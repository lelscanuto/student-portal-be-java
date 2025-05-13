package com.mist.studentportal.iamservice.role.application.internal.impl;

import com.mist.studentportal.iamservice.permission.application.internal.PermissionLookUpService;
import com.mist.studentportal.iamservice.permission.domain.entities.Permission;
import com.mist.studentportal.iamservice.role.application.internal.RolePermissionService;
import java.util.Set;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(propagation = Propagation.MANDATORY)
public class RolePermissionServiceImpl implements RolePermissionService {

  private final PermissionLookUpService permissionLookUpService;

  public RolePermissionServiceImpl(PermissionLookUpService permissionLookUpService) {
    this.permissionLookUpService = permissionLookUpService;
  }

  @Override
  public Set<Permission> findPermissionByIds(Set<Long> permissionIds) {
    return permissionLookUpService.findByIds(permissionIds);
  }
}
