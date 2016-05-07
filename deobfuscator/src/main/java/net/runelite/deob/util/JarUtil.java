/*
 * Copyright (c) 2016, Adam <Adam@sigterm.info>
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 * 1. Redistributions of source code must retain the above copyright
 *    notice, this list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright
 *    notice, this list of conditions and the following disclaimer in the
 *    documentation and/or other materials provided with the distribution.
 * 3. All advertising materials mentioning features or use of this software
 *    must display the following acknowledgement:
 *    This product includes software developed by Adam <Adam@sigterm.info>
 * 4. Neither the name of the Adam <Adam@sigterm.info> nor the
 *    names of its contributors may be used to endorse or promote products
 *    derived from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY Adam <Adam@sigterm.info> ''AS IS'' AND ANY
 * EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL Adam <Adam@sigterm.info> BE LIABLE FOR ANY
 * DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package net.runelite.deob.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.jar.JarOutputStream;
import java.util.jar.Manifest;
import net.runelite.asm.ClassFile;
import net.runelite.asm.ClassGroup;
import net.runelite.asm.objectwebasm.AsmUtils;

public class JarUtil
{
	public static ClassGroup loadJar(File jarfile) throws IOException
	{
		ClassGroup group = new ClassGroup();

		try (JarFile jar = new JarFile(jarfile))
		{
			for (Enumeration<JarEntry> it = jar.entries(); it.hasMoreElements();)
			{
				JarEntry entry = it.nextElement();
				
				if (!entry.getName().endsWith(".class"))
					continue;
				
				InputStream is = jar.getInputStream(entry);
				group.addClass(entry.getName(), new DataInputStream(is));
			}
		}
		
		group.initialize();
		
		return group;
	}
	
	public static void saveJar(ClassGroup group, File jarfile) throws IOException
	{
		try (JarOutputStream jout = new JarOutputStream(new FileOutputStream(jarfile), new Manifest()))
		{
			for (ClassFile cf : group.getClasses())
			{
				JarEntry entry = new JarEntry(cf.getName() + ".class");
				jout.putNextEntry(entry);
				
				ByteArrayOutputStream bout = new ByteArrayOutputStream();
				cf.write(new DataOutputStream(bout));

				// run through asm to generate stackmaps
				byte[] b = AsmUtils.rebuildWithStackmaps(group, new ByteArrayInputStream(bout.toByteArray()));

				jout.write(b);
				
				jout.closeEntry();
			}
		}
	}
}
