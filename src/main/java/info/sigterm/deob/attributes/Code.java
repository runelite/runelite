package info.sigterm.deob.attributes;

import info.sigterm.deob.attributes.code.Exceptions;
import info.sigterm.deob.attributes.code.Instructions;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Code extends Attribute
{
	private int maxStack;
	private int maxLocals;
	private Instructions instructions;
	private Exceptions exceptions;
	private Attributes attributes;

	public Code(Attributes attributes) throws IOException
	{
		super(attributes, AttributeType.CODE);

		DataInputStream is = attributes.getStream();

		maxStack = is.readUnsignedShort();
		maxLocals = is.readUnsignedShort();

		instructions = new Instructions(this);

		exceptions = new Exceptions(this);
		this.attributes = new Attributes(this);
		
		instructions.buildBlocks();
		instructions.buildJumpGraph();
	}
	
	@Override
	public void writeAttr(DataOutputStream out) throws IOException
	{
		out.writeShort(maxStack);
		out.writeShort(maxLocals);
		
		instructions.write(out);
		exceptions.write(out);
		attributes.write(out);
	}

	public int getMaxStack()
	{
		return maxStack;
	}

	public int getMaxLocals()
	{
		return maxLocals;
	}
	
	public Exceptions getExceptions()
	{
		return exceptions;
	}
	
	public Instructions getInstructions()
	{
		return instructions;
	}

	public void buildInstructionGraph()
	{
		instructions.buildInstructionGraph();
	}
	
	public void buildCallGraph()
	{
		instructions.buildCallGraph();
	}
}
