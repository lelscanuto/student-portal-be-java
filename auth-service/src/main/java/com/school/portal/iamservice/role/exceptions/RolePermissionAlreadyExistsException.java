package com.school.portal.iamservice.role.exceptions;

import com.school.portal.iamservice.common.exceptions.IException;
import java.io.Serial;
import java.util.Set;
import org.springframework.http.HttpStatus;

public class RolePermissionAlreadyExistsException extends RuntimeException implements IException {

  @Serial private static final long serialVersionUID = 2845363633384792918L;

  private static final String MESSAGE = "Role Permission Already Exists: [ids : %s]";

  public RolePermissionAlreadyExistsException(Set<Long> permissionIds) {
    super(String.format(MESSAGE, permissionIds));
  }

  @Override
  public HttpStatus getCode() {
    return HttpStatus.UNPROCESSABLE_ENTITY;
  }
}
