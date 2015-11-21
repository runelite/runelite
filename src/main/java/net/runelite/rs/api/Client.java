package net.runelite.rs.api;

public interface Client extends GameEngine
{
	int getCameraX();

	int getCameraY();

	int getCameraZ();

	int getPlane();

	int getCameraPitch();

	int getCameraYaw();

	int getWorld();

	int getFPS();

	int getMapScale();

	int getMapAngle();

	int[][][] getTileHeights();

	byte[][][] getTileSettings();

	int[] getSettings();

	int[] getWidgetSettings();

	int getEnergy();

	int getWeight();

	int getBaseX();

	int getBaseY();

	int[] getBoostedSkillLevels();

	int[] getRealSkillLevels();

	int[] getSkillExperiences();

	int getGameState();

	Widget[][] getWidgets();

	Region getRegion();

	Player getLocalPlayer();

	NPC[] getCachedNPCs();

	CollisionData[] getCollisionMaps();

	Player[] getCachedPlayers();

	Deque[][][] getGroundItemDeque();

	String getUsername();

	String[] getMenuActions();

	String[] getMenuOptions();

	Friend[] getFriends();

	Ignore[] getIgnores();

	World[] getWorldList();

	int getRootInterface();

	void setUsername(String var1);

	void sendGameMessage(int var1, String var2, String var3, int var4);

	void hopToWorld(String var1, int var2, int var3);

	ObjectComposition getObjectDefinition(int var1);

	void setScale(int var1);

	int getScale();

	int getCamera2();

	int getCamera3();

	boolean[] getValidInterfaces();

	boolean isResized();

	int[] getWidgetPositionsX();

	int[] getWidgetPositionsY();

	XHashTable getItemContainers();

	XHashTable getComponentTable();

	XGrandExchangeOffer[] getGrandExchangeOffers();

	Widget getActiveInterface();

	XClanMember[] getClanMembers();
}
