import java.io.IOException;
import java.net.Socket;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("g")
@Implements("WorldMapType3")
public class WorldMapType3 implements WorldMapSectionBase {
   @ObfuscatedName("gu")
   @ObfuscatedGetter(
      intValue = 1313573881
   )
   @Export("cameraX")
   static int cameraX;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 1132759595
   )
   int field112;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 1416784301
   )
   int field111;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 308760233
   )
   int field108;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -1016991907
   )
   int field107;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 839121669
   )
   int field109;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -1944673831
   )
   int field106;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 1530611787
   )
   int field120;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 1695570431
   )
   int field113;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 1267510081
   )
   int field114;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 167534849
   )
   int field115;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -1314401979
   )
   int field116;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 1229192741
   )
   int field117;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -402631621
   )
   int field110;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 2030373513
   )
   int field119;

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Li;I)V",
      garbageValue = "-1657983190"
   )
   public void vmethod692(WorldMapData var1) {
      if(var1.minX > this.field109) {
         var1.minX = this.field109;
      }

      if(var1.field177 < this.field109) {
         var1.field177 = this.field109;
      }

      if(var1.minY > this.field106) {
         var1.minY = this.field106;
      }

      if(var1.field179 < this.field106) {
         var1.field179 = this.field106;
      }

   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(IIII)Z",
      garbageValue = "1329615536"
   )
   public boolean containsCoord(int var1, int var2, int var3) {
      return var1 >= this.field112 && var1 < this.field112 + this.field111?var2 >= (this.field108 << 6) + (this.field120 << 3) && var2 <= (this.field108 << 6) + (this.field114 << 3) + 7 && var3 >= (this.field107 << 6) + (this.field113 << 3) && var3 <= (this.field107 << 6) + (this.field115 << 3) + 7:false;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(III)Z",
      garbageValue = "-1150064833"
   )
   public boolean vmethod694(int var1, int var2) {
      return var1 >= (this.field109 << 6) + (this.field116 << 3) && var1 <= (this.field109 << 6) + (this.field110 << 3) + 7 && var2 >= (this.field106 << 6) + (this.field117 << 3) && var2 <= (this.field106 << 6) + (this.field119 << 3) + 7;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(IIII)[I",
      garbageValue = "-1657440355"
   )
   public int[] vmethod712(int var1, int var2, int var3) {
      if(!this.containsCoord(var1, var2, var3)) {
         return null;
      } else {
         int[] var4 = new int[]{this.field109 * 64 - this.field108 * 64 + var2 + (this.field116 * 8 - this.field120 * 8), var3 + (this.field106 * 64 - this.field107 * 64) + (this.field117 * 8 - this.field113 * 8)};
         return var4;
      }
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(III)Lhh;",
      garbageValue = "2126255726"
   )
   public Coordinates vmethod707(int var1, int var2) {
      if(!this.vmethod694(var1, var2)) {
         return null;
      } else {
         int var3 = this.field108 * 64 - this.field109 * 64 + (this.field120 * 8 - this.field116 * 8) + var1;
         int var4 = this.field107 * 64 - this.field106 * 64 + var2 + (this.field113 * 8 - this.field117 * 8);
         return new Coordinates(this.field112, var3, var4);
      }
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Lgy;S)V",
      garbageValue = "255"
   )
   public void vmethod697(Buffer var1) {
      this.field112 = var1.readUnsignedByte();
      this.field111 = var1.readUnsignedByte();
      this.field108 = var1.readUnsignedShort();
      this.field120 = var1.readUnsignedByte();
      this.field114 = var1.readUnsignedByte();
      this.field107 = var1.readUnsignedShort();
      this.field113 = var1.readUnsignedByte();
      this.field115 = var1.readUnsignedByte();
      this.field109 = var1.readUnsignedShort();
      this.field116 = var1.readUnsignedByte();
      this.field110 = var1.readUnsignedByte();
      this.field106 = var1.readUnsignedShort();
      this.field117 = var1.readUnsignedByte();
      this.field119 = var1.readUnsignedByte();
      this.method133();
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-98"
   )
   void method133() {
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Ljava/net/Socket;III)Lft;",
      garbageValue = "1392861920"
   )
   public static class157 method154(Socket var0, int var1, int var2) throws IOException {
      return new class159(var0, var1, var2);
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "-1825420386"
   )
   @Export("sendConInfo")
   public static void sendConInfo(boolean var0) {
      if(class250.NetCache_socket != null) {
         try {
            Buffer var1 = new Buffer(4);
            var1.putByte(var0?2:3);
            var1.put24bitInt(0);
            class250.NetCache_socket.vmethod3385(var1.payload, 0, 4);
         } catch (IOException var4) {
            try {
               class250.NetCache_socket.vmethod3368();
            } catch (Exception var3) {
               ;
            }

            ++class250.field3227;
            class250.NetCache_socket = null;
         }

      }
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "([Ljava/lang/String;[SIII)V",
      garbageValue = "-25845431"
   )
   static void method155(String[] var0, short[] var1, int var2, int var3) {
      if(var2 < var3) {
         int var4 = (var3 + var2) / 2;
         int var5 = var2;
         String var6 = var0[var4];
         var0[var4] = var0[var3];
         var0[var3] = var6;
         short var7 = var1[var4];
         var1[var4] = var1[var3];
         var1[var3] = var7;

         for(int var8 = var2; var8 < var3; ++var8) {
            if(var6 == null || var0[var8] != null && var0[var8].compareTo(var6) < (var8 & 1)) {
               String var9 = var0[var8];
               var0[var8] = var0[var5];
               var0[var5] = var9;
               short var10 = var1[var8];
               var1[var8] = var1[var5];
               var1[var5++] = var10;
            }
         }

         var0[var3] = var0[var5];
         var0[var5] = var6;
         var1[var3] = var1[var5];
         var1[var5] = var7;
         method155(var0, var1, var2, var5 - 1);
         method155(var0, var1, var5 + 1, var3);
      }

   }

   @ObfuscatedName("il")
   @ObfuscatedSignature(
      signature = "([Lhl;IIIIIIIII)V",
      garbageValue = "1015784875"
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

            int var55;
            if(var10.contentType > 0) {
               var55 = var10.contentType;
               if(var55 == 324) {
                  if(Client.field783 == -1) {
                     Client.field783 = var10.spriteId;
                     Client.field854 = var10.field2616;
                  }

                  if(Client.field853.isFemale) {
                     var10.spriteId = Client.field783;
                  } else {
                     var10.spriteId = Client.field854;
                  }
               } else if(var55 == 325) {
                  if(Client.field783 == -1) {
                     Client.field783 = var10.spriteId;
                     Client.field854 = var10.field2616;
                  }

                  if(Client.field853.isFemale) {
                     var10.spriteId = Client.field854;
                  } else {
                     var10.spriteId = Client.field783;
                  }
               } else if(var55 == 327) {
                  var10.rotationX = 150;
                  var10.rotationZ = (int)(Math.sin((double)Client.gameCycle / 40.0D) * 256.0D) & 2047;
                  var10.modelType = 5;
                  var10.modelId = 0;
               } else if(var55 == 328) {
                  var10.rotationX = 150;
                  var10.rotationZ = (int)(Math.sin((double)Client.gameCycle / 40.0D) * 256.0D) & 2047;
                  var10.modelType = 5;
                  var10.modelId = 1;
               }
            }

            var55 = var10.relativeX + var6;
            int var13 = var7 + var10.relativeY;
            int var14 = var10.opacity;
            int var15;
            int var16;
            if(var10 == Client.draggedWidget) {
               if(var1 != -1412584499 && !var10.dragRenderBehavior) {
                  class25.field226 = var0;
                  class184.field2378 = var6;
                  WorldMapManager.field268 = var7;
                  continue;
               }

               if(Client.draggingWidget && Client.field594) {
                  var15 = MouseInput.mouseLastX;
                  var16 = MouseInput.mouseLastY;
                  var15 -= Client.field685;
                  var16 -= Client.field766;
                  if(var15 < Client.field769) {
                     var15 = Client.field769;
                  }

                  if(var15 + var10.width > Client.field769 + Client.field639.width) {
                     var15 = Client.field769 + Client.field639.width - var10.width;
                  }

                  if(var16 < Client.field770) {
                     var16 = Client.field770;
                  }

                  if(var16 + var10.height > Client.field770 + Client.field639.height) {
                     var16 = Client.field770 + Client.field639.height - var10.height;
                  }

                  var55 = var15;
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
            int var46;
            if(var10.type == 2) {
               var15 = var2;
               var16 = var3;
               var17 = var4;
               var18 = var5;
            } else if(var10.type == 9) {
               var46 = var55;
               var20 = var13;
               var21 = var55 + var10.width;
               var22 = var13 + var10.height;
               if(var21 < var55) {
                  var46 = var21;
                  var21 = var55;
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
               var46 = var55 + var10.width;
               var20 = var13 + var10.height;
               var15 = var55 > var2?var55:var2;
               var16 = var13 > var3?var13:var3;
               var17 = var46 < var4?var46:var4;
               var18 = var20 < var5?var20:var5;
            }

            if(!var10.hasScript || var15 < var17 && var16 < var18) {
               int var23;
               int var24;
               int var25;
               int var26;
               int var49;
               int var53;
               if(var10.contentType != 0) {
                  if(var10.contentType == 1336) {
                     if(Client.displayFps) {
                        var13 += 15;
                        ScriptEvent.font_p12full.method5543("Fps:" + GameEngine.FPS, var55 + var10.width, var13, 16776960, -1);
                        var13 += 15;
                        Runtime var59 = Runtime.getRuntime();
                        var20 = (int)((var59.totalMemory() - var59.freeMemory()) / 1024L);
                        var21 = 16776960;
                        if(var20 > 327680 && !Client.lowMemory) {
                           var21 = 16711680;
                        }

                        ScriptEvent.font_p12full.method5543("Mem:" + var20 + "k", var55 + var10.width, var13, var21, -1);
                        var13 += 15;
                     }
                     continue;
                  }

                  if(var10.contentType == 1337) {
                     Client.field741 = var55;
                     Client.field667 = var13;
                     class35.method682(var55, var13, var10.width, var10.height);
                     Client.field795[var10.boundsIndex] = true;
                     Rasterizer2D.setDrawRegion(var2, var3, var4, var5);
                     continue;
                  }

                  if(var10.contentType == 1338) {
                     Varbit.method4951();
                     class224 var58 = var10.method4561(false);
                     if(var58 != null) {
                        Rasterizer2D.setDrawRegion(var55, var13, var55 + var58.field2570, var13 + var58.field2575);
                        if(Client.field822 != 2 && Client.field822 != 5) {
                           var20 = Client.mapAngle & 2047;
                           var21 = MilliTimer.localPlayer.x / 32 + 48;
                           var22 = 464 - MilliTimer.localPlayer.y / 32;
                           class283.minimapSprite.method5948(var55, var13, var58.field2570, var58.field2575, var21, var22, var20, 256, var58.field2573, var58.field2572);

                           for(var23 = 0; var23 < Client.field651; ++var23) {
                              var24 = Client.field817[var23] * 4 + 2 - MilliTimer.localPlayer.x / 32;
                              var25 = Client.field818[var23] * 4 + 2 - MilliTimer.localPlayer.y / 32;
                              InvType.drawDot(var55, var13, var24, var25, Client.mapIcons[var23], var58);
                           }

                           var23 = 0;

                           while(true) {
                              if(var23 >= 104) {
                                 for(var23 = 0; var23 < Client.npcIndexesCount; ++var23) {
                                    NPC var66 = Client.cachedNPCs[Client.npcIndices[var23]];
                                    if(var66 != null && var66.hasConfig()) {
                                       NPCComposition var64 = var66.composition;
                                       if(var64 != null && var64.configs != null) {
                                          var64 = var64.transform();
                                       }

                                       if(var64 != null && var64.isMinimapVisible && var64.field3535) {
                                          var26 = var66.x / 32 - MilliTimer.localPlayer.x / 32;
                                          var49 = var66.y / 32 - MilliTimer.localPlayer.y / 32;
                                          InvType.drawDot(var55, var13, var26, var49, class81.mapDots[1], var58);
                                       }
                                    }
                                 }

                                 var23 = class81.playerIndexesCount;
                                 int[] var67 = class81.playerIndices;

                                 for(var25 = 0; var25 < var23; ++var25) {
                                    Player var52 = Client.cachedPlayers[var67[var25]];
                                    if(var52 != null && var52.hasConfig() && !var52.hidden && var52 != MilliTimer.localPlayer) {
                                       var49 = var52.x / 32 - MilliTimer.localPlayer.x / 32;
                                       var53 = var52.y / 32 - MilliTimer.localPlayer.y / 32;
                                       boolean var62 = false;
                                       if(MilliTimer.localPlayer.team != 0 && var52.team != 0 && var52.team == MilliTimer.localPlayer.team) {
                                          var62 = true;
                                       }

                                       if(var52.isFriend()) {
                                          InvType.drawDot(var55, var13, var49, var53, class81.mapDots[3], var58);
                                       } else if(var62) {
                                          InvType.drawDot(var55, var13, var49, var53, class81.mapDots[4], var58);
                                       } else if(var52.isClanMember()) {
                                          InvType.drawDot(var55, var13, var49, var53, class81.mapDots[5], var58);
                                       } else {
                                          InvType.drawDot(var55, var13, var49, var53, class81.mapDots[2], var58);
                                       }
                                    }
                                 }

                                 if(Client.hintArrowTargetType != 0 && Client.gameCycle % 20 < 10) {
                                    if(Client.hintArrowTargetType == 1 && Client.hintArrowNpcTargetIdx >= 0 && Client.hintArrowNpcTargetIdx < Client.cachedNPCs.length) {
                                       NPC var68 = Client.cachedNPCs[Client.hintArrowNpcTargetIdx];
                                       if(var68 != null) {
                                          var26 = var68.x / 32 - MilliTimer.localPlayer.x / 32;
                                          var49 = var68.y / 32 - MilliTimer.localPlayer.y / 32;
                                          MapIcon.worldToMinimap(var55, var13, var26, var49, class217.mapMarkers[1], var58);
                                       }
                                    }

                                    if(Client.hintArrowTargetType == 2) {
                                       var25 = Client.hintArrowX * 4 - class178.baseX * 4 + 2 - MilliTimer.localPlayer.x / 32;
                                       var26 = Client.hintArrowY * 4 - CombatInfoListHolder.baseY * 4 + 2 - MilliTimer.localPlayer.y / 32;
                                       MapIcon.worldToMinimap(var55, var13, var25, var26, class217.mapMarkers[1], var58);
                                    }

                                    if(Client.hintArrowTargetType == 10 && Client.hintArrowPlayerTargetIdx >= 0 && Client.hintArrowPlayerTargetIdx < Client.cachedPlayers.length) {
                                       Player var69 = Client.cachedPlayers[Client.hintArrowPlayerTargetIdx];
                                       if(var69 != null) {
                                          var26 = var69.x / 32 - MilliTimer.localPlayer.x / 32;
                                          var49 = var69.y / 32 - MilliTimer.localPlayer.y / 32;
                                          MapIcon.worldToMinimap(var55, var13, var26, var49, class217.mapMarkers[1], var58);
                                       }
                                    }
                                 }

                                 if(Client.destinationX != 0) {
                                    var25 = Client.destinationX * 4 + 2 - MilliTimer.localPlayer.x / 32;
                                    var26 = Client.destinationY * 4 + 2 - MilliTimer.localPlayer.y / 32;
                                    InvType.drawDot(var55, var13, var25, var26, class217.mapMarkers[0], var58);
                                 }

                                 if(!MilliTimer.localPlayer.hidden) {
                                    Rasterizer2D.Rasterizer2D_fillRectangle(var58.field2570 / 2 + var55 - 1, var58.field2575 / 2 + var13 - 1, 3, 3, 16777215);
                                 }
                                 break;
                              }

                              for(var24 = 0; var24 < 104; ++var24) {
                                 Deque var48 = Client.groundItemDeque[class192.plane][var23][var24];
                                 if(var48 != null) {
                                    var26 = var23 * 4 + 2 - MilliTimer.localPlayer.x / 32;
                                    var49 = var24 * 4 + 2 - MilliTimer.localPlayer.y / 32;
                                    InvType.drawDot(var55, var13, var26, var49, class81.mapDots[0], var58);
                                 }
                              }

                              ++var23;
                           }
                        } else {
                           Rasterizer2D.method5786(var55, var13, 0, var58.field2573, var58.field2572);
                        }

                        Client.field796[var11] = true;
                     }

                     Rasterizer2D.setDrawRegion(var2, var3, var4, var5);
                     continue;
                  }

                  if(var10.contentType == 1339) {
                     GrandExchangeOffer.method57(var10, var55, var13, var11);
                     Rasterizer2D.setDrawRegion(var2, var3, var4, var5);
                     continue;
                  }

                  if(var10.contentType == 1400) {
                     Preferences.renderOverview.extractWorldmap(var55, var13, var10.width, var10.height, Client.gameCycle);
                  }

                  if(var10.contentType == 1401) {
                     Preferences.renderOverview.extractData(var55, var13, var10.width, var10.height);
                  }
               }

               boolean var63;
               if(var10.type == 0) {
                  if(!var10.hasScript) {
                     var63 = var10.isHidden;
                     if(var63 && var10 != class37.field329) {
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

                  gameDraw(var0, var10.id, var15, var16, var17, var18, var55 - var10.scrollX, var13 - var10.scrollY, var11);
                  if(var10.children != null) {
                     gameDraw(var10.children, var10.id, var15, var16, var17, var18, var55 - var10.scrollX, var13 - var10.scrollY, var11);
                  }

                  WidgetNode var19 = (WidgetNode)Client.componentTable.get((long)var10.id);
                  if(var19 != null) {
                     class218.method4359(var19.id, var15, var16, var17, var18, var55, var13, var11);
                  }

                  Rasterizer2D.setDrawRegion(var2, var3, var4, var5);
                  Graphics3D.Rasterizer3D_method1();
               }

               if(Client.isResized || Client.field797[var11] || Client.gameDrawingMode > 1) {
                  if(var10.type == 0 && !var10.hasScript && var10.scrollHeight > var10.height) {
                     var46 = var55 + var10.width;
                     var20 = var10.scrollY;
                     var21 = var10.height;
                     var22 = var10.scrollHeight;
                     CombatInfoListHolder.scrollbarSprites[0].method5873(var46, var13);
                     CombatInfoListHolder.scrollbarSprites[1].method5873(var46, var13 + var21 - 16);
                     Rasterizer2D.Rasterizer2D_fillRectangle(var46, var13 + 16, 16, var21 - 32, Client.field655);
                     var23 = var21 * (var21 - 32) / var22;
                     if(var23 < 8) {
                        var23 = 8;
                     }

                     var24 = var20 * (var21 - 32 - var23) / (var22 - var21);
                     Rasterizer2D.Rasterizer2D_fillRectangle(var46, var24 + var13 + 16, 16, var23, Client.field656);
                     Rasterizer2D.method5842(var46, var24 + var13 + 16, var23, Client.field658);
                     Rasterizer2D.method5842(var46 + 1, var13 + var24 + 16, var23, Client.field658);
                     Rasterizer2D.method5780(var46, var13 + var24 + 16, 16, Client.field658);
                     Rasterizer2D.method5780(var46, var24 + var13 + 17, 16, Client.field658);
                     Rasterizer2D.method5842(var46 + 15, var24 + var13 + 16, var23, Client.field731);
                     Rasterizer2D.method5842(var46 + 14, var13 + var24 + 17, var23 - 1, Client.field731);
                     Rasterizer2D.method5780(var46, var23 + var13 + var24 + 15, 16, Client.field731);
                     Rasterizer2D.method5780(var46 + 1, var13 + var24 + var23 + 14, 15, Client.field731);
                  }

                  if(var10.type != 1) {
                     int var29;
                     if(var10.type == 2) {
                        var46 = 0;

                        for(var20 = 0; var20 < var10.originalHeight; ++var20) {
                           for(var21 = 0; var21 < var10.originalWidth; ++var21) {
                              var22 = var55 + var21 * (var10.paddingX + 32);
                              var23 = var13 + var20 * (var10.paddingY + 32);
                              if(var46 < 20) {
                                 var22 += var10.xSprites[var46];
                                 var23 += var10.field2693[var46];
                              }

                              if(var10.itemIds[var46] <= 0) {
                                 if(var10.field2750 != null && var46 < 20) {
                                    SpritePixels var65 = var10.method4528(var46);
                                    if(var65 != null) {
                                       var65.drawAt(var22, var23);
                                    } else if(Widget.field2621) {
                                       DState.method3548(var10);
                                    }
                                 }
                              } else {
                                 boolean var60 = false;
                                 boolean var61 = false;
                                 var26 = var10.itemIds[var46] - 1;
                                 if(var22 + 32 > var2 && var22 < var4 && var23 + 32 > var3 && var23 < var5 || var10 == class49.field442 && var46 == Client.field597) {
                                    SpritePixels var27;
                                    if(Client.itemSelectionState == 1 && var46 == class59.selectedItemIndex && var10.id == Huffman.field2296) {
                                       var27 = class171.createSprite(var26, var10.itemQuantities[var46], 2, 0, 2, false);
                                    } else {
                                       var27 = class171.createSprite(var26, var10.itemQuantities[var46], 1, 3153952, 2, false);
                                    }

                                    if(var27 != null) {
                                       if(var10 == class49.field442 && var46 == Client.field597) {
                                          var24 = MouseInput.mouseLastX - Client.field701;
                                          var25 = MouseInput.mouseLastY - Client.field640;
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

                                          var27.drawAtOpacity(var24 + var22, var25 + var23, 128);
                                          if(var1 != -1) {
                                             Widget var28 = var0[var1 & 65535];
                                             if(var25 + var23 < Rasterizer2D.drawingAreaTop && var28.scrollY > 0) {
                                                var29 = (Rasterizer2D.drawingAreaTop - var23 - var25) * Client.field654 / 3;
                                                if(var29 > Client.field654 * 10) {
                                                   var29 = Client.field654 * 10;
                                                }

                                                if(var29 > var28.scrollY) {
                                                   var29 = var28.scrollY;
                                                }

                                                var28.scrollY -= var29;
                                                Client.field640 += var29;
                                                DState.method3548(var28);
                                             }

                                             if(var23 + var25 + 32 > Rasterizer2D.drawingAreaRight && var28.scrollY < var28.scrollHeight - var28.height) {
                                                var29 = (var23 + var25 + 32 - Rasterizer2D.drawingAreaRight) * Client.field654 / 3;
                                                if(var29 > Client.field654 * 10) {
                                                   var29 = Client.field654 * 10;
                                                }

                                                if(var29 > var28.scrollHeight - var28.height - var28.scrollY) {
                                                   var29 = var28.scrollHeight - var28.height - var28.scrollY;
                                                }

                                                var28.scrollY += var29;
                                                Client.field640 -= var29;
                                                DState.method3548(var28);
                                             }
                                          }
                                       } else if(var10 == class144.field1921 && var46 == Client.pressedItemIndex) {
                                          var27.drawAtOpacity(var22, var23, 128);
                                       } else {
                                          var27.drawAt(var22, var23);
                                       }
                                    } else {
                                       DState.method3548(var10);
                                    }
                                 }
                              }

                              ++var46;
                           }
                        }
                     } else if(var10.type == 3) {
                        if(class9.method96(var10)) {
                           var46 = var10.field2640;
                           if(var10 == class37.field329 && var10.field2651 != 0) {
                              var46 = var10.field2651;
                           }
                        } else {
                           var46 = var10.textColor;
                           if(var10 == class37.field329 && var10.field2650 != 0) {
                              var46 = var10.field2650;
                           }
                        }

                        if(var10.filled) {
                           switch(var10.field2700.field3776) {
                           case 1:
                              Rasterizer2D.method5772(var55, var13, var10.width, var10.height, var10.textColor, var10.field2640, 256 - (var10.opacity & 255), 256 - (var10.field2649 & 255));
                              break;
                           case 2:
                              Rasterizer2D.method5773(var55, var13, var10.width, var10.height, var10.textColor, var10.field2640, 256 - (var10.opacity & 255), 256 - (var10.field2649 & 255));
                              break;
                           case 3:
                              Rasterizer2D.method5774(var55, var13, var10.width, var10.height, var10.textColor, var10.field2640, 256 - (var10.opacity & 255), 256 - (var10.field2649 & 255));
                              break;
                           case 4:
                              Rasterizer2D.method5838(var55, var13, var10.width, var10.height, var10.textColor, var10.field2640, 256 - (var10.opacity & 255), 256 - (var10.field2649 & 255));
                              break;
                           default:
                              if(var14 == 0) {
                                 Rasterizer2D.Rasterizer2D_fillRectangle(var55, var13, var10.width, var10.height, var46);
                              } else {
                                 Rasterizer2D.fillRectangle(var55, var13, var10.width, var10.height, var46, 256 - (var14 & 255));
                              }
                           }
                        } else if(var14 == 0) {
                           Rasterizer2D.drawRectangle(var55, var13, var10.width, var10.height, var46);
                        } else {
                           Rasterizer2D.Rasterizer2D_drawRectangleAlpha(var55, var13, var10.width, var10.height, var46, 256 - (var14 & 255));
                        }
                     } else {
                        Font var56;
                        if(var10.type == 4) {
                           var56 = var10.getFont();
                           if(var56 == null) {
                              if(Widget.field2621) {
                                 DState.method3548(var10);
                              }
                           } else {
                              String var72 = var10.text;
                              if(class9.method96(var10)) {
                                 var20 = var10.field2640;
                                 if(var10 == class37.field329 && var10.field2651 != 0) {
                                    var20 = var10.field2651;
                                 }

                                 if(var10.string1.length() > 0) {
                                    var72 = var10.string1;
                                 }
                              } else {
                                 var20 = var10.textColor;
                                 if(var10 == class37.field329 && var10.field2650 != 0) {
                                    var20 = var10.field2650;
                                 }
                              }

                              if(var10.hasScript && var10.itemId != -1) {
                                 ItemComposition var74 = class120.getItemDefinition(var10.itemId);
                                 var72 = var74.name;
                                 if(var72 == null) {
                                    var72 = "null";
                                 }

                                 if((var74.isStackable == 1 || var10.itemQuantity != 1) && var10.itemQuantity != -1) {
                                    var72 = class50.getColTags(16748608) + var72 + "</col>" + " " + 'x' + class49.method1016(var10.itemQuantity);
                                 }
                              }

                              if(var10 == Client.field756) {
                                 var72 = "Please wait...";
                                 var20 = var10.textColor;
                              }

                              if(!var10.hasScript) {
                                 var72 = FileRequest.method4621(var72, var10);
                              }

                              var56.method5595(var72, var55, var13, var10.width, var10.height, var20, var10.textShadowed?0:-1, var10.field2747, var10.field2688, var10.field2686);
                           }
                        } else if(var10.type == 5) {
                           SpritePixels var57;
                           if(!var10.hasScript) {
                              var57 = var10.method4562(class9.method96(var10));
                              if(var57 != null) {
                                 var57.drawAt(var55, var13);
                              } else if(Widget.field2621) {
                                 DState.method3548(var10);
                              }
                           } else {
                              if(var10.itemId != -1) {
                                 var57 = class171.createSprite(var10.itemId, var10.itemQuantity, var10.borderThickness, var10.sprite2, var10.field2645, false);
                              } else {
                                 var57 = var10.method4562(false);
                              }

                              if(var57 == null) {
                                 if(Widget.field2621) {
                                    DState.method3548(var10);
                                 }
                              } else {
                                 var20 = var57.maxWidth;
                                 var21 = var57.maxHeight;
                                 if(!var10.spriteTiling) {
                                    var22 = var10.width * 4096 / var20;
                                    if(var10.textureId != 0) {
                                       var57.method5998(var10.width / 2 + var55, var10.height / 2 + var13, var10.textureId, var22);
                                    } else if(var14 != 0) {
                                       var57.method5903(var55, var13, var10.width, var10.height, 256 - (var14 & 255));
                                    } else if(var20 == var10.width && var21 == var10.height) {
                                       var57.drawAt(var55, var13);
                                    } else {
                                       var57.method5897(var55, var13, var10.width, var10.height);
                                    }
                                 } else {
                                    Rasterizer2D.setInnerDrawRegion(var55, var13, var55 + var10.width, var13 + var10.height);
                                    var22 = (var20 - 1 + var10.width) / var20;
                                    var23 = (var21 - 1 + var10.height) / var21;

                                    for(var24 = 0; var24 < var22; ++var24) {
                                       for(var25 = 0; var25 < var23; ++var25) {
                                          if(var10.textureId != 0) {
                                             var57.method5998(var20 / 2 + var55 + var20 * var24, var21 / 2 + var13 + var25 * var21, var10.textureId, 4096);
                                          } else if(var14 != 0) {
                                             var57.drawAtOpacity(var55 + var24 * var20, var13 + var21 * var25, 256 - (var14 & 255));
                                          } else {
                                             var57.drawAt(var55 + var24 * var20, var13 + var21 * var25);
                                          }
                                       }
                                    }

                                    Rasterizer2D.setDrawRegion(var2, var3, var4, var5);
                                 }
                              }
                           }
                        } else {
                           ItemComposition var51;
                           if(var10.type == 6) {
                              var63 = class9.method96(var10);
                              if(var63) {
                                 var20 = var10.field2671;
                              } else {
                                 var20 = var10.field2670;
                              }

                              Model var70 = null;
                              var22 = 0;
                              if(var10.itemId != -1) {
                                 var51 = class120.getItemDefinition(var10.itemId);
                                 if(var51 != null) {
                                    var51 = var51.method5105(var10.itemQuantity);
                                    var70 = var51.getModel(1);
                                    if(var70 != null) {
                                       var70.calculateBoundsCylinder();
                                       var22 = var70.modelHeight / 2;
                                    } else {
                                       DState.method3548(var10);
                                    }
                                 }
                              } else if(var10.modelType == 5) {
                                 if(var10.modelId == 0) {
                                    var70 = Client.field853.getModel((Sequence)null, -1, (Sequence)null, -1);
                                 } else {
                                    var70 = MilliTimer.localPlayer.getModel();
                                 }
                              } else if(var20 == -1) {
                                 var70 = var10.getModel((Sequence)null, -1, var63, MilliTimer.localPlayer.composition);
                                 if(var70 == null && Widget.field2621) {
                                    DState.method3548(var10);
                                 }
                              } else {
                                 Sequence var73 = class137.getAnimation(var20);
                                 var70 = var10.getModel(var73, var10.field2746, var63, MilliTimer.localPlayer.composition);
                                 if(var70 == null && Widget.field2621) {
                                    DState.method3548(var10);
                                 }
                              }

                              Graphics3D.method2821(var10.width / 2 + var55, var10.height / 2 + var13);
                              var23 = Graphics3D.SINE[var10.rotationX] * var10.modelZoom >> 16;
                              var24 = Graphics3D.COSINE[var10.rotationX] * var10.modelZoom >> 16;
                              if(var70 != null) {
                                 if(!var10.hasScript) {
                                    var70.method2738(0, var10.rotationZ, 0, var10.rotationX, 0, var23, var24);
                                 } else {
                                    var70.calculateBoundsCylinder();
                                    if(var10.field2699) {
                                       var70.method2746(0, var10.rotationZ, var10.rotationY, var10.rotationX, var10.offsetX2d, var23 + var22 + var10.offsetY2d, var24 + var10.offsetY2d, var10.modelZoom);
                                    } else {
                                       var70.method2738(0, var10.rotationZ, var10.rotationY, var10.rotationX, var10.offsetX2d, var23 + var22 + var10.offsetY2d, var24 + var10.offsetY2d);
                                    }
                                 }
                              }

                              Graphics3D.Rasterizer3D_method3();
                           } else {
                              if(var10.type == 7) {
                                 var56 = var10.getFont();
                                 if(var56 == null) {
                                    if(Widget.field2621) {
                                       DState.method3548(var10);
                                    }
                                    continue;
                                 }

                                 var20 = 0;

                                 for(var21 = 0; var21 < var10.originalHeight; ++var21) {
                                    for(var22 = 0; var22 < var10.originalWidth; ++var22) {
                                       if(var10.itemIds[var20] > 0) {
                                          var51 = class120.getItemDefinition(var10.itemIds[var20] - 1);
                                          String var47;
                                          if(var51.isStackable != 1 && var10.itemQuantities[var20] == 1) {
                                             var47 = class50.getColTags(16748608) + var51.name + "</col>";
                                          } else {
                                             var47 = class50.getColTags(16748608) + var51.name + "</col>" + " " + 'x' + class49.method1016(var10.itemQuantities[var20]);
                                          }

                                          var25 = var55 + var22 * (var10.paddingX + 115);
                                          var26 = var13 + (var10.paddingY + 12) * var21;
                                          if(var10.field2747 == 0) {
                                             var56.method5541(var47, var25, var26, var10.textColor, var10.textShadowed?0:-1);
                                          } else if(var10.field2747 == 1) {
                                             var56.drawTextCentered(var47, var10.width / 2 + var25, var26, var10.textColor, var10.textShadowed?0:-1);
                                          } else {
                                             var56.method5543(var47, var25 + var10.width - 1, var26, var10.textColor, var10.textShadowed?0:-1);
                                          }
                                       }

                                       ++var20;
                                    }
                                 }
                              }

                              if(var10.type == 8 && var10 == class7.field42 && Client.field744 == Client.field747) {
                                 var46 = 0;
                                 var20 = 0;
                                 Font var50 = ScriptEvent.font_p12full;
                                 String var54 = var10.text;

                                 String var71;
                                 for(var54 = FileRequest.method4621(var54, var10); var54.length() > 0; var20 = var20 + var50.verticalSpace + 1) {
                                    var24 = var54.indexOf("<br>");
                                    if(var24 != -1) {
                                       var71 = var54.substring(0, var24);
                                       var54 = var54.substring(var24 + 4);
                                    } else {
                                       var71 = var54;
                                       var54 = "";
                                    }

                                    var25 = var50.getTextWidth(var71);
                                    if(var25 > var46) {
                                       var46 = var25;
                                    }
                                 }

                                 var46 += 6;
                                 var20 += 7;
                                 var24 = var55 + var10.width - 5 - var46;
                                 var25 = var13 + var10.height + 5;
                                 if(var24 < var55 + 5) {
                                    var24 = var55 + 5;
                                 }

                                 if(var46 + var24 > var4) {
                                    var24 = var4 - var46;
                                 }

                                 if(var25 + var20 > var5) {
                                    var25 = var5 - var20;
                                 }

                                 Rasterizer2D.Rasterizer2D_fillRectangle(var24, var25, var46, var20, 16777120);
                                 Rasterizer2D.drawRectangle(var24, var25, var46, var20, 0);
                                 var54 = var10.text;
                                 var26 = var25 + var50.verticalSpace + 2;

                                 for(var54 = FileRequest.method4621(var54, var10); var54.length() > 0; var26 = var26 + var50.verticalSpace + 1) {
                                    var49 = var54.indexOf("<br>");
                                    if(var49 != -1) {
                                       var71 = var54.substring(0, var49);
                                       var54 = var54.substring(var49 + 4);
                                    } else {
                                       var71 = var54;
                                       var54 = "";
                                    }

                                    var50.method5541(var71, var24 + 3, var26, 0, -1);
                                 }
                              }

                              if(var10.type == 9) {
                                 if(var10.field2657) {
                                    var46 = var55;
                                    var20 = var13 + var10.height;
                                    var21 = var55 + var10.width;
                                    var22 = var13;
                                 } else {
                                    var46 = var55;
                                    var20 = var13;
                                    var21 = var55 + var10.width;
                                    var22 = var13 + var10.height;
                                 }

                                 if(var10.lineWidth == 1) {
                                    Rasterizer2D.drawLine(var46, var20, var21, var22, var10.textColor);
                                 } else {
                                    var25 = var10.textColor;
                                    var26 = var10.lineWidth;
                                    var49 = var21 - var46;
                                    var53 = var22 - var20;
                                    var29 = var49 >= 0?var49:-var49;
                                    int var30 = var53 >= 0?var53:-var53;
                                    int var31 = var29;
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

                                       int var34 = var33 * var26 >> 17;
                                       int var35 = var33 * var26 + 1 >> 17;
                                       int var36 = var26 * var32 >> 17;
                                       int var37 = var26 * var32 + 1 >> 17;
                                       var23 = var46 - Rasterizer2D.draw_region_x;
                                       var24 = var20 - Rasterizer2D.drawingAreaTop;
                                       int var38 = var23 + var34;
                                       int var39 = var23 - var35;
                                       int var40 = var23 + var49 - var35;
                                       int var41 = var23 + var49 + var34;
                                       int var42 = var24 + var36;
                                       int var43 = var24 - var37;
                                       int var44 = var53 + var24 - var37;
                                       int var45 = var24 + var53 + var36;
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
