package info.sigterm.deob.execution;

public class StackContext
{
	private InstructionContext pushed; // instruction which pushed this
	private InstructionContext popped; // instruction which popped this
	private Type type; // type of this
	
	public StackContext(InstructionContext pushed, Type type)
	{
		this.pushed = pushed;
		this.type = type;
	}
	
	public StackContext(InstructionContext pushed, Class<?> clazz)
	{
		this.pushed = pushed;
		type = new Type(clazz.getCanonicalName());
	}
	
	public StackContext(InstructionContext pushed, info.sigterm.deob.pool.Class c)
	{
		this.pushed = pushed;
		type = new Type(c.getName());
	}
	
	public InstructionContext getPushed()
	{
		return pushed;
	}

	public InstructionContext getPopped()
	{
		return popped;
	}

	public void setPopped(InstructionContext popped)
	{
		this.popped = popped;
	}

	public Type getType()
	{
		return type;
	}
	
	// remove this object from the stack
	public void removeStack()
	{
		// remove the instruction which pushed this
		if (!pushed.getInstruction().removeStack())
			// dup will return false as the other objects on the stack below this are necessary
			// for the other branch.
			return;
		
		// remove from the stack things this instruction read
		for (StackContext ctx : pushed.getPops()) 
			ctx.removeStack();
	}
}
