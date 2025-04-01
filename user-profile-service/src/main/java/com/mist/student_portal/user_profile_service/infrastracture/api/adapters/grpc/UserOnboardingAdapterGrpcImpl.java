package com.mist.student_portal.user_profile_service.infrastracture.api.adapters.grpc;

import com.mist.student_portal.user_profile_service.application.use_cases.UserOnboardingService;
import com.mist.student_portal.user_profile_service.infrastracture.mappers.UserRequestMapper;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
public class UserOnboardingAdapterGrpcImpl extends UserOnboardingGrpc.UserOnboardingImplBase {

  private final UserOnboardingService userOnboardingService;
  private final UserRequestMapper userRequestMapper;

  public UserOnboardingAdapterGrpcImpl(
      UserOnboardingService userOnboardingService, UserRequestMapper userRequestMapper) {
    this.userOnboardingService = userOnboardingService;
    this.userRequestMapper = userRequestMapper;
  }

  @Override
  public void activate(
      UserQueryService.UserIdRequest request,
      StreamObserver<UserQueryService.UserLiteIdentifier> responseObserver) {

    userOnboardingService.activate(request.getUserId());
  }

  @Override
  public void register(
      UserQueryService.UserRegisterRequest request,
      StreamObserver<UserQueryService.UserLiteIdentifier> responseObserver) {

    userOnboardingService.register(userRequestMapper.toDTO(request));
  }
}
