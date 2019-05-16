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

import static org.objectweb.asm.Opcodes.ASM6;
import static org.objectweb.asm.Opcodes.GETSTATIC;
import static org.objectweb.asm.Opcodes.INVOKESTATIC;
import static org.objectweb.asm.Opcodes.PUTSTATIC;

public class AsmStaticUsageTransformer extends AsmBaseTransformer
{
	
	private String className;
	private byte[] bytecode;
	private final String TYPE_PREFIX = "us/runelitepl/mixins/";
	
	public AsmStaticUsageTransformer(String className, byte[] bytecode)
	{
		this.className = className;
		this.bytecode = bytecode;
	}
	
	@Override
	public byte[] transform()
	{
		ClassReader cr = new ClassReader(bytecode);
		ClassWriter cw = new ClassWriter(cr, 0);
		ClassVisitor cv = new ClassVisitor(ASM6, cw)
		{
			@Override
			public MethodVisitor visitMethod(int access, String name, String descriptor, String signature, String[] exceptions)
			{
				MethodVisitor visitor = super.visitMethod(access, name, descriptor, signature, exceptions);
				return new MethodVisitor(ASM6, visitor)
				{
					@Override
					public void visitFieldInsn(int opcode, String owner, String name, String descriptor)
					{
						if ((opcode == GETSTATIC || opcode == PUTSTATIC) && owner.endsWith(RefUtils.STATICS_STRING))
						{
							String oldName = name;
							String originalOwner = owner.replace(TYPE_PREFIX, "");
							String temp = RefUtils.reobFieldNameDangerous(name, RefUtils.reobDescriptor(descriptor));
							if (temp == null)
							{
								MixinProcessorMojo.log("Failed to reobfuscate class name for field %s %s %s", owner,
									name, descriptor);
								throw new RuntimeException();
							}
							owner = temp.split(" ")[0];
							if (RefUtils.shouldReobField(originalOwner, name, RefUtils.reobDescriptor(descriptor)))
							{
								name = temp.split(" ")[1];
							}
						}
						super.visitFieldInsn(opcode, owner, name, descriptor);
					}
					
					@Override
					public void visitMethodInsn(int opcode, String owner, String name, String descriptor, boolean isInterface)
					{
						if(opcode == INVOKESTATIC && owner.endsWith(RefUtils.STATICS_STRING))
						{
							String originalOwner = owner.replace(TYPE_PREFIX, "");
							String temp = RefUtils.reobMethodName(RefUtils.STATICS_STRING, name, descriptor);
							if (temp == null)
							{
								MixinProcessorMojo.log("Failed to reobfuscate class name for method %s %s %s", owner,
									name, descriptor);
								throw new RuntimeException();
							}
							owner = temp.split(" ")[0];
							if (RefUtils.shouldReobMethod(originalOwner, name, descriptor))
							{
								name = temp.split(" ")[1];
							}
						}
						super.visitMethodInsn(opcode, owner, name, descriptor, isInterface);
					}
				};
			}
		};
		
		cr.accept(cv, 0);
		
		return cw.toByteArray();
	}
	
}
