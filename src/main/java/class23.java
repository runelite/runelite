import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("n")
public final class class23 extends class208 {
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 230663981
   )
   int field609;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 2091569477
   )
   int field610;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -1472836069
   )
   int field611;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -225517199
   )
   int field612;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -1181891573
   )
   int field613;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 772561943
   )
   int field614;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 1786012273
   )
   int field615;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 795972749
   )
   int field616;
   @ObfuscatedName("v")
   class64 field617;
   @ObfuscatedName("w")
   static class199 field618 = new class199();
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 398030767
   )
   int field619;
   @ObfuscatedName("q")
   class64 field620;
   @ObfuscatedName("s")
   int[] field621;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 2144640173
   )
   int field623;
   @ObfuscatedName("do")
   @ObfuscatedGetter(
      intValue = 1325251193
   )
   static int field625;
   @ObfuscatedName("a")
   class40 field626;

   @ObfuscatedName("c")
   public static class78[] method598(class167 var0, String var1, String var2) {
      int var3 = var0.method3303(var1);
      int var4 = var0.method3289(var3, var2);
      return class39.method820(var0, var3, var4);
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1788611116"
   )
   void method601() {
      int var1 = this.field616;
      class40 var2 = this.field626.method842();
      if(var2 != null) {
         this.field616 = var2.field963;
         this.field623 = var2.field971 * 128;
         this.field609 = var2.field972;
         this.field619 = var2.field960;
         this.field621 = var2.field974;
      } else {
         this.field616 = -1;
         this.field623 = 0;
         this.field609 = 0;
         this.field619 = 0;
         this.field621 = null;
      }

      if(this.field616 != var1 && null != this.field617) {
         class72.field1353.method1153(this.field617);
         this.field617 = null;
      }

   }

   @ObfuscatedName("cv")
   @ObfuscatedSignature(
      signature = "([Lclass173;IIIIIIIII)V",
      garbageValue = "16711935"
   )
   static final void method604(class173[] var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
      class79.method1773(var2, var3, var4, var5);
      class91.method2082();

      for(int var9 = 0; var9 < var0.length; ++var9) {
         class173 var10 = var0[var9];
         if(null != var10 && (var10.field2786 == var1 || var1 == -1412584499 && var10 == client.field353)) {
            int var11;
            if(var8 == -1) {
               client.field361[client.field497] = var6 + var10.field2780;
               client.field486[client.field497] = var7 + var10.field2892;
               client.field558[client.field497] = var10.field2767;
               client.field505[client.field497] = var10.field2783;
               var11 = ++client.field497 - 1;
            } else {
               var11 = var8;
            }

            var10.field2769 = var11;
            var10.field2899 = client.field305;
            if(!var10.field2766 || !class102.method2282(var10)) {
               if(var10.field2890 > 0) {
                  class176.method3480(var10);
               }

               int var12 = var6 + var10.field2780;
               int var13 = var7 + var10.field2892;
               int var14 = var10.field2798;
               int var15;
               int var16;
               if(client.field353 == var10) {
                  if(-1412584499 != var1 && !var10.field2845) {
                     class76.field1394 = var0;
                     class113.field1976 = var6;
                     class2.field64 = var7;
                     continue;
                  }

                  if(client.field423 && client.field382) {
                     var15 = class140.field2168;
                     var16 = class140.field2182;
                     var15 -= client.field469;
                     var16 -= client.field470;
                     if(var15 < client.field473) {
                        var15 = client.field473;
                     }

                     if(var15 + var10.field2767 > client.field473 + client.field468.field2767) {
                        var15 = client.field468.field2767 + client.field473 - var10.field2767;
                     }

                     if(var16 < client.field335) {
                        var16 = client.field335;
                     }

                     if(var16 + var10.field2783 > client.field468.field2783 + client.field335) {
                        var16 = client.field335 + client.field468.field2783 - var10.field2783;
                     }

                     var12 = var15;
                     var13 = var16;
                  }

                  if(!var10.field2845) {
                     var14 = 128;
                  }
               }

               int var17;
               int var18;
               int var19;
               int var20;
               int var21;
               int var22;
               if(var10.field2814 == 2) {
                  var15 = var2;
                  var16 = var3;
                  var17 = var4;
                  var18 = var5;
               } else if(9 == var10.field2814) {
                  var19 = var12;
                  var20 = var13;
                  var21 = var10.field2767 + var12;
                  var22 = var13 + var10.field2783;
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
                  var19 = var10.field2767 + var12;
                  var20 = var13 + var10.field2783;
                  var15 = var12 > var2?var12:var2;
                  var16 = var13 > var3?var13:var3;
                  var17 = var19 < var4?var19:var4;
                  var18 = var20 < var5?var20:var5;
               }

               if(!var10.field2766 || var15 < var17 && var16 < var18) {
                  if(0 != var10.field2890) {
                     if(var10.field2890 == 1336) {
                        if(client.field311) {
                           var13 += 15;
                           class3.field76.method4038("Fps:" + class144.field2218, var12 + var10.field2767, var13, 16776960, -1);
                           var13 += 15;
                           Runtime var52 = Runtime.getRuntime();
                           var20 = (int)((var52.totalMemory() - var52.freeMemory()) / 1024L);
                           var21 = 16776960;
                           if(var20 > '耀' && client.field413) {
                              var21 = 16711680;
                           }

                           if(var20 > 65536 && !client.field413) {
                              var21 = 16711680;
                           }

                           class3.field76.method4038("Mem:" + var20 + "k", var12 + var10.field2767, var13, var21, -1);
                           var13 += 15;
                        }
                        continue;
                     }

                     if(var10.field2890 == 1337) {
                        client.field516 = var12;
                        client.field443 = var13;
                        class47.method1020(var12, var13, var10.field2767, var10.field2783);
                        client.field499[var10.field2769] = true;
                        class79.method1773(var2, var3, var4, var5);
                        continue;
                     }

                     if(var10.field2890 == 1338) {
                        class8.method105(var10, var12, var13, var11);
                        class79.method1773(var2, var3, var4, var5);
                        continue;
                     }

                     if(var10.field2890 == 1339) {
                        class175 var51 = var10.method3424(false);
                        if(null != var51) {
                           if(client.field334 < 3) {
                              class32.field746.method1710(var12, var13, var51.field2911, var51.field2912, 25, 25, client.field388, 256, var51.field2909, var51.field2914);
                           } else {
                              class79.method1792(var12, var13, 0, var51.field2909, var51.field2914);
                           }
                        }

                        class79.method1773(var2, var3, var4, var5);
                        continue;
                     }
                  }

                  if(0 == var10.field2814) {
                     if(!var10.field2766 && class102.method2282(var10) && class99.field1693 != var10) {
                        continue;
                     }

                     if(!var10.field2766) {
                        if(var10.field2882 > var10.field2791 - var10.field2783) {
                           var10.field2882 = var10.field2791 - var10.field2783;
                        }

                        if(var10.field2882 < 0) {
                           var10.field2882 = 0;
                        }
                     }

                     method604(var0, var10.field2838, var15, var16, var17, var18, var12 - var10.field2788, var13 - var10.field2882, var11);
                     if(var10.field2891 != null) {
                        method604(var10.field2891, var10.field2838, var15, var16, var17, var18, var12 - var10.field2788, var13 - var10.field2882, var11);
                     }

                     class3 var36 = (class3)client.field455.method3806((long)var10.field2838);
                     if(null != var36) {
                        class34.method748(var36.field74, var15, var16, var17, var18, var12, var13, var11);
                     }

                     class79.method1773(var2, var3, var4, var5);
                     class91.method2082();
                  }

                  if(client.field508 || client.field459[var11] || client.field506 > 1) {
                     if(var10.field2814 == 0 && !var10.field2766 && var10.field2791 > var10.field2783) {
                        class12.method155(var12 + var10.field2767, var13, var10.field2882, var10.field2783, var10.field2791);
                     }

                     if(var10.field2814 != 1) {
                        int var25;
                        int var26;
                        int var29;
                        int var44;
                        int var45;
                        if(2 == var10.field2814) {
                           var19 = 0;

                           for(var20 = 0; var20 < var10.field2779; ++var20) {
                              for(var21 = 0; var21 < var10.field2778; ++var21) {
                                 var22 = (var10.field2833 + 32) * var21 + var12;
                                 var44 = var20 * (var10.field2834 + 32) + var13;
                                 if(var19 < 20) {
                                    var22 += var10.field2835[var19];
                                    var44 += var10.field2848[var19];
                                 }

                                 if(var10.field2885[var19] <= 0) {
                                    if(var10.field2837 != null && var19 < 20) {
                                       class78 var54 = var10.method3472(var19);
                                       if(var54 != null) {
                                          var54.method1699(var22, var44);
                                       } else if(class173.field2765) {
                                          class134.method2877(var10);
                                       }
                                    }
                                 } else {
                                    boolean var53 = false;
                                    boolean var47 = false;
                                    var26 = var10.field2885[var19] - 1;
                                    if(32 + var22 > var2 && var22 < var4 && var44 + 32 > var3 && var44 < var5 || var10 == class9.field175 && var19 == client.field408) {
                                       class78 var48;
                                       if(client.field381 == 1 && var19 == class59.field1224 && var10.field2838 == class41.field980) {
                                          var48 = class107.method2388(var26, var10.field2886[var19], 2, 0, 2, false);
                                       } else {
                                          var48 = class107.method2388(var26, var10.field2886[var19], 1, 3153952, 2, false);
                                       }

                                       if(null != var48) {
                                          if(var10 == class9.field175 && client.field408 == var19) {
                                             var45 = class140.field2168 - client.field467;
                                             var25 = class140.field2182 - client.field308;
                                             if(var45 < 5 && var45 > -5) {
                                                var45 = 0;
                                             }

                                             if(var25 < 5 && var25 > -5) {
                                                var25 = 0;
                                             }

                                             if(client.field550 < 5) {
                                                var45 = 0;
                                                var25 = 0;
                                             }

                                             var48.method1705(var22 + var45, var25 + var44, 128);
                                             if(var1 != -1) {
                                                class173 var50 = var0[var1 & '\uffff'];
                                                if(var25 + var44 < class79.field1418 && var50.field2882 > 0) {
                                                   var29 = (class79.field1418 - var44 - var25) * client.field370 / 3;
                                                   if(var29 > client.field370 * 10) {
                                                      var29 = client.field370 * 10;
                                                   }

                                                   if(var29 > var50.field2882) {
                                                      var29 = var50.field2882;
                                                   }

                                                   var50.field2882 -= var29;
                                                   client.field308 += var29;
                                                   class134.method2877(var50);
                                                }

                                                if(var25 + var44 + 32 > class79.field1413 && var50.field2882 < var50.field2791 - var50.field2783) {
                                                   var29 = client.field370 * (32 + var25 + var44 - class79.field1413) / 3;
                                                   if(var29 > client.field370 * 10) {
                                                      var29 = client.field370 * 10;
                                                   }

                                                   if(var29 > var50.field2791 - var50.field2783 - var50.field2882) {
                                                      var29 = var50.field2791 - var50.field2783 - var50.field2882;
                                                   }

                                                   var50.field2882 += var29;
                                                   client.field308 -= var29;
                                                   class134.method2877(var50);
                                                }
                                             }
                                          } else if(var10 == class52.field1167 && client.field407 == var19) {
                                             var48.method1705(var22, var44, 128);
                                          } else {
                                             var48.method1699(var22, var44);
                                          }
                                       } else {
                                          class134.method2877(var10);
                                       }
                                    }
                                 }

                                 ++var19;
                              }
                           }
                        } else if(var10.field2814 == 3) {
                           if(class50.method1058(var10)) {
                              var19 = var10.field2793;
                              if(var10 == class99.field1693 && 0 != var10.field2812) {
                                 var19 = var10.field2812;
                              }
                           } else {
                              var19 = var10.field2884;
                              if(class99.field1693 == var10 && 0 != var10.field2794) {
                                 var19 = var10.field2794;
                              }
                           }

                           if(var10.field2796) {
                              switch(var10.field2797.field1439) {
                              case 1:
                                 class79.method1780(var12, var13, var10.field2767, var10.field2783, var10.field2884, var10.field2793, 256 - (var10.field2798 & 255), 256 - (var10.field2799 & 255));
                                 break;
                              case 2:
                                 class79.method1820(var12, var13, var10.field2767, var10.field2783, var10.field2884, var10.field2793, 256 - (var10.field2798 & 255), 256 - (var10.field2799 & 255));
                                 break;
                              case 3:
                                 class79.method1851(var12, var13, var10.field2767, var10.field2783, var10.field2884, var10.field2793, 256 - (var10.field2798 & 255), 256 - (var10.field2799 & 255));
                                 break;
                              case 4:
                                 class79.method1770(var12, var13, var10.field2767, var10.field2783, var10.field2884, var10.field2793, 256 - (var10.field2798 & 255), 256 - (var10.field2799 & 255));
                                 break;
                              default:
                                 if(0 == var14) {
                                    class79.method1800(var12, var13, var10.field2767, var10.field2783, var19);
                                 } else {
                                    class79.method1803(var12, var13, var10.field2767, var10.field2783, var19, 256 - (var14 & 255));
                                 }
                              }
                           } else if(var14 == 0) {
                              class79.method1790(var12, var13, var10.field2767, var10.field2783, var19);
                           } else {
                              class79.method1782(var12, var13, var10.field2767, var10.field2783, var19, 256 - (var14 & 255));
                           }
                        } else {
                           class224 var37;
                           if(var10.field2814 == 4) {
                              var37 = var10.method3449();
                              if(var37 == null) {
                                 if(class173.field2765) {
                                    class134.method2877(var10);
                                 }
                              } else {
                                 String var49 = var10.field2771;
                                 if(class50.method1058(var10)) {
                                    var20 = var10.field2793;
                                    if(var10 == class99.field1693 && 0 != var10.field2812) {
                                       var20 = var10.field2812;
                                    }

                                    if(var10.field2828.length() > 0) {
                                       var49 = var10.field2828;
                                    }
                                 } else {
                                    var20 = var10.field2884;
                                    if(class99.field1693 == var10 && 0 != var10.field2794) {
                                       var20 = var10.field2794;
                                    }
                                 }

                                 if(var10.field2766 && -1 != var10.field2883) {
                                    class51 var55 = class50.method1055(var10.field2883);
                                    var49 = var55.field1122;
                                    if(var49 == null) {
                                       var49 = "null";
                                    }

                                    if((var55.field1133 == 1 || 1 != var10.field2888) && -1 != var10.field2888) {
                                       var49 = class72.method1574(16748608) + var49 + "</col>" + " " + 'x' + class47.method1022(var10.field2888);
                                    }
                                 }

                                 if(client.field458 == var10) {
                                    class157 var10000 = (class157)null;
                                    var49 = "Please wait...";
                                    var20 = var10.field2884;
                                 }

                                 if(!var10.field2766) {
                                    var49 = class171.method3414(var49, var10);
                                 }

                                 var37.method4066(var49, var12, var13, var10.field2767, var10.field2783, var20, var10.field2832?0:-1, var10.field2789, var10.field2831, var10.field2770);
                              }
                           } else if(5 == var10.field2814) {
                              class78 var41;
                              if(!var10.field2766) {
                                 var41 = var10.method3420(class50.method1058(var10));
                                 if(null != var41) {
                                    var41.method1699(var12, var13);
                                 } else if(class173.field2765) {
                                    class134.method2877(var10);
                                 }
                              } else {
                                 if(-1 != var10.field2883) {
                                    var41 = class107.method2388(var10.field2883, var10.field2888, var10.field2825, var10.field2820, var10.field2807, false);
                                 } else {
                                    var41 = var10.method3420(false);
                                 }

                                 if(null == var41) {
                                    if(class173.field2765) {
                                       class134.method2877(var10);
                                    }
                                 } else {
                                    var20 = var41.field1401;
                                    var21 = var41.field1409;
                                    if(!var10.field2805) {
                                       var22 = var10.field2767 * 4096 / var20;
                                       if(var10.field2804 != 0) {
                                          var41.method1757(var12 + var10.field2767 / 2, var13 + var10.field2783 / 2, var10.field2804, var22);
                                       } else if(0 != var14) {
                                          var41.method1691(var12, var13, var10.field2767, var10.field2783, 256 - (var14 & 255));
                                       } else if(var10.field2767 == var20 && var10.field2783 == var21) {
                                          var41.method1699(var12, var13);
                                       } else {
                                          var41.method1701(var12, var13, var10.field2767, var10.field2783);
                                       }
                                    } else {
                                       class79.method1831(var12, var13, var12 + var10.field2767, var13 + var10.field2783);
                                       var22 = (var20 - 1 + var10.field2767) / var20;
                                       var44 = (var21 - 1 + var10.field2783) / var21;

                                       for(var45 = 0; var45 < var22; ++var45) {
                                          for(var25 = 0; var25 < var44; ++var25) {
                                             if(0 != var10.field2804) {
                                                var41.method1757(var20 / 2 + var12 + var45 * var20, var25 * var21 + var13 + var21 / 2, var10.field2804, 4096);
                                             } else if(var14 != 0) {
                                                var41.method1705(var20 * var45 + var12, var25 * var21 + var13, 256 - (var14 & 255));
                                             } else {
                                                var41.method1699(var45 * var20 + var12, var25 * var21 + var13);
                                             }
                                          }
                                       }

                                       class79.method1773(var2, var3, var4, var5);
                                    }
                                 }
                              }
                           } else {
                              class51 var23;
                              if(6 == var10.field2814) {
                                 boolean var39 = class50.method1058(var10);
                                 if(var39) {
                                    var20 = var10.field2815;
                                 } else {
                                    var20 = var10.field2851;
                                 }

                                 class105 var43 = null;
                                 var22 = 0;
                                 if(-1 != var10.field2883) {
                                    var23 = class50.method1055(var10.field2883);
                                    if(var23 != null) {
                                       var23 = var23.method1067(var10.field2888);
                                       var43 = var23.method1084(1);
                                       if(var43 != null) {
                                          var43.method2323();
                                          var22 = var43.field1467 / 2;
                                       } else {
                                          class134.method2877(var10);
                                       }
                                    }
                                 } else if(var10.field2810 == 5) {
                                    if(0 == var10.field2811) {
                                       var43 = client.field309.method3497((class42)null, -1, (class42)null, -1);
                                    } else {
                                       var43 = class167.field2692.vmethod1901();
                                    }
                                 } else if(var20 == -1) {
                                    var43 = var10.method3423((class42)null, -1, var39, class167.field2692.field47);
                                    if(var43 == null && class173.field2765) {
                                       class134.method2877(var10);
                                    }
                                 } else {
                                    class42 var46 = class96.method2187(var20);
                                    var43 = var10.method3423(var46, var10.field2889, var39, class167.field2692.field47);
                                    if(var43 == null && class173.field2765) {
                                       class134.method2877(var10);
                                    }
                                 }

                                 class91.method2104(var12 + var10.field2767 / 2, var13 + var10.field2783 / 2);
                                 var44 = class91.field1573[var10.field2763] * var10.field2821 >> 16;
                                 var45 = var10.field2821 * class91.field1595[var10.field2763] >> 16;
                                 if(var43 != null) {
                                    if(!var10.field2766) {
                                       var43.method2349(0, var10.field2819, 0, var10.field2763, 0, var44, var45);
                                    } else {
                                       var43.method2323();
                                       if(var10.field2824) {
                                          var43.method2359(0, var10.field2819, var10.field2836, var10.field2763, var10.field2816, var10.field2817 + var22 + var44, var45 + var10.field2817, var10.field2821);
                                       } else {
                                          var43.method2349(0, var10.field2819, var10.field2836, var10.field2763, var10.field2816, var44 + var22 + var10.field2817, var10.field2817 + var45);
                                       }
                                    }
                                 }

                                 class91.method2084();
                              } else {
                                 if(var10.field2814 == 7) {
                                    var37 = var10.method3449();
                                    if(var37 == null) {
                                       if(class173.field2765) {
                                          class134.method2877(var10);
                                       }
                                       continue;
                                    }

                                    var20 = 0;

                                    for(var21 = 0; var21 < var10.field2779; ++var21) {
                                       for(var22 = 0; var22 < var10.field2778; ++var22) {
                                          if(var10.field2885[var20] > 0) {
                                             var23 = class50.method1055(var10.field2885[var20] - 1);
                                             String var24;
                                             if(1 != var23.field1133 && 1 == var10.field2886[var20]) {
                                                var24 = class72.method1574(16748608) + var23.field1122 + "</col>";
                                             } else {
                                                var24 = class72.method1574(16748608) + var23.field1122 + "</col>" + " " + 'x' + class47.method1022(var10.field2886[var20]);
                                             }

                                             var25 = var22 * (115 + var10.field2833) + var12;
                                             var26 = var13 + (12 + var10.field2834) * var21;
                                             if(0 == var10.field2789) {
                                                var37.method4037(var24, var25, var26, var10.field2884, var10.field2832?0:-1);
                                             } else if(1 == var10.field2789) {
                                                var37.method4039(var24, var10.field2767 / 2 + var25, var26, var10.field2884, var10.field2832?0:-1);
                                             } else {
                                                var37.method4038(var24, var25 + var10.field2767 - 1, var26, var10.field2884, var10.field2832?0:-1);
                                             }
                                          }

                                          ++var20;
                                       }
                                    }
                                 }

                                 int var27;
                                 if(8 == var10.field2814 && class0.field12 == var10 && client.field445 == client.field444) {
                                    var19 = 0;
                                    var20 = 0;
                                    class224 var38 = class3.field76;
                                    String var42 = var10.field2771;

                                    String var40;
                                    for(var42 = class171.method3414(var42, var10); var42.length() > 0; var20 += var38.field3194 + 1) {
                                       var45 = var42.indexOf("<br>");
                                       if(var45 != -1) {
                                          var40 = var42.substring(0, var45);
                                          var42 = var42.substring(var45 + 4);
                                       } else {
                                          var40 = var42;
                                          var42 = "";
                                       }

                                       var25 = var38.method4032(var40);
                                       if(var25 > var19) {
                                          var19 = var25;
                                       }
                                    }

                                    var19 += 6;
                                    var20 += 7;
                                    var45 = var12 + var10.field2767 - 5 - var19;
                                    var25 = 5 + var13 + var10.field2783;
                                    if(var45 < var12 + 5) {
                                       var45 = 5 + var12;
                                    }

                                    if(var19 + var45 > var4) {
                                       var45 = var4 - var19;
                                    }

                                    if(var20 + var25 > var5) {
                                       var25 = var5 - var20;
                                    }

                                    class79.method1800(var45, var25, var19, var20, 16777120);
                                    class79.method1790(var45, var25, var19, var20, 0);
                                    var42 = var10.field2771;
                                    var26 = var25 + var38.field3194 + 2;

                                    for(var42 = class171.method3414(var42, var10); var42.length() > 0; var26 += var38.field3194 + 1) {
                                       var27 = var42.indexOf("<br>");
                                       if(-1 != var27) {
                                          var40 = var42.substring(0, var27);
                                          var42 = var42.substring(var27 + 4);
                                       } else {
                                          var40 = var42;
                                          var42 = "";
                                       }

                                       var38.method4037(var40, 3 + var45, var26, 0, -1);
                                    }
                                 }

                                 if(9 == var10.field2814) {
                                    if(1 == var10.field2800) {
                                       if(var10.field2902) {
                                          var19 = var12;
                                          var20 = var10.field2783 + var13;
                                          var21 = var10.field2767 + var12;
                                          var22 = var13;
                                       } else {
                                          var19 = var12;
                                          var20 = var13;
                                          var21 = var10.field2767 + var12;
                                          var22 = var13 + var10.field2783;
                                       }

                                       class79.method1819(var19, var20, var21, var22, var10.field2884);
                                    } else {
                                       var19 = var10.field2767 >= 0?var10.field2767:-var10.field2767;
                                       var20 = var10.field2783 >= 0?var10.field2783:-var10.field2783;
                                       var21 = var19;
                                       if(var19 < var20) {
                                          var21 = var20;
                                       }

                                       if(0 != var21) {
                                          var22 = (var10.field2767 << 16) / var21;
                                          var44 = (var10.field2783 << 16) / var21;
                                          if(var44 <= var22) {
                                             var22 = -var22;
                                          } else {
                                             var44 = -var44;
                                          }

                                          var45 = var10.field2800 * var44 >> 17;
                                          var25 = 1 + var44 * var10.field2800 >> 17;
                                          var26 = var10.field2800 * var22 >> 17;
                                          var27 = var22 * var10.field2800 + 1 >> 17;
                                          int var28 = var12 + var45;
                                          var29 = var12 - var25;
                                          int var30 = var10.field2767 + var12 - var25;
                                          int var31 = var45 + var12 + var10.field2767;
                                          int var32 = var13 + var26;
                                          int var33 = var13 - var27;
                                          int var34 = var13 + var10.field2783 - var27;
                                          int var35 = var26 + var10.field2783 + var13;
                                          class91.method2140(var28, var29, var30);
                                          class91.method2093(var32, var33, var34, var28, var29, var30, var10.field2884);
                                          class91.method2140(var28, var30, var31);
                                          class91.method2093(var32, var34, var35, var28, var30, var31, var10.field2884);
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

   @ObfuscatedName("w")
   public static class112 method606(class112[] var0, int var1) {
      class112[] var2 = var0;

      for(int var3 = 0; var3 < var2.length; ++var3) {
         class112 var4 = var2[var3];
         if(var1 == var4.vmethod3196()) {
            return var4;
         }
      }

      return null;
   }
}
