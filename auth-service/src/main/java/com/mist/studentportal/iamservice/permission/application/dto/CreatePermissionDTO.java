package com.mist.studentportal.iamservice.permission.application.dto;

import jakarta.validation.constraints.NotEmpty;

public record CreatePermissionDTO(@NotEmpty String name, @NotEmpty String description) {}
