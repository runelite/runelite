package net.runelite.client;

import java.util.logging.Level;
import java.util.logging.Logger;
import net.runelite.launcher.Launchable;

public class Launcher implements Launchable
{
	@Override
	public void run()
	{
		try
		{
			new RuneLite().start();
		}
		catch (Exception ex)
		{
			Logger.getLogger(Launcher.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

}
