import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("aw")
public class class35 {
   @ObfuscatedName("r")
   static class83[] field818;
   @ObfuscatedName("h")
   static final class35 field819 = new class35();
   @ObfuscatedName("l")
   static final class35 field820 = new class35();
   @ObfuscatedName("c")
   static final class35 field821 = new class35();
   @ObfuscatedName("e")
   static final class35 field823 = new class35();

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "([BIII)Ljava/lang/String;",
      garbageValue = "397658715"
   )
   public static String method747(byte[] var0, int var1, int var2) {
      char[] var3 = new char[var2];
      int var4 = 0;

      for(int var5 = 0; var5 < var2; ++var5) {
         int var6 = var0[var1 + var5] & 255;
         if(var6 != 0) {
            if(var6 >= 128 && var6 < 160) {
               char var7 = class168.field2699[var6 - 128];
               if(var7 == 0) {
                  var7 = 63;
               }

               var6 = var7;
            }

            var3[var4++] = (char)var6;
         }
      }

      return new String(var3, 0, var4);
   }

   @ObfuscatedName("db")
   @ObfuscatedSignature(
      signature = "([Lclass176;II)V",
      garbageValue = "1797619998"
   )
   static final void method748(class176[] var0, int var1) {
      for(int var2 = 0; var2 < var0.length; ++var2) {
         class176 var3 = var0[var2];
         if(null != var3 && var3.field2813 == var1 && (!var3.field2793 || !class78.method1733(var3))) {
            int var5;
            if(var3.field2796 == 0) {
               if(!var3.field2793 && class78.method1733(var3) && class99.field1699 != var3) {
                  continue;
               }

               method748(var0, var3.field2794);
               if(null != var3.field2827) {
                  method748(var3.field2827, var3.field2794);
               }

               class3 var7 = (class3)client.field455.method3864((long)var3.field2794);
               if(null != var7) {
                  var5 = var7.field60;
                  if(class10.method112(var5)) {
                     method748(class176.field2811[var5], -1);
                  }
               }
            }

            if(var3.field2796 == 6) {
               if(var3.field2841 != -1 || var3.field2784 != -1) {
                  boolean var4 = class28.method646(var3);
                  if(var4) {
                     var5 = var3.field2784;
                  } else {
                     var5 = var3.field2841;
                  }

                  if(var5 != -1) {
                     class44 var6 = class13.method153(var5);

                     for(var3.field2917 += client.field485; var3.field2917 > var6.field1025[var3.field2790]; class51.method1124(var3)) {
                        var3.field2917 -= var6.field1025[var3.field2790];
                        ++var3.field2790;
                        if(var3.field2790 >= var6.field1023.length) {
                           var3.field2790 -= var6.field1027;
                           if(var3.field2790 < 0 || var3.field2790 >= var6.field1023.length) {
                              var3.field2790 = 0;
                           }
                        }
                     }
                  }
               }

               if(var3.field2850 != 0 && !var3.field2793) {
                  int var8 = var3.field2850 >> 16;
                  var5 = var3.field2850 << 16 >> 16;
                  var8 *= client.field485;
                  var5 *= client.field485;
                  var3.field2845 = var8 + var3.field2845 & 2047;
                  var3.field2846 = var3.field2846 + var5 & 2047;
                  class51.method1124(var3);
               }
            }
         }
      }

   }

   @ObfuscatedName("dn")
   @ObfuscatedSignature(
      signature = "([Lclass176;IIIIIIII)V",
      garbageValue = "1981445471"
   )
   static final void method749(class176[] var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      for(int var8 = 0; var8 < var0.length; ++var8) {
         class176 var9 = var0[var8];
         if(null != var9 && (!var9.field2793 || var9.field2796 == 0 || var9.field2874 || class27.method644(var9) != 0 || var9 == client.field403 || var9.field2916 == 1338) && var1 == var9.field2813 && (!var9.field2793 || !class78.method1733(var9))) {
            int var10 = var9.field2807 + var6;
            int var11 = var7 + var9.field2808;
            int var12;
            int var13;
            int var14;
            int var15;
            int var16;
            int var17;
            int var18;
            int var19;
            if(var9.field2796 == 2) {
               var12 = var2;
               var13 = var3;
               var14 = var4;
               var15 = var5;
            } else if(var9.field2796 == 9) {
               var16 = var10;
               var17 = var11;
               var18 = var9.field2866 + var10;
               var19 = var11 + var9.field2810;
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
               var16 = var9.field2866 + var10;
               var17 = var11 + var9.field2810;
               var12 = var10 > var2?var10:var2;
               var13 = var11 > var3?var11:var3;
               var14 = var16 < var4?var16:var4;
               var15 = var17 < var5?var17:var5;
            }

            if(var9 == client.field492) {
               client.field475 = true;
               client.field537 = var10;
               client.field477 = var11;
            }

            if(!var9.field2793 || var12 < var14 && var13 < var15) {
               var16 = class143.field2198;
               var17 = class143.field2201;
               if(class143.field2208 != 0) {
                  var16 = class143.field2207;
                  var17 = class143.field2213;
               }

               int var20;
               int var22;
               int var23;
               int var27;
               int var36;
               int var38;
               int var39;
               int var40;
               int var41;
               int var56;
               if(var9.field2916 == 1337) {
                  if(!client.field302 && !client.field540 && var16 >= var12 && var17 >= var13 && var16 < var14 && var17 < var15) {
                     if(client.field459 == 0 && !client.field448) {
                        class118.method2543("Walk here", "", 23, 0, var16 - var12, var17 - var13);
                     }

                     var18 = -1;
                     var19 = -1;

                     for(var20 = 0; var20 < class108.field1932; ++var20) {
                        var36 = class108.field1933[var20];
                        var22 = var36 & 127;
                        var23 = var36 >> 7 & 127;
                        var38 = var36 >> 29 & 3;
                        var39 = var36 >> 14 & 32767;
                        if(var36 != var19) {
                           var19 = var36;
                           if(var38 == 2 && class79.field1453.method2039(class50.field1119, var22, var23, var36) >= 0) {
                              class42 var50 = class146.method3102(var39);
                              if(var50.field969 != null) {
                                 var50 = var50.method847();
                              }

                              if(var50 == null) {
                                 continue;
                              }

                              if(client.field459 == 1) {
                                 class118.method2543("Use", client.field447 + " " + "->" + " " + class117.method2530('\uffff') + var50.field964, 1, var36, var22, var23);
                              } else if(client.field448) {
                                 if((class19.field278 & 4) == 4) {
                                    class118.method2543(client.field452, client.field369 + " " + "->" + " " + class117.method2530('\uffff') + var50.field964, 2, var36, var22, var23);
                                 }
                              } else {
                                 String[] var34 = var50.field962;
                                 if(client.field524) {
                                    var34 = class20.method542(var34);
                                 }

                                 if(var34 != null) {
                                    for(var40 = 4; var40 >= 0; --var40) {
                                       if(null != var34[var40]) {
                                          short var65 = 0;
                                          if(var40 == 0) {
                                             var65 = 3;
                                          }

                                          if(var40 == 1) {
                                             var65 = 4;
                                          }

                                          if(var40 == 2) {
                                             var65 = 5;
                                          }

                                          if(var40 == 3) {
                                             var65 = 6;
                                          }

                                          if(var40 == 4) {
                                             var65 = 1001;
                                          }

                                          class118.method2543(var34[var40], class117.method2530('\uffff') + var50.field964, var65, var36, var22, var23);
                                       }
                                    }
                                 }

                                 class118.method2543("Examine", class117.method2530('\uffff') + var50.field964, 1002, var50.field974 << 14, var22, var23);
                              }
                           }

                           class36 var28;
                           class2 var37;
                           int[] var51;
                           if(var38 == 1) {
                              class36 var52 = client.field331[var39];
                              if(var52 == null) {
                                 continue;
                              }

                              if(var52.field825.field924 == 1 && (var52.field896 & 127) == 64 && (var52.field879 & 127) == 64) {
                                 for(var27 = 0; var27 < client.field332; ++var27) {
                                    var28 = client.field331[client.field333[var27]];
                                    if(var28 != null && var52 != var28 && var28.field825.field924 == 1 && var28.field896 == var52.field896 && var52.field879 == var28.field879) {
                                       class4.method43(var28.field825, client.field333[var27], var22, var23);
                                    }
                                 }

                                 var27 = class34.field804;
                                 var51 = class34.field807;

                                 for(var41 = 0; var41 < var27; ++var41) {
                                    var37 = client.field467[var51[var41]];
                                    if(null != var37 && var52.field896 == var37.field896 && var37.field879 == var52.field879) {
                                       class109.method2462(var37, var51[var41], var22, var23);
                                    }
                                 }
                              }

                              class4.method43(var52.field825, var39, var22, var23);
                           }

                           if(var38 == 0) {
                              class2 var54 = client.field467[var39];
                              if(null == var54) {
                                 continue;
                              }

                              if((var54.field896 & 127) == 64 && (var54.field879 & 127) == 64) {
                                 for(var27 = 0; var27 < client.field332; ++var27) {
                                    var28 = client.field331[client.field333[var27]];
                                    if(null != var28 && var28.field825.field924 == 1 && var54.field896 == var28.field896 && var54.field879 == var28.field879) {
                                       class4.method43(var28.field825, client.field333[var27], var22, var23);
                                    }
                                 }

                                 var27 = class34.field804;
                                 var51 = class34.field807;

                                 for(var41 = 0; var41 < var27; ++var41) {
                                    var37 = client.field467[var51[var41]];
                                    if(var37 != null && var54 != var37 && var37.field896 == var54.field896 && var54.field879 == var37.field879) {
                                       class109.method2462(var37, var51[var41], var22, var23);
                                    }
                                 }
                              }

                              if(client.field425 != var39) {
                                 class109.method2462(var54, var39, var22, var23);
                              } else {
                                 var18 = var36;
                              }
                           }

                           if(var38 == 3) {
                              class202 var55 = client.field426[class50.field1119][var22][var23];
                              if(null != var55) {
                                 for(class30 var60 = (class30)var55.method3900(); var60 != null; var60 = (class30)var55.method3893()) {
                                    class55 var53 = class9.method108(var60.field717);
                                    if(client.field459 == 1) {
                                       class118.method2543("Use", client.field447 + " " + "->" + " " + class117.method2530(16748608) + var53.field1183, 16, var60.field717, var22, var23);
                                    } else if(client.field448) {
                                       if((class19.field278 & 1) == 1) {
                                          class118.method2543(client.field452, client.field369 + " " + "->" + " " + class117.method2530(16748608) + var53.field1183, 17, var60.field717, var22, var23);
                                       }
                                    } else {
                                       String[] var29 = var53.field1189;
                                       if(client.field524) {
                                          var29 = class20.method542(var29);
                                       }

                                       for(var56 = 4; var56 >= 0; --var56) {
                                          if(null != var29 && var29[var56] != null) {
                                             byte var57 = 0;
                                             if(var56 == 0) {
                                                var57 = 18;
                                             }

                                             if(var56 == 1) {
                                                var57 = 19;
                                             }

                                             if(var56 == 2) {
                                                var57 = 20;
                                             }

                                             if(var56 == 3) {
                                                var57 = 21;
                                             }

                                             if(var56 == 4) {
                                                var57 = 22;
                                             }

                                             class118.method2543(var29[var56], class117.method2530(16748608) + var53.field1183, var57, var60.field717, var22, var23);
                                          } else if(var56 == 2) {
                                             class118.method2543("Take", class117.method2530(16748608) + var53.field1183, 20, var60.field717, var22, var23);
                                          }
                                       }

                                       class118.method2543("Examine", class117.method2530(16748608) + var53.field1183, 1004, var60.field717, var22, var23);
                                    }
                                 }
                              }
                           }
                        }
                     }

                     if(var18 != -1) {
                        var20 = var18 & 127;
                        var36 = var18 >> 7 & 127;
                        class2 var62 = client.field467[client.field425];
                        class109.method2462(var62, client.field425, var20, var36);
                     }
                  }
               } else if(var9.field2916 == 1338) {
                  if((client.field531 == 0 || client.field531 == 3) && (class143.field2208 == 1 || !client.field469 && class143.field2208 == 4)) {
                     class178 var59 = var9.method3493(true);
                     if(null != var59) {
                        var19 = class143.field2207 - var10;
                        var20 = class143.field2213 - var11;
                        if(var59.method3541(var19, var20)) {
                           var19 -= var59.field2940 / 2;
                           var20 -= var59.field2938 / 2;
                           var36 = client.field365 + client.field514 & 2047;
                           var22 = class94.field1655[var36];
                           var23 = class94.field1653[var36];
                           var22 = (client.field327 + 256) * var22 >> 8;
                           var23 = var23 * (client.field327 + 256) >> 8;
                           var38 = var22 * var20 + var19 * var23 >> 11;
                           var39 = var23 * var20 - var19 * var22 >> 11;
                           int var66 = var38 + class118.field2035.field896 >> 7;
                           var27 = class118.field2035.field879 - var39 >> 7;
                           client.field336.method2854(73);
                           client.field336.method2795(18);
                           client.field336.method2642(class6.field128 + var27);
                           client.field336.method2805(class140.field2160[82]?(class140.field2160[81]?2:1):0);
                           client.field336.method2637(var66 + class19.field286);
                           client.field336.method2795(var19);
                           client.field336.method2795(var20);
                           client.field336.method2781(client.field514);
                           client.field336.method2795(57);
                           client.field336.method2795(client.field365);
                           client.field336.method2795(client.field327);
                           client.field336.method2795(89);
                           client.field336.method2781(class118.field2035.field896);
                           client.field336.method2781(class118.field2035.field879);
                           client.field336.method2795(63);
                           client.field529 = var66;
                           client.field530 = var27;
                        }
                     }
                  }
               } else {
                  boolean var47;
                  if(!client.field540 && var16 >= var12 && var17 >= var13 && var16 < var14 && var17 < var15) {
                     var18 = var16 - var10;
                     var19 = var17 - var11;
                     if(var9.field2816 == 1) {
                        class118.method2543(var9.field2911, "", 24, 0, 0, var9.field2794);
                     }

                     String var42;
                     if(var9.field2816 == 2 && !client.field448) {
                        var42 = class52.method1133(var9);
                        if(null != var42) {
                           class118.method2543(var42, class117.method2530('\uff00') + var9.field2786, 25, 0, -1, var9.field2794);
                        }
                     }

                     if(var9.field2816 == 3) {
                        class118.method2543("Close", "", 26, 0, 0, var9.field2794);
                     }

                     if(var9.field2816 == 4) {
                        class118.method2543(var9.field2911, "", 28, 0, 0, var9.field2794);
                     }

                     if(var9.field2816 == 5) {
                        class118.method2543(var9.field2911, "", 29, 0, 0, var9.field2794);
                     }

                     if(var9.field2816 == 6 && client.field371 == null) {
                        class118.method2543(var9.field2911, "", 30, 0, -1, var9.field2794);
                     }

                     if(var9.field2796 == 2) {
                        var20 = 0;

                        for(var36 = 0; var36 < var9.field2810; ++var36) {
                           for(var22 = 0; var22 < var9.field2866; ++var22) {
                              var23 = (32 + var9.field2904) * var22;
                              var38 = var36 * (var9.field2887 + 32);
                              if(var20 < 20) {
                                 var23 += var9.field2862[var20];
                                 var38 += var9.field2824[var20];
                              }

                              if(var18 >= var23 && var19 >= var38 && var18 < var23 + 32 && var19 < 32 + var38) {
                                 client.field412 = var20;
                                 class0.field14 = var9;
                                 if(var9.field2912[var20] > 0) {
                                    label1733: {
                                       class55 var25 = class9.method108(var9.field2912[var20] - 1);
                                       boolean var43;
                                       if(client.field459 == 1) {
                                          var27 = class27.method644(var9);
                                          var43 = (var27 >> 30 & 1) != 0;
                                          if(var43) {
                                             if(var9.field2794 != class93.field1624 || class6.field124 != var20) {
                                                class118.method2543("Use", client.field447 + " " + "->" + " " + class117.method2530(16748608) + var25.field1183, 31, var25.field1181, var20, var9.field2794);
                                             }
                                             break label1733;
                                          }
                                       }

                                       if(client.field448) {
                                          var27 = class27.method644(var9);
                                          var43 = (var27 >> 30 & 1) != 0;
                                          if(var43) {
                                             if((class19.field278 & 16) == 16) {
                                                class118.method2543(client.field452, client.field369 + " " + "->" + " " + class117.method2530(16748608) + var25.field1183, 32, var25.field1181, var20, var9.field2794);
                                             }
                                             break label1733;
                                          }
                                       }

                                       String[] var26 = var25.field1180;
                                       if(client.field524) {
                                          var26 = class20.method542(var26);
                                       }

                                       var40 = class27.method644(var9);
                                       boolean var49 = (var40 >> 30 & 1) != 0;
                                       if(var49) {
                                          for(var41 = 4; var41 >= 3; --var41) {
                                             if(var26 != null && var26[var41] != null) {
                                                byte var30;
                                                if(var41 == 3) {
                                                   var30 = 36;
                                                } else {
                                                   var30 = 37;
                                                }

                                                class118.method2543(var26[var41], class117.method2530(16748608) + var25.field1183, var30, var25.field1181, var20, var9.field2794);
                                             } else if(var41 == 4) {
                                                class118.method2543("Drop", class117.method2530(16748608) + var25.field1183, 37, var25.field1181, var20, var9.field2794);
                                             }
                                          }
                                       }

                                       Object var10000 = null;
                                       if(class101.method2286(class27.method644(var9))) {
                                          class118.method2543("Use", class117.method2530(16748608) + var25.field1183, 38, var25.field1181, var20, var9.field2794);
                                       }

                                       var56 = class27.method644(var9);
                                       boolean var64 = (var56 >> 30 & 1) != 0;
                                       int var31;
                                       byte var32;
                                       if(var64 && var26 != null) {
                                          for(var31 = 2; var31 >= 0; --var31) {
                                             if(var26[var31] != null) {
                                                var32 = 0;
                                                if(var31 == 0) {
                                                   var32 = 33;
                                                }

                                                if(var31 == 1) {
                                                   var32 = 34;
                                                }

                                                if(var31 == 2) {
                                                   var32 = 35;
                                                }

                                                class118.method2543(var26[var31], class117.method2530(16748608) + var25.field1183, var32, var25.field1181, var20, var9.field2794);
                                             }
                                          }
                                       }

                                       var26 = var9.field2857;
                                       if(client.field524) {
                                          var26 = class20.method542(var26);
                                       }

                                       if(null != var26) {
                                          for(var31 = 4; var31 >= 0; --var31) {
                                             if(var26[var31] != null) {
                                                var32 = 0;
                                                if(var31 == 0) {
                                                   var32 = 39;
                                                }

                                                if(var31 == 1) {
                                                   var32 = 40;
                                                }

                                                if(var31 == 2) {
                                                   var32 = 41;
                                                }

                                                if(var31 == 3) {
                                                   var32 = 42;
                                                }

                                                if(var31 == 4) {
                                                   var32 = 43;
                                                }

                                                class118.method2543(var26[var31], class117.method2530(16748608) + var25.field1183, var32, var25.field1181, var20, var9.field2794);
                                             }
                                          }
                                       }

                                       class118.method2543("Examine", class117.method2530(16748608) + var25.field1183, 1005, var25.field1181, var20, var9.field2794);
                                    }
                                 }
                              }

                              ++var20;
                           }
                        }
                     }

                     if(var9.field2793) {
                        if(client.field448) {
                           var36 = class27.method644(var9);
                           var47 = (var36 >> 21 & 1) != 0;
                           if(var47 && (class19.field278 & 32) == 32) {
                              class118.method2543(client.field452, client.field369 + " " + "->" + " " + var9.field2922, 58, 0, var9.field2795, var9.field2794);
                           }
                        } else {
                           for(var20 = 9; var20 >= 5; --var20) {
                              String var21 = class96.method2258(var9, var20);
                              if(var21 != null) {
                                 class118.method2543(var21, var9.field2922, 1007, var20 + 1, var9.field2795, var9.field2794);
                              }
                           }

                           var42 = class52.method1133(var9);
                           if(var42 != null) {
                              class118.method2543(var42, var9.field2922, 25, 0, var9.field2795, var9.field2794);
                           }

                           for(var36 = 4; var36 >= 0; --var36) {
                              String var35 = class96.method2258(var9, var36);
                              if(null != var35) {
                                 class118.method2543(var35, var9.field2922, 57, var36 + 1, var9.field2795, var9.field2794);
                              }
                           }

                           if(class6.method81(class27.method644(var9))) {
                              class118.method2543("Continue", "", 30, 0, var9.field2795, var9.field2794);
                           }
                        }
                     }
                  }

                  if(var9.field2796 == 0) {
                     if(!var9.field2793 && class78.method1733(var9) && class99.field1699 != var9) {
                        continue;
                     }

                     method749(var0, var9.field2794, var12, var13, var14, var15, var10 - var9.field2815, var11 - var9.field2883);
                     if(null != var9.field2827) {
                        method749(var9.field2827, var9.field2794, var12, var13, var14, var15, var10 - var9.field2815, var11 - var9.field2883);
                     }

                     class3 var33 = (class3)client.field455.method3864((long)var9.field2794);
                     if(var33 != null) {
                        if(var33.field59 == 0 && class143.field2198 >= var12 && class143.field2201 >= var13 && class143.field2198 < var14 && class143.field2201 < var15 && !client.field540 && !client.field464) {
                           for(class0 var44 = (class0)client.field357.method3899(); var44 != null; var44 = (class0)client.field357.method3918()) {
                              if(var44.field10) {
                                 var44.method4000();
                                 var44.field2.field2919 = false;
                              }
                           }

                           if(client.field479 == 0) {
                              client.field492 = null;
                              client.field403 = null;
                           }

                           if(!client.field540) {
                              client.field440[0] = "Cancel";
                              client.field441[0] = "";
                              client.field438[0] = 1006;
                              client.field435 = 1;
                           }
                        }

                        class24.method578(var33.field60, var12, var13, var14, var15, var10, var11);
                     }
                  }

                  if(var9.field2793) {
                     class0 var58;
                     if(!var9.field2927) {
                        if(var9.field2928 && class143.field2198 >= var12 && class143.field2201 >= var13 && class143.field2198 < var14 && class143.field2201 < var15) {
                           for(var58 = (class0)client.field357.method3899(); var58 != null; var58 = (class0)client.field357.method3918()) {
                              if(var58.field10 && var58.field2.field2895 == var58.field4) {
                                 var58.method4000();
                              }
                           }
                        }
                     } else if(class143.field2198 >= var12 && class143.field2201 >= var13 && class143.field2198 < var14 && class143.field2201 < var15) {
                        for(var58 = (class0)client.field357.method3899(); var58 != null; var58 = (class0)client.field357.method3918()) {
                           if(var58.field10) {
                              var58.method4000();
                              var58.field2.field2919 = false;
                           }
                        }

                        if(client.field479 == 0) {
                           client.field492 = null;
                           client.field403 = null;
                        }

                        if(!client.field540) {
                           client.field440[0] = "Cancel";
                           client.field441[0] = "";
                           client.field438[0] = 1006;
                           client.field435 = 1;
                        }
                     }

                     boolean var45;
                     if(class143.field2198 >= var12 && class143.field2201 >= var13 && class143.field2198 < var14 && class143.field2201 < var15) {
                        var45 = true;
                     } else {
                        var45 = false;
                     }

                     boolean var46 = false;
                     if((class143.field2199 == 1 || !client.field469 && class143.field2199 == 4) && var45) {
                        var46 = true;
                     }

                     var47 = false;
                     if((class143.field2208 == 1 || !client.field469 && class143.field2208 == 4) && class143.field2207 >= var12 && class143.field2213 >= var13 && class143.field2207 < var14 && class143.field2213 < var15) {
                        var47 = true;
                     }

                     if(var47) {
                        class44.method922(var9, class143.field2207 - var10, class143.field2213 - var11);
                     }

                     if(null != client.field492 && var9 != client.field492 && var45) {
                        var22 = class27.method644(var9);
                        boolean var63 = (var22 >> 20 & 1) != 0;
                        if(var63) {
                           client.field382 = var9;
                        }
                     }

                     if(var9 == client.field403) {
                        client.field472 = true;
                        client.field473 = var10;
                        client.field474 = var11;
                     }

                     if(var9.field2874) {
                        class0 var48;
                        if(var45 && client.field573 != 0 && var9.field2895 != null) {
                           var48 = new class0();
                           var48.field10 = true;
                           var48.field2 = var9;
                           var48.field13 = client.field573;
                           var48.field4 = var9.field2895;
                           client.field357.method3895(var48);
                        }

                        if(null != client.field492 || null != class159.field2356 || client.field540) {
                           var47 = false;
                           var46 = false;
                           var45 = false;
                        }

                        if(!var9.field2920 && var47) {
                           var9.field2920 = true;
                           if(var9.field2926 != null) {
                              var48 = new class0();
                              var48.field10 = true;
                              var48.field2 = var9;
                              var48.field3 = class143.field2207 - var10;
                              var48.field13 = class143.field2213 - var11;
                              var48.field4 = var9.field2926;
                              client.field357.method3895(var48);
                           }
                        }

                        if(var9.field2920 && var46 && var9.field2825 != null) {
                           var48 = new class0();
                           var48.field10 = true;
                           var48.field2 = var9;
                           var48.field3 = class143.field2198 - var10;
                           var48.field13 = class143.field2201 - var11;
                           var48.field4 = var9.field2825;
                           client.field357.method3895(var48);
                        }

                        if(var9.field2920 && !var46) {
                           var9.field2920 = false;
                           if(null != var9.field2878) {
                              var48 = new class0();
                              var48.field10 = true;
                              var48.field2 = var9;
                              var48.field3 = class143.field2198 - var10;
                              var48.field13 = class143.field2201 - var11;
                              var48.field4 = var9.field2878;
                              client.field496.method3895(var48);
                           }
                        }

                        if(var46 && null != var9.field2879) {
                           var48 = new class0();
                           var48.field10 = true;
                           var48.field2 = var9;
                           var48.field3 = class143.field2198 - var10;
                           var48.field13 = class143.field2201 - var11;
                           var48.field4 = var9.field2879;
                           client.field357.method3895(var48);
                        }

                        if(!var9.field2919 && var45) {
                           var9.field2919 = true;
                           if(null != var9.field2864) {
                              var48 = new class0();
                              var48.field10 = true;
                              var48.field2 = var9;
                              var48.field3 = class143.field2198 - var10;
                              var48.field13 = class143.field2201 - var11;
                              var48.field4 = var9.field2864;
                              client.field357.method3895(var48);
                           }
                        }

                        if(var9.field2919 && var45 && var9.field2881 != null) {
                           var48 = new class0();
                           var48.field10 = true;
                           var48.field2 = var9;
                           var48.field3 = class143.field2198 - var10;
                           var48.field13 = class143.field2201 - var11;
                           var48.field4 = var9.field2881;
                           client.field357.method3895(var48);
                        }

                        if(var9.field2919 && !var45) {
                           var9.field2919 = false;
                           if(var9.field2882 != null) {
                              var48 = new class0();
                              var48.field10 = true;
                              var48.field2 = var9;
                              var48.field3 = class143.field2198 - var10;
                              var48.field13 = class143.field2201 - var11;
                              var48.field4 = var9.field2882;
                              client.field496.method3895(var48);
                           }
                        }

                        if(null != var9.field2839) {
                           var48 = new class0();
                           var48.field2 = var9;
                           var48.field4 = var9.field2839;
                           client.field495.method3895(var48);
                        }

                        class0 var24;
                        if(null != var9.field2858 && client.field482 > var9.field2818) {
                           if(null != var9.field2888 && client.field482 - var9.field2818 <= 32) {
                              label1404:
                              for(var36 = var9.field2818; var36 < client.field482; ++var36) {
                                 var22 = client.field415[var36 & 31];

                                 for(var23 = 0; var23 < var9.field2888.length; ++var23) {
                                    if(var22 == var9.field2888[var23]) {
                                       var24 = new class0();
                                       var24.field2 = var9;
                                       var24.field4 = var9.field2858;
                                       client.field357.method3895(var24);
                                       break label1404;
                                    }
                                 }
                              }
                           } else {
                              var48 = new class0();
                              var48.field2 = var9;
                              var48.field4 = var9.field2858;
                              client.field357.method3895(var48);
                           }

                           var9.field2818 = client.field482;
                        }

                        if(null != var9.field2889 && client.field484 > var9.field2923) {
                           if(null != var9.field2890 && client.field484 - var9.field2923 <= 32) {
                              label1380:
                              for(var36 = var9.field2923; var36 < client.field484; ++var36) {
                                 var22 = client.field483[var36 & 31];

                                 for(var23 = 0; var23 < var9.field2890.length; ++var23) {
                                    if(var9.field2890[var23] == var22) {
                                       var24 = new class0();
                                       var24.field2 = var9;
                                       var24.field4 = var9.field2889;
                                       client.field357.method3895(var24);
                                       break label1380;
                                    }
                                 }
                              }
                           } else {
                              var48 = new class0();
                              var48.field2 = var9;
                              var48.field4 = var9.field2889;
                              client.field357.method3895(var48);
                           }

                           var9.field2923 = client.field484;
                        }

                        if(var9.field2840 != null && client.field486 > var9.field2924) {
                           if(var9.field2892 != null && client.field486 - var9.field2924 <= 32) {
                              label1356:
                              for(var36 = var9.field2924; var36 < client.field486; ++var36) {
                                 var22 = client.field430[var36 & 31];

                                 for(var23 = 0; var23 < var9.field2892.length; ++var23) {
                                    if(var22 == var9.field2892[var23]) {
                                       var24 = new class0();
                                       var24.field2 = var9;
                                       var24.field4 = var9.field2840;
                                       client.field357.method3895(var24);
                                       break label1356;
                                    }
                                 }
                              }
                           } else {
                              var48 = new class0();
                              var48.field2 = var9;
                              var48.field4 = var9.field2840;
                              client.field357.method3895(var48);
                           }

                           var9.field2924 = client.field486;
                        }

                        if(client.field308 > var9.field2921 && var9.field2819 != null) {
                           var48 = new class0();
                           var48.field2 = var9;
                           var48.field4 = var9.field2819;
                           client.field357.method3895(var48);
                        }

                        if(-412771 * client.field515 > var9.field2921 && null != var9.field2898) {
                           var48 = new class0();
                           var48.field2 = var9;
                           var48.field4 = var9.field2898;
                           client.field357.method3895(var48);
                        }

                        if(client.field446 > var9.field2921 && var9.field2899 != null) {
                           var48 = new class0();
                           var48.field2 = var9;
                           var48.field4 = var9.field2899;
                           client.field357.method3895(var48);
                        }

                        if(client.field408 > var9.field2921 && null != var9.field2891) {
                           var48 = new class0();
                           var48.field2 = var9;
                           var48.field4 = var9.field2891;
                           client.field357.method3895(var48);
                        }

                        if(client.field402 > var9.field2921 && null != var9.field2905) {
                           var48 = new class0();
                           var48.field2 = var9;
                           var48.field4 = var9.field2905;
                           client.field357.method3895(var48);
                        }

                        if(client.field476 > var9.field2921 && var9.field2900 != null) {
                           var48 = new class0();
                           var48.field2 = var9;
                           var48.field4 = var9.field2900;
                           client.field357.method3895(var48);
                        }

                        var9.field2921 = client.field506;
                        if(var9.field2897 != null) {
                           for(var36 = 0; var36 < client.field518; ++var36) {
                              class0 var61 = new class0();
                              var61.field2 = var9;
                              var61.field7 = client.field520[var36];
                              var61.field8 = client.field519[var36];
                              var61.field4 = var9.field2897;
                              client.field357.method3895(var61);
                           }
                        }
                     }
                  }

                  if(!var9.field2793 && client.field492 == null && class159.field2356 == null && !client.field540) {
                     if((var9.field2787 >= 0 || var9.field2871 != 0) && class143.field2198 >= var12 && class143.field2201 >= var13 && class143.field2198 < var14 && class143.field2201 < var15) {
                        if(var9.field2787 >= 0) {
                           class99.field1699 = var0[var9.field2787];
                        } else {
                           class99.field1699 = var9;
                        }
                     }

                     if(var9.field2796 == 8 && class143.field2198 >= var12 && class143.field2201 >= var13 && class143.field2198 < var14 && class143.field2201 < var15) {
                        class170.field2726 = var9;
                     }

                     if(var9.field2867 > var9.field2810) {
                        class88.method2006(var9, var9.field2866 + var10, var11, var9.field2810, var9.field2867, class143.field2198, class143.field2201);
                     }
                  }
               }
            }
         }
      }

   }

   @ObfuscatedName("l")
   public static String method750(long var0) {
      if(var0 > 0L && var0 < 6582952005840035281L) {
         if(var0 % 37L == 0L) {
            return null;
         } else {
            int var2 = 0;

            for(long var3 = var0; var3 != 0L; var3 /= 37L) {
               ++var2;
            }

            StringBuilder var5;
            char var8;
            for(var5 = new StringBuilder(var2); 0L != var0; var5.append(var8)) {
               long var6 = var0;
               var0 /= 37L;
               var8 = class165.field2687[(int)(var6 - var0 * 37L)];
               if(var8 == 95) {
                  int var9 = var5.length() - 1;
                  var5.setCharAt(var9, Character.toUpperCase(var5.charAt(var9)));
                  var8 = 160;
               }
            }

            var5.reverse();
            var5.setCharAt(0, Character.toUpperCase(var5.charAt(0)));
            return var5.toString();
         }
      } else {
         return null;
      }
   }
}
