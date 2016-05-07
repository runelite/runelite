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

package net.runelite.asm.attributes.annotation;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import net.runelite.asm.ConstantPool;
import net.runelite.asm.attributes.Annotations;
import net.runelite.asm.signature.Type;

public class Annotation
{
	private final Annotations annotations;
	private Type type;
	private final List<Element> elements = new ArrayList<>();

	public Annotation(Annotations annotations)
	{
		this.annotations = annotations;
	}

	public Annotations getAnnotations()
	{
		return annotations;
	}

	public void setType(Type type)
	{
		this.type = type;
	}

	public Type getType()
	{
		return type;
	}

	public List<Element> getElements()
	{
		return elements;
	}
	
	public Element getElement()
	{
		return elements.get(0);
	}
	
	public void addElement(Element element)
	{
		elements.add(element);
	}
	
	public void load(DataInputStream is) throws IOException
	{
		ConstantPool pool = annotations.getAttributes().getClassFile().getPool();
		
		int typeIndex = is.readUnsignedShort();
		type = new Type(pool.getUTF8(typeIndex));
		
		int pairs = is.readUnsignedShort();
		for (int i = 0; i < pairs; ++i)
		{
			Element e = new Element(this);
			e.load(is);
			elements.add(e);
		}
	}
	
	public void write(DataOutputStream out) throws IOException
	{
		ConstantPool pool = annotations.getAttributes().getClassFile().getPool();
		
		out.writeShort(pool.makeUTF8(type.getFullType()));
		out.writeShort(elements.size());
		for (Element e : elements)
		{
			e.write(out);
		}
	}
}
