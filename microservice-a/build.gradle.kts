plugins {
    java
    id("com.tomgregory.deployment")
}

deployment {
    qa {
        replicas.set(2)
    }
    prod {
        replicas.set(3)
    }
}