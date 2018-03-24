import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jk")
@Implements("FileRequest")
public class FileRequest extends CacheableNode {
   @ObfuscatedName("db")
   @ObfuscatedSignature(
      signature = "Lju;"
   )
   @Export("indexCache10")
   static IndexData indexCache10;
   @ObfuscatedName("kz")
   @ObfuscatedSignature(
      signature = "Lig;"
   )
   static Widget field3371;
   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "Lju;"
   )
   @Export("index")
   public IndexData index;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 858976375
   )
   @Export("crc")
   public int crc;
   @ObfuscatedName("i")
   @Export("padding")
   public byte padding;

   @ObfuscatedName("iq")
   @ObfuscatedSignature(
      signature = "([Lig;IIIIIIIII)V",
      garbageValue = "-2048134470"
   )
   @Export("gameDraw")
   static final void gameDraw(Widget[] var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
      Rasterizer2D.setDrawRegion(var2, var3, var4, var5);
      Graphics3D.Rasterizer3D_method1();

      for(int var9 = 0; var9 < var0.length; ++var9) {
         Widget var10 = var0[var9];
         if(var10 != null && (var10.parentId == var1 || var1 == -1412584499 && var10 == Client.draggedWidget)) {
            int var11;
            if(var8 == -1) {
               Client.widgetPositionX[Client.widgetCount] = var10.relativeX + var6;
               Client.widgetPositionY[Client.widgetCount] = var7 + var10.relativeY;
               Client.widgetBoundsWidth[Client.widgetCount] = var10.width;
               Client.widgetBoundsHeight[Client.widgetCount] = var10.height;
               var11 = ++Client.widgetCount - 1;
            } else {
               var11 = var8;
            }

            var10.boundsIndex = var11;
            var10.loopCycle = Client.gameCycle;
            if(var10.hasScript) {
               boolean var12 = var10.isHidden;
               if(var12) {
                  continue;
               }
            }

            int var39;
            if(var10.contentType > 0) {
               var39 = var10.contentType;
               if(var39 == 324) {
                  if(Client.field1110 == -1) {
                     Client.field1110 = var10.spriteId;
                     Client.field1111 = var10.field2880;
                  }

                  if(Client.field1109.isFemale) {
                     var10.spriteId = Client.field1110;
                  } else {
                     var10.spriteId = Client.field1111;
                  }
               } else if(var39 == 325) {
                  if(Client.field1110 == -1) {
                     Client.field1110 = var10.spriteId;
                     Client.field1111 = var10.field2880;
                  }

                  if(Client.field1109.isFemale) {
                     var10.spriteId = Client.field1111;
                  } else {
                     var10.spriteId = Client.field1110;
                  }
               } else if(var39 == 327) {
                  var10.rotationX = 150;
                  var10.rotationZ = (int)(Math.sin((double)Client.gameCycle / 40.0D) * 256.0D) & 2047;
                  var10.modelType = 5;
                  var10.modelId = 0;
               } else if(var39 == 328) {
                  var10.rotationX = 150;
                  var10.rotationZ = (int)(Math.sin((double)Client.gameCycle / 40.0D) * 256.0D) & 2047;
                  var10.modelType = 5;
                  var10.modelId = 1;
               }
            }

            var39 = var10.relativeX + var6;
            int var13 = var7 + var10.relativeY;
            int var14 = var10.opacity;
            int var15;
            int var16;
            if(var10 == Client.draggedWidget) {
               if(var1 != -1412584499 && !var10.field2895) {
                  class2.field14 = var0;
                  ItemContainer.field746 = var6;
                  WorldComparator.field262 = var7;
                  continue;
               }

               if(Client.draggingWidget && Client.field1024) {
                  var15 = MouseInput.mouseLastX;
                  var16 = MouseInput.mouseLastY;
                  var15 -= Client.field1021;
                  var16 -= Client.field1015;
                  if(var15 < Client.field1025) {
                     var15 = Client.field1025;
                  }

                  if(var15 + var10.width > Client.field1025 + Client.field1020.width) {
                     var15 = Client.field1025 + Client.field1020.width - var10.width;
                  }

                  if(var16 < Client.field1098) {
                     var16 = Client.field1098;
                  }

                  if(var16 + var10.height > Client.field1098 + Client.field1020.height) {
                     var16 = Client.field1098 + Client.field1020.height - var10.height;
                  }

                  var39 = var15;
                  var13 = var16;
               }

               if(!var10.field2895) {
                  var14 = 128;
               }
            }

            int var17;
            int var18;
            int var20;
            int var21;
            int var22;
            int var30;
            if(var10.type == 2) {
               var15 = var2;
               var16 = var3;
               var17 = var4;
               var18 = var5;
            } else if(var10.type == 9) {
               var30 = var39;
               var20 = var13;
               var21 = var39 + var10.width;
               var22 = var13 + var10.height;
               if(var21 < var39) {
                  var30 = var21;
                  var21 = var39;
               }

               if(var22 < var13) {
                  var20 = var22;
                  var22 = var13;
               }

               ++var21;
               ++var22;
               var15 = var30 > var2?var30:var2;
               var16 = var20 > var3?var20:var3;
               var17 = var21 < var4?var21:var4;
               var18 = var22 < var5?var22:var5;
            } else {
               var30 = var39 + var10.width;
               var20 = var13 + var10.height;
               var15 = var39 > var2?var39:var2;
               var16 = var13 > var3?var13:var3;
               var17 = var30 < var4?var30:var4;
               var18 = var20 < var5?var20:var5;
            }

            if(!var10.hasScript || var15 < var17 && var16 < var18) {
               int var23;
               int var24;
               int var25;
               int var26;
               int var27;
               if(var10.contentType != 0) {
                  if(var10.contentType == 1336) {
                     if(Client.displayFps) {
                        var13 += 15;
                        class178.font_p12full.method5502("Fps:" + GameEngine.FPS, var39 + var10.width, var13, 16776960, -1);
                        var13 += 15;
                        Runtime var43 = Runtime.getRuntime();
                        var20 = (int)((var43.totalMemory() - var43.freeMemory()) / 1024L);
                        var21 = 16776960;
                        if(var20 > 327680 && !Client.lowMemory) {
                           var21 = 16711680;
                        }

                        class178.font_p12full.method5502("Mem:" + var20 + "k", var39 + var10.width, var13, var21, -1);
                        var13 += 15;
                     }
                     continue;
                  }

                  if(var10.contentType == 1337) {
                     Client.field1004 = var39;
                     Client.field1089 = var13;
                     ScriptVarType.method23(var39, var13, var10.width, var10.height);
                     Client.field1051[var10.boundsIndex] = true;
                     Rasterizer2D.setDrawRegion(var2, var3, var4, var5);
                     continue;
                  }

                  class236 var42;
                  if(var10.contentType == 1338) {
                     MapIcon.method588();
                     var42 = var10.method4470(false);
                     if(var42 != null) {
                        Rasterizer2D.setDrawRegion(var39, var13, var39 + var42.field2766, var13 + var42.field2767);
                        if(Client.field1003 != 2 && Client.field1003 != 5) {
                           var20 = Client.mapAngle & 2047;
                           var21 = WorldMapData.localPlayer.x / 32 + 48;
                           var22 = 464 - WorldMapData.localPlayer.y / 32;
                           GrandExchangeOffer.minimapSprite.method5862(var39, var13, var42.field2766, var42.field2767, var21, var22, var20, 256, var42.field2765, var42.field2764);

                           for(var23 = 0; var23 < Client.field1048; ++var23) {
                              var24 = Client.field1073[var23] * 4 + 2 - WorldMapData.localPlayer.x / 32;
                              var25 = Client.field861[var23] * 4 + 2 - WorldMapData.localPlayer.y / 32;
                              BoundingBox2D.drawDot(var39, var13, var24, var25, Client.mapIcons[var23], var42);
                           }

                           var23 = 0;

                           while(true) {
                              if(var23 >= 104) {
                                 for(var23 = 0; var23 < Client.npcIndexesCount; ++var23) {
                                    NPC var53 = Client.cachedNPCs[Client.npcIndices[var23]];
                                    if(var53 != null && var53.hasConfig()) {
                                       NPCComposition var47 = var53.composition;
                                       if(var47 != null && var47.configs != null) {
                                          var47 = var47.transform();
                                       }

                                       if(var47 != null && var47.isMinimapVisible && var47.field3738) {
                                          var26 = var53.x / 32 - WorldMapData.localPlayer.x / 32;
                                          var27 = var53.y / 32 - WorldMapData.localPlayer.y / 32;
                                          BoundingBox2D.drawDot(var39, var13, var26, var27, Tile.mapDots[1], var42);
                                       }
                                    }
                                 }

                                 var23 = class93.playerIndexesCount;
                                 int[] var54 = class93.playerIndices;

                                 for(var25 = 0; var25 < var23; ++var25) {
                                    Player var37 = Client.cachedPlayers[var54[var25]];
                                    if(var37 != null && var37.hasConfig() && !var37.hidden && var37 != WorldMapData.localPlayer) {
                                       var27 = var37.x / 32 - WorldMapData.localPlayer.x / 32;
                                       int var38 = var37.y / 32 - WorldMapData.localPlayer.y / 32;
                                       boolean var48 = false;
                                       if(WorldMapData.localPlayer.team != 0 && var37.team != 0 && var37.team == WorldMapData.localPlayer.team) {
                                          var48 = true;
                                       }

                                       if(var37.isFriend()) {
                                          BoundingBox2D.drawDot(var39, var13, var27, var38, Tile.mapDots[3], var42);
                                       } else if(var48) {
                                          BoundingBox2D.drawDot(var39, var13, var27, var38, Tile.mapDots[4], var42);
                                       } else if(var37.isClanMember()) {
                                          BoundingBox2D.drawDot(var39, var13, var27, var38, Tile.mapDots[5], var42);
                                       } else {
                                          BoundingBox2D.drawDot(var39, var13, var27, var38, Tile.mapDots[2], var42);
                                       }
                                    }
                                 }

                                 if(Client.hintArrowTargetType != 0 && Client.gameCycle % 20 < 10) {
                                    if(Client.hintArrowTargetType == 1 && Client.hintArrowNpcTargetIdx >= 0 && Client.hintArrowNpcTargetIdx < Client.cachedNPCs.length) {
                                       NPC var49 = Client.cachedNPCs[Client.hintArrowNpcTargetIdx];
                                       if(var49 != null) {
                                          var26 = var49.x / 32 - WorldMapData.localPlayer.x / 32;
                                          var27 = var49.y / 32 - WorldMapData.localPlayer.y / 32;
                                          class3.worldToMinimap(var39, var13, var26, var27, class62.mapMarkers[1], var42);
                                       }
                                    }

                                    if(Client.hintArrowTargetType == 2) {
                                       var25 = Client.hintArrowX * 4 - class38.baseX * 4 + 2 - WorldMapData.localPlayer.x / 32;
                                       var26 = Client.hintArrowY * 4 - PlayerComposition.baseY * 4 + 2 - WorldMapData.localPlayer.y / 32;
                                       class3.worldToMinimap(var39, var13, var25, var26, class62.mapMarkers[1], var42);
                                    }

                                    if(Client.hintArrowTargetType == 10 && Client.hintArrowPlayerTargetIdx >= 0 && Client.hintArrowPlayerTargetIdx < Client.cachedPlayers.length) {
                                       Player var50 = Client.cachedPlayers[Client.hintArrowPlayerTargetIdx];
                                       if(var50 != null) {
                                          var26 = var50.x / 32 - WorldMapData.localPlayer.x / 32;
                                          var27 = var50.y / 32 - WorldMapData.localPlayer.y / 32;
                                          class3.worldToMinimap(var39, var13, var26, var27, class62.mapMarkers[1], var42);
                                       }
                                    }
                                 }

                                 if(Client.destinationX != 0) {
                                    var25 = Client.destinationX * 4 + 2 - WorldMapData.localPlayer.x / 32;
                                    var26 = Client.destinationY * 4 + 2 - WorldMapData.localPlayer.y / 32;
                                    BoundingBox2D.drawDot(var39, var13, var25, var26, class62.mapMarkers[0], var42);
                                 }

                                 if(!WorldMapData.localPlayer.hidden) {
                                    Rasterizer2D.Rasterizer2D_fillRectangle(var42.field2766 / 2 + var39 - 1, var42.field2767 / 2 + var13 - 1, 3, 3, 16777215);
                                 }
                                 break;
                              }

                              for(var24 = 0; var24 < 104; ++var24) {
                                 Deque var31 = Client.groundItemDeque[Ignore.plane][var23][var24];
                                 if(var31 != null) {
                                    var26 = var23 * 4 + 2 - WorldMapData.localPlayer.x / 32;
                                    var27 = var24 * 4 + 2 - WorldMapData.localPlayer.y / 32;
                                    BoundingBox2D.drawDot(var39, var13, var26, var27, Tile.mapDots[0], var42);
                                 }
                              }

                              ++var23;
                           }
                        } else {
                           Rasterizer2D.method5746(var39, var13, 0, var42.field2765, var42.field2764);
                        }

                        Client.field904[var11] = true;
                     }

                     Rasterizer2D.setDrawRegion(var2, var3, var4, var5);
                     continue;
                  }

                  if(var10.contentType == 1339) {
                     var42 = var10.method4470(false);
                     if(var42 != null) {
                        if(Client.field1003 < 3) {
                           class23.compass.method5862(var39, var13, var42.field2766, var42.field2767, 25, 25, Client.mapAngle, 256, var42.field2765, var42.field2764);
                        } else {
                           Rasterizer2D.method5746(var39, var13, 0, var42.field2765, var42.field2764);
                        }
                     }

                     Rasterizer2D.setDrawRegion(var2, var3, var4, var5);
                     continue;
                  }

                  if(var10.contentType == 1400) {
                     class251.renderOverview.extractWorldmap(var39, var13, var10.width, var10.height, Client.gameCycle);
                  }

                  if(var10.contentType == 1401) {
                     class251.renderOverview.extractData(var39, var13, var10.width, var10.height);
                  }
               }

               boolean var46;
               if(var10.type == 0) {
                  if(!var10.hasScript) {
                     var46 = var10.isHidden;
                     if(var46 && var10 != class28.field377) {
                        continue;
                     }
                  }

                  if(!var10.hasScript) {
                     if(var10.scrollY > var10.scrollHeight - var10.height) {
                        var10.scrollY = var10.scrollHeight - var10.height;
                     }

                     if(var10.scrollY < 0) {
                        var10.scrollY = 0;
                     }
                  }

                  gameDraw(var0, var10.id, var15, var16, var17, var18, var39 - var10.scrollX, var13 - var10.scrollY, var11);
                  if(var10.children != null) {
                     gameDraw(var10.children, var10.id, var15, var16, var17, var18, var39 - var10.scrollX, var13 - var10.scrollY, var11);
                  }

                  WidgetNode var19 = (WidgetNode)Client.componentTable.get((long)var10.id);
                  if(var19 != null) {
                     FontName.method5473(var19.id, var15, var16, var17, var18, var39, var13, var11);
                  }

                  Rasterizer2D.setDrawRegion(var2, var3, var4, var5);
                  Graphics3D.Rasterizer3D_method1();
               }

               if(Client.isResized || Client.field1053[var11] || Client.gameDrawingMode > 1) {
                  if(var10.type == 0 && !var10.hasScript && var10.scrollHeight > var10.height) {
                     BaseVarType.method13(var39 + var10.width, var13, var10.scrollY, var10.height, var10.scrollHeight);
                  }

                  if(var10.type != 1) {
                     if(var10.type == 2) {
                        var30 = 0;

                        for(var20 = 0; var20 < var10.originalHeight; ++var20) {
                           for(var21 = 0; var21 < var10.originalWidth; ++var21) {
                              var22 = var39 + var21 * (var10.paddingX + 32);
                              var23 = var13 + var20 * (var10.paddingY + 32);
                              if(var30 < 20) {
                                 var22 += var10.xSprites[var30];
                                 var23 += var10.field2886[var30];
                              }

                              if(var10.itemIds[var30] <= 0) {
                                 if(var10.field2887 != null && var30 < 20) {
                                    SpritePixels var52 = var10.method4468(var30);
                                    if(var52 != null) {
                                       var52.drawAt(var22, var23);
                                    } else if(Widget.field2885) {
                                       GameEngine.method1053(var10);
                                    }
                                 }
                              } else {
                                 boolean var44 = false;
                                 boolean var45 = false;
                                 var26 = var10.itemIds[var30] - 1;
                                 if(var22 + 32 > var2 && var22 < var4 && var23 + 32 > var3 && var23 < var5 || var10 == MapIconReference.field574 && var30 == Client.field998) {
                                    SpritePixels var36;
                                    if(Client.itemSelectionState == 1 && var30 == class271.selectedItemIndex && var10.id == SoundTaskDataProvider.field619) {
                                       var36 = class25.createSprite(var26, var10.itemQuantities[var30], 2, 0, 2, false);
                                    } else {
                                       var36 = class25.createSprite(var26, var10.itemQuantities[var30], 1, 3153952, 2, false);
                                    }

                                    if(var36 != null) {
                                       if(var10 == MapIconReference.field574 && var30 == Client.field998) {
                                          var24 = MouseInput.mouseLastX - Client.field957;
                                          var25 = MouseInput.mouseLastY - Client.field958;
                                          if(var24 < 5 && var24 > -5) {
                                             var24 = 0;
                                          }

                                          if(var25 < 5 && var25 > -5) {
                                             var25 = 0;
                                          }

                                          if(Client.itemPressedDuration < 5) {
                                             var24 = 0;
                                             var25 = 0;
                                          }

                                          var36.drawAtOpacity(var24 + var22, var23 + var25, 128);
                                          if(var1 != -1) {
                                             Widget var28 = var0[var1 & 65535];
                                             int var29;
                                             if(var23 + var25 < Rasterizer2D.drawingAreaTop && var28.scrollY > 0) {
                                                var29 = (Rasterizer2D.drawingAreaTop - var23 - var25) * Client.field910 / 3;
                                                if(var29 > Client.field910 * 10) {
                                                   var29 = Client.field910 * 10;
                                                }

                                                if(var29 > var28.scrollY) {
                                                   var29 = var28.scrollY;
                                                }

                                                var28.scrollY -= var29;
                                                Client.field958 += var29;
                                                GameEngine.method1053(var28);
                                             }

                                             if(var23 + var25 + 32 > Rasterizer2D.drawingAreaRight && var28.scrollY < var28.scrollHeight - var28.height) {
                                                var29 = (var23 + var25 + 32 - Rasterizer2D.drawingAreaRight) * Client.field910 / 3;
                                                if(var29 > Client.field910 * 10) {
                                                   var29 = Client.field910 * 10;
                                                }

                                                if(var29 > var28.scrollHeight - var28.height - var28.scrollY) {
                                                   var29 = var28.scrollHeight - var28.height - var28.scrollY;
                                                }

                                                var28.scrollY += var29;
                                                Client.field958 -= var29;
                                                GameEngine.method1053(var28);
                                             }
                                          }
                                       } else if(var10 == MouseRecorder.field797 && var30 == Client.pressedItemIndex) {
                                          var36.drawAtOpacity(var22, var23, 128);
                                       } else {
                                          var36.drawAt(var22, var23);
                                       }
                                    } else {
                                       GameEngine.method1053(var10);
                                    }
                                 }
                              }

                              ++var30;
                           }
                        }
                     } else if(var10.type == 3) {
                        if(class57.method887(var10)) {
                           var30 = var10.field2879;
                           if(var10 == class28.field377 && var10.field2893 != 0) {
                              var30 = var10.field2893;
                           }
                        } else {
                           var30 = var10.textColor;
                           if(var10 == class28.field377 && var10.field2844 != 0) {
                              var30 = var10.field2844;
                           }
                        }

                        if(var10.filled) {
                           switch(var10.field2808.field3972) {
                           case 1:
                              Rasterizer2D.method5714(var39, var13, var10.width, var10.height, var10.textColor, var10.field2879, 256 - (var10.opacity & 255), 256 - (var10.field2952 & 255));
                              break;
                           case 2:
                              Rasterizer2D.method5711(var39, var13, var10.width, var10.height, var10.textColor, var10.field2879, 256 - (var10.opacity & 255), 256 - (var10.field2952 & 255));
                              break;
                           case 3:
                              Rasterizer2D.method5712(var39, var13, var10.width, var10.height, var10.textColor, var10.field2879, 256 - (var10.opacity & 255), 256 - (var10.field2952 & 255));
                              break;
                           case 4:
                              Rasterizer2D.method5713(var39, var13, var10.width, var10.height, var10.textColor, var10.field2879, 256 - (var10.opacity & 255), 256 - (var10.field2952 & 255));
                              break;
                           default:
                              if(var14 == 0) {
                                 Rasterizer2D.Rasterizer2D_fillRectangle(var39, var13, var10.width, var10.height, var30);
                              } else {
                                 Rasterizer2D.fillRectangle(var39, var13, var10.width, var10.height, var30, 256 - (var14 & 255));
                              }
                           }
                        } else if(var14 == 0) {
                           Rasterizer2D.drawRectangle(var39, var13, var10.width, var10.height, var30);
                        } else {
                           Rasterizer2D.Rasterizer2D_drawRectangleAlpha(var39, var13, var10.width, var10.height, var30, 256 - (var14 & 255));
                        }
                     } else {
                        Font var40;
                        if(var10.type == 4) {
                           var40 = var10.getFont();
                           if(var40 == null) {
                              if(Widget.field2885) {
                                 GameEngine.method1053(var10);
                              }
                           } else {
                              String var56 = var10.text;
                              if(class57.method887(var10)) {
                                 var20 = var10.field2879;
                                 if(var10 == class28.field377 && var10.field2893 != 0) {
                                    var20 = var10.field2893;
                                 }

                                 if(var10.string1.length() > 0) {
                                    var56 = var10.string1;
                                 }
                              } else {
                                 var20 = var10.textColor;
                                 if(var10 == class28.field377 && var10.field2844 != 0) {
                                    var20 = var10.field2844;
                                 }
                              }

                              if(var10.hasScript && var10.itemId != -1) {
                                 ItemComposition var57 = class81.getItemDefinition(var10.itemId);
                                 var56 = var57.name;
                                 if(var56 == null) {
                                    var56 = "null";
                                 }

                                 if((var57.isStackable == 1 || var10.itemQuantity != 1) && var10.itemQuantity != -1) {
                                    var56 = class37.getColTags(16748608) + var56 + "</col>" + " " + 'x' + class36.method537(var10.itemQuantity);
                                 }
                              }

                              if(var10 == Client.field1012) {
                                 var56 = "Please wait...";
                                 var20 = var10.textColor;
                              }

                              if(!var10.hasScript) {
                                 var56 = World.method1709(var56, var10);
                              }

                              var40.method5504(var56, var39, var13, var10.width, var10.height, var20, var10.textShadowed?0:-1, var10.field2827, var10.field2881, var10.field2813);
                           }
                        } else if(var10.type == 5) {
                           SpritePixels var41;
                           if(!var10.hasScript) {
                              var41 = var10.method4481(class57.method887(var10));
                              if(var41 != null) {
                                 var41.drawAt(var39, var13);
                              } else if(Widget.field2885) {
                                 GameEngine.method1053(var10);
                              }
                           } else {
                              if(var10.itemId != -1) {
                                 var41 = class25.createSprite(var10.itemId, var10.itemQuantity, var10.borderThickness, var10.sprite2, var10.field2864, false);
                              } else {
                                 var41 = var10.method4481(false);
                              }

                              if(var41 == null) {
                                 if(Widget.field2885) {
                                    GameEngine.method1053(var10);
                                 }
                              } else {
                                 var20 = var41.maxWidth;
                                 var21 = var41.maxHeight;
                                 if(!var10.spriteTiling) {
                                    var22 = var10.width * 4096 / var20;
                                    if(var10.textureId != 0) {
                                       var41.method5861(var10.width / 2 + var39, var10.height / 2 + var13, var10.textureId, var22);
                                    } else if(var14 != 0) {
                                       var41.method5850(var39, var13, var10.width, var10.height, 256 - (var14 & 255));
                                    } else if(var20 == var10.width && var21 == var10.height) {
                                       var41.drawAt(var39, var13);
                                    } else {
                                       var41.method5844(var39, var13, var10.width, var10.height);
                                    }
                                 } else {
                                    Rasterizer2D.setInnerDrawRegion(var39, var13, var39 + var10.width, var13 + var10.height);
                                    var22 = (var20 - 1 + var10.width) / var20;
                                    var23 = (var21 - 1 + var10.height) / var21;

                                    for(var24 = 0; var24 < var22; ++var24) {
                                       for(var25 = 0; var25 < var23; ++var25) {
                                          if(var10.textureId != 0) {
                                             var41.method5861(var20 / 2 + var39 + var24 * var20, var21 / 2 + var13 + var25 * var21, var10.textureId, 4096);
                                          } else if(var14 != 0) {
                                             var41.drawAtOpacity(var39 + var24 * var20, var13 + var25 * var21, 256 - (var14 & 255));
                                          } else {
                                             var41.drawAt(var39 + var20 * var24, var13 + var25 * var21);
                                          }
                                       }
                                    }

                                    Rasterizer2D.setDrawRegion(var2, var3, var4, var5);
                                 }
                              }
                           }
                        } else {
                           ItemComposition var35;
                           if(var10.type == 6) {
                              var46 = class57.method887(var10);
                              if(var46) {
                                 var20 = var10.field2865;
                              } else {
                                 var20 = var10.field2838;
                              }

                              Model var51 = null;
                              var22 = 0;
                              if(var10.itemId != -1) {
                                 var35 = class81.getItemDefinition(var10.itemId);
                                 if(var35 != null) {
                                    var35 = var35.method5049(var10.itemQuantity);
                                    var51 = var35.getModel(1);
                                    if(var51 != null) {
                                       var51.calculateBoundsCylinder();
                                       var22 = var51.modelHeight / 2;
                                    } else {
                                       GameEngine.method1053(var10);
                                    }
                                 }
                              } else if(var10.modelType == 5) {
                                 if(var10.modelId == 0) {
                                    var51 = Client.field1109.getModel((Sequence)null, -1, (Sequence)null, -1);
                                 } else {
                                    var51 = WorldMapData.localPlayer.getModel();
                                 }
                              } else if(var20 == -1) {
                                 var51 = var10.getModel((Sequence)null, -1, var46, WorldMapData.localPlayer.composition);
                                 if(var51 == null && Widget.field2885) {
                                    GameEngine.method1053(var10);
                                 }
                              } else {
                                 Sequence var58 = class158.getAnimation(var20);
                                 var51 = var10.getModel(var58, var10.field2939, var46, WorldMapData.localPlayer.composition);
                                 if(var51 == null && Widget.field2885) {
                                    GameEngine.method1053(var10);
                                 }
                              }

                              Graphics3D.method2780(var10.width / 2 + var39, var10.height / 2 + var13);
                              var23 = Graphics3D.SINE[var10.rotationX] * var10.modelZoom >> 16;
                              var24 = Graphics3D.COSINE[var10.rotationX] * var10.modelZoom >> 16;
                              if(var51 != null) {
                                 if(!var10.hasScript) {
                                    var51.method2702(0, var10.rotationZ, 0, var10.rotationX, 0, var23, var24);
                                 } else {
                                    var51.calculateBoundsCylinder();
                                    if(var10.field2874) {
                                       var51.method2703(0, var10.rotationZ, var10.rotationY, var10.rotationX, var10.field2866, var22 + var23 + var10.field2867, var24 + var10.field2867, var10.modelZoom);
                                    } else {
                                       var51.method2702(0, var10.rotationZ, var10.rotationY, var10.rotationX, var10.field2866, var22 + var23 + var10.field2867, var24 + var10.field2867);
                                    }
                                 }
                              }

                              Graphics3D.Rasterizer3D_method3();
                           } else {
                              if(var10.type == 7) {
                                 var40 = var10.getFont();
                                 if(var40 == null) {
                                    if(Widget.field2885) {
                                       GameEngine.method1053(var10);
                                    }
                                    continue;
                                 }

                                 var20 = 0;

                                 for(var21 = 0; var21 < var10.originalHeight; ++var21) {
                                    for(var22 = 0; var22 < var10.originalWidth; ++var22) {
                                       if(var10.itemIds[var20] > 0) {
                                          var35 = class81.getItemDefinition(var10.itemIds[var20] - 1);
                                          String var32;
                                          if(var35.isStackable != 1 && var10.itemQuantities[var20] == 1) {
                                             var32 = class37.getColTags(16748608) + var35.name + "</col>";
                                          } else {
                                             var32 = class37.getColTags(16748608) + var35.name + "</col>" + " " + 'x' + class36.method537(var10.itemQuantities[var20]);
                                          }

                                          var25 = var22 * (var10.paddingX + 115) + var39;
                                          var26 = (var10.paddingY + 12) * var21 + var13;
                                          if(var10.field2827 == 0) {
                                             var40.method5500(var32, var25, var26, var10.textColor, var10.textShadowed?0:-1);
                                          } else if(var10.field2827 == 1) {
                                             var40.drawTextCentered(var32, var10.width / 2 + var25, var26, var10.textColor, var10.textShadowed?0:-1);
                                          } else {
                                             var40.method5502(var32, var25 + var10.width - 1, var26, var10.textColor, var10.textShadowed?0:-1);
                                          }
                                       }

                                       ++var20;
                                    }
                                 }
                              }

                              if(var10.type == 8 && var10 == field3371 && Client.field999 == Client.field1000) {
                                 var30 = 0;
                                 var20 = 0;
                                 Font var33 = class178.font_p12full;
                                 String var34 = var10.text;

                                 String var55;
                                 for(var34 = World.method1709(var34, var10); var34.length() > 0; var20 = var20 + var33.verticalSpace + 1) {
                                    var24 = var34.indexOf("<br>");
                                    if(var24 != -1) {
                                       var55 = var34.substring(0, var24);
                                       var34 = var34.substring(var24 + 4);
                                    } else {
                                       var55 = var34;
                                       var34 = "";
                                    }

                                    var25 = var33.getTextWidth(var55);
                                    if(var25 > var30) {
                                       var30 = var25;
                                    }
                                 }

                                 var30 += 6;
                                 var20 += 7;
                                 var24 = var39 + var10.width - 5 - var30;
                                 var25 = var13 + var10.height + 5;
                                 if(var24 < var39 + 5) {
                                    var24 = var39 + 5;
                                 }

                                 if(var30 + var24 > var4) {
                                    var24 = var4 - var30;
                                 }

                                 if(var20 + var25 > var5) {
                                    var25 = var5 - var20;
                                 }

                                 Rasterizer2D.Rasterizer2D_fillRectangle(var24, var25, var30, var20, 16777120);
                                 Rasterizer2D.drawRectangle(var24, var25, var30, var20, 0);
                                 var34 = var10.text;
                                 var26 = var25 + var33.verticalSpace + 2;

                                 for(var34 = World.method1709(var34, var10); var34.length() > 0; var26 = var26 + var33.verticalSpace + 1) {
                                    var27 = var34.indexOf("<br>");
                                    if(var27 != -1) {
                                       var55 = var34.substring(0, var27);
                                       var34 = var34.substring(var27 + 4);
                                    } else {
                                       var55 = var34;
                                       var34 = "";
                                    }

                                    var33.method5500(var55, var24 + 3, var26, 0, -1);
                                 }
                              }

                              if(var10.type == 9) {
                                 if(var10.field2851) {
                                    var30 = var39;
                                    var20 = var13 + var10.height;
                                    var21 = var39 + var10.width;
                                    var22 = var13;
                                 } else {
                                    var30 = var39;
                                    var20 = var13;
                                    var21 = var39 + var10.width;
                                    var22 = var13 + var10.height;
                                 }

                                 if(var10.lineWidth == 1) {
                                    Rasterizer2D.drawLine(var30, var20, var21, var22, var10.textColor);
                                 } else {
                                    IndexDataBase.method4579(var30, var20, var21, var22, var10.textColor, var10.lineWidth);
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
