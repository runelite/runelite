/*
 * Copyright (c) 2016, Adam <Adam@sigterm.info>
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 * 1. Redistributions of source code must retain the above copyright
 *    notice, this list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright
 *    notice, this list of conditions and the following disclaimer in the
 *    documentation and/or other materials provided with the distribution.
 * 3. All advertising materials mentioning features or use of this software
 *    must display the following acknowledgement:
 *    This product includes software developed by Adam <Adam@sigterm.info>
 * 4. Neither the name of the Adam <Adam@sigterm.info> nor the
 *    names of its contributors may be used to endorse or promote products
 *    derived from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY Adam <Adam@sigterm.info> ''AS IS'' AND ANY
 * EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL Adam <Adam@sigterm.info> BE LIABLE FOR ANY
 * DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package net.runelite.deob.injection;

import java.io.IOException;
import java.util.List;
import net.runelite.asm.ClassFile;
import net.runelite.asm.ClassGroup;
import net.runelite.asm.Field;
import net.runelite.asm.Interfaces;
import net.runelite.asm.Method;
import net.runelite.asm.attributes.Annotations;
import net.runelite.asm.attributes.Code;
import net.runelite.asm.attributes.annotation.Annotation;
import net.runelite.asm.attributes.annotation.Element;
import net.runelite.asm.attributes.code.Instruction;
import net.runelite.asm.attributes.code.InstructionType;
import net.runelite.asm.attributes.code.Instructions;
import net.runelite.asm.attributes.code.instructions.ALoad;
import net.runelite.asm.attributes.code.instructions.BiPush;
import net.runelite.asm.attributes.code.instructions.DLoad;
import net.runelite.asm.attributes.code.instructions.FLoad;
import net.runelite.asm.attributes.code.instructions.GetField;
import net.runelite.asm.attributes.code.instructions.GetStatic;
import net.runelite.asm.attributes.code.instructions.ILoad;
import net.runelite.asm.attributes.code.instructions.IMul;
import net.runelite.asm.attributes.code.instructions.InvokeStatic;
import net.runelite.asm.attributes.code.instructions.InvokeVirtual;
import net.runelite.asm.attributes.code.instructions.LDC2_W;
import net.runelite.asm.attributes.code.instructions.LDC_W;
import net.runelite.asm.attributes.code.instructions.LLoad;
import net.runelite.asm.attributes.code.instructions.LMul;
import net.runelite.asm.attributes.code.instructions.Return;
import net.runelite.asm.attributes.code.instructions.SiPush;
import net.runelite.asm.pool.Class;
import net.runelite.asm.signature.Signature;
import net.runelite.asm.signature.Type;
import net.runelite.mapping.Import;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Inject
{
	private static final Logger logger = LoggerFactory.getLogger(Inject.class);
	
	private static final Type OBFUSCATED_NAME = new Type("Lnet/runelite/mapping/ObfuscatedName;");
	private static final Type EXPORT = new Type("Lnet/runelite/mapping/Export;");
	private static final Type IMPLEMENTS = new Type("Lnet/runelite/mapping/Implements;");
	private static final Type OBFUSCATED_GETTER = new Type("Lnet/runelite/mapping/ObfuscatedGetter;");
	private static final Type OBFUSCATED_SIGNATURE = new Type("Lnet/runelite/mapping/ObfuscatedSignature;");

	private static final String API_PACKAGE_BASE = "net.runelite.rs.api.";
	
	private static java.lang.Class<?> clientClass;
	
	static
	{
		try
		{
			clientClass = java.lang.Class.forName("net.runelite.rs.api.Client");
		}
		catch (ClassNotFoundException ex)
		{
			ex.printStackTrace();
		}
	}
	
	// deobfuscated contains exports etc to apply to vanilla
	private final ClassGroup deobfuscated, vanilla;

	public Inject(ClassGroup deobfuscated, ClassGroup vanilla)
	{
		this.deobfuscated = deobfuscated;
		this.vanilla = vanilla;
	}
	
	private Type toObType(Type t)
	{
		if (t.isPrimitive())
			return t;

		if (!t.isObfuscatedType() && !t.getType().equals("client"))
			return t;
		
		String className = t.getType();
		className = className.substring(1, className.length() - 1); // remove L ;
		ClassFile cf = deobfuscated.findClass(className);
		assert cf != null;
		
		Annotations an = cf.getAnnotations();
		String obfuscatedName = an.find(OBFUSCATED_NAME).getElement().getString();
		return new Type("L" + obfuscatedName + ";", t.getArrayDims());
	}
	
	private Signature toObSignature(Signature s)
	{
		Signature sig = new Signature();
		sig.setTypeOfReturnValue(toObType(s.getReturnValue()));
		for (Type t : s.getArguments())
			sig.addArg(toObType(t));
		return sig;
	}

	private Type classToType(java.lang.Class<?> c)
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
				default:
					throw new RuntimeException("unknown primitive type");
			}

			return new Type(s, dimms);
		}

		return new Type("L" + c.getName().replace('.', '/') + ";", dimms);
	}
	
	public void run()
	{
		for (ClassFile cf : deobfuscated.getClasses())
		{
			Annotations an = cf.getAnnotations();

			if (an == null || an.size() == 0)
				continue;

			String obfuscatedName = cf.getName();
			Annotation obfuscatedNameAnnotation = an.find(OBFUSCATED_NAME);
			if (obfuscatedNameAnnotation != null)
				obfuscatedName = obfuscatedNameAnnotation.getElement().getString();
			
			ClassFile other = vanilla.findClass(obfuscatedName);
			assert other != null;
			
			java.lang.Class implementingClass = injectInterface(cf, other);
			// it can not implement an interface but still have exported static fields, which are
			// moved to client

			InjectReplace ij = new InjectReplace(cf, other);
			try
			{
				ij.run();
			}
			catch (ClassNotFoundException | IOException ex)
			{
				ex.printStackTrace();
				assert false;
			}
			
			for (Field f : cf.getFields().getFields())
			{
				an = f.getAnnotations();
				
				if (an == null || an.find(EXPORT) == null)
					continue; // not an exported field
				
				String exportedName = an.find(EXPORT).getElement().getString();
				obfuscatedName = an.find(OBFUSCATED_NAME).getElement().getString();
				
				Annotation getterAnnotation = an.find(OBFUSCATED_GETTER);
				Number getter = null;
				if (getterAnnotation != null)
					getter = (Number) getterAnnotation.getElement().getValue();
				
				// the ob jar is the same as the vanilla so this field must exist in this class.

				Type obType = toObType(f.getType());
				Field otherf = other.findField(obfuscatedName, obType);
				assert otherf != null;
				
				assert f.isStatic() == otherf.isStatic();
				
				ClassFile targetClass = f.isStatic() ? vanilla.findClass("client") : other; // target class for getter
				java.lang.Class targetApiClass = f.isStatic() ? clientClass : implementingClass; // target api class for getter
				if (targetApiClass == null)
				{
					assert !f.isStatic();
					System.out.println("Non static exported field " + exportedName + " on non exported interface");
					// non static field exported on non exported interface
					continue;
				}
				
				java.lang.reflect.Method apiMethod = findImportMethodOnApi(targetApiClass, exportedName);
				if (apiMethod == null)
				{
					System.out.println("Unable to find import method on api class " + targetApiClass + " with exported name " + exportedName + ", not injecting getter");
					continue;
				}
				
				injectGetter(targetClass, apiMethod, otherf, getter);
			}
			
			for (Method m : cf.getMethods().getMethods())
			{
				an = m.getAnnotations();
				
				if (an == null || an.find(EXPORT) == null)
					continue; // not an exported method
				
				String exportedName = an.find(EXPORT).getElement().getString();

				Annotation obAn = an.find(OBFUSCATED_NAME);
				if (obAn != null)
					obfuscatedName = obAn.getElement().getString();
				else
					obfuscatedName = m.getName();
				
				Method otherm;

				Annotation obfuscatedSignature = an.find(OBFUSCATED_SIGNATURE);

				String garbage = null;
				if (obfuscatedSignature != null)
				{
					List<Element> elements = obfuscatedSignature.getElements();

					String signatureString = elements.get(0).getString();
					if (elements.size() == 2)
						garbage = obfuscatedSignature.getElements().get(1).getString();

					Signature signature = new Signature(signatureString); // parse signature

					// The obfuscated signature annotation is generated post rename unique, so class
					// names in the signature match our class names and not theirs, so we toObSignature() it
					otherm = other.findMethod(obfuscatedName, toObSignature(signature));
				}
				else
				{
					// No obfuscated signature annotation, so the annotation wasn't changed during deobfuscation.
					// We should be able to just find it normally.
					otherm = other.findMethod(obfuscatedName, toObSignature(m.getDescriptor()));
				}

				assert otherm != null;
				assert m.isStatic() == otherm.isStatic();

				ClassFile targetClass = m.isStatic() ? vanilla.findClass("client") : other;
				java.lang.Class<?> targetClassJava = m.isStatic() ? clientClass : implementingClass;
				
				if (targetClassJava == null)
				{
					assert !m.isStatic();
					System.out.println("Non static exported method " + exportedName + " on non exported interface");
					// non static exported method on non exported interface, weird.
					continue;
				}
				
				java.lang.reflect.Method apiMethod = findImportMethodOnApi(targetClassJava, exportedName); // api method to invoke 'otherm'
				if (apiMethod == null)
				{
					System.out.println("Unable to find api method on " + targetClassJava + " for exported name " + exportedName + ", not injecting invoker");
					continue;
				}

				injectInvoker(targetClass, apiMethod, m, otherm, garbage);
			}
		}
	}
	
	private java.lang.Class injectInterface(ClassFile cf, ClassFile other)
	{
		Annotations an = cf.getAnnotations();
		if (an == null)
			return null;
		
		Annotation a = an.find(IMPLEMENTS);
		if (a == null)
			return null;
		
		String ifaceName = API_PACKAGE_BASE + a.getElement().getString();
		java.lang.Class<?> apiClass;
		
		try
		{
			apiClass = java.lang.Class.forName(ifaceName);
		}
		catch (ClassNotFoundException ex)
		{
			logger.warn("Class {} implements nonexistent interface {}, skipping interface injection",
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

	private java.lang.reflect.Method findImportMethodOnApi(java.lang.Class<?> clazz, String name)
	{
		for (java.lang.reflect.Method method : clazz.getMethods())
		{
			Import i = method.getAnnotation(Import.class);
			
			if (i == null || !name.equals(i.value()))
				continue;
			
			return method;
		}
		
		return null;
	}
	
	private void injectGetter(ClassFile clazz, java.lang.reflect.Method method, Field field, Number getter)
	{
		// clazz = class file we're injecting the method into.
		// method = api method (java reflect) that we're overriding
		// field = field we're getting. might not be in this class if static.
		// getter = encryption getter
		
		assert clazz.findMethod(method.getName()) == null;
		assert field.isStatic() || field.getFields().getClassFile() == clazz;
		
		Signature sig = new Signature();
		sig.setTypeOfReturnValue(classToType(method.getReturnType()));
		Method getterMethod = new Method(clazz.getMethods(), method.getName(), sig);
		getterMethod.setAccessFlags(Method.ACC_PUBLIC);
		
		// create code
		Code code = new Code(getterMethod);
		getterMethod.setCode(code);
		
		Instructions instructions = code.getInstructions();
		List<Instruction> ins = instructions.getInstructions();
		
		if (field.isStatic())
		{
			code.setMaxStack(1);
			
			ins.add(new GetStatic(instructions, field.getPoolField()));
		}
		else
		{
			code.setMaxStack(2);

			ins.add(new ALoad(instructions, 0));
			ins.add(new GetField(instructions, field.getPoolField()));
		}
		
		if (getter != null)
		{
			code.setMaxStack(2);

			assert getter instanceof Integer || getter instanceof Long;
			
			if (getter instanceof Integer)
			{
				ins.add(new LDC_W(instructions, (int) getter));
				ins.add(new IMul(instructions));
			}
			else
			{
				ins.add(new LDC2_W(instructions, (long) getter));
				ins.add(new LMul(instructions));
			}
		}

		InstructionType returnType;
		if (field.getType().isPrimitive() && field.getType().getArrayDims() == 0)
		{
			switch (field.getType().getType())
			{
				case "B":
				case "C":
				case "I":
				case "S":
				case "Z":
					returnType = InstructionType.IRETURN;
					break;
				case "D":
					returnType = InstructionType.DRETURN;
					break;
				case "F":
					returnType = InstructionType.FRETURN;
					break;
				case "J":
					returnType = InstructionType.LRETURN;
					break;
				default:
					throw new RuntimeException("Unknown type");
			}
		}
		else
		{
			returnType = InstructionType.ARETURN;
		}
		
		ins.add(new Return(instructions, returnType));
		
		clazz.getMethods().addMethod(getterMethod);
	}

	private void injectInvoker(ClassFile clazz, java.lang.reflect.Method method, Method deobfuscatedMethod, Method invokeMethod, String garbage)
	{
		// clazz = clazz to add invoker to
		// method = api method to override
		// deobfuscatedMethod = deobfuscated method, used to get the deobfuscated signature
		// invokeMethod = method to invoke, obfuscated

		if (clazz.findMethod(method.getName()) != null)
		{
			return; // hmm. this might be due to an export/import of a non obfuscated method
		}

		assert invokeMethod.isStatic() == deobfuscatedMethod.isStatic();
		assert invokeMethod.isStatic() || invokeMethod.getMethods().getClassFile() == clazz;

		Type lastGarbageArgumentType = null;

		if (!deobfuscatedMethod.getDescriptor().equals(invokeMethod.getDescriptor()))
		{
			// allow for obfuscated method to have a single bogus signature at the end
			assert deobfuscatedMethod.getDescriptor().size() + 1 == invokeMethod.getDescriptor().size();

			List<Type> arguments = invokeMethod.getDescriptor().getArguments();
			lastGarbageArgumentType = arguments.get(arguments.size() - 1);
		}

		Method invokerMethodSignature = new Method(clazz.getMethods(), method.getName(), deobfuscatedMethod.getDescriptor());
		invokerMethodSignature.setAccessFlags(Method.ACC_PUBLIC);

		// create code attribute
		Code code = new Code(invokerMethodSignature);
		invokerMethodSignature.setCode(code);

		Instructions instructions = code.getInstructions();
		List<Instruction> ins = instructions.getInstructions();

		code.setMaxStack(1 + invokeMethod.getDescriptor().size()); // this + arguments

		// load function arguments onto the stack.

		int index = 0;
		if (!invokeMethod.isStatic())
			ins.add(new ALoad(instructions, index++)); // this
		else
			++index; // this method is always non static

		for (int i = 0; i < deobfuscatedMethod.getDescriptor().size(); ++i)
		{
			Type type = deobfuscatedMethod.getDescriptor().getTypeOfArg(i);

			if (type.getArrayDims() > 0 || !type.isPrimitive())
			{
				ins.add(new ALoad(instructions, index++));
			}
			else
			{
				switch (type.getType())
				{
					case "B":
					case "C":
					case "I":
					case "S":
					case "Z":
						ins.add(new ILoad(instructions, index++));
						break;
					case "D":
						ins.add(new DLoad(instructions, index++));
						++index; // takes two slots
						break;
					case "F":
						ins.add(new FLoad(instructions, index++));
						break;
					case "J":
						ins.add(new LLoad(instructions, index++));
						++index;
						break;
					default:
						throw new RuntimeException("Unknown type");
				}
			}
		}

		if (lastGarbageArgumentType != null)
		{
			// function requires garbage value

			// if garbage is null here it might just be an unused parameter, not part of the obfuscation
			if (garbage == null)
				garbage = "0";

			switch (lastGarbageArgumentType.getType())
			{
				case "Z":
				case "B":
				case "C":
					ins.add(new BiPush(instructions, Byte.parseByte(garbage)));
					break;
				case "S":
					ins.add(new SiPush(instructions, Short.parseShort(garbage)));
					break;
				case "I":
					ins.add(new LDC_W(instructions, Integer.parseInt(garbage)));
					break;
				case "D":
					ins.add(new LDC2_W(instructions, Double.parseDouble(garbage)));
					break;
				case "F":
					ins.add(new LDC_W(instructions, Float.parseFloat(garbage)));
					break;
				case "J":
					ins.add(new LDC2_W(instructions, Long.parseLong(garbage)));
					break;
				default:
					throw new RuntimeException("Unknown type");
			}
		}

		if (invokeMethod.isStatic())
			ins.add(new InvokeStatic(instructions, invokeMethod.getPoolMethod()));
		else
			ins.add(new InvokeVirtual(instructions, invokeMethod.getPoolMethod()));

		Type returnValue = invokeMethod.getDescriptor().getReturnValue();
		InstructionType returnType;

		if (returnValue.isPrimitive() && returnValue.getArrayDims() == 0)
		{
			switch (returnValue.getType())
			{
				case "Z":
				case "I":
					returnType = InstructionType.IRETURN;
					break;
				case "J":
					returnType = InstructionType.LRETURN;
					break;
				case "F":
					returnType = InstructionType.FRETURN;
					break;
				case "D":
					returnType = InstructionType.DRETURN;
					break;
				case "V":
					returnType = InstructionType.RETURN;
					break;
				default:
					assert false;
					return;
			}
		}
		else
		{
			returnType = InstructionType.ARETURN;
		}

		ins.add(new Return(instructions, returnType));

		clazz.getMethods().addMethod(invokerMethodSignature);
	}
}
