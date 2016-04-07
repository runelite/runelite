package net.runelite.asm.attributes.code.instructions;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import net.runelite.asm.ClassFile;
import net.runelite.asm.ClassGroup;
import net.runelite.asm.Field;
import net.runelite.asm.attributes.code.Instruction;
import net.runelite.asm.attributes.code.InstructionType;
import net.runelite.asm.attributes.code.Instructions;
import net.runelite.asm.attributes.code.instruction.types.GetFieldInstruction;
import net.runelite.asm.attributes.code.instruction.types.InvokeInstruction;
import net.runelite.asm.execution.Execution;
import net.runelite.asm.execution.Frame;
import net.runelite.asm.execution.InstructionContext;
import net.runelite.asm.execution.Stack;
import net.runelite.asm.execution.StackContext;
import net.runelite.asm.execution.Type;
import net.runelite.asm.execution.Value;
import net.runelite.asm.pool.Method;
import net.runelite.asm.pool.NameAndType;
import net.runelite.asm.pool.PoolEntry;
import net.runelite.asm.signature.Signature;
import net.runelite.deob.deobfuscators.rename.MappingExecutorUtil;
import net.runelite.deob.deobfuscators.rename.ParallelExecutorMapping;

public class InvokeStatic extends Instruction implements InvokeInstruction
{
	private Method method;
	private net.runelite.asm.Method myMethod;

	public InvokeStatic(Instructions instructions, InstructionType type, int pc)
	{
		super(instructions, type, pc);
	}
	
	public InvokeStatic(Instructions instructions, Method method)
	{
		super(instructions, InstructionType.INVOKESTATIC, -1);
		
		this.method = method;
	}
	
	@Override
	public String toString()
	{
		return "invokestatic " + method + " in " + this.getInstructions().getCode().getAttributes().getMethod() + " at pc 0x" + Integer.toHexString(this.getPc());
	}
	
	@Override
	public void load(DataInputStream is) throws IOException
	{
		method = this.getPool().getMethod(is.readUnsignedShort());
		length += 2;
	}
	
	@Override
	public void write(DataOutputStream out) throws IOException
	{
		super.write(out);
		out.writeShort(this.getPool().make(method));
	}
	
	@Override
	public List<net.runelite.asm.Method> getMethods()
	{
		return myMethod != null ? Arrays.asList(myMethod) : Arrays.asList();
	}

	@Override
	public InstructionContext execute(Frame frame)
	{
		InstructionContext ins = new InstructionContext(this, frame);
		Stack stack = frame.getStack();
		
		int count = method.getNameAndType().getNumberOfArgs();
		
		for (int i = 0; i < count; ++i)
		{
			StackContext arg = stack.pop();
			ins.pop(arg);
		}
		
		if (!method.getNameAndType().isVoid())
		{
			StackContext ctx = new StackContext(ins,
				new Type(method.getNameAndType().getDescriptor().getReturnValue()),
				Value.NULL
			);
			stack.push(ctx);
			
			ins.push(ctx);
		}
		
		for (net.runelite.asm.Method method : getMethods())
		{
			ins.invoke(method);
			
			if (method.getCode() == null)
			{
				frame.getExecution().methods.add(method);
				continue;
			}
			
			// add possible method call to execution
			Execution execution = frame.getExecution();
			execution.invoke(ins, method);
		}
		
		return ins;
	}
	
	@Override
	public void removeParameter(int idx)
	{
		net.runelite.asm.pool.Class clazz = method.getClassEntry();
		NameAndType nat = method.getNameAndType();
		
		// create new signature
		Signature sig = new Signature(nat.getDescriptor());
		sig.remove(idx);
		
		// create new method pool object
		method = new Method(clazz, new NameAndType(nat.getName(), sig));
	}
	
	@Override
	public PoolEntry getMethod()
	{
		return method;
	}
	
	private net.runelite.asm.Method lookupMethod()
	{
		ClassGroup group = this.getInstructions().getCode().getAttributes().getClassFile().getGroup();
		
		ClassFile otherClass = group.findClass(method.getClassEntry().getName());
		if (otherClass == null)
			return null; // not our class
		
		net.runelite.asm.Method other = otherClass.findMethodDeepStatic(method.getNameAndType());
		if (other == null)
			return null; // when regenerating the pool after renaming the method this can be null.
		
		return other;
	}

	@Override
	public void lookup()
	{
		myMethod = lookupMethod();
	}
	
	@Override
	public void regeneratePool()
	{
		if (myMethod != null)
			if (myMethod != lookupMethod())
				method = myMethod.getPoolMethod();
	}
	
	@Override
	public void map(ParallelExecutorMapping mapping, InstructionContext ctx, InstructionContext other)
	{
		List<net.runelite.asm.Method> myMethods = this.getMethods(),
			otherMethods = ((InvokeStatic) other.getInstruction()).getMethods();
		
		assert myMethods.size() == otherMethods.size();
		
		for (int i = 0; i < myMethods.size(); ++i)
			mapping.map(myMethods.get(i), otherMethods.get(i));
		
		for (int i = 0; i < ctx.getPops().size(); ++i)
		{
			StackContext s1 = ctx.getPops().get(i),
				s2 = other.getPops().get(i);
			
			InstructionContext base1 = MappingExecutorUtil.resolve(s1.getPushed(), s1);
			InstructionContext base2 = MappingExecutorUtil.resolve(s2.getPushed(), s2);
			
			if (base1.getInstruction() instanceof GetFieldInstruction && base2.getInstruction() instanceof GetFieldInstruction)
			{
				GetFieldInstruction gf1 = (GetFieldInstruction) base1.getInstruction(),
					gf2 = (GetFieldInstruction) base2.getInstruction();
				
				Field f1 = gf1.getMyField(),
					f2 = gf2.getMyField();
				
				if (f1 != null && f2 != null)
				{
					mapping.map(f1, f2);
				}
			}
		}
	}
	
	@Override
	public boolean isSame(InstructionContext thisIc, InstructionContext otherIc)
	{
		if (thisIc.getInstruction().getClass() != otherIc.getInstruction().getClass())
			return false;
		
		InvokeStatic thisIi = (InvokeStatic) thisIc.getInstruction(),
			otherIi = (InvokeStatic) otherIc.getInstruction();

		if (!MappingExecutorUtil.isMaybeEqual(thisIi.method.getNameAndType().getDescriptor(), otherIi.method.getNameAndType().getDescriptor()))
			return false;
		
		List<net.runelite.asm.Method> thisMethods = thisIi.getMethods(),
			otherMethods = otherIi.getMethods();
		
		if (thisMethods.size() != otherMethods.size())
			return false;
		
		assert thisMethods.size() == 1;
		assert otherMethods.size() == 1;
		
		for (int i = 0; i < thisMethods.size(); ++i)
		{
			net.runelite.asm.Method m1 = thisMethods.get(i);
			net.runelite.asm.Method m2 = otherMethods.get(i);
			
			/* The class names are random */
			
			if (!m1.getNameAndType().getDescriptor().equals(m2.getNameAndType().getDescriptor()))
				return false;
		}
		
		return true;
	}
	
	@Override
	public boolean canMap(InstructionContext thisIc)
	{
		return MappingExecutorUtil.isMappable(this);
	}
}
