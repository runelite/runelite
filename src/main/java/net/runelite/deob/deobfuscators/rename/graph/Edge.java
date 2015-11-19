package net.runelite.deob.deobfuscators.rename.graph;

import java.util.Objects;

public class Edge
{
	private final Vertex from, to;

	public Edge(Vertex from, Vertex to)
	{
		this.from = from;
		this.to = to;
		
		assert from.getGraph() == to.getGraph();
	}

	public Vertex getFrom()
	{
		return from;
	}

	public Vertex getTo()
	{
		return to;
	}

	@Override
	public int hashCode()
	{
		int hash = 7;
		hash = 11 * hash + Objects.hashCode(this.from);
		hash = 11 * hash + Objects.hashCode(this.to);
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
		final Edge other = (Edge) obj;
		if (!Objects.equals(this.from, other.from))
		{
			return false;
		}
		if (!Objects.equals(this.to, other.to))
		{
			return false;
		}
		return true;
	}
	
	
}
