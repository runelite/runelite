package info.sigterm.deob.execution;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import info.sigterm.deob.Method;
import info.sigterm.deob.attributes.Code;
import info.sigterm.deob.attributes.code.Exception;
import info.sigterm.deob.attributes.code.Instruction;
import info.sigterm.deob.attributes.code.Instructions;
import info.sigterm.deob.attributes.code.instructions.LookupSwitch;
import info.sigterm.deob.attributes.code.instructions.TableSwitch;
import info.sigterm.deob.pool.NameAndType;

public class Frame
{
	private Execution execution;
	private Method method;
	private boolean executing = true;
	private int pc;
	private Stack stack;
	private Variables variables;
	private List<InstructionContext> instructions = new ArrayList<>(); // instructions executed in this frame
	private Map<Instruction, Instruction> visited; // shared

	public Frame(Execution execution, Method method)
	{
		this.execution = execution;
		this.method = method;
		
		Code code = method.getCode();

		stack = new Stack(code.getMaxStack());
		variables = new Variables(code.getMaxLocals());
		
		visited = new HashMap<>();
		
		// initialize LVT
		int pos = 0;
		if (!method.isStatic())
			variables.set(pos++, new VariableContext(null, new Type(method.getMethods().getClassFile().getName())));
		
		NameAndType nat = method.getNameAndType();
		for (int i = 0; i < nat.getNumberOfArgs(); ++i)
		{
			variables.set(pos, new VariableContext(null, new Type(nat.getDescriptor().getTypeOfArg(i)).toStackType()));
			pos += nat.getDescriptor().getTypeOfArg(i).getSlots();
		}
	}
	
	protected Frame(Frame other)
	{
		this.execution = other.execution;
		this.method = other.method;
		this.executing = other.executing;
		this.pc = other.pc;
		this.stack = new Stack(other.stack);
		this.variables = new Variables(other.variables);
		this.visited = other.visited;
	}
	
	public Frame dup()
	{
		Frame other = new Frame(this);
		execution.frames.add(other);
		return other;
	}
	
	public void stop()
	{
		executing = false;
	}
	
	public void throwException(Type type)
	{
		executing = false; // XXX
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
	
	public void addInstructionContext(InstructionContext i)
	{
		instructions.add(i);
	}
	
	public List<InstructionContext> getInstructions()
	{
		return instructions;
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
			}
			catch (Throwable ex)
			{
				System.err.println("Error executing instruction " + i.getDesc(this));
				System.err.println("Frame stack (grows downward):");
				while (stack.getSize() > 0)
				{
					StackContext stacki = stack.pop();
					System.err.println(stacki);
				}
				System.err.println("end of stack");
				ex.printStackTrace();
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
	
	private void doJump(Instruction from, Instruction to)
	{
		visited.put(from, to);
	}
	
	private boolean hasJumped(Instruction from, Instruction to)
	{
		Instruction i = visited.get(from);
		if (from instanceof TableSwitch || from instanceof LookupSwitch) // XXX magic instructions which jump to multiple different places
			if (i != null)
				return true;
		assert i == null || i == to;
		return i == to;
	}
	
	public void jump(int offset)
	{
		jumpAbsolute(pc + offset);
	}
	
	public void jumpAbsolute(int pc)
	{
		Instruction from = method.getCode().getInstructions().findInstruction(this.pc);
		Instruction to = method.getCode().getInstructions().findInstruction(pc);
		
		assert from != null;
		assert to != null;
		
		if (hasJumped(from, to))
		{
			executing = false;
			return;
		}
		
		doJump(from, to);
		this.pc = pc;
	}
}
