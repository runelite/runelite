package info.sigterm.deob.execution;


public abstract class ObjectInstanceBase
{
	private Path path;
	private ClassInstance type;
	
	public ObjectInstanceBase(Path path, ClassInstance type)
	{
		this.path = path;
		this.type = type;
	}
	
	public ClassInstance getType()
	{
		return type;
	}
}
