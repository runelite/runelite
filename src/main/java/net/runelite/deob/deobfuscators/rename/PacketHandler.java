package net.runelite.deob.deobfuscators.rename;

import java.util.List;
import net.runelite.deob.attributes.code.Instruction;
import net.runelite.deob.attributes.code.instructions.If;
import net.runelite.deob.attributes.code.instructions.IfICmpEq;
import net.runelite.deob.attributes.code.instructions.IfICmpNe;

public class PacketHandler
{
	private final If branchInstruction;
	private final int packetId;

	public PacketHandler(If branchInstruction, int packetId)
	{
		this.branchInstruction = branchInstruction;
		this.packetId = packetId;
	}

	public If getBranchInstruction()
	{
		return branchInstruction;
	}

	public int getPacketId()
	{
		return packetId;
	}

	@Override
	public String toString()
	{
		return "PacketHandler{" + "packetId=" + packetId + '}';
	}

	public Instruction getFirstInsOfHandler()
	{
		if (branchInstruction instanceof IfICmpNe)
		{
			List<Instruction> ins = branchInstruction.getInstructions().getInstructions();
			int idx = ins.indexOf(branchInstruction);
			assert idx != -1;
			return ins.get(idx + 1);
		}
		else if (branchInstruction instanceof IfICmpEq)
		{
			List<Instruction> jumps = branchInstruction.getJumps();
			assert jumps.size() == 1;
			return jumps.get(0);
		}
		else
		{
			assert false;
			return null;
		}
	}
}
