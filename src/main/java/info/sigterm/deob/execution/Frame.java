package info.sigterm.deob.execution;

import info.sigterm.deob.Method;
import info.sigterm.deob.attributes.Code;
import info.sigterm.deob.attributes.code.Instruction;
import info.sigterm.deob.attributes.code.Instructions;

public class Frame
{
	private Path path;
	private Method method;
	private boolean executing = true;
	private int pc;
	private Stack stack;
	private Variables variables;

	public Frame(Path path, Method method)
	{
		Code code = method.getCode();

		this.path = path;
		this.method = method;

		stack = new Stack(code.getMaxStack());
		variables = new Variables(code.getMaxLocals());
	}

	public Path getPath()
	{
		return path;
	}

	public Stack getStack()
	{
		return stack;
	}

	public Variables getVariables()
	{
		return variables;
	}
	
	public void execute()
	{
		Instructions ins = method.getCode().getInstructions();
		while (executing)
		{
			int oldPc = pc;
			
			Instruction i = ins.findInstruction(pc);
			i.execute(this);
			
			if (oldPc == pc)
			{
				pc += i.getLength();
			}
			else
			{
				/* jump */
			}
		}
	}
	
	public void jump(int offset)
	{
		assert offset != 0;
		pc += offset;
	}
}
