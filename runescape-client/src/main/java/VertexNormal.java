import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ed")
@Implements("VertexNormal")
public class VertexNormal {
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -2019530039
   )
   public static int field1888;
   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "Lgn;"
   )
   @Export("NetCache_responseArchiveBuffer")
   public static Buffer NetCache_responseArchiveBuffer;
   @ObfuscatedName("ex")
   @ObfuscatedGetter(
      longValue = 4560359104242307535L
   )
   static long field1889;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -921267083
   )
   @Export("x")
   int x;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 767058705
   )
   @Export("y")
   int y;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 1797688725
   )
   @Export("z")
   int z;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -287760493
   )
   @Export("magnitude")
   int magnitude;

   VertexNormal() {
   }

   @ObfuscatedSignature(
      signature = "(Led;)V"
   )
   VertexNormal(VertexNormal var1) {
      this.x = var1.x;
      this.y = var1.y;
      this.z = var1.z;
      this.magnitude = var1.magnitude;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(IB)Ljh;",
      garbageValue = "64"
   )
   public static Enum method2804(int var0) {
      Enum var1 = (Enum)Enum.EnumDefinition_cached.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = Enum.EnumDefinition_indexCache.getConfigData(8, var0);
         var1 = new Enum();
         if(var2 != null) {
            var1.decode(new Buffer(var2));
         }

         Enum.EnumDefinition_cached.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1360565069"
   )
   static void method2802() {
      FileOnDisk var0 = null;

      try {
         var0 = WorldComparator.getPreferencesFile("", class35.field456.name, true);
         Buffer var1 = Client.preferences.serialize();
         var0.write(var1.payload, 0, var1.offset);
      } catch (Exception var3) {
         ;
      }

      try {
         if(var0 != null) {
            var0.closeSync(true);
         }
      } catch (Exception var2) {
         ;
      }

   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-582575530"
   )
   static final void method2801() {
      Object var10000 = null;
      String var0 = "Your ignore list is full. Max of 100 for free users, and 400 for members";
      class149.sendGameMessage(30, "", var0);
   }

   @ObfuscatedName("fu")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-301842137"
   )
   static final void method2800() {
      Client.field863.close();
      class184.method3455();
      GameObject.region.reset();

      for(int var0 = 0; var0 < 4; ++var0) {
         Client.collisionMaps[var0].reset();
      }

      System.gc();
      class249.method4517(2);
      Client.field1015 = -1;
      Client.field1039 = false;

      for(class79 var1 = (class79)class79.field1210.getFront(); var1 != null; var1 = (class79)class79.field1210.getNext()) {
         if(var1.field1201 != null) {
            KeyFocusListener.field583.method2069(var1.field1201);
            var1.field1201 = null;
         }

         if(var1.field1213 != null) {
            KeyFocusListener.field583.method2069(var1.field1213);
            var1.field1213 = null;
         }
      }

      class79.field1210.clear();
      WorldMapType1.setGameState(10);
   }

   @ObfuscatedName("id")
   @ObfuscatedSignature(
      signature = "([Lim;IIIIIIIII)V",
      garbageValue = "124708325"
   )
   @Export("gameDraw")
   static final void gameDraw(Widget[] var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
      Rasterizer2D.setDrawRegion(var2, var3, var4, var5);
      Graphics3D.Rasterizer3D_method1();

      label1487:
      for(int var9 = 0; var9 < var0.length; ++var9) {
         Widget var10 = var0[var9];
         if(var10 != null && (var10.parentId == var1 || var1 == -1412584499 && var10 == Client.field976)) {
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
            if(!var10.hasScript || !class197.method3823(var10)) {
               if(var10.contentType > 0) {
                  class225.method4260(var10);
               }

               int var12 = var10.relativeX + var6;
               int var13 = var7 + var10.relativeY;
               int var14 = var10.opacity;
               int var15;
               int var16;
               if(var10 == Client.field976) {
                  if(var1 != -1412584499 && !var10.field2855) {
                     Overlay.field3668 = var0;
                     ItemContainer.field721 = var6;
                     CombatInfo2.field3469 = var7;
                     continue;
                  }

                  if(Client.field987 && Client.field978) {
                     var15 = MouseInput.mouseLastX;
                     var16 = MouseInput.mouseLastY;
                     var15 -= Client.field1023;
                     var16 -= Client.field914;
                     if(var15 < Client.field982) {
                        var15 = Client.field982;
                     }

                     if(var15 + var10.width > Client.field982 + Client.field977.width) {
                        var15 = Client.field982 + Client.field977.width - var10.width;
                     }

                     if(var16 < Client.field1004) {
                        var16 = Client.field1004;
                     }

                     if(var16 + var10.height > Client.field1004 + Client.field977.height) {
                        var16 = Client.field1004 + Client.field977.height - var10.height;
                     }

                     var12 = var15;
                     var13 = var16;
                  }

                  if(!var10.field2855) {
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
                  int var37;
                  int var39;
                  int var40;
                  int var41;
                  int var43;
                  int var44;
                  int var45;
                  int var49;
                  int var58;
                  if(var10.contentType != 0) {
                     if(var10.contentType == 1336) {
                        if(Client.displayFps) {
                           var13 += 15;
                           ClanMemberManager.font_p12full.method5453("Fps:" + GameEngine.FPS, var12 + var10.width, var13, 16776960, -1);
                           var13 += 15;
                           Runtime var69 = Runtime.getRuntime();
                           var20 = (int)((var69.totalMemory() - var69.freeMemory()) / 1024L);
                           var21 = 16776960;
                           if(var20 > 32768 && Client.lowMemory) {
                              var21 = 16711680;
                           }

                           if(var20 > 65536 && !Client.lowMemory) {
                              var21 = 16711680;
                           }

                           ClanMemberManager.font_p12full.method5453("Mem:" + var20 + "k", var12 + var10.width, var13, var21, -1);
                           var13 += 15;
                        }
                        continue;
                     }

                     if(var10.contentType == 1337) {
                        Client.field952 = var12;
                        Client.field953 = var13;
                        var21 = var10.width;
                        var22 = var10.height;
                        ++Client.field868;
                        if(OwnWorldComparator.localPlayer.x >> 7 == Client.destinationX && OwnWorldComparator.localPlayer.y >> 7 == Client.destinationY) {
                           Client.destinationX = 0;
                        }

                        if(Client.field925) {
                           TotalQuantityComparator.method99(OwnWorldComparator.localPlayer, false);
                        }

                        if(Client.field972 >= 0 && Client.cachedPlayers[Client.field972] != null) {
                           TotalQuantityComparator.method99(Client.cachedPlayers[Client.field972], false);
                        }

                        class5.method13(true);
                        var23 = class92.playerIndexesCount;
                        int[] var62 = class92.playerIndices;

                        for(var25 = 0; var25 < var23; ++var25) {
                           if(var62[var25] != Client.field972 && var62[var25] != Client.localInteractingIndex) {
                              TotalQuantityComparator.method99(Client.cachedPlayers[var62[var25]], true);
                           }
                        }

                        class5.method13(false);
                        class39.method560();

                        for(GraphicsObject var71 = (GraphicsObject)Client.graphicsObjectDeque.getFront(); var71 != null; var71 = (GraphicsObject)Client.graphicsObjectDeque.getNext()) {
                           if(var71.level == class230.plane && !var71.finished) {
                              if(Client.gameCycle >= var71.startCycle) {
                                 var71.method1817(Client.field878);
                                 if(var71.finished) {
                                    var71.unlink();
                                 } else {
                                    GameObject.region.method2930(var71.level, var71.x, var71.y, var71.height, 60, var71, 0, -1, false);
                                 }
                              }
                           } else {
                              var71.unlink();
                           }
                        }

                        class19.method161(var12, var13, var21, var22, true);
                        var19 = Client.Viewport_xOffset;
                        var20 = Client.Viewport_yOffset;
                        var21 = Client.viewportWidth;
                        var22 = Client.viewportHeight;
                        Rasterizer2D.setDrawRegion(var19, var20, var21 + var19, var20 + var22);
                        Graphics3D.Rasterizer3D_method1();
                        if(!Client.field983) {
                           var23 = Client.cameraPitch;
                           if(Client.field894 / 256 > var23) {
                              var23 = Client.field894 / 256;
                           }

                           if(Client.field1050[4] && Client.field1052[4] + 128 > var23) {
                              var23 = Client.field1052[4] + 128;
                           }

                           var49 = Client.mapAngle & 2047;
                           var25 = AbstractByteBuffer.field2564;
                           var26 = WorldMapType1.getTileHeight(OwnWorldComparator.localPlayer.x, OwnWorldComparator.localPlayer.y, class230.plane) - Client.field891;
                           var27 = BaseVarType.field25;
                           var28 = var23 * 3 + 600;
                           var29 = 2048 - var23 & 2047;
                           var30 = 2048 - var49 & 2047;
                           var31 = 0;
                           var32 = 0;
                           var33 = var28;
                           if(var29 != 0) {
                              var34 = Graphics3D.SINE[var29];
                              var35 = Graphics3D.COSINE[var29];
                              var36 = var35 * var32 - var34 * var28 >> 16;
                              var33 = var32 * var34 + var35 * var28 >> 16;
                              var32 = var36;
                           }

                           if(var30 != 0) {
                              var34 = Graphics3D.SINE[var30];
                              var35 = Graphics3D.COSINE[var30];
                              var36 = var33 * var34 + var31 * var35 >> 16;
                              var33 = var33 * var35 - var31 * var34 >> 16;
                              var31 = var36;
                           }

                           class39.cameraX = var25 - var31;
                           class159.cameraZ = var26 - var32;
                           CombatInfo1.cameraY = var27 - var33;
                           DecorativeObject.cameraPitchCopy = var23;
                           class60.cameraYaw = var49;
                        }

                        if(!Client.field983) {
                           var23 = Script.method2007();
                        } else {
                           var23 = class176.method3421();
                        }

                        var49 = class39.cameraX;
                        var25 = class159.cameraZ;
                        var26 = CombatInfo1.cameraY;
                        var27 = DecorativeObject.cameraPitchCopy;
                        var28 = class60.cameraYaw;

                        for(var29 = 0; var29 < 5; ++var29) {
                           if(Client.field1050[var29]) {
                              var30 = (int)(Math.random() * (double)(Client.field1051[var29] * 2 + 1) - (double)Client.field1051[var29] + Math.sin((double)Client.field889[var29] / 100.0D * (double)Client.field1054[var29]) * (double)Client.field1052[var29]);
                              if(var29 == 0) {
                                 class39.cameraX += var30;
                              }

                              if(var29 == 1) {
                                 class159.cameraZ += var30;
                              }

                              if(var29 == 2) {
                                 CombatInfo1.cameraY += var30;
                              }

                              if(var29 == 3) {
                                 class60.cameraYaw = var30 + class60.cameraYaw & 2047;
                              }

                              if(var29 == 4) {
                                 DecorativeObject.cameraPitchCopy += var30;
                                 if(DecorativeObject.cameraPitchCopy < 128) {
                                    DecorativeObject.cameraPitchCopy = 128;
                                 }

                                 if(DecorativeObject.cameraPitchCopy > 383) {
                                    DecorativeObject.cameraPitchCopy = 383;
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
                           WidgetNode.method1124(var29 - var19, var30 - var20);
                        } else {
                           class131.Viewport_containsMouse = false;
                           class131.Viewport_entityCountAtMouse = 0;
                        }

                        class45.method681();
                        Rasterizer2D.Rasterizer2D_fillRectangle(var19, var20, var21, var22, 0);
                        class45.method681();
                        var31 = Graphics3D.Rasterizer3D_zoom;
                        Graphics3D.Rasterizer3D_zoom = Client.scale;
                        GameObject.region.draw(class39.cameraX, class159.cameraZ, CombatInfo1.cameraY, DecorativeObject.cameraPitchCopy, class60.cameraYaw, var23);

                        while(true) {
                           BoundingBox var50 = (BoundingBox)class7.boundingBoxes.removeLast();
                           if(var50 == null) {
                              Graphics3D.Rasterizer3D_zoom = var31;
                              class45.method681();
                              GameObject.region.clearEntities();
                              Client.overheadTextCount = 0;
                              boolean var64 = false;
                              var33 = -1;
                              var34 = -1;
                              var35 = class92.playerIndexesCount;
                              int[] var51 = class92.playerIndices;

                              for(var37 = 0; var37 < var35 + Client.npcIndexesCount; ++var37) {
                                 Object var38;
                                 if(var37 < var35) {
                                    var38 = Client.cachedPlayers[var51[var37]];
                                    if(var51[var37] == Client.field972) {
                                       var64 = true;
                                       var33 = var37;
                                       continue;
                                    }

                                    if(var38 == OwnWorldComparator.localPlayer) {
                                       var34 = var37;
                                       continue;
                                    }
                                 } else {
                                    var38 = Client.cachedNPCs[Client.npcIndices[var37 - var35]];
                                 }

                                 World.draw2DExtras((Actor)var38, var37, var19, var20, var21, var22);
                              }

                              if(Client.field925) {
                                 World.draw2DExtras(OwnWorldComparator.localPlayer, var34, var19, var20, var21, var22);
                              }

                              if(var64) {
                                 World.draw2DExtras(Client.cachedPlayers[Client.field972], var33, var19, var20, var21, var22);
                              }

                              for(var37 = 0; var37 < Client.overheadTextCount; ++var37) {
                                 var58 = Client.overheadTextsX[var37];
                                 var39 = Client.overheadTextsY[var37];
                                 var40 = Client.overheadTextsOffsetX[var37];
                                 var41 = Client.overheadTextsOffsetY[var37];
                                 boolean var65 = true;

                                 while(var65) {
                                    var65 = false;

                                    for(var43 = 0; var43 < var37; ++var43) {
                                       if(var39 + 2 > Client.overheadTextsY[var43] - Client.overheadTextsOffsetY[var43] && var39 - var41 < Client.overheadTextsY[var43] + 2 && var58 - var40 < Client.overheadTextsOffsetX[var43] + Client.overheadTextsX[var43] && var58 + var40 > Client.overheadTextsX[var43] - Client.overheadTextsOffsetX[var43] && Client.overheadTextsY[var43] - Client.overheadTextsOffsetY[var43] < var39) {
                                          var39 = Client.overheadTextsY[var43] - Client.overheadTextsOffsetY[var43];
                                          var65 = true;
                                       }
                                    }
                                 }

                                 Client.screenX = Client.overheadTextsX[var37];
                                 Client.screenY = Client.overheadTextsY[var37] = var39;
                                 String var59 = Client.overheadTexts[var37];
                                 if(Client.field965 == 0) {
                                    var44 = 16776960;
                                    if(Client.field901[var37] < 6) {
                                       var44 = Client.field1019[Client.field901[var37]];
                                    }

                                    if(Client.field901[var37] == 6) {
                                       var44 = Client.field868 % 20 < 10?16711680:16776960;
                                    }

                                    if(Client.field901[var37] == 7) {
                                       var44 = Client.field868 % 20 < 10?255:'\uffff';
                                    }

                                    if(Client.field901[var37] == 8) {
                                       var44 = Client.field868 % 20 < 10?'뀀':8454016;
                                    }

                                    if(Client.field901[var37] == 9) {
                                       var45 = 150 - Client.overheadTextsCyclesRemaining[var37];
                                       if(var45 < 50) {
                                          var44 = var45 * 1280 + 16711680;
                                       } else if(var45 < 100) {
                                          var44 = 16776960 - (var45 - 50) * 327680;
                                       } else if(var45 < 150) {
                                          var44 = (var45 - 100) * 5 + 65280;
                                       }
                                    }

                                    if(Client.field901[var37] == 10) {
                                       var45 = 150 - Client.overheadTextsCyclesRemaining[var37];
                                       if(var45 < 50) {
                                          var44 = var45 * 5 + 16711680;
                                       } else if(var45 < 100) {
                                          var44 = 16711935 - (var45 - 50) * 327680;
                                       } else if(var45 < 150) {
                                          var44 = (var45 - 100) * 327680 + 255 - (var45 - 100) * 5;
                                       }
                                    }

                                    if(Client.field901[var37] == 11) {
                                       var45 = 150 - Client.overheadTextsCyclesRemaining[var37];
                                       if(var45 < 50) {
                                          var44 = 16777215 - var45 * 327685;
                                       } else if(var45 < 100) {
                                          var44 = (var45 - 50) * 327685 + 65280;
                                       } else if(var45 < 150) {
                                          var44 = 16777215 - (var45 - 100) * 327680;
                                       }
                                    }

                                    if(Client.field902[var37] == 0) {
                                       class153.fontBold12.drawTextCentered(var59, var19 + Client.screenX, var20 + Client.screenY, var44, 0);
                                    }

                                    if(Client.field902[var37] == 1) {
                                       class153.fontBold12.method5509(var59, var19 + Client.screenX, var20 + Client.screenY, var44, 0, Client.field868);
                                    }

                                    if(Client.field902[var37] == 2) {
                                       class153.fontBold12.method5457(var59, var19 + Client.screenX, var20 + Client.screenY, var44, 0, Client.field868);
                                    }

                                    if(Client.field902[var37] == 3) {
                                       class153.fontBold12.method5445(var59, var19 + Client.screenX, var20 + Client.screenY, var44, 0, Client.field868, 150 - Client.overheadTextsCyclesRemaining[var37]);
                                    }

                                    if(Client.field902[var37] == 4) {
                                       var45 = (150 - Client.overheadTextsCyclesRemaining[var37]) * (class153.fontBold12.getTextWidth(var59) + 100) / 150;
                                       Rasterizer2D.setInnerDrawRegion(var19 + Client.screenX - 50, var20, var19 + Client.screenX + 50, var20 + var22);
                                       class153.fontBold12.method5451(var59, var19 + Client.screenX + 50 - var45, var20 + Client.screenY, var44, 0);
                                       Rasterizer2D.setDrawRegion(var19, var20, var21 + var19, var22 + var20);
                                    }

                                    if(Client.field902[var37] == 5) {
                                       var45 = 150 - Client.overheadTextsCyclesRemaining[var37];
                                       int var46 = 0;
                                       if(var45 < 25) {
                                          var46 = var45 - 25;
                                       } else if(var45 > 125) {
                                          var46 = var45 - 125;
                                       }

                                       Rasterizer2D.setInnerDrawRegion(var19, var20 + Client.screenY - class153.fontBold12.verticalSpace - 1, var21 + var19, var20 + Client.screenY + 5);
                                       class153.fontBold12.drawTextCentered(var59, var19 + Client.screenX, var20 + var46 + Client.screenY, var44, 0);
                                       Rasterizer2D.setDrawRegion(var19, var20, var21 + var19, var22 + var20);
                                    }
                                 } else {
                                    class153.fontBold12.drawTextCentered(var59, var19 + Client.screenX, var20 + Client.screenY, 16776960, 0);
                                 }
                              }

                              class271.method4881(var19, var20);
                              ((TextureProvider)Graphics3D.textureLoader).checkTextures(Client.field878);
                              WorldComparator.method66(var19, var20, var21, var22);
                              class39.cameraX = var49;
                              class159.cameraZ = var25;
                              CombatInfo1.cameraY = var26;
                              DecorativeObject.cameraPitchCopy = var27;
                              class60.cameraYaw = var28;
                              if(Client.field828 && LoginPacket.method3437(true, false) == 0) {
                                 Client.field828 = false;
                              }

                              if(Client.field828) {
                                 Rasterizer2D.Rasterizer2D_fillRectangle(var19, var20, var21, var22, 0);
                                 class235.drawStatusBox("Loading - please wait.", false);
                              }

                              Client.field979[var10.boundsIndex] = true;
                              Rasterizer2D.setDrawRegion(var2, var3, var4, var5);
                              continue label1487;
                           }

                           var50.vmethod48();
                        }
                     }

                     if(var10.contentType == 1338) {
                        class47.method734(var10, var12, var13, var11);
                        Rasterizer2D.setDrawRegion(var2, var3, var4, var5);
                        continue;
                     }

                     if(var10.contentType == 1339) {
                        class92.method1940(var10, var12, var13, var11);
                        Rasterizer2D.setDrawRegion(var2, var3, var4, var5);
                        continue;
                     }

                     if(var10.contentType == 1400) {
                        BoundingBox3D.renderOverview.extractWorldmap(var12, var13, var10.width, var10.height, Client.gameCycle);
                     }

                     if(var10.contentType == 1401) {
                        BoundingBox3D.renderOverview.extractData(var12, var13, var10.width, var10.height);
                     }
                  }

                  if(var10.type == 0) {
                     if(!var10.hasScript && class197.method3823(var10) && var10 != Varcs.field1389) {
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
                        Spotanim.method4793(var47.id, var15, var16, var17, var18, var12, var13, var11);
                     }

                     Rasterizer2D.setDrawRegion(var2, var3, var4, var5);
                     Graphics3D.Rasterizer3D_method1();
                  }

                  if(Client.isResized || Client.field1031[var11] || Client.gameDrawingMode > 1) {
                     if(var10.type == 0 && !var10.hasScript && var10.scrollHeight > var10.height) {
                        var19 = var12 + var10.width;
                        var20 = var10.scrollY;
                        var21 = var10.height;
                        var22 = var10.scrollHeight;
                        CacheFile.scrollbarSprites[0].method5783(var19, var13);
                        CacheFile.scrollbarSprites[1].method5783(var19, var13 + var21 - 16);
                        Rasterizer2D.Rasterizer2D_fillRectangle(var19, var13 + 16, 16, var21 - 32, Client.field957);
                        var23 = var21 * (var21 - 32) / var22;
                        if(var23 < 8) {
                           var23 = 8;
                        }

                        var49 = var20 * (var21 - 32 - var23) / (var22 - var21);
                        Rasterizer2D.Rasterizer2D_fillRectangle(var19, var49 + var13 + 16, 16, var23, Client.field880);
                        Rasterizer2D.method5685(var19, var49 + var13 + 16, var23, Client.field1035);
                        Rasterizer2D.method5685(var19 + 1, var13 + var49 + 16, var23, Client.field1035);
                        Rasterizer2D.method5683(var19, var13 + var49 + 16, 16, Client.field1035);
                        Rasterizer2D.method5683(var19, var49 + var13 + 17, 16, Client.field1035);
                        Rasterizer2D.method5685(var19 + 15, var49 + var13 + 16, var23, Client.field881);
                        Rasterizer2D.method5685(var19 + 14, var13 + var49 + 17, var23 - 1, Client.field881);
                        Rasterizer2D.method5683(var19, var49 + var13 + var23 + 15, 16, Client.field881);
                        Rasterizer2D.method5683(var19 + 1, var49 + var13 + var23 + 14, 15, Client.field881);
                     }

                     if(var10.type != 1) {
                        if(var10.type == 2) {
                           var19 = 0;

                           for(var20 = 0; var20 < var10.originalHeight; ++var20) {
                              for(var21 = 0; var21 < var10.originalWidth; ++var21) {
                                 var22 = var12 + var21 * (var10.paddingX + 32);
                                 var23 = var20 * (var10.paddingY + 32) + var13;
                                 if(var19 < 20) {
                                    var22 += var10.xSprites[var19];
                                    var23 += var10.field2825[var19];
                                 }

                                 if(var10.itemIds[var19] <= 0) {
                                    if(var10.field2866 != null && var19 < 20) {
                                       SpritePixels var61 = var10.method4427(var19);
                                       if(var61 != null) {
                                          var61.drawAt(var22, var23);
                                       } else if(Widget.field2820) {
                                          ScriptEvent.method1132(var10);
                                       }
                                    }
                                 } else {
                                    boolean var72 = false;
                                    boolean var63 = false;
                                    var26 = var10.itemIds[var19] - 1;
                                    if(var22 + 32 > var2 && var22 < var4 && var23 + 32 > var3 && var23 < var5 || var10 == class25.field348 && var19 == Client.field934) {
                                       SpritePixels var52;
                                       if(Client.itemSelectionState == 1 && var19 == GameObject.selectedItemIndex && var10.id == MouseInput.field670) {
                                          var52 = class149.createSprite(var26, var10.itemQuantities[var19], 2, 0, 2, false);
                                       } else {
                                          var52 = class149.createSprite(var26, var10.itemQuantities[var19], 1, 3153952, 2, false);
                                       }

                                       if(var52 != null) {
                                          if(var10 == class25.field348 && var19 == Client.field934) {
                                             var49 = MouseInput.mouseLastX - Client.field916;
                                             var25 = MouseInput.mouseLastY - Client.field917;
                                             if(var49 < 5 && var49 > -5) {
                                                var49 = 0;
                                             }

                                             if(var25 < 5 && var25 > -5) {
                                                var25 = 0;
                                             }

                                             if(Client.itemPressedDuration < 5) {
                                                var49 = 0;
                                                var25 = 0;
                                             }

                                             var52.drawAtOpacity(var22 + var49, var23 + var25, 128);
                                             if(var1 != -1) {
                                                Widget var73 = var0[var1 & 65535];
                                                if(var25 + var23 < Rasterizer2D.drawingAreaTop && var73.scrollY > 0) {
                                                   var29 = (Rasterizer2D.drawingAreaTop - var23 - var25) * Client.field878 / 3;
                                                   if(var29 > Client.field878 * 10) {
                                                      var29 = Client.field878 * 10;
                                                   }

                                                   if(var29 > var73.scrollY) {
                                                      var29 = var73.scrollY;
                                                   }

                                                   var73.scrollY -= var29;
                                                   Client.field917 += var29;
                                                   ScriptEvent.method1132(var73);
                                                }

                                                if(var23 + var25 + 32 > Rasterizer2D.drawingAreaRight && var73.scrollY < var73.scrollHeight - var73.height) {
                                                   var29 = (var23 + var25 + 32 - Rasterizer2D.drawingAreaRight) * Client.field878 / 3;
                                                   if(var29 > Client.field878 * 10) {
                                                      var29 = Client.field878 * 10;
                                                   }

                                                   if(var29 > var73.scrollHeight - var73.height - var73.scrollY) {
                                                      var29 = var73.scrollHeight - var73.height - var73.scrollY;
                                                   }

                                                   var73.scrollY += var29;
                                                   Client.field917 -= var29;
                                                   ScriptEvent.method1132(var73);
                                                }
                                             }
                                          } else if(var10 == UnitPriceComparator.field298 && var19 == Client.pressedItemIndex) {
                                             var52.drawAtOpacity(var22, var23, 128);
                                          } else {
                                             var52.drawAt(var22, var23);
                                          }
                                       } else {
                                          ScriptEvent.method1132(var10);
                                       }
                                    }
                                 }

                                 ++var19;
                              }
                           }
                        } else if(var10.type == 3) {
                           if(Renderable.method3049(var10)) {
                              var19 = var10.field2803;
                              if(var10 == Varcs.field1389 && var10.field2805 != 0) {
                                 var19 = var10.field2805;
                              }
                           } else {
                              var19 = var10.textColor;
                              if(var10 == Varcs.field1389 && var10.field2896 != 0) {
                                 var19 = var10.field2896;
                              }
                           }

                           if(var10.filled) {
                              switch(var10.field2807.field3890) {
                              case 1:
                                 Rasterizer2D.method5675(var12, var13, var10.width, var10.height, var10.textColor, var10.field2803, 256 - (var10.opacity & 255), 256 - (var10.field2772 & 255));
                                 break;
                              case 2:
                                 Rasterizer2D.method5676(var12, var13, var10.width, var10.height, var10.textColor, var10.field2803, 256 - (var10.opacity & 255), 256 - (var10.field2772 & 255));
                                 break;
                              case 3:
                                 Rasterizer2D.method5677(var12, var13, var10.width, var10.height, var10.textColor, var10.field2803, 256 - (var10.opacity & 255), 256 - (var10.field2772 & 255));
                                 break;
                              case 4:
                                 Rasterizer2D.method5743(var12, var13, var10.width, var10.height, var10.textColor, var10.field2803, 256 - (var10.opacity & 255), 256 - (var10.field2772 & 255));
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
                           String var24;
                           String var56;
                           Font var66;
                           String var68;
                           if(var10.type == 4) {
                              var66 = var10.getFont();
                              if(var66 == null) {
                                 if(Widget.field2820) {
                                    ScriptEvent.method1132(var10);
                                 }
                              } else {
                                 String var75 = var10.text;
                                 if(Renderable.method3049(var10)) {
                                    var20 = var10.field2803;
                                    if(var10 == Varcs.field1389 && var10.field2805 != 0) {
                                       var20 = var10.field2805;
                                    }

                                    if(var10.string1.length() > 0) {
                                       var75 = var10.string1;
                                    }
                                 } else {
                                    var20 = var10.textColor;
                                    if(var10 == Varcs.field1389 && var10.field2896 != 0) {
                                       var20 = var10.field2896;
                                    }
                                 }

                                 StringBuilder var10000;
                                 if(var10.hasScript && var10.itemId != -1) {
                                    ItemComposition var76 = ContextMenuRow.getItemDefinition(var10.itemId);
                                    var75 = var76.name;
                                    if(var75 == null) {
                                       var75 = "null";
                                    }

                                    if((var76.isStackable == 1 || var10.itemQuantity != 1) && var10.itemQuantity != -1) {
                                       var68 = BoundingBox3D.getColTags(16748608) + var75 + "</col>" + " " + 'x';
                                       var25 = var10.itemQuantity;
                                       var56 = Integer.toString(var25);

                                       for(var27 = var56.length() - 3; var27 > 0; var27 -= 3) {
                                          var56 = var56.substring(0, var27) + "," + var56.substring(var27);
                                       }

                                       Object var10001;
                                       if(var56.length() > 9) {
                                          var10000 = (new StringBuilder()).append(" ").append(BoundingBox3D.getColTags(65408)).append(var56.substring(0, var56.length() - 8));
                                          var10001 = null;
                                          var24 = var10000.append("M").append(" ").append(" (").append(var56).append(")").append("</col>").toString();
                                       } else if(var56.length() > 6) {
                                          var10000 = (new StringBuilder()).append(" ").append(BoundingBox3D.getColTags(16777215)).append(var56.substring(0, var56.length() - 4));
                                          var10001 = null;
                                          var24 = var10000.append("K").append(" ").append(" (").append(var56).append(")").append("</col>").toString();
                                       } else {
                                          var24 = " " + BoundingBox3D.getColTags(16776960) + var56 + "</col>";
                                       }

                                       var75 = var68 + var24;
                                    }
                                 }

                                 if(var10 == Client.field930) {
                                    var10000 = null;
                                    var75 = "Please wait...";
                                    var20 = var10.textColor;
                                 }

                                 if(!var10.hasScript) {
                                    var75 = class47.method733(var75, var10);
                                 }

                                 var66.method5455(var75, var12, var13, var10.width, var10.height, var20, var10.textShadowed?0:-1, var10.field2779, var10.field2847, var10.field2839);
                              }
                           } else if(var10.type == 5) {
                              SpritePixels var67;
                              if(!var10.hasScript) {
                                 var67 = var10.method4425(Renderable.method3049(var10));
                                 if(var67 != null) {
                                    var67.drawAt(var12, var13);
                                 } else if(Widget.field2820) {
                                    ScriptEvent.method1132(var10);
                                 }
                              } else {
                                 if(var10.itemId != -1) {
                                    var67 = class149.createSprite(var10.itemId, var10.itemQuantity, var10.borderThickness, var10.sprite2, var10.field2858, false);
                                 } else {
                                    var67 = var10.method4425(false);
                                 }

                                 if(var67 == null) {
                                    if(Widget.field2820) {
                                       ScriptEvent.method1132(var10);
                                    }
                                 } else {
                                    var20 = var67.maxWidth;
                                    var21 = var67.maxHeight;
                                    if(!var10.spriteTiling) {
                                       var22 = var10.width * 4096 / var20;
                                       if(var10.textureId != 0) {
                                          var67.method5826(var10.width / 2 + var12, var10.height / 2 + var13, var10.textureId, var22);
                                       } else if(var14 != 0) {
                                          var67.method5818(var12, var13, var10.width, var10.height, 256 - (var14 & 255));
                                       } else if(var20 == var10.width && var21 == var10.height) {
                                          var67.drawAt(var12, var13);
                                       } else {
                                          var67.method5863(var12, var13, var10.width, var10.height);
                                       }
                                    } else {
                                       Rasterizer2D.setInnerDrawRegion(var12, var13, var12 + var10.width, var13 + var10.height);
                                       var22 = (var20 - 1 + var10.width) / var20;
                                       var23 = (var21 - 1 + var10.height) / var21;

                                       for(var49 = 0; var49 < var22; ++var49) {
                                          for(var25 = 0; var25 < var23; ++var25) {
                                             if(var10.textureId != 0) {
                                                var67.method5826(var20 / 2 + var12 + var49 * var20, var21 / 2 + var13 + var25 * var21, var10.textureId, 4096);
                                             } else if(var14 != 0) {
                                                var67.drawAtOpacity(var12 + var49 * var20, var13 + var21 * var25, 256 - (var14 & 255));
                                             } else {
                                                var67.drawAt(var12 + var20 * var49, var13 + var25 * var21);
                                             }
                                          }
                                       }

                                       Rasterizer2D.setDrawRegion(var2, var3, var4, var5);
                                    }
                                 }
                              }
                           } else {
                              ItemComposition var48;
                              if(var10.type == 6) {
                                 boolean var60 = Renderable.method3049(var10);
                                 if(var60) {
                                    var20 = var10.field2765;
                                 } else {
                                    var20 = var10.field2824;
                                 }

                                 Model var74 = null;
                                 var22 = 0;
                                 if(var10.itemId != -1) {
                                    var48 = ContextMenuRow.getItemDefinition(var10.itemId);
                                    if(var48 != null) {
                                       var48 = var48.method4998(var10.itemQuantity);
                                       var74 = var48.getModel(1);
                                       if(var74 != null) {
                                          var74.calculateBoundsCylinder();
                                          var22 = var74.modelHeight / 2;
                                       } else {
                                          ScriptEvent.method1132(var10);
                                       }
                                    }
                                 } else if(var10.modelType == 5) {
                                    if(var10.modelId == 0) {
                                       var74 = Client.field1068.getModel((Sequence)null, -1, (Sequence)null, -1);
                                    } else {
                                       var74 = OwnWorldComparator.localPlayer.getModel();
                                    }
                                 } else if(var20 == -1) {
                                    var74 = var10.getModel((Sequence)null, -1, var60, OwnWorldComparator.localPlayer.composition);
                                    if(var74 == null && Widget.field2820) {
                                       ScriptEvent.method1132(var10);
                                    }
                                 } else {
                                    Sequence var70 = Occluder.getAnimation(var20);
                                    var74 = var10.getModel(var70, var10.field2899, var60, OwnWorldComparator.localPlayer.composition);
                                    if(var74 == null && Widget.field2820) {
                                       ScriptEvent.method1132(var10);
                                    }
                                 }

                                 Graphics3D.method2835(var10.width / 2 + var12, var10.height / 2 + var13);
                                 var23 = Graphics3D.SINE[var10.rotationX] * var10.modelZoom >> 16;
                                 var49 = Graphics3D.COSINE[var10.rotationX] * var10.modelZoom >> 16;
                                 if(var74 != null) {
                                    if(!var10.hasScript) {
                                       var74.method2731(0, var10.rotationZ, 0, var10.rotationX, 0, var23, var49);
                                    } else {
                                       var74.calculateBoundsCylinder();
                                       if(var10.field2834) {
                                          var74.method2721(0, var10.rotationZ, var10.rotationY, var10.rotationX, var10.field2835, var22 + var23 + var10.field2795, var49 + var10.field2795, var10.modelZoom);
                                       } else {
                                          var74.method2731(0, var10.rotationZ, var10.rotationY, var10.rotationX, var10.field2835, var23 + var22 + var10.field2795, var49 + var10.field2795);
                                       }
                                    }
                                 }

                                 Graphics3D.Rasterizer3D_method3();
                              } else {
                                 if(var10.type == 7) {
                                    var66 = var10.getFont();
                                    if(var66 == null) {
                                       if(Widget.field2820) {
                                          ScriptEvent.method1132(var10);
                                       }
                                       continue;
                                    }

                                    var20 = 0;

                                    for(var21 = 0; var21 < var10.originalHeight; ++var21) {
                                       for(var22 = 0; var22 < var10.originalWidth; ++var22) {
                                          if(var10.itemIds[var20] > 0) {
                                             var48 = ContextMenuRow.getItemDefinition(var10.itemIds[var20] - 1);
                                             if(var48.isStackable != 1 && var10.itemQuantities[var20] == 1) {
                                                var24 = BoundingBox3D.getColTags(16748608) + var48.name + "</col>";
                                             } else {
                                                String var57 = BoundingBox3D.getColTags(16748608) + var48.name + "</col>" + " " + 'x';
                                                var27 = var10.itemQuantities[var20];
                                                String var53 = Integer.toString(var27);

                                                for(var29 = var53.length() - 3; var29 > 0; var29 -= 3) {
                                                   var53 = var53.substring(0, var29) + "," + var53.substring(var29);
                                                }

                                                if(var53.length() > 9) {
                                                   var56 = " " + BoundingBox3D.getColTags(65408) + var53.substring(0, var53.length() - 8) + "M" + " " + " (" + var53 + ")" + "</col>";
                                                } else if(var53.length() > 6) {
                                                   var56 = " " + BoundingBox3D.getColTags(16777215) + var53.substring(0, var53.length() - 4) + "K" + " " + " (" + var53 + ")" + "</col>";
                                                } else {
                                                   var56 = " " + BoundingBox3D.getColTags(16776960) + var53 + "</col>";
                                                }

                                                var24 = var57 + var56;
                                             }

                                             var25 = var22 * (var10.paddingX + 115) + var12;
                                             var26 = (var10.paddingY + 12) * var21 + var13;
                                             if(var10.field2779 == 0) {
                                                var66.method5451(var24, var25, var26, var10.textColor, var10.textShadowed?0:-1);
                                             } else if(var10.field2779 == 1) {
                                                var66.drawTextCentered(var24, var10.width / 2 + var25, var26, var10.textColor, var10.textShadowed?0:-1);
                                             } else {
                                                var66.method5453(var24, var25 + var10.width - 1, var26, var10.textColor, var10.textShadowed?0:-1);
                                             }
                                          }

                                          ++var20;
                                       }
                                    }
                                 }

                                 if(var10.type == 8 && var10 == WorldComparator.field258 && Client.field933 == Client.field879) {
                                    var19 = 0;
                                    var20 = 0;
                                    Font var54 = ClanMemberManager.font_p12full;
                                    String var55 = var10.text;

                                    for(var55 = class47.method733(var55, var10); var55.length() > 0; var20 = var20 + var54.verticalSpace + 1) {
                                       var49 = var55.indexOf("<br>");
                                       if(var49 != -1) {
                                          var68 = var55.substring(0, var49);
                                          var55 = var55.substring(var49 + 4);
                                       } else {
                                          var68 = var55;
                                          var55 = "";
                                       }

                                       var25 = var54.getTextWidth(var68);
                                       if(var25 > var19) {
                                          var19 = var25;
                                       }
                                    }

                                    var19 += 6;
                                    var20 += 7;
                                    var49 = var12 + var10.width - 5 - var19;
                                    var25 = var13 + var10.height + 5;
                                    if(var49 < var12 + 5) {
                                       var49 = var12 + 5;
                                    }

                                    if(var19 + var49 > var4) {
                                       var49 = var4 - var19;
                                    }

                                    if(var20 + var25 > var5) {
                                       var25 = var5 - var20;
                                    }

                                    Rasterizer2D.Rasterizer2D_fillRectangle(var49, var25, var19, var20, 16777120);
                                    Rasterizer2D.drawRectangle(var49, var25, var19, var20, 0);
                                    var55 = var10.text;
                                    var26 = var25 + var54.verticalSpace + 2;

                                    for(var55 = class47.method733(var55, var10); var55.length() > 0; var26 = var26 + var54.verticalSpace + 1) {
                                       var27 = var55.indexOf("<br>");
                                       if(var27 != -1) {
                                          var68 = var55.substring(0, var27);
                                          var55 = var55.substring(var27 + 4);
                                       } else {
                                          var68 = var55;
                                          var55 = "";
                                       }

                                       var54.method5451(var68, var49 + 3, var26, 0, -1);
                                    }
                                 }

                                 if(var10.type == 9) {
                                    if(var10.field2889) {
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
                                          var35 = var33 * var26 + 1 >> 17;
                                          var36 = var32 * var26 >> 17;
                                          var37 = var26 * var32 + 1 >> 17;
                                          var23 = var19 - Rasterizer2D.draw_region_x;
                                          var49 = var20 - Rasterizer2D.drawingAreaTop;
                                          var58 = var23 + var34;
                                          var39 = var23 - var35;
                                          var40 = var27 + var23 - var35;
                                          var41 = var34 + var23 + var27;
                                          int var42 = var36 + var49;
                                          var43 = var49 - var37;
                                          var44 = var49 + var28 - var37;
                                          var45 = var49 + var28 + var36;
                                          Graphics3D.setRasterClippingEnabled(var58, var39, var40);
                                          Graphics3D.rasterFlat(var42, var43, var44, var58, var39, var40, var25);
                                          Graphics3D.setRasterClippingEnabled(var58, var40, var41);
                                          Graphics3D.rasterFlat(var42, var44, var45, var58, var40, var41, var25);
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
