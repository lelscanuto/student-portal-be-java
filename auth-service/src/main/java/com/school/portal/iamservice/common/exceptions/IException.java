package com.school.portal.iamservice.common.exceptions;

import java.io.Serializable;
import org.springframework.http.HttpStatus;

public interface IException extends Serializable {

  HttpStatus getCode();
}
