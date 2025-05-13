package com.mist.studentportal.iamservice.role.application.mappers;

import com.mist.studentportal.iamservice.permission.domain.entities.Permission;
import com.mist.studentportal.iamservice.role.application.dto.CreateRoleDTO;
import com.mist.studentportal.iamservice.role.application.dto.RoleDetailDTO;
import com.mist.studentportal.iamservice.role.domain.entities.Role;
import java.util.Set;
import org.mapstruct.*;

@Mapper(
    collectionMappingStrategy = CollectionMappingStrategy.ADDER_PREFERRED,
    componentModel = MappingConstants.ComponentModel.SPRING,
    injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface RoleMapper {

  RoleDetailDTO toRoleDetailDTO(Role existingRole);

  @Mapping(target = "createdBy", ignore = true)
  @Mapping(target = "lastModifiedBy", ignore = true)
  @Mapping(target = "createdDate", ignore = true)
  @Mapping(target = "lastModifiedDate", ignore = true)
  Role toEntity(CreateRoleDTO createRoleDTO, Set<Permission> permissions);
}
