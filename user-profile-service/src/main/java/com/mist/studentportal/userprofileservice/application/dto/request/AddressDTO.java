package com.mist.studentportal.userprofileservice.application.dto.request;

public record AddressDTO(
    String street, String unitNo, String city, String province, String postalCode) {}
