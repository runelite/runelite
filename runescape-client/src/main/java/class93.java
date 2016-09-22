import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cc")
public class class93 {
   @ObfuscatedName("qw")
   @ObfuscatedGetter(
      intValue = 1375069123
   )
   protected static int field1648;
   @ObfuscatedName("t")
   static byte[][][] field1649;
   @ObfuscatedName("k")
   static ModIcon field1651;

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "-766230042"
   )
   public static boolean method2114(int var0) {
      if(Widget.validInterfaces[var0]) {
         return true;
      } else if(!class153.field2311.method3362(var0)) {
         return false;
      } else {
         int var1 = class153.field2311.method3319(var0);
         if(var1 == 0) {
            Widget.validInterfaces[var0] = true;
            return true;
         } else {
            if(null == Widget.widgets[var0]) {
               Widget.widgets[var0] = new Widget[var1];
            }

            for(int var2 = 0; var2 < var1; ++var2) {
               if(null == Widget.widgets[var0][var2]) {
                  byte[] var3 = class153.field2311.method3309(var0, var2);
                  if(var3 != null) {
                     Widget.widgets[var0][var2] = new Widget();
                     Widget.widgets[var0][var2].id = (var0 << 16) + var2;
                     if(var3[0] == -1) {
                        Widget.widgets[var0][var2].method3437(new Buffer(var3));
                     } else {
                        Widget.widgets[var0][var2].method3436(new Buffer(var3));
                     }
                  }
               }
            }

            Widget.validInterfaces[var0] = true;
            return true;
         }
      }
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(IIB)I",
      garbageValue = "85"
   )
   static final int method2115(int var0, int var1) {
      if(var0 == -1) {
         return 12345678;
      } else {
         var1 = (var0 & 127) * var1 / 128;
         if(var1 < 2) {
            var1 = 2;
         } else if(var1 > 126) {
            var1 = 126;
         }

         return (var0 & 'ﾀ') + var1;
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1983148319"
   )
   static final void method2116(int var0) {
      short var1 = 256;
      class33.field738 += var0 * 128;
      int var2;
      if(class33.field738 > class1.field20.length) {
         class33.field738 -= class1.field20.length;
         var2 = (int)(Math.random() * 12.0D);
         Player.method13(class33.field753[var2]);
      }

      var2 = 0;
      int var3 = 128 * var0;
      int var4 = 128 * (var1 - var0);

      int var5;
      int var6;
      for(var5 = 0; var5 < var4; ++var5) {
         var6 = class9.field149[var3 + var2] - class1.field20[var2 + class33.field738 & class1.field20.length - 1] * var0 / 6;
         if(var6 < 0) {
            var6 = 0;
         }

         class9.field149[var2++] = var6;
      }

      int var7;
      int var8;
      for(var5 = var1 - var0; var5 < var1; ++var5) {
         var6 = 128 * var5;

         for(var7 = 0; var7 < 128; ++var7) {
            var8 = (int)(Math.random() * 100.0D);
            if(var8 < 50 && var7 > 10 && var7 < 118) {
               class9.field149[var7 + var6] = 255;
            } else {
               class9.field149[var6 + var7] = 0;
            }
         }
      }

      if(class33.field744 > 0) {
         class33.field744 -= 4 * var0;
      }

      if(class33.field769 > 0) {
         class33.field769 -= var0 * 4;
      }

      if(class33.field744 == 0 && class33.field769 == 0) {
         var5 = (int)(Math.random() * (double)(2000 / var0));
         if(var5 == 0) {
            class33.field744 = 1024;
         }

         if(var5 == 1) {
            class33.field769 = 1024;
         }
      }

      for(var5 = 0; var5 < var1 - var0; ++var5) {
         class33.field742[var5] = class33.field742[var0 + var5];
      }

      for(var5 = var1 - var0; var5 < var1; ++var5) {
         class33.field742[var5] = (int)(Math.sin((double)class33.field735 / 14.0D) * 16.0D + Math.sin((double)class33.field735 / 15.0D) * 14.0D + Math.sin((double)class33.field735 / 16.0D) * 12.0D);
         ++class33.field735;
      }

      class33.field749 += var0;
      var5 = ((Client.gameCycle & 1) + var0) / 2;
      if(var5 > 0) {
         for(var6 = 0; var6 < class33.field749 * 100; ++var6) {
            var7 = (int)(Math.random() * 124.0D) + 2;
            var8 = (int)(Math.random() * 128.0D) + 128;
            class9.field149[var7 + (var8 << 7)] = 192;
         }

         class33.field749 = 0;

         int var9;
         for(var6 = 0; var6 < var1; ++var6) {
            var7 = 0;
            var8 = var6 * 128;

            for(var9 = -var5; var9 < 128; ++var9) {
               if(var9 + var5 < 128) {
                  var7 += class9.field149[var5 + var9 + var8];
               }

               if(var9 - (var5 + 1) >= 0) {
                  var7 -= class9.field149[var9 + var8 - (1 + var5)];
               }

               if(var9 >= 0) {
                  class138.field2159[var9 + var8] = var7 / (2 * var5 + 1);
               }
            }
         }

         for(var6 = 0; var6 < 128; ++var6) {
            var7 = 0;

            for(var8 = -var5; var8 < var1; ++var8) {
               var9 = 128 * var8;
               if(var8 + var5 < var1) {
                  var7 += class138.field2159[128 * var5 + var6 + var9];
               }

               if(var8 - (1 + var5) >= 0) {
                  var7 -= class138.field2159[var9 + var6 - (var5 + 1) * 128];
               }

               if(var8 >= 0) {
                  class9.field149[var9 + var6] = var7 / (2 * var5 + 1);
               }
            }
         }
      }

   }
}
