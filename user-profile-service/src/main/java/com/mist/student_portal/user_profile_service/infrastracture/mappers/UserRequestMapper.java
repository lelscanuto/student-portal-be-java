package com.mist.student_portal.user_profile_service.infrastracture.mappers;

import com.mist.student_portal.user_profile_service.application.dto.request.UserRegisterDTO;
import com.mist.student_portal.user_profile_service.infrastracture.api.adapters.grpc.UserQueryService;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(
    componentModel = MappingConstants.ComponentModel.SPRING,
    injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface UserRequestMapper {

  UserRegisterDTO toDTO(UserQueryService.UserRegisterRequest grpcReq);
}
