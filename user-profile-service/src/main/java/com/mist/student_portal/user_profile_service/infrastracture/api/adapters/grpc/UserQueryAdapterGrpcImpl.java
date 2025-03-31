package com.mist.student_portal.user_profile_service.infrastracture.api.adapters.grpc;

import com.mist.student_portal.user_profile_service.application.use_cases.UserQueryService;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
public class UserQueryAdapterGrpcImpl extends UserQueryAdapterGrpc.UserQueryAdapterImplBase {

  private final UserQueryService userQueryService;

  public UserQueryAdapterGrpcImpl(UserQueryService userQueryService) {
    this.userQueryService = userQueryService;
  }

  @Override
  public void findByUserId(
      com.mist.student_portal.user_profile_service.infrastracture.api.adapters.grpc.UserQueryService
              .UserIdRequest
          request,
      StreamObserver<
              com.mist.student_portal.user_profile_service.infrastracture.api.adapters.grpc
                  .UserQueryService.UserLiteIdentifier>
          responseObserver) {

    userQueryService
        .findByUserId(request.getUserId())
        .thenAccept(
            res -> {
              responseObserver.onNext(
                  com.mist.student_portal.user_profile_service.infrastracture.api.adapters.grpc
                      .UserQueryService.UserLiteIdentifier.newBuilder()
                      .setUserId(res.getUserId())
                      .setEmail(res.getUserEmail())
                      .build());

              responseObserver.onCompleted();
            })
        .exceptionallyAsync(
            err -> {
              responseObserver.onError(err);
              return null;
            });
  }
}
