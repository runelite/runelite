import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bb")
@Implements("FriendSystem")
public class FriendSystem {
	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "Lln;"
	)
	@Export("loginType")
	final LoginType loginType;
	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "Ljh;"
	)
	@Export("friendsList")
	public final FriendsList friendsList;
	@ObfuscatedName("l")
	@ObfuscatedSignature(
		signature = "Lje;"
	)
	@Export("ignoreList")
	public final IgnoreList ignoreList;
	@ObfuscatedName("c")
	@ObfuscatedGetter(
		intValue = -1502987485
	)
	int field1044;

	@ObfuscatedSignature(
		signature = "(Lln;)V"
	)
	FriendSystem(LoginType var1) {
		this.field1044 = 0;
		this.loginType = var1;
		this.friendsList = new FriendsList(var1);
		this.ignoreList = new IgnoreList(var1);
	}

	@ObfuscatedName("a")
	@ObfuscatedSignature(
		signature = "(I)Z",
		garbageValue = "-2101343080"
	)
	boolean method1973() {
		return this.field1044 == 2;
	}

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "1650406039"
	)
	final void method1968() {
		this.field1044 = 1;
	}

	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "(Lkc;II)V",
		garbageValue = "1319465817"
	)
	@Export("readUpdate")
	final void readUpdate(Buffer var1, int var2) {
		this.friendsList.read(var1, var2);
		this.field1044 = 2;
		ByteArrayPool.FriendSystem_invalidateFriends();
	}

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-885412524"
	)
	@Export("processFriendUpdates")
	final void processFriendUpdates() {
		for (FriendLoginUpdate var1 = (FriendLoginUpdate)this.friendsList.friendLoginUpdates.last(); var1 != null; var1 = (FriendLoginUpdate)this.friendsList.friendLoginUpdates.previous()) {
			if ((long)var1.field3624 < PlayerAppearance.currentTimeMillis() / 1000L - 5L) {
				if (var1.world > 0) {
					class30.addGameMessage(5, "", var1.username + " has logged in.");
				}

				if (var1.world == 0) {
					class30.addGameMessage(5, "", var1.username + " has logged out.");
				}

				var1.remove();
			}
		}

	}

	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "-44"
	)
	@Export("clear")
	final void clear() {
		this.field1044 = 0;
		this.friendsList.clear();
		this.ignoreList.clear();
	}

	@ObfuscatedName("l")
	@ObfuscatedSignature(
		signature = "(Lju;ZB)Z",
		garbageValue = "-128"
	)
	@Export("isFriended")
	final boolean isFriended(Username var1, boolean var2) {
		if (var1 == null) {
			return false;
		} else if (var1.equals(class215.localPlayer.username)) {
			return true;
		} else {
			return this.friendsList.isFriended(var1, var2);
		}
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(Lju;S)Z",
		garbageValue = "19045"
	)
	@Export("isIgnored")
	final boolean isIgnored(Username var1) {
		if (var1 == null) {
			return false;
		} else {
			return this.ignoreList.contains(var1);
		}
	}

	@ObfuscatedName("o")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;B)V",
		garbageValue = "14"
	)
	@Export("addFriend")
	final void addFriend(String var1) {
		if (var1 != null) {
			Username var2 = new Username(var1, this.loginType);
			if (var2.hasCleanName()) {
				StringBuilder var10000;
				String var3;
				if (this.friendsListIsFull()) {
					var10000 = null;
					var3 = "Your friend list is full. Max of 200 for free users, and 400 for members";
					class30.addGameMessage(30, "", var3);
				} else if (class215.localPlayer.username.equals(var2)) {
					WorldMapRegion.method599();
				} else if (this.isFriended(var2, false)) {
					var10000 = (new StringBuilder()).append(var1);
					Object var10001 = null;
					var3 = var10000.append(" is already on your friend list").toString();
					class30.addGameMessage(30, "", var3);
				} else if (this.isIgnored(var2)) {
					Players.method2308(var1);
				} else {
					method2024(var1);
				}
			}
		}
	}

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "(I)Z",
		garbageValue = "1177214541"
	)
	@Export("friendsListIsFull")
	final boolean friendsListIsFull() {
		return this.friendsList.isFull() || this.friendsList.getSize() >= 200 && Client.field749 != 1;
	}

	@ObfuscatedName("h")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;B)V",
		garbageValue = "22"
	)
	@Export("addIgnore")
	final void addIgnore(String var1) {
		if (var1 != null) {
			Username var2 = new Username(var1, this.loginType);
			if (var2.hasCleanName()) {
				if (this.canAddIgnore()) {
					ModelData0.method3380();
				} else if (class215.localPlayer.username.equals(var2)) {
					class247.method4642();
				} else if (this.isIgnored(var2)) {
					VarbitDefinition.method4651(var1);
				} else if (this.isFriended(var2, false)) {
					WorldMapIcon_1.method355(var1);
				} else {
					PacketBufferNode var3 = SoundSystem.getPacketBufferNode(ClientPacket.field2202, Client.packetWriter.isaacCipher);
					var3.packetBuffer.writeByte(UserComparator6.stringCp1252NullTerminatedByteSize(var1));
					var3.packetBuffer.writeStringCp1252NullTerminated(var1);
					Client.packetWriter.addNode(var3);
				}
			}
		}
	}

	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "(B)Z",
		garbageValue = "-54"
	)
	@Export("canAddIgnore")
	final boolean canAddIgnore() {
		return this.ignoreList.isFull() || this.ignoreList.getSize() >= 100 && Client.field749 != 1;
	}

	@ObfuscatedName("s")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;I)V",
		garbageValue = "-248973546"
	)
	@Export("removeFriend")
	final void removeFriend(String var1) {
		if (var1 != null) {
			Username var2 = new Username(var1, this.loginType);
			if (var2.hasCleanName()) {
				if (this.friendsList.removeByUsername(var2)) {
					MilliClock.method3604();
					PacketBufferNode var3 = SoundSystem.getPacketBufferNode(ClientPacket.field2227, Client.packetWriter.isaacCipher);
					var3.packetBuffer.writeByte(UserComparator6.stringCp1252NullTerminatedByteSize(var1));
					var3.packetBuffer.writeStringCp1252NullTerminated(var1);
					Client.packetWriter.addNode(var3);
				}

				ByteArrayPool.FriendSystem_invalidateFriends();
			}
		}
	}

	@ObfuscatedName("b")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;I)V",
		garbageValue = "1867823329"
	)
	@Export("removeIgnore")
	final void removeIgnore(String var1) {
		if (var1 != null) {
			Username var2 = new Username(var1, this.loginType);
			if (var2.hasCleanName()) {
				if (this.ignoreList.removeByUsername(var2)) {
					MilliClock.method3604();
					PacketBufferNode var3 = SoundSystem.getPacketBufferNode(ClientPacket.field2197, Client.packetWriter.isaacCipher);
					var3.packetBuffer.writeByte(UserComparator6.stringCp1252NullTerminatedByteSize(var1));
					var3.packetBuffer.writeStringCp1252NullTerminated(var1);
					Client.packetWriter.addNode(var3);
				}

				class42.FriendSystem_invalidateIgnoreds();
			}
		}
	}

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "(Lju;B)Z",
		garbageValue = "-6"
	)
	@Export("isFriendAndHasWorld")
	final boolean isFriendAndHasWorld(Username var1) {
		Friend var2 = (Friend)this.friendsList.getByUsername(var1);
		return var2 != null && var2.hasWorld();
	}

	@ObfuscatedName("m")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;I)V",
		garbageValue = "-758327012"
	)
	static final void method2024(String var0) {
		PacketBufferNode var1 = SoundSystem.getPacketBufferNode(ClientPacket.field2247, Client.packetWriter.isaacCipher);
		var1.packetBuffer.writeByte(UserComparator6.stringCp1252NullTerminatedByteSize(var0));
		var1.packetBuffer.writeStringCp1252NullTerminated(var0);
		Client.packetWriter.addNode(var1);
	}

	@ObfuscatedName("s")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "896810620"
	)
	public static void method2038() {
		ItemDefinition.ItemDefinition_cached.clear();
		ItemDefinition.ItemDefinition_cachedModels.clear();
		ItemDefinition.ItemDefinition_cachedSprites.clear();
	}
}
