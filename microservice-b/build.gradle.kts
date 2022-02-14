plugins {
    application
    id("com.tomgregory.deployment")
}

application {
    mainClass.set("com.tomgregory.microserviceb.MicroserviceB")
}

deployment {
    qa {
//        replicas.set(2)
    }
    prod {
        replicas.set(10)
    }
}