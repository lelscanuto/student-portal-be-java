package com.school.portal.iamservice.department.application.facade;

import com.school.portal.iamservice.department.application.dto.CreateDepartmentDTO;
import com.school.portal.iamservice.department.application.dto.DepartmentLiteDTO;

public interface DepartmentManagementFacade {

  DepartmentLiteDTO create(CreateDepartmentDTO createDepartmentDTO);
}
