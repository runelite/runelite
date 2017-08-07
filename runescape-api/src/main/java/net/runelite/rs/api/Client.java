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
package net.runelite.rs.api;

import net.runelite.mapping.Import;

public interface Client extends GameEngine
{
	@Import("cameraX")
	int getCameraX();

	@Import("cameraY")
	int getCameraY();

	@Import("cameraZ")
	int getCameraZ();

	@Import("plane")
	int getPlane();

	@Import("cameraPitch")
	int getCameraPitch();

	@Import("cameraYaw")
	int getCameraYaw();

	@Import("world")
	int getWorld();

	@Import("FPS")
	int getFPS();

	@Import("mapAngle")
	int getMapAngle();

	@Import("tileHeights")
	int[][][] getTileHeights();

	@Import("tileSettings")
	byte[][][] getTileSettings();

	@Import("settings")
	int[] getSettings();

	@Import("widgetSettings")
	int[] getWidgetSettings();

	@Import("energy")
	int getEnergy();

	@Import("weight")
	int getWeight();

	@Import("baseX")
	int getBaseX();

	@Import("baseY")
	int getBaseY();

	@Import("boostedSkillLevels")
	int[] getBoostedSkillLevels();

	@Import("realSkillLevels")
	int[] getRealSkillLevels();

	@Import("skillExperiences")
	int[] getSkillExperiences();

	@Import("gameState")
	int getGameState();

	@Import("widgets")
	Widget[][] getWidgets();

	@Import("region")
	Region getRegion();

	@Import("localPlayer")
	Player getLocalPlayer();

	@Import("cachedNPCs")
	NPC[] getCachedNPCs();

	@Import("collisionMaps")
	CollisionData[] getCollisionMaps();

	@Import("cachedPlayers")
	Player[] getCachedPlayers();

	@Import("groundItemDeque")
	Deque[][][] getGroundItemDeque();

	@Import("username")
	String getUsername();

	@Import(value = "username", setter = true)
	void setUsername(String username);

	@Import("playerOptions")
	String[] getPlayerOptions();

	@Import("playerOptionsPriorities")
	boolean[] getPlayerOptionsPriorities();

	@Import("playerMenuTypes")
	int[] getPlayerMenuTypes();

	@Import("menuTargets")
	String[] getMenuTargets();

	@Import("menuOptions")
	String[] getMenuOptions();

	@Import("mouseX")
	int getMouseX();

	@Import("mouseY")
	int getMouseY();

	@Import("menuOptionCount")
	int getMenuOptionCount();

	@Import("menuTypes")
	int[] getMenuTypes();

	@Import("menuIdentifiers")
	int[] getMenuIdentifiers();

	@Import("friends")
	Friend[] getFriends();

	@Import("ignores")
	Ignore[] getIgnores();

	@Import("worldList")
	World[] getWorldList();

	@Import("sendGameMessage")
	void sendGameMessage(int var1, String var2, String var3);

	@Import("getObjectDefinition")
	ObjectComposition getObjectDefinition(int objectId);

	@Import("scale")
	int getScale();

	@Import("viewportHeight")
	int getViewportHeight();

	@Import("viewportWidth")
	int getViewportWidth();

	@Import("isResized")
	boolean isResized();

	@Import("widgetPositionX")
	int[] getWidgetPositionsX();

	@Import("widgetPositionY")
	int[] getWidgetPositionsY();

	@Import("itemContainers")
	XHashTable getItemContainers();

	@Import("getItemDefinition")
	ItemComposition getItemDefinition(int itemId);

	@Import("componentTable")
	XHashTable getComponentTable();

	@Import("grandExchangeOffers")
	XGrandExchangeOffer[] getGrandExchangeOffers();

	@Import("clanChatCount")
	int getClanChatCount();

	@Import("clanMembers")
	XClanMember[] getClanMembers();

	@Import("isMenuOpen")
	boolean isMenuOpen();

	@Import("gameCycle")
	int getGameCycle();

	@Import("packetHandler")
	void packetHandler();

	@Import("revision")
	int getRevision();

	@Import("mapRegions")
	int[] getMapRegions();

	@Import("xteaKeys")
	int[][] getXteaKeys();

	@Import("gameDrawingMode")
	int getGameDrawingMode();

	@Import(
		value = "gameDrawingMode",
		setter = true
	)
	void setGameDrawingMode(int gameDrawingMode);

	@Import("cycleCntr")
	int getCycleCntr();

	@Import(value = "chatCycle", setter = true)
	void setChatCycle(int value);

	/**
	 * Get the widget top group. widgets[topGroup] contains widgets with
	 * parentId -1, which are the widget roots.
	 * @return
	 */
	@Import("widgetRoot")
	int getWidgetRoot();
}
