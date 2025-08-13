package com.mist.portal.academic.service.subjects.domain.constants;

import com.school.portal.common.exception.IErrorCode;
import org.springframework.http.HttpStatus;

public enum SubjectErrorCode implements IErrorCode {
  SUBJECT_STATE_INVALID("SUBJECT_ERR_001", HttpStatus.UNPROCESSABLE_ENTITY),
  SUBJECT_ALREADY_EXISTS("SUBJECT_ERR_002", HttpStatus.CONFLICT),
  SUBJECT_NOT_FOUND("SUBJECT_ERR_003", HttpStatus.NOT_FOUND);

  private final String code;
  private final HttpStatus httpStatus;

  SubjectErrorCode(String code, HttpStatus httpStatus) {
    this.code = code;
    this.httpStatus = httpStatus;
  }

  @Override
  public String getCode() {
    return this.code;
  }

  @Override
  public HttpStatus getHttpStatus() {
    return this.httpStatus;
  }
}
