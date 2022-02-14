package com.tomgregory.deployment;

import org.gradle.api.Action;
import org.gradle.api.model.ObjectFactory;

import javax.inject.Inject;

public class DeploymentPluginExtension {
    private final Environment qa;
    private final Environment prod;

    @Inject
    public DeploymentPluginExtension(ObjectFactory objectFactory) {
        this.qa = objectFactory.newInstance(Environment.class);
        this.prod = objectFactory.newInstance(Environment.class);
    }

    public void qa(Action<Environment> action) {
        action.execute(qa);
    }

    public Environment getQA() {
        return qa;
    }

    public void prod(Action<Environment> action) {
        action.execute(prod);
    }

    public Environment getProd() {
        return prod;
    }
}