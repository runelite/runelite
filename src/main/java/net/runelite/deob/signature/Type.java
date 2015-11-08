package net.runelite.deob.signature;

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
		return getFullType();
	}
}
