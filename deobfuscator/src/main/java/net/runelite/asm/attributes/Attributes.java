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

package net.runelite.asm.attributes;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;
import net.runelite.asm.ClassFile;
import net.runelite.asm.Field;
import net.runelite.asm.Method;
import net.runelite.asm.attributes.annotation.Annotation;
import net.runelite.asm.attributes.annotation.Element;
import net.runelite.asm.pool.PoolEntry;
import net.runelite.asm.signature.Type;

public class Attributes
{
	private ClassFile classFile;
	private Field field;
	private Method method;
	private Code code;

	private List<Attribute> attributes = new ArrayList<>();

	public Attributes(ClassFile cf, DataInputStream is) throws IOException
	{
		classFile = cf;

		load(is);
	}
	
	public Attributes(ClassFile cf)
	{
		classFile = cf;
	}

	public Attributes(Field f, DataInputStream is) throws IOException
	{
		field = f;

		load(is);
	}
	
	public Attributes(Field f)
	{
		field = f;
	}

	public Attributes(Method m)
	{
		method = m;
	}

	public Attributes(Code c)
	{
		code = c;
	}
	
	public Method getMethod()
	{
		return method;
	}

	public Attribute findType(AttributeType type)
	{
		for (Attribute a : attributes)
			if (a.getType() == type)
				return a;
		return null;
	}

	public ClassFile getClassFile()
	{
		if (classFile != null)
			return classFile;

		if (field != null)
			return field.getFields().getClassFile();

		if (method != null)
			return method.getMethods().getClassFile();

		if (code != null)
			return code.getAttributes().getClassFile();

		return null;
	}

	public void load(DataInputStream is) throws IOException
	{
		int count = is.readUnsignedShort();

		for (int i = 0; i < count; ++i)
		{
			String name = this.getClassFile().getPool().getUTF8(is.readUnsignedShort());

			AttributeType type = AttributeType.findType(name);
			try
			{
				Constructor<? extends Attribute> con = type.getAttributeClass().getConstructor(new Class[] { Attributes.class });
				Attribute attr = con.newInstance(this);
				attr.load(is);

				if (type != AttributeType.UNKNOWN)
					attributes.add(attr);
			}
			catch (Exception ex)
			{
				throw new IOException(ex);
			}
		}
	}
	
	public void write(DataOutputStream out) throws IOException
	{
		out.writeShort(attributes.size());
		for (Attribute a : attributes)
		{
			out.writeShort(this.getClassFile().getPool().makeUTF8(a.getType().getName()));
			a.write(out);
		}
	}
	
	public void addAttribute(Attribute a)
	{
		assert a.getAttributes() == this;
		attributes.add(a);
	}
	
	public Annotation addAnnotation(Type type, String etype, PoolEntry value)
	{
		Annotations an = (Annotations) findType(AttributeType.RUNTIMEVISIBLEANNOTATIONS);
		if (an == null)
		{
			an = new Annotations(this);
			this.addAttribute(an);
		}
		
		Annotation annotation = new Annotation(an);
		annotation.setType(type);
		an.addAnnotation(annotation);
		
		Element element = new Element(annotation);
		element.setType(new Type(etype));
		element.setValue(value);
		annotation.addElement(element);

		return annotation;
	}

	public Annotations getAnnotations()
	{
		return (Annotations) findType(AttributeType.RUNTIMEVISIBLEANNOTATIONS);
	}
}
