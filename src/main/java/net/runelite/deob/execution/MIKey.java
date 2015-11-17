package net.runelite.deob.execution;

import java.util.Objects;

class MIKey
{
	private int prevVertex;
	private InstructionContext ictx;

	public MIKey(int prevVertex, InstructionContext ictx)
	{
		this.prevVertex = prevVertex;
		this.ictx = ictx;
	}

	@Override
	public int hashCode()
	{
		int hash = 7;
		hash = 97 * hash + this.prevVertex;
		hash = 97 * hash + Objects.hashCode(this.ictx);
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
		final MIKey other = (MIKey) obj;
		if (this.prevVertex != other.prevVertex)
		{
			return false;
		}
		if (!Objects.equals(this.ictx, other.ictx))
		{
			return false;
		}
		return true;
	}
}
