package net.runelite.asm.execution;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import net.runelite.asm.attributes.code.Instruction;

public class WeakInstructionContext
{
	private Instruction ins;
	private List<Instruction> stack = new ArrayList<>();

	public WeakInstructionContext(Instruction ins)
	{
		this.ins = ins;
	}

	public void addStack(Instruction i)
	{
		stack.add(i);
	}

	@Override
	public int hashCode()
	{
		int hash = 3;
		hash = 37 * hash + Objects.hashCode(this.ins);
		hash = 37 * hash + Objects.hashCode(this.stack);
		return hash;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
		{
			return true;
		}
		if (obj == null)
		{
			return false;
		}
		if (getClass() != obj.getClass())
		{
			return false;
		}
		final WeakInstructionContext other = (WeakInstructionContext) obj;
		if (!Objects.equals(this.ins, other.ins))
		{
			return false;
		}
		if (!Objects.equals(this.stack, other.stack))
		{
			return false;
		}
		return true;
	}
}
