package net.runelite.client.plugins.alfred.rpc.annotate;

import java.lang.annotation.*;

@Documented
@Target(ElementType.TYPE)
@Inherited
@Retention(RetentionPolicy.RUNTIME)
public @interface RPCClass {
    String name();

    String description() default "";
}
