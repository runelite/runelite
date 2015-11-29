package net.runelite.deob.deobfuscators.rename.graph;

import java.util.Objects;
import net.runelite.deob.Method;
import net.runelite.deob.attributes.code.Instruction;

public class MethodEdge extends Edge
{
	private final Method method;

	public MethodEdge(Instruction i, Vertex from, Vertex to, EdgeType type, Method method)
	{
		super(i, from, to, type);
		this.method = method;
	}

	@Override
	public int hashCode()
	{
		int hash = 7;
		hash = 61 * hash + Objects.hashCode(this.method);
		return hash ^ super.hashCode();
	}

	@Override
	public boolean equals(Object obj)
	{
		if (!super.equals(obj))
		{
			return false;
		}
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
		final MethodEdge other = (MethodEdge) obj;
		if (!Objects.equals(this.method, other.method))
		{
			return false;
		}
		return true;
	}
	
	
}
