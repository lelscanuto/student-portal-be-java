package com.school.portal.iamservice.role.application.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotEmpty;
import java.util.Set;

public record CreateRoleDTO(
    @NotEmpty String name, @Max(255) String description, @NotEmpty Set<Long> permissionIds) {}
