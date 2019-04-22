package net.runelite.client.rs.bytecode.transformers;

import javassist.CtClass;
import javassist.CtMethod;
import javassist.CtNewMethod;
import net.runelite.client.rs.bytecode.ByteCodePatcher;

//This prevents the client from sending stack traces to Jagex at all, even classes outside of runelite.
public class ErrorTransform implements Transform {
    public CtClass ct = null;

    //Where Runelites error interceptor is located, not auto-scraped.
    private final String ERROR_INSTANCE_CLASS = "dp";
    private final String ERROR_INSTANCE_METHOD = "a";
    private final String ERROR_WARNING = "Tried to send a warning";

    @Override
    public void modify(Class clazz) {
        try {
            System.out.println("[RuneLitePlus] Transforming error method at class: "+ERROR_INSTANCE_CLASS);
            ct = ByteCodePatcher.classPool.get(ERROR_INSTANCE_CLASS);
            CtMethod error = ct.getDeclaredMethod(ERROR_INSTANCE_METHOD);
            ct.removeMethod(error);
            error = CtMethod.make("public static void a(String string, Throwable throwable, byte by) {"+
                    "                       throwable.printStackTrace();"+
                    "                       System.out.println(\"[RuneLitePlus] Prevented preceeding stack trace from being sent to Jagex\");"+
                    "                   }", ct);
            ct.addMethod(error);
            ByteCodePatcher.modifiedClasses.add(ct);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void transform() {

    }
}
