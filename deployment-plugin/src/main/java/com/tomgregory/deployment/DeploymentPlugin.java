package com.tomgregory.deployment;

import org.gradle.api.Plugin;
import org.gradle.api.Project;

public class DeploymentPlugin implements Plugin<Project> {
    private static final String TASK_GROUP = "Deployment";

    @Override
    public void apply(Project project) {
        DeploymentPluginExtension extension = project.getExtensions().create("deployment", DeploymentPluginExtension.class);

        project.getTasks().register("deployQA", DeploymentTask.class, task -> {
            task.setGroup(TASK_GROUP);
            task.setDescription("Spurts your app into QA!");
            task.getDeployableName().set(project.getName());
            task.getDestinationEnvironment().set("qa");
            task.getReplicas().set(extension.getQA().getReplicas());
        });

        project.getTasks().register("deployProd", DeploymentTask.class, task -> {
            task.setGroup(TASK_GROUP);
            task.setDescription("Spurts your app into prod!");
            task.getDeployableName().set(project.getName());
            task.getDestinationEnvironment().set("qa");
            task.getReplicas().set(extension.getProd().getReplicas());
        });
    }
}
