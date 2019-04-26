package net.runelite.client.plugins.newraids;

public class timerSpecial
{
	public boolean started = false;
	private long startTime = 0;
	private long difference = 0;
	private long pause = 0;
	private long unpaused = 0;
	private long tempTime = 0;
	private boolean paused = false;

	public void start()
	{
		startTime = System.currentTimeMillis();
		tempTime = startTime;
	}

	public void start(long offset)
	{
		startTime = System.currentTimeMillis() - offset * 1000;
		tempTime = startTime;
		started = true;
	}

	public void pause()
	{
		pause = System.currentTimeMillis();
		tempTime = (System.currentTimeMillis() - startTime) / 1000;
		paused = true;
	}

	public void unpause()
	{
		paused = false;
		unpaused = System.currentTimeMillis();
		difference = unpaused - pause;
		startTime = startTime + difference;
	}

	public void reset()
	{
		startTime = 0;
		difference = 0;
		pause = 0;
		unpaused = 0;
		tempTime = 0;
		paused = false;
		startTime = System.currentTimeMillis();
		tempTime = startTime;
		started = false;
	}

	public long getElapsedTime()
	{
		if (paused)
		{
			return (tempTime);
		}
		return (System.currentTimeMillis() - startTime) / 1000;
		// return (System.currentTimeMillis() - startTime + difference) / 1000; //returns in seconds
	}
}
