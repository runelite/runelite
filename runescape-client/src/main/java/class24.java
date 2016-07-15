import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("d")
public final class class24 extends class211 {
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 910580931
   )
   int field626;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -1183428401
   )
   int field627;
   @ObfuscatedName("e")
   static class202 field628 = new class202();
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 373696137
   )
   int field629;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -79437789
   )
   int field630;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 313385595
   )
   int field631;
   @ObfuscatedName("r")
   class42 field632;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 871729707
   )
   int field633;
   @ObfuscatedName("p")
   class67 field634;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 364571215
   )
   int field635;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 270805759
   )
   int field636;
   @ObfuscatedName("g")
   int[] field637;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 2018265607
   )
   int field638;
   @ObfuscatedName("w")
   class67 field639;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -1810844099
   )
   int field640;
   @ObfuscatedName("dp")
   static int[] field643;
   @ObfuscatedName("cs")
   static class149 field645;

   @ObfuscatedName("dv")
   @ObfuscatedSignature(
      signature = "(IIIIIIII)V",
      garbageValue = "1664109372"
   )
   static final void method578(int var0, int var1, int var2, int var3, int var4, int var5, int var6) {
      if(class10.method112(var0)) {
         class35.method749(class176.field2811[var0], -1, var1, var2, var3, var4, var5, var6);
      }
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(Lclass170;Ljava/lang/String;Ljava/lang/String;B)Lclass83;",
      garbageValue = "3"
   )
   public static class83 method580(class170 var0, String var1, String var2) {
      int var3 = var0.method3342(var1);
      int var4 = var0.method3357(var3, var2);
      class83 var5;
      if(!class42.method884(var0, var3, var4)) {
         var5 = null;
      } else {
         class83 var7 = new class83();
         var7.field1485 = class79.field1458;
         var7.field1484 = class79.field1452;
         var7.field1488 = class79.field1449[0];
         var7.field1491 = class11.field192[0];
         var7.field1486 = class138.field2134[0];
         var7.field1489 = class169.field2703[0];
         var7.field1487 = class178.field2941;
         var7.field1490 = class93.field1626[0];
         class52.method1134();
         var5 = var7;
      }

      return var5;
   }

   @ObfuscatedName("cw")
   @ObfuscatedSignature(
      signature = "([Lclass176;IIIIIIIII)V",
      garbageValue = "1232771612"
   )
   @Export("gameDraw")
   static final void method581(class176[] var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
      class82.method1934(var2, var3, var4, var5);
      class94.method2184();

      for(int var9 = 0; var9 < var0.length; ++var9) {
         class176 var10 = var0[var9];
         if(var10 != null && (var10.field2813 == var1 || var1 == -1412584499 && client.field492 == var10)) {
            int var11;
            if(var8 == -1) {
               client.field503[client.field457] = var6 + var10.field2807;
               client.field504[client.field457] = var7 + var10.field2808;
               client.field505[client.field457] = var10.field2866;
               client.field466[client.field457] = var10.field2810;
               var11 = ++client.field457 - 1;
            } else {
               var11 = var8;
            }

            var10.field2925 = var11;
            var10.field2821 = client.field567;
            if(!var10.field2793 || !class78.method1733(var10)) {
               if(var10.field2916 > 0) {
                  class109.method2463(var10);
               }

               int var12 = var10.field2807 + var6;
               int var13 = var7 + var10.field2808;
               int var14 = var10.field2865;
               int var15;
               int var16;
               if(client.field492 == var10) {
                  if(var1 != -1412584499 && !var10.field2910) {
                     class8.field145 = var0;
                     class62.field1286 = var6;
                     class141.field2186 = var7;
                     continue;
                  }

                  if(client.field424 && client.field472) {
                     var15 = class143.field2198;
                     var16 = class143.field2201;
                     var15 -= client.field481;
                     var16 -= client.field470;
                     if(var15 < client.field473) {
                        var15 = client.field473;
                     }

                     if(var15 + var10.field2866 > client.field403.field2866 + client.field473) {
                        var15 = client.field473 + client.field403.field2866 - var10.field2866;
                     }

                     if(var16 < client.field474) {
                        var16 = client.field474;
                     }

                     if(var10.field2810 + var16 > client.field403.field2810 + client.field474) {
                        var16 = client.field474 + client.field403.field2810 - var10.field2810;
                     }

                     var12 = var15;
                     var13 = var16;
                  }

                  if(!var10.field2910) {
                     var14 = 128;
                  }
               }

               int var17;
               int var18;
               int var19;
               int var20;
               int var22;
               int var39;
               if(var10.field2796 == 2) {
                  var15 = var2;
                  var16 = var3;
                  var17 = var4;
                  var18 = var5;
               } else if(var10.field2796 == 9) {
                  var19 = var12;
                  var20 = var13;
                  var39 = var10.field2866 + var12;
                  var22 = var10.field2810 + var13;
                  if(var39 < var12) {
                     var19 = var39;
                     var39 = var12;
                  }

                  if(var22 < var13) {
                     var20 = var22;
                     var22 = var13;
                  }

                  ++var39;
                  ++var22;
                  var15 = var19 > var2?var19:var2;
                  var16 = var20 > var3?var20:var3;
                  var17 = var39 < var4?var39:var4;
                  var18 = var22 < var5?var22:var5;
               } else {
                  var19 = var10.field2866 + var12;
                  var20 = var13 + var10.field2810;
                  var15 = var12 > var2?var12:var2;
                  var16 = var13 > var3?var13:var3;
                  var17 = var19 < var4?var19:var4;
                  var18 = var20 < var5?var20:var5;
               }

               if(!var10.field2793 || var15 < var17 && var16 < var18) {
                  if(var10.field2916 != 0) {
                     if(var10.field2916 == 1336) {
                        if(client.field309) {
                           var13 += 15;
                           class104.field1834.method4114("Fps:" + class147.field2246, var12 + var10.field2866, var13, 16776960, -1);
                           var13 += 15;
                           Runtime var53 = Runtime.getRuntime();
                           var20 = (int)((var53.totalMemory() - var53.freeMemory()) / 1024L);
                           var39 = 16776960;
                           if(var20 > '耀' && client.field298) {
                              var39 = 16711680;
                           }

                           if(var20 > 65536 && !client.field298) {
                              var39 = 16711680;
                           }

                           class104.field1834.method4114("Mem:" + var20 + "k", var10.field2866 + var12, var13, var39, -1);
                           var13 += 15;
                        }
                        continue;
                     }

                     if(var10.field2916 == 1337) {
                        client.field295 = var12;
                        client.field443 = var13;
                        class128.method2917(var12, var13, var10.field2866, var10.field2810);
                        client.field500[var10.field2925] = true;
                        class82.method1934(var2, var3, var4, var5);
                        continue;
                     }

                     if(var10.field2916 == 1338) {
                        class30.method666(var10, var12, var13, var11);
                        class82.method1934(var2, var3, var4, var5);
                        continue;
                     }

                     if(var10.field2916 == 1339) {
                        class142.method3043(var10, var12, var13, var11);
                        class82.method1934(var2, var3, var4, var5);
                        continue;
                     }
                  }

                  if(var10.field2796 == 0) {
                     if(!var10.field2793 && class78.method1733(var10) && var10 != class99.field1699) {
                        continue;
                     }

                     if(!var10.field2793) {
                        if(var10.field2883 > var10.field2867 - var10.field2810) {
                           var10.field2883 = var10.field2867 - var10.field2810;
                        }

                        if(var10.field2883 < 0) {
                           var10.field2883 = 0;
                        }
                     }

                     method581(var0, var10.field2794, var15, var16, var17, var18, var12 - var10.field2815, var13 - var10.field2883, var11);
                     if(var10.field2827 != null) {
                        method581(var10.field2827, var10.field2794, var15, var16, var17, var18, var12 - var10.field2815, var13 - var10.field2883, var11);
                     }

                     class3 var40 = (class3)client.field455.method3864((long)var10.field2794);
                     if(null != var40) {
                        class21.method553(var40.field60, var15, var16, var17, var18, var12, var13, var11);
                     }

                     class82.method1934(var2, var3, var4, var5);
                     class94.method2184();
                  }

                  if(client.field509 || client.field502[var11] || client.field507 > 1) {
                     int var23;
                     int var24;
                     if(var10.field2796 == 0 && !var10.field2793 && var10.field2867 > var10.field2810) {
                        var19 = var12 + var10.field2866;
                        var20 = var10.field2883;
                        var39 = var10.field2810;
                        var22 = var10.field2867;
                        class214.field3178[0].method1952(var19, var13);
                        class214.field3178[1].method1952(var19, var13 + var39 - 16);
                        class82.method1911(var19, 16 + var13, 16, var39 - 32, client.field373);
                        var23 = (var39 - 32) * var39 / var22;
                        if(var23 < 8) {
                           var23 = 8;
                        }

                        var24 = (var39 - 32 - var23) * var20 / (var22 - var39);
                        class82.method1911(var19, 16 + var13 + var24, 16, var23, client.field374);
                        class82.method1899(var19, var24 + var13 + 16, var23, client.field319);
                        class82.method1899(var19 + 1, var24 + var13 + 16, var23, client.field319);
                        class82.method1897(var19, var24 + var13 + 16, 16, client.field319);
                        class82.method1897(var19, 17 + var13 + var24, 16, client.field319);
                        class82.method1899(var19 + 15, var24 + 16 + var13, var23, client.field375);
                        class82.method1899(14 + var19, 17 + var13 + var24, var23 - 1, client.field375);
                        class82.method1897(var19, var24 + var13 + 15 + var23, 16, client.field375);
                        class82.method1897(1 + var19, var24 + 14 + var13 + var23, 15, client.field375);
                     }

                     if(var10.field2796 != 1) {
                        int var25;
                        int var26;
                        int var29;
                        if(var10.field2796 == 2) {
                           var19 = 0;

                           for(var20 = 0; var20 < var10.field2806; ++var20) {
                              for(var39 = 0; var39 < var10.field2805; ++var39) {
                                 var22 = var12 + var39 * (32 + var10.field2904);
                                 var23 = var20 * (var10.field2887 + 32) + var13;
                                 if(var19 < 20) {
                                    var22 += var10.field2862[var19];
                                    var23 += var10.field2824[var19];
                                 }

                                 if(var10.field2912[var19] <= 0) {
                                    if(var10.field2880 != null && var19 < 20) {
                                       class81 var54 = var10.method3491(var19);
                                       if(null != var54) {
                                          var54.method1873(var22, var23);
                                       } else if(class176.field2828) {
                                          class51.method1124(var10);
                                       }
                                    }
                                 } else {
                                    boolean var46 = false;
                                    boolean var47 = false;
                                    var26 = var10.field2912[var19] - 1;
                                    if(var22 + 32 > var2 && var22 < var4 && var23 + 32 > var3 && var23 < var5 || class159.field2356 == var10 && client.field409 == var19) {
                                       class81 var27;
                                       if(client.field459 == 1 && class6.field124 == var19 && class93.field1624 == var10.field2794) {
                                          var27 = class33.method717(var26, var10.field2809[var19], 2, 0, 2, false);
                                       } else {
                                          var27 = class33.method717(var26, var10.field2809[var19], 1, 3153952, 2, false);
                                       }

                                       if(var27 != null) {
                                          if(class159.field2356 == var10 && client.field409 == var19) {
                                             var24 = class143.field2198 - client.field377;
                                             var25 = class143.field2201 - client.field395;
                                             if(var24 < 5 && var24 > -5) {
                                                var24 = 0;
                                             }

                                             if(var25 < 5 && var25 > -5) {
                                                var25 = 0;
                                             }

                                             if(client.field465 < 5) {
                                                var24 = 0;
                                                var25 = 0;
                                             }

                                             var27.method1807(var24 + var22, var25 + var23, 128);
                                             if(var1 != -1) {
                                                class176 var28 = var0[var1 & '\uffff'];
                                                if(var23 + var25 < class82.field1480 && var28.field2883 > 0) {
                                                   var29 = (class82.field1480 - var23 - var25) * client.field485 / 3;
                                                   if(var29 > client.field485 * 10) {
                                                      var29 = client.field485 * 10;
                                                   }

                                                   if(var29 > var28.field2883) {
                                                      var29 = var28.field2883;
                                                   }

                                                   var28.field2883 -= var29;
                                                   client.field395 += var29;
                                                   class51.method1124(var28);
                                                }

                                                if(32 + var25 + var23 > class82.field1479 && var28.field2883 < var28.field2867 - var28.field2810) {
                                                   var29 = client.field485 * (32 + var23 + var25 - class82.field1479) / 3;
                                                   if(var29 > client.field485 * 10) {
                                                      var29 = client.field485 * 10;
                                                   }

                                                   if(var29 > var28.field2867 - var28.field2810 - var28.field2883) {
                                                      var29 = var28.field2867 - var28.field2810 - var28.field2883;
                                                   }

                                                   var28.field2883 += var29;
                                                   client.field395 -= var29;
                                                   class51.method1124(var28);
                                                }
                                             }
                                          } else if(class9.field160 == var10 && client.field555 == var19) {
                                             var27.method1807(var22, var23, 128);
                                          } else {
                                             var27.method1873(var22, var23);
                                          }
                                       } else {
                                          class51.method1124(var10);
                                       }
                                    }
                                 }

                                 ++var19;
                              }
                           }
                        } else if(var10.field2796 == 3) {
                           if(class28.method646(var10)) {
                              var19 = var10.field2820;
                              if(var10 == class99.field1699 && var10.field2877 != 0) {
                                 var19 = var10.field2877;
                              }
                           } else {
                              var19 = var10.field2798;
                              if(class99.field1699 == var10 && var10.field2871 != 0) {
                                 var19 = var10.field2871;
                              }
                           }

                           if(var10.field2859) {
                              switch(var10.field2909.field1498) {
                              case 1:
                                 class82.method1890(var12, var13, var10.field2866, var10.field2810, var10.field2798, var10.field2820, 256 - (var10.field2865 & 255), 256 - (var10.field2826 & 255));
                                 break;
                              case 2:
                                 class82.method1891(var12, var13, var10.field2866, var10.field2810, var10.field2798, var10.field2820, 256 - (var10.field2865 & 255), 256 - (var10.field2826 & 255));
                                 break;
                              case 3:
                                 class82.method1892(var12, var13, var10.field2866, var10.field2810, var10.field2798, var10.field2820, 256 - (var10.field2865 & 255), 256 - (var10.field2826 & 255));
                                 break;
                              case 4:
                                 class82.method1893(var12, var13, var10.field2866, var10.field2810, var10.field2798, var10.field2820, 256 - (var10.field2865 & 255), 256 - (var10.field2826 & 255));
                                 break;
                              default:
                                 if(var14 == 0) {
                                    class82.method1911(var12, var13, var10.field2866, var10.field2810, var19);
                                 } else {
                                    class82.method1895(var12, var13, var10.field2866, var10.field2810, var19, 256 - (var14 & 255));
                                 }
                              }
                           } else if(var14 == 0) {
                              class82.method1925(var12, var13, var10.field2866, var10.field2810, var19);
                           } else {
                              class82.method1896(var12, var13, var10.field2866, var10.field2810, var19, 256 - (var14 & 255));
                           }
                        } else {
                           class227 var51;
                           if(var10.field2796 == 4) {
                              var51 = var10.method3497();
                              if(var51 == null) {
                                 if(class176.field2828) {
                                    class51.method1124(var10);
                                 }
                              } else {
                                 String var45 = var10.field2844;
                                 if(class28.method646(var10)) {
                                    var20 = var10.field2820;
                                    if(var10 == class99.field1699 && var10.field2877 != 0) {
                                       var20 = var10.field2877;
                                    }

                                    if(var10.field2855.length() > 0) {
                                       var45 = var10.field2855;
                                    }
                                 } else {
                                    var20 = var10.field2798;
                                    if(class99.field1699 == var10 && var10.field2871 != 0) {
                                       var20 = var10.field2871;
                                    }
                                 }

                                 if(var10.field2793 && var10.field2914 != -1) {
                                    class55 var50 = class9.method108(var10.field2914);
                                    var45 = var50.field1183;
                                    if(var45 == null) {
                                       var45 = "null";
                                    }

                                    if((var50.field1194 == 1 || var10.field2915 != 1) && var10.field2915 != -1) {
                                       var45 = class117.method2530(16748608) + var45 + "</col>" + " " + 'x' + class20.method540(var10.field2915);
                                    }
                                 }

                                 if(client.field371 == var10) {
                                    Object var10000 = null;
                                    var45 = "Please wait...";
                                    var20 = var10.field2798;
                                 }

                                 if(!var10.field2793) {
                                    var45 = class42.method886(var45, var10);
                                 }

                                 var51.method4116(var45, var12, var13, var10.field2866, var10.field2810, var20, var10.field2896?0:-1, var10.field2842, var10.field2854, var10.field2856);
                              }
                           } else if(var10.field2796 == 5) {
                              class81 var52;
                              if(!var10.field2793) {
                                 var52 = var10.method3505(class28.method646(var10));
                                 if(null != var52) {
                                    var52.method1873(var12, var13);
                                 } else if(class176.field2828) {
                                    class51.method1124(var10);
                                 }
                              } else {
                                 if(var10.field2914 != -1) {
                                    var52 = class33.method717(var10.field2914, var10.field2915, var10.field2833, var10.field2876, var10.field2852, false);
                                 } else {
                                    var52 = var10.method3505(false);
                                 }

                                 if(var52 == null) {
                                    if(class176.field2828) {
                                       class51.method1124(var10);
                                    }
                                 } else {
                                    var20 = var52.field1471;
                                    var39 = var52.field1469;
                                    if(!var10.field2832) {
                                       var22 = var10.field2866 * 4096 / var20;
                                       if(var10.field2831 != 0) {
                                          var52.method1820(var10.field2866 / 2 + var12, var13 + var10.field2810 / 2, var10.field2831, var22);
                                       } else if(var14 != 0) {
                                          var52.method1809(var12, var13, var10.field2866, var10.field2810, 256 - (var14 & 255));
                                       } else if(var20 == var10.field2866 && var10.field2810 == var39) {
                                          var52.method1873(var12, var13);
                                       } else {
                                          var52.method1824(var12, var13, var10.field2866, var10.field2810);
                                       }
                                    } else {
                                       class82.method1884(var12, var13, var12 + var10.field2866, var13 + var10.field2810);
                                       var22 = (var20 - 1 + var10.field2866) / var20;
                                       var23 = (var39 - 1 + var10.field2810) / var39;

                                       for(var24 = 0; var24 < var22; ++var24) {
                                          for(var25 = 0; var25 < var23; ++var25) {
                                             if(var10.field2831 != 0) {
                                                var52.method1820(var12 + var20 * var24 + var20 / 2, var13 + var25 * var39 + var39 / 2, var10.field2831, 4096);
                                             } else if(var14 != 0) {
                                                var52.method1807(var20 * var24 + var12, var13 + var25 * var39, 256 - (var14 & 255));
                                             } else {
                                                var52.method1873(var20 * var24 + var12, var13 + var39 * var25);
                                             }
                                          }
                                       }

                                       class82.method1934(var2, var3, var4, var5);
                                    }
                                 }
                              }
                           } else {
                              class55 var36;
                              if(var10.field2796 == 6) {
                                 boolean var44 = class28.method646(var10);
                                 if(var44) {
                                    var20 = var10.field2784;
                                 } else {
                                    var20 = var10.field2841;
                                 }

                                 class108 var43 = null;
                                 var22 = 0;
                                 if(var10.field2914 != -1) {
                                    var36 = class9.method108(var10.field2914);
                                    if(null != var36) {
                                       var36 = var36.method1169(var10.field2915);
                                       var43 = var36.method1160(1);
                                       if(null != var43) {
                                          var43.method2381();
                                          var22 = var43.field1529 / 2;
                                       } else {
                                          class51.method1124(var10);
                                       }
                                    }
                                 } else if(var10.field2837 == 5) {
                                    if(var10.field2863 == 0) {
                                       var43 = client.field568.method3583((class44)null, -1, (class44)null, -1);
                                    } else {
                                       var43 = class118.field2035.vmethod1999();
                                    }
                                 } else if(var20 == -1) {
                                    var43 = var10.method3492((class44)null, -1, var44, class118.field2035.field53);
                                    if(null == var43 && class176.field2828) {
                                       class51.method1124(var10);
                                    }
                                 } else {
                                    class44 var49 = class13.method153(var20);
                                    var43 = var10.method3492(var49, var10.field2790, var44, class118.field2035.field53);
                                    if(var43 == null && class176.field2828) {
                                       class51.method1124(var10);
                                    }
                                 }

                                 class94.method2227(var10.field2866 / 2 + var12, var13 + var10.field2810 / 2);
                                 var23 = class94.field1655[var10.field2845] * var10.field2848 >> 16;
                                 var24 = class94.field1653[var10.field2845] * var10.field2848 >> 16;
                                 if(var43 != null) {
                                    if(!var10.field2793) {
                                       var43.method2422(0, var10.field2846, 0, var10.field2845, 0, var23, var24);
                                    } else {
                                       var43.method2381();
                                       if(var10.field2851) {
                                          var43.method2416(0, var10.field2846, var10.field2929, var10.field2845, var10.field2843, var22 + var23 + var10.field2838, var10.field2838 + var24, var10.field2848);
                                       } else {
                                          var43.method2422(0, var10.field2846, var10.field2929, var10.field2845, var10.field2843, var23 + var22 + var10.field2838, var10.field2838 + var24);
                                       }
                                    }
                                 }

                                 class94.method2207();
                              } else {
                                 if(var10.field2796 == 7) {
                                    var51 = var10.method3497();
                                    if(var51 == null) {
                                       if(class176.field2828) {
                                          class51.method1124(var10);
                                       }
                                       continue;
                                    }

                                    var20 = 0;

                                    for(var39 = 0; var39 < var10.field2806; ++var39) {
                                       for(var22 = 0; var22 < var10.field2805; ++var22) {
                                          if(var10.field2912[var20] > 0) {
                                             var36 = class9.method108(var10.field2912[var20] - 1);
                                             String var41;
                                             if(var36.field1194 != 1 && var10.field2809[var20] == 1) {
                                                var41 = class117.method2530(16748608) + var36.field1183 + "</col>";
                                             } else {
                                                var41 = class117.method2530(16748608) + var36.field1183 + "</col>" + " " + 'x' + class20.method540(var10.field2809[var20]);
                                             }

                                             var25 = var12 + var22 * (var10.field2904 + 115);
                                             var26 = var13 + var39 * (var10.field2887 + 12);
                                             if(var10.field2842 == 0) {
                                                var51.method4177(var41, var25, var26, var10.field2798, var10.field2896?0:-1);
                                             } else if(var10.field2842 == 1) {
                                                var51.method4119(var41, var25 + var10.field2866 / 2, var26, var10.field2798, var10.field2896?0:-1);
                                             } else {
                                                var51.method4114(var41, var10.field2866 + var25 - 1, var26, var10.field2798, var10.field2896?0:-1);
                                             }
                                          }

                                          ++var20;
                                       }
                                    }
                                 }

                                 int var38;
                                 if(var10.field2796 == 8 && var10 == class170.field2726 && client.field361 == client.field444) {
                                    var19 = 0;
                                    var20 = 0;
                                    class227 var21 = class104.field1834;
                                    String var37 = var10.field2844;

                                    String var48;
                                    for(var37 = class42.method886(var37, var10); var37.length() > 0; var20 += var21.field3242 + 1) {
                                       var24 = var37.indexOf("<br>");
                                       if(var24 != -1) {
                                          var48 = var37.substring(0, var24);
                                          var37 = var37.substring(4 + var24);
                                       } else {
                                          var48 = var37;
                                          var37 = "";
                                       }

                                       var25 = var21.method4179(var48);
                                       if(var25 > var19) {
                                          var19 = var25;
                                       }
                                    }

                                    var19 += 6;
                                    var20 += 7;
                                    var24 = var10.field2866 + var12 - 5 - var19;
                                    var25 = 5 + var13 + var10.field2810;
                                    if(var24 < var12 + 5) {
                                       var24 = var12 + 5;
                                    }

                                    if(var24 + var19 > var4) {
                                       var24 = var4 - var19;
                                    }

                                    if(var20 + var25 > var5) {
                                       var25 = var5 - var20;
                                    }

                                    class82.method1911(var24, var25, var19, var20, 16777120);
                                    class82.method1925(var24, var25, var19, var20, 0);
                                    var37 = var10.field2844;
                                    var26 = 2 + var21.field3242 + var25;

                                    for(var37 = class42.method886(var37, var10); var37.length() > 0; var26 += 1 + var21.field3242) {
                                       var38 = var37.indexOf("<br>");
                                       if(var38 != -1) {
                                          var48 = var37.substring(0, var38);
                                          var37 = var37.substring(4 + var38);
                                       } else {
                                          var48 = var37;
                                          var37 = "";
                                       }

                                       var21.method4177(var48, var24 + 3, var26, 0, -1);
                                    }
                                 }

                                 if(var10.field2796 == 9) {
                                    if(var10.field2847 == 1) {
                                       if(var10.field2872) {
                                          var19 = var12;
                                          var20 = var13 + var10.field2810;
                                          var39 = var12 + var10.field2866;
                                          var22 = var13;
                                       } else {
                                          var19 = var12;
                                          var20 = var13;
                                          var39 = var12 + var10.field2866;
                                          var22 = var13 + var10.field2810;
                                       }

                                       class82.method1920(var19, var20, var39, var22, var10.field2798);
                                    } else {
                                       var19 = var10.field2866 >= 0?var10.field2866:-var10.field2866;
                                       var20 = var10.field2810 >= 0?var10.field2810:-var10.field2810;
                                       var39 = var19;
                                       if(var19 < var20) {
                                          var39 = var20;
                                       }

                                       if(var39 != 0) {
                                          var22 = (var10.field2866 << 16) / var39;
                                          var23 = (var10.field2810 << 16) / var39;
                                          if(var23 <= var22) {
                                             var22 = -var22;
                                          } else {
                                             var23 = -var23;
                                          }

                                          var24 = var23 * var10.field2847 >> 17;
                                          var25 = var23 * var10.field2847 + 1 >> 17;
                                          var26 = var22 * var10.field2847 >> 17;
                                          var38 = 1 + var10.field2847 * var22 >> 17;
                                          int var42 = var12 + var24;
                                          var29 = var12 - var25;
                                          int var30 = var12 + var10.field2866 - var25;
                                          int var31 = var24 + var12 + var10.field2866;
                                          int var32 = var13 + var26;
                                          int var33 = var13 - var38;
                                          int var34 = var10.field2810 + var13 - var38;
                                          int var35 = var10.field2810 + var13 + var26;
                                          class94.method2201(var42, var29, var30);
                                          class94.method2195(var32, var33, var34, var42, var29, var30, var10.field2798);
                                          class94.method2201(var42, var30, var31);
                                          class94.method2195(var32, var34, var35, var42, var30, var31, var10.field2798);
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
      signature = "(B)V",
      garbageValue = "5"
   )
   void method582() {
      int var1 = this.field633;
      class42 var2 = this.field632.method847();
      if(var2 != null) {
         this.field633 = var2.field1003;
         this.field626 = var2.field1004 * 128;
         this.field635 = var2.field1005;
         this.field636 = var2.field975;
         this.field637 = var2.field1007;
      } else {
         this.field633 = -1;
         this.field626 = 0;
         this.field635 = 0;
         this.field636 = 0;
         this.field637 = null;
      }

      if(this.field633 != var1 && null != this.field634) {
         class31.field742.method1254(this.field634);
         this.field634 = null;
      }

   }
}
