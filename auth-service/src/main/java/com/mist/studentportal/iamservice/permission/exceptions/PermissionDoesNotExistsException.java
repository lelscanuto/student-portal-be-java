package com.mist.studentportal.iamservice.permission.exceptions;

import com.mist.studentportal.iamservice.common.exceptions.IException;
import jakarta.annotation.Nonnull;
import java.io.Serial;
import java.util.Set;
import org.springframework.http.HttpStatus;

public class PermissionDoesNotExistsException extends RuntimeException implements IException {

  @Serial private static final long serialVersionUID = 6514244927962484359L;

  private static final String MESSAGE_1 = "Permission not found: [{%d}]";

  private static final String MESSAGE_2 = "Permission Already Exists: [ids : %s]";

  public PermissionDoesNotExistsException(@Nonnull Long permissionId) {
    super(String.format(MESSAGE_1, permissionId));
  }

  public PermissionDoesNotExistsException(@Nonnull Set<Long> permissionId) {
    super(String.format(MESSAGE_2, permissionId));
  }

  @Override
  public HttpStatus getCode() {
    return HttpStatus.NOT_FOUND;
  }
}
