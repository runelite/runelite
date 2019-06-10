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
package net.runelite.injector;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import net.runelite.asm.ClassFile;
import net.runelite.asm.ClassGroup;
import net.runelite.asm.Method;
import net.runelite.asm.Type;
import net.runelite.asm.attributes.Code;
import net.runelite.asm.attributes.code.Instruction;
import net.runelite.asm.attributes.code.Instructions;
import net.runelite.asm.attributes.code.instructions.CheckCast;
import net.runelite.asm.attributes.code.instructions.Dup;
import net.runelite.asm.attributes.code.instructions.InvokeSpecial;
import net.runelite.asm.attributes.code.instructions.New;
import net.runelite.asm.attributes.code.instructions.Return;
import net.runelite.asm.signature.Signature;
import net.runelite.deob.DeobAnnotations;
import net.runelite.mapping.Construct;
import static org.objectweb.asm.Opcodes.ACC_PUBLIC;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class InjectConstruct
{
	private static final Logger logger = LoggerFactory.getLogger(InjectConstruct.class);

	private final Inject inject;

	InjectConstruct(Inject inject)
	{
		this.inject = inject;
	}

	public void inject(Map<ClassFile, java.lang.Class> implemented) throws InjectionException
	{
		for (Entry<ClassFile, java.lang.Class> entry : implemented.entrySet())
		{
			Class<?> clazz = entry.getValue();
			ClassFile cf = entry.getKey();

			if (clazz == null)
			{
				continue;
			}

			for (java.lang.reflect.Method method : clazz.getDeclaredMethods())
			{
				if (method.isSynthetic())
				{
					continue;
				}

				Construct construct = method.getAnnotation(Construct.class);
				if (construct == null)
				{
					continue;
				}

				String obfuscatedName = DeobAnnotations.getObfuscatedName(cf.getAnnotations());
				if (obfuscatedName == null)
				{
					obfuscatedName = cf.getName();
				}

				ClassGroup vanilla = inject.getVanilla();
				ClassFile other = vanilla.findClass(obfuscatedName);
				assert other != null : "unable to find vanilla class from obfuscated name: " + obfuscatedName;

				injectConstruct(other, method);
			}
		}
	}

	void injectConstruct(ClassFile targetClass, java.lang.reflect.Method apiMethod) throws InjectionException
	{
		logger.info("Injecting construct for {}", apiMethod);

		assert targetClass.findMethod(apiMethod.getName()) == null;

		Class<?> typeToConstruct = apiMethod.getReturnType();
		ClassFile vanillaClass = inject.findVanillaForInterface(typeToConstruct);
		if (vanillaClass == null)
		{
			throw new InjectionException("Unable to find vanilla class which implements interface " + typeToConstruct);
		}

		Signature sig = inject.javaMethodToSignature(apiMethod);

		Signature constructorSig = new Signature.Builder()
			.addArguments(Stream.of(apiMethod.getParameterTypes())
				.map(arg ->
				{
					ClassFile vanilla = inject.findVanillaForInterface(arg);
					if (vanilla != null)
					{
						return new Type("L" + vanilla.getName() + ";");
					}
					return Inject.classToType(arg);
				})
				.collect(Collectors.toList()))
			.setReturnType(Type.VOID)
			.build();
		Method vanillaConstructor = vanillaClass.findMethod("<init>", constructorSig);
		if (vanillaConstructor == null)
		{
			throw new InjectionException("Unable to find constructor for " + vanillaClass.getName() + ".<init>" + constructorSig);
		}

		Method setterMethod = new Method(targetClass, apiMethod.getName(), sig);
		setterMethod.setAccessFlags(ACC_PUBLIC);
		targetClass.addMethod(setterMethod);

		Code code = new Code(setterMethod);
		setterMethod.setCode(code);

		Instructions instructions = code.getInstructions();
		List<Instruction> ins = instructions.getInstructions();

		ins.add(new New(instructions, vanillaClass.getPoolClass()));
		ins.add(new Dup(instructions));
		int idx = 1;
		int parameter = 0;
		for (Type type : vanillaConstructor.getDescriptor().getArguments())
		{
			Instruction load = inject.createLoadForTypeIndex(instructions, type, idx);
			idx += type.getSize();
			ins.add(load);

			Type paramType = sig.getTypeOfArg(parameter);
			if (!type.equals(paramType))
			{
				CheckCast checkCast = new CheckCast(instructions);
				checkCast.setType(type);
				ins.add(checkCast);
			}

			++parameter;
		}
		ins.add(new InvokeSpecial(instructions, vanillaConstructor.getPoolMethod()));
		ins.add(new Return(instructions));

	}
}
