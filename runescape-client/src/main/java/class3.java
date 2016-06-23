import java.awt.datatransfer.ClipboardOwner;
import java.awt.datatransfer.StringSelection;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("b")
@Implements("WidgetNode")
public class class3 extends class208 {
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 1654306503
   )
   int field62;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -64772739
   )
   @Export("id")
   int field64;
   @ObfuscatedName("kz")
   @Export("chatMessages")
   static class19 field65;
   @ObfuscatedName("bj")
   @Export("host")
   static String field66;
   @ObfuscatedName("b")
   public static File field67;
   @ObfuscatedName("x")
   boolean field68 = false;
   @ObfuscatedName("y")
   public static String field70;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -1770436441
   )
   public static int field73;

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "80"
   )
   public static int method44() {
      return ++class140.field2145 - 1;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "1897425203"
   )
   static final void method45(int var0, int var1, int var2) {
      int var3;
      for(var3 = 0; var3 < 8; ++var3) {
         for(int var4 = 0; var4 < 8; ++var4) {
            class5.field99[var0][var1 + var3][var2 + var4] = 0;
         }
      }

      if(var1 > 0) {
         for(var3 = 1; var3 < 8; ++var3) {
            class5.field99[var0][var1][var3 + var2] = class5.field99[var0][var1 - 1][var3 + var2];
         }
      }

      if(var2 > 0) {
         for(var3 = 1; var3 < 8; ++var3) {
            class5.field99[var0][var1 + var3][var2] = class5.field99[var0][var3 + var1][var2 - 1];
         }
      }

      if(var1 > 0 && class5.field99[var0][var1 - 1][var2] != 0) {
         class5.field99[var0][var1][var2] = class5.field99[var0][var1 - 1][var2];
      } else if(var2 > 0 && class5.field99[var0][var1][var2 - 1] != 0) {
         class5.field99[var0][var1][var2] = class5.field99[var0][var1][var2 - 1];
      } else if(var1 > 0 && var2 > 0 && class5.field99[var0][var1 - 1][var2 - 1] != 0) {
         class5.field99[var0][var1][var2] = class5.field99[var0][var1 - 1][var2 - 1];
      }

   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-2007094336"
   )
   static final void method46() {
      if(client.field309 > 1) {
         --client.field309;
      }

      if(client.field343 > 0) {
         --client.field343;
      }

      if(client.field361) {
         client.field361 = false;
         if(client.field343 > 0) {
            class5.method71();
         } else {
            class11.method156(40);
            class9.field158 = class172.field2742;
            class172.field2742 = null;
         }

      } else {
         if(!client.field310) {
            client.field459[0] = "Cancel";
            client.field435[0] = "";
            client.field329[0] = 1006;
            client.field429 = 1;
         }

         int var0;
         for(var0 = 0; var0 < 100 && class110.method2474(); ++var0) {
            ;
         }

         if(client.field299 == 30) {
            while(true) {
               class210 var1 = (class210)class211.field3128.method3891();
               boolean var25;
               if(var1 == null) {
                  var25 = false;
               } else {
                  var25 = true;
               }

               int var16;
               if(!var25) {
                  Object var17 = client.field473.field199;
                  int var2;
                  int var3;
                  int var4;
                  int var5;
                  int var6;
                  int var7;
                  int var8;
                  synchronized(client.field473.field199) {
                     if(!client.field455) {
                        client.field473.field200 = 0;
                     } else if(class140.field2156 != 0 || client.field473.field200 >= 40) {
                        client.field333.method2773(86);
                        client.field333.method2654(0);
                        var16 = client.field333.field1998;
                        var2 = 0;

                        for(var3 = 0; var3 < client.field473.field200 && client.field333.field1998 - var16 < 240; ++var3) {
                           ++var2;
                           var4 = client.field473.field202[var3];
                           if(var4 < 0) {
                              var4 = 0;
                           } else if(var4 > 502) {
                              var4 = 502;
                           }

                           var5 = client.field473.field201[var3];
                           if(var5 < 0) {
                              var5 = 0;
                           } else if(var5 > 764) {
                              var5 = 764;
                           }

                           var6 = var4 * 765 + var5;
                           if(client.field473.field202[var3] == -1 && client.field473.field201[var3] == -1) {
                              var5 = -1;
                              var4 = -1;
                              var6 = 524287;
                           }

                           if(client.field354 == var5 && var4 == client.field305) {
                              if(client.field306 < 2047) {
                                 ++client.field306;
                              }
                           } else {
                              var7 = var5 - client.field354;
                              client.field354 = var5;
                              var8 = var4 - client.field305;
                              client.field305 = var4;
                              if(client.field306 < 8 && var7 >= -32 && var7 <= 31 && var8 >= -32 && var8 <= 31) {
                                 var7 += 32;
                                 var8 += 32;
                                 client.field333.method2540(var8 + (client.field306 << 12) + (var7 << 6));
                                 client.field306 = 0;
                              } else if(client.field306 < 8) {
                                 client.field333.method2541(var6 + (client.field306 << 19) + 8388608);
                                 client.field306 = 0;
                              } else {
                                 client.field333.method2539(var6 + (client.field306 << 19) + -1073741824);
                                 client.field306 = 0;
                              }
                           }
                        }

                        client.field333.method2551(client.field333.field1998 - var16);
                        if(var2 >= client.field473.field200) {
                           client.field473.field200 = 0;
                        } else {
                           client.field473.field200 -= var2;

                           for(var3 = 0; var3 < client.field473.field200; ++var3) {
                              client.field473.field201[var3] = client.field473.field201[var3 + var2];
                              client.field473.field202[var3] = client.field473.field202[var3 + var2];
                           }
                        }
                     }
                  }

                  if(class140.field2156 == 1 || !class148.field2224 && class140.field2156 == 4 || class140.field2156 == 2) {
                     long var27 = (class140.field2159 - client.field460) / 50L;
                     if(var27 > 4095L) {
                        var27 = 4095L;
                     }

                     client.field460 = class140.field2159;
                     var2 = class140.field2158;
                     if(var2 < 0) {
                        var2 = 0;
                     } else if(var2 > class153.field2274) {
                        var2 = class153.field2274;
                     }

                     var3 = class140.field2161;
                     if(var3 < 0) {
                        var3 = 0;
                     } else if(var3 > class30.field708) {
                        var3 = class30.field708;
                     }

                     var4 = (int)var27;
                     client.field333.method2773(4);
                     client.field333.method2540((class140.field2156 == 2?1:0) + (var4 << 1));
                     client.field333.method2540(var3);
                     client.field333.method2540(var2);
                  }

                  if(class137.field2123 > 0) {
                     client.field333.method2773(236);
                     client.field333.method2540(0);
                     var0 = client.field333.field1998;
                     long var32 = class130.method2846();

                     for(var3 = 0; var3 < class137.field2123; ++var3) {
                        long var29 = var32 - client.field513;
                        if(var29 > 16777215L) {
                           var29 = 16777215L;
                        }

                        client.field513 = var32;
                        client.field333.method2592((int)var29);
                        client.field333.method2578(class137.field2117[var3]);
                     }

                     client.field333.method2550(client.field333.field1998 - var0);
                  }

                  if(client.field380 > 0) {
                     --client.field380;
                  }

                  if(class137.field2114[96] || class137.field2114[97] || class137.field2114[98] || class137.field2114[99]) {
                     client.field340 = true;
                  }

                  if(client.field340 && client.field380 <= 0) {
                     client.field380 = 20;
                     client.field340 = false;
                     client.field333.method2773(6);
                     client.field333.method2584(client.field373);
                     client.field333.method2586(client.field374);
                  }

                  if(class30.field709 && !client.field307) {
                     client.field307 = true;
                     client.field333.method2773(255);
                     client.field333.method2654(1);
                  }

                  if(!class30.field709 && client.field307) {
                     client.field307 = false;
                     client.field333.method2773(255);
                     client.field333.method2654(0);
                  }

                  int var10;
                  int var18;
                  int[] var26;
                  if(client.field422 != class14.field212) {
                     client.field422 = class14.field212;
                     var0 = class14.field212;
                     var26 = class178.field2911.field1409;
                     var2 = var26.length;

                     for(var3 = 0; var3 < var2; ++var3) {
                        var26[var3] = 0;
                     }

                     for(var3 = 1; var3 < 103; ++var3) {
                        var4 = 24628 + (103 - var3) * 2048;

                        for(var5 = 1; var5 < 103; ++var5) {
                           if((class5.field82[var0][var5][var3] & 24) == 0) {
                              class129.field2056.method1985(var26, var4, 512, var0, var5, var3);
                           }

                           if(var0 < 3 && (class5.field82[1 + var0][var5][var3] & 8) != 0) {
                              class129.field2056.method1985(var26, var4, 512, 1 + var0, var5, var3);
                           }

                           var4 += 4;
                        }
                     }

                     var3 = (238 + (int)(Math.random() * 20.0D) - 10 << 16) + (238 + (int)(Math.random() * 20.0D) - 10 << 8) + (238 + (int)(Math.random() * 20.0D) - 10);
                     var4 = 238 + (int)(Math.random() * 20.0D) - 10 << 16;
                     class178.field2911.method1755();

                     for(var5 = 1; var5 < 103; ++var5) {
                        for(var6 = 1; var6 < 103; ++var6) {
                           if((class5.field82[var0][var6][var5] & 24) == 0) {
                              class168.method3392(var0, var6, var5, var3, var4);
                           }

                           if(var0 < 3 && (class5.field82[var0 + 1][var6][var5] & 8) != 0) {
                              class168.method3392(1 + var0, var6, var5, var3, var4);
                           }
                        }
                     }

                     client.field517 = 0;

                     for(var5 = 0; var5 < 104; ++var5) {
                        for(var6 = 0; var6 < 104; ++var6) {
                           var7 = class129.field2056.method1979(class14.field212, var5, var6);
                           if(var7 != 0) {
                              var7 = var7 >> 14 & 32767;
                              var8 = class150.method3166(var7).field964;
                              if(var8 >= 0) {
                                 var18 = var5;
                                 var10 = var6;
                                 if(var8 != 22 && var8 != 29 && var8 != 34 && var8 != 36 && var8 != 46 && var8 != 47 && var8 != 48) {
                                    int[][] var13 = client.field350[class14.field212].field1908;

                                    for(int var14 = 0; var14 < 10; ++var14) {
                                       int var15 = (int)(Math.random() * 4.0D);
                                       if(var15 == 0 && var18 > 0 && var18 > var5 - 3 && (var13[var18 - 1][var10] & 19136776) == 0) {
                                          --var18;
                                       }

                                       if(var15 == 1 && var18 < 103 && var18 < var5 + 3 && (var13[1 + var18][var10] & 19136896) == 0) {
                                          ++var18;
                                       }

                                       if(var15 == 2 && var10 > 0 && var10 > var6 - 3 && (var13[var18][var10 - 1] & 19136770) == 0) {
                                          --var10;
                                       }

                                       if(var15 == 3 && var10 < 103 && var10 < var6 + 3 && (var13[var18][var10 + 1] & 19136800) == 0) {
                                          ++var10;
                                       }
                                    }
                                 }

                                 client.field520[client.field517] = class8.field144[var8];
                                 client.field518[client.field517] = var18;
                                 client.field519[client.field517] = var10;
                                 ++client.field517;
                              }
                           }
                        }
                     }

                     class12.field196.method1733();
                  }

                  if(client.field299 != 30) {
                     return;
                  }

                  class36.method784();
                  class183.method3634();
                  ++client.field338;
                  if(client.field338 > 750) {
                     if(client.field343 > 0) {
                        class5.method71();
                     } else {
                        class11.method156(40);
                        class9.field158 = class172.field2742;
                        class172.field2742 = null;
                     }

                     return;
                  }

                  var0 = class32.field753;
                  var26 = class32.field761;

                  for(var2 = 0; var2 < var0; ++var2) {
                     class2 var19 = client.field302[var26[var2]];
                     if(null != var19) {
                        class6.method106(var19, 1);
                     }
                  }

                  class47.method1028();
                  class33.method746();
                  ++client.field366;
                  if(client.field394 != 0) {
                     client.field511 += 20;
                     if(client.field511 >= 400) {
                        client.field394 = 0;
                     }
                  }

                  if(class59.field1225 != null) {
                     ++client.field401;
                     if(client.field401 >= 15) {
                        class39.method818(class59.field1225);
                        class59.field1225 = null;
                     }
                  }

                  class173 var33 = class59.field1234;
                  class173 var28 = class42.field1002;
                  class59.field1234 = null;
                  class42.field1002 = null;
                  client.field399 = null;
                  client.field468 = false;
                  client.field465 = false;
                  client.field510 = 0;

                  while(class84.method1962() && client.field510 < 128) {
                     if(client.field454 >= 2 && class137.field2114[82] && class101.field1756 == 66) {
                        String var34 = "";

                        class35 var21;
                        for(Iterator var20 = class11.field182.iterator(); var20.hasNext(); var34 = var34 + var21.field789 + ':' + var21.field791 + '\n') {
                           var21 = (class35)var20.next();
                        }

                        class121.field2011.setContents(new StringSelection(var34), (ClipboardOwner)null);
                     } else {
                        client.field512[client.field510] = class101.field1756;
                        client.field430[client.field510] = class13.field198;
                        ++client.field510;
                     }
                  }

                  if(client.field391 != -1) {
                     class36.method785(client.field391, 0, 0, class30.field708, class153.field2274, 0, 0);
                  }

                  ++client.field563;

                  while(true) {
                     class0 var22;
                     class173 var35;
                     class173 var36;
                     do {
                        var22 = (class0)client.field393.method3853();
                        if(null == var22) {
                           while(true) {
                              do {
                                 var22 = (class0)client.field488.method3853();
                                 if(null == var22) {
                                    while(true) {
                                       do {
                                          var22 = (class0)client.field486.method3853();
                                          if(null == var22) {
                                             class56.method1291();
                                             if(client.field428 != null) {
                                                class39.method818(client.field428);
                                                ++class72.field1367;
                                                if(client.field468 && client.field465) {
                                                   var2 = class140.field2146;
                                                   var3 = class140.field2151;
                                                   var2 -= client.field308;
                                                   var3 -= client.field545;
                                                   if(var2 < client.field466) {
                                                      var2 = client.field466;
                                                   }

                                                   if(client.field428.field2769 + var2 > client.field298.field2769 + client.field466) {
                                                      var2 = client.field466 + client.field298.field2769 - client.field428.field2769;
                                                   }

                                                   if(var3 < client.field467) {
                                                      var3 = client.field467;
                                                   }

                                                   if(var3 + client.field428.field2888 > client.field298.field2888 + client.field467) {
                                                      var3 = client.field467 + client.field298.field2888 - client.field428.field2888;
                                                   }

                                                   var4 = var2 - client.field469;
                                                   var5 = var3 - client.field295;
                                                   var6 = client.field428.field2830;
                                                   if(class72.field1367 > client.field428.field2831 && (var4 > var6 || var4 < -var6 || var5 > var6 || var5 < -var6)) {
                                                      client.field369 = true;
                                                   }

                                                   var7 = var2 - client.field466 + client.field298.field2878;
                                                   var8 = client.field298.field2776 + (var3 - client.field467);
                                                   class0 var9;
                                                   if(client.field428.field2843 != null && client.field369) {
                                                      var9 = new class0();
                                                      var9.field1 = client.field428;
                                                      var9.field3 = var7;
                                                      var9.field4 = var8;
                                                      var9.field0 = client.field428.field2843;
                                                      class31.method737(var9, 200000);
                                                   }

                                                   if(class140.field2144 == 0) {
                                                      if(client.field369) {
                                                         if(null != client.field428.field2844) {
                                                            var9 = new class0();
                                                            var9.field1 = client.field428;
                                                            var9.field3 = var7;
                                                            var9.field4 = var8;
                                                            var9.field12 = client.field399;
                                                            var9.field0 = client.field428.field2844;
                                                            class31.method737(var9, 200000);
                                                         }

                                                         if(null != client.field399 && class76.method1704(client.field428) != null) {
                                                            client.field333.method2773(131);
                                                            client.field333.method2584(client.field399.field2764);
                                                            client.field333.method2585(client.field399.field2755);
                                                            client.field333.method2540(client.field428.field2764);
                                                            client.field333.method2594(client.field399.field2869);
                                                            client.field333.method2585(client.field428.field2755);
                                                            client.field333.method2595(client.field428.field2869);
                                                         }
                                                      } else if((client.field474 == 1 || class37.method795(client.field429 - 1)) && client.field429 > 2) {
                                                         class148.method3156(client.field308 + client.field469, client.field295 + client.field545);
                                                      } else if(client.field429 > 0) {
                                                         var18 = client.field308 + client.field469;
                                                         var10 = client.field295 + client.field545;
                                                         class14.method176(class13.field203, var18, var10);
                                                         class13.field203 = null;
                                                      }

                                                      client.field428 = null;
                                                   }
                                                } else if(class72.field1367 > 1) {
                                                   client.field428 = null;
                                                }
                                             }

                                             if(class167.field2675 != null) {
                                                class39.method818(class167.field2675);
                                                ++client.field471;
                                                if(class140.field2144 == 0) {
                                                   if(client.field407) {
                                                      if(class167.field2675 == class51.field1165 && client.field406 != client.field403) {
                                                         class173 var38 = class167.field2675;
                                                         byte var31 = 0;
                                                         if(client.field450 == 1 && var38.field2758 == 206) {
                                                            var31 = 1;
                                                         }

                                                         if(var38.field2889[client.field406] <= 0) {
                                                            var31 = 0;
                                                         }

                                                         var5 = class18.method205(var38);
                                                         boolean var30 = (var5 >> 29 & 1) != 0;
                                                         if(var30) {
                                                            var6 = client.field403;
                                                            var7 = client.field406;
                                                            var38.field2889[var7] = var38.field2889[var6];
                                                            var38.field2750[var7] = var38.field2750[var6];
                                                            var38.field2889[var6] = -1;
                                                            var38.field2750[var6] = 0;
                                                         } else if(var31 == 1) {
                                                            var6 = client.field403;
                                                            var7 = client.field406;

                                                            while(var7 != var6) {
                                                               if(var6 > var7) {
                                                                  var38.method3449(var6 - 1, var6);
                                                                  --var6;
                                                               } else if(var6 < var7) {
                                                                  var38.method3449(1 + var6, var6);
                                                                  ++var6;
                                                               }
                                                            }
                                                         } else {
                                                            var38.method3449(client.field406, client.field403);
                                                         }

                                                         client.field333.method2773(79);
                                                         client.field333.method2585(client.field403);
                                                         client.field333.method2654(var31);
                                                         client.field333.method2585(client.field406);
                                                         client.field333.method2539(class167.field2675.field2869);
                                                      }
                                                   } else if((client.field474 == 1 || class37.method795(client.field429 - 1)) && client.field429 > 2) {
                                                      class148.method3156(client.field504, client.field405);
                                                   } else if(client.field429 > 0) {
                                                      var2 = client.field504;
                                                      var3 = client.field405;
                                                      class14.method176(class13.field203, var2, var3);
                                                      class13.field203 = null;
                                                   }

                                                   client.field401 = 10;
                                                   class140.field2156 = 0;
                                                   class167.field2675 = null;
                                                } else if(client.field471 >= 5 && (class140.field2146 > 5 + client.field504 || class140.field2146 < client.field504 - 5 || class140.field2151 > 5 + client.field405 || class140.field2151 < client.field405 - 5)) {
                                                   client.field407 = true;
                                                }
                                             }

                                             if(class86.field1469 != -1) {
                                                var2 = class86.field1469;
                                                var3 = class86.field1505;
                                                client.field333.method2773(146);
                                                client.field333.method2654(5);
                                                client.field333.method2577(class137.field2114[82]?(class137.field2114[81]?2:1):0);
                                                client.field333.method2584(class20.field576 + var3);
                                                client.field333.method2540(class172.field2734 + var2);
                                                class86.field1469 = -1;
                                                client.field346 = class140.field2161;
                                                client.field398 = class140.field2158;
                                                client.field394 = 1;
                                                client.field511 = 0;
                                                client.field482 = var2;
                                                client.field522 = var3;
                                             }

                                             if(class59.field1234 != var33) {
                                                if(var33 != null) {
                                                   class39.method818(var33);
                                                }

                                                if(null != class59.field1234) {
                                                   class39.method818(class59.field1234);
                                                }
                                             }

                                             if(class42.field1002 != var28 && client.field438 == client.field439) {
                                                if(null != var28) {
                                                   class39.method818(var28);
                                                }

                                                if(null != class42.field1002) {
                                                   class39.method818(class42.field1002);
                                                }
                                             }

                                             if(class42.field1002 != null) {
                                                if(client.field438 < client.field439) {
                                                   ++client.field438;
                                                   if(client.field439 == client.field438) {
                                                      class39.method818(class42.field1002);
                                                   }
                                                }
                                             } else if(client.field438 > 0) {
                                                --client.field438;
                                             }

                                             var2 = class15.field225.field837 + client.field382;
                                             var3 = class15.field225.field880 + client.field356;
                                             if(class5.field101 - var2 < -500 || class5.field101 - var2 > 500 || class9.field161 - var3 < -500 || class9.field161 - var3 > 500) {
                                                class5.field101 = var2;
                                                class9.field161 = var3;
                                             }

                                             if(var2 != class5.field101) {
                                                class5.field101 += (var2 - class5.field101) / 16;
                                             }

                                             if(class9.field161 != var3) {
                                                class9.field161 += (var3 - class9.field161) / 16;
                                             }

                                             if(class140.field2144 == 4 && class148.field2224) {
                                                var4 = class140.field2151 - client.field472;
                                                client.field436 = var4 * 2;
                                                client.field472 = var4 != -1 && var4 != 1?(class140.field2151 + client.field472) / 2:class140.field2151;
                                                var5 = client.field371 - class140.field2146;
                                                client.field375 = var5 * 2;
                                                client.field371 = var5 != -1 && var5 != 1?(class140.field2146 + client.field371) / 2:class140.field2146;
                                             } else {
                                                if(class137.field2114[96]) {
                                                   client.field375 += (-24 - client.field375) / 2;
                                                } else if(class137.field2114[97]) {
                                                   client.field375 += (24 - client.field375) / 2;
                                                } else {
                                                   client.field375 /= 2;
                                                }

                                                if(class137.field2114[98]) {
                                                   client.field436 += (12 - client.field436) / 2;
                                                } else if(class137.field2114[99]) {
                                                   client.field436 += (-12 - client.field436) / 2;
                                                } else {
                                                   client.field436 /= 2;
                                                }

                                                client.field472 = class140.field2151;
                                                client.field371 = class140.field2146;
                                             }

                                             client.field374 = client.field374 + client.field375 / 2 & 2047;
                                             client.field373 += client.field436 / 2;
                                             if(client.field373 < 128) {
                                                client.field373 = 128;
                                             }

                                             if(client.field373 > 383) {
                                                client.field373 = 383;
                                             }

                                             var4 = class5.field101 >> 7;
                                             var5 = class9.field161 >> 7;
                                             var6 = class74.method1659(class5.field101, class9.field161, class14.field212);
                                             var7 = 0;
                                             int var11;
                                             if(var4 > 3 && var5 > 3 && var4 < 100 && var5 < 100) {
                                                for(var8 = var4 - 4; var8 <= var4 + 4; ++var8) {
                                                   for(var18 = var5 - 4; var18 <= var5 + 4; ++var18) {
                                                      var10 = class14.field212;
                                                      if(var10 < 3 && (class5.field82[1][var8][var18] & 2) == 2) {
                                                         ++var10;
                                                      }

                                                      var11 = var6 - class5.field99[var10][var8][var18];
                                                      if(var11 > var7) {
                                                         var7 = var11;
                                                      }
                                                   }
                                                }
                                             }

                                             var8 = var7 * 192;
                                             if(var8 > 98048) {
                                                var8 = 98048;
                                             }

                                             if(var8 < '耀') {
                                                var8 = '耀';
                                             }

                                             if(var8 > client.field556) {
                                                client.field556 += (var8 - client.field556) / 24;
                                             } else if(var8 < client.field556) {
                                                client.field556 += (var8 - client.field556) / 80;
                                             }

                                             if(client.field536) {
                                                var2 = 64 + client.field570 * 128;
                                                var3 = 64 + class99.field1685 * 128;
                                                var4 = class74.method1659(var2, var3, class14.field212) - class45.field1058;
                                                if(class216.field3160 < var2) {
                                                   class216.field3160 += (var2 - class216.field3160) * class0.field11 / 1000 + class149.field2242;
                                                   if(class216.field3160 > var2) {
                                                      class216.field3160 = var2;
                                                   }
                                                }

                                                if(class216.field3160 > var2) {
                                                   class216.field3160 -= class149.field2242 + (class216.field3160 - var2) * class0.field11 / 1000;
                                                   if(class216.field3160 < var2) {
                                                      class216.field3160 = var2;
                                                   }
                                                }

                                                if(class1.field27 < var4) {
                                                   class1.field27 += class149.field2242 + class0.field11 * (var4 - class1.field27) / 1000;
                                                   if(class1.field27 > var4) {
                                                      class1.field27 = var4;
                                                   }
                                                }

                                                if(class1.field27 > var4) {
                                                   class1.field27 -= class149.field2242 + class0.field11 * (class1.field27 - var4) / 1000;
                                                   if(class1.field27 < var4) {
                                                      class1.field27 = var4;
                                                   }
                                                }

                                                if(class26.field665 < var3) {
                                                   class26.field665 += class149.field2242 + (var3 - class26.field665) * class0.field11 / 1000;
                                                   if(class26.field665 > var3) {
                                                      class26.field665 = var3;
                                                   }
                                                }

                                                if(class26.field665 > var3) {
                                                   class26.field665 -= class149.field2242 + (class26.field665 - var3) * class0.field11 / 1000;
                                                   if(class26.field665 < var3) {
                                                      class26.field665 = var3;
                                                   }
                                                }

                                                var2 = class136.field2091 * 128 + 64;
                                                var3 = class44.field1050 * 128 + 64;
                                                var4 = class74.method1659(var2, var3, class14.field212) - class137.field2128;
                                                var5 = var2 - class216.field3160;
                                                var6 = var4 - class1.field27;
                                                var7 = var3 - class26.field665;
                                                var8 = (int)Math.sqrt((double)(var5 * var5 + var7 * var7));
                                                var18 = (int)(Math.atan2((double)var6, (double)var8) * 325.949D) & 2047;
                                                var10 = (int)(Math.atan2((double)var5, (double)var7) * -325.949D) & 2047;
                                                if(var18 < 128) {
                                                   var18 = 128;
                                                }

                                                if(var18 > 383) {
                                                   var18 = 383;
                                                }

                                                if(class134.field2082 < var18) {
                                                   class134.field2082 += class155.field2289 + (var18 - class134.field2082) * class89.field1558 / 1000;
                                                   if(class134.field2082 > var18) {
                                                      class134.field2082 = var18;
                                                   }
                                                }

                                                if(class134.field2082 > var18) {
                                                   class134.field2082 -= class155.field2289 + (class134.field2082 - var18) * class89.field1558 / 1000;
                                                   if(class134.field2082 < var18) {
                                                      class134.field2082 = var18;
                                                   }
                                                }

                                                var11 = var10 - class42.field1018;
                                                if(var11 > 1024) {
                                                   var11 -= 2048;
                                                }

                                                if(var11 < -1024) {
                                                   var11 += 2048;
                                                }

                                                if(var11 > 0) {
                                                   class42.field1018 += var11 * class89.field1558 / 1000 + class155.field2289;
                                                   class42.field1018 &= 2047;
                                                }

                                                if(var11 < 0) {
                                                   class42.field1018 -= class89.field1558 * -var11 / 1000 + class155.field2289;
                                                   class42.field1018 &= 2047;
                                                }

                                                int var12 = var10 - class42.field1018;
                                                if(var12 > 1024) {
                                                   var12 -= 2048;
                                                }

                                                if(var12 < -1024) {
                                                   var12 += 2048;
                                                }

                                                if(var12 < 0 && var11 > 0 || var12 > 0 && var11 < 0) {
                                                   class42.field1018 = var10;
                                                }
                                             }

                                             for(var2 = 0; var2 < 5; ++var2) {
                                                ++client.field541[var2];
                                             }

                                             field65.method219();
                                             var2 = method44();
                                             var3 = class137.field2126;
                                             if(var2 > 15000 && var3 > 15000) {
                                                client.field343 = 250;
                                                class140.field2145 = 14500;
                                                client.field333.method2773(74);
                                             }

                                             ++client.field345;
                                             if(client.field345 > 500) {
                                                client.field345 = 0;
                                                var5 = (int)(Math.random() * 8.0D);
                                                if((var5 & 1) == 1) {
                                                   client.field382 += client.field550;
                                                }

                                                if((var5 & 2) == 2) {
                                                   client.field356 += client.field357;
                                                }

                                                if((var5 & 4) == 4) {
                                                   client.field358 += client.field289;
                                                }
                                             }

                                             if(client.field382 < -50) {
                                                client.field550 = 2;
                                             }

                                             if(client.field382 > 50) {
                                                client.field550 = -2;
                                             }

                                             if(client.field356 < -55) {
                                                client.field357 = 2;
                                             }

                                             if(client.field356 > 55) {
                                                client.field357 = -2;
                                             }

                                             if(client.field358 < -40) {
                                                client.field289 = 1;
                                             }

                                             if(client.field358 > 40) {
                                                client.field289 = -1;
                                             }

                                             ++client.field359;
                                             if(client.field359 > 500) {
                                                client.field359 = 0;
                                                var5 = (int)(Math.random() * 8.0D);
                                                if((var5 & 1) == 1) {
                                                   client.field500 += client.field362;
                                                }

                                                if((var5 & 2) == 2) {
                                                   client.field363 += client.field503;
                                                }
                                             }

                                             if(client.field500 < -60) {
                                                client.field362 = 2;
                                             }

                                             if(client.field500 > 60) {
                                                client.field362 = -2;
                                             }

                                             if(client.field363 < -20) {
                                                client.field503 = 1;
                                             }

                                             if(client.field363 > 10) {
                                                client.field503 = -1;
                                             }

                                             for(class38 var37 = (class38)client.field558.method3810(); var37 != null; var37 = (class38)client.field558.method3817()) {
                                                if((long)var37.field891 < class130.method2846() / 1000L - 5L) {
                                                   if(var37.field886 > 0) {
                                                      class52.method1147(5, "", var37.field885 + " has logged in.");
                                                   }

                                                   if(var37.field886 == 0) {
                                                      class52.method1147(5, "", var37.field885 + " has logged out.");
                                                   }

                                                   var37.method3936();
                                                }
                                             }

                                             ++client.field339;
                                             if(client.field339 > 50) {
                                                client.field333.method2773(144);
                                             }

                                             try {
                                                if(class172.field2742 != null && client.field333.field1998 > 0) {
                                                   class172.field2742.method3018(client.field333.field2000, 0, client.field333.field1998);
                                                   client.field333.field1998 = 0;
                                                   client.field339 = 0;
                                                }
                                             } catch (IOException var23) {
                                                if(client.field343 > 0) {
                                                   class5.method71();
                                                } else {
                                                   class11.method156(40);
                                                   class9.field158 = class172.field2742;
                                                   class172.field2742 = null;
                                                }
                                             }

                                             return;
                                          }

                                          var35 = var22.field1;
                                          if(var35.field2755 < 0) {
                                             break;
                                          }

                                          var36 = class153.method3177(var35.field2773);
                                       } while(null == var36 || var36.field2767 == null || var35.field2755 >= var36.field2767.length || var36.field2767[var35.field2755] != var35);

                                       class31.method737(var22, 200000);
                                    }
                                 }

                                 var35 = var22.field1;
                                 if(var35.field2755 < 0) {
                                    break;
                                 }

                                 var36 = class153.method3177(var35.field2773);
                              } while(var36 == null || var36.field2767 == null || var35.field2755 >= var36.field2767.length || var35 != var36.field2767[var35.field2755]);

                              class31.method737(var22, 200000);
                           }
                        }

                        var35 = var22.field1;
                        if(var35.field2755 < 0) {
                           break;
                        }

                        var36 = class153.method3177(var35.field2773);
                     } while(var36 == null || null == var36.field2767 || var35.field2755 >= var36.field2767.length || var35 != var36.field2767[var35.field2755]);

                     class31.method737(var22, 200000);
                  }
               }

               client.field333.method2773(150);
               client.field333.method2654(0);
               var16 = client.field333.field1998;
               class10.method140(client.field333);
               client.field333.method2551(client.field333.field1998 - var16);
            }
         }
      }
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1875350745"
   )
   static void method47() {
      class15.field229 = new class196(32);
   }
}
