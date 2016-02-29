package net.runelite.deob.deobfuscators.rename;

import net.runelite.deob.ClassFile;
import net.runelite.deob.ClassGroup;
import net.runelite.deob.Field;
import net.runelite.deob.Method;
import net.runelite.deob.attributes.Attributes;
import net.runelite.deob.attributes.annotation.Annotation;
import net.runelite.deob.attributes.annotation.Element;
import net.runelite.deob.signature.Type;

public class AnnotationMapper
{
	private static final Type EXPORT = new Type("Lnet/runelite/mapping/Export;");
	private static final Type IMPLEMENTS = new Type("Lnet/runelite/mapping/Implements;");
	
	private final ClassGroup source, target;
	private final ParallelExecutorMapping mapping;

	public AnnotationMapper(ClassGroup source, ClassGroup target, ParallelExecutorMapping mapping)
	{
		this.source = source;
		this.target = target;
		this.mapping = mapping;
	}

	public void run()
	{
		int count = 0;

		for (ClassFile c : source.getClasses())
		{
			ClassFile other = target.findClass(c.getName());

			if (other == null)
				continue;

			count += run(c, other);
		}

		System.out.println("Copied " + count + " annotations");
	}

	private int run(ClassFile from, ClassFile to)
	{
		int count = 0;

		count += copyAnnotations(from.getAttributes(), to.getAttributes());

		for (Field f : from.getFields().getFields())
		{
			if (!hasCopyableAnnotation(f.getAttributes()))
				continue;

			Field other = (Field) mapping.get(f);
			if (other == null)
			{
				assert false;
			}

			count += copyAnnotations(f.getAttributes(), other.getAttributes());
		}

		for (Method m : to.getMethods().getMethods())
		{
			if (!hasCopyableAnnotation(m.getAttributes()))
				continue;

			Method other = (Method) mapping.get(m);
			if (other == null)
			{
				assert false;
			}

			count += copyAnnotations(m.getAttributes(), other.getAttributes());
		}

		return count;
	}

	private int copyAnnotations(Attributes from, Attributes to)
	{
		int count = 0;

		if (from.getAnnotations() == null)
			return count;
		
		for (Annotation a : from.getAnnotations().getAnnotations())
		{
			if (isCopyable(a))
			{
				assert a.getElements().size() == 1;
				Element e = a.getElements().get(0);

				to.addAnnotation(a.getType(), e.getType().toString(), e.getValue().copy());
				++count;
			}
		}

		return count;
	}

	private boolean hasCopyableAnnotation(Attributes a)
	{
		if (a.getAnnotations() == null)
			return false;

		for (Annotation an : a.getAnnotations().getAnnotations())
			if (isCopyable(an))
				return true;

		return false;
	}

	private boolean isCopyable(Annotation a)
	{
		return a.getType().equals(EXPORT) || a.getType().equals(IMPLEMENTS);
	}
}
