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
import java.awt.Dimension;
import java.util.EnumSet;
import java.util.List;
import java.util.Map;
import javax.annotation.Nullable;
import net.runelite.api.annotations.VisibleForDevtools;
import net.runelite.api.coords.LocalPoint;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.vars.AccountType;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetInfo;

public interface Client extends GameEngine
{
	List<Player> getPlayers();

	List<NPC> getNpcs();

	NPC[] getCachedNPCs();

	Player[] getCachedPlayers();

	int getBoostedSkillLevel(Skill skill);

	int getRealSkillLevel(Skill skill);

	void addChatMessage(ChatMessageType type, String name, String message, String sender);

	GameState getGameState();

	String getUsername();

	void setUsername(String name);

	/**
	 * Gets the account type for the logged in player.
	 */
	AccountType getAccountType();

	Canvas getCanvas();

	int getFPS();

	int getCameraX();

	int getCameraY();

	int getCameraZ();

	/**
	 * This returns the actual pitch of the camera in JAUs
	 */
	int getCameraPitch();

	int getCameraYaw();

	int getWorld();

	int getViewportHeight();

	int getViewportWidth();

	int getViewportXOffset();

	int getViewportYOffset();

	int getScale();

	Point getMouseCanvasPosition();

	int[][][] getTileHeights();

	byte[][][] getTileSettings();

	int getPlane();

	Region getRegion();

	Player getLocalPlayer();

	ItemComposition getItemDefinition(int id);

	SpritePixels createItemSprite(int itemId, int quantity, int border, int shadowColor, int stackable, boolean noted, int scale);

	SpritePixels getSprite(IndexDataBase source, int archiveId, int fileId);

	IndexDataBase getIndexSprites();

	int getBaseX();

	int getBaseY();

	int getMouseCurrentButton();

	Tile getSelectedRegionTile();

	boolean isDraggingWidget();

	Widget getDraggedWidget();

	Widget getDraggedOnWidget();

	void setDraggedOnWidget(Widget widget);

	Widget[] getWidgetRoots();

	Widget getWidget(WidgetInfo widget);

	Widget[] getGroup(int groupId);

	Widget getWidget(int groupId, int childId);

	int[] getWidgetPositionsX();

	int[] getWidgetPositionsY();

	int getEnergy();

	String[] getPlayerOptions();

	boolean[] getPlayerOptionsPriorities();

	int[] getPlayerMenuTypes();

	/**
	 * Get list of all RuneScape worlds
	 * @return world list
	 */
	World[] getWorldList();

	MenuEntry[] getMenuEntries();

	void setMenuEntries(MenuEntry[] entries);

	boolean isMenuOpen();

	int getMapAngle();

	boolean isResized();

	int getRevision();

	int[] getMapRegions();

	int[][][] getInstanceTemplateChunks();

	int[][] getXteaKeys();

	@VisibleForDevtools
	int[] getVarps();

	@VisibleForDevtools
	int[] getIntVarcs();

	@VisibleForDevtools
	String[] getStrVarcs();

	int getVar(VarPlayer varPlayer);

	int getVar(Varbits varbit);

	int getVar(VarClientInt varClientInt);

	String getVar(VarClientStr varClientStr);

	@VisibleForDevtools
	void setSetting(Varbits varbit, int value);

	@VisibleForDevtools
	int getVarbitValue(int[] varps, int varbitId);

	@VisibleForDevtools
	void setVarbitValue(int[] varps, int varbit, int value);

	HashTable getWidgetFlags();

	HashTable getComponentTable();

	GrandExchangeOffer[] getGrandExchangeOffers();

	boolean isPrayerActive(Prayer prayer);

	int getSkillExperience(Skill skill);

	int getGameDrawingMode();

	void setGameDrawingMode(int gameDrawingMode);

	void refreshChat();

	Map<Integer, ChatLineBuffer> getChatLineMap();

	Widget getViewportWidget();

	ObjectComposition getObjectDefinition(int objectId);

	NPCComposition getNpcDefinition(int npcId);

	Area[] getMapAreas();

	IndexedSprite[] getMapScene();
	
	SpritePixels[] getMapDots();

	int getGameCycle();

	SpritePixels[] getMapIcons();

	IndexedSprite[] getModIcons();

	void setModIcons(IndexedSprite[] modIcons);

	IndexedSprite createIndexedSprite();

	SpritePixels createSpritePixels(int[] pixels, int width, int height);

	@Nullable
	LocalPoint getLocalDestinationLocation();

	List<Projectile> getProjectiles();

	List<GraphicsObject> getGraphicsObjects();

	/**
	 * Play a sound effect at the player's current location. This is how UI,
	 * and player-generated (e.g. mining, woodcutting) sound effects are
	 * normally played
	 *
	 * @param id the ID of the sound to play. Any int is allowed, but see
	 * {@link SoundEffectID} for some common ones
	 */
	void playSoundEffect(int id);

	/**
	 * Play a sound effect from some point in the world.
	 *
	 * @param id the ID of the sound to play. Any int is allowed, but see
	 * {@link SoundEffectID} for some common ones
	 * @param x the ground coordinate on the x axis
	 * @param y the ground coordinate on the y axis
	 * @param range the number of tiles away that the sound can be heard
	 * from
	 */
	void playSoundEffect(int id, int x, int y, int range);

	BufferProvider getBufferProvider();

	int getMouseIdleTicks();

	int getKeyboardIdleTicks();

	/**
	 * Changes how game behaves based on memory mode. Low memory mode skips
	 * drawing of all floors and renders ground textures in low quality.
	 *
	 * @param lowMemory if we are running in low memory mode or not
	 */
	void changeMemoryMode(boolean lowMemory);

	/**
	 * Get the item container for an inventory
	 *
	 * @param inventory
	 * @return
	 */
	@Nullable
	ItemContainer getItemContainer(InventoryID inventory);

	int getIntStackSize();

	void setIntStackSize(int stackSize);

	int[] getIntStack();

	int getStringStackSize();

	void setStringStackSize(int stackSize);

	String[] getStringStack();

	boolean isFriended(String name, boolean mustBeLoggedIn);

	int getClanChatCount();

	ClanMember[] getClanMembers();

	Friend[] getFriends();

	boolean isClanMember(String name);

	Preferences getPreferences();

	void setCameraPitchRelaxerEnabled(boolean enabled);

	RenderOverview getRenderOverview();

	boolean isStretchedEnabled();

	void setStretchedEnabled(boolean state);

	boolean isStretchedFast();

	void setStretchedFast(boolean state);

	void setStretchedKeepAspectRatio(boolean state);

	Dimension getStretchedDimensions();

	Dimension getRealDimensions();

	/**
	 * Changes world. Works only on login screen
	 * @param world world
	 */
	void changeWorld(World world);

	/**
	 * Creates instance of new world
	 * @return world
	 */
	World createWorld();

	SpritePixels drawInstanceMap(int z);

	void runScript(int id, Object... args);

	boolean hasHintArrow();

	HintArrowType getHintArrowType();

	void clearHintArrow();

	void setHintArrow(WorldPoint point);

	void setHintArrow(Player player);

	void setHintArrow(NPC npc);

	WorldPoint getHintArrowPoint();

	Player getHintArrowPlayer();

	NPC getHintArrowNpc();

	boolean isInterpolatePlayerAnimations();

	void setInterpolatePlayerAnimations(boolean interpolate);

	boolean isInterpolateNpcAnimations();

	void setInterpolateNpcAnimations(boolean interpolate);

	boolean isInterpolateObjectAnimations();

	void setInterpolateObjectAnimations(boolean interpolate);

	boolean isInInstancedRegion();

	void setIsHidingEntities(boolean state);

	void setPlayersHidden(boolean state);

	void setPlayersHidden2D(boolean state);

	void setFriendsHidden(boolean state);

	void setClanMatesHidden(boolean state);

	void setLocalPlayerHidden(boolean state);

	void setLocalPlayerHidden2D(boolean state);

	void setNPCsHidden(boolean state);

	void setNPCsHidden2D(boolean state);

	void setAttackersHidden(boolean state);

	void setProjectilesHidden(boolean state);

	CollisionData[] getCollisionMaps();

	@VisibleForDevtools
	int[] getBoostedSkillLevels();

	@VisibleForDevtools
	int[] getRealSkillLevels();

	@VisibleForDevtools
	int[] getSkillExperiences();

	@VisibleForDevtools
	int[] getChangedSkills();

	@VisibleForDevtools
	int getChangedSkillsCount();

	@VisibleForDevtools
	void setChangedSkillsCount(int i);

	void setSpriteOverrides(Map<Integer, SpritePixels> overrides);

	void setWidgetSpriteOverrides(Map<Integer, SpritePixels> overrides);

	void setCompass(SpritePixels spritePixels);

	int getTickCount();

	void setTickCount(int tickCount);

	void setInventoryDragDelay(int delay);

	EnumSet<WorldType> getWorldType();
}
