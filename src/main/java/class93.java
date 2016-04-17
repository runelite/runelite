import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Insets;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ci")
public final class class93 {
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 1351873191
   )
   int field1597;
   @ObfuscatedName("c")
   public class85 field1598;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 1150040805
   )
   public int field1599;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -1380639735
   )
   int field1600;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 2008135083
   )
   int field1601;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 1843927249
   )
   int field1605;

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(IB)I",
      garbageValue = "11"
   )
   public static int method2248(int var0) {
      class47 var2 = (class47)class47.field1073.method3840((long)var0);
      class47 var1;
      if(var2 != null) {
         var1 = var2;
      } else {
         byte[] var3 = class109.field1907.method3403(14, var0);
         var2 = new class47();
         if(null != var3) {
            var2.method1071(new class119(var3));
         }

         class47.field1073.method3842(var2, (long)var0);
         var1 = var2;
      }

      int var7 = var1.field1074;
      int var4 = var1.field1075;
      int var5 = var1.field1076;
      int var6 = class176.field2909[var5 - var4];
      return class176.field2905[var7] >> var4 & var6;
   }

   @ObfuscatedName("av")
   @ObfuscatedSignature(
      signature = "(IIIIS)V",
      garbageValue = "256"
   )
   static final void method2249(int var0, int var1, int var2, int var3) {
      client.field388 = 0;
      boolean var4 = false;
      int var5 = -1;
      int var6 = class32.field771;
      int[] var7 = class32.field762;

      int var8;
      for(var8 = 0; var8 < var6 + client.field343; ++var8) {
         Object var9;
         if(var8 < var6) {
            var9 = client.field550[var7[var8]];
            if(client.field424 == var7[var8]) {
               var4 = true;
               var5 = var8;
               continue;
            }
         } else {
            var9 = client.field546[client.field335[var8 - var6]];
         }

         class96.method2275((class37)var9, var8, var0, var1, var2, var3);
      }

      if(var4) {
         class96.method2275(client.field550[client.field424], var5, var0, var1, var2, var3);
      }

      for(var8 = 0; var8 < client.field388; ++var8) {
         int var18 = client.field390[var8];
         int var10 = client.field533[var8];
         int var11 = client.field419[var8];
         int var12 = client.field566[var8];
         boolean var13 = true;

         while(var13) {
            var13 = false;

            for(int var14 = 0; var14 < var8; ++var14) {
               if(2 + var10 > client.field533[var14] - client.field566[var14] && var10 - var12 < client.field533[var14] + 2 && var18 - var11 < client.field419[var14] + client.field390[var14] && var18 + var11 > client.field390[var14] - client.field419[var14] && client.field533[var14] - client.field566[var14] < var10) {
                  var10 = client.field533[var14] - client.field566[var14];
                  var13 = true;
               }
            }
         }

         client.field400 = client.field390[var8];
         client.field293 = client.field533[var8] = var10;
         String var19 = client.field488[var8];
         if(client.field454 == 0) {
            int var15 = 16776960;
            if(client.field459[var8] < 6) {
               var15 = client.field510[client.field459[var8]];
            }

            if(6 == client.field459[var8]) {
               var15 = client.field399 % 20 < 10?16711680:16776960;
            }

            if(client.field459[var8] == 7) {
               var15 = client.field399 % 20 < 10?255:'\uffff';
            }

            if(client.field459[var8] == 8) {
               var15 = client.field399 % 20 < 10?'뀀':8454016;
            }

            int var16;
            if(9 == client.field459[var8]) {
               var16 = 150 - client.field396[var8];
               if(var16 < 50) {
                  var15 = var16 * 1280 + 16711680;
               } else if(var16 < 100) {
                  var15 = 16776960 - 327680 * (var16 - 50);
               } else if(var16 < 150) {
                  var15 = (var16 - 100) * 5 + '\uff00';
               }
            }

            if(client.field459[var8] == 10) {
               var16 = 150 - client.field396[var8];
               if(var16 < 50) {
                  var15 = var16 * 5 + 16711680;
               } else if(var16 < 100) {
                  var15 = 16711935 - (var16 - 50) * 327680;
               } else if(var16 < 150) {
                  var15 = 255 + 327680 * (var16 - 100) - (var16 - 100) * 5;
               }
            }

            if(client.field459[var8] == 11) {
               var16 = 150 - client.field396[var8];
               if(var16 < 50) {
                  var15 = 16777215 - 327685 * var16;
               } else if(var16 < 100) {
                  var15 = '\uff00' + (var16 - 50) * 327685;
               } else if(var16 < 150) {
                  var15 = 16777215 - (var16 - 100) * 327680;
               }
            }

            if(client.field502[var8] == 0) {
               class33.field781.method4118(var19, client.field400 + var0, var1 + client.field293, var15, 0);
            }

            if(1 == client.field502[var8]) {
               class33.field781.method4120(var19, client.field400 + var0, var1 + client.field293, var15, 0, client.field399);
            }

            if(client.field502[var8] == 2) {
               class33.field781.method4121(var19, client.field400 + var0, client.field293 + var1, var15, 0, client.field399);
            }

            if(client.field502[var8] == 3) {
               class33.field781.method4122(var19, var0 + client.field400, client.field293 + var1, var15, 0, client.field399, 150 - client.field396[var8]);
            }

            if(client.field502[var8] == 4) {
               var16 = (150 - client.field396[var8]) * (class33.field781.method4111(var19) + 100) / 150;
               class79.method1945(client.field400 + var0 - 50, var1, 50 + client.field400 + var0, var3 + var1);
               class33.field781.method4116(var19, var0 + client.field400 + 50 - var16, client.field293 + var1, var15, 0);
               class79.method1889(var0, var1, var2 + var0, var3 + var1);
            }

            if(client.field502[var8] == 5) {
               var16 = 150 - client.field396[var8];
               int var17 = 0;
               if(var16 < 25) {
                  var17 = var16 - 25;
               } else if(var16 > 125) {
                  var17 = var16 - 125;
               }

               class79.method1945(var0, client.field293 + var1 - class33.field781.field3190 - 1, var2 + var0, var1 + client.field293 + 5);
               class33.field781.method4118(var19, client.field400 + var0, var1 + client.field293 + var17, var15, 0);
               class79.method1889(var0, var1, var0 + var2, var3 + var1);
            }
         } else {
            class33.field781.method4118(var19, var0 + client.field400, var1 + client.field293, 16776960, 0);
         }
      }

   }

   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1206480979"
   )
   static void method2250() {
      int var0 = class144.field2192;
      int var1 = class144.field2191;
      int var2 = class133.field2071 - class37.field876 - var0;
      int var3 = class8.field155 - class98.field1671 - var1;
      if(var0 > 0 || var2 > 0 || var1 > 0 || var3 > 0) {
         try {
            Container var4 = client.field294.method3128();
            int var5 = 0;
            int var6 = 0;
            if(class32.field760 == var4) {
               Insets var7 = class32.field760.getInsets();
               var5 = var7.left;
               var6 = var7.top;
            }

            Graphics var9 = var4.getGraphics();
            var9.setColor(Color.black);
            if(var0 > 0) {
               var9.fillRect(var5, var6, var0, class8.field155);
            }

            if(var1 > 0) {
               var9.fillRect(var5, var6, class133.field2071, var1);
            }

            if(var2 > 0) {
               var9.fillRect(var5 + class133.field2071 - var2, var6, var2, class8.field155);
            }

            if(var3 > 0) {
               var9.fillRect(var5, class8.field155 + var6 - var3, class133.field2071, var3);
            }
         } catch (Exception var8) {
            ;
         }
      }

   }

   @ObfuscatedName("cl")
   @ObfuscatedSignature(
      signature = "([Lclass173;IIIIIIIB)V",
      garbageValue = "-62"
   )
   static final void method2251(class173[] var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      for(int var8 = 0; var8 < var0.length; ++var8) {
         class173 var9 = var0[var8];
         if(null != var9 && (!var9.field2757 || 0 == var9.field2824 || var9.field2838 || class31.method776(var9) != 0 || client.field409 == var9 || 1338 == var9.field2762) && var1 == var9.field2777 && (!var9.field2757 || !class219.method4065(var9))) {
            int var10 = var6 + var9.field2848;
            int var11 = var9.field2772 + var7;
            int var12;
            int var13;
            int var14;
            int var15;
            int var16;
            int var17;
            int var18;
            int var19;
            if(2 == var9.field2824) {
               var12 = var2;
               var13 = var3;
               var14 = var4;
               var15 = var5;
            } else if(var9.field2824 == 9) {
               var16 = var10;
               var17 = var11;
               var18 = var9.field2773 + var10;
               var19 = var9.field2774 + var11;
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
               var16 = var9.field2773 + var10;
               var17 = var11 + var9.field2774;
               var12 = var10 > var2?var10:var2;
               var13 = var11 > var3?var11:var3;
               var14 = var16 < var4?var16:var4;
               var15 = var17 < var5?var17:var5;
            }

            if(var9 == client.field465) {
               client.field473 = true;
               client.field474 = var10;
               client.field475 = var11;
            }

            if(!var9.field2757 || var12 < var14 && var13 < var15) {
               var16 = class140.field2151;
               var17 = class140.field2161;
               if(class140.field2157 != 0) {
                  var16 = class140.field2160;
                  var17 = class140.field2159;
               }

               int var22;
               int var23;
               int var40;
               if(1337 == var9.field2762) {
                  if(!client.field507 && !client.field433 && var16 >= var12 && var17 >= var13 && var16 < var14 && var17 < var15) {
                     if(0 == client.field448 && !client.field447) {
                        class23.method671("Walk here", "", 23, 0, var16 - var12, var17 - var13);
                     }

                     var18 = -1;
                     var19 = -1;

                     int var37;
                     for(var37 = 0; var37 < class105.field1851; ++var37) {
                        var40 = class105.field1852[var37];
                        var22 = var40 & 127;
                        var23 = var40 >> 7 & 127;
                        int var41 = var40 >> 29 & 3;
                        int var25 = var40 >> 14 & 32767;
                        if(var19 != var40) {
                           var19 = var40;
                           if(2 == var41 && class30.field717.method2038(class42.field1002, var22, var23, var40) >= 0) {
                              class40 var26 = class133.method2969(var25);
                              if(var26.field925 != null) {
                                 var26 = var26.method894();
                              }

                              if(null == var26) {
                                 continue;
                              }

                              if(client.field448 == 1) {
                                 class23.method671("Use", client.field378 + " " + "->" + " " + class139.method3046('\uffff') + var26.field933, 1, var40, var22, var23);
                              } else if(client.field447) {
                                 if(4 == (class161.field2636 & 4)) {
                                    class23.method671(client.field297, client.field534 + " " + "->" + " " + class139.method3046('\uffff') + var26.field933, 2, var40, var22, var23);
                                 }
                              } else {
                                 String[] var27 = var26.field950;
                                 if(client.field463) {
                                    var27 = class89.method2163(var27);
                                 }

                                 if(null != var27) {
                                    for(int var28 = 4; var28 >= 0; --var28) {
                                       if(var27[var28] != null) {
                                          short var29 = 0;
                                          if(var28 == 0) {
                                             var29 = 3;
                                          }

                                          if(var28 == 1) {
                                             var29 = 4;
                                          }

                                          if(2 == var28) {
                                             var29 = 5;
                                          }

                                          if(var28 == 3) {
                                             var29 = 6;
                                          }

                                          if(4 == var28) {
                                             var29 = 1001;
                                          }

                                          class23.method671(var27[var28], class139.method3046('\uffff') + var26.field933, var29, var40, var22, var23);
                                       }
                                    }
                                 }

                                 class23.method671("Examine", class139.method3046('\uffff') + var26.field933, 1002, var26.field930 << 14, var22, var23);
                              }
                           }

                           class2 var30;
                           int var45;
                           class34 var46;
                           int[] var47;
                           int var51;
                           if(var41 == 1) {
                              class34 var42 = client.field546[var25];
                              if(null == var42) {
                                 continue;
                              }

                              if(var42.field784.field887 == 1 && (var42.field844 & 127) == 64 && (var42.field819 & 127) == 64) {
                                 for(var45 = 0; var45 < client.field343; ++var45) {
                                    var46 = client.field546[client.field335[var45]];
                                    if(null != var46 && var42 != var46 && var46.field784.field887 == 1 && var42.field844 == var46.field844 && var46.field819 == var42.field819) {
                                       class126.method2930(var46.field784, client.field335[var45], var22, var23);
                                    }
                                 }

                                 var45 = class32.field771;
                                 var47 = class32.field762;

                                 for(var51 = 0; var51 < var45; ++var51) {
                                    var30 = client.field550[var47[var51]];
                                    if(null != var30 && var42.field844 == var30.field844 && var42.field819 == var30.field819) {
                                       class188.method3828(var30, var47[var51], var22, var23);
                                    }
                                 }
                              }

                              class126.method2930(var42.field784, var25, var22, var23);
                           }

                           if(var41 == 0) {
                              class2 var43 = client.field550[var25];
                              if(null == var43) {
                                 continue;
                              }

                              if(64 == (var43.field844 & 127) && 64 == (var43.field819 & 127)) {
                                 for(var45 = 0; var45 < client.field343; ++var45) {
                                    var46 = client.field546[client.field335[var45]];
                                    if(var46 != null && var46.field784.field887 == 1 && var43.field844 == var46.field844 && var43.field819 == var46.field819) {
                                       class126.method2930(var46.field784, client.field335[var45], var22, var23);
                                    }
                                 }

                                 var45 = class32.field771;
                                 var47 = class32.field762;

                                 for(var51 = 0; var51 < var45; ++var51) {
                                    var30 = client.field550[var47[var51]];
                                    if(null != var30 && var30 != var43 && var30.field844 == var43.field844 && var30.field819 == var43.field819) {
                                       class188.method3828(var30, var47[var51], var22, var23);
                                    }
                                 }
                              }

                              if(client.field424 != var25) {
                                 class188.method3828(var43, var25, var22, var23);
                              } else {
                                 var18 = var40;
                              }
                           }

                           if(var41 == 3) {
                              class199 var44 = client.field425[class42.field1002][var22][var23];
                              if(null != var44) {
                                 for(class28 var48 = (class28)var44.method3906(); null != var48; var48 = (class28)var44.method3919()) {
                                    class51 var49 = class11.method178(var48.field691);
                                    if(1 == client.field448) {
                                       class23.method671("Use", client.field378 + " " + "->" + " " + class139.method3046(16748608) + var49.field1125, 16, var48.field691, var22, var23);
                                    } else if(client.field447) {
                                       if((class161.field2636 & 1) == 1) {
                                          class23.method671(client.field297, client.field534 + " " + "->" + " " + class139.method3046(16748608) + var49.field1125, 17, var48.field691, var22, var23);
                                       }
                                    } else {
                                       String[] var52 = var49.field1139;
                                       if(client.field463) {
                                          var52 = class89.method2163(var52);
                                       }

                                       for(int var50 = 4; var50 >= 0; --var50) {
                                          if(null != var52 && null != var52[var50]) {
                                             byte var31 = 0;
                                             if(var50 == 0) {
                                                var31 = 18;
                                             }

                                             if(var50 == 1) {
                                                var31 = 19;
                                             }

                                             if(2 == var50) {
                                                var31 = 20;
                                             }

                                             if(3 == var50) {
                                                var31 = 21;
                                             }

                                             if(var50 == 4) {
                                                var31 = 22;
                                             }

                                             class23.method671(var52[var50], class139.method3046(16748608) + var49.field1125, var31, var48.field691, var22, var23);
                                          } else if(2 == var50) {
                                             class23.method671("Take", class139.method3046(16748608) + var49.field1125, 20, var48.field691, var22, var23);
                                          }
                                       }

                                       class23.method671("Examine", class139.method3046(16748608) + var49.field1125, 1004, var48.field691, var22, var23);
                                    }
                                 }
                              }
                           }
                        }
                     }

                     if(var18 != -1) {
                        var37 = var18 & 127;
                        var40 = var18 >> 7 & 127;
                        class2 var39 = client.field550[client.field424];
                        class188.method3828(var39, client.field424, var37, var40);
                     }
                  }
               } else if(var9.field2762 == 1338) {
                  class150.method3241(var9, var10, var11);
               } else {
                  if(!client.field433 && var16 >= var12 && var17 >= var13 && var16 < var14 && var17 < var15) {
                     class104.method2386(var9, var16 - var10, var17 - var11);
                  }

                  if(var9.field2824 == 0) {
                     if(!var9.field2757 && class219.method4065(var9) && var9 != class43.field1032) {
                        continue;
                     }

                     method2251(var0, var9.field2842, var12, var13, var14, var15, var10 - var9.field2879, var11 - var9.field2780);
                     if(null != var9.field2867) {
                        method2251(var9.field2867, var9.field2842, var12, var13, var14, var15, var10 - var9.field2879, var11 - var9.field2780);
                     }

                     class3 var32 = (class3)client.field453.method3868((long)var9.field2842);
                     if(null != var32) {
                        if(var32.field72 == 0 && class140.field2151 >= var12 && class140.field2161 >= var13 && class140.field2151 < var14 && class140.field2161 < var15 && !client.field433 && !client.field462) {
                           for(class0 var34 = (class0)client.field492.method3926(); null != var34; var34 = (class0)client.field492.method3902()) {
                              if(var34.field8) {
                                 var34.method3998();
                                 var34.field2.field2883 = false;
                              }
                           }

                           if(class11.field184 == 0) {
                              client.field465 = null;
                              client.field409 = null;
                           }

                           if(!client.field433) {
                              client.field439[0] = "Cancel";
                              client.field440[0] = "";
                              client.field437[0] = 1006;
                              client.field434 = 1;
                           }
                        }

                        var19 = var32.field70;
                        if(class9.method161(var19)) {
                           method2251(class173.field2886[var19], -1, var12, var13, var14, var15, var10, var11);
                        }
                     }
                  }

                  if(var9.field2757) {
                     class0 var33;
                     if(!var9.field2891) {
                        if(var9.field2892 && class140.field2151 >= var12 && class140.field2161 >= var13 && class140.field2151 < var14 && class140.field2161 < var15) {
                           for(var33 = (class0)client.field492.method3926(); var33 != null; var33 = (class0)client.field492.method3902()) {
                              if(var33.field8 && var33.field2.field2859 == var33.field4) {
                                 var33.method3998();
                              }
                           }
                        }
                     } else if(class140.field2151 >= var12 && class140.field2161 >= var13 && class140.field2151 < var14 && class140.field2161 < var15) {
                        for(var33 = (class0)client.field492.method3926(); null != var33; var33 = (class0)client.field492.method3902()) {
                           if(var33.field8) {
                              var33.method3998();
                              var33.field2.field2883 = false;
                           }
                        }

                        if(class11.field184 == 0) {
                           client.field465 = null;
                           client.field409 = null;
                        }

                        if(!client.field433) {
                           client.field439[0] = "Cancel";
                           client.field440[0] = "";
                           client.field437[0] = 1006;
                           client.field434 = 1;
                        }
                     }

                     boolean var35;
                     if(class140.field2151 >= var12 && class140.field2161 >= var13 && class140.field2151 < var14 && class140.field2161 < var15) {
                        var35 = true;
                     } else {
                        var35 = false;
                     }

                     boolean var36 = false;
                     if((1 == class140.field2147 || !class7.field143 && 4 == class140.field2147) && var35) {
                        var36 = true;
                     }

                     boolean var20 = false;
                     if((class140.field2157 == 1 || !class7.field143 && 4 == class140.field2157) && class140.field2160 >= var12 && class140.field2159 >= var13 && class140.field2160 < var14 && class140.field2159 < var15) {
                        var20 = true;
                     }

                     if(var20) {
                        class49.method1111(var9, class140.field2160 - var10, class140.field2159 - var11);
                     }

                     if(client.field465 != null && client.field465 != var9 && var35 && class36.method830(class31.method776(var9))) {
                        client.field469 = var9;
                     }

                     if(var9 == client.field409) {
                        client.field498 = true;
                        client.field450 = var10;
                        client.field472 = var11;
                     }

                     if(var9.field2838) {
                        class0 var21;
                        if(var35 && client.field571 != 0 && var9.field2859 != null) {
                           var21 = new class0();
                           var21.field8 = true;
                           var21.field2 = var9;
                           var21.field16 = client.field571;
                           var21.field4 = var9.field2859;
                           client.field492.method3900(var21);
                        }

                        if(client.field465 != null || class3.field65 != null || client.field433) {
                           var20 = false;
                           var36 = false;
                           var35 = false;
                        }

                        if(!var9.field2884 && var20) {
                           var9.field2884 = true;
                           if(var9.field2840 != null) {
                              var21 = new class0();
                              var21.field8 = true;
                              var21.field2 = var9;
                              var21.field3 = class140.field2160 - var10;
                              var21.field16 = class140.field2159 - var11;
                              var21.field4 = var9.field2840;
                              client.field492.method3900(var21);
                           }
                        }

                        if(var9.field2884 && var36 && var9.field2799 != null) {
                           var21 = new class0();
                           var21.field8 = true;
                           var21.field2 = var9;
                           var21.field3 = class140.field2151 - var10;
                           var21.field16 = class140.field2161 - var11;
                           var21.field4 = var9.field2799;
                           client.field492.method3900(var21);
                        }

                        if(var9.field2884 && !var36) {
                           var9.field2884 = false;
                           if(var9.field2749 != null) {
                              var21 = new class0();
                              var21.field8 = true;
                              var21.field2 = var9;
                              var21.field3 = class140.field2151 - var10;
                              var21.field16 = class140.field2161 - var11;
                              var21.field4 = var9.field2749;
                              client.field494.method3900(var21);
                           }
                        }

                        if(var36 && var9.field2843 != null) {
                           var21 = new class0();
                           var21.field8 = true;
                           var21.field2 = var9;
                           var21.field3 = class140.field2151 - var10;
                           var21.field16 = class140.field2161 - var11;
                           var21.field4 = var9.field2843;
                           client.field492.method3900(var21);
                        }

                        if(!var9.field2883 && var35) {
                           var9.field2883 = true;
                           if(null != var9.field2844) {
                              var21 = new class0();
                              var21.field8 = true;
                              var21.field2 = var9;
                              var21.field3 = class140.field2151 - var10;
                              var21.field16 = class140.field2161 - var11;
                              var21.field4 = var9.field2844;
                              client.field492.method3900(var21);
                           }
                        }

                        if(var9.field2883 && var35 && var9.field2789 != null) {
                           var21 = new class0();
                           var21.field8 = true;
                           var21.field2 = var9;
                           var21.field3 = class140.field2151 - var10;
                           var21.field16 = class140.field2161 - var11;
                           var21.field4 = var9.field2789;
                           client.field492.method3900(var21);
                        }

                        if(var9.field2883 && !var35) {
                           var9.field2883 = false;
                           if(null != var9.field2846) {
                              var21 = new class0();
                              var21.field8 = true;
                              var21.field2 = var9;
                              var21.field3 = class140.field2151 - var10;
                              var21.field16 = class140.field2161 - var11;
                              var21.field4 = var9.field2846;
                              client.field494.method3900(var21);
                           }
                        }

                        if(null != var9.field2857) {
                           var21 = new class0();
                           var21.field2 = var9;
                           var21.field4 = var9.field2857;
                           client.field493.method3900(var21);
                        }

                        class0 var24;
                        if(null != var9.field2851 && client.field480 > var9.field2781) {
                           if(null != var9.field2852 && client.field480 - var9.field2781 <= 32) {
                              label1116:
                              for(var40 = var9.field2781; var40 < client.field480; ++var40) {
                                 var22 = client.field489[var40 & 31];

                                 for(var23 = 0; var23 < var9.field2852.length; ++var23) {
                                    if(var9.field2852[var23] == var22) {
                                       var24 = new class0();
                                       var24.field2 = var9;
                                       var24.field4 = var9.field2851;
                                       client.field492.method3900(var24);
                                       break label1116;
                                    }
                                 }
                              }
                           } else {
                              var21 = new class0();
                              var21.field2 = var9;
                              var21.field4 = var9.field2851;
                              client.field492.method3900(var21);
                           }

                           var9.field2781 = client.field480;
                        }

                        if(var9.field2767 != null && client.field482 > var9.field2887) {
                           if(null != var9.field2854 && client.field482 - var9.field2887 <= 32) {
                              label1092:
                              for(var40 = var9.field2887; var40 < client.field482; ++var40) {
                                 var22 = client.field481[var40 & 31];

                                 for(var23 = 0; var23 < var9.field2854.length; ++var23) {
                                    if(var22 == var9.field2854[var23]) {
                                       var24 = new class0();
                                       var24.field2 = var9;
                                       var24.field4 = var9.field2767;
                                       client.field492.method3900(var24);
                                       break label1092;
                                    }
                                 }
                              }
                           } else {
                              var21 = new class0();
                              var21.field2 = var9;
                              var21.field4 = var9.field2767;
                              client.field492.method3900(var21);
                           }

                           var9.field2887 = client.field482;
                        }

                        if(var9.field2855 != null && client.field484 > var9.field2888) {
                           if(null != var9.field2882 && client.field484 - var9.field2888 <= 32) {
                              label1068:
                              for(var40 = var9.field2888; var40 < client.field484; ++var40) {
                                 var22 = client.field483[var40 & 31];

                                 for(var23 = 0; var23 < var9.field2882.length; ++var23) {
                                    if(var9.field2882[var23] == var22) {
                                       var24 = new class0();
                                       var24.field2 = var9;
                                       var24.field4 = var9.field2855;
                                       client.field492.method3900(var24);
                                       break label1068;
                                    }
                                 }
                              }
                           } else {
                              var21 = new class0();
                              var21.field2 = var9;
                              var21.field4 = var9.field2855;
                              client.field492.method3900(var21);
                           }

                           var9.field2888 = client.field484;
                        }

                        if(client.field303 > var9.field2885 && var9.field2860 != null) {
                           var21 = new class0();
                           var21.field2 = var9;
                           var21.field4 = var9.field2860;
                           client.field492.method3900(var21);
                        }

                        if(client.field486 > var9.field2885 && var9.field2862 != null) {
                           var21 = new class0();
                           var21.field2 = var9;
                           var21.field4 = var9.field2862;
                           client.field492.method3900(var21);
                        }

                        if(client.field487 > var9.field2885 && null != var9.field2863) {
                           var21 = new class0();
                           var21.field2 = var9;
                           var21.field4 = var9.field2863;
                           client.field492.method3900(var21);
                        }

                        if(client.field405 > var9.field2885 && var9.field2868 != null) {
                           var21 = new class0();
                           var21.field2 = var9;
                           var21.field4 = var9.field2868;
                           client.field492.method3900(var21);
                        }

                        if(client.field365 > var9.field2885 && null != var9.field2858) {
                           var21 = new class0();
                           var21.field2 = var9;
                           var21.field4 = var9.field2858;
                           client.field492.method3900(var21);
                        }

                        if(client.field342 > var9.field2885 && var9.field2786 != null) {
                           var21 = new class0();
                           var21.field2 = var9;
                           var21.field4 = var9.field2786;
                           client.field492.method3900(var21);
                        }

                        var9.field2885 = client.field477;
                        if(null != var9.field2861) {
                           for(var40 = 0; var40 < client.field517; ++var40) {
                              class0 var38 = new class0();
                              var38.field2 = var9;
                              var38.field14 = client.field519[var40];
                              var38.field1 = client.field518[var40];
                              var38.field4 = var9.field2861;
                              client.field492.method3900(var38);
                           }
                        }
                     }
                  }

                  if(!var9.field2757 && client.field465 == null && class3.field65 == null && !client.field433) {
                     if((var9.field2873 >= 0 || var9.field2785 != 0) && class140.field2151 >= var12 && class140.field2161 >= var13 && class140.field2151 < var14 && class140.field2161 < var15) {
                        if(var9.field2873 >= 0) {
                           class43.field1032 = var0[var9.field2873];
                        } else {
                           class43.field1032 = var9;
                        }
                     }

                     if(8 == var9.field2824 && class140.field2151 >= var12 && class140.field2161 >= var13 && class140.field2151 < var14 && class140.field2161 < var15) {
                        class56.field1201 = var9;
                     }

                     if(var9.field2765 > var9.field2774) {
                        class23.method669(var9, var10 + var9.field2773, var11, var9.field2774, var9.field2765, class140.field2151, class140.field2161);
                     }
                  }
               }
            }
         }
      }

   }
}
