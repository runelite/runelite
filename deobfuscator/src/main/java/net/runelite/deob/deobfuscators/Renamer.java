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

package net.runelite.deob.deobfuscators;

import java.util.List;
import net.runelite.asm.ClassFile;
import net.runelite.asm.ClassGroup;
import net.runelite.asm.Field;
import net.runelite.asm.Interfaces;
import net.runelite.asm.Method;
import net.runelite.asm.attributes.Code;
import net.runelite.asm.attributes.code.Exceptions;
import net.runelite.asm.pool.UTF8;
import net.runelite.asm.signature.Signature;
import net.runelite.asm.signature.Type;
import net.runelite.asm.signature.util.VirtualMethods;
import net.runelite.deob.Deobfuscator;
import net.runelite.deob.util.NameMappings;

public class Renamer implements Deobfuscator
{
	private static final Type OBFUSCATED_NAME_TYPE = new Type("Lnet/runelite/mapping/ObfuscatedName;");

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
					// rename on exception handlers
					Exceptions exceptions = method.getCode().getExceptions();
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
		
		cf.getAttributes().addAnnotation(OBFUSCATED_NAME_TYPE, "value", new UTF8(cf.getName()));
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
				
				field.getAttributes().addAnnotation(OBFUSCATED_NAME_TYPE, "value", new UTF8(field.getName()));
				field.setName(newName);
				++fields;
			}
		
		// rename methods
		for (ClassFile cf : group.getClasses())
			for (Method method : cf.getMethods().getMethods())
			{
				String newName = mappings.get(method.getPoolMethod());
				if (newName == null)
					continue;
				
				List<Method> virtualMethods = VirtualMethods.getVirutalMethods(method);
				assert !virtualMethods.isEmpty();
				
				for (Method m : virtualMethods)
				{
					m.getAttributes().addAnnotation(OBFUSCATED_NAME_TYPE, "value", new UTF8(m.getName()));
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
		
		System.out.println("Renamed " + classes + " classes, " + fields + " fields, and " + methods + " methods");
	}
}
