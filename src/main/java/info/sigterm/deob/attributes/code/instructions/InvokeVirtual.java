package info.sigterm.deob.attributes.code.instructions;

import info.sigterm.deob.ClassFile;
import info.sigterm.deob.ClassGroup;
import info.sigterm.deob.attributes.code.Instruction;
import info.sigterm.deob.attributes.code.InstructionType;
import info.sigterm.deob.attributes.code.Instructions;
import info.sigterm.deob.attributes.code.instruction.types.InvokeInstruction;
import info.sigterm.deob.execution.Frame;
import info.sigterm.deob.execution.InstructionContext;
import info.sigterm.deob.execution.Stack;
import info.sigterm.deob.execution.StackContext;
import info.sigterm.deob.execution.Type;
import info.sigterm.deob.pool.Class;
import info.sigterm.deob.pool.Method;
import info.sigterm.deob.pool.NameAndType;
import info.sigterm.deob.pool.PoolEntry;
import info.sigterm.deob.signature.Signature;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class InvokeVirtual extends Instruction implements InvokeInstruction
{
	private Method method;

	public InvokeVirtual(Instructions instructions, InstructionType type, int pc) throws IOException
	{
		super(instructions, type, pc);

		DataInputStream is = instructions.getCode().getAttributes().getStream();
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
			
			ins.push(ctx);
		}

		for (info.sigterm.deob.Method method : getMethods())
		{
			ins.invoke(method);
			// add possible method call to execution
			frame.getExecution().addMethod(method);
		}
		
		frame.addInstructionContext(ins);
	}
	
	// find the possible methods this instruction might be invoking. we can't know for sure
	// which method is being invoked without tracking the types of objects in fields and when
	// passed in parameters/return values.
	@Override
	public List<info.sigterm.deob.Method> getMethods()
	{
		ClassGroup group = this.getInstructions().getCode().getAttributes().getClassFile().getGroup();
		
		ClassFile otherClass = group.findClass(method.getClassEntry().getName());
		if (otherClass == null)
			return new ArrayList<>(); // not our class
		
		// look up this method in this class and anything that inherits from it
		List<info.sigterm.deob.Method> list = new ArrayList<>();
		findMethodFromClass(list, otherClass);
		return list;
	}
	
	private void findMethodFromClass(List<info.sigterm.deob.Method> list, ClassFile clazz)
	{
		info.sigterm.deob.Method m = clazz.findMethodDeep(method.getNameAndType());
		if (m != null)
			list.add(m);
	
		for (ClassFile cf : clazz.getChildren())
			findMethodFromClass(list, cf);
	}
	
	private void handleExceptions(Frame frame)
	{
		// jump to instruction handlers that can catch exceptions here
		for (info.sigterm.deob.attributes.code.Exception e : this.getInstructions().getCode().getExceptions().getExceptions())
		{
			int startIdx = this.getInstructions().getInstructions().indexOf(e.getStart()),
					endIdx = this.getInstructions().getInstructions().indexOf(e.getEnd()),
					thisIdx = this.getInstructions().getInstructions().indexOf(this);
			
			assert startIdx != -1;
			assert endIdx != -1;
			assert thisIdx != -1;
			
			// [start, end)
			if (thisIdx >= startIdx && thisIdx < endIdx)
			{
				Frame f = frame.dup();
				Stack stack = f.getStack();
				
				while (stack.getSize() > 0)
					stack.pop();
				
				InstructionContext ins = new InstructionContext(this, f);
				StackContext ctx = new StackContext(ins, new Type("java/lang/Exception"));
				stack.push(ctx);
				
				ins.push(ctx);
				
				f.jump(e.getHandler());
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
		method = new Method(clazz, new NameAndType(nat.getName(), sig));
	}
	
	@Override
	public PoolEntry getMethod()
	{
		return method;
	}
	
	@Override
	public void renameClass(ClassFile cf, String name)
	{
		if (method.getClassEntry().getName().equals(cf.getName()))
			method = new Method(new Class(name), method.getNameAndType());
		
		Signature signature = method.getNameAndType().getDescriptor();
		for (int i = 0; i < signature.size(); ++i)
		{
			info.sigterm.deob.signature.Type type = signature.getTypeOfArg(i);
			
			if (type.getType().equals("L" + cf.getName() + ";"))
				signature.setTypeOfArg(i, new info.sigterm.deob.signature.Type("L" + name + ";", type.getArrayDims())); 
		}
		
		// rename return type
		if (signature.getReturnValue().getType().equals("L" + cf.getName() + ";"))
			signature.setTypeOfReturnValue(new info.sigterm.deob.signature.Type("L" + name + ";", signature.getReturnValue().getArrayDims()));
	}
	
	@Override
	public void renameMethod(info.sigterm.deob.Method m, String name)
	{
		for (info.sigterm.deob.Method m2 : getMethods())
			if (m2.equals(m))
				method = new Method(method.getClassEntry(), new NameAndType(name, method.getNameAndType().getDescriptor()));
	}
}
