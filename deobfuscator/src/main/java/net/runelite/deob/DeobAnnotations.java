/*
 * Copyright (c) 2016-2017, Adam <Adam@sigterm.info>
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
package net.runelite.deob;

import net.runelite.asm.ClassFile;
import net.runelite.asm.Field;
import net.runelite.asm.Method;
import net.runelite.asm.Type;
import net.runelite.asm.attributes.Annotations;
import net.runelite.asm.attributes.annotation.Annotation;
import net.runelite.asm.attributes.annotation.Element;
import net.runelite.asm.signature.Signature;

import java.util.List;

public class DeobAnnotations
{
	public static final Type OBFUSCATED_NAME = new Type("Lnet/runelite/mapping/ObfuscatedName;");
	public static final Type EXPORT = new Type("Lnet/runelite/mapping/Export;");
	public static final Type IMPLEMENTS = new Type("Lnet/runelite/mapping/Implements;");
	public static final Type OBFUSCATED_GETTER = new Type("Lnet/runelite/mapping/ObfuscatedGetter;");
	public static final Type OBFUSCATED_SIGNATURE = new Type("Lnet/runelite/mapping/ObfuscatedSignature;");
	public static final Type HOOK = new Type("Lnet/runelite/mapping/Hook;");

	public static Signature getObfuscatedSignature(Method m)
	{
		String str = getAnnotationValue(m.getAnnotations(), OBFUSCATED_SIGNATURE);

		if (str == null)
		{
			return null;
		}

		return new Signature(str);
	}

	public static Type getObfuscatedType(Field f)
	{
		String str = getAnnotationValue(f.getAnnotations(), OBFUSCATED_SIGNATURE);

		if (str == null)
		{
			return null;
		}

		return new Type(str);
	}

	public static String getObfuscatedName(Annotations an)
	{
		return getAnnotationValue(an, OBFUSCATED_NAME);
	}

	public static String getExportedName(Annotations an)
	{
		return getAnnotationValue(an, EXPORT);
	}

	public static String getImplements(ClassFile cf)
	{
		return getAnnotationValue(cf.getAnnotations(), IMPLEMENTS);
	}

	public static Number getObfuscatedGetter(Field field)
	{
		if (field == null || field.getAnnotations() == null)
		{
			return null;
		}

		Annotation an = field.getAnnotations().find(OBFUSCATED_GETTER);
		if (an == null)
		{
			return null;
		}
		
		return (Number) an.getElement().getValue();
	}

	public static String getDecoder(Method method)
	{
		if (method == null || method.getAnnotations() == null)
		{
			return null;
		}

		Annotation an = method.getAnnotations().find(OBFUSCATED_SIGNATURE);
		if (an == null)
		{
			return null;
		}

		List<Element> elements = an.getElements();
		if (elements == null || elements.size() < 2)
		{
			return null;
		}

		return (String) elements.get(1).getValue();
	}

	public static String getAnnotationValue(Annotations an, Type type)
	{
		if (an == null)
		{
			return null;
		}

		Annotation a = an.find(type);
		if (a == null)
		{
			return null;
		}

		return a.getElement().getString();
	}
}
