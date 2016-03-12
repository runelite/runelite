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

	@Import("mapScale")
	int getMapScale();

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

	@Import("menuActions")
	String[] getMenuActions();

	@Import("menuTargets")
	String[] getMenuTargets();

	@Import("menuOptions")
	String[] getMenuOptions();

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

	@Import("rootInterface")
	int getRootInterface();

	//void setUsername(String var1);

	//void sendGameMessage(int var1, String var2, String var3, int var4);

	//void hopToWorld(String var1, int var2, int var3);

	@Import("objectDefinition")
	ObjectComposition getObjectDefinition(int var1);

	//void setScale(int var1);

	@Import("scale")
	int getScale();

	@Import("camera2")
	int getCamera2();

	@Import("camera3")
	int getCamera3();

	@Import("validInterfaces")
	boolean[] getValidInterfaces();

	@Import("isResized")
	boolean isResized();

	@Import("widgetPositionX")
	int[] getWidgetPositionsX();

	@Import("widgetPositionY")
	int[] getWidgetPositionsY();

	@Import("itemContainers")
	XHashTable getItemContainers();

	@Import("componentTable")
	XHashTable getComponentTable();

	@Import("grandExchangeOffers")
	XGrandExchangeOffer[] getGrandExchangeOffers();

	@Import("activeInterface")
	Widget getActiveInterface();

	@Import("clanMembers")
	XClanMember[] getClanMembers();

	@Import("isMenuOpen")
	boolean isMenuOpen();

	@Import("packetOpcode")
	int getPacketOpcode();

	@Import("gameCycle")
	int getGameCycle();

	@Import("packetHandler")
	void packetHandler();
}
