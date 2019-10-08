package net.runelite.api.events;

/**
 * Gets sent before menu handling code is ran, once per client tick.
 * Can be consumed, skipping this method this tick.
 */
public class Menu implements Event
{
	public static final Menu MENU = new Menu();

	private Menu()
	{
	}

	private boolean run;

	public void reset()
	{
		run = true;
	}

	public void dontRun()
	{
		run = false;
	}

	public boolean shouldRun()
	{
		return run;
	}
}
