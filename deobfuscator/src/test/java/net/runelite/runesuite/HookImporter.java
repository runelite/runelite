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
package net.runelite.runesuite;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import net.runelite.asm.ClassFile;
import net.runelite.asm.ClassGroup;
import net.runelite.asm.Field;
import net.runelite.asm.Method;
import net.runelite.asm.Type;
import net.runelite.asm.attributes.Annotations;
import net.runelite.asm.attributes.annotation.Annotation;
import net.runelite.asm.attributes.annotation.Element;
import net.runelite.asm.signature.Signature;
import net.runelite.asm.signature.util.VirtualMethods;
import static net.runelite.deob.DeobAnnotations.EXPORT;
import static net.runelite.deob.DeobAnnotations.IMPLEMENTS;
import static net.runelite.deob.DeobAnnotations.OBFUSCATED_NAME;
import static net.runelite.deob.DeobAnnotations.OBFUSCATED_SIGNATURE;
import net.runelite.deob.DeobTestProperties;
import net.runelite.deob.TemporyFolderLocation;
import net.runelite.deob.deobfuscators.Renamer;
import net.runelite.deob.util.JarUtil;
import net.runelite.deob.util.NameMappings;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HookImporter
{
	private static final Logger logger = LoggerFactory.getLogger(HookImporter.class);

	@Rule
	public DeobTestProperties properties = new DeobTestProperties();

	@Rule
	public TemporaryFolder folder = TemporyFolderLocation.getTemporaryFolder();

	private List<HookClass> hooks;
	private ClassGroup group;

	@Before
	public void before() throws IOException
	{
		group = JarUtil.loadJar(new File(properties.getRsClient()));;

		InputStream is = getClass().getResourceAsStream("hooks.json");
		Gson gson = new Gson();
		java.lang.reflect.Type type = new TypeToken<List<HookClass>>()
		{
		}.getType();
		hooks = gson.fromJson(new InputStreamReader(is), type);
	}

	@After
	public void after() throws IOException
	{
		File out = folder.newFile("client.jar");
		JarUtil.saveJar(group, out);
		logger.info("Wrote to {}", out);
	}

	@Test
	@Ignore
	public void importHooks()
	{
		int classes = 0, fields = 0, methods = 0;
		NameMappings mappings = new NameMappings();

		for (HookClass hc : hooks)
		{

			ClassFile cf = findClassWithObfuscatedName(hc.name);

			assert cf != null;

			String implementsName = getAnnotation(cf.getAnnotations(), IMPLEMENTS);
			if (implementsName.isEmpty())
			{
				String deobfuscatedClassName = hc.clazz;
				cf.getAnnotations().addAnnotation(IMPLEMENTS, "value", deobfuscatedClassName);
				mappings.map(cf.getPoolClass(), deobfuscatedClassName);
				++classes;
			}

			for (HookField fh : hc.fields)
			{
				ClassFile cf2 = findClassWithObfuscatedName(fh.owner);
				assert cf2 != null;

				Field f = findFieldWithObfuscatedName(cf2, fh.name);
				if (f == null)
				{
					logger.warn("Missing field {}", fh); // inlined constant maybe?
					continue;
				}

				String exportedName = getAnnotation(f.getAnnotations(), EXPORT);
				if (exportedName.isEmpty())
				{
					String deobfuscatedFieldName = fh.field;

					Field other = cf2.findField(deobfuscatedFieldName);
					if (other != null)
					{
						logger.warn("Name collision for field {}", deobfuscatedFieldName);
						continue;
					}

					f.getAnnotations().addAnnotation(EXPORT, "value", deobfuscatedFieldName);
					mappings.map(f.getPoolField(), deobfuscatedFieldName);
					++fields;
				}
			}

			outer:
			for (HookMethod hm : hc.methods)
			{

				ClassFile cf2 = findClassWithObfuscatedName(hm.owner);
				assert cf2 != null;

				Method m = findMethodWithObfuscatedName(cf2, hm.name, hm.descriptor);
				assert m != null;

				// maybe only the base class method is exported
				List<Method> virtualMethods = VirtualMethods.getVirtualMethods(m);
				for (Method method : virtualMethods)
				{
					String exportedName = getAnnotation(method.getAnnotations(), EXPORT);
					if (!exportedName.isEmpty())
					{
						continue outer;
					}
				}

				String deobfuscatedMethodName = hm.method;
				m.getAnnotations().addAnnotation(EXPORT, "value", deobfuscatedMethodName);
				mappings.map(m.getPoolMethod(), deobfuscatedMethodName);
				++methods;
			}
		}

		Renamer renamer = new Renamer(mappings);
		renamer.run(group);

		logger.info("Imported {} classes, {} fields, {} methods", classes, fields, methods);
	}

	private ClassFile findClassWithObfuscatedName(String name)
	{
		for (ClassFile c : group.getClasses())
		{
			if (c.getName().equals(name))
			{
				return c;
			}

			Annotations an = c.getAnnotations();
			if (getAnnotation(an, OBFUSCATED_NAME).equals(name))
			{
				return c;
			}
		}
		return null;
	}

	private Field findFieldWithObfuscatedName(ClassFile c, String name)
	{
		for (Field f : c.getFields())
		{
			Annotations an = f.getAnnotations();
			if (getAnnotation(an, OBFUSCATED_NAME).equals(name))
			{
				return f;
			}
		}
		return null;
	}

	private Method findMethodWithObfuscatedName(ClassFile c, String name, String signature)
	{
		Signature sig = new Signature(signature);

		for (Method m : c.getMethods())
		{
			Annotations an = m.getAnnotations();
			if (m.getName().equals(name) || getAnnotation(an, OBFUSCATED_NAME).equals(name))
			{
				Signature methodSig = getObfuscatedMethodSignature(m);

				if (methodSig.equals(sig))
				{
					return m;
				}
			}
		}
		return null;
	}

	private String getAnnotation(Annotations an, Type type)
	{
		Annotation a = an.find(type);
		if (a != null)
		{
			for (Element e : a.getElements())
			{
				String str = (String) e.getValue();
				return str;
			}
		}

		return "";
	}

	private Signature getObfuscatedMethodSignature(Method method)
	{
		String sig = getAnnotation(method.getAnnotations(), OBFUSCATED_SIGNATURE);
		if (sig.isEmpty() == false)
		{
			return new Signature(sig); // if it is annotated, use that
		}
		else
		{
			return method.getDescriptor();
		}
	}
}
