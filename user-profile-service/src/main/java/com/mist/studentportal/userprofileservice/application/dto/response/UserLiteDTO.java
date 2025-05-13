package com.mist.studentportal.userprofileservice.application.dto.response;

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
