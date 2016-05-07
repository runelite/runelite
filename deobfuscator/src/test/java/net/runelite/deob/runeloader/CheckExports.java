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

package net.runelite.deob.runeloader;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.List;
import net.runelite.deob.runeloader.inject.GetterInjectInstruction;
import net.runelite.deob.runeloader.inject.InjectionModscript;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class CheckExports
{
	private static final File CLIENT = new File("/Users/adam/w/rs/07/rs-client-1.0-SNAPSHOT.jar");
	private static final File RL_INJECTION = new File("/Users/adam/w/rs/07/rl/injection.json");
	
	private final List<Class> classes = new ArrayList<>();
	
	@Before
	public void before() throws MalformedURLException, ClassNotFoundException
	{
		ClassLoader loader = new URLClassLoader(new URL[] { CLIENT.toURL() });
		
		Class c = loader.loadClass("net.runelite.rs.client.client");
		classes.add(c);
		
		for (int i = 0; i < 230; ++i)
		{
			try
			{
				c = loader.loadClass("net.runelite.rs.client.class" + i);
				classes.add(c);
			}
			catch (ClassNotFoundException ex)
			{
			}
		}
	}
	
	private Class<?> findClassWithObfuscatedName(String name)
	{
		for (Class c : classes)
		{
			if (c.getName().equals("net.runelite.rs.client.client") && name.equals("client"))
				return c;
			
			ObfuscatedName oc = (ObfuscatedName) c.getDeclaredAnnotation(ObfuscatedName.class);
			if (oc == null)
				continue;
			
			if (oc.value().equals(name))
				return c;
		}
		return null;
	}
	
	private Field findFieldWithObfuscatedName(Class c, String name)
	{
		for (Field f : c.getDeclaredFields())
		{
			ObfuscatedName oc = (ObfuscatedName) f.getDeclaredAnnotation(ObfuscatedName.class);
			if (oc == null)
				continue;
			
			if (oc.value().equals(name))
				return f;
		}
		return null;
	}
	
	private boolean isExported(Field f)
	{
		Export export = (Export) f.getDeclaredAnnotation(Export.class);
		return export != null;
	}

	@Test
	@Ignore
	public void checkMappings() throws IOException
	{
		InjectionModscript mod = InjectionModscript.load(RL_INJECTION);
		
		for (int i = 0; i < mod.getGetterInjects().size(); ++i)
		{
			GetterInjectInstruction gii = (GetterInjectInstruction) mod.getGetterInjects().get(i);
			
			Class c = this.findClassWithObfuscatedName(gii.getGetterClassName());
			Assert.assertNotNull(c);
			
			Field f = this.findFieldWithObfuscatedName(c, gii.getGetterFieldName());
			Assert.assertNotNull(f);
			
			Assert.assertTrue(this.isExported(f));
		}
	}
}
