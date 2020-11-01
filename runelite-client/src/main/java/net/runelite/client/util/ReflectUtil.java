/*
 * Copyright (c) 2018, Tomas Slusny <slusnucky@gmail.com>
 * Copyright (c) 2018, Abex
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
package net.runelite.client.util;

import java.lang.invoke.MethodHandles;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectUtil
{
	private ReflectUtil()
	{
	}

	public static MethodHandles.Lookup privateLookupIn(Class clazz)
	{
		try
		{
			// Java 9+ has privateLookupIn method on MethodHandles, but since we are shipping and using Java 8
			// we need to access it via reflection. This is preferred way because it's Java 9+ public api and is
			// likely to not change
			final Method privateLookupIn = MethodHandles.class.getMethod("privateLookupIn", Class.class, MethodHandles.Lookup.class);
			return (MethodHandles.Lookup) privateLookupIn.invoke(null, clazz, MethodHandles.lookup());
		}
		catch (InvocationTargetException | IllegalAccessException e)
		{
			throw new RuntimeException(e);
		}
		catch (NoSuchMethodException e)
		{
			try
			{
				// In Java 8 we first do standard lookupIn class
				final MethodHandles.Lookup lookupIn = MethodHandles.lookup().in(clazz);

				// and then we mark it as trusted for private lookup via reflection on private field
				final Field modes = MethodHandles.Lookup.class.getDeclaredField("allowedModes");
				modes.setAccessible(true);
				modes.setInt(lookupIn, -1); // -1 == TRUSTED
				return lookupIn;
			}
			catch (ReflectiveOperationException ex)
			{
				throw new RuntimeException(ex); // NOPMD: PreserveStackTrace: ignore e
			}
		}
	}
}
