package info.sigterm.deob.execution;


public class ArrayInstance extends ObjectInstanceBase
{
	private ObjectInstance[] array;
	
	public ArrayInstance(Path path, ClassInstance type, int len)
	{
		super(path, type);
		this.array = new ObjectInstance[len];
	}
	
	public void put(ObjectInstance obj, int idx)
	{
		array[idx] = obj;
	}
	
	public ObjectInstance get(int idx)
	{
		return array[idx];
	}
}
