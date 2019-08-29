import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.ScriptOpcodes;

@ObfuscatedName("ba")
@Implements("FriendSystem")
public class FriendSystem {
	@ObfuscatedName("cs")
	@Export("mouseCam")
	static boolean mouseCam;
	@ObfuscatedName("hn")
	@ObfuscatedGetter(
		intValue = 2015707871
	)
	@Export("oculusOrbFocalPointY")
	static int oculusOrbFocalPointY;
	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "Llu;"
	)
	@Export("loginType")
	final LoginType loginType;
	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "Ljo;"
	)
	@Export("friendsList")
	public final FriendsList friendsList;
	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "Ljk;"
	)
	@Export("ignoreList")
	public final IgnoreList ignoreList;
	@ObfuscatedName("t")
	@ObfuscatedGetter(
		intValue = 1694848325
	)
	int field1045;

	@ObfuscatedSignature(
		signature = "(Llu;)V"
	)
	FriendSystem(LoginType var1) {
		this.field1045 = 0;
		this.loginType = var1;
		this.friendsList = new FriendsList(var1);
		this.ignoreList = new IgnoreList(var1);
	}

	@ObfuscatedName("s")
	@ObfuscatedSignature(
		signature = "(S)Z",
		garbageValue = "-3646"
	)
	boolean method1773() {
		return this.field1045 == 2;
	}

	@ObfuscatedName("j")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "-52"
	)
	final void method1774() {
		this.field1045 = 1;
	}

	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "(Lky;II)V",
		garbageValue = "-1957399935"
	)
	@Export("readUpdate")
	final void readUpdate(Buffer var1, int var2) {
		this.friendsList.read(var1, var2);
		this.field1045 = 2;
		class3.FriendSystem_invalidateFriends();
	}

	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-688345786"
	)
	@Export("processFriendUpdates")
	final void processFriendUpdates() {
		for (FriendLoginUpdate var1 = (FriendLoginUpdate)this.friendsList.friendLoginUpdates.last(); var1 != null; var1 = (FriendLoginUpdate)this.friendsList.friendLoginUpdates.previous()) {
			if ((long)var1.field3621 < SequenceDefinition.method4686() / 1000L - 5L) {
				if (var1.world > 0) {
					DirectByteArrayCopier.addGameMessage(5, "", var1.username + " has logged in.");
				}

				if (var1.world == 0) {
					DirectByteArrayCopier.addGameMessage(5, "", var1.username + " has logged out.");
				}

				var1.remove();
			}
		}

	}

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "452224146"
	)
	@Export("clear")
	final void clear() {
		this.field1045 = 0;
		this.friendsList.clear();
		this.ignoreList.clear();
	}

	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "(Ljx;ZI)Z",
		garbageValue = "1695640889"
	)
	@Export("isFriended")
	final boolean isFriended(Username var1, boolean var2) {
		if (var1 == null) {
			return false;
		} else if (var1.equals(WorldMapIcon_1.localPlayer.username)) {
			return true;
		} else {
			return this.friendsList.isFriended(var1, var2);
		}
	}

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(Ljx;I)Z",
		garbageValue = "-33196880"
	)
	@Export("isIgnored")
	final boolean isIgnored(Username var1) {
		if (var1 == null) {
			return false;
		} else {
			return this.ignoreList.contains(var1);
		}
	}

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;B)V",
		garbageValue = "6"
	)
	@Export("addFriend")
	final void addFriend(String var1) {
		if (var1 != null) {
			Username var2 = new Username(var1, this.loginType);
			if (var2.hasCleanName()) {
				if (this.friendsListIsFull()) {
					class3.method53();
				} else {
					StringBuilder var10000;
					String var4;
					if (WorldMapIcon_1.localPlayer.username.equals(var2)) {
						var10000 = null;
						var4 = "You can't add yourself to your own friend list";
						DirectByteArrayCopier.addGameMessage(30, "", var4);
					} else if (this.isFriended(var2, false)) {
						NPC.method1976(var1);
					} else if (this.isIgnored(var2)) {
						var10000 = new StringBuilder();
						Object var10001 = null;
						var10000 = var10000.append("Please remove ").append(var1);
						var10001 = null;
						var4 = var10000.append(" from your ignore list first").toString();
						DirectByteArrayCopier.addGameMessage(30, "", var4);
					} else {
						PacketBufferNode var3 = MenuAction.getPacketBufferNode(ClientPacket.field2201, Client.packetWriter.isaacCipher);
						var3.packetBuffer.writeByte(Buddy.stringCp1252NullTerminatedByteSize(var1));
						var3.packetBuffer.writeStringCp1252NullTerminated(var1);
						Client.packetWriter.addNode(var3);
					}
				}
			}
		}
	}

	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "(B)Z",
		garbageValue = "-21"
	)
	@Export("friendsListIsFull")
	final boolean friendsListIsFull() {
		return this.friendsList.isFull() || this.friendsList.getSize() >= 200 && Client.field741 != 1;
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;I)V",
		garbageValue = "1615716489"
	)
	@Export("addIgnore")
	final void addIgnore(String var1) {
		if (var1 != null) {
			Username var2 = new Username(var1, this.loginType);
			if (var2.hasCleanName()) {
				StringBuilder var10000;
				String var3;
				if (this.canAddIgnore()) {
					var10000 = null;
					var3 = "Your ignore list is full. Max of 100 for free users, and 400 for members";
					DirectByteArrayCopier.addGameMessage(30, "", var3);
				} else if (WorldMapIcon_1.localPlayer.username.equals(var2)) {
					var10000 = null;
					var3 = "You can't add yourself to your own ignore list";
					DirectByteArrayCopier.addGameMessage(30, "", var3);
				} else if (this.isIgnored(var2)) {
					AbstractWorldMapIcon.method591(var1);
				} else if (this.isFriended(var2, false)) {
					var10000 = new StringBuilder();
					Object var10001 = null;
					var10000 = var10000.append("Please remove ").append(var1);
					var10001 = null;
					var3 = var10000.append(" from your friend list first").toString();
					DirectByteArrayCopier.addGameMessage(30, "", var3);
				} else {
					Huffman.method3902(var1);
				}
			}
		}
	}

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "(I)Z",
		garbageValue = "1672650441"
	)
	@Export("canAddIgnore")
	final boolean canAddIgnore() {
		return this.ignoreList.isFull() || this.ignoreList.getSize() >= 100 && Client.field741 != 1;
	}

	@ObfuscatedName("g")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;B)V",
		garbageValue = "-123"
	)
	@Export("removeFriend")
	final void removeFriend(String var1) {
		if (var1 != null) {
			Username var2 = new Username(var1, this.loginType);
			if (var2.hasCleanName()) {
				if (this.friendsList.removeByUsername(var2)) {
					class43.method759();
					PacketBufferNode var3 = MenuAction.getPacketBufferNode(ClientPacket.field2225, Client.packetWriter.isaacCipher);
					var3.packetBuffer.writeByte(Buddy.stringCp1252NullTerminatedByteSize(var1));
					var3.packetBuffer.writeStringCp1252NullTerminated(var1);
					Client.packetWriter.addNode(var3);
				}

				class3.FriendSystem_invalidateFriends();
			}
		}
	}

	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;B)V",
		garbageValue = "2"
	)
	@Export("removeIgnore")
	final void removeIgnore(String var1) {
		if (var1 != null) {
			Username var2 = new Username(var1, this.loginType);
			if (var2.hasCleanName()) {
				if (this.ignoreList.removeByUsername(var2)) {
					class43.method759();
					PacketBufferNode var3 = MenuAction.getPacketBufferNode(ClientPacket.field2266, Client.packetWriter.isaacCipher);
					var3.packetBuffer.writeByte(Buddy.stringCp1252NullTerminatedByteSize(var1));
					var3.packetBuffer.writeStringCp1252NullTerminated(var1);
					Client.packetWriter.addNode(var3);
				}

				InterfaceParent.FriendSystem_invalidateIgnoreds();
			}
		}
	}

	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "(Ljx;I)Z",
		garbageValue = "2127242291"
	)
	@Export("isFriendAndHasWorld")
	final boolean isFriendAndHasWorld(Username var1) {
		Friend var2 = (Friend)this.friendsList.getByUsername(var1);
		return var2 != null && var2.hasWorld();
	}

	@ObfuscatedName("s")
	@ObfuscatedSignature(
		signature = "([Lgn;II)Lgn;",
		garbageValue = "-2035427993"
	)
	@Export("findEnumerated")
	public static Enumerated findEnumerated(Enumerated[] var0, int var1) {
		Enumerated[] var2 = var0;

		for (int var3 = 0; var3 < var2.length; ++var3) {
			Enumerated var4 = var2[var3];
			if (var1 == var4.rsOrdinal()) {
				return var4;
			}
		}

		return null;
	}

	@ObfuscatedName("s")
	@ObfuscatedSignature(
		signature = "(I)[Lia;",
		garbageValue = "173195137"
	)
	static VerticalAlignment[] method1830() {
		return new VerticalAlignment[]{VerticalAlignment.VerticalAlignment_centered, VerticalAlignment.field3172, VerticalAlignment.field3174};
	}

	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "(ILcr;ZI)I",
		garbageValue = "1342968347"
	)
	static int method1831(int var0, Script var1, boolean var2) {
		int var3;
		int var4;
		if (var0 == ScriptOpcodes.CC_CREATE) {
			Interpreter.Interpreter_intStackSize -= 3;
			var3 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize];
			var4 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1];
			int var5 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 2];
			if (var4 == 0) {
				throw new RuntimeException();
			} else {
				Widget var6 = WorldMapElement.getWidget(var3);
				if (var6.children == null) {
					var6.children = new Widget[var5 + 1];
				}

				if (var6.children.length <= var5) {
					Widget[] var7 = new Widget[var5 + 1];

					for (int var8 = 0; var8 < var6.children.length; ++var8) {
						var7[var8] = var6.children[var8];
					}

					var6.children = var7;
				}

				if (var5 > 0 && var6.children[var5 - 1] == null) {
					throw new RuntimeException("" + (var5 - 1));
				} else {
					Widget var12 = new Widget();
					var12.type = var4;
					var12.parentId = var12.id = var6.id;
					var12.childIndex = var5;
					var12.isIf3 = true;
					var6.children[var5] = var12;
					if (var2) {
						class286.field3623 = var12;
					} else {
						class297.field3693 = var12;
					}

					invalidateWidget(var6);
					return 1;
				}
			}
		} else {
			Widget var9;
			if (var0 == ScriptOpcodes.CC_DELETE) {
				var9 = var2 ? class286.field3623 : class297.field3693;
				Widget var10 = WorldMapElement.getWidget(var9.id);
				var10.children[var9.childIndex] = null;
				invalidateWidget(var10);
				return 1;
			} else if (var0 == ScriptOpcodes.CC_DELETEALL) {
				var9 = WorldMapElement.getWidget(Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize]);
				var9.children = null;
				invalidateWidget(var9);
				return 1;
			} else if (var0 != ScriptOpcodes.CC_FIND) {
				if (var0 == ScriptOpcodes.IF_FIND) {
					var9 = WorldMapElement.getWidget(Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize]);
					if (var9 != null) {
						Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 1;
						if (var2) {
							class286.field3623 = var9;
						} else {
							class297.field3693 = var9;
						}
					} else {
						Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 0;
					}

					return 1;
				} else {
					return 2;
				}
			} else {
				Interpreter.Interpreter_intStackSize -= 2;
				var3 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize];
				var4 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1];
				Widget var11 = ModelData0.getWidgetChild(var3, var4);
				if (var11 != null && var4 != -1) {
					Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 1;
					if (var2) {
						class286.field3623 = var11;
					} else {
						class297.field3693 = var11;
					}
				} else {
					Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 0;
				}

				return 1;
			}
		}
	}

	@ObfuscatedName("jk")
	@ObfuscatedSignature(
		signature = "(Lhp;I)V",
		garbageValue = "-1019792182"
	)
	@Export("invalidateWidget")
	static void invalidateWidget(Widget var0) {
		if (var0.cycle == Client.field752) {
			Client.field703[var0.rootIndex] = true;
		}

	}
}
