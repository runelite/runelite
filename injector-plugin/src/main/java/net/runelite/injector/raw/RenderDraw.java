package net.runelite.injector.raw;

import com.google.common.base.Stopwatch;
import java.util.ArrayList;
import java.util.List;
import net.runelite.asm.attributes.code.Instruction;
import net.runelite.asm.attributes.code.Instructions;
import net.runelite.asm.attributes.code.instructions.InvokeStatic;
import net.runelite.asm.attributes.code.instructions.InvokeVirtual;
import net.runelite.asm.pool.Class;
import net.runelite.asm.pool.Method;
import net.runelite.asm.signature.Signature;
import net.runelite.injector.Inject;
import static net.runelite.injector.InjectUtil.findMethod;
import net.runelite.injector.InjectionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RenderDraw
{
	private static final Logger log = LoggerFactory.getLogger(RenderDraw.class);
	private static final net.runelite.asm.pool.Method renderDraw = new net.runelite.asm.pool.Method(
		new Class("net.runelite.client.callback.Hooks"),
		"renderDraw",
		new Signature("(Lnet/runelite/api/Entity;IIIIIIIIJ)V")
	);
	private final Inject inject;

	public RenderDraw(Inject inject)
	{
		this.inject = inject;
	}

	public void inject() throws InjectionException
	{
		Stopwatch stopwatch = Stopwatch.createStarted();

		net.runelite.asm.Method obmethod = findMethod(inject, "drawTile", "Scene");
		Method renderDraw = findMethod(inject, "draw", "Entity").getPoolMethod();

		Instructions ins = obmethod.getCode().getInstructions();
		replace(ins, renderDraw);

		log.info("RenderDraw took {}", stopwatch.toString());
	}

	private void replace(Instructions ins, net.runelite.asm.pool.Method meth) throws InjectionException
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
					log.debug("Found renderDraw at index {}, {} found.", index, count);

					insList.add(i);
				}
			}
		}

		if (count < 21)
		{
			throw new InjectionException("Not all renderDraws were found");
		}
		if (count != 21)
		{
			log.warn("Found {} draws while 21 were expected. Rev update?", count);
		}
		else
		{
			log.info("RenderDraw replaced {} method calls", count);
		}


		for (Instruction i : insList)
		{
			Instruction invoke = new InvokeStatic(ins, renderDraw);
			ins.replace(i, invoke);
		}
	}
}
