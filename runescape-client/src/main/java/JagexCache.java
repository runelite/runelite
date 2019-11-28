import java.io.File;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fs")
@Implements("JagexCache")
public class JagexCache {
	@ObfuscatedName("g")
	@Export("JagexCache_locationFile")
	public static File JagexCache_locationFile;
	@ObfuscatedName("p")
	@ObfuscatedGetter(
		intValue = 618561373
	)
	@Export("idxCount")
	public static int idxCount;
	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "Lmb;"
	)
	@Export("JagexCache_randomDat")
	public static BufferedFile JagexCache_randomDat;
	@ObfuscatedName("o")
	@ObfuscatedSignature(
		signature = "Lmb;"
	)
	@Export("JagexCache_dat2File")
	public static BufferedFile JagexCache_dat2File;
	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "Lmb;"
	)
	@Export("JagexCache_idx255File")
	public static BufferedFile JagexCache_idx255File;
	@ObfuscatedName("c")
	public static String[] field2046;
	@ObfuscatedName("v")
	@Export("userHomeDirectory")
	public static String userHomeDirectory;
	@ObfuscatedName("ct")
	@Export("mouseCam")
	static boolean mouseCam;
	@ObfuscatedName("fq")
	@ObfuscatedSignature(
		signature = "Lky;"
	)
	@Export("fontBold12")
	static Font fontBold12;
	@ObfuscatedName("ji")
	@ObfuscatedSignature(
		signature = "Ldb;"
	)
	@Export("textureProvider")
	static TextureProvider textureProvider;

	static {
		JagexCache_randomDat = null;
		JagexCache_dat2File = null;
		JagexCache_idx255File = null;
	}

	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "(IIB)V",
		garbageValue = "87"
	)
	public static void method3540(int var0, int var1) {
		VarbitDefinition var3 = (VarbitDefinition)VarbitDefinition.VarbitDefinition_cached.get((long)var0);
		VarbitDefinition var2;
		if (var3 != null) {
			var2 = var3;
		} else {
			byte[] var8 = VarbitDefinition.VarbitDefinition_archive.takeFile(14, var0);
			var3 = new VarbitDefinition();
			if (var8 != null) {
				var3.decode(new Buffer(var8));
			}

			VarbitDefinition.VarbitDefinition_cached.put(var3, (long)var0);
			var2 = var3;
		}

		int var4 = var2.baseVar;
		int var5 = var2.startBit;
		int var6 = var2.endBit;
		int var7 = Varps.Varps_masks[var6 - var5];
		if (var1 < 0 || var1 > var7) {
			var1 = 0;
		}

		var7 <<= var5;
		Varps.Varps_main[var4] = Varps.Varps_main[var4] & ~var7 | var1 << var5 & var7;
	}

	@ObfuscatedName("b")
	@ObfuscatedSignature(
		signature = "(IIIB)I",
		garbageValue = "12"
	)
	static int method3531(int var0, int var1, int var2) {
		if (var2 > 179) {
			var1 /= 2;
		}

		if (var2 > 192) {
			var1 /= 2;
		}

		if (var2 > 217) {
			var1 /= 2;
		}

		if (var2 > 243) {
			var1 /= 2;
		}

		int var3 = (var1 / 32 << 7) + (var0 / 4 << 10) + var2 / 2;
		return var3;
	}

	@ObfuscatedName("jd")
	@ObfuscatedSignature(
		signature = "(IIIIIB)V",
		garbageValue = "11"
	)
	@Export("drawScrollBar")
	static final void drawScrollBar(int var0, int var1, int var2, int var3, int var4) {
		GrandExchangeOfferTotalQuantityComparator.scrollBarSprites[0].drawAt(var0, var1);
		GrandExchangeOfferTotalQuantityComparator.scrollBarSprites[1].drawAt(var0, var3 + var1 - 16);
		Rasterizer2D.Rasterizer2D_fillRectangle(var0, var1 + 16, 16, var3 - 32, Client.field705);
		int var5 = var3 * (var3 - 32) / var4;
		if (var5 < 8) {
			var5 = 8;
		}

		int var6 = (var3 - 32 - var5) * var2 / (var4 - var3);
		Rasterizer2D.Rasterizer2D_fillRectangle(var0, var6 + var1 + 16, 16, var5, Client.field706);
		Rasterizer2D.Rasterizer2D_drawVerticalLine(var0, var6 + var1 + 16, var5, Client.field708);
		Rasterizer2D.Rasterizer2D_drawVerticalLine(var0 + 1, var6 + var1 + 16, var5, Client.field708);
		Rasterizer2D.Rasterizer2D_drawHorizontalLine(var0, var6 + var1 + 16, 16, Client.field708);
		Rasterizer2D.Rasterizer2D_drawHorizontalLine(var0, var6 + var1 + 17, 16, Client.field708);
		Rasterizer2D.Rasterizer2D_drawVerticalLine(var0 + 15, var6 + var1 + 16, var5, Client.field707);
		Rasterizer2D.Rasterizer2D_drawVerticalLine(var0 + 14, var6 + var1 + 17, var5 - 1, Client.field707);
		Rasterizer2D.Rasterizer2D_drawHorizontalLine(var0, var6 + var5 + var1 + 15, 16, Client.field707);
		Rasterizer2D.Rasterizer2D_drawHorizontalLine(var0 + 1, var6 + var5 + var1 + 14, 15, Client.field707);
	}

	@ObfuscatedName("lq")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "66"
	)
	static void method3539() {
		if (Client.field826 && class215.localPlayer != null) {
			int var0 = class215.localPlayer.pathX[0];
			int var1 = class215.localPlayer.pathY[0];
			if (var0 < 0 || var1 < 0 || var0 >= 104 || var1 >= 104) {
				return;
			}

			class80.oculusOrbFocalPointX = class215.localPlayer.x;
			int var2 = class195.getTileHeight(class215.localPlayer.x, class215.localPlayer.y, ClientPacket.Client_plane) - Client.camFollowHeight;
			if (var2 < GrandExchangeOfferAgeComparator.field78) {
				GrandExchangeOfferAgeComparator.field78 = var2;
			}

			class81.oculusOrbFocalPointY = class215.localPlayer.y;
			Client.field826 = false;
		}

	}
}
