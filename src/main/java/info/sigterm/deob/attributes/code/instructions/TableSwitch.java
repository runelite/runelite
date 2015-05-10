package info.sigterm.deob.attributes.code.instructions;

import info.sigterm.deob.attributes.code.Instruction;
import info.sigterm.deob.attributes.code.InstructionType;
import info.sigterm.deob.attributes.code.Instructions;
import info.sigterm.deob.execution.Frame;
import info.sigterm.deob.execution.Path;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class TableSwitch extends Instruction
{
	private int def;
	private int low;
	private int high;
	private int[] jumps;

	public TableSwitch(Instructions instructions, InstructionType type, int pc) throws IOException
	{
		super(instructions, type, pc);

		DataInputStream is = instructions.getCode().getAttributes().getStream();

		int tableSkip = 4 - (pc + 1) % 4;
		if (tableSkip == 4) tableSkip = 0;
		if (tableSkip > 0) is.skip(tableSkip);

		def = is.readInt();
		low = is.readInt();
		high = is.readInt();

		int count = high - low + 1;
		jumps = new int[count];

		for (int i = 0; i < count; ++i)
			jumps[i] = is.readInt();

		length += tableSkip + 12 + (count * 4);
	}
	
	@Override
	public void write(DataOutputStream out, int pc) throws IOException
	{
		super.write(out, pc);
		
		int tableSkip = 4 - (pc + 1) % 4;
		if (tableSkip == 4) tableSkip = 0;
		if (tableSkip > 0) out.write(new byte[tableSkip]);
		
		out.writeInt(def);
		out.writeInt(low);
		out.writeInt(high);
		
		for (int i = 0; i < high - low + 1; ++i)
			out.writeInt(jumps[i]);
	}

	@Override
	public void buildJumpGraph()
	{
		for (int i : jumps)
			this.addJump(i);
		this.addJump(def);
	}

	@Override
	public void execute(Frame e)
	{
		e.getStack().pop();
		
		for (int i : jumps)
		{
			Path p = e.getPath().dup();
			p.getCurrentFrame().jump(i);
		}
		
		Path p = e.getPath().dup();
		p.getCurrentFrame().jump(def);
	}
	
	@Override
	public boolean isTerminal()
	{
		return true;
	}
}
