/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.runelite.deob.injection;

import java.io.File;
import java.io.IOException;
import net.runelite.deob.ClassGroup;
import net.runelite.deob.runeloader.MappingImporter;
import net.runelite.deob.util.JarUtil;
import org.junit.Test;

public class InjectTest
{
	private static final File DEOBFUSCATED = new File("d:/rs/07/adamin.jar");
	private static final File VANILLA = new File(MappingImporter.class.getResource("/gamepack_v16.jar").getFile());

	@Test
	public void testRun() throws IOException
	{
		ClassGroup deob = JarUtil.loadJar(DEOBFUSCATED),
			vanilla = JarUtil.loadJar(VANILLA);

		Inject instance = new Inject(deob, vanilla);
		instance.run();
	}

}
