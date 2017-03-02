import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cz")
public final class class85 {
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 1060105437
   )
   int field1437;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 2141442631
   )
   int field1438;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 1002695987
   )
   int field1440;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -46681377
   )
   int field1441;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 204173523
   )
   int field1442;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 1621079327
   )
   int field1443;
   @ObfuscatedName("r")
   static int[] field1444;
   @ObfuscatedName("qp")
   @ObfuscatedGetter(
      intValue = -956623985
   )
   protected static int field1445;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 1669388431
   )
   public static int field1446;
   @ObfuscatedName("rs")
   protected static boolean field1447;
   @ObfuscatedName("h")
   boolean field1448 = true;

   @ObfuscatedSignature(
      signature = "(IIIIIIZ)V",
      garbageValue = "0"
   )
   class85(int var1, int var2, int var3, int var4, int var5, int var6, boolean var7) {
      this.field1442 = var1;
      this.field1438 = var2;
      this.field1443 = var3;
      this.field1440 = var4;
      this.field1441 = var5;
      this.field1437 = var6;
      this.field1448 = var7;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(IB)Ljava/lang/String;",
      garbageValue = "10"
   )
   static final String method1751(int var0) {
      return var0 < 100000?"<col=ffff00>" + var0 + "</col>":(var0 < 10000000?"<col=ffffff>" + var0 / 1000 + "K" + "</col>":"<col=00ff80>" + var0 / 1000000 + "M" + "</col>");
   }

   @ObfuscatedName("cc")
   @ObfuscatedSignature(
      signature = "([LWidget;IIIIIIIIB)V",
      garbageValue = "-87"
   )
   @Export("gameDraw")
   static final void gameDraw(Widget[] var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
      Rasterizer2D.method4124(var2, var3, var4, var5);
      class84.method1695();

      for(int var9 = 0; var9 < var0.length; ++var9) {
         Widget var10 = var0[var9];
         if(var10 != null && (var10.parentId == var1 || var1 == -1412584499 && var10 == Client.field458)) {
            int var11;
            if(var8 == -1) {
               Client.widgetPositionX[Client.field544] = var6 + var10.relativeX;
               Client.widgetPositionY[Client.field544] = var10.relativeY + var7;
               Client.widgetBoundsWidth[Client.field544] = var10.width;
               Client.widgetBoundsHeight[Client.field544] = var10.height;
               var11 = ++Client.field544 - 1;
            } else {
               var11 = var8;
            }

            var10.boundsIndex = var11;
            var10.field2328 = Client.gameCycle;
            if(!var10.hasScript || !Client.method611(var10)) {
               if(var10.contentType > 0) {
                  Frames.method1959(var10);
               }

               int var12 = var10.relativeX + var6;
               int var13 = var10.relativeY + var7;
               int var14 = var10.opacity;
               int var15;
               int var16;
               if(Client.field458 == var10) {
                  if(var1 != -1412584499 && !var10.field2274) {
                     class94.field1589 = var0;
                     class160.field2133 = var6;
                     class40.field813 = var7;
                     continue;
                  }

                  if(Client.field469 && Client.field463) {
                     var15 = class115.field1802;
                     var16 = class115.field1801;
                     var15 -= Client.field460;
                     var16 -= Client.field461;
                     if(var15 < Client.field506) {
                        var15 = Client.field506;
                     }

                     if(var15 + var10.width > Client.field506 + Client.field459.width) {
                        var15 = Client.field506 + Client.field459.width - var10.width;
                     }

                     if(var16 < Client.field465) {
                        var16 = Client.field465;
                     }

                     if(var10.height + var16 > Client.field459.height + Client.field465) {
                        var16 = Client.field465 + Client.field459.height - var10.height;
                     }

                     var12 = var15;
                     var13 = var16;
                  }

                  if(!var10.field2274) {
                     var14 = 128;
                  }
               }

               int var17;
               int var18;
               int var19;
               int var20;
               int var21;
               int var22;
               if(var10.type == 2) {
                  var15 = var2;
                  var16 = var3;
                  var17 = var4;
                  var18 = var5;
               } else if(var10.type == 9) {
                  var19 = var12;
                  var20 = var13;
                  var21 = var10.width + var12;
                  var22 = var10.height + var13;
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
                  var19 = var10.width + var12;
                  var20 = var10.height + var13;
                  var15 = var12 > var2?var12:var2;
                  var16 = var13 > var3?var13:var3;
                  var17 = var19 < var4?var19:var4;
                  var18 = var20 < var5?var20:var5;
               }

               if(!var10.hasScript || var15 < var17 && var16 < var18) {
                  int var23;
                  int var24;
                  int var27;
                  int var28;
                  int var29;
                  int var30;
                  int var31;
                  int var32;
                  int var33;
                  int var34;
                  int var35;
                  int var47;
                  int var52;
                  if(var10.contentType != 0) {
                     if(var10.contentType == 1336) {
                        if(Client.field298) {
                           var13 += 15;
                           XItemContainer.field119.method3965("Fps:" + GameEngine.FPS, var10.width + var12, var13, 16776960, -1);
                           var13 += 15;
                           Runtime var75 = Runtime.getRuntime();
                           var20 = (int)((var75.totalMemory() - var75.freeMemory()) / 1024L);
                           var21 = 16776960;
                           if(var20 > '耀' && Client.field404) {
                              var21 = 16711680;
                           }

                           if(var20 > 65536 && !Client.field404) {
                              var21 = 16711680;
                           }

                           XItemContainer.field119.method3965("Mem:" + var20 + "k", var10.width + var12, var13, var21, -1);
                           var13 += 15;
                        }
                        continue;
                     }

                     if(var10.contentType == 1337) {
                        Client.field434 = var12;
                        Client.field487 = var13;
                        var21 = var10.width;
                        var22 = var10.height;
                        ++Client.field543;
                        ScriptState.method166(class15.field161);
                        boolean var64 = false;
                        if(Client.field414 >= 0) {
                           var24 = class45.field907;
                           int[] var62 = class45.field900;

                           for(var47 = 0; var47 < var24; ++var47) {
                              if(Client.field414 == var62[var47]) {
                                 var64 = true;
                                 break;
                              }
                           }
                        }

                        if(var64) {
                           ScriptState.method166(class15.field155);
                        }

                        class13.method182(true);
                        ScriptState.method166(var64?class15.field160:class15.field156);
                        class13.method182(false);
                        Player.method245();
                        class212.method4061();
                        class103.method2025(var12, var13, var21, var22, true);
                        var19 = Client.field316;
                        var20 = Client.field548;
                        var21 = Client.camera2;
                        var22 = Client.camera3;
                        Rasterizer2D.method4124(var19, var20, var19 + var21, var20 + var22);
                        class84.method1695();
                        if(!Client.field332) {
                           var24 = Client.field368;
                           if(Client.field377 / 256 > var24) {
                              var24 = Client.field377 / 256;
                           }

                           if(Client.field478[4] && 128 + Client.field303[4] > var24) {
                              var24 = 128 + Client.field303[4];
                           }

                           var52 = Client.mapAngle + Client.field353 & 2047;
                           class104.method2049(Overlay.field3057, class65.method1224(class9.localPlayer.x, class9.localPlayer.y, class156.plane) - Client.field374, class40.field812, var24, var52, 600 + 3 * var24);
                        }

                        if(!Client.field332) {
                           if(WallObject.field1551.field689) {
                              var52 = class156.plane;
                           } else {
                              label1930: {
                                 var47 = 3;
                                 if(FaceNormal.cameraPitch < 310) {
                                    var27 = class206.cameraX >> 7;
                                    var28 = class22.cameraY >> 7;
                                    var29 = class9.localPlayer.x >> 7;
                                    var30 = class9.localPlayer.y >> 7;
                                    if(var27 < 0 || var28 < 0 || var27 >= 104 || var28 >= 104) {
                                       var52 = class156.plane;
                                       break label1930;
                                    }

                                    if((class10.tileSettings[class156.plane][var27][var28] & 4) != 0) {
                                       var47 = class156.plane;
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

                                          if((class10.tileSettings[class156.plane][var27][var28] & 4) != 0) {
                                             var47 = class156.plane;
                                          }

                                          var34 += var33;
                                          if(var34 >= 65536) {
                                             var34 -= 65536;
                                             if(var28 < var30) {
                                                ++var28;
                                             } else if(var28 > var30) {
                                                --var28;
                                             }

                                             if((class10.tileSettings[class156.plane][var27][var28] & 4) != 0) {
                                                var47 = class156.plane;
                                             }
                                          }
                                       }
                                    } else {
                                       var33 = 65536 * var31 / var32;
                                       var34 = '耀';

                                       while(var30 != var28) {
                                          if(var28 < var30) {
                                             ++var28;
                                          } else if(var28 > var30) {
                                             --var28;
                                          }

                                          if((class10.tileSettings[class156.plane][var27][var28] & 4) != 0) {
                                             var47 = class156.plane;
                                          }

                                          var34 += var33;
                                          if(var34 >= 65536) {
                                             var34 -= 65536;
                                             if(var27 < var29) {
                                                ++var27;
                                             } else if(var27 > var29) {
                                                --var27;
                                             }

                                             if((class10.tileSettings[class156.plane][var27][var28] & 4) != 0) {
                                                var47 = class156.plane;
                                             }
                                          }
                                       }
                                    }
                                 }

                                 if(class9.localPlayer.x >= 0 && class9.localPlayer.y >= 0 && class9.localPlayer.x < 13312 && class9.localPlayer.y < 13312) {
                                    if((class10.tileSettings[class156.plane][class9.localPlayer.x >> 7][class9.localPlayer.y >> 7] & 4) != 0) {
                                       var47 = class156.plane;
                                    }

                                    var52 = var47;
                                 } else {
                                    var52 = class156.plane;
                                 }
                              }
                           }

                           var24 = var52;
                        } else {
                           var24 = class72.method1460();
                        }

                        var52 = class206.cameraX;
                        var47 = class112.cameraZ;
                        var27 = class22.cameraY;
                        var28 = FaceNormal.cameraPitch;
                        var29 = Friend.cameraYaw;

                        for(var30 = 0; var30 < 5; ++var30) {
                           if(Client.field478[var30]) {
                              var31 = (int)(Math.random() * (double)(2 * Client.field535[var30] + 1) - (double)Client.field535[var30] + Math.sin((double)Client.field537[var30] / 100.0D * (double)Client.field538[var30]) * (double)Client.field303[var30]);
                              if(var30 == 0) {
                                 class206.cameraX += var31;
                              }

                              if(var30 == 1) {
                                 class112.cameraZ += var31;
                              }

                              if(var30 == 2) {
                                 class22.cameraY += var31;
                              }

                              if(var30 == 3) {
                                 Friend.cameraYaw = var31 + Friend.cameraYaw & 2047;
                              }

                              if(var30 == 4) {
                                 FaceNormal.cameraPitch += var31;
                                 if(FaceNormal.cameraPitch < 128) {
                                    FaceNormal.cameraPitch = 128;
                                 }

                                 if(FaceNormal.cameraPitch > 383) {
                                    FaceNormal.cameraPitch = 383;
                                 }
                              }
                           }
                        }

                        var30 = class115.field1802;
                        var31 = class115.field1801;
                        if(class115.field1796 != 0) {
                           var30 = class115.field1808;
                           var31 = class115.field1798;
                        }

                        if(var30 >= var19 && var30 < var21 + var19 && var31 >= var20 && var31 < var22 + var20) {
                           Model.field1391 = true;
                           Model.field1394 = 0;
                           Model.field1392 = var30 - var19;
                           Model.field1393 = var31 - var20;
                        } else {
                           Model.field1391 = false;
                           Model.field1394 = 0;
                        }

                        class22.method224();
                        Rasterizer2D.method4099(var19, var20, var21, var22, 0);
                        class22.method224();
                        var32 = class84.field1421;
                        class84.field1421 = Client.scale;
                        Varbit.region.method1814(class206.cameraX, class112.cameraZ, class22.cameraY, FaceNormal.cameraPitch, Friend.cameraYaw, var24);
                        class84.field1421 = var32;
                        class22.method224();
                        Varbit.region.method1770();
                        Client.field445 = 0;
                        boolean var68 = false;
                        var34 = -1;
                        var35 = class45.field907;
                        int[] var36 = class45.field900;

                        int var37;
                        for(var37 = 0; var37 < Client.field323 + var35; ++var37) {
                           Object var38;
                           if(var37 < var35) {
                              var38 = Client.cachedPlayers[var36[var37]];
                              if(var36[var37] == Client.field414) {
                                 var68 = true;
                                 var34 = var37;
                                 continue;
                              }
                           } else {
                              var38 = Client.cachedNPCs[Client.field324[var37 - var35]];
                           }

                           class213.method4062((Actor)var38, var37, var19, var20, var21, var22);
                        }

                        if(var68) {
                           class213.method4062(Client.cachedPlayers[Client.field414], var34, var19, var20, var21, var22);
                        }

                        for(var37 = 0; var37 < Client.field445; ++var37) {
                           int var57 = Client.field380[var37];
                           int var39 = Client.field291[var37];
                           int var40 = Client.field383[var37];
                           int var41 = Client.field382[var37];
                           boolean var42 = true;

                           while(var42) {
                              var42 = false;

                              for(int var43 = 0; var43 < var37; ++var43) {
                                 if(2 + var39 > Client.field291[var43] - Client.field382[var43] && var39 - var41 < 2 + Client.field291[var43] && var57 - var40 < Client.field380[var43] + Client.field383[var43] && var57 + var40 > Client.field380[var43] - Client.field383[var43] && Client.field291[var43] - Client.field382[var43] < var39) {
                                    var39 = Client.field291[var43] - Client.field382[var43];
                                    var42 = true;
                                 }
                              }
                           }

                           Client.field390 = Client.field380[var37];
                           Client.field391 = Client.field291[var37] = var39;
                           String var53 = Client.field488[var37];
                           if(Client.field447 == 0) {
                              int var44 = 16776960;
                              if(Client.field384[var37] < 6) {
                                 var44 = Client.field305[Client.field384[var37]];
                              }

                              if(Client.field384[var37] == 6) {
                                 var44 = Client.field543 % 20 < 10?16711680:16776960;
                              }

                              if(Client.field384[var37] == 7) {
                                 var44 = Client.field543 % 20 < 10?255:'\uffff';
                              }

                              if(Client.field384[var37] == 8) {
                                 var44 = Client.field543 % 20 < 10?'뀀':8454016;
                              }

                              int var45;
                              if(Client.field384[var37] == 9) {
                                 var45 = 150 - Client.field545[var37];
                                 if(var45 < 50) {
                                    var44 = 16711680 + 1280 * var45;
                                 } else if(var45 < 100) {
                                    var44 = 16776960 - 327680 * (var45 - 50);
                                 } else if(var45 < 150) {
                                    var44 = 5 * (var45 - 100) + '\uff00';
                                 }
                              }

                              if(Client.field384[var37] == 10) {
                                 var45 = 150 - Client.field545[var37];
                                 if(var45 < 50) {
                                    var44 = var45 * 5 + 16711680;
                                 } else if(var45 < 100) {
                                    var44 = 16711935 - (var45 - 50) * 327680;
                                 } else if(var45 < 150) {
                                    var44 = (var45 - 100) * 327680 + 255 - (var45 - 100) * 5;
                                 }
                              }

                              if(Client.field384[var37] == 11) {
                                 var45 = 150 - Client.field545[var37];
                                 if(var45 < 50) {
                                    var44 = 16777215 - 327685 * var45;
                                 } else if(var45 < 100) {
                                    var44 = '\uff00' + (var45 - 50) * 327685;
                                 } else if(var45 < 150) {
                                    var44 = 16777215 - 327680 * (var45 - 100);
                                 }
                              }

                              if(Client.field417[var37] == 0) {
                                 class16.field170.method4006(var53, var19 + Client.field390, var20 + Client.field391, var44, 0);
                              }

                              if(Client.field417[var37] == 1) {
                                 class16.field170.method4040(var53, Client.field390 + var19, Client.field391 + var20, var44, 0, Client.field543);
                              }

                              if(Client.field417[var37] == 2) {
                                 class16.field170.method3990(var53, var19 + Client.field390, Client.field391 + var20, var44, 0, Client.field543);
                              }

                              if(Client.field417[var37] == 3) {
                                 class16.field170.method4020(var53, var19 + Client.field390, Client.field391 + var20, var44, 0, Client.field543, 150 - Client.field545[var37]);
                              }

                              if(Client.field417[var37] == 4) {
                                 var45 = (150 - Client.field545[var37]) * (class16.field170.method3969(var53) + 100) / 150;
                                 Rasterizer2D.method4093(Client.field390 + var19 - 50, var20, Client.field390 + var19 + 50, var22 + var20);
                                 class16.field170.method3974(var53, Client.field390 + var19 + 50 - var45, Client.field391 + var20, var44, 0);
                                 Rasterizer2D.method4124(var19, var20, var19 + var21, var20 + var22);
                              }

                              if(Client.field417[var37] == 5) {
                                 var45 = 150 - Client.field545[var37];
                                 int var46 = 0;
                                 if(var45 < 25) {
                                    var46 = var45 - 25;
                                 } else if(var45 > 125) {
                                    var46 = var45 - 125;
                                 }

                                 Rasterizer2D.method4093(var19, Client.field391 + var20 - class16.field170.field3104 - 1, var19 + var21, 5 + var20 + Client.field391);
                                 class16.field170.method4006(var53, Client.field390 + var19, var20 + Client.field391 + var46, var44, 0);
                                 Rasterizer2D.method4124(var19, var20, var19 + var21, var20 + var22);
                              }
                           } else {
                              class16.field170.method4006(var53, Client.field390 + var19, var20 + Client.field391, 16776960, 0);
                           }
                        }

                        if(Client.field300 == 2) {
                           ItemLayer.method1516(Client.field306 + (Client.field536 - MessageNode.baseX << 7), Client.field307 + (Client.field315 - class2.baseY << 7), Client.field387 * 2);
                           if(Client.field390 > -1 && Client.gameCycle % 20 < 10) {
                              class164.field2152[0].method4284(Client.field390 + var19 - 12, var20 + Client.field391 - 28);
                           }
                        }

                        ((TextureProvider)class84.field1415).method1496(Client.field477);
                        if(Client.field326 == 1) {
                           ScriptState.field115[Client.field394 / 100].method4284(Client.field392 - 8, Client.field524 - 8);
                        }

                        if(Client.field326 == 2) {
                           ScriptState.field115[Client.field394 / 100 + 4].method4284(Client.field392 - 8, Client.field524 - 8);
                        }

                        Client.field336 = 0;
                        var33 = (class9.localPlayer.x >> 7) + MessageNode.baseX;
                        var34 = (class9.localPlayer.y >> 7) + class2.baseY;
                        if(var33 >= 3053 && var33 <= 3156 && var34 >= 3056 && var34 <= 3136) {
                           Client.field336 = 1;
                        }

                        if(var33 >= 3072 && var33 <= 3118 && var34 >= 9492 && var34 <= 9535) {
                           Client.field336 = 1;
                        }

                        if(Client.field336 == 1 && var33 >= 3139 && var33 <= 3199 && var34 >= 3008 && var34 <= 3062) {
                           Client.field336 = 0;
                        }

                        class206.cameraX = var52;
                        class112.cameraZ = var47;
                        class22.cameraY = var27;
                        FaceNormal.cameraPitch = var28;
                        Friend.cameraYaw = var29;
                        if(Client.field547 && class103.method2040(true, false) == 0) {
                           Client.field547 = false;
                        }

                        if(Client.field547) {
                           Rasterizer2D.method4099(var19, var20, var21, var22, 0);
                           XGrandExchangeOffer.method65("Loading - please wait.", false);
                        }

                        Client.field490[var10.boundsIndex] = true;
                        Rasterizer2D.method4124(var2, var3, var4, var5);
                        continue;
                     }

                     class164 var73;
                     if(var10.contentType == 1338) {
                        class22.method224();
                        var73 = var10.method3293(false);
                        if(null != var73) {
                           Rasterizer2D.method4124(var12, var13, var12 + var73.field2148, var13 + var73.field2146);
                           if(Client.field558 != 2 && Client.field558 != 5) {
                              var20 = Client.mapScale + Client.mapAngle & 2047;
                              var21 = 48 + class9.localPlayer.x / 32;
                              var22 = 464 - class9.localPlayer.y / 32;
                              class148.field2025.method4265(var12, var13, var73.field2148, var73.field2146, var21, var22, var20, 256 + Client.mapScaleDelta, var73.field2149, var73.field2145);

                              for(var23 = 0; var23 < Client.field515; ++var23) {
                                 var24 = Client.field516[var23] * 4 + 2 - class9.localPlayer.x / 32;
                                 var52 = Client.field517[var23] * 4 + 2 - class9.localPlayer.y / 32;
                                 FrameMap.method1754(var12, var13, var24, var52, Client.field518[var23], var73);
                              }

                              var23 = 0;

                              while(true) {
                                 if(var23 >= 104) {
                                    for(var23 = 0; var23 < Client.field323; ++var23) {
                                       NPC var76 = Client.cachedNPCs[Client.field324[var23]];
                                       if(var76 != null && var76.vmethod795()) {
                                          NPCComposition var59 = var76.composition;
                                          if(var59 != null && null != var59.configs) {
                                             var59 = var59.method3807();
                                          }

                                          if(null != var59 && var59.isMinimapVisible && var59.field3039) {
                                             var47 = var76.x / 32 - class9.localPlayer.x / 32;
                                             var27 = var76.y / 32 - class9.localPlayer.y / 32;
                                             FrameMap.method1754(var12, var13, var47, var27, GroundObject.field1283[1], var73);
                                          }
                                       }
                                    }

                                    var23 = class45.field907;
                                    int[] var77 = class45.field900;

                                    for(var52 = 0; var52 < var23; ++var52) {
                                       Player var26 = Client.cachedPlayers[var77[var52]];
                                       if(var26 != null && var26.vmethod795() && !var26.field259 && var26 != class9.localPlayer) {
                                          var27 = var26.x / 32 - class9.localPlayer.x / 32;
                                          var28 = var26.y / 32 - class9.localPlayer.y / 32;
                                          boolean var67 = false;
                                          if(ChatLineBuffer.method983(var26.name, true)) {
                                             var67 = true;
                                          }

                                          boolean var65 = false;

                                          for(var31 = 0; var31 < class1.clanChatCount; ++var31) {
                                             if(var26.name.equals(ObjectComposition.clanMembers[var31].username)) {
                                                var65 = true;
                                                break;
                                             }
                                          }

                                          boolean var66 = false;
                                          if(class9.localPlayer.team != 0 && var26.team != 0 && class9.localPlayer.team == var26.team) {
                                             var66 = true;
                                          }

                                          if(var67) {
                                             FrameMap.method1754(var12, var13, var27, var28, GroundObject.field1283[3], var73);
                                          } else if(var66) {
                                             FrameMap.method1754(var12, var13, var27, var28, GroundObject.field1283[4], var73);
                                          } else if(var65) {
                                             FrameMap.method1754(var12, var13, var27, var28, GroundObject.field1283[5], var73);
                                          } else {
                                             FrameMap.method1754(var12, var13, var27, var28, GroundObject.field1283[2], var73);
                                          }
                                       }
                                    }

                                    if(Client.field300 != 0 && Client.gameCycle % 20 < 10) {
                                       if(Client.field300 == 1 && Client.field301 >= 0 && Client.field301 < Client.cachedNPCs.length) {
                                          NPC var60 = Client.cachedNPCs[Client.field301];
                                          if(var60 != null) {
                                             var47 = var60.x / 32 - class9.localPlayer.x / 32;
                                             var27 = var60.y / 32 - class9.localPlayer.y / 32;
                                             Player.method228(var12, var13, var47, var27, class72.field1171[1], var73);
                                          }
                                       }

                                       if(Client.field300 == 2) {
                                          var52 = Client.field536 * 4 - MessageNode.baseX * 4 + 2 - class9.localPlayer.x / 32;
                                          var47 = Client.field315 * 4 - class2.baseY * 4 + 2 - class9.localPlayer.y / 32;
                                          Player.method228(var12, var13, var52, var47, class72.field1171[1], var73);
                                       }

                                       if(Client.field300 == 10 && Client.field311 >= 0 && Client.field311 < Client.cachedPlayers.length) {
                                          Player var61 = Client.cachedPlayers[Client.field311];
                                          if(null != var61) {
                                             var47 = var61.x / 32 - class9.localPlayer.x / 32;
                                             var27 = var61.y / 32 - class9.localPlayer.y / 32;
                                             Player.method228(var12, var13, var47, var27, class72.field1171[1], var73);
                                          }
                                       }
                                    }

                                    if(Client.flagX != 0) {
                                       var52 = 2 + Client.flagX * 4 - class9.localPlayer.x / 32;
                                       var47 = 2 + Client.flagY * 4 - class9.localPlayer.y / 32;
                                       FrameMap.method1754(var12, var13, var52, var47, class72.field1171[0], var73);
                                    }

                                    if(!class9.localPlayer.field259) {
                                       Rasterizer2D.method4099(var12 + var73.field2148 / 2 - 1, var13 + var73.field2146 / 2 - 1, 3, 3, 16777215);
                                    }
                                    break;
                                 }

                                 for(var24 = 0; var24 < 104; ++var24) {
                                    Deque var25 = Client.groundItemDeque[class156.plane][var23][var24];
                                    if(var25 != null) {
                                       var47 = var23 * 4 + 2 - class9.localPlayer.x / 32;
                                       var27 = var24 * 4 + 2 - class9.localPlayer.y / 32;
                                       FrameMap.method1754(var12, var13, var47, var27, GroundObject.field1283[0], var73);
                                    }
                                 }

                                 ++var23;
                              }
                           } else {
                              Rasterizer2D.method4111(var12, var13, 0, var73.field2149, var73.field2145);
                           }

                           Client.field386[var11] = true;
                        }

                        Rasterizer2D.method4124(var2, var3, var4, var5);
                        continue;
                     }

                     if(var10.contentType == 1339) {
                        var73 = var10.method3293(false);
                        if(null != var73) {
                           if(Client.field558 < 3) {
                              class94.field1588.method4265(var12, var13, var73.field2148, var73.field2146, 25, 25, Client.mapAngle, 256, var73.field2149, var73.field2145);
                           } else {
                              Rasterizer2D.method4111(var12, var13, 0, var73.field2149, var73.field2145);
                           }
                        }

                        Rasterizer2D.method4124(var2, var3, var4, var5);
                        continue;
                     }
                  }

                  if(var10.type == 0) {
                     if(!var10.hasScript && Client.method611(var10) && class45.field896 != var10) {
                        continue;
                     }

                     if(!var10.hasScript) {
                        if(var10.scrollY > var10.scrollHeight - var10.height) {
                           var10.scrollY = var10.scrollHeight - var10.height;
                        }

                        if(var10.scrollY < 0) {
                           var10.scrollY = 0;
                        }
                     }

                     gameDraw(var0, var10.id, var15, var16, var17, var18, var12 - var10.scrollX, var13 - var10.scrollY, var11);
                     if(var10.children != null) {
                        gameDraw(var10.children, var10.id, var15, var16, var17, var18, var12 - var10.scrollX, var13 - var10.scrollY, var11);
                     }

                     WidgetNode var50 = (WidgetNode)Client.componentTable.method2428((long)var10.id);
                     if(null != var50) {
                        class172.method3325(var50.id, var15, var16, var17, var18, var12, var13, var11);
                     }

                     Rasterizer2D.method4124(var2, var3, var4, var5);
                     class84.method1695();
                  }

                  if(Client.isResized || Client.field492[var11] || Client.field497 > 1) {
                     if(var10.type == 0 && !var10.hasScript && var10.scrollHeight > var10.height) {
                        class32.method755(var12 + var10.width, var13, var10.scrollY, var10.height, var10.scrollHeight);
                     }

                     if(var10.type != 1) {
                        if(var10.type == 2) {
                           var19 = 0;

                           for(var20 = 0; var20 < var10.field2208; ++var20) {
                              for(var21 = 0; var21 < var10.originalWidth; ++var21) {
                                 var22 = var12 + (var10.field2259 + 32) * var21;
                                 var23 = var13 + (32 + var10.field2313) * var20;
                                 if(var19 < 20) {
                                    var22 += var10.field2264[var19];
                                    var23 += var10.field2319[var19];
                                 }

                                 if(var10.itemIds[var19] <= 0) {
                                    if(var10.field2266 != null && var19 < 20) {
                                       SpritePixels var74 = var10.method3268(var19);
                                       if(var74 != null) {
                                          var74.method4284(var22, var23);
                                       } else if(Widget.field2195) {
                                          Frames.method1960(var10);
                                       }
                                    }
                                 } else {
                                    boolean var63 = false;
                                    boolean var79 = false;
                                    var47 = var10.itemIds[var19] - 1;
                                    if(var22 + 32 > var2 && var22 < var4 && 32 + var23 > var3 && var23 < var5 || var10 == class5.field50 && Client.field398 == var19) {
                                       SpritePixels var48;
                                       if(Client.field438 == 1 && var19 == class109.field1732 && var10.id == XGrandExchangeOffer.field42) {
                                          var48 = class175.createSprite(var47, var10.itemQuantities[var19], 2, 0, 2, false);
                                       } else {
                                          var48 = class175.createSprite(var47, var10.itemQuantities[var19], 1, 3153952, 2, false);
                                       }

                                       if(null != var48) {
                                          if(var10 == class5.field50 && Client.field398 == var19) {
                                             var24 = class115.field1802 - Client.field399;
                                             var52 = class115.field1801 - Client.field491;
                                             if(var24 < 5 && var24 > -5) {
                                                var24 = 0;
                                             }

                                             if(var52 < 5 && var52 > -5) {
                                                var52 = 0;
                                             }

                                             if(Client.field403 < 5) {
                                                var24 = 0;
                                                var52 = 0;
                                             }

                                             var48.method4271(var22 + var24, var23 + var52, 128);
                                             if(var1 != -1) {
                                                Widget var56 = var0[var1 & '\uffff'];
                                                if(var23 + var52 < Rasterizer2D.field3187 && var56.scrollY > 0) {
                                                   var29 = (Rasterizer2D.field3187 - var23 - var52) * Client.field477 / 3;
                                                   if(var29 > Client.field477 * 10) {
                                                      var29 = Client.field477 * 10;
                                                   }

                                                   if(var29 > var56.scrollY) {
                                                      var29 = var56.scrollY;
                                                   }

                                                   var56.scrollY -= var29;
                                                   Client.field491 += var29;
                                                   Frames.method1960(var56);
                                                }

                                                if(var23 + var52 + 32 > Rasterizer2D.field3182 && var56.scrollY < var56.scrollHeight - var56.height) {
                                                   var29 = (var52 + var23 + 32 - Rasterizer2D.field3182) * Client.field477 / 3;
                                                   if(var29 > Client.field477 * 10) {
                                                      var29 = Client.field477 * 10;
                                                   }

                                                   if(var29 > var56.scrollHeight - var56.height - var56.scrollY) {
                                                      var29 = var56.scrollHeight - var56.height - var56.scrollY;
                                                   }

                                                   var56.scrollY += var29;
                                                   Client.field491 -= var29;
                                                   Frames.method1960(var56);
                                                }
                                             }
                                          } else if(var10 == class101.field1644 && Client.field308 == var19) {
                                             var48.method4271(var22, var23, 128);
                                          } else {
                                             var48.method4284(var22, var23);
                                          }
                                       } else {
                                          Frames.method1960(var10);
                                       }
                                    }
                                 }

                                 ++var19;
                              }
                           }
                        } else if(var10.type == 3) {
                           if(class175.method3328(var10)) {
                              var19 = var10.field2222;
                              if(class45.field896 == var10 && var10.field2310 != 0) {
                                 var19 = var10.field2310;
                              }
                           } else {
                              var19 = var10.textColor;
                              if(class45.field896 == var10 && var10.field2223 != 0) {
                                 var19 = var10.field2223;
                              }
                           }

                           if(var10.field2225) {
                              switch(var10.field2329.field3196) {
                              case 1:
                                 Rasterizer2D.method4106(var12, var13, var10.width, var10.height, var10.textColor, var10.field2222, 256 - (var10.opacity & 255), 256 - (var10.field2228 & 255));
                                 break;
                              case 2:
                                 Rasterizer2D.method4100(var12, var13, var10.width, var10.height, var10.textColor, var10.field2222, 256 - (var10.opacity & 255), 256 - (var10.field2228 & 255));
                                 break;
                              case 3:
                                 Rasterizer2D.method4101(var12, var13, var10.width, var10.height, var10.textColor, var10.field2222, 256 - (var10.opacity & 255), 256 - (var10.field2228 & 255));
                                 break;
                              case 4:
                                 Rasterizer2D.method4102(var12, var13, var10.width, var10.height, var10.textColor, var10.field2222, 256 - (var10.opacity & 255), 256 - (var10.field2228 & 255));
                                 break;
                              default:
                                 if(var14 == 0) {
                                    Rasterizer2D.method4099(var12, var13, var10.width, var10.height, var19);
                                 } else {
                                    Rasterizer2D.method4107(var12, var13, var10.width, var10.height, var19, 256 - (var14 & 255));
                                 }
                              }
                           } else if(var14 == 0) {
                              Rasterizer2D.method4104(var12, var13, var10.width, var10.height, var19);
                           } else {
                              Rasterizer2D.method4098(var12, var13, var10.width, var10.height, var19, 256 - (var14 & 255));
                           }
                        } else {
                           Font var70;
                           if(var10.type == 4) {
                              var70 = var10.method3285();
                              if(var70 == null) {
                                 if(Widget.field2195) {
                                    Frames.method1960(var10);
                                 }
                              } else {
                                 String var72 = var10.text;
                                 if(class175.method3328(var10)) {
                                    var20 = var10.field2222;
                                    if(var10 == class45.field896 && var10.field2310 != 0) {
                                       var20 = var10.field2310;
                                    }

                                    if(var10.field2257.length() > 0) {
                                       var72 = var10.field2257;
                                    }
                                 } else {
                                    var20 = var10.textColor;
                                    if(var10 == class45.field896 && var10.field2223 != 0) {
                                       var20 = var10.field2223;
                                    }
                                 }

                                 if(var10.hasScript && var10.item != -1) {
                                    ItemComposition var81 = class168.getItemDefinition(var10.item);
                                    var72 = var81.name;
                                    if(var72 == null) {
                                       var72 = "null";
                                    }

                                    if((var81.isStackable == 1 || var10.stackSize != 1) && var10.stackSize != -1) {
                                       var72 = class187.method3515(16748608) + var72 + "</col>" + " " + 'x' + Buffer.method3071(var10.stackSize);
                                    }
                                 }

                                 if(Client.field546 == var10) {
                                    Object var10000 = null;
                                    var72 = "Please wait...";
                                    var20 = var10.textColor;
                                 }

                                 if(!var10.hasScript) {
                                    var72 = XItemContainer.method167(var72, var10);
                                 }

                                 var70.method4042(var72, var12, var13, var10.width, var10.height, var20, var10.field2261?0:-1, var10.field2236, var10.field2260, var10.field2283);
                              }
                           } else if(var10.type == 5) {
                              SpritePixels var71;
                              if(!var10.hasScript) {
                                 var71 = var10.method3266(class175.method3328(var10));
                                 if(null != var71) {
                                    var71.method4284(var12, var13);
                                 } else if(Widget.field2195) {
                                    Frames.method1960(var10);
                                 }
                              } else {
                                 if(var10.item != -1) {
                                    var71 = class175.createSprite(var10.item, var10.stackSize, var10.borderThickness, var10.sprite2, var10.field2254, false);
                                 } else {
                                    var71 = var10.method3266(false);
                                 }

                                 if(var71 == null) {
                                    if(Widget.field2195) {
                                       Frames.method1960(var10);
                                    }
                                 } else {
                                    var20 = var71.maxWidth;
                                    var21 = var71.maxHeight;
                                    if(!var10.field2278) {
                                       var22 = var10.width * 4096 / var20;
                                       if(var10.field2233 != 0) {
                                          var71.method4267(var10.width / 2 + var12, var13 + var10.height / 2, var10.field2233, var22);
                                       } else if(var14 != 0) {
                                          var71.method4289(var12, var13, var10.width, var10.height, 256 - (var14 & 255));
                                       } else if(var10.width == var20 && var21 == var10.height) {
                                          var71.method4284(var12, var13);
                                       } else {
                                          var71.method4247(var12, var13, var10.width, var10.height);
                                       }
                                    } else {
                                       Rasterizer2D.method4093(var12, var13, var10.width + var12, var10.height + var13);
                                       var22 = (var10.width + (var20 - 1)) / var20;
                                       var23 = (var21 - 1 + var10.height) / var21;

                                       for(var24 = 0; var24 < var22; ++var24) {
                                          for(var52 = 0; var52 < var23; ++var52) {
                                             if(var10.field2233 != 0) {
                                                var71.method4267(var24 * var20 + var12 + var20 / 2, var13 + var52 * var21 + var21 / 2, var10.field2233, 4096);
                                             } else if(var14 != 0) {
                                                var71.method4271(var12 + var20 * var24, var52 * var21 + var13, 256 - (var14 & 255));
                                             } else {
                                                var71.method4284(var20 * var24 + var12, var21 * var52 + var13);
                                             }
                                          }
                                       }

                                       Rasterizer2D.method4124(var2, var3, var4, var5);
                                    }
                                 }
                              }
                           } else {
                              ItemComposition var54;
                              if(var10.type == 6) {
                                 boolean var58 = class175.method3328(var10);
                                 if(var58) {
                                    var20 = var10.field2262;
                                 } else {
                                    var20 = var10.field2243;
                                 }

                                 Model var69 = null;
                                 var22 = 0;
                                 if(var10.item != -1) {
                                    var54 = class168.getItemDefinition(var10.item);
                                    if(null != var54) {
                                       var54 = var54.method3772(var10.stackSize);
                                       var69 = var54.getModel(1);
                                       if(var69 != null) {
                                          var69.method1684();
                                          var22 = var69.modelHeight / 2;
                                       } else {
                                          Frames.method1960(var10);
                                       }
                                    }
                                 } else if(var10.modelType == 5) {
                                    if(var10.modelId == 0) {
                                       var69 = Client.field562.method3236((Sequence)null, -1, (Sequence)null, -1);
                                    } else {
                                       var69 = class9.localPlayer.getModel();
                                    }
                                 } else if(var20 == -1) {
                                    var69 = var10.method3269((Sequence)null, -1, var58, class9.localPlayer.composition);
                                    if(null == var69 && Widget.field2195) {
                                       Frames.method1960(var10);
                                    }
                                 } else {
                                    Sequence var80 = XClanMember.getAnimation(var20);
                                    var69 = var10.method3269(var80, var10.field2318, var58, class9.localPlayer.composition);
                                    if(null == var69 && Widget.field2195) {
                                       Frames.method1960(var10);
                                    }
                                 }

                                 class84.method1741(var10.width / 2 + var12, var10.height / 2 + var13);
                                 var23 = var10.field2238 * class84.field1435[var10.rotationX] >> 16;
                                 var24 = var10.field2238 * class84.field1432[var10.rotationX] >> 16;
                                 if(null != var69) {
                                    if(!var10.hasScript) {
                                       var69.method1633(0, var10.rotationZ, 0, var10.rotationX, 0, var23, var24);
                                    } else {
                                       var69.method1684();
                                       if(var10.field2287) {
                                          var69.method1627(0, var10.rotationZ, var10.rotationY, var10.rotationX, var10.field2245, var10.field2246 + var22 + var23, var10.field2246 + var24, var10.field2238);
                                       } else {
                                          var69.method1633(0, var10.rotationZ, var10.rotationY, var10.rotationX, var10.field2245, var22 + var23 + var10.field2246, var24 + var10.field2246);
                                       }
                                    }
                                 }

                                 class84.method1699();
                              } else {
                                 if(var10.type == 7) {
                                    var70 = var10.method3285();
                                    if(null == var70) {
                                       if(Widget.field2195) {
                                          Frames.method1960(var10);
                                       }
                                       continue;
                                    }

                                    var20 = 0;

                                    for(var21 = 0; var21 < var10.field2208; ++var21) {
                                       for(var22 = 0; var22 < var10.originalWidth; ++var22) {
                                          if(var10.itemIds[var20] > 0) {
                                             var54 = class168.getItemDefinition(var10.itemIds[var20] - 1);
                                             String var51;
                                             if(var54.isStackable != 1 && var10.itemQuantities[var20] == 1) {
                                                var51 = class187.method3515(16748608) + var54.name + "</col>";
                                             } else {
                                                var51 = class187.method3515(16748608) + var54.name + "</col>" + " " + 'x' + Buffer.method3071(var10.itemQuantities[var20]);
                                             }

                                             var52 = var12 + var22 * (var10.field2259 + 115);
                                             var47 = (var10.field2313 + 12) * var21 + var13;
                                             if(var10.field2236 == 0) {
                                                var70.method3974(var51, var52, var47, var10.textColor, var10.field2261?0:-1);
                                             } else if(var10.field2236 == 1) {
                                                var70.method4006(var51, var52 + var10.width / 2, var47, var10.textColor, var10.field2261?0:-1);
                                             } else {
                                                var70.method3965(var51, var52 + var10.width - 1, var47, var10.textColor, var10.field2261?0:-1);
                                             }
                                          }

                                          ++var20;
                                       }
                                    }
                                 }

                                 if(var10.type == 8 && var10 == Ignore.field201 && Client.field507 == Client.field436) {
                                    var19 = 0;
                                    var20 = 0;
                                    Font var49 = XItemContainer.field119;
                                    String var55 = var10.text;

                                    String var78;
                                    for(var55 = XItemContainer.method167(var55, var10); var55.length() > 0; var20 += var49.field3104 + 1) {
                                       var24 = var55.indexOf("<br>");
                                       if(var24 != -1) {
                                          var78 = var55.substring(0, var24);
                                          var55 = var55.substring(4 + var24);
                                       } else {
                                          var78 = var55;
                                          var55 = "";
                                       }

                                       var52 = var49.method3969(var78);
                                       if(var52 > var19) {
                                          var19 = var52;
                                       }
                                    }

                                    var19 += 6;
                                    var20 += 7;
                                    var24 = var10.width + var12 - 5 - var19;
                                    var52 = var10.height + var13 + 5;
                                    if(var24 < 5 + var12) {
                                       var24 = var12 + 5;
                                    }

                                    if(var19 + var24 > var4) {
                                       var24 = var4 - var19;
                                    }

                                    if(var52 + var20 > var5) {
                                       var52 = var5 - var20;
                                    }

                                    Rasterizer2D.method4099(var24, var52, var19, var20, 16777120);
                                    Rasterizer2D.method4104(var24, var52, var19, var20, 0);
                                    var55 = var10.text;
                                    var47 = var52 + var49.field3104 + 2;

                                    for(var55 = XItemContainer.method167(var55, var10); var55.length() > 0; var47 += var49.field3104 + 1) {
                                       var27 = var55.indexOf("<br>");
                                       if(var27 != -1) {
                                          var78 = var55.substring(0, var27);
                                          var55 = var55.substring(4 + var27);
                                       } else {
                                          var78 = var55;
                                          var55 = "";
                                       }

                                       var49.method3974(var78, var24 + 3, var47, 0, -1);
                                    }
                                 }

                                 if(var10.type == 9) {
                                    if(var10.field2229 == 1) {
                                       if(var10.field2230) {
                                          var19 = var12;
                                          var20 = var13 + var10.height;
                                          var21 = var10.width + var12;
                                          var22 = var13;
                                       } else {
                                          var19 = var12;
                                          var20 = var13;
                                          var21 = var12 + var10.width;
                                          var22 = var13 + var10.height;
                                       }

                                       Rasterizer2D.method4097(var19, var20, var21, var22, var10.textColor);
                                    } else {
                                       var19 = var10.width >= 0?var10.width:-var10.width;
                                       var20 = var10.height >= 0?var10.height:-var10.height;
                                       var21 = var19;
                                       if(var19 < var20) {
                                          var21 = var20;
                                       }

                                       if(var21 != 0) {
                                          var22 = (var10.width << 16) / var21;
                                          var23 = (var10.height << 16) / var21;
                                          if(var23 <= var22) {
                                             var22 = -var22;
                                          } else {
                                             var23 = -var23;
                                          }

                                          var24 = var10.field2229 * var23 >> 17;
                                          var52 = var10.field2229 * var23 + 1 >> 17;
                                          var47 = var22 * var10.field2229 >> 17;
                                          var27 = 1 + var22 * var10.field2229 >> 17;
                                          var28 = var24 + var12;
                                          var29 = var12 - var52;
                                          var30 = var10.width + var12 - var52;
                                          var31 = var24 + var10.width + var12;
                                          var32 = var13 + var47;
                                          var33 = var13 - var27;
                                          var34 = var10.height + var13 - var27;
                                          var35 = var47 + var13 + var10.height;
                                          class84.setRasterClippingEnabled(var28, var29, var30);
                                          class84.rasterFlat(var32, var33, var34, var28, var29, var30, var10.textColor);
                                          class84.setRasterClippingEnabled(var28, var30, var31);
                                          class84.rasterFlat(var32, var34, var35, var28, var30, var31, var10.textColor);
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
