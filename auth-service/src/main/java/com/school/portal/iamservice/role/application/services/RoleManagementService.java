package com.school.portal.iamservice.role.application.services;

import com.school.portal.iamservice.role.application.dto.CreateRoleDTO;
import com.school.portal.iamservice.role.application.dto.RoleDetailDTO;
import jakarta.annotation.Nonnull;
import java.util.concurrent.CompletableFuture;

public interface RoleManagementService {

  CompletableFuture<RoleDetailDTO> create(@Nonnull CreateRoleDTO createRoleDTO);

  CompletableFuture<RoleDetailDTO> delete(@Nonnull Long roleId);
}
