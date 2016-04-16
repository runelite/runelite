package net.runelite.deob.deobfuscators.rename;

import net.runelite.asm.ClassFile;
import net.runelite.asm.ClassGroup;
import net.runelite.asm.Interfaces;
import net.runelite.asm.Method;
import net.runelite.asm.attributes.code.Instruction;
import net.runelite.asm.attributes.code.instruction.types.ArrayLoad;
import net.runelite.asm.attributes.code.instruction.types.DupInstruction;
import net.runelite.asm.attributes.code.instruction.types.InvokeInstruction;
import net.runelite.asm.attributes.code.instruction.types.LVTInstruction;
import net.runelite.asm.attributes.code.instruction.types.MappableInstruction;
import net.runelite.asm.attributes.code.instruction.types.PushConstantInstruction;
import net.runelite.asm.attributes.code.instruction.types.SetFieldInstruction;
import net.runelite.asm.attributes.code.instructions.InvokeStatic;
import net.runelite.asm.execution.Execution;
import net.runelite.asm.execution.Frame;
import net.runelite.asm.execution.InstructionContext;
import net.runelite.asm.execution.ParallellMappingExecutor;
import net.runelite.asm.execution.StackContext;
import net.runelite.asm.execution.VariableContext;
import net.runelite.asm.execution.Variables;
import net.runelite.asm.signature.Signature;
import net.runelite.asm.signature.Type;

public class MappingExecutorUtil
{	
	public static ParallelExecutorMapping map(Method m1, Method m2)
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
		ParallelExecutorMapping mappings = new ParallelExecutorMapping(m1.getMethods().getClassFile().getGroup(),
			m2.getMethods().getClassFile().getGroup());
		
		mappings.m1 = m1;
		mappings.m2 = m2;
		
		parallel.mappings = mappings;

		int same = 0;
		while (parallel.step())
		{
			// get what each frame is paused/exited on
			InstructionContext p1 = parallel.getP1(), p2 = parallel.getP2();
			
			assert e.paused;
			assert e2.paused;
			
			//System.out.println(p1.getInstruction() + " <-> " + p2.getInstruction());
			
			//assert p1.getInstruction().getInstructions().getCode().getAttributes().getMethod() == m1;
			//assert p2.getInstruction().getInstructions().getCode().getAttributes().getMethod() == m2;

			assert p1.getInstruction() instanceof MappableInstruction;
			assert p2.getInstruction() instanceof MappableInstruction;
			
			MappableInstruction mi1 = (MappableInstruction) p1.getInstruction(),
				mi2 = (MappableInstruction) p2.getInstruction();
			
			if (!mi1.isSame(p1, p2))
			{
				mappings.crashed = true;
				p1.getFrame().stop();
				p2.getFrame().stop();
				e.paused = e2.paused = false;
				continue;
			}

			++same;
			mi1.map(mappings, p1, p2);
			e.paused = e2.paused = false;
		}

		mappings.same = same;
		
		return mappings;
	}

	public static ParallelExecutorMapping mapFrame(ClassGroup group1, ClassGroup group2, Instruction i1, Instruction i2)
	{
		Execution e = new Execution(group1);
		e.step = true;
		Frame frame = new Frame(e, i1.getInstructions().getCode().getAttributes().getMethod(), i1);
		//frame.initialize();
		e.frames.add(frame);

		Execution e2 = new Execution(group2);
		e2.step = true;
		//Frame frame2 = new Frame(e2, m2);
		Frame frame2 = new Frame(e2, i2.getInstructions().getCode().getAttributes().getMethod(), i2);
		//frame2.initialize();
		e2.frames.add(frame2);

		frame.other = frame2;
		frame2.other = frame;

		ParallellMappingExecutor parallel = new ParallellMappingExecutor(e, e2);
		ParallelExecutorMapping mappings = new ParallelExecutorMapping(group1, group2);

		//mappings.m1 = m1;
		//mappings.m2 = m2;

		parallel.mappings = mappings;

		int compare = 0;
		while (parallel.step())
		{
			// get what each frame is paused/exited on
			InstructionContext p1 = parallel.getP1(), p2 = parallel.getP2();

			assert e.paused;
			assert e2.paused;
			++compare;

			//System.out.println(p1.getInstruction() + " <-> " + p2.getInstruction());

			//assert p1.getInstruction().getInstructions().getCode().getAttributes().getMethod() == m1;
			//assert p2.getInstruction().getInstructions().getCode().getAttributes().getMethod() == m2;

			assert p1.getInstruction() instanceof MappableInstruction;
			assert p2.getInstruction() instanceof MappableInstruction;

			MappableInstruction mi1 = (MappableInstruction) p1.getInstruction(),
				mi2 = (MappableInstruction) p2.getInstruction();

			if (!mi1.isSame(p1, p2))
			{
				mappings.crashed = true;
				mi1.isSame(p1, p2);
				p1.getFrame().stop();
				p2.getFrame().stop();
				e.paused = e2.paused = false;
				continue;
			}

			mi1.map(mappings, p1, p2);
			e.paused = e2.paused = false;


			// detect end of handler. this method is only used to map handlers.
			if (mi1 instanceof SetFieldInstruction && mi2 instanceof SetFieldInstruction)
			{
				SetFieldInstruction sfi1 = (SetFieldInstruction) mi1,
					sfi2 = (SetFieldInstruction) mi2;

				if (sfi1.getMyField().packetHandler && sfi2.getMyField().packetHandler)
				{
					Instruction sfii = p1.getPops().get(0).getPushed().getInstruction();
					if (sfii instanceof PushConstantInstruction)
					{
						Object o = ((PushConstantInstruction) sfii).getConstant().getObject();
						if (o.equals(-1))
						{
							p1.getFrame().stop();
							p2.getFrame().stop();
							e.paused = e2.paused = false;
						}
					}
				}
			}
		}

		return mappings;
	}
	
	public static boolean isMappable(InvokeInstruction ii)
	{
		String className;
		
		if (ii.getMethod() instanceof net.runelite.asm.pool.Method)
		{
			net.runelite.asm.pool.Method m = (net.runelite.asm.pool.Method) ii.getMethod();
			className = m.getClassEntry().getName();
		}
		else if (ii.getMethod() instanceof net.runelite.asm.pool.InterfaceMethod)
		{
			net.runelite.asm.pool.InterfaceMethod m = (net.runelite.asm.pool.InterfaceMethod) ii.getMethod();
			className = m.getClassEntry().getName();	
		}
		else
		{
			assert false;
			return false;
		}

		if (className.startsWith("java/lang/reflect/") || className.startsWith("java/io/"))
			return true;
		
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
		
		if (ctx.getInstruction() instanceof ArrayLoad)
		{
			// might be multidimensional array
			StackContext s = ctx.getPops().get(1); // the array
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

		if (ctx.getInstruction() instanceof InvokeStatic)
		{
			if (from.returnSource != null)
			{
				return resolve(from.returnSource.getPushed(), from.returnSource);
			}
		}
		
		return ctx;
	}

	public static boolean isMaybeEqual(Type t1, Type t2)
	{
		if (t1.isPrimitive() != t2.isPrimitive())
			return false;

		if (t1.getArrayDims() != t2.getArrayDims())
			return false;

		return true;
	}

	public static boolean isMaybeEqual(Signature s1, Signature s2)
	{
		if (s1.size() != s2.size())
			return false;

		if (!isMaybeEqual(s1.getReturnValue(), s2.getReturnValue()))
			return false;

		for (int i = 0; i < s1.size(); ++i)
		{
			Type t1 = s1.getTypeOfArg(i), t2 = s2.getTypeOfArg(i);

			if (!isMaybeEqual(t1, t2))
				return false;
		}

		return true;
	}

	public static boolean isMaybeEqual(ClassFile cf1, ClassFile cf2)
	{
		if (cf1 == null && cf2 == null)
			return true;
		
		if (cf1 == null || cf2 == null)
			return false;
		
		if (!isMaybeEqual(cf1.getParent(), cf2.getParent()))
			return false;
		
		Interfaces i1 = cf1.getInterfaces(), i2 = cf2.getInterfaces();
		if (i1.getInterfaces().size() != i2.getInterfaces().size())
			return false;
		
		return true;
	}
}
