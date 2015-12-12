package net.runelite.deob.deobfuscators.rename.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Graph
{
	private List<Vertex> verticies = new ArrayList<>();
	
	private Map<Object, Vertex> o2v = new HashMap<>();
	
//	public Vertex getVertexFor(Object o)
//	{
//		Vertex v = o2v.get(o);
//		if (v != null)
//			return v;
//		
//		v = new Vertex(this, o);
//		o2v.put(o, v);
//		verticies.add(v);
//		return v;
//	}
	
	public Vertex getVertexFor(Object o)
	{
		Vertex v = o2v.get(o);
		assert v != null;
		return v;
	}
	
	public Vertex addVertex(Object o, VertexType type)
	{
		assert o2v.get(o) == null;
		
		Vertex v = new Vertex(this, o);
		//v.setType(type);
		assert type == v.getType();
		
		verticies.add(v);
		o2v.put(o, v);
		
		return v;
	}
	
	public void removeVertex(Object o)
	{
		Vertex v = this.getVertexFor(o);
		
		assert v.getEdges().isEmpty();
		assert v.getEdgesFrom().isEmpty();
		
		verticies.remove(v);
		o2v.remove(o);
	}
	
	public void addEdge(Edge e)
	{
		e.getFrom().addEdge(e);
	}

	public List<Vertex> getVerticies()
	{
		return verticies;
	}
	
	public int vertexCount()
	{
		return verticies.size();
	}

	@Override
	public String toString()
	{
		return "Graph{" + "verticies=" + verticies.size() + "}";
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
	
	public int unsolved(VertexType type)
	{
		int solved = 0;
		for (Vertex v : verticies)
			if (v.getOther() == null && type == v.getType())
				++solved;
		return solved;
	}
	
	private void recurse(Vertex v, Set<Vertex> verticies)
	{
		if (verticies.contains(v))
			return;
		
		verticies.add(v);
		
		for (Edge e : v.getEdges())
			recurse(e.getTo(), verticies);
	}
	
	public Set<Vertex> reachableVerticiesFromSolvedVerticies()
	{
		Set<Vertex> verticies = new HashSet<>();
		for (Vertex v : this.verticies)
			if (v.getOther() != null)
				recurse(v, verticies);
		return verticies;
	}
}
