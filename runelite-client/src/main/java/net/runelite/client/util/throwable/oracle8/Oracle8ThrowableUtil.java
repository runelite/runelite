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

import net.runelite.client.util.throwable.EnhancedStackTraceElement;
import net.runelite.client.util.throwable.JVMUnsupportedException;
import net.runelite.client.util.throwable.ThrowableUtil;

class Oracle8ThrowableUtil extends ThrowableUtil
{
	private Oracle8ThrowableUtil()
	{
	}

	@Override
	public EnhancedStackTraceElement[] getEnhancedStackTrace(Throwable t) throws JVMUnsupportedException
	{
		// There is so much bad shit™ going on here.
		// This touches some _VERY_ internal JVM structures that reflection cannot even get to,
		// hence the use of MagicUtil, which extends sun.reflect.MagicAccessorImpl, which short
		// circuits JVM access checks. It also relies on implementation details of Method and
		// MethodName to turn a class and slot into a signature
		try
		{
			Object backtrace = MagicUtil.getBacktrace(t);
			if (backtrace == null)
			{
				return null;
			}

			Object[] btoarr = (Object[]) backtrace;
			// Method idnum
			short[] methods = (short[]) btoarr[0];
			// Bytecode Index
			int[] bcis = (int[]) btoarr[1];
			// Class
			Object[] mirrors = (Object[]) btoarr[2];
			// Constant pool reference to name ?
			//short[] cprefs = (short[]) btoarr[3];

			// This is getStackTrace, but without the deep copy
			StackTraceElement ste[] = MagicUtil.getWritableStackTrace(t);
			int length = ste.length;
			if (methods.length < length)
			{
				length = methods.length;
			}
			if (bcis.length < length)
			{
				length = bcis.length;
			}

			EnhancedStackTraceElement[] out = new EnhancedStackTraceElement[length];

			for (int i = 0; i < length; i++)
			{
				Class<?> mirror = (Class<?>) mirrors[i];
				// Get (incomplete) MethodName(package-private) for method idnum
				Object method = MagicUtil.makeMethodName(mirror, methods[i]);
				int bci = bcis[i] >> 16;
				out[i] = new Oracle8EnhancedStackTraceElement(method, bci, ste[i]);
			}

			return out;
		}
		catch (ThreadDeath d)
		{
			throw d;
		}
		catch (Throwable f)
		{
			throw new JVMUnsupportedException("", f);
		}
	}
}
