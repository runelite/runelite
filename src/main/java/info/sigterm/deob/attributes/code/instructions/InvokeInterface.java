package info.sigterm.deob.attributes.code.instructions;

import info.sigterm.deob.ClassFile;
import info.sigterm.deob.attributes.code.Instruction;
import info.sigterm.deob.attributes.code.InstructionType;
import info.sigterm.deob.attributes.code.Instructions;
import info.sigterm.deob.attributes.code.instruction.types.InvokeInstruction;
import info.sigterm.deob.execution.Frame;
import info.sigterm.deob.execution.InstructionContext;
import info.sigterm.deob.execution.Stack;
import info.sigterm.deob.execution.StackContext;
import info.sigterm.deob.execution.Type;
import info.sigterm.deob.pool.InterfaceMethod;
import info.sigterm.deob.pool.Method;
import info.sigterm.deob.pool.NameAndType;
import info.sigterm.deob.pool.PoolEntry;
import info.sigterm.deob.signature.Signature;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class InvokeInterface extends Instruction implements InvokeInstruction
{
	private InterfaceMethod method;
	private int count;

	public InvokeInterface(Instructions instructions, InstructionType type, int pc) throws IOException
	{
		super(instructions, type, pc);

		DataInputStream is = instructions.getCode().getAttributes().getStream();
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
	public void buildCallGraph()
	{	
		info.sigterm.deob.pool.Class clazz = method.getClassEntry();
		NameAndType nat = method.getNameAndType();
		
		info.sigterm.deob.Method thisMethod = this.getInstructions().getCode().getAttributes().getMethod();
		
		ClassFile otherClass = this.getInstructions().getCode().getAttributes().getClassFile().getGroup().findClass(clazz.getName());
		if (otherClass == null)
			return;
		info.sigterm.deob.Method other = otherClass.findMethod(nat);
		
		thisMethod.addCallTo(this, other);
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
		
		handleExceptions(frame);
		
		if (!method.getNameAndType().isVoid())
		{
			StackContext ctx = new StackContext(ins, new Type(method.getNameAndType().getDescriptor().getReturnValue()).toStackType());
			stack.push(ctx);
		}
		
		frame.addInstructionContext(ins);
	}
	
	private void handleExceptions(Frame frame)
	{
		// jump to instruction handlers that can catch exceptions here
		for (info.sigterm.deob.attributes.code.Exception e : this.getInstructions().getCode().getExceptions().getExceptions())
		{
			Instruction start = e.getStart(),
					end = e.getEnd();
			
			// [start, end)
			if (this.getPc() >= start.getPc() && this.getPc() < end.getPc())
			{
				Frame f = frame.dup();
				Stack stack = f.getStack();
				
				while (stack.getSize() > 0)
					stack.pop();
				
				InstructionContext ins = new InstructionContext(this, f);
				StackContext ctx = new StackContext(ins, new Type("java/lang/Exception"));
				stack.push(ctx);
				
				f.jumpAbsolute(e.getHandler().getPc());
			}
		}
	}

	@Override
	public void removeParameter(int idx)
	{
		info.sigterm.deob.pool.Class clazz = method.getClassEntry();
		NameAndType nat = method.getNameAndType();
		
		// create new signature
		Signature sig = new Signature(nat.getDescriptor());
		sig.remove(idx);
		
		// create new method pool object
		method = new InterfaceMethod(method.getPool(), clazz, new NameAndType(nat.getPool(), nat.getName(), sig));
	}

	@Override
	public PoolEntry getMethod()
	{
		return method;
	}
}
