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
	private Instruction cur; // current instruction
	private Stack stack;
	private Variables variables;
	private List<InstructionContext> instructions = new ArrayList<>(); // instructions executed in this frame
	private Map<Instruction, List<Instruction>> visited; // shared

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
		
		cur = code.getInstructions().getInstructions().get(0);
	}
	
	protected Frame(Frame other)
	{
		this.execution = other.execution;
		this.method = other.method;
		this.executing = other.executing;
		this.pc = other.pc;
		this.cur = other.cur;
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
	
	public Execution getExecution()
	{
		return execution;
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
		List<Instruction> instructions = ins.getInstructions();
		
		while (executing)
		{
			Instruction oldCur = cur;
			
			try
			{
				cur.execute(this);
			}
			catch (Throwable ex)
			{
				System.err.println("Error executing instruction " + cur.getDesc(this));
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
			
			if (!executing)
				break;
			
			if (oldCur == cur)
			{
				int idx = instructions.indexOf(cur);
				assert idx != -1;
				cur = instructions.get(idx + 1);
			}
			else
			{
				/* jump */
			}
		}
	}
	
	private void doJump(Instruction from, Instruction to)
	{
		List<Instruction> l = visited.get(from);
		if (l == null)
		{
			List<Instruction> l2 = new ArrayList<>();
			l2.add(to);
			visited.put(from, l2);
		}
		else
		{
			l.add(to);
		}
	}
	
	private boolean hasJumped(Instruction from, Instruction to)
	{
		List<Instruction> i = visited.get(from);
		if (i != null && i.contains(to))
			return true;
		
		if (i == null)
		{
			i = new ArrayList<>();
			visited.put(from, i);
		}
		
		i.add(to);
		return false;
	}
	
	public void jump(Instruction to)
	{
		assert to != null;
		assert to.getInstructions() == method.getCode().getInstructions();
		assert method.getCode().getInstructions().getInstructions().contains(to);
		
		if (hasJumped(cur, to))
		{
			executing = false;
			return;
		}
		
		doJump(cur, to);
		cur = to;
	}
}
