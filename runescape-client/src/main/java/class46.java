import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ae")
public class class46 extends class204 {
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -1552751241
   )
   public int field1059 = 0;
   @ObfuscatedName("u")
   public static class193 field1060 = new class193(64);
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 117359957
   )
   public int field1061;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 698826121
   )
   public int field1062 = -1;
   @ObfuscatedName("l")
   public boolean field1064 = true;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 373638355
   )
   public int field1065;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -161614509
   )
   public int field1066;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -1817604689
   )
   public int field1067;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -1059411691
   )
   public int field1068;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -932420573
   )
   public int field1070;
   @ObfuscatedName("f")
   public static class167 field1071;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -505143779
   )
   public int field1073 = -1;
   @ObfuscatedName("pi")
   static class160 field1074;

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Lclass119;II)V",
      garbageValue = "884794858"
   )
   public void method1004(class119 var1, int var2) {
      while(true) {
         int var3 = var1.method2554();
         if(var3 == 0) {
            return;
         }

         this.method1005(var1, var3, var2);
      }
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Lclass119;IIB)V",
      garbageValue = "-92"
   )
   void method1005(class119 var1, int var2, int var3) {
      if(var2 == 1) {
         this.field1059 = var1.method2558();
      } else if(var2 == 2) {
         this.field1062 = var1.method2554();
      } else if(var2 == 5) {
         this.field1064 = false;
      } else if(var2 == 7) {
         this.field1073 = var1.method2558();
      } else if(var2 == 8) {
         ;
      }

   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-990481107"
   )
   void method1006(int var1) {
      double var2 = (double)(var1 >> 16 & 255) / 256.0D;
      double var4 = (double)(var1 >> 8 & 255) / 256.0D;
      double var6 = (double)(var1 & 255) / 256.0D;
      double var8 = var2;
      if(var4 < var2) {
         var8 = var4;
      }

      if(var6 < var8) {
         var8 = var6;
      }

      double var10 = var2;
      if(var4 > var2) {
         var10 = var4;
      }

      if(var6 > var10) {
         var10 = var6;
      }

      double var12 = 0.0D;
      double var14 = 0.0D;
      double var16 = (var10 + var8) / 2.0D;
      if(var8 != var10) {
         if(var16 < 0.5D) {
            var14 = (var10 - var8) / (var8 + var10);
         }

         if(var16 >= 0.5D) {
            var14 = (var10 - var8) / (2.0D - var10 - var8);
         }

         if(var2 == var10) {
            var12 = (var4 - var6) / (var10 - var8);
         } else if(var10 == var4) {
            var12 = 2.0D + (var6 - var2) / (var10 - var8);
         } else if(var6 == var10) {
            var12 = (var2 - var4) / (var10 - var8) + 4.0D;
         }
      }

      var12 /= 6.0D;
      this.field1065 = (int)(256.0D * var12);
      this.field1066 = (int)(256.0D * var14);
      this.field1067 = (int)(var16 * 256.0D);
      if(this.field1066 < 0) {
         this.field1066 = 0;
      } else if(this.field1066 > 255) {
         this.field1066 = 255;
      }

      if(this.field1067 < 0) {
         this.field1067 = 0;
      } else if(this.field1067 > 255) {
         this.field1067 = 255;
      }

   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(Lclass167;Lclass167;Lclass167;Lclass167;I)V",
      garbageValue = "-2010731823"
   )
   public static void method1007(class167 var0, class167 var1, class167 var2, class167 var3) {
      class173.field2802 = var0;
      class173.field2882 = var1;
      class173.field2747 = var2;
      class163.field2648 = var3;
      class173.field2770 = new class173[class173.field2802.method3292()][];
      class173.field2744 = new boolean[class173.field2802.method3292()];
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1363908800"
   )
   public void method1013() {
      if(this.field1073 != -1) {
         this.method1006(this.field1073);
         this.field1068 = this.field1065;
         this.field1061 = this.field1066;
         this.field1070 = this.field1067;
      }

      this.method1006(this.field1059);
   }

   @ObfuscatedName("ad")
   @ObfuscatedSignature(
      signature = "(Lclass37;IIIIII)V",
      garbageValue = "-1612256898"
   )
   static final void method1017(class37 var0, int var1, int var2, int var3, int var4, int var5) {
      if(null != var0 && var0.vmethod790()) {
         if(var0 instanceof class34) {
            class39 var6 = ((class34)var0).field782;
            if(null != var6.field910) {
               var6 = var6.method813();
            }

            if(var6 == null) {
               return;
            }
         }

         int var10 = class32.field753;
         int[] var7 = class32.field761;
         int var8;
         if(var1 < var10) {
            var8 = 30;
            class2 var9 = (class2)var0;
            if(var9.field46) {
               return;
            }

            if(var9.field56 != -1 || var9.field38 != -1) {
               class188.method3779(var0, var0.field870 + 15);
               if(client.field395 > -1) {
                  if(var9.field56 != -1) {
                     class156.field2305[var9.field56].method1763(client.field395 + var2 - 12, var3 + client.field396 - var8);
                     var8 += 25;
                  }

                  if(var9.field38 != -1) {
                     class87.field1541[var9.field38].method1763(client.field395 + var2 - 12, var3 + client.field396 - var8);
                     var8 += 25;
                  }
               }
            }

            if(var1 >= 0 && client.field457 == 10 && client.field360 == var7[var1]) {
               class188.method3779(var0, 15 + var0.field870);
               if(client.field395 > -1) {
                  class9.field164[1].method1763(var2 + client.field395 - 12, client.field396 + var3 - var8);
               }
            }
         } else {
            class39 var11 = ((class34)var0).field782;
            if(null != var11.field910) {
               var11 = var11.method813();
            }

            if(var11.field921 >= 0 && var11.field921 < class87.field1541.length) {
               class188.method3779(var0, var0.field870 + 15);
               if(client.field395 > -1) {
                  class87.field1541[var11.field921].method1763(var2 + client.field395 - 12, client.field396 + var3 - 30);
               }
            }

            if(client.field457 == 1 && client.field330[var1 - var10] == client.field311 && client.field301 % 20 < 10) {
               class188.method3779(var0, 15 + var0.field870);
               if(client.field395 > -1) {
                  class9.field164[0].method1763(client.field395 + var2 - 12, var3 + client.field396 - 28);
               }
            }
         }

         if(var0.field824 != null && (var1 >= var10 || !var0.field836 && (client.field505 == 4 || !var0.field835 && (client.field505 == 0 || client.field505 == 3 || client.field505 == 1 && class90.method2140(((class2)var0).field60, false))))) {
            class188.method3779(var0, var0.field870);
            if(client.field395 > -1 && client.field383 < client.field384) {
               client.field388[client.field383] = class32.field758.method4043(var0.field824) / 2;
               client.field387[client.field383] = class32.field758.field3188;
               client.field385[client.field383] = client.field395;
               client.field528[client.field383] = client.field396;
               client.field389[client.field383] = var0.field852;
               client.field390[client.field383] = var0.field877;
               client.field487[client.field383] = var0.field882;
               client.field334[client.field383] = var0.field824;
               ++client.field383;
            }
         }

         if(var0.field843 > client.field301) {
            class188.method3779(var0, 15 + var0.field870);
            if(client.field395 > -1) {
               if(var1 < var10) {
                  var8 = 30;
               } else {
                  class39 var13 = ((class34)var0).field782;
                  var8 = var13.field914;
               }

               int var12 = var0.field861 * var8 / var0.field834;
               if(var12 > var8) {
                  var12 = var8;
               } else if(var12 == 0 && var0.field861 > 0) {
                  var12 = 1;
               }

               class79.method1854(client.field395 + var2 - var8 / 2, client.field396 + var3 - 3, var12, 5, '\uff00');
               class79.method1854(client.field395 + var2 - var8 / 2 + var12, client.field396 + var3 - 3, var8 - var12, 5, 16711680);
            }
         }

         for(var8 = 0; var8 < 4; ++var8) {
            if(var0.field869[var8] > client.field301) {
               class188.method3779(var0, var0.field870 / 2);
               if(client.field395 > -1) {
                  if(var8 == 1) {
                     client.field396 -= 20;
                  }

                  if(var8 == 2) {
                     client.field395 -= 15;
                     client.field396 -= 10;
                  }

                  if(var8 == 3) {
                     client.field395 += 15;
                     client.field396 -= 10;
                  }

                  class138.field2139[var0.field841[var8]].method1763(var2 + client.field395 - 12, client.field396 + var3 - 12);
                  class31.field737.method4073(Integer.toString(var0.field840[var8]), client.field395 + var2 - 1, 3 + client.field396 + var3, 16777215, 0);
               }
            }
         }

      }
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(Lclass167;III)Lclass78;",
      garbageValue = "802113147"
   )
   public static class78 method1018(class167 var0, int var1, int var2) {
      return !class94.method2227(var0, var1, var2)?null:class77.method1748();
   }

   @ObfuscatedName("ao")
   @ObfuscatedSignature(
      signature = "(Lclass173;III)V",
      garbageValue = "1975530379"
   )
   static final void method1019(class173 var0, int var1, int var2) {
      if(client.field523 == 0 || client.field523 == 3) {
         if(class140.field2156 == 1 || !class148.field2224 && class140.field2156 == 4) {
            class175 var3 = var0.method3454(true);
            if(var3 == null) {
               return;
            }

            int var4 = class140.field2161 - var1;
            int var5 = class140.field2158 - var2;
            if(var3.method3475(var4, var5)) {
               var4 -= var3.field2900 / 2;
               var5 -= var3.field2901 / 2;
               int var6 = client.field374 + client.field500 & 2047;
               int var7 = class91.field1597[var6];
               int var8 = class91.field1577[var6];
               var7 = (client.field363 + 256) * var7 >> 8;
               var8 = var8 * (client.field363 + 256) >> 8;
               int var9 = var8 * var4 + var7 * var5 >> 11;
               int var10 = var8 * var5 - var4 * var7 >> 11;
               int var11 = class15.field225.field837 + var9 >> 7;
               int var12 = class15.field225.field880 - var10 >> 7;
               client.field333.method2773(9);
               client.field333.method2654(18);
               client.field333.method2577(class137.field2114[82]?(class137.field2114[81]?2:1):0);
               client.field333.method2584(var12 + class20.field576);
               client.field333.method2540(var11 + class172.field2734);
               client.field333.method2654(var4);
               client.field333.method2654(var5);
               client.field333.method2540(client.field374);
               client.field333.method2654(57);
               client.field333.method2654(client.field500);
               client.field333.method2654(client.field363);
               client.field333.method2654(89);
               client.field333.method2540(class15.field225.field837);
               client.field333.method2540(class15.field225.field880);
               client.field333.method2654(63);
               client.field482 = var11;
               client.field522 = var12;
            }
         }

      }
   }

   @ObfuscatedName("cw")
   @ObfuscatedSignature(
      signature = "([Lclass173;IIIIIIIII)V",
      garbageValue = "997972966"
   )
   @Export("gameDraw")
   static final void method1020(class173[] var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
      class79.method1848(var2, var3, var4, var5);
      class91.method2151();

      for(int var9 = 0; var9 < var0.length; ++var9) {
         class173 var10 = var0[var9];
         if(var10 != null && (var10.field2773 == var1 || var1 == -1412584499 && var10 == client.field428)) {
            int var11;
            if(var8 == -1) {
               client.field495[client.field490] = var6 + var10.field2873;
               client.field496[client.field490] = var7 + var10.field2807;
               client.field497[client.field490] = var10.field2769;
               client.field498[client.field490] = var10.field2888;
               var11 = ++client.field490 - 1;
            } else {
               var11 = var8;
            }

            var10.field2885 = var11;
            var10.field2886 = client.field301;
            if(!var10.field2860 || !class6.method107(var10)) {
               int var12;
               if(var10.field2758 > 0) {
                  var12 = var10.field2758;
                  if(var12 == 324) {
                     if(client.field303 == -1) {
                        client.field303 = var10.field2789;
                        client.field400 = var10.field2790;
                     }

                     if(client.field561.field2917) {
                        var10.field2789 = client.field303;
                     } else {
                        var10.field2789 = client.field400;
                     }
                  } else if(var12 == 325) {
                     if(client.field303 == -1) {
                        client.field303 = var10.field2789;
                        client.field400 = var10.field2790;
                     }

                     if(client.field561.field2917) {
                        var10.field2789 = client.field400;
                     } else {
                        var10.field2789 = client.field303;
                     }
                  } else if(var12 == 327) {
                     var10.field2805 = 150;
                     var10.field2806 = (int)(Math.sin((double)client.field301 / 40.0D) * 256.0D) & 2047;
                     var10.field2797 = 5;
                     var10.field2768 = 0;
                  } else if(var12 == 328) {
                     var10.field2805 = 150;
                     var10.field2806 = (int)(Math.sin((double)client.field301 / 40.0D) * 256.0D) & 2047;
                     var10.field2797 = 5;
                     var10.field2768 = 1;
                  }
               }

               var12 = var10.field2873 + var6;
               int var13 = var10.field2807 + var7;
               int var14 = var10.field2785;
               int var15;
               int var16;
               if(var10 == client.field428) {
                  if(var1 != -1412584499 && !var10.field2832) {
                     class173.field2890 = var0;
                     class22.field594 = var6;
                     class1.field34 = var7;
                     continue;
                  }

                  if(client.field369 && client.field465) {
                     var15 = class140.field2146;
                     var16 = class140.field2151;
                     var15 -= client.field308;
                     var16 -= client.field545;
                     if(var15 < client.field466) {
                        var15 = client.field466;
                     }

                     if(var15 + var10.field2769 > client.field298.field2769 + client.field466) {
                        var15 = client.field298.field2769 + client.field466 - var10.field2769;
                     }

                     if(var16 < client.field467) {
                        var16 = client.field467;
                     }

                     if(var16 + var10.field2888 > client.field467 + client.field298.field2888) {
                        var16 = client.field298.field2888 + client.field467 - var10.field2888;
                     }

                     var12 = var15;
                     var13 = var16;
                  }

                  if(!var10.field2832) {
                     var14 = 128;
                  }
               }

               int var17;
               int var18;
               int var20;
               int var21;
               int var22;
               int var48;
               if(var10.field2798 == 2) {
                  var15 = var2;
                  var16 = var3;
                  var17 = var4;
                  var18 = var5;
               } else if(var10.field2798 == 9) {
                  var48 = var12;
                  var20 = var13;
                  var21 = var12 + var10.field2769;
                  var22 = var10.field2888 + var13;
                  if(var21 < var12) {
                     var48 = var21;
                     var21 = var12;
                  }

                  if(var22 < var13) {
                     var20 = var22;
                     var22 = var13;
                  }

                  ++var21;
                  ++var22;
                  var15 = var48 > var2?var48:var2;
                  var16 = var20 > var3?var20:var3;
                  var17 = var21 < var4?var21:var4;
                  var18 = var22 < var5?var22:var5;
               } else {
                  var48 = var12 + var10.field2769;
                  var20 = var13 + var10.field2888;
                  var15 = var12 > var2?var12:var2;
                  var16 = var13 > var3?var13:var3;
                  var17 = var48 < var4?var48:var4;
                  var18 = var20 < var5?var20:var5;
               }

               if(!var10.field2860 || var15 < var17 && var16 < var18) {
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
                  if(var10.field2758 != 0) {
                     if(var10.field2758 == 1336) {
                        if(client.field355) {
                           var13 += 15;
                           class36.field814.method4105("Fps:" + class144.field2194, var12 + var10.field2769, var13, 16776960, -1);
                           var13 += 15;
                           Runtime var59 = Runtime.getRuntime();
                           var20 = (int)((var59.totalMemory() - var59.freeMemory()) / 1024L);
                           var21 = 16776960;
                           if(var20 > '耀' && client.field296) {
                              var21 = 16711680;
                           }

                           if(var20 > 65536 && !client.field296) {
                              var21 = 16711680;
                           }

                           class36.field814.method4105("Mem:" + var20 + "k", var10.field2769 + var12, var13, var21, -1);
                           var13 += 15;
                        }
                        continue;
                     }

                     if(var10.field2758 == 1337) {
                        client.field568 = var12;
                        client.field461 = var13;
                        var21 = var10.field2769;
                        var22 = var10.field2888;
                        ++client.field552;
                        class166.method3282(class33.field781);
                        boolean var60 = false;
                        if(client.field464 >= 0) {
                           var24 = class32.field753;
                           int[] var54 = class32.field761;

                           for(var26 = 0; var26 < var24; ++var26) {
                              if(client.field464 == var54[var26]) {
                                 var60 = true;
                                 break;
                              }
                           }
                        }

                        if(var60) {
                           class166.method3282(class33.field772);
                        }

                        class49.method1047(true);
                        class166.method3282(var60?class33.field776:class33.field773);
                        class49.method1047(false);
                        class4.method50();
                        class16.method194();
                        class157.method3189(var12, var13, var21, var22, true);
                        var48 = client.field463;
                        var20 = client.field551;
                        var21 = client.field432;
                        var22 = client.field553;
                        class79.method1848(var48, var20, var48 + var21, var22 + var20);
                        class91.method2151();
                        if(!client.field536) {
                           var24 = client.field373;
                           if(client.field556 / 256 > var24) {
                              var24 = client.field556 / 256;
                           }

                           if(client.field525[4] && 128 + client.field539[4] > var24) {
                              var24 = 128 + client.field539[4];
                           }

                           var25 = client.field374 + client.field358 & 2047;
                           class9.method132(class5.field101, class74.method1659(class15.field225.field837, class15.field225.field880, class14.field212) - client.field379, class9.field161, var24, var25, 600 + 3 * var24);
                        }

                        if(!client.field536) {
                           if(class20.field580.field140) {
                              var25 = class14.field212;
                           } else {
                              label1672: {
                                 var26 = 3;
                                 if(class134.field2082 < 310) {
                                    var27 = class216.field3160 >> 7;
                                    var28 = class26.field665 >> 7;
                                    var29 = class15.field225.field837 >> 7;
                                    var30 = class15.field225.field880 >> 7;
                                    if(var27 < 0 || var28 < 0 || var27 >= 104 || var28 >= 104) {
                                       var25 = class14.field212;
                                       break label1672;
                                    }

                                    if((class5.field82[class14.field212][var27][var28] & 4) != 0) {
                                       var26 = class14.field212;
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

                                          if((class5.field82[class14.field212][var27][var28] & 4) != 0) {
                                             var26 = class14.field212;
                                          }

                                          var34 += var33;
                                          if(var34 >= 65536) {
                                             var34 -= 65536;
                                             if(var28 < var30) {
                                                ++var28;
                                             } else if(var28 > var30) {
                                                --var28;
                                             }

                                             if((class5.field82[class14.field212][var27][var28] & 4) != 0) {
                                                var26 = class14.field212;
                                             }
                                          }
                                       }
                                    } else {
                                       var33 = 65536 * var31 / var32;
                                       var34 = '耀';

                                       while(var28 != var30) {
                                          if(var28 < var30) {
                                             ++var28;
                                          } else if(var28 > var30) {
                                             --var28;
                                          }

                                          if((class5.field82[class14.field212][var27][var28] & 4) != 0) {
                                             var26 = class14.field212;
                                          }

                                          var34 += var33;
                                          if(var34 >= 65536) {
                                             var34 -= 65536;
                                             if(var27 < var29) {
                                                ++var27;
                                             } else if(var27 > var29) {
                                                --var27;
                                             }

                                             if((class5.field82[class14.field212][var27][var28] & 4) != 0) {
                                                var26 = class14.field212;
                                             }
                                          }
                                       }
                                    }
                                 }

                                 if(class15.field225.field837 >= 0 && class15.field225.field880 >= 0 && class15.field225.field837 < 13312 && class15.field225.field880 < 13312) {
                                    if((class5.field82[class14.field212][class15.field225.field837 >> 7][class15.field225.field880 >> 7] & 4) != 0) {
                                       var26 = class14.field212;
                                    }

                                    var25 = var26;
                                 } else {
                                    var25 = class14.field212;
                                 }
                              }
                           }

                           var24 = var25;
                        } else {
                           if(class20.field580.field140) {
                              var25 = class14.field212;
                           } else {
                              var26 = class74.method1659(class216.field3160, class26.field665, class14.field212);
                              if(var26 - class1.field27 < 800 && (class5.field82[class14.field212][class216.field3160 >> 7][class26.field665 >> 7] & 4) != 0) {
                                 var25 = class14.field212;
                              } else {
                                 var25 = 3;
                              }
                           }

                           var24 = var25;
                        }

                        var25 = class216.field3160;
                        var26 = class1.field27;
                        var27 = class26.field665;
                        var28 = class134.field2082;
                        var29 = class42.field1018;

                        for(var30 = 0; var30 < 5; ++var30) {
                           if(client.field525[var30]) {
                              var31 = (int)(Math.random() * (double)(1 + client.field538[var30] * 2) - (double)client.field538[var30] + Math.sin((double)client.field540[var30] / 100.0D * (double)client.field541[var30]) * (double)client.field539[var30]);
                              if(var30 == 0) {
                                 class216.field3160 += var31;
                              }

                              if(var30 == 1) {
                                 class1.field27 += var31;
                              }

                              if(var30 == 2) {
                                 class26.field665 += var31;
                              }

                              if(var30 == 3) {
                                 class42.field1018 = var31 + class42.field1018 & 2047;
                              }

                              if(var30 == 4) {
                                 class134.field2082 += var31;
                                 if(class134.field2082 < 128) {
                                    class134.field2082 = 128;
                                 }

                                 if(class134.field2082 > 383) {
                                    class134.field2082 = 383;
                                 }
                              }
                           }
                        }

                        var30 = class140.field2146;
                        var31 = class140.field2151;
                        if(class140.field2156 != 0) {
                           var30 = class140.field2161;
                           var31 = class140.field2158;
                        }

                        if(var30 >= var48 && var30 < var21 + var48 && var31 >= var20 && var31 < var20 + var22) {
                           class105.field1858 = true;
                           class105.field1861 = 0;
                           class105.field1853 = var30 - var48;
                           class105.field1860 = var31 - var20;
                        } else {
                           class105.field1858 = false;
                           class105.field1861 = 0;
                        }

                        class8.method114();
                        class79.method1854(var48, var20, var21, var22, 0);
                        class8.method114();
                        var32 = class91.field1583;
                        class91.field1583 = client.field548;
                        class129.field2056.method2061(class216.field3160, class1.field27, class26.field665, class134.field2082, class42.field1018, var24);
                        class91.field1583 = var32;
                        class8.method114();
                        class129.field2056.method1989();
                        client.field383 = 0;
                        boolean var63 = false;
                        var34 = -1;
                        var35 = class32.field753;
                        int[] var36 = class32.field761;

                        int var37;
                        for(var37 = 0; var37 < var35 + client.field494; ++var37) {
                           Object var56;
                           if(var37 < var35) {
                              var56 = client.field302[var36[var37]];
                              if(client.field464 == var36[var37]) {
                                 var63 = true;
                                 var34 = var37;
                                 continue;
                              }
                           } else {
                              var56 = client.field328[client.field330[var37 - var35]];
                           }

                           method1017((class37)var56, var37, var48, var20, var21, var22);
                        }

                        if(var63) {
                           method1017(client.field302[client.field464], var34, var48, var20, var21, var22);
                        }

                        for(var37 = 0; var37 < client.field383; ++var37) {
                           int var38 = client.field385[var37];
                           int var39 = client.field528[var37];
                           int var40 = client.field388[var37];
                           int var41 = client.field387[var37];
                           boolean var42 = true;

                           while(var42) {
                              var42 = false;

                              for(int var43 = 0; var43 < var37; ++var43) {
                                 if(var39 + 2 > client.field528[var43] - client.field387[var43] && var39 - var41 < client.field528[var43] + 2 && var38 - var40 < client.field388[var43] + client.field385[var43] && var40 + var38 > client.field385[var43] - client.field388[var43] && client.field528[var43] - client.field387[var43] < var39) {
                                    var39 = client.field528[var43] - client.field387[var43];
                                    var42 = true;
                                 }
                              }
                           }

                           client.field395 = client.field385[var37];
                           client.field396 = client.field528[var37] = var39;
                           String var47 = client.field334[var37];
                           if(client.field449 == 0) {
                              int var44 = 16776960;
                              if(client.field389[var37] < 6) {
                                 var44 = client.field348[client.field389[var37]];
                              }

                              if(client.field389[var37] == 6) {
                                 var44 = client.field552 % 20 < 10?16711680:16776960;
                              }

                              if(client.field389[var37] == 7) {
                                 var44 = client.field552 % 20 < 10?255:'\uffff';
                              }

                              if(client.field389[var37] == 8) {
                                 var44 = client.field552 % 20 < 10?'뀀':8454016;
                              }

                              int var45;
                              if(client.field389[var37] == 9) {
                                 var45 = 150 - client.field487[var37];
                                 if(var45 < 50) {
                                    var44 = var45 * 1280 + 16711680;
                                 } else if(var45 < 100) {
                                    var44 = 16776960 - (var45 - 50) * 327680;
                                 } else if(var45 < 150) {
                                    var44 = '\uff00' + (var45 - 100) * 5;
                                 }
                              }

                              if(client.field389[var37] == 10) {
                                 var45 = 150 - client.field487[var37];
                                 if(var45 < 50) {
                                    var44 = 16711680 + 5 * var45;
                                 } else if(var45 < 100) {
                                    var44 = 16711935 - 327680 * (var45 - 50);
                                 } else if(var45 < 150) {
                                    var44 = 255 + 327680 * (var45 - 100) - (var45 - 100) * 5;
                                 }
                              }

                              if(client.field389[var37] == 11) {
                                 var45 = 150 - client.field487[var37];
                                 if(var45 < 50) {
                                    var44 = 16777215 - var45 * 327685;
                                 } else if(var45 < 100) {
                                    var44 = 327685 * (var45 - 50) + '\uff00';
                                 } else if(var45 < 150) {
                                    var44 = 16777215 - 327680 * (var45 - 100);
                                 }
                              }

                              if(client.field390[var37] == 0) {
                                 class32.field758.method4073(var47, var48 + client.field395, var20 + client.field396, var44, 0);
                              }

                              if(client.field390[var37] == 1) {
                                 class32.field758.method4052(var47, var48 + client.field395, client.field396 + var20, var44, 0, client.field552);
                              }

                              if(client.field390[var37] == 2) {
                                 class32.field758.method4053(var47, var48 + client.field395, var20 + client.field396, var44, 0, client.field552);
                              }

                              if(client.field390[var37] == 3) {
                                 class32.field758.method4072(var47, var48 + client.field395, var20 + client.field396, var44, 0, client.field552, 150 - client.field487[var37]);
                              }

                              if(client.field390[var37] == 4) {
                                 var45 = (150 - client.field487[var37]) * (class32.field758.method4043(var47) + 100) / 150;
                                 class79.method1849(var48 + client.field395 - 50, var20, client.field395 + var48 + 50, var22 + var20);
                                 class32.field758.method4066(var47, 50 + client.field395 + var48 - var45, client.field396 + var20, var44, 0);
                                 class79.method1848(var48, var20, var48 + var21, var20 + var22);
                              }

                              if(client.field390[var37] == 5) {
                                 var45 = 150 - client.field487[var37];
                                 int var46 = 0;
                                 if(var45 < 25) {
                                    var46 = var45 - 25;
                                 } else if(var45 > 125) {
                                    var46 = var45 - 125;
                                 }

                                 class79.method1849(var48, var20 + client.field396 - class32.field758.field3188 - 1, var21 + var48, 5 + client.field396 + var20);
                                 class32.field758.method4073(var47, client.field395 + var48, var46 + client.field396 + var20, var44, 0);
                                 class79.method1848(var48, var20, var21 + var48, var22 + var20);
                              }
                           } else {
                              class32.field758.method4073(var47, var48 + client.field395, var20 + client.field396, 16776960, 0);
                           }
                        }

                        class164.method3258(var48, var20);
                        ((class95)class91.field1594).method2236(client.field366);
                        class26.method676(var48, var20, var21, var22);
                        class216.field3160 = var25;
                        class1.field27 = var26;
                        class26.field665 = var27;
                        class134.field2082 = var28;
                        class42.field1018 = var29;
                        if(client.field300) {
                           byte var64 = 0;
                           var34 = var64 + class171.field2730 + class171.field2714;
                           if(var34 == 0) {
                              client.field300 = false;
                           }
                        }

                        if(client.field300) {
                           class79.method1854(var48, var20, var21, var22, 0);
                           class33.method747("Loading - please wait.", false);
                        }

                        client.field516[var10.field2885] = true;
                        class79.method1848(var2, var3, var4, var5);
                        continue;
                     }

                     if(var10.field2758 == 1338) {
                        class43.method946(var10, var12, var13, var11);
                        class79.method1848(var2, var3, var4, var5);
                        continue;
                     }

                     if(var10.field2758 == 1339) {
                        class108.method2468(var10, var12, var13, var11);
                        class79.method1848(var2, var3, var4, var5);
                        continue;
                     }
                  }

                  if(var10.field2798 == 0) {
                     if(!var10.field2860 && class6.method107(var10) && var10 != class59.field1234) {
                        continue;
                     }

                     if(!var10.field2860) {
                        if(var10.field2776 > var10.field2778 - var10.field2888) {
                           var10.field2776 = var10.field2778 - var10.field2888;
                        }

                        if(var10.field2776 < 0) {
                           var10.field2776 = 0;
                        }
                     }

                     method1020(var0, var10.field2869, var15, var16, var17, var18, var12 - var10.field2878, var13 - var10.field2776, var11);
                     if(null != var10.field2767) {
                        method1020(var10.field2767, var10.field2869, var15, var16, var17, var18, var12 - var10.field2878, var13 - var10.field2776, var11);
                     }

                     class3 var19 = (class3)client.field448.method3822((long)var10.field2869);
                     if(null != var19) {
                        class84.method1965(var19.field64, var15, var16, var17, var18, var12, var13, var11);
                     }

                     class79.method1848(var2, var3, var4, var5);
                     class91.method2151();
                  }

                  if(client.field501 || client.field427[var11] || client.field336 > 1) {
                     if(var10.field2798 == 0 && !var10.field2860 && var10.field2778 > var10.field2888) {
                        class0.method0(var10.field2769 + var12, var13, var10.field2776, var10.field2888, var10.field2778);
                     }

                     if(var10.field2798 != 1) {
                        int var23;
                        if(var10.field2798 == 2) {
                           var48 = 0;

                           for(var20 = 0; var20 < var10.field2863; ++var20) {
                              for(var21 = 0; var21 < var10.field2825; ++var21) {
                                 var22 = (var10.field2820 + 32) * var21 + var12;
                                 var23 = var13 + var20 * (32 + var10.field2821);
                                 if(var48 < 20) {
                                    var22 += var10.field2822[var48];
                                    var23 += var10.field2823[var48];
                                 }

                                 if(var10.field2889[var48] <= 0) {
                                    if(var10.field2824 != null && var48 < 20) {
                                       class78 var70 = var10.method3434(var48);
                                       if(null != var70) {
                                          var70.method1763(var22, var23);
                                       } else if(class173.field2752) {
                                          class39.method818(var10);
                                       }
                                    }
                                 } else {
                                    boolean var61 = false;
                                    boolean var62 = false;
                                    var26 = var10.field2889[var48] - 1;
                                    if(32 + var22 > var2 && var22 < var4 && var23 + 32 > var3 && var23 < var5 || var10 == class167.field2675 && client.field403 == var48) {
                                       class78 var55;
                                       if(client.field353 == 1 && class42.field1016 == var48 && var10.field2869 == class110.field1956) {
                                          var55 = class137.method2954(var26, var10.field2750[var48], 2, 0, 2, false);
                                       } else {
                                          var55 = class137.method2954(var26, var10.field2750[var48], 1, 3153952, 2, false);
                                       }

                                       if(var55 != null) {
                                          if(class167.field2675 == var10 && client.field403 == var48) {
                                             var24 = class140.field2146 - client.field504;
                                             var25 = class140.field2151 - client.field405;
                                             if(var24 < 5 && var24 > -5) {
                                                var24 = 0;
                                             }

                                             if(var25 < 5 && var25 > -5) {
                                                var25 = 0;
                                             }

                                             if(client.field471 < 5) {
                                                var24 = 0;
                                                var25 = 0;
                                             }

                                             var55.method1816(var24 + var22, var23 + var25, 128);
                                             if(var1 != -1) {
                                                class173 var49 = var0[var1 & '\uffff'];
                                                if(var25 + var23 < class79.field1422 && var49.field2776 > 0) {
                                                   var29 = (class79.field1422 - var23 - var25) * client.field366 / 3;
                                                   if(var29 > client.field366 * 10) {
                                                      var29 = client.field366 * 10;
                                                   }

                                                   if(var29 > var49.field2776) {
                                                      var29 = var49.field2776;
                                                   }

                                                   var49.field2776 -= var29;
                                                   client.field405 += var29;
                                                   class39.method818(var49);
                                                }

                                                if(var25 + var23 + 32 > class79.field1423 && var49.field2776 < var49.field2778 - var49.field2888) {
                                                   var29 = client.field366 * (32 + var25 + var23 - class79.field1423) / 3;
                                                   if(var29 > client.field366 * 10) {
                                                      var29 = client.field366 * 10;
                                                   }

                                                   if(var29 > var49.field2778 - var49.field2888 - var49.field2776) {
                                                      var29 = var49.field2778 - var49.field2888 - var49.field2776;
                                                   }

                                                   var49.field2776 += var29;
                                                   client.field405 -= var29;
                                                   class39.method818(var49);
                                                }
                                             }
                                          } else if(var10 == class59.field1225 && client.field402 == var48) {
                                             var55.method1816(var22, var23, 128);
                                          } else {
                                             var55.method1763(var22, var23);
                                          }
                                       } else {
                                          class39.method818(var10);
                                       }
                                    }
                                 }

                                 ++var48;
                              }
                           }
                        } else if(var10.field2798 == 3) {
                           if(class17.method199(var10)) {
                              var48 = var10.field2780;
                              if(var10 == class59.field1234 && var10.field2782 != 0) {
                                 var48 = var10.field2782;
                              }
                           } else {
                              var48 = var10.field2779;
                              if(class59.field1234 == var10 && var10.field2781 != 0) {
                                 var48 = var10.field2781;
                              }
                           }

                           if(var10.field2842) {
                              switch(var10.field2784.field1440) {
                              case 1:
                                 class79.method1845(var12, var13, var10.field2769, var10.field2888, var10.field2779, var10.field2780, 256 - (var10.field2785 & 255), 256 - (var10.field2839 & 255));
                                 break;
                              case 2:
                                 class79.method1856(var12, var13, var10.field2769, var10.field2888, var10.field2779, var10.field2780, 256 - (var10.field2785 & 255), 256 - (var10.field2839 & 255));
                                 break;
                              case 3:
                                 class79.method1872(var12, var13, var10.field2769, var10.field2888, var10.field2779, var10.field2780, 256 - (var10.field2785 & 255), 256 - (var10.field2839 & 255));
                                 break;
                              case 4:
                                 class79.method1883(var12, var13, var10.field2769, var10.field2888, var10.field2779, var10.field2780, 256 - (var10.field2785 & 255), 256 - (var10.field2839 & 255));
                                 break;
                              default:
                                 if(var14 == 0) {
                                    class79.method1854(var12, var13, var10.field2769, var10.field2888, var48);
                                 } else {
                                    class79.method1853(var12, var13, var10.field2769, var10.field2888, var48, 256 - (var14 & 255));
                                 }
                              }
                           } else if(var14 == 0) {
                              class79.method1860(var12, var13, var10.field2769, var10.field2888, var48);
                           } else {
                              class79.method1861(var12, var13, var10.field2769, var10.field2888, var48, 256 - (var14 & 255));
                           }
                        } else {
                           class224 var57;
                           if(var10.field2798 == 4) {
                              var57 = var10.method3433();
                              if(var57 == null) {
                                 if(class173.field2752) {
                                    class39.method818(var10);
                                 }
                              } else {
                                 String var68 = var10.field2814;
                                 if(class17.method199(var10)) {
                                    var20 = var10.field2780;
                                    if(class59.field1234 == var10 && var10.field2782 != 0) {
                                       var20 = var10.field2782;
                                    }

                                    if(var10.field2815.length() > 0) {
                                       var68 = var10.field2815;
                                    }
                                 } else {
                                    var20 = var10.field2779;
                                    if(class59.field1234 == var10 && var10.field2781 != 0) {
                                       var20 = var10.field2781;
                                    }
                                 }

                                 if(var10.field2860 && var10.field2764 != -1) {
                                    class51 var71 = class141.method3001(var10.field2764);
                                    var68 = var71.field1128;
                                    if(var68 == null) {
                                       var68 = "null";
                                    }

                                    if((var71.field1151 == 1 || var10.field2794 != 1) && var10.field2794 != -1) {
                                       var68 = class164.method3251(16748608) + var68 + "</col>" + " " + 'x' + class96.method2262(var10.field2794);
                                    }
                                 }

                                 if(var10 == client.field312) {
                                    class157 var10000 = (class157)null;
                                    var68 = "Please wait...";
                                    var20 = var10.field2779;
                                 }

                                 if(!var10.field2860) {
                                    var68 = class166.method3281(var68, var10);
                                 }

                                 var57.method4051(var68, var12, var13, var10.field2769, var10.field2888, var20, var10.field2819?0:-1, var10.field2817, var10.field2818, var10.field2816);
                              }
                           } else if(var10.field2798 == 5) {
                              class78 var58;
                              if(!var10.field2860) {
                                 var58 = var10.method3432(class17.method199(var10));
                                 if(var58 != null) {
                                    var58.method1763(var12, var13);
                                 } else if(class173.field2752) {
                                    class39.method818(var10);
                                 }
                              } else {
                                 if(var10.field2764 != -1) {
                                    var58 = class137.method2954(var10.field2764, var10.field2794, var10.field2793, var10.field2801, var10.field2812, false);
                                 } else {
                                    var58 = var10.method3432(false);
                                 }

                                 if(var58 == null) {
                                    if(class173.field2752) {
                                       class39.method818(var10);
                                    }
                                 } else {
                                    var20 = var58.field1412;
                                    var21 = var58.field1415;
                                    if(!var10.field2792) {
                                       var22 = var10.field2769 * 4096 / var20;
                                       if(var10.field2877 != 0) {
                                          var58.method1776(var10.field2769 / 2 + var12, var13 + var10.field2888 / 2, var10.field2877, var22);
                                       } else if(var14 != 0) {
                                          var58.method1771(var12, var13, var10.field2769, var10.field2888, 256 - (var14 & 255));
                                       } else if(var20 == var10.field2769 && var10.field2888 == var21) {
                                          var58.method1763(var12, var13);
                                       } else {
                                          var58.method1781(var12, var13, var10.field2769, var10.field2888);
                                       }
                                    } else {
                                       class79.method1849(var12, var13, var10.field2769 + var12, var10.field2888 + var13);
                                       var22 = (var10.field2769 + (var20 - 1)) / var20;
                                       var23 = (var21 - 1 + var10.field2888) / var21;

                                       for(var24 = 0; var24 < var22; ++var24) {
                                          for(var25 = 0; var25 < var23; ++var25) {
                                             if(var10.field2877 != 0) {
                                                var58.method1776(var12 + var24 * var20 + var20 / 2, var25 * var21 + var13 + var21 / 2, var10.field2877, 4096);
                                             } else if(var14 != 0) {
                                                var58.method1816(var20 * var24 + var12, var21 * var25 + var13, 256 - (var14 & 255));
                                             } else {
                                                var58.method1763(var24 * var20 + var12, var25 * var21 + var13);
                                             }
                                          }
                                       }

                                       class79.method1848(var2, var3, var4, var5);
                                    }
                                 }
                              }
                           } else {
                              class51 var51;
                              if(var10.field2798 == 6) {
                                 boolean var67 = class17.method199(var10);
                                 if(var67) {
                                    var20 = var10.field2783;
                                 } else {
                                    var20 = var10.field2756;
                                 }

                                 class105 var65 = null;
                                 var22 = 0;
                                 if(var10.field2764 != -1) {
                                    var51 = class141.method3001(var10.field2764);
                                    if(var51 != null) {
                                       var51 = var51.method1085(var10.field2794);
                                       var65 = var51.method1112(1);
                                       if(var65 != null) {
                                          var65.method2357();
                                          var22 = var65.field1468 / 2;
                                       } else {
                                          class39.method818(var10);
                                       }
                                    }
                                 } else if(var10.field2797 == 5) {
                                    if(var10.field2768 == 0) {
                                       var65 = client.field561.method3514((class42)null, -1, (class42)null, -1);
                                    } else {
                                       var65 = class15.field225.vmethod1968();
                                    }
                                 } else if(var20 == -1) {
                                    var65 = var10.method3469((class42)null, -1, var67, class15.field225.field36);
                                    if(null == var65 && class173.field2752) {
                                       class39.method818(var10);
                                    }
                                 } else {
                                    class42 var69 = class34.method768(var20);
                                    var65 = var10.method3469(var69, var10.field2876, var67, class15.field225.field36);
                                    if(var65 == null && class173.field2752) {
                                       class39.method818(var10);
                                    }
                                 }

                                 class91.method2145(var12 + var10.field2769 / 2, var13 + var10.field2888 / 2);
                                 var23 = var10.field2874 * class91.field1597[var10.field2805] >> 16;
                                 var24 = class91.field1577[var10.field2805] * var10.field2874 >> 16;
                                 if(null != var65) {
                                    if(!var10.field2860) {
                                       var65.method2367(0, var10.field2806, 0, var10.field2805, 0, var23, var24);
                                    } else {
                                       var65.method2357();
                                       if(var10.field2811) {
                                          var65.method2368(0, var10.field2806, var10.field2746, var10.field2805, var10.field2803, var10.field2804 + var22 + var23, var24 + var10.field2804, var10.field2874);
                                       } else {
                                          var65.method2367(0, var10.field2806, var10.field2746, var10.field2805, var10.field2803, var22 + var23 + var10.field2804, var24 + var10.field2804);
                                       }
                                    }
                                 }

                                 class91.method2167();
                              } else {
                                 if(var10.field2798 == 7) {
                                    var57 = var10.method3433();
                                    if(var57 == null) {
                                       if(class173.field2752) {
                                          class39.method818(var10);
                                       }
                                       continue;
                                    }

                                    var20 = 0;

                                    for(var21 = 0; var21 < var10.field2863; ++var21) {
                                       for(var22 = 0; var22 < var10.field2825; ++var22) {
                                          if(var10.field2889[var20] > 0) {
                                             var51 = class141.method3001(var10.field2889[var20] - 1);
                                             String var53;
                                             if(var51.field1151 != 1 && var10.field2750[var20] == 1) {
                                                var53 = class164.method3251(16748608) + var51.field1128 + "</col>";
                                             } else {
                                                var53 = class164.method3251(16748608) + var51.field1128 + "</col>" + " " + 'x' + class96.method2262(var10.field2750[var20]);
                                             }

                                             var25 = var12 + (var10.field2820 + 115) * var22;
                                             var26 = (var10.field2821 + 12) * var21 + var13;
                                             if(var10.field2817 == 0) {
                                                var57.method4066(var53, var25, var26, var10.field2779, var10.field2819?0:-1);
                                             } else if(var10.field2817 == 1) {
                                                var57.method4073(var53, var10.field2769 / 2 + var25, var26, var10.field2779, var10.field2819?0:-1);
                                             } else {
                                                var57.method4105(var53, var10.field2769 + var25 - 1, var26, var10.field2779, var10.field2819?0:-1);
                                             }
                                          }

                                          ++var20;
                                       }
                                    }
                                 }

                                 if(var10.field2798 == 8 && var10 == class42.field1002 && client.field439 == client.field438) {
                                    var48 = 0;
                                    var20 = 0;
                                    class224 var50 = class36.field814;
                                    String var52 = var10.field2814;

                                    String var66;
                                    for(var52 = class166.method3281(var52, var10); var52.length() > 0; var20 += 1 + var50.field3188) {
                                       var24 = var52.indexOf("<br>");
                                       if(var24 != -1) {
                                          var66 = var52.substring(0, var24);
                                          var52 = var52.substring(var24 + 4);
                                       } else {
                                          var66 = var52;
                                          var52 = "";
                                       }

                                       var25 = var50.method4043(var66);
                                       if(var25 > var48) {
                                          var48 = var25;
                                       }
                                    }

                                    var48 += 6;
                                    var20 += 7;
                                    var24 = var12 + var10.field2769 - 5 - var48;
                                    var25 = var13 + var10.field2888 + 5;
                                    if(var24 < var12 + 5) {
                                       var24 = 5 + var12;
                                    }

                                    if(var24 + var48 > var4) {
                                       var24 = var4 - var48;
                                    }

                                    if(var25 + var20 > var5) {
                                       var25 = var5 - var20;
                                    }

                                    class79.method1854(var24, var25, var48, var20, 16777120);
                                    class79.method1860(var24, var25, var48, var20, 0);
                                    var52 = var10.field2814;
                                    var26 = var25 + var50.field3188 + 2;

                                    for(var52 = class166.method3281(var52, var10); var52.length() > 0; var26 += var50.field3188 + 1) {
                                       var27 = var52.indexOf("<br>");
                                       if(var27 != -1) {
                                          var66 = var52.substring(0, var27);
                                          var52 = var52.substring(var27 + 4);
                                       } else {
                                          var66 = var52;
                                          var52 = "";
                                       }

                                       var50.method4066(var66, var24 + 3, var26, 0, -1);
                                    }
                                 }

                                 if(var10.field2798 == 9) {
                                    if(var10.field2787 == 1) {
                                       if(var10.field2788) {
                                          var48 = var12;
                                          var20 = var13 + var10.field2888;
                                          var21 = var10.field2769 + var12;
                                          var22 = var13;
                                       } else {
                                          var48 = var12;
                                          var20 = var13;
                                          var21 = var12 + var10.field2769;
                                          var22 = var13 + var10.field2888;
                                       }

                                       class79.method1886(var48, var20, var21, var22, var10.field2779);
                                    } else {
                                       var48 = var10.field2769 >= 0?var10.field2769:-var10.field2769;
                                       var20 = var10.field2888 >= 0?var10.field2888:-var10.field2888;
                                       var21 = var48;
                                       if(var48 < var20) {
                                          var21 = var20;
                                       }

                                       if(var21 != 0) {
                                          var22 = (var10.field2769 << 16) / var21;
                                          var23 = (var10.field2888 << 16) / var21;
                                          if(var23 <= var22) {
                                             var22 = -var22;
                                          } else {
                                             var23 = -var23;
                                          }

                                          var24 = var23 * var10.field2787 >> 17;
                                          var25 = var23 * var10.field2787 + 1 >> 17;
                                          var26 = var10.field2787 * var22 >> 17;
                                          var27 = var10.field2787 * var22 + 1 >> 17;
                                          var28 = var12 + var24;
                                          var29 = var12 - var25;
                                          var30 = var10.field2769 + var12 - var25;
                                          var31 = var24 + var10.field2769 + var12;
                                          var32 = var26 + var13;
                                          var33 = var13 - var27;
                                          var34 = var10.field2888 + var13 - var27;
                                          var35 = var26 + var13 + var10.field2888;
                                          class91.method2185(var28, var29, var30);
                                          class91.method2153(var32, var33, var34, var28, var29, var30, var10.field2779);
                                          class91.method2185(var28, var30, var31);
                                          class91.method2153(var32, var34, var35, var28, var30, var31, var10.field2779);
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

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "([BZS)Ljava/lang/Object;",
      garbageValue = "-14792"
   )
   public static Object method1022(byte[] var0, boolean var1) {
      if(var0 == null) {
         return null;
      } else {
         if(var0.length > 136 && !class125.field2043) {
            try {
               class118 var2 = new class118();
               var2.vmethod2816(var0);
               return var2;
            } catch (Throwable var3) {
               class125.field2043 = true;
            }
         }

         return var0;
      }
   }
}
