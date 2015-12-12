package net.runelite.deob.deobfuscators.rename.graph;

import com.google.common.base.Objects;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import net.runelite.deob.ClassFile;
import net.runelite.deob.Field;
import net.runelite.deob.Method;
import net.runelite.deob.attributes.AttributeType;
import net.runelite.deob.attributes.Code;
import net.runelite.deob.attributes.ConstantValue;
import net.runelite.deob.attributes.code.Instruction;
import net.runelite.deob.attributes.code.instruction.types.InvokeInstruction;
import net.runelite.deob.attributes.code.instruction.types.SetFieldInstruction;
import net.runelite.deob.attributes.code.instructions.InvokeStatic;
import net.runelite.deob.deobfuscators.rename.InstructionList;
import net.runelite.deob.deobfuscators.rename.Rename2;
import org.apache.commons.collections4.CollectionUtils;

public class Vertex
{
	private static final int FIELD_MASK = Field.ACC_FINAL | Field.ACC_STATIC;
	private static final int METHOD_MASK = Method.ACC_ABSTRACT | Method.ACC_FINAL | Method.ACC_STATIC | Method.ACC_SYNCHRONIZED;
	
	private Graph graph;
	private final Object object;
	private VertexType type;
	
	private final Set<Edge> edges = new HashSet<>();
	
	private Collection<Vertex> mightBe;
	private Vertex is;
	
	//private Set<Instruction> edgeFrom = new HashSet<>();

	public Vertex(Graph graph, Object object)
	{
		this.graph = graph;
		this.object = object;
		if (object instanceof Method)
			type = VertexType.METHOD;
		else if (object instanceof Field)
			type = VertexType.FIELD;
		else if (object instanceof ClassFile)
			type = VertexType.CLASS;
		else
			assert false;
	}

	@Override
	public String toString()
	{
		return "Vertex{" + "object=" + object + '}';
	}

	@Override
	public int hashCode()
	{
		int hash = 7;
		hash = 79 * hash + java.util.Objects.hashCode(this.object);
		return hash;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (obj == null)
		{
			return false;
		}
		if (getClass() != obj.getClass())
		{
			return false;
		}
		final Vertex other = (Vertex) obj;
		if (!java.util.Objects.equals(this.object, other.object))
		{
			return false;
		}
		return true;
	}

	public Graph getGraph()
	{
		return graph;
	}

	public Object getObject()
	{
		return object;
	}

	public VertexType getType()
	{
		return type;
	}

	public void setType(VertexType type)
	{
		this.type = type;
	}
	
	public void addEdge(Edge edge)
	{
		if (edges.contains(edge))
		//if (c != null)
		{
//			if (edge.getIns() instanceof SetFieldInstruction && !edgeFrom.contains(edge.getIns()))
//			{
//				edgeFrom.add(edge.getIns());
//				c.increase();
//			}
			return;
		}
		
		edges.add(edge);
		//edges.put(edge, edge);
	}
	
	public Set<Edge> getEdges()
	{
		return edges;
	}
	
	public void merge(Collection<Vertex> maybe)
	{
		boolean b = false;
		if (this.object instanceof Method)
		{
			Method m = (Method) object;
			
			if (m.getName().equals("method2566"))
			{
				b = true;
			}
		}
		
		if (mightBe == null)
			mightBe = maybe;
		else
		{
			int old = mightBe.size();
			mightBe = CollectionUtils.intersection(mightBe, maybe);
			if (b && old == 1 && mightBe.isEmpty())
			{
				int i = 6;
			}
		}
	}
	
	public void finish()
	{
		if (this.toString().equals("Vertex{object=class207.<init>()V}"))
		{
			int i =5;
		}
		
		if (mightBe == null)
			return;
		
		if (mightBe != null && mightBe.size() > 1)
		{
	//		System.out.println("Can't decide for " + this);
			
	//		for(Vertex v : mightBe)
	//			System.out.println(v);
	//		int i = 5;
		}
		if (mightBe.isEmpty())
		{
			System.out.println("empty " + this);
			int i = 5;
		}
		if (mightBe != null && mightBe.size() == 1)
		{
			Vertex v = mightBe.stream().findAny().get();
			
			//if (v.getOther() == null || v.getOther() == this)
			{
				is(v);
				is.is(this);
				mightBe = null;
				System.out.println(this + " is " + is);
			}
			
			if (object instanceof Method)
			{
				//Method m = (Method) object;
				//if (m.getName().equals
			}
		}
	}

	public void is(Vertex other)
	{
		if (is != null)
		{
			assert is.is == this;
			is.is = null;
			is = null;

			//Rename2.collide(object, is.object, other.object);
		}
		assert is == null;
		assert other.graph != graph;
		
		if (object instanceof Method)
		{
			Method thism = (Method) object;
			Method otherm = (Method) other.object;
		
			assert thism.getMethods().getClassFile().getName().equals(otherm.getMethods().getClassFile().getName());
		}
		
		this.is = other;
	}
	
	public Vertex getOther()
	{
		return is;
	}
	
	private boolean couldBeEqual(ClassFile cf1, ClassFile cf2)
	{
		if (!cf1.getClassName().equals(cf2.getClassName()))
			return false;
		
		if (!cf1.getInterfaces().getInterfaces().equals(cf2.getInterfaces().getInterfaces()))
			return false;
		
		if (!cf1.getParentClass().equals(cf2.getParentClass()))
			return false;
		
		return true;
	}
	
	private List<Instruction> getInstructionsInMethodInclStatic(Method method, Set<Method> visited)
	{
		List<Instruction> ilist = new ArrayList<>();
		
		if (visited.contains(method))
			return ilist;
		visited.add(method);
		
		Code code = method.getCode();
		if (code == null)
			return ilist;
		
		for (Instruction i : code.getInstructions().getInstructions())
		{
			if (i instanceof InvokeStatic)
			{
				InvokeInstruction ii = (InvokeInstruction) i;
				List<Method> methods = ii.getMethods();
				
				if (methods.isEmpty())
					continue;
				
				Method m = methods.get(0);
				ilist.addAll(this.getInstructionsInMethodInclStatic(m, visited));
			}
			else
			{
				ilist.add(i);
			}
		}
		
		return ilist;
	}
	
	private boolean couldBeEqual(Method m1, Method m2)
	{
		InstructionList il1 = new InstructionList(this.getInstructionsInMethodInclStatic(m1, new HashSet())),
			il2 = new InstructionList(this.getInstructionsInMethodInclStatic(m2, new HashSet()));
		return il1.couldBeEqual(il2);
	}
	
	private static boolean recurse = true;
	public boolean couldBeEqual(Vertex other)
	{
		assert this != other;
		assert graph != other.graph;
//		assert is == null;
		//assert other.is == null;
		
		if (this.getOther() != null || other.getOther() != null)
		{
			return this.getOther() == other && other.getOther() == this;
		}
		
		if (this.getType() != other.getType())
			return false;

//		if (this.getEdges().size() != other.getEdges().size())
//			return false;
//
//		for (EdgeType e : EdgeType.values())
//		{
//			// for each edge of this type, it must be equal with just one of the others
//
//			if (this.edgesOf(e) != other.edgesOf(e))// ||
//				//this.solvedEdgesOfType(e) != other.solvedEdgesOfType(e))
//			{
//				int thise = edgesOf(e), othere = other.edgesOf(e);
//				int thisse = this.solvedEdgesOfType(e), otherse = other.solvedEdgesOfType(e);
//				return false;
//			}
//		}

		// must be 1->1
		// map v -> possibles
		// start with the ones with the least possibilities
		
//		if (recurse)
//		{
//			Set<Edge> others = new HashSet<>(other.getEdges());
//			for (Edge e : edges.values())
//			{
//				Vertex v = e.getTo();
//
//				boolean found = false;
//				List<Vertex> lv = new ArrayList();
//				for (Edge e2 : others)
//				{
//					Vertex v2 = e2.getTo();
//					lv.add(v2);
//
//					recurse = false;
//					if (v.couldBeEqual(v2))
//				//	if (e.couldBeEqual(e2))
//					{
//						recurse = true;
//					//	others.remove(e2);
//						found = true;
//						break;
//					}
//					recurse = true;
//				}
//
//				if (!found)
//				{
//					Vertex v2 = null;
//					for (Vertex vt : lv)
//						if (vt.getObject() instanceof Method)
//						{
//							Method m = (Method) vt.getObject();
//							if (m.getName().equals("vmethod2975"))
//							{
//								v2 = vt;
//								break;
//							}
//						}
//					//v.couldBeEqual(v2);
//					return false;
//				}
//			}
//		}
		
		if (this.getType() == VertexType.METHOD)
		{
			Method m1 = (Method) object;
			Method m2 = (Method) other.object;
			
			assert !m1.isStatic();
			assert !m2.isStatic();
			
			if (m1.getName().equals("<init>") != m2.getName().equals("<init>"))
				return false;
			
			if (!m1.getDescriptor().equals(m2.getDescriptor()))
				return false;
			
			if ((m1.getAccessFlags() & METHOD_MASK) != (m2.getAccessFlags() & METHOD_MASK))
				return false;
			
			if ((m1.getCode() == null) != (m2.getCode() == null))
				return false;
			
			ClassFile cf1 = m1.getMethods().getClassFile(), cf2 = m2.getMethods().getClassFile();
			
			if (!couldBeEqual(cf1, cf2))
				return false;
			
			if (!couldBeEqual(m1, m2))
				return false;
		}
		else if (type == VertexType.FIELD)
		{
			Field f1 = (Field) object;
			Field f2 = (Field) other.object;
			
			if (!f1.getType().equals(f2.getType()))
				return false;
	
			if ((f1.getAccessFlags() & FIELD_MASK) != (f2.getAccessFlags() & FIELD_MASK))
				return false;
			
			if (!f1.isStatic())
			{
				ClassFile cf1 = f1.getFields().getClassFile(), cf2 = f2.getFields().getClassFile();

				if (!couldBeEqual(cf1, cf2))
					return false;
			}
			
			// compare other edges, 
			
			ConstantValue cf1 = (ConstantValue) f1.getAttributes().findType(AttributeType.CONSTANT_VALUE);
			ConstantValue cf2 = (ConstantValue) f2.getAttributes().findType(AttributeType.CONSTANT_VALUE);
			
			//if (!Objects.equal(cf1, cf2))
			//	return false;
		}
		else
			assert false;
		
		return true;
	}
	
	private int edgesOf(EdgeType type)
	{
		int t = 0;
		for (Edge e : this.edges)
			if (e.getType() == type)
				++t;
		return t;
	}
	
	private int solvedEdgesOfType(EdgeType type)
	{
		return (int) edges.stream().filter(e -> e.getType() == type).filter(e -> e.getTo().getOther() != null).count();
	}
}
