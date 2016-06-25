/*
 * Copyright (c) 2016, Adam <Adam@sigterm.info>
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 * 1. Redistributions of source code must retain the above copyright
 *    notice, this list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright
 *    notice, this list of conditions and the following disclaimer in the
 *    documentation and/or other materials provided with the distribution.
 * 3. All advertising materials mentioning features or use of this software
 *    must display the following acknowledgement:
 *    This product includes software developed by Adam <Adam@sigterm.info>
 * 4. Neither the name of the Adam <Adam@sigterm.info> nor the
 *    names of its contributors may be used to endorse or promote products
 *    derived from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY Adam <Adam@sigterm.info> ''AS IS'' AND ANY
 * EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL Adam <Adam@sigterm.info> BE LIABLE FOR ANY
 * DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package net.runelite.asm;

import net.runelite.asm.attributes.Annotations;
import net.runelite.asm.attributes.annotation.Annotation;
import net.runelite.asm.signature.Type;
import org.objectweb.asm.AnnotationVisitor;
import org.objectweb.asm.FieldVisitor;

public class Field
{
	public static int ACC_PUBLIC = 0x0001;
	public static int ACC_PRIVATE = 0x0002;
	public static int ACC_PROTECTED = 0x0004;
	public static int ACC_STATIC = 0x0008;
	public static int ACC_FINAL = 0x0010;
	public static int ACC_VOLATILE = 0x0040;
	public static int ACC_TRANSIENT = 0x0080;
	public static int ACC_SYNTHETIC = 0x1000;
	public static int ACC_ENUM = 0x4000;

	private Fields fields;

	private int accessFlags;
	private String name;
	private Type type;
	private Object value; // ConstantValue
	private Annotations annotations;
	public boolean packetHandler;
	
	public Field(Fields fields, String name, Type type)
	{
		this.fields = fields;
		this.name = name;
		this.type = type;
		
		annotations = new Annotations();
	}

	public void accept(FieldVisitor visitor)
	{
		for (Annotation annotation : annotations.getAnnotations())
		{
			AnnotationVisitor av = visitor.visitAnnotation(annotation.getType().getFullType(), true);
			annotation.accept(av);
		}
		
		visitor.visitEnd();
	}

	public Fields getFields()
	{
		return fields;
	}
	
	public void setFields(Fields fields)
	{
		this.fields = fields;
	}

	public int getAccessFlags()
	{
		return accessFlags;
	}

	public void setAccessFlags(int accessFlags)
	{
		this.accessFlags = accessFlags;
	}
	
	public boolean isStatic()
	{
		return (accessFlags & ACC_STATIC) != 0;
	}
	
	public void setStatic()
	{
		accessFlags |= ACC_STATIC;
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
			new net.runelite.asm.pool.Class(this.getFields().getClassFile().getName()),
			this.getName(),
			this.getType()
		);
	}
	
	@Override
	public String toString()
	{
		return (this.isStatic() ? "static " : "") + this.type + " " + this.getFields().getClassFile().getName() + "." + this.getName();
	}
}