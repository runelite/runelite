import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("r")
public final class class5 {
   @ObfuscatedName("v")
   static final int[] field82 = new int[]{1, -1, -1, 1};
   @ObfuscatedName("i")
   @Export("tileSettings")
   static byte[][][] field83 = new byte[4][104][104];
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -1522955063
   )
   static int field84 = 99;
   @ObfuscatedName("q")
   static final int[] field85 = new int[]{1, 0, -1, 0};
   @ObfuscatedName("r")
   static byte[][][] field86;
   @ObfuscatedName("z")
   static byte[][][] field87;
   @ObfuscatedName("d")
   static int[][] field88;
   @ObfuscatedName("o")
   static int[] field89;
   @ObfuscatedName("c")
   static final int[] field90 = new int[]{1, 2, 4, 8};
   @ObfuscatedName("n")
   static final int[] field91 = new int[]{16, 32, 64, 128};
   @ObfuscatedName("s")
   static byte[][][] field92;
   @ObfuscatedName("x")
   static final int[] field93 = new int[]{0, -1, 0, 1};
   @ObfuscatedName("m")
   static final int[] field95 = new int[]{-1, -1, 1, 1};
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 631687523
   )
   static int field96 = (int)(Math.random() * 17.0D) - 8;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 115553789
   )
   static int field97 = (int)(Math.random() * 33.0D) - 16;
   @ObfuscatedName("t")
   @Export("tileHeights")
   static int[][][] field100 = new int[4][105][105];

   @ObfuscatedName("cy")
   @ObfuscatedSignature(
      signature = "([Lclass173;IIIIIIIII)V",
      garbageValue = "1743367205"
   )
   @Export("gameDraw")
   static final void method65(class173[] var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
      class79.method1753(var2, var3, var4, var5);
      class91.method2084();

      for(int var9 = 0; var9 < var0.length; ++var9) {
         class173 var10 = var0[var9];
         if(var10 != null && (var10.field2795 == var1 || var1 == -1412584499 && client.field455 == var10)) {
            int var11;
            if(var8 == -1) {
               client.field490[client.field485] = var10.field2876 + var6;
               client.field436[client.field485] = var7 + var10.field2801;
               client.field535[client.field485] = var10.field2791;
               client.field493[client.field485] = var10.field2792;
               var11 = ++client.field485 - 1;
            } else {
               var11 = var8;
            }

            var10.field2813 = var11;
            var10.field2908 = client.field332;
            if(!var10.field2775 || !class14.method146(var10)) {
               int var12;
               if(var10.field2780 > 0) {
                  var12 = var10.field2780;
                  if(var12 == 324) {
                     if(client.field556 == -1) {
                        client.field556 = var10.field2811;
                        client.field557 = var10.field2907;
                     }

                     if(client.field555.field2942) {
                        var10.field2811 = client.field556;
                     } else {
                        var10.field2811 = client.field557;
                     }
                  } else if(var12 == 325) {
                     if(client.field556 == -1) {
                        client.field556 = var10.field2811;
                        client.field557 = var10.field2907;
                     }

                     if(client.field555.field2942) {
                        var10.field2811 = client.field557;
                     } else {
                        var10.field2811 = client.field556;
                     }
                  } else if(var12 == 327) {
                     var10.field2789 = 150;
                     var10.field2798 = (int)(Math.sin((double)client.field332 / 40.0D) * 256.0D) & 2047;
                     var10.field2871 = 5;
                     var10.field2829 = 0;
                  } else if(var12 == 328) {
                     var10.field2789 = 150;
                     var10.field2798 = (int)(Math.sin((double)client.field332 / 40.0D) * 256.0D) & 2047;
                     var10.field2871 = 5;
                     var10.field2829 = 1;
                  }
               }

               var12 = var10.field2876 + var6;
               int var13 = var7 + var10.field2801;
               int var14 = var10.field2807;
               int var15;
               int var16;
               if(var10 == client.field455) {
                  if(var1 != -1412584499 && !var10.field2854) {
                     class1.field18 = var0;
                     class49.field1102 = var6;
                     class24.field624 = var7;
                     continue;
                  }

                  if(client.field513 && client.field416) {
                     var15 = class140.field2192;
                     var16 = class140.field2189;
                     var15 -= client.field491;
                     var16 -= client.field348;
                     if(var15 < client.field279) {
                        var15 = client.field279;
                     }

                     if(var15 + var10.field2791 > client.field456.field2791 + client.field279) {
                        var15 = client.field456.field2791 + client.field279 - var10.field2791;
                     }

                     if(var16 < client.field408) {
                        var16 = client.field408;
                     }

                     if(var10.field2792 + var16 > client.field456.field2792 + client.field408) {
                        var16 = client.field456.field2792 + client.field408 - var10.field2792;
                     }

                     var12 = var15;
                     var13 = var16;
                  }

                  if(!var10.field2854) {
                     var14 = 128;
                  }
               }

               int var17;
               int var18;
               int var19;
               int var20;
               int var21;
               int var22;
               if(var10.field2778 == 2) {
                  var15 = var2;
                  var16 = var3;
                  var17 = var4;
                  var18 = var5;
               } else if(var10.field2778 == 9) {
                  var19 = var12;
                  var20 = var13;
                  var21 = var10.field2791 + var12;
                  var22 = var10.field2792 + var13;
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
                  var19 = var12 + var10.field2791;
                  var20 = var13 + var10.field2792;
                  var15 = var12 > var2?var12:var2;
                  var16 = var13 > var3?var13:var3;
                  var17 = var19 < var4?var19:var4;
                  var18 = var20 < var5?var20:var5;
               }

               if(!var10.field2775 || var15 < var17 && var16 < var18) {
                  if(var10.field2780 != 0) {
                     if(var10.field2780 == 1336) {
                        if(client.field376) {
                           var13 += 15;
                           class82.field1440.method3966("Fps:" + class144.field2224, var12 + var10.field2791, var13, 16776960, -1);
                           var13 += 15;
                           Runtime var48 = Runtime.getRuntime();
                           var20 = (int)((var48.totalMemory() - var48.freeMemory()) / 1024L);
                           var21 = 16776960;
                           if(var20 > '耀' && client.field287) {
                              var21 = 16711680;
                           }

                           if(var20 > 65536 && !client.field287) {
                              var21 = 16711680;
                           }

                           class82.field1440.method3966("Mem:" + var20 + "k", var12 + var10.field2791, var13, var21, -1);
                           var13 += 15;
                        }
                        continue;
                     }

                     if(var10.field2780 == 1337) {
                        client.field431 = var12;
                        client.field375 = var13;
                        class173.method3411(var12, var13, var10.field2791, var10.field2792);
                        client.field396[var10.field2813] = true;
                        class79.method1753(var2, var3, var4, var5);
                        continue;
                     }

                     if(var10.field2780 == 1338) {
                        class22.method562(var10, var12, var13, var11);
                        class79.method1753(var2, var3, var4, var5);
                        continue;
                     }

                     if(var10.field2780 == 1339) {
                        class162.method3166(var10, var12, var13, var11);
                        class79.method1753(var2, var3, var4, var5);
                        continue;
                     }
                  }

                  if(var10.field2778 == 0) {
                     if(!var10.field2775 && class14.method146(var10) && class131.field2082 != var10) {
                        continue;
                     }

                     if(!var10.field2775) {
                        if(var10.field2861 > var10.field2823 - var10.field2792) {
                           var10.field2861 = var10.field2823 - var10.field2792;
                        }

                        if(var10.field2861 < 0) {
                           var10.field2861 = 0;
                        }
                     }

                     method65(var0, var10.field2776, var15, var16, var17, var18, var12 - var10.field2835, var13 - var10.field2861, var11);
                     if(var10.field2770 != null) {
                        method65(var10.field2770, var10.field2776, var15, var16, var17, var18, var12 - var10.field2835, var13 - var10.field2861, var11);
                     }

                     class3 var36 = (class3)client.field443.method3748((long)var10.field2776);
                     if(var36 != null) {
                        var20 = var36.field65;
                        if(!class173.method3380(var20)) {
                           if(var11 != -1) {
                              client.field396[var11] = true;
                           } else {
                              for(var21 = 0; var21 < 100; ++var21) {
                                 client.field396[var21] = true;
                              }
                           }
                        } else {
                           class1.field18 = null;
                           method65(class216.field3168[var20], -1, var15, var16, var17, var18, var12, var13, var11);
                           if(class1.field18 != null) {
                              method65(class1.field18, -1412584499, var15, var16, var17, var18, class49.field1102, class24.field624, var11);
                              class1.field18 = null;
                           }
                        }
                     }

                     class79.method1753(var2, var3, var4, var5);
                     class91.method2084();
                  }

                  if(client.field496 || client.field546[var11] || client.field494 > 1) {
                     int var23;
                     int var24;
                     if(var10.field2778 == 0 && !var10.field2775 && var10.field2823 > var10.field2792) {
                        var19 = var12 + var10.field2791;
                        var20 = var10.field2861;
                        var21 = var10.field2792;
                        var22 = var10.field2823;
                        class144.field2243[0].method1822(var19, var13);
                        class144.field2243[1].method1822(var19, var21 + var13 - 16);
                        class79.method1785(var19, var13 + 16, 16, var21 - 32, client.field361);
                        var23 = (var21 - 32) * var21 / var22;
                        if(var23 < 8) {
                           var23 = 8;
                        }

                        var24 = var20 * (var21 - 32 - var23) / (var22 - var21);
                        class79.method1785(var19, 16 + var13 + var24, 16, var23, client.field362);
                        class79.method1807(var19, 16 + var13 + var24, var23, client.field364);
                        class79.method1807(var19 + 1, var24 + 16 + var13, var23, client.field364);
                        class79.method1759(var19, var24 + 16 + var13, 16, client.field364);
                        class79.method1759(var19, var24 + 17 + var13, 16, client.field364);
                        class79.method1807(15 + var19, var13 + 16 + var24, var23, client.field363);
                        class79.method1807(14 + var19, var24 + 17 + var13, var23 - 1, client.field363);
                        class79.method1759(var19, var23 + 15 + var13 + var24, 16, client.field363);
                        class79.method1759(1 + var19, 14 + var13 + var24 + var23, 15, client.field363);
                     }

                     if(var10.field2778 != 1) {
                        int var25;
                        int var26;
                        int var29;
                        if(var10.field2778 == 2) {
                           var19 = 0;

                           for(var20 = 0; var20 < var10.field2788; ++var20) {
                              for(var21 = 0; var21 < var10.field2787; ++var21) {
                                 var22 = (32 + var10.field2848) * var21 + var12;
                                 var23 = var13 + var20 * (32 + var10.field2812);
                                 if(var19 < 20) {
                                    var22 += var10.field2844[var19];
                                    var23 += var10.field2845[var19];
                                 }

                                 if(var10.field2849[var19] <= 0) {
                                    if(null != var10.field2846 && var19 < 20) {
                                       class78 var53 = var10.method3373(var19);
                                       if(var53 != null) {
                                          var53.method1667(var22, var23);
                                       } else if(class173.field2774) {
                                          class20.method547(var10);
                                       }
                                    }
                                 } else {
                                    boolean var44 = false;
                                    boolean var45 = false;
                                    var26 = var10.field2849[var19] - 1;
                                    if(32 + var22 > var2 && var22 < var4 && var23 + 32 > var3 && var23 < var5 || var10 == class6.field126 && client.field398 == var19) {
                                       class78 var27;
                                       if(client.field379 == 1 && class127.field2059 == var19 && class143.field2208 == var10.field2776) {
                                          var27 = client.method542(var26, var10.field2868[var19], 2, 0, 2, false);
                                       } else {
                                          var27 = client.method542(var26, var10.field2868[var19], 1, 3153952, 2, false);
                                       }

                                       if(var27 != null) {
                                          if(var10 == class6.field126 && var19 == client.field398) {
                                             var24 = class140.field2192 - client.field424;
                                             var25 = class140.field2189 - client.field315;
                                             if(var24 < 5 && var24 > -5) {
                                                var24 = 0;
                                             }

                                             if(var25 < 5 && var25 > -5) {
                                                var25 = 0;
                                             }

                                             if(client.field440 < 5) {
                                                var24 = 0;
                                                var25 = 0;
                                             }

                                             var27.method1700(var22 + var24, var25 + var23, 128);
                                             if(var1 != -1) {
                                                class173 var42 = var0[var1 & '\uffff'];
                                                if(var25 + var23 < class79.field1416 && var42.field2861 > 0) {
                                                   var29 = client.field330 * (class79.field1416 - var23 - var25) / 3;
                                                   if(var29 > client.field330 * 10) {
                                                      var29 = client.field330 * 10;
                                                   }

                                                   if(var29 > var42.field2861) {
                                                      var29 = var42.field2861;
                                                   }

                                                   var42.field2861 -= var29;
                                                   client.field315 += var29;
                                                   class20.method547(var42);
                                                }

                                                if(32 + var23 + var25 > class79.field1419 && var42.field2861 < var42.field2823 - var42.field2792) {
                                                   var29 = (32 + var23 + var25 - class79.field1419) * client.field330 / 3;
                                                   if(var29 > client.field330 * 10) {
                                                      var29 = client.field330 * 10;
                                                   }

                                                   if(var29 > var42.field2823 - var42.field2792 - var42.field2861) {
                                                      var29 = var42.field2823 - var42.field2792 - var42.field2861;
                                                   }

                                                   var42.field2861 += var29;
                                                   client.field315 -= var29;
                                                   class20.method547(var42);
                                                }
                                             }
                                          } else if(client.field291 == var10 && var19 == client.field397) {
                                             var27.method1700(var22, var23, 128);
                                          } else {
                                             var27.method1667(var22, var23);
                                          }
                                       } else {
                                          class20.method547(var10);
                                       }
                                    }
                                 }

                                 ++var19;
                              }
                           }
                        } else if(var10.field2778 == 3) {
                           if(class77.method1653(var10)) {
                              var19 = var10.field2802;
                              if(class131.field2082 == var10 && var10.field2804 != 0) {
                                 var19 = var10.field2804;
                              }
                           } else {
                              var19 = var10.field2797;
                              if(class131.field2082 == var10 && var10.field2803 != 0) {
                                 var19 = var10.field2803;
                              }
                           }

                           if(var10.field2895) {
                              switch(var10.field2806.field1431) {
                              case 1:
                                 class79.method1760(var12, var13, var10.field2791, var10.field2792, var10.field2797, var10.field2802, 256 - (var10.field2807 & 255), 256 - (var10.field2785 & 255));
                                 break;
                              case 2:
                                 class79.method1788(var12, var13, var10.field2791, var10.field2792, var10.field2797, var10.field2802, 256 - (var10.field2807 & 255), 256 - (var10.field2785 & 255));
                                 break;
                              case 3:
                                 class79.method1778(var12, var13, var10.field2791, var10.field2792, var10.field2797, var10.field2802, 256 - (var10.field2807 & 255), 256 - (var10.field2785 & 255));
                                 break;
                              case 4:
                                 class79.method1763(var12, var13, var10.field2791, var10.field2792, var10.field2797, var10.field2802, 256 - (var10.field2807 & 255), 256 - (var10.field2785 & 255));
                                 break;
                              default:
                                 if(var14 == 0) {
                                    class79.method1785(var12, var13, var10.field2791, var10.field2792, var19);
                                 } else {
                                    class79.method1758(var12, var13, var10.field2791, var10.field2792, var19, 256 - (var14 & 255));
                                 }
                              }
                           } else if(var14 == 0) {
                              class79.method1772(var12, var13, var10.field2791, var10.field2792, var19);
                           } else {
                              class79.method1766(var12, var13, var10.field2791, var10.field2792, var19, 256 - (var14 & 255));
                           }
                        } else {
                           class224 var46;
                           if(var10.field2778 == 4) {
                              var46 = var10.method3372();
                              if(null == var46) {
                                 if(class173.field2774) {
                                    class20.method547(var10);
                                 }
                              } else {
                                 String var52 = var10.field2832;
                                 if(class77.method1653(var10)) {
                                    var20 = var10.field2802;
                                    if(var10 == class131.field2082 && var10.field2804 != 0) {
                                       var20 = var10.field2804;
                                    }

                                    if(var10.field2837.length() > 0) {
                                       var52 = var10.field2837;
                                    }
                                 } else {
                                    var20 = var10.field2797;
                                    if(class131.field2082 == var10 && var10.field2803 != 0) {
                                       var20 = var10.field2803;
                                    }
                                 }

                                 if(var10.field2775 && var10.field2896 != -1) {
                                    class51 var51 = class123.method2743(var10.field2896);
                                    var52 = var51.field1120;
                                    if(null == var52) {
                                       var52 = "null";
                                    }

                                    if((var51.field1131 == 1 || var10.field2897 != 1) && var10.field2897 != -1) {
                                       var52 = class155.method3132(16748608) + var52 + "</col>" + " " + 'x' + class7.method88(var10.field2897);
                                    }
                                 }

                                 if(var10 == client.field399) {
                                    class157 var10000 = (class157)null;
                                    var52 = "Please wait...";
                                    var20 = var10.field2797;
                                 }

                                 if(!var10.field2775) {
                                    var52 = class74.method1562(var52, var10);
                                 }

                                 var46.method3985(var52, var12, var13, var10.field2791, var10.field2792, var20, var10.field2841?0:-1, var10.field2839, var10.field2840, var10.field2838);
                              }
                           } else if(var10.field2778 == 5) {
                              class78 var47;
                              if(!var10.field2775) {
                                 var47 = var10.method3401(class77.method1653(var10));
                                 if(var47 != null) {
                                    var47.method1667(var12, var13);
                                 } else if(class173.field2774) {
                                    class20.method547(var10);
                                 }
                              } else {
                                 if(var10.field2896 != -1) {
                                    var47 = client.method542(var10.field2896, var10.field2897, var10.field2769, var10.field2816, var10.field2834, false);
                                 } else {
                                    var47 = var10.method3401(false);
                                 }

                                 if(null == var47) {
                                    if(class173.field2774) {
                                       class20.method547(var10);
                                    }
                                 } else {
                                    var20 = var47.field1408;
                                    var21 = var47.field1411;
                                    if(!var10.field2814) {
                                       var22 = var10.field2791 * 4096 / var20;
                                       if(var10.field2857 != 0) {
                                          var47.method1738(var12 + var10.field2791 / 2, var10.field2792 / 2 + var13, var10.field2857, var22);
                                       } else if(var14 != 0) {
                                          var47.method1683(var12, var13, var10.field2791, var10.field2792, 256 - (var14 & 255));
                                       } else if(var10.field2791 == var20 && var10.field2792 == var21) {
                                          var47.method1667(var12, var13);
                                       } else {
                                          var47.method1677(var12, var13, var10.field2791, var10.field2792);
                                       }
                                    } else {
                                       class79.method1800(var12, var13, var10.field2791 + var12, var10.field2792 + var13);
                                       var22 = (var20 - 1 + var10.field2791) / var20;
                                       var23 = (var21 - 1 + var10.field2792) / var21;

                                       for(var24 = 0; var24 < var22; ++var24) {
                                          for(var25 = 0; var25 < var23; ++var25) {
                                             if(var10.field2857 != 0) {
                                                var47.method1738(var20 / 2 + var12 + var24 * var20, var21 / 2 + var13 + var21 * var25, var10.field2857, 4096);
                                             } else if(var14 != 0) {
                                                var47.method1700(var20 * var24 + var12, var13 + var21 * var25, 256 - (var14 & 255));
                                             } else {
                                                var47.method1667(var12 + var20 * var24, var13 + var21 * var25);
                                             }
                                          }
                                       }

                                       class79.method1753(var2, var3, var4, var5);
                                    }
                                 }
                              }
                           } else {
                              class51 var39;
                              if(var10.field2778 == 6) {
                                 boolean var43 = class77.method1653(var10);
                                 if(var43) {
                                    var20 = var10.field2842;
                                 } else {
                                    var20 = var10.field2893;
                                 }

                                 class105 var49 = null;
                                 var22 = 0;
                                 if(var10.field2896 != -1) {
                                    var39 = class123.method2743(var10.field2896);
                                    if(var39 != null) {
                                       var39 = var39.method999(var10.field2897);
                                       var49 = var39.method998(1);
                                       if(null != var49) {
                                          var49.method2258();
                                          var22 = var49.field1466 / 2;
                                       } else {
                                          class20.method547(var10);
                                       }
                                    }
                                 } else if(var10.field2871 == 5) {
                                    if(var10.field2829 == 0) {
                                       var49 = client.field555.method3436((class42)null, -1, (class42)null, -1);
                                    } else {
                                       var49 = class152.field2301.vmethod1862();
                                    }
                                 } else if(var20 == -1) {
                                    var49 = var10.method3400((class42)null, -1, var43, class152.field2301.field59);
                                    if(var49 == null && class173.field2774) {
                                       class20.method547(var10);
                                    }
                                 } else {
                                    class42 var54 = class18.method177(var20);
                                    var49 = var10.method3400(var54, var10.field2898, var43, class152.field2301.field59);
                                    if(var49 == null && class173.field2774) {
                                       class20.method547(var10);
                                    }
                                 }

                                 class91.method2102(var10.field2791 / 2 + var12, var13 + var10.field2792 / 2);
                                 var23 = class91.field1602[var10.field2789] * var10.field2830 >> 16;
                                 var24 = class91.field1603[var10.field2789] * var10.field2830 >> 16;
                                 if(null != var49) {
                                    if(!var10.field2775) {
                                       var49.method2269(0, var10.field2798, 0, var10.field2789, 0, var23, var24);
                                    } else {
                                       var49.method2258();
                                       if(var10.field2855) {
                                          var49.method2270(0, var10.field2798, var10.field2799, var10.field2789, var10.field2843, var22 + var23 + var10.field2826, var10.field2826 + var24, var10.field2830);
                                       } else {
                                          var49.method2269(0, var10.field2798, var10.field2799, var10.field2789, var10.field2843, var10.field2826 + var22 + var23, var24 + var10.field2826);
                                       }
                                    }
                                 }

                                 class91.method2052();
                              } else {
                                 if(var10.field2778 == 7) {
                                    var46 = var10.method3372();
                                    if(var46 == null) {
                                       if(class173.field2774) {
                                          class20.method547(var10);
                                       }
                                       continue;
                                    }

                                    var20 = 0;

                                    for(var21 = 0; var21 < var10.field2788; ++var21) {
                                       for(var22 = 0; var22 < var10.field2787; ++var22) {
                                          if(var10.field2849[var20] > 0) {
                                             var39 = class123.method2743(var10.field2849[var20] - 1);
                                             String var40;
                                             if(var39.field1131 != 1 && var10.field2868[var20] == 1) {
                                                var40 = class155.method3132(16748608) + var39.field1120 + "</col>";
                                             } else {
                                                var40 = class155.method3132(16748608) + var39.field1120 + "</col>" + " " + 'x' + class7.method88(var10.field2868[var20]);
                                             }

                                             var25 = var12 + (var10.field2848 + 115) * var22;
                                             var26 = var13 + var21 * (var10.field2812 + 12);
                                             if(var10.field2839 == 0) {
                                                var46.method3968(var40, var25, var26, var10.field2797, var10.field2841?0:-1);
                                             } else if(var10.field2839 == 1) {
                                                var46.method3970(var40, var25 + var10.field2791 / 2, var26, var10.field2797, var10.field2841?0:-1);
                                             } else {
                                                var46.method3966(var40, var10.field2791 + var25 - 1, var26, var10.field2797, var10.field2841?0:-1);
                                             }
                                          }

                                          ++var20;
                                       }
                                    }
                                 }

                                 int var41;
                                 if(var10.field2778 == 8 && class24.field617 == var10 && client.field434 == client.field433) {
                                    var19 = 0;
                                    var20 = 0;
                                    class224 var38 = class82.field1440;
                                    String var37 = var10.field2832;

                                    String var50;
                                    for(var37 = class74.method1562(var37, var10); var37.length() > 0; var20 += 1 + var38.field3193) {
                                       var24 = var37.indexOf("<br>");
                                       if(var24 != -1) {
                                          var50 = var37.substring(0, var24);
                                          var37 = var37.substring(4 + var24);
                                       } else {
                                          var50 = var37;
                                          var37 = "";
                                       }

                                       var25 = var38.method3963(var50);
                                       if(var25 > var19) {
                                          var19 = var25;
                                       }
                                    }

                                    var19 += 6;
                                    var20 += 7;
                                    var24 = var10.field2791 + var12 - 5 - var19;
                                    var25 = 5 + var10.field2792 + var13;
                                    if(var24 < var12 + 5) {
                                       var24 = 5 + var12;
                                    }

                                    if(var24 + var19 > var4) {
                                       var24 = var4 - var19;
                                    }

                                    if(var20 + var25 > var5) {
                                       var25 = var5 - var20;
                                    }

                                    class79.method1785(var24, var25, var19, var20, 16777120);
                                    class79.method1772(var24, var25, var19, var20, 0);
                                    var37 = var10.field2832;
                                    var26 = var38.field3193 + var25 + 2;

                                    for(var37 = class74.method1562(var37, var10); var37.length() > 0; var26 += 1 + var38.field3193) {
                                       var41 = var37.indexOf("<br>");
                                       if(var41 != -1) {
                                          var50 = var37.substring(0, var41);
                                          var37 = var37.substring(var41 + 4);
                                       } else {
                                          var50 = var37;
                                          var37 = "";
                                       }

                                       var38.method3968(var50, var24 + 3, var26, 0, -1);
                                    }
                                 }

                                 if(var10.field2778 == 9) {
                                    if(var10.field2809 == 1) {
                                       if(var10.field2810) {
                                          var19 = var12;
                                          var20 = var10.field2792 + var13;
                                          var21 = var12 + var10.field2791;
                                          var22 = var13;
                                       } else {
                                          var19 = var12;
                                          var20 = var13;
                                          var21 = var12 + var10.field2791;
                                          var22 = var13 + var10.field2792;
                                       }

                                       class79.method1771(var19, var20, var21, var22, var10.field2797);
                                    } else {
                                       var19 = var10.field2791 >= 0?var10.field2791:-var10.field2791;
                                       var20 = var10.field2792 >= 0?var10.field2792:-var10.field2792;
                                       var21 = var19;
                                       if(var19 < var20) {
                                          var21 = var20;
                                       }

                                       if(var21 != 0) {
                                          var22 = (var10.field2791 << 16) / var21;
                                          var23 = (var10.field2792 << 16) / var21;
                                          if(var23 <= var22) {
                                             var22 = -var22;
                                          } else {
                                             var23 = -var23;
                                          }

                                          var24 = var10.field2809 * var23 >> 17;
                                          var25 = 1 + var10.field2809 * var23 >> 17;
                                          var26 = var22 * var10.field2809 >> 17;
                                          var41 = 1 + var22 * var10.field2809 >> 17;
                                          int var28 = var24 + var12;
                                          var29 = var12 - var25;
                                          int var30 = var12 + var10.field2791 - var25;
                                          int var31 = var10.field2791 + var12 + var24;
                                          int var32 = var13 + var26;
                                          int var33 = var13 - var41;
                                          int var34 = var13 + var10.field2792 - var41;
                                          int var35 = var10.field2792 + var13 + var26;
                                          class91.method2058(var28, var29, var30);
                                          class91.method2061(var32, var33, var34, var28, var29, var30, var10.field2797);
                                          class91.method2058(var28, var30, var31);
                                          class91.method2061(var32, var34, var35, var28, var30, var31, var10.field2797);
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

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "-1770388740"
   )
   static int method66(int var0) {
      class35 var1 = (class35)class11.field180.method3761((long)var0);
      return var1 == null?-1:(var1.field3115 == class11.field174.field3110?-1:((class35)var1.field3115).field780);
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)Ljava/lang/Class;",
      garbageValue = "-1690111423"
   )
   public static Class method67(String var0) throws ClassNotFoundException {
      return var0.equals("B")?Byte.TYPE:(var0.equals("I")?Integer.TYPE:(var0.equals("S")?Short.TYPE:(var0.equals("J")?Long.TYPE:(var0.equals("Z")?Boolean.TYPE:(var0.equals("F")?Float.TYPE:(var0.equals("D")?Double.TYPE:(var0.equals("C")?Character.TYPE:(var0.equals("void")?Void.TYPE:Class.forName(var0)))))))));
   }
}
