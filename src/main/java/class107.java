import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InvalidClassException;
import java.io.ObjectInputStream;
import java.io.OptionalDataException;
import java.io.StreamCorruptedException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dc")
public abstract class class107 {
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -2128756661
   )
   public int field1868;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -951732917
   )
   public int field1869;
   @ObfuscatedName("ej")
   static class78[] field1871;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -358705137
   )
   public int field1873;
   @ObfuscatedName("pp")
   public static class136 field1874;
   @ObfuscatedName("nd")
   @ObfuscatedGetter(
      intValue = -741802265
   )
   static int field1875;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 1123790177
   )
   public int field1878;

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(IIILclass108;I)Z",
      garbageValue = "271013110"
   )
   protected abstract boolean vmethod2480(int var1, int var2, int var3, class108 var4);

   @ObfuscatedName("cj")
   @ObfuscatedSignature(
      signature = "([Lclass173;IIIIIIIII)V",
      garbageValue = "-1921491560"
   )
   static final void method2482(class173[] var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
      class79.method1889(var2, var3, var4, var5);
      class91.method2169();

      for(int var9 = 0; var9 < var0.length; ++var9) {
         class173 var10 = var0[var9];
         if(null != var10 && (var10.field2777 == var1 || -1412584499 == var1 && client.field465 == var10)) {
            int var11;
            if(var8 == -1) {
               client.field311[client.field496] = var10.field2848 + var6;
               client.field497[client.field496] = var7 + var10.field2772;
               client.field503[client.field496] = var10.field2773;
               client.field504[client.field496] = var10.field2774;
               var11 = ++client.field496 - 1;
            } else {
               var11 = var8;
            }

            var10.field2889 = var11;
            var10.field2890 = client.field306;
            if(!var10.field2757 || !class219.method4065(var10)) {
               int var12;
               if(var10.field2762 > 0) {
                  var12 = var10.field2762;
                  if(324 == var12) {
                     if(client.field446 == -1) {
                        client.field446 = var10.field2793;
                        client.field569 = var10.field2794;
                     }

                     if(client.field567.field2924) {
                        var10.field2793 = client.field446;
                     } else {
                        var10.field2793 = client.field569;
                     }
                  } else if(325 == var12) {
                     if(-1 == client.field446) {
                        client.field446 = var10.field2793;
                        client.field569 = var10.field2794;
                     }

                     if(client.field567.field2924) {
                        var10.field2793 = client.field569;
                     } else {
                        var10.field2793 = client.field446;
                     }
                  } else if(var12 == 327) {
                     var10.field2800 = 150;
                     var10.field2810 = (int)(Math.sin((double)client.field306 / 40.0D) * 256.0D) & 2047;
                     var10.field2801 = 5;
                     var10.field2869 = 0;
                  } else if(328 == var12) {
                     var10.field2800 = 150;
                     var10.field2810 = (int)(Math.sin((double)client.field306 / 40.0D) * 256.0D) & 2047;
                     var10.field2801 = 5;
                     var10.field2869 = 1;
                  }
               }

               var12 = var10.field2848 + var6;
               int var13 = var7 + var10.field2772;
               int var14 = var10.field2807;
               int var15;
               int var16;
               if(client.field465 == var10) {
                  if(var1 != -1412584499 && !var10.field2836) {
                     class155.field2289 = var0;
                     class104.field1782 = var6;
                     class175.field2904 = var7;
                     continue;
                  }

                  if(client.field476 && client.field498) {
                     var15 = class140.field2151;
                     var16 = class140.field2161;
                     var15 -= client.field464;
                     var16 -= client.field485;
                     if(var15 < client.field450) {
                        var15 = client.field450;
                     }

                     if(var15 + var10.field2773 > client.field450 + client.field409.field2773) {
                        var15 = client.field450 + client.field409.field2773 - var10.field2773;
                     }

                     if(var16 < client.field472) {
                        var16 = client.field472;
                     }

                     if(var16 + var10.field2774 > client.field409.field2774 + client.field472) {
                        var16 = client.field472 + client.field409.field2774 - var10.field2774;
                     }

                     var12 = var15;
                     var13 = var16;
                  }

                  if(!var10.field2836) {
                     var14 = 128;
                  }
               }

               int var17;
               int var18;
               int var19;
               int var20;
               int var21;
               int var22;
               if(2 == var10.field2824) {
                  var15 = var2;
                  var16 = var3;
                  var17 = var4;
                  var18 = var5;
               } else if(var10.field2824 == 9) {
                  var19 = var12;
                  var20 = var13;
                  var21 = var12 + var10.field2773;
                  var22 = var10.field2774 + var13;
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
                  var19 = var12 + var10.field2773;
                  var20 = var13 + var10.field2774;
                  var15 = var12 > var2?var12:var2;
                  var16 = var13 > var3?var13:var3;
                  var17 = var19 < var4?var19:var4;
                  var18 = var20 < var5?var20:var5;
               }

               if(!var10.field2757 || var15 < var17 && var16 < var18) {
                  int var23;
                  int var24;
                  int var25;
                  int var26;
                  int var27;
                  int var28;
                  int var31;
                  if(var10.field2762 != 0) {
                     if(var10.field2762 == 1336) {
                        if(client.field312) {
                           var13 += 15;
                           class135.field2084.method4117("Fps:" + class144.field2185, var12 + var10.field2773, var13, 16776960, -1);
                           var13 += 15;
                           Runtime var53 = Runtime.getRuntime();
                           var20 = (int)((var53.totalMemory() - var53.freeMemory()) / 1024L);
                           var21 = 16776960;
                           if(var20 > '耀' && client.field302) {
                              var21 = 16711680;
                           }

                           if(var20 > 65536 && !client.field302) {
                              var21 = 16711680;
                           }

                           class135.field2084.method4117("Mem:" + var20 + "k", var10.field2773 + var12, var13, var21, -1);
                           var13 += 15;
                        }
                        continue;
                     }

                     if(var10.field2762 == 1337) {
                        client.field340 = var12;
                        client.field442 = var13;
                        class16.method212(var12, var13, var10.field2773, var10.field2774);
                        client.field323[var10.field2889] = true;
                        class79.method1889(var2, var3, var4, var5);
                        continue;
                     }

                     if(1338 == var10.field2762) {
                        class41.method935();
                        class175 var52 = var10.method3487(false);
                        if(null != var52) {
                           class79.method1889(var12, var13, var52.field2901 + var12, var52.field2900 + var13);
                           if(2 != client.field530 && client.field530 != 5) {
                              var20 = client.field443 + client.field379 & 2047;
                              var21 = 48 + class5.field93.field844 / 32;
                              var22 = 464 - class5.field93.field819 / 32;
                              class94.field1610.method1809(var12, var13, var52.field2901, var52.field2900, var21, var22, var20, 256 + client.field368, var52.field2902, var52.field2899);

                              for(var23 = 0; var23 < client.field524; ++var23) {
                                 var24 = 2 + 4 * client.field307[var23] - class5.field93.field844 / 32;
                                 var25 = 2 + 4 * client.field565[var23] - class5.field93.field819 / 32;
                                 class95.method2255(var12, var13, var24, var25, client.field527[var23], var52);
                              }

                              var23 = 0;

                              while(true) {
                                 if(var23 >= 104) {
                                    for(var23 = 0; var23 < client.field343; ++var23) {
                                       class34 var62 = client.field546[client.field335[var23]];
                                       if(null != var62 && var62.vmethod836()) {
                                          class39 var56 = var62.field784;
                                          if(var56 != null && null != var56.field916) {
                                             var56 = var56.method862();
                                          }

                                          if(var56 != null && var56.field907 && var56.field898) {
                                             var26 = var62.field844 / 32 - class5.field93.field844 / 32;
                                             var27 = var62.field819 / 32 - class5.field93.field819 / 32;
                                             class95.method2255(var12, var13, var26, var27, class139.field2142[1], var52);
                                          }
                                       }
                                    }

                                    var23 = class32.field771;
                                    int[] var64 = class32.field762;

                                    for(var25 = 0; var25 < var23; ++var25) {
                                       class2 var50 = client.field550[var64[var25]];
                                       if(var50 != null && var50.vmethod836() && !var50.field51 && var50 != class5.field93) {
                                          var27 = var50.field844 / 32 - class5.field93.field844 / 32;
                                          var28 = var50.field819 / 32 - class5.field93.field819 / 32;
                                          boolean var65 = false;
                                          if(class41.method948(var50.field58, true)) {
                                             var65 = true;
                                          }

                                          boolean var57 = false;

                                          for(var31 = 0; var31 < class139.field2143; ++var31) {
                                             if(var50.field58.equals(class59.field1226[var31].field637)) {
                                                var57 = true;
                                                break;
                                             }
                                          }

                                          boolean var61 = false;
                                          if(class5.field93.field63 != 0 && 0 != var50.field63 && var50.field63 == class5.field93.field63) {
                                             var61 = true;
                                          }

                                          if(var65) {
                                             class95.method2255(var12, var13, var27, var28, class139.field2142[3], var52);
                                          } else if(var61) {
                                             class95.method2255(var12, var13, var27, var28, class139.field2142[4], var52);
                                          } else if(var57) {
                                             class95.method2255(var12, var13, var27, var28, class139.field2142[5], var52);
                                          } else {
                                             class95.method2255(var12, var13, var27, var28, class139.field2142[2], var52);
                                          }
                                       }
                                    }

                                    if(client.field314 != 0 && client.field306 % 20 < 10) {
                                       if(1 == client.field314 && client.field315 >= 0 && client.field315 < client.field546.length) {
                                          class34 var60 = client.field546[client.field315];
                                          if(var60 != null) {
                                             var26 = var60.field844 / 32 - class5.field93.field844 / 32;
                                             var27 = var60.field819 / 32 - class5.field93.field819 / 32;
                                             class209.method4007(var12, var13, var26, var27, field1871[1], var52);
                                          }
                                       }

                                       if(client.field314 == 2) {
                                          var25 = client.field391 * 4 - class144.field2204 * 4 + 2 - class5.field93.field844 / 32;
                                          var26 = 2 + (client.field318 * 4 - class3.field67 * 4) - class5.field93.field819 / 32;
                                          class209.method4007(var12, var13, var25, var26, field1871[1], var52);
                                       }

                                       if(10 == client.field314 && client.field316 >= 0 && client.field316 < client.field550.length) {
                                          class2 var63 = client.field550[client.field316];
                                          if(null != var63) {
                                             var26 = var63.field844 / 32 - class5.field93.field844 / 32;
                                             var27 = var63.field819 / 32 - class5.field93.field819 / 32;
                                             class209.method4007(var12, var13, var26, var27, field1871[1], var52);
                                          }
                                       }
                                    }

                                    if(0 != client.field528) {
                                       var25 = 2 + client.field528 * 4 - class5.field93.field844 / 32;
                                       var26 = client.field347 * 4 + 2 - class5.field93.field819 / 32;
                                       class95.method2255(var12, var13, var25, var26, field1871[0], var52);
                                    }

                                    if(!class5.field93.field51) {
                                       class79.method1929(var52.field2901 / 2 + var12 - 1, var13 + var52.field2900 / 2 - 1, 3, 3, 16777215);
                                    }
                                    break;
                                 }

                                 for(var24 = 0; var24 < 104; ++var24) {
                                    class199 var55 = client.field425[class42.field1002][var23][var24];
                                    if(null != var55) {
                                       var26 = 2 + 4 * var23 - class5.field93.field844 / 32;
                                       var27 = 4 * var24 + 2 - class5.field93.field819 / 32;
                                       class95.method2255(var12, var13, var26, var27, class139.field2142[0], var52);
                                    }
                                 }

                                 ++var23;
                              }
                           } else {
                              class79.method1908(var12, var13, 0, var52.field2902, var52.field2899);
                           }

                           client.field520[var11] = true;
                        }

                        class79.method1889(var2, var3, var4, var5);
                        continue;
                     }

                     if(1339 == var10.field2762) {
                        class90.method2167(var10, var12, var13, var11);
                        class79.method1889(var2, var3, var4, var5);
                        continue;
                     }
                  }

                  if(0 == var10.field2824) {
                     if(!var10.field2757 && class219.method4065(var10) && class43.field1032 != var10) {
                        continue;
                     }

                     if(!var10.field2757) {
                        if(var10.field2780 > var10.field2765 - var10.field2774) {
                           var10.field2780 = var10.field2765 - var10.field2774;
                        }

                        if(var10.field2780 < 0) {
                           var10.field2780 = 0;
                        }
                     }

                     method2482(var0, var10.field2842, var15, var16, var17, var18, var12 - var10.field2879, var13 - var10.field2780, var11);
                     if(null != var10.field2867) {
                        method2482(var10.field2867, var10.field2842, var15, var16, var17, var18, var12 - var10.field2879, var13 - var10.field2780, var11);
                     }

                     class3 var36 = (class3)client.field453.method3868((long)var10.field2842);
                     if(var36 != null) {
                        class5.method114(var36.field70, var15, var16, var17, var18, var12, var13, var11);
                     }

                     class79.method1889(var2, var3, var4, var5);
                     class91.method2169();
                  }

                  if(client.field344 || client.field354[var11] || client.field505 > 1) {
                     if(0 == var10.field2824 && !var10.field2757 && var10.field2765 > var10.field2774) {
                        var19 = var12 + var10.field2773;
                        var20 = var10.field2780;
                        var21 = var10.field2774;
                        var22 = var10.field2765;
                        class163.field2640[0].method1962(var19, var13);
                        class163.field2640[1].method1962(var19, var21 + var13 - 16);
                        class79.method1929(var19, 16 + var13, 16, var21 - 32, client.field549);
                        var23 = (var21 - 32) * var21 / var22;
                        if(var23 < 8) {
                           var23 = 8;
                        }

                        var24 = (var21 - 32 - var23) * var20 / (var22 - var21);
                        class79.method1929(var19, var13 + 16 + var24, 16, var23, client.field373);
                        class79.method1905(var19, var24 + 16 + var13, var23, client.field375);
                        class79.method1905(1 + var19, var13 + 16 + var24, var23, client.field375);
                        class79.method1903(var19, 16 + var13 + var24, 16, client.field375);
                        class79.method1903(var19, var24 + var13 + 17, 16, client.field375);
                        class79.method1905(var19 + 15, var24 + 16 + var13, var23, client.field374);
                        class79.method1905(14 + var19, var13 + 17 + var24, var23 - 1, client.field374);
                        class79.method1903(var19, var23 + var24 + 15 + var13, 16, client.field374);
                        class79.method1903(1 + var19, var23 + var13 + 14 + var24, 15, client.field374);
                     }

                     if(var10.field2824 != 1) {
                        int var29;
                        if(var10.field2824 == 2) {
                           var19 = 0;

                           for(var20 = 0; var20 < var10.field2809; ++var20) {
                              for(var21 = 0; var21 < var10.field2827; ++var21) {
                                 var22 = var12 + (32 + var10.field2758) * var21;
                                 var23 = var13 + var20 * (var10.field2825 + 32);
                                 if(var19 < 20) {
                                    var22 += var10.field2826[var19];
                                    var23 += var10.field2750[var19];
                                 }

                                 if(var10.field2876[var19] <= 0) {
                                    if(var10.field2828 != null && var19 < 20) {
                                       class78 var58 = var10.method3480(var19);
                                       if(null != var58) {
                                          var58.method1798(var22, var23);
                                       } else if(class173.field2790) {
                                          class23.method657(var10);
                                       }
                                    }
                                 } else {
                                    boolean var54 = false;
                                    boolean var46 = false;
                                    var26 = var10.field2876[var19] - 1;
                                    if(var22 + 32 > var2 && var22 < var4 && var23 + 32 > var3 && var23 < var5 || var10 == class3.field65 && var19 == client.field408) {
                                       class78 var47;
                                       if(client.field448 == 1 && class11.field187 == var19 && var10.field2842 == class40.field931) {
                                          var47 = class49.method1109(var26, var10.field2877[var19], 2, 0, 2, false);
                                       } else {
                                          var47 = class49.method1109(var26, var10.field2877[var19], 1, 3153952, 2, false);
                                       }

                                       if(var47 != null) {
                                          if(var10 == class3.field65 && client.field408 == var19) {
                                             var24 = class140.field2151 - client.field414;
                                             var25 = class140.field2161 - client.field377;
                                             if(var24 < 5 && var24 > -5) {
                                                var24 = 0;
                                             }

                                             if(var25 < 5 && var25 > -5) {
                                                var25 = 0;
                                             }

                                             if(client.field413 < 5) {
                                                var24 = 0;
                                                var25 = 0;
                                             }

                                             var47.method1856(var22 + var24, var23 + var25, 128);
                                             if(var1 != -1) {
                                                class173 var51 = var0[var1 & '\uffff'];
                                                if(var23 + var25 < class79.field1415 && var51.field2780 > 0) {
                                                   var29 = client.field427 * (class79.field1415 - var23 - var25) / 3;
                                                   if(var29 > client.field427 * 10) {
                                                      var29 = client.field427 * 10;
                                                   }

                                                   if(var29 > var51.field2780) {
                                                      var29 = var51.field2780;
                                                   }

                                                   var51.field2780 -= var29;
                                                   client.field377 += var29;
                                                   class23.method657(var51);
                                                }

                                                if(var25 + var23 + 32 > class79.field1416 && var51.field2780 < var51.field2765 - var51.field2774) {
                                                   var29 = (32 + var23 + var25 - class79.field1416) * client.field427 / 3;
                                                   if(var29 > client.field427 * 10) {
                                                      var29 = client.field427 * 10;
                                                   }

                                                   if(var29 > var51.field2765 - var51.field2774 - var51.field2780) {
                                                      var29 = var51.field2765 - var51.field2774 - var51.field2780;
                                                   }

                                                   var51.field2780 += var29;
                                                   client.field377 -= var29;
                                                   class23.method657(var51);
                                                }
                                             }
                                          } else if(class130.field2061 == var10 && var19 == client.field407) {
                                             var47.method1856(var22, var23, 128);
                                          } else {
                                             var47.method1798(var22, var23);
                                          }
                                       } else {
                                          class23.method657(var10);
                                       }
                                    }
                                 }

                                 ++var19;
                              }
                           }
                        } else if(var10.field2824 == 3) {
                           if(class154.method3253(var10)) {
                              var19 = var10.field2784;
                              if(var10 == class43.field1032 && var10.field2822 != 0) {
                                 var19 = var10.field2822;
                              }
                           } else {
                              var19 = var10.field2783;
                              if(class43.field1032 == var10 && 0 != var10.field2785) {
                                 var19 = var10.field2785;
                              }
                           }

                           if(var10.field2787) {
                              switch(var10.field2845.field1431) {
                              case 1:
                                 class79.method1896(var12, var13, var10.field2773, var10.field2774, var10.field2783, var10.field2784, 256 - (var10.field2807 & 255), 256 - (var10.field2833 & 255));
                                 break;
                              case 2:
                                 class79.method1958(var12, var13, var10.field2773, var10.field2774, var10.field2783, var10.field2784, 256 - (var10.field2807 & 255), 256 - (var10.field2833 & 255));
                                 break;
                              case 3:
                                 class79.method1898(var12, var13, var10.field2773, var10.field2774, var10.field2783, var10.field2784, 256 - (var10.field2807 & 255), 256 - (var10.field2833 & 255));
                                 break;
                              case 4:
                                 class79.method1899(var12, var13, var10.field2773, var10.field2774, var10.field2783, var10.field2784, 256 - (var10.field2807 & 255), 256 - (var10.field2833 & 255));
                                 break;
                              default:
                                 if(0 == var14) {
                                    class79.method1929(var12, var13, var10.field2773, var10.field2774, var19);
                                 } else {
                                    class79.method1911(var12, var13, var10.field2773, var10.field2774, var19, 256 - (var14 & 255));
                                 }
                              }
                           } else if(var14 == 0) {
                              class79.method1941(var12, var13, var10.field2773, var10.field2774, var19);
                           } else {
                              class79.method1902(var12, var13, var10.field2773, var10.field2774, var19, 256 - (var14 & 255));
                           }
                        } else {
                           class224 var37;
                           if(var10.field2824 == 4) {
                              var37 = var10.method3485();
                              if(null == var37) {
                                 if(class173.field2790) {
                                    class23.method657(var10);
                                 }
                              } else {
                                 String var49 = var10.field2769;
                                 if(class154.method3253(var10)) {
                                    var20 = var10.field2784;
                                    if(var10 == class43.field1032 && var10.field2822 != 0) {
                                       var20 = var10.field2822;
                                    }

                                    if(var10.field2819.length() > 0) {
                                       var49 = var10.field2819;
                                    }
                                 } else {
                                    var20 = var10.field2783;
                                    if(class43.field1032 == var10 && var10.field2785 != 0) {
                                       var20 = var10.field2785;
                                    }
                                 }

                                 if(var10.field2757 && var10.field2878 != -1) {
                                    class51 var59 = class11.method178(var10.field2878);
                                    var49 = var59.field1125;
                                    if(var49 == null) {
                                       var49 = "null";
                                    }

                                    if((1 == var59.field1136 || var10.field2766 != 1) && var10.field2766 != -1) {
                                       var49 = class139.method3046(16748608) + var49 + "</col>" + " " + 'x' + class155.method3262(var10.field2766);
                                    }
                                 }

                                 if(client.field526 == var10) {
                                    class157 var10000 = (class157)null;
                                    var49 = "Please wait...";
                                    var20 = var10.field2783;
                                 }

                                 if(!var10.field2757) {
                                    var49 = class27.method725(var49, var10);
                                 }

                                 var37.method4119(var49, var12, var13, var10.field2773, var10.field2774, var20, var10.field2823?0:-1, var10.field2821, var10.field2782, var10.field2814);
                              }
                           } else if(var10.field2824 == 5) {
                              class78 var40;
                              if(!var10.field2757) {
                                 var40 = var10.method3484(class154.method3253(var10));
                                 if(null != var40) {
                                    var40.method1798(var12, var13);
                                 } else if(class173.field2790) {
                                    class23.method657(var10);
                                 }
                              } else {
                                 if(var10.field2878 != -1) {
                                    var40 = class49.method1109(var10.field2878, var10.field2766, var10.field2820, var10.field2798, var10.field2816, false);
                                 } else {
                                    var40 = var10.method3484(false);
                                 }

                                 if(var40 == null) {
                                    if(class173.field2790) {
                                       class23.method657(var10);
                                    }
                                 } else {
                                    var20 = var40.field1405;
                                    var21 = var40.field1407;
                                    if(!var10.field2796) {
                                       var22 = var10.field2773 * 4096 / var20;
                                       if(0 != var10.field2795) {
                                          var40.method1811(var10.field2773 / 2 + var12, var10.field2774 / 2 + var13, var10.field2795, var22);
                                       } else if(0 != var14) {
                                          var40.method1806(var12, var13, var10.field2773, var10.field2774, 256 - (var14 & 255));
                                       } else if(var20 == var10.field2773 && var21 == var10.field2774) {
                                          var40.method1798(var12, var13);
                                       } else {
                                          var40.method1859(var12, var13, var10.field2773, var10.field2774);
                                       }
                                    } else {
                                       class79.method1945(var12, var13, var10.field2773 + var12, var13 + var10.field2774);
                                       var22 = (var10.field2773 + (var20 - 1)) / var20;
                                       var23 = (var21 - 1 + var10.field2774) / var21;

                                       for(var24 = 0; var24 < var22; ++var24) {
                                          for(var25 = 0; var25 < var23; ++var25) {
                                             if(0 != var10.field2795) {
                                                var40.method1811(var12 + var24 * var20 + var20 / 2, var13 + var25 * var21 + var21 / 2, var10.field2795, 4096);
                                             } else if(0 != var14) {
                                                var40.method1856(var12 + var20 * var24, var21 * var25 + var13, 256 - (var14 & 255));
                                             } else {
                                                var40.method1798(var24 * var20 + var12, var25 * var21 + var13);
                                             }
                                          }
                                       }

                                       class79.method1889(var2, var3, var4, var5);
                                    }
                                 }
                              }
                           } else {
                              class51 var41;
                              if(var10.field2824 == 6) {
                                 boolean var39 = class154.method3253(var10);
                                 if(var39) {
                                    var20 = var10.field2834;
                                 } else {
                                    var20 = var10.field2805;
                                 }

                                 class105 var45 = null;
                                 var22 = 0;
                                 if(-1 != var10.field2878) {
                                    var41 = class11.method178(var10.field2878);
                                    if(var41 != null) {
                                       var41 = var41.method1174(var10.field2766);
                                       var45 = var41.method1132(1);
                                       if(null != var45) {
                                          var45.method2418();
                                          var22 = var45.field1465 / 2;
                                       } else {
                                          class23.method657(var10);
                                       }
                                    }
                                 } else if(5 == var10.field2801) {
                                    if(0 == var10.field2869) {
                                       var45 = client.field567.method3565((class42)null, -1, (class42)null, -1);
                                    } else {
                                       var45 = class5.field93.vmethod1999();
                                    }
                                 } else if(var20 == -1) {
                                    var45 = var10.method3511((class42)null, -1, var39, class5.field93.field33);
                                    if(null == var45 && class173.field2790) {
                                       class23.method657(var10);
                                    }
                                 } else {
                                    class42 var48 = class96.method2279(var20);
                                    var45 = var10.method3511(var48, var10.field2771, var39, class5.field93.field33);
                                    if(var45 == null && class173.field2790) {
                                       class23.method657(var10);
                                    }
                                 }

                                 class91.method2172(var10.field2773 / 2 + var12, var10.field2774 / 2 + var13);
                                 var23 = var10.field2812 * class91.field1593[var10.field2800] >> 16;
                                 var24 = class91.field1594[var10.field2800] * var10.field2812 >> 16;
                                 if(null != var45) {
                                    if(!var10.field2757) {
                                       var45.method2420(0, var10.field2810, 0, var10.field2800, 0, var23, var24);
                                    } else {
                                       var45.method2418();
                                       if(var10.field2815) {
                                          var45.method2460(0, var10.field2810, var10.field2811, var10.field2800, var10.field2760, var10.field2808 + var23 + var22, var10.field2808 + var24, var10.field2812);
                                       } else {
                                          var45.method2420(0, var10.field2810, var10.field2811, var10.field2800, var10.field2760, var23 + var22 + var10.field2808, var10.field2808 + var24);
                                       }
                                    }
                                 }

                                 class91.method2171();
                              } else {
                                 if(7 == var10.field2824) {
                                    var37 = var10.method3485();
                                    if(null == var37) {
                                       if(class173.field2790) {
                                          class23.method657(var10);
                                       }
                                       continue;
                                    }

                                    var20 = 0;

                                    for(var21 = 0; var21 < var10.field2809; ++var21) {
                                       for(var22 = 0; var22 < var10.field2827; ++var22) {
                                          if(var10.field2876[var20] > 0) {
                                             var41 = class11.method178(var10.field2876[var20] - 1);
                                             String var44;
                                             if(var41.field1136 != 1 && 1 == var10.field2877[var20]) {
                                                var44 = class139.method3046(16748608) + var41.field1125 + "</col>";
                                             } else {
                                                var44 = class139.method3046(16748608) + var41.field1125 + "</col>" + " " + 'x' + class155.method3262(var10.field2877[var20]);
                                             }

                                             var25 = var12 + var22 * (var10.field2758 + 115);
                                             var26 = var13 + var21 * (12 + var10.field2825);
                                             if(var10.field2821 == 0) {
                                                var37.method4116(var44, var25, var26, var10.field2783, var10.field2823?0:-1);
                                             } else if(1 == var10.field2821) {
                                                var37.method4118(var44, var25 + var10.field2773 / 2, var26, var10.field2783, var10.field2823?0:-1);
                                             } else {
                                                var37.method4117(var44, var25 + var10.field2773 - 1, var26, var10.field2783, var10.field2823?0:-1);
                                             }
                                          }

                                          ++var20;
                                       }
                                    }
                                 }

                                 if(var10.field2824 == 8 && var10 == class56.field1201 && client.field410 == client.field444) {
                                    var19 = 0;
                                    var20 = 0;
                                    class224 var38 = class135.field2084;
                                    String var42 = var10.field2769;

                                    String var43;
                                    for(var42 = class27.method725(var42, var10); var42.length() > 0; var20 += 1 + var38.field3190) {
                                       var24 = var42.indexOf("<br>");
                                       if(var24 != -1) {
                                          var43 = var42.substring(0, var24);
                                          var42 = var42.substring(var24 + 4);
                                       } else {
                                          var43 = var42;
                                          var42 = "";
                                       }

                                       var25 = var38.method4111(var43);
                                       if(var25 > var19) {
                                          var19 = var25;
                                       }
                                    }

                                    var19 += 6;
                                    var20 += 7;
                                    var24 = var10.field2773 + var12 - 5 - var19;
                                    var25 = 5 + var13 + var10.field2774;
                                    if(var24 < var12 + 5) {
                                       var24 = var12 + 5;
                                    }

                                    if(var24 + var19 > var4) {
                                       var24 = var4 - var19;
                                    }

                                    if(var20 + var25 > var5) {
                                       var25 = var5 - var20;
                                    }

                                    class79.method1929(var24, var25, var19, var20, 16777120);
                                    class79.method1941(var24, var25, var19, var20, 0);
                                    var42 = var10.field2769;
                                    var26 = 2 + var25 + var38.field3190;

                                    for(var42 = class27.method725(var42, var10); var42.length() > 0; var26 += 1 + var38.field3190) {
                                       var27 = var42.indexOf("<br>");
                                       if(var27 != -1) {
                                          var43 = var42.substring(0, var27);
                                          var42 = var42.substring(var27 + 4);
                                       } else {
                                          var43 = var42;
                                          var42 = "";
                                       }

                                       var38.method4116(var43, 3 + var24, var26, 0, -1);
                                    }
                                 }

                                 if(var10.field2824 == 9) {
                                    if(var10.field2791 == 1) {
                                       if(var10.field2792) {
                                          var19 = var12;
                                          var20 = var10.field2774 + var13;
                                          var21 = var12 + var10.field2773;
                                          var22 = var13;
                                       } else {
                                          var19 = var12;
                                          var20 = var13;
                                          var21 = var10.field2773 + var12;
                                          var22 = var10.field2774 + var13;
                                       }

                                       class79.method1907(var19, var20, var21, var22, var10.field2783);
                                    } else {
                                       var19 = var10.field2773 >= 0?var10.field2773:-var10.field2773;
                                       var20 = var10.field2774 >= 0?var10.field2774:-var10.field2774;
                                       var21 = var19;
                                       if(var19 < var20) {
                                          var21 = var20;
                                       }

                                       if(0 != var21) {
                                          var22 = (var10.field2773 << 16) / var21;
                                          var23 = (var10.field2774 << 16) / var21;
                                          if(var23 <= var22) {
                                             var22 = -var22;
                                          } else {
                                             var23 = -var23;
                                          }

                                          var24 = var10.field2791 * var23 >> 17;
                                          var25 = var23 * var10.field2791 + 1 >> 17;
                                          var26 = var10.field2791 * var22 >> 17;
                                          var27 = var22 * var10.field2791 + 1 >> 17;
                                          var28 = var12 + var24;
                                          var29 = var12 - var25;
                                          int var30 = var10.field2773 + var12 - var25;
                                          var31 = var24 + var12 + var10.field2773;
                                          int var32 = var13 + var26;
                                          int var33 = var13 - var27;
                                          int var34 = var13 + var10.field2774 - var27;
                                          int var35 = var10.field2774 + var13 + var26;
                                          class91.method2177(var28, var29, var30);
                                          class91.method2180(var32, var33, var34, var28, var29, var30, var10.field2783);
                                          class91.method2177(var28, var30, var31);
                                          class91.method2180(var32, var34, var35, var28, var30, var31, var10.field2783);
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

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(IB)Z",
      garbageValue = "36"
   )
   public static boolean method2483(int var0) {
      return (var0 >> 21 & 1) != 0;
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(IZZZI)Lclass168;",
      garbageValue = "0"
   )
   static class168 method2484(int var0, boolean var1, boolean var2, boolean var3) {
      class134 var4 = null;
      if(class149.field2235 != null) {
         var4 = new class134(var0, class149.field2235, class89.field1558[var0], 1000000);
      }

      return new class168(var4, class134.field2072, var0, var1, var2, var3);
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Lclass122;I)V",
      garbageValue = "2047452633"
   )
   public static void method2485(class122 var0) {
      class210 var1 = (class210)class211.field3138.method3950();
      if(null != var1) {
         int var2 = var0.field1992;
         var0.method2786(var1.field3133);

         for(int var3 = 0; var3 < var1.field3130; ++var3) {
            if(var1.field3127[var3] != 0) {
               var0.method2603(var1.field3127[var3]);
            } else {
               try {
                  int var4 = var1.field3129[var3];
                  Field var5;
                  int var6;
                  if(var4 == 0) {
                     var5 = var1.field3131[var3];
                     var6 = var5.getInt((Object)null);
                     var0.method2603(0);
                     var0.method2786(var6);
                  } else if(1 == var4) {
                     var5 = var1.field3131[var3];
                     var5.setInt((Object)null, var1.field3132[var3]);
                     var0.method2603(0);
                  } else if(var4 == 2) {
                     var5 = var1.field3131[var3];
                     var6 = var5.getModifiers();
                     var0.method2603(0);
                     var0.method2786(var6);
                  }

                  Method var22;
                  if(var4 != 3) {
                     if(var4 == 4) {
                        var22 = var1.field3128[var3];
                        var6 = var22.getModifiers();
                        var0.method2603(0);
                        var0.method2786(var6);
                     }
                  } else {
                     var22 = var1.field3128[var3];
                     byte[][] var23 = var1.field3134[var3];
                     Object[] var7 = new Object[var23.length];

                     for(int var8 = 0; var8 < var23.length; ++var8) {
                        ObjectInputStream var9 = new ObjectInputStream(new ByteArrayInputStream(var23[var8]));
                        var7[var8] = var9.readObject();
                     }

                     Object var24 = var22.invoke((Object)null, var7);
                     if(null == var24) {
                        var0.method2603(0);
                     } else if(var24 instanceof Number) {
                        var0.method2603(1);
                        var0.method2716(((Number)var24).longValue());
                     } else if(var24 instanceof String) {
                        var0.method2603(2);
                        var0.method2694((String)var24);
                     } else {
                        var0.method2603(4);
                     }
                  }
               } catch (ClassNotFoundException var10) {
                  var0.method2603(-10);
               } catch (InvalidClassException var11) {
                  var0.method2603(-11);
               } catch (StreamCorruptedException var12) {
                  var0.method2603(-12);
               } catch (OptionalDataException var13) {
                  var0.method2603(-13);
               } catch (IllegalAccessException var14) {
                  var0.method2603(-14);
               } catch (IllegalArgumentException var15) {
                  var0.method2603(-15);
               } catch (InvocationTargetException var16) {
                  var0.method2603(-16);
               } catch (SecurityException var17) {
                  var0.method2603(-17);
               } catch (IOException var18) {
                  var0.method2603(-18);
               } catch (NullPointerException var19) {
                  var0.method2603(-19);
               } catch (Exception var20) {
                  var0.method2603(-20);
               } catch (Throwable var21) {
                  var0.method2603(-21);
               }
            }
         }

         var0.method2604(var2);
         var1.method3998();
      }
   }

   @ObfuscatedName("dq")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ZI)V",
      garbageValue = "0"
   )
   static final void method2486(String var0, boolean var1) {
      if(var0 != null) {
         if((client.field397 < 100 || 1 == client.field417) && client.field397 < 400) {
            String var2 = class23.method672(var0, client.field551);
            if(null != var2) {
               int var3;
               String var5;
               String var6;
               for(var3 = 0; var3 < client.field397; ++var3) {
                  class7 var4 = client.field395[var3];
                  var5 = class23.method672(var4.field140, client.field551);
                  if(null != var5 && var5.equals(var2)) {
                     class129.method2943(31, "", var0 + " is already on your ignore list");
                     return;
                  }

                  if(null != var4.field137) {
                     var6 = class23.method672(var4.field137, client.field551);
                     if(var6 != null && var6.equals(var2)) {
                        class129.method2943(31, "", var0 + " is already on your ignore list");
                        return;
                     }
                  }
               }

               for(var3 = 0; var3 < client.field561; ++var3) {
                  class17 var7 = client.field563[var3];
                  var5 = class23.method672(var7.field261, client.field551);
                  if(var5 != null && var5.equals(var2)) {
                     class129.method2943(31, "", "Please remove " + var0 + " from your friend list first");
                     return;
                  }

                  if(var7.field262 != null) {
                     var6 = class23.method672(var7.field262, client.field551);
                     if(var6 != null && var6.equals(var2)) {
                        class129.method2943(31, "", "Please remove " + var0 + " from your friend list first");
                        return;
                     }
                  }
               }

               if(class23.method672(class5.field93.field58, client.field551).equals(var2)) {
                  class129.method2943(31, "", "You can\'t add yourself to your own ignore list");
               } else {
                  client.field338.method2873(158);
                  client.field338.method2603(class104.method2383(var0));
                  client.field338.method2694(var0);
               }
            }
         } else {
            class129.method2943(31, "", "Your ignore list is full. Max of 100 for free users, and 400 for members");
         }
      }
   }
}
