package net.runelite.injector.raw;

import java.util.ArrayList;
import java.util.List;
import net.runelite.asm.ClassFile;
import net.runelite.asm.attributes.code.Instruction;
import net.runelite.asm.attributes.code.Instructions;
import net.runelite.asm.attributes.code.instructions.InvokeStatic;
import net.runelite.asm.attributes.code.instructions.InvokeVirtual;
import net.runelite.asm.pool.Class;
import net.runelite.asm.pool.Method;
import net.runelite.asm.signature.Signature;
import net.runelite.deob.DeobAnnotations;
import net.runelite.injector.Inject;
import net.runelite.injector.InjectionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RenderDraw
{
	private static final Logger log = LoggerFactory.getLogger(ClearColorBuffer.class);
	private static final net.runelite.asm.pool.Method renderDraw = new net.runelite.asm.pool.Method(
		new Class("net.runelite.client.callback.Hooks"),
		"renderDraw",
		new Signature("(Lapi/Renderable;IIIIIIIIJ)V")
	);
	private final Inject inject;

	public RenderDraw(Inject inject)
	{
		this.inject = inject;
	}

	public void inject() throws InjectionException
	{
		injectColorBufferHooks();
	}

	private void injectColorBufferHooks() throws InjectionException
	{
		net.runelite.asm.Method obmethod = findObMethod("drawTile");
		Method renderDraw = findObMethod("renderDraw").getPoolMethod();
		Instructions ins = obmethod.getCode().getInstructions();
		replace(ins, renderDraw);
	}

	private void replace(Instructions ins, net.runelite.asm.pool.Method meth)
	{
		List<Instruction> insList = new ArrayList<>();
		int count = 0;
		for (Instruction i : ins.getInstructions())
		{
			if (i instanceof InvokeVirtual)
			{
				if (((InvokeVirtual) i).getMethod().equals(meth))
				{
					int index = ins.getInstructions().indexOf(i);
					count++;
					log.info("Found renderDraw at index {}, {} found.", index, count);

					insList.add(i);
				}
			}
		}

		for (Instruction i : insList)
		{
			Instruction invoke = new InvokeStatic(ins, renderDraw);
			ins.replace(i, invoke);
		}
	}

	private net.runelite.asm.Method findObMethod(String name) throws InjectionException
	{
		for (ClassFile cf : inject.getDeobfuscated().getClasses())
		{
			for (net.runelite.asm.Method m : cf.getMethods())
			{
				if (!m.getName().equals(name))
				{
					continue;
				}
				String obfuscatedName = DeobAnnotations.getObfuscatedName(m.getAnnotations());

				ClassFile c2 = inject.toObClass(cf);
				return c2.findMethod(obfuscatedName);
			}
		}

		throw new InjectionException(String.format("Method \"%s\" could not be found.", name));
	}
}
