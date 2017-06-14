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
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.rs.api.ItemComposition;

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

	NPC getNpc(int idx)
	{
		net.runelite.rs.api.NPC npc = client.getCachedNPCs()[idx];
		return npc != null ? new NPC(this, npc) : null;
	}

	public Player[] getPlayers()
	{
		return Arrays.stream(client.getCachedPlayers())
			.map(player -> player != null ? new Player(this, player) : null)
			.toArray(size -> new Player[size]);
	}

	Player getPlayer(int idx)
	{
		net.runelite.rs.api.Player player = client.getCachedPlayers()[idx];
		return player != null ? new Player(this, player) : null;
	}

	@SuppressWarnings("unchecked")
	public <T> T[] runQuery(Query query)
	{
		return (T[]) query.result(this);
	}

	public int getBoostedSkillLevel(Skill skill)
	{
		int[] boostedLevels = client.getBoostedSkillLevels();
		return boostedLevels[skill.ordinal()];
	}

	public int getRealSkillLevel(Skill skill)
	{
		int[] realLevels = client.getRealSkillLevels();
		return realLevels[skill.ordinal()];
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

	public int getViewportHeight()
	{
		return client.getViewportHeight();
	}

	public int getViewportWidth()
	{
		return client.getViewportWidth();
	}

	public int getScale()
	{
		return client.getScale();
	}

	public Point getMouseCanvasPosition()
	{
		return new Point(client.getMouseX(), client.getMouseY());
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

	public ItemComposition getItemDefinition(int id)
	{
		return client.getItemDefinition(id);
	}

	public int getBaseX()
	{
		return client.getBaseX();
	}

	public int getBaseY()
	{
		return client.getBaseY();
	}

	public Widget[][] getWidgets()
	{
		return Arrays.stream(client.getWidgets())
			.map(parent -> parent != null ? Arrays.stream(parent)
			.map(child -> child != null ? new Widget(this, child) : null)
			.toArray(Widget[]::new) : null
			).toArray(Widget[][]::new);
	}

	public Widget getWidget(WidgetInfo widget)
	{
		int groupId = widget.getGroupId();
		int childId = widget.getChildId();

		return getWidget(groupId, childId);
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

	public boolean[] getValidInterfaces()
	{
		return client.getValidInterfaces();
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

	public String[] getMenuTargets()
	{
		return client.getMenuTargets();
	}

	public int getMenuCount()
	{
		return client.getMenuOptionCount();
	}

	public boolean isMenuOpen()
	{
		return client.isMenuOpen();
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

	public int getSetting(Varbits varbit)
	{
		int[] settings = client.getSettings();
		int value = settings[varbit.getIndex()];
		return varbit.get(value);
	}

	public XHashTable getComponentTable()
	{
		return new XHashTable(client.getComponentTable());
	}

	public int[] getSettings()
	{
		return client.getSettings();
	}

	public int[] getWidgetSettings()
	{
		return client.getWidgetSettings();
	}

	public boolean isPrayerActive(Prayer prayer)
	{
		return getSetting(prayer.getVarbit()) == 1;
	}

	public int getClanChatCount()
	{
		return client.getClanChatCount();
	}

	/**
	 * Returns the local player's current experience in the specified {@link Skill}.
	 *
	 * @param skill the {@link Skill} to retrieve the experience for
	 * @return the local player's current experience in the specified {@link Skill}, or -1 if the {@link Skill} isn't
	 *         valid
	 */
	public int getSkillExperience(Skill skill)
	{
		int[] experiences = client.getSkillExperiences();

		if (skill == Skill.OVERALL)
		{
			int totalExperience = 0;

			for (int experience : experiences)
			{
				totalExperience += experience;
			}

			return totalExperience;
		}

		int idx = skill.ordinal();

		// I'm not certain exactly how needed this is, but if the Skill enum is updated in the future
		// to hold something else that's not reported it'll save us from an ArrayIndexOutOfBoundsException.
		if (idx >= experiences.length)
		{
			return -1;
		}

		return experiences[idx];
	}
}
