package info.sigterm.deob.callgraph;

import info.sigterm.deob.Method;
import info.sigterm.deob.attributes.code.Instruction;

public class Node
{
	public Method from, to;
	public Instruction ins;
	
	public Node(Method from, Method to, Instruction ins)
	{
		this.from = from;
		this.to = to;
		this.ins = ins;
	}
}
