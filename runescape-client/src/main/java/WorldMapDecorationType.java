import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hs")
@Implements("WorldMapDecorationType")
public enum WorldMapDecorationType implements Enumerated {
	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "Lhs;"
	)
	field2719(0, 0),
	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "Lhs;"
	)
	field2706(1, 0),
	@ObfuscatedName("y")
	@ObfuscatedSignature(
		signature = "Lhs;"
	)
	field2710(2, 0),
	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "Lhs;"
	)
	field2708(3, 0),
	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "Lhs;"
	)
	field2707(9, 2),
	@ObfuscatedName("b")
	@ObfuscatedSignature(
		signature = "Lhs;"
	)
	field2711(4, 1),
	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "Lhs;"
	)
	field2724(5, 1),
	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "Lhs;"
	)
	field2712(6, 1),
	@ObfuscatedName("a")
	@ObfuscatedSignature(
		signature = "Lhs;"
	)
	field2713(7, 1),
	@ObfuscatedName("d")
	@ObfuscatedSignature(
		signature = "Lhs;"
	)
	field2714(8, 1),
	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "Lhs;"
	)
	field2715(12, 2),
	@ObfuscatedName("o")
	@ObfuscatedSignature(
		signature = "Lhs;"
	)
	field2716(13, 2),
	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "Lhs;"
	)
	field2723(14, 2),
	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "Lhs;"
	)
	field2721(15, 2),
	@ObfuscatedName("s")
	@ObfuscatedSignature(
		signature = "Lhs;"
	)
	field2722(16, 2),
	@ObfuscatedName("l")
	@ObfuscatedSignature(
		signature = "Lhs;"
	)
	field2720(17, 2),
	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "Lhs;"
	)
	field2718(18, 2),
	@ObfuscatedName("j")
	@ObfuscatedSignature(
		signature = "Lhs;"
	)
	field2717(19, 2),
	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "Lhs;"
	)
	field2705(20, 2),
	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "Lhs;"
	)
	field2709(21, 2),
	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "Lhs;"
	)
	field2725(10, 2),
	@ObfuscatedName("h")
	@ObfuscatedSignature(
		signature = "Lhs;"
	)
	field2726(11, 2),
	@ObfuscatedName("m")
	@ObfuscatedSignature(
		signature = "Lhs;"
	)
	field2727(22, 3);

	@ObfuscatedName("g")
	@ObfuscatedGetter(
		intValue = -1693964609
	)
	@Export("id")
	public final int id;

	@ObfuscatedSignature(
		signature = "(II)V",
		garbageValue = "0"
	)
	WorldMapDecorationType(int var3, int var4) {
		this.id = var3;
	}

	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "(B)I",
		garbageValue = "-57"
	)
	@Export("rsOrdinal")
	public int rsOrdinal() {
		return this.id;
	}

	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "(Lhz;I)V",
		garbageValue = "1637716955"
	)
	public static void method4079(AbstractArchive var0) {
		FloorUnderlayDefinition.FloorUnderlayDefinition_archive = var0;
	}

	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "(III)I",
		garbageValue = "500637540"
	)
	public static int method4085(int var0, int var1) {
		return (var0 << 8) + var1;
	}

	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "(Lkl;IB)Z",
		garbageValue = "17"
	)
	@Export("updateExternalPlayer")
	static boolean updateExternalPlayer(PacketBuffer var0, int var1) {
		int var2 = var0.readBits(2);
		int var3;
		int var4;
		int var7;
		int var8;
		int var9;
		int var10;
		if (var2 == 0) {
			if (var0.readBits(1) != 0) {
				updateExternalPlayer(var0, var1);
			}

			var3 = var0.readBits(13);
			var4 = var0.readBits(13);
			boolean var12 = var0.readBits(1) == 1;
			if (var12) {
				Players.Players_pendingUpdateIndices[++Players.Players_pendingUpdateCount - 1] = var1;
			}

			if (Client.players[var1] != null) {
				throw new RuntimeException();
			} else {
				Player var6 = Client.players[var1] = new Player();
				var6.index = var1;
				if (Players.field1228[var1] != null) {
					var6.read(Players.field1228[var1]);
				}

				var6.orientation = Players.Players_orientations[var1];
				var6.targetIndex = Players.Players_targetIndices[var1];
				var7 = Players.Players_regions[var1];
				var8 = var7 >> 28;
				var9 = var7 >> 14 & 255;
				var10 = var7 & 255;
				var6.pathTraversed[0] = Players.field1231[var1];
				var6.plane = (byte)var8;
				var6.resetPath((var9 << 13) + var3 - MusicPatchPcmStream.baseX * 64, (var10 << 13) + var4 - ScriptEvent.baseY * 64);
				var6.field616 = false;
				return true;
			}
		} else if (var2 == 1) {
			var3 = var0.readBits(2);
			var4 = Players.Players_regions[var1];
			Players.Players_regions[var1] = (var4 & 268435455) + (((var4 >> 28) + var3 & 3) << 28);
			return false;
		} else {
			int var5;
			int var11;
			if (var2 == 2) {
				var3 = var0.readBits(5);
				var4 = var3 >> 3;
				var5 = var3 & 7;
				var11 = Players.Players_regions[var1];
				var7 = (var11 >> 28) + var4 & 3;
				var8 = var11 >> 14 & 255;
				var9 = var11 & 255;
				if (var5 == 0) {
					--var8;
					--var9;
				}

				if (var5 == 1) {
					--var9;
				}

				if (var5 == 2) {
					++var8;
					--var9;
				}

				if (var5 == 3) {
					--var8;
				}

				if (var5 == 4) {
					++var8;
				}

				if (var5 == 5) {
					--var8;
					++var9;
				}

				if (var5 == 6) {
					++var9;
				}

				if (var5 == 7) {
					++var8;
					++var9;
				}

				Players.Players_regions[var1] = (var8 << 14) + var9 + (var7 << 28);
				return false;
			} else {
				var3 = var0.readBits(18);
				var4 = var3 >> 16;
				var5 = var3 >> 8 & 255;
				var11 = var3 & 255;
				var7 = Players.Players_regions[var1];
				var8 = (var7 >> 28) + var4 & 3;
				var9 = var5 + (var7 >> 14) & 255;
				var10 = var7 + var11 & 255;
				Players.Players_regions[var1] = (var9 << 14) + var10 + (var8 << 28);
				return false;
			}
		}
	}
}
