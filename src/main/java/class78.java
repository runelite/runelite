import java.awt.Component;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Toolkit;
import java.awt.image.PixelGrabber;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cd")
@Implements("SpritePixels")
public final class class78 extends class79 {
   @ObfuscatedName("w")
   public int field1401;
   @ObfuscatedName("d")
   public int field1402;
   @ObfuscatedName("c")
   int field1403;
   @ObfuscatedName("y")
   int field1404;
   @ObfuscatedName("k")
   public int field1405;
   @ObfuscatedName("r")
   public int field1407;
   @ObfuscatedName("a")
   public int[] field1411;

   @ObfuscatedName("k")
   public void method1785(int var1) {
      if(this.field1401 != this.field1405 || this.field1402 != this.field1407) {
         int var2 = var1;
         if(var1 > this.field1403) {
            var2 = this.field1403;
         }

         int var3 = var1;
         if(var1 + this.field1403 + this.field1401 > this.field1405) {
            var3 = this.field1405 - this.field1403 - this.field1401;
         }

         int var4 = var1;
         if(var1 > this.field1404) {
            var4 = this.field1404;
         }

         int var5 = var1;
         if(var1 + this.field1404 + this.field1402 > this.field1407) {
            var5 = this.field1407 - this.field1404 - this.field1402;
         }

         int var6 = this.field1401 + var2 + var3;
         int var7 = this.field1402 + var4 + var5;
         int[] var8 = new int[var6 * var7];

         for(int var9 = 0; var9 < this.field1402; ++var9) {
            for(int var10 = 0; var10 < this.field1401; ++var10) {
               var8[(var9 + var4) * var6 + var10 + var2] = this.field1411[var9 * this.field1401 + var10];
            }
         }

         this.field1411 = var8;
         this.field1401 = var6;
         this.field1402 = var7;
         this.field1403 -= var2;
         this.field1404 -= var4;
      }
   }

   public class78(int var1, int var2) {
      this.field1411 = new int[var1 * var2];
      this.field1401 = this.field1405 = var1;
      this.field1402 = this.field1407 = var2;
      this.field1404 = 0;
      this.field1403 = 0;
   }

   public class78(byte[] var1, Component var2) {
      try {
         Image var3 = Toolkit.getDefaultToolkit().createImage(var1);
         MediaTracker var4 = new MediaTracker(var2);
         var4.addImage(var3, 0);
         var4.waitForAll();
         this.field1401 = var3.getWidth(var2);
         this.field1402 = var3.getHeight(var2);
         this.field1405 = this.field1401;
         this.field1407 = this.field1402;
         this.field1403 = 0;
         this.field1404 = 0;
         this.field1411 = new int[this.field1401 * this.field1402];
         PixelGrabber var5 = new PixelGrabber(var3, 0, 0, this.field1401, this.field1402, this.field1411, 0, this.field1401);
         var5.grabPixels();
      } catch (InterruptedException var6) {
         ;
      }

   }

   @ObfuscatedName("a")
   public class78 method1786() {
      class78 var1 = new class78(this.field1401, this.field1402);
      var1.field1405 = this.field1405;
      var1.field1407 = this.field1407;
      var1.field1403 = this.field1405 - this.field1401 - this.field1403;
      var1.field1404 = this.field1404;

      for(int var2 = 0; var2 < this.field1402; ++var2) {
         for(int var3 = 0; var3 < this.field1401; ++var3) {
            var1.field1411[var2 * this.field1401 + var3] = this.field1411[var2 * this.field1401 + this.field1401 - 1 - var3];
         }
      }

      return var1;
   }

   @ObfuscatedName("w")
   public class78 method1787() {
      class78 var1 = new class78(this.field1405, this.field1407);

      for(int var2 = 0; var2 < this.field1402; ++var2) {
         for(int var3 = 0; var3 < this.field1401; ++var3) {
            var1.field1411[(var2 + this.field1404) * this.field1405 + var3 + this.field1403] = this.field1411[var2 * this.field1401 + var3];
         }
      }

      return var1;
   }

   @ObfuscatedName("h")
   static void method1788(int[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9) {
      int var10 = 256 - var9;

      for(int var11 = -var6; var11 < 0; ++var11) {
         for(int var12 = -var5; var12 < 0; ++var12) {
            var2 = var1[var3++];
            if(var2 != 0) {
               int var13 = var0[var4];
               var0[var4++] = ((var2 & 16711935) * var9 + (var13 & 16711935) * var10 & -16711936) + ((var2 & '\uff00') * var9 + (var13 & '\uff00') * var10 & 16711680) >> 8;
            } else {
               ++var4;
            }
         }

         var4 += var7;
         var3 += var8;
      }

   }

   @ObfuscatedName("n")
   static void method1789(int[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11) {
      int var12 = var3;

      for(int var13 = -var8; var13 < 0; ++var13) {
         int var14 = (var4 >> 16) * var11;

         for(int var15 = -var7; var15 < 0; ++var15) {
            var2 = var1[(var3 >> 16) + var14];
            if(var2 != 0) {
               var0[var5++] = var2;
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

   @ObfuscatedName("y")
   public void method1790() {
      if(this.field1401 != this.field1405 || this.field1402 != this.field1407) {
         int[] var1 = new int[this.field1405 * this.field1407];

         for(int var2 = 0; var2 < this.field1402; ++var2) {
            for(int var3 = 0; var3 < this.field1401; ++var3) {
               var1[(var2 + this.field1404) * this.field1405 + var3 + this.field1403] = this.field1411[var2 * this.field1401 + var3];
            }
         }

         this.field1411 = var1;
         this.field1401 = this.field1405;
         this.field1402 = this.field1407;
         this.field1403 = 0;
         this.field1404 = 0;
      }
   }

   @ObfuscatedName("p")
   public void method1793() {
      int[] var1 = new int[this.field1401 * this.field1402];
      int var2 = 0;

      for(int var3 = this.field1402 - 1; var3 >= 0; --var3) {
         for(int var4 = 0; var4 < this.field1401; ++var4) {
            var1[var2++] = this.field1411[var4 + var3 * this.field1401];
         }
      }

      this.field1411 = var1;
      this.field1404 = this.field1407 - this.field1402 - this.field1404;
   }

   @ObfuscatedName("m")
   public void method1794(int var1) {
      for(int var2 = this.field1402 - 1; var2 > 0; --var2) {
         int var3 = var2 * this.field1401;

         for(int var4 = this.field1401 - 1; var4 > 0; --var4) {
            if(this.field1411[var4 + var3] == 0 && this.field1411[var4 + var3 - 1 - this.field1401] != 0) {
               this.field1411[var4 + var3] = var1;
            }
         }
      }

   }

   @ObfuscatedName("g")
   static void method1795(int[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10) {
      int var11 = 256 - var9;
      int var12 = (var10 & 16711935) * var11 & -16711936;
      int var13 = (var10 & '\uff00') * var11 & 16711680;
      var10 = (var12 | var13) >>> 8;

      for(int var14 = -var6; var14 < 0; ++var14) {
         for(int var15 = -var5; var15 < 0; ++var15) {
            var2 = var1[var3++];
            if(var2 != 0) {
               var12 = (var2 & 16711935) * var9 & -16711936;
               var13 = (var2 & '\uff00') * var9 & 16711680;
               var0[var4++] = ((var12 | var13) >>> 8) + var10;
            } else {
               ++var4;
            }
         }

         var4 += var7;
         var3 += var8;
      }

   }

   @ObfuscatedName("e")
   public void method1796(int var1, int var2) {
      var1 += this.field1403;
      var2 += this.field1404;
      int var3 = var1 + var2 * class79.field1417;
      int var4 = 0;
      int var5 = this.field1402;
      int var6 = this.field1401;
      int var7 = class79.field1417 - var6;
      int var8 = 0;
      int var9;
      if(var2 < class79.field1415) {
         var9 = class79.field1415 - var2;
         var5 -= var9;
         var2 = class79.field1415;
         var4 += var9 * var6;
         var3 += var9 * class79.field1417;
      }

      if(var2 + var5 > class79.field1416) {
         var5 -= var2 + var5 - class79.field1416;
      }

      if(var1 < class79.field1412) {
         var9 = class79.field1412 - var1;
         var6 -= var9;
         var1 = class79.field1412;
         var4 += var9;
         var3 += var9;
         var8 += var9;
         var7 += var9;
      }

      if(var1 + var6 > class79.field1418) {
         var9 = var1 + var6 - class79.field1418;
         var6 -= var9;
         var8 += var9;
         var7 += var9;
      }

      if(var6 > 0 && var5 > 0) {
         method1797(class79.field1413, this.field1411, var4, var3, var6, var5, var7, var8);
      }
   }

   @ObfuscatedName("x")
   static void method1797(int[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      for(int var8 = -var5; var8 < 0; ++var8) {
         int var9;
         for(var9 = var3 + var4 - 3; var3 < var9; var0[var3++] = var1[var2++]) {
            var0[var3++] = var1[var2++];
            var0[var3++] = var1[var2++];
            var0[var3++] = var1[var2++];
         }

         for(var9 += 3; var3 < var9; var0[var3++] = var1[var2++]) {
            ;
         }

         var3 += var6;
         var2 += var7;
      }

   }

   @ObfuscatedName("z")
   public void method1798(int var1, int var2) {
      var1 += this.field1403;
      var2 += this.field1404;
      int var3 = var1 + var2 * class79.field1417;
      int var4 = 0;
      int var5 = this.field1402;
      int var6 = this.field1401;
      int var7 = class79.field1417 - var6;
      int var8 = 0;
      int var9;
      if(var2 < class79.field1415) {
         var9 = class79.field1415 - var2;
         var5 -= var9;
         var2 = class79.field1415;
         var4 += var9 * var6;
         var3 += var9 * class79.field1417;
      }

      if(var2 + var5 > class79.field1416) {
         var5 -= var2 + var5 - class79.field1416;
      }

      if(var1 < class79.field1412) {
         var9 = class79.field1412 - var1;
         var6 -= var9;
         var1 = class79.field1412;
         var4 += var9;
         var3 += var9;
         var8 += var9;
         var7 += var9;
      }

      if(var1 + var6 > class79.field1418) {
         var9 = var1 + var6 - class79.field1418;
         var6 -= var9;
         var8 += var9;
         var7 += var9;
      }

      if(var6 > 0 && var5 > 0) {
         method1799(class79.field1413, this.field1411, 0, var4, var3, var6, var5, var7, var8);
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "([I[IIIIIIII)V",
      garbageValue = "0"
   )
   static void method1799(int[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
      int var9 = -(var5 >> 2);
      var5 = -(var5 & 3);

      for(int var10 = -var6; var10 < 0; ++var10) {
         int var11;
         for(var11 = var9; var11 < 0; ++var11) {
            var2 = var1[var3++];
            if(var2 != 0) {
               var0[var4++] = var2;
            } else {
               ++var4;
            }

            var2 = var1[var3++];
            if(var2 != 0) {
               var0[var4++] = var2;
            } else {
               ++var4;
            }

            var2 = var1[var3++];
            if(var2 != 0) {
               var0[var4++] = var2;
            } else {
               ++var4;
            }

            var2 = var1[var3++];
            if(var2 != 0) {
               var0[var4++] = var2;
            } else {
               ++var4;
            }
         }

         for(var11 = var5; var11 < 0; ++var11) {
            var2 = var1[var3++];
            if(var2 != 0) {
               var0[var4++] = var2;
            } else {
               ++var4;
            }
         }

         var4 += var7;
         var3 += var8;
      }

   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "128"
   )
   public void method1802(int var1, int var2, int var3, int var4) {
      var1 += this.field1403;
      var2 += this.field1404;
      int var5 = var1 + var2 * class79.field1417;
      int var6 = 0;
      int var7 = this.field1402;
      int var8 = this.field1401;
      int var9 = class79.field1417 - var8;
      int var10 = 0;
      int var11;
      if(var2 < class79.field1415) {
         var11 = class79.field1415 - var2;
         var7 -= var11;
         var2 = class79.field1415;
         var6 += var11 * var8;
         var5 += var11 * class79.field1417;
      }

      if(var2 + var7 > class79.field1416) {
         var7 -= var2 + var7 - class79.field1416;
      }

      if(var1 < class79.field1412) {
         var11 = class79.field1412 - var1;
         var8 -= var11;
         var1 = class79.field1412;
         var6 += var11;
         var5 += var11;
         var10 += var11;
         var9 += var11;
      }

      if(var1 + var8 > class79.field1418) {
         var11 = var1 + var8 - class79.field1418;
         var8 -= var11;
         var10 += var11;
         var9 += var11;
      }

      if(var8 > 0 && var7 > 0) {
         method1795(class79.field1413, this.field1411, 0, var6, var5, var8, var7, var9, var10, var3, var4);
      }
   }

   @ObfuscatedName("c")
   public void method1805(int var1, int var2, int var3) {
      for(int var4 = 0; var4 < this.field1411.length; ++var4) {
         int var5 = this.field1411[var4];
         if(var5 != 0) {
            int var6 = var5 >> 16 & 255;
            var6 += var1;
            if(var6 < 1) {
               var6 = 1;
            } else if(var6 > 255) {
               var6 = 255;
            }

            int var7 = var5 >> 8 & 255;
            var7 += var2;
            if(var7 < 1) {
               var7 = 1;
            } else if(var7 > 255) {
               var7 = 255;
            }

            int var8 = var5 & 255;
            var8 += var3;
            if(var8 < 1) {
               var8 = 1;
            } else if(var8 > 255) {
               var8 = 255;
            }

            this.field1411[var4] = (var6 << 16) + (var7 << 8) + var8;
         }
      }

   }

   @ObfuscatedName("s")
   public void method1806(int var1, int var2, int var3, int var4, int var5) {
      if(var3 > 0 && var4 > 0) {
         int var6 = this.field1401;
         int var7 = this.field1402;
         int var8 = 0;
         int var9 = 0;
         int var10 = this.field1405;
         int var11 = this.field1407;
         int var12 = (var10 << 16) / var3;
         int var13 = (var11 << 16) / var4;
         int var14;
         if(this.field1403 > 0) {
            var14 = ((this.field1403 << 16) + var12 - 1) / var12;
            var1 += var14;
            var8 += var14 * var12 - (this.field1403 << 16);
         }

         if(this.field1404 > 0) {
            var14 = ((this.field1404 << 16) + var13 - 1) / var13;
            var2 += var14;
            var9 += var14 * var13 - (this.field1404 << 16);
         }

         if(var6 < var10) {
            var3 = ((var6 << 16) - var8 + var12 - 1) / var12;
         }

         if(var7 < var11) {
            var4 = ((var7 << 16) - var9 + var13 - 1) / var13;
         }

         var14 = var1 + var2 * class79.field1417;
         int var15 = class79.field1417 - var3;
         if(var2 + var4 > class79.field1416) {
            var4 -= var2 + var4 - class79.field1416;
         }

         int var16;
         if(var2 < class79.field1415) {
            var16 = class79.field1415 - var2;
            var4 -= var16;
            var14 += var16 * class79.field1417;
            var9 += var13 * var16;
         }

         if(var1 + var3 > class79.field1418) {
            var16 = var1 + var3 - class79.field1418;
            var3 -= var16;
            var15 += var16;
         }

         if(var1 < class79.field1412) {
            var16 = class79.field1412 - var1;
            var3 -= var16;
            var14 += var16;
            var8 += var12 * var16;
            var15 += var16;
         }

         method1860(class79.field1413, this.field1411, 0, var8, var9, var14, var15, var3, var4, var12, var13, var6, var5);
      }
   }

   @ObfuscatedName("b")
   public void method1808(int var1, int var2, int var3, int var4, int var5, int var6, int[] var7, int[] var8) {
      int var9 = var2 < 0?-var2:0;
      int var10 = var2 + this.field1402 <= var6?this.field1402:var6 - var2;
      int var11 = var1 < 0?-var1:0;
      int var10000;
      if(var1 + this.field1401 <= var5) {
         var10000 = this.field1401;
      } else {
         var10000 = var5 - var1;
      }

      int var13 = var3 + var1 + var11 + (var4 + var2 + var9) * class79.field1417;
      int var14 = var2 + var9;

      for(int var15 = var9; var15 < var10; ++var15) {
         int var16 = var7[var14];
         int var17 = var8[var14++];
         int var18 = var13;
         int var19;
         if(var1 < var16) {
            var19 = var16 - var1;
            var18 = var13 + (var19 - var11);
         } else {
            var19 = var11;
         }

         int var12;
         if(var1 + this.field1401 <= var16 + var17) {
            var12 = this.field1401;
         } else {
            var12 = var16 + var17 - var1;
         }

         for(int var20 = var19; var20 < var12; ++var20) {
            int var21 = this.field1411[var20 + var15 * this.field1401];
            if(var21 != 0) {
               class79.field1413[var18++] = var21;
            } else {
               ++var18;
            }
         }

         var13 += class79.field1417;
      }

   }

   @ObfuscatedName("l")
   public void method1809(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int[] var9, int[] var10) {
      try {
         int var11 = -var3 / 2;
         int var12 = -var4 / 2;
         int var13 = (int)(Math.sin((double)var7 / 326.11D) * 65536.0D);
         int var14 = (int)(Math.cos((double)var7 / 326.11D) * 65536.0D);
         var13 = var13 * var8 >> 8;
         var14 = var14 * var8 >> 8;
         int var15 = (var5 << 16) + var12 * var13 + var11 * var14;
         int var16 = (var6 << 16) + (var12 * var14 - var11 * var13);
         int var17 = var1 + var2 * class79.field1417;

         for(var2 = 0; var2 < var4; ++var2) {
            int var18 = var9[var2];
            int var19 = var17 + var18;
            int var20 = var15 + var14 * var18;
            int var21 = var16 - var13 * var18;

            for(var1 = -var10[var2]; var1 < 0; ++var1) {
               class79.field1413[var19++] = this.field1411[(var20 >> 16) + (var21 >> 16) * this.field1401];
               var20 += var14;
               var21 -= var13;
            }

            var15 += var13;
            var16 += var14;
            var17 += class79.field1417;
         }
      } catch (Exception var22) {
         ;
      }

   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(IIIIIIDI)V",
      garbageValue = "20"
   )
   public void method1810(int var1, int var2, int var3, int var4, int var5, int var6, double var7, int var9) {
      try {
         int var10 = -var3 / 2;
         int var11 = -var4 / 2;
         int var12 = (int)(Math.sin(var7) * 65536.0D);
         int var13 = (int)(Math.cos(var7) * 65536.0D);
         var12 = var12 * var9 >> 8;
         var13 = var13 * var9 >> 8;
         int var14 = (var5 << 16) + var11 * var12 + var10 * var13;
         int var15 = (var6 << 16) + (var11 * var13 - var10 * var12);
         int var16 = var1 + var2 * class79.field1417;

         for(var2 = 0; var2 < var4; ++var2) {
            int var17 = var16;
            int var18 = var14;
            int var19 = var15;

            for(var1 = -var3; var1 < 0; ++var1) {
               int var20 = this.field1411[(var18 >> 16) + (var19 >> 16) * this.field1401];
               if(var20 != 0) {
                  class79.field1413[var17++] = var20;
               } else {
                  ++var17;
               }

               var18 += var13;
               var19 -= var12;
            }

            var14 += var12;
            var15 += var13;
            var16 += class79.field1417;
         }
      } catch (Exception var21) {
         ;
      }

   }

   @ObfuscatedName("v")
   public void method1811(int var1, int var2, int var3, int var4) {
      this.method1812(this.field1405 << 3, this.field1407 << 3, var1 << 4, var2 << 4, var3, var4);
   }

   @ObfuscatedName("ad")
   void method1812(int var1, int var2, int var3, int var4, int var5, int var6) {
      if(var6 != 0) {
         var1 -= this.field1403 << 4;
         var2 -= this.field1404 << 4;
         double var7 = (double)(var5 & '\uffff') * 9.587379924285257E-5D;
         int var9 = (int)Math.floor(Math.sin(var7) * (double)var6 + 0.5D);
         int var10 = (int)Math.floor(Math.cos(var7) * (double)var6 + 0.5D);
         int var11 = -var1 * var10 + -var2 * var9;
         int var12 = -(-var1) * var9 + -var2 * var10;
         int var13 = ((this.field1401 << 4) - var1) * var10 + -var2 * var9;
         int var14 = -((this.field1401 << 4) - var1) * var9 + -var2 * var10;
         int var15 = -var1 * var10 + ((this.field1402 << 4) - var2) * var9;
         int var16 = -(-var1) * var9 + ((this.field1402 << 4) - var2) * var10;
         int var17 = ((this.field1401 << 4) - var1) * var10 + ((this.field1402 << 4) - var2) * var9;
         int var18 = -((this.field1401 << 4) - var1) * var9 + ((this.field1402 << 4) - var2) * var10;
         int var19;
         int var20;
         if(var11 < var13) {
            var19 = var11;
            var20 = var13;
         } else {
            var19 = var13;
            var20 = var11;
         }

         if(var15 < var19) {
            var19 = var15;
         }

         if(var17 < var19) {
            var19 = var17;
         }

         if(var15 > var20) {
            var20 = var15;
         }

         if(var17 > var20) {
            var20 = var17;
         }

         int var21;
         int var22;
         if(var12 < var14) {
            var21 = var12;
            var22 = var14;
         } else {
            var21 = var14;
            var22 = var12;
         }

         if(var16 < var21) {
            var21 = var16;
         }

         if(var18 < var21) {
            var21 = var18;
         }

         if(var16 > var22) {
            var22 = var16;
         }

         if(var18 > var22) {
            var22 = var18;
         }

         var19 >>= 12;
         var20 = var20 + 4095 >> 12;
         var21 >>= 12;
         var22 = var22 + 4095 >> 12;
         var19 += var3;
         var20 += var3;
         var21 += var4;
         var22 += var4;
         var19 >>= 4;
         var20 = var20 + 15 >> 4;
         var21 >>= 4;
         var22 = var22 + 15 >> 4;
         if(var19 < class79.field1412) {
            var19 = class79.field1412;
         }

         if(var20 > class79.field1418) {
            var20 = class79.field1418;
         }

         if(var21 < class79.field1415) {
            var21 = class79.field1415;
         }

         if(var22 > class79.field1416) {
            var22 = class79.field1416;
         }

         var20 = var19 - var20;
         if(var20 < 0) {
            var22 = var21 - var22;
            if(var22 < 0) {
               int var23 = var21 * class79.field1417 + var19;
               double var24 = 1.6777216E7D / (double)var6;
               int var26 = (int)Math.floor(Math.sin(var7) * var24 + 0.5D);
               int var27 = (int)Math.floor(Math.cos(var7) * var24 + 0.5D);
               int var28 = (var19 << 4) + 8 - var3;
               int var29 = (var21 << 4) + 8 - var4;
               int var30 = (var1 << 8) - (var29 * var26 >> 4);
               int var31 = (var2 << 8) + (var29 * var27 >> 4);
               int var32;
               int var33;
               int var34;
               int var35;
               int var36;
               int var37;
               int var38;
               if(var27 == 0) {
                  if(var26 == 0) {
                     for(var33 = var22; var33 < 0; var23 += class79.field1417) {
                        var34 = var23;
                        var35 = var30;
                        var36 = var31;
                        var37 = var20;
                        if(var30 >= 0 && var31 >= 0 && var30 - (this.field1401 << 12) < 0 && var31 - (this.field1402 << 12) < 0) {
                           for(; var37 < 0; ++var37) {
                              var38 = this.field1411[(var36 >> 12) * this.field1401 + (var35 >> 12)];
                              if(var38 != 0) {
                                 class79.field1413[var34++] = var38;
                              } else {
                                 ++var34;
                              }
                           }
                        }

                        ++var33;
                     }
                  } else if(var26 < 0) {
                     for(var33 = var22; var33 < 0; var23 += class79.field1417) {
                        var34 = var23;
                        var35 = var30;
                        var36 = var31 + (var28 * var26 >> 4);
                        var37 = var20;
                        if(var30 >= 0 && var30 - (this.field1401 << 12) < 0) {
                           if((var32 = var36 - (this.field1402 << 12)) >= 0) {
                              var32 = (var26 - var32) / var26;
                              var37 = var20 + var32;
                              var36 += var26 * var32;
                              var34 = var23 + var32;
                           }

                           if((var32 = (var36 - var26) / var26) > var37) {
                              var37 = var32;
                           }

                           while(var37 < 0) {
                              var38 = this.field1411[(var36 >> 12) * this.field1401 + (var35 >> 12)];
                              if(var38 != 0) {
                                 class79.field1413[var34++] = var38;
                              } else {
                                 ++var34;
                              }

                              var36 += var26;
                              ++var37;
                           }
                        }

                        ++var33;
                        var30 -= var26;
                     }
                  } else {
                     for(var33 = var22; var33 < 0; var23 += class79.field1417) {
                        var34 = var23;
                        var35 = var30;
                        var36 = var31 + (var28 * var26 >> 4);
                        var37 = var20;
                        if(var30 >= 0 && var30 - (this.field1401 << 12) < 0) {
                           if(var36 < 0) {
                              var32 = (var26 - 1 - var36) / var26;
                              var37 = var20 + var32;
                              var36 += var26 * var32;
                              var34 = var23 + var32;
                           }

                           if((var32 = (1 + var36 - (this.field1402 << 12) - var26) / var26) > var37) {
                              var37 = var32;
                           }

                           while(var37 < 0) {
                              var38 = this.field1411[(var36 >> 12) * this.field1401 + (var35 >> 12)];
                              if(var38 != 0) {
                                 class79.field1413[var34++] = var38;
                              } else {
                                 ++var34;
                              }

                              var36 += var26;
                              ++var37;
                           }
                        }

                        ++var33;
                        var30 -= var26;
                     }
                  }
               } else if(var27 < 0) {
                  if(var26 == 0) {
                     for(var33 = var22; var33 < 0; var23 += class79.field1417) {
                        var34 = var23;
                        var35 = var30 + (var28 * var27 >> 4);
                        var36 = var31;
                        var37 = var20;
                        if(var31 >= 0 && var31 - (this.field1402 << 12) < 0) {
                           if((var32 = var35 - (this.field1401 << 12)) >= 0) {
                              var32 = (var27 - var32) / var27;
                              var37 = var20 + var32;
                              var35 += var27 * var32;
                              var34 = var23 + var32;
                           }

                           if((var32 = (var35 - var27) / var27) > var37) {
                              var37 = var32;
                           }

                           while(var37 < 0) {
                              var38 = this.field1411[(var36 >> 12) * this.field1401 + (var35 >> 12)];
                              if(var38 != 0) {
                                 class79.field1413[var34++] = var38;
                              } else {
                                 ++var34;
                              }

                              var35 += var27;
                              ++var37;
                           }
                        }

                        ++var33;
                        var31 += var27;
                     }
                  } else if(var26 < 0) {
                     for(var33 = var22; var33 < 0; var23 += class79.field1417) {
                        var34 = var23;
                        var35 = var30 + (var28 * var27 >> 4);
                        var36 = var31 + (var28 * var26 >> 4);
                        var37 = var20;
                        if((var32 = var35 - (this.field1401 << 12)) >= 0) {
                           var32 = (var27 - var32) / var27;
                           var37 = var20 + var32;
                           var35 += var27 * var32;
                           var36 += var26 * var32;
                           var34 = var23 + var32;
                        }

                        if((var32 = (var35 - var27) / var27) > var37) {
                           var37 = var32;
                        }

                        if((var32 = var36 - (this.field1402 << 12)) >= 0) {
                           var32 = (var26 - var32) / var26;
                           var37 += var32;
                           var35 += var27 * var32;
                           var36 += var26 * var32;
                           var34 += var32;
                        }

                        if((var32 = (var36 - var26) / var26) > var37) {
                           var37 = var32;
                        }

                        while(var37 < 0) {
                           var38 = this.field1411[(var36 >> 12) * this.field1401 + (var35 >> 12)];
                           if(var38 != 0) {
                              class79.field1413[var34++] = var38;
                           } else {
                              ++var34;
                           }

                           var35 += var27;
                           var36 += var26;
                           ++var37;
                        }

                        ++var33;
                        var30 -= var26;
                        var31 += var27;
                     }
                  } else {
                     for(var33 = var22; var33 < 0; var23 += class79.field1417) {
                        var34 = var23;
                        var35 = var30 + (var28 * var27 >> 4);
                        var36 = var31 + (var28 * var26 >> 4);
                        var37 = var20;
                        if((var32 = var35 - (this.field1401 << 12)) >= 0) {
                           var32 = (var27 - var32) / var27;
                           var37 = var20 + var32;
                           var35 += var27 * var32;
                           var36 += var26 * var32;
                           var34 = var23 + var32;
                        }

                        if((var32 = (var35 - var27) / var27) > var37) {
                           var37 = var32;
                        }

                        if(var36 < 0) {
                           var32 = (var26 - 1 - var36) / var26;
                           var37 += var32;
                           var35 += var27 * var32;
                           var36 += var26 * var32;
                           var34 += var32;
                        }

                        if((var32 = (1 + var36 - (this.field1402 << 12) - var26) / var26) > var37) {
                           var37 = var32;
                        }

                        while(var37 < 0) {
                           var38 = this.field1411[(var36 >> 12) * this.field1401 + (var35 >> 12)];
                           if(var38 != 0) {
                              class79.field1413[var34++] = var38;
                           } else {
                              ++var34;
                           }

                           var35 += var27;
                           var36 += var26;
                           ++var37;
                        }

                        ++var33;
                        var30 -= var26;
                        var31 += var27;
                     }
                  }
               } else if(var26 == 0) {
                  for(var33 = var22; var33 < 0; var23 += class79.field1417) {
                     var34 = var23;
                     var35 = var30 + (var28 * var27 >> 4);
                     var36 = var31;
                     var37 = var20;
                     if(var31 >= 0 && var31 - (this.field1402 << 12) < 0) {
                        if(var35 < 0) {
                           var32 = (var27 - 1 - var35) / var27;
                           var37 = var20 + var32;
                           var35 += var27 * var32;
                           var34 = var23 + var32;
                        }

                        if((var32 = (1 + var35 - (this.field1401 << 12) - var27) / var27) > var37) {
                           var37 = var32;
                        }

                        while(var37 < 0) {
                           var38 = this.field1411[(var36 >> 12) * this.field1401 + (var35 >> 12)];
                           if(var38 != 0) {
                              class79.field1413[var34++] = var38;
                           } else {
                              ++var34;
                           }

                           var35 += var27;
                           ++var37;
                        }
                     }

                     ++var33;
                     var31 += var27;
                  }
               } else if(var26 < 0) {
                  for(var33 = var22; var33 < 0; var23 += class79.field1417) {
                     var34 = var23;
                     var35 = var30 + (var28 * var27 >> 4);
                     var36 = var31 + (var28 * var26 >> 4);
                     var37 = var20;
                     if(var35 < 0) {
                        var32 = (var27 - 1 - var35) / var27;
                        var37 = var20 + var32;
                        var35 += var27 * var32;
                        var36 += var26 * var32;
                        var34 = var23 + var32;
                     }

                     if((var32 = (1 + var35 - (this.field1401 << 12) - var27) / var27) > var37) {
                        var37 = var32;
                     }

                     if((var32 = var36 - (this.field1402 << 12)) >= 0) {
                        var32 = (var26 - var32) / var26;
                        var37 += var32;
                        var35 += var27 * var32;
                        var36 += var26 * var32;
                        var34 += var32;
                     }

                     if((var32 = (var36 - var26) / var26) > var37) {
                        var37 = var32;
                     }

                     while(var37 < 0) {
                        var38 = this.field1411[(var36 >> 12) * this.field1401 + (var35 >> 12)];
                        if(var38 != 0) {
                           class79.field1413[var34++] = var38;
                        } else {
                           ++var34;
                        }

                        var35 += var27;
                        var36 += var26;
                        ++var37;
                     }

                     ++var33;
                     var30 -= var26;
                     var31 += var27;
                  }
               } else {
                  for(var33 = var22; var33 < 0; var23 += class79.field1417) {
                     var34 = var23;
                     var35 = var30 + (var28 * var27 >> 4);
                     var36 = var31 + (var28 * var26 >> 4);
                     var37 = var20;
                     if(var35 < 0) {
                        var32 = (var27 - 1 - var35) / var27;
                        var37 = var20 + var32;
                        var35 += var27 * var32;
                        var36 += var26 * var32;
                        var34 = var23 + var32;
                     }

                     if((var32 = (1 + var35 - (this.field1401 << 12) - var27) / var27) > var37) {
                        var37 = var32;
                     }

                     if(var36 < 0) {
                        var32 = (var26 - 1 - var36) / var26;
                        var37 += var32;
                        var35 += var27 * var32;
                        var36 += var26 * var32;
                        var34 += var32;
                     }

                     if((var32 = (1 + var36 - (this.field1402 << 12) - var26) / var26) > var37) {
                        var37 = var32;
                     }

                     while(var37 < 0) {
                        var38 = this.field1411[(var36 >> 12) * this.field1401 + (var35 >> 12)];
                        if(var38 != 0) {
                           class79.field1413[var34++] = var38;
                        } else {
                           ++var34;
                        }

                        var35 += var27;
                        var36 += var26;
                        ++var37;
                     }

                     ++var33;
                     var30 -= var26;
                     var31 += var27;
                  }
               }

            }
         }
      }
   }

   @ObfuscatedName("r")
   public void method1820() {
      int[] var1 = new int[this.field1401 * this.field1402];
      int var2 = 0;

      for(int var3 = 0; var3 < this.field1402; ++var3) {
         for(int var4 = this.field1401 - 1; var4 >= 0; --var4) {
            var1[var2++] = this.field1411[var4 + var3 * this.field1401];
         }
      }

      this.field1411 = var1;
      this.field1403 = this.field1405 - this.field1401 - this.field1403;
   }

   @ObfuscatedName("d")
   public void method1849() {
      class79.method1942(this.field1411, this.field1401, this.field1402);
   }

   class78() {
   }

   @ObfuscatedName("j")
   public void method1856(int var1, int var2, int var3) {
      var1 += this.field1403;
      var2 += this.field1404;
      int var4 = var1 + var2 * class79.field1417;
      int var5 = 0;
      int var6 = this.field1402;
      int var7 = this.field1401;
      int var8 = class79.field1417 - var7;
      int var9 = 0;
      int var10;
      if(var2 < class79.field1415) {
         var10 = class79.field1415 - var2;
         var6 -= var10;
         var2 = class79.field1415;
         var5 += var10 * var7;
         var4 += var10 * class79.field1417;
      }

      if(var2 + var6 > class79.field1416) {
         var6 -= var2 + var6 - class79.field1416;
      }

      if(var1 < class79.field1412) {
         var10 = class79.field1412 - var1;
         var7 -= var10;
         var1 = class79.field1412;
         var5 += var10;
         var4 += var10;
         var9 += var10;
         var8 += var10;
      }

      if(var1 + var7 > class79.field1418) {
         var10 = var1 + var7 - class79.field1418;
         var7 -= var10;
         var9 += var10;
         var8 += var10;
      }

      if(var7 > 0 && var6 > 0) {
         method1788(class79.field1413, this.field1411, 0, var5, var4, var7, var6, var8, var9, var3);
      }
   }

   @ObfuscatedName("t")
   public void method1859(int var1, int var2, int var3, int var4) {
      if(var3 > 0 && var4 > 0) {
         int var5 = this.field1401;
         int var6 = this.field1402;
         int var7 = 0;
         int var8 = 0;
         int var9 = this.field1405;
         int var10 = this.field1407;
         int var11 = (var9 << 16) / var3;
         int var12 = (var10 << 16) / var4;
         int var13;
         if(this.field1403 > 0) {
            var13 = ((this.field1403 << 16) + var11 - 1) / var11;
            var1 += var13;
            var7 += var13 * var11 - (this.field1403 << 16);
         }

         if(this.field1404 > 0) {
            var13 = ((this.field1404 << 16) + var12 - 1) / var12;
            var2 += var13;
            var8 += var13 * var12 - (this.field1404 << 16);
         }

         if(var5 < var9) {
            var3 = ((var5 << 16) - var7 + var11 - 1) / var11;
         }

         if(var6 < var10) {
            var4 = ((var6 << 16) - var8 + var12 - 1) / var12;
         }

         var13 = var1 + var2 * class79.field1417;
         int var14 = class79.field1417 - var3;
         if(var2 + var4 > class79.field1416) {
            var4 -= var2 + var4 - class79.field1416;
         }

         int var15;
         if(var2 < class79.field1415) {
            var15 = class79.field1415 - var2;
            var4 -= var15;
            var13 += var15 * class79.field1417;
            var8 += var12 * var15;
         }

         if(var1 + var3 > class79.field1418) {
            var15 = var1 + var3 - class79.field1418;
            var3 -= var15;
            var14 += var15;
         }

         if(var1 < class79.field1412) {
            var15 = class79.field1412 - var1;
            var3 -= var15;
            var13 += var15;
            var7 += var11 * var15;
            var14 += var15;
         }

         method1789(class79.field1413, this.field1411, 0, var7, var8, var13, var14, var3, var4, var11, var12, var5);
      }
   }

   @ObfuscatedName("f")
   static void method1860(int[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, int var12) {
      int var13 = 256 - var12;
      int var14 = var3;

      for(int var15 = -var8; var15 < 0; ++var15) {
         int var16 = (var4 >> 16) * var11;

         for(int var17 = -var7; var17 < 0; ++var17) {
            var2 = var1[(var3 >> 16) + var16];
            if(var2 != 0) {
               int var18 = var0[var5];
               var0[var5++] = ((var2 & 16711935) * var12 + (var18 & 16711935) * var13 & -16711936) + ((var2 & '\uff00') * var12 + (var18 & '\uff00') * var13 & 16711680) >> 8;
            } else {
               ++var5;
            }

            var3 += var9;
         }

         var4 += var10;
         var3 = var14;
         var5 += var6;
      }

   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1"
   )
   public void method1876(int var1) {
      int[] var2 = new int[this.field1401 * this.field1402];
      int var3 = 0;

      for(int var4 = 0; var4 < this.field1402; ++var4) {
         for(int var5 = 0; var5 < this.field1401; ++var5) {
            int var6 = this.field1411[var3];
            if(var6 == 0) {
               if(var5 > 0 && this.field1411[var3 - 1] != 0) {
                  var6 = var1;
               } else if(var4 > 0 && this.field1411[var3 - this.field1401] != 0) {
                  var6 = var1;
               } else if(var5 < this.field1401 - 1 && this.field1411[var3 + 1] != 0) {
                  var6 = var1;
               } else if(var4 < this.field1402 - 1 && this.field1411[var3 + this.field1401] != 0) {
                  var6 = var1;
               }
            }

            var2[var3++] = var6;
         }
      }

      this.field1411 = var2;
   }
}
