plugins {
    java
    id("com.tomgregory.deployment")
}

deployment {
    destinationEnvironment.set("qa")
}