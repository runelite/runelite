/*
 *  Copyright (c) 2019, ThatGamerBlue <thatgamerblue@gmail.com>
 *  All rights reserved.
 *
 *  Redistribution and use in source and binary forms, with or without
 *  modification, are permitted provided that the following conditions are met:
 *
 *  1. Redistributions of source code must retain the above copyright notice, this
 *     list of conditions and the following disclaimer.
 *  2. Redistributions in binary form must reproduce the above copyright notice,
 *     this list of conditions and the following disclaimer in the documentation
 *     and/or other materials provided with the distribution.
 *
 *  THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 *  ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 *  WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 *  DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
 *  ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 *  (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 *  LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 *  ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 *  (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 *  SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package net.runelite.client.rs.mixins;

import lombok.RequiredArgsConstructor;
import net.runelite.client.rs.mixins.transformers.*;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.commons.ClassRemapper;
import org.objectweb.asm.commons.Remapper;
import org.objectweb.asm.tree.ClassNode;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@RequiredArgsConstructor
public class MixinRunner
{
	
	private final Map<String, byte[]> classes;
	private final Map<String, byte[]> patches;
	
	public Map<String, byte[]> run()
	throws NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException
	{
		runVisitor(InterfaceTransformer.class);
		runVisitor(OverwriteTransformer.class);
		runSanityChecker(OverwriteSanityCheck.class);
		runVisitor(InjectTransformer.class);
		runVisitor(AppendTransformer.class); // append has to come before prepend or append does nothing
		// (test method:    Projectile.rl$$init()V    )
		runVisitor(PrependTransformer.class);
		runRemapper(ProtectTransformer.class);
		
		recalcMaxes();
		return classes;
	}
	
	private void runRemapper(Class<? extends Remapper> clazz) throws IllegalAccessException, InstantiationException
	{
		for (Map.Entry<String, byte[]> entry : classes.entrySet())
		{
			if (entry.getKey().contains("META-INF"))
			{
				continue;
			}
			Remapper inst = clazz.newInstance();
			ClassReader cr = new ClassReader(entry.getValue());
			ClassWriter cw = new ClassWriter(cr, 1);
			cr.accept(new ClassRemapper(cw, inst), 0);
			
			entry.setValue(cw.toByteArray());
		}
	}
	
	private void runVisitor(Class<? extends ClassVisitor> clazz)
	throws IllegalAccessException, NoSuchMethodException, InvocationTargetException, InstantiationException
	{
		runVisitor(clazz, 1);
	}
	
	private void runVisitor(Class<? extends ClassVisitor> clazz, int flags)
	throws IllegalAccessException, NoSuchMethodException, InvocationTargetException, InstantiationException
	{
		for (Map.Entry<String, byte[]> entry : classes.entrySet())
		{
			if (entry.getKey().contains("META-INF"))
			{
				continue;
			}
			ClassReader cr = new ClassReader(entry.getValue());
			ClassWriter cw = new ClassWriter(cr, flags);
			byte[] patch = patches.getOrDefault(entry.getKey(), null);
			ClassNode node = new ClassNode();
			cr.accept(node, 0);
			ClassVisitor inst = clazz.getConstructor(ClassVisitor.class, byte[].class, ClassNode.class).newInstance(cw,
					patch, node);
			cr.accept(inst, 0);
			
			entry.setValue(cw.toByteArray());
		}
	}
	
	private void runSanityChecker(Class<? extends SanityChecker> clazz)
	throws IllegalAccessException, NoSuchMethodException, InvocationTargetException, InstantiationException
	{
		runSanityChecker(clazz, 1);
	}
	
	private void runSanityChecker(Class<? extends SanityChecker> clazz, int flags)
	throws IllegalAccessException, NoSuchMethodException, InvocationTargetException, InstantiationException
	{
		for (Map.Entry<String, byte[]> entry : patches.entrySet())
		{
			ClassReader cr = new ClassReader(entry.getValue());
			ClassWriter cw = new ClassWriter(cr, flags);
			ClassNode node = new ClassNode();
			cr.accept(node, 0);
			SanityChecker inst = clazz.getConstructor(ClassVisitor.class, ClassNode.class).newInstance(cw, node);
			cr.accept(inst, 0);
		}
	}
	
	private void recalcMaxes()
	throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException
	{
		runVisitor(DoNothingTransformer.class, 3);
	}
	
}
