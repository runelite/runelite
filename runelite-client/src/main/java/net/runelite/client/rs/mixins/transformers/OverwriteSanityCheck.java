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

package net.runelite.client.rs.mixins.transformers;

import lombok.extern.slf4j.Slf4j;
import net.runelite.client.util.RefUtils;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.tree.ClassNode;
import org.objectweb.asm.tree.MethodNode;

import java.util.ArrayList;

@Slf4j
public class OverwriteSanityCheck extends SanityChecker implements Opcodes
{
	
	private String className;
	private ClassNode patchNode;
	public static final ArrayList<String> methodsUsed = new ArrayList<>();
	
	public OverwriteSanityCheck(ClassVisitor classVisitor, ClassNode node)
	{
		super(ASM6, classVisitor);
		this.className = node.name;
		this.patchNode = node;
	}
	
	@Override
	public MethodVisitor visitMethod(int access, String name, String descriptor, String signature, String[] exceptions)
	{
		String check = String.format("%s %s %s %s", className, name,
				descriptor, access);
		
		MethodNode methodNode = null;
		for (Object obj2 : patchNode.methods)
		{
			MethodNode classMethod = (MethodNode) obj2;
			if (classMethod.access == access && classMethod.name.equals(name) &&
					classMethod.desc.equals(descriptor))
			{
				methodNode = classMethod;
			}
		}
		
		if(methodNode == null)
		{
			log.error("[OverwriteSanity] Failed to find original patch method for {}", check);
			return super.visitMethod(access, name, descriptor, signature, exceptions);
		}
		
		if (!RefUtils.checkAnnotation(methodNode, "Overwrite"))
		{
			return super.visitMethod(access, name, descriptor, signature, exceptions);
		}
		
		if (!methodsUsed.contains(check))
		{
			throw new RuntimeException("[OverwriteSanity] Overwrite target not found: " + check);
		}
		return super.visitMethod(access, name, descriptor, signature, exceptions);
	}
}
