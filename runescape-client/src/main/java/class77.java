import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bd")
public class class77 {
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 916186757
   )
   int field1432;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 1495203331
   )
   int field1435;
   @ObfuscatedName("bu")
   static class83[] field1436;
   @ObfuscatedName("a")
   int[][] field1437;
   @ObfuscatedName("dr")
   static int[] field1440;

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "([BI)[B",
      garbageValue = "-1102486348"
   )
   byte[] method1685(byte[] var1) {
      if(this.field1437 != null) {
         int var2 = (int)((long)var1.length * (long)this.field1432 / (long)this.field1435) + 14;
         int[] var3 = new int[var2];
         int var4 = 0;
         int var5 = 0;

         int var6;
         for(var6 = 0; var6 < var1.length; ++var6) {
            byte var7 = var1[var6];
            int[] var8 = this.field1437[var5];

            int var9;
            for(var9 = 0; var9 < 14; ++var9) {
               var3[var9 + var4] += var8[var9] * var7;
            }

            var5 += this.field1432;
            var9 = var5 / this.field1435;
            var4 += var9;
            var5 -= this.field1435 * var9;
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

   public class77(int var1, int var2) {
      if(var1 != var2) {
         int var3 = class126.method2896(var1, var2);
         var1 /= var3;
         var2 /= var3;
         this.field1435 = var1;
         this.field1432 = var2;
         this.field1437 = new int[var1][14];

         for(int var4 = 0; var4 < var1; ++var4) {
            int[] var5 = this.field1437[var4];
            double var6 = 6.0D + (double)var4 / (double)var1;
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

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "1358063915"
   )
   int method1686(int var1) {
      if(null != this.field1437) {
         var1 = 6 + (int)((long)this.field1432 * (long)var1 / (long)this.field1435);
      }

      return var1;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(IZZZB)Lclass171;",
      garbageValue = "71"
   )
   static class171 method1690(int var0, boolean var1, boolean var2, boolean var3) {
      class137 var4 = null;
      if(null != class152.field2284) {
         var4 = new class137(var0, class152.field2284, class152.field2286[var0], 1000000);
      }

      return new class171(var4, class26.field669, var0, var1, var2, var3);
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "1079412293"
   )
   int method1691(int var1) {
      if(null != this.field1437) {
         var1 = (int)((long)var1 * (long)this.field1432 / (long)this.field1435);
      }

      return var1;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Lclass170;Lclass170;Lclass170;Lclass170;I)V",
      garbageValue = "-687578615"
   )
   public static void method1693(class170 var0, class170 var1, class170 var2, class170 var3) {
      class176.field2834 = var0;
      class87.field1525 = var1;
      class176.field2918 = var2;
      class56.field1230 = var3;
      class176.field2811 = new class176[class176.field2834.method3416()][];
      class176.field2785 = new boolean[class176.field2834.method3416()];
   }
}
