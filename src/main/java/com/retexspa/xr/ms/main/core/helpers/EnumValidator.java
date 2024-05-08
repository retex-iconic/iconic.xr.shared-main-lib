package com.retexspa.xr.ms.main.core.helpers;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.ReportAsSingleViolation;


@Documented
@Constraint(validatedBy = EnumValidatorImpl.class)
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@ReportAsSingleViolation
public @interface EnumValidator {

  Class<? extends Enum<?>> enumClazz();

  String message() default "Value is not valid";

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};
}
