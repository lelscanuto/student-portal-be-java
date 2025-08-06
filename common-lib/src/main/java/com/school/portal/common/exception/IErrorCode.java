package com.school.portal.common.exception;

import org.springframework.http.HttpStatus;

public interface IErrorCode {

  String getCode();

  HttpStatus getHttpStatus();
}
