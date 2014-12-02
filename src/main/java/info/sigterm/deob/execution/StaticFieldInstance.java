package info.sigterm.deob.execution;

import info.sigterm.deob.Field;
import info.sigterm.deob.attributes.ConstantValue;

public class StaticFieldInstance
{
	private Field field;
	private ConstantValue value;

	public StaticFieldInstance(Field field, ConstantValue value)
	{
		this.field = field;
		this.value = value;
	}

	public Field getField()
	{
		return field;
	}

	public ConstantValue getValue()
	{
		return value;
	}
}
