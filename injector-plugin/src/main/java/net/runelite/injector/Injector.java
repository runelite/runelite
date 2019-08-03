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
package net.runelite.injector;

import java.io.File;
import java.io.IOException;

import com.google.common.io.Files;
import net.runelite.asm.ClassFile;
import net.runelite.asm.ClassGroup;
import net.runelite.deob.util.JarUtil;

public class Injector
{
	private final ClassGroup deobfuscated, vanilla;

	public Injector(ClassGroup deobfuscated, ClassGroup vanilla)
	{
		this.deobfuscated = deobfuscated;
		this.vanilla = vanilla;
	}

	public static void main(String[] args) throws IOException, InjectionException
	{
		if (args.length < 3)
		{
			System.exit(-1);
		}

		ClassGroup deobfuscated = JarUtil.loadJar(new File(args[0]));
		ClassGroup vanilla = JarUtil.loadJar(new File(args[1]));

		Injector u = new Injector(
			deobfuscated,
			vanilla
		);
		u.inject();

		InjectorValidator iv = new InjectorValidator(vanilla);
		iv.validate();

		u.save(new File(args[2]));
	}

	public void inject() throws InjectionException
	{
		Inject instance = new Inject(deobfuscated, vanilla);
		instance.run();
	}

	private void save(File out) throws IOException
	{
		out.mkdirs();
		for (ClassFile cf : vanilla.getClasses())
		{
			File f = new File(out, cf.getClassName() + ".class");
			byte[] data = JarUtil.writeClass(vanilla, cf);
			Files.write(data, f);
		}
	}


}
