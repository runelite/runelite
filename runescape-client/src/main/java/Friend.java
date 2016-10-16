import java.awt.datatransfer.Clipboard;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("q")
@Implements("Friend")
public class Friend {
   @ObfuscatedName("p")
   boolean field223;
   @ObfuscatedName("z")
   @Export("previousName")
   String previousName;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 2039839657
   )
   @Export("world")
   int world;
   @ObfuscatedName("s")
   @Export("name")
   String name;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 1261838405
   )
   @Export("rank")
   int rank;
   @ObfuscatedName("pl")
   static Clipboard field229;
   @ObfuscatedName("g")
   boolean field233;

   @ObfuscatedName("bm")
   @ObfuscatedSignature(
      signature = "(LPlayer;IIBS)V",
      garbageValue = "-22896"
   )
   static final void method190(Player var0, int var1, int var2, byte var3) {
      int var4 = var0.pathX[0];
      int var5 = var0.pathY[0];
      int var6 = var0.method9();
      if(var4 >= var6 && var4 < 104 - var6 && var5 >= var6 && var5 < 104 - var6) {
         if(var1 >= var6 && var1 < 104 - var6 && var2 >= var6 && var2 < 104 - var6) {
            int var8 = var0.method9();
            class110 var9 = class143.method2968(var1, var2);
            CollisionData var10 = Client.collisionMaps[var0.field47];
            int[] var11 = Client.field445;
            int[] var12 = Client.field549;

            int var13;
            int var14;
            for(var13 = 0; var13 < 128; ++var13) {
               for(var14 = 0; var14 < 128; ++var14) {
                  class109.field1905[var13][var14] = 0;
                  class109.field1906[var13][var14] = 99999999;
               }
            }

            int var15;
            int var16;
            byte var18;
            int var19;
            int var20;
            int var22;
            int var24;
            int var25;
            int var26;
            boolean var33;
            int var35;
            int var36;
            int var38;
            if(var8 == 1) {
               var33 = class14.method172(var4, var5, var9, var10);
            } else if(var8 == 2) {
               var15 = var4;
               var16 = var5;
               byte var17 = 64;
               var18 = 64;
               var19 = var4 - var17;
               var20 = var5 - var18;
               class109.field1905[var17][var18] = 99;
               class109.field1906[var17][var18] = 0;
               byte var21 = 0;
               var22 = 0;
               class109.field1912[var21] = var4;
               var38 = var21 + 1;
               class109.field1915[var21] = var5;
               int[][] var23 = var10.flags;

               boolean var34;
               while(true) {
                  if(var22 == var38) {
                     class109.field1907 = var15;
                     class109.field1908 = var16;
                     var34 = false;
                     break;
                  }

                  var15 = class109.field1912[var22];
                  var16 = class109.field1915[var22];
                  var22 = 1 + var22 & 4095;
                  var35 = var15 - var19;
                  var36 = var16 - var20;
                  var24 = var15 - var10.x;
                  var25 = var16 - var10.y;
                  if(var9.vmethod2357(2, var15, var16, var10)) {
                     class109.field1907 = var15;
                     class109.field1908 = var16;
                     var34 = true;
                     break;
                  }

                  var26 = class109.field1906[var35][var36] + 1;
                  if(var35 > 0 && class109.field1905[var35 - 1][var36] == 0 && (var23[var24 - 1][var25] & 19136782) == 0 && (var23[var24 - 1][1 + var25] & 19136824) == 0) {
                     class109.field1912[var38] = var15 - 1;
                     class109.field1915[var38] = var16;
                     var38 = var38 + 1 & 4095;
                     class109.field1905[var35 - 1][var36] = 2;
                     class109.field1906[var35 - 1][var36] = var26;
                  }

                  if(var35 < 126 && class109.field1905[1 + var35][var36] == 0 && (var23[var24 + 2][var25] & 19136899) == 0 && (var23[var24 + 2][1 + var25] & 19136992) == 0) {
                     class109.field1912[var38] = 1 + var15;
                     class109.field1915[var38] = var16;
                     var38 = 1 + var38 & 4095;
                     class109.field1905[var35 + 1][var36] = 8;
                     class109.field1906[var35 + 1][var36] = var26;
                  }

                  if(var36 > 0 && class109.field1905[var35][var36 - 1] == 0 && (var23[var24][var25 - 1] & 19136782) == 0 && (var23[var24 + 1][var25 - 1] & 19136899) == 0) {
                     class109.field1912[var38] = var15;
                     class109.field1915[var38] = var16 - 1;
                     var38 = 1 + var38 & 4095;
                     class109.field1905[var35][var36 - 1] = 1;
                     class109.field1906[var35][var36 - 1] = var26;
                  }

                  if(var36 < 126 && class109.field1905[var35][1 + var36] == 0 && (var23[var24][var25 + 2] & 19136824) == 0 && (var23[1 + var24][2 + var25] & 19136992) == 0) {
                     class109.field1912[var38] = var15;
                     class109.field1915[var38] = var16 + 1;
                     var38 = 1 + var38 & 4095;
                     class109.field1905[var35][var36 + 1] = 4;
                     class109.field1906[var35][var36 + 1] = var26;
                  }

                  if(var35 > 0 && var36 > 0 && class109.field1905[var35 - 1][var36 - 1] == 0 && (var23[var24 - 1][var25] & 19136830) == 0 && (var23[var24 - 1][var25 - 1] & 19136782) == 0 && (var23[var24][var25 - 1] & 19136911) == 0) {
                     class109.field1912[var38] = var15 - 1;
                     class109.field1915[var38] = var16 - 1;
                     var38 = 1 + var38 & 4095;
                     class109.field1905[var35 - 1][var36 - 1] = 3;
                     class109.field1906[var35 - 1][var36 - 1] = var26;
                  }

                  if(var35 < 126 && var36 > 0 && class109.field1905[var35 + 1][var36 - 1] == 0 && (var23[1 + var24][var25 - 1] & 19136911) == 0 && (var23[var24 + 2][var25 - 1] & 19136899) == 0 && (var23[2 + var24][var25] & 19136995) == 0) {
                     class109.field1912[var38] = 1 + var15;
                     class109.field1915[var38] = var16 - 1;
                     var38 = 1 + var38 & 4095;
                     class109.field1905[1 + var35][var36 - 1] = 9;
                     class109.field1906[var35 + 1][var36 - 1] = var26;
                  }

                  if(var35 > 0 && var36 < 126 && class109.field1905[var35 - 1][1 + var36] == 0 && (var23[var24 - 1][1 + var25] & 19136830) == 0 && (var23[var24 - 1][var25 + 2] & 19136824) == 0 && (var23[var24][var25 + 2] & 19137016) == 0) {
                     class109.field1912[var38] = var15 - 1;
                     class109.field1915[var38] = 1 + var16;
                     var38 = 1 + var38 & 4095;
                     class109.field1905[var35 - 1][1 + var36] = 6;
                     class109.field1906[var35 - 1][var36 + 1] = var26;
                  }

                  if(var35 < 126 && var36 < 126 && class109.field1905[1 + var35][var36 + 1] == 0 && (var23[var24 + 1][var25 + 2] & 19137016) == 0 && (var23[var24 + 2][var25 + 2] & 19136992) == 0 && (var23[2 + var24][var25 + 1] & 19136995) == 0) {
                     class109.field1912[var38] = var15 + 1;
                     class109.field1915[var38] = var16 + 1;
                     var38 = 1 + var38 & 4095;
                     class109.field1905[var35 + 1][var36 + 1] = 12;
                     class109.field1906[var35 + 1][var36 + 1] = var26;
                  }
               }

               var33 = var34;
            } else {
               var33 = Renderable.method1912(var4, var5, var8, var9, var10);
            }

            int var7;
            label457: {
               var14 = var4 - 64;
               var15 = var5 - 64;
               var16 = class109.field1907;
               var35 = class109.field1908;
               if(!var33) {
                  var36 = Integer.MAX_VALUE;
                  var19 = Integer.MAX_VALUE;
                  byte var37 = 10;
                  var38 = var9.field1920;
                  var22 = var9.field1917;
                  int var32 = var9.field1918;
                  var24 = var9.field1919;

                  for(var25 = var38 - var37; var25 <= var38 + var37; ++var25) {
                     for(var26 = var22 - var37; var26 <= var22 + var37; ++var26) {
                        int var27 = var25 - var14;
                        int var28 = var26 - var15;
                        if(var27 >= 0 && var28 >= 0 && var27 < 128 && var28 < 128 && class109.field1906[var27][var28] < 100) {
                           int var29 = 0;
                           if(var25 < var38) {
                              var29 = var38 - var25;
                           } else if(var25 > var32 + var38 - 1) {
                              var29 = var25 - (var38 + var32 - 1);
                           }

                           int var30 = 0;
                           if(var26 < var22) {
                              var30 = var22 - var26;
                           } else if(var26 > var22 + var24 - 1) {
                              var30 = var26 - (var22 + var24 - 1);
                           }

                           int var31 = var29 * var29 + var30 * var30;
                           if(var31 < var36 || var36 == var31 && class109.field1906[var27][var28] < var19) {
                              var36 = var31;
                              var19 = class109.field1906[var27][var28];
                              var16 = var25;
                              var35 = var26;
                           }
                        }
                     }
                  }

                  if(var36 == Integer.MAX_VALUE) {
                     var7 = -1;
                     break label457;
                  }
               }

               if(var4 == var16 && var35 == var5) {
                  var7 = 0;
               } else {
                  var18 = 0;
                  class109.field1912[var18] = var16;
                  var36 = var18 + 1;
                  class109.field1915[var18] = var35;

                  for(var19 = var20 = class109.field1905[var16 - var14][var35 - var15]; var4 != var16 || var5 != var35; var19 = class109.field1905[var16 - var14][var35 - var15]) {
                     if(var20 != var19) {
                        var20 = var19;
                        class109.field1912[var36] = var16;
                        class109.field1915[var36++] = var35;
                     }

                     if((var19 & 2) != 0) {
                        ++var16;
                     } else if((var19 & 8) != 0) {
                        --var16;
                     }

                     if((var19 & 1) != 0) {
                        ++var35;
                     } else if((var19 & 4) != 0) {
                        --var35;
                     }
                  }

                  var38 = 0;

                  while(var36-- > 0) {
                     var11[var38] = class109.field1912[var36];
                     var12[var38++] = class109.field1915[var36];
                     if(var38 >= var11.length) {
                        break;
                     }
                  }

                  var7 = var38;
               }
            }

            var13 = var7;
            if(var7 >= 1) {
               for(var14 = 0; var14 < var13 - 1; ++var14) {
                  var0.method13(Client.field445[var14], Client.field549[var14], var3);
               }

            }
         }
      }
   }

   @ObfuscatedName("ct")
   @ObfuscatedSignature(
      signature = "([LWidget;IIIIIIIII)V",
      garbageValue = "-887109221"
   )
   @Export("gameDraw")
   static final void gameDraw(Widget[] var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
      class82.method1795(var2, var3, var4, var5);
      class94.method2081();

      for(int var9 = 0; var9 < var0.length; ++var9) {
         Widget var10 = var0[var9];
         if(var10 != null && (var10.parentId == var1 || var1 == -1412584499 && var10 == Client.field441)) {
            int var11;
            if(var8 == -1) {
               Client.widgetPositionX[Client.field298] = var10.relativeX + var6;
               Client.widgetPositionY[Client.field298] = var7 + var10.relativeY;
               Client.widgetBoundsWidth[Client.field298] = var10.width;
               Client.widgetBoundsHeight[Client.field298] = var10.height;
               var11 = ++Client.field298 - 1;
            } else {
               var11 = var8;
            }

            var10.boundsIndex = var11;
            var10.field2930 = Client.gameCycle;
            if(!var10.field2797 || !class13.method164(var10)) {
               int var12;
               if(var10.contentType > 0) {
                  var12 = var10.contentType;
                  if(var12 == 324) {
                     if(Client.field542 == -1) {
                        Client.field542 = var10.textureId;
                        Client.field543 = var10.field2834;
                     }

                     if(Client.field541.isFemale) {
                        var10.textureId = Client.field542;
                     } else {
                        var10.textureId = Client.field543;
                     }
                  } else if(var12 == 325) {
                     if(Client.field542 == -1) {
                        Client.field542 = var10.textureId;
                        Client.field543 = var10.field2834;
                     }

                     if(Client.field541.isFemale) {
                        var10.textureId = Client.field543;
                     } else {
                        var10.textureId = Client.field542;
                     }
                  } else if(var12 == 327) {
                     var10.rotationX = 150;
                     var10.rotationZ = (int)(Math.sin((double)Client.gameCycle / 40.0D) * 256.0D) & 2047;
                     var10.modelType = 5;
                     var10.modelId = 0;
                  } else if(var12 == 328) {
                     var10.rotationX = 150;
                     var10.rotationZ = (int)(Math.sin((double)Client.gameCycle / 40.0D) * 256.0D) & 2047;
                     var10.modelType = 5;
                     var10.modelId = 1;
                  }
               }

               var12 = var6 + var10.relativeX;
               int var13 = var10.relativeY + var7;
               int var14 = var10.opacity;
               int var15;
               int var16;
               if(var10 == Client.field441) {
                  if(var1 != -1412584499 && !var10.field2876) {
                     Ignore.field119 = var0;
                     class165.field2696 = var6;
                     class9.field142 = var7;
                     continue;
                  }

                  if(Client.field473 && Client.field446) {
                     var15 = class143.field2192;
                     var16 = class143.field2189;
                     var15 -= Client.field280;
                     var16 -= Client.field444;
                     if(var15 < Client.field404) {
                        var15 = Client.field404;
                     }

                     if(var15 + var10.width > Client.field391.width + Client.field404) {
                        var15 = Client.field391.width + Client.field404 - var10.width;
                     }

                     if(var16 < Client.field336) {
                        var16 = Client.field336;
                     }

                     if(var16 + var10.height > Client.field336 + Client.field391.height) {
                        var16 = Client.field336 + Client.field391.height - var10.height;
                     }

                     var12 = var15;
                     var13 = var16;
                  }

                  if(!var10.field2876) {
                     var14 = 128;
                  }
               }

               int var17;
               int var18;
               int var19;
               int var20;
               int var21;
               int var37;
               if(var10.type == 2) {
                  var15 = var2;
                  var16 = var3;
                  var17 = var4;
                  var18 = var5;
               } else if(var10.type == 9) {
                  var19 = var12;
                  var20 = var13;
                  var21 = var10.width + var12;
                  var37 = var13 + var10.height;
                  if(var21 < var12) {
                     var19 = var21;
                     var21 = var12;
                  }

                  if(var37 < var13) {
                     var20 = var37;
                     var37 = var13;
                  }

                  ++var21;
                  ++var37;
                  var15 = var19 > var2?var19:var2;
                  var16 = var20 > var3?var20:var3;
                  var17 = var21 < var4?var21:var4;
                  var18 = var37 < var5?var37:var5;
               } else {
                  var19 = var10.width + var12;
                  var20 = var13 + var10.height;
                  var15 = var12 > var2?var12:var2;
                  var16 = var13 > var3?var13:var3;
                  var17 = var19 < var4?var19:var4;
                  var18 = var20 < var5?var20:var5;
               }

               if(!var10.field2797 || var15 < var17 && var16 < var18) {
                  int var23;
                  int var24;
                  int var27;
                  int var28;
                  int var31;
                  int var41;
                  int var42;
                  if(var10.contentType != 0) {
                     if(var10.contentType == 1336) {
                        if(Client.field282) {
                           var13 += 15;
                           class218.field3204.method4093("Fps:" + GameEngine.FPS, var10.width + var12, var13, 16776960, -1);
                           var13 += 15;
                           Runtime var58 = Runtime.getRuntime();
                           var20 = (int)((var58.totalMemory() - var58.freeMemory()) / 1024L);
                           var21 = 16776960;
                           if(var20 > '耀' && Client.field271) {
                              var21 = 16711680;
                           }

                           if(var20 > 65536 && !Client.field271) {
                              var21 = 16711680;
                           }

                           class218.field3204.method4093("Mem:" + var20 + "k", var10.width + var12, var13, var21, -1);
                           var13 += 15;
                        }
                        continue;
                     }

                     if(var10.contentType == 1337) {
                        Client.field427 = var12;
                        Client.field405 = var13;
                        class124.method2739(var12, var13, var10.width, var10.height);
                        Client.field379[var10.boundsIndex] = true;
                        class82.method1795(var2, var3, var4, var5);
                        continue;
                     }

                     class178 var56;
                     if(var10.contentType == 1338) {
                        class12.method162();
                        var56 = var10.method3407(false);
                        if(null != var56) {
                           class82.method1795(var12, var13, var56.field2943 + var12, var13 + var56.field2944);
                           if(Client.field326 != 2 && Client.field326 != 5) {
                              var20 = Client.mapScale + Client.mapAngle & 2047;
                              var21 = TextureProvider.localPlayer.x / 32 + 48;
                              var37 = 464 - TextureProvider.localPlayer.y / 32;
                              class11.field166.method1723(var12, var13, var56.field2943, var56.field2944, var21, var37, var20, Client.mapScaleDelta + 256, var56.field2948, var56.field2945);

                              for(var23 = 0; var23 < Client.field498; ++var23) {
                                 var24 = 2 + 4 * Client.field499[var23] - TextureProvider.localPlayer.x / 32;
                                 var41 = 4 * Client.field500[var23] + 2 - TextureProvider.localPlayer.y / 32;
                                 TextureProvider.method2172(var12, var13, var24, var41, Client.field501[var23], var56);
                              }

                              var23 = 0;

                              while(true) {
                                 if(var23 >= 104) {
                                    for(var23 = 0; var23 < Client.field309; ++var23) {
                                       NPC var62 = Client.cachedNPCs[Client.field307[var23]];
                                       if(null != var62 && var62.vmethod767()) {
                                          NPCComposition var47 = var62.composition;
                                          if(var47 != null && null != var47.field897) {
                                             var47 = var47.method790();
                                          }

                                          if(null != var47 && var47.isMinimapVisible && var47.field900) {
                                             var42 = var62.x / 32 - TextureProvider.localPlayer.x / 32;
                                             var27 = var62.y / 32 - TextureProvider.localPlayer.y / 32;
                                             TextureProvider.method2172(var12, var13, var42, var27, Client.field348[1], var56);
                                          }
                                       }
                                    }

                                    var23 = class34.field743;
                                    int[] var64 = class34.field739;

                                    for(var41 = 0; var41 < var23; ++var41) {
                                       Player var26 = Client.cachedPlayers[var64[var41]];
                                       if(null != var26 && var26.vmethod767() && !var26.field50 && TextureProvider.localPlayer != var26) {
                                          var27 = var26.x / 32 - TextureProvider.localPlayer.x / 32;
                                          var28 = var26.y / 32 - TextureProvider.localPlayer.y / 32;
                                          boolean var53 = false;
                                          if(ChatMessages.method222(var26.name, true)) {
                                             var53 = true;
                                          }

                                          boolean var51 = false;

                                          for(var31 = 0; var31 < NPC.field764; ++var31) {
                                             if(var26.name.equals(Frames.clanMembers[var31].username)) {
                                                var51 = true;
                                                break;
                                             }
                                          }

                                          boolean var52 = false;
                                          if(TextureProvider.localPlayer.team != 0 && var26.team != 0 && TextureProvider.localPlayer.team == var26.team) {
                                             var52 = true;
                                          }

                                          if(var53) {
                                             TextureProvider.method2172(var12, var13, var27, var28, Client.field348[3], var56);
                                          } else if(var52) {
                                             TextureProvider.method2172(var12, var13, var27, var28, Client.field348[4], var56);
                                          } else if(var51) {
                                             TextureProvider.method2172(var12, var13, var27, var28, Client.field348[5], var56);
                                          } else {
                                             TextureProvider.method2172(var12, var13, var27, var28, Client.field348[2], var56);
                                          }
                                       }
                                    }

                                    if(Client.field310 != 0 && Client.gameCycle % 20 < 10) {
                                       if(Client.field310 == 1 && Client.field285 >= 0 && Client.field285 < Client.cachedNPCs.length) {
                                          NPC var48 = Client.cachedNPCs[Client.field285];
                                          if(var48 != null) {
                                             var42 = var48.x / 32 - TextureProvider.localPlayer.x / 32;
                                             var27 = var48.y / 32 - TextureProvider.localPlayer.y / 32;
                                             class140.method2919(var12, var13, var42, var27, Item.field676[1], var56);
                                          }
                                       }

                                       if(Client.field310 == 2) {
                                          var41 = Client.field287 * 4 - class23.baseX * 4 + 2 - TextureProvider.localPlayer.x / 32;
                                          var42 = 2 + (Client.field433 * 4 - class8.baseY * 4) - TextureProvider.localPlayer.y / 32;
                                          class140.method2919(var12, var13, var41, var42, Item.field676[1], var56);
                                       }

                                       if(Client.field310 == 10 && Client.field417 >= 0 && Client.field417 < Client.cachedPlayers.length) {
                                          Player var49 = Client.cachedPlayers[Client.field417];
                                          if(var49 != null) {
                                             var42 = var49.x / 32 - TextureProvider.localPlayer.x / 32;
                                             var27 = var49.y / 32 - TextureProvider.localPlayer.y / 32;
                                             class140.method2919(var12, var13, var42, var27, Item.field676[1], var56);
                                          }
                                       }
                                    }

                                    if(Client.flagX != 0) {
                                       var41 = Client.flagX * 4 + 2 - TextureProvider.localPlayer.x / 32;
                                       var42 = Client.flagY * 4 + 2 - TextureProvider.localPlayer.y / 32;
                                       TextureProvider.method2172(var12, var13, var41, var42, Item.field676[0], var56);
                                    }

                                    if(!TextureProvider.localPlayer.field50) {
                                       class82.method1801(var12 + var56.field2943 / 2 - 1, var13 + var56.field2944 / 2 - 1, 3, 3, 16777215);
                                    }
                                    break;
                                 }

                                 for(var24 = 0; var24 < 104; ++var24) {
                                    Deque var25 = Client.groundItemDeque[class59.plane][var23][var24];
                                    if(null != var25) {
                                       var42 = 4 * var23 + 2 - TextureProvider.localPlayer.x / 32;
                                       var27 = var24 * 4 + 2 - TextureProvider.localPlayer.y / 32;
                                       TextureProvider.method2172(var12, var13, var42, var27, Client.field348[0], var56);
                                    }
                                 }

                                 ++var23;
                              }
                           } else {
                              class82.method1814(var12, var13, 0, var56.field2948, var56.field2945);
                           }

                           Client.field452[var11] = true;
                        }

                        class82.method1795(var2, var3, var4, var5);
                        continue;
                     }

                     if(var10.contentType == 1339) {
                        var56 = var10.method3407(false);
                        if(null != var56) {
                           if(Client.field326 < 3) {
                              class191.field3097.method1723(var12, var13, var56.field2943, var56.field2944, 25, 25, Client.mapAngle, 256, var56.field2948, var56.field2945);
                           } else {
                              class82.method1814(var12, var13, 0, var56.field2948, var56.field2945);
                           }
                        }

                        class82.method1795(var2, var3, var4, var5);
                        continue;
                     }
                  }

                  if(var10.type == 0) {
                     if(!var10.field2797 && class13.method164(var10) && var10 != ItemComposition.field1196) {
                        continue;
                     }

                     if(!var10.field2797) {
                        if(var10.scrollY > var10.scrollHeight - var10.height) {
                           var10.scrollY = var10.scrollHeight - var10.height;
                        }

                        if(var10.scrollY < 0) {
                           var10.scrollY = 0;
                        }
                     }

                     gameDraw(var0, var10.id, var15, var16, var17, var18, var12 - var10.itemId, var13 - var10.scrollY, var11);
                     if(null != var10.children) {
                        gameDraw(var10.children, var10.id, var15, var16, var17, var18, var12 - var10.itemId, var13 - var10.scrollY, var11);
                     }

                     WidgetNode var36 = (WidgetNode)Client.componentTable.method3775((long)var10.id);
                     if(null != var36) {
                        class151.method3122(var36.id, var15, var16, var17, var18, var12, var13, var11);
                     }

                     class82.method1795(var2, var3, var4, var5);
                     class94.method2081();
                  }

                  if(Client.isResized || Client.field320[var11] || Client.field480 > 1) {
                     if(var10.type == 0 && !var10.field2797 && var10.scrollHeight > var10.height) {
                        WidgetNode.method41(var10.width + var12, var13, var10.scrollY, var10.height, var10.scrollHeight);
                     }

                     if(var10.type != 1) {
                        int var29;
                        if(var10.type == 2) {
                           var19 = 0;

                           for(var20 = 0; var20 < var10.field2791; ++var20) {
                              for(var21 = 0; var21 < var10.field2805; ++var21) {
                                 var37 = (var10.field2795 + 32) * var21 + var12;
                                 var23 = var20 * (32 + var10.field2865) + var13;
                                 if(var19 < 20) {
                                    var37 += var10.field2866[var19];
                                    var23 += var10.field2867[var19];
                                 }

                                 if(var10.itemIds[var19] <= 0) {
                                    if(null != var10.field2868 && var19 < 20) {
                                       SpritePixels var61 = var10.method3405(var19);
                                       if(var61 != null) {
                                          var61.method1712(var37, var23);
                                       } else if(Widget.field2796) {
                                          class32.method685(var10);
                                       }
                                    }
                                 } else {
                                    boolean var50 = false;
                                    boolean var65 = false;
                                    var42 = var10.itemIds[var19] - 1;
                                    if(var37 + 32 > var2 && var37 < var4 && 32 + var23 > var3 && var23 < var5 || var10 == SecondaryBufferProvider.field1414 && Client.field383 == var19) {
                                       SpritePixels var44;
                                       if(Client.field421 == 1 && var19 == class145.field2215 && Item.field670 == var10.id) {
                                          var44 = class21.createSprite(var42, var10.itemQuantities[var19], 2, 0, 2, false);
                                       } else {
                                          var44 = class21.createSprite(var42, var10.itemQuantities[var19], 1, 3153952, 2, false);
                                       }

                                       if(null != var44) {
                                          if(var10 == SecondaryBufferProvider.field1414 && var19 == Client.field383) {
                                             var24 = class143.field2192 - Client.field384;
                                             var41 = class143.field2189 - Client.field385;
                                             if(var24 < 5 && var24 > -5) {
                                                var24 = 0;
                                             }

                                             if(var41 < 5 && var41 > -5) {
                                                var41 = 0;
                                             }

                                             if(Client.field388 < 5) {
                                                var24 = 0;
                                                var41 = 0;
                                             }

                                             var44.method1705(var24 + var37, var41 + var23, 128);
                                             if(var1 != -1) {
                                                Widget var43 = var0[var1 & '\uffff'];
                                                if(var41 + var23 < class82.field1452 && var43.scrollY > 0) {
                                                   var29 = Client.field297 * (class82.field1452 - var23 - var41) / 3;
                                                   if(var29 > Client.field297 * 10) {
                                                      var29 = Client.field297 * 10;
                                                   }

                                                   if(var29 > var43.scrollY) {
                                                      var29 = var43.scrollY;
                                                   }

                                                   var43.scrollY -= var29;
                                                   Client.field385 += var29;
                                                   class32.method685(var43);
                                                }

                                                if(32 + var41 + var23 > class82.field1454 && var43.scrollY < var43.scrollHeight - var43.height) {
                                                   var29 = (var23 + var41 + 32 - class82.field1454) * Client.field297 / 3;
                                                   if(var29 > Client.field297 * 10) {
                                                      var29 = Client.field297 * 10;
                                                   }

                                                   if(var29 > var43.scrollHeight - var43.height - var43.scrollY) {
                                                      var29 = var43.scrollHeight - var43.height - var43.scrollY;
                                                   }

                                                   var43.scrollY += var29;
                                                   Client.field385 -= var29;
                                                   class32.method685(var43);
                                                }
                                             }
                                          } else if(var10 == NPCComposition.field873 && Client.field317 == var19) {
                                             var44.method1705(var37, var23, 128);
                                          } else {
                                             var44.method1712(var37, var23);
                                          }
                                       } else {
                                          class32.method685(var10);
                                       }
                                    }
                                 }

                                 ++var19;
                              }
                           }
                        } else if(var10.type == 3) {
                           if(Player.method37(var10)) {
                              var19 = var10.field2824;
                              if(ItemComposition.field1196 == var10 && var10.field2826 != 0) {
                                 var19 = var10.field2826;
                              }
                           } else {
                              var19 = var10.textColor;
                              if(ItemComposition.field1196 == var10 && var10.field2825 != 0) {
                                 var19 = var10.field2825;
                              }
                           }

                           if(var10.field2827) {
                              switch(var10.field2806.field1472) {
                              case 1:
                                 class82.method1802(var12, var13, var10.width, var10.height, var10.textColor, var10.field2824, 256 - (var10.opacity & 255), 256 - (var10.field2830 & 255));
                                 break;
                              case 2:
                                 class82.method1851(var12, var13, var10.width, var10.height, var10.textColor, var10.field2824, 256 - (var10.opacity & 255), 256 - (var10.field2830 & 255));
                                 break;
                              case 3:
                                 class82.method1804(var12, var13, var10.width, var10.height, var10.textColor, var10.field2824, 256 - (var10.opacity & 255), 256 - (var10.field2830 & 255));
                                 break;
                              case 4:
                                 class82.method1805(var12, var13, var10.width, var10.height, var10.textColor, var10.field2824, 256 - (var10.opacity & 255), 256 - (var10.field2830 & 255));
                                 break;
                              default:
                                 if(var14 == 0) {
                                    class82.method1801(var12, var13, var10.width, var10.height, var19);
                                 } else {
                                    class82.method1800(var12, var13, var10.width, var10.height, var19, 256 - (var14 & 255));
                                 }
                              }
                           } else if(var14 == 0) {
                              class82.method1815(var12, var13, var10.width, var10.height, var19);
                           } else {
                              class82.method1808(var12, var13, var10.width, var10.height, var19, 256 - (var14 & 255));
                           }
                        } else {
                           class227 var54;
                           if(var10.type == 4) {
                              var54 = var10.method3419();
                              if(var54 == null) {
                                 if(Widget.field2796) {
                                    class32.method685(var10);
                                 }
                              } else {
                                 String var60 = var10.text;
                                 if(Player.method37(var10)) {
                                    var20 = var10.field2824;
                                    if(var10 == ItemComposition.field1196 && var10.field2826 != 0) {
                                       var20 = var10.field2826;
                                    }

                                    if(var10.field2810.length() > 0) {
                                       var60 = var10.field2810;
                                    }
                                 } else {
                                    var20 = var10.textColor;
                                    if(var10 == ItemComposition.field1196 && var10.field2825 != 0) {
                                       var20 = var10.field2825;
                                    }
                                 }

                                 if(var10.field2797 && var10.item != -1) {
                                    ItemComposition var46 = class174.getItemDefinition(var10.item);
                                    var60 = var46.name;
                                    if(null == var60) {
                                       var60 = "null";
                                    }

                                    if((var46.isStackable == 1 || var10.stackSize != 1) && var10.stackSize != -1) {
                                       var60 = class188.method3706(16748608) + var60 + "</col>" + " " + 'x' + XClanMember.method592(var10.stackSize);
                                    }
                                 }

                                 if(Client.field432 == var10) {
                                    Object var10000 = null;
                                    var60 = "Please wait...";
                                    var20 = var10.textColor;
                                 }

                                 if(!var10.field2797) {
                                    var60 = class8.method116(var60, var10);
                                 }

                                 var54.method4035(var60, var12, var13, var10.width, var10.height, var20, var10.field2879?0:-1, var10.field2786, var10.field2862, var10.field2886);
                              }
                           } else if(var10.type == 5) {
                              SpritePixels var55;
                              if(!var10.field2797) {
                                 var55 = var10.method3403(Player.method37(var10));
                                 if(var55 != null) {
                                    var55.method1712(var12, var13);
                                 } else if(Widget.field2796) {
                                    class32.method685(var10);
                                 }
                              } else {
                                 if(var10.item != -1) {
                                    var55 = class21.createSprite(var10.item, var10.stackSize, var10.borderThickness, var10.sprite2, var10.field2856, false);
                                 } else {
                                    var55 = var10.method3403(false);
                                 }

                                 if(var55 == null) {
                                    if(Widget.field2796) {
                                       class32.method685(var10);
                                    }
                                 } else {
                                    var20 = var55.field1439;
                                    var21 = var55.field1445;
                                    if(!var10.field2836) {
                                       var37 = var10.width * 4096 / var20;
                                       if(var10.field2835 != 0) {
                                          var55.method1763(var12 + var10.width / 2, var13 + var10.height / 2, var10.field2835, var37);
                                       } else if(var14 != 0) {
                                          var55.method1720(var12, var13, var10.width, var10.height, 256 - (var14 & 255));
                                       } else if(var10.width == var20 && var21 == var10.height) {
                                          var55.method1712(var12, var13);
                                       } else {
                                          var55.method1714(var12, var13, var10.width, var10.height);
                                       }
                                    } else {
                                       class82.method1796(var12, var13, var10.width + var12, var13 + var10.height);
                                       var37 = (var10.width + (var20 - 1)) / var20;
                                       var23 = (var10.height + (var21 - 1)) / var21;

                                       for(var24 = 0; var24 < var37; ++var24) {
                                          for(var41 = 0; var41 < var23; ++var41) {
                                             if(var10.field2835 != 0) {
                                                var55.method1763(var20 * var24 + var12 + var20 / 2, var21 / 2 + var13 + var41 * var21, var10.field2835, 4096);
                                             } else if(var14 != 0) {
                                                var55.method1705(var20 * var24 + var12, var13 + var41 * var21, 256 - (var14 & 255));
                                             } else {
                                                var55.method1712(var12 + var20 * var24, var41 * var21 + var13);
                                             }
                                          }
                                       }

                                       class82.method1795(var2, var3, var4, var5);
                                    }
                                 }
                              }
                           } else {
                              ItemComposition var39;
                              if(var10.type == 6) {
                                 boolean var45 = Player.method37(var10);
                                 if(var45) {
                                    var20 = var10.field2870;
                                 } else {
                                    var20 = var10.field2845;
                                 }

                                 Model var57 = null;
                                 var37 = 0;
                                 if(var10.item != -1) {
                                    var39 = class174.getItemDefinition(var10.item);
                                    if(var39 != null) {
                                       var39 = var39.method1086(var10.stackSize);
                                       var57 = var39.getModel(1);
                                       if(null != var57) {
                                          var57.method2275();
                                          var37 = var57.modelHeight / 2;
                                       } else {
                                          class32.method685(var10);
                                       }
                                    }
                                 } else if(var10.modelType == 5) {
                                    if(var10.modelId == 0) {
                                       var57 = Client.field541.method3497((Sequence)null, -1, (Sequence)null, -1);
                                    } else {
                                       var57 = TextureProvider.localPlayer.getModel();
                                    }
                                 } else if(var20 == -1) {
                                    var57 = var10.method3406((Sequence)null, -1, var45, TextureProvider.localPlayer.composition);
                                    if(null == var57 && Widget.field2796) {
                                       class32.method685(var10);
                                    }
                                 } else {
                                    Sequence var63 = class4.getAnimation(var20);
                                    var57 = var10.method3406(var63, var10.field2811, var45, TextureProvider.localPlayer.composition);
                                    if(null == var57 && Widget.field2796) {
                                       class32.method685(var10);
                                    }
                                 }

                                 class94.method2089(var12 + var10.width / 2, var13 + var10.height / 2);
                                 var23 = var10.field2852 * class94.field1631[var10.rotationX] >> 16;
                                 var24 = class94.field1621[var10.rotationX] * var10.field2852 >> 16;
                                 if(var57 != null) {
                                    if(!var10.field2797) {
                                       var57.method2287(0, var10.rotationZ, 0, var10.rotationX, 0, var23, var24);
                                    } else {
                                       var57.method2275();
                                       if(var10.field2855) {
                                          var57.method2281(0, var10.rotationZ, var10.rotationY, var10.rotationX, var10.field2787, var37 + var23 + var10.field2847, var10.field2847 + var24, var10.field2852);
                                       } else {
                                          var57.method2287(0, var10.rotationZ, var10.rotationY, var10.rotationX, var10.field2787, var10.field2847 + var23 + var37, var24 + var10.field2847);
                                       }
                                    }
                                 }

                                 class94.method2087();
                              } else {
                                 if(var10.type == 7) {
                                    var54 = var10.method3419();
                                    if(var54 == null) {
                                       if(Widget.field2796) {
                                          class32.method685(var10);
                                       }
                                       continue;
                                    }

                                    var20 = 0;

                                    for(var21 = 0; var21 < var10.field2791; ++var21) {
                                       for(var37 = 0; var37 < var10.field2805; ++var37) {
                                          if(var10.itemIds[var20] > 0) {
                                             var39 = class174.getItemDefinition(var10.itemIds[var20] - 1);
                                             String var40;
                                             if(var39.isStackable != 1 && var10.itemQuantities[var20] == 1) {
                                                var40 = class188.method3706(16748608) + var39.name + "</col>";
                                             } else {
                                                var40 = class188.method3706(16748608) + var39.name + "</col>" + " " + 'x' + XClanMember.method592(var10.itemQuantities[var20]);
                                             }

                                             var41 = var37 * (115 + var10.field2795) + var12;
                                             var42 = var13 + (12 + var10.field2865) * var21;
                                             if(var10.field2786 == 0) {
                                                var54.method4032(var40, var41, var42, var10.textColor, var10.field2879?0:-1);
                                             } else if(var10.field2786 == 1) {
                                                var54.method4072(var40, var41 + var10.width / 2, var42, var10.textColor, var10.field2879?0:-1);
                                             } else {
                                                var54.method4093(var40, var10.width + var41 - 1, var42, var10.textColor, var10.field2879?0:-1);
                                             }
                                          }

                                          ++var20;
                                       }
                                    }
                                 }

                                 if(var10.type == 8 && class38.field793 == var10 && Client.field419 == Client.field448) {
                                    var19 = 0;
                                    var20 = 0;
                                    class227 var38 = class218.field3204;
                                    String var22 = var10.text;

                                    String var59;
                                    for(var22 = class8.method116(var22, var10); var22.length() > 0; var20 += var38.field3238 + 1) {
                                       var24 = var22.indexOf("<br>");
                                       if(var24 != -1) {
                                          var59 = var22.substring(0, var24);
                                          var22 = var22.substring(4 + var24);
                                       } else {
                                          var59 = var22;
                                          var22 = "";
                                       }

                                       var41 = var38.method4027(var59);
                                       if(var41 > var19) {
                                          var19 = var41;
                                       }
                                    }

                                    var19 += 6;
                                    var20 += 7;
                                    var24 = var10.width + var12 - 5 - var19;
                                    var41 = 5 + var10.height + var13;
                                    if(var24 < 5 + var12) {
                                       var24 = 5 + var12;
                                    }

                                    if(var19 + var24 > var4) {
                                       var24 = var4 - var19;
                                    }

                                    if(var20 + var41 > var5) {
                                       var41 = var5 - var20;
                                    }

                                    class82.method1801(var24, var41, var19, var20, 16777120);
                                    class82.method1815(var24, var41, var19, var20, 0);
                                    var22 = var10.text;
                                    var42 = 2 + var41 + var38.field3238;

                                    for(var22 = class8.method116(var22, var10); var22.length() > 0; var42 += 1 + var38.field3238) {
                                       var27 = var22.indexOf("<br>");
                                       if(var27 != -1) {
                                          var59 = var22.substring(0, var27);
                                          var22 = var22.substring(var27 + 4);
                                       } else {
                                          var59 = var22;
                                          var22 = "";
                                       }

                                       var38.method4032(var59, var24 + 3, var42, 0, -1);
                                    }
                                 }

                                 if(var10.type == 9) {
                                    if(var10.field2831 == 1) {
                                       if(var10.field2878) {
                                          var19 = var12;
                                          var20 = var13 + var10.height;
                                          var21 = var12 + var10.width;
                                          var37 = var13;
                                       } else {
                                          var19 = var12;
                                          var20 = var13;
                                          var21 = var10.width + var12;
                                          var37 = var13 + var10.height;
                                       }

                                       class82.method1813(var19, var20, var21, var37, var10.textColor);
                                    } else {
                                       var19 = var10.width >= 0?var10.width:-var10.width;
                                       var20 = var10.height >= 0?var10.height:-var10.height;
                                       var21 = var19;
                                       if(var19 < var20) {
                                          var21 = var20;
                                       }

                                       if(var21 != 0) {
                                          var37 = (var10.width << 16) / var21;
                                          var23 = (var10.height << 16) / var21;
                                          if(var23 <= var37) {
                                             var37 = -var37;
                                          } else {
                                             var23 = -var23;
                                          }

                                          var24 = var23 * var10.field2831 >> 17;
                                          var41 = 1 + var10.field2831 * var23 >> 17;
                                          var42 = var10.field2831 * var37 >> 17;
                                          var27 = 1 + var10.field2831 * var37 >> 17;
                                          var28 = var12 + var24;
                                          var29 = var12 - var41;
                                          int var30 = var10.width + var12 - var41;
                                          var31 = var12 + var10.width + var24;
                                          int var32 = var13 + var42;
                                          int var33 = var13 - var27;
                                          int var34 = var10.height + var13 - var27;
                                          int var35 = var10.height + var13 + var42;
                                          class94.setRasterClippingEnabled(var28, var29, var30);
                                          class94.rasterFlat(var32, var33, var34, var28, var29, var30, var10.textColor);
                                          class94.setRasterClippingEnabled(var28, var30, var31);
                                          class94.rasterFlat(var32, var34, var35, var28, var30, var31, var10.textColor);
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
}
