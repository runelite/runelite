package net.runelite.deob.deobfuscators.rename;

import java.io.File;
import java.io.IOException;
import net.runelite.asm.ClassGroup;
import net.runelite.deob.updater.UpdateMappings;
import net.runelite.deob.util.JarUtil;
import org.junit.Test;

public class AnnotationMapperTest
{
	private static final String JAR1 = "C:\\Users\\Adam\\.m2\\repository\\net\\runelite\\rs\\rs-client\\1.0-SNAPSHOT\\rs-client-1.0-SNAPSHOT.jar",
		JAR2 = "d:/rs/07/gamepack_v21_deobfuscated.jar",
		OUT = "d:/rs/07/adamout.jar";
	
	@Test
	public void testRun() throws IOException
	{
		ClassGroup group1 = JarUtil.loadJar(new File(JAR1));
		ClassGroup group2 = JarUtil.loadJar(new File(JAR2));

		UpdateMappings um = new UpdateMappings(group1, group2);
		um.update();

		um.save(new File(OUT));
	}

}
