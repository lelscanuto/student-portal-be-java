package com.mist.studentportal.iamservice.permission.application.services;

import com.mist.studentportal.iamservice.permission.application.dto.CreatePermissionDTO;
import com.mist.studentportal.iamservice.permission.application.dto.PermissionDetailDTO;
import java.util.concurrent.CompletableFuture;

public interface PermissionManagementService {

  CompletableFuture<PermissionDetailDTO> create(CreatePermissionDTO createPermissionDTO);

  CompletableFuture<PermissionDetailDTO> delete(Long permissionId);
}
