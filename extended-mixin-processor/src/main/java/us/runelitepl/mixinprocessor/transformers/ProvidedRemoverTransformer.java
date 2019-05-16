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

package us.runelitepl.mixinprocessor.transformers;

import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.tree.AnnotationNode;
import org.objectweb.asm.tree.ClassNode;
import org.objectweb.asm.tree.MethodNode;
import us.runelitepl.mixinprocessor.MixinProcessorMojo;

public class ProvidedRemoverTransformer extends AsmBaseTransformer
{
	
	private final String className;
	private final byte[] bytecode;
	
	public ProvidedRemoverTransformer(String className, byte[] bytecode)
	{
		this.className = className;
		this.bytecode = bytecode;
	}
	
	public void buildMethodList()
	{
		ClassReader cr = new ClassReader(bytecode);
		ClassNode node = new ClassNode();
		cr.accept(node, 0);
		
		for(Object obj : node.methods)
		{
			MethodNode method = (MethodNode) obj;
			if(method == null)
			{
				MixinProcessorMojo.log("ProvidedRemoverTransformer: Method null?");
				continue;
			}
			if(method.visibleAnnotations == null)
			{
				continue;
			}
			for(Object obj2 : method.visibleAnnotations)
			{
				AnnotationNode annot = (AnnotationNode) obj2;
				if(annot.desc.equals(AnnotationRemoverTransformer.makeAnnotationDescriptor("Provided")))
				{
					validMethods.add(method.access + " " + method.desc + " " + method.name);
				}
			}
		}
	}
	
	@Override
	public byte[] transform()
	{
		buildMethodList();
		ClassReader cr = new ClassReader(bytecode);
		ClassWriter cw = new ClassWriter(cr, 0);
		cr.accept(new ClassVisitor(Opcodes.ASM6, cw)
		{
			@Override
			public MethodVisitor visitMethod(int access, String name, String desc, String signature,
					String[] exceptions)
			{
				if(validMethods.contains(access + " " + desc + " " + name))
				{
					return null;
				}
				return super.visitMethod(access, name, desc, signature, exceptions);
			}
		}, 0);
		
		return cw.toByteArray();
	}
}
