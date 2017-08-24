import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cf")
@Implements("GraphicsObject")
public final class GraphicsObject extends Renderable {
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 1380452557
   )
   @Export("id")
   int id;
   @ObfuscatedName("s")
   @Export("finished")
   boolean finished;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 605798863
   )
   int field1366;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 144783259
   )
   int field1365;
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Ljw;"
   )
   Sequence field1364;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 1649565989
   )
   @Export("level")
   int level;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 1460410411
   )
   @Export("x")
   int x;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 384641417
   )
   @Export("y")
   int y;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -413794051
   )
   @Export("height")
   int height;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -1747636549
   )
   @Export("startCycle")
   int startCycle;

   GraphicsObject(int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      this.field1365 = 0;
      this.field1366 = 0;
      this.finished = false;
      this.id = var1;
      this.level = var2;
      this.x = var3;
      this.y = var4;
      this.height = var5;
      this.startCycle = var7 + var6;
      int var8 = class15.getSpotAnimType(this.id).field3332;
      if(var8 != -1) {
         this.finished = false;
         this.field1364 = class216.getAnimation(var8);
      } else {
         this.finished = true;
      }

   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(I)Lem;",
      garbageValue = "-1455933636"
   )
   protected final Model getModel() {
      Spotanim var1 = class15.getSpotAnimType(this.id);
      Model var2;
      if(!this.finished) {
         var2 = var1.method4339(this.field1365);
      } else {
         var2 = var1.method4339(-1);
      }

      return var2 == null?null:var2;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1828245755"
   )
   final void method1685(int var1) {
      if(!this.finished) {
         this.field1366 += var1;

         while(this.field1366 > this.field1364.frameLenghts[this.field1365]) {
            this.field1366 -= this.field1364.frameLenghts[this.field1365];
            ++this.field1365;
            if(this.field1365 >= this.field1364.frameIDs.length) {
               this.finished = true;
               break;
            }
         }

      }
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "([BB)V",
      garbageValue = "112"
   )
   @Export("decodeSprite")
   static void decodeSprite(byte[] var0) {
      Buffer var1 = new Buffer(var0);
      var1.offset = var0.length - 2;
      class171.field2347 = var1.readUnsignedShort();
      class271.field3679 = new int[class171.field2347];
      class18.offsetsY = new int[class171.field2347];
      class287.field3796 = new int[class171.field2347];
      class245.field3324 = new int[class171.field2347];
      class274.spritePixels = new byte[class171.field2347][];
      var1.offset = var0.length - 7 - class171.field2347 * 8;
      class287.field3797 = var1.readUnsignedShort();
      class287.field3798 = var1.readUnsignedShort();
      int var2 = (var1.readUnsignedByte() & 255) + 1;

      int var3;
      for(var3 = 0; var3 < class171.field2347; ++var3) {
         class271.field3679[var3] = var1.readUnsignedShort();
      }

      for(var3 = 0; var3 < class171.field2347; ++var3) {
         class18.offsetsY[var3] = var1.readUnsignedShort();
      }

      for(var3 = 0; var3 < class171.field2347; ++var3) {
         class287.field3796[var3] = var1.readUnsignedShort();
      }

      for(var3 = 0; var3 < class171.field2347; ++var3) {
         class245.field3324[var3] = var1.readUnsignedShort();
      }

      var1.offset = var0.length - 7 - class171.field2347 * 8 - (var2 - 1) * 3;
      Varbit.field3387 = new int[var2];

      for(var3 = 1; var3 < var2; ++var3) {
         Varbit.field3387[var3] = var1.read24BitInt();
         if(Varbit.field3387[var3] == 0) {
            Varbit.field3387[var3] = 1;
         }
      }

      var1.offset = 0;

      for(var3 = 0; var3 < class171.field2347; ++var3) {
         int var4 = class287.field3796[var3];
         int var5 = class245.field3324[var3];
         int var6 = var4 * var5;
         byte[] var7 = new byte[var6];
         class274.spritePixels[var3] = var7;
         int var8 = var1.readUnsignedByte();
         int var9;
         if(var8 == 0) {
            for(var9 = 0; var9 < var6; ++var9) {
               var7[var9] = var1.readByte();
            }
         } else if(var8 == 1) {
            for(var9 = 0; var9 < var4; ++var9) {
               for(int var10 = 0; var10 < var5; ++var10) {
                  var7[var9 + var4 * var10] = var1.readByte();
               }
            }
         }
      }

   }

   @ObfuscatedName("gm")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-364393183"
   )
   static void method1675() {
      Client.menuOptionCount = 0;
      Client.isMenuOpen = false;
      Client.menuOptions[0] = "Cancel";
      Client.menuTargets[0] = "";
      Client.menuTypes[0] = 1006;
      Client.field1077[0] = false;
      Client.menuOptionCount = 1;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "-45"
   )
   public static boolean method1683() {
      ClassInfo var0 = (ClassInfo)class281.field3757.method3642();
      return var0 != null;
   }

   @ObfuscatedName("hq")
   @ObfuscatedSignature(
      signature = "([Lhx;IIIIIIIII)V",
      garbageValue = "-315740922"
   )
   @Export("gameDraw")
   static final void gameDraw(Widget[] var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
      Rasterizer2D.setDrawRegion(var2, var3, var4, var5);
      Graphics3D.method2616();

      for(int var9 = 0; var9 < var0.length; ++var9) {
         Widget var10 = var0[var9];
         if(var10 != null && (var10.parentId == var1 || var1 == -1412584499 && var10 == Client.field1111)) {
            int var11;
            if(var8 == -1) {
               Client.widgetPositionX[Client.field1065] = var10.relativeX + var6;
               Client.widgetPositionY[Client.field1065] = var7 + var10.relativeY;
               Client.widgetBoundsWidth[Client.field1065] = var10.width;
               Client.widgetBoundsHeight[Client.field1065] = var10.height;
               var11 = ++Client.field1065 - 1;
            } else {
               var11 = var8;
            }

            var10.boundsIndex = var11;
            var10.loopCycle = Client.gameCycle;
            if(!var10.hasScript || !WorldMapType2.method548(var10)) {
               if(var10.contentType > 0) {
                  class291.method5341(var10);
               }

               int var12 = var10.relativeX + var6;
               int var13 = var7 + var10.relativeY;
               int var14 = var10.opacity;
               int var15;
               int var16;
               if(var10 == Client.field1111) {
                  if(var1 != -1412584499 && !var10.field2715) {
                     class39.field549 = var0;
                     class12.field280 = var6;
                     Preferences.field1322 = var7;
                     continue;
                  }

                  if(Client.field1115 && Client.field1209) {
                     var15 = MouseInput.field752;
                     var16 = MouseInput.field747;
                     var15 -= Client.field1106;
                     var16 -= Client.field1107;
                     if(var15 < Client.field1011) {
                        var15 = Client.field1011;
                     }

                     if(var15 + var10.width > Client.field1011 + Client.field1045.width) {
                        var15 = Client.field1011 + Client.field1045.width - var10.width;
                     }

                     if(var16 < Client.field1182) {
                        var16 = Client.field1182;
                     }

                     if(var16 + var10.height > Client.field1182 + Client.field1045.height) {
                        var16 = Client.field1182 + Client.field1045.height - var10.height;
                     }

                     var12 = var15;
                     var13 = var16;
                  }

                  if(!var10.field2715) {
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
                  int var27;
                  int var28;
                  int var31;
                  if(var10.contentType != 0) {
                     if(var10.contentType == 1336) {
                        if(Client.displayFps) {
                           var13 += 15;
                           WorldMapType2.font_p12full.method4722("Fps:" + GameEngine.FPS, var12 + var10.width, var13, 16776960, -1);
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

                           WorldMapType2.font_p12full.method4722("Mem:" + var20 + "k", var12 + var10.width, var13, var21, -1);
                           var13 += 15;
                        }
                        continue;
                     }

                     if(var10.contentType == 1337) {
                        Client.field1080 = var12;
                        Client.field1126 = var13;
                        Client.method1515(var12, var13, var10.width, var10.height);
                        Client.field1110[var10.boundsIndex] = true;
                        Rasterizer2D.setDrawRegion(var2, var3, var4, var5);
                        continue;
                     }

                     if(var10.contentType == 1338) {
                        WorldMapType3.method239();
                        class211 var57 = var10.method4031(false);
                        if(var57 != null) {
                           Rasterizer2D.setDrawRegion(var12, var13, var12 + var57.field2600, var13 + var57.field2599);
                           if(Client.field1079 != 2 && Client.field1079 != 5) {
                              var20 = Client.mapAngle & 2047;
                              var21 = Player.localPlayer.x / 32 + 48;
                              var22 = 464 - Player.localPlayer.y / 32;
                              GrandExchangeOffer.field315.method5031(var12, var13, var57.field2600, var57.field2599, var21, var22, var20, 256, var57.field2602, var57.field2601);

                              for(var23 = 0; var23 < Client.field1160; ++var23) {
                                 var24 = Client.field1161[var23] * 4 + 2 - Player.localPlayer.x / 32;
                                 var25 = Client.field1162[var23] * 4 + 2 - Player.localPlayer.y / 32;
                                 IndexData.drawDot(var12, var13, var24, var25, Client.field1163[var23], var57);
                              }

                              var23 = 0;

                              while(true) {
                                 if(var23 >= 104) {
                                    for(var23 = 0; var23 < Client.field946; ++var23) {
                                       NPC var69 = Client.cachedNPCs[Client.npcIndices[var23]];
                                       if(var69 != null && var69.hasConfig()) {
                                          NPCComposition var64 = var69.composition;
                                          if(var64 != null && var64.configs != null) {
                                             var64 = var64.transform();
                                          }

                                          if(var64 != null && var64.isMinimapVisible && var64.field3579) {
                                             var26 = var69.x / 32 - Player.localPlayer.x / 32;
                                             var27 = var69.y / 32 - Player.localPlayer.y / 32;
                                             IndexData.drawDot(var12, var13, var26, var27, class156.mapDots[1], var57);
                                          }
                                       }
                                    }

                                    var23 = class95.field1507;
                                    int[] var70 = class95.field1511;

                                    for(var25 = 0; var25 < var23; ++var25) {
                                       Player var49 = Client.cachedPlayers[var70[var25]];
                                       if(var49 != null && var49.hasConfig() && !var49.hidden && var49 != Player.localPlayer) {
                                          var27 = var49.x / 32 - Player.localPlayer.x / 32;
                                          var28 = var49.y / 32 - Player.localPlayer.y / 32;
                                          boolean var62 = false;
                                          if(Actor.isFriended(var49.name, true)) {
                                             var62 = true;
                                          }

                                          boolean var61 = false;

                                          for(var31 = 0; var31 < class13.clanChatCount; ++var31) {
                                             if(var49.name.equals(class223.clanMembers[var31].username)) {
                                                var61 = true;
                                                break;
                                             }
                                          }

                                          boolean var63 = false;
                                          if(Player.localPlayer.team != 0 && var49.team != 0 && var49.team == Player.localPlayer.team) {
                                             var63 = true;
                                          }

                                          if(var62) {
                                             IndexData.drawDot(var12, var13, var27, var28, class156.mapDots[3], var57);
                                          } else if(var63) {
                                             IndexData.drawDot(var12, var13, var27, var28, class156.mapDots[4], var57);
                                          } else if(var61) {
                                             IndexData.drawDot(var12, var13, var27, var28, class156.mapDots[5], var57);
                                          } else {
                                             IndexData.drawDot(var12, var13, var27, var28, class156.mapDots[2], var57);
                                          }
                                       }
                                    }

                                    if(Client.field958 != 0 && Client.gameCycle % 20 < 10) {
                                       if(Client.field958 == 1 && Client.field959 >= 0 && Client.field959 < Client.cachedNPCs.length) {
                                          NPC var65 = Client.cachedNPCs[Client.field959];
                                          if(var65 != null) {
                                             var26 = var65.x / 32 - Player.localPlayer.x / 32;
                                             var27 = var65.y / 32 - Player.localPlayer.y / 32;
                                             class12.method68(var12, var13, var26, var27, class66.field832[1], var57);
                                          }
                                       }

                                       if(Client.field958 == 2) {
                                          var25 = 2 + (Client.hintArrowX * 4 - class149.baseX * 4) - Player.localPlayer.x / 32;
                                          var26 = Client.hintArrowY * 4 - class67.baseY * 4 + 2 - Player.localPlayer.y / 32;
                                          class12.method68(var12, var13, var25, var26, class66.field832[1], var57);
                                       }

                                       if(Client.field958 == 10 && Client.field960 >= 0 && Client.field960 < Client.cachedPlayers.length) {
                                          Player var66 = Client.cachedPlayers[Client.field960];
                                          if(var66 != null) {
                                             var26 = var66.x / 32 - Player.localPlayer.x / 32;
                                             var27 = var66.y / 32 - Player.localPlayer.y / 32;
                                             class12.method68(var12, var13, var26, var27, class66.field832[1], var57);
                                          }
                                       }
                                    }

                                    if(Client.destinationX != 0) {
                                       var25 = Client.destinationX * 4 + 2 - Player.localPlayer.x / 32;
                                       var26 = Client.destinationY * 4 + 2 - Player.localPlayer.y / 32;
                                       IndexData.drawDot(var12, var13, var25, var26, class66.field832[0], var57);
                                    }

                                    if(!Player.localPlayer.hidden) {
                                       Rasterizer2D.method4890(var57.field2600 / 2 + var12 - 1, var57.field2599 / 2 + var13 - 1, 3, 3, 16777215);
                                    }
                                    break;
                                 }

                                 for(var24 = 0; var24 < 104; ++var24) {
                                    Deque var47 = Client.groundItemDeque[class27.plane][var23][var24];
                                    if(var47 != null) {
                                       var26 = var23 * 4 + 2 - Player.localPlayer.x / 32;
                                       var27 = 2 + var24 * 4 - Player.localPlayer.y / 32;
                                       IndexData.drawDot(var12, var13, var26, var27, class156.mapDots[0], var57);
                                    }
                                 }

                                 ++var23;
                              }
                           } else {
                              Rasterizer2D.method4957(var12, var13, 0, var57.field2602, var57.field2601);
                           }

                           Client.field966[var11] = true;
                        }

                        Rasterizer2D.setDrawRegion(var2, var3, var4, var5);
                        continue;
                     }

                     if(var10.contentType == 1339) {
                        InvType.method4280(var10, var12, var13, var11);
                        Rasterizer2D.setDrawRegion(var2, var3, var4, var5);
                        continue;
                     }

                     if(var10.contentType == 1400) {
                        KeyFocusListener.renderOverview.extractWorldmap(var12, var13, var10.width, var10.height, Client.gameCycle);
                     }

                     if(var10.contentType == 1401) {
                        KeyFocusListener.renderOverview.extractData(var12, var13, var10.width, var10.height);
                     }
                  }

                  if(var10.type == 0) {
                     if(!var10.hasScript && WorldMapType2.method548(var10) && var10 != class56.field696) {
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
                        class5.method8(var19.id, var15, var16, var17, var18, var12, var13, var11);
                     }

                     Rasterizer2D.setDrawRegion(var2, var3, var4, var5);
                     Graphics3D.method2616();
                  }

                  if(Client.isResized || Client.field1138[var11] || Client.gameDrawingMode > 1) {
                     if(var10.type == 0 && !var10.hasScript && var10.scrollHeight > var10.height) {
                        var46 = var12 + var10.width;
                        var20 = var10.scrollY;
                        var21 = var10.height;
                        var22 = var10.scrollHeight;
                        class158.field2262[0].method4983(var46, var13);
                        class158.field2262[1].method4983(var46, var13 + var21 - 16);
                        Rasterizer2D.method4890(var46, var13 + 16, 16, var21 - 32, Client.field1008);
                        var23 = var21 * (var21 - 32) / var22;
                        if(var23 < 8) {
                           var23 = 8;
                        }

                        var24 = var20 * (var21 - 32 - var23) / (var22 - var21);
                        Rasterizer2D.method4890(var46, var24 + var13 + 16, 16, var23, Client.field1073);
                        Rasterizer2D.method4904(var46, var13 + var24 + 16, var23, Client.field1006);
                        Rasterizer2D.method4904(var46 + 1, var13 + var24 + 16, var23, Client.field1006);
                        Rasterizer2D.method4884(var46, var13 + var24 + 16, 16, Client.field1006);
                        Rasterizer2D.method4884(var46, var24 + var13 + 17, 16, Client.field1006);
                        Rasterizer2D.method4904(var46 + 15, var13 + var24 + 16, var23, Client.field1010);
                        Rasterizer2D.method4904(var46 + 14, var13 + var24 + 17, var23 - 1, Client.field1010);
                        Rasterizer2D.method4884(var46, var23 + var13 + var24 + 15, 16, Client.field1010);
                        Rasterizer2D.method4884(var46 + 1, var23 + var24 + var13 + 14, 15, Client.field1010);
                     }

                     if(var10.type != 1) {
                        int var29;
                        if(var10.type == 2) {
                           var46 = 0;

                           for(var20 = 0; var20 < var10.field2670; ++var20) {
                              for(var21 = 0; var21 < var10.originalWidth; ++var21) {
                                 var22 = var12 + var21 * (var10.paddingX + 32);
                                 var23 = var20 * (var10.paddingY + 32) + var13;
                                 if(var46 < 20) {
                                    var22 += var10.xSprites[var46];
                                    var23 += var10.field2728[var46];
                                 }

                                 if(var10.itemIds[var46] <= 0) {
                                    if(var10.field2686 != null && var46 < 20) {
                                       SpritePixels var67 = var10.method4037(var46);
                                       if(var67 != null) {
                                          var67.method5019(var22, var23);
                                       } else if(Widget.field2683) {
                                          class7.method34(var10);
                                       }
                                    }
                                 } else {
                                    boolean var59 = false;
                                    boolean var60 = false;
                                    var26 = var10.itemIds[var46] - 1;
                                    if(var22 + 32 > var2 && var22 < var4 && var23 + 32 > var3 && var23 < var5 || var10 == class18.field325 && var46 == Client.field1044) {
                                       SpritePixels var52;
                                       if(Client.itemSelectionState == 1 && var46 == class56.selectedItemIndex && var10.id == class48.field626) {
                                          var52 = class31.createSprite(var26, var10.itemQuantities[var46], 2, 0, 2, false);
                                       } else {
                                          var52 = class31.createSprite(var26, var10.itemQuantities[var46], 1, 3153952, 2, false);
                                       }

                                       if(var52 != null) {
                                          if(var10 == class18.field325 && var46 == Client.field1044) {
                                             var24 = MouseInput.field752 - Client.field1069;
                                             var25 = MouseInput.field747 - Client.field1046;
                                             if(var24 < 5 && var24 > -5) {
                                                var24 = 0;
                                             }

                                             if(var25 < 5 && var25 > -5) {
                                                var25 = 0;
                                             }

                                             if(Client.field1081 < 5) {
                                                var24 = 0;
                                                var25 = 0;
                                             }

                                             var52.method5015(var24 + var22, var23 + var25, 128);
                                             if(var1 != -1) {
                                                Widget var53 = var0[var1 & '\uffff'];
                                                if(var23 + var25 < Rasterizer2D.drawingAreaTop && var53.scrollY > 0) {
                                                   var29 = (Rasterizer2D.drawingAreaTop - var23 - var25) * Client.field1007 / 3;
                                                   if(var29 > Client.field1007 * 10) {
                                                      var29 = Client.field1007 * 10;
                                                   }

                                                   if(var29 > var53.scrollY) {
                                                      var29 = var53.scrollY;
                                                   }

                                                   var53.scrollY -= var29;
                                                   Client.field1046 += var29;
                                                   class7.method34(var53);
                                                }

                                                if(var25 + var23 + 32 > Rasterizer2D.drawingAreaRight && var53.scrollY < var53.scrollHeight - var53.height) {
                                                   var29 = Client.field1007 * (var25 + var23 + 32 - Rasterizer2D.drawingAreaRight) / 3;
                                                   if(var29 > Client.field1007 * 10) {
                                                      var29 = Client.field1007 * 10;
                                                   }

                                                   if(var29 > var53.scrollHeight - var53.height - var53.scrollY) {
                                                      var29 = var53.scrollHeight - var53.height - var53.scrollY;
                                                   }

                                                   var53.scrollY += var29;
                                                   Client.field1046 -= var29;
                                                   class7.method34(var53);
                                                }
                                             }
                                          } else if(var10 == class262.field3618 && var46 == Client.field1043) {
                                             var52.method5015(var22, var23, 128);
                                          } else {
                                             var52.method5019(var22, var23);
                                          }
                                       } else {
                                          class7.method34(var10);
                                       }
                                    }
                                 }

                                 ++var46;
                              }
                           }
                        } else if(var10.type == 3) {
                           if(class37.method528(var10)) {
                              var46 = var10.field2684;
                              if(var10 == class56.field696 && var10.field2656 != 0) {
                                 var46 = var10.field2656;
                              }
                           } else {
                              var46 = var10.textColor;
                              if(var10 == class56.field696 && var10.field2646 != 0) {
                                 var46 = var10.field2646;
                              }
                           }

                           if(var10.field2687) {
                              switch(var10.field2688.field3774) {
                              case 1:
                                 Rasterizer2D.method4891(var12, var13, var10.width, var10.height, var10.textColor, var10.field2684, 256 - (var10.opacity & 255), 256 - (var10.field2690 & 255));
                                 break;
                              case 2:
                                 Rasterizer2D.method4910(var12, var13, var10.width, var10.height, var10.textColor, var10.field2684, 256 - (var10.opacity & 255), 256 - (var10.field2690 & 255));
                                 break;
                              case 3:
                                 Rasterizer2D.method4893(var12, var13, var10.width, var10.height, var10.textColor, var10.field2684, 256 - (var10.opacity & 255), 256 - (var10.field2690 & 255));
                                 break;
                              case 4:
                                 Rasterizer2D.method4894(var12, var13, var10.width, var10.height, var10.textColor, var10.field2684, 256 - (var10.opacity & 255), 256 - (var10.field2690 & 255));
                                 break;
                              default:
                                 if(var14 == 0) {
                                    Rasterizer2D.method4890(var12, var13, var10.width, var10.height, var46);
                                 } else {
                                    Rasterizer2D.fillRectangle(var12, var13, var10.width, var10.height, var46, 256 - (var14 & 255));
                                 }
                              }
                           } else if(var14 == 0) {
                              Rasterizer2D.drawRectangle(var12, var13, var10.width, var10.height, var46);
                           } else {
                              Rasterizer2D.method4898(var12, var13, var10.width, var10.height, var46, 256 - (var14 & 255));
                           }
                        } else {
                           Font var55;
                           if(var10.type == 4) {
                              var55 = var10.method4042();
                              if(var55 == null) {
                                 if(Widget.field2683) {
                                    class7.method34(var10);
                                 }
                              } else {
                                 String var72 = var10.text;
                                 if(class37.method528(var10)) {
                                    var20 = var10.field2684;
                                    if(var10 == class56.field696 && var10.field2656 != 0) {
                                       var20 = var10.field2656;
                                    }

                                    if(var10.field2719.length() > 0) {
                                       var72 = var10.field2719;
                                    }
                                 } else {
                                    var20 = var10.textColor;
                                    if(var10 == class56.field696 && var10.field2646 != 0) {
                                       var20 = var10.field2646;
                                    }
                                 }

                                 if(var10.hasScript && var10.itemId != -1) {
                                    ItemComposition var73 = class169.getItemDefinition(var10.itemId);
                                    var72 = var73.name;
                                    if(var72 == null) {
                                       var72 = "null";
                                    }

                                    if((var73.isStackable == 1 || var10.itemQuantity != 1) && var10.itemQuantity != -1) {
                                       var72 = Friend.getColTags(16748608) + var72 + "</col>" + " " + 'x' + Friend.method1117(var10.itemQuantity);
                                    }
                                 }

                                 if(var10 == Client.field1086) {
                                    Object var10000 = null;
                                    var72 = "Please wait...";
                                    var20 = var10.textColor;
                                 }

                                 if(!var10.hasScript) {
                                    var72 = class156.method3036(var72, var10);
                                 }

                                 var55.method4789(var72, var12, var13, var10.width, var10.height, var20, var10.textShadowed?0:-1, var10.field2721, var10.field2722, var10.field2731);
                              }
                           } else if(var10.type == 5) {
                              SpritePixels var56;
                              if(!var10.hasScript) {
                                 var56 = var10.method4035(class37.method528(var10));
                                 if(var56 != null) {
                                    var56.method5019(var12, var13);
                                 } else if(Widget.field2683) {
                                    class7.method34(var10);
                                 }
                              } else {
                                 if(var10.itemId != -1) {
                                    var56 = class31.createSprite(var10.itemId, var10.itemQuantity, var10.borderThickness, var10.sprite2, var10.field2716, false);
                                 } else {
                                    var56 = var10.method4035(false);
                                 }

                                 if(var56 == null) {
                                    if(Widget.field2683) {
                                       class7.method34(var10);
                                    }
                                 } else {
                                    var20 = var56.maxWidth;
                                    var21 = var56.maxHeight;
                                    if(!var10.field2696) {
                                       var22 = var10.width * 4096 / var20;
                                       if(var10.textureId != 0) {
                                          var56.method5032(var10.width / 2 + var12, var10.height / 2 + var13, var10.textureId, var22);
                                       } else if(var14 != 0) {
                                          var56.method5016(var12, var13, var10.width, var10.height, 256 - (var14 & 255));
                                       } else if(var20 == var10.width && var21 == var10.height) {
                                          var56.method5019(var12, var13);
                                       } else {
                                          var56.method5021(var12, var13, var10.width, var10.height);
                                       }
                                    } else {
                                       Rasterizer2D.setInnerDrawRegion(var12, var13, var12 + var10.width, var13 + var10.height);
                                       var22 = (var20 - 1 + var10.width) / var20;
                                       var23 = (var21 - 1 + var10.height) / var21;

                                       for(var24 = 0; var24 < var22; ++var24) {
                                          for(var25 = 0; var25 < var23; ++var25) {
                                             if(var10.textureId != 0) {
                                                var56.method5032(var20 / 2 + var12 + var20 * var24, var21 / 2 + var13 + var21 * var25, var10.textureId, 4096);
                                             } else if(var14 != 0) {
                                                var56.method5015(var12 + var24 * var20, var25 * var21 + var13, 256 - (var14 & 255));
                                             } else {
                                                var56.method5019(var12 + var24 * var20, var13 + var25 * var21);
                                             }
                                          }
                                       }

                                       Rasterizer2D.setDrawRegion(var2, var3, var4, var5);
                                    }
                                 }
                              }
                           } else {
                              ItemComposition var54;
                              if(var10.type == 6) {
                                 boolean var68 = class37.method528(var10);
                                 if(var68) {
                                    var20 = var10.field2706;
                                 } else {
                                    var20 = var10.field2783;
                                 }

                                 Model var71 = null;
                                 var22 = 0;
                                 if(var10.itemId != -1) {
                                    var54 = class169.getItemDefinition(var10.itemId);
                                    if(var54 != null) {
                                       var54 = var54.method4556(var10.itemQuantity);
                                       var71 = var54.getModel(1);
                                       if(var71 != null) {
                                          var71.method2515();
                                          var22 = var71.modelHeight / 2;
                                       } else {
                                          class7.method34(var10);
                                       }
                                    }
                                 } else if(var10.modelType == 5) {
                                    if(var10.modelId == 0) {
                                       var71 = Client.field1078.method4011((Sequence)null, -1, (Sequence)null, -1);
                                    } else {
                                       var71 = Player.localPlayer.getModel();
                                    }
                                 } else if(var20 == -1) {
                                    var71 = var10.method4038((Sequence)null, -1, var68, Player.localPlayer.composition);
                                    if(var71 == null && Widget.field2683) {
                                       class7.method34(var10);
                                    }
                                 } else {
                                    Sequence var75 = class216.getAnimation(var20);
                                    var71 = var10.method4038(var75, var10.field2780, var68, Player.localPlayer.composition);
                                    if(var71 == null && Widget.field2683) {
                                       class7.method34(var10);
                                    }
                                 }

                                 Graphics3D.method2619(var10.width / 2 + var12, var10.height / 2 + var13);
                                 var23 = Graphics3D.SINE[var10.rotationX] * var10.modelZoom >> 16;
                                 var24 = Graphics3D.COSINE[var10.rotationX] * var10.modelZoom >> 16;
                                 if(var71 != null) {
                                    if(!var10.hasScript) {
                                       var71.method2528(0, var10.rotationZ, 0, var10.rotationX, 0, var23, var24);
                                    } else {
                                       var71.method2515();
                                       if(var10.field2694) {
                                          var71.method2589(0, var10.rotationZ, var10.rotationY, var10.rotationX, var10.field2707, var23 + var22 + var10.field2647, var24 + var10.field2647, var10.modelZoom);
                                       } else {
                                          var71.method2528(0, var10.rotationZ, var10.rotationY, var10.rotationX, var10.field2707, var22 + var23 + var10.field2647, var24 + var10.field2647);
                                       }
                                    }
                                 }

                                 Graphics3D.method2638();
                              } else {
                                 if(var10.type == 7) {
                                    var55 = var10.method4042();
                                    if(var55 == null) {
                                       if(Widget.field2683) {
                                          class7.method34(var10);
                                       }
                                       continue;
                                    }

                                    var20 = 0;

                                    for(var21 = 0; var21 < var10.field2670; ++var21) {
                                       for(var22 = 0; var22 < var10.originalWidth; ++var22) {
                                          if(var10.itemIds[var20] > 0) {
                                             var54 = class169.getItemDefinition(var10.itemIds[var20] - 1);
                                             String var48;
                                             if(var54.isStackable != 1 && var10.itemQuantities[var20] == 1) {
                                                var48 = Friend.getColTags(16748608) + var54.name + "</col>";
                                             } else {
                                                var48 = Friend.getColTags(16748608) + var54.name + "</col>" + " " + 'x' + Friend.method1117(var10.itemQuantities[var20]);
                                             }

                                             var25 = var22 * (var10.paddingX + 115) + var12;
                                             var26 = var21 * (var10.paddingY + 12) + var13;
                                             if(var10.field2721 == 0) {
                                                var55.method4773(var48, var25, var26, var10.textColor, var10.textShadowed?0:-1);
                                             } else if(var10.field2721 == 1) {
                                                var55.method4755(var48, var10.width / 2 + var25, var26, var10.textColor, var10.textShadowed?0:-1);
                                             } else {
                                                var55.method4722(var48, var25 + var10.width - 1, var26, var10.textColor, var10.textShadowed?0:-1);
                                             }
                                          }

                                          ++var20;
                                       }
                                    }
                                 }

                                 if(var10.type == 8 && var10 == class48.field629 && Client.field1083 == Client.field973) {
                                    var46 = 0;
                                    var20 = 0;
                                    Font var50 = WorldMapType2.font_p12full;
                                    String var51 = var10.text;

                                    String var74;
                                    for(var51 = class156.method3036(var51, var10); var51.length() > 0; var20 = var20 + var50.verticalSpace + 1) {
                                       var24 = var51.indexOf("<br>");
                                       if(var24 != -1) {
                                          var74 = var51.substring(0, var24);
                                          var51 = var51.substring(var24 + 4);
                                       } else {
                                          var74 = var51;
                                          var51 = "";
                                       }

                                       var25 = var50.method4775(var74);
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

                                    Rasterizer2D.method4890(var24, var25, var46, var20, 16777120);
                                    Rasterizer2D.drawRectangle(var24, var25, var46, var20, 0);
                                    var51 = var10.text;
                                    var26 = var25 + var50.verticalSpace + 2;

                                    for(var51 = class156.method3036(var51, var10); var51.length() > 0; var26 = var26 + var50.verticalSpace + 1) {
                                       var27 = var51.indexOf("<br>");
                                       if(var27 != -1) {
                                          var74 = var51.substring(0, var27);
                                          var51 = var51.substring(var27 + 4);
                                       } else {
                                          var74 = var51;
                                          var51 = "";
                                       }

                                       var50.method4773(var74, var24 + 3, var26, 0, -1);
                                    }
                                 }

                                 if(var10.type == 9) {
                                    if(var10.field2692) {
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

                                    if(var10.field2691 == 1) {
                                       Rasterizer2D.drawLine(var46, var20, var21, var22, var10.textColor);
                                    } else {
                                       var25 = var10.textColor;
                                       var26 = var10.field2691;
                                       var27 = var21 - var46;
                                       var28 = var22 - var20;
                                       var29 = var27 >= 0?var27:-var27;
                                       int var30 = var28 >= 0?var28:-var28;
                                       var31 = var29;
                                       if(var29 < var30) {
                                          var31 = var30;
                                       }

                                       if(var31 != 0) {
                                          int var32 = (var27 << 16) / var31;
                                          int var33 = (var28 << 16) / var31;
                                          if(var33 <= var32) {
                                             var32 = -var32;
                                          } else {
                                             var33 = -var33;
                                          }

                                          int var34 = var26 * var33 >> 17;
                                          int var35 = var33 * var26 + 1 >> 17;
                                          int var36 = var26 * var32 >> 17;
                                          int var37 = var26 * var32 + 1 >> 17;
                                          var23 = var46 - Rasterizer2D.draw_region_x;
                                          var24 = var20 - Rasterizer2D.drawingAreaTop;
                                          int var38 = var34 + var23;
                                          int var39 = var23 - var35;
                                          int var40 = var23 + var27 - var35;
                                          int var41 = var27 + var23 + var34;
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

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;II)Z",
      garbageValue = "-1311846446"
   )
   static boolean method1682(String var0, int var1) {
      return class149.method2969(var0, var1, "openjs");
   }
}
