package net.runelite.client.config;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface ConfigTitleSection
{
    int position();

    String keyName();

    String name();

    String description();

    String section() default "";

    String titleSection() default "";

    boolean hidden() default false;

    String unhide() default "";

    String unhideValue() default "";

    String hide() default "";

    String hideValue() default "";
}