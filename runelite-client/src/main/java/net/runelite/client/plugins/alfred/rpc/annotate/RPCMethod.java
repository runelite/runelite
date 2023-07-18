package net.runelite.client.plugins.alfred.rpc.annotate;

import java.lang.annotation.*;

@Documented
@Target({ElementType.METHOD})
@Inherited
@Retention(RetentionPolicy.RUNTIME)
public @interface RPCMethod {
    String name();

    String description() default "";
}