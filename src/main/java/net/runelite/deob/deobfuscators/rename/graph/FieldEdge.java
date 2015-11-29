package net.runelite.deob.deobfuscators.rename.graph;

import net.runelite.deob.attributes.code.Instruction;

public class FieldEdge extends Edge
{
	private int id;
	
	public FieldEdge(Instruction ins, Vertex from, Vertex to, EdgeType type, int id)
	{
		super(ins, from, to, type);
		this.id = id;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (!super.equals(obj))
		{
			return false;
		}
		final FieldEdge other = (FieldEdge) obj;
		if (this.id != other.id)
		{
			return false;
		}
		return true;
	}

	@Override
	public int hashCode()
	{
		int hash = 5;
		hash = 89 * hash + this.id;
		return hash ^ super.hashCode();
	}

	
}
