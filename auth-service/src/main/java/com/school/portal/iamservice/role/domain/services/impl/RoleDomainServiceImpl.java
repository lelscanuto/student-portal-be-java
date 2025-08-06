package com.school.portal.iamservice.role.domain.services.impl;

import com.school.portal.iamservice.permission.domain.entities.Permission;
import com.school.portal.iamservice.role.domain.entities.Role;
import com.school.portal.iamservice.role.domain.services.RoleDomainService;
import com.school.portal.iamservice.role.exceptions.RolePermissionAlreadyExistsException;
import java.util.Set;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

@Service
@Transactional(propagation = Propagation.MANDATORY)
public class RoleDomainServiceImpl implements RoleDomainService {

  @Override
  public void addPermission(Role existingRole, Set<Permission> permission) {

    var duplicatePermissionId =
        permission.stream()
            .filter(existingRole::isPermissionDoesExists)
            .map(Permission::getId)
            .collect(Collectors.toSet());

    if (!CollectionUtils.isEmpty(duplicatePermissionId)) {
      throw new RolePermissionAlreadyExistsException(duplicatePermissionId);
    }

    existingRole.addPermission(permission);
  }

  @Override
  public void removePermission(Role existingRole, Set<Permission> permissions) {

    var notExistPermission =
        permissions.stream()
            .filter(permission -> !existingRole.isPermissionDoesExists(permission))
            .map(Permission::getId)
            .collect(Collectors.toSet());

    if (!CollectionUtils.isEmpty(notExistPermission)) {
      throw new RolePermissionAlreadyExistsException(notExistPermission);
    }

    existingRole.removePermission(permissions);
  }
}
