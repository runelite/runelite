import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("du")
public class class115 {
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 725426845
   )
   int field1592;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -1385358171
   )
   int field1595;
   @ObfuscatedName("f")
   int[][] field1593;

   public class115(int var1, int var2) {
      if(var2 != var1) {
         int var3 = MouseInput.method963(var1, var2);
         var1 /= var3;
         var2 /= var3;
         this.field1592 = var1;
         this.field1595 = var2;
         this.field1593 = new int[var1][14];

         for(int var4 = 0; var4 < var1; ++var4) {
            int[] var5 = this.field1593[var4];
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
               double var12 = 3.141592653589793D * ((double)var8 - var6);
               double var14 = var10;
               if(var12 < -1.0E-4D || var12 > 1.0E-4D) {
                  var14 = var10 * (Math.sin(var12) / var12);
               }

               var14 *= 0.54D + 0.46D * Math.cos(((double)var8 - var6) * 0.2243994752564138D);
               var5[var8] = (int)Math.floor(65536.0D * var14 + 0.5D);
            }
         }

      }
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "([BB)[B",
      garbageValue = "64"
   )
   byte[] method2121(byte[] var1) {
      if(this.field1593 != null) {
         int var2 = (int)((long)this.field1595 * (long)var1.length / (long)this.field1592) + 14;
         int[] var3 = new int[var2];
         int var4 = 0;
         int var5 = 0;

         int var6;
         for(var6 = 0; var6 < var1.length; ++var6) {
            byte var7 = var1[var6];
            int[] var8 = this.field1593[var5];

            int var9;
            for(var9 = 0; var9 < 14; ++var9) {
               var3[var4 + var9] += var7 * var8[var9];
            }

            var5 += this.field1595;
            var9 = var5 / this.field1592;
            var4 += var9;
            var5 -= var9 * this.field1592;
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

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "1287386688"
   )
   int method2119(int var1) {
      if(this.field1593 != null) {
         var1 = (int)((long)var1 * (long)this.field1595 / (long)this.field1592);
      }

      return var1;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "1840619080"
   )
   int method2120(int var1) {
      if(this.field1593 != null) {
         var1 = (int)((long)this.field1595 * (long)var1 / (long)this.field1592) + 6;
      }

      return var1;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(ILcx;ZI)I",
      garbageValue = "1151816711"
   )
   static int method2126(int var0, Script var1, boolean var2) {
      Widget var3;
      if(var0 >= 2000) {
         var0 -= 1000;
         var3 = class64.method1017(class82.intStack[--class82.intStackSize]);
      } else {
         var3 = var2?class234.field3210:class82.field1253;
      }

      if(var0 == 1927) {
         if(class82.field1266 >= 10) {
            throw new RuntimeException();
         } else if(var3.field2822 == null) {
            return 0;
         } else {
            ScriptEvent var4 = new ScriptEvent();
            var4.widget = var3;
            var4.field785 = var3.field2822;
            var4.field779 = class82.field1266 + 1;
            Client.field862.addFront(var4);
            return 1;
         }
      } else {
         return 2;
      }
   }
}
