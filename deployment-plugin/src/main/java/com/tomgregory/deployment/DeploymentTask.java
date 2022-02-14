package com.tomgregory.deployment;

import org.gradle.api.DefaultTask;
import org.gradle.api.provider.Property;
import org.gradle.api.tasks.Input;
import org.gradle.api.tasks.TaskAction;

public abstract class DeploymentTask extends DefaultTask {
    @Input
    public abstract Property<String> getDeployableName();
    @Input
    public abstract Property<String> getDestinationEnvironment();

    @TaskAction
    public void deploy() {
        System.out.printf("3...2...1...deploying %s to %s!", getDeployableName().get(), getDestinationEnvironment().get());
    }
}
