import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fu")
public enum class169 implements Enumerated {
	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "Lfu;"
	)
	field2012(0, 0),
	@ObfuscatedName("m")
	@ObfuscatedSignature(
		signature = "Lfu;"
	)
	field2007(1, 1),
	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "Lfu;"
	)
	field2008(3, 2),
	@ObfuscatedName("d")
	@ObfuscatedSignature(
		signature = "Lfu;"
	)
	field2006(2, 3);

	@ObfuscatedName("z")
	@Export("ItemDefinition_inMembersWorld")
	public static boolean ItemDefinition_inMembersWorld;
	@ObfuscatedName("gf")
	@ObfuscatedSignature(
		signature = "[Lle;"
	)
	@Export("mapSceneSprites")
	static IndexedSprite[] mapSceneSprites;
	@ObfuscatedName("w")
	@ObfuscatedGetter(
		intValue = -1763845437
	)
	public final int field2014;
	@ObfuscatedName("v")
	@ObfuscatedGetter(
		intValue = 1800480151
	)
	@Export("id")
	final int id;

	class169(int var3, int var4) {
		this.field2014 = var3;
		this.id = var4;
	}

	@ObfuscatedName("d")
	@ObfuscatedSignature(
		signature = "(B)I",
		garbageValue = "56"
	)
	@Export("rsOrdinal")
	public int rsOrdinal() {
		return this.id;
	}

	@ObfuscatedName("x")
	public static final void method3541(long var0) {
		if (var0 > 0L) {
			if (0L == var0 % 10L) {
				long var2 = var0 - 1L;

				try {
					Thread.sleep(var2);
				} catch (InterruptedException var8) {
				}

				try {
					Thread.sleep(1L);
				} catch (InterruptedException var7) {
				}
			} else {
				try {
					Thread.sleep(var0);
				} catch (InterruptedException var6) {
				}
			}

		}
	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(III)I",
		garbageValue = "2060432902"
	)
	static int method3545(int var0, int var1) {
		FloorOverlayDefinition var2 = UserComparator9.FloorUnderlayDefinition_get(var0);
		if (var2 == null) {
			return var1;
		} else if (var2.secondaryRgb >= 0) {
			return var2.secondaryRgb | -16777216;
		} else {
			int var4;
			int var5;
			if (var2.texture >= 0) {
				var4 = Rasterizer3D.Rasterizer3D_textureLoader.getAverageTextureRGB(var2.texture);
				byte var11 = 96;
				int var3;
				if (var4 == -2) {
					var3 = 12345678;
				} else if (var4 == -1) {
					if (var11 < 0) {
						var11 = 0;
					} else if (var11 > 127) {
						var11 = 127;
					}

					var5 = 127 - var11;
					var3 = var5;
				} else {
					var5 = var11 * (var4 & 127) / 128;
					if (var5 < 2) {
						var5 = 2;
					} else if (var5 > 126) {
						var5 = 126;
					}

					var3 = var5 + (var4 & 65408);
				}

				return Rasterizer3D.Rasterizer3D_colorPalette[var3] | -16777216;
			} else if (var2.primaryRgb == 16711935) {
				return var1;
			} else {
				var4 = var2.hue;
				var5 = var2.saturation;
				int var6 = var2.lightness;
				if (var6 > 179) {
					var5 /= 2;
				}

				if (var6 > 192) {
					var5 /= 2;
				}

				if (var6 > 217) {
					var5 /= 2;
				}

				if (var6 > 243) {
					var5 /= 2;
				}

				int var7 = (var5 / 32 << 7) + var6 / 2 + (var4 / 4 << 10);
				byte var9 = 96;
				int var8;
				if (var7 == -2) {
					var8 = 12345678;
				} else {
					int var12;
					if (var7 == -1) {
						if (var9 < 0) {
							var9 = 0;
						} else if (var9 > 127) {
							var9 = 127;
						}

						var12 = 127 - var9;
						var8 = var12;
					} else {
						var12 = var9 * (var7 & 127) / 128;
						if (var12 < 2) {
							var12 = 2;
						} else if (var12 > 126) {
							var12 = 126;
						}

						var8 = var12 + (var7 & 65408);
					}
				}

				return Rasterizer3D.Rasterizer3D_colorPalette[var8] | -16777216;
			}
		}
	}
}
