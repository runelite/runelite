package net.runelite.client.plugins.wintertodt;

import net.runelite.api.Client;
import net.runelite.api.GameObject;
import net.runelite.api.coords.LocalPoint;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.Perspective;

import java.awt.*;

public class Brazier
{
	private static final int BRAZIER_ATTACK_PARTICLES_ID = 26690; //Id of the particles around the center of a damaging brazier attack

	private WorldPoint attackCenter; //the position the attack sprite of the brazier attack will hit
	private WorldPoint damageCenter; //the center of the 4x4 AOE damage

	private int x;
	private int y;

	public Brazier(WorldPoint attackCenter, WorldPoint damageCenter)
	{
		//The location the snow attack graphics object will spawn at for a south east brazier attack
		this.attackCenter = attackCenter;
		//The center of the snow attacks AOE damage
		this.damageCenter = damageCenter;

		this.x = attackCenter.getX();
		this.y = attackCenter.getY();
	}

	//Is an attack hitting the point a brazier attack hits?
	public boolean isAttackingBrazier(int x, int y)
	{
		return (x == this.x && y == this.y);
	}

	//Returns a polygon that contains the area a player will take damage in from a brazier attack
	public Polygon dangerZone(Client client)
	{
		return Perspective.getCanvasTileAreaPoly(client, LocalPoint.fromWorld(client, this.damageCenter), 4);
	}

	//If a brazier attack will damage the player, additional snow particle objects are spawned around the attack projectile
	public boolean isBrazierAttackDangerous(GameObject[] gameObjects)
	{
		for (int i = 1; i < gameObjects.length; i++)
		{
			GameObject obj = gameObjects[i];
			if (obj.getId() == BRAZIER_ATTACK_PARTICLES_ID)
			{
				WorldPoint gameObjectLoc = obj.getWorldLocation();
				int particleX = gameObjectLoc.getX();
				int particleY = gameObjectLoc.getY();
				//the particles of an attack that will explode a brazier are 1 tile away with no diagonals
				if (particleX == x)
				{
					if (y + 1 == particleY || y - 1 == particleY)
					{
						return true;
					}
				}
				else if (particleY == y)
				{
					if (x + 1 == particleX || x - 1 == particleX)
					{
						return true;
					}
				}
			}
		}
		return false;
	}
}
