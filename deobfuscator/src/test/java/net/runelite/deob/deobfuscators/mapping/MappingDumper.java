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

import java.io.File;
import java.io.IOException;
import java.time.Instant;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import net.runelite.asm.ClassFile;
import net.runelite.asm.ClassGroup;
import net.runelite.asm.Field;
import net.runelite.asm.Method;
import net.runelite.asm.signature.Signature;
import net.runelite.asm.signature.Type;
import net.runelite.deob.DeobAnnotations;
import net.runelite.deob.DeobProperties;
import net.runelite.deob.util.JarUtil;
import org.junit.Rule;
import org.junit.Test;

public class MappingDumper
{
	@Rule
	public DeobProperties properties = new DeobProperties();

	@Test
	public void dump() throws IOException
	{
		ClassGroup group = JarUtil.loadJar(new File(properties.getRsClient()));

		int classes = 0, methods = 0, fields = 0;

		StringBuilder builder = new StringBuilder();
		StringBuilder sBuilder = new StringBuilder();

		for (ClassFile cf : group.getClasses())
		{
			String impl = DeobAnnotations.getImplements(cf),
				obfName = DeobAnnotations.getObfuscatedName(cf.getAnnotations());

			String classPrefix = obfName + ".";

			if (impl != null)
			{
				builder.append("\n").append(impl).append(" -> ").append(obfName).append("\n");
				++classes;
			}

			for (Field f : cf.getFields().getFields())
			{
				obfName = DeobAnnotations.getObfuscatedName(f.getAnnotations());
				String deobName = DeobAnnotations.getExportedName(f.getAnnotations());
				Number getter = DeobAnnotations.getObfuscatedGetter(f);

				if (deobName == null)
				{
					continue;
				}

				++fields;

				String type = typeToString(f.getType());

				if (f.isStatic())
				{
					sBuilder.append("\t").append(String.format("%-25s", type)).append(String.format("%-25s", deobName))
						.append(classPrefix).append(obfName);

					if (getter != null)
					{
						sBuilder.append(" * ").append(getter).append("\n");
					}

					else
					{
						sBuilder.append("\n");
					}
				}

				else
				{
					builder.append("\t").append(String.format("%-25s", type)).append(String.format("%-25s", deobName))
							.append(classPrefix).append(obfName);

					if (getter != null)
					{
						builder.append(" * ").append(getter).append("\n");
					}

					else
					{
						builder.append("\n");
					}
				}
			}

			for (Method m : cf.getMethods().getMethods())
			{
				obfName = DeobAnnotations.getObfuscatedName(m.getAnnotations());
				Signature obfSignature = DeobAnnotations.getObfuscatedSignature(m);

				String deobName = DeobAnnotations.getExportedName(m.getAnnotations());
				Number predicate = DeobAnnotations.getObfuscatedPredicate(m);
				Signature deobSig = m.getDescriptor();

				if (deobName == null)
				{
					continue;
				}

				methods++;

				String type = typeToString(deobSig.getReturnValue());
				String[] params;

				if (obfSignature != null)
				{
					params = new String[obfSignature.size()];
					for (int i = 0; i < params.length; i++)
					{
						params[i] = typeToString(obfSignature.getTypeOfArg(i));
					}
				}

				else
				{
					params = new String[deobSig.size()];
					for (int i = 0; i < params.length; i++)
					{
						params[i] = typeToString(deobSig.getTypeOfArg(i));
					}
				}

				if (m.isStatic())
				{
					sBuilder.append("\t").append(String.format("%-25s", type)).append(String.format("%-25s", deobName))
							.append(classPrefix).append(obfName);

					sBuilder.append("(");
					for (int i = 0; i < params.length; i++)
					{
						sBuilder.append(params[i]).append((i == params.length - 1 ? "" : ", "));
					}
					sBuilder.append(")\n");
				}

				else
				{
					builder.append("\t").append(String.format("%-25s", type)).append(String.format("%-25s", deobName))
							.append(classPrefix).append(obfName);

					builder.append("(");
					for (int i = 0; i < params.length; i++)
					{
						builder.append(params[i]);

						if (i == params.length - 1)
						{
							if (predicate != null)
							{
								builder.append(" = ").append(predicate);
							}
						}

						else
						{
							builder.append(", ");
						}
					}
					builder.append(")\n");
				}
			}
		}

		System.out.println("Runelite http://github.com/runelite");
		System.out.println("Run " + Instant.now());
		System.out.println("Classes: " + classes + ", methods: " + methods + ", fields: " + fields);
		System.out.println("Gamepack " + properties.getRsVersion());
		System.out.println(builder.toString());
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
			String impl = DeobAnnotations.getImplements(cf), obfName = DeobAnnotations.getObfuscatedName(cf.getAnnotations());
			String classPrefix = obfName;

			for (Field f : cf.getFields().getFields())
			{
				obfName = DeobAnnotations.getObfuscatedName(f.getAnnotations());
				String deobName = DeobAnnotations.getExportedName(f.getAnnotations());
				Number getter = DeobAnnotations.getObfuscatedGetter(f);

				if (deobName == null)
				{
					continue;
				}

				JsonObject jField = new JsonObject();

				jField.addProperty("name", deobName);
				jField.addProperty("owner", f.isStatic() ? "" : impl);
				jField.addProperty("class", classPrefix);
				jField.addProperty("field", obfName);
				jField.addProperty("signiture", f.getType().getFullType());
				jField.addProperty("multiplier", (getter != null ? getter : 0));
				jField.addProperty("static", f.isStatic());

				jFields.add(jField);
			}

			for (Method m : cf.getMethods().getMethods())
			{
				obfName = DeobAnnotations.getObfuscatedName(m.getAnnotations());
				Signature obfSignature = DeobAnnotations.getObfuscatedSignature(m);

				String deobName = DeobAnnotations.getExportedName(m.getAnnotations());
				Number predicate = DeobAnnotations.getObfuscatedPredicate(m);
				Signature deobSig = m.getDescriptor();

				if (deobName == null)
				{
					continue;
				}

				JsonObject jMethod = new JsonObject();

				jMethod.addProperty("name", deobName);
				jMethod.addProperty("owner", m.isStatic() ? "" : impl);
				jMethod.addProperty("class", classPrefix);
				jMethod.addProperty("field", obfName);
				jMethod.addProperty("obfSigniture", (obfSignature != null ? obfSignature.toString() : ""));
				jMethod.addProperty("signiture", (deobSig != null ? deobSig.toString() : ""));
				jMethod.addProperty("predicate", (predicate != null ? predicate : 0));
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
		switch (type.getType())
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
				String t = type.getType();
				subType = t.substring(1, t.length() - 1).replace("/", ".");
				break;
		}

		if (type.isArray())
		{
			for (int i = 0; i < type.getArrayDims(); ++i)
			{
				subType += "[]";
			}
		}

		return subType;
	}
}
