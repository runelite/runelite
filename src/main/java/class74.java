import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("bq")
public class class74 {
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -1957766795
   )
   int field1371;
   @ObfuscatedName("y")
   int[][] field1373;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -1544461869
   )
   int field1374;
   @ObfuscatedName("kj")
   static class19 field1375;

   @ObfuscatedName("w")
   byte[] method1587(byte[] var1) {
      if(this.field1373 != null) {
         int var2 = 14 + (int)((long)var1.length * (long)this.field1374 / (long)this.field1371);
         int[] var3 = new int[var2];
         int var4 = 0;
         int var5 = 0;

         int var6;
         for(var6 = 0; var6 < var1.length; ++var6) {
            byte var7 = var1[var6];
            int[] var8 = this.field1373[var5];

            int var9;
            for(var9 = 0; var9 < 14; ++var9) {
               var3[var4 + var9] += var8[var9] * var7;
            }

            var5 += this.field1374;
            var9 = var5 / this.field1371;
            var4 += var9;
            var5 -= var9 * this.field1371;
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

   @ObfuscatedName("x")
   int method1588(int var1) {
      if(this.field1373 != null) {
         var1 = (int)((long)var1 * (long)this.field1374 / (long)this.field1371);
      }

      return var1;
   }

   @ObfuscatedName("t")
   int method1589(int var1) {
      if(null != this.field1373) {
         var1 = 6 + (int)((long)this.field1374 * (long)var1 / (long)this.field1371);
      }

      return var1;
   }

   public class74(int var1, int var2) {
      if(var2 != var1) {
         int var3 = class89.method2075(var1, var2);
         var1 /= var3;
         var2 /= var3;
         this.field1371 = var1;
         this.field1374 = var2;
         this.field1373 = new int[var1][14];

         for(int var4 = 0; var4 < var1; ++var4) {
            int[] var5 = this.field1373[var4];
            double var6 = (double)var4 / (double)var1 + 6.0D;
            int var8 = (int)Math.floor(1.0D + (var6 - 7.0D));
            if(var8 < 0) {
               var8 = 0;
            }

            int var9 = (int)Math.ceil(var6 + 7.0D);
            if(var9 > 14) {
               var9 = 14;
            }

            for(double var10 = (double)var2 / (double)var1; var8 < var9; ++var8) {
               double var12 = 3.141592653589793D * ((double)var8 - var6);
               double var14 = var10;
               if(var12 < -1.0E-4D || var12 > 1.0E-4D) {
                  var14 = var10 * (Math.sin(var12) / var12);
               }

               var14 *= 0.54D + 0.46D * Math.cos(0.2243994752564138D * ((double)var8 - var6));
               var5[var8] = (int)Math.floor(0.5D + 65536.0D * var14);
            }
         }

      }
   }

   @ObfuscatedName("m")
   public static void method1599() {
      class41.field981.method3776();
   }
}
