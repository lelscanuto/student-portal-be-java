package com.mist.studentportal.iamservice.role.domain.services;

import com.mist.studentportal.iamservice.permission.domain.entities.Permission;
import com.mist.studentportal.iamservice.role.domain.entities.Role;
import java.util.Set;

public interface RoleDomainService {

  void addPermission(Role existingRole, Set<Permission> existingPermissions);

  void removePermission(Role existingRole, Set<Permission> existingPermissions);
}
