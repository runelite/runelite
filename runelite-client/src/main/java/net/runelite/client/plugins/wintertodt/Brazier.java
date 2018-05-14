/*
 * Copyright (c) 2018, EmptySet <https://github.com/OTRD5k>
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *    list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
 * ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package net.runelite.client.plugins.wintertodt;

import net.runelite.api.Client;
import net.runelite.api.GameObject;
import net.runelite.api.ObjectID;
import net.runelite.api.coords.LocalPoint;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.Perspective;
import java.awt.Polygon;

public class Brazier
{
	private static final int BRAZIER_ATTACK_PARTICLES_ID = ObjectID.NULL_26690; //Id of the particles around the center of a damaging brazier attack

	private WorldPoint attackCenter; //the position the attack sprite of the brazier attack will hit
	private WorldPoint damageCenter; //the center of the 4x4 AOE damage

	private int x;
	private int y;

	public Brazier(WorldPoint attackCenter, WorldPoint damageCenter)
	{
		//The location the snow attack graphics object will spawn at for a brazier attack
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
