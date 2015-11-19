package net.runelite.deob.deobfuscators.rename.graph;

import java.util.Objects;

public class Edge
{
	private final Vertex from, to;
	private final EdgeType type;

	public Edge(Vertex from, Vertex to, EdgeType type)
	{
		this.from = from;
		this.to = to;
		this.type = type;
		
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

	public EdgeType getType()
	{
		return type;
	}	

	@Override
	public int hashCode()
	{
		int hash = 5;
		hash = 89 * hash + Objects.hashCode(this.from);
		hash = 89 * hash + Objects.hashCode(this.to);
		hash = 89 * hash + Objects.hashCode(this.type);
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
		if (this.type != other.type)
		{
			return false;
		}
		return true;
	}
}
