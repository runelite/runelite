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

package net.runelite.asm.pool;

import net.runelite.asm.ConstantPool;
import net.runelite.asm.signature.Signature;
import net.runelite.asm.signature.Type;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Objects;

public class NameAndType extends PoolEntry
{
	private int nameIndex, descriptorIndex;
	private java.lang.String name;
	/* method signature */
	private Signature signature;
	/* type */
	private Type type;

	public NameAndType(ConstantPool pool, DataInputStream is) throws IOException
	{
		super(ConstantType.NAME_AND_TYPE);

		nameIndex = is.readUnsignedShort();
		descriptorIndex = is.readUnsignedShort();
	}
	
	public NameAndType(java.lang.String name, Signature sig)
	{
		super(ConstantType.NAME_AND_TYPE);
		
		this.name = name;
		this.signature = sig;
	}
	
	public NameAndType(java.lang.String name, Type type)
	{
		super(ConstantType.NAME_AND_TYPE);
		
		this.name = name;
		this.type = type;
	}

	@Override
	public NameAndType copy()
	{
		if (signature != null)
		{
			return new NameAndType(name, new Signature(signature));
		}
		else if (type != null)
		{
			return new NameAndType(name, new Type(type));
		}
		else
		{
			assert false;
			return null;
		}
	}
	
	@Override
	public void resolve(ConstantPool pool)
	{
		name = pool.getUTF8(nameIndex);
		
		java.lang.String sig = pool.getUTF8(descriptorIndex);
		if (sig.startsWith("("))
			signature = new Signature(sig);
		else
			type = new Type(sig);
	}
	
	@Override
	public void prime(ConstantPool pool)
	{
		nameIndex = pool.makeUTF8(name);
		if (signature != null)
			descriptorIndex = pool.makeUTF8(signature.toString());
		else
			descriptorIndex = pool.makeUTF8(type.getFullType());
	}

	@Override
	public java.lang.String toString()
	{
		if (type != null)
			return name + " " + type;
		else
			return name + signature;
	}
	
	@Override
	public boolean equals(Object other)
	{
		if (!(other instanceof NameAndType))
			return false;
		
		NameAndType nat = (NameAndType) other;
		return name.equals(nat.name) && Objects.equals(signature, nat.signature) && Objects.equals(type, nat.type);
	}
	
	@Override
	public int hashCode()
	{
		return name.hashCode();
	}

	public java.lang.String getName()
	{
		return name;
	}

	public Signature getDescriptor()
	{
		return signature;
	}
	
	public Type getDescriptorType()
	{
		return type;
	}

	public Object getStackObject()
	{
		switch (type.getFullType())
		{
			case "B":
				return (byte) 0;
			case "C":
				return (char) 0;
			case "I":
				return 0;
			case "S":
				return null;
			case "Z":
				return false;
			case "D":
				return 0d;
			case "F":
				return 0f;
			case "J":
				return 0L;
			default:
				return null;
		}
	}

	public int getNumberOfArgs()
	{
		return signature.size();
	}
	
	public boolean isVoid()
	{
		if (this.getName().equals("<init>") || this.getName().equals("<clinit>"))
			return true;
		return signature.getReturnValue().getType().equals("V");
	}

	@Override
	public void write(DataOutputStream out) throws IOException
	{
		out.writeShort(nameIndex);
		out.writeShort(descriptorIndex);
	}
}
