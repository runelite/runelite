package net.runelite.deob.util;

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
				jout.write(bout.toByteArray());
				
				jout.closeEntry();
			}
		}
	}
}
