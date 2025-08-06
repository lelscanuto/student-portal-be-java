package com.school.portal.iamservice.permission.domain.repositories;

import com.school.portal.iamservice.permission.domain.entities.Permission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface PermissionRepository extends JpaRepository<Permission, Long> {
  boolean existsByName(String name);

  Set<Permission> findByIds(Set<Long> permissionIds);
}
