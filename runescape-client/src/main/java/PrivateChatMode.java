import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ku")
@Implements("PrivateChatMode")
public class PrivateChatMode {
	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "Lku;"
	)
	static final PrivateChatMode field3790;
	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "Lku;"
	)
	public static final PrivateChatMode field3791;
	@ObfuscatedName("y")
	@ObfuscatedSignature(
		signature = "Lku;"
	)
	static final PrivateChatMode field3792;
	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "Lho;"
	)
	@Export("NetCache_currentResponse")
	public static NetFileRequest NetCache_currentResponse;
	@ObfuscatedName("w")
	@ObfuscatedGetter(
		intValue = 1903603553
	)
	public final int field3793;

	static {
		field3790 = new PrivateChatMode(0);
		field3791 = new PrivateChatMode(1);
		field3792 = new PrivateChatMode(2);
	}

	PrivateChatMode(int var1) {
		this.field3793 = var1;
	}

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "(Lkq;IIIIIII)V",
		garbageValue = "-1462890137"
	)
	@Export("loadTerrain")
	static final void loadTerrain(Buffer var0, int var1, int var2, int var3, int var4, int var5, int var6) {
		int var7;
		if (var2 >= 0 && var2 < 104 && var3 >= 0 && var3 < 104) {
			Tiles.Tiles_renderFlags[var1][var2][var3] = 0;

			while (true) {
				var7 = var0.readUnsignedByte();
				if (var7 == 0) {
					if (var1 == 0) {
						int[] var8 = Tiles.Tiles_heights[0][var2];
						int var11 = var2 + var4 + 932731;
						int var12 = var3 + var5 + 556238;
						int var13 = CollisionMap.method3530(45365 + var11, 91923 + var12, 4) - 128 + (CollisionMap.method3530(var11 + 10294, var12 + 37821, 2) - 128 >> 1) + (CollisionMap.method3530(var11, var12, 1) - 128 >> 2);
						var13 = (int)(0.3D * (double)var13) + 35;
						if (var13 < 10) {
							var13 = 10;
						} else if (var13 > 60) {
							var13 = 60;
						}

						var8[var3] = -var13 * 8;
					} else {
						Tiles.Tiles_heights[var1][var2][var3] = Tiles.Tiles_heights[var1 - 1][var2][var3] - 240;
					}
					break;
				}

				if (var7 == 1) {
					int var14 = var0.readUnsignedByte();
					if (var14 == 1) {
						var14 = 0;
					}

					if (var1 == 0) {
						Tiles.Tiles_heights[0][var2][var3] = -var14 * 8;
					} else {
						Tiles.Tiles_heights[var1][var2][var3] = Tiles.Tiles_heights[var1 - 1][var2][var3] - var14 * 8;
					}
					break;
				}

				if (var7 <= 49) {
					Tiles.field498[var1][var2][var3] = var0.readByte();
					Tiles.field494[var1][var2][var3] = (byte)((var7 - 2) / 4);
					Tiles.field493[var1][var2][var3] = (byte)(var7 - 2 + var6 & 3);
				} else if (var7 <= 81) {
					Tiles.Tiles_renderFlags[var1][var2][var3] = (byte)(var7 - 49);
				} else {
					class14.field88[var1][var2][var3] = (byte)(var7 - 81);
				}
			}
		} else {
			while (true) {
				var7 = var0.readUnsignedByte();
				if (var7 == 0) {
					break;
				}

				if (var7 == 1) {
					var0.readUnsignedByte();
					break;
				}

				if (var7 <= 49) {
					var0.readUnsignedByte();
				}
			}
		}

	}
}
