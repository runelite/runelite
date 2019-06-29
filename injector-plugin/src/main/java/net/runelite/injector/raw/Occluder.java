package net.runelite.injector.raw;

import com.google.common.base.Stopwatch;
import java.util.ListIterator;
import net.runelite.asm.Method;
import net.runelite.asm.attributes.Code;
import net.runelite.asm.attributes.code.Instruction;
import net.runelite.asm.attributes.code.Instructions;
import net.runelite.asm.attributes.code.instructions.BiPush;
import net.runelite.injector.Inject;
import net.runelite.injector.InjectUtil;
import net.runelite.injector.InjectionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Occluder
{
	private final Inject inject;
	private static final Logger log = LoggerFactory.getLogger(Occluder.class);
	private static final byte OLDVALUE = 25;
	private static final byte NEWVALUE = 90;

	public Occluder(Inject inject)
	{
		this.inject = inject;
	}

	public void inject() throws InjectionException
	{
		Stopwatch stopwatch = Stopwatch.createStarted();
		Method occlude = InjectUtil.findMethod(inject, "occlude");
		int replaced = 0;

		if (occlude == null)
		{
			throw new InjectionException("Occlude couldn't be found");
		}

		Code code = occlude.getCode();

		if (code == null)
		{
			throw new InjectionException("Occlude code was null");
		}

		Instructions ins = code.getInstructions();

		ListIterator<Instruction> it = ins.getInstructions().listIterator();

		while (it.hasNext())
		{
			Instruction i = it.next();

			if (!(i instanceof BiPush))
			{
				continue;
			}

			boolean shouldChange = (byte) ((BiPush) i).getConstant() == OLDVALUE;

			if (!shouldChange)
			{
				continue;
			}

			replaced++;

			Instruction biPush = new BiPush(ins, NEWVALUE);

			it.set(biPush);
		}

		stopwatch.stop();

		if (replaced != 10)
		{
			throw new InjectionException("Only found " + replaced + " 25's to replace in occlude instead of expected 10");
		}

		log.info("Changed {} values in occlude()", replaced);
		log.info("Occluder took {}", stopwatch.toString());
	}
}
