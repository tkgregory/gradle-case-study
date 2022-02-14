plugins {
    id("java-gradle-plugin")
}

group = "com.tomgregory"
version = "0.1.0-SNAPSHOT"

gradlePlugin {
    plugins {
        create("deployment") {
            id = "com.tomgregory.deployment"
            implementationClass = "com.tomgregory.deployment.DeploymentPlugin"
        }
    }
}