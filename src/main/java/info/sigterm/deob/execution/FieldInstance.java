package info.sigterm.deob.execution;

import info.sigterm.deob.Field;

public class FieldInstance
{
	private ObjectInstance object;
	private Field field;
	private Object value;
	
	public FieldInstance(ObjectInstance object, Field field, Object value)
	{
		this.object = object;
		this.field = field;
		this.value = value;
	}
	
	protected FieldInstance(ObjectInstance object, FieldInstance other)
	{
		this.object = object;
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
	
	public void setValue(Object obj)
	{
		value = obj;
	}
}
