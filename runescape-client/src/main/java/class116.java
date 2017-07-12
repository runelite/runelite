import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("da")
public class class116 {
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 930050307
   )
   int field1692;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -1432717501
   )
   int field1695;
   @ObfuscatedName("r")
   int[][] field1696;

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "-522632720"
   )
   int method2111(int var1) {
      if(this.field1696 != null) {
         var1 = (int)((long)var1 * (long)this.field1692 / (long)this.field1695) + 6;
      }

      return var1;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "138890490"
   )
   int method2113(int var1) {
      if(this.field1696 != null) {
         var1 = (int)((long)var1 * (long)this.field1692 / (long)this.field1695);
      }

      return var1;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "([BI)[B",
      garbageValue = "-113472209"
   )
   byte[] method2115(byte[] var1) {
      if(this.field1696 != null) {
         int var2 = (int)((long)this.field1692 * (long)var1.length / (long)this.field1695) + 14;
         int[] var3 = new int[var2];
         int var4 = 0;
         int var5 = 0;

         int var6;
         for(var6 = 0; var6 < var1.length; ++var6) {
            byte var7 = var1[var6];
            int[] var8 = this.field1696[var5];

            int var9;
            for(var9 = 0; var9 < 14; ++var9) {
               var3[var9 + var4] += var8[var9] * var7;
            }

            var5 += this.field1692;
            var9 = var5 / this.field1695;
            var4 += var9;
            var5 -= this.field1695 * var9;
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

   public class116(int var1, int var2) {
      if(var2 != var1) {
         int var3 = var1;
         int var4 = var2;
         if(var2 > var1) {
            var3 = var2;
            var4 = var1;
         }

         int var5;
         while(var4 != 0) {
            var5 = var3 % var4;
            var3 = var4;
            var4 = var5;
         }

         var1 /= var3;
         var2 /= var3;
         this.field1695 = var1;
         this.field1692 = var2;
         this.field1696 = new int[var1][14];

         for(var5 = 0; var5 < var1; ++var5) {
            int[] var6 = this.field1696[var5];
            double var7 = 6.0D + (double)var5 / (double)var1;
            int var9 = (int)Math.floor(1.0D + (var7 - 7.0D));
            if(var9 < 0) {
               var9 = 0;
            }

            int var10 = (int)Math.ceil(var7 + 7.0D);
            if(var10 > 14) {
               var10 = 14;
            }

            for(double var11 = (double)var2 / (double)var1; var9 < var10; ++var9) {
               double var13 = ((double)var9 - var7) * 3.141592653589793D;
               double var15 = var11;
               if(var13 < -1.0E-4D || var13 > 1.0E-4D) {
                  var15 = var11 * (Math.sin(var13) / var13);
               }

               var15 *= 0.54D + 0.46D * Math.cos(0.2243994752564138D * ((double)var9 - var7));
               var6[var9] = (int)Math.floor(0.5D + 65536.0D * var15);
            }
         }
      }

   }
}
