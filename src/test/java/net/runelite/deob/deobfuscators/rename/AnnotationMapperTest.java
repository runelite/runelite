package net.runelite.deob.deobfuscators.rename;

import java.io.File;
import java.io.IOException;
import net.runelite.deob.ClassGroup;
import net.runelite.deob.util.JarUtil;
import org.junit.Test;

public class AnnotationMapperTest
{
	private static final String JAR1 = "C:\\Users\\Adam\\.m2\\repository\\net\\runelite\\rs\\rs-client\\1.0-SNAPSHOT\\rs-client-1.0-SNAPSHOT.jar",
		JAR2 = "c:/rs/gamepack_v18_deobbed.jar",
		OUT = "c:/rs/adamout.jar";
	
	@Test
	public void testRun() throws IOException
	{
		ClassGroup group1 = JarUtil.loadJar(new File(JAR1));
		ClassGroup group2 = JarUtil.loadJar(new File(JAR2));

		Mapper mapper = new Mapper(group1, group2);
		mapper.run();
		ParallelExecutorMapping mapping = mapper.getMapping();
		
		AnnotationMapper amapper = new AnnotationMapper(group1, group2, mapping);
		amapper.run();
		
		JarUtil.saveJar(group2, new File(OUT));
	}

}
