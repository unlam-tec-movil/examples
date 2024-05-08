package ar.edu.unlam.mobile.scaffolding.domain.engine

import ar.edu.unlam.mobile.scaffolding.domain.androids.Engine
import javax.inject.Inject

interface Engine {
    fun start()
}

interface Maintainable {
    fun maintain()
}

open class GasolineEngine
    @Inject
    constructor() : Engine, Maintainable {
        override fun start() {
            println("Starting gasoline engine")
        }

        override fun maintain() {
            TODO("Not yet implemented")
        }
    }

class Car
    @Inject
    constructor(private val engine: Engine) {
        fun start() {
            engine.start()
        }
    }

class AutoHorrible : GasolineEngine() {
    fun arrancar() {
        super.start()
    }
}
