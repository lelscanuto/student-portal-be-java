package com.school.portal.iamservice.department.application.use_cases.impl;

import static com.school.portal.common.utils.AssertUtil.isFalse;

import com.school.portal.iamservice.department.application.dto.CreateDepartmentDTO;
import com.school.portal.iamservice.department.application.dto.DepartmentLiteDTO;
import com.school.portal.iamservice.department.application.mappers.DepartmentMapper;
import com.school.portal.iamservice.department.application.use_cases.DepartmentCreationUseCase;
import com.school.portal.iamservice.department.domain.exceptions.DepartmentAlreadyExistsException;
import com.school.portal.iamservice.department.domain.repositories.DepartmentRepository;
import jakarta.annotation.Nonnull;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(propagation = Propagation.REQUIRES_NEW)
public class DepartmentCreationUseCaseImpl implements DepartmentCreationUseCase {

  private final DepartmentRepository departmentRepository;
  private final DepartmentMapper departmentMapper;

  public DepartmentCreationUseCaseImpl(
      DepartmentRepository departmentRepository, DepartmentMapper departmentMapper) {
    this.departmentRepository = departmentRepository;
    this.departmentMapper = departmentMapper;
  }

  /**
   * This method is responsible for creating a new department. It takes a CreateDepartmentDTO object
   * as input and returns a DepartmentLiteDTO object.
   *
   * @param createDepartmentDTO the DTO containing the details of the department to be created
   * @return a DepartmentLiteDTO representing the created department
   */
  @Override
  public DepartmentLiteDTO create(@Nonnull CreateDepartmentDTO createDepartmentDTO) {

    // Assert that department with code does not exists
    isFalse(departmentRepository.existsByCode(createDepartmentDTO.code()))
        .elseThrow(() -> DepartmentAlreadyExistsException.ofCode(createDepartmentDTO.code()));

    // Create Department
    final var department = departmentMapper.toEntity(createDepartmentDTO);

    // Save new Department
    departmentRepository.save(department);

    return departmentMapper.toLiteDTO(department);
  }
}
