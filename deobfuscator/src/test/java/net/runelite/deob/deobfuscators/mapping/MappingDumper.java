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
package net.runelite.deob.deobfuscators.mapping;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.time.Instant;
import net.runelite.asm.ClassFile;
import net.runelite.asm.ClassGroup;
import net.runelite.asm.Field;
import net.runelite.asm.Method;
import net.runelite.asm.signature.Signature;
import net.runelite.deob.DeobAnnotations;
import net.runelite.deob.DeobProperties;
import net.runelite.deob.util.JarUtil;
import org.junit.Rule;
import org.junit.Test;

public class MappingDumper
{
	@Rule
	public DeobProperties properties = new DeobProperties();

	@Test
	public void dump() throws IOException
	{
		ClassGroup group = JarUtil.loadJar(new File(properties.getRsClient()));

		int classes = 0, methods = 0, fields = 0;

		ByteArrayOutputStream bout = new ByteArrayOutputStream();
		PrintStream out = new PrintStream(bout);

		for (ClassFile cf : group.getClasses())
		{
			String impl = DeobAnnotations.getImplements(cf),
				obfName = DeobAnnotations.getObfuscatedName(cf.getAnnotations());

			String classPrefix = obfName + ".";
			boolean neednl = false;

			if (impl != null)
			{
				out.println(obfName + " -> " + impl);
				++classes;
				neednl = true;
			}

			for (Field f : cf.getFields().getFields())
			{
				obfName = DeobAnnotations.getObfuscatedName(f.getAnnotations());
				String deobName = DeobAnnotations.getExportedName(f.getAnnotations());
				Number getter = DeobAnnotations.getObfuscatedGetter(f);

				if (deobName == null)
				{
					continue;
				}

				String prefix = f.isStatic() ? "static " : "       ";
				++fields;
				neednl = true;

				if (getter != null)
				{
					out.println(prefix + f.getType() + " " + deobName + " -> " + classPrefix + obfName + " * " + getter);
				}
				else
				{
					out.println(prefix + f.getType() + " " + deobName + " -> " + classPrefix + obfName);
				}
			}

			for (Method m : cf.getMethods().getMethods())
			{
				obfName = DeobAnnotations.getObfuscatedName(m.getAnnotations());
				Signature obfSignature = DeobAnnotations.getObfuscatedSignature(m);

				String deobName = DeobAnnotations.getExportedName(m.getAnnotations());
				Signature deobSig = m.getDescriptor();

				if (deobName == null)
				{
					continue;
				}

				String prefix = m.isStatic() ? "static " : "       ";
				++methods;
				neednl = true;

				out.println(prefix + deobName + " " + deobSig + " -> " + classPrefix + obfName + " " + obfSignature);
			}

			if (neednl)
			{
				out.println("");
			}
		}

		System.out.println("Runelite http://github.com/runelite");
		System.out.println("Run " + Instant.now());
		System.out.println("Classes: " + classes + ", methods: " + methods + ", fields: " + fields);
		System.out.println("Gamepack " + properties.getRsVersion());
		System.out.println("");
		System.out.println(new String(bout.toByteArray()));
	}
}
