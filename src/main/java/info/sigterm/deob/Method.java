package info.sigterm.deob;

import info.sigterm.deob.attributes.AttributeType;
import info.sigterm.deob.attributes.Attributes;
import info.sigterm.deob.attributes.Code;
import info.sigterm.deob.attributes.code.Instruction;
import info.sigterm.deob.attributes.code.instruction.types.InvokeInstruction;
import info.sigterm.deob.attributes.code.instruction.types.LVTInstruction;
import info.sigterm.deob.callgraph.Node;
import info.sigterm.deob.execution.Execution;
import info.sigterm.deob.execution.Frame;
import info.sigterm.deob.execution.InstructionContext;
import info.sigterm.deob.pool.NameAndType;
import info.sigterm.deob.pool.PoolEntry;
import info.sigterm.deob.signature.Signature;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Method
{
	public static final int ACC_STATIC = 0x8;
	
	private Methods methods;

	private short accessFlags;
	private String name;
	private Signature arguments;
	private Attributes attributes;
	List<Node> callsTo = new ArrayList<>();
	List<Node> callsFrom = new ArrayList<>();

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
	
	public void removeParameter(Execution execution, int paramIndex, int lvtIndex)
	{
		Set<Instruction> done = new HashSet<>();
		for (Node n : callsFrom)
		{
			// find everywhere that calls this
			// remove parameter from stack
			Method caller = n.from;
			
			// find frames on the caller
			boolean found = false;
			for (Frame f : execution.processedFrames)
				if (f.getMethod() == caller)
					for (InstructionContext ins : f.getInstructions())
						if (ins.getInstruction() == n.ins) // this instruction invokes the function we're removing a parameter from
						{
							found = true;
							if (done.contains(ins.getInstruction()))
									continue;
							
							int pops = arguments.size() - paramIndex - 1; // index from top of stack of parameter
							ins.removeStack(pops); // remove parameter from stack
							
							InvokeInstruction iins = (InvokeInstruction) ins.getInstruction();
							iins.removeParameter(paramIndex); // remove parameter from instruction
							
							done.add(ins.getInstruction());
						}
			if (found == false)
			{
				System.err.println("Method " + caller.getName() + " in " + caller.getMethods().getClassFile().getName() + " calls " + this.getName() + " in " + this.getMethods().getClassFile().getName() + ", but was unable to find any execution frame doing this");
				assert false;
			}
		}
		
		// this double checks that all calls to this have been located
		for (ClassFile cf : methods.getClassFile().getGroup().getClasses())
			for (Method m : cf.getMethods().getMethods())
			{
				Code c = m.getCode();
				if (c == null)
					continue;
				
				for (Instruction i : c.getInstructions().getInstructions())
				{
					if (i instanceof InvokeInstruction)
					{
						InvokeInstruction ii = (InvokeInstruction) i;
						PoolEntry pool = ii.getMethod();
						
						if (pool instanceof info.sigterm.deob.pool.Method)
						{
							info.sigterm.deob.pool.Method pm = (info.sigterm.deob.pool.Method) pool;
							
							if (pm.getClassEntry().getName().equals(this.getMethods().getClassFile().getName()) && pm.getNameAndType().equals(this.getNameAndType()) && !done.contains(i))
							{
								// for some reason this wasn't removed above?
								System.err.println("Method " + m.getName() + " in " + cf.getName() + " calls " + pm.getNameAndType().getName() + " in " + pm.getClassEntry().getName() + " at " + i.getPc() + ", but this instruction was not found during execution");
								//assert false;
							}
						}
						else if (pool instanceof info.sigterm.deob.pool.InterfaceMethod)
						{
							info.sigterm.deob.pool.InterfaceMethod pm = (info.sigterm.deob.pool.InterfaceMethod) pool;
							
							if (pm.getClassEntry().getName().equals(this.getMethods().getClassFile().getName()) && pm.getNameAndType().equals(this.getNameAndType()) && !done.contains(i))
							{
								// for some reason this wasn't removed above?
								System.err.println("Method " + m.getName() + " in " + cf.getName() + " calls " + pm.getNameAndType().getName() + " in " + pm.getClassEntry().getName() + " at " + i.getPc() + ", but this instruction was not found during execution");
								//assert false;
							}
						}
					}
				}
			}
		
		// adjust lvt indexes to get rid of idx in the method
		for (Instruction ins : new ArrayList<>(getCode().getInstructions().getInstructions()))
		{
			if (ins instanceof LVTInstruction)
			{
				LVTInstruction lins = (LVTInstruction) ins;
				
				int i = lins.getVariableIndex();
				assert i != lvtIndex; // current unused variable detection just looks for no accesses
				
				// reassign
				if (i > lvtIndex)
				{
					Instruction newIns = lins.setVariableIndex(--i);
					if (newIns != ins)
						ins.replace(newIns);
				}
			}
		}
		
		arguments.remove(paramIndex);
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
		assert method != null;
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
