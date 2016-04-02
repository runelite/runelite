import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("s")
@Implements("WidgetNode")
public class class3 extends class208 {
   @ObfuscatedName("f")
   boolean field63 = false;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 1188698353
   )
   int field64;
   @ObfuscatedName("am")
   static boolean field66;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 864085775
   )
   @Export("id")
   int field69;

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(Lclass122;II)V",
      garbageValue = "1421896535"
   )
   static void method40(class122 var0, int var1) {
      boolean var2 = var0.method2756(1) == 1;
      if(var2) {
         class32.field739[++class32.field741 - 1] = var1;
      }

      int var3 = var0.method2756(2);
      class2 var4 = client.field387[var1];
      if(var3 == 0) {
         if(var2) {
            var4.field44 = false;
         } else if(client.field401 == var1) {
            throw new RuntimeException();
         } else {
            class32.field735[var1] = (class85.field1439 + var4.field842[0] >> 6 << 14) + (var4.field55 << 28) + (var4.field843[0] + class6.field128 >> 6);
            if(-1 != var4.field815) {
               class32.field736[var1] = var4.field815;
            } else {
               class32.field736[var1] = var4.field793;
            }

            class32.field737[var1] = var4.field845;
            client.field387[var1] = null;
            if(var0.method2756(1) != 0) {
               class28.method655(var0, var1);
            }

         }
      } else {
         int var5;
         int var6;
         int var7;
         if(var3 == 1) {
            var5 = var0.method2756(3);
            var6 = var4.field842[0];
            var7 = var4.field843[0];
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
            } else if(5 == var5) {
               --var6;
               ++var7;
            } else if(var5 == 6) {
               ++var7;
            } else if(var5 == 7) {
               ++var6;
               ++var7;
            }

            if(client.field401 == var1 && (var4.field804 < 1536 || var4.field814 < 1536 || var4.field804 >= 11776 || var4.field814 >= 11776)) {
               var4.method25(var6, var7);
               var4.field44 = false;
            } else if(var2) {
               var4.field44 = true;
               var4.field58 = var6;
               var4.field36 = var7;
            } else {
               var4.field44 = false;
               var4.method23(var6, var7, class32.field730[var1]);
            }

         } else if(var3 == 2) {
            var5 = var0.method2756(4);
            var6 = var4.field842[0];
            var7 = var4.field843[0];
            if(var5 == 0) {
               var6 -= 2;
               var7 -= 2;
            } else if(1 == var5) {
               --var6;
               var7 -= 2;
            } else if(2 == var5) {
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
            } else if(6 == var5) {
               var6 += 2;
               --var7;
            } else if(var5 == 7) {
               var6 -= 2;
            } else if(8 == var5) {
               var6 += 2;
            } else if(var5 == 9) {
               var6 -= 2;
               ++var7;
            } else if(10 == var5) {
               var6 += 2;
               ++var7;
            } else if(var5 == 11) {
               var6 -= 2;
               var7 += 2;
            } else if(12 == var5) {
               --var6;
               var7 += 2;
            } else if(13 == var5) {
               var7 += 2;
            } else if(var5 == 14) {
               ++var6;
               var7 += 2;
            } else if(15 == var5) {
               var6 += 2;
               var7 += 2;
            }

            if(client.field401 == var1 && (var4.field804 < 1536 || var4.field814 < 1536 || var4.field804 >= 11776 || var4.field814 >= 11776)) {
               var4.method25(var6, var7);
               var4.field44 = false;
            } else if(var2) {
               var4.field44 = true;
               var4.field58 = var6;
               var4.field36 = var7;
            } else {
               var4.field44 = false;
               var4.method23(var6, var7, class32.field730[var1]);
            }

         } else {
            var5 = var0.method2756(1);
            int var8;
            int var9;
            int var10;
            int var11;
            if(var5 == 0) {
               var6 = var0.method2756(12);
               var7 = var6 >> 10;
               var8 = var6 >> 5 & 31;
               if(var8 > 15) {
                  var8 -= 32;
               }

               var9 = var6 & 31;
               if(var9 > 15) {
                  var9 -= 32;
               }

               var10 = var4.field842[0] + var8;
               var11 = var4.field843[0] + var9;
               if(var1 == client.field401 && (var4.field804 < 1536 || var4.field814 < 1536 || var4.field804 >= 11776 || var4.field814 >= 11776)) {
                  var4.method25(var10, var11);
                  var4.field44 = false;
               } else if(var2) {
                  var4.field44 = true;
                  var4.field58 = var10;
                  var4.field36 = var11;
               } else {
                  var4.field44 = false;
                  var4.method23(var10, var11, class32.field730[var1]);
               }

               var4.field55 = (byte)(var7 + var4.field55 & 3);
               if(client.field401 == var1) {
                  class48.field1063 = var4.field55;
               }

            } else {
               var6 = var0.method2756(30);
               var7 = var6 >> 28;
               var8 = var6 >> 14 & 16383;
               var9 = var6 & 16383;
               var10 = (var8 + var4.field842[0] + class85.field1439 & 16383) - class85.field1439;
               var11 = (class6.field128 + var4.field843[0] + var9 & 16383) - class6.field128;
               if(var1 != client.field401 || var4.field804 >= 1536 && var4.field814 >= 1536 && var4.field804 < 11776 && var4.field814 < 11776) {
                  if(var2) {
                     var4.field44 = true;
                     var4.field58 = var10;
                     var4.field36 = var11;
                  } else {
                     var4.field44 = false;
                     var4.method23(var10, var11, class32.field730[var1]);
                  }
               } else {
                  var4.method25(var10, var11);
                  var4.field44 = false;
               }

               var4.field55 = (byte)(var4.field55 + var7 & 3);
               if(client.field401 == var1) {
                  class48.field1063 = var4.field55;
               }

            }
         }
      }
   }

   @ObfuscatedName("ce")
   static boolean method41(int var0) {
      return var0 == 57 || var0 == 58 || 1007 == var0 || 25 == var0 || 30 == var0;
   }

   @ObfuscatedName("e")
   public static class44 method42(int var0) {
      class44 var1 = (class44)class44.field1003.method3754((long)var0);
      if(null != var1) {
         return var1;
      } else {
         byte[] var2 = class44.field1005.method3280(3, var0);
         var1 = new class44();
         if(var2 != null) {
            var1.method920(new class119(var2));
         }

         class44.field1003.method3756(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("ah")
   static final void method43(class37 var0) {
      if(client.field289 == var0.field820 || var0.field819 == -1 || 0 != var0.field822 || var0.field821 + 1 > class46.method974(var0.field819).field968[var0.field789]) {
         int var1 = var0.field820 - var0.field833;
         int var2 = client.field289 - var0.field833;
         int var3 = var0.field792 * 64 + var0.field816 * 128;
         int var4 = var0.field792 * 64 + var0.field831 * 128;
         int var5 = var0.field792 * 64 + var0.field830 * 128;
         int var6 = var0.field792 * 64 + var0.field788 * 128;
         var0.field804 = ((var1 - var2) * var3 + var5 * var2) / var1;
         var0.field814 = (var2 * var6 + var4 * (var1 - var2)) / var1;
      }

      var0.field832 = 0;
      var0.field793 = var0.field840;
      var0.field790 = var0.field793;
   }
}
