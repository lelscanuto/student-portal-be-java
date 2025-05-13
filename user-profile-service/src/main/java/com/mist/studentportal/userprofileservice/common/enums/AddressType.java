package com.mist.studentportal.userprofileservice.common.enums;

import jakarta.persistence.Converter;

public enum AddressType implements IConvertible {
  MAILING(1),
  PERMANENT(2);

  private final long value;

  AddressType(long value) {
    this.value = value;
  }

  @Override
  public Long getValue() {
    return value;
  }

  @Converter(autoApply = true)
  public static class AddressTypeConverter extends AbstractEnumConverter<AddressType> {
    public AddressTypeConverter() {
      super(AddressType.class);
    }
  }
}
