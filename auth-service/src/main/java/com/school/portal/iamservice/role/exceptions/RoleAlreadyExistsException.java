package com.school.portal.iamservice.role.exceptions;

import com.school.portal.iamservice.common.exceptions.IException;
import jakarta.annotation.Nonnull;
import java.io.Serial;
import org.springframework.http.HttpStatus;

public class RoleAlreadyExistsException extends RuntimeException implements IException {

  @Serial private static final long serialVersionUID = 629621124832888126L;

  private static final String MESSAGE = "Role Already Exists: [name : %s]";

  public RoleAlreadyExistsException(@Nonnull String roleName) {
    super(String.format(MESSAGE, roleName));
  }

  @Override
  public HttpStatus getCode() {
    return HttpStatus.NOT_FOUND;
  }
}
