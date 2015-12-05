package net.runelite.deob.deobfuscators.rename.graph;

import java.util.Arrays;
import java.util.Objects;
import net.runelite.deob.attributes.code.instruction.types.DupInstruction;
import net.runelite.deob.execution.InstructionContext;
import net.runelite.deob.execution.StackContext;

public class Edge
{
	private final InstructionContext ins;
	private final Vertex from, to;
	private final EdgeType type;
	private int weight;

	public Edge(InstructionContext ins, Vertex from, Vertex to, EdgeType type)
	{
		this.ins = ins;
		this.from = from;
		this.to = to;
		this.type = type;
		
		assert from.getGraph() == to.getGraph();
	}

	public InstructionContext getIns()
	{
		return ins;
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
	
	public void increase()
	{
		++weight;
	}
	
	public int getWeight()
	{
		return weight;
	}

	@Override
	public String toString()
	{
		return "Edge{" + "from=" + from + ", to=" + to + ", type=" + type + '}';
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
	
	public boolean couldBeEqual(Edge other)
	{	
		if (this.type != other.type)
			return false;

		if (this.type == EdgeType.SETFIELD)
		{
			if (!compareSetField(other.getIns()))
				return false;
		}
//		if (this.weight != other.weight)
//			return false;
		
		return true;
	}
	
	private InstructionContext handleDup(InstructionContext i, StackContext sctx)
	{
		DupInstruction d = (DupInstruction) i.getInstruction();
		return d.getOriginal(sctx).getPushed();
	}
	
	private boolean compareSetField(InstructionContext other)
	{
		InstructionContext thisp = ins.getPops().get(0).getPushed(),
			otherp = other.getPops().get(0).getPushed();
		
		if (thisp.getInstruction() instanceof DupInstruction)
		{
			thisp = handleDup(thisp, ins.getPops().get(0));
		}
		if (otherp.getInstruction() instanceof DupInstruction)
		{
			otherp = handleDup(otherp, other.getPops().get(0));
		}
		
		Class[] c1 = thisp.getInstruction().getClass().getInterfaces(),
			c2 = otherp.getInstruction().getClass().getInterfaces();
		
		return Arrays.equals(c1, c2);
	}
}
