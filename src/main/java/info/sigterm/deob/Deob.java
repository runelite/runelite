package info.sigterm.deob;

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
		JarFile jar = new JarFile(args[0]);
		for (Enumeration<JarEntry> it = jar.entries(); it.hasMoreElements();)
		{
			JarEntry entry = it.nextElement();

			if (!entry.getName().endsWith(".class"))
				continue;

			InputStream is = jar.getInputStream(entry);
			ClassFile c = new ClassFile(new DataInputStream(is));
		}
	}
}
