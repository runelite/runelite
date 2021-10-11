/*
 * Copyright (c) 2020 Abex
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
package net.runelite.http.api.gson;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import java.lang.reflect.Modifier;
import java.util.HashSet;
import java.util.Set;

public class IllegalReflectionExclusion implements ExclusionStrategy
{
	private static final Set<ClassLoader> PRIVATE_CLASSLOADERS = new HashSet<>();

	static
	{
		for (ClassLoader cl = ClassLoader.getSystemClassLoader(); cl != null; )
		{
			cl = cl.getParent();
			PRIVATE_CLASSLOADERS.add(cl);
		}
	}

	@Override
	public boolean shouldSkipField(FieldAttributes f)
	{
		if (!PRIVATE_CLASSLOADERS.contains(f.getDeclaringClass().getClassLoader()))
		{
			return false;
		}

		assert !Modifier.isPrivate(f.getDeclaringClass().getModifiers()) : "gsoning private class " + f.getDeclaringClass().getName();
		try
		{
			f.getDeclaringClass().getField(f.getName());
		}
		catch (NoSuchFieldException e)
		{
			throw new AssertionError("gsoning private field " + f.getDeclaringClass() + "." + f.getName());
		}
		return false;
	}

	@Override
	public boolean shouldSkipClass(Class<?> clazz)
	{
		return false;
	}
}
