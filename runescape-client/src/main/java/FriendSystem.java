import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bz")
@Implements("FriendSystem")
public class FriendSystem {
	@ObfuscatedName("g")
	@ObfuscatedSignature(
		signature = "Llg;"
	)
	@Export("loginType")
	final LoginType loginType;
	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "Ljh;"
	)
	@Export("friendsList")
	public final FriendsList friendsList;
	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "Lju;"
	)
	@Export("ignoreList")
	public final IgnoreList ignoreList;
	@ObfuscatedName("h")
	@ObfuscatedGetter(
		intValue = 618152065
	)
	int field1061;

	@ObfuscatedSignature(
		signature = "(Llg;)V"
	)
	FriendSystem(LoginType var1) {
		this.field1061 = 0;
		this.loginType = var1;
		this.friendsList = new FriendsList(var1);
		this.ignoreList = new IgnoreList(var1);
	}

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "(I)Z",
		garbageValue = "-1963052463"
	)
	boolean method1870() {
		return this.field1061 == 2;
	}

	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "-31"
	)
	final void method1867() {
		this.field1061 = 1;
	}

	@ObfuscatedName("b")
	@ObfuscatedSignature(
		signature = "(Lkg;IB)V",
		garbageValue = "52"
	)
	@Export("readUpdate")
	final void readUpdate(Buffer var1, int var2) {
		this.friendsList.read(var1, var2);
		this.field1061 = 2;
		WorldMapIcon_1.FriendSystem_invalidateFriends();
	}

	@ObfuscatedName("g")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "2007033957"
	)
	@Export("processFriendUpdates")
	final void processFriendUpdates() {
		for (FriendLoginUpdate var1 = (FriendLoginUpdate)this.friendsList.friendLoginUpdates.last(); var1 != null; var1 = (FriendLoginUpdate)this.friendsList.friendLoginUpdates.previous()) {
			if ((long)var1.field3646 < TaskHandler.currentTimeMillis() / 1000L - 5L) {
				if (var1.world > 0) {
					GrandExchangeOfferAgeComparator.addGameMessage(5, "", var1.username + " has logged in.");
				}

				if (var1.world == 0) {
					GrandExchangeOfferAgeComparator.addGameMessage(5, "", var1.username + " has logged out.");
				}

				var1.remove();
			}
		}

	}

	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-242142328"
	)
	@Export("clear")
	final void clear() {
		this.field1061 = 0;
		this.friendsList.clear();
		this.ignoreList.clear();
	}

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "(Ljb;ZI)Z",
		garbageValue = "-557958994"
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

	@ObfuscatedName("h")
	@ObfuscatedSignature(
		signature = "(Ljb;B)Z",
		garbageValue = "94"
	)
	@Export("isIgnored")
	final boolean isIgnored(Username var1) {
		if (var1 == null) {
			return false;
		} else {
			return this.ignoreList.contains(var1);
		}
	}

	@ObfuscatedName("y")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;I)V",
		garbageValue = "905679920"
	)
	@Export("addFriend")
	final void addFriend(String var1) {
		if (var1 != null) {
			Username var2 = new Username(var1, this.loginType);
			if (var2.hasCleanName()) {
				if (this.friendsListIsFull()) {
					PacketBufferNode.method3670();
				} else if (class215.localPlayer.username.equals(var2)) {
					WorldMapSection2.method347("You can't add yourself to your own friend list");
				} else if (this.isFriended(var2, false)) {
					class65.method1244(var1);
				} else if (this.isIgnored(var2)) {
					WorldMapSection2.method347("Please remove " + var1 + " from your ignore list first");
				} else {
					PacketBufferNode var3 = ModelData0.getPacketBufferNode(ClientPacket.field2268, Client.packetWriter.isaacCipher);
					var3.packetBuffer.writeByte(class173.stringCp1252NullTerminatedByteSize(var1));
					var3.packetBuffer.writeStringCp1252NullTerminated(var1);
					Client.packetWriter.addNode(var3);
				}
			}
		}
	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(I)Z",
		garbageValue = "-1079308803"
	)
	@Export("friendsListIsFull")
	final boolean friendsListIsFull() {
		return this.friendsList.isFull() || this.friendsList.getSize() >= 200 && Client.field789 != 1;
	}

	@ObfuscatedName("o")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;B)V",
		garbageValue = "15"
	)
	@Export("addIgnore")
	final void addIgnore(String var1) {
		if (var1 != null) {
			Username var2 = new Username(var1, this.loginType);
			if (var2.hasCleanName()) {
				if (this.canAddIgnore()) {
					GrandExchangeOfferNameComparator.method145();
				} else if (class215.localPlayer.username.equals(var2)) {
					WorldMapSection2.method347("You can't add yourself to your own ignore list");
				} else if (this.isIgnored(var2)) {
					WorldMapSection2.method347(var1 + " is already on your ignore list");
				} else if (this.isFriended(var2, false)) {
					WorldMapSectionType.method269(var1);
				} else {
					class218.method4179(var1);
				}
			}
		}
	}

	@ObfuscatedName("s")
	@ObfuscatedSignature(
		signature = "(B)Z",
		garbageValue = "97"
	)
	@Export("canAddIgnore")
	final boolean canAddIgnore() {
		return this.ignoreList.isFull() || this.ignoreList.getSize() >= 100 && Client.field789 != 1;
	}

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;I)V",
		garbageValue = "-774164721"
	)
	@Export("removeFriend")
	final void removeFriend(String var1) {
		if (var1 != null) {
			Username var2 = new Username(var1, this.loginType);
			if (var2.hasCleanName()) {
				if (this.friendsList.removeByUsername(var2)) {
					Client.field833 = Client.cycleCntr;
					PacketBufferNode var3 = ModelData0.getPacketBufferNode(ClientPacket.field2289, Client.packetWriter.isaacCipher);
					var3.packetBuffer.writeByte(class173.stringCp1252NullTerminatedByteSize(var1));
					var3.packetBuffer.writeStringCp1252NullTerminated(var1);
					Client.packetWriter.addNode(var3);
				}

				WorldMapIcon_1.FriendSystem_invalidateFriends();
			}
		}
	}

	@ObfuscatedName("m")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;I)V",
		garbageValue = "-1018111"
	)
	@Export("removeIgnore")
	final void removeIgnore(String var1) {
		if (var1 != null) {
			Username var2 = new Username(var1, this.loginType);
			if (var2.hasCleanName()) {
				if (this.ignoreList.removeByUsername(var2)) {
					Client.field833 = Client.cycleCntr;
					PacketBufferNode var3 = ModelData0.getPacketBufferNode(ClientPacket.field2217, Client.packetWriter.isaacCipher);
					var3.packetBuffer.writeByte(class173.stringCp1252NullTerminatedByteSize(var1));
					var3.packetBuffer.writeStringCp1252NullTerminated(var1);
					Client.packetWriter.addNode(var3);
				}

				Language.FriendSystem_invalidateIgnoreds();
			}
		}
	}

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "(Ljb;B)Z",
		garbageValue = "0"
	)
	@Export("isFriendAndHasWorld")
	final boolean isFriendAndHasWorld(Username var1) {
		Friend var2 = (Friend)this.friendsList.getByUsername(var1);
		return var2 != null && var2.hasWorld();
	}

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "(I)[Lgd;",
		garbageValue = "-1110076754"
	)
	public static class185[] method1927() {
		return new class185[]{class185.field2334, class185.field2332, class185.field2333, class185.field2339, class185.field2336, class185.field2341, class185.field2337, class185.field2331, class185.field2335, class185.field2340};
	}

	@ObfuscatedName("ge")
	@ObfuscatedSignature(
		signature = "(B)Z",
		garbageValue = "-90"
	)
	static boolean method1920() {
		return (Client.drawPlayerNames & 2) != 0;
	}
}
