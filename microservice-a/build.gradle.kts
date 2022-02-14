plugins {
    application
    id("com.tomgregory.deployment")
}

application {
    mainClass.set("com.tomgregory.microservicea.MicroserviceA")
}

deployment {
    qa {
        replicas.set(2)
    }
    prod {
        replicas.set(3)
    }
}