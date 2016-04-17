import java.net.URL;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bw")
public class class74 {
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -1217961481
   )
   int field1373;
   @ObfuscatedName("k")
   int[][] field1374;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 1057601121
   )
   int field1377;

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "21"
   )
   static boolean method1690() {
      try {
         if(class25.field645 == null) {
            class25.field645 = new class18(class107.field1874, new URL(class33.field776));
         } else {
            byte[] var0 = class25.field645.method223();
            if(null != var0) {
               class119 var1 = new class119(var0);
               class25.field650 = var1.method2615();
               class129.field2051 = new class25[class25.field650];

               class25 var3;
               for(int var2 = 0; var2 < class25.field650; var3.field638 = var2++) {
                  var3 = class129.field2051[var2] = new class25();
                  var3.field646 = var1.method2615();
                  var3.field647 = var1.method2618();
                  var3.field655 = var1.method2621();
                  var3.field649 = var1.method2621();
                  var3.field651 = var1.method2613();
                  var3.field648 = var1.method2664();
               }

               class34.method817(class129.field2051, 0, class129.field2051.length - 1, class25.field652, class25.field643);
               class25.field645 = null;
               return true;
            }
         }
      } catch (Exception var4) {
         var4.printStackTrace();
         class25.field645 = null;
      }

      return false;
   }

   public class74(int var1, int var2) {
      if(var2 != var1) {
         int var4 = var1;
         int var5 = var2;
         if(var2 > var1) {
            var4 = var2;
            var5 = var1;
         }

         while(var5 != 0) {
            int var6 = var4 % var5;
            var4 = var5;
            var5 = var6;
         }

         var1 /= var4;
         var2 /= var4;
         this.field1373 = var1;
         this.field1377 = var2;
         this.field1374 = new int[var1][14];

         for(int var7 = 0; var7 < var1; ++var7) {
            int[] var8 = this.field1374[var7];
            double var9 = (double)var7 / (double)var1 + 6.0D;
            int var11 = (int)Math.floor(var9 - 7.0D + 1.0D);
            if(var11 < 0) {
               var11 = 0;
            }

            int var12 = (int)Math.ceil(var9 + 7.0D);
            if(var12 > 14) {
               var12 = 14;
            }

            for(double var13 = (double)var2 / (double)var1; var11 < var12; ++var11) {
               double var15 = ((double)var11 - var9) * 3.141592653589793D;
               double var17 = var13;
               if(var15 < -1.0E-4D || var15 > 1.0E-4D) {
                  var17 = var13 * (Math.sin(var15) / var15);
               }

               var17 *= 0.54D + 0.46D * Math.cos(0.2243994752564138D * ((double)var11 - var9));
               var8[var11] = (int)Math.floor(0.5D + 65536.0D * var17);
            }
         }

      }
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "-294974772"
   )
   int method1691(int var1) {
      if(this.field1374 != null) {
         var1 = (int)((long)var1 * (long)this.field1377 / (long)this.field1373);
      }

      return var1;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(IB)I",
      garbageValue = "-62"
   )
   int method1692(int var1) {
      if(null != this.field1374) {
         var1 = (int)((long)this.field1377 * (long)var1 / (long)this.field1373) + 6;
      }

      return var1;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(I)Lclass80;",
      garbageValue = "-361344104"
   )
   static class80 method1700() {
      class80 var0 = new class80();
      var0.field1425 = class76.field1385;
      var0.field1426 = class103.field1773;
      var0.field1421 = class76.field1389[0];
      var0.field1424 = class76.field1387[0];
      var0.field1419 = class126.field2042[0];
      var0.field1420 = class77.field1397[0];
      var0.field1423 = class8.field153;
      var0.field1422 = class76.field1388[0];
      class15.method203();
      return var0;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "([BS)[B",
      garbageValue = "191"
   )
   byte[] method1701(byte[] var1) {
      if(null != this.field1374) {
         int var2 = 14 + (int)((long)var1.length * (long)this.field1377 / (long)this.field1373);
         int[] var3 = new int[var2];
         int var4 = 0;
         int var5 = 0;

         int var6;
         for(var6 = 0; var6 < var1.length; ++var6) {
            byte var7 = var1[var6];
            int[] var8 = this.field1374[var5];

            int var9;
            for(var9 = 0; var9 < 14; ++var9) {
               var3[var4 + var9] += var7 * var8[var9];
            }

            var5 += this.field1377;
            var9 = var5 / this.field1373;
            var4 += var9;
            var5 -= var9 * this.field1373;
         }

         var1 = new byte[var2];

         for(var6 = 0; var6 < var2; ++var6) {
            int var10 = '耀' + var3[var6] >> 16;
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

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-403103637"
   )
   public static void method1702(int var0) {
      if(0 != class183.field2967) {
         class183.field2966 = var0;
      } else {
         class183.field2973.method3677(var0);
      }

   }
}
