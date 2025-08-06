package com.school.portal.iamservice.role.application.services.impl;

import com.school.portal.iamservice.role.application.dto.RoleDetailDTO;
import com.school.portal.iamservice.role.application.dto.RolePermissionDTO;
import com.school.portal.iamservice.role.application.internal.RolePermissionService;
import com.school.portal.iamservice.role.application.mappers.RoleMapper;
import com.school.portal.iamservice.role.application.services.RolePermissionManagementService;
import com.school.portal.iamservice.role.domain.repositories.RoleRepository;
import com.school.portal.iamservice.role.domain.services.RoleDomainService;
import com.school.portal.iamservice.role.exceptions.RoleDoesNotExistsException;
import jakarta.annotation.Nonnull;
import java.util.concurrent.CompletableFuture;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(propagation = Propagation.REQUIRES_NEW)
public class RolePermissionManagementServiceImpl implements RolePermissionManagementService {

  private final RolePermissionService rolePermissionService;
  private final RoleDomainService roleDomainService;
  private final RoleMapper roleMapper;
  private final RoleRepository roleRepository;

  public RolePermissionManagementServiceImpl(
      RolePermissionService rolePermissionService,
      RoleDomainService roleDomainService,
      RoleMapper roleMapper,
      RoleRepository roleRepository) {
    this.rolePermissionService = rolePermissionService;
    this.roleDomainService = roleDomainService;
    this.roleMapper = roleMapper;
    this.roleRepository = roleRepository;
  }

  @Override
  public CompletableFuture<RoleDetailDTO> addPermission(
      @Nonnull Long roleId, @Nonnull final RolePermissionDTO createRoleDTO) {

    // Find Existing Role
    final var existingRole =
        roleRepository.findById(roleId).orElseThrow(() -> new RoleDoesNotExistsException(roleId));

    // Find Existing Permission
    final var existingPermissions =
        rolePermissionService.findPermissionByIds(createRoleDTO.permissionIds());

    // Add Permission to the Role
    roleDomainService.addPermission(existingRole, existingPermissions);

    // Save new state of the Existing Role
    roleRepository.save(existingRole);

    return CompletableFuture.completedFuture(roleMapper.toRoleDetailDTO(existingRole));
  }

  @Override
  public CompletableFuture<RoleDetailDTO> removePermission(
      @Nonnull Long roleId, @Nonnull final RolePermissionDTO createRoleDTO) {

    // Find Existing Role
    final var existingRole =
        roleRepository.findById(roleId).orElseThrow(() -> new RoleDoesNotExistsException(roleId));

    // Find Existing Permission
    final var existingPermissions =
        rolePermissionService.findPermissionByIds(createRoleDTO.permissionIds());

    // Add Permission to the Role
    roleDomainService.removePermission(existingRole, existingPermissions);

    // Save new state of the Existing Role
    roleRepository.save(existingRole);

    return CompletableFuture.completedFuture(roleMapper.toRoleDetailDTO(existingRole));
  }
}
