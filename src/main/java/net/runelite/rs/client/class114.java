package net.runelite.rs.client;

import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("dd")
public class class114 {
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      longValue = -649817176488381667L
   )
   static long field1958;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      longValue = 2998043934180663027L
   )
   static long field1961;

   @ObfuscatedName("cb")
   static final void method2464(class172[] var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
      class79.method1816(var2, var3, var4, var5);
      class90.method2103();

      for(int var9 = 0; var9 < var0.length; ++var9) {
         class172 var10 = var0[var9];
         if(var10 != null && (var10.field2742 == var1 || var1 == -1412584499 && client.field447 == var10)) {
            int var11;
            if(-1 == var8) {
               client.field482[client.field477] = var10.field2846 + var6;
               client.field483[client.field477] = var7 + var10.field2748;
               client.field484[client.field477] = var10.field2749;
               client.field526[client.field477] = var10.field2750;
               var11 = ++client.field477 - 1;
            } else {
               var11 = var8;
            }

            var10.field2863 = var11;
            var10.field2833 = client.field286 * -1;
            if(!var10.field2733 || !class153.method3195(var10)) {
               if(var10.field2738 > 0) {
                  class128.method2864(var10);
               }

               int var12 = var10.field2846 + var6;
               int var13 = var10.field2748 + var7;
               int var14 = var10.field2784;
               int var15;
               int var16;
               if(client.field447 == var10) {
                  if(var1 != -1412584499 && !var10.field2810) {
                     class37.field836 = var0;
                     class10.field157 = var6;
                     class48.field1070 = var7;
                     continue;
                  }

                  if(client.field517 && client.field452) {
                     var15 = class139.field2134;
                     var16 = class139.field2135;
                     var15 -= client.field449;
                     var16 -= client.field450;
                     if(var15 < client.field453) {
                        var15 = client.field453;
                     }

                     if(var10.field2749 + var15 > client.field448.field2749 + client.field453) {
                        var15 = client.field453 + client.field448.field2749 - var10.field2749;
                     }

                     if(var16 < client.field454) {
                        var16 = client.field454;
                     }

                     if(var16 + var10.field2750 > client.field454 + client.field448.field2750) {
                        var16 = client.field448.field2750 + client.field454 - var10.field2750;
                     }

                     var12 = var15;
                     var13 = var16;
                  }

                  if(!var10.field2810) {
                     var14 = 128;
                  }
               }

               int var17;
               int var18;
               int var19;
               int var20;
               int var21;
               int var22;
               if(2 == var10.field2736) {
                  var15 = var2;
                  var16 = var3;
                  var17 = var4;
                  var18 = var5;
               } else if(9 == var10.field2736) {
                  var19 = var12;
                  var20 = var13;
                  var21 = var12 + var10.field2749;
                  var22 = var13 + var10.field2750;
                  if(var21 < var12) {
                     var19 = var21;
                     var21 = var12;
                  }

                  if(var22 < var13) {
                     var20 = var22;
                     var22 = var13;
                  }

                  ++var21;
                  ++var22;
                  var15 = var19 > var2?var19:var2;
                  var16 = var20 > var3?var20:var3;
                  var17 = var21 < var4?var21:var4;
                  var18 = var22 < var5?var22:var5;
               } else {
                  var19 = var10.field2749 + var12;
                  var20 = var10.field2750 + var13;
                  var15 = var12 > var2?var12:var2;
                  var16 = var13 > var3?var13:var3;
                  var17 = var19 < var4?var19:var4;
                  var18 = var20 < var5?var20:var5;
               }

               if(!var10.field2733 || var15 < var17 && var16 < var18) {
                  int var23;
                  int var24;
                  int var27;
                  int var29;
                  int var30;
                  int var31;
                  int var32;
                  int var33;
                  int var34;
                  int var35;
                  int var47;
                  int var49;
                  int var54;
                  if(var10.field2738 != 0) {
                     if(1336 == var10.field2738) {
                        if(client.field292) {
                           var13 += 15;
                           class8.field139.method4076("Fps:" + class143.field2181, var10.field2749 + var12, var13, 16776960, -1);
                           var13 += 15;
                           Runtime var57 = Runtime.getRuntime();
                           var20 = (int)((var57.totalMemory() - var57.freeMemory()) / 1024L);
                           var21 = 16776960;
                           if(var20 > '耀' && client.field527) {
                              var21 = 16711680;
                           }

                           if(var20 > 65536 && !client.field527) {
                              var21 = 16711680;
                           }

                           class8.field139.method4076("Mem:" + var20 + "k", var12 + var10.field2749, var13, var21, -1);
                           var13 += 15;
                        }
                        continue;
                     }

                     class34 var66;
                     class2 var68;
                     if(var10.field2738 == 1337) {
                        client.field423 = var12;
                        client.field424 = var13;
                        var21 = var10.field2749;
                        var22 = var10.field2750;
                        ++client.field381;
                        class6.method112(class33.field753);
                        boolean var67 = false;
                        if(client.field406 >= 0) {
                           var24 = class32.field733;
                           int[] var70 = class32.field730;

                           for(var49 = 0; var49 < var24; ++var49) {
                              if(var70[var49] == client.field406) {
                                 var67 = true;
                                 break;
                              }
                           }
                        }

                        if(var67) {
                           class6.method112(class33.field748);
                        }

                        class38.method806(true);
                        class6.method112(var67?class33.field750:class33.field754);
                        class38.method806(false);

                        for(class6 var73 = (class6)client.field409.method3871(); var73 != null; var73 = (class6)client.field409.method3873()) {
                           if(var73.field95 == class8.field134 && client.field286 <= var73.field100) {
                              if(client.field286 >= var73.field99) {
                                 if(var73.field103 > 0) {
                                    var66 = client.field313[var73.field103 - 1];
                                    if(null != var66 && var66.field846 >= 0 && var66.field846 < 13312 && var66.field834 >= 0 && var66.field834 < 13312) {
                                       var73.method116(var66.field846, var66.field834, class34.method774(var66.field846, var66.field834, var73.field95) - var73.field98, client.field286);
                                    }
                                 }

                                 if(var73.field103 < 0) {
                                    var49 = -var73.field103 - 1;
                                    if(client.field523 == var49) {
                                       var68 = class0.field12;
                                    } else {
                                       var68 = client.field397[var49];
                                    }

                                    if(null != var68 && var68.field846 >= 0 && var68.field846 < 13312 && var68.field834 >= 0 && var68.field834 < 13312) {
                                       var73.method116(var68.field846, var68.field834, class34.method774(var68.field846, var68.field834, var73.field95) - var73.field98, client.field286);
                                    }
                                 }

                                 var73.method103(client.field420);
                                 class24.field610.method1943(class8.field134, (int)var73.field105, (int)var73.field106, (int)var73.field96, 60, var73, var73.field104, -1, false);
                              }
                           } else {
                              var73.method3965();
                           }
                        }

                        class32.method753();
                        class31.method735(var12, var13, var21, var22, true);
                        var19 = client.field536;
                        var20 = client.field435;
                        var21 = client.field538;
                        var22 = client.field539;
                        class79.method1816(var19, var20, var19 + var21, var20 + var22);
                        class90.method2103();
                        if(!client.field334) {
                           var24 = client.field360;
                           if(client.field369 / 256 > var24) {
                              var24 = client.field369 / 256;
                           }

                           if(client.field427[4] && 128 + client.field525[4] > var24) {
                              var24 = 128 + client.field525[4];
                           }

                           var47 = client.field434 + client.field343 & 2047;
                           var49 = class18.field254;
                           var27 = class34.method774(class0.field12.field846, class0.field12.field834, class8.field134) - client.field366;
                           var54 = class24.field609;
                           var29 = 600 + 3 * var24;
                           var30 = 2048 - var24 & 2047;
                           var31 = 2048 - var47 & 2047;
                           var32 = 0;
                           var33 = 0;
                           var34 = var29;
                           int var36;
                           int var37;
                           if(0 != var30) {
                              var35 = class90.field1571[var30];
                              var36 = class90.field1573[var30];
                              var37 = var36 * var33 - var29 * var35 >> 16;
                              var34 = var35 * var33 + var29 * var36 >> 16;
                              var33 = var37;
                           }

                           if(0 != var31) {
                              var35 = class90.field1571[var31];
                              var36 = class90.field1573[var31];
                              var37 = var32 * var36 + var34 * var35 >> 16;
                              var34 = var36 * var34 - var35 * var32 >> 16;
                              var32 = var37;
                           }

                           class29.field672 = var49 - var32;
                           class132.field2053 = var27 - var33;
                           class76.field1374 = var54 - var34;
                           class11.field169 = var24;
                           class83.field1434 = var47;
                        }

                        if(!client.field334) {
                           if(class153.field2277.field142) {
                              var47 = class8.field134;
                           } else {
                              label1808: {
                                 var49 = 3;
                                 if(class11.field169 < 310) {
                                    var27 = class29.field672 >> 7;
                                    var54 = class76.field1374 >> 7;
                                    var29 = class0.field12.field846 >> 7;
                                    var30 = class0.field12.field834 >> 7;
                                    if(var27 < 0 || var54 < 0 || var27 >= 104 || var54 >= 104) {
                                       var47 = class8.field134;
                                       break label1808;
                                    }

                                    if(0 != (class5.field86[class8.field134][var27][var54] & 4)) {
                                       var49 = class8.field134;
                                    }

                                    if(var29 > var27) {
                                       var31 = var29 - var27;
                                    } else {
                                       var31 = var27 - var29;
                                    }

                                    if(var30 > var54) {
                                       var32 = var30 - var54;
                                    } else {
                                       var32 = var54 - var30;
                                    }

                                    if(var31 > var32) {
                                       var33 = 65536 * var32 / var31;
                                       var34 = '耀';

                                       while(var29 != var27) {
                                          if(var27 < var29) {
                                             ++var27;
                                          } else if(var27 > var29) {
                                             --var27;
                                          }

                                          if(0 != (class5.field86[class8.field134][var27][var54] & 4)) {
                                             var49 = class8.field134;
                                          }

                                          var34 += var33;
                                          if(var34 >= 65536) {
                                             var34 -= 65536;
                                             if(var54 < var30) {
                                                ++var54;
                                             } else if(var54 > var30) {
                                                --var54;
                                             }

                                             if((class5.field86[class8.field134][var27][var54] & 4) != 0) {
                                                var49 = class8.field134;
                                             }
                                          }
                                       }
                                    } else {
                                       var33 = var31 * 65536 / var32;
                                       var34 = '耀';

                                       while(var30 != var54) {
                                          if(var54 < var30) {
                                             ++var54;
                                          } else if(var54 > var30) {
                                             --var54;
                                          }

                                          if((class5.field86[class8.field134][var27][var54] & 4) != 0) {
                                             var49 = class8.field134;
                                          }

                                          var34 += var33;
                                          if(var34 >= 65536) {
                                             var34 -= 65536;
                                             if(var27 < var29) {
                                                ++var27;
                                             } else if(var27 > var29) {
                                                --var27;
                                             }

                                             if((class5.field86[class8.field134][var27][var54] & 4) != 0) {
                                                var49 = class8.field134;
                                             }
                                          }
                                       }
                                    }
                                 }

                                 if(class0.field12.field846 >= 0 && class0.field12.field834 >= 0 && class0.field12.field846 < 13312 && class0.field12.field834 < 13312) {
                                    if((class5.field86[class8.field134][class0.field12.field846 >> 7][class0.field12.field834 >> 7] & 4) != 0) {
                                       var49 = class8.field134;
                                    }

                                    var47 = var49;
                                 } else {
                                    var47 = class8.field134;
                                 }
                              }
                           }

                           var24 = var47;
                        } else {
                           var24 = class37.method802();
                        }

                        var47 = class29.field672;
                        var49 = class132.field2053;
                        var27 = class76.field1374;
                        var54 = class11.field169;
                        var29 = class83.field1434;

                        for(var30 = 0; var30 < 5; ++var30) {
                           if(client.field427[var30]) {
                              var31 = (int)(Math.random() * (double)(1 + 2 * client.field524[var30]) - (double)client.field524[var30] + Math.sin((double)client.field474[var30] * ((double)client.field290[var30] / 100.0D)) * (double)client.field525[var30]);
                              if(var30 == 0) {
                                 class29.field672 += var31;
                              }

                              if(1 == var30) {
                                 class132.field2053 += var31;
                              }

                              if(var30 == 2) {
                                 class76.field1374 += var31;
                              }

                              if(3 == var30) {
                                 class83.field1434 = class83.field1434 + var31 & 2047;
                              }

                              if(4 == var30) {
                                 class11.field169 += var31;
                                 if(class11.field169 < 128) {
                                    class11.field169 = 128;
                                 }

                                 if(class11.field169 > 383) {
                                    class11.field169 = 383;
                                 }
                              }
                           }
                        }

                        var30 = class139.field2134;
                        var31 = class139.field2135;
                        if(class139.field2140 != 0) {
                           var30 = class139.field2130;
                           var31 = class139.field2142;
                        }

                        if(var30 >= var19 && var30 < var19 + var21 && var31 >= var20 && var31 < var20 + var22) {
                           class104.field1830 = true;
                           class104.field1833 = 0;
                           class104.field1831 = var30 - var19;
                           class104.field1832 = var31 - var20;
                        } else {
                           class104.field1830 = false;
                           class104.field1833 = 0;
                        }

                        class130.method2869();
                        class79.method1820(var19, var20, var21, var22, 0);
                        class130.method2869();
                        var32 = class90.field1553;
                        class90.field1553 = client.field540;
                        class24.field610.method1970(class29.field672, class132.field2053, class76.field1374, class11.field169, class83.field1434, var24);
                        class90.field1553 = var32;
                        class130.method2869();
                        class24.field610.method1946();
                        class33.method756(var19, var20, var21, var22);
                        class3.method45(var19, var20);
                        ((class94)class90.field1569).method2191(client.field420);
                        class95.method2212();
                        class29.field672 = var47;
                        class132.field2053 = var49;
                        class76.field1374 = var27;
                        class11.field169 = var54;
                        class83.field1434 = var29;
                        if(client.field532 && class50.method1064() == 0) {
                           client.field532 = false;
                        }

                        if(client.field532) {
                           class79.method1820(var19, var20, var21, var22, 0);
                           class40.method880("Loading - please wait.", false);
                        }

                        client.field370[var10.field2863] = true;
                        class79.method1816(var2, var3, var4, var5);
                        continue;
                     }

                     if(var10.field2738 == 1338) {
                        class130.method2869();
                        class174 var55 = var10.method3464(false);
                        if(var55 != null) {
                           class79.method1816(var12, var13, var12 + var55.field2882, var13 + var55.field2877);
                           if(client.field510 != 2 && client.field510 != 5) {
                              var20 = client.field434 + client.field346 & 2047;
                              var21 = class0.field12.field846 / 32 + 48;
                              var22 = 464 - class0.field12.field834 / 32;
                              class97.field1655.method1739(var12, var13, var55.field2882, var55.field2877, var21, var22, var20, 256 + client.field348, var55.field2879, var55.field2878);

                              for(var23 = 0; var23 < client.field504; ++var23) {
                                 var24 = 2 + client.field322[var23] * 4 - class0.field12.field846 / 32;
                                 var47 = 2 + 4 * client.field506[var23] - class0.field12.field834 / 32;
                                 class9.method153(var12, var13, var24, var47, client.field507[var23], var55);
                              }

                              var23 = 0;

                              while(true) {
                                 if(var23 >= 104) {
                                    for(var23 = 0; var23 < client.field314; ++var23) {
                                       class34 var71 = client.field313[client.field315[var23]];
                                       if(null != var71 && var71.vmethod791()) {
                                          class39 var62 = var71.field761;
                                          if(var62 != null && null != var62.field895) {
                                             var62 = var62.method813();
                                          }

                                          if(var62 != null && var62.field886 && var62.field881) {
                                             var49 = var71.field846 / 32 - class0.field12.field846 / 32;
                                             var27 = var71.field834 / 32 - class0.field12.field834 / 32;
                                             class9.method153(var12, var13, var49, var27, class10.field155[1], var55);
                                          }
                                       }
                                    }

                                    var23 = class32.field733;
                                    int[] var72 = class32.field730;

                                    for(var47 = 0; var47 < var23; ++var47) {
                                       class2 var59 = client.field397[var72[var47]];
                                       if(null != var59 && var59.vmethod791() && !var59.field35 && var59 != class0.field12) {
                                          var27 = var59.field846 / 32 - class0.field12.field846 / 32;
                                          var54 = var59.field834 / 32 - class0.field12.field834 / 32;
                                          boolean var69 = false;
                                          if(class8.method138(var59.field34, true)) {
                                             var69 = true;
                                          }

                                          boolean var60 = false;

                                          for(var31 = 0; var31 < class41.field964; ++var31) {
                                             if(var59.field34.equals(class98.field1667[var31].field604)) {
                                                var60 = true;
                                                break;
                                             }
                                          }

                                          boolean var64 = false;
                                          if(class0.field12.field50 != 0 && 0 != var59.field50 && class0.field12.field50 == var59.field50) {
                                             var64 = true;
                                          }

                                          if(var69) {
                                             class9.method153(var12, var13, var27, var54, class10.field155[3], var55);
                                          } else if(var64) {
                                             class9.method153(var12, var13, var27, var54, class10.field155[4], var55);
                                          } else if(var60) {
                                             class9.method153(var12, var13, var27, var54, class10.field155[5], var55);
                                          } else {
                                             class9.method153(var12, var13, var27, var54, class10.field155[2], var55);
                                          }
                                       }
                                    }

                                    if(client.field429 != 0 && client.field286 % 20 < 10) {
                                       if(client.field429 == 1 && client.field311 >= 0 && client.field311 < client.field313.length) {
                                          var66 = client.field313[client.field311];
                                          if(null != var66) {
                                             var49 = var66.field846 / 32 - class0.field12.field846 / 32;
                                             var27 = var66.field834 / 32 - class0.field12.field834 / 32;
                                             class12.method187(var12, var13, var49, var27, client.field353[1], var55);
                                          }
                                       }

                                       if(client.field429 == 2) {
                                          var47 = client.field502 * 4 - class47.field1053 * 4 + 2 - class0.field12.field846 / 32;
                                          var49 = 2 + (client.field437 * 4 - class161.field2629 * 4) - class0.field12.field834 / 32;
                                          class12.method187(var12, var13, var47, var49, client.field353[1], var55);
                                       }

                                       if(client.field429 == 10 && client.field282 >= 0 && client.field282 < client.field397.length) {
                                          var68 = client.field397[client.field282];
                                          if(null != var68) {
                                             var49 = var68.field846 / 32 - class0.field12.field846 / 32;
                                             var27 = var68.field834 / 32 - class0.field12.field834 / 32;
                                             class12.method187(var12, var13, var49, var27, client.field353[1], var55);
                                          }
                                       }
                                    }

                                    if(0 != client.field537) {
                                       var47 = 2 + client.field537 * 4 - class0.field12.field846 / 32;
                                       var49 = 2 + client.field294 * 4 - class0.field12.field834 / 32;
                                       class9.method153(var12, var13, var47, var49, client.field353[0], var55);
                                    }

                                    if(!class0.field12.field35) {
                                       class79.method1820(var12 + var55.field2882 / 2 - 1, var55.field2877 / 2 + var13 - 1, 3, 3, 16777215);
                                    }
                                    break;
                                 }

                                 for(var24 = 0; var24 < 104; ++var24) {
                                    class198 var58 = client.field407[class8.field134][var23][var24];
                                    if(var58 != null) {
                                       var49 = 2 + 4 * var23 - class0.field12.field846 / 32;
                                       var27 = 2 + var24 * 4 - class0.field12.field834 / 32;
                                       class9.method153(var12, var13, var49, var27, class10.field155[0], var55);
                                    }
                                 }

                                 ++var23;
                              }
                           } else {
                              class79.method1818(var12, var13, 0, var55.field2879, var55.field2878);
                           }

                           client.field496[var11] = true;
                        }

                        class79.method1816(var2, var3, var4, var5);
                        continue;
                     }

                     if(var10.field2738 == 1339) {
                        class8.method140(var10, var12, var13);
                        class79.method1816(var2, var3, var4, var5);
                        continue;
                     }
                  }

                  if(var10.field2736 == 0) {
                     if(!var10.field2733 && class153.method3195(var10) && class3.field65 != var10) {
                        continue;
                     }

                     if(!var10.field2733) {
                        if(var10.field2762 > var10.field2765 - var10.field2750) {
                           var10.field2762 = var10.field2765 - var10.field2750;
                        }

                        if(var10.field2762 < 0) {
                           var10.field2762 = 0;
                        }
                     }

                     method2464(var0, var10.field2734 * -1, var15, var16, var17, var18, var12 - var10.field2755, var13 - var10.field2762, var11);
                     if(null != var10.field2806) {
                        method2464(var10.field2806, var10.field2734 * -1, var15, var16, var17, var18, var12 - var10.field2755, var13 - var10.field2762, var11);
                     }

                     class3 var38 = (class3)client.field304.method3836((long)(var10.field2734 * -1));
                     if(var38 != null) {
                        class106.method2419(var38.field63, var15, var16, var17, var18, var12, var13, var11);
                     }

                     class79.method1816(var2, var3, var4, var5);
                     class90.method2103();
                  }

                  if(client.field426 || client.field481[var11] || client.field316 > 1) {
                     if(var10.field2736 == 0 && !var10.field2733 && var10.field2765 > var10.field2750) {
                        var19 = var10.field2749 + var12;
                        var20 = var10.field2762;
                        var21 = var10.field2750;
                        var22 = var10.field2765;
                        class182.field2941[0].method1881(var19, var13);
                        class182.field2941[1].method1881(var19, var21 + var13 - 16);
                        class79.method1820(var19, var13 + 16, 16, var21 - 32, client.field480);
                        var23 = (var21 - 32) * var21 / var22;
                        if(var23 < 8) {
                           var23 = 8;
                        }

                        var24 = var20 * (var21 - 32 - var23) / (var22 - var21);
                        class79.method1820(var19, var24 + var13 + 16, 16, var23, client.field376);
                        class79.method1855(var19, var13 + 16 + var24, var23, client.field278);
                        class79.method1855(var19 + 1, var13 + 16 + var24, var23, client.field278);
                        class79.method1831(var19, 16 + var13 + var24, 16, client.field278);
                        class79.method1831(var19, var13 + 17 + var24, 16, client.field278);
                        class79.method1855(var19 + 15, var24 + var13 + 16, var23, client.field384);
                        class79.method1855(var19 + 14, 17 + var13 + var24, var23 - 1, client.field384);
                        class79.method1831(var19, var23 + var13 + 15 + var24, 16, client.field384);
                        class79.method1831(1 + var19, 14 + var13 + var24 + var23, 15, client.field384);
                     }

                     if(1 != var10.field2736) {
                        if(var10.field2736 == 2) {
                           var19 = 0;

                           for(var20 = 0; var20 < var10.field2746; ++var20) {
                              for(var21 = 0; var21 < var10.field2860; ++var21) {
                                 var22 = (32 + var10.field2761) * var21 + var12;
                                 var23 = var13 + (32 + var10.field2799) * var20;
                                 if(var19 < 20) {
                                    var22 += var10.field2800[var19];
                                    var23 += var10.field2801[var19];
                                 }

                                 if(var10.field2850[var19] <= 0) {
                                    if(null != var10.field2819 && var19 < 20) {
                                       class78 var65 = var10.method3469(var19);
                                       if(null != var65) {
                                          var65.method1730(var22, var23);
                                       } else if(class172.field2745) {
                                          class42.method942(var10);
                                       }
                                    }
                                 } else {
                                    boolean var61 = false;
                                    boolean var52 = false;
                                    var49 = var10.field2850[var19] - 1;
                                    if(var22 + 32 > var2 && var22 < var4 && 32 + var23 > var3 && var23 < var5 || var10 == class1.field26 && client.field390 == var19) {
                                       class78 var53;
                                       if(1 == client.field398 && var19 == class219.field3155 && var10.field2734 * -1 == class98.field1660) {
                                          var53 = class129.method2865(var49, var10.field2851[var19], 2, 0, 2, false);
                                       } else {
                                          var53 = class129.method2865(var49, var10.field2851[var19], 1, 3153952, 2, false);
                                       }

                                       if(var53 != null) {
                                          if(var10 == class1.field26 && client.field390 == var19) {
                                             var24 = class139.field2134 - client.field391;
                                             var47 = class139.field2135 - client.field509;
                                             if(var24 < 5 && var24 > -5) {
                                                var24 = 0;
                                             }

                                             if(var47 < 5 && var47 > -5) {
                                                var47 = 0;
                                             }

                                             if(client.field489 < 5) {
                                                var24 = 0;
                                                var47 = 0;
                                             }

                                             var53.method1791(var24 + var22, var47 + var23, 128);
                                             if(var1 != -1) {
                                                class172 var56 = var0[var1 & '\uffff'];
                                                if(var23 + var47 < class79.field1403 && var56.field2762 > 0) {
                                                   var29 = client.field420 * (class79.field1403 - var23 - var47) / 3;
                                                   if(var29 > client.field420 * 10) {
                                                      var29 = client.field420 * 10;
                                                   }

                                                   if(var29 > var56.field2762) {
                                                      var29 = var56.field2762;
                                                   }

                                                   var56.field2762 -= var29;
                                                   client.field509 += var29;
                                                   class42.method942(var56);
                                                }

                                                if(var47 + var23 + 32 > class79.field1402 && var56.field2762 < var56.field2765 - var56.field2750) {
                                                   var29 = client.field420 * (32 + var47 + var23 - class79.field1402) / 3;
                                                   if(var29 > client.field420 * 10) {
                                                      var29 = client.field420 * 10;
                                                   }

                                                   if(var29 > var56.field2765 - var56.field2750 - var56.field2762) {
                                                      var29 = var56.field2765 - var56.field2750 - var56.field2762;
                                                   }

                                                   var56.field2762 += var29;
                                                   client.field509 -= var29;
                                                   class42.method942(var56);
                                                }
                                             }
                                          } else if(var10 == class10.field156 && var19 == client.field389) {
                                             var53.method1791(var22, var23, 128);
                                          } else {
                                             var53.method1730(var22, var23);
                                          }
                                       } else {
                                          class42.method942(var10);
                                       }
                                    }
                                 }

                                 ++var19;
                              }
                           }
                        } else if(3 == var10.field2736) {
                           if(class161.method3232(var10)) {
                              var19 = var10.field2839;
                              if(var10 == class3.field65 && var10.field2767 != 0) {
                                 var19 = var10.field2767;
                              }
                           } else {
                              var19 = var10.field2824;
                              if(class3.field65 == var10 && var10.field2813 != 0) {
                                 var19 = var10.field2813;
                              }
                           }

                           if(0 == var14) {
                              if(var10.field2763) {
                                 class79.method1820(var12, var13, var10.field2749, var10.field2750, var19);
                              } else {
                                 class79.method1815(var12, var13, var10.field2749, var10.field2750, var19);
                              }
                           } else if(var10.field2763) {
                              class79.method1821(var12, var13, var10.field2749, var10.field2750, var19, 256 - (var14 & 255));
                           } else {
                              class79.method1825(var12, var13, var10.field2749, var10.field2750, var19, 256 - (var14 & 255));
                           }
                        } else {
                           String var26;
                           class223 var39;
                           String var45;
                           String var46;
                           if(var10.field2736 == 4) {
                              var39 = var10.method3468();
                              if(var39 == null) {
                                 if(class172.field2745) {
                                    class42.method942(var10);
                                 }
                              } else {
                                 String var51 = var10.field2756;
                                 if(class161.method3232(var10)) {
                                    var20 = var10.field2839;
                                    if(var10 == class3.field65 && var10.field2767 != 0) {
                                       var20 = var10.field2767;
                                    }

                                    if(var10.field2793.length() > 0) {
                                       var51 = var10.field2793;
                                    }
                                 } else {
                                    var20 = var10.field2824;
                                    if(var10 == class3.field65 && var10.field2813 != 0) {
                                       var20 = var10.field2813;
                                    }
                                 }

                                 if(var10.field2733 && var10.field2852 != -1) {
                                    class51 var63 = class10.method158(var10.field2852);
                                    var51 = var63.field1099;
                                    if(var51 == null) {
                                       var51 = "null";
                                    }

                                    if((1 == var63.field1110 || var10.field2853 != 1) && var10.field2853 != -1) {
                                       var45 = class74.method1617(16748608) + var51 + "</col>" + " " + 'x';
                                       var47 = var10.field2853;
                                       var26 = Integer.toString(var47);

                                       for(var27 = var26.length() - 3; var27 > 0; var27 -= 3) {
                                          var26 = var26.substring(0, var27) + "," + var26.substring(var27);
                                       }

                                       StringBuilder var10000;
                                       class156 var10001;
                                       if(var26.length() > 9) {
                                          var10000 = (new StringBuilder()).append(" ").append(class74.method1617('ﾀ')).append(var26.substring(0, var26.length() - 8));
                                          var10001 = (class156)null;
                                          var46 = var10000.append("M").append(" ").append(" (").append(var26).append(")").append("</col>").toString();
                                       } else if(var26.length() > 6) {
                                          var10000 = (new StringBuilder()).append(" ").append(class74.method1617(16777215)).append(var26.substring(0, var26.length() - 4));
                                          var10001 = (class156)null;
                                          var46 = var10000.append("K").append(" ").append(" (").append(var26).append(")").append("</col>").toString();
                                       } else {
                                          var46 = " " + class74.method1617(16776960) + var26 + "</col>";
                                       }

                                       var51 = var45 + var46;
                                    }
                                 }

                                 if(var10 == client.field545) {
                                    class156 var74 = (class156)null;
                                    var51 = "Please wait...";
                                    var20 = var10.field2824;
                                 }

                                 if(!var10.field2733) {
                                    var51 = class15.method203(var51, var10);
                                 }

                                 var39.method4078(var51, var12, var13, var10.field2749, var10.field2750, var20, var10.field2744?0:-1, var10.field2795, var10.field2796, var10.field2788);
                              }
                           } else if(5 == var10.field2736) {
                              class78 var42;
                              if(!var10.field2733) {
                                 var42 = var10.method3467(class161.method3232(var10));
                                 if(null != var42) {
                                    var42.method1730(var12, var13);
                                 } else if(class172.field2745) {
                                    class42.method942(var10);
                                 }
                              } else {
                                 if(var10.field2852 != -1) {
                                    var42 = class129.method2865(var10.field2852, var10.field2853, var10.field2771, var10.field2772, var10.field2779, false);
                                 } else {
                                    var42 = var10.method3467(false);
                                 }

                                 if(var42 == null) {
                                    if(class172.field2745) {
                                       class42.method942(var10);
                                    }
                                 } else {
                                    var20 = var42.field1388;
                                    var21 = var42.field1399;
                                    if(!var10.field2770) {
                                       var22 = var10.field2749 * 4096 / var20;
                                       if(var10.field2769 != 0) {
                                          var42.method1742(var12 + var10.field2749 / 2, var13 + var10.field2750 / 2, var10.field2769, var22);
                                       } else if(0 != var14) {
                                          var42.method1737(var12, var13, var10.field2749, var10.field2750, 256 - (var14 & 255));
                                       } else if(var10.field2749 == var20 && var21 == var10.field2750) {
                                          var42.method1730(var12, var13);
                                       } else {
                                          var42.method1731(var12, var13, var10.field2749, var10.field2750);
                                       }
                                    } else {
                                       class79.method1817(var12, var13, var12 + var10.field2749, var13 + var10.field2750);
                                       var22 = (var20 - 1 + var10.field2749) / var20;
                                       var23 = (var21 - 1 + var10.field2750) / var21;

                                       for(var24 = 0; var24 < var22; ++var24) {
                                          for(var47 = 0; var47 < var23; ++var47) {
                                             if(0 != var10.field2769) {
                                                var42.method1742(var20 / 2 + var12 + var20 * var24, var21 / 2 + var13 + var47 * var21, var10.field2769, 4096);
                                             } else if(0 != var14) {
                                                var42.method1791(var12 + var24 * var20, var13 + var47 * var21, 256 - (var14 & 255));
                                             } else {
                                                var42.method1730(var20 * var24 + var12, var13 + var21 * var47);
                                             }
                                          }
                                       }

                                       class79.method1816(var2, var3, var4, var5);
                                    }
                                 }
                              }
                           } else {
                              class51 var43;
                              if(6 == var10.field2736) {
                                 boolean var41 = class161.method3232(var10);
                                 if(var41) {
                                    var20 = var10.field2780;
                                 } else {
                                    var20 = var10.field2802;
                                 }

                                 class104 var48 = null;
                                 var22 = 0;
                                 if(-1 != var10.field2852) {
                                    var43 = class10.method158(var10.field2852);
                                    if(var43 != null) {
                                       var43 = var43.method1074(var10.field2853);
                                       var48 = var43.method1073(1);
                                       if(null != var48) {
                                          var48.method2334();
                                          var22 = var48.field1441 / 2;
                                       } else {
                                          class42.method942(var10);
                                       }
                                    }
                                 } else if(var10.field2777 == 5) {
                                    if(var10.field2776 == 0) {
                                       var48 = client.field547.method3543((class42)null, -1, (class42)null, -1);
                                    } else {
                                       var48 = class0.field12.vmethod1921();
                                    }
                                 } else if(var20 == -1) {
                                    var48 = var10.method3470((class42)null, -1, var41, class0.field12.field31);
                                    if(var48 == null && class172.field2745) {
                                       class42.method942(var10);
                                    }
                                 } else {
                                    class42 var50 = client.method584(var20);
                                    var48 = var10.method3470(var50, var10.field2854, var41, class0.field12.field31);
                                    if(null == var48 && class172.field2745) {
                                       class42.method942(var10);
                                    }
                                 }

                                 class90.method2106(var10.field2749 / 2 + var12, var13 + var10.field2750 / 2);
                                 var23 = var10.field2787 * class90.field1571[var10.field2783] >> 16;
                                 var24 = var10.field2787 * class90.field1573[var10.field2783] >> 16;
                                 if(var48 != null) {
                                    if(!var10.field2733) {
                                       var48.method2379(0, var10.field2760, 0, var10.field2783, 0, var23, var24);
                                    } else {
                                       var48.method2334();
                                       if(var10.field2753) {
                                          var48.method2347(0, var10.field2760, var10.field2785, var10.field2783, var10.field2781, var10.field2782 + var22 + var23, var24 + var10.field2782, var10.field2787);
                                       } else {
                                          var48.method2379(0, var10.field2760, var10.field2785, var10.field2783, var10.field2781, var10.field2782 + var22 + var23, var24 + var10.field2782);
                                       }
                                    }
                                 }

                                 class90.method2105();
                              } else {
                                 if(7 == var10.field2736) {
                                    var39 = var10.method3468();
                                    if(var39 == null) {
                                       if(class172.field2745) {
                                          class42.method942(var10);
                                       }
                                       continue;
                                    }

                                    var20 = 0;

                                    for(var21 = 0; var21 < var10.field2746; ++var21) {
                                       for(var22 = 0; var22 < var10.field2860; ++var22) {
                                          if(var10.field2850[var20] > 0) {
                                             var43 = class10.method158(var10.field2850[var20] - 1);
                                             if(var43.field1110 != 1 && 1 == var10.field2851[var20]) {
                                                var46 = class74.method1617(16748608) + var43.field1099 + "</col>";
                                             } else {
                                                String var25 = class74.method1617(16748608) + var43.field1099 + "</col>" + " " + 'x';
                                                var27 = var10.field2851[var20];
                                                String var28 = Integer.toString(var27);

                                                for(var29 = var28.length() - 3; var29 > 0; var29 -= 3) {
                                                   var28 = var28.substring(0, var29) + "," + var28.substring(var29);
                                                }

                                                if(var28.length() > 9) {
                                                   var26 = " " + class74.method1617('ﾀ') + var28.substring(0, var28.length() - 8) + "M" + " " + " (" + var28 + ")" + "</col>";
                                                } else if(var28.length() > 6) {
                                                   var26 = " " + class74.method1617(16777215) + var28.substring(0, var28.length() - 4) + "K" + " " + " (" + var28 + ")" + "</col>";
                                                } else {
                                                   var26 = " " + class74.method1617(16776960) + var28 + "</col>";
                                                }

                                                var46 = var25 + var26;
                                             }

                                             var47 = var22 * (115 + var10.field2761) + var12;
                                             var49 = (var10.field2799 + 12) * var21 + var13;
                                             if(var10.field2795 == 0) {
                                                var39.method4074(var46, var47, var49, var10.field2824, var10.field2744?0:-1);
                                             } else if(1 == var10.field2795) {
                                                var39.method4077(var46, var10.field2749 / 2 + var47, var49, var10.field2824, var10.field2744?0:-1);
                                             } else {
                                                var39.method4076(var46, var47 + var10.field2749 - 1, var49, var10.field2824, var10.field2744?0:-1);
                                             }
                                          }

                                          ++var20;
                                       }
                                    }
                                 }

                                 if(8 == var10.field2736 && var10 == class8.field140 && client.field285 == client.field425) {
                                    var19 = 0;
                                    var20 = 0;
                                    class223 var40 = class8.field139;
                                    String var44 = var10.field2756;

                                    for(var44 = class15.method203(var44, var10); var44.length() > 0; var20 += 1 + var40.field3182) {
                                       var24 = var44.indexOf("<br>");
                                       if(var24 != -1) {
                                          var45 = var44.substring(0, var24);
                                          var44 = var44.substring(4 + var24);
                                       } else {
                                          var45 = var44;
                                          var44 = "";
                                       }

                                       var47 = var40.method4161(var45);
                                       if(var47 > var19) {
                                          var19 = var47;
                                       }
                                    }

                                    var19 += 6;
                                    var20 += 7;
                                    var24 = var10.field2749 + var12 - 5 - var19;
                                    var47 = var13 + var10.field2750 + 5;
                                    if(var24 < 5 + var12) {
                                       var24 = var12 + 5;
                                    }

                                    if(var24 + var19 > var4) {
                                       var24 = var4 - var19;
                                    }

                                    if(var20 + var47 > var5) {
                                       var47 = var5 - var20;
                                    }

                                    class79.method1820(var24, var47, var19, var20, 16777120);
                                    class79.method1815(var24, var47, var19, var20, 0);
                                    var44 = var10.field2756;
                                    var49 = var40.field3182 + var47 + 2;

                                    for(var44 = class15.method203(var44, var10); var44.length() > 0; var49 += 1 + var40.field3182) {
                                       var27 = var44.indexOf("<br>");
                                       if(-1 != var27) {
                                          var45 = var44.substring(0, var27);
                                          var44 = var44.substring(var27 + 4);
                                       } else {
                                          var45 = var44;
                                          var44 = "";
                                       }

                                       var40.method4074(var45, 3 + var24, var49, 0, -1);
                                    }
                                 }

                                 if(9 == var10.field2736) {
                                    if(var10.field2832 == 1) {
                                       if(var10.field2808) {
                                          var19 = var12;
                                          var20 = var10.field2750 + var13;
                                          var21 = var12 + var10.field2749;
                                          var22 = var13;
                                       } else {
                                          var19 = var12;
                                          var20 = var13;
                                          var21 = var10.field2749 + var12;
                                          var22 = var13 + var10.field2750;
                                       }

                                       class79.method1830(var19, var20, var21, var22, var10.field2824);
                                    } else {
                                       var19 = var10.field2749 >= 0?var10.field2749:-var10.field2749;
                                       var20 = var10.field2750 >= 0?var10.field2750:-var10.field2750;
                                       var21 = var19;
                                       if(var19 < var20) {
                                          var21 = var20;
                                       }

                                       if(0 != var21) {
                                          var22 = (var10.field2749 << 16) / var21;
                                          var23 = (var10.field2750 << 16) / var21;
                                          if(var23 <= var22) {
                                             var22 = -var22;
                                          } else {
                                             var23 = -var23;
                                          }

                                          var24 = var23 * var10.field2832 >> 17;
                                          var47 = 1 + var23 * var10.field2832 >> 17;
                                          var49 = var22 * var10.field2832 >> 17;
                                          var27 = 1 + var22 * var10.field2832 >> 17;
                                          var54 = var24 + var12;
                                          var29 = var12 - var47;
                                          var30 = var12 + var10.field2749 - var47;
                                          var31 = var24 + var12 + var10.field2749;
                                          var32 = var49 + var13;
                                          var33 = var13 - var27;
                                          var34 = var13 + var10.field2750 - var27;
                                          var35 = var49 + var10.field2750 + var13;
                                          class90.method2147(var54, var29, var30);
                                          class90.method2114(var32, var33, var34, var54, var29, var30, var10.field2824);
                                          class90.method2147(var54, var30, var31);
                                          class90.method2114(var32, var34, var35, var54, var30, var31, var10.field2824);
                                       }
                                    }
                                 }
                              }
                           }
                        }
                     }
                  }
               }
            }
         }
      }

   }

   @ObfuscatedName("af")
   static final void method2467(boolean var0) {
      client.field336 = var0;
      int var1;
      int var2;
      int var3;
      int var4;
      int var5;
      int var6;
      int var7;
      if(!client.field336) {
         var1 = client.field320.method2572();
         var2 = client.field320.method2571();
         var3 = client.field320.method2538();
         class13.field197 = new int[var3][4];

         for(var4 = 0; var4 < var3; ++var4) {
            for(var5 = 0; var5 < 4; ++var5) {
               class13.field197[var4][var5] = client.field320.method2541();
            }
         }

         class47.field1051 = new int[var3];
         class46.field1044 = new int[var3];
         class92.field1575 = new int[var3];
         class76.field1377 = new byte[var3][];
         class19.field270 = new byte[var3][];
         boolean var13 = false;
         if((48 == var2 / 8 || var2 / 8 == 49) && 48 == var1 / 8) {
            var13 = true;
         }

         if(48 == var2 / 8 && 148 == var1 / 8) {
            var13 = true;
         }

         var3 = 0;

         for(var5 = (var2 - 6) / 8; var5 <= (6 + var2) / 8; ++var5) {
            for(var6 = (var1 - 6) / 8; var6 <= (var1 + 6) / 8; ++var6) {
               var7 = (var5 << 8) + var6;
               if(!var13 || 49 != var6 && var6 != 149 && var6 != 147 && 50 != var5 && (var5 != 49 || 47 != var6)) {
                  class47.field1051[var3] = var7;
                  class46.field1044[var3] = class12.field185.method3327("m" + var5 + "_" + var6);
                  class92.field1575[var3] = class12.field185.method3327("l" + var5 + "_" + var6);
                  ++var3;
               }
            }
         }

         class132.method2895(var2, var1);
      } else {
         var1 = client.field320.method2572();
         var2 = client.field320.method2570();
         var3 = client.field320.method2538();
         client.field320.method2787();

         for(var4 = 0; var4 < 4; ++var4) {
            for(var5 = 0; var5 < 13; ++var5) {
               for(var6 = 0; var6 < 13; ++var6) {
                  var7 = client.field320.method2786(1);
                  if(1 == var7) {
                     client.field337[var4][var5][var6] = client.field320.method2786(26);
                  } else {
                     client.field337[var4][var5][var6] = -1;
                  }
               }
            }
         }

         client.field320.method2800();
         class13.field197 = new int[var3][4];

         for(var4 = 0; var4 < var3; ++var4) {
            for(var5 = 0; var5 < 4; ++var5) {
               class13.field197[var4][var5] = client.field320.method2541();
            }
         }

         class47.field1051 = new int[var3];
         class46.field1044 = new int[var3];
         class92.field1575 = new int[var3];
         class76.field1377 = new byte[var3][];
         class19.field270 = new byte[var3][];
         var3 = 0;

         for(var4 = 0; var4 < 4; ++var4) {
            for(var5 = 0; var5 < 13; ++var5) {
               for(var6 = 0; var6 < 13; ++var6) {
                  var7 = client.field337[var4][var5][var6];
                  if(var7 != -1) {
                     int var8 = var7 >> 14 & 1023;
                     int var9 = var7 >> 3 & 2047;
                     int var10 = (var8 / 8 << 8) + var9 / 8;

                     int var11;
                     for(var11 = 0; var11 < var3; ++var11) {
                        if(var10 == class47.field1051[var11]) {
                           var10 = -1;
                           break;
                        }
                     }

                     if(var10 != -1) {
                        class47.field1051[var3] = var10;
                        var11 = var10 >> 8 & 255;
                        int var12 = var10 & 255;
                        class46.field1044[var3] = class12.field185.method3327("m" + var11 + "_" + var12);
                        class92.field1575[var3] = class12.field185.method3327("l" + var11 + "_" + var12);
                        ++var3;
                     }
                  }
               }
            }
         }

         class132.method2895(var2, var1);
      }

   }
}
