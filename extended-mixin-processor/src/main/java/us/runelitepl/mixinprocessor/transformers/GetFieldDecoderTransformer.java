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
import us.runelitepl.mixinprocessor.MixinProcessorMojo;
import us.runelitepl.mixinprocessor.util.RefUtils;

public class GetFieldDecoderTransformer extends AsmBaseTransformer
{
	
	private final String className;
	private final byte[] classFileBytecode;
	
	public GetFieldDecoderTransformer(String className, byte[] bytes)
	{
		this.className = className;
		this.classFileBytecode = bytes;
	}
	
	@Override
	public void buildMethodList()
	{
		ClassReader cr = new ClassReader(classFileBytecode);
		ClassWriter cw = new ClassWriter(cr, 0);
		cr.accept(new ClassVisitor(Opcodes.ASM6, cw)
		{
			@Override
			public MethodVisitor visitMethod(int access, String name, String desc, String signature,
					String[] exceptions)
			{
				final boolean[] valid = {true};
				MethodVisitor visitor = super.visitMethod(access, name, desc, signature, exceptions);
				return new MethodVisitor(Opcodes.ASM6, visitor)
				{
					int opcodeCount = 0;
					
					@Override
					public void visitEnd()
					{
						if (valid[0])
						{
							MixinProcessorMojo.log("Valid method: %s %s %s %s", access, name, desc, signature);
							validMethods.add(access + " " + name + " " + desc + " " + signature);
						}
					}
					
					@Override
					public void visitVarInsn(int opcode, int var)
					{
						if (opcode != Opcodes.ALOAD || var != 0 || opcodeCount != 0)
						{
							valid[0] = false;
						}
						opcodeCount++;
						
						super.visitVarInsn(opcode, var);
					}
					
					@Override
					public void visitFieldInsn(int opcode, String owner, String fieldName, String signature)
					{
						if (opcode != Opcodes.GETFIELD || opcodeCount != 1)
						{
							valid[0] = false;
						}
						opcodeCount++;
						
						super.visitFieldInsn(opcode, owner, fieldName, signature);
					}
					
					@Override
					public void visitLdcInsn(Object o)
					{
						if (!(o instanceof Integer) && !(o instanceof Long))
						{
							valid[0] = false;
						}
						if (opcodeCount != 2)
						{
							valid[0] = false;
						}
						opcodeCount++;
						super.visitLdcInsn(o);
					}
					
					@Override
					public void visitInsn(int opcode)
					{
						switch (opcode)
						{
							case Opcodes.IMUL:
								if (opcodeCount != 3)
								{
									valid[0] = false;
								}
								break;
							case Opcodes.IRETURN:
								if (opcodeCount != 4)
								{
									valid[0] = false;
								}
								break;
							default:
								valid[0] = false;
								break;
						}
						opcodeCount++;
						super.visitInsn(opcode);
					}
				};
			}
		}, 0);
	}
	
	public byte[] transform()
	{
		buildMethodList();
		ClassReader cr = new ClassReader(classFileBytecode);
		ClassWriter cw = new ClassWriter(cr, 0);
		cr.accept(new ClassVisitor(Opcodes.ASM6, cw)
		{
			@Override
			public MethodVisitor visitMethod(int access, String name, String desc, String signature, String[] exceptions)
			{
				MethodVisitor visitor = super.visitMethod(access, name, desc, signature, exceptions);
				if (!validMethods.contains(access + " " + name + " " + desc + " " + signature))
				{
					return visitor;
				}
				return new MethodVisitor(Opcodes.ASM6, visitor)
				{
					String target = null;
					
					@Override
					public void visitFieldInsn(int opcode, String owner, String fieldName, String signature)
					{
						target = fieldName;
						super.visitFieldInsn(opcode, owner, fieldName, signature);
					}
					
					@Override
					public void visitLdcInsn(Object o)
					{
						if (target != null)
						{
							if (o instanceof Long)
							{
								o = MixinProcessorMojo.fieldDecoders.getOrDefault(
										RefUtils.deobClassName(className) + " " + target, 1L);
							}
							else
							{
								o = Math.toIntExact(MixinProcessorMojo.fieldDecoders.getOrDefault(RefUtils.deobClassName(className) +
												" " + target,
										1L));
							}
						}
						MixinProcessorMojo.log("\tGetFieldDecoderTransformer: %s %s %s %s %s",
							RefUtils.deobClassName(className), name, target, desc, o);
						super.visitLdcInsn(o);
					}
				};
			}
		}, 0);
		return cw.toByteArray();
	}
	
}
