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
package net.runelite.asm.visitors;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.stream.Collectors;
import net.runelite.asm.ClassFile;
import net.runelite.asm.Method;
import net.runelite.asm.Type;
import net.runelite.asm.attributes.Code;
import net.runelite.asm.attributes.code.Exceptions;
import net.runelite.asm.attributes.code.Instruction;
import net.runelite.asm.attributes.code.InstructionType;
import net.runelite.asm.attributes.code.Instructions;
import net.runelite.asm.attributes.code.LocalVariable;
import net.runelite.asm.attributes.code.Parameter;
import net.runelite.asm.attributes.code.instruction.types.FieldInstruction;
import net.runelite.asm.attributes.code.instruction.types.IntInstruction;
import net.runelite.asm.attributes.code.instruction.types.InvokeInstruction;
import net.runelite.asm.attributes.code.instruction.types.JumpingInstruction;
import net.runelite.asm.attributes.code.instruction.types.LVTInstruction;
import net.runelite.asm.attributes.code.instruction.types.TypeInstruction;
import net.runelite.asm.attributes.code.instructions.IInc;
import net.runelite.asm.attributes.code.instructions.InvokeDynamic;
import net.runelite.asm.attributes.code.instructions.InvokeInterface;
import net.runelite.asm.attributes.code.instructions.LDC;
import net.runelite.asm.attributes.code.instructions.LookupSwitch;
import net.runelite.asm.attributes.code.instructions.MultiANewArray;
import net.runelite.asm.attributes.code.instructions.TableSwitch;
import net.runelite.asm.pool.Field;
import net.runelite.asm.signature.Signature;
import org.objectweb.asm.AnnotationVisitor;
import org.objectweb.asm.Handle;
import org.objectweb.asm.Label;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;
import static org.objectweb.asm.Opcodes.DCONST_0;
import static org.objectweb.asm.Opcodes.DCONST_1;
import static org.objectweb.asm.Opcodes.FCONST_0;
import static org.objectweb.asm.Opcodes.FCONST_1;
import static org.objectweb.asm.Opcodes.FCONST_2;
import static org.objectweb.asm.Opcodes.ICONST_0;
import static org.objectweb.asm.Opcodes.ICONST_1;
import static org.objectweb.asm.Opcodes.ICONST_2;
import static org.objectweb.asm.Opcodes.ICONST_3;
import static org.objectweb.asm.Opcodes.ICONST_4;
import static org.objectweb.asm.Opcodes.ICONST_5;
import static org.objectweb.asm.Opcodes.ICONST_M1;
import static org.objectweb.asm.Opcodes.LCONST_0;
import static org.objectweb.asm.Opcodes.LCONST_1;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CodeVisitor extends MethodVisitor
{
	private static final Logger logger = LoggerFactory.getLogger(CodeVisitor.class);

	private final ClassFile classFile;
	private final Method method;
	private Code code;

	public CodeVisitor(ClassFile classFile, int access, String name, Signature signature, String[] sexceptions)
	{
		super(Opcodes.ASM5);

		this.classFile = classFile;

		method = new Method(classFile, name, signature);
		method.setAccessFlags(access);

		net.runelite.asm.attributes.Exceptions exceptions = method.getExceptions();
		if (sexceptions != null)
		{
			for (String e : sexceptions)
			{
				exceptions.addException(new net.runelite.asm.pool.Class(e));
			}
		}
	}

	@Override
	public void visitCode()
	{
		code = new Code(method);
	}

	@Override
	public AnnotationVisitor visitAnnotation(String desc, boolean visible)
	{
		Type type = new Type(desc);
		return new MethodAnnotationVisitor(method, type);
	}

	@Override
	public void visitParameter(String name, int access)
	{
		method.getParameters().add(new Parameter(name, access));
	}

	private Instruction createInstructionFromOpcode(int opcode)
	{
		InstructionType type = InstructionType.findInstructionFromCode(opcode);
		assert type != null;

		try
		{
			Constructor<? extends Instruction> con = type.getInstructionClass().getConstructor(Instructions.class, InstructionType.class);
			Instruction ins = con.newInstance(code.getInstructions(), type);

			code.getInstructions().addInstruction(ins);
			return ins;
		}
		catch (NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex)
		{
			throw new RuntimeException(ex);
		}

	}

	@Override
	public void visitInsn(int opcode)
	{
		switch (opcode)
		{
			case DCONST_0:
			{
				Instruction i = new LDC(code.getInstructions(), 0d);
				code.getInstructions().addInstruction(i);
				break;
			}
			case DCONST_1:
			{
				Instruction i = new LDC(code.getInstructions(), 1d);
				code.getInstructions().addInstruction(i);
				break;
			}
			case FCONST_0:
			{
				Instruction i = new LDC(code.getInstructions(), 0f);
				code.getInstructions().addInstruction(i);
				break;
			}
			case FCONST_1:
			{
				Instruction i = new LDC(code.getInstructions(), 1f);
				code.getInstructions().addInstruction(i);
				break;
			}
			case FCONST_2:
			{
				Instruction i = new LDC(code.getInstructions(), 2f);
				code.getInstructions().addInstruction(i);
				break;
			}
			case ICONST_M1:
			{
				Instruction i = new LDC(code.getInstructions(), -1);
				code.getInstructions().addInstruction(i);
				break;
			}
			case ICONST_0:
			{
				Instruction i = new LDC(code.getInstructions(), 0);
				code.getInstructions().addInstruction(i);
				break;
			}
			case ICONST_1:
			{
			{
				Instruction i = new LDC(code.getInstructions(), 1);
				code.getInstructions().addInstruction(i);
				break;
			}
			}
			case ICONST_2:
			{
				Instruction i = new LDC(code.getInstructions(), 2);
				code.getInstructions().addInstruction(i);
				break;
			}
			case ICONST_3:
			{
				Instruction i = new LDC(code.getInstructions(), 3);
				code.getInstructions().addInstruction(i);
				break;
			}
			case ICONST_4:
			{
				Instruction i = new LDC(code.getInstructions(), 4);
				code.getInstructions().addInstruction(i);
				break;
			}
			case ICONST_5:
			{
				Instruction i = new LDC(code.getInstructions(), 5);
				code.getInstructions().addInstruction(i);
				break;
			}
			case LCONST_0:
			{
				Instruction i = new LDC(code.getInstructions(), 0L);
				code.getInstructions().addInstruction(i);
				break;
			}
			case LCONST_1:
			{
				Instruction i = new LDC(code.getInstructions(), 1L);
				code.getInstructions().addInstruction(i);
				break;
			}
			default:
				createInstructionFromOpcode(opcode);
		}
	}

	@Override
	public void visitIntInsn(int opcode, int operand)
	{
		IntInstruction i = (IntInstruction) createInstructionFromOpcode(opcode);
		i.setOperand(operand);
	}

	@Override
	public void visitVarInsn(int opcode, int var)
	{
		LVTInstruction lvt = (LVTInstruction) createInstructionFromOpcode(opcode);
		lvt.setVariableIndex(var);
	}

	@Override
	public void visitTypeInsn(int opcode, String type)
	{
		TypeInstruction i = (TypeInstruction) createInstructionFromOpcode(opcode);
		Type t = Type.fromAsmString(type);
		i.setType(t);
	}

	@Override
	public void visitFieldInsn(int opcode, String owner, String name, String desc)
	{
		FieldInstruction i = (FieldInstruction) createInstructionFromOpcode(opcode);
		Field field = new Field(
			new net.runelite.asm.pool.Class(owner),
			name,
			new Type(desc)
		);
		i.setField(field);
	}

	@Override
	public void visitMethodInsn(int opcode, String owner, String name, String desc, boolean itf)
	{
		InvokeInstruction ii = (InvokeInstruction) createInstructionFromOpcode(opcode);

		assert ii instanceof InvokeInterface == itf;

		Type type = new Type(owner);

		net.runelite.asm.pool.Method entry = new net.runelite.asm.pool.Method(
			new net.runelite.asm.pool.Class(type.getInternalName()),
			name,
			new Signature(desc)
		);

		ii.setMethod(entry);
	}

	@Override
	public void visitInvokeDynamicInsn(String name, String desc, Handle bsm, Object[] bsmArgs)
	{
		InvokeDynamic id = new InvokeDynamic(code.getInstructions(), name, desc, bsm, bsmArgs);
		code.getInstructions().addInstruction(id);
	}

	@Override
	public void visitJumpInsn(int opcode, Label label)
	{
		JumpingInstruction i = (JumpingInstruction) createInstructionFromOpcode(opcode);
		i.setLabel(label);
	}

	@Override
	public void visitLabel(Label label)
	{
		Instruction i = code.getInstructions().findOrCreateLabel(label);
		code.getInstructions().addInstruction(i);
	}

	@Override
	public void visitLocalVariable(String name, String desc, String signature, Label start, Label end, int index)
	{
		LocalVariable lv = new LocalVariable(name, desc, signature, start, end, index);

		for (Parameter p : method.getParameters())
		{
			if (p.getName().equals(name))
			{
				p.setLocalVariable(lv);
				break;
			}
		}
	}

	@Override
	public void visitLdcInsn(Object cst)
	{
		Object entry = cst;

		if (cst instanceof org.objectweb.asm.Type)
		{
			org.objectweb.asm.Type t = (org.objectweb.asm.Type) cst;
			entry = new net.runelite.asm.pool.Class((String) t.getClassName());
		}

		LDC ldc = new LDC(code.getInstructions(), entry);
		code.getInstructions().addInstruction(ldc);
	}

	@Override
	public void visitIincInsn(int var, int increment)
	{
		IInc iinc = new IInc(code.getInstructions(), InstructionType.IINC);
		iinc.setVariableIndex(var);
		iinc.setIncrement(increment);
		code.getInstructions().addInstruction(iinc);
	}

	@Override
	public void visitTableSwitchInsn(int min, int max, Label dflt, Label[] labels)
	{
		TableSwitch tableSwitch = new TableSwitch(code.getInstructions(), InstructionType.TABLESWITCH);
		tableSwitch.setLow(min);
		tableSwitch.setHigh(max);
		tableSwitch.setDefi(code.getInstructions().findOrCreateLabel(dflt));
		tableSwitch.setBranchi(
			Arrays.stream(labels)
				.map(label -> code.getInstructions().findOrCreateLabel(label))
				.collect(Collectors.toList())
		);
		code.getInstructions().addInstruction(tableSwitch);
	}

	@Override
	public void visitLookupSwitchInsn(Label dflt, int[] keys, Label[] labels)
	{
		LookupSwitch lookupSwitch = new LookupSwitch(code.getInstructions(), InstructionType.LOOKUPSWITCH);
		lookupSwitch.setMatch(keys);
		lookupSwitch.setDefi(code.getInstructions().findOrCreateLabel(dflt));
		lookupSwitch.setBranchi(
			Arrays.stream(labels)
				.map(label -> code.getInstructions().findOrCreateLabel(label))
				.collect(Collectors.toList())
		);
		code.getInstructions().addInstruction(lookupSwitch);
	}

	@Override
	public void visitMultiANewArrayInsn(String desc, int dims)
	{
		MultiANewArray m = new MultiANewArray(code.getInstructions(), InstructionType.MULTIANEWARRAY);
		m.setArrayType(new Type(desc));
		m.setDimensions(dims);
		code.getInstructions().addInstruction(m);
	}

	@Override
	public void visitTryCatchBlock(Label start, Label end, Label handler, String type)
	{
		Exceptions exceptions = code.getExceptions();
		net.runelite.asm.attributes.code.Exception e = new net.runelite.asm.attributes.code.Exception(exceptions);

		Instructions ins = code.getInstructions();

		net.runelite.asm.attributes.code.Label startL = ins.findOrCreateLabel(start);
		net.runelite.asm.attributes.code.Label endL = ins.findOrCreateLabel(end);
		net.runelite.asm.attributes.code.Label handlerL = ins.findOrCreateLabel(handler);

		assert startL != null;
		assert endL != null;
		assert handlerL != null;

		e.setStart(startL);
		e.setEnd(endL);
		e.setHandler(handlerL);
		if (type != null)
		{
			e.setCatchType(new net.runelite.asm.pool.Class(type));
		}

		exceptions.add(e);
	}

	@Override
	public void visitLineNumber(int line, Label start)
	{
		net.runelite.asm.attributes.code.Label label = code.getInstructions().findLabel(start);

		if (label != null)
		{
			label.setLineNumber(line);
		}
	}

	@Override
	public void visitMaxs(int maxStack, int maxLocals)
	{
		code.setMaxStack(maxStack);
	}

	@Override
	public void visitEnd()
	{
		if (code != null)
		{
			for (Instruction i : code.getInstructions().getInstructions())
			{
				i.resolve();
			}

			method.setCode(code);
		}

		classFile.addMethod(method);
	}
}
