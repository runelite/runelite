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
import us.runelitepl.mixinprocessor.MethodGarbageValue;
import us.runelitepl.mixinprocessor.MixinProcessorMojo;
import us.runelitepl.mixinprocessor.util.RefUtils;

import java.sql.Ref;
import java.util.HashMap;

public class AsmMethodGarbageTransformer extends AsmBaseTransformer
{
	
	private final String className;
	private final byte[] bytecode;
	private HashMap<String, byte[]> classSet;
	
	public AsmMethodGarbageTransformer(String className, byte[] bytecode, HashMap<String, byte[]> classSet)
	{
		this.className = className;
		this.bytecode = bytecode;
		this.classSet = classSet;
	}
	
	@Override
	public byte[] transform()
	{
		
		ClassReader cr = new ClassReader(bytecode);
		ClassWriter cw = new ClassWriter(cr, ClassWriter.COMPUTE_FRAMES);
		
		cr.accept(new ClassVisitor(ASM6, cw)
		{
			@Override
			public MethodVisitor visitMethod(int access, String name, String desc, String signature, String[] exceptions)
			{
				MethodVisitor mv = super.visitMethod(access, name, desc, signature, exceptions);
				return new MethodVisitor(ASM6, mv)
				{
					@Override
					public void visitMethodInsn(int opcode, String owner, String name, String desc, boolean itf)
					{
						// get method owner.string(desc)
						// check if method is annotated with @Reobfuscate
						// brute force actual descriptor (check with shouldReobMethod(owner, name desc) )
						// mv.visitLdcInsn(BIPUSH, constant);
						// call super method with new descriptor
						
						if(RefUtils.shouldReobMethod(owner, name, desc))
						{
							String nc = RefUtils.reobMethodName(owner, name, desc).split(" ")[0];
							String nn = RefUtils.reobMethodName(owner, name, desc).split(" ")[1];
							String nd = RefUtils.reobMethodDescriptor(desc);
							MethodGarbageValue value;
							if((value = MixinProcessorMojo.methodGarbageValues.getOrDefault(String.format("%s.%s%s",
									nc,	nn, nd), null)) != null)
							{
								switch (value.getType())
								{
									case "I":
										super.visitLdcInsn(new Integer(value.getValue()));
										break;
									case "S":
										super.visitIntInsn(SIPUSH, (short) value.getValue());
										break;
									case "B":
										super.visitIntInsn(BIPUSH, (byte) value.getValue());
										break;
								}
							}
						}
						
						super.visitMethodInsn(opcode, owner, name, desc, itf);
					}
				};
			}
		}, 0);
		
		return cw.toByteArray();
	}
}
