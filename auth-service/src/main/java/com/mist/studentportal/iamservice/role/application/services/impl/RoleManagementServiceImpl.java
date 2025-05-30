package com.mist.studentportal.iamservice.role.application.services.impl;

import com.mist.studentportal.iamservice.role.application.dto.CreateRoleDTO;
import com.mist.studentportal.iamservice.role.application.dto.RoleDetailDTO;
import com.mist.studentportal.iamservice.role.application.internal.RolePermissionService;
import com.mist.studentportal.iamservice.role.application.mappers.RoleMapper;
import com.mist.studentportal.iamservice.role.application.services.RoleManagementService;
import com.mist.studentportal.iamservice.role.domain.repositories.RoleRepository;
import com.mist.studentportal.iamservice.role.exceptions.RoleAlreadyExistsException;
import com.mist.studentportal.iamservice.role.exceptions.RoleDoesNotExistsException;
import jakarta.annotation.Nonnull;
import jakarta.transaction.Transactional;
import java.util.concurrent.CompletableFuture;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class RoleManagementServiceImpl implements RoleManagementService {

  private final RolePermissionService rolePermissionService;
  private final RoleMapper roleMapper;
  private final RoleRepository roleRepository;

  public RoleManagementServiceImpl(
      com.mist.studentportal.iamservice.role.application.internal.RolePermissionService
          rolePermissionService,
      RoleMapper roleMapper,
      RoleRepository roleRepository) {
    this.rolePermissionService = rolePermissionService;
    this.roleMapper = roleMapper;
    this.roleRepository = roleRepository;
  }

  @Override
  @Async
  public CompletableFuture<RoleDetailDTO> create(@Nonnull final CreateRoleDTO createRoleDTO) {

    if (roleRepository.existsByName(createRoleDTO.name())) {
      throw new RoleAlreadyExistsException(createRoleDTO.name());
    }

    var permissions = rolePermissionService.findPermissionByIds(createRoleDTO.permissionIds());

    final var newRole = roleMapper.toEntity(createRoleDTO, permissions);

    roleRepository.save(newRole);

    return CompletableFuture.completedFuture(roleMapper.toRoleDetailDTO(newRole));
  }

  @Override
  @Async
  public CompletableFuture<RoleDetailDTO> delete(@Nonnull Long roleId) {
    return roleRepository
        .findById(roleId)
        .map(
            existingRole -> {

              // Delete Role
              roleRepository.delete(existingRole);

              return CompletableFuture.completedFuture(roleMapper.toRoleDetailDTO(existingRole));
            })
        .orElseThrow(() -> new RoleDoesNotExistsException(roleId));
  }
}
