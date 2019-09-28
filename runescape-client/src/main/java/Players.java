import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cr")
@Implements("Players")
public class Players {
	@ObfuscatedName("v")
	static byte[] field1244;
	@ObfuscatedName("u")
	static byte[] field1235;
	@ObfuscatedName("r")
	@ObfuscatedSignature(
		signature = "[Lkl;"
	)
	static Buffer[] field1236;
	@ObfuscatedName("p")
	@ObfuscatedGetter(
		intValue = 842790617
	)
	@Export("Players_count")
	static int Players_count;
	@ObfuscatedName("q")
	@Export("Players_indices")
	static int[] Players_indices;
	@ObfuscatedName("m")
	@ObfuscatedGetter(
		intValue = -662435465
	)
	@Export("Players_emptyIdxCount")
	static int Players_emptyIdxCount;
	@ObfuscatedName("y")
	@Export("Players_emptyIndices")
	static int[] Players_emptyIndices;
	@ObfuscatedName("i")
	@Export("Players_regions")
	static int[] Players_regions;
	@ObfuscatedName("c")
	@Export("Players_orientations")
	static int[] Players_orientations;
	@ObfuscatedName("b")
	@Export("Players_targetIndices")
	static int[] Players_targetIndices;
	@ObfuscatedName("o")
	@ObfuscatedGetter(
		intValue = 301065307
	)
	@Export("Players_pendingUpdateCount")
	static int Players_pendingUpdateCount;
	@ObfuscatedName("a")
	@Export("Players_pendingUpdateIndices")
	static int[] Players_pendingUpdateIndices;
	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "Lkl;"
	)
	static Buffer field1246;

	static {
		field1244 = new byte[2048];
		field1235 = new byte[2048];
		field1236 = new Buffer[2048];
		Players_count = 0;
		Players_indices = new int[2048];
		Players_emptyIdxCount = 0;
		Players_emptyIndices = new int[2048];
		Players_regions = new int[2048];
		Players_orientations = new int[2048];
		Players_targetIndices = new int[2048];
		Players_pendingUpdateCount = 0;
		Players_pendingUpdateIndices = new int[2048];
		field1246 = new Buffer(new byte[5000]);
	}

	@ObfuscatedName("gw")
	@ObfuscatedSignature(
		signature = "(Lbi;ZI)V",
		garbageValue = "-1924716638"
	)
	@Export("addPlayerToScene")
	static void addPlayerToScene(Player var0, boolean var1) {
		if (var0 != null && var0.isVisible() && !var0.isHidden) {
			var0.isUnanimated = false;
			if ((Client.isLowDetail && Players_count > 50 || Players_count > 200) && var1 && var0.readySequence == var0.movementSequence) {
				var0.isUnanimated = true;
			}

			int var2 = var0.x >> 7;
			int var3 = var0.y >> 7;
			if (var2 >= 0 && var2 < 104 && var3 >= 0 && var3 < 104) {
				long var4 = class267.calculateTag(0, 0, 0, false, var0.index);
				if (var0.model0 != null && Client.cycle >= var0.animationCycleStart && Client.cycle < var0.animationCycleEnd) {
					var0.isUnanimated = false;
					var0.tileHeight = MusicPatchPcmStream.getTileHeight(var0.x, var0.y, WorldMapRectangle.plane);
					var0.playerCycle = Client.cycle;
					PacketWriter.scene.addNullableObject(WorldMapRectangle.plane, var0.x, var0.y, var0.tileHeight, 60, var0, var0.rotation, var4, var0.field622, var0.field611, var0.field612, var0.field613);
				} else {
					if ((var0.x & 127) == 64 && (var0.y & 127) == 64) {
						if (Client.tileLastDrawnActor[var2][var3] == Client.viewportDrawCount) {
							return;
						}

						Client.tileLastDrawnActor[var2][var3] = Client.viewportDrawCount;
					}

					var0.tileHeight = MusicPatchPcmStream.getTileHeight(var0.x, var0.y, WorldMapRectangle.plane);
					var0.playerCycle = Client.cycle;
					PacketWriter.scene.drawEntity(WorldMapRectangle.plane, var0.x, var0.y, var0.tileHeight, 60, var0, var0.rotation, var4, var0.isWalking);
				}
			}
		}

	}
}
