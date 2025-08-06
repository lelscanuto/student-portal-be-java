package com.mist.portal.academic.service.subjects.domain.exceptions;

import java.io.Serial;

public class SubjectNotFoundException extends RuntimeException {

  @Serial private static final long serialVersionUID = -3817668673852982630L;

  private static final String MESSAGE = "Subject Not Found: [{%d}]";

  public SubjectNotFoundException(Long subjectId) {
    super(String.format(MESSAGE, subjectId));
  }

  public static SubjectNotFoundException of(Long id) {
    return new SubjectNotFoundException(id);
  }
}
