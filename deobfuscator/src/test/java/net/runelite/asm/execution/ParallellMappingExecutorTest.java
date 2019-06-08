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

import net.runelite.asm.ClassFile;
import net.runelite.asm.ClassGroup;
import net.runelite.asm.ClassUtil;
import net.runelite.asm.Method;
import net.runelite.deob.deobfuscators.mapping.MappingExecutorUtil;
import net.runelite.deob.deobfuscators.mapping.ParallelExecutorMapping;
import org.junit.Assert;
import org.junit.Test;

public class ParallellMappingExecutorTest
{
	@Test
	public void testStaticStep() throws Exception
	{
		ClassFile cf1 = ClassUtil.loadClass(getClass().getResourceAsStream("mapper/StaticStepTest.class"));
		ClassFile cf2 = ClassUtil.loadClass(getClass().getResourceAsStream("mapper/StaticStepTest.class"));

		ClassGroup group1 = new ClassGroup();
		ClassGroup group2 = new ClassGroup();

		group1.addClass(cf1);
		group2.addClass(cf2);

		group1.buildClassGraph();
		group1.lookup();

		group2.buildClassGraph();
		group2.lookup();

		Method m1 = cf1.findMethod("entry");
		Method m2 = cf2.findMethod("entry");

		Method map1 = cf1.findMethod("map"),
			map2 = cf2.findMethod("map");

		Assert.assertNotNull(map1);
		Assert.assertNotNull(map2);

		ParallelExecutorMapping map = MappingExecutorUtil.map(m1, m2);
		Assert.assertEquals(map2, map.get(map1));
	}

}
