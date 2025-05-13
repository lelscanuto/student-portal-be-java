package com.mist.studentportal.userprofileservice.application.mappers;

import com.mist.studentportal.userprofileservice.application.dto.response.UserLiteDTO;
import com.mist.studentportal.userprofileservice.domain.entities.RoleEntity;
import com.mist.studentportal.userprofileservice.domain.entities.UserEntity;
import java.util.Set;
import java.util.stream.Collectors;
import org.mapstruct.*;

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
