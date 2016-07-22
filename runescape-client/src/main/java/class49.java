import java.awt.Component;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("az")
public class class49 extends class207 {
   @ObfuscatedName("nj")
   @ObfuscatedGetter(
      intValue = -1666659125
   )
   static int field1087;
   @ObfuscatedName("e")
   static class196 field1088 = new class196(64);
   @ObfuscatedName("m")
   static class170 field1089;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 1131778205
   )
   public int field1090;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 814201421
   )
   public int field1091 = 255;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 664837699
   )
   public int field1092 = 255;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -1369370035
   )
   public int field1095 = 70;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 134559075
   )
   int field1096 = -1;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 1417720891
   )
   int field1097 = -1;
   @ObfuscatedName("o")
   static class196 field1098 = new class196(64);
   @ObfuscatedName("a")
   static int[] field1099;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -266989063
   )
   public int field1100 = -1;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 450898549
   )
   public int field1101 = 1;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -878439939
   )
   public int field1102 = 30;
   @ObfuscatedName("w")
   static class170 field1103;

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Lclass122;B)V",
      garbageValue = "11"
   )
   void method1020(class122 var1) {
      while(true) {
         int var2 = var1.method2556();
         if(var2 == 0) {
            return;
         }

         this.method1031(var1, var2);
      }
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(I)Lclass81;",
      garbageValue = "-225212931"
   )
   public class81 method1023() {
      if(this.field1097 < 0) {
         return null;
      } else {
         class81 var1 = (class81)field1098.method3817((long)this.field1097);
         if(var1 != null) {
            return var1;
         } else {
            var1 = class164.method3232(field1103, this.field1097, 0);
            if(null != var1) {
               field1098.method3823(var1, (long)this.field1097);
            }

            return var1;
         }
      }
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(Lclass122;IB)V",
      garbageValue = "-8"
   )
   void method1031(class122 var1, int var2) {
      if(var2 == 1) {
         var1.method2706();
      } else if(var2 == 2) {
         this.field1091 = var1.method2556();
      } else if(var2 == 3) {
         this.field1092 = var1.method2556();
      } else if(var2 == 4) {
         this.field1100 = 0;
      } else if(var2 == 5) {
         this.field1095 = var1.method2706();
      } else if(var2 == 6) {
         var1.method2556();
      } else if(var2 == 7) {
         this.field1096 = var1.method2586();
      } else if(var2 == 8) {
         this.field1097 = var1.method2586();
      } else if(var2 == 11) {
         this.field1100 = var1.method2706();
      } else if(var2 == 14) {
         this.field1102 = var1.method2556();
      }

   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)Lclass81;",
      garbageValue = "-2117931565"
   )
   public class81 method1032() {
      if(this.field1096 < 0) {
         return null;
      } else {
         class81 var1 = (class81)field1098.method3817((long)this.field1096);
         if(var1 != null) {
            return var1;
         } else {
            var1 = class164.method3232(field1103, this.field1096, 0);
            if(var1 != null) {
               field1098.method3823(var1, (long)this.field1096);
            }

            return var1;
         }
      }
   }

   @ObfuscatedName("ax")
   @ObfuscatedSignature(
      signature = "(IILjava/awt/Component;I)Lclass80;",
      garbageValue = "943365650"
   )
   public static class80 method1043(int var0, int var1, Component var2) {
      try {
         class84 var3 = new class84();
         var3.vmethod1969(var0, var1, var2);
         return var3;
      } catch (Throwable var5) {
         class78 var4 = new class78();
         var4.vmethod1969(var0, var1, var2);
         return var4;
      }
   }

   @ObfuscatedName("w")
   static final void method1044(long var0) {
      try {
         Thread.sleep(var0);
      } catch (InterruptedException var3) {
         ;
      }

   }

   @ObfuscatedName("cl")
   @ObfuscatedSignature(
      signature = "([Lclass176;IIIIIIIIB)V",
      garbageValue = "60"
   )
   @Export("gameDraw")
   static final void method1045(class176[] var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
      class82.method1875(var2, var3, var4, var5);
      class94.method2166();

      for(int var9 = 0; var9 < var0.length; ++var9) {
         class176 var10 = var0[var9];
         if(null != var10 && (var1 == var10.field2836 || var1 == -1412584499 && client.field540 == var10)) {
            int var11;
            if(var8 == -1) {
               client.field478[client.field413] = var10.field2804 + var6;
               client.field479[client.field413] = var10.field2809 + var7;
               client.field359[client.field413] = var10.field2926;
               client.field495[client.field413] = var10.field2877;
               var11 = ++client.field413 - 1;
            } else {
               var11 = var8;
            }

            var10.field2813 = var11;
            var10.field2927 = client.field282;
            if(!var10.field2794 || !class32.method677(var10)) {
               if(var10.field2799 > 0) {
                  class87.method1984(var10);
               }

               int var12 = var6 + var10.field2804;
               int var13 = var7 + var10.field2809;
               int var14 = var10.field2826;
               int var15;
               int var16;
               if(client.field540 == var10) {
                  if(var1 != -1412584499 && !var10.field2873) {
                     class20.field563 = var0;
                     class4.field68 = var6;
                     client.field554 = var7;
                     continue;
                  }

                  if(client.field454 && client.field448) {
                     var15 = class143.field2213;
                     var16 = class143.field2214;
                     var15 -= client.field445;
                     var16 -= client.field446;
                     if(var15 < client.field449) {
                        var15 = client.field449;
                     }

                     if(var15 + var10.field2926 > client.field449 + client.field352.field2926) {
                        var15 = client.field352.field2926 + client.field449 - var10.field2926;
                     }

                     if(var16 < client.field515) {
                        var16 = client.field515;
                     }

                     if(var10.field2877 + var16 > client.field515 + client.field352.field2877) {
                        var16 = client.field515 + client.field352.field2877 - var10.field2877;
                     }

                     var12 = var15;
                     var13 = var16;
                  }

                  if(!var10.field2873) {
                     var14 = 128;
                  }
               }

               int var17;
               int var18;
               int var19;
               int var20;
               int var21;
               int var22;
               if(var10.field2929 == 2) {
                  var15 = var2;
                  var16 = var3;
                  var17 = var4;
                  var18 = var5;
               } else if(var10.field2929 == 9) {
                  var19 = var12;
                  var20 = var13;
                  var21 = var10.field2926 + var12;
                  var22 = var13 + var10.field2877;
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
                  var19 = var12 + var10.field2926;
                  var20 = var13 + var10.field2877;
                  var15 = var12 > var2?var12:var2;
                  var16 = var13 > var3?var13:var3;
                  var17 = var19 < var4?var19:var4;
                  var18 = var20 < var5?var20:var5;
               }

               if(!var10.field2794 || var15 < var17 && var16 < var18) {
                  int var23;
                  int var25;
                  int var27;
                  int var31;
                  int var37;
                  int var41;
                  int var42;
                  if(var10.field2799 != 0) {
                     if(var10.field2799 == 1336) {
                        if(client.field338) {
                           var13 += 15;
                           class15.field201.method4101("Fps:" + class147.field2259, var12 + var10.field2926, var13, 16776960, -1);
                           var13 += 15;
                           Runtime var63 = Runtime.getRuntime();
                           var20 = (int)((var63.totalMemory() - var63.freeMemory()) / 1024L);
                           var21 = 16776960;
                           if(var20 > '耀' && client.field277) {
                              var21 = 16711680;
                           }

                           if(var20 > 65536 && !client.field277) {
                              var21 = 16711680;
                           }

                           class15.field201.method4101("Mem:" + var20 + "k", var10.field2926 + var12, var13, var21, -1);
                           var13 += 15;
                        }
                        continue;
                     }

                     if(var10.field2799 == 1337) {
                        client.field419 = var12;
                        client.field527 = var13;
                        class33.method706(var12, var13, var10.field2926, var10.field2877);
                        client.field460[var10.field2813] = true;
                        class82.method1875(var2, var3, var4, var5);
                        continue;
                     }

                     if(var10.field2799 == 1338) {
                        class20.method553();
                        class178 var62 = var10.method3453(false);
                        if(var62 != null) {
                           class82.method1875(var12, var13, var12 + var62.field2948, var62.field2938 + var13);
                           if(client.field506 != 2 && client.field506 != 5) {
                              var20 = client.field342 + client.field357 & 2047;
                              var21 = 48 + class114.field2010.field864 / 32;
                              var22 = 464 - class114.field2010.field831 / 32;
                              class20.field561.method1811(var12, var13, var62.field2948, var62.field2938, var21, var22, var20, client.field484 + 256, var62.field2941, var62.field2940);

                              for(var23 = 0; var23 < client.field500; ++var23) {
                                 var37 = 2 + client.field501[var23] * 4 - class114.field2010.field864 / 32;
                                 var25 = client.field502[var23] * 4 + 2 - class114.field2010.field831 / 32;
                                 class55.method1177(var12, var13, var37, var25, client.field503[var23], var62);
                              }

                              var23 = 0;

                              while(true) {
                                 if(var23 >= 104) {
                                    for(var23 = 0; var23 < client.field394; ++var23) {
                                       class36 var47 = client.field308[client.field310[var23]];
                                       if(null != var47 && var47.vmethod786()) {
                                          class41 var54 = var47.field802;
                                          if(null != var54 && var54.field934 != null) {
                                             var54 = var54.method797();
                                          }

                                          if(var54 != null && var54.field914 && var54.field935) {
                                             var42 = var47.field864 / 32 - class114.field2010.field864 / 32;
                                             var27 = var47.field831 / 32 - class114.field2010.field831 / 32;
                                             class55.method1177(var12, var13, var42, var27, class22.field589[1], var62);
                                          }
                                       }
                                    }

                                    var23 = class34.field777;
                                    int[] var48 = class34.field780;

                                    for(var25 = 0; var25 < var23; ++var25) {
                                       class2 var26 = client.field393[var48[var25]];
                                       if(null != var26 && var26.vmethod786() && !var26.field56 && class114.field2010 != var26) {
                                          var27 = var26.field864 / 32 - class114.field2010.field864 / 32;
                                          var41 = var26.field831 / 32 - class114.field2010.field831 / 32;
                                          boolean var52 = false;
                                          if(class166.method3234(var26.field43, true)) {
                                             var52 = true;
                                          }

                                          boolean var50 = false;

                                          for(var31 = 0; var31 < class152.field2300; ++var31) {
                                             if(var26.field43.equals(class17.field236[var31].field631)) {
                                                var50 = true;
                                                break;
                                             }
                                          }

                                          boolean var51 = false;
                                          if(class114.field2010.field55 != 0 && var26.field55 != 0 && class114.field2010.field55 == var26.field55) {
                                             var51 = true;
                                          }

                                          if(var52) {
                                             class55.method1177(var12, var13, var27, var41, class22.field589[3], var62);
                                          } else if(var51) {
                                             class55.method1177(var12, var13, var27, var41, class22.field589[4], var62);
                                          } else if(var50) {
                                             class55.method1177(var12, var13, var27, var41, class22.field589[5], var62);
                                          } else {
                                             class55.method1177(var12, var13, var27, var41, class22.field589[2], var62);
                                          }
                                       }
                                    }

                                    if(client.field418 != 0 && client.field282 % 20 < 10) {
                                       if(client.field418 == 1 && client.field291 >= 0 && client.field291 < client.field308.length) {
                                          class36 var57 = client.field308[client.field291];
                                          if(var57 != null) {
                                             var42 = var57.field864 / 32 - class114.field2010.field864 / 32;
                                             var27 = var57.field831 / 32 - class114.field2010.field831 / 32;
                                             class109.method2444(var12, var13, var42, var27, class8.field131[1], var62);
                                          }
                                       }

                                       if(client.field418 == 2) {
                                          var25 = 2 + (client.field293 * 4 - class39.field838 * 4) - class114.field2010.field864 / 32;
                                          var42 = client.field309 * 4 - class13.field184 * 4 + 2 - class114.field2010.field831 / 32;
                                          class109.method2444(var12, var13, var25, var42, class8.field131[1], var62);
                                       }

                                       if(client.field418 == 10 && client.field336 >= 0 && client.field336 < client.field393.length) {
                                          class2 var59 = client.field393[client.field336];
                                          if(var59 != null) {
                                             var42 = var59.field864 / 32 - class114.field2010.field864 / 32;
                                             var27 = var59.field831 / 32 - class114.field2010.field831 / 32;
                                             class109.method2444(var12, var13, var42, var27, class8.field131[1], var62);
                                          }
                                       }
                                    }

                                    if(client.field504 != 0) {
                                       var25 = client.field504 * 4 + 2 - class114.field2010.field864 / 32;
                                       var42 = client.field464 * 4 + 2 - class114.field2010.field831 / 32;
                                       class55.method1177(var12, var13, var25, var42, class8.field131[0], var62);
                                    }

                                    if(!class114.field2010.field56) {
                                       class82.method1880(var62.field2948 / 2 + var12 - 1, var13 + var62.field2938 / 2 - 1, 3, 3, 16777215);
                                    }
                                    break;
                                 }

                                 for(var37 = 0; var37 < 104; ++var37) {
                                    class202 var38 = client.field403[class51.field1119][var23][var37];
                                    if(null != var38) {
                                       var42 = var23 * 4 + 2 - class114.field2010.field864 / 32;
                                       var27 = var37 * 4 + 2 - class114.field2010.field831 / 32;
                                       class55.method1177(var12, var13, var42, var27, class22.field589[0], var62);
                                    }
                                 }

                                 ++var23;
                              }
                           } else {
                              class82.method1892(var12, var13, 0, var62.field2941, var62.field2940);
                           }

                           client.field476[var11] = true;
                        }

                        class82.method1875(var2, var3, var4, var5);
                        continue;
                     }

                     if(var10.field2799 == 1339) {
                        class175.method3441(var10, var12, var13, var11);
                        class82.method1875(var2, var3, var4, var5);
                        continue;
                     }
                  }

                  if(var10.field2929 == 0) {
                     if(!var10.field2794 && class32.method677(var10) && class15.field197 != var10) {
                        continue;
                     }

                     if(!var10.field2794) {
                        if(var10.field2817 > var10.field2819 - var10.field2877) {
                           var10.field2817 = var10.field2819 - var10.field2877;
                        }

                        if(var10.field2817 < 0) {
                           var10.field2817 = 0;
                        }
                     }

                     method1045(var0, var10.field2795, var15, var16, var17, var18, var12 - var10.field2894, var13 - var10.field2817, var11);
                     if(null != var10.field2919) {
                        method1045(var10.field2919, var10.field2795, var15, var16, var17, var18, var12 - var10.field2894, var13 - var10.field2817, var11);
                     }

                     class3 var39 = (class3)client.field535.method3856((long)var10.field2795);
                     if(null != var39) {
                        class168.method3293(var39.field66, var15, var16, var17, var18, var12, var13, var11);
                     }

                     class82.method1875(var2, var3, var4, var5);
                     class94.method2166();
                  }

                  if(client.field360 || client.field477[var11] || client.field482 > 1) {
                     if(var10.field2929 == 0 && !var10.field2794 && var10.field2819 > var10.field2877) {
                        var19 = var12 + var10.field2926;
                        var20 = var10.field2817;
                        var21 = var10.field2877;
                        var22 = var10.field2819;
                        class177.field2934[0].method1946(var19, var13);
                        class177.field2934[1].method1946(var19, var13 + var21 - 16);
                        class82.method1880(var19, 16 + var13, 16, var21 - 32, client.field350);
                        var23 = (var21 - 32) * var21 / var22;
                        if(var23 < 8) {
                           var23 = 8;
                        }

                        var37 = var20 * (var21 - 32 - var23) / (var22 - var21);
                        class82.method1880(var19, var37 + 16 + var13, 16, var23, client.field481);
                        class82.method1921(var19, var13 + 16 + var37, var23, client.field353);
                        class82.method1921(var19 + 1, 16 + var13 + var37, var23, client.field353);
                        class82.method1888(var19, var37 + 16 + var13, 16, client.field353);
                        class82.method1888(var19, var37 + var13 + 17, 16, client.field353);
                        class82.method1921(15 + var19, var37 + var13 + 16, var23, client.field349);
                        class82.method1921(var19 + 14, var37 + 17 + var13, var23 - 1, client.field349);
                        class82.method1888(var19, var23 + var37 + 15 + var13, 16, client.field349);
                        class82.method1888(var19 + 1, var23 + var13 + 14 + var37, 15, client.field349);
                     }

                     if(var10.field2929 != 1) {
                        int var29;
                        if(var10.field2929 == 2) {
                           var19 = 0;

                           for(var20 = 0; var20 < var10.field2915; ++var20) {
                              for(var21 = 0; var21 < var10.field2806; ++var21) {
                                 var22 = var12 + (var10.field2875 + 32) * var21;
                                 var23 = (32 + var10.field2862) * var20 + var13;
                                 if(var19 < 20) {
                                    var22 += var10.field2810[var19];
                                    var23 += var10.field2857[var19];
                                 }

                                 if(var10.field2869[var19] <= 0) {
                                    if(null != var10.field2865 && var19 < 20) {
                                       class81 var46 = var10.method3451(var19);
                                       if(null != var46) {
                                          var46.method1800(var22, var23);
                                       } else if(class176.field2793) {
                                          class92.method2164(var10);
                                       }
                                    }
                                 } else {
                                    boolean var61 = false;
                                    boolean var49 = false;
                                    var42 = var10.field2869[var19] - 1;
                                    if(32 + var22 > var2 && var22 < var4 && var23 + 32 > var3 && var23 < var5 || class30.field701 == var10 && var19 == client.field386) {
                                       class81 var44;
                                       if(client.field531 == 1 && var19 == class24.field620 && class162.field2664 == var10.field2795) {
                                          var44 = class3.method38(var42, var10.field2830[var19], 2, 0, 2, false);
                                       } else {
                                          var44 = class3.method38(var42, var10.field2830[var19], 1, 3153952, 2, false);
                                       }

                                       if(null != var44) {
                                          if(var10 == class30.field701 && client.field386 == var19) {
                                             var37 = class143.field2213 - client.field387;
                                             var25 = class143.field2214 - client.field388;
                                             if(var37 < 5 && var37 > -5) {
                                                var37 = 0;
                                             }

                                             if(var25 < 5 && var25 > -5) {
                                                var25 = 0;
                                             }

                                             if(client.field391 < 5) {
                                                var37 = 0;
                                                var25 = 0;
                                             }

                                             var44.method1797(var37 + var22, var23 + var25, 128);
                                             if(var1 != -1) {
                                                class176 var28 = var0[var1 & '\uffff'];
                                                if(var25 + var23 < class82.field1490 && var28.field2817 > 0) {
                                                   var29 = client.field329 * (class82.field1490 - var23 - var25) / 3;
                                                   if(var29 > client.field329 * 10) {
                                                      var29 = client.field329 * 10;
                                                   }

                                                   if(var29 > var28.field2817) {
                                                      var29 = var28.field2817;
                                                   }

                                                   var28.field2817 -= var29;
                                                   client.field388 += var29;
                                                   class92.method2164(var28);
                                                }

                                                if(var25 + var23 + 32 > class82.field1491 && var28.field2817 < var28.field2819 - var28.field2877) {
                                                   var29 = (var23 + var25 + 32 - class82.field1491) * client.field329 / 3;
                                                   if(var29 > client.field329 * 10) {
                                                      var29 = client.field329 * 10;
                                                   }

                                                   if(var29 > var28.field2819 - var28.field2877 - var28.field2817) {
                                                      var29 = var28.field2819 - var28.field2877 - var28.field2817;
                                                   }

                                                   var28.field2817 += var29;
                                                   client.field388 -= var29;
                                                   class92.method2164(var28);
                                                }
                                             }
                                          } else if(var10 == class97.field1673 && client.field385 == var19) {
                                             var44.method1797(var22, var23, 128);
                                          } else {
                                             var44.method1800(var22, var23);
                                          }
                                       } else {
                                          class92.method2164(var10);
                                       }
                                    }
                                 }

                                 ++var19;
                              }
                           }
                        } else if(var10.field2929 == 3) {
                           if(class59.method1271(var10)) {
                              var19 = var10.field2821;
                              if(class15.field197 == var10 && var10.field2872 != 0) {
                                 var19 = var10.field2872;
                              }
                           } else {
                              var19 = var10.field2891;
                              if(var10 == class15.field197 && var10.field2822 != 0) {
                                 var19 = var10.field2822;
                              }
                           }

                           if(var10.field2824) {
                              switch(var10.field2811.field1510) {
                              case 1:
                                 class82.method1881(var12, var13, var10.field2926, var10.field2877, var10.field2891, var10.field2821, 256 - (var10.field2826 & 255), 256 - (var10.field2886 & 255));
                                 break;
                              case 2:
                                 class82.method1882(var12, var13, var10.field2926, var10.field2877, var10.field2891, var10.field2821, 256 - (var10.field2826 & 255), 256 - (var10.field2886 & 255));
                                 break;
                              case 3:
                                 class82.method1908(var12, var13, var10.field2926, var10.field2877, var10.field2891, var10.field2821, 256 - (var10.field2826 & 255), 256 - (var10.field2886 & 255));
                                 break;
                              case 4:
                                 class82.method1910(var12, var13, var10.field2926, var10.field2877, var10.field2891, var10.field2821, 256 - (var10.field2826 & 255), 256 - (var10.field2886 & 255));
                                 break;
                              default:
                                 if(var14 == 0) {
                                    class82.method1880(var12, var13, var10.field2926, var10.field2877, var19);
                                 } else {
                                    class82.method1879(var12, var13, var10.field2926, var10.field2877, var19, 256 - (var14 & 255));
                                 }
                              }
                           } else if(var14 == 0) {
                              class82.method1878(var12, var13, var10.field2926, var10.field2877, var19);
                           } else {
                              class82.method1887(var12, var13, var10.field2926, var10.field2877, var19, 256 - (var14 & 255));
                           }
                        } else {
                           class227 var56;
                           if(var10.field2929 == 4) {
                              var56 = var10.method3450();
                              if(var56 == null) {
                                 if(class176.field2793) {
                                    class92.method2164(var10);
                                 }
                              } else {
                                 String var55 = var10.field2855;
                                 if(class59.method1271(var10)) {
                                    var20 = var10.field2821;
                                    if(var10 == class15.field197 && var10.field2872 != 0) {
                                       var20 = var10.field2872;
                                    }

                                    if(var10.field2856.length() > 0) {
                                       var55 = var10.field2856;
                                    }
                                 } else {
                                    var20 = var10.field2891;
                                    if(var10 == class15.field197 && var10.field2822 != 0) {
                                       var20 = var10.field2822;
                                    }
                                 }

                                 if(var10.field2794 && var10.field2834 != -1) {
                                    class55 var65 = class4.method42(var10.field2834);
                                    var55 = var65.field1183;
                                    if(var55 == null) {
                                       var55 = "null";
                                    }

                                    if((var65.field1194 == 1 || var10.field2916 != 1) && var10.field2916 != -1) {
                                       var55 = class51.method1096(16748608) + var55 + "</col>" + " " + 'x' + class75.method1663(var10.field2916);
                                    }
                                 }

                                 if(var10 == client.field402) {
                                    Object var10000 = null;
                                    var55 = "Please wait...";
                                    var20 = var10.field2891;
                                 }

                                 if(!var10.field2794) {
                                    var55 = class176.method3492(var55, var10);
                                 }

                                 var56.method4106(var55, var12, var13, var10.field2926, var10.field2877, var20, var10.field2860?0:-1, var10.field2858, var10.field2859, var10.field2884);
                              }
                           } else if(var10.field2929 == 5) {
                              class81 var58;
                              if(!var10.field2794) {
                                 var58 = var10.method3449(class59.method1271(var10));
                                 if(var58 != null) {
                                    var58.method1800(var12, var13);
                                 } else if(class176.field2793) {
                                    class92.method2164(var10);
                                 }
                              } else {
                                 if(var10.field2834 != -1) {
                                    var58 = class3.method38(var10.field2834, var10.field2916, var10.field2844, var10.field2835, var10.field2913, false);
                                 } else {
                                    var58 = var10.method3449(false);
                                 }

                                 if(null == var58) {
                                    if(class176.field2793) {
                                       class92.method2164(var10);
                                    }
                                 } else {
                                    var20 = var58.field1475;
                                    var21 = var58.field1481;
                                    if(!var10.field2833) {
                                       var22 = var10.field2926 * 4096 / var20;
                                       if(var10.field2832 != 0) {
                                          var58.method1813(var12 + var10.field2926 / 2, var13 + var10.field2877 / 2, var10.field2832, var22);
                                       } else if(var14 != 0) {
                                          var58.method1808(var12, var13, var10.field2926, var10.field2877, 256 - (var14 & 255));
                                       } else if(var10.field2926 == var20 && var21 == var10.field2877) {
                                          var58.method1800(var12, var13);
                                       } else {
                                          var58.method1802(var12, var13, var10.field2926, var10.field2877);
                                       }
                                    } else {
                                       class82.method1876(var12, var13, var12 + var10.field2926, var10.field2877 + var13);
                                       var22 = (var10.field2926 + (var20 - 1)) / var20;
                                       var23 = (var10.field2877 + (var21 - 1)) / var21;

                                       for(var37 = 0; var37 < var22; ++var37) {
                                          for(var25 = 0; var25 < var23; ++var25) {
                                             if(var10.field2832 != 0) {
                                                var58.method1813(var20 / 2 + var20 * var37 + var12, var21 / 2 + var25 * var21 + var13, var10.field2832, 4096);
                                             } else if(var14 != 0) {
                                                var58.method1797(var12 + var37 * var20, var13 + var21 * var25, 256 - (var14 & 255));
                                             } else {
                                                var58.method1800(var12 + var20 * var37, var21 * var25 + var13);
                                             }
                                          }
                                       }

                                       class82.method1875(var2, var3, var4, var5);
                                    }
                                 }
                              }
                           } else {
                              class55 var40;
                              if(var10.field2929 == 6) {
                                 boolean var45 = class59.method1271(var10);
                                 if(var45) {
                                    var20 = var10.field2843;
                                 } else {
                                    var20 = var10.field2831;
                                 }

                                 class108 var53 = null;
                                 var22 = 0;
                                 if(var10.field2834 != -1) {
                                    var40 = class4.method42(var10.field2834);
                                    if(null != var40) {
                                       var40 = var40.method1142(var10.field2916);
                                       var53 = var40.method1151(1);
                                       if(var53 != null) {
                                          var53.method2385();
                                          var22 = var53.field1536 / 2;
                                       } else {
                                          class92.method2164(var10);
                                       }
                                    }
                                 } else if(var10.field2786 == 5) {
                                    if(var10.field2839 == 0) {
                                       var53 = client.field516.method3542((class44)null, -1, (class44)null, -1);
                                    } else {
                                       var53 = class114.field2010.vmethod1992();
                                    }
                                 } else if(var20 == -1) {
                                    var53 = var10.method3476((class44)null, -1, var45, class114.field2010.field50);
                                    if(null == var53 && class176.field2793) {
                                       class92.method2164(var10);
                                    }
                                 } else {
                                    class44 var64 = class28.method646(var20);
                                    var53 = var10.method3476(var64, var10.field2917, var45, class114.field2010.field50);
                                    if(var53 == null && class176.field2793) {
                                       class92.method2164(var10);
                                    }
                                 }

                                 class94.method2169(var12 + var10.field2926 / 2, var10.field2877 / 2 + var13);
                                 var23 = var10.field2820 * class94.field1660[var10.field2853] >> 16;
                                 var37 = class94.field1661[var10.field2853] * var10.field2820 >> 16;
                                 if(null != var53) {
                                    if(!var10.field2794) {
                                       var53.method2420(0, var10.field2847, 0, var10.field2853, 0, var23, var37);
                                    } else {
                                       var53.method2385();
                                       if(var10.field2852) {
                                          var53.method2383(0, var10.field2847, var10.field2848, var10.field2853, var10.field2863, var23 + var22 + var10.field2851, var37 + var10.field2851, var10.field2820);
                                       } else {
                                          var53.method2420(0, var10.field2847, var10.field2848, var10.field2853, var10.field2863, var10.field2851 + var22 + var23, var10.field2851 + var37);
                                       }
                                    }
                                 }

                                 class94.method2168();
                              } else {
                                 if(var10.field2929 == 7) {
                                    var56 = var10.method3450();
                                    if(null == var56) {
                                       if(class176.field2793) {
                                          class92.method2164(var10);
                                       }
                                       continue;
                                    }

                                    var20 = 0;

                                    for(var21 = 0; var21 < var10.field2915; ++var21) {
                                       for(var22 = 0; var22 < var10.field2806; ++var22) {
                                          if(var10.field2869[var20] > 0) {
                                             var40 = class4.method42(var10.field2869[var20] - 1);
                                             String var24;
                                             if(var40.field1194 != 1 && var10.field2830[var20] == 1) {
                                                var24 = class51.method1096(16748608) + var40.field1183 + "</col>";
                                             } else {
                                                var24 = class51.method1096(16748608) + var40.field1183 + "</col>" + " " + 'x' + class75.method1663(var10.field2830[var20]);
                                             }

                                             var25 = var22 * (var10.field2875 + 115) + var12;
                                             var42 = var13 + (var10.field2862 + 12) * var21;
                                             if(var10.field2858 == 0) {
                                                var56.method4099(var24, var25, var42, var10.field2891, var10.field2860?0:-1);
                                             } else if(var10.field2858 == 1) {
                                                var56.method4116(var24, var10.field2926 / 2 + var25, var42, var10.field2891, var10.field2860?0:-1);
                                             } else {
                                                var56.method4101(var24, var10.field2926 + var25 - 1, var42, var10.field2891, var10.field2860?0:-1);
                                             }
                                          }

                                          ++var20;
                                       }
                                    }
                                 }

                                 if(var10.field2929 == 8 && class27.field642 == var10 && client.field422 == client.field390) {
                                    var19 = 0;
                                    var20 = 0;
                                    class227 var36 = class15.field201;
                                    String var43 = var10.field2855;

                                    String var60;
                                    for(var43 = class176.method3492(var43, var10); var43.length() > 0; var20 += 1 + var36.field3237) {
                                       var37 = var43.indexOf("<br>");
                                       if(var37 != -1) {
                                          var60 = var43.substring(0, var37);
                                          var43 = var43.substring(var37 + 4);
                                       } else {
                                          var60 = var43;
                                          var43 = "";
                                       }

                                       var25 = var36.method4094(var60);
                                       if(var25 > var19) {
                                          var19 = var25;
                                       }
                                    }

                                    var19 += 6;
                                    var20 += 7;
                                    var37 = var12 + var10.field2926 - 5 - var19;
                                    var25 = 5 + var10.field2877 + var13;
                                    if(var37 < var12 + 5) {
                                       var37 = 5 + var12;
                                    }

                                    if(var19 + var37 > var4) {
                                       var37 = var4 - var19;
                                    }

                                    if(var25 + var20 > var5) {
                                       var25 = var5 - var20;
                                    }

                                    class82.method1880(var37, var25, var19, var20, 16777120);
                                    class82.method1878(var37, var25, var19, var20, 0);
                                    var43 = var10.field2855;
                                    var42 = 2 + var36.field3237 + var25;

                                    for(var43 = class176.method3492(var43, var10); var43.length() > 0; var42 += 1 + var36.field3237) {
                                       var27 = var43.indexOf("<br>");
                                       if(var27 != -1) {
                                          var60 = var43.substring(0, var27);
                                          var43 = var43.substring(4 + var27);
                                       } else {
                                          var60 = var43;
                                          var43 = "";
                                       }

                                       var36.method4099(var60, 3 + var37, var42, 0, -1);
                                    }
                                 }

                                 if(var10.field2929 == 9) {
                                    if(var10.field2828 == 1) {
                                       if(var10.field2829) {
                                          var19 = var12;
                                          var20 = var10.field2877 + var13;
                                          var21 = var10.field2926 + var12;
                                          var22 = var13;
                                       } else {
                                          var19 = var12;
                                          var20 = var13;
                                          var21 = var12 + var10.field2926;
                                          var22 = var10.field2877 + var13;
                                       }

                                       class82.method1872(var19, var20, var21, var22, var10.field2891);
                                    } else {
                                       var19 = var10.field2926 >= 0?var10.field2926:-var10.field2926;
                                       var20 = var10.field2877 >= 0?var10.field2877:-var10.field2877;
                                       var21 = var19;
                                       if(var19 < var20) {
                                          var21 = var20;
                                       }

                                       if(var21 != 0) {
                                          var22 = (var10.field2926 << 16) / var21;
                                          var23 = (var10.field2877 << 16) / var21;
                                          if(var23 <= var22) {
                                             var22 = -var22;
                                          } else {
                                             var23 = -var23;
                                          }

                                          var37 = var10.field2828 * var23 >> 17;
                                          var25 = var23 * var10.field2828 + 1 >> 17;
                                          var42 = var10.field2828 * var22 >> 17;
                                          var27 = var10.field2828 * var22 + 1 >> 17;
                                          var41 = var37 + var12;
                                          var29 = var12 - var25;
                                          int var30 = var12 + var10.field2926 - var25;
                                          var31 = var37 + var10.field2926 + var12;
                                          int var32 = var42 + var13;
                                          int var33 = var13 - var27;
                                          int var34 = var10.field2877 + var13 - var27;
                                          int var35 = var42 + var10.field2877 + var13;
                                          class94.method2174(var41, var29, var30);
                                          class94.method2171(var32, var33, var34, var41, var29, var30, var10.field2891);
                                          class94.method2174(var41, var30, var31);
                                          class94.method2171(var32, var34, var35, var41, var30, var31, var10.field2891);
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
