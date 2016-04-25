package net.runelite.deob.injection;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.security.SecureClassLoader;
import java.util.HashMap;
import java.util.Map;
import net.runelite.asm.ClassFile;
import net.runelite.asm.ClassGroup;
import net.runelite.asm.objectwebasm.AsmUtils;

public class TestingClassLoader extends SecureClassLoader
{
	private ClassGroup group;
	private Map<String, Class<?> > classes = new HashMap<>();

	public TestingClassLoader(ClassGroup group)
	{
		this.group = group;
	}
	
	@Override
	public Class<?> findClass(String name) throws ClassNotFoundException
	{
		ClassFile cf = group.findClass(name);
		if (cf == null)
			return super.findClass(name);

		Class<?> c = classes.get(name);
		if (c != null)
			return c;

		return defineClass(name, classToBytes(cf));
	}

	private Class<?> defineClass(String name, byte[] b)
	{
		Class<?> c = super.defineClass(name.replace('/', '.'), b, 0, b.length);
		classes.put(name, c);
		return c;
	}

	private byte[] classToBytes(ClassFile cf)
	{
		try
		{
			ByteArrayOutputStream bout = new ByteArrayOutputStream();
			cf.write(new DataOutputStream(bout));

			// run through asm to generate stackmaps
			return AsmUtils.rebuildWithStackmaps(group, new ByteArrayInputStream(bout.toByteArray()));
		}
		catch (IOException ex)
		{
			ex.printStackTrace();
			return null;
		}
	}
}
