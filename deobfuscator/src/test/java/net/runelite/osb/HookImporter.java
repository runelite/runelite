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
package net.runelite.osb;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Map;
import net.runelite.asm.ClassFile;
import net.runelite.asm.ClassGroup;
import net.runelite.asm.Field;
import net.runelite.asm.Method;
import net.runelite.asm.Type;
import net.runelite.asm.attributes.Annotations;
import net.runelite.asm.attributes.annotation.Annotation;
import net.runelite.asm.attributes.annotation.Element;
import net.runelite.asm.signature.Signature;
import net.runelite.deob.util.JarUtil;
import net.runelite.osb.inject.ClassHook;
import net.runelite.osb.inject.FieldHook;
import net.runelite.osb.inject.MethodHook;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class HookImporter
{
	private static final File IN = new File("C:\\Users\\Adam\\.m2\\repository\\net\\runelite\\rs\\rs-client\\114.2-SNAPSHOT\\rs-client-114.2-SNAPSHOT.jar");
	private static final File OUT = new File("c:\\rs\\adamout.jar");

	private static final Type OBFUSCATED_NAME = new Type("Lnet/runelite/mapping/ObfuscatedName;");
	private static final Type IMPLEMENTS = new Type("Lnet/runelite/mapping/Implements;");
	private static final Type EXPORT = new Type("Lnet/runelite/mapping/Export;");
	private static final Type OBFUSCATED_SIGNATURE = new Type("Lnet/runelite/mapping/ObfuscatedSignature;");

	private Map<String, ClassHook> hooks;
	private ClassGroup group;

	@Before
	public void before() throws IOException
	{
		InputStream is = HookImporter.class.getResourceAsStream("osbmappings-114.json");
		Assert.assertNotNull(is);

		Gson gson = new Gson();
		java.lang.reflect.Type type = new TypeToken<Map<String, ClassHook>>()
		{
		}.getType();
		hooks = gson.fromJson(new InputStreamReader(is), type);

		group = JarUtil.loadJar(IN);
	}

	@After
	public void after() throws IOException
	{
		JarUtil.saveJar(group, OUT);
	}

	@Test
	@Ignore
	public void importHooks()
	{
		int classes = 0, fields = 0, methods = 0, callbacks = 0;

		for (String deobfuscatedClassName : hooks.keySet())
		{
			ClassHook ch = hooks.get(deobfuscatedClassName);
			ClassFile cf = this.findClassWithObfuscatedName(ch.getClazz());

			assert cf != null;

			String implementsName = getAnnotation(cf.getAnnotations(), IMPLEMENTS);
			if (implementsName.isEmpty())
			{
				cf.getAnnotations().addAnnotation(IMPLEMENTS, "value", deobfuscatedClassName);
				++classes;
			}

			for (String deobfuscatedFieldName : ch.getFields().keySet())
			{
				FieldHook fh = ch.getFields().get(deobfuscatedFieldName);

				String[] s = fh.getField().split("\\.");
				Field f;

				if (s.length == 2)
				{
					ClassFile cf2 = this.findClassWithObfuscatedName(s[0]);
					assert cf2 != null;

					f = this.findFieldWithObfuscatedName(cf2, s[1]);
				}
				else if (s.length == 1)
				{
					f = this.findFieldWithObfuscatedName(cf, fh.getField());
				}
				else
				{
					throw new RuntimeException();
				}

				assert f != null;

				String exportedName = getAnnotation(f.getAnnotations(), EXPORT);
				if (exportedName.isEmpty())
				{
					f.getAnnotations().addAnnotation(EXPORT, "value", deobfuscatedFieldName);
					++fields;
				}
			}

			for (String deobfuscatedMethodName : ch.getMethods().keySet())
			{
				MethodHook mh = ch.getMethods().get(deobfuscatedMethodName);

				String[] s = mh.getMethod().split("\\.");
				Method m;

				if (s.length == 2)
				{
					ClassFile cf2 = this.findClassWithObfuscatedName(s[0]);
					assert cf2 != null;

					m = this.findMethodWithObfuscatedName(cf2, s[1], mh.getClientDesc());
				}
				else if (s.length == 1)
				{
					m = this.findMethodWithObfuscatedName(cf, mh.getMethod(), mh.getClientDesc());
				}
				else
				{
					throw new RuntimeException();
				}

				assert m != null;

				String exportedName = getAnnotation(m.getAnnotations(), EXPORT);
				if (exportedName.isEmpty())
				{
					m.getAnnotations().addAnnotation(EXPORT, "value", deobfuscatedMethodName);
					++methods;
				}
			}

			for (String deobfuscatedMethodName : ch.getCallbacks().keySet())
			{
				MethodHook mh = ch.getCallbacks().get(deobfuscatedMethodName);

				String[] s = mh.getMethod().split("\\.");
				Method m;

				if (s.length == 2)
				{
					ClassFile cf2 = this.findClassWithObfuscatedName(s[0]);
					assert cf2 != null;

					m = this.findMethodWithObfuscatedName(cf2, s[1], mh.getClientDesc());
				}
				else if (s.length == 1)
				{
					m = this.findMethodWithObfuscatedName(cf, mh.getMethod(), mh.getClientDesc());
				}
				else
				{
					throw new RuntimeException();
				}

				assert m != null;

				String exportedName = getAnnotation(m.getAnnotations(), EXPORT);
				if (exportedName.isEmpty())
				{
					m.getAnnotations().addAnnotation(EXPORT, "value", deobfuscatedMethodName);
					++callbacks;
				}
			}
		}

		System.out.println("Imported " + classes + " classes, " + fields + " fields, " + methods + " methods, " + callbacks + " callbacks");
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
			if (getAnnotation(an, OBFUSCATED_NAME).equals(name))
			{
				Signature methodSig = getObfuscatedMethodSignature(m);

				if (methodSig.equals(sig))
				{
					return m;
				}
				else
				{
					methodSig.equals(sig);
					getObfuscatedMethodSignature(m);
				}
			}
		}
		return null;
	}

	private String getAnnotation(Annotations an, Type type)
	{
		if (an == null)
		{
			return "";
		}

		for (Annotation a : an.getAnnotations())
		{
			if (a.getType().equals(type))
			{
				for (Element e : a.getElements())
				{
					String str = (String) e.getValue();
					return str;
				}
			}
		}

		return "";
	}

	private Signature getObfuscatedMethodSignature(Method method)
	{
		String sig = getAnnotation(method.getAnnotations(), OBFUSCATED_SIGNATURE);
		if (sig.isEmpty() == false)
		{
			return toObSignature(new Signature(sig)); // if it is annoted, use that
		}
		else
		{
			return toObSignature(method.getDescriptor());
		}
	}

	private Type toObType(Type t)
	{
		if (t.isPrimitive())
		{
			return t;
		}

		if (!t.getInternalName().startsWith("class") && !t.getInternalName().equals("client"))
		{
			return t;
		}

		ClassFile cf = group.findClass(t.getInternalName());
		assert cf != null;

		Annotations an = cf.getAnnotations();
		String obfuscatedName = an.find(OBFUSCATED_NAME).getElement().getString();
		return Type.getType("L" + obfuscatedName + ";", t.getDimensions());
	}

	private Signature toObSignature(Signature s)
	{
		Signature.Builder builder = new Signature.Builder()
			.setReturnType(toObType(s.getReturnValue()));
		for (Type t : s.getArguments())
		{
			builder.addArgument(toObType(t));
		}
		return builder.build();
	}
}
