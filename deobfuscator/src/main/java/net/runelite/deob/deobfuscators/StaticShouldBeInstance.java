package net.runelite.deob.deobfuscators;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import net.runelite.asm.ClassFile;
import net.runelite.asm.ClassGroup;
import net.runelite.asm.Field;
import net.runelite.asm.Type;
import net.runelite.asm.attributes.Annotations;
import net.runelite.asm.attributes.Code;
import net.runelite.asm.attributes.code.Instruction;
import net.runelite.asm.attributes.code.Instructions;
import net.runelite.asm.attributes.code.instruction.types.ReturnInstruction;
import net.runelite.asm.attributes.code.instructions.InvokeStatic;
import net.runelite.asm.attributes.code.instructions.InvokeVirtual;
import net.runelite.asm.pool.Method;
import net.runelite.asm.signature.Signature;
import net.runelite.deob.Deobfuscator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StaticShouldBeInstance implements Deobfuscator
{
	private static final Logger logger = LoggerFactory.getLogger(StaticShouldBeInstance.class);
	private static Map<Method, Method> methods = new HashMap<>();

	public void run(ClassGroup group)
	{
		int replacedCalls = 0;
		int removedInstructions = 0;
		int removedMethods = 0;
		int removedAnnotations = 0;
		List<net.runelite.asm.Method> obfuscatedMethods = new ArrayList<>();

		for (ClassFile cf : group.getClasses())
		{
			// Remove unused annotations
			Annotations a = cf.getAnnotations();
			removedAnnotations += a.getAnnotations().size();
			a.clearAnnotations();

			Type type = new Type('L' + cf.getClassName() + ';');
			obfuscatedMethods.clear();

			for (net.runelite.asm.Method m : cf.getMethods())
			{
				// Remove unused annotations
				a = m.getAnnotations();
				removedAnnotations += a.size();
				a.clearAnnotations();

				if (m.isStatic() && m.getCode() != null)
				{
					if (checkIfObf(m, type, cf))
					{
						removedMethods++;
						obfuscatedMethods.add(m);
					}
				}
			}


			for (net.runelite.asm.Method m : obfuscatedMethods)
			{
				Signature sig = m.getDescriptor();
				Signature.Builder builder = new Signature.Builder();
				builder.setReturnType(sig.getReturnValue());
				if (sig.getArguments().size() > 1)
				{
					builder.addArguments(sig.getArguments().subList(1, sig.getArguments().size()));
				}

				Signature toFind = builder.build();

				net.runelite.asm.Method notStatic = cf.findMethod(m.getName(), toFind);
				net.runelite.asm.pool.Method oldPool = m.getPoolMethod();
				cf.removeMethod(notStatic);

				m.setDescriptor(toFind);
				m.setStatic(false);
				Code c = m.getCode();
				Instructions ins = c.getInstructions();
				int startLength = ins.getInstructions().size();
				ListIterator<Instruction> it = ins.getInstructions().listIterator();
				assert it.hasNext();
				Instruction i = it.next();
				while (!(i instanceof ReturnInstruction))
				{
					it.remove();
					i = it.next();
				}
				it.remove();
				net.runelite.asm.pool.Method newPool = m.getPoolMethod();

				methods.put(oldPool, newPool);

				removedInstructions += startLength - ins.getInstructions().size();
			}

			for (Field fi : cf.getFields())
			{
				a = fi.getAnnotations();
				if (a.find(new Type("Ljavax/inject/Inject;")) == null)
				{
					removedAnnotations += a.size();
					a.clearAnnotations();
				}
				else
				{
					logger.info("Class {}, field {} has inject", cf.getClassName(), fi.getName());
				}
			}
		}

		for (ClassFile cf : group.getClasses())
		{
			for (net.runelite.asm.Method m : cf.getMethods())
			{
				if (m.getCode() == null)
				{
					continue;
				}

				Instructions ins = m.getCode().getInstructions();
				List<Instruction> instructions = ins.getInstructions();
				for (int i1 = 0, instructionsSize = instructions.size(); i1 < instructionsSize; i1++)
				{
					Instruction i = instructions.get(i1);
					if (!(i instanceof InvokeStatic))
					{
						continue;
					}

					if (methods.containsKey(((InvokeStatic) i).getMethod()))
					{
						InvokeVirtual invoke = new InvokeVirtual(ins, methods.get(((InvokeStatic) i).getMethod()));
						ins.replace(i, invoke);
						replacedCalls++;
					}
				}
			}
		}

		logger.info("Made {} methods not static, removed {} instructions, replaced {} invokes, and removed {} annotations", removedMethods, removedInstructions, replacedCalls, removedAnnotations);
	}

	private static boolean checkIfObf(net.runelite.asm.Method m, Type type, ClassFile cf)
	{
		Signature sig = m.getDescriptor();
		if (sig.getArguments().size() < 1 || !sig.getTypeOfArg(0).equals(type))
		{
			return  false;
		}

		Signature.Builder builder = new Signature.Builder();
		builder.setReturnType(sig.getReturnValue());
		if (sig.getArguments().size() > 1)
		{
			builder.addArguments(sig.getArguments().subList(1, sig.getArguments().size()));
		}

		Signature toFind = builder.build();

		net.runelite.asm.Method notStatic = cf.findMethod(m.getName(), toFind);

		return notStatic != null;
	}
}
