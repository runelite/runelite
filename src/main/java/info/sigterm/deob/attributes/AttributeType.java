package info.sigterm.deob.attributes;

public enum AttributeType
{
	CONSTANT_VALUE("ConstantValue", ConstantValue.class),
	CODE("Code", Code.class),
	UNKNOWN(null, Unknown.class);

	private String name;
	private Class<? extends Attribute> clazz;
	public int nameIndex;

	AttributeType(String name, Class<? extends Attribute> clazz)
	{
		this.name = name;
		this.clazz = clazz;
	}

	public String getName()
	{
		return name;
	}

	public Class<? extends Attribute> getAttributeClass()
	{
		return clazz;
	}

	public static AttributeType findType(String name)
	{
		for (AttributeType t : AttributeType.values())
			if (t.getName() != null && t.getName().equals(name))
				return t;

		return UNKNOWN;
	}
}
