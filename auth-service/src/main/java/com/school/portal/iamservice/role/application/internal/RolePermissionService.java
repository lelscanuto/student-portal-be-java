package com.school.portal.iamservice.role.application.internal;

import com.school.portal.iamservice.permission.domain.entities.Permission;
import java.util.Set;

public interface RolePermissionService {
  Set<Permission> findPermissionByIds(Set<Long> permissionIds);
}
