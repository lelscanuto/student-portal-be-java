package com.mist.portal.academic.service.subjects.domain.exceptions;

import com.mist.portal.academic.service.subjects.domain.constants.SubjectErrorCode;
import com.school.portal.common.exception.ICodedException;
import com.school.portal.common.exception.IErrorCode;
import java.io.Serial;

public class SubjectAlreadyExistsException extends RuntimeException implements ICodedException {

  @Serial private static final long serialVersionUID = -7723071872879894320L;

  private static final String MESSAGE = "Subject Already Exists: [{%s}]";

  private SubjectAlreadyExistsException(String message) {
    super(message);
  }

  public static SubjectAlreadyExistsException ofCode(String code) {
    return new SubjectAlreadyExistsException((String.format(MESSAGE, code)));
  }

  @Override
  public IErrorCode getErrorCode() {
    return SubjectErrorCode.SUBJECT_ALREADY_EXISTS;
  }
}
