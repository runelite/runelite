import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.ScriptOpcodes;

@ObfuscatedName("ck")
@Implements("MenuAction")
public class MenuAction {
	@ObfuscatedName("c")
	@ObfuscatedGetter(
		intValue = -171831145
	)
	@Export("param0")
	int param0;
	@ObfuscatedName("t")
	@Export("action")
	String action;
	@ObfuscatedName("o")
	@ObfuscatedGetter(
		intValue = -923254575
	)
	@Export("param1")
	int param1;
	@ObfuscatedName("e")
	@ObfuscatedGetter(
		intValue = -1388301791
	)
	@Export("opcode")
	int opcode;
	@ObfuscatedName("i")
	@ObfuscatedGetter(
		intValue = 455082071
	)
	@Export("identifier")
	int identifier;

	MenuAction() {
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(Lks;I)V",
		garbageValue = "-1231997766"
	)
	@Export("updatePlayer")
	static final void updatePlayer(PacketBuffer var0) {
		var0.importIndex();
		int var1 = Client.localPlayerIndex;
		Player var2 = class192.localPlayer = Client.players[var1] = new Player();
		var2.index = var1;
		int var3 = var0.readBits(30);
		byte var4 = (byte)(var3 >> 28);
		int var5 = var3 >> 14 & 16383;
		int var6 = var3 & 16383;
		var2.pathX[0] = var5 - Messages.baseX * 64;
		var2.x = (var2.pathX[0] << 7) + (var2.transformedSize() << 6);
		var2.pathY[0] = var6 - Language.baseY * 64;
		var2.y = (var2.pathY[0] << 7) + (var2.transformedSize() << 6);
		Clock.Client_plane = var2.plane = var4;
		if (Players.field1235[var1] != null) {
			var2.read(Players.field1235[var1]);
		}

		Players.Players_count = 0;
		Players.Players_indices[++Players.Players_count - 1] = var1;
		Players.field1236[var1] = 0;
		Players.Players_emptyIdxCount = 0;

		for (int var7 = 1; var7 < 2048; ++var7) {
			if (var1 != var7) {
				int var8 = var0.readBits(18);
				int var9 = var8 >> 16;
				int var10 = var8 >> 8 & 597;
				int var11 = var8 & 597;
				Players.Players_regions[var7] = (var10 << 14) + var11 + (var9 << 28);
				Players.Players_orientations[var7] = 0;
				Players.Players_targetIndices[var7] = -1;
				Players.Players_emptyIndices[++Players.Players_emptyIdxCount - 1] = var7;
				Players.field1236[var7] = 0;
			}
		}

		var0.exportIndex();
	}

	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "(ILce;ZI)I",
		garbageValue = "1513709763"
	)
	static int method2106(int var0, Script var1, boolean var2) {
		int var3 = -1;
		Widget var4;
		if (var0 >= 2000) {
			var0 -= 1000;
			var3 = Interpreter.Interpreter_intStack[--class320.Interpreter_intStackSize];
			var4 = Varps.getWidget(var3);
		} else {
			var4 = var2 ? class186.field2331 : MidiPcmStream.field2444;
		}

		if (var0 == ScriptOpcodes.CC_SETPOSITION) {
			class320.Interpreter_intStackSize -= 4;
			var4.rawX = Interpreter.Interpreter_intStack[class320.Interpreter_intStackSize];
			var4.rawY = Interpreter.Interpreter_intStack[class320.Interpreter_intStackSize + 1];
			var4.xAlignment = Interpreter.Interpreter_intStack[class320.Interpreter_intStackSize + 2];
			var4.yAlignment = Interpreter.Interpreter_intStack[class320.Interpreter_intStackSize + 3];
			NPCDefinition.invalidateWidget(var4);
			Username.client.alignWidget(var4);
			if (var3 != -1 && var4.type == 0) {
				WorldMapIcon_1.revalidateWidgetScroll(WorldMapLabel.Widget_interfaceComponents[var3 >> 16], var4, false);
			}

			return 1;
		} else if (var0 == ScriptOpcodes.CC_SETSIZE) {
			class320.Interpreter_intStackSize -= 4;
			var4.rawWidth = Interpreter.Interpreter_intStack[class320.Interpreter_intStackSize];
			var4.rawHeight = Interpreter.Interpreter_intStack[class320.Interpreter_intStackSize + 1];
			var4.widthAlignment = Interpreter.Interpreter_intStack[class320.Interpreter_intStackSize + 2];
			var4.heightAlignment = Interpreter.Interpreter_intStack[class320.Interpreter_intStackSize + 3];
			NPCDefinition.invalidateWidget(var4);
			Username.client.alignWidget(var4);
			if (var3 != -1 && var4.type == 0) {
				WorldMapIcon_1.revalidateWidgetScroll(WorldMapLabel.Widget_interfaceComponents[var3 >> 16], var4, false);
			}

			return 1;
		} else if (var0 == ScriptOpcodes.CC_SETHIDE) {
			boolean var5 = Interpreter.Interpreter_intStack[--class320.Interpreter_intStackSize] == 1;
			if (var5 != var4.isHidden) {
				var4.isHidden = var5;
				NPCDefinition.invalidateWidget(var4);
			}

			return 1;
		} else if (var0 == ScriptOpcodes.CC_SETNOCLICKTHROUGH) {
			var4.noClickThrough = Interpreter.Interpreter_intStack[--class320.Interpreter_intStackSize] == 1;
			return 1;
		} else if (var0 == ScriptOpcodes.CC_SETNOSCROLLTHROUGH) {
			var4.noScrollThrough = Interpreter.Interpreter_intStack[--class320.Interpreter_intStackSize] == 1;
			return 1;
		} else {
			return 2;
		}
	}

	@ObfuscatedName("kg")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-879378563"
	)
	@Export("Clan_leaveChat")
	static final void Clan_leaveChat() {
		PacketBufferNode var0 = TilePaint.getPacketBufferNode(ClientPacket.field2252, Client.packetWriter.isaacCipher);
		var0.packetBuffer.writeByte(0);
		Client.packetWriter.addNode(var0);
	}
}
