package com.mist.studentportal.userprofileservice.application.dto.request;

import java.util.Set;

public record UserRegisterDTO(
    String userId,
    String firstName,
    String middleName,
    String lastName,
    Set<String> roles,
    AddressDTO address) {}
