package com.school.portal.iamservice.permission.application.mappers;

import com.school.portal.iamservice.permission.application.dto.CreatePermissionDTO;
import com.school.portal.iamservice.permission.application.dto.PermissionDetailDTO;
import com.school.portal.iamservice.permission.domain.entities.Permission;
import org.mapstruct.CollectionMappingStrategy;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(
    collectionMappingStrategy = CollectionMappingStrategy.ADDER_PREFERRED,
    componentModel = MappingConstants.ComponentModel.SPRING,
    injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface PermissionMapper {

  Permission toEntity(CreatePermissionDTO createPermissionDTO);

  PermissionDetailDTO toPermissionDetailDTO(Permission permission);
}
