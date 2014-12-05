package info.sigterm.deob.attributes;

import info.sigterm.deob.attributes.code.Exceptions;
import info.sigterm.deob.attributes.code.Instructions;

import java.io.DataInputStream;
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
		attributes = new Attributes(this);
	}

	public int getMaxStack()
	{
		return getMaxStack();
	}

	public int getMaxLocals()
	{
		return maxLocals;
	}
	
	public Instructions getInstructions()
	{
		return instructions;
	}

	public void buildInstructionGraph()
	{
		instructions.buildInstructionGraph();
	}

	/*
	public void execute(Frame frame)
	{
		int pc = 0;
		
		while (exeuting)
		{
			Instruction i = instructions.findInstruction(pc);
			i.execute(frame);
		}
	}
	
	public void jump(int offset)
	{
	}*/
}
