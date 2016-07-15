import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("du")
public abstract class class128 {
   @ObfuscatedName("l")
   static boolean field2092 = false;

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "([BI)V",
      garbageValue = "-663862977"
   )
   abstract void vmethod2905(byte[] var1);

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)[B",
      garbageValue = "1238789013"
   )
   abstract byte[] vmethod2906();

   @ObfuscatedName("ao")
   @ObfuscatedSignature(
      signature = "(Lclass39;II)V",
      garbageValue = "351742163"
   )
   static final void method2916(class39 var0, int var1) {
      if(var0.field883 > client.field567) {
         int var2 = var0.field883 - client.field567;
         int var3 = var0.field892 * 128 + var0.field851 * 64;
         int var4 = var0.field894 * 128 + var0.field851 * 64;
         var0.field896 += (var3 - var0.field896) / var2;
         var0.field879 += (var4 - var0.field879) / var2;
         var0.field908 = 0;
         var0.field889 = var0.field862;
      } else if(var0.field859 >= client.field567) {
         class19.method206(var0);
      } else {
         class155.method3237(var0);
      }

      if(var0.field896 < 128 || var0.field879 < 128 || var0.field896 >= 13184 || var0.field879 >= 13184) {
         var0.field890 = -1;
         var0.field887 = -1;
         var0.field883 = 0;
         var0.field859 = 0;
         var0.field896 = var0.field851 * 64 + 128 * var0.field885[0];
         var0.field879 = var0.field851 * 64 + var0.field906[0] * 128;
         var0.method792();
      }

      if(var0 == class118.field2035 && (var0.field896 < 1536 || var0.field879 < 1536 || var0.field896 >= 11776 || var0.field879 >= 11776)) {
         var0.field890 = -1;
         var0.field887 = -1;
         var0.field883 = 0;
         var0.field859 = 0;
         var0.field896 = 128 * var0.field885[0] + var0.field851 * 64;
         var0.field879 = var0.field851 * 64 + 128 * var0.field906[0];
         var0.method792();
      }

      class12.method146(var0);
      class157.method3257(var0);
   }

   @ObfuscatedName("ai")
   @ObfuscatedSignature(
      signature = "(IIIIB)V",
      garbageValue = "-110"
   )
   static final void method2917(int var0, int var1, int var2, int var3) {
      ++client.field400;
      class176.method3534(class35.field823);
      boolean var4 = false;
      int var5;
      int var7;
      if(client.field425 >= 0) {
         var5 = class34.field804;
         int[] var6 = class34.field807;

         for(var7 = 0; var7 < var5; ++var7) {
            if(client.field425 == var6[var7]) {
               var4 = true;
               break;
            }
         }
      }

      if(var4) {
         class176.method3534(class35.field820);
      }

      class97.method2261(true);
      class176.method3534(var4?class35.field819:class35.field821);
      class97.method2261(false);
      class18.method172();
      class5.method71();
      class134.method2959(var0, var1, var2, var3, true);
      var0 = client.field557;
      var1 = client.field572;
      var2 = client.field559;
      var3 = client.field562;
      class82.method1934(var0, var1, var0 + var2, var3 + var1);
      class94.method2184();
      int var16;
      if(!client.field543) {
         var5 = client.field379;
         if(client.field563 / 256 > var5) {
            var5 = client.field563 / 256;
         }

         if(client.field544[4] && client.field546[4] + 128 > var5) {
            var5 = client.field546[4] + 128;
         }

         var16 = client.field514 + client.field362 & 2047;
         class41.method835(class6.field123, class105.method2370(class118.field2035.field896, class118.field2035.field879, class50.field1119) - client.field385, class9.field175, var5, var16, 600 + 3 * var5);
      }

      if(!client.field543) {
         var5 = class156.method3243();
      } else {
         if(client.field571.field153) {
            var16 = class50.field1119;
         } else {
            var7 = class105.method2370(class85.field1500, class157.field2342, class50.field1119);
            if(var7 - class41.field955 < 800 && (class5.field89[class50.field1119][class85.field1500 >> 7][class157.field2342 >> 7] & 4) != 0) {
               var16 = class50.field1119;
            } else {
               var16 = 3;
            }
         }

         var5 = var16;
      }

      var16 = class85.field1500;
      var7 = class41.field955;
      int var8 = class157.field2342;
      int var9 = class98.field1694;
      int var10 = class99.field1703;

      int var11;
      int var12;
      for(var11 = 0; var11 < 5; ++var11) {
         if(client.field544[var11]) {
            var12 = (int)(Math.random() * (double)(2 * client.field545[var11] + 1) - (double)client.field545[var11] + Math.sin((double)client.field380[var11] * ((double)client.field566[var11] / 100.0D)) * (double)client.field546[var11]);
            if(var11 == 0) {
               class85.field1500 += var12;
            }

            if(var11 == 1) {
               class41.field955 += var12;
            }

            if(var11 == 2) {
               class157.field2342 += var12;
            }

            if(var11 == 3) {
               class99.field1703 = var12 + class99.field1703 & 2047;
            }

            if(var11 == 4) {
               class98.field1694 += var12;
               if(class98.field1694 < 128) {
                  class98.field1694 = 128;
               }

               if(class98.field1694 > 383) {
                  class98.field1694 = 383;
               }
            }
         }
      }

      var11 = class143.field2198;
      var12 = class143.field2201;
      if(class143.field2208 != 0) {
         var11 = class143.field2207;
         var12 = class143.field2213;
      }

      if(var11 >= var0 && var11 < var2 + var0 && var12 >= var1 && var12 < var1 + var3) {
         class108.field1913 = true;
         class108.field1932 = 0;
         class108.field1930 = var11 - var0;
         class108.field1931 = var12 - var1;
      } else {
         class108.field1913 = false;
         class108.field1932 = 0;
      }

      class110.method2469();
      class82.method1911(var0, var1, var2, var3, 0);
      class110.method2469();
      int var13 = class94.field1641;
      class94.field1641 = client.field561;
      class79.field1453.method2047(class85.field1500, class41.field955, class157.field2342, class98.field1694, class99.field1703, var5);
      class94.field1641 = var13;
      class110.method2469();
      class79.field1453.method2044();
      class44.method960(var0, var1, var2, var3);
      if(client.field294 == 2) {
         class157.method3254(client.field317 + (client.field314 - class19.field286 << 7), client.field318 + (client.field341 - class6.field128 << 7), client.field316 * 2);
         if(client.field401 > -1 && client.field567 % 20 < 10) {
            class184.field2977[0].method1873(client.field401 + var0 - 12, var1 + client.field322 - 28);
         }
      }

      ((class98)class94.field1646).method2278(client.field485);
      if(client.field406 == 1) {
         class34.field811[client.field405 / 100].method1873(client.field491 - 8, client.field547 - 8);
      }

      if(client.field406 == 2) {
         class34.field811[client.field405 / 100 + 4].method1873(client.field491 - 8, client.field547 - 8);
      }

      class112.method2509();
      class85.field1500 = var16;
      class41.field955 = var7;
      class157.field2342 = var8;
      class98.field1694 = var9;
      class99.field1703 = var10;
      if(client.field302) {
         byte var15 = 0;
         int var17 = var15 + class174.field2762 + class174.field2761;
         if(var17 == 0) {
            client.field302 = false;
         }
      }

      if(client.field302) {
         class82.method1911(var0, var1, var2, var3, 0);
         class96.method2260("Loading - please wait.", false);
      }

   }
}
