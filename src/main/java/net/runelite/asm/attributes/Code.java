package net.runelite.asm.attributes;

import net.runelite.asm.Method;
import net.runelite.asm.attributes.code.Exceptions;
import net.runelite.asm.attributes.code.Instruction;
import net.runelite.asm.attributes.code.Instructions;
import net.runelite.asm.attributes.code.instruction.types.LVTInstruction;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import net.runelite.asm.signature.Signature;

public class Code extends Attribute
{
	private int maxStack;
	private Instructions instructions;
	private Exceptions exceptions;
	private Attributes attributes;

	public Code(Attributes attributes)
	{
		super(attributes, AttributeType.CODE);
		
		exceptions = new Exceptions(this);
		this.attributes = new Attributes(this);
		instructions = new Instructions(this);
	}
	
	@Override
	public void loadAttribute(DataInputStream is) throws IOException
	{
		maxStack = is.readUnsignedShort();
		is.skip(2); // max locals

		instructions = new Instructions(this);
		instructions.load(is);

		exceptions = new Exceptions(this);
		exceptions.load(is);
		
		this.attributes = new Attributes(this);
		this.attributes.load(is);
		
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
		int num = m.isStatic() ? -1 : 0;
		Signature sig = m.getDescriptor();
		for (int i = 0; i < sig.size(); ++i)
			num += sig.getTypeOfArg(i).getSlots();
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
					max = lvt.getVariableIndex(); // XXX if this is long or double and highest lvt, requires 2 slots
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
	
	public void setInstructions(Instructions instructions)
	{
		this.instructions = instructions;
	}
}
