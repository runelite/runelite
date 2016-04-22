package net.runelite.deob.deobfuscators.mapping;

import java.util.ArrayList;
import java.util.List;
import net.runelite.asm.ClassFile;
import net.runelite.asm.ClassGroup;
import net.runelite.asm.Field;
import net.runelite.asm.Method;
import net.runelite.asm.attributes.Annotations;
import net.runelite.asm.attributes.Attributes;
import net.runelite.asm.signature.Type;

public class AnnotationIntegrityChecker
{
	private static final Type EXPORT = new Type("Lnet/runelite/mapping/Export;");
	
	private ClassGroup one, two;
	private ParallelExecutorMapping mapping;

	public AnnotationIntegrityChecker(ClassGroup one, ClassGroup two, ParallelExecutorMapping mapping)
	{
		this.one = one;
		this.two = two;
		this.mapping = mapping;
	}

	public void run()
	{
		for (ClassFile cf : one.getClasses())
		{
			ClassFile other = (ClassFile) mapping.get(cf);

			List<Field> exf1 = getExportedFields(cf);
			List<Method> exm1 = getExportedMethods(cf);

			for (Field f1 : exf1)
			{
				if (f1.isStatic())
					continue;
				
				Field f2 = findExportedField(other, getExportedName(f1.getAttributes()));

				if (f2 == null)
				{
					System.out.println("Missing exported field on " + other + " named " + getExportedName(f1.getAttributes()));
				}
			}

			for (Method m1 : exm1)
			{
				if (m1.isStatic())
					continue;

				Method m2 = findExportedMethod(other, getExportedName(m1.getAttributes()));

				if (m2 == null)
				{
					System.out.println("Missing exported method on " + other + " named " + getExportedName(m1.getAttributes()));
				}
			}
		}
	}

	private List<Field> getExportedFields(ClassFile clazz)
	{
		List<Field> list = new ArrayList<>();
		for (Field f : clazz.getFields().getFields())
		{
			if (getExportedName(f.getAttributes()) != null)
				list.add(f);
		}
		return list;
	}

	private List<Method> getExportedMethods(ClassFile clazz)
	{
		List<Method> list = new ArrayList<>();
		for (Method m : clazz.getMethods().getMethods())
		{
			if (getExportedName(m.getAttributes()) != null)
				list.add(m);
		}
		return list;
	}

	private String getExportedName(Attributes attr)
	{
		Annotations an = attr.getAnnotations();

		if (an == null || an.find(EXPORT) == null)
		{
			return null;
		}

		return an.find(EXPORT).getElement().getString();
	}

	private Field findExportedField(ClassFile clazz, String name)
	{
		for (Field f : getExportedFields(clazz))
			if (getExportedName(f.getAttributes()).equals(name))
				return f;
		return null;
	}

	private Method findExportedMethod(ClassFile clazz, String name)
	{
		for (Method m : getExportedMethods(clazz))
			if (getExportedName(m.getAttributes()).equals(name))
				return m;
		return null;
	}
}
