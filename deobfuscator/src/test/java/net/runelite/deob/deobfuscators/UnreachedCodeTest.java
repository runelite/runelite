/*
 * Copyright (c) 2016-2017, Adam <Adam@sigterm.info>
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
package net.runelite.deob.deobfuscators;

import java.io.IOException;
import net.runelite.asm.ClassFile;
import net.runelite.asm.ClassGroup;
import net.runelite.asm.ClassUtil;
import net.runelite.asm.Method;
import net.runelite.asm.attributes.code.Label;
import net.runelite.deob.TemporyFolderLocation;
import net.runelite.deob.util.JarUtil;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

public class UnreachedCodeTest
{
	@Rule
	public TemporaryFolder folder = TemporyFolderLocation.getTemporaryFolder();

	private ClassGroup group;

	@Before
	public void before() throws IOException
	{
		ClassFile cf = ClassUtil.loadClass(UnreachedCodeTest.class.getResourceAsStream("unreachedcode/UnreachableTest.class"));
		Assert.assertNotNull(cf);

		group = new ClassGroup();
		group.addClass(cf);
	}

	@After
	public void after() throws IOException
	{
		JarUtil.saveJar(group, folder.newFile());
	}

	@Test
	public void testRun() throws IOException
	{
		UnreachedCode uc = new UnreachedCode();
		uc.run(group);

		ClassFile cf = group.getClasses().get(0);

		Method method = cf.findMethod("entry");
		Assert.assertFalse(method.getCode().getExceptions().getExceptions().isEmpty());

		method = cf.findMethod("method1Unused");
		Assert.assertNotNull(method);
		Assert.assertFalse(method.getCode().getInstructions().getInstructions().stream().filter(i -> !(i instanceof Label)).findAny().isPresent());
		Assert.assertTrue(method.getCode().getExceptions().getExceptions().isEmpty());
		
		// Method is now invalid, remove so jar can be saved
		cf.removeMethod(method);

		// constructor now has no instructions
		method = cf.findMethod("<init>");
		Assert.assertNotNull(method);
		Assert.assertFalse(method.getCode().getInstructions().getInstructions().stream().filter(i -> !(i instanceof Label)).findAny().isPresent());

		// remove it too
		cf.removeMethod(method);
	}
}
