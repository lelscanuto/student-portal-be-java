package com.school.portal.iamservice.role.domain.services;

import com.school.portal.iamservice.permission.domain.entities.Permission;
import com.school.portal.iamservice.role.domain.entities.Role;
import java.util.Set;

public interface RoleDomainService {

  void addPermission(Role existingRole, Set<Permission> existingPermissions);

  void removePermission(Role existingRole, Set<Permission> existingPermissions);
}
