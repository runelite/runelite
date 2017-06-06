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
package net.runelite.asm.execution;

import java.io.IOException;
import java.io.InputStream;
import net.runelite.asm.ClassFile;
import net.runelite.asm.ClassGroup;
import net.runelite.asm.ClassUtil;
import net.runelite.asm.Method;
import net.runelite.deob.deobfuscators.mapping.MappingExecutorUtil;
import net.runelite.deob.deobfuscators.mapping.ParallelExecutorMapping;
import org.junit.Assert;
import org.junit.Test;

public class ParallelMappingExecutorTest
{
	@Test
	public void testTableswitch() throws IOException
	{
		InputStream in = ParallelMappingExecutorTest.class.getResourceAsStream("tests/TableSwitch.class");
		Assert.assertNotNull(in);

		ClassGroup group = new ClassGroup();
		ClassFile cf = ClassUtil.loadClass(in);
		group.addClass(cf);

		in = ParallelMappingExecutorTest.class.getResourceAsStream("tests/TableSwitch.class");
		Assert.assertNotNull(in);

		ClassGroup group2 = new ClassGroup();
		ClassFile cf2 = ClassUtil.loadClass(in);
		group2.addClass(cf2);

		Method m1 = cf.findMethod("method");
		Method m2 = cf2.findMethod("method");

		ParallelExecutorMapping map = MappingExecutorUtil.map(m1, m2);
		Assert.assertEquals(cf2.findField("field2"), map.get(cf.findField("field2")));
	}
}
