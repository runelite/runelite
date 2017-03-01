import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("am")
@Implements("ChatLineBuffer")
public class ChatLineBuffer {
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -1700173113
   )
   @Export("length")
   int length;
   @ObfuscatedName("ff")
   @ObfuscatedGetter(
      intValue = 755574967
   )
   @Export("cameraY")
   static int cameraY;
   @ObfuscatedName("n")
   @Export("lines")
   MessageNode[] lines = new MessageNode[100];

   @ObfuscatedName("cs")
   @ObfuscatedSignature(
      signature = "([LWidget;IIIIIIIII)V",
      garbageValue = "-1914461643"
   )
   @Export("gameDraw")
   static final void gameDraw(Widget[] var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
      Rasterizer2D.method4091(var2, var3, var4, var5);
      class84.method1747();

      for(int var9 = 0; var9 < var0.length; ++var9) {
         Widget var10 = var0[var9];
         if(var10 != null && (var10.parentId == var1 || var1 == -1412584499 && Client.field462 == var10)) {
            int var11;
            if(var8 == -1) {
               Client.widgetPositionX[Client.field468] = var10.relativeX + var6;
               Client.widgetPositionY[Client.field468] = var7 + var10.relativeY;
               Client.widgetBoundsWidth[Client.field468] = var10.width;
               Client.widgetBoundsHeight[Client.field468] = var10.height;
               var11 = ++Client.field468 - 1;
            } else {
               var11 = var8;
            }

            var10.boundsIndex = var11;
            var10.field2338 = Client.gameCycle;
            if(!var10.hasScript || !class9.method114(var10)) {
               int var12;
               if(var10.contentType > 0) {
                  var12 = var10.contentType;
                  if(var12 == 324) {
                     if(Client.field564 == -1) {
                        Client.field564 = var10.textureId;
                        Client.field565 = var10.field2231;
                     }

                     if(Client.field412.isFemale) {
                        var10.textureId = Client.field564;
                     } else {
                        var10.textureId = Client.field565;
                     }
                  } else if(var12 == 325) {
                     if(Client.field564 == -1) {
                        Client.field564 = var10.textureId;
                        Client.field565 = var10.field2231;
                     }

                     if(Client.field412.isFemale) {
                        var10.textureId = Client.field565;
                     } else {
                        var10.textureId = Client.field564;
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

               var12 = var10.relativeX + var6;
               int var13 = var7 + var10.relativeY;
               int var14 = var10.opacity;
               int var15;
               int var16;
               if(Client.field462 == var10) {
                  if(var1 != -1412584499 && !var10.field2284) {
                     TextureProvider.field1212 = var0;
                     NPC.field766 = var6;
                     Player.field263 = var7;
                     continue;
                  }

                  if(Client.field473 && Client.field467) {
                     var15 = class115.field1805;
                     var16 = class115.field1806;
                     var15 -= Client.field464;
                     var16 -= Client.field466;
                     if(var15 < Client.field523) {
                        var15 = Client.field523;
                     }

                     if(var10.width + var15 > Client.field523 + Client.field463.width) {
                        var15 = Client.field463.width + Client.field523 - var10.width;
                     }

                     if(var16 < Client.field307) {
                        var16 = Client.field307;
                     }

                     if(var10.height + var16 > Client.field307 + Client.field463.height) {
                        var16 = Client.field463.height + Client.field307 - var10.height;
                     }

                     var12 = var15;
                     var13 = var16;
                  }

                  if(!var10.field2284) {
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
                  var21 = var12 + var10.width;
                  var22 = var13 + var10.height;
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
                  int var25;
                  int var26;
                  int var28;
                  int var31;
                  int var39;
                  int var43;
                  if(var10.contentType != 0) {
                     if(var10.contentType == 1336) {
                        if(Client.field302) {
                           var13 += 15;
                           class15.field162.method3911("Fps:" + GameEngine.FPS, var10.width + var12, var13, 16776960, -1);
                           var13 += 15;
                           Runtime var64 = Runtime.getRuntime();
                           var20 = (int)((var64.totalMemory() - var64.freeMemory()) / 1024L);
                           var21 = 16776960;
                           if(var20 > '耀' && Client.field290) {
                              var21 = 16711680;
                           }

                           if(var20 > 65536 && !Client.field290) {
                              var21 = 16711680;
                           }

                           class15.field162.method3911("Mem:" + var20 + "k", var10.width + var12, var13, var21, -1);
                           var13 += 15;
                        }
                        continue;
                     }

                     if(var10.contentType == 1337) {
                        Client.field438 = var12;
                        Client.field465 = var13;
                        Tile.method1639(var12, var13, var10.width, var10.height);
                        Client.field494[var10.boundsIndex] = true;
                        Rasterizer2D.method4091(var2, var3, var4, var5);
                        continue;
                     }

                     if(var10.contentType == 1338) {
                        class112.method2179();
                        class164 var62 = var10.method3289(false);
                        if(var62 != null) {
                           Rasterizer2D.method4091(var12, var13, var62.field2160 + var12, var13 + var62.field2155);
                           if(Client.field526 != 2 && Client.field526 != 5) {
                              var20 = Client.mapAngle + Client.mapScale & 2047;
                              var21 = 48 + WidgetNode.localPlayer.x / 32;
                              var22 = 464 - WidgetNode.localPlayer.y / 32;
                              class26.field595.method4220(var12, var13, var62.field2160, var62.field2155, var21, var22, var20, 256 + Client.mapScaleDelta, var62.field2157, var62.field2156);

                              for(var23 = 0; var23 < Client.field520; ++var23) {
                                 var39 = 2 + Client.field475[var23] * 4 - WidgetNode.localPlayer.x / 32;
                                 var25 = 4 * Client.field396[var23] + 2 - WidgetNode.localPlayer.y / 32;
                                 class57.method1177(var12, var13, var39, var25, Client.field358[var23], var62);
                              }

                              var23 = 0;

                              while(true) {
                                 if(var23 >= 104) {
                                    for(var23 = 0; var23 < Client.field328; ++var23) {
                                       NPC var47 = Client.cachedNPCs[Client.field285[var23]];
                                       if(null != var47 && var47.vmethod794()) {
                                          NPCComposition var59 = var47.composition;
                                          if(null != var59 && var59.configs != null) {
                                             var59 = var59.method3779();
                                          }

                                          if(var59 != null && var59.isMinimapVisible && var59.field3039) {
                                             var26 = var47.x / 32 - WidgetNode.localPlayer.x / 32;
                                             var43 = var47.y / 32 - WidgetNode.localPlayer.y / 32;
                                             class57.method1177(var12, var13, var26, var43, class44.field902[1], var62);
                                          }
                                       }
                                    }

                                    var23 = class45.field916;
                                    int[] var48 = class45.field913;

                                    for(var25 = 0; var25 < var23; ++var25) {
                                       Player var38 = Client.cachedPlayers[var48[var25]];
                                       if(var38 != null && var38.vmethod794() && !var38.field260 && WidgetNode.localPlayer != var38) {
                                          var43 = var38.x / 32 - WidgetNode.localPlayer.x / 32;
                                          var28 = var38.y / 32 - WidgetNode.localPlayer.y / 32;
                                          boolean var52 = false;
                                          if(class20.method215(var38.name, true)) {
                                             var52 = true;
                                          }

                                          boolean var50 = false;

                                          for(var31 = 0; var31 < class119.clanChatCount; ++var31) {
                                             if(var38.name.equals(Friend.clanMembers[var31].username)) {
                                                var50 = true;
                                                break;
                                             }
                                          }

                                          boolean var51 = false;
                                          if(WidgetNode.localPlayer.team != 0 && var38.team != 0 && var38.team == WidgetNode.localPlayer.team) {
                                             var51 = true;
                                          }

                                          if(var52) {
                                             class57.method1177(var12, var13, var43, var28, class44.field902[3], var62);
                                          } else if(var51) {
                                             class57.method1177(var12, var13, var43, var28, class44.field902[4], var62);
                                          } else if(var50) {
                                             class57.method1177(var12, var13, var43, var28, class44.field902[5], var62);
                                          } else {
                                             class57.method1177(var12, var13, var43, var28, class44.field902[2], var62);
                                          }
                                       }
                                    }

                                    if(Client.field304 != 0 && Client.gameCycle % 20 < 10) {
                                       if(Client.field304 == 1 && Client.field305 >= 0 && Client.field305 < Client.cachedNPCs.length) {
                                          NPC var63 = Client.cachedNPCs[Client.field305];
                                          if(null != var63) {
                                             var26 = var63.x / 32 - WidgetNode.localPlayer.x / 32;
                                             var43 = var63.y / 32 - WidgetNode.localPlayer.y / 32;
                                             class45.method908(var12, var13, var26, var43, class16.field170[1], var62);
                                          }
                                       }

                                       if(Client.field304 == 2) {
                                          var25 = 2 + (Client.field295 * 4 - Player.baseX * 4) - WidgetNode.localPlayer.x / 32;
                                          var26 = 2 + (Client.field382 * 4 - SecondaryBufferProvider.baseY * 4) - WidgetNode.localPlayer.y / 32;
                                          class45.method908(var12, var13, var25, var26, class16.field170[1], var62);
                                       }

                                       if(Client.field304 == 10 && Client.field562 >= 0 && Client.field562 < Client.cachedPlayers.length) {
                                          Player var65 = Client.cachedPlayers[Client.field562];
                                          if(var65 != null) {
                                             var26 = var65.x / 32 - WidgetNode.localPlayer.x / 32;
                                             var43 = var65.y / 32 - WidgetNode.localPlayer.y / 32;
                                             class45.method908(var12, var13, var26, var43, class16.field170[1], var62);
                                          }
                                       }
                                    }

                                    if(Client.flagX != 0) {
                                       var25 = 2 + Client.flagX * 4 - WidgetNode.localPlayer.x / 32;
                                       var26 = Client.flagY * 4 + 2 - WidgetNode.localPlayer.y / 32;
                                       class57.method1177(var12, var13, var25, var26, class16.field170[0], var62);
                                    }

                                    if(!WidgetNode.localPlayer.field260) {
                                       Rasterizer2D.method4056(var12 + var62.field2160 / 2 - 1, var62.field2155 / 2 + var13 - 1, 3, 3, 16777215);
                                    }
                                    break;
                                 }

                                 for(var39 = 0; var39 < 104; ++var39) {
                                    Deque var42 = Client.groundItemDeque[CollisionData.plane][var23][var39];
                                    if(var42 != null) {
                                       var26 = 2 + 4 * var23 - WidgetNode.localPlayer.x / 32;
                                       var43 = 2 + 4 * var39 - WidgetNode.localPlayer.y / 32;
                                       class57.method1177(var12, var13, var26, var43, class44.field902[0], var62);
                                    }
                                 }

                                 ++var23;
                              }
                           } else {
                              Rasterizer2D.method4031(var12, var13, 0, var62.field2157, var62.field2156);
                           }

                           Client.field495[var11] = true;
                        }

                        Rasterizer2D.method4091(var2, var3, var4, var5);
                        continue;
                     }

                     if(var10.contentType == 1339) {
                        class162.method3184(var10, var12, var13, var11);
                        Rasterizer2D.method4091(var2, var3, var4, var5);
                        continue;
                     }
                  }

                  if(var10.type == 0) {
                     if(!var10.hasScript && class9.method114(var10) && var10 != class45.field924) {
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
                     if(null != var10.children) {
                        gameDraw(var10.children, var10.id, var15, var16, var17, var18, var12 - var10.scrollX, var13 - var10.scrollY, var11);
                     }

                     WidgetNode var41 = (WidgetNode)Client.componentTable.method2437((long)var10.id);
                     if(null != var41) {
                        class1.method18(var41.id, var15, var16, var17, var18, var12, var13, var11);
                     }

                     Rasterizer2D.method4091(var2, var3, var4, var5);
                     class84.method1747();
                  }

                  if(Client.isResized || Client.field435[var11] || Client.field501 > 1) {
                     if(var10.type == 0 && !var10.hasScript && var10.scrollHeight > var10.height) {
                        var19 = var10.width + var12;
                        var20 = var10.scrollY;
                        var21 = var10.height;
                        var22 = var10.scrollHeight;
                        class9.field73[0].method4115(var19, var13);
                        class9.field73[1].method4115(var19, var13 + var21 - 16);
                        Rasterizer2D.method4056(var19, var13 + 16, 16, var21 - 32, Client.field366);
                        var23 = (var21 - 32) * var21 / var22;
                        if(var23 < 8) {
                           var23 = 8;
                        }

                        var39 = var20 * (var21 - 32 - var23) / (var22 - var21);
                        Rasterizer2D.method4056(var19, 16 + var13 + var39, 16, var23, Client.field367);
                        Rasterizer2D.method4028(var19, var13 + 16 + var39, var23, Client.field369);
                        Rasterizer2D.method4028(var19 + 1, var13 + 16 + var39, var23, Client.field369);
                        Rasterizer2D.method4026(var19, 16 + var13 + var39, 16, Client.field369);
                        Rasterizer2D.method4026(var19, 17 + var13 + var39, 16, Client.field369);
                        Rasterizer2D.method4028(var19 + 15, var39 + var13 + 16, var23, Client.field368);
                        Rasterizer2D.method4028(var19 + 14, var39 + 17 + var13, var23 - 1, Client.field368);
                        Rasterizer2D.method4026(var19, var23 + var13 + 15 + var39, 16, Client.field368);
                        Rasterizer2D.method4026(var19 + 1, var23 + var13 + 14 + var39, 15, Client.field368);
                     }

                     if(var10.type != 1) {
                        int var29;
                        if(var10.type == 2) {
                           var19 = 0;

                           for(var20 = 0; var20 < var10.field2199; ++var20) {
                              for(var21 = 0; var21 < var10.originalWidth; ++var21) {
                                 var22 = var12 + var21 * (var10.field2272 + 32);
                                 var23 = var13 + var20 * (var10.field2273 + 32);
                                 if(var19 < 20) {
                                    var22 += var10.field2316[var19];
                                    var23 += var10.field2275[var19];
                                 }

                                 if(var10.itemIds[var19] <= 0) {
                                    if(null != var10.field2242 && var19 < 20) {
                                       SpritePixels var46 = var10.method3287(var19);
                                       if(null != var46) {
                                          var46.method4174(var22, var23);
                                       } else if(Widget.field2327) {
                                          method996(var10);
                                       }
                                    }
                                 } else {
                                    boolean var60 = false;
                                    boolean var49 = false;
                                    var26 = var10.itemIds[var19] - 1;
                                    if(32 + var22 > var2 && var22 < var4 && 32 + var23 > var3 && var23 < var5 || var10 == class15.field159 && var19 == Client.field402) {
                                       SpritePixels var27;
                                       if(Client.field416 == 1 && class6.field41 == var19 && var10.id == class33.field750) {
                                          var27 = class170.createSprite(var26, var10.itemQuantities[var19], 2, 0, 2, false);
                                       } else {
                                          var27 = class170.createSprite(var26, var10.itemQuantities[var19], 1, 3153952, 2, false);
                                       }

                                       if(var27 != null) {
                                          if(class15.field159 == var10 && var19 == Client.field402) {
                                             var39 = class115.field1805 - Client.field403;
                                             var25 = class115.field1806 - Client.field442;
                                             if(var39 < 5 && var39 > -5) {
                                                var39 = 0;
                                             }

                                             if(var25 < 5 && var25 > -5) {
                                                var25 = 0;
                                             }

                                             if(Client.field407 < 5) {
                                                var39 = 0;
                                                var25 = 0;
                                             }

                                             var27.method4180(var39 + var22, var25 + var23, 128);
                                             if(var1 != -1) {
                                                Widget var44 = var0[var1 & '\uffff'];
                                                if(var25 + var23 < Rasterizer2D.field3193 && var44.scrollY > 0) {
                                                   var29 = (Rasterizer2D.field3193 - var23 - var25) * Client.field365 / 3;
                                                   if(var29 > Client.field365 * 10) {
                                                      var29 = Client.field365 * 10;
                                                   }

                                                   if(var29 > var44.scrollY) {
                                                      var29 = var44.scrollY;
                                                   }

                                                   var44.scrollY -= var29;
                                                   Client.field442 += var29;
                                                   method996(var44);
                                                }

                                                if(32 + var23 + var25 > Rasterizer2D.field3190 && var44.scrollY < var44.scrollHeight - var44.height) {
                                                   var29 = (var23 + var25 + 32 - Rasterizer2D.field3190) * Client.field365 / 3;
                                                   if(var29 > Client.field365 * 10) {
                                                      var29 = Client.field365 * 10;
                                                   }

                                                   if(var29 > var44.scrollHeight - var44.height - var44.scrollY) {
                                                      var29 = var44.scrollHeight - var44.height - var44.scrollY;
                                                   }

                                                   var44.scrollY += var29;
                                                   Client.field442 -= var29;
                                                   method996(var44);
                                                }
                                             }
                                          } else if(var10 == class186.field2773 && var19 == Client.field401) {
                                             var27.method4180(var22, var23, 128);
                                          } else {
                                             var27.method4174(var22, var23);
                                          }
                                       } else {
                                          method996(var10);
                                       }
                                    }
                                 }

                                 ++var19;
                              }
                           }
                        } else if(var10.type == 3) {
                           if(class183.method3442(var10)) {
                              var19 = var10.field2232;
                              if(class45.field924 == var10 && var10.field2234 != 0) {
                                 var19 = var10.field2234;
                              }
                           } else {
                              var19 = var10.textColor;
                              if(var10 == class45.field924 && var10.field2285 != 0) {
                                 var19 = var10.field2285;
                              }
                           }

                           if(var10.field2261) {
                              switch(var10.field2236.field3207) {
                              case 1:
                                 Rasterizer2D.method4020(var12, var13, var10.width, var10.height, var10.textColor, var10.field2232, 256 - (var10.opacity & 255), 256 - (var10.field2196 & 255));
                                 break;
                              case 2:
                                 Rasterizer2D.method4021(var12, var13, var10.width, var10.height, var10.textColor, var10.field2232, 256 - (var10.opacity & 255), 256 - (var10.field2196 & 255));
                                 break;
                              case 3:
                                 Rasterizer2D.method4022(var12, var13, var10.width, var10.height, var10.textColor, var10.field2232, 256 - (var10.opacity & 255), 256 - (var10.field2196 & 255));
                                 break;
                              case 4:
                                 Rasterizer2D.method4054(var12, var13, var10.width, var10.height, var10.textColor, var10.field2232, 256 - (var10.opacity & 255), 256 - (var10.field2196 & 255));
                                 break;
                              default:
                                 if(var14 == 0) {
                                    Rasterizer2D.method4056(var12, var13, var10.width, var10.height, var19);
                                 } else {
                                    Rasterizer2D.method4034(var12, var13, var10.width, var10.height, var19, 256 - (var14 & 255));
                                 }
                              }
                           } else if(var14 == 0) {
                              Rasterizer2D.method4012(var12, var13, var10.width, var10.height, var19);
                           } else {
                              Rasterizer2D.method4025(var12, var13, var10.width, var10.height, var19, 256 - (var14 & 255));
                           }
                        } else {
                           Font var57;
                           if(var10.type == 4) {
                              var57 = var10.method3282();
                              if(var57 == null) {
                                 if(Widget.field2327) {
                                    method996(var10);
                                 }
                              } else {
                                 String var55 = var10.text;
                                 if(class183.method3442(var10)) {
                                    var20 = var10.field2232;
                                    if(var10 == class45.field924 && var10.field2234 != 0) {
                                       var20 = var10.field2234;
                                    }

                                    if(var10.field2267.length() > 0) {
                                       var55 = var10.field2267;
                                    }
                                 } else {
                                    var20 = var10.textColor;
                                    if(class45.field924 == var10 && var10.field2285 != 0) {
                                       var20 = var10.field2285;
                                    }
                                 }

                                 if(var10.hasScript && var10.item != -1) {
                                    ItemComposition var54 = getItemDefinition(var10.item);
                                    var55 = var54.name;
                                    if(null == var55) {
                                       var55 = "null";
                                    }

                                    if((var54.isStackable == 1 || var10.stackSize != 1) && var10.stackSize != -1) {
                                       var55 = class37.method813(16748608) + var55 + "</col>" + " " + 'x' + class13.method186(var10.stackSize);
                                    }
                                 }

                                 if(Client.field543 == var10) {
                                    Object var10000 = null;
                                    var55 = "Please wait...";
                                    var20 = var10.textColor;
                                 }

                                 if(!var10.hasScript) {
                                    var55 = ScriptState.method160(var55, var10);
                                 }

                                 var57.method3913(var55, var12, var13, var10.width, var10.height, var20, var10.field2271?0:-1, var10.field2269, var10.field2270, var10.field2268);
                              }
                           } else if(var10.type == 5) {
                              SpritePixels var58;
                              if(!var10.hasScript) {
                                 var58 = var10.method3286(class183.method3442(var10));
                                 if(var58 != null) {
                                    var58.method4174(var12, var13);
                                 } else if(Widget.field2327) {
                                    method996(var10);
                                 }
                              } else {
                                 if(var10.item != -1) {
                                    var58 = class170.createSprite(var10.item, var10.stackSize, var10.borderThickness, var10.sprite2, var10.field2229, false);
                                 } else {
                                    var58 = var10.method3286(false);
                                 }

                                 if(null == var58) {
                                    if(Widget.field2327) {
                                       method996(var10);
                                    }
                                 } else {
                                    var20 = var58.maxWidth;
                                    var21 = var58.maxHeight;
                                    if(!var10.field2244) {
                                       var22 = var10.width * 4096 / var20;
                                       if(var10.field2291 != 0) {
                                          var58.method4187(var12 + var10.width / 2, var13 + var10.height / 2, var10.field2291, var22);
                                       } else if(var14 != 0) {
                                          var58.method4182(var12, var13, var10.width, var10.height, 256 - (var14 & 255));
                                       } else if(var10.width == var20 && var21 == var10.height) {
                                          var58.method4174(var12, var13);
                                       } else {
                                          var58.method4241(var12, var13, var10.width, var10.height);
                                       }
                                    } else {
                                       Rasterizer2D.method4014(var12, var13, var12 + var10.width, var10.height + var13);
                                       var22 = (var20 - 1 + var10.width) / var20;
                                       var23 = (var10.height + (var21 - 1)) / var21;

                                       for(var39 = 0; var39 < var22; ++var39) {
                                          for(var25 = 0; var25 < var23; ++var25) {
                                             if(var10.field2291 != 0) {
                                                var58.method4187(var12 + var20 * var39 + var20 / 2, var13 + var25 * var21 + var21 / 2, var10.field2291, 4096);
                                             } else if(var14 != 0) {
                                                var58.method4180(var12 + var20 * var39, var13 + var25 * var21, 256 - (var14 & 255));
                                             } else {
                                                var58.method4174(var20 * var39 + var12, var25 * var21 + var13);
                                             }
                                          }
                                       }

                                       Rasterizer2D.method4091(var2, var3, var4, var5);
                                    }
                                 }
                              }
                           } else {
                              ItemComposition var40;
                              if(var10.type == 6) {
                                 boolean var45 = class183.method3442(var10);
                                 if(var45) {
                                    var20 = var10.field2254;
                                 } else {
                                    var20 = var10.field2233;
                                 }

                                 Model var53 = null;
                                 var22 = 0;
                                 if(var10.item != -1) {
                                    var40 = getItemDefinition(var10.item);
                                    if(null != var40) {
                                       var40 = var40.method3743(var10.stackSize);
                                       var53 = var40.getModel(1);
                                       if(null != var53) {
                                          var53.method1649();
                                          var22 = var53.modelHeight / 2;
                                       } else {
                                          method996(var10);
                                       }
                                    }
                                 } else if(var10.modelType == 5) {
                                    if(var10.modelId == 0) {
                                       var53 = Client.field412.method3242((Sequence)null, -1, (Sequence)null, -1);
                                    } else {
                                       var53 = WidgetNode.localPlayer.getModel();
                                    }
                                 } else if(var20 == -1) {
                                    var53 = var10.method3288((Sequence)null, -1, var45, WidgetNode.localPlayer.composition);
                                    if(var53 == null && Widget.field2327) {
                                       method996(var10);
                                    }
                                 } else {
                                    Sequence var61 = TextureProvider.getAnimation(var20);
                                    var53 = var10.method3288(var61, var10.field2328, var45, WidgetNode.localPlayer.composition);
                                    if(null == var53 && Widget.field2327) {
                                       method996(var10);
                                    }
                                 }

                                 class84.method1726(var12 + var10.width / 2, var13 + var10.height / 2);
                                 var23 = class84.field1460[var10.rotationX] * var10.field2260 >> 16;
                                 var39 = class84.field1446[var10.rotationX] * var10.field2260 >> 16;
                                 if(var53 != null) {
                                    if(!var10.hasScript) {
                                       var53.method1661(0, var10.rotationZ, 0, var10.rotationX, 0, var23, var39);
                                    } else {
                                       var53.method1649();
                                       if(var10.field2263) {
                                          var53.method1662(0, var10.rotationZ, var10.rotationY, var10.rotationX, var10.field2255, var22 + var23 + var10.field2256, var10.field2256 + var39, var10.field2260);
                                       } else {
                                          var53.method1661(0, var10.rotationZ, var10.rotationY, var10.rotationX, var10.field2255, var22 + var23 + var10.field2256, var10.field2256 + var39);
                                       }
                                    }
                                 }

                                 class84.method1751();
                              } else {
                                 if(var10.type == 7) {
                                    var57 = var10.method3282();
                                    if(var57 == null) {
                                       if(Widget.field2327) {
                                          method996(var10);
                                       }
                                       continue;
                                    }

                                    var20 = 0;

                                    for(var21 = 0; var21 < var10.field2199; ++var21) {
                                       for(var22 = 0; var22 < var10.originalWidth; ++var22) {
                                          if(var10.itemIds[var20] > 0) {
                                             var40 = getItemDefinition(var10.itemIds[var20] - 1);
                                             String var24;
                                             if(var40.isStackable != 1 && var10.itemQuantities[var20] == 1) {
                                                var24 = class37.method813(16748608) + var40.name + "</col>";
                                             } else {
                                                var24 = class37.method813(16748608) + var40.name + "</col>" + " " + 'x' + class13.method186(var10.itemQuantities[var20]);
                                             }

                                             var25 = var12 + (115 + var10.field2272) * var22;
                                             var26 = var13 + (var10.field2273 + 12) * var21;
                                             if(var10.field2269 == 0) {
                                                var57.method3973(var24, var25, var26, var10.textColor, var10.field2271?0:-1);
                                             } else if(var10.field2269 == 1) {
                                                var57.method3912(var24, var10.width / 2 + var25, var26, var10.textColor, var10.field2271?0:-1);
                                             } else {
                                                var57.method3911(var24, var25 + var10.width - 1, var26, var10.textColor, var10.field2271?0:-1);
                                             }
                                          }

                                          ++var20;
                                       }
                                    }
                                 }

                                 if(var10.type == 8 && var10 == class5.field40 && Client.field441 == Client.field440) {
                                    var19 = 0;
                                    var20 = 0;
                                    Font var37 = class15.field162;
                                    String var36 = var10.text;

                                    String var56;
                                    for(var36 = ScriptState.method160(var36, var10); var36.length() > 0; var20 += var37.field3112 + 1) {
                                       var39 = var36.indexOf("<br>");
                                       if(var39 != -1) {
                                          var56 = var36.substring(0, var39);
                                          var36 = var36.substring(4 + var39);
                                       } else {
                                          var56 = var36;
                                          var36 = "";
                                       }

                                       var25 = var37.method3904(var56);
                                       if(var25 > var19) {
                                          var19 = var25;
                                       }
                                    }

                                    var19 += 6;
                                    var20 += 7;
                                    var39 = var12 + var10.width - 5 - var19;
                                    var25 = var13 + var10.height + 5;
                                    if(var39 < 5 + var12) {
                                       var39 = var12 + 5;
                                    }

                                    if(var39 + var19 > var4) {
                                       var39 = var4 - var19;
                                    }

                                    if(var20 + var25 > var5) {
                                       var25 = var5 - var20;
                                    }

                                    Rasterizer2D.method4056(var39, var25, var19, var20, 16777120);
                                    Rasterizer2D.method4012(var39, var25, var19, var20, 0);
                                    var36 = var10.text;
                                    var26 = 2 + var25 + var37.field3112;

                                    for(var36 = ScriptState.method160(var36, var10); var36.length() > 0; var26 += var37.field3112 + 1) {
                                       var43 = var36.indexOf("<br>");
                                       if(var43 != -1) {
                                          var56 = var36.substring(0, var43);
                                          var36 = var36.substring(var43 + 4);
                                       } else {
                                          var56 = var36;
                                          var36 = "";
                                       }

                                       var37.method3973(var56, var39 + 3, var26, 0, -1);
                                    }
                                 }

                                 if(var10.type == 9) {
                                    if(var10.field2239 == 1) {
                                       if(var10.field2289) {
                                          var19 = var12;
                                          var20 = var10.height + var13;
                                          var21 = var10.width + var12;
                                          var22 = var13;
                                       } else {
                                          var19 = var12;
                                          var20 = var13;
                                          var21 = var10.width + var12;
                                          var22 = var13 + var10.height;
                                       }

                                       Rasterizer2D.method4030(var19, var20, var21, var22, var10.textColor);
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

                                          var39 = var23 * var10.field2239 >> 17;
                                          var25 = 1 + var23 * var10.field2239 >> 17;
                                          var26 = var10.field2239 * var22 >> 17;
                                          var43 = 1 + var10.field2239 * var22 >> 17;
                                          var28 = var12 + var39;
                                          var29 = var12 - var25;
                                          int var30 = var10.width + var12 - var25;
                                          var31 = var10.width + var12 + var39;
                                          int var32 = var13 + var26;
                                          int var33 = var13 - var43;
                                          int var34 = var13 + var10.height - var43;
                                          int var35 = var10.height + var13 + var26;
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

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(ILScript;ZB)I",
      garbageValue = "30"
   )
   static int method982(int var0, Script var1, boolean var2) {
      Widget var3 = method993(class32.field726[--class32.field735]);
      if(var0 == 2800) {
         int[] var8 = class32.field726;
         int var5 = ++class32.field735 - 1;
         int var7 = MessageNode.method220(var3);
         int var6 = var7 >> 11 & 63;
         var8[var5] = var6;
         return 1;
      } else if(var0 != 2801) {
         if(var0 == 2802) {
            if(var3.name == null) {
               class32.scriptStringStack[++class30.scriptStringStackSize - 1] = "";
            } else {
               class32.scriptStringStack[++class30.scriptStringStackSize - 1] = var3.name;
            }

            return 1;
         } else {
            return 2;
         }
      } else {
         int var4 = class32.field726[--class32.field735];
         --var4;
         if(var3.actions != null && var4 < var3.actions.length && null != var3.actions[var4]) {
            class32.scriptStringStack[++class30.scriptStringStackSize - 1] = var3.actions[var4];
         } else {
            class32.scriptStringStack[++class30.scriptStringStackSize - 1] = "";
         }

         return 1;
      }
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(II)LMessageNode;",
      garbageValue = "-185570260"
   )
   MessageNode method983(int var1) {
      return var1 >= 0 && var1 < this.length?this.lines[var1]:null;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "2019091897"
   )
   int method984() {
      return this.length;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(IB)LWidget;",
      garbageValue = "-12"
   )
   public static Widget method993(int var0) {
      int var1 = var0 >> 16;
      int var2 = var0 & '\uffff';
      if(null == class231.widgets[var1] || class231.widgets[var1][var2] == null) {
         boolean var3 = Projectile.method874(var1);
         if(!var3) {
            return null;
         }
      }

      return class231.widgets[var1][var2];
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;I)LMessageNode;",
      garbageValue = "781529683"
   )
   MessageNode method994(int var1, String var2, String var3, String var4) {
      MessageNode var5 = this.lines[99];

      for(int var6 = this.length; var6 > 0; --var6) {
         if(var6 != 100) {
            this.lines[var6] = this.lines[var6 - 1];
         }
      }

      if(var5 == null) {
         var5 = new MessageNode(var1, var2, var4, var3);
      } else {
         var5.unlink();
         var5.method2513();
         var5.method217(var1, var2, var4, var3);
      }

      this.lines[0] = var5;
      if(this.length < 100) {
         ++this.length;
      }

      return var5;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(II)LItemComposition;",
      garbageValue = "-385492660"
   )
   @Export("getItemDefinition")
   public static ItemComposition getItemDefinition(int var0) {
      ItemComposition var1 = (ItemComposition)ItemComposition.field2993.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = ItemComposition.field2978.getConfigData(10, var0);
         var1 = new ItemComposition();
         var1.id = var0;
         if(var2 != null) {
            var1.loadBuffer(new Buffer(var2));
         }

         var1.method3705();
         if(var1.notedTemplate != -1) {
            var1.method3706(getItemDefinition(var1.notedTemplate), getItemDefinition(var1.note));
         }

         if(var1.field3000 != -1) {
            var1.method3763(getItemDefinition(var1.field3000), getItemDefinition(var1.field2983));
         }

         if(var1.field2999 != -1) {
            var1.method3704(getItemDefinition(var1.field2999), getItemDefinition(var1.field3001));
         }

         if(!Item.isMembersWorld && var1.isMembers) {
            var1.name = "Members object";
            var1.field2998 = false;
            var1.groundActions = null;
            var1.inventoryActions = null;
            var1.team = -1;
            var1.field2950 = 0;
         }

         ItemComposition.field2993.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("dx")
   @ObfuscatedSignature(
      signature = "(LWidget;I)V",
      garbageValue = "-1246149486"
   )
   static void method996(Widget var0) {
      if(Client.field493 == var0.field2338) {
         Client.field494[var0.boundsIndex] = true;
      }

   }
}
