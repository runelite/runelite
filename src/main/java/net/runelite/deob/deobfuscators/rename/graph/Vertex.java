package net.runelite.deob.deobfuscators.rename.graph;

import com.google.common.base.Objects;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import net.runelite.deob.ClassFile;
import net.runelite.deob.Field;
import net.runelite.deob.Method;
import net.runelite.deob.attributes.AttributeType;
import net.runelite.deob.attributes.Code;
import net.runelite.deob.attributes.ConstantValue;
import net.runelite.deob.attributes.code.Instruction;
import net.runelite.deob.attributes.code.instruction.types.PushConstantInstruction;
import net.runelite.deob.deobfuscators.rename.Rename2;
import net.runelite.deob.pool.PoolEntry;
import org.apache.commons.collections4.CollectionUtils;

public class Vertex
{
	private Graph graph;
	private Object object;
	private VertexType type;
	
	private final Map<Edge, Edge> edges = new HashMap<>();
	
	private Collection<Vertex> mightBe;
	private Vertex is;

	public Vertex(Graph graph, Object object)
	{
		this.graph = graph;
		this.object = object;
		if (object instanceof Method)
			type = VertexType.METHOD;
		else if (object instanceof Field)
			type = VertexType.FIELD;
		else
			assert false;
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
		Edge c = edges.get(edge);
		if (c != null)
		{
			c.increase();
			return;
		}
		
		edges.put(edge, edge);
	}
	
	public Set<Edge> getEdges()
	{
		return edges.keySet();
	}
	
	public void merge(Collection<Vertex> maybe)
	{
		// mightBe and maybe
		
		if (mightBe == null)
			mightBe = maybe;
		else
			mightBe = CollectionUtils.intersection(mightBe, maybe);
	}
	
	public void finish()
	{
		if (mightBe != null && mightBe.size() == 1)
		{
			is(mightBe.stream().findAny().get());
			is.is(this);
			mightBe = null;
		}
	}

	public void is(Vertex other)
	{
		if (is != null)
		{
			assert graph != other.graph;
			assert is.graph == other.graph;
			Rename2.collide(object, is.object, other.object);
		}
		assert is == null;
		assert other.graph != graph;
		
		this.is = other;
	}
	
	public Vertex getOther()
	{
		return is;
	}
	
	private boolean couldBeEqual(ClassFile cf1, ClassFile cf2)
	{
		if (!cf1.getName().equals(cf2.getName()))
			return false;
		
		if (!cf1.getInterfaces().getInterfaces().equals(cf2.getInterfaces().getInterfaces()))
			return false;
		
		if (!cf1.getParentClass().equals(cf2.getParentClass()))
			return false;
		
		return true;
	}
	
	private boolean couldBeEqual(Method m1, Method m2)
	{
		Set<PoolEntry> h1 = new HashSet<>(),
			h2 = new HashSet<>();
		
		if (m1.getCode() == null)
			return true;
		
		for (Instruction i : m1.getCode().getInstructions().getInstructions())
		{
			if (i instanceof PushConstantInstruction)
			{
				PushConstantInstruction pci = (PushConstantInstruction) i;
				h1.add(pci.getConstant());
			}
		}
		
		for (Instruction i : m2.getCode().getInstructions().getInstructions())
		{
			if (i instanceof PushConstantInstruction)
			{
				PushConstantInstruction pci = (PushConstantInstruction) i;
				h2.add(pci.getConstant());
			}
		}
		
		boolean b = h1.equals(h2);
		return b;
		//return true;
	}
	
	public boolean couldBeEqual(Vertex other)
	{
		assert this != other;
		assert graph != other.graph;
		assert is == null;
		assert other.is == null;
		
		if (this.getType() != other.getType())
			return false;
		
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
			
			if (m1.getAccessFlags() != m2.getAccessFlags())
				return false;
			
			if ((m1.getCode() == null) != (m2.getCode() == null))
				return false;
			
			ClassFile cf1 = m1.getMethods().getClassFile(), cf2 = m2.getMethods().getClassFile();
			
			if (!couldBeEqual(cf1, cf2))
				return false;
			
//			if (!couldBeEqual(m1, m2))
//				return false;
		}
		else if (type == VertexType.FIELD)
		{
			Field f1 = (Field) object;
			Field f2 = (Field) other.object;
			
			if (!f1.getType().equals(f2.getType()))
				return false;
			
			if (f1.isStatic() != f2.isStatic() || f1.getAccessFlags() != f2.getAccessFlags())
				return false;
			
			if (!f1.isStatic())
			{
				ClassFile cf1 = f1.getFields().getClassFile(), cf2 = f2.getFields().getClassFile();

				if (!couldBeEqual(cf1, cf2))
					return false;
			}
			
			ConstantValue cf1 = (ConstantValue) f1.getAttributes().findType(AttributeType.CONSTANT_VALUE);
			ConstantValue cf2 = (ConstantValue) f2.getAttributes().findType(AttributeType.CONSTANT_VALUE);
			
			if (!Objects.equal(cf1, cf2))
				return false;
		}
		else
			assert false;
		
		return true;
	}
}
