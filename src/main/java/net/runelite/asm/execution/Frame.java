package net.runelite.asm.execution;

import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.List;
import net.runelite.asm.Method;
import net.runelite.asm.attributes.Code;
import net.runelite.asm.attributes.code.Exception;
import net.runelite.asm.attributes.code.Instruction;
import net.runelite.asm.attributes.code.Instructions;
import net.runelite.asm.pool.NameAndType;
import net.runelite.asm.attributes.code.instruction.types.InvokeInstruction;
import net.runelite.asm.attributes.code.instruction.types.MappableInstruction;
import net.runelite.asm.attributes.code.instructions.InvokeStatic;

public class Frame
{
	private Execution execution;
	private Method method;
	private boolean executing = true;
	private Instruction cur; // current instruction
	private Stack stack;
	private Variables variables;
	private List<InstructionContext> instructions = new ArrayList<>(); // instructions executed in this frame
	private MethodContext ctx;
	protected Method nonStatic; // next non static method up the stack
	public Frame other; // in the other execution for mapping
	public Frame returnTo; // is this the same as caller?
	public Frame otherStatic;

	public Frame(Execution execution, Method method)
	{
		this.execution = execution;
		this.method = method;
		
		Code code = method.getCode();

		stack = new Stack(code.getMaxStack());
		variables = new Variables(code.getMaxLocals());
		// don't cache method contexts per execution
		// need to allow the same method to execute multiple times
		// when called from multiple places to allow graph building //XXX there no longer is a graph
		ctx = new MethodContext(execution);
		nonStatic = method;
	}

	public Frame(Execution execution, Method method, Instruction i)
	{
		this.execution = execution;
		this.method = method;

		Code code = method.getCode();

		stack = new Stack(code.getMaxStack());
		variables = new Variables(code.getMaxLocals());

		ctx = new MethodContext(execution);
		nonStatic = method;

		cur = i;
	}

	@Override
	public String toString()
	{
		return "Frame{" + "cur=" + cur + ", last=" + this.lastInstruction() + "}";
	}
	
	public void initialize()
	{
		// initialize LVT
		int pos = 0;
		if (!method.isStatic())
			variables.set(pos++, new VariableContext(new Type(method.getMethods().getClassFile().getName())).markParameter());
		
		NameAndType nat = method.getNameAndType();
		for (int i = 0; i < nat.getNumberOfArgs(); ++i)
		{
			variables.set(pos, new VariableContext(new Type(nat.getDescriptor().getTypeOfArg(i))).markParameter());
			pos += nat.getDescriptor().getTypeOfArg(i).getSlots();
		}
		
		Code code = method.getCode();
		cur = code.getInstructions().getInstructions().get(0);
	}
	
	public void initialize(InstructionContext ctx)
	{
		// initialize frame from invoking context
		assert ctx.getInstruction() instanceof InvokeInstruction;

		// this assert fails. evidently it's possible to invokevirtual a static method.
		//assert ctx.getInstruction() instanceof InvokeStatic == this.method.isStatic();
		
		if (this.getMethod().isStatic())
		{
			this.nonStatic = ctx.getFrame().nonStatic;
		}
		
		// initialize LVT. the last argument is popped first, and is at arguments[0]
		List<StackContext> pops = ctx.getPops();
		pops = Lists.reverse(new ArrayList<>(pops)); // reverse the list so first argument is at index 0
		
		int lvtOffset = 0;
		if (!(ctx.getInstruction() instanceof InvokeStatic))
		{
			StackContext s = pops.remove(0); // object
			
			// sometimes there are invokevirtuals on static methods. still must pop the object from the stack,
			// but don't set as a parameter
			if (!method.isStatic())
			{
				variables.set(lvtOffset++, new VariableContext(ctx, s).markParameter());
			}
		}

		NameAndType nat = method.getNameAndType();
		
		for (int i = 0; i < nat.getNumberOfArgs(); ++i)
		{
			StackContext argument = pops.remove(0);
			
			variables.set(lvtOffset, new VariableContext(ctx, argument).markParameter());
			lvtOffset += nat.getDescriptor().getTypeOfArg(i).getSlots();
		}
		
		assert pops.isEmpty();
		
		Code code = method.getCode();
		cur = code.getInstructions().getInstructions().get(0);
	}

	protected Frame(Frame other)
	{
		this.execution = other.execution;
		this.method = other.method;
		this.executing = other.executing;
		this.cur = other.cur;
		this.stack = new Stack(other.stack);
		this.variables = new Variables(other.variables);
		this.ctx = other.ctx;
		this.nonStatic = other.nonStatic;
		if (other.returnTo != null)
		{
			this.returnTo = new Frame(other.returnTo);
			this.returnTo.instructions.addAll(other.returnTo.instructions);
		}
		this.otherStatic = other.otherStatic;
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

	public boolean isExecuting()
	{
		return executing;
	}
	
	public Method getMethod()
	{
		return method;
	}
	
	public int getPc()
	{
		return cur.getPc();
	}

	public Stack getStack()
	{
		return stack;
	}
	
	public Variables getVariables()
	{
		return variables;
	}

	public MethodContext getMethodCtx()
	{
		return ctx;
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
					InstructionContext pushed = stacki.getPushed();
					Frame frame = pushed.getFrame();
					
					System.err.println(pushed.getInstruction().getDesc(frame));
				}
				System.err.println("end of stack");
				ex.printStackTrace();
				throw ex;
			}
			
			InstructionContext ictx = this.instructions.get(this.instructions.size() - 1);
			
			assert ictx.getInstruction() == oldCur;
			execution.contexts.put(oldCur, ictx);
			
			execution.executed.add(oldCur);
			
			processExceptions(oldCur);
			
			if (!executing)
				break;
			
			if (oldCur == cur)
			{
				this.nextInstruction();
			}
			else
			{
				/* jump */
			}
			
			if (execution.step && oldCur instanceof MappableInstruction)
			{
				MappableInstruction mi = (MappableInstruction) oldCur;
				if (mi.canMap(ictx))
				{
					execution.paused = true;
					return;
				}
			}
		}
	}
	
	public void nextInstruction()
	{
		Instructions ins = method.getCode().getInstructions();
		List<Instruction> instructions = ins.getInstructions();
		
		int idx = instructions.indexOf(cur);
		assert idx != -1;
		cur = instructions.get(idx + 1);
	}
	
	private InstructionContext lastInstruction()
	{
		return instructions.isEmpty() ? null : instructions.get(instructions.size() - 1);
	}
	
	private void processExceptions(Instruction i)
	{
		if (this.execution.step)
			return; // no frame.other
		
		Code code = method.getCode();
		InstructionContext ictx = instructions.get(instructions.size() - 1);
		
		assert ictx.getInstruction() == i;
		
		for (Exception e : code.getExceptions().getExceptions())
		{
			if (e.getStart() == i)
			{				
				Frame f = dup();
				Stack stack = f.getStack();
				
				while (stack.getSize() > 0)
					stack.pop();
				
				InstructionContext ins = new InstructionContext(i, f);
				StackContext ctx = new StackContext(ins, new Type("java/lang/Exception"), Value.NULL);
				stack.push(ctx);
				
				ins.push(ctx);
			
				f.jump(ictx, e.getHandler());
			}
		}
	}
	
	public void jump(InstructionContext from, Instruction to)
	{
		assert to != null;
		assert to.getInstructions() == method.getCode().getInstructions();
		assert method.getCode().getInstructions().getInstructions().contains(to);
		
		if (ctx.hasJumped(from, to))
		{
			executing = false;
			return;
		}
		
		cur = to;
	}
}
