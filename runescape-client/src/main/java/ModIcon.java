import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("je")
@Implements("ModIcon")
public final class ModIcon extends Rasterizer2D {
   @ObfuscatedName("f")
   @Export("offsetX")
   public int offsetX;
   @ObfuscatedName("p")
   @Export("palette")
   public int[] palette;
   @ObfuscatedName("i")
   @Export("originalWidth")
   public int originalWidth;
   @ObfuscatedName("m")
   @Export("offsetY")
   public int offsetY;
   @ObfuscatedName("j")
   @Export("height")
   public int height;
   @ObfuscatedName("n")
   @Export("pixels")
   public byte[] pixels;
   @ObfuscatedName("c")
   @Export("width")
   public int width;
   @ObfuscatedName("z")
   @Export("originalHeight")
   public int originalHeight;

   @ObfuscatedName("j")
   static void method5062(int[] var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8) {
      int var9 = -(var5 >> 2);
      var5 = -(var5 & 3);

      for(int var10 = -var6; var10 < 0; ++var10) {
         int var11;
         byte var12;
         for(var11 = var9; var11 < 0; ++var11) {
            var12 = var1[var3++];
            if(var12 != 0) {
               var0[var4++] = var2[var12 & 255];
            } else {
               ++var4;
            }

            var12 = var1[var3++];
            if(var12 != 0) {
               var0[var4++] = var2[var12 & 255];
            } else {
               ++var4;
            }

            var12 = var1[var3++];
            if(var12 != 0) {
               var0[var4++] = var2[var12 & 255];
            } else {
               ++var4;
            }

            var12 = var1[var3++];
            if(var12 != 0) {
               var0[var4++] = var2[var12 & 255];
            } else {
               ++var4;
            }
         }

         for(var11 = var5; var11 < 0; ++var11) {
            var12 = var1[var3++];
            if(var12 != 0) {
               var0[var4++] = var2[var12 & 255];
            } else {
               ++var4;
            }
         }

         var4 += var7;
         var3 += var8;
      }

   }

   @ObfuscatedName("n")
   public void method5063() {
      if(this.originalWidth != this.width || this.height != this.originalHeight) {
         byte[] var1 = new byte[this.width * this.originalHeight];
         int var2 = 0;

         for(int var3 = 0; var3 < this.height; ++var3) {
            for(int var4 = 0; var4 < this.originalWidth; ++var4) {
               var1[var4 + this.offsetX + (var3 + this.offsetY) * this.width] = this.pixels[var2++];
            }
         }

         this.pixels = var1;
         this.originalWidth = this.width;
         this.height = this.originalHeight;
         this.offsetX = 0;
         this.offsetY = 0;
      }
   }

   @ObfuscatedName("p")
   public void method5064(int var1, int var2, int var3) {
      for(int var4 = 0; var4 < this.palette.length; ++var4) {
         int var5 = this.palette[var4] >> 16 & 255;
         var5 += var1;
         if(var5 < 0) {
            var5 = 0;
         } else if(var5 > 255) {
            var5 = 255;
         }

         int var6 = this.palette[var4] >> 8 & 255;
         var6 += var2;
         if(var6 < 0) {
            var6 = 0;
         } else if(var6 > 255) {
            var6 = 255;
         }

         int var7 = this.palette[var4] & 255;
         var7 += var3;
         if(var7 < 0) {
            var7 = 0;
         } else if(var7 > 255) {
            var7 = 255;
         }

         this.palette[var4] = (var5 << 16) + (var6 << 8) + var7;
      }

   }

   @ObfuscatedName("i")
   public void method5066(int var1, int var2) {
      var1 += this.offsetX;
      var2 += this.offsetY;
      int var3 = var1 + var2 * Rasterizer2D.graphicsPixelsWidth;
      int var4 = 0;
      int var5 = this.height;
      int var6 = this.originalWidth;
      int var7 = Rasterizer2D.graphicsPixelsWidth - var6;
      int var8 = 0;
      int var9;
      if(var2 < Rasterizer2D.field3755) {
         var9 = Rasterizer2D.field3755 - var2;
         var5 -= var9;
         var2 = Rasterizer2D.field3755;
         var4 += var9 * var6;
         var3 += var9 * Rasterizer2D.graphicsPixelsWidth;
      }

      if(var2 + var5 > Rasterizer2D.field3756) {
         var5 -= var2 + var5 - Rasterizer2D.field3756;
      }

      if(var1 < Rasterizer2D.field3754) {
         var9 = Rasterizer2D.field3754 - var1;
         var6 -= var9;
         var1 = Rasterizer2D.field3754;
         var4 += var9;
         var3 += var9;
         var8 += var9;
         var7 += var9;
      }

      if(var1 + var6 > Rasterizer2D.field3758) {
         var9 = var1 + var6 - Rasterizer2D.field3758;
         var6 -= var9;
         var8 += var9;
         var7 += var9;
      }

      if(var6 > 0 && var5 > 0) {
         method5062(Rasterizer2D.graphicsPixels, this.pixels, this.palette, var4, var3, var6, var5, var7, var8);
      }
   }

   @ObfuscatedName("m")
   static void method5068(int[] var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11) {
      int var12 = var3;

      for(int var13 = -var8; var13 < 0; ++var13) {
         int var14 = (var4 >> 16) * var11;

         for(int var15 = -var7; var15 < 0; ++var15) {
            byte var16 = var1[(var3 >> 16) + var14];
            if(var16 != 0) {
               var0[var5++] = var2[var16 & 255];
            } else {
               ++var5;
            }

            var3 += var9;
         }

         var4 += var10;
         var3 = var12;
         var5 += var6;
      }

   }

   @ObfuscatedName("f")
   public void method5073(int var1, int var2, int var3, int var4) {
      int var5 = this.originalWidth;
      int var6 = this.height;
      int var7 = 0;
      int var8 = 0;
      int var9 = this.width;
      int var10 = this.originalHeight;
      int var11 = (var9 << 16) / var3;
      int var12 = (var10 << 16) / var4;
      int var13;
      if(this.offsetX > 0) {
         var13 = ((this.offsetX << 16) + var11 - 1) / var11;
         var1 += var13;
         var7 += var13 * var11 - (this.offsetX << 16);
      }

      if(this.offsetY > 0) {
         var13 = ((this.offsetY << 16) + var12 - 1) / var12;
         var2 += var13;
         var8 += var13 * var12 - (this.offsetY << 16);
      }

      if(var5 < var9) {
         var3 = ((var5 << 16) - var7 + var11 - 1) / var11;
      }

      if(var6 < var10) {
         var4 = ((var6 << 16) - var8 + var12 - 1) / var12;
      }

      var13 = var1 + var2 * Rasterizer2D.graphicsPixelsWidth;
      int var14 = Rasterizer2D.graphicsPixelsWidth - var3;
      if(var2 + var4 > Rasterizer2D.field3756) {
         var4 -= var2 + var4 - Rasterizer2D.field3756;
      }

      int var15;
      if(var2 < Rasterizer2D.field3755) {
         var15 = Rasterizer2D.field3755 - var2;
         var4 -= var15;
         var13 += var15 * Rasterizer2D.graphicsPixelsWidth;
         var8 += var12 * var15;
      }

      if(var1 + var3 > Rasterizer2D.field3758) {
         var15 = var1 + var3 - Rasterizer2D.field3758;
         var3 -= var15;
         var14 += var15;
      }

      if(var1 < Rasterizer2D.field3754) {
         var15 = Rasterizer2D.field3754 - var1;
         var3 -= var15;
         var13 += var15;
         var7 += var11 * var15;
         var14 += var15;
      }

      method5068(Rasterizer2D.graphicsPixels, this.pixels, this.palette, var7, var8, var13, var14, var3, var4, var11, var12, var5);
   }
}
