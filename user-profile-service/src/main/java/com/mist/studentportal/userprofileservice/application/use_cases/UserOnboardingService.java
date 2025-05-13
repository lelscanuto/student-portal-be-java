package com.mist.studentportal.userprofileservice.application.use_cases;

import com.mist.studentportal.userprofileservice.application.dto.request.UserRegisterDTO;
import com.mist.studentportal.userprofileservice.application.dto.response.UserLiteDTO;
import java.util.concurrent.CompletableFuture;
import javax.annotation.Nonnull;

public interface UserOnboardingService {

  CompletableFuture<UserLiteDTO> activate(@Nonnull String userId);

  CompletableFuture<UserLiteDTO> register(@Nonnull UserRegisterDTO dto);
}
