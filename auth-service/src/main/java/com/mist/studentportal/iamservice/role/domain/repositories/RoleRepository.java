package com.mist.studentportal.iamservice.role.domain.repositories;

import com.mist.studentportal.iamservice.role.domain.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
  boolean existsByName(String name);
}
