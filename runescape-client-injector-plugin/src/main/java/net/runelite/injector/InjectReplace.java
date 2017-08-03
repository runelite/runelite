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

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import net.runelite.asm.ClassFile;
import net.runelite.asm.Method;
import net.runelite.asm.Methods;
import net.runelite.asm.attributes.Annotations;
import net.runelite.asm.attributes.Code;
import net.runelite.asm.attributes.annotation.Annotation;
import net.runelite.asm.attributes.code.Instruction;
import net.runelite.asm.attributes.code.InstructionType;
import net.runelite.asm.attributes.code.Instructions;
import net.runelite.asm.attributes.code.instructions.AConstNull;
import net.runelite.asm.attributes.code.instructions.ALoad;
import net.runelite.asm.attributes.code.instructions.BiPush;
import net.runelite.asm.attributes.code.instructions.DLoad;
import net.runelite.asm.attributes.code.instructions.FLoad;
import net.runelite.asm.attributes.code.instructions.ILoad;
import net.runelite.asm.attributes.code.instructions.InvokeSpecial;
import net.runelite.asm.attributes.code.instructions.InvokeVirtual;
import net.runelite.asm.attributes.code.instructions.LDC2_W;
import net.runelite.asm.attributes.code.instructions.LDC_W;
import net.runelite.asm.attributes.code.instructions.LLoad;
import net.runelite.asm.attributes.code.instructions.New;
import net.runelite.asm.attributes.code.instructions.Pop;
import net.runelite.asm.attributes.code.instructions.Return;
import net.runelite.asm.attributes.code.instructions.SiPush;
import net.runelite.asm.signature.Signature;
import net.runelite.asm.signature.Type;
import net.runelite.asm.visitors.ClassFileVisitor;
import net.runelite.deob.DeobAnnotations;
import org.objectweb.asm.ClassReader;

public class InjectReplace
{
	private ClassFile cf, vanilla;

	public InjectReplace(ClassFile cf, ClassFile vanilla)
	{
		this.cf = cf; // deobfuscated class
		this.vanilla = vanilla; // vanilla class
	}

	public void run() throws ClassNotFoundException, IOException
	{
		Annotations an = cf.getAnnotations();
		if (an == null)
			return;

		Annotation a = an.find(DeobAnnotations.REPLACE);
		if (a == null)
			return;

		// cf = deobfuscated class with @Replace("net.runelite.whatever")

		// generate a new class. make it inherit from 'vanilla'.

		// make all classes which inherit from 'vanilla' instead inherit from the new class
		// and adjust their constructors

		// add constructors to new class
		//   cf must implement an interface from the api?
		//   methods can have @ObfuscatedOverride("name") to be renamed
		//   to override ob'd method.
		// replace all instances of new 'vanilla' with new 'new class'

		Class<?> c = Class.forName(a.getElement().getString());
		ClassFile classToInject;
		try (InputStream is = c.getClassLoader().getResourceAsStream(c.getName().replace('.', '/') + ".class"))
		{
			ClassReader reader = new ClassReader(is);
			ClassFileVisitor cv = new ClassFileVisitor();

			reader.accept(cv, 0);

			classToInject = cv.getClassFile();

			vanilla.getGroup().addClass(classToInject);
		}

		// parent is either java/lang/Object or a dummy class so that invokespecial (super) calls work.
		assert classToInject.isAbstract();

		// set parent
		classToInject.setParentClass(vanilla.getPoolClass());
		vanilla.clearFinal(); // can't be final anymore now that we inherit from it
		classToInject.clearAbstract(); // this is being instantiated now, so is no longer abstract
		
		injectConstructors(classToInject);

		overideMethods(classToInject);

		// find all classes which inherit from 'vanilla'. replace with classToInject
		replaceSuperclass(classToInject);

		replaceNew(classToInject);
	}

	private static final String INITFN = "init";
	
	private void injectConstructors(ClassFile classToInject)
	{
		// Delete compiler generated constructors
		Methods methods = classToInject.getMethods();
		Methods vanillaMethods = vanilla.getMethods();

		boolean seen = false;
		for (Method m : methods.getMethods())
			if (m.getName().equals("<init>"))
			{
				assert seen == false; // only one ctor allowed
				seen = true;

				Code code = m.getCode();
				Instructions instructions = code.getInstructions();

				m.setName(INITFN); // magic

				// replace invokespecial call

				for (Instruction i : instructions.getInstructions())
				{
					if (!(i instanceof InvokeSpecial))
						continue;

					InvokeSpecial is = (InvokeSpecial) i;
					net.runelite.asm.pool.Method method = is.getMethod();
					assert method.getType().size() == 0; // Replace classes must extend Object so this must be Object.init()

					instructions.replace(i, new Pop(instructions)); // pop this

					break;
				}

				m.setPrivate();

				// now we'll just add a call to init in the constructors
			}

		// Add constructors
		for (Method m : vanillaMethods.getMethods())
			if (m.getName().equals("<init>"))
			{
				// create new constructor with same signature
				Method constructor = new Method(methods, "<init>", m.getDescriptor());
				constructor.setAccessFlags(Method.ACC_PUBLIC);

				// ensure vanilla ctor is public too
				m.setAccessFlags(Method.ACC_PUBLIC);

				// create code
				Code code = new Code(constructor);
				constructor.setCode(code);

				Instructions instructions = code.getInstructions();
				List<Instruction> ins = instructions.getInstructions();

				int index = 0;
				ins.add(new ALoad(instructions, index++)); // this

				// push arguments
				for (int i = 0; i < m.getDescriptor().size(); ++i)
				{
					Type type = m.getDescriptor().getTypeOfArg(i);

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

				ins.add(new InvokeSpecial(instructions, m.getPoolMethod()));

				// invoke our init func if it exists
				Method initfn = methods.findMethod(INITFN);
				if (initfn != null)
				{
					ins.add(new ALoad(instructions, 0)); // this
					ins.add(new InvokeVirtual(instructions, initfn.getPoolMethod()));
				}

				ins.add(new Return(instructions, InstructionType.RETURN));

				methods.addMethod(constructor);
			}
	}

	private void overideMethods(ClassFile classToInject)
	{
		// find methods in methods that are supposed to override obfuscated methods, and rename them.
		
		Methods methods = classToInject.getMethods();

		for (Method m : methods.getMethods())
		{
			Annotations annotations = m.getAnnotations();

			if (annotations == null || annotations.find(DeobAnnotations.OBFUSCATED_OVERRIDE) == null)
				continue;

			Annotation annotation = annotations.find(DeobAnnotations.OBFUSCATED_OVERRIDE);
			String overridenMethod = annotation.getElement().getString(); // name of @Exported method to override

			// Find method with exported name on 'cf'
			Method obfuscatedMethodToOverride = findMethodByExportedName(overridenMethod); // this is from the deobfuscated jar
			Method vanillaMethodToOverride = findVanillaMethodFromDeobfuscatedMethod(obfuscatedMethodToOverride);
			String deobfuscatedName = m.getName();
			Signature deobfuscatedSignature = m.getDescriptor();
			
			assert obfuscatedMethodToOverride != null;
			assert vanillaMethodToOverride != null;

			vanillaMethodToOverride.setFinal(false);
			vanillaMethodToOverride.setPublic();
			
			assert !vanillaMethodToOverride.isFinal();
			assert !vanillaMethodToOverride.isPrivate();

			// Rename method to override
			m.setName(vanillaMethodToOverride.getName());

			String garbageValue = null;
			Signature originalSignature = null;
			if (!m.getDescriptor().equals(vanillaMethodToOverride.getDescriptor()))
			{
				// Obfuscation can add garbage parameter.
				assert m.getDescriptor().size() + 1 == vanillaMethodToOverride.getDescriptor().size();

				originalSignature = m.getDescriptor();

				m.setDescriptor(vanillaMethodToOverride.getDescriptor()); // is this right?

				garbageValue = this.getGarbage(obfuscatedMethodToOverride);
			}

			// This means method is overriden. It is possible that the return value is a child class
			// of the parents overriden method, and it will still override the method however the signatures won't match,
			// but we don't do that.
			assert m.getDescriptor().equals(vanillaMethodToOverride.getDescriptor());

			// Now that the function is overriden, when the invoke injector is called, it turns around and invokevirtuals
			// the parent method, which hits ours.

			// locate super.method() calls and modify...
			for (Instruction i : new ArrayList<>(m.getCode().getInstructions().getInstructions()))
			{
				if (!(i instanceof InvokeSpecial))
					continue;

				if (originalSignature != null)
				{
					assert originalSignature.size() + 1 == m.getDescriptor().size();

					Instructions instructions = m.getCode().getInstructions();
					List<Instruction> ins = instructions.getInstructions();
					Type type = m.getDescriptor().getTypeOfArg(m.getDescriptor().size() - 1);
					int offset = ins.indexOf(i);
					
					assert offset != -1;

					// XXX we could maybe just pull the variable off of the lvt here, instead
					// if we know we haven't overwritten it?
					if (type.getArrayDims() > 0 || !type.isPrimitive())
					{
						ins.add(offset, new AConstNull(instructions));
					}
					else
					{
						if (garbageValue == null)
						{
							garbageValue = "0";
						}

						switch (type.getType())
						{
							case "Z":
							case "B":
							case "C":
								ins.add(offset, new BiPush(instructions, Byte.parseByte(garbageValue)));
								break;
							case "S":
								ins.add(offset, new SiPush(instructions, Short.parseShort(garbageValue)));
								break;
							case "I":
								ins.add(offset, new LDC_W(instructions, Integer.parseInt(garbageValue)));
								break;
							case "D":
								ins.add(offset, new LDC2_W(instructions, Double.parseDouble(garbageValue)));
								break;
							case "F":
								ins.add(offset, new LDC_W(instructions, Float.parseFloat(garbageValue)));
								break;
							case "J":
								ins.add(offset, new LDC2_W(instructions, Long.parseLong(garbageValue)));
								break;
							default:
								throw new RuntimeException("Unknown type");
						}
					}
				}

				InvokeSpecial is = (InvokeSpecial) i;

				net.runelite.asm.pool.Method invokedMethod = is.getMethod();

				if (invokedMethod.getName().equals(deobfuscatedName) && invokedMethod.getType().equals(deobfuscatedSignature))
				{
					is.setMethod(new net.runelite.asm.pool.Method(
						classToInject.getParentClass(), // invokedMethod.getClassEntry() is probably our dummy class
						m.getName(), // set to obfuscated name
						m.getDescriptor()
					));
				}
			}
		}
	}

	private Method findMethodByExportedName(String name)
	{
		for (Method m : cf.getMethods().getMethods())
		{
			String exportedName = DeobAnnotations.getExportedName(m.getAnnotations());
			if (name.equals(exportedName))
			{
				return m;
			}
		}

		return null;
	}

	private Method findVanillaMethodFromDeobfuscatedMethod(Method method)
	{
		String name = DeobAnnotations.getObfuscatedName(method.getAnnotations());
		Signature sig = DeobAnnotations.getObfuscatedSignature(method);
		return vanilla.findMethod(name, sig);
	}

	private String getGarbage(Method method)
	{
		Annotations an = method.getAnnotations();
		if (an == null)
		{
			return null;
		}

		Annotation obSig = an.find(DeobAnnotations.OBFUSCATED_SIGNATURE);
		if (obSig == null || obSig.getElements().size() < 2)
		{
			return null;
		}

		return obSig.getElements().get(1).getString();
	}

	private void replaceSuperclass(ClassFile classToInject)
	{
		for (ClassFile cf : vanilla.getGroup().getClasses())
			if (cf.getParentClass().equals(vanilla.getPoolClass()))
			{
				if (cf == classToInject) // of course this inherits from it.
					continue;

				cf.setParentClass(classToInject.getPoolClass());
				
				// adjust constructors
				
				for (Method m : cf.getMethods().getMethods())
				{
					if (!m.getName().equals("<init>"))
						continue;

					Code code = m.getCode();
					Instructions ins = code.getInstructions();

					for (Instruction i : ins.getInstructions())
					{
						if (!(i instanceof InvokeSpecial))
							continue;

						// The super constructor invokespecial will be the first invokespecial instruction encountered
						InvokeSpecial is = (InvokeSpecial) i;

						net.runelite.asm.pool.Method method = is.getMethod();
						assert method.getClazz().equals(vanilla.getPoolClass());
						assert method.getName().equals("<init>");

						is.setMethod(new net.runelite.asm.pool.Method(
							classToInject.getPoolClass(),
							method.getName(),
							method.getType())
						);

						break;
					}
				}
			}
	}

	private void replaceNew(ClassFile classToInject)
	{
		// new vanilla -> new classToInject

		for (ClassFile cf : vanilla.getGroup().getClasses())
		{
			if (cf == classToInject)
				continue;

			for (Method m : cf.getMethods().getMethods())
			{
				Code code = m.getCode();

				if (code == null)
					continue;

				Instructions ins = code.getInstructions();

				boolean seen = false, isConstructor = m.getName().equals("<init>");

				for (Instruction i : ins.getInstructions())
				{
					if (i instanceof New)
					{
						New n = (New) i;

						if (!n.getNewClass().equals(vanilla.getPoolClass()))
							continue;

						n.setNewClass(classToInject.getPoolClass());
					}
					else if (i instanceof InvokeSpecial)
					{
						if (isConstructor)
						{
							if (!seen)
							{
								seen = true;
								continue; // superclass invoke in constructor of class which inherits classToInject
							}
						}

						InvokeSpecial is = (InvokeSpecial) i;
						net.runelite.asm.pool.Method method = is.getMethod();

						if (!method.getName().equals("<init>") || !method.getClazz().equals(vanilla.getPoolClass()))
							continue;

						is.setMethod(new net.runelite.asm.pool.Method(
							classToInject.getPoolClass(),
							method.getName(),
							method.getType())
						);
					}
				}
			}
		}
	}
}
