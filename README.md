[![CI](https://github.com/tkgregory/gradle-case-study/actions/workflows/gradle.yml/badge.svg)](https://github.com/tkgregory/gradle-case-study/actions/workflows/gradle.yml)

## Overview

Custom plugins are a great way to share common build logic between multiple projects. This is especially useful in a microservice environment.

This repository is a reproduction of a deployment technique I encountered at Sky in 2015-2017. 

## Repository layout

This repository comprises 3 separate Gradle projects:

1. a custom *deployment-plugin* project
2. a *microservice-a* project, which applies the plugin
3. a *microservice-b* project, which applies the plugin

## How the plugin works

The plugin creates one deployment task per target environment, with configurable properties for each task. 

* `deployQA`
* `deployProd`

You can easily add or remove tasks based on your own environments, by updating *[DeploymentPlugin.java](deployment-plugin/src/main/java/com/tomgregory/deployment/DeploymentPlugin.java)* and *[Environment.java](deployment-plugin/src/main/java/com/tomgregory/deployment/Environment.java)*

The number of replicas to deploy is by default 1, but can be configured as you'll see in *[microservice-a/build.gradle.kts](microservice-a/build.gradle.kts)*:

```kotlin
deployment {
    qa {
        replicas.set(2)
    }
    prod {
        replicas.set(3)
    }
}
```
Of course you can also add whatever other properties you need by updating *[Environment.java](deployment-plugin/src/main/java/com/tomgregory/deployment/Environment.java)*.

## Running

Within *microservice-a* if you run: 

`./gradlew deployProd` 

You'll see the actual deployment consists of just printing a string. 
> Deploying 3 replica(s) of microservice-a to Prod!

You can hook in any deployment mechanism such as Kubernetes, AWS ECS, etc. 

## Need Gradle support?
Contact me if you need help with Gradle at [tom@tomgregory.com](mailto:tom@tomgregory.com).
