package ar.edu.unlam.mobile.scaffolding.domain.androids

import ar.edu.unlam.mobile.scaffolding.domain.engine.Car
import ar.edu.unlam.mobile.scaffolding.domain.engine.Engine
import ar.edu.unlam.mobile.scaffolding.domain.engine.GasolineEngine

interface Engine {
    fun start()
}

class GasolineEngine : Engine {
    override fun start() {
        println("Starting gasoline engine")
    }
}

class BadCar {
    private val engine = GasolineEngine()

    fun start() {
        engine.start()
    }
}

class Car constructor(private val engine: Engine) {
    fun start() {
        engine.start()
    }
}

fun main() {
    val engine = GasolineEngine()
    val car = Car(engine)
    car.start()
}
