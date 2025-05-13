package com.mist.studentportal.userprofileservice.infrastracture.mappers;

import com.mist.studentportal.userprofileservice.application.dto.request.UserRegisterDTO;
import com.mist.studentportal.userprofileservice.infrastracture.api.adapters.grpc.UserQueryService;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(
    componentModel = MappingConstants.ComponentModel.SPRING,
    injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface UserRequestMapper {

  UserRegisterDTO toUserRegisterDTO(UserQueryService.UserRegisterRequest grpcReq);
}
