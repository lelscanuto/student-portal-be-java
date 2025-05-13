package com.mist.studentportal.iamservice.role.application.internal;

import com.mist.studentportal.iamservice.permission.domain.entities.Permission;
import java.util.Set;

public interface RolePermissionService {
  Set<Permission> findPermissionByIds(Set<Long> permissionIds);
}
