package info.sigterm.deob;

import info.sigterm.deob.attributes.AttributeType;
import info.sigterm.deob.attributes.Attributes;
import info.sigterm.deob.attributes.Code;
import info.sigterm.deob.attributes.code.Instruction;
import info.sigterm.deob.callgraph.Node;
import info.sigterm.deob.pool.UTF8;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Method
{
	private Methods methods;

	private short accessFlags;
	private int nameIndex;
	private int descriptorIndex;
	private Attributes attributes;
	public List<Node> callsTo = new ArrayList<>(),
			callsFrom = new ArrayList<>();

	Method(Methods methods) throws IOException
	{
		this.methods = methods;

		DataInputStream is = methods.getClassFile().getStream();

		accessFlags = is.readShort();
		nameIndex = is.readUnsignedShort();
		descriptorIndex = is.readUnsignedShort();
		attributes = new Attributes(this);
	}
	
	public void write(DataOutputStream out) throws IOException
	{
		out.writeShort(accessFlags);
		out.writeShort(nameIndex);
		out.writeShort(descriptorIndex);
		attributes.write(out);
	}
	
	protected void remove()
	{
		assert callsFrom.isEmpty();
	}

	public Methods getMethods()
	{
		return methods;
	}
	
	public String getName()
	{
		UTF8 u = (UTF8) methods.getClassFile().getPool().getEntry(nameIndex);
		return u.getValue();
	}

	public String getDescriptor()
	{
		UTF8 u = (UTF8) methods.getClassFile().getPool().getEntry(descriptorIndex);
		return u.getValue();
	}

	public Code getCode()
	{
		return (Code) attributes.findType(AttributeType.CODE);
	}
	
	public List<Method> getOverriddenMethods()
	{
		List<Method> m = new ArrayList<Method>();
		
		ClassFile parent = methods.getClassFile().getParent();
		if (parent != null)
		{
			Method other = parent.getMethods().findMethod(getName(), getDescriptor());
			if (other != null)
				m.add(other);
		}
		
		for (ClassFile inter : methods.getClassFile().getInterfaces().getInterfaces())
		{
			Method other = inter.getMethods().findMethod(getName(), getDescriptor());
			if (other != null)
				m.add(other);
		}
		
		return m;
	}

	public void buildInstructionGraph()
	{
		Code code = getCode();

		if (code != null)
			code.buildInstructionGraph();
	}
	
	public void buildCallGraph()
	{
		Code code = getCode();

		if (code != null)
			code.buildCallGraph();
	}
	
	public boolean isUsed()
	{
		if (!callsFrom.isEmpty())
			return true;
		
		for (Method sm : getOverriddenMethods())
		{
			if (sm.isUsed())
				return true;
		}
		
		return false;
	}
	
	public void addCallTo(Instruction ins, Method method)
	{
		Node node = new Node(this, method, ins);
		callsTo.add(node);
		method.callsFrom.add(node);
	}
}
