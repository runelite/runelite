package info.sigterm.deob.attributes.code.instructions;

import info.sigterm.deob.attributes.code.Instruction;
import info.sigterm.deob.attributes.code.InstructionType;
import info.sigterm.deob.attributes.code.Instructions;
import info.sigterm.deob.execution.Frame;
import info.sigterm.deob.execution.Path;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class LookupSwitch extends Instruction
{
	private int def;
	private int count;
	private int[] match;
	private int[] branch;

	public LookupSwitch(Instructions instructions, InstructionType type, int pc) throws IOException
	{
		super(instructions, type, pc);

		DataInputStream is = instructions.getCode().getAttributes().getStream();

		int tableSkip = 4 - (pc + 1) % 4;
		if (tableSkip == 4) tableSkip = 0;
		if (tableSkip > 0) is.skip(tableSkip);

		def = is.readInt();

		count = is.readInt();
		match = new int[count];
		branch = new int[count];

		for (int i = 0; i < count; ++i)
		{
			match[i] = is.readInt();
			branch[i] = is.readInt();
		}

		length += tableSkip + 8 + (count * 8);
	}
	
	@Override
	public void write(DataOutputStream out, int pc) throws IOException
	{
		super.write(out, pc);
		
		int tableSkip = 4 - (pc + 1) % 4;
		if (tableSkip == 4) tableSkip = 0;
		if (tableSkip > 0) out.write(new byte[tableSkip]);
		
		out.writeInt(def);
		
		out.writeInt(count);
		for (int i = 0; i < count; ++i)
		{
			out.writeInt(match[i]);
			out.writeInt(branch[i]);
		}
	}

	@Override
	public void buildJumpGraph()
	{
		for (int i : branch)
			this.addJump(i);
		this.addJump(def);
	}

	@Override
	public void execute(Frame e)
	{
		e.getStack().pop();
		
		for (int i : branch)
		{
			Path p = e.getPath().dup();
			p.getCurrentFrame().jump(i);
		}
		
		Path p = e.getPath().dup();
		p.getCurrentFrame().jump(def);
	}
}
