/*
 * Copyright (c) 2018, Lotto <https://github.com/devLotto>
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *    list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
 * ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package net.runelite.injector.raw;

import java.util.HashSet;
import java.util.ListIterator;
import java.util.Set;
import net.runelite.asm.ClassFile;
import net.runelite.asm.Method;
import net.runelite.asm.attributes.code.Instruction;
import net.runelite.asm.attributes.code.Instructions;
import net.runelite.asm.attributes.code.Label;
import net.runelite.asm.attributes.code.instruction.types.JumpingInstruction;
import net.runelite.asm.attributes.code.instruction.types.PushConstantInstruction;
import net.runelite.asm.attributes.code.instructions.GetStatic;
import net.runelite.asm.attributes.code.instructions.IMul;
import net.runelite.asm.attributes.code.instructions.InvokeStatic;
import net.runelite.asm.signature.Signature;
import net.runelite.injector.Inject;
import static net.runelite.injector.InjectHookMethod.HOOKS;
import static net.runelite.injector.InjectUtil.findStaticMethod;
import net.runelite.injector.InjectionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DrawAfterWidgets
{
	private static final Logger logger = LoggerFactory.getLogger(DrawAfterWidgets.class);

	private final Inject inject;

	public DrawAfterWidgets(Inject inject)
	{
		this.inject = inject;
	}

	public void inject() throws InjectionException
	{
		injectDrawAfterWidgets();
	}

	private void injectDrawAfterWidgets() throws InjectionException
	{
		/*
			This call has to be injected using raw injection because the
			drawWidgets method gets inlined in some revisions. If it wouldn't be,
			mixins would be used to add the call to the end of drawWidgets.

			--> This hook depends on the positions of "if (535573958 * kl != -1)" and "jz.db();".


			Revision 180 - client.gs():
			______________________________________________________

		   @Export("drawLoggedIn")
		   final void drawLoggedIn() {
		      if(rootInterface != -1) {
		         ClientPreferences.method1809(rootInterface);
		      }

		      int var1;
		      for(var1 = 0; var1 < rootWidgetCount; ++var1) {
		         if(__client_od[var1]) {
		            __client_ot[var1] = true;
		         }

		         __client_oq[var1] = __client_od[var1];
		         __client_od[var1] = false;
		      }

		      __client_oo = cycle;
		      __client_lq = -1;
		      __client_ln = -1;
		      UserComparator6.__fg_jh = null;
		      if(rootInterface != -1) {
		         rootWidgetCount = 0;
		         Interpreter.method1977(rootInterface, 0, 0, SoundCache.canvasWidth, Huffman.canvasHeight, 0, 0, -1);
		      }

				< --  here appearantly

		      Rasterizer2D.Rasterizer2D_resetClip();
			______________________________________________________
		 */

		boolean injected = false;

		Method noClip = findStaticMethod(inject, "Rasterizer2D_resetClip"); // !!!!!

		if (noClip == null)
		{
			throw new InjectionException("Mapped method \"Rasterizer2D_resetClip\" could not be found.");
		}

		net.runelite.asm.pool.Method poolNoClip = noClip.getPoolMethod();

		for (ClassFile c : inject.getVanilla().getClasses())
		{
			for (Method m : c.getMethods())
			{
				if (m.getCode() == null)
				{
					continue;
				}

				Instructions instructions = m.getCode().getInstructions();

				Set<Label> labels = new HashSet<>();

				// Let's find "invokestatic <some class>.noClip()" and its label
				ListIterator<Instruction> labelIterator = instructions.getInstructions().listIterator();
				while (labelIterator.hasNext())
				{
					Instruction i = labelIterator.next();

					if (!(i instanceof InvokeStatic))
					{
						continue;
					}

					InvokeStatic is = (InvokeStatic) i;

					if (!is.getMethod().equals(poolNoClip))
					{
						continue;
					}

					labelIterator.previous();
					Instruction i2 = labelIterator.previous();
					labelIterator.next();
					labelIterator.next();

					// Find the label that marks the code path for the instruction
					if (!(i2 instanceof Label))
					{
						continue;
					}

					// There can be several noClip invocations in a method, so let's catch them all
					labels.add((Label) i2);
				}

				if (labels.isEmpty())
				{
					// If we get here, we're either in the wrong method
					// or Jagex has removed the "if (535573958 * kl != -1)"
					//	logger.debug("Could not find the label for jumping to the " + noClip + " call in " + m);
					continue;
				}

				Set<Label> labelsToInjectAfter = new HashSet<>();

				ListIterator<Instruction> jumpIterator = instructions.getInstructions().listIterator();
				while (jumpIterator.hasNext())
				{
					Instruction i = jumpIterator.next();

					if (!(i instanceof JumpingInstruction))
					{
						continue;
					}

					JumpingInstruction ji = (JumpingInstruction) i;

					Label label = null;

					for (Label l : labels)
					{
						if (ji.getJumps().contains(l))
						{
							label = l;
							break;
						}
					}

					if (label == null)
					{
						continue;
					}

					jumpIterator.previous();

					Set<Instruction> insns = new HashSet<>();
					insns.add(jumpIterator.previous());
					insns.add(jumpIterator.previous());
					insns.add(jumpIterator.previous());
					insns.add(jumpIterator.previous());

					// Get the iterator back to i's position
					jumpIterator.next();
					jumpIterator.next();
					jumpIterator.next();
					jumpIterator.next();
					jumpIterator.next();

					/*
						Check that these instruction types are passed into the if-statement:

						ICONST_M1
						GETSTATIC client.kr : I
						LDC 634425425
						IMUL

						We cannot depend on the order of these because of the obfuscation,
						so let's make it easier by just checking that they are there.
					 */
					if (insns.stream().filter(i2 -> i2 instanceof PushConstantInstruction).count() != 2
						|| insns.stream().filter(i2 -> i2 instanceof IMul).count() != 1
						|| insns.stream().filter(i2 -> i2 instanceof GetStatic).count() != 1)
					{
						continue;
					}

					// At this point, we have found the real injection point
					labelsToInjectAfter.add(label);
				}

				for (Label l : labelsToInjectAfter)
				{
					InvokeStatic invoke = new InvokeStatic(instructions,
						new net.runelite.asm.pool.Method(
							new net.runelite.asm.pool.Class(HOOKS),
							"drawAfterWidgets",
							new Signature("()V")
						)
					);

					instructions.addInstruction(instructions.getInstructions().indexOf(l) + 1, invoke);

					logger.info("injectDrawAfterWidgets injected a call after " + l);

					injected = true;
				}
			}
		}

		if (!injected)
		{
			throw new InjectionException("injectDrawAfterWidgets failed to inject!");
		}
	}
}
