import java.util.Comparator;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("t")
@Implements("WorldComparator")
final class WorldComparator implements Comparator {
   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "Ljk;"
   )
   @Export("item_ref")
   public static IndexDataBase item_ref;

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Lu;Lu;I)I",
      garbageValue = "-721317283"
   )
   int method65(GrandExchangeEvent var1, GrandExchangeEvent var2) {
      return var1.world < var2.world?-1:(var2.world == var1.world?0:1);
   }

   public int compare(Object var1, Object var2) {
      return this.method65((GrandExchangeEvent)var1, (GrandExchangeEvent)var2);
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "776860617"
   )
   static void method73(int var0, int var1, int var2, int var3) {
      for(class80 var4 = (class80)class80.field1253.getFront(); var4 != null; var4 = (class80)class80.field1253.getNext()) {
         if(var4.field1244 != -1 || var4.field1250 != null) {
            int var5 = 0;
            if(var1 > var4.field1243) {
               var5 += var1 - var4.field1243;
            } else if(var1 < var4.field1241) {
               var5 += var4.field1241 - var1;
            }

            if(var2 > var4.field1246) {
               var5 += var2 - var4.field1246;
            } else if(var2 < var4.field1256) {
               var5 += var4.field1256 - var2;
            }

            if(var5 - 64 <= var4.field1245 && Client.field911 != 0 && var0 == var4.field1240) {
               var5 -= 64;
               if(var5 < 0) {
                  var5 = 0;
               }

               int var6 = (var4.field1245 - var5) * Client.field911 / var4.field1245;
               if(var4.field1247 == null) {
                  if(var4.field1244 >= 0) {
                     SoundEffect var7 = SoundEffect.getTrack(class178.indexCache4, var4.field1244, 0);
                     if(var7 != null) {
                        RawAudioNode var8 = var7.method2168().applyResampler(class57.field673);
                        class115 var9 = class115.method2363(var8, 100, var6);
                        var9.method2366(-1);
                        class29.field431.method2103(var9);
                        var4.field1247 = var9;
                     }
                  }
               } else {
                  var4.field1247.method2367(var6);
               }

               if(var4.field1252 == null) {
                  if(var4.field1250 != null && (var4.field1251 -= var3) <= 0) {
                     int var11 = (int)(Math.random() * (double)var4.field1250.length);
                     SoundEffect var12 = SoundEffect.getTrack(class178.indexCache4, var4.field1250[var11], 0);
                     if(var12 != null) {
                        RawAudioNode var13 = var12.method2168().applyResampler(class57.field673);
                        class115 var10 = class115.method2363(var13, 100, var6);
                        var10.method2366(0);
                        class29.field431.method2103(var10);
                        var4.field1252 = var10;
                        var4.field1251 = var4.field1248 + (int)(Math.random() * (double)(var4.field1249 - var4.field1248));
                     }
                  }
               } else {
                  var4.field1252.method2367(var6);
                  if(!var4.field1252.linked()) {
                     var4.field1252 = null;
                  }
               }
            } else {
               if(var4.field1247 != null) {
                  class29.field431.method2129(var4.field1247);
                  var4.field1247 = null;
               }

               if(var4.field1252 != null) {
                  class29.field431.method2129(var4.field1252);
                  var4.field1252 = null;
               }
            }
         }
      }

   }

   @ObfuscatedName("ff")
   @ObfuscatedSignature(
      signature = "(S)V",
      garbageValue = "1006"
   )
   static void method74() {
      if(Client.field1103 >= 0 && Client.cachedPlayers[Client.field1103] != null) {
         VertexNormal.method2844(Client.cachedPlayers[Client.field1103], false);
      }

   }

   @ObfuscatedName("hi")
   @ObfuscatedSignature(
      signature = "([Liw;IIIIIIIII)V",
      garbageValue = "547260568"
   )
   @Export("gameDraw")
   static final void gameDraw(Widget[] var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
      Rasterizer2D.setDrawRegion(var2, var3, var4, var5);
      Graphics3D.Rasterizer3D_method1();

      label1411:
      for(int var9 = 0; var9 < var0.length; ++var9) {
         Widget var10 = var0[var9];
         if(var10 != null && (var10.parentId == var1 || var1 == -1412584499 && var10 == Client.field1021)) {
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
            if(!var10.hasScript || !class236.method4476(var10)) {
               if(var10.contentType > 0) {
                  class236.method4475(var10);
               }

               int var12 = var10.relativeX + var6;
               int var13 = var7 + var10.relativeY;
               int var14 = var10.opacity;
               int var15;
               int var16;
               if(var10 == Client.field1021) {
                  if(var1 != -1412584499 && !var10.field2903) {
                     Signlink.field2184 = var0;
                     class86.field1308 = var6;
                     ScriptState.field758 = var7;
                     continue;
                  }

                  if(Client.field1032 && Client.field1026) {
                     var15 = MouseInput.mouseLastX;
                     var16 = MouseInput.mouseLastY;
                     var15 -= Client.field1023;
                     var16 -= Client.field1056;
                     if(var15 < Client.field1027) {
                        var15 = Client.field1027;
                     }

                     if(var15 + var10.width > Client.field1027 + Client.field1022.width) {
                        var15 = Client.field1027 + Client.field1022.width - var10.width;
                     }

                     if(var16 < Client.field1028) {
                        var16 = Client.field1028;
                     }

                     if(var16 + var10.height > Client.field1028 + Client.field1022.height) {
                        var16 = Client.field1028 + Client.field1022.height - var10.height;
                     }

                     var12 = var15;
                     var13 = var16;
                  }

                  if(!var10.field2903) {
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
                  var19 = var12 + var10.width;
                  var20 = var13 + var10.height;
                  var15 = var12 > var2?var12:var2;
                  var16 = var13 > var3?var13:var3;
                  var17 = var19 < var4?var19:var4;
                  var18 = var20 < var5?var20:var5;
               }

               if(!var10.hasScript || var15 < var17 && var16 < var18) {
                  int var23;
                  int var24;
                  int var25;
                  int var26;
                  int var28;
                  int var29;
                  int var30;
                  int var31;
                  int var33;
                  int var34;
                  int var35;
                  int var37;
                  int var38;
                  int var39;
                  int var40;
                  int var41;
                  int var43;
                  int var44;
                  int var45;
                  int var51;
                  if(var10.contentType != 0) {
                     if(var10.contentType == 1336) {
                        if(Client.displayFps) {
                           var13 += 15;
                           SoundTaskDataProvider.font_p12full.method5617("Fps:" + GameEngine.FPS, var12 + var10.width, var13, 16776960, -1);
                           var13 += 15;
                           Runtime var68 = Runtime.getRuntime();
                           var20 = (int)((var68.totalMemory() - var68.freeMemory()) / 1024L);
                           var21 = 16776960;
                           if(var20 > 327680 && !Client.lowMemory) {
                              var21 = 16711680;
                           }

                           SoundTaskDataProvider.font_p12full.method5617("Mem:" + var20 + "k", var12 + var10.width, var13, var21, -1);
                           var13 += 15;
                        }
                        continue;
                     }

                     if(var10.contentType == 1337) {
                        Client.field999 = var12;
                        Client.field919 = var13;
                        var21 = var10.width;
                        var22 = var10.height;
                        ++Client.field1108;
                        if(TotalQuantityComparator.localPlayer.x >> 7 == Client.destinationX && TotalQuantityComparator.localPlayer.y >> 7 == Client.destinationY) {
                           Client.destinationX = 0;
                        }

                        ContextMenuRow.method1894();
                        method74();
                        class27.method222(true);
                        class204.method3930();
                        class27.method222(false);
                        DecorativeObject.method3164();
                        class61.method1016();
                        GameSocket.method3420(var12, var13, var21, var22, true);
                        var19 = Client.Viewport_xOffset;
                        var20 = Client.Viewport_yOffset;
                        var21 = Client.viewportWidth;
                        var22 = Client.viewportHeight;
                        Rasterizer2D.setDrawRegion(var19, var20, var21 + var19, var20 + var22);
                        Graphics3D.Rasterizer3D_method1();
                        if(!Client.field1092) {
                           var23 = Client.cameraPitchTarget;
                           if(Client.field936 / 256 > var23) {
                              var23 = Client.field936 / 256;
                           }

                           if(Client.field1093[4] && Client.field894[4] + 128 > var23) {
                              var23 = Client.field894[4] + 128;
                           }

                           var24 = Client.mapAngle & 2047;
                           class234.method4461(WorldMapType1.field443, MapLabel.field476, class171.field2218, var23, var24, var23 * 3 + 600);
                        }

                        if(!Client.field1092) {
                           var23 = FriendManager.method1722();
                        } else {
                           if(class55.preferences.hideRoofs) {
                              var24 = class36.plane;
                           } else {
                              var25 = class35.getTileHeight(Resampler.cameraX, class31.cameraY, class36.plane);
                              if(var25 - class49.cameraZ < 800 && (class62.tileSettings[class36.plane][Resampler.cameraX >> 7][class31.cameraY >> 7] & 4) != 0) {
                                 var24 = class36.plane;
                              } else {
                                 var24 = 3;
                              }
                           }

                           var23 = var24;
                        }

                        var24 = Resampler.cameraX;
                        var25 = class49.cameraZ;
                        var26 = class31.cameraY;
                        var51 = GameCanvas.cameraPitch;
                        var28 = IndexDataBase.cameraYaw;

                        for(var29 = 0; var29 < 5; ++var29) {
                           if(Client.field1093[var29]) {
                              var30 = (int)(Math.random() * (double)(Client.field995[var29] * 2 + 1) - (double)Client.field995[var29] + Math.sin((double)Client.field903[var29] / 100.0D * (double)Client.field1091[var29]) * (double)Client.field894[var29]);
                              if(var29 == 0) {
                                 Resampler.cameraX += var30;
                              }

                              if(var29 == 1) {
                                 class49.cameraZ += var30;
                              }

                              if(var29 == 2) {
                                 class31.cameraY += var30;
                              }

                              if(var29 == 3) {
                                 IndexDataBase.cameraYaw = var30 + IndexDataBase.cameraYaw & 2047;
                              }

                              if(var29 == 4) {
                                 GameCanvas.cameraPitch += var30;
                                 if(GameCanvas.cameraPitch < 128) {
                                    GameCanvas.cameraPitch = 128;
                                 }

                                 if(GameCanvas.cameraPitch > 383) {
                                    GameCanvas.cameraPitch = 383;
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

                        if(var29 >= var19 && var29 < var21 + var19 && var30 >= var20 && var30 < var20 + var22) {
                           class66.method1082(var29 - var19, var30 - var20);
                        } else {
                           class132.Viewport_containsMouse = false;
                           class132.Viewport_entityCountAtMouse = 0;
                        }

                        Huffman.method3510();
                        Rasterizer2D.Rasterizer2D_fillRectangle(var19, var20, var21, var22, 0);
                        Huffman.method3510();
                        var31 = Graphics3D.Rasterizer3D_zoom;
                        Graphics3D.Rasterizer3D_zoom = Client.scale;
                        class86.region.drawRegion(Resampler.cameraX, class49.cameraZ, class31.cameraY, GameCanvas.cameraPitch, IndexDataBase.cameraYaw, var23);

                        while(true) {
                           BoundingBox var54 = (BoundingBox)class7.boundingBoxes.removeLast();
                           if(var54 == null) {
                              Graphics3D.Rasterizer3D_zoom = var31;
                              Huffman.method3510();
                              class86.region.clearEntities();
                              Client.overheadTextCount = 0;
                              boolean var61 = false;
                              var33 = -1;
                              var34 = -1;
                              var35 = class93.playerIndexesCount;
                              int[] var55 = class93.playerIndices;

                              for(var37 = 0; var37 < var35 + Client.npcIndexesCount; ++var37) {
                                 Object var56;
                                 if(var37 < var35) {
                                    var56 = Client.cachedPlayers[var55[var37]];
                                    if(var55[var37] == Client.field1103) {
                                       var61 = true;
                                       var33 = var37;
                                       continue;
                                    }

                                    if(var56 == TotalQuantityComparator.localPlayer) {
                                       var34 = var37;
                                       continue;
                                    }
                                 } else {
                                    var56 = Client.cachedNPCs[Client.npcIndices[var37 - var35]];
                                 }

                                 ScriptEvent.draw2DExtras((Actor)var56, var37, var19, var20, var21, var22);
                              }

                              if(Client.field969 && var34 != -1) {
                                 ScriptEvent.draw2DExtras(TotalQuantityComparator.localPlayer, var34, var19, var20, var21, var22);
                              }

                              if(var61) {
                                 ScriptEvent.draw2DExtras(Client.cachedPlayers[Client.field1103], var33, var19, var20, var21, var22);
                              }

                              for(var37 = 0; var37 < Client.overheadTextCount; ++var37) {
                                 var38 = Client.overheadTextsX[var37];
                                 var39 = Client.overheadTextsY[var37];
                                 var40 = Client.overheadTextsOffsetX[var37];
                                 var41 = Client.overheadTextsOffsetY[var37];
                                 boolean var63 = true;

                                 while(var63) {
                                    var63 = false;

                                    for(var43 = 0; var43 < var37; ++var43) {
                                       if(var39 + 2 > Client.overheadTextsY[var43] - Client.overheadTextsOffsetY[var43] && var39 - var41 < Client.overheadTextsY[var43] + 2 && var38 - var40 < Client.overheadTextsX[var43] + Client.overheadTextsOffsetX[var43] && var40 + var38 > Client.overheadTextsX[var43] - Client.overheadTextsOffsetX[var43] && Client.overheadTextsY[var43] - Client.overheadTextsOffsetY[var43] < var39) {
                                          var39 = Client.overheadTextsY[var43] - Client.overheadTextsOffsetY[var43];
                                          var63 = true;
                                       }
                                    }
                                 }

                                 Client.screenX = Client.overheadTextsX[var37];
                                 Client.screenY = Client.overheadTextsY[var37] = var39;
                                 String var57 = Client.overheadTexts[var37];
                                 if(Client.field1012 == 0) {
                                    var44 = 16776960;
                                    if(Client.field943[var37] < 6) {
                                       var44 = Client.field1063[Client.field943[var37]];
                                    }

                                    if(Client.field943[var37] == 6) {
                                       var44 = Client.field1108 % 20 < 10?16711680:16776960;
                                    }

                                    if(Client.field943[var37] == 7) {
                                       var44 = Client.field1108 % 20 < 10?255:'\uffff';
                                    }

                                    if(Client.field943[var37] == 8) {
                                       var44 = Client.field1108 % 20 < 10?'뀀':8454016;
                                    }

                                    if(Client.field943[var37] == 9) {
                                       var45 = 150 - Client.overheadTextsCyclesRemaining[var37];
                                       if(var45 < 50) {
                                          var44 = var45 * 1280 + 16711680;
                                       } else if(var45 < 100) {
                                          var44 = 16776960 - (var45 - 50) * 327680;
                                       } else if(var45 < 150) {
                                          var44 = (var45 - 100) * 5 + 65280;
                                       }
                                    }

                                    if(Client.field943[var37] == 10) {
                                       var45 = 150 - Client.overheadTextsCyclesRemaining[var37];
                                       if(var45 < 50) {
                                          var44 = var45 * 5 + 16711680;
                                       } else if(var45 < 100) {
                                          var44 = 16711935 - (var45 - 50) * 327680;
                                       } else if(var45 < 150) {
                                          var44 = (var45 - 100) * 327680 + 255 - (var45 - 100) * 5;
                                       }
                                    }

                                    if(Client.field943[var37] == 11) {
                                       var45 = 150 - Client.overheadTextsCyclesRemaining[var37];
                                       if(var45 < 50) {
                                          var44 = 16777215 - var45 * 327685;
                                       } else if(var45 < 100) {
                                          var44 = (var45 - 50) * 327685 + 65280;
                                       } else if(var45 < 150) {
                                          var44 = 16777215 - (var45 - 100) * 327680;
                                       }
                                    }

                                    if(Client.field915[var37] == 0) {
                                       DecorativeObject.fontBold12.drawTextCentered(var57, var19 + Client.screenX, var20 + Client.screenY, var44, 0);
                                    }

                                    if(Client.field915[var37] == 1) {
                                       DecorativeObject.fontBold12.method5680(var57, var19 + Client.screenX, var20 + Client.screenY, var44, 0, Client.field1108);
                                    }

                                    if(Client.field915[var37] == 2) {
                                       DecorativeObject.fontBold12.method5621(var57, var19 + Client.screenX, var20 + Client.screenY, var44, 0, Client.field1108);
                                    }

                                    if(Client.field915[var37] == 3) {
                                       DecorativeObject.fontBold12.method5622(var57, var19 + Client.screenX, var20 + Client.screenY, var44, 0, Client.field1108, 150 - Client.overheadTextsCyclesRemaining[var37]);
                                    }

                                    if(Client.field915[var37] == 4) {
                                       var45 = (150 - Client.overheadTextsCyclesRemaining[var37]) * (DecorativeObject.fontBold12.getTextWidth(var57) + 100) / 150;
                                       Rasterizer2D.setInnerDrawRegion(var19 + Client.screenX - 50, var20, var19 + Client.screenX + 50, var20 + var22);
                                       DecorativeObject.fontBold12.method5689(var57, var19 + Client.screenX + 50 - var45, var20 + Client.screenY, var44, 0);
                                       Rasterizer2D.setDrawRegion(var19, var20, var21 + var19, var20 + var22);
                                    }

                                    if(Client.field915[var37] == 5) {
                                       var45 = 150 - Client.overheadTextsCyclesRemaining[var37];
                                       int var46 = 0;
                                       if(var45 < 25) {
                                          var46 = var45 - 25;
                                       } else if(var45 > 125) {
                                          var46 = var45 - 125;
                                       }

                                       Rasterizer2D.setInnerDrawRegion(var19, var20 + Client.screenY - DecorativeObject.fontBold12.verticalSpace - 1, var19 + var21, var20 + Client.screenY + 5);
                                       DecorativeObject.fontBold12.drawTextCentered(var57, var19 + Client.screenX, var20 + var46 + Client.screenY, var44, 0);
                                       Rasterizer2D.setDrawRegion(var19, var20, var19 + var21, var22 + var20);
                                    }
                                 } else {
                                    DecorativeObject.fontBold12.drawTextCentered(var57, var19 + Client.screenX, var20 + Client.screenY, 16776960, 0);
                                 }
                              }

                              if(Client.hintArrowTargetType == 2) {
                                 class160.worldToScreen((Client.hintArrowX - WorldMapType1.baseX << 7) + Client.hintArrowOffsetX, (Client.hintArrowY - Enum.baseY << 7) + Client.hintArrowOffsetY, Client.hintArrowType * 2);
                                 if(Client.screenX > -1 && Client.gameCycle % 20 < 10) {
                                    SceneTilePaint.headIconsHint[0].drawAt(var19 + Client.screenX - 12, var20 + Client.screenY - 28);
                                 }
                              }

                              ((TextureProvider)Graphics3D.textureLoader).checkTextures(Client.field914);
                              class138.method3119(var19, var20, var21, var22);
                              Resampler.cameraX = var24;
                              class49.cameraZ = var25;
                              class31.cameraY = var26;
                              GameCanvas.cameraPitch = var51;
                              IndexDataBase.cameraYaw = var28;
                              if(Client.field1068) {
                                 byte var62 = 0;
                                 var33 = var62 + class264.NetCache_pendingPriorityResponsesCount + class264.NetCache_pendingPriorityWritesCount;
                                 if(var33 == 0) {
                                    Client.field1068 = false;
                                 }
                              }

                              if(Client.field1068) {
                                 Rasterizer2D.Rasterizer2D_fillRectangle(var19, var20, var21, var22, 0);
                                 SoundTaskDataProvider.method783("Loading - please wait.", false);
                              }

                              Client.field1053[var10.boundsIndex] = true;
                              Rasterizer2D.setDrawRegion(var2, var3, var4, var5);
                              continue label1411;
                           }

                           var54.vmethod59();
                        }
                     }

                     if(var10.contentType == 1338) {
                        class64.method1066(var10, var12, var13, var11);
                        Rasterizer2D.setDrawRegion(var2, var3, var4, var5);
                        continue;
                     }

                     if(var10.contentType == 1339) {
                        class236 var67 = var10.method4563(false);
                        if(var67 != null) {
                           if(Client.field1080 < 3) {
                              FrameMap.compass.method5938(var12, var13, var67.field2777, var67.field2775, 25, 25, Client.mapAngle, 256, var67.field2778, var67.field2779);
                           } else {
                              Rasterizer2D.method5820(var12, var13, 0, var67.field2778, var67.field2779);
                           }
                        }

                        Rasterizer2D.setDrawRegion(var2, var3, var4, var5);
                        continue;
                     }

                     if(var10.contentType == 1400) {
                        class248.renderOverview.extractWorldmap(var12, var13, var10.width, var10.height, Client.gameCycle);
                     }

                     if(var10.contentType == 1401) {
                        class248.renderOverview.extractData(var12, var13, var10.width, var10.height);
                     }
                  }

                  if(var10.type == 0) {
                     if(!var10.hasScript && class236.method4476(var10) && var10 != class45.field579) {
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

                     WidgetNode var47 = (WidgetNode)Client.componentTable.get((long)var10.id);
                     if(var47 != null) {
                        class1.method0(var47.id, var15, var16, var17, var18, var12, var13, var11);
                     }

                     Rasterizer2D.setDrawRegion(var2, var3, var4, var5);
                     Graphics3D.Rasterizer3D_method1();
                  }

                  if(Client.isResized || Client.field1055[var11] || Client.gameDrawingMode > 1) {
                     if(var10.type == 0 && !var10.hasScript && var10.scrollHeight > var10.height) {
                        var19 = var12 + var10.width;
                        var20 = var10.scrollY;
                        var21 = var10.height;
                        var22 = var10.scrollHeight;
                        class233.scrollbarSprites[0].method5899(var19, var13);
                        class233.scrollbarSprites[1].method5899(var19, var13 + var21 - 16);
                        Rasterizer2D.Rasterizer2D_fillRectangle(var19, var13 + 16, 16, var21 - 32, Client.field989);
                        var23 = var21 * (var21 - 32) / var22;
                        if(var23 < 8) {
                           var23 = 8;
                        }

                        var24 = var20 * (var21 - 32 - var23) / (var22 - var21);
                        Rasterizer2D.Rasterizer2D_fillRectangle(var19, var24 + var13 + 16, 16, var23, Client.field916);
                        Rasterizer2D.method5816(var19, var13 + var24 + 16, var23, Client.field955);
                        Rasterizer2D.method5816(var19 + 1, var13 + var24 + 16, var23, Client.field955);
                        Rasterizer2D.method5814(var19, var13 + var24 + 16, 16, Client.field955);
                        Rasterizer2D.method5814(var19, var24 + var13 + 17, 16, Client.field955);
                        Rasterizer2D.method5816(var19 + 15, var13 + var24 + 16, var23, Client.field917);
                        Rasterizer2D.method5816(var19 + 14, var24 + var13 + 17, var23 - 1, Client.field917);
                        Rasterizer2D.method5814(var19, var23 + var13 + var24 + 15, 16, Client.field917);
                        Rasterizer2D.method5814(var19 + 1, var13 + var24 + var23 + 14, 15, Client.field917);
                     }

                     if(var10.type != 1) {
                        if(var10.type == 2) {
                           var19 = 0;

                           for(var20 = 0; var20 < var10.originalHeight; ++var20) {
                              for(var21 = 0; var21 < var10.originalWidth; ++var21) {
                                 var22 = var12 + var21 * (var10.paddingX + 32);
                                 var23 = var13 + var20 * (var10.paddingY + 32);
                                 if(var19 < 20) {
                                    var22 += var10.xSprites[var19];
                                    var23 += var10.field2894[var19];
                                 }

                                 if(var10.itemIds[var19] <= 0) {
                                    if(var10.field2902 != null && var19 < 20) {
                                       SpritePixels var73 = var10.method4595(var19);
                                       if(var73 != null) {
                                          var73.drawAt(var22, var23);
                                       } else if(Widget.field2823) {
                                          class171.method3363(var10);
                                       }
                                    }
                                 } else {
                                    boolean var59 = false;
                                    boolean var60 = false;
                                    var26 = var10.itemIds[var19] - 1;
                                    if(var22 + 32 > var2 && var22 < var4 && var23 + 32 > var3 && var23 < var5 || var10 == class160.field2147 && var19 == Client.field958) {
                                       SpritePixels var27;
                                       if(Client.itemSelectionState == 1 && var19 == MapIcon.selectedItemIndex && var10.id == class71.field820) {
                                          var27 = CollisionData.createSprite(var26, var10.itemQuantities[var19], 2, 0, 2, false);
                                       } else {
                                          var27 = CollisionData.createSprite(var26, var10.itemQuantities[var19], 1, 3153952, 2, false);
                                       }

                                       if(var27 != null) {
                                          if(var10 == class160.field2147 && var19 == Client.field958) {
                                             var24 = MouseInput.mouseLastX - Client.field1048;
                                             var25 = MouseInput.mouseLastY - Client.field960;
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

                                             var27.drawAtOpacity(var22 + var24, var23 + var25, 128);
                                             if(var1 != -1) {
                                                Widget var53 = var0[var1 & 65535];
                                                if(var25 + var23 < Rasterizer2D.drawingAreaTop && var53.scrollY > 0) {
                                                   var29 = (Rasterizer2D.drawingAreaTop - var23 - var25) * Client.field914 / 3;
                                                   if(var29 > Client.field914 * 10) {
                                                      var29 = Client.field914 * 10;
                                                   }

                                                   if(var29 > var53.scrollY) {
                                                      var29 = var53.scrollY;
                                                   }

                                                   var53.scrollY -= var29;
                                                   Client.field960 += var29;
                                                   class171.method3363(var53);
                                                }

                                                if(var25 + var23 + 32 > Rasterizer2D.drawingAreaRight && var53.scrollY < var53.scrollHeight - var53.height) {
                                                   var29 = (var23 + var25 + 32 - Rasterizer2D.drawingAreaRight) * Client.field914 / 3;
                                                   if(var29 > Client.field914 * 10) {
                                                      var29 = Client.field914 * 10;
                                                   }

                                                   if(var29 > var53.scrollHeight - var53.height - var53.scrollY) {
                                                      var29 = var53.scrollHeight - var53.height - var53.scrollY;
                                                   }

                                                   var53.scrollY += var29;
                                                   Client.field960 -= var29;
                                                   class171.method3363(var53);
                                                }
                                             }
                                          } else if(var10 == MapLabel.field477 && var19 == Client.pressedItemIndex) {
                                             var27.drawAtOpacity(var22, var23, 128);
                                          } else {
                                             var27.drawAt(var22, var23);
                                          }
                                       } else {
                                          class171.method3363(var10);
                                       }
                                    }
                                 }

                                 ++var19;
                              }
                           }
                        } else if(var10.type == 3) {
                           if(WorldMapManager.method562(var10)) {
                              var19 = var10.field2851;
                              if(var10 == class45.field579 && var10.field2853 != 0) {
                                 var19 = var10.field2853;
                              }
                           } else {
                              var19 = var10.textColor;
                              if(var10 == class45.field579 && var10.field2852 != 0) {
                                 var19 = var10.field2852;
                              }
                           }

                           if(var10.filled) {
                              switch(var10.field2868.field3967) {
                              case 1:
                                 Rasterizer2D.method5806(var12, var13, var10.width, var10.height, var10.textColor, var10.field2851, 256 - (var10.opacity & 255), 256 - (var10.field2857 & 255));
                                 break;
                              case 2:
                                 Rasterizer2D.method5794(var12, var13, var10.width, var10.height, var10.textColor, var10.field2851, 256 - (var10.opacity & 255), 256 - (var10.field2857 & 255));
                                 break;
                              case 3:
                                 Rasterizer2D.method5809(var12, var13, var10.width, var10.height, var10.textColor, var10.field2851, 256 - (var10.opacity & 255), 256 - (var10.field2857 & 255));
                                 break;
                              case 4:
                                 Rasterizer2D.method5856(var12, var13, var10.width, var10.height, var10.textColor, var10.field2851, 256 - (var10.opacity & 255), 256 - (var10.field2857 & 255));
                                 break;
                              default:
                                 if(var14 == 0) {
                                    Rasterizer2D.Rasterizer2D_fillRectangle(var12, var13, var10.width, var10.height, var19);
                                 } else {
                                    Rasterizer2D.fillRectangle(var12, var13, var10.width, var10.height, var19, 256 - (var14 & 255));
                                 }
                              }
                           } else if(var14 == 0) {
                              Rasterizer2D.drawRectangle(var12, var13, var10.width, var10.height, var19);
                           } else {
                              Rasterizer2D.Rasterizer2D_drawRectangleAlpha(var12, var13, var10.width, var10.height, var19, 256 - (var14 & 255));
                           }
                        } else {
                           Font var64;
                           if(var10.type == 4) {
                              var64 = var10.getFont();
                              if(var64 == null) {
                                 if(Widget.field2823) {
                                    class171.method3363(var10);
                                 }
                              } else {
                                 String var70 = var10.text;
                                 if(WorldMapManager.method562(var10)) {
                                    var20 = var10.field2851;
                                    if(var10 == class45.field579 && var10.field2853 != 0) {
                                       var20 = var10.field2853;
                                    }

                                    if(var10.string1.length() > 0) {
                                       var70 = var10.string1;
                                    }
                                 } else {
                                    var20 = var10.textColor;
                                    if(var10 == class45.field579 && var10.field2852 != 0) {
                                       var20 = var10.field2852;
                                    }
                                 }

                                 if(var10.hasScript && var10.itemId != -1) {
                                    ItemComposition var71 = class251.getItemDefinition(var10.itemId);
                                    var70 = var71.name;
                                    if(var70 == null) {
                                       var70 = "null";
                                    }

                                    if((var71.isStackable == 1 || var10.itemQuantity != 1) && var10.itemQuantity != -1) {
                                       var70 = IndexFile.getColTags(16748608) + var70 + "</col>" + " " + 'x' + MapIconReference.method710(var10.itemQuantity);
                                    }
                                 }

                                 if(var10 == Client.field1014) {
                                    var70 = "Please wait...";
                                    var20 = var10.textColor;
                                 }

                                 if(!var10.hasScript) {
                                    var70 = class61.method1022(var70, var10);
                                 }

                                 var64.method5627(var70, var12, var13, var10.width, var10.height, var20, var10.textShadowed?0:-1, var10.field2888, var10.field2891, var10.field2850);
                              }
                           } else if(var10.type == 5) {
                              SpritePixels var65;
                              if(!var10.hasScript) {
                                 var65 = var10.method4561(WorldMapManager.method562(var10));
                                 if(var65 != null) {
                                    var65.drawAt(var12, var13);
                                 } else if(Widget.field2823) {
                                    class171.method3363(var10);
                                 }
                              } else {
                                 if(var10.itemId != -1) {
                                    var65 = CollisionData.createSprite(var10.itemId, var10.itemQuantity, var10.borderThickness, var10.sprite2, var10.field2958, false);
                                 } else {
                                    var65 = var10.method4561(false);
                                 }

                                 if(var65 == null) {
                                    if(Widget.field2823) {
                                       class171.method3363(var10);
                                    }
                                 } else {
                                    var20 = var65.maxWidth;
                                    var21 = var65.maxHeight;
                                    if(!var10.spriteTiling) {
                                       var22 = var10.width * 4096 / var20;
                                       if(var10.textureId != 0) {
                                          var65.method5940(var10.width / 2 + var12, var10.height / 2 + var13, var10.textureId, var22);
                                       } else if(var14 != 0) {
                                          var65.method5929(var12, var13, var10.width, var10.height, 256 - (var14 & 255));
                                       } else if(var20 == var10.width && var21 == var10.height) {
                                          var65.drawAt(var12, var13);
                                       } else {
                                          var65.method5989(var12, var13, var10.width, var10.height);
                                       }
                                    } else {
                                       Rasterizer2D.setInnerDrawRegion(var12, var13, var12 + var10.width, var13 + var10.height);
                                       var22 = (var20 - 1 + var10.width) / var20;
                                       var23 = (var21 - 1 + var10.height) / var21;

                                       for(var24 = 0; var24 < var22; ++var24) {
                                          for(var25 = 0; var25 < var23; ++var25) {
                                             if(var10.textureId != 0) {
                                                var65.method5940(var20 / 2 + var12 + var20 * var24, var21 / 2 + var13 + var21 * var25, var10.textureId, 4096);
                                             } else if(var14 != 0) {
                                                var65.drawAtOpacity(var12 + var20 * var24, var13 + var25 * var21, 256 - (var14 & 255));
                                             } else {
                                                var65.drawAt(var12 + var20 * var24, var13 + var25 * var21);
                                             }
                                          }
                                       }

                                       Rasterizer2D.setDrawRegion(var2, var3, var4, var5);
                                    }
                                 }
                              }
                           } else {
                              ItemComposition var50;
                              if(var10.type == 6) {
                                 boolean var58 = WorldMapManager.method562(var10);
                                 if(var58) {
                                    var20 = var10.field2873;
                                 } else {
                                    var20 = var10.field2820;
                                 }

                                 Model var66 = null;
                                 var22 = 0;
                                 if(var10.itemId != -1) {
                                    var50 = class251.getItemDefinition(var10.itemId);
                                    if(var50 != null) {
                                       var50 = var50.method5165(var10.itemQuantity);
                                       var66 = var50.getModel(1);
                                       if(var66 != null) {
                                          var66.calculateBoundsCylinder();
                                          var22 = var66.modelHeight / 2;
                                       } else {
                                          class171.method3363(var10);
                                       }
                                    }
                                 } else if(var10.modelType == 5) {
                                    if(var10.modelId == 0) {
                                       var66 = Client.field1009.getModel((Sequence)null, -1, (Sequence)null, -1);
                                    } else {
                                       var66 = TotalQuantityComparator.localPlayer.getModel();
                                    }
                                 } else if(var20 == -1) {
                                    var66 = var10.getModel((Sequence)null, -1, var58, TotalQuantityComparator.localPlayer.composition);
                                    if(var66 == null && Widget.field2823) {
                                       class171.method3363(var10);
                                    }
                                 } else {
                                    Sequence var72 = class270.getAnimation(var20);
                                    var66 = var10.getModel(var72, var10.field2947, var58, TotalQuantityComparator.localPlayer.composition);
                                    if(var66 == null && Widget.field2823) {
                                       class171.method3363(var10);
                                    }
                                 }

                                 Graphics3D.method2925(var10.width / 2 + var12, var10.height / 2 + var13);
                                 var23 = Graphics3D.SINE[var10.rotationX] * var10.modelZoom >> 16;
                                 var24 = Graphics3D.COSINE[var10.rotationX] * var10.modelZoom >> 16;
                                 if(var66 != null) {
                                    if(!var10.hasScript) {
                                       var66.method2773(0, var10.rotationZ, 0, var10.rotationX, 0, var23, var24);
                                    } else {
                                       var66.calculateBoundsCylinder();
                                       if(var10.field2882) {
                                          var66.method2774(0, var10.rotationZ, var10.rotationY, var10.rotationX, var10.field2874, var22 + var23 + var10.field2875, var24 + var10.field2875, var10.modelZoom);
                                       } else {
                                          var66.method2773(0, var10.rotationZ, var10.rotationY, var10.rotationX, var10.field2874, var23 + var22 + var10.field2875, var24 + var10.field2875);
                                       }
                                    }
                                 }

                                 Graphics3D.Rasterizer3D_method3();
                              } else {
                                 if(var10.type == 7) {
                                    var64 = var10.getFont();
                                    if(var64 == null) {
                                       if(Widget.field2823) {
                                          class171.method3363(var10);
                                       }
                                       continue;
                                    }

                                    var20 = 0;

                                    for(var21 = 0; var21 < var10.originalHeight; ++var21) {
                                       for(var22 = 0; var22 < var10.originalWidth; ++var22) {
                                          if(var10.itemIds[var20] > 0) {
                                             var50 = class251.getItemDefinition(var10.itemIds[var20] - 1);
                                             String var52;
                                             if(var50.isStackable != 1 && var10.itemQuantities[var20] == 1) {
                                                var52 = IndexFile.getColTags(16748608) + var50.name + "</col>";
                                             } else {
                                                var52 = IndexFile.getColTags(16748608) + var50.name + "</col>" + " " + 'x' + MapIconReference.method710(var10.itemQuantities[var20]);
                                             }

                                             var25 = var12 + var22 * (var10.paddingX + 115);
                                             var26 = var13 + (var10.paddingY + 12) * var21;
                                             if(var10.field2888 == 0) {
                                                var64.method5689(var52, var25, var26, var10.textColor, var10.textShadowed?0:-1);
                                             } else if(var10.field2888 == 1) {
                                                var64.drawTextCentered(var52, var10.width / 2 + var25, var26, var10.textColor, var10.textShadowed?0:-1);
                                             } else {
                                                var64.method5617(var52, var25 + var10.width - 1, var26, var10.textColor, var10.textShadowed?0:-1);
                                             }
                                          }

                                          ++var20;
                                       }
                                    }
                                 }

                                 if(var10.type == 8 && var10 == class35.field497 && Client.field1002 == Client.field1001) {
                                    var19 = 0;
                                    var20 = 0;
                                    Font var48 = SoundTaskDataProvider.font_p12full;
                                    String var49 = var10.text;

                                    String var69;
                                    for(var49 = class61.method1022(var49, var10); var49.length() > 0; var20 = var20 + var48.verticalSpace + 1) {
                                       var24 = var49.indexOf("<br>");
                                       if(var24 != -1) {
                                          var69 = var49.substring(0, var24);
                                          var49 = var49.substring(var24 + 4);
                                       } else {
                                          var69 = var49;
                                          var49 = "";
                                       }

                                       var25 = var48.getTextWidth(var69);
                                       if(var25 > var19) {
                                          var19 = var25;
                                       }
                                    }

                                    var19 += 6;
                                    var20 += 7;
                                    var24 = var12 + var10.width - 5 - var19;
                                    var25 = var13 + var10.height + 5;
                                    if(var24 < var12 + 5) {
                                       var24 = var12 + 5;
                                    }

                                    if(var19 + var24 > var4) {
                                       var24 = var4 - var19;
                                    }

                                    if(var25 + var20 > var5) {
                                       var25 = var5 - var20;
                                    }

                                    Rasterizer2D.Rasterizer2D_fillRectangle(var24, var25, var19, var20, 16777120);
                                    Rasterizer2D.drawRectangle(var24, var25, var19, var20, 0);
                                    var49 = var10.text;
                                    var26 = var25 + var48.verticalSpace + 2;

                                    for(var49 = class61.method1022(var49, var10); var49.length() > 0; var26 = var26 + var48.verticalSpace + 1) {
                                       var51 = var49.indexOf("<br>");
                                       if(var51 != -1) {
                                          var69 = var49.substring(0, var51);
                                          var49 = var49.substring(var51 + 4);
                                       } else {
                                          var69 = var49;
                                          var49 = "";
                                       }

                                       var48.method5689(var69, var24 + 3, var26, 0, -1);
                                    }
                                 }

                                 if(var10.type == 9) {
                                    if(var10.field2946) {
                                       var19 = var12;
                                       var20 = var13 + var10.height;
                                       var21 = var12 + var10.width;
                                       var22 = var13;
                                    } else {
                                       var19 = var12;
                                       var20 = var13;
                                       var21 = var12 + var10.width;
                                       var22 = var13 + var10.height;
                                    }

                                    if(var10.lineWidth == 1) {
                                       Rasterizer2D.drawLine(var19, var20, var21, var22, var10.textColor);
                                    } else {
                                       var25 = var10.textColor;
                                       var26 = var10.lineWidth;
                                       var51 = var21 - var19;
                                       var28 = var22 - var20;
                                       var29 = var51 >= 0?var51:-var51;
                                       var30 = var28 >= 0?var28:-var28;
                                       var31 = var29;
                                       if(var29 < var30) {
                                          var31 = var30;
                                       }

                                       if(var31 != 0) {
                                          int var32 = (var51 << 16) / var31;
                                          var33 = (var28 << 16) / var31;
                                          if(var33 <= var32) {
                                             var32 = -var32;
                                          } else {
                                             var33 = -var33;
                                          }

                                          var34 = var26 * var33 >> 17;
                                          var35 = var26 * var33 + 1 >> 17;
                                          int var36 = var26 * var32 >> 17;
                                          var37 = var32 * var26 + 1 >> 17;
                                          var23 = var19 - Rasterizer2D.draw_region_x;
                                          var24 = var20 - Rasterizer2D.drawingAreaTop;
                                          var38 = var23 + var34;
                                          var39 = var23 - var35;
                                          var40 = var23 + var51 - var35;
                                          var41 = var34 + var51 + var23;
                                          int var42 = var36 + var24;
                                          var43 = var24 - var37;
                                          var44 = var24 + var28 - var37;
                                          var45 = var24 + var28 + var36;
                                          Graphics3D.setRasterClippingEnabled(var38, var39, var40);
                                          Graphics3D.rasterFlat(var42, var43, var44, var38, var39, var40, var25);
                                          Graphics3D.setRasterClippingEnabled(var38, var40, var41);
                                          Graphics3D.rasterFlat(var42, var44, var45, var38, var40, var41, var25);
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
