package com.school.portal.common.access_control;

import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor
@Getter
@Builder
public final class Token {

  private Long userId;
  private String userName;
  private String name;
  private String email;
  private Set<String> roles;
  private Set<String> departments;
}
