package net.runelite.client.plugins.lmsperformancetracker;

import lombok.Getter;
import net.runelite.api.Player;

@Getter
//public abstract class Fighter implements Player
public class Fighter
{
	private String name; // username
	private int attackCount; // total number of attacks
	private int successCount; // total number of successful attacks
	private double successRate; // success rate in percentage (0-100)
	private boolean dead; // will be true if the fighter died in the fight
	private boolean currentlyAttacking; // will be true if the player is currently doing an attack animation

//	static Fighter createFromPlayer(Player player)
//	{
//		Fighter fighter = (Fighter)player;
//		fighter.attackCount = 0;
//		fighter.successCount = 0;
//		fighter.successRate = 0;
//		fighter.dead = false;
//		fighter.currentlyAttacking = false;
//		return fighter;
//	}

	public Fighter(String name)
	{
		this.name = name;
		attackCount = 0;
		successCount = 0;
		successRate = 0;
		dead = false;
		currentlyAttacking = false;
	}

	// add an attack to the counters depending if it is successful or not.
	// also update the success rate with the new counts.
	public void addAttack(boolean success)
	{
		attackCount++;
		if (success)
		{
			successCount++;
		}

		updateSuccessRate();
	}

	// this is to be used from the TotalStatsPanel which saves a total of multiple fights.
	public void addAttacks(int success, int total)
	{
		successCount += success;
		attackCount += total;

		updateSuccessRate();
	}

	public void died()
	{
		dead = true;
	}

	// Return a simple string to display the current player's success rate.
	// ex. "42/59 (71%)". The name is not included as it will be in a separate view.
	// Would round to 1 decimal space, but the overlay size is restrictive.
	public String getStatsString()
	{
		return successCount + "/" + attackCount + " (" + Math.round(successRate) + "%)";
	}

	private void updateSuccessRate()
	{
		successRate = (double) successCount / (double) attackCount * 100.0;
	}
}
