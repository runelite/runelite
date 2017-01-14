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

package net.runelite.deob.updater;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import net.runelite.asm.ClassFile;
import net.runelite.asm.ClassGroup;
import net.runelite.asm.Field;
import net.runelite.asm.Method;
import net.runelite.deob.deobfuscators.mapping.AnnotationIntegrityChecker;
import net.runelite.deob.deobfuscators.mapping.AnnotationMapper;
import net.runelite.deob.deobfuscators.mapping.Mapper;
import net.runelite.deob.deobfuscators.mapping.ParallelExecutorMapping;
import net.runelite.deob.util.JarUtil;
import org.junit.Ignore;
import org.junit.Test;

public class UpdateMappingsTest
{
	private static final String JAR1 = "C:\\Users\\Adam\\.m2\\repository\\net\\runelite\\rs\\rs-client\\116.2-SNAPSHOT\\rs-client-116.2-SNAPSHOT.jar",
		JAR2 = "d:/rs/07/gamepack_117_deobfuscated.jar",
		OUT = "d:/rs/07/adamout.jar";

	@Test
	@Ignore
	public void testRun() throws IOException
	{
		ClassGroup group1 = JarUtil.loadJar(new File(JAR1));
		ClassGroup group2 = JarUtil.loadJar(new File(JAR2));

		Mapper mapper = new Mapper(group1, group2);
		mapper.run();
		ParallelExecutorMapping mapping = mapper.getMapping();

		summary(mapping, group1);

		String sg1 = print(group1),
			sg2 = print(group2);

		System.out.println("GROUP 1 " + sg1);
		System.out.println("GROUP 2 " + sg2);

		AnnotationMapper amapper = new AnnotationMapper(group1, group2, mapping);
		amapper.run();

		AnnotationIntegrityChecker aic = new AnnotationIntegrityChecker(group1, group2, mapping);
		aic.run();

		AnnotationRenamer an = new AnnotationRenamer(group2);
		an.run();

		JarUtil.saveJar(group2, new File(OUT));
	}

	public static String print(ClassGroup cg)
	{
		int methods = 0, fields = 0, classes = 0;
		for (ClassFile cf : cg.getClasses())
		{
			++classes;
			methods += cf.getMethods().getMethods().size();
			fields += cf.getFields().getFields().size();
		}
		int total = methods + fields + classes;
		return "total: " + total + ", " + methods + " methods, " + fields + " fields, " + classes + " classes";
	}

	public static void summary(ParallelExecutorMapping finalm, ClassGroup in)
	{
		int fields = 0, staticMethod = 0, method = 0, total = 0, classes = 0;
		for (Map.Entry<Object, Object> e : finalm.getMap().entrySet())
		{
			Object o = e.getKey();
			if (o instanceof Field)
			{
				++fields;

				Field f = (Field) o;
				assert f.getFields().getClassFile().getGroup() == in;
			}
			else if (o instanceof Method)
			{
				Method m = (Method) o;
				assert m.getMethods().getClassFile().getGroup() == in;

				if (m.isStatic())
					++staticMethod;
				else
					++method;
			}
			else if (o instanceof ClassFile)
				++classes;

			++total;
		}
		System.out.println("Total " + total + ". " + fields + " fields, " + staticMethod + " static methods, " + method + " non-static methods, " + classes + " classes");
	}

}
