package net.runelite.deob.deobfuscators;

import java.io.File;
import java.io.IOException;
import net.runelite.asm.ClassGroup;
import net.runelite.deob.deobfuscators.arithmetic.ModArith;
import net.runelite.deob.deobfuscators.arithmetic.MultiplicationDeobfuscator;
import net.runelite.deob.deobfuscators.arithmetic.MultiplyOneDeobfuscator;
import net.runelite.deob.deobfuscators.arithmetic.MultiplyZeroDeobfuscator;
import net.runelite.deob.util.JarUtil;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

public class ModArithTest
{
	private static final File GAMEPACK = new File("d:/rs/07/adamin.jar");

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
		ModArith mod = new ModArith();
		mod.run(group);

		int last = -1, cur;
		while ((cur = mod.runOnce()) > 0)
		{
			new MultiplicationDeobfuscator().run(group);

			new MultiplyOneDeobfuscator().run(group);

			new MultiplyZeroDeobfuscator().run(group);

			if (last == cur)
				break;

			last = cur;
		}

		mod.annotateEncryption();
	}
}
