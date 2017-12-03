import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dz")
public class class115 {
   @ObfuscatedName("t")
   @Export("validInterfaces")
   static boolean[] validInterfaces;
   @ObfuscatedName("r")
   @Export("cacheLocations")
   static String[] cacheLocations;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -151636743
   )
   int field1571;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -581648665
   )
   int field1574;
   @ObfuscatedName("z")
   int[][] field1573;

   public class115(int var1, int var2) {
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
         this.field1571 = var1;
         this.field1574 = var2;
         this.field1573 = new int[var1][14];

         for(int var7 = 0; var7 < var1; ++var7) {
            int[] var8 = this.field1573[var7];
            double var9 = 6.0D + (double)var7 / (double)var1;
            int var11 = (int)Math.floor(1.0D + (var9 - 7.0D));
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

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "([BI)[B",
      garbageValue = "-1948330626"
   )
   byte[] method2097(byte[] var1) {
      if(this.field1573 != null) {
         int var2 = (int)((long)var1.length * (long)this.field1574 / (long)this.field1571) + 14;
         int[] var3 = new int[var2];
         int var4 = 0;
         int var5 = 0;

         int var6;
         for(var6 = 0; var6 < var1.length; ++var6) {
            byte var7 = var1[var6];
            int[] var8 = this.field1573[var5];

            int var9;
            for(var9 = 0; var9 < 14; ++var9) {
               var3[var9 + var4] += var8[var9] * var7;
            }

            var5 += this.field1574;
            var9 = var5 / this.field1571;
            var4 += var9;
            var5 -= var9 * this.field1571;
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

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "2142728636"
   )
   int method2104(int var1) {
      if(this.field1573 != null) {
         var1 = (int)((long)var1 * (long)this.field1574 / (long)this.field1571);
      }

      return var1;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "1610576549"
   )
   int method2099(int var1) {
      if(this.field1573 != null) {
         var1 = (int)((long)this.field1574 * (long)var1 / (long)this.field1571) + 6;
      }

      return var1;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "1996961150"
   )
   static int method2106(int var0) {
      MessageNode var1 = (MessageNode)class96.messages.get((long)var0);
      return var1 == null?-1:(var1.next == class96.field1414.sentinel?-1:((MessageNode)var1.next).id);
   }
}
