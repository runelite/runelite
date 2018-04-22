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

import java.util.ListIterator;
import net.runelite.asm.ClassFile;
import net.runelite.asm.Field;
import net.runelite.asm.Method;
import net.runelite.asm.attributes.code.Instruction;
import net.runelite.asm.attributes.code.Instructions;
import net.runelite.asm.attributes.code.instructions.GetStatic;
import net.runelite.asm.attributes.code.instructions.IMul;
import net.runelite.asm.attributes.code.instructions.IStore;
import net.runelite.asm.attributes.code.instructions.InvokeStatic;
import net.runelite.asm.attributes.code.instructions.LDC;
import net.runelite.asm.signature.Signature;
import net.runelite.deob.DeobAnnotations;
import net.runelite.injector.Inject;
import net.runelite.injector.InjectionException;
import static net.runelite.injector.InjectHookMethod.HOOKS;

public class ForcePlaySound
{
	private final Inject inject;

	public ForcePlaySound(Inject inject)
	{
		this.inject = inject;
	}

	public void inject() throws InjectionException
	{
		injectForcePlaySound();
	}

	private void injectForcePlaySound() throws InjectionException
	{
		boolean injected = false;

		Field soundEffectVolume = findStaticField("soundEffectVolume");

		if (soundEffectVolume == null)
		{
			throw new InjectionException("Mapped field \"soundEffectVolume\" could not be found.");
		}

		net.runelite.asm.pool.Field poolSoundEffectVolume = soundEffectVolume.getPoolField();

		for (ClassFile c : inject.getVanilla().getClasses())
		{
			for (Method m : c.getMethods())
			{
				if (m.getCode() == null)
				{
					continue;
				}

				Instructions instructions = m.getCode().getInstructions();

				// Let's find "getstatic <some class>.soundEffectVolume":
				// (Revision 168)
				// LDC -946689099
				// GETSTATIC client.pf : I
				// IMUL
				// ISTORE 3

				ListIterator<Instruction> iterator = instructions.getInstructions().listIterator();
				while (iterator.hasNext())
				{
					Instruction i = iterator.next();

					if (!(i instanceof GetStatic))
					{
						continue;
					}

					if (!iterator.hasNext())
					{
						break;
					}

					Instruction i2 = iterator.next();

					if (!(i2 instanceof IMul) && !(i2 instanceof LDC))
					{
						iterator.previous();
						continue;
					}

					if (!iterator.hasNext())
					{
						break;
					}

					Instruction i3 = iterator.next();

					if (!(i3 instanceof IStore))
					{
						iterator.previous();
						continue;
					}

					GetStatic gs = (GetStatic) i;

					if (!gs.getField().equals(poolSoundEffectVolume))
					{
						continue;
					}

					InvokeStatic invoke = new InvokeStatic(instructions,
						new net.runelite.asm.pool.Method(
							new net.runelite.asm.pool.Class(HOOKS),
							"getVolumeForQueuedSoundEffects",
							new Signature("()I")
						)
					);

					// Remove:
					// LDC -946689099
					// GETSTATIC client.pf : I
					// IMUL

					iterator.previous();
					iterator.previous();
					iterator.remove();
					iterator.previous();
					iterator.remove();
					iterator.previous();
					iterator.remove();

					// Add invoke before "istore"

					iterator.add(invoke);

					injected = true;
				}
			}
		}

		if (!injected)
		{
			throw new InjectionException("injectForcePlaySound failed to inject!");
		}
	}

	private Field findStaticField(String name)
	{
		for (ClassFile c : inject.getDeobfuscated().getClasses())
		{
			for (Field f : c.getFields())
			{
				if (!f.getName().equals(name))
				{
					continue;
				}

				if (!f.isStatic())
				{
					continue;
				}

				String obfuscatedName = DeobAnnotations.getObfuscatedName(f.getAnnotations());

				ClassFile c2 = inject.toObClass(c);
				return c2.findField(obfuscatedName);
			}
		}

		return null;
	}
}
