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
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class CheckMappings
{
	private static final File CLIENT = new File("d:/rs/07/adamout.jar");
	private static final File RL_INJECTION = new File(CheckMappings.class.getResource("/injection_v18.json").getFile());
	
	private final List<Class> classes = new ArrayList<>();
	
	@Before
	public void before() throws MalformedURLException, ClassNotFoundException
	{
		ClassLoader loader = new URLClassLoader(new URL[] { CLIENT.toURL() });
		
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
	
	private Integer getIntegerMultiplier(Field f)
	{
		ObfuscatedGetter getter = (ObfuscatedGetter) f.getDeclaredAnnotation(ObfuscatedGetter.class);
		if (getter == null)
			return null;
		return getter.intValue() == 0 ? null : getter.intValue();
	}

	private String getExportedName(Field f)
	{
		Export e = (Export) f.getDeclaredAnnotation(Export.class);
		if (e == null)
			return null;
		return e.value();
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
