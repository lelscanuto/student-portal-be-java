package com.school.portal.iamservice.department.application.mappers;

import com.school.portal.iamservice.department.application.dto.CreateDepartmentDTO;
import com.school.portal.iamservice.department.application.dto.DepartmentLiteDTO;
import com.school.portal.iamservice.department.domain.entities.Department;
import org.mapstruct.CollectionMappingStrategy;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(
    collectionMappingStrategy = CollectionMappingStrategy.ADDER_PREFERRED,
    componentModel = MappingConstants.ComponentModel.SPRING,
    injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface DepartmentMapper {
  Department toEntity(CreateDepartmentDTO createDepartmentDTO);

  DepartmentLiteDTO toLiteDTO(Department department);
}
