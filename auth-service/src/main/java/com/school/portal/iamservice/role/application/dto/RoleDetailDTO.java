package com.school.portal.iamservice.role.application.dto;

import com.school.portal.iamservice.permission.application.dto.PermissionDetailDTO;
import java.util.Set;

public record RoleDetailDTO(Long id, String name, Set<PermissionDetailDTO> permissions) {}
