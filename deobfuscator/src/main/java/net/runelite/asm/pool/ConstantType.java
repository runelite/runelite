package net.runelite.asm.pool;

public enum ConstantType
{
	CLASS(7, Class.class),
	FIELDREF(9, Field.class),
	METHODREF(10, Method.class),
	INTERFACE_METHOD_REF(11, InterfaceMethod.class),
	STRING(8, String.class),
	INTEGER(3, Integer.class),
	FLOAT(4, Float.class),
	LONG(5, Long.class),
	DOUBLE(6, Double.class),
	NAME_AND_TYPE(12, NameAndType.class),
	UTF8(1, UTF8.class);

	private int value;
	private java.lang.Class<? extends PoolEntry> clazz;

	ConstantType(int value, java.lang.Class<? extends PoolEntry> clazz)
	{
		this.value = value;
		this.clazz = clazz;
	}

	public int getType()
	{
		return value;
	}

	public java.lang.Class<? extends PoolEntry> getPoolClass()
	{
		return clazz;
	}

	public static ConstantType findFromType(int type)
	{
		for (ConstantType t : ConstantType.values())
			if (t.getType() == type)
				return t;
		return null;
	}
}
