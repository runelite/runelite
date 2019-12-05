import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ey")
@Implements("TilePaint")
public final class TilePaint {
	@ObfuscatedName("ns")
	@ObfuscatedGetter(
		intValue = -1788868487
	)
	static int field1782;
	@ObfuscatedName("u")
	@ObfuscatedGetter(
		intValue = -94402457
	)
	@Export("swColor")
	int swColor;
	@ObfuscatedName("f")
	@ObfuscatedGetter(
		intValue = 1565892331
	)
	@Export("seColor")
	int seColor;
	@ObfuscatedName("b")
	@ObfuscatedGetter(
		intValue = 813293965
	)
	@Export("neColor")
	int neColor;
	@ObfuscatedName("g")
	@ObfuscatedGetter(
		intValue = -1163969349
	)
	@Export("nwColor")
	int nwColor;
	@ObfuscatedName("z")
	@ObfuscatedGetter(
		intValue = 1857222665
	)
	@Export("texture")
	int texture;
	@ObfuscatedName("p")
	@Export("isFlat")
	boolean isFlat;
	@ObfuscatedName("h")
	@ObfuscatedGetter(
		intValue = -1506842685
	)
	@Export("rgb")
	int rgb;

	TilePaint(int var1, int var2, int var3, int var4, int var5, int var6, boolean var7) {
		this.isFlat = true;
		this.swColor = var1;
		this.seColor = var2;
		this.neColor = var3;
		this.nwColor = var4;
		this.texture = var5;
		this.rgb = var6;
		this.isFlat = var7;
	}

	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "(IIB)I",
		garbageValue = "82"
	)
	static int method3104(int var0, int var1) {
		if (var0 == -2) {
			return 12345678;
		} else if (var0 == -1) {
			if (var1 < 0) {
				var1 = 0;
			} else if (var1 > 127) {
				var1 = 127;
			}

			var1 = 127 - var1;
			return var1;
		} else {
			var1 = (var0 & 127) * var1 / 128;
			if (var1 < 2) {
				var1 = 2;
			} else if (var1 > 126) {
				var1 = 126;
			}

			return (var0 & 65408) + var1;
		}
	}

	@ObfuscatedName("b")
	@ObfuscatedSignature(
		signature = "(IIII)V",
		garbageValue = "606674318"
	)
	static final void method3105(int var0, int var1, int var2) {
		int var3;
		for (var3 = 0; var3 < 8; ++var3) {
			for (int var4 = 0; var4 < 8; ++var4) {
				Tiles.Tiles_heights[var0][var3 + var1][var4 + var2] = 0;
			}
		}

		if (var1 > 0) {
			for (var3 = 1; var3 < 8; ++var3) {
				Tiles.Tiles_heights[var0][var1][var3 + var2] = Tiles.Tiles_heights[var0][var1 - 1][var3 + var2];
			}
		}

		if (var2 > 0) {
			for (var3 = 1; var3 < 8; ++var3) {
				Tiles.Tiles_heights[var0][var3 + var1][var2] = Tiles.Tiles_heights[var0][var3 + var1][var2 - 1];
			}
		}

		if (var1 > 0 && Tiles.Tiles_heights[var0][var1 - 1][var2] != 0) {
			Tiles.Tiles_heights[var0][var1][var2] = Tiles.Tiles_heights[var0][var1 - 1][var2];
		} else if (var2 > 0 && Tiles.Tiles_heights[var0][var1][var2 - 1] != 0) {
			Tiles.Tiles_heights[var0][var1][var2] = Tiles.Tiles_heights[var0][var1][var2 - 1];
		} else if (var1 > 0 && var2 > 0 && Tiles.Tiles_heights[var0][var1 - 1][var2 - 1] != 0) {
			Tiles.Tiles_heights[var0][var1][var2] = Tiles.Tiles_heights[var0][var1 - 1][var2 - 1];
		}

	}

	@ObfuscatedName("g")
	@ObfuscatedSignature(
		signature = "(II)V",
		garbageValue = "-770375157"
	)
	public static void method3103(int var0) {
		if (class197.field2411 != 0) {
			class197.musicTrackVolume = var0;
		} else {
			FaceNormal.midiPcmStream.setPcmStreamVolume(var0);
		}

	}
}
