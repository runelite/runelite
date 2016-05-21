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

package net.runelite.asm.signature;

import java.util.Objects;

public class Type
{
	private String type;
	private int arrayDimms;
	
	public Type(String str)
	{
		while (str.startsWith("["))
		{
			++arrayDimms;
			str = str.substring(1);
		}
		
		type = str;
	}
	
	public Type(String type, int dimms)
	{
		this.type = type;
		this.arrayDimms = dimms;
	}
	
	public Type(Type other)
	{
		type = other.type;
		arrayDimms = other.arrayDimms;
	}
	
	public String getType()
	{
		return type;
	}
	
	public String getFullType()
	{
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < arrayDimms; ++i)
			sb.append('[');
		sb.append(type);
		return sb.toString();
	}
	
	public int getArrayDims()
	{
		return arrayDimms;
	}
	
	public int getSlots()
	{
		if (arrayDimms == 0)
		{
			if (type.equals("D") || type.equals("J"))
				return 2;
		}
		return 1;
	}

	public boolean isInt()
	{
		return type.equals("I") && arrayDimms == 0;
	}

	public boolean isLong()
	{
		return type.equals("J") && arrayDimms == 0;
	}
	
	public boolean isPrimitive()
	{
		assert type.startsWith("L") == type.endsWith(";");
		return !type.startsWith("L");
	}
	
	public boolean isObfuscatedType()
	{
		return type.startsWith("Lclass");
	}
	
	@Override
	public boolean equals(Object other)
	{
		if (!(other instanceof Type))
			return false;
		
		Type a = (Type) other;
		return type.equals(a.type) && arrayDimms == a.arrayDimms;
	}

	@Override
	public int hashCode()
	{
		int hash = 7;
		hash = 23 * hash + Objects.hashCode(this.type);
		hash = 23 * hash + this.arrayDimms;
		return hash;
	}
	
	@Override
	public String toString()
	{
		String type = this.type;
		for (int i = 0; i < this.getArrayDims(); ++i)
			type += "[]";
		return type;
	}
}
