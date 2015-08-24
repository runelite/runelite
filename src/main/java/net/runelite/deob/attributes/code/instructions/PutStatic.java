package net.runelite.deob.attributes.code.instructions;

import net.runelite.deob.ClassFile;
import net.runelite.deob.attributes.code.Instruction;
import net.runelite.deob.attributes.code.InstructionType;
import net.runelite.deob.attributes.code.Instructions;
import net.runelite.deob.attributes.code.instruction.types.SetFieldInstruction;
import net.runelite.deob.execution.Frame;
import net.runelite.deob.execution.InstructionContext;
import net.runelite.deob.execution.Stack;
import net.runelite.deob.execution.StackContext;
import net.runelite.deob.pool.Class;
import net.runelite.deob.pool.Field;
import net.runelite.deob.pool.NameAndType;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.List;
import net.runelite.deob.attributes.code.instruction.types.PushConstantInstruction;
import net.runelite.deob.deobfuscators.arithmetic.Encryption;
import net.runelite.deob.deobfuscators.arithmetic.Pair;

public class PutStatic extends Instruction implements SetFieldInstruction
{
	private Field field;

	public PutStatic(Instructions instructions, InstructionType type, int pc) throws IOException
	{
		super(instructions, type, pc);

		DataInputStream is = instructions.getCode().getAttributes().getStream();
		field = this.getPool().getField(is.readUnsignedShort());
		length += 2;
	}
	
	@Override
	public void write(DataOutputStream out) throws IOException
	{
		super.write(out);
		out.writeShort(this.getPool().make(field));
	}

	@Override
	public void execute(Frame frame)
	{
		InstructionContext ins = new InstructionContext(this, frame);
		Stack stack = frame.getStack();
		
		StackContext object = stack.pop();
		ins.pop(object);
		
		Encryption encryption = frame.getExecution().getEncryption();
		net.runelite.deob.Field myField = getMyField();
		if (encryption != null && myField != null)
		{
			Pair pair = encryption.getField(myField);
			InstructionContext ctx = object.getPushed();
			if (ctx.getInstruction() instanceof PushConstantInstruction && pair != null)
			{
				// field = encryptedvalue
				// decrypt value by * getter
				
				PushConstantInstruction pci = (PushConstantInstruction) ctx.getInstruction();
				int value = (int) pci.getConstant().getObject();
				
				if (value != 0 && value != 1)
				{
					value = value * pair.getter;

					encryption.change(pci, value);
				}
			}
			if (ctx.getInstruction() instanceof ISub)
			{
				List<StackContext> stackCtx = ctx.getPops();
				
				StackContext one = stackCtx.get(0), two = stackCtx.get(1);
				
				if (one.getPushed().getInstruction() instanceof IMul)
				{
					ctx = one.getPushed();
				}
				else if (two.getPushed().getInstruction() instanceof IMul)
				{
					ctx = two.getPushed();
				}
			}
			if (ctx.getInstruction() instanceof IMul && pair != null)
			{
				List<StackContext> stackCtx = ctx.getPops();
				
				StackContext one = stackCtx.get(0), two = stackCtx.get(1);
				
				if (one.getPushed().getInstruction() instanceof PushConstantInstruction)
				{
					PushConstantInstruction pci = (PushConstantInstruction) one.getPushed().getInstruction();
					int value = (int) pci.getConstant().getObject();
					
					// field is encrypted with pair
					// divide value by setter
					
					if (value != 0 && value != 1)
					{
						value = value * pair.getter;

						encryption.change(pci, value);
					}
					
				}
				else if (two.getPushed().getInstruction() instanceof PushConstantInstruction)
				{
					PushConstantInstruction pci = (PushConstantInstruction) two.getPushed().getInstruction();
					int value = (int) pci.getConstant().getObject();
					
					// field is encrypted with pair
					// divide value by setter
					
					if (value != 0 && value != 1)
					{
						value = value * pair.getter;

						encryption.change(pci, value);
					}
				}
				else
					assert false;
			}
		}
		
		frame.addInstructionContext(ins);
	}

	@Override
	public Field getField()
	{
		return field;
	}
	
	@Override
	public net.runelite.deob.Field getMyField()
	{
		Class clazz = field.getClassEntry();
		NameAndType nat = field.getNameAndType();

		ClassFile cf = this.getInstructions().getCode().getAttributes().getClassFile().getGroup().findClass(clazz.getName());
		if (cf == null)
			return null;

		net.runelite.deob.Field f2 = cf.findFieldDeep(nat);
		return f2;
	}
	
	@Override
	public void renameClass(ClassFile cf, String name)
	{
		if (field.getClassEntry().getName().equals(cf.getName()))
			field = new Field(new Class(name), field.getNameAndType());
		
		if (field.getNameAndType().getDescriptorType().getType().equals("L" + cf.getName() + ";"))
			field = new Field(field.getClassEntry(), new NameAndType(field.getNameAndType().getName(), new net.runelite.deob.signature.Type("L" + name + ";", field.getNameAndType().getDescriptorType().getArrayDims())));
	}
	
	@Override
	public void renameField(net.runelite.deob.Field f, Field newField)
	{
		Class clazz = field.getClassEntry();
		NameAndType nat = field.getNameAndType();

		ClassFile cf = this.getInstructions().getCode().getAttributes().getClassFile().getGroup().findClass(clazz.getName());
		if (cf == null)
			return;

		net.runelite.deob.Field f2 = cf.findFieldDeep(nat);
		
		if (f2 == f)
		{
			field = newField;
		}
	}
}
