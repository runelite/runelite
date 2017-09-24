import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("di")
public class class115 {
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -900012671
   )
   public static int field1694;
   @ObfuscatedName("n")
   int[][] field1693;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 649239673
   )
   int field1692;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -425607287
   )
   int field1689;

   public class115(int var1, int var2) {
      if(var2 != var1) {
         int var3 = Occluder.method2940(var1, var2);
         var1 /= var3;
         var2 /= var3;
         this.field1689 = var1;
         this.field1692 = var2;
         this.field1693 = new int[var1][14];

         for(int var4 = 0; var4 < var1; ++var4) {
            int[] var5 = this.field1693[var4];
            double var6 = 6.0D + (double)var4 / (double)var1;
            int var8 = (int)Math.floor(1.0D + (var6 - 7.0D));
            if(var8 < 0) {
               var8 = 0;
            }

            int var9 = (int)Math.ceil(7.0D + var6);
            if(var9 > 14) {
               var9 = 14;
            }

            for(double var10 = (double)var2 / (double)var1; var8 < var9; ++var8) {
               double var12 = ((double)var8 - var6) * 3.141592653589793D;
               double var14 = var10;
               if(var12 < -1.0E-4D || var12 > 1.0E-4D) {
                  var14 = var10 * (Math.sin(var12) / var12);
               }

               var14 *= 0.54D + 0.46D * Math.cos(0.2243994752564138D * ((double)var8 - var6));
               var5[var8] = (int)Math.floor(0.5D + var14 * 65536.0D);
            }
         }

      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "([BI)[B",
      garbageValue = "1335560639"
   )
   byte[] method2114(byte[] var1) {
      if(this.field1693 != null) {
         int var2 = (int)((long)this.field1692 * (long)var1.length / (long)this.field1689) + 14;
         int[] var3 = new int[var2];
         int var4 = 0;
         int var5 = 0;

         int var6;
         for(var6 = 0; var6 < var1.length; ++var6) {
            byte var7 = var1[var6];
            int[] var8 = this.field1693[var5];

            int var9;
            for(var9 = 0; var9 < 14; ++var9) {
               var3[var9 + var4] += var7 * var8[var9];
            }

            var5 += this.field1692;
            var9 = var5 / this.field1689;
            var4 += var9;
            var5 -= var9 * this.field1689;
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

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "857751"
   )
   int method2124(int var1) {
      if(this.field1693 != null) {
         var1 = (int)((long)this.field1692 * (long)var1 / (long)this.field1689);
      }

      return var1;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(IB)I",
      garbageValue = "0"
   )
   int method2116(int var1) {
      if(this.field1693 != null) {
         var1 = (int)((long)this.field1692 * (long)var1 / (long)this.field1689) + 6;
      }

      return var1;
   }
}
