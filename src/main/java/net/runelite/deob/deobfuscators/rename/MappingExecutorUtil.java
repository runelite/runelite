package net.runelite.deob.deobfuscators.rename;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import net.runelite.deob.ClassGroup;
import net.runelite.deob.Method;
import net.runelite.deob.attributes.code.Instruction;
import net.runelite.deob.attributes.code.instruction.types.DupInstruction;
import net.runelite.deob.attributes.code.instruction.types.InvokeInstruction;
import net.runelite.deob.attributes.code.instruction.types.LVTInstruction;
import net.runelite.deob.attributes.code.instruction.types.MappableInstruction;
import net.runelite.deob.attributes.code.instruction.types.SetFieldInstruction;
import net.runelite.deob.attributes.code.instructions.InvokeStatic;
import net.runelite.deob.execution.Execution;
import net.runelite.deob.execution.Frame;
import net.runelite.deob.execution.InstructionContext;
import net.runelite.deob.execution.ParallellMappingExecutor;
import net.runelite.deob.execution.StackContext;
import net.runelite.deob.execution.VariableContext;
import net.runelite.deob.execution.Variables;
import net.runelite.deob.signature.Signature;

public class MappingExecutorUtil
{
	// won't work with static funcs etc. this is all wrong. XXX
	public static boolean isMappable(Method m1, Method m2)
	{
		assert (m1.getCode() == null) == (m2.getCode() == null);
		
		if (m1.getCode() == null || m2.getCode() == null)
			return false;
		
		List<Instruction> l1 = m1.getCode().getInstructions().getInstructions().stream().filter(i -> i instanceof MappableInstruction).collect(Collectors.toList());
		List<Instruction> l2 = m2.getCode().getInstructions().getInstructions().stream().filter(i -> i instanceof MappableInstruction).collect(Collectors.toList());
		
		if (l1.size() != l2.size())
			return false;
		
		Map<Class, Integer> map1 = new HashMap<>(),
			map2 = new HashMap<>();
		
		for (int i = 0; i < l1.size(); ++i)
		{
			Instruction i1 = l1.get(i);
			
			Integer c = map1.get(i1.getClass());
			if (c == null)
				map1.put(i1.getClass(), 1);
			else
				map1.put(i1.getClass(), c + 1);
		}
		
		for (int i = 0; i < l2.size(); ++i)
		{
			Instruction i2 = l2.get(i);
			
			Integer c = map2.get(i2.getClass());
			if (c == null)
				map2.put(i2.getClass(), 1);
			else
				map2.put(i2.getClass(), c + 1);
		}
		
		return map1.equals(map2);
	}
	
	public static ParallelExecutorMapping map(Method m1, Method m2) throws MappingException
	{
		ClassGroup group1 = m1.getMethods().getClassFile().getGroup();
		ClassGroup group2 = m2.getMethods().getClassFile().getGroup();

		Execution e = new Execution(group1);
		e.step = true;
		Frame frame = new Frame(e, m1);
		frame.initialize();
		e.frames.add(frame);

		Execution e2 = new Execution(group2);
		e2.step = true;
		Frame frame2 = new Frame(e2, m2);
		frame2.initialize();
		e2.frames.add(frame2);
		
		frame.other = frame2;
		frame2.other = frame;
		
		ParallellMappingExecutor parallel = new ParallellMappingExecutor(e, e2);
		ParallelExecutorMapping mappings = new ParallelExecutorMapping();
		
		mappings.m1 = m1;
		mappings.m2 = m2;
		
		parallel.mappings = mappings;
		
		while (parallel.step())
		{
			// get what each frame is paused/exited on
			InstructionContext p1 = parallel.getP1(), p2 = parallel.getP2();
			
			assert e.paused;
			assert e2.paused;
			
			System.out.println(p1.getInstruction() + " <-> " + p2.getInstruction());
			
			//assert p1.getInstruction().getInstructions().getCode().getAttributes().getMethod() == m1;
			//assert p2.getInstruction().getInstructions().getCode().getAttributes().getMethod() == m2;

			assert p1.getInstruction() instanceof MappableInstruction;
			assert p2.getInstruction() instanceof MappableInstruction;
			
			MappableInstruction mi1 = (MappableInstruction) p1.getInstruction(),
				mi2 = (MappableInstruction) p2.getInstruction();
			
			if (!mi1.isSame(p1, p2))
			{
				throw new MappingException();
			}

			mi1.map(mappings, p1, p2);

			e.paused = e2.paused = false;
		}
		
		return mappings;
	}
	
	public static boolean isMappable(InvokeInstruction ii)
	{
		String className;
		
		if (ii.getMethod() instanceof net.runelite.deob.pool.Method)
		{
			net.runelite.deob.pool.Method m = (net.runelite.deob.pool.Method) ii.getMethod();
			className = m.getClassEntry().getName();
		}
		else if (ii.getMethod() instanceof net.runelite.deob.pool.InterfaceMethod)
		{
			net.runelite.deob.pool.InterfaceMethod m = (net.runelite.deob.pool.InterfaceMethod) ii.getMethod();
			className = m.getClassEntry().getName();	
		}
		else
		{
			assert false;
			return false;
		}
		
		if (className.startsWith("java/") || className.startsWith("netscape/") || className.startsWith("javax/"))
			return false;
		
		return true;
	}
	
	public static boolean isInlineable(Instruction i)
	{
		return i instanceof InvokeStatic && isMappable((InvokeStatic) i);
	}
	
	public static InstructionContext resolve(
		InstructionContext ctx,
		StackContext from // pushed from ctx
	)
	{
		if (ctx.getInstruction() instanceof SetFieldInstruction)
		{
			StackContext s = ctx.getPops().get(0);
			return resolve(s.getPushed(), s);
		}
		
		if (ctx.getInstruction() instanceof DupInstruction)
		{
			DupInstruction d = (DupInstruction) ctx.getInstruction();
			StackContext s = d.getOriginal(from);
			return resolve(s.getPushed(), s);
		}
		
		if (ctx.getInstruction() instanceof LVTInstruction)
		{
			LVTInstruction lvt = (LVTInstruction) ctx.getInstruction();
			Variables variables = ctx.getVariables();
			
			if (lvt.store())
			{
				StackContext s = ctx.getPops().get(0); // is this right?
				return resolve(s.getPushed(), s);
			}
			else
			{
				VariableContext vctx = variables.get(lvt.getVariableIndex()); // variable being loaded
				assert vctx != null;

				InstructionContext storedCtx = vctx.getInstructionWhichStored();
				if (storedCtx == null)
					return ctx; // initial parameter
				
				if (vctx.isIsParameter())
				{
					// Normally storedCtx being an InvokeInstruction means that this resolves to the
					// return value of an invoke instruction, but if the variable is a parameter, it means
					// this storedCtx is the invoke instruction which called this method.
					assert storedCtx.getInstruction() instanceof InvokeInstruction;
					// In PME non static functions are never stepped into/aren't inline obfuscated
					assert storedCtx.getInstruction() instanceof InvokeStatic;
					
					// Figure out parameter index from variable index.
					Signature sig = ctx.getFrame().getMethod().getDescriptor(); // signature of current method
					int paramIndex = 0;
					for (int lvtIndex = 0 /* static */;
						paramIndex < sig.size();
						lvtIndex += sig.getTypeOfArg(paramIndex++).getSlots())
						if (lvtIndex == lvt.getVariableIndex())
							break;
					assert paramIndex < sig.size();

					// Get stack context that was popped by the invoke
					// pops[0] is the first thing popped, which is the last parameter.
					StackContext sctx = storedCtx.getPops().get(sig.size() - 1 - paramIndex);
					return resolve(sctx.getPushed(), sctx);
				}
				
				return resolve(storedCtx, null);
			}
		}
		
		return ctx;
	}
}
