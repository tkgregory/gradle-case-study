package com.tomgregory.deployment;

import org.gradle.api.provider.Property;

public abstract class DeploymentPluginExtension {
    abstract public Property<String> getDestinationEnvironment();
}
