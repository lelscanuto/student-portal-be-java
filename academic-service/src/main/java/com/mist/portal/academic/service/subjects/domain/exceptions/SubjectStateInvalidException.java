package com.mist.portal.academic.service.subjects.domain.exceptions;

import com.mist.portal.academic.service.subjects.domain.constants.SubjectErrorCode;
import com.mist.portal.academic.service.subjects.domain.enums.SubjectOperation;
import com.school.portal.common.exception.ICodedException;
import com.school.portal.common.exception.IErrorCode;
import java.io.Serial;

public final class SubjectStateInvalidException extends RuntimeException
    implements ICodedException {

  @Serial private static final long serialVersionUID = 5030644180729147961L;

  private static final String MESSAGE =
      "Subject state is invalid for the operation : {operation: %s, code: %s, isDeleted: %s}";

  private SubjectStateInvalidException(String operation, String code, boolean isDeleted) {
    super(String.format(MESSAGE, operation, code, isDeleted));
  }

  public static SubjectStateInvalidExceptionBuilder of(String code) {
    return SubjectStateInvalidExceptionBuilder.aSubjectStateInvalidException().code(code);
  }

  @Override
  public IErrorCode getErrorCode() {
    return SubjectErrorCode.SUBJECT_STATE_INVALID;
  }

  public static final class SubjectStateInvalidExceptionBuilder {
    private String code;
    private String operation;
    private boolean isDeleted = false;

    private SubjectStateInvalidExceptionBuilder() {}

    public static SubjectStateInvalidExceptionBuilder aSubjectStateInvalidException() {
      return new SubjectStateInvalidExceptionBuilder();
    }

    private SubjectStateInvalidExceptionBuilder code(String code) {
      this.code = code;
      return this;
    }

    public SubjectStateInvalidExceptionBuilder operation(SubjectOperation operation) {
      this.operation = operation.name();
      return this;
    }

    public SubjectStateInvalidExceptionBuilder isDeleted() {
      this.isDeleted = true;
      return this;
    }

    public SubjectStateInvalidException build() {
      return new SubjectStateInvalidException(operation, code, isDeleted);
    }
  }
}
