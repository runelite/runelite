package net.runelite.deob.deobfuscators.arithmetic;

import java.io.File;
import java.io.IOException;
import net.runelite.asm.ClassGroup;
import net.runelite.deob.util.JarUtil;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

public class MultiplyZeroDeobfuscatorTest
{
	private static final File GAMEPACK = new File("d:/rs/07/gamepack_v19.jar");

	@Rule
	public TemporaryFolder folder = new TemporaryFolder();

	private ClassGroup group;

	@Before
	public void before() throws IOException
	{
		group = JarUtil.loadJar(GAMEPACK);
	}

	@After
	public void after() throws IOException
	{
		JarUtil.saveJar(group, folder.newFile());
	}

	@Test
	public void testRun()
	{
		MultiplyZeroDeobfuscator m = new MultiplyZeroDeobfuscator();
		m.run(group);
	}
}
