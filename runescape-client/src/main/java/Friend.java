import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.ScriptOpcodes;

@ObfuscatedName("jg")
@Implements("Friend")
public class Friend extends Buddy {
	@ObfuscatedName("f")
	boolean field3617;
	@ObfuscatedName("i")
	boolean field3618;

	Friend() {
	}

	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "(Ljg;B)I",
		garbageValue = "73"
	)
	@Export("compareToFriend")
	int compareToFriend(Friend var1) {
		if (super.world == Client.worldId && Client.worldId != var1.world) {
			return -1;
		} else if (Client.worldId == var1.world && super.world != Client.worldId) {
			return 1;
		} else if (super.world != 0 && var1.world == 0) {
			return -1;
		} else if (var1.world != 0 && super.world == 0) {
			return 1;
		} else if (this.field3617 && !var1.field3617) {
			return -1;
		} else if (!this.field3617 && var1.field3617) {
			return 1;
		} else if (this.field3618 && !var1.field3618) {
			return -1;
		} else if (!this.field3618 && var1.field3618) {
			return 1;
		} else {
			return super.world != 0 ? super.int2 - var1.int2 : var1.int2 - super.int2;
		}
	}

	@ObfuscatedName("ay")
	@ObfuscatedSignature(
		signature = "(Ljy;S)I",
		garbageValue = "9221"
	)
	@Export("compareTo_user")
	public int compareTo_user(User var1) {
		return this.compareToFriend((Friend)var1);
	}

	public int compareTo(Object var1) {
		return this.compareToFriend((Friend)var1);
	}

	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "(ILcu;ZI)I",
		garbageValue = "316315133"
	)
	static int method5286(int var0, Script var1, boolean var2) {
		Widget var3;
		if (var0 >= 2000) {
			var0 -= 1000;
			var3 = Tile.getWidget(Interpreter.Interpreter_intStack[--class188.Interpreter_intStackSize]);
		} else {
			var3 = var2 ? UserComparator7.field1946 : class197.field2398;
		}

		LoginPacket.invalidateWidget(var3);
		if (var0 != ScriptOpcodes.CC_SETOBJECT && var0 != ScriptOpcodes.CC_SETOBJECT_NONUM && var0 != ScriptOpcodes.CC_SETOBJECT_ALWAYS_NUM) {
			if (var0 == ScriptOpcodes.CC_SETNPCHEAD) {
				var3.modelType = 2;
				var3.modelId = Interpreter.Interpreter_intStack[--class188.Interpreter_intStackSize];
				return 1;
			} else if (var0 == ScriptOpcodes.CC_SETPLAYERHEAD_SELF) {
				var3.modelType = 3;
				var3.modelId = Message.localPlayer.appearance.getChatHeadId();
				return 1;
			} else {
				return 2;
			}
		} else {
			class188.Interpreter_intStackSize -= 2;
			int var4 = Interpreter.Interpreter_intStack[class188.Interpreter_intStackSize];
			int var5 = Interpreter.Interpreter_intStack[class188.Interpreter_intStackSize + 1];
			var3.itemId = var4;
			var3.itemQuantity = var5;
			ItemDefinition var6 = PacketBufferNode.ItemDefinition_get(var4);
			var3.modelAngleX = var6.xan2d;
			var3.modelAngleY = var6.yan2d;
			var3.modelAngleZ = var6.zan2d;
			var3.modelOffsetX = var6.offsetX2d;
			var3.modelOffsetY = var6.offsetY2d;
			var3.modelZoom = var6.zoom2d;
			if (var0 == ScriptOpcodes.CC_SETOBJECT_NONUM) {
				var3.itemQuantityMode = 0;
			} else if (var0 == ScriptOpcodes.CC_SETOBJECT_ALWAYS_NUM | 1 == var6.isStackable) {
				var3.itemQuantityMode = 1;
			} else {
				var3.itemQuantityMode = 2;
			}

			if (var3.field2645 > 0) {
				var3.modelZoom = var3.modelZoom * 32 / var3.field2645;
			} else if (var3.rawWidth > 0) {
				var3.modelZoom = var3.modelZoom * 32 / var3.rawWidth;
			}

			return 1;
		}
	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(I)Lbe;",
		garbageValue = "-422000887"
	)
	@Export("getNextWorldListWorld")
	static World getNextWorldListWorld() {
		return World.World_listCount < World.World_count ? class162.World_worlds[++World.World_listCount - 1] : null;
	}

	@ObfuscatedName("kq")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-2130982399"
	)
	@Export("FriendSystem_invalidateFriends")
	static final void FriendSystem_invalidateFriends() {
		for (int var0 = 0; var0 < Players.Players_count; ++var0) {
			Player var1 = Client.players[Players.Players_indices[var0]];
			var1.clearIsFriend();
		}

		class216.method4013();
		if (Calendar.clanChat != null) {
			Calendar.clanChat.clearFriends();
		}

	}
}
