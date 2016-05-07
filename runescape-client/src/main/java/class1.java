import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("j")
public class class1 {
   @ObfuscatedName("c")
   static class212 field24;
   @ObfuscatedName("w")
   static int[] field26;
   @ObfuscatedName("na")
   @ObfuscatedGetter(
      intValue = -516919371
   )
   static int field28;

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "1891870132"
   )
   public static void method1(boolean var0) {
      if(var0 != class49.field1091) {
         class51.field1140.method3750();
         class51.field1131.method3750();
         class51.field1113.method3750();
         class49.field1091 = var0;
      }

   }

   @ObfuscatedName("ds")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ZI)V",
      garbageValue = "0"
   )
   static final void method6(String var0, boolean var1) {
      if(null != var0) {
         if((client.field550 < 100 || client.field402 == 1) && client.field550 < 400) {
            String var2 = class32.method690(var0, field24);
            if(null != var2) {
               int var3;
               String var5;
               String var6;
               for(var3 = 0; var3 < client.field550; ++var3) {
                  class7 var4 = client.field344[var3];
                  var5 = class32.method690(var4.field133, field24);
                  if(null != var5 && var5.equals(var2)) {
                     class125.method2783(31, "", var0 + " is already on your ignore list");
                     return;
                  }

                  if(var4.field135 != null) {
                     var6 = class32.method690(var4.field135, field24);
                     if(var6 != null && var6.equals(var2)) {
                        class125.method2783(31, "", var0 + " is already on your ignore list");
                        return;
                     }
                  }
               }

               for(var3 = 0; var3 < client.field499; ++var3) {
                  class17 var7 = client.field548[var3];
                  var5 = class32.method690(var7.field247, field24);
                  if(var5 != null && var5.equals(var2)) {
                     class125.method2783(31, "", "Please remove " + var0 + " from your friend list first");
                     return;
                  }

                  if(var7.field240 != null) {
                     var6 = class32.method690(var7.field240, field24);
                     if(null != var6 && var6.equals(var2)) {
                        class125.method2783(31, "", "Please remove " + var0 + " from your friend list first");
                        return;
                     }
                  }
               }

               if(class32.method690(class106.field1881.field59, field24).equals(var2)) {
                  class125.method2783(31, "", "You can\'t add yourself to your own ignore list");
               } else {
                  client.field322.method2737(33);
                  client.field322.method2477(class30.method647(var0));
                  client.field322.method2483(var0);
               }
            }
         } else {
            class125.method2783(31, "", "Your ignore list is full. Max of 100 for free users, and 400 for members");
         }
      }
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Lclass122;II)V",
      garbageValue = "1684210747"
   )
   static void method7(class122 var0, int var1) {
      boolean var2 = var0.method2750(1) == 1;
      if(var2) {
         class32.field764[++class32.field762 - 1] = var1;
      }

      int var3 = var0.method2750(2);
      class2 var4 = client.field491[var1];
      if(0 == var3) {
         if(var2) {
            var4.field36 = false;
         } else if(client.field291 == var1) {
            throw new RuntimeException();
         } else {
            class32.field759[var1] = (class114.field1981 + var4.field863[0] >> 6) + (var4.field866[0] + class22.field594 >> 6 << 14) + (var4.field55 << 28);
            if(var4.field824 != -1) {
               class32.field760[var1] = var4.field824;
            } else {
               class32.field760[var1] = var4.field862;
            }

            class32.field761[var1] = var4.field837;
            client.field491[var1] = null;
            if(var0.method2750(1) != 0) {
               class119.method2638(var0, var1);
            }

         }
      } else {
         int var5;
         int var6;
         int var7;
         if(var3 == 1) {
            var5 = var0.method2750(3);
            var6 = var4.field866[0];
            var7 = var4.field863[0];
            if(var5 == 0) {
               --var6;
               --var7;
            } else if(var5 == 1) {
               --var7;
            } else if(2 == var5) {
               ++var6;
               --var7;
            } else if(var5 == 3) {
               --var6;
            } else if(var5 == 4) {
               ++var6;
            } else if(5 == var5) {
               --var6;
               ++var7;
            } else if(6 == var5) {
               ++var7;
            } else if(7 == var5) {
               ++var6;
               ++var7;
            }

            if(client.field291 == var1 && (var4.field823 < 1536 || var4.field813 < 1536 || var4.field823 >= 11776 || var4.field813 >= 11776)) {
               var4.method15(var6, var7);
               var4.field36 = false;
            } else if(var2) {
               var4.field36 = true;
               var4.field37 = var6;
               var4.field57 = var7;
            } else {
               var4.field36 = false;
               var4.method31(var6, var7, class32.field753[var1]);
            }

         } else if(2 == var3) {
            var5 = var0.method2750(4);
            var6 = var4.field866[0];
            var7 = var4.field863[0];
            if(0 == var5) {
               var6 -= 2;
               var7 -= 2;
            } else if(var5 == 1) {
               --var6;
               var7 -= 2;
            } else if(var5 == 2) {
               var7 -= 2;
            } else if(3 == var5) {
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
            } else if(7 == var5) {
               var6 -= 2;
            } else if(8 == var5) {
               var6 += 2;
            } else if(var5 == 9) {
               var6 -= 2;
               ++var7;
            } else if(10 == var5) {
               var6 += 2;
               ++var7;
            } else if(11 == var5) {
               var6 -= 2;
               var7 += 2;
            } else if(var5 == 12) {
               --var6;
               var7 += 2;
            } else if(13 == var5) {
               var7 += 2;
            } else if(14 == var5) {
               ++var6;
               var7 += 2;
            } else if(15 == var5) {
               var6 += 2;
               var7 += 2;
            }

            if(client.field291 != var1 || var4.field823 >= 1536 && var4.field813 >= 1536 && var4.field823 < 11776 && var4.field813 < 11776) {
               if(var2) {
                  var4.field36 = true;
                  var4.field37 = var6;
                  var4.field57 = var7;
               } else {
                  var4.field36 = false;
                  var4.method31(var6, var7, class32.field753[var1]);
               }
            } else {
               var4.method15(var6, var7);
               var4.field36 = false;
            }

         } else {
            var5 = var0.method2750(1);
            int var8;
            int var9;
            int var10;
            int var11;
            if(var5 == 0) {
               var6 = var0.method2750(12);
               var7 = var6 >> 10;
               var8 = var6 >> 5 & 31;
               if(var8 > 15) {
                  var8 -= 32;
               }

               var9 = var6 & 31;
               if(var9 > 15) {
                  var9 -= 32;
               }

               var10 = var8 + var4.field866[0];
               var11 = var4.field863[0] + var9;
               if(var1 != client.field291 || var4.field823 >= 1536 && var4.field813 >= 1536 && var4.field823 < 11776 && var4.field813 < 11776) {
                  if(var2) {
                     var4.field36 = true;
                     var4.field37 = var10;
                     var4.field57 = var11;
                  } else {
                     var4.field36 = false;
                     var4.method31(var10, var11, class32.field753[var1]);
                  }
               } else {
                  var4.method15(var10, var11);
                  var4.field36 = false;
               }

               var4.field55 = (byte)(var4.field55 + var7 & 3);
               if(var1 == client.field291) {
                  class21.field581 = var4.field55;
               }

            } else {
               var6 = var0.method2750(30);
               var7 = var6 >> 28;
               var8 = var6 >> 14 & 16383;
               var9 = var6 & 16383;
               var10 = (var8 + class22.field594 + var4.field866[0] & 16383) - class22.field594;
               var11 = (var9 + var4.field863[0] + class114.field1981 & 16383) - class114.field1981;
               if(client.field291 == var1 && (var4.field823 < 1536 || var4.field813 < 1536 || var4.field823 >= 11776 || var4.field813 >= 11776)) {
                  var4.method15(var10, var11);
                  var4.field36 = false;
               } else if(var2) {
                  var4.field36 = true;
                  var4.field37 = var10;
                  var4.field57 = var11;
               } else {
                  var4.field36 = false;
                  var4.method31(var10, var11, class32.field753[var1]);
               }

               var4.field55 = (byte)(var7 + var4.field55 & 3);
               if(var1 == client.field291) {
                  class21.field581 = var4.field55;
               }

            }
         }
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1961576344"
   )
   public static void method8(int var0) {
      if(var0 != -1) {
         if(class173.field2838[var0]) {
            class173.field2755.method3309(var0);
            if(null != class217.field3171[var0]) {
               boolean var1 = true;

               for(int var2 = 0; var2 < class217.field3171[var0].length; ++var2) {
                  if(class217.field3171[var0][var2] != null) {
                     if(2 != class217.field3171[var0][var2].field2767) {
                        class217.field3171[var0][var2] = null;
                     } else {
                        var1 = false;
                     }
                  }
               }

               if(var1) {
                  class217.field3171[var0] = null;
               }

               class173.field2838[var0] = false;
            }
         }
      }
   }
}
