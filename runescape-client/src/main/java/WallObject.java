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
   int field2144;
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
   int field2147;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -510242745
   )
   int field2149;

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(I)Ljava/lang/String;",
      garbageValue = "-749082801"
   )
   static String method2865() {
      String var0 = "";

      MessageNode var2;
      for(Iterator var1 = class98.field1546.iterator(); var1.hasNext(); var0 = var0 + var2.name + ':' + var2.value + '\n') {
         var2 = (MessageNode)var1.next();
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

      if(var0.field2662 == 0) {
         var0.height = var0.field2707;
      } else if(var0.field2662 == 1) {
         var0.height = var2 - var0.field2707;
      } else if(var0.field2662 == 2) {
         var0.height = var2 * var0.field2707 >> 14;
      }

      if(var0.field2683 == 4) {
         var0.width = var0.height * var0.field2671 / var0.field2672;
      }

      if(var0.field2662 == 4) {
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
         class69 var6 = new class69();
         var6.field849 = var0;
         var6.field857 = var0.field2763;
         Client.field1035.method3603(var6);
      }

   }

   @ObfuscatedName("hu")
   @ObfuscatedSignature(
      signature = "([LWidget;IIIIIIIII)V",
      garbageValue = "-346520034"
   )
   @Export("gameDraw")
   static final void gameDraw(Widget[] var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
      Rasterizer2D.method4999(var2, var3, var4, var5);
      class136.method2582();

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
            var10.field2786 = Client.gameCycle;
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
                     var15 = class59.field748;
                     var16 = class59.field749;
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
                  int var31;
                  int var49;
                  int var53;
                  if(var10.contentType != 0) {
                     if(var10.contentType == 1336) {
                        if(Client.field941) {
                           var13 += 15;
                           class37.font_p12full.method4756("Fps:" + GameEngine.FPS, var12 + var10.width, var13, 16776960, -1);
                           var13 += 15;
                           Runtime var67 = Runtime.getRuntime();
                           var20 = (int)((var67.totalMemory() - var67.freeMemory()) / 1024L);
                           var21 = 16776960;
                           if(var20 > '耀' && Client.field930) {
                              var21 = 16711680;
                           }

                           if(var20 > 65536 && !Client.field930) {
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
                        Rasterizer2D.method4999(var2, var3, var4, var5);
                        continue;
                     }

                     class210 var64;
                     if(var10.contentType == 1338) {
                        class14.method67();
                        var64 = var10.method3981(false);
                        if(var64 != null) {
                           Rasterizer2D.method4999(var12, var13, var64.field2607 + var12, var13 + var64.field2602);
                           if(Client.field1161 != 2 && Client.field1161 != 5) {
                              var20 = Client.mapAngle + Client.mapScale & 2047;
                              var21 = XItemContainer.localPlayer.x / 32 + 48;
                              var22 = 464 - XItemContainer.localPlayer.y / 32;
                              class59.field758.method5096(var12, var13, var64.field2607, var64.field2602, var21, var22, var20, Client.mapScaleDelta + 256, var64.field2604, var64.field2608);

                              for(var23 = 0; var23 < Client.field1155; ++var23) {
                                 var24 = Client.field1156[var23] * 4 + 2 - XItemContainer.localPlayer.x / 32;
                                 var25 = Client.field1011[var23] * 4 + 2 - XItemContainer.localPlayer.y / 32;
                                 class40.method560(var12, var13, var24, var25, Client.field927[var23], var64);
                              }

                              var23 = 0;

                              while(true) {
                                 if(var23 >= 104) {
                                    for(var23 = 0; var23 < Client.field937; ++var23) {
                                       NPC var69 = Client.cachedNPCs[Client.npcIndices[var23]];
                                       if(var69 != null && var69.vmethod1695()) {
                                          NPCComposition var63 = var69.composition;
                                          if(var63 != null && var63.configs != null) {
                                             var63 = var63.method4646();
                                          }

                                          if(var63 != null && var63.isMinimapVisible && var63.field3588) {
                                             var26 = var69.x / 32 - XItemContainer.localPlayer.x / 32;
                                             var49 = var69.y / 32 - XItemContainer.localPlayer.y / 32;
                                             class40.method560(var12, var13, var26, var49, WorldMapType3.field377[1], var64);
                                          }
                                       }
                                    }

                                    var23 = class96.field1521;
                                    int[] var70 = class96.field1531;

                                    for(var25 = 0; var25 < var23; ++var25) {
                                       Player var54 = Client.cachedPlayers[var70[var25]];
                                       if(var54 != null && var54.vmethod1695() && !var54.hidden && var54 != XItemContainer.localPlayer) {
                                          var49 = var54.x / 32 - XItemContainer.localPlayer.x / 32;
                                          var53 = var54.y / 32 - XItemContainer.localPlayer.y / 32;
                                          boolean var59 = false;
                                          if(class25.method167(var54.name, true)) {
                                             var59 = true;
                                          }

                                          boolean var58 = false;

                                          for(var31 = 0; var31 < class28.clanChatCount; ++var31) {
                                             if(var54.name.equals(class11.clanMembers[var31].username)) {
                                                var58 = true;
                                                break;
                                             }
                                          }

                                          boolean var60 = false;
                                          if(XItemContainer.localPlayer.team != 0 && var54.team != 0 && var54.team == XItemContainer.localPlayer.team) {
                                             var60 = true;
                                          }

                                          if(var59) {
                                             class40.method560(var12, var13, var49, var53, WorldMapType3.field377[3], var64);
                                          } else if(var60) {
                                             class40.method560(var12, var13, var49, var53, WorldMapType3.field377[4], var64);
                                          } else if(var58) {
                                             class40.method560(var12, var13, var49, var53, WorldMapType3.field377[5], var64);
                                          } else {
                                             class40.method560(var12, var13, var49, var53, WorldMapType3.field377[2], var64);
                                          }
                                       }
                                    }

                                    if(Client.field943 != 0 && Client.gameCycle % 20 < 10) {
                                       if(Client.field943 == 1 && Client.field944 >= 0 && Client.field944 < Client.cachedNPCs.length) {
                                          NPC var65 = Client.cachedNPCs[Client.field944];
                                          if(var65 != null) {
                                             var26 = var65.x / 32 - XItemContainer.localPlayer.x / 32;
                                             var49 = var65.y / 32 - XItemContainer.localPlayer.y / 32;
                                             MessageNode.method1144(var12, var13, var26, var49, class31.field458[1], var64);
                                          }
                                       }

                                       if(Client.field943 == 2) {
                                          var25 = Client.hintArrowX * 4 - class50.baseX * 4 + 2 - XItemContainer.localPlayer.x / 32;
                                          var26 = Client.hintArrowY * 4 - class266.baseY * 4 + 2 - XItemContainer.localPlayer.y / 32;
                                          MessageNode.method1144(var12, var13, var25, var26, class31.field458[1], var64);
                                       }

                                       if(Client.field943 == 10 && Client.field1183 >= 0 && Client.field1183 < Client.cachedPlayers.length) {
                                          Player var66 = Client.cachedPlayers[Client.field1183];
                                          if(var66 != null) {
                                             var26 = var66.x / 32 - XItemContainer.localPlayer.x / 32;
                                             var49 = var66.y / 32 - XItemContainer.localPlayer.y / 32;
                                             MessageNode.method1144(var12, var13, var26, var49, class31.field458[1], var64);
                                          }
                                       }
                                    }

                                    if(Client.destinationX != 0) {
                                       var25 = Client.destinationX * 4 + 2 - XItemContainer.localPlayer.x / 32;
                                       var26 = Client.destinationY * 4 + 2 - XItemContainer.localPlayer.y / 32;
                                       class40.method560(var12, var13, var25, var26, class31.field458[0], var64);
                                    }

                                    if(!XItemContainer.localPlayer.hidden) {
                                       Rasterizer2D.method4983(var64.field2607 / 2 + var12 - 1, var13 + var64.field2602 / 2 - 1, 3, 3, 16777215);
                                    }
                                    break;
                                 }

                                 for(var24 = 0; var24 < 104; ++var24) {
                                    Deque var47 = Client.groundItemDeque[plane][var23][var24];
                                    if(var47 != null) {
                                       var26 = var23 * 4 + 2 - XItemContainer.localPlayer.x / 32;
                                       var49 = var24 * 4 + 2 - XItemContainer.localPlayer.y / 32;
                                       class40.method560(var12, var13, var26, var49, WorldMapType3.field377[0], var64);
                                    }
                                 }

                                 ++var23;
                              }
                           } else {
                              Rasterizer2D.method4947(var12, var13, 0, var64.field2604, var64.field2608);
                           }

                           Client.field1133[var11] = true;
                        }

                        Rasterizer2D.method4999(var2, var3, var4, var5);
                        continue;
                     }

                     if(var10.contentType == 1339) {
                        var64 = var10.method3981(false);
                        if(var64 != null) {
                           if(Client.field1161 < 3) {
                              class19.field329.method5096(var12, var13, var64.field2607, var64.field2602, 25, 25, Client.mapAngle, 256, var64.field2604, var64.field2608);
                           } else {
                              Rasterizer2D.method4947(var12, var13, 0, var64.field2604, var64.field2608);
                           }
                        }

                        Rasterizer2D.method4999(var2, var3, var4, var5);
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

                     WidgetNode var46 = (WidgetNode)Client.componentTable.method3530((long)var10.id);
                     if(var46 != null) {
                        Signlink.drawWidget(var46.id, var15, var16, var17, var18, var12, var13, var11);
                     }

                     Rasterizer2D.method4999(var2, var3, var4, var5);
                     class136.method2582();
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
                        int var29;
                        if(var10.type == 2) {
                           var19 = 0;

                           for(var20 = 0; var20 < var10.field2707; ++var20) {
                              for(var21 = 0; var21 < var10.originalWidth; ++var21) {
                                 var22 = (var10.paddingX + 32) * var21 + var12;
                                 var23 = var13 + (var10.paddingY + 32) * var20;
                                 if(var19 < 20) {
                                    var22 += var10.field2775[var19];
                                    var23 += var10.field2723[var19];
                                 }

                                 if(var10.itemIds[var19] <= 0) {
                                    if(var10.field2724 != null && var19 < 20) {
                                       SpritePixels var68 = var10.method3989(var19);
                                       if(var68 != null) {
                                          var68.method5042(var22, var23);
                                       } else if(Widget.field2684) {
                                          class88.method1714(var10);
                                       }
                                    }
                                 } else {
                                    boolean var56 = false;
                                    boolean var57 = false;
                                    var26 = var10.itemIds[var19] - 1;
                                    if(var22 + 32 > var2 && var22 < var4 && var23 + 32 > var3 && var23 < var5 || var10 == class95.field1513 && var19 == Client.field1039) {
                                       SpritePixels var27;
                                       if(Client.itemSelectionState == 1 && var19 == FileSystem.selectedItemIndex && class40.field571 == var10.id) {
                                          var27 = class21.createSprite(var26, var10.itemQuantities[var19], 2, 0, 2, false);
                                       } else {
                                          var27 = class21.createSprite(var26, var10.itemQuantities[var19], 1, 3153952, 2, false);
                                       }

                                       if(var27 != null) {
                                          if(var10 == class95.field1513 && var19 == Client.field1039) {
                                             var24 = class59.field748 - Client.field1040;
                                             var25 = class59.field749 - Client.field1041;
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

                                             var27.method5057(var24 + var22, var25 + var23, 128);
                                             if(var1 != -1) {
                                                Widget var28 = var0[var1 & '\uffff'];
                                                if(var25 + var23 < Rasterizer2D.drawingAreaTop && var28.scrollY > 0) {
                                                   var29 = (Rasterizer2D.drawingAreaTop - var23 - var25) * Client.field1002 / 3;
                                                   if(var29 > Client.field1002 * 10) {
                                                      var29 = Client.field1002 * 10;
                                                   }

                                                   if(var29 > var28.scrollY) {
                                                      var29 = var28.scrollY;
                                                   }

                                                   var28.scrollY -= var29;
                                                   Client.field1041 += var29;
                                                   class88.method1714(var28);
                                                }

                                                if(var25 + var23 + 32 > Rasterizer2D.drawingAreaRight && var28.scrollY < var28.scrollHeight - var28.height) {
                                                   var29 = (var23 + var25 + 32 - Rasterizer2D.drawingAreaRight) * Client.field1002 / 3;
                                                   if(var29 > Client.field1002 * 10) {
                                                      var29 = Client.field1002 * 10;
                                                   }

                                                   if(var29 > var28.scrollHeight - var28.height - var28.scrollY) {
                                                      var29 = var28.scrollHeight - var28.height - var28.scrollY;
                                                   }

                                                   var28.scrollY += var29;
                                                   Client.field1041 -= var29;
                                                   class88.method1714(var28);
                                                }
                                             }
                                          } else if(var10 == Buffer.field2405 && var19 == Client.field1114) {
                                             var27.method5057(var22, var23, 128);
                                          } else {
                                             var27.method5042(var22, var23);
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
                                    Rasterizer2D.method4931(var12, var13, var10.width, var10.height, var19, 256 - (var14 & 255));
                                 }
                              }
                           } else if(var14 == 0) {
                              Rasterizer2D.method4958(var12, var13, var10.width, var10.height, var19);
                           } else {
                              Rasterizer2D.method4995(var12, var13, var10.width, var10.height, var19, 256 - (var14 & 255));
                           }
                        } else {
                           Font var61;
                           if(var10.type == 4) {
                              var61 = var10.method3988();
                              if(var61 == null) {
                                 if(Widget.field2684) {
                                    class88.method1714(var10);
                                 }
                              } else {
                                 String var73 = var10.text;
                                 if(WorldMapData.method272(var10)) {
                                    var20 = var10.field2680;
                                    if(var10 == KitDefinition.field3371 && var10.field2682 != 0) {
                                       var20 = var10.field2682;
                                    }

                                    if(var10.field2729.length() > 0) {
                                       var73 = var10.field2729;
                                    }
                                 } else {
                                    var20 = var10.textColor;
                                    if(var10 == KitDefinition.field3371 && var10.field2681 != 0) {
                                       var20 = var10.field2681;
                                    }
                                 }

                                 if(var10.hasScript && var10.itemId != -1) {
                                    ItemComposition var74 = class176.getItemDefinition(var10.itemId);
                                    var73 = var74.name;
                                    if(var73 == null) {
                                       var73 = "null";
                                    }

                                    if((var74.isStackable == 1 || var10.itemQuantity != 1) && var10.itemQuantity != -1) {
                                       var73 = class220.method4055(16748608) + var73 + "</col>" + " " + 'x' + class45.method684(var10.itemQuantity);
                                    }
                                 }

                                 if(var10 == Client.field1091) {
                                    Object var10000 = null;
                                    var73 = "Please wait...";
                                    var20 = var10.textColor;
                                 }

                                 if(!var10.hasScript) {
                                    var73 = class50.method788(var73, var10);
                                 }

                                 var61.method4788(var73, var12, var13, var10.width, var10.height, var20, var10.field2719?0:-1, var10.field2652, var10.field2726, var10.field2716);
                              }
                           } else if(var10.type == 5) {
                              SpritePixels var62;
                              if(!var10.hasScript) {
                                 var62 = var10.method3991(WorldMapData.method272(var10));
                                 if(var62 != null) {
                                    var62.method5042(var12, var13);
                                 } else if(Widget.field2684) {
                                    class88.method1714(var10);
                                 }
                              } else {
                                 if(var10.itemId != -1) {
                                    var62 = class21.createSprite(var10.itemId, var10.itemQuantity, var10.borderThickness, var10.sprite2, var10.field2784, false);
                                 } else {
                                    var62 = var10.method3991(false);
                                 }

                                 if(var62 == null) {
                                    if(Widget.field2684) {
                                       class88.method1714(var10);
                                    }
                                 } else {
                                    var20 = var62.maxWidth;
                                    var21 = var62.maxHeight;
                                    if(!var10.field2692) {
                                       var22 = var10.width * 4096 / var20;
                                       if(var10.field2691 != 0) {
                                          var62.method5064(var10.width / 2 + var12, var10.height / 2 + var13, var10.field2691, var22);
                                       } else if(var14 != 0) {
                                          var62.method5109(var12, var13, var10.width, var10.height, 256 - (var14 & 255));
                                       } else if(var20 == var10.width && var21 == var10.height) {
                                          var62.method5042(var12, var13);
                                       } else {
                                          var62.method5080(var12, var13, var10.width, var10.height);
                                       }
                                    } else {
                                       Rasterizer2D.method4925(var12, var13, var12 + var10.width, var13 + var10.height);
                                       var22 = (var20 - 1 + var10.width) / var20;
                                       var23 = (var21 - 1 + var10.height) / var21;

                                       for(var24 = 0; var24 < var22; ++var24) {
                                          for(var25 = 0; var25 < var23; ++var25) {
                                             if(var10.field2691 != 0) {
                                                var62.method5064(var12 + var24 * var20 + var20 / 2, var13 + var21 * var25 + var21 / 2, var10.field2691, 4096);
                                             } else if(var14 != 0) {
                                                var62.method5057(var24 * var20 + var12, var13 + var25 * var21, 256 - (var14 & 255));
                                             } else {
                                                var62.method5042(var24 * var20 + var12, var13 + var25 * var21);
                                             }
                                          }
                                       }

                                       Rasterizer2D.method4999(var2, var3, var4, var5);
                                    }
                                 }
                              }
                           } else {
                              ItemComposition var52;
                              if(var10.type == 6) {
                                 boolean var55 = WorldMapData.method272(var10);
                                 if(var55) {
                                    var20 = var10.field2702;
                                 } else {
                                    var20 = var10.field2717;
                                 }

                                 Model var71 = null;
                                 var22 = 0;
                                 if(var10.itemId != -1) {
                                    var52 = class176.getItemDefinition(var10.itemId);
                                    if(var52 != null) {
                                       var52 = var52.method4584(var10.itemQuantity);
                                       var71 = var52.getModel(1);
                                       if(var71 != null) {
                                          var71.method2493();
                                          var22 = var71.modelHeight / 2;
                                       } else {
                                          class88.method1714(var10);
                                       }
                                    }
                                 } else if(var10.modelType == 5) {
                                    if(var10.modelId == 0) {
                                       var71 = Client.field1198.method3936((Sequence)null, -1, (Sequence)null, -1);
                                    } else {
                                       var71 = XItemContainer.localPlayer.getModel();
                                    }
                                 } else if(var20 == -1) {
                                    var71 = var10.method3990((Sequence)null, -1, var55, XItemContainer.localPlayer.composition);
                                    if(var71 == null && Widget.field2684) {
                                       class88.method1714(var10);
                                    }
                                 } else {
                                    Sequence var75 = class224.getAnimation(var20);
                                    var71 = var10.method3990(var75, var10.field2788, var55, XItemContainer.localPlayer.composition);
                                    if(var71 == null && Widget.field2684) {
                                       class88.method1714(var10);
                                    }
                                 }

                                 class136.method2585(var10.width / 2 + var12, var10.height / 2 + var13);
                                 var23 = class136.SINE[var10.rotationX] * var10.field2650 >> 16;
                                 var24 = class136.COSINE[var10.rotationX] * var10.field2650 >> 16;
                                 if(var71 != null) {
                                    if(!var10.hasScript) {
                                       var71.method2506(0, var10.rotationZ, 0, var10.rotationX, 0, var23, var24);
                                    } else {
                                       var71.method2493();
                                       if(var10.field2711) {
                                          var71.method2507(0, var10.rotationZ, var10.rotationY, var10.rotationX, var10.field2703, var22 + var23 + var10.field2704, var24 + var10.field2704, var10.field2650);
                                       } else {
                                          var71.method2506(0, var10.rotationZ, var10.rotationY, var10.rotationX, var10.field2703, var22 + var23 + var10.field2704, var24 + var10.field2704);
                                       }
                                    }
                                 }

                                 class136.method2583();
                              } else {
                                 if(var10.type == 7) {
                                    var61 = var10.method3988();
                                    if(var61 == null) {
                                       if(Widget.field2684) {
                                          class88.method1714(var10);
                                       }
                                       continue;
                                    }

                                    var20 = 0;

                                    for(var21 = 0; var21 < var10.field2707; ++var21) {
                                       for(var22 = 0; var22 < var10.originalWidth; ++var22) {
                                          if(var10.itemIds[var20] > 0) {
                                             var52 = class176.getItemDefinition(var10.itemIds[var20] - 1);
                                             String var48;
                                             if(var52.isStackable != 1 && var10.itemQuantities[var20] == 1) {
                                                var48 = class220.method4055(16748608) + var52.name + "</col>";
                                             } else {
                                                var48 = class220.method4055(16748608) + var52.name + "</col>" + " " + 'x' + class45.method684(var10.itemQuantities[var20]);
                                             }

                                             var25 = (var10.paddingX + 115) * var22 + var12;
                                             var26 = var13 + (12 + var10.paddingY) * var21;
                                             if(var10.field2652 == 0) {
                                                var61.method4790(var48, var25, var26, var10.textColor, var10.field2719?0:-1);
                                             } else if(var10.field2652 == 1) {
                                                var61.method4757(var48, var10.width / 2 + var25, var26, var10.textColor, var10.field2719?0:-1);
                                             } else {
                                                var61.method4756(var48, var25 + var10.width - 1, var26, var10.textColor, var10.field2719?0:-1);
                                             }
                                          }

                                          ++var20;
                                       }
                                    }
                                 }

                                 if(var10.type == 8 && var10 == PendingSpawn.field1211 && Client.field1054 == Client.field1079) {
                                    var19 = 0;
                                    var20 = 0;
                                    Font var50 = class37.font_p12full;
                                    String var51 = var10.text;

                                    String var72;
                                    for(var51 = class50.method788(var51, var10); var51.length() > 0; var20 += var50.field3649 + 1) {
                                       var24 = var51.indexOf("<br>");
                                       if(var24 != -1) {
                                          var72 = var51.substring(0, var24);
                                          var51 = var51.substring(var24 + 4);
                                       } else {
                                          var72 = var51;
                                          var51 = "";
                                       }

                                       var25 = var50.method4773(var72);
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
                                    Rasterizer2D.method4958(var24, var25, var19, var20, 0);
                                    var51 = var10.text;
                                    var26 = var25 + var50.field3649 + 2;

                                    for(var51 = class50.method788(var51, var10); var51.length() > 0; var26 += var50.field3649 + 1) {
                                       var49 = var51.indexOf("<br>");
                                       if(var49 != -1) {
                                          var72 = var51.substring(0, var49);
                                          var51 = var51.substring(var49 + 4);
                                       } else {
                                          var72 = var51;
                                          var51 = "";
                                       }

                                       var50.method4790(var72, var24 + 3, var26, 0, -1);
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
                                       Rasterizer2D.method4945(var19, var20, var21, var22, var10.textColor);
                                    } else {
                                       var25 = var10.textColor;
                                       var26 = var10.field2687;
                                       var49 = var21 - var19;
                                       var53 = var22 - var20;
                                       var29 = var49 >= 0?var49:-var49;
                                       int var30 = var53 >= 0?var53:-var53;
                                       var31 = var29;
                                       if(var29 < var30) {
                                          var31 = var30;
                                       }

                                       if(var31 != 0) {
                                          int var32 = (var49 << 16) / var31;
                                          int var33 = (var53 << 16) / var31;
                                          if(var33 <= var32) {
                                             var32 = -var32;
                                          } else {
                                             var33 = -var33;
                                          }

                                          int var34 = var26 * var33 >> 17;
                                          int var35 = var26 * var33 + 1 >> 17;
                                          int var36 = var26 * var32 >> 17;
                                          int var37 = var26 * var32 + 1 >> 17;
                                          var23 = var19 - Rasterizer2D.field3761;
                                          var24 = var20 - Rasterizer2D.drawingAreaTop;
                                          int var38 = var23 + var34;
                                          int var39 = var23 - var35;
                                          int var40 = var23 + var49 - var35;
                                          int var41 = var23 + var49 + var34;
                                          int var42 = var24 + var36;
                                          int var43 = var24 - var37;
                                          int var44 = var24 + var53 - var37;
                                          int var45 = var24 + var53 + var36;
                                          class136.setRasterClippingEnabled(var38, var39, var40);
                                          class136.rasterFlat(var42, var43, var44, var38, var39, var40, var25);
                                          class136.setRasterClippingEnabled(var38, var40, var41);
                                          class136.rasterFlat(var42, var44, var45, var38, var40, var41, var25);
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
      this.field2144 = 0;
   }
}
