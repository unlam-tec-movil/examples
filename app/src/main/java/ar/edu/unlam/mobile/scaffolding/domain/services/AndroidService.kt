package ar.edu.unlam.mobile.scaffolding.domain.services

import ar.edu.unlam.mobile.scaffolding.domain.models.RealAndroid
import ar.edu.unlam.mobile.scaffolding.domain.usecases.GetAndroids
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

val androidsList =
    listOf(
        RealAndroid(
            name = "2b",
            id = 1u,
            description =
                "YoRHa No. 2 Type B, commonly known as 2B, is a fictional android from the 2017 video game Nier:" +
                    " Automata, a spin-off of the Drakengard series developed by PlatinumGames and published by" +
                    " Square Enix.",
            picture =
                "https://i.kym-cdn.com/entries/icons/original/000/036/666/cover10.jpg",
        ),
        RealAndroid(
            name = "c18",
            id = 2u,
            description = "Android 2",
            picture = "https://www.mundodeportivo.com/alfabeta/hero/2023/09/c18_dragon_ball.png",
        ),
        RealAndroid(
            name = "Android 3",
            id = 3u,
            description = "Android 3",
            picture = "https://manga-imperial.fr/cdn/shop/articles/android171_2_1_520x500_d43619ac-4db6-4049-b479-17c562ab380d_375x.jpg",
        ),
    )

class AndroidService
    @Inject
    constructor() : GetAndroids {
        override suspend fun getAndroids(): Flow<List<RealAndroid>> {
            return flow {
                emit(
                    androidsList,
                )
            }
        }

        override suspend fun getAndroid(id: UInt): Flow<RealAndroid> {
            return flow {
                delay(2000)
                var res: RealAndroid? = null
                androidsList.forEach {
                    if (it.id == id) {
                        res = it
                    }
                }
                if (res == null) {
                    throw Error("Not found")
                } else {
                    emit(res!!)
                }
            }
        }
    }
