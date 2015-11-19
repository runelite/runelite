package net.runelite.deob.deobfuscators.rename.graph;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import net.runelite.deob.ClassFile;
import net.runelite.deob.Field;
import net.runelite.deob.Method;
import net.runelite.deob.deobfuscators.rename.Rename2;
import org.apache.commons.collections4.CollectionUtils;

public class Vertex
{
	private Graph graph;
	private Object object;
	private VertexType type;
	
	private Set<Edge> edges = new HashSet<>();
	
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
	
	public boolean addEdge(Edge edge)
	{
		return edges.add(edge);
	}
	
	public Set<Edge> getEdges()
	{
		return edges;
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
			
			ClassFile cf1 = m1.getMethods().getClassFile(), cf2 = m2.getMethods().getClassFile();
			
			if (!couldBeEqual(cf1, cf2))
				return false;
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
		}
		else
			assert false;
		
		return true;
	}
}
