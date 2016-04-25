package net.runelite.deob;

import net.runelite.asm.ClassFile;
import net.runelite.asm.Methods;
import net.runelite.asm.Fields;
import net.runelite.asm.Method;
import net.runelite.asm.Field;
import net.runelite.asm.ClassGroup;
import net.runelite.asm.attributes.Attributes;
import net.runelite.asm.attributes.Code;
import net.runelite.asm.attributes.code.Instructions;
import net.runelite.asm.attributes.code.instructions.VReturn;
import net.runelite.asm.signature.Signature;
import net.runelite.asm.signature.Type;

public class ClassGroupFactory
{
	private static void addVoidMethod(Methods methods, String name)
	{
		Method method = new Method(methods, name, new Signature("()V"));
		method.setStatic();
		methods.addMethod(method);

		Attributes methodAttributes = method.getAttributes();

		Code code = new Code(methodAttributes);
		methodAttributes.addAttribute(code);

		Instructions ins = code.getInstructions();
		ins.addInstruction(new VReturn(ins));
	}

	public static ClassGroup generateGroup()
	{
		ClassGroup group = new ClassGroup();

		ClassFile cf = new ClassFile(group);
		cf.setName("test");
		cf.setSuperName("java/lang/Object");
		group.addClass(cf);

		Fields fields = cf.getFields();
		Field field = new Field(fields, "field", new Type("I"));
		field.setStatic();
		fields.addField(field);

		Methods methods = cf.getMethods();
		Method method = new Method(methods, "func", new Signature("()V"));
		method.setStatic();
		methods.addMethod(method);

		Attributes methodAttributes = method.getAttributes();

		Code code = new Code(methodAttributes);
		methodAttributes.addAttribute(code);

		{
			method = new Method(methods, "func2", new Signature("(III)V"));
			method.setStatic();
			methods.addMethod(method);

			methodAttributes = method.getAttributes();

			code = new Code(methodAttributes);
			methodAttributes.addAttribute(code);

			Instructions ins = code.getInstructions();
			ins.addInstruction(new VReturn(ins));
		}
		
		addVoidMethod(methods, "void1");
		addVoidMethod(methods, "void2");
		addVoidMethod(methods, "void3");
		addVoidMethod(methods, "void4");

		return group;
	}
}
