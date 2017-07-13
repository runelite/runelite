import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("et")
@Implements("Frames")
public class Frames extends CacheableNode {
   @ObfuscatedName("v")
   static ModIcon[] field2137;
   @ObfuscatedName("a")
   @Export("skeletons")
   Frame[] skeletons;

   @ObfuscatedSignature(
      signature = "(LIndexDataBase;LIndexDataBase;IZ)V",
      garbageValue = "0"
   )
   public Frames(IndexDataBase var1, IndexDataBase var2, int var3, boolean var4) {
      Deque var5 = new Deque();
      int var6 = var1.fileCount(var3);
      this.skeletons = new Frame[var6];
      int[] var7 = var1.getChilds(var3);

      for(int var8 = 0; var8 < var7.length; ++var8) {
         byte[] var9 = var1.getConfigData(var3, var7[var8]);
         FrameMap var10 = null;
         int var11 = (var9[0] & 255) << 8 | var9[1] & 255;

         for(FrameMap var12 = (FrameMap)var5.getFront(); var12 != null; var12 = (FrameMap)var5.getNext()) {
            if(var11 == var12.id) {
               var10 = var12;
               break;
            }
         }

         if(var10 == null) {
            byte[] var13 = var2.getChild(var11, 0);
            var10 = new FrameMap(var11, var13);
            var5.addFront(var10);
         }

         this.skeletons[var7[var8]] = new Frame(var9, var10);
      }

   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(IB)Z",
      garbageValue = "1"
   )
   public boolean method2867(int var1) {
      return this.skeletons[var1].showing;
   }

   @ObfuscatedName("if")
   @ObfuscatedSignature(
      signature = "([LWidget;IIIIIIIIS)V",
      garbageValue = "28686"
   )
   @Export("gameDraw")
   static final void gameDraw(Widget[] var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
      Rasterizer2D.setDrawRegion(var2, var3, var4, var5);
      Graphics3D.method2594();

      for(int var9 = 0; var9 < var0.length; ++var9) {
         Widget var10 = var0[var9];
         if(var10 != null && (var10.parentId == var1 || var1 == -1412584499 && var10 == Client.field1079)) {
            int var11;
            if(var8 == -1) {
               Client.widgetPositionX[Client.field1006] = var10.relativeX + var6;
               Client.widgetPositionY[Client.field1006] = var7 + var10.relativeY;
               Client.widgetBoundsWidth[Client.field1006] = var10.width;
               Client.widgetBoundsHeight[Client.field1006] = var10.height;
               var11 = ++Client.field1006 - 1;
            } else {
               var11 = var8;
            }

            var10.boundsIndex = var11;
            var10.loopCycle = Client.gameCycle;
            if(!var10.hasScript || !class90.method1690(var10)) {
               if(var10.contentType > 0) {
                  class20.method150(var10);
               }

               int var12 = var10.relativeX + var6;
               int var13 = var7 + var10.relativeY;
               int var14 = var10.opacity;
               int var15;
               int var16;
               if(var10 == Client.field1079) {
                  if(var1 != -1412584499 && !var10.field2731) {
                     class203.field2508 = var0;
                     Ignore.field846 = var6;
                     class45.field579 = var7;
                     continue;
                  }

                  if(Client.field1174 && Client.field1084) {
                     var15 = MouseInput.field722;
                     var16 = MouseInput.field723;
                     var15 -= Client.field1081;
                     var16 -= Client.field1082;
                     if(var15 < Client.field1085) {
                        var15 = Client.field1085;
                     }

                     if(var15 + var10.width > Client.field1085 + Client.field920.width) {
                        var15 = Client.field1085 + Client.field920.width - var10.width;
                     }

                     if(var16 < Client.field1137) {
                        var16 = Client.field1137;
                     }

                     if(var16 + var10.height > Client.field1137 + Client.field920.height) {
                        var16 = Client.field1137 + Client.field920.height - var10.height;
                     }

                     var12 = var15;
                     var13 = var16;
                  }

                  if(!var10.field2731) {
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
                  int var23;
                  int var24;
                  int var25;
                  int var26;
                  int var31;
                  int var49;
                  int var51;
                  if(var10.contentType != 0) {
                     if(var10.contentType == 1336) {
                        if(Client.displayFps) {
                           var13 += 15;
                           class5.font_p12full.method4679("Fps:" + GameEngine.FPS, var12 + var10.width, var13, 16776960, -1);
                           var13 += 15;
                           Runtime var58 = Runtime.getRuntime();
                           var20 = (int)((var58.totalMemory() - var58.freeMemory()) / 1024L);
                           var21 = 16776960;
                           if(var20 > '耀' && Client.lowMemory) {
                              var21 = 16711680;
                           }

                           if(var20 > 65536 && !Client.lowMemory) {
                              var21 = 16711680;
                           }

                           class5.font_p12full.method4679("Mem:" + var20 + "k", var12 + var10.width, var13, var21, -1);
                           var13 += 15;
                        }
                        continue;
                     }

                     if(var10.contentType == 1337) {
                        Client.field1055 = var12;
                        Client.field915 = var13;
                        class64.method1082(var12, var13, var10.width, var10.height);
                        Client.field1111[var10.boundsIndex] = true;
                        Rasterizer2D.setDrawRegion(var2, var3, var4, var5);
                        continue;
                     }

                     if(var10.contentType == 1338) {
                        class46.method712();
                        class210 var57 = var10.method3980(false);
                        if(var57 != null) {
                           Rasterizer2D.setDrawRegion(var12, var13, var12 + var57.field2600, var13 + var57.field2599);
                           if(Client.field1140 != 2 && Client.field1140 != 5) {
                              var20 = Client.mapAngle + Client.mapScale & 2047;
                              var21 = Script.localPlayer.x / 32 + 48;
                              var22 = 464 - Script.localPlayer.y / 32;
                              class221.field2833.method5001(var12, var13, var57.field2600, var57.field2599, var21, var22, var20, Client.mapScaleDelta + 256, var57.field2602, var57.field2601);

                              for(var23 = 0; var23 < Client.field1134; ++var23) {
                                 var24 = Client.field1135[var23] * 4 + 2 - Script.localPlayer.x / 32;
                                 var25 = Client.field1136[var23] * 4 + 2 - Script.localPlayer.y / 32;
                                 ScriptVarType.drawDot(var12, var13, var24, var25, Client.field1035[var23], var57);
                              }

                              var23 = 0;

                              while(true) {
                                 if(var23 >= 104) {
                                    for(var23 = 0; var23 < Client.field944; ++var23) {
                                       NPC var66 = Client.cachedNPCs[Client.npcIndices[var23]];
                                       if(var66 != null && var66.hasConfig()) {
                                          NPCComposition var64 = var66.composition;
                                          if(var64 != null && var64.configs != null) {
                                             var64 = var64.transform();
                                          }

                                          if(var64 != null && var64.isMinimapVisible && var64.field3584) {
                                             var26 = var66.x / 32 - Script.localPlayer.x / 32;
                                             var49 = var66.y / 32 - Script.localPlayer.y / 32;
                                             ScriptVarType.drawDot(var12, var13, var26, var49, class163.mapDots[1], var57);
                                          }
                                       }
                                    }

                                    var23 = class96.field1499;
                                    int[] var67 = class96.field1492;

                                    for(var25 = 0; var25 < var23; ++var25) {
                                       Player var50 = Client.cachedPlayers[var67[var25]];
                                       if(var50 != null && var50.hasConfig() && !var50.hidden && var50 != Script.localPlayer) {
                                          var49 = var50.x / 32 - Script.localPlayer.x / 32;
                                          var51 = var50.y / 32 - Script.localPlayer.y / 32;
                                          boolean var62 = false;
                                          if(WorldMapType3.isFriended(var50.name, true)) {
                                             var62 = true;
                                          }

                                          boolean var61 = false;

                                          for(var31 = 0; var31 < Signlink.clanChatCount; ++var31) {
                                             if(var50.name.equals(class44.clanMembers[var31].username)) {
                                                var61 = true;
                                                break;
                                             }
                                          }

                                          boolean var63 = false;
                                          if(Script.localPlayer.team != 0 && var50.team != 0 && var50.team == Script.localPlayer.team) {
                                             var63 = true;
                                          }

                                          if(var62) {
                                             ScriptVarType.drawDot(var12, var13, var49, var51, class163.mapDots[3], var57);
                                          } else if(var63) {
                                             ScriptVarType.drawDot(var12, var13, var49, var51, class163.mapDots[4], var57);
                                          } else if(var61) {
                                             ScriptVarType.drawDot(var12, var13, var49, var51, class163.mapDots[5], var57);
                                          } else {
                                             ScriptVarType.drawDot(var12, var13, var49, var51, class163.mapDots[2], var57);
                                          }
                                       }
                                    }

                                    if(Client.field1120 != 0 && Client.gameCycle % 20 < 10) {
                                       if(Client.field1120 == 1 && Client.field924 >= 0 && Client.field924 < Client.cachedNPCs.length) {
                                          NPC var68 = Client.cachedNPCs[Client.field924];
                                          if(var68 != null) {
                                             var26 = var68.x / 32 - Script.localPlayer.x / 32;
                                             var49 = var68.y / 32 - Script.localPlayer.y / 32;
                                             class92.method1733(var12, var13, var26, var49, class64.field799[1], var57);
                                          }
                                       }

                                       if(Client.field1120 == 2) {
                                          var25 = Client.hintArrowX * 4 - class163.baseX * 4 + 2 - Script.localPlayer.x / 32;
                                          var26 = Client.hintArrowY * 4 - class10.baseY * 4 + 2 - Script.localPlayer.y / 32;
                                          class92.method1733(var12, var13, var25, var26, class64.field799[1], var57);
                                       }

                                       if(Client.field1120 == 10 && Client.field927 >= 0 && Client.field927 < Client.cachedPlayers.length) {
                                          Player var70 = Client.cachedPlayers[Client.field927];
                                          if(var70 != null) {
                                             var26 = var70.x / 32 - Script.localPlayer.x / 32;
                                             var49 = var70.y / 32 - Script.localPlayer.y / 32;
                                             class92.method1733(var12, var13, var26, var49, class64.field799[1], var57);
                                          }
                                       }
                                    }

                                    if(Client.destinationX != 0) {
                                       var25 = Client.destinationX * 4 + 2 - Script.localPlayer.x / 32;
                                       var26 = Client.destinationY * 4 + 2 - Script.localPlayer.y / 32;
                                       ScriptVarType.drawDot(var12, var13, var25, var26, class64.field799[0], var57);
                                    }

                                    if(!Script.localPlayer.hidden) {
                                       Rasterizer2D.method4921(var12 + var57.field2600 / 2 - 1, var13 + var57.field2599 / 2 - 1, 3, 3, 16777215);
                                    }
                                    break;
                                 }

                                 for(var24 = 0; var24 < 104; ++var24) {
                                    Deque var48 = Client.groundItemDeque[class45.plane][var23][var24];
                                    if(var48 != null) {
                                       var26 = var23 * 4 + 2 - Script.localPlayer.x / 32;
                                       var49 = 4 * var24 + 2 - Script.localPlayer.y / 32;
                                       ScriptVarType.drawDot(var12, var13, var26, var49, class163.mapDots[0], var57);
                                    }
                                 }

                                 ++var23;
                              }
                           } else {
                              Rasterizer2D.method4868(var12, var13, 0, var57.field2602, var57.field2601);
                           }

                           Client.field1112[var11] = true;
                        }

                        Rasterizer2D.setDrawRegion(var2, var3, var4, var5);
                        continue;
                     }

                     if(var10.contentType == 1339) {
                        class51.method785(var10, var12, var13, var11);
                        Rasterizer2D.setDrawRegion(var2, var3, var4, var5);
                        continue;
                     }

                     if(var10.contentType == 1400) {
                        class11.renderOverview.extractWorldmap(var12, var13, var10.width, var10.height, Client.gameCycle);
                     }

                     if(var10.contentType == 1401) {
                        class11.renderOverview.extractData(var12, var13, var10.width, var10.height);
                     }
                  }

                  if(var10.type == 0) {
                     if(!var10.hasScript && class90.method1690(var10) && var10 != XGrandExchangeOffer.field308) {
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
                        VertexNormal.drawWidget(var19.id, var15, var16, var17, var18, var12, var13, var11);
                     }

                     Rasterizer2D.setDrawRegion(var2, var3, var4, var5);
                     Graphics3D.method2594();
                  }

                  if(Client.isResized || Client.field938[var11] || Client.gameDrawingMode > 1) {
                     if(var10.type == 0 && !var10.hasScript && var10.scrollHeight > var10.height) {
                        Widget.method4009(var12 + var10.width, var13, var10.scrollY, var10.height, var10.scrollHeight);
                     }

                     if(var10.type != 1) {
                        int var29;
                        if(var10.type == 2) {
                           var46 = 0;

                           for(var20 = 0; var20 < var10.field2736; ++var20) {
                              for(var21 = 0; var21 < var10.originalWidth; ++var21) {
                                 var22 = var12 + var21 * (var10.paddingX + 32);
                                 var23 = var13 + var20 * (var10.paddingY + 32);
                                 if(var46 < 20) {
                                    var22 += var10.xSprites[var46];
                                    var23 += var10.field2722[var46];
                                 }

                                 if(var10.itemIds[var46] <= 0) {
                                    if(var10.field2723 != null && var46 < 20) {
                                       SpritePixels var65 = var10.method3976(var46);
                                       if(var65 != null) {
                                          var65.method5032(var22, var23);
                                       } else if(Widget.field2759) {
                                          class48.method749(var10);
                                       }
                                    }
                                 } else {
                                    boolean var59 = false;
                                    boolean var60 = false;
                                    var26 = var10.itemIds[var46] - 1;
                                    if(var22 + 32 > var2 && var22 < var4 && var23 + 32 > var3 && var23 < var5 || var10 == Ignore.field841 && var46 == Client.field943) {
                                       SpritePixels var27;
                                       if(Client.itemSelectionState == 1 && var46 == class11.selectedItemIndex && var10.id == class3.field17) {
                                          var27 = MilliTimer.createSprite(var26, var10.itemQuantities[var46], 2, 0, 2, false);
                                       } else {
                                          var27 = MilliTimer.createSprite(var26, var10.itemQuantities[var46], 1, 3153952, 2, false);
                                       }

                                       if(var27 != null) {
                                          if(var10 == Ignore.field841 && var46 == Client.field943) {
                                             var24 = MouseInput.field722 - Client.field1032;
                                             var25 = MouseInput.field723 - Client.field1021;
                                             if(var24 < 5 && var24 > -5) {
                                                var24 = 0;
                                             }

                                             if(var25 < 5 && var25 > -5) {
                                                var25 = 0;
                                             }

                                             if(Client.field1051 < 5) {
                                                var24 = 0;
                                                var25 = 0;
                                             }

                                             var27.method4989(var22 + var24, var25 + var23, 128);
                                             if(var1 != -1) {
                                                Widget var28 = var0[var1 & '\uffff'];
                                                if(var23 + var25 < Rasterizer2D.drawingAreaTop && var28.scrollY > 0) {
                                                   var29 = (Rasterizer2D.drawingAreaTop - var23 - var25) * Client.field982 / 3;
                                                   if(var29 > Client.field982 * 10) {
                                                      var29 = Client.field982 * 10;
                                                   }

                                                   if(var29 > var28.scrollY) {
                                                      var29 = var28.scrollY;
                                                   }

                                                   var28.scrollY -= var29;
                                                   Client.field1021 += var29;
                                                   class48.method749(var28);
                                                }

                                                if(var23 + var25 + 32 > Rasterizer2D.drawingAreaRight && var28.scrollY < var28.scrollHeight - var28.height) {
                                                   var29 = (var25 + var23 + 32 - Rasterizer2D.drawingAreaRight) * Client.field982 / 3;
                                                   if(var29 > Client.field982 * 10) {
                                                      var29 = Client.field982 * 10;
                                                   }

                                                   if(var29 > var28.scrollHeight - var28.height - var28.scrollY) {
                                                      var29 = var28.scrollHeight - var28.height - var28.scrollY;
                                                   }

                                                   var28.scrollY += var29;
                                                   Client.field1021 -= var29;
                                                   class48.method749(var28);
                                                }
                                             }
                                          } else if(var10 == class35.field482 && var46 == Client.field1048) {
                                             var27.method4989(var22, var23, 128);
                                          } else {
                                             var27.method5032(var22, var23);
                                          }
                                       } else {
                                          class48.method749(var10);
                                       }
                                    }
                                 }

                                 ++var46;
                              }
                           }
                        } else if(var10.type == 3) {
                           if(AbstractSoundSystem.method2039(var10)) {
                              var46 = var10.field2703;
                              if(var10 == XGrandExchangeOffer.field308 && var10.field2645 != 0) {
                                 var46 = var10.field2645;
                              }
                           } else {
                              var46 = var10.textColor;
                              if(var10 == XGrandExchangeOffer.field308 && var10.field2680 != 0) {
                                 var46 = var10.field2680;
                              }
                           }

                           if(var10.field2682) {
                              switch(var10.field2683.field3770) {
                              case 1:
                                 Rasterizer2D.method4855(var12, var13, var10.width, var10.height, var10.textColor, var10.field2703, 256 - (var10.opacity & 255), 256 - (var10.field2708 & 255));
                                 break;
                              case 2:
                                 Rasterizer2D.method4856(var12, var13, var10.width, var10.height, var10.textColor, var10.field2703, 256 - (var10.opacity & 255), 256 - (var10.field2708 & 255));
                                 break;
                              case 3:
                                 Rasterizer2D.method4923(var12, var13, var10.width, var10.height, var10.textColor, var10.field2703, 256 - (var10.opacity & 255), 256 - (var10.field2708 & 255));
                                 break;
                              case 4:
                                 Rasterizer2D.method4857(var12, var13, var10.width, var10.height, var10.textColor, var10.field2703, 256 - (var10.opacity & 255), 256 - (var10.field2708 & 255));
                                 break;
                              default:
                                 if(var14 == 0) {
                                    Rasterizer2D.method4921(var12, var13, var10.width, var10.height, var46);
                                 } else {
                                    Rasterizer2D.fillRectangle(var12, var13, var10.width, var10.height, var46, 256 - (var14 & 255));
                                 }
                              }
                           } else if(var14 == 0) {
                              Rasterizer2D.drawRectangle(var12, var13, var10.width, var10.height, var46);
                           } else {
                              Rasterizer2D.method4892(var12, var13, var10.width, var10.height, var46, 256 - (var14 & 255));
                           }
                        } else {
                           Font var55;
                           if(var10.type == 4) {
                              var55 = var10.method3977();
                              if(var55 == null) {
                                 if(Widget.field2759) {
                                    class48.method749(var10);
                                 }
                              } else {
                                 String var73 = var10.text;
                                 if(AbstractSoundSystem.method2039(var10)) {
                                    var20 = var10.field2703;
                                    if(var10 == XGrandExchangeOffer.field308 && var10.field2645 != 0) {
                                       var20 = var10.field2645;
                                    }

                                    if(var10.field2686.length() > 0) {
                                       var73 = var10.field2686;
                                    }
                                 } else {
                                    var20 = var10.textColor;
                                    if(var10 == XGrandExchangeOffer.field308 && var10.field2680 != 0) {
                                       var20 = var10.field2680;
                                    }
                                 }

                                 if(var10.hasScript && var10.itemId != -1) {
                                    ItemComposition var75 = class83.getItemDefinition(var10.itemId);
                                    var73 = var75.name;
                                    if(var73 == null) {
                                       var73 = "null";
                                    }

                                    if((var75.isStackable == 1 || var10.itemQuantity != 1) && var10.itemQuantity != -1) {
                                       var73 = class46.getColTags(16748608) + var73 + "</col>" + " " + 'x' + class56.method830(var10.itemQuantity);
                                    }
                                 }

                                 if(var10 == Client.field1070) {
                                    Object var10000 = null;
                                    var73 = "Please wait...";
                                    var20 = var10.textColor;
                                 }

                                 if(!var10.hasScript) {
                                    var73 = class71.method1103(var73, var10);
                                 }

                                 var55.method4681(var73, var12, var13, var10.width, var10.height, var20, var10.textShadowed?0:-1, var10.field2716, var10.field2749, var10.field2651);
                              }
                           } else if(var10.type == 5) {
                              SpritePixels var56;
                              if(!var10.hasScript) {
                                 var56 = var10.method4011(AbstractSoundSystem.method2039(var10));
                                 if(var56 != null) {
                                    var56.method5032(var12, var13);
                                 } else if(Widget.field2759) {
                                    class48.method749(var10);
                                 }
                              } else {
                                 if(var10.itemId != -1) {
                                    var56 = MilliTimer.createSprite(var10.itemId, var10.itemQuantity, var10.borderThickness, var10.sprite2, var10.field2711, false);
                                 } else {
                                    var56 = var10.method4011(false);
                                 }

                                 if(var56 == null) {
                                    if(Widget.field2759) {
                                       class48.method749(var10);
                                    }
                                 } else {
                                    var20 = var56.maxWidth;
                                    var21 = var56.maxHeight;
                                    if(!var10.field2691) {
                                       var22 = var10.width * 4096 / var20;
                                       if(var10.textureId != 0) {
                                          var56.method5023(var12 + var10.width / 2, var13 + var10.height / 2, var10.textureId, var22);
                                       } else if(var14 != 0) {
                                          var56.method4970(var12, var13, var10.width, var10.height, 256 - (var14 & 255));
                                       } else if(var20 == var10.width && var21 == var10.height) {
                                          var56.method5032(var12, var13);
                                       } else {
                                          var56.method5030(var12, var13, var10.width, var10.height);
                                       }
                                    } else {
                                       Rasterizer2D.setInnerDrawRegion(var12, var13, var12 + var10.width, var13 + var10.height);
                                       var22 = (var20 - 1 + var10.width) / var20;
                                       var23 = (var21 - 1 + var10.height) / var21;

                                       for(var24 = 0; var24 < var22; ++var24) {
                                          for(var25 = 0; var25 < var23; ++var25) {
                                             if(var10.textureId != 0) {
                                                var56.method5023(var12 + var24 * var20 + var20 / 2, var13 + var21 * var25 + var21 / 2, var10.textureId, 4096);
                                             } else if(var14 != 0) {
                                                var56.method4989(var12 + var20 * var24, var13 + var21 * var25, 256 - (var14 & 255));
                                             } else {
                                                var56.method5032(var12 + var24 * var20, var13 + var21 * var25);
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
                                 boolean var69 = AbstractSoundSystem.method2039(var10);
                                 if(var69) {
                                    var20 = var10.field2701;
                                 } else {
                                    var20 = var10.field2777;
                                 }

                                 Model var71 = null;
                                 var22 = 0;
                                 if(var10.itemId != -1) {
                                    var53 = class83.getItemDefinition(var10.itemId);
                                    if(var53 != null) {
                                       var53 = var53.method4514(var10.itemQuantity);
                                       var71 = var53.getModel(1);
                                       if(var71 != null) {
                                          var71.method2542();
                                          var22 = var71.modelHeight / 2;
                                       } else {
                                          class48.method749(var10);
                                       }
                                    }
                                 } else if(var10.modelType == 5) {
                                    if(var10.modelId == 0) {
                                       var71 = Client.field1177.method3940((Sequence)null, -1, (Sequence)null, -1);
                                    } else {
                                       var71 = Script.localPlayer.getModel();
                                    }
                                 } else if(var20 == -1) {
                                    var71 = var10.method3979((Sequence)null, -1, var69, Script.localPlayer.composition);
                                    if(var71 == null && Widget.field2759) {
                                       class48.method749(var10);
                                    }
                                 } else {
                                    Sequence var74 = class112.getAnimation(var20);
                                    var71 = var10.method3979(var74, var10.field2772, var69, Script.localPlayer.composition);
                                    if(var71 == null && Widget.field2759) {
                                       class48.method749(var10);
                                    }
                                 }

                                 Graphics3D.method2599(var12 + var10.width / 2, var13 + var10.height / 2);
                                 var23 = Graphics3D.SINE[var10.rotationX] * var10.modelZoom >> 16;
                                 var24 = Graphics3D.COSINE[var10.rotationX] * var10.modelZoom >> 16;
                                 if(var71 != null) {
                                    if(!var10.hasScript) {
                                       var71.method2512(0, var10.rotationZ, 0, var10.rotationX, 0, var23, var24);
                                    } else {
                                       var71.method2542();
                                       if(var10.field2687) {
                                          var71.method2513(0, var10.rotationZ, var10.rotationY, var10.rotationX, var10.field2702, var10.field2670 + var22 + var23, var24 + var10.field2670, var10.modelZoom);
                                       } else {
                                          var71.method2512(0, var10.rotationZ, var10.rotationY, var10.rotationX, var10.field2702, var10.field2670 + var23 + var22, var24 + var10.field2670);
                                       }
                                    }
                                 }

                                 Graphics3D.method2596();
                              } else {
                                 if(var10.type == 7) {
                                    var55 = var10.method3977();
                                    if(var55 == null) {
                                       if(Widget.field2759) {
                                          class48.method749(var10);
                                       }
                                       continue;
                                    }

                                    var20 = 0;

                                    for(var21 = 0; var21 < var10.field2736; ++var21) {
                                       for(var22 = 0; var22 < var10.originalWidth; ++var22) {
                                          if(var10.itemIds[var20] > 0) {
                                             var53 = class83.getItemDefinition(var10.itemIds[var20] - 1);
                                             String var47;
                                             if(var53.isStackable != 1 && var10.itemQuantities[var20] == 1) {
                                                var47 = class46.getColTags(16748608) + var53.name + "</col>";
                                             } else {
                                                var47 = class46.getColTags(16748608) + var53.name + "</col>" + " " + 'x' + class56.method830(var10.itemQuantities[var20]);
                                             }

                                             var25 = var22 * (115 + var10.paddingX) + var12;
                                             var26 = var21 * (12 + var10.paddingY) + var13;
                                             if(var10.field2716 == 0) {
                                                var55.method4725(var47, var25, var26, var10.textColor, var10.textShadowed?0:-1);
                                             } else if(var10.field2716 == 1) {
                                                var55.method4734(var47, var25 + var10.width / 2, var26, var10.textColor, var10.textShadowed?0:-1);
                                             } else {
                                                var55.method4679(var47, var25 + var10.width - 1, var26, var10.textColor, var10.textShadowed?0:-1);
                                             }
                                          }

                                          ++var20;
                                       }
                                    }
                                 }

                                 if(var10.type == 8 && var10 == class35.field483 && Client.field1183 == Client.field1132) {
                                    var46 = 0;
                                    var20 = 0;
                                    Font var52 = class5.font_p12full;
                                    String var54 = var10.text;

                                    String var72;
                                    for(var54 = class71.method1103(var54, var10); var54.length() > 0; var20 += 1 + var52.verticalSpace) {
                                       var24 = var54.indexOf("<br>");
                                       if(var24 != -1) {
                                          var72 = var54.substring(0, var24);
                                          var54 = var54.substring(var24 + 4);
                                       } else {
                                          var72 = var54;
                                          var54 = "";
                                       }

                                       var25 = var52.method4721(var72);
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

                                    Rasterizer2D.method4921(var24, var25, var46, var20, 16777120);
                                    Rasterizer2D.drawRectangle(var24, var25, var46, var20, 0);
                                    var54 = var10.text;
                                    var26 = var25 + var52.verticalSpace + 2;

                                    for(var54 = class71.method1103(var54, var10); var54.length() > 0; var26 += var52.verticalSpace + 1) {
                                       var49 = var54.indexOf("<br>");
                                       if(var49 != -1) {
                                          var72 = var54.substring(0, var49);
                                          var54 = var54.substring(var49 + 4);
                                       } else {
                                          var72 = var54;
                                          var54 = "";
                                       }

                                       var52.method4725(var72, var24 + 3, var26, 0, -1);
                                    }
                                 }

                                 if(var10.type == 9) {
                                    if(var10.field2721) {
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

                                    if(var10.field2643 == 1) {
                                       Rasterizer2D.drawLine(var46, var20, var21, var22, var10.textColor);
                                    } else {
                                       var25 = var10.textColor;
                                       var26 = var10.field2643;
                                       var49 = var21 - var46;
                                       var51 = var22 - var20;
                                       var29 = var49 >= 0?var49:-var49;
                                       int var30 = var51 >= 0?var51:-var51;
                                       var31 = var29;
                                       if(var29 < var30) {
                                          var31 = var30;
                                       }

                                       if(var31 != 0) {
                                          int var32 = (var49 << 16) / var31;
                                          int var33 = (var51 << 16) / var31;
                                          if(var33 <= var32) {
                                             var32 = -var32;
                                          } else {
                                             var33 = -var33;
                                          }

                                          int var34 = var33 * var26 >> 17;
                                          int var35 = var26 * var33 + 1 >> 17;
                                          int var36 = var26 * var32 >> 17;
                                          int var37 = var32 * var26 + 1 >> 17;
                                          var23 = var46 - Rasterizer2D.draw_region_x;
                                          var24 = var20 - Rasterizer2D.drawingAreaTop;
                                          int var38 = var34 + var23;
                                          int var39 = var23 - var35;
                                          int var40 = var49 + var23 - var35;
                                          int var41 = var34 + var23 + var49;
                                          int var42 = var24 + var36;
                                          int var43 = var24 - var37;
                                          int var44 = var24 + var51 - var37;
                                          int var45 = var36 + var51 + var24;
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
