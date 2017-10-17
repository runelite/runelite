/*
 * Copyright (c) 2017, Adam <Adam@sigterm.info>
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
package net.runelite.injector;

import java.io.InputStream;
import net.runelite.asm.ClassFile;
import net.runelite.asm.ClassGroup;
import net.runelite.asm.ClassUtil;
import net.runelite.asm.Field;
import static net.runelite.asm.Type.INT;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import static org.objectweb.asm.Opcodes.ACC_PUBLIC;

interface RSTarget
{
}

class Target implements RSTarget
{
}

abstract class Source
{
	@net.runelite.api.mixins.Inject
	public int foo;
}

public class MixinInjectorTest
{
	@Test
	public void testInject() throws Exception
	{
		InputStream in = getClass().getResourceAsStream("Target.class");
		ClassFile target = ClassUtil.loadClass(in);

		ClassGroup vanilla = new ClassGroup();
		vanilla.addClass(target);

		assertTrue(target.getFields().isEmpty());

		Inject inject = new Inject(null, vanilla);
		new MixinInjector(inject).inject(Source.class, RSTarget.class);

		Field field = target.findField("foo");
		assertNotNull(field);
		assertEquals(INT, field.getType());
		assertEquals(ACC_PUBLIC, field.getAccessFlags());
	}

}
