import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bl")
public class class77 {
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -1169324131
   )
   int field1422;
   @ObfuscatedName("u")
   int[][] field1424;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -273239365
   )
   public static int field1426;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -145448143
   )
   int field1427;
   @ObfuscatedName("qq")
   @ObfuscatedGetter(
      intValue = 1829424793
   )
   protected static int field1428;

   public class77(int var1, int var2) {
      if(var1 != var2) {
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
         this.field1427 = var1;
         this.field1422 = var2;
         this.field1424 = new int[var1][14];

         for(int var7 = 0; var7 < var1; ++var7) {
            int[] var8 = this.field1424[var7];
            double var9 = (double)var7 / (double)var1 + 6.0D;
            int var11 = (int)Math.floor(1.0D + (var9 - 7.0D));
            if(var11 < 0) {
               var11 = 0;
            }

            int var12 = (int)Math.ceil(7.0D + var9);
            if(var12 > 14) {
               var12 = 14;
            }

            for(double var13 = (double)var2 / (double)var1; var11 < var12; ++var11) {
               double var15 = 3.141592653589793D * ((double)var11 - var9);
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

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "([BI)[B",
      garbageValue = "2096779002"
   )
   byte[] method1630(byte[] var1) {
      if(null != this.field1424) {
         int var2 = 14 + (int)((long)var1.length * (long)this.field1422 / (long)this.field1427);
         int[] var3 = new int[var2];
         int var4 = 0;
         int var5 = 0;

         int var6;
         for(var6 = 0; var6 < var1.length; ++var6) {
            byte var7 = var1[var6];
            int[] var8 = this.field1424[var5];

            int var9;
            for(var9 = 0; var9 < 14; ++var9) {
               var3[var4 + var9] += var7 * var8[var9];
            }

            var5 += this.field1422;
            var9 = var5 / this.field1427;
            var4 += var9;
            var5 -= this.field1427 * var9;
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

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(IB)I",
      garbageValue = "106"
   )
   int method1631(int var1) {
      if(this.field1424 != null) {
         var1 = (int)((long)var1 * (long)this.field1422 / (long)this.field1427);
      }

      return var1;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "1607034823"
   )
   int method1632(int var1) {
      if(this.field1424 != null) {
         var1 = (int)((long)this.field1422 * (long)var1 / (long)this.field1427) + 6;
      }

      return var1;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(B)[Lclass85;",
      garbageValue = "94"
   )
   public static class85[] method1637() {
      return new class85[]{class85.field1482, class85.field1484, class85.field1487, class85.field1485, class85.field1486};
   }
}
