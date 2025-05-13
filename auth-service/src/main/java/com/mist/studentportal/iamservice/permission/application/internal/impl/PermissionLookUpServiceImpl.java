package com.mist.studentportal.iamservice.permission.application.internal.impl;

import com.mist.studentportal.iamservice.permission.application.internal.PermissionLookUpService;
import com.mist.studentportal.iamservice.permission.domain.entities.Permission;
import com.mist.studentportal.iamservice.permission.domain.repositories.PermissionRepository;
import com.mist.studentportal.iamservice.permission.exceptions.PermissionDoesNotExistsException;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(propagation = Propagation.MANDATORY)
public class PermissionLookUpServiceImpl implements PermissionLookUpService {

  private final PermissionRepository permissionRepository;

  public PermissionLookUpServiceImpl(PermissionRepository permissionRepository) {
    this.permissionRepository = permissionRepository;
  }

  @Override
  public Set<Permission> findByIds(Set<Long> permissionIds) {

    final var existingPermissions = permissionRepository.findByIds(permissionIds);

    // Extract found IDs
    Set<Long> foundIds =
        existingPermissions.stream().map(Permission::getId).collect(Collectors.toSet());

    // Find missing IDs
    Set<Long> missingIds = new HashSet<>(permissionIds);
    missingIds.removeAll(foundIds);

    if (!missingIds.isEmpty()) {
      throw new PermissionDoesNotExistsException(missingIds);
    }

    return existingPermissions;
  }
}
