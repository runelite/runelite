package net.runelite.deob.clientver;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import org.objectweb.asm.ClassReader;

public class ClientVersion
{
	private File jar;

	public ClientVersion(File jar)
	{
		this.jar = jar;
	}

	public int getVersion() throws IOException
	{
		try (JarFile jar = new JarFile(this.jar))
		{
			for (Enumeration<JarEntry> it = jar.entries(); it.hasMoreElements();)
			{
				JarEntry entry = it.nextElement();

				if (!entry.getName().equals("client.class"))
					continue;

				InputStream in = jar.getInputStream(entry);

				ClassReader reader = new ClassReader(in);
				VersionClassVisitor v = new VersionClassVisitor();
				reader.accept(v, 0);
				return v.getVersion();
			}
		}

		return -1;
	}
}
