package net.runelite.deob.attributes.code.instructions;

import net.runelite.deob.ClassFile;
import net.runelite.deob.ClassGroup;
import net.runelite.deob.attributes.code.Instruction;
import net.runelite.deob.attributes.code.InstructionType;
import net.runelite.deob.attributes.code.Instructions;
import net.runelite.deob.attributes.code.instruction.types.InvokeInstruction;
import net.runelite.deob.execution.Frame;
import net.runelite.deob.execution.InstructionContext;
import net.runelite.deob.execution.Stack;
import net.runelite.deob.execution.StackContext;
import net.runelite.deob.execution.Type;
import net.runelite.deob.pool.Method;
import net.runelite.deob.pool.NameAndType;
import net.runelite.deob.pool.PoolEntry;
import net.runelite.deob.signature.Signature;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import net.runelite.deob.execution.Execution;

public class InvokeSpecial extends Instruction implements InvokeInstruction
{
	private Method method;
	private List<net.runelite.deob.Method> myMethods;

	public InvokeSpecial(Instructions instructions, InstructionType type, int pc)
	{
		super(instructions, type, pc);
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
	public List<net.runelite.deob.Method> getMethods()
	{
		return myMethods != null ? myMethods : Arrays.asList();
	}

	@Override
	public void execute(Frame frame)
	{
		InstructionContext ins = new InstructionContext(this, frame);
		Stack stack = frame.getStack();
		
		int count = method.getNameAndType().getNumberOfArgs();
		
		for (int i = 0; i < count; ++i)
		{
			StackContext arg = stack.pop();
			ins.pop(arg);
		}
		
		StackContext object = stack.pop();
		ins.pop(object);
		
		if (!method.getNameAndType().isVoid())
		{
			StackContext ctx = new StackContext(ins, new Type(method.getNameAndType().getDescriptor().getReturnValue()).toStackType());
			stack.push(ctx);
			
			ins.push(ctx);
		}
		
		for (net.runelite.deob.Method method : getMethods())
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
		
		frame.addInstructionContext(ins);
	}

	@Override
	public String getDesc(Frame frame)
	{	
		return "invokespecial " + method.getNameAndType().getDescriptor() + " on " + method.getClassEntry().getName();
	}
	
	@Override
	public void removeParameter(int idx)
	{
		net.runelite.deob.pool.Class clazz = method.getClassEntry();
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
	
	@Override
	public void lookup()
	{
		ClassGroup group = this.getInstructions().getCode().getAttributes().getClassFile().getGroup();
		
		ClassFile otherClass = group.findClass(method.getClassEntry().getName());
		if (otherClass == null)
			return; // not our class
		
		net.runelite.deob.Method other = otherClass.findMethod(method.getNameAndType());
		assert other != null;
		
		List<net.runelite.deob.Method> list = new ArrayList<>();
		list.add(other);
		myMethods = list;
	}
	
	@Override
	public void regeneratePool()
	{
		if (!myMethods.isEmpty())
			method = myMethods.get(0).getPoolMethod();
	}
}
