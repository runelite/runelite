import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hm")
public class class231 {
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;B)I",
      garbageValue = "84"
   )
   @Export("djb2Hash")
   public static int djb2Hash(CharSequence var0) {
      int var1 = var0.length();
      int var2 = 0;

      for(int var3 = 0; var3 < var1; ++var3) {
         var2 = (var2 << 5) - var2 + ItemContainer.charToByteCp1252(var0.charAt(var3));
      }

      return var2;
   }

   @ObfuscatedName("ir")
   @ObfuscatedSignature(
      signature = "([Lhx;IIIIIIIII)V",
      garbageValue = "-520336327"
   )
   @Export("gameDraw")
   static final void gameDraw(Widget[] var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
      Rasterizer2D.setDrawRegion(var2, var3, var4, var5);
      Graphics3D.Rasterizer3D_method1();

      for(int var9 = 0; var9 < var0.length; ++var9) {
         Widget var10 = var0[var9];
         if(var10 != null && (var10.parentId == var1 || var1 == -1412584499 && var10 == Client.field1027)) {
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
            if(!var10.hasScript || !Buffer.method3509(var10)) {
               if(var10.contentType > 0) {
                  class39.method548(var10);
               }

               int var12 = var10.relativeX + var6;
               int var13 = var7 + var10.relativeY;
               int var14 = var10.opacity;
               int var15;
               int var16;
               if(var10 == Client.field1027) {
                  if(var1 != -1412584499 && !var10.field2802) {
                     UrlRequest.field2108 = var0;
                     MouseInput.field712 = var6;
                     class31.field422 = var7;
                     continue;
                  }

                  if(Client.field1014 && Client.field1046) {
                     var15 = MouseInput.field703;
                     var16 = MouseInput.field715 * 10625923;
                     var15 -= Client.field1029;
                     var16 -= Client.field953;
                     if(var15 < Client.field1033) {
                        var15 = Client.field1033;
                     }

                     if(var15 + var10.width > Client.field1033 + Client.field1028.width) {
                        var15 = Client.field1033 + Client.field1028.width - var10.width;
                     }

                     if(var16 < Client.field1034) {
                        var16 = Client.field1034;
                     }

                     if(var16 + var10.height > Client.field1034 + Client.field1028.height) {
                        var16 = Client.field1034 + Client.field1028.height - var10.height;
                     }

                     var12 = var15;
                     var13 = var16;
                  }

                  if(!var10.field2802) {
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
                  int var27;
                  int var28;
                  int var29;
                  int var30;
                  int var31;
                  int var32;
                  int var33;
                  int var34;
                  int var36;
                  int var38;
                  int var39;
                  int var40;
                  int var42;
                  int var43;
                  int var44;
                  int var45;
                  int var47;
                  if(var10.contentType != 0) {
                     if(var10.contentType == 1336) {
                        if(Client.displayFps) {
                           var13 += 15;
                           KeyFocusListener.font_p12full.method4970("Fps:" + GameEngine.FPS, var12 + var10.width, var13, 16776960, -1);
                           var13 += 15;
                           Runtime var63 = Runtime.getRuntime();
                           var20 = (int)((var63.totalMemory() - var63.freeMemory()) / 1024L);
                           var21 = 16776960;
                           if(var20 > 32768 && Client.lowMemory) {
                              var21 = 16711680;
                           }

                           if(var20 > 65536 && !Client.lowMemory) {
                              var21 = 16711680;
                           }

                           KeyFocusListener.font_p12full.method4970("Mem:" + var20 + "k", var12 + var10.width, var13, var21, -1);
                           var13 += 15;
                        }
                        continue;
                     }

                     if(var10.contentType == 1337) {
                        Client.field1003 = var12;
                        Client.field1004 = var13;
                        var21 = var10.width;
                        var22 = var10.height;
                        ++Client.field958;
                        if(class181.localPlayer.x >> 7 == Client.destinationX && class181.localPlayer.y >> 7 == Client.destinationY) {
                           Client.destinationX = 0;
                        }

                        class43.method621();
                        if(Client.field1094 >= 0 && Client.cachedPlayers[Client.field1094] != null) {
                           class3.method7(Client.cachedPlayers[Client.field1094], false);
                        }

                        class47.method710(true);
                        class230.method4226();
                        class47.method710(false);
                        class184.method3543();
                        WorldComparator.method77();
                        class82.method1692(var12, var13, var21, var22, true);
                        var19 = Client.Viewport_xOffset;
                        var20 = Client.Viewport_yOffset;
                        var21 = Client.viewportHeight;
                        var22 = Client.viewportWidth;
                        Rasterizer2D.setDrawRegion(var19, var20, var19 + var21, var20 + var22);
                        Graphics3D.Rasterizer3D_method1();
                        if(!Client.field1100) {
                           var23 = Client.field997;
                           if(Client.field946 / 256 > var23) {
                              var23 = Client.field946 / 256;
                           }

                           if(Client.field1101[4] && Client.field935[4] + 128 > var23) {
                              var23 = Client.field935[4] + 128;
                           }

                           var24 = Client.mapAngle & 2047;
                           class56.method835(class224.field2863, class41.getTileHeight(class181.localPlayer.x, class181.localPlayer.y, class233.plane) - Client.field943, TotalQuantityComparator.field283, var23, var24, var23 * 3 + 600);
                        }

                        if(!Client.field1100) {
                           if(RSCanvas.preferences.hideRoofs) {
                              var24 = class233.plane;
                           } else {
                              label1694: {
                                 var25 = 3;
                                 if(class18.cameraPitch < 310) {
                                    var26 = class214.cameraX >> 7;
                                    var27 = class289.cameraY >> 7;
                                    var28 = class181.localPlayer.x >> 7;
                                    var29 = class181.localPlayer.y >> 7;
                                    if(var26 < 0 || var27 < 0 || var26 >= 104 || var27 >= 104) {
                                       var24 = class233.plane;
                                       break label1694;
                                    }

                                    if((class61.tileSettings[class233.plane][var26][var27] & 4) != 0) {
                                       var25 = class233.plane;
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

                                          if((class61.tileSettings[class233.plane][var26][var27] & 4) != 0) {
                                             var25 = class233.plane;
                                          }

                                          var33 += var32;
                                          if(var33 >= 65536) {
                                             var33 -= 65536;
                                             if(var27 < var29) {
                                                ++var27;
                                             } else if(var27 > var29) {
                                                --var27;
                                             }

                                             if((class61.tileSettings[class233.plane][var26][var27] & 4) != 0) {
                                                var25 = class233.plane;
                                             }
                                          }
                                       }
                                    } else {
                                       var32 = var30 * 65536 / var31;
                                       var33 = 32768;

                                       while(var27 != var29) {
                                          if(var27 < var29) {
                                             ++var27;
                                          } else if(var27 > var29) {
                                             --var27;
                                          }

                                          if((class61.tileSettings[class233.plane][var26][var27] & 4) != 0) {
                                             var25 = class233.plane;
                                          }

                                          var33 += var32;
                                          if(var33 >= 65536) {
                                             var33 -= 65536;
                                             if(var26 < var28) {
                                                ++var26;
                                             } else if(var26 > var28) {
                                                --var26;
                                             }

                                             if((class61.tileSettings[class233.plane][var26][var27] & 4) != 0) {
                                                var25 = class233.plane;
                                             }
                                          }
                                       }
                                    }
                                 }

                                 if(class181.localPlayer.x >= 0 && class181.localPlayer.y >= 0 && class181.localPlayer.x < 13312 && class181.localPlayer.y < 13312) {
                                    if((class61.tileSettings[class233.plane][class181.localPlayer.x >> 7][class181.localPlayer.y >> 7] & 4) != 0) {
                                       var25 = class233.plane;
                                    }

                                    var24 = var25;
                                 } else {
                                    var24 = class233.plane;
                                 }
                              }
                           }

                           var23 = var24;
                        } else {
                           if(RSCanvas.preferences.hideRoofs) {
                              var24 = class233.plane;
                           } else {
                              var25 = class41.getTileHeight(class214.cameraX, class289.cameraY, class233.plane);
                              if(var25 - GameEngine.cameraZ < 800 && (class61.tileSettings[class233.plane][class214.cameraX >> 7][class289.cameraY >> 7] & 4) != 0) {
                                 var24 = class233.plane;
                              } else {
                                 var24 = 3;
                              }
                           }

                           var23 = var24;
                        }

                        var24 = class214.cameraX;
                        var25 = GameEngine.cameraZ;
                        var26 = class289.cameraY;
                        var27 = class18.cameraPitch;
                        var28 = SoundTaskDataProvider.cameraYaw;

                        for(var29 = 0; var29 < 5; ++var29) {
                           if(Client.field1101[var29]) {
                              var30 = (int)(Math.random() * (double)(Client.field1102[var29] * 2 + 1) - (double)Client.field1102[var29] + Math.sin((double)Client.field1091[var29] * ((double)Client.field872[var29] / 100.0D)) * (double)Client.field935[var29]);
                              if(var29 == 0) {
                                 class214.cameraX += var30;
                              }

                              if(var29 == 1) {
                                 GameEngine.cameraZ += var30;
                              }

                              if(var29 == 2) {
                                 class289.cameraY += var30;
                              }

                              if(var29 == 3) {
                                 SoundTaskDataProvider.cameraYaw = var30 + SoundTaskDataProvider.cameraYaw & 2047;
                              }

                              if(var29 == 4) {
                                 class18.cameraPitch += var30;
                                 if(class18.cameraPitch < 128) {
                                    class18.cameraPitch = 128;
                                 }

                                 if(class18.cameraPitch > 383) {
                                    class18.cameraPitch = 383;
                                 }
                              }
                           }
                        }

                        var29 = MouseInput.field703;
                        var30 = MouseInput.field715 * 10625923;
                        if(MouseInput.mouseLastButton != 0) {
                           var29 = MouseInput.mouseLastPressedX;
                           var30 = MouseInput.mouseLastPressedY;
                        }

                        if(var29 >= var19 && var29 < var21 + var19 && var30 >= var20 && var30 < var22 + var20) {
                           class181.method3521(var29 - var19, var30 - var20);
                        } else {
                           TextureProvider.method2506();
                        }

                        class25.method190();
                        Rasterizer2D.Rasterizer2D_fillRectangle(var19, var20, var21, var22, 0);
                        class25.method190();
                        var31 = Graphics3D.Rasterizer3D_zoom;
                        Graphics3D.Rasterizer3D_zoom = Client.scale;
                        GrandExchangeEvent.region.draw(class214.cameraX, GameEngine.cameraZ, class289.cameraY, class18.cameraPitch, SoundTaskDataProvider.cameraYaw, var23);
                        class39.method554();
                        Graphics3D.Rasterizer3D_zoom = var31;
                        class25.method190();
                        GrandExchangeEvent.region.clearEntities();
                        Client.field947 = 0;
                        boolean var59 = false;
                        var33 = -1;
                        var34 = class94.playerIndexesCount;
                        int[] var35 = class94.playerIndices;

                        for(var36 = 0; var36 < var34 + Client.npcIndexesCount; ++var36) {
                           Object var37;
                           if(var36 < var34) {
                              var37 = Client.cachedPlayers[var35[var36]];
                              if(var35[var36] == Client.field1094) {
                                 var59 = true;
                                 var33 = var36;
                                 continue;
                              }
                           } else {
                              var37 = Client.cachedNPCs[Client.npcIndices[var36 - var34]];
                           }

                           KeyFocusListener.method775((Actor)var37, var36, var19, var20, var21, var22);
                        }

                        if(var59) {
                           KeyFocusListener.method775(Client.cachedPlayers[Client.field1094], var33, var19, var20, var21, var22);
                        }

                        for(var36 = 0; var36 < Client.field947; ++var36) {
                           var47 = Client.field949[var36];
                           var38 = Client.field950[var36];
                           var39 = Client.field952[var36];
                           var40 = Client.field951[var36];
                           boolean var60 = true;

                           while(var60) {
                              var60 = false;

                              for(var42 = 0; var42 < var36; ++var42) {
                                 if(var38 + 2 > Client.field950[var42] - Client.field951[var42] && var38 - var40 < Client.field950[var42] + 2 && var47 - var39 < Client.field952[var42] + Client.field949[var42] && var47 + var39 > Client.field949[var42] - Client.field952[var42] && Client.field950[var42] - Client.field951[var42] < var38) {
                                    var38 = Client.field950[var42] - Client.field951[var42];
                                    var60 = true;
                                 }
                              }
                           }

                           Client.screenY = Client.field949[var36];
                           Client.screenX = Client.field950[var36] = var38;
                           String var48 = Client.field876[var36];
                           if(Client.field1016 == 0) {
                              var43 = 16776960;
                              if(Client.field910[var36] < 6) {
                                 var43 = Client.field1008[Client.field910[var36]];
                              }

                              if(Client.field910[var36] == 6) {
                                 var43 = Client.field958 % 20 < 10?16711680:16776960;
                              }

                              if(Client.field910[var36] == 7) {
                                 var43 = Client.field958 % 20 < 10?255:'\uffff';
                              }

                              if(Client.field910[var36] == 8) {
                                 var43 = Client.field958 % 20 < 10?'뀀':8454016;
                              }

                              if(Client.field910[var36] == 9) {
                                 var44 = 150 - Client.field913[var36];
                                 if(var44 < 50) {
                                    var43 = var44 * 1280 + 16711680;
                                 } else if(var44 < 100) {
                                    var43 = 16776960 - (var44 - 50) * 327680;
                                 } else if(var44 < 150) {
                                    var43 = (var44 - 100) * 5 + 65280;
                                 }
                              }

                              if(Client.field910[var36] == 10) {
                                 var44 = 150 - Client.field913[var36];
                                 if(var44 < 50) {
                                    var43 = var44 * 5 + 16711680;
                                 } else if(var44 < 100) {
                                    var43 = 16711935 - (var44 - 50) * 327680;
                                 } else if(var44 < 150) {
                                    var43 = (var44 - 100) * 327680 + 255 - (var44 - 100) * 5;
                                 }
                              }

                              if(Client.field910[var36] == 11) {
                                 var44 = 150 - Client.field913[var36];
                                 if(var44 < 50) {
                                    var43 = 16777215 - var44 * 327685;
                                 } else if(var44 < 100) {
                                    var43 = (var44 - 50) * 327685 + 65280;
                                 } else if(var44 < 150) {
                                    var43 = 16777215 - (var44 - 100) * 327680;
                                 }
                              }

                              if(Client.field954[var36] == 0) {
                                 World.fontBold12.method4962(var48, var19 + Client.screenY, var20 + Client.screenX, var43, 0);
                              }

                              if(Client.field954[var36] == 1) {
                                 World.fontBold12.method4936(var48, var19 + Client.screenY, var20 + Client.screenX, var43, 0, Client.field958);
                              }

                              if(Client.field954[var36] == 2) {
                                 World.fontBold12.method4937(var48, var19 + Client.screenY, var20 + Client.screenX, var43, 0, Client.field958);
                              }

                              if(Client.field954[var36] == 3) {
                                 World.fontBold12.method4938(var48, var19 + Client.screenY, var20 + Client.screenX, var43, 0, Client.field958, 150 - Client.field913[var36]);
                              }

                              if(Client.field954[var36] == 4) {
                                 var44 = (150 - Client.field913[var36]) * (World.fontBold12.method4925(var48) + 100) / 150;
                                 Rasterizer2D.setInnerDrawRegion(var19 + Client.screenY - 50, var20, var19 + Client.screenY + 50, var22 + var20);
                                 World.fontBold12.method4931(var48, var19 + Client.screenY + 50 - var44, var20 + Client.screenX, var43, 0);
                                 Rasterizer2D.setDrawRegion(var19, var20, var19 + var21, var20 + var22);
                              }

                              if(Client.field954[var36] == 5) {
                                 var44 = 150 - Client.field913[var36];
                                 var45 = 0;
                                 if(var44 < 25) {
                                    var45 = var44 - 25;
                                 } else if(var44 > 125) {
                                    var45 = var44 - 125;
                                 }

                                 Rasterizer2D.setInnerDrawRegion(var19, var20 + Client.screenX - World.fontBold12.verticalSpace - 1, var19 + var21, var20 + Client.screenX + 5);
                                 World.fontBold12.method4962(var48, var19 + Client.screenY, var20 + var45 + Client.screenX, var43, 0);
                                 Rasterizer2D.setDrawRegion(var19, var20, var19 + var21, var20 + var22);
                              }
                           } else {
                              World.fontBold12.method4962(var48, var19 + Client.screenY, var20 + Client.screenX, 16776960, 0);
                           }
                        }

                        BoundingBox3D.method56(var19, var20);
                        ((TextureProvider)Graphics3D.textureLoader).method2486(Client.field992);
                        GrandExchangeOffer.method117(var19, var20, var21, var22);
                        class214.cameraX = var24;
                        GameEngine.cameraZ = var25;
                        class289.cameraY = var26;
                        class18.cameraPitch = var27;
                        SoundTaskDataProvider.cameraYaw = var28;
                        if(Client.field879 && AbstractSoundSystem.method2156(true, false) == 0) {
                           Client.field879 = false;
                        }

                        if(Client.field879) {
                           Rasterizer2D.Rasterizer2D_fillRectangle(var19, var20, var21, var22, 0);
                           UrlRequester.drawStatusBox("Loading - please wait.", false);
                        }

                        Client.field1059[var10.boundsIndex] = true;
                        Rasterizer2D.setDrawRegion(var2, var3, var4, var5);
                        continue;
                     }

                     if(var10.contentType == 1338) {
                        ItemContainer.method1099(var10, var12, var13, var11);
                        Rasterizer2D.setDrawRegion(var2, var3, var4, var5);
                        continue;
                     }

                     if(var10.contentType == 1339) {
                        AbstractByteBuffer.method3541(var10, var12, var13, var11);
                        Rasterizer2D.setDrawRegion(var2, var3, var4, var5);
                        continue;
                     }

                     if(var10.contentType == 1400) {
                        MouseInput.renderOverview.extractWorldmap(var12, var13, var10.width, var10.height, Client.gameCycle);
                     }

                     if(var10.contentType == 1401) {
                        MouseInput.renderOverview.extractData(var12, var13, var10.width, var10.height);
                     }
                  }

                  if(var10.type == 0) {
                     if(!var10.hasScript && Buffer.method3509(var10) && var10 != FloorUnderlayDefinition.field3409) {
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
                        MilliTimer.method3057(var46.id, var15, var16, var17, var18, var12, var13, var11);
                     }

                     Rasterizer2D.setDrawRegion(var2, var3, var4, var5);
                     Graphics3D.Rasterizer3D_method1();
                  }

                  if(Client.isResized || Client.field1132[var11] || Client.gameDrawingMode > 1) {
                     if(var10.type == 0 && !var10.hasScript && var10.scrollHeight > var10.height) {
                        var19 = var12 + var10.width;
                        var20 = var10.scrollY;
                        var21 = var10.height;
                        var22 = var10.scrollHeight;
                        AttackOption.scrollbarSprites[0].method5245(var19, var13);
                        AttackOption.scrollbarSprites[1].method5245(var19, var13 + var21 - 16);
                        Rasterizer2D.Rasterizer2D_fillRectangle(var19, var13 + 16, 16, var21 - 32, Client.field1038);
                        var23 = var21 * (var21 - 32) / var22;
                        if(var23 < 8) {
                           var23 = 8;
                        }

                        var24 = var20 * (var21 - 32 - var23) / (var22 - var21);
                        Rasterizer2D.Rasterizer2D_fillRectangle(var19, var13 + var24 + 16, 16, var23, Client.field982);
                        Rasterizer2D.method5146(var19, var24 + var13 + 16, var23, Client.field934);
                        Rasterizer2D.method5146(var19 + 1, var13 + var24 + 16, var23, Client.field934);
                        Rasterizer2D.method5148(var19, var24 + var13 + 16, 16, Client.field934);
                        Rasterizer2D.method5148(var19, var13 + var24 + 17, 16, Client.field934);
                        Rasterizer2D.method5146(var19 + 15, var24 + var13 + 16, var23, Client.field933);
                        Rasterizer2D.method5146(var19 + 14, var24 + var13 + 17, var23 - 1, Client.field933);
                        Rasterizer2D.method5148(var19, var24 + var13 + var23 + 15, 16, Client.field933);
                        Rasterizer2D.method5148(var19 + 1, var13 + var24 + var23 + 14, 15, Client.field933);
                     }

                     if(var10.type != 1) {
                        if(var10.type == 2) {
                           var19 = 0;

                           for(var20 = 0; var20 < var10.field2736; ++var20) {
                              for(var21 = 0; var21 < var10.originalWidth; ++var21) {
                                 var22 = var21 * (var10.paddingX + 32) + var12;
                                 var23 = var13 + var20 * (var10.paddingY + 32);
                                 if(var19 < 20) {
                                    var22 += var10.xSprites[var19];
                                    var23 += var10.field2838[var19];
                                 }

                                 if(var10.itemIds[var19] <= 0) {
                                    if(var10.field2794 != null && var19 < 20) {
                                       SpritePixels var64 = var10.method4165(var19);
                                       if(var64 != null) {
                                          var64.drawAt(var22, var23);
                                       } else if(Widget.field2721) {
                                          class40.method556(var10);
                                       }
                                    }
                                 } else {
                                    boolean var57 = false;
                                    boolean var58 = false;
                                    var26 = var10.itemIds[var19] - 1;
                                    if(var22 + 32 > var2 && var22 < var4 && var23 + 32 > var3 && var23 < var5 || var10 == WorldMapType2.field492 && var19 == Client.field1076) {
                                       SpritePixels var50;
                                       if(Client.itemSelectionState == 1 && var19 == class34.selectedItemIndex && var10.id == class214.field2675) {
                                          var50 = TotalQuantityComparator.createSprite(var26, var10.itemQuantities[var19], 2, 0, 2, false);
                                       } else {
                                          var50 = TotalQuantityComparator.createSprite(var26, var10.itemQuantities[var19], 1, 3153952, 2, false);
                                       }

                                       if(var50 != null) {
                                          if(var10 == WorldMapType2.field492 && var19 == Client.field1076) {
                                             var24 = MouseInput.field703 - Client.field968;
                                             var25 = MouseInput.field715 * 10625923 - Client.field969;
                                             if(var24 < 5 && var24 > -5) {
                                                var24 = 0;
                                             }

                                             if(var25 < 5 && var25 > -5) {
                                                var25 = 0;
                                             }

                                             if(Client.field1012 < 5) {
                                                var24 = 0;
                                                var25 = 0;
                                             }

                                             var50.method5274(var24 + var22, var25 + var23, 128);
                                             if(var1 != -1) {
                                                Widget var51 = var0[var1 & 65535];
                                                if(var23 + var25 < Rasterizer2D.drawingAreaTop && var51.scrollY > 0) {
                                                   var29 = (Rasterizer2D.drawingAreaTop - var23 - var25) * Client.field992 / 3;
                                                   if(var29 > Client.field992 * 10) {
                                                      var29 = Client.field992 * 10;
                                                   }

                                                   if(var29 > var51.scrollY) {
                                                      var29 = var51.scrollY;
                                                   }

                                                   var51.scrollY -= var29;
                                                   Client.field969 += var29;
                                                   class40.method556(var51);
                                                }

                                                if(var23 + var25 + 32 > Rasterizer2D.drawingAreaRight && var51.scrollY < var51.scrollHeight - var51.height) {
                                                   var29 = (var23 + var25 + 32 - Rasterizer2D.drawingAreaRight) * Client.field992 / 3;
                                                   if(var29 > Client.field992 * 10) {
                                                      var29 = Client.field992 * 10;
                                                   }

                                                   if(var29 > var51.scrollHeight - var51.height - var51.scrollY) {
                                                      var29 = var51.scrollHeight - var51.height - var51.scrollY;
                                                   }

                                                   var51.scrollY += var29;
                                                   Client.field969 -= var29;
                                                   class40.method556(var51);
                                                }
                                             }
                                          } else if(var10 == SoundTaskDataProvider.field622 && var19 == Client.field966) {
                                             var50.method5274(var22, var23, 128);
                                          } else {
                                             var50.drawAt(var22, var23);
                                          }
                                       } else {
                                          class40.method556(var10);
                                       }
                                    }
                                 }

                                 ++var19;
                              }
                           }
                        } else if(var10.type == 3) {
                           if(Varcs.method1877(var10)) {
                              var19 = var10.field2750;
                              if(var10 == FloorUnderlayDefinition.field3409 && var10.field2752 != 0) {
                                 var19 = var10.field2752;
                              }
                           } else {
                              var19 = var10.textColor;
                              if(var10 == FloorUnderlayDefinition.field3409 && var10.field2751 != 0) {
                                 var19 = var10.field2751;
                              }
                           }

                           if(var10.filled) {
                              switch(var10.field2754.field3824) {
                              case 1:
                                 Rasterizer2D.method5171(var12, var13, var10.width, var10.height, var10.textColor, var10.field2750, 256 - (var10.opacity & 255), 256 - (var10.field2729 & 255));
                                 break;
                              case 2:
                                 Rasterizer2D.method5160(var12, var13, var10.width, var10.height, var10.textColor, var10.field2750, 256 - (var10.opacity & 255), 256 - (var10.field2729 & 255));
                                 break;
                              case 3:
                                 Rasterizer2D.method5147(var12, var13, var10.width, var10.height, var10.textColor, var10.field2750, 256 - (var10.opacity & 255), 256 - (var10.field2729 & 255));
                                 break;
                              case 4:
                                 Rasterizer2D.method5191(var12, var13, var10.width, var10.height, var10.textColor, var10.field2750, 256 - (var10.opacity & 255), 256 - (var10.field2729 & 255));
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
                           Font var61;
                           if(var10.type == 4) {
                              var61 = var10.getFont();
                              if(var61 == null) {
                                 if(Widget.field2721) {
                                    class40.method556(var10);
                                 }
                              } else {
                                 String var67 = var10.text;
                                 if(Varcs.method1877(var10)) {
                                    var20 = var10.field2750;
                                    if(var10 == FloorUnderlayDefinition.field3409 && var10.field2752 != 0) {
                                       var20 = var10.field2752;
                                    }

                                    if(var10.string1.length() > 0) {
                                       var67 = var10.string1;
                                    }
                                 } else {
                                    var20 = var10.textColor;
                                    if(var10 == FloorUnderlayDefinition.field3409 && var10.field2751 != 0) {
                                       var20 = var10.field2751;
                                    }
                                 }

                                 if(var10.hasScript && var10.itemId != -1) {
                                    ItemComposition var68 = WorldMapType2.getItemDefinition(var10.itemId);
                                    var67 = var68.name;
                                    if(var67 == null) {
                                       var67 = "null";
                                    }

                                    if((var68.isStackable == 1 || var10.itemQuantity != 1) && var10.itemQuantity != -1) {
                                       var67 = ISAACCipher.getColTags(16748608) + var67 + "</col>" + " " + 'x' + class19.method159(var10.itemQuantity);
                                    }
                                 }

                                 if(var10 == Client.field1018) {
                                    Object var10000 = null;
                                    var67 = "Please wait...";
                                    var20 = var10.textColor;
                                 }

                                 if(!var10.hasScript) {
                                    var67 = ScriptState.method1091(var67, var10);
                                 }

                                 var61.method4935(var67, var12, var13, var10.width, var10.height, var20, var10.textShadowed?0:-1, var10.field2787, var10.field2809, var10.field2824);
                              }
                           } else if(var10.type == 5) {
                              SpritePixels var62;
                              if(!var10.hasScript) {
                                 var62 = var10.method4173(Varcs.method1877(var10));
                                 if(var62 != null) {
                                    var62.drawAt(var12, var13);
                                 } else if(Widget.field2721) {
                                    class40.method556(var10);
                                 }
                              } else {
                                 if(var10.itemId != -1) {
                                    var62 = TotalQuantityComparator.createSprite(var10.itemId, var10.itemQuantity, var10.borderThickness, var10.sprite2, var10.field2782, false);
                                 } else {
                                    var62 = var10.method4173(false);
                                 }

                                 if(var62 == null) {
                                    if(Widget.field2721) {
                                       class40.method556(var10);
                                    }
                                 } else {
                                    var20 = var62.maxWidth;
                                    var21 = var62.maxHeight;
                                    if(!var10.spriteTiling) {
                                       var22 = var10.width * 4096 / var20;
                                       if(var10.textureId != 0) {
                                          var62.method5259(var10.width / 2 + var12, var10.height / 2 + var13, var10.textureId, var22);
                                       } else if(var14 != 0) {
                                          var62.method5291(var12, var13, var10.width, var10.height, 256 - (var14 & 255));
                                       } else if(var20 == var10.width && var21 == var10.height) {
                                          var62.drawAt(var12, var13);
                                       } else {
                                          var62.method5270(var12, var13, var10.width, var10.height);
                                       }
                                    } else {
                                       Rasterizer2D.setInnerDrawRegion(var12, var13, var12 + var10.width, var13 + var10.height);
                                       var22 = (var20 - 1 + var10.width) / var20;
                                       var23 = (var21 - 1 + var10.height) / var21;

                                       for(var24 = 0; var24 < var22; ++var24) {
                                          for(var25 = 0; var25 < var23; ++var25) {
                                             if(var10.textureId != 0) {
                                                var62.method5259(var20 / 2 + var12 + var24 * var20, var21 / 2 + var13 + var21 * var25, var10.textureId, 4096);
                                             } else if(var14 != 0) {
                                                var62.method5274(var12 + var24 * var20, var13 + var25 * var21, 256 - (var14 & 255));
                                             } else {
                                                var62.drawAt(var12 + var20 * var24, var13 + var25 * var21);
                                             }
                                          }
                                       }

                                       Rasterizer2D.setDrawRegion(var2, var3, var4, var5);
                                    }
                                 }
                              }
                           } else {
                              ItemComposition var54;
                              if(var10.type == 6) {
                                 boolean var56 = Varcs.method1877(var10);
                                 if(var56) {
                                    var20 = var10.field2772;
                                 } else {
                                    var20 = var10.field2844;
                                 }

                                 Model var65 = null;
                                 var22 = 0;
                                 if(var10.itemId != -1) {
                                    var54 = WorldMapType2.getItemDefinition(var10.itemId);
                                    if(var54 != null) {
                                       var54 = var54.method4756(var10.itemQuantity);
                                       var65 = var54.getModel(1);
                                       if(var65 != null) {
                                          var65.calculateBoundsCylinder();
                                          var22 = var65.modelHeight / 2;
                                       } else {
                                          class40.method556(var10);
                                       }
                                    }
                                 } else if(var10.modelType == 5) {
                                    if(var10.modelId == 0) {
                                       var65 = Client.field1125.getModel((Sequence)null, -1, (Sequence)null, -1);
                                    } else {
                                       var65 = class181.localPlayer.getModel();
                                    }
                                 } else if(var20 == -1) {
                                    var65 = var10.getModel((Sequence)null, -1, var56, class181.localPlayer.composition);
                                    if(var65 == null && Widget.field2721) {
                                       class40.method556(var10);
                                    }
                                 } else {
                                    Sequence var69 = GrandExchangeEvents.getAnimation(var20);
                                    var65 = var10.getModel(var69, var10.field2846, var56, class181.localPlayer.composition);
                                    if(var65 == null && Widget.field2721) {
                                       class40.method556(var10);
                                    }
                                 }

                                 Graphics3D.method2724(var10.width / 2 + var12, var10.height / 2 + var13);
                                 var23 = Graphics3D.SINE[var10.rotationX] * var10.modelZoom >> 16;
                                 var24 = Graphics3D.COSINE[var10.rotationX] * var10.modelZoom >> 16;
                                 if(var65 != null) {
                                    if(!var10.hasScript) {
                                       var65.method2652(0, var10.rotationZ, 0, var10.rotationX, 0, var23, var24);
                                    } else {
                                       var65.calculateBoundsCylinder();
                                       if(var10.field2843) {
                                          var65.method2629(0, var10.rotationZ, var10.rotationY, var10.rotationX, var10.field2773, var23 + var22 + var10.field2774, var24 + var10.field2774, var10.modelZoom);
                                       } else {
                                          var65.method2652(0, var10.rotationZ, var10.rotationY, var10.rotationX, var10.field2773, var22 + var23 + var10.field2774, var24 + var10.field2774);
                                       }
                                    }
                                 }

                                 Graphics3D.Rasterizer3D_method3();
                              } else {
                                 if(var10.type == 7) {
                                    var61 = var10.getFont();
                                    if(var61 == null) {
                                       if(Widget.field2721) {
                                          class40.method556(var10);
                                       }
                                       continue;
                                    }

                                    var20 = 0;

                                    for(var21 = 0; var21 < var10.field2736; ++var21) {
                                       for(var22 = 0; var22 < var10.originalWidth; ++var22) {
                                          if(var10.itemIds[var20] > 0) {
                                             var54 = WorldMapType2.getItemDefinition(var10.itemIds[var20] - 1);
                                             String var49;
                                             if(var54.isStackable != 1 && var10.itemQuantities[var20] == 1) {
                                                var49 = ISAACCipher.getColTags(16748608) + var54.name + "</col>";
                                             } else {
                                                var49 = ISAACCipher.getColTags(16748608) + var54.name + "</col>" + " " + 'x' + class19.method159(var10.itemQuantities[var20]);
                                             }

                                             var25 = var12 + var22 * (var10.paddingX + 115);
                                             var26 = var21 * (var10.paddingY + 12) + var13;
                                             if(var10.field2787 == 0) {
                                                var61.method4931(var49, var25, var26, var10.textColor, var10.textShadowed?0:-1);
                                             } else if(var10.field2787 == 1) {
                                                var61.method4962(var49, var10.width / 2 + var25, var26, var10.textColor, var10.textShadowed?0:-1);
                                             } else {
                                                var61.method4970(var49, var25 + var10.width - 1, var26, var10.textColor, var10.textShadowed?0:-1);
                                             }
                                          }

                                          ++var20;
                                       }
                                    }
                                 }

                                 if(var10.type == 8 && var10 == GrandExchangeEvent.field279 && Client.field1006 == Client.field882) {
                                    var19 = 0;
                                    var20 = 0;
                                    Font var52 = KeyFocusListener.font_p12full;
                                    String var53 = var10.text;

                                    String var66;
                                    for(var53 = ScriptState.method1091(var53, var10); var53.length() > 0; var20 = var20 + var52.verticalSpace + 1) {
                                       var24 = var53.indexOf("<br>");
                                       if(var24 != -1) {
                                          var66 = var53.substring(0, var24);
                                          var53 = var53.substring(var24 + 4);
                                       } else {
                                          var66 = var53;
                                          var53 = "";
                                       }

                                       var25 = var52.method4925(var66);
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

                                    if(var20 + var25 > var5) {
                                       var25 = var5 - var20;
                                    }

                                    Rasterizer2D.Rasterizer2D_fillRectangle(var24, var25, var19, var20, 16777120);
                                    Rasterizer2D.drawRectangle(var24, var25, var19, var20, 0);
                                    var53 = var10.text;
                                    var26 = var25 + var52.verticalSpace + 2;

                                    for(var53 = ScriptState.method1091(var53, var10); var53.length() > 0; var26 = var26 + var52.verticalSpace + 1) {
                                       var27 = var53.indexOf("<br>");
                                       if(var27 != -1) {
                                          var66 = var53.substring(0, var27);
                                          var53 = var53.substring(var27 + 4);
                                       } else {
                                          var66 = var53;
                                          var53 = "";
                                       }

                                       var52.method4931(var66, var24 + 3, var26, 0, -1);
                                    }
                                 }

                                 if(var10.type == 9) {
                                    if(var10.field2756) {
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

                                          var34 = var26 * var33 >> 17;
                                          int var55 = var33 * var26 + 1 >> 17;
                                          var36 = var32 * var26 >> 17;
                                          var47 = var32 * var26 + 1 >> 17;
                                          var23 = var19 - Rasterizer2D.draw_region_x;
                                          var24 = var20 - Rasterizer2D.drawingAreaTop;
                                          var38 = var23 + var34;
                                          var39 = var23 - var55;
                                          var40 = var23 + var27 - var55;
                                          int var41 = var23 + var27 + var34;
                                          var42 = var24 + var36;
                                          var43 = var24 - var47;
                                          var44 = var28 + var24 - var47;
                                          var45 = var28 + var24 + var36;
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
