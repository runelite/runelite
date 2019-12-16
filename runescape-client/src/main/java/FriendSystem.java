import java.util.concurrent.ScheduledExecutorService;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bi")
@Implements("FriendSystem")
public class FriendSystem {
	@ObfuscatedName("x")
	@Export("soundSystemExecutor")
	static ScheduledExecutorService soundSystemExecutor;
	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "Lll;"
	)
	@Export("loginType")
	final LoginType loginType;
	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "Ljr;"
	)
	@Export("friendsList")
	public final FriendsList friendsList;
	@ObfuscatedName("b")
	@ObfuscatedSignature(
		signature = "Lju;"
	)
	@Export("ignoreList")
	public final IgnoreList ignoreList;
	@ObfuscatedName("e")
	@ObfuscatedGetter(
		intValue = 1346758177
	)
	int field1045;

	@ObfuscatedSignature(
		signature = "(Lll;)V"
	)
	FriendSystem(LoginType var1) {
		this.field1045 = 0;
		this.loginType = var1;
		this.friendsList = new FriendsList(var1);
		this.ignoreList = new IgnoreList(var1);
	}

	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "(I)Z",
		garbageValue = "-1542848201"
	)
	boolean method1844() {
		return this.field1045 == 2;
	}

	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "0"
	)
	final void method1845() {
		this.field1045 = 1;
	}

	@ObfuscatedName("y")
	@ObfuscatedSignature(
		signature = "(Lkq;II)V",
		garbageValue = "818210154"
	)
	@Export("readUpdate")
	final void readUpdate(Buffer var1, int var2) {
		this.friendsList.read(var1, var2);
		this.field1045 = 2;
		Friend.FriendSystem_invalidateFriends();
	}

	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "64"
	)
	@Export("processFriendUpdates")
	final void processFriendUpdates() {
		for (FriendLoginUpdate var1 = (FriendLoginUpdate)this.friendsList.friendLoginUpdates.last(); var1 != null; var1 = (FriendLoginUpdate)this.friendsList.friendLoginUpdates.previous()) {
			if ((long)var1.field3623 < WorldMapID.currentTimeMillis() / 1000L - 5L) {
				if (var1.world > 0) {
					class83.addGameMessage(5, "", var1.username + " has logged in.");
				}

				if (var1.world == 0) {
					class83.addGameMessage(5, "", var1.username + " has logged out.");
				}

				var1.remove();
			}
		}

	}

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "-3"
	)
	@Export("clear")
	final void clear() {
		this.field1045 = 0;
		this.friendsList.clear();
		this.ignoreList.clear();
	}

	@ObfuscatedName("b")
	@ObfuscatedSignature(
		signature = "(Ljc;ZI)Z",
		garbageValue = "-1562604277"
	)
	@Export("isFriended")
	final boolean isFriended(Username var1, boolean var2) {
		if (var1 == null) {
			return false;
		} else if (var1.equals(Message.localPlayer.username)) {
			return true;
		} else {
			return this.friendsList.isFriended(var1, var2);
		}
	}

	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "(Ljc;I)Z",
		garbageValue = "-408948257"
	)
	@Export("isIgnored")
	final boolean isIgnored(Username var1) {
		if (var1 == null) {
			return false;
		} else {
			return this.ignoreList.contains(var1);
		}
	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;B)V",
		garbageValue = "-28"
	)
	@Export("addFriend")
	final void addFriend(String var1) {
		if (var1 != null) {
			Username var2 = new Username(var1, this.loginType);
			if (var2.hasCleanName()) {
				if (this.friendsListIsFull()) {
					WorldMapRegion.method446();
				} else if (Message.localPlayer.username.equals(var2)) {
					Tiles.method1143("You can't add yourself to your own friend list");
				} else if (this.isFriended(var2, false)) {
					class288.method5335(var1);
				} else if (this.isIgnored(var2)) {
					Tiles.method1143("Please remove " + var1 + " from your ignore list first");
				} else {
					PacketBufferNode var3 = class2.getPacketBufferNode(ClientPacket.field2236, Client.packetWriter.isaacCipher);
					var3.packetBuffer.writeByte(ViewportMouse.stringCp1252NullTerminatedByteSize(var1));
					var3.packetBuffer.writeStringCp1252NullTerminated(var1);
					Client.packetWriter.addNode(var3);
				}
			}
		}
	}

	@ObfuscatedName("o")
	@ObfuscatedSignature(
		signature = "(I)Z",
		garbageValue = "1773395073"
	)
	@Export("friendsListIsFull")
	final boolean friendsListIsFull() {
		return this.friendsList.isFull() || this.friendsList.getSize() >= 200 && Client.field746 != 1;
	}

	@ObfuscatedName("l")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;I)V",
		garbageValue = "1243376516"
	)
	@Export("addIgnore")
	final void addIgnore(String var1) {
		if (var1 != null) {
			Username var2 = new Username(var1, this.loginType);
			if (var2.hasCleanName()) {
				if (this.canAddIgnore()) {
					VertexNormal.method2996();
				} else if (Message.localPlayer.username.equals(var2)) {
					WorldMapCacheName.method620();
				} else if (this.isIgnored(var2)) {
					Tiles.method1143(var1 + " is already on your ignore list");
				} else if (this.isFriended(var2, false)) {
					class191.method3640(var1);
				} else {
					PacketBufferNode var3 = class2.getPacketBufferNode(ClientPacket.field2206, Client.packetWriter.isaacCipher);
					var3.packetBuffer.writeByte(ViewportMouse.stringCp1252NullTerminatedByteSize(var1));
					var3.packetBuffer.writeStringCp1252NullTerminated(var1);
					Client.packetWriter.addNode(var3);
				}
			}
		}
	}

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "(I)Z",
		garbageValue = "-1684864200"
	)
	@Export("canAddIgnore")
	final boolean canAddIgnore() {
		return this.ignoreList.isFull() || this.ignoreList.getSize() >= 100 && Client.field746 != 1;
	}

	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;I)V",
		garbageValue = "975666104"
	)
	@Export("removeFriend")
	final void removeFriend(String var1) {
		if (var1 != null) {
			Username var2 = new Username(var1, this.loginType);
			if (var2.hasCleanName()) {
				if (this.friendsList.removeByUsername(var2)) {
					VertexNormal.method2995();
					PacketBufferNode var3 = class2.getPacketBufferNode(ClientPacket.field2238, Client.packetWriter.isaacCipher);
					var3.packetBuffer.writeByte(ViewportMouse.stringCp1252NullTerminatedByteSize(var1));
					var3.packetBuffer.writeStringCp1252NullTerminated(var1);
					Client.packetWriter.addNode(var3);
				}

				Friend.FriendSystem_invalidateFriends();
			}
		}
	}

	@ObfuscatedName("h")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;I)V",
		garbageValue = "2048585665"
	)
	@Export("removeIgnore")
	final void removeIgnore(String var1) {
		if (var1 != null) {
			Username var2 = new Username(var1, this.loginType);
			if (var2.hasCleanName()) {
				if (this.ignoreList.removeByUsername(var2)) {
					VertexNormal.method2995();
					PacketBufferNode var3 = class2.getPacketBufferNode(ClientPacket.field2260, Client.packetWriter.isaacCipher);
					var3.packetBuffer.writeByte(ViewportMouse.stringCp1252NullTerminatedByteSize(var1));
					var3.packetBuffer.writeStringCp1252NullTerminated(var1);
					Client.packetWriter.addNode(var3);
				}

				GameShell.FriendSystem_invalidateIgnoreds();
			}
		}
	}

	@ObfuscatedName("aa")
	@ObfuscatedSignature(
		signature = "(Ljc;I)Z",
		garbageValue = "-2137551829"
	)
	@Export("isFriendAndHasWorld")
	final boolean isFriendAndHasWorld(Username var1) {
		Friend var2 = (Friend)this.friendsList.getByUsername(var1);
		return var2 != null && var2.hasWorld();
	}

	@ObfuscatedName("y")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-435303731"
	)
	@Export("savePreferences")
	static void savePreferences() {
		AccessFile var0 = null;

		try {
			var0 = Messages.getPreferencesFile("", AbstractWorldMapIcon.field284.name, true);
			Buffer var1 = Interpreter.clientPreferences.toBuffer();
			var0.write(var1.array, 0, var1.offset);
		} catch (Exception var3) {
		}

		try {
			if (var0 != null) {
				var0.closeSync(true);
			}
		} catch (Exception var2) {
		}

	}

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "(II)V",
		garbageValue = "2090172291"
	)
	@Export("clearItemContainer")
	static void clearItemContainer(int var0) {
		ItemContainer var1 = (ItemContainer)ItemContainer.itemContainers.get((long)var0);
		if (var1 != null) {
			for (int var2 = 0; var2 < var1.ids.length; ++var2) {
				var1.ids[var2] = -1;
				var1.quantities[var2] = 0;
			}

		}
	}

	@ObfuscatedName("km")
	@ObfuscatedSignature(
		signature = "(Lha;IIII)V",
		garbageValue = "688328393"
	)
	@Export("drawCompass")
	static final void drawCompass(Widget var0, int var1, int var2, int var3) {
		SpriteMask var4 = var0.getSpriteMask(false);
		if (var4 != null) {
			if (Client.minimapState < 3) {
				GrandExchangeOfferTotalQuantityComparator.compass.drawRotatedMaskedCenteredAround(var1, var2, var4.width, var4.height, 25, 25, Client.camAngleY, 256, var4.xStarts, var4.xWidths);
			} else {
				Rasterizer2D.Rasterizer2D_fillMaskedRectangle(var1, var2, 0, var4.xStarts, var4.xWidths);
			}

		}
	}
}
