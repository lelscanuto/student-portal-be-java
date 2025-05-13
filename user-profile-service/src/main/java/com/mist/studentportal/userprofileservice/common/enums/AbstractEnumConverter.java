package com.mist.studentportal.userprofileservice.common.enums;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter
public abstract class AbstractEnumConverter<T extends Enum<T> & IConvertible>
    implements AttributeConverter<T, Long> {

  private final Class<T> clazz;

  protected AbstractEnumConverter(Class<T> clazz) {
    this.clazz = clazz;
  }

  @Override
  public Long convertToDatabaseColumn(T attribute) {
    return attribute != null ? attribute.getValue() : null;
  }

  @Override
  public T convertToEntityAttribute(Long dbData) {
    if (dbData == null) {
      return null;
    }

    T[] enums = clazz.getEnumConstants();

    for (T e : enums) {
      if (e.getValue().equals(dbData)) {
        return e;
      }
    }

    throw new UnsupportedOperationException();
  }
}
