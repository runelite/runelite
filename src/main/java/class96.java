import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ce")
public class class96 {
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -387697473
   )
   int field1639;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -1884510033
   )
   int field1641;
   @ObfuscatedName("z")
   public static class224 field1642;
   @ObfuscatedName("fd")
   @ObfuscatedGetter(
      intValue = -1188225149
   )
   static int field1643;
   @ObfuscatedName("h")
   static int[] field1645;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -1723010257
   )
   int field1646;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -368786635
   )
   int field1648;
   @ObfuscatedName("bh")
   static class168 field1649;

   @ObfuscatedName("bp")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-159923195"
   )
   static final void method2186() {
      int var0;
      int var1;
      int var2;
      int var3;
      int var4;
      int var5;
      if(client.field301 == 81) {
         var0 = client.field528.method2506();
         var1 = (var0 >> 4 & 7) + class10.field177;
         var2 = client.field304 + (var0 & 7);
         var3 = client.field528.method2508();
         var4 = client.field528.method2508();
         var5 = client.field528.method2508();
         if(var1 >= 0 && var2 >= 0 && var1 < 104 && var2 < 104) {
            class199 var32 = client.field425[class82.field1437][var1][var2];
            if(var32 != null) {
               for(class28 var34 = (class28)var32.method3836(); var34 != null; var34 = (class28)var32.method3841()) {
                  if(var34.field686 == (var3 & 32767) && var34.field683 == var4) {
                     var34.field683 = var5;
                     break;
                  }
               }

               class122.method2760(var1, var2);
            }
         }

      } else {
         class28 var29;
         if(36 == client.field301) {
            var0 = client.field528.method2506();
            var1 = class10.field177 + (var0 >> 4 & 7);
            var2 = (var0 & 7) + client.field304;
            var3 = client.field528.method2508();
            if(var1 >= 0 && var2 >= 0 && var1 < 104 && var2 < 104) {
               class199 var31 = client.field425[class82.field1437][var1][var2];
               if(null != var31) {
                  for(var29 = (class28)var31.method3836(); null != var29; var29 = (class28)var31.method3841()) {
                     if((var3 & 32767) == var29.field686) {
                        var29.method3935();
                        break;
                     }
                  }

                  if(var31.method3836() == null) {
                     client.field425[class82.field1437][var1][var2] = null;
                  }

                  class122.method2760(var1, var2);
               }
            }

         } else {
            int var6;
            int var7;
            int var8;
            int var9;
            int var10;
            if(198 == client.field301) {
               var0 = client.field528.method2506();
               var1 = (var0 >> 4 & 7) + class10.field177;
               var2 = client.field304 + (var0 & 7);
               var3 = var1 + client.field528.method2524();
               var4 = var2 + client.field528.method2524();
               var5 = client.field528.method2509();
               var6 = client.field528.method2508();
               var7 = client.field528.method2506() * 4;
               var8 = client.field528.method2506() * 4;
               var9 = client.field528.method2508();
               var10 = client.field528.method2508();
               int var39 = client.field528.method2506();
               int var40 = client.field528.method2506();
               if(var1 >= 0 && var2 >= 0 && var1 < 104 && var2 < 104 && var3 >= 0 && var4 >= 0 && var3 < 104 && var4 < 104 && var6 != '\uffff') {
                  var1 = 64 + 128 * var1;
                  var2 = var2 * 128 + 64;
                  var3 = 64 + var3 * 128;
                  var4 = 64 + 128 * var4;
                  class6 var41 = new class6(var6, class82.field1437, var1, var2, class43.method938(var1, var2, class82.field1437) - var7, client.field305 + var9, client.field305 + var10, var39, var40, var5, var8);
                  var41.method95(var3, var4, class43.method938(var3, var4, class82.field1437) - var8, var9 + client.field305);
                  client.field427.method3834(var41);
               }

            } else {
               if(115 == client.field301) {
                  var0 = client.field528.method2506();
                  var1 = class10.field177 + (var0 >> 4 & 7);
                  var2 = client.field304 + (var0 & 7);
                  var3 = client.field528.method2508();
                  var4 = client.field528.method2506();
                  var5 = var4 >> 4 & 15;
                  var6 = var4 & 7;
                  var7 = client.field528.method2506();
                  if(var1 >= 0 && var2 >= 0 && var1 < 104 && var2 < 104) {
                     var8 = 1 + var5;
                     if(class167.field2692.field872[0] >= var1 - var8 && class167.field2692.field872[0] <= var8 + var1 && class167.field2692.field873[0] >= var2 - var8 && class167.field2692.field873[0] <= var2 + var8 && 0 != client.field535 && var6 > 0 && client.field536 < 50) {
                        client.field350[client.field536] = var3;
                        client.field538[client.field536] = var6;
                        client.field543[client.field536] = var7;
                        client.field552[client.field536] = null;
                        client.field540[client.field536] = var5 + (var2 << 8) + (var1 << 16);
                        ++client.field536;
                     }
                  }
               }

               if(client.field301 == 224) {
                  var0 = client.field528.method2532();
                  var1 = class10.field177 + (var0 >> 4 & 7);
                  var2 = client.field304 + (var0 & 7);
                  var3 = client.field528.method2597();
                  var4 = var3 >> 2;
                  var5 = var3 & 3;
                  var6 = client.field556[var4];
                  var7 = client.field528.method2541();
                  byte var33 = client.field528.method2537();
                  var9 = client.field528.method2600();
                  var10 = client.field528.method2541();
                  byte var11 = client.field528.method2537();
                  byte var12 = client.field528.method2639();
                  int var13 = client.field528.method2541();
                  byte var14 = client.field528.method2536();
                  class2 var15;
                  if(var7 == client.field416) {
                     var15 = class167.field2692;
                  } else {
                     var15 = client.field415[var7];
                  }

                  if(null != var15) {
                     class40 var16 = class22.method592(var10);
                     int var17;
                     int var18;
                     if(1 != var5 && var5 != 3) {
                        var17 = var16.field979;
                        var18 = var16.field942;
                     } else {
                        var17 = var16.field942;
                        var18 = var16.field979;
                     }

                     int var19 = (var17 >> 1) + var1;
                     int var20 = var1 + (var17 + 1 >> 1);
                     int var21 = var2 + (var18 >> 1);
                     int var22 = var2 + (1 + var18 >> 1);
                     int[][] var23 = class5.field96[class82.field1437];
                     int var24 = var23[var20][var22] + var23[var19][var22] + var23[var20][var21] + var23[var19][var21] >> 2;
                     int var25 = (var1 << 7) + (var17 << 6);
                     int var26 = (var2 << 7) + (var18 << 6);
                     class105 var27 = var16.method870(var4, var5, var23, var25, var24, var26);
                     if(null != var27) {
                        class5.method62(class82.field1437, var1, var2, var6, -1, 0, 0, 1 + var13, var9 + 1);
                        var15.field46 = client.field305 + var13;
                        var15.field57 = var9 + client.field305;
                        var15.field51 = var27;
                        var15.field48 = var1 * 128 + var17 * 64;
                        var15.field38 = 64 * var18 + 128 * var2;
                        var15.field49 = var24;
                        byte var28;
                        if(var11 > var14) {
                           var28 = var11;
                           var11 = var14;
                           var14 = var28;
                        }

                        if(var33 > var12) {
                           var28 = var33;
                           var33 = var12;
                           var12 = var28;
                        }

                        var15.field52 = var11 + var1;
                        var15.field54 = var14 + var1;
                        var15.field53 = var33 + var2;
                        var15.field67 = var12 + var2;
                     }
                  }
               }

               if(153 == client.field301) {
                  var0 = client.field528.method2506();
                  var1 = var0 >> 2;
                  var2 = var0 & 3;
                  var3 = client.field556[var1];
                  var4 = client.field528.method2597();
                  var5 = class10.field177 + (var4 >> 4 & 7);
                  var6 = client.field304 + (var4 & 7);
                  if(var5 >= 0 && var6 >= 0 && var5 < 104 && var6 < 104) {
                     class5.method62(class82.field1437, var5, var6, var3, -1, var1, var2, 0, -1);
                  }

               } else if(client.field301 != 196) {
                  if(154 == client.field301) {
                     var0 = client.field528.method2597();
                     var1 = (var0 >> 4 & 7) + class10.field177;
                     var2 = client.field304 + (var0 & 7);
                     var3 = client.field528.method2533();
                     var4 = var3 >> 2;
                     var5 = var3 & 3;
                     var6 = client.field556[var4];
                     var7 = client.field528.method2541();
                     if(var1 >= 0 && var2 >= 0 && var1 < 104 && var2 < 104) {
                        class5.method62(class82.field1437, var1, var2, var6, var7, var4, var5, 0, -1);
                     }

                  } else if(52 == client.field301) {
                     var0 = client.field528.method2506();
                     var1 = (var0 >> 4 & 7) + class10.field177;
                     var2 = client.field304 + (var0 & 7);
                     var3 = client.field528.method2508();
                     var4 = client.field528.method2506();
                     var5 = client.field528.method2508();
                     if(var1 >= 0 && var2 >= 0 && var1 < 104 && var2 < 104) {
                        var1 = 64 + var1 * 128;
                        var2 = 64 + 128 * var2;
                        class29 var30 = new class29(var3, class82.field1437, var1, var2, class43.method938(var1, var2, class82.field1437) - var4, var5, client.field305);
                        client.field478.method3834(var30);
                     }

                  } else if(client.field301 == 95) {
                     var0 = client.field528.method2508();
                     var1 = client.field528.method2506();
                     var2 = (var1 >> 4 & 7) + class10.field177;
                     var3 = (var1 & 7) + client.field304;
                     var4 = client.field528.method2508();
                     if(var2 >= 0 && var3 >= 0 && var2 < 104 && var3 < 104) {
                        var29 = new class28();
                        var29.field686 = var4;
                        var29.field683 = var0;
                        if(client.field425[class82.field1437][var2][var3] == null) {
                           client.field425[class82.field1437][var2][var3] = new class199();
                        }

                        client.field425[class82.field1437][var2][var3].method3834(var29);
                        class122.method2760(var2, var3);
                     }

                  }
               } else {
                  var0 = client.field528.method2506();
                  var1 = (var0 >> 4 & 7) + class10.field177;
                  var2 = (var0 & 7) + client.field304;
                  var3 = client.field528.method2533();
                  var4 = var3 >> 2;
                  var5 = var3 & 3;
                  var6 = client.field556[var4];
                  var7 = client.field528.method2542();
                  if(var1 >= 0 && var2 >= 0 && var1 < 103 && var2 < 103) {
                     if(var6 == 0) {
                        class87 var35 = class3.field75.method2040(class82.field1437, var1, var2);
                        if(null != var35) {
                           var9 = var35.field1538 >> 14 & 32767;
                           if(2 == var4) {
                              var35.field1540 = new class12(var9, 2, var5 + 4, class82.field1437, var1, var2, var7, false, var35.field1540);
                              var35.field1541 = new class12(var9, 2, 1 + var5 & 3, class82.field1437, var1, var2, var7, false, var35.field1541);
                           } else {
                              var35.field1540 = new class12(var9, var4, var5, class82.field1437, var1, var2, var7, false, var35.field1540);
                           }
                        }
                     }

                     if(1 == var6) {
                        class94 var36 = class3.field75.method1931(class82.field1437, var1, var2);
                        if(var36 != null) {
                           var9 = var36.field1620 >> 14 & 32767;
                           if(var4 != 4 && 5 != var4) {
                              if(var4 == 6) {
                                 var36.field1618 = new class12(var9, 4, 4 + var5, class82.field1437, var1, var2, var7, false, var36.field1618);
                              } else if(7 == var4) {
                                 var36.field1618 = new class12(var9, 4, (var5 + 2 & 3) + 4, class82.field1437, var1, var2, var7, false, var36.field1618);
                              } else if(var4 == 8) {
                                 var36.field1618 = new class12(var9, 4, 4 + var5, class82.field1437, var1, var2, var7, false, var36.field1618);
                                 var36.field1612 = new class12(var9, 4, (2 + var5 & 3) + 4, class82.field1437, var1, var2, var7, false, var36.field1612);
                              }
                           } else {
                              var36.field1618 = new class12(var9, 4, var5, class82.field1437, var1, var2, var7, false, var36.field1618);
                           }
                        }
                     }

                     if(2 == var6) {
                        class98 var37 = class3.field75.method1932(class82.field1437, var1, var2);
                        if(var4 == 11) {
                           var4 = 10;
                        }

                        if(var37 != null) {
                           var37.field1676 = new class12(var37.field1678 >> 14 & 32767, var4, var5, class82.field1437, var1, var2, var7, false, var37.field1676);
                        }
                     }

                     if(3 == var6) {
                        class93 var38 = class3.field75.method1933(class82.field1437, var1, var2);
                        if(null != var38) {
                           var38.field1599 = new class12(var38.field1600 >> 14 & 32767, 22, var5, class82.field1437, var1, var2, var7, false, var38.field1599);
                        }
                     }
                  }

               }
            }
         }
      }
   }

   class96() {
   }

   @ObfuscatedName("x")
   public static class42 method2187(int var0) {
      class42 var1 = (class42)class42.field993.method3771((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = class42.field1007.method3335(12, var0);
         var1 = new class42();
         if(null != var2) {
            var1.method917(new class119(var2));
         }

         var1.method901();
         class42.field993.method3773(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("p")
   public static class152[] method2188() {
      return new class152[]{class152.field2296, class152.field2286, class152.field2287, class152.field2285, class152.field2288};
   }

   class96(class96 var1) {
      this.field1646 = var1.field1646;
      this.field1639 = var1.field1639;
      this.field1648 = var1.field1648;
      this.field1641 = var1.field1641;
   }
}
