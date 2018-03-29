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
package net.runelite.client.util.throwable.oracle8;

import java.lang.invoke.MethodType;
import java.lang.reflect.Method;
import net.runelite.client.util.throwable.EnhancedStackTraceElement;

class Oracle8EnhancedStackTraceElement implements EnhancedStackTraceElement
{
	// This is a java.lang.invoke.MemberName
	private final Object mn;
	private final int bci;
	private final StackTraceElement ste;

	Oracle8EnhancedStackTraceElement(Object mn, int bci, StackTraceElement ste)
	{
		this.mn = mn;
		this.bci = bci;
		this.ste = ste;
	}

	@Override
	public Method getMethod()
	{
		// We have to manually filter the methods because the jvm supports two methods with the same
		// name and parameters, but with different return types. Java's normal reflection methods don't
		// allow you to filter by return type.
		Class<?> clazz = MagicUtil.MNgetClass(mn);
		String name = MagicUtil.MNgetName(mn).intern();
		MethodType mt = MagicUtil.MNgetMethodType(mn);
		Class<?> retur = mt.returnType();
		Class<?>[] params = mt.parameterArray();

		// Note: These methods have to be copied before being exposed
		Method[] ms = MagicUtil.classPrivateGetDeclaredMethods(clazz, false);

		for (Method m : ms)
		{
			if (name == m.getName()
				&& retur == m.getReturnType()
				&& MagicUtil.arrayContentsEq(params, m.getParameterTypes()))
			{
				return MagicUtil.classMethodCopyForWorld(m);
			}
		}
		return null;
	}

	@Override
	public Class<?> getDeclaringClass()
	{
		return MagicUtil.MNgetClass(mn);
	}

	@Override
	public String getMethodName()
	{
		return MagicUtil.MNgetName(mn);
	}

	@Override
	public Class<?> getReturnType()
	{
		MethodType mt = MagicUtil.MNgetMethodType(mn);
		return mt.returnType();
	}

	@Override
	public Class<?>[] getParameterTypes()
	{
		MethodType mt = MagicUtil.MNgetMethodType(mn);
		return mt.parameterArray();
	}

	@Override
	public String getFileName()
	{
		return ste.getFileName();
	}

	@Override
	public int getBytecodeIndex()
	{
		return bci;
	}

	@Override
	public int getLineNumber()
	{
		return ste.getLineNumber();
	}

	@Override
	public StackTraceElement toStackTraceElement()
	{
		return ste;
	}

	@Override
	public String toString()
	{
		StringBuilder b = new StringBuilder();
		Method m = getMethod();
		b.append(m.toString());

		b.append("(");

		int lineNo = ste.getLineNumber();
		String filename = ste.getFileName();
		if (filename != null)
		{
			b.append(filename);
		}
		if (lineNo >= 0)
		{
			b.append(":").append(lineNo).append(",");
		}

		b.append("bci ").append(bci);

		b.append(")");
		return b.toString();
	}
}
