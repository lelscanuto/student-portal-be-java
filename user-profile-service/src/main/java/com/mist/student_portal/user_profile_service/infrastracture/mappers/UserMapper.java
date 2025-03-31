package com.mist.student_portal.user_profile_service.infrastracture.mappers;

import com.mist.student_portal.user_profile_service.application.dto.response.UserLiteDTO;
import com.mist.student_portal.user_profile_service.domain.entities.RoleEntity;
import com.mist.student_portal.user_profile_service.domain.entities.UserEntity;
import org.mapstruct.*;

import java.util.Set;
import java.util.stream.Collectors;

@Mapper(
    componentModel = MappingConstants.ComponentModel.SPRING,
    injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface UserMapper {

  @Mapping(target = "roles", source = "roles", qualifiedByName = "getRoles")
  UserLiteDTO toUserLiteDTO(UserEntity userEntity);

  @Named("getRoles")
  default Set<String> getRoles(Set<RoleEntity> roles) {
    return roles.stream().map(RoleEntity::getValue).collect(Collectors.toSet());
  }
}
