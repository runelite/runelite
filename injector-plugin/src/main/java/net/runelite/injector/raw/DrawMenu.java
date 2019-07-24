package net.runelite.injector.raw;

import java.util.ListIterator;
import net.runelite.asm.ClassFile;
import net.runelite.asm.Method;
import net.runelite.asm.attributes.Code;
import net.runelite.asm.attributes.code.Instruction;
import net.runelite.asm.attributes.code.Instructions;
import net.runelite.asm.attributes.code.Label;
import net.runelite.asm.attributes.code.instruction.types.JumpingInstruction;
import net.runelite.asm.attributes.code.instructions.GetStatic;
import net.runelite.asm.attributes.code.instructions.IfEq;
import net.runelite.asm.attributes.code.instructions.IfNe;
import net.runelite.asm.attributes.code.instructions.InvokeStatic;
import net.runelite.asm.pool.Class;
import net.runelite.asm.pool.Field;
import net.runelite.asm.signature.Signature;
import net.runelite.injector.Inject;
import static net.runelite.injector.InjectUtil.findDeobField;
import static net.runelite.injector.InjectUtil.findStaticMethod;
import net.runelite.injector.InjectionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DrawMenu
{
	private final Logger log = LoggerFactory.getLogger(DrawMenu.class);
	private final Inject inject;
	private static final net.runelite.asm.pool.Method hook = new net.runelite.asm.pool.Method(
		new Class("net.runelite.client.callback.Hooks"),
		"drawMenu",
		new Signature("()Z")
	);

	//Label Getstatic client.isMenuOpen
	//Ifne -> Label Drawmenu
	//Jump -> Label Drawtext

	//Label drawtext
	//Ldc xxx
	//Getstatic client. something with viewport size?
	//Imul
	//Iconst_m1
	//Ifne -> Label after draw menu <- info we need
	//Getstatic / LDC (same getstatic and LDC before)
	//Getstatic / LDC

	public DrawMenu(Inject inject)
	{
		this.inject = inject;
	}

	public void inject() throws InjectionException
	{
		Field isMenuOpen = findDeobField(inject, "isMenuOpen").getPoolField();
		net.runelite.asm.pool.Method topLeftText = findStaticMethod(inject, "drawMenuActionTextAt").getPoolMethod();

		for (ClassFile cf : inject.getVanilla().getClasses())
		{
			for (Method m : cf.getMethods())
			{
				Code c = m.getCode();
				if (c == null)
				{
					continue;
				}

				Instructions ins = c.getInstructions();
				ListIterator<Instruction> it = ins.getInstructions().listIterator();
				int injectIndex = -1;
				Label after = null;
				boolean foundBefore = false;
				boolean foundAfter = false;

				while (it.hasNext())
				{
					Instruction i = it.next();

					if (!(i instanceof GetStatic) && !(i instanceof InvokeStatic))
					{
						continue;
					}

					if (!foundBefore && i instanceof GetStatic)
					{
						if (!((GetStatic) i).getField().equals(isMenuOpen))
						{
							continue;
						}

						i = it.next();
						if (!(i instanceof IfEq) && !(i instanceof IfNe))
						{
							continue;
						}

						if (i instanceof IfEq)
						{
							injectIndex = it.nextIndex();
						}
						else
						{
							injectIndex = ins.getInstructions().indexOf(((IfNe) i).getJumps().get(0)) + 1;
						}
						foundBefore = true;
					}
					else if (!foundAfter && i instanceof InvokeStatic
						&& ((InvokeStatic) i).getMethod().equals(topLeftText))
					{
						i = it.next();
						assert i instanceof JumpingInstruction;
						after = ((JumpingInstruction) i).getJumps().get(0);
						foundAfter = true;
					}

					if (foundBefore && foundAfter)
					{
						break;
					}
				}

				if (!foundBefore || !foundAfter || injectIndex == -1)
				{
					continue;
				}

				ins.addInstruction(injectIndex, new IfNe(ins, after));
				ins.addInstruction(injectIndex, new InvokeStatic(ins, hook));
				log.info("Injected drawmenu hook in {} at index {}", m, injectIndex);
				return;
			}
		}

	}
}