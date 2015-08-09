package info.sigterm.deob;

import info.sigterm.deob.attributes.AttributeType;
import info.sigterm.deob.attributes.Attributes;
import info.sigterm.deob.attributes.Code;
import info.sigterm.deob.attributes.Exceptions;
import info.sigterm.deob.attributes.code.Instruction;
import info.sigterm.deob.attributes.code.instruction.types.LVTInstruction;
import info.sigterm.deob.pool.NameAndType;
import info.sigterm.deob.signature.Signature;

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

	Method(Methods methods) throws IOException
	{
		this.methods = methods;

		DataInputStream is = methods.getClassFile().getStream();
		ConstantPool pool = methods.getClassFile().getPool();

		accessFlags = is.readShort();
		name = pool.getUTF8(is.readUnsignedShort());
		arguments = new Signature(pool.getUTF8(is.readUnsignedShort()));
		attributes = new Attributes(this);
	}
	
	public void write(DataOutputStream out) throws IOException
	{
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

	public void buildInstructionGraph()
	{
		Code code = getCode();

		if (code != null)
			code.buildInstructionGraph();
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
}
