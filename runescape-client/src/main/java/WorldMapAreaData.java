import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.ScriptOpcodes;

@ObfuscatedName("aw")
@Implements("WorldMapAreaData")
public class WorldMapAreaData extends WorldMapArea {
	@ObfuscatedName("v")
	@Export("worldMapData0Set")
	HashSet worldMapData0Set;
	@ObfuscatedName("n")
	@Export("worldMapData1Set")
	HashSet worldMapData1Set;
	@ObfuscatedName("x")
	@Export("iconList")
	List iconList;

	WorldMapAreaData() {
	}

	@ObfuscatedName("cg")
	@ObfuscatedSignature(
		signature = "(Lkp;Lkp;IZS)V",
		garbageValue = "-14333"
	)
	@Export("init")
	void init(Buffer var1, Buffer var2, int var3, boolean var4) {
		this.read(var1, var3);
		int var5 = var2.readUnsignedShort();
		this.worldMapData0Set = new HashSet(var5);

		int var6;
		for (var6 = 0; var6 < var5; ++var6) {
			WorldMapData_0 var7 = new WorldMapData_0();

			try {
				var7.init(var2);
			} catch (IllegalStateException var12) {
				continue;
			}

			this.worldMapData0Set.add(var7);
		}

		var6 = var2.readUnsignedShort();
		this.worldMapData1Set = new HashSet(var6);

		for (int var10 = 0; var10 < var6; ++var10) {
			WorldMapData_1 var8 = new WorldMapData_1();

			try {
				var8.init(var2);
			} catch (IllegalStateException var11) {
				continue;
			}

			this.worldMapData1Set.add(var8);
		}

		this.initIconsList(var2, var4);
	}

	@ObfuscatedName("cr")
	@ObfuscatedSignature(
		signature = "(Lkp;ZI)V",
		garbageValue = "-1209977249"
	)
	@Export("initIconsList")
	void initIconsList(Buffer var1, boolean var2) {
		this.iconList = new LinkedList();
		int var3 = var1.readUnsignedShort();

		for (int var4 = 0; var4 < var3; ++var4) {
			int var5 = var1.method5593();
			Coord var6 = new Coord(var1.readInt());
			boolean var7 = var1.readUnsignedByte() == 1;
			if (var2 || !var7) {
				this.iconList.add(new WorldMapIcon_0((Coord)null, var6, var5, (WorldMapLabel)null));
			}
		}

	}

	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "(ILce;ZI)I",
		garbageValue = "599780957"
	)
	static int method706(int var0, Script var1, boolean var2) {
		int var3;
		int var4;
		if (var0 == ScriptOpcodes.CC_CREATE) {
			class320.Interpreter_intStackSize -= 3;
			var3 = Interpreter.Interpreter_intStack[class320.Interpreter_intStackSize];
			var4 = Interpreter.Interpreter_intStack[class320.Interpreter_intStackSize + 1];
			int var5 = Interpreter.Interpreter_intStack[class320.Interpreter_intStackSize + 2];
			if (var4 == 0) {
				throw new RuntimeException();
			} else {
				Widget var6 = Varps.getWidget(var3);
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
						class186.field2331 = var12;
					} else {
						MidiPcmStream.field2444 = var12;
					}

					NPCDefinition.invalidateWidget(var6);
					return 1;
				}
			}
		} else {
			Widget var9;
			if (var0 == ScriptOpcodes.CC_DELETE) {
				var9 = var2 ? class186.field2331 : MidiPcmStream.field2444;
				Widget var10 = Varps.getWidget(var9.id);
				var10.children[var9.childIndex] = null;
				NPCDefinition.invalidateWidget(var10);
				return 1;
			} else if (var0 == ScriptOpcodes.CC_DELETEALL) {
				var9 = Varps.getWidget(Interpreter.Interpreter_intStack[--class320.Interpreter_intStackSize]);
				var9.children = null;
				NPCDefinition.invalidateWidget(var9);
				return 1;
			} else if (var0 != ScriptOpcodes.CC_FIND) {
				if (var0 == ScriptOpcodes.IF_FIND) {
					var9 = Varps.getWidget(Interpreter.Interpreter_intStack[--class320.Interpreter_intStackSize]);
					if (var9 != null) {
						Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = 1;
						if (var2) {
							class186.field2331 = var9;
						} else {
							MidiPcmStream.field2444 = var9;
						}
					} else {
						Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = 0;
					}

					return 1;
				} else {
					return 2;
				}
			} else {
				class320.Interpreter_intStackSize -= 2;
				var3 = Interpreter.Interpreter_intStack[class320.Interpreter_intStackSize];
				var4 = Interpreter.Interpreter_intStack[class320.Interpreter_intStackSize + 1];
				Widget var11 = SpriteMask.getWidgetChild(var3, var4);
				if (var11 != null && var4 != -1) {
					Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = 1;
					if (var2) {
						class186.field2331 = var11;
					} else {
						MidiPcmStream.field2444 = var11;
					}
				} else {
					Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = 0;
				}

				return 1;
			}
		}
	}

	@ObfuscatedName("ia")
	@ObfuscatedSignature(
		signature = "(III)V",
		garbageValue = "-1052520169"
	)
	@Export("resumePauseWidget")
	static void resumePauseWidget(int var0, int var1) {
		PacketBufferNode var2 = TilePaint.getPacketBufferNode(ClientPacket.field2256, Client.packetWriter.isaacCipher);
		var2.packetBuffer.writeShortLE(var1);
		var2.packetBuffer.writeInt(var0);
		Client.packetWriter.addNode(var2);
	}
}
