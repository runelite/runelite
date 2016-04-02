import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dj")
public class class106 {
   @ObfuscatedName("s")
   static int[][] field1843 = new int[128][128];
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -2139182447
   )
   static int field1844;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 595771291
   )
   static int field1845;
   @ObfuscatedName("a")
   static int[] field1846 = new int[4096];
   @ObfuscatedName("f")
   static int[][] field1847 = new int[128][128];
   @ObfuscatedName("r")
   static int[] field1848 = new int[4096];

   @ObfuscatedName("s")
   public static int method2396() {
      return class137.field2114;
   }

   @ObfuscatedName("by")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1939186712"
   )
   static final void method2399() {
      int var0;
      int var1;
      int var2;
      int var3;
      class28 var32;
      if(245 == client.field325) {
         var0 = client.field323.method2523();
         var1 = class50.field1077 + (var0 >> 4 & 7);
         var2 = client.field342 + (var0 & 7);
         var3 = client.field323.method2557();
         if(var1 >= 0 && var2 >= 0 && var1 < 104 && var2 < 104) {
            class199 var31 = client.field410[class48.field1063][var1][var2];
            if(null != var31) {
               for(var32 = (class28)var31.method3825(); var32 != null; var32 = (class28)var31.method3827()) {
                  if(var32.field666 == (var3 & 32767)) {
                     var32.method3913();
                     break;
                  }
               }

               if(var31.method3825() == null) {
                  client.field410[class48.field1063][var1][var2] = null;
               }

               class31.method680(var1, var2);
            }
         }

      } else {
         int var4;
         int var5;
         int var6;
         int var7;
         if(client.field325 == 228) {
            var0 = client.field323.method2550();
            var1 = var0 >> 2;
            var2 = var0 & 3;
            var3 = client.field341[var1];
            var4 = client.field323.method2523();
            var5 = (var4 >> 4 & 7) + class50.field1077;
            var6 = (var4 & 7) + client.field342;
            var7 = client.field323.method2587();
            if(var5 >= 0 && var6 >= 0 && var5 < 104 && var6 < 104) {
               class14.method168(class48.field1063, var5, var6, var3, var7, var1, var2, 0, -1);
            }

         } else if(client.field325 == 200) {
            var0 = client.field323.method2587();
            var1 = client.field323.method2523();
            var2 = (var1 >> 4 & 7) + class50.field1077;
            var3 = client.field342 + (var1 & 7);
            var4 = client.field323.method2557();
            if(var2 >= 0 && var3 >= 0 && var2 < 104 && var3 < 104) {
               var32 = new class28();
               var32.field666 = var4;
               var32.field664 = var0;
               if(client.field410[class48.field1063][var2][var3] == null) {
                  client.field410[class48.field1063][var2][var3] = new class199();
               }

               client.field410[class48.field1063][var2][var3].method3834(var32);
               class31.method680(var2, var3);
            }

         } else {
            int var9;
            if(81 == client.field325) {
               var0 = client.field323.method2523();
               var1 = var0 >> 2;
               var2 = var0 & 3;
               var3 = client.field341[var1];
               var4 = client.field323.method2523();
               var5 = class50.field1077 + (var4 >> 4 & 7);
               var6 = client.field342 + (var4 & 7);
               var7 = client.field323.method2557();
               if(var5 >= 0 && var6 >= 0 && var5 < 103 && var6 < 103) {
                  if(0 == var3) {
                     class87 var35 = class151.field2250.method1948(class48.field1063, var5, var6);
                     if(null != var35) {
                        var9 = var35.field1515 >> 14 & 32767;
                        if(var1 == 2) {
                           var35.field1509 = new class12(var9, 2, var2 + 4, class48.field1063, var5, var6, var7, false, var35.field1509);
                           var35.field1510 = new class12(var9, 2, 1 + var2 & 3, class48.field1063, var5, var6, var7, false, var35.field1510);
                        } else {
                           var35.field1509 = new class12(var9, var1, var2, class48.field1063, var5, var6, var7, false, var35.field1509);
                        }
                     }
                  }

                  if(var3 == 1) {
                     class94 var36 = class151.field2250.method1949(class48.field1063, var5, var6);
                     if(var36 != null) {
                        var9 = var36.field1587 >> 14 & 32767;
                        if(var1 != 4 && 5 != var1) {
                           if(6 == var1) {
                              var36.field1589 = new class12(var9, 4, 4 + var2, class48.field1063, var5, var6, var7, false, var36.field1589);
                           } else if(7 == var1) {
                              var36.field1589 = new class12(var9, 4, (2 + var2 & 3) + 4, class48.field1063, var5, var6, var7, false, var36.field1589);
                           } else if(var1 == 8) {
                              var36.field1589 = new class12(var9, 4, 4 + var2, class48.field1063, var5, var6, var7, false, var36.field1589);
                              var36.field1586 = new class12(var9, 4, (var2 + 2 & 3) + 4, class48.field1063, var5, var6, var7, false, var36.field1586);
                           }
                        } else {
                           var36.field1589 = new class12(var9, 4, var2, class48.field1063, var5, var6, var7, false, var36.field1589);
                        }
                     }
                  }

                  if(var3 == 2) {
                     class98 var37 = class151.field2250.method1950(class48.field1063, var5, var6);
                     if(11 == var1) {
                        var1 = 10;
                     }

                     if(var37 != null) {
                        var37.field1638 = new class12(var37.field1646 >> 14 & 32767, var1, var2, class48.field1063, var5, var6, var7, false, var37.field1638);
                     }
                  }

                  if(var3 == 3) {
                     class93 var38 = class151.field2250.method2046(class48.field1063, var5, var6);
                     if(var38 != null) {
                        var38.field1573 = new class12(var38.field1572 >> 14 & 32767, 22, var2, class48.field1063, var5, var6, var7, false, var38.field1573);
                     }
                  }
               }

            } else if(33 == client.field325) {
               var0 = client.field323.method2523();
               var1 = class50.field1077 + (var0 >> 4 & 7);
               var2 = client.field342 + (var0 & 7);
               var3 = client.field323.method2700();
               var4 = client.field323.method2523();
               var5 = client.field323.method2700();
               if(var1 >= 0 && var2 >= 0 && var1 < 104 && var2 < 104) {
                  var1 = var1 * 128 + 64;
                  var2 = var2 * 128 + 64;
                  class29 var33 = new class29(var3, class48.field1063, var1, var2, class59.method1263(var1, var2, class48.field1063) - var4, var5, client.field289);
                  client.field413.method3834(var33);
               }

            } else if(203 == client.field325) {
               var0 = client.field323.method2523();
               var1 = var0 >> 2;
               var2 = var0 & 3;
               var3 = client.field341[var1];
               var4 = client.field323.method2523();
               var5 = (var4 >> 4 & 7) + class50.field1077;
               var6 = client.field342 + (var4 & 7);
               if(var5 >= 0 && var6 >= 0 && var5 < 104 && var6 < 104) {
                  class14.method168(class48.field1063, var5, var6, var3, -1, var1, var2, 0, -1);
               }

            } else {
               int var8;
               if(client.field325 == 83) {
                  var0 = client.field323.method2523();
                  var1 = (var0 >> 4 & 7) + class50.field1077;
                  var2 = client.field342 + (var0 & 7);
                  var3 = client.field323.method2700();
                  var4 = client.field323.method2523();
                  var5 = var4 >> 4 & 15;
                  var6 = var4 & 7;
                  var7 = client.field323.method2523();
                  if(var1 >= 0 && var2 >= 0 && var1 < 104 && var2 < 104) {
                     var8 = var5 + 1;
                     if(class20.field572.field842[0] >= var1 - var8 && class20.field572.field842[0] <= var1 + var8 && class20.field572.field843[0] >= var2 - var8 && class20.field572.field843[0] <= var2 + var8 && client.field519 != 0 && var6 > 0 && client.field383 < 50) {
                        client.field521[client.field383] = var3;
                        client.field522[client.field383] = var6;
                        client.field523[client.field383] = var7;
                        client.field444[client.field383] = null;
                        client.field446[client.field383] = (var1 << 16) + (var2 << 8) + var5;
                        ++client.field383;
                     }
                  }
               }

               int var12;
               if(client.field325 == 238) {
                  var0 = client.field323.method2523();
                  var1 = (var0 >> 4 & 7) + class50.field1077;
                  var2 = (var0 & 7) + client.field342;
                  var3 = var1 + client.field323.method2633();
                  var4 = var2 + client.field323.method2633();
                  var5 = client.field323.method2526();
                  var6 = client.field323.method2700();
                  var7 = client.field323.method2523() * 4;
                  var8 = client.field323.method2523() * 4;
                  var9 = client.field323.method2700();
                  int var39 = client.field323.method2700();
                  int var40 = client.field323.method2523();
                  var12 = client.field323.method2523();
                  if(var1 >= 0 && var2 >= 0 && var1 < 104 && var2 < 104 && var3 >= 0 && var4 >= 0 && var3 < 104 && var4 < 104 && var6 != '\uffff') {
                     var1 = 64 + 128 * var1;
                     var2 = 128 * var2 + 64;
                     var3 = 128 * var3 + 64;
                     var4 = 128 * var4 + 64;
                     class6 var41 = new class6(var6, class48.field1063, var1, var2, class59.method1263(var1, var2, class48.field1063) - var7, client.field289 + var9, var39 + client.field289, var40, var12, var5, var8);
                     var41.method94(var3, var4, class59.method1263(var3, var4, class48.field1063) - var8, var9 + client.field289);
                     client.field412.method3834(var41);
                  }

               } else {
                  if(177 == client.field325) {
                     var0 = client.field323.method2700();
                     byte var29 = client.field323.method2633();
                     var2 = client.field323.method2551();
                     var3 = class50.field1077 + (var2 >> 4 & 7);
                     var4 = client.field342 + (var2 & 7);
                     var5 = client.field323.method2550();
                     var6 = var5 >> 2;
                     var7 = var5 & 3;
                     var8 = client.field341[var6];
                     var9 = client.field323.method2561();
                     byte var10 = client.field323.method2588();
                     byte var11 = client.field323.method2588();
                     var12 = client.field323.method2557();
                     int var13 = client.field323.method2561();
                     byte var14 = client.field323.method2552();
                     class2 var15;
                     if(var12 == client.field401) {
                        var15 = class20.field572;
                     } else {
                        var15 = client.field387[var12];
                     }

                     if(null != var15) {
                        class40 var16 = class26.method633(var0);
                        int var17;
                        int var18;
                        if(var7 != 1 && var7 != 3) {
                           var17 = var16.field908;
                           var18 = var16.field915;
                        } else {
                           var17 = var16.field915;
                           var18 = var16.field908;
                        }

                        int var19 = var3 + (var17 >> 1);
                        int var20 = (var17 + 1 >> 1) + var3;
                        int var21 = var4 + (var18 >> 1);
                        int var22 = var4 + (var18 + 1 >> 1);
                        int[][] var23 = class5.field90[class48.field1063];
                        int var24 = var23[var20][var22] + var23[var20][var21] + var23[var19][var21] + var23[var19][var22] >> 2;
                        int var25 = (var17 << 6) + (var3 << 7);
                        int var26 = (var4 << 7) + (var18 << 6);
                        class105 var27 = var16.method799(var6, var7, var23, var25, var24, var26);
                        if(null != var27) {
                           class14.method168(class48.field1063, var3, var4, var8, -1, 0, 0, 1 + var9, 1 + var13);
                           var15.field42 = client.field289 + var9;
                           var15.field59 = client.field289 + var13;
                           var15.field47 = var27;
                           var15.field38 = var17 * 64 + var3 * 128;
                           var15.field43 = var4 * 128 + 64 * var18;
                           var15.field53 = var24;
                           byte var28;
                           if(var29 > var11) {
                              var28 = var29;
                              var29 = var11;
                              var11 = var28;
                           }

                           if(var14 > var10) {
                              var28 = var14;
                              var14 = var10;
                              var10 = var28;
                           }

                           var15.field48 = var3 + var29;
                           var15.field50 = var3 + var11;
                           var15.field49 = var4 + var14;
                           var15.field51 = var10 + var4;
                        }
                     }
                  }

                  if(191 == client.field325) {
                     var0 = client.field323.method2523();
                     var1 = class50.field1077 + (var0 >> 4 & 7);
                     var2 = (var0 & 7) + client.field342;
                     var3 = client.field323.method2700();
                     var4 = client.field323.method2700();
                     var5 = client.field323.method2700();
                     if(var1 >= 0 && var2 >= 0 && var1 < 104 && var2 < 104) {
                        class199 var30 = client.field410[class48.field1063][var1][var2];
                        if(var30 != null) {
                           for(class28 var34 = (class28)var30.method3825(); var34 != null; var34 = (class28)var30.method3827()) {
                              if((var3 & 32767) == var34.field666 && var34.field664 == var4) {
                                 var34.field664 = var5;
                                 break;
                              }
                           }

                           class31.method680(var1, var2);
                        }
                     }

                  }
               }
            }
         }
      }
   }

   @ObfuscatedName("dw")
   static final void method2400() {
      client.field321.method2762(114);

      for(class3 var0 = (class3)client.field439.method3794(); var0 != null; var0 = (class3)client.field439.method3791()) {
         if(var0.field64 == 0 || 3 == var0.field64) {
            class110.method2446(var0, true);
         }
      }

      if(null != client.field442) {
         class9.method133(client.field442);
         client.field442 = null;
      }

   }
}
