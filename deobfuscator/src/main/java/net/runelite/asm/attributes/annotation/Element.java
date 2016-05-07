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
import net.runelite.asm.ConstantPool;
import net.runelite.asm.pool.PoolEntry;
import net.runelite.asm.signature.Type;

public class Element
{
	private final Annotation annotation;
	private Type type;
	private PoolEntry value;
	
	public Element(Annotation annotation)
	{
		this.annotation = annotation;
	}

	public Annotation getAnnotation()
	{
		return annotation;
	}

	public Type getType()
	{
		return type;
	}

	public void setType(Type type)
	{
		this.type = type;
	}

	public PoolEntry getValue()
	{
		return value;
	}

	public void setValue(PoolEntry value)
	{
		this.value = value;
	}
	
	public String getString()
	{
		return (String) value.getObject();
	}
	
	public void load(DataInputStream is) throws IOException
	{
		ConstantPool pool = annotation.getAnnotations().getAttributes().getClassFile().getPool();
		
		int typeIndex = is.readShort();
		type = new Type(pool.getUTF8(typeIndex));
		
		byte type = is.readByte();
		
		if (type != 's' && type != 'I' && type != 'J')
			throw new RuntimeException("can't parse annotation element type " + type);
		
		int index = is.readShort(); // pool index to String
		
		value = pool.getEntry(index);
	}
	
	public void write(DataOutputStream out) throws IOException
	{
		ConstantPool pool = annotation.getAnnotations().getAttributes().getClassFile().getPool();

		out.writeShort(pool.makeUTF8(type.getFullType()));
		byte type;
		switch (value.getType())
		{
			case UTF8:
				type = 's';
				break;
			case INTEGER:
				type = 'I';
				break;
			case LONG:
				type = 'J';
				break;
			default:
				throw new RuntimeException("can't write annotation type " + value);
		}
		out.write(type);
		out.writeShort(pool.make(value));
	}
}
