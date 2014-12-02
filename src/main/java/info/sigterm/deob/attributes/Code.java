package info.sigterm.deob.attributes;

import info.sigterm.deob.attributes.code.Exceptions;
import info.sigterm.deob.attributes.code.Instruction;
import info.sigterm.deob.attributes.code.Instructions;
import info.sigterm.deob.execution.Frame;

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

	public void buildInstructionGraph()
	{
		instructions.buildInstructionGraph();
	}

	public void execute(Frame frame)
	{
		Instruction i = instructions.getFirstInstruction();
		i.execute(frame);
	}
}
