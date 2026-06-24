# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Project

Android single-module app (`:app`, project name `ScaffoldingV2`) used as a teaching reference for organizing an Android project with hexagonal / clean architecture. Root package: `ar.edu.unlam.mobile.scaffolding`. The README is in Spanish and documents the intended architecture in depth.

## Commands

On Windows use `.\gradlew.bat`; on macOS/Linux use `./gradlew`.

- Build debug APK: `./gradlew assembleDebug`
- Unit tests: `./gradlew testDebugUnitTest`
- Single unit test: `./gradlew testDebugUnitTest --tests "ar.edu.unlam.mobile.scaffolding.ExampleUnitTest"` (append `.methodName` for one method)
- Instrumented tests (needs device/emulator): `./gradlew connectedDebugAndroidTest`
- ktlint check: `./gradlew ktlintCheck` — auto-fix: `./gradlew ktlintFormat`
- Android lint: `./gradlew lint`
- Coverage report (kover): `./gradlew koverXmlReportRelease` (HTML: `koverHtmlReportDebug`)

CI on PRs runs ktlint + `./gradlew lint` (PRs to `main`/`develop`/`releases/**`) and `./gradlew koverXmlReportRelease` (all PRs).

## Architecture

Three layers, each a top-level package under the root package. Dependencies point inward toward the domain — `ui` and `data` depend on domain models, never the reverse.

- **`domain/`** — pure business logic. Models, use cases/services, and DI definitions per business domain. Domain models must be free of framework annotations (no Hilt, Room, or Retrofit/Gson annotations, no ViewModel/LiveData).
- **`data/`** — adapters to the outside world, organized per domain.
  - `data/network/` — Retrofit interface (`ArtInstituteAPI`, targets the Art Institute of Chicago API), Gson DTOs using `@SerializedName`, and `toDomainModel()` extension functions that map DTOs → domain models.
  - `data/repository/` — repository interface (the port, expressed in domain terms), its `*DefaultRepository` implementation, and `models/` for the domain models.
- **`ui/`** — Jetpack Compose. Follows the container/component paradigm:
  - `ui/screens/<feature>/` — a Screen container composable plus its ViewModel. Screens orchestrate components and obtain their ViewModel via `hiltViewModel()`.
  - `ui/components/` — reusable, stateless composables that receive state and render it.
  - ViewModels expose a single `StateFlow<...UIState>`; each section of UI state is a sealed interface with `Loading` / `Success` / `Error` variants (see `HomeViewModel`).

### Navigation & app shell
Single-Activity app. `MainActivity` (`@AndroidEntryPoint`) hosts the `Scaffold` + `NavHost` in `MainScreen()`. Navigation uses Compose Navigation with **string routes** (`composable("home") { ... }`, `controller.navigate("home")`); route arguments are declared with `navArgument`. Add new screens as `composable(route)` entries in the `NavHost`.

### Dependency injection (Hilt)
`ScaffoldingApplication` is `@HiltAndroidApp`; `MainActivity` is `@AndroidEntryPoint`; ViewModels are `@HiltViewModel` with `@Inject constructor`. Hilt runs via **KSP** (`ksp(...)` in `app/build.gradle.kts`), not kapt. Interfaces such as `ArtworkRepository` require a Hilt `@Module` (`@Binds`/`@Provides`) to be provided — without one, the build fails at `hiltJavaCompileDebug` with `MissingBinding`. Retrofit/`ArtInstituteAPI` also needs a provider module. Place DI modules in a `di` package within `domain` or `data` per the README.

## Build configuration & version constraints

- Versions are centralized in `gradle/libs.versions.toml`; both `build.gradle.kts` files reference them via `libs.*`. JVM target is 17.
- Uses **AGP 9 built-in Kotlin** — there is intentionally no `org.jetbrains.kotlin.android` plugin. The Kotlin DSL lives inside the `android {}` block (`android { kotlin { compilerOptions { jvmTarget = ... } } }`), and the Kotlin compiler version is overridden above AGP's built-in default via a `classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:<kotlin>")` entry in the root `buildscript` block.
- Three-way Kotlin version ceiling to be aware of when bumping versions: AGP's built-in Kotlin (older), Coil (needs newer stdlib metadata), and Hilt/Dagger (its bundled `kotlin-metadata-jvm` caps the readable metadata version). A mismatch fails `compileDebugKotlin` or `hiltJavaCompileDebug` with metadata-version errors.
- **Version-priority policy:** the Kotlin version is driven by what AGP supports, not by what libraries want. Pick the latest Kotlin compatible with the current AGP, then bring every other dependency in line with that Kotlin. If a library only ships a version requiring a newer Kotlin than AGP supports, **downgrade that library** to an older version compatible with the chosen Kotlin — do not raise Kotlin past the AGP-supported version. Example: if library X only supports Kotlin 2.4.0 but AGP supports 2.3.x, use an older X that works with 2.3.x. (Current state: AGP 9.2.0 → Kotlin 2.3.21. Coil is pinned to **3.4.0**, not 3.5.0, because 3.5.0 forces `kotlin-stdlib:2.4.0` whose metadata Hilt's reader rejects; 3.4.0 uses `kotlin-stdlib:2.3.10`.)

## Code style (ktlint)

ktlint is the active formatter, customized via `.editorconfig`: wildcard imports are allowed, the filename rule is disabled, and function-naming is disabled / ignored for `@Composable` functions (so composables use PascalCase). `kotlin.code.style=official`. Run `ktlintFormat` before committing.
