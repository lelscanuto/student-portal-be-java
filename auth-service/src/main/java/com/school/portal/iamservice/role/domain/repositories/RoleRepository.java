package com.school.portal.iamservice.role.domain.repositories;

import com.school.portal.iamservice.role.domain.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
  boolean existsByName(String name);
}
