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
import net.runelite.api.BufferProvider;
import net.runelite.api.Client;
import net.runelite.api.World;
import net.runelite.api.widgets.Widget;
import net.runelite.mapping.Construct;
import net.runelite.mapping.Import;

public interface RSClient extends RSGameEngine, Client
{
	@Import("cameraX")
	@Override
	int getCameraX();

	@Import("cameraY")
	@Override
	int getCameraY();

	@Import("cameraZ")
	@Override
	int getCameraZ();

	@Import("plane")
	@Override
	int getPlane();

	@Import("cameraPitch")
	@Override
	int getCameraPitch();

	@Import("cameraYaw")
	@Override
	int getCameraYaw();

	@Import("world")
	int getWorld();

	@Import("FPS")
	@Override
	int getFPS();

	@Import("mapAngle")
	@Override
	int getMapAngle();

	@Import("tileHeights")
	@Override
	int[][][] getTileHeights();

	@Import("tileSettings")
	@Override
	byte[][][] getTileSettings();

	@Import("settings")
	@Override
	int[] getSettings();

	@Import("widgetSettings")
	@Override
	int[] getWidgetSettings();

	@Import("energy")
	@Override
	int getEnergy();

	@Import("weight")
	int getWeight();

	@Import("baseX")
	@Override
	int getBaseX();

	@Import("baseY")
	@Override
	int getBaseY();

	@Import("boostedSkillLevels")
	int[] getBoostedSkillLevels();

	@Import("realSkillLevels")
	int[] getRealSkillLevels();

	@Import("skillExperiences")
	int[] getSkillExperiences();

	@Import("gameState")
	int getRSGameState();

	@Import("mouseCurrentButton")
	@Override
	int getMouseCurrentButton();

	@Import("draggingWidget")
	@Override
	boolean isDraggingWidget();

	@Import("draggedWidget")
	@Override
	RSWidget getDraggedWidget();

	@Import("draggedOnWidget")
	@Override
	RSWidget getDraggedOnWidget();

	@Import("draggedOnWidget")
	@Override
	void setDraggedOnWidget(Widget widget);

	@Import("widgets")
	RSWidget[][] getWidgets();

	@Import("region")
	@Override
	RSRegion getRegion();

	@Import("localPlayer")
	@Override
	RSPlayer getLocalPlayer();

	@Import("npcIndexesCount")
	int getNpcIndexesCount();

	@Import("npcIndices")
	int[] getNpcIndices();

	@Import("cachedNPCs")
	@Override
	RSNPC[] getCachedNPCs();

	@Import("collisionMaps")
	RSCollisionData[] getCollisionMaps();

	@Import("playerIndexesCount")
	int getPlayerIndexesCount();

	@Import("playerIndices")
	int[] getPlayerIndices();

	@Import("cachedPlayers")
	RSPlayer[] getCachedPlayers();

	@Import("localInteractingIndex")
	int getLocalInteractingIndex();

	@Import("groundItemDeque")
	RSDeque[][][] getGroundItemDeque();

	@Import("projectiles")
	RSDeque getProjectilesDeque();

	@Import("username")
	@Override
	String getUsername();

	@Import("username")
	@Override
	void setUsername(String username);

	@Import("playerOptions")
	@Override
	String[] getPlayerOptions();

	@Import("playerOptionsPriorities")
	@Override
	boolean[] getPlayerOptionsPriorities();

	@Import("playerMenuTypes")
	@Override
	int[] getPlayerMenuTypes();

	@Import("mouseX")
	int getMouseX();

	@Import("mouseY")
	int getMouseY();

	@Import("menuOptionCount")
	int getMenuOptionCount();

	@Import("menuOptionCount")
	void setMenuOptionCount(int menuOptionCount);

	@Import("menuOptions")
	String[] getMenuOptions();

	@Import("menuTargets")
	String[] getMenuTargets();

	@Import("menuIdentifiers")
	int[] getMenuIdentifiers();

	@Import("menuTypes")
	int[] getMenuTypes();

	@Import("menuActionParams0")
	int[] getMenuActionParams0();

	@Import("menuActionParams1")
	int[] getMenuActionParams1();

	@Import("worldList")
	@Override
	RSWorld[] getWorldList();

	@Import("addChatMessage")
	void addChatMessage(int type, String name, String message, String sender);

	@Override
	@Import("getObjectDefinition")
	RSObjectComposition getObjectDefinition(int objectId);

	@Override
	@Import("getNpcDefinition")
	RSNPCComposition getNpcDefinition(int npcId);

	@Import("scale")
	@Override
	int getScale();

	@Import("viewportHeight")
	@Override
	int getViewportHeight();

	@Import("viewportWidth")
	@Override
	int getViewportWidth();

	@Import("isResized")
	@Override
	boolean isResized();

	@Import("widgetPositionX")
	@Override
	int[] getWidgetPositionsX();

	@Import("widgetPositionY")
	@Override
	int[] getWidgetPositionsY();

	@Import("itemContainers")
	RSHashTable getItemContainers();

	@Import("getItemDefinition")
	@Override
	RSItemComposition getItemDefinition(int itemId);

	@Import("createSprite")
	RSSpritePixels createItemSprite(int itemId, int quantity, int thickness, int borderColor, int stackable, boolean noted);

	@Import("componentTable")
	@Override
	RSHashTable getComponentTable();

	@Import("grandExchangeOffers")
	RSGrandExchangeOffer[] getGrandExchangeOffers();

	@Import("isMenuOpen")
	@Override
	boolean isMenuOpen();

	@Import("gameCycle")
	@Override
	int getGameCycle();

	@Import("packetHandler")
	void packetHandler();

	@Import("chatLineMap")
	@Override
	Map getChatLineMap();

	@Import("revision")
	@Override
	int getRevision();

	@Import("mapRegions")
	@Override
	int[] getMapRegions();

	@Import("instanceTemplateChunks")
	@Override
	int[][][] getInstanceTemplateChunks();

	@Import("xteaKeys")
	@Override
	int[][] getXteaKeys();

	@Import("gameDrawingMode")
	@Override
	int getGameDrawingMode();

	@Import("gameDrawingMode")
	@Override
	void setGameDrawingMode(int gameDrawingMode);

	@Import("cycleCntr")
	int getCycleCntr();

	@Import("chatCycle")
	void setChatCycle(int value);

	/**
	 * Get the widget top group. widgets[topGroup] contains widgets with
	 * parentId -1, which are the widget roots.
	 *
	 * @return
	 */
	@Import("widgetRoot")
	int getWidgetRoot();

	@Import("mapAreaType")
	@Override
	RSArea[] getMapAreas();

	@Import("mapscene")
	@Override
	RSIndexedSprite[] getMapScene();

	@Import("mapIcons")
	@Override
	RSSpritePixels[] getMapIcons();

	@Import("mapDots")
	RSSpritePixels[] getMapDots();

	@Import("modIcons")
	@Override
	RSIndexedSprite[] getModIcons();

	@Import("modIcons")
	void setRSModIcons(RSIndexedSprite[] modIcons);

	@Construct
	@Override
	RSIndexedSprite createIndexedSprite();

	@Construct
	@Override
	RSSpritePixels createSpritePixels(int[] pixels, int width, int height);

	@Import("destinationX")
	int getDestinationX();

	@Import("destinationY")
	int getDestinationY();

	@Import("audioEffects")
	RSSoundEffect[] getAudioEffects();

	@Import("queuedSoundEffectIDs")
	int[] getQueuedSoundEffectIDs();

	@Import("soundLocations")
	int[] getSoundLocations();

	@Import("unknownSoundValues1")
	int[] getUnknownSoundValues1();

	@Import("unknownSoundValues2")
	int[] getUnknownSoundValues2();

	@Import("queuedSoundEffectCount")
	int getQueuedSoundEffectCount();

	@Import("queuedSoundEffectCount")
	void setQueuedSoundEffectCount(int queuedSoundEffectCount);

	@Import("drawBoundingBoxes2D")
	@Override
	boolean getDrawBoundingBoxes2D();

	@Import("drawBoundingBoxes2D")
	@Override
	void setDrawBoundingBoxes2D(boolean shouldDraw);

	@Import("drawBoundingBoxes3D")
	@Override
	boolean getDrawBoundingBoxes3D();

	@Import("drawBoundingBoxes3D")
	@Override
	void setDrawBoundingBoxes3D(boolean shouldDraw);

	@Import("drawObjectGeometry2D")
	@Override
	boolean getdrawObjectGeometry2D();

	@Import("drawObjectGeometry2D")
	@Override
	void setdrawObjectGeometry2D(boolean shouldDraw);

	@Import("boundingBox3DDrawMode")
	RSBoundingBox3DDrawMode getboundingBox3DDrawMode();

	@Import("boundingBox3DDrawMode")
	void setboundingBox3DDrawMode(RSBoundingBox3DDrawMode drawMode);

	@Import("ON_MOUSEOVER")
	RSBoundingBox3DDrawMode getON_MOUSEOVERDrawMode();

	@Import("ALWAYS")
	RSBoundingBox3DDrawMode getALWAYSDrawMode();

	@Import("rasterProvider")
	@Override
	BufferProvider getBufferProvider();

	@Import("mouseIdleTicks")
	@Override
	int getMouseIdleTicks();

	@Import("keyboardIdleTicks")
	@Override
	int getKeyboardIdleTicks();

	@Import("lowMemory")
	void setLowMemory(boolean lowMemory);

	@Import("regionLowMemory")
	void setRegionLowMemory(boolean lowMemory);

	@Import("audioHighMemory")
	void setAudioHighMemory(boolean highMemory);

	@Import("objectCompositionLowDetail")
	void setObjectCompositionLowDetail(boolean lowDetail);

	@Construct
	RSItem createItem();

	@Import("intStackSize")
	@Override
	int getIntStackSize();

	@Import("intStackSize")
	@Override
	void setIntStackSize(int stackSize);

	@Import("intStack")
	@Override
	int[] getIntStack();

	@Import("scriptStringStackSize")
	@Override
	int getStringStackSize();

	@Import("scriptStringStackSize")
	@Override
	void setStringStackSize(int stackSize);

	@Import("scriptStringStack")
	@Override
	String[] getStringStack();

	@Import("friendManager")
	RSFriendManager getFriendManager();

	@Import("clanMemberManager")
	RSClanMemberManager getClanMemberManager();

	@Import("loginType")
	RSJagexLoginType getLoginType();

	@Construct
	RSName createName(String name, RSJagexLoginType type);

	@Import("getVarbit")
	int getVarbit(int varbitId);

	@Import("varbits")
	RSNodeCache getVarbitCache();

	@Import("preferences")
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
	@Import("cameraPitchTarget")
	int getCameraPitchTarget();

	@Import("cameraPitchTarget")
	void setCameraPitchTarget(int pitch);

	@Import("pitchSin")
	void setPitchSin(int v);

	@Import("pitchCos")
	void setPitchCos(int v);

	@Import("Rasterizer3D_zoom")
	int get3dZoom();

	@Import("Rasterizer3D_zoom")
	void set3dZoom(int zoom);

	@Import("renderOverview")
	RSRenderOverview getRenderOverview();

	@Import("changeWorld")
	@Override
	void changeWorld(World world);

	@Construct
	@Override
	RSWorld createWorld();
}
