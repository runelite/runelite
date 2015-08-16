package net.runelite.deob.attributes;

import net.runelite.deob.Method;
import net.runelite.deob.attributes.code.Exceptions;
import net.runelite.deob.attributes.code.Instruction;
import net.runelite.deob.attributes.code.Instructions;
import net.runelite.deob.attributes.code.instruction.types.LVTInstruction;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Code extends Attribute
{
	private int maxStack;
	private Instructions instructions;
	private Exceptions exceptions;
	private Attributes attributes;

	public Code(Attributes attributes) throws IOException
	{
		super(attributes, AttributeType.CODE);

		DataInputStream is = attributes.getStream();

		maxStack = is.readUnsignedShort();
		is.skip(2); // max locals

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
		out.writeShort(getMaxLocals());
		
		instructions.write(out);
		exceptions.write(out);
		attributes.write(out);
	}

	public int getMaxStack()
	{
		return maxStack;
	}
	
	public void setMaxStack(int maxStack)
	{
		this.maxStack = maxStack;
	}
	
	private int getMaxLocalsFromSig()
	{
		Method m = super.getAttributes().getMethod();
		int num = m.isStatic() ? 0 : 1;
		num += m.getDescriptor().size();
		return num;
	}

	public int getMaxLocals()
	{
		int max = -1;
		
		for (Instruction ins : instructions.getInstructions())
		{
			if (ins instanceof LVTInstruction)
			{
				LVTInstruction lvt = (LVTInstruction) ins;
				
				if (lvt.getVariableIndex() > max)
					max = lvt.getVariableIndex();
			}
		}
		
		int fromSig = getMaxLocalsFromSig();
		if (fromSig > max)
			max = fromSig;
		
		return max + 1;
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
}
