package info.sigterm.deob;

import info.sigterm.deob.execution.Execution;
import info.sigterm.deob.execution.Frame;
import info.sigterm.deob.pool.NameAndType;
import info.sigterm.deob.signature.Signature;
import info.sigterm.deob.attributes.Code;
import info.sigterm.deob.attributes.code.Block;
import info.sigterm.deob.attributes.code.Instruction;
import info.sigterm.deob.attributes.code.Instructions;
import info.sigterm.deob.attributes.code.instructions.Goto;
import info.sigterm.deob.attributes.code.instructions.GotoW;
import info.sigterm.deob.attributes.code.instructions.Return;

import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.jar.JarOutputStream;
import java.util.jar.Manifest;

public class Deob
{
	public static void main(String[] args) throws IOException
	{
		ClassGroup group = new ClassGroup();

		JarFile jar = new JarFile(args[0]);
		for (Enumeration<JarEntry> it = jar.entries(); it.hasMoreElements();)
		{
			JarEntry entry = it.nextElement();

			if (!entry.getName().endsWith(".class"))
				continue;

			InputStream is = jar.getInputStream(entry);
			group.addClass(entry.getName(), new DataInputStream(is));
		}
		jar.close();

		group.buildClassGraph();
		group.buildInstructionGraph();
		group.buildCallGraph();
		
		checkCallGraph(group);
		removeExceptionObfuscation(group);
		checkBlockGraph(group);
		
		Execution e = execute(group);
		
		checkParameters(e, group);
		checkBlockGraphJump(group);
		
		JarOutputStream jout = new JarOutputStream(new FileOutputStream(args[1]), new Manifest());
		
		for (ClassFile cf : group.getClasses())
		{
			JarEntry entry = new JarEntry(cf.getName() + ".class");
			jout.putNextEntry(entry);
			
			ByteArrayOutputStream bout = new ByteArrayOutputStream();
			cf.write(new DataOutputStream(bout));
			jout.write(bout.toByteArray());
			
			jout.closeEntry();
		}
		
		jout.close();
	}

	private static Execution execute(ClassGroup group) throws IOException
	{
		Execution e = new Execution(group);
		
		int count = 0, fcount = 0;
		for (ClassFile cf : group.getClasses())
			for (Method method : cf.getMethods().getMethods())
			{
				if (method.getCode() == null)
					continue;
				Frame f = new Frame(e, method);
				e.frames.add(f);
				fcount += e.run();
				++count;
			}
		
		System.out.println("Processed " + count + " methods and " + fcount + " paths");
		return e;
	}
	
	private static void checkCallGraph(ClassGroup group)
	{
		int i = 0;
		for (ClassFile cf : group.getClasses())
		{
			for (Method m : new ArrayList<>(cf.getMethods().getMethods()))
			{
				/* assume obfuscated names are <= 2 chars */
				if (m.getName().length() > 2)
					continue;
				
				if (!m.isUsed())
				{
					cf.getMethods().removeMethod(m);
					++i;
				}
			}
		}
		System.out.println("Removed " + i + " methods");
	}
	
	private static void removeExceptionObfuscation(ClassGroup group)
	{
		int i = 0;
		for (ClassFile cf : group.getClasses())
		{
			for (Method m : new ArrayList<>(cf.getMethods().getMethods()))
			{
				Code c = m.getCode();
				if (c == null)
					continue;
				
				for (info.sigterm.deob.attributes.code.Exception e : new ArrayList<>(c.getExceptions().getExceptions()))
				{
					if (e.getCatchType() != null && e.getCatchType().getName().equals("java/lang/RuntimeException"))
					{
						c.getExceptions().remove(e);
						++i;
					}
				}
			}
		}
		System.out.println("Removed " + i + " exception handlers");
	}
	
	private static void checkBlockGraph(ClassGroup group)
	{
		int i = 0;
		for (ClassFile cf : group.getClasses())
		{
			for (Method m : new ArrayList<>(cf.getMethods().getMethods()))
			{
				if (m.getCode() == null)
					continue;
				
				Instructions ins = m.getCode().getInstructions();
				int count = 0;
				for (Block b : new ArrayList<>(ins.getBlocks()))
				{
					// first block is the entrypoint, so its always used
					if (count++ == 0)
						continue;
					
					if (b.begin.from.isEmpty() && b.begin.exce.isEmpty())
					{
						ins.remove(b);
						++i;
					}
				}
			}
		}
		System.out.println("Removed " + i + " unused blocks");
	}
	
	private static int checkBlockGraphOnce(ClassGroup group)
	{
		int count = 0;
		for (ClassFile cf : group.getClasses())
		{
			for (Method m : new ArrayList<>(cf.getMethods().getMethods()))
			{
				if (m.getCode() == null)
					continue;
				
				Instructions ins = m.getCode().getInstructions();
				ins.buildBlocks();
				ins.buildJumpGraph();
				List<Block> blocks = ins.getBlocks();
				for (int i = 0; i < blocks.size(); ++i)
				{
					Block block = blocks.get(i);
					Block prev = i > 0 ? blocks.get(i - 1) : null;
					
					// only one thing jumps here
					if (block.begin.from.size() == 1 && prev != null && prev.end.isTerminal())
					{
						Instruction from = block.begin.from.get(0); // this instruction jumps to block
						
						if (from.block == block)
							continue;
						
						if (from instanceof Goto || from instanceof GotoW)
						{
							++count;
							
							List<Instruction> ilist = ins.getInstructions();
							
							// remove instructions
							for (Instruction in : block.instructions)
								ilist.remove(in);
							
							int index = ilist.indexOf(from);
							
							assert from.block != block;
							from.block = null;
							
							// move instructions which jump here to jump to block.begin
							for (Instruction in : from.from)
							{
								assert in.jump.contains(from);
								assert !in.jump.contains(block.begin);
								
								in.jump.remove(from);
								
								in.jump.add(block.begin);
								block.begin.from.add(in);
							}
							from.from.clear();
							
							// .replace ins
							for (Instruction in : ilist)
								in.replace(from, block.begin);
							
							for (info.sigterm.deob.attributes.code.Exception e : m.getCode().getExceptions().getExceptions())
								e.replace(from, block.begin);
							
							ins.remove(from); // remove jump
							
							// insert instructions from block where jump was
							for (Instruction in : block.instructions)
								ilist.add(index++, in);
						}
					}
				}
			}
		}
		return count;
	}
	
	private static void checkBlockGraphJump(ClassGroup g)
	{
		int count = 0;
		int passes = 0;
		int i;
		do
		{
			i = checkBlockGraphOnce(g);
			count += i;
			++passes;
		}
		while (i > 0);
		
		System.out.println("Inlined " + count + " jumps in " + passes + " passes");
	}
	
	private static int[] checkParametersOnce(Execution execution, ClassGroup group)
	{
		// removing parameters shifts the others around which is annoying.
		// if more than one is unused, we'll just remove the one
		// and do the others on another pass
		
		int count = 0;
		int collide = 0;
		int overrides = 0;
		for (ClassFile cf : group.getClasses())
		{
			for (Method m : cf.getMethods().getMethods())
			{
				int offset = m.isStatic() ? 0 : 1;
				NameAndType nat = m.getNameAndType();
				Signature signature = nat.getDescriptor();
				
				for (int variableIndex = 0, lvtIndex = offset;
						variableIndex < signature.size();
						lvtIndex += signature.getTypeOfArg(variableIndex++).getSlots())
				{
					List<? extends Instruction> lv = m.findLVTInstructionsForVariable(lvtIndex);
					
					if (lv == null)
						continue;
	
					// XXX instead of checking if the lvt index is never accessed,
					// check execution frames and see if it is never read prior to being
					// written to, and if so, then remove the parameter, but don't re index
					// the lvt table.
					if (!lv.isEmpty())
						continue;
					
					if (!m.getOverriddenMethods().isEmpty())
					{
						++overrides;
						continue;
					}
					
					Signature newSig = new Signature(m.getDescriptor());
					newSig.remove(variableIndex);
						
					Method otherMethod = cf.getMethods().findMethod(new NameAndType(m.getName(), newSig));
					if (otherMethod != null)
					{
						// sometimes removing an unused parameter will cause a signature collision with another function,
						// just ignore it atm (there seems to be very few)
						++collide;
						continue;
					}
						
					m.removeParameter(execution, variableIndex, lvtIndex);
					++count;
					break;
				}
			}
		}
		return new int[] { count, collide, overrides };
	}
	
	private static void checkParameters(Execution execution, ClassGroup group)
	{
		int count = 0;
		int collide = 0;
		int override = 0;
		int[] i;
		do
		{
			i = checkParametersOnce(execution, group);
		
			count += i[0];
			collide = i[1]; // the next pass may be able to reduce the collisions
			override = i[2];
		}
		while (i[0] > 0);
		
		System.out.println("Removed " + count + " unused parameters, unable to remove " + collide + " because of signature collisions and " + override + " due to overriding");
	}
}