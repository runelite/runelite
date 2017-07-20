import java.util.Date;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dy")
public class class116 {
   @ObfuscatedName("m")
   int[][] field1649;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 1518188239
   )
   int field1648;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 711960205
   )
   int field1644;

   public class116(int var1, int var2) {
      if(var2 != var1) {
         int var3 = BaseVarType.method16(var1, var2);
         var1 /= var3;
         var2 /= var3;
         this.field1644 = var1;
         this.field1648 = var2;
         this.field1649 = new int[var1][14];

         for(int var4 = 0; var4 < var1; ++var4) {
            int[] var5 = this.field1649[var4];
            double var6 = 6.0D + (double)var4 / (double)var1;
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
               var5[var8] = (int)Math.floor(var14 * 65536.0D + 0.5D);
            }
         }

      }
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "([BB)[B",
      garbageValue = "-65"
   )
   byte[] method2043(byte[] var1) {
      if(this.field1649 != null) {
         int var2 = (int)((long)this.field1648 * (long)var1.length / (long)this.field1644) + 14;
         int[] var3 = new int[var2];
         int var4 = 0;
         int var5 = 0;

         int var6;
         for(var6 = 0; var6 < var1.length; ++var6) {
            byte var7 = var1[var6];
            int[] var8 = this.field1649[var5];

            int var9;
            for(var9 = 0; var9 < 14; ++var9) {
               var3[var4 + var9] += var7 * var8[var9];
            }

            var5 += this.field1648;
            var9 = var5 / this.field1644;
            var4 += var9;
            var5 -= var9 * this.field1644;
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

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "2044410605"
   )
   int method2044(int var1) {
      if(this.field1649 != null) {
         var1 = (int)((long)var1 * (long)this.field1648 / (long)this.field1644);
      }

      return var1;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "-2039212899"
   )
   int method2046(int var1) {
      if(this.field1649 != null) {
         var1 = (int)((long)this.field1648 * (long)var1 / (long)this.field1644) + 6;
      }

      return var1;
   }

   @ObfuscatedName("c")
   public static String method2050(long var0) {
      class182.field2410.setTime(new Date(var0));
      int var2 = class182.field2410.get(7);
      int var3 = class182.field2410.get(5);
      int var4 = class182.field2410.get(2);
      int var5 = class182.field2410.get(1);
      int var6 = class182.field2410.get(11);
      int var7 = class182.field2410.get(12);
      int var8 = class182.field2410.get(13);
      return class182.field2408[var2 - 1] + ", " + var3 / 10 + var3 % 10 + "-" + class182.field2409[0][var4] + "-" + var5 + " " + var6 / 10 + var6 % 10 + ":" + var7 / 10 + var7 % 10 + ":" + var8 / 10 + var8 % 10 + " GMT";
   }
}
