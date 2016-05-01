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
import net.runelite.asm.pool.InterfaceMethod;
import net.runelite.asm.pool.NameAndType;
import net.runelite.asm.pool.PoolEntry;
import net.runelite.asm.signature.Signature;
import net.runelite.asm.signature.util.VirtualMethods;
import net.runelite.deob.deobfuscators.mapping.MappingExecutorUtil;
import net.runelite.deob.deobfuscators.mapping.ParallelExecutorMapping;

public class InvokeInterface extends Instruction implements InvokeInstruction
{
	private InterfaceMethod method;
	private int count;
	private List<net.runelite.asm.Method> myMethods;

	public InvokeInterface(Instructions instructions, InstructionType type, int pc)
	{
		super(instructions, type, pc);
	}

	@Override
	public String toString()
	{
		return "invokeinterface " + method + " in " + this.getInstructions().getCode().getAttributes().getMethod() + " at pc 0x" + Integer.toHexString(this.getPc());
	}
	
	@Override
	public void load(DataInputStream is) throws IOException
	{
		method = this.getPool().getInterfaceMethod(is.readUnsignedShort());
		count = is.readUnsignedByte();
		is.skip(1);
		length += 4;
	}
	
	@Override
	public void write(DataOutputStream out) throws IOException
	{
		super.write(out);
		out.writeShort(this.getPool().make(method));
		out.writeByte(count);
		out.writeByte(0);
	}
	
	@Override
	public List<net.runelite.asm.Method> getMethods()
	{
		return myMethods != null ? myMethods : Arrays.asList();
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
		
		StackContext object = stack.pop();
		ins.pop(object);
		
		if (!method.getNameAndType().isVoid())
		{
			StackContext ctx = new StackContext(ins,
				new Type(method.getNameAndType().getDescriptor().getReturnValue()),
				Value.UNKNOWN
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
		method = new InterfaceMethod(clazz, new NameAndType(nat.getName(), sig));
	}

	@Override
	public PoolEntry getMethod()
	{
		return method;
	}
	
	private List<net.runelite.asm.Method> lookupMethods()
	{
		ClassGroup group = this.getInstructions().getCode().getAttributes().getClassFile().getGroup();
		
		ClassFile otherClass = group.findClass(method.getClassEntry().getName());
		if (otherClass == null)
			return null; // not our class

		net.runelite.asm.Method m = otherClass.findMethod(method.getNameAndType());
		if (m == null)
			return null;
		
		return VirtualMethods.getVirutalMethods(m);
	}

	@Override
	public void lookup()
	{
		myMethods = lookupMethods();
	}
	
	@Override
	public void regeneratePool()
	{
		if (myMethods != null && !myMethods.isEmpty())
			if (!myMethods.equals(lookupMethods()))
				method = myMethods.get(0).getPoolInterfaceMethod(); // is this right?
	}
	
	@Override
	public void map(ParallelExecutorMapping mapping, InstructionContext ctx, InstructionContext other)
	{
		InvokeInterface otherIv = (InvokeInterface) other.getInstruction();
		
		List<net.runelite.asm.Method> myMethods = this.getMethods(),
			otherMethods = otherIv.getMethods();
		
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
		
		/* map field that was invoked on */
		
		StackContext object1 = ctx.getPops().get(method.getNameAndType().getNumberOfArgs()),
			object2 = other.getPops().get(otherIv.method.getNameAndType().getNumberOfArgs());
		
		InstructionContext base1 = MappingExecutorUtil.resolve(object1.getPushed(), object1);
		InstructionContext base2 = MappingExecutorUtil.resolve(object2.getPushed(), object2);

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
	
	@Override
	public boolean isSame(InstructionContext thisIc, InstructionContext otherIc)
	{
		if (thisIc.getInstruction().getClass() != otherIc.getInstruction().getClass())
			return false;
		
		InvokeInterface thisIi = (InvokeInterface) thisIc.getInstruction(),
			otherIi = (InvokeInterface) otherIc.getInstruction();

		if (!MappingExecutorUtil.isMaybeEqual(thisIi.method.getNameAndType().getDescriptor(), otherIi.method.getNameAndType().getDescriptor()))
			return false;
		
		List<net.runelite.asm.Method> thisMethods = thisIi.getMethods(),
			otherMethods = otherIi.getMethods();
		
		if (thisMethods.size() != otherMethods.size())
			return false;
		
		for (int i = 0; i < thisMethods.size(); ++i)
		{
			net.runelite.asm.Method m1 = thisMethods.get(i);
			net.runelite.asm.Method m2 = otherMethods.get(i);

			if (!MappingExecutorUtil.isMaybeEqual(m1.getMethods().getClassFile(), m2.getMethods().getClassFile()))
				return false;
			
			if (!MappingExecutorUtil.isMaybeEqual(m1.getNameAndType().getDescriptor(), m2.getNameAndType().getDescriptor()))
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
