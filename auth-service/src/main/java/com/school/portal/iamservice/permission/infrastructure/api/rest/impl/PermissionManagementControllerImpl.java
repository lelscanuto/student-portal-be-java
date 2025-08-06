package com.school.portal.iamservice.permission.infrastructure.api.rest.impl;

import com.school.portal.iamservice.permission.application.dto.CreatePermissionDTO;
import com.school.portal.iamservice.permission.application.dto.PermissionDetailDTO;
import com.school.portal.iamservice.permission.application.services.PermissionManagementService;
import com.school.portal.iamservice.permission.infrastructure.api.rest.PermissionManagementController;
import java.util.concurrent.CompletableFuture;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/permissions")
public class PermissionManagementControllerImpl implements PermissionManagementController {

  private final PermissionManagementService permissionManagementService;

  public PermissionManagementControllerImpl(
      PermissionManagementService permissionManagementService) {
    this.permissionManagementService = permissionManagementService;
  }

  @Override
  @ResponseStatus(HttpStatus.CREATED)
  @PostMapping
  public CompletableFuture<PermissionDetailDTO> create(
      @RequestBody CreatePermissionDTO createPermissionDTO) {
    return permissionManagementService.create(createPermissionDTO);
  }

  @Override
  @ResponseStatus(HttpStatus.OK)
  @DeleteMapping("/{id}")
  public CompletableFuture<PermissionDetailDTO> delete(@PathVariable("id") Long permissionId) {
    return permissionManagementService.delete(permissionId);
  }
}
