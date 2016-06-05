import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ev")
public class class142 {
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 1739338927
   )
   static int field2204;
   @ObfuscatedName("t")
   public static class167 field2206;

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(Lclass122;IB)V",
      garbageValue = "3"
   )
   static void method2957(class122 var0, int var1) {
      boolean var2 = var0.method2713(1) == 1;
      if(var2) {
         class32.field749[++class32.field748 - 1] = var1;
      }

      int var3 = var0.method2713(2);
      class2 var4 = client.field405[var1];
      if(var3 == 0) {
         if(var2) {
            var4.field48 = false;
         } else if(client.field460 == var1) {
            throw new RuntimeException();
         } else {
            class32.field756[var1] = (client.field358 + var4.field839[0] >> 6) + (var4.field57 << 28) + (class89.field1565 + var4.field847[0] >> 6 << 14);
            if(var4.field830 != -1) {
               class32.field747[var1] = var4.field830;
            } else {
               class32.field747[var1] = var4.field831;
            }

            class32.field740[var1] = var4.field828;
            client.field405[var1] = null;
            if(var0.method2713(1) != 0) {
               class114.method2406(var0, var1);
            }

         }
      } else {
         int var5;
         int var6;
         int var7;
         if(var3 == 1) {
            var5 = var0.method2713(3);
            var6 = var4.field847[0];
            var7 = var4.field839[0];
            if(var5 == 0) {
               --var6;
               --var7;
            } else if(var5 == 1) {
               --var7;
            } else if(var5 == 2) {
               ++var6;
               --var7;
            } else if(var5 == 3) {
               --var6;
            } else if(var5 == 4) {
               ++var6;
            } else if(var5 == 5) {
               --var6;
               ++var7;
            } else if(var5 == 6) {
               ++var7;
            } else if(var5 == 7) {
               ++var6;
               ++var7;
            }

            if(client.field460 == var1 && (var4.field809 < 1536 || var4.field804 < 1536 || var4.field809 >= 11776 || var4.field804 >= 11776)) {
               var4.method29(var6, var7);
               var4.field48 = false;
            } else if(var2) {
               var4.field48 = true;
               var4.field44 = var6;
               var4.field61 = var7;
            } else {
               var4.field48 = false;
               var4.method11(var6, var7, class32.field739[var1]);
            }

         } else if(var3 == 2) {
            var5 = var0.method2713(4);
            var6 = var4.field847[0];
            var7 = var4.field839[0];
            if(var5 == 0) {
               var6 -= 2;
               var7 -= 2;
            } else if(var5 == 1) {
               --var6;
               var7 -= 2;
            } else if(var5 == 2) {
               var7 -= 2;
            } else if(var5 == 3) {
               ++var6;
               var7 -= 2;
            } else if(var5 == 4) {
               var6 += 2;
               var7 -= 2;
            } else if(var5 == 5) {
               var6 -= 2;
               --var7;
            } else if(var5 == 6) {
               var6 += 2;
               --var7;
            } else if(var5 == 7) {
               var6 -= 2;
            } else if(var5 == 8) {
               var6 += 2;
            } else if(var5 == 9) {
               var6 -= 2;
               ++var7;
            } else if(var5 == 10) {
               var6 += 2;
               ++var7;
            } else if(var5 == 11) {
               var6 -= 2;
               var7 += 2;
            } else if(var5 == 12) {
               --var6;
               var7 += 2;
            } else if(var5 == 13) {
               var7 += 2;
            } else if(var5 == 14) {
               ++var6;
               var7 += 2;
            } else if(var5 == 15) {
               var6 += 2;
               var7 += 2;
            }

            if(client.field460 != var1 || var4.field809 >= 1536 && var4.field804 >= 1536 && var4.field809 < 11776 && var4.field804 < 11776) {
               if(var2) {
                  var4.field48 = true;
                  var4.field44 = var6;
                  var4.field61 = var7;
               } else {
                  var4.field48 = false;
                  var4.method11(var6, var7, class32.field739[var1]);
               }
            } else {
               var4.method29(var6, var7);
               var4.field48 = false;
            }

         } else {
            var5 = var0.method2713(1);
            int var8;
            int var9;
            int var10;
            int var11;
            if(var5 == 0) {
               var6 = var0.method2713(12);
               var7 = var6 >> 10;
               var8 = var6 >> 5 & 31;
               if(var8 > 15) {
                  var8 -= 32;
               }

               var9 = var6 & 31;
               if(var9 > 15) {
                  var9 -= 32;
               }

               var10 = var4.field847[0] + var8;
               var11 = var4.field839[0] + var9;
               if(client.field460 != var1 || var4.field809 >= 1536 && var4.field804 >= 1536 && var4.field809 < 11776 && var4.field804 < 11776) {
                  if(var2) {
                     var4.field48 = true;
                     var4.field44 = var10;
                     var4.field61 = var11;
                  } else {
                     var4.field48 = false;
                     var4.method11(var10, var11, class32.field739[var1]);
                  }
               } else {
                  var4.method29(var10, var11);
                  var4.field48 = false;
               }

               var4.field57 = (byte)(var7 + var4.field57 & 3);
               if(var1 == client.field460) {
                  class32.field754 = var4.field57;
               }

            } else {
               var6 = var0.method2713(30);
               var7 = var6 >> 28;
               var8 = var6 >> 14 & 16383;
               var9 = var6 & 16383;
               var10 = (var8 + var4.field847[0] + class89.field1565 & 16383) - class89.field1565;
               var11 = (var9 + client.field358 + var4.field839[0] & 16383) - client.field358;
               if(var1 == client.field460 && (var4.field809 < 1536 || var4.field804 < 1536 || var4.field809 >= 11776 || var4.field804 >= 11776)) {
                  var4.method29(var10, var11);
                  var4.field48 = false;
               } else if(var2) {
                  var4.field48 = true;
                  var4.field44 = var10;
                  var4.field61 = var11;
               } else {
                  var4.field48 = false;
                  var4.method11(var10, var11, class32.field739[var1]);
               }

               var4.field57 = (byte)(var7 + var4.field57 & 3);
               if(var1 == client.field460) {
                  class32.field754 = var4.field57;
               }

            }
         }
      }
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(IB)Lclass103;",
      garbageValue = "8"
   )
   @Export("getFrames")
   static class103 method2958(int var0) {
      class103 var1 = (class103)class42.field984.method3716((long)var0);
      if(null != var1) {
         return var1;
      } else {
         var1 = class19.method214(class42.field996, class42.field998, var0, false);
         if(null != var1) {
            class42.field984.method3724(var1, (long)var0);
         }

         return var1;
      }
   }
}
