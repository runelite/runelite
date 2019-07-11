import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("kk")
@Implements("Font")
public final class Font extends AbstractFont {
   public Font(byte[] data, int[] leftBearings, int[] topBearings, int[] widths, int[] heights, int[] var6, byte[][] pixels) {
      super(data, leftBearings, topBearings, widths, heights, var6, pixels);
   }

   public Font(byte[] var1) {
      super(var1);
   }

   @ObfuscatedName("m")
   @Export("drawGlyph")
   final void drawGlyph(byte[] pixels, int x, int y, int width, int height, int color) {
      int var7 = y * Rasterizer2D.Rasterizer2D_width + x;
      int var8 = Rasterizer2D.Rasterizer2D_width - width;
      int var9 = 0;
      int var10 = 0;
      int var11;
      if (y < Rasterizer2D.Rasterizer2D_yClipStart) {
         var11 = Rasterizer2D.Rasterizer2D_yClipStart - y;
         height -= var11;
         y = Rasterizer2D.Rasterizer2D_yClipStart;
         var10 += var11 * width;
         var7 += var11 * Rasterizer2D.Rasterizer2D_width;
      }

      if (y + height > Rasterizer2D.Rasterizer2D_yClipEnd) {
         height -= y + height - Rasterizer2D.Rasterizer2D_yClipEnd;
      }

      if (x < Rasterizer2D.Rasterizer2D_xClipStart) {
         var11 = Rasterizer2D.Rasterizer2D_xClipStart - x;
         width -= var11;
         x = Rasterizer2D.Rasterizer2D_xClipStart;
         var10 += var11;
         var7 += var11;
         var9 += var11;
         var8 += var11;
      }

      if (x + width > Rasterizer2D.Rasterizer2D_xClipEnd) {
         var11 = x + width - Rasterizer2D.Rasterizer2D_xClipEnd;
         width -= var11;
         var9 += var11;
         var8 += var11;
      }

      if (width > 0 && height > 0) {
         AbstractFont.AbstractFont_placeGlyph(Rasterizer2D.Rasterizer2D_pixels, pixels, color, var10, var7, width, height, var8, var9);
      }

   }

   @ObfuscatedName("f")
   @Export("drawGlyphAlpha")
   final void drawGlyphAlpha(byte[] pixels, int x, int y, int width, int height, int color, int alpha) {
      int var8 = y * Rasterizer2D.Rasterizer2D_width + x;
      int var9 = Rasterizer2D.Rasterizer2D_width - width;
      int var10 = 0;
      int var11 = 0;
      int var12;
      if (y < Rasterizer2D.Rasterizer2D_yClipStart) {
         var12 = Rasterizer2D.Rasterizer2D_yClipStart - y;
         height -= var12;
         y = Rasterizer2D.Rasterizer2D_yClipStart;
         var11 += var12 * width;
         var8 += var12 * Rasterizer2D.Rasterizer2D_width;
      }

      if (y + height > Rasterizer2D.Rasterizer2D_yClipEnd) {
         height -= y + height - Rasterizer2D.Rasterizer2D_yClipEnd;
      }

      if (x < Rasterizer2D.Rasterizer2D_xClipStart) {
         var12 = Rasterizer2D.Rasterizer2D_xClipStart - x;
         width -= var12;
         x = Rasterizer2D.Rasterizer2D_xClipStart;
         var11 += var12;
         var8 += var12;
         var10 += var12;
         var9 += var12;
      }

      if (x + width > Rasterizer2D.Rasterizer2D_xClipEnd) {
         var12 = x + width - Rasterizer2D.Rasterizer2D_xClipEnd;
         width -= var12;
         var10 += var12;
         var9 += var12;
      }

      if (width > 0 && height > 0) {
         AbstractFont.AbstractFont_placeGlyphAlpha(Rasterizer2D.Rasterizer2D_pixels, pixels, color, var11, var8, width, height, var9, var10, alpha);
      }

   }
}
