import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("lf")
@Implements("Rasterizer2D")
public class Rasterizer2D extends DualNode {
   @ObfuscatedName("aq")
   @Export("Rasterizer2D_pixels")
   public static int[] Rasterizer2D_pixels;
   @ObfuscatedName("aj")
   @Export("Rasterizer2D_width")
   public static int Rasterizer2D_width;
   @ObfuscatedName("av")
   @Export("Rasterizer2D_height")
   public static int Rasterizer2D_height;
   @ObfuscatedName("ar")
   @Export("Rasterizer2D_yClipStart")
   public static int Rasterizer2D_yClipStart;
   @ObfuscatedName("ac")
   @Export("Rasterizer2D_yClipEnd")
   public static int Rasterizer2D_yClipEnd;
   @ObfuscatedName("ay")
   @Export("Rasterizer2D_xClipStart")
   public static int Rasterizer2D_xClipStart;
   @ObfuscatedName("ah")
   @Export("Rasterizer2D_xClipEnd")
   public static int Rasterizer2D_xClipEnd;

   @ObfuscatedName("dp")
   @Export("Rasterizer2D_replace")
   public static void Rasterizer2D_replace(int[] pixels, int width, int height) {
      Rasterizer2D_pixels = pixels;
      Rasterizer2D_width = width;
      Rasterizer2D_height = height;
      Rasterizer2D_setClip(0, 0, width, height);
   }

   @ObfuscatedName("ds")
   @Export("Rasterizer2D_resetClip")
   public static void Rasterizer2D_resetClip() {
      Rasterizer2D_xClipStart = 0;
      Rasterizer2D_yClipStart = 0;
      Rasterizer2D_xClipEnd = Rasterizer2D_width;
      Rasterizer2D_yClipEnd = Rasterizer2D_height;
   }

   @ObfuscatedName("di")
   @Export("Rasterizer2D_setClip")
   public static void Rasterizer2D_setClip(int xStart, int yStart, int xEnd, int yEnd) {
      if (xStart < 0) {
         xStart = 0;
      }

      if (yStart < 0) {
         yStart = 0;
      }

      if (xEnd > Rasterizer2D_width) {
         xEnd = Rasterizer2D_width;
      }

      if (yEnd > Rasterizer2D_height) {
         yEnd = Rasterizer2D_height;
      }

      Rasterizer2D_xClipStart = xStart;
      Rasterizer2D_yClipStart = yStart;
      Rasterizer2D_xClipEnd = xEnd;
      Rasterizer2D_yClipEnd = yEnd;
   }

   @ObfuscatedName("dc")
   @Export("Rasterizer2D_expandClip")
   public static void Rasterizer2D_expandClip(int xStart, int yStart, int xEnd, int yEnd) {
      if (Rasterizer2D_xClipStart < xStart) {
         Rasterizer2D_xClipStart = xStart;
      }

      if (Rasterizer2D_yClipStart < yStart) {
         Rasterizer2D_yClipStart = yStart;
      }

      if (Rasterizer2D_xClipEnd > xEnd) {
         Rasterizer2D_xClipEnd = xEnd;
      }

      if (Rasterizer2D_yClipEnd > yEnd) {
         Rasterizer2D_yClipEnd = yEnd;
      }

   }

   @ObfuscatedName("dg")
   @Export("Rasterizer2D_getClipArray")
   public static void Rasterizer2D_getClipArray(int[] dst) {
      dst[0] = Rasterizer2D_xClipStart;
      dst[1] = Rasterizer2D_yClipStart;
      dst[2] = Rasterizer2D_xClipEnd;
      dst[3] = Rasterizer2D_yClipEnd;
   }

   @ObfuscatedName("db")
   @Export("Rasterizer2D_setClipArray")
   public static void Rasterizer2D_setClipArray(int[] src) {
      Rasterizer2D_xClipStart = src[0];
      Rasterizer2D_yClipStart = src[1];
      Rasterizer2D_xClipEnd = src[2];
      Rasterizer2D_yClipEnd = src[3];
   }

   @ObfuscatedName("dd")
   @Export("Rasterizer2D_clear")
   public static void Rasterizer2D_clear() {
      int var0 = 0;

      int var1;
      for (var1 = Rasterizer2D_width * Rasterizer2D_height - 7; var0 < var1; Rasterizer2D_pixels[var0++] = 0) {
         Rasterizer2D_pixels[var0++] = 0;
         Rasterizer2D_pixels[var0++] = 0;
         Rasterizer2D_pixels[var0++] = 0;
         Rasterizer2D_pixels[var0++] = 0;
         Rasterizer2D_pixels[var0++] = 0;
         Rasterizer2D_pixels[var0++] = 0;
         Rasterizer2D_pixels[var0++] = 0;
      }

      for (var1 += 7; var0 < var1; Rasterizer2D_pixels[var0++] = 0) {
      }

   }

   @Export("drawCircle")
   @ObfuscatedName("dy")
   static void drawCircle(int var0, int var1, int var2, int var3) {
      if (var2 == 0) {
         Rasterizer2D_setPixel(var0, var1, var3);
      } else {
         if (var2 < 0) {
            var2 = -var2;
         }

         int var4 = var1 - var2;
         if (var4 < Rasterizer2D_yClipStart) {
            var4 = Rasterizer2D_yClipStart;
         }

         int var5 = var2 + var1 + 1;
         if (var5 > Rasterizer2D_yClipEnd) {
            var5 = Rasterizer2D_yClipEnd;
         }

         int var6 = var4;
         int var7 = var2 * var2;
         int var8 = 0;
         int var9 = var1 - var4;
         int var10 = var9 * var9;
         int var11 = var10 - var9;
         if (var1 > var5) {
            var1 = var5;
         }

         int var12;
         int var13;
         int var14;
         int var15;
         while (var6 < var1) {
            while (var11 <= var7 || var10 <= var7) {
               var10 = var10 + var8 + var8;
               var11 += var8++ + var8;
            }

            var12 = var0 - var8 + 1;
            if (var12 < Rasterizer2D_xClipStart) {
               var12 = Rasterizer2D_xClipStart;
            }

            var13 = var0 + var8;
            if (var13 > Rasterizer2D_xClipEnd) {
               var13 = Rasterizer2D_xClipEnd;
            }

            var14 = var12 + var6 * Rasterizer2D_width;

            for (var15 = var12; var15 < var13; ++var15) {
               Rasterizer2D_pixels[var14++] = var3;
            }

            ++var6;
            var10 -= var9-- + var9;
            var11 -= var9 + var9;
         }

         var8 = var2;
         var9 = var6 - var1;
         var11 = var7 + var9 * var9;
         var10 = var11 - var2;

         for (var11 -= var9; var6 < var5; var10 += var9++ + var9) {
            while (var11 > var7 && var10 > var7) {
               var11 -= var8-- + var8;
               var10 -= var8 + var8;
            }

            var12 = var0 - var8;
            if (var12 < Rasterizer2D_xClipStart) {
               var12 = Rasterizer2D_xClipStart;
            }

            var13 = var0 + var8;
            if (var13 > Rasterizer2D_xClipEnd - 1) {
               var13 = Rasterizer2D_xClipEnd - 1;
            }

            var14 = var12 + var6 * Rasterizer2D_width;

            for (var15 = var12; var15 <= var13; ++var15) {
               Rasterizer2D_pixels[var14++] = var3;
            }

            ++var6;
            var11 = var11 + var9 + var9;
         }
      }

   }

   @ObfuscatedName("dk")
   @Export("Rasterizer2D_drawCircleAlpha")
   public static void Rasterizer2D_drawCircleAlpha(int var0, int var1, int var2, int var3, int var4) {
      if (var4 != 0) {
         if (var4 == 256) {
            drawCircle(var0, var1, var2, var3);
         } else {
            if (var2 < 0) {
               var2 = -var2;
            }

            int var5 = 256 - var4;
            int var6 = (var3 >> 16 & 255) * var4;
            int var7 = (var3 >> 8 & 255) * var4;
            int var8 = var4 * (var3 & 255);
            int var9 = var1 - var2;
            if (var9 < Rasterizer2D_yClipStart) {
               var9 = Rasterizer2D_yClipStart;
            }

            int var10 = var2 + var1 + 1;
            if (var10 > Rasterizer2D_yClipEnd) {
               var10 = Rasterizer2D_yClipEnd;
            }

            int var11 = var9;
            int var12 = var2 * var2;
            int var13 = 0;
            int var14 = var1 - var9;
            int var15 = var14 * var14;
            int var16 = var15 - var14;
            if (var1 > var10) {
               var1 = var10;
            }

            int var17;
            int var18;
            int var19;
            int var20;
            int var21;
            int var22;
            int var23;
            int var24;
            while (var11 < var1) {
               while (var16 <= var12 || var15 <= var12) {
                  var15 = var15 + var13 + var13;
                  var16 += var13++ + var13;
               }

               var20 = var0 - var13 + 1;
               if (var20 < Rasterizer2D_xClipStart) {
                  var20 = Rasterizer2D_xClipStart;
               }

               var21 = var0 + var13;
               if (var21 > Rasterizer2D_xClipEnd) {
                  var21 = Rasterizer2D_xClipEnd;
               }

               var22 = var20 + var11 * Rasterizer2D_width;

               for (var23 = var20; var23 < var21; ++var23) {
                  var17 = var5 * (Rasterizer2D_pixels[var22] >> 16 & 255);
                  var18 = (Rasterizer2D_pixels[var22] >> 8 & 255) * var5;
                  var19 = var5 * (Rasterizer2D_pixels[var22] & 255);
                  var24 = (var8 + var19 >> 8) + (var6 + var17 >> 8 << 16) + (var7 + var18 >> 8 << 8);
                  Rasterizer2D_pixels[var22++] = var24;
               }

               ++var11;
               var15 -= var14-- + var14;
               var16 -= var14 + var14;
            }

            var13 = var2;
            var14 = -var14;
            var16 = var12 + var14 * var14;
            var15 = var16 - var2;

            for (var16 -= var14; var11 < var10; var15 += var14++ + var14) {
               while (var16 > var12 && var15 > var12) {
                  var16 -= var13-- + var13;
                  var15 -= var13 + var13;
               }

               var20 = var0 - var13;
               if (var20 < Rasterizer2D_xClipStart) {
                  var20 = Rasterizer2D_xClipStart;
               }

               var21 = var0 + var13;
               if (var21 > Rasterizer2D_xClipEnd - 1) {
                  var21 = Rasterizer2D_xClipEnd - 1;
               }

               var22 = var20 + var11 * Rasterizer2D_width;

               for (var23 = var20; var23 <= var21; ++var23) {
                  var17 = var5 * (Rasterizer2D_pixels[var22] >> 16 & 255);
                  var18 = (Rasterizer2D_pixels[var22] >> 8 & 255) * var5;
                  var19 = var5 * (Rasterizer2D_pixels[var22] & 255);
                  var24 = (var8 + var19 >> 8) + (var6 + var17 >> 8 << 16) + (var7 + var18 >> 8 << 8);
                  Rasterizer2D_pixels[var22++] = var24;
               }

               ++var11;
               var16 = var16 + var14 + var14;
            }
         }
      }

   }

   @ObfuscatedName("dl")
   @Export("Rasterizer2D_fillRectangleAlpha")
   public static void Rasterizer2D_fillRectangleAlpha(int var0, int var1, int var2, int var3, int var4, int var5) {
      if (var0 < Rasterizer2D_xClipStart) {
         var2 -= Rasterizer2D_xClipStart - var0;
         var0 = Rasterizer2D_xClipStart;
      }

      if (var1 < Rasterizer2D_yClipStart) {
         var3 -= Rasterizer2D_yClipStart - var1;
         var1 = Rasterizer2D_yClipStart;
      }

      if (var0 + var2 > Rasterizer2D_xClipEnd) {
         var2 = Rasterizer2D_xClipEnd - var0;
      }

      if (var3 + var1 > Rasterizer2D_yClipEnd) {
         var3 = Rasterizer2D_yClipEnd - var1;
      }

      var4 = (var5 * (var4 & 16711935) >> 8 & 16711935) + (var5 * (var4 & 65280) >> 8 & 65280);
      int var6 = 256 - var5;
      int var7 = Rasterizer2D_width - var2;
      int var8 = var0 + Rasterizer2D_width * var1;

      for (int var9 = 0; var9 < var3; ++var9) {
         for (int var10 = -var2; var10 < 0; ++var10) {
            int var11 = Rasterizer2D_pixels[var8];
            var11 = ((var11 & 16711935) * var6 >> 8 & 16711935) + (var6 * (var11 & 65280) >> 8 & 65280);
            Rasterizer2D_pixels[var8++] = var11 + var4;
         }

         var8 += var7;
      }

   }

   @ObfuscatedName("dr")
   @Export("Rasterizer2D_fillRectangle")
   public static void Rasterizer2D_fillRectangle(int x, int y, int width, int height, int color) {
      if (x < Rasterizer2D_xClipStart) {
         width -= Rasterizer2D_xClipStart - x;
         x = Rasterizer2D_xClipStart;
      }

      if (y < Rasterizer2D_yClipStart) {
         height -= Rasterizer2D_yClipStart - y;
         y = Rasterizer2D_yClipStart;
      }

      if (x + width > Rasterizer2D_xClipEnd) {
         width = Rasterizer2D_xClipEnd - x;
      }

      if (height + y > Rasterizer2D_yClipEnd) {
         height = Rasterizer2D_yClipEnd - y;
      }

      int var5 = Rasterizer2D_width - width;
      int var6 = x + Rasterizer2D_width * y;

      for (int var7 = -height; var7 < 0; ++var7) {
         for (int var8 = -width; var8 < 0; ++var8) {
            Rasterizer2D_pixels[var6++] = color;
         }

         var6 += var5;
      }

   }

   @Export("drawGradient")
   @ObfuscatedName("dw")
   public static void drawGradient(int var0, int var1, int var2, int var3, int var4, int var5) {
      if (var2 > 0 && var3 > 0) {
         int var6 = 0;
         int var7 = 65536 / var3;
         if (var0 < Rasterizer2D_xClipStart) {
            var2 -= Rasterizer2D_xClipStart - var0;
            var0 = Rasterizer2D_xClipStart;
         }

         if (var1 < Rasterizer2D_yClipStart) {
            var6 += (Rasterizer2D_yClipStart - var1) * var7;
            var3 -= Rasterizer2D_yClipStart - var1;
            var1 = Rasterizer2D_yClipStart;
         }

         if (var0 + var2 > Rasterizer2D_xClipEnd) {
            var2 = Rasterizer2D_xClipEnd - var0;
         }

         if (var3 + var1 > Rasterizer2D_yClipEnd) {
            var3 = Rasterizer2D_yClipEnd - var1;
         }

         int var8 = Rasterizer2D_width - var2;
         int var9 = var0 + Rasterizer2D_width * var1;

         for (int var10 = -var3; var10 < 0; ++var10) {
            int var11 = 65536 - var6 >> 8;
            int var12 = var6 >> 8;
            int var13 = (var12 * (var5 & 16711935) + var11 * (var4 & 16711935) & -16711936) + (var12 * (var5 & 65280) + var11 * (var4 & 65280) & 16711680) >>> 8;

            for (int var14 = -var2; var14 < 0; ++var14) {
               Rasterizer2D_pixels[var9++] = var13;
            }

            var9 += var8;
            var6 += var7;
         }
      }

   }

   @ObfuscatedName("dv")
   @Export("drawGradientAlpha")
   public static void drawGradientAlpha(int var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      if (var2 > 0 && var3 > 0) {
         int var8 = 0;
         int var9 = 65536 / var3;
         if (var0 < Rasterizer2D_xClipStart) {
            var2 -= Rasterizer2D_xClipStart - var0;
            var0 = Rasterizer2D_xClipStart;
         }

         if (var1 < Rasterizer2D_yClipStart) {
            var8 += (Rasterizer2D_yClipStart - var1) * var9;
            var3 -= Rasterizer2D_yClipStart - var1;
            var1 = Rasterizer2D_yClipStart;
         }

         if (var0 + var2 > Rasterizer2D_xClipEnd) {
            var2 = Rasterizer2D_xClipEnd - var0;
         }

         if (var3 + var1 > Rasterizer2D_yClipEnd) {
            var3 = Rasterizer2D_yClipEnd - var1;
         }

         int var10 = Rasterizer2D_width - var2;
         int var11 = var0 + Rasterizer2D_width * var1;

         for (int var12 = -var3; var12 < 0; ++var12) {
            int var13 = 65536 - var8 >> 8;
            int var14 = var8 >> 8;
            int var15 = (var13 * var6 + var14 * var7 & 65280) >>> 8;
            if (var15 == 0) {
               var11 += Rasterizer2D_width;
               var8 += var9;
            } else {
               int var16 = (var14 * (var5 & 16711935) + var13 * (var4 & 16711935) & -16711936) + (var14 * (var5 & 65280) + var13 * (var4 & 65280) & 16711680) >>> 8;
               int var17 = 255 - var15;
               int var18 = ((var16 & 16711935) * var15 >> 8 & 16711935) + (var15 * (var16 & 65280) >> 8 & 65280);

               for (int var19 = -var2; var19 < 0; ++var19) {
                  int var20 = Rasterizer2D_pixels[var11];
                  if (var20 == 0) {
                     Rasterizer2D_pixels[var11++] = var18;
                  } else {
                     var20 = ((var20 & 16711935) * var17 >> 8 & 16711935) + (var17 * (var20 & 65280) >> 8 & 65280);
                     Rasterizer2D_pixels[var11++] = var18 + var20;
                  }
               }

               var11 += var10;
               var8 += var9;
            }
         }
      }

   }

   @ObfuscatedName("do")
   @ObfuscatedSignature(
      signature = "(IIIIII[BIZ)V",
      garbageValue = "1"
   )
   @Export("raster2d7")
   public static void raster2d7(int var0, int var1, int var2, int var3, int var4, int var5, byte[] var6, int var7) {
      if (var0 + var2 >= 0 && var3 + var1 >= 0 && var0 < Rasterizer2D_width && var1 < Rasterizer2D_height) {
         int var8 = 0;
         int var9 = 0;
         if (var0 < 0) {
            var8 -= var0;
            var2 += var0;
         }

         if (var1 < 0) {
            var9 -= var1;
            var3 += var1;
         }

         if (var0 + var2 > Rasterizer2D_width) {
            var2 = Rasterizer2D_width - var0;
         }

         if (var3 + var1 > Rasterizer2D_height) {
            var3 = Rasterizer2D_height - var1;
         }

         int var10 = var6.length / var7;
         int var11 = Rasterizer2D_width - var2;
         int var12 = var4 >>> 24;
         int var13 = var5 >>> 24;
         int var14;
         int var15;
         int var16;
         int var17;
         int var18;
         if (var12 == 255 && var13 == 255) {
            var14 = var0 + var8 + (var9 + var1) * Rasterizer2D_width;

            for (var15 = var9 + var1; var15 < var3 + var9 + var1; ++var15) {
               for (var16 = var0 + var8; var16 < var0 + var8 + var2; ++var16) {
                  var17 = (var15 - var1) % var10;
                  var18 = (var16 - var0) % var7;
                  if (var6[var18 + var17 * var7] != 0) {
                     Rasterizer2D_pixels[var14++] = var5;
                  } else {
                     Rasterizer2D_pixels[var14++] = var4;
                  }
               }

               var14 += var11;
            }
         } else {
            var14 = var0 + var8 + (var9 + var1) * Rasterizer2D_width;

            for (var15 = var9 + var1; var15 < var3 + var9 + var1; ++var15) {
               for (var16 = var0 + var8; var16 < var0 + var8 + var2; ++var16) {
                  var17 = (var15 - var1) % var10;
                  var18 = (var16 - var0) % var7;
                  int var19 = var4;
                  if (var6[var18 + var17 * var7] != 0) {
                     var19 = var5;
                  }

                  int var20 = var19 >>> 24;
                  int var21 = 255 - var20;
                  int var22 = Rasterizer2D_pixels[var14];
                  int var23 = ((var19 & 16711935) * var20 + (var22 & 16711935) * var21 & -16711936) + (var20 * (var19 & 65280) + var21 * (var22 & 65280) & 16711680) >> 8;
                  Rasterizer2D_pixels[var14++] = var23;
               }

               var14 += var11;
            }
         }
      }

   }

   @ObfuscatedName("dh")
   @Export("Rasterizer2D_drawRectangle")
   public static void Rasterizer2D_drawRectangle(int x, int y, int width, int height, int color) {
      Rasterizer2D_drawHorizontalLine(x, y, width, color);
      Rasterizer2D_drawHorizontalLine(x, height + y - 1, width, color);
      Rasterizer2D_drawVerticalLine(x, y, height, color);
      Rasterizer2D_drawVerticalLine(x + width - 1, y, height, color);
   }

   @ObfuscatedName("dz")
   @Export("Rasterizer2D_drawRectangleAlpha")
   public static void Rasterizer2D_drawRectangleAlpha(int x, int y, int width, int height, int rgb, int alpha) {
      Rasterizer2D_drawHorizontalLineAlpha(x, y, width, rgb, alpha);
      Rasterizer2D_drawHorizontalLineAlpha(x, height + y - 1, width, rgb, alpha);
      if (height >= 3) {
         Rasterizer2D_drawVerticalLineAlpha(x, y + 1, height - 2, rgb, alpha);
         Rasterizer2D_drawVerticalLineAlpha(x + width - 1, y + 1, height - 2, rgb, alpha);
      }

   }

   @ObfuscatedName("dj")
   @Export("Rasterizer2D_drawHorizontalLine")
   public static void Rasterizer2D_drawHorizontalLine(int x, int y, int length, int color) {
      if (y >= Rasterizer2D_yClipStart && y < Rasterizer2D_yClipEnd) {
         if (x < Rasterizer2D_xClipStart) {
            length -= Rasterizer2D_xClipStart - x;
            x = Rasterizer2D_xClipStart;
         }

         if (x + length > Rasterizer2D_xClipEnd) {
            length = Rasterizer2D_xClipEnd - x;
         }

         int var4 = x + Rasterizer2D_width * y;

         for (int var5 = 0; var5 < length; ++var5) {
            Rasterizer2D_pixels[var4 + var5] = color;
         }
      }

   }

   @ObfuscatedName("du")
   @Export("Rasterizer2D_drawHorizontalLineAlpha")
   static void Rasterizer2D_drawHorizontalLineAlpha(int x, int y, int length, int rgb, int alpha) {
      if (y >= Rasterizer2D_yClipStart && y < Rasterizer2D_yClipEnd) {
         if (x < Rasterizer2D_xClipStart) {
            length -= Rasterizer2D_xClipStart - x;
            x = Rasterizer2D_xClipStart;
         }

         if (x + length > Rasterizer2D_xClipEnd) {
            length = Rasterizer2D_xClipEnd - x;
         }

         int var5 = 256 - alpha;
         int var6 = (rgb >> 16 & 255) * alpha;
         int var7 = (rgb >> 8 & 255) * alpha;
         int var8 = alpha * (rgb & 255);
         int var9 = x + Rasterizer2D_width * y;

         for (int var10 = 0; var10 < length; ++var10) {
            int var11 = var5 * (Rasterizer2D_pixels[var9] >> 16 & 255);
            int var12 = (Rasterizer2D_pixels[var9] >> 8 & 255) * var5;
            int var13 = var5 * (Rasterizer2D_pixels[var9] & 255);
            int var14 = (var8 + var13 >> 8) + (var6 + var11 >> 8 << 16) + (var7 + var12 >> 8 << 8);
            Rasterizer2D_pixels[var9++] = var14;
         }
      }

   }

   @ObfuscatedName("dm")
   @Export("Rasterizer2D_drawVerticalLine")
   public static void Rasterizer2D_drawVerticalLine(int x, int y, int length, int color) {
      if (x >= Rasterizer2D_xClipStart && x < Rasterizer2D_xClipEnd) {
         if (y < Rasterizer2D_yClipStart) {
            length -= Rasterizer2D_yClipStart - y;
            y = Rasterizer2D_yClipStart;
         }

         if (length + y > Rasterizer2D_yClipEnd) {
            length = Rasterizer2D_yClipEnd - y;
         }

         int var4 = x + Rasterizer2D_width * y;

         for (int var5 = 0; var5 < length; ++var5) {
            Rasterizer2D_pixels[var4 + var5 * Rasterizer2D_width] = color;
         }
      }

   }

   @ObfuscatedName("dq")
   @Export("Rasterizer2D_drawVerticalLineAlpha")
   static void Rasterizer2D_drawVerticalLineAlpha(int x, int y, int length, int rgb, int alpha) {
      if (x >= Rasterizer2D_xClipStart && x < Rasterizer2D_xClipEnd) {
         if (y < Rasterizer2D_yClipStart) {
            length -= Rasterizer2D_yClipStart - y;
            y = Rasterizer2D_yClipStart;
         }

         if (length + y > Rasterizer2D_yClipEnd) {
            length = Rasterizer2D_yClipEnd - y;
         }

         int var5 = 256 - alpha;
         int var6 = (rgb >> 16 & 255) * alpha;
         int var7 = (rgb >> 8 & 255) * alpha;
         int var8 = alpha * (rgb & 255);
         int var9 = x + Rasterizer2D_width * y;

         for (int var10 = 0; var10 < length; ++var10) {
            int var11 = var5 * (Rasterizer2D_pixels[var9] >> 16 & 255);
            int var12 = (Rasterizer2D_pixels[var9] >> 8 & 255) * var5;
            int var13 = var5 * (Rasterizer2D_pixels[var9] & 255);
            int var14 = (var8 + var13 >> 8) + (var6 + var11 >> 8 << 16) + (var7 + var12 >> 8 << 8);
            Rasterizer2D_pixels[var9] = var14;
            var9 += Rasterizer2D_width;
         }
      }

   }

   @ObfuscatedName("et")
   @Export("Rasterizer2D_drawLine")
   public static void Rasterizer2D_drawLine(int x0, int y0, int x1, int y1, int color) {
      x1 -= x0;
      y1 -= y0;
      if (y1 == 0) {
         if (x1 >= 0) {
            Rasterizer2D_drawHorizontalLine(x0, y0, x1 + 1, color);
         } else {
            Rasterizer2D_drawHorizontalLine(x0 + x1, y0, -x1 + 1, color);
         }
      } else if (x1 == 0) {
         if (y1 >= 0) {
            Rasterizer2D_drawVerticalLine(x0, y0, y1 + 1, color);
         } else {
            Rasterizer2D_drawVerticalLine(x0, y1 + y0, -y1 + 1, color);
         }
      } else {
         if (y1 + x1 < 0) {
            x0 += x1;
            x1 = -x1;
            y0 += y1;
            y1 = -y1;
         }

         int var5;
         int var6;
         if (x1 > y1) {
            y0 <<= 16;
            y0 += 32768;
            y1 <<= 16;
            var5 = (int)Math.floor((double)y1 / (double)x1 + 0.5D);
            x1 += x0;
            if (x0 < Rasterizer2D_xClipStart) {
               y0 += var5 * (Rasterizer2D_xClipStart - x0);
               x0 = Rasterizer2D_xClipStart;
            }

            if (x1 >= Rasterizer2D_xClipEnd) {
               x1 = Rasterizer2D_xClipEnd - 1;
            }

            while (x0 <= x1) {
               var6 = y0 >> 16;
               if (var6 >= Rasterizer2D_yClipStart && var6 < Rasterizer2D_yClipEnd) {
                  Rasterizer2D_pixels[x0 + var6 * Rasterizer2D_width] = color;
               }

               y0 += var5;
               ++x0;
            }
         } else {
            x0 <<= 16;
            x0 += 32768;
            x1 <<= 16;
            var5 = (int)Math.floor((double)x1 / (double)y1 + 0.5D);
            y1 += y0;
            if (y0 < Rasterizer2D_yClipStart) {
               x0 += (Rasterizer2D_yClipStart - y0) * var5;
               y0 = Rasterizer2D_yClipStart;
            }

            if (y1 >= Rasterizer2D_yClipEnd) {
               y1 = Rasterizer2D_yClipEnd - 1;
            }

            while (y0 <= y1) {
               var6 = x0 >> 16;
               if (var6 >= Rasterizer2D_xClipStart && var6 < Rasterizer2D_xClipEnd) {
                  Rasterizer2D_pixels[var6 + Rasterizer2D_width * y0] = color;
               }

               x0 += var5;
               ++y0;
            }
         }
      }

   }

   @ObfuscatedName("eb")
   @Export("Rasterizer2D_setPixel")
   static void Rasterizer2D_setPixel(int x, int y, int color) {
      if (x >= Rasterizer2D_xClipStart && y >= Rasterizer2D_yClipStart && x < Rasterizer2D_xClipEnd && y < Rasterizer2D_yClipEnd) {
         Rasterizer2D_pixels[x + Rasterizer2D_width * y] = color;
      }

   }

   @ObfuscatedName("ek")
   public static void method5948(int var0, int var1, int var2, int[] var3, int[] var4) {
      int var5 = var0 + Rasterizer2D_width * var1;

      for (var1 = 0; var1 < var3.length; ++var1) {
         int var6 = var5 + var3[var1];

         for (var0 = -var4[var1]; var0 < 0; ++var0) {
            Rasterizer2D_pixels[var6++] = var2;
         }

         var5 += Rasterizer2D_width;
      }

   }

   static {
      Rasterizer2D_yClipStart = 0;
      Rasterizer2D_yClipEnd = 0;
      Rasterizer2D_xClipStart = 0;
      Rasterizer2D_xClipEnd = 0;
   }
}
