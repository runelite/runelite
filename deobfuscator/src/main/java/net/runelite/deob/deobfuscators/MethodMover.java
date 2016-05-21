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

import net.runelite.asm.ClassFile;
import net.runelite.asm.ClassGroup;
import net.runelite.deob.Deobfuscator;
import net.runelite.asm.Method;
import net.runelite.asm.attributes.Code;
import net.runelite.asm.attributes.code.Instruction;
import net.runelite.asm.attributes.code.Instructions;
import net.runelite.asm.attributes.code.instructions.InvokeStatic;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.collections4.map.MultiValueMap;

// find static methods that are only called from non-static methods of one class
public class MethodMover implements Deobfuscator
{
	private ClassGroup group;
	private MultiValueMap<Method, Method> calls = new MultiValueMap<>();
	
	private void buildCalls()
	{
		calls.clear();
		
		for (ClassFile cf : group.getClasses())
		{
			for (Method m : cf.getMethods().getMethods())
			{
				Code code = m.getCode();
				
				if (code == null)
					continue;
				
				if (m.isStatic())
					continue; // only want member methods
				
				Instructions ins = code.getInstructions();
				for (Instruction i : ins.getInstructions())
				{
					if (!(i instanceof InvokeStatic))
						continue;
					
					InvokeStatic is = (InvokeStatic) i;
					List<Method> methods = is.getMethods();
					
					if (methods.isEmpty())
						continue;
					
					Method method = methods.get(0);
					
					calls.put(method, m);
				}
			}
		}	
	}
	
	private int moveMethods()
	{
		int moved = 0;
		
		for (Method m : calls.keySet())
		{
			Collection<Method> values = calls.getCollection(m);
			
			boolean set = false;
			ClassFile caller = null;
			
			for (Method m2 : values)
			{
				if (!set)
				{
					set = true;
					caller = m2.getMethods().getClassFile();
				}
				
				if (caller != m2.getMethods().getClassFile())
				{
					caller = null;
				}
			}
			
			if (caller == null)
				continue;
			
			if (m.getMethods().getClassFile() == caller)
				continue;
			
			++moved;
			move(m, caller);
		}
		
		return moved;
	}
	
	private void move(Method method, ClassFile to)
	{
		assert method.getMethods().getClassFile() != to;
		
		net.runelite.asm.pool.Method newMethod = new net.runelite.asm.pool.Method(
			new net.runelite.asm.pool.Class(to.getName()),
			method.getNameAndType()
		);
		
		// move on instructions
		for (ClassFile cf : group.getClasses())
		{
			for (Method m : cf.getMethods().getMethods())
			{
				Code code = m.getCode();
				
				if (code == null)
					continue;
				
				//code.getInstructions().renameMethod(method, newMethod);
			}
		}
		
		// move the method
		method.getMethods().removeMethod(method);
		to.getMethods().getMethods().add(method);
		method.setMethods(to.getMethods());
	}
	
	@Override
	public void run(ClassGroup group)
	{
		this.group = group;
		
		group.buildClassGraph();
		buildCalls();
		int count = moveMethods();
		
		System.out.println("Moved " + count + " methods");
	}
}
