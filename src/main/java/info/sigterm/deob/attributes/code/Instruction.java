package info.sigterm.deob.attributes.code;

import info.sigterm.deob.ClassFile;
import info.sigterm.deob.ConstantPool;
import info.sigterm.deob.Field;
import info.sigterm.deob.Method;
import info.sigterm.deob.execution.Frame;

import java.io.DataOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public abstract class Instruction
{
	private Instructions instructions;
	public Block block;
	private InstructionType type;

	private int pc; // offset into method this instructions resides at
	protected int length = 1; // length of this instruction

	public List<Instruction> jump = new ArrayList<>(), // instructions which this instruction jumps to
								from = new ArrayList<>(); // instructions which jump to this instruction
	public List<Exception> exce = new ArrayList<>(); // exception handlers which start here

	public Instruction(Instructions instructions, InstructionType type, int pc)
	{
		this.instructions = instructions;
		this.type = type;
		this.pc = pc;
	}
	
	protected void remove()
	{
		assert block == null;
		
		for (Instruction i : jump)
			i.from.remove(this);
		jump.clear();
		
		Exceptions exceptions = instructions.getCode().getExceptions();
		for (Exception e : exceptions.getExceptions())
		{
			assert this != e.getStart();
			assert this != e.getEnd();
			assert this != e.getHandler();
		}
		
		assert from.isEmpty(); // because this is empty no jumping instructions point here
		assert exce.isEmpty();
	}
	
	public void replace(Instruction other)
	{
		List<Instruction> ins = instructions.getInstructions();
		
		assert this != other;
		assert ins.contains(this);
		assert !ins.contains(other);
		
		// XXX this corrupts the block graph. we shouldn't keep it around once we are done using it,
		// too much stuff to keep updated.
		this.block = null;
		
		// XXX instructions which hold references to instructions !
		for (Instruction i : ins)
		{
			i.replace(this, other);
		}
		
		// update instructions which jump here to jump to the new instruction
		for (Instruction i : from)
		{
			assert i.jump.contains(this);
			assert !i.jump.contains(other);
			
			i.jump.remove(this);
			i.jump.add(other);
		}
		from.clear();
		
		// move jumps over
		for (Instruction i : jump)
		{
			assert i.from.contains(this);
			assert !i.from.contains(other);
			
			i.from.remove(this);
			i.from.add(other);
		}
		other.jump = new ArrayList<>(this.jump);
		jump.clear();
		
		Exceptions exceptions = instructions.getCode().getExceptions();
		for (Exception e : exceptions.getExceptions())
		{
			e.replace(this, other);
		}
		assert exce.isEmpty();
		
		// replace ins
		int index = ins.indexOf(this);
		ins.remove(this);
		ins.add(index, other);
	}
	
	public boolean removeStack()
	{
		block = null;
		
		// update instructions which jump here to jump to the next instruction
		List<Instruction> ins = instructions.getInstructions();
		Instruction next = ins.get(ins.indexOf(this) + 1);
		assert next != null;
		
		for (Instruction i : ins)
		{
			i.replace(this, next);
		}
		
		for (Instruction i : from)
		{
			assert i.jump.contains(this);
			
			i.jump.remove(this);
			
			i.jump.add(next);
			next.from.add(i);
		}
		from.clear();
		
		this.getInstructions().remove(this); // calls remove()
		
		return true;
	}
	
	// resolve jumps
	public void resolve()
	{
	}
	
	// initialize constant pool to see if instruction u/g is required 
	public void prime()
	{
	}

	public void write(DataOutputStream out) throws IOException
	{
		out.writeByte(type.getCode());
	}

	public Instructions getInstructions()
	{
		return instructions;
	}
	
	public InstructionType getType()
	{
		return type;
	}
	
	public ConstantPool getPool()
	{
		return instructions.getCode().getAttributes().getClassFile().getPool();
	}

	public int getPc()
	{
		return pc;
	}
	
	public void setPc(int pc)
	{
		this.pc = pc;
	}

	public int getLength()
	{
		return length;
	}
	
	public String getDesc(Frame frame)
	{
		return type.getName() + " at pc " + frame.getPc() + " in " + frame.getMethod().getName() + " " + frame.getMethod().getDescriptor() + " class " + frame.getMethod().getCode().getAttributes().getClassFile().getName();
	}

	protected void addJump(Instruction to)
	{
		assert to != null;
		assert to != this;

		this.jump.add(to);
		to.from.add(this);
	}

	public void buildInstructionGraph()
	{
	}
	
	public abstract void execute(Frame e);
	
	/* does this terminate a block? */
	public boolean isTerminal()
	{
		return false;
	}
	
	public void replace(Instruction oldi, Instruction newi)
	{
	}
	
	public void renameClass(ClassFile cf, String name)
	{
	}
	
	public void renameField(Field f, String name)
	{
	}
	
	public void renameMethod(Method m, String name)
	{
	}
}
