import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("br")
public class class72 implements Runnable {
   @ObfuscatedName("j")
   volatile boolean field1315 = false;
   @ObfuscatedName("g")
   volatile class56[] field1317 = new class56[2];
   @ObfuscatedName("d")
   volatile boolean field1318 = false;
   @ObfuscatedName("iy")
   @ObfuscatedGetter(
      intValue = 322251947
   )
   static int field1325;
   @ObfuscatedName("b")
   class136 field1327;

   @ObfuscatedName("cs")
   @ObfuscatedSignature(
      signature = "([Lclass173;IIIIIIIIB)V",
      garbageValue = "2"
   )
   @Export("gameDraw")
   static final void method1597(class173[] var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
      class79.method1793(var2, var3, var4, var5);
      class91.method2126();

      for(int var9 = 0; var9 < var0.length; ++var9) {
         class173 var10 = var0[var9];
         if(var10 != null && (var1 == var10.field2777 || var1 == -1412584499 && var10 == client.field460)) {
            int var11;
            if(var8 == -1) {
               client.field495[client.field490] = var10.field2796 + var6;
               client.field496[client.field490] = var7 + var10.field2823;
               client.field497[client.field490] = var10.field2763;
               client.field498[client.field490] = var10.field2764;
               var11 = ++client.field490 - 1;
            } else {
               var11 = var8;
            }

            var10.field2879 = var11;
            var10.field2880 = client.field296;
            if(!var10.field2741 || !class12.method150(var10)) {
               int var12;
               if(var10.field2768 > 0) {
                  var12 = var10.field2768;
                  if(var12 == 324) {
                     if(client.field561 == -1) {
                        client.field561 = var10.field2783;
                        client.field517 = var10.field2757;
                     }

                     if(client.field339.field2913) {
                        var10.field2783 = client.field561;
                     } else {
                        var10.field2783 = client.field517;
                     }
                  } else if(var12 == 325) {
                     if(client.field561 == -1) {
                        client.field561 = var10.field2783;
                        client.field517 = var10.field2757;
                     }

                     if(client.field339.field2913) {
                        var10.field2783 = client.field517;
                     } else {
                        var10.field2783 = client.field561;
                     }
                  } else if(var12 == 327) {
                     var10.field2839 = 150;
                     var10.field2800 = (int)(Math.sin((double)client.field296 / 40.0D) * 256.0D) & 2047;
                     var10.field2791 = 5;
                     var10.field2792 = 0;
                  } else if(var12 == 328) {
                     var10.field2839 = 150;
                     var10.field2800 = (int)(Math.sin((double)client.field296 / 40.0D) * 256.0D) & 2047;
                     var10.field2791 = 5;
                     var10.field2792 = 1;
                  }
               }

               var12 = var6 + var10.field2796;
               int var13 = var10.field2823 + var7;
               int var14 = var10.field2830;
               int var15;
               int var16;
               if(var10 == client.field460) {
                  if(var1 != -1412584499 && !var10.field2826) {
                     class42.field968 = var0;
                     class101.field1740 = var6;
                     class7.field125 = var7;
                     continue;
                  }

                  if(client.field545 && client.field465) {
                     var15 = class140.field2134;
                     var16 = class140.field2135;
                     var15 -= client.field560;
                     var16 -= client.field463;
                     if(var15 < client.field440) {
                        var15 = client.field440;
                     }

                     if(var15 + var10.field2763 > client.field440 + client.field461.field2763) {
                        var15 = client.field461.field2763 + client.field440 - var10.field2763;
                     }

                     if(var16 < client.field447) {
                        var16 = client.field447;
                     }

                     if(var16 + var10.field2764 > client.field447 + client.field461.field2764) {
                        var16 = client.field447 + client.field461.field2764 - var10.field2764;
                     }

                     var12 = var15;
                     var13 = var16;
                  }

                  if(!var10.field2826) {
                     var14 = 128;
                  }
               }

               int var17;
               int var18;
               int var19;
               int var20;
               int var21;
               int var39;
               if(var10.field2833 == 2) {
                  var15 = var2;
                  var16 = var3;
                  var17 = var4;
                  var18 = var5;
               } else if(var10.field2833 == 9) {
                  var19 = var12;
                  var20 = var13;
                  var21 = var12 + var10.field2763;
                  var39 = var10.field2764 + var13;
                  if(var21 < var12) {
                     var19 = var21;
                     var21 = var12;
                  }

                  if(var39 < var13) {
                     var20 = var39;
                     var39 = var13;
                  }

                  ++var21;
                  ++var39;
                  var15 = var19 > var2?var19:var2;
                  var16 = var20 > var3?var20:var3;
                  var17 = var21 < var4?var21:var4;
                  var18 = var39 < var5?var39:var5;
               } else {
                  var19 = var12 + var10.field2763;
                  var20 = var13 + var10.field2764;
                  var15 = var12 > var2?var12:var2;
                  var16 = var13 > var3?var13:var3;
                  var17 = var19 < var4?var19:var4;
                  var18 = var20 < var5?var20:var5;
               }

               if(!var10.field2741 || var15 < var17 && var16 < var18) {
                  int var23;
                  int var24;
                  int var25;
                  int var27;
                  int var28;
                  int var31;
                  int var42;
                  if(var10.field2768 != 0) {
                     if(var10.field2768 == 1336) {
                        if(client.field302) {
                           var13 += 15;
                           class44.field1021.method4034("Fps:" + class144.field2181, var12 + var10.field2763, var13, 16776960, -1);
                           var13 += 15;
                           Runtime var63 = Runtime.getRuntime();
                           var20 = (int)((var63.totalMemory() - var63.freeMemory()) / 1024L);
                           var21 = 16776960;
                           if(var20 > '耀' && client.field383) {
                              var21 = 16711680;
                           }

                           if(var20 > 65536 && !client.field383) {
                              var21 = 16711680;
                           }

                           class44.field1021.method4034("Mem:" + var20 + "k", var10.field2763 + var12, var13, var21, -1);
                           var13 += 15;
                        }
                        continue;
                     }

                     if(var10.field2768 == 1337) {
                        client.field436 = var12;
                        client.field437 = var13;
                        class95.method2191(var12, var13, var10.field2763, var10.field2764);
                        client.field507[var10.field2879] = true;
                        class79.method1793(var2, var3, var4, var5);
                        continue;
                     }

                     class175 var62;
                     if(var10.field2768 == 1338) {
                        class124.method2824();
                        var62 = var10.method3409(false);
                        if(null != var62) {
                           class79.method1793(var12, var13, var12 + var62.field2888, var13 + var62.field2889);
                           if(client.field493 != 2 && client.field493 != 5) {
                              var20 = client.field360 + client.field322 & 2047;
                              var21 = class153.field2262.field813 / 32 + 48;
                              var39 = 464 - class153.field2262.field791 / 32;
                              class44.field1017.method1725(var12, var13, var62.field2888, var62.field2889, var21, var39, var20, 256 + client.field558, var62.field2891, var62.field2892);

                              for(var23 = 0; var23 < client.field373; ++var23) {
                                 var24 = 2 + client.field293[var23] * 4 - class153.field2262.field813 / 32;
                                 var25 = 2 + 4 * client.field387[var23] - class153.field2262.field791 / 32;
                                 class126.method2848(var12, var13, var24, var25, client.field520[var23], var62);
                              }

                              var23 = 0;

                              while(true) {
                                 if(var23 >= 104) {
                                    for(var23 = 0; var23 < client.field449; ++var23) {
                                       class34 var56 = client.field326[client.field318[var23]];
                                       if(var56 != null && var56.vmethod760()) {
                                          class39 var53 = var56.field762;
                                          if(var53 != null && null != var53.field889) {
                                             var53 = var53.method773();
                                          }

                                          if(null != var53 && var53.field880 && var53.field892) {
                                             var42 = var56.field813 / 32 - class153.field2262.field813 / 32;
                                             var27 = var56.field791 / 32 - class153.field2262.field791 / 32;
                                             class126.method2848(var12, var13, var42, var27, class221.field3180[1], var62);
                                          }
                                       }
                                    }

                                    var23 = class32.field738;
                                    int[] var57 = class32.field739;

                                    for(var25 = 0; var25 < var23; ++var25) {
                                       class2 var26 = client.field410[var57[var25]];
                                       if(null != var26 && var26.vmethod760() && !var26.field40 && var26 != class153.field2262) {
                                          var27 = var26.field813 / 32 - class153.field2262.field813 / 32;
                                          var28 = var26.field791 / 32 - class153.field2262.field791 / 32;
                                          boolean var51 = false;
                                          if(class11.method147(var26.field26, true)) {
                                             var51 = true;
                                          }

                                          boolean var49 = false;

                                          for(var31 = 0; var31 < class116.field1957; ++var31) {
                                             if(var26.field26.equals(class40.field923[var31].field617)) {
                                                var49 = true;
                                                break;
                                             }
                                          }

                                          boolean var50 = false;
                                          if(class153.field2262.field45 != 0 && var26.field45 != 0 && var26.field45 == class153.field2262.field45) {
                                             var50 = true;
                                          }

                                          if(var51) {
                                             class126.method2848(var12, var13, var27, var28, class221.field3180[3], var62);
                                          } else if(var50) {
                                             class126.method2848(var12, var13, var27, var28, class221.field3180[4], var62);
                                          } else if(var49) {
                                             class126.method2848(var12, var13, var27, var28, class221.field3180[5], var62);
                                          } else {
                                             class126.method2848(var12, var13, var27, var28, class221.field3180[2], var62);
                                          }
                                       }
                                    }

                                    if(client.field323 != 0 && client.field296 % 20 < 10) {
                                       if(client.field323 == 1 && client.field305 >= 0 && client.field305 < client.field326.length) {
                                          class34 var58 = client.field326[client.field305];
                                          if(var58 != null) {
                                             var42 = var58.field813 / 32 - class153.field2262.field813 / 32;
                                             var27 = var58.field791 / 32 - class153.field2262.field791 / 32;
                                             class11.method146(var12, var13, var42, var27, class216.field3158[1], var62);
                                          }
                                       }

                                       if(client.field323 == 2) {
                                          var25 = 2 + (client.field307 * 4 - class4.field62 * 4) - class153.field2262.field813 / 32;
                                          var42 = client.field308 * 4 - class85.field1434 * 4 + 2 - class153.field2262.field791 / 32;
                                          class11.method146(var12, var13, var25, var42, class216.field3158[1], var62);
                                       }

                                       if(client.field323 == 10 && client.field306 >= 0 && client.field306 < client.field410.length) {
                                          class2 var59 = client.field410[client.field306];
                                          if(var59 != null) {
                                             var42 = var59.field813 / 32 - class153.field2262.field813 / 32;
                                             var27 = var59.field791 / 32 - class153.field2262.field791 / 32;
                                             class11.method146(var12, var13, var42, var27, class216.field3158[1], var62);
                                          }
                                       }
                                    }

                                    if(client.field521 != 0) {
                                       var25 = 2 + client.field521 * 4 - class153.field2262.field813 / 32;
                                       var42 = 2 + client.field522 * 4 - class153.field2262.field791 / 32;
                                       class126.method2848(var12, var13, var25, var42, class216.field3158[0], var62);
                                    }

                                    if(!class153.field2262.field40) {
                                       class79.method1865(var62.field2888 / 2 + var12 - 1, var13 + var62.field2889 / 2 - 1, 3, 3, 16777215);
                                    }
                                    break;
                                 }

                                 for(var24 = 0; var24 < 104; ++var24) {
                                    class199 var38 = client.field420[class144.field2193][var23][var24];
                                    if(null != var38) {
                                       var42 = var23 * 4 + 2 - class153.field2262.field813 / 32;
                                       var27 = 2 + 4 * var24 - class153.field2262.field791 / 32;
                                       class126.method2848(var12, var13, var42, var27, class221.field3180[0], var62);
                                    }
                                 }

                                 ++var23;
                              }
                           } else {
                              class79.method1858(var12, var13, 0, var62.field2891, var62.field2892);
                           }

                           client.field283[var11] = true;
                        }

                        class79.method1793(var2, var3, var4, var5);
                        continue;
                     }

                     if(var10.field2768 == 1339) {
                        var62 = var10.method3409(false);
                        if(null != var62) {
                           if(client.field493 < 3) {
                              class153.field2263.method1725(var12, var13, var62.field2888, var62.field2889, 25, 25, client.field322, 256, var62.field2891, var62.field2892);
                           } else {
                              class79.method1858(var12, var13, 0, var62.field2891, var62.field2892);
                           }
                        }

                        class79.method1793(var2, var3, var4, var5);
                        continue;
                     }
                  }

                  if(var10.field2833 == 0) {
                     if(!var10.field2741 && class12.method150(var10) && var10 != class172.field2732) {
                        continue;
                     }

                     if(!var10.field2741) {
                        if(var10.field2770 > var10.field2772 - var10.field2764) {
                           var10.field2770 = var10.field2772 - var10.field2764;
                        }

                        if(var10.field2770 < 0) {
                           var10.field2770 = 0;
                        }
                     }

                     method1597(var0, var10.field2748, var15, var16, var17, var18, var12 - var10.field2863, var13 - var10.field2770, var11);
                     if(var10.field2872 != null) {
                        method1597(var10.field2872, var10.field2748, var15, var16, var17, var18, var12 - var10.field2863, var13 - var10.field2770, var11);
                     }

                     class3 var40 = (class3)client.field448.method3807((long)var10.field2748);
                     if(var40 != null) {
                        client.method272(var40.field60, var15, var16, var17, var18, var12, var13, var11);
                     }

                     class79.method1793(var2, var3, var4, var5);
                     class91.method2126();
                  }

                  if(client.field501 || client.field494[var11] || client.field499 > 1) {
                     if(var10.field2833 == 0 && !var10.field2741 && var10.field2772 > var10.field2764) {
                        class130.method2858(var10.field2763 + var12, var13, var10.field2770, var10.field2764, var10.field2772);
                     }

                     if(var10.field2833 != 1) {
                        int var29;
                        if(var10.field2833 == 2) {
                           var19 = 0;

                           for(var20 = 0; var20 < var10.field2765; ++var20) {
                              for(var21 = 0; var21 < var10.field2759; ++var21) {
                                 var39 = var21 * (var10.field2814 + 32) + var12;
                                 var23 = var20 * (var10.field2815 + 32) + var13;
                                 if(var19 < 20) {
                                    var39 += var10.field2816[var19];
                                    var23 += var10.field2817[var19];
                                 }

                                 if(var10.field2866[var19] <= 0) {
                                    if(var10.field2795 != null && var19 < 20) {
                                       class78 var55 = var10.method3407(var19);
                                       if(var55 != null) {
                                          var55.method1767(var39, var23);
                                       } else if(class173.field2746) {
                                          class4.method37(var10);
                                       }
                                    }
                                 } else {
                                    boolean var47 = false;
                                    boolean var48 = false;
                                    var42 = var10.field2866[var19] - 1;
                                    if(32 + var39 > var2 && var39 < var4 && 32 + var23 > var3 && var23 < var5 || var10 == class38.field849 && var19 == client.field347) {
                                       class78 var44;
                                       if(client.field352 == 1 && var19 == field1325 && class0.field11 == var10.field2748) {
                                          var44 = class39.method794(var42, var10.field2745[var19], 2, 0, 2, false);
                                       } else {
                                          var44 = class39.method794(var42, var10.field2745[var19], 1, 3153952, 2, false);
                                       }

                                       if(null != var44) {
                                          if(var10 == class38.field849 && var19 == client.field347) {
                                             var24 = class140.field2134 - client.field404;
                                             var25 = class140.field2135 - client.field405;
                                             if(var24 < 5 && var24 > -5) {
                                                var24 = 0;
                                             }

                                             if(var25 < 5 && var25 > -5) {
                                                var25 = 0;
                                             }

                                             if(client.field408 < 5) {
                                                var24 = 0;
                                                var25 = 0;
                                             }

                                             var44.method1720(var39 + var24, var25 + var23, 128);
                                             if(var1 != -1) {
                                                class173 var41 = var0[var1 & '\uffff'];
                                                if(var25 + var23 < class79.field1384 && var41.field2770 > 0) {
                                                   var29 = client.field538 * (class79.field1384 - var23 - var25) / 3;
                                                   if(var29 > client.field538 * 10) {
                                                      var29 = client.field538 * 10;
                                                   }

                                                   if(var29 > var41.field2770) {
                                                      var29 = var41.field2770;
                                                   }

                                                   var41.field2770 -= var29;
                                                   client.field405 += var29;
                                                   class4.method37(var41);
                                                }

                                                if(32 + var25 + var23 > class79.field1385 && var41.field2770 < var41.field2772 - var41.field2764) {
                                                   var29 = client.field538 * (32 + var23 + var25 - class79.field1385) / 3;
                                                   if(var29 > client.field538 * 10) {
                                                      var29 = client.field538 * 10;
                                                   }

                                                   if(var29 > var41.field2772 - var41.field2764 - var41.field2770) {
                                                      var29 = var41.field2772 - var41.field2764 - var41.field2770;
                                                   }

                                                   var41.field2770 += var29;
                                                   client.field405 -= var29;
                                                   class4.method37(var41);
                                                }
                                             }
                                          } else if(class219.field3170 == var10 && client.field402 == var19) {
                                             var44.method1720(var39, var23, 128);
                                          } else {
                                             var44.method1767(var39, var23);
                                          }
                                       } else {
                                          class4.method37(var10);
                                       }
                                    }
                                 }

                                 ++var19;
                              }
                           }
                        } else if(var10.field2833 == 3) {
                           if(class95.method2186(var10)) {
                              var19 = var10.field2755;
                              if(var10 == class172.field2732 && var10.field2776 != 0) {
                                 var19 = var10.field2776;
                              }
                           } else {
                              var19 = var10.field2773;
                              if(var10 == class172.field2732 && var10.field2775 != 0) {
                                 var19 = var10.field2775;
                              }
                           }

                           if(var10.field2850) {
                              switch(var10.field2778.field1398) {
                              case 1:
                                 class79.method1800(var12, var13, var10.field2763, var10.field2764, var10.field2773, var10.field2755, 256 - (var10.field2830 & 255), 256 - (var10.field2780 & 255));
                                 break;
                              case 2:
                                 class79.method1801(var12, var13, var10.field2763, var10.field2764, var10.field2773, var10.field2755, 256 - (var10.field2830 & 255), 256 - (var10.field2780 & 255));
                                 break;
                              case 3:
                                 class79.method1802(var12, var13, var10.field2763, var10.field2764, var10.field2773, var10.field2755, 256 - (var10.field2830 & 255), 256 - (var10.field2780 & 255));
                                 break;
                              case 4:
                                 class79.method1857(var12, var13, var10.field2763, var10.field2764, var10.field2773, var10.field2755, 256 - (var10.field2830 & 255), 256 - (var10.field2780 & 255));
                                 break;
                              default:
                                 if(var14 == 0) {
                                    class79.method1865(var12, var13, var10.field2763, var10.field2764, var19);
                                 } else {
                                    class79.method1855(var12, var13, var10.field2763, var10.field2764, var19, 256 - (var14 & 255));
                                 }
                              }
                           } else if(var14 == 0) {
                              class79.method1852(var12, var13, var10.field2763, var10.field2764, var19);
                           } else {
                              class79.method1806(var12, var13, var10.field2763, var10.field2764, var19, 256 - (var14 & 255));
                           }
                        } else {
                           class224 var60;
                           if(var10.field2833 == 4) {
                              var60 = var10.method3411();
                              if(null == var60) {
                                 if(class173.field2746) {
                                    class4.method37(var10);
                                 }
                              } else {
                                 String var54 = var10.field2808;
                                 if(class95.method2186(var10)) {
                                    var20 = var10.field2755;
                                    if(class172.field2732 == var10 && var10.field2776 != 0) {
                                       var20 = var10.field2776;
                                    }

                                    if(var10.field2809.length() > 0) {
                                       var54 = var10.field2809;
                                    }
                                 } else {
                                    var20 = var10.field2773;
                                    if(class172.field2732 == var10 && var10.field2775 != 0) {
                                       var20 = var10.field2775;
                                    }
                                 }

                                 if(var10.field2741 && var10.field2868 != -1) {
                                    class51 var46 = class35.method741(var10.field2868);
                                    var54 = var46.field1090;
                                    if(null == var54) {
                                       var54 = "null";
                                    }

                                    if((var46.field1096 == 1 || var10.field2871 != 1) && var10.field2871 != -1) {
                                       var54 = class158.method3184(16748608) + var54 + "</col>" + " " + 'x' + class2.method21(var10.field2871);
                                    }
                                 }

                                 if(client.field451 == var10) {
                                    class157 var10000 = (class157)null;
                                    var54 = "Please wait...";
                                    var20 = var10.field2773;
                                 }

                                 if(!var10.field2741) {
                                    var54 = class96.method2197(var54, var10);
                                 }

                                 var60.method4036(var54, var12, var13, var10.field2763, var10.field2764, var20, var10.field2799?0:-1, var10.field2811, var10.field2861, var10.field2813);
                              }
                           } else if(var10.field2833 == 5) {
                              class78 var61;
                              if(!var10.field2741) {
                                 var61 = var10.method3410(class95.method2186(var10));
                                 if(var61 != null) {
                                    var61.method1767(var12, var13);
                                 } else if(class173.field2746) {
                                    class4.method37(var10);
                                 }
                              } else {
                                 if(var10.field2868 != -1) {
                                    var61 = class39.method794(var10.field2868, var10.field2871, var10.field2787, var10.field2738, var10.field2806, false);
                                 } else {
                                    var61 = var10.method3410(false);
                                 }

                                 if(null == var61) {
                                    if(class173.field2746) {
                                       class4.method37(var10);
                                    }
                                 } else {
                                    var20 = var61.field1370;
                                    var21 = var61.field1372;
                                    if(!var10.field2853) {
                                       var39 = var10.field2763 * 4096 / var20;
                                       if(var10.field2851 != 0) {
                                          var61.method1727(var12 + var10.field2763 / 2, var10.field2764 / 2 + var13, var10.field2851, var39);
                                       } else if(var14 != 0) {
                                          var61.method1722(var12, var13, var10.field2763, var10.field2764, 256 - (var14 & 255));
                                       } else if(var10.field2763 == var20 && var10.field2764 == var21) {
                                          var61.method1767(var12, var13);
                                       } else {
                                          var61.method1716(var12, var13, var10.field2763, var10.field2764);
                                       }
                                    } else {
                                       class79.method1794(var12, var13, var10.field2763 + var12, var10.field2764 + var13);
                                       var39 = (var10.field2763 + (var20 - 1)) / var20;
                                       var23 = (var10.field2764 + (var21 - 1)) / var21;

                                       for(var24 = 0; var24 < var39; ++var24) {
                                          for(var25 = 0; var25 < var23; ++var25) {
                                             if(var10.field2851 != 0) {
                                                var61.method1727(var24 * var20 + var12 + var20 / 2, var21 / 2 + var21 * var25 + var13, var10.field2851, 4096);
                                             } else if(var14 != 0) {
                                                var61.method1720(var12 + var24 * var20, var13 + var21 * var25, 256 - (var14 & 255));
                                             } else {
                                                var61.method1767(var24 * var20 + var12, var13 + var21 * var25);
                                             }
                                          }
                                       }

                                       class79.method1793(var2, var3, var4, var5);
                                    }
                                 }
                              }
                           } else {
                              class51 var43;
                              if(var10.field2833 == 6) {
                                 boolean var45 = class95.method2186(var10);
                                 if(var45) {
                                    var20 = var10.field2845;
                                 } else {
                                    var20 = var10.field2752;
                                 }

                                 class105 var52 = null;
                                 var39 = 0;
                                 if(var10.field2868 != -1) {
                                    var43 = class35.method741(var10.field2868);
                                    if(null != var43) {
                                       var43 = var43.method1052(var10.field2871);
                                       var52 = var43.method1024(1);
                                       if(null != var52) {
                                          var52.method2323();
                                          var39 = var52.field1436 / 2;
                                       } else {
                                          class4.method37(var10);
                                       }
                                    }
                                 } else if(var10.field2791 == 5) {
                                    if(var10.field2792 == 0) {
                                       var52 = client.field339.method3519((class42)null, -1, (class42)null, -1);
                                    } else {
                                       var52 = class153.field2262.vmethod1913();
                                    }
                                 } else if(var20 == -1) {
                                    var52 = var10.method3408((class42)null, -1, var45, class153.field2262.field49);
                                    if(var52 == null && class173.field2746) {
                                       class4.method37(var10);
                                    }
                                 } else {
                                    class42 var65 = class17.method178(var20);
                                    var52 = var10.method3408(var65, var10.field2870, var45, class153.field2262.field49);
                                    if(null == var52 && class173.field2746) {
                                       class4.method37(var10);
                                    }
                                 }

                                 class91.method2147(var10.field2763 / 2 + var12, var13 + var10.field2764 / 2);
                                 var23 = var10.field2802 * class91.field1563[var10.field2839] >> 16;
                                 var24 = class91.field1564[var10.field2839] * var10.field2802 >> 16;
                                 if(var52 != null) {
                                    if(!var10.field2741) {
                                       var52.method2314(0, var10.field2800, 0, var10.field2839, 0, var23, var24);
                                    } else {
                                       var52.method2323();
                                       if(var10.field2805) {
                                          var52.method2312(0, var10.field2800, var10.field2844, var10.field2839, var10.field2797, var23 + var39 + var10.field2798, var24 + var10.field2798, var10.field2802);
                                       } else {
                                          var52.method2314(0, var10.field2800, var10.field2844, var10.field2839, var10.field2797, var23 + var39 + var10.field2798, var24 + var10.field2798);
                                       }
                                    }
                                 }

                                 class91.method2142();
                              } else {
                                 if(var10.field2833 == 7) {
                                    var60 = var10.method3411();
                                    if(null == var60) {
                                       if(class173.field2746) {
                                          class4.method37(var10);
                                       }
                                       continue;
                                    }

                                    var20 = 0;

                                    for(var21 = 0; var21 < var10.field2765; ++var21) {
                                       for(var39 = 0; var39 < var10.field2759; ++var39) {
                                          if(var10.field2866[var20] > 0) {
                                             var43 = class35.method741(var10.field2866[var20] - 1);
                                             String var37;
                                             if(var43.field1096 != 1 && var10.field2745[var20] == 1) {
                                                var37 = class158.method3184(16748608) + var43.field1090 + "</col>";
                                             } else {
                                                var37 = class158.method3184(16748608) + var43.field1090 + "</col>" + " " + 'x' + class2.method21(var10.field2745[var20]);
                                             }

                                             var25 = (115 + var10.field2814) * var39 + var12;
                                             var42 = var21 * (var10.field2815 + 12) + var13;
                                             if(var10.field2811 == 0) {
                                                var60.method4033(var37, var25, var42, var10.field2773, var10.field2799?0:-1);
                                             } else if(var10.field2811 == 1) {
                                                var60.method4035(var37, var25 + var10.field2763 / 2, var42, var10.field2773, var10.field2799?0:-1);
                                             } else {
                                                var60.method4034(var37, var25 + var10.field2763 - 1, var42, var10.field2773, var10.field2799?0:-1);
                                             }
                                          }

                                          ++var20;
                                       }
                                    }
                                 }

                                 if(var10.field2833 == 8 && class175.field2890 == var10 && client.field518 == client.field321) {
                                    var19 = 0;
                                    var20 = 0;
                                    class224 var36 = class44.field1021;
                                    String var22 = var10.field2808;

                                    String var64;
                                    for(var22 = class96.method2197(var22, var10); var22.length() > 0; var20 += var36.field3190 + 1) {
                                       var24 = var22.indexOf("<br>");
                                       if(var24 != -1) {
                                          var64 = var22.substring(0, var24);
                                          var22 = var22.substring(var24 + 4);
                                       } else {
                                          var64 = var22;
                                          var22 = "";
                                       }

                                       var25 = var36.method4028(var64);
                                       if(var25 > var19) {
                                          var19 = var25;
                                       }
                                    }

                                    var19 += 6;
                                    var20 += 7;
                                    var24 = var10.field2763 + var12 - 5 - var19;
                                    var25 = 5 + var13 + var10.field2764;
                                    if(var24 < 5 + var12) {
                                       var24 = 5 + var12;
                                    }

                                    if(var19 + var24 > var4) {
                                       var24 = var4 - var19;
                                    }

                                    if(var20 + var25 > var5) {
                                       var25 = var5 - var20;
                                    }

                                    class79.method1865(var24, var25, var19, var20, 16777120);
                                    class79.method1852(var24, var25, var19, var20, 0);
                                    var22 = var10.field2808;
                                    var42 = var36.field3190 + var25 + 2;

                                    for(var22 = class96.method2197(var22, var10); var22.length() > 0; var42 += var36.field3190 + 1) {
                                       var27 = var22.indexOf("<br>");
                                       if(var27 != -1) {
                                          var64 = var22.substring(0, var27);
                                          var22 = var22.substring(var27 + 4);
                                       } else {
                                          var64 = var22;
                                          var22 = "";
                                       }

                                       var36.method4033(var64, var24 + 3, var42, 0, -1);
                                    }
                                 }

                                 if(var10.field2833 == 9) {
                                    if(var10.field2781 == 1) {
                                       if(var10.field2782) {
                                          var19 = var12;
                                          var20 = var13 + var10.field2764;
                                          var21 = var12 + var10.field2763;
                                          var39 = var13;
                                       } else {
                                          var19 = var12;
                                          var20 = var13;
                                          var21 = var12 + var10.field2763;
                                          var39 = var10.field2764 + var13;
                                       }

                                       class79.method1803(var19, var20, var21, var39, var10.field2773);
                                    } else {
                                       var19 = var10.field2763 >= 0?var10.field2763:-var10.field2763;
                                       var20 = var10.field2764 >= 0?var10.field2764:-var10.field2764;
                                       var21 = var19;
                                       if(var19 < var20) {
                                          var21 = var20;
                                       }

                                       if(var21 != 0) {
                                          var39 = (var10.field2763 << 16) / var21;
                                          var23 = (var10.field2764 << 16) / var21;
                                          if(var23 <= var39) {
                                             var39 = -var39;
                                          } else {
                                             var23 = -var23;
                                          }

                                          var24 = var10.field2781 * var23 >> 17;
                                          var25 = 1 + var10.field2781 * var23 >> 17;
                                          var42 = var39 * var10.field2781 >> 17;
                                          var27 = 1 + var10.field2781 * var39 >> 17;
                                          var28 = var24 + var12;
                                          var29 = var12 - var25;
                                          int var30 = var10.field2763 + var12 - var25;
                                          var31 = var24 + var10.field2763 + var12;
                                          int var32 = var13 + var42;
                                          int var33 = var13 - var27;
                                          int var34 = var13 + var10.field2764 - var27;
                                          int var35 = var42 + var13 + var10.field2764;
                                          class91.method2101(var28, var29, var30);
                                          class91.method2095(var32, var33, var34, var28, var29, var30, var10.field2773);
                                          class91.method2101(var28, var30, var31);
                                          class91.method2095(var32, var34, var35, var28, var30, var31, var10.field2773);
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

   public void run() {
      this.field1318 = true;

      try {
         while(!this.field1315) {
            for(int var1 = 0; var1 < 2; ++var1) {
               class56 var2 = this.field1317[var1];
               if(var2 != null) {
                  var2.method1192();
               }
            }

            class116.method2459(10L);
            class129.method2857(this.field1327, (Object)null);
         }
      } catch (Exception var7) {
         class7.method94((String)null, var7);
      } finally {
         this.field1318 = false;
      }

   }

   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "1390538707"
   )
   static final void method1601(int var0, int var1, int var2, int var3) {
      client.field489 = 0;
      boolean var4 = false;
      int var5 = -1;
      int var6 = class32.field738;
      int[] var7 = class32.field739;

      int var8;
      for(var8 = 0; var8 < var6 + client.field449; ++var8) {
         Object var9;
         if(var8 < var6) {
            var9 = client.field410[var7[var8]];
            if(var7[var8] == client.field329) {
               var4 = true;
               var5 = var8;
               continue;
            }
         } else {
            var9 = client.field326[client.field318[var8 - var6]];
         }

         class8.method115((class37)var9, var8, var0, var1, var2, var3);
      }

      if(var4) {
         class8.method115(client.field410[client.field329], var5, var0, var1, var2, var3);
      }

      for(var8 = 0; var8 < client.field489; ++var8) {
         int var18 = client.field385[var8];
         int var10 = client.field386[var8];
         int var11 = client.field388[var8];
         int var12 = client.field455[var8];
         boolean var13 = true;

         while(var13) {
            var13 = false;

            for(int var19 = 0; var19 < var8; ++var19) {
               if(2 + var10 > client.field386[var19] - client.field455[var19] && var10 - var12 < client.field386[var19] + 2 && var18 - var11 < client.field388[var19] + client.field385[var19] && var11 + var18 > client.field385[var19] - client.field388[var19] && client.field386[var19] - client.field455[var19] < var10) {
                  var10 = client.field386[var19] - client.field455[var19];
                  var13 = true;
               }
            }
         }

         client.field395 = client.field385[var8];
         client.field544 = client.field386[var8] = var10;
         String var14 = client.field392[var8];
         if(client.field377 == 0) {
            int var15 = 16776960;
            if(client.field389[var8] < 6) {
               var15 = client.field562[client.field389[var8]];
            }

            if(client.field389[var8] == 6) {
               var15 = client.field565 % 20 < 10?16711680:16776960;
            }

            if(client.field389[var8] == 7) {
               var15 = client.field565 % 20 < 10?255:'\uffff';
            }

            if(client.field389[var8] == 8) {
               var15 = client.field565 % 20 < 10?'뀀':8454016;
            }

            int var16;
            if(client.field389[var8] == 9) {
               var16 = 150 - client.field391[var8];
               if(var16 < 50) {
                  var15 = 16711680 + var16 * 1280;
               } else if(var16 < 100) {
                  var15 = 16776960 - 327680 * (var16 - 50);
               } else if(var16 < 150) {
                  var15 = 5 * (var16 - 100) + '\uff00';
               }
            }

            if(client.field389[var8] == 10) {
               var16 = 150 - client.field391[var8];
               if(var16 < 50) {
                  var15 = var16 * 5 + 16711680;
               } else if(var16 < 100) {
                  var15 = 16711935 - 327680 * (var16 - 50);
               } else if(var16 < 150) {
                  var15 = 327680 * (var16 - 100) + 255 - (var16 - 100) * 5;
               }
            }

            if(client.field389[var8] == 11) {
               var16 = 150 - client.field391[var8];
               if(var16 < 50) {
                  var15 = 16777215 - 327685 * var16;
               } else if(var16 < 100) {
                  var15 = 327685 * (var16 - 50) + '\uff00';
               } else if(var16 < 150) {
                  var15 = 16777215 - 327680 * (var16 - 100);
               }
            }

            if(client.field457[var8] == 0) {
               class162.field2636.method4035(var14, var0 + client.field395, client.field544 + var1, var15, 0);
            }

            if(client.field457[var8] == 1) {
               class162.field2636.method4037(var14, var0 + client.field395, var1 + client.field544, var15, 0, client.field565);
            }

            if(client.field457[var8] == 2) {
               class162.field2636.method4038(var14, client.field395 + var0, var1 + client.field544, var15, 0, client.field565);
            }

            if(client.field457[var8] == 3) {
               class162.field2636.method4070(var14, client.field395 + var0, var1 + client.field544, var15, 0, client.field565, 150 - client.field391[var8]);
            }

            if(client.field457[var8] == 4) {
               var16 = (150 - client.field391[var8]) * (class162.field2636.method4028(var14) + 100) / 150;
               class79.method1794(var0 + client.field395 - 50, var1, 50 + var0 + client.field395, var1 + var3);
               class162.field2636.method4033(var14, var0 + client.field395 + 50 - var16, client.field544 + var1, var15, 0);
               class79.method1793(var0, var1, var2 + var0, var1 + var3);
            }

            if(client.field457[var8] == 5) {
               var16 = 150 - client.field391[var8];
               int var17 = 0;
               if(var16 < 25) {
                  var17 = var16 - 25;
               } else if(var16 > 125) {
                  var17 = var16 - 125;
               }

               class79.method1794(var0, var1 + client.field544 - class162.field2636.field3190 - 1, var0 + var2, 5 + client.field544 + var1);
               class162.field2636.method4035(var14, var0 + client.field395, var1 + client.field544 + var17, var15, 0);
               class79.method1793(var0, var1, var2 + var0, var1 + var3);
            }
         } else {
            class162.field2636.method4035(var14, client.field395 + var0, var1 + client.field544, 16776960, 0);
         }
      }

   }

   @ObfuscatedName("az")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-2019670127"
   )
   static void method1602(int var0) {
      client.field500 = 0L;
      if(var0 >= 2) {
         client.field501 = true;
      } else {
         client.field501 = false;
      }

      class137.method2961();
      if(client.field294 >= 25) {
         client.field331.method2781(174);
         class122 var1 = client.field331;
         int var2 = client.field501?2:1;
         var1.method2650(var2);
         client.field331.method2695(class45.field1026);
         client.field331.method2695(class143.field2169);
      }

      class144.field2186 = true;
   }
}
