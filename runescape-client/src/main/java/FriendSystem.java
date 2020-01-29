import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.ScriptOpcodes;

@ObfuscatedName("bu")
@Implements("FriendSystem")
public class FriendSystem {
	@ObfuscatedName("ha")
	@ObfuscatedGetter(
		intValue = -1970559655
	)
	@Export("cameraYaw")
	static int cameraYaw;
	@ObfuscatedName("ix")
	@ObfuscatedGetter(
		intValue = -1654190039
	)
	@Export("selectedItemWidget")
	static int selectedItemWidget;
	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "Lmv;"
	)
	@Export("loginType")
	final LoginType loginType;
	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "Ljd;"
	)
	@Export("friendsList")
	public final FriendsList friendsList;
	@ObfuscatedName("g")
	@ObfuscatedSignature(
		signature = "Ljf;"
	)
	@Export("ignoreList")
	public final IgnoreList ignoreList;
	@ObfuscatedName("d")
	@ObfuscatedGetter(
		intValue = -154816357
	)
	int field1063;

	@ObfuscatedSignature(
		signature = "(Lmv;)V"
	)
	FriendSystem(LoginType var1) {
		this.field1063 = 0;
		this.loginType = var1;
		this.friendsList = new FriendsList(var1);
		this.ignoreList = new IgnoreList(var1);
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(I)Z",
		garbageValue = "-1947292888"
	)
	boolean method1857() {
		return this.field1063 == 2;
	}

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "1940001821"
	)
	final void method1858() {
		this.field1063 = 1;
	}

	@ObfuscatedName("o")
	@ObfuscatedSignature(
		signature = "(Lkp;II)V",
		garbageValue = "224283434"
	)
	@Export("readUpdate")
	final void readUpdate(Buffer var1, int var2) {
		this.friendsList.read(var1, var2);
		this.field1063 = 2;
		WorldMapID.FriendSystem_invalidateFriends();
	}

	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "291777380"
	)
	@Export("processFriendUpdates")
	final void processFriendUpdates() {
		for (FriendLoginUpdate var1 = (FriendLoginUpdate)this.friendsList.friendLoginUpdates.last(); var1 != null; var1 = (FriendLoginUpdate)this.friendsList.friendLoginUpdates.previous()) {
			if ((long)var1.field3632 < WorldMapIcon_0.currentTimeMillis() / 1000L - 5L) {
				if (var1.world > 0) {
					ClientPreferences.addGameMessage(5, "", var1.username + " has logged in.");
				}

				if (var1.world == 0) {
					ClientPreferences.addGameMessage(5, "", var1.username + " has logged out.");
				}

				var1.remove();
			}
		}

	}

	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-1660346454"
	)
	@Export("clear")
	final void clear() {
		this.field1063 = 0;
		this.friendsList.clear();
		this.ignoreList.clear();
	}

	@ObfuscatedName("g")
	@ObfuscatedSignature(
		signature = "(Ljz;ZI)Z",
		garbageValue = "1100778689"
	)
	@Export("isFriended")
	final boolean isFriended(Username var1, boolean var2) {
		if (var1 == null) {
			return false;
		} else if (var1.equals(class192.localPlayer.username)) {
			return true;
		} else {
			return this.friendsList.isFriended(var1, var2);
		}
	}

	@ObfuscatedName("d")
	@ObfuscatedSignature(
		signature = "(Ljz;I)Z",
		garbageValue = "819479662"
	)
	@Export("isIgnored")
	final boolean isIgnored(Username var1) {
		if (var1 == null) {
			return false;
		} else {
			return this.ignoreList.contains(var1);
		}
	}

	@ObfuscatedName("l")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;I)V",
		garbageValue = "-340804777"
	)
	@Export("addFriend")
	final void addFriend(String var1) {
		if (var1 != null) {
			Username var2 = new Username(var1, this.loginType);
			if (var2.hasCleanName()) {
				if (this.friendsListIsFull()) {
					WorldMapArea.method425();
				} else if (class192.localPlayer.username.equals(var2)) {
					WorldMapLabel.method439();
				} else if (this.isFriended(var2, false)) {
					LoginScreenAnimation.method1837(var1);
				} else if (this.isIgnored(var2)) {
					Calendar.method4014(var1);
				} else {
					PacketBufferNode var3 = TilePaint.getPacketBufferNode(ClientPacket.field2260, Client.packetWriter.isaacCipher);
					var3.packetBuffer.writeByte(Buddy.stringCp1252NullTerminatedByteSize(var1));
					var3.packetBuffer.writeStringCp1252NullTerminated(var1);
					Client.packetWriter.addNode(var3);
				}
			}
		}
	}

	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "(I)Z",
		garbageValue = "-1302160469"
	)
	@Export("friendsListIsFull")
	final boolean friendsListIsFull() {
		return this.friendsList.isFull() || this.friendsList.getSize() >= 200 && Client.field763 != 1;
	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;I)V",
		garbageValue = "-1143439097"
	)
	@Export("addIgnore")
	final void addIgnore(String var1) {
		if (var1 != null) {
			Username var2 = new Username(var1, this.loginType);
			if (var2.hasCleanName()) {
				if (this.canAddIgnore()) {
					class60.method1188("Your ignore list is full. Max of 100 for free users, and 400 for members");
				} else if (class192.localPlayer.username.equals(var2)) {
					class80.method2097();
				} else if (this.isIgnored(var2)) {
					ModelData0.method3323(var1);
				} else if (this.isFriended(var2, false)) {
					FloorDecoration.method2912(var1);
				} else {
					class43.method817(var1);
				}
			}
		}
	}

	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "(I)Z",
		garbageValue = "-1820924219"
	)
	@Export("canAddIgnore")
	final boolean canAddIgnore() {
		return this.ignoreList.isFull() || this.ignoreList.getSize() >= 100 && Client.field763 != 1;
	}

	@ObfuscatedName("a")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;I)V",
		garbageValue = "561828243"
	)
	@Export("removeFriend")
	final void removeFriend(String var1) {
		if (var1 != null) {
			Username var2 = new Username(var1, this.loginType);
			if (var2.hasCleanName()) {
				if (this.friendsList.removeByUsername(var2)) {
					Client.field839 = Client.cycleCntr;
					PacketBufferNode var3 = TilePaint.getPacketBufferNode(ClientPacket.field2213, Client.packetWriter.isaacCipher);
					var3.packetBuffer.writeByte(Buddy.stringCp1252NullTerminatedByteSize(var1));
					var3.packetBuffer.writeStringCp1252NullTerminated(var1);
					Client.packetWriter.addNode(var3);
				}

				WorldMapID.FriendSystem_invalidateFriends();
			}
		}
	}

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;I)V",
		garbageValue = "-892672688"
	)
	@Export("removeIgnore")
	final void removeIgnore(String var1) {
		if (var1 != null) {
			Username var2 = new Username(var1, this.loginType);
			if (var2.hasCleanName()) {
				if (this.ignoreList.removeByUsername(var2)) {
					Client.field839 = Client.cycleCntr;
					PacketBufferNode var3 = TilePaint.getPacketBufferNode(ClientPacket.field2288, Client.packetWriter.isaacCipher);
					var3.packetBuffer.writeByte(Buddy.stringCp1252NullTerminatedByteSize(var1));
					var3.packetBuffer.writeStringCp1252NullTerminated(var1);
					Client.packetWriter.addNode(var3);
				}

				class96.FriendSystem_invalidateIgnoreds();
			}
		}
	}

	@ObfuscatedName("af")
	@ObfuscatedSignature(
		signature = "(Ljz;I)Z",
		garbageValue = "431116625"
	)
	@Export("isFriendAndHasWorld")
	final boolean isFriendAndHasWorld(Username var1) {
		Friend var2 = (Friend)this.friendsList.getByUsername(var1);
		return var2 != null && var2.hasWorld();
	}

	@ObfuscatedName("ak")
	@ObfuscatedSignature(
		signature = "(ILce;ZB)I",
		garbageValue = "0"
	)
	static int method1920(int var0, Script var1, boolean var2) {
		int var3;
		if (var0 == ScriptOpcodes.CAM_FORCEANGLE) {
			class320.Interpreter_intStackSize -= 2;
			var3 = Interpreter.Interpreter_intStack[class320.Interpreter_intStackSize];
			int var4 = Interpreter.Interpreter_intStack[class320.Interpreter_intStackSize + 1];
			if (!Client.isCameraLocked) {
				Client.camAngleX = var3;
				Client.camAngleY = var4;
			}

			return 1;
		} else if (var0 == ScriptOpcodes.CAM_GETANGLE_XA) {
			Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = Client.camAngleX;
			return 1;
		} else if (var0 == ScriptOpcodes.CAM_GETANGLE_YA) {
			Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = Client.camAngleY;
			return 1;
		} else if (var0 == ScriptOpcodes.CAM_SETFOLLOWHEIGHT) {
			var3 = Interpreter.Interpreter_intStack[--class320.Interpreter_intStackSize];
			if (var3 < 0) {
				var3 = 0;
			}

			Client.camFollowHeight = var3;
			return 1;
		} else if (var0 == ScriptOpcodes.CAM_GETFOLLOWHEIGHT) {
			Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = Client.camFollowHeight;
			return 1;
		} else {
			return 2;
		}
	}
}
