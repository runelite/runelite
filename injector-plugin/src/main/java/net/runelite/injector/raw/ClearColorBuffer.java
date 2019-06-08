package net.runelite.injector.raw;

import java.util.ArrayList;
import java.util.List;
import net.runelite.asm.ClassFile;
import net.runelite.asm.Method;
import net.runelite.asm.attributes.code.Instruction;
import net.runelite.asm.attributes.code.Instructions;
import net.runelite.asm.attributes.code.instructions.InvokeStatic;
import net.runelite.asm.pool.Class;
import net.runelite.asm.signature.Signature;
import net.runelite.deob.DeobAnnotations;
import net.runelite.injector.Inject;
import net.runelite.injector.InjectionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ClearColorBuffer
{
	private static final Logger log = LoggerFactory.getLogger(ClearColorBuffer.class);
	private static final net.runelite.asm.pool.Method clearBuffer = new net.runelite.asm.pool.Method(
		new Class("net.runelite.client.callback.Hooks"),
		"clearColorBuffer",
		new Signature("(IIIII)V")
	);
	private final Inject inject;

	public ClearColorBuffer(Inject inject)
	{
		this.inject = inject;
	}

	public void inject() throws InjectionException
	{
		injectColorBufferHooks();
	}

	private void injectColorBufferHooks() throws InjectionException
	{
		Method obmethod = findStaticMethod("drawEntities");
		net.runelite.asm.pool.Method fillRectangle = findStaticMethod("Rasterizer2D_fillRectangle").getPoolMethod();
		Instructions ins = obmethod.getCode().getInstructions();
		replace(ins, fillRectangle);
	}

	private void replace(Instructions ins, net.runelite.asm.pool.Method meth)
	{
		List<Instruction> insList = new ArrayList<>();
		for (Instruction i : ins.getInstructions())
		{
			if (i instanceof InvokeStatic)
			{
				if (((InvokeStatic) i).getMethod().equals(meth))
				{
					int index = ins.getInstructions().indexOf(i);
					log.info("Found drawRectangle at index {}", index);

					insList.add(i);
				}
			}
		}

		for (Instruction i : insList)
		{
			Instruction invoke = new InvokeStatic(ins, clearBuffer);
			ins.replace(i, invoke);
		}
	}

	private Method findStaticMethod(String name) throws InjectionException
	{
		for (ClassFile c : inject.getDeobfuscated().getClasses())
		{
			for (Method m : c.getMethods())
			{
				if (!m.getName().equals(name))
				{
					continue;
				}

				String obfuscatedName = DeobAnnotations.getObfuscatedName(m.getAnnotations());
				Signature obfuscatedSignature = DeobAnnotations.getObfuscatedSignature(m);

				ClassFile c2 = inject.toObClass(c);

				return c2.findMethod(obfuscatedName, (obfuscatedSignature != null) ? obfuscatedSignature : m.getDescriptor());
			}
		}

		throw new InjectionException("Couldn't find static method " + name);
	}

}