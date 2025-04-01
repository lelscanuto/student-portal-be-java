package com.mist.student_portal.user_profile_service.common.exceptions;

import java.io.Serial;

public class UserNotFoundException extends RuntimeException {

  @Serial private static final long serialVersionUID = -6578753272315863572L;

  private static final String MESSAGE = "User does not Exists: [userId:%s]";

  public UserNotFoundException(String userId) {
    super(String.format(MESSAGE, userId));
  }
}
