package com.tomgregory.deployment;

public abstract class Environment {
    private int replicas;

    public void replicas(int replicas) {
        this.replicas = replicas;
    }

    public int getReplicas() {
        return replicas;
    }
}