package net.runelite.deob.injection;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.runelite.deob.ClassFile;
import net.runelite.deob.ClassGroup;
import net.runelite.deob.Field;
import net.runelite.deob.Interfaces;
import net.runelite.deob.Method;
import net.runelite.deob.attributes.Annotations;
import net.runelite.deob.attributes.Attributes;
import net.runelite.deob.attributes.Code;
import net.runelite.deob.attributes.annotation.Annotation;
import net.runelite.deob.attributes.code.Instruction;
import net.runelite.deob.attributes.code.InstructionType;
import net.runelite.deob.attributes.code.Instructions;
import net.runelite.deob.attributes.code.instructions.ALoad;
import net.runelite.deob.attributes.code.instructions.GetField;
import net.runelite.deob.attributes.code.instructions.GetStatic;
import net.runelite.deob.attributes.code.instructions.IMul;
import net.runelite.deob.attributes.code.instructions.LDC2_W;
import net.runelite.deob.attributes.code.instructions.LDC_W;
import net.runelite.deob.attributes.code.instructions.LMul;
import net.runelite.deob.attributes.code.instructions.Return;
import net.runelite.deob.signature.Type;
import net.runelite.deob.pool.Class;
import net.runelite.deob.pool.NameAndType;
import net.runelite.deob.signature.Signature;
import net.runelite.mapping.Import;

public class Inject
{
	private static final Type OBFUSCATED_NAME = new Type("Lnet/runelite/mapping/ObfuscatedName;");
	private static final Type EXPORT = new Type("Lnet/runelite/mapping/Export;");
	private static final Type IMPLEMENTS = new Type("Lnet/runelite/mapping/Implements;");
	private static final Type OBFUSCATED_GETTER = new Type("Lnet/runelite/mapping/ObfuscatedGetter;");
	
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
	
	public void run()
	{
		for (ClassFile cf : deobfuscated.getClasses())
		{
			Annotations an = cf.getAttributes().getAnnotations();

			String obfuscatedName = cf.getName();
			Annotation obfuscatedNameAnnotation = an.find(OBFUSCATED_NAME);
			if (obfuscatedNameAnnotation != null)
				obfuscatedName = obfuscatedNameAnnotation.getElement().getString();
			
			ClassFile other = vanilla.findClass(obfuscatedName);
			assert other != null;
			
			java.lang.Class implementingClass = injectInterface(cf, other);
			if (implementingClass == null)
				continue;
			
			for (Field f : cf.getFields().getFields())
			{
				an = f.getAttributes().getAnnotations();
				
				if (an.find(EXPORT) == null)
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
				if (otherf == null)
					otherf = other.findField(new NameAndType(obfuscatedName, obType));
				assert otherf != null;
				
				assert f.isStatic() == otherf.isStatic();
				
				//
				
				ClassFile targetClass = f.isStatic() ? vanilla.findClass("client") : other; // target class for getter
				java.lang.Class targetApiClass = f.isStatic() ? clientClass : implementingClass; // target api class for getter
				
				java.lang.reflect.Method apiMethod = findImportMethodOnApi(targetApiClass, exportedName);
				if (apiMethod == null)
				{
					System.out.println("no api method");
					continue;
				}
				
				injectGetter(targetClass, apiMethod, otherf, getter);
			}
			
			for (Method m : cf.getMethods().getMethods())
			{
				an = m.getAttributes().getAnnotations();
				
				if (an == null || an.find(EXPORT) == null)
					continue; // not an exported method
				
				String exportedName = an.find(EXPORT).getElement().getString();
				obfuscatedName = an.find(OBFUSCATED_NAME).getElement().getString();
				
				// XXX static methods don't have to be in the same class, so we should have @ObfuscatedClass or something
				
				Method otherm = other.findMethod(new NameAndType(obfuscatedName, toObSignature(m.getDescriptor())));
				assert otherm != null;
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
		
		String ifaceName = "net.runelite.rs.api." + a.getElement().getString();
		Class clazz = new Class(ifaceName);
		
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
		sig.setTypeOfReturnValue(field.getType());
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
				case "Z":
				case "I":
					returnType = InstructionType.IRETURN;
					break;
				case "J":
					returnType = InstructionType.LRETURN;
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
		
		clazz.getMethods().addMethod(getterMethod);
	}
}
