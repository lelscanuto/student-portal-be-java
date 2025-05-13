package com.mist.studentportal.iamservice.role.application.dto;

import com.mist.studentportal.iamservice.permission.application.dto.PermissionDetailDTO;
import java.util.Set;

public record RoleDetailDTO(Long id, String name, Set<PermissionDetailDTO> permissions) {}
