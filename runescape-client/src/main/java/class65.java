import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bn")
public class class65 {
   @ObfuscatedName("n")
   int[][] field1107;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -692468071
   )
   int field1108;
   @ObfuscatedName("a")
   @Export("overlayRotations")
   static byte[][][] overlayRotations;
   @ObfuscatedName("bk")
   static class184 field1111;
   @ObfuscatedName("qg")
   @ObfuscatedGetter(
      intValue = -746510389
   )
   static int field1112;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -415626267
   )
   int field1114;

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
         this.field1114 = var1;
         this.field1108 = var2;
         this.field1107 = new int[var1][14];

         for(int var7 = 0; var7 < var1; ++var7) {
            int[] var8 = this.field1107[var7];
            double var9 = (double)var7 / (double)var1 + 6.0D;
            int var11 = (int)Math.floor(var9 - 7.0D + 1.0D);
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

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(IS)I",
      garbageValue = "1170"
   )
   int method1145(int var1) {
      if(this.field1107 != null) {
         var1 = (int)((long)this.field1108 * (long)var1 / (long)this.field1114);
      }

      return var1;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(IB)I",
      garbageValue = "8"
   )
   int method1146(int var1) {
      if(this.field1107 != null) {
         var1 = (int)((long)this.field1108 * (long)var1 / (long)this.field1114) + 6;
      }

      return var1;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "([BI)[B",
      garbageValue = "-795230039"
   )
   byte[] method1150(byte[] var1) {
      if(this.field1107 != null) {
         int var2 = (int)((long)var1.length * (long)this.field1108 / (long)this.field1114) + 14;
         int[] var3 = new int[var2];
         int var4 = 0;
         int var5 = 0;

         int var6;
         for(var6 = 0; var6 < var1.length; ++var6) {
            byte var7 = var1[var6];
            int[] var8 = this.field1107[var5];

            int var9;
            for(var9 = 0; var9 < 14; ++var9) {
               var3[var9 + var4] += var7 * var8[var9];
            }

            var5 += this.field1108;
            var9 = var5 / this.field1114;
            var4 += var9;
            var5 -= this.field1114 * var9;
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

   @ObfuscatedName("ch")
   @ObfuscatedSignature(
      signature = "(III)Ljava/lang/String;",
      garbageValue = "-1642093837"
   )
   static final String method1154(int var0, int var1) {
      int var2 = var1 - var0;
      return var2 < -9?class155.method2949(16711680):(var2 < -6?class155.method2949(16723968):(var2 < -3?class155.method2949(16740352):(var2 < 0?class155.method2949(16756736):(var2 > 9?class155.method2949('\uff00'):(var2 > 6?class155.method2949(4259584):(var2 > 3?class155.method2949(8453888):(var2 > 0?class155.method2949(12648192):class155.method2949(16776960))))))));
   }
}
