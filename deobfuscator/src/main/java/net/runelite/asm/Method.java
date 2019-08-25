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
import net.runelite.asm.attributes.code.LocalVariable;
import net.runelite.asm.attributes.code.Parameter;
import net.runelite.asm.attributes.code.instruction.types.LVTInstruction;
import net.runelite.asm.signature.Signature;
import net.runelite.deob.DeobAnnotations;
import org.objectweb.asm.AnnotationVisitor;
import org.objectweb.asm.Label;
import org.objectweb.asm.MethodVisitor;
import static org.objectweb.asm.Opcodes.ACC_FINAL;
import static org.objectweb.asm.Opcodes.ACC_NATIVE;
import static org.objectweb.asm.Opcodes.ACC_PRIVATE;
import static org.objectweb.asm.Opcodes.ACC_PROTECTED;
import static org.objectweb.asm.Opcodes.ACC_PUBLIC;
import static org.objectweb.asm.Opcodes.ACC_STATIC;
import static org.objectweb.asm.Opcodes.ACC_SYNCHRONIZED;

public class Method
{
	public static final int ACCESS_MODIFIERS = ACC_PUBLIC | ACC_PRIVATE | ACC_PROTECTED;

	private final ClassFile classFile;

	private int accessFlags;
	private String name;
	private Signature arguments;
	private Exceptions exceptions;
	private Annotations annotations;
	private List<Parameter> parameters;
	private Code code;

	public Method(ClassFile classFile, String name, Signature signature)
	{
		this.classFile = classFile;
		this.name = name;
		this.arguments = signature;
		exceptions = new Exceptions();
		annotations = new Annotations();
		parameters = new ArrayList<>();
	}

	public ClassFile getClassFile()
	{
		return classFile;
	}

	@Override
	public String toString()
	{
		return (this.isStatic() ? "static " : "") + classFile.getName() + "." + this.name + this.arguments;
	}

	public void accept(MethodVisitor visitor)
	{
		//This is required to name unused parameters
		for (Parameter p : parameters)
		{
			visitor.visitParameter(p.getName(), p.getAccess());
		}

		for (Annotation annotation : annotations.getAnnotations())
		{
			AnnotationVisitor av = visitor.visitAnnotation(annotation.getType().toString(), true);
			annotation.accept(av);
		}

		if (code != null)
		{
			code.getInstructions().rebuildLabels();

			visitor.visitCode();

			net.runelite.asm.attributes.code.Exceptions exceptions = code.getExceptions();
			for (net.runelite.asm.attributes.code.Exception exception : exceptions.getExceptions())
			{
				assert exception.getStart().getLabel() != null;
				assert exception.getEnd().getLabel() != null;
				assert exception.getHandler().getLabel() != null;

				int idxStart = code.getInstructions().getInstructions().indexOf(exception.getStart());
				int idxEnd = code.getInstructions().getInstructions().indexOf(exception.getEnd());

				assert idxStart != -1;
				assert idxEnd != -1;
				assert code.getInstructions().getInstructions().contains(exception.getHandler());

				assert idxEnd > idxStart;

				visitor.visitTryCatchBlock(
					exception.getStart().getLabel(),
					exception.getEnd().getLabel(),
					exception.getHandler().getLabel(),
					exception.getCatchType() != null ? exception.getCatchType().getName() : null
				);
			}

			for (Instruction i : code.getInstructions().getInstructions())
			{
				i.accept(visitor);
			}

			//Find first and last label for this method
			if (parameters.size() > 0)
			{
				Label startLabel = null;
				Label endLabel = null;
				for (Instruction i : code.getInstructions().getInstructions())
				{
					if (i instanceof net.runelite.asm.attributes.code.Label)
					{
						if (startLabel == null)
						{
							startLabel = ((net.runelite.asm.attributes.code.Label) i).getLabel();
						}
						endLabel = ((net.runelite.asm.attributes.code.Label) i).getLabel();
					}
				}

				for (Parameter p : parameters)
				{
					LocalVariable lv = p.getLocalVariable();
					if (lv != null)
					{
						visitor.visitLocalVariable(lv.getName(), lv.getDesc(), lv.getSignature(), startLabel, endLabel, lv.getIndex());
					}
				}
			}

			visitor.visitMaxs(code.getMaxStack(), code.getMaxLocals());
		}

		visitor.visitEnd();
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

	public Signature getObfuscatedSignature()
	{
		Signature sig = DeobAnnotations.getObfuscatedSignature(this);
		if (sig == null)
		{
			sig = arguments;
		}

		return sig;
	}

	public boolean isNative()
	{
		return (accessFlags & ACC_NATIVE) != 0;
	}

	public boolean isStatic()
	{
		return (accessFlags & ACC_STATIC) != 0;
	}

	public void setStatic(boolean s)
	{
		if (s)
		{
			accessFlags |= ACC_STATIC;
		}
		else
		{
			accessFlags &= ~ACC_STATIC;
		}
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
		{
			accessFlags |= ACC_FINAL;
		}
		else
		{
			accessFlags &= ~ACC_FINAL;
		}
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
		{
			return null;
		}

		for (Instruction ins : getCode().getInstructions().getInstructions())
		{
			if (ins instanceof LVTInstruction)
			{
				LVTInstruction lv = (LVTInstruction) ins;

				if (lv.getVariableIndex() != index)
				{
					continue;
				}

				list.add((T) ins);
			}
		}

		return list;
	}

	public net.runelite.asm.pool.Method getPoolMethod()
	{
		return new net.runelite.asm.pool.Method(
			new net.runelite.asm.pool.Class(classFile.getName()),
			name,
			arguments
		);
	}

	public List<Parameter> getParameters()
	{
		return parameters;
	}

	public void setParameters(List<Parameter> parameters)
	{
		this.parameters = parameters;
	}
}
