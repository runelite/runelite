package net.runelite.asm;

import java.io.IOException;
import java.io.InputStream;
import net.runelite.asm.objectwebasm.NonloadingClassWriter;
import net.runelite.asm.visitors.ClassFileVisitor;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassWriter;

public class ClassUtil
{
	public static ClassFile loadClass(InputStream in) throws IOException
	{
		ClassReader reader = new ClassReader(in);
		ClassFileVisitor cv = new ClassFileVisitor();

		reader.accept(cv, ClassReader.SKIP_FRAMES);

		return cv.getClassFile();
	}

	public static byte[] saveClass(ClassGroup group, ClassFile cf)
	{
		ClassWriter writer = new NonloadingClassWriter(group, ClassWriter.COMPUTE_FRAMES | ClassWriter.COMPUTE_MAXS);

		cf.accept(writer);

		byte[] data = writer.toByteArray();
		return data;
	}
}
