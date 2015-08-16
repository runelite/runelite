package net.runelite.deob.execution;

public class Type
{
	public String type;
	
	public Type(String type)
	{
		if (type.startsWith("["))
			throw new IllegalStateException();
		this.type = type;
	}
	
	public Type(net.runelite.deob.signature.Type t)
	{
		type = asmTypeToClass(t.getType());
		for (int i = 0; i < t.getArrayDims(); ++i)
			type = type + "[]";
	}
	
	public Type toStackType()
	{
		if (type.equals(byte.class.getCanonicalName()) || type.equals(char.class.getCanonicalName()) || type.equals(short.class.getCanonicalName())
				|| type.equals(boolean.class.getCanonicalName()))
			return new Type(int.class.getCanonicalName());
		return this;
	}
	
	private static String asmTypeToClass(String type)
	{
		switch (type.toString())
		{
			case "B":
				return byte.class.getCanonicalName();
			case "C":
				return char.class.getCanonicalName();
			case "I":
				return int.class.getCanonicalName();
			case "S":
				return short.class.getCanonicalName();
			case "Z":
				return boolean.class.getCanonicalName();
			case "D":
				return double.class.getCanonicalName();
			case "F":
				return float.class.getCanonicalName();
			case "J":
				return long.class.getCanonicalName();
			default:
				return type.replace("/", ".");
		}
	}
	
	@Override
	public boolean equals(Object other)
	{
		if (!(other instanceof Type))
			return false;
		
		Type t = (Type) other;
		return type.equals(t.type);
	}
	
	public Type getSubtype()
	{
		if (!type.endsWith("[]"))
			throw new IllegalStateException(type + " is not an array type");
		
		return new Type(type.substring(0, type.length() - 2));
	}
}
