import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("m")
final class class2 implements class0 {
   @ObfuscatedName("po")
   @ObfuscatedGetter(
      intValue = 1965558467
   )
   static int field10;
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Lir;"
   )
   static IndexDataBase field9;
   @ObfuscatedName("ex")
   @ObfuscatedSignature(
      signature = "Lkp;"
   )
   @Export("fontPlain11")
   static Font fontPlain11;
   @ObfuscatedName("fz")
   static byte[][] field13;

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(IIB)I",
      garbageValue = "50"
   )
   static int method3(int var0, int var1) {
      Overlay var2 = class153.getOverlayDefinition(var0);
      if(var2 == null) {
         return var1;
      } else if(var2.otherRgbColor >= 0) {
         return var2.otherRgbColor | -16777216;
      } else {
         int var4;
         int var5;
         if(var2.texture >= 0) {
            var4 = Graphics3D.textureLoader.getAverageTextureRGB(var2.texture);
            byte var9 = 96;
            int var3;
            if(var4 == -2) {
               var3 = 12345678;
            } else if(var4 == -1) {
               if(var9 < 0) {
                  var9 = 0;
               } else if(var9 > 127) {
                  var9 = 127;
               }

               var5 = 127 - var9;
               var3 = var5;
            } else {
               var5 = var9 * (var4 & 127) / 128;
               if(var5 < 2) {
                  var5 = 2;
               } else if(var5 > 126) {
                  var5 = 126;
               }

               var3 = var5 + (var4 & 65408);
            }

            return Graphics3D.colorPalette[var3] | -16777216;
         } else if(var2.color == 16711935) {
            return var1;
         } else {
            var4 = var2.hue;
            var5 = var2.saturation;
            int var6 = var2.lightness;
            if(var6 > 179) {
               var5 /= 2;
            }

            if(var6 > 192) {
               var5 /= 2;
            }

            if(var6 > 217) {
               var5 /= 2;
            }

            if(var6 > 243) {
               var5 /= 2;
            }

            int var7 = (var5 / 32 << 7) + var6 / 2 + (var4 / 4 << 10);
            int var8 = class28.method239(var7, 96);
            return Graphics3D.colorPalette[var8] | -16777216;
         }
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "1600584303"
   )
   static int method4(int var0, int var1) {
      ItemContainer var2 = (ItemContainer)ItemContainer.itemContainers.get((long)var0);
      return var2 == null?0:(var1 >= 0 && var1 < var2.stackSizes.length?var2.stackSizes[var1]:0);
   }

   @ObfuscatedName("ih")
   @ObfuscatedSignature(
      signature = "([Lhs;IIIIIIIII)V",
      garbageValue = "1821831370"
   )
   @Export("gameDraw")
   static final void gameDraw(Widget[] var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
      Rasterizer2D.setDrawRegion(var2, var3, var4, var5);
      Graphics3D.Rasterizer3D_method1();

      for(int var9 = 0; var9 < var0.length; ++var9) {
         Widget var10 = var0[var9];
         if(var10 != null && (var10.parentId == var1 || var1 == -1412584499 && var10 == Client.field940)) {
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
            if(!var10.hasScript || !ContextMenuRow.method1877(var10)) {
               int var12;
               if(var10.contentType > 0) {
                  var12 = var10.contentType;
                  if(var12 == 324) {
                     if(Client.field850 == -1) {
                        Client.field850 = var10.spriteId;
                        Client.field1089 = var10.field2790;
                     }

                     if(Client.field1087.isFemale) {
                        var10.spriteId = Client.field850;
                     } else {
                        var10.spriteId = Client.field1089;
                     }
                  } else if(var12 == 325) {
                     if(Client.field850 == -1) {
                        Client.field850 = var10.spriteId;
                        Client.field1089 = var10.field2790;
                     }

                     if(Client.field1087.isFemale) {
                        var10.spriteId = Client.field1089;
                     } else {
                        var10.spriteId = Client.field850;
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
               if(var10 == Client.field940) {
                  if(var1 != -1412584499 && !var10.field2819) {
                     GameCanvas.field628 = var0;
                     InvType.field3363 = var6;
                     WorldComparator.field268 = var7;
                     continue;
                  }

                  if(Client.field1008 && Client.field1002) {
                     var15 = MouseInput.mouseLastX;
                     var16 = MouseInput.mouseLastY;
                     var15 -= Client.field999;
                     var16 -= Client.field921;
                     if(var15 < Client.field856) {
                        var15 = Client.field856;
                     }

                     if(var15 + var10.width > Client.field856 + Client.field930.width) {
                        var15 = Client.field856 + Client.field930.width - var10.width;
                     }

                     if(var16 < Client.field1070) {
                        var16 = Client.field1070;
                     }

                     if(var16 + var10.height > Client.field1070 + Client.field930.height) {
                        var16 = Client.field1070 + Client.field930.height - var10.height;
                     }

                     var12 = var15;
                     var13 = var16;
                  }

                  if(!var10.field2819) {
                     var14 = 128;
                  }
               }

               int var17;
               int var18;
               int var20;
               int var21;
               int var22;
               int var46;
               if(var10.type == 2) {
                  var15 = var2;
                  var16 = var3;
                  var17 = var4;
                  var18 = var5;
               } else if(var10.type == 9) {
                  var46 = var12;
                  var20 = var13;
                  var21 = var12 + var10.width;
                  var22 = var13 + var10.height;
                  if(var21 < var12) {
                     var46 = var21;
                     var21 = var12;
                  }

                  if(var22 < var13) {
                     var20 = var22;
                     var22 = var13;
                  }

                  ++var21;
                  ++var22;
                  var15 = var46 > var2?var46:var2;
                  var16 = var20 > var3?var20:var3;
                  var17 = var21 < var4?var21:var4;
                  var18 = var22 < var5?var22:var5;
               } else {
                  var46 = var12 + var10.width;
                  var20 = var13 + var10.height;
                  var15 = var12 > var2?var12:var2;
                  var16 = var13 > var3?var13:var3;
                  var17 = var46 < var4?var46:var4;
                  var18 = var20 < var5?var20:var5;
               }

               if(!var10.hasScript || var15 < var17 && var16 < var18) {
                  int var24;
                  int var25;
                  int var26;
                  int var29;
                  int var47;
                  int var50;
                  if(var10.contentType != 0) {
                     if(var10.contentType == 1336) {
                        if(Client.displayFps) {
                           var13 += 15;
                           TextureProvider.font_p12full.method5412("Fps:" + GameEngine.FPS, var12 + var10.width, var13, 16776960, -1);
                           var13 += 15;
                           Runtime var60 = Runtime.getRuntime();
                           var20 = (int)((var60.totalMemory() - var60.freeMemory()) / 1024L);
                           var21 = 16776960;
                           if(var20 > 32768 && Client.lowMemory) {
                              var21 = 16711680;
                           }

                           if(var20 > 65536 && !Client.lowMemory) {
                              var21 = 16711680;
                           }

                           TextureProvider.font_p12full.method5412("Mem:" + var20 + "k", var12 + var10.width, var13, var21, -1);
                           var13 += 15;
                        }
                        continue;
                     }

                     int var51;
                     if(var10.contentType == 1337) {
                        Client.field973 = var12;
                        Client.field974 = var13;
                        var21 = var10.width;
                        var22 = var10.height;
                        ++Client.field928;
                        if(GroundObject.localPlayer.x >> 7 == Client.destinationX && GroundObject.localPlayer.y >> 7 == Client.destinationY) {
                           Client.destinationX = 0;
                        }

                        class214.method4127(GroundObject.localPlayer, false);
                        MessageNode.method1111();
                        class159.method3257(true);
                        class153.method3203();
                        class159.method3257(false);
                        class89.method1939();

                        for(GraphicsObject var63 = (GraphicsObject)Client.graphicsObjectDeque.getFront(); var63 != null; var63 = (GraphicsObject)Client.graphicsObjectDeque.getNext()) {
                           if(var63.level == class60.plane && !var63.finished) {
                              if(Client.gameCycle >= var63.startCycle) {
                                 var63.method1829(Client.field1091);
                                 if(var63.finished) {
                                    var63.unlink();
                                 } else {
                                    TotalQuantityComparator.region.method2915(var63.level, var63.x, var63.y, var63.height, 60, var63, 0, -1, false);
                                 }
                              }
                           } else {
                              var63.unlink();
                           }
                        }

                        BoundingBox2D.method38(var12, var13, var21, var22, true);
                        var46 = Client.Viewport_xOffset;
                        var20 = Client.Viewport_yOffset;
                        var21 = Client.viewportWidth;
                        var22 = Client.viewportHeight;
                        Rasterizer2D.setDrawRegion(var46, var20, var46 + var21, var20 + var22);
                        Graphics3D.Rasterizer3D_method1();
                        if(!Client.field1068) {
                           var47 = Client.field907;
                           if(Client.field916 / 256 > var47) {
                              var47 = Client.field916 / 256;
                           }

                           if(Client.field1069[4] && Client.field932[4] + 128 > var47) {
                              var47 = Client.field932[4] + 128;
                           }

                           var24 = Client.mapAngle & 2047;
                           SoundTaskDataProvider.method738(MouseRecorder.field789, MessageNode.getTileHeight(GroundObject.localPlayer.x, GroundObject.localPlayer.y, class60.plane) - Client.field1061, class5.field27, var47, var24, var47 * 3 + 600);
                        }

                        if(!Client.field1068) {
                           var47 = GrandExchangeEvent.method88();
                        } else {
                           var47 = World.method1659();
                        }

                        var24 = class89.cameraX;
                        var25 = class216.cameraZ;
                        var26 = class3.cameraY;
                        var50 = ScriptEvent.cameraPitch;
                        var51 = class80.cameraYaw;

                        int var30;
                        for(var29 = 0; var29 < 5; ++var29) {
                           if(Client.field1069[var29]) {
                              var30 = (int)(Math.random() * (double)(Client.field998[var29] * 2 + 1) - (double)Client.field998[var29] + Math.sin((double)Client.field1073[var29] * ((double)Client.field1072[var29] / 100.0D)) * (double)Client.field932[var29]);
                              if(var29 == 0) {
                                 class89.cameraX += var30;
                              }

                              if(var29 == 1) {
                                 class216.cameraZ += var30;
                              }

                              if(var29 == 2) {
                                 class3.cameraY += var30;
                              }

                              if(var29 == 3) {
                                 class80.cameraYaw = var30 + class80.cameraYaw & 2047;
                              }

                              if(var29 == 4) {
                                 ScriptEvent.cameraPitch += var30;
                                 if(ScriptEvent.cameraPitch < 128) {
                                    ScriptEvent.cameraPitch = 128;
                                 }

                                 if(ScriptEvent.cameraPitch > 383) {
                                    ScriptEvent.cameraPitch = 383;
                                 }
                              }
                           }
                        }

                        var29 = MouseInput.mouseLastX;
                        var30 = MouseInput.mouseLastY;
                        if(MouseInput.mouseLastButton != 0) {
                           var29 = MouseInput.mouseLastPressedX;
                           var30 = MouseInput.mouseLastPressedY;
                        }

                        int var31;
                        if(var29 >= var46 && var29 < var46 + var21 && var30 >= var20 && var30 < var22 + var20) {
                           var31 = var29 - var46;
                           int var32 = var30 - var20;
                           class131.Viewport_mouseX = var31;
                           class131.Viewport_mouseY = var32;
                           class131.Viewport_containsMouse = true;
                           class131.Viewport_entityCountAtMouse = 0;
                           class131.Viewport_false0 = false;
                        } else {
                           class21.method161();
                        }

                        class186.method3767();
                        Rasterizer2D.Rasterizer2D_fillRectangle(var46, var20, var21, var22, 0);
                        class186.method3767();
                        var31 = Graphics3D.Rasterizer3D_zoom;
                        Graphics3D.Rasterizer3D_zoom = Client.scale;
                        TotalQuantityComparator.region.draw(class89.cameraX, class216.cameraZ, class3.cameraY, ScriptEvent.cameraPitch, class80.cameraYaw, var47);
                        OwnWorldComparator.method1166();
                        Graphics3D.Rasterizer3D_zoom = var31;
                        class186.method3767();
                        TotalQuantityComparator.region.clearEntities();
                        Client.overheadTextCount = 0;
                        boolean var66 = false;
                        int var33 = -1;
                        int var34 = class92.playerIndexesCount;
                        int[] var35 = class92.playerIndices;

                        int var36;
                        for(var36 = 0; var36 < var34 + Client.npcIndexesCount; ++var36) {
                           Object var37;
                           if(var36 < var34) {
                              var37 = Client.cachedPlayers[var35[var36]];
                              if(var35[var36] == Client.field953) {
                                 var66 = true;
                                 var33 = var36;
                                 continue;
                              }
                           } else {
                              var37 = Client.cachedNPCs[Client.npcIndices[var36 - var34]];
                           }

                           BaseVarType.draw2DExtras((Actor)var37, var36, var46, var20, var21, var22);
                        }

                        if(var66) {
                           BaseVarType.draw2DExtras(Client.cachedPlayers[Client.field953], var33, var46, var20, var21, var22);
                        }

                        for(var36 = 0; var36 < Client.overheadTextCount; ++var36) {
                           int var55 = Client.overheadTextsX[var36];
                           int var38 = Client.overheadTextsY[var36];
                           int var39 = Client.overheadTextsOffsetX[var36];
                           int var40 = Client.overheadTextsOffsetY[var36];
                           boolean var41 = true;

                           while(var41) {
                              var41 = false;

                              for(int var42 = 0; var42 < var36; ++var42) {
                                 if(var38 + 2 > Client.overheadTextsY[var42] - Client.overheadTextsOffsetY[var42] && var38 - var40 < Client.overheadTextsY[var42] + 2 && var55 - var39 < Client.overheadTextsX[var42] + Client.overheadTextsOffsetX[var42] && var55 + var39 > Client.overheadTextsX[var42] - Client.overheadTextsOffsetX[var42] && Client.overheadTextsY[var42] - Client.overheadTextsOffsetY[var42] < var38) {
                                    var38 = Client.overheadTextsY[var42] - Client.overheadTextsOffsetY[var42];
                                    var41 = true;
                                 }
                              }
                           }

                           Client.screenX = Client.overheadTextsX[var36];
                           Client.screenY = Client.overheadTextsY[var36] = var38;
                           String var56 = Client.overheadTexts[var36];
                           if(Client.field986 == 0) {
                              int var43 = 16776960;
                              if(Client.field1080[var36] < 6) {
                                 var43 = Client.field1039[Client.field1080[var36]];
                              }

                              if(Client.field1080[var36] == 6) {
                                 var43 = Client.field928 % 20 < 10?16711680:16776960;
                              }

                              if(Client.field1080[var36] == 7) {
                                 var43 = Client.field928 % 20 < 10?255:'\uffff';
                              }

                              if(Client.field1080[var36] == 8) {
                                 var43 = Client.field928 % 20 < 10?'뀀':8454016;
                              }

                              int var44;
                              if(Client.field1080[var36] == 9) {
                                 var44 = 150 - Client.overheadTextsCyclesRemaining[var36];
                                 if(var44 < 50) {
                                    var43 = var44 * 1280 + 16711680;
                                 } else if(var44 < 100) {
                                    var43 = 16776960 - (var44 - 50) * 327680;
                                 } else if(var44 < 150) {
                                    var43 = (var44 - 100) * 5 + 65280;
                                 }
                              }

                              if(Client.field1080[var36] == 10) {
                                 var44 = 150 - Client.overheadTextsCyclesRemaining[var36];
                                 if(var44 < 50) {
                                    var43 = var44 * 5 + 16711680;
                                 } else if(var44 < 100) {
                                    var43 = 16711935 - (var44 - 50) * 327680;
                                 } else if(var44 < 150) {
                                    var43 = (var44 - 100) * 327680 + 255 - (var44 - 100) * 5;
                                 }
                              }

                              if(Client.field1080[var36] == 11) {
                                 var44 = 150 - Client.overheadTextsCyclesRemaining[var36];
                                 if(var44 < 50) {
                                    var43 = 16777215 - var44 * 327685;
                                 } else if(var44 < 100) {
                                    var43 = (var44 - 50) * 327685 + 65280;
                                 } else if(var44 < 150) {
                                    var43 = 16777215 - (var44 - 100) * 327680;
                                 }
                              }

                              if(Client.field924[var36] == 0) {
                                 IndexDataBase.fontBold12.drawTextCentered(var56, var46 + Client.screenX, var20 + Client.screenY, var43, 0);
                              }

                              if(Client.field924[var36] == 1) {
                                 IndexDataBase.fontBold12.method5364(var56, var46 + Client.screenX, var20 + Client.screenY, var43, 0, Client.field928);
                              }

                              if(Client.field924[var36] == 2) {
                                 IndexDataBase.fontBold12.method5372(var56, var46 + Client.screenX, var20 + Client.screenY, var43, 0, Client.field928);
                              }

                              if(Client.field924[var36] == 3) {
                                 IndexDataBase.fontBold12.method5379(var56, var46 + Client.screenX, var20 + Client.screenY, var43, 0, Client.field928, 150 - Client.overheadTextsCyclesRemaining[var36]);
                              }

                              if(Client.field924[var36] == 4) {
                                 var44 = (150 - Client.overheadTextsCyclesRemaining[var36]) * (IndexDataBase.fontBold12.getTextWidth(var56) + 100) / 150;
                                 Rasterizer2D.setInnerDrawRegion(var46 + Client.screenX - 50, var20, var46 + Client.screenX + 50, var20 + var22);
                                 IndexDataBase.fontBold12.method5384(var56, var46 + Client.screenX + 50 - var44, var20 + Client.screenY, var43, 0);
                                 Rasterizer2D.setDrawRegion(var46, var20, var21 + var46, var22 + var20);
                              }

                              if(Client.field924[var36] == 5) {
                                 var44 = 150 - Client.overheadTextsCyclesRemaining[var36];
                                 int var45 = 0;
                                 if(var44 < 25) {
                                    var45 = var44 - 25;
                                 } else if(var44 > 125) {
                                    var45 = var44 - 125;
                                 }

                                 Rasterizer2D.setInnerDrawRegion(var46, var20 + Client.screenY - IndexDataBase.fontBold12.verticalSpace - 1, var46 + var21, var20 + Client.screenY + 5);
                                 IndexDataBase.fontBold12.drawTextCentered(var56, var46 + Client.screenX, var45 + var20 + Client.screenY, var43, 0);
                                 Rasterizer2D.setDrawRegion(var46, var20, var21 + var46, var20 + var22);
                              }
                           } else {
                              IndexDataBase.fontBold12.drawTextCentered(var56, var46 + Client.screenX, var20 + Client.screenY, 16776960, 0);
                           }
                        }

                        MessageNode.method1100(var46, var20);
                        ((TextureProvider)Graphics3D.textureLoader).checkTextures(Client.field1091);
                        if(Client.cursorState == 1) {
                           Enum.crossSprites[Client.field933 / 100].drawAt(Client.lastLeftClickX - 8, Client.lastLeftClickY - 8);
                        }

                        if(Client.cursorState == 2) {
                           Enum.crossSprites[Client.field933 / 100 + 4].drawAt(Client.lastLeftClickX - 8, Client.lastLeftClickY - 8);
                        }

                        class28.method231();
                        class89.cameraX = var24;
                        class216.cameraZ = var25;
                        class3.cameraY = var26;
                        ScriptEvent.cameraPitch = var50;
                        class80.cameraYaw = var51;
                        if(Client.field848 && class131.method2812(true, false) == 0) {
                           Client.field848 = false;
                        }

                        if(Client.field848) {
                           Rasterizer2D.Rasterizer2D_fillRectangle(var46, var20, var21, var22, 0);
                           BoundingBox2D.drawStatusBox("Loading - please wait.", false);
                        }

                        Client.field1029[var10.boundsIndex] = true;
                        Rasterizer2D.setDrawRegion(var2, var3, var4, var5);
                        continue;
                     }

                     if(var10.contentType == 1338) {
                        class186.method3767();
                        class221 var59 = var10.method4421(false);
                        if(var59 != null) {
                           Rasterizer2D.setDrawRegion(var12, var13, var12 + var59.field2708, var13 + var59.field2703);
                           if(Client.field978 != 2 && Client.field978 != 5) {
                              var20 = Client.mapAngle & 2047;
                              var21 = GroundObject.localPlayer.x / 32 + 48;
                              var22 = 464 - GroundObject.localPlayer.y / 32;
                              SoundTask.minimapSprite.method5695(var12, var13, var59.field2708, var59.field2703, var21, var22, var20, 256, var59.field2704, var59.field2702);

                              for(var47 = 0; var47 < Client.field1050; ++var47) {
                                 var24 = Client.field1034[var47] * 4 + 2 - GroundObject.localPlayer.x / 32;
                                 var25 = Client.field1052[var47] * 4 + 2 - GroundObject.localPlayer.y / 32;
                                 WorldMapType2.drawDot(var12, var13, var24, var25, Client.mapIcons[var47], var59);
                              }

                              var47 = 0;

                              while(true) {
                                 if(var47 >= 104) {
                                    for(var47 = 0; var47 < Client.npcIndexesCount; ++var47) {
                                       NPC var71 = Client.cachedNPCs[Client.npcIndices[var47]];
                                       if(var71 != null && var71.hasConfig()) {
                                          NPCComposition var74 = var71.composition;
                                          if(var74 != null && var74.configs != null) {
                                             var74 = var74.transform();
                                          }

                                          if(var74 != null && var74.isMinimapVisible && var74.field3660) {
                                             var26 = var71.x / 32 - GroundObject.localPlayer.x / 32;
                                             var50 = var71.y / 32 - GroundObject.localPlayer.y / 32;
                                             WorldMapType2.drawDot(var12, var13, var26, var50, WidgetNode.mapDots[1], var59);
                                          }
                                       }
                                    }

                                    var47 = class92.playerIndexesCount;
                                    int[] var72 = class92.playerIndices;

                                    for(var25 = 0; var25 < var47; ++var25) {
                                       Player var54 = Client.cachedPlayers[var72[var25]];
                                       if(var54 != null && var54.hasConfig() && !var54.hidden && var54 != GroundObject.localPlayer) {
                                          var50 = var54.x / 32 - GroundObject.localPlayer.x / 32;
                                          var51 = var54.y / 32 - GroundObject.localPlayer.y / 32;
                                          boolean var67 = false;
                                          if(GroundObject.localPlayer.team != 0 && var54.team != 0 && var54.team == GroundObject.localPlayer.team) {
                                             var67 = true;
                                          }

                                          if(var54.isFriend()) {
                                             WorldMapType2.drawDot(var12, var13, var50, var51, WidgetNode.mapDots[3], var59);
                                          } else if(var67) {
                                             WorldMapType2.drawDot(var12, var13, var50, var51, WidgetNode.mapDots[4], var59);
                                          } else if(var54.isClanMember()) {
                                             WorldMapType2.drawDot(var12, var13, var50, var51, WidgetNode.mapDots[5], var59);
                                          } else {
                                             WorldMapType2.drawDot(var12, var13, var50, var51, WidgetNode.mapDots[2], var59);
                                          }
                                       }
                                    }

                                    if(Client.hintArrowTargetType != 0 && Client.gameCycle % 20 < 10) {
                                       if(Client.hintArrowTargetType == 1 && Client.hintArrowNpcTargetIdx >= 0 && Client.hintArrowNpcTargetIdx < Client.cachedNPCs.length) {
                                          NPC var75 = Client.cachedNPCs[Client.hintArrowNpcTargetIdx];
                                          if(var75 != null) {
                                             var26 = var75.x / 32 - GroundObject.localPlayer.x / 32;
                                             var50 = var75.y / 32 - GroundObject.localPlayer.y / 32;
                                             MessageNode.worldToMinimap(var12, var13, var26, var50, ScriptState.mapMarkers[1], var59);
                                          }
                                       }

                                       if(Client.hintArrowTargetType == 2) {
                                          var25 = Client.hintArrowX * 4 - ClanMemberManager.baseX * 4 + 2 - GroundObject.localPlayer.x / 32;
                                          var26 = Client.hintArrowY * 4 - WorldMapData.baseY * 4 + 2 - GroundObject.localPlayer.y / 32;
                                          MessageNode.worldToMinimap(var12, var13, var25, var26, ScriptState.mapMarkers[1], var59);
                                       }

                                       if(Client.hintArrowTargetType == 10 && Client.hintArrowPlayerTargetIdx >= 0 && Client.hintArrowPlayerTargetIdx < Client.cachedPlayers.length) {
                                          Player var77 = Client.cachedPlayers[Client.hintArrowPlayerTargetIdx];
                                          if(var77 != null) {
                                             var26 = var77.x / 32 - GroundObject.localPlayer.x / 32;
                                             var50 = var77.y / 32 - GroundObject.localPlayer.y / 32;
                                             MessageNode.worldToMinimap(var12, var13, var26, var50, ScriptState.mapMarkers[1], var59);
                                          }
                                       }
                                    }

                                    if(Client.destinationX != 0) {
                                       var25 = Client.destinationX * 4 + 2 - GroundObject.localPlayer.x / 32;
                                       var26 = Client.destinationY * 4 + 2 - GroundObject.localPlayer.y / 32;
                                       WorldMapType2.drawDot(var12, var13, var25, var26, ScriptState.mapMarkers[0], var59);
                                    }

                                    if(!GroundObject.localPlayer.hidden) {
                                       Rasterizer2D.Rasterizer2D_fillRectangle(var59.field2708 / 2 + var12 - 1, var59.field2703 / 2 + var13 - 1, 3, 3, 16777215);
                                    }
                                    break;
                                 }

                                 for(var24 = 0; var24 < 104; ++var24) {
                                    Deque var53 = Client.groundItemDeque[class60.plane][var47][var24];
                                    if(var53 != null) {
                                       var26 = var47 * 4 + 2 - GroundObject.localPlayer.x / 32;
                                       var50 = var24 * 4 + 2 - GroundObject.localPlayer.y / 32;
                                       WorldMapType2.drawDot(var12, var13, var26, var50, WidgetNode.mapDots[0], var59);
                                    }
                                 }

                                 ++var47;
                              }
                           } else {
                              Rasterizer2D.method5598(var12, var13, 0, var59.field2704, var59.field2702);
                           }

                           Client.field906[var11] = true;
                        }

                        Rasterizer2D.setDrawRegion(var2, var3, var4, var5);
                        continue;
                     }

                     if(var10.contentType == 1339) {
                        ItemLayer.method2618(var10, var12, var13, var11);
                        Rasterizer2D.setDrawRegion(var2, var3, var4, var5);
                        continue;
                     }

                     if(var10.contentType == 1400) {
                        class175.renderOverview.extractWorldmap(var12, var13, var10.width, var10.height, Client.gameCycle);
                     }

                     if(var10.contentType == 1401) {
                        class175.renderOverview.extractData(var12, var13, var10.width, var10.height);
                     }
                  }

                  if(var10.type == 0) {
                     if(!var10.hasScript && ContextMenuRow.method1877(var10) && var10 != KeyFocusListener.field624) {
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

                     WidgetNode var19 = (WidgetNode)Client.componentTable.get((long)var10.id);
                     if(var19 != null) {
                        LoginPacket.method3410(var19.id, var15, var16, var17, var18, var12, var13, var11);
                     }

                     Rasterizer2D.setDrawRegion(var2, var3, var4, var5);
                     Graphics3D.Rasterizer3D_method1();
                  }

                  if(Client.isResized || Client.field1031[var11] || Client.gameDrawingMode > 1) {
                     if(var10.type == 0 && !var10.hasScript && var10.scrollHeight > var10.height) {
                        class214.method4128(var12 + var10.width, var13, var10.scrollY, var10.height, var10.scrollHeight);
                     }

                     if(var10.type != 1) {
                        if(var10.type == 2) {
                           var46 = 0;

                           for(var20 = 0; var20 < var10.originalHeight; ++var20) {
                              for(var21 = 0; var21 < var10.originalWidth; ++var21) {
                                 var22 = var21 * (var10.paddingX + 32) + var12;
                                 var47 = var20 * (var10.paddingY + 32) + var13;
                                 if(var46 < 20) {
                                    var22 += var10.xSprites[var46];
                                    var47 += var10.field2823[var46];
                                 }

                                 if(var10.itemIds[var46] <= 0) {
                                    if(var10.field2824 != null && var46 < 20) {
                                       SpritePixels var70 = var10.method4419(var46);
                                       if(var70 != null) {
                                          var70.drawAt(var22, var47);
                                       } else if(Widget.field2752) {
                                          class33.method341(var10);
                                       }
                                    }
                                 } else {
                                    boolean var64 = false;
                                    boolean var65 = false;
                                    var26 = var10.itemIds[var46] - 1;
                                    if(var22 + 32 > var2 && var22 < var4 && var47 + 32 > var3 && var47 < var5 || var10 == class265.field3515 && var46 == Client.field987) {
                                       SpritePixels var27;
                                       if(Client.itemSelectionState == 1 && var46 == class18.selectedItemIndex && var10.id == class274.field3702) {
                                          var27 = ObjectComposition.createSprite(var26, var10.itemQuantities[var46], 2, 0, 2, false);
                                       } else {
                                          var27 = ObjectComposition.createSprite(var26, var10.itemQuantities[var46], 1, 3153952, 2, false);
                                       }

                                       if(var27 != null) {
                                          if(var10 == class265.field3515 && var46 == Client.field987) {
                                             var24 = MouseInput.mouseLastX - Client.field993;
                                             var25 = MouseInput.mouseLastY - Client.field939;
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

                                             var27.drawAtOpacity(var22 + var24, var47 + var25, 128);
                                             if(var1 != -1) {
                                                Widget var28 = var0[var1 & 65535];
                                                if(var47 + var25 < Rasterizer2D.drawingAreaTop && var28.scrollY > 0) {
                                                   var29 = (Rasterizer2D.drawingAreaTop - var47 - var25) * Client.field1091 / 3;
                                                   if(var29 > Client.field1091 * 10) {
                                                      var29 = Client.field1091 * 10;
                                                   }

                                                   if(var29 > var28.scrollY) {
                                                      var29 = var28.scrollY;
                                                   }

                                                   var28.scrollY -= var29;
                                                   Client.field939 += var29;
                                                   class33.method341(var28);
                                                }

                                                if(var25 + var47 + 32 > Rasterizer2D.drawingAreaRight && var28.scrollY < var28.scrollHeight - var28.height) {
                                                   var29 = (var47 + var25 + 32 - Rasterizer2D.drawingAreaRight) * Client.field1091 / 3;
                                                   if(var29 > Client.field1091 * 10) {
                                                      var29 = Client.field1091 * 10;
                                                   }

                                                   if(var29 > var28.scrollHeight - var28.height - var28.scrollY) {
                                                      var29 = var28.scrollHeight - var28.height - var28.scrollY;
                                                   }

                                                   var28.scrollY += var29;
                                                   Client.field939 -= var29;
                                                   class33.method341(var28);
                                                }
                                             }
                                          } else if(var10 == class45.field566 && var46 == Client.pressedItemIndex) {
                                             var27.drawAtOpacity(var22, var47, 128);
                                          } else {
                                             var27.drawAt(var22, var47);
                                          }
                                       } else {
                                          class33.method341(var10);
                                       }
                                    }
                                 }

                                 ++var46;
                              }
                           }
                        } else if(var10.type == 3) {
                           if(class43.method600(var10)) {
                              var46 = var10.field2780;
                              if(var10 == KeyFocusListener.field624 && var10.field2782 != 0) {
                                 var46 = var10.field2782;
                              }
                           } else {
                              var46 = var10.textColor;
                              if(var10 == KeyFocusListener.field624 && var10.field2867 != 0) {
                                 var46 = var10.field2867;
                              }
                           }

                           if(var10.filled) {
                              switch(var10.field2832.field3886) {
                              case 1:
                                 Rasterizer2D.method5565(var12, var13, var10.width, var10.height, var10.textColor, var10.field2780, 256 - (var10.opacity & 255), 256 - (var10.field2786 & 255));
                                 break;
                              case 2:
                                 Rasterizer2D.method5566(var12, var13, var10.width, var10.height, var10.textColor, var10.field2780, 256 - (var10.opacity & 255), 256 - (var10.field2786 & 255));
                                 break;
                              case 3:
                                 Rasterizer2D.method5567(var12, var13, var10.width, var10.height, var10.textColor, var10.field2780, 256 - (var10.opacity & 255), 256 - (var10.field2786 & 255));
                                 break;
                              case 4:
                                 Rasterizer2D.method5568(var12, var13, var10.width, var10.height, var10.textColor, var10.field2780, 256 - (var10.opacity & 255), 256 - (var10.field2786 & 255));
                                 break;
                              default:
                                 if(var14 == 0) {
                                    Rasterizer2D.Rasterizer2D_fillRectangle(var12, var13, var10.width, var10.height, var46);
                                 } else {
                                    Rasterizer2D.fillRectangle(var12, var13, var10.width, var10.height, var46, 256 - (var14 & 255));
                                 }
                              }
                           } else if(var14 == 0) {
                              Rasterizer2D.drawRectangle(var12, var13, var10.width, var10.height, var46);
                           } else {
                              Rasterizer2D.Rasterizer2D_drawRectangleAlpha(var12, var13, var10.width, var10.height, var46, 256 - (var14 & 255));
                           }
                        } else {
                           Font var57;
                           if(var10.type == 4) {
                              var57 = var10.getFont();
                              if(var57 == null) {
                                 if(Widget.field2752) {
                                    class33.method341(var10);
                                 }
                              } else {
                                 String var73 = var10.text;
                                 if(class43.method600(var10)) {
                                    var20 = var10.field2780;
                                    if(var10 == KeyFocusListener.field624 && var10.field2782 != 0) {
                                       var20 = var10.field2782;
                                    }

                                    if(var10.string1.length() > 0) {
                                       var73 = var10.string1;
                                    }
                                 } else {
                                    var20 = var10.textColor;
                                    if(var10 == KeyFocusListener.field624 && var10.field2867 != 0) {
                                       var20 = var10.field2867;
                                    }
                                 }

                                 if(var10.hasScript && var10.itemId != -1) {
                                    ItemComposition var76 = ItemContainer.getItemDefinition(var10.itemId);
                                    var73 = var76.name;
                                    if(var73 == null) {
                                       var73 = "null";
                                    }

                                    if((var76.isStackable == 1 || var10.itemQuantity != 1) && var10.itemQuantity != -1) {
                                       var73 = class70.getColTags(16748608) + var73 + "</col>" + " " + 'x' + class65.method1061(var10.itemQuantity);
                                    }
                                 }

                                 if(var10 == Client.field885) {
                                    Object var10000 = null;
                                    var73 = "Please wait...";
                                    var20 = var10.textColor;
                                 }

                                 if(!var10.hasScript) {
                                    var73 = class292.method5483(var73, var10);
                                 }

                                 var57.method5376(var73, var12, var13, var10.width, var10.height, var20, var10.textShadowed?0:-1, var10.field2817, var10.field2818, var10.field2816);
                              }
                           } else if(var10.type == 5) {
                              SpritePixels var58;
                              if(!var10.hasScript) {
                                 var58 = var10.method4417(class43.method600(var10));
                                 if(var58 != null) {
                                    var58.drawAt(var12, var13);
                                 } else if(Widget.field2752) {
                                    class33.method341(var10);
                                 }
                              } else {
                                 if(var10.itemId != -1) {
                                    var58 = ObjectComposition.createSprite(var10.itemId, var10.itemQuantity, var10.borderThickness, var10.sprite2, var10.field2862, false);
                                 } else {
                                    var58 = var10.method4417(false);
                                 }

                                 if(var58 == null) {
                                    if(Widget.field2752) {
                                       class33.method341(var10);
                                    }
                                 } else {
                                    var20 = var58.maxWidth;
                                    var21 = var58.maxHeight;
                                    if(!var10.spriteTiling) {
                                       var22 = var10.width * 4096 / var20;
                                       if(var10.textureId != 0) {
                                          var58.method5683(var10.width / 2 + var12, var10.height / 2 + var13, var10.textureId, var22);
                                       } else if(var14 != 0) {
                                          var58.method5692(var12, var13, var10.width, var10.height, 256 - (var14 & 255));
                                       } else if(var20 == var10.width && var21 == var10.height) {
                                          var58.drawAt(var12, var13);
                                       } else {
                                          var58.method5731(var12, var13, var10.width, var10.height);
                                       }
                                    } else {
                                       Rasterizer2D.setInnerDrawRegion(var12, var13, var12 + var10.width, var13 + var10.height);
                                       var22 = (var20 - 1 + var10.width) / var20;
                                       var47 = (var21 - 1 + var10.height) / var21;

                                       for(var24 = 0; var24 < var22; ++var24) {
                                          for(var25 = 0; var25 < var47; ++var25) {
                                             if(var10.textureId != 0) {
                                                var58.method5683(var20 / 2 + var12 + var20 * var24, var21 / 2 + var13 + var21 * var25, var10.textureId, 4096);
                                             } else if(var14 != 0) {
                                                var58.drawAtOpacity(var12 + var20 * var24, var13 + var21 * var25, 256 - (var14 & 255));
                                             } else {
                                                var58.drawAt(var12 + var24 * var20, var13 + var21 * var25);
                                             }
                                          }
                                       }

                                       Rasterizer2D.setDrawRegion(var2, var3, var4, var5);
                                    }
                                 }
                              }
                           } else {
                              ItemComposition var23;
                              if(var10.type == 6) {
                                 boolean var69 = class43.method600(var10);
                                 if(var69) {
                                    var20 = var10.field2831;
                                 } else {
                                    var20 = var10.field2801;
                                 }

                                 Model var68 = null;
                                 var22 = 0;
                                 if(var10.itemId != -1) {
                                    var23 = ItemContainer.getItemDefinition(var10.itemId);
                                    if(var23 != null) {
                                       var23 = var23.method4972(var10.itemQuantity);
                                       var68 = var23.getModel(1);
                                       if(var68 != null) {
                                          var68.calculateBoundsCylinder();
                                          var22 = var68.modelHeight / 2;
                                       } else {
                                          class33.method341(var10);
                                       }
                                    }
                                 } else if(var10.modelType == 5) {
                                    if(var10.modelId == 0) {
                                       var68 = Client.field1087.getModel((Sequence)null, -1, (Sequence)null, -1);
                                    } else {
                                       var68 = GroundObject.localPlayer.getModel();
                                    }
                                 } else if(var20 == -1) {
                                    var68 = var10.getModel((Sequence)null, -1, var69, GroundObject.localPlayer.composition);
                                    if(var68 == null && Widget.field2752) {
                                       class33.method341(var10);
                                    }
                                 } else {
                                    Sequence var62 = FileRequest.getAnimation(var20);
                                    var68 = var10.getModel(var62, var10.field2876, var69, GroundObject.localPlayer.composition);
                                    if(var68 == null && Widget.field2752) {
                                       class33.method341(var10);
                                    }
                                 }

                                 Graphics3D.method2820(var10.width / 2 + var12, var10.height / 2 + var13);
                                 var47 = Graphics3D.SINE[var10.rotationX] * var10.modelZoom >> 16;
                                 var24 = Graphics3D.COSINE[var10.rotationX] * var10.modelZoom >> 16;
                                 if(var68 != null) {
                                    if(!var10.hasScript) {
                                       var68.method2732(0, var10.rotationZ, 0, var10.rotationX, 0, var47, var24);
                                    } else {
                                       var68.calculateBoundsCylinder();
                                       if(var10.field2778) {
                                          var68.method2733(0, var10.rotationZ, var10.rotationY, var10.rotationX, var10.field2777, var22 + var47 + var10.field2864, var24 + var10.field2864, var10.modelZoom);
                                       } else {
                                          var68.method2732(0, var10.rotationZ, var10.rotationY, var10.rotationX, var10.field2777, var47 + var22 + var10.field2864, var24 + var10.field2864);
                                       }
                                    }
                                 }

                                 Graphics3D.Rasterizer3D_method3();
                              } else {
                                 if(var10.type == 7) {
                                    var57 = var10.getFont();
                                    if(var57 == null) {
                                       if(Widget.field2752) {
                                          class33.method341(var10);
                                       }
                                       continue;
                                    }

                                    var20 = 0;

                                    for(var21 = 0; var21 < var10.originalHeight; ++var21) {
                                       for(var22 = 0; var22 < var10.originalWidth; ++var22) {
                                          if(var10.itemIds[var20] > 0) {
                                             var23 = ItemContainer.getItemDefinition(var10.itemIds[var20] - 1);
                                             String var48;
                                             if(var23.isStackable != 1 && var10.itemQuantities[var20] == 1) {
                                                var48 = class70.getColTags(16748608) + var23.name + "</col>";
                                             } else {
                                                var48 = class70.getColTags(16748608) + var23.name + "</col>" + " " + 'x' + class65.method1061(var10.itemQuantities[var20]);
                                             }

                                             var25 = var12 + var22 * (var10.paddingX + 115);
                                             var26 = var13 + (var10.paddingY + 12) * var21;
                                             if(var10.field2817 == 0) {
                                                var57.method5384(var48, var25, var26, var10.textColor, var10.textShadowed?0:-1);
                                             } else if(var10.field2817 == 1) {
                                                var57.drawTextCentered(var48, var10.width / 2 + var25, var26, var10.textColor, var10.textShadowed?0:-1);
                                             } else {
                                                var57.method5412(var48, var25 + var10.width - 1, var26, var10.textColor, var10.textShadowed?0:-1);
                                             }
                                          }

                                          ++var20;
                                       }
                                    }
                                 }

                                 if(var10.type == 8 && var10 == FriendManager.field1216 && Client.field976 == Client.field975) {
                                    var46 = 0;
                                    var20 = 0;
                                    Font var49 = TextureProvider.font_p12full;
                                    String var52 = var10.text;

                                    String var61;
                                    for(var52 = class292.method5483(var52, var10); var52.length() > 0; var20 = var20 + var49.verticalSpace + 1) {
                                       var24 = var52.indexOf("<br>");
                                       if(var24 != -1) {
                                          var61 = var52.substring(0, var24);
                                          var52 = var52.substring(var24 + 4);
                                       } else {
                                          var61 = var52;
                                          var52 = "";
                                       }

                                       var25 = var49.getTextWidth(var61);
                                       if(var25 > var46) {
                                          var46 = var25;
                                       }
                                    }

                                    var46 += 6;
                                    var20 += 7;
                                    var24 = var12 + var10.width - 5 - var46;
                                    var25 = var13 + var10.height + 5;
                                    if(var24 < var12 + 5) {
                                       var24 = var12 + 5;
                                    }

                                    if(var46 + var24 > var4) {
                                       var24 = var4 - var46;
                                    }

                                    if(var20 + var25 > var5) {
                                       var25 = var5 - var20;
                                    }

                                    Rasterizer2D.Rasterizer2D_fillRectangle(var24, var25, var46, var20, 16777120);
                                    Rasterizer2D.drawRectangle(var24, var25, var46, var20, 0);
                                    var52 = var10.text;
                                    var26 = var25 + var49.verticalSpace + 2;

                                    for(var52 = class292.method5483(var52, var10); var52.length() > 0; var26 = var26 + var49.verticalSpace + 1) {
                                       var50 = var52.indexOf("<br>");
                                       if(var50 != -1) {
                                          var61 = var52.substring(0, var50);
                                          var52 = var52.substring(var50 + 4);
                                       } else {
                                          var61 = var52;
                                          var52 = "";
                                       }

                                       var49.method5384(var61, var24 + 3, var26, 0, -1);
                                    }
                                 }

                                 if(var10.type == 9) {
                                    if(var10.field2820) {
                                       var46 = var12;
                                       var20 = var13 + var10.height;
                                       var21 = var12 + var10.width;
                                       var22 = var13;
                                    } else {
                                       var46 = var12;
                                       var20 = var13;
                                       var21 = var12 + var10.width;
                                       var22 = var13 + var10.height;
                                    }

                                    if(var10.lineWidth == 1) {
                                       Rasterizer2D.drawLine(var46, var20, var21, var22, var10.textColor);
                                    } else {
                                       class62.method1032(var46, var20, var21, var22, var10.textColor, var10.lineWidth);
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
