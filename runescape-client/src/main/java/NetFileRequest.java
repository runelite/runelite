import java.awt.Image;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hq")
@Implements("NetFileRequest")
public class NetFileRequest extends DualNode {
	@ObfuscatedName("az")
	static Image field3125;
	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "Liu;"
	)
	@Export("archive")
	Archive archive;
	@ObfuscatedName("w")
	@ObfuscatedGetter(
		intValue = 1663016965
	)
	@Export("crc")
	int crc;
	@ObfuscatedName("e")
	@Export("padding")
	byte padding;

	NetFileRequest() {
	}

	@ObfuscatedName("ap")
	@ObfuscatedSignature(
		signature = "(II)I",
		garbageValue = "616247304"
	)
	static int method4140(int var0) {
		return (int)((Math.log((double)var0) / Interpreter.field1110 - 7.0D) * 256.0D);
	}

	@ObfuscatedName("ia")
	@ObfuscatedSignature(
		signature = "(IIIIIB)V",
		garbageValue = "-20"
	)
	static final void method4139(int var0, int var1, int var2, int var3, int var4) {
		GrandExchangeOfferAgeComparator.scrollBarSprites[0].drawAt(var0, var1);
		GrandExchangeOfferAgeComparator.scrollBarSprites[1].drawAt(var0, var3 + var1 - 16);
		Rasterizer2D.Rasterizer2D_fillRectangle(var0, var1 + 16, 16, var3 - 32, Client.field715);
		int var5 = var3 * (var3 - 32) / var4;
		if (var5 < 8) {
			var5 = 8;
		}

		int var6 = (var3 - 32 - var5) * var2 / (var4 - var3);
		Rasterizer2D.Rasterizer2D_fillRectangle(var0, var6 + var1 + 16, 16, var5, Client.field716);
		Rasterizer2D.Rasterizer2D_drawVerticalLine(var0, var6 + var1 + 16, var5, Client.field772);
		Rasterizer2D.Rasterizer2D_drawVerticalLine(var0 + 1, var6 + var1 + 16, var5, Client.field772);
		Rasterizer2D.Rasterizer2D_drawHorizontalLine(var0, var6 + var1 + 16, 16, Client.field772);
		Rasterizer2D.Rasterizer2D_drawHorizontalLine(var0, var6 + var1 + 17, 16, Client.field772);
		Rasterizer2D.Rasterizer2D_drawVerticalLine(var0 + 15, var6 + var1 + 16, var5, Client.field720);
		Rasterizer2D.Rasterizer2D_drawVerticalLine(var0 + 14, var6 + var1 + 17, var5 - 1, Client.field720);
		Rasterizer2D.Rasterizer2D_drawHorizontalLine(var0, var6 + var5 + var1 + 15, 16, Client.field720);
		Rasterizer2D.Rasterizer2D_drawHorizontalLine(var0 + 1, var5 + var6 + var1 + 14, 15, Client.field720);
	}
}
