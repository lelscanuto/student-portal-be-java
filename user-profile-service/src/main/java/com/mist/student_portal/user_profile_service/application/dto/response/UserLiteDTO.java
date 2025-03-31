package com.mist.student_portal.user_profile_service.application.dto.response;

import java.util.Set;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserLiteDTO {

  private Long userId;
  private String email;
  private Set<String> roles;
}
