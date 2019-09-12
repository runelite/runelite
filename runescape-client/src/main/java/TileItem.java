import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.ScriptOpcodes;

@ObfuscatedName("cm")
@Implements("TileItem")
public final class TileItem extends Entity {
	@ObfuscatedName("n")
	@Export("Tiles_saturation")
	static int[] Tiles_saturation;
	@ObfuscatedName("c")
	@ObfuscatedGetter(
		intValue = -1255811811
	)
	@Export("id")
	int id;
	@ObfuscatedName("x")
	@ObfuscatedGetter(
		intValue = -411129151
	)
	@Export("quantity")
	int quantity;

	TileItem() {
	}

	@ObfuscatedName("d")
	@ObfuscatedSignature(
		signature = "(B)Ldr;",
		garbageValue = "-35"
	)
	@Export("getModel")
	protected final Model getModel() {
		return Player.ItemDefinition_get(this.id).getModel(this.quantity);
	}

	@ObfuscatedName("g")
	@ObfuscatedSignature(
		signature = "(ILcu;ZI)I",
		garbageValue = "-475912836"
	)
	static int method2091(int var0, Script var1, boolean var2) {
		int var3;
		int var4;
		if (var0 == ScriptOpcodes.CC_CREATE) {
			class160.Interpreter_intStackSize -= 3;
			var3 = Interpreter.Interpreter_intStack[class160.Interpreter_intStackSize];
			var4 = Interpreter.Interpreter_intStack[class160.Interpreter_intStackSize + 1];
			int var5 = Interpreter.Interpreter_intStack[class160.Interpreter_intStackSize + 2];
			if (var4 == 0) {
				throw new RuntimeException();
			} else {
				Widget var6 = Player.getWidget(var3);
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
						UserComparator9.field1941 = var12;
					} else {
						MidiPcmStream.field2410 = var12;
					}

					WorldMapID.invalidateWidget(var6);
					return 1;
				}
			}
		} else {
			Widget var9;
			if (var0 == ScriptOpcodes.CC_DELETE) {
				var9 = var2 ? UserComparator9.field1941 : MidiPcmStream.field2410;
				Widget var10 = Player.getWidget(var9.id);
				var10.children[var9.childIndex] = null;
				WorldMapID.invalidateWidget(var10);
				return 1;
			} else if (var0 == ScriptOpcodes.CC_DELETEALL) {
				var9 = Player.getWidget(Interpreter.Interpreter_intStack[--class160.Interpreter_intStackSize]);
				var9.children = null;
				WorldMapID.invalidateWidget(var9);
				return 1;
			} else if (var0 != ScriptOpcodes.CC_FIND) {
				if (var0 == ScriptOpcodes.IF_FIND) {
					var9 = Player.getWidget(Interpreter.Interpreter_intStack[--class160.Interpreter_intStackSize]);
					if (var9 != null) {
						Interpreter.Interpreter_intStack[++class160.Interpreter_intStackSize - 1] = 1;
						if (var2) {
							UserComparator9.field1941 = var9;
						} else {
							MidiPcmStream.field2410 = var9;
						}
					} else {
						Interpreter.Interpreter_intStack[++class160.Interpreter_intStackSize - 1] = 0;
					}

					return 1;
				} else {
					return 2;
				}
			} else {
				class160.Interpreter_intStackSize -= 2;
				var3 = Interpreter.Interpreter_intStack[class160.Interpreter_intStackSize];
				var4 = Interpreter.Interpreter_intStack[class160.Interpreter_intStackSize + 1];
				Widget var11 = class49.getWidgetChild(var3, var4);
				if (var11 != null && var4 != -1) {
					Interpreter.Interpreter_intStack[++class160.Interpreter_intStackSize - 1] = 1;
					if (var2) {
						UserComparator9.field1941 = var11;
					} else {
						MidiPcmStream.field2410 = var11;
					}
				} else {
					Interpreter.Interpreter_intStack[++class160.Interpreter_intStackSize - 1] = 0;
				}

				return 1;
			}
		}
	}

	@ObfuscatedName("ht")
	@ObfuscatedSignature(
		signature = "(IIIILjava/lang/String;I)V",
		garbageValue = "-2119996572"
	)
	static void method2093(int var0, int var1, int var2, int var3, String var4) {
		Widget var5 = class49.getWidgetChild(var1, var2);
		if (var5 != null) {
			if (var5.onOp != null) {
				ScriptEvent var6 = new ScriptEvent();
				var6.widget = var5;
				var6.opIndex = var0;
				var6.targetName = var4;
				var6.args = var5.onOp;
				SecureRandomFuture.runScriptEvent(var6);
			}

			boolean var8 = true;
			if (var5.contentType > 0) {
				var8 = class49.method825(var5);
			}

			if (var8) {
				if (class210.method3951(class60.getWidgetClickMask(var5), var0 - 1)) {
					PacketBufferNode var7;
					if (var0 == 1) {
						var7 = MenuAction.getPacketBufferNode(ClientPacket.field2279, Client.packetWriter.isaacCipher);
						var7.packetBuffer.writeInt(var1);
						var7.packetBuffer.writeShort(var2);
						var7.packetBuffer.writeShort(var3);
						Client.packetWriter.addNode(var7);
					}

					if (var0 == 2) {
						var7 = MenuAction.getPacketBufferNode(ClientPacket.field2228, Client.packetWriter.isaacCipher);
						var7.packetBuffer.writeInt(var1);
						var7.packetBuffer.writeShort(var2);
						var7.packetBuffer.writeShort(var3);
						Client.packetWriter.addNode(var7);
					}

					if (var0 == 3) {
						var7 = MenuAction.getPacketBufferNode(ClientPacket.field2202, Client.packetWriter.isaacCipher);
						var7.packetBuffer.writeInt(var1);
						var7.packetBuffer.writeShort(var2);
						var7.packetBuffer.writeShort(var3);
						Client.packetWriter.addNode(var7);
					}

					if (var0 == 4) {
						var7 = MenuAction.getPacketBufferNode(ClientPacket.field2231, Client.packetWriter.isaacCipher);
						var7.packetBuffer.writeInt(var1);
						var7.packetBuffer.writeShort(var2);
						var7.packetBuffer.writeShort(var3);
						Client.packetWriter.addNode(var7);
					}

					if (var0 == 5) {
						var7 = MenuAction.getPacketBufferNode(ClientPacket.field2258, Client.packetWriter.isaacCipher);
						var7.packetBuffer.writeInt(var1);
						var7.packetBuffer.writeShort(var2);
						var7.packetBuffer.writeShort(var3);
						Client.packetWriter.addNode(var7);
					}

					if (var0 == 6) {
						var7 = MenuAction.getPacketBufferNode(ClientPacket.field2251, Client.packetWriter.isaacCipher);
						var7.packetBuffer.writeInt(var1);
						var7.packetBuffer.writeShort(var2);
						var7.packetBuffer.writeShort(var3);
						Client.packetWriter.addNode(var7);
					}

					if (var0 == 7) {
						var7 = MenuAction.getPacketBufferNode(ClientPacket.field2199, Client.packetWriter.isaacCipher);
						var7.packetBuffer.writeInt(var1);
						var7.packetBuffer.writeShort(var2);
						var7.packetBuffer.writeShort(var3);
						Client.packetWriter.addNode(var7);
					}

					if (var0 == 8) {
						var7 = MenuAction.getPacketBufferNode(ClientPacket.field2207, Client.packetWriter.isaacCipher);
						var7.packetBuffer.writeInt(var1);
						var7.packetBuffer.writeShort(var2);
						var7.packetBuffer.writeShort(var3);
						Client.packetWriter.addNode(var7);
					}

					if (var0 == 9) {
						var7 = MenuAction.getPacketBufferNode(ClientPacket.field2247, Client.packetWriter.isaacCipher);
						var7.packetBuffer.writeInt(var1);
						var7.packetBuffer.writeShort(var2);
						var7.packetBuffer.writeShort(var3);
						Client.packetWriter.addNode(var7);
					}

					if (var0 == 10) {
						var7 = MenuAction.getPacketBufferNode(ClientPacket.field2217, Client.packetWriter.isaacCipher);
						var7.packetBuffer.writeInt(var1);
						var7.packetBuffer.writeShort(var2);
						var7.packetBuffer.writeShort(var3);
						Client.packetWriter.addNode(var7);
					}

				}
			}
		}
	}
}
