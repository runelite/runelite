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

import java.util.HashSet;
import java.util.Set;
import net.runelite.api.ChatMessageType;
import net.runelite.api.ClanMember;
import net.runelite.api.EnumDefinition;
import net.runelite.api.Friend;
import net.runelite.api.GameState;
import net.runelite.api.GrandExchangeOffer;
import net.runelite.api.GraphicsObject;
import net.runelite.api.HashTable;
import net.runelite.api.HintArrowType;
import net.runelite.api.Ignore;
import net.runelite.api.IndexDataBase;
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
import net.runelite.api.MessageNode;
import net.runelite.api.NPC;
import net.runelite.api.Node;
import static net.runelite.api.Perspective.LOCAL_TILE_SIZE;
import net.runelite.api.Player;
import net.runelite.api.Point;
import net.runelite.api.Prayer;
import net.runelite.api.Projectile;
import net.runelite.api.Skill;
import net.runelite.api.Sprite;
import net.runelite.api.Tile;
import net.runelite.api.VarPlayer;
import net.runelite.api.Varbits;
import net.runelite.api.WidgetNode;
import net.runelite.api.WorldType;
import net.runelite.api.coords.LocalPoint;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.events.BoostedLevelChanged;
import net.runelite.api.events.CanvasSizeChanged;
import net.runelite.api.events.ChatMessage;
import net.runelite.api.events.ClanChanged;
import net.runelite.api.events.ClientTick;
import net.runelite.api.events.DraggingWidgetChanged;
import net.runelite.api.events.ExperienceChanged;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.GrandExchangeOfferChanged;
import net.runelite.api.events.MenuEntryAdded;
import net.runelite.api.events.MenuOpened;
import net.runelite.api.events.MenuOptionClicked;
import net.runelite.api.events.MenuShouldLeftClick;
import net.runelite.api.events.NpcSpawned;
import net.runelite.api.events.PlayerDespawned;
import net.runelite.api.events.PlayerMenuOptionsChanged;
import net.runelite.api.events.PlayerSpawned;
import net.runelite.api.events.ResizeableChanged;
import net.runelite.api.events.UsernameChanged;
import net.runelite.api.events.VarbitChanged;
import net.runelite.api.events.WidgetLoaded;
import net.runelite.api.events.WidgetPressed;
import net.runelite.api.hooks.Callbacks;
import net.runelite.api.hooks.DrawCallbacks;
import net.runelite.api.vars.AccountType;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.api.widgets.WidgetItem;
import net.runelite.api.widgets.WidgetType;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.EnumSet;
import java.util.List;
import java.util.Map;
import javax.annotation.Nullable;
import javax.inject.Named;
import net.runelite.api.mixins.Copy;
import net.runelite.api.mixins.FieldHook;
import net.runelite.api.mixins.Inject;
import net.runelite.api.mixins.MethodHook;
import net.runelite.api.mixins.Mixin;
import net.runelite.api.mixins.Replace;
import net.runelite.api.mixins.Shadow;
import net.runelite.rs.api.RSPacketBuffer;
import org.slf4j.Logger;
import net.runelite.rs.api.RSAbstractArchive;
import net.runelite.rs.api.RSChatChannel;
import net.runelite.rs.api.RSClanChat;
import net.runelite.rs.api.RSClient;
import net.runelite.rs.api.RSEnumDefinition;
import net.runelite.rs.api.RSFriendSystem;
import net.runelite.rs.api.RSFriendsList;
import net.runelite.rs.api.RSGroundItem;
import net.runelite.rs.api.RSIgnoreList;
import net.runelite.rs.api.RSIndexedSprite;
import net.runelite.rs.api.RSItemContainer;
import net.runelite.rs.api.RSNPC;
import net.runelite.rs.api.RSNodeDeque;
import net.runelite.rs.api.RSNodeHashTable;
import net.runelite.rs.api.RSPlayer;
import net.runelite.rs.api.RSSprite;
import net.runelite.rs.api.RSUsername;
import net.runelite.rs.api.RSWidget;

@Mixin(RSClient.class)
public abstract class RSClientMixin implements RSClient
{
	@Shadow("client")
	private static RSClient client;

	@Inject
	@javax.inject.Inject
	private Callbacks callbacks;

	@Inject
	private DrawCallbacks drawCallbacks;

	@Inject
	@javax.inject.Inject
	@Named("Core Logger")
	private Logger logger;

	@Inject
	private static int tickCount;

	@Inject
	private static boolean interpolatePlayerAnimations;

	@Inject
	private static boolean interpolateNpcAnimations;

	@Inject
	private static boolean interpolateObjectAnimations;

	@Inject
	private static boolean interpolateWidgetAnimations;

	@Inject
	private static RSPlayer[] oldPlayers = new RSPlayer[2048];

	@Inject
	private static int itemPressedDurationBuffer;

	@Inject
	private static int inventoryDragDelay;

	@Inject
	private static int oldMenuEntryCount;

	@Inject
	private static RSGroundItem lastItemDespawn;

	@Inject
	private boolean gpu;

	@Inject
	private static boolean oldIsResized;

	@Inject
	static int skyboxColor;

	@Inject
	private final Cache<Integer, RSEnumDefinition> enumCache = CacheBuilder.newBuilder()
		.maximumSize(64)
		.build();

	@Inject
	private static boolean printMenuActions;

	@Inject
	@Override
	public void setPrintMenuActions(boolean yes)
	{
		printMenuActions = yes;
	}

	@Inject
	private static boolean hideFriendAttackOptions = false;

	@Inject
	private static boolean hideClanmateAttackOptions = false;

	@Inject
	private static boolean hideFriendCastOptions = false;

	@Inject
	private static boolean hideClanmateCastOptions = false;

	@Inject
	private static Set<String> unhiddenCasts = new HashSet<String>();

	@Inject
	@Override
	public void setHideFriendAttackOptions(boolean yes)
	{
		hideFriendAttackOptions = yes;
	}

	@Inject
	@Override
	public void setHideFriendCastOptions(boolean yes)
	{
		hideFriendCastOptions = yes;
	}

	@Inject
	@Override
	public void setHideClanmateAttackOptions(boolean yes)
	{
		hideClanmateAttackOptions = yes;
	}

	@Inject
	@Override
	public void setHideClanmateCastOptions(boolean yes)
	{
		hideClanmateCastOptions = yes;
	}

	@Inject
	@Override
	public void setUnhiddenCasts(Set<String> casts)
	{
		unhiddenCasts = casts;
	}

	@Inject
	public RSClientMixin()
	{
	}

	@Inject
	@Override
	public Callbacks getCallbacks()
	{
		return callbacks;
	}

	@Inject
	@Override
	public DrawCallbacks getDrawCallbacks()
	{
		return drawCallbacks;
	}

	@Inject
	@Override
	public void setDrawCallbacks(DrawCallbacks drawCallbacks)
	{
		this.drawCallbacks = drawCallbacks;
	}

	@Inject
	@Override
	public Logger getLogger()
	{
		return logger;
	}

	@Inject
	@Override
	public boolean isInterpolatePlayerAnimations()
	{
		return interpolatePlayerAnimations;
	}

	@Inject
	@Override
	public void setInterpolatePlayerAnimations(boolean interpolate)
	{
		interpolatePlayerAnimations = interpolate;
	}

	@Inject
	@Override
	public boolean isInterpolateNpcAnimations()
	{
		return interpolateNpcAnimations;
	}

	@Inject
	@Override
	public void setInterpolateNpcAnimations(boolean interpolate)
	{
		interpolateNpcAnimations = interpolate;
	}

	@Inject
	@Override
	public boolean isInterpolateObjectAnimations()
	{
		return interpolateObjectAnimations;
	}

	@Inject
	@Override
	public void setInterpolateObjectAnimations(boolean interpolate)
	{
		interpolateObjectAnimations = interpolate;
	}

	@Inject
	@Override
	public boolean isInterpolateWidgetAnimations()
	{
		return interpolateWidgetAnimations;
	}

	@Inject
	@Override
	public void setInterpolateWidgetAnimations(boolean interpolate)
	{
		interpolateWidgetAnimations = interpolate;
	}

	@Inject
	@Override
	public void setInventoryDragDelay(int delay)
	{
		inventoryDragDelay = delay;
	}

	@Inject
	@Override
	public AccountType getAccountType()
	{
		int varbit = getVar(Varbits.ACCOUNT_TYPE);

		switch (varbit)
		{
			case 1:
				return AccountType.IRONMAN;
			case 2:
				return AccountType.ULTIMATE_IRONMAN;
			case 3:
				return AccountType.HARDCORE_IRONMAN;
		}

		return AccountType.NORMAL;
	}

	@Inject
	@Override
	public Tile getSelectedSceneTile()
	{
		int tileX = getSelectedSceneTileX();
		int tileY = getSelectedSceneTileY();

		if (tileX == -1 || tileY == -1)
		{
			return null;
		}

		return getScene().getTiles()[getPlane()][tileX][tileY];
	}

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
	public int getTotalLevel()
	{
		int totalLevel = 0;

		int[] realLevels = client.getRealSkillLevels();
		int lastSkillIdx = Skill.CONSTRUCTION.ordinal();

		for (int i = 0; i < realLevels.length; i++)
		{
			if (i <= lastSkillIdx)
			{
				totalLevel += realLevels[i];
			}
		}

		return totalLevel;
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
		for (RSWidget widget : getWidgets()[topGroup])
		{
			if (widget != null && widget.getRSParentId() == -1)
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
	public RSWidget[] getGroup(int groupId)
	{
		RSWidget[][] widgets = getWidgets();

		if (widgets == null || groupId < 0 || groupId >= widgets.length || widgets[groupId] == null)
		{
			return null;
		}

		return widgets[groupId];
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
	public int getVar(VarPlayer varPlayer)
	{
		int[] varps = getVarps();
		return varps[varPlayer.getId()];
	}

	@Inject
	@Override
	public int getVarpValue(int[] varps, int varpId)
	{
		return varps[varpId];
	}

	@Inject
	@Override
	public void setVarpValue(int[] varps, int varpId, int value)
	{
		varps[varpId] = value;
	}

	@Inject
	@Override
	public boolean isPrayerActive(Prayer prayer)
	{
		return getVar(prayer.getVarbit()) == 1;
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
			logger.debug("getSkillExperience called for {}!", skill);
			return (int) getOverallExperience();
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
	public long getOverallExperience()
	{
		int[] experiences = getSkillExperiences();

		long totalExperience = 0L;

		for (int experience : experiences)
		{
			totalExperience += experience;
		}

		return totalExperience;
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
			if (getVar(Varbits.SIDE_PANELS) == 1)
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
		boolean[] leftClick = getMenuForceLeftClick();

		MenuEntry[] entries = new MenuEntry[count];
		for (int i = 0; i < count; ++i)
		{
			MenuEntry entry = entries[i] = new MenuEntry();
			entry.setOption(menuOptions[i]);
			entry.setTarget(menuTargets[i]);
			entry.setIdentifier(menuIdentifiers[i]);
			entry.setType(menuTypes[i]);
			entry.setParam0(params0[i]);
			entry.setParam1(params1[i]);
			entry.setForceLeftClick(leftClick[i]);
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
		boolean[] leftClick = getMenuForceLeftClick();

		for (MenuEntry entry : entries)
		{
			menuOptions[count] = entry.getOption();
			menuTargets[count] = entry.getTarget();
			menuIdentifiers[count] = entry.getIdentifier();
			menuTypes[count] = entry.getType();
			params0[count] = entry.getParam0();
			params1[count] = entry.getParam1();
			leftClick[count] = entry.isForceLeftClick();
			++count;
		}

		setMenuOptionCount(count);
		oldMenuEntryCount = count;
	}

	@FieldHook("menuOptionsCount")
	@Inject
	public static void onMenuOptionsChanged(int idx)
	{
		int oldCount = oldMenuEntryCount;
		int newCount = client.getMenuOptionCount();

		oldMenuEntryCount = newCount;

		if (newCount == oldCount + 1)
		{
			MenuEntryAdded event = new MenuEntryAdded(
				new MenuEntry(
					client.getMenuOptions()[oldCount],
					client.getMenuTargets()[oldCount],
					client.getMenuIdentifiers()[oldCount],
					client.getMenuTypes()[oldCount],
					client.getMenuActionParams0()[oldCount],
					client.getMenuActionParams1()[oldCount],
					client.getMenuForceLeftClick()[oldCount]
				)
			);

			client.getCallbacks().post(MenuEntryAdded.class, event);
		}
	}

	@Inject
	@Override
	public List<Projectile> getProjectiles()
	{
		List<Projectile> projectiles = new ArrayList<Projectile>();
		RSNodeDeque projectileDeque = this.getProjectilesDeque();
		Node head = projectileDeque.getHead();

		for (Node node = head.getNext(); node != head; node = node.getNext())
		{
			projectiles.add((Projectile) node);
		}

		return projectiles;
	}

	@Inject
	@Override
	public List<GraphicsObject> getGraphicsObjects()
	{
		List<GraphicsObject> graphicsObjects = new ArrayList<GraphicsObject>();
		RSNodeDeque graphicsObjectDeque = this.getGraphicsObjectDeque();
		Node head = graphicsObjectDeque.getHead();

		for (Node node = head.getNext(); node != head; node = node.getNext())
		{
			graphicsObjects.add((GraphicsObject) node);
		}

		return graphicsObjects;
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
		int sceneX = getDestinationX();
		int sceneY = getDestinationY();
		if (sceneX != 0 && sceneY != 0)
		{
			return LocalPoint.fromScene(sceneX, sceneY);
		}
		return null;
	}

	@Inject
	@Override
	public void changeMemoryMode(boolean lowMemory)
	{
		setLowMemory(lowMemory);
		setSceneLowMemory(lowMemory);
		setAudioHighMemory(true);
		setObjectDefinitionLowDetail(lowMemory);
	}

	@Inject
	@Override
	public RSItemContainer getItemContainer(InventoryID inventory)
	{
		RSNodeHashTable itemContainers = getItemContainers();
		return (RSItemContainer) itemContainers.get(inventory.getId());
	}

	@Inject
	@Override
	public boolean isFriended(String name, boolean mustBeLoggedIn)
	{
		RSUsername rsName = createName(name, getLoginType());
		return getFriendManager().isFriended(rsName, mustBeLoggedIn);
	}

	@Inject
	@Override
	public int getClanChatCount()
	{
		final RSClanChat clanMemberManager = getClanMemberManager();
		return clanMemberManager != null ? clanMemberManager.getCount() : 0;
	}

	@Inject
	@Override
	public ClanMember[] getClanMembers()
	{
		final RSClanChat clanMemberManager = getClanMemberManager();
		if (clanMemberManager == null)
		{
			return null;
		}

		final int count = clanMemberManager.getCount();
		return Arrays.copyOf(clanMemberManager.getNameables(), count);
	}

	@Inject
	@Override
	public String getClanOwner()
	{
		return getClanMemberManager().getClanOwner();
	}

	@Inject
	@Override
	public String getClanChatName()
	{
		return getClanMemberManager().getClanChatName();
	}

	@Inject
	@Override
	public Friend[] getFriends()
	{
		final RSFriendSystem friendManager = getFriendManager();
		if (friendManager == null)
		{
			return null;
		}

		final RSFriendsList friendContainer = friendManager.getFriendContainer();
		if (friendContainer == null)
		{
			return null;
		}

		final int count = friendContainer.getCount();
		return Arrays.copyOf(friendContainer.getNameables(), count);
	}

	@Inject
	@Override
	public int getFriendsCount()
	{
		final RSFriendSystem friendManager = getFriendManager();
		if (friendManager == null)
		{
			return -1;
		}

		final RSFriendsList friendContainer = friendManager.getFriendContainer();
		if (friendContainer == null)
		{
			return -1;
		}

		return friendContainer.getCount();
	}

	@Inject
	@Override
	public Ignore[] getIgnores()
	{
		final RSFriendSystem friendManager = getFriendManager();
		if (friendManager == null)
		{
			return null;
		}

		final RSIgnoreList ignoreContainer = friendManager.getIgnoreContainer();
		if (ignoreContainer == null)
		{
			return null;
		}

		final int count = ignoreContainer.getCount();
		return Arrays.copyOf(ignoreContainer.getNameables(), count);
	}

	@Inject
	@Override
	public int getIgnoreCount()
	{
		final RSFriendSystem friendManager = getFriendManager();
		if (friendManager == null)
		{
			return -1;
		}

		final RSIgnoreList ignoreContainer = friendManager.getIgnoreContainer();
		if (ignoreContainer == null)
		{
			return -1;
		}

		return ignoreContainer.getCount();
	}

	@Inject
	@Override
	public boolean isClanMember(String name)
	{
		final RSClanChat clanMemberManager = getClanMemberManager();
		return clanMemberManager != null && clanMemberManager.isMember(createName(name, getLoginType()));
	}

	@FieldHook("isDraggingWidget")
	@Inject
	public static void draggingWidgetChanged(int idx)
	{
		DraggingWidgetChanged draggingWidgetChanged = new DraggingWidgetChanged();
		draggingWidgetChanged.setDraggingWidget(client.isDraggingWidget());
		client.getCallbacks().post(DraggingWidgetChanged.class, draggingWidgetChanged);
	}

	@Inject
	@Override
	public Sprite createItemSprite(int itemId, int quantity, int border, int shadowColor, int stackable, boolean noted, int scale)
	{
		assert isClientThread();
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

	@Copy("runWidgetOnLoadListener")
	public static void rs$runWidgetOnLoadListener(int groupId)
	{
		throw new RuntimeException();
	}

	@Replace("runWidgetOnLoadListener")
	public static void rl$runWidgetOnLoadListener(int groupId)
	{
		rs$runWidgetOnLoadListener(groupId);

		RSWidget[][] widgets = client.getWidgets();
		boolean loaded = widgets != null && widgets[groupId] != null;

		if (loaded)
		{
			WidgetLoaded event = new WidgetLoaded();
			event.setGroupId(groupId);
			client.getCallbacks().post(WidgetLoaded.class, event);
		}
	}

	@FieldHook("itemDragDuration")
	@Inject
	public static void itemPressedDurationChanged(int idx)
	{
		if (client.getItemPressedDuration() > 0)
		{
			itemPressedDurationBuffer++;
			if (itemPressedDurationBuffer >= inventoryDragDelay)
			{
				client.setItemPressedDuration(itemPressedDurationBuffer);
			}
			else
			{
				client.setItemPressedDuration(0);
			}
		}
		else
		{
			itemPressedDurationBuffer = 0;
		}
	}

	@FieldHook("experience")
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
			client.getCallbacks().post(ExperienceChanged.class, experienceChanged);
		}
	}

	@FieldHook("currentLevels")
	@Inject
	public static void boostedSkillLevelsChanged(int idx)
	{
		Skill[] skills = Skill.values();

		if (idx >= 0 && idx < skills.length - 1)
		{
			Skill updatedSkill = skills[idx];
			BoostedLevelChanged boostedLevelChanged = new BoostedLevelChanged();
			boostedLevelChanged.setSkill(updatedSkill);
			client.getCallbacks().post(BoostedLevelChanged.class, boostedLevelChanged);
		}
	}

	@FieldHook("playerMenuActions")
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
		client.getCallbacks().post(PlayerMenuOptionsChanged.class, optionsChanged);
	}

	@FieldHook("gameState")
	@Inject
	public static void gameStateChanged(int idx)
	{
		GameStateChanged gameStateChange = new GameStateChanged();
		gameStateChange.setGameState(client.getGameState());
		client.getCallbacks().post(GameStateChanged.class, gameStateChange);
	}


	@FieldHook("npcs")
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

			client.getCallbacks().postDeferred(NpcSpawned.class, new NpcSpawned(npc));
		}
	}

	@FieldHook("players")
	@Inject
	public static void cachedPlayersChanged(int idx)
	{
		RSPlayer[] cachedPlayers = client.getCachedPlayers();
		if (idx < 0 || idx >= cachedPlayers.length)
		{
			return;
		}

		RSPlayer player = cachedPlayers[idx];
		RSPlayer oldPlayer = oldPlayers[idx];
		oldPlayers[idx] = player;

		if (oldPlayer != null)
		{
			client.getCallbacks().post(PlayerDespawned.class, new PlayerDespawned(oldPlayer));
		}
		if (player != null)
		{
			client.getCallbacks().postDeferred(PlayerSpawned.class, new PlayerSpawned(player));
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
		client.getCallbacks().post(GrandExchangeOfferChanged.class, offerChangedEvent);
	}

	@FieldHook("Varps_main")
	@Inject
	public static void settingsChanged(int idx)
	{
		VarbitChanged varbitChanged = new VarbitChanged();
		varbitChanged.setIndex(idx);
		client.getCallbacks().post(VarbitChanged.class, varbitChanged);
	}

	@FieldHook("isResizable")
	@Inject
	public static void resizeChanged(int idx)
	{
		//maybe couple with varbitChanged. resizeable may not be a varbit but it would fit with the other client settings.
		boolean isResized = client.isResized();

		if (oldIsResized != isResized)
		{
			ResizeableChanged resizeableChanged = new ResizeableChanged();
			resizeableChanged.setResized(isResized);
			client.getCallbacks().post(ResizeableChanged.class, resizeableChanged);

			oldIsResized = isResized;
		}
	}

	@FieldHook("clanChat")
	@Inject
	public static void clanMemberManagerChanged(int idx)
	{
		client.getCallbacks().post(ClanChanged.class, new ClanChanged(client.getClanMemberManager() != null));
	}

	@FieldHook("canvasWidth")
	@Inject
	public static void canvasWidthChanged(int idx)
	{
		client.getCallbacks().post(CanvasSizeChanged.class, CanvasSizeChanged.INSTANCE);
	}

	@FieldHook("canvasHeight")
	@Inject
	public static void canvasHeightChanged(int idx)
	{
		client.getCallbacks().post(CanvasSizeChanged.class, CanvasSizeChanged.INSTANCE);
	}

	@Inject
	@Override
	public boolean hasHintArrow()
	{
		return client.getHintArrowTargetType() != HintArrowType.NONE.getValue();
	}

	@Inject
	@Override
	public HintArrowType getHintArrowType()
	{
		int type = client.getHintArrowTargetType();
		if (type == HintArrowType.NPC.getValue())
		{
			return HintArrowType.NPC;
		}
		else if (type == HintArrowType.PLAYER.getValue())
		{
			return HintArrowType.PLAYER;
		}
		else if (type == HintArrowType.WORLD_POSITION.getValue())
		{
			return HintArrowType.WORLD_POSITION;
		}
		else
		{
			return HintArrowType.NONE;
		}
	}

	@Inject
	@Override
	public void clearHintArrow()
	{
		client.setHintArrowTargetType(HintArrowType.NONE.getValue());
	}

	@Inject
	@Override
	public void setHintArrow(NPC npc)
	{
		client.setHintArrowTargetType(HintArrowType.NPC.getValue());
		client.setHintArrowNpcTargetIdx(npc.getIndex());
	}

	@Inject
	@Override
	public void setHintArrow(Player player)
	{
		client.setHintArrowTargetType(HintArrowType.PLAYER.getValue());
		client.setHintArrowPlayerTargetIdx(((RSPlayer) player).getPlayerId());
	}

	@Inject
	@Override
	public void setHintArrow(WorldPoint point)
	{
		client.setHintArrowTargetType(HintArrowType.WORLD_POSITION.getValue());
		client.setHintArrowX(point.getX());
		client.setHintArrowY(point.getY());
		// position the arrow in center of the tile
		client.setHintArrowOffsetX(LOCAL_TILE_SIZE / 2);
		client.setHintArrowOffsetY(LOCAL_TILE_SIZE / 2);
	}

	@Inject
	@Override
	public WorldPoint getHintArrowPoint()
	{
		if (getHintArrowType() == HintArrowType.WORLD_POSITION)
		{
			int x = client.getHintArrowX();
			int y = client.getHintArrowY();
			return new WorldPoint(x, y, client.getPlane());
		}

		return null;
	}

	@Inject
	@Override
	public Player getHintArrowPlayer()
	{
		if (getHintArrowType() == HintArrowType.PLAYER)
		{
			int idx = client.getHintArrowPlayerTargetIdx();
			RSPlayer[] players = client.getCachedPlayers();

			if (idx < 0 || idx >= players.length)
			{
				return null;
			}

			return players[idx];
		}

		return null;
	}

	@Inject
	@Override
	public NPC getHintArrowNpc()
	{
		if (getHintArrowType() == HintArrowType.NPC)
		{
			int idx = client.getHintArrowNpcTargetIdx();
			RSNPC[] npcs = client.getCachedNPCs();

			if (idx < 0 || idx >= npcs.length)
			{
				return null;
			}

			return npcs[idx];
		}

		return null;
	}

	@Copy("menuAction")
	static void rs$menuAction(int var0, int var1, int var2, int var3, String var4, String var5, int var6, int var7)
	{
		throw new RuntimeException();
	}

	@Replace("menuAction")
	static void rl$menuAction(int actionParam, int widgetId, int menuAction, int id, String menuOption, String menuTarget, int var6, int var7)
	{
		boolean authentic = true;
		if (menuTarget != null && menuTarget.startsWith("!AUTHENTIC"))
		{
			authentic = false;
			menuTarget = menuTarget.substring(10);
		}

		if (printMenuActions && client.getLogger().isDebugEnabled())
		{
			client.getLogger().debug("Menuaction: {} {} {} {} {} {} {} {} {}", actionParam, widgetId, menuAction, id, menuOption, menuTarget, var6, var7, authentic);
		}

		/* Along the way, the RuneScape client may change a menuAction by incrementing it with 2000.
		 * I have no idea why, but it does. Their code contains the same conditional statement.
		 */
		if (menuAction >= 2000)
		{
			menuAction -= 2000;
		}

		final MenuOptionClicked menuOptionClicked = new MenuOptionClicked(
			new MenuEntry(
				menuOption,
				menuTarget,
				id,
				menuAction,
				actionParam,
				widgetId,
				false
			),
			authentic
		);

		client.getCallbacks().post(MenuOptionClicked.class, menuOptionClicked);

		if (menuOptionClicked.isConsumed())
		{
			return;
		}

		rs$menuAction(menuOptionClicked.getActionParam0(), menuOptionClicked.getActionParam1(), menuOptionClicked.getType(),
			menuOptionClicked.getIdentifier(), menuOptionClicked.getOption(), menuOptionClicked.getTarget(), var6, var7);
	}

	@Override
	@Inject
	public void invokeMenuAction(int actionParam, int widgetId, int menuAction, int id, String menuOption, String menuTarget, int var6, int var7)
	{
		client.sendMenuAction(actionParam, widgetId, menuAction, id, menuOption, "!AUTHENTIC" + menuTarget, var6, var7);
	}

	@Inject
	@FieldHook("tempMenuAction")
	public static void onTempMenuActionChanged(int idx)
	{
		if (client.getTempMenuAction() != null)
		{
			client.getCallbacks().post(WidgetPressed.class, WidgetPressed.INSTANCE);
		}
	}

	@FieldHook("Login_username")
	@Inject
	public static void onUsernameChanged(int idx)
	{
		client.getCallbacks().post(UsernameChanged.class, UsernameChanged.INSTANCE);
	}

	@Override
	@Inject
	public int getTickCount()
	{
		return tickCount;
	}

	@Override
	@Inject
	public void setTickCount(int tick)
	{
		tickCount = tick;
	}

	@Inject
	@Override
	public EnumSet<WorldType> getWorldType()
	{
		int flags = getFlags();
		return WorldType.fromMask(flags);
	}

	@Inject
	@MethodHook("openMenu")
	public void menuOpened(int var1, int var2)
	{
		final MenuOpened event = new MenuOpened();
		event.setMenuEntries(getMenuEntries());
		callbacks.post(MenuOpened.class, event);
	}

	@Inject
	@MethodHook("updateNpcs")
	public static void updateNpcs(boolean var0, RSPacketBuffer var1)
	{
		client.getCallbacks().updateNpcs();
	}

	@Inject
	@MethodHook(value = "addChatMessage", end = true)
	public static void onAddChatMessage(int type, String name, String message, String sender)
	{
		Logger logger = client.getLogger();
		if (logger.isDebugEnabled())
		{
			logger.debug("Chat message type {}: {}", ChatMessageType.of(type), message);
		}

		// Get the message node which was added
		Map<Integer, RSChatChannel> chatLineMap = client.getChatLineMap();
		RSChatChannel chatLineBuffer = chatLineMap.get(type);
		MessageNode messageNode = chatLineBuffer.getLines()[0];

		final ChatMessageType chatMessageType = ChatMessageType.of(type);
		final ChatMessage chatMessage = new ChatMessage(messageNode, chatMessageType, name, message, sender, messageNode.getTimestamp());
		client.getCallbacks().post(ChatMessage.class, chatMessage);
	}

	@Inject
	@MethodHook("draw")
	public void draw(boolean var1)
	{
		callbacks.clientMainLoop();
	}

	@MethodHook("drawInterface")
	@Inject
	public static void renderWidgetLayer(Widget[] widgets, int parentId, int minX, int minY, int maxX, int maxY, int x, int y, int var8)
	{
		Callbacks callbacks = client.getCallbacks();
		HashTable<WidgetNode> componentTable = client.getComponentTable();

		for (Widget rlWidget : widgets)
		{
			RSWidget widget = (RSWidget) rlWidget;
			if (widget == null || widget.getRSParentId() != parentId || widget.isSelfHidden())
			{
				continue;
			}

			if (parentId != -1)
			{
				widget.setRenderParentId(parentId);
			}

			final int renderX = x + widget.getRelativeX();
			final int renderY = y + widget.getRelativeY();
			widget.setRenderX(renderX);
			widget.setRenderY(renderY);

			final int widgetType = widget.getType();
			if (widgetType == WidgetType.GRAPHIC && widget.getItemId() != -1)
			{
				if (renderX >= minX && renderX <= maxX && renderY >= minY && renderY <= maxY)
				{
					WidgetItem widgetItem = new WidgetItem(widget.getItemId(), widget.getItemQuantity(), -1, widget.getBounds(), widget);
					callbacks.drawItem(widget.getItemId(), widgetItem);
				}
			}
			else if (widgetType == WidgetType.INVENTORY)
			{
				Collection<WidgetItem> widgetItems = widget.getWidgetItems();
				for (WidgetItem widgetItem : widgetItems)
				{
					callbacks.drawItem(widgetItem.getId(), widgetItem);
				}
			}

			WidgetNode childNode = componentTable.get(widget.getId());
			if (childNode != null)
			{
				int widgetId = widget.getId();
				int groupId = childNode.getId();
				RSWidget[] children = client.getWidgets()[groupId];

				for (RSWidget child : children)
				{
					if (child.getRSParentId() == -1)
					{
						child.setRenderParentId(widgetId);
					}
				}
			}
		}
	}

	@Inject
	@Override
	public RSGroundItem getLastItemDespawn()
	{
		return lastItemDespawn;
	}

	@Inject
	@Override
	public void setLastItemDespawn(RSGroundItem lastItemDespawn)
	{
		RSClientMixin.lastItemDespawn = lastItemDespawn;
	}

	@Inject
	@Override
	public boolean isGpu()
	{
		return gpu;
	}

	@Inject
	@Override
	public void setGpu(boolean gpu)
	{
		this.gpu = gpu;
	}

	@Inject
	@Override
	public void queueChangedSkill(Skill skill)
	{
		int[] skills = client.getChangedSkills();
		int count = client.getChangedSkillsCount();
		skills[++count - 1 & 31] = skill.ordinal();
		client.setChangedSkillsCount(count);
	}

	@Inject
	@Override
	public RSSprite[] getSprites(IndexDataBase source, int archiveId, int fileId)
	{
		RSAbstractArchive rsSource = (RSAbstractArchive) source;
		byte[] configData = rsSource.getConfigData(archiveId, fileId);
		if (configData == null)
		{
			return null;
		}

		decodeSprite(configData);

		int indexedSpriteCount = getIndexedSpriteCount();
		int maxWidth = getIndexedSpriteWidth();
		int maxHeight = getIndexedSpriteHeight();
		int[] offsetX = getIndexedSpriteOffsetXs();
		int[] offsetY = getIndexedSpriteOffsetYs();
		int[] widths = getIndexedSpriteWidths();
		int[] heights = getIndexedSpriteHeights();
		byte[][] spritePixelsArray = getSpritePixels();
		int[] indexedSpritePalette = getIndexedSpritePalette();

		RSSprite[] array = new RSSprite[indexedSpriteCount];

		for (int i = 0; i < indexedSpriteCount; ++i)
		{
			int width = widths[i];
			int height = heights[i];

			byte[] pixelArray = spritePixelsArray[i];
			int[] pixels = new int[width * height];

			RSSprite spritePixels = createSprite(pixels, width, height);
			spritePixels.setMaxHeight(maxHeight);
			spritePixels.setMaxWidth(maxWidth);
			spritePixels.setOffsetX(offsetX[i]);
			spritePixels.setOffsetY(offsetY[i]);

			for (int j = 0; j < width * height; ++j)
			{
				pixels[j] = indexedSpritePalette[pixelArray[j] & 0xff];
			}

			array[i] = spritePixels;
		}

		setIndexedSpriteOffsetXs(null);
		setIndexedSpriteOffsetYs(null);
		setIndexedSpriteWidths(null);
		setIndexedSpriteHeights(null);
		setIndexedSpritePalette(null);
		setSpritePixels(null);

		return array;
	}

	@Inject
	@Override
	public void setSkyboxColor(int newSkyboxColor)
	{
		skyboxColor = newSkyboxColor;
	}

	@Inject
	@Override
	public int getSkyboxColor()
	{
		return skyboxColor;
	}

	@Inject
	@FieldHook("cycleCntr")
	public static void onCycleCntrChanged(int idx)
	{
		client.getCallbacks().post(ClientTick.class, ClientTick.INSTANCE);
	}

	@Copy("shouldLeftClickOpenMenu")
	boolean rs$shouldLeftClickOpenMenu()
	{
		throw new RuntimeException();
	}

	@Replace("shouldLeftClickOpenMenu")
	boolean rl$shouldLeftClickOpenMenu()
	{
		if (rs$shouldLeftClickOpenMenu())
		{
			return true;
		}

		MenuShouldLeftClick menuShouldLeftClick = new MenuShouldLeftClick();
		client.getCallbacks().post(MenuShouldLeftClick.class, menuShouldLeftClick);

		if (menuShouldLeftClick.isForceRightClick())
		{
			return true;
		}

		int len = getMenuOptionCount();
		if (len > 0)
		{
			int type = getMenuTypes()[len - 1];
			return type == MenuAction.RUNELITE_OVERLAY.getId();
		}

		return false;
	}

	@Inject
	@Override
	public EnumDefinition getEnum(int id)
	{
		assert isClientThread() : "getEnum must be called on client thread";

		RSEnumDefinition rsEnumDefinition = enumCache.getIfPresent(id);
		if (rsEnumDefinition != null)
		{
			return rsEnumDefinition;
		}

		rsEnumDefinition = getRsEnum(id);
		enumCache.put(id, rsEnumDefinition);
		return rsEnumDefinition;
	}

	@Inject
	@Override
	public void resetHealthBarCaches()
	{
		getHealthBarCache().reset();
		getHealthBarSpriteCache().reset();
	}

	@Inject
	static boolean shouldHideAttackOptionFor(RSPlayer p)
	{
		if (client.isSpellSelected())
		{
			return ((hideFriendCastOptions && p.isFriended()) || (hideClanmateCastOptions && p.isClanMember()))
				&& !unhiddenCasts.contains(client.getSelectedSpellName().replaceAll("<[^>]*>", "").toLowerCase());
		}

		return ((hideFriendAttackOptions && p.isFriended()) || (hideClanmateAttackOptions && p.isClanMember()));
	}

	@Inject
	@Override
	public void addFriend(String friend)
	{
		RSFriendSystem friendSystem = getFriendManager();
		friendSystem.addFriend(friend);
	}

	@Inject
	@Override
	public void removeFriend(String friend)
	{
		RSFriendSystem friendSystem = getFriendManager();
		friendSystem.removeFriend(friend);
	}
}