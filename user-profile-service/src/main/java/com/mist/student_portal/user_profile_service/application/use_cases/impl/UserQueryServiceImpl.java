package com.mist.student_portal.user_profile_service.application.use_cases.impl;

import com.mist.student_portal.user_profile_service.application.dto.response.UserLiteDTO;
import com.mist.student_portal.user_profile_service.application.use_cases.UserQueryService;
import com.mist.student_portal.user_profile_service.domain.repositories.UserRepository;
import com.mist.student_portal.user_profile_service.infrastracture.mappers.UserMapper;
import java.util.concurrent.CompletableFuture;
import javax.annotation.Nonnull;
import org.springframework.scheduling.annotation.Async;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true, propagation = Propagation.REQUIRES_NEW)
public class UserQueryServiceImpl implements UserQueryService {

  private final UserMapper userMapper;
  private final UserRepository userRepository;

  public UserQueryServiceImpl(UserMapper userMapper, UserRepository userRepository) {
    this.userMapper = userMapper;
    this.userRepository = userRepository;
  }

  @Override
  @Async
  public CompletableFuture<UserLiteDTO> findByUserId(@Nonnull String userId) {
    return CompletableFuture.completedFuture(
        userRepository
            .findByUserId(userId)
            .map(userMapper::toUserLiteDTO)
            .orElseThrow(() -> new RuntimeException("Something")));
  }
}
