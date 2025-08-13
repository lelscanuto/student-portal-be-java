package com.school.portal.iamservice.department.application.facade.impl;

import com.school.portal.iamservice.department.application.dto.CreateDepartmentDTO;
import com.school.portal.iamservice.department.application.dto.DepartmentLiteDTO;
import com.school.portal.iamservice.department.application.facade.DepartmentManagementFacade;
import com.school.portal.iamservice.department.application.use_cases.DepartmentCreationUseCase;
import org.springframework.stereotype.Service;

@Service
public class DepartmentManagementFacadeImpl implements DepartmentManagementFacade {

  private final DepartmentCreationUseCase departmentCreationUseCase;

  public DepartmentManagementFacadeImpl(DepartmentCreationUseCase departmentCreationUseCase) {
    this.departmentCreationUseCase = departmentCreationUseCase;
  }

  @Override
  public DepartmentLiteDTO create(CreateDepartmentDTO createDepartmentDTO) {
    return departmentCreationUseCase.create(createDepartmentDTO);
  }
}
