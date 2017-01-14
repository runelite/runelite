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
import net.runelite.asm.ClassFile;
import net.runelite.asm.ClassGroup;
import net.runelite.asm.Field;
import net.runelite.asm.attributes.Annotations;
import net.runelite.asm.attributes.annotation.Annotation;
import net.runelite.asm.attributes.annotation.Element;
import net.runelite.asm.signature.Type;
import net.runelite.runeloader.inject.AddInterfaceInstruction;
import net.runelite.runeloader.inject.GetterInjectInstruction;
import net.runelite.runeloader.inject.InjectionModscript;
import net.runelite.deob.util.JarUtil;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class MappingImporter
{
	private static final File IN = new File("d:/rs/07/gamepack_v18_annotationmap.jar");
	private static final File OUT = new File("d:/rs/07/adamout.jar");
	private static final File RL_INJECTION = new File(MappingImporter.class.getResource("/injection_v18.json").getFile());
	
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
					String str = (String) e.getValue();
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
			
			Annotations an = c.getAnnotations();
			if (this.hasObfuscatedName(an, name))
				return c;
		}
		return null;
	}
	
	private Field findFieldWithObfuscatedName(ClassFile c, String name)
	{
		for (Field f : c.getFields().getFields())
		{
			Annotations an = f.getAnnotations();
			if (this.hasObfuscatedName(an, name))
				return f;
		}
		return null;
	}

	@Test
	@Ignore
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
			attrName = Utils.toExportedName(attrName);

			Annotations an = f.getAnnotations();

			Annotation a = an.find(EXPORT);
			if (a != null)
			{
				String exportedName = a.getElement().getString();

				if (!attrName.equals(exportedName))
				{
					System.out.println("Exported field " + f + " with mismatched name. Theirs: " + attrName + ", mine: " + exportedName);
				}
			}
			else
			{
				an.addAnnotation(EXPORT, "value", attrName);
			}
		}
		
		for (AddInterfaceInstruction aii : mod.getAddInterfaceInjects())
		{
			ClassFile cf = this.findClassWithObfuscatedName(aii.getClientClass());
			Assert.assertNotNull(cf);
			
			String iface = aii.getInterfaceClass();
			
			iface = iface.replace("com/runeloader/api/bridge/os/accessor/", "");

			Annotations an = cf.getAnnotations();

			Annotation a = an.find(IMPLEMENTS);
			if (a != null)
			{
				String implementsName = a.getElement().getString();

				if (!iface.equals(implementsName))
				{
					System.out.println("Implements class " + cf + " with mismatched name. Theirs: " + iface + ", mine: " + implementsName);
				}
			}
			else
			{
				an.addAnnotation(IMPLEMENTS, "value", iface);
			}
		}
	}
}
