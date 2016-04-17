package net.runelite.deob.deobfuscators.rename;

import net.runelite.deob.deobfuscators.mapping.ClassGroupMapper;
import java.io.File;
import java.io.IOException;
import java.util.Map;
import net.runelite.asm.ClassFile;
import net.runelite.asm.ClassGroup;
import net.runelite.deob.util.JarUtil;
import org.junit.Test;

/**
 *
 * @author Adam
 */
public class ClassGroupMapperTest
{
	private static final String JAR1 = "C:\\Users\\Adam\\.m2\\repository\\net\\runelite\\rs\\rs-client\\1.0-SNAPSHOT\\rs-client-1.0-SNAPSHOT.jar",
		JAR2 = "c:/rs/gamepack_v19_postmath.jar",
		OUT = "c:/rs/adamout.jar";
	
	@Test
	public void testRun() throws IOException
	{
		ClassGroup group1 = JarUtil.loadJar(new File(JAR1));
		ClassGroup group2 = JarUtil.loadJar(new File(JAR2));
		
		ClassGroupMapper m = new ClassGroupMapper(group1, group2);
		m.map();
		
		for (ClassFile cf : group1.getClasses())
		{
			ClassFile cf2 = m.get(cf);
			
			System.out.println(cf + " -> " + cf2);
		}
	}
}
