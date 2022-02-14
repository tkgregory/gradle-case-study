plugins {
    java
    id("com.tomgregory.deployment")
}

deployment {
    qa {
        replicas = 2
    }
    prod {
        replicas = 3
    }
}