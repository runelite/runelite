package info.sigterm.deob;

import info.sigterm.deob.execution.Execution;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

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
		
		execute(group);
	}

	private static void execute(ClassGroup group) throws IOException
	{
		ClassFile cf = group.findClass("client");
		Method method = cf.findMethod("init");
		
		Execution e = new Execution(group);
		e.run(cf, method);
	}
}
