import java.awt.datatransfer.Clipboard;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ac")
@Implements("MessageNode")
public class class35 extends class204 {
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 907298721
   )
   int field789;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -543768309
   )
   @Export("type")
   int field790;
   @ObfuscatedName("y")
   @Export("sender")
   String field791;
   @ObfuscatedName("c")
   String field792;
   @ObfuscatedName("pe")
   static Clipboard field793;
   @ObfuscatedName("k")
   @Export("value")
   String field795;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 1331829645
   )
   int field797 = client.method627();

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Lclass25;B)V",
      garbageValue = "16"
   )
   static void method821(class25 var0) {
      if(var0.method679() != client.field301) {
         client.field301 = var0.method679();
         class85.method2004(var0.method679());
      }

      class12.field191 = var0.field655;
      client.field296 = var0.field646;
      client.field431 = var0.field647;
      class27.field680 = client.field352 == 0?'ꩊ':var0.field646 + '鱀';
      client.field332 = client.field352 == 0?443:'썐' + var0.field646;
      class42.field1000 = class27.field680;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;B)V",
      garbageValue = "2"
   )
   void method822(int var1, String var2, String var3, String var4) {
      this.field797 = client.method627();
      this.field789 = client.field306;
      this.field790 = var1;
      this.field792 = var2;
      this.field791 = var3;
      this.field795 = var4;
   }

   class35(int var1, String var2, String var3, String var4) {
      this.field789 = client.field306;
      this.field790 = var1;
      this.field792 = var2;
      this.field791 = var3;
      this.field795 = var4;
   }

   @ObfuscatedName("cq")
   @ObfuscatedSignature(
      signature = "([Lclass173;IIIZI)V",
      garbageValue = "1007752835"
   )
   static void method825(class173[] var0, int var1, int var2, int var3, boolean var4) {
      for(int var5 = 0; var5 < var0.length; ++var5) {
         class173 var6 = var0[var5];
         if(var6 != null && var6.field2777 == var1) {
            class113.method2542(var6, var2, var3, var4);
            class16.method213(var6, var2, var3);
            if(var6.field2879 > var6.field2853 - var6.field2773) {
               var6.field2879 = var6.field2853 - var6.field2773;
            }

            if(var6.field2879 < 0) {
               var6.field2879 = 0;
            }

            if(var6.field2780 > var6.field2765 - var6.field2774) {
               var6.field2780 = var6.field2765 - var6.field2774;
            }

            if(var6.field2780 < 0) {
               var6.field2780 = 0;
            }

            if(var6.field2824 == 0) {
               class14.method202(var0, var6, var4);
            }
         }
      }

   }

   @ObfuscatedName("by")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-18"
   )
   static final void method826() {
      class59.method1357(false);
      client.field350 = 0;
      boolean var0 = true;

      int var1;
      for(var1 = 0; var1 < class9.field168.length; ++var1) {
         if(class72.field1359[var1] != -1 && class9.field168[var1] == null) {
            class9.field168[var1] = class8.field156.method3403(class72.field1359[var1], 0);
            if(class9.field168[var1] == null) {
               var0 = false;
               ++client.field350;
            }
         }

         if(-1 != class110.field1929[var1] && class7.field136[var1] == null) {
            class7.field136[var1] = class8.field156.method3363(class110.field1929[var1], 0, class106.field1859[var1]);
            if(null == class7.field136[var1]) {
               var0 = false;
               ++client.field350;
            }
         }
      }

      if(!var0) {
         client.field346 = 1;
      } else {
         client.field333 = 0;
         var0 = true;

         int var3;
         int var4;
         for(var1 = 0; var1 < class9.field168.length; ++var1) {
            byte[] var2 = class7.field136[var1];
            if(null != var2) {
               var3 = (class12.field203[var1] >> 8) * 64 - class144.field2204;
               var4 = 64 * (class12.field203[var1] & 255) - class3.field67;
               if(client.field356) {
                  var3 = 10;
                  var4 = 10;
               }

               var0 &= class114.method2544(var2, var3, var4);
            }
         }

         if(!var0) {
            client.field346 = 2;
         } else {
            if(0 != client.field346) {
               class25.method682("Loading - please wait." + "<br>" + " (" + 100 + "%" + ")", true);
            }

            class41.method935();
            class3.method48();
            class41.method935();
            class30.field717.method2042();
            class41.method935();
            System.gc();

            for(var1 = 0; var1 < 4; ++var1) {
               client.field361[var1].method2488();
            }

            int var35;
            for(var1 = 0; var1 < 4; ++var1) {
               for(var35 = 0; var35 < 104; ++var35) {
                  for(var3 = 0; var3 < 104; ++var3) {
                     class5.field82[var1][var35][var3] = 0;
                  }
               }
            }

            class41.method935();
            class175.method3530();
            var1 = class9.field168.length;

            for(class23 var36 = (class23)class23.field627.method3926(); null != var36; var36 = (class23)class23.field627.method3902()) {
               if(null != var36.field615) {
                  class10.field178.method1235(var36.field615);
                  var36.field615 = null;
               }

               if(var36.field623 != null) {
                  class10.field178.method1235(var36.field623);
                  var36.field623 = null;
               }
            }

            class23.field627.method3898();
            class59.method1357(true);
            int var9;
            int var10;
            int var11;
            int var12;
            int var13;
            int var14;
            int var15;
            int var16;
            int var20;
            int var21;
            int var38;
            if(!client.field356) {
               byte[] var5;
               for(var35 = 0; var35 < var1; ++var35) {
                  var3 = (class12.field203[var35] >> 8) * 64 - class144.field2204;
                  var4 = (class12.field203[var35] & 255) * 64 - class3.field67;
                  var5 = class9.field168[var35];
                  if(null != var5) {
                     class41.method935();
                     class6.method125(var5, var3, var4, class30.field710 * 8 - 48, class28.field694 * 8 - 48, client.field361);
                  }
               }

               for(var35 = 0; var35 < var1; ++var35) {
                  var3 = 64 * (class12.field203[var35] >> 8) - class144.field2204;
                  var4 = (class12.field203[var35] & 255) * 64 - class3.field67;
                  var5 = class9.field168[var35];
                  if(null == var5 && class28.field694 < 800) {
                     class41.method935();
                     class1.method13(var3, var4, 64, 64);
                  }
               }

               class59.method1357(true);

               for(var35 = 0; var35 < var1; ++var35) {
                  byte[] var37 = class7.field136[var35];
                  if(var37 != null) {
                     var4 = 64 * (class12.field203[var35] >> 8) - class144.field2204;
                     var38 = 64 * (class12.field203[var35] & 255) - class3.field67;
                     class41.method935();
                     class86 var6 = class30.field717;
                     class108[] var7 = client.field361;
                     class119 var8 = new class119(var37);
                     var9 = -1;

                     while(true) {
                        var10 = var8.method2812();
                        if(var10 == 0) {
                           break;
                        }

                        var9 += var10;
                        var11 = 0;

                        while(true) {
                           var12 = var8.method2812();
                           if(var12 == 0) {
                              break;
                           }

                           var11 += var12 - 1;
                           var13 = var11 & 63;
                           var14 = var11 >> 6 & 63;
                           var15 = var11 >> 12;
                           var16 = var8.method2613();
                           int var17 = var16 >> 2;
                           int var18 = var16 & 3;
                           int var19 = var4 + var14;
                           var20 = var38 + var13;
                           if(var19 > 0 && var20 > 0 && var19 < 103 && var20 < 103) {
                              var21 = var15;
                              if(2 == (class5.field82[1][var19][var20] & 2)) {
                                 var21 = var15 - 1;
                              }

                              class108 var22 = null;
                              if(var21 >= 0) {
                                 var22 = var7[var21];
                              }

                              class47.method1083(var15, var19, var20, var9, var18, var17, var6, var22);
                           }
                        }
                     }
                  }
               }
            }

            int var40;
            int var41;
            int var43;
            if(client.field356) {
               for(var35 = 0; var35 < 4; ++var35) {
                  class41.method935();

                  for(var3 = 0; var3 < 13; ++var3) {
                     for(var4 = 0; var4 < 13; ++var4) {
                        boolean var39 = false;
                        var40 = client.field529[var35][var3][var4];
                        if(-1 != var40) {
                           var41 = var40 >> 24 & 3;
                           var43 = var40 >> 1 & 3;
                           var9 = var40 >> 14 & 1023;
                           var10 = var40 >> 3 & 2047;
                           var11 = var10 / 8 + (var9 / 8 << 8);

                           for(var12 = 0; var12 < class12.field203.length; ++var12) {
                              if(class12.field203[var12] == var11 && class9.field168[var12] != null) {
                                 class144.method3145(class9.field168[var12], var35, 8 * var3, 8 * var4, var41, (var9 & 7) * 8, 8 * (var10 & 7), var43, client.field361);
                                 var39 = true;
                                 break;
                              }
                           }
                        }

                        if(!var39) {
                           class87.method2160(var35, var3 * 8, var4 * 8);
                        }
                     }
                  }
               }

               for(var35 = 0; var35 < 13; ++var35) {
                  for(var3 = 0; var3 < 13; ++var3) {
                     var4 = client.field529[0][var35][var3];
                     if(-1 == var4) {
                        class1.method13(8 * var35, 8 * var3, 8, 8);
                     }
                  }
               }

               class59.method1357(true);

               for(var35 = 0; var35 < 4; ++var35) {
                  class41.method935();

                  for(var3 = 0; var3 < 13; ++var3) {
                     label495:
                     for(var4 = 0; var4 < 13; ++var4) {
                        var38 = client.field529[var35][var3][var4];
                        if(var38 != -1) {
                           var40 = var38 >> 24 & 3;
                           var41 = var38 >> 1 & 3;
                           var43 = var38 >> 14 & 1023;
                           var9 = var38 >> 3 & 2047;
                           var10 = (var43 / 8 << 8) + var9 / 8;

                           for(var11 = 0; var11 < class12.field203.length; ++var11) {
                              if(var10 == class12.field203[var11] && class7.field136[var11] != null) {
                                 byte[] var44 = class7.field136[var11];
                                 var13 = var3 * 8;
                                 var14 = 8 * var4;
                                 var15 = (var43 & 7) * 8;
                                 var16 = (var9 & 7) * 8;
                                 class86 var45 = class30.field717;
                                 class108[] var46 = client.field361;
                                 class119 var47 = new class119(var44);
                                 var20 = -1;

                                 while(true) {
                                    var21 = var47.method2812();
                                    if(var21 == 0) {
                                       continue label495;
                                    }

                                    var20 += var21;
                                    int var48 = 0;

                                    while(true) {
                                       int var23 = var47.method2812();
                                       if(var23 == 0) {
                                          break;
                                       }

                                       var48 += var23 - 1;
                                       int var24 = var48 & 63;
                                       int var25 = var48 >> 6 & 63;
                                       int var26 = var48 >> 12;
                                       int var27 = var47.method2613();
                                       int var28 = var27 >> 2;
                                       int var29 = var27 & 3;
                                       if(var40 == var26 && var25 >= var15 && var25 < var15 + 8 && var24 >= var16 && var24 < 8 + var16) {
                                          class40 var30 = class133.method2969(var20);
                                          int var31 = var13 + class5.method117(var25 & 7, var24 & 7, var41, var30.field938, var30.field939, var29);
                                          int var32 = var14 + class16.method216(var25 & 7, var24 & 7, var41, var30.field938, var30.field939, var29);
                                          if(var31 > 0 && var32 > 0 && var31 < 103 && var32 < 103) {
                                             int var33 = var35;
                                             if(2 == (class5.field82[1][var31][var32] & 2)) {
                                                var33 = var35 - 1;
                                             }

                                             class108 var34 = null;
                                             if(var33 >= 0) {
                                                var34 = var46[var33];
                                             }

                                             class47.method1083(var35, var31, var32, var20, var29 + var41 & 3, var28, var45, var34);
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

            class59.method1357(true);
            class3.method48();
            class41.method935();
            class34.method819(class30.field717, client.field361);
            class59.method1357(true);
            var35 = class5.field87;
            if(var35 > class42.field1002) {
               var35 = class42.field1002;
            }

            if(var35 < class42.field1002 - 1) {
               var35 = class42.field1002 - 1;
            }

            if(client.field302) {
               class30.field717.method2009(class5.field87);
            } else {
               class30.field717.method2009(0);
            }

            for(var3 = 0; var3 < 104; ++var3) {
               for(var4 = 0; var4 < 104; ++var4) {
                  class130.method2949(var3, var4);
               }
            }

            class41.method935();

            for(class16 var42 = (class16)client.field426.method3926(); null != var42; var42 = (class16)client.field426.method3902()) {
               if(var42.field247 == -1) {
                  var42.field239 = 0;
                  class106.method2478(var42);
               } else {
                  var42.method3998();
               }
            }

            class40.field926.method3843();
            if(null != class32.field760) {
               client.field338.method2873(119);
               client.field338.method2786(1057001181);
            }

            if(!client.field356) {
               var3 = (class30.field710 - 6) / 8;
               var4 = (6 + class30.field710) / 8;
               var38 = (class28.field694 - 6) / 8;
               var40 = (6 + class28.field694) / 8;

               for(var41 = var3 - 1; var41 <= 1 + var4; ++var41) {
                  for(var43 = var38 - 1; var43 <= var40 + 1; ++var43) {
                     if(var41 < var3 || var41 > var4 || var43 < var38 || var43 > var40) {
                        class8.field156.method3384("m" + var41 + "_" + var43);
                        class8.field156.method3384("l" + var41 + "_" + var43);
                     }
                  }
               }
            }

            class3.method49(30);
            class41.method935();
            class45.field1053 = (byte[][][])null;
            class5.field84 = (byte[][][])null;
            class5.field85 = (byte[][][])null;
            class84.field1463 = (byte[][][])null;
            class4.field77 = (int[][][])null;
            class41.field985 = (byte[][][])null;
            class209.field3126 = (int[][])null;
            class5.field86 = null;
            class134.field2077 = null;
            class142.field2170 = null;
            class5.field95 = null;
            class125.field2035 = null;
            client.field338.method2873(254);
            class48.field1091.vmethod3216();

            for(var3 = 0; var3 < 32; ++var3) {
               class144.field2196[var3] = 0L;
            }

            for(var3 = 0; var3 < 32; ++var3) {
               class144.field2194[var3] = 0L;
            }

            class49.field1097 = 0;
         }
      }
   }
}
