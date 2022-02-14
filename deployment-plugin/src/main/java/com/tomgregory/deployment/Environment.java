package com.tomgregory.deployment;

import org.gradle.api.model.ObjectFactory;
import org.gradle.api.provider.Property;

import javax.inject.Inject;

public abstract class Environment {
    private final Property<Integer> replicas;

    @Inject
    public Environment(ObjectFactory objectFactory) {
        replicas = objectFactory.property(Integer.class).convention(1);
    }

    public Property<Integer> getReplicas() {
        return replicas;
    }
}