package net.runelite.deob.injection;

import java.io.DataInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import net.runelite.asm.ClassFile;
import net.runelite.asm.Method;
import net.runelite.asm.Methods;
import net.runelite.asm.attributes.Annotations;
import net.runelite.asm.attributes.Attributes;
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
import net.runelite.asm.pool.NameAndType;
import net.runelite.asm.signature.Signature;
import net.runelite.asm.signature.Type;

public class InjectReplace
{
	private static final Type REPLACE = new Type("Lnet/runelite/mapping/Replace;");
	private static final Type OBFUSCATED_OVERRIDE = new Type("Lnet/runelite/mapping/ObfuscatedOverride;");
	private static final Type OBFUSCATED_NAME = new Type("Lnet/runelite/mapping/ObfuscatedName;");
	private static final Type OBFUSCATED_SIGNATURE = new Type("Lnet/runelite/mapping/ObfuscatedSignature;");
	private static final Type EXPORT = new Type("Lnet/runelite/mapping/Export;");

	private ClassFile cf, vanilla;

	public InjectReplace(ClassFile cf, ClassFile vanilla)
	{
		this.cf = cf; // deobfuscated class
		this.vanilla = vanilla; // vanilla class
	}

	public void run() throws ClassNotFoundException, IOException
	{
		Annotations an = cf.getAttributes().getAnnotations();
		if (an == null)
			return;

		Annotation a = an.find(REPLACE);
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
		try (DataInputStream dis = new DataInputStream(c.getClassLoader().getResourceAsStream(c.getName().replace('.', '/') + ".class")))
		{
			classToInject = new ClassFile(vanilla.getGroup(), dis);
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
					net.runelite.asm.pool.Method method = (net.runelite.asm.pool.Method) is.getMethod();
					assert method.getNameAndType().getDescriptor().size() == 0; // Replace classes must extend Object so this must be Object.init()

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

				Attributes methodAttributes = constructor.getAttributes();

				// create code attribute
				Code code = new Code(methodAttributes);
				methodAttributes.addAttribute(code);

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
			Attributes attributes = m.getAttributes();
			Annotations annotations = attributes.getAnnotations();

			if (annotations == null || annotations.find(OBFUSCATED_OVERRIDE) == null)
				continue;

			Annotation annotation = annotations.find(OBFUSCATED_OVERRIDE);
			String overridenMethod = annotation.getElement().getString(); // name of @Exported method to override

			// Find method with exported name on 'cf'
			Method obfuscatedMethodToOverride = findMethodByExportedName(overridenMethod); // this is from the deobfuscated jar
			Method vanillaMethodToOverride = findVanillaMethodFromDeobfuscatedMethod(obfuscatedMethodToOverride);
			NameAndType deobfuscatedNat = m.getNameAndType();
			
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

				m.arguments = vanillaMethodToOverride.getDescriptor(); // is this right?

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

				net.runelite.asm.pool.Method invokedMethod = (net.runelite.asm.pool.Method) is.getMethod();

				if (invokedMethod.getNameAndType().equals(deobfuscatedNat))
				{
					is.setMethod(new net.runelite.asm.pool.Method(
							classToInject.getParentClass(), // invokedMethod.getClassEntry() is probably our dummy class
							m.getNameAndType() // set to obfuscated name
						)
					);
				}
			}
		}
	}

	private Method findMethodByExportedName(String name)
	{
		for (Method m : cf.getMethods().getMethods())
		{
			Attributes attributes = m.getAttributes();
			Annotations annotations = attributes.getAnnotations();

			if (annotations == null || annotations.find(EXPORT) == null)
				continue;

			Annotation annotation = annotations.find(EXPORT);
			String exportedName = annotation.getElement().getString();

			if (name.equals(exportedName))
				return m;
		}

		return null;
	}

	private Method findVanillaMethodFromDeobfuscatedMethod(Method method)
	{
		String name = getObfuscatedName(method);
		Signature sig = getObfuscatedSignature(method);
		return vanilla.findMethod(name, sig);
	}

	private String getObfuscatedName(Method method)
	{
		Annotations an = method.getAttributes().getAnnotations();
		if (an == null)
			return method.getName();

		Annotation a = an.find(OBFUSCATED_NAME);
		if (a == null)
			return method.getName();
		
		return a.getElement().getString();
	}

	private Signature getObfuscatedSignature(Method method)
	{
		Annotations an = method.getAttributes().getAnnotations();
		if (an == null)
		{
			return method.getDescriptor();
		}

		Annotation obSig = an.find(OBFUSCATED_SIGNATURE);
		if (obSig == null)
		{
			return method.getDescriptor();
		}

		return new Signature(obSig.getElement().getString());
	}

	private String getGarbage(Method method)
	{
		Annotations an = method.getAttributes().getAnnotations();
		if (an == null)
		{
			return null;
		}

		Annotation obSig = an.find(OBFUSCATED_SIGNATURE);
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

						net.runelite.asm.pool.Method method = (net.runelite.asm.pool.Method) is.getMethod();
						assert method.getClassEntry().equals(vanilla.getPoolClass());
						assert method.getNameAndType().getName().equals("<init>");

						is.setMethod(new net.runelite.asm.pool.Method(
								classToInject.getPoolClass(),
								method.getNameAndType()
							)
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
						net.runelite.asm.pool.Method method = (net.runelite.asm.pool.Method) is.getMethod();

						if (!method.getNameAndType().getName().equals("<init>") || !method.getClassEntry().equals(vanilla.getPoolClass()))
							continue;

						is.setMethod(new net.runelite.asm.pool.Method(
								classToInject.getPoolClass(),
								method.getNameAndType()
							)
						);
					}
				}
			}
		}
	}
}
