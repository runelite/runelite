import java.util.Iterator;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ej")
@Implements("WallObject")
public final class WallObject {
   @ObfuscatedName("iu")
   @ObfuscatedGetter(
      intValue = 763721957
   )
   @Export("plane")
   static int plane;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 621720823
   )
   @Export("x")
   int x;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -1238281823
   )
   @Export("hash")
   public int hash;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -58193371
   )
   @Export("y")
   int y;
   @ObfuscatedName("r")
   @Export("renderable1")
   public Renderable renderable1;
   @ObfuscatedName("v")
   @Export("renderable2")
   public Renderable renderable2;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 1426439445
   )
   @Export("config")
   int config;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 524303663
   )
   @Export("floor")
   int floor;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 1917065447
   )
   @Export("orientationA")
   int orientationA;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -510242745
   )
   @Export("orientationB")
   int orientationB;

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(I)Ljava/lang/String;",
      garbageValue = "-749082801"
   )
   static String method2865() {
      String var0 = "";

      MessageNode var1;
      for(Iterator var2 = class98.field1546.iterator(); var2.hasNext(); var0 = var0 + var1.name + ':' + var1.value + '\n') {
         var1 = (MessageNode)var2.next();
      }

      return var0;
   }

   @ObfuscatedName("ic")
   @ObfuscatedSignature(
      signature = "(LWidget;IIZI)V",
      garbageValue = "41713648"
   )
   static void method2866(Widget var0, int var1, int var2, boolean var3) {
      int var4 = var0.width;
      int var5 = var0.height;
      if(var0.field2683 == 0) {
         var0.width = var0.originalWidth;
      } else if(var0.field2683 == 1) {
         var0.width = var1 - var0.originalWidth;
      } else if(var0.field2683 == 2) {
         var0.width = var0.originalWidth * var1 >> 14;
      }

      if(var0.buttonType == 0) {
         var0.height = var0.field2707;
      } else if(var0.buttonType == 1) {
         var0.height = var2 - var0.field2707;
      } else if(var0.buttonType == 2) {
         var0.height = var2 * var0.field2707 >> 14;
      }

      if(var0.field2683 == 4) {
         var0.width = var0.height * var0.field2671 / var0.field2672;
      }

      if(var0.buttonType == 4) {
         var0.height = var0.width * var0.field2672 / var0.field2671;
      }

      if(Client.field1097 && var0.type == 0) {
         if(var0.height < 5 && var0.width < 5) {
            var0.height = 5;
            var0.width = 5;
         } else {
            if(var0.height <= 0) {
               var0.height = 5;
            }

            if(var0.width <= 0) {
               var0.width = 5;
            }
         }
      }

      if(var0.contentType == 1337) {
         Client.field1099 = var0;
      }

      if(var3 && var0.field2763 != null && (var0.width != var4 || var5 != var0.height)) {
         ScriptEvent var6 = new ScriptEvent();
         var6.widget = var0;
         var6.field857 = var0.field2763;
         Client.field1035.addFront(var6);
      }

   }

   @ObfuscatedName("hu")
   @ObfuscatedSignature(
      signature = "([LWidget;IIIIIIIII)V",
      garbageValue = "-346520034"
   )
   @Export("gameDraw")
   static final void gameDraw(Widget[] var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
      Rasterizer2D.setDrawRegion(var2, var3, var4, var5);
      Graphics3D.method2582();

      for(int var9 = 0; var9 < var0.length; ++var9) {
         Widget var10 = var0[var9];
         if(var10 != null && (var1 == var10.parentId || var1 == -1412584499 && var10 == Client.field1100)) {
            int var11;
            if(var8 == -1) {
               Client.widgetPositionX[Client.field1061] = var6 + var10.relativeX;
               Client.widgetPositionY[Client.field1061] = var7 + var10.relativeY;
               Client.widgetBoundsWidth[Client.field1061] = var10.width;
               Client.widgetBoundsHeight[Client.field1061] = var10.height;
               var11 = ++Client.field1061 - 1;
            } else {
               var11 = var8;
            }

            var10.boundsIndex = var11;
            var10.loopCycle = Client.gameCycle;
            if(!var10.hasScript || !class39.method555(var10)) {
               if(var10.contentType > 0) {
                  class20.method143(var10);
               }

               int var12 = var6 + var10.relativeX;
               int var13 = var7 + var10.relativeY;
               int var14 = var10.opacity;
               int var15;
               int var16;
               if(var10 == Client.field1100) {
                  if(var1 != -1412584499 && !var10.field2737) {
                     class262.field3641 = var0;
                     class77.field1237 = var6;
                     class270.field3689 = var7;
                     continue;
                  }

                  if(Client.field1111 && Client.field1069) {
                     var15 = MouseInput.field748;
                     var16 = MouseInput.field749;
                     var15 -= Client.field1102;
                     var16 -= Client.field1103;
                     if(var15 < Client.field1175) {
                        var15 = Client.field1175;
                     }

                     if(var15 + var10.width > Client.field1175 + Client.field1101.width) {
                        var15 = Client.field1175 + Client.field1101.width - var10.width;
                     }

                     if(var16 < Client.field1107) {
                        var16 = Client.field1107;
                     }

                     if(var16 + var10.height > Client.field1107 + Client.field1101.height) {
                        var16 = Client.field1107 + Client.field1101.height - var10.height;
                     }

                     var12 = var15;
                     var13 = var16;
                  }

                  if(!var10.field2737) {
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
                  boolean var60;
                  if(var10.contentType != 0) {
                     if(var10.contentType == 1336) {
                        if(Client.displayFps) {
                           var13 += 15;
                           class37.font_p12full.method4756("Fps:" + GameEngine.FPS, var12 + var10.width, var13, 16776960, -1);
                           var13 += 15;
                           Runtime var57 = Runtime.getRuntime();
                           var20 = (int)((var57.totalMemory() - var57.freeMemory()) / 1024L);
                           var21 = 16776960;
                           if(var20 > '耀' && Client.lowMemory) {
                              var21 = 16711680;
                           }

                           if(var20 > 65536 && !Client.lowMemory) {
                              var21 = 16711680;
                           }

                           class37.font_p12full.method4756("Mem:" + var20 + "k", var12 + var10.width, var13, var21, -1);
                           var13 += 15;
                        }
                        continue;
                     }

                     if(var10.contentType == 1337) {
                        Client.field1076 = var12;
                        Client.field1003 = var13;
                        class31.method271(var12, var13, var10.width, var10.height);
                        Client.field1132[var10.boundsIndex] = true;
                        Rasterizer2D.setDrawRegion(var2, var3, var4, var5);
                        continue;
                     }

                     class210 var55;
                     if(var10.contentType == 1338) {
                        class14.method67();
                        var55 = var10.method3981(false);
                        if(var55 != null) {
                           Rasterizer2D.setDrawRegion(var12, var13, var55.field2607 + var12, var13 + var55.field2602);
                           if(Client.field1161 != 2 && Client.field1161 != 5) {
                              var20 = Client.mapAngle + Client.mapScale & 2047;
                              var21 = XItemContainer.localPlayer.x / 32 + 48;
                              var22 = 464 - XItemContainer.localPlayer.y / 32;
                              MouseInput.field758.method5096(var12, var13, var55.field2607, var55.field2602, var21, var22, var20, Client.mapScaleDelta + 256, var55.field2604, var55.field2608);

                              for(var23 = 0; var23 < Client.field1155; ++var23) {
                                 var24 = Client.field1156[var23] * 4 + 2 - XItemContainer.localPlayer.x / 32;
                                 var25 = Client.field1011[var23] * 4 + 2 - XItemContainer.localPlayer.y / 32;
                                 class40.drawDot(var12, var13, var24, var25, Client.field927[var23], var55);
                              }

                              var23 = 0;

                              while(true) {
                                 if(var23 >= 104) {
                                    for(var23 = 0; var23 < Client.field937; ++var23) {
                                       NPC var52 = Client.cachedNPCs[Client.npcIndices[var23]];
                                       if(var52 != null && var52.hasConfig()) {
                                          NPCComposition var67 = var52.composition;
                                          if(var67 != null && var67.configs != null) {
                                             var67 = var67.transform();
                                          }

                                          if(var67 != null && var67.isMinimapVisible && var67.field3588) {
                                             var26 = var52.x / 32 - XItemContainer.localPlayer.x / 32;
                                             var28 = var52.y / 32 - XItemContainer.localPlayer.y / 32;
                                             class40.drawDot(var12, var13, var26, var28, WorldMapType3.mapDots[1], var55);
                                          }
                                       }
                                    }

                                    var23 = class96.field1521;
                                    int[] var53 = class96.field1531;

                                    Player var70;
                                    for(var25 = 0; var25 < var23; ++var25) {
                                       var70 = Client.cachedPlayers[var53[var25]];
                                       if(var70 != null && var70.hasConfig() && !var70.hidden && var70 != XItemContainer.localPlayer) {
                                          var28 = var70.x / 32 - XItemContainer.localPlayer.x / 32;
                                          var29 = var70.y / 32 - XItemContainer.localPlayer.y / 32;
                                          var60 = false;
                                          if(class25.isFriended(var70.name, true)) {
                                             var60 = true;
                                          }

                                          boolean var73 = false;

                                          for(var27 = 0; var27 < class28.clanChatCount; ++var27) {
                                             if(var70.name.equals(class11.clanMembers[var27].username)) {
                                                var73 = true;
                                                break;
                                             }
                                          }

                                          boolean var69 = false;
                                          if(XItemContainer.localPlayer.team != 0 && var70.team != 0 && var70.team == XItemContainer.localPlayer.team) {
                                             var69 = true;
                                          }

                                          if(var60) {
                                             class40.drawDot(var12, var13, var28, var29, WorldMapType3.mapDots[3], var55);
                                          } else if(var69) {
                                             class40.drawDot(var12, var13, var28, var29, WorldMapType3.mapDots[4], var55);
                                          } else if(var73) {
                                             class40.drawDot(var12, var13, var28, var29, WorldMapType3.mapDots[5], var55);
                                          } else {
                                             class40.drawDot(var12, var13, var28, var29, WorldMapType3.mapDots[2], var55);
                                          }
                                       }
                                    }

                                    if(Client.field943 != 0 && Client.gameCycle % 20 < 10) {
                                       if(Client.field943 == 1 && Client.field944 >= 0 && Client.field944 < Client.cachedNPCs.length) {
                                          NPC var71 = Client.cachedNPCs[Client.field944];
                                          if(var71 != null) {
                                             var26 = var71.x / 32 - XItemContainer.localPlayer.x / 32;
                                             var28 = var71.y / 32 - XItemContainer.localPlayer.y / 32;
                                             MessageNode.method1144(var12, var13, var26, var28, class31.field458[1], var55);
                                          }
                                       }

                                       if(Client.field943 == 2) {
                                          var25 = Client.hintArrowX * 4 - KeyFocusListener.baseX * 4 + 2 - XItemContainer.localPlayer.x / 32;
                                          var26 = Client.hintArrowY * 4 - class266.baseY * 4 + 2 - XItemContainer.localPlayer.y / 32;
                                          MessageNode.method1144(var12, var13, var25, var26, class31.field458[1], var55);
                                       }

                                       if(Client.field943 == 10 && Client.field1183 >= 0 && Client.field1183 < Client.cachedPlayers.length) {
                                          var70 = Client.cachedPlayers[Client.field1183];
                                          if(var70 != null) {
                                             var26 = var70.x / 32 - XItemContainer.localPlayer.x / 32;
                                             var28 = var70.y / 32 - XItemContainer.localPlayer.y / 32;
                                             MessageNode.method1144(var12, var13, var26, var28, class31.field458[1], var55);
                                          }
                                       }
                                    }

                                    if(Client.destinationX != 0) {
                                       var25 = Client.destinationX * 4 + 2 - XItemContainer.localPlayer.x / 32;
                                       var26 = Client.destinationY * 4 + 2 - XItemContainer.localPlayer.y / 32;
                                       class40.drawDot(var12, var13, var25, var26, class31.field458[0], var55);
                                    }

                                    if(!XItemContainer.localPlayer.hidden) {
                                       Rasterizer2D.method4983(var55.field2607 / 2 + var12 - 1, var13 + var55.field2602 / 2 - 1, 3, 3, 16777215);
                                    }
                                    break;
                                 }

                                 for(var24 = 0; var24 < 104; ++var24) {
                                    Deque var51 = Client.groundItemDeque[plane][var23][var24];
                                    if(var51 != null) {
                                       var26 = var23 * 4 + 2 - XItemContainer.localPlayer.x / 32;
                                       var28 = var24 * 4 + 2 - XItemContainer.localPlayer.y / 32;
                                       class40.drawDot(var12, var13, var26, var28, WorldMapType3.mapDots[0], var55);
                                    }
                                 }

                                 ++var23;
                              }
                           } else {
                              Rasterizer2D.method4947(var12, var13, 0, var55.field2604, var55.field2608);
                           }

                           Client.field1133[var11] = true;
                        }

                        Rasterizer2D.setDrawRegion(var2, var3, var4, var5);
                        continue;
                     }

                     if(var10.contentType == 1339) {
                        var55 = var10.method3981(false);
                        if(var55 != null) {
                           if(Client.field1161 < 3) {
                              class19.compass.method5096(var12, var13, var55.field2607, var55.field2602, 25, 25, Client.mapAngle, 256, var55.field2604, var55.field2608);
                           } else {
                              Rasterizer2D.method4947(var12, var13, 0, var55.field2604, var55.field2608);
                           }
                        }

                        Rasterizer2D.setDrawRegion(var2, var3, var4, var5);
                        continue;
                     }

                     if(var10.contentType == 1400) {
                        class43.renderOverview.extractWorldmap(var12, var13, var10.width, var10.height, Client.gameCycle);
                     }

                     if(var10.contentType == 1401) {
                        class43.renderOverview.extractData(var12, var13, var10.width, var10.height);
                     }
                  }

                  if(var10.type == 0) {
                     if(!var10.hasScript && class39.method555(var10) && var10 != KitDefinition.field3371) {
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

                     WidgetNode var30 = (WidgetNode)Client.componentTable.get((long)var10.id);
                     if(var30 != null) {
                        Signlink.drawWidget(var30.id, var15, var16, var17, var18, var12, var13, var11);
                     }

                     Rasterizer2D.setDrawRegion(var2, var3, var4, var5);
                     Graphics3D.method2582();
                  }

                  if(Client.isResized || Client.field1030[var11] || Client.gameDrawingMode > 1) {
                     if(var10.type == 0 && !var10.hasScript && var10.scrollHeight > var10.height) {
                        var19 = var12 + var10.width;
                        var20 = var10.scrollY;
                        var21 = var10.height;
                        var22 = var10.scrollHeight;
                        class262.field3639[0].method5025(var19, var13);
                        class262.field3639[1].method5025(var19, var13 + var21 - 16);
                        Rasterizer2D.method4983(var19, var13 + 16, 16, var21 - 32, Client.field1108);
                        var23 = (var21 - 32) * var21 / var22;
                        if(var23 < 8) {
                           var23 = 8;
                        }

                        var24 = var20 * (var21 - 32 - var23) / (var22 - var21);
                        Rasterizer2D.method4983(var19, var24 + 16 + var13, 16, var23, Client.field990);
                        Rasterizer2D.method4943(var19, var24 + var13 + 16, var23, Client.field1006);
                        Rasterizer2D.method4943(var19 + 1, var24 + var13 + 16, var23, Client.field1006);
                        Rasterizer2D.method4941(var19, var24 + var13 + 16, 16, Client.field1006);
                        Rasterizer2D.method4941(var19, var24 + var13 + 17, 16, Client.field1006);
                        Rasterizer2D.method4943(var19 + 15, var24 + var13 + 16, var23, Client.field1005);
                        Rasterizer2D.method4943(var19 + 14, var24 + var13 + 17, var23 - 1, Client.field1005);
                        Rasterizer2D.method4941(var19, var23 + var24 + 15 + var13, 16, Client.field1005);
                        Rasterizer2D.method4941(var19 + 1, var23 + var24 + var13 + 14, 15, Client.field1005);
                     }

                     if(var10.type != 1) {
                        int var48;
                        if(var10.type == 2) {
                           var19 = 0;

                           for(var20 = 0; var20 < var10.field2707; ++var20) {
                              for(var21 = 0; var21 < var10.originalWidth; ++var21) {
                                 var22 = (var10.paddingX + 32) * var21 + var12;
                                 var23 = var13 + (var10.paddingY + 32) * var20;
                                 if(var19 < 20) {
                                    var22 += var10.xSprites[var19];
                                    var23 += var10.field2723[var19];
                                 }

                                 if(var10.itemIds[var19] <= 0) {
                                    if(var10.field2724 != null && var19 < 20) {
                                       SpritePixels var50 = var10.method3989(var19);
                                       if(var50 != null) {
                                          var50.method5042(var22, var23);
                                       } else if(Widget.field2684) {
                                          class88.method1714(var10);
                                       }
                                    }
                                 } else {
                                    boolean var49 = false;
                                    boolean var65 = false;
                                    var26 = var10.itemIds[var19] - 1;
                                    if(var22 + 32 > var2 && var22 < var4 && var23 + 32 > var3 && var23 < var5 || var10 == class95.field1513 && var19 == Client.field1039) {
                                       SpritePixels var62;
                                       if(Client.itemSelectionState == 1 && var19 == FileSystem.selectedItemIndex && class40.field571 == var10.id) {
                                          var62 = class21.createSprite(var26, var10.itemQuantities[var19], 2, 0, 2, false);
                                       } else {
                                          var62 = class21.createSprite(var26, var10.itemQuantities[var19], 1, 3153952, 2, false);
                                       }

                                       if(var62 != null) {
                                          if(var10 == class95.field1513 && var19 == Client.field1039) {
                                             var24 = MouseInput.field748 - Client.field1040;
                                             var25 = MouseInput.field749 - Client.field1041;
                                             if(var24 < 5 && var24 > -5) {
                                                var24 = 0;
                                             }

                                             if(var25 < 5 && var25 > -5) {
                                                var25 = 0;
                                             }

                                             if(Client.field1044 < 5) {
                                                var24 = 0;
                                                var25 = 0;
                                             }

                                             var62.method5057(var24 + var22, var25 + var23, 128);
                                             if(var1 != -1) {
                                                Widget var72 = var0[var1 & '\uffff'];
                                                if(var25 + var23 < Rasterizer2D.drawingAreaTop && var72.scrollY > 0) {
                                                   var48 = (Rasterizer2D.drawingAreaTop - var23 - var25) * Client.field1002 / 3;
                                                   if(var48 > Client.field1002 * 10) {
                                                      var48 = Client.field1002 * 10;
                                                   }

                                                   if(var48 > var72.scrollY) {
                                                      var48 = var72.scrollY;
                                                   }

                                                   var72.scrollY -= var48;
                                                   Client.field1041 += var48;
                                                   class88.method1714(var72);
                                                }

                                                if(var25 + var23 + 32 > Rasterizer2D.drawingAreaRight && var72.scrollY < var72.scrollHeight - var72.height) {
                                                   var48 = (var23 + var25 + 32 - Rasterizer2D.drawingAreaRight) * Client.field1002 / 3;
                                                   if(var48 > Client.field1002 * 10) {
                                                      var48 = Client.field1002 * 10;
                                                   }

                                                   if(var48 > var72.scrollHeight - var72.height - var72.scrollY) {
                                                      var48 = var72.scrollHeight - var72.height - var72.scrollY;
                                                   }

                                                   var72.scrollY += var48;
                                                   Client.field1041 -= var48;
                                                   class88.method1714(var72);
                                                }
                                             }
                                          } else if(var10 == Buffer.field2405 && var19 == Client.field1114) {
                                             var62.method5057(var22, var23, 128);
                                          } else {
                                             var62.method5042(var22, var23);
                                          }
                                       } else {
                                          class88.method1714(var10);
                                       }
                                    }
                                 }

                                 ++var19;
                              }
                           }
                        } else if(var10.type == 3) {
                           if(WorldMapData.method272(var10)) {
                              var19 = var10.field2680;
                              if(var10 == KitDefinition.field3371 && var10.field2682 != 0) {
                                 var19 = var10.field2682;
                              }
                           } else {
                              var19 = var10.textColor;
                              if(var10 == KitDefinition.field3371 && var10.field2681 != 0) {
                                 var19 = var10.field2681;
                              }
                           }

                           if(var10.field2647) {
                              switch(var10.field2757.field3767) {
                              case 1:
                                 Rasterizer2D.method5003(var12, var13, var10.width, var10.height, var10.textColor, var10.field2680, 256 - (var10.opacity & 255), 256 - (var10.field2686 & 255));
                                 break;
                              case 2:
                                 Rasterizer2D.method4934(var12, var13, var10.width, var10.height, var10.textColor, var10.field2680, 256 - (var10.opacity & 255), 256 - (var10.field2686 & 255));
                                 break;
                              case 3:
                                 Rasterizer2D.method4935(var12, var13, var10.width, var10.height, var10.textColor, var10.field2680, 256 - (var10.opacity & 255), 256 - (var10.field2686 & 255));
                                 break;
                              case 4:
                                 Rasterizer2D.method4936(var12, var13, var10.width, var10.height, var10.textColor, var10.field2680, 256 - (var10.opacity & 255), 256 - (var10.field2686 & 255));
                                 break;
                              default:
                                 if(var14 == 0) {
                                    Rasterizer2D.method4983(var12, var13, var10.width, var10.height, var19);
                                 } else {
                                    Rasterizer2D.fillRectangle(var12, var13, var10.width, var10.height, var19, 256 - (var14 & 255));
                                 }
                              }
                           } else if(var14 == 0) {
                              Rasterizer2D.drawRectangle(var12, var13, var10.width, var10.height, var19);
                           } else {
                              Rasterizer2D.method4995(var12, var13, var10.width, var10.height, var19, 256 - (var14 & 255));
                           }
                        } else {
                           Font var31;
                           String var33;
                           if(var10.type == 4) {
                              var31 = var10.method3988();
                              if(var31 == null) {
                                 if(Widget.field2684) {
                                    class88.method1714(var10);
                                 }
                              } else {
                                 String var56 = var10.text;
                                 if(WorldMapData.method272(var10)) {
                                    var20 = var10.field2680;
                                    if(var10 == KitDefinition.field3371 && var10.field2682 != 0) {
                                       var20 = var10.field2682;
                                    }

                                    if(var10.field2729.length() > 0) {
                                       var56 = var10.field2729;
                                    }
                                 } else {
                                    var20 = var10.textColor;
                                    if(var10 == KitDefinition.field3371 && var10.field2681 != 0) {
                                       var20 = var10.field2681;
                                    }
                                 }

                                 if(var10.hasScript && var10.itemId != -1) {
                                    ItemComposition var61 = AbstractByteBuffer.getItemDefinition(var10.itemId);
                                    var56 = var61.name;
                                    if(var56 == null) {
                                       var56 = "null";
                                    }

                                    if((var61.isStackable == 1 || var10.itemQuantity != 1) && var10.itemQuantity != -1) {
                                       var56 = class220.getColTags(16748608) + var56 + "</col> " + 'x' + class45.method684(var10.itemQuantity);
                                    }
                                 }

                                 if(var10 == Client.field1091) {
                                    var33 = null;
                                    var56 = "Please wait...";
                                    var20 = var10.textColor;
                                 }

                                 if(!var10.hasScript) {
                                    var56 = KeyFocusListener.method788(var56, var10);
                                 }

                                 var31.method4788(var56, var12, var13, var10.width, var10.height, var20, var10.textShadowed?0:-1, var10.field2652, var10.field2726, var10.field2716);
                              }
                           } else if(var10.type == 5) {
                              SpritePixels var54;
                              if(!var10.hasScript) {
                                 var54 = var10.method3991(WorldMapData.method272(var10));
                                 if(var54 != null) {
                                    var54.method5042(var12, var13);
                                 } else if(Widget.field2684) {
                                    class88.method1714(var10);
                                 }
                              } else {
                                 if(var10.itemId != -1) {
                                    var54 = class21.createSprite(var10.itemId, var10.itemQuantity, var10.borderThickness, var10.sprite2, var10.field2784, false);
                                 } else {
                                    var54 = var10.method3991(false);
                                 }

                                 if(var54 == null) {
                                    if(Widget.field2684) {
                                       class88.method1714(var10);
                                    }
                                 } else {
                                    var20 = var54.maxWidth;
                                    var21 = var54.maxHeight;
                                    if(!var10.field2692) {
                                       var22 = var10.width * 4096 / var20;
                                       if(var10.textureId != 0) {
                                          var54.method5064(var10.width / 2 + var12, var10.height / 2 + var13, var10.textureId, var22);
                                       } else if(var14 != 0) {
                                          var54.method5109(var12, var13, var10.width, var10.height, 256 - (var14 & 255));
                                       } else if(var20 == var10.width && var21 == var10.height) {
                                          var54.method5042(var12, var13);
                                       } else {
                                          var54.method5080(var12, var13, var10.width, var10.height);
                                       }
                                    } else {
                                       Rasterizer2D.setInnerDrawRegion(var12, var13, var12 + var10.width, var13 + var10.height);
                                       var22 = (var20 - 1 + var10.width) / var20;
                                       var23 = (var21 - 1 + var10.height) / var21;

                                       for(var24 = 0; var24 < var22; ++var24) {
                                          for(var25 = 0; var25 < var23; ++var25) {
                                             if(var10.textureId != 0) {
                                                var54.method5064(var12 + var24 * var20 + var20 / 2, var13 + var21 * var25 + var21 / 2, var10.textureId, 4096);
                                             } else if(var14 != 0) {
                                                var54.method5057(var24 * var20 + var12, var13 + var25 * var21, 256 - (var14 & 255));
                                             } else {
                                                var54.method5042(var24 * var20 + var12, var13 + var25 * var21);
                                             }
                                          }
                                       }

                                       Rasterizer2D.setDrawRegion(var2, var3, var4, var5);
                                    }
                                 }
                              }
                           } else {
                              ItemComposition var32;
                              if(var10.type == 6) {
                                 var60 = WorldMapData.method272(var10);
                                 if(var60) {
                                    var20 = var10.field2702;
                                 } else {
                                    var20 = var10.field2717;
                                 }

                                 Model var66 = null;
                                 var22 = 0;
                                 if(var10.itemId != -1) {
                                    var32 = AbstractByteBuffer.getItemDefinition(var10.itemId);
                                    if(var32 != null) {
                                       var32 = var32.method4584(var10.itemQuantity);
                                       var66 = var32.getModel(1);
                                       if(var66 != null) {
                                          var66.method2493();
                                          var22 = var66.modelHeight / 2;
                                       } else {
                                          class88.method1714(var10);
                                       }
                                    }
                                 } else if(var10.modelType == 5) {
                                    if(var10.modelId == 0) {
                                       var66 = Client.field1198.method3936((Sequence)null, -1, (Sequence)null, -1);
                                    } else {
                                       var66 = XItemContainer.localPlayer.getModel();
                                    }
                                 } else if(var20 == -1) {
                                    var66 = var10.method3990((Sequence)null, -1, var60, XItemContainer.localPlayer.composition);
                                    if(var66 == null && Widget.field2684) {
                                       class88.method1714(var10);
                                    }
                                 } else {
                                    Sequence var68 = class224.getAnimation(var20);
                                    var66 = var10.method3990(var68, var10.field2788, var60, XItemContainer.localPlayer.composition);
                                    if(var66 == null && Widget.field2684) {
                                       class88.method1714(var10);
                                    }
                                 }

                                 Graphics3D.method2585(var10.width / 2 + var12, var10.height / 2 + var13);
                                 var23 = Graphics3D.SINE[var10.rotationX] * var10.modelZoom >> 16;
                                 var24 = Graphics3D.COSINE[var10.rotationX] * var10.modelZoom >> 16;
                                 if(var66 != null) {
                                    if(!var10.hasScript) {
                                       var66.method2506(0, var10.rotationZ, 0, var10.rotationX, 0, var23, var24);
                                    } else {
                                       var66.method2493();
                                       if(var10.field2711) {
                                          var66.method2507(0, var10.rotationZ, var10.rotationY, var10.rotationX, var10.field2703, var22 + var23 + var10.field2704, var24 + var10.field2704, var10.modelZoom);
                                       } else {
                                          var66.method2506(0, var10.rotationZ, var10.rotationY, var10.rotationX, var10.field2703, var22 + var23 + var10.field2704, var24 + var10.field2704);
                                       }
                                    }
                                 }

                                 Graphics3D.method2583();
                              } else {
                                 if(var10.type == 7) {
                                    var31 = var10.method3988();
                                    if(var31 == null) {
                                       if(Widget.field2684) {
                                          class88.method1714(var10);
                                       }
                                       continue;
                                    }

                                    var20 = 0;

                                    for(var21 = 0; var21 < var10.field2707; ++var21) {
                                       for(var22 = 0; var22 < var10.originalWidth; ++var22) {
                                          if(var10.itemIds[var20] > 0) {
                                             var32 = AbstractByteBuffer.getItemDefinition(var10.itemIds[var20] - 1);
                                             if(var32.isStackable != 1 && var10.itemQuantities[var20] == 1) {
                                                var33 = class220.getColTags(16748608) + var32.name + "</col>";
                                             } else {
                                                var33 = class220.getColTags(16748608) + var32.name + "</col> " + 'x' + class45.method684(var10.itemQuantities[var20]);
                                             }

                                             var25 = (var10.paddingX + 115) * var22 + var12;
                                             var26 = var13 + (12 + var10.paddingY) * var21;
                                             if(var10.field2652 == 0) {
                                                var31.method4790(var33, var25, var26, var10.textColor, var10.textShadowed?0:-1);
                                             } else if(var10.field2652 == 1) {
                                                var31.method4757(var33, var10.width / 2 + var25, var26, var10.textColor, var10.textShadowed?0:-1);
                                             } else {
                                                var31.method4756(var33, var25 + var10.width - 1, var26, var10.textColor, var10.textShadowed?0:-1);
                                             }
                                          }

                                          ++var20;
                                       }
                                    }
                                 }

                                 if(var10.type == 8 && var10 == PendingSpawn.field1211 && Client.field1054 == Client.field1079) {
                                    var19 = 0;
                                    var20 = 0;
                                    Font var58 = class37.font_p12full;
                                    String var34 = var10.text;

                                    String var35;
                                    for(var34 = KeyFocusListener.method788(var34, var10); var34.length() > 0; var20 += var58.verticalSpace + 1) {
                                       var24 = var34.indexOf("<br>");
                                       if(var24 != -1) {
                                          var35 = var34.substring(0, var24);
                                          var34 = var34.substring(var24 + 4);
                                       } else {
                                          var35 = var34;
                                          var34 = "";
                                       }

                                       var25 = var58.method4773(var35);
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

                                    if(var24 + var19 > var4) {
                                       var24 = var4 - var19;
                                    }

                                    if(var25 + var20 > var5) {
                                       var25 = var5 - var20;
                                    }

                                    Rasterizer2D.method4983(var24, var25, var19, var20, 16777120);
                                    Rasterizer2D.drawRectangle(var24, var25, var19, var20, 0);
                                    var34 = var10.text;
                                    var26 = var25 + var58.verticalSpace + 2;

                                    for(var34 = KeyFocusListener.method788(var34, var10); var34.length() > 0; var26 += var58.verticalSpace + 1) {
                                       var28 = var34.indexOf("<br>");
                                       if(var28 != -1) {
                                          var35 = var34.substring(0, var28);
                                          var34 = var34.substring(var28 + 4);
                                       } else {
                                          var35 = var34;
                                          var34 = "";
                                       }

                                       var58.method4790(var35, var24 + 3, var26, 0, -1);
                                    }
                                 }

                                 if(var10.type == 9) {
                                    if(var10.field2688) {
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

                                    if(var10.field2687 == 1) {
                                       Rasterizer2D.drawLine(var19, var20, var21, var22, var10.textColor);
                                    } else {
                                       var25 = var10.textColor;
                                       var26 = var10.field2687;
                                       var28 = var21 - var19;
                                       var29 = var22 - var20;
                                       var48 = var28 >= 0?var28:-var28;
                                       int var59 = var29 >= 0?var29:-var29;
                                       var27 = var48;
                                       if(var48 < var59) {
                                          var27 = var59;
                                       }

                                       if(var27 != 0) {
                                          int var63 = (var28 << 16) / var27;
                                          int var64 = (var29 << 16) / var27;
                                          if(var64 <= var63) {
                                             var63 = -var63;
                                          } else {
                                             var64 = -var64;
                                          }

                                          int var36 = var26 * var64 >> 17;
                                          int var37 = var26 * var64 + 1 >> 17;
                                          int var38 = var26 * var63 >> 17;
                                          int var39 = var26 * var63 + 1 >> 17;
                                          var23 = var19 - Rasterizer2D.draw_region_x;
                                          var24 = var20 - Rasterizer2D.drawingAreaTop;
                                          int var40 = var23 + var36;
                                          int var41 = var23 - var37;
                                          int var42 = var23 + var28 - var37;
                                          int var43 = var23 + var28 + var36;
                                          int var44 = var24 + var38;
                                          int var45 = var24 - var39;
                                          int var46 = var24 + var29 - var39;
                                          int var47 = var24 + var29 + var38;
                                          Graphics3D.setRasterClippingEnabled(var40, var41, var42);
                                          Graphics3D.rasterFlat(var44, var45, var46, var40, var41, var42, var25);
                                          Graphics3D.setRasterClippingEnabled(var40, var42, var43);
                                          Graphics3D.rasterFlat(var44, var46, var47, var40, var42, var43, var25);
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

   WallObject() {
      this.hash = 0;
      this.config = 0;
   }
}
