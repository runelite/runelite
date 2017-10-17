import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dy")
public class class114 {
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Lfu;"
   )
   @Export("timer")
   static Timer timer;
   @ObfuscatedName("s")
   int[][] field1673;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -230833531
   )
   int field1669;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -501138665
   )
   int field1672;

   public class114(int var1, int var2) {
      if(var2 != var1) {
         int var3 = class47.method719(var1, var2);
         var1 /= var3;
         var2 /= var3;
         this.field1672 = var1;
         this.field1669 = var2;
         this.field1673 = new int[var1][14];

         for(int var4 = 0; var4 < var1; ++var4) {
            int[] var5 = this.field1673[var4];
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
               double var12 = ((double)var8 - var6) * 3.141592653589793D;
               double var14 = var10;
               if(var12 < -1.0E-4D || var12 > 1.0E-4D) {
                  var14 = var10 * (Math.sin(var12) / var12);
               }

               var14 *= 0.54D + 0.46D * Math.cos(((double)var8 - var6) * 0.2243994752564138D);
               var5[var8] = (int)Math.floor(0.5D + 65536.0D * var14);
            }
         }

      }
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "([BI)[B",
      garbageValue = "1115169895"
   )
   byte[] method2185(byte[] var1) {
      if(this.field1673 != null) {
         int var2 = (int)((long)this.field1669 * (long)var1.length / (long)this.field1672) + 14;
         int[] var3 = new int[var2];
         int var4 = 0;
         int var5 = 0;

         int var6;
         for(var6 = 0; var6 < var1.length; ++var6) {
            byte var7 = var1[var6];
            int[] var8 = this.field1673[var5];

            int var9;
            for(var9 = 0; var9 < 14; ++var9) {
               var3[var9 + var4] += var7 * var8[var9];
            }

            var5 += this.field1669;
            var9 = var5 / this.field1672;
            var4 += var9;
            var5 -= var9 * this.field1672;
         }

         var1 = new byte[var2];

         for(var6 = 0; var6 < var2; ++var6) {
            int var10 = var3[var6] + 32768 >> 16;
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
      signature = "(IB)I",
      garbageValue = "-4"
   )
   int method2186(int var1) {
      if(this.field1673 != null) {
         var1 = (int)((long)var1 * (long)this.field1669 / (long)this.field1672);
      }

      return var1;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "-569296126"
   )
   int method2194(int var1) {
      if(this.field1673 != null) {
         var1 = (int)((long)this.field1669 * (long)var1 / (long)this.field1672) + 6;
      }

      return var1;
   }
}
