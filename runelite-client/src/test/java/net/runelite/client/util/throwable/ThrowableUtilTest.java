/*
 * Copyright (c) 2018 Abex
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *    list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
 * ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package net.runelite.client.util.throwable;

import java.lang.reflect.Method;
import org.junit.Assume;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

public class ThrowableUtilTest
{
	@Test
	public void test() throws Exception
	{
		ThrowableUtil tu;
		try
		{
			tu = ThrowableUtil.getInstance();
		}
		catch (JVMUnsupportedException e)
		{
			Assume.assumeTrue(e.getMessage(), e.getCause() != null);
			throw e;
		}

		try
		{
			new ExtendsDependsOnWithCLinit();
		}
		catch (ExceptionInInitializerError e)
		{
			testWithThrowable(tu, e);
			testWithThrowable(tu, e.getCause());
			return;
		}
		fail("Test is broken");
	}

	private void testWithThrowable(ThrowableUtil tu, Throwable e) throws JVMUnsupportedException
	{
		StackTraceElement[] vanilla = e.getStackTrace();
		EnhancedStackTraceElement[] enhanced = tu.getEnhancedStackTrace(e);

		assertEquals(vanilla.length, enhanced.length);

		for (int i = 0; i < vanilla.length; i++)
		{
			assertEquals(vanilla[i].getLineNumber(), enhanced[i].getLineNumber());
			assertEquals(vanilla[i].getFileName(), enhanced[i].getFileName());
			assertEquals(vanilla[i].getClassName(), enhanced[i].getDeclaringClass().getName());
			assertEquals(vanilla[i].getMethodName(), enhanced[i].getMethodName());
			enhanced[i].getBytecodeIndex();
			Method m = enhanced[i].getMethod();

			if (!vanilla[i].getMethodName().contains("init>"))
			{
				assertNotNull(m);
				assertEquals(vanilla[i].getMethodName(), m.getName());
				assertEquals(m.getDeclaringClass(), enhanced[i].getDeclaringClass());
			}
		}
	}

	static class FakeException extends RuntimeException
	{
		FakeException()
		{
			super("If you see this, ThrowableUtilTest is broken");
		}
	}

	static class ExtendsDependsOnWithCLinit extends DependsOnWithCLinit
	{
	}

	static class DependsOnWithCLinit
	{
		DependsOnWithCLinit(Object v)
		{
			new WithCLInit();
		}

		DependsOnWithCLinit()
		{
			this(null);
		}
	}

	static class WithCLInit
	{
		static
		{
			overloadedStatic();
		}

		WithCLInit()
		{
		}
	}

	static void overloadedStatic()
	{
		overloadedStatic(null);
	}

	static void overloadedStatic(Object v)
	{
		throw new FakeException();
	}
}
