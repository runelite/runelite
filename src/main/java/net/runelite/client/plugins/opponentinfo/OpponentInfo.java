package net.runelite.client.plugins.opponentinfo;

import java.awt.Graphics;
import net.runelite.api.Actor;
import net.runelite.api.Client;
import net.runelite.api.Player;
import net.runelite.client.RuneLite;
import net.runelite.client.plugins.Plugin;

public class OpponentInfo extends Plugin
{
	private Actor getOpponent()
	{
		Client client = RuneLite.getClient();

		Player player = client.getLocalPlayer();
		if (player == null)
			return null;

		return player.getInteracting();
	}

	public void draw(Graphics graphics)
	{
		Actor opponent = getOpponent();

		if (opponent == null)
			return;

		graphics.drawString(opponent.getName() + " " + opponent.getHealth() + "/" + opponent.getMaxHealth(), 42, 42);
	}
}
