package net.runelite.client.plugins.alfred.rpc.annotate;

import java.lang.annotation.*;

@Documented
@Target({ElementType.FIELD})
@Inherited
@Retention(RetentionPolicy.RUNTIME)
public @interface RPCField {
    String name();

    String description() default "";
}