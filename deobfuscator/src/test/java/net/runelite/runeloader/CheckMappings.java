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

package net.runelite.runeloader;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.List;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.runeloader.inject.GetterInjectInstruction;
import net.runelite.runeloader.inject.Injection;
import net.runelite.runeloader.inject.InjectionModscript;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class CheckMappings
{
	private static final File CLIENT = new File("d:/rs/07/adamout.jar");

	private final List<Class> classes = new ArrayList<>();

	@Before
	public void before() throws MalformedURLException, ClassNotFoundException
	{
		ClassLoader loader = new URLClassLoader(new URL[]{CLIENT.toURI().toURL()});

		Class c = loader.loadClass("client");
		classes.add(c);

		for (int i = 0; i < 230; ++i)
		{
			try
			{
				c = loader.loadClass("class" + i);
				classes.add(c);
			}
			catch (ClassNotFoundException ex)
			{
			}
		}
	}

	@SuppressWarnings("unchecked")
	private Class<?> findClassWithObfuscatedName(String name)
	{
		for (Class c : classes)
		{
			if (c.getName().equals("net.runelite.rs.client.client") && name.equals("client"))
			{
				return c;
			}

			ObfuscatedName oc = (ObfuscatedName) c.getDeclaredAnnotation(ObfuscatedName.class);
			if (oc == null)
			{
				continue;
			}

			if (oc.value().equals(name))
			{
				return c;
			}
		}
		return null;
	}

	private Field findFieldWithObfuscatedName(Class c, String name)
	{
		for (Field f : c.getDeclaredFields())
		{
			ObfuscatedName oc = f.getDeclaredAnnotation(ObfuscatedName.class);
			if (oc == null)
			{
				continue;
			}

			if (oc.value().equals(name))
			{
				return f;
			}
		}
		return null;
	}

	private Integer getIntegerMultiplier(Field f)
	{
		ObfuscatedGetter getter = f.getDeclaredAnnotation(ObfuscatedGetter.class);
		if (getter == null)
		{
			return null;
		}
		return getter.intValue() == 0 ? null : getter.intValue();
	}

	private String getExportedName(Field f)
	{
		Export e = f.getDeclaredAnnotation(Export.class);
		if (e == null)
		{
			return null;
		}
		return e.value();
	}

	@Test
	@Ignore
	public void checkMappings() throws IOException
	{
		InjectionModscript mod = Injection.load(MappingImporter.class.getResourceAsStream(MappingImporter.RL_INJECTION));

		for (int i = 0; i < mod.getGetterInjects().size(); ++i)
		{
			GetterInjectInstruction gii = mod.getGetterInjects().get(i);

			Class c = this.findClassWithObfuscatedName(gii.getGetterClassName());
			Assert.assertNotNull(c);

			Field f = this.findFieldWithObfuscatedName(c, gii.getGetterFieldName());
			Assert.assertNotNull(f);

			String exportedName = this.getExportedName(f);
			String attrName = gii.getGetterName();
			attrName = Utils.toExportedName(attrName);

			Integer mul = gii.getMultiplier(),
				myMul = this.getIntegerMultiplier(f);

			// XXX Check @Export etc names

			//Assert.assertEquals(exportedName, attrName);
			Assert.assertEquals(myMul, mul);
		}
	}
}
