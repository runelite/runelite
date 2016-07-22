import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bw")
public class class77 {
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 2112951363
   )
   int field1441;
   @ObfuscatedName("l")
   int[][] field1443;
   @ObfuscatedName("jv")
   @ObfuscatedGetter(
      intValue = 1140830371
   )
   static int field1444;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -1825185875
   )
   int field1449;

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)I",
      garbageValue = "-310811879"
   )
   public static int method1679(String var0) {
      return var0.length() + 1;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "([BB)[B",
      garbageValue = "-88"
   )
   byte[] method1680(byte[] var1) {
      if(this.field1443 != null) {
         int var2 = (int)((long)var1.length * (long)this.field1449 / (long)this.field1441) + 14;
         int[] var3 = new int[var2];
         int var4 = 0;
         int var5 = 0;

         int var6;
         for(var6 = 0; var6 < var1.length; ++var6) {
            byte var7 = var1[var6];
            int[] var8 = this.field1443[var5];

            int var9;
            for(var9 = 0; var9 < 14; ++var9) {
               var3[var9 + var4] += var8[var9] * var7;
            }

            var5 += this.field1449;
            var9 = var5 / this.field1441;
            var4 += var9;
            var5 -= this.field1441 * var9;
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

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "2087326047"
   )
   int method1681(int var1) {
      if(null != this.field1443) {
         var1 = (int)((long)var1 * (long)this.field1449 / (long)this.field1441);
      }

      return var1;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(B)Lclass83;",
      garbageValue = "1"
   )
   public static class83 method1682() {
      class83 var0 = new class83();
      var0.field1496 = class79.field1457;
      var0.field1501 = class79.field1458;
      var0.field1498 = class79.field1459[0];
      var0.field1499 = class79.field1460[0];
      var0.field1500 = class79.field1463[0];
      var0.field1497 = class117.field2021[0];
      var0.field1495 = class79.field1462;
      var0.field1494 = class10.field151[0];
      class18.method191();
      return var0;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "1674265404"
   )
   int method1685(int var1) {
      if(this.field1443 != null) {
         var1 = (int)((long)var1 * (long)this.field1449 / (long)this.field1441) + 6;
      }

      return var1;
   }

   @ObfuscatedName("ca")
   @ObfuscatedSignature(
      signature = "(Lclass176;IIZB)V",
      garbageValue = "-2"
   )
   static void method1689(class176 var0, int var1, int var2, boolean var3) {
      int var4 = var0.field2926;
      int var5 = var0.field2877;
      if(var0.field2802 == 0) {
         var0.field2926 = var0.field2806;
      } else if(var0.field2802 == 1) {
         var0.field2926 = var1 - var0.field2806;
      } else if(var0.field2802 == 2) {
         var0.field2926 = var1 * var0.field2806 >> 14;
      }

      if(var0.field2803 == 0) {
         var0.field2877 = var0.field2915;
      } else if(var0.field2803 == 1) {
         var0.field2877 = var2 - var0.field2915;
      } else if(var0.field2803 == 2) {
         var0.field2877 = var2 * var0.field2915 >> 14;
      }

      if(var0.field2802 == 4) {
         var0.field2926 = var0.field2914 * var0.field2877 / var0.field2918;
      }

      if(var0.field2803 == 4) {
         var0.field2877 = var0.field2926 * var0.field2918 / var0.field2914;
      }

      if(client.field440 && var0.field2929 == 0) {
         if(var0.field2877 < 5 && var0.field2926 < 5) {
            var0.field2877 = 5;
            var0.field2926 = 5;
         } else {
            if(var0.field2877 <= 0) {
               var0.field2877 = 5;
            }

            if(var0.field2926 <= 0) {
               var0.field2926 = 5;
            }
         }
      }

      if(var0.field2799 == 1337) {
         client.field292 = var0;
      }

      if(var3 && null != var0.field2904 && (var0.field2926 != var4 || var5 != var0.field2877)) {
         class0 var6 = new class0();
         var6.field3 = var0;
         var6.field1 = var0.field2904;
         client.field327.method3877(var6);
      }

   }

   public class77(int var1, int var2) {
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
         this.field1441 = var1;
         this.field1449 = var2;
         this.field1443 = new int[var1][14];

         for(int var7 = 0; var7 < var1; ++var7) {
            int[] var8 = this.field1443[var7];
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

               var17 *= 0.54D + 0.46D * Math.cos(0.2243994752564138D * ((double)var11 - var9));
               var8[var11] = (int)Math.floor(var17 * 65536.0D + 0.5D);
            }
         }

      }
   }
}
