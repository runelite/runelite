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

package net.runelite.deob.updater;

import java.util.Arrays;
import net.runelite.asm.ClassFile;
import net.runelite.asm.ClassGroup;
import net.runelite.asm.Field;
import net.runelite.asm.Method;
import net.runelite.asm.Type;
import net.runelite.asm.attributes.Annotations;
import net.runelite.asm.attributes.annotation.Annotation;
import net.runelite.asm.attributes.annotation.Element;

public class AnnotationCopier
{
	private final ClassGroup group1, group2;
	private final Type[] types;

	public AnnotationCopier(ClassGroup group1, ClassGroup group2, Type... types)
	{
		this.group1 = group1;
		this.group2 = group2;
		this.types = types;
	}

	public void copy()
	{
		for (ClassFile cf1 : group1.getClasses())
		{
			ClassFile cf2 = group2.findClass(cf1.getName());

			assert cf2 != null;

			copy(cf1.getAnnotations(), cf2.getAnnotations());

			for (Field f : cf1.getFields())
			{
				Field f2 = cf2.findField(f.getName(), f.getType());

				assert f2 != null || f.getAnnotations() == null;

				if (f2 == null)
					continue;

				copy(f.getAnnotations(), f2.getAnnotations());
			}

			for (Method m : cf1.getMethods())
			{
				Method m2 = cf2.findMethod(m.getName(), m.getDescriptor());

				assert m2 != null || m.getAnnotations() == null;

				if (m2 == null)
					continue;

				copy(m.getAnnotations(), m2.getAnnotations());
			}
		}
	}

	private void copy(Annotations an, Annotations an2)
	{
		for (Annotation a : an2.getAnnotations())
		{
			if (isType(a.getType()))
			{
				an2.removeAnnotation(a);
			}
		}

		for (Annotation a : an.getAnnotations())
		{
			if (!isType(a.getType()))
				continue;
			
			Annotation a2 = new Annotation(an2);
			a2.setType(a.getType());

			for (Element element : a.getElements())
			{
				Element element2 = new Element(a2);
				element2.setName(element.getName());
				element2.setValue(element.getValue());
				a2.addElement(element2);
			}

			an2.addAnnotation(a2);
		}
	}

	private boolean isType(Type type)
	{
		return Arrays.asList(types).contains(type);
	}
}
