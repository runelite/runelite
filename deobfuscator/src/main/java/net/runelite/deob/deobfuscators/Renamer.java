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

package net.runelite.deob.deobfuscators;

import java.util.List;
import net.runelite.asm.ClassFile;
import net.runelite.asm.ClassGroup;
import net.runelite.asm.Field;
import net.runelite.asm.Interfaces;
import net.runelite.asm.Method;
import net.runelite.asm.attributes.Code;
import net.runelite.asm.attributes.annotation.Annotation;
import net.runelite.asm.attributes.code.Exceptions;
import net.runelite.asm.attributes.code.Instruction;
import net.runelite.asm.signature.Signature;
import net.runelite.asm.signature.Type;
import net.runelite.asm.signature.util.VirtualMethods;
import net.runelite.deob.Deobfuscator;
import net.runelite.deob.util.NameMappings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Renamer implements Deobfuscator
{
	private static final Logger logger = LoggerFactory.getLogger(Renamer.class);

	private static final Type OBFUSCATED_NAME_TYPE = new Type("Lnet/runelite/mapping/ObfuscatedName;");
	private static final Type OBFUSCATED_SIGNATURE_TYPE = new Type("Lnet/runelite/mapping/ObfuscatedSignature;");

	private final NameMappings mappings;

	public Renamer(NameMappings mappings)
	{
		this.mappings = mappings;
	}

	private void renameClass(ClassFile on, ClassFile old, String name)
	{
		if (on.getParentClass().getName().equals(old.getName()))
			on.setParentClass(new net.runelite.asm.pool.Class(name));
		
		Interfaces interfaces = on.getInterfaces();
		List<net.runelite.asm.pool.Class> interfaceList = interfaces.getInterfaces();
		for (net.runelite.asm.pool.Class inter : interfaceList)
			if (inter.getName().equals(old.getName()))
			{
				int idx = interfaceList.indexOf(inter);
				interfaceList.remove(idx);
				interfaceList.add(idx, new net.runelite.asm.pool.Class(name));
				break;
			}
	}
	
	private void renameClass(ClassGroup group, ClassFile cf, String name)
	{	
		for (ClassFile c : group.getClasses())
		{
			// rename on child interfaces and classes
			renameClass(c, cf, name);
			
			for (Method method : c.getMethods().getMethods())
			{
				// rename on instructions. this includes method calls and field accesses.
				if (method.getCode() != null)
				{
					Code code = method.getCode();

					// rename on instructions
					for (Instruction i : code.getInstructions().getInstructions())
						i.renameClass(cf.getName(), name);

					// rename on exception handlers
					Exceptions exceptions = code.getExceptions();
					exceptions.renameClass(cf, name);
				}
				
				// rename on parameters
				Signature signature = method.getDescriptor();
				for (int i = 0; i < signature.size(); ++i)
				{
					Type type = signature.getTypeOfArg(i);
					
					if (type.getType().equals("L" + cf.getName() + ";"))
						signature.setTypeOfArg(i, new Type("L" + name + ";", type.getArrayDims())); 
				}
				
				// rename return type
				if (signature.getReturnValue().getType().equals("L" + cf.getName() + ";"))
					signature.setTypeOfReturnValue(new Type("L" + name + ";", signature.getReturnValue().getArrayDims()));
				
				// rename on exceptions thrown
				if (method.getExceptions() != null)
					method.getExceptions().renameClass(cf, name);
			}
			
			// rename on fields
			for (Field field : c.getFields().getFields())
				if (field.getType().getType().equals("L" + cf.getName() + ";"))
					field.setType(new Type("L" + name + ";", field.getType().getArrayDims()));
		}

		if (cf.getAnnotations().find(OBFUSCATED_NAME_TYPE) == null)
		{
			cf.getAnnotations().addAnnotation(OBFUSCATED_NAME_TYPE, "value", cf.getName());
		}

		cf.setName(name);
	}
	
	private void regeneratePool(ClassGroup group)
	{
		for (ClassFile cf : group.getClasses())
			for (Method m : cf.getMethods().getMethods())
			{
				Code c = m.getCode();
				if (c == null)
					continue;
				
				c.getInstructions().regeneratePool();
			}
	}

	@Override
	public void run(ClassGroup group)
	{
		group.buildClassGraph();
		group.lookup();
		
		int classes = 0, fields = 0, methods = 0;
		
		// rename fields
		for (ClassFile cf : group.getClasses())
			for (Field field : cf.getFields().getFields())
			{
				String newName = mappings.get(field.getPoolField());
				if (newName == null)
					continue;

				if (field.getAnnotations().find(OBFUSCATED_NAME_TYPE) == null)
				{
					field.getAnnotations().addAnnotation(OBFUSCATED_NAME_TYPE, "value", field.getName());
				}

				field.setName(newName);
				++fields;
			}
		
		// rename methods
		for (ClassFile cf : group.getClasses())
			for (Method method : cf.getMethods().getMethods())
			{
				String newName = mappings.get(method.getPoolMethod());

				// rename on obfuscated signature
				Annotation an = method.getAnnotations().find(OBFUSCATED_SIGNATURE_TYPE);
				if (an != null)
				{
					Signature obfuscatedSig = new Signature(an.getElement().getString());
					Signature updatedSig = renameSignature(obfuscatedSig);
					an.getElement().setValue(updatedSig.toString());
				}

				if (newName == null)
					continue;

				List<Method> virtualMethods = VirtualMethods.getVirutalMethods(method);
				assert !virtualMethods.isEmpty();

				for (Method m : virtualMethods)
				{
					if (m.getAnnotations().find(OBFUSCATED_NAME_TYPE) == null)
					{
						m.getAnnotations().addAnnotation(OBFUSCATED_NAME_TYPE, "value", m.getName());
					}
					
					m.setName(newName);
				}

				methods += virtualMethods.size();
			}
		
		for (ClassFile cf : group.getClasses())
		{
			String newName = mappings.get(cf.getPoolClass());
			if (newName == null)
				continue;

			renameClass(group, cf, newName);
			++classes;
		}
		
		this.regeneratePool(group);

		logger.info("Renamed {} classes, {} fields, and {} methods", classes, fields, methods);
	}

	private Type renameType(Type t)
	{
		if (t.isPrimitive())
		{
			return t;
		}

		String className = t.getType();
		assert className.startsWith("L");
		assert className.endsWith(";");

		className = className.substring(1, className.length() - 1); // remove L ;

		String newName = mappings.get(new net.runelite.asm.pool.Class(className));
		if (newName == null)
		{
			return t;
		}

		Type type = new Type("L" + newName + ";", t.getArrayDims());

		logger.debug("Renamed {} -> {}", t, type);

		return type;
	}

	private Signature renameSignature(Signature s)
	{
		Signature sig = new Signature();
		sig.setTypeOfReturnValue(renameType(s.getReturnValue()));
		for (Type t : s.getArguments())
		{
			sig.addArg(renameType(t));
		}
		return sig;
	}
}
