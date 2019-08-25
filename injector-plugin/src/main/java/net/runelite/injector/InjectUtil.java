package net.runelite.injector;

import net.runelite.asm.ClassFile;
import net.runelite.asm.ClassGroup;
import net.runelite.asm.Field;
import net.runelite.asm.Method;
import net.runelite.asm.Type;
import net.runelite.asm.attributes.annotation.Annotation;
import net.runelite.asm.signature.Signature;
import net.runelite.deob.DeobAnnotations;

public class InjectUtil
{
	public static ClassFile toObClass(final ClassGroup vanilla, final ClassFile deobCf) throws InjectionException
	{
		final String obfuscatedName = DeobAnnotations.getObfuscatedName(deobCf.getAnnotations());
		final ClassFile obCf = vanilla.findClass(obfuscatedName);

		if (obCf == null)
		{
			throw new InjectionException(String.format("ClassFile \"%s\" could not be found.", obfuscatedName));
		}

		return obCf;
	}

	public static Field toObField(final ClassGroup vanilla, final Field field) throws InjectionException
	{
		String obfuscatedClassName = DeobAnnotations.getObfuscatedName(field.getClassFile().getAnnotations());
		String obfuscatedFieldName = DeobAnnotations.getObfuscatedName(field.getAnnotations()); // obfuscated name of field
		Type type = getFieldType(field);

		ClassFile obfuscatedClass = vanilla.findClass(obfuscatedClassName);
		if (obfuscatedClass == null)
		{
			throw new InjectionException(String.format("ClassFile \"%s\" could not be found.", obfuscatedClassName));
		}

		Field obfuscatedField = obfuscatedClass.findFieldDeep(obfuscatedFieldName, type);
		if (obfuscatedField == null)
		{
			throw new InjectionException(String.format("Field \"%s\" could not be found.", obfuscatedFieldName));
		}

		return obfuscatedField;
	}

	public static ClassFile toDeobClass(final ClassFile obCf, final ClassGroup deob) throws InjectionException
	{
		final ClassFile wowThatWasQuick = deob.findObfuscatedName(obCf.getName());
		if (wowThatWasQuick == null)
		{
			throw new InjectionException("It wasn't obfscated enough, or a bit too much. Whatever it was it, wasn't in deob");
		}
		return wowThatWasQuick;
	}

	public static Type getFieldType(final Field f)
	{
		Type type = f.getType();

		Annotation obfSignature = f.getAnnotations().find(DeobAnnotations.OBFUSCATED_SIGNATURE);
		if (obfSignature != null)
		{
			//Annotation exists. Type was updated by us during deobfuscation
			type = DeobAnnotations.getObfuscatedType(f);
		}

		return type;
	}

	/**
	 * Find a static method in ClassGroup group. Check the class with name hint first.
	 * (useful for static methods which are in the class they belong to)
	 */
	public static Method findStaticMethod(final ClassGroup group, final String name, final String hint) throws InjectionException
	{
		final ClassFile cf = group.findClass(hint);

		if (cf == null)
		{
			throw new InjectionException(String.format("ClassFile \"%s\" could not be found.", hint));
		}

		Method m = cf.findStaticMethod(name);

		if (m == null)
		{
			m = group.findStaticMethod(name);
		}

		return m;
	}

	/**
	 * Find a static method in ClassGroup group. Throws exception if not found.
	 */
	public static Method findStaticMethod(final ClassGroup group, final String name) throws InjectionException
	{
		Method m = group.findStaticMethod(name);

		if (m == null)
		{
			throw new InjectionException(String.format("Static method \"%s\" could not be found.", name));
		}

		return m;
	}

	/**
	 * Find a static method in ClassGroup group. Throws exception if not found.
	 */
	public static Method findStaticMethod(final ClassGroup group, final String name, Signature sig) throws InjectionException
	{
		Method m = group.findStaticMethod(name, sig);

		if (m == null)
		{
			throw new InjectionException(String.format("Static method \"%s\" could not be found.", name));
		}

		return m;
	}

	public static Method findMethod(Inject inject, String name) throws InjectionException
	{
		return findMethod(inject, name, null);
	}

	public static Method findMethod(Inject inject, String name, String hint) throws InjectionException
	{
		if (hint != null)
		{
			ClassFile c = inject.getDeobfuscated().findClass(hint);

			if (c == null)
			{
				throw new InjectionException("Class " + hint + " doesn't exist. (check capitalization)");
			}

			Method deob = c.findMethod(name);

			if (deob != null)
			{
				String obfuscatedName = DeobAnnotations.getObfuscatedName(deob.getAnnotations());
				Signature obfuscatedSignature = DeobAnnotations.getObfuscatedSignature(deob);

				ClassFile ob = toObClass(inject.getVanilla(), c);

				return ob.findMethod(obfuscatedName, (obfuscatedSignature != null) ? obfuscatedSignature : deob.getDescriptor());
			}
		}

		for (ClassFile c : inject.getDeobfuscated().getClasses())
		{
			for (Method m : c.getMethods())
			{
				if (!m.getName().equals(name))
				{
					continue;
				}

				String obfuscatedName = DeobAnnotations.getObfuscatedName(m.getAnnotations());
				Signature obfuscatedSignature = DeobAnnotations.getObfuscatedSignature(m);

				ClassFile c2 = toObClass(inject.getVanilla(), c);

				return c2.findMethod(obfuscatedName, (obfuscatedSignature != null) ? obfuscatedSignature : m.getDescriptor());
			}
		}

		throw new InjectionException("Couldn't find method " + name);
	}

	public static Method findStaticMethod(Inject inject, String name) throws InjectionException
	{
		for (ClassFile c : inject.getDeobfuscated().getClasses())
		{
			for (Method m : c.getMethods())
			{
				if (!m.isStatic() || !m.getName().equals(name))
				{
					continue;
				}

				String obfuscatedName = DeobAnnotations.getObfuscatedName(m.getAnnotations());
				Signature obfuscatedSignature = DeobAnnotations.getObfuscatedSignature(m);

				ClassFile c2 = toObClass(inject.getVanilla(), c);

				return c2.findMethod(obfuscatedName, (obfuscatedSignature != null) ? obfuscatedSignature : m.getDescriptor());
			}
		}

		throw new InjectionException("Couldn't find static method " + name);
	}


	public static Field findObField(Inject inject, String name) throws InjectionException
	{
		for (ClassFile c : inject.getVanilla().getClasses())
		{
			for (Field f : c.getFields())
			{
				if (!f.getName().equals(name))
				{
					continue;
				}
				return f;
			}
		}

		throw new InjectionException(String.format("Field \"%s\" could not be found.", name));
	}

	public static Field findDeobField(Inject inject, String name) throws InjectionException
	{
		return findDeobField(inject, name, null);
	}

	public static Field findDeobField(Inject inject, String name, String hint) throws InjectionException
	{
		if (hint != null)
		{
			ClassFile c = inject.getDeobfuscated().findClass(hint);
			if (c == null)
			{
				throw new InjectionException("Class " + hint + " doesn't exist. (check capitalization)");
			}

			for (Field f : c.getFields())
			{
				if (!f.getName().equals(name))
				{
					continue;
				}

				String obfuscatedName = DeobAnnotations.getObfuscatedName(f.getAnnotations());

				ClassFile c2 = toObClass(inject.getVanilla(), c);
				return c2.findField(obfuscatedName);
			}
		}

		for (ClassFile c : inject.getDeobfuscated().getClasses())
		{
			for (Field f : c.getFields())
			{
				if (!f.getName().equals(name))
				{
					continue;
				}

				String obfuscatedName = DeobAnnotations.getObfuscatedName(f.getAnnotations());

				ClassFile c2 = toObClass(inject.getVanilla(), c);
				return c2.findField(obfuscatedName);
			}
		}

		throw new InjectionException(String.format("Mapped field \"%s\" could not be found.", name));
	}

	public static Field findDeobFieldButUseless(Inject inject, String name) throws InjectionException
	{
		for (ClassFile c : inject.getDeobfuscated().getClasses())
		{
			for (Field f : c.getFields())
			{
				if (!f.getName().equals(name))
				{
					continue;
				}

				return f;
			}
		}

		throw new InjectionException(String.format("Mapped field \"%s\" could not be found.", name));
	}
}
