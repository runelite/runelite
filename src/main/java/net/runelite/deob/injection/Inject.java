package net.runelite.deob.injection;

import java.io.IOException;
import java.util.List;
import net.runelite.asm.ClassFile;
import net.runelite.asm.ClassGroup;
import net.runelite.asm.Field;
import net.runelite.asm.Interfaces;
import net.runelite.asm.Method;
import net.runelite.asm.attributes.Annotations;
import net.runelite.asm.attributes.Attributes;
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
import net.runelite.asm.attributes.code.instructions.InvokeVirtual;
import net.runelite.asm.attributes.code.instructions.LDC2_W;
import net.runelite.asm.attributes.code.instructions.LDC_W;
import net.runelite.asm.attributes.code.instructions.LLoad;
import net.runelite.asm.attributes.code.instructions.LMul;
import net.runelite.asm.attributes.code.instructions.Return;
import net.runelite.asm.attributes.code.instructions.SiPush;
import net.runelite.asm.signature.Type;
import net.runelite.asm.pool.Class;
import net.runelite.asm.pool.NameAndType;
import net.runelite.asm.signature.Signature;
import net.runelite.mapping.Import;

public class Inject
{
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
		
		Annotations an = cf.getAttributes().getAnnotations();
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
			Annotations an = cf.getAttributes().getAnnotations();

			if (an == null)
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
				an = f.getAttributes().getAnnotations();
				
				if (an == null || an.find(EXPORT) == null)
					continue; // not an exported field
				
				String exportedName = an.find(EXPORT).getElement().getString();
				obfuscatedName = an.find(OBFUSCATED_NAME).getElement().getString();
				
				Annotation getterAnnotation = an.find(OBFUSCATED_GETTER);
				Number getter = null;
				if (getterAnnotation != null)
					getter = (Number) getterAnnotation.getElement().getValue().getObject();
				
				// the ob jar is the same as the vanilla so this field must exist in this class.

				Type obType = toObType(f.getType());
				Field otherf = other.findField(new NameAndType(obfuscatedName, obType));
				assert otherf != null;
				
				assert f.isStatic() == otherf.isStatic();
				
				ClassFile targetClass = f.isStatic() ? vanilla.findClass("client") : other; // target class for getter
				java.lang.Class targetApiClass = f.isStatic() ? clientClass : implementingClass; // target api class for getter
				assert targetApiClass != null;
				
				java.lang.reflect.Method apiMethod = findImportMethodOnApi(targetApiClass, exportedName);
				assert apiMethod != null;
				
				injectGetter(targetClass, apiMethod, otherf, getter);
			}

			if (implementingClass == null)
				continue; // can't export methods from non implementing class
			
			for (Method m : cf.getMethods().getMethods())
			{
				an = m.getAttributes().getAnnotations();
				
				if (an == null || an.find(EXPORT) == null)
					continue; // not an exported method

				// XXX static methods can be in any class not just 'other' so the below finding won't work.
				// XXX static methods can also be totally inlined by the obfuscator and thus removed by the dead code remover,
				// so exporting them maybe wouldn't work anyway?
				assert !m.isStatic();
				
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
					otherm = other.findMethod(new NameAndType(obfuscatedName, toObSignature(signature)));
				}
				else
				{
					// No obfuscated signature annotation, so the annotation wasn't changed during deobfuscation.
					// We should be able to just find it normally.
					otherm = other.findMethod(new NameAndType(obfuscatedName, toObSignature(m.getDescriptor())));
				}

				assert otherm != null;

				java.lang.reflect.Method apiMethod = findImportMethodOnApi(implementingClass, exportedName); // api method to invoke 'otherm'
				assert apiMethod != null;

				injectInvoker(other, apiMethod, m, otherm, garbage);
			}
		}
	}
	
	private java.lang.Class injectInterface(ClassFile cf, ClassFile other)
	{
		Annotations an = cf.getAttributes().getAnnotations();
		if (an == null)
			return null;
		
		Annotation a = an.find(IMPLEMENTS);
		if (a == null)
			return null;
		
		String ifaceName = API_PACKAGE_BASE + a.getElement().getString();
		String ifaceNameInternal = ifaceName.replace('.', '/'); // to internal name

		Class clazz = new Class(ifaceNameInternal);
		
		Interfaces interfaces = other.getInterfaces();
		interfaces.addInterface(clazz);
		
		try
		{
			return java.lang.Class.forName(ifaceName);
		}
		catch (ClassNotFoundException ex)
		{
			ex.printStackTrace();
			return null;
		}
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
		
		Attributes methodAttributes = getterMethod.getAttributes();

		// create code attribute
		Code code = new Code(methodAttributes);
		methodAttributes.addAttribute(code);
		
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

		assert !invokeMethod.isStatic();
		assert invokeMethod.getMethods().getClassFile() == clazz;

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

		Attributes methodAttributes = invokerMethodSignature.getAttributes();

		// create code attribute
		Code code = new Code(methodAttributes);
		methodAttributes.addAttribute(code);

		Instructions instructions = code.getInstructions();
		List<Instruction> ins = instructions.getInstructions();

		code.setMaxStack(1 + invokeMethod.getDescriptor().size()); // this + arguments

		// load function arguments onto the stack.

		int index = 0;
		ins.add(new ALoad(instructions, index++)); // this

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
