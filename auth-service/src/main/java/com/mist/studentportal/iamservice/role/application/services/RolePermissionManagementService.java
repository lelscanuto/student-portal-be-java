package com.mist.studentportal.iamservice.role.application.services;

import com.mist.studentportal.iamservice.role.application.dto.RoleDetailDTO;
import com.mist.studentportal.iamservice.role.application.dto.RolePermissionDTO;
import jakarta.annotation.Nonnull;

import java.util.concurrent.CompletableFuture;

public interface RolePermissionManagementService {

  CompletableFuture<RoleDetailDTO> addPermission(
      @Nonnull Long roleId, @Nonnull RolePermissionDTO createRoleDTO);

  CompletableFuture<RoleDetailDTO> removePermission(
      @Nonnull Long roleId, @Nonnull RolePermissionDTO createRoleDTO);
}
