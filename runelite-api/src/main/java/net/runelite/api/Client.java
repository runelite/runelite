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
import java.util.List;
import java.util.Map;
import javax.annotation.Nullable;
import net.runelite.api.coords.LocalPoint;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetInfo;

public interface Client extends GameEngine
{
	List<Player> getPlayers();

	List<NPC> getNpcs();

	NPC[] getCachedNPCs();

	int getBoostedSkillLevel(Skill skill);

	int getRealSkillLevel(Skill skill);

	void addChatMessage(ChatMessageType type, String name, String message, String sender);

	GameState getGameState();

	String getUsername();

	void setUsername(String name);

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

	int getScale();

	Point getMouseCanvasPosition();

	int[][][] getTileHeights();

	byte[][][] getTileSettings();

	int getPlane();

	Region getRegion();

	Player getLocalPlayer();

	ItemComposition getItemDefinition(int id);

	SpritePixels createItemSprite(int itemId, int quantity, int border, int shadowColor, int stackable, boolean noted, int scale);

	int getBaseX();

	int getBaseY();

	int getMouseCurrentButton();

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

	int[] getSettings();

	int[] getWidgetSettings();

	int getSetting(Setting setting);

	int getSetting(Varbits varbit);

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

	boolean getDrawBoundingBoxes2D();

	/**
	 * When {@code shouldDraw} is true, a 2D bounding box will be drawn for
	 * all on-screen objects
	 *
	 * @param shouldDraw whether or not to draw 2D bounding boxes
	 */
	void setDrawBoundingBoxes2D(boolean shouldDraw);

	boolean getDrawBoundingBoxes3D();

	/**
	 * When {@code shouldDraw} is true, 3D bounding boxes will be drawn
	 * either for the object under the cursor, or every object on screen
	 * according to
	 * {@link #setBoundingBoxAlwaysOnMode(boolean) BoundingBoxAlwaysOnMode}
	 *
	 * @param shouldDraw whether or not to draw 3D bounding boxes
	 */
	void setDrawBoundingBoxes3D(boolean shouldDraw);

	boolean getdrawObjectGeometry2D();

	/**
	 * When {@code shouldDraw} is true, the clickbox geometry for the object
	 * under the cursor will be displayed
	 *
	 * @param shouldDraw whether or not to draw the clickbox geometry
	 */
	void setdrawObjectGeometry2D(boolean shouldDraw);

	boolean getBoundingBoxAlwaysOnMode();

	/**
	 * Changes how {@link #getDrawBoundingBoxes3D()} behaves when active.
	 * When {@code alwaysDrawBoxes} is true, 3D bounding boxes will be
	 * drawn. When false, a 3D bounding box will only be drawn for the
	 * object under the cursor
	 *
	 * @param alwaysDrawBoxes whether or not to draw every 3D bounding box,
	 * when 3D bounding boxes are enabled
	 */
	void setBoundingBoxAlwaysOnMode(boolean alwaysDrawBoxes);

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
}
