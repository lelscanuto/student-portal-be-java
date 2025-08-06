package com.school.portal.iamservice.permission.application.dto;

import jakarta.validation.constraints.NotEmpty;

public record CreatePermissionDTO(@NotEmpty String name, @NotEmpty String description) {}
