package com.mist.portal.academic.service.subjects.domain.exceptions;

import java.io.Serial;

public class SubjectAlreadyExistsException extends RuntimeException {

  @Serial private static final long serialVersionUID = -7723071872879894320L;

  private static final String MESSAGE = "Subject Already Exists: [{%s}]";

  public SubjectAlreadyExistsException(String code) {
    super(String.format(MESSAGE, code));
  }
}
