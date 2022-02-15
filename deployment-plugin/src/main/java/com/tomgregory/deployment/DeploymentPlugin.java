package com.tomgregory.deployment;

import org.gradle.api.Plugin;
import org.gradle.api.Project;

public class DeploymentPlugin implements Plugin<Project> {
    private static final String TASK_GROUP = "Deployment";

    @Override
    public void apply(Project project) {
        DeploymentPluginExtension extension = project.getExtensions().create("deployment", DeploymentPluginExtension.class);

        registerTaskForEnvironment(project, "QA", extension.getQA());
        registerTaskForEnvironment(project, "Prod", extension.getProd());
    }

    private void registerTaskForEnvironment(Project project, String environmentName, Environment environmentConfig) {
        project.getTasks().register(String.format("deploy%s", environmentName), DeploymentTask.class, task -> {
            task.setGroup(TASK_GROUP);
            task.setDescription(String.format("Spurts your app into %s!", environmentName));
            task.getDeployableName().set(project.getName());
            task.getDestinationEnvironment().set(environmentName);
            task.getReplicas().set(environmentConfig.getReplicas().get());
        });
    }
}
