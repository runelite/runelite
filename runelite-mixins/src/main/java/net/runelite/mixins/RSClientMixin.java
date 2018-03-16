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
package net.runelite.mixins;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;
import net.runelite.api.ChatMessageType;
import net.runelite.api.ClanMember;
import net.runelite.api.GameState;
import net.runelite.api.GrandExchangeOffer;
import net.runelite.api.IndexedSprite;
import net.runelite.api.InventoryID;
import net.runelite.api.MenuAction;
import static net.runelite.api.MenuAction.PLAYER_EIGTH_OPTION;
import static net.runelite.api.MenuAction.PLAYER_FIFTH_OPTION;
import static net.runelite.api.MenuAction.PLAYER_FIRST_OPTION;
import static net.runelite.api.MenuAction.PLAYER_FOURTH_OPTION;
import static net.runelite.api.MenuAction.PLAYER_SECOND_OPTION;
import static net.runelite.api.MenuAction.PLAYER_SEVENTH_OPTION;
import static net.runelite.api.MenuAction.PLAYER_SIXTH_OPTION;
import static net.runelite.api.MenuAction.PLAYER_THIRD_OPTION;
import net.runelite.api.MenuEntry;
import net.runelite.api.NPC;
import net.runelite.api.Node;
import net.runelite.api.Player;
import net.runelite.api.Point;
import net.runelite.api.Prayer;
import net.runelite.api.Projectile;
import net.runelite.api.Setting;
import net.runelite.api.Skill;
import net.runelite.api.SpritePixels;
import net.runelite.api.Varbits;
import net.runelite.api.WidgetNode;
import net.runelite.api.coords.LocalPoint;
import net.runelite.api.events.DraggingWidgetChanged;
import net.runelite.api.events.BoostedLevelChanged;
import net.runelite.api.events.ExperienceChanged;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.GrandExchangeOfferChanged;
import net.runelite.api.events.MapRegionChanged;
import net.runelite.api.events.PlayerMenuOptionsChanged;
import net.runelite.api.events.ResizeableChanged;
import net.runelite.api.events.VarbitChanged;
import net.runelite.api.events.WidgetOpened;
import net.runelite.api.mixins.Copy;
import net.runelite.api.mixins.FieldHook;
import net.runelite.api.mixins.Inject;
import net.runelite.api.mixins.Mixin;
import net.runelite.api.mixins.Replace;
import net.runelite.api.mixins.Shadow;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetInfo;
import static net.runelite.client.callback.Hooks.eventBus;
import net.runelite.rs.api.RSClanMemberManager;
import net.runelite.rs.api.RSClient;
import net.runelite.rs.api.RSDeque;
import net.runelite.rs.api.RSHashTable;
import net.runelite.rs.api.RSIndexedSprite;
import net.runelite.rs.api.RSItemContainer;
import net.runelite.rs.api.RSNPC;
import net.runelite.rs.api.RSName;
import net.runelite.rs.api.RSWidget;

@Mixin(RSClient.class)
public abstract class RSClientMixin implements RSClient
{
	@Shadow("clientInstance")
	private static RSClient client;

	@Inject
	@Override
	public List<Player> getPlayers()
	{
		int validPlayerIndexes = getPlayerIndexesCount();
		int[] playerIndexes = getPlayerIndices();
		Player[] cachedPlayers = getCachedPlayers();
		List<Player> players = new ArrayList<Player>(validPlayerIndexes);

		for (int i = 0; i < validPlayerIndexes; ++i)
		{
			players.add(cachedPlayers[playerIndexes[i]]);
		}

		return players;
	}

	@Inject
	@Override
	public List<NPC> getNpcs()
	{
		int validNpcIndexes = getNpcIndexesCount();
		int[] npcIndexes = getNpcIndices();
		NPC[] cachedNpcs = getCachedNPCs();
		List<NPC> npcs = new ArrayList<NPC>(validNpcIndexes);

		for (int i = 0; i < validNpcIndexes; ++i)
		{
			npcs.add(cachedNpcs[npcIndexes[i]]);
		}

		return npcs;
	}

	@Inject
	@Override
	public int getBoostedSkillLevel(Skill skill)
	{
		int[] boostedLevels = getBoostedSkillLevels();
		return boostedLevels[skill.ordinal()];
	}

	@Inject
	@Override
	public int getRealSkillLevel(Skill skill)
	{
		int[] realLevels = getRealSkillLevels();
		return realLevels[skill.ordinal()];
	}

	@Inject
	@Override
	public void addChatMessage(ChatMessageType type, String name, String message, String sender)
	{
		addChatMessage(type.getType(), name, message, sender);
	}

	@Inject
	@Override
	public GameState getGameState()
	{
		return GameState.of(getRSGameState());
	}

	@Inject
	@Override
	public Point getMouseCanvasPosition()
	{
		return new Point(getMouseX(), getMouseY());
	}

	@Inject
	@Override
	public Widget[] getWidgetRoots()
	{
		int topGroup = getWidgetRoot();
		List<Widget> widgets = new ArrayList<Widget>();
		for (Widget widget : getWidgets()[topGroup])
		{
			if (widget != null && widget.getParentId() == -1)
			{
				widgets.add(widget);
			}
		}
		return widgets.toArray(new Widget[widgets.size()]);
	}

	@Inject
	@Override
	public Widget getWidget(WidgetInfo widget)
	{
		int groupId = widget.getGroupId();
		int childId = widget.getChildId();

		return getWidget(groupId, childId);
	}

	@Inject
	@Override
	public Widget[] getGroup(int groupId)
	{
		RSWidget[][] widgets = getWidgets();

		if (widgets == null || groupId < 0 || groupId >= widgets.length || widgets[groupId] == null)
		{
			return null;
		}

		List<Widget> w = new ArrayList<Widget>();
		for (Widget widget : widgets[groupId])
		{
			if (widget != null)
			{
				w.add(widget);
			}
		}
		return w.toArray(new Widget[w.size()]);
	}

	@Inject
	@Override
	public Widget getWidget(int groupId, int childId)
	{
		RSWidget[][] widgets = getWidgets();

		if (widgets == null || widgets.length <= groupId)
		{
			return null;
		}

		RSWidget[] childWidgets = widgets[groupId];
		if (childWidgets == null || childWidgets.length <= childId)
		{
			return null;
		}

		return childWidgets[childId];
	}

	@Inject
	@Override
	public int getSetting(Setting setting)
	{
		int[] settings = getSettings();
		return settings[setting.getId()];
	}

	@Inject
	@Override
	public boolean isPrayerActive(Prayer prayer)
	{
		return getSetting(prayer.getVarbit()) == 1;
	}

	/**
	 * Returns the local player's current experience in the specified
	 * {@link Skill}.
	 *
	 * @param skill the {@link Skill} to retrieve the experience for
	 * @return the local player's current experience in the specified
	 * {@link Skill}, or -1 if the {@link Skill} isn't valid
	 */
	@Inject
	@Override
	public int getSkillExperience(Skill skill)
	{
		int[] experiences = getSkillExperiences();

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

	@Inject
	@Override
	public void refreshChat()
	{
		setChatCycle(getCycleCntr());
	}

	@Inject
	@Override
	public Widget getViewportWidget()
	{
		if (isResized())
		{
			if (getSetting(Varbits.SIDE_PANELS) == 1)
			{
				return getWidget(WidgetInfo.RESIZABLE_VIEWPORT_BOTTOM_LINE);
			}
			else
			{
				return getWidget(WidgetInfo.RESIZABLE_VIEWPORT_OLD_SCHOOL_BOX);
			}
		}
		return getWidget(WidgetInfo.FIXED_VIEWPORT);
	}

	@Inject
	@Override
	public MenuEntry[] getMenuEntries()
	{
		int count = getMenuOptionCount();
		String[] menuOptions = getMenuOptions();
		String[] menuTargets = getMenuTargets();
		int[] menuIdentifiers = getMenuIdentifiers();
		int[] menuTypes = getMenuTypes();
		int[] params0 = getMenuActionParams0();
		int[] params1 = getMenuActionParams1();

		MenuEntry[] entries = new MenuEntry[count];
		for (int i = 0; i < count; ++i)
		{
			MenuEntry entry = entries[i] = new MenuEntry();
			entry.setOption(menuOptions[i]);
			entry.setTarget(menuTargets[i]);
			entry.setIdentifier(menuIdentifiers[i]);
			entry.setType(MenuAction.of(menuTypes[i]));
			entry.setParam0(params0[i]);
			entry.setParam1(params1[i]);
		}
		return entries;
	}

	@Inject
	@Override
	public void setMenuEntries(MenuEntry[] entries)
	{
		int count = 0;
		String[] menuOptions = getMenuOptions();
		String[] menuTargets = getMenuTargets();
		int[] menuIdentifiers = getMenuIdentifiers();
		int[] menuTypes = getMenuTypes();
		int[] params0 = getMenuActionParams0();
		int[] params1 = getMenuActionParams1();

		for (MenuEntry entry : entries)
		{
			menuOptions[count] = entry.getOption();
			menuTargets[count] = entry.getTarget();
			menuIdentifiers[count] = entry.getIdentifier();
			menuTypes[count] = entry.getType().getId();
			params0[count] = entry.getParam0();
			params1[count] = entry.getParam1();
			++count;
		}

		setMenuOptionCount(count);
	}

	@Inject
	@Override
	public List<Projectile> getProjectiles()
	{
		List<Projectile> projectiles = new ArrayList<Projectile>();
		RSDeque projectileDeque = this.getProjectilesDeque();
		Node head = projectileDeque.getHead();

		for (Node node = head.getNext(); node != head; node = node.getNext())
		{
			projectiles.add((Projectile) node);
		}

		return projectiles;
	}

	@Inject
	@Override
	public void setModIcons(IndexedSprite[] modIcons)
	{
		setRSModIcons((RSIndexedSprite[]) modIcons);
	}

	@Inject
	@Override
	@Nullable
	public LocalPoint getLocalDestinationLocation()
	{
		int regionX = getDestinationX();
		int regionY = getDestinationY();
		if (regionX != 0 && regionY != 0)
		{
			return LocalPoint.fromRegion(regionX, regionY);
		}
		return null;
	}

	@Inject
	@Override
	public boolean getBoundingBoxAlwaysOnMode()
	{
		return getboundingBox3DDrawMode() == getALWAYSDrawMode();
	}

	@Inject
	@Override
	public void setBoundingBoxAlwaysOnMode(boolean alwaysDrawBoxes)
	{
		if (alwaysDrawBoxes)
		{
			setboundingBox3DDrawMode(getALWAYSDrawMode());
		}
		else
		{
			setboundingBox3DDrawMode(getON_MOUSEOVERDrawMode());
		}
	}

	@Inject
	@Override
	public void changeMemoryMode(boolean lowMemory)
	{
		setLowMemory(lowMemory);
		setRegionLowMemory(lowMemory);
		setAudioHighMemory(true);
		setObjectCompositionLowDetail(lowMemory);
	}

	@Inject
	@Override
	public RSItemContainer getItemContainer(InventoryID inventory)
	{
		RSHashTable itemContainers = getItemContainers();
		return (RSItemContainer) itemContainers.get(inventory.getId());
	}

	@Inject
	@Override
	public boolean isFriended(String name, boolean mustBeLoggedIn)
	{
		RSName rsName = createName(name, getLoginType());
		return getFriendManager().isFriended(rsName, mustBeLoggedIn);
	}

	@Inject
	@Override
	public int getClanChatCount()
	{
		final RSClanMemberManager clanMemberManager = getClanMemberManager();
		return clanMemberManager != null ? clanMemberManager.getCount() : 0;
	}

	@Inject
	@Override
	public ClanMember[] getClanMembers()
	{
		final RSClanMemberManager clanMemberManager = getClanMemberManager();
		return clanMemberManager != null ? (ClanMember[]) getClanMemberManager().getNameables() : null;
	}

	@Inject
	@Override
	public boolean isClanMember(String name)
	{
		final RSClanMemberManager clanMemberManager = getClanMemberManager();
		return clanMemberManager != null && clanMemberManager.isMember(createName(name, getLoginType()));
	}

	@FieldHook("draggingWidget")
	@Inject
	public static void draggingWidgetChanged(int idx)
	{
		DraggingWidgetChanged draggingWidgetChanged = new DraggingWidgetChanged();
		draggingWidgetChanged.setDraggingWidget(client.isDraggingWidget());
		eventBus.post(draggingWidgetChanged);
	}

	@Inject
	@Override
	public SpritePixels createItemSprite(int itemId, int quantity, int border, int shadowColor, int stackable, boolean noted, int scale)
	{
		int zoom = get3dZoom();
		set3dZoom(scale);
		try
		{
			return createItemSprite(itemId, quantity, border, shadowColor, stackable, noted);
		}
		finally
		{
			set3dZoom(zoom);
		}
	}

	@Copy("closeWidget")
	public static void rs$closeWidget(WidgetNode widget, boolean b)
	{
		throw new RuntimeException();
	}

	@Replace("closeWidget")
	public static void rl$closeWidget(WidgetNode widget, boolean b)
	{
		MenuEntry[] entries = client.getMenuEntries();
		rs$closeWidget(widget, b);
		client.setMenuEntries(entries);
	}

	@Copy("openWidget")
	public static WidgetNode rs$openWidget(int parentId, int groupId, int autoClose)
	{
		throw new RuntimeException();
	}

	@Replace("openWidget")
	public static WidgetNode rl$openWidget(int parentId, int groupId, int autoClose)
	{
		MenuEntry[] entries = client.getMenuEntries();
		WidgetNode widgetNode = rs$openWidget(parentId, groupId, autoClose);
		client.setMenuEntries(entries);

		WidgetOpened event = new WidgetOpened();
		event.setParentId(parentId);
		event.setGroupId(groupId);
		event.setAutoClose(autoClose);
		eventBus.post(event);
		return widgetNode;
	}

	@FieldHook("skillExperiences")
	@Inject
	public static void experiencedChanged(int idx)
	{
		ExperienceChanged experienceChanged = new ExperienceChanged();
		Skill[] possibleSkills = Skill.values();

		// We subtract one here because 'Overall' isn't considered a skill that's updated.
		if (idx < possibleSkills.length - 1)
		{
			Skill updatedSkill = possibleSkills[idx];
			experienceChanged.setSkill(updatedSkill);
			eventBus.post(experienceChanged);
		}
	}

	@FieldHook("boostedSkillLevels")
	@Inject
	public static void boostedSkillLevelsChanged(int idx)
	{
		Skill[] skills = Skill.values();

		if (idx >= 0 && idx < skills.length - 1)
		{
			Skill updatedSkill = skills[idx];
			BoostedLevelChanged boostedLevelChanged = new BoostedLevelChanged();
			boostedLevelChanged.setSkill(updatedSkill);
			eventBus.post(boostedLevelChanged);
		}
	}

	@FieldHook("mapRegions")
	@Inject
	public static void mapRegionsChanged(int idx)
	{
		MapRegionChanged regionChanged = new MapRegionChanged();
		regionChanged.setIndex(idx);
		eventBus.post(regionChanged);
	}

	@FieldHook("playerOptions")
	@Inject
	public static void playerOptionsChanged(int idx)
	{
		// Reset the menu type
		MenuAction[] playerActions = {PLAYER_FIRST_OPTION, PLAYER_SECOND_OPTION, PLAYER_THIRD_OPTION, PLAYER_FOURTH_OPTION,
			PLAYER_FIFTH_OPTION, PLAYER_SIXTH_OPTION, PLAYER_SEVENTH_OPTION, PLAYER_EIGTH_OPTION};
		if (idx >= 0 && idx < playerActions.length)
		{
			MenuAction playerAction = playerActions[idx];
			client.getPlayerMenuTypes()[idx] = playerAction.getId();
		}

		PlayerMenuOptionsChanged optionsChanged = new PlayerMenuOptionsChanged();
		optionsChanged.setIndex(idx);
		eventBus.post(optionsChanged);
	}

	@FieldHook("gameState")
	@Inject
	public static void gameStateChanged(int idx)
	{
		GameStateChanged gameStateChange = new GameStateChanged();
		gameStateChange.setGameState(client.getGameState());
		eventBus.post(gameStateChange);
	}


	@FieldHook("cachedNPCs")
	@Inject
	public static void cachedNPCsChanged(int idx)
	{
		RSNPC[] cachedNPCs = client.getCachedNPCs();
		if (idx < 0 || idx >= cachedNPCs.length)
		{
			return;
		}

		RSNPC npc = cachedNPCs[idx];
		if (npc != null)
		{
			npc.setIndex(idx);
		}
	}

	@Inject
	@FieldHook("grandExchangeOffers")
	public static void onGrandExchangeOffersChanged(int idx)
	{
		if (idx == -1)
		{
			return;
		}

		GrandExchangeOffer internalOffer = client.getGrandExchangeOffers()[idx];

		if (internalOffer == null)
		{
			return;
		}

		GrandExchangeOfferChanged offerChangedEvent = new GrandExchangeOfferChanged();
		offerChangedEvent.setOffer(internalOffer);
		offerChangedEvent.setSlot(idx);
		eventBus.post(offerChangedEvent);
	}

	@FieldHook("settings")
	@Inject
	public static void settingsChanged(int idx)
	{
		VarbitChanged varbitChanged = new VarbitChanged();
		eventBus.post(varbitChanged);
	}

	@FieldHook("isResized")
	@Inject
	public static void resizeChanged(int idx)
	{
		//maybe couple with varbitChanged. resizeable may not be a varbit but it would fit with the other client settings.
		ResizeableChanged resizeableChanged = new ResizeableChanged();
		resizeableChanged.setResized(client.isResized());
		eventBus.post(resizeableChanged);
	}
}
