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

import java.lang.reflect.Constructor;

public abstract class ThrowableUtil
{
	/**
	 * Returns an instance of ThrowableUtil or throws if the JVM is not supported
	 */
	public static ThrowableUtil getInstance() throws JVMUnsupportedException
	{
		String vendor = System.getProperty("java.vendor");
		String version = System.getProperty("java.version");
		String vstr = "JVM \"" + version + "\" by \"" + vendor + "\" is not supported";
		if ("Oracle Corporation".equals(vendor) && version.startsWith("1.8.0"))
		{
			try
			{
				Constructor ctor = Class.forName("net.runelite.client.util.throwable.oracle8.Oracle8ThrowableUtil").getDeclaredConstructor();
				ctor.setAccessible(true);
				return (ThrowableUtil) ctor.newInstance();
			}
			catch (ThreadDeath d)
			{
				throw d;
			}
			catch (Throwable f)
			{
				throw new JVMUnsupportedException(vstr, f);
			}
		}
		throw new JVMUnsupportedException(vstr);
	}

	/**
	 * Uses black magic to get extra data from a stack trace
	 */
	public abstract EnhancedStackTraceElement[] getEnhancedStackTrace(Throwable t) throws JVMUnsupportedException;
}
