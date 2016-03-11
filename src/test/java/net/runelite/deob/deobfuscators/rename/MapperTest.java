package net.runelite.deob.deobfuscators.rename;

import java.io.File;
import java.io.IOException;
import net.runelite.deob.ClassGroup;
import static net.runelite.deob.deobfuscators.rename.MapStaticTest.print;
import static net.runelite.deob.deobfuscators.rename.MapStaticTest.summary;
import net.runelite.deob.util.JarUtil;
import org.junit.Test;

// Compares two deobfuscated versions of the client
public class MapperTest
{
	private static final String JAR1 = "C:\\Users\\Adam\\.m2\\repository\\net\\runelite\\rs\\rs-client\\1.0-SNAPSHOT\\rs-client-1.0-SNAPSHOT.jar",//"d:/rs/07/gamepack_v16_deobbed.jar",
		JAR2 = MapperTest.class.getResource("/gamepack_v16_deobbed.jar").getFile();
//	private static final String JAR1 = MapStaticTest.class.getResource("/adamin1.jar").getFile(),
//		JAR2 = MapStaticTest.class.getResource("/adamin2.jar").getFile();

	@Test
	public void testRun() throws IOException
	{
		ClassGroup group1 = JarUtil.loadJar(new File(JAR1));
		ClassGroup group2 = JarUtil.loadJar(new File(JAR2));

		Mapper mapper = new Mapper(group1, group2);
		mapper.run();
		ParallelExecutorMapping mapping = mapper.getMapping();
		
		summary(mapping, group1);

		String sg1 = print(group1),
			sg2 = print(group2);

		System.out.println("GROUP 1 " + sg1);
		System.out.println("GROUP 2 " + sg2);
	}
}
