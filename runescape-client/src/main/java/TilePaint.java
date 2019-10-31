import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("eg")
@Implements("TilePaint")
public final class TilePaint {
	@ObfuscatedName("a")
	@ObfuscatedGetter(
		intValue = -1607728329
	)
	@Export("swColor")
	int swColor;
	@ObfuscatedName("t")
	@ObfuscatedGetter(
		intValue = -293038201
	)
	@Export("seColor")
	int seColor;
	@ObfuscatedName("n")
	@ObfuscatedGetter(
		intValue = -1492739509
	)
	@Export("neColor")
	int neColor;
	@ObfuscatedName("q")
	@ObfuscatedGetter(
		intValue = 276503717
	)
	@Export("nwColor")
	int nwColor;
	@ObfuscatedName("v")
	@ObfuscatedGetter(
		intValue = -1272946255
	)
	@Export("texture")
	int texture;
	@ObfuscatedName("l")
	@Export("isFlat")
	boolean isFlat;
	@ObfuscatedName("c")
	@ObfuscatedGetter(
		intValue = 609514679
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

	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "([BIIII[Lfm;I)V",
		garbageValue = "1145128419"
	)
	static final void method3200(byte[] var0, int var1, int var2, int var3, int var4, CollisionMap[] var5) {
		int var7;
		int var8;
		for (int var6 = 0; var6 < 4; ++var6) {
			for (var7 = 0; var7 < 64; ++var7) {
				for (var8 = 0; var8 < 64; ++var8) {
					if (var7 + var1 > 0 && var7 + var1 < 103 && var8 + var2 > 0 && var8 + var2 < 103) {
						int[] var10000 = var5[var6].flags[var7 + var1];
						var10000[var8 + var2] &= -16777217;
					}
				}
			}
		}

		Buffer var10 = new Buffer(var0);

		for (var7 = 0; var7 < 4; ++var7) {
			for (var8 = 0; var8 < 64; ++var8) {
				for (int var9 = 0; var9 < 64; ++var9) {
					class312.loadTerrain(var10, var7, var8 + var1, var9 + var2, var3, var4, 0);
				}
			}
		}

	}
}
