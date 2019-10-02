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

import java.util.HashMap;
import java.util.Map;
import net.runelite.asm.ClassFile;
import net.runelite.asm.ClassGroup;
import net.runelite.asm.Field;
import net.runelite.asm.Interfaces;
import net.runelite.asm.Method;
import net.runelite.asm.Type;
import net.runelite.asm.attributes.Annotations;
import net.runelite.asm.attributes.annotation.Annotation;
import net.runelite.asm.attributes.code.Instruction;
import net.runelite.asm.attributes.code.Instructions;
import net.runelite.asm.attributes.code.instructions.ALoad;
import net.runelite.asm.attributes.code.instructions.DLoad;
import net.runelite.asm.attributes.code.instructions.FLoad;
import net.runelite.asm.attributes.code.instructions.ILoad;
import net.runelite.asm.attributes.code.instructions.LLoad;
import net.runelite.asm.pool.Class;
import net.runelite.asm.signature.Signature;
import net.runelite.deob.DeobAnnotations;
import net.runelite.deob.deobfuscators.arithmetic.DMath;
import static net.runelite.injector.InjectUtil.getFieldType;
import net.runelite.injector.raw.ClearColorBuffer;
import net.runelite.injector.raw.DrawAfterWidgets;
import net.runelite.injector.raw.Occluder;
import net.runelite.injector.raw.RasterizerHook;
import net.runelite.injector.raw.RenderDraw;
import net.runelite.injector.raw.ScriptVM;
import net.runelite.mapping.Import;
import net.runelite.rs.api.RSClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import net.runelite.injector.raw.HidePlayerAttacks;

// import net.runelite.injector.raw.DrawMenu;

public class Inject
{
	public static final java.lang.Class<?> CLIENT_CLASS = RSClient.class;
	public static final String API_PACKAGE_BASE = "net.runelite.rs.api.RS";
	public static final String RL_API_PACKAGE_BASE = "net.runelite.api.";
	private static final Logger logger = LoggerFactory.getLogger(Inject.class);
	private final InjectHookMethod hookMethod = new InjectHookMethod(this);

	private final InjectGetter getters = new InjectGetter(this);
	private final InjectSetter setters = new InjectSetter(this);
	private final InjectInvoker invokes = new InjectInvoker(this);
	private final InjectConstruct construct = new InjectConstruct(this);

	private final MixinInjector mixinInjector = new MixinInjector(this);

	// deobfuscated contains exports etc to apply to vanilla
	private final ClassGroup deobfuscated, vanilla;

	public Inject(ClassGroup deobfuscated, ClassGroup vanilla)
	{
		this.deobfuscated = deobfuscated;
		this.vanilla = vanilla;
	}

	/**
	 * Convert a java.lang.Class to a Type
	 *
	 * @param c
	 * @return
	 */
	public static Type classToType(java.lang.Class<?> c)
	{
		int dimms = 0;
		while (c.isArray())
		{
			c = c.getComponentType();
			++dimms;
		}

		if (c.isPrimitive())
		{
			String s;

			switch (c.getName())
			{
				case "int":
					s = "I";
					break;
				case "long":
					s = "J";
					break;
				case "boolean":
					s = "Z";
					break;
				case "char":
					s = "C";
					break;
				case "short":
					s = "S";
					break;
				case "float":
					s = "F";
					break;
				case "double":
					s = "D";
					break;
				case "byte":
					s = "B";
					break;
				case "void":
					s = "V";
					break;
				default:
					throw new RuntimeException("unknown primitive type " + c.getName());
			}

			return Type.getType(s, dimms);
		}

		return Type.getType("L" + c.getName().replace('.', '/') + ";", dimms);
	}

	public Signature getMethodSignature(Method m)
	{
		Signature signature = m.getDescriptor();

		Annotation obfSignature = m.getAnnotations().find(DeobAnnotations.OBFUSCATED_SIGNATURE);
		if (obfSignature != null)
		{
			//Annotation exists. Signature was updated by us during deobfuscation
			signature = DeobAnnotations.getObfuscatedSignature(m);
		}

		return signature;
	}

	/**
	 * Build a Signature from a java method
	 *
	 * @param method
	 * @return
	 */
	public Signature javaMethodToSignature(java.lang.reflect.Method method)
	{
		Signature.Builder builder = new Signature.Builder()
			.setReturnType(classToType(method.getReturnType()));
		for (java.lang.Class<?> clazz : method.getParameterTypes())
		{
			builder.addArgument(classToType(clazz));
		}
		return builder.build();
	}

	public void run() throws InjectionException
	{
		Map<ClassFile, java.lang.Class> implemented = new HashMap<>();

		// inject interfaces first, so the validateTypeIsConvertibleTo
		// check below works
		for (ClassFile cf : deobfuscated.getClasses())
		{
			Annotations an = cf.getAnnotations();

			if (an == null || an.size() == 0)
			{
				continue;
			}

			String obfuscatedName = DeobAnnotations.getObfuscatedName(an);
			if (obfuscatedName == null)
			{
				obfuscatedName = cf.getName();
			}

			ClassFile other = vanilla.findClass(obfuscatedName);
			assert other != null : "unable to find vanilla class from obfuscated name: " + obfuscatedName;

			java.lang.Class implementingClass = injectInterface(cf, other);
			// it can not implement an interface but still have exported static fields, which are
			// moved to client

			implemented.put(cf, implementingClass);
		}

		// Has to be done before mixins
		// well, can be done after really
		// but why do that when you can do it before
		new RasterizerHook(this).inject();

		// requires interfaces to be injected
		mixinInjector.inject();
		construct.inject(implemented);

		for (ClassFile cf : deobfuscated.getClasses())
		{
			java.lang.Class implementingClass = implemented.get(cf);
			Annotations an = cf.getAnnotations();

			if (an == null || an.size() == 0)
			{
				continue;
			}

			String obfuscatedName = DeobAnnotations.getObfuscatedName(an);
			if (obfuscatedName == null)
			{
				obfuscatedName = cf.getName();
			}

			ClassFile other = vanilla.findClass(obfuscatedName);
			assert other != null : "unable to find vanilla class from obfuscated name: " + obfuscatedName;

			for (Field f : cf.getFields())
			{
				an = f.getAnnotations();

				if (an == null || an.find(DeobAnnotations.EXPORT) == null)
				{
					continue; // not an exported field
				}

				Annotation exportAnnotation = an.find(DeobAnnotations.EXPORT);
				String exportedName = exportAnnotation.getElement().getString();

				obfuscatedName = DeobAnnotations.getObfuscatedName(an);

				Annotation getterAnnotation = an.find(DeobAnnotations.OBFUSCATED_GETTER);
				Number getter = null;
				if (getterAnnotation != null)
				{
					getter = (Number) getterAnnotation.getElement().getValue();
				}
				// the ob jar is the same as the vanilla so this field must exist in this class.

				Type obType = getFieldType(f);
				Field otherf = other.findField(obfuscatedName, obType);
				assert otherf != null;

				assert f.isStatic() == otherf.isStatic();

				ClassFile targetClass = f.isStatic() ? vanilla.findClass("client") : other; // target class for getter
				java.lang.Class targetApiClass = f.isStatic() ? CLIENT_CLASS : implementingClass; // target api class for getter
				if (targetApiClass == null)
				{
					assert !f.isStatic();

					// non static field exported on non exported interface
					//			logger.debug("Non static exported field {} on non exported interface", exportedName);
					continue;
				}

				java.lang.reflect.Method apiMethod = findImportMethodOnApi(targetApiClass, exportedName, true);
				if (apiMethod != null)
				{
					Number setter = null;
					if (getter != null)
					{
						setter = DMath.modInverse(getter); // inverse getter to get the setter
					}

					setters.injectSetter(targetClass, targetApiClass, otherf, exportedName, setter);
				}

				apiMethod = findImportMethodOnApi(targetApiClass, exportedName, false);
				if (apiMethod == null)
				{
					//logger.debug("Unable to find import method on api class {} with imported name {}, not injecting getter", targetApiClass, exportedName);
					continue;
				}

				// check that otherf is converable to apiMethod's
				// return type
				Type fieldType = otherf.getType();
				Type returnType = classToType(apiMethod.getReturnType());
				if (!validateTypeIsConvertibleTo(fieldType, returnType))
				{
					throw new InjectionException("Type " + fieldType + " is not convertable to " + returnType + " for getter " + apiMethod);
				}

				getters.injectGetter(targetClass, apiMethod, otherf, getter);
			}

			for (Method m : cf.getMethods())
			{
				hookMethod.process(m);
				invokes.process(m, other, implementingClass);
			}
		}

		logger.info("Injected {} getters, {} setters, {} invokers",
			getters.getInjectedGetters(),
			setters.getInjectedSetters(), invokes.getInjectedInvokers());

		new DrawAfterWidgets(this).inject();
		new ScriptVM(this).inject();
		new ClearColorBuffer(this).inject();
		new RenderDraw(this).inject();
		// new DrawMenu(this).inject();
		new Occluder(this).inject();
		new HidePlayerAttacks(this).inject();
	}

	private java.lang.Class injectInterface(ClassFile cf, ClassFile other)
	{
		Annotations an = cf.getAnnotations();
		if (an == null)
		{
			return null;
		}

		Annotation a = an.find(DeobAnnotations.IMPLEMENTS);
		if (a == null)
		{
			return null;
		}

		String ifaceName = API_PACKAGE_BASE + a.getElement().getString();
		java.lang.Class<?> apiClass;

		try
		{
			apiClass = java.lang.Class.forName(ifaceName);
		}
		catch (ClassNotFoundException ex)
		{
			logger.trace("Class {} implements nonexistent interface {}, skipping interface injection",
				cf.getName(),
				ifaceName);
			return null;
		}

		String ifaceNameInternal = ifaceName.replace('.', '/'); // to internal name
		Class clazz = new Class(ifaceNameInternal);

		Interfaces interfaces = other.getInterfaces();
		interfaces.addInterface(clazz);

		return apiClass;
	}

	public java.lang.reflect.Method findImportMethodOnApi(java.lang.Class<?> clazz, String name, Boolean setter)
	{
		for (java.lang.reflect.Method method : clazz.getDeclaredMethods())
		{
			if (method.isSynthetic())
			{
				/*
				 * If you override an interface method in another interface
				 * with a return type that is a child of the overriden methods
				 * return type, both methods end up in the interface, and both
				 * are *annotated*. But the base one is synthetic.
				 */
				continue;
			}

			Import i = method.getAnnotation(Import.class);

			if (i == null || !name.equals(i.value()) || (setter != null && (method.getParameterCount() > 0) != setter))
			{
				continue;
			}

			return method;
		}

		return null;
	}

	/**
	 * create a load instruction for a variable of type from a given index
	 *
	 * @param instructions
	 * @param type
	 * @param index
	 * @return
	 */
	public Instruction createLoadForTypeIndex(Instructions instructions, Type type, int index)
	{
		if (type.getDimensions() > 0 || !type.isPrimitive())
		{
			return new ALoad(instructions, index);
		}

		switch (type.toString())
		{
			case "B":
			case "C":
			case "I":
			case "S":
			case "Z":
				return new ILoad(instructions, index);
			case "D":
				return new DLoad(instructions, index);
			case "F":
				return new FLoad(instructions, index);
			case "J":
				return new LLoad(instructions, index);
			default:
				throw new RuntimeException("Unknown type");
		}
	}

	ClassFile toDeobClass(ClassFile obClass)
	{
		for (ClassFile cf : deobfuscated.getClasses())
		{
			String obfuscatedName = DeobAnnotations.getObfuscatedName(cf.getAnnotations());

			if (obClass.getName().equalsIgnoreCase(obfuscatedName))
			{
				return cf;
			}
		}

		return null;
	}

	Type deobfuscatedTypeToApiType(Type type) throws InjectionException
	{
		if (type.isPrimitive())
		{
			return type;
		}

		ClassFile cf = deobfuscated.findClass(type.getInternalName());
		if (cf == null)
		{
			return type; // not my type
		}

		java.lang.Class<?> rsApiType;
		try
		{
			rsApiType = java.lang.Class.forName(API_PACKAGE_BASE + cf.getName().replace("/", "."));
		}
		catch (ClassNotFoundException ex)
		{
			throw new InjectionException("Deobfuscated type " + type.getInternalName() + " has no API type", ex);
		}

		java.lang.Class<?> rlApiType = null;

		for (java.lang.Class<?> inter : rsApiType.getInterfaces())
		{
			if (inter.getName().startsWith(RL_API_PACKAGE_BASE))
			{
				rlApiType = inter;
			}
		}

		//	if (rlApiType == null)
		//	{
		//		throw new InjectionException("RS API type " + rsApiType + " does not extend RL API interface");
		//	}

		final java.lang.Class<?> finalType = rlApiType == null ? rsApiType : rlApiType;

		return Type.getType("L" + finalType.getName().replace('.', '/') + ";", type.getDimensions());
	}

	Type apiTypeToDeobfuscatedType(Type type)
	{
		if (type.isPrimitive())
		{
			return type;
		}

		String internalName = type.getInternalName().replace('/', '.');
		if (!internalName.startsWith(API_PACKAGE_BASE))
		{
			return type; // not an rs api type
		}

		return Type.getType("L" + type.getInternalName().substring(API_PACKAGE_BASE.length()) + ";", type.getDimensions());
	}

	ClassFile findVanillaForInterface(java.lang.Class<?> clazz)
	{
		String className = clazz.getName().replace('.', '/');
		for (ClassFile cf : getVanilla().getClasses())
		{
			for (net.runelite.asm.pool.Class cl : cf.getInterfaces().getInterfaces())
			{
				if (cl.getName().equals(className))
				{
					return cf;
				}
			}
		}
		return null;
	}

	private boolean validateTypeIsConvertibleTo(Type from, Type to) throws InjectionException
	{
		if (from.getDimensions() != to.getDimensions())
		{
			throw new InjectionException("Array dimension mismatch");
		}

		if (from.isPrimitive())
		{
			return true;
		}

		ClassFile vanillaClass = vanilla.findClass(from.getInternalName());
		if (vanillaClass == null)
		{
			return true;
		}

		boolean okay = false;
		for (Class inter : vanillaClass.getInterfaces().getInterfaces())
		{
			java.lang.Class c;

			try
			{
				c = java.lang.Class.forName(inter.getName().replace('/', '.'));
			}
			catch (ClassNotFoundException ex)
			{
				continue;
			}

			okay |= check(c, to);
		}

		return okay;
	}

	private boolean check(java.lang.Class c, Type type)
	{
		String s = type.getInternalName()
			.replace('/', '.');

		if (c.getName().equals(s))
		{
			return true;
		}

		for (java.lang.Class c2 : c.getInterfaces())
		{
			if (check(c2, type))
			{
				return true;
			}
		}
		return false;
	}

	public final ClassGroup getDeobfuscated()
	{
		return deobfuscated;
	}

	public final ClassGroup getVanilla()
	{
		return vanilla;
	}
}
