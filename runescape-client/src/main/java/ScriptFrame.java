import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bp")
@Implements("ScriptFrame")
public class ScriptFrame {
	@ObfuscatedName("s")
	@ObfuscatedGetter(
		intValue = 1672525423
	)
	@Export("pc")
	int pc;
	@ObfuscatedName("j")
	@ObfuscatedSignature(
		signature = "Lcr;"
	)
	@Export("script")
	Script script;
	@ObfuscatedName("i")
	@Export("intLocals")
	int[] intLocals;
	@ObfuscatedName("k")
	@Export("stringLocals")
	String[] stringLocals;

	ScriptFrame() {
		this.pc = -1;
	}

	@ObfuscatedName("s")
	@ObfuscatedSignature(
		signature = "(Lkx;I)V",
		garbageValue = "923319519"
	)
	@Export("updatePlayer")
	static final void updatePlayer(PacketBuffer var0) {
		var0.importIndex();
		int var1 = Client.localPlayerIndex;
		Player var2 = WorldMapIcon_1.localPlayer = Client.players[var1] = new Player();
		var2.index = var1;
		int var3 = var0.readBits(30);
		byte var4 = (byte)(var3 >> 28);
		int var5 = var3 >> 14 & 16383;
		int var6 = var3 & 16383;
		var2.pathX[0] = var5 - PacketWriter.baseX * 64;
		var2.x = (var2.pathX[0] << 7) + (var2.transformedSize() << 6);
		var2.pathY[0] = var6 - RouteStrategy.baseY * 64;
		var2.y = (var2.pathY[0] << 7) + (var2.transformedSize() << 6);
		ItemContainer.plane = var2.plane = var4;
		if (Players.field1219[var1] != null) {
			var2.read(Players.field1219[var1]);
		}

		Players.Players_count = 0;
		Players.Players_indices[++Players.Players_count - 1] = var1;
		Players.field1221[var1] = 0;
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
				Players.field1221[var7] = 0;
			}
		}

		var0.exportIndex();
	}

	@ObfuscatedName("je")
	@ObfuscatedSignature(
		signature = "(IIB)V",
		garbageValue = "53"
	)
	static void method1092(int var0, int var1) {
		MenuAction var2 = class1.tempMenuAction;
		SecureRandomFuture.menuAction(var2.argument1, var2.argument2, var2.opcode, var2.argument0, var2.action, var2.action, var0, var1);
		class1.tempMenuAction = null;
	}
}
