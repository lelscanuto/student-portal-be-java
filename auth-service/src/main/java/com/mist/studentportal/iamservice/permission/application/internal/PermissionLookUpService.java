package com.mist.studentportal.iamservice.permission.application.internal;

import com.mist.studentportal.iamservice.permission.domain.entities.Permission;
import java.util.Set;

public interface PermissionLookUpService {
    Set<Permission> findByIds(Set<Long> permissionIds);
}
