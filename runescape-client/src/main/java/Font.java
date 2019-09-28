import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("kn")
@Implements("Font")
public final class Font extends AbstractFont {
	public Font(byte[] var1, int[] var2, int[] var3, int[] var4, int[] var5, int[] var6, byte[][] var7) {
		super(var1, var2, var3, var4, var5, var6, var7);
	}

	public Font(byte[] var1) {
		super(var1);
	}

	@ObfuscatedName("z")
	@Export("drawGlyph")
	final void drawGlyph(byte[] var1, int var2, int var3, int var4, int var5, int var6) {
		int var7 = var3 * Rasterizer2D.Rasterizer2D_width + var2;
		int var8 = Rasterizer2D.Rasterizer2D_width - var4;
		int var9 = 0;
		int var10 = 0;
		int var11;
		if (var3 < Rasterizer2D.Rasterizer2D_yClipStart) {
			var11 = Rasterizer2D.Rasterizer2D_yClipStart - var3;
			var5 -= var11;
			var3 = Rasterizer2D.Rasterizer2D_yClipStart;
			var10 += var11 * var4;
			var7 += var11 * Rasterizer2D.Rasterizer2D_width;
		}

		if (var3 + var5 > Rasterizer2D.Rasterizer2D_yClipEnd) {
			var5 -= var3 + var5 - Rasterizer2D.Rasterizer2D_yClipEnd;
		}

		if (var2 < Rasterizer2D.Rasterizer2D_xClipStart) {
			var11 = Rasterizer2D.Rasterizer2D_xClipStart - var2;
			var4 -= var11;
			var2 = Rasterizer2D.Rasterizer2D_xClipStart;
			var10 += var11;
			var7 += var11;
			var9 += var11;
			var8 += var11;
		}

		if (var2 + var4 > Rasterizer2D.Rasterizer2D_xClipEnd) {
			var11 = var2 + var4 - Rasterizer2D.Rasterizer2D_xClipEnd;
			var4 -= var11;
			var9 += var11;
			var8 += var11;
		}

		if (var4 > 0 && var5 > 0) {
			AbstractFont.AbstractFont_placeGlyph(Rasterizer2D.Rasterizer2D_pixels, var1, var6, var10, var7, var4, var5, var8, var9);
		}
	}

	@ObfuscatedName("n")
	@Export("drawGlyphAlpha")
	final void drawGlyphAlpha(byte[] var1, int var2, int var3, int var4, int var5, int var6, int var7) {
		int var8 = var3 * Rasterizer2D.Rasterizer2D_width + var2;
		int var9 = Rasterizer2D.Rasterizer2D_width - var4;
		int var10 = 0;
		int var11 = 0;
		int var12;
		if (var3 < Rasterizer2D.Rasterizer2D_yClipStart) {
			var12 = Rasterizer2D.Rasterizer2D_yClipStart - var3;
			var5 -= var12;
			var3 = Rasterizer2D.Rasterizer2D_yClipStart;
			var11 += var12 * var4;
			var8 += var12 * Rasterizer2D.Rasterizer2D_width;
		}

		if (var3 + var5 > Rasterizer2D.Rasterizer2D_yClipEnd) {
			var5 -= var3 + var5 - Rasterizer2D.Rasterizer2D_yClipEnd;
		}

		if (var2 < Rasterizer2D.Rasterizer2D_xClipStart) {
			var12 = Rasterizer2D.Rasterizer2D_xClipStart - var2;
			var4 -= var12;
			var2 = Rasterizer2D.Rasterizer2D_xClipStart;
			var11 += var12;
			var8 += var12;
			var10 += var12;
			var9 += var12;
		}

		if (var2 + var4 > Rasterizer2D.Rasterizer2D_xClipEnd) {
			var12 = var2 + var4 - Rasterizer2D.Rasterizer2D_xClipEnd;
			var4 -= var12;
			var10 += var12;
			var9 += var12;
		}

		if (var4 > 0 && var5 > 0) {
			AbstractFont.AbstractFont_placeGlyphAlpha(Rasterizer2D.Rasterizer2D_pixels, var1, var6, var11, var8, var4, var5, var9, var10, var7);
		}
	}
}
