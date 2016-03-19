package net.runelite.deob.asm;

import java.io.IOException;
import java.io.InputStream;
import net.runelite.deob.ClassGroup;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassWriter;

public class AsmUtils
{
	public static byte[] rebuildWithStackmaps(ClassGroup group, InputStream is) throws IOException
	{
		// I don't want to write my own stack map builder.

		ClassReader r = new ClassReader(is);
		ClassWriter writer = new NonloadingClassWriter(group, ClassWriter.COMPUTE_FRAMES | ClassWriter.COMPUTE_MAXS);

		r.accept(writer, ClassReader.SKIP_FRAMES);

		return writer.toByteArray();
	}
}
