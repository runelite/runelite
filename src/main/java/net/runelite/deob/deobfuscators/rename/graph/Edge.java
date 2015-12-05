package net.runelite.deob.deobfuscators.rename.graph;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import net.runelite.deob.Field;
import net.runelite.deob.Method;
import net.runelite.deob.attributes.code.Instruction;
import net.runelite.deob.attributes.code.instruction.types.DupInstruction;
import net.runelite.deob.attributes.code.instruction.types.InvokeInstruction;
import net.runelite.deob.attributes.code.instruction.types.LVTInstruction;
import net.runelite.deob.attributes.code.instruction.types.SetFieldInstruction;
import net.runelite.deob.attributes.code.instructions.InvokeStatic;
import net.runelite.deob.attributes.code.instructions.NewArray;
import net.runelite.deob.execution.InstructionContext;
import net.runelite.deob.execution.StackContext;
import net.runelite.deob.execution.VariableContext;
import net.runelite.deob.execution.Variables;

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

		if (this.type == EdgeType.SETFIELD)// || this.type == EdgeType.SETFIELD_FROM)
		{
			if (!compareSetField((Field) this.getTo().getObject(), (Field) other.getTo().getObject(), other.getIns()))
				return false;
		}
//		if (this.weight != other.weight)
//			return false;
		
		return true;
	}

	private InstructionContext resolve(
		InstructionContext ctx,
		StackContext from // pushed from ctx
	)
	{
		if (ctx.getInstruction() instanceof SetFieldInstruction)
		{
			StackContext s = ctx.getPops().get(0);
			return resolve(s.getPushed(), s);
		}
		
		if (ctx.getInstruction() instanceof DupInstruction)
		{
			DupInstruction d = (DupInstruction) ctx.getInstruction();
			StackContext s = d.getOriginal(from);
			return resolve(s.getPushed(), s);
		}
		
		if (ctx.getInstruction() instanceof LVTInstruction)
		{
			LVTInstruction lvt = (LVTInstruction) ctx.getInstruction();
			Variables variables = ctx.getVariables();
			
			if (lvt.store())
			{
				StackContext s = ctx.getPops().get(0); // is this right?
				return resolve(s.getPushed(), s);
			}
			else
			{
				VariableContext vctx = variables.get(lvt.getVariableIndex()); // variable being loaded
				assert vctx != null;

				InstructionContext storedCtx = vctx.getInstructionWhichStored();
				if (storedCtx == null)
					return ctx; // parameter?
				
				return resolve(storedCtx, null);
			}
		}
		
		return ctx;
	}
	
//	private static final String[][] map = {
//		{"field1989", "field2042"},
//		{"field164", "field2156"},
//		{"field2904", "field2881"},
//		{"field296", "field287"},
//		{"field297", "field425"},
//		{"field416", "field420"},
//		{"field329", "field331"},
//		{"field2203", "field2216"},
//		{"field2202", "field2222"},
//		{"field2100", "field2109"},
//	};
//	
//	private boolean isEqual(SetFieldInstruction sf1, SetFieldInstruction sf2)
//	{
//		for (int i = 0; i < map.length; ++i)
//		{
//			if (sf1.getMyField() != null && sf1.getMyField().getName().equals(map[i][0]) &&
//				sf2.getMyField() != null && sf2.getMyField().getName().equals(map[i][1]))
//				return true;
//		}
//		return false;
//	}
	
	private boolean compareSetField(Field field1, Field field2, InstructionContext other)
	{
		InstructionContext thisp = resolve(ins.getPops().get(0).getPushed(), ins.getPops().get(0)),
			otherp = resolve(other.getPops().get(0).getPushed(), other.getPops().get(0));

		return couldBeEqual(field1, field2, thisp, otherp);
	}
	
	private boolean couldBeEqual(Field field1, Field field2, InstructionContext one, InstructionContext two)
	{
		if (field2.getName().equals("field209"))
		{
			int i =5;
		}
		Instruction i1 = one.getInstruction(), i2 = two.getInstruction();
		
		if (i1 instanceof LVTInstruction && i2 instanceof LVTInstruction)
		{
			LVTInstruction l1 = (LVTInstruction) i1, l2 = (LVTInstruction) i2;
			
			assert !l1.store();
			assert !l2.store();
			
			VariableContext v1 = one.getVariables().get(l1.getVariableIndex()),
				v2 = two.getVariables().get(l2.getVariableIndex());
			
			assert v1.getInstructionWhichStored() == null;
			assert v2.getInstructionWhichStored() == null;
			
			return v1.getType().equals(v2.getType());
		}
		
		if (i1 instanceof NewArray && i2 instanceof NewArray)
		{
			NewArray a1 = (NewArray) i1, a2 = (NewArray) i2;
			return a1.getArrayType() == a2.getArrayType();
		}
		
		// XXX check for invokestatic vs.
		if (i1 instanceof InvokeInstruction && i2 instanceof InvokeInstruction)
		{
			InvokeInstruction ii1 = (InvokeInstruction) i1, ii2 = (InvokeInstruction) i2;
			
			List<Method> methods1 = ii1.getMethods(), methods2 = ii2.getMethods();

			if (methods1.size() != methods2.size())
			{
				return false;
			}
			
			if (methods1.isEmpty())
			{
				// compare pool Method
				return ii1.getMethod().equals(ii2.getMethod());
			}
			
			Method m1 = methods1.get(0), m2 = methods2.get(0);
			
			if (!m1.getDescriptor().equals(m2.getDescriptor()))
				return false;
		}
		else if (i1 instanceof InvokeStatic || i2 instanceof InvokeStatic)
		{
			return true;
			//int i = 5;
		}
		
		if (!i1.getClass().equals(i2.getClass()))
		{
			return false;
		}
		
		return true;
	}
}
