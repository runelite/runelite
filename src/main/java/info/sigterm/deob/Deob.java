package info.sigterm.deob;

import info.sigterm.deob.execution.Execution;

import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.jar.JarOutputStream;
import java.util.jar.Manifest;

public class Deob
{
	public static void main(String[] args) throws IOException
	{
		ClassGroup group = new ClassGroup();

		JarFile jar = new JarFile(args[0]);
		for (Enumeration<JarEntry> it = jar.entries(); it.hasMoreElements();)
		{
			JarEntry entry = it.nextElement();

			if (!entry.getName().endsWith(".class"))
				continue;

			InputStream is = jar.getInputStream(entry);
			group.addClass(entry.getName(), new DataInputStream(is));
		}
		jar.close();

		group.buildClassGraph();
		group.buildInstructionGraph();
		group.buildCallGraph();
		
		checkCallGraph(group);
		
		//execute(group);
		
		JarOutputStream jout = new JarOutputStream(new FileOutputStream("d:/rs/07/adamout.jar"), new Manifest());
		
		for (ClassFile cf : group.getClasses())
		{
			JarEntry entry = new JarEntry(cf.getName() + ".class");
			jout.putNextEntry(entry);
			
			ByteArrayOutputStream bout = new ByteArrayOutputStream();
			cf.write(new DataOutputStream(bout));
			jout.write(bout.toByteArray());
			
			jout.closeEntry();
		}
		
		jout.close();
	}

	private static void execute(ClassGroup group) throws IOException
	{
		ClassFile cf = group.findClass("client");
		Method method = cf.findMethod("init");
		
		Execution e = new Execution(group);
		e.run(cf, method);
	}
	
	private static void checkCallGraph(ClassGroup group)
	{
		int i = 0;
		for (ClassFile cf : group.getClasses())
		{
			for (Method m : new ArrayList<>(cf.getMethods().getMethods()))
			{
				/* assume obfuscated names are <= 2 chars */
				if (m.getName().length() > 2)
					continue;
				
				if (!m.isUsed())
				{
					System.out.println(cf.getName() + " " + m.getName());
					cf.getMethods().removeMethod(m);
					++i;
				}
			}
		}
		System.out.println("Removed " + i + " methods");
	}
}
