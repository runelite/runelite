package net.runelite.deob;

import net.runelite.deob.attributes.AttributeType;
import net.runelite.deob.attributes.Attributes;
import net.runelite.deob.attributes.Code;
import net.runelite.deob.attributes.Exceptions;
import net.runelite.deob.attributes.code.Instruction;
import net.runelite.deob.attributes.code.instruction.types.LVTInstruction;
import net.runelite.deob.pool.NameAndType;
import net.runelite.deob.signature.Signature;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Method
{
	public static final int ACC_STATIC = 0x8;
	public static final int ACC_SYNCHRONIZED = 0x20;
	
	private Methods methods;

	private short accessFlags;
	private String name;
	public Signature arguments;
	private Attributes attributes;

	Method(Methods methods, DataInputStream is) throws IOException
	{
		this.methods = methods;

		ConstantPool pool = methods.getClassFile().getPool();

		accessFlags = is.readShort();
		name = pool.getUTF8(is.readUnsignedShort());
		arguments = new Signature(pool.getUTF8(is.readUnsignedShort()));
		attributes = new Attributes(this);
		attributes.load(is);
	}
	
	public Method(Methods methods, String name, Signature signature)
	{
		this.methods = methods;
		this.name = name;
		this.arguments = signature;
		attributes = new Attributes(this);
	}
	
	public void write(DataOutputStream out) throws IOException
	{
		assert methods.getMethods().contains(this);
		
		ConstantPool pool = methods.getClassFile().getPool();
		
		out.writeShort(accessFlags);
		out.writeShort(pool.makeUTF8(name));
		out.writeShort(pool.makeUTF8(arguments.toString()));
		attributes.write(out);
	}

	public Methods getMethods()
	{
		return methods;
	}
	
	public void setMethods(Methods methods)
	{
		this.methods = methods;
	}
	
	public Attributes getAttributes()
	{
		return attributes;
	}
	
	public void setAttributes(Attributes a)
	{
		this.attributes = a;
	}
	
	public String getName()
	{
		return name;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}

	public Signature getDescriptor()
	{
		return arguments;
	}
	
	public NameAndType getNameAndType()
	{
		return new NameAndType(name, arguments);
	}
	
	public boolean isStatic()
	{
		return (accessFlags & ACC_STATIC) != 0;
	}
	
	public void setStatic()
	{
		accessFlags |= ACC_STATIC;
	}
	
	public boolean isSynchronized()
	{
		return (accessFlags & ACC_SYNCHRONIZED) != 0;
	}
	
	public Exceptions getExceptions()
	{
		return (Exceptions) attributes.findType(AttributeType.EXCEPTIONS);
	}

	public Code getCode()
	{
		return (Code) attributes.findType(AttributeType.CODE);
	}
	
	@SuppressWarnings("unchecked")
	public <T extends Instruction & LVTInstruction> List<T> findLVTInstructionsForVariable(int index)
	{
		List<T> list = new ArrayList<>();
		
		if (getCode() == null)
			return null;
		
		for (Instruction ins : getCode().getInstructions().getInstructions())
			if (ins instanceof LVTInstruction)
			{
				LVTInstruction lv = (LVTInstruction) ins;
				
				if (lv.getVariableIndex() != index)
					continue;
				
				list.add((T) ins);
			}
		
		return list;
	}
	
	public net.runelite.deob.pool.Method getPoolMethod()
	{
		return new net.runelite.deob.pool.Method(
			new net.runelite.deob.pool.Class(this.getMethods().getClassFile().getName()),
			new NameAndType(this.getName(), this.getDescriptor())
		);
	}
}
