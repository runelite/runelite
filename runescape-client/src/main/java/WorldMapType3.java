import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ag")
@Implements("WorldMapType3")
public class WorldMapType3 implements WorldMapSectionBase {
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 1992808171
   )
   int field385;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 902898497
   )
   int field383;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 1661713291
   )
   int field386;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 505849137
   )
   int field377;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 1952494241
   )
   int field388;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 1861643521
   )
   int field384;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -1060027551
   )
   int field382;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -1995492177
   )
   int field381;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -669825871
   )
   int field387;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -1673837433
   )
   int field380;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 1645853363
   )
   int field378;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 1749456225
   )
   int field389;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 1762920899
   )
   int field379;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -637438367
   )
   int field391;

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(III)Z",
      garbageValue = "-39567884"
   )
   public boolean vmethod705(int var1, int var2) {
      return var1 >= (this.field383 << 6) + (this.field386 << 3) && var1 <= (this.field383 << 6) + (this.field388 << 3) + 7 && var2 >= (this.field381 << 6) + (this.field387 << 3) && var2 <= (this.field381 << 6) + (this.field378 << 3) + 7;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(IIII)Z",
      garbageValue = "2062801574"
   )
   public boolean vmethod704(int var1, int var2, int var3) {
      return var1 >= this.field385 && var1 < this.field377 + this.field385?var2 >= (this.field384 << 6) + (this.field382 << 3) && var2 <= (this.field384 << 6) + (this.field380 << 3) + 7 && var3 >= (this.field379 << 6) + (this.field389 << 3) && var3 <= (this.field379 << 6) + (this.field391 << 3) + 7:false;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Lae;B)V",
      garbageValue = "-3"
   )
   public void vmethod703(WorldMapData var1) {
      if(var1.field457 > this.field383) {
         var1.field457 = this.field383;
      }

      if(var1.field460 < this.field383) {
         var1.field460 = this.field383;
      }

      if(var1.field453 > this.field381) {
         var1.field453 = this.field381;
      }

      if(var1.field462 < this.field381) {
         var1.field462 = this.field381;
      }

   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(III)Lhq;",
      garbageValue = "578346769"
   )
   public Coordinates vmethod728(int var1, int var2) {
      if(!this.vmethod705(var1, var2)) {
         return null;
      } else {
         int var3 = this.field384 * 64 - this.field383 * 64 + (this.field382 * 8 - this.field386 * 8) + var1;
         int var4 = this.field389 * 8 - this.field387 * 8 + this.field379 * 64 - this.field381 * 64 + var2;
         return new Coordinates(this.field385, var3, var4);
      }
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(IIII)[I",
      garbageValue = "-670381390"
   )
   public int[] vmethod706(int var1, int var2, int var3) {
      if(!this.vmethod704(var1, var2, var3)) {
         return null;
      } else {
         int[] var4 = new int[]{this.field386 * 8 - this.field382 * 8 + this.field383 * 64 - this.field384 * 64 + var2, this.field387 * 8 - this.field389 * 8 + this.field381 * 64 - this.field379 * 64 + var3};
         return var4;
      }
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(Lfh;B)V",
      garbageValue = "0"
   )
   public void vmethod716(Buffer var1) {
      this.field385 = var1.readUnsignedByte();
      this.field377 = var1.readUnsignedByte();
      this.field384 = var1.readUnsignedShort();
      this.field382 = var1.readUnsignedByte();
      this.field380 = var1.readUnsignedByte();
      this.field379 = var1.readUnsignedShort();
      this.field389 = var1.readUnsignedByte();
      this.field391 = var1.readUnsignedByte();
      this.field383 = var1.readUnsignedShort();
      this.field386 = var1.readUnsignedByte();
      this.field388 = var1.readUnsignedByte();
      this.field381 = var1.readUnsignedShort();
      this.field387 = var1.readUnsignedByte();
      this.field378 = var1.readUnsignedByte();
      this.method193();
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1176651731"
   )
   void method193() {
   }

   @ObfuscatedName("he")
   @ObfuscatedSignature(
      signature = "([Lhg;IIIIIIIIB)V",
      garbageValue = "1"
   )
   @Export("gameDraw")
   static final void gameDraw(Widget[] var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
      Rasterizer2D.setDrawRegion(var2, var3, var4, var5);
      Graphics3D.method2627();

      for(int var9 = 0; var9 < var0.length; ++var9) {
         Widget var10 = var0[var9];
         if(var10 != null && (var10.parentId == var1 || var1 == -1412584499 && var10 == Client.field1117)) {
            int var11;
            if(var8 == -1) {
               Client.widgetPositionX[Client.field1105] = var10.relativeX + var6;
               Client.widgetPositionY[Client.field1105] = var7 + var10.relativeY;
               Client.widgetBoundsWidth[Client.field1105] = var10.width;
               Client.widgetBoundsHeight[Client.field1105] = var10.height;
               var11 = ++Client.field1105 - 1;
            } else {
               var11 = var8;
            }

            var10.boundsIndex = var11;
            var10.loopCycle = Client.gameCycle;
            if(!var10.hasScript || !class41.method543(var10)) {
               int var12;
               if(var10.contentType > 0) {
                  var12 = var10.contentType;
                  if(var12 == 324) {
                     if(Client.field1176 == -1) {
                        Client.field1176 = var10.spriteId;
                        Client.field1177 = var10.field2659;
                     }

                     if(Client.field1035.isFemale) {
                        var10.spriteId = Client.field1176;
                     } else {
                        var10.spriteId = Client.field1177;
                     }
                  } else if(var12 == 325) {
                     if(Client.field1176 == -1) {
                        Client.field1176 = var10.spriteId;
                        Client.field1177 = var10.field2659;
                     }

                     if(Client.field1035.isFemale) {
                        var10.spriteId = Client.field1177;
                     } else {
                        var10.spriteId = Client.field1176;
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
               if(var10 == Client.field1117) {
                  if(var1 != -1412584499 && !var10.field2701) {
                     Player.field906 = var0;
                     class14.field295 = var6;
                     class91.field1399 = var7;
                     continue;
                  }

                  if(Client.field1086 && Client.field1080) {
                     var15 = MouseInput.field718;
                     var16 = MouseInput.field719;
                     var15 -= Client.field1012;
                     var16 -= Client.field1078;
                     if(var15 < Client.field1081) {
                        var15 = Client.field1081;
                     }

                     if(var15 + var10.width > Client.field1081 + Client.field1076.width) {
                        var15 = Client.field1081 + Client.field1076.width - var10.width;
                     }

                     if(var16 < Client.field1082) {
                        var16 = Client.field1082;
                     }

                     if(var16 + var10.height > Client.field1082 + Client.field1076.height) {
                        var16 = Client.field1082 + Client.field1076.height - var10.height;
                     }

                     var12 = var15;
                     var13 = var16;
                  }

                  if(!var10.field2701) {
                     var14 = 128;
                  }
               }

               int var17;
               int var18;
               int var20;
               int var21;
               int var22;
               int var33;
               if(var10.type == 2) {
                  var15 = var2;
                  var16 = var3;
                  var17 = var4;
                  var18 = var5;
               } else if(var10.type == 9) {
                  var33 = var12;
                  var20 = var13;
                  var21 = var12 + var10.width;
                  var22 = var13 + var10.height;
                  if(var21 < var12) {
                     var33 = var21;
                     var21 = var12;
                  }

                  if(var22 < var13) {
                     var20 = var22;
                     var22 = var13;
                  }

                  ++var21;
                  ++var22;
                  var15 = var33 > var2?var33:var2;
                  var16 = var20 > var3?var20:var3;
                  var17 = var21 < var4?var21:var4;
                  var18 = var22 < var5?var22:var5;
               } else {
                  var33 = var12 + var10.width;
                  var20 = var13 + var10.height;
                  var15 = var12 > var2?var12:var2;
                  var16 = var13 > var3?var13:var3;
                  var17 = var33 < var4?var33:var4;
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
                           class290.font_p12full.method4778("Fps:" + GameEngine.FPS, var12 + var10.width, var13, 16776960, -1);
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

                           class290.font_p12full.method4778("Mem:" + var20 + "k", var12 + var10.width, var13, var21, -1);
                           var13 += 15;
                        }
                        continue;
                     }

                     if(var10.contentType == 1337) {
                        Client.field1051 = var12;
                        Client.field1052 = var13;
                        ScriptState.method1074(var12, var13, var10.width, var10.height);
                        Client.field1107[var10.boundsIndex] = true;
                        Rasterizer2D.setDrawRegion(var2, var3, var4, var5);
                        continue;
                     }

                     if(var10.contentType == 1338) {
                        class35.method495();
                        class211 var43 = var10.method4008(false);
                        if(var43 != null) {
                           Rasterizer2D.setDrawRegion(var12, var13, var12 + var43.field2577, var13 + var43.field2578);
                           if(Client.field1138 != 2 && Client.field1138 != 5) {
                              var20 = Client.mapAngle & 2047;
                              var21 = class54.localPlayer.x / 32 + 48;
                              var22 = 464 - class54.localPlayer.y / 32;
                              class56.field667.method5184(var12, var13, var43.field2577, var43.field2578, var21, var22, var20, 256, var43.field2581, var43.field2579);

                              for(var23 = 0; var23 < Client.field1132; ++var23) {
                                 var24 = Client.field1133[var23] * 4 + 2 - class54.localPlayer.x / 32;
                                 var25 = Client.field1134[var23] * 4 + 2 - class54.localPlayer.y / 32;
                                 class276.drawDot(var12, var13, var24, var25, Client.field1075[var23], var43);
                              }

                              var23 = 0;

                              while(true) {
                                 if(var23 >= 104) {
                                    for(var23 = 0; var23 < Client.field952; ++var23) {
                                       NPC var54 = Client.cachedNPCs[Client.npcIndices[var23]];
                                       if(var54 != null && var54.hasConfig()) {
                                          NPCComposition var48 = var54.composition;
                                          if(var48 != null && var48.configs != null) {
                                             var48 = var48.transform();
                                          }

                                          if(var48 != null && var48.isMinimapVisible && var48.field3574) {
                                             var26 = var54.x / 32 - class54.localPlayer.x / 32;
                                             var27 = var54.y / 32 - class54.localPlayer.y / 32;
                                             class276.drawDot(var12, var13, var26, var27, class44.mapDots[1], var43);
                                          }
                                       }
                                    }

                                    var23 = class97.field1493;
                                    int[] var55 = class97.field1494;

                                    for(var25 = 0; var25 < var23; ++var25) {
                                       Player var36 = Client.cachedPlayers[var55[var25]];
                                       if(var36 != null && var36.hasConfig() && !var36.hidden && var36 != class54.localPlayer) {
                                          var27 = var36.x / 32 - class54.localPlayer.x / 32;
                                          int var37 = var36.y / 32 - class54.localPlayer.y / 32;
                                          boolean var49 = false;
                                          if(class9.isFriended(var36.name, true)) {
                                             var49 = true;
                                          }

                                          boolean var30 = false;

                                          for(int var31 = 0; var31 < class5.clanChatCount; ++var31) {
                                             if(var36.name.equals(WorldMapData.clanMembers[var31].username)) {
                                                var30 = true;
                                                break;
                                             }
                                          }

                                          boolean var47 = false;
                                          if(class54.localPlayer.team != 0 && var36.team != 0 && var36.team == class54.localPlayer.team) {
                                             var47 = true;
                                          }

                                          if(var49) {
                                             class276.drawDot(var12, var13, var27, var37, class44.mapDots[3], var43);
                                          } else if(var47) {
                                             class276.drawDot(var12, var13, var27, var37, class44.mapDots[4], var43);
                                          } else if(var30) {
                                             class276.drawDot(var12, var13, var27, var37, class44.mapDots[5], var43);
                                          } else {
                                             class276.drawDot(var12, var13, var27, var37, class44.mapDots[2], var43);
                                          }
                                       }
                                    }

                                    if(Client.field1103 != 0 && Client.gameCycle % 20 < 10) {
                                       if(Client.field1103 == 1 && Client.field933 >= 0 && Client.field933 < Client.cachedNPCs.length) {
                                          NPC var50 = Client.cachedNPCs[Client.field933];
                                          if(var50 != null) {
                                             var26 = var50.x / 32 - class54.localPlayer.x / 32;
                                             var27 = var50.y / 32 - class54.localPlayer.y / 32;
                                             class226.method4082(var12, var13, var26, var27, Script.field1523[1], var43);
                                          }
                                       }

                                       if(Client.field1103 == 2) {
                                          var25 = 2 + (Client.hintArrowX * 4 - class25.baseX * 4) - class54.localPlayer.x / 32;
                                          var26 = Client.hintArrowY * 4 - ScriptEvent.baseY * 4 + 2 - class54.localPlayer.y / 32;
                                          class226.method4082(var12, var13, var25, var26, Script.field1523[1], var43);
                                       }

                                       if(Client.field1103 == 10 && Client.field996 >= 0 && Client.field996 < Client.cachedPlayers.length) {
                                          Player var51 = Client.cachedPlayers[Client.field996];
                                          if(var51 != null) {
                                             var26 = var51.x / 32 - class54.localPlayer.x / 32;
                                             var27 = var51.y / 32 - class54.localPlayer.y / 32;
                                             class226.method4082(var12, var13, var26, var27, Script.field1523[1], var43);
                                          }
                                       }
                                    }

                                    if(Client.destinationX != 0) {
                                       var25 = Client.destinationX * 4 + 2 - class54.localPlayer.x / 32;
                                       var26 = 2 + Client.destinationY * 4 - class54.localPlayer.y / 32;
                                       class276.drawDot(var12, var13, var25, var26, Script.field1523[0], var43);
                                    }

                                    if(!class54.localPlayer.hidden) {
                                       Rasterizer2D.method4973(var43.field2577 / 2 + var12 - 1, var43.field2578 / 2 + var13 - 1, 3, 3, 16777215);
                                    }
                                    break;
                                 }

                                 for(var24 = 0; var24 < 104; ++var24) {
                                    Deque var32 = Client.groundItemDeque[class29.plane][var23][var24];
                                    if(var32 != null) {
                                       var26 = var23 * 4 + 2 - class54.localPlayer.x / 32;
                                       var27 = 2 + var24 * 4 - class54.localPlayer.y / 32;
                                       class276.drawDot(var12, var13, var26, var27, class44.mapDots[0], var43);
                                    }
                                 }

                                 ++var23;
                              }
                           } else {
                              Rasterizer2D.method4988(var12, var13, 0, var43.field2581, var43.field2579);
                           }

                           Client.field1159[var11] = true;
                        }

                        Rasterizer2D.setDrawRegion(var2, var3, var4, var5);
                        continue;
                     }

                     if(var10.contentType == 1339) {
                        class233.method4110(var10, var12, var13, var11);
                        Rasterizer2D.setDrawRegion(var2, var3, var4, var5);
                        continue;
                     }

                     if(var10.contentType == 1400) {
                        BaseVarType.renderOverview.extractWorldmap(var12, var13, var10.width, var10.height, Client.gameCycle);
                     }

                     if(var10.contentType == 1401) {
                        BaseVarType.renderOverview.extractData(var12, var13, var10.width, var10.height);
                     }
                  }

                  if(var10.type == 0) {
                     if(!var10.hasScript && class41.method543(var10) && var10 != class43.field569) {
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
                        class33.drawWidget(var19.id, var15, var16, var17, var18, var12, var13, var11);
                     }

                     Rasterizer2D.setDrawRegion(var2, var3, var4, var5);
                     Graphics3D.method2627();
                  }

                  if(Client.isResized || Client.field1050[var11] || Client.gameDrawingMode > 1) {
                     if(var10.type == 0 && !var10.hasScript && var10.scrollHeight > var10.height) {
                        var33 = var12 + var10.width;
                        var20 = var10.scrollY;
                        var21 = var10.height;
                        var22 = var10.scrollHeight;
                        class27.field401[0].method5068(var33, var13);
                        class27.field401[1].method5068(var33, var21 + var13 - 16);
                        Rasterizer2D.method4973(var33, var13 + 16, 16, var21 - 32, Client.field979);
                        var23 = var21 * (var21 - 32) / var22;
                        if(var23 < 8) {
                           var23 = 8;
                        }

                        var24 = var20 * (var21 - 32 - var23) / (var22 - var21);
                        Rasterizer2D.method4973(var33, var24 + var13 + 16, 16, var23, Client.field980);
                        Rasterizer2D.method4984(var33, var24 + var13 + 16, var23, Client.field982);
                        Rasterizer2D.method4984(var33 + 1, var24 + var13 + 16, var23, Client.field982);
                        Rasterizer2D.method4982(var33, var13 + var24 + 16, 16, Client.field982);
                        Rasterizer2D.method4982(var33, var13 + var24 + 17, 16, Client.field982);
                        Rasterizer2D.method4984(var33 + 15, var24 + var13 + 16, var23, Client.field970);
                        Rasterizer2D.method4984(var33 + 14, var24 + var13 + 17, var23 - 1, Client.field970);
                        Rasterizer2D.method4982(var33, var24 + var13 + var23 + 15, 16, Client.field970);
                        Rasterizer2D.method4982(var33 + 1, var13 + var24 + var23 + 14, 15, Client.field970);
                     }

                     if(var10.type != 1) {
                        if(var10.type == 2) {
                           var33 = 0;

                           for(var20 = 0; var20 < var10.field2635; ++var20) {
                              for(var21 = 0; var21 < var10.originalWidth; ++var21) {
                                 var22 = var21 * (var10.paddingX + 32) + var12;
                                 var23 = var13 + var20 * (var10.paddingY + 32);
                                 if(var33 < 20) {
                                    var22 += var10.xSprites[var33];
                                    var23 += var10.field2692[var33];
                                 }

                                 if(var10.itemIds[var33] <= 0) {
                                    if(var10.field2709 != null && var33 < 20) {
                                       SpritePixels var52 = var10.method4006(var33);
                                       if(var52 != null) {
                                          var52.method5143(var22, var23);
                                       } else if(Widget.field2718) {
                                          class255.method4531(var10);
                                       }
                                    }
                                 } else {
                                    boolean var45 = false;
                                    boolean var46 = false;
                                    var26 = var10.itemIds[var33] - 1;
                                    if(var22 + 32 > var2 && var22 < var4 && var23 + 32 > var3 && var23 < var5 || var10 == class31.field451 && var33 == Client.field1126) {
                                       SpritePixels var34;
                                       if(Client.itemSelectionState == 1 && var33 == class31.selectedItemIndex && var10.id == class10.field261) {
                                          var34 = class158.createSprite(var26, var10.itemQuantities[var33], 2, 0, 2, false);
                                       } else {
                                          var34 = class158.createSprite(var26, var10.itemQuantities[var33], 1, 3153952, 2, false);
                                       }

                                       if(var34 != null) {
                                          if(var10 == class31.field451 && var33 == Client.field1126) {
                                             var24 = MouseInput.field718 - Client.field1016;
                                             var25 = MouseInput.field719 - Client.field1017;
                                             if(var24 < 5 && var24 > -5) {
                                                var24 = 0;
                                             }

                                             if(var25 < 5 && var25 > -5) {
                                                var25 = 0;
                                             }

                                             if(Client.field1079 < 5) {
                                                var24 = 0;
                                                var25 = 0;
                                             }

                                             var34.method5106(var22 + var24, var25 + var23, 128);
                                             if(var1 != -1) {
                                                Widget var28 = var0[var1 & '\uffff'];
                                                int var29;
                                                if(var25 + var23 < Rasterizer2D.drawingAreaTop && var28.scrollY > 0) {
                                                   var29 = (Rasterizer2D.drawingAreaTop - var23 - var25) * Client.field1020 / 3;
                                                   if(var29 > Client.field1020 * 10) {
                                                      var29 = Client.field1020 * 10;
                                                   }

                                                   if(var29 > var28.scrollY) {
                                                      var29 = var28.scrollY;
                                                   }

                                                   var28.scrollY -= var29;
                                                   Client.field1017 += var29;
                                                   class255.method4531(var28);
                                                }

                                                if(var25 + var23 + 32 > Rasterizer2D.drawingAreaRight && var28.scrollY < var28.scrollHeight - var28.height) {
                                                   var29 = Client.field1020 * (var23 + var25 + 32 - Rasterizer2D.drawingAreaRight) / 3;
                                                   if(var29 > Client.field1020 * 10) {
                                                      var29 = Client.field1020 * 10;
                                                   }

                                                   if(var29 > var28.scrollHeight - var28.height - var28.scrollY) {
                                                      var29 = var28.scrollHeight - var28.height - var28.scrollY;
                                                   }

                                                   var28.scrollY += var29;
                                                   Client.field1017 -= var29;
                                                   class255.method4531(var28);
                                                }
                                             }
                                          } else if(var10 == class227.field3110 && var33 == Client.field957) {
                                             var34.method5106(var22, var23, 128);
                                          } else {
                                             var34.method5143(var22, var23);
                                          }
                                       } else {
                                          class255.method4531(var10);
                                       }
                                    }
                                 }

                                 ++var33;
                              }
                           }
                        } else if(var10.type == 3) {
                           if(MessageNode.method1132(var10)) {
                              var33 = var10.field2649;
                              if(var10 == class43.field569 && var10.field2631 != 0) {
                                 var33 = var10.field2631;
                              }
                           } else {
                              var33 = var10.textColor;
                              if(var10 == class43.field569 && var10.field2650 != 0) {
                                 var33 = var10.field2650;
                              }
                           }

                           if(var10.field2655) {
                              switch(var10.field2653.field3754) {
                              case 1:
                                 Rasterizer2D.method4974(var12, var13, var10.width, var10.height, var10.textColor, var10.field2649, 256 - (var10.opacity & 255), 256 - (var10.field2644 & 255));
                                 break;
                              case 2:
                                 Rasterizer2D.method4975(var12, var13, var10.width, var10.height, var10.textColor, var10.field2649, 256 - (var10.opacity & 255), 256 - (var10.field2644 & 255));
                                 break;
                              case 3:
                                 Rasterizer2D.method4995(var12, var13, var10.width, var10.height, var10.textColor, var10.field2649, 256 - (var10.opacity & 255), 256 - (var10.field2644 & 255));
                                 break;
                              case 4:
                                 Rasterizer2D.method5011(var12, var13, var10.width, var10.height, var10.textColor, var10.field2649, 256 - (var10.opacity & 255), 256 - (var10.field2644 & 255));
                                 break;
                              default:
                                 if(var14 == 0) {
                                    Rasterizer2D.method4973(var12, var13, var10.width, var10.height, var33);
                                 } else {
                                    Rasterizer2D.fillRectangle(var12, var13, var10.width, var10.height, var33, 256 - (var14 & 255));
                                 }
                              }
                           } else if(var14 == 0) {
                              Rasterizer2D.drawRectangle(var12, var13, var10.width, var10.height, var33);
                           } else {
                              Rasterizer2D.method4981(var12, var13, var10.width, var10.height, var33, 256 - (var14 & 255));
                           }
                        } else {
                           Font var41;
                           if(var10.type == 4) {
                              var41 = var10.method4033();
                              if(var41 == null) {
                                 if(Widget.field2718) {
                                    class255.method4531(var10);
                                 }
                              } else {
                                 String var58 = var10.text;
                                 if(MessageNode.method1132(var10)) {
                                    var20 = var10.field2649;
                                    if(var10 == class43.field569 && var10.field2631 != 0) {
                                       var20 = var10.field2631;
                                    }

                                    if(var10.field2684.length() > 0) {
                                       var58 = var10.field2684;
                                    }
                                 } else {
                                    var20 = var10.textColor;
                                    if(var10 == class43.field569 && var10.field2650 != 0) {
                                       var20 = var10.field2650;
                                    }
                                 }

                                 if(var10.hasScript && var10.itemId != -1) {
                                    ItemComposition var59 = ClassInfo.getItemDefinition(var10.itemId);
                                    var58 = var59.name;
                                    if(var58 == null) {
                                       var58 = "null";
                                    }

                                    if((var59.isStackable == 1 || var10.itemQuantity != 1) && var10.itemQuantity != -1) {
                                       var58 = RSSocket.getColTags(16748608) + var58 + "</col>" + " " + 'x' + FrameMap.method2709(var10.itemQuantity);
                                    }
                                 }

                                 if(var10 == Client.field1066) {
                                    Object var10000 = null;
                                    var58 = "Please wait...";
                                    var20 = var10.textColor;
                                 }

                                 if(!var10.hasScript) {
                                    var58 = WorldMapType2.method527(var58, var10);
                                 }

                                 var41.method4780(var58, var12, var13, var10.width, var10.height, var20, var10.textShadowed?0:-1, var10.field2743, var10.field2757, var10.field2751);
                              }
                           } else if(var10.type == 5) {
                              SpritePixels var42;
                              if(!var10.hasScript) {
                                 var42 = var10.method4004(MessageNode.method1132(var10));
                                 if(var42 != null) {
                                    var42.method5143(var12, var13);
                                 } else if(Widget.field2718) {
                                    class255.method4531(var10);
                                 }
                              } else {
                                 if(var10.itemId != -1) {
                                    var42 = class158.createSprite(var10.itemId, var10.itemQuantity, var10.borderThickness, var10.sprite2, var10.field2681, false);
                                 } else {
                                    var42 = var10.method4004(false);
                                 }

                                 if(var42 == null) {
                                    if(Widget.field2718) {
                                       class255.method4531(var10);
                                    }
                                 } else {
                                    var20 = var42.maxWidth;
                                    var21 = var42.maxHeight;
                                    if(!var10.field2661) {
                                       var22 = var10.width * 4096 / var20;
                                       if(var10.textureId != 0) {
                                          var42.method5113(var10.width / 2 + var12, var10.height / 2 + var13, var10.textureId, var22);
                                       } else if(var14 != 0) {
                                          var42.method5108(var12, var13, var10.width, var10.height, 256 - (var14 & 255));
                                       } else if(var20 == var10.width && var21 == var10.height) {
                                          var42.method5143(var12, var13);
                                       } else {
                                          var42.method5102(var12, var13, var10.width, var10.height);
                                       }
                                    } else {
                                       Rasterizer2D.setInnerDrawRegion(var12, var13, var12 + var10.width, var13 + var10.height);
                                       var22 = (var20 - 1 + var10.width) / var20;
                                       var23 = (var21 - 1 + var10.height) / var21;

                                       for(var24 = 0; var24 < var22; ++var24) {
                                          for(var25 = 0; var25 < var23; ++var25) {
                                             if(var10.textureId != 0) {
                                                var42.method5113(var20 / 2 + var12 + var20 * var24, var21 / 2 + var13 + var21 * var25, var10.textureId, 4096);
                                             } else if(var14 != 0) {
                                                var42.method5106(var12 + var20 * var24, var21 * var25 + var13, 256 - (var14 & 255));
                                             } else {
                                                var42.method5143(var12 + var20 * var24, var13 + var25 * var21);
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
                                 boolean var53 = MessageNode.method1132(var10);
                                 if(var53) {
                                    var20 = var10.field2620;
                                 } else {
                                    var20 = var10.field2633;
                                 }

                                 Model var56 = null;
                                 var22 = 0;
                                 if(var10.itemId != -1) {
                                    var40 = ClassInfo.getItemDefinition(var10.itemId);
                                    if(var40 != null) {
                                       var40 = var40.method4591(var10.itemQuantity);
                                       var56 = var40.getModel(1);
                                       if(var56 != null) {
                                          var56.method2519();
                                          var22 = var56.modelHeight / 2;
                                       } else {
                                          class255.method4531(var10);
                                       }
                                    }
                                 } else if(var10.modelType == 5) {
                                    if(var10.modelId == 0) {
                                       var56 = Client.field1035.method3976((Sequence)null, -1, (Sequence)null, -1);
                                    } else {
                                       var56 = class54.localPlayer.getModel();
                                    }
                                 } else if(var20 == -1) {
                                    var56 = var10.method4007((Sequence)null, -1, var53, class54.localPlayer.composition);
                                    if(var56 == null && Widget.field2718) {
                                       class255.method4531(var10);
                                    }
                                 } else {
                                    Sequence var60 = Ignore.getAnimation(var20);
                                    var56 = var10.method4007(var60, var10.field2745, var53, class54.localPlayer.composition);
                                    if(var56 == null && Widget.field2718) {
                                       class255.method4531(var10);
                                    }
                                 }

                                 Graphics3D.method2630(var10.width / 2 + var12, var10.height / 2 + var13);
                                 var23 = Graphics3D.SINE[var10.rotationX] * var10.modelZoom >> 16;
                                 var24 = Graphics3D.COSINE[var10.rotationX] * var10.modelZoom >> 16;
                                 if(var56 != null) {
                                    if(!var10.hasScript) {
                                       var56.method2532(0, var10.rotationZ, 0, var10.rotationX, 0, var23, var24);
                                    } else {
                                       var56.method2519();
                                       if(var10.field2680) {
                                          var56.method2533(0, var10.rotationZ, var10.rotationY, var10.rotationX, var10.field2663, var23 + var22 + var10.field2621, var24 + var10.field2621, var10.modelZoom);
                                       } else {
                                          var56.method2532(0, var10.rotationZ, var10.rotationY, var10.rotationX, var10.field2663, var23 + var22 + var10.field2621, var24 + var10.field2621);
                                       }
                                    }
                                 }

                                 Graphics3D.method2629();
                              } else {
                                 if(var10.type == 7) {
                                    var41 = var10.method4033();
                                    if(var41 == null) {
                                       if(Widget.field2718) {
                                          class255.method4531(var10);
                                       }
                                       continue;
                                    }

                                    var20 = 0;

                                    for(var21 = 0; var21 < var10.field2635; ++var21) {
                                       for(var22 = 0; var22 < var10.originalWidth; ++var22) {
                                          if(var10.itemIds[var20] > 0) {
                                             var40 = ClassInfo.getItemDefinition(var10.itemIds[var20] - 1);
                                             String var35;
                                             if(var40.isStackable != 1 && var10.itemQuantities[var20] == 1) {
                                                var35 = RSSocket.getColTags(16748608) + var40.name + "</col>";
                                             } else {
                                                var35 = RSSocket.getColTags(16748608) + var40.name + "</col>" + " " + 'x' + FrameMap.method2709(var10.itemQuantities[var20]);
                                             }

                                             var25 = var12 + var22 * (var10.paddingX + 115);
                                             var26 = var13 + var21 * (var10.paddingY + 12);
                                             if(var10.field2743 == 0) {
                                                var41.method4776(var35, var25, var26, var10.textColor, var10.textShadowed?0:-1);
                                             } else if(var10.field2743 == 1) {
                                                var41.method4779(var35, var10.width / 2 + var25, var26, var10.textColor, var10.textShadowed?0:-1);
                                             } else {
                                                var41.method4778(var35, var25 + var10.width - 1, var26, var10.textColor, var10.textShadowed?0:-1);
                                             }
                                          }

                                          ++var20;
                                       }
                                    }
                                 }

                                 if(var10.type == 8 && var10 == class47.field602 && Client.field1054 == Client.field1053) {
                                    var33 = 0;
                                    var20 = 0;
                                    Font var38 = class290.font_p12full;
                                    String var39 = var10.text;

                                    String var57;
                                    for(var39 = WorldMapType2.method527(var39, var10); var39.length() > 0; var20 = var20 + var38.verticalSpace + 1) {
                                       var24 = var39.indexOf("<br>");
                                       if(var24 != -1) {
                                          var57 = var39.substring(0, var24);
                                          var39 = var39.substring(var24 + 4);
                                       } else {
                                          var57 = var39;
                                          var39 = "";
                                       }

                                       var25 = var38.method4771(var57);
                                       if(var25 > var33) {
                                          var33 = var25;
                                       }
                                    }

                                    var33 += 6;
                                    var20 += 7;
                                    var24 = var12 + var10.width - 5 - var33;
                                    var25 = var13 + var10.height + 5;
                                    if(var24 < var12 + 5) {
                                       var24 = var12 + 5;
                                    }

                                    if(var33 + var24 > var4) {
                                       var24 = var4 - var33;
                                    }

                                    if(var20 + var25 > var5) {
                                       var25 = var5 - var20;
                                    }

                                    Rasterizer2D.method4973(var24, var25, var33, var20, 16777120);
                                    Rasterizer2D.drawRectangle(var24, var25, var33, var20, 0);
                                    var39 = var10.text;
                                    var26 = var25 + var38.verticalSpace + 2;

                                    for(var39 = WorldMapType2.method527(var39, var10); var39.length() > 0; var26 = var26 + var38.verticalSpace + 1) {
                                       var27 = var39.indexOf("<br>");
                                       if(var27 != -1) {
                                          var57 = var39.substring(0, var27);
                                          var39 = var39.substring(var27 + 4);
                                       } else {
                                          var57 = var39;
                                          var39 = "";
                                       }

                                       var38.method4776(var57, var24 + 3, var26, 0, -1);
                                    }
                                 }

                                 if(var10.type == 9) {
                                    if(var10.field2657) {
                                       var33 = var12;
                                       var20 = var13 + var10.height;
                                       var21 = var12 + var10.width;
                                       var22 = var13;
                                    } else {
                                       var33 = var12;
                                       var20 = var13;
                                       var21 = var12 + var10.width;
                                       var22 = var13 + var10.height;
                                    }

                                    if(var10.field2687 == 1) {
                                       Rasterizer2D.drawLine(var33, var20, var21, var22, var10.textColor);
                                    } else {
                                       PacketBuffer.method3427(var33, var20, var21, var22, var10.textColor, var10.field2687);
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

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Lit;I)V",
      garbageValue = "1225930112"
   )
   public static void method213(IndexDataBase var0) {
      VarPlayerType.varplayer_ref = var0;
      VarPlayerType.field3270 = VarPlayerType.varplayer_ref.fileCount(16);
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;Ljava/lang/String;I)V",
      garbageValue = "193006546"
   )
   @Export("sendGameMessage")
   static void sendGameMessage(int var0, String var1, String var2) {
      class17.addChatMessage(var0, var1, var2, (String)null);
   }

   @ObfuscatedName("gj")
   @ObfuscatedSignature(
      signature = "(IIIIII)V",
      garbageValue = "-2137930854"
   )
   static final void method202(int var0, int var1, int var2, int var3, int var4) {
      int var5 = class84.region.method2736(var0, var1, var2);
      int var6;
      int var7;
      int var8;
      int var9;
      int var11;
      int var12;
      if(var5 != 0) {
         var6 = class84.region.method2740(var0, var1, var2, var5);
         var7 = var6 >> 6 & 3;
         var8 = var6 & 31;
         var9 = var3;
         if(var5 > 0) {
            var9 = var4;
         }

         int[] var10 = class56.field667.image;
         var11 = (103 - var2) * 2048 + var1 * 4 + 24624;
         var12 = var5 >> 14 & 32767;
         ObjectComposition var13 = WorldMapType1.getObjectDefinition(var12);
         if(var13.mapSceneId != -1) {
            IndexedSprite var14 = class19.field321[var13.mapSceneId];
            if(var14 != null) {
               int var15 = (var13.sizeX * 4 - var14.originalWidth) / 2;
               int var16 = (var13.sizeY * 4 - var14.height) / 2;
               var14.method5068(var15 + var1 * 4 + 48, var16 + (104 - var2 - var13.sizeY) * 4 + 48);
            }
         } else {
            if(var8 == 0 || var8 == 2) {
               if(var7 == 0) {
                  var10[var11] = var9;
                  var10[var11 + 512] = var9;
                  var10[var11 + 1024] = var9;
                  var10[var11 + 1536] = var9;
               } else if(var7 == 1) {
                  var10[var11] = var9;
                  var10[var11 + 1] = var9;
                  var10[var11 + 2] = var9;
                  var10[var11 + 3] = var9;
               } else if(var7 == 2) {
                  var10[var11 + 3] = var9;
                  var10[var11 + 512 + 3] = var9;
                  var10[var11 + 1024 + 3] = var9;
                  var10[var11 + 1536 + 3] = var9;
               } else if(var7 == 3) {
                  var10[var11 + 1536] = var9;
                  var10[var11 + 1536 + 1] = var9;
                  var10[var11 + 1536 + 2] = var9;
                  var10[var11 + 1536 + 3] = var9;
               }
            }

            if(var8 == 3) {
               if(var7 == 0) {
                  var10[var11] = var9;
               } else if(var7 == 1) {
                  var10[var11 + 3] = var9;
               } else if(var7 == 2) {
                  var10[var11 + 1536 + 3] = var9;
               } else if(var7 == 3) {
                  var10[var11 + 1536] = var9;
               }
            }

            if(var8 == 2) {
               if(var7 == 3) {
                  var10[var11] = var9;
                  var10[var11 + 512] = var9;
                  var10[var11 + 1024] = var9;
                  var10[var11 + 1536] = var9;
               } else if(var7 == 0) {
                  var10[var11] = var9;
                  var10[var11 + 1] = var9;
                  var10[var11 + 2] = var9;
                  var10[var11 + 3] = var9;
               } else if(var7 == 1) {
                  var10[var11 + 3] = var9;
                  var10[var11 + 512 + 3] = var9;
                  var10[var11 + 1024 + 3] = var9;
                  var10[var11 + 1536 + 3] = var9;
               } else if(var7 == 2) {
                  var10[var11 + 1536] = var9;
                  var10[var11 + 1536 + 1] = var9;
                  var10[var11 + 1536 + 2] = var9;
                  var10[var11 + 1536 + 3] = var9;
               }
            }
         }
      }

      var5 = class84.region.method2738(var0, var1, var2);
      if(var5 != 0) {
         var6 = class84.region.method2740(var0, var1, var2, var5);
         var7 = var6 >> 6 & 3;
         var8 = var6 & 31;
         var9 = var5 >> 14 & 32767;
         ObjectComposition var23 = WorldMapType1.getObjectDefinition(var9);
         int var18;
         if(var23.mapSceneId != -1) {
            IndexedSprite var17 = class19.field321[var23.mapSceneId];
            if(var17 != null) {
               var12 = (var23.sizeX * 4 - var17.originalWidth) / 2;
               var18 = (var23.sizeY * 4 - var17.height) / 2;
               var17.method5068(var12 + var1 * 4 + 48, (104 - var2 - var23.sizeY) * 4 + var18 + 48);
            }
         } else if(var8 == 9) {
            var11 = 15658734;
            if(var5 > 0) {
               var11 = 15597568;
            }

            int[] var22 = class56.field667.image;
            var18 = (103 - var2) * 2048 + 24624 + var1 * 4;
            if(var7 != 0 && var7 != 2) {
               var22[var18] = var11;
               var22[var18 + 1 + 512] = var11;
               var22[var18 + 1024 + 2] = var11;
               var22[var18 + 1536 + 3] = var11;
            } else {
               var22[var18 + 1536] = var11;
               var22[var18 + 1 + 1024] = var11;
               var22[var18 + 512 + 2] = var11;
               var22[var18 + 3] = var11;
            }
         }
      }

      var5 = class84.region.method2739(var0, var1, var2);
      if(var5 != 0) {
         var6 = var5 >> 14 & 32767;
         ObjectComposition var19 = WorldMapType1.getObjectDefinition(var6);
         if(var19.mapSceneId != -1) {
            IndexedSprite var20 = class19.field321[var19.mapSceneId];
            if(var20 != null) {
               var9 = (var19.sizeX * 4 - var20.originalWidth) / 2;
               int var21 = (var19.sizeY * 4 - var20.height) / 2;
               var20.method5068(48 + var1 * 4 + var9, (104 - var2 - var19.sizeY) * 4 + var21 + 48);
            }
         }
      }

   }

   @ObfuscatedName("ag")
   @ObfuscatedSignature(
      signature = "(ILhq;ZB)V",
      garbageValue = "-60"
   )
   static void method214(int var0, Coordinates var1, boolean var2) {
      WorldMapData var3 = class23.method172().method5249(var0);
      int var4 = class54.localPlayer.field900;
      int var5 = (class54.localPlayer.x >> 7) + class25.baseX;
      int var6 = (class54.localPlayer.y >> 7) + ScriptEvent.baseY;
      Coordinates var7 = new Coordinates(var4, var5, var6);
      class23.method172().method5239(var3, var7, var1, var2);
   }
}
