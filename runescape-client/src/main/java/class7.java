import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("s")
@Implements("Ignore")
public class class7 {
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -258551939
   )
   static int field131;
   @ObfuscatedName("i")
   @Export("previousName")
   String field134;
   @ObfuscatedName("t")
   @Export("name")
   String field135;
   @ObfuscatedName("as")
   static int[] field136;

   @ObfuscatedName("bx")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1939594229"
   )
   static final void method85() {
      for(class16 var0 = (class16)client.field542.method3797(); null != var0; var0 = (class16)client.field542.method3779()) {
         if(var0.field235 == -1) {
            var0.field234 = 0;
            class183.method3545(var0);
         } else {
            var0.method3870();
         }
      }

   }

   @ObfuscatedName("cp")
   @ObfuscatedSignature(
      signature = "([Lclass173;IIIIIIII)V",
      garbageValue = "1380034770"
   )
   static final void method86(class173[] var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      for(int var8 = 0; var8 < var0.length; ++var8) {
         class173 var9 = var0[var8];
         if(null != var9 && (!var9.field2775 || var9.field2778 == 0 || var9.field2856 || class138.method2906(var9) != 0 || var9 == client.field456 || var9.field2780 == 1338) && var1 == var9.field2795 && (!var9.field2775 || !class14.method146(var9))) {
            int var10 = var9.field2876 + var6;
            int var11 = var7 + var9.field2801;
            int var12;
            int var13;
            int var14;
            int var15;
            int var16;
            int var17;
            int var18;
            int var19;
            if(var9.field2778 == 2) {
               var12 = var2;
               var13 = var3;
               var14 = var4;
               var15 = var5;
            } else if(var9.field2778 == 9) {
               var16 = var10;
               var17 = var11;
               var18 = var9.field2791 + var10;
               var19 = var9.field2792 + var11;
               if(var18 < var10) {
                  var16 = var18;
                  var18 = var10;
               }

               if(var19 < var11) {
                  var17 = var19;
                  var19 = var11;
               }

               ++var18;
               ++var19;
               var12 = var16 > var2?var16:var2;
               var13 = var17 > var3?var17:var3;
               var14 = var18 < var4?var18:var4;
               var15 = var19 < var5?var19:var5;
            } else {
               var16 = var10 + var9.field2791;
               var17 = var9.field2792 + var11;
               var12 = var10 > var2?var10:var2;
               var13 = var11 > var3?var11:var3;
               var14 = var16 < var4?var16:var4;
               var15 = var17 < var5?var17:var5;
            }

            if(client.field455 == var9) {
               client.field427 = true;
               client.field503 = var10;
               client.field465 = var11;
            }

            if(!var9.field2775 || var12 < var14 && var13 < var15) {
               var16 = class140.field2192;
               var17 = class140.field2189;
               if(class140.field2185 != 0) {
                  var16 = class140.field2190;
                  var17 = class140.field2187;
               }

               if(var9.field2780 == 1337) {
                  if(!client.field292 && !client.field423 && var16 >= var12 && var17 >= var13 && var16 < var14 && var17 < var15) {
                     class171.method3361(var16, var17, var12, var13);
                  }
               } else {
                  int var20;
                  int var22;
                  int var23;
                  int var27;
                  int var34;
                  int var36;
                  if(var9.field2780 == 1338) {
                     if((client.field549 == 0 || client.field549 == 3) && (class140.field2185 == 1 || !class101.field1755 && class140.field2185 == 4)) {
                        class175 var47 = var9.method3375(true);
                        if(var47 != null) {
                           var19 = class140.field2190 - var10;
                           var20 = class140.field2187 - var11;
                           if(var47.method3413(var19, var20)) {
                              var19 -= var47.field2918 / 2;
                              var20 -= var47.field2917 / 2;
                              var34 = client.field302 + client.field355 & 2047;
                              var22 = class91.field1602[var34];
                              var23 = class91.field1603[var34];
                              var22 = (client.field357 + 256) * var22 >> 8;
                              var23 = (client.field357 + 256) * var23 >> 8;
                              var36 = var20 * var22 + var19 * var23 >> 11;
                              int var37 = var23 * var20 - var19 * var22 >> 11;
                              int var38 = class152.field2301.field809 + var36 >> 7;
                              var27 = class152.field2301.field804 - var37 >> 7;
                              client.field325.method2733(83);
                              client.field325.method2453(18);
                              client.field325.method2492(class137.field2133[82]?(class137.field2133[81]?2:1):0);
                              client.field325.method2500(var38 + class89.field1565);
                              client.field325.method2454(client.field358 + var27);
                              client.field325.method2453(var19);
                              client.field325.method2453(var20);
                              client.field325.method2454(client.field302);
                              client.field325.method2453(57);
                              client.field325.method2453(client.field355);
                              client.field325.method2453(client.field357);
                              client.field325.method2453(89);
                              client.field325.method2454(class152.field2301.field809);
                              client.field325.method2454(class152.field2301.field804);
                              client.field325.method2453(63);
                              client.field545 = var38;
                              client.field517 = var27;
                           }
                        }
                     }
                  } else {
                     boolean var42;
                     if(!client.field423 && var16 >= var12 && var17 >= var13 && var16 < var14 && var17 < var15) {
                        var18 = var16 - var10;
                        var19 = var17 - var11;
                        if(var9.field2779 == 1) {
                           class2.method33(var9.field2872, "", 24, 0, 0, var9.field2776);
                        }

                        String var33;
                        if(var9.field2779 == 2 && !client.field437) {
                           var22 = class138.method2906(var9);
                           var34 = var22 >> 11 & 63;
                           if(var34 == 0) {
                              var33 = null;
                           } else if(var9.field2796 != null && var9.field2796.trim().length() != 0) {
                              var33 = var9.field2796;
                           } else {
                              var33 = null;
                           }

                           if(var33 != null) {
                              class2.method33(var33, class155.method3132('\uff00') + var9.field2892, 25, 0, -1, var9.field2776);
                           }
                        }

                        if(var9.field2779 == 3) {
                           class2.method33("Close", "", 26, 0, 0, var9.field2776);
                        }

                        if(var9.field2779 == 4) {
                           class2.method33(var9.field2872, "", 28, 0, 0, var9.field2776);
                        }

                        if(var9.field2779 == 5) {
                           class2.method33(var9.field2872, "", 29, 0, 0, var9.field2776);
                        }

                        if(var9.field2779 == 6 && null == client.field399) {
                           class2.method33(var9.field2872, "", 30, 0, -1, var9.field2776);
                        }

                        if(var9.field2778 == 2) {
                           var20 = 0;

                           for(var34 = 0; var34 < var9.field2792; ++var34) {
                              for(var22 = 0; var22 < var9.field2791; ++var22) {
                                 var23 = var22 * (32 + var9.field2848);
                                 var36 = var34 * (32 + var9.field2812);
                                 if(var20 < 20) {
                                    var23 += var9.field2844[var20];
                                    var36 += var9.field2845[var20];
                                 }

                                 if(var18 >= var23 && var19 >= var36 && var18 < var23 + 32 && var19 < 32 + var36) {
                                    client.field401 = var20;
                                    class11.field177 = var9;
                                    if(var9.field2849[var20] > 0) {
                                       class51 var25 = class123.method2743(var9.field2849[var20] - 1);
                                       if(client.field379 == 1 && class33.method701(class138.method2906(var9))) {
                                          if(var9.field2776 != class143.field2208 || class127.field2059 != var20) {
                                             class2.method33("Use", client.field463 + " " + "->" + " " + class155.method3132(16748608) + var25.field1120, 31, var25.field1118, var20, var9.field2776);
                                          }
                                       } else if(client.field437 && class33.method701(class138.method2906(var9))) {
                                          if((class3.field69 & 16) == 16) {
                                             class2.method33(client.field432, client.field441 + " " + "->" + " " + class155.method3132(16748608) + var25.field1120, 32, var25.field1118, var20, var9.field2776);
                                          }
                                       } else {
                                          String[] var26 = var25.field1121;
                                          if(client.field453) {
                                             var26 = class125.method2765(var26);
                                          }

                                          if(class33.method701(class138.method2906(var9))) {
                                             for(var27 = 4; var27 >= 3; --var27) {
                                                if(var26 != null && null != var26[var27]) {
                                                   byte var28;
                                                   if(var27 == 3) {
                                                      var28 = 36;
                                                   } else {
                                                      var28 = 37;
                                                   }

                                                   class2.method33(var26[var27], class155.method3132(16748608) + var25.field1120, var28, var25.field1118, var20, var9.field2776);
                                                } else if(var27 == 4) {
                                                   class2.method33("Drop", class155.method3132(16748608) + var25.field1120, 37, var25.field1118, var20, var9.field2776);
                                                }
                                             }
                                          }

                                          int var45 = class138.method2906(var9);
                                          boolean var44 = (var45 >> 31 & 1) != 0;
                                          if(var44) {
                                             class2.method33("Use", class155.method3132(16748608) + var25.field1120, 38, var25.field1118, var20, var9.field2776);
                                          }

                                          class178 var10000 = (class178)null;
                                          int var29;
                                          byte var30;
                                          if(class33.method701(class138.method2906(var9)) && null != var26) {
                                             for(var29 = 2; var29 >= 0; --var29) {
                                                if(var26[var29] != null) {
                                                   var30 = 0;
                                                   if(var29 == 0) {
                                                      var30 = 33;
                                                   }

                                                   if(var29 == 1) {
                                                      var30 = 34;
                                                   }

                                                   if(var29 == 2) {
                                                      var30 = 35;
                                                   }

                                                   class2.method33(var26[var29], class155.method3132(16748608) + var25.field1120, var30, var25.field1118, var20, var9.field2776);
                                                }
                                             }
                                          }

                                          var26 = var9.field2805;
                                          if(client.field453) {
                                             var26 = class125.method2765(var26);
                                          }

                                          if(var26 != null) {
                                             for(var29 = 4; var29 >= 0; --var29) {
                                                if(var26[var29] != null) {
                                                   var30 = 0;
                                                   if(var29 == 0) {
                                                      var30 = 39;
                                                   }

                                                   if(var29 == 1) {
                                                      var30 = 40;
                                                   }

                                                   if(var29 == 2) {
                                                      var30 = 41;
                                                   }

                                                   if(var29 == 3) {
                                                      var30 = 42;
                                                   }

                                                   if(var29 == 4) {
                                                      var30 = 43;
                                                   }

                                                   class2.method33(var26[var29], class155.method3132(16748608) + var25.field1120, var30, var25.field1118, var20, var9.field2776);
                                                }
                                             }
                                          }

                                          class2.method33("Examine", class155.method3132(16748608) + var25.field1120, 1005, var25.field1118, var20, var9.field2776);
                                       }
                                    }
                                 }

                                 ++var20;
                              }
                           }
                        }

                        if(var9.field2775) {
                           if(client.field437) {
                              var34 = class138.method2906(var9);
                              var42 = (var34 >> 21 & 1) != 0;
                              if(var42 && (class3.field69 & 32) == 32) {
                                 class2.method33(client.field432, client.field441 + " " + "->" + " " + var9.field2833, 58, 0, var9.field2777, var9.field2776);
                              }
                           } else {
                              for(var20 = 9; var20 >= 5; --var20) {
                                 String var21 = class84.method1858(var9, var20);
                                 if(var21 != null) {
                                    class2.method33(var21, var9.field2833, 1007, var20 + 1, var9.field2777, var9.field2776);
                                 }
                              }

                              var22 = class138.method2906(var9);
                              var34 = var22 >> 11 & 63;
                              if(var34 == 0) {
                                 var33 = null;
                              } else if(var9.field2796 != null && var9.field2796.trim().length() != 0) {
                                 var33 = var9.field2796;
                              } else {
                                 var33 = null;
                              }

                              if(null != var33) {
                                 class2.method33(var33, var9.field2833, 25, 0, var9.field2777, var9.field2776);
                              }

                              for(var22 = 4; var22 >= 0; --var22) {
                                 String var32 = class84.method1858(var9, var22);
                                 if(null != var32) {
                                    class2.method33(var32, var9.field2833, 57, var22 + 1, var9.field2777, var9.field2776);
                                 }
                              }

                              if(class156.method3138(class138.method2906(var9))) {
                                 class2.method33("Continue", "", 30, 0, var9.field2777, var9.field2776);
                              }
                           }
                        }
                     }

                     if(var9.field2778 == 0) {
                        if(!var9.field2775 && class14.method146(var9) && var9 != class131.field2082) {
                           continue;
                        }

                        method86(var0, var9.field2776, var12, var13, var14, var15, var10 - var9.field2835, var11 - var9.field2861);
                        if(null != var9.field2770) {
                           method86(var9.field2770, var9.field2776, var12, var13, var14, var15, var10 - var9.field2835, var11 - var9.field2861);
                        }

                        class3 var35 = (class3)client.field443.method3748((long)var9.field2776);
                        if(var35 != null) {
                           if(var35.field64 == 0 && class140.field2192 >= var12 && class140.field2189 >= var13 && class140.field2192 < var14 && class140.field2189 < var15 && !client.field423 && !client.field452) {
                              for(class0 var31 = (class0)client.field395.method3797(); var31 != null; var31 = (class0)client.field395.method3779()) {
                                 if(var31.field1) {
                                    var31.method3870();
                                    var31.field2.field2824 = false;
                                 }
                              }

                              if(class1.field28 == 0) {
                                 client.field455 = null;
                                 client.field456 = null;
                              }

                              if(!client.field423) {
                                 client.field429[0] = "Cancel";
                                 client.field337[0] = "";
                                 client.field392[0] = 1006;
                                 client.field294 = 1;
                              }
                           }

                           client.method541(var35.field65, var12, var13, var14, var15, var10, var11);
                        }
                     }

                     if(var9.field2775) {
                        class0 var46;
                        if(!var9.field2909) {
                           if(var9.field2910 && class140.field2192 >= var12 && class140.field2189 >= var13 && class140.field2192 < var14 && class140.field2189 < var15) {
                              for(var46 = (class0)client.field395.method3797(); var46 != null; var46 = (class0)client.field395.method3779()) {
                                 if(var46.field1 && var46.field2.field2873 == var46.field5) {
                                    var46.method3870();
                                 }
                              }
                           }
                        } else if(class140.field2192 >= var12 && class140.field2189 >= var13 && class140.field2192 < var14 && class140.field2189 < var15) {
                           for(var46 = (class0)client.field395.method3797(); var46 != null; var46 = (class0)client.field395.method3779()) {
                              if(var46.field1) {
                                 var46.method3870();
                                 var46.field2.field2824 = false;
                              }
                           }

                           if(class1.field28 == 0) {
                              client.field455 = null;
                              client.field456 = null;
                           }

                           if(!client.field423) {
                              client.field429[0] = "Cancel";
                              client.field337[0] = "";
                              client.field392[0] = 1006;
                              client.field294 = 1;
                           }
                        }

                        boolean var40;
                        if(class140.field2192 >= var12 && class140.field2189 >= var13 && class140.field2192 < var14 && class140.field2189 < var15) {
                           var40 = true;
                        } else {
                           var40 = false;
                        }

                        boolean var41 = false;
                        if((class140.field2178 == 1 || !class101.field1755 && class140.field2178 == 4) && var40) {
                           var41 = true;
                        }

                        var42 = false;
                        if((class140.field2185 == 1 || !class101.field1755 && class140.field2185 == 4) && class140.field2190 >= var12 && class140.field2187 >= var13 && class140.field2190 < var14 && class140.field2187 < var15) {
                           var42 = true;
                        }

                        if(var42) {
                           method87(var9, class140.field2190 - var10, class140.field2187 - var11);
                        }

                        if(null != client.field455 && var9 != client.field455 && var40 && class106.method2335(class138.method2906(var9))) {
                           client.field459 = var9;
                        }

                        if(var9 == client.field456) {
                           client.field416 = true;
                           client.field279 = var10;
                           client.field408 = var11;
                        }

                        if(var9.field2856) {
                           class0 var43;
                           if(var40 && client.field480 != 0 && null != var9.field2873) {
                              var43 = new class0();
                              var43.field1 = true;
                              var43.field2 = var9;
                              var43.field4 = client.field480;
                              var43.field5 = var9.field2873;
                              client.field395.method3771(var43);
                           }

                           if(client.field455 != null || class6.field126 != null || client.field423) {
                              var42 = false;
                              var41 = false;
                              var40 = false;
                           }

                           if(!var9.field2820 && var42) {
                              var9.field2820 = true;
                              if(null != var9.field2858) {
                                 var43 = new class0();
                                 var43.field1 = true;
                                 var43.field2 = var9;
                                 var43.field6 = class140.field2190 - var10;
                                 var43.field4 = class140.field2187 - var11;
                                 var43.field5 = var9.field2858;
                                 client.field395.method3771(var43);
                              }
                           }

                           if(var9.field2820 && var41 && var9.field2859 != null) {
                              var43 = new class0();
                              var43.field1 = true;
                              var43.field2 = var9;
                              var43.field6 = class140.field2192 - var10;
                              var43.field4 = class140.field2189 - var11;
                              var43.field5 = var9.field2859;
                              client.field395.method3771(var43);
                           }

                           if(var9.field2820 && !var41) {
                              var9.field2820 = false;
                              if(null != var9.field2860) {
                                 var43 = new class0();
                                 var43.field1 = true;
                                 var43.field2 = var9;
                                 var43.field6 = class140.field2192 - var10;
                                 var43.field4 = class140.field2189 - var11;
                                 var43.field5 = var9.field2860;
                                 client.field483.method3771(var43);
                              }
                           }

                           if(var41 && null != var9.field2828) {
                              var43 = new class0();
                              var43.field1 = true;
                              var43.field2 = var9;
                              var43.field6 = class140.field2192 - var10;
                              var43.field4 = class140.field2189 - var11;
                              var43.field5 = var9.field2828;
                              client.field395.method3771(var43);
                           }

                           if(!var9.field2824 && var40) {
                              var9.field2824 = true;
                              if(null != var9.field2862) {
                                 var43 = new class0();
                                 var43.field1 = true;
                                 var43.field2 = var9;
                                 var43.field6 = class140.field2192 - var10;
                                 var43.field4 = class140.field2189 - var11;
                                 var43.field5 = var9.field2862;
                                 client.field395.method3771(var43);
                              }
                           }

                           if(var9.field2824 && var40 && var9.field2863 != null) {
                              var43 = new class0();
                              var43.field1 = true;
                              var43.field2 = var9;
                              var43.field6 = class140.field2192 - var10;
                              var43.field4 = class140.field2189 - var11;
                              var43.field5 = var9.field2863;
                              client.field395.method3771(var43);
                           }

                           if(var9.field2824 && !var40) {
                              var9.field2824 = false;
                              if(var9.field2864 != null) {
                                 var43 = new class0();
                                 var43.field1 = true;
                                 var43.field2 = var9;
                                 var43.field6 = class140.field2192 - var10;
                                 var43.field4 = class140.field2189 - var11;
                                 var43.field5 = var9.field2864;
                                 client.field483.method3771(var43);
                              }
                           }

                           if(var9.field2819 != null) {
                              var43 = new class0();
                              var43.field2 = var9;
                              var43.field5 = var9.field2819;
                              client.field482.method3771(var43);
                           }

                           class0 var24;
                           if(var9.field2899 != null && client.field469 > var9.field2904) {
                              if(null != var9.field2900 && client.field469 - var9.field2904 <= 32) {
                                 label1045:
                                 for(var34 = var9.field2904; var34 < client.field469; ++var34) {
                                    var22 = client.field512[var34 & 31];

                                    for(var23 = 0; var23 < var9.field2900.length; ++var23) {
                                       if(var9.field2900[var23] == var22) {
                                          var24 = new class0();
                                          var24.field2 = var9;
                                          var24.field5 = var9.field2899;
                                          client.field395.method3771(var24);
                                          break label1045;
                                       }
                                    }
                                 }
                              } else {
                                 var43 = new class0();
                                 var43.field2 = var9;
                                 var43.field5 = var9.field2899;
                                 client.field395.method3771(var43);
                              }

                              var9.field2904 = client.field469;
                           }

                           if(null != var9.field2773 && client.field386 > var9.field2905) {
                              if(var9.field2901 != null && client.field386 - var9.field2905 <= 32) {
                                 label1021:
                                 for(var34 = var9.field2905; var34 < client.field386; ++var34) {
                                    var22 = client.field470[var34 & 31];

                                    for(var23 = 0; var23 < var9.field2901.length; ++var23) {
                                       if(var22 == var9.field2901[var23]) {
                                          var24 = new class0();
                                          var24.field2 = var9;
                                          var24.field5 = var9.field2773;
                                          client.field395.method3771(var24);
                                          break label1021;
                                       }
                                    }
                                 }
                              } else {
                                 var43 = new class0();
                                 var43.field2 = var9;
                                 var43.field5 = var9.field2773;
                                 client.field395.method3771(var43);
                              }

                              var9.field2905 = client.field386;
                           }

                           if(var9.field2902 != null && client.field473 > var9.field2906) {
                              if(null != var9.field2874 && client.field473 - var9.field2906 <= 32) {
                                 label997:
                                 for(var34 = var9.field2906; var34 < client.field473; ++var34) {
                                    var22 = client.field472[var34 & 31];

                                    for(var23 = 0; var23 < var9.field2874.length; ++var23) {
                                       if(var22 == var9.field2874[var23]) {
                                          var24 = new class0();
                                          var24.field2 = var9;
                                          var24.field5 = var9.field2902;
                                          client.field395.method3771(var24);
                                          break label997;
                                       }
                                    }
                                 }
                              } else {
                                 var43 = new class0();
                                 var43.field2 = var9;
                                 var43.field5 = var9.field2902;
                                 client.field395.method3771(var43);
                              }

                              var9.field2906 = client.field473;
                           }

                           if(client.field474 > var9.field2903 && null != var9.field2808) {
                              var43 = new class0();
                              var43.field2 = var9;
                              var43.field5 = var9.field2808;
                              client.field395.method3771(var43);
                           }

                           if(client.field475 > var9.field2903 && var9.field2880 != null) {
                              var43 = new class0();
                              var43.field2 = var9;
                              var43.field5 = var9.field2880;
                              client.field395.method3771(var43);
                           }

                           if(client.field382 > var9.field2903 && var9.field2881 != null) {
                              var43 = new class0();
                              var43.field2 = var9;
                              var43.field5 = var9.field2881;
                              client.field395.method3771(var43);
                           }

                           if(client.field477 > var9.field2903 && var9.field2886 != null) {
                              var43 = new class0();
                              var43.field2 = var9;
                              var43.field5 = var9.field2886;
                              client.field395.method3771(var43);
                           }

                           if(client.field537 > var9.field2903 && var9.field2887 != null) {
                              var43 = new class0();
                              var43.field2 = var9;
                              var43.field5 = var9.field2887;
                              client.field395.method3771(var43);
                           }

                           if(client.field479 > var9.field2903 && null != var9.field2882) {
                              var43 = new class0();
                              var43.field2 = var9;
                              var43.field5 = var9.field2882;
                              client.field395.method3771(var43);
                           }

                           var9.field2903 = client.field467;
                           if(var9.field2879 != null) {
                              for(var34 = 0; var34 < client.field505; ++var34) {
                                 class0 var39 = new class0();
                                 var39.field2 = var9;
                                 var39.field7 = client.field507[var34];
                                 var39.field8 = client.field562[var34];
                                 var39.field5 = var9.field2879;
                                 client.field395.method3771(var39);
                              }
                           }
                        }
                     }

                     if(!var9.field2775 && client.field455 == null && null == class6.field126 && !client.field423) {
                        if((var9.field2891 >= 0 || var9.field2803 != 0) && class140.field2192 >= var12 && class140.field2189 >= var13 && class140.field2192 < var14 && class140.field2189 < var15) {
                           if(var9.field2891 >= 0) {
                              class131.field2082 = var0[var9.field2891];
                           } else {
                              class131.field2082 = var9;
                           }
                        }

                        if(var9.field2778 == 8 && class140.field2192 >= var12 && class140.field2189 >= var13 && class140.field2192 < var14 && class140.field2189 < var15) {
                           class24.field617 = var9;
                        }

                        if(var9.field2823 > var9.field2792) {
                           class148.method3089(var9, var10 + var9.field2791, var11, var9.field2792, var9.field2823, class140.field2192, class140.field2189);
                        }
                     }
                  }
               }
            }
         }
      }

   }

   @ObfuscatedName("dw")
   @ObfuscatedSignature(
      signature = "(Lclass173;III)V",
      garbageValue = "-2078234709"
   )
   static final void method87(class173 var0, int var1, int var2) {
      if(null == client.field455 && !client.field423) {
         if(null != var0) {
            class173 var5 = var0;
            int var6 = class29.method649(class138.method2906(var0));
            class173 var4;
            int var7;
            if(var6 == 0) {
               var4 = null;
            } else {
               var7 = 0;

               while(true) {
                  if(var7 >= var6) {
                     var4 = var5;
                     break;
                  }

                  var5 = class170.method3344(var5.field2795);
                  if(null == var5) {
                     var4 = null;
                     break;
                  }

                  ++var7;
               }
            }

            class173 var8 = var4;
            if(var4 == null) {
               var8 = var0.field2851;
            }

            if(var8 != null) {
               client.field455 = var0;
               var5 = var0;
               var6 = class29.method649(class138.method2906(var0));
               if(var6 == 0) {
                  var4 = null;
               } else {
                  var7 = 0;

                  while(true) {
                     if(var7 >= var6) {
                        var4 = var5;
                        break;
                     }

                     var5 = class170.method3344(var5.field2795);
                     if(var5 == null) {
                        var4 = null;
                        break;
                     }

                     ++var7;
                  }
               }

               var8 = var4;
               if(var4 == null) {
                  var8 = var0.field2851;
               }

               client.field456 = var8;
               client.field491 = var1;
               client.field348 = var2;
               class1.field28 = 0;
               client.field513 = false;
               if(client.field294 > 0) {
                  class127.method2787(client.field294 - 1);
               }

               return;
            }
         }

      }
   }

   @ObfuscatedName("cx")
   @ObfuscatedSignature(
      signature = "(II)Ljava/lang/String;",
      garbageValue = "-2012111169"
   )
   static final String method88(int var0) {
      String var1 = Integer.toString(var0);

      for(int var2 = var1.length() - 3; var2 > 0; var2 -= 3) {
         var1 = var1.substring(0, var2) + "," + var1.substring(var2);
      }

      return var1.length() > 9?" " + class155.method3132('ﾀ') + var1.substring(0, var1.length() - 8) + "M" + " " + " (" + var1 + ")" + "</col>":(var1.length() > 6?" " + class155.method3132(16777215) + var1.substring(0, var1.length() - 4) + "K" + " " + " (" + var1 + ")" + "</col>":" " + class155.method3132(16776960) + var1 + "</col>");
   }

   @ObfuscatedName("ag")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-2115164670"
   )
   static final void method89() {
      int var0 = client.field445 + class152.field2301.field809;
      int var1 = client.field350 + class152.field2301.field804;
      if(class76.field1390 - var0 < -500 || class76.field1390 - var0 > 500 || class56.field1200 - var1 < -500 || class56.field1200 - var1 > 500) {
         class76.field1390 = var0;
         class56.field1200 = var1;
      }

      if(var0 != class76.field1390) {
         class76.field1390 += (var0 - class76.field1390) / 16;
      }

      if(class56.field1200 != var1) {
         class56.field1200 += (var1 - class56.field1200) / 16;
      }

      int var2;
      int var3;
      if(class140.field2178 == 4 && class101.field1755) {
         var2 = class140.field2189 - client.field372;
         client.field509 = var2 * 2;
         client.field372 = var2 != -1 && var2 != 1?(class140.field2189 + client.field372) / 2:class140.field2189;
         var3 = client.field371 - class140.field2192;
         client.field369 = var3 * 2;
         client.field371 = var3 != -1 && var3 != 1?(client.field371 + class140.field2192) / 2:class140.field2192;
      } else {
         if(class137.field2133[96]) {
            client.field369 += (-24 - client.field369) / 2;
         } else if(class137.field2133[97]) {
            client.field369 += (24 - client.field369) / 2;
         } else {
            client.field369 /= 2;
         }

         if(class137.field2133[98]) {
            client.field509 += (12 - client.field509) / 2;
         } else if(class137.field2133[99]) {
            client.field509 += (-12 - client.field509) / 2;
         } else {
            client.field509 /= 2;
         }

         client.field372 = class140.field2189;
         client.field371 = class140.field2192;
      }

      client.field302 = client.field369 / 2 + client.field302 & 2047;
      client.field367 += client.field509 / 2;
      if(client.field367 < 128) {
         client.field367 = 128;
      }

      if(client.field367 > 383) {
         client.field367 = 383;
      }

      var2 = class76.field1390 >> 7;
      var3 = class56.field1200 >> 7;
      int var4 = class14.method147(class76.field1390, class56.field1200, class32.field754);
      int var5 = 0;
      int var6;
      if(var2 > 3 && var3 > 3 && var2 < 100 && var3 < 100) {
         for(var6 = var2 - 4; var6 <= 4 + var2; ++var6) {
            for(int var7 = var3 - 4; var7 <= 4 + var3; ++var7) {
               int var8 = class32.field754;
               if(var8 < 3 && (class5.field83[1][var6][var7] & 2) == 2) {
                  ++var8;
               }

               int var9 = var4 - class5.field100[var8][var6][var7];
               if(var9 > var5) {
                  var5 = var9;
               }
            }
         }
      }

      var6 = var5 * 192;
      if(var6 > 98048) {
         var6 = 98048;
      }

      if(var6 < '耀') {
         var6 = '耀';
      }

      if(var6 > client.field471) {
         client.field471 += (var6 - client.field471) / 24;
      } else if(var6 < client.field471) {
         client.field471 += (var6 - client.field471) / 80;
      }

   }
}
