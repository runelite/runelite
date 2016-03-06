package net.runelite.deob.runeloader;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import net.runelite.deob.ClassFile;
import net.runelite.deob.ClassGroup;
import net.runelite.deob.Field;
import net.runelite.deob.Interfaces;
import net.runelite.deob.attributes.Annotations;
import net.runelite.deob.attributes.AttributeType;
import net.runelite.deob.attributes.annotation.Annotation;
import net.runelite.deob.attributes.annotation.Element;
import net.runelite.deob.pool.UTF8;
import net.runelite.deob.runeloader.inject.AddInterfaceInstruction;
import net.runelite.deob.runeloader.inject.GetterInjectInstruction;
import net.runelite.deob.runeloader.inject.InjectionModscript;
import net.runelite.deob.signature.Type;
import net.runelite.deob.util.JarUtil;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MappingImporter
{
	private static final File IN = new File("d:/rs/07/adamin.jar");
	private static final File OUT = new File("d:/rs/07/adamout.jar");
	private static final File RL_INJECTION = new File(MappingImporter.class.getResource("/injection_v16.json").getFile());
	
	private static final Type OBFUSCATED_NAME = new Type("Lnet/runelite/mapping/ObfuscatedName;");
	private static final Type EXPORT = new Type("Lnet/runelite/mapping/Export;");
	private static final Type IMPLEMENTS = new Type("Lnet/runelite/mapping/Implements;");
	
	private ClassGroup group;
	
	@Before
	public void before() throws IOException
	{
		group = JarUtil.loadJar(IN);
	}
	
	@After
	public void after() throws IOException
	{
		JarUtil.saveJar(group, OUT);
	}
	
	private boolean hasObfuscatedName(Annotations an, String name)
	{
		if (an == null)
		{
			return false;
		}

		for (Annotation a : an.getAnnotations())
		{
			if (a.getType().equals(OBFUSCATED_NAME))
			{
				for (Element e : a.getElements())
				{
					String str = (String) e.getValue().getObject();
					if (str.equals(name))
					{
						return true;
					}
				}
			}
		}

		return false;
	}
	
	private ClassFile findClassWithObfuscatedName(String name)
	{
		for (ClassFile c : group.getClasses())
		{
			if (c.getName().equals(name))
				return c;
			
			Annotations an = (Annotations) c.getAttributes().findType(AttributeType.RUNTIMEVISIBLEANNOTATIONS);
			if (this.hasObfuscatedName(an, name))
				return c;
		}
		return null;
	}
	
	private Field findFieldWithObfuscatedName(ClassFile c, String name)
	{
		for (Field f : c.getFields().getFields())
		{
			Annotations an = (Annotations) f.getAttributes().findType(AttributeType.RUNTIMEVISIBLEANNOTATIONS);
			if (this.hasObfuscatedName(an, name))
				return f;
		}
		return null;
	}

	@Test
	public void makeMappings() throws IOException
	{
		InjectionModscript mod = InjectionModscript.load(RL_INJECTION);
		
		for (int i = 0; i < mod.getGetterInjects().size(); ++i)
		{
			GetterInjectInstruction gii = (GetterInjectInstruction) mod.getGetterInjects().get(i);
			
			ClassFile cf = this.findClassWithObfuscatedName(gii.getGetterClassName());
			Assert.assertNotNull(cf);
			
			Field f = this.findFieldWithObfuscatedName(cf, gii.getGetterFieldName());
			Assert.assertNotNull(f);
			
			String attrName = gii.getGetterName();
			if (attrName.startsWith("get"))
			{
				attrName = attrName.substring(3);
				attrName = Character.toLowerCase(attrName.charAt(0)) + attrName.substring(1);
			}
			
			f.getAttributes().addAnnotation(EXPORT, "value", new UTF8(attrName));
		}
		
		for (AddInterfaceInstruction aii : mod.getAddInterfaceInjects())
		{
			ClassFile cf = this.findClassWithObfuscatedName(aii.getClientClass());
			Assert.assertNotNull(cf);
			
			String iface = aii.getInterfaceClass();
			
			iface = iface.replace("com/runeloader/api/bridge/os/accessor/", "");
			
			cf.getAttributes().addAnnotation(IMPLEMENTS, "value", new UTF8(iface));
		}
	}
}
