package net.runelite.mapping;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.CONSTRUCTOR})
public @interface ObfuscatedSignature
{
	String signature();

	String garbageValue() default ""; // valid garbage value for last parameter. can't be an Object because Java.
}
