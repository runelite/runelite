import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dj")
@Implements("FloorDecoration")
public final class FloorDecoration {
	@ObfuscatedName("d")
	@ObfuscatedGetter(
		intValue = 1829552079
	)
	@Export("canvasWidth")
	public static int canvasWidth;
	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "Ler;"
	)
	@Export("entity")
	public Entity entity;
	@ObfuscatedName("n")
	@ObfuscatedGetter(
		intValue = 1834213503
	)
	@Export("tileHeight")
	int tileHeight;
	@ObfuscatedName("v")
	@ObfuscatedGetter(
		intValue = 461857131
	)
	@Export("x")
	int x;
	@ObfuscatedName("u")
	@ObfuscatedGetter(
		intValue = -848464295
	)
	@Export("y")
	int y;
	@ObfuscatedName("r")
	@ObfuscatedGetter(
		longValue = 3642112439868332829L
	)
	@Export("tag")
	public long tag;
	@ObfuscatedName("p")
	@ObfuscatedGetter(
		intValue = -1953587145
	)
	@Export("flags")
	int flags;

	FloorDecoration() {
	}

	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "(II)Lhs;",
		garbageValue = "-1156266256"
	)
	public static ServerBuild method2841(int var0) {
		ServerBuild[] var1 = new ServerBuild[]{ServerBuild.BUILDLIVE, ServerBuild.LIVE, ServerBuild.RC, ServerBuild.WIP};
		ServerBuild[] var2 = var1;

		for (int var3 = 0; var3 < var2.length; ++var3) {
			ServerBuild var4 = var2[var3];
			if (var0 == var4.field3079) {
				return var4;
			}
		}

		return null;
	}

	@ObfuscatedName("jl")
	@ObfuscatedSignature(
		signature = "(IIIILlf;Lhz;S)V",
		garbageValue = "1700"
	)
	@Export("worldToMinimap")
	static final void worldToMinimap(int var0, int var1, int var2, int var3, Sprite var4, SpriteMask var5) {
		int var6 = var3 * var3 + var2 * var2;
		if (var6 > 4225 && var6 < 90000) {
			int var7 = Client.camAngleY & 2047;
			int var8 = Rasterizer3D.Rasterizer3D_sine[var7];
			int var9 = Rasterizer3D.Rasterizer3D_cosine[var7];
			int var10 = var9 * var2 + var3 * var8 >> 16;
			int var11 = var3 * var9 - var8 * var2 >> 16;
			double var12 = Math.atan2((double)var10, (double)var11);
			int var14 = var5.width / 2 - 25;
			int var15 = (int)(Math.sin(var12) * (double)var14);
			int var16 = (int)(Math.cos(var12) * (double)var14);
			byte var17 = 20;
			PendingSpawn.redHintArrowSprite.method6090(var15 + (var0 + var5.width / 2 - var17 / 2), var5.height / 2 + var1 - var17 / 2 - var16 - 10, var17, var17, 15, 15, var12, 256);
		} else {
			class208.drawSpriteOnMinimap(var0, var1, var2, var3, var4, var5);
		}

	}
}
