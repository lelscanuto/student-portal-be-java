package com.school.portal.iamservice.department.domain.repositories;

import com.school.portal.iamservice.department.domain.entities.Department;
import jakarta.validation.constraints.NotNull;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository
    extends JpaRepository<Department, Long>, JpaSpecificationExecutor<Department> {

  Optional<Department> findByCode(@NotNull String code);

  boolean existsByCode(@NotNull String code);
}
