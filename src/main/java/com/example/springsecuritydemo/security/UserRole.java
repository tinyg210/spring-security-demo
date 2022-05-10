package com.example.springsecuritydemo.security;

import static com.example.springsecuritydemo.security.UserPermission.COURSE_READ;
import static com.example.springsecuritydemo.security.UserPermission.COURSE_WRITE;
import static com.example.springsecuritydemo.security.UserPermission.STUDENT_READ;
import static com.example.springsecuritydemo.security.UserPermission.STUDENT_WRITE;

import com.google.common.collect.Sets;
import java.util.Set;

public enum UserRole {

  STUDENT(Sets.newHashSet(COURSE_READ, STUDENT_READ, STUDENT_WRITE)),
  ADMIN(Sets.newHashSet(COURSE_READ, STUDENT_READ, STUDENT_WRITE, COURSE_WRITE));

  private final Set<UserPermission> permissions;

  UserRole(Set<UserPermission> permissions) {
    this.permissions = permissions;
  }
}
