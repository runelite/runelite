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

package net.runelite.asm.attributes;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import net.runelite.asm.Type;
import net.runelite.asm.attributes.annotation.Annotation;
import net.runelite.asm.attributes.annotation.Element;
import net.runelite.asm.attributes.annotation.SimpleElement;
import org.jetbrains.annotations.NotNull;

public class Annotations implements Iterable<Annotation>
{
	private final List<Annotation> annotations = new ArrayList<>();

	public List<Annotation> getAnnotations()
	{
		return annotations;
	}

	public void addAnnotation(Annotation annotation)
	{
		annotations.add(annotation);
	}

	public void removeAnnotation(Annotation annotation)
	{
		annotations.remove(annotation);
	}

	public void clearAnnotations()
	{
		annotations.clear();
	}

	public Annotation find(Type type)
	{
		for (Annotation a : annotations)
			if (a.getType().equals(type))
				return a;
		return null;
	}

	public int size()
	{
		return annotations.size();
	}

	public Annotation addAnnotation(Type type, String name, Object value)
	{
		Annotation annotation = new Annotation(type);
		addAnnotation(annotation);

		Element element = new SimpleElement(name, value);
		annotation.addElement(element);

		return annotation;
	}

	@NotNull
	@Override
	public Iterator<Annotation> iterator()
	{
		return this.annotations.iterator();
	}
}
