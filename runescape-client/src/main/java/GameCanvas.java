import java.awt.Canvas;
import java.awt.Component;
import java.awt.Graphics;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bl")
@Implements("GameCanvas")
public final class GameCanvas extends Canvas {
   @ObfuscatedName("dx")
   @ObfuscatedSignature(
      signature = "Ljn;"
   )
   @Export("indexTextures")
   static IndexData indexTextures;
   @ObfuscatedName("o")
   @Export("component")
   Component component;

   GameCanvas(Component var1) {
      this.component = var1;
   }

   public final void paint(Graphics var1) {
      this.component.paint(var1);
   }

   public final void update(Graphics var1) {
      this.component.update(var1);
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(II)Lja;",
      garbageValue = "455009002"
   )
   @Export("getObjectDefinition")
   public static ObjectComposition getObjectDefinition(int var0) {
      ObjectComposition var1 = (ObjectComposition)ObjectComposition.objects.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = ObjectComposition.objects_ref.getConfigData(6, var0);
         var1 = new ObjectComposition();
         var1.id = var0;
         if(var2 != null) {
            var1.decode(new Buffer(var2));
         }

         var1.post();
         if(var1.isHollow) {
            var1.clipType = 0;
            var1.blocksProjectile = false;
         }

         ObjectComposition.objects.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("ff")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "14"
   )
   static void method832(int var0) {
      Client.field1080 = 0L;
      if(var0 >= 2) {
         Client.isResized = true;
      } else {
         Client.isResized = false;
      }

      int var1 = Client.isResized?2:1;
      if(var1 == 1) {
         class23.clientInstance.method894(765, 503);
      } else {
         class23.clientInstance.method894(7680, 2160);
      }

      if(Client.gameState >= 25) {
         class61.method1070();
      }

   }

   @ObfuscatedName("gk")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1910225768"
   )
   static final int method831() {
      if(Client.preferences.hideRoofs) {
         return BoundingBox3DDrawMode.plane;
      } else {
         int var0 = class265.getTileHeight(Player.cameraX, class20.cameraY, BoundingBox3DDrawMode.plane);
         return var0 - GameObject.cameraZ < 800 && (class62.tileSettings[BoundingBox3DDrawMode.plane][Player.cameraX >> 7][class20.cameraY >> 7] & 4) != 0?BoundingBox3DDrawMode.plane:3;
      }
   }

   @ObfuscatedName("hf")
   @ObfuscatedSignature(
      signature = "(IIIIB)V",
      garbageValue = "81"
   )
   static final void method833(int var0, int var1, int var2, int var3) {
      if(Client.itemSelectionState == 0 && !Client.spellSelected) {
         TextureProvider.addMenuEntry("Walk here", "", 23, 0, var0 - var2, var1 - var3);
      }

      int var4 = -1;
      int var5 = -1;

      int var6;
      int var7;
      for(var6 = 0; var6 < class132.Viewport_entityCountAtMouse; ++var6) {
         var7 = class132.Viewport_entityIdsAtMouse[var6];
         int var8 = var7 & 127;
         int var9 = var7 >> 7 & 127;
         int var10 = var7 >> 29 & 3;
         int var11 = var7 >> 14 & 32767;
         if(var7 != var5) {
            var5 = var7;
            if(var10 == 2 && class255.region.getObjectFlags(BoundingBox3DDrawMode.plane, var8, var9, var7) >= 0) {
               ObjectComposition var12 = getObjectDefinition(var11);
               if(var12.impostorIds != null) {
                  var12 = var12.getImpostor();
               }

               if(var12 == null) {
                  continue;
               }

               if(Client.itemSelectionState == 1) {
                  TextureProvider.addMenuEntry("Use", Client.lastSelectedItemName + " " + "->" + " " + class45.getColTags(65535) + var12.name, 1, var7, var8, var9);
               } else if(Client.spellSelected) {
                  if((class110.field1607 & 4) == 4) {
                     TextureProvider.addMenuEntry(Client.field1092, Client.field1028 + " " + "->" + " " + class45.getColTags(65535) + var12.name, 2, var7, var8, var9);
                  }
               } else {
                  String[] var19 = var12.actions;
                  if(var19 != null) {
                     for(int var20 = 4; var20 >= 0; --var20) {
                        if(var19[var20] != null) {
                           short var15 = 0;
                           if(var20 == 0) {
                              var15 = 3;
                           }

                           if(var20 == 1) {
                              var15 = 4;
                           }

                           if(var20 == 2) {
                              var15 = 5;
                           }

                           if(var20 == 3) {
                              var15 = 6;
                           }

                           if(var20 == 4) {
                              var15 = 1001;
                           }

                           TextureProvider.addMenuEntry(var19[var20], class45.getColTags(65535) + var12.name, var15, var7, var8, var9);
                        }
                     }
                  }

                  TextureProvider.addMenuEntry("Examine", class45.getColTags(65535) + var12.name, 1002, var12.id << 14, var8, var9);
               }
            }

            int var13;
            NPC var14;
            Player var16;
            int[] var26;
            int var28;
            if(var10 == 1) {
               NPC var23 = Client.cachedNPCs[var11];
               if(var23 == null) {
                  continue;
               }

               if(var23.composition.field3720 == 1 && (var23.x & 127) == 64 && (var23.y & 127) == 64) {
                  for(var13 = 0; var13 < Client.npcIndexesCount; ++var13) {
                     var14 = Client.cachedNPCs[Client.npcIndices[var13]];
                     if(var14 != null && var23 != var14 && var14.composition.field3720 == 1 && var23.x == var14.x && var14.y == var23.y) {
                        KeyFocusListener.method811(var14.composition, Client.npcIndices[var13], var8, var9);
                     }
                  }

                  var13 = class93.playerIndexesCount;
                  var26 = class93.playerIndices;

                  for(var28 = 0; var28 < var13; ++var28) {
                     var16 = Client.cachedPlayers[var26[var28]];
                     if(var16 != null && var16.x == var23.x && var16.y == var23.y) {
                        Signlink.method3241(var16, var26[var28], var8, var9);
                     }
                  }
               }

               KeyFocusListener.method811(var23.composition, var11, var8, var9);
            }

            if(var10 == 0) {
               Player var24 = Client.cachedPlayers[var11];
               if(var24 == null) {
                  continue;
               }

               if((var24.x & 127) == 64 && (var24.y & 127) == 64) {
                  for(var13 = 0; var13 < Client.npcIndexesCount; ++var13) {
                     var14 = Client.cachedNPCs[Client.npcIndices[var13]];
                     if(var14 != null && var14.composition.field3720 == 1 && var14.x == var24.x && var14.y == var24.y) {
                        KeyFocusListener.method811(var14.composition, Client.npcIndices[var13], var8, var9);
                     }
                  }

                  var13 = class93.playerIndexesCount;
                  var26 = class93.playerIndices;

                  for(var28 = 0; var28 < var13; ++var28) {
                     var16 = Client.cachedPlayers[var26[var28]];
                     if(var16 != null && var24 != var16 && var24.x == var16.x && var24.y == var16.y) {
                        Signlink.method3241(var16, var26[var28], var8, var9);
                     }
                  }
               }

               if(var11 != Client.field1112) {
                  Signlink.method3241(var24, var11, var8, var9);
               } else {
                  var4 = var7;
               }
            }

            if(var10 == 3) {
               Deque var25 = Client.groundItemDeque[BoundingBox3DDrawMode.plane][var8][var9];
               if(var25 != null) {
                  for(Item var29 = (Item)var25.getTail(); var29 != null; var29 = (Item)var25.getPrevious()) {
                     ItemComposition var27 = class47.getItemDefinition(var29.id);
                     if(Client.itemSelectionState == 1) {
                        TextureProvider.addMenuEntry("Use", Client.lastSelectedItemName + " " + "->" + " " + class45.getColTags(16748608) + var27.name, 16, var29.id, var8, var9);
                     } else if(Client.spellSelected) {
                        if((class110.field1607 & 1) == 1) {
                           TextureProvider.addMenuEntry(Client.field1092, Client.field1028 + " " + "->" + " " + class45.getColTags(16748608) + var27.name, 17, var29.id, var8, var9);
                        }
                     } else {
                        String[] var21 = var27.groundActions;

                        for(int var22 = 4; var22 >= 0; --var22) {
                           if(var21 != null && var21[var22] != null) {
                              byte var17 = 0;
                              if(var22 == 0) {
                                 var17 = 18;
                              }

                              if(var22 == 1) {
                                 var17 = 19;
                              }

                              if(var22 == 2) {
                                 var17 = 20;
                              }

                              if(var22 == 3) {
                                 var17 = 21;
                              }

                              if(var22 == 4) {
                                 var17 = 22;
                              }

                              TextureProvider.addMenuEntry(var21[var22], class45.getColTags(16748608) + var27.name, var17, var29.id, var8, var9);
                           } else if(var22 == 2) {
                              TextureProvider.addMenuEntry("Take", class45.getColTags(16748608) + var27.name, 20, var29.id, var8, var9);
                           }
                        }

                        TextureProvider.addMenuEntry("Examine", class45.getColTags(16748608) + var27.name, 1004, var29.id, var8, var9);
                     }
                  }
               }
            }
         }
      }

      if(var4 != -1) {
         var6 = var4 & 127;
         var7 = var4 >> 7 & 127;
         Player var18 = Client.cachedPlayers[Client.field1112];
         Signlink.method3241(var18, Client.field1112, var6, var7);
      }

   }

   @ObfuscatedName("iw")
   @ObfuscatedSignature(
      signature = "([Lin;IIIIIIIII)V",
      garbageValue = "1832587292"
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

            if(var10.contentType > 0) {
               class88.method1894(var10);
            }

            int var39 = var10.relativeX + var6;
            int var13 = var7 + var10.relativeY;
            int var14 = var10.opacity;
            int var15;
            int var16;
            if(var10 == Client.draggedWidget) {
               if(var1 != -1412584499 && !var10.dragRenderBehavior) {
                  class66.field785 = var0;
                  CombatInfoListHolder.field1310 = var6;
                  GrandExchangeEvent.field300 = var7;
                  continue;
               }

               if(Client.draggingWidget && Client.field1053) {
                  var15 = MouseInput.mouseLastX;
                  var16 = MouseInput.mouseLastY;
                  var15 -= Client.field1042;
                  var16 -= Client.field1114;
                  if(var15 < Client.field1008) {
                     var15 = Client.field1008;
                  }

                  if(var15 + var10.width > Client.field1008 + Client.field937.width) {
                     var15 = Client.field1008 + Client.field937.width - var10.width;
                  }

                  if(var16 < Client.field1047) {
                     var16 = Client.field1047;
                  }

                  if(var16 + var10.height > Client.field1047 + Client.field937.height) {
                     var16 = Client.field1047 + Client.field937.height - var10.height;
                  }

                  var39 = var15;
                  var13 = var16;
               }

               if(!var10.dragRenderBehavior) {
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
                        class20.font_p12full.method5512("Fps:" + GameEngine.FPS, var39 + var10.width, var13, 16776960, -1);
                        var13 += 15;
                        Runtime var43 = Runtime.getRuntime();
                        var20 = (int)((var43.totalMemory() - var43.freeMemory()) / 1024L);
                        var21 = 16776960;
                        if(var20 > 327680 && !Client.lowMemory) {
                           var21 = 16711680;
                        }

                        class20.font_p12full.method5512("Mem:" + var20 + "k", var39 + var10.width, var13, var21, -1);
                        var13 += 15;
                     }
                     continue;
                  }

                  if(var10.contentType == 1337) {
                     Client.field991 = var39;
                     Client.field1019 = var13;
                     WorldMapDecoration.method314(var39, var13, var10.width, var10.height);
                     Client.field1072[var10.boundsIndex] = true;
                     Rasterizer2D.setDrawRegion(var2, var3, var4, var5);
                     continue;
                  }

                  if(var10.contentType == 1338) {
                     BoundingBox2D.method36();
                     class236 var42 = var10.method4425(false);
                     if(var42 != null) {
                        Rasterizer2D.setDrawRegion(var39, var13, var39 + var42.field2773, var13 + var42.field2772);
                        if(Client.field1099 != 2 && Client.field1099 != 5) {
                           var20 = Client.mapAngle & 2047;
                           var21 = SoundTaskDataProvider.localPlayer.x / 32 + 48;
                           var22 = 464 - SoundTaskDataProvider.localPlayer.y / 32;
                           BoundingBox2D.minimapSprite.method5875(var39, var13, var42.field2773, var42.field2772, var21, var22, var20, 256, var42.field2774, var42.field2771);

                           for(var23 = 0; var23 < Client.field1093; ++var23) {
                              var24 = Client.field1094[var23] * 4 + 2 - SoundTaskDataProvider.localPlayer.x / 32;
                              var25 = Client.field1095[var23] * 4 + 2 - SoundTaskDataProvider.localPlayer.y / 32;
                              class38.drawDot(var39, var13, var24, var25, Client.mapIcons[var23], var42);
                           }

                           var23 = 0;

                           while(true) {
                              if(var23 >= 104) {
                                 for(var23 = 0; var23 < Client.npcIndexesCount; ++var23) {
                                    NPC var50 = Client.cachedNPCs[Client.npcIndices[var23]];
                                    if(var50 != null && var50.hasConfig()) {
                                       NPCComposition var55 = var50.composition;
                                       if(var55 != null && var55.configs != null) {
                                          var55 = var55.transform();
                                       }

                                       if(var55 != null && var55.isMinimapVisible && var55.field3724) {
                                          var26 = var50.x / 32 - SoundTaskDataProvider.localPlayer.x / 32;
                                          var27 = var50.y / 32 - SoundTaskDataProvider.localPlayer.y / 32;
                                          class38.drawDot(var39, var13, var26, var27, class49.mapDots[1], var42);
                                       }
                                    }
                                 }

                                 var23 = class93.playerIndexesCount;
                                 int[] var51 = class93.playerIndices;

                                 for(var25 = 0; var25 < var23; ++var25) {
                                    Player var37 = Client.cachedPlayers[var51[var25]];
                                    if(var37 != null && var37.hasConfig() && !var37.hidden && var37 != SoundTaskDataProvider.localPlayer) {
                                       var27 = var37.x / 32 - SoundTaskDataProvider.localPlayer.x / 32;
                                       int var38 = var37.y / 32 - SoundTaskDataProvider.localPlayer.y / 32;
                                       boolean var48 = false;
                                       if(SoundTaskDataProvider.localPlayer.team != 0 && var37.team != 0 && var37.team == SoundTaskDataProvider.localPlayer.team) {
                                          var48 = true;
                                       }

                                       if(var37.isFriend()) {
                                          class38.drawDot(var39, var13, var27, var38, class49.mapDots[3], var42);
                                       } else if(var48) {
                                          class38.drawDot(var39, var13, var27, var38, class49.mapDots[4], var42);
                                       } else if(var37.isClanMember()) {
                                          class38.drawDot(var39, var13, var27, var38, class49.mapDots[5], var42);
                                       } else {
                                          class38.drawDot(var39, var13, var27, var38, class49.mapDots[2], var42);
                                       }
                                    }
                                 }

                                 if(Client.hintArrowTargetType != 0 && Client.gameCycle % 20 < 10) {
                                    if(Client.hintArrowTargetType == 1 && Client.hintArrowNpcTargetIdx >= 0 && Client.hintArrowNpcTargetIdx < Client.cachedNPCs.length) {
                                       NPC var57 = Client.cachedNPCs[Client.hintArrowNpcTargetIdx];
                                       if(var57 != null) {
                                          var26 = var57.x / 32 - SoundTaskDataProvider.localPlayer.x / 32;
                                          var27 = var57.y / 32 - SoundTaskDataProvider.localPlayer.y / 32;
                                          FrameMap.worldToMinimap(var39, var13, var26, var27, class19.mapMarkers[1], var42);
                                       }
                                    }

                                    if(Client.hintArrowTargetType == 2) {
                                       var25 = Client.hintArrowX * 4 - class138.baseX * 4 + 2 - SoundTaskDataProvider.localPlayer.x / 32;
                                       var26 = Client.hintArrowY * 4 - class23.baseY * 4 + 2 - SoundTaskDataProvider.localPlayer.y / 32;
                                       FrameMap.worldToMinimap(var39, var13, var25, var26, class19.mapMarkers[1], var42);
                                    }

                                    if(Client.hintArrowTargetType == 10 && Client.hintArrowPlayerTargetIdx >= 0 && Client.hintArrowPlayerTargetIdx < Client.cachedPlayers.length) {
                                       Player var58 = Client.cachedPlayers[Client.hintArrowPlayerTargetIdx];
                                       if(var58 != null) {
                                          var26 = var58.x / 32 - SoundTaskDataProvider.localPlayer.x / 32;
                                          var27 = var58.y / 32 - SoundTaskDataProvider.localPlayer.y / 32;
                                          FrameMap.worldToMinimap(var39, var13, var26, var27, class19.mapMarkers[1], var42);
                                       }
                                    }
                                 }

                                 if(Client.destinationX != 0) {
                                    var25 = Client.destinationX * 4 + 2 - SoundTaskDataProvider.localPlayer.x / 32;
                                    var26 = Client.destinationY * 4 + 2 - SoundTaskDataProvider.localPlayer.y / 32;
                                    class38.drawDot(var39, var13, var25, var26, class19.mapMarkers[0], var42);
                                 }

                                 if(!SoundTaskDataProvider.localPlayer.hidden) {
                                    Rasterizer2D.Rasterizer2D_fillRectangle(var42.field2773 / 2 + var39 - 1, var42.field2772 / 2 + var13 - 1, 3, 3, 16777215);
                                 }
                                 break;
                              }

                              for(var24 = 0; var24 < 104; ++var24) {
                                 Deque var36 = Client.groundItemDeque[BoundingBox3DDrawMode.plane][var23][var24];
                                 if(var36 != null) {
                                    var26 = var23 * 4 + 2 - SoundTaskDataProvider.localPlayer.x / 32;
                                    var27 = var24 * 4 + 2 - SoundTaskDataProvider.localPlayer.y / 32;
                                    class38.drawDot(var39, var13, var26, var27, class49.mapDots[0], var42);
                                 }
                              }

                              ++var23;
                           }
                        } else {
                           Rasterizer2D.method5737(var39, var13, 0, var42.field2774, var42.field2771);
                        }

                        Client.field1073[var11] = true;
                     }

                     Rasterizer2D.setDrawRegion(var2, var3, var4, var5);
                     continue;
                  }

                  if(var10.contentType == 1339) {
                     class25.method202(var10, var39, var13, var11);
                     Rasterizer2D.setDrawRegion(var2, var3, var4, var5);
                     continue;
                  }

                  if(var10.contentType == 1400) {
                     Preferences.renderOverview.extractWorldmap(var39, var13, var10.width, var10.height, Client.gameCycle);
                  }

                  if(var10.contentType == 1401) {
                     Preferences.renderOverview.extractData(var39, var13, var10.width, var10.height);
                  }
               }

               boolean var46;
               if(var10.type == 0) {
                  if(!var10.hasScript) {
                     var46 = var10.isHidden;
                     if(var46 && var10 != BoundingBox3D.field259) {
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
                     class88.method1893(var19.id, var15, var16, var17, var18, var39, var13, var11);
                  }

                  Rasterizer2D.setDrawRegion(var2, var3, var4, var5);
                  Graphics3D.Rasterizer3D_method1();
               }

               if(Client.isResized || Client.field1074[var11] || Client.gameDrawingMode > 1) {
                  if(var10.type == 0 && !var10.hasScript && var10.scrollHeight > var10.height) {
                     class152.method3139(var39 + var10.width, var13, var10.scrollY, var10.height, var10.scrollHeight);
                  }

                  if(var10.type != 1) {
                     if(var10.type == 2) {
                        var30 = 0;

                        for(var20 = 0; var20 < var10.originalHeight; ++var20) {
                           for(var21 = 0; var21 < var10.originalWidth; ++var21) {
                              var22 = var21 * (var10.paddingX + 32) + var39;
                              var23 = var13 + var20 * (var10.paddingY + 32);
                              if(var30 < 20) {
                                 var22 += var10.xSprites[var30];
                                 var23 += var10.field2915[var30];
                              }

                              if(var10.itemIds[var30] <= 0) {
                                 if(var10.field2892 != null && var30 < 20) {
                                    SpritePixels var49 = var10.method4423(var30);
                                    if(var49 != null) {
                                       var49.drawAt(var22, var23);
                                    } else if(Widget.field2820) {
                                       FontName.method5490(var10);
                                    }
                                 }
                              } else {
                                 boolean var44 = false;
                                 boolean var45 = false;
                                 var26 = var10.itemIds[var30] - 1;
                                 if(var22 + 32 > var2 && var22 < var4 && var23 + 32 > var3 && var23 < var5 || var10 == UrlRequest.field2137 && var30 == Client.field977) {
                                    SpritePixels var35;
                                    if(Client.itemSelectionState == 1 && var30 == UrlRequester.selectedItemIndex && var10.id == BoundingBox.field251) {
                                       var35 = WorldMapDecoration.createSprite(var26, var10.itemQuantities[var30], 2, 0, 2, false);
                                    } else {
                                       var35 = WorldMapDecoration.createSprite(var26, var10.itemQuantities[var30], 1, 3153952, 2, false);
                                    }

                                    if(var35 != null) {
                                       if(var10 == UrlRequest.field2137 && var30 == Client.field977) {
                                          var24 = MouseInput.mouseLastX - Client.field978;
                                          var25 = MouseInput.mouseLastY - Client.field912;
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

                                          var35.drawAtOpacity(var22 + var24, var23 + var25, 128);
                                          if(var1 != -1) {
                                             Widget var28 = var0[var1 & 65535];
                                             int var29;
                                             if(var23 + var25 < Rasterizer2D.drawingAreaTop && var28.scrollY > 0) {
                                                var29 = (Rasterizer2D.drawingAreaTop - var23 - var25) * Client.field930 / 3;
                                                if(var29 > Client.field930 * 10) {
                                                   var29 = Client.field930 * 10;
                                                }

                                                if(var29 > var28.scrollY) {
                                                   var29 = var28.scrollY;
                                                }

                                                var28.scrollY -= var29;
                                                Client.field912 += var29;
                                                FontName.method5490(var28);
                                             }

                                             if(var25 + var23 + 32 > Rasterizer2D.drawingAreaRight && var28.scrollY < var28.scrollHeight - var28.height) {
                                                var29 = (var25 + var23 + 32 - Rasterizer2D.drawingAreaRight) * Client.field930 / 3;
                                                if(var29 > Client.field930 * 10) {
                                                   var29 = Client.field930 * 10;
                                                }

                                                if(var29 > var28.scrollHeight - var28.height - var28.scrollY) {
                                                   var29 = var28.scrollHeight - var28.height - var28.scrollY;
                                                }

                                                var28.scrollY += var29;
                                                Client.field912 -= var29;
                                                FontName.method5490(var28);
                                             }
                                          }
                                       } else if(var10 == class2.field17 && var30 == Client.pressedItemIndex) {
                                          var35.drawAtOpacity(var22, var23, 128);
                                       } else {
                                          var35.drawAt(var22, var23);
                                       }
                                    } else {
                                       FontName.method5490(var10);
                                    }
                                 }
                              }

                              ++var30;
                           }
                        }
                     } else if(var10.type == 3) {
                        if(class27.method246(var10)) {
                           var30 = var10.field2841;
                           if(var10 == BoundingBox3D.field259 && var10.field2908 != 0) {
                              var30 = var10.field2908;
                           }
                        } else {
                           var30 = var10.textColor;
                           if(var10 == BoundingBox3D.field259 && var10.field2849 != 0) {
                              var30 = var10.field2849;
                           }
                        }

                        if(var10.filled) {
                           switch(var10.field2909.field3970) {
                           case 1:
                              Rasterizer2D.method5723(var39, var13, var10.width, var10.height, var10.textColor, var10.field2841, 256 - (var10.opacity & 255), 256 - (var10.field2854 & 255));
                              break;
                           case 2:
                              Rasterizer2D.method5742(var39, var13, var10.width, var10.height, var10.textColor, var10.field2841, 256 - (var10.opacity & 255), 256 - (var10.field2854 & 255));
                              break;
                           case 3:
                              Rasterizer2D.method5725(var39, var13, var10.width, var10.height, var10.textColor, var10.field2841, 256 - (var10.opacity & 255), 256 - (var10.field2854 & 255));
                              break;
                           case 4:
                              Rasterizer2D.method5726(var39, var13, var10.width, var10.height, var10.textColor, var10.field2841, 256 - (var10.opacity & 255), 256 - (var10.field2854 & 255));
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
                              if(Widget.field2820) {
                                 FontName.method5490(var10);
                              }
                           } else {
                              String var53 = var10.text;
                              if(class27.method246(var10)) {
                                 var20 = var10.field2841;
                                 if(var10 == BoundingBox3D.field259 && var10.field2908 != 0) {
                                    var20 = var10.field2908;
                                 }

                                 if(var10.string1.length() > 0) {
                                    var53 = var10.string1;
                                 }
                              } else {
                                 var20 = var10.textColor;
                                 if(var10 == BoundingBox3D.field259 && var10.field2849 != 0) {
                                    var20 = var10.field2849;
                                 }
                              }

                              if(var10.hasScript && var10.itemId != -1) {
                                 ItemComposition var54 = class47.getItemDefinition(var10.itemId);
                                 var53 = var54.name;
                                 if(var53 == null) {
                                    var53 = "null";
                                 }

                                 if((var54.isStackable == 1 || var10.itemQuantity != 1) && var10.itemQuantity != -1) {
                                    var53 = class45.getColTags(16748608) + var53 + "</col>" + " " + 'x' + class169.method3290(var10.itemQuantity);
                                 }
                              }

                              if(var10 == Client.field1033) {
                                 var53 = "Please wait...";
                                 var20 = var10.textColor;
                              }

                              if(!var10.hasScript) {
                                 var53 = WidgetNode.method1135(var53, var10);
                              }

                              var40.method5514(var53, var39, var13, var10.width, var10.height, var20, var10.textShadowed?0:-1, var10.field2885, var10.field2833, var10.field2884);
                           }
                        } else if(var10.type == 5) {
                           SpritePixels var41;
                           if(!var10.hasScript) {
                              var41 = var10.method4431(class27.method246(var10));
                              if(var41 != null) {
                                 var41.drawAt(var39, var13);
                              } else if(Widget.field2820) {
                                 FontName.method5490(var10);
                              }
                           } else {
                              if(var10.itemId != -1) {
                                 var41 = WorldMapDecoration.createSprite(var10.itemId, var10.itemQuantity, var10.borderThickness, var10.sprite2, var10.field2853, false);
                              } else {
                                 var41 = var10.method4431(false);
                              }

                              if(var41 == null) {
                                 if(Widget.field2820) {
                                    FontName.method5490(var10);
                                 }
                              } else {
                                 var20 = var41.maxWidth;
                                 var21 = var41.maxHeight;
                                 if(!var10.spriteTiling) {
                                    var22 = var10.width * 4096 / var20;
                                    if(var10.textureId != 0) {
                                       var41.method5877(var10.width / 2 + var39, var10.height / 2 + var13, var10.textureId, var22);
                                    } else if(var14 != 0) {
                                       var41.method5866(var39, var13, var10.width, var10.height, 256 - (var14 & 255));
                                    } else if(var20 == var10.width && var21 == var10.height) {
                                       var41.drawAt(var39, var13);
                                    } else {
                                       var41.method5860(var39, var13, var10.width, var10.height);
                                    }
                                 } else {
                                    Rasterizer2D.setInnerDrawRegion(var39, var13, var39 + var10.width, var13 + var10.height);
                                    var22 = (var20 - 1 + var10.width) / var20;
                                    var23 = (var21 - 1 + var10.height) / var21;

                                    for(var24 = 0; var24 < var22; ++var24) {
                                       for(var25 = 0; var25 < var23; ++var25) {
                                          if(var10.textureId != 0) {
                                             var41.method5877(var20 / 2 + var39 + var20 * var24, var21 / 2 + var13 + var25 * var21, var10.textureId, 4096);
                                          } else if(var14 != 0) {
                                             var41.drawAtOpacity(var39 + var20 * var24, var13 + var21 * var25, 256 - (var14 & 255));
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
                           ItemComposition var34;
                           if(var10.type == 6) {
                              var46 = class27.method246(var10);
                              if(var46) {
                                 var20 = var10.field2855;
                              } else {
                                 var20 = var10.field2869;
                              }

                              Model var47 = null;
                              var22 = 0;
                              if(var10.itemId != -1) {
                                 var34 = class47.getItemDefinition(var10.itemId);
                                 if(var34 != null) {
                                    var34 = var34.method5063(var10.itemQuantity);
                                    var47 = var34.getModel(1);
                                    if(var47 != null) {
                                       var47.calculateBoundsCylinder();
                                       var22 = var47.modelHeight / 2;
                                    } else {
                                       FontName.method5490(var10);
                                    }
                                 }
                              } else if(var10.modelType == 5) {
                                 if(var10.modelId == 0) {
                                    var47 = Client.field1132.getModel((Sequence)null, -1, (Sequence)null, -1);
                                 } else {
                                    var47 = SoundTaskDataProvider.localPlayer.getModel();
                                 }
                              } else if(var20 == -1) {
                                 var47 = var10.getModel((Sequence)null, -1, var46, SoundTaskDataProvider.localPlayer.composition);
                                 if(var47 == null && Widget.field2820) {
                                    FontName.method5490(var10);
                                 }
                              } else {
                                 Sequence var56 = CombatInfo1.getAnimation(var20);
                                 var47 = var10.getModel(var56, var10.field2935, var46, SoundTaskDataProvider.localPlayer.composition);
                                 if(var47 == null && Widget.field2820) {
                                    FontName.method5490(var10);
                                 }
                              }

                              Graphics3D.method2780(var10.width / 2 + var39, var10.height / 2 + var13);
                              var23 = Graphics3D.SINE[var10.rotationX] * var10.modelZoom >> 16;
                              var24 = Graphics3D.COSINE[var10.rotationX] * var10.modelZoom >> 16;
                              if(var47 != null) {
                                 if(!var10.hasScript) {
                                    var47.method2734(0, var10.rotationZ, 0, var10.rotationX, 0, var23, var24);
                                 } else {
                                    var47.calculateBoundsCylinder();
                                    if(var10.field2879) {
                                       var47.method2748(0, var10.rotationZ, var10.rotationY, var10.rotationX, var10.offsetX2d, var23 + var22 + var10.offsetY2d, var24 + var10.offsetY2d, var10.modelZoom);
                                    } else {
                                       var47.method2734(0, var10.rotationZ, var10.rotationY, var10.rotationX, var10.offsetX2d, var23 + var22 + var10.offsetY2d, var24 + var10.offsetY2d);
                                    }
                                 }
                              }

                              Graphics3D.Rasterizer3D_method3();
                           } else {
                              if(var10.type == 7) {
                                 var40 = var10.getFont();
                                 if(var40 == null) {
                                    if(Widget.field2820) {
                                       FontName.method5490(var10);
                                    }
                                    continue;
                                 }

                                 var20 = 0;

                                 for(var21 = 0; var21 < var10.originalHeight; ++var21) {
                                    for(var22 = 0; var22 < var10.originalWidth; ++var22) {
                                       if(var10.itemIds[var20] > 0) {
                                          var34 = class47.getItemDefinition(var10.itemIds[var20] - 1);
                                          String var31;
                                          if(var34.isStackable != 1 && var10.itemQuantities[var20] == 1) {
                                             var31 = class45.getColTags(16748608) + var34.name + "</col>";
                                          } else {
                                             var31 = class45.getColTags(16748608) + var34.name + "</col>" + " " + 'x' + class169.method3290(var10.itemQuantities[var20]);
                                          }

                                          var25 = var39 + var22 * (var10.paddingX + 115);
                                          var26 = var13 + (var10.paddingY + 12) * var21;
                                          if(var10.field2885 == 0) {
                                             var40.method5510(var31, var25, var26, var10.textColor, var10.textShadowed?0:-1);
                                          } else if(var10.field2885 == 1) {
                                             var40.drawTextCentered(var31, var10.width / 2 + var25, var26, var10.textColor, var10.textShadowed?0:-1);
                                          } else {
                                             var40.method5512(var31, var25 + var10.width - 1, var26, var10.textColor, var10.textShadowed?0:-1);
                                          }
                                       }

                                       ++var20;
                                    }
                                 }
                              }

                              if(var10.type == 8 && var10 == class7.field234 && Client.field1115 == Client.field1021) {
                                 var30 = 0;
                                 var20 = 0;
                                 Font var32 = class20.font_p12full;
                                 String var33 = var10.text;

                                 String var52;
                                 for(var33 = WidgetNode.method1135(var33, var10); var33.length() > 0; var20 = var20 + var32.verticalSpace + 1) {
                                    var24 = var33.indexOf("<br>");
                                    if(var24 != -1) {
                                       var52 = var33.substring(0, var24);
                                       var33 = var33.substring(var24 + 4);
                                    } else {
                                       var52 = var33;
                                       var33 = "";
                                    }

                                    var25 = var32.getTextWidth(var52);
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
                                 var33 = var10.text;
                                 var26 = var25 + var32.verticalSpace + 2;

                                 for(var33 = WidgetNode.method1135(var33, var10); var33.length() > 0; var26 = var26 + var32.verticalSpace + 1) {
                                    var27 = var33.indexOf("<br>");
                                    if(var27 != -1) {
                                       var52 = var33.substring(0, var27);
                                       var33 = var33.substring(var27 + 4);
                                    } else {
                                       var52 = var33;
                                       var33 = "";
                                    }

                                    var32.method5510(var52, var24 + 3, var26, 0, -1);
                                 }
                              }

                              if(var10.type == 9) {
                                 if(var10.field2903) {
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
                                    class2.method2(var30, var20, var21, var22, var10.textColor, var10.lineWidth);
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
