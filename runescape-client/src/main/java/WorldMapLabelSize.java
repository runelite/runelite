import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("e")
@Implements("WorldMapLabelSize")
public class WorldMapLabelSize {
	@ObfuscatedName("s")
	@ObfuscatedSignature(
		signature = "Le;"
	)
	@Export("WorldMapLabelSize_small")
	public static final WorldMapLabelSize WorldMapLabelSize_small;
	@ObfuscatedName("j")
	@ObfuscatedSignature(
		signature = "Le;"
	)
	@Export("WorldMapLabelSize_medium")
	public static final WorldMapLabelSize WorldMapLabelSize_medium;
	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "Le;"
	)
	@Export("WorldMapLabelSize_large")
	public static final WorldMapLabelSize WorldMapLabelSize_large;
	@ObfuscatedName("k")
	@ObfuscatedGetter(
		intValue = 658824929
	)
	final int field108;
	@ObfuscatedName("u")
	@ObfuscatedGetter(
		intValue = -84893291
	)
	final int field105;
	@ObfuscatedName("n")
	@ObfuscatedGetter(
		intValue = 1954115307
	)
	final int field110;

	static {
		WorldMapLabelSize_small = new WorldMapLabelSize(1, 0, 4);
		WorldMapLabelSize_medium = new WorldMapLabelSize(0, 1, 2);
		WorldMapLabelSize_large = new WorldMapLabelSize(2, 2, 0);
	}

	WorldMapLabelSize(int var1, int var2, int var3) {
		this.field108 = var1;
		this.field105 = var2;
		this.field110 = var3;
	}

	@ObfuscatedName("j")
	@ObfuscatedSignature(
		signature = "(FI)Z",
		garbageValue = "-1981348285"
	)
	boolean method185(float var1) {
		return var1 >= (float)this.field110;
	}

	@ObfuscatedName("s")
	@ObfuscatedSignature(
		signature = "(I)[Le;",
		garbageValue = "-1460468047"
	)
	static WorldMapLabelSize[] method190() {
		return new WorldMapLabelSize[]{WorldMapLabelSize_small, WorldMapLabelSize_large, WorldMapLabelSize_medium};
	}

	@ObfuscatedName("n")
	static boolean method186(long var0) {
		return (int)(var0 >>> 16 & 1L) == 1;
	}

	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "(Lkx;II)Z",
		garbageValue = "751514225"
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
				if (Players.field1219[var1] != null) {
					var6.read(Players.field1219[var1]);
				}

				var6.orientation = Players.Players_orientations[var1];
				var6.targetIndex = Players.Players_targetIndices[var1];
				var7 = Players.Players_regions[var1];
				var8 = var7 >> 28;
				var9 = var7 >> 14 & 255;
				var10 = var7 & 255;
				var6.pathTraversed[0] = Players.field1230[var1];
				var6.plane = (byte)var8;
				var6.resetPath((var9 << 13) + var3 - PacketWriter.baseX * 64, (var10 << 13) + var4 - RouteStrategy.baseY * 64);
				var6.field614 = false;
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
