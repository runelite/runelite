package info.sigterm.deob.execution;

import java.util.Collection;
import java.util.HashSet;

import info.sigterm.deob.Method;
import info.sigterm.deob.attributes.Code;
import info.sigterm.deob.attributes.code.Exception;
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
	
	public Method getMethod()
	{
		return method;
	}
	
	public int getPc()
	{
		return pc;
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
			
			if (i == null)
			{
				System.err.println("Cant find ins at pc " + pc + " in method " + method.getName() + " in " + method.getCode().getAttributes().getClassFile().getName());
				System.exit(-1);
			}
			
			try
			{
				i.execute(this);
				System.out.println(i.getDesc(this));
			}
			catch (Throwable ex)
			{
				System.err.println("Error executing instruction " + i.getDesc(this));
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
				//System.exit(-1);
				throw ex;
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
	
	public void resume()
	{
		execute();
	}
	
	public void skip()
	{
		/* for resume, skip current ins? */
		Instructions ins = method.getCode().getInstructions();
		Instruction i = ins.findInstruction(pc);
		pc += i.getLength();
	}
	
	private void checkLoop()
	{
		if (!this.getPath().getExecution().visit(method, pc))
		{
			System.out.println("Ending frame " + this);
			executing = false;
		}
	}
	
	public void jump(int offset)
	{
		assert offset != 0;
		pc += offset;
		checkLoop();
	}
	
	public void jumpAbsolute(int pc)
	{
		this.pc = pc;
		checkLoop();
	}
	
	public Collection<Exception> getExceptionHandlers()
	{
		return method.getCode().getExceptions().getHandlersForPc(this.pc);
	}
}
