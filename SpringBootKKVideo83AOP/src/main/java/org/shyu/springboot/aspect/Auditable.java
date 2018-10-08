package org.shyu.springboot.aspect;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Auditable {
	public enum AuditDestination {
		FILE_STSTEM, DATABASE
	};
	
	AuditDestination value() default AuditDestination.FILE_STSTEM;
}
