import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("u")
public class class11 {
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Lu;"
   )
   @Export("BoundingBox3DDrawMode_mouseOver")
   public static final class11 BoundingBox3DDrawMode_mouseOver;
   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "Lu;"
   )
   @Export("BoundingBox3DDrawMode_all")
   public static final class11 BoundingBox3DDrawMode_all;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 2068281525
   )
   static int field254;

   static {
      BoundingBox3DDrawMode_mouseOver = new class11();
      BoundingBox3DDrawMode_all = new class11();
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(ILcv;ZI)I",
      garbageValue = "132499247"
   )
   static int method54(int var0, Script var1, boolean var2) {
      Widget var3;
      if(var0 >= 2000) {
         var0 -= 1000;
         var3 = UrlRequester.getWidget(class82.intStack[--class82.intStackSize]);
      } else {
         var3 = var2?class82.field1267:CombatInfo1.field1216;
      }

      class28.method220(var3);
      if(var0 != 1200 && var0 != 1205 && var0 != 1212) {
         if(var0 == 1201) {
            var3.modelType = 2;
            var3.modelId = class82.intStack[--class82.intStackSize];
            return 1;
         } else if(var0 == 1202) {
            var3.modelType = 3;
            var3.modelId = GrandExchangeOffer.localPlayer.composition.method4186();
            return 1;
         } else {
            return 2;
         }
      } else {
         class82.intStackSize -= 2;
         int var4 = class82.intStack[class82.intStackSize];
         int var5 = class82.intStack[class82.intStackSize + 1];
         var3.itemId = var4;
         var3.itemQuantity = var5;
         ItemComposition var6 = class115.getItemDefinition(var4);
         var3.rotationX = var6.xan2d;
         var3.rotationZ = var6.yan2d;
         var3.rotationY = var6.zan2d;
         var3.field2868 = var6.offsetX2d;
         var3.field2812 = var6.offsetY2d;
         var3.modelZoom = var6.zoom2d;
         if(var0 == 1205) {
            var3.field2784 = 0;
         } else if(var0 == 1212 | 1 == var6.isStackable) {
            var3.field2784 = 1;
         } else {
            var3.field2784 = 2;
         }

         if(var3.field2817 > 0) {
            var3.modelZoom = var3.modelZoom * 32 / var3.field2817;
         } else if(var3.originalWidth > 0) {
            var3.modelZoom = var3.modelZoom * 32 / var3.originalWidth;
         }

         return 1;
      }
   }

   @ObfuscatedName("im")
   @ObfuscatedSignature(
      signature = "([Lhq;IIIIIIIII)V",
      garbageValue = "-559056018"
   )
   @Export("gameDraw")
   static final void gameDraw(Widget[] var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
      Rasterizer2D.setDrawRegion(var2, var3, var4, var5);
      Graphics3D.Rasterizer3D_method1();

      for(int var9 = 0; var9 < var0.length; ++var9) {
         Widget var10 = var0[var9];
         if(var10 != null && (var10.parentId == var1 || var1 == -1412584499 && var10 == Client.field1028)) {
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
            if(!var10.hasScript || !class20.method150(var10)) {
               if(var10.contentType > 0) {
                  class22.method164(var10);
               }

               int var12 = var10.relativeX + var6;
               int var13 = var7 + var10.relativeY;
               int var14 = var10.opacity;
               int var15;
               int var16;
               if(var10 == Client.field1028) {
                  if(var1 != -1412584499 && !var10.field2776) {
                     FontName.field3710 = var0;
                     class60.field719 = var6;
                     Client.field1134 = var7;
                     continue;
                  }

                  if(Client.field1039 && Client.field1033) {
                     var15 = MouseInput.mouseLastX;
                     var16 = MouseInput.mouseLastY;
                     var15 -= Client.field925;
                     var16 -= Client.field1001;
                     if(var15 < Client.field1034) {
                        var15 = Client.field1034;
                     }

                     if(var15 + var10.width > Client.field1034 + Client.field1029.width) {
                        var15 = Client.field1034 + Client.field1029.width - var10.width;
                     }

                     if(var16 < Client.field1035) {
                        var16 = Client.field1035;
                     }

                     if(var16 + var10.height > Client.field1035 + Client.field1029.height) {
                        var16 = Client.field1035 + Client.field1029.height - var10.height;
                     }

                     var12 = var15;
                     var13 = var16;
                  }

                  if(!var10.field2776) {
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
                  int var25;
                  int var26;
                  int var27;
                  int var28;
                  int var29;
                  int var30;
                  int var31;
                  int var32;
                  int var33;
                  int var34;
                  int var35;
                  int var36;
                  int var50;
                  if(var10.contentType != 0) {
                     if(var10.contentType == 1336) {
                        if(Client.displayFps) {
                           var13 += 15;
                           CombatInfo1.font_p12full.method4952("Fps:" + GameEngine.FPS, var12 + var10.width, var13, 16776960, -1);
                           var13 += 15;
                           Runtime var62 = Runtime.getRuntime();
                           var20 = (int)((var62.totalMemory() - var62.freeMemory()) / 1024L);
                           var21 = 16776960;
                           if(var20 > 32768 && Client.lowMemory) {
                              var21 = 16711680;
                           }

                           if(var20 > 65536 && !Client.lowMemory) {
                              var21 = 16711680;
                           }

                           CombatInfo1.font_p12full.method4952("Mem:" + var20 + "k", var12 + var10.width, var13, var21, -1);
                           var13 += 15;
                        }
                        continue;
                     }

                     if(var10.contentType == 1337) {
                        Client.field1004 = var12;
                        Client.field1005 = var13;
                        var21 = var10.width;
                        var22 = var10.height;
                        ++Client.field919;
                        MilliTimer.method3007();
                        GrandExchangeEvent.method77();
                        class33.method344();
                        SoundTaskDataProvider.method761(true);
                        var23 = class94.playerIndexesCount;
                        int[] var55 = class94.playerIndices;

                        for(var25 = 0; var25 < var23; ++var25) {
                           if(var55[var25] != Client.field974 && var55[var25] != Client.localInteractingIndex) {
                              ItemContainer.method1097(Client.cachedPlayers[var55[var25]], true);
                           }
                        }

                        SoundTaskDataProvider.method761(false);

                        for(Projectile var65 = (Projectile)Client.projectiles.getFront(); var65 != null; var65 = (Projectile)Client.projectiles.getNext()) {
                           if(var65.floor == class7.plane && Client.gameCycle <= var65.endCycle) {
                              if(Client.gameCycle >= var65.startMovementCycle) {
                                 if(var65.interacting > 0) {
                                    NPC var56 = Client.cachedNPCs[var65.interacting - 1];
                                    if(var56 != null && var56.x >= 0 && var56.x < 13312 && var56.y >= 0 && var56.y < 13312) {
                                       var65.moveProjectile(var56.x, var56.y, MouseInput.getTileHeight(var56.x, var56.y, var65.floor) - var65.endHeight, Client.gameCycle);
                                    }
                                 }

                                 if(var65.interacting < 0) {
                                    var25 = -var65.interacting - 1;
                                    Player var57;
                                    if(var25 == Client.localInteractingIndex) {
                                       var57 = GrandExchangeOffer.localPlayer;
                                    } else {
                                       var57 = Client.cachedPlayers[var25];
                                    }

                                    if(var57 != null && var57.x >= 0 && var57.x < 13312 && var57.y >= 0 && var57.y < 13312) {
                                       var65.moveProjectile(var57.x, var57.y, MouseInput.getTileHeight(var57.x, var57.y, var65.floor) - var65.endHeight, Client.gameCycle);
                                    }
                                 }

                                 var65.update(Client.field944);
                                 class45.region.method2829(class7.plane, (int)var65.x, (int)var65.y, (int)var65.z, 60, var65, var65.rotationX, -1, false);
                              }
                           } else {
                              var65.unlink();
                           }
                        }

                        for(GraphicsObject var67 = (GraphicsObject)Client.graphicsObjectDeque.getFront(); var67 != null; var67 = (GraphicsObject)Client.graphicsObjectDeque.getNext()) {
                           if(var67.level == class7.plane && !var67.finished) {
                              if(Client.gameCycle >= var67.startCycle) {
                                 var67.method1687(Client.field944);
                                 if(var67.finished) {
                                    var67.unlink();
                                 } else {
                                    class45.region.method2829(var67.level, var67.x, var67.y, var67.height, 60, var67, 0, -1, false);
                                 }
                              }
                           } else {
                              var67.unlink();
                           }
                        }

                        Player.method1159(var12, var13, var21, var22, true);
                        var19 = Client.Viewport_xOffset;
                        var20 = Client.Viewport_yOffset;
                        var21 = Client.viewportHeight;
                        var22 = Client.viewportWidth;
                        Rasterizer2D.setDrawRegion(var19, var20, var19 + var21, var20 + var22);
                        Graphics3D.Rasterizer3D_method1();
                        if(!Client.field1101) {
                           var23 = Client.field1092;
                           if(Client.field947 / 256 > var23) {
                              var23 = Client.field947 / 256;
                           }

                           if(Client.field1097[4] && Client.field1104[4] + 128 > var23) {
                              var23 = Client.field1104[4] + 128;
                           }

                           var50 = Client.mapAngle & 2047;
                           var25 = IndexData.field3340;
                           var26 = MouseInput.getTileHeight(GrandExchangeOffer.localPlayer.x, GrandExchangeOffer.localPlayer.y, class7.plane) - Client.field1023;
                           var27 = SoundTask.field1575;
                           var28 = var23 * 3 + 600;
                           var29 = 2048 - var23 & 2047;
                           var30 = 2048 - var50 & 2047;
                           var31 = 0;
                           var32 = 0;
                           var33 = var28;
                           if(var29 != 0) {
                              var34 = Graphics3D.SINE[var29];
                              var35 = Graphics3D.COSINE[var29];
                              var36 = var35 * var32 - var28 * var34 >> 16;
                              var33 = var28 * var35 + var34 * var32 >> 16;
                              var32 = var36;
                           }

                           if(var30 != 0) {
                              var34 = Graphics3D.SINE[var30];
                              var35 = Graphics3D.COSINE[var30];
                              var36 = var35 * var31 + var33 * var34 >> 16;
                              var33 = var33 * var35 - var31 * var34 >> 16;
                              var31 = var36;
                           }

                           GameEngine.cameraX = var25 - var31;
                           ScriptEvent.cameraZ = var26 - var32;
                           MouseInput.cameraY = var27 - var33;
                           SoundTask.cameraPitch = var23;
                           class2.cameraYaw = var50;
                        }

                        if(!Client.field1101) {
                           if(class222.preferences.hideRoofs) {
                              var50 = class7.plane;
                           } else {
                              label1668: {
                                 var25 = 3;
                                 if(SoundTask.cameraPitch < 310) {
                                    var26 = GameEngine.cameraX >> 7;
                                    var27 = MouseInput.cameraY >> 7;
                                    var28 = GrandExchangeOffer.localPlayer.x >> 7;
                                    var29 = GrandExchangeOffer.localPlayer.y >> 7;
                                    if(var26 < 0 || var27 < 0 || var26 >= 104 || var27 >= 104) {
                                       var50 = class7.plane;
                                       break label1668;
                                    }

                                    if((class61.tileSettings[class7.plane][var26][var27] & 4) != 0) {
                                       var25 = class7.plane;
                                    }

                                    if(var28 > var26) {
                                       var30 = var28 - var26;
                                    } else {
                                       var30 = var26 - var28;
                                    }

                                    if(var29 > var27) {
                                       var31 = var29 - var27;
                                    } else {
                                       var31 = var27 - var29;
                                    }

                                    if(var30 > var31) {
                                       var32 = var31 * 65536 / var30;
                                       var33 = 32768;

                                       while(var26 != var28) {
                                          if(var26 < var28) {
                                             ++var26;
                                          } else if(var26 > var28) {
                                             --var26;
                                          }

                                          if((class61.tileSettings[class7.plane][var26][var27] & 4) != 0) {
                                             var25 = class7.plane;
                                          }

                                          var33 += var32;
                                          if(var33 >= 65536) {
                                             var33 -= 65536;
                                             if(var27 < var29) {
                                                ++var27;
                                             } else if(var27 > var29) {
                                                --var27;
                                             }

                                             if((class61.tileSettings[class7.plane][var26][var27] & 4) != 0) {
                                                var25 = class7.plane;
                                             }
                                          }
                                       }
                                    } else {
                                       var32 = var30 * 65536 / var31;
                                       var33 = 32768;

                                       while(var29 != var27) {
                                          if(var27 < var29) {
                                             ++var27;
                                          } else if(var27 > var29) {
                                             --var27;
                                          }

                                          if((class61.tileSettings[class7.plane][var26][var27] & 4) != 0) {
                                             var25 = class7.plane;
                                          }

                                          var33 += var32;
                                          if(var33 >= 65536) {
                                             var33 -= 65536;
                                             if(var26 < var28) {
                                                ++var26;
                                             } else if(var26 > var28) {
                                                --var26;
                                             }

                                             if((class61.tileSettings[class7.plane][var26][var27] & 4) != 0) {
                                                var25 = class7.plane;
                                             }
                                          }
                                       }
                                    }
                                 }

                                 if(GrandExchangeOffer.localPlayer.x >= 0 && GrandExchangeOffer.localPlayer.y >= 0 && GrandExchangeOffer.localPlayer.x < 13312 && GrandExchangeOffer.localPlayer.y < 13312) {
                                    if((class61.tileSettings[class7.plane][GrandExchangeOffer.localPlayer.x >> 7][GrandExchangeOffer.localPlayer.y >> 7] & 4) != 0) {
                                       var25 = class7.plane;
                                    }

                                    var50 = var25;
                                 } else {
                                    var50 = class7.plane;
                                 }
                              }
                           }

                           var23 = var50;
                        } else {
                           if(class222.preferences.hideRoofs) {
                              var50 = class7.plane;
                           } else {
                              var25 = MouseInput.getTileHeight(GameEngine.cameraX, MouseInput.cameraY, class7.plane);
                              if(var25 - ScriptEvent.cameraZ < 800 && (class61.tileSettings[class7.plane][GameEngine.cameraX >> 7][MouseInput.cameraY >> 7] & 4) != 0) {
                                 var50 = class7.plane;
                              } else {
                                 var50 = 3;
                              }
                           }

                           var23 = var50;
                        }

                        var50 = GameEngine.cameraX;
                        var25 = ScriptEvent.cameraZ;
                        var26 = MouseInput.cameraY;
                        var27 = SoundTask.cameraPitch;
                        var28 = class2.cameraYaw;

                        for(var29 = 0; var29 < 5; ++var29) {
                           if(Client.field1097[var29]) {
                              var30 = (int)(Math.random() * (double)(Client.field929[var29] * 2 + 1) - (double)Client.field929[var29] + Math.sin((double)Client.field1105[var29] / 100.0D * (double)Client.field1043[var29]) * (double)Client.field1104[var29]);
                              if(var29 == 0) {
                                 GameEngine.cameraX += var30;
                              }

                              if(var29 == 1) {
                                 ScriptEvent.cameraZ += var30;
                              }

                              if(var29 == 2) {
                                 MouseInput.cameraY += var30;
                              }

                              if(var29 == 3) {
                                 class2.cameraYaw = var30 + class2.cameraYaw & 2047;
                              }

                              if(var29 == 4) {
                                 SoundTask.cameraPitch += var30;
                                 if(SoundTask.cameraPitch < 128) {
                                    SoundTask.cameraPitch = 128;
                                 }

                                 if(SoundTask.cameraPitch > 383) {
                                    SoundTask.cameraPitch = 383;
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

                        if(var29 >= var19 && var29 < var21 + var19 && var30 >= var20 && var30 < var22 + var20) {
                           var31 = var29 - var19;
                           var32 = var30 - var20;
                           class133.Viewport_mouseX = var31;
                           class133.Viewport_mouseY = var32;
                           class133.Viewport_containsMouse = true;
                           class133.Viewport_entityCountAtMouse = 0;
                           class133.Viewport_false0 = false;
                        } else {
                           class133.Viewport_containsMouse = false;
                           class133.Viewport_entityCountAtMouse = 0;
                        }

                        FontName.method4928();
                        Rasterizer2D.Rasterizer2D_fillRectangle(var19, var20, var21, var22, 0);
                        FontName.method4928();
                        var31 = Graphics3D.Rasterizer3D_zoom;
                        Graphics3D.Rasterizer3D_zoom = Client.scale;
                        class45.region.draw(GameEngine.cameraX, ScriptEvent.cameraZ, MouseInput.cameraY, SoundTask.cameraPitch, class2.cameraYaw, var23);
                        class5.method13();
                        Graphics3D.Rasterizer3D_zoom = var31;
                        FontName.method4928();
                        class45.region.clearEntities();
                        BaseVarType.method4(var19, var20, var21, var22);
                        if(Client.hintArrowTargetType == 2) {
                           class61.worldToScreen((Client.hintArrowX - class175.baseX << 7) + Client.hintArrowOffsetX, (Client.hintArrowY - GraphicsObject.baseY << 7) + Client.hintArrowOffsetY, Client.hintArrowType * 2);
                           if(Client.screenX > -1 && Client.gameCycle % 20 < 10) {
                              GameEngine.headIconsHint[0].drawAt(var19 + Client.screenX - 12, var20 + Client.screenY - 28);
                           }
                        }

                        ((TextureProvider)Graphics3D.textureLoader).method2447(Client.field944);
                        if(Client.cursorState == 1) {
                           MessageNode.crossSprites[Client.field964 / 100].drawAt(Client.lastLeftClickX - 8, Client.lastLeftClickY - 8);
                        }

                        if(Client.cursorState == 2) {
                           MessageNode.crossSprites[Client.field964 / 100 + 4].drawAt(Client.lastLeftClickX - 8, Client.lastLeftClickY - 8);
                        }

                        Client.myPlayerIndex = 0;
                        var32 = (GrandExchangeOffer.localPlayer.x >> 7) + class175.baseX;
                        var33 = (GrandExchangeOffer.localPlayer.y >> 7) + GraphicsObject.baseY;
                        if(var32 >= 3053 && var32 <= 3156 && var33 >= 3056 && var33 <= 3136) {
                           Client.myPlayerIndex = 1;
                        }

                        if(var32 >= 3072 && var32 <= 3118 && var33 >= 9492 && var33 <= 9535) {
                           Client.myPlayerIndex = 1;
                        }

                        if(Client.myPlayerIndex == 1 && var32 >= 3139 && var32 <= 3199 && var33 >= 3008 && var33 <= 3062) {
                           Client.myPlayerIndex = 0;
                        }

                        GameEngine.cameraX = var50;
                        ScriptEvent.cameraZ = var25;
                        MouseInput.cameraY = var26;
                        SoundTask.cameraPitch = var27;
                        class2.cameraYaw = var28;
                        if(Client.field881 && Ignore.method1115(true, false) == 0) {
                           Client.field881 = false;
                        }

                        if(Client.field881) {
                           Rasterizer2D.Rasterizer2D_fillRectangle(var19, var20, var21, var22, 0);
                           GrandExchangeEvents.drawStatusBox("Loading - please wait.", false);
                        }

                        Client.field1041[var10.boundsIndex] = true;
                        Rasterizer2D.setDrawRegion(var2, var3, var4, var5);
                        continue;
                     }

                     if(var10.contentType == 1338) {
                        Buffer.method3553(var10, var12, var13, var11);
                        Rasterizer2D.setDrawRegion(var2, var3, var4, var5);
                        continue;
                     }

                     if(var10.contentType == 1339) {
                        SoundTask.method2131(var10, var12, var13, var11);
                        Rasterizer2D.setDrawRegion(var2, var3, var4, var5);
                        continue;
                     }

                     if(var10.contentType == 1400) {
                        TextureProvider.renderOverview.extractWorldmap(var12, var13, var10.width, var10.height, Client.gameCycle);
                     }

                     if(var10.contentType == 1401) {
                        TextureProvider.renderOverview.extractData(var12, var13, var10.width, var10.height);
                     }
                  }

                  if(var10.type == 0) {
                     if(!var10.hasScript && class20.method150(var10) && var10 != BoundingBox.field239) {
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

                     WidgetNode var46 = (WidgetNode)Client.componentTable.get((long)var10.id);
                     if(var46 != null) {
                        class40.method538(var46.id, var15, var16, var17, var18, var12, var13, var11);
                     }

                     Rasterizer2D.setDrawRegion(var2, var3, var4, var5);
                     Graphics3D.Rasterizer3D_method1();
                  }

                  if(Client.isResized || Client.field975[var11] || Client.gameDrawingMode > 1) {
                     if(var10.type == 0 && !var10.hasScript && var10.scrollHeight > var10.height) {
                        var19 = var12 + var10.width;
                        var20 = var10.scrollY;
                        var21 = var10.height;
                        var22 = var10.scrollHeight;
                        GameEngine.scrollbarSprites[0].method5253(var19, var13);
                        GameEngine.scrollbarSprites[1].method5253(var19, var13 + var21 - 16);
                        Rasterizer2D.Rasterizer2D_fillRectangle(var19, var13 + 16, 16, var21 - 32, Client.field1087);
                        var23 = var21 * (var21 - 32) / var22;
                        if(var23 < 8) {
                           var23 = 8;
                        }

                        var50 = var20 * (var21 - 32 - var23) / (var22 - var21);
                        Rasterizer2D.Rasterizer2D_fillRectangle(var19, var50 + var13 + 16, 16, var23, Client.field933);
                        Rasterizer2D.method5168(var19, var13 + var50 + 16, var23, Client.field935);
                        Rasterizer2D.method5168(var19 + 1, var50 + var13 + 16, var23, Client.field935);
                        Rasterizer2D.method5186(var19, var50 + var13 + 16, 16, Client.field935);
                        Rasterizer2D.method5186(var19, var50 + var13 + 17, 16, Client.field935);
                        Rasterizer2D.method5168(var19 + 15, var50 + var13 + 16, var23, Client.field1008);
                        Rasterizer2D.method5168(var19 + 14, var50 + var13 + 17, var23 - 1, Client.field1008);
                        Rasterizer2D.method5186(var19, var50 + var13 + var23 + 15, 16, Client.field1008);
                        Rasterizer2D.method5186(var19 + 1, var23 + var13 + var50 + 14, 15, Client.field1008);
                     }

                     if(var10.type != 1) {
                        if(var10.type == 2) {
                           var19 = 0;

                           for(var20 = 0; var20 < var10.originalHeight; ++var20) {
                              for(var21 = 0; var21 < var10.originalWidth; ++var21) {
                                 var22 = var21 * (var10.paddingX + 32) + var12;
                                 var23 = var13 + var20 * (var10.paddingY + 32);
                                 if(var19 < 20) {
                                    var22 += var10.xSprites[var19];
                                    var23 += var10.field2874[var19];
                                 }

                                 if(var10.itemIds[var19] <= 0) {
                                    if(var10.field2832 != null && var19 < 20) {
                                       SpritePixels var54 = var10.method4207(var19);
                                       if(var54 != null) {
                                          var54.drawAt(var22, var23);
                                       } else if(Widget.field2760) {
                                          class28.method220(var10);
                                       }
                                    }
                                 } else {
                                    boolean var69 = false;
                                    boolean var58 = false;
                                    var26 = var10.itemIds[var19] - 1;
                                    if(var22 + 32 > var2 && var22 < var4 && var23 + 32 > var3 && var23 < var5 || var10 == Frames.field2040 && var19 == Client.field968) {
                                       SpritePixels var51;
                                       if(Client.itemSelectionState == 1 && var19 == class22.selectedItemIndex && var10.id == class33.field448) {
                                          var51 = CacheFile.createSprite(var26, var10.itemQuantities[var19], 2, 0, 2, false);
                                       } else {
                                          var51 = CacheFile.createSprite(var26, var10.itemQuantities[var19], 1, 3153952, 2, false);
                                       }

                                       if(var51 != null) {
                                          if(var10 == Frames.field2040 && var19 == Client.field968) {
                                             var50 = MouseInput.mouseLastX - Client.field969;
                                             var25 = MouseInput.mouseLastY - Client.field970;
                                             if(var50 < 5 && var50 > -5) {
                                                var50 = 0;
                                             }

                                             if(var25 < 5 && var25 > -5) {
                                                var25 = 0;
                                             }

                                             if(Client.itemPressedDuration < 5) {
                                                var50 = 0;
                                                var25 = 0;
                                             }

                                             var51.drawAtOpacity(var50 + var22, var23 + var25, 128);
                                             if(var1 != -1) {
                                                Widget var52 = var0[var1 & 65535];
                                                if(var23 + var25 < Rasterizer2D.drawingAreaTop && var52.scrollY > 0) {
                                                   var29 = (Rasterizer2D.drawingAreaTop - var23 - var25) * Client.field944 / 3;
                                                   if(var29 > Client.field944 * 10) {
                                                      var29 = Client.field944 * 10;
                                                   }

                                                   if(var29 > var52.scrollY) {
                                                      var29 = var52.scrollY;
                                                   }

                                                   var52.scrollY -= var29;
                                                   Client.field970 += var29;
                                                   class28.method220(var52);
                                                }

                                                if(var25 + var23 + 32 > Rasterizer2D.drawingAreaRight && var52.scrollY < var52.scrollHeight - var52.height) {
                                                   var29 = (var25 + var23 + 32 - Rasterizer2D.drawingAreaRight) * Client.field944 / 3;
                                                   if(var29 > Client.field944 * 10) {
                                                      var29 = Client.field944 * 10;
                                                   }

                                                   if(var29 > var52.scrollHeight - var52.height - var52.scrollY) {
                                                      var29 = var52.scrollHeight - var52.height - var52.scrollY;
                                                   }

                                                   var52.scrollY += var29;
                                                   Client.field970 -= var29;
                                                   class28.method220(var52);
                                                }
                                             }
                                          } else if(var10 == WorldMapData.field438 && var19 == Client.pressedItemIndex) {
                                             var51.drawAtOpacity(var22, var23, 128);
                                          } else {
                                             var51.drawAt(var22, var23);
                                          }
                                       } else {
                                          class28.method220(var10);
                                       }
                                    }
                                 }

                                 ++var19;
                              }
                           }
                        } else if(var10.type == 3) {
                           if(Client.method1223(var10)) {
                              var19 = var10.field2788;
                              if(var10 == BoundingBox.field239 && var10.field2790 != 0) {
                                 var19 = var10.field2790;
                              }
                           } else {
                              var19 = var10.textColor;
                              if(var10 == BoundingBox.field239 && var10.field2809 != 0) {
                                 var19 = var10.field2809;
                              }
                           }

                           if(var10.filled) {
                              switch(var10.field2792.field3843) {
                              case 1:
                                 Rasterizer2D.method5173(var12, var13, var10.width, var10.height, var10.textColor, var10.field2788, 256 - (var10.opacity & 255), 256 - (var10.field2896 & 255));
                                 break;
                              case 2:
                                 Rasterizer2D.method5223(var12, var13, var10.width, var10.height, var10.textColor, var10.field2788, 256 - (var10.opacity & 255), 256 - (var10.field2896 & 255));
                                 break;
                              case 3:
                                 Rasterizer2D.method5214(var12, var13, var10.width, var10.height, var10.textColor, var10.field2788, 256 - (var10.opacity & 255), 256 - (var10.field2896 & 255));
                                 break;
                              case 4:
                                 Rasterizer2D.method5220(var12, var13, var10.width, var10.height, var10.textColor, var10.field2788, 256 - (var10.opacity & 255), 256 - (var10.field2896 & 255));
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
                           Font var59;
                           if(var10.type == 4) {
                              var59 = var10.getFont();
                              if(var59 == null) {
                                 if(Widget.field2760) {
                                    class28.method220(var10);
                                 }
                              } else {
                                 String var66 = var10.text;
                                 if(Client.method1223(var10)) {
                                    var20 = var10.field2788;
                                    if(var10 == BoundingBox.field239 && var10.field2790 != 0) {
                                       var20 = var10.field2790;
                                    }

                                    if(var10.string1.length() > 0) {
                                       var66 = var10.string1;
                                    }
                                 } else {
                                    var20 = var10.textColor;
                                    if(var10 == BoundingBox.field239 && var10.field2809 != 0) {
                                       var20 = var10.field2809;
                                    }
                                 }

                                 if(var10.hasScript && var10.itemId != -1) {
                                    ItemComposition var68 = class115.getItemDefinition(var10.itemId);
                                    var66 = var68.name;
                                    if(var66 == null) {
                                       var66 = "null";
                                    }

                                    if((var68.isStackable == 1 || var10.itemQuantity != 1) && var10.itemQuantity != -1) {
                                       var66 = class54.getColTags(16748608) + var66 + "</col>" + " " + 'x' + class31.method269(var10.itemQuantity);
                                    }
                                 }

                                 if(var10 == Client.field1019) {
                                    Object var10000 = null;
                                    var66 = "Please wait...";
                                    var20 = var10.textColor;
                                 }

                                 if(!var10.hasScript) {
                                    var66 = BoundingBox3D.method53(var66, var10);
                                 }

                                 var59.method4954(var66, var12, var13, var10.width, var10.height, var20, var10.textShadowed?0:-1, var10.field2825, var10.field2761, var10.field2835);
                              }
                           } else if(var10.type == 5) {
                              SpritePixels var60;
                              if(!var10.hasScript) {
                                 var60 = var10.method4199(Client.method1223(var10));
                                 if(var60 != null) {
                                    var60.drawAt(var12, var13);
                                 } else if(Widget.field2760) {
                                    class28.method220(var10);
                                 }
                              } else {
                                 if(var10.itemId != -1) {
                                    var60 = CacheFile.createSprite(var10.itemId, var10.itemQuantity, var10.borderThickness, var10.sprite2, var10.field2784, false);
                                 } else {
                                    var60 = var10.method4199(false);
                                 }

                                 if(var60 == null) {
                                    if(Widget.field2760) {
                                       class28.method220(var10);
                                    }
                                 } else {
                                    var20 = var60.maxWidth;
                                    var21 = var60.maxHeight;
                                    if(!var10.spriteTiling) {
                                       var22 = var10.width * 4096 / var20;
                                       if(var10.textureId != 0) {
                                          var60.method5295(var10.width / 2 + var12, var10.height / 2 + var13, var10.textureId, var22);
                                       } else if(var14 != 0) {
                                          var60.method5290(var12, var13, var10.width, var10.height, 256 - (var14 & 255));
                                       } else if(var20 == var10.width && var21 == var10.height) {
                                          var60.drawAt(var12, var13);
                                       } else {
                                          var60.method5284(var12, var13, var10.width, var10.height);
                                       }
                                    } else {
                                       Rasterizer2D.setInnerDrawRegion(var12, var13, var12 + var10.width, var13 + var10.height);
                                       var22 = (var20 - 1 + var10.width) / var20;
                                       var23 = (var21 - 1 + var10.height) / var21;

                                       for(var50 = 0; var50 < var22; ++var50) {
                                          for(var25 = 0; var25 < var23; ++var25) {
                                             if(var10.textureId != 0) {
                                                var60.method5295(var20 / 2 + var12 + var20 * var50, var21 / 2 + var13 + var21 * var25, var10.textureId, 4096);
                                             } else if(var14 != 0) {
                                                var60.drawAtOpacity(var12 + var20 * var50, var13 + var21 * var25, 256 - (var14 & 255));
                                             } else {
                                                var60.drawAt(var12 + var20 * var50, var13 + var21 * var25);
                                             }
                                          }
                                       }

                                       Rasterizer2D.setDrawRegion(var2, var3, var4, var5);
                                    }
                                 }
                              }
                           } else {
                              ItemComposition var47;
                              if(var10.type == 6) {
                                 boolean var53 = Client.method1223(var10);
                                 if(var53) {
                                    var20 = var10.field2810;
                                 } else {
                                    var20 = var10.field2749;
                                 }

                                 Model var63 = null;
                                 var22 = 0;
                                 if(var10.itemId != -1) {
                                    var47 = class115.getItemDefinition(var10.itemId);
                                    if(var47 != null) {
                                       var47 = var47.method4767(var10.itemQuantity);
                                       var63 = var47.getModel(1);
                                       if(var63 != null) {
                                          var63.calculateBoundsCylinder();
                                          var22 = var63.modelHeight / 2;
                                       } else {
                                          class28.method220(var10);
                                       }
                                    }
                                 } else if(var10.modelType == 5) {
                                    if(var10.modelId == 0) {
                                       var63 = Client.field1126.getModel((Sequence)null, -1, (Sequence)null, -1);
                                    } else {
                                       var63 = GrandExchangeOffer.localPlayer.getModel();
                                    }
                                 } else if(var20 == -1) {
                                    var63 = var10.getModel((Sequence)null, -1, var53, GrandExchangeOffer.localPlayer.composition);
                                    if(var63 == null && Widget.field2760) {
                                       class28.method220(var10);
                                    }
                                 } else {
                                    Sequence var64 = class45.getAnimation(var20);
                                    var63 = var10.getModel(var64, var10.field2884, var53, GrandExchangeOffer.localPlayer.composition);
                                    if(var63 == null && Widget.field2760) {
                                       class28.method220(var10);
                                    }
                                 }

                                 Graphics3D.method2671(var10.width / 2 + var12, var10.height / 2 + var13);
                                 var23 = Graphics3D.SINE[var10.rotationX] * var10.modelZoom >> 16;
                                 var50 = Graphics3D.COSINE[var10.rotationX] * var10.modelZoom >> 16;
                                 if(var63 != null) {
                                    if(!var10.hasScript) {
                                       var63.method2590(0, var10.rotationZ, 0, var10.rotationX, 0, var23, var50);
                                    } else {
                                       var63.calculateBoundsCylinder();
                                       if(var10.field2857) {
                                          var63.method2591(0, var10.rotationZ, var10.rotationY, var10.rotationX, var10.field2868, var22 + var23 + var10.field2812, var50 + var10.field2812, var10.modelZoom);
                                       } else {
                                          var63.method2590(0, var10.rotationZ, var10.rotationY, var10.rotationX, var10.field2868, var23 + var22 + var10.field2812, var50 + var10.field2812);
                                       }
                                    }
                                 }

                                 Graphics3D.Rasterizer3D_method3();
                              } else {
                                 if(var10.type == 7) {
                                    var59 = var10.getFont();
                                    if(var59 == null) {
                                       if(Widget.field2760) {
                                          class28.method220(var10);
                                       }
                                       continue;
                                    }

                                    var20 = 0;

                                    for(var21 = 0; var21 < var10.originalHeight; ++var21) {
                                       for(var22 = 0; var22 < var10.originalWidth; ++var22) {
                                          if(var10.itemIds[var20] > 0) {
                                             var47 = class115.getItemDefinition(var10.itemIds[var20] - 1);
                                             String var24;
                                             if(var47.isStackable != 1 && var10.itemQuantities[var20] == 1) {
                                                var24 = class54.getColTags(16748608) + var47.name + "</col>";
                                             } else {
                                                var24 = class54.getColTags(16748608) + var47.name + "</col>" + " " + 'x' + class31.method269(var10.itemQuantities[var20]);
                                             }

                                             var25 = var12 + var22 * (var10.paddingX + 115);
                                             var26 = var13 + (var10.paddingY + 12) * var21;
                                             if(var10.field2825 == 0) {
                                                var59.method4950(var24, var25, var26, var10.textColor, var10.textShadowed?0:-1);
                                             } else if(var10.field2825 == 1) {
                                                var59.drawTextCentered(var24, var10.width / 2 + var25, var26, var10.textColor, var10.textShadowed?0:-1);
                                             } else {
                                                var59.method4952(var24, var25 + var10.width - 1, var26, var10.textColor, var10.textShadowed?0:-1);
                                             }
                                          }

                                          ++var20;
                                       }
                                    }
                                 }

                                 if(var10.type == 8 && var10 == CacheFile.field1665 && Client.field1006 == Client.field1007) {
                                    var19 = 0;
                                    var20 = 0;
                                    Font var48 = CombatInfo1.font_p12full;
                                    String var49 = var10.text;

                                    String var61;
                                    for(var49 = BoundingBox3D.method53(var49, var10); var49.length() > 0; var20 = var20 + var48.verticalSpace + 1) {
                                       var50 = var49.indexOf("<br>");
                                       if(var50 != -1) {
                                          var61 = var49.substring(0, var50);
                                          var49 = var49.substring(var50 + 4);
                                       } else {
                                          var61 = var49;
                                          var49 = "";
                                       }

                                       var25 = var48.getTextWidth(var61);
                                       if(var25 > var19) {
                                          var19 = var25;
                                       }
                                    }

                                    var19 += 6;
                                    var20 += 7;
                                    var50 = var12 + var10.width - 5 - var19;
                                    var25 = var13 + var10.height + 5;
                                    if(var50 < var12 + 5) {
                                       var50 = var12 + 5;
                                    }

                                    if(var50 + var19 > var4) {
                                       var50 = var4 - var19;
                                    }

                                    if(var20 + var25 > var5) {
                                       var25 = var5 - var20;
                                    }

                                    Rasterizer2D.Rasterizer2D_fillRectangle(var50, var25, var19, var20, 16777120);
                                    Rasterizer2D.drawRectangle(var50, var25, var19, var20, 0);
                                    var49 = var10.text;
                                    var26 = var25 + var48.verticalSpace + 2;

                                    for(var49 = BoundingBox3D.method53(var49, var10); var49.length() > 0; var26 = var26 + var48.verticalSpace + 1) {
                                       var27 = var49.indexOf("<br>");
                                       if(var27 != -1) {
                                          var61 = var49.substring(0, var27);
                                          var49 = var49.substring(var27 + 4);
                                       } else {
                                          var61 = var49;
                                          var49 = "";
                                       }

                                       var48.method4950(var61, var50 + 3, var26, 0, -1);
                                    }
                                 }

                                 if(var10.type == 9) {
                                    if(var10.field2796) {
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
                                       var27 = var21 - var19;
                                       var28 = var22 - var20;
                                       var29 = var27 >= 0?var27:-var27;
                                       var30 = var28 >= 0?var28:-var28;
                                       var31 = var29;
                                       if(var29 < var30) {
                                          var31 = var30;
                                       }

                                       if(var31 != 0) {
                                          var32 = (var27 << 16) / var31;
                                          var33 = (var28 << 16) / var31;
                                          if(var33 <= var32) {
                                             var32 = -var32;
                                          } else {
                                             var33 = -var33;
                                          }

                                          var34 = var33 * var26 >> 17;
                                          var35 = var26 * var33 + 1 >> 17;
                                          var36 = var26 * var32 >> 17;
                                          int var37 = var26 * var32 + 1 >> 17;
                                          var23 = var19 - Rasterizer2D.draw_region_x;
                                          var50 = var20 - Rasterizer2D.drawingAreaTop;
                                          int var38 = var34 + var23;
                                          int var39 = var23 - var35;
                                          int var40 = var23 + var27 - var35;
                                          int var41 = var34 + var23 + var27;
                                          int var42 = var36 + var50;
                                          int var43 = var50 - var37;
                                          int var44 = var50 + var28 - var37;
                                          int var45 = var36 + var50 + var28;
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

   @ObfuscatedName("jm")
   @ObfuscatedSignature(
      signature = "(IIIILkg;Lhw;I)V",
      garbageValue = "1598305006"
   )
   @Export("worldToMinimap")
   static final void worldToMinimap(int var0, int var1, int var2, int var3, SpritePixels var4, class221 var5) {
      int var6 = var3 * var3 + var2 * var2;
      if(var6 > 4225 && var6 < 90000) {
         int var7 = Client.mapAngle & 2047;
         int var8 = Graphics3D.SINE[var7];
         int var9 = Graphics3D.COSINE[var7];
         int var10 = var9 * var2 + var3 * var8 >> 16;
         int var11 = var3 * var9 - var8 * var2 >> 16;
         double var12 = Math.atan2((double)var10, (double)var11);
         int var14 = var5.field2721 / 2 - 25;
         int var15 = (int)(Math.sin(var12) * (double)var14);
         int var16 = (int)(Math.cos(var12) * (double)var14);
         byte var17 = 20;
         class2.mapedge.method5360(var15 + (var0 + var5.field2721 / 2 - var17 / 2), var5.field2718 / 2 + var1 - var17 / 2 - var16 - 10, var17, var17, 15, 15, var12, 256);
      } else {
         FrameMap.drawDot(var0, var1, var2, var3, var4, var5);
      }

   }
}
