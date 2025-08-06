package com.school.portal.iamservice.permission.application.internal;

import com.school.portal.iamservice.permission.domain.entities.Permission;
import java.util.Set;

public interface PermissionLookUpService {
  Set<Permission> findByIds(Set<Long> permissionIds);
}
