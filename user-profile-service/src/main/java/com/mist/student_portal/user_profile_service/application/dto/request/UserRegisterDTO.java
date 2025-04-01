package com.mist.student_portal.user_profile_service.application.dto.request;

import java.util.Set;

public record UserRegisterDTO(
    String userId,
    String firstName,
    String middleName,
    String lastName,
    Set<String> roles,
    AddressDTO address) {}
