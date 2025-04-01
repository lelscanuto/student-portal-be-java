package com.mist.student_portal.user_profile_service.application.dto.request;

public record AddressDTO(
    String street, String unitNo, String city, String province, String postalCode) {}
