plugins {
    application
    id("com.tomgregory.deployment")
}

application {
    mainClass.set("com.tomgregory.microserviceb.MicroserviceB")
}

deployment {
    prod {
        replicas.set(10)
    }
}