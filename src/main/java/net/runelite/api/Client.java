package net.runelite.api;

import java.util.Arrays;

public class Client
{
	private net.runelite.rs.api.Client client;

	public Client(net.runelite.rs.api.Client client)
	{
		this.client = client;
	}

	public Player getLocalPlayer()
	{
		if (client.getLocalPlayer() == null)
			return null;
		
		return new Player(this, client.getLocalPlayer());
	}

	public NPC[] getNpcs()
	{
		return Arrays.stream(client.getCachedNPCs())
			.map(npc -> npc != null ? new NPC(this, npc) : null)
			.toArray(size -> new NPC[size]);
	}

	public Player[] getPlayers()
	{
		return Arrays.stream(client.getCachedPlayers())
			.map(player -> player != null ? new Player(this, player) : null)
			.toArray(size -> new Player[size]);
	}

	public int[] getBoostedSkillLevels()
	{
		return client.getBoostedSkillLevels();
	}

	public int[] getRealSkillLevels()
	{
		return client.getRealSkillLevels();
	}

	public int[] getSkillExperiences()
	{
		return client.getSkillExperiences();
	}
}
