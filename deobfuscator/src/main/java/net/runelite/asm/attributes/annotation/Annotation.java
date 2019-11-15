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

package net.runelite.asm.attributes.annotation;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import net.runelite.asm.Type;
import org.jetbrains.annotations.NotNull;
import org.objectweb.asm.AnnotationVisitor;

public class Annotation extends Element<List<Element>> implements Iterable<Element>
{
	private final Type type;

	public Annotation(Type type)
	{
		this.value = new ArrayList<>();
		this.type = type;
	}

	public Annotation(String name, Type type)
	{
		this.value = new ArrayList<>();
		this.name = name;
		this.type = type;
	}

	public Type getType()
	{
		return type;
	}

	public List<Element> getElements()
	{
		return value;
	}

	public Element getElement()
	{
		return value.get(0);
	}

	public void addElement(Element element)
	{
		value.add(element);
	}

	@Override
	public final void setValue(List<Element> value)
	{
		throw new UnsupportedOperationException();
	}

	public void accept(AnnotationVisitor visitor)
	{
		if (visitor == null)
		{
			return;
		}

		for (Element element : this)
		{
			accept(visitor, element.name, element.value);
		}

		visitor.visitEnd();
	}

	@NotNull
	@Override
	public Iterator<Element> iterator()
	{
		return this.value.iterator();
	}
}
