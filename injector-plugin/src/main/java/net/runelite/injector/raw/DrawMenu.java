/*
package net.runelite.injector.raw;

import com.google.common.base.Strings;
import java.util.HashSet;
import java.util.Set;
import net.runelite.asm.ClassFile;
import net.runelite.asm.Method;
import net.runelite.asm.Type;
import net.runelite.asm.attributes.Annotations;
import net.runelite.asm.attributes.Code;
import net.runelite.asm.attributes.annotation.Annotation;
import net.runelite.asm.attributes.code.Instruction;
import net.runelite.asm.attributes.code.Instructions;
import net.runelite.asm.attributes.code.Label;
import net.runelite.asm.attributes.code.instruction.types.ComparisonInstruction;
import net.runelite.asm.attributes.code.instruction.types.JumpingInstruction;
import net.runelite.asm.attributes.code.instruction.types.ReturnInstruction;
import net.runelite.asm.attributes.code.instructions.GetStatic;
import net.runelite.asm.attributes.code.instructions.IfACmpEq;
import net.runelite.asm.attributes.code.instructions.IfACmpNe;
import net.runelite.asm.attributes.code.instructions.IfEq;
import net.runelite.asm.attributes.code.instructions.IfNe;
import net.runelite.asm.attributes.code.instructions.InvokeStatic;
import net.runelite.asm.execution.Execution;
import net.runelite.asm.execution.InstructionContext;
import net.runelite.asm.pool.Class;
import net.runelite.asm.pool.Field;
import net.runelite.asm.signature.Signature;
import net.runelite.deob.DeobAnnotations;
import net.runelite.injector.Inject;
import net.runelite.injector.InjectionException;

public class DrawMenu
{
	private final Inject inject;
	private static final Field isMenuOpen = new Field(
		new Class("Client"),
		"isMenuOpen",
		Type.BOOLEAN
	);
	private static final net.runelite.asm.pool.Method hook = new net.runelite.asm.pool.Method(
		new Class("net.runelite.client.callback.Hooks"),
		"drawMenu",
		new Signature("()Z")
	);

	public DrawMenu(Inject inject)
	{
		this.inject =inject;
	}

	public void inject() throws InjectionException
	{
		Method drawLoggedIn = findDeobThing("drawLoggedIn", "Client", false);
		Instructions ins = drawLoggedIn.getCode().getInstructions();

		int menuOpenIdx = -1;
		Field field = toObField(isMenuOpen).getPoolField();

		for (Instruction i : ins.getInstructions())
		{
			if (!(i instanceof GetStatic))
			{
				continue;
			}

			if (((GetStatic) i).getField().equals(field))
			{
				menuOpenIdx = ins.getInstructions().indexOf(i);
			}
		}

		if (menuOpenIdx == -1)
		{
			throw new InjectionException("Couldn't find the isMenuOpen check!");
		}

		// This is where the IFEQ or IFNE will be
		final Instruction jump = ins.getInstructions().get(menuOpenIdx + 1);
		// We want to inject if it's false so
		if (jump instanceof IfEq)
		{
			// Not this one, but we gotta find out where the paths will intersect
			Set<Label> labels = getLabels(jump);
		}

	}

	private Set<Label> getLabels(Instruction i)
	{
		Set<Label> labels = new HashSet<>();
		Execution ex = new Execution(inject.getVanilla());
		ex.addMethod(i.getInstructions().getCode().getMethod());
		ex.noInvoke = true;

		ex.addExecutionVisitor((InstructionContext ic) ->
		{
			Instruction in = ic.getInstruction();
			Instructions ins = in.getInstructions();
			Code code = ins.getCode();
			Method method = code.getMethod();
			//ic.
		});
	}

	private Set<Label> findLabels(Instructions ins, int idx)
	{
		Set<Label> labels = new HashSet<>();
		Instruction i = null;
		while (labels.size() < 10 || !(i instanceof ReturnInstruction))
		{
			i = ins.getInstructions().get(idx);
			if (i instanceof JumpingInstruction)
			{
				Label cur = ((JumpingInstruction) i).getJumps().get(0);
				labels.add((Label) cur);

				idx = ins.getInstructions().indexOf(cur) + 1;
			}
		}

		return labels;
	}

	private Method findDeobThing(String name, String hint, boolean isStatic) throws InjectionException
	{
		if (!Strings.isNullOrEmpty(hint))
		{
			ClassFile hintCf = inject.getDeobfuscated().findClass(hint);
			if (hintCf != null)
			{
				for (Method m : hintCf.getMethods())
				{
					if (isStatic != m.isStatic())
					{
						continue;
					}

					if (!m.getName().equals(name))
					{
						continue;
					}

					Annotations an = m.getAnnotations();
					if (an == null || an.find(DeobAnnotations.EXPORT) == null)
					{
						continue; // not an exported field
					}

					String obfuscatedName = DeobAnnotations.getObfuscatedName(an);
					return inject.toObClass(hintCf).findMethod(obfuscatedName);
				}
			}
		}

		for (ClassFile cf : inject.getDeobfuscated().getClasses())
		{
			for (Method m : cf.getMethods())
			{
				if (isStatic != m.isStatic())
				{
					continue;
				}

				Annotations an = m.getAnnotations();
				if (an == null || an.find(DeobAnnotations.EXPORT) == null)
				{
					continue; // not an exported field
				}

				String obfuscatedName = DeobAnnotations.getObfuscatedName(an);
				return inject.toObClass(cf).findMethod(obfuscatedName);
			}
		}

		throw new InjectionException("Method not found!");
	}

	private net.runelite.asm.Field toObField(Field field) throws InjectionException
	{
		ClassFile cf = inject.getDeobfuscated().findClass(field.getClazz().getName());
		for (net.runelite.asm.Field f : cf.getFields())
		{
			if (f.getPoolField().equals(field))
			{
				return inject.toObField(f);
			}
		}
		throw new InjectionException("Field not found!");
	}
}
*/
