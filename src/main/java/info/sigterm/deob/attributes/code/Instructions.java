package info.sigterm.deob.attributes.code;

import info.sigterm.deob.attributes.Code;
import info.sigterm.deob.attributes.code.instruction.types.JumpingInstruction;
import info.sigterm.deob.attributes.code.instructions.LDC;

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
	private List<Block> blocks = new ArrayList<>();

	public Instructions(Code code) throws IOException
	{
		this.code = code;
		DataInputStream is = code.getAttributes().getStream();

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

				instructions.add(ins);

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
	
	public List<Block> getBlocks()
	{
		return blocks;
	}
	
	public void remove(Instruction ins)
	{
		ins.remove();
		instructions.remove(ins);
	}
	
	public void remove(Block block)
	{
		blocks.remove(block);
		
		for (Instruction i : block.instructions)
		{
			i.block = null;
			remove(i);
		}
	}
	
	private void findExceptionInfo(Block block, Instruction i)
	{
		for (Exception e : code.getExceptions().getExceptions())
		{
			if (i.getPc() >= e.getStart().getPc() && i.getPc() < e.getEnd().getPc())
			{
				block.exceptions.add(e);
			}
			if (e.getHandler() == i)
			{
				block.handlers.add(e);
			}
		}
	}
	
	public void buildBlocks()
	{
		clearBlockGraph();
		
		Block current = null;
		for (Instruction i : instructions)
		{
			if (current == null)
			{
				current = new Block();
				current.begin = i;
				findExceptionInfo(current, i);
			}
			i.block = current;
			current.instructions.add(i);
			if (i.isTerminal())
			{
				current.end = i;
				blocks.add(current);
				current = null;
			}
		}
	}
	
	public void clearBlockGraph()
	{
		for (Instruction i : instructions)
			i.block = null;
		blocks.clear();
	}
	
	public void write(DataOutputStream out) throws IOException
	{
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
	
	public void clearJumpGraph()
	{
		for (Instruction i : instructions)
		{
			i.jump.clear();
			i.from.clear();
		}
	}

	public void buildJumpGraph()
	{
		clearJumpGraph();
		
		for (Instruction i : instructions)
			if (i instanceof JumpingInstruction)
				((JumpingInstruction) i).buildJumpGraph();
	}

	public void buildInstructionGraph()
	{
		for (Instruction i : instructions)
			i.buildInstructionGraph();
	}
	
	public void buildCallGraph()
	{
		for (Instruction i : instructions)
			i.buildCallGraph();
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
}
