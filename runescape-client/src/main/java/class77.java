import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bj")
public class class77 {
   @ObfuscatedName("j")
   int[][] field1419;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -1806714903
   )
   int field1422;
   @ObfuscatedName("do")
   @Export("mapRegions")
   static int[] mapRegions;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 1435980595
   )
   int field1427;

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "-896669220"
   )
   int method1646(int var1) {
      if(this.field1419 != null) {
         var1 = (int)((long)var1 * (long)this.field1427 / (long)this.field1422);
      }

      return var1;
   }

   public class77(int var1, int var2) {
      if(var2 != var1) {
         int var3 = class53.method1085(var1, var2);
         var1 /= var3;
         var2 /= var3;
         this.field1422 = var1;
         this.field1427 = var2;
         this.field1419 = new int[var1][14];

         for(int var4 = 0; var4 < var1; ++var4) {
            int[] var5 = this.field1419[var4];
            double var6 = (double)var4 / (double)var1 + 6.0D;
            int var8 = (int)Math.floor(var6 - 7.0D + 1.0D);
            if(var8 < 0) {
               var8 = 0;
            }

            int var9 = (int)Math.ceil(7.0D + var6);
            if(var9 > 14) {
               var9 = 14;
            }

            for(double var10 = (double)var2 / (double)var1; var8 < var9; ++var8) {
               double var12 = 3.141592653589793D * ((double)var8 - var6);
               double var14 = var10;
               if(var12 < -1.0E-4D || var12 > 1.0E-4D) {
                  var14 = var10 * (Math.sin(var12) / var12);
               }

               var14 *= 0.54D + 0.46D * Math.cos(((double)var8 - var6) * 0.2243994752564138D);
               var5[var8] = (int)Math.floor(65536.0D * var14 + 0.5D);
            }
         }

      }
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "2140481558"
   )
   int method1648(int var1) {
      if(this.field1419 != null) {
         var1 = (int)((long)var1 * (long)this.field1427 / (long)this.field1422) + 6;
      }

      return var1;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Lclass125;II)Z",
      garbageValue = "294558071"
   )
   static boolean method1651(class125 var0, int var1) {
      int var2 = var0.method2807(2);
      int var3;
      int var4;
      int var7;
      int var8;
      int var9;
      int var10;
      if(var2 == 0) {
         if(var0.method2807(1) != 0) {
            method1651(var0, var1);
         }

         var3 = var0.method2807(6);
         var4 = var0.method2807(6);
         boolean var12 = var0.method2807(1) == 1;
         if(var12) {
            class34.field767[++class34.field779 - 1] = var1;
         }

         if(null != Client.cachedPlayers[var1]) {
            throw new RuntimeException();
         } else {
            Player var11 = Client.cachedPlayers[var1] = new Player();
            var11.field51 = var1;
            if(class34.field771[var1] != null) {
               var11.method11(class34.field771[var1]);
            }

            var11.field876 = class34.field772[var1];
            var11.interacting = class34.field778[var1];
            var7 = class34.field776[var1];
            var8 = var7 >> 28;
            var9 = var7 >> 14 & 255;
            var10 = var7 & 255;
            var11.field882[0] = class34.field770[var1];
            var11.field55 = (byte)var8;
            var11.method10((var9 << 6) + var3 - class47.baseX, (var10 << 6) + var4 - class21.baseY);
            var11.field52 = false;
            return true;
         }
      } else if(var2 == 1) {
         var3 = var0.method2807(2);
         var4 = class34.field776[var1];
         class34.field776[var1] = (((var4 >> 28) + var3 & 3) << 28) + (var4 & 268435455);
         return false;
      } else {
         int var5;
         int var6;
         if(var2 == 2) {
            var3 = var0.method2807(5);
            var4 = var3 >> 3;
            var5 = var3 & 7;
            var6 = class34.field776[var1];
            var7 = var4 + (var6 >> 28) & 3;
            var8 = var6 >> 14 & 255;
            var9 = var6 & 255;
            if(var5 == 0) {
               --var8;
               --var9;
            }

            if(var5 == 1) {
               --var9;
            }

            if(var5 == 2) {
               ++var8;
               --var9;
            }

            if(var5 == 3) {
               --var8;
            }

            if(var5 == 4) {
               ++var8;
            }

            if(var5 == 5) {
               --var8;
               ++var9;
            }

            if(var5 == 6) {
               ++var9;
            }

            if(var5 == 7) {
               ++var8;
               ++var9;
            }

            class34.field776[var1] = var9 + (var7 << 28) + (var8 << 14);
            return false;
         } else {
            var3 = var0.method2807(18);
            var4 = var3 >> 16;
            var5 = var3 >> 8 & 255;
            var6 = var3 & 255;
            var7 = class34.field776[var1];
            var8 = var4 + (var7 >> 28) & 3;
            var9 = var5 + (var7 >> 14) & 255;
            var10 = var7 + var6 & 255;
            class34.field776[var1] = (var8 << 28) + (var9 << 14) + var10;
            return false;
         }
      }
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "([BI)[B",
      garbageValue = "391610389"
   )
   byte[] method1653(byte[] var1) {
      if(null != this.field1419) {
         int var2 = (int)((long)this.field1427 * (long)var1.length / (long)this.field1422) + 14;
         int[] var3 = new int[var2];
         int var4 = 0;
         int var5 = 0;

         int var6;
         for(var6 = 0; var6 < var1.length; ++var6) {
            byte var7 = var1[var6];
            int[] var8 = this.field1419[var5];

            int var9;
            for(var9 = 0; var9 < 14; ++var9) {
               var3[var4 + var9] += var7 * var8[var9];
            }

            var5 += this.field1427;
            var9 = var5 / this.field1422;
            var4 += var9;
            var5 -= var9 * this.field1422;
         }

         var1 = new byte[var2];

         for(var6 = 0; var6 < var2; ++var6) {
            int var10 = var3[var6] + '耀' >> 16;
            if(var10 < -128) {
               var1[var6] = -128;
            } else if(var10 > 127) {
               var1[var6] = 127;
            } else {
               var1[var6] = (byte)var10;
            }
         }
      }

      return var1;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "([Lclass115;II)Lclass115;",
      garbageValue = "-2129653262"
   )
   public static class115 method1656(class115[] var0, int var1) {
      class115[] var2 = var0;

      for(int var3 = 0; var3 < var2.length; ++var3) {
         class115 var4 = var2[var3];
         if(var1 == var4.vmethod3197()) {
            return var4;
         }
      }

      return null;
   }

   @ObfuscatedName("bn")
   @ObfuscatedSignature(
      signature = "(IIIB)V",
      garbageValue = "47"
   )
   static final void method1658(int var0, int var1, int var2) {
      if(var0 >= 128 && var1 >= 128 && var0 <= 13056 && var1 <= 13056) {
         int var3 = class109.method2439(var0, var1, class145.plane) - var2;
         var0 -= class79.cameraX;
         var3 -= class10.cameraZ;
         var1 -= class170.cameraY;
         int var4 = class94.field1650[class116.cameraPitch];
         int var5 = class94.field1651[class116.cameraPitch];
         int var6 = class94.field1650[SecondaryBufferProvider.cameraYaw];
         int var7 = class94.field1651[SecondaryBufferProvider.cameraYaw];
         int var8 = var1 * var6 + var0 * var7 >> 16;
         var1 = var7 * var1 - var0 * var6 >> 16;
         var0 = var8;
         var8 = var5 * var3 - var1 * var4 >> 16;
         var1 = var5 * var1 + var3 * var4 >> 16;
         if(var1 >= 50) {
            Client.field387 = Client.camera2 / 2 + var0 * Client.scale / var1;
            Client.field333 = Client.scale * var8 / var1 + Client.camera3 / 2;
         } else {
            Client.field387 = -1;
            Client.field333 = -1;
         }

      } else {
         Client.field387 = -1;
         Client.field333 = -1;
      }
   }
}
