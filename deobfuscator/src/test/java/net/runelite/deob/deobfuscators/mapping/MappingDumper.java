/*
 * Copyright (c) 2017, Adam <Adam@sigterm.info>
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
package net.runelite.deob.deobfuscators.mapping;

import com.google.common.io.Files;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.time.Instant;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import net.runelite.asm.ClassFile;
import net.runelite.asm.ClassGroup;
import net.runelite.asm.Field;
import net.runelite.asm.Method;
import net.runelite.asm.Type;
import net.runelite.asm.attributes.code.Parameter;
import net.runelite.asm.signature.Signature;
import net.runelite.deob.Deob;
import net.runelite.deob.DeobAnnotations;
import net.runelite.deob.DeobTestProperties;
import net.runelite.deob.deobfuscators.mapping.mappingdumper.MappedClass;
import net.runelite.deob.deobfuscators.mapping.mappingdumper.MappedField;
import net.runelite.deob.deobfuscators.mapping.mappingdumper.MappedMethod;
import net.runelite.deob.deobfuscators.mapping.mappingdumper.MappingDump;
import net.runelite.deob.util.JarUtil;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MappingDumper
{
	@Rule
	public DeobTestProperties properties = new DeobTestProperties();

	private final Logger log = LoggerFactory.getLogger(MappingDumper.class);

	private MappingDump dump;
	private Map<String, MappedClass> classMap;
	private static final String OUTDIR = "";
	private final File OUTFILE = new File(OUTDIR, "rlplushooks.json");

	@Before
	public void before()
	{
		dump = new MappingDump();
		dump.revision = properties.getRsVersion();
		dump.classes = new ArrayList<>();
		dump.staticFields = new ArrayList<>();
		dump.staticMethods = new ArrayList<>();
		classMap = new HashMap<>();
	}

	@Test
	@Ignore
	public void newDump() throws IOException
	{
		final ClassGroup group = JarUtil.loadJar(new File(properties.getRsClient()));


		// First create all the mappedclasses, so we can add static methods to their lists
		for (ClassFile c : group.getClasses())
		{
			if (c.getName().contains("runelite"))
			{
				continue;
			}

			final MappedClass mc = new MappedClass();

			mc.obfuscatedName = DeobAnnotations.getObfuscatedName(c.getAnnotations());
			mc.implementingName = DeobAnnotations.getImplements(c);
			mc.superClass = c.getSuperName();
			mc.interfaces = c.getInterfaces().getIntfNames();
			mc.constructors = new ArrayList<>();
			mc.fields = new ArrayList<>();
			mc.methods = new ArrayList<>();
			mc.access = c.getAccess();
			mc.staticMethods = new ArrayList<>();
			mc.staticFields = new ArrayList<>();

			dump.classes.add(mc);
			classMap.put(c.getName(), mc);

			dump.totalClasses++;
			if (mc.implementingName != null)
			{
				dump.totalNamedClasses++;
			}
		}

		for (ClassFile c : group.getClasses())
		{
			if (c.getName().contains("runelite"))
			{
				continue;
			}

			final MappedClass mc = classMap.get(c.getName());

			getFields(c, mc);

			getMethods(c, mc);
		}

		dump.totalNonStaticFields = dump.totalFields - dump.totalStaticFields;
		dump.totalNamedNonStaticFields = dump.totalNamedFields - dump.totalNamedStaticFields;
		dump.totalNonStaticMethods = dump.totalMethods - dump.totalStaticMethods;
		dump.totalNamedNonStaticMethods = dump.totalNamedMethods - dump.totalNamedStaticMethods;

		final Gson gson = new GsonBuilder().setPrettyPrinting().create();
		Files.asCharSink(OUTFILE, Charset.defaultCharset()).write(gson.toJson(dump));

		log.info("Dumped current mappings. revision {}", dump.revision);
		log.info("Total classes: {}. Total mapped classes: {}. ({}%)", dump.totalClasses, dump.totalNamedClasses, dump.totalNamedClasses * 100 / dump.totalClasses);
		log.info("Total non static methods: {}. Total mapped non static methods: {}. ({}%)", dump.totalNonStaticMethods, dump.totalNamedNonStaticMethods, dump.totalNamedNonStaticMethods * 100 / dump.totalNamedMethods);
		log.info("Total methods: {}. Total mapped methods: {}. ({}%)", dump.totalMethods, dump.totalNamedMethods, dump.totalNamedMethods * 100 / dump.totalMethods);
		log.info("Total fields: {}. Total mapped fields: {}. ({}%)", dump.totalFields, dump.totalNamedFields, dump.totalNamedFields * 100 / dump.totalFields);
		log.info("Total non static fields: {}. Total mapped non static fields: {}. ({}%)", dump.totalNonStaticFields, dump.totalNamedNonStaticFields, dump.totalNamedNonStaticFields * 100 / dump.totalNamedFields);

	}

	private void getFields(final ClassFile c, final MappedClass mc)
	{
		for (Field f : c.getFields())
		{
			dump.totalFields++;

			if (f.isStatic())
			{
				dump.totalStaticFields++;
			}

			if (Deob.isObfuscated(f.getName()))
			{
				continue;
			}

			dump.totalNamedFields++;

			final MappedField mf = new MappedField();

			mf.exportedName = f.getName();
			mf.owner = mc.obfuscatedName;
			mf.obfuscatedName = DeobAnnotations.getObfuscatedName(f.getAnnotations());
			mf.access = f.getAccessFlags();
			mf.descriptor = DeobAnnotations.getAnnotationValue(f.getAnnotations(), DeobAnnotations.OBFUSCATED_SIGNATURE);

			Number decoder = DeobAnnotations.getObfuscatedGetter(f);
			if (decoder != null)
			{
				mf.decoder = decoder.longValue();
			}

			if (mf.descriptor == null)
			{
				mf.descriptor = f.getType().toString();
			}

			if (f.isStatic())
			{
				dump.staticFields.add(mf);
				dump.totalNamedStaticFields++;

				int _index = mf.exportedName.indexOf('_');

				if (_index != -1)
				{
					String className = mf.exportedName.substring(0, _index);
					MappedClass staticOwner = classMap.get(className);

					if (staticOwner != null)
					{
						staticOwner.staticFields.add(mf);
					}
				}
			}
			else
			{
				mc.fields.add(mf);
			}
		}
	}

	private void getMethods(final ClassFile c, final MappedClass mc)
	{
		for (Method m : c.getMethods())
		{
			dump.totalMethods++;

			if (m.isStatic())
			{
				dump.totalStaticMethods++;
			}

			if (Deob.isObfuscated(m.getName()) || m.getName().equals("<clinit>"))
			{
				continue;
			}

			dump.totalNamedMethods++;

			final MappedMethod mm = new MappedMethod();

			mm.exportedName = m.getName();
			mm.owner = mc.obfuscatedName;
			mm.obfuscatedName = DeobAnnotations.getObfuscatedName(m.getAnnotations());
			mm.access = m.getAccessFlags();
			mm.parameters = new ArrayList<>();
			mm.descriptor = DeobAnnotations.getObfuscatedSignature(m) != null ? DeobAnnotations.getObfuscatedSignature(m).toString() : m.getDescriptor().toString();

			try
			{
				mm.garbageValue = Long.parseLong(DeobAnnotations.getDecoder(m));
			}
			catch (NumberFormatException e)
			{
				mm.garbageValue = null;
			}

			for (Parameter p : m.getParameters())
			{
				mm.parameters.add(p.getName());
			}

			if (m.getName().equals("<init>"))
			{
				mm.exportedName = null;
				mc.constructors.add(mm);
				continue;
			}

			if (m.isStatic())
			{
				dump.staticMethods.add(mm);
				dump.totalNamedStaticMethods++;

				int _index = mm.exportedName.indexOf('_');

				if (_index != -1)
				{
					String className = mm.exportedName.substring(0, _index - 1);
					MappedClass staticOwner = classMap.get(className);

					if (staticOwner != null)
					{
						staticOwner.staticMethods.add(mm);
					}
				}
			}
			else
			{
				mc.methods.add(mm);
			}
		}
	}

	@Test
	public void dump() throws IOException
	{
		ClassGroup group = JarUtil.loadJar(new File(properties.getRsClient()));

		final String GAP = "%-40s";
		int classes = 0, methods = 0, fields = 0;

		StringBuilder mBuilder = new StringBuilder();
		StringBuilder sBuilder = new StringBuilder();
		StringBuilder tmp;

		for (ClassFile cf : group.getClasses())
		{
			String implName = DeobAnnotations.getImplements(cf);
			String className = DeobAnnotations.getObfuscatedName(cf.getAnnotations());

			if (implName != null)
			{
				mBuilder.append("\n").append(implName).append(" -> ").append(className).append("\n");
				++classes;
			}

			for (Field f : cf.getFields())
			{
				String exportName = DeobAnnotations.getExportedName(f.getAnnotations());

				if (exportName == null)
				{
					continue;
				}

				++fields;

				String fieldName = DeobAnnotations.getObfuscatedName(f.getAnnotations());
				Type type = f.getType();
				Number getter = DeobAnnotations.getObfuscatedGetter(f);

				String fieldType = typeToString(type);

				if (f.isStatic())
				{
					tmp = sBuilder;
				}

				else
				{
					tmp = mBuilder;
				}

				tmp.append("\t").append(String.format(GAP, fieldType)).append(String.format(GAP, exportName))
						.append(className).append(".").append(fieldName);

				if (getter != null)
				{
					tmp.append(" * ").append(getter).append("\n");
				}

				else
				{
					tmp.append("\n");
				}
			}

			for (Method m : cf.getMethods())
			{
				String exportName = DeobAnnotations.getExportedName(m.getAnnotations());

				if (exportName == null)
				{
					continue;
				}

				methods++;

				String methodName = DeobAnnotations.getObfuscatedName(m.getAnnotations());
				Signature signature = DeobAnnotations.getObfuscatedSignature(m);
				String garbageValue = DeobAnnotations.getDecoder(m);

				if (signature == null)
				{
					signature = m.getDescriptor();
				}

				String returnType = typeToString(m.getDescriptor().getReturnValue());
				String[] paramTypes = new String[signature.size()];
				for (int i = 0; i < paramTypes.length; i++)
				{
					paramTypes[i] = typeToString(signature.getTypeOfArg(i));
				}

				if (m.isStatic())
				{
					tmp = sBuilder;
				}

				else
				{
					tmp = mBuilder;
				}

				tmp.append("\t").append(String.format(GAP, returnType)).append(String.format(GAP, exportName))
						.append(className).append(".").append(methodName);

				tmp.append("(");
				for (int i = 0; i < paramTypes.length; i++)
				{
					tmp.append(paramTypes[i]);

					if (i == paramTypes.length - 1)
					{
						if (garbageValue != null)
						{
							tmp.append(" = ").append(garbageValue);
						}
					}

					else
					{
						tmp.append(", ");
					}
				}
				tmp.append(")\n");
			}
		}

		System.out.println("RuneLite http://github.com/runelite");
		System.out.println("Run " + Instant.now());
		System.out.println("Classes: " + classes + ", methods: " + methods + ", fields: " + fields);
		System.out.println("Gamepack " + properties.getRsVersion());
		System.out.println(mBuilder.toString());
		System.out.println("Static ->");
		System.out.println(sBuilder.toString());
	}

	@Test
	public void dumpJson() throws IOException
	{
		ClassGroup group = JarUtil.loadJar(new File(properties.getRsClient()));

		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		JsonObject jObject = new JsonObject();
		JsonArray jFields = new JsonArray();
		JsonArray jMethods = new JsonArray();

		for (ClassFile cf : group.getClasses())
		{
			String implName = DeobAnnotations.getImplements(cf);
			String className = DeobAnnotations.getObfuscatedName(cf.getAnnotations());

			for (Field f : cf.getFields())
			{
				String exportName = DeobAnnotations.getExportedName(f.getAnnotations());

				if (exportName == null)
				{
					continue;
				}

				String fieldName = DeobAnnotations.getObfuscatedName(f.getAnnotations());
				Type obfType = DeobAnnotations.getObfuscatedType(f);
				Number getter = DeobAnnotations.getObfuscatedGetter(f);

				JsonObject jField = new JsonObject();

				jField.addProperty("name", exportName);
				jField.addProperty("owner", f.isStatic() ? "" : implName);
				jField.addProperty("class", className);
				jField.addProperty("field", fieldName);
				jField.addProperty("obfSignature", (obfType != null ? obfType.toString() : ""));
				jField.addProperty("signature", f.getType().toString());
				jField.addProperty("multiplier", (getter != null ? getter : 0));
				jField.addProperty("static", f.isStatic());

				jFields.add(jField);
			}

			for (Method m : cf.getMethods())
			{

				String exportName = DeobAnnotations.getExportedName(m.getAnnotations());

				if (exportName == null)
				{
					continue;
				}

				String methodName = DeobAnnotations.getObfuscatedName(m.getAnnotations());
				Signature obfSignature = DeobAnnotations.getObfuscatedSignature(m);
				String predicate = DeobAnnotations.getDecoder(m);

				JsonObject jMethod = new JsonObject();

				jMethod.addProperty("name", exportName);
				jMethod.addProperty("owner", m.isStatic() ? "" : implName);
				jMethod.addProperty("class", className);
				jMethod.addProperty("field", methodName);
				jMethod.addProperty("obfSignature", (obfSignature != null ? obfSignature.toString() : ""));
				jMethod.addProperty("signature", m.getDescriptor().toString());
				jMethod.addProperty("predicate", (predicate != null ? predicate : ""));
				jMethod.addProperty("static", m.isStatic());

				jMethods.add(jMethod);

			}
		}

		jObject.addProperty("runelite", "http://github.com/runelite");
		jObject.addProperty("run", Instant.now().toString());
		jObject.addProperty("gamepack", properties.getRsVersion());
		jObject.add("fields", jFields);
		jObject.add("methods", jMethods);

		System.out.println(gson.toJson(jObject));
	}

	private static String typeToString(Type type)
	{
		String subType;
		switch (type.toString())
		{
			case "B":
				subType = byte.class.getCanonicalName();
				break;
			case "C":
				subType = char.class.getCanonicalName();
				break;
			case "I":
				subType = int.class.getCanonicalName();
				break;
			case "S":
				subType = short.class.getCanonicalName();
				break;
			case "Z":
				subType = boolean.class.getCanonicalName();
				break;
			case "D":
				subType = double.class.getCanonicalName();
				break;
			case "F":
				subType = float.class.getCanonicalName();
				break;
			case "J":
				subType = long.class.getCanonicalName();
				break;
			case "V":
				subType = void.class.getCanonicalName();
				break;
			default:
				subType = type.getInternalName();
				break;
		}

		if (type.isArray())
		{
			for (int i = 0; i < type.getDimensions(); ++i)
			{
				subType += "[]";
			}
		}

		return subType;
	}
}
