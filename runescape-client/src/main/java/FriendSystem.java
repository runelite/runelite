import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bc")
@Implements("FriendSystem")
public class FriendSystem {
	@ObfuscatedName("qh")
	@ObfuscatedGetter(
		intValue = -1955536512
	)
	static int field1037;
	@ObfuscatedName("h")
	@ObfuscatedSignature(
		signature = "Lfk;"
	)
	@Export("clock")
	static Clock clock;
	@ObfuscatedName("g")
	@ObfuscatedSignature(
		signature = "Lll;"
	)
	@Export("loginType")
	final LoginType loginType;
	@ObfuscatedName("l")
	@ObfuscatedSignature(
		signature = "Ljx;"
	)
	@Export("friendsList")
	public final FriendsList friendsList;
	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "Lji;"
	)
	@Export("ignoreList")
	public final IgnoreList ignoreList;
	@ObfuscatedName("j")
	@ObfuscatedGetter(
		intValue = 1109899493
	)
	int field1034;

	@ObfuscatedSignature(
		signature = "(Lll;)V"
	)
	FriendSystem(LoginType var1) {
		this.field1034 = 0;
		this.loginType = var1;
		this.friendsList = new FriendsList(var1);
		this.ignoreList = new IgnoreList(var1);
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(I)Z",
		garbageValue = "1338647349"
	)
	boolean method1825() {
		return this.field1034 == 2;
	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "1"
	)
	final void method1856() {
		this.field1034 = 1;
	}

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(Lkz;IB)V",
		garbageValue = "0"
	)
	@Export("readUpdate")
	final void readUpdate(Buffer var1, int var2) {
		this.friendsList.read(var1, var2);
		this.field1034 = 2;
		WallDecoration.FriendSystem_invalidateFriends();
	}

	@ObfuscatedName("g")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-916004239"
	)
	@Export("processFriendUpdates")
	final void processFriendUpdates() {
		for (FriendLoginUpdate var1 = (FriendLoginUpdate)this.friendsList.friendLoginUpdates.last(); var1 != null; var1 = (FriendLoginUpdate)this.friendsList.friendLoginUpdates.previous()) {
			if ((long)var1.field3613 < SoundCache.method2480() / 1000L - 5L) {
				if (var1.world > 0) {
					WorldMapCacheName.addGameMessage(5, "", var1.username + " has logged in.");
				}

				if (var1.world == 0) {
					WorldMapCacheName.addGameMessage(5, "", var1.username + " has logged out.");
				}

				var1.remove();
			}
		}

	}

	@ObfuscatedName("l")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "299049416"
	)
	@Export("clear")
	final void clear() {
		this.field1034 = 0;
		this.friendsList.clear();
		this.ignoreList.clear();
	}

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "(Ljt;ZI)Z",
		garbageValue = "1657738118"
	)
	@Export("isFriended")
	final boolean isFriended(Username var1, boolean var2) {
		if (var1 == null) {
			return false;
		} else if (var1.equals(Varps.localPlayer.username)) {
			return true;
		} else {
			return this.friendsList.isFriended(var1, var2);
		}
	}

	@ObfuscatedName("j")
	@ObfuscatedSignature(
		signature = "(Ljt;I)Z",
		garbageValue = "2143942402"
	)
	@Export("isIgnored")
	final boolean isIgnored(Username var1) {
		if (var1 == null) {
			return false;
		} else {
			return this.ignoreList.contains(var1);
		}
	}

	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;I)V",
		garbageValue = "365133706"
	)
	@Export("addFriend")
	final void addFriend(String var1) {
		if (var1 != null) {
			Username var2 = new Username(var1, this.loginType);
			if (var2.hasCleanName()) {
				if (this.friendsListIsFull()) {
					WorldMapSection2.method283("Your friend list is full. Max of 200 for free users, and 400 for members");
				} else if (Varps.localPlayer.username.equals(var2)) {
					class1.method9();
				} else if (this.isFriended(var2, false)) {
					Calendar.method3933(var1);
				} else if (this.isIgnored(var2)) {
					WorldMapSection2.method283("Please remove " + var1 + " from your ignore list first");
				} else {
					WorldMapLabelSize.method172(var1);
				}
			}
		}
	}

	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "(I)Z",
		garbageValue = "-567390482"
	)
	@Export("friendsListIsFull")
	final boolean friendsListIsFull() {
		return this.friendsList.isFull() || this.friendsList.getSize() >= 200 && Client.field739 != 1;
	}

	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;I)V",
		garbageValue = "-1635625891"
	)
	@Export("addIgnore")
	final void addIgnore(String var1) {
		if (var1 != null) {
			Username var2 = new Username(var1, this.loginType);
			if (var2.hasCleanName()) {
				if (this.canAddIgnore()) {
					WorldMapSection2.method283("Your ignore list is full. Max of 100 for free users, and 400 for members");
				} else if (Varps.localPlayer.username.equals(var2)) {
					Huffman.method3943();
				} else if (this.isIgnored(var2)) {
					WorldMapSection2.method283(var1 + " is already on your ignore list");
				} else if (this.isFriended(var2, false)) {
					WorldMapSection2.method283("Please remove " + var1 + " from your friend list first");
				} else {
					PacketBufferNode var3 = MenuAction.getPacketBufferNode(ClientPacket.field2274, Client.packetWriter.isaacCipher);
					var3.packetBuffer.writeByte(Varcs.stringCp1252NullTerminatedByteSize(var1));
					var3.packetBuffer.writeStringCp1252NullTerminated(var1);
					Client.packetWriter.addNode(var3);
				}
			}
		}
	}

	@ObfuscatedName("r")
	@ObfuscatedSignature(
		signature = "(B)Z",
		garbageValue = "-41"
	)
	@Export("canAddIgnore")
	final boolean canAddIgnore() {
		return this.ignoreList.isFull() || this.ignoreList.getSize() >= 100 && Client.field739 != 1;
	}

	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;B)V",
		garbageValue = "73"
	)
	@Export("removeFriend")
	final void removeFriend(String var1) {
		if (var1 != null) {
			Username var2 = new Username(var1, this.loginType);
			if (var2.hasCleanName()) {
				if (this.friendsList.removeByUsername(var2)) {
					GrandExchangeEvents.method66();
					PacketBufferNode var3 = MenuAction.getPacketBufferNode(ClientPacket.field2281, Client.packetWriter.isaacCipher);
					var3.packetBuffer.writeByte(Varcs.stringCp1252NullTerminatedByteSize(var1));
					var3.packetBuffer.writeStringCp1252NullTerminated(var1);
					Client.packetWriter.addNode(var3);
				}

				WallDecoration.FriendSystem_invalidateFriends();
			}
		}
	}

	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;S)V",
		garbageValue = "257"
	)
	@Export("removeIgnore")
	final void removeIgnore(String var1) {
		if (var1 != null) {
			Username var2 = new Username(var1, this.loginType);
			if (var2.hasCleanName()) {
				if (this.ignoreList.removeByUsername(var2)) {
					GrandExchangeEvents.method66();
					PacketBufferNode var3 = MenuAction.getPacketBufferNode(ClientPacket.field2273, Client.packetWriter.isaacCipher);
					var3.packetBuffer.writeByte(Varcs.stringCp1252NullTerminatedByteSize(var1));
					var3.packetBuffer.writeStringCp1252NullTerminated(var1);
					Client.packetWriter.addNode(var3);
				}

				HealthBarUpdate.FriendSystem_invalidateIgnoreds();
			}
		}
	}

	@ObfuscatedName("o")
	@ObfuscatedSignature(
		signature = "(Ljt;I)Z",
		garbageValue = "-1345116753"
	)
	@Export("isFriendAndHasWorld")
	final boolean isFriendAndHasWorld(Username var1) {
		Friend var2 = (Friend)this.friendsList.getByUsername(var1);
		return var2 != null && var2.hasWorld();
	}

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "591224258"
	)
	public static void method1871() {
		if (KeyHandler.KeyHandler_instance != null) {
			synchronized(KeyHandler.KeyHandler_instance) {
				KeyHandler.KeyHandler_instance = null;
			}
		}

	}

	@ObfuscatedName("ih")
	@ObfuscatedSignature(
		signature = "(II)Ljava/lang/String;",
		garbageValue = "-1994917329"
	)
	@Export("formatItemStacks")
	static final String formatItemStacks(int var0) {
		String var1 = Integer.toString(var0);

		for (int var2 = var1.length() - 3; var2 > 0; var2 -= 3) {
			var1 = var1.substring(0, var2) + "," + var1.substring(var2);
		}

		if (var1.length() > 9) {
			return " " + UserComparator7.colorStartTag(65408) + var1.substring(0, var1.length() - 8) + "M" + " " + " (" + var1 + ")" + "</col>";
		} else {
			return var1.length() > 6 ? " " + UserComparator7.colorStartTag(16777215) + var1.substring(0, var1.length() - 4) + "K" + " " + " (" + var1 + ")" + "</col>" : " " + UserComparator7.colorStartTag(16776960) + var1 + "</col>";
		}
	}

	@ObfuscatedName("ip")
	@ObfuscatedSignature(
		signature = "(ZB)V",
		garbageValue = "71"
	)
	@Export("setTapToDrop")
	static void setTapToDrop(boolean var0) {
		Client.tapToDrop = var0;
	}
}
