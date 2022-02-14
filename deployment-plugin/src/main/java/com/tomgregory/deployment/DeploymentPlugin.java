package com.tomgregory.deployment;

import org.gradle.api.Plugin;
import org.gradle.api.Project;

public class DeploymentPlugin implements Plugin<Project> {
    @Override
    public void apply(Project project) {
        DeploymentPluginExtension extension = project.getExtensions().create("deployment", DeploymentPluginExtension.class);

        project.getTasks().register("deploy", DeploymentTask.class, task -> {
            task.setGroup("Deployment");
            task.setDescription("Spurts your app where it needs to go!");
            task.getDeployableName().set(project.getName());
            task.getDestinationEnvironment().set(extension.getDestinationEnvironment());
        });
    }
}
