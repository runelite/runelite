import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bu")
public class class65 {
   @ObfuscatedName("r")
   int[][] field1097;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -998239475
   )
   int field1098;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -1728030457
   )
   int field1100;
   @ObfuscatedName("qc")
   @ObfuscatedGetter(
      intValue = 2003025007
   )
   protected static int field1103;
   @ObfuscatedName("s")
   static String[] field1105;

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(IB)I",
      garbageValue = "37"
   )
   int method1157(int var1) {
      if(this.field1097 != null) {
         var1 = (int)((long)this.field1100 * (long)var1 / (long)this.field1098) + 6;
      }

      return var1;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "([BI)[B",
      garbageValue = "1848038553"
   )
   byte[] method1158(byte[] var1) {
      if(null != this.field1097) {
         int var2 = 14 + (int)((long)this.field1100 * (long)var1.length / (long)this.field1098);
         int[] var3 = new int[var2];
         int var4 = 0;
         int var5 = 0;

         int var6;
         for(var6 = 0; var6 < var1.length; ++var6) {
            byte var7 = var1[var6];
            int[] var8 = this.field1097[var5];

            int var9;
            for(var9 = 0; var9 < 14; ++var9) {
               var3[var4 + var9] += var8[var9] * var7;
            }

            var5 += this.field1100;
            var9 = var5 / this.field1098;
            var4 += var9;
            var5 -= this.field1098 * var9;
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

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "-1053150338"
   )
   int method1159(int var1) {
      if(this.field1097 != null) {
         var1 = (int)((long)this.field1100 * (long)var1 / (long)this.field1098);
      }

      return var1;
   }

   @ObfuscatedName("ai")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1484734908"
   )
   static final void method1165() {
      int var0 = class45.field897;
      int[] var1 = class45.field902;

      for(int var2 = 0; var2 < var0; ++var2) {
         Player var3 = Client.cachedPlayers[var1[var2]];
         if(null != var3) {
            class103.method1995(var3, 1);
         }
      }

   }

   public class65(int var1, int var2) {
      if(var1 != var2) {
         int var3 = class114.method2247(var1, var2);
         var1 /= var3;
         var2 /= var3;
         this.field1098 = var1;
         this.field1100 = var2;
         this.field1097 = new int[var1][14];

         for(int var4 = 0; var4 < var1; ++var4) {
            int[] var5 = this.field1097[var4];
            double var6 = (double)var4 / (double)var1 + 6.0D;
            int var8 = (int)Math.floor(var6 - 7.0D + 1.0D);
            if(var8 < 0) {
               var8 = 0;
            }

            int var9 = (int)Math.ceil(var6 + 7.0D);
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
               var5[var8] = (int)Math.floor(var14 * 65536.0D + 0.5D);
            }
         }

      }
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(I)[Lclass177;",
      garbageValue = "-2112033429"
   )
   public static class177[] method1170() {
      return new class177[]{class177.field2679, class177.field2670, class177.field2672, class177.field2678, class177.field2671, class177.field2675};
   }
}
