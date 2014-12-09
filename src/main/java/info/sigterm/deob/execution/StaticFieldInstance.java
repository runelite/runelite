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
		this.value = value.getValue().getObject();
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
