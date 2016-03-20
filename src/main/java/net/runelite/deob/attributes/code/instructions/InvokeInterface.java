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
import net.runelite.deob.pool.InterfaceMethod;
import net.runelite.deob.pool.NameAndType;
import net.runelite.deob.pool.PoolEntry;
import net.runelite.deob.signature.Signature;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import net.runelite.deob.Field;
import net.runelite.deob.attributes.code.instruction.types.GetFieldInstruction;
import net.runelite.deob.deobfuscators.Renamer;
import net.runelite.deob.deobfuscators.rename.MappingExecutorUtil;
import net.runelite.deob.deobfuscators.rename.ParallelExecutorMapping;
import net.runelite.deob.execution.Execution;
import net.runelite.deob.execution.Value;

public class InvokeInterface extends Instruction implements InvokeInstruction
{
	private InterfaceMethod method;
	private int count;
	private List<net.runelite.deob.Method> myMethods;

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
	public List<net.runelite.deob.Method> getMethods()
	{
		return myMethods != null ? myMethods : Arrays.asList();
	}
	
	private void findMethodFromClass(List<net.runelite.deob.Method> list, ClassFile clazz)
	{
		net.runelite.deob.Method m = clazz.findMethodDeep(method.getNameAndType());
		if (m != null && !list.contains(m))
			list.add(m);
	
		for (ClassFile cf : clazz.getChildren())
			findMethodFromClass(list, cf);
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
			StackContext ctx = new StackContext(ins,
				new Type(method.getNameAndType().getDescriptor().getReturnValue()),
				Value.NULL
			);
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
	public void removeParameter(int idx)
	{
		net.runelite.deob.pool.Class clazz = method.getClassEntry();
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
	
	private List<net.runelite.deob.Method> lookupMethods()
	{
		ClassGroup group = this.getInstructions().getCode().getAttributes().getClassFile().getGroup();
		
		ClassFile otherClass = group.findClass(method.getClassEntry().getName());
		if (otherClass == null)
			return null; // not our class
		
		return Renamer.getVirutalMethods(otherClass.findMethod(method.getNameAndType()));
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
		
		List<net.runelite.deob.Method> myMethods = this.getMethods(),
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
		
		if (!thisIi.method.getNameAndType().getDescriptor().equals(otherIi.method.getNameAndType().getDescriptor()))
			return false;
		
		List<net.runelite.deob.Method> thisMethods = thisIi.getMethods(),
			otherMethods = otherIi.getMethods();
		
		if ((thisMethods != null) != (otherMethods != null))
			return false;
		
		if (thisMethods == null || otherMethods == null)
			return true; // we don't map these anyway
		
		if (thisMethods.size() != otherMethods.size())
			return false;
		
		for (int i = 0; i < thisMethods.size(); ++i)
		{
			net.runelite.deob.Method m1 = thisMethods.get(i),
				m2 = otherMethods.get(i);
			
			if (!m1.getMethods().getClassFile().getPoolClass().equals(m2.getMethods().getClassFile().getPoolClass()))
				return false;
			
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
