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
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.tree.ClassNode;
import org.objectweb.asm.tree.MethodNode;

@Slf4j
public class OverwriteTransformer extends ClassVisitor
{
	
	private final byte[] patch;
	private ClassNode node;
	private String className;
	
	public OverwriteTransformer(ClassVisitor classVisitor, byte[] patch, ClassNode node)
	{
		super(Opcodes.ASM6, classVisitor);
		this.patch = patch;
		this.node = node;
		this.className = node.name;
	}
	
	@Override
	public void visit(int version, int access, String name, String signature, String superName, String[] interfaces)
	{
		className = name;
		super.visit(version, access, name, signature, superName, interfaces);
	}
	
	@Override
	public MethodVisitor visitMethod(int access, String name, String descriptor, String signature, String[] exceptions)
	{
		if (patch == null || name.startsWith("1protect$"))
		{
			return super.visitMethod(access, name, descriptor, signature, exceptions);
		}
		
		if (name.startsWith("prepend$") || name.startsWith("append$"))
		{
			return null;
		}
		
		ClassReader cr = new ClassReader(patch);
		ClassNode patchNode = new ClassNode(Opcodes.ASM6);
		cr.accept(patchNode, 0);
		
		for (Object obj : patchNode.methods)
		{
			MethodNode patchMethod = (MethodNode) obj;
			
			if (patchMethod.access == access && patchMethod.name.equals(name) && patchMethod.desc.equals(descriptor))
			{
				if (RefUtils.checkAnnotation(patchMethod, "Overwrite"))
				{
					MethodVisitor mv =
							new MethodVisitor(Opcodes.ASM6, super.visitMethod(access, name, descriptor, signature,
									exceptions))
							{
							};
					mv.visitCode();
					patchMethod.accept(new MethodReflector(mv));
					mv.visitEnd();
					String s = String.format("%s %s %s %s", className, patchMethod.name,
							patchMethod.desc, patchMethod.access);
					OverwriteSanityCheck.methodsUsed.add(s);
					return mv;
				}
			}
		}
		return super.visitMethod(access, name, descriptor, signature, exceptions);
	}
}
