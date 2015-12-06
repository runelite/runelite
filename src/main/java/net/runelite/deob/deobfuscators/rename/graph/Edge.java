package net.runelite.deob.deobfuscators.rename.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import net.runelite.deob.Field;
import net.runelite.deob.Method;
import net.runelite.deob.attributes.code.Instruction;
import net.runelite.deob.attributes.code.instruction.types.DupInstruction;
import net.runelite.deob.attributes.code.instruction.types.FieldInstruction;
import net.runelite.deob.attributes.code.instruction.types.GetFieldInstruction;
import net.runelite.deob.attributes.code.instruction.types.InvokeInstruction;
import net.runelite.deob.attributes.code.instruction.types.LVTInstruction;
import net.runelite.deob.attributes.code.instruction.types.PushConstantInstruction;
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
			if (!compareSetField(getGraph(), other.getGraph(),
				(Field) this.getTo().getObject(), (Field) other.getTo().getObject(),
				other.getIns()))
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
					return ctx; // initial parameter
				
				if (vctx.isIsParameter())
					return ctx; // parameter (storedCtx is invoking instruction in another frame). this lvt index is fixed.
				
				return resolve(storedCtx, null);
			}
		}
		
		return ctx;
	}
	
	private List<InstructionContext> resolveUp(
		List<InstructionContext> ctxs,
		StackContext from // popped by ctxs
	)
	{
		List<InstructionContext> list = new ArrayList<>();
		
		for (InstructionContext ctx : ctxs)
		{
			if (ctx.getInstruction() instanceof DupInstruction)
			{
				DupInstruction d = (DupInstruction) ctx.getInstruction();
				//StackContext s = d.
				//return resolve(s.getPushed(), s);
			}

			list.add(ctx);
		}
		
		return list;
//		if (ctx.getInstruction() instanceof SetFieldInstruction)
//		{
//			StackContext s = ctx.getPops().get(0);
//			return resolve(s.getPushed(), s);
//		}
//		

//		
//		if (ctx.getInstruction() instanceof LVTInstruction)
//		{
//			LVTInstruction lvt = (LVTInstruction) ctx.getInstruction();
//			Variables variables = ctx.getVariables();
//			
//			if (lvt.store())
//			{
//				StackContext s = ctx.getPops().get(0); // is this right?
//				return resolve(s.getPushed(), s);
//			}
//			else
//			{
//				VariableContext vctx = variables.get(lvt.getVariableIndex()); // variable being loaded
//				assert vctx != null;
//
//				InstructionContext storedCtx = vctx.getInstructionWhichStored();
//				if (storedCtx == null)
//					return ctx; // parameter?
//				
//				return resolve(storedCtx, null);
//			}
//		}
		
	//	return ctx;
	}
	
	private boolean compareSetField(Graph g1, Graph g2, Field field1, Field field2, InstructionContext other)
	{
		InstructionContext thisp = resolve(ins.getPops().get(0).getPushed(), ins.getPops().get(0)),
			otherp = resolve(other.getPops().get(0).getPushed(), other.getPops().get(0));

		return couldBeEqual(g1, g2, field1, field2, thisp, otherp, null);
	}
	
	private boolean couldBeEqual(Graph g1, Graph g2, Field field1, Field field2, InstructionContext one, InstructionContext two, InstructionContext from)
	{
		Instruction i1 = one.getInstruction(), i2 = two.getInstruction();
		
		if (i1 instanceof LVTInstruction && i2 instanceof LVTInstruction)
		{
			LVTInstruction l1 = (LVTInstruction) i1, l2 = (LVTInstruction) i2;
			
			assert !l1.store();
			assert !l2.store();
			
			VariableContext v1 = one.getVariables().get(l1.getVariableIndex()),
				v2 = two.getVariables().get(l2.getVariableIndex());
			
			assert v1.isIsParameter();
			assert v2.isIsParameter();
			
			// resolve() resolves these unless they are parameters, so compare indexes
			if (l1.getVariableIndex() != l2.getVariableIndex())
				return false;
			
			return v1.getType().equals(v2.getType());
		}
		
		if (i1 instanceof NewArray && i2 instanceof NewArray)
		{
			NewArray a1 = (NewArray) i1, a2 = (NewArray) i2;
			if (a1.getArrayType() != a2.getArrayType())
				return false;
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
		}
		
		if (i1 instanceof FieldInstruction && i2 instanceof FieldInstruction)
		{
			assert i1 instanceof GetFieldInstruction;
			assert i2 instanceof GetFieldInstruction;
			
			GetFieldInstruction gf1 = (GetFieldInstruction) i1, gf2 = (GetFieldInstruction) i2;
			Field f1 = gf1.getMyField(), f2 = gf2.getMyField();
			
			if ((f1 != null) != (f2 != null))
				return false;
			
			//if (f1 == null || f2 == null)
			//	return
			
			if (!f1.getType().equals(f2.getType()))
				return false;
			
			// lookup already solved fields.
			
			Vertex v1 = g1.getVertexFor(f1), v2 = g2.getVertexFor(f2); // vertex of fields whose value is being set to
			
			// get solved field
			v1 = v1.getOther();
			v2 = v2.getOther();
			
			if ((v1 != null) != (v2 != null))
				return false;
			
			if (v1 != null || v2 != null)
			{
				if (v1.getObject() != f2 || v2.getObject() != f1)
					return false;
			}
		}
		
		if (i1 instanceof PushConstantInstruction && i2 instanceof PushConstantInstruction)
		{
			PushConstantInstruction pc1 = (PushConstantInstruction) i1, pc2 = (PushConstantInstruction) i2;
			
			return pc1.getConstant().equals(pc2.getConstant());
		}
		
		if (!i1.getClass().equals(i2.getClass()))
		{
			return false;
		}
		
		// check down
		assert one.getPops().size() == two.getPops().size();
		for (int i = 0; i < one.getPops().size(); ++i)
		{
			StackContext s1 = one.getPops().get(i), s2 = two.getPops().get(i);
			
			if (resolve(s1.getPushed(), s1) == from)
				continue;
			
			if (!couldBeEqual(
				g1, g2,
				field1, field2,
				resolve(s1.getPushed(), s1),
				resolve(s2.getPushed(), s2),
				one
			))
				return false;
		}
		
		// check up
//		assert one.getPushes().size() == two.getPushes().size();
//		for (int i = 0; i < one.getPushes().size(); ++i)
//		{
//			StackContext s1 = one.getPushes().get(i), s2 = two.getPushes().get(i);
//			List<InstructionContext> p1 = s1.getPopped(), p2 = s2.getPopped(); // instructions which popped the push
//			
//			assert p1.size() == p2.size();
//			
//			//resolveUp(p1, s1);
//			
//			for (int j = 0; j < p1.size(); ++i)
//			{
//				InstructionContext ic1 = p1.get(j), ic2 = p2.get(j);
//				
//				if (from == ic1)
//					continue;
//				
////				resolveUp(ic1, s1);
////				resolveUp(ic2, s2);
//				
//				if (!couldBeEqual(
//					field1, field2,
//					ic1, ic2,
//					one
//				)) {}
//					//return false;
//			}
//		}
		
		return true;
	}
	
	private Graph getGraph()
	{
		assert from.getGraph() == to.getGraph();
		return from.getGraph();
	}
}
