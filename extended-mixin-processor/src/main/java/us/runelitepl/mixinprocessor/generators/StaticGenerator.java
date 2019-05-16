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

package us.runelitepl.mixinprocessor.generators;

import javassist.CannotCompileException;
import javassist.CtClass;
import javassist.NotFoundException;
import us.runelitepl.mixinprocessor.MixinProcessorMojo;
import us.runelitepl.mixinprocessor.util.JavassistUtils;
import us.runelitepl.mixinprocessor.util.RefUtils;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.tree.ClassNode;
import org.objectweb.asm.tree.FieldNode;
import org.objectweb.asm.tree.MethodNode;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class StaticGenerator
{
	
	public static HashMap<String, ArrayList<MethodNode>> staticMethods = new HashMap<>();
	public static HashMap<String, ArrayList<FieldNode>> staticFields = new HashMap<>();
	public static Set<String> modifiedClasses = new HashSet<>();
	
	public void run(byte[] bytecode) throws NotFoundException, IOException, CannotCompileException
	{
		ClassReader cr = new ClassReader(bytecode);
		
		ClassNode node = new ClassNode();
		cr.accept(node, 0);
		
		for (Object aaa : node.methods)
		{
			MethodNode method = (MethodNode) aaa;
			
			String methodName = method.name;
			method.desc = RefUtils.reobMethodDescriptor(method.desc);
			int access = method.access;
			if ((access & 8) != 8)
			{
				continue;
			}
			String reobbed = RefUtils.reobMethodName(RefUtils.STATICS_STRING, methodName, method.desc);
			if(reobbed == null)
			{
				MixinProcessorMojo.log("Failed to reob static method: %s %s", methodName, method.desc);
				throw new RuntimeException();
			}
			String[] split = reobbed.split(" ");
			method.name = split[1];
			ArrayList<MethodNode> list = staticMethods.getOrDefault(split[0], new ArrayList<>());
			list.add(method);
			staticMethods.put(split[0], list);
			modifiedClasses.add(split[0]);
		}
		
		for (Object aaa : node.fields)
		{
			FieldNode field = (FieldNode) aaa;
			
			String fieldName = field.name;
			field.desc = RefUtils.reobDescriptor(field.desc);
			int access = field.access;
			if ((access & 8) != 8)
			{
				continue;
			}
			String reobbed = RefUtils.reobFieldName(RefUtils.STATICS_STRING, fieldName, field.desc);
			if(reobbed == null)
			{
				MixinProcessorMojo.log("Failed to reob static field: %s %s", fieldName, field.desc);
				throw new RuntimeException();
			}
			String[] split = reobbed.split(" ");
			field.name = split[1];
			ArrayList<FieldNode> list = staticFields.getOrDefault(split[0], new ArrayList<>());
			list.add(field);
			staticFields.put(split[0], list);
			modifiedClasses.add(split[0]);
		}
	}
	
}
