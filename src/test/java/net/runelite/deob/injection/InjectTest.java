package net.runelite.deob.injection;

import java.io.File;
import java.io.IOException;
import net.runelite.deob.ClassGroup;
import net.runelite.deob.runeloader.MappingImporter;
import net.runelite.deob.util.JarUtil;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class InjectTest
{
	private static final File DEOBFUSCATED = new File("d:/rs/07/adamin.jar");
	private static final File VANILLA = new File(MappingImporter.class.getResource("/gamepack_v16.jar").getFile());
	private static final File OUT = new File("d:/rs/07/adamout.jar");

	private ClassGroup deob, vanilla;

	@Before
	public void before() throws IOException
	{
		deob = JarUtil.loadJar(DEOBFUSCATED);
		vanilla = JarUtil.loadJar(VANILLA);
	}

	@After
	public void after() throws IOException
	{
		JarUtil.saveJar(vanilla, OUT);
	}

	@Test
	public void testRun()
	{
		Inject instance = new Inject(deob, vanilla);
		instance.run();
	}

}
