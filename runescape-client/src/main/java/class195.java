import java.util.HashMap;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gk")
public class class195 {
	static {
		new HashMap();
	}

	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "(II)Z",
		garbageValue = "338644626"
	)
	public static boolean method3743(int var0) {
		return var0 == WorldMapDecorationType.field2749.id;
	}

	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "(IIII)Lci;",
		garbageValue = "-990900321"
	)
	@Export("getWorldMapScript")
	static Script getWorldMapScript(int var0, int var1, int var2) {
		int var3 = (var1 << 8) + var0;
		Script var5 = class49.method880(var3, var0);
		if (var5 != null) {
			return var5;
		} else {
			int var6 = var0 + (var2 + 40000 << 8);
			var5 = class49.method880(var6, var0);
			return var5 != null ? var5 : null;
		}
	}

	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "([BIIB)Ljava/lang/String;",
		garbageValue = "9"
	)
	static String method3739(byte[] var0, int var1, int var2) {
		StringBuilder var3 = new StringBuilder();

		for (int var4 = var1; var4 < var2 + var1; var4 += 3) {
			int var5 = var0[var4] & 255;
			var3.append(class289.field3653[var5 >>> 2]);
			if (var4 < var2 - 1) {
				int var6 = var0[var4 + 1] & 255;
				var3.append(class289.field3653[(var5 & 3) << 4 | var6 >>> 4]);
				if (var4 < var2 - 2) {
					int var7 = var0[var4 + 2] & 255;
					var3.append(class289.field3653[(var6 & 15) << 2 | var7 >>> 6]).append(class289.field3653[var7 & 63]);
				} else {
					var3.append(class289.field3653[(var6 & 15) << 2]).append("=");
				}
			} else {
				var3.append(class289.field3653[(var5 & 3) << 4]).append("==");
			}
		}

		return var3.toString();
	}

	@ObfuscatedName("g")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "1518312277"
	)
	public static void method3746() {
		VarpDefinition.VarpDefinition_cached.clear();
	}

	@ObfuscatedName("gf")
	@ObfuscatedSignature(
		signature = "(IIII)I",
		garbageValue = "-1206093044"
	)
	@Export("getTileHeight")
	static final int getTileHeight(int var0, int var1, int var2) {
		int var3 = var0 >> 7;
		int var4 = var1 >> 7;
		if (var3 >= 0 && var4 >= 0 && var3 <= 103 && var4 <= 103) {
			int var5 = var2;
			if (var2 < 3 && (Tiles.Tiles_renderFlags[1][var3][var4] & 2) == 2) {
				var5 = var2 + 1;
			}

			int var6 = var0 & 127;
			int var7 = var1 & 127;
			int var8 = (128 - var6) * Tiles.Tiles_heights[var5][var3][var4] + Tiles.Tiles_heights[var5][var3 + 1][var4] * var6 >> 7;
			int var9 = Tiles.Tiles_heights[var5][var3][var4 + 1] * (128 - var6) + var6 * Tiles.Tiles_heights[var5][var3 + 1][var4 + 1] >> 7;
			return var7 * var9 + var8 * (128 - var7) >> 7;
		} else {
			return 0;
		}
	}
}
