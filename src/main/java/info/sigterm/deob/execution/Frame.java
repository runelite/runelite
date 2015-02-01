package info.sigterm.deob.execution;

import info.sigterm.deob.Method;
import info.sigterm.deob.attributes.Code;
import info.sigterm.deob.attributes.code.Instruction;
import info.sigterm.deob.attributes.code.Instructions;

public class Frame
{
	private Path path;
	private Method method;
	boolean executing = true;
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
	
	protected Frame(Path path, Frame other)
	{
		this.path = path;
		this.method = other.method;
		this.executing = other.executing;
		this.pc = other.pc;
		this.stack = new Stack(other.stack);
		this.variables = new Variables(other.variables);
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
			
			String desc = i.getDesc(this);
			if (desc != null)
				System.out.println(desc);
			
			try
			{
				i.execute(this);
			}
			catch (Throwable ex)
			{
				System.err.println("Error executing instruction in " + method.getName() + " " + method.getDescriptor() + " in class " + method.getMethods().getClassFile().getName() + " at pc " + pc);
				System.err.println("Frame stack (grows downward):");
				while (stack.getSize() > 0)
				{
					Instruction stacki = stack.getIns();
					Object obj = stack.pop();
					if (obj != null)
						System.err.println(" " + obj + " (class " + obj.getClass().getName() + ") pushed by instruction " + stacki + " at pc " + stacki.getPc());
					else
						System.err.println(" " + obj + " pushed by instruction " + stacki + " at pc " + stacki.getPc());
				}
				System.err.println("end of stack");
				ex.printStackTrace();
				System.exit(-1);
				//throw ex;
			}
			
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
