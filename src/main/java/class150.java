import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ed")
public class class150 {
   @ObfuscatedName("ct")
   @ObfuscatedSignature(
      signature = "([Lclass172;IIIIIIIII)V",
      garbageValue = "-1977370989"
   )
   static final void method3147(class172[] var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
      class79.method1852(var2, var3, var4, var5);
      class90.method2153();

      for(int var9 = 0; var9 < var0.length; ++var9) {
         class172 var10 = var0[var9];
         if(null != var10 && (var10.field2762 == var1 || var1 == -1412584499 && var10 == client.field466)) {
            int var11;
            if(var8 == -1) {
               client.field502[client.field497] = var6 + var10.field2734;
               client.field515[client.field497] = var7 + var10.field2757;
               client.field504[client.field497] = var10.field2752;
               client.field505[client.field497] = var10.field2759;
               var11 = ++client.field497 - 1;
            } else {
               var11 = var8;
            }

            var10.field2872 = var11;
            var10.field2873 = client.field303 * -1;
            if(!var10.field2742 || !class112.method2447(var10)) {
               int var12;
               if(var10.field2747 > 0) {
                  var12 = var10.field2747;
                  if(var12 == 324) {
                     if(client.field570 * -1 == -1) {
                        client.field570 = var10.field2776 * -1;
                        client.field571 = var10.field2777 * -1;
                     }

                     if(client.field378.field2904) {
                        var10.field2776 = client.field570 * -1;
                     } else {
                        var10.field2776 = client.field571 * -1;
                     }
                  } else if(325 == var12) {
                     if(client.field570 * -1 == -1) {
                        client.field570 = var10.field2776 * -1;
                        client.field571 = var10.field2777 * -1;
                     }

                     if(client.field378.field2904) {
                        var10.field2776 = client.field571 * -1;
                     } else {
                        var10.field2776 = client.field570 * -1;
                     }
                  } else if(327 == var12) {
                     var10.field2792 = 150;
                     var10.field2802 = (int)(Math.sin((double)client.field303 / 40.0D) * 256.0D) & 2047;
                     var10.field2784 = 5;
                     var10.field2846 = 0;
                  } else if(var12 == 328) {
                     var10.field2792 = 150;
                     var10.field2802 = (int)(Math.sin((double)client.field303 / 40.0D) * 256.0D) & 2047;
                     var10.field2784 = 5;
                     var10.field2846 = 1;
                  }
               }

               var12 = var6 + var10.field2734;
               int var13 = var10.field2757 + var7;
               int var14 = var10.field2773;
               int var15;
               int var16;
               if(client.field466 == var10) {
                  if(-1412584499 != var1 && !var10.field2754) {
                     class11.field170 = var0;
                     class13.field200 = var6;
                     class59.field1215 = var7;
                     continue;
                  }

                  if(client.field565 && client.field498) {
                     var15 = class139.field2140;
                     var16 = class139.field2135;
                     var15 -= client.field468;
                     var16 -= client.field469;
                     if(var15 < client.field480) {
                        var15 = client.field480;
                     }

                     if(var15 + var10.field2752 > client.field480 + client.field566.field2752) {
                        var15 = client.field566.field2752 + client.field480 - var10.field2752;
                     }

                     if(var16 < client.field473) {
                        var16 = client.field473;
                     }

                     if(var16 + var10.field2759 > client.field473 + client.field566.field2759) {
                        var16 = client.field566.field2759 + client.field473 - var10.field2759;
                     }

                     var12 = var15;
                     var13 = var16;
                  }

                  if(!var10.field2754) {
                     var14 = 128;
                  }
               }

               int var17;
               int var18;
               int var19;
               int var20;
               int var21;
               int var22;
               if(2 == var10.field2764) {
                  var15 = var2;
                  var16 = var3;
                  var17 = var4;
                  var18 = var5;
               } else if(9 == var10.field2764) {
                  var19 = var12;
                  var20 = var13;
                  var21 = var10.field2752 + var12;
                  var22 = var10.field2759 + var13;
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
                  var19 = var12 + var10.field2752;
                  var20 = var10.field2759 + var13;
                  var15 = var12 > var2?var12:var2;
                  var16 = var13 > var3?var13:var3;
                  var17 = var19 < var4?var19:var4;
                  var18 = var20 < var5?var20:var5;
               }

               if(!var10.field2742 || var15 < var17 && var16 < var18) {
                  if(0 != var10.field2747) {
                     if(1336 == var10.field2747) {
                        if(client.field309) {
                           var13 += 15;
                           class72.field1348.method4058("Fps:" + class143.field2178, var10.field2752 + var12, var13, 16776960, -1);
                           var13 += 15;
                           Runtime var51 = Runtime.getRuntime();
                           var20 = (int)((var51.totalMemory() - var51.freeMemory()) / 1024L);
                           var21 = 16776960;
                           if(var20 > '耀' && client.field297) {
                              var21 = 16711680;
                           }

                           if(var20 > 65536 && !client.field297) {
                              var21 = 16711680;
                           }

                           class72.field1348.method4058("Mem:" + var20 + "k", var12 + var10.field2752, var13, var21, -1);
                           var13 += 15;
                        }
                        continue;
                     }

                     if(var10.field2747 == 1337) {
                        client.field442 = var12;
                        client.field443 = var13;
                        class56.method1229(var12, var13, var10.field2752, var10.field2759);
                        client.field499[var10.field2872] = true;
                        class79.method1852(var2, var3, var4, var5);
                        continue;
                     }

                     if(1338 == var10.field2747) {
                        class97.method2214(var10, var12, var13, var11);
                        class79.method1852(var2, var3, var4, var5);
                        continue;
                     }

                     if(var10.field2747 == 1339) {
                        class147.method3132(var10, var12, var13);
                        class79.method1852(var2, var3, var4, var5);
                        continue;
                     }
                  }

                  if(var10.field2764 == 0) {
                     if(!var10.field2742 && class112.method2447(var10) && var10 != class188.field3039) {
                        continue;
                     }

                     if(!var10.field2742) {
                        if(var10.field2765 > var10.field2813 - var10.field2759) {
                           var10.field2765 = var10.field2813 - var10.field2759;
                        }

                        if(var10.field2765 < 0) {
                           var10.field2765 = 0;
                        }
                     }

                     method3147(var0, var10.field2800 * -1, var15, var16, var17, var18, var12 - var10.field2803, var13 - var10.field2765, var11);
                     if(null != var10.field2865) {
                        method3147(var10.field2865, var10.field2800 * -1, var15, var16, var17, var18, var12 - var10.field2803, var13 - var10.field2765, var11);
                     }

                     class3 var36 = (class3)client.field454.method3824((long)(var10.field2800 * -1));
                     if(null != var36) {
                        class48.method1018(var36.field56, var15, var16, var17, var18, var12, var13, var11);
                     }

                     class79.method1852(var2, var3, var4, var5);
                     class90.method2153();
                  }

                  if(client.field508 || client.field501[var11] || client.field522 > 1) {
                     int var23;
                     int var24;
                     if(0 == var10.field2764 && !var10.field2742 && var10.field2813 > var10.field2759) {
                        var19 = var12 + var10.field2752;
                        var20 = var10.field2765;
                        var21 = var10.field2759;
                        var22 = var10.field2813;
                        class220.field3174[0].method1883(var19, var13);
                        class220.field3174[1].method1883(var19, var13 + var21 - 16);
                        class79.method1830(var19, var13 + 16, 16, var21 - 32, client.field424);
                        var23 = var21 * (var21 - 32) / var22;
                        if(var23 < 8) {
                           var23 = 8;
                        }

                        var24 = (var21 - 32 - var23) * var20 / (var22 - var21);
                        class79.method1830(var19, var24 + var13 + 16, 16, var23, client.field373);
                        class79.method1862(var19, var24 + var13 + 16, var23, client.field375);
                        class79.method1862(var19 + 1, var13 + 16 + var24, var23, client.field375);
                        class79.method1864(var19, var24 + 16 + var13, 16, client.field375);
                        class79.method1864(var19, 17 + var13 + var24, 16, client.field375);
                        class79.method1862(15 + var19, var24 + var13 + 16, var23, client.field374);
                        class79.method1862(14 + var19, 17 + var13 + var24, var23 - 1, client.field374);
                        class79.method1864(var19, var23 + var24 + 15 + var13, 16, client.field374);
                        class79.method1864(var19 + 1, var24 + 14 + var13 + var23, 15, client.field374);
                     }

                     if(1 != var10.field2764) {
                        int var25;
                        int var26;
                        int var29;
                        if(2 == var10.field2764) {
                           var19 = 0;

                           for(var20 = 0; var20 < var10.field2755; ++var20) {
                              for(var21 = 0; var21 < var10.field2783; ++var21) {
                                 var22 = var12 + (var10.field2807 + 32) * var21;
                                 var23 = var20 * (var10.field2805 + 32) + var13;
                                 if(var19 < 20) {
                                    var22 += var10.field2809[var19];
                                    var23 += var10.field2810[var19];
                                 }

                                 if(var10.field2859[var19] <= 0) {
                                    if(null != var10.field2745 && var19 < 20) {
                                       class78 var53 = var10.method3422(var19);
                                       if(var53 != null) {
                                          var53.method1805(var22, var23);
                                       } else if(class172.field2769) {
                                          class36.method745(var10);
                                       }
                                    }
                                 } else {
                                    boolean var52 = false;
                                    boolean var46 = false;
                                    var26 = var10.field2859[var19] - 1;
                                    if(var22 + 32 > var2 && var22 < var4 && var23 + 32 > var3 && var23 < var5 || class32.field762 == var10 && var19 == client.field408) {
                                       class78 var47;
                                       if(1 == client.field446 && class152.field2264 == var19 && var10.field2800 * -1 == class88.field1536) {
                                          var47 = class163.method3234(var26, var10.field2860[var19], 2, 0, 2, false);
                                       } else {
                                          var47 = class163.method3234(var26, var10.field2860[var19], 1, 3153952, 2, false);
                                       }

                                       if(var47 != null) {
                                          if(var10 == class32.field762 && client.field408 == var19) {
                                             var24 = class139.field2140 - client.field510;
                                             var25 = class139.field2135 - client.field493;
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

                                             var47.method1761(var24 + var22, var23 + var25, 128);
                                             if(var1 != -1) {
                                                class172 var50 = var0[var1 & '\uffff'];
                                                if(var25 + var23 < class79.field1409 && var50.field2765 > 0) {
                                                   var29 = (class79.field1409 - var23 - var25) * client.field409 / 3;
                                                   if(var29 > client.field409 * 10) {
                                                      var29 = client.field409 * 10;
                                                   }

                                                   if(var29 > var50.field2765) {
                                                      var29 = var50.field2765;
                                                   }

                                                   var50.field2765 -= var29;
                                                   client.field493 += var29;
                                                   class36.method745(var50);
                                                }

                                                if(var23 + var25 + 32 > class79.field1413 && var50.field2765 < var50.field2813 - var50.field2759) {
                                                   var29 = client.field409 * (var23 + var25 + 32 - class79.field1413) / 3;
                                                   if(var29 > client.field409 * 10) {
                                                      var29 = client.field409 * 10;
                                                   }

                                                   if(var29 > var50.field2813 - var50.field2759 - var50.field2765) {
                                                      var29 = var50.field2813 - var50.field2759 - var50.field2765;
                                                   }

                                                   var50.field2765 += var29;
                                                   client.field493 -= var29;
                                                   class36.method745(var50);
                                                }
                                             }
                                          } else if(var10 == class28.field679 && client.field350 == var19) {
                                             var47.method1761(var22, var23, 128);
                                          } else {
                                             var47.method1805(var22, var23);
                                          }
                                       } else {
                                          class36.method745(var10);
                                       }
                                    }
                                 }

                                 ++var19;
                              }
                           }
                        } else if(3 == var10.field2764) {
                           if(class92.method2181(var10)) {
                              var19 = var10.field2837;
                              if(class188.field3039 == var10 && var10.field2771 != 0) {
                                 var19 = var10.field2771;
                              }
                           } else {
                              var19 = var10.field2768;
                              if(var10 == class188.field3039 && 0 != var10.field2770) {
                                 var19 = var10.field2770;
                              }
                           }

                           if(var14 == 0) {
                              if(var10.field2772) {
                                 class79.method1830(var12, var13, var10.field2752, var10.field2759, var19);
                              } else {
                                 class79.method1853(var12, var13, var10.field2752, var10.field2759, var19);
                              }
                           } else if(var10.field2772) {
                              class79.method1829(var12, var13, var10.field2752, var10.field2759, var19, 256 - (var14 & 255));
                           } else {
                              class79.method1833(var12, var13, var10.field2752, var10.field2759, var19, 256 - (var14 & 255));
                           }
                        } else {
                           class223 var37;
                           if(4 == var10.field2764) {
                              var37 = var10.method3453();
                              if(null == var37) {
                                 if(class172.field2769) {
                                    class36.method745(var10);
                                 }
                              } else {
                                 String var49 = var10.field2778;
                                 if(class92.method2181(var10)) {
                                    var20 = var10.field2837;
                                    if(var10 == class188.field3039 && 0 != var10.field2771) {
                                       var20 = var10.field2771;
                                    }

                                    if(var10.field2774.length() > 0) {
                                       var49 = var10.field2774;
                                    }
                                 } else {
                                    var20 = var10.field2768;
                                    if(class188.field3039 == var10 && 0 != var10.field2770) {
                                       var20 = var10.field2770;
                                    }
                                 }

                                 if(var10.field2742 && var10.field2834 != -1) {
                                    class51 var54 = class75.method1648(var10.field2834);
                                    var49 = var54.field1115;
                                    if(null == var49) {
                                       var49 = "null";
                                    }

                                    if((1 == var54.field1126 || 1 != var10.field2862) && -1 != var10.field2862) {
                                       var49 = class51.method1090(16748608) + var49 + "</col>" + " " + 'x' + class74.method1639(var10.field2862);
                                    }
                                 }

                                 if(client.field431 == var10) {
                                    class156 var10000 = (class156)null;
                                    var49 = "Please wait...";
                                    var20 = var10.field2768;
                                 }

                                 if(!var10.field2742) {
                                    var49 = class7.method115(var49, var10);
                                 }

                                 var37.method4095(var49, var12, var13, var10.field2752, var10.field2759, var20, var10.field2785?0:-1, var10.field2819, var10.field2866, var10.field2741);
                              }
                           } else if(var10.field2764 == 5) {
                              class78 var40;
                              if(!var10.field2742) {
                                 var40 = var10.method3420(class92.method2181(var10));
                                 if(var40 != null) {
                                    var40.method1805(var12, var13);
                                 } else if(class172.field2769) {
                                    class36.method745(var10);
                                 }
                              } else {
                                 if(-1 != var10.field2834) {
                                    var40 = class163.method3234(var10.field2834, var10.field2862, var10.field2780, var10.field2781, var10.field2839, false);
                                 } else {
                                    var40 = var10.method3420(false);
                                 }

                                 if(null == var40) {
                                    if(class172.field2769) {
                                       class36.method745(var10);
                                    }
                                 } else {
                                    var20 = var40.field1402;
                                    var21 = var40.field1403;
                                    if(!var10.field2821) {
                                       var22 = var10.field2752 * 4096 / var20;
                                       if(var10.field2779 != 0) {
                                          var40.method1753(var12 + var10.field2752 / 2, var13 + var10.field2759 / 2, var10.field2779, var22);
                                       } else if(0 != var14) {
                                          var40.method1748(var12, var13, var10.field2752, var10.field2759, 256 - (var14 & 255));
                                       } else if(var10.field2752 == var20 && var21 == var10.field2759) {
                                          var40.method1805(var12, var13);
                                       } else {
                                          var40.method1787(var12, var13, var10.field2752, var10.field2759);
                                       }
                                    } else {
                                       class79.method1825(var12, var13, var12 + var10.field2752, var13 + var10.field2759);
                                       var22 = (var10.field2752 + (var20 - 1)) / var20;
                                       var23 = (var10.field2759 + (var21 - 1)) / var21;

                                       for(var24 = 0; var24 < var22; ++var24) {
                                          for(var25 = 0; var25 < var23; ++var25) {
                                             if(var10.field2779 != 0) {
                                                var40.method1753(var20 / 2 + var24 * var20 + var12, var13 + var21 * var25 + var21 / 2, var10.field2779, 4096);
                                             } else if(var14 != 0) {
                                                var40.method1761(var24 * var20 + var12, var21 * var25 + var13, 256 - (var14 & 255));
                                             } else {
                                                var40.method1805(var12 + var20 * var24, var25 * var21 + var13);
                                             }
                                          }
                                       }

                                       class79.method1852(var2, var3, var4, var5);
                                    }
                                 }
                              }
                           } else {
                              class51 var41;
                              if(6 == var10.field2764) {
                                 boolean var39 = class92.method2181(var10);
                                 if(var39) {
                                    var20 = var10.field2789;
                                 } else {
                                    var20 = var10.field2788;
                                 }

                                 class104 var45 = null;
                                 var22 = 0;
                                 if(var10.field2834 != -1) {
                                    var41 = class75.method1648(var10.field2834);
                                    if(var41 != null) {
                                       var41 = var41.method1049(var10.field2862);
                                       var45 = var41.method1048(1);
                                       if(var45 != null) {
                                          var45.method2305();
                                          var22 = var45.field1448 / 2;
                                       } else {
                                          class36.method745(var10);
                                       }
                                    }
                                 } else if(var10.field2784 == 5) {
                                    if(var10.field2846 == 0) {
                                       var45 = client.field378.method3502((class42)null, -1, (class42)null, -1);
                                    } else {
                                       var45 = class151.field2253.vmethod1919();
                                    }
                                 } else if(var20 == -1) {
                                    var45 = var10.method3423((class42)null, -1, var39, class151.field2253.field43);
                                    if(var45 == null && class172.field2769) {
                                       class36.method745(var10);
                                    }
                                 } else {
                                    class42 var48 = class134.method2875(var20);
                                    var45 = var10.method3423(var48, var10.field2808, var39, class151.field2253.field43);
                                    if(var45 == null && class172.field2769) {
                                       class36.method745(var10);
                                    }
                                 }

                                 class90.method2106(var10.field2752 / 2 + var12, var10.field2759 / 2 + var13);
                                 var23 = class90.field1572[var10.field2792] * var10.field2795 >> 16;
                                 var24 = class90.field1578[var10.field2792] * var10.field2795 >> 16;
                                 if(null != var45) {
                                    if(!var10.field2742) {
                                       var45.method2322(0, var10.field2802, 0, var10.field2792, 0, var23, var24);
                                    } else {
                                       var45.method2305();
                                       if(var10.field2817) {
                                          var45.method2323(0, var10.field2802, var10.field2794, var10.field2792, var10.field2790, var22 + var23 + var10.field2793, var10.field2793 + var24, var10.field2795);
                                       } else {
                                          var45.method2322(0, var10.field2802, var10.field2794, var10.field2792, var10.field2790, var10.field2793 + var23 + var22, var24 + var10.field2793);
                                       }
                                    }
                                 }

                                 class90.method2104();
                              } else {
                                 if(var10.field2764 == 7) {
                                    var37 = var10.method3453();
                                    if(var37 == null) {
                                       if(class172.field2769) {
                                          class36.method745(var10);
                                       }
                                       continue;
                                    }

                                    var20 = 0;

                                    for(var21 = 0; var21 < var10.field2755; ++var21) {
                                       for(var22 = 0; var22 < var10.field2783; ++var22) {
                                          if(var10.field2859[var20] > 0) {
                                             var41 = class75.method1648(var10.field2859[var20] - 1);
                                             String var44;
                                             if(var41.field1126 != 1 && var10.field2860[var20] == 1) {
                                                var44 = class51.method1090(16748608) + var41.field1115 + "</col>";
                                             } else {
                                                var44 = class51.method1090(16748608) + var41.field1115 + "</col>" + " " + 'x' + class74.method1639(var10.field2860[var20]);
                                             }

                                             var25 = var22 * (var10.field2807 + 115) + var12;
                                             var26 = (var10.field2805 + 12) * var21 + var13;
                                             if(var10.field2819 == 0) {
                                                var37.method4057(var44, var25, var26, var10.field2768, var10.field2785?0:-1);
                                             } else if(var10.field2819 == 1) {
                                                var37.method4059(var44, var10.field2752 / 2 + var25, var26, var10.field2768, var10.field2785?0:-1);
                                             } else {
                                                var37.method4058(var44, var25 + var10.field2752 - 1, var26, var10.field2768, var10.field2785?0:-1);
                                             }
                                          }

                                          ++var20;
                                       }
                                    }
                                 }

                                 int var27;
                                 if(var10.field2764 == 8 && var10 == class161.field2632 && client.field395 == client.field494) {
                                    var19 = 0;
                                    var20 = 0;
                                    class223 var38 = class72.field1348;
                                    String var42 = var10.field2778;

                                    String var43;
                                    for(var42 = class7.method115(var42, var10); var42.length() > 0; var20 += var38.field3193 + 1) {
                                       var24 = var42.indexOf("<br>");
                                       if(var24 != -1) {
                                          var43 = var42.substring(0, var24);
                                          var42 = var42.substring(var24 + 4);
                                       } else {
                                          var43 = var42;
                                          var42 = "";
                                       }

                                       var25 = var38.method4052(var43);
                                       if(var25 > var19) {
                                          var19 = var25;
                                       }
                                    }

                                    var19 += 6;
                                    var20 += 7;
                                    var24 = var10.field2752 + var12 - 5 - var19;
                                    var25 = var13 + var10.field2759 + 5;
                                    if(var24 < 5 + var12) {
                                       var24 = var12 + 5;
                                    }

                                    if(var24 + var19 > var4) {
                                       var24 = var4 - var19;
                                    }

                                    if(var20 + var25 > var5) {
                                       var25 = var5 - var20;
                                    }

                                    class79.method1830(var24, var25, var19, var20, 16777120);
                                    class79.method1853(var24, var25, var19, var20, 0);
                                    var42 = var10.field2778;
                                    var26 = 2 + var38.field3193 + var25;

                                    for(var42 = class7.method115(var42, var10); var42.length() > 0; var26 += var38.field3193 + 1) {
                                       var27 = var42.indexOf("<br>");
                                       if(var27 != -1) {
                                          var43 = var42.substring(0, var27);
                                          var42 = var42.substring(var27 + 4);
                                       } else {
                                          var43 = var42;
                                          var42 = "";
                                       }

                                       var38.method4057(var43, 3 + var24, var26, 0, -1);
                                    }
                                 }

                                 if(var10.field2764 == 9) {
                                    if(var10.field2804 == 1) {
                                       if(var10.field2775) {
                                          var19 = var12;
                                          var20 = var13 + var10.field2759;
                                          var21 = var10.field2752 + var12;
                                          var22 = var13;
                                       } else {
                                          var19 = var12;
                                          var20 = var13;
                                          var21 = var12 + var10.field2752;
                                          var22 = var13 + var10.field2759;
                                       }

                                       class79.method1838(var19, var20, var21, var22, var10.field2768);
                                    } else {
                                       var19 = var10.field2752 >= 0?var10.field2752:-var10.field2752;
                                       var20 = var10.field2759 >= 0?var10.field2759:-var10.field2759;
                                       var21 = var19;
                                       if(var19 < var20) {
                                          var21 = var20;
                                       }

                                       if(var21 != 0) {
                                          var22 = (var10.field2752 << 16) / var21;
                                          var23 = (var10.field2759 << 16) / var21;
                                          if(var23 <= var22) {
                                             var22 = -var22;
                                          } else {
                                             var23 = -var23;
                                          }

                                          var24 = var23 * var10.field2804 >> 17;
                                          var25 = 1 + var10.field2804 * var23 >> 17;
                                          var26 = var22 * var10.field2804 >> 17;
                                          var27 = 1 + var10.field2804 * var22 >> 17;
                                          int var28 = var12 + var24;
                                          var29 = var12 - var25;
                                          int var30 = var12 + var10.field2752 - var25;
                                          int var31 = var12 + var10.field2752 + var24;
                                          int var32 = var26 + var13;
                                          int var33 = var13 - var27;
                                          int var34 = var13 + var10.field2759 - var27;
                                          int var35 = var10.field2759 + var13 + var26;
                                          class90.method2110(var28, var29, var30);
                                          class90.method2113(var32, var33, var34, var28, var29, var30, var10.field2768);
                                          class90.method2110(var28, var30, var31);
                                          class90.method2113(var32, var34, var35, var28, var30, var31, var10.field2768);
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

   @ObfuscatedName("a")
   static void method3148(class0 var0) {
      class72.method1613(var0, 200000);
   }

   @ObfuscatedName("cj")
   @ObfuscatedSignature(
      signature = "(Lclass2;IIII)V",
      garbageValue = "-2125591980"
   )
   static final void method3149(class2 var0, int var1, int var2, int var3) {
      if(class151.field2253 != var0) {
         if(client.field435 < 400) {
            String var4;
            if(var0.field32 == 0) {
               var4 = var0.field30[0] + var0.field40 + var0.field30[1] + class141.method2997(var0.field31, class151.field2253.field31) + " " + " (" + "level-" + var0.field31 + ")" + var0.field30[2];
            } else {
               var4 = var0.field30[0] + var0.field40 + var0.field30[1] + " " + " (" + "skill-" + var0.field32 + ")" + var0.field30[2];
            }

            int var5;
            if(client.field446 == 1) {
               class212.method3983("Use", client.field447 + " " + "->" + " " + class51.method1090(16777215) + var4, 14, var1, var2, var3);
            } else if(client.field448) {
               if(8 == (class15.field218 & 8)) {
                  class212.method3983(client.field451, client.field452 + " " + "->" + " " + class51.method1090(16777215) + var4, 15, var1, var2, var3);
               }
            } else {
               for(var5 = 7; var5 >= 0; --var5) {
                  if(client.field432[var5] != null) {
                     short var6 = 0;
                     if(client.field432[var5].equalsIgnoreCase("Attack")) {
                        if(class20.field589 == client.field319) {
                           continue;
                        }

                        if(client.field319 == class20.field580 || class20.field583 == client.field319 && var0.field31 > class151.field2253.field31) {
                           var6 = 2000;
                        }

                        if(0 != class151.field2253.field45 && 0 != var0.field45) {
                           if(var0.field45 == class151.field2253.field45) {
                              var6 = 2000;
                           } else {
                              var6 = 0;
                           }
                        }
                     } else if(client.field520[var5]) {
                        var6 = 2000;
                     }

                     boolean var7 = false;
                     int var8 = var6 + client.field525[var5];
                     class212.method3983(client.field432[var5], class51.method1090(16777215) + var4, var8, var1, var2, var3);
                  }
               }
            }

            for(var5 = 0; var5 < client.field435; ++var5) {
               if(23 == client.field302[var5]) {
                  client.field445[var5] = class51.method1090(16777215) + var4;
                  break;
               }
            }

         }
      }
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "5"
   )
   static void method3150() {
      int var0;
      if(client.field321 == 0) {
         class77.field1396 = new class85(4, 104, 104, class5.field86);

         for(var0 = 0; var0 < 4; ++var0) {
            client.field359[var0] = new class107(104, 104);
         }

         class1.field21 = new class78(512, 512);
         class31.field740 = "Starting game engine...";
         class31.field750 = 5;
         client.field321 = 20;
      } else {
         int var1;
         int var2;
         int var3;
         int var4;
         if(20 == client.field321) {
            int[] var28 = new int[9];

            for(var1 = 0; var1 < 9; ++var1) {
               var2 = var1 * 32 + 128 + 15;
               var3 = 3 * var2 + 600;
               var4 = class90.field1572[var2];
               var28[var1] = var4 * var3 >> 16;
            }

            class85.method1994(var28, 500, 800, 512, 334);
            class31.field740 = "Prepared visibility map";
            class31.field750 = 10;
            client.field321 = 30;
         } else if(client.field321 == 30) {
            class27.field672 = class11.method166(0, false, true, true);
            class138.field2129 = class11.method166(1, false, true, true);
            class48.field1079 = class11.method166(2, true, false, true);
            class188.field3040 = class11.method166(3, false, true, true);
            class12.field181 = class11.method166(4, false, true, true);
            class49.field1088 = class11.method166(5, true, true, true);
            class129.field2054 = class11.method166(6, true, true, false);
            class175.field2892 = class11.method166(7, false, true, true);
            class7.field127 = class11.method166(8, false, true, true);
            class1.field18 = class11.method166(9, false, true, true);
            class213.field3146 = class11.method166(10, false, true, true);
            class29.field701 = class11.method166(11, false, true, true);
            class24.field623 = class11.method166(12, false, true, true);
            class77.field1391 = class11.method166(13, true, false, true);
            class124.field2035 = class11.method166(14, false, true, false);
            class20.field588 = class11.method166(15, false, true, true);
            class31.field740 = "Connecting to update server";
            class31.field750 = 20;
            client.field321 = 40;
         } else if(40 == client.field321) {
            byte var27 = 0;
            var0 = var27 + class27.field672.method3374() * 4 / 100;
            var0 += class138.field2129.method3374() * 4 / 100;
            var0 += class48.field1079.method3374() * 2 / 100;
            var0 += class188.field3040.method3374() * 2 / 100;
            var0 += class12.field181.method3374() * 6 / 100;
            var0 += class49.field1088.method3374() * 4 / 100;
            var0 += class129.field2054.method3374() * 2 / 100;
            var0 += class175.field2892.method3374() * 60 / 100;
            var0 += class7.field127.method3374() * 2 / 100;
            var0 += class1.field18.method3374() * 2 / 100;
            var0 += class213.field3146.method3374() * 2 / 100;
            var0 += class29.field701.method3374() * 2 / 100;
            var0 += class24.field623.method3374() * 2 / 100;
            var0 += class77.field1391.method3374() * 2 / 100;
            var0 += class124.field2035.method3374() * 2 / 100;
            var0 += class20.field588.method3374() * 2 / 100;
            if(var0 != 100) {
               if(0 != var0) {
                  class31.field740 = "Checking for updates - " + var0 + "%";
               }

               class31.field750 = 30;
            } else {
               class31.field740 = "Loaded update list";
               class31.field750 = 30;
               client.field321 = 45;
            }
         } else {
            class167 var18;
            class167 var19;
            if(45 == client.field321) {
               boolean var26 = !client.field297;
               class56.field1185 = 22050;
               class56.field1173 = var26;
               class56.field1174 = 2;
               class183 var17 = new class183();
               var17.method3673(9, 128);
               class76.field1380 = class26.method636(class129.field2056, 0, 22050);
               class76.field1380.method1193(var17);
               var18 = class20.field588;
               var19 = class124.field2035;
               class167 var21 = class12.field181;
               class21.field593 = var18;
               class182.field2944 = var19;
               class182.field2943 = var21;
               class182.field2942 = var17;
               class2.field53 = class26.method636(class129.field2056, 1, 2048);
               class40.field973 = new class55();
               class2.field53.method1193(class40.field973);
               class9.field150 = new class74(22050, class56.field1185);
               class31.field740 = "Prepared sound engine";
               class31.field750 = 35;
               client.field321 = 50;
            } else if(client.field321 == 50) {
               var0 = 0;
               if(class95.field1627 == null) {
                  class95.field1627 = class75.method1673(class7.field127, class77.field1391, "p11_full", "");
               } else {
                  ++var0;
               }

               if(null == class72.field1348) {
                  class72.field1348 = class75.method1673(class7.field127, class77.field1391, "p12_full", "");
               } else {
                  ++var0;
               }

               if(class38.field876 == null) {
                  class38.field876 = class75.method1673(class7.field127, class77.field1391, "b12_full", "");
               } else {
                  ++var0;
               }

               if(var0 < 3) {
                  class31.field740 = "Loading fonts - " + var0 * 100 / 3 + "%";
                  class31.field750 = 40;
               } else {
                  class9.field154 = new class159(true);
                  class31.field740 = "Loaded fonts";
                  class31.field750 = 40;
                  client.field321 = 60;
               }
            } else if(client.field321 == 60) {
               var0 = class18.method213(class213.field3146, class7.field127);
               byte var16 = 9;
               if(var0 < var16) {
                  class31.field740 = "Loading title screen - " + 100 * var0 / var16 + "%";
                  class31.field750 = 50;
               } else {
                  class31.field740 = "Loaded title screen";
                  class31.field750 = 50;
                  class1.method9(5);
                  client.field321 = 70;
               }
            } else if(client.field321 == 70) {
               if(!class48.field1079.method3267()) {
                  class31.field740 = "Loading config - " + class48.field1079.method3381() + "%";
                  class31.field750 = 60;
               } else {
                  class167 var25 = class48.field1079;
                  class46.field1059 = var25;
                  class167 var15 = class48.field1079;
                  class41.field975 = var15;
                  class3.method45(class48.field1079, class175.field2892);
                  var18 = class48.field1079;
                  var19 = class175.field2892;
                  boolean var20 = client.field297;
                  class40.field965 = var18;
                  class40.field924 = var19;
                  class40.field940 = var20;
                  class7.method116(class48.field1079, class175.field2892);
                  class167 var22 = class48.field1079;
                  class167 var6 = class175.field2892;
                  boolean var7 = client.field296;
                  class223 var8 = class95.field1627;
                  class51.field1146 = var22;
                  class4.field65 = var6;
                  class51.field1109 = var7;
                  class165.field2655 = class51.field1146.method3273(10);
                  class75.field1374 = var8;
                  class15.method194(class48.field1079, class27.field672, class138.field2129);
                  class172.method3461(class48.field1079, class175.field2892);
                  class0.method1(class48.field1079);
                  class167 var9 = class48.field1079;
                  class52.field1156 = var9;
                  class52.field1157 = class52.field1156.method3273(16);
                  class167 var10 = class188.field3040;
                  class167 var11 = class175.field2892;
                  class167 var12 = class7.field127;
                  class167 var13 = class77.field1391;
                  class172.field2782 = var10;
                  class172.field2735 = var11;
                  class172.field2736 = var12;
                  class124.field2032 = var13;
                  class172.field2850 = new class172[class172.field2782.method3287()][];
                  class172.field2733 = new boolean[class172.field2782.method3287()];
                  class94.method2211(class48.field1079);
                  class13.method182(class48.field1079);
                  class167 var14 = class48.field1079;
                  class45.field1046 = var14;
                  class140.method2987(class48.field1079);
                  class112.field1958 = new class19();
                  class31.field740 = "Loaded config";
                  class31.field750 = 60;
                  client.field321 = 80;
               }
            } else if(client.field321 != 80) {
               if(90 == client.field321) {
                  if(!class1.field18.method3267()) {
                     class31.field740 = "Loading textures - " + class1.field18.method3381() + "%";
                     class31.field750 = 90;
                  } else {
                     class94 var24 = new class94(class1.field18, class7.field127, 20, 0.8D, client.field297?64:128);
                     class90.method2140(var24);
                     class90.method2107(0.8D);
                     class31.field740 = "Loaded textures";
                     class31.field750 = 90;
                     client.field321 = 110;
                  }
               } else if(client.field321 == 110) {
                  class93.field1600 = new class13();
                  class129.field2056.method2893(class93.field1600, 10);
                  class31.field740 = "Loaded input handler";
                  class31.field750 = 94;
                  client.field321 = 120;
               } else if(client.field321 == 120) {
                  if(!class213.field3146.method3281("huffman", "")) {
                     class31.field740 = "Loading wordpack - " + 0 + "%";
                     class31.field750 = 96;
                  } else {
                     class112 var23 = new class112(class213.field3146.method3280("huffman", ""));
                     class221.field3177 = var23;
                     class31.field740 = "Loaded wordpack";
                     class31.field750 = 96;
                     client.field321 = 130;
                  }
               } else if(130 == client.field321) {
                  if(!class188.field3040.method3267()) {
                     class31.field740 = "Loading interfaces - " + class188.field3040.method3381() * 4 / 5 + "%";
                     class31.field750 = 100;
                  } else if(!class24.field623.method3267()) {
                     class31.field740 = "Loading interfaces - " + (80 + class24.field623.method3381() / 6) + "%";
                     class31.field750 = 100;
                  } else if(!class77.field1391.method3267()) {
                     class31.field740 = "Loading interfaces - " + (96 + class77.field1391.method3381() / 20) + "%";
                     class31.field750 = 100;
                  } else {
                     class31.field740 = "Loaded interfaces";
                     class31.field750 = 100;
                     client.field321 = 140;
                  }
               } else if(client.field321 == 140) {
                  class1.method9(10);
               }
            } else {
               var0 = 0;
               if(null == class149.field2236) {
                  class149.field2236 = class0.method0(class7.field127, "compass", "");
               } else {
                  ++var0;
               }

               if(null == class19.field279) {
                  class19.field279 = class0.method0(class7.field127, "mapedge", "");
               } else {
                  ++var0;
               }

               if(null == class27.field676) {
                  class27.field676 = class30.method664(class7.field127, "mapscene", "");
               } else {
                  ++var0;
               }

               if(null == class121.field2000) {
                  class121.field2000 = class74.method1637(class7.field127, "mapfunction", "");
               } else {
                  ++var0;
               }

               if(client.field545 == null) {
                  client.field545 = class74.method1637(class7.field127, "hitmarks", "");
               } else {
                  ++var0;
               }

               if(class15.field216 == null) {
                  class15.field216 = class74.method1637(class7.field127, "headicons_pk", "");
               } else {
                  ++var0;
               }

               if(null == class34.field787) {
                  class34.field787 = class74.method1637(class7.field127, "headicons_prayer", "");
               } else {
                  ++var0;
               }

               if(client.field370 == null) {
                  client.field370 = class74.method1637(class7.field127, "headicons_hint", "");
               } else {
                  ++var0;
               }

               if(client.field371 == null) {
                  client.field371 = class74.method1637(class7.field127, "mapmarker", "");
               } else {
                  ++var0;
               }

               if(null == class14.field206) {
                  class14.field206 = class74.method1637(class7.field127, "cross", "");
               } else {
                  ++var0;
               }

               if(class26.field665 == null) {
                  class26.field665 = class74.method1637(class7.field127, "mapdots", "");
               } else {
                  ++var0;
               }

               if(null == class220.field3174) {
                  class220.field3174 = class30.method664(class7.field127, "scrollbar", "");
               } else {
                  ++var0;
               }

               if(class31.field739 == null) {
                  class31.field739 = class30.method664(class7.field127, "mod_icons", "");
               } else {
                  ++var0;
               }

               if(var0 < 13) {
                  class31.field740 = "Loading sprites - " + var0 * 100 / 13 + "%";
                  class31.field750 = 70;
               } else {
                  class222.field3187 = class31.field739;
                  class19.field279.method1732();
                  var1 = (int)(Math.random() * 21.0D) - 10;
                  var2 = (int)(Math.random() * 21.0D) - 10;
                  var3 = (int)(Math.random() * 21.0D) - 10;
                  var4 = (int)(Math.random() * 41.0D) - 20;

                  for(int var5 = 0; var5 < class121.field2000.length; ++var5) {
                     class121.field2000[var5].method1731(var1 + var4, var4 + var2, var3 + var4);
                  }

                  class27.field676[0].method1882(var1 + var4, var2 + var4, var4 + var3);
                  class31.field740 = "Loaded sprites";
                  class31.field750 = 70;
                  client.field321 = 90;
               }
            }
         }
      }
   }
}
