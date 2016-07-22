import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("aa")
public class class32 {
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 1838367181
   )
   int field720;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 756509905
   )
   int field722;
   @ObfuscatedName("g")
   String field723;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -1401082647
   )
   int field724;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -153477383
   )
   int field725;

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(Lclass125;II)V",
      garbageValue = "-1888809127"
   )
   static void method675(class125 var0, int var1) {
      boolean var2 = var0.method2813(1) == 1;
      if(var2) {
         class34.field783[++class34.field782 - 1] = var1;
      }

      int var3 = var0.method2813(2);
      class2 var4 = client.field393[var1];
      if(var3 == 0) {
         if(var2) {
            var4.field59 = false;
         } else if(var1 == client.field551) {
            throw new RuntimeException();
         } else {
            class34.field779[var1] = (class39.field838 + var4.field885[0] >> 6 << 14) + (var4.field57 << 28) + (class13.field184 + var4.field886[0] >> 6);
            if(var4.field867 != -1) {
               class34.field778[var1] = var4.field867;
            } else {
               class34.field778[var1] = var4.field881;
            }

            class34.field781[var1] = var4.field856;
            client.field393[var1] = null;
            if(var0.method2813(1) != 0) {
               class42.method880(var0, var1);
            }

         }
      } else {
         int var5;
         int var6;
         int var7;
         if(var3 == 1) {
            var5 = var0.method2813(3);
            var6 = var4.field885[0];
            var7 = var4.field886[0];
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

            if(client.field551 != var1 || var4.field864 >= 1536 && var4.field831 >= 1536 && var4.field864 < 11776 && var4.field831 < 11776) {
               if(var2) {
                  var4.field59 = true;
                  var4.field60 = var6;
                  var4.field61 = var7;
               } else {
                  var4.field59 = false;
                  var4.method16(var6, var7, class34.field773[var1]);
               }
            } else {
               var4.method17(var6, var7);
               var4.field59 = false;
            }

         } else if(var3 == 2) {
            var5 = var0.method2813(4);
            var6 = var4.field885[0];
            var7 = var4.field886[0];
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

            if(var1 == client.field551 && (var4.field864 < 1536 || var4.field831 < 1536 || var4.field864 >= 11776 || var4.field831 >= 11776)) {
               var4.method17(var6, var7);
               var4.field59 = false;
            } else if(var2) {
               var4.field59 = true;
               var4.field60 = var6;
               var4.field61 = var7;
            } else {
               var4.field59 = false;
               var4.method16(var6, var7, class34.field773[var1]);
            }

         } else {
            var5 = var0.method2813(1);
            int var8;
            int var9;
            int var10;
            int var11;
            if(var5 == 0) {
               var6 = var0.method2813(12);
               var7 = var6 >> 10;
               var8 = var6 >> 5 & 31;
               if(var8 > 15) {
                  var8 -= 32;
               }

               var9 = var6 & 31;
               if(var9 > 15) {
                  var9 -= 32;
               }

               var10 = var4.field885[0] + var8;
               var11 = var9 + var4.field886[0];
               if(var1 != client.field551 || var4.field864 >= 1536 && var4.field831 >= 1536 && var4.field864 < 11776 && var4.field831 < 11776) {
                  if(var2) {
                     var4.field59 = true;
                     var4.field60 = var10;
                     var4.field61 = var11;
                  } else {
                     var4.field59 = false;
                     var4.method16(var10, var11, class34.field773[var1]);
                  }
               } else {
                  var4.method17(var10, var11);
                  var4.field59 = false;
               }

               var4.field57 = (byte)(var4.field57 + var7 & 3);
               if(var1 == client.field551) {
                  class51.field1119 = var4.field57;
               }

            } else {
               var6 = var0.method2813(30);
               var7 = var6 >> 28;
               var8 = var6 >> 14 & 16383;
               var9 = var6 & 16383;
               var10 = (var4.field885[0] + class39.field838 + var8 & 16383) - class39.field838;
               var11 = (var9 + var4.field886[0] + class13.field184 & 16383) - class13.field184;
               if(client.field551 != var1 || var4.field864 >= 1536 && var4.field831 >= 1536 && var4.field864 < 11776 && var4.field831 < 11776) {
                  if(var2) {
                     var4.field59 = true;
                     var4.field60 = var10;
                     var4.field61 = var11;
                  } else {
                     var4.field59 = false;
                     var4.method16(var10, var11, class34.field773[var1]);
                  }
               } else {
                  var4.method17(var10, var11);
                  var4.field59 = false;
               }

               var4.field57 = (byte)(var4.field57 + var7 & 3);
               if(client.field551 == var1) {
                  class51.field1119 = var4.field57;
               }

            }
         }
      }
   }

   @ObfuscatedName("bl")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "1"
   )
   static final void method676() {
      int var0 = class163.field2699;
      int var1 = class130.field2099;
      int var2 = class23.field600;
      int var3 = class34.field788;
      int var4 = 6116423;
      class82.method1880(var0, var1, var2, var3, var4);
      class82.method1880(1 + var0, 1 + var1, var2 - 2, 16, 0);
      class82.method1878(var0 + 1, var1 + 18, var2 - 2, var3 - 19, 0);
      class1.field25.method4099("Choose Option", 3 + var0, var1 + 14, var4, -1);
      int var5 = class143.field2213;
      int var6 = class143.field2214;

      for(int var7 = 0; var7 < client.field412; ++var7) {
         int var8 = 31 + var1 + 15 * (client.field412 - 1 - var7);
         int var9 = 16777215;
         if(var5 > var0 && var5 < var0 + var2 && var6 > var8 - 13 && var6 < 3 + var8) {
            var9 = 16776960;
         }

         class227 var10 = class1.field25;
         String var11;
         if(client.field328[var7].length() > 0) {
            var11 = client.field417[var7] + " " + client.field328[var7];
         } else {
            var11 = client.field417[var7];
         }

         var10.method4099(var11, var0 + 3, var8, var9, 0);
      }

      class38.method767(class163.field2699, class130.field2099, class23.field600, class34.field788);
   }

   @ObfuscatedName("dq")
   @ObfuscatedSignature(
      signature = "(Lclass176;B)Z",
      garbageValue = "-105"
   )
   static boolean method677(class176 var0) {
      if(client.field440) {
         if(class12.method151(var0) != 0) {
            return false;
         }

         if(var0.field2929 == 0) {
            return false;
         }
      }

      return var0.field2815;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(B)Lclass27;",
      garbageValue = "-53"
   )
   static class27 method678() {
      return class27.field661 < class27.field646?class219.field3210[++class27.field661 - 1]:null;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-2108926908"
   )
   static void method679() {
      class230 var0 = null;

      try {
         var0 = class7.method96("", class56.field1240.field2343, true);
         class122 var1 = class12.field162.method108();
         var0.method4207(var1.field2047, 0, var1.field2045);
      } catch (Exception var3) {
         ;
      }

      try {
         if(var0 != null) {
            var0.method4223();
         }
      } catch (Exception var2) {
         ;
      }

   }
}
