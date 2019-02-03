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
import net.runelite.api.SpritePixels;
import net.runelite.api.World;
import net.runelite.api.widgets.Widget;
import net.runelite.mapping.Construct;
import net.runelite.mapping.Import;
import net.runelite.mapping.Protect;

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

	@Import("cameraX2")
	@Override
	int getCameraX2();

	@Import("cameraY2")
	@Override
	int getCameraY2();

	@Import("cameraZ2")
	@Override
	int getCameraZ2();

	@Import("plane")
	@Override
	int getPlane();

	@Import("cameraPitch")
	@Override
	int getCameraPitch();

	@Import("cameraPitch")
	void setCameraPitch(int cameraPitch);

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

	@Import("clientVarps")
	@Override
	int[] getVarps();

	@Import("varcs")
	RSVarcs getVarcs();

	@Import("energy")
	@Override
	int getEnergy();

	@Import("weight")
	@Override
	int getWeight();

	@Import("baseX")
	@Override
	int getBaseX();

	@Import("baseY")
	@Override
	int getBaseY();

	@Import("boostedSkillLevels")
	@Override
	int[] getBoostedSkillLevels();

	@Import("realSkillLevels")
	@Override
	int[] getRealSkillLevels();

	@Import("skillExperiences")
	@Override
	int[] getSkillExperiences();

	@Import("changedSkills")
	int[] getChangedSkills();

	@Import("changedSkillsCount")
	int getChangedSkillsCount();

	@Import("changedSkillsCount")
	void setChangedSkillsCount(int i);

	@Import("gameState")
	int getRSGameState();

	@Import("checkClick")
	@Override
	void setCheckClick(boolean checkClick);

	@Import("mouseX2")
	void setMouseCanvasHoverPositionX(int x);

	@Import("mouseY2")
	void setMouseCanvasHoverPositionY(int y);

	@Import("mouseCurrentButton")
	@Override
	int getMouseCurrentButton();

	@Import("selectedSceneTileX")
	int getSelectedSceneTileX();

	@Import("selectedSceneTileX")
	void setSelectedSceneTileX(int selectedSceneTileX);

	@Import("selectedSceneTileY")
	int getSelectedSceneTileY();

	@Import("selectedSceneTileY")
	void setSelectedSceneTileY(int selectedSceneTileY);

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

	/**
	 * Gets an array of widgets that correspond to the passed group ID.
	 *
	 * @param groupId the group ID
	 * @return the widget group
	 * @see net.runelite.api.widgets.WidgetID
	 */
	RSWidget[] getGroup(int groupId);

	@Import("scene")
	@Override
	RSScene getScene();

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
	@Override
	RSPlayer[] getCachedPlayers();

	@Import("localInteractingIndex")
	int getLocalInteractingIndex();

	@Import("groundItemDeque")
	RSDeque[][][] getGroundItemDeque();

	@Import("projectiles")
	RSDeque getProjectilesDeque();

	@Import("graphicsObjectDeque")
	RSDeque getGraphicsObjectDeque();

	@Import("username")
	@Override
	String getUsername();

	@Import("username")
	@Override
	void setUsername(String username);

	@Import("password")
	@Override
	void setPassword(String password);

	@Import("currentLoginField")
	@Override
	int getCurrentLoginField();

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

	@Import("mouseX2")
	int getMouseX2();

	@Import("mouseY2")
	int getMouseY2();

	@Import("containsBounds")
	boolean containsBounds(int var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7);

	@Import("checkClick")
	boolean isCheckClick();

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

	@Import("menuForceLeftClick")
	boolean[] getMenuForceLeftClick();

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

	@Import("canvasHeight")
	@Override
	int getCanvasHeight();

	@Import("canvasWidth")
	@Override
	int getCanvasWidth();

	@Import("viewportHeight")
	@Override
	int getViewportHeight();

	@Import("viewportWidth")
	@Override
	int getViewportWidth();

	@Import("Viewport_xOffset")
	@Override
	int getViewportXOffset();

	@Import("Viewport_yOffset")
	@Override
	int getViewportYOffset();

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

	@Import("decodeSprite")
	void decodeSprite(byte[] data);

	@Import("indexedSpriteCount")
	int getIndexedSpriteCount();

	@Import("indexedSpriteWidth")
	int getIndexedSpriteWidth();

	@Import("indexedSpriteHeight")
	int getIndexedSpriteHeight();

	@Import("indexedSpriteOffsetXs")
	int[] getIndexedSpriteOffsetXs();

	@Import("indexedSpriteOffsetXs")
	void setIndexedSpriteOffsetXs(int[] indexedSpriteOffsetXs);

	@Import("indexedSpriteOffsetYs")
	int[] getIndexedSpriteOffsetYs();

	@Import("indexedSpriteOffsetYs")
	void setIndexedSpriteOffsetYs(int[] indexedSpriteOffsetYs);

	@Import("indexSpriteWidths")
	int[] getIndexSpriteWidths();

	@Import("indexSpriteWidths")
	void setIndexSpriteWidths(int[] indexSpriteWidths);

	@Import("indexedSpriteHeights")
	int[] getIndexedSpriteHeights();

	@Import("indexedSpriteHeights")
	void setIndexedSpriteHeights(int[] indexedSpriteHeights);

	@Import("spritePixels")
	byte[][] getSpritePixels();

	@Import("spritePixels")
	void setSpritePixels(byte[][] spritePixels);

	@Import("indexedSpritePalette")
	int[] getIndexedSpritePalette();

	@Import("indexedSpritePalette")
	void setIndexSpritePalette(int[] indexSpritePalette);

	@Import("indexSprites")
	@Override
	RSIndexDataBase getIndexSprites();

	@Import("indexScripts")
	@Override
	RSIndexDataBase getIndexScripts();

	@Import("widgetFlags")
	@Override
	RSHashTable getWidgetFlags();

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

	@Import("messages")
	@Override
	RSIterableHashTable getMessages();

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

	@Import("mapElementConfigs")
	@Override
	RSMapElementConfig[] getMapElementConfigs();

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

	@Import("queuedSoundEffectDelays")
	int[] getQueuedSoundEffectDelays();

	@Import("queuedSoundEffectCount")
	int getQueuedSoundEffectCount();

	@Import("queuedSoundEffectCount")
	void setQueuedSoundEffectCount(int queuedSoundEffectCount);

	@Import("rasterProvider")
	@Override
	RSBufferProvider getBufferProvider();

	@Import("mouseIdleTicks")
	@Override
	int getMouseIdleTicks();

	@Import("mouseLastPressedTimeMillis")
	@Override
	long getMouseLastPressedMillis();

	@Import("keyboardIdleTicks")
	@Override
	int getKeyboardIdleTicks();

	@Import("lowMemory")
	void setLowMemory(boolean lowMemory);

	@Import("sceneLowMemory")
	void setSceneLowMemory(boolean lowMemory);

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

	@Import("yawSin")
	void setYawSin(int v);

	@Import("yawCos")
	void setYawCos(int v);

	@Import("Rasterizer3D_zoom")
	@Override
	int get3dZoom();

	@Import("Rasterizer3D_zoom")
	void set3dZoom(int zoom);

	@Import("Rasterizer3D_clipMidX2")
	@Override
	int getRasterizer3D_clipMidX2();

	@Import("Rasterizer3D_clipNegativeMidX")
	@Override
	int getRasterizer3D_clipNegativeMidX();

	@Import("Rasterizer3D_clipNegativeMidY")
	@Override
	int getRasterizer3D_clipNegativeMidY();

	@Import("Rasterizer3D_clipMidY2")
	@Override
	int getRasterizer3D_clipMidY2();

	@Import("centerX")
	@Override
	int getCenterX();

	@Import("centerY")
	@Override
	int getCenterY();

	@Import("renderOverview")
	RSRenderOverview getRenderOverview();

	@Import("changeWorld")
	@Override
	void changeWorld(World world);

	@Construct
	@Override
	RSWorld createWorld();

	@Import("animOffsetX")
	void setAnimOffsetX(int animOffsetX);

	@Import("animOffsetY")
	void setAnimOffsetY(int animOffsetY);

	@Import("animOffsetZ")
	void setAnimOffsetZ(int animOffsetZ);

	@Import("getFrames")
	RSFrames getFrames(int frameId);

	@Import("minimapSprite")
	RSSpritePixels getMinimapSprite();

	@Import("minimapSprite")
	void setMinimapSprite(SpritePixels spritePixels);

	@Import("drawObject")
	void drawObject(int z, int x, int y, int randomColor1, int randomColor2);

	@Construct
	RSScriptEvent createScriptEvent();

	@Import("runScript")
	void runScript(RSScriptEvent ev, int ex);

	@Import("hintArrowTargetType")
	void setHintArrowTargetType(int value);

	@Import("hintArrowTargetType")
	int getHintArrowTargetType();

	@Import("hintArrowX")
	void setHintArrowX(int value);

	@Import("hintArrowX")
	int getHintArrowX();

	@Import("hintArrowY")
	void setHintArrowY(int value);

	@Import("hintArrowY")
	int getHintArrowY();

	@Import("hintArrowOffsetX")
	void setHintArrowOffsetX(int value);

	@Import("hintArrowOffsetY")
	void setHintArrowOffsetY(int value);

	@Import("hintArrowNpcTargetIdx")
	void setHintArrowNpcTargetIdx(int value);

	@Import("hintArrowNpcTargetIdx")
	int getHintArrowNpcTargetIdx();

	@Import("hintArrowPlayerTargetIdx")
	void setHintArrowPlayerTargetIdx(int value);

	@Import("hintArrowPlayerTargetIdx")
	int getHintArrowPlayerTargetIdx();

	@Import("isDynamicRegion")
	@Override
	boolean isInInstancedRegion();

	@Import("itemPressedDuration")
	int getItemPressedDuration();

	@Import("itemPressedDuration")
	void setItemPressedDuration(int duration);

	@Import("flags")
	int getFlags();

	@Import("compass")
	void setCompass(SpritePixels spritePixels);

	@Import("widgetSpriteCache")
	@Override
	RSNodeCache getWidgetSpriteCache();

	@Import("oculusOrbState")
	@Override
	int getOculusOrbState();

	@Import("oculusOrbState")
	@Override
	void setOculusOrbState(int state);

	@Import("oculusOrbNormalSpeed")
	@Override
	void setOculusOrbNormalSpeed(int state);

	@Import("lookingAtX")
	@Override
	int getOculusOrbFocalPointX();

	@Import("lookingAtY")
	@Override
	int getOculusOrbFocalPointY();

	RSItem getLastItemDespawn();

	void setLastItemDespawn(RSItem lastItemDespawn);

	@Construct
	RSWidget createWidget();

	@Import("revalidateWidget")
	void revalidateWidget(Widget w);

	@Import("revalidateWidgetScroll")
	void revalidateWidgetScroll(Widget[] group, Widget w, boolean postEvent);

	@Import("menuAction")
	@Protect
	void menuAction(int var0, int var1, int var2, int var3, String var4, String var5, int var6, int var7);

	@Import("Viewport_entityCountAtMouse")
	int getEntitiesAtMouseCount();

	@Import("Viewport_entityCountAtMouse")
	void setEntitiesAtMouseCount(int i);

	@Import("Viewport_entitiesAtMouse")
	long[] getEntitiesAtMouse();

	@Import("Viewport_mouseX")
	int getViewportMouseX();

	@Import("Viewport_mouseY")
	int getViewportMouseY();

	@Import("textureProvider")
	@Override
	RSTextureProvider getTextureProvider();

	@Import("occupiedTilesTick")
	int[][] getOccupiedTilesTick();

	@Import("cachedModels2")
	RSNodeCache getCachedModels2();

	@Import("cycle")
	int getCycle();

	@Import("cycle")
	void setCycle(int cycle);

	@Import("visibilityMaps")
	boolean[][][][] getVisibilityMaps();

	@Import("renderArea")
	void setRenderArea(boolean[][] renderArea);

	@Import("cameraX2")
	void setCameraX2(int cameraX2);

	@Import("cameraY2")
	void setCameraY2(int cameraY2);

	@Import("cameraZ2")
	void setCameraZ2(int cameraZ2);

	@Import("screenCenterX")
	void setScreenCenterX(int screenCenterX);

	@Import("screenCenterZ")
	void setScreenCenterZ(int screenCenterZ);

	@Import("Scene_plane")
	void setScenePlane(int scenePlane);

	@Import("minTileX")
	void setMinTileX(int i);

	@Import("minTileZ")
	void setMinTileZ(int i);

	@Import("maxTileX")
	void setMaxTileX(int i);

	@Import("maxTileZ")
	void setMaxTileZ(int i);

	@Import("tileUpdateCount")
	int getTileUpdateCount();

	@Import("tileUpdateCount")
	void setTileUpdateCount(int tileUpdateCount);

	@Import("Viewport_containsMouse")
	boolean getViewportContainsMouse();

	@Import("graphicsPixels")
	int[] getGraphicsPixels();

	@Import("graphicsPixelsWidth")
	int getGraphicsPixelsWidth();

	@Import("graphicsPixelsHeight")
	int getGraphicsPixelsHeight();

	@Import("fillRectangle")
	void RasterizerFillRectangle(int x, int y, int w, int h, int rgb);

	@Import("startX")
	int getStartX();

	@Import("startY")
	int getStartY();

	@Import("endX")
	int getEndX();

	@Import("endY")
	int getEndY();
}
