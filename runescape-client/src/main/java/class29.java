import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("au")
public final class class29 extends class85 {
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -390803557
   )
   int field687;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -1534737275
   )
   int field688;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -1707028939
   )
   int field689;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -2105132445
   )
   int field691;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 681527549
   )
   int field692;
   @ObfuscatedName("o")
   class42 field693;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -620101149
   )
   int field695 = 0;
   @ObfuscatedName("c")
   boolean field696 = false;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -2120189379
   )
   int field698;
   @ObfuscatedName("qf")
   @ObfuscatedGetter(
      intValue = -1355069907
   )
   static int field700;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 1379189439
   )
   int field701 = 0;

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1782149649"
   )
   final void method638(int var1) {
      if(!this.field696) {
         this.field695 += var1;

         while(this.field695 > this.field693.field999[this.field701]) {
            this.field695 -= this.field693.field999[this.field701];
            ++this.field701;
            if(this.field701 >= this.field693.field986.length) {
               this.field696 = true;
               break;
            }
         }
      }

   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(B)Lclass105;",
      garbageValue = "1"
   )
   protected final class105 vmethod1888() {
      class43 var1 = class179.method3492(this.field698);
      class105 var2;
      if(!this.field696) {
         var2 = var1.method879(this.field701);
      } else {
         var2 = var1.method879(-1);
      }

      return var2 == null?null:var2;
   }

   @ObfuscatedName("cw")
   @ObfuscatedSignature(
      signature = "([Lclass173;IIIIIIIIB)V",
      garbageValue = "33"
   )
   @Export("gameDraw")
   static final void method642(class173[] var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
      class79.method1767(var2, var3, var4, var5);
      class91.method2070();

      for(int var9 = 0; var9 < var0.length; ++var9) {
         class173 var10 = var0[var9];
         if(null != var10 && (var1 == var10.field2784 || -1412584499 == var1 && var10 == client.field450)) {
            int var11;
            if(-1 == var8) {
               client.field485[client.field480] = var6 + var10.field2768;
               client.field486[client.field480] = var10.field2779 + var7;
               client.field477[client.field480] = var10.field2886;
               client.field488[client.field480] = var10.field2781;
               var11 = ++client.field480 - 1;
            } else {
               var11 = var8;
            }

            var10.field2896 = var11;
            var10.field2897 = client.field335;
            if(!var10.field2764 || !class85.method1892(var10)) {
               int var12;
               if(var10.field2887 > 0) {
                  var12 = var10.field2887;
                  if(var12 == 324) {
                     if(-1 == client.field553) {
                        client.field553 = var10.field2890;
                        client.field419 = var10.field2801;
                     }

                     if(client.field350.field2936) {
                        var10.field2890 = client.field553;
                     } else {
                        var10.field2890 = client.field419;
                     }
                  } else if(var12 == 325) {
                     if(-1 == client.field553) {
                        client.field553 = var10.field2890;
                        client.field419 = var10.field2801;
                     }

                     if(client.field350.field2936) {
                        var10.field2890 = client.field419;
                     } else {
                        var10.field2890 = client.field553;
                     }
                  } else if(var12 == 327) {
                     var10.field2816 = 150;
                     var10.field2817 = (int)(Math.sin((double)client.field335 / 40.0D) * 256.0D) & 2047;
                     var10.field2788 = 5;
                     var10.field2830 = 0;
                  } else if(var12 == 328) {
                     var10.field2816 = 150;
                     var10.field2817 = (int)(Math.sin((double)client.field335 / 40.0D) * 256.0D) & 2047;
                     var10.field2788 = 5;
                     var10.field2830 = 1;
                  }
               }

               var12 = var10.field2768 + var6;
               int var13 = var10.field2779 + var7;
               int var14 = var10.field2796;
               int var15;
               int var16;
               if(client.field450 == var10) {
                  if(var1 != -1412584499 && !var10.field2856) {
                     class99.field1689 = var0;
                     class154.field2291 = var6;
                     class25.field630 = var7;
                     continue;
                  }

                  if(client.field461 && client.field455) {
                     var15 = class140.field2162;
                     var16 = class140.field2163;
                     var15 -= client.field452;
                     var16 -= client.field453;
                     if(var15 < client.field456) {
                        var15 = client.field456;
                     }

                     if(var10.field2886 + var15 > client.field288.field2886 + client.field456) {
                        var15 = client.field456 + client.field288.field2886 - var10.field2886;
                     }

                     if(var16 < client.field457) {
                        var16 = client.field457;
                     }

                     if(var16 + var10.field2781 > client.field288.field2781 + client.field457) {
                        var16 = client.field457 + client.field288.field2781 - var10.field2781;
                     }

                     var12 = var15;
                     var13 = var16;
                  }

                  if(!var10.field2856) {
                     var14 = 128;
                  }
               }

               int var17;
               int var18;
               int var19;
               int var20;
               int var21;
               int var22;
               if(var10.field2767 == 2) {
                  var15 = var2;
                  var16 = var3;
                  var17 = var4;
                  var18 = var5;
               } else if(9 == var10.field2767) {
                  var19 = var12;
                  var20 = var13;
                  var21 = var12 + var10.field2886;
                  var22 = var10.field2781 + var13;
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
                  var19 = var12 + var10.field2886;
                  var20 = var13 + var10.field2781;
                  var15 = var12 > var2?var12:var2;
                  var16 = var13 > var3?var13:var3;
                  var17 = var19 < var4?var19:var4;
                  var18 = var20 < var5?var20:var5;
               }

               if(!var10.field2764 || var15 < var17 && var16 < var18) {
                  int var23;
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
                  boolean var43;
                  if(0 != var10.field2887) {
                     if(1336 == var10.field2887) {
                        if(client.field282) {
                           var13 += 15;
                           class181.field2945.method4003("Fps:" + class144.field2207, var12 + var10.field2886, var13, 16776960, -1);
                           var13 += 15;
                           Runtime var47 = Runtime.getRuntime();
                           var20 = (int)((var47.totalMemory() - var47.freeMemory()) / 1024L);
                           var21 = 16776960;
                           if(var20 > '耀' && client.field493) {
                              var21 = 16711680;
                           }

                           if(var20 > 65536 && !client.field493) {
                              var21 = 16711680;
                           }

                           class181.field2945.method4003("Mem:" + var20 + "k", var10.field2886 + var12, var13, var21, -1);
                           var13 += 15;
                        }
                        continue;
                     }

                     int[] var63;
                     if(var10.field2887 == 1337) {
                        client.field426 = var12;
                        client.field443 = var13;
                        var21 = var10.field2886;
                        var22 = var10.field2781;
                        ++client.field275;
                        class56.method1204(class33.field773);
                        var43 = false;
                        if(client.field409 >= 0) {
                           var24 = class32.field755;
                           var63 = class32.field756;

                           for(var26 = 0; var26 < var24; ++var26) {
                              if(client.field409 == var63[var26]) {
                                 var43 = true;
                                 break;
                              }
                           }
                        }

                        if(var43) {
                           class56.method1204(class33.field774);
                        }

                        class11.method138(true);
                        class56.method1204(var43?class33.field778:class33.field771);
                        class11.method138(false);
                        class101.method2266();
                        class5.method87();
                        class11.method137(var12, var13, var21, var22, true);
                        var19 = client.field398;
                        var20 = client.field542;
                        var21 = client.field472;
                        var22 = client.field383;
                        class79.method1767(var19, var20, var19 + var21, var20 + var22);
                        class91.method2070();
                        if(!client.field558) {
                           var24 = client.field363;
                           if(client.field372 / 256 > var24) {
                              var24 = client.field372 / 256;
                           }

                           if(client.field528[4] && 128 + client.field423[4] > var24) {
                              var24 = client.field423[4] + 128;
                           }

                           var25 = client.field364 + client.field348 & 2047;
                           var26 = class17.field236;
                           var27 = class107.method2369(class106.field1881.field823, class106.field1881.field813, class21.field581) - client.field369;
                           var28 = class160.field2646;
                           var29 = var24 * 3 + 600;
                           var30 = 2048 - var24 & 2047;
                           var31 = 2048 - var25 & 2047;
                           var32 = 0;
                           var33 = 0;
                           var34 = var29;
                           int var64;
                           int var66;
                           if(0 != var30) {
                              var35 = class91.field1596[var30];
                              var66 = class91.field1597[var30];
                              var64 = var66 * var33 - var29 * var35 >> 16;
                              var34 = var66 * var29 + var35 * var33 >> 16;
                              var33 = var64;
                           }

                           if(var31 != 0) {
                              var35 = class91.field1596[var31];
                              var66 = class91.field1597[var31];
                              var64 = var34 * var35 + var66 * var32 >> 16;
                              var34 = var66 * var34 - var35 * var32 >> 16;
                              var32 = var64;
                           }

                           class77.field1404 = var26 - var32;
                           class7.field138 = var27 - var33;
                           class72.field1353 = var28 - var34;
                           class59.field1222 = var24;
                           class32.field750 = var25;
                        }

                        if(!client.field558) {
                           if(class76.field1388.field148) {
                              var25 = class21.field581;
                           } else {
                              label1235: {
                                 var26 = 3;
                                 if(class59.field1222 < 310) {
                                    var27 = class77.field1404 >> 7;
                                    var28 = class72.field1353 >> 7;
                                    var29 = class106.field1881.field823 >> 7;
                                    var30 = class106.field1881.field813 >> 7;
                                    if(var27 < 0 || var28 < 0 || var27 >= 104 || var28 >= 104) {
                                       var25 = class21.field581;
                                       break label1235;
                                    }

                                    if(0 != (class5.field90[class21.field581][var27][var28] & 4)) {
                                       var26 = class21.field581;
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

                                       while(var29 != var27) {
                                          if(var27 < var29) {
                                             ++var27;
                                          } else if(var27 > var29) {
                                             --var27;
                                          }

                                          if(0 != (class5.field90[class21.field581][var27][var28] & 4)) {
                                             var26 = class21.field581;
                                          }

                                          var34 += var33;
                                          if(var34 >= 65536) {
                                             var34 -= 65536;
                                             if(var28 < var30) {
                                                ++var28;
                                             } else if(var28 > var30) {
                                                --var28;
                                             }

                                             if(0 != (class5.field90[class21.field581][var27][var28] & 4)) {
                                                var26 = class21.field581;
                                             }
                                          }
                                       }
                                    } else {
                                       var33 = 65536 * var31 / var32;
                                       var34 = '耀';

                                       while(var30 != var28) {
                                          if(var28 < var30) {
                                             ++var28;
                                          } else if(var28 > var30) {
                                             --var28;
                                          }

                                          if((class5.field90[class21.field581][var27][var28] & 4) != 0) {
                                             var26 = class21.field581;
                                          }

                                          var34 += var33;
                                          if(var34 >= 65536) {
                                             var34 -= 65536;
                                             if(var27 < var29) {
                                                ++var27;
                                             } else if(var27 > var29) {
                                                --var27;
                                             }

                                             if((class5.field90[class21.field581][var27][var28] & 4) != 0) {
                                                var26 = class21.field581;
                                             }
                                          }
                                       }
                                    }
                                 }

                                 if(class106.field1881.field823 >= 0 && class106.field1881.field813 >= 0 && class106.field1881.field823 < 13312 && class106.field1881.field813 < 13312) {
                                    if(0 != (class5.field90[class21.field581][class106.field1881.field823 >> 7][class106.field1881.field813 >> 7] & 4)) {
                                       var26 = class21.field581;
                                    }

                                    var25 = var26;
                                 } else {
                                    var25 = class21.field581;
                                 }
                              }
                           }

                           var24 = var25;
                        } else {
                           if(class76.field1388.field148) {
                              var25 = class21.field581;
                           } else {
                              var26 = class107.method2369(class77.field1404, class72.field1353, class21.field581);
                              if(var26 - class7.field138 < 800 && (class5.field90[class21.field581][class77.field1404 >> 7][class72.field1353 >> 7] & 4) != 0) {
                                 var25 = class21.field581;
                              } else {
                                 var25 = 3;
                              }
                           }

                           var24 = var25;
                        }

                        var25 = class77.field1404;
                        var26 = class7.field138;
                        var27 = class72.field1353;
                        var28 = class59.field1222;
                        var29 = class32.field750;

                        for(var30 = 0; var30 < 5; ++var30) {
                           if(client.field528[var30]) {
                              var31 = (int)(Math.random() * (double)(2 * client.field529[var30] + 1) - (double)client.field529[var30] + Math.sin((double)client.field532[var30] * ((double)client.field337[var30] / 100.0D)) * (double)client.field423[var30]);
                              if(0 == var30) {
                                 class77.field1404 += var31;
                              }

                              if(var30 == 1) {
                                 class7.field138 += var31;
                              }

                              if(var30 == 2) {
                                 class72.field1353 += var31;
                              }

                              if(3 == var30) {
                                 class32.field750 = var31 + class32.field750 & 2047;
                              }

                              if(4 == var30) {
                                 class59.field1222 += var31;
                                 if(class59.field1222 < 128) {
                                    class59.field1222 = 128;
                                 }

                                 if(class59.field1222 > 383) {
                                    class59.field1222 = 383;
                                 }
                              }
                           }
                        }

                        var30 = class140.field2162;
                        var31 = class140.field2163;
                        if(0 != class140.field2159) {
                           var30 = class140.field2169;
                           var31 = class140.field2170;
                        }

                        if(var30 >= var19 && var30 < var21 + var19 && var31 >= var20 && var31 < var20 + var22) {
                           class105.field1863 = true;
                           class105.field1808 = 0;
                           class105.field1864 = var30 - var19;
                           class105.field1865 = var31 - var20;
                        } else {
                           class105.field1863 = false;
                           class105.field1808 = 0;
                        }

                        class31.method677();
                        class79.method1808(var19, var20, var21, var22, 0);
                        class31.method677();
                        var32 = class91.field1587;
                        class91.field1587 = client.field555;
                        client.field339.method1920(class77.field1404, class7.field138, class72.field1353, class59.field1222, class32.field750, var24);
                        class91.field1587 = var32;
                        class31.method677();
                        client.field339.method1909();
                        class41.method834(var19, var20, var21, var22);
                        if(client.field476 == 2) {
                           class102.method2270((client.field299 - class22.field594 << 7) + client.field302, client.field303 + (client.field543 - class114.field1981 << 7), client.field547 * 2);
                           if(client.field385 > -1 && client.field335 % 20 < 10) {
                              class39.field919[0].method1676(client.field385 + var19 - 12, var20 + client.field386 - 28);
                           }
                        }

                        ((class95)class91.field1593).method2154(client.field356);
                        class98.method2177(var19, var20, var21, var22);
                        class77.field1404 = var25;
                        class7.field138 = var26;
                        class72.field1353 = var27;
                        class59.field1222 = var28;
                        class32.field750 = var29;
                        if(client.field287) {
                           byte var68 = 0;
                           var34 = var68 + class171.field2732 + class171.field2730;
                           if(var34 == 0) {
                              client.field287 = false;
                           }
                        }

                        if(client.field287) {
                           class79.method1808(var19, var20, var21, var22, 0);
                           class153.method3132("Loading - please wait.", false);
                        }

                        client.field482[var10.field2896] = true;
                        class79.method1767(var2, var3, var4, var5);
                        continue;
                     }

                     class175 var45;
                     if(1338 == var10.field2887) {
                        class31.method677();
                        var45 = var10.method3404(false);
                        if(null != var45) {
                           class79.method1767(var12, var13, var45.field2914 + var12, var13 + var45.field2909);
                           if(2 != client.field293 && 5 != client.field293) {
                              var20 = client.field364 + client.field410 & 2047;
                              var21 = 48 + class106.field1881.field823 / 32;
                              var22 = 464 - class106.field1881.field813 / 32;
                              class74.field1370.method1687(var12, var13, var45.field2914, var45.field2909, var21, var22, var20, client.field353 + 256, var45.field2911, var45.field2910);

                              for(var23 = 0; var23 < client.field508; ++var23) {
                                 var24 = 4 * client.field509[var23] + 2 - class106.field1881.field823 / 32;
                                 var25 = 2 + client.field522[var23] * 4 - class106.field1881.field813 / 32;
                                 class13.method164(var12, var13, var24, var25, client.field511[var23], var45);
                              }

                              var23 = 0;

                              while(true) {
                                 if(var23 >= 104) {
                                    for(var23 = 0; var23 < client.field317; ++var23) {
                                       class34 var61 = client.field515[client.field318[var23]];
                                       if(var61 != null && var61.vmethod727()) {
                                          class39 var55 = var61.field782;
                                          if(null != var55 && null != var55.field921) {
                                             var55 = var55.method740();
                                          }

                                          if(null != var55 && var55.field903 && var55.field915) {
                                             var26 = var61.field823 / 32 - class106.field1881.field823 / 32;
                                             var27 = var61.field813 / 32 - class106.field1881.field813 / 32;
                                             class13.method164(var12, var13, var26, var27, class138.field2146[1], var45);
                                          }
                                       }
                                    }

                                    var23 = class32.field755;
                                    var63 = class32.field756;

                                    class2 var60;
                                    for(var25 = 0; var25 < var23; ++var25) {
                                       var60 = client.field491[var63[var25]];
                                       if(null != var60 && var60.vmethod727() && !var60.field58 && var60 != class106.field1881) {
                                          var27 = var60.field823 / 32 - class106.field1881.field823 / 32;
                                          var28 = var60.field813 / 32 - class106.field1881.field813 / 32;
                                          boolean var67 = false;
                                          if(class19.method241(var60.field59, true)) {
                                             var67 = true;
                                          }

                                          boolean var57 = false;

                                          for(var31 = 0; var31 < class110.field1959; ++var31) {
                                             if(var60.field59.equals(class159.field2612[var31].field616)) {
                                                var57 = true;
                                                break;
                                             }
                                          }

                                          boolean var41 = false;
                                          if(class106.field1881.field53 != 0 && 0 != var60.field53 && var60.field53 == class106.field1881.field53) {
                                             var41 = true;
                                          }

                                          if(var67) {
                                             class13.method164(var12, var13, var27, var28, class138.field2146[3], var45);
                                          } else if(var41) {
                                             class13.method164(var12, var13, var27, var28, class138.field2146[4], var45);
                                          } else if(var57) {
                                             class13.method164(var12, var13, var27, var28, class138.field2146[5], var45);
                                          } else {
                                             class13.method164(var12, var13, var27, var28, class138.field2146[2], var45);
                                          }
                                       }
                                    }

                                    if(client.field476 != 0 && client.field335 % 20 < 10) {
                                       if(client.field476 == 1 && client.field297 >= 0 && client.field297 < client.field515.length) {
                                          class34 var62 = client.field515[client.field297];
                                          if(var62 != null) {
                                             var26 = var62.field823 / 32 - class106.field1881.field823 / 32;
                                             var27 = var62.field813 / 32 - class106.field1881.field813 / 32;
                                             class41.method833(var12, var13, var26, var27, class90.field1570[1], var45);
                                          }
                                       }

                                       if(2 == client.field476) {
                                          var25 = client.field299 * 4 - class22.field594 * 4 + 2 - class106.field1881.field823 / 32;
                                          var26 = client.field543 * 4 - class114.field1981 * 4 + 2 - class106.field1881.field813 / 32;
                                          class41.method833(var12, var13, var25, var26, class90.field1570[1], var45);
                                       }

                                       if(client.field476 == 10 && client.field298 >= 0 && client.field298 < client.field491.length) {
                                          var60 = client.field491[client.field298];
                                          if(null != var60) {
                                             var26 = var60.field823 / 32 - class106.field1881.field823 / 32;
                                             var27 = var60.field813 / 32 - class106.field1881.field813 / 32;
                                             class41.method833(var12, var13, var26, var27, class90.field1570[1], var45);
                                          }
                                       }
                                    }

                                    if(0 != client.field512) {
                                       var25 = 2 + client.field512 * 4 - class106.field1881.field823 / 32;
                                       var26 = 2 + client.field513 * 4 - class106.field1881.field813 / 32;
                                       class13.method164(var12, var13, var25, var26, class90.field1570[0], var45);
                                    }

                                    if(!class106.field1881.field58) {
                                       class79.method1808(var45.field2914 / 2 + var12 - 1, var13 + var45.field2909 / 2 - 1, 3, 3, 16777215);
                                    }
                                    break;
                                 }

                                 for(var24 = 0; var24 < 104; ++var24) {
                                    class199 var59 = client.field345[class21.field581][var23][var24];
                                    if(var59 != null) {
                                       var26 = var23 * 4 + 2 - class106.field1881.field823 / 32;
                                       var27 = 2 + var24 * 4 - class106.field1881.field813 / 32;
                                       class13.method164(var12, var13, var26, var27, class138.field2146[0], var45);
                                    }
                                 }

                                 ++var23;
                              }
                           } else {
                              class79.method1786(var12, var13, 0, var45.field2911, var45.field2910);
                           }

                           client.field483[var11] = true;
                        }

                        class79.method1767(var2, var3, var4, var5);
                        continue;
                     }

                     if(var10.field2887 == 1339) {
                        var45 = var10.method3404(false);
                        if(null != var45) {
                           if(client.field293 < 3) {
                              class99.field1691.method1687(var12, var13, var45.field2914, var45.field2909, 25, 25, client.field364, 256, var45.field2911, var45.field2910);
                           } else {
                              class79.method1786(var12, var13, 0, var45.field2911, var45.field2910);
                           }
                        }

                        class79.method1767(var2, var3, var4, var5);
                        continue;
                     }
                  }

                  if(var10.field2767 == 0) {
                     if(!var10.field2764 && class85.method1892(var10) && class4.field78 != var10) {
                        continue;
                     }

                     if(!var10.field2764) {
                        if(var10.field2787 > var10.field2858 - var10.field2781) {
                           var10.field2787 = var10.field2858 - var10.field2781;
                        }

                        if(var10.field2787 < 0) {
                           var10.field2787 = 0;
                        }
                     }

                     method642(var0, var10.field2826, var15, var16, var17, var18, var12 - var10.field2786, var13 - var10.field2787, var11);
                     if(null != var10.field2847) {
                        method642(var10.field2847, var10.field2826, var15, var16, var17, var18, var12 - var10.field2786, var13 - var10.field2787, var11);
                     }

                     class3 var36 = (class3)client.field308.method3777((long)var10.field2826);
                     if(null != var36) {
                        class59.method1241(var36.field69, var15, var16, var17, var18, var12, var13, var11);
                     }

                     class79.method1767(var2, var3, var4, var5);
                     class91.method2070();
                  }

                  if(client.field336 || client.field368[var11] || client.field506 > 1) {
                     if(var10.field2767 == 0 && !var10.field2764 && var10.field2858 > var10.field2781) {
                        var19 = var12 + var10.field2886;
                        var20 = var10.field2787;
                        var21 = var10.field2781;
                        var22 = var10.field2858;
                        class151.field2270[0].method1841(var19, var13);
                        class151.field2270[1].method1841(var19, var13 + var21 - 16);
                        class79.method1808(var19, var13 + 16, 16, var21 - 32, client.field357);
                        var23 = var21 * (var21 - 32) / var22;
                        if(var23 < 8) {
                           var23 = 8;
                        }

                        var24 = (var21 - 32 - var23) * var20 / (var22 - var21);
                        class79.method1808(var19, var24 + 16 + var13, 16, var23, client.field531);
                        class79.method1796(var19, 16 + var13 + var24, var23, client.field527);
                        class79.method1796(var19 + 1, 16 + var13 + var24, var23, client.field527);
                        class79.method1781(var19, var13 + 16 + var24, 16, client.field527);
                        class79.method1781(var19, 17 + var13 + var24, 16, client.field527);
                        class79.method1796(var19 + 15, var13 + 16 + var24, var23, client.field327);
                        class79.method1796(14 + var19, var13 + 17 + var24, var23 - 1, client.field327);
                        class79.method1781(var19, var23 + var13 + 15 + var24, 16, client.field327);
                        class79.method1781(1 + var19, var13 + 14 + var24 + var23, 15, client.field327);
                     }

                     if(var10.field2767 != 1) {
                        if(var10.field2767 == 2) {
                           var19 = 0;

                           for(var20 = 0; var20 < var10.field2777; ++var20) {
                              for(var21 = 0; var21 < var10.field2776; ++var21) {
                                 var22 = var12 + (32 + var10.field2831) * var21;
                                 var23 = var13 + var20 * (32 + var10.field2832);
                                 if(var19 < 20) {
                                    var22 += var10.field2835[var19];
                                    var23 += var10.field2876[var19];
                                 }

                                 if(var10.field2883[var19] <= 0) {
                                    if(null != var10.field2861 && var19 < 20) {
                                       class78 var44 = var10.method3374(var19);
                                       if(var44 != null) {
                                          var44.method1676(var22, var23);
                                       } else if(class173.field2866) {
                                          class34.method701(var10);
                                       }
                                    }
                                 } else {
                                    var43 = false;
                                    boolean var58 = false;
                                    var26 = var10.field2883[var19] - 1;
                                    if(32 + var22 > var2 && var22 < var4 && 32 + var23 > var3 && var23 < var5 || var10 == class25.field626 && client.field359 == var19) {
                                       class78 var53;
                                       if(client.field430 == 1 && var19 == class162.field2657 && class209.field3127 == var10.field2826) {
                                          var53 = class3.method33(var26, var10.field2884[var19], 2, 0, 2, false);
                                       } else {
                                          var53 = class3.method33(var26, var10.field2884[var19], 1, 3153952, 2, false);
                                       }

                                       if(null != var53) {
                                          if(class25.field626 == var10 && client.field359 == var19) {
                                             var24 = class140.field2162 - client.field394;
                                             var25 = class140.field2163 - client.field395;
                                             if(var24 < 5 && var24 > -5) {
                                                var24 = 0;
                                             }

                                             if(var25 < 5 && var25 > -5) {
                                                var25 = 0;
                                             }

                                             if(client.field417 < 5) {
                                                var24 = 0;
                                                var25 = 0;
                                             }

                                             var53.method1697(var22 + var24, var23 + var25, 128);
                                             if(-1 != var1) {
                                                class173 var65 = var0[var1 & '\uffff'];
                                                if(var23 + var25 < class79.field1423 && var65.field2787 > 0) {
                                                   var29 = (class79.field1423 - var23 - var25) * client.field356 / 3;
                                                   if(var29 > client.field356 * 10) {
                                                      var29 = client.field356 * 10;
                                                   }

                                                   if(var29 > var65.field2787) {
                                                      var29 = var65.field2787;
                                                   }

                                                   var65.field2787 -= var29;
                                                   client.field395 += var29;
                                                   class34.method701(var65);
                                                }

                                                if(32 + var25 + var23 > class79.field1421 && var65.field2787 < var65.field2858 - var65.field2781) {
                                                   var29 = client.field356 * (var25 + var23 + 32 - class79.field1421) / 3;
                                                   if(var29 > client.field356 * 10) {
                                                      var29 = client.field356 * 10;
                                                   }

                                                   if(var29 > var65.field2858 - var65.field2781 - var65.field2787) {
                                                      var29 = var65.field2858 - var65.field2781 - var65.field2787;
                                                   }

                                                   var65.field2787 += var29;
                                                   client.field395 -= var29;
                                                   class34.method701(var65);
                                                }
                                             }
                                          } else if(class19.field274 == var10 && client.field406 == var19) {
                                             var53.method1697(var22, var23, 128);
                                          } else {
                                             var53.method1676(var22, var23);
                                          }
                                       } else {
                                          class34.method701(var10);
                                       }
                                    }
                                 }

                                 ++var19;
                              }
                           }
                        } else if(var10.field2767 == 3) {
                           if(class127.method2809(var10)) {
                              var19 = var10.field2791;
                              if(var10 == class4.field78 && 0 != var10.field2797) {
                                 var19 = var10.field2797;
                              }
                           } else {
                              var19 = var10.field2790;
                              if(var10 == class4.field78 && var10.field2827 != 0) {
                                 var19 = var10.field2827;
                              }
                           }

                           if(var10.field2794) {
                              switch(var10.field2795.field1439) {
                              case 1:
                                 class79.method1778(var12, var13, var10.field2886, var10.field2781, var10.field2790, var10.field2791, 256 - (var10.field2796 & 255), 256 - (var10.field2833 & 255));
                                 break;
                              case 2:
                                 class79.method1775(var12, var13, var10.field2886, var10.field2781, var10.field2790, var10.field2791, 256 - (var10.field2796 & 255), 256 - (var10.field2833 & 255));
                                 break;
                              case 3:
                                 class79.method1773(var12, var13, var10.field2886, var10.field2781, var10.field2790, var10.field2791, 256 - (var10.field2796 & 255), 256 - (var10.field2833 & 255));
                                 break;
                              case 4:
                                 class79.method1777(var12, var13, var10.field2886, var10.field2781, var10.field2790, var10.field2791, 256 - (var10.field2796 & 255), 256 - (var10.field2833 & 255));
                                 break;
                              default:
                                 if(0 == var14) {
                                    class79.method1808(var12, var13, var10.field2886, var10.field2781, var19);
                                 } else {
                                    class79.method1772(var12, var13, var10.field2886, var10.field2781, var19, 256 - (var14 & 255));
                                 }
                              }
                           } else if(var14 == 0) {
                              class79.method1779(var12, var13, var10.field2886, var10.field2781, var19);
                           } else {
                              class79.method1780(var12, var13, var10.field2886, var10.field2781, var19, 256 - (var14 & 255));
                           }
                        } else {
                           class224 var42;
                           if(var10.field2767 == 4) {
                              var42 = var10.method3410();
                              if(var42 == null) {
                                 if(class173.field2866) {
                                    class34.method701(var10);
                                 }
                              } else {
                                 String var48 = var10.field2825;
                                 if(class127.method2809(var10)) {
                                    var20 = var10.field2791;
                                    if(var10 == class4.field78 && 0 != var10.field2797) {
                                       var20 = var10.field2797;
                                    }

                                    if(var10.field2778.length() > 0) {
                                       var48 = var10.field2778;
                                    }
                                 } else {
                                    var20 = var10.field2790;
                                    if(var10 == class4.field78 && 0 != var10.field2827) {
                                       var20 = var10.field2827;
                                    }
                                 }

                                 if(var10.field2764 && -1 != var10.field2885) {
                                    class51 var51 = class9.method128(var10.field2885);
                                    var48 = var51.field1128;
                                    if(var48 == null) {
                                       var48 = "null";
                                    }

                                    if((var51.field1127 == 1 || 1 != var10.field2780) && -1 != var10.field2780) {
                                       var48 = class12.method163(16748608) + var48 + "</col>" + " " + 'x' + class109.method2413(var10.field2780);
                                    }
                                 }

                                 if(var10 == client.field441) {
                                    class157 var52 = (class157)null;
                                    var48 = "Please wait...";
                                    var20 = var10.field2790;
                                 }

                                 if(!var10.field2764) {
                                    var48 = client.method544(var48, var10);
                                 }

                                 var42.method4005(var48, var12, var13, var10.field2886, var10.field2781, var20, var10.field2769?0:-1, var10.field2828, var10.field2829, var10.field2899);
                              }
                           } else if(5 == var10.field2767) {
                              class78 var46;
                              if(!var10.field2764) {
                                 var46 = var10.method3372(class127.method2809(var10));
                                 if(var46 != null) {
                                    var46.method1676(var12, var13);
                                 } else if(class173.field2866) {
                                    class34.method701(var10);
                                 }
                              } else {
                                 if(-1 != var10.field2885) {
                                    var46 = class3.method33(var10.field2885, var10.field2780, var10.field2804, var10.field2805, var10.field2823, false);
                                 } else {
                                    var46 = var10.method3372(false);
                                 }

                                 if(var46 == null) {
                                    if(class173.field2866) {
                                       class34.method701(var10);
                                    }
                                 } else {
                                    var20 = var46.field1416;
                                    var21 = var46.field1412;
                                    if(!var10.field2803) {
                                       var22 = var10.field2886 * 4096 / var20;
                                       if(var10.field2802 != 0) {
                                          var46.method1689(var10.field2886 / 2 + var12, var10.field2781 / 2 + var13, var10.field2802, var22);
                                       } else if(var14 != 0) {
                                          var46.method1695(var12, var13, var10.field2886, var10.field2781, 256 - (var14 & 255));
                                       } else if(var10.field2886 == var20 && var10.field2781 == var21) {
                                          var46.method1676(var12, var13);
                                       } else {
                                          var46.method1675(var12, var13, var10.field2886, var10.field2781);
                                       }
                                    } else {
                                       class79.method1768(var12, var13, var12 + var10.field2886, var13 + var10.field2781);
                                       var22 = (var20 - 1 + var10.field2886) / var20;
                                       var23 = (var10.field2781 + (var21 - 1)) / var21;

                                       for(var24 = 0; var24 < var22; ++var24) {
                                          for(var25 = 0; var25 < var23; ++var25) {
                                             if(0 != var10.field2802) {
                                                var46.method1689(var20 / 2 + var12 + var24 * var20, var21 / 2 + var21 * var25 + var13, var10.field2802, 4096);
                                             } else if(var14 != 0) {
                                                var46.method1697(var12 + var20 * var24, var25 * var21 + var13, 256 - (var14 & 255));
                                             } else {
                                                var46.method1676(var20 * var24 + var12, var21 * var25 + var13);
                                             }
                                          }
                                       }

                                       class79.method1767(var2, var3, var4, var5);
                                    }
                                 }
                              }
                           } else {
                              class51 var37;
                              if(var10.field2767 == 6) {
                                 boolean var50 = class127.method2809(var10);
                                 if(var50) {
                                    var20 = var10.field2813;
                                 } else {
                                    var20 = var10.field2812;
                                 }

                                 class105 var54 = null;
                                 var22 = 0;
                                 if(var10.field2885 != -1) {
                                    var37 = class9.method128(var10.field2885);
                                    if(null != var37) {
                                       var37 = var37.method992(var10.field2780);
                                       var54 = var37.method1000(1);
                                       if(null != var54) {
                                          var54.method2287();
                                          var22 = var54.field1465 / 2;
                                       } else {
                                          class34.method701(var10);
                                       }
                                    }
                                 } else if(var10.field2788 == 5) {
                                    if(0 == var10.field2830) {
                                       var54 = client.field350.method3463((class42)null, -1, (class42)null, -1);
                                    } else {
                                       var54 = class106.field1881.vmethod1888();
                                    }
                                 } else if(-1 == var20) {
                                    var54 = var10.method3375((class42)null, -1, var50, class106.field1881.field34);
                                    if(null == var54 && class173.field2866) {
                                       class34.method701(var10);
                                    }
                                 } else {
                                    class42 var56 = class4.method42(var20);
                                    var54 = var10.method3375(var56, var10.field2834, var50, class106.field1881.field34);
                                    if(var54 == null && class173.field2866) {
                                       class34.method701(var10);
                                    }
                                 }

                                 class91.method2073(var10.field2886 / 2 + var12, var13 + var10.field2781 / 2);
                                 var23 = class91.field1596[var10.field2816] * var10.field2819 >> 16;
                                 var24 = var10.field2819 * class91.field1597[var10.field2816] >> 16;
                                 if(null != var54) {
                                    if(!var10.field2764) {
                                       var54.method2299(0, var10.field2817, 0, var10.field2816, 0, var23, var24);
                                    } else {
                                       var54.method2287();
                                       if(var10.field2822) {
                                          var54.method2300(0, var10.field2817, var10.field2818, var10.field2816, var10.field2859, var10.field2815 + var22 + var23, var24 + var10.field2815, var10.field2819);
                                       } else {
                                          var54.method2299(0, var10.field2817, var10.field2818, var10.field2816, var10.field2859, var23 + var22 + var10.field2815, var10.field2815 + var24);
                                       }
                                    }
                                 }

                                 class91.method2072();
                              } else {
                                 if(7 == var10.field2767) {
                                    var42 = var10.method3410();
                                    if(var42 == null) {
                                       if(class173.field2866) {
                                          class34.method701(var10);
                                       }
                                       continue;
                                    }

                                    var20 = 0;

                                    for(var21 = 0; var21 < var10.field2777; ++var21) {
                                       for(var22 = 0; var22 < var10.field2776; ++var22) {
                                          if(var10.field2883[var20] > 0) {
                                             var37 = class9.method128(var10.field2883[var20] - 1);
                                             String var38;
                                             if(1 != var37.field1127 && var10.field2884[var20] == 1) {
                                                var38 = class12.method163(16748608) + var37.field1128 + "</col>";
                                             } else {
                                                var38 = class12.method163(16748608) + var37.field1128 + "</col>" + " " + 'x' + class109.method2413(var10.field2884[var20]);
                                             }

                                             var25 = var22 * (115 + var10.field2831) + var12;
                                             var26 = var13 + (12 + var10.field2832) * var21;
                                             if(var10.field2828 == 0) {
                                                var42.method4002(var38, var25, var26, var10.field2790, var10.field2769?0:-1);
                                             } else if(var10.field2828 == 1) {
                                                var42.method4004(var38, var10.field2886 / 2 + var25, var26, var10.field2790, var10.field2769?0:-1);
                                             } else {
                                                var42.method4003(var38, var10.field2886 + var25 - 1, var26, var10.field2790, var10.field2769?0:-1);
                                             }
                                          }

                                          ++var20;
                                       }
                                    }
                                 }

                                 if(var10.field2767 == 8 && var10 == class26.field664 && client.field428 == client.field429) {
                                    var19 = 0;
                                    var20 = 0;
                                    class224 var49 = class181.field2945;
                                    String var39 = var10.field2825;

                                    String var40;
                                    for(var39 = client.method544(var39, var10); var39.length() > 0; var20 += var49.field3189 + 1) {
                                       var24 = var39.indexOf("<br>");
                                       if(-1 != var24) {
                                          var40 = var39.substring(0, var24);
                                          var39 = var39.substring(var24 + 4);
                                       } else {
                                          var40 = var39;
                                          var39 = "";
                                       }

                                       var25 = var49.method3997(var40);
                                       if(var25 > var19) {
                                          var19 = var25;
                                       }
                                    }

                                    var19 += 6;
                                    var20 += 7;
                                    var24 = var12 + var10.field2886 - 5 - var19;
                                    var25 = var13 + var10.field2781 + 5;
                                    if(var24 < var12 + 5) {
                                       var24 = var12 + 5;
                                    }

                                    if(var24 + var19 > var4) {
                                       var24 = var4 - var19;
                                    }

                                    if(var20 + var25 > var5) {
                                       var25 = var5 - var20;
                                    }

                                    class79.method1808(var24, var25, var19, var20, 16777120);
                                    class79.method1779(var24, var25, var19, var20, 0);
                                    var39 = var10.field2825;
                                    var26 = 2 + var25 + var49.field3189;

                                    for(var39 = client.method544(var39, var10); var39.length() > 0; var26 += 1 + var49.field3189) {
                                       var27 = var39.indexOf("<br>");
                                       if(-1 != var27) {
                                          var40 = var39.substring(0, var27);
                                          var39 = var39.substring(var27 + 4);
                                       } else {
                                          var40 = var39;
                                          var39 = "";
                                       }

                                       var49.method4002(var40, var24 + 3, var26, 0, -1);
                                    }
                                 }

                                 if(9 == var10.field2767) {
                                    if(1 == var10.field2798) {
                                       if(var10.field2799) {
                                          var19 = var12;
                                          var20 = var10.field2781 + var13;
                                          var21 = var10.field2886 + var12;
                                          var22 = var13;
                                       } else {
                                          var19 = var12;
                                          var20 = var13;
                                          var21 = var12 + var10.field2886;
                                          var22 = var13 + var10.field2781;
                                       }

                                       class79.method1785(var19, var20, var21, var22, var10.field2790);
                                    } else {
                                       var19 = var10.field2886 >= 0?var10.field2886:-var10.field2886;
                                       var20 = var10.field2781 >= 0?var10.field2781:-var10.field2781;
                                       var21 = var19;
                                       if(var19 < var20) {
                                          var21 = var20;
                                       }

                                       if(var21 != 0) {
                                          var22 = (var10.field2886 << 16) / var21;
                                          var23 = (var10.field2781 << 16) / var21;
                                          if(var23 <= var22) {
                                             var22 = -var22;
                                          } else {
                                             var23 = -var23;
                                          }

                                          var24 = var23 * var10.field2798 >> 17;
                                          var25 = var23 * var10.field2798 + 1 >> 17;
                                          var26 = var22 * var10.field2798 >> 17;
                                          var27 = var22 * var10.field2798 + 1 >> 17;
                                          var28 = var24 + var12;
                                          var29 = var12 - var25;
                                          var30 = var10.field2886 + var12 - var25;
                                          var31 = var10.field2886 + var12 + var24;
                                          var32 = var26 + var13;
                                          var33 = var13 - var27;
                                          var34 = var13 + var10.field2781 - var27;
                                          var35 = var26 + var13 + var10.field2781;
                                          class91.method2078(var28, var29, var30);
                                          class91.method2090(var32, var33, var34, var28, var29, var30, var10.field2790);
                                          class91.method2078(var28, var30, var31);
                                          class91.method2090(var32, var34, var35, var28, var30, var31, var10.field2790);
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

   class29(int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      this.field698 = var1;
      this.field689 = var2;
      this.field688 = var3;
      this.field687 = var4;
      this.field692 = var5;
      this.field691 = var6 + var7;
      int var8 = class179.method3492(this.field698).field1008;
      if(-1 != var8) {
         this.field696 = false;
         this.field693 = class4.method42(var8);
      } else {
         this.field696 = true;
      }

   }

   @ObfuscatedName("ap")
   @ObfuscatedSignature(
      signature = "(Lclass66;I)V",
      garbageValue = "1297281720"
   )
   static final void method644(class66 var0) {
      var0.field1269 = false;
      if(null != var0.field1271) {
         var0.field1271.field1268 = 0;
      }

      for(class66 var1 = var0.vmethod3709(); null != var1; var1 = var0.vmethod3704()) {
         method644(var1);
      }

   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(II)Lclass173;",
      garbageValue = "1915514479"
   )
   public static class173 method645(int var0) {
      int var1 = var0 >> 16;
      int var2 = var0 & '\uffff';
      if(null == class217.field3171[var1] || class217.field3171[var1][var2] == null) {
         boolean var3 = class188.method3731(var1);
         if(!var3) {
            return null;
         }
      }

      return class217.field3171[var1][var2];
   }
}
