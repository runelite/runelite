package info.sigterm.deob.execution;

import info.sigterm.deob.Field;
import info.sigterm.deob.attributes.ConstantValue;

public class StaticFieldInstance
{
	private ClassInstance clazz;
	private Field field;
	private Object value;

	public StaticFieldInstance(ClassInstance clazz, Field field, ConstantValue value)
	{
		this.clazz = clazz;
		this.field = field;
		if (value != null)
			this.value = value.getValue().getObject();
	}
	
	protected StaticFieldInstance(ClassInstance clazz, StaticFieldInstance other)
	{
		this.clazz = clazz;
		this.field = other.field;
		this.value = other.value;
	}

	public Field getField()
	{
		return field;
	}

	public Object getValue()
	{
		return value;
	}
	
	public void setField(Object obj)
	{
		value = obj;
	}
}
