import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fd")
public final class class176 {
   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1290852072"
   )
   static final void method3184(int var0) {
      short var1 = 256;
      class41.field838 += var0 * 128;
      int var2;
      if(class41.field838 > XGrandExchangeOffer.field44.length) {
         class41.field838 -= XGrandExchangeOffer.field44.length;
         var2 = (int)(Math.random() * 12.0D);
         class107.method2007(class41.field827[var2]);
      }

      var2 = 0;
      int var3 = var0 * 128;
      int var4 = (var1 - var0) * 128;

      int var5;
      int var6;
      for(var5 = 0; var5 < var4; ++var5) {
         var6 = GameObject.field1613[var2 + var3] - var0 * XGrandExchangeOffer.field44[class41.field838 + var2 & XGrandExchangeOffer.field44.length - 1] / 6;
         if(var6 < 0) {
            var6 = 0;
         }

         GameObject.field1613[var2++] = var6;
      }

      int var7;
      int var8;
      for(var5 = var1 - var0; var5 < var1; ++var5) {
         var6 = 128 * var5;

         for(var7 = 0; var7 < 128; ++var7) {
            var8 = (int)(Math.random() * 100.0D);
            if(var8 < 50 && var7 > 10 && var7 < 118) {
               GameObject.field1613[var6 + var7] = 255;
            } else {
               GameObject.field1613[var6 + var7] = 0;
            }
         }
      }

      if(class41.field836 > 0) {
         class41.field836 -= 4 * var0;
      }

      if(class41.field837 > 0) {
         class41.field837 -= 4 * var0;
      }

      if(class41.field836 == 0 && class41.field837 == 0) {
         var5 = (int)(Math.random() * (double)(2000 / var0));
         if(var5 == 0) {
            class41.field836 = 1024;
         }

         if(var5 == 1) {
            class41.field837 = 1024;
         }
      }

      for(var5 = 0; var5 < var1 - var0; ++var5) {
         class41.field832[var5] = class41.field832[var0 + var5];
      }

      for(var5 = var1 - var0; var5 < var1; ++var5) {
         class41.field832[var5] = (int)(Math.sin((double)class41.field844 / 14.0D) * 16.0D + Math.sin((double)class41.field844 / 15.0D) * 14.0D + Math.sin((double)class41.field844 / 16.0D) * 12.0D);
         ++class41.field844;
      }

      class41.field839 += var0;
      var5 = (var0 + (Client.gameCycle & 1)) / 2;
      if(var5 > 0) {
         for(var6 = 0; var6 < class41.field839 * 100; ++var6) {
            var7 = (int)(Math.random() * 124.0D) + 2;
            var8 = (int)(Math.random() * 128.0D) + 128;
            GameObject.field1613[var7 + (var8 << 7)] = 192;
         }

         class41.field839 = 0;

         int var9;
         for(var6 = 0; var6 < var1; ++var6) {
            var7 = 0;
            var8 = var6 * 128;

            for(var9 = -var5; var9 < 128; ++var9) {
               if(var5 + var9 < 128) {
                  var7 += GameObject.field1613[var9 + var8 + var5];
               }

               if(var9 - (1 + var5) >= 0) {
                  var7 -= GameObject.field1613[var9 + var8 - (1 + var5)];
               }

               if(var9 >= 0) {
                  class119.field1850[var8 + var9] = var7 / (var5 * 2 + 1);
               }
            }
         }

         for(var6 = 0; var6 < 128; ++var6) {
            var7 = 0;

            for(var8 = -var5; var8 < var1; ++var8) {
               var9 = 128 * var8;
               if(var5 + var8 < var1) {
                  var7 += class119.field1850[var6 + var9 + var5 * 128];
               }

               if(var8 - (1 + var5) >= 0) {
                  var7 -= class119.field1850[var9 + var6 - 128 * (1 + var5)];
               }

               if(var8 >= 0) {
                  GameObject.field1613[var6 + var9] = var7 / (1 + var5 * 2);
               }
            }
         }
      }

   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-110179701"
   )
   static void method3185(int var0) {
      if(var0 != -1) {
         if(class212.method3870(var0)) {
            Widget[] var1 = Widget.widgets[var0];

            for(int var2 = 0; var2 < var1.length; ++var2) {
               Widget var3 = var1[var2];
               if(null != var3.field2289) {
                  class18 var4 = new class18();
                  var4.field187 = var3;
                  var4.field188 = var3.field2289;
                  class6.method83(var4, 2000000);
               }
            }

         }
      }
   }
}
