/*
 * Copyright (c) 2018, UniquePassive <https://github.com/uniquepassive>
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

import java.util.List;
import net.runelite.asm.ClassFile;
import net.runelite.asm.ClassGroup;
import net.runelite.asm.ClassUtil;
import net.runelite.asm.Method;
import net.runelite.asm.attributes.code.Instruction;
import net.runelite.asm.attributes.code.instructions.InvokeStatic;
import net.runelite.asm.signature.Signature;
import net.runelite.injector.Inject;
import org.junit.Test;
import static net.runelite.injector.raw.ClientErrorFilter.METHOD_TO_INJECT_NAME;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class ClientErrorFilterTest
{
	@Test
	public void testInjectRev161() throws Exception
	{
		ClassFile obClass = ClassUtil.loadClass(getClass().getResourceAsStream("/clienterrorfilter/kk_ob161.class"));

		ClassGroup vanilla = new ClassGroup();
		vanilla.addClass(obClass);

		Inject inject = new Inject(new ClassGroup(), vanilla);
		new ClientErrorFilter(inject).inject();

		assertNotNull(obClass.findMethod(METHOD_TO_INJECT_NAME));

		Method methodToInjectInto = obClass.findMethod("n", new Signature("(Ljava/lang/String;Ljava/lang/Throwable;I)V"));

		List<Instruction> instructions = methodToInjectInto.getCode().getInstructions().getInstructions();

		boolean found = false;

		for (Instruction i : instructions)
		{
			if (i instanceof InvokeStatic)
			{
				InvokeStatic is = (InvokeStatic) i;

				if (is.getMethod().getName().equals(METHOD_TO_INJECT_NAME))
				{
					found = true;
					break;
				}
			}
		}

		assertTrue(found);
	}
}
