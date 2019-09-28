import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ag")
@Implements("DevicePcmPlayerProvider")
public class DevicePcmPlayerProvider implements PcmPlayerProvider {
	@ObfuscatedName("sg")
	@ObfuscatedGetter(
		intValue = 408059263
	)
	@Export("foundItemIdCount")
	static int foundItemIdCount;
	@ObfuscatedName("v")
	@ObfuscatedGetter(
		intValue = -1430118873
	)
	@Export("KitDefinition_fileCount")
	public static int KitDefinition_fileCount;
	@ObfuscatedName("p")
	static byte[][][] field393;
	@ObfuscatedName("y")
	static int[][] field386;
	@ObfuscatedName("i")
	public static short[][] field390;
	@ObfuscatedName("ja")
	@ObfuscatedSignature(
		signature = "Lho;"
	)
	static Widget field391;
	@ObfuscatedName("lk")
	@ObfuscatedGetter(
		intValue = -783171563
	)
	@Export("selectedItemSlot")
	static int selectedItemSlot;

	DevicePcmPlayerProvider() {
	}

	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "(I)Ldv;",
		garbageValue = "-79742550"
	)
	@Export("player")
	public PcmPlayer player() {
		return new DevicePcmPlayer();
	}

	@ObfuscatedName("im")
	@ObfuscatedSignature(
		signature = "(IIIIIII)V",
		garbageValue = "405770761"
	)
	static final void method877(int var0, int var1, int var2, int var3, int var4, int var5) {
		int var6 = var2 - var0;
		int var7 = var3 - var1;
		int var8 = var6 >= 0 ? var6 : -var6;
		int var9 = var7 >= 0 ? var7 : -var7;
		int var10 = var8;
		if (var8 < var9) {
			var10 = var9;
		}

		if (var10 != 0) {
			int var11 = (var6 << 16) / var10;
			int var12 = (var7 << 16) / var10;
			if (var12 <= var11) {
				var11 = -var11;
			} else {
				var12 = -var12;
			}

			int var13 = var5 * var12 >> 17;
			int var14 = var5 * var12 + 1 >> 17;
			int var15 = var5 * var11 >> 17;
			int var16 = var5 * var11 + 1 >> 17;
			var0 -= Rasterizer2D.Rasterizer2D_xClipStart;
			var1 -= Rasterizer2D.Rasterizer2D_yClipStart;
			int var17 = var0 + var13;
			int var18 = var0 - var14;
			int var19 = var0 + var6 - var14;
			int var20 = var0 + var13 + var6;
			int var21 = var15 + var1;
			int var22 = var1 - var16;
			int var23 = var7 + var1 - var16;
			int var24 = var15 + var7 + var1;
			Rasterizer3D.method2972(var17, var18, var19);
			Rasterizer3D.method2975(var21, var22, var23, var17, var18, var19, var4);
			Rasterizer3D.method2972(var17, var19, var20);
			Rasterizer3D.method2975(var21, var23, var24, var17, var19, var20, var4);
		}
	}
}
