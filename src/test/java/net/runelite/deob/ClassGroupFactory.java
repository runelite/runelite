package net.runelite.deob;

import net.runelite.deob.attributes.Attributes;
import net.runelite.deob.attributes.Code;
import net.runelite.deob.signature.Signature;

public class ClassGroupFactory
{
	public static ClassGroup generateGroup()
	{
		ClassGroup group = new ClassGroup();
		
		ClassFile cf = new ClassFile(group);
		cf.setName("test");
		cf.setSuperName("java/lang/Object");
		group.addClass(cf);
		
		Methods methods = cf.getMethods();
		Method method = new Method(methods, "func", new Signature("()V"));
		method.setStatic();
		methods.addMethod(method);
		
		Attributes methodAttributes = method.getAttributes();
		
		Code code = new Code(methodAttributes);
		methodAttributes.addAttribute(code);
		
		return group;
	}
}
