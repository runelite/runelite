package net.runelite.deob.deobfuscators.rename.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graph
{
	private List<Vertex> verticies = new ArrayList<>();
	
	private Map<Object, Vertex> o2v = new HashMap<>();
	private int edgeCount;
	
	public Vertex getVertexFor(Object o)
	{
		Vertex v = o2v.get(o);
		if (v != null)
			return v;
		
		v = new Vertex(this, o);
		o2v.put(o, v);
		verticies.add(v);
		return v;
	}
	
	public void addEdge(Object from, Object to)
	{
		assert from != null;
		assert to != null;
		
		Vertex v1 = getVertexFor(from), v2 = getVertexFor(to);
		
		Edge e = new Edge(v1, v2);
		if (v1.addEdge(e))
			++edgeCount;
	}

	public List<Vertex> getVerticies()
	{
		return verticies;
	}
	
	public int vertexCount()
	{
		return verticies.size();
	}
	
	public int edgeCount()
	{
		return edgeCount;
	}

	@Override
	public String toString()
	{
		return "Graph{" + "verticies=" + verticies.size() + ", edgeCount=" + edgeCount + '}';
	}
	
	public void check()
	{
		for (Vertex v : verticies)
		{
			if (v.getOther() != null)
			{
				assert v.getOther().getOther() == v;
			}
		}
	}
	
	public int solved(VertexType type)
	{
		int solved = 0;
		for (Vertex v : verticies)
			if (v.getOther() != null && (type == null || v.getType() == type))
				++solved;
		return solved;
	}
}
