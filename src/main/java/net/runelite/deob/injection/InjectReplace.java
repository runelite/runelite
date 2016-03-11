package net.runelite.deob.injection;

import java.io.DataInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import net.runelite.deob.ClassFile;
import net.runelite.deob.Method;
import net.runelite.deob.Methods;
import net.runelite.deob.attributes.Annotations;
import net.runelite.deob.attributes.Attributes;
import net.runelite.deob.attributes.Code;
import net.runelite.deob.attributes.annotation.Annotation;
import net.runelite.deob.attributes.code.Instruction;
import net.runelite.deob.attributes.code.InstructionType;
import net.runelite.deob.attributes.code.Instructions;
import net.runelite.deob.attributes.code.instructions.ALoad;
import net.runelite.deob.attributes.code.instructions.DLoad;
import net.runelite.deob.attributes.code.instructions.FLoad;
import net.runelite.deob.attributes.code.instructions.ILoad;
import net.runelite.deob.attributes.code.instructions.InvokeSpecial;
import net.runelite.deob.attributes.code.instructions.LLoad;
import net.runelite.deob.attributes.code.instructions.New;
import net.runelite.deob.attributes.code.instructions.Return;
import net.runelite.deob.signature.Type;

public class InjectReplace
{
	private static final Type REPLACE = new Type("Lnet/runelite/mapping/Replace;");
	private static final Type OBFUSCATED_OVERRIDE = new Type("Lnet/runelite/mapping/ObfuscatedOverride;");
	private static final Type OBFUSCATED_NAME = new Type("Lnet/runelite/mapping/ObfuscatedName;");

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

		assert classToInject.getParentClass().getName().equals("java/lang/Object");
		assert classToInject.isAbstract();

		// set parent
		classToInject.setParentClass(vanilla.getPoolClass());
		vanilla.clearFinal(); // can't be final anymore now that we inherit from it
		
		injectConstructors(classToInject);

		overideMethods(classToInject);

		// find all classes which inherit from 'vanilla'. replace with classToInject
		replaceSuperclass(classToInject);

		replaceNew(classToInject);
	}
	
	private void injectConstructors(ClassFile classToInject)
	{
		// Delete compiler generate constructors
		Methods methods = classToInject.getMethods();
		Methods vanillaMethods = vanilla.getMethods();

		for (Method m : new ArrayList<>(methods.getMethods()))
			if (m.getName().equals("<init>"))
				methods.removeMethod(m);

		// Add constructors
		for (Method m : vanillaMethods.getMethods())
			if (m.getName().equals("<init>"))
			{
				// create new constructor with same signature
				Method constructor = new Method(methods, "<init>", m.getDescriptor());
				constructor.setAccessFlags(Method.ACC_PUBLIC);

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
			Method obfuscatedMethodToOverride = findMethodByObfuscatedName(overridenMethod);
			
			assert obfuscatedMethodToOverride != null;
			assert !obfuscatedMethodToOverride.isFinal();
			assert !obfuscatedMethodToOverride.isPrivate();

			// Rename method to override
			m.setName(obfuscatedMethodToOverride.getName());

			if (!m.getDescriptor().equals(obfuscatedMethodToOverride.getDescriptor()))
			{
				// Obfuscation can add garbage parameter.
				assert m.getDescriptor().size() + 1 == obfuscatedMethodToOverride.getDescriptor().size();

				// Either we have to modify the bytecode when it is copied over to include this,
				// or maybe can inject overloaded function into superclass if it doesn't cause a signature collision
				assert false;
			}

			// This means method is overriden. It is possible that the return value is a child class
			// of the parents overriden method, and it will still override the method however the signatures won't match,
			// but we don't do that.
			assert m.getDescriptor().equals(obfuscatedMethodToOverride.getDescriptor());

			// Now that the function is overriden, when the invoke injector is called, it turns around and invokevirtuals
			// the parent method, which hits ours.
		}
	}

	private Method findMethodByObfuscatedName(String name)
	{
		for (Method m : cf.getMethods().getMethods())
		{
			Attributes attributes = m.getAttributes();
			Annotations annotations = attributes.getAnnotations();

			if (annotations == null || annotations.find(OBFUSCATED_NAME) == null)
				continue;

			Annotation annotation = annotations.find(OBFUSCATED_NAME);
			String obfuscatedName = annotation.getElement().getString();

			if (name.equals(obfuscatedName))
				return m;
		}

		return null;
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

						net.runelite.deob.pool.Method method = (net.runelite.deob.pool.Method) is.getMethod();
						assert method.getClassEntry().equals(vanilla.getPoolClass());
						assert method.getNameAndType().getName().equals("<init>");

						is.setMethod(
							new net.runelite.deob.pool.Method(
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
						net.runelite.deob.pool.Method method = (net.runelite.deob.pool.Method) is.getMethod();

						is.setMethod(
							new net.runelite.deob.pool.Method(
								classToInject.getPoolClass(),
								method.getNameAndType()
							)
						);
					}
				}
			}
	}
}
