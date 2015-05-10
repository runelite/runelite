package info.sigterm.deob;

import info.sigterm.deob.attributes.AttributeType;
import info.sigterm.deob.attributes.Attributes;
import info.sigterm.deob.attributes.Code;
import info.sigterm.deob.attributes.code.Instruction;
import info.sigterm.deob.attributes.code.instruction.types.LVTInstruction;
import info.sigterm.deob.callgraph.Node;
import info.sigterm.deob.pool.NameAndType;
import info.sigterm.deob.signature.Signature;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Method
{
	public static final int ACC_STATIC = 0x8;
	
	private Methods methods;

	private short accessFlags;
	private String name;
	private Signature arguments;
	private Attributes attributes;
	private List<Node> callsTo = new ArrayList<>(),
			callsFrom = new ArrayList<>();

	Method(Methods methods) throws IOException
	{
		this.methods = methods;

		DataInputStream is = methods.getClassFile().getStream();
		ConstantPool pool = methods.getClassFile().getPool();

		accessFlags = is.readShort();
		name = pool.getUTF8(is.readUnsignedShort());
		arguments = new Signature(pool.getUTF8(is.readUnsignedShort()));
		attributes = new Attributes(this);
	}
	
	public void write(DataOutputStream out) throws IOException
	{
		ConstantPool pool = methods.getClassFile().getPool();
		
		out.writeShort(accessFlags);
		out.writeShort(pool.makeUTF8(name));
		out.writeShort(pool.makeUTF8(arguments.toString()));
		attributes.write(out);
	}
	
	protected void remove()
	{
		assert callsFrom.isEmpty();
	}
	
	protected void removeParameter(int i)
	{
		// If this is a non static method parameter 0 is this
		if (!this.isStatic())
			--i;
		
		arguments.remove(i);
		
		// XXX now remove from code.
	}

	public Methods getMethods()
	{
		return methods;
	}
	
	public String getName()
	{
		return name;
	}

	public Signature getDescriptor()
	{
		return arguments;
	}
	
	public NameAndType getNameAndType()
	{
		return new NameAndType(name, arguments);
	}
	
	public boolean isStatic()
	{
		return (accessFlags & ACC_STATIC) != 0;
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
	
	@SuppressWarnings("unchecked")
	public <T extends Instruction & LVTInstruction> List<T> findLVTInstructionsForVariable(int index)
	{
		List<T> list = new ArrayList<>();
		
		if (getCode() == null)
			return null;
		
		for (Instruction ins : getCode().getInstructions().getInstructions())
			if (ins instanceof LVTInstruction)
			{
				LVTInstruction lv = (LVTInstruction) ins;
				
				if (lv.getVariableIndex() != index)
					continue;
				
				list.add((T) ins);
			}
		
		return list;
	} 
}
