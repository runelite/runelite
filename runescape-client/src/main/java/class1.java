import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("g")
public class class1 {
   @ObfuscatedName("cv")
   @ObfuscatedSignature(
      signature = "([Lclass173;IIIIIIIB)V",
      garbageValue = "-48"
   )
   static final void method4(class173[] var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      for(int var8 = 0; var8 < var0.length; ++var8) {
         class173 var9 = var0[var8];
         if(var9 != null && (!var9.field2741 || var9.field2833 == 0 || var9.field2767 || class34.method734(var9) != 0 || client.field461 == var9 || var9.field2768 == 1338) && var1 == var9.field2777 && (!var9.field2741 || !class12.method150(var9))) {
            int var10 = var9.field2796 + var6;
            int var11 = var9.field2823 + var7;
            int var12;
            int var13;
            int var14;
            int var15;
            int var16;
            int var17;
            int var18;
            int var19;
            if(var9.field2833 == 2) {
               var12 = var2;
               var13 = var3;
               var14 = var4;
               var15 = var5;
            } else if(var9.field2833 == 9) {
               var16 = var10;
               var17 = var11;
               var18 = var10 + var9.field2763;
               var19 = var11 + var9.field2764;
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
               var16 = var9.field2763 + var10;
               var17 = var9.field2764 + var11;
               var12 = var10 > var2?var10:var2;
               var13 = var11 > var3?var11:var3;
               var14 = var16 < var4?var16:var4;
               var15 = var17 < var5?var17:var5;
            }

            if(client.field460 == var9) {
               client.field341 = true;
               client.field438 = var10;
               client.field470 = var11;
            }

            if(!var9.field2741 || var12 < var14 && var13 < var15) {
               var16 = class140.field2134;
               var17 = class140.field2135;
               if(class140.field2140 != 0) {
                  var16 = class140.field2141;
                  var17 = class140.field2142;
               }

               if(var9.field2768 == 1337) {
                  if(!client.field295 && !client.field428 && var16 >= var12 && var17 >= var13 && var16 < var14 && var17 < var15) {
                     class90.method2091(var16, var17, var12, var13);
                  }
               } else {
                  int var20;
                  int var23;
                  int var33;
                  int var34;
                  int var35;
                  if(var9.field2768 == 1338) {
                     if((client.field493 == 0 || client.field493 == 3) && (class140.field2140 == 1 || !class161.field2631 && class140.field2140 == 4)) {
                        class175 var46 = var9.method3409(true);
                        if(null != var46) {
                           var19 = class140.field2141 - var10;
                           var20 = class140.field2142 - var11;
                           if(var46.method3452(var19, var20)) {
                              var19 -= var46.field2888 / 2;
                              var20 -= var46.field2889 / 2;
                              var34 = client.field322 + client.field360 & 2047;
                              var33 = class91.field1563[var34];
                              var23 = class91.field1564[var34];
                              var33 = (256 + client.field558) * var33 >> 8;
                              var23 = var23 * (client.field558 + 256) >> 8;
                              var35 = var33 * var20 + var19 * var23 >> 11;
                              int var36 = var23 * var20 - var33 * var19 >> 11;
                              int var37 = var35 + class153.field2262.field813 >> 7;
                              int var44 = class153.field2262.field791 - var36 >> 7;
                              client.field331.method2781(68);
                              client.field331.method2650(18);
                              client.field331.method2538(class137.field2095[82]?(class137.field2095[81]?2:1):0);
                              client.field331.method2545(var37 + class4.field62);
                              client.field331.method2695(class85.field1434 + var44);
                              client.field331.method2650(var19);
                              client.field331.method2650(var20);
                              client.field331.method2695(client.field322);
                              client.field331.method2650(57);
                              client.field331.method2650(client.field360);
                              client.field331.method2650(client.field558);
                              client.field331.method2650(89);
                              client.field331.method2695(class153.field2262.field813);
                              client.field331.method2695(class153.field2262.field791);
                              client.field331.method2650(63);
                              client.field521 = var37;
                              client.field522 = var44;
                           }
                        }
                     }
                  } else {
                     if(!client.field428 && var16 >= var12 && var17 >= var13 && var16 < var14 && var17 < var15) {
                        var18 = var16 - var10;
                        var19 = var17 - var11;
                        if(var9.field2751 == 1) {
                           class217.method3974(var9.field2865, "", 24, 0, 0, var9.field2748);
                        }

                        String var38;
                        if(var9.field2751 == 2 && !client.field442) {
                           if(class116.method2461(class34.method734(var9)) == 0) {
                              var38 = null;
                           } else if(var9.field2869 != null && var9.field2869.trim().length() != 0) {
                              var38 = var9.field2869;
                           } else {
                              var38 = null;
                           }

                           if(null != var38) {
                              class217.method3974(var38, class158.method3184('\uff00') + var9.field2786, 25, 0, -1, var9.field2748);
                           }
                        }

                        if(var9.field2751 == 3) {
                           class217.method3974("Close", "", 26, 0, 0, var9.field2748);
                        }

                        if(var9.field2751 == 4) {
                           class217.method3974(var9.field2865, "", 28, 0, 0, var9.field2748);
                        }

                        if(var9.field2751 == 5) {
                           class217.method3974(var9.field2865, "", 29, 0, 0, var9.field2748);
                        }

                        if(var9.field2751 == 6 && null == client.field451) {
                           class217.method3974(var9.field2865, "", 30, 0, -1, var9.field2748);
                        }

                        class178 var10000;
                        if(var9.field2833 == 2) {
                           var20 = 0;

                           for(var34 = 0; var34 < var9.field2764; ++var34) {
                              for(var33 = 0; var33 < var9.field2763; ++var33) {
                                 var23 = (32 + var9.field2814) * var33;
                                 var35 = var34 * (var9.field2815 + 32);
                                 if(var20 < 20) {
                                    var23 += var9.field2816[var20];
                                    var35 += var9.field2817[var20];
                                 }

                                 if(var18 >= var23 && var19 >= var35 && var18 < 32 + var23 && var19 < var35 + 32) {
                                    client.field320 = var20;
                                    class119.field1983 = var9;
                                    if(var9.field2866[var20] > 0) {
                                       class51 var25 = class35.method741(var9.field2866[var20] - 1);
                                       if(client.field352 == 1 && class154.method3174(class34.method734(var9))) {
                                          if(var9.field2748 != class0.field11 || var20 != class72.field1325) {
                                             class217.method3974("Use", client.field349 + " " + "->" + " " + class158.method3184(16748608) + var25.field1090, 31, var25.field1092, var20, var9.field2748);
                                          }
                                       } else if(client.field442 && class154.method3174(class34.method734(var9))) {
                                          if((class138.field2115 & 16) == 16) {
                                             class217.method3974(client.field445, client.field446 + " " + "->" + " " + class158.method3184(16748608) + var25.field1090, 32, var25.field1092, var20, var9.field2748);
                                          }
                                       } else {
                                          String[] var26 = var25.field1105;
                                          if(client.field439) {
                                             var26 = class0.method1(var26);
                                          }

                                          int var28 = class34.method734(var9);
                                          boolean var27 = (var28 >> 30 & 1) != 0;
                                          int var29;
                                          byte var30;
                                          if(var27) {
                                             for(var29 = 4; var29 >= 3; --var29) {
                                                if(null != var26 && null != var26[var29]) {
                                                   if(var29 == 3) {
                                                      var30 = 36;
                                                   } else {
                                                      var30 = 37;
                                                   }

                                                   class217.method3974(var26[var29], class158.method3184(16748608) + var25.field1090, var30, var25.field1092, var20, var9.field2748);
                                                } else if(var29 == 4) {
                                                   class217.method3974("Drop", class158.method3184(16748608) + var25.field1090, 37, var25.field1092, var20, var9.field2748);
                                                }
                                             }
                                          }

                                          var10000 = (class178)null;
                                          if(class26.method634(class34.method734(var9))) {
                                             class217.method3974("Use", class158.method3184(16748608) + var25.field1090, 38, var25.field1092, var20, var9.field2748);
                                          }

                                          var10000 = (class178)null;
                                          if(class154.method3174(class34.method734(var9)) && null != var26) {
                                             for(var29 = 2; var29 >= 0; --var29) {
                                                if(null != var26[var29]) {
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

                                                   class217.method3974(var26[var29], class158.method3184(16748608) + var25.field1090, var30, var25.field1092, var20, var9.field2748);
                                                }
                                             }
                                          }

                                          var26 = var9.field2819;
                                          if(client.field439) {
                                             var26 = class0.method1(var26);
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

                                                   class217.method3974(var26[var29], class158.method3184(16748608) + var25.field1090, var30, var25.field1092, var20, var9.field2748);
                                                }
                                             }
                                          }

                                          class217.method3974("Examine", class158.method3184(16748608) + var25.field1090, 1005, var25.field1092, var20, var9.field2748);
                                       }
                                    }
                                 }

                                 ++var20;
                              }
                           }
                        }

                        if(var9.field2741) {
                           if(client.field442) {
                              if(class173.method3450(class34.method734(var9)) && (class138.field2115 & 32) == 32) {
                                 class217.method3974(client.field445, client.field446 + " " + "->" + " " + var9.field2760, 58, 0, var9.field2749, var9.field2748);
                              }
                           } else {
                              for(var20 = 9; var20 >= 5; --var20) {
                                 String var21 = class8.method113(var9, var20);
                                 if(var21 != null) {
                                    class217.method3974(var21, var9.field2760, 1007, var20 + 1, var9.field2749, var9.field2748);
                                 }
                              }

                              if(class116.method2461(class34.method734(var9)) == 0) {
                                 var38 = null;
                              } else if(var9.field2869 != null && var9.field2869.trim().length() != 0) {
                                 var38 = var9.field2869;
                              } else {
                                 var38 = null;
                              }

                              var10000 = null;

                              for(var33 = 4; var33 >= 0; --var33) {
                                 String var39 = class8.method113(var9, var33);
                                 if(null != var39) {
                                    class217.method3974(var39, var9.field2760, 57, var33 + 1, var9.field2749, var9.field2748);
                                 }
                              }

                              if(class29.method662(class34.method734(var9))) {
                                 class217.method3974("Continue", "", 30, 0, var9.field2749, var9.field2748);
                              }
                           }
                        }
                     }

                     if(var9.field2833 == 0) {
                        if(!var9.field2741 && class12.method150(var9) && var9 != class172.field2732) {
                           continue;
                        }

                        method4(var0, var9.field2748, var12, var13, var14, var15, var10 - var9.field2863, var11 - var9.field2770);
                        if(null != var9.field2872) {
                           method4(var9.field2872, var9.field2748, var12, var13, var14, var15, var10 - var9.field2863, var11 - var9.field2770);
                        }

                        class3 var32 = (class3)client.field448.method3807((long)var9.field2748);
                        if(null != var32) {
                           if(var32.field54 == 0 && class140.field2134 >= var12 && class140.field2135 >= var13 && class140.field2134 < var14 && class140.field2135 < var15 && !client.field428 && !client.field336) {
                              for(class0 var31 = (class0)client.field486.method3844(); null != var31; var31 = (class0)client.field486.method3834()) {
                                 if(var31.field1) {
                                    var31.method3916();
                                    var31.field10.field2873 = false;
                                 }
                              }

                              if(class103.field1755 == 0) {
                                 client.field460 = null;
                                 client.field461 = null;
                              }

                              if(!client.field428) {
                                 client.field434[0] = "Cancel";
                                 client.field396[0] = "";
                                 client.field432[0] = 1006;
                                 client.field429 = 1;
                              }
                           }

                           class19.method220(var32.field60, var12, var13, var14, var15, var10, var11);
                        }
                     }

                     if(var9.field2741) {
                        class0 var45;
                        if(!var9.field2761) {
                           if(var9.field2737 && class140.field2134 >= var12 && class140.field2135 >= var13 && class140.field2134 < var14 && class140.field2135 < var15) {
                              for(var45 = (class0)client.field486.method3844(); null != var45; var45 = (class0)client.field486.method3834()) {
                                 if(var45.field1 && var45.field10.field2837 == var45.field12) {
                                    var45.method3916();
                                 }
                              }
                           }
                        } else if(class140.field2134 >= var12 && class140.field2135 >= var13 && class140.field2134 < var14 && class140.field2135 < var15) {
                           for(var45 = (class0)client.field486.method3844(); null != var45; var45 = (class0)client.field486.method3834()) {
                              if(var45.field1) {
                                 var45.method3916();
                                 var45.field10.field2873 = false;
                              }
                           }

                           if(class103.field1755 == 0) {
                              client.field460 = null;
                              client.field461 = null;
                           }

                           if(!client.field428) {
                              client.field434[0] = "Cancel";
                              client.field396[0] = "";
                              client.field432[0] = 1006;
                              client.field429 = 1;
                           }
                        }

                        boolean var40;
                        if(class140.field2134 >= var12 && class140.field2135 >= var13 && class140.field2134 < var14 && class140.field2135 < var15) {
                           var40 = true;
                        } else {
                           var40 = false;
                        }

                        boolean var41 = false;
                        if((class140.field2133 == 1 || !class161.field2631 && class140.field2133 == 4) && var40) {
                           var41 = true;
                        }

                        boolean var42 = false;
                        if((class140.field2140 == 1 || !class161.field2631 && class140.field2140 == 4) && class140.field2141 >= var12 && class140.field2142 >= var13 && class140.field2141 < var14 && class140.field2142 < var15) {
                           var42 = true;
                        }

                        if(var42) {
                           class165.method3250(var9, class140.field2141 - var10, class140.field2142 - var11);
                        }

                        if(client.field460 != null && var9 != client.field460 && var40 && class12.method154(class34.method734(var9))) {
                           client.field464 = var9;
                        }

                        if(var9 == client.field461) {
                           client.field465 = true;
                           client.field440 = var10;
                           client.field447 = var11;
                        }

                        if(var9.field2767) {
                           class0 var43;
                           if(var40 && client.field485 != 0 && var9.field2837 != null) {
                              var43 = new class0();
                              var43.field1 = true;
                              var43.field10 = var9;
                              var43.field4 = client.field485;
                              var43.field12 = var9.field2837;
                              client.field486.method3819(var43);
                           }

                           if(client.field460 != null || class38.field849 != null || client.field428) {
                              var42 = false;
                              var41 = false;
                              var40 = false;
                           }

                           if(!var9.field2874 && var42) {
                              var9.field2874 = true;
                              if(null != var9.field2827) {
                                 var43 = new class0();
                                 var43.field1 = true;
                                 var43.field10 = var9;
                                 var43.field3 = class140.field2141 - var10;
                                 var43.field4 = class140.field2142 - var11;
                                 var43.field12 = var9.field2827;
                                 client.field486.method3819(var43);
                              }
                           }

                           if(var9.field2874 && var41 && var9.field2758 != null) {
                              var43 = new class0();
                              var43.field1 = true;
                              var43.field10 = var9;
                              var43.field3 = class140.field2134 - var10;
                              var43.field4 = class140.field2135 - var11;
                              var43.field12 = var9.field2758;
                              client.field486.method3819(var43);
                           }

                           if(var9.field2874 && !var41) {
                              var9.field2874 = false;
                              if(null != var9.field2832) {
                                 var43 = new class0();
                                 var43.field1 = true;
                                 var43.field10 = var9;
                                 var43.field3 = class140.field2134 - var10;
                                 var43.field4 = class140.field2135 - var11;
                                 var43.field12 = var9.field2832;
                                 client.field488.method3819(var43);
                              }
                           }

                           if(var41 && null != var9.field2875) {
                              var43 = new class0();
                              var43.field1 = true;
                              var43.field10 = var9;
                              var43.field3 = class140.field2134 - var10;
                              var43.field4 = class140.field2135 - var11;
                              var43.field12 = var9.field2875;
                              client.field486.method3819(var43);
                           }

                           if(!var9.field2873 && var40) {
                              var9.field2873 = true;
                              if(null != var9.field2834) {
                                 var43 = new class0();
                                 var43.field1 = true;
                                 var43.field10 = var9;
                                 var43.field3 = class140.field2134 - var10;
                                 var43.field4 = class140.field2135 - var11;
                                 var43.field12 = var9.field2834;
                                 client.field486.method3819(var43);
                              }
                           }

                           if(var9.field2873 && var40 && var9.field2864 != null) {
                              var43 = new class0();
                              var43.field1 = true;
                              var43.field10 = var9;
                              var43.field3 = class140.field2134 - var10;
                              var43.field4 = class140.field2135 - var11;
                              var43.field12 = var9.field2864;
                              client.field486.method3819(var43);
                           }

                           if(var9.field2873 && !var40) {
                              var9.field2873 = false;
                              if(null != var9.field2836) {
                                 var43 = new class0();
                                 var43.field1 = true;
                                 var43.field10 = var9;
                                 var43.field3 = class140.field2134 - var10;
                                 var43.field4 = class140.field2135 - var11;
                                 var43.field12 = var9.field2836;
                                 client.field488.method3819(var43);
                              }
                           }

                           if(var9.field2847 != null) {
                              var43 = new class0();
                              var43.field10 = var9;
                              var43.field12 = var9.field2847;
                              client.field487.method3819(var43);
                           }

                           class0 var24;
                           if(var9.field2841 != null && client.field474 > var9.field2876) {
                              if(var9.field2842 != null && client.field474 - var9.field2876 <= 32) {
                                 label1025:
                                 for(var34 = var9.field2876; var34 < client.field474; ++var34) {
                                    var33 = client.field473[var34 & 31];

                                    for(var23 = 0; var23 < var9.field2842.length; ++var23) {
                                       if(var9.field2842[var23] == var33) {
                                          var24 = new class0();
                                          var24.field10 = var9;
                                          var24.field12 = var9.field2841;
                                          client.field486.method3819(var24);
                                          break label1025;
                                       }
                                    }
                                 }
                              } else {
                                 var43 = new class0();
                                 var43.field10 = var9;
                                 var43.field12 = var9.field2841;
                                 client.field486.method3819(var43);
                              }

                              var9.field2876 = client.field474;
                           }

                           if(null != var9.field2843 && client.field476 > var9.field2785) {
                              if(null != var9.field2881 && client.field476 - var9.field2785 <= 32) {
                                 label1001:
                                 for(var34 = var9.field2785; var34 < client.field476; ++var34) {
                                    var33 = client.field475[var34 & 31];

                                    for(var23 = 0; var23 < var9.field2881.length; ++var23) {
                                       if(var33 == var9.field2881[var23]) {
                                          var24 = new class0();
                                          var24.field10 = var9;
                                          var24.field12 = var9.field2843;
                                          client.field486.method3819(var24);
                                          break label1001;
                                       }
                                    }
                                 }
                              } else {
                                 var43 = new class0();
                                 var43.field10 = var9;
                                 var43.field12 = var9.field2843;
                                 client.field486.method3819(var43);
                              }

                              var9.field2785 = client.field476;
                           }

                           if(null != var9.field2846 && client.field467 > var9.field2878) {
                              if(null != var9.field2812 && client.field467 - var9.field2878 <= 32) {
                                 label977:
                                 for(var34 = var9.field2878; var34 < client.field467; ++var34) {
                                    var33 = client.field471[var34 & 31];

                                    for(var23 = 0; var23 < var9.field2812.length; ++var23) {
                                       if(var33 == var9.field2812[var23]) {
                                          var24 = new class0();
                                          var24.field10 = var9;
                                          var24.field12 = var9.field2846;
                                          client.field486.method3819(var24);
                                          break label977;
                                       }
                                    }
                                 }
                              } else {
                                 var43 = new class0();
                                 var43.field10 = var9;
                                 var43.field12 = var9.field2846;
                                 client.field486.method3819(var43);
                              }

                              var9.field2878 = client.field467;
                           }

                           if(client.field435 > var9.field2831 && null != var9.field2740) {
                              var43 = new class0();
                              var43.field10 = var9;
                              var43.field12 = var9.field2740;
                              client.field486.method3819(var43);
                           }

                           if(client.field492 > var9.field2831 && null != var9.field2852) {
                              var43 = new class0();
                              var43.field10 = var9;
                              var43.field12 = var9.field2852;
                              client.field486.method3819(var43);
                           }

                           if(client.field288 > var9.field2831 && var9.field2877 != null) {
                              var43 = new class0();
                              var43.field10 = var9;
                              var43.field12 = var9.field2877;
                              client.field486.method3819(var43);
                           }

                           if(client.field327 > var9.field2831 && null != var9.field2858) {
                              var43 = new class0();
                              var43.field10 = var9;
                              var43.field12 = var9.field2858;
                              client.field486.method3819(var43);
                           }

                           if(client.field483 > var9.field2831 && null != var9.field2859) {
                              var43 = new class0();
                              var43.field10 = var9;
                              var43.field12 = var9.field2859;
                              client.field486.method3819(var43);
                           }

                           if(client.field484 > var9.field2831 && var9.field2854 != null) {
                              var43 = new class0();
                              var43.field10 = var9;
                              var43.field12 = var9.field2854;
                              client.field486.method3819(var43);
                           }

                           var9.field2831 = client.field359;
                           if(var9.field2807 != null) {
                              for(var34 = 0; var34 < client.field510; ++var34) {
                                 class0 var22 = new class0();
                                 var22.field10 = var9;
                                 var22.field7 = client.field512[var34];
                                 var22.field8 = client.field511[var34];
                                 var22.field12 = var9.field2807;
                                 client.field486.method3819(var22);
                              }
                           }
                        }
                     }

                     if(!var9.field2741 && null == client.field460 && null == class38.field849 && !client.field428) {
                        if((var9.field2790 >= 0 || var9.field2775 != 0) && class140.field2134 >= var12 && class140.field2135 >= var13 && class140.field2134 < var14 && class140.field2135 < var15) {
                           if(var9.field2790 >= 0) {
                              class172.field2732 = var0[var9.field2790];
                           } else {
                              class172.field2732 = var9;
                           }
                        }

                        if(var9.field2833 == 8 && class140.field2134 >= var12 && class140.field2135 >= var13 && class140.field2134 < var14 && class140.field2135 < var15) {
                           class175.field2890 = var9;
                        }

                        if(var9.field2772 > var9.field2764) {
                           class167.method3344(var9, var9.field2763 + var10, var11, var9.field2764, var9.field2772, class140.field2134, class140.field2135);
                        }
                     }
                  }
               }
            }
         }
      }

   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(IIIIIILclass86;Lclass108;I)V",
      garbageValue = "1258815667"
   )
   static final void method8(int var0, int var1, int var2, int var3, int var4, int var5, class86 var6, class108 var7) {
      if(!client.field383 || (class5.field69[0][var1][var2] & 2) != 0 || (class5.field69[var0][var1][var2] & 16) == 0) {
         if(var0 < class5.field70) {
            class5.field70 = var0;
         }

         class40 var8 = class172.method3399(var3);
         int var9;
         int var10;
         if(var4 != 1 && var4 != 3) {
            var9 = var8.field915;
            var10 = var8.field904;
         } else {
            var9 = var8.field904;
            var10 = var8.field915;
         }

         int var11;
         int var12;
         if(var1 + var9 <= 104) {
            var11 = var1 + (var9 >> 1);
            var12 = var1 + (1 + var9 >> 1);
         } else {
            var11 = var1;
            var12 = var1 + 1;
         }

         int var13;
         int var14;
         if(var2 + var10 <= 104) {
            var13 = (var10 >> 1) + var2;
            var14 = (1 + var10 >> 1) + var2;
         } else {
            var13 = var2;
            var14 = var2 + 1;
         }

         int[][] var15 = class5.field83[var0];
         int var16 = var15[var11][var14] + var15[var12][var13] + var15[var11][var13] + var15[var12][var14] >> 2;
         int var17 = (var9 << 6) + (var1 << 7);
         int var18 = (var2 << 7) + (var10 << 6);
         int var19 = (var3 << 14) + (var2 << 7) + var1 + 1073741824;
         if(var8.field919 == 0) {
            var19 -= Integer.MIN_VALUE;
         }

         int var20 = var5 + (var4 << 6);
         if(var8.field940 == 1) {
            var20 += 256;
         }

         if(var8.method810()) {
            class14.method163(var0, var1, var2, var8, var4);
         }

         Object var21;
         if(var5 == 22) {
            if(!client.field383 || var8.field919 != 0 || var8.field917 == 1 || var8.field938) {
               if(var8.field945 == -1 && null == var8.field949) {
                  var21 = var8.method833(22, var4, var15, var17, var16, var18);
               } else {
                  var21 = new class12(var3, 22, var4, var0, var1, var2, var8.field945, true, (class85)null);
               }

               var6.method1931(var0, var1, var2, var16, (class85)var21, var19, var20);
               if(var8.field917 == 1 && null != var7) {
                  var7.method2395(var1, var2);
               }

            }
         } else {
            int var22;
            if(var5 != 10 && var5 != 11) {
               if(var5 >= 12) {
                  if(var8.field945 == -1 && null == var8.field949) {
                     var21 = var8.method833(var5, var4, var15, var17, var16, var18);
                  } else {
                     var21 = new class12(var3, var5, var4, var0, var1, var2, var8.field945, true, (class85)null);
                  }

                  var6.method1945(var0, var1, var2, var16, 1, 1, (class85)var21, 0, var19, var20);
                  if(var5 >= 12 && var5 <= 17 && var5 != 13 && var0 > 0) {
                     class149.field2225[var0][var1][var2] |= 2340;
                  }

                  if(var8.field917 != 0 && null != var7) {
                     var7.method2393(var1, var2, var9, var10, var8.field918);
                  }

               } else if(var5 == 0) {
                  if(var8.field945 == -1 && var8.field949 == null) {
                     var21 = var8.method833(0, var4, var15, var17, var16, var18);
                  } else {
                     var21 = new class12(var3, 0, var4, var0, var1, var2, var8.field945, true, (class85)null);
                  }

                  var6.method1933(var0, var1, var2, var16, (class85)var21, (class85)null, class5.field75[var4], 0, var19, var20);
                  if(var4 == 0) {
                     if(var8.field921) {
                        class5.field91[var0][var1][var2] = 50;
                        class5.field91[var0][var1][var2 + 1] = 50;
                     }

                     if(var8.field922) {
                        class149.field2225[var0][var1][var2] |= 585;
                     }
                  } else if(var4 == 1) {
                     if(var8.field921) {
                        class5.field91[var0][var1][1 + var2] = 50;
                        class5.field91[var0][var1 + 1][1 + var2] = 50;
                     }

                     if(var8.field922) {
                        class149.field2225[var0][var1][var2 + 1] |= 1170;
                     }
                  } else if(var4 == 2) {
                     if(var8.field921) {
                        class5.field91[var0][var1 + 1][var2] = 50;
                        class5.field91[var0][1 + var1][var2 + 1] = 50;
                     }

                     if(var8.field922) {
                        class149.field2225[var0][var1 + 1][var2] |= 585;
                     }
                  } else if(var4 == 3) {
                     if(var8.field921) {
                        class5.field91[var0][var1][var2] = 50;
                        class5.field91[var0][1 + var1][var2] = 50;
                     }

                     if(var8.field922) {
                        class149.field2225[var0][var1][var2] |= 1170;
                     }
                  }

                  if(var8.field917 != 0 && null != var7) {
                     var7.method2392(var1, var2, var5, var4, var8.field918);
                  }

                  if(var8.field908 != 16) {
                     var6.method1941(var0, var1, var2, var8.field908);
                  }

               } else if(var5 == 1) {
                  if(var8.field945 == -1 && null == var8.field949) {
                     var21 = var8.method833(1, var4, var15, var17, var16, var18);
                  } else {
                     var21 = new class12(var3, 1, var4, var0, var1, var2, var8.field945, true, (class85)null);
                  }

                  var6.method1933(var0, var1, var2, var16, (class85)var21, (class85)null, class5.field68[var4], 0, var19, var20);
                  if(var8.field921) {
                     if(var4 == 0) {
                        class5.field91[var0][var1][1 + var2] = 50;
                     } else if(var4 == 1) {
                        class5.field91[var0][var1 + 1][1 + var2] = 50;
                     } else if(var4 == 2) {
                        class5.field91[var0][1 + var1][var2] = 50;
                     } else if(var4 == 3) {
                        class5.field91[var0][var1][var2] = 50;
                     }
                  }

                  if(var8.field917 != 0 && var7 != null) {
                     var7.method2392(var1, var2, var5, var4, var8.field918);
                  }

               } else {
                  Object var23;
                  int var26;
                  if(var5 == 2) {
                     var26 = var4 + 1 & 3;
                     Object var28;
                     if(var8.field945 == -1 && null == var8.field949) {
                        var28 = var8.method833(2, var4 + 4, var15, var17, var16, var18);
                        var23 = var8.method833(2, var26, var15, var17, var16, var18);
                     } else {
                        var28 = new class12(var3, 2, 4 + var4, var0, var1, var2, var8.field945, true, (class85)null);
                        var23 = new class12(var3, 2, var26, var0, var1, var2, var8.field945, true, (class85)null);
                     }

                     var6.method1933(var0, var1, var2, var16, (class85)var28, (class85)var23, class5.field75[var4], class5.field75[var26], var19, var20);
                     if(var8.field922) {
                        if(var4 == 0) {
                           class149.field2225[var0][var1][var2] |= 585;
                           class149.field2225[var0][var1][var2 + 1] |= 1170;
                        } else if(var4 == 1) {
                           class149.field2225[var0][var1][1 + var2] |= 1170;
                           class149.field2225[var0][1 + var1][var2] |= 585;
                        } else if(var4 == 2) {
                           class149.field2225[var0][var1 + 1][var2] |= 585;
                           class149.field2225[var0][var1][var2] |= 1170;
                        } else if(var4 == 3) {
                           class149.field2225[var0][var1][var2] |= 1170;
                           class149.field2225[var0][var1][var2] |= 585;
                        }
                     }

                     if(var8.field917 != 0 && null != var7) {
                        var7.method2392(var1, var2, var5, var4, var8.field918);
                     }

                     if(var8.field908 != 16) {
                        var6.method1941(var0, var1, var2, var8.field908);
                     }

                  } else if(var5 == 3) {
                     if(var8.field945 == -1 && null == var8.field949) {
                        var21 = var8.method833(3, var4, var15, var17, var16, var18);
                     } else {
                        var21 = new class12(var3, 3, var4, var0, var1, var2, var8.field945, true, (class85)null);
                     }

                     var6.method1933(var0, var1, var2, var16, (class85)var21, (class85)null, class5.field68[var4], 0, var19, var20);
                     if(var8.field921) {
                        if(var4 == 0) {
                           class5.field91[var0][var1][1 + var2] = 50;
                        } else if(var4 == 1) {
                           class5.field91[var0][var1 + 1][var2 + 1] = 50;
                        } else if(var4 == 2) {
                           class5.field91[var0][1 + var1][var2] = 50;
                        } else if(var4 == 3) {
                           class5.field91[var0][var1][var2] = 50;
                        }
                     }

                     if(var8.field917 != 0 && var7 != null) {
                        var7.method2392(var1, var2, var5, var4, var8.field918);
                     }

                  } else if(var5 == 9) {
                     if(var8.field945 == -1 && var8.field949 == null) {
                        var21 = var8.method833(var5, var4, var15, var17, var16, var18);
                     } else {
                        var21 = new class12(var3, var5, var4, var0, var1, var2, var8.field945, true, (class85)null);
                     }

                     var6.method1945(var0, var1, var2, var16, 1, 1, (class85)var21, 0, var19, var20);
                     if(var8.field917 != 0 && null != var7) {
                        var7.method2393(var1, var2, var9, var10, var8.field918);
                     }

                     if(var8.field908 != 16) {
                        var6.method1941(var0, var1, var2, var8.field908);
                     }

                  } else if(var5 == 4) {
                     if(var8.field945 == -1 && null == var8.field949) {
                        var21 = var8.method833(4, var4, var15, var17, var16, var18);
                     } else {
                        var21 = new class12(var3, 4, var4, var0, var1, var2, var8.field945, true, (class85)null);
                     }

                     var6.method2053(var0, var1, var2, var16, (class85)var21, (class85)null, class5.field75[var4], 0, 0, 0, var19, var20);
                  } else if(var5 == 5) {
                     var26 = 16;
                     var22 = var6.method1951(var0, var1, var2);
                     if(var22 != 0) {
                        var26 = class172.method3399(var22 >> 14 & 32767).field908;
                     }

                     if(var8.field945 == -1 && var8.field949 == null) {
                        var23 = var8.method833(4, var4, var15, var17, var16, var18);
                     } else {
                        var23 = new class12(var3, 4, var4, var0, var1, var2, var8.field945, true, (class85)null);
                     }

                     var6.method2053(var0, var1, var2, var16, (class85)var23, (class85)null, class5.field75[var4], 0, class5.field88[var4] * var26, var26 * class5.field77[var4], var19, var20);
                  } else if(var5 == 6) {
                     var26 = 8;
                     var22 = var6.method1951(var0, var1, var2);
                     if(var22 != 0) {
                        var26 = class172.method3399(var22 >> 14 & 32767).field908 / 2;
                     }

                     if(var8.field945 == -1 && var8.field949 == null) {
                        var23 = var8.method833(4, var4 + 4, var15, var17, var16, var18);
                     } else {
                        var23 = new class12(var3, 4, var4 + 4, var0, var1, var2, var8.field945, true, (class85)null);
                     }

                     var6.method2053(var0, var1, var2, var16, (class85)var23, (class85)null, 256, var4, var26 * class5.field76[var4], class5.field80[var4] * var26, var19, var20);
                  } else if(var5 == 7) {
                     var22 = var4 + 2 & 3;
                     if(var8.field945 == -1 && var8.field949 == null) {
                        var21 = var8.method833(4, var22 + 4, var15, var17, var16, var18);
                     } else {
                        var21 = new class12(var3, 4, var22 + 4, var0, var1, var2, var8.field945, true, (class85)null);
                     }

                     var6.method2053(var0, var1, var2, var16, (class85)var21, (class85)null, 256, var22, 0, 0, var19, var20);
                  } else if(var5 == 8) {
                     var26 = 8;
                     var22 = var6.method1951(var0, var1, var2);
                     if(var22 != 0) {
                        var26 = class172.method3399(var22 >> 14 & 32767).field908 / 2;
                     }

                     int var25 = var4 + 2 & 3;
                     Object var29;
                     if(var8.field945 == -1 && var8.field949 == null) {
                        var23 = var8.method833(4, 4 + var4, var15, var17, var16, var18);
                        var29 = var8.method833(4, 4 + var25, var15, var17, var16, var18);
                     } else {
                        var23 = new class12(var3, 4, 4 + var4, var0, var1, var2, var8.field945, true, (class85)null);
                        var29 = new class12(var3, 4, var25 + 4, var0, var1, var2, var8.field945, true, (class85)null);
                     }

                     var6.method2053(var0, var1, var2, var16, (class85)var23, (class85)var29, 256, var4, var26 * class5.field76[var4], var26 * class5.field80[var4], var19, var20);
                  }
               }
            } else {
               if(var8.field945 == -1 && var8.field949 == null) {
                  var21 = var8.method833(10, var4, var15, var17, var16, var18);
               } else {
                  var21 = new class12(var3, 10, var4, var0, var1, var2, var8.field945, true, (class85)null);
               }

               if(var21 != null && var6.method1945(var0, var1, var2, var16, var9, var10, (class85)var21, var5 == 11?256:0, var19, var20) && var8.field921) {
                  var22 = 15;
                  if(var21 instanceof class105) {
                     var22 = ((class105)var21).method2340() / 4;
                     if(var22 > 30) {
                        var22 = 30;
                     }
                  }

                  for(int var27 = 0; var27 <= var9; ++var27) {
                     for(int var24 = 0; var24 <= var10; ++var24) {
                        if(var22 > class5.field91[var0][var27 + var1][var24 + var2]) {
                           class5.field91[var0][var1 + var27][var2 + var24] = (byte)var22;
                        }
                     }
                  }
               }

               if(var8.field917 != 0 && var7 != null) {
                  var7.method2393(var1, var2, var9, var10, var8.field918);
               }

            }
         }
      }
   }

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      signature = "(Lclass37;I)V",
      garbageValue = "2005138943"
   )
   static final void method10(class37 var0) {
      int var1 = var0.field843 - client.field296;
      int var2 = var0.field837 * 128 + var0.field832 * 64;
      int var3 = var0.field833 * 128 + var0.field832 * 64;
      var0.field813 += (var2 - var0.field813) / var1;
      var0.field791 += (var3 - var0.field791) / var1;
      var0.field847 = 0;
      var0.field840 = var0.field826;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1098267027"
   )
   static final void method11() {
      for(int var0 = 0; var0 < client.field504; ++var0) {
         --client.field532[var0];
         if(client.field532[var0] >= -10) {
            class58 var9 = client.field534[var0];
            if(null == var9) {
               class58 var10000 = (class58)null;
               var9 = class58.method1251(client.field466, client.field530[var0], 0);
               if(null == var9) {
                  continue;
               }

               client.field532[var0] += var9.method1250();
               client.field534[var0] = var9;
            }

            if(client.field532[var0] < 0) {
               int var2;
               if(client.field480[var0] != 0) {
                  int var3 = 128 * (client.field480[var0] & 255);
                  int var10 = client.field480[var0] >> 16 & 255;
                  int var5 = 64 + var10 * 128 - class153.field2262.field813;
                  if(var5 < 0) {
                     var5 = -var5;
                  }

                  int var6 = client.field480[var0] >> 8 & 255;
                  int var7 = 128 * var6 + 64 - class153.field2262.field791;
                  if(var7 < 0) {
                     var7 = -var7;
                  }

                  int var8 = var7 + var5 - 128;
                  if(var8 > var3) {
                     client.field532[var0] = -100;
                     continue;
                  }

                  if(var8 < 0) {
                     var8 = 0;
                  }

                  var2 = (var3 - var8) * client.field365 / var3;
               } else {
                  var2 = client.field527;
               }

               if(var2 > 0) {
                  class62 var11 = var9.method1257().method1286(class95.field1589);
                  class64 var4 = class64.method1311(var11, 100, var2);
                  var4.method1314(client.field531[var0] - 1);
                  class52.field1134.method1167(var4);
               }

               client.field532[var0] = -100;
            }
         } else {
            --client.field504;

            for(int var1 = var0; var1 < client.field504; ++var1) {
               client.field530[var1] = client.field530[var1 + 1];
               client.field534[var1] = client.field534[1 + var1];
               client.field531[var1] = client.field531[1 + var1];
               client.field532[var1] = client.field532[var1 + 1];
               client.field480[var1] = client.field480[var1 + 1];
            }

            --var0;
         }
      }

      if(client.field526) {
         boolean var12;
         if(class183.field2953 != 0) {
            var12 = true;
         } else {
            var12 = class183.field2952.method3707();
         }

         if(!var12) {
            if(client.field524 != 0 && client.field525 != -1) {
               class85.method1922(client.field358, client.field525, 0, client.field524, false);
            }

            client.field526 = false;
         }
      }

   }
}
