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
package net.runelite.asm;

import net.runelite.asm.attributes.Annotations;
import net.runelite.asm.attributes.annotation.Annotation;
import net.runelite.deob.DeobAnnotations;
import org.objectweb.asm.AnnotationVisitor;
import org.objectweb.asm.FieldVisitor;
import org.objectweb.asm.Opcodes;

import static org.objectweb.asm.Opcodes.ACC_PRIVATE;
import static org.objectweb.asm.Opcodes.ACC_PROTECTED;
import static org.objectweb.asm.Opcodes.ACC_PUBLIC;

public class Field
{
	public static final int ACCESS_MODIFIERS = ACC_PUBLIC | ACC_PRIVATE | ACC_PROTECTED;

	private final ClassFile classFile;

	private int accessFlags;
	private String name;
	private Type type;
	private Object value; // ConstantValue
	private final Annotations annotations;

	public Field(ClassFile classFile, String name, Type type)
	{
		this.classFile = classFile;
		this.name = name;
		this.type = type;

		annotations = new Annotations();
	}

	public void accept(FieldVisitor visitor)
	{
		for (Annotation annotation : annotations.getAnnotations())
		{
			AnnotationVisitor av = visitor.visitAnnotation(annotation.getType().toString(), true);
			annotation.accept(av);
		}

		visitor.visitEnd();
	}

	public ClassFile getClassFile()
	{
		return classFile;
	}

	public int getAccessFlags()
	{
		return accessFlags;
	}

	public void setAccessFlags(int accessFlags)
	{
		this.accessFlags = accessFlags;
	}

	public boolean isPublic()
	{
		return (accessFlags & Opcodes.ACC_PUBLIC) != 0;
	}

	public void setPublic()
	{
		accessFlags = (short) ((accessFlags & ~ACCESS_MODIFIERS) | ACC_PUBLIC);
	}

	public boolean isStatic()
	{
		return (accessFlags & Opcodes.ACC_STATIC) != 0;
	}

	public void setStatic()
	{
		accessFlags |= Opcodes.ACC_STATIC;
	}

	public boolean isSynthetic()
	{
		return (accessFlags & Opcodes.ACC_SYNTHETIC) != 0;
	}

	public void setEnum()
	{
		accessFlags |= Opcodes.ACC_ENUM;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public Type getType()
	{
		return type;
	}

	public void setType(Type type)
	{
		this.type = type;
	}

	public Type getObfuscatedType()
	{
		Type type = DeobAnnotations.getObfuscatedType(this);
		if (type == null)
		{
			type = getType();
		}

		return type;
	}

	public Object getValue()
	{
		return value;
	}

	public void setValue(Object value)
	{
		this.value = value;
	}

	public Annotations getAnnotations()
	{
		return annotations;
	}

	public net.runelite.asm.pool.Field getPoolField()
	{
		return new net.runelite.asm.pool.Field(
			new net.runelite.asm.pool.Class(classFile.getName()),
			this.getName(),
			this.getType()
		);
	}

	@Override
	public String toString()
	{
		return (this.isStatic() ? "static " : "") + this.type + " " + classFile.getName() + "." + this.getName();
	}
}
