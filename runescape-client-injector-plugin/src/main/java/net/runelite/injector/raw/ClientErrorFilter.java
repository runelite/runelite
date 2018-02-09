/*
 * Copyright (c) 2018, UniquePassive <https://github.com/uniquepassive>
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
package net.runelite.injector.raw;

import com.google.common.io.ByteStreams;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.stream.Collectors;
import net.runelite.asm.ClassFile;
import net.runelite.asm.Field;
import net.runelite.asm.Method;
import net.runelite.asm.Type;
import net.runelite.asm.attributes.Code;
import net.runelite.asm.attributes.code.Instruction;
import net.runelite.asm.attributes.code.InstructionType;
import net.runelite.asm.attributes.code.Instructions;
import net.runelite.asm.attributes.code.instructions.ALoad;
import net.runelite.asm.attributes.code.instructions.CheckCast;
import net.runelite.asm.attributes.code.instructions.Dup;
import net.runelite.asm.attributes.code.instructions.GetField;
import net.runelite.asm.attributes.code.instructions.IfEq;
import net.runelite.asm.attributes.code.instructions.IfNe;
import net.runelite.asm.attributes.code.instructions.InstanceOf;
import net.runelite.asm.attributes.code.instructions.InvokeStatic;
import net.runelite.asm.attributes.code.instructions.VReturn;
import net.runelite.asm.signature.Signature;
import net.runelite.asm.visitors.ClassFileVisitor;
import net.runelite.injector.Inject;
import net.runelite.injector.InjectionException;
import org.objectweb.asm.ClassReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Makes it so the client does not send
 * stack traces triggered by RuneLite to Jagex.
 */
public class ClientErrorFilter
{
	private static final Logger logger = LoggerFactory.getLogger(ClientErrorFilter.class);

	public static final Type THROWABLE = new Type("Ljava/lang/Throwable;");
	public static final String METHOD_TO_INJECT_NAME = "clientErrorFilter$shouldSend";

	private static boolean clientErrorFilter$shouldSend(Throwable throwable)
	{
		StackTraceElement[] stackTrace = throwable.getStackTrace();

		for (StackTraceElement stackTraceElement : stackTrace)
		{
			// If stack trace contains "runelite", don't send it
			if (stackTraceElement.getClassName().contains("runelite"))
			{
				return false;
			}
		}

		return true;
	}

	private final Inject inject;

	public ClientErrorFilter(Inject inject)
	{
		this.inject = inject;
	}

	public void inject() throws InjectionException
	{
		Method methodToInsert = null;

		try
		{
			String classAsPath = ClientErrorFilter.class.getName().replace(".", "/") + ".class";
			InputStream classStream = ClientErrorFilter.class.getClassLoader().getResourceAsStream(classAsPath);
			byte[] classBytes = ByteStreams.toByteArray(classStream);

			ClassFileVisitor cv = new ClassFileVisitor();
			ClassReader reader = new ClassReader(classBytes);
			reader.accept(cv, ClassReader.SKIP_DEBUG);

			for (Method m : cv.getClassFile().getMethods())
			{
				if (m.getName().equals(METHOD_TO_INJECT_NAME))
				{
					methodToInsert = m;
				}
			}
		}
		catch (IOException e)
		{
			throw new InjectionException(e);
		}

		if (methodToInsert == null)
		{
			throw new InjectionException(METHOD_TO_INJECT_NAME + " method could not be located");
		}

		boolean hasInjected = false;

		for (ClassFile c : inject.getVanilla().getClasses())
		{
			boolean shouldInjectMethod = false;

			for (Method m : c.getMethods())
			{
				if (m.getCode() == null)
				{
					continue;
				}

				if (!m.isStatic()
						|| m.getDescriptor().size() < 2
						|| m.getDescriptor().size() > 3
						|| !m.getDescriptor().getTypeOfArg(0).equals(Type.STRING)
						|| !m.getDescriptor().getTypeOfArg(1).equals(Type.THROWABLE))
				{
					continue;
				}

				Instructions instructions = m.getCode().getInstructions();

				// Find the instanceof in the method in order to establish the ob name for RunException class
				Type instanceOfType = null;

				for (Instruction i : instructions.getInstructions())
				{
					if (i instanceof InstanceOf)
					{
						if (instanceOfType != null)
						{
							throw new InjectionException("There should only be one instanceof in this method");
						}

						instanceOfType = ((InstanceOf) i).getType_();
					}
				}

				if (instanceOfType == null)
				{
					throw new InjectionException("instanceof instruction could not be located");
				}

				ClassFile runException = inject
						.getVanilla()
						.findClass(instanceOfType.getInternalName());

				if (runException == null)
				{
					throw new InjectionException("RunException class could not be located from instanceof type");
				}

				// Find non-static "parent" field of type Throwable
				List<Field> throwableFields = runException
						.getFields()
						.stream()
						.filter(f -> !f.isStatic())
						.filter(f -> f.getType().equals(THROWABLE))
						.collect(Collectors.toList());

				if (throwableFields.size() != 1)
				{
					throw new InjectionException("Expected 1 throwable field, found " + throwableFields.size());
				}

				Field parentThrowable = throwableFields.get(0);

				/*
					#162

					aload 1
					dup
					instanceof ef
					ifeq L1
					checkcast ef
					getfield ef.j : Ljava/lang/Throwable;
					L1:
					invokestatic shouldSend
					ifne L2
					return
					L2:
					original method code
				 */

				Instruction aload1 = new ALoad(instructions, 1); // load throwable

				Dup dup = new Dup(instructions);

				InstanceOf instanceOf = new InstanceOf(instructions, InstructionType.INSTANCEOf);
				instanceOf.setType(instanceOfType);

				IfEq ifEq = new IfEq(instructions, InstructionType.IFEQ);

				CheckCast checkCast = new CheckCast(instructions);
				checkCast.setType(instanceOfType);

				GetField getField = new GetField(instructions, parentThrowable.getPoolField());

				InvokeStatic shouldSend = new InvokeStatic(instructions,
						new net.runelite.asm.pool.Method(
								c.getPoolClass(),
								methodToInsert.getName(),
								methodToInsert.getDescriptor()
						)
				);

				IfNe ifNe = new IfNe(instructions, InstructionType.IFNE);
				ifNe.setTo(instructions.createLabelFor(instructions.getInstructions().get(0)));

				Instruction ret = new VReturn(instructions);

				instructions.addInstruction(0, aload1);
				instructions.addInstruction(1, dup);
				instructions.addInstruction(2, instanceOf);
				instructions.addInstruction(3, ifEq);
				instructions.addInstruction(4, checkCast);
				instructions.addInstruction(5, getField);
				instructions.addInstruction(6, shouldSend);
				instructions.addInstruction(7, ifNe);
				instructions.addInstruction(8, ret);

				// Cannot call createLabelFor when shouldSend isn't in the instructions list..
				ifEq.setTo(instructions.createLabelFor(shouldSend));

				hasInjected = true;
				shouldInjectMethod = true;

				logger.info("Injected client error filter into {}", m);
			}

			if (shouldInjectMethod)
			{
				// Copy shouldSend over to the target class
				Method copy = new Method(c, methodToInsert.getName(), new Signature(methodToInsert.getDescriptor()));

				Code copiedCode = new Code(copy);
				copiedCode.setMaxStack(methodToInsert.getCode().getMaxStack());
				copiedCode.getInstructions().getInstructions().addAll(methodToInsert.getCode().getInstructions().getInstructions());
				// Update instructions for each instruction
				for (Instruction i : copiedCode.getInstructions().getInstructions())
				{
					i.setInstructions(copiedCode.getInstructions());
				}
				copy.setCode(copiedCode);

				copy.setAccessFlags(methodToInsert.getAccessFlags());
				copy.setPublic();
				copy.getExceptions().getExceptions().addAll(methodToInsert.getExceptions().getExceptions());
				c.addMethod(copy);

				logger.info("Injected " + METHOD_TO_INJECT_NAME + " method into " + c);
			}
		}

		if (!hasInjected)
		{
			throw new InjectionException("Client error handler could not be located");
		}
	}
}
