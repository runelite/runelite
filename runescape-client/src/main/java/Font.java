import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("kr")
@Implements("Font")
public final class Font extends FontTypeFace {
   public Font(byte[] var1, int[] var2, int[] var3, int[] var4, int[] var5, int[] var6, byte[][] var7) {
      super(var1, var2, var3, var4, var5, var6, var7);
   }

   public Font(byte[] var1) {
      super(var1);
   }

   @ObfuscatedName("w")
   @Export("renderRGB")
   final void renderRGB(byte[] var1, int var2, int var3, int var4, int var5, int var6) {
      int var7 = var3 * Rasterizer2D.graphicsPixelsWidth + var2;
      int var8 = Rasterizer2D.graphicsPixelsWidth - var4;
      int var9 = 0;
      int var10 = 0;
      int var11;
      if(var3 < Rasterizer2D.drawingAreaTop) {
         var11 = Rasterizer2D.drawingAreaTop - var3;
         var5 -= var11;
         var3 = Rasterizer2D.drawingAreaTop;
         var10 += var11 * var4;
         var7 += var11 * Rasterizer2D.graphicsPixelsWidth;
      }

      if(var3 + var5 > Rasterizer2D.drawingAreaRight) {
         var5 -= var3 + var5 - Rasterizer2D.drawingAreaRight;
      }

      if(var2 < Rasterizer2D.draw_region_x) {
         var11 = Rasterizer2D.draw_region_x - var2;
         var4 -= var11;
         var2 = Rasterizer2D.draw_region_x;
         var10 += var11;
         var7 += var11;
         var9 += var11;
         var8 += var11;
      }

      if(var2 + var4 > Rasterizer2D.drawingAreaBottom) {
         var11 = var2 + var4 - Rasterizer2D.drawingAreaBottom;
         var4 -= var11;
         var9 += var11;
         var8 += var11;
      }

      if(var4 > 0 && var5 > 0) {
         FontTypeFace.render(Rasterizer2D.graphicsPixels, var1, var6, var10, var7, var4, var5, var8, var9);
      }
   }

   @ObfuscatedName("m")
   @Export("renderRGBA")
   final void renderRGBA(byte[] var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      int var8 = var3 * Rasterizer2D.graphicsPixelsWidth + var2;
      int var9 = Rasterizer2D.graphicsPixelsWidth - var4;
      int var10 = 0;
      int var11 = 0;
      int var12;
      if(var3 < Rasterizer2D.drawingAreaTop) {
         var12 = Rasterizer2D.drawingAreaTop - var3;
         var5 -= var12;
         var3 = Rasterizer2D.drawingAreaTop;
         var11 += var12 * var4;
         var8 += var12 * Rasterizer2D.graphicsPixelsWidth;
      }

      if(var3 + var5 > Rasterizer2D.drawingAreaRight) {
         var5 -= var3 + var5 - Rasterizer2D.drawingAreaRight;
      }

      if(var2 < Rasterizer2D.draw_region_x) {
         var12 = Rasterizer2D.draw_region_x - var2;
         var4 -= var12;
         var2 = Rasterizer2D.draw_region_x;
         var11 += var12;
         var8 += var12;
         var10 += var12;
         var9 += var12;
      }

      if(var2 + var4 > Rasterizer2D.drawingAreaBottom) {
         var12 = var2 + var4 - Rasterizer2D.drawingAreaBottom;
         var4 -= var12;
         var10 += var12;
         var9 += var12;
      }

      if(var4 > 0 && var5 > 0) {
         FontTypeFace.renderRGBA(Rasterizer2D.graphicsPixels, var1, var6, var11, var8, var4, var5, var9, var10, var7);
      }
   }
}
