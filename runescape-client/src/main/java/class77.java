import java.io.DataInputStream;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.URL;
import net.runelite.mapping.Export;
import net.runelite.mapping.Hook;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bx")
public class class77 {
   @ObfuscatedName("fk")
   @Export("mapRegions")
   @Hook("mapRegionsChanged")
   static int[] mapRegions;
   @ObfuscatedName("i")
   byte[] field1202;
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Ler;"
   )
   Task field1199;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -129690293
   )
   int field1206;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      longValue = 1507070217419571009L
   )
   long field1203;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 543494229
   )
   int field1201;
   @ObfuscatedName("u")
   DataInputStream field1208;
   @ObfuscatedName("m")
   byte[] field1204;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -622563887
   )
   int field1205;

   @ObfuscatedSignature(
      signature = "(Lew;Ljava/net/URL;)V"
   )
   class77(Signlink var1, URL var2) {
      this.field1202 = new byte[4];
      this.field1199 = var1.createURL(var2);
      this.field1206 = 0;
      this.field1203 = class157.currentTimeMs() + 30000L;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)[B",
      garbageValue = "-1904326993"
   )
   byte[] method1470() throws IOException {
      if(class157.currentTimeMs() > this.field1203) {
         throw new IOException();
      } else {
         if(this.field1206 == 0) {
            if(this.field1199.status == 2) {
               throw new IOException();
            }

            if(this.field1199.status == 1) {
               this.field1208 = (DataInputStream)this.field1199.value;
               this.field1206 = 1;
            }
         }

         if(this.field1206 == 1) {
            this.field1201 += this.field1208.read(this.field1202, this.field1201, this.field1202.length - this.field1201);
            if(this.field1201 == 4) {
               int var1 = (new Buffer(this.field1202)).readInt();
               this.field1204 = new byte[var1];
               this.field1206 = 2;
            }
         }

         if(this.field1206 == 2) {
            this.field1205 += this.field1208.read(this.field1204, this.field1205, this.field1204.length - this.field1205);
            if(this.field1204.length == this.field1205) {
               return this.field1204;
            }
         }

         return null;
      }
   }

   @ObfuscatedName("hy")
   @ObfuscatedSignature(
      signature = "([Lho;IIIIIIIIB)V",
      garbageValue = "45"
   )
   @Export("gameDraw")
   static final void gameDraw(Widget[] var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
      Rasterizer2D.setDrawRegion(var2, var3, var4, var5);
      Graphics3D.method2524();

      for(int var9 = 0; var9 < var0.length; ++var9) {
         Widget var10 = var0[var9];
         if(var10 != null && (var10.parentId == var1 || var1 == -1412584499 && var10 == Client.field1077)) {
            int var11;
            if(var8 == -1) {
               Client.widgetPositionX[Client.field1107] = var10.relativeX + var6;
               Client.widgetPositionY[Client.field1107] = var7 + var10.relativeY;
               Client.widgetBoundsWidth[Client.field1107] = var10.width;
               Client.widgetBoundsHeight[Client.field1107] = var10.height;
               var11 = ++Client.field1107 - 1;
            } else {
               var11 = var8;
            }

            var10.boundsIndex = var11;
            var10.loopCycle = Client.gameCycle;
            if(!var10.hasScript || !class11.method55(var10)) {
               int var12;
               if(var10.contentType > 0) {
                  var12 = var10.contentType;
                  if(var12 == 324) {
                     if(Client.field1156 == -1) {
                        Client.field1156 = var10.spriteId;
                        Client.field1177 = var10.field2653;
                     }

                     if(Client.field1080.isFemale) {
                        var10.spriteId = Client.field1156;
                     } else {
                        var10.spriteId = Client.field1177;
                     }
                  } else if(var12 == 325) {
                     if(Client.field1156 == -1) {
                        Client.field1156 = var10.spriteId;
                        Client.field1177 = var10.field2653;
                     }

                     if(Client.field1080.isFemale) {
                        var10.spriteId = Client.field1177;
                     } else {
                        var10.spriteId = Client.field1156;
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
               if(var10 == Client.field1077) {
                  if(var1 != -1412584499 && !var10.field2712) {
                     class24.field346 = var0;
                     class29.field410 = var6;
                     GZipDecompressor.field2293 = var7;
                     continue;
                  }

                  if(Client.field1088 && Client.field1082) {
                     var15 = MouseInput.field730;
                     var16 = MouseInput.field731;
                     var15 -= Client.field1079;
                     var16 -= Client.field1160;
                     if(var15 < Client.field1083) {
                        var15 = Client.field1083;
                     }

                     if(var15 + var10.width > Client.field1083 + Client.field1147.width) {
                        var15 = Client.field1083 + Client.field1147.width - var10.width;
                     }

                     if(var16 < Client.field1084) {
                        var16 = Client.field1084;
                     }

                     if(var16 + var10.height > Client.field1084 + Client.field1147.height) {
                        var16 = Client.field1084 + Client.field1147.height - var10.height;
                     }

                     var12 = var15;
                     var13 = var16;
                  }

                  if(!var10.field2712) {
                     var14 = 128;
                  }
               }

               int var17;
               int var18;
               int var20;
               int var21;
               int var22;
               int var32;
               if(var10.type == 2) {
                  var15 = var2;
                  var16 = var3;
                  var17 = var4;
                  var18 = var5;
               } else if(var10.type == 9) {
                  var32 = var12;
                  var20 = var13;
                  var21 = var12 + var10.width;
                  var22 = var13 + var10.height;
                  if(var21 < var12) {
                     var32 = var21;
                     var21 = var12;
                  }

                  if(var22 < var13) {
                     var20 = var22;
                     var22 = var13;
                  }

                  ++var21;
                  ++var22;
                  var15 = var32 > var2?var32:var2;
                  var16 = var20 > var3?var20:var3;
                  var17 = var21 < var4?var21:var4;
                  var18 = var22 < var5?var22:var5;
               } else {
                  var32 = var12 + var10.width;
                  var20 = var13 + var10.height;
                  var15 = var12 > var2?var12:var2;
                  var16 = var13 > var3?var13:var3;
                  var17 = var32 < var4?var32:var4;
                  var18 = var20 < var5?var20:var5;
               }

               if(!var10.hasScript || var15 < var17 && var16 < var18) {
                  int var23;
                  int var24;
                  int var25;
                  int var26;
                  int var37;
                  if(var10.contentType != 0) {
                     if(var10.contentType == 1336) {
                        if(Client.displayFps) {
                           var13 += 15;
                           class112.font_p12full.method4681("Fps:" + GameEngine.FPS, var12 + var10.width, var13, 16776960, -1);
                           var13 += 15;
                           Runtime var44 = Runtime.getRuntime();
                           var20 = (int)((var44.totalMemory() - var44.freeMemory()) / 1024L);
                           var21 = 16776960;
                           if(var20 > '耀' && Client.lowMemory) {
                              var21 = 16711680;
                           }

                           if(var20 > 65536 && !Client.lowMemory) {
                              var21 = 16711680;
                           }

                           class112.font_p12full.method4681("Mem:" + var20 + "k", var12 + var10.width, var13, var21, -1);
                           var13 += 15;
                        }
                        continue;
                     }

                     if(var10.contentType == 1337) {
                        Client.field1053 = var12;
                        Client.field1054 = var13;
                        class17.method124(var12, var13, var10.width, var10.height);
                        Client.field1109[var10.boundsIndex] = true;
                        Rasterizer2D.setDrawRegion(var2, var3, var4, var5);
                        continue;
                     }

                     if(var10.contentType == 1338) {
                        class140.method2791();
                        class210 var43 = var10.method3920(false);
                        if(var43 != null) {
                           Rasterizer2D.setDrawRegion(var12, var13, var12 + var43.field2569, var13 + var43.field2566);
                           if(Client.field1138 != 2 && Client.field1138 != 5) {
                              var20 = Client.mapAngle & 2047;
                              var21 = class226.localPlayer.x / 32 + 48;
                              var22 = 464 - class226.localPlayer.y / 32;
                              class43.field576.method5022(var12, var13, var43.field2569, var43.field2566, var21, var22, var20, 256, var43.field2568, var43.field2567);

                              for(var23 = 0; var23 < Client.field1056; ++var23) {
                                 var24 = Client.field1039[var23] * 4 + 2 - class226.localPlayer.x / 32;
                                 var25 = Client.field1134[var23] * 4 + 2 - class226.localPlayer.y / 32;
                                 class87.drawDot(var12, var13, var24, var25, Client.field1135[var23], var43);
                              }

                              var23 = 0;

                              while(true) {
                                 if(var23 >= 104) {
                                    for(var23 = 0; var23 < Client.field953; ++var23) {
                                       NPC var51 = Client.cachedNPCs[Client.npcIndices[var23]];
                                       if(var51 != null && var51.hasConfig()) {
                                          NPCComposition var54 = var51.composition;
                                          if(var54 != null && var54.configs != null) {
                                             var54 = var54.transform();
                                          }

                                          if(var54 != null && var54.isMinimapVisible && var54.field3559) {
                                             var26 = var51.x / 32 - class226.localPlayer.x / 32;
                                             var37 = var51.y / 32 - class226.localPlayer.y / 32;
                                             class87.drawDot(var12, var13, var26, var37, WorldMapType3.mapDots[1], var43);
                                          }
                                       }
                                    }

                                    var23 = class96.field1469;
                                    int[] var52 = class96.field1470;

                                    for(var25 = 0; var25 < var23; ++var25) {
                                       Player var38 = Client.cachedPlayers[var52[var25]];
                                       if(var38 != null && var38.hasConfig() && !var38.hidden && var38 != class226.localPlayer) {
                                          var37 = var38.x / 32 - class226.localPlayer.x / 32;
                                          int var39 = var38.y / 32 - class226.localPlayer.y / 32;
                                          boolean var48 = false;
                                          if(DecorativeObject.isFriended(var38.name, true)) {
                                             var48 = true;
                                          }

                                          boolean var30 = false;

                                          for(int var31 = 0; var31 < VarPlayerType.clanChatCount; ++var31) {
                                             if(var38.name.equals(KeyFocusListener.clanMembers[var31].username)) {
                                                var30 = true;
                                                break;
                                             }
                                          }

                                          boolean var47 = false;
                                          if(class226.localPlayer.team != 0 && var38.team != 0 && var38.team == class226.localPlayer.team) {
                                             var47 = true;
                                          }

                                          if(var48) {
                                             class87.drawDot(var12, var13, var37, var39, WorldMapType3.mapDots[3], var43);
                                          } else if(var47) {
                                             class87.drawDot(var12, var13, var37, var39, WorldMapType3.mapDots[4], var43);
                                          } else if(var30) {
                                             class87.drawDot(var12, var13, var37, var39, WorldMapType3.mapDots[5], var43);
                                          } else {
                                             class87.drawDot(var12, var13, var37, var39, WorldMapType3.mapDots[2], var43);
                                          }
                                       }
                                    }

                                    if(Client.field992 != 0 && Client.gameCycle % 20 < 10) {
                                       if(Client.field992 == 1 && Client.field933 >= 0 && Client.field933 < Client.cachedNPCs.length) {
                                          NPC var56 = Client.cachedNPCs[Client.field933];
                                          if(var56 != null) {
                                             var26 = var56.x / 32 - class226.localPlayer.x / 32;
                                             var37 = var56.y / 32 - class226.localPlayer.y / 32;
                                             World.method1536(var12, var13, var26, var37, class27.field388[1], var43);
                                          }
                                       }

                                       if(Client.field992 == 2) {
                                          var25 = Client.hintArrowX * 4 - class21.baseX * 4 + 2 - class226.localPlayer.x / 32;
                                          var26 = Client.hintArrowY * 4 - class164.baseY * 4 + 2 - class226.localPlayer.y / 32;
                                          World.method1536(var12, var13, var25, var26, class27.field388[1], var43);
                                       }

                                       if(Client.field992 == 10 && Client.field1150 >= 0 && Client.field1150 < Client.cachedPlayers.length) {
                                          Player var58 = Client.cachedPlayers[Client.field1150];
                                          if(var58 != null) {
                                             var26 = var58.x / 32 - class226.localPlayer.x / 32;
                                             var37 = var58.y / 32 - class226.localPlayer.y / 32;
                                             World.method1536(var12, var13, var26, var37, class27.field388[1], var43);
                                          }
                                       }
                                    }

                                    if(Client.destinationX != 0) {
                                       var25 = Client.destinationX * 4 + 2 - class226.localPlayer.x / 32;
                                       var26 = Client.destinationY * 4 + 2 - class226.localPlayer.y / 32;
                                       class87.drawDot(var12, var13, var25, var26, class27.field388[0], var43);
                                    }

                                    if(!class226.localPlayer.hidden) {
                                       Rasterizer2D.method4828(var12 + var43.field2569 / 2 - 1, var13 + var43.field2566 / 2 - 1, 3, 3, 16777215);
                                    }
                                    break;
                                 }

                                 for(var24 = 0; var24 < 104; ++var24) {
                                    Deque var36 = Client.groundItemDeque[class10.plane][var23][var24];
                                    if(var36 != null) {
                                       var26 = var23 * 4 + 2 - class226.localPlayer.x / 32;
                                       var37 = var24 * 4 + 2 - class226.localPlayer.y / 32;
                                       class87.drawDot(var12, var13, var26, var37, WorldMapType3.mapDots[0], var43);
                                    }
                                 }

                                 ++var23;
                              }
                           } else {
                              Rasterizer2D.method4843(var12, var13, 0, var43.field2568, var43.field2567);
                           }

                           Client.field1064[var11] = true;
                        }

                        Rasterizer2D.setDrawRegion(var2, var3, var4, var5);
                        continue;
                     }

                     if(var10.contentType == 1339) {
                        class29.method242(var10, var12, var13, var11);
                        Rasterizer2D.setDrawRegion(var2, var3, var4, var5);
                        continue;
                     }

                     if(var10.contentType == 1400) {
                        Client.renderOverview.extractWorldmap(var12, var13, var10.width, var10.height, Client.gameCycle);
                     }

                     if(var10.contentType == 1401) {
                        Client.renderOverview.extractData(var12, var13, var10.width, var10.height);
                     }
                  }

                  if(var10.type == 0) {
                     if(!var10.hasScript && class11.method55(var10) && var10 != class3.field14) {
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
                        Renderable.drawWidget(var19.id, var15, var16, var17, var18, var12, var13, var11);
                     }

                     Rasterizer2D.setDrawRegion(var2, var3, var4, var5);
                     Graphics3D.method2524();
                  }

                  if(Client.isResized || Client.field1111[var11] || Client.gameDrawingMode > 1) {
                     if(var10.type == 0 && !var10.hasScript && var10.scrollHeight > var10.height) {
                        var32 = var12 + var10.width;
                        var20 = var10.scrollY;
                        var21 = var10.height;
                        var22 = var10.scrollHeight;
                        FileRequest.field3179[0].method4941(var32, var13);
                        FileRequest.field3179[1].method4941(var32, var21 + var13 - 16);
                        Rasterizer2D.method4828(var32, var13 + 16, 16, var21 - 32, Client.field980);
                        var23 = var21 * (var21 - 32) / var22;
                        if(var23 < 8) {
                           var23 = 8;
                        }

                        var24 = var20 * (var21 - 32 - var23) / (var22 - var21);
                        Rasterizer2D.method4828(var32, var24 + 16 + var13, 16, var23, Client.field1032);
                        Rasterizer2D.method4864(var32, var24 + var13 + 16, var23, Client.field1127);
                        Rasterizer2D.method4864(var32 + 1, var13 + 16 + var24, var23, Client.field1127);
                        Rasterizer2D.method4837(var32, var13 + 16 + var24, 16, Client.field1127);
                        Rasterizer2D.method4837(var32, 17 + var13 + var24, 16, Client.field1127);
                        Rasterizer2D.method4864(var32 + 15, var24 + var13 + 16, var23, Client.field982);
                        Rasterizer2D.method4864(var32 + 14, var13 + 17 + var24, var23 - 1, Client.field982);
                        Rasterizer2D.method4837(var32, var23 + var24 + var13 + 15, 16, Client.field982);
                        Rasterizer2D.method4837(var32 + 1, var23 + 14 + var13 + var24, 15, Client.field982);
                     }

                     if(var10.type != 1) {
                        if(var10.type == 2) {
                           var32 = 0;

                           for(var20 = 0; var20 < var10.field2629; ++var20) {
                              for(var21 = 0; var21 < var10.originalWidth; ++var21) {
                                 var22 = var12 + var21 * (var10.paddingX + 32);
                                 var23 = var20 * (var10.paddingY + 32) + var13;
                                 if(var32 < 20) {
                                    var22 += var10.xSprites[var32];
                                    var23 += var10.field2677[var32];
                                 }

                                 if(var10.itemIds[var32] <= 0) {
                                    if(var10.field2687 != null && var32 < 20) {
                                       SpritePixels var50 = var10.method3935(var32);
                                       if(var50 != null) {
                                          var50.method4958(var22, var23);
                                       } else if(Widget.field2674) {
                                          class21.method156(var10);
                                       }
                                    }
                                 } else {
                                    boolean var45 = false;
                                    boolean var46 = false;
                                    var26 = var10.itemIds[var32] - 1;
                                    if(var22 + 32 > var2 && var22 < var4 && var23 + 32 > var3 && var23 < var5 || var10 == class14.field281 && var32 == Client.field988) {
                                       SpritePixels var27;
                                       if(Client.itemSelectionState == 1 && var32 == class25.selectedItemIndex && var10.id == class8.field232) {
                                          var27 = FileOnDisk.createSprite(var26, var10.itemQuantities[var32], 2, 0, 2, false);
                                       } else {
                                          var27 = FileOnDisk.createSprite(var26, var10.itemQuantities[var32], 1, 3153952, 2, false);
                                       }

                                       if(var27 != null) {
                                          if(var10 == class14.field281 && var32 == Client.field988) {
                                             var24 = MouseInput.field730 - Client.field1143;
                                             var25 = MouseInput.field731 - Client.field1019;
                                             if(var24 < 5 && var24 > -5) {
                                                var24 = 0;
                                             }

                                             if(var25 < 5 && var25 > -5) {
                                                var25 = 0;
                                             }

                                             if(Client.field1022 < 5) {
                                                var24 = 0;
                                                var25 = 0;
                                             }

                                             var27.method5024(var22 + var24, var25 + var23, 128);
                                             if(var1 != -1) {
                                                Widget var28 = var0[var1 & '\uffff'];
                                                int var29;
                                                if(var25 + var23 < Rasterizer2D.drawingAreaTop && var28.scrollY > 0) {
                                                   var29 = (Rasterizer2D.drawingAreaTop - var23 - var25) * Client.field1066 / 3;
                                                   if(var29 > Client.field1066 * 10) {
                                                      var29 = Client.field1066 * 10;
                                                   }

                                                   if(var29 > var28.scrollY) {
                                                      var29 = var28.scrollY;
                                                   }

                                                   var28.scrollY -= var29;
                                                   Client.field1019 += var29;
                                                   class21.method156(var28);
                                                }

                                                if(var23 + var25 + 32 > Rasterizer2D.drawingAreaRight && var28.scrollY < var28.scrollHeight - var28.height) {
                                                   var29 = (var25 + var23 + 32 - Rasterizer2D.drawingAreaRight) * Client.field1066 / 3;
                                                   if(var29 > Client.field1066 * 10) {
                                                      var29 = Client.field1066 * 10;
                                                   }

                                                   if(var29 > var28.scrollHeight - var28.height - var28.scrollY) {
                                                      var29 = var28.scrollHeight - var28.height - var28.scrollY;
                                                   }

                                                   var28.scrollY += var29;
                                                   Client.field1019 -= var29;
                                                   class21.method156(var28);
                                                }
                                             }
                                          } else if(var10 == class12.field262 && var32 == Client.field1182) {
                                             var27.method5024(var22, var23, 128);
                                          } else {
                                             var27.method4958(var22, var23);
                                          }
                                       } else {
                                          class21.method156(var10);
                                       }
                                    }
                                 }

                                 ++var32;
                              }
                           }
                        } else if(var10.type == 3) {
                           if(AbstractSoundSystem.method1998(var10)) {
                              var32 = var10.field2643;
                              if(var10 == class3.field14 && var10.field2645 != 0) {
                                 var32 = var10.field2645;
                              }
                           } else {
                              var32 = var10.textColor;
                              if(var10 == class3.field14 && var10.field2632 != 0) {
                                 var32 = var10.field2632;
                              }
                           }

                           if(var10.field2646) {
                              switch(var10.field2647.field3751) {
                              case 1:
                                 Rasterizer2D.method4829(var12, var13, var10.width, var10.height, var10.textColor, var10.field2643, 256 - (var10.opacity & 255), 256 - (var10.field2649 & 255));
                                 break;
                              case 2:
                                 Rasterizer2D.method4822(var12, var13, var10.width, var10.height, var10.textColor, var10.field2643, 256 - (var10.opacity & 255), 256 - (var10.field2649 & 255));
                                 break;
                              case 3:
                                 Rasterizer2D.method4862(var12, var13, var10.width, var10.height, var10.textColor, var10.field2643, 256 - (var10.opacity & 255), 256 - (var10.field2649 & 255));
                                 break;
                              case 4:
                                 Rasterizer2D.method4832(var12, var13, var10.width, var10.height, var10.textColor, var10.field2643, 256 - (var10.opacity & 255), 256 - (var10.field2649 & 255));
                                 break;
                              default:
                                 if(var14 == 0) {
                                    Rasterizer2D.method4828(var12, var13, var10.width, var10.height, var32);
                                 } else {
                                    Rasterizer2D.fillRectangle(var12, var13, var10.width, var10.height, var32, 256 - (var14 & 255));
                                 }
                              }
                           } else if(var14 == 0) {
                              Rasterizer2D.drawRectangle(var12, var13, var10.width, var10.height, var32);
                           } else {
                              Rasterizer2D.method4836(var12, var13, var10.width, var10.height, var32, 256 - (var14 & 255));
                           }
                        } else {
                           Font var41;
                           if(var10.type == 4) {
                              var41 = var10.method3917();
                              if(var41 == null) {
                                 if(Widget.field2674) {
                                    class21.method156(var10);
                                 }
                              } else {
                                 String var55 = var10.text;
                                 if(AbstractSoundSystem.method1998(var10)) {
                                    var20 = var10.field2643;
                                    if(var10 == class3.field14 && var10.field2645 != 0) {
                                       var20 = var10.field2645;
                                    }

                                    if(var10.field2678.length() > 0) {
                                       var55 = var10.field2678;
                                    }
                                 } else {
                                    var20 = var10.textColor;
                                    if(var10 == class3.field14 && var10.field2632 != 0) {
                                       var20 = var10.field2632;
                                    }
                                 }

                                 if(var10.hasScript && var10.itemId != -1) {
                                    ItemComposition var57 = class10.getItemDefinition(var10.itemId);
                                    var55 = var57.name;
                                    if(var55 == null) {
                                       var55 = "null";
                                    }

                                    if((var57.isStackable == 1 || var10.itemQuantity != 1) && var10.itemQuantity != -1) {
                                       var55 = class8.getColTags(16748608) + var55 + "</col>" + " " + 'x' + NPC.method1650(var10.itemQuantity);
                                    }
                                 }

                                 if(var10 == Client.field1068) {
                                    Object var10000 = null;
                                    var55 = "Please wait...";
                                    var20 = var10.textColor;
                                 }

                                 if(!var10.hasScript) {
                                    var55 = Friend.method1038(var55, var10);
                                 }

                                 var41.method4644(var55, var12, var13, var10.width, var10.height, var20, var10.textShadowed?0:-1, var10.field2718, var10.field2681, var10.field2644);
                              }
                           } else if(var10.type == 5) {
                              SpritePixels var42;
                              if(!var10.hasScript) {
                                 var42 = var10.method3936(AbstractSoundSystem.method1998(var10));
                                 if(var42 != null) {
                                    var42.method4958(var12, var13);
                                 } else if(Widget.field2674) {
                                    class21.method156(var10);
                                 }
                              } else {
                                 if(var10.itemId != -1) {
                                    var42 = FileOnDisk.createSprite(var10.itemId, var10.itemQuantity, var10.borderThickness, var10.sprite2, var10.field2675, false);
                                 } else {
                                    var42 = var10.method3936(false);
                                 }

                                 if(var42 == null) {
                                    if(Widget.field2674) {
                                       class21.method156(var10);
                                    }
                                 } else {
                                    var20 = var42.maxWidth;
                                    var21 = var42.maxHeight;
                                    if(!var10.field2655) {
                                       var22 = var10.width * 4096 / var20;
                                       if(var10.textureId != 0) {
                                          var42.method4971(var12 + var10.width / 2, var13 + var10.height / 2, var10.textureId, var22);
                                       } else if(var14 != 0) {
                                          var42.method4966(var12, var13, var10.width, var10.height, 256 - (var14 & 255));
                                       } else if(var20 == var10.width && var21 == var10.height) {
                                          var42.method4958(var12, var13);
                                       } else {
                                          var42.method4960(var12, var13, var10.width, var10.height);
                                       }
                                    } else {
                                       Rasterizer2D.setInnerDrawRegion(var12, var13, var12 + var10.width, var13 + var10.height);
                                       var22 = (var20 - 1 + var10.width) / var20;
                                       var23 = (var21 - 1 + var10.height) / var21;

                                       for(var24 = 0; var24 < var22; ++var24) {
                                          for(var25 = 0; var25 < var23; ++var25) {
                                             if(var10.textureId != 0) {
                                                var42.method4971(var12 + var20 * var24 + var20 / 2, var13 + var25 * var21 + var21 / 2, var10.textureId, 4096);
                                             } else if(var14 != 0) {
                                                var42.method5024(var12 + var24 * var20, var13 + var25 * var21, 256 - (var14 & 255));
                                             } else {
                                                var42.method4958(var12 + var20 * var24, var13 + var21 * var25);
                                             }
                                          }
                                       }

                                       Rasterizer2D.setDrawRegion(var2, var3, var4, var5);
                                    }
                                 }
                              }
                           } else {
                              ItemComposition var40;
                              if(var10.type == 6) {
                                 boolean var53 = AbstractSoundSystem.method1998(var10);
                                 if(var53) {
                                    var20 = var10.field2665;
                                 } else {
                                    var20 = var10.field2664;
                                 }

                                 Model var49 = null;
                                 var22 = 0;
                                 if(var10.itemId != -1) {
                                    var40 = class10.getItemDefinition(var10.itemId);
                                    if(var40 != null) {
                                       var40 = var40.method4450(var10.itemQuantity);
                                       var49 = var40.getModel(1);
                                       if(var49 != null) {
                                          var49.method2433();
                                          var22 = var49.modelHeight / 2;
                                       } else {
                                          class21.method156(var10);
                                       }
                                    }
                                 } else if(var10.modelType == 5) {
                                    if(var10.modelId == 0) {
                                       var49 = Client.field1080.method3882((Sequence)null, -1, (Sequence)null, -1);
                                    } else {
                                       var49 = class226.localPlayer.getModel();
                                    }
                                 } else if(var20 == -1) {
                                    var49 = var10.method3919((Sequence)null, -1, var53, class226.localPlayer.composition);
                                    if(var49 == null && Widget.field2674) {
                                       class21.method156(var10);
                                    }
                                 } else {
                                    Sequence var60 = class31.getAnimation(var20);
                                    var49 = var10.method3919(var60, var10.field2739, var53, class226.localPlayer.composition);
                                    if(var49 == null && Widget.field2674) {
                                       class21.method156(var10);
                                    }
                                 }

                                 Graphics3D.method2602(var12 + var10.width / 2, var13 + var10.height / 2);
                                 var23 = Graphics3D.SINE[var10.rotationX] * var10.modelZoom >> 16;
                                 var24 = Graphics3D.COSINE[var10.rotationX] * var10.modelZoom >> 16;
                                 if(var49 != null) {
                                    if(!var10.hasScript) {
                                       var49.method2476(0, var10.rotationZ, 0, var10.rotationX, 0, var23, var24);
                                    } else {
                                       var49.method2433();
                                       if(var10.field2680) {
                                          var49.method2446(0, var10.rotationZ, var10.rotationY, var10.rotationX, var10.field2661, var10.field2667 + var22 + var23, var24 + var10.field2667, var10.modelZoom);
                                       } else {
                                          var49.method2476(0, var10.rotationZ, var10.rotationY, var10.rotationX, var10.field2661, var10.field2667 + var23 + var22, var24 + var10.field2667);
                                       }
                                    }
                                 }

                                 Graphics3D.method2528();
                              } else {
                                 if(var10.type == 7) {
                                    var41 = var10.method3917();
                                    if(var41 == null) {
                                       if(Widget.field2674) {
                                          class21.method156(var10);
                                       }
                                       continue;
                                    }

                                    var20 = 0;

                                    for(var21 = 0; var21 < var10.field2629; ++var21) {
                                       for(var22 = 0; var22 < var10.originalWidth; ++var22) {
                                          if(var10.itemIds[var20] > 0) {
                                             var40 = class10.getItemDefinition(var10.itemIds[var20] - 1);
                                             String var33;
                                             if(var40.isStackable != 1 && var10.itemQuantities[var20] == 1) {
                                                var33 = class8.getColTags(16748608) + var40.name + "</col>";
                                             } else {
                                                var33 = class8.getColTags(16748608) + var40.name + "</col>" + " " + 'x' + NPC.method1650(var10.itemQuantities[var20]);
                                             }

                                             var25 = var12 + var22 * (115 + var10.paddingX);
                                             var26 = var21 * (var10.paddingY + 12) + var13;
                                             if(var10.field2718 == 0) {
                                                var41.method4640(var33, var25, var26, var10.textColor, var10.textShadowed?0:-1);
                                             } else if(var10.field2718 == 1) {
                                                var41.method4643(var33, var25 + var10.width / 2, var26, var10.textColor, var10.textShadowed?0:-1);
                                             } else {
                                                var41.method4681(var33, var25 + var10.width - 1, var26, var10.textColor, var10.textShadowed?0:-1);
                                             }
                                          }

                                          ++var20;
                                       }
                                    }
                                 }

                                 if(var10.type == 8 && var10 == class48.field616 && Client.field917 == Client.field1121) {
                                    var32 = 0;
                                    var20 = 0;
                                    Font var34 = class112.font_p12full;
                                    String var35 = var10.text;

                                    String var59;
                                    for(var35 = Friend.method1038(var35, var10); var35.length() > 0; var20 += var34.verticalSpace + 1) {
                                       var24 = var35.indexOf("<br>");
                                       if(var24 != -1) {
                                          var59 = var35.substring(0, var24);
                                          var35 = var35.substring(var24 + 4);
                                       } else {
                                          var59 = var35;
                                          var35 = "";
                                       }

                                       var25 = var34.method4635(var59);
                                       if(var25 > var32) {
                                          var32 = var25;
                                       }
                                    }

                                    var32 += 6;
                                    var20 += 7;
                                    var24 = var12 + var10.width - 5 - var32;
                                    var25 = var13 + var10.height + 5;
                                    if(var24 < var12 + 5) {
                                       var24 = var12 + 5;
                                    }

                                    if(var24 + var32 > var4) {
                                       var24 = var4 - var32;
                                    }

                                    if(var20 + var25 > var5) {
                                       var25 = var5 - var20;
                                    }

                                    Rasterizer2D.method4828(var24, var25, var32, var20, 16777120);
                                    Rasterizer2D.drawRectangle(var24, var25, var32, var20, 0);
                                    var35 = var10.text;
                                    var26 = var34.verticalSpace + var25 + 2;

                                    for(var35 = Friend.method1038(var35, var10); var35.length() > 0; var26 += var34.verticalSpace + 1) {
                                       var37 = var35.indexOf("<br>");
                                       if(var37 != -1) {
                                          var59 = var35.substring(0, var37);
                                          var35 = var35.substring(var37 + 4);
                                       } else {
                                          var59 = var35;
                                          var35 = "";
                                       }

                                       var34.method4640(var59, var24 + 3, var26, 0, -1);
                                    }
                                 }

                                 if(var10.type == 9) {
                                    if(var10.field2663) {
                                       var32 = var12;
                                       var20 = var13 + var10.height;
                                       var21 = var12 + var10.width;
                                       var22 = var13;
                                    } else {
                                       var32 = var12;
                                       var20 = var13;
                                       var21 = var12 + var10.width;
                                       var22 = var13 + var10.height;
                                    }

                                    if(var10.field2650 == 1) {
                                       Rasterizer2D.drawLine(var32, var20, var21, var22, var10.textColor);
                                    } else {
                                       class60.method977(var32, var20, var21, var22, var10.textColor, var10.field2650);
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

   @ObfuscatedName("hq")
   @ObfuscatedSignature(
      signature = "([Lho;Lho;ZB)V",
      garbageValue = "-36"
   )
   static void method1465(Widget[] var0, Widget var1, boolean var2) {
      int var3 = var1.scrollWidth != 0?var1.scrollWidth:var1.width;
      int var4 = var1.scrollHeight != 0?var1.scrollHeight:var1.height;
      class41.method555(var0, var1.id, var3, var4, var2);
      if(var1.children != null) {
         class41.method555(var1.children, var1.id, var3, var4, var2);
      }

      WidgetNode var5 = (WidgetNode)Client.componentTable.get((long)var1.id);
      if(var5 != null) {
         int var6 = var5.id;
         if(class9.loadWidget(var6)) {
            class41.method555(Widget.widgets[var6], -1, var3, var4, var2);
         }
      }

      if(var1.contentType == 1337) {
         ;
      }

   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;I)Ljava/lang/String;",
      garbageValue = "-1002767576"
   )
   public static String method1472(CharSequence var0) {
      return MouseInput.method974('*', var0.length());
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(Ljava/io/File;ZI)Z",
      garbageValue = "-165246648"
   )
   static boolean method1466(File var0, boolean var1) {
      try {
         RandomAccessFile var2 = new RandomAccessFile(var0, "rw");
         int var3 = var2.read();
         var2.seek(0L);
         var2.write(var3);
         var2.seek(0L);
         var2.close();
         if(var1) {
            var0.delete();
         }

         return true;
      } catch (Exception var4) {
         return false;
      }
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(Lip;Lip;Lip;B)V",
      garbageValue = "39"
   )
   public static void method1471(IndexDataBase var0, IndexDataBase var1, IndexDataBase var2) {
      Sequence.seq_ref = var0;
      Sequence.skel_ref = var1;
      Sequence.skin_ref = var2;
   }
}
