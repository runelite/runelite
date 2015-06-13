package info.sigterm.deob.execution;

public class StackContext
{
	private InstructionContext ic; // instruction which pushed this
	private Type type; // type of this
	
	public StackContext(InstructionContext i, Type t)
	{
		ic = i;
		type = t;
	}
	
	public StackContext(InstructionContext i, Class<?> c)
	{
		ic = i;
		type = new Type(c.getCanonicalName());
	}
	
	public StackContext(InstructionContext i, info.sigterm.deob.pool.Class c)
	{
		ic = i;
		type = new Type(c.getName());
	}
	
	public InstructionContext getIns()
	{
		return ic;
	}
	
	public Type getType()
	{
		return type;
	}
	
	// remove this object from the stack
	public void removeStack()
	{
		// remove the instruction which pushed this
		if (!ic.getInstruction().removeStack())
			// dup will return false as the other objects on the stack below this are necessary
			// for the other branch.
			return;
		
		// remove from the stack things this instruction read
		for (StackContext ctx : ic.getPops()) 
			ctx.removeStack();
	}
}
