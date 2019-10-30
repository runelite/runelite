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

package net.runelite.asm.visitors;

import net.runelite.asm.Type;
import net.runelite.asm.attributes.annotation.Annotation;
import net.runelite.asm.attributes.annotation.ArrayElement;
import net.runelite.asm.attributes.annotation.SimpleElement;
import org.objectweb.asm.AnnotationVisitor;
import org.objectweb.asm.Opcodes;

public class AnnotationElementVisitor extends AnnotationVisitor
{
	private final Annotation annotation;

	AnnotationElementVisitor(Annotation annotation)
	{
		super(Opcodes.ASM5);

		this.annotation = annotation;
	}

	@Override
	public void visit(String name, Object value)
	{
		SimpleElement element = new SimpleElement(name, value);
		annotation.addElement(element);
	}

	@Override
	public AnnotationVisitor visitArray(String name)
	{
		ArrayElement element = new ArrayElement(name);
		this.annotation.addElement(element);
		return new AnnotationVisitor(Opcodes.ASM5)
		{
			@Override
			public void visit(String name, Object value)
			{
				element.addValue(value);
			}

			@Override
			public AnnotationVisitor visitAnnotation(String name, String descriptor)
			{
				Annotation annotation = new Annotation(name, new Type(descriptor));
				element.addValue(annotation);
				return new AnnotationElementVisitor(annotation);
			}
		};
	}

	@Override
	public AnnotationVisitor visitAnnotation(String name, String descriptor)
	{
		Annotation annotation = new Annotation(name, new Type(descriptor));
		this.annotation.addElement(annotation);
		return new AnnotationElementVisitor(annotation);
	}
}
