package com.mist.studentportal.iamservice.role.exceptions;

import com.mist.studentportal.iamservice.common.exceptions.IException;
import jakarta.annotation.Nonnull;
import java.io.Serial;
import org.springframework.http.HttpStatus;

public class RoleDoesNotExistsException extends RuntimeException implements IException {

  @Serial private static final long serialVersionUID = 629621124832888126L;

  private static final String MESSAGE = "Role Does not Exists: [id : {%d}]";

  public RoleDoesNotExistsException(@Nonnull Long roleId) {
    super(String.format(MESSAGE, roleId));
  }

  @Override
  public HttpStatus getCode() {
    return HttpStatus.NOT_FOUND;
  }
}
