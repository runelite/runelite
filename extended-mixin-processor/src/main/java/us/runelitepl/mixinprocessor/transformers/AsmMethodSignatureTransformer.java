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
import us.runelitepl.mixinprocessor.MixinProcessorMojo;
import us.runelitepl.mixinprocessor.util.RefUtils;

public class AsmMethodSignatureTransformer extends AsmBaseTransformer
{
	
	private final String className;
	private final byte[] bytecode;
	
	public AsmMethodSignatureTransformer(String className, byte[] bytecode)
	{
		this.className = RefUtils.deobClassName(className);
		this.bytecode = bytecode;
	}
	
	@Override
	public byte[] transform()
	{
		ClassReader cr = new ClassReader(bytecode);
		ClassWriter cw = new ClassWriter(cr, ClassWriter.COMPUTE_FRAMES);
		
		cr.accept(new ClassVisitor(ASM6, cw)
		{
			@Override
			public MethodVisitor visitMethod(int access, String name, String desc, String sig, String[] exceptions)
			{
				MethodVisitor mv = super.visitMethod(access, name, fixMethodDesc(className, name, desc), sig, exceptions);
				return new MethodVisitor(ASM6, mv)
				{
					@Override
					public void visitMethodInsn(int opcode, String owner, String name, String desc, boolean itf)
					{
						super.visitMethodInsn(opcode, owner, name, fixMethodDesc(owner, name, desc), itf);
					}
				};
			}
		}, 0);
		
		return cw.toByteArray();
	}
	
	private String fixMethodDesc(String className, String name, String desc)
	{
		if(className.startsWith(RefUtils.TYPE_PREFIX))
		{
			className = className.substring(RefUtils.TYPE_PREFIX.length());
		}
		if (RefUtils.shouldReobMethod(className, name, desc))
		{
			if (RefUtils.reobMethodName(className, name, desc) == null)
			{
				// get correct descriptor
				String realDesc = null;
				for (String s : RefUtils.POSSIBLE_GARBAGE_TYPES)
				{
					String check = RefUtils.reobMethodName(className, name, RefUtils.appendArgument(desc, s));
					if (check != null)
					{
						realDesc = RefUtils.appendArgument(desc, s);
						break;
					}
				}
				if (realDesc == null)
				{
					MixinProcessorMojo.log("Failed to find actual method descriptor for %s.%s%s", className,
							name, desc);
					throw new RuntimeException();
				}
				// fixed = realDesc
				MixinProcessorMojo.isMethodTagged.put(String.format("%s %s %s", className, name, realDesc), true);
				return realDesc;
			}
		}
		return desc;
	}
}
