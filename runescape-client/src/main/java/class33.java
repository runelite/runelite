import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ao")
public class class33 {
   @ObfuscatedName("z")
   static final class33 field751 = new class33();
   @ObfuscatedName("h")
   static final class33 field752 = new class33();
   @ObfuscatedName("m")
   static final class33 field753 = new class33();
   @ObfuscatedName("bk")
   @ObfuscatedGetter(
      intValue = 656613211
   )
   static int field756;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 1756074249
   )
   static int field758;
   @ObfuscatedName("j")
   static final class33 field760 = new class33();

   @ObfuscatedName("bu")
   @ObfuscatedSignature(
      signature = "([Lclass173;IIIIIIIIB)V",
      garbageValue = "105"
   )
   static final void method707(class173[] var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
      class79.method1777(var2, var3, var4, var5);
      class91.method2087();

      for(int var9 = 0; var9 < var0.length; ++var9) {
         class173 var10 = var0[var9];
         if(null != var10 && (var10.field2763 == var1 || var1 == -1412584499 && var10 == client.field446)) {
            int var11;
            if(var8 == -1) {
               client.field321[client.field476] = var6 + var10.field2796;
               client.field315[client.field476] = var7 + var10.field2758;
               client.field483[client.field476] = var10.field2840;
               client.field551[client.field476] = var10.field2746;
               var11 = ++client.field476 - 1;
            } else {
               var11 = var8;
            }

            var10.field2734 = var11;
            var10.field2876 = client.field285;
            if(!var10.field2768 || !class30.method659(var10)) {
               int var12;
               if(var10.field2748 > 0) {
                  var12 = var10.field2748;
                  if(var12 == 324) {
                     if(client.field547 == -1) {
                        client.field547 = var10.field2779;
                        client.field548 = var10.field2780;
                     }

                     if(client.field546.field2920) {
                        var10.field2779 = client.field547;
                     } else {
                        var10.field2779 = client.field548;
                     }
                  } else if(325 == var12) {
                     if(-1 == client.field547) {
                        client.field547 = var10.field2779;
                        client.field548 = var10.field2780;
                     }

                     if(client.field546.field2920) {
                        var10.field2779 = client.field548;
                     } else {
                        var10.field2779 = client.field547;
                     }
                  } else if(327 == var12) {
                     var10.field2795 = 150;
                     var10.field2832 = (int)(Math.sin((double)client.field285 / 40.0D) * 256.0D) & 2047;
                     var10.field2787 = 5;
                     var10.field2776 = 0;
                  } else if(var12 == 328) {
                     var10.field2795 = 150;
                     var10.field2832 = (int)(Math.sin((double)client.field285 / 40.0D) * 256.0D) & 2047;
                     var10.field2787 = 5;
                     var10.field2776 = 1;
                  }
               }

               var12 = var10.field2796 + var6;
               int var13 = var10.field2758 + var7;
               int var14 = var10.field2775;
               int var15;
               int var16;
               if(var10 == client.field446) {
                  if(-1412584499 != var1 && !var10.field2822) {
                     class28.field665 = var0;
                     class10.field160 = var6;
                     class77.field1377 = var7;
                     continue;
                  }

                  if(client.field457 && client.field451) {
                     var15 = class140.field2128;
                     var16 = class140.field2126;
                     var15 -= client.field448;
                     var16 -= client.field449;
                     if(var15 < client.field452) {
                        var15 = client.field452;
                     }

                     if(var10.field2840 + var15 > client.field447.field2840 + client.field452) {
                        var15 = client.field447.field2840 + client.field452 - var10.field2840;
                     }

                     if(var16 < client.field299) {
                        var16 = client.field299;
                     }

                     if(var10.field2746 + var16 > client.field299 + client.field447.field2746) {
                        var16 = client.field299 + client.field447.field2746 - var10.field2746;
                     }

                     var12 = var15;
                     var13 = var16;
                  }

                  if(!var10.field2822) {
                     var14 = 128;
                  }
               }

               int var17;
               int var18;
               int var19;
               int var20;
               int var21;
               int var22;
               if(2 == var10.field2820) {
                  var15 = var2;
                  var16 = var3;
                  var17 = var4;
                  var18 = var5;
               } else if(9 == var10.field2820) {
                  var19 = var12;
                  var20 = var13;
                  var21 = var12 + var10.field2840;
                  var22 = var13 + var10.field2746;
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
                  var19 = var10.field2840 + var12;
                  var20 = var10.field2746 + var13;
                  var15 = var12 > var2?var12:var2;
                  var16 = var13 > var3?var13:var3;
                  var17 = var19 < var4?var19:var4;
                  var18 = var20 < var5?var20:var5;
               }

               if(!var10.field2768 || var15 < var17 && var16 < var18) {
                  int var23;
                  int var24;
                  int var25;
                  int var26;
                  int var27;
                  int var28;
                  int var31;
                  if(0 != var10.field2748) {
                     if(var10.field2748 == 1336) {
                        if(client.field531) {
                           var13 += 15;
                           class37.field797.method4061("Fps:" + class144.field2184, var12 + var10.field2840, var13, 16776960, -1);
                           var13 += 15;
                           Runtime var54 = Runtime.getRuntime();
                           var20 = (int)((var54.totalMemory() - var54.freeMemory()) / 1024L);
                           var21 = 16776960;
                           if(var20 > '耀' && client.field303) {
                              var21 = 16711680;
                           }

                           if(var20 > 65536 && !client.field303) {
                              var21 = 16711680;
                           }

                           class37.field797.method4061("Mem:" + var20 + "k", var12 + var10.field2840, var13, var21, -1);
                           var13 += 15;
                        }
                        continue;
                     }

                     if(var10.field2748 == 1337) {
                        client.field316 = var12;
                        client.field442 = var13;
                        class41.method849(var12, var13, var10.field2840, var10.field2746);
                        client.field478[var10.field2734] = true;
                        class79.method1777(var2, var3, var4, var5);
                        continue;
                     }

                     class175 var52;
                     if(1338 == var10.field2748) {
                        class13.method165();
                        var52 = var10.method3369(false);
                        if(var52 != null) {
                           class79.method1777(var12, var13, var12 + var52.field2890, var52.field2891 + var13);
                           if(2 != client.field509 && 5 != client.field509) {
                              var20 = client.field521 + client.field346 & 2047;
                              var21 = 48 + class47.field1053.field816 / 32;
                              var22 = 464 - class47.field1053.field840 / 32;
                              class25.field621.method1711(var12, var13, var52.field2890, var52.field2891, var21, var22, var20, client.field479 + 256, var52.field2892, var52.field2895);

                              for(var23 = 0; var23 < client.field503; ++var23) {
                                 var24 = client.field474[var23] * 4 + 2 - class47.field1053.field816 / 32;
                                 var25 = 2 + 4 * client.field450[var23] - class47.field1053.field840 / 32;
                                 class48.method996(var12, var13, var24, var25, client.field506[var23], var52);
                              }

                              var23 = 0;

                              while(true) {
                                 if(var23 >= 104) {
                                    for(var23 = 0; var23 < client.field314; ++var23) {
                                       class34 var62 = client.field517[client.field459[var23]];
                                       if(null != var62 && var62.vmethod742()) {
                                          class39 var56 = var62.field761;
                                          if(var56 != null && var56.field892 != null) {
                                             var56 = var56.method759();
                                          }

                                          if(null != var56 && var56.field883 && var56.field880) {
                                             var26 = var62.field816 / 32 - class47.field1053.field816 / 32;
                                             var27 = var62.field840 / 32 - class47.field1053.field840 / 32;
                                             class48.method996(var12, var13, var26, var27, client.field352[1], var52);
                                          }
                                       }
                                    }

                                    var23 = class32.field737;
                                    int[] var64 = class32.field738;

                                    for(var25 = 0; var25 < var23; ++var25) {
                                       class2 var50 = client.field396[var64[var25]];
                                       if(null != var50 && var50.vmethod742() && !var50.field56 && var50 != class47.field1053) {
                                          var27 = var50.field816 / 32 - class47.field1053.field816 / 32;
                                          var28 = var50.field840 / 32 - class47.field1053.field840 / 32;
                                          boolean var65 = false;
                                          if(class109.method2418(var50.field58, true)) {
                                             var65 = true;
                                          }

                                          boolean var57 = false;

                                          for(var31 = 0; var31 < class37.field853; ++var31) {
                                             if(var50.field58.equals(class123.field2005[var31].field607)) {
                                                var57 = true;
                                                break;
                                             }
                                          }

                                          boolean var61 = false;
                                          if(class47.field1053.field55 != 0 && var50.field55 != 0 && class47.field1053.field55 == var50.field55) {
                                             var61 = true;
                                          }

                                          if(var65) {
                                             class48.method996(var12, var13, var27, var28, client.field352[3], var52);
                                          } else if(var61) {
                                             class48.method996(var12, var13, var27, var28, client.field352[4], var52);
                                          } else if(var57) {
                                             class48.method996(var12, var13, var27, var28, client.field352[5], var52);
                                          } else {
                                             class48.method996(var12, var13, var27, var28, client.field352[2], var52);
                                          }
                                       }
                                    }

                                    if(0 != client.field275 && client.field285 % 20 < 10) {
                                       if(client.field275 == 1 && client.field294 >= 0 && client.field294 < client.field517.length) {
                                          class34 var60 = client.field517[client.field294];
                                          if(var60 != null) {
                                             var26 = var60.field816 / 32 - class47.field1053.field816 / 32;
                                             var27 = var60.field840 / 32 - class47.field1053.field840 / 32;
                                             class56.method1221(var12, var13, var26, var27, class108.field1881[1], var52);
                                          }
                                       }

                                       if(client.field275 == 2) {
                                          var25 = 2 + (client.field296 * 4 - class187.field3014 * 4) - class47.field1053.field816 / 32;
                                          var26 = client.field423 * 4 - class0.field12 * 4 + 2 - class47.field1053.field840 / 32;
                                          class56.method1221(var12, var13, var25, var26, class108.field1881[1], var52);
                                       }

                                       if(10 == client.field275 && client.field309 >= 0 && client.field309 < client.field396.length) {
                                          class2 var63 = client.field396[client.field309];
                                          if(null != var63) {
                                             var26 = var63.field816 / 32 - class47.field1053.field816 / 32;
                                             var27 = var63.field840 / 32 - class47.field1053.field840 / 32;
                                             class56.method1221(var12, var13, var26, var27, class108.field1881[1], var52);
                                          }
                                       }
                                    }

                                    if(0 != client.field507) {
                                       var25 = client.field507 * 4 + 2 - class47.field1053.field816 / 32;
                                       var26 = client.field508 * 4 + 2 - class47.field1053.field840 / 32;
                                       class48.method996(var12, var13, var25, var26, class108.field1881[0], var52);
                                    }

                                    if(!class47.field1053.field56) {
                                       class79.method1783(var12 + var52.field2890 / 2 - 1, var52.field2891 / 2 + var13 - 1, 3, 3, 16777215);
                                    }
                                    break;
                                 }

                                 for(var24 = 0; var24 < 104; ++var24) {
                                    class199 var55 = client.field364[class28.field655][var23][var24];
                                    if(var55 != null) {
                                       var26 = var23 * 4 + 2 - class47.field1053.field816 / 32;
                                       var27 = 2 + var24 * 4 - class47.field1053.field840 / 32;
                                       class48.method996(var12, var13, var26, var27, client.field352[0], var52);
                                    }
                                 }

                                 ++var23;
                              }
                           } else {
                              class79.method1796(var12, var13, 0, var52.field2892, var52.field2895);
                           }

                           client.field391[var11] = true;
                        }

                        class79.method1777(var2, var3, var4, var5);
                        continue;
                     }

                     if(1339 == var10.field2748) {
                        var52 = var10.method3369(false);
                        if(null != var52) {
                           if(client.field509 < 3) {
                              class14.field202.method1711(var12, var13, var52.field2890, var52.field2891, 25, 25, client.field521, 256, var52.field2892, var52.field2895);
                           } else {
                              class79.method1796(var12, var13, 0, var52.field2892, var52.field2895);
                           }
                        }

                        class79.method1777(var2, var3, var4, var5);
                        continue;
                     }
                  }

                  if(var10.field2820 == 0) {
                     if(!var10.field2768 && class30.method659(var10) && var10 != class143.field2170) {
                        continue;
                     }

                     if(!var10.field2768) {
                        if(var10.field2766 > var10.field2784 - var10.field2746) {
                           var10.field2766 = var10.field2784 - var10.field2746;
                        }

                        if(var10.field2766 < 0) {
                           var10.field2766 = 0;
                        }
                     }

                     method707(var0, var10.field2774, var15, var16, var17, var18, var12 - var10.field2765, var13 - var10.field2766, var11);
                     if(null != var10.field2868) {
                        method707(var10.field2868, var10.field2774, var15, var16, var17, var18, var12 - var10.field2765, var13 - var10.field2766, var11);
                     }

                     class3 var36 = (class3)client.field434.method3742((long)var10.field2774);
                     if(var36 != null) {
                        class52.method1079(var36.field65, var15, var16, var17, var18, var12, var13, var11);
                     }

                     class79.method1777(var2, var3, var4, var5);
                     class91.method2087();
                  }

                  if(client.field487 || client.field480[var11] || client.field338 > 1) {
                     if(var10.field2820 == 0 && !var10.field2768 && var10.field2784 > var10.field2746) {
                        var19 = var12 + var10.field2840;
                        var20 = var10.field2766;
                        var21 = var10.field2746;
                        var22 = var10.field2784;
                        class209.field3126[0].method1867(var19, var13);
                        class209.field3126[1].method1867(var19, var13 + var21 - 16);
                        class79.method1783(var19, var13 + 16, 16, var21 - 32, client.field353);
                        var23 = var21 * (var21 - 32) / var22;
                        if(var23 < 8) {
                           var23 = 8;
                        }

                        var24 = var20 * (var21 - 32 - var23) / (var22 - var21);
                        class79.method1783(var19, var24 + var13 + 16, 16, var23, client.field354);
                        class79.method1793(var19, 16 + var13 + var24, var23, client.field356);
                        class79.method1793(var19 + 1, var13 + 16 + var24, var23, client.field356);
                        class79.method1791(var19, var24 + 16 + var13, 16, client.field356);
                        class79.method1791(var19, var13 + 17 + var24, 16, client.field356);
                        class79.method1793(15 + var19, 16 + var13 + var24, var23, client.field406);
                        class79.method1793(14 + var19, var13 + 17 + var24, var23 - 1, client.field406);
                        class79.method1791(var19, var23 + var24 + var13 + 15, 16, client.field406);
                        class79.method1791(1 + var19, 14 + var13 + var24 + var23, 15, client.field406);
                     }

                     if(var10.field2820 != 1) {
                        int var29;
                        if(2 == var10.field2820) {
                           var19 = 0;

                           for(var20 = 0; var20 < var10.field2756; ++var20) {
                              for(var21 = 0; var21 < var10.field2755; ++var21) {
                                 var22 = var21 * (var10.field2810 + 32) + var12;
                                 var23 = var13 + var20 * (32 + var10.field2811);
                                 if(var19 < 20) {
                                    var22 += var10.field2812[var19];
                                    var23 += var10.field2813[var19];
                                 }

                                 if(var10.field2862[var19] <= 0) {
                                    if(null != var10.field2814 && var19 < 20) {
                                       class78 var58 = var10.method3380(var19);
                                       if(var58 != null) {
                                          var58.method1700(var22, var23);
                                       } else if(class173.field2742) {
                                          class2.method28(var10);
                                       }
                                    }
                                 } else {
                                    boolean var53 = false;
                                    boolean var46 = false;
                                    var26 = var10.field2862[var19] - 1;
                                    if(32 + var22 > var2 && var22 < var4 && var23 + 32 > var3 && var23 < var5 || var10 == class35.field772 && client.field389 == var19) {
                                       class78 var47;
                                       if(client.field280 == 1 && var19 == class15.field214 && var10.field2774 == class109.field1894) {
                                          var47 = class26.method628(var26, var10.field2863[var19], 2, 0, 2, false);
                                       } else {
                                          var47 = class26.method628(var26, var10.field2863[var19], 1, 3153952, 2, false);
                                       }

                                       if(null != var47) {
                                          if(var10 == class35.field772 && client.field389 == var19) {
                                             var24 = class140.field2128 - client.field390;
                                             var25 = class140.field2126 - client.field357;
                                             if(var24 < 5 && var24 > -5) {
                                                var24 = 0;
                                             }

                                             if(var25 < 5 && var25 > -5) {
                                                var25 = 0;
                                             }

                                             if(client.field394 < 5) {
                                                var24 = 0;
                                                var25 = 0;
                                             }

                                             var47.method1706(var24 + var22, var23 + var25, 128);
                                             if(var1 != -1) {
                                                class173 var51 = var0[var1 & '\uffff'];
                                                if(var25 + var23 < class79.field1400 && var51.field2766 > 0) {
                                                   var29 = (class79.field1400 - var23 - var25) * client.field351 / 3;
                                                   if(var29 > client.field351 * 10) {
                                                      var29 = client.field351 * 10;
                                                   }

                                                   if(var29 > var51.field2766) {
                                                      var29 = var51.field2766;
                                                   }

                                                   var51.field2766 -= var29;
                                                   client.field357 += var29;
                                                   class2.method28(var51);
                                                }

                                                if(var23 + var25 + 32 > class79.field1395 && var51.field2766 < var51.field2784 - var51.field2746) {
                                                   var29 = (32 + var25 + var23 - class79.field1395) * client.field351 / 3;
                                                   if(var29 > client.field351 * 10) {
                                                      var29 = client.field351 * 10;
                                                   }

                                                   if(var29 > var51.field2784 - var51.field2746 - var51.field2766) {
                                                      var29 = var51.field2784 - var51.field2746 - var51.field2766;
                                                   }

                                                   var51.field2766 += var29;
                                                   client.field357 -= var29;
                                                   class2.method28(var51);
                                                }
                                             }
                                          } else if(class15.field217 == var10 && client.field388 == var19) {
                                             var47.method1706(var22, var23, 128);
                                          } else {
                                             var47.method1700(var22, var23);
                                          }
                                       } else {
                                          class2.method28(var10);
                                       }
                                    }
                                 }

                                 ++var19;
                              }
                           }
                        } else if(3 == var10.field2820) {
                           if(class48.method995(var10)) {
                              var19 = var10.field2770;
                              if(var10 == class143.field2170 && 0 != var10.field2772) {
                                 var19 = var10.field2772;
                              }
                           } else {
                              var19 = var10.field2790;
                              if(var10 == class143.field2170 && 0 != var10.field2771) {
                                 var19 = var10.field2771;
                              }
                           }

                           if(var10.field2760) {
                              switch(var10.field2788.field1415) {
                              case 1:
                                 class79.method1784(var12, var13, var10.field2840, var10.field2746, var10.field2790, var10.field2770, 256 - (var10.field2775 & 255), 256 - (var10.field2847 & 255));
                                 break;
                              case 2:
                                 class79.method1785(var12, var13, var10.field2840, var10.field2746, var10.field2790, var10.field2770, 256 - (var10.field2775 & 255), 256 - (var10.field2847 & 255));
                                 break;
                              case 3:
                                 class79.method1786(var12, var13, var10.field2840, var10.field2746, var10.field2790, var10.field2770, 256 - (var10.field2775 & 255), 256 - (var10.field2847 & 255));
                                 break;
                              case 4:
                                 class79.method1787(var12, var13, var10.field2840, var10.field2746, var10.field2790, var10.field2770, 256 - (var10.field2775 & 255), 256 - (var10.field2847 & 255));
                                 break;
                              default:
                                 if(var14 == 0) {
                                    class79.method1783(var12, var13, var10.field2840, var10.field2746, var19);
                                 } else {
                                    class79.method1782(var12, var13, var10.field2840, var10.field2746, var19, 256 - (var14 & 255));
                                 }
                              }
                           } else if(0 == var14) {
                              class79.method1801(var12, var13, var10.field2840, var10.field2746, var19);
                           } else {
                              class79.method1790(var12, var13, var10.field2840, var10.field2746, var19, 256 - (var14 & 255));
                           }
                        } else {
                           class224 var37;
                           if(4 == var10.field2820) {
                              var37 = var10.method3403();
                              if(var37 == null) {
                                 if(class173.field2742) {
                                    class2.method28(var10);
                                 }
                              } else {
                                 String var49 = var10.field2875;
                                 if(class48.method995(var10)) {
                                    var20 = var10.field2770;
                                    if(class143.field2170 == var10 && 0 != var10.field2772) {
                                       var20 = var10.field2772;
                                    }

                                    if(var10.field2805.length() > 0) {
                                       var49 = var10.field2805;
                                    }
                                 } else {
                                    var20 = var10.field2790;
                                    if(var10 == class143.field2170 && var10.field2771 != 0) {
                                       var20 = var10.field2771;
                                    }
                                 }

                                 if(var10.field2768 && var10.field2773 != -1) {
                                    class51 var59 = class89.method2081(var10.field2773);
                                    var49 = var59.field1095;
                                    if(var49 == null) {
                                       var49 = "null";
                                    }

                                    if((1 == var59.field1106 || 1 != var10.field2738) && -1 != var10.field2738) {
                                       var49 = class219.method3968(16748608) + var49 + "</col>" + " " + 'x' + class10.method135(var10.field2738);
                                    }
                                 }

                                 if(var10 == client.field437) {
                                    class157 var10000 = (class157)null;
                                    var49 = "Please wait...";
                                    var20 = var10.field2790;
                                 }

                                 if(!var10.field2768) {
                                    var49 = class113.method2433(var49, var10);
                                 }

                                 var37.method4008(var49, var12, var13, var10.field2840, var10.field2746, var20, var10.field2757?0:-1, var10.field2807, var10.field2808, var10.field2806);
                              }
                           } else if(var10.field2820 == 5) {
                              class78 var40;
                              if(!var10.field2768) {
                                 var40 = var10.method3365(class48.method995(var10));
                                 if(var40 != null) {
                                    var40.method1700(var12, var13);
                                 } else if(class173.field2742) {
                                    class2.method28(var10);
                                 }
                              } else {
                                 if(var10.field2773 != -1) {
                                    var40 = class26.method628(var10.field2773, var10.field2738, var10.field2783, var10.field2833, var10.field2802, false);
                                 } else {
                                    var40 = var10.method3365(false);
                                 }

                                 if(null == var40) {
                                    if(class173.field2742) {
                                       class2.method28(var10);
                                    }
                                 } else {
                                    var20 = var40.field1387;
                                    var21 = var40.field1388;
                                    if(!var10.field2782) {
                                       var22 = var10.field2840 * 4096 / var20;
                                       if(var10.field2781 != 0) {
                                          var40.method1713(var12 + var10.field2840 / 2, var13 + var10.field2746 / 2, var10.field2781, var22);
                                       } else if(var14 != 0) {
                                          var40.method1708(var12, var13, var10.field2840, var10.field2746, 256 - (var14 & 255));
                                       } else if(var20 == var10.field2840 && var21 == var10.field2746) {
                                          var40.method1700(var12, var13);
                                       } else {
                                          var40.method1702(var12, var13, var10.field2840, var10.field2746);
                                       }
                                    } else {
                                       class79.method1778(var12, var13, var10.field2840 + var12, var13 + var10.field2746);
                                       var22 = (var10.field2840 + (var20 - 1)) / var20;
                                       var23 = (var21 - 1 + var10.field2746) / var21;

                                       for(var24 = 0; var24 < var22; ++var24) {
                                          for(var25 = 0; var25 < var23; ++var25) {
                                             if(var10.field2781 != 0) {
                                                var40.method1713(var20 / 2 + var12 + var24 * var20, var13 + var21 * var25 + var21 / 2, var10.field2781, 4096);
                                             } else if(var14 != 0) {
                                                var40.method1706(var24 * var20 + var12, var13 + var25 * var21, 256 - (var14 & 255));
                                             } else {
                                                var40.method1700(var12 + var24 * var20, var21 * var25 + var13);
                                             }
                                          }
                                       }

                                       class79.method1777(var2, var3, var4, var5);
                                    }
                                 }
                              }
                           } else {
                              class51 var41;
                              if(var10.field2820 == 6) {
                                 boolean var39 = class48.method995(var10);
                                 if(var39) {
                                    var20 = var10.field2864;
                                 } else {
                                    var20 = var10.field2848;
                                 }

                                 class105 var45 = null;
                                 var22 = 0;
                                 if(var10.field2773 != -1) {
                                    var41 = class89.method2081(var10.field2773);
                                    if(null != var41) {
                                       var41 = var41.method1039(var10.field2738);
                                       var45 = var41.method1058(1);
                                       if(null != var45) {
                                          var45.method2335();
                                          var22 = var45.field1443 / 2;
                                       } else {
                                          class2.method28(var10);
                                       }
                                    }
                                 } else if(var10.field2787 == 5) {
                                    if(0 == var10.field2776) {
                                       var45 = client.field546.method3444((class42)null, -1, (class42)null, -1);
                                    } else {
                                       var45 = class47.field1053.vmethod1900();
                                    }
                                 } else if(-1 == var20) {
                                    var45 = var10.method3367((class42)null, -1, var39, class47.field1053.field36);
                                    if(var45 == null && class173.field2742) {
                                       class2.method28(var10);
                                    }
                                 } else {
                                    class42 var48 = class161.method3153(var20);
                                    var45 = var10.method3367(var48, var10.field2866, var39, class47.field1053.field36);
                                    if(var45 == null && class173.field2742) {
                                       class2.method28(var10);
                                    }
                                 }

                                 class91.method2101(var12 + var10.field2840 / 2, var10.field2746 / 2 + var13);
                                 var23 = var10.field2743 * class91.field1571[var10.field2795] >> 16;
                                 var24 = var10.field2743 * class91.field1572[var10.field2795] >> 16;
                                 if(var45 != null) {
                                    if(!var10.field2768) {
                                       var45.method2299(0, var10.field2832, 0, var10.field2795, 0, var23, var24);
                                    } else {
                                       var45.method2335();
                                       if(var10.field2767) {
                                          var45.method2306(0, var10.field2832, var10.field2797, var10.field2795, var10.field2793, var10.field2801 + var22 + var23, var24 + var10.field2801, var10.field2743);
                                       } else {
                                          var45.method2299(0, var10.field2832, var10.field2797, var10.field2795, var10.field2793, var10.field2801 + var23 + var22, var10.field2801 + var24);
                                       }
                                    }
                                 }

                                 class91.method2142();
                              } else {
                                 if(var10.field2820 == 7) {
                                    var37 = var10.method3403();
                                    if(null == var37) {
                                       if(class173.field2742) {
                                          class2.method28(var10);
                                       }
                                       continue;
                                    }

                                    var20 = 0;

                                    for(var21 = 0; var21 < var10.field2756; ++var21) {
                                       for(var22 = 0; var22 < var10.field2755; ++var22) {
                                          if(var10.field2862[var20] > 0) {
                                             var41 = class89.method2081(var10.field2862[var20] - 1);
                                             String var44;
                                             if(1 != var41.field1106 && 1 == var10.field2863[var20]) {
                                                var44 = class219.method3968(16748608) + var41.field1095 + "</col>";
                                             } else {
                                                var44 = class219.method3968(16748608) + var41.field1095 + "</col>" + " " + 'x' + class10.method135(var10.field2863[var20]);
                                             }

                                             var25 = var12 + (115 + var10.field2810) * var22;
                                             var26 = var21 * (var10.field2811 + 12) + var13;
                                             if(var10.field2807 == 0) {
                                                var37.method4006(var44, var25, var26, var10.field2790, var10.field2757?0:-1);
                                             } else if(var10.field2807 == 1) {
                                                var37.method4007(var44, var10.field2840 / 2 + var25, var26, var10.field2790, var10.field2757?0:-1);
                                             } else {
                                                var37.method4061(var44, var25 + var10.field2840 - 1, var26, var10.field2790, var10.field2757?0:-1);
                                             }
                                          }

                                          ++var20;
                                       }
                                    }
                                 }

                                 if(var10.field2820 == 8 && class0.field14 == var10 && client.field424 == client.field425) {
                                    var19 = 0;
                                    var20 = 0;
                                    class224 var38 = class37.field797;
                                    String var42 = var10.field2875;

                                    String var43;
                                    for(var42 = class113.method2433(var42, var10); var42.length() > 0; var20 += 1 + var38.field3192) {
                                       var24 = var42.indexOf("<br>");
                                       if(var24 != -1) {
                                          var43 = var42.substring(0, var24);
                                          var42 = var42.substring(4 + var24);
                                       } else {
                                          var43 = var42;
                                          var42 = "";
                                       }

                                       var25 = var38.method4002(var43);
                                       if(var25 > var19) {
                                          var19 = var25;
                                       }
                                    }

                                    var19 += 6;
                                    var20 += 7;
                                    var24 = var10.field2840 + var12 - 5 - var19;
                                    var25 = var10.field2746 + var13 + 5;
                                    if(var24 < var12 + 5) {
                                       var24 = var12 + 5;
                                    }

                                    if(var24 + var19 > var4) {
                                       var24 = var4 - var19;
                                    }

                                    if(var20 + var25 > var5) {
                                       var25 = var5 - var20;
                                    }

                                    class79.method1783(var24, var25, var19, var20, 16777120);
                                    class79.method1801(var24, var25, var19, var20, 0);
                                    var42 = var10.field2875;
                                    var26 = 2 + var25 + var38.field3192;

                                    for(var42 = class113.method2433(var42, var10); var42.length() > 0; var26 += 1 + var38.field3192) {
                                       var27 = var42.indexOf("<br>");
                                       if(-1 != var27) {
                                          var43 = var42.substring(0, var27);
                                          var42 = var42.substring(var27 + 4);
                                       } else {
                                          var43 = var42;
                                          var42 = "";
                                       }

                                       var38.method4006(var43, var24 + 3, var26, 0, -1);
                                    }
                                 }

                                 if(9 == var10.field2820) {
                                    if(1 == var10.field2777) {
                                       if(var10.field2778) {
                                          var19 = var12;
                                          var20 = var13 + var10.field2746;
                                          var21 = var12 + var10.field2840;
                                          var22 = var13;
                                       } else {
                                          var19 = var12;
                                          var20 = var13;
                                          var21 = var12 + var10.field2840;
                                          var22 = var10.field2746 + var13;
                                       }

                                       class79.method1795(var19, var20, var21, var22, var10.field2790);
                                    } else {
                                       var19 = var10.field2840 >= 0?var10.field2840:-var10.field2840;
                                       var20 = var10.field2746 >= 0?var10.field2746:-var10.field2746;
                                       var21 = var19;
                                       if(var19 < var20) {
                                          var21 = var20;
                                       }

                                       if(0 != var21) {
                                          var22 = (var10.field2840 << 16) / var21;
                                          var23 = (var10.field2746 << 16) / var21;
                                          if(var23 <= var22) {
                                             var22 = -var22;
                                          } else {
                                             var23 = -var23;
                                          }

                                          var24 = var10.field2777 * var23 >> 17;
                                          var25 = var10.field2777 * var23 + 1 >> 17;
                                          var26 = var10.field2777 * var22 >> 17;
                                          var27 = var10.field2777 * var22 + 1 >> 17;
                                          var28 = var12 + var24;
                                          var29 = var12 - var25;
                                          int var30 = var10.field2840 + var12 - var25;
                                          var31 = var10.field2840 + var12 + var24;
                                          int var32 = var13 + var26;
                                          int var33 = var13 - var27;
                                          int var34 = var10.field2746 + var13 - var27;
                                          int var35 = var10.field2746 + var13 + var26;
                                          class91.method2095(var28, var29, var30);
                                          class91.method2092(var32, var33, var34, var28, var29, var30, var10.field2790);
                                          class91.method2095(var28, var30, var31);
                                          class91.method2092(var32, var34, var35, var28, var30, var31, var10.field2790);
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

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "534896091"
   )
   public static boolean method708() {
      try {
         if(class183.field2959 == 2) {
            if(null == class183.field2955) {
               class183.field2955 = class180.method3470(class76.field1370, class183.field2960, class183.field2961);
               if(class183.field2955 == null) {
                  return false;
               }
            }

            if(class3.field67 == null) {
               class3.field67 = new class59(class183.field2962, class183.field2956);
            }

            if(class183.field2958.method3630(class183.field2955, class183.field2965, class3.field67, 22050)) {
               class183.field2958.method3562();
               class183.field2958.method3559(class183.field2957);
               class183.field2958.method3564(class183.field2955, class183.field2964);
               class183.field2959 = 0;
               class183.field2955 = null;
               class3.field67 = null;
               class76.field1370 = null;
               return true;
            }
         }
      } catch (Exception var1) {
         var1.printStackTrace();
         class183.field2958.method3565();
         class183.field2959 = 0;
         class183.field2955 = null;
         class3.field67 = null;
         class76.field1370 = null;
      }

      return false;
   }
}
