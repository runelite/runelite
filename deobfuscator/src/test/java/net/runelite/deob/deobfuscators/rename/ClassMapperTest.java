package net.runelite.deob.deobfuscators.rename;

import net.runelite.deob.deobfuscators.mapping.ClassMapper;
import java.io.File;
import java.io.IOException;
import net.runelite.asm.ClassGroup;
import net.runelite.deob.util.JarUtil;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author Adam
 */
public class ClassMapperTest
{
	private static final String JAR1 = "C:\\Users\\Adam\\.m2\\repository\\net\\runelite\\rs\\rs-client\\1.0-SNAPSHOT\\rs-client-1.0-SNAPSHOT.jar",
		JAR2 = "c:/rs/gamepack_v19_postmath.jar";
	
	@Test
	public void testRun() throws IOException
	{
		ClassGroup group1 = JarUtil.loadJar(new File(JAR1));
		ClassGroup group2 = JarUtil.loadJar(new File(JAR2));
		
		ClassMapper m = new ClassMapper(group1.findClass("class118"), group2.findClass("class119"));
		Assert.assertTrue(m.same());
	}
}
