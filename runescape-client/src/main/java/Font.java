import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("hk")
@Implements("Font")
public final class Font extends FontTypeFace {
   @ObfuscatedName("q")
   final void vmethod3912(byte[] var1, int var2, int var3, int var4, int var5, int var6) {
      int var7 = var2 + var3 * Rasterizer2D.graphicsPixelsWidth;
      int var8 = Rasterizer2D.graphicsPixelsWidth - var4;
      int var9 = 0;
      int var10 = 0;
      int var11;
      if(var3 < Rasterizer2D.field3191) {
         var11 = Rasterizer2D.field3191 - var3;
         var5 -= var11;
         var3 = Rasterizer2D.field3191;
         var10 += var11 * var4;
         var7 += var11 * Rasterizer2D.graphicsPixelsWidth;
      }

      if(var3 + var5 > Rasterizer2D.field3192) {
         var5 -= var3 + var5 - Rasterizer2D.field3192;
      }

      if(var2 < Rasterizer2D.field3189) {
         var11 = Rasterizer2D.field3189 - var2;
         var4 -= var11;
         var2 = Rasterizer2D.field3189;
         var10 += var11;
         var7 += var11;
         var9 += var11;
         var8 += var11;
      }

      if(var2 + var4 > Rasterizer2D.field3194) {
         var11 = var2 + var4 - Rasterizer2D.field3194;
         var4 -= var11;
         var9 += var11;
         var8 += var11;
      }

      if(var4 > 0 && var5 > 0) {
         FontTypeFace.method3943(Rasterizer2D.graphicsPixels, var1, var6, var10, var7, var4, var5, var8, var9);
      }
   }

   @ObfuscatedName("d")
   final void vmethod3913(byte[] var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      int var8 = var2 + var3 * Rasterizer2D.graphicsPixelsWidth;
      int var9 = Rasterizer2D.graphicsPixelsWidth - var4;
      int var10 = 0;
      int var11 = 0;
      int var12;
      if(var3 < Rasterizer2D.field3191) {
         var12 = Rasterizer2D.field3191 - var3;
         var5 -= var12;
         var3 = Rasterizer2D.field3191;
         var11 += var12 * var4;
         var8 += var12 * Rasterizer2D.graphicsPixelsWidth;
      }

      if(var3 + var5 > Rasterizer2D.field3192) {
         var5 -= var3 + var5 - Rasterizer2D.field3192;
      }

      if(var2 < Rasterizer2D.field3189) {
         var12 = Rasterizer2D.field3189 - var2;
         var4 -= var12;
         var2 = Rasterizer2D.field3189;
         var11 += var12;
         var8 += var12;
         var10 += var12;
         var9 += var12;
      }

      if(var2 + var4 > Rasterizer2D.field3194) {
         var12 = var2 + var4 - Rasterizer2D.field3194;
         var4 -= var12;
         var10 += var12;
         var9 += var12;
      }

      if(var4 > 0 && var5 > 0) {
         FontTypeFace.method3968(Rasterizer2D.graphicsPixels, var1, var6, var11, var8, var4, var5, var9, var10, var7);
      }
   }

   public Font(byte[] var1) {
      super(var1);
   }

   public Font(byte[] var1, int[] var2, int[] var3, int[] var4, int[] var5, int[] var6, byte[][] var7) {
      super(var1, var2, var3, var4, var5, var6, var7);
   }
}
