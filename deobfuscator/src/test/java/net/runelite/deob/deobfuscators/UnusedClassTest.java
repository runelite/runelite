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
import java.io.InputStream;
import net.runelite.asm.ClassFile;
import net.runelite.asm.ClassGroup;
import net.runelite.asm.ClassUtil;
import net.runelite.deob.DeobTestProperties;
import net.runelite.deob.TemporyFolderLocation;
import net.runelite.deob.util.JarUtil;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

public class UnusedClassTest
{
	@Rule
	public DeobTestProperties properties = new DeobTestProperties();

	@Rule
	public TemporaryFolder folder = TemporyFolderLocation.getTemporaryFolder();

	private ClassGroup group;

	@Before
	public void before() throws IOException
	{
		group = new ClassGroup();

		load("EmptyInterface.class");
		load("ClassA.class");
		ClassFile emptyClass = load("EmptyClass.class");
		
		emptyClass.removeMethod(emptyClass.findMethod("<init>"));
	}

	private ClassFile load(String name) throws IOException
	{
		InputStream in = UnusedClassTest.class.getResourceAsStream("unusedclass/" + name);
		Assert.assertNotNull(in);

		ClassFile cf = ClassUtil.loadClass(in);
		group.addClass(cf);
		
		return cf;
	}

	@After
	public void after() throws IOException
	{
		JarUtil.saveJar(group, folder.newFile());
	}

	@Test
	public void testRun()
	{
		UnusedClass uc = new UnusedClass();
		uc.run(group);
		
		Assert.assertNotNull(group.findClass("net/runelite/deob/deobfuscators/unusedclass/ClassA"));
		Assert.assertNull(group.findClass("net/runelite/deob/deobfuscators/unusedclass/EmptyClass"));
		Assert.assertNotNull(group.findClass("net/runelite/deob/deobfuscators/unusedclass/EmptyInterface"));
	}
}
