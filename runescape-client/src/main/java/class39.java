import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ag")
public class class39 {
   @ObfuscatedName("fz")
   @ObfuscatedSignature(
      signature = "[Lko;"
   )
   @Export("crossSprites")
   static SpritePixels[] crossSprites;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 1144228661
   )
   public final int field495;
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Lhn;"
   )
   public final Coordinates field496;
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Lhn;"
   )
   public final Coordinates field500;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -1321944133
   )
   final int field493;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 123620561
   )
   final int field497;
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "Lah;"
   )
   final class33 field498;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -1170699017
   )
   int field499;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 1590202733
   )
   int field494;

   @ObfuscatedSignature(
      signature = "(ILhn;Lhn;Lah;)V"
   )
   class39(int var1, Coordinates var2, Coordinates var3, class33 var4) {
      this.field495 = var1;
      this.field500 = var2;
      this.field496 = var3;
      this.field498 = var4;
      Area var5 = Area.mapAreaType[this.field495];
      SpritePixels var6 = var5.getMapIcon(false);
      if(var6 != null) {
         this.field493 = var6.width;
         this.field497 = var6.height;
      } else {
         this.field493 = 0;
         this.field497 = 0;
      }

   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(III)Z",
      garbageValue = "1957544789"
   )
   boolean method536(int var1, int var2) {
      return this.method537(var1, var2)?true:this.method538(var1, var2);
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(III)Z",
      garbageValue = "935248910"
   )
   boolean method537(int var1, int var2) {
      Area var3 = Area.mapAreaType[this.field495];
      switch(var3.field3356.field3601) {
      case 0:
         if(var1 > this.field499 - this.field493 && var1 <= this.field499) {
            break;
         }

         return false;
      case 1:
         if(var1 >= this.field499 - this.field493 / 2 && var1 <= this.field493 / 2 + this.field499) {
            break;
         }

         return false;
      case 2:
         if(var1 < this.field499 || var1 >= this.field493 + this.field499) {
            return false;
         }
      }

      switch(var3.field3370.field3341) {
      case 0:
         if(var2 > this.field494 - this.field497 && var2 <= this.field494) {
            break;
         }

         return false;
      case 1:
         if(var2 < this.field494 - this.field497 / 2 || var2 > this.field497 / 2 + this.field494) {
            return false;
         }
         break;
      case 2:
         if(var2 < this.field494 || var2 >= this.field494 + this.field497) {
            return false;
         }
      }

      return true;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(III)Z",
      garbageValue = "1252306821"
   )
   boolean method538(int var1, int var2) {
      return this.field498 == null?false:(var1 >= this.field499 - this.field498.field435 / 2 && var1 <= this.field498.field435 / 2 + this.field499?var2 >= this.field494 && var2 <= this.field498.field437 + this.field494:false);
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(CI)Z",
      garbageValue = "554802764"
   )
   static final boolean method535(char var0) {
      return var0 == 160 || var0 == ' ' || var0 == '_' || var0 == '-';
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;I)I",
      garbageValue = "-2000355189"
   )
   @Export("djb2Hash")
   public static int djb2Hash(CharSequence var0) {
      int var1 = var0.length();
      int var2 = 0;

      for(int var3 = 0; var3 < var1; ++var3) {
         var2 = (var2 << 5) - var2 + WorldComparator.charToByteCp1252(var0.charAt(var3));
      }

      return var2;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(ILcd;ZI)I",
      garbageValue = "-720149689"
   )
   static int method544(int var0, Script var1, boolean var2) {
      Widget var3 = var2?class23.field331:GrandExchangeOffer.field297;
      if(var0 == 1700) {
         class80.intStack[++class80.intStackSize - 1] = var3.itemId;
         return 1;
      } else if(var0 == 1701) {
         if(var3.itemId != -1) {
            class80.intStack[++class80.intStackSize - 1] = var3.itemQuantity;
         } else {
            class80.intStack[++class80.intStackSize - 1] = 0;
         }

         return 1;
      } else if(var0 == 1702) {
         class80.intStack[++class80.intStackSize - 1] = var3.index;
         return 1;
      } else {
         return 2;
      }
   }

   @ObfuscatedName("gw")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-361913360"
   )
   static void method541() {
      if(Client.field935 >= 0 && Client.cachedPlayers[Client.field935] != null) {
         class181.method3381(Client.cachedPlayers[Client.field935], false);
      }

   }

   @ObfuscatedName("il")
   @ObfuscatedSignature(
      signature = "([Lho;IIIIIIIII)V",
      garbageValue = "885903784"
   )
   @Export("gameDraw")
   static final void gameDraw(Widget[] var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
      Rasterizer2D.setDrawRegion(var2, var3, var4, var5);
      Graphics3D.Rasterizer3D_method1();

      for(int var9 = 0; var9 < var0.length; ++var9) {
         Widget var10 = var0[var9];
         if(var10 != null && (var10.parentId == var1 || var1 == -1412584499 && var10 == Client.field980)) {
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
            if(!var10.hasScript || !WorldMapType3.method220(var10)) {
               int var12;
               if(var10.contentType > 0) {
                  var12 = var10.contentType;
                  if(var12 == 324) {
                     if(Client.field1071 == -1) {
                        Client.field1071 = var10.spriteId;
                        Client.field1072 = var10.field2805;
                     }

                     if(Client.field1081.isFemale) {
                        var10.spriteId = Client.field1071;
                     } else {
                        var10.spriteId = Client.field1072;
                     }
                  } else if(var12 == 325) {
                     if(Client.field1071 == -1) {
                        Client.field1071 = var10.spriteId;
                        Client.field1072 = var10.field2805;
                     }

                     if(Client.field1081.isFemale) {
                        var10.spriteId = Client.field1072;
                     } else {
                        var10.spriteId = Client.field1071;
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
               if(var10 == Client.field980) {
                  if(var1 != -1412584499 && !var10.field2816) {
                     Script.field1417 = var0;
                     class7.field227 = var6;
                     class218.field2667 = var7;
                     continue;
                  }

                  if(Client.field991 && Client.field985) {
                     var15 = MouseInput.mouseLastX;
                     var16 = MouseInput.mouseLastY;
                     var15 -= Client.field982;
                     var16 -= Client.field983;
                     if(var15 < Client.field986) {
                        var15 = Client.field986;
                     }

                     if(var15 + var10.width > Client.field986 + Client.field981.width) {
                        var15 = Client.field986 + Client.field981.width - var10.width;
                     }

                     if(var16 < Client.field987) {
                        var16 = Client.field987;
                     }

                     if(var16 + var10.height > Client.field987 + Client.field981.height) {
                        var16 = Client.field987 + Client.field981.height - var10.height;
                     }

                     var12 = var15;
                     var13 = var16;
                  }

                  if(!var10.field2816) {
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
                  int var49;
                  if(var10.contentType != 0) {
                     if(var10.contentType == 1336) {
                        if(Client.displayFps) {
                           var13 += 15;
                           BoundingBox2D.font_p12full.method5268("Fps:" + GameEngine.FPS, var12 + var10.width, var13, 16776960, -1);
                           var13 += 15;
                           Runtime var65 = Runtime.getRuntime();
                           var20 = (int)((var65.totalMemory() - var65.freeMemory()) / 1024L);
                           var21 = 16776960;
                           if(var20 > 32768 && Client.lowMemory) {
                              var21 = 16711680;
                           }

                           if(var20 > 65536 && !Client.lowMemory) {
                              var21 = 16711680;
                           }

                           BoundingBox2D.font_p12full.method5268("Mem:" + var20 + "k", var12 + var10.width, var13, var21, -1);
                           var13 += 15;
                        }
                        continue;
                     }

                     if(var10.contentType == 1337) {
                        Client.field955 = var12;
                        Client.field1025 = var13;
                        class3.method6(var12, var13, var10.width, var10.height);
                        Client.field1012[var10.boundsIndex] = true;
                        Rasterizer2D.setDrawRegion(var2, var3, var4, var5);
                        continue;
                     }

                     class221 var63;
                     if(var10.contentType == 1338) {
                        Friend.method5158();
                        var63 = var10.method4288(false);
                        if(var63 != null) {
                           Rasterizer2D.setDrawRegion(var12, var13, var12 + var63.field2686, var13 + var63.field2684);
                           if(Client.field1050 != 2 && Client.field1050 != 5) {
                              var20 = Client.mapAngle & 2047;
                              var21 = class36.localPlayer.x / 32 + 48;
                              var22 = 464 - class36.localPlayer.y / 32;
                              class29.minimapSprite.method5547(var12, var13, var63.field2686, var63.field2684, var21, var22, var20, 256, var63.field2685, var63.field2683);

                              for(var23 = 0; var23 < Client.field1033; ++var23) {
                                 var24 = Client.field1034[var23] * 4 + 2 - class36.localPlayer.x / 32;
                                 var25 = Client.field1035[var23] * 4 + 2 - class36.localPlayer.y / 32;
                                 RunException.drawDot(var12, var13, var24, var25, Client.mapIcons[var23], var63);
                              }

                              var23 = 0;

                              while(true) {
                                 if(var23 >= 104) {
                                    for(var23 = 0; var23 < Client.npcIndexesCount; ++var23) {
                                       NPC var68 = Client.cachedNPCs[Client.npcIndices[var23]];
                                       if(var68 != null && var68.hasConfig()) {
                                          NPCComposition var62 = var68.composition;
                                          if(var62 != null && var62.configs != null) {
                                             var62 = var62.transform();
                                          }

                                          if(var62 != null && var62.isMinimapVisible && var62.field3630) {
                                             var26 = var68.x / 32 - class36.localPlayer.x / 32;
                                             var49 = var68.y / 32 - class36.localPlayer.y / 32;
                                             RunException.drawDot(var12, var13, var26, var49, Widget.mapDots[1], var63);
                                          }
                                       }
                                    }

                                    var23 = class92.playerIndexesCount;
                                    int[] var70 = class92.playerIndices;

                                    for(var25 = 0; var25 < var23; ++var25) {
                                       Player var71 = Client.cachedPlayers[var70[var25]];
                                       if(var71 != null && var71.hasConfig() && !var71.hidden && var71 != class36.localPlayer) {
                                          var49 = var71.x / 32 - class36.localPlayer.x / 32;
                                          var28 = var71.y / 32 - class36.localPlayer.y / 32;
                                          boolean var58 = false;
                                          if(class36.localPlayer.team != 0 && var71.team != 0 && var71.team == class36.localPlayer.team) {
                                             var58 = true;
                                          }

                                          if(var71.isFriend()) {
                                             RunException.drawDot(var12, var13, var49, var28, Widget.mapDots[3], var63);
                                          } else if(var58) {
                                             RunException.drawDot(var12, var13, var49, var28, Widget.mapDots[4], var63);
                                          } else if(var71.isClanMember()) {
                                             RunException.drawDot(var12, var13, var49, var28, Widget.mapDots[5], var63);
                                          } else {
                                             RunException.drawDot(var12, var13, var49, var28, Widget.mapDots[2], var63);
                                          }
                                       }
                                    }

                                    if(Client.hintArrowTargetType != 0 && Client.gameCycle % 20 < 10) {
                                       if(Client.hintArrowTargetType == 1 && Client.hintArrowNpcTargetIdx >= 0 && Client.hintArrowNpcTargetIdx < Client.cachedNPCs.length) {
                                          NPC var64 = Client.cachedNPCs[Client.hintArrowNpcTargetIdx];
                                          if(var64 != null) {
                                             var26 = var64.x / 32 - class36.localPlayer.x / 32;
                                             var49 = var64.y / 32 - class36.localPlayer.y / 32;
                                             class254.worldToMinimap(var12, var13, var26, var49, DState.mapMarkers[1], var63);
                                          }
                                       }

                                       if(Client.hintArrowTargetType == 2) {
                                          var25 = Client.hintArrowX * 4 - WorldMapType1.baseX * 4 + 2 - class36.localPlayer.x / 32;
                                          var26 = Client.hintArrowY * 4 - class85.baseY * 4 + 2 - class36.localPlayer.y / 32;
                                          class254.worldToMinimap(var12, var13, var25, var26, DState.mapMarkers[1], var63);
                                       }

                                       if(Client.hintArrowTargetType == 10 && Client.hintArrowPlayerTargetIdx >= 0 && Client.hintArrowPlayerTargetIdx < Client.cachedPlayers.length) {
                                          Player var66 = Client.cachedPlayers[Client.hintArrowPlayerTargetIdx];
                                          if(var66 != null) {
                                             var26 = var66.x / 32 - class36.localPlayer.x / 32;
                                             var49 = var66.y / 32 - class36.localPlayer.y / 32;
                                             class254.worldToMinimap(var12, var13, var26, var49, DState.mapMarkers[1], var63);
                                          }
                                       }
                                    }

                                    if(Client.destinationX != 0) {
                                       var25 = Client.destinationX * 4 + 2 - class36.localPlayer.x / 32;
                                       var26 = Client.destinationY * 4 + 2 - class36.localPlayer.y / 32;
                                       RunException.drawDot(var12, var13, var25, var26, DState.mapMarkers[0], var63);
                                    }

                                    if(!class36.localPlayer.hidden) {
                                       Rasterizer2D.Rasterizer2D_fillRectangle(var63.field2686 / 2 + var12 - 1, var63.field2684 / 2 + var13 - 1, 3, 3, 16777215);
                                    }
                                    break;
                                 }

                                 for(var24 = 0; var24 < 104; ++var24) {
                                    Deque var61 = Client.groundItemDeque[MessageNode.plane][var23][var24];
                                    if(var61 != null) {
                                       var26 = var23 * 4 + 2 - class36.localPlayer.x / 32;
                                       var49 = var24 * 4 + 2 - class36.localPlayer.y / 32;
                                       RunException.drawDot(var12, var13, var26, var49, Widget.mapDots[0], var63);
                                    }
                                 }

                                 ++var23;
                              }
                           } else {
                              Rasterizer2D.method5473(var12, var13, 0, var63.field2685, var63.field2683);
                           }

                           Client.field1013[var11] = true;
                        }

                        Rasterizer2D.setDrawRegion(var2, var3, var4, var5);
                        continue;
                     }

                     if(var10.contentType == 1339) {
                        var63 = var10.method4288(false);
                        if(var63 != null) {
                           if(Client.field1050 < 3) {
                              ClassInfo.compass.method5547(var12, var13, var63.field2686, var63.field2684, 25, 25, Client.mapAngle, 256, var63.field2685, var63.field2683);
                           } else {
                              Rasterizer2D.method5473(var12, var13, 0, var63.field2685, var63.field2683);
                           }
                        }

                        Rasterizer2D.setDrawRegion(var2, var3, var4, var5);
                        continue;
                     }

                     if(var10.contentType == 1400) {
                        ScriptState.renderOverview.extractWorldmap(var12, var13, var10.width, var10.height, Client.gameCycle);
                     }

                     if(var10.contentType == 1401) {
                        ScriptState.renderOverview.extractData(var12, var13, var10.width, var10.height);
                     }
                  }

                  if(var10.type == 0) {
                     if(!var10.hasScript && WorldMapType3.method220(var10) && var10 != FileRequest.field3287) {
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
                        class254.method4589(var46.id, var15, var16, var17, var18, var12, var13, var11);
                     }

                     Rasterizer2D.setDrawRegion(var2, var3, var4, var5);
                     Graphics3D.Rasterizer3D_method1();
                  }

                  if(Client.isResized || Client.field833[var11] || Client.gameDrawingMode > 1) {
                     if(var10.type == 0 && !var10.hasScript && var10.scrollHeight > var10.height) {
                        class193.method3702(var12 + var10.width, var13, var10.scrollY, var10.height, var10.scrollHeight);
                     }

                     if(var10.type != 1) {
                        int var29;
                        if(var10.type == 2) {
                           var19 = 0;

                           for(var20 = 0; var20 < var10.originalHeight; ++var20) {
                              for(var21 = 0; var21 < var10.originalWidth; ++var21) {
                                 var22 = var12 + var21 * (var10.paddingX + 32);
                                 var23 = var13 + var20 * (var10.paddingY + 32);
                                 if(var19 < 20) {
                                    var22 += var10.xSprites[var19];
                                    var23 += var10.field2807[var19];
                                 }

                                 if(var10.itemIds[var19] <= 0) {
                                    if(var10.field2808 != null && var19 < 20) {
                                       SpritePixels var67 = var10.method4255(var19);
                                       if(var67 != null) {
                                          var67.drawAt(var22, var23);
                                       } else if(Widget.field2736) {
                                          class60.method1015(var10);
                                       }
                                    }
                                 } else {
                                    boolean var56 = false;
                                    boolean var57 = false;
                                    var26 = var10.itemIds[var19] - 1;
                                    if(var22 + 32 > var2 && var22 < var4 && var23 + 32 > var3 && var23 < var5 || var10 == class37.field479 && var19 == Client.field1002) {
                                       SpritePixels var27;
                                       if(Client.itemSelectionState == 1 && var19 == FontName.selectedItemIndex && var10.id == class37.field476) {
                                          var27 = class27.createSprite(var26, var10.itemQuantities[var19], 2, 0, 2, false);
                                       } else {
                                          var27 = class27.createSprite(var26, var10.itemQuantities[var19], 1, 3153952, 2, false);
                                       }

                                       if(var27 != null) {
                                          if(var10 == class37.field479 && var19 == Client.field1002) {
                                             var24 = MouseInput.mouseLastX - Client.field914;
                                             var25 = MouseInput.mouseLastY - Client.field1044;
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

                                             var27.drawAtOpacity(var22 + var24, var25 + var23, 128);
                                             if(var1 != -1) {
                                                Widget var75 = var0[var1 & 65535];
                                                if(var25 + var23 < Rasterizer2D.drawingAreaTop && var75.scrollY > 0) {
                                                   var29 = (Rasterizer2D.drawingAreaTop - var23 - var25) * Client.field882 / 3;
                                                   if(var29 > Client.field882 * 10) {
                                                      var29 = Client.field882 * 10;
                                                   }

                                                   if(var29 > var75.scrollY) {
                                                      var29 = var75.scrollY;
                                                   }

                                                   var75.scrollY -= var29;
                                                   Client.field1044 += var29;
                                                   class60.method1015(var75);
                                                }

                                                if(var23 + var25 + 32 > Rasterizer2D.drawingAreaRight && var75.scrollY < var75.scrollHeight - var75.height) {
                                                   var29 = (var23 + var25 + 32 - Rasterizer2D.drawingAreaRight) * Client.field882 / 3;
                                                   if(var29 > Client.field882 * 10) {
                                                      var29 = Client.field882 * 10;
                                                   }

                                                   if(var29 > var75.scrollHeight - var75.height - var75.scrollY) {
                                                      var29 = var75.scrollHeight - var75.height - var75.scrollY;
                                                   }

                                                   var75.scrollY += var29;
                                                   Client.field1044 -= var29;
                                                   class60.method1015(var75);
                                                }
                                             }
                                          } else if(var10 == class25.field349 && var19 == Client.pressedItemIndex) {
                                             var27.drawAtOpacity(var22, var23, 128);
                                          } else {
                                             var27.drawAt(var22, var23);
                                          }
                                       } else {
                                          class60.method1015(var10);
                                       }
                                    }
                                 }

                                 ++var19;
                              }
                           }
                        } else if(var10.type == 3) {
                           if(class19.method161(var10)) {
                              var19 = var10.field2764;
                              if(var10 == FileRequest.field3287 && var10.field2766 != 0) {
                                 var19 = var10.field2766;
                              }
                           } else {
                              var19 = var10.textColor;
                              if(var10 == FileRequest.field3287 && var10.field2765 != 0) {
                                 var19 = var10.field2765;
                              }
                           }

                           if(var10.filled) {
                              switch(var10.field2758.field3867) {
                              case 1:
                                 Rasterizer2D.method5402(var12, var13, var10.width, var10.height, var10.textColor, var10.field2764, 256 - (var10.opacity & 255), 256 - (var10.field2770 & 255));
                                 break;
                              case 2:
                                 Rasterizer2D.method5472(var12, var13, var10.width, var10.height, var10.textColor, var10.field2764, 256 - (var10.opacity & 255), 256 - (var10.field2770 & 255));
                                 break;
                              case 3:
                                 Rasterizer2D.method5454(var12, var13, var10.width, var10.height, var10.textColor, var10.field2764, 256 - (var10.opacity & 255), 256 - (var10.field2770 & 255));
                                 break;
                              case 4:
                                 Rasterizer2D.method5405(var12, var13, var10.width, var10.height, var10.textColor, var10.field2764, 256 - (var10.opacity & 255), 256 - (var10.field2770 & 255));
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
                           String var48;
                           String var50;
                           Font var59;
                           String var72;
                           if(var10.type == 4) {
                              var59 = var10.getFont();
                              if(var59 == null) {
                                 if(Widget.field2736) {
                                    class60.method1015(var10);
                                 }
                              } else {
                                 String var73 = var10.text;
                                 if(class19.method161(var10)) {
                                    var20 = var10.field2764;
                                    if(var10 == FileRequest.field3287 && var10.field2766 != 0) {
                                       var20 = var10.field2766;
                                    }

                                    if(var10.string1.length() > 0) {
                                       var73 = var10.string1;
                                    }
                                 } else {
                                    var20 = var10.textColor;
                                    if(var10 == FileRequest.field3287 && var10.field2765 != 0) {
                                       var20 = var10.field2765;
                                    }
                                 }

                                 StringBuilder var10000;
                                 if(var10.hasScript && var10.itemId != -1) {
                                    ItemComposition var74 = CombatInfo1.getItemDefinition(var10.itemId);
                                    var73 = var74.name;
                                    if(var73 == null) {
                                       var73 = "null";
                                    }

                                    if((var74.isStackable == 1 || var10.itemQuantity != 1) && var10.itemQuantity != -1) {
                                       var72 = class1.getColTags(16748608) + var73 + "</col>" + " " + 'x';
                                       var25 = var10.itemQuantity;
                                       var50 = Integer.toString(var25);

                                       for(var49 = var50.length() - 3; var49 > 0; var49 -= 3) {
                                          var50 = var50.substring(0, var49) + "," + var50.substring(var49);
                                       }

                                       Object var10001;
                                       if(var50.length() > 9) {
                                          var10000 = (new StringBuilder()).append(" ").append(class1.getColTags(65408)).append(var50.substring(0, var50.length() - 8));
                                          var10001 = null;
                                          var48 = var10000.append("M").append(" ").append(" (").append(var50).append(")").append("</col>").toString();
                                       } else if(var50.length() > 6) {
                                          var10000 = (new StringBuilder()).append(" ").append(class1.getColTags(16777215)).append(var50.substring(0, var50.length() - 4));
                                          var10001 = null;
                                          var48 = var10000.append("K").append(" ").append(" (").append(var50).append(")").append("</col>").toString();
                                       } else {
                                          var48 = " " + class1.getColTags(16776960) + var50 + "</col>";
                                       }

                                       var73 = var72 + var48;
                                    }
                                 }

                                 if(var10 == Client.field971) {
                                    var10000 = null;
                                    var73 = "Please wait...";
                                    var20 = var10.textColor;
                                 }

                                 if(!var10.hasScript) {
                                    var73 = DState.method3386(var73, var10);
                                 }

                                 var59.method5217(var73, var12, var13, var10.width, var10.height, var20, var10.textShadowed?0:-1, var10.field2801, var10.field2788, var10.field2800);
                              }
                           } else if(var10.type == 5) {
                              SpritePixels var60;
                              if(!var10.hasScript) {
                                 var60 = var10.method4253(class19.method161(var10));
                                 if(var60 != null) {
                                    var60.drawAt(var12, var13);
                                 } else if(Widget.field2736) {
                                    class60.method1015(var10);
                                 }
                              } else {
                                 if(var10.itemId != -1) {
                                    var60 = class27.createSprite(var10.itemId, var10.itemQuantity, var10.borderThickness, var10.sprite2, var10.field2739, false);
                                 } else {
                                    var60 = var10.method4253(false);
                                 }

                                 if(var60 == null) {
                                    if(Widget.field2736) {
                                       class60.method1015(var10);
                                    }
                                 } else {
                                    var20 = var60.maxWidth;
                                    var21 = var60.maxHeight;
                                    if(!var10.spriteTiling) {
                                       var22 = var10.width * 4096 / var20;
                                       if(var10.textureId != 0) {
                                          var60.method5577(var10.width / 2 + var12, var10.height / 2 + var13, var10.textureId, var22);
                                       } else if(var14 != 0) {
                                          var60.method5544(var12, var13, var10.width, var10.height, 256 - (var14 & 255));
                                       } else if(var20 == var10.width && var21 == var10.height) {
                                          var60.drawAt(var12, var13);
                                       } else {
                                          var60.method5538(var12, var13, var10.width, var10.height);
                                       }
                                    } else {
                                       Rasterizer2D.setInnerDrawRegion(var12, var13, var12 + var10.width, var13 + var10.height);
                                       var22 = (var20 - 1 + var10.width) / var20;
                                       var23 = (var21 - 1 + var10.height) / var21;

                                       for(var24 = 0; var24 < var22; ++var24) {
                                          for(var25 = 0; var25 < var23; ++var25) {
                                             if(var10.textureId != 0) {
                                                var60.method5577(var20 / 2 + var12 + var24 * var20, var21 / 2 + var13 + var21 * var25, var10.textureId, 4096);
                                             } else if(var14 != 0) {
                                                var60.drawAtOpacity(var12 + var20 * var24, var13 + var25 * var21, 256 - (var14 & 255));
                                             } else {
                                                var60.drawAt(var12 + var20 * var24, var13 + var25 * var21);
                                             }
                                          }
                                       }

                                       Rasterizer2D.setDrawRegion(var2, var3, var4, var5);
                                    }
                                 }
                              }
                           } else {
                              ItemComposition var53;
                              if(var10.type == 6) {
                                 boolean var55 = class19.method161(var10);
                                 if(var55) {
                                    var20 = var10.field2786;
                                 } else {
                                    var20 = var10.field2785;
                                 }

                                 Model var69 = null;
                                 var22 = 0;
                                 if(var10.itemId != -1) {
                                    var53 = CombatInfo1.getItemDefinition(var10.itemId);
                                    if(var53 != null) {
                                       var53 = var53.method4834(var10.itemQuantity);
                                       var69 = var53.getModel(1);
                                       if(var69 != null) {
                                          var69.calculateBoundsCylinder();
                                          var22 = var69.modelHeight / 2;
                                       } else {
                                          class60.method1015(var10);
                                       }
                                    }
                                 } else if(var10.modelType == 5) {
                                    if(var10.modelId == 0) {
                                       var69 = Client.field1081.getModel((Sequence)null, -1, (Sequence)null, -1);
                                    } else {
                                       var69 = class36.localPlayer.getModel();
                                    }
                                 } else if(var20 == -1) {
                                    var69 = var10.getModel((Sequence)null, -1, var55, class36.localPlayer.composition);
                                    if(var69 == null && Widget.field2736) {
                                       class60.method1015(var10);
                                    }
                                 } else {
                                    Sequence var76 = CacheFile.getAnimation(var20);
                                    var69 = var10.getModel(var76, var10.field2860, var55, class36.localPlayer.composition);
                                    if(var69 == null && Widget.field2736) {
                                       class60.method1015(var10);
                                    }
                                 }

                                 Graphics3D.method2745(var10.width / 2 + var12, var10.height / 2 + var13);
                                 var23 = Graphics3D.SINE[var10.rotationX] * var10.modelZoom >> 16;
                                 var24 = Graphics3D.COSINE[var10.rotationX] * var10.modelZoom >> 16;
                                 if(var69 != null) {
                                    if(!var10.hasScript) {
                                       var69.method2672(0, var10.rotationZ, 0, var10.rotationX, 0, var23, var24);
                                    } else {
                                       var69.calculateBoundsCylinder();
                                       if(var10.field2795) {
                                          var69.method2673(0, var10.rotationZ, var10.rotationY, var10.rotationX, var10.field2787, var22 + var23 + var10.field2782, var24 + var10.field2782, var10.modelZoom);
                                       } else {
                                          var69.method2672(0, var10.rotationZ, var10.rotationY, var10.rotationX, var10.field2787, var23 + var22 + var10.field2782, var24 + var10.field2782);
                                       }
                                    }
                                 }

                                 Graphics3D.Rasterizer3D_method3();
                              } else {
                                 if(var10.type == 7) {
                                    var59 = var10.getFont();
                                    if(var59 == null) {
                                       if(Widget.field2736) {
                                          class60.method1015(var10);
                                       }
                                       continue;
                                    }

                                    var20 = 0;

                                    for(var21 = 0; var21 < var10.originalHeight; ++var21) {
                                       for(var22 = 0; var22 < var10.originalWidth; ++var22) {
                                          if(var10.itemIds[var20] > 0) {
                                             var53 = CombatInfo1.getItemDefinition(var10.itemIds[var20] - 1);
                                             if(var53.isStackable != 1 && var10.itemQuantities[var20] == 1) {
                                                var48 = class1.getColTags(16748608) + var53.name + "</col>";
                                             } else {
                                                String var47 = class1.getColTags(16748608) + var53.name + "</col>" + " " + 'x';
                                                var49 = var10.itemQuantities[var20];
                                                String var54 = Integer.toString(var49);

                                                for(var29 = var54.length() - 3; var29 > 0; var29 -= 3) {
                                                   var54 = var54.substring(0, var29) + "," + var54.substring(var29);
                                                }

                                                if(var54.length() > 9) {
                                                   var50 = " " + class1.getColTags(65408) + var54.substring(0, var54.length() - 8) + "M" + " " + " (" + var54 + ")" + "</col>";
                                                } else if(var54.length() > 6) {
                                                   var50 = " " + class1.getColTags(16777215) + var54.substring(0, var54.length() - 4) + "K" + " " + " (" + var54 + ")" + "</col>";
                                                } else {
                                                   var50 = " " + class1.getColTags(16776960) + var54 + "</col>";
                                                }

                                                var48 = var47 + var50;
                                             }

                                             var25 = var22 * (var10.paddingX + 115) + var12;
                                             var26 = (var10.paddingY + 12) * var21 + var13;
                                             if(var10.field2801 == 0) {
                                                var59.method5225(var48, var25, var26, var10.textColor, var10.textShadowed?0:-1);
                                             } else if(var10.field2801 == 1) {
                                                var59.drawTextCentered(var48, var10.width / 2 + var25, var26, var10.textColor, var10.textShadowed?0:-1);
                                             } else {
                                                var59.method5268(var48, var25 + var10.width - 1, var26, var10.textColor, var10.textShadowed?0:-1);
                                             }
                                          }

                                          ++var20;
                                       }
                                    }
                                 }

                                 if(var10.type == 8 && var10 == BaseVarType.field25 && Client.field1011 == Client.field1003) {
                                    var19 = 0;
                                    var20 = 0;
                                    Font var51 = BoundingBox2D.font_p12full;
                                    String var52 = var10.text;

                                    for(var52 = DState.method3386(var52, var10); var52.length() > 0; var20 = var20 + var51.verticalSpace + 1) {
                                       var24 = var52.indexOf("<br>");
                                       if(var24 != -1) {
                                          var72 = var52.substring(0, var24);
                                          var52 = var52.substring(var24 + 4);
                                       } else {
                                          var72 = var52;
                                          var52 = "";
                                       }

                                       var25 = var51.getTextWidth(var72);
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
                                    var52 = var10.text;
                                    var26 = var25 + var51.verticalSpace + 2;

                                    for(var52 = DState.method3386(var52, var10); var52.length() > 0; var26 = var26 + var51.verticalSpace + 1) {
                                       var49 = var52.indexOf("<br>");
                                       if(var49 != -1) {
                                          var72 = var52.substring(0, var49);
                                          var52 = var52.substring(var49 + 4);
                                       } else {
                                          var72 = var52;
                                          var52 = "";
                                       }

                                       var51.method5225(var72, var24 + 3, var26, 0, -1);
                                    }
                                 }

                                 if(var10.type == 9) {
                                    if(var10.field2772) {
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
                                       var49 = var21 - var19;
                                       var28 = var22 - var20;
                                       var29 = var49 >= 0?var49:-var49;
                                       int var30 = var28 >= 0?var28:-var28;
                                       int var31 = var29;
                                       if(var29 < var30) {
                                          var31 = var30;
                                       }

                                       if(var31 != 0) {
                                          int var32 = (var49 << 16) / var31;
                                          int var33 = (var28 << 16) / var31;
                                          if(var33 <= var32) {
                                             var32 = -var32;
                                          } else {
                                             var33 = -var33;
                                          }

                                          int var34 = var26 * var33 >> 17;
                                          int var35 = var26 * var33 + 1 >> 17;
                                          int var36 = var26 * var32 >> 17;
                                          int var37 = var32 * var26 + 1 >> 17;
                                          var23 = var19 - Rasterizer2D.draw_region_x;
                                          var24 = var20 - Rasterizer2D.drawingAreaTop;
                                          int var38 = var34 + var23;
                                          int var39 = var23 - var35;
                                          int var40 = var49 + var23 - var35;
                                          int var41 = var49 + var23 + var34;
                                          int var42 = var24 + var36;
                                          int var43 = var24 - var37;
                                          int var44 = var28 + var24 - var37;
                                          int var45 = var36 + var28 + var24;
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
