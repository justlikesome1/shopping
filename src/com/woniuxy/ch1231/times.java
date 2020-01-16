package com.woniuxy.ch1231;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.net.Authenticator.RequestorType;

import javax.lang.model.element.Element;

@Retention(RetentionPolicy.CLASS)
//@Target(ElementType.LOCAL_VARIABLE)
public @interface times {

	int number();
	String name();
	int[]  num();
	
	
}
