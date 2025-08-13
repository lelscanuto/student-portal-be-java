package com.school.portal.iamservice.department.application.use_cases;

import com.school.portal.iamservice.department.application.dto.CreateDepartmentDTO;
import com.school.portal.iamservice.department.application.dto.DepartmentLiteDTO;
import jakarta.annotation.Nonnull;

public interface DepartmentCreationUseCase {
  DepartmentLiteDTO create(@Nonnull CreateDepartmentDTO createDepartmentDTO);
}
