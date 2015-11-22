package net.runelite.deob.runeloader;

import java.io.File;
import java.io.IOException;
import net.runelite.deob.runeloader.inject.InjectionModscript;
import org.junit.Test;

public class CheckMappings
{
	private static final File CLIENT = new File("/Users/adam/w/rs/07/rs-client-1.0-SNAPSHOT.jar");
	private static final File RL_INJECTION = new File("/Users/adam/w/rs/07/rl/injection.json");
		
	@Test
	public void checkMappings() throws IOException
	{
		InjectionModscript mod = InjectionModscript.load(RL_INJECTION);
	}
}
