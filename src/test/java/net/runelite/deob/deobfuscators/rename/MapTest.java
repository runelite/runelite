package net.runelite.deob.deobfuscators.rename;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import net.runelite.asm.ClassFile;
import net.runelite.asm.ClassGroup;
import net.runelite.asm.Field;
import net.runelite.asm.Method;
import net.runelite.asm.signature.Signature;
import static net.runelite.deob.deobfuscators.rename.MapStaticTest.print;
import static net.runelite.deob.deobfuscators.rename.MapStaticTest.summary;
import net.runelite.deob.util.JarUtil;
import org.junit.Test;

public class MapTest
{
	private static final String JAR1 = "C:\\Users\\Adam\\.m2\\repository\\net\\runelite\\rs\\rs-client\\1.0-SNAPSHOT\\rs-client-1.0-SNAPSHOT.jar",
		JAR2 = "d:/rs/07/gamepack_v20_deobfuscated.jar";

	@Test
	public void test2() throws IOException
	{
		ClassGroup group1 = JarUtil.loadJar(new File(JAR1));
		ClassGroup group2 = JarUtil.loadJar(new File(JAR2));

		Method m = group1.findClass("class106").findMethod("method2379");
		Method m2 = group2.findClass("class9").findMethod("method125");

		ParallelExecutorMapping mappings = MappingExecutorUtil.map(m, m2);
		System.out.println(mappings);
		//System.out.println(mappings.get(group1.findClass("class209").findField("field3120")));
	}

	//@Test
	public void test3() throws IOException
	{
		ClassGroup group1 = JarUtil.loadJar(new File(JAR1));
		ClassGroup group2 = JarUtil.loadJar(new File(JAR2));

		Mapper mapper = new Mapper(group1, group2);
		mapper.run();
		ParallelExecutorMapping mapping = mapper.getMapping();

		Method m = group1.findClass("class120").findMethod("method2747");

		System.out.println(m);
		System.out.println(mapping.get(m));
	}

	private List<Method> getMethodsOfSignature(ClassFile cf, Signature signature)
	{
		List<Method> l = new ArrayList<>();
		for (Method m : cf.getMethods().getMethods())
			if (m.getDescriptor().equals(signature) && !m.isStatic() && !m.getName().startsWith("<"))
				l.add(m);
		return l;
	}
}
