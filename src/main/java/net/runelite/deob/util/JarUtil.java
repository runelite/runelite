package net.runelite.deob.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.jar.JarOutputStream;
import java.util.jar.Manifest;
import net.runelite.deob.ClassFile;
import net.runelite.deob.ClassGroup;
import net.runelite.deob.asm.AsmUtils;
import org.objectweb.asm.ClassReader;

public class JarUtil
{
	public static ClassGroup loadJar(File jarfile) throws IOException
	{
		ClassGroup group = new ClassGroup();

		try (JarFile jar = new JarFile(jarfile))
		{
			for (Enumeration<JarEntry> it = jar.entries(); it.hasMoreElements();)
			{
				JarEntry entry = it.nextElement();
				
				if (!entry.getName().endsWith(".class"))
					continue;
				
				InputStream is = jar.getInputStream(entry);
				group.addClass(entry.getName(), new DataInputStream(is));
			}
		}
		
		group.initialize();
		
		return group;
	}
	
	public static void saveJar(ClassGroup group, File jarfile) throws IOException
	{
		try (JarOutputStream jout = new JarOutputStream(new FileOutputStream(jarfile), new Manifest()))
		{
			for (ClassFile cf : group.getClasses())
			{
				JarEntry entry = new JarEntry(cf.getName() + ".class");
				jout.putNextEntry(entry);
				
				ByteArrayOutputStream bout = new ByteArrayOutputStream();
				cf.write(new DataOutputStream(bout));

				// run through asm to generate stackmaps
				byte[] b = AsmUtils.rebuildWithStackmaps(group, new ByteArrayInputStream(bout.toByteArray()));

				jout.write(b);
				
				jout.closeEntry();
			}
		}
	}
}
