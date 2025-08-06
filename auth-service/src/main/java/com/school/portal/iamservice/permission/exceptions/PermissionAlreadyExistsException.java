package com.school.portal.iamservice.permission.exceptions;

import com.school.portal.iamservice.common.exceptions.IException;
import jakarta.annotation.Nonnull;
import java.io.Serial;
import org.springframework.http.HttpStatus;

public class PermissionAlreadyExistsException extends RuntimeException implements IException {

  @Serial private static final long serialVersionUID = 8587969671708706735L;

  private static final String MESSAGE = "Permission Already Exists: [{%s}]";

  public PermissionAlreadyExistsException(@Nonnull String name) {
    super(String.format(MESSAGE, name));
  }

  @Override
  public HttpStatus getCode() {
    return HttpStatus.CONFLICT;
  }
}
