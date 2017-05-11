/*
 * Copyright (c) 2016-2017, Adam <Adam@sigterm.info>
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
package net.runelite.api;

import java.awt.Graphics2D;
import java.awt.Polygon;
import net.runelite.rs.api.CombatInfo1;
import net.runelite.rs.api.CombatInfo2;
import net.runelite.rs.api.CombatInfoList;
import net.runelite.rs.api.CombatInfoListHolder;
import net.runelite.rs.api.Node;

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

	public abstract int getCombatLevel();

	public abstract String getName();

	public Actor getInteracting()
	{
		int i = actor.getInteracting();
		if (i == -1)
		{
			return null;
		}

		if (i < 0x8000)
		{
			return client.getNpc(i);
		}

		i -= 0x8000;
		return client.getPlayer(i);
	}

	public int getHealthRatio()
	{
		CombatInfoList combatInfoList = actor.getCombatInfoList();
		if (combatInfoList != null)
		{
			Node node = combatInfoList.getNode();
			Node next = node.getNext();
			if (next instanceof CombatInfoListHolder)
			{
				CombatInfoListHolder combatInfoListWrapper = (CombatInfoListHolder) next;
				CombatInfoList combatInfoList1 = combatInfoListWrapper.getCombatInfo1();

				Node node2 = combatInfoList1.getNode();
				Node next2 = node2.getNext();
				if (next2 instanceof CombatInfo1)
				{
					CombatInfo1 combatInfo = (CombatInfo1) next2;
					return combatInfo.getHealthRatio();
				}
			}
		}
		return -1;
	}

	public int getHealth()
	{
		CombatInfoList combatInfoList = actor.getCombatInfoList();
		if (combatInfoList != null)
		{
			Node node = combatInfoList.getNode();
			Node next = node.getNext();
			if (next instanceof CombatInfoListHolder)
			{
				CombatInfoListHolder combatInfoListWrapper = (CombatInfoListHolder) next;
				CombatInfo2 cf = combatInfoListWrapper.getCombatInfo2();
				return cf.getHealthScale();
			}
		}
		return -1;
	}

	public Point getLocalLocation()
	{
		return new Point(getX(), getY());
	}

	private int getX()
	{
		return actor.getX();
	}

	private int getY()
	{
		return actor.getY();
	}

	public int getAnimation()
	{
		return actor.getAnimation();
	}

	public int getModelHeight()
	{
		return actor.getModelHeight();
	}

	public Polygon getCanvasTilePoly()
	{
		return Perspective.getCanvasTilePoly(client, getLocalLocation());
	}

	public Point getCanvasTextLocation(Graphics2D graphics, String text, int zOffset)
	{
		return Perspective.getCanvasTextLocation(client, graphics, getLocalLocation(), text, zOffset);
	}

	public Point getMinimapLocation()
	{
		return Perspective.worldToMiniMap(client, getX(), getY());
	}
}
