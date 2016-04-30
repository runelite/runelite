package net.runelite.deob.deobfuscators;

import java.io.File;
import java.io.IOException;
import net.runelite.asm.ClassGroup;
import net.runelite.cache.StoreLocation;
import net.runelite.deob.util.JarUtil;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

public class UnusedParametersTest
{
	private static final File GAMEPACK = new File(RenameUniqueTest.class.getResource("/gamepack_v16.jar").getFile());

	@Rule
	public TemporaryFolder folder = StoreLocation.getTemporaryFolder();

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
		RenameUnique r = new RenameUnique();
		r.run(group);
		r = null;
		System.gc();
		
		RuntimeExceptions re = new RuntimeExceptions();
		re.run(group);
		re = null;
		System.gc();
		
		UnreachedCode uc = new UnreachedCode();
		uc.run(group);
		uc = null;
		System.gc();
		
		UnusedMethods um = new UnusedMethods();
		um.run(group);
		um = null;
		System.gc();
		
		IllegalStateExceptions ise = new IllegalStateExceptions();
		ise.run(group);
		ise = null;
		System.gc();
		
		UnusedParameters cp = new UnusedParameters();
		cp.run(group);
		cp = null;
		System.gc();
	}
}
