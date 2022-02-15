package com.tomgregory.deployment;

import org.gradle.api.DefaultTask;
import org.gradle.api.provider.Property;
import org.gradle.api.tasks.Input;
import org.gradle.api.tasks.TaskAction;

import static java.lang.String.format;

public abstract class DeploymentTask extends DefaultTask {
    @Input
    public abstract Property<String> getDeployableName();

    @Input
    public abstract Property<String> getDestinationEnvironment();

    @Input
    public abstract Property<Integer> getReplicas();

    @TaskAction
    public void deploy() {
        System.out.println(format("Deploying %s replica(s) of %s to %s!",
                getReplicas().get(), getDeployableName().get(), getDestinationEnvironment().get()));
    }
}