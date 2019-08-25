package net.runelite.injector.raw;

import java.util.ListIterator;
import net.runelite.asm.ClassFile;
import net.runelite.asm.Method;
import net.runelite.asm.attributes.Code;
import net.runelite.asm.attributes.code.Instruction;
import net.runelite.asm.attributes.code.Instructions;
import net.runelite.asm.attributes.code.instructions.ILoad;
import net.runelite.asm.attributes.code.instructions.InvokeStatic;
import net.runelite.asm.attributes.code.instructions.LDC;
import net.runelite.asm.pool.Class;
import net.runelite.asm.signature.Signature;
import net.runelite.injector.Inject;
import net.runelite.injector.InjectUtil;
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
		net.runelite.asm.pool.Method fillRectangle = InjectUtil.findStaticMethod(inject, "Rasterizer2D_fillRectangle").getPoolMethod();

		int count = 0;
		int replaced = 0;

		for (ClassFile cf : inject.getVanilla().getClasses())
		{
			for (Method m : cf.getMethods())
			{
				if (!m.isStatic())
				{
					continue;
				}

				Code c = m.getCode();
				if (c == null)
				{
					continue;
				}

				Instructions ins = c.getInstructions();
				ListIterator<Instruction> it = ins.getInstructions().listIterator();

				for (; it.hasNext(); )
				{
					Instruction i = it.next();
					if (!(i instanceof InvokeStatic))
					{
						continue;
					}

					if (!((InvokeStatic) i).getMethod().equals(fillRectangle))
					{
						continue;
					}

					int indexToReturnTo = it.nextIndex();
					count++;
					it.previous();
					Instruction current = it.previous();
					if (current instanceof LDC && ((LDC) current).getConstantAsInt() == 0)
					{
						int varIdx = 0;
						for (; ; )
						{
							current = it.previous();
							if (current instanceof ILoad && ((ILoad) current).getVariableIndex() == 3 - varIdx)
							{
								varIdx++;
								log.debug(varIdx + " we can count yay");
								continue;
							}

							break;
						}

						if (varIdx == 4)
						{
							for (; !(current instanceof InvokeStatic); )
							{
								current = it.next();
							}
							assert it.nextIndex() == indexToReturnTo;

							it.set(new InvokeStatic(ins, clearBuffer));
							replaced++;
							log.debug("Found drawRectangle at {}. Found: {}, replaced {}", m.getName(), count, replaced);
						}
						else
						{
							log.debug("Welp, guess this wasn't it chief " + m);
						}
					}

					while (it.nextIndex() != indexToReturnTo)
					{
						it.next();
					}
				}
			}
		}
	}
}