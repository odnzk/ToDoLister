package com.odnzk.study.model;

public enum Priority {

    HIGH("high"), MEDIUM("medium"), LOW("low");

    private final String key;

    Priority(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }
}
