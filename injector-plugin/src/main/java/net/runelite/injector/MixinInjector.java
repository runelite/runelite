/*
 * Copyright (c) 2017, Adam <Adam@sigterm.info>
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

import com.google.common.reflect.ClassPath;
import com.google.common.reflect.ClassPath.ClassInfo;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import net.runelite.api.mixins.Mixin;
import net.runelite.asm.ClassFile;
import net.runelite.asm.Field;
import net.runelite.asm.Method;
import net.runelite.asm.Type;
import net.runelite.asm.attributes.Code;
import net.runelite.asm.attributes.annotation.Annotation;
import net.runelite.asm.attributes.code.Instruction;
import net.runelite.asm.attributes.code.Instructions;
import net.runelite.asm.attributes.code.instruction.types.FieldInstruction;
import net.runelite.asm.attributes.code.instruction.types.InvokeInstruction;
import net.runelite.asm.attributes.code.instruction.types.LVTInstruction;
import net.runelite.asm.attributes.code.instruction.types.PushConstantInstruction;
import net.runelite.asm.attributes.code.instruction.types.ReturnInstruction;
import net.runelite.asm.attributes.code.instructions.ALoad;
import net.runelite.asm.attributes.code.instructions.ANewArray;
import net.runelite.asm.attributes.code.instructions.CheckCast;
import net.runelite.asm.attributes.code.instructions.GetField;
import net.runelite.asm.attributes.code.instructions.ILoad;
import net.runelite.asm.attributes.code.instructions.InvokeDynamic;
import net.runelite.asm.attributes.code.instructions.InvokeSpecial;
import net.runelite.asm.attributes.code.instructions.InvokeStatic;
import net.runelite.asm.attributes.code.instructions.Pop;
import net.runelite.asm.attributes.code.instructions.PutField;
import net.runelite.asm.signature.Signature;
import net.runelite.asm.visitors.ClassFileVisitor;
import net.runelite.deob.DeobAnnotations;
import static net.runelite.injector.InjectUtil.findStaticMethod;
import static net.runelite.injector.InjectUtil.toDeobClass;
import static net.runelite.injector.InjectUtil.toObClass;
import static net.runelite.injector.InjectUtil.toObField;
import org.objectweb.asm.ClassReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MixinInjector
{
	private static final Logger logger = LoggerFactory.getLogger(MixinInjector.class);

	private static final Type INJECT = new Type("Lnet/runelite/api/mixins/Inject;");
	private static final Type SHADOW = new Type("Lnet/runelite/api/mixins/Shadow;");
	private static final Type COPY = new Type("Lnet/runelite/api/mixins/Copy;");
	private static final Type REPLACE = new Type("Lnet/runelite/api/mixins/Replace;");
	private static final Type FIELDHOOK = new Type("Lnet/runelite/api/mixins/FieldHook;");
	private static final Type METHODHOOK = new Type("Lnet/runelite/api/mixins/MethodHook;");
	private static final Type JAVAX_INJECT = new Type("Ljavax/inject/Inject;");
	private static final Type NAMED = new Type("Ljavax/inject/Named;");

	private static final String MIXIN_BASE = "net.runelite.mixins";
	private static final String ASSERTION_FIELD = "$assertionsDisabled";

	private final Inject inject;

	// field name -> Field of injected fields
	private final Map<String, Field> injectedFields = new HashMap<>();
	// Use net.runelite.asm.pool.Field instead of Field because the pool version has hashcode implemented
	private final Map<net.runelite.asm.pool.Field, Field> shadowFields = new HashMap<>();

	MixinInjector(Inject inject)
	{
		this.inject = inject;
	}

	public void inject() throws InjectionException
	{
		ClassPath classPath;

		try
		{
			classPath = ClassPath.from(this.getClass().getClassLoader());
		}
		catch (IOException ex)
		{
			throw new InjectionException(ex);
		}

		// key: mixin class
		// value: mixin targets
		Map<Class<?>, List<ClassFile>> mixinClasses = new HashMap<>();

		// Find mixins and populate mixinClasses
		for (ClassInfo classInfo : classPath.getTopLevelClasses(MIXIN_BASE))
		{
			Class<?> mixinClass = classInfo.load();
			List<ClassFile> mixinTargets = new ArrayList<>();

			for (Mixin mixin : mixinClass.getAnnotationsByType(Mixin.class))
			{
				Class<?> implementInto = mixin.value();

				ClassFile targetCf = inject.findVanillaForInterface(implementInto);

				if (targetCf == null)
				{
					throw new InjectionException("No class implements " + implementInto + " for mixin " + mixinClass);
				}

				mixinTargets.add(targetCf);
			}

			mixinClasses.put(mixinClass, mixinTargets);
		}

		inject(mixinClasses);
	}

	public void inject(Map<Class<?>, List<ClassFile>> mixinClasses) throws InjectionException
	{
		injectFields(mixinClasses);
		findShadowFields(mixinClasses);

		for (Class<?> mixinClass : mixinClasses.keySet())
		{
			try
			{
				for (ClassFile cf : mixinClasses.get(mixinClass))
				{
					// Make a new mixin ClassFile copy every time,
					// so they don't share Code references
					ClassFile mixinCf = loadClass(mixinClass);

					injectMethods(mixinCf, cf, shadowFields);
				}
			}
			catch (IOException ex)
			{
				throw new InjectionException(ex);
			}
		}

		injectFieldHooks(mixinClasses);
		injectMethodHooks(mixinClasses);
	}

	/**
	 * Finds fields that are marked @Inject and inject them into the target
	 */
	private void injectFields(Map<Class<?>, List<ClassFile>> mixinClasses) throws InjectionException
	{
		// Inject fields, and put them in injectedFields if they can be used by other mixins
		for (Class<?> mixinClass : mixinClasses.keySet())
		{
			ClassFile mixinCf;

			try
			{
				mixinCf = loadClass(mixinClass);
			}
			catch (IOException ex)
			{
				throw new InjectionException(ex);
			}

			List<ClassFile> targetCfs = mixinClasses.get(mixinClass);

			for (ClassFile cf : targetCfs)
			{
				for (Field field : mixinCf.getFields())
				{
					// Always inject $assertionsEnabled if its missing.
					if (ASSERTION_FIELD.equals(field.getName()))
					{
						if (cf.findField(ASSERTION_FIELD, Type.BOOLEAN) != null)
						{
							continue;
						}
					}
					else
					{
						Annotation inject = field.getAnnotations().find(INJECT);

						if (inject == null)
						{
							continue;
						}
					}

					Field copy = new Field(cf, field.getName(), field.getType());
					copy.setAccessFlags(field.getAccessFlags());
					copy.setPublic();
					copy.setValue(field.getValue());

					Annotation jInject = field.getAnnotations().find(JAVAX_INJECT);
					if (jInject != null)
					{
						copy.getAnnotations().addAnnotation(jInject);
						logger.info("Added javax inject to {}.{}", cf.getClassName(), copy.getName());

						Annotation named = field.getAnnotations().find(NAMED);
						if (named != null)
						{
							copy.getAnnotations().addAnnotation(named);
							logger.info("Added javax named to {}.{}", cf.getClassName(), copy.getName());
						}
					}

					cf.addField(copy);

					if (injectedFields.containsKey(field.getName()) && !field.getName().equals(ASSERTION_FIELD))
					{
						java.util.logging.Logger.getAnonymousLogger().severe("Duplicate field : " + field.getName());
						throw new InjectionException("Injected field names must be globally unique");
					}

					injectedFields.put(field.getName(), copy);
				}
			}

		}
	}

	/**
	 * Find fields which are marked @Shadow, and what they shadow
	 */
	private void findShadowFields(Map<Class<?>, List<ClassFile>> mixinClasses) throws InjectionException
	{
		// Find shadow fields
		// Injected static fields take precedence when looking up shadowed fields
		for (Class<?> mixinClass : mixinClasses.keySet())
		{
			ClassFile mixinCf;

			try
			{
				mixinCf = loadClass(mixinClass);
			}
			catch (IOException ex)
			{
				throw new InjectionException(ex);
			}

			for (Field field : mixinCf.getFields())
			{
				Annotation shadow = field.getAnnotations().find(SHADOW);
				if (shadow != null)
				{
					if (!field.isStatic())
					{
						throw new InjectionException("Can only shadow static fields");
					}

					String shadowName = shadow.getElement().getString(); // shadow this field

					Field injectedField = injectedFields.get(shadowName);
					if (injectedField != null)
					{
						// Shadow a field injected by a mixin
						shadowFields.put(field.getPoolField(), injectedField);
					}
					else
					{
						// Shadow a field already in the gamepack
						Field shadowField = InjectUtil.findDeobFieldButUseless(inject, shadowName);

						if (shadowField == null)
						{
							throw new InjectionException("Shadow of nonexistent field " + shadowName);
						}

						Field obShadow = toObField(inject.getVanilla(), shadowField);
						assert obShadow != null;
						shadowFields.put(field.getPoolField(), obShadow);
					}
				}
			}
		}
	}

	private ClassFile loadClass(Class<?> clazz) throws IOException
	{
		try (InputStream is = clazz.getClassLoader().getResourceAsStream(clazz.getName().replace('.', '/') + ".class"))
		{
			ClassReader reader = new ClassReader(is);
			ClassFileVisitor cv = new ClassFileVisitor();

			reader.accept(cv, 0);

			return cv.getClassFile();
		}
	}

	private void injectMethods(ClassFile mixinCf, ClassFile cf, Map<net.runelite.asm.pool.Field, Field> shadowFields)
		throws InjectionException
	{
		// Keeps mappings between methods annotated with @Copy -> the copied method within the vanilla pack
		Map<net.runelite.asm.pool.Method, CopiedMethod> copiedMethods = new HashMap<>();

		// Handle the copy mixins first, so all other mixins know of the copies
		for (Method method : mixinCf.getMethods())
		{
			Annotation copyAnnotation = method.getAnnotations().find(COPY);

			if (copyAnnotation == null)
			{
				continue;
			}

			String deobMethodName = (String) copyAnnotation.getElement().getValue();
			Method deobMethod;
			if (method.isStatic())
			{
				deobMethod = findStaticMethod(inject.getDeobfuscated(), deobMethodName, method.getDescriptor().rsApiToRsClient());
			}
			else
			{
				ClassFile deobCf = toDeobClass(cf, inject.getDeobfuscated());
				deobMethod = deobCf.findMethod(deobMethodName, method.getDescriptor().rsApiToRsClient());
			}


			if (deobMethod == null)
			{
				throw new InjectionException("Failed to find the deob method " + deobMethodName + " for mixin " + mixinCf);
			}

			if (method.isStatic() != deobMethod.isStatic())
			{
				throw new InjectionException("Mixin method " + method + " should be " + (deobMethod.isStatic() ? "static" : "non-static"));
			}

			// Find the vanilla class where the method to copy is in
			String obClassName = DeobAnnotations.getObfuscatedName(deobMethod.getClassFile().getAnnotations());
			ClassFile obCf = inject.getVanilla().findClass(obClassName);
			assert obCf != null : "unable to find vanilla class from obfuscated name " + obClassName;

			String obMethodName = DeobAnnotations.getObfuscatedName(deobMethod.getAnnotations());
			Signature obMethodSignature = DeobAnnotations.getObfuscatedSignature(deobMethod);

			if (obMethodName == null)
			{
				obMethodName = deobMethod.getName();
			}
			if (obMethodSignature == null)
			{
				obMethodSignature = deobMethod.getDescriptor();
			}

			Method obMethod = obCf.findMethod(obMethodName, obMethodSignature);
			if (obMethod == null)
			{
				throw new InjectionException("Failed to find the ob method " + obMethodName + " for mixin " + mixinCf);
			}

			if (method.getDescriptor().size() > obMethod.getDescriptor().size())
			{
				throw new InjectionException("Mixin methods cannot have more parameters than their corresponding ob method");
			}

			Method copy = new Method(cf, "copy$" + deobMethodName, obMethodSignature);
			moveCode(copy, obMethod.getCode());
			copy.setAccessFlags(obMethod.getAccessFlags());
			copy.setPublic();
			copy.getExceptions().getExceptions().addAll(obMethod.getExceptions().getExceptions());
			copy.getAnnotations().getAnnotations().addAll(obMethod.getAnnotations().getAnnotations());
			cf.addMethod(copy);

			/*
				If the desc for the mixin method and the desc for the ob method
				are the same in length, assume that the mixin method is taking
				care of the garbage parameter itself.
			 */
			boolean hasGarbageValue = method.getDescriptor().size() != obMethod.getDescriptor().size()
				&& deobMethod.getDescriptor().size() < obMethodSignature.size();
			copiedMethods.put(method.getPoolMethod(), new CopiedMethod(copy, hasGarbageValue));

			logger.debug("Injected copy of {} to {}", obMethod, copy);
		}

		// Handle the rest of the mixin types
		for (Method method : mixinCf.getMethods())
		{
			boolean isClinit = "<clinit>".equals(method.getName());
			boolean isInit = "<init>".equals(method.getName());
			boolean hasInject = method.getAnnotations().find(INJECT) != null;

			// You can't annotate clinit, so its always injected
			if ((hasInject && isInit) || isClinit)
			{
				if (!"()V".equals(method.getDescriptor().toString()))
				{
					throw new InjectionException("Injected constructors cannot have arguments");
				}

				Method[] originalMethods = cf.getMethods().stream()
					.filter(n -> n.getName().equals(method.getName()))
					.toArray(Method[]::new);
				// If there isn't a <clinit> already just inject ours, otherwise rename it
				// This is always true for <init>
				String name = method.getName();
				if (originalMethods.length > 0)
				{
					name = "rl$$" + (isInit ? "init" : "clinit");
				}
				String numberlessName = name;
				for (int i = 1; cf.findMethod(name, method.getDescriptor()) != null; i++)
				{
					name = numberlessName + i;
				}

				Method copy = new Method(cf, name, method.getDescriptor());
				moveCode(copy, method.getCode());
				copy.setAccessFlags(method.getAccessFlags());
				copy.setPrivate();
				assert method.getExceptions().getExceptions().isEmpty();

				// Remove the call to the superclass's ctor
				if (isInit)
				{
					Instructions instructions = copy.getCode().getInstructions();
					ListIterator<Instruction> listIter = instructions.getInstructions().listIterator();
					for (; listIter.hasNext(); )
					{
						Instruction instr = listIter.next();
						if (instr instanceof InvokeSpecial)
						{
							InvokeSpecial invoke = (InvokeSpecial) instr;
							assert invoke.getMethod().getName().equals("<init>");
							listIter.remove();
							int pops = invoke.getMethod().getType().getArguments().size() + 1;
							for (int i = 0; i < pops; i++)
							{
								listIter.add(new Pop(instructions));
							}
							break;
						}
					}
				}

				setOwnersToTargetClass(mixinCf, cf, copy, shadowFields, copiedMethods);
				cf.addMethod(copy);

				// Call our method at the return point of the matching method(s)
				for (Method om : originalMethods)
				{
					Instructions instructions = om.getCode().getInstructions();
					ListIterator<Instruction> listIter = instructions.getInstructions().listIterator();
					for (; listIter.hasNext(); )
					{
						Instruction instr = listIter.next();
						if (instr instanceof ReturnInstruction)
						{
							listIter.previous();
							if (isInit)
							{
								listIter.add(new ALoad(instructions, 0));
								listIter.add(new InvokeSpecial(instructions, copy.getPoolMethod()));
							}
							else if (isClinit)
							{
								listIter.add(new InvokeStatic(instructions, copy.getPoolMethod()));
							}
							listIter.next();
						}
					}
				}

				logger.debug("Injected mixin method {} to {}", copy, cf);
			}
			else if (hasInject)
			{
				// Make sure the method doesn't invoke copied methods
				for (Instruction i : method.getCode().getInstructions().getInstructions())
				{
					if (i instanceof InvokeInstruction)
					{
						InvokeInstruction ii = (InvokeInstruction) i;

						if (copiedMethods.containsKey(ii.getMethod()))
						{
							throw new InjectionException("Injected methods cannot invoke copied methods");
						}
					}
				}

				Method copy = new Method(cf, method.getName(), method.getDescriptor());
				moveCode(copy, method.getCode());
				copy.setAccessFlags(method.getAccessFlags());
				copy.setPublic();
				assert method.getExceptions().getExceptions().isEmpty();

				setOwnersToTargetClass(mixinCf, cf, copy, shadowFields, copiedMethods);

				cf.addMethod(copy);

				logger.debug("Injected mixin method {} to {}", copy, cf);
			}
			else if (method.getAnnotations().find(REPLACE) != null)
			{
				Annotation replaceAnnotation = method.getAnnotations().find(REPLACE);
				String deobMethodName = (String) replaceAnnotation.getElement().getValue();

				ClassFile deobCf = inject.toDeobClass(cf);
				Method deobMethod = findDeobMethod(deobCf, deobMethodName, method.getDescriptor());

				if (deobMethod == null)
				{
					throw new InjectionException("Failed to find the deob method " + deobMethodName + " for mixin " + mixinCf);
				}

				if (method.isStatic() != deobMethod.isStatic())
				{
					throw new InjectionException("Mixin method " + method + " should be "
						+ (deobMethod.isStatic() ? "static" : "non-static"));
				}

				String obMethodName = DeobAnnotations.getObfuscatedName(deobMethod.getAnnotations());
				Signature obMethodSignature = DeobAnnotations.getObfuscatedSignature(deobMethod);

				// Deob signature is the same as ob signature
				if (obMethodName == null)
				{
					obMethodName = deobMethod.getName();
				}
				if (obMethodSignature == null)
				{
					obMethodSignature = deobMethod.getDescriptor();
				}

				// Find the vanilla class where the method to copy is in
				String obClassName = DeobAnnotations.getObfuscatedName(deobMethod.getClassFile().getAnnotations());
				ClassFile obCf = inject.getVanilla().findClass(obClassName);

				Method obMethod = obCf.findMethod(obMethodName, obMethodSignature);
				assert obMethod != null : "obfuscated method " + obMethodName + obMethodSignature + " does not exist";

				if (method.getDescriptor().size() > obMethod.getDescriptor().size())
				{
					throw new InjectionException("Mixin methods cannot have more parameters than their corresponding ob method");
				}

				Type returnType = method.getDescriptor().getReturnValue();
				Type deobReturnType = inject.apiTypeToDeobfuscatedType(returnType);
				if (!returnType.equals(deobReturnType))
				{
					ClassFile deobReturnTypeClassFile = inject.getDeobfuscated()
						.findClass(deobReturnType.getInternalName());
					if (deobReturnTypeClassFile != null)
					{
						ClassFile obReturnTypeClass = toObClass(inject.getVanilla(), deobReturnTypeClassFile);

						Instructions instructions = method.getCode().getInstructions();
						ListIterator<Instruction> listIter = instructions.getInstructions().listIterator();
						for (; listIter.hasNext(); )
						{
							Instruction instr = listIter.next();
							if (instr instanceof ReturnInstruction)
							{
								listIter.previous();
								CheckCast checkCast = new CheckCast(instructions);
								checkCast.setType(new Type(obReturnTypeClass.getName()));
								listIter.add(checkCast);
								listIter.next();
							}
						}
					}
				}

				moveCode(obMethod, method.getCode());

				boolean hasGarbageValue = method.getDescriptor().size() != obMethod.getDescriptor().size()
					&& deobMethod.getDescriptor().size() < obMethodSignature.size();

				if (hasGarbageValue)
				{
					int garbageIndex = obMethod.isStatic()
						? obMethod.getDescriptor().size() - 1
						: obMethod.getDescriptor().size();

					/*
						If the mixin method doesn't have the garbage parameter,
						the compiler will have produced code that uses the garbage
						parameter's local variable index for other things,
						so we'll have to add 1 to all loads/stores to indices
						that are >= garbageIndex.
					 */
					shiftLocalIndices(obMethod.getCode().getInstructions(), garbageIndex);
				}

				setOwnersToTargetClass(mixinCf, cf, obMethod, shadowFields, copiedMethods);

				logger.debug("Replaced method {} with mixin method {}", obMethod, method);
			}
		}
	}

	private void moveCode(Method method, Code code)
	{
		Code newCode = new Code(method);
		newCode.setMaxStack(code.getMaxStack());
		newCode.getInstructions().getInstructions().addAll(code.getInstructions().getInstructions());
		// Update instructions for each instruction
		for (Instruction i : newCode.getInstructions().getInstructions())
		{
			i.setInstructions(newCode.getInstructions());
		}
		newCode.getExceptions().getExceptions().addAll(code.getExceptions().getExceptions());
		for (net.runelite.asm.attributes.code.Exception e : newCode.getExceptions().getExceptions())
		{
			e.setExceptions(newCode.getExceptions());
		}
		method.setCode(newCode);
	}

	private void setOwnersToTargetClass(ClassFile mixinCf, ClassFile cf, Method method,
										Map<net.runelite.asm.pool.Field, Field> shadowFields,
										Map<net.runelite.asm.pool.Method, CopiedMethod> copiedMethods)
		throws InjectionException
	{
		ListIterator<Instruction> iterator = method.getCode().getInstructions().getInstructions().listIterator();

		while (iterator.hasNext())
		{
			Instruction i = iterator.next();

			if (i instanceof ANewArray)
			{
				Type type = ((ANewArray) i).getType_();
				ClassFile deobCf = inject.getDeobfuscated().findClass(type.toString().replace("Lnet/runelite/rs/api/RS", "").replace(";", ""));

				if (deobCf != null)
				{
					ClassFile obReturnTypeClass = toObClass(inject.getVanilla(), deobCf);
					Type newType = new Type("L" + obReturnTypeClass.getName() + ";");

					((ANewArray) i).setType(newType);
					logger.info("Replaced {} type {} with type {}", i, type, newType);
				}
			}

			if (i instanceof InvokeInstruction)
			{
				InvokeInstruction ii = (InvokeInstruction) i;

				CopiedMethod copiedMethod = copiedMethods.get(ii.getMethod());
				if (copiedMethod != null)
				{
					ii.setMethod(copiedMethod.obMethod.getPoolMethod());

					// Pass through garbage value if the method has one
					if (copiedMethod.hasGarbageValue)
					{
						int garbageIndex = copiedMethod.obMethod.isStatic()
							? copiedMethod.obMethod.getDescriptor().size() - 1
							: copiedMethod.obMethod.getDescriptor().size();

						iterator.previous();
						iterator.add(new ILoad(method.getCode().getInstructions(), garbageIndex));
						iterator.next();
					}
				}
				else if (ii.getMethod().getClazz().getName().equals(mixinCf.getName()))
				{
					ii.setMethod(new net.runelite.asm.pool.Method(
						new net.runelite.asm.pool.Class(cf.getName()),
						ii.getMethod().getName(),
						ii.getMethod().getType()
					));
				}
			}
			else if (i instanceof FieldInstruction)
			{
				FieldInstruction fi = (FieldInstruction) i;

				Field shadowed = shadowFields.get(fi.getField());
				if (shadowed != null)
				{
					fi.setField(shadowed.getPoolField());
				}
				else if (fi.getField().getClazz().getName().equals(mixinCf.getName()))
				{
					fi.setField(new net.runelite.asm.pool.Field(
						new net.runelite.asm.pool.Class(cf.getName()),
						fi.getField().getName(),
						fi.getField().getType()
					));
				}
			}
			else if (i instanceof PushConstantInstruction)
			{
				PushConstantInstruction pi = (PushConstantInstruction) i;
				if (mixinCf.getPoolClass().equals(pi.getConstant()))
				{
					pi.setConstant(cf.getPoolClass());
				}
			}

			verify(mixinCf, i);
		}
	}

	private void shiftLocalIndices(Instructions instructions, int startIdx)
	{
		for (Instruction i : instructions.getInstructions())
		{
			if (i instanceof LVTInstruction)
			{
				LVTInstruction lvti = (LVTInstruction) i;

				if (lvti.getVariableIndex() >= startIdx)
				{
					lvti.setVariableIndex(lvti.getVariableIndex() + 1);
				}
			}
		}
	}

	private Method findDeobMethod(ClassFile deobCf, String deobMethodName, Signature descriptor)
		throws InjectionException
	{
		List<Method> matchingMethods = new ArrayList<>();

		for (Method m : deobCf.getMethods())
		{
			if (!deobMethodName.equals(m.getName()))
			{
				continue;
			}

			Type returnType = inject.apiTypeToDeobfuscatedType(descriptor.getReturnValue());
			Type returnType2 = m.getDescriptor().getReturnValue();

			if (!returnType.equals(returnType2))
			{
				continue;
			}

			List<Type> args = descriptor.getArguments();
			List<Type> args2 = m.getDescriptor().getArguments();

			if (args.size() > args2.size())
			{
				continue;
			}

			boolean matchingArgs = true;

			for (int i = 0; i < args.size(); i++)
			{
				Type type = inject.apiTypeToDeobfuscatedType(args.get(i));
				Type type2 = args2.get(i);

				if (!type.equals(type2))
				{
					matchingArgs = false;
					break;
				}
			}

			if (!matchingArgs)
			{
				continue;
			}

			matchingMethods.add(m);
		}

		if (matchingMethods.size() > 1)
		{
			// this happens when it has found several deob methods for some mixin method,
			// to get rid of the error, refine your search by making your mixin method have more parameters
			throw new InjectionException("There are several matching methods when there should only be one");
		}
		else if (matchingMethods.size() == 1)
		{
			return matchingMethods.get(0);
		}

		Method method = deobCf.findMethod(deobMethodName);

		if (method == null)
		{
			// Look for static methods if an instance method couldn't be found
			for (ClassFile deobCf2 : inject.getDeobfuscated().getClasses())
			{
				if (deobCf2 != deobCf)
				{
					method = deobCf2.findMethod(deobMethodName);

					if (method != null)
					{
						break;
					}
				}
			}
		}

		return method;
	}

	private void verify(ClassFile mixinCf, Instruction i) throws InjectionException
	{
		if (i instanceof FieldInstruction)
		{
			FieldInstruction fi = (FieldInstruction) i;

			if (fi.getField().getClazz().getName().equals(mixinCf.getName()))
			{
				if (i instanceof PutField || i instanceof GetField)
				{
					throw new InjectionException("Access to non static member field of mixin");
				}

				Field field = fi.getMyField();
				if (field != null && !field.isPublic())
				{
					throw new InjectionException("Static access to non public field " + field);
				}
			}
		}
		else if (i instanceof InvokeStatic)
		{
			InvokeStatic is = (InvokeStatic) i;

			if (is.getMethod().getClazz() != mixinCf.getPoolClass()
				&& is.getMethod().getClazz().getName().startsWith(MIXIN_BASE.replace(".", "/")))
			{
				throw new InjectionException("Invoking static methods of other mixins is not supported");
			}
		}
		else if (i instanceof InvokeDynamic)
		{
			// RS classes don't verify under java 7+ due to the
			// super() invokespecial being inside of a try{}
			throw new InjectionException("Injected bytecode must be Java 6 compatible");
		}
	}

	private void injectFieldHooks(Map<Class<?>, List<ClassFile>> mixinClasses) throws InjectionException
	{
		InjectHook injectHook = new InjectHook(inject);

		for (Class<?> mixinClass : mixinClasses.keySet())
		{
			ClassFile mixinCf;

			try
			{
				mixinCf = loadClass(mixinClass);
			}
			catch (IOException ex)
			{
				throw new InjectionException(ex);
			}

			List<ClassFile> targetCfs = mixinClasses.get(mixinClass);

			for (ClassFile cf : targetCfs)
			{
				for (Method method : mixinCf.getMethods())
				{
					Annotation fieldHook = method.getAnnotations().find(FIELDHOOK);
					if (fieldHook != null)
					{
						String hookName = fieldHook.getElement().getString();
						boolean before = fieldHook.getElements().size() == 2 && fieldHook.getElements().get(1).getValue().equals(true);
						ClassFile deobCf = inject.toDeobClass(cf);
						Field targetField = deobCf.findField(hookName);
						if (targetField == null)
						{
							// first try non static fields, then static
							targetField = InjectUtil.findDeobFieldButUseless(inject, hookName);
						}

						if (targetField == null)
						{
							throw new InjectionException("Field hook for nonexistent field " + hookName + " on " + method);
						}

						Annotation an = targetField.getAnnotations().find(DeobAnnotations.OBFUSCATED_GETTER);
						Number getter = null;
						if (an != null)
						{
							getter = (Number) an.getElement().getValue();
						}

						Field obField = toObField(inject.getVanilla(), targetField);

						if (method.isStatic() != targetField.isStatic())
						{
							throw new InjectionException("Field hook method static flag must match target field");
						}

						// cf is the target class to invoke
						InjectHook.HookInfo hookInfo = new InjectHook.HookInfo();
						hookInfo.clazz = cf.getName();
						hookInfo.fieldName = hookName;
						hookInfo.method = method;
						hookInfo.before = before;
						hookInfo.getter = getter;
						injectHook.hook(obField, hookInfo);
					}
				}
			}
		}

		injectHook.run();

		logger.info("Injected {} field hooks", injectHook.getInjectedHooks());
	}

	private void injectMethodHooks(Map<Class<?>, List<ClassFile>> mixinClasses) throws InjectionException
	{
		InjectHookMethod injectHookMethod = new InjectHookMethod(inject);

		for (Class<?> mixinClass : mixinClasses.keySet())
		{
			ClassFile mixinCf;

			try
			{
				mixinCf = loadClass(mixinClass);
			}
			catch (IOException ex)
			{
				throw new InjectionException(ex);
			}

			List<ClassFile> targetCfs = mixinClasses.get(mixinClass);

			for (ClassFile cf : targetCfs)
			{
				for (Method method : mixinCf.getMethods())
				{
					Annotation methodHook = method.getAnnotations().find(METHODHOOK);

					if (methodHook == null)
					{
						continue;
					}

					String hookName = methodHook.getElement().getString();
					boolean end = methodHook.getElements().size() == 2 && methodHook.getElements().get(1).getValue().equals(true);
					ClassFile deobCf = inject.toDeobClass(cf);
					Method targetMethod = findDeobMethod(deobCf, hookName, method.getDescriptor());

					if (targetMethod == null)
					{
						throw new InjectionException("Method hook for nonexistent method " + hookName + " on " + method);
					}

					if (method.isStatic() != targetMethod.isStatic())
					{
						throw new InjectionException("Method hook static flag must match target - " + hookName);
					}

					injectHookMethod.inject(method, targetMethod, hookName, end, false);
				}
			}
		}
	}

	private static class CopiedMethod
	{
		private Method obMethod;
		private boolean hasGarbageValue;

		private CopiedMethod(Method obMethod, boolean hasGarbageValue)
		{
			this.obMethod = obMethod;
			this.hasGarbageValue = hasGarbageValue;
		}
	}
}
