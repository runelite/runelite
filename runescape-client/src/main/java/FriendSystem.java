import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bf")
@Implements("FriendSystem")
public class FriendSystem {
	@ObfuscatedName("kp")
	@ObfuscatedGetter(
		intValue = 784647043
	)
	@Export("menuWidth")
	static int menuWidth;
	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "Lli;"
	)
	@Export("loginType")
	final LoginType loginType;
	@ObfuscatedName("r")
	@ObfuscatedSignature(
		signature = "Ljz;"
	)
	@Export("friendsList")
	public final FriendsList friendsList;
	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "Ljw;"
	)
	@Export("ignoreList")
	public final IgnoreList ignoreList;
	@ObfuscatedName("q")
	@ObfuscatedGetter(
		intValue = -154127357
	)
	int field1052;

	@ObfuscatedSignature(
		signature = "(Lli;)V"
	)
	FriendSystem(LoginType var1) {
		this.field1052 = 0;
		this.loginType = var1;
		this.friendsList = new FriendsList(var1);
		this.ignoreList = new IgnoreList(var1);
	}

	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "(I)Z",
		garbageValue = "-537546182"
	)
	boolean method1863() {
		return this.field1052 == 2;
	}

	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-1827488115"
	)
	final void method1864() {
		this.field1052 = 1;
	}

	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "(Lkl;II)V",
		garbageValue = "87159269"
	)
	@Export("readUpdate")
	final void readUpdate(Buffer var1, int var2) {
		this.friendsList.read(var1, var2);
		this.field1052 = 2;
		Coord.FriendSystem_invalidateFriends();
	}

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "1809100173"
	)
	@Export("processFriendUpdates")
	final void processFriendUpdates() {
		for (FriendLoginUpdate var1 = (FriendLoginUpdate)this.friendsList.friendLoginUpdates.last(); var1 != null; var1 = (FriendLoginUpdate)this.friendsList.friendLoginUpdates.previous()) {
			if ((long)var1.field3627 < class30.currentTimeMillis() / 1000L - 5L) {
				if (var1.world > 0) {
					class210.addGameMessage(5, "", var1.username + " has logged in.");
				}

				if (var1.world == 0) {
					class210.addGameMessage(5, "", var1.username + " has logged out.");
				}

				var1.remove();
			}
		}

	}

	@ObfuscatedName("r")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "2097335947"
	)
	@Export("clear")
	final void clear() {
		this.field1052 = 0;
		this.friendsList.clear();
		this.ignoreList.clear();
	}

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "(Ljq;ZI)Z",
		garbageValue = "-99546473"
	)
	@Export("isFriended")
	final boolean isFriended(Username var1, boolean var2) {
		if (var1 == null) {
			return false;
		} else if (var1.equals(class223.localPlayer.username)) {
			return true;
		} else {
			return this.friendsList.isFriended(var1, var2);
		}
	}

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "(Ljq;I)Z",
		garbageValue = "-1271048446"
	)
	@Export("isIgnored")
	final boolean isIgnored(Username var1) {
		if (var1 == null) {
			return false;
		} else {
			return this.ignoreList.contains(var1);
		}
	}

	@ObfuscatedName("m")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;I)V",
		garbageValue = "70213064"
	)
	@Export("addFriend")
	final void addFriend(String var1) {
		if (var1 != null) {
			Username var2 = new Username(var1, this.loginType);
			if (var2.hasCleanName()) {
				StringBuilder var10000;
				String var4;
				if (this.friendsListIsFull()) {
					var10000 = null;
					var4 = "Your friend list is full. Max of 200 for free users, and 400 for members";
					class210.addGameMessage(30, "", var4);
				} else if (class223.localPlayer.username.equals(var2)) {
					var10000 = null;
					var4 = "You can't add yourself to your own friend list";
					class210.addGameMessage(30, "", var4);
				} else {
					Object var10001;
					if (this.isFriended(var2, false)) {
						var10000 = (new StringBuilder()).append(var1);
						var10001 = null;
						var4 = var10000.append(" is already on your friend list").toString();
						class210.addGameMessage(30, "", var4);
					} else if (this.isIgnored(var2)) {
						var10000 = new StringBuilder();
						var10001 = null;
						var10000 = var10000.append("Please remove ").append(var1);
						var10001 = null;
						var4 = var10000.append(" from your ignore list first").toString();
						class210.addGameMessage(30, "", var4);
					} else {
						PacketBufferNode var3 = InterfaceParent.getPacketBufferNode(ClientPacket.field2264, Client.packetWriter.isaacCipher);
						var3.packetBuffer.writeByte(class268.stringCp1252NullTerminatedByteSize(var1));
						var3.packetBuffer.writeStringCp1252NullTerminated(var1);
						Client.packetWriter.addNode(var3);
					}
				}
			}
		}
	}

	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "(I)Z",
		garbageValue = "-414102513"
	)
	@Export("friendsListIsFull")
	final boolean friendsListIsFull() {
		return this.friendsList.isFull() || this.friendsList.getSize() >= 200 && Client.field636 != 1;
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;I)V",
		garbageValue = "1251138329"
	)
	@Export("addIgnore")
	final void addIgnore(String var1) {
		if (var1 != null) {
			Username var2 = new Username(var1, this.loginType);
			if (var2.hasCleanName()) {
				if (this.canAddIgnore()) {
					WorldMapCacheName.method644();
				} else {
					StringBuilder var10000;
					String var4;
					if (class223.localPlayer.username.equals(var2)) {
						var10000 = null;
						var4 = "You can't add yourself to your own ignore list";
						class210.addGameMessage(30, "", var4);
					} else {
						Object var10001;
						if (this.isIgnored(var2)) {
							var10000 = (new StringBuilder()).append(var1);
							var10001 = null;
							var4 = var10000.append(" is already on your ignore list").toString();
							class210.addGameMessage(30, "", var4);
						} else if (this.isFriended(var2, false)) {
							var10000 = new StringBuilder();
							var10001 = null;
							var10000 = var10000.append("Please remove ").append(var1);
							var10001 = null;
							var4 = var10000.append(" from your friend list first").toString();
							class210.addGameMessage(30, "", var4);
						} else {
							PacketBufferNode var3 = InterfaceParent.getPacketBufferNode(ClientPacket.field2279, Client.packetWriter.isaacCipher);
							var3.packetBuffer.writeByte(class268.stringCp1252NullTerminatedByteSize(var1));
							var3.packetBuffer.writeStringCp1252NullTerminated(var1);
							Client.packetWriter.addNode(var3);
						}
					}
				}
			}
		}
	}

	@ObfuscatedName("o")
	@ObfuscatedSignature(
		signature = "(S)Z",
		garbageValue = "30910"
	)
	@Export("canAddIgnore")
	final boolean canAddIgnore() {
		return this.ignoreList.isFull() || this.ignoreList.getSize() >= 100 && Client.field636 != 1;
	}

	@ObfuscatedName("a")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;I)V",
		garbageValue = "1378951166"
	)
	@Export("removeFriend")
	final void removeFriend(String var1) {
		if (var1 != null) {
			Username var2 = new Username(var1, this.loginType);
			if (var2.hasCleanName()) {
				if (this.friendsList.removeByUsername(var2)) {
					Client.field744 = Client.cycleCntr;
					PacketBufferNode var3 = InterfaceParent.getPacketBufferNode(ClientPacket.field2232, Client.packetWriter.isaacCipher);
					var3.packetBuffer.writeByte(class268.stringCp1252NullTerminatedByteSize(var1));
					var3.packetBuffer.writeStringCp1252NullTerminated(var1);
					Client.packetWriter.addNode(var3);
				}

				Coord.FriendSystem_invalidateFriends();
			}
		}
	}

	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;I)V",
		garbageValue = "-1989545258"
	)
	@Export("removeIgnore")
	final void removeIgnore(String var1) {
		if (var1 != null) {
			Username var2 = new Username(var1, this.loginType);
			if (var2.hasCleanName()) {
				if (this.ignoreList.removeByUsername(var2)) {
					Client.field744 = Client.cycleCntr;
					PacketBufferNode var3 = InterfaceParent.getPacketBufferNode(ClientPacket.field2268, Client.packetWriter.isaacCipher);
					var3.packetBuffer.writeByte(class268.stringCp1252NullTerminatedByteSize(var1));
					var3.packetBuffer.writeStringCp1252NullTerminated(var1);
					Client.packetWriter.addNode(var3);
				}

				class195.FriendSystem_invalidateIgnoreds();
			}
		}
	}

	@ObfuscatedName("h")
	@ObfuscatedSignature(
		signature = "(Ljq;I)Z",
		garbageValue = "869979117"
	)
	@Export("isFriendAndHasWorld")
	final boolean isFriendAndHasWorld(Username var1) {
		Friend var2 = (Friend)this.friendsList.getByUsername(var1);
		return var2 != null && var2.hasWorld();
	}
}
