import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dj")
public class class117 {
   @ObfuscatedName("pq")
   @ObfuscatedGetter(
      intValue = -30496743
   )
   static int field1698;
   @ObfuscatedName("g")
   int[][] field1694;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 1790385607
   )
   int field1693;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -370829021
   )
   int field1691;

   public class117(int var1, int var2) {
      if(var2 != var1) {
         int var3 = CombatInfo1.method1544(var1, var2);
         var1 /= var3;
         var2 /= var3;
         this.field1691 = var1;
         this.field1693 = var2;
         this.field1694 = new int[var1][14];

         for(int var4 = 0; var4 < var1; ++var4) {
            int[] var5 = this.field1694[var4];
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
               var5[var8] = (int)Math.floor(var14 * 65536.0D + 0.5D);
            }
         }

      }
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "([BI)[B",
      garbageValue = "-1554092414"
   )
   byte[] method2137(byte[] var1) {
      if(this.field1694 != null) {
         int var2 = (int)((long)this.field1693 * (long)var1.length / (long)this.field1691) + 14;
         int[] var3 = new int[var2];
         int var4 = 0;
         int var5 = 0;

         int var6;
         for(var6 = 0; var6 < var1.length; ++var6) {
            byte var7 = var1[var6];
            int[] var8 = this.field1694[var5];

            int var9;
            for(var9 = 0; var9 < 14; ++var9) {
               var3[var4 + var9] += var7 * var8[var9];
            }

            var5 += this.field1693;
            var9 = var5 / this.field1691;
            var4 += var9;
            var5 -= var9 * this.field1691;
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
      signature = "(II)I",
      garbageValue = "-506361387"
   )
   int method2129(int var1) {
      if(this.field1694 != null) {
         var1 = (int)((long)var1 * (long)this.field1693 / (long)this.field1691);
      }

      return var1;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(IB)I",
      garbageValue = "-93"
   )
   int method2130(int var1) {
      if(this.field1694 != null) {
         var1 = (int)((long)var1 * (long)this.field1693 / (long)this.field1691) + 6;
      }

      return var1;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-2778040"
   )
   public static void method2138() {
      ObjectComposition.objects.reset();
      ObjectComposition.field3476.reset();
      ObjectComposition.cachedModels.reset();
      ObjectComposition.field3431.reset();
   }
}
