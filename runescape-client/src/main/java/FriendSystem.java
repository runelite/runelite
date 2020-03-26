import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("co")
@Implements("FriendSystem")
public class FriendSystem {
	@ObfuscatedName("u")
	static int[] field1086;
	@ObfuscatedName("d")
	@ObfuscatedSignature(
		signature = "Lmx;"
	)
	@Export("loginType")
	final LoginType loginType;
	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "Lkr;"
	)
	@Export("friendsList")
	public final FriendsList friendsList;
	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "Ljb;"
	)
	@Export("ignoreList")
	public final IgnoreList ignoreList;
	@ObfuscatedName("q")
	@ObfuscatedGetter(
		intValue = 429745001
	)
	int field1092;

	@ObfuscatedSignature(
		signature = "(Lmx;)V"
	)
	FriendSystem(LoginType var1) {
		this.field1092 = 0;
		this.loginType = var1;
		this.friendsList = new FriendsList(var1);
		this.ignoreList = new IgnoreList(var1);
	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(I)Z",
		garbageValue = "-1209289020"
	)
	boolean method1952() {
		return this.field1092 == 2;
	}

	@ObfuscatedName("m")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "104"
	)
	final void method1953() {
		this.field1092 = 1;
	}

	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "(Lkb;II)V",
		garbageValue = "1535812566"
	)
	@Export("readUpdate")
	final void readUpdate(Buffer var1, int var2) {
		this.friendsList.read(var1, var2);
		this.field1092 = 2;
		class236.FriendSystem_invalidateFriends();
	}

	@ObfuscatedName("d")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-1051336580"
	)
	@Export("processFriendUpdates")
	final void processFriendUpdates() {
		for (FriendLoginUpdate var1 = (FriendLoginUpdate)this.friendsList.friendLoginUpdates.last(); var1 != null; var1 = (FriendLoginUpdate)this.friendsList.friendLoginUpdates.previous()) {
			if ((long)var1.field3636 < class217.currentTimeMillis() / 1000L - 5L) {
				if (var1.world > 0) {
					Skeleton.addGameMessage(5, "", var1.username + " has logged in.");
				}

				if (var1.world == 0) {
					Skeleton.addGameMessage(5, "", var1.username + " has logged out.");
				}

				var1.remove();
			}
		}

	}

	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-589542332"
	)
	@Export("clear")
	final void clear() {
		this.field1092 = 0;
		this.friendsList.clear();
		this.ignoreList.clear();
	}

	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "(Lku;ZI)Z",
		garbageValue = "-1932720892"
	)
	@Export("isFriended")
	final boolean isFriended(Username var1, boolean var2) {
		if (var1 == null) {
			return false;
		} else if (var1.equals(ByteArrayPool.localPlayer.username)) {
			return true;
		} else {
			return this.friendsList.isFriended(var1, var2);
		}
	}

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "(Lku;B)Z",
		garbageValue = "-60"
	)
	@Export("isIgnored")
	final boolean isIgnored(Username var1) {
		if (var1 == null) {
			return false;
		} else {
			return this.ignoreList.contains(var1);
		}
	}

	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;B)V",
		garbageValue = "-36"
	)
	@Export("addFriend")
	final void addFriend(String var1) {
		if (var1 != null) {
			Username var2 = new Username(var1, this.loginType);
			if (var2.hasCleanName()) {
				if (this.friendsListIsFull()) {
					LoginPacket.method3692();
				} else if (ByteArrayPool.localPlayer.username.equals(var2)) {
					GrandExchangeEvent.method165("You can't add yourself to your own friend list");
				} else if (this.isFriended(var2, false)) {
					DevicePcmPlayerProvider.method946(var1);
				} else if (this.isIgnored(var2)) {
					ClientPreferences.method1950(var1);
				} else {
					PacketBufferNode var3 = FaceNormal.getPacketBufferNode(ClientPacket.field2290, Client.packetWriter.isaacCipher);
					var3.packetBuffer.writeByte(class234.stringCp1252NullTerminatedByteSize(var1));
					var3.packetBuffer.writeStringCp1252NullTerminated(var1);
					Client.packetWriter.addNode(var3);
				}
			}
		}
	}

	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "(I)Z",
		garbageValue = "2128609566"
	)
	@Export("friendsListIsFull")
	final boolean friendsListIsFull() {
		return this.friendsList.isFull() || this.friendsList.getSize() >= 200 && Client.field798 != 1;
	}

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;B)V",
		garbageValue = "-110"
	)
	@Export("addIgnore")
	final void addIgnore(String var1) {
		if (var1 != null) {
			Username var2 = new Username(var1, this.loginType);
			if (var2.hasCleanName()) {
				if (this.canAddIgnore()) {
					GrandExchangeEvent.method165("Your ignore list is full. Max of 100 for free users, and 400 for members");
				} else if (ByteArrayPool.localPlayer.username.equals(var2)) {
					ChatChannel.method2351();
				} else if (this.isIgnored(var2)) {
					GrandExchangeEvent.method165(var1 + " is already on your ignore list");
				} else if (this.isFriended(var2, false)) {
					class195.method3696(var1);
				} else {
					PacketBufferNode var3 = FaceNormal.getPacketBufferNode(ClientPacket.field2216, Client.packetWriter.isaacCipher);
					var3.packetBuffer.writeByte(class234.stringCp1252NullTerminatedByteSize(var1));
					var3.packetBuffer.writeStringCp1252NullTerminated(var1);
					Client.packetWriter.addNode(var3);
				}
			}
		}
	}

	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "(B)Z",
		garbageValue = "-46"
	)
	@Export("canAddIgnore")
	final boolean canAddIgnore() {
		return this.ignoreList.isFull() || this.ignoreList.getSize() >= 100 && Client.field798 != 1;
	}

	@ObfuscatedName("a")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;B)V",
		garbageValue = "-31"
	)
	@Export("removeFriend")
	final void removeFriend(String var1) {
		if (var1 != null) {
			Username var2 = new Username(var1, this.loginType);
			if (var2.hasCleanName()) {
				if (this.friendsList.removeByUsername(var2)) {
					Clock.method3599();
					PacketBufferNode var3 = FaceNormal.getPacketBufferNode(ClientPacket.field2297, Client.packetWriter.isaacCipher);
					var3.packetBuffer.writeByte(class234.stringCp1252NullTerminatedByteSize(var1));
					var3.packetBuffer.writeStringCp1252NullTerminated(var1);
					Client.packetWriter.addNode(var3);
				}

				class236.FriendSystem_invalidateFriends();
			}
		}
	}

	@ObfuscatedName("o")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;B)V",
		garbageValue = "-29"
	)
	@Export("removeIgnore")
	final void removeIgnore(String var1) {
		if (var1 != null) {
			Username var2 = new Username(var1, this.loginType);
			if (var2.hasCleanName()) {
				if (this.ignoreList.removeByUsername(var2)) {
					Clock.method3599();
					PacketBufferNode var3 = FaceNormal.getPacketBufferNode(ClientPacket.field2222, Client.packetWriter.isaacCipher);
					var3.packetBuffer.writeByte(class234.stringCp1252NullTerminatedByteSize(var1));
					var3.packetBuffer.writeStringCp1252NullTerminated(var1);
					Client.packetWriter.addNode(var3);
				}

				FontName.FriendSystem_invalidateIgnoreds();
			}
		}
	}

	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "(Lku;I)Z",
		garbageValue = "-407468573"
	)
	@Export("isFriendAndHasWorld")
	final boolean isFriendAndHasWorld(Username var1) {
		Friend var2 = (Friend)this.friendsList.getByUsername(var1);
		return var2 != null && var2.hasWorld();
	}
}
