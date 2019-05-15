package net.runelite.client.rs.bytecode.transformers;

import javassist.CannotCompileException;
import javassist.CtClass;
import javassist.CtMethod;
import javassist.NotFoundException;
import net.runelite.client.rs.bytecode.ByteCodePatcher;

// This prevents the client from sending stack traces to Jagex at all, even classes outside of runelite.
public class ErrorTransform implements Transform
{
	private CtClass ct;

	// Where Runelites error interceptor is located, not auto-scraped.
	private static final String ERROR_INSTANCE_CLASS = "dp";
	private static final String ERROR_INSTANCE_METHOD = "a";
    // private static final String ERROR_WARNING = "Tried to send a warning";

	@Override
	public void modify(Class clazz)
	{
		try
		{
			System.out.println("[RuneLitePlus] Transforming error method at class: " + ERROR_INSTANCE_CLASS);

			ct = ByteCodePatcher.classPool.get(ERROR_INSTANCE_CLASS);
			transformError();

			ByteCodePatcher.modifiedClasses.add(ct);
		}
		catch (CannotCompileException | NotFoundException e)
		{
			e.printStackTrace();
		}
	}

	private void transformError() throws CannotCompileException, NotFoundException
	{
		CtMethod error = ct.getDeclaredMethod(ERROR_INSTANCE_METHOD);
		ct.removeMethod(error);

		error = CtMethod.make(
			"public static void a(String string, Throwable throwable, byte by)" +
				"{" +
				"	throwable.printStackTrace();" +
				"	System.out.println(\"[RuneLitePlus] Prevented preceeding stack trace from being sent to Jagex\");" +
				"}", ct);
		ct.addMethod(error);
	}
}
