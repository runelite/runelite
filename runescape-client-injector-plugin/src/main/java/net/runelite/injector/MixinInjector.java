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
import java.util.HashMap;
import java.util.Map;
import net.runelite.asm.ClassFile;
import net.runelite.asm.ClassGroup;
import net.runelite.asm.Field;
import net.runelite.asm.Method;
import net.runelite.asm.Type;
import net.runelite.asm.attributes.annotation.Annotation;
import net.runelite.asm.attributes.code.Instruction;
import net.runelite.asm.attributes.code.instruction.types.FieldInstruction;
import net.runelite.asm.attributes.code.instruction.types.GetFieldInstruction;
import net.runelite.asm.attributes.code.instruction.types.InvokeInstruction;
import net.runelite.asm.attributes.code.instruction.types.SetFieldInstruction;
import net.runelite.asm.attributes.code.instructions.GetField;
import net.runelite.asm.attributes.code.instructions.InvokeDynamic;
import net.runelite.asm.attributes.code.instructions.PutField;
import net.runelite.asm.visitors.ClassFileVisitor;
import net.runelite.api.mixins.Mixin;
import org.objectweb.asm.ClassReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MixinInjector
{
	private static final Logger logger = LoggerFactory.getLogger(MixinInjector.class);

	private static final Type INJECT = new Type("Lnet/runelite/api/mixins/Inject;");
	private static final Type SHADOW = new Type("Lnet/runelite/api/mixins/Shadow;");

	private static final String MIXIN_BASE = "net.runelite.mixins";

	private final Inject inject;

	public MixinInjector(Inject inject)
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

		for (ClassInfo classInfo : classPath.getTopLevelClasses(MIXIN_BASE))
		{
			Class<?> mixinClass = classInfo.load();
			Mixin[] mixins = mixinClass.getAnnotationsByType(Mixin.class);
			for (Mixin mixin : mixins)
			{
				Class<?> implementInto = mixin.value();

				logger.debug("Injecting mixin {} into {}", mixinClass, implementInto);

				try
				{
					inject(mixinClass, implementInto);
				}
				catch (IOException ex)
				{
					throw new InjectionException(ex);
				}
			}
		}
	}

	private void inject(Class<?> mixinClass, Class<?> implementInto) throws IOException, InjectionException
	{
		ClassFile mixinCf = loadClass(mixinClass);
		// Find vanilla class which implements implementInto
		ClassFile vanillaCf = findVanillaForInterface(implementInto);

		if (vanillaCf == null)
		{
			throw new InjectionException("No class implements " + implementInto + " for mixin " + mixinClass);
		}

		inject(mixinCf, vanillaCf);
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

	private ClassFile findVanillaForInterface(Class<?> clazz)
	{
		for (ClassFile cf : inject.getVanilla().getClasses())
		{
			for (net.runelite.asm.pool.Class cl : cf.getInterfaces().getInterfaces())
			{
				if (cl.getName().equals(clazz.getName().replace('.', '/')))
				{
					return cf;
				}
			}
		}
		return null;
	}

	private void inject(ClassFile mixinCf, ClassFile cf) throws InjectionException
	{
		ClassGroup group = new ClassGroup();
		group.addClass(mixinCf);
		group.initialize();

		Map<Field, Field> shadowFields = new HashMap<>();
		Map<Field, Field> injectedFields = new HashMap<>();

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
				Field shadowField = findField(shadowName);

				if (shadowField == null)
				{
					throw new InjectionException("Shadow of nonexistent field " + shadowName);
				}

				shadowFields.put(field, shadowField);
			}

			Annotation inject = field.getAnnotations().find(INJECT);
			if (inject != null)
			{
				Field copy = new Field(cf, field.getName(), field.getType());
				copy.setAccessFlags(field.getAccessFlags());
				copy.setValue(field.getValue());
				cf.addField(copy);

				injectedFields.put(field, copy);
			}
		}

		for (Method method : mixinCf.getMethods())
		{
			if (method.getAnnotations().find(INJECT) == null)
			{
				continue;
			}

			Method copy = new Method(cf, method.getName(), method.getDescriptor());
			copy.setCode(method.getCode());
			copy.setAccessFlags(method.getAccessFlags());
			assert method.getExceptions().getExceptions().isEmpty();

			for (Instruction i : copy.getCode().getInstructions().getInstructions())
			{
				if (i instanceof GetFieldInstruction)
				{
					GetFieldInstruction gfi = (GetFieldInstruction) i;
					Field field = gfi.getMyField();

					Field shadowed = shadowFields.get(field);
					if (shadowed != null)
					{
						Field obShadow = inject.toObField(shadowed);
						assert obShadow != null;
						gfi.setField(obShadow.getPoolField());
					}

					Field injected = injectedFields.get(field);
					if (injected != null) {
						gfi.setField(injected.getPoolField());
					}
				}
				else if (i instanceof SetFieldInstruction)
				{
					SetFieldInstruction gfi = (SetFieldInstruction) i;
					Field field = gfi.getMyField();

					Field injected = injectedFields.get(field);
					if (injected != null) {
						gfi.setField(injected.getPoolField());
					}
				}
				else if (i instanceof InvokeInstruction)
				{
					InvokeInstruction ii = (InvokeInstruction) i;
					if (ii.getMethod() != null && ii.getMethod().getClazz().getName().equals(mixinCf.getName()))
					{
						ii.setMethod(new net.runelite.asm.pool.Method(
							new net.runelite.asm.pool.Class(cf.getName()),
							ii.getMethod().getName(),
							ii.getMethod().getType()
						));
					}
				}

				verify(mixinCf, i);
			}

			cf.addMethod(copy);

			logger.debug("Injected mixin method {} to {}", copy, cf);
		}
	}

	private Field findField(String name)
	{
		for (ClassFile cf : inject.getDeobfuscated().getClasses())
		{
			for (Field f : cf.getFields())
			{
				if (f.getName().equals(name) && f.isStatic())
				{
					return f;
				}
			}
		}
		return null;
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
		else if (i instanceof InvokeDynamic)
		{
			// RS classes don't verify under java 7+ due to the
			// super() invokespecial being inside of a try{}
			throw new InjectionException("Injected bytecode must be Java 6 compatible");
		}
	}
}
