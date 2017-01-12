import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("br")
public class class65 {
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 1794103023
   )
   int field1098;
   @ObfuscatedName("qr")
   @ObfuscatedGetter(
      intValue = 1712261561
   )
   public static int field1099;
   @ObfuscatedName("c")
   int[][] field1100;
   @ObfuscatedName("bv")
   static ModIcon[] field1102;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -1181648487
   )
   int field1105;

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "([BI)[B",
      garbageValue = "-1110945995"
   )
   byte[] method1115(byte[] var1) {
      if(null != this.field1100) {
         int var2 = 14 + (int)((long)var1.length * (long)this.field1098 / (long)this.field1105);
         int[] var3 = new int[var2];
         int var4 = 0;
         int var5 = 0;

         int var6;
         for(var6 = 0; var6 < var1.length; ++var6) {
            byte var7 = var1[var6];
            int[] var8 = this.field1100[var5];

            int var9;
            for(var9 = 0; var9 < 14; ++var9) {
               var3[var4 + var9] += var7 * var8[var9];
            }

            var5 += this.field1098;
            var9 = var5 / this.field1105;
            var4 += var9;
            var5 -= this.field1105 * var9;
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

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "810207063"
   )
   int method1116(int var1) {
      if(null != this.field1100) {
         var1 = (int)((long)var1 * (long)this.field1098 / (long)this.field1105);
      }

      return var1;
   }

   public class65(int var1, int var2) {
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
         this.field1105 = var1;
         this.field1098 = var2;
         this.field1100 = new int[var1][14];

         for(int var7 = 0; var7 < var1; ++var7) {
            int[] var8 = this.field1100[var7];
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

               var17 *= 0.54D + 0.46D * Math.cos(((double)var11 - var9) * 0.2243994752564138D);
               var8[var11] = (int)Math.floor(var17 * 65536.0D + 0.5D);
            }
         }

      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(IS)I",
      garbageValue = "9535"
   )
   int method1117(int var1) {
      if(this.field1100 != null) {
         var1 = (int)((long)this.field1098 * (long)var1 / (long)this.field1105) + 6;
      }

      return var1;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(II)Lclass196;",
      garbageValue = "-502263160"
   )
   public static class196 method1118(int var0) {
      class196 var1 = (class196)class196.field2854.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = class196.field2861.method3272(32, var0);
         var1 = new class196();
         if(var2 != null) {
            var1.method3592(new Buffer(var2));
         }

         class196.field2854.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(II)Lclass194;",
      garbageValue = "-74863735"
   )
   public static class194 method1124(int var0) {
      class194 var1 = (class194)class194.field2834.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = class194.field2836.method3272(14, var0);
         var1 = new class194();
         if(var2 != null) {
            var1.method3540(new Buffer(var2));
         }

         class194.field2834.put(var1, (long)var0);
         return var1;
      }
   }
}
