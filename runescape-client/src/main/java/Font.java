import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("hm")
@Implements("Font")
public final class Font extends FontTypeFace {
   public Font(byte[] var1) {
      super(var1);
   }

   @ObfuscatedName("k")
   final void vmethod3870(byte[] var1, int var2, int var3, int var4, int var5, int var6) {
      int var7 = var2 + var3 * Rasterizer2D.graphicsPixelsWidth;
      int var8 = Rasterizer2D.graphicsPixelsWidth - var4;
      int var9 = 0;
      int var10 = 0;
      int var11;
      if(var3 < Rasterizer2D.field3172) {
         var11 = Rasterizer2D.field3172 - var3;
         var5 -= var11;
         var3 = Rasterizer2D.field3172;
         var10 += var11 * var4;
         var7 += var11 * Rasterizer2D.graphicsPixelsWidth;
      }

      if(var3 + var5 > Rasterizer2D.field3169) {
         var5 -= var3 + var5 - Rasterizer2D.field3169;
      }

      if(var2 < Rasterizer2D.field3175) {
         var11 = Rasterizer2D.field3175 - var2;
         var4 -= var11;
         var2 = Rasterizer2D.field3175;
         var10 += var11;
         var7 += var11;
         var9 += var11;
         var8 += var11;
      }

      if(var2 + var4 > Rasterizer2D.field3173) {
         var11 = var2 + var4 - Rasterizer2D.field3173;
         var4 -= var11;
         var9 += var11;
         var8 += var11;
      }

      if(var4 > 0 && var5 > 0) {
         FontTypeFace.method3887(Rasterizer2D.graphicsPixels, var1, var6, var10, var7, var4, var5, var8, var9);
      }
   }

   @ObfuscatedName("y")
   final void vmethod3885(byte[] var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      int var8 = var2 + var3 * Rasterizer2D.graphicsPixelsWidth;
      int var9 = Rasterizer2D.graphicsPixelsWidth - var4;
      int var10 = 0;
      int var11 = 0;
      int var12;
      if(var3 < Rasterizer2D.field3172) {
         var12 = Rasterizer2D.field3172 - var3;
         var5 -= var12;
         var3 = Rasterizer2D.field3172;
         var11 += var12 * var4;
         var8 += var12 * Rasterizer2D.graphicsPixelsWidth;
      }

      if(var3 + var5 > Rasterizer2D.field3169) {
         var5 -= var3 + var5 - Rasterizer2D.field3169;
      }

      if(var2 < Rasterizer2D.field3175) {
         var12 = Rasterizer2D.field3175 - var2;
         var4 -= var12;
         var2 = Rasterizer2D.field3175;
         var11 += var12;
         var8 += var12;
         var10 += var12;
         var9 += var12;
      }

      if(var2 + var4 > Rasterizer2D.field3173) {
         var12 = var2 + var4 - Rasterizer2D.field3173;
         var4 -= var12;
         var10 += var12;
         var9 += var12;
      }

      if(var4 > 0 && var5 > 0) {
         FontTypeFace.method3889(Rasterizer2D.graphicsPixels, var1, var6, var11, var8, var4, var5, var9, var10, var7);
      }
   }

   public Font(byte[] var1, int[] var2, int[] var3, int[] var4, int[] var5, int[] var6, byte[][] var7) {
      super(var1, var2, var3, var4, var5, var6, var7);
   }
}
