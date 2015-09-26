package net.runelite.deob.execution;

import net.runelite.deob.ClassFile;
import net.runelite.deob.ClassGroup;
import net.runelite.deob.Deob;
import net.runelite.deob.Method;
import net.runelite.deob.attributes.code.Instruction;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import net.runelite.deob.deobfuscators.arithmetic.Encryption;
import org.apache.commons.collections4.map.MultiValueMap;

public class Execution
{
	private ClassGroup group;
	public List<Frame> frames = new ArrayList<>(),
			processedFrames = new ArrayList<>();
	public Set<Method> methods = new HashSet<>(); // all methods
	public Set<Instruction> executed = new HashSet<>(); // executed instructions
	private MultiValueMap<InstructionContext, Method> invokes = new MultiValueMap<>();
	private Encryption encryption;
	public MultiValueMap<Instruction, InstructionContext> contexts = new MultiValueMap<>();

	public Execution(ClassGroup group)
	{
		this.group = group;
	}

	public Encryption getEncryption()
	{
		return encryption;
	}
	
	public void setEncryption(Encryption encryption)
	{
		this.encryption = encryption;
	}
	
	public void populateInitialMethods()
	{
		for (ClassFile cf : group.getClasses())
		{
			for (Method m : cf.getMethods().getMethods())
			{
				if (!Deob.isObfuscated(m.getName()) && !m.getName().equals("<init>"))
				{
					if (m.getCode() == null)
					{
						methods.add(m);
						continue;
					}
					
					Frame frame = new Frame(this, m);
					frame.initialize();
					addFrame(frame); // I guess this method name is overriding a jre interface (init, run, ?).
				}
			}
		}
	}
	
	private boolean hasInvoked(InstructionContext from, Method to)
	{
		Collection<Method> methods = invokes.getCollection(from);
		if (methods != null && methods.contains(to))
			return true;
		
		invokes.put(from, to);
		return false;
	}

	private void addFrame(Frame frame)
	{
		frames.add(frame);
	}
	
	public void invoke(InstructionContext from, Method to)
	{
		if (hasInvoked(from, to))
			return;
		
		Frame f = new Frame(this, to);
		f.initialize(from);
		this.addFrame(f);
	}
	
	public void run()
	{
		int fcount = 0;
		while (!frames.isEmpty())
		{
			Frame frame = frames.remove(0);
			
			methods.add(frame.getMethod());
			
			++fcount;
			frame.execute();
			processedFrames.add(frame);
		}
		
		System.out.println("Processed " + fcount + " frames");
	}
	
	public Collection<InstructionContext> getInstructonContexts(Instruction i)
	{
		return contexts.getCollection(i);
	}
}
