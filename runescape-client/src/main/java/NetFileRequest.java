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
	@Export("drawScrollBar")
	static final void drawScrollBar(int x, int y, int scrollY, int height, int scrollHeight) {
		GrandExchangeOfferAgeComparator.scrollBarSprites[0].drawAt(x, y);
		GrandExchangeOfferAgeComparator.scrollBarSprites[1].drawAt(x, height + y - 16);
		Rasterizer2D.Rasterizer2D_fillRectangle(x, y + 16, 16, height - 32, Client.field715);
		int var5 = height * (height - 32) / scrollHeight;
		if (var5 < 8) {
			var5 = 8;
		}

		int var6 = (height - 32 - var5) * scrollY / (scrollHeight - height);
		Rasterizer2D.Rasterizer2D_fillRectangle(x, var6 + y + 16, 16, var5, Client.field716);
		Rasterizer2D.Rasterizer2D_drawVerticalLine(x, var6 + y + 16, var5, Client.field772);
		Rasterizer2D.Rasterizer2D_drawVerticalLine(x + 1, var6 + y + 16, var5, Client.field772);
		Rasterizer2D.Rasterizer2D_drawHorizontalLine(x, var6 + y + 16, 16, Client.field772);
		Rasterizer2D.Rasterizer2D_drawHorizontalLine(x, var6 + y + 17, 16, Client.field772);
		Rasterizer2D.Rasterizer2D_drawVerticalLine(x + 15, var6 + y + 16, var5, Client.field720);
		Rasterizer2D.Rasterizer2D_drawVerticalLine(x + 14, var6 + y + 17, var5 - 1, Client.field720);
		Rasterizer2D.Rasterizer2D_drawHorizontalLine(x, var6 + var5 + y + 15, 16, Client.field720);
		Rasterizer2D.Rasterizer2D_drawHorizontalLine(x + 1, var5 + var6 + y + 14, 15, Client.field720);
	}
}
