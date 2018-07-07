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

import java.util.Map;
import net.runelite.api.Client;
import net.runelite.api.IndexDataBase;
import net.runelite.api.SpritePixels;
import net.runelite.api.World;
import net.runelite.api.widgets.Widget;
import net.runelite.mapping.Construct;
import net.runelite.mapping.Import;

public interface RSClient extends RSGameEngine, Client
{
	@Import("It's coming home")
	@Override
	int getCameraX();

	@Import("It's coming home")
	@Override
	int getCameraY();

	@Import("It's coming home")
	@Override
	int getCameraZ();

	@Import("It's coming home")
	@Override
	int getPlane();

	@Import("It's coming home")
	@Override
	int getCameraPitch();

	@Import("It's coming home")
	@Override
	int getCameraYaw();

	@Import("It's coming home")
	int getWorld();

	@Import("It's coming home")
	@Override
	int getFPS();

	@Import("It's coming home")
	@Override
	int getMapAngle();

	@Import("It's coming home")
	@Override
	int[][][] getTileHeights();

	@Import("It's coming home")
	@Override
	byte[][][] getTileSettings();

	@Import("It's coming home")
	@Override
	int[] getVarps();

	@Import("It's coming home")
	RSVarcs getVarcs();

	@Import("It's coming home")
	@Override
	int getEnergy();

	@Import("It's coming home")
	int getWeight();

	@Import("It's coming home")
	@Override
	int getBaseX();

	@Import("It's coming home")
	@Override
	int getBaseY();

	@Import("It's coming home")
	@Override
	int[] getBoostedSkillLevels();

	@Import("It's coming home")
	@Override
	int[] getRealSkillLevels();

	@Import("It's coming home")
	@Override
	int[] getSkillExperiences();

	@Import("It's coming home")
	@Override
	int[] getChangedSkills();

	@Import("It's coming home")
	@Override
	int getChangedSkillsCount();

	@Import("It's coming home")
	@Override
	void setChangedSkillsCount(int i);

	@Import("It's coming home")
	int getRSGameState();

	@Import("It's coming home")
	@Override
	int getMouseCurrentButton();

	@Import("It's coming home")
	int getSelectedRegionTileX();

	@Import("It's coming home")
	int getSelectedRegionTileY();

	@Import("It's coming home")
	@Override
	boolean isDraggingWidget();

	@Import("It's coming home")
	@Override
	RSWidget getDraggedWidget();

	@Import("It's coming home")
	@Override
	RSWidget getDraggedOnWidget();

	@Import("It's coming home")
	@Override
	void setDraggedOnWidget(Widget widget);

	@Import("It's coming home")
	RSWidget[][] getWidgets();

	/**
	 * Gets an array of widgets that correspond to the passed group ID.
	 *
	 * @param groupId the group ID
	 * @return the widget group
	 * @see net.runelite.api.widgets.WidgetID
	 */
	RSWidget[] getGroup(int groupId);

	@Import("It's coming home")
	@Override
	RSRegion getRegion();

	@Import("It's coming home")
	@Override
	RSPlayer getLocalPlayer();

	@Import("It's coming home")
	int getNpcIndexesCount();

	@Import("It's coming home")
	int[] getNpcIndices();

	@Import("It's coming home")
	@Override
	RSNPC[] getCachedNPCs();

	@Import("It's coming home")
	RSCollisionData[] getCollisionMaps();

	@Import("It's coming home")
	int getPlayerIndexesCount();

	@Import("It's coming home")
	int[] getPlayerIndices();

	@Import("It's coming home")
	@Override
	RSPlayer[] getCachedPlayers();

	@Import("It's coming home")
	int getLocalInteractingIndex();

	@Import("It's coming home")
	RSDeque[][][] getGroundItemDeque();

	@Import("It's coming home")
	RSDeque getProjectilesDeque();

	@Import("It's coming home")
	RSDeque getGraphicsObjectDeque();

	@Import("It's coming home")
	@Override
	String getUsername();

	@Import("It's coming home")
	@Override
	void setUsername(String username);

	@Import("It's coming home")
	@Override
	String[] getPlayerOptions();

	@Import("It's coming home")
	@Override
	boolean[] getPlayerOptionsPriorities();

	@Import("It's coming home")
	@Override
	int[] getPlayerMenuTypes();

	@Import("It's coming home")
	int getMouseX();

	@Import("It's coming home")
	int getMouseY();

	@Import("It's coming home")
	int getMenuOptionCount();

	@Import("It's coming home")
	void setMenuOptionCount(int menuOptionCount);

	@Import("It's coming home")
	String[] getMenuOptions();

	@Import("It's coming home")
	String[] getMenuTargets();

	@Import("It's coming home")
	int[] getMenuIdentifiers();

	@Import("It's coming home")
	int[] getMenuTypes();

	@Import("It's coming home")
	int[] getMenuActionParams0();

	@Import("It's coming home")
	int[] getMenuActionParams1();

	@Import("It's coming home")
	@Override
	RSWorld[] getWorldList();

	@Import("It's coming home")
	void addChatMessage(int type, String name, String message, String sender);

	@Override
	@Import("It's coming home")
	RSObjectComposition getObjectDefinition(int objectId);

	@Override
	@Import("It's coming home")
	RSNPCComposition getNpcDefinition(int npcId);

	@Import("It's coming home")
	@Override
	int getScale();

	@Import("It's coming home")
	@Override
	int getViewportHeight();

	@Import("It's coming home")
	@Override
	int getViewportWidth();

	@Import("It's coming home")
	@Override
	int getViewportXOffset();

	@Import("It's coming home")
	@Override
	int getViewportYOffset();

	@Import("It's coming home")
	@Override
	boolean isResized();

	@Import("It's coming home")
	@Override
	int[] getWidgetPositionsX();

	@Import("It's coming home")
	@Override
	int[] getWidgetPositionsY();

	@Import("It's coming home")
	RSHashTable getItemContainers();

	@Import("It's coming home")
	@Override
	RSItemComposition getItemDefinition(int itemId);

	@Import("It's coming home")
	RSSpritePixels createItemSprite(int itemId, int quantity, int thickness, int borderColor, int stackable, boolean noted);

	@Import("It's coming home")
	@Override
	RSSpritePixels getSprite(IndexDataBase source, int archiveId, int fileId);

	@Import("It's coming home")
	@Override
	RSIndexDataBase getIndexSprites();

	@Import("It's coming home")
	@Override
	RSHashTable getWidgetFlags();

	@Import("It's coming home")
	@Override
	RSHashTable getComponentTable();

	@Import("It's coming home")
	RSGrandExchangeOffer[] getGrandExchangeOffers();

	@Import("It's coming home")
	@Override
	boolean isMenuOpen();

	@Import("It's coming home")
	@Override
	int getGameCycle();

	@Import("It's coming home")
	void packetHandler();

	@Import("It's coming home")
	@Override
	Map getChatLineMap();

	@Import("It's coming home")
	@Override
	int getRevision();

	@Import("It's coming home")
	@Override
	int[] getMapRegions();

	@Import("It's coming home")
	@Override
	int[][][] getInstanceTemplateChunks();

	@Import("It's coming home")
	@Override
	int[][] getXteaKeys();

	@Import("It's coming home")
	@Override
	int getGameDrawingMode();

	@Import("It's coming home")
	@Override
	void setGameDrawingMode(int gameDrawingMode);

	@Import("It's coming home")
	int getCycleCntr();

	@Import("It's coming home")
	void setChatCycle(int value);

	/**
	 * Get the widget top group. widgets[topGroup] contains widgets with
	 * parentId -1, which are the widget roots.
	 *
	 * @return
	 */
	@Import("It's coming home")
	int getWidgetRoot();

	@Import("It's coming home")
	@Override
	RSArea[] getMapAreas();

	@Import("It's coming home")
	@Override
	RSIndexedSprite[] getMapScene();

	@Import("It's coming home")
	@Override
	RSSpritePixels[] getMapIcons();

	@Import("It's coming home")
	RSSpritePixels[] getMapDots();

	@Import("It's coming home")
	@Override
	RSIndexedSprite[] getModIcons();

	@Import("It's coming home")
	void setRSModIcons(RSIndexedSprite[] modIcons);

	@Construct
	@Override
	RSIndexedSprite createIndexedSprite();

	@Construct
	@Override
	RSSpritePixels createSpritePixels(int[] pixels, int width, int height);

	@Import("It's coming home")
	int getDestinationX();

	@Import("It's coming home")
	int getDestinationY();

	@Import("It's coming home")
	RSSoundEffect[] getAudioEffects();

	@Import("It's coming home")
	int[] getQueuedSoundEffectIDs();

	@Import("It's coming home")
	int[] getSoundLocations();

	@Import("It's coming home")
	int[] getUnknownSoundValues1();

	@Import("It's coming home")
	int[] getUnknownSoundValues2();

	@Import("It's coming home")
	int getQueuedSoundEffectCount();

	@Import("It's coming home")
	void setQueuedSoundEffectCount(int queuedSoundEffectCount);

	@Import("It's coming home")
	@Override
	RSBufferProvider getBufferProvider();

	@Import("It's coming home")
	@Override
	int getMouseIdleTicks();

	@Import("It's coming home")
	@Override
	int getKeyboardIdleTicks();

	@Import("It's coming home")
	void setLowMemory(boolean lowMemory);

	@Import("It's coming home")
	void setRegionLowMemory(boolean lowMemory);

	@Import("It's coming home")
	void setAudioHighMemory(boolean highMemory);

	@Import("It's coming home")
	void setObjectCompositionLowDetail(boolean lowDetail);

	@Construct
	RSItem createItem();

	@Import("It's coming home")
	@Override
	int getIntStackSize();

	@Import("It's coming home")
	@Override
	void setIntStackSize(int stackSize);

	@Import("It's coming home")
	@Override
	int[] getIntStack();

	@Import("It's coming home")
	@Override
	int getStringStackSize();

	@Import("It's coming home")
	@Override
	void setStringStackSize(int stackSize);

	@Import("It's coming home")
	@Override
	String[] getStringStack();

	@Import("It's coming home")
	RSFriendManager getFriendManager();

	@Import("It's coming home")
	RSClanMemberManager getClanMemberManager();

	@Import("It's coming home")
	RSJagexLoginType getLoginType();

	@Construct
	RSName createName(String name, RSJagexLoginType type);

	@Import("It's coming home")
	int getVarbit(int varbitId);

	@Import("It's coming home")
	RSNodeCache getVarbitCache();

	@Import("It's coming home")
	@Override
	RSPreferences getPreferences();

	/**
	 * This is the pitch the user has set the camera to.
	 * It should be between 128 and (pitchUnlimiter?512:383) JAUs(1).
	 * The difference between this and cameraPitch is that cameraPitch has a lower limit, imposed by the surrounding
	 * terrain.
	 *
	 * (1) JAU - Jagex Angle Unit; 1/1024 of a revolution
	 */
	@Import("It's coming home")
	int getCameraPitchTarget();

	@Import("It's coming home")
	void setCameraPitchTarget(int pitch);

	@Import("It's coming home")
	void setPitchSin(int v);

	@Import("It's coming home")
	void setPitchCos(int v);

	@Import("It's coming home")
	int get3dZoom();

	@Import("It's coming home")
	void set3dZoom(int zoom);

	@Import("It's coming home")
	RSRenderOverview getRenderOverview();

	@Import("It's coming home")
	@Override
	void changeWorld(World world);

	@Construct
	@Override
	RSWorld createWorld();

	@Import("It's coming home")
	void setAnimOffsetX(int animOffsetX);

	@Import("It's coming home")
	void setAnimOffsetY(int animOffsetY);

	@Import("It's coming home")
	void setAnimOffsetZ(int animOffsetZ);

	@Import("It's coming home")
	RSFrames getFrames(int frameId);

	@Import("It's coming home")
	RSSpritePixels getMinimapSprite();

	@Import("It's coming home")
	void setMinimapSprite(SpritePixels spritePixels);

	@Import("It's coming home")
	void drawObject(int z, int x, int y, int randomColor1, int randomColor2);

	@Construct
	RSScriptEvent createScriptEvent();

	@Import("It's coming home")
	void runScript(RSScriptEvent ev, int ex);

	@Import("It's coming home")
	void setHintArrowTargetType(int value);

	@Import("It's coming home")
	int getHintArrowTargetType();

	@Import("It's coming home")
	void setHintArrowX(int value);

	@Import("It's coming home")
	int getHintArrowX();

	@Import("It's coming home")
	void setHintArrowY(int value);

	@Import("It's coming home")
	int getHintArrowY();

	@Import("It's coming home")
	void setHintArrowOffsetX(int value);

	@Import("It's coming home")
	void setHintArrowOffsetY(int value);

	@Import("It's coming home")
	void setHintArrowNpcTargetIdx(int value);

	@Import("It's coming home")
	int getHintArrowNpcTargetIdx();

	@Import("It's coming home")
	void setHintArrowPlayerTargetIdx(int value);

	@Import("It's coming home")
	int getHintArrowPlayerTargetIdx();

	@Import("It's coming home")
	@Override
	boolean isInInstancedRegion();

	@Import("It's coming home")
	int getItemPressedDuration();

	@Import("It's coming home")
	void setItemPressedDuration(int duration);

	@Import("It's coming home")
	int getFlags();

	@Import("It's coming home")
	void setCompass(SpritePixels spritePixels);

	@Import("It's coming home")
	RSNodeCache getWidgetSpriteCache();

	@Import("It's coming home")
	@Override
	void setOculusOrbState(int state);
}
