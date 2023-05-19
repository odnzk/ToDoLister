package com.odnzk.study.model;

import java.util.Set;

public record User(Integer id, String username, String email, String password, Set<Integer> projectIds) {
}
