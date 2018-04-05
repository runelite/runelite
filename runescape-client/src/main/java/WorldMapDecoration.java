import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("al")
@Implements("WorldMapDecoration")
public class WorldMapDecoration {
   @ObfuscatedName("pp")
   @ObfuscatedSignature(
      signature = "Ldq;"
   )
   static Resampler field446;
   @ObfuscatedName("m")
   @Export("indexSpriteWidths")
   static int[] indexSpriteWidths;
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Lki;"
   )
   public static Font field445;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -482495715
   )
   @Export("objectDefinitionId")
   final int objectDefinitionId;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -1094644915
   )
   @Export("decoration")
   final int decoration;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 823954177
   )
   @Export("rotation")
   final int rotation;

   WorldMapDecoration(int var1, int var2, int var3) {
      this.objectDefinitionId = var1;
      this.decoration = var2;
      this.rotation = var3;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(CI)Z",
      garbageValue = "-2096250241"
   )
   static final boolean method315(char var0) {
      return var0 == 160 || var0 == ' ' || var0 == '_' || var0 == '-';
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(II)Lcr;",
      garbageValue = "-597555070"
   )
   static Script method313(int var0) {
      Script var1 = (Script)Script.field1459.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = class190.indexScripts.getConfigData(var0, 0);
         if(var2 == null) {
            return null;
         } else {
            var1 = Signlink.newScript(var2);
            Script.field1459.put(var1, (long)var0);
            return var1;
         }
      }
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(IIIIIZI)Lld;",
      garbageValue = "-717116517"
   )
   @Export("createSprite")
   public static final SpritePixels createSprite(int var0, int var1, int var2, int var3, int var4, boolean var5) {
      if(var1 == -1) {
         var4 = 0;
      } else if(var4 == 2 && var1 != 1) {
         var4 = 1;
      }

      long var6 = ((long)var1 << 16) + (long)var0 + ((long)var2 << 38) + ((long)var4 << 40) + ((long)var3 << 42);
      SpritePixels var8;
      if(!var5) {
         var8 = (SpritePixels)ItemComposition.itemSpriteCache.get(var6);
         if(var8 != null) {
            return var8;
         }
      }

      ItemComposition var9 = class47.getItemDefinition(var0);
      if(var1 > 1 && var9.countObj != null) {
         int var10 = -1;

         for(int var11 = 0; var11 < 10; ++var11) {
            if(var1 >= var9.countCo[var11] && var9.countCo[var11] != 0) {
               var10 = var9.countObj[var11];
            }
         }

         if(var10 != -1) {
            var9 = class47.getItemDefinition(var10);
         }
      }

      Model var19 = var9.getModel(1);
      if(var19 == null) {
         return null;
      } else {
         SpritePixels var20 = null;
         if(var9.notedTemplate != -1) {
            var20 = createSprite(var9.note, 10, 1, 0, 0, true);
            if(var20 == null) {
               return null;
            }
         } else if(var9.notedId != -1) {
            var20 = createSprite(var9.unnotedId, var1, var2, var3, 0, false);
            if(var20 == null) {
               return null;
            }
         } else if(var9.placeholderTemplateId != -1) {
            var20 = createSprite(var9.placeholderId, var1, 0, 0, 0, false);
            if(var20 == null) {
               return null;
            }
         }

         int[] var12 = Rasterizer2D.graphicsPixels;
         int var13 = Rasterizer2D.graphicsPixelsWidth;
         int var14 = Rasterizer2D.graphicsPixelsHeight;
         int[] var15 = new int[4];
         Rasterizer2D.copyDrawRegion(var15);
         var8 = new SpritePixels(36, 32);
         Rasterizer2D.setRasterBuffer(var8.pixels, 36, 32);
         Rasterizer2D.reset();
         Graphics3D.Rasterizer3D_method1();
         Graphics3D.method2780(16, 16);
         Graphics3D.rasterGouraudLowRes = false;
         if(var9.placeholderTemplateId != -1) {
            var20.drawAt(0, 0);
         }

         int var16 = var9.zoom2d;
         if(var5) {
            var16 = (int)((double)var16 * 1.5D);
         } else if(var2 == 2) {
            var16 = (int)((double)var16 * 1.04D);
         }

         int var17 = var16 * Graphics3D.SINE[var9.xan2d] >> 16;
         int var18 = var16 * Graphics3D.COSINE[var9.xan2d] >> 16;
         var19.calculateBoundsCylinder();
         var19.method2734(0, var9.yan2d, var9.zan2d, var9.xan2d, var9.offsetX2d, var19.modelHeight / 2 + var17 + var9.offsetY2d, var18 + var9.offsetY2d);
         if(var9.notedId != -1) {
            var20.drawAt(0, 0);
         }

         if(var2 >= 1) {
            var8.method5854(1);
         }

         if(var2 >= 2) {
            var8.method5854(16777215);
         }

         if(var3 != 0) {
            var8.method5855(var3);
         }

         Rasterizer2D.setRasterBuffer(var8.pixels, 36, 32);
         if(var9.notedTemplate != -1) {
            var20.drawAt(0, 0);
         }

         if(var4 == 1 || var4 == 2 && var9.isStackable == 1) {
            field445.method5510(PlayerComposition.method4408(var1), 0, 9, 16776960, 1);
         }

         if(!var5) {
            ItemComposition.itemSpriteCache.put(var8, var6);
         }

         Rasterizer2D.setRasterBuffer(var12, var13, var14);
         Rasterizer2D.setDrawRegion(var15);
         Graphics3D.Rasterizer3D_method1();
         Graphics3D.rasterGouraudLowRes = true;
         return var8;
      }
   }

   @ObfuscatedName("at")
   @ObfuscatedSignature(
      signature = "(ILix;ZI)V",
      garbageValue = "-708527233"
   )
   static void method310(int var0, Coordinates var1, boolean var2) {
      WorldMapData var3 = class86.method1892().getWorldMapDataByFileId(var0);
      int var4 = SoundTaskDataProvider.localPlayer.field856;
      int var5 = (SoundTaskDataProvider.localPlayer.x >> 7) + class138.baseX;
      int var6 = (SoundTaskDataProvider.localPlayer.y >> 7) + class23.baseY;
      Coordinates var7 = new Coordinates(var4, var5, var6);
      class86.method1892().method6024(var3, var7, var1, var2);
   }

   @ObfuscatedName("fv")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "978144869"
   )
   static final void method314(int var0, int var1, int var2, int var3) {
      ++Client.field1137;
      GroundObject.method2670();
      if(Client.field988) {
         WorldMapManager.method627(SoundTaskDataProvider.localPlayer, false);
      }

      if(Client.field1112 >= 0 && Client.cachedPlayers[Client.field1112] != null) {
         WorldMapManager.method627(Client.cachedPlayers[Client.field1112], false);
      }

      ISAACCipher.method3809(true);
      class49.method755();
      ISAACCipher.method3809(false);
      class177.method3427();

      for(GraphicsObject var4 = (GraphicsObject)Client.graphicsObjectDeque.getFront(); var4 != null; var4 = (GraphicsObject)Client.graphicsObjectDeque.getNext()) {
         if(var4.level == BoundingBox3DDrawMode.plane && !var4.finished) {
            if(Client.gameCycle >= var4.startCycle) {
               var4.method1851(Client.field930);
               if(var4.finished) {
                  var4.unlink();
               } else {
                  class255.region.method2863(var4.level, var4.x, var4.y, var4.height, 60, var4, 0, -1, false);
               }
            }
         } else {
            var4.unlink();
         }
      }

      WorldMapRegion.method535(var0, var1, var2, var3, true);
      var0 = Client.Viewport_xOffset;
      var1 = Client.Viewport_yOffset;
      var2 = Client.viewportWidth;
      var3 = Client.viewportHeight;
      Rasterizer2D.setDrawRegion(var0, var1, var0 + var2, var3 + var1);
      Graphics3D.Rasterizer3D_method1();
      int var5;
      int var6;
      int var7;
      int var8;
      int var9;
      int var10;
      int var11;
      int var12;
      int var13;
      int var14;
      int var15;
      int var16;
      int var28;
      if(!Client.field1111) {
         var28 = Client.cameraPitchTarget;
         if(Client.field884 / 256 > var28) {
            var28 = Client.field884 / 256;
         }

         if(Client.field955[4] && Client.field1006[4] + 128 > var28) {
            var28 = Client.field1006[4] + 128;
         }

         var5 = Client.mapAngle & 2047;
         var6 = class169.field2228;
         var7 = ObjectComposition.field3640;
         var8 = class46.field578;
         var9 = var28 * 3 + 600;
         var10 = 2048 - var28 & 2047;
         var11 = 2048 - var5 & 2047;
         var12 = 0;
         var13 = 0;
         var14 = var9;
         int var17;
         if(var10 != 0) {
            var15 = Graphics3D.SINE[var10];
            var16 = Graphics3D.COSINE[var10];
            var17 = var13 * var16 - var15 * var9 >> 16;
            var14 = var16 * var9 + var13 * var15 >> 16;
            var13 = var17;
         }

         if(var11 != 0) {
            var15 = Graphics3D.SINE[var11];
            var16 = Graphics3D.COSINE[var11];
            var17 = var16 * var12 + var15 * var14 >> 16;
            var14 = var14 * var16 - var15 * var12 >> 16;
            var12 = var17;
         }

         Player.cameraX = var6 - var12;
         GameObject.cameraZ = var7 - var13;
         class20.cameraY = var8 - var14;
         GrandExchangeOffer.cameraPitch = var28;
         class28.cameraYaw = var5;
         if(Client.field960 == 1 && Client.rights >= 2 && Client.gameCycle % 50 == 0 && (class169.field2228 >> 7 != SoundTaskDataProvider.localPlayer.x >> 7 || class46.field578 >> 7 != SoundTaskDataProvider.localPlayer.y >> 7)) {
            var15 = SoundTaskDataProvider.localPlayer.field856;
            var16 = (class169.field2228 >> 7) + class138.baseX;
            var17 = (class46.field578 >> 7) + class23.baseY;
            class19.method166(var16, var17, var15, true);
         }
      }

      if(!Client.field1111) {
         if(Client.preferences.hideRoofs) {
            var5 = BoundingBox3DDrawMode.plane;
         } else {
            label680: {
               var6 = 3;
               if(GrandExchangeOffer.cameraPitch < 310) {
                  if(Client.field960 == 1) {
                     var7 = class169.field2228 >> 7;
                     var8 = class46.field578 >> 7;
                  } else {
                     var7 = SoundTaskDataProvider.localPlayer.x >> 7;
                     var8 = SoundTaskDataProvider.localPlayer.y >> 7;
                  }

                  var9 = Player.cameraX >> 7;
                  var10 = class20.cameraY >> 7;
                  if(var9 < 0 || var10 < 0 || var9 >= 104 || var10 >= 104) {
                     var5 = BoundingBox3DDrawMode.plane;
                     break label680;
                  }

                  if(var7 < 0 || var8 < 0 || var7 >= 104 || var8 >= 104) {
                     var5 = BoundingBox3DDrawMode.plane;
                     break label680;
                  }

                  if((class62.tileSettings[BoundingBox3DDrawMode.plane][var9][var10] & 4) != 0) {
                     var6 = BoundingBox3DDrawMode.plane;
                  }

                  if(var7 > var9) {
                     var11 = var7 - var9;
                  } else {
                     var11 = var9 - var7;
                  }

                  if(var8 > var10) {
                     var12 = var8 - var10;
                  } else {
                     var12 = var10 - var8;
                  }

                  if(var11 > var12) {
                     var13 = var12 * 65536 / var11;
                     var14 = 32768;

                     while(var7 != var9) {
                        if(var9 < var7) {
                           ++var9;
                        } else if(var9 > var7) {
                           --var9;
                        }

                        if((class62.tileSettings[BoundingBox3DDrawMode.plane][var9][var10] & 4) != 0) {
                           var6 = BoundingBox3DDrawMode.plane;
                        }

                        var14 += var13;
                        if(var14 >= 65536) {
                           var14 -= 65536;
                           if(var10 < var8) {
                              ++var10;
                           } else if(var10 > var8) {
                              --var10;
                           }

                           if((class62.tileSettings[BoundingBox3DDrawMode.plane][var9][var10] & 4) != 0) {
                              var6 = BoundingBox3DDrawMode.plane;
                           }
                        }
                     }
                  } else if(var12 > 0) {
                     var13 = var11 * 65536 / var12;
                     var14 = 32768;

                     while(var10 != var8) {
                        if(var10 < var8) {
                           ++var10;
                        } else if(var10 > var8) {
                           --var10;
                        }

                        if((class62.tileSettings[BoundingBox3DDrawMode.plane][var9][var10] & 4) != 0) {
                           var6 = BoundingBox3DDrawMode.plane;
                        }

                        var14 += var13;
                        if(var14 >= 65536) {
                           var14 -= 65536;
                           if(var9 < var7) {
                              ++var9;
                           } else if(var9 > var7) {
                              --var9;
                           }

                           if((class62.tileSettings[BoundingBox3DDrawMode.plane][var9][var10] & 4) != 0) {
                              var6 = BoundingBox3DDrawMode.plane;
                           }
                        }
                     }
                  }
               }

               if(SoundTaskDataProvider.localPlayer.x >= 0 && SoundTaskDataProvider.localPlayer.y >= 0 && SoundTaskDataProvider.localPlayer.x < 13312 && SoundTaskDataProvider.localPlayer.y < 13312) {
                  if((class62.tileSettings[BoundingBox3DDrawMode.plane][SoundTaskDataProvider.localPlayer.x >> 7][SoundTaskDataProvider.localPlayer.y >> 7] & 4) != 0) {
                     var6 = BoundingBox3DDrawMode.plane;
                  }

                  var5 = var6;
               } else {
                  var5 = BoundingBox3DDrawMode.plane;
               }
            }
         }

         var28 = var5;
      } else {
         var28 = GameCanvas.method831();
      }

      var5 = Player.cameraX;
      var6 = GameObject.cameraZ;
      var7 = class20.cameraY;
      var8 = GrandExchangeOffer.cameraPitch;
      var9 = class28.cameraYaw;

      for(var10 = 0; var10 < 5; ++var10) {
         if(Client.field955[var10]) {
            var11 = (int)(Math.random() * (double)(Client.field942[var10] * 2 + 1) - (double)Client.field942[var10] + Math.sin((double)Client.field1116[var10] * ((double)Client.field939[var10] / 100.0D)) * (double)Client.field1006[var10]);
            if(var10 == 0) {
               Player.cameraX += var11;
            }

            if(var10 == 1) {
               GameObject.cameraZ += var11;
            }

            if(var10 == 2) {
               class20.cameraY += var11;
            }

            if(var10 == 3) {
               class28.cameraYaw = var11 + class28.cameraYaw & 2047;
            }

            if(var10 == 4) {
               GrandExchangeOffer.cameraPitch += var11;
               if(GrandExchangeOffer.cameraPitch < 128) {
                  GrandExchangeOffer.cameraPitch = 128;
               }

               if(GrandExchangeOffer.cameraPitch > 383) {
                  GrandExchangeOffer.cameraPitch = 383;
               }
            }
         }
      }

      var10 = MouseInput.mouseLastX;
      var11 = MouseInput.mouseLastY;
      if(MouseInput.mouseLastButton != 0) {
         var10 = MouseInput.mouseLastPressedX;
         var11 = MouseInput.mouseLastPressedY;
      }

      if(var10 >= var0 && var10 < var0 + var2 && var11 >= var1 && var11 < var3 + var1) {
         var12 = var10 - var0;
         var13 = var11 - var1;
         class132.Viewport_mouseX = var12;
         class132.Viewport_mouseY = var13;
         class132.Viewport_containsMouse = true;
         class132.Viewport_entityCountAtMouse = 0;
         class132.Viewport_false0 = false;
      } else {
         class132.Viewport_containsMouse = false;
         class132.Viewport_entityCountAtMouse = 0;
      }

      BoundingBox2D.method36();
      Rasterizer2D.Rasterizer2D_fillRectangle(var0, var1, var2, var3, 0);
      BoundingBox2D.method36();
      var12 = Graphics3D.Rasterizer3D_zoom;
      Graphics3D.Rasterizer3D_zoom = Client.scale;
      class255.region.drawRegion(Player.cameraX, GameObject.cameraZ, class20.cameraY, GrandExchangeOffer.cameraPitch, class28.cameraYaw, var28);

      while(true) {
         BoundingBox var29 = (BoundingBox)class7.boundingBoxes.removeLast();
         if(var29 == null) {
            Graphics3D.Rasterizer3D_zoom = var12;
            BoundingBox2D.method36();
            class255.region.clearEntities();
            Client.overheadTextCount = 0;
            boolean var33 = false;
            var14 = -1;
            var15 = -1;
            var16 = class93.playerIndexesCount;
            int[] var30 = class93.playerIndices;

            int var18;
            for(var18 = 0; var18 < var16 + Client.npcIndexesCount; ++var18) {
               Object var19;
               if(var18 < var16) {
                  var19 = Client.cachedPlayers[var30[var18]];
                  if(var30[var18] == Client.field1112) {
                     var33 = true;
                     var14 = var18;
                     continue;
                  }

                  if(var19 == SoundTaskDataProvider.localPlayer) {
                     var15 = var18;
                     continue;
                  }
               } else {
                  var19 = Client.cachedNPCs[Client.npcIndices[var18 - var16]];
               }

               DState.draw2DExtras((Actor)var19, var18, var0, var1, var2, var3);
            }

            if(Client.field988 && var15 != -1) {
               DState.draw2DExtras(SoundTaskDataProvider.localPlayer, var15, var0, var1, var2, var3);
            }

            if(var33) {
               DState.draw2DExtras(Client.cachedPlayers[Client.field1112], var14, var0, var1, var2, var3);
            }

            for(var18 = 0; var18 < Client.overheadTextCount; ++var18) {
               int var31 = Client.overheadTextsX[var18];
               int var20 = Client.overheadTextsY[var18];
               int var21 = Client.overheadTextsOffsetX[var18];
               int var22 = Client.overheadTextsOffsetY[var18];
               boolean var23 = true;

               while(var23) {
                  var23 = false;

                  for(int var24 = 0; var24 < var18; ++var24) {
                     if(var20 + 2 > Client.overheadTextsY[var24] - Client.overheadTextsOffsetY[var24] && var20 - var22 < Client.overheadTextsY[var24] + 2 && var31 - var21 < Client.overheadTextsOffsetX[var24] + Client.overheadTextsX[var24] && var21 + var31 > Client.overheadTextsX[var24] - Client.overheadTextsOffsetX[var24] && Client.overheadTextsY[var24] - Client.overheadTextsOffsetY[var24] < var20) {
                        var20 = Client.overheadTextsY[var24] - Client.overheadTextsOffsetY[var24];
                        var23 = true;
                     }
                  }
               }

               Client.screenX = Client.overheadTextsX[var18];
               Client.screenY = Client.overheadTextsY[var18] = var20;
               String var32 = Client.overheadTexts[var18];
               if(Client.field1031 == 0) {
                  int var25 = 16776960;
                  if(Client.field962[var18] < 6) {
                     var25 = Client.field1082[Client.field962[var18]];
                  }

                  if(Client.field962[var18] == 6) {
                     var25 = Client.field1137 % 20 < 10?16711680:16776960;
                  }

                  if(Client.field962[var18] == 7) {
                     var25 = Client.field1137 % 20 < 10?255:'\uffff';
                  }

                  if(Client.field962[var18] == 8) {
                     var25 = Client.field1137 % 20 < 10?'뀀':8454016;
                  }

                  int var26;
                  if(Client.field962[var18] == 9) {
                     var26 = 150 - Client.overheadTextsCyclesRemaining[var18];
                     if(var26 < 50) {
                        var25 = var26 * 1280 + 16711680;
                     } else if(var26 < 100) {
                        var25 = 16776960 - (var26 - 50) * 327680;
                     } else if(var26 < 150) {
                        var25 = (var26 - 100) * 5 + 65280;
                     }
                  }

                  if(Client.field962[var18] == 10) {
                     var26 = 150 - Client.overheadTextsCyclesRemaining[var18];
                     if(var26 < 50) {
                        var25 = var26 * 5 + 16711680;
                     } else if(var26 < 100) {
                        var25 = 16711935 - (var26 - 50) * 327680;
                     } else if(var26 < 150) {
                        var25 = (var26 - 100) * 327680 + 255 - (var26 - 100) * 5;
                     }
                  }

                  if(Client.field962[var18] == 11) {
                     var26 = 150 - Client.overheadTextsCyclesRemaining[var18];
                     if(var26 < 50) {
                        var25 = 16777215 - var26 * 327685;
                     } else if(var26 < 100) {
                        var25 = (var26 - 50) * 327685 + 65280;
                     } else if(var26 < 150) {
                        var25 = 16777215 - (var26 - 100) * 327680;
                     }
                  }

                  if(Client.field963[var18] == 0) {
                     MessageNode.fontBold12.drawTextCentered(var32, var0 + Client.screenX, Client.screenY + var1, var25, 0);
                  }

                  if(Client.field963[var18] == 1) {
                     MessageNode.fontBold12.method5515(var32, var0 + Client.screenX, Client.screenY + var1, var25, 0, Client.field1137);
                  }

                  if(Client.field963[var18] == 2) {
                     MessageNode.fontBold12.method5516(var32, var0 + Client.screenX, Client.screenY + var1, var25, 0, Client.field1137);
                  }

                  if(Client.field963[var18] == 3) {
                     MessageNode.fontBold12.method5517(var32, var0 + Client.screenX, Client.screenY + var1, var25, 0, Client.field1137, 150 - Client.overheadTextsCyclesRemaining[var18]);
                  }

                  if(Client.field963[var18] == 4) {
                     var26 = (150 - Client.overheadTextsCyclesRemaining[var18]) * (MessageNode.fontBold12.getTextWidth(var32) + 100) / 150;
                     Rasterizer2D.setInnerDrawRegion(var0 + Client.screenX - 50, var1, var0 + Client.screenX + 50, var3 + var1);
                     MessageNode.fontBold12.method5510(var32, var0 + Client.screenX + 50 - var26, Client.screenY + var1, var25, 0);
                     Rasterizer2D.setDrawRegion(var0, var1, var0 + var2, var3 + var1);
                  }

                  if(Client.field963[var18] == 5) {
                     var26 = 150 - Client.overheadTextsCyclesRemaining[var18];
                     int var27 = 0;
                     if(var26 < 25) {
                        var27 = var26 - 25;
                     } else if(var26 > 125) {
                        var27 = var26 - 125;
                     }

                     Rasterizer2D.setInnerDrawRegion(var0, Client.screenY + var1 - MessageNode.fontBold12.verticalSpace - 1, var0 + var2, Client.screenY + var1 + 5);
                     MessageNode.fontBold12.drawTextCentered(var32, var0 + Client.screenX, var27 + Client.screenY + var1, var25, 0);
                     Rasterizer2D.setDrawRegion(var0, var1, var0 + var2, var3 + var1);
                  }
               } else {
                  MessageNode.fontBold12.drawTextCentered(var32, var0 + Client.screenX, Client.screenY + var1, 16776960, 0);
               }
            }

            class38.method546(var0, var1);
            ((TextureProvider)Graphics3D.textureLoader).checkTextures(Client.field930);
            if(Client.field974) {
               if(Client.cursorState == 1) {
                  class248.crossSprites[Client.field972 / 100].drawAt(Client.lastLeftClickX - 8, Client.lastLeftClickY - 8);
               }

               if(Client.cursorState == 2) {
                  class248.crossSprites[Client.field972 / 100 + 4].drawAt(Client.lastLeftClickX - 8, Client.lastLeftClickY - 8);
               }
            }

            class246.method4491();
            Player.cameraX = var5;
            GameObject.cameraZ = var6;
            class20.cameraY = var7;
            GrandExchangeOffer.cameraPitch = var8;
            class28.cameraYaw = var9;
            if(Client.field880) {
               byte var34 = 0;
               var14 = var34 + class264.NetCache_pendingPriorityWritesCount + class264.NetCache_pendingPriorityResponsesCount;
               if(var14 == 0) {
                  Client.field880 = false;
               }
            }

            if(Client.field880) {
               Rasterizer2D.Rasterizer2D_fillRectangle(var0, var1, var2, var3, 0);
               CombatInfo1.method1681("Loading - please wait.", false);
            }

            return;
         }

         var29.vmethod46();
      }
   }

   @ObfuscatedName("gc")
   @ObfuscatedSignature(
      signature = "(Lba;IS)V",
      garbageValue = "482"
   )
   @Export("characterToScreen")
   static final void characterToScreen(Actor var0, int var1) {
      SoundTask.worldToScreen(var0.x, var0.y, var1);
   }
}
