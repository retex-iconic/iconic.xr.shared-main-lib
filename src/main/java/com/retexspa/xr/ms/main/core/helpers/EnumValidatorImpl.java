package com.retexspa.xr.ms.main.core.helpers;

import java.util.ArrayList;
import java.util.List;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EnumValidatorImpl implements ConstraintValidator<EnumValidator, String> {

  List<String> valueList = null;

  @Override
  public boolean isValid(String value, ConstraintValidatorContext context) {
    return value == null ? true : valueList.contains(value.toUpperCase());
  }

  @Override
  public void initialize(EnumValidator constraintAnnotation) {
    valueList = new ArrayList<String>();
    Class<? extends Enum<?>> enumClass = constraintAnnotation.enumClazz();

    @SuppressWarnings("rawtypes")
    Enum[] enumValArr = enumClass.getEnumConstants();

    for (@SuppressWarnings("rawtypes")
    Enum enumVal : enumValArr) {
      valueList.add(enumVal.toString().toUpperCase());
    }
  }
}
