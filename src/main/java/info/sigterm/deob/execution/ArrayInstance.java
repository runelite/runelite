package info.sigterm.deob.execution;

import java.util.Arrays;


public class ArrayInstance extends ObjectInstanceBase
{
	private Object[] array;
	
	public ArrayInstance(Path path, ClassInstance type, int len)
	{
		super(path, type);
		this.array = new Object[len];
	}
	
	private ArrayInstance(ArrayInstance other, Path path, ClassInstance type)
	{
		super(path, type);
		this.array = Arrays.copyOf(other.array, other.array.length);
	}
	
	public void put(Object obj, int idx)
	{
		array[idx] = obj;
	}
	
	public Object get(int idx)
	{
		return array[idx];
	}
	
	public int getLength()
	{
		return array.length;
	}

	@Override
	public ObjectInstanceBase dup(Path path, ClassInstance type)
	{
		return new ArrayInstance(this, path, type);
	}
}
