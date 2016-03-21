package net.runelite.asm.objectwebasm;

import net.runelite.asm.ClassFile;
import net.runelite.asm.ClassGroup;
import org.objectweb.asm.ClassWriter;

class NonloadingClassWriter extends ClassWriter
{
	private final ClassGroup group;

	public NonloadingClassWriter(ClassGroup group, int flags)
	{
		super(flags);

		this.group = group;
	}

	@Override
	protected String getCommonSuperClass(String type1, String type2)
	{
		ClassFile cf1 = group.findClass(type1),
			cf2 = group.findClass(type2);

		if (cf1 == null && cf2 == null)
		{
			// not mine
			return super.getCommonSuperClass(type1, type2);
		}

		if (cf1 != null && cf2 != null)
		{
			for (ClassFile c = cf1; c != null; c = c.getParent())
				for (ClassFile c2 = cf2; c2 != null; c2 = c2.getParent())
					if (c == c2)
						return c.getName();

			throw new RuntimeException("No common base");
		}

		ClassFile found;
		String other;

		if (cf1 == null)
		{
			found = cf2;
			other = type1;
		}
		else
		{
			assert cf2 == null;
			found = cf1;
			other = type2;
		}

		ClassFile prev = null;

		for (ClassFile c = found; c != null; c = c.getParent())
		{
			prev = c;

			if (c.getName().equals(other))
				return other;
		}

		return super.getCommonSuperClass(prev.getSuperName(), other);
	}
}
