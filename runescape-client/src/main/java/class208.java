import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("he")
public final class class208 extends class209 {
   public class208(byte[] var1) {
      super(var1);
   }

   @ObfuscatedName("d")
   final void vmethod3932(byte[] var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      int var8 = var2 + var3 * class219.graphicsPixelsWidth;
      int var9 = class219.graphicsPixelsWidth - var4;
      int var10 = 0;
      int var11 = 0;
      int var12;
      if(var3 < class219.field3168) {
         var12 = class219.field3168 - var3;
         var5 -= var12;
         var3 = class219.field3168;
         var11 += var12 * var4;
         var8 += var12 * class219.graphicsPixelsWidth;
      }

      if(var3 + var5 > class219.field3169) {
         var5 -= var3 + var5 - class219.field3169;
      }

      if(var2 < class219.field3165) {
         var12 = class219.field3165 - var2;
         var4 -= var12;
         var2 = class219.field3165;
         var11 += var12;
         var8 += var12;
         var10 += var12;
         var9 += var12;
      }

      if(var2 + var4 > class219.field3171) {
         var12 = var2 + var4 - class219.field3171;
         var4 -= var12;
         var10 += var12;
         var9 += var12;
      }

      if(var4 > 0 && var5 > 0) {
         class209.method3937(class219.graphicsPixels, var1, var6, var11, var8, var4, var5, var9, var10, var7);
      }
   }

   @ObfuscatedName("n")
   final void vmethod3993(byte[] var1, int var2, int var3, int var4, int var5, int var6) {
      int var7 = var2 + var3 * class219.graphicsPixelsWidth;
      int var8 = class219.graphicsPixelsWidth - var4;
      int var9 = 0;
      int var10 = 0;
      int var11;
      if(var3 < class219.field3168) {
         var11 = class219.field3168 - var3;
         var5 -= var11;
         var3 = class219.field3168;
         var10 += var11 * var4;
         var7 += var11 * class219.graphicsPixelsWidth;
      }

      if(var3 + var5 > class219.field3169) {
         var5 -= var3 + var5 - class219.field3169;
      }

      if(var2 < class219.field3165) {
         var11 = class219.field3165 - var2;
         var4 -= var11;
         var2 = class219.field3165;
         var10 += var11;
         var7 += var11;
         var9 += var11;
         var8 += var11;
      }

      if(var2 + var4 > class219.field3171) {
         var11 = var2 + var4 - class219.field3171;
         var4 -= var11;
         var9 += var11;
         var8 += var11;
      }

      if(var4 > 0 && var5 > 0) {
         class209.method4009(class219.graphicsPixels, var1, var6, var10, var7, var4, var5, var8, var9);
      }
   }

   public class208(byte[] var1, int[] var2, int[] var3, int[] var4, int[] var5, int[] var6, byte[][] var7) {
      super(var1, var2, var3, var4, var5, var6, var7);
   }
}
