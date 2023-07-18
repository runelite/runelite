package net.runelite.client.plugins.alfred.rpc.annotate;

import java.lang.annotation.*;

@Documented
@Target({ElementType.PARAMETER})
@Inherited
@Retention(RetentionPolicy.RUNTIME)
public @interface RPCParameter {
    String name();

}