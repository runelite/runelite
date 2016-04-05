package net.runelite.asm.attributes.code;

import net.runelite.asm.attributes.Code;

import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;

public class Instructions
{
	private Code code;
	private List<Instruction> instructions = new ArrayList<>();

	public Instructions(Code code)
	{
		this.code = code;
	}
	
	public void load(DataInputStream is) throws IOException
	{
		int length = is.readInt();

		int pc;
		for (pc = 0; pc < length;)
		{
			byte opcode = is.readByte();

			InstructionType type = InstructionType.findInstructionFromCode(opcode);

			try
			{
				Constructor<? extends Instruction> con = type.getInstructionClass().getConstructor(Instructions.class, InstructionType.class, int.class);
				Instruction ins = con.newInstance(this, type, pc);
				ins.load(is);
				
				Instruction genericIns = ins.makeGeneric();
				if (genericIns != ins)
				{
					genericIns.setPc(ins.getPc());
				}

				instructions.add(genericIns);

				int len = ins.getLength();
				pc += len;
			}
			catch (java.lang.Exception ex)
			{
				throw new IOException(ex);
			}
		}

		assert pc == length;
		
		for (Instruction i : instructions)
			i.resolve();
	}
	
	public List<Instruction> getInstructions()
	{
		return instructions;
	}
	
	public void addInstruction(Instruction i)
	{
		instructions.add(i);
	}
	
	public void remove(Instruction ins)
	{
		assert ins.getInstructions() == this;
		ins.remove();
		instructions.remove(ins);
		ins.setInstructions(null);
	}
	
	public void write(DataOutputStream out) throws IOException
	{
		this.regeneratePool();
		
		// translate instructions to specific
		for (Instruction i : new ArrayList<>(instructions))
		{
			Instruction specific = i.makeSpecific();
			if (i != specific)
			{
				replace(i, specific);
			}
		}
		
		// generate pool indexes
		for (Instruction i : new ArrayList<>(instructions))
			i.prime();
		
		// rebuild pc
		int pc = 0;
		for (Instruction i : instructions)
		{
			i.setPc(pc);
			pc += i.getLength();
		}
		
		ByteArrayOutputStream b = new ByteArrayOutputStream();
		DataOutputStream o = new DataOutputStream(b);
		for (Instruction i : instructions)
		{
			assert o.size() == i.getPc();
			i.write(o);
			assert o.size() == i.getPc() + i.getLength();
		}
		byte[] ba = b.toByteArray();
		out.writeInt(ba.length);
		out.write(ba);
	}
	
	public Code getCode()
	{
		return code;
	}
	
	public Instruction findInstruction(int pc)
	{
		for (Instruction i : instructions)
			if (i.getPc() == pc)
				return i;
		return null;
	}
	
	public void lookup()
	{
		for (Instruction i : instructions)
			i.lookup();
	}
	
	public void regeneratePool()
	{
		for (Instruction i : instructions)
			i.regeneratePool();
	}

	public void replace(Instruction oldi, Instruction newi)
	{
		assert oldi != newi;
		
		assert oldi.getInstructions() == this;
		assert newi.getInstructions() == this;
		
		assert instructions.contains(oldi);
		assert !instructions.contains(newi);
		
		int i = instructions.indexOf(oldi);
		instructions.remove(oldi);
		oldi.setInstructions(null);
		instructions.add(i, newi);

		for (Instruction ins : instructions)
			ins.replace(oldi, newi);
		
		for (net.runelite.asm.attributes.code.Exception e : code.getExceptions().getExceptions())
			e.replace(oldi, newi);
	}
}
