import java.awt.Component;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("bz")
public class class74 {
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -2084152337
   )
   int field1337;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 97847835
   )
   int field1338;
   @ObfuscatedName("h")
   int[][] field1339;
   @ObfuscatedName("eg")
   static class78[] field1340;

   @ObfuscatedName("e")
   byte[] method1593(byte[] var1) {
      if(this.field1339 != null) {
         int var2 = (int)((long)this.field1338 * (long)var1.length / (long)this.field1337) + 14;
         int[] var3 = new int[var2];
         int var4 = 0;
         int var5 = 0;

         int var6;
         for(var6 = 0; var6 < var1.length; ++var6) {
            byte var7 = var1[var6];
            int[] var8 = this.field1339[var5];

            int var9;
            for(var9 = 0; var9 < 14; ++var9) {
               var3[var9 + var4] += var7 * var8[var9];
            }

            var5 += this.field1338;
            var9 = var5 / this.field1337;
            var4 += var9;
            var5 -= this.field1337 * var9;
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

   @ObfuscatedName("w")
   int method1595(int var1) {
      if(this.field1339 != null) {
         var1 = (int)((long)var1 * (long)this.field1338 / (long)this.field1337);
      }

      return var1;
   }

   @ObfuscatedName("f")
   int method1596(int var1) {
      if(null != this.field1339) {
         var1 = 6 + (int)((long)this.field1338 * (long)var1 / (long)this.field1337);
      }

      return var1;
   }

   @ObfuscatedName("e")
   public static void method1601(Component var0) {
      var0.addMouseListener(class140.field2142);
      var0.addMouseMotionListener(class140.field2142);
      var0.addFocusListener(class140.field2142);
   }

   public class74(int var1, int var2) {
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
         this.field1337 = var1;
         this.field1338 = var2;
         this.field1339 = new int[var1][14];

         for(int var7 = 0; var7 < var1; ++var7) {
            int[] var8 = this.field1339[var7];
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
               double var15 = ((double)var11 - var9) * 3.141592653589793D;
               double var17 = var13;
               if(var15 < -1.0E-4D || var15 > 1.0E-4D) {
                  var17 = var13 * (Math.sin(var15) / var15);
               }

               var17 *= 0.54D + 0.46D * Math.cos(((double)var11 - var9) * 0.2243994752564138D);
               var8[var11] = (int)Math.floor(0.5D + 65536.0D * var17);
            }
         }

      }
   }
}
