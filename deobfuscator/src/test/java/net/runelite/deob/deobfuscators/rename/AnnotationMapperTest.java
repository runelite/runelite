package net.runelite.deob.deobfuscators.rename;

import java.io.File;
import java.io.IOException;
import net.runelite.asm.ClassGroup;
import net.runelite.asm.Method;
import net.runelite.deob.deobfuscators.mapping.AnnotationIntegrityChecker;
import net.runelite.deob.deobfuscators.mapping.AnnotationMapper;
import net.runelite.deob.deobfuscators.mapping.Mapper;
import net.runelite.deob.deobfuscators.mapping.MappingExecutorUtil;
import net.runelite.deob.deobfuscators.mapping.ParallelExecutorMapping;
import static net.runelite.deob.deobfuscators.rename.MapStaticTest.print;
import static net.runelite.deob.deobfuscators.rename.MapStaticTest.summary;
import net.runelite.deob.util.JarUtil;
import org.junit.Test;

public class AnnotationMapperTest
{
	private static final String JAR1 = "C:\\Users\\Adam\\.m2\\repository\\net\\runelite\\rs\\rs-client\\1.0-SNAPSHOT\\rs-client-1.0-SNAPSHOT.jar",
		JAR2 = "d:/rs/07/gamepack_113_deobfuscated.jar",
		OUT = "d:/rs/07/adamout.jar";
	
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

		Method m1 = group1.findClass("class199").findMethod("method3902");
		Method m2 = (Method) mapping.get(m1);

		MappingExecutorUtil.map(m1, m2);

		AnnotationMapper amapper = new AnnotationMapper(group1, group2, mapping);
		amapper.run();

		AnnotationIntegrityChecker aic = new AnnotationIntegrityChecker(group1, group2, mapping);
		aic.run();

		JarUtil.saveJar(group2, new File(OUT));
	}

}
