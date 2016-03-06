package net.runelite.rs.client;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("ai")
public class class33 {
   @ObfuscatedName("j")
   static final class33 field765 = new class33();
   @ObfuscatedName("a")
   static final class33 field766 = new class33();
   @ObfuscatedName("i")
   static final class33 field767 = new class33();
   @ObfuscatedName("l")
   static final class33 field769 = new class33();

   @ObfuscatedName("m")
   static boolean method722(class121 var0, int var1) {
      int var2 = var0.method2689(2);
      int var3;
      int var4;
      int var7;
      int var8;
      int var9;
      int var10;
      if(var2 == 0) {
         if(var0.method2689(1) != 0) {
            method722(var0, var1);
         }

         var3 = var0.method2689(6);
         var4 = var0.method2689(6);
         boolean var11 = var0.method2689(1) == 1;
         if(var11) {
            class32.field748[++class32.field756 - 1] = var1;
         }

         if(client.field410[var1] != null) {
            throw new RuntimeException();
         } else {
            class2 var12 = client.field410[var1] = new class2();
            var12.field56 = var1;
            if(class32.field745[var1] != null) {
               var12.method11(class32.field745[var1]);
            }

            var12.field860 = class32.field754[var1];
            var12.field835 = class32.field753[var1];
            var7 = class32.field752[var1];
            var8 = var7 >> 28;
            var9 = var7 >> 14 & 255;
            var10 = var7 & 255;
            var12.field866[0] = class32.field747[var1];
            var12.field55 = (byte)var8;
            var12.method12((var9 << 6) + var3 - class98.field1683, var4 + (var10 << 6) - class92.field1598);
            var12.field49 = false;
            return true;
         }
      } else if(var2 == 1) {
         var3 = var0.method2689(2);
         var4 = class32.field752[var1];
         class32.field752[var1] = (var4 & 268435455) + (((var4 >> 28) + var3 & 3) << 28);
         return false;
      } else {
         int var5;
         int var6;
         if(var2 == 2) {
            var3 = var0.method2689(5);
            var4 = var3 >> 3;
            var5 = var3 & 7;
            var6 = class32.field752[var1];
            var7 = var4 + (var6 >> 28) & 3;
            var8 = var6 >> 14 & 255;
            var9 = var6 & 255;
            if(var5 == 0) {
               --var8;
               --var9;
            }

            if(1 == var5) {
               --var9;
            }

            if(var5 == 2) {
               ++var8;
               --var9;
            }

            if(3 == var5) {
               --var8;
            }

            if(4 == var5) {
               ++var8;
            }

            if(5 == var5) {
               --var8;
               ++var9;
            }

            if(6 == var5) {
               ++var9;
            }

            if(7 == var5) {
               ++var8;
               ++var9;
            }

            class32.field752[var1] = var9 + (var8 << 14) + (var7 << 28);
            return false;
         } else {
            var3 = var0.method2689(18);
            var4 = var3 >> 16;
            var5 = var3 >> 8 & 255;
            var6 = var3 & 255;
            var7 = class32.field752[var1];
            var8 = (var7 >> 28) + var4 & 3;
            var9 = var5 + (var7 >> 14) & 255;
            var10 = var6 + var7 & 255;
            class32.field752[var1] = var10 + (var9 << 14) + (var8 << 28);
            return false;
         }
      }
   }

   @ObfuscatedName("cr")
   static final void method723(class172[] var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
      class79.method1778(var2, var3, var4, var5);
      class90.method2114();

      for(int var9 = 0; var9 < var0.length; ++var9) {
         class172 var10 = var0[var9];
         if(null != var10 && (var1 == var10.field2778 || -1412584499 == var1 && client.field536 == var10)) {
            int var11;
            if(var8 == -1) {
               client.field496[client.field491] = var6 + var10.field2772;
               client.field456[client.field491] = var7 + var10.field2773;
               client.field498[client.field491] = var10.field2774;
               client.field499[client.field491] = var10.field2890;
               var11 = ++client.field491 - 1;
            } else {
               var11 = var8;
            }

            var10.field2888 = var11;
            var10.field2889 = client.field394 * -1;
            if(!var10.field2758 || !class18.method195(var10)) {
               int var12;
               if(var10.field2763 > 0) {
                  var12 = var10.field2763;
                  if(324 == var12) {
                     if(client.field562 * -1 == -1) {
                        client.field562 = var10.field2765 * -1;
                        client.field485 = var10.field2793 * -1;
                     }

                     if(client.field475.field2922) {
                        var10.field2765 = client.field562 * -1;
                     } else {
                        var10.field2765 = client.field485 * -1;
                     }
                  } else if(var12 == 325) {
                     if(client.field562 * -1 == -1) {
                        client.field562 = var10.field2765 * -1;
                        client.field485 = var10.field2793 * -1;
                     }

                     if(client.field475.field2922) {
                        var10.field2765 = client.field485 * -1;
                     } else {
                        var10.field2765 = client.field562 * -1;
                     }
                  } else if(var12 == 327) {
                     var10.field2808 = 150;
                     var10.field2809 = (int)(Math.sin((double)client.field394 / 40.0D) * 256.0D) & 2047;
                     var10.field2800 = 5;
                     var10.field2857 = 0;
                  } else if(328 == var12) {
                     var10.field2808 = 150;
                     var10.field2809 = (int)(Math.sin((double)client.field394 / 40.0D) * 256.0D) & 2047;
                     var10.field2800 = 5;
                     var10.field2857 = 1;
                  }
               }

               var12 = var6 + var10.field2772;
               int var13 = var10.field2773 + var7;
               int var14 = var10.field2753;
               int var15;
               int var16;
               if(client.field536 == var10) {
                  if(var1 != -1412584499 && !var10.field2775) {
                     class75.field1381 = var0;
                     class6.field131 = var6;
                     class19.field279 = var7;
                     continue;
                  }

                  if(client.field314 && client.field466) {
                     var15 = class139.field2162;
                     var16 = class139.field2171;
                     var15 -= client.field428;
                     var16 -= client.field464;
                     if(var15 < client.field467) {
                        var15 = client.field467;
                     }

                     if(var15 + var10.field2774 > client.field297.field2774 + client.field467) {
                        var15 = client.field467 + client.field297.field2774 - var10.field2774;
                     }

                     if(var16 < client.field468) {
                        var16 = client.field468;
                     }

                     if(var16 + var10.field2890 > client.field468 + client.field297.field2890) {
                        var16 = client.field468 + client.field297.field2890 - var10.field2890;
                     }

                     var12 = var15;
                     var13 = var16;
                  }

                  if(!var10.field2775) {
                     var14 = 128;
                  }
               }

               int var17;
               int var18;
               int var19;
               int var20;
               int var21;
               int var22;
               if(var10.field2849 == 2) {
                  var15 = var2;
                  var16 = var3;
                  var17 = var4;
                  var18 = var5;
               } else if(9 == var10.field2849) {
                  var19 = var12;
                  var20 = var13;
                  var21 = var10.field2774 + var12;
                  var22 = var13 + var10.field2890;
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
                  var19 = var12 + var10.field2774;
                  var20 = var13 + var10.field2890;
                  var15 = var12 > var2?var12:var2;
                  var16 = var13 > var3?var13:var3;
                  var17 = var19 < var4?var19:var4;
                  var18 = var20 < var5?var20:var5;
               }

               if(!var10.field2758 || var15 < var17 && var16 < var18) {
                  int var24;
                  int var25;
                  int var26;
                  int var27;
                  int var28;
                  int var29;
                  int var30;
                  int var31;
                  int var32;
                  int var33;
                  int var34;
                  int var35;
                  if(var10.field2763 != 0) {
                     if(1336 == var10.field2763) {
                        if(client.field303) {
                           var13 += 15;
                           class29.field692.method3968("Fps:" + class143.field2205, var10.field2774 + var12, var13, 16776960, -1);
                           var13 += 15;
                           Runtime var65 = Runtime.getRuntime();
                           var20 = (int)((var65.totalMemory() - var65.freeMemory()) / 1024L);
                           var21 = 16776960;
                           if(var20 > '耀' && client.field457) {
                              var21 = 16711680;
                           }

                           if(var20 > 65536 && !client.field457) {
                              var21 = 16711680;
                           }

                           class29.field692.method3968("Mem:" + var20 + "k", var10.field2774 + var12, var13, var21, -1);
                           var13 += 15;
                        }
                        continue;
                     }

                     if(1337 == var10.field2763) {
                        client.field289 = var12;
                        client.field315 = var13;
                        var21 = var10.field2774;
                        var22 = var10.field2890;
                        ++client.field407;
                        class135.method2812(field765);
                        boolean var66 = false;
                        if(client.field419 >= 0) {
                           var24 = class32.field749;
                           int[] var63 = class32.field755;

                           for(var26 = 0; var26 < var24; ++var26) {
                              if(client.field419 == var63[var26]) {
                                 var66 = true;
                                 break;
                              }
                           }
                        }

                        if(var66) {
                           class135.method2812(field769);
                        }

                        class52.method1090(true);
                        class135.method2812(var66?field767:field766);
                        class52.method1090(false);
                        class10.method129();

                        for(class29 var69 = (class29)client.field423.method3773(); null != var69; var69 = (class29)client.field423.method3772()) {
                           if(var69.field691 == class75.field1386 && !var69.field687) {
                              if(client.field394 >= var69.field690) {
                                 var69.method658(client.field362);
                                 if(var69.field687) {
                                    var69.method3853();
                                 } else {
                                    class107.field1906.method1886(var69.field691, var69.field685, var69.field682, var69.field683, 60, var69, 0, -1, false);
                                 }
                              }
                           } else {
                              var69.method3853();
                           }
                        }

                        class174.method3407(var12, var13, var21, var22, true);
                        var19 = client.field441;
                        var20 = client.field417;
                        var21 = client.field552;
                        var22 = client.field553;
                        class79.method1778(var19, var20, var21 + var19, var22 + var20);
                        class90.method2114();
                        int var37;
                        if(!client.field528) {
                           var24 = client.field555;
                           if(client.field551 / 256 > var24) {
                              var24 = client.field551 / 256;
                           }

                           if(client.field537[4] && client.field539[4] + 128 > var24) {
                              var24 = 128 + client.field539[4];
                           }

                           var25 = client.field374 + client.field354 & 2047;
                           var26 = class98.field1695;
                           var27 = class105.method2335(class148.field2249.field839, class148.field2249.field848, class75.field1386) - client.field379;
                           var28 = class138.field2153;
                           var29 = 600 + 3 * var24;
                           var30 = 2048 - var24 & 2047;
                           var31 = 2048 - var25 & 2047;
                           var32 = 0;
                           var33 = 0;
                           var34 = var29;
                           int var36;
                           if(0 != var30) {
                              var35 = class90.field1587[var30];
                              var36 = class90.field1590[var30];
                              var37 = var36 * var33 - var35 * var29 >> 16;
                              var34 = var35 * var33 + var36 * var29 >> 16;
                              var33 = var37;
                           }

                           if(var31 != 0) {
                              var35 = class90.field1587[var31];
                              var36 = class90.field1590[var31];
                              var37 = var36 * var32 + var34 * var35 >> 16;
                              var34 = var34 * var36 - var32 * var35 >> 16;
                              var32 = var37;
                           }

                           class142.field2197 = var26 - var32;
                           class36.field797 = var27 - var33;
                           class147.field2228 = var28 - var34;
                           client.field556 = var24;
                           class74.field1371 = var25;
                        }

                        if(!client.field528) {
                           if(class10.field169.field142) {
                              var25 = class75.field1386;
                           } else {
                              label1832: {
                                 var26 = 3;
                                 if(client.field556 < 310) {
                                    var27 = class142.field2197 >> 7;
                                    var28 = class147.field2228 >> 7;
                                    var29 = class148.field2249.field839 >> 7;
                                    var30 = class148.field2249.field848 >> 7;
                                    if(var27 < 0 || var28 < 0 || var27 >= 104 || var28 >= 104) {
                                       var25 = class75.field1386;
                                       break label1832;
                                    }

                                    if((class5.field81[class75.field1386][var27][var28] & 4) != 0) {
                                       var26 = class75.field1386;
                                    }

                                    if(var29 > var27) {
                                       var31 = var29 - var27;
                                    } else {
                                       var31 = var27 - var29;
                                    }

                                    if(var30 > var28) {
                                       var32 = var30 - var28;
                                    } else {
                                       var32 = var28 - var30;
                                    }

                                    if(var31 > var32) {
                                       var33 = var32 * 65536 / var31;
                                       var34 = '耀';

                                       while(var27 != var29) {
                                          if(var27 < var29) {
                                             ++var27;
                                          } else if(var27 > var29) {
                                             --var27;
                                          }

                                          if(0 != (class5.field81[class75.field1386][var27][var28] & 4)) {
                                             var26 = class75.field1386;
                                          }

                                          var34 += var33;
                                          if(var34 >= 65536) {
                                             var34 -= 65536;
                                             if(var28 < var30) {
                                                ++var28;
                                             } else if(var28 > var30) {
                                                --var28;
                                             }

                                             if(0 != (class5.field81[class75.field1386][var27][var28] & 4)) {
                                                var26 = class75.field1386;
                                             }
                                          }
                                       }
                                    } else {
                                       var33 = var31 * 65536 / var32;
                                       var34 = '耀';

                                       while(var30 != var28) {
                                          if(var28 < var30) {
                                             ++var28;
                                          } else if(var28 > var30) {
                                             --var28;
                                          }

                                          if((class5.field81[class75.field1386][var27][var28] & 4) != 0) {
                                             var26 = class75.field1386;
                                          }

                                          var34 += var33;
                                          if(var34 >= 65536) {
                                             var34 -= 65536;
                                             if(var27 < var29) {
                                                ++var27;
                                             } else if(var27 > var29) {
                                                --var27;
                                             }

                                             if((class5.field81[class75.field1386][var27][var28] & 4) != 0) {
                                                var26 = class75.field1386;
                                             }
                                          }
                                       }
                                    }
                                 }

                                 if(class148.field2249.field839 >= 0 && class148.field2249.field848 >= 0 && class148.field2249.field839 < 13312 && class148.field2249.field848 < 13312) {
                                    if((class5.field81[class75.field1386][class148.field2249.field839 >> 7][class148.field2249.field848 >> 7] & 4) != 0) {
                                       var26 = class75.field1386;
                                    }

                                    var25 = var26;
                                 } else {
                                    var25 = class75.field1386;
                                 }
                              }
                           }

                           var24 = var25;
                        } else {
                           var24 = class15.method180();
                        }

                        var25 = class142.field2197;
                        var26 = class36.field797;
                        var27 = class147.field2228;
                        var28 = client.field556;
                        var29 = class74.field1371;

                        for(var30 = 0; var30 < 5; ++var30) {
                           if(client.field537[var30]) {
                              var31 = (int)(Math.random() * (double)(1 + 2 * client.field538[var30]) - (double)client.field538[var30] + Math.sin((double)client.field541[var30] * ((double)client.field540[var30] / 100.0D)) * (double)client.field539[var30]);
                              if(var30 == 0) {
                                 class142.field2197 += var31;
                              }

                              if(var30 == 1) {
                                 class36.field797 += var31;
                              }

                              if(var30 == 2) {
                                 class147.field2228 += var31;
                              }

                              if(3 == var30) {
                                 class74.field1371 = class74.field1371 + var31 & 2047;
                              }

                              if(var30 == 4) {
                                 client.field556 += var31;
                                 if(client.field556 < 128) {
                                    client.field556 = 128;
                                 }

                                 if(client.field556 > 383) {
                                    client.field556 = 383;
                                 }
                              }
                           }
                        }

                        var30 = class139.field2162;
                        var31 = class139.field2171;
                        if(class139.field2168 != 0) {
                           var30 = class139.field2169;
                           var31 = class139.field2163;
                        }

                        if(var30 >= var19 && var30 < var19 + var21 && var31 >= var20 && var31 < var20 + var22) {
                           class104.field1828 = true;
                           class104.field1853 = 0;
                           class104.field1859 = var30 - var19;
                           class104.field1821 = var31 - var20;
                        } else {
                           class104.field1828 = false;
                           class104.field1853 = 0;
                        }

                        class38.method764();
                        class79.method1776(var19, var20, var21, var22, 0);
                        class38.method764();
                        var32 = class90.field1575;
                        class90.field1575 = client.field487;
                        class107.field1906.method2007(class142.field2197, class36.field797, class147.field2228, client.field556, class74.field1371, var24);
                        class90.field1575 = var32;
                        class38.method764();
                        class107.field1906.method2031();
                        client.field383 = 0;
                        boolean var70 = false;
                        var34 = -1;
                        var35 = class32.field749;
                        int[] var71 = class32.field755;

                        for(var37 = 0; var37 < client.field561 + var35; ++var37) {
                           Object var38;
                           if(var37 < var35) {
                              var38 = client.field410[var71[var37]];
                              if(var71[var37] == client.field419) {
                                 var70 = true;
                                 var34 = var37;
                                 continue;
                              }
                           } else {
                              var38 = client.field324[client.field326[var37 - var35]];
                           }

                           class103.method2255((class37)var38, var37, var19, var20);
                        }

                        if(var70) {
                           class103.method2255(client.field410[client.field419], var34, var19, var20);
                        }

                        for(var37 = 0; var37 < client.field383; ++var37) {
                           int var72 = client.field478[var37];
                           int var39 = client.field356[var37];
                           int var40 = client.field388[var37];
                           int var41 = client.field387[var37];
                           boolean var42 = true;

                           while(var42) {
                              var42 = false;

                              for(int var43 = 0; var43 < var37; ++var43) {
                                 if(var39 + 2 > client.field356[var43] - client.field387[var43] && var39 - var41 < 2 + client.field356[var43] && var72 - var40 < client.field478[var43] + client.field388[var43] && var72 + var40 > client.field478[var43] - client.field388[var43] && client.field356[var43] - client.field387[var43] < var39) {
                                    var39 = client.field356[var43] - client.field387[var43];
                                    var42 = true;
                                 }
                              }
                           }

                           client.field358 = client.field478[var37] * -1;
                           client.field396 = (client.field356[var37] = var39) * -1;
                           String var74 = client.field550[var37];
                           if(0 == client.field361) {
                              int var44 = 16776960;
                              if(client.field389[var37] < 6) {
                                 var44 = client.field318[client.field389[var37]];
                              }

                              if(6 == client.field389[var37]) {
                                 var44 = client.field407 % 20 < 10?16711680:16776960;
                              }

                              if(7 == client.field389[var37]) {
                                 var44 = client.field407 % 20 < 10?255:'\uffff';
                              }

                              if(client.field389[var37] == 8) {
                                 var44 = client.field407 % 20 < 10?'뀀':8454016;
                              }

                              int var45;
                              if(9 == client.field389[var37]) {
                                 var45 = 150 - client.field391[var37];
                                 if(var45 < 50) {
                                    var44 = 16711680 + 1280 * var45;
                                 } else if(var45 < 100) {
                                    var44 = 16776960 - (var45 - 50) * 327680;
                                 } else if(var45 < 150) {
                                    var44 = '\uff00' + (var45 - 100) * 5;
                                 }
                              }

                              if(10 == client.field389[var37]) {
                                 var45 = 150 - client.field391[var37];
                                 if(var45 < 50) {
                                    var44 = 16711680 + 5 * var45;
                                 } else if(var45 < 100) {
                                    var44 = 16711935 - 327680 * (var45 - 50);
                                 } else if(var45 < 150) {
                                    var44 = 255 + 327680 * (var45 - 100) - 5 * (var45 - 100);
                                 }
                              }

                              if(11 == client.field389[var37]) {
                                 var45 = 150 - client.field391[var37];
                                 if(var45 < 50) {
                                    var44 = 16777215 - var45 * 327685;
                                 } else if(var45 < 100) {
                                    var44 = (var45 - 50) * 327685 + '\uff00';
                                 } else if(var45 < 150) {
                                    var44 = 16777215 - (var45 - 100) * 327680;
                                 }
                              }

                              if(0 == client.field390[var37]) {
                                 class1.field28.method4039(var74, client.field358 * -1 + var19, var20 + client.field396 * -1, var44, 0);
                              }

                              if(1 == client.field390[var37]) {
                                 class1.field28.method3960(var74, client.field358 * -1 + var19, client.field396 * -1 + var20, var44, 0, client.field407);
                              }

                              if(2 == client.field390[var37]) {
                                 class1.field28.method3972(var74, client.field358 * -1 + var19, var20 + client.field396 * -1, var44, 0, client.field407);
                              }

                              if(3 == client.field390[var37]) {
                                 class1.field28.method3973(var74, var19 + client.field358 * -1, client.field396 * -1 + var20, var44, 0, client.field407, 150 - client.field391[var37]);
                              }

                              if(4 == client.field390[var37]) {
                                 var45 = (150 - client.field391[var37]) * (class1.field28.method3962(var74) + 100) / 150;
                                 class79.method1783(var19 + client.field358 * -1 - 50, var20, client.field358 * -1 + var19 + 50, var20 + var22);
                                 class1.field28.method3967(var74, client.field358 * -1 + var19 + 50 - var45, var20 + client.field396 * -1, var44, 0);
                                 class79.method1778(var19, var20, var21 + var19, var20 + var22);
                              }

                              if(5 == client.field390[var37]) {
                                 var45 = 150 - client.field391[var37];
                                 int var46 = 0;
                                 if(var45 < 25) {
                                    var46 = var45 - 25;
                                 } else if(var45 > 125) {
                                    var46 = var45 - 125;
                                 }

                                 class79.method1783(var19, client.field396 * -1 + var20 - class1.field28.field3182 - 1, var21 + var19, client.field396 * -1 + var20 + 5);
                                 class1.field28.method4039(var74, var19 + client.field358 * -1, var46 + var20 + client.field396 * -1, var44, 0);
                                 class79.method1778(var19, var20, var21 + var19, var22 + var20);
                              }
                           } else {
                              class1.field28.method4039(var74, var19 + client.field358 * -1, var20 + client.field396 * -1, 16776960, 0);
                           }
                        }

                        if(client.field351 == 2) {
                           class4.method42((client.field438 - class98.field1683 << 7) + client.field311, (client.field309 - class92.field1598 << 7) + client.field565, client.field310 * 2);
                           if(client.field358 * -1 > -1 && client.field394 % 20 < 10) {
                              class74.field1378[0].method1706(client.field358 * -1 + var19 - 12, var20 + client.field396 * -1 - 28);
                           }
                        }

                        ((class94)class90.field1576).method2144(client.field362);
                        if(1 == client.field400) {
                           client.field405[client.field305 / 100].method1706(client.field397 - 8, client.field479 - 8);
                        }

                        if(2 == client.field400) {
                           client.field405[4 + client.field305 / 100].method1706(client.field397 - 8, client.field479 - 8);
                        }

                        client.field471 = 0;
                        var33 = class98.field1683 + (class148.field2249.field839 >> 7);
                        var34 = class92.field1598 + (class148.field2249.field848 >> 7);
                        if(var33 >= 3053 && var33 <= 3156 && var34 >= 3056 && var34 <= 3136) {
                           client.field471 = 1;
                        }

                        if(var33 >= 3072 && var33 <= 3118 && var34 >= 9492 && var34 <= 9535) {
                           client.field471 = 1;
                        }

                        if(1 == client.field471 && var33 >= 3139 && var33 <= 3199 && var34 >= 3008 && var34 <= 3062) {
                           client.field471 = 0;
                        }

                        class142.field2197 = var25;
                        class36.field797 = var26;
                        class147.field2228 = var27;
                        client.field556 = var28;
                        class74.field1371 = var29;
                        if(client.field316) {
                           byte var73 = 0;
                           var34 = var73 + class170.field2741 + class170.field2726;
                           if(var34 == 0) {
                              client.field316 = false;
                           }
                        }

                        if(client.field316) {
                           class79.method1776(var19, var20, var21, var22, 0);
                           class10.method128("Loading - please wait.", false);
                        }

                        client.field493[var10.field2888] = true;
                        class79.method1778(var2, var3, var4, var5);
                        continue;
                     }

                     if(1338 == var10.field2763) {
                        class161.method3147(var10, var12, var13, var11);
                        class79.method1778(var2, var3, var4, var5);
                        continue;
                     }

                     if(1339 == var10.field2763) {
                        class174 var62 = var10.method3360(false);
                        if(var62 != null) {
                           if(client.field524 < 3) {
                              class0.field10.method1699(var12, var13, var62.field2903, var62.field2900, 25, 25, client.field374, 256, var62.field2902, var62.field2899);
                           } else {
                              class79.method1771(var12, var13, 0, var62.field2902, var62.field2899);
                           }
                        }

                        class79.method1778(var2, var3, var4, var5);
                        continue;
                     }
                  }

                  if(var10.field2849 == 0) {
                     if(!var10.field2758 && class18.method195(var10) && var10 != class74.field1376) {
                        continue;
                     }

                     if(!var10.field2758) {
                        if(var10.field2886 > var10.field2783 - var10.field2890) {
                           var10.field2886 = var10.field2783 - var10.field2890;
                        }

                        if(var10.field2886 < 0) {
                           var10.field2886 = 0;
                        }
                     }

                     method723(var0, var10.field2759 * -1, var15, var16, var17, var18, var12 - var10.field2829, var13 - var10.field2886, var11);
                     if(null != var10.field2881) {
                        method723(var10.field2881, var10.field2759 * -1, var15, var16, var17, var18, var12 - var10.field2829, var13 - var10.field2886, var11);
                     }

                     class3 var47 = (class3)client.field449.method3744((long)(var10.field2759 * -1));
                     if(null != var47) {
                        class89.method2055(var47.field66, var15, var16, var17, var18, var12, var13, var11);
                     }

                     class79.method1778(var2, var3, var4, var5);
                     class90.method2114();
                  }

                  if(client.field382 || client.field495[var11] || client.field513 > 1) {
                     int var23;
                     if(0 == var10.field2849 && !var10.field2758 && var10.field2783 > var10.field2890) {
                        var19 = var12 + var10.field2774;
                        var20 = var10.field2886;
                        var21 = var10.field2890;
                        var22 = var10.field2783;
                        class5.field104[0].method1838(var19, var13);
                        class5.field104[1].method1838(var19, var21 + var13 - 16);
                        class79.method1776(var19, var13 + 16, 16, var21 - 32, client.field366);
                        var23 = var21 * (var21 - 32) / var22;
                        if(var23 < 8) {
                           var23 = 8;
                        }

                        var24 = var20 * (var21 - 32 - var23) / (var22 - var21);
                        class79.method1776(var19, var13 + 16 + var24, 16, var23, client.field367);
                        class79.method1790(var19, var13 + 16 + var24, var23, client.field369);
                        class79.method1790(var19 + 1, var24 + 16 + var13, var23, client.field369);
                        class79.method1780(var19, var13 + 16 + var24, 16, client.field369);
                        class79.method1780(var19, var24 + 17 + var13, 16, client.field369);
                        class79.method1790(var19 + 15, var13 + 16 + var24, var23, client.field368);
                        class79.method1790(var19 + 14, var24 + var13 + 17, var23 - 1, client.field368);
                        class79.method1780(var19, var23 + var24 + var13 + 15, 16, client.field368);
                        class79.method1780(var19 + 1, var23 + var24 + 14 + var13, 15, client.field368);
                     }

                     if(var10.field2849 != 1) {
                        if(var10.field2849 == 2) {
                           var19 = 0;

                           for(var20 = 0; var20 < var10.field2771; ++var20) {
                              for(var21 = 0; var21 < var10.field2781; ++var21) {
                                 var22 = var21 * (var10.field2823 + 32) + var12;
                                 var23 = var20 * (var10.field2824 + 32) + var13;
                                 if(var19 < 20) {
                                    var22 += var10.field2749[var19];
                                    var23 += var10.field2826[var19];
                                 }

                                 if(var10.field2875[var19] <= 0) {
                                    if(null != var10.field2841 && var19 < 20) {
                                       class78 var67 = var10.method3384(var19);
                                       if(null != var67) {
                                          var67.method1706(var22, var23);
                                       } else if(class172.field2853) {
                                          class114.method2400(var10);
                                       }
                                    }
                                 } else {
                                    boolean var64 = false;
                                    boolean var57 = false;
                                    var26 = var10.field2875[var19] - 1;
                                    if(32 + var22 > var2 && var22 < var4 && 32 + var23 > var3 && var23 < var5 || var10 == class132.field2073 && client.field535 == var19) {
                                       class78 var58;
                                       if(1 == client.field301 && var19 == class164.field2672 && var10.field2759 * -1 == class47.field1074) {
                                          var58 = class27.method650(var26, var10.field2876[var19], 2, 0, 2, false);
                                       } else {
                                          var58 = class27.method650(var26, var10.field2876[var19], 1, 3153952, 2, false);
                                       }

                                       if(var58 != null) {
                                          if(var10 == class132.field2073 && var19 == client.field535) {
                                             var24 = class139.field2162 - client.field533;
                                             var25 = class139.field2171 - client.field292;
                                             if(var24 < 5 && var24 > -5) {
                                                var24 = 0;
                                             }

                                             if(var25 < 5 && var25 > -5) {
                                                var25 = 0;
                                             }

                                             if(client.field341 < 5) {
                                                var24 = 0;
                                                var25 = 0;
                                             }

                                             var58.method1694(var22 + var24, var23 + var25, 128);
                                             if(-1 != var1) {
                                                class172 var61 = var0[var1 & '\uffff'];
                                                if(var25 + var23 < class79.field1425 && var61.field2886 > 0) {
                                                   var29 = (class79.field1425 - var23 - var25) * client.field362 / 3;
                                                   if(var29 > client.field362 * 10) {
                                                      var29 = client.field362 * 10;
                                                   }

                                                   if(var29 > var61.field2886) {
                                                      var29 = var61.field2886;
                                                   }

                                                   var61.field2886 -= var29;
                                                   client.field292 += var29;
                                                   class114.method2400(var61);
                                                }

                                                if(var25 + var23 + 32 > class79.field1422 && var61.field2886 < var61.field2783 - var61.field2890) {
                                                   var29 = client.field362 * (32 + var23 + var25 - class79.field1422) / 3;
                                                   if(var29 > client.field362 * 10) {
                                                      var29 = client.field362 * 10;
                                                   }

                                                   if(var29 > var61.field2783 - var61.field2890 - var61.field2886) {
                                                      var29 = var61.field2783 - var61.field2890 - var61.field2886;
                                                   }

                                                   var61.field2886 += var29;
                                                   client.field292 -= var29;
                                                   class114.method2400(var61);
                                                }
                                             }
                                          } else if(class8.field141 == var10 && var19 == client.field402) {
                                             var58.method1694(var22, var23, 128);
                                          } else {
                                             var58.method1706(var22, var23);
                                          }
                                       } else {
                                          class114.method2400(var10);
                                       }
                                    }
                                 }

                                 ++var19;
                              }
                           }
                        } else if(var10.field2849 == 3) {
                           if(class72.method1568(var10)) {
                              var19 = var10.field2850;
                              if(class74.field1376 == var10 && 0 != var10.field2787) {
                                 var19 = var10.field2787;
                              }
                           } else {
                              var19 = var10.field2859;
                              if(class74.field1376 == var10 && var10.field2786 != 0) {
                                 var19 = var10.field2786;
                              }
                           }

                           if(0 == var14) {
                              if(var10.field2788) {
                                 class79.method1776(var12, var13, var10.field2774, var10.field2890, var19);
                              } else {
                                 class79.method1813(var12, var13, var10.field2774, var10.field2890, var19);
                              }
                           } else if(var10.field2788) {
                              class79.method1818(var12, var13, var10.field2774, var10.field2890, var19, 256 - (var14 & 255));
                           } else {
                              class79.method1779(var12, var13, var10.field2774, var10.field2890, var19, 256 - (var14 & 255));
                           }
                        } else {
                           class223 var48;
                           if(var10.field2849 == 4) {
                              var48 = var10.method3373();
                              if(null == var48) {
                                 if(class172.field2853) {
                                    class114.method2400(var10);
                                 }
                              } else {
                                 String var60 = var10.field2817;
                                 if(class72.method1568(var10)) {
                                    var20 = var10.field2850;
                                    if(class74.field1376 == var10 && var10.field2787 != 0) {
                                       var20 = var10.field2787;
                                    }

                                    if(var10.field2804.length() > 0) {
                                       var60 = var10.field2804;
                                    }
                                 } else {
                                    var20 = var10.field2859;
                                    if(class74.field1376 == var10 && 0 != var10.field2786) {
                                       var20 = var10.field2786;
                                    }
                                 }

                                 if(var10.field2758 && var10.field2877 != -1) {
                                    class51 var68 = class22.method581(var10.field2877);
                                    var60 = var68.field1121;
                                    if(null == var60) {
                                       var60 = "null";
                                    }

                                    if((var68.field1134 == 1 || 1 != var10.field2878) && var10.field2878 != -1) {
                                       var60 = class24.method592(16748608) + var60 + "</col>" + " " + 'x' + class100.method2244(var10.field2878);
                                    }
                                 }

                                 if(client.field452 == var10) {
                                    class156 var10000 = (class156)null;
                                    var60 = "Please wait...";
                                    var20 = var10.field2859;
                                 }

                                 if(!var10.field2758) {
                                    var60 = class130.method2774(var60, var10);
                                 }

                                 var48.method3970(var60, var12, var13, var10.field2774, var10.field2890, var20, var10.field2822?0:-1, var10.field2820, var10.field2821, var10.field2819);
                              }
                           } else if(var10.field2849 == 5) {
                              class78 var51;
                              if(!var10.field2758) {
                                 var51 = var10.method3356(class72.method1568(var10));
                                 if(var51 != null) {
                                    var51.method1706(var12, var13);
                                 } else if(class172.field2853) {
                                    class114.method2400(var10);
                                 }
                              } else {
                                 if(var10.field2877 != -1) {
                                    var51 = class27.method650(var10.field2877, var10.field2878, var10.field2796, var10.field2797, var10.field2815, false);
                                 } else {
                                    var51 = var10.method3356(false);
                                 }

                                 if(null == var51) {
                                    if(class172.field2853) {
                                       class114.method2400(var10);
                                    }
                                 } else {
                                    var20 = var51.field1421;
                                    var21 = var51.field1416;
                                    if(!var10.field2795) {
                                       var22 = var10.field2774 * 4096 / var20;
                                       if(0 != var10.field2761) {
                                          var51.method1701(var10.field2774 / 2 + var12, var10.field2890 / 2 + var13, var10.field2761, var22);
                                       } else if(0 != var14) {
                                          var51.method1679(var12, var13, var10.field2774, var10.field2890, 256 - (var14 & 255));
                                       } else if(var10.field2774 == var20 && var21 == var10.field2890) {
                                          var51.method1706(var12, var13);
                                       } else {
                                          var51.method1740(var12, var13, var10.field2774, var10.field2890);
                                       }
                                    } else {
                                       class79.method1783(var12, var13, var10.field2774 + var12, var13 + var10.field2890);
                                       var22 = (var10.field2774 + (var20 - 1)) / var20;
                                       var23 = (var10.field2890 + (var21 - 1)) / var21;

                                       for(var24 = 0; var24 < var22; ++var24) {
                                          for(var25 = 0; var25 < var23; ++var25) {
                                             if(var10.field2761 != 0) {
                                                var51.method1701(var20 / 2 + var20 * var24 + var12, var13 + var21 * var25 + var21 / 2, var10.field2761, 4096);
                                             } else if(0 != var14) {
                                                var51.method1694(var12 + var20 * var24, var25 * var21 + var13, 256 - (var14 & 255));
                                             } else {
                                                var51.method1706(var12 + var24 * var20, var21 * var25 + var13);
                                             }
                                          }
                                       }

                                       class79.method1778(var2, var3, var4, var5);
                                    }
                                 }
                              }
                           } else {
                              class51 var52;
                              if(var10.field2849 == 6) {
                                 boolean var50 = class72.method1568(var10);
                                 if(var50) {
                                    var20 = var10.field2805;
                                 } else {
                                    var20 = var10.field2836;
                                 }

                                 class104 var56 = null;
                                 var22 = 0;
                                 if(-1 != var10.field2877) {
                                    var52 = class22.method581(var10.field2877);
                                    if(null != var52) {
                                       var52 = var52.method1016(var10.field2878);
                                       var56 = var52.method1032(1);
                                       if(null != var56) {
                                          var56.method2261();
                                          var22 = var56.field1461 / 2;
                                       } else {
                                          class114.method2400(var10);
                                       }
                                    }
                                 } else if(5 == var10.field2800) {
                                    if(var10.field2857 == 0) {
                                       var56 = client.field475.method3438((class42)null, -1, (class42)null, -1);
                                    } else {
                                       var56 = class148.field2249.vmethod1870();
                                    }
                                 } else if(-1 == var20) {
                                    var56 = var10.method3359((class42)null, -1, var50, class148.field2249.field34);
                                    if(null == var56 && class172.field2853) {
                                       class114.method2400(var10);
                                    }
                                 } else {
                                    class42 var59 = class36.method741(var20);
                                    var56 = var10.method3359(var59, var10.field2816, var50, class148.field2249.field34);
                                    if(var56 == null && class172.field2853) {
                                       class114.method2400(var10);
                                    }
                                 }

                                 class90.method2062(var10.field2774 / 2 + var12, var13 + var10.field2890 / 2);
                                 var23 = class90.field1587[var10.field2808] * var10.field2818 >> 16;
                                 var24 = class90.field1590[var10.field2808] * var10.field2818 >> 16;
                                 if(var56 != null) {
                                    if(!var10.field2758) {
                                       var56.method2289(0, var10.field2809, 0, var10.field2808, 0, var23, var24);
                                    } else {
                                       var56.method2261();
                                       if(var10.field2801) {
                                          var56.method2273(0, var10.field2809, var10.field2810, var10.field2808, var10.field2770, var10.field2839 + var22 + var23, var24 + var10.field2839, var10.field2818);
                                       } else {
                                          var56.method2289(0, var10.field2809, var10.field2810, var10.field2808, var10.field2770, var10.field2839 + var22 + var23, var24 + var10.field2839);
                                       }
                                    }
                                 }

                                 class90.method2119();
                              } else {
                                 if(7 == var10.field2849) {
                                    var48 = var10.method3373();
                                    if(var48 == null) {
                                       if(class172.field2853) {
                                          class114.method2400(var10);
                                       }
                                       continue;
                                    }

                                    var20 = 0;

                                    for(var21 = 0; var21 < var10.field2771; ++var21) {
                                       for(var22 = 0; var22 < var10.field2781; ++var22) {
                                          if(var10.field2875[var20] > 0) {
                                             var52 = class22.method581(var10.field2875[var20] - 1);
                                             String var55;
                                             if(var52.field1134 != 1 && var10.field2876[var20] == 1) {
                                                var55 = class24.method592(16748608) + var52.field1121 + "</col>";
                                             } else {
                                                var55 = class24.method592(16748608) + var52.field1121 + "</col>" + " " + 'x' + class100.method2244(var10.field2876[var20]);
                                             }

                                             var25 = var12 + (var10.field2823 + 115) * var22;
                                             var26 = (12 + var10.field2824) * var21 + var13;
                                             if(var10.field2820 == 0) {
                                                var48.method3967(var55, var25, var26, var10.field2859, var10.field2822?0:-1);
                                             } else if(1 == var10.field2820) {
                                                var48.method4039(var55, var25 + var10.field2774 / 2, var26, var10.field2859, var10.field2822?0:-1);
                                             } else {
                                                var48.method3968(var55, var10.field2774 + var25 - 1, var26, var10.field2859, var10.field2822?0:-1);
                                             }
                                          }

                                          ++var20;
                                       }
                                    }
                                 }

                                 if(8 == var10.field2849 && class52.field1171 == var10 && client.field440 == client.field439) {
                                    var19 = 0;
                                    var20 = 0;
                                    class223 var49 = class29.field692;
                                    String var53 = var10.field2817;

                                    String var54;
                                    for(var53 = class130.method2774(var53, var10); var53.length() > 0; var20 += 1 + var49.field3182) {
                                       var24 = var53.indexOf("<br>");
                                       if(var24 != -1) {
                                          var54 = var53.substring(0, var24);
                                          var53 = var53.substring(var24 + 4);
                                       } else {
                                          var54 = var53;
                                          var53 = "";
                                       }

                                       var25 = var49.method3962(var54);
                                       if(var25 > var19) {
                                          var19 = var25;
                                       }
                                    }

                                    var19 += 6;
                                    var20 += 7;
                                    var24 = var12 + var10.field2774 - 5 - var19;
                                    var25 = var13 + var10.field2890 + 5;
                                    if(var24 < 5 + var12) {
                                       var24 = var12 + 5;
                                    }

                                    if(var24 + var19 > var4) {
                                       var24 = var4 - var19;
                                    }

                                    if(var25 + var20 > var5) {
                                       var25 = var5 - var20;
                                    }

                                    class79.method1776(var24, var25, var19, var20, 16777120);
                                    class79.method1813(var24, var25, var19, var20, 0);
                                    var53 = var10.field2817;
                                    var26 = var25 + var49.field3182 + 2;

                                    for(var53 = class130.method2774(var53, var10); var53.length() > 0; var26 += 1 + var49.field3182) {
                                       var27 = var53.indexOf("<br>");
                                       if(var27 != -1) {
                                          var54 = var53.substring(0, var27);
                                          var53 = var53.substring(var27 + 4);
                                       } else {
                                          var54 = var53;
                                          var53 = "";
                                       }

                                       var49.method3967(var54, 3 + var24, var26, 0, -1);
                                    }
                                 }

                                 if(var10.field2849 == 9) {
                                    if(var10.field2790 == 1) {
                                       if(var10.field2791) {
                                          var19 = var12;
                                          var20 = var13 + var10.field2890;
                                          var21 = var12 + var10.field2774;
                                          var22 = var13;
                                       } else {
                                          var19 = var12;
                                          var20 = var13;
                                          var21 = var12 + var10.field2774;
                                          var22 = var13 + var10.field2890;
                                       }

                                       class79.method1784(var19, var20, var21, var22, var10.field2859);
                                    } else {
                                       var19 = var10.field2774 >= 0?var10.field2774:-var10.field2774;
                                       var20 = var10.field2890 >= 0?var10.field2890:-var10.field2890;
                                       var21 = var19;
                                       if(var19 < var20) {
                                          var21 = var20;
                                       }

                                       if(var21 != 0) {
                                          var22 = (var10.field2774 << 16) / var21;
                                          var23 = (var10.field2890 << 16) / var21;
                                          if(var23 <= var22) {
                                             var22 = -var22;
                                          } else {
                                             var23 = -var23;
                                          }

                                          var24 = var23 * var10.field2790 >> 17;
                                          var25 = 1 + var10.field2790 * var23 >> 17;
                                          var26 = var22 * var10.field2790 >> 17;
                                          var27 = var22 * var10.field2790 + 1 >> 17;
                                          var28 = var12 + var24;
                                          var29 = var12 - var25;
                                          var30 = var10.field2774 + var12 - var25;
                                          var31 = var24 + var12 + var10.field2774;
                                          var32 = var13 + var26;
                                          var33 = var13 - var27;
                                          var34 = var13 + var10.field2890 - var27;
                                          var35 = var26 + var13 + var10.field2890;
                                          class90.method2067(var28, var29, var30);
                                          class90.method2070(var32, var33, var34, var28, var29, var30, var10.field2859);
                                          class90.method2067(var28, var30, var31);
                                          class90.method2070(var32, var34, var35, var28, var30, var31, var10.field2859);
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
}
