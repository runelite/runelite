import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.ScriptOpcodes;

@ObfuscatedName("b")
@Implements("GrandExchangeOffer")
public class GrandExchangeOffer {
	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "Liy;"
	)
	@Export("ItemDefinition_modelArchive")
	public static AbstractArchive ItemDefinition_modelArchive;
	@ObfuscatedName("dk")
	@ObfuscatedSignature(
		signature = "Lih;"
	)
	@Export("archive2")
	static Archive archive2;
	@ObfuscatedName("x")
	@Export("state")
	byte state;
	@ObfuscatedName("m")
	@ObfuscatedGetter(
		intValue = -1191314621
	)
	@Export("id")
	public int id;
	@ObfuscatedName("k")
	@ObfuscatedGetter(
		intValue = -1373983325
	)
	@Export("unitPrice")
	public int unitPrice;
	@ObfuscatedName("d")
	@ObfuscatedGetter(
		intValue = -435168387
	)
	@Export("totalQuantity")
	public int totalQuantity;
	@ObfuscatedName("w")
	@ObfuscatedGetter(
		intValue = 1383495981
	)
	@Export("currentQuantity")
	public int currentQuantity;
	@ObfuscatedName("v")
	@ObfuscatedGetter(
		intValue = 1519014469
	)
	@Export("currentPrice")
	public int currentPrice;

	public GrandExchangeOffer() {
	}

	@ObfuscatedSignature(
		signature = "(Lkb;Z)V",
		garbageValue = "0"
	)
	public GrandExchangeOffer(Buffer var1, boolean var2) {
		this.state = var1.readByte();
		this.id = var1.readUnsignedShort();
		this.unitPrice = var1.readInt();
		this.totalQuantity = var1.readInt();
		this.currentQuantity = var1.readInt();
		this.currentPrice = var1.readInt();
	}

	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "1689314705"
	)
	@Export("status")
	public int status() {
		return this.state & 7;
	}

	@ObfuscatedName("d")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "-1922096625"
	)
	@Export("type")
	public int type() {
		return (this.state & 8) == 8 ? 1 : 0;
	}

	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "(II)V",
		garbageValue = "587802237"
	)
	void method211(int var1) {
		this.state &= -8;
		this.state = (byte)(this.state | var1 & 7);
	}

	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "(II)V",
		garbageValue = "-582599399"
	)
	void method187(int var1) {
		this.state &= -9;
		if (var1 == 1) {
			this.state = (byte)(this.state | 8);
		}

	}

	@ObfuscatedName("m")
	@ObfuscatedSignature(
		signature = "([Ljava/lang/String;[SIII)V",
		garbageValue = "922781737"
	)
	@Export("sortItemsByName")
	static void sortItemsByName(String[] var0, short[] var1, int var2, int var3) {
		if (var2 < var3) {
			int var4 = (var3 + var2) / 2;
			int var5 = var2;
			String var6 = var0[var4];
			var0[var4] = var0[var3];
			var0[var3] = var6;
			short var7 = var1[var4];
			var1[var4] = var1[var3];
			var1[var3] = var7;

			for (int var8 = var2; var8 < var3; ++var8) {
				if (var6 == null || var0[var8] != null && var0[var8].compareTo(var6) < (var8 & 1)) {
					String var9 = var0[var8];
					var0[var8] = var0[var5];
					var0[var5] = var9;
					short var10 = var1[var8];
					var1[var8] = var1[var5];
					var1[var5++] = var10;
				}
			}

			var0[var3] = var0[var5];
			var0[var5] = var6;
			var1[var3] = var1[var5];
			var1[var5] = var7;
			sortItemsByName(var0, var1, var2, var5 - 1);
			sortItemsByName(var0, var1, var5 + 1, var3);
		}

	}

	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "(ILce;ZB)I",
		garbageValue = "19"
	)
	static int method191(int var0, Script var1, boolean var2) {
		Widget var3 = var2 ? GrandExchangeOfferNameComparator.field115 : Interpreter.field1130;
		if (var0 == ScriptOpcodes.CC_GETX) {
			Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var3.x;
			return 1;
		} else if (var0 == ScriptOpcodes.CC_GETY) {
			Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var3.y;
			return 1;
		} else if (var0 == ScriptOpcodes.CC_GETWIDTH) {
			Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var3.width;
			return 1;
		} else if (var0 == ScriptOpcodes.CC_GETHEIGHT) {
			Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var3.height;
			return 1;
		} else if (var0 == ScriptOpcodes.CC_GETHIDE) {
			Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var3.isHidden ? 1 : 0;
			return 1;
		} else if (var0 == ScriptOpcodes.CC_GETLAYER) {
			Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var3.parentId;
			return 1;
		} else {
			return 2;
		}
	}

	@ObfuscatedName("hj")
	@ObfuscatedSignature(
		signature = "(ZLkj;B)V",
		garbageValue = "18"
	)
	@Export("updateNpcs")
	static final void updateNpcs(boolean var0, PacketBuffer var1) {
		Client.field801 = 0;
		Client.field851 = 0;
		WorldMapIcon_0.method304();

		int var2;
		while (var1.bitsRemaining(Client.packetWriter.serverPacketLength) >= 27) {
			var2 = var1.readBits(15);
			if (var2 == 32767) {
				break;
			}

			boolean var3 = false;
			if (Client.npcs[var2] == null) {
				Client.npcs[var2] = new NPC();
				var3 = true;
			}

			NPC var4 = Client.npcs[var2];
			Client.npcIndices[++Client.npcCount - 1] = var2;
			var4.npcCycle = Client.cycle;
			int var5;
			if (var0) {
				var5 = var1.readBits(8);
				if (var5 > 127) {
					var5 -= 256;
				}
			} else {
				var5 = var1.readBits(5);
				if (var5 > 15) {
					var5 -= 32;
				}
			}

			int var6 = Client.defaultRotations[var1.readBits(3)];
			if (var3) {
				var4.orientation = var4.rotation = var6;
			}

			int var7 = var1.readBits(1);
			int var8 = var1.readBits(1);
			if (var8 == 1) {
				Client.field725[++Client.field851 - 1] = var2;
			}

			int var9;
			if (var0) {
				var9 = var1.readBits(8);
				if (var9 > 127) {
					var9 -= 256;
				}
			} else {
				var9 = var1.readBits(5);
				if (var9 > 15) {
					var9 -= 32;
				}
			}

			var4.definition = class237.getNpcDefinition(var1.readBits(14));
			var4.field976 = var4.definition.size;
			var4.field1026 = var4.definition.rotation;
			if (var4.field1026 == 0) {
				var4.rotation = 0;
			}

			var4.walkSequence = var4.definition.walkSequence;
			var4.walkBackSequence = var4.definition.walkBackSequence;
			var4.walkLeftSequence = var4.definition.walkLeftSequence;
			var4.walkRightSequence = var4.definition.walkRightSequence;
			var4.readySequence = var4.definition.readySequence;
			var4.turnLeftSequence = var4.definition.turnLeftSequence;
			var4.turnRightSequence = var4.definition.turnRightSequence;
			var4.method2136(ByteArrayPool.localPlayer.pathX[0] + var9, ByteArrayPool.localPlayer.pathY[0] + var5, var7 == 1);
		}

		var1.exportIndex();
		WorldMapSection0.method335(var1);

		for (var2 = 0; var2 < Client.field801; ++var2) {
			int var10 = Client.field918[var2];
			if (Client.npcs[var10].npcCycle != Client.cycle) {
				Client.npcs[var10].definition = null;
				Client.npcs[var10] = null;
			}
		}

		if (var1.offset != Client.packetWriter.serverPacketLength) {
			throw new RuntimeException(var1.offset + "," + Client.packetWriter.serverPacketLength);
		} else {
			for (var2 = 0; var2 < Client.npcCount; ++var2) {
				if (Client.npcs[Client.npcIndices[var2]] == null) {
					throw new RuntimeException(var2 + "," + Client.npcCount);
				}
			}

		}
	}

	@ObfuscatedName("iz")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "-21"
	)
	@Export("Widget_runOnTargetLeave")
	static void Widget_runOnTargetLeave() {
		if (Client.isSpellSelected) {
			Widget var0 = GrandExchangeOfferUnitPriceComparator.getWidgetChild(class7.selectedSpellWidget, Client.selectedSpellChildIndex);
			if (var0 != null && var0.onTargetLeave != null) {
				ScriptEvent var1 = new ScriptEvent();
				var1.widget = var0;
				var1.args = var0.onTargetLeave;
				GrandExchangeOfferOwnWorldComparator.runScriptEvent(var1);
			}

			Client.isSpellSelected = false;
			ItemContainer.invalidateWidget(var0);
		}
	}
}
