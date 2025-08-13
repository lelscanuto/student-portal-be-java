package com.school.portal.iamservice.department.domain.exceptions;

import com.school.portal.common.exception.ICodedException;
import com.school.portal.common.exception.IErrorCode;
import java.io.Serial;

public class DepartmentAlreadyExistsException extends RuntimeException implements ICodedException {

  @Serial private static final long serialVersionUID = -8174135086051265153L;

  private static final String MESSAGE = "Department Already Exists: [{%s}]";

  private DepartmentAlreadyExistsException(String message) {
    super(message);
  }

  public static DepartmentAlreadyExistsException ofCode(String code) {
    return new DepartmentAlreadyExistsException(String.format(MESSAGE, code));
  }

  @Override
  public IErrorCode getErrorCode() {
    return null;
  }
}
