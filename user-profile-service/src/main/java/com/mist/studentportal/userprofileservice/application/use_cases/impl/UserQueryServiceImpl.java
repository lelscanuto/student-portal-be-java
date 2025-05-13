package com.mist.studentportal.userprofileservice.application.use_cases.impl;

import com.mist.studentportal.userprofileservice.application.dto.response.UserLiteDTO;
import com.mist.studentportal.userprofileservice.application.mappers.UserMapper;
import com.mist.studentportal.userprofileservice.application.use_cases.UserQueryService;
import com.mist.studentportal.userprofileservice.common.exceptions.UserNotFoundException;
import com.mist.studentportal.userprofileservice.domain.repositories.UserRepository;
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
            .orElseThrow(() -> new UserNotFoundException(userId)));
  }
}
