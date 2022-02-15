## Overview

Custom plugins are a great way to share common build logic between multiple projects. This is especially useful in a microservice environment.

This repository is a reproduction of a deployment technique I encountered at Sky in 2015-2017. 

## Repository layout

This repository comprises 3 separate Gradle projects:

1. a custom *deployment-plugin* project
2. a *microservice-a* project, which applies the plugin
3. a *microservice-b* project, which applies the plugin

## How the plugin works

The plugin creates one deployment task per target environment with configurable properties for each task. 

For example, the plugin has `deployQA` and `deployProd` tasks. You can easily add or remove tasks depending on your own environments.

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
Of course you can also add whatever other properties you need by updating *[Environment.java](deployment-plugin/src/main/java/com/tomgregory/deployment/Environment)*.

Right now the actual deployment consists of just printing a string. 
> Deploying 3 replica(s) of microservice-a to Prod!

You can hook in any deployment mechanism such as Kubernetes, AWS ECS, etc. 