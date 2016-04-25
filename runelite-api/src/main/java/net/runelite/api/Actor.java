package net.runelite.api;

public abstract class Actor extends Renderable
{
	private Client client;
	private net.runelite.rs.api.Actor actor;

	public Actor(Client client, net.runelite.rs.api.Actor actor)
	{
		super(actor);

		this.client = client;
		this.actor = actor;
	}

	public abstract String getName();

	public Actor getInteracting()
	{
		int i = actor.getInteracting();
		if (i == -1)
		{
			return null;
		}

		// logic taken from runeloader.
		if (i < 32767)
		{
			return client.getNpcs()[i];
		}

		// XXX is this correct for i = 32767 ?
		i = i - 32767 - 1;
		return client.getPlayers()[i];
	}

	public int getHealth()
	{
		return actor.getHealth();
	}

	public int getMaxHealth()
	{
		return actor.getMaxHealth();
	}
}
