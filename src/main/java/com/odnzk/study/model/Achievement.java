package com.odnzk.study.model;

public enum Achievement {

    PROJECT_CREATED(1),
    PROJECT_COMPLETED(2),
    TASK_CREATED(3),
    TASK_COMPLETED(4),
    CHANGE_PROFILE_DATA(5),
    SIGN_UP(6);

    private final Integer id;

    Achievement(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }
}
