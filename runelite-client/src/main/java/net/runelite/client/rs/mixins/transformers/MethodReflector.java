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

import org.objectweb.asm.AnnotationVisitor;
import org.objectweb.asm.Attribute;
import org.objectweb.asm.Handle;
import org.objectweb.asm.Label;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.TypePath;

public class MethodReflector extends MethodVisitor
{
	
	private MethodVisitor target;
	
	public MethodReflector(MethodVisitor target)
	{
		super(Opcodes.ASM6);
		this.target = target;
	}
	
	public void visitParameter(String var1, int var2)
	{
		if (target != null)
		{
			target.visitParameter(var1, var2);
		}
		super.visitParameter(var1, var2);
	}
	
	public AnnotationVisitor visitAnnotationDefault()
	{
		return super.visitAnnotationDefault();
	}
	
	public AnnotationVisitor visitAnnotation(String var1, boolean var2)
	{
		return super.visitAnnotation(var1, var2);
	}
	
	public AnnotationVisitor visitTypeAnnotation(int var1, TypePath var2, String var3, boolean var4)
	{
		return super.visitTypeAnnotation(var1, var2, var3, var4);
	}
	
	public AnnotationVisitor visitParameterAnnotation(int var1, String var2, boolean var3)
	{
		return super.visitParameterAnnotation(var1, var2, var3);
	}
	
	public void visitAttribute(Attribute var1)
	{
		if (target != null)
		{
			target.visitAttribute(var1);
		}
		super.visitAttribute(var1);
	}
	
	public void visitFrame(int var1, int var2, Object[] var3, int var4, Object[] var5)
	{
		if (target != null)
		{
			target.visitFrame(var1, var2, var3, var4, var5);
		}
		super.visitFrame(var1, var2, var3, var4, var5);
	}
	
	public void visitInsn(int var1)
	{
		if (target != null)
		{
			target.visitInsn(var1);
		}
		super.visitInsn(var1);
	}
	
	public void visitIntInsn(int var1, int var2)
	{
		if (target != null)
		{
			target.visitIntInsn(var1, var2);
		}
		super.visitIntInsn(var1, var2);
	}
	
	public void visitVarInsn(int var1, int var2)
	{
		if (target != null)
		{
			target.visitVarInsn(var1, var2);
		}
		super.visitVarInsn(var1, var2);
	}
	
	public void visitTypeInsn(int var1, String var2)
	{
		if (target != null)
		{
			target.visitTypeInsn(var1, var2);
		}
		super.visitTypeInsn(var1, var2);
	}
	
	public void visitFieldInsn(int var1, String var2, String var3, String var4)
	{
		if (target != null)
		{
			target.visitFieldInsn(var1, var2, var3, var4);
		}
		super.visitFieldInsn(var1, var2, var3, var4);
	}
	
	/**
	 * @deprecated
	 */
	public void visitMethodInsn(int var1, String var2, String var3, String var4)
	{
		if (target != null)
		{
			target.visitMethodInsn(var1, var2, var3, var4);
		}
		super.visitMethodInsn(var1, var2, var3, var4);
	}
	
	public void visitMethodInsn(int var1, String var2, String var3, String var4, boolean var5)
	{
		if (target != null)
		{
			target.visitMethodInsn(var1, var2, var3, var4, var5);
		}
		super.visitMethodInsn(var1, var2, var3, var4, var5);
	}
	
	public void visitInvokeDynamicInsn(String var1, String var2, Handle var3, Object... var4)
	{
		if (target != null)
		{
			target.visitInvokeDynamicInsn(var1, var2, var3, var4);
		}
		super.visitInvokeDynamicInsn(var1, var2, var3, var4);
	}
	
	public void visitJumpInsn(int var1, Label var2)
	{
		if (target != null)
		{
			target.visitJumpInsn(var1, var2);
		}
		super.visitJumpInsn(var1, var2);
	}
	
	public void visitLabel(Label var1)
	{
		if (target != null)
		{
			target.visitLabel(var1);
		}
		super.visitLabel(var1);
	}
	
	public void visitLdcInsn(Object var1)
	{
		if (target != null)
		{
			target.visitLdcInsn(var1);
		}
		super.visitLdcInsn(var1);
	}
	
	public void visitIincInsn(int var1, int var2)
	{
		if (target != null)
		{
			target.visitIincInsn(var1, var2);
		}
		super.visitIincInsn(var1, var2);
	}
	
	public void visitTableSwitchInsn(int var1, int var2, Label var3, Label... var4)
	{
		if (target != null)
		{
			target.visitTableSwitchInsn(var1, var2, var3, var4);
		}
		super.visitTableSwitchInsn(var1, var2, var3, var4);
	}
	
	public void visitLookupSwitchInsn(Label var1, int[] var2, Label[] var3)
	{
		if (target != null)
		{
			target.visitLookupSwitchInsn(var1, var2, var3);
		}
		super.visitLookupSwitchInsn(var1, var2, var3);
	}
	
	public void visitMultiANewArrayInsn(String var1, int var2)
	{
		if (target != null)
		{
			target.visitMultiANewArrayInsn(var1, var2);
		}
		super.visitMultiANewArrayInsn(var1, var2);
	}
	
	public AnnotationVisitor visitInsnAnnotation(int var1, TypePath var2, String var3, boolean var4)
	{
		if (target != null)
		{
			target.visitInsnAnnotation(var1, var2, var3, var4);
		}
		return super.visitInsnAnnotation(var1, var2, var3, var4);
	}
	
	public void visitTryCatchBlock(Label var1, Label var2, Label var3, String var4)
	{
		if (target != null)
		{
			target.visitTryCatchBlock(var1, var2, var3, var4);
		}
		super.visitTryCatchBlock(var1, var2, var3, var4);
	}
	
	public AnnotationVisitor visitTryCatchAnnotation(int var1, TypePath var2, String var3, boolean var4)
	{
		if (target != null)
		{
			target.visitTryCatchAnnotation(var1, var2, var3, var4);
		}
		return super.visitTryCatchAnnotation(var1, var2, var3, var4);
	}
	
	public void visitLocalVariable(String var1, String var2, String var3, Label var4, Label var5, int var6)
	{
		if (target != null)
		{
			target.visitLocalVariable(var1, var2, var3, var4, var5, var6);
		}
		super.visitLocalVariable(var1, var2, var3, var4, var5, var6);
	}
	
	public AnnotationVisitor visitLocalVariableAnnotation(int var1, TypePath var2, Label[] var3, Label[] var4, int[] var5, String var6, boolean var7)
	{
		if (target != null)
		{
			target.visitLocalVariableAnnotation(var1, var2, var3, var4, var5, var6, var7);
		}
		return super.visitLocalVariableAnnotation(var1, var2, var3, var4, var5, var6, var7);
	}
	
	public void visitLineNumber(int var1, Label var2)
	{
		if (target != null)
		{
			target.visitLineNumber(var1, var2);
		}
		super.visitLineNumber(var1, var2);
	}
	
	public void visitMaxs(int var1, int var2)
	{
		if (target != null)
		{
			target.visitMaxs(var1, var2);
		}
		super.visitMaxs(var1, var2);
	}
	
}
