import net.runelite.mapping.Export;
import net.runelite.mapping.Hook;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("s")
final class class3 implements class0 {
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Lik;"
   )
   @Export("NpcDefinition_modelIndexCache")
   static IndexDataBase NpcDefinition_modelIndexCache;
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "[Ldb;"
   )
   @Export("idxFiles")
   public static CacheFile[] idxFiles;
   @ObfuscatedName("bl")
   @ObfuscatedSignature(
      signature = "Lbd;"
   )
   @Export("mouseRecorder")
   static MouseRecorder mouseRecorder;

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1910932518"
   )
   public static void method7() {
      if(KeyFocusListener.keyboard != null) {
         KeyFocusListener var0 = KeyFocusListener.keyboard;
         synchronized(KeyFocusListener.keyboard) {
            KeyFocusListener.keyboard = null;
         }
      }

   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-773099223"
   )
   public static void method9(int var0) {
      if(var0 != -1) {
         if(Widget.validInterfaces[var0]) {
            Widget.widgetIndex.method4380(var0);
            if(FileRequest.widgets[var0] != null) {
               boolean var1 = true;

               for(int var2 = 0; var2 < FileRequest.widgets[var0].length; ++var2) {
                  if(FileRequest.widgets[var0][var2] != null) {
                     if(FileRequest.widgets[var0][var2].type != 2) {
                        FileRequest.widgets[var0][var2] = null;
                     } else {
                        var1 = false;
                     }
                  }
               }

               if(var1) {
                  FileRequest.widgets[var0] = null;
               }

               Widget.validInterfaces[var0] = false;
            }
         }
      }
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Lgd;I)I",
      garbageValue = "-406408320"
   )
   static int method10(PacketBuffer var0) {
      int var1 = var0.getBits(2);
      int var2;
      if(var1 == 0) {
         var2 = 0;
      } else if(var1 == 1) {
         var2 = var0.getBits(5);
      } else if(var1 == 2) {
         var2 = var0.getBits(8);
      } else {
         var2 = var0.getBits(11);
      }

      return var2;
   }

   @ObfuscatedName("gm")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "-851139282"
   )
   static final void method6(int var0, int var1, int var2, int var3) {
      ++Client.field821;
      if(class36.localPlayer.x >> 7 == Client.destinationX && class36.localPlayer.y >> 7 == Client.destinationY) {
         Client.destinationX = 0;
      }

      class19.method165();
      class39.method541();
      BoundingBox2D.method54(true);
      int var4 = class92.playerIndexesCount;
      int[] var5 = class92.playerIndices;

      int var6;
      for(var6 = 0; var6 < var4; ++var6) {
         if(var5[var6] != Client.field935 && var5[var6] != Client.localInteractingIndex) {
            class181.method3381(Client.cachedPlayers[var5[var6]], true);
         }
      }

      BoundingBox2D.method54(false);
      class35.method499();

      for(GraphicsObject var27 = (GraphicsObject)Client.graphicsObjectDeque.getFront(); var27 != null; var27 = (GraphicsObject)Client.graphicsObjectDeque.getNext()) {
         if(var27.level == MessageNode.plane && !var27.finished) {
            if(Client.gameCycle >= var27.startCycle) {
               var27.method1798(Client.field882);
               if(var27.finished) {
                  var27.unlink();
               } else {
                  class48.region.method2822(var27.level, var27.x, var27.y, var27.height, 60, var27, 0, -1, false);
               }
            }
         } else {
            var27.unlink();
         }
      }

      class65.method1069(var0, var1, var2, var3, true);
      var0 = Client.Viewport_xOffset;
      var1 = Client.Viewport_yOffset;
      var2 = Client.viewportWidth;
      var3 = Client.viewportHeight;
      Rasterizer2D.setDrawRegion(var0, var1, var0 + var2, var3 + var1);
      Graphics3D.Rasterizer3D_method1();
      int var28;
      if(!Client.field1051) {
         var4 = Client.field889;
         if(Client.field898 / 256 > var4) {
            var4 = Client.field898 / 256;
         }

         if(Client.field1052[4] && Client.field1054[4] + 128 > var4) {
            var4 = Client.field1054[4] + 128;
         }

         var28 = Client.mapAngle & 2047;
         class44.method626(class43.field535, GameCanvas.getTileHeight(class36.localPlayer.x, class36.localPlayer.y, MessageNode.plane) - Client.field895, FontName.field3729, var4, var28, var4 * 3 + 600);
      }

      if(!Client.field1051) {
         var4 = class28.method256();
      } else {
         var4 = NPCComposition.method4931();
      }

      var28 = Actor.cameraX;
      var6 = class60.cameraZ;
      int var7 = GameCanvas.cameraY;
      int var8 = SceneTilePaint.cameraPitch;
      int var9 = class33.cameraYaw;

      int var10;
      int var11;
      for(var10 = 0; var10 < 5; ++var10) {
         if(Client.field1052[var10]) {
            var11 = (int)(Math.random() * (double)(Client.field908[var10] * 2 + 1) - (double)Client.field908[var10] + Math.sin((double)Client.field1056[var10] * ((double)Client.field1055[var10] / 100.0D)) * (double)Client.field1054[var10]);
            if(var10 == 0) {
               Actor.cameraX += var11;
            }

            if(var10 == 1) {
               class60.cameraZ += var11;
            }

            if(var10 == 2) {
               GameCanvas.cameraY += var11;
            }

            if(var10 == 3) {
               class33.cameraYaw = var11 + class33.cameraYaw & 2047;
            }

            if(var10 == 4) {
               SceneTilePaint.cameraPitch += var11;
               if(SceneTilePaint.cameraPitch < 128) {
                  SceneTilePaint.cameraPitch = 128;
               }

               if(SceneTilePaint.cameraPitch > 383) {
                  SceneTilePaint.cameraPitch = 383;
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

      int var12;
      int var13;
      if(var10 >= var0 && var10 < var0 + var2 && var11 >= var1 && var11 < var3 + var1) {
         var12 = var10 - var0;
         var13 = var11 - var1;
         class131.Viewport_mouseX = var12;
         class131.Viewport_mouseY = var13;
         class131.Viewport_containsMouse = true;
         class131.Viewport_entityCountAtMouse = 0;
         class131.Viewport_false0 = false;
      } else {
         class237.method4337();
      }

      Friend.method5158();
      Rasterizer2D.Rasterizer2D_fillRectangle(var0, var1, var2, var3, 0);
      Friend.method5158();
      var12 = Graphics3D.Rasterizer3D_zoom;
      Graphics3D.Rasterizer3D_zoom = Client.scale;
      class48.region.draw(Actor.cameraX, class60.cameraZ, GameCanvas.cameraY, SceneTilePaint.cameraPitch, class33.cameraYaw, var4);
      Spotanim.method4610();
      Graphics3D.Rasterizer3D_zoom = var12;
      Friend.method5158();
      class48.region.clearEntities();
      Client.overheadTextCount = 0;
      boolean var31 = false;
      int var14 = -1;
      int var15 = class92.playerIndexesCount;
      int[] var16 = class92.playerIndices;

      int var17;
      for(var17 = 0; var17 < var15 + Client.npcIndexesCount; ++var17) {
         Object var18;
         if(var17 < var15) {
            var18 = Client.cachedPlayers[var16[var17]];
            if(var16[var17] == Client.field935) {
               var31 = true;
               var14 = var17;
               continue;
            }
         } else {
            var18 = Client.cachedNPCs[Client.npcIndices[var17 - var15]];
         }

         draw2DExtras((Actor)var18, var17, var0, var1, var2, var3);
      }

      if(var31) {
         draw2DExtras(Client.cachedPlayers[Client.field935], var14, var0, var1, var2, var3);
      }

      for(var17 = 0; var17 < Client.overheadTextCount; ++var17) {
         int var29 = Client.overheadTextsX[var17];
         int var19 = Client.overheadTextsY[var17];
         int var20 = Client.overheadTextsOffsetX[var17];
         int var21 = Client.overheadTextsOffsetY[var17];
         boolean var22 = true;

         while(var22) {
            var22 = false;

            for(int var23 = 0; var23 < var17; ++var23) {
               if(var19 + 2 > Client.overheadTextsY[var23] - Client.overheadTextsOffsetY[var23] && var19 - var21 < Client.overheadTextsY[var23] + 2 && var29 - var20 < Client.overheadTextsX[var23] + Client.overheadTextsOffsetX[var23] && var20 + var29 > Client.overheadTextsX[var23] - Client.overheadTextsOffsetX[var23] && Client.overheadTextsY[var23] - Client.overheadTextsOffsetY[var23] < var19) {
                  var19 = Client.overheadTextsY[var23] - Client.overheadTextsOffsetY[var23];
                  var22 = true;
               }
            }
         }

         Client.screenX = Client.overheadTextsX[var17];
         Client.screenY = Client.overheadTextsY[var17] = var19;
         String var30 = Client.overheadTexts[var17];
         if(Client.field1042 == 0) {
            int var24 = 16776960;
            if(Client.field905[var17] < 6) {
               var24 = Client.field1022[Client.field905[var17]];
            }

            if(Client.field905[var17] == 6) {
               var24 = Client.field821 % 20 < 10?16711680:16776960;
            }

            if(Client.field905[var17] == 7) {
               var24 = Client.field821 % 20 < 10?255:'\uffff';
            }

            if(Client.field905[var17] == 8) {
               var24 = Client.field821 % 20 < 10?'뀀':8454016;
            }

            int var25;
            if(Client.field905[var17] == 9) {
               var25 = 150 - Client.overheadTextsCyclesRemaining[var17];
               if(var25 < 50) {
                  var24 = var25 * 1280 + 16711680;
               } else if(var25 < 100) {
                  var24 = 16776960 - (var25 - 50) * 327680;
               } else if(var25 < 150) {
                  var24 = (var25 - 100) * 5 + 65280;
               }
            }

            if(Client.field905[var17] == 10) {
               var25 = 150 - Client.overheadTextsCyclesRemaining[var17];
               if(var25 < 50) {
                  var24 = var25 * 5 + 16711680;
               } else if(var25 < 100) {
                  var24 = 16711935 - (var25 - 50) * 327680;
               } else if(var25 < 150) {
                  var24 = (var25 - 100) * 327680 + 255 - (var25 - 100) * 5;
               }
            }

            if(Client.field905[var17] == 11) {
               var25 = 150 - Client.overheadTextsCyclesRemaining[var17];
               if(var25 < 50) {
                  var24 = 16777215 - var25 * 327685;
               } else if(var25 < 100) {
                  var24 = (var25 - 50) * 327685 + 65280;
               } else if(var25 < 150) {
                  var24 = 16777215 - (var25 - 100) * 327680;
               }
            }

            if(Client.field887[var17] == 0) {
               ContextMenuRow.fontBold12.drawTextCentered(var30, var0 + Client.screenX, Client.screenY + var1, var24, 0);
            }

            if(Client.field887[var17] == 1) {
               ContextMenuRow.fontBold12.method5218(var30, var0 + Client.screenX, Client.screenY + var1, var24, 0, Client.field821);
            }

            if(Client.field887[var17] == 2) {
               ContextMenuRow.fontBold12.method5219(var30, var0 + Client.screenX, Client.screenY + var1, var24, 0, Client.field821);
            }

            if(Client.field887[var17] == 3) {
               ContextMenuRow.fontBold12.method5220(var30, var0 + Client.screenX, Client.screenY + var1, var24, 0, Client.field821, 150 - Client.overheadTextsCyclesRemaining[var17]);
            }

            if(Client.field887[var17] == 4) {
               var25 = (150 - Client.overheadTextsCyclesRemaining[var17]) * (ContextMenuRow.fontBold12.getTextWidth(var30) + 100) / 150;
               Rasterizer2D.setInnerDrawRegion(var0 + Client.screenX - 50, var1, var0 + Client.screenX + 50, var3 + var1);
               ContextMenuRow.fontBold12.method5225(var30, var0 + Client.screenX + 50 - var25, Client.screenY + var1, var24, 0);
               Rasterizer2D.setDrawRegion(var0, var1, var0 + var2, var3 + var1);
            }

            if(Client.field887[var17] == 5) {
               var25 = 150 - Client.overheadTextsCyclesRemaining[var17];
               int var26 = 0;
               if(var25 < 25) {
                  var26 = var25 - 25;
               } else if(var25 > 125) {
                  var26 = var25 - 125;
               }

               Rasterizer2D.setInnerDrawRegion(var0, Client.screenY + var1 - ContextMenuRow.fontBold12.verticalSpace - 1, var0 + var2, Client.screenY + var1 + 5);
               ContextMenuRow.fontBold12.drawTextCentered(var30, var0 + Client.screenX, var26 + Client.screenY + var1, var24, 0);
               Rasterizer2D.setDrawRegion(var0, var1, var0 + var2, var3 + var1);
            }
         } else {
            ContextMenuRow.fontBold12.drawTextCentered(var30, var0 + Client.screenX, Client.screenY + var1, 16776960, 0);
         }
      }

      class2.method5(var0, var1);
      ((TextureProvider)Graphics3D.textureLoader).checkTextures(Client.field882);
      if(Client.cursorState == 1) {
         class39.crossSprites[Client.field871 / 100].drawAt(Client.lastLeftClickX - 8, Client.lastLeftClickY - 8);
      }

      if(Client.cursorState == 2) {
         class39.crossSprites[Client.field871 / 100 + 4].drawAt(Client.lastLeftClickX - 8, Client.lastLeftClickY - 8);
      }

      Client.myPlayerIndex = 0;
      var13 = (class36.localPlayer.x >> 7) + WorldMapType1.baseX;
      var14 = (class36.localPlayer.y >> 7) + class85.baseY;
      if(var13 >= 3053 && var13 <= 3156 && var14 >= 3056 && var14 <= 3136) {
         Client.myPlayerIndex = 1;
      }

      if(var13 >= 3072 && var13 <= 3118 && var14 >= 9492 && var14 <= 9535) {
         Client.myPlayerIndex = 1;
      }

      if(Client.myPlayerIndex == 1 && var13 >= 3139 && var13 <= 3199 && var14 >= 3008 && var14 <= 3062) {
         Client.myPlayerIndex = 0;
      }

      Actor.cameraX = var28;
      class60.cameraZ = var6;
      GameCanvas.cameraY = var7;
      SceneTilePaint.cameraPitch = var8;
      class33.cameraYaw = var9;
      if(Client.field830 && class239.method4340(true, false) == 0) {
         Client.field830 = false;
      }

      if(Client.field830) {
         Rasterizer2D.Rasterizer2D_fillRectangle(var0, var1, var2, var3, 0);
         ScriptEvent.drawStatusBox("Loading - please wait.", false);
      }

   }

   @ObfuscatedName("hp")
   @ObfuscatedSignature(
      signature = "(Lbx;IIIIIB)V",
      garbageValue = "0"
   )
   @Export("draw2DExtras")
   static final void draw2DExtras(Actor var0, int var1, int var2, int var3, int var4, int var5) {
      if(var0 != null && var0.hasConfig()) {
         if(var0 instanceof NPC) {
            NPCComposition var6 = ((NPC)var0).composition;
            if(var6.configs != null) {
               var6 = var6.transform();
            }

            if(var6 == null) {
               return;
            }
         }

         int var74 = class92.playerIndexesCount;
         int[] var7 = class92.playerIndices;
         int var8 = 3;
         int var14;
         int var21;
         int var22;
         if(!var0.combatInfoList.isEmpty()) {
            class47.characterToScreen(var0, var0.logicalHeight + 15);

            for(CombatInfoListHolder var9 = (CombatInfoListHolder)var0.combatInfoList.last(); var9 != null; var9 = (CombatInfoListHolder)var0.combatInfoList.previous()) {
               CombatInfo1 var10 = var9.method1810(Client.gameCycle);
               if(var10 == null) {
                  if(var9.method1809()) {
                     var9.unlink();
                  }
               } else {
                  CombatInfo2 var11 = var9.combatInfo2;
                  SpritePixels var12 = var11.method4669();
                  SpritePixels var13 = var11.method4657();
                  int var15 = 0;
                  if(var12 != null && var13 != null) {
                     if(var11.field3433 * 2 < var13.width) {
                        var15 = var11.field3433;
                     }

                     var14 = var13.width - var15 * 2;
                  } else {
                     var14 = var11.healthScale;
                  }

                  int var16 = 255;
                  boolean var17 = true;
                  int var18 = Client.gameCycle - var10.cycle;
                  int var19 = var14 * var10.health / var11.healthScale;
                  int var20;
                  int var88;
                  if(var10.int2 > var18) {
                     var20 = var11.field3428 == 0?0:var11.field3428 * (var18 / var11.field3428);
                     var21 = var14 * var10.healthRatio / var11.healthScale;
                     var88 = var20 * (var19 - var21) / var10.int2 + var21;
                  } else {
                     var88 = var19;
                     var20 = var11.field3429 + var10.int2 - var18;
                     if(var11.field3427 >= 0) {
                        var16 = (var20 << 8) / (var11.field3429 - var11.field3427);
                     }
                  }

                  if(var10.health > 0 && var88 < 1) {
                     var88 = 1;
                  }

                  var20 = var2 + Client.screenX - (var14 >> 1);
                  var21 = var3 + Client.screenY - var8;
                  if(var12 != null && var13 != null) {
                     var20 -= var15;
                     if(var88 == var14) {
                        var88 += var15 * 2;
                     } else {
                        var88 += var15;
                     }

                     var22 = var12.height;
                     var8 += var22;
                     if(var16 >= 0 && var16 < 255) {
                        var12.drawAtOpacity(var20, var21, var16);
                        Rasterizer2D.setInnerDrawRegion(var20, var21, var20 + var88, var22 + var21);
                        var13.drawAtOpacity(var20, var21, var16);
                     } else {
                        var12.drawAt(var20, var21);
                        Rasterizer2D.setInnerDrawRegion(var20, var21, var20 + var88, var22 + var21);
                        var13.drawAt(var20, var21);
                     }

                     Rasterizer2D.setDrawRegion(var2, var3, var2 + var4, var3 + var5);
                     var8 += 2;
                  } else {
                     if(Client.screenX > -1) {
                        Rasterizer2D.Rasterizer2D_fillRectangle(var20, var21, var88, 5, 65280);
                        Rasterizer2D.Rasterizer2D_fillRectangle(var88 + var20, var21, var14 - var88, 5, 16711680);
                     }

                     var8 += 7;
                  }
               }
            }
         }

         if(var8 < 30) {
            var8 = 30;
         }

         if(var1 < var74) {
            Player var85 = (Player)var0;
            if(var85.hidden) {
               return;
            }

            if(var85.skullIcon != -1 || var85.overheadIcon != -1) {
               class47.characterToScreen(var0, var0.logicalHeight + 15);
               if(Client.screenX > -1) {
                  if(var85.skullIcon != -1) {
                     GrandExchangeOffer.headIconsPk[var85.skullIcon].drawAt(var2 + Client.screenX - 12, var3 + Client.screenY - var8);
                     var8 += 25;
                  }

                  if(var85.overheadIcon != -1) {
                     Player.headIconsPrayer[var85.overheadIcon].drawAt(var2 + Client.screenX - 12, var3 + Client.screenY - var8);
                     var8 += 25;
                  }
               }
            }

            if(var1 >= 0 && Client.hintArrowTargetType == 10 && var7[var1] == Client.hintArrowPlayerTargetIdx) {
               class47.characterToScreen(var0, var0.logicalHeight + 15);
               if(Client.screenX > -1) {
                  GrandExchangeEvent.headIconsHint[1].drawAt(var2 + Client.screenX - 12, var3 + Client.screenY - var8);
               }
            }
         } else {
            NPCComposition var86 = ((NPC)var0).composition;
            if(var86.configs != null) {
               var86 = var86.transform();
            }

            if(var86.field3633 >= 0 && var86.field3633 < Player.headIconsPrayer.length) {
               class47.characterToScreen(var0, var0.logicalHeight + 15);
               if(Client.screenX > -1) {
                  Player.headIconsPrayer[var86.field3633].drawAt(var2 + Client.screenX - 12, var3 + Client.screenY - 30);
               }
            }

            if(Client.hintArrowTargetType == 1 && Client.npcIndices[var1 - var74] == Client.hintArrowNpcTargetIdx && Client.gameCycle % 20 < 10) {
               class47.characterToScreen(var0, var0.logicalHeight + 15);
               if(Client.screenX > -1) {
                  GrandExchangeEvent.headIconsHint[0].drawAt(var2 + Client.screenX - 12, var3 + Client.screenY - 28);
               }
            }
         }

         if(var0.overhead != null && (var1 >= var74 || !var0.inSequence && (Client.publicChatMode == 4 || !var0.field1103 && (Client.publicChatMode == 0 || Client.publicChatMode == 3 || Client.publicChatMode == 1 && ((Player)var0).isFriend())))) {
            class47.characterToScreen(var0, var0.logicalHeight);
            if(Client.screenX > -1 && Client.overheadTextCount < Client.maxOverheadTexts) {
               Client.overheadTextsOffsetX[Client.overheadTextCount] = ContextMenuRow.fontBold12.getTextWidth(var0.overhead) / 2;
               Client.overheadTextsOffsetY[Client.overheadTextCount] = ContextMenuRow.fontBold12.verticalSpace;
               Client.overheadTextsX[Client.overheadTextCount] = Client.screenX;
               Client.overheadTextsY[Client.overheadTextCount] = Client.screenY;
               Client.field905[Client.overheadTextCount] = var0.field1114;
               Client.field887[Client.overheadTextCount] = var0.field1115;
               Client.overheadTextsCyclesRemaining[Client.overheadTextCount] = var0.overheadTextCyclesRemaining;
               Client.overheadTexts[Client.overheadTextCount] = var0.overhead;
               ++Client.overheadTextCount;
            }
         }

         for(int var75 = 0; var75 < 4; ++var75) {
            int var76 = var0.hitsplatCycles[var75];
            int var77 = var0.field1111[var75];
            class265 var87 = null;
            int var78 = 0;
            if(var77 >= 0) {
               if(var76 <= Client.gameCycle) {
                  continue;
               }

               var87 = class163.method3219(var0.field1111[var75]);
               var78 = var87.field3487;
               if(var87 != null && var87.field3491 != null) {
                  var87 = var87.method4773();
                  if(var87 == null) {
                     var0.hitsplatCycles[var75] = -1;
                     continue;
                  }
               }
            } else if(var76 < 0) {
               continue;
            }

            var14 = var0.field1137[var75];
            class265 var79 = null;
            if(var14 >= 0) {
               var79 = class163.method3219(var14);
               if(var79 != null && var79.field3491 != null) {
                  var79 = var79.method4773();
               }
            }

            if(var76 - var78 <= Client.gameCycle) {
               if(var87 == null) {
                  var0.hitsplatCycles[var75] = -1;
               } else {
                  class47.characterToScreen(var0, var0.logicalHeight / 2);
                  if(Client.screenX > -1) {
                     if(var75 == 1) {
                        Client.screenY -= 20;
                     }

                     if(var75 == 2) {
                        Client.screenX -= 15;
                        Client.screenY -= 10;
                     }

                     if(var75 == 3) {
                        Client.screenX += 15;
                        Client.screenY -= 10;
                     }

                     SpritePixels var80 = null;
                     SpritePixels var81 = null;
                     SpritePixels var82 = null;
                     SpritePixels var83 = null;
                     var21 = 0;
                     var22 = 0;
                     int var23 = 0;
                     int var24 = 0;
                     int var25 = 0;
                     int var26 = 0;
                     int var27 = 0;
                     int var28 = 0;
                     SpritePixels var29 = null;
                     SpritePixels var30 = null;
                     SpritePixels var31 = null;
                     SpritePixels var32 = null;
                     int var33 = 0;
                     int var34 = 0;
                     int var35 = 0;
                     int var36 = 0;
                     int var37 = 0;
                     int var38 = 0;
                     int var39 = 0;
                     int var40 = 0;
                     int var41 = 0;
                     var80 = var87.method4764();
                     int var42;
                     if(var80 != null) {
                        var21 = var80.width;
                        var42 = var80.height;
                        if(var42 > var41) {
                           var41 = var42;
                        }

                        var25 = var80.offsetX;
                     }

                     var81 = var87.method4743();
                     if(var81 != null) {
                        var22 = var81.width;
                        var42 = var81.height;
                        if(var42 > var41) {
                           var41 = var42;
                        }

                        var26 = var81.offsetX;
                     }

                     var82 = var87.method4738();
                     if(var82 != null) {
                        var23 = var82.width;
                        var42 = var82.height;
                        if(var42 > var41) {
                           var41 = var42;
                        }

                        var27 = var82.offsetX;
                     }

                     var83 = var87.method4745();
                     if(var83 != null) {
                        var24 = var83.width;
                        var42 = var83.height;
                        if(var42 > var41) {
                           var41 = var42;
                        }

                        var28 = var83.offsetX;
                     }

                     if(var79 != null) {
                        var29 = var79.method4764();
                        if(var29 != null) {
                           var33 = var29.width;
                           var42 = var29.height;
                           if(var42 > var41) {
                              var41 = var42;
                           }

                           var37 = var29.offsetX;
                        }

                        var30 = var79.method4743();
                        if(var30 != null) {
                           var34 = var30.width;
                           var42 = var30.height;
                           if(var42 > var41) {
                              var41 = var42;
                           }

                           var38 = var30.offsetX;
                        }

                        var31 = var79.method4738();
                        if(var31 != null) {
                           var35 = var31.width;
                           var42 = var31.height;
                           if(var42 > var41) {
                              var41 = var42;
                           }

                           var39 = var31.offsetX;
                        }

                        var32 = var79.method4745();
                        if(var32 != null) {
                           var36 = var32.width;
                           var42 = var32.height;
                           if(var42 > var41) {
                              var41 = var42;
                           }

                           var40 = var32.offsetX;
                        }
                     }

                     Font var84 = var87.method4746();
                     if(var84 == null) {
                        var84 = GrandExchangeOffer.fontPlain11;
                     }

                     Font var43;
                     if(var79 != null) {
                        var43 = var79.method4746();
                        if(var43 == null) {
                           var43 = GrandExchangeOffer.fontPlain11;
                        }
                     } else {
                        var43 = GrandExchangeOffer.fontPlain11;
                     }

                     String var44 = null;
                     String var45 = null;
                     boolean var46 = false;
                     int var47 = 0;
                     var44 = var87.method4759(var0.hitsplatTypes[var75]);
                     int var89 = var84.getTextWidth(var44);
                     if(var79 != null) {
                        var45 = var79.method4759(var0.field1121[var75]);
                        var47 = var43.getTextWidth(var45);
                     }

                     int var48 = 0;
                     int var49 = 0;
                     if(var22 > 0) {
                        if(var82 == null && var83 == null) {
                           var48 = 1;
                        } else {
                           var48 = var89 / var22 + 1;
                        }
                     }

                     if(var79 != null && var34 > 0) {
                        if(var31 == null && var32 == null) {
                           var49 = 1;
                        } else {
                           var49 = var47 / var34 + 1;
                        }
                     }

                     int var50 = 0;
                     int var51 = var50;
                     if(var21 > 0) {
                        var50 += var21;
                     }

                     var50 += 2;
                     int var52 = var50;
                     if(var23 > 0) {
                        var50 += var23;
                     }

                     int var53 = var50;
                     int var54 = var50;
                     int var55;
                     if(var22 > 0) {
                        var55 = var48 * var22;
                        var50 += var55;
                        var54 += (var55 - var89) / 2;
                     } else {
                        var50 += var89;
                     }

                     var55 = var50;
                     if(var24 > 0) {
                        var50 += var24;
                     }

                     int var56 = 0;
                     int var57 = 0;
                     int var58 = 0;
                     int var59 = 0;
                     int var60 = 0;
                     int var61;
                     if(var79 != null) {
                        var50 += 2;
                        var56 = var50;
                        if(var33 > 0) {
                           var50 += var33;
                        }

                        var50 += 2;
                        var57 = var50;
                        if(var35 > 0) {
                           var50 += var35;
                        }

                        var58 = var50;
                        var60 = var50;
                        if(var34 > 0) {
                           var61 = var49 * var34;
                           var50 += var61;
                           var60 += (var61 - var47) / 2;
                        } else {
                           var50 += var47;
                        }

                        var59 = var50;
                        if(var36 > 0) {
                           var50 += var36;
                        }
                     }

                     var61 = var0.hitsplatCycles[var75] - Client.gameCycle;
                     int var62 = var87.field3485 - var61 * var87.field3485 / var87.field3487;
                     int var63 = var61 * var87.field3470 / var87.field3487 + -var87.field3470;
                     int var64 = var62 + (var2 + Client.screenX - (var50 >> 1));
                     int var65 = var63 + (var3 + Client.screenY - 12);
                     int var66 = var65;
                     int var67 = var65 + var41;
                     int var68 = var65 + var87.field3472 + 15;
                     int var69 = var68 - var84.minSpacing;
                     int var70 = var68 + var84.maxSpacing;
                     if(var69 < var65) {
                        var66 = var69;
                     }

                     if(var70 > var67) {
                        var67 = var70;
                     }

                     int var71 = 0;
                     int var72;
                     int var73;
                     if(var79 != null) {
                        var71 = var65 + var79.field3472 + 15;
                        var72 = var71 - var43.minSpacing;
                        var73 = var71 + var43.maxSpacing;
                        if(var72 < var66) {
                           ;
                        }

                        if(var73 > var67) {
                           ;
                        }
                     }

                     var72 = 255;
                     if(var87.field3481 >= 0) {
                        var72 = (var61 << 8) / (var87.field3487 - var87.field3481);
                     }

                     if(var72 >= 0 && var72 < 255) {
                        if(var80 != null) {
                           var80.drawAtOpacity(var64 + var51 - var25, var65, var72);
                        }

                        if(var82 != null) {
                           var82.drawAtOpacity(var64 + var52 - var27, var65, var72);
                        }

                        if(var81 != null) {
                           for(var73 = 0; var73 < var48; ++var73) {
                              var81.drawAtOpacity(var73 * var22 + (var64 + var53 - var26), var65, var72);
                           }
                        }

                        if(var83 != null) {
                           var83.drawAtOpacity(var55 + var64 - var28, var65, var72);
                        }

                        var84.method5214(var44, var54 + var64, var68, var87.field3483, 0, var72);
                        if(var79 != null) {
                           if(var29 != null) {
                              var29.drawAtOpacity(var64 + var56 - var37, var65, var72);
                           }

                           if(var31 != null) {
                              var31.drawAtOpacity(var57 + var64 - var39, var65, var72);
                           }

                           if(var30 != null) {
                              for(var73 = 0; var73 < var49; ++var73) {
                                 var30.drawAtOpacity(var73 * var34 + (var58 + var64 - var38), var65, var72);
                              }
                           }

                           if(var32 != null) {
                              var32.drawAtOpacity(var59 + var64 - var40, var65, var72);
                           }

                           var43.method5214(var45, var64 + var60, var71, var79.field3483, 0, var72);
                        }
                     } else {
                        if(var80 != null) {
                           var80.drawAt(var51 + var64 - var25, var65);
                        }

                        if(var82 != null) {
                           var82.drawAt(var52 + var64 - var27, var65);
                        }

                        if(var81 != null) {
                           for(var73 = 0; var73 < var48; ++var73) {
                              var81.drawAt(var73 * var22 + (var64 + var53 - var26), var65);
                           }
                        }

                        if(var83 != null) {
                           var83.drawAt(var64 + var55 - var28, var65);
                        }

                        var84.method5225(var44, var64 + var54, var68, var87.field3483 | -16777216, 0);
                        if(var79 != null) {
                           if(var29 != null) {
                              var29.drawAt(var56 + var64 - var37, var65);
                           }

                           if(var31 != null) {
                              var31.drawAt(var57 + var64 - var39, var65);
                           }

                           if(var30 != null) {
                              for(var73 = 0; var73 < var49; ++var73) {
                                 var30.drawAt(var73 * var34 + (var64 + var58 - var38), var65);
                              }
                           }

                           if(var32 != null) {
                              var32.drawAt(var59 + var64 - var40, var65);
                           }

                           var43.method5225(var45, var64 + var60, var71, var79.field3483 | -16777216, 0);
                        }
                     }
                  }
               }
            }
         }

      }
   }

   @ObfuscatedName("ik")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;IIIIB)V",
      garbageValue = "76"
   )
   @Export("addMenuEntry")
   @Hook("addMenuEntry")
   public static final void addMenuEntry(String var0, String var1, int var2, int var3, int var4, int var5) {
      Parameters.method5333(var0, var1, var2, var3, var4, var5, false);
   }
}
