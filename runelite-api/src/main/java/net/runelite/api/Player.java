package net.runelite.api;

public class Player extends Actor
{
	private Client client;
	private net.runelite.rs.api.Player player;

	public Player(Client client, net.runelite.rs.api.Player player)
	{
		super(client, player);

		this.player = player;
		this.client = client;
	}

	@Override
	public String getName()
	{
		return player.getName();
	}
}
