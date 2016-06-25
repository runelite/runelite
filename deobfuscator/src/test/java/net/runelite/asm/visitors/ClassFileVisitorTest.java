package net.runelite.asm.visitors;

import java.io.File;
import net.runelite.asm.ClassGroup;
import net.runelite.deob.TemporyFolderLocation;
import net.runelite.deob.util.JarUtil;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

public class ClassFileVisitorTest
{
	private static final String JAR1 = ClassFileVisitorTest.class.getResource("/gamepack_v16.jar").getFile();

	@Rule
	public TemporaryFolder folder = TemporyFolderLocation.getTemporaryFolder();

	@Test
	public void test() throws Exception
	{
		ClassGroup group = JarUtil.loadJar(new File(JAR1));
		System.out.println(group);
		JarUtil.saveJar(group, folder.newFile());
	}

}
