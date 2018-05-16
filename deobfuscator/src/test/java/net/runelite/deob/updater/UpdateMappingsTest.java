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
import net.runelite.deob.DeobAnnotations;
import net.runelite.deob.DeobTestProperties;
import net.runelite.deob.deobfuscators.mapping.AnnotationIntegrityChecker;
import net.runelite.deob.deobfuscators.mapping.AnnotationMapper;
import net.runelite.deob.deobfuscators.mapping.Mapper;
import net.runelite.deob.deobfuscators.mapping.ParallelExecutorMapping;
import net.runelite.deob.util.JarUtil;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UpdateMappingsTest
{
	private static final Logger logger = LoggerFactory.getLogger(UpdateMappingsTest.class);

	private static final String JAR = "d:/rs/07/gamepack_139_deobfuscated.jar",
		OUT = "d:/rs/07/adamout.jar";

	@Rule
	public DeobTestProperties properties = new DeobTestProperties();

	@Test
	@Ignore
	public void testManual() throws IOException
	{
		File client = new File(properties.getRsClient());

		ClassGroup group1 = JarUtil.loadJar(client);
		ClassGroup group2 = JarUtil.loadJar(new File(JAR));

		map(group1, group2);

		JarUtil.saveJar(group2, new File(OUT));
	}

	@Test
	public void testRun() throws IOException
	{
		File client = new File(properties.getRsClient());

		ClassGroup group1 = JarUtil.loadJar(client);
		ClassGroup group2 = JarUtil.loadJar(client);

		// Remove existing annotations
		unannotate(group2);

		// Map the client against itself
		map(group1, group2);

		check(group1, group2);
	}

	private void unannotate(ClassGroup group)
	{
		for (ClassFile cf : group.getClasses())
		{
			cf.getAnnotations().clearAnnotations();

			for (Field f : cf.getFields())
			{
				f.getAnnotations().clearAnnotations();
			}

			for (Method m : cf.getMethods())
			{
				m.getAnnotations().clearAnnotations();
			}
		}
	}

	private void check(ClassGroup group1, ClassGroup group2)
	{
		for (ClassFile cf : group1.getClasses())
		{
			ClassFile other = group2.findClass(cf.getName());

			String implname = DeobAnnotations.getImplements(cf);
			String otherimplname = DeobAnnotations.getImplements(other);

			Assert.assertEquals(implname, otherimplname);

			for (Field f : cf.getFields())
			{
				Field otherf = other.findField(f.getName(), f.getType());

				assert otherf != null : "unable to find " + f;

				String name = DeobAnnotations.getExportedName(f.getAnnotations());
				String otherName = DeobAnnotations.getExportedName(otherf.getAnnotations());

				Assert.assertEquals(name + " <-> " + otherName, name, otherName);
			}

			for (Method m : cf.getMethods())
			{
				Method otherm = other.findMethod(m.getName(), m.getDescriptor());

				assert otherm != null : "unable to find " + m;

				String name = DeobAnnotations.getExportedName(m.getAnnotations());
				String otherName = DeobAnnotations.getExportedName(otherm.getAnnotations());

				Assert.assertEquals(name + " <-> " + otherName, name, otherName);
			}
		}
	}

	private void map(ClassGroup group1, ClassGroup group2)
	{
		logger.info("Mapping group1 ({}) vs group2 ({})", desc(group1), desc(group2));

		Mapper mapper = new Mapper(group1, group2);
		mapper.run();
		ParallelExecutorMapping mapping = mapper.getMapping();

		summary(mapping, group1);

		AnnotationMapper amapper = new AnnotationMapper(group1, group2, mapping);
		amapper.run();

		AnnotationIntegrityChecker aic = new AnnotationIntegrityChecker(group1, group2, mapping);
		aic.run();

		if (aic.getErrors() > 0)
		{
			Assert.fail("Errors in annotation integrity checker");
		}

		AnnotationRenamer an = new AnnotationRenamer(group2);
		an.run();
	}

	private static String desc(ClassGroup cg)
	{
		int methods = 0, fields = 0, classes = 0;
		for (ClassFile cf : cg.getClasses())
		{
			++classes;
			methods += cf.getMethods().size();
			fields += cf.getFields().size();
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
				assert f.getClassFile().getGroup() == in;
			}
			else if (o instanceof Method)
			{
				Method m = (Method) o;
				assert m.getClassFile().getGroup() == in;

				if (m.isStatic())
				{
					++staticMethod;
				}
				else
				{
					++method;
				}
			}
			else if (o instanceof ClassFile)
			{
				++classes;
			}

			++total;
		}

		logger.info("Total mapped: {}. {} fields, {} static methods, {} member methods, {} classes",
			total, fields, staticMethod, method, classes);
	}

}
