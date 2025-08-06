package com.school.portal.iamservice.permission.application.services.impl;

import com.school.portal.iamservice.permission.application.dto.CreatePermissionDTO;
import com.school.portal.iamservice.permission.application.dto.PermissionDetailDTO;
import com.school.portal.iamservice.permission.application.mappers.PermissionMapper;
import com.school.portal.iamservice.permission.application.services.PermissionManagementService;
import com.school.portal.iamservice.permission.domain.repositories.PermissionRepository;
import com.school.portal.iamservice.permission.exceptions.PermissionAlreadyExistsException;
import com.school.portal.iamservice.permission.exceptions.PermissionDoesNotExistsException;
import jakarta.annotation.Nonnull;
import java.util.concurrent.CompletableFuture;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(propagation = Propagation.REQUIRES_NEW)
public class PermissionManagementServiceImpl implements PermissionManagementService {

  private final PermissionMapper permissionMapper;
  private final PermissionRepository permissionRepository;

  public PermissionManagementServiceImpl(
      PermissionMapper permissionMapper, PermissionRepository permissionRepository) {
    this.permissionMapper = permissionMapper;
    this.permissionRepository = permissionRepository;
  }

  @Override
  @Async
  public CompletableFuture<PermissionDetailDTO> create(
      @Nonnull final CreatePermissionDTO createPermissionDTO) {

    // Assert If Permission Already Exists
    if (permissionRepository.existsByName(createPermissionDTO.name())) {
      throw new PermissionAlreadyExistsException(createPermissionDTO.name());
    }

    // Create Permission Entity
    final var newPermission = permissionMapper.toEntity(createPermissionDTO);

    // Save New Permission
    permissionRepository.save(newPermission);

    return CompletableFuture.completedFuture(permissionMapper.toPermissionDetailDTO(newPermission));
  }

  @Override
  @Async
  public CompletableFuture<PermissionDetailDTO> delete(@Nonnull Long permissionId) {
    return permissionRepository
        .findById(permissionId)
        .map(
            existingPermission -> {
              permissionRepository.delete(existingPermission);

              return CompletableFuture.completedFuture(
                  permissionMapper.toPermissionDetailDTO(existingPermission));
            })
        .orElseThrow(() -> new PermissionDoesNotExistsException(permissionId));
  }
}
