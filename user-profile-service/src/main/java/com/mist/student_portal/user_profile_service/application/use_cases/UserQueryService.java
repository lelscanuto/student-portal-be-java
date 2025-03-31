package com.mist.student_portal.user_profile_service.application.use_cases;

import com.mist.student_portal.user_profile_service.application.dto.response.UserLiteDTO;
import java.util.concurrent.CompletableFuture;
import javax.annotation.Nonnull;

public interface UserQueryService {

  CompletableFuture<UserLiteDTO> findByUserId(@Nonnull String userId);
}
