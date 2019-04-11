package net.runelite.http.api.hiscore;

public abstract class TrackerClient
{
	public abstract void update(String playerName) throws Exception;

	public abstract Datapoint track(String playerName, Datapoint.TimePeriod time) throws Exception;

	public Datapoint track(String playerName) throws Exception
	{
		return track(playerName, Datapoint.TimePeriod.WEEK);
	}

	/**
	 * Releases any resources the tracker may be using.
	 */
	public void release()
	{
	}
}
