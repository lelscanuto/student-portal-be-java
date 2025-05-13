package com.mist.studentportal.userprofileservice.application.use_cases;

import com.mist.studentportal.userprofileservice.application.dto.response.UserLiteDTO;
import java.util.concurrent.CompletableFuture;
import javax.annotation.Nonnull;

public interface UserQueryService {

  CompletableFuture<UserLiteDTO> findByUserId(@Nonnull String userId);
}
