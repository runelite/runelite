import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.StringReader;
import java.io.StringWriter;
import java.net.URL;
import java.net.URLConnection;
import java.util.Random;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("s")
public final class class16 extends class207 {
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 2082359781
   )
   int field230;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 1244821827
   )
   int field231;
   @ObfuscatedName("nk")
   @ObfuscatedGetter(
      intValue = 400978095
   )
   static int field233;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -1833005609
   )
   int field234;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 1792290881
   )
   int field235;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 1733106597
   )
   int field236;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 1923517143
   )
   int field237;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 1482256725
   )
   int field238;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -1403748347
   )
   int field239;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 1938463291
   )
   int field240 = 0;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -2022489989
   )
   int field241;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 1883040487
   )
   int field242;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -2020557315
   )
   int field244 = -1;

   @ObfuscatedName("i")
   static int method182(int var0) {
      class35 var1 = (class35)class11.field172.method3761((long)var0);
      return var1 == null?-1:(class11.field173.field3096 == var1.field3101?-1:((class35)var1.field3101).field789);
   }

   @ObfuscatedName("ct")
   @ObfuscatedSignature(
      signature = "([Lclass172;IIIIIIII)V",
      garbageValue = "2074699794"
   )
   static final void method183(class172[] var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      for(int var8 = 0; var8 < var0.length; ++var8) {
         class172 var9 = var0[var8];
         if(null != var9 && (!var9.field2758 || var9.field2849 == 0 || var9.field2837 || class42.method898(var9) != 0 || var9 == client.field297 || 1338 == var9.field2763) && var9.field2778 == var1 && (!var9.field2758 || !class18.method195(var9))) {
            int var10 = var6 + var9.field2772;
            int var11 = var9.field2773 + var7;
            int var12;
            int var13;
            int var14;
            int var15;
            int var16;
            int var17;
            int var18;
            int var19;
            if(2 == var9.field2849) {
               var12 = var2;
               var13 = var3;
               var14 = var4;
               var15 = var5;
            } else if(9 == var9.field2849) {
               var16 = var10;
               var17 = var11;
               var18 = var9.field2774 + var10;
               var19 = var11 + var9.field2890;
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
               var16 = var10 + var9.field2774;
               var17 = var11 + var9.field2890;
               var12 = var10 > var2?var10:var2;
               var13 = var11 > var3?var11:var3;
               var14 = var16 < var4?var16:var4;
               var15 = var17 < var5?var17:var5;
            }

            if(var9 == client.field536) {
               client.field469 = true;
               client.field470 = var10;
               client.field321 = var11;
            }

            if(!var9.field2758 || var12 < var14 && var13 < var15) {
               var16 = class139.field2162;
               var17 = class139.field2171;
               if(0 != class139.field2168) {
                  var16 = class139.field2169;
                  var17 = class139.field2163;
               }

               int var21;
               int var22;
               int var23;
               int var24;
               int var27;
               int var29;
               int var36;
               int var47;
               int var53;
               if(1337 == var9.field2763) {
                  if(!client.field316 && !client.field308 && var16 >= var12 && var17 >= var13 && var16 < var14 && var17 < var15) {
                     if(0 == client.field301 && !client.field408) {
                        class118.method2510("Walk here", "", 23, 0, var16 - var12, var17 - var13);
                     }

                     var18 = -1;
                     var19 = -1;

                     for(var36 = 0; var36 < class104.field1853; ++var36) {
                        var21 = class104.field1862[var36];
                        var22 = var21 & 127;
                        var23 = var21 >> 7 & 127;
                        var24 = var21 >> 29 & 3;
                        var47 = var21 >> 14 & 32767;
                        if(var19 != var21) {
                           var19 = var21;
                           if(2 == var24 && class107.field1906.method1983(class75.field1386, var22, var23, var21) >= 0) {
                              class40 var52 = class48.method996(var47);
                              if(null != var52.field920) {
                                 var52 = var52.method824();
                              }

                              if(var52 == null) {
                                 continue;
                              }

                              if(1 == client.field301) {
                                 class118.method2510("Use", client.field442 + " " + "->" + " " + class24.method592('\uffff') + var52.field927, 1, var21, var22, var23);
                              } else if(client.field408) {
                                 if((client.field573 & 4) == 4) {
                                    class118.method2510(client.field446, client.field447 + " " + "->" + " " + class24.method592('\uffff') + var52.field927, 2, var21, var22, var23);
                                 }
                              } else {
                                 String[] var51 = var52.field944;
                                 if(client.field459) {
                                    var51 = class100.method2242(var51);
                                 }

                                 if(var51 != null) {
                                    for(var53 = 4; var53 >= 0; --var53) {
                                       if(null != var51[var53]) {
                                          short var59 = 0;
                                          if(var53 == 0) {
                                             var59 = 3;
                                          }

                                          if(1 == var53) {
                                             var59 = 4;
                                          }

                                          if(var53 == 2) {
                                             var59 = 5;
                                          }

                                          if(var53 == 3) {
                                             var59 = 6;
                                          }

                                          if(4 == var53) {
                                             var59 = 1001;
                                          }

                                          class118.method2510(var51[var53], class24.method592('\uffff') + var52.field927, var59, var21, var22, var23);
                                       }
                                    }
                                 }

                                 class118.method2510("Examine", class24.method592('\uffff') + var52.field927, 1002, var52.field924 << 14, var22, var23);
                              }
                           }

                           class34 var56;
                           int[] var58;
                           class2 var62;
                           if(var24 == 1) {
                              class34 var54 = client.field324[var47];
                              if(null == var54) {
                                 continue;
                              }

                              if(var54.field779.field885 == 1 && (var54.field839 & 127) == 64 && 64 == (var54.field848 & 127)) {
                                 for(var27 = 0; var27 < client.field561; ++var27) {
                                    var56 = client.field324[client.field326[var27]];
                                    if(null != var56 && var56 != var54 && 1 == var56.field779.field885 && var54.field839 == var56.field839 && var56.field848 == var54.field848) {
                                       class34.method726(var56.field779, client.field326[var27], var22, var23);
                                    }
                                 }

                                 var27 = class32.field749;
                                 var58 = class32.field755;

                                 for(var29 = 0; var29 < var27; ++var29) {
                                    var62 = client.field410[var58[var29]];
                                    if(null != var62 && var54.field839 == var62.field839 && var54.field848 == var62.field848) {
                                       class8.method108(var62, var58[var29], var22, var23);
                                    }
                                 }
                              }

                              class34.method726(var54.field779, var47, var22, var23);
                           }

                           if(0 == var24) {
                              class2 var55 = client.field410[var47];
                              if(null == var55) {
                                 continue;
                              }

                              if((var55.field839 & 127) == 64 && (var55.field848 & 127) == 64) {
                                 for(var27 = 0; var27 < client.field561; ++var27) {
                                    var56 = client.field324[client.field326[var27]];
                                    if(null != var56 && var56.field779.field885 == 1 && var56.field839 == var55.field839 && var55.field848 == var56.field848) {
                                       class34.method726(var56.field779, client.field326[var27], var22, var23);
                                    }
                                 }

                                 var27 = class32.field749;
                                 var58 = class32.field755;

                                 for(var29 = 0; var29 < var27; ++var29) {
                                    var62 = client.field410[var58[var29]];
                                    if(null != var62 && var55 != var62 && var55.field839 == var62.field839 && var55.field848 == var62.field848) {
                                       class8.method108(var62, var58[var29], var22, var23);
                                    }
                                 }
                              }

                              if(client.field419 != var47) {
                                 class8.method108(var55, var47, var22, var23);
                              } else {
                                 var18 = var21;
                              }
                           }

                           if(var24 == 3) {
                              class198 var57 = client.field420[class75.field1386][var22][var23];
                              if(var57 != null) {
                                 for(class28 var60 = (class28)var57.method3774(); null != var60; var60 = (class28)var57.method3776()) {
                                    class51 var61 = class22.method581(var60.field677);
                                    if(client.field301 == 1) {
                                       class118.method2510("Use", client.field442 + " " + "->" + " " + class24.method592(16748608) + var61.field1121, 16, var60.field677, var22, var23);
                                    } else if(client.field408) {
                                       if(1 == (client.field573 & 1)) {
                                          class118.method2510(client.field446, client.field447 + " " + "->" + " " + class24.method592(16748608) + var61.field1121, 17, var60.field677, var22, var23);
                                       }
                                    } else {
                                       String[] var63 = var61.field1135;
                                       if(client.field459) {
                                          var63 = class100.method2242(var63);
                                       }

                                       for(int var64 = 4; var64 >= 0; --var64) {
                                          if(var63 != null && var63[var64] != null) {
                                             byte var31 = 0;
                                             if(0 == var64) {
                                                var31 = 18;
                                             }

                                             if(1 == var64) {
                                                var31 = 19;
                                             }

                                             if(var64 == 2) {
                                                var31 = 20;
                                             }

                                             if(var64 == 3) {
                                                var31 = 21;
                                             }

                                             if(var64 == 4) {
                                                var31 = 22;
                                             }

                                             class118.method2510(var63[var64], class24.method592(16748608) + var61.field1121, var31, var60.field677, var22, var23);
                                          } else if(2 == var64) {
                                             class118.method2510("Take", class24.method592(16748608) + var61.field1121, 20, var60.field677, var22, var23);
                                          }
                                       }

                                       class118.method2510("Examine", class24.method592(16748608) + var61.field1121, 1004, var60.field677, var22, var23);
                                    }
                                 }
                              }
                           }
                        }
                     }

                     if(-1 != var18) {
                        var36 = var18 & 127;
                        var21 = var18 >> 7 & 127;
                        class2 var48 = client.field410[client.field419];
                        class8.method108(var48, client.field419, var36, var21);
                     }
                  }
               } else if(1338 == var9.field2763) {
                  if((client.field524 == 0 || client.field524 == 3) && (class139.field2168 == 1 || !class94.field1617 && 4 == class139.field2168)) {
                     class174 var44 = var9.method3360(true);
                     if(null != var44) {
                        var19 = class139.field2169 - var10;
                        var36 = class139.field2163 - var11;
                        if(var44.method3404(var19, var36)) {
                           var19 -= var44.field2903 / 2;
                           var36 -= var44.field2900 / 2;
                           var21 = client.field374 + client.field522 & 2047;
                           var22 = class90.field1587[var21];
                           var23 = class90.field1590[var21];
                           var22 = var22 * (256 + client.field359) >> 8;
                           var23 = var23 * (client.field359 + 256) >> 8;
                           var24 = var36 * var22 + var19 * var23 >> 11;
                           var47 = var23 * var36 - var22 * var19 >> 11;
                           int var50 = class148.field2249.field839 + var24 >> 7;
                           var27 = class148.field2249.field848 - var47 >> 7;
                           client.field329.method2686(204);
                           client.field329.method2438(18);
                           client.field329.method2440(class92.field1598 + var27);
                           client.field329.method2564(var50 + class98.field1683);
                           client.field329.method2476(class136.field2121[82]?(class136.field2121[81]?2:1):0);
                           client.field329.method2438(var19);
                           client.field329.method2438(var36);
                           client.field329.method2541(client.field374);
                           client.field329.method2438(57);
                           client.field329.method2438(client.field522);
                           client.field329.method2438(client.field359);
                           client.field329.method2438(89);
                           client.field329.method2541(class148.field2249.field839);
                           client.field329.method2541(class148.field2249.field848);
                           client.field329.method2438(63);
                           client.field296 = var50;
                           client.field319 = var27;
                        }
                     }
                  }
               } else {
                  boolean var38;
                  if(!client.field308 && var16 >= var12 && var17 >= var13 && var16 < var14 && var17 < var15) {
                     var18 = var16 - var10;
                     var19 = var17 - var11;
                     if(var9.field2762 == 1) {
                        class118.method2510(var9.field2874, "", 24, 0, 0, var9.field2759 * -1);
                     }

                     String var20;
                     if(var9.field2762 == 2 && !client.field408) {
                        if(class156.method3118(class42.method898(var9)) == 0) {
                           var20 = null;
                        } else if(var9.field2806 != null && var9.field2806.trim().length() != 0) {
                           var20 = var9.field2806;
                        } else {
                           var20 = null;
                        }

                        if(null != var20) {
                           class118.method2510(var20, class24.method592('\uff00') + var9.field2832, 25, 0, -1, var9.field2759 * -1);
                        }
                     }

                     if(3 == var9.field2762) {
                        class118.method2510("Close", "", 26, 0, 0, var9.field2759 * -1);
                     }

                     if(4 == var9.field2762) {
                        class118.method2510(var9.field2874, "", 28, 0, 0, var9.field2759 * -1);
                     }

                     if(5 == var9.field2762) {
                        class118.method2510(var9.field2874, "", 29, 0, 0, var9.field2759 * -1);
                     }

                     if(var9.field2762 == 6 && client.field452 == null) {
                        class118.method2510(var9.field2874, "", 30, 0, -1, var9.field2759 * -1);
                     }

                     if(2 == var9.field2849) {
                        var36 = 0;

                        for(var21 = 0; var21 < var9.field2890; ++var21) {
                           for(var22 = 0; var22 < var9.field2774; ++var22) {
                              var23 = var22 * (32 + var9.field2823);
                              var24 = var21 * (var9.field2824 + 32);
                              if(var36 < 20) {
                                 var23 += var9.field2749[var36];
                                 var24 += var9.field2826[var36];
                              }

                              if(var18 >= var23 && var19 >= var24 && var18 < 32 + var23 && var19 < 32 + var24) {
                                 client.field406 = var36;
                                 class141.field2181 = var9;
                                 if(var9.field2875[var36] > 0) {
                                    class51 var25 = class22.method581(var9.field2875[var36] - 1);
                                    if(1 == client.field301 && class102.method2251(class42.method898(var9))) {
                                       if(class47.field1074 != var9.field2759 * -1 || var36 != class164.field2672) {
                                          class118.method2510("Use", client.field442 + " " + "->" + " " + class24.method592(16748608) + var25.field1121, 31, var25.field1151, var36, var9.field2759 * -1);
                                       }
                                    } else if(client.field408 && class102.method2251(class42.method898(var9))) {
                                       if(16 == (client.field573 & 16)) {
                                          class118.method2510(client.field446, client.field447 + " " + "->" + " " + class24.method592(16748608) + var25.field1121, 32, var25.field1151, var36, var9.field2759 * -1);
                                       }
                                    } else {
                                       String[] var26 = var25.field1136;
                                       if(client.field459) {
                                          var26 = class100.method2242(var26);
                                       }

                                       if(class102.method2251(class42.method898(var9))) {
                                          for(var27 = 4; var27 >= 3; --var27) {
                                             if(null != var26 && var26[var27] != null) {
                                                byte var28;
                                                if(var27 == 3) {
                                                   var28 = 36;
                                                } else {
                                                   var28 = 37;
                                                }

                                                class118.method2510(var26[var27], class24.method592(16748608) + var25.field1121, var28, var25.field1151, var36, var9.field2759 * -1);
                                             } else if(4 == var27) {
                                                class118.method2510("Drop", class24.method592(16748608) + var25.field1121, 37, var25.field1151, var36, var9.field2759 * -1);
                                             }
                                          }
                                       }

                                       var53 = class42.method898(var9);
                                       boolean var49 = 0 != (var53 >> 31 & 1);
                                       if(var49) {
                                          class118.method2510("Use", class24.method592(16748608) + var25.field1121, 38, var25.field1151, var36, var9.field2759 * -1);
                                       }

                                       class177 var10000 = (class177)null;
                                       byte var30;
                                       if(class102.method2251(class42.method898(var9)) && null != var26) {
                                          for(var29 = 2; var29 >= 0; --var29) {
                                             if(null != var26[var29]) {
                                                var30 = 0;
                                                if(0 == var29) {
                                                   var30 = 33;
                                                }

                                                if(var29 == 1) {
                                                   var30 = 34;
                                                }

                                                if(2 == var29) {
                                                   var30 = 35;
                                                }

                                                class118.method2510(var26[var29], class24.method592(16748608) + var25.field1121, var30, var25.field1151, var36, var9.field2759 * -1);
                                             }
                                          }
                                       }

                                       var26 = var9.field2780;
                                       if(client.field459) {
                                          var26 = class100.method2242(var26);
                                       }

                                       if(var26 != null) {
                                          for(var29 = 4; var29 >= 0; --var29) {
                                             if(var26[var29] != null) {
                                                var30 = 0;
                                                if(0 == var29) {
                                                   var30 = 39;
                                                }

                                                if(var29 == 1) {
                                                   var30 = 40;
                                                }

                                                if(2 == var29) {
                                                   var30 = 41;
                                                }

                                                if(3 == var29) {
                                                   var30 = 42;
                                                }

                                                if(var29 == 4) {
                                                   var30 = 43;
                                                }

                                                class118.method2510(var26[var29], class24.method592(16748608) + var25.field1121, var30, var25.field1151, var36, var9.field2759 * -1);
                                             }
                                          }
                                       }

                                       class118.method2510("Examine", class24.method592(16748608) + var25.field1121, 1005, var25.field1151, var36, var9.field2759 * -1);
                                    }
                                 }
                              }

                              ++var36;
                           }
                        }
                     }

                     if(var9.field2758) {
                        if(client.field408) {
                           var21 = class42.method898(var9);
                           var38 = (var21 >> 21 & 1) != 0;
                           if(var38 && 32 == (client.field573 & 32)) {
                              class118.method2510(client.field446, client.field447 + " " + "->" + " " + var9.field2830, 58, 0, var9.field2825, var9.field2759 * -1);
                           }
                        } else {
                           for(var36 = 9; var36 >= 5; --var36) {
                              String var39;
                              if(!class41.method839(class42.method898(var9), var36) && var9.field2891 == null) {
                                 var39 = null;
                              } else if(null != var9.field2831 && var9.field2831.length > var36 && null != var9.field2831[var36] && var9.field2831[var36].trim().length() != 0) {
                                 var39 = var9.field2831[var36];
                              } else {
                                 var39 = null;
                              }

                              if(var39 != null) {
                                 class118.method2510(var39, var9.field2830, 1007, var36 + 1, var9.field2825, var9.field2759 * -1);
                              }
                           }

                           if(class156.method3118(class42.method898(var9)) == 0) {
                              var20 = null;
                           } else if(null != var9.field2806 && var9.field2806.trim().length() != 0) {
                              var20 = var9.field2806;
                           } else {
                              var20 = null;
                           }

                           if(null != var20) {
                              class118.method2510(var20, var9.field2830, 25, 0, var9.field2825, var9.field2759 * -1);
                           }

                           for(var22 = 4; var22 >= 0; --var22) {
                              String var43;
                              if(!class41.method839(class42.method898(var9), var22) && var9.field2891 == null) {
                                 var43 = null;
                              } else if(null != var9.field2831 && var9.field2831.length > var22 && null != var9.field2831[var22] && var9.field2831[var22].trim().length() != 0) {
                                 var43 = var9.field2831[var22];
                              } else {
                                 var43 = null;
                              }

                              if(null != var43) {
                                 class118.method2510(var43, var9.field2830, 57, var22 + 1, var9.field2825, var9.field2759 * -1);
                              }
                           }

                           var23 = class42.method898(var9);
                           boolean var41 = 0 != (var23 & 1);
                           if(var41) {
                              class118.method2510("Continue", "", 30, 0, var9.field2825, var9.field2759 * -1);
                           }
                        }
                     }
                  }

                  if(0 == var9.field2849) {
                     if(!var9.field2758 && class18.method195(var9) && var9 != class74.field1376) {
                        continue;
                     }

                     method183(var0, var9.field2759 * -1, var12, var13, var14, var15, var10 - var9.field2829, var11 - var9.field2886);
                     if(null != var9.field2881) {
                        method183(var9.field2881, var9.field2759 * -1, var12, var13, var14, var15, var10 - var9.field2829, var11 - var9.field2886);
                     }

                     class3 var32 = (class3)client.field449.method3744((long)(var9.field2759 * -1));
                     if(null != var32) {
                        if(0 == var32.field61 && class139.field2162 >= var12 && class139.field2171 >= var13 && class139.field2162 < var14 && class139.field2171 < var15 && !client.field308 && !client.field458) {
                           for(class0 var34 = (class0)client.field465.method3773(); var34 != null; var34 = (class0)client.field465.method3772()) {
                              if(var34.field1) {
                                 var34.method3853();
                                 var34.field2.field2882 = false;
                              }
                           }

                           if(0 == class83.field1458) {
                              client.field536 = null;
                              client.field297 = null;
                           }

                           if(!client.field308) {
                              client.field437[0] = "Cancel";
                              client.field365[0] = "";
                              client.field433[0] = 1006;
                              client.field430 = 1;
                           }
                        }

                        var19 = var32.field66;
                        if(class149.method3102(var19)) {
                           method183(class172.field2757[var19], -1, var12, var13, var14, var15, var10, var11);
                        }
                     }
                  }

                  if(var9.field2758) {
                     class0 var33;
                     if(!var9.field2884) {
                        if(var9.field2880 && class139.field2162 >= var12 && class139.field2171 >= var13 && class139.field2162 < var14 && class139.field2171 < var15) {
                           for(var33 = (class0)client.field465.method3773(); null != var33; var33 = (class0)client.field465.method3772()) {
                              if(var33.field1 && var33.field5 == var33.field2.field2858) {
                                 var33.method3853();
                              }
                           }
                        }
                     } else if(class139.field2162 >= var12 && class139.field2171 >= var13 && class139.field2162 < var14 && class139.field2171 < var15) {
                        for(var33 = (class0)client.field465.method3773(); null != var33; var33 = (class0)client.field465.method3772()) {
                           if(var33.field1) {
                              var33.method3853();
                              var33.field2.field2882 = false;
                           }
                        }

                        if(0 == class83.field1458) {
                           client.field536 = null;
                           client.field297 = null;
                        }

                        if(!client.field308) {
                           client.field437[0] = "Cancel";
                           client.field365[0] = "";
                           client.field433[0] = 1006;
                           client.field430 = 1;
                        }
                     }

                     boolean var35;
                     if(class139.field2162 >= var12 && class139.field2171 >= var13 && class139.field2162 < var14 && class139.field2171 < var15) {
                        var35 = true;
                     } else {
                        var35 = false;
                     }

                     boolean var37 = false;
                     if((class139.field2161 == 1 || !class94.field1617 && class139.field2161 == 4) && var35) {
                        var37 = true;
                     }

                     var38 = false;
                     if((1 == class139.field2168 || !class94.field1617 && class139.field2168 == 4) && class139.field2169 >= var12 && class139.field2163 >= var13 && class139.field2169 < var14 && class139.field2163 < var15) {
                        var38 = true;
                     }

                     if(var38) {
                        class49.method1007(var9, class139.field2169 - var10, class139.field2163 - var11);
                     }

                     if(null != client.field536 && client.field536 != var9 && var35) {
                        var22 = class42.method898(var9);
                        boolean var40 = 0 != (var22 >> 20 & 1);
                        if(var40) {
                           client.field312 = var9;
                        }
                     }

                     if(client.field297 == var9) {
                        client.field466 = true;
                        client.field467 = var10;
                        client.field468 = var11;
                     }

                     if(var9.field2837) {
                        class0 var42;
                        if(var35 && client.field486 != 0 && null != var9.field2858) {
                           var42 = new class0();
                           var42.field1 = true;
                           var42.field2 = var9;
                           var42.field6 = client.field486;
                           var42.field5 = var9.field2858;
                           client.field465.method3768(var42);
                        }

                        if(client.field536 != null || null != class132.field2073 || client.field308) {
                           var38 = false;
                           var37 = false;
                           var35 = false;
                        }

                        if(!var9.field2883 && var38) {
                           var9.field2883 = true;
                           if(null != var9.field2755) {
                              var42 = new class0();
                              var42.field1 = true;
                              var42.field2 = var9;
                              var42.field3 = class139.field2169 - var10;
                              var42.field6 = class139.field2163 - var11;
                              var42.field5 = var9.field2755;
                              client.field465.method3768(var42);
                           }
                        }

                        if(var9.field2883 && var37 && var9.field2840 != null) {
                           var42 = new class0();
                           var42.field1 = true;
                           var42.field2 = var9;
                           var42.field3 = class139.field2162 - var10;
                           var42.field6 = class139.field2171 - var11;
                           var42.field5 = var9.field2840;
                           client.field465.method3768(var42);
                        }

                        if(var9.field2883 && !var37) {
                           var9.field2883 = false;
                           if(var9.field2863 != null) {
                              var42 = new class0();
                              var42.field1 = true;
                              var42.field2 = var9;
                              var42.field3 = class139.field2162 - var10;
                              var42.field6 = class139.field2171 - var11;
                              var42.field5 = var9.field2863;
                              client.field489.method3768(var42);
                           }
                        }

                        if(var37 && var9.field2842 != null) {
                           var42 = new class0();
                           var42.field1 = true;
                           var42.field2 = var9;
                           var42.field3 = class139.field2162 - var10;
                           var42.field6 = class139.field2171 - var11;
                           var42.field5 = var9.field2842;
                           client.field465.method3768(var42);
                        }

                        if(!var9.field2882 && var35) {
                           var9.field2882 = true;
                           if(var9.field2807 != null) {
                              var42 = new class0();
                              var42.field1 = true;
                              var42.field2 = var9;
                              var42.field3 = class139.field2162 - var10;
                              var42.field6 = class139.field2171 - var11;
                              var42.field5 = var9.field2807;
                              client.field465.method3768(var42);
                           }
                        }

                        if(var9.field2882 && var35 && var9.field2844 != null) {
                           var42 = new class0();
                           var42.field1 = true;
                           var42.field2 = var9;
                           var42.field3 = class139.field2162 - var10;
                           var42.field6 = class139.field2171 - var11;
                           var42.field5 = var9.field2844;
                           client.field465.method3768(var42);
                        }

                        if(var9.field2882 && !var35) {
                           var9.field2882 = false;
                           if(null != var9.field2845) {
                              var42 = new class0();
                              var42.field1 = true;
                              var42.field2 = var9;
                              var42.field3 = class139.field2162 - var10;
                              var42.field6 = class139.field2171 - var11;
                              var42.field5 = var9.field2845;
                              client.field489.method3768(var42);
                           }
                        }

                        if(var9.field2856 != null) {
                           var42 = new class0();
                           var42.field2 = var9;
                           var42.field5 = var9.field2856;
                           client.field488.method3768(var42);
                        }

                        class0 var45;
                        if(var9.field2838 != null && client.field340 > var9.field2756) {
                           if(null != var9.field2851 && client.field340 - var9.field2756 <= 32) {
                              label1445:
                              for(var21 = var9.field2756; var21 < client.field340; ++var21) {
                                 var22 = client.field474[var21 & 31];

                                 for(var23 = 0; var23 < var9.field2851.length; ++var23) {
                                    if(var22 == var9.field2851[var23]) {
                                       var45 = new class0();
                                       var45.field2 = var9;
                                       var45.field5 = var9.field2838;
                                       client.field465.method3768(var45);
                                       break label1445;
                                    }
                                 }
                              }
                           } else {
                              var42 = new class0();
                              var42.field2 = var9;
                              var42.field5 = var9.field2838;
                              client.field465.method3768(var42);
                           }

                           var9.field2756 = client.field340;
                        }

                        if(var9.field2852 != null && client.field411 > var9.field2789) {
                           if(var9.field2751 != null && client.field411 - var9.field2789 <= 32) {
                              label1421:
                              for(var21 = var9.field2789; var21 < client.field411; ++var21) {
                                 var22 = client.field476[var21 & 31];

                                 for(var23 = 0; var23 < var9.field2751.length; ++var23) {
                                    if(var22 == var9.field2751[var23]) {
                                       var45 = new class0();
                                       var45.field2 = var9;
                                       var45.field5 = var9.field2852;
                                       client.field465.method3768(var45);
                                       break label1421;
                                    }
                                 }
                              }
                           } else {
                              var42 = new class0();
                              var42.field2 = var9;
                              var42.field5 = var9.field2852;
                              client.field465.method3768(var42);
                           }

                           var9.field2789 = client.field411;
                        }

                        if(null != var9.field2854 && client.field521 > var9.field2846) {
                           if(null != var9.field2855 && client.field521 - var9.field2846 <= 32) {
                              label1397:
                              for(var21 = var9.field2846; var21 < client.field521; ++var21) {
                                 var22 = client.field463[var21 & 31];

                                 for(var23 = 0; var23 < var9.field2855.length; ++var23) {
                                    if(var9.field2855[var23] == var22) {
                                       var45 = new class0();
                                       var45.field2 = var9;
                                       var45.field5 = var9.field2854;
                                       client.field465.method3768(var45);
                                       break label1397;
                                    }
                                 }
                              }
                           } else {
                              var42 = new class0();
                              var42.field2 = var9;
                              var42.field5 = var9.field2854;
                              client.field465.method3768(var42);
                           }

                           var9.field2846 = client.field521;
                        }

                        if(client.field480 > var9.field2785 * -1 && var9.field2885 != null) {
                           var42 = new class0();
                           var42.field2 = var9;
                           var42.field5 = var9.field2885;
                           client.field465.method3768(var42);
                        }

                        if(client.field481 > var9.field2785 * -1 && var9.field2861 != null) {
                           var42 = new class0();
                           var42.field2 = var9;
                           var42.field5 = var9.field2861;
                           client.field465.method3768(var42);
                        }

                        if(client.field482 > var9.field2785 * -1 && var9.field2862 != null) {
                           var42 = new class0();
                           var42.field2 = var9;
                           var42.field5 = var9.field2862;
                           client.field465.method3768(var42);
                        }

                        if(client.field483 > var9.field2785 * -1 && null != var9.field2867) {
                           var42 = new class0();
                           var42.field2 = var9;
                           var42.field5 = var9.field2867;
                           client.field465.method3768(var42);
                        }

                        if(client.field484 > var9.field2785 * -1 && var9.field2868 != null) {
                           var42 = new class0();
                           var42.field2 = var9;
                           var42.field5 = var9.field2868;
                           client.field465.method3768(var42);
                        }

                        if(client.field363 > var9.field2785 * -1 && var9.field2828 != null) {
                           var42 = new class0();
                           var42.field2 = var9;
                           var42.field5 = var9.field2828;
                           client.field465.method3768(var42);
                        }

                        var9.field2785 = client.field392 * -1;
                        if(null != var9.field2860) {
                           for(var21 = 0; var21 < client.field500; ++var21) {
                              class0 var46 = new class0();
                              var46.field2 = var9;
                              var46.field7 = client.field385[var21];
                              var46.field8 = client.field512[var21];
                              var46.field5 = var9.field2860;
                              client.field465.method3768(var46);
                           }
                        }
                     }
                  }

                  if(!var9.field2758 && null == client.field536 && class132.field2073 == null && !client.field308) {
                     if((var9.field2872 >= 0 || var9.field2786 != 0) && class139.field2162 >= var12 && class139.field2171 >= var13 && class139.field2162 < var14 && class139.field2171 < var15) {
                        if(var9.field2872 >= 0) {
                           class74.field1376 = var0[var9.field2872];
                        } else {
                           class74.field1376 = var9;
                        }
                     }

                     if(var9.field2849 == 8 && class139.field2162 >= var12 && class139.field2171 >= var13 && class139.field2162 < var14 && class139.field2171 < var15) {
                        class52.field1171 = var9;
                     }

                     if(var9.field2783 > var9.field2890) {
                        class13.method158(var9, var10 + var9.field2774, var11, var9.field2890, var9.field2783, class139.field2162, class139.field2171);
                     }
                  }
               }
            }
         }
      }

   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/Throwable;B)V",
      garbageValue = "1"
   )
   public static void method184(String var0, Throwable var1) {
      try {
         String var2 = "";
         if(null != var1) {
            Throwable var4 = var1;
            String var5;
            if(var1 instanceof class147) {
               class147 var6 = (class147)var1;
               var5 = var6.field2234 + " | ";
               var4 = var6.field2231;
            } else {
               var5 = "";
            }

            StringWriter var18 = new StringWriter();
            PrintWriter var7 = new PrintWriter(var18);
            var4.printStackTrace(var7);
            var7.close();
            String var8 = var18.toString();
            BufferedReader var9 = new BufferedReader(new StringReader(var8));
            String var10 = var9.readLine();

            while(true) {
               String var11 = var9.readLine();
               if(var11 == null) {
                  var5 = var5 + "| " + var10;
                  var2 = var5;
                  break;
               }

               int var12 = var11.indexOf(40);
               int var13 = var11.indexOf(41, 1 + var12);
               if(var12 >= 0 && var13 >= 0) {
                  String var14 = var11.substring(1 + var12, var13);
                  int var15 = var14.indexOf(".java:");
                  if(var15 >= 0) {
                     var14 = var14.substring(0, var15) + var14.substring(var15 + 5);
                     var5 = var5 + var14 + ' ';
                     continue;
                  }

                  var11 = var11.substring(0, var12);
               }

               var11 = var11.trim();
               var11 = var11.substring(var11.lastIndexOf(32) + 1);
               var11 = var11.substring(var11.lastIndexOf(9) + 1);
               var5 = var5 + var11 + ' ';
            }
         }

         if(null != var0) {
            if(var1 != null) {
               var2 = var2 + " | ";
            }

            var2 = var2 + var0;
         }

         System.out.println("Error: " + var2);
         var2 = var2.replace(':', '.');
         var2 = var2.replace('@', '_');
         var2 = var2.replace('&', '_');
         var2 = var2.replace('#', '_');
         if(class217.field3158 == null) {
            return;
         }

         URL var3 = new URL(class217.field3158.getCodeBase(), "clienterror.ws?c=" + class147.field2232 + "&u=" + class147.field2235 + "&v1=" + class135.field2091 + "&v2=" + class135.field2090 + "&e=" + var2);
         DataInputStream var17 = new DataInputStream(var3.openStream());
         var17.read();
         var17.close();
      } catch (Exception var16) {
         ;
      }

   }

   @ObfuscatedName("l")
   static final int method185(long var0, String var2) {
      Random var3 = new Random();
      class118 var4 = new class118(128);
      class118 var5 = new class118(128);
      int[] var6 = new int[]{var3.nextInt(), var3.nextInt(), (int)(var0 >> 32), (int)var0};
      var4.method2438(10);

      int var7;
      for(var7 = 0; var7 < 4; ++var7) {
         var4.method2441(var3.nextInt());
      }

      var4.method2441(var6[0]);
      var4.method2441(var6[1]);
      var4.method2570(var0);
      var4.method2570(0L);

      for(var7 = 0; var7 < 4; ++var7) {
         var4.method2441(var3.nextInt());
      }

      var4.method2624(class9.field156, class9.field157);
      var5.method2438(10);

      for(var7 = 0; var7 < 3; ++var7) {
         var5.method2441(var3.nextInt());
      }

      var5.method2570(var3.nextLong());
      var5.method2442(var3.nextLong());
      byte[] var21 = new byte[24];

      try {
         class148.field2241.method4084(0L);
         class148.field2241.method4108(var21);

         int var8;
         for(var8 = 0; var8 < 24 && 0 == var21[var8]; ++var8) {
            ;
         }

         if(var8 >= 24) {
            throw new IOException();
         }
      } catch (Exception var19) {
         for(int var9 = 0; var9 < 24; ++var9) {
            var21[var9] = -1;
         }
      }

      var5.method2447(var21, 0, 24);
      var5.method2570(var3.nextLong());
      var5.method2624(class9.field156, class9.field157);
      var7 = class36.method742(var2);
      if(0 != var7 % 8) {
         var7 += 8 - var7 % 8;
      }

      class118 var20 = new class118(var7);
      var20.method2444(var2);
      var20.field1998 = var7;
      var20.method2469(var6);
      class118 var22 = new class118(var20.field1998 + 5 + var4.field1998 + var5.field1998);
      var22.method2438(2);
      var22.method2438(var4.field1998);
      var22.method2447(var4.field1995, 0, var4.field1998);
      var22.method2438(var5.field1998);
      var22.method2447(var5.field1995, 0, var5.field1998);
      var22.method2541(var20.field1998);
      var22.method2447(var20.field1995, 0, var20.field1998);
      byte[] var11 = var22.field1995;
      String var10 = class26.method636(var11, 0, var11.length);
      String var12 = var10;

      try {
         URL var13 = new URL(class135.method2838("services", false) + "m=accountappeal/login.ws");
         URLConnection var14 = var13.openConnection();
         var14.setDoInput(true);
         var14.setDoOutput(true);
         var14.setConnectTimeout(5000);
         OutputStreamWriter var15 = new OutputStreamWriter(var14.getOutputStream());
         var15.write("data2=" + class37.method760(var12) + "&dest=" + class37.method760("passwordchoice.ws"));
         var15.flush();
         InputStream var16 = var14.getInputStream();
         var22 = new class118(new byte[1000]);

         do {
            int var17 = var16.read(var22.field1995, var22.field1998, 1000 - var22.field1998);
            if(-1 == var17) {
               var15.close();
               var16.close();
               String var23 = new String(var22.field1995);
               if(var23.startsWith("OFFLINE")) {
                  return 4;
               } else if(var23.startsWith("WRONG")) {
                  return 7;
               } else if(var23.startsWith("RELOAD")) {
                  return 3;
               } else if(var23.startsWith("Not permitted for social network accounts.")) {
                  return 6;
               } else {
                  var22.method2470(var6);

                  while(var22.field1998 > 0 && 0 == var22.field1995[var22.field1998 - 1]) {
                     --var22.field1998;
                  }

                  var23 = new String(var22.field1995, 0, var22.field1998);
                  if(client.method559(var23)) {
                     class164.method3191(var23, true);
                     return 2;
                  } else {
                     return 5;
                  }
               }
            }

            var22.field1998 += var17;
         } while(var22.field1998 < 1000);

         return 5;
      } catch (Throwable var18) {
         var18.printStackTrace();
         return 5;
      }
   }

   @ObfuscatedName("j")
   static void method186(int var0, String var1, String var2) {
      class44.method934(var0, var1, var2, (String)null);
   }

   @ObfuscatedName("cy")
   @ObfuscatedSignature(
      signature = "([Lclass172;II)V",
      garbageValue = "1006578465"
   )
   static final void method187(class172[] var0, int var1) {
      for(int var2 = 0; var2 < var0.length; ++var2) {
         class172 var3 = var0[var2];
         if(var3 != null) {
            if(0 == var3.field2849) {
               if(var3.field2881 != null) {
                  method187(var3.field2881, var1);
               }

               class3 var4 = (class3)client.field449.method3744((long)(var3.field2759 * -1));
               if(null != var4) {
                  class18.method192(var4.field66, var1);
               }
            }

            class0 var5;
            if(var1 == 0 && var3.field2864 != null) {
               var5 = new class0();
               var5.field2 = var3;
               var5.field5 = var3.field2864;
               class126.method2751(var5, 200000);
            }

            if(1 == var1 && var3.field2865 != null) {
               if(var3.field2825 >= 0) {
                  class172 var6 = class31.method698(var3.field2759 * -1);
                  if(null == var6 || null == var6.field2881 || var3.field2825 >= var6.field2881.length || var3 != var6.field2881[var3.field2825]) {
                     continue;
                  }
               }

               var5 = new class0();
               var5.field2 = var3;
               var5.field5 = var3.field2865;
               class126.method2751(var5, 200000);
            }
         }
      }

   }
}
