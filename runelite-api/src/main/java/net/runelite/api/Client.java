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

import java.awt.Canvas;
import java.util.Arrays;
import net.runelite.api.widgets.Widget;

public class Client
{
	private final net.runelite.rs.api.Client client;

	public Client(net.runelite.rs.api.Client client)
	{
		this.client = client;
	}

	public Player getLocalPlayer()
	{
		if (client.getLocalPlayer() == null)
		{
			return null;
		}

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

	public void sendGameMessage(String message)
	{
		client.sendGameMessage(99, "", message);
	}

	public GameState getGameState()
	{
		return GameState.of(client.getGameState());
	}

	public Canvas getCanvas()
	{
		return client.getCanvas();
	}

	public int getFPS()
	{
		return client.getFPS();
	}

	public int getClientHeight()
	{
		return client.getCanvas().getHeight();
	}

	public int getClientWidth()
	{
		return client.getCanvas().getWidth();
	}

	public int getCameraX()
	{
		return client.getCameraX();
	}

	public int getCameraY()
	{
		return client.getCameraY();
	}

	public int getCameraZ()
	{
		return client.getCameraZ();
	}

	public int getCameraPitch()
	{
		return client.getCameraPitch();
	}

	public int getCameraYaw()
	{
		return client.getCameraYaw();
	}

	public int getCamera2()
	{
		return client.getCamera2();
	}

	public int getCamera3()
	{
		return client.getCamera3();
	}

	public int getScale()
	{
		return client.getScale();
	}

	public int[][][] getTileHeights()
	{
		return client.getTileHeights();
	}

	public byte[][][] getTileSettings()
	{
		return client.getTileSettings();
	}

	public int getPlane()
	{
		return client.getPlane();
	}

	public Region getRegion()
	{
		return new Region(this, client.getRegion());
	}

	public int getBaseX()
	{
		return client.getBaseX();
	}

	public int getBaseY()
	{
		return client.getBaseY();
	}


	public Widget getWidget(int groupId, int childId)
	{
		net.runelite.rs.api.Widget[][] widgets = client.getWidgets();

		if (widgets == null || widgets.length <= groupId)
		{
			return null;
		}

		net.runelite.rs.api.Widget[] childWidgets = widgets[groupId];
		if (childWidgets == null || childWidgets.length <= childId)
		{
			return null;
		}

		return new Widget(this, childWidgets[childId]);
	}

	public int[] getWidgetPositionsX()
	{
		return client.getWidgetPositionsX();
	}

	public int[] getWidgetPositionsY()
	{
		return client.getWidgetPositionsY();
	}
        
        public String[] getPlayerOptions()
        {
                return client.getPlayerOptions();
        }

        public boolean[] getPlayerOptionsPriorities()
        {
                return client.getPlayerOptionsPriorities();
        }

        public int[] getPlayerMenuType()
        {
                return client.getPlayerMenuTypes();
        }
        
        public String[] getMenuOptions()
        {
                return client.getMenuOptions();
        }

	public int getMapScale()
	{
		return client.getMapScale();
	}

	public int getMapAngle()
	{
		return client.getMapAngle();
	}

	public int getMapOffset()
	{
		return client.getMapOffset();
	}

	public boolean isResized()
	{
		return client.isResized();
	}

	public int getRevision()
	{
		return client.getRevision();
	}

	public int[] getMapRegions()
	{
		return client.getMapRegions();
	}

	public int[][] getXteaKeys()
	{
		return client.getXteaKeys();
	}
}
