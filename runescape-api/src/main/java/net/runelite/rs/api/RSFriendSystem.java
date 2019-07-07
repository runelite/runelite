package net.runelite.rs.api;

import net.runelite.api.FriendManager;
import net.runelite.mapping.Import;

public interface RSFriendSystem extends FriendManager
{
	@Import("friendsList")
	RSFriendsList getFriendContainer();

	@Import("ignoreList")
	RSIgnoreList getIgnoreContainer();

	@Import("isFriended")
	boolean isFriended(RSUsername var1, boolean var2);

	@Import("addFriend")
	void addFriend(String username);

	@Import("removeFriend")
	void removeFriend(String username);
}
