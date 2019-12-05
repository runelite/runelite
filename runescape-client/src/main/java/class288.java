import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("kh")
public final class class288 {
	@ObfuscatedName("u")
	@Export("base37Table")
	static final char[] base37Table;
	@ObfuscatedName("f")
	static long[] field3650;
	@ObfuscatedName("i")
	@ObfuscatedGetter(
		intValue = -1236461177
	)
	static int field3652;
	@ObfuscatedName("dh")
	@ObfuscatedSignature(
		signature = "Lij;"
	)
	@Export("archive2")
	static Archive archive2;

	static {
		base37Table = new char[]{'_', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
		field3650 = new long[12];

		for (int var0 = 0; var0 < field3650.length; ++var0) {
			field3650[var0] = (long)Math.pow(37.0D, (double)var0);
		}

	}

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "(IIB)I",
		garbageValue = "-123"
	)
	static int method5383(int var0, int var1) {
		FloorOverlayDefinition var2 = WorldMapRectangle.FloorUnderlayDefinition_get(var0);
		if (var2 == null) {
			return var1;
		} else if (var2.secondaryRgb >= 0) {
			return var2.secondaryRgb | -16777216;
		} else {
			int var3;
			if (var2.texture >= 0) {
				var3 = TilePaint.method3104(Rasterizer3D.Rasterizer3D_textureLoader.getAverageTextureRGB(var2.texture), 96);
				return Rasterizer3D.Rasterizer3D_colorPalette[var3] | -16777216;
			} else if (var2.primaryRgb == 16711935) {
				return var1;
			} else {
				var3 = JagexCache.method3531(var2.hue, var2.saturation, var2.lightness);
				byte var5 = 96;
				int var4;
				if (var3 == -2) {
					var4 = 12345678;
				} else {
					int var7;
					if (var3 == -1) {
						if (var5 < 0) {
							var5 = 0;
						} else if (var5 > 127) {
							var5 = 127;
						}

						var7 = 127 - var5;
						var4 = var7;
					} else {
						var7 = var5 * (var3 & 127) / 128;
						if (var7 < 2) {
							var7 = 2;
						} else if (var7 > 126) {
							var7 = 126;
						}

						var4 = var7 + (var3 & 65408);
					}
				}

				return Rasterizer3D.Rasterizer3D_colorPalette[var4] | -16777216;
			}
		}
	}

	@ObfuscatedName("b")
	@ObfuscatedSignature(
		signature = "(Lhf;III)Lln;",
		garbageValue = "170852381"
	)
	@Export("SpriteBuffer_getSprite")
	public static Sprite SpriteBuffer_getSprite(AbstractArchive var0, int var1, int var2) {
		return !GraphicsObject.method2030(var0, var1, var2) ? null : Occluder.method3338();
	}
}
