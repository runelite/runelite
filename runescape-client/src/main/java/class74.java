import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bu")
public class class74 {
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 347979949
   )
   int field1349;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -2128189313
   )
   int field1350;
   @ObfuscatedName("e")
   int[][] field1351;

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "696907997"
   )
   int method1587(int var1) {
      if(this.field1351 != null) {
         var1 = (int)((long)this.field1350 * (long)var1 / (long)this.field1349);
      }

      return var1;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "1869463537"
   )
   int method1588(int var1) {
      if(this.field1351 != null) {
         var1 = 6 + (int)((long)var1 * (long)this.field1350 / (long)this.field1349);
      }

      return var1;
   }

   public class74(int var1, int var2) {
      if(var2 != var1) {
         int var3 = class40.method794(var1, var2);
         var1 /= var3;
         var2 /= var3;
         this.field1349 = var1;
         this.field1350 = var2;
         this.field1351 = new int[var1][14];

         for(int var4 = 0; var4 < var1; ++var4) {
            int[] var5 = this.field1351[var4];
            double var6 = 6.0D + (double)var4 / (double)var1;
            int var8 = (int)Math.floor(1.0D + (var6 - 7.0D));
            if(var8 < 0) {
               var8 = 0;
            }

            int var9 = (int)Math.ceil(7.0D + var6);
            if(var9 > 14) {
               var9 = 14;
            }

            for(double var10 = (double)var2 / (double)var1; var8 < var9; ++var8) {
               double var12 = 3.141592653589793D * ((double)var8 - var6);
               double var14 = var10;
               if(var12 < -1.0E-4D || var12 > 1.0E-4D) {
                  var14 = var10 * (Math.sin(var12) / var12);
               }

               var14 *= 0.54D + 0.46D * Math.cos(((double)var8 - var6) * 0.2243994752564138D);
               var5[var8] = (int)Math.floor(0.5D + 65536.0D * var14);
            }
         }

      }
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "([BI)[B",
      garbageValue = "-1350477868"
   )
   byte[] method1592(byte[] var1) {
      if(this.field1351 != null) {
         int var2 = (int)((long)var1.length * (long)this.field1350 / (long)this.field1349) + 14;
         int[] var3 = new int[var2];
         int var4 = 0;
         int var5 = 0;

         int var6;
         for(var6 = 0; var6 < var1.length; ++var6) {
            byte var7 = var1[var6];
            int[] var8 = this.field1351[var5];

            int var9;
            for(var9 = 0; var9 < 14; ++var9) {
               var3[var9 + var4] += var7 * var8[var9];
            }

            var5 += this.field1350;
            var9 = var5 / this.field1349;
            var4 += var9;
            var5 -= this.field1349 * var9;
         }

         var1 = new byte[var2];

         for(var6 = 0; var6 < var2; ++var6) {
            int var10 = var3[var6] + '耀' >> 16;
            if(var10 < -128) {
               var1[var6] = -128;
            } else if(var10 > 127) {
               var1[var6] = 127;
            } else {
               var1[var6] = (byte)var10;
            }
         }
      }

      return var1;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1967568451"
   )
   static void method1594() {
      for(class23 var0 = (class23)class23.field593.method3784(); null != var0; var0 = (class23)class23.field593.method3777()) {
         if(var0.field592 != null) {
            class135.field2066.method1133(var0.field592);
            var0.field592 = null;
         }

         if(null != var0.field597) {
            class135.field2066.method1133(var0.field597);
            var0.field597 = null;
         }
      }

      class23.field593.method3789();
   }

   @ObfuscatedName("cv")
   @ObfuscatedSignature(
      signature = "([Lclass173;IIIIIIII)V",
      garbageValue = "1776428034"
   )
   static final void method1595(class173[] var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      for(int var8 = 0; var8 < var0.length; ++var8) {
         class173 var9 = var0[var8];
         if(var9 != null && (!var9.field2768 || var9.field2820 == 0 || var9.field2809 || class144.method3075(var9) != 0 || client.field447 == var9 || 1338 == var9.field2748) && var9.field2763 == var1 && (!var9.field2768 || !class30.method659(var9))) {
            int var10 = var9.field2796 + var6;
            int var11 = var9.field2758 + var7;
            int var12;
            int var13;
            int var14;
            int var15;
            int var16;
            int var17;
            int var18;
            int var19;
            if(2 == var9.field2820) {
               var12 = var2;
               var13 = var3;
               var14 = var4;
               var15 = var5;
            } else if(9 == var9.field2820) {
               var16 = var10;
               var17 = var11;
               var18 = var10 + var9.field2840;
               var19 = var11 + var9.field2746;
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
               var16 = var9.field2840 + var10;
               var17 = var9.field2746 + var11;
               var12 = var10 > var2?var10:var2;
               var13 = var11 > var3?var11:var3;
               var14 = var16 < var4?var16:var4;
               var15 = var17 < var5?var17:var5;
            }

            if(var9 == client.field446) {
               client.field469 = true;
               client.field455 = var10;
               client.field456 = var11;
            }

            if(!var9.field2768 || var12 < var14 && var13 < var15) {
               var16 = class140.field2128;
               var17 = class140.field2126;
               if(class140.field2134 != 0) {
                  var16 = class140.field2135;
                  var17 = class140.field2136;
               }

               int var22;
               int var23;
               int var25;
               int var38;
               int var41;
               int var42;
               if(var9.field2748 == 1337) {
                  if(!client.field284 && !client.field453 && var16 >= var12 && var17 >= var13 && var16 < var14 && var17 < var15) {
                     if(client.field280 == 0 && !client.field511) {
                        class125.method2769("Walk here", "", 23, 0, var16 - var12, var17 - var13);
                     }

                     var18 = -1;
                     var19 = -1;

                     for(var38 = 0; var38 < class105.field1798; ++var38) {
                        var41 = class105.field1824[var38];
                        var22 = var41 & 127;
                        var23 = var41 >> 7 & 127;
                        var42 = var41 >> 29 & 3;
                        var25 = var41 >> 14 & 32767;
                        if(var41 != var19) {
                           var19 = var41;
                           if(2 == var42 && class35.field771.method2072(class28.field655, var22, var23, var41) >= 0) {
                              class40 var26 = class85.method1903(var25);
                              if(var26.field956 != null) {
                                 var26 = var26.method804();
                              }

                              if(var26 == null) {
                                 continue;
                              }

                              if(client.field280 == 1) {
                                 class125.method2769("Use", client.field427 + " " + "->" + " " + class219.method3968('\uffff') + var26.field925, 1, var41, var22, var23);
                              } else if(client.field511) {
                                 if(4 == (class11.field174 & 4)) {
                                    class125.method2769(client.field362, client.field313 + " " + "->" + " " + class219.method3968('\uffff') + var26.field925, 2, var41, var22, var23);
                                 }
                              } else {
                                 String[] var27 = var26.field926;
                                 if(client.field444) {
                                    var27 = class50.method1017(var27);
                                 }

                                 if(null != var27) {
                                    for(int var28 = 4; var28 >= 0; --var28) {
                                       if(null != var27[var28]) {
                                          short var29 = 0;
                                          if(0 == var28) {
                                             var29 = 3;
                                          }

                                          if(1 == var28) {
                                             var29 = 4;
                                          }

                                          if(2 == var28) {
                                             var29 = 5;
                                          }

                                          if(3 == var28) {
                                             var29 = 6;
                                          }

                                          if(var28 == 4) {
                                             var29 = 1001;
                                          }

                                          class125.method2769(var27[var28], class219.method3968('\uffff') + var26.field925, var29, var41, var22, var23);
                                       }
                                    }
                                 }

                                 class125.method2769("Examine", class219.method3968('\uffff') + var26.field925, 1002, var26.field924 << 14, var22, var23);
                              }
                           }

                           class2 var30;
                           int var46;
                           class34 var47;
                           int[] var48;
                           int var52;
                           if(1 == var42) {
                              class34 var43 = client.field517[var25];
                              if(var43 == null) {
                                 continue;
                              }

                              if(1 == var43.field761.field868 && 64 == (var43.field816 & 127) && 64 == (var43.field840 & 127)) {
                                 for(var46 = 0; var46 < client.field314; ++var46) {
                                    var47 = client.field517[client.field459[var46]];
                                    if(null != var47 && var47 != var43 && var47.field761.field868 == 1 && var43.field816 == var47.field816 && var43.field840 == var47.field840) {
                                       class90.method2085(var47.field761, client.field459[var46], var22, var23);
                                    }
                                 }

                                 var46 = class32.field737;
                                 var48 = class32.field738;

                                 for(var52 = 0; var52 < var46; ++var52) {
                                    var30 = client.field396[var48[var52]];
                                    if(var30 != null && var43.field816 == var30.field816 && var43.field840 == var30.field840) {
                                       class42.method880(var30, var48[var52], var22, var23);
                                    }
                                 }
                              }

                              class90.method2085(var43.field761, var25, var22, var23);
                           }

                           if(0 == var42) {
                              class2 var44 = client.field396[var25];
                              if(null == var44) {
                                 continue;
                              }

                              if((var44.field816 & 127) == 64 && 64 == (var44.field840 & 127)) {
                                 for(var46 = 0; var46 < client.field314; ++var46) {
                                    var47 = client.field517[client.field459[var46]];
                                    if(var47 != null && var47.field761.field868 == 1 && var44.field816 == var47.field816 && var47.field840 == var44.field840) {
                                       class90.method2085(var47.field761, client.field459[var46], var22, var23);
                                    }
                                 }

                                 var46 = class32.field737;
                                 var48 = class32.field738;

                                 for(var52 = 0; var52 < var46; ++var52) {
                                    var30 = client.field396[var48[var52]];
                                    if(null != var30 && var44 != var30 && var30.field816 == var44.field816 && var44.field840 == var30.field840) {
                                       class42.method880(var30, var48[var52], var22, var23);
                                    }
                                 }
                              }

                              if(client.field405 != var25) {
                                 class42.method880(var44, var25, var22, var23);
                              } else {
                                 var18 = var41;
                              }
                           }

                           if(var42 == 3) {
                              class199 var45 = client.field364[class28.field655][var22][var23];
                              if(null != var45) {
                                 for(class28 var49 = (class28)var45.method3785(); var49 != null; var49 = (class28)var45.method3787()) {
                                    class51 var50 = class89.method2081(var49.field662);
                                    if(client.field280 == 1) {
                                       class125.method2769("Use", client.field427 + " " + "->" + " " + class219.method3968(16748608) + var50.field1095, 16, var49.field662, var22, var23);
                                    } else if(client.field511) {
                                       if(1 == (class11.field174 & 1)) {
                                          class125.method2769(client.field362, client.field313 + " " + "->" + " " + class219.method3968(16748608) + var50.field1095, 17, var49.field662, var22, var23);
                                       }
                                    } else {
                                       String[] var53 = var50.field1088;
                                       if(client.field444) {
                                          var53 = class50.method1017(var53);
                                       }

                                       for(int var51 = 4; var51 >= 0; --var51) {
                                          if(var53 != null && null != var53[var51]) {
                                             byte var31 = 0;
                                             if(var51 == 0) {
                                                var31 = 18;
                                             }

                                             if(var51 == 1) {
                                                var31 = 19;
                                             }

                                             if(2 == var51) {
                                                var31 = 20;
                                             }

                                             if(3 == var51) {
                                                var31 = 21;
                                             }

                                             if(var51 == 4) {
                                                var31 = 22;
                                             }

                                             class125.method2769(var53[var51], class219.method3968(16748608) + var50.field1095, var31, var49.field662, var22, var23);
                                          } else if(var51 == 2) {
                                             class125.method2769("Take", class219.method3968(16748608) + var50.field1095, 20, var49.field662, var22, var23);
                                          }
                                       }

                                       class125.method2769("Examine", class219.method3968(16748608) + var50.field1095, 1004, var49.field662, var22, var23);
                                    }
                                 }
                              }
                           }
                        }
                     }

                     if(var18 != -1) {
                        var38 = var18 & 127;
                        var41 = var18 >> 7 & 127;
                        class2 var40 = client.field396[client.field405];
                        class42.method880(var40, client.field405, var38, var41);
                     }
                  }
               } else if(var9.field2748 == 1338) {
                  class8.method119(var9, var10, var11);
               } else {
                  if(!client.field453 && var16 >= var12 && var17 >= var13 && var16 < var14 && var17 < var15) {
                     class6.method100(var9, var16 - var10, var17 - var11);
                  }

                  if(var9.field2820 == 0) {
                     if(!var9.field2768 && class30.method659(var9) && class143.field2170 != var9) {
                        continue;
                     }

                     method1595(var0, var9.field2774, var12, var13, var14, var15, var10 - var9.field2765, var11 - var9.field2766);
                     if(var9.field2868 != null) {
                        method1595(var9.field2868, var9.field2774, var12, var13, var14, var15, var10 - var9.field2765, var11 - var9.field2766);
                     }

                     class3 var32 = (class3)client.field434.method3742((long)var9.field2774);
                     if(var32 != null) {
                        if(var32.field64 == 0 && class140.field2128 >= var12 && class140.field2126 >= var13 && class140.field2128 < var14 && class140.field2126 < var15 && !client.field453 && !client.field443) {
                           for(class0 var34 = (class0)client.field472.method3784(); null != var34; var34 = (class0)client.field472.method3777()) {
                              if(var34.field1) {
                                 var34.method3883();
                                 var34.field18.field2839 = false;
                              }
                           }

                           if(0 == class99.field1659) {
                              client.field446 = null;
                              client.field447 = null;
                           }

                           if(!client.field453) {
                              client.field420[0] = "Cancel";
                              client.field290[0] = "";
                              client.field418[0] = 1006;
                              client.field415 = 1;
                           }
                        }

                        class108.method2414(var32.field65, var12, var13, var14, var15, var10, var11);
                     }
                  }

                  if(var9.field2768) {
                     class0 var33;
                     if(!var9.field2877) {
                        if(var9.field2741 && class140.field2128 >= var12 && class140.field2126 >= var13 && class140.field2128 < var14 && class140.field2126 < var15) {
                           for(var33 = (class0)client.field472.method3784(); var33 != null; var33 = (class0)client.field472.method3777()) {
                              if(var33.field1 && var33.field16 == var33.field18.field2845) {
                                 var33.method3883();
                              }
                           }
                        }
                     } else if(class140.field2128 >= var12 && class140.field2126 >= var13 && class140.field2128 < var14 && class140.field2126 < var15) {
                        for(var33 = (class0)client.field472.method3784(); null != var33; var33 = (class0)client.field472.method3777()) {
                           if(var33.field1) {
                              var33.method3883();
                              var33.field18.field2839 = false;
                           }
                        }

                        if(class99.field1659 == 0) {
                           client.field446 = null;
                           client.field447 = null;
                        }

                        if(!client.field453) {
                           client.field420[0] = "Cancel";
                           client.field290[0] = "";
                           client.field418[0] = 1006;
                           client.field415 = 1;
                        }
                     }

                     boolean var35;
                     if(class140.field2128 >= var12 && class140.field2126 >= var13 && class140.field2128 < var14 && class140.field2126 < var15) {
                        var35 = true;
                     } else {
                        var35 = false;
                     }

                     boolean var36 = false;
                     if((class140.field2127 == 1 || !class139.field2116 && class140.field2127 == 4) && var35) {
                        var36 = true;
                     }

                     boolean var20 = false;
                     if((class140.field2134 == 1 || !class139.field2116 && class140.field2134 == 4) && class140.field2135 >= var12 && class140.field2136 >= var13 && class140.field2135 < var14 && class140.field2136 < var15) {
                        var20 = true;
                     }

                     if(var20) {
                        class119.method2701(var9, class140.field2135 - var10, class140.field2136 - var11);
                     }

                     if(client.field446 != null && client.field446 != var9 && var35) {
                        var22 = class144.method3075(var9);
                        boolean var21 = 0 != (var22 >> 20 & 1);
                        if(var21) {
                           client.field295 = var9;
                        }
                     }

                     if(client.field447 == var9) {
                        client.field451 = true;
                        client.field452 = var10;
                        client.field299 = var11;
                     }

                     if(var9.field2809) {
                        class0 var37;
                        if(var35 && client.field537 != 0 && var9.field2845 != null) {
                           var37 = new class0();
                           var37.field1 = true;
                           var37.field18 = var9;
                           var37.field4 = client.field537;
                           var37.field16 = var9.field2845;
                           client.field472.method3779(var37);
                        }

                        if(client.field446 != null || null != class35.field772 || client.field453) {
                           var20 = false;
                           var36 = false;
                           var35 = false;
                        }

                        if(!var9.field2870 && var20) {
                           var9.field2870 = true;
                           if(var9.field2826 != null) {
                              var37 = new class0();
                              var37.field1 = true;
                              var37.field18 = var9;
                              var37.field3 = class140.field2135 - var10;
                              var37.field4 = class140.field2136 - var11;
                              var37.field16 = var9.field2826;
                              client.field472.method3779(var37);
                           }
                        }

                        if(var9.field2870 && var36 && null != var9.field2827) {
                           var37 = new class0();
                           var37.field1 = true;
                           var37.field18 = var9;
                           var37.field3 = class140.field2128 - var10;
                           var37.field4 = class140.field2126 - var11;
                           var37.field16 = var9.field2827;
                           client.field472.method3779(var37);
                        }

                        if(var9.field2870 && !var36) {
                           var9.field2870 = false;
                           if(null != var9.field2828) {
                              var37 = new class0();
                              var37.field1 = true;
                              var37.field18 = var9;
                              var37.field3 = class140.field2128 - var10;
                              var37.field4 = class140.field2126 - var11;
                              var37.field16 = var9.field2828;
                              client.field340.method3779(var37);
                           }
                        }

                        if(var36 && null != var9.field2829) {
                           var37 = new class0();
                           var37.field1 = true;
                           var37.field18 = var9;
                           var37.field3 = class140.field2128 - var10;
                           var37.field4 = class140.field2126 - var11;
                           var37.field16 = var9.field2829;
                           client.field472.method3779(var37);
                        }

                        if(!var9.field2839 && var35) {
                           var9.field2839 = true;
                           if(var9.field2842 != null) {
                              var37 = new class0();
                              var37.field1 = true;
                              var37.field18 = var9;
                              var37.field3 = class140.field2128 - var10;
                              var37.field4 = class140.field2126 - var11;
                              var37.field16 = var9.field2842;
                              client.field472.method3779(var37);
                           }
                        }

                        if(var9.field2839 && var35 && null != var9.field2794) {
                           var37 = new class0();
                           var37.field1 = true;
                           var37.field18 = var9;
                           var37.field3 = class140.field2128 - var10;
                           var37.field4 = class140.field2126 - var11;
                           var37.field16 = var9.field2794;
                           client.field472.method3779(var37);
                        }

                        if(var9.field2839 && !var35) {
                           var9.field2839 = false;
                           if(var9.field2851 != null) {
                              var37 = new class0();
                              var37.field1 = true;
                              var37.field18 = var9;
                              var37.field3 = class140.field2128 - var10;
                              var37.field4 = class140.field2126 - var11;
                              var37.field16 = var9.field2851;
                              client.field340.method3779(var37);
                           }
                        }

                        if(null != var9.field2843) {
                           var37 = new class0();
                           var37.field18 = var9;
                           var37.field16 = var9.field2843;
                           client.field550.method3779(var37);
                        }

                        class0 var24;
                        if(var9.field2800 != null && client.field445 > var9.field2872) {
                           if(null != var9.field2838 && client.field445 - var9.field2872 <= 32) {
                              label1209:
                              for(var41 = var9.field2872; var41 < client.field445; ++var41) {
                                 var22 = client.field441[var41 & 31];

                                 for(var23 = 0; var23 < var9.field2838.length; ++var23) {
                                    if(var9.field2838[var23] == var22) {
                                       var24 = new class0();
                                       var24.field18 = var9;
                                       var24.field16 = var9.field2800;
                                       client.field472.method3779(var24);
                                       break label1209;
                                    }
                                 }
                              }
                           } else {
                              var37 = new class0();
                              var37.field18 = var9;
                              var37.field16 = var9.field2800;
                              client.field472.method3779(var37);
                           }

                           var9.field2872 = client.field445;
                        }

                        if(null != var9.field2769 && client.field462 > var9.field2831) {
                           if(var9.field2878 != null && client.field462 - var9.field2831 <= 32) {
                              label1185:
                              for(var41 = var9.field2831; var41 < client.field462; ++var41) {
                                 var22 = client.field461[var41 & 31];

                                 for(var23 = 0; var23 < var9.field2878.length; ++var23) {
                                    if(var22 == var9.field2878[var23]) {
                                       var24 = new class0();
                                       var24.field18 = var9;
                                       var24.field16 = var9.field2769;
                                       client.field472.method3779(var24);
                                       break label1185;
                                    }
                                 }
                              }
                           } else {
                              var37 = new class0();
                              var37.field18 = var9;
                              var37.field16 = var9.field2769;
                              client.field472.method3779(var37);
                           }

                           var9.field2831 = client.field462;
                        }

                        if(null != var9.field2841 && client.field496 > var9.field2874) {
                           if(var9.field2764 != null && client.field496 - var9.field2874 <= 32) {
                              label1161:
                              for(var41 = var9.field2874; var41 < client.field496; ++var41) {
                                 var22 = client.field463[var41 & 31];

                                 for(var23 = 0; var23 < var9.field2764.length; ++var23) {
                                    if(var9.field2764[var23] == var22) {
                                       var24 = new class0();
                                       var24.field18 = var9;
                                       var24.field16 = var9.field2841;
                                       client.field472.method3779(var24);
                                       break label1161;
                                    }
                                 }
                              }
                           } else {
                              var37 = new class0();
                              var37.field18 = var9;
                              var37.field16 = var9.field2841;
                              client.field472.method3779(var37);
                           }

                           var9.field2874 = client.field496;
                        }

                        if(client.field500 > var9.field2871 && null != var9.field2744) {
                           var37 = new class0();
                           var37.field18 = var9;
                           var37.field16 = var9.field2744;
                           client.field472.method3779(var37);
                        }

                        if(client.field466 > var9.field2871 && null != var9.field2855) {
                           var37 = new class0();
                           var37.field18 = var9;
                           var37.field16 = var9.field2855;
                           client.field472.method3779(var37);
                        }

                        if(client.field467 > var9.field2871 && null != var9.field2835) {
                           var37 = new class0();
                           var37.field18 = var9;
                           var37.field16 = var9.field2835;
                           client.field472.method3779(var37);
                        }

                        if(client.field468 > var9.field2871 && var9.field2854 != null) {
                           var37 = new class0();
                           var37.field18 = var9;
                           var37.field16 = var9.field2854;
                           client.field472.method3779(var37);
                        }

                        if(client.field484 > var9.field2871 && null != var9.field2830) {
                           var37 = new class0();
                           var37.field18 = var9;
                           var37.field16 = var9.field2830;
                           client.field472.method3779(var37);
                        }

                        if(client.field470 > var9.field2871 && null != var9.field2850) {
                           var37 = new class0();
                           var37.field18 = var9;
                           var37.field16 = var9.field2850;
                           client.field472.method3779(var37);
                        }

                        var9.field2871 = client.field458;
                        if(null != var9.field2785) {
                           for(var41 = 0; var41 < client.field410; ++var41) {
                              class0 var39 = new class0();
                              var39.field18 = var9;
                              var39.field8 = client.field498[var41];
                              var39.field0 = client.field497[var41];
                              var39.field16 = var9.field2785;
                              client.field472.method3779(var39);
                           }
                        }
                     }
                  }

                  if(!var9.field2768 && client.field446 == null && class35.field772 == null && !client.field453) {
                     if((var9.field2859 >= 0 || 0 != var9.field2771) && class140.field2128 >= var12 && class140.field2126 >= var13 && class140.field2128 < var14 && class140.field2126 < var15) {
                        if(var9.field2859 >= 0) {
                           class143.field2170 = var0[var9.field2859];
                        } else {
                           class143.field2170 = var9;
                        }
                     }

                     if(var9.field2820 == 8 && class140.field2128 >= var12 && class140.field2126 >= var13 && class140.field2128 < var14 && class140.field2126 < var15) {
                        class0.field14 = var9;
                     }

                     if(var9.field2784 > var9.field2746) {
                        var18 = var9.field2840 + var10;
                        var19 = var9.field2746;
                        var38 = var9.field2784;
                        var41 = class140.field2128;
                        var22 = class140.field2126;
                        if(client.field422) {
                           client.field358 = 32;
                        } else {
                           client.field358 = 0;
                        }

                        client.field422 = false;
                        if(1 == class140.field2127 || !class139.field2116 && 4 == class140.field2127) {
                           if(var41 >= var18 && var41 < 16 + var18 && var22 >= var11 && var22 < 16 + var11) {
                              var9.field2766 -= 4;
                              class2.method28(var9);
                           } else if(var41 >= var18 && var41 < 16 + var18 && var22 >= var19 + var11 - 16 && var22 < var19 + var11) {
                              var9.field2766 += 4;
                              class2.method28(var9);
                           } else if(var41 >= var18 - client.field358 && var41 < client.field358 + var18 + 16 && var22 >= var11 + 16 && var22 < var19 + var11 - 16) {
                              var23 = (var19 - 32) * var19 / var38;
                              if(var23 < 8) {
                                 var23 = 8;
                              }

                              var42 = var22 - var11 - 16 - var23 / 2;
                              var25 = var19 - 32 - var23;
                              var9.field2766 = (var38 - var19) * var42 / var25;
                              class2.method28(var9);
                              client.field422 = true;
                           }
                        }

                        if(0 != client.field537) {
                           var23 = var9.field2840;
                           if(var41 >= var18 - var23 && var22 >= var11 && var41 < 16 + var18 && var22 <= var11 + var19) {
                              var9.field2766 += client.field537 * 45;
                              class2.method28(var9);
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
