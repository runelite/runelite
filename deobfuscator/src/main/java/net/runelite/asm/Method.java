/*
 * Copyright (c) 2016-2017, Adam <Adam@sigterm.info>
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *    list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
 * ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package net.runelite.asm;

import java.util.ArrayList;
import java.util.List;
import net.runelite.asm.attributes.Annotations;
import net.runelite.asm.attributes.Code;
import net.runelite.asm.attributes.Exceptions;
import net.runelite.asm.attributes.annotation.Annotation;
import net.runelite.asm.attributes.code.Instruction;
import net.runelite.asm.attributes.code.instruction.types.LVTInstruction;
import net.runelite.asm.signature.Signature;
import org.objectweb.asm.AnnotationVisitor;
import org.objectweb.asm.MethodVisitor;

public class Method
{
	public static final short ACC_PUBLIC = 0x1;
	public static final short ACC_PRIVATE = 0x2;
	public static final short ACC_PROTECTED = 0x4;
	public static final short ACC_STATIC = 0x8;
	public static final short ACC_FINAL = 0x10;
	public static final short ACC_SYNCHRONIZED = 0x20;
	public static final short ACC_ABSTRACT = 0x400;

	public static final short ACCESS_MODIFIERS = ACC_PUBLIC | ACC_PRIVATE | ACC_PROTECTED;
	
	private Methods methods;

	private int accessFlags;
	private String name;
	private Signature arguments;
	private Exceptions exceptions;
	private Annotations annotations;
	private Code code;

	public Method(Methods methods, String name, Signature signature)
	{
		this.methods = methods;
		this.name = name;
		this.arguments = signature;
		exceptions = new Exceptions();
		annotations = new Annotations();
	}
	
	@Override
	public String toString()
	{
		return (this.isStatic() ? "static " : "") + this.getMethods().getClassFile().getName() + "." + this.name + this.arguments;
	}

	public void accept(MethodVisitor visitor)
	{
		for (Annotation annotation : annotations.getAnnotations())
		{
			AnnotationVisitor av = visitor.visitAnnotation(annotation.getType().getFullType(), true);
			annotation.accept(av);
		}
		
		if (code != null)
		{
			visitor.visitCode();

			net.runelite.asm.attributes.code.Exceptions exceptions = code.getExceptions();
			for (net.runelite.asm.attributes.code.Exception exception : exceptions.getExceptions())
			{
				assert exception.getStart().getLabel() != null;
				assert exception.getEnd().getLabel() != null;
				assert exception.getHandler().getLabel() != null;

				assert code.getInstructions().getInstructions().contains(exception.getStart());
				assert code.getInstructions().getInstructions().contains(exception.getEnd());
				assert code.getInstructions().getInstructions().contains(exception.getHandler());

				visitor.visitTryCatchBlock(
					exception.getStart().getLabel(),
					exception.getEnd().getLabel(),
					exception.getHandler().getLabel(),
					exception.getCatchType() != null ? exception.getCatchType().getName() : null
				);
			}

			for (Instruction i : code.getInstructions().getInstructions())
			{
				i = i.makeSpecific();
				i.accept(visitor);
			}

			visitor.visitMaxs(code.getMaxStack(), code.getMaxLocals());
		}

		visitor.visitEnd();
	}

	public Methods getMethods()
	{
		return methods;
	}
	
	public void setMethods(Methods methods)
	{
		this.methods = methods;
	}

	public int getAccessFlags()
	{
		return accessFlags;
	}

	public void setAccessFlags(int accessFlags)
	{
		this.accessFlags = accessFlags;
	}
	
	public String getName()
	{
		return name;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}

	public Signature getDescriptor()
	{
		return arguments;
	}

	public void setDescriptor(Signature signature)
	{
		this.arguments = signature;
	}
	
	public boolean isStatic()
	{
		return (accessFlags & ACC_STATIC) != 0;
	}
	
	public void setStatic()
	{
		accessFlags |= ACC_STATIC;
	}
	
	public boolean isSynchronized()
	{
		return (accessFlags & ACC_SYNCHRONIZED) != 0;
	}

	public boolean isFinal()
	{
		return (accessFlags & ACC_FINAL) != 0;
	}

	public void setFinal(boolean f)
	{
		if (f)
			accessFlags |= ACC_FINAL;
		else
			accessFlags &= ~ACC_FINAL;
	}

	public boolean isPrivate()
	{
		return (accessFlags & ACC_PRIVATE) != 0;
	}

	public void setPrivate()
	{
		accessFlags = (short) ((accessFlags & ~ACCESS_MODIFIERS) | ACC_PRIVATE);
	}

	public void setPublic()
	{
		accessFlags = (short) ((accessFlags & ~ACCESS_MODIFIERS) | ACC_PUBLIC);
	}
	
	public Exceptions getExceptions()
	{
		return exceptions;
	}

	public Code getCode()
	{
		return code;
	}

	public void setCode(Code code)
	{
		this.code = code;
	}
	
	public Annotations getAnnotations()
	{
		return annotations;
	}
	
	@SuppressWarnings("unchecked")
	public <T extends Instruction & LVTInstruction> List<T> findLVTInstructionsForVariable(int index)
	{
		List<T> list = new ArrayList<>();
		
		if (getCode() == null)
			return null;
		
		for (Instruction ins : getCode().getInstructions().getInstructions())
			if (ins instanceof LVTInstruction)
			{
				LVTInstruction lv = (LVTInstruction) ins;
				
				if (lv.getVariableIndex() != index)
					continue;
				
				list.add((T) ins);
			}
		
		return list;
	}
	
	public net.runelite.asm.pool.Method getPoolMethod()
	{
		return new net.runelite.asm.pool.Method(
			new net.runelite.asm.pool.Class(this.getMethods().getClassFile().getName()),
			name,
			arguments
		);
	}
}
