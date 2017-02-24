import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bk")
public class class65 {
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -237260249
   )
   int field1121;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -2107995949
   )
   int field1122;
   @ObfuscatedName("n")
   int[][] field1124;

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "-1235686229"
   )
   int method1219(int var1) {
      if(null != this.field1124) {
         var1 = 6 + (int)((long)this.field1122 * (long)var1 / (long)this.field1121);
      }

      return var1;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "([BB)[B",
      garbageValue = "-128"
   )
   byte[] method1220(byte[] var1) {
      if(this.field1124 != null) {
         int var2 = (int)((long)this.field1122 * (long)var1.length / (long)this.field1121) + 14;
         int[] var3 = new int[var2];
         int var4 = 0;
         int var5 = 0;

         int var6;
         for(var6 = 0; var6 < var1.length; ++var6) {
            byte var7 = var1[var6];
            int[] var8 = this.field1124[var5];

            int var9;
            for(var9 = 0; var9 < 14; ++var9) {
               var3[var4 + var9] += var7 * var8[var9];
            }

            var5 += this.field1122;
            var9 = var5 / this.field1121;
            var4 += var9;
            var5 -= this.field1121 * var9;
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

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(IIII)I",
      garbageValue = "429863418"
   )
   static int method1222(int var0, int var1, int var2) {
      return (class10.tileSettings[var0][var1][var2] & 8) != 0?0:(var0 > 0 && (class10.tileSettings[1][var1][var2] & 2) != 0?var0 - 1:var0);
   }

   public class65(int var1, int var2) {
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
         this.field1121 = var1;
         this.field1122 = var2;
         this.field1124 = new int[var1][14];

         for(int var7 = 0; var7 < var1; ++var7) {
            int[] var8 = this.field1124[var7];
            double var9 = (double)var7 / (double)var1 + 6.0D;
            int var11 = (int)Math.floor(1.0D + (var9 - 7.0D));
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

               var17 *= 0.54D + 0.46D * Math.cos(0.2243994752564138D * ((double)var11 - var9));
               var8[var11] = (int)Math.floor(0.5D + 65536.0D * var17);
            }
         }

      }
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "-1306594267"
   )
   int method1228(int var1) {
      if(null != this.field1124) {
         var1 = (int)((long)var1 * (long)this.field1122 / (long)this.field1121);
      }

      return var1;
   }
}
