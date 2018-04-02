import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ju")
@Implements("VarCString")
public class VarCString extends CacheableNode {
   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "Ljm;"
   )
   public static IndexDataBase field3483;
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Lhj;"
   )
   public static NodeCache field3478;
   @ObfuscatedName("o")
   public boolean field3482;

   static {
      field3478 = new NodeCache(64);
   }

   public VarCString() {
      this.field3482 = false;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Lgp;I)V",
      garbageValue = "1507365460"
   )
   public void method4782(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method4783(var1, var2);
      }
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(Lgp;II)V",
      garbageValue = "-1402607986"
   )
   void method4783(Buffer var1, int var2) {
      if(var2 == 2) {
         this.field3482 = true;
      }

   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(II)Ljt;",
      garbageValue = "-1803411668"
   )
   @Export("getKitDefinition")
   public static KitDefinition getKitDefinition(int var0) {
      KitDefinition var1 = (KitDefinition)KitDefinition.identKits.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = KitDefinition.identKit_ref.getConfigData(3, var0);
         var1 = new KitDefinition();
         if(var2 != null) {
            var1.decode(new Buffer(var2));
         }

         KitDefinition.identKits.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "2131160825"
   )
   public static int method4791(int var0) {
      return var0 >> 17 & 7;
   }

   @ObfuscatedName("ii")
   @ObfuscatedSignature(
      signature = "([Lib;IIIIIIIII)V",
      garbageValue = "-1723704151"
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
            if(!var10.hasScript || !class157.method3183(var10)) {
               if(var10.contentType > 0) {
                  PacketNode.method3437(var10);
               }

               int var12 = var10.relativeX + var6;
               int var13 = var7 + var10.relativeY;
               int var14 = var10.opacity;
               int var15;
               int var16;
               if(var10 == Client.draggedWidget) {
                  if(var1 != -1412584499 && !var10.dragRenderBehavior) {
                     Client.field1095 = var0;
                     WorldMapManager.field537 = var6;
                     SoundTask.field1582 = var7;
                     continue;
                  }

                  if(Client.draggingWidget && Client.field1032) {
                     var15 = MouseInput.mouseLastX;
                     var16 = MouseInput.mouseLastY;
                     var15 -= Client.field1029;
                     var16 -= Client.field1030;
                     if(var15 < Client.field1033) {
                        var15 = Client.field1033;
                     }

                     if(var15 + var10.width > Client.field1033 + Client.field1028.width) {
                        var15 = Client.field1033 + Client.field1028.width - var10.width;
                     }

                     if(var16 < Client.field980) {
                        var16 = Client.field980;
                     }

                     if(var16 + var10.height > Client.field980 + Client.field1028.height) {
                        var16 = Client.field980 + Client.field1028.height - var10.height;
                     }

                     var12 = var15;
                     var13 = var16;
                  }

                  if(!var10.dragRenderBehavior) {
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
                  int var30;
                  int var31;
                  int var32;
                  int var33;
                  int var34;
                  int var35;
                  int var36;
                  int var37;
                  int var39;
                  int var40;
                  int var41;
                  int var43;
                  int var44;
                  int var45;
                  int var53;
                  if(var10.contentType != 0) {
                     if(var10.contentType == 1336) {
                        if(Client.displayFps) {
                           var13 += 15;
                           Huffman.font_p12full.method5544("Fps:" + GameEngine.FPS, var12 + var10.width, var13, 16776960, -1);
                           var13 += 15;
                           Runtime var65 = Runtime.getRuntime();
                           var20 = (int)((var65.totalMemory() - var65.freeMemory()) / 1024L);
                           var21 = 16776960;
                           if(var20 > 327680 && !Client.lowMemory) {
                              var21 = 16711680;
                           }

                           Huffman.font_p12full.method5544("Mem:" + var20 + "k", var12 + var10.width, var13, var21, -1);
                           var13 += 15;
                        }
                        continue;
                     }

                     if(var10.contentType == 1337) {
                        Client.field1004 = var12;
                        Client.field1088 = var13;
                        var21 = var10.width;
                        var22 = var10.height;
                        ++Client.field953;
                        if(WorldComparator.localPlayer.x >> 7 == Client.destinationX && WorldComparator.localPlayer.y >> 7 == Client.destinationY) {
                           Client.destinationX = 0;
                        }

                        if(Client.field974) {
                           class37.method523(WorldComparator.localPlayer, false);
                        }

                        class19.method166();
                        PacketBuffer.method3820(true);
                        class233.method4334();
                        PacketBuffer.method3820(false);
                        MapIconReference.method746();
                        Name.method5437();
                        Projectile.method1921(var12, var13, var21, var22, true);
                        var19 = Client.Viewport_xOffset;
                        var20 = Client.Viewport_yOffset;
                        var21 = Client.viewportWidth;
                        var22 = Client.viewportHeight;
                        Rasterizer2D.setDrawRegion(var19, var20, var19 + var21, var22 + var20);
                        Graphics3D.Rasterizer3D_method1();
                        if(!Client.field1099) {
                           var23 = Client.cameraPitchTarget;
                           if(Client.field941 / 256 > var23) {
                              var23 = Client.field941 / 256;
                           }

                           if(Client.field901[4] && Client.field861[4] + 128 > var23) {
                              var23 = Client.field861[4] + 128;
                           }

                           var24 = Client.mapAngle & 2047;
                           var25 = class190.field2522;
                           var26 = Area.field3457;
                           var27 = NetWriter.field1474;
                           var28 = var23 * 3 + 600;
                           var29 = 2048 - var23 & 2047;
                           var30 = 2048 - var24 & 2047;
                           var31 = 0;
                           var32 = 0;
                           var33 = var28;
                           if(var29 != 0) {
                              var34 = Graphics3D.SINE[var29];
                              var35 = Graphics3D.COSINE[var29];
                              var36 = var32 * var35 - var28 * var34 >> 16;
                              var33 = var28 * var35 + var32 * var34 >> 16;
                              var32 = var36;
                           }

                           if(var30 != 0) {
                              var34 = Graphics3D.SINE[var30];
                              var35 = Graphics3D.COSINE[var30];
                              var36 = var35 * var31 + var33 * var34 >> 16;
                              var33 = var35 * var33 - var34 * var31 >> 16;
                              var31 = var36;
                           }

                           Sequence.cameraX = var25 - var31;
                           Area.cameraZ = var26 - var32;
                           ChatLineBuffer.cameraY = var27 - var33;
                           BoundingBox3D.cameraPitch = var23;
                           ClientPacket.cameraYaw = var24;
                           if(Client.field930 == 1 && Client.rights >= 2 && Client.gameCycle % 50 == 0 && (class190.field2522 >> 7 != WorldComparator.localPlayer.x >> 7 || NetWriter.field1474 >> 7 != WorldComparator.localPlayer.y >> 7)) {
                              var34 = WorldComparator.localPlayer.field842;
                              var35 = (class190.field2522 >> 7) + PacketNode.baseX;
                              var36 = (NetWriter.field1474 >> 7) + BaseVarType.baseY;
                              GrandExchangeOffer.method125(var35, var36, var34, true);
                           }
                        }

                        if(!Client.field1099) {
                           var23 = ServerPacket.method3419();
                        } else {
                           var23 = AbstractByteBuffer.method3756();
                        }

                        var24 = Sequence.cameraX;
                        var25 = Area.cameraZ;
                        var26 = ChatLineBuffer.cameraY;
                        var27 = BoundingBox3D.cameraPitch;
                        var28 = ClientPacket.cameraYaw;

                        for(var29 = 0; var29 < 5; ++var29) {
                           if(Client.field901[var29]) {
                              var30 = (int)(Math.random() * (double)(Client.field1101[var29] * 2 + 1) - (double)Client.field1101[var29] + Math.sin((double)Client.field1103[var29] / 100.0D * (double)Client.field1104[var29]) * (double)Client.field861[var29]);
                              if(var29 == 0) {
                                 Sequence.cameraX += var30;
                              }

                              if(var29 == 1) {
                                 Area.cameraZ += var30;
                              }

                              if(var29 == 2) {
                                 ChatLineBuffer.cameraY += var30;
                              }

                              if(var29 == 3) {
                                 ClientPacket.cameraYaw = var30 + ClientPacket.cameraYaw & 2047;
                              }

                              if(var29 == 4) {
                                 BoundingBox3D.cameraPitch += var30;
                                 if(BoundingBox3D.cameraPitch < 128) {
                                    BoundingBox3D.cameraPitch = 128;
                                 }

                                 if(BoundingBox3D.cameraPitch > 383) {
                                    BoundingBox3D.cameraPitch = 383;
                                 }
                              }
                           }
                        }

                        var29 = MouseInput.mouseLastX;
                        var30 = MouseInput.mouseLastY;
                        if(MouseInput.mouseLastButton != 0) {
                           var29 = MouseInput.mouseLastPressedX;
                           var30 = MouseInput.mouseLastPressedY;
                        }

                        if(var29 >= var19 && var29 < var21 + var19 && var30 >= var20 && var30 < var20 + var22) {
                           class46.method696(var29 - var19, var30 - var20);
                        } else {
                           class132.Viewport_containsMouse = false;
                           class132.Viewport_entityCountAtMouse = 0;
                        }

                        class33.method384();
                        Rasterizer2D.Rasterizer2D_fillRectangle(var19, var20, var21, var22, 0);
                        class33.method384();
                        var31 = Graphics3D.Rasterizer3D_zoom;
                        Graphics3D.Rasterizer3D_zoom = Client.scale;
                        class308.region.drawRegion(Sequence.cameraX, Area.cameraZ, ChatLineBuffer.cameraY, BoundingBox3D.cameraPitch, ClientPacket.cameraYaw, var23);
                        class81.method1796();
                        Graphics3D.Rasterizer3D_zoom = var31;
                        class33.method384();
                        class308.region.clearEntities();
                        Client.overheadTextCount = 0;
                        boolean var60 = false;
                        var33 = -1;
                        var34 = -1;
                        var35 = class93.playerIndexesCount;
                        int[] var49 = class93.playerIndices;

                        for(var37 = 0; var37 < var35 + Client.npcIndexesCount; ++var37) {
                           Object var38;
                           if(var37 < var35) {
                              var38 = Client.cachedPlayers[var49[var37]];
                              if(var49[var37] == Client.field982) {
                                 var60 = true;
                                 var33 = var37;
                                 continue;
                              }

                              if(var38 == WorldComparator.localPlayer) {
                                 var34 = var37;
                                 continue;
                              }
                           } else {
                              var38 = Client.cachedNPCs[Client.npcIndices[var37 - var35]];
                           }

                           World.draw2DExtras((Actor)var38, var37, var19, var20, var21, var22);
                        }

                        if(Client.field974 && var34 != -1) {
                           World.draw2DExtras(WorldComparator.localPlayer, var34, var19, var20, var21, var22);
                        }

                        if(var60) {
                           World.draw2DExtras(Client.cachedPlayers[Client.field982], var33, var19, var20, var21, var22);
                        }

                        for(var37 = 0; var37 < Client.overheadTextCount; ++var37) {
                           var53 = Client.overheadTextsX[var37];
                           var39 = Client.overheadTextsY[var37];
                           var40 = Client.overheadTextsOffsetX[var37];
                           var41 = Client.overheadTextsOffsetY[var37];
                           boolean var62 = true;

                           while(var62) {
                              var62 = false;

                              for(var43 = 0; var43 < var37; ++var43) {
                                 if(var39 + 2 > Client.overheadTextsY[var43] - Client.overheadTextsOffsetY[var43] && var39 - var41 < Client.overheadTextsY[var43] + 2 && var53 - var40 < Client.overheadTextsX[var43] + Client.overheadTextsOffsetX[var43] && var53 + var40 > Client.overheadTextsX[var43] - Client.overheadTextsOffsetX[var43] && Client.overheadTextsY[var43] - Client.overheadTextsOffsetY[var43] < var39) {
                                    var39 = Client.overheadTextsY[var43] - Client.overheadTextsOffsetY[var43];
                                    var62 = true;
                                 }
                              }
                           }

                           Client.screenX = Client.overheadTextsX[var37];
                           Client.screenY = Client.overheadTextsY[var37] = var39;
                           String var56 = Client.overheadTexts[var37];
                           if(Client.field1018 == 0) {
                              var44 = 16776960;
                              if(Client.field1073[var37] < 6) {
                                 var44 = Client.field1070[Client.field1073[var37]];
                              }

                              if(Client.field1073[var37] == 6) {
                                 var44 = Client.field953 % 20 < 10?16711680:16776960;
                              }

                              if(Client.field1073[var37] == 7) {
                                 var44 = Client.field953 % 20 < 10?255:'\uffff';
                              }

                              if(Client.field1073[var37] == 8) {
                                 var44 = Client.field953 % 20 < 10?'뀀':8454016;
                              }

                              if(Client.field1073[var37] == 9) {
                                 var45 = 150 - Client.overheadTextsCyclesRemaining[var37];
                                 if(var45 < 50) {
                                    var44 = var45 * 1280 + 16711680;
                                 } else if(var45 < 100) {
                                    var44 = 16776960 - (var45 - 50) * 327680;
                                 } else if(var45 < 150) {
                                    var44 = (var45 - 100) * 5 + 65280;
                                 }
                              }

                              if(Client.field1073[var37] == 10) {
                                 var45 = 150 - Client.overheadTextsCyclesRemaining[var37];
                                 if(var45 < 50) {
                                    var44 = var45 * 5 + 16711680;
                                 } else if(var45 < 100) {
                                    var44 = 16711935 - (var45 - 50) * 327680;
                                 } else if(var45 < 150) {
                                    var44 = (var45 - 100) * 327680 + 255 - (var45 - 100) * 5;
                                 }
                              }

                              if(Client.field1073[var37] == 11) {
                                 var45 = 150 - Client.overheadTextsCyclesRemaining[var37];
                                 if(var45 < 50) {
                                    var44 = 16777215 - var45 * 327685;
                                 } else if(var45 < 100) {
                                    var44 = (var45 - 50) * 327685 + 65280;
                                 } else if(var45 < 150) {
                                    var44 = 16777215 - (var45 - 100) * 327680;
                                 }
                              }

                              if(Client.field984[var37] == 0) {
                                 class228.fontBold12.drawTextCentered(var56, var19 + Client.screenX, var20 + Client.screenY, var44, 0);
                              }

                              if(Client.field984[var37] == 1) {
                                 class228.fontBold12.method5526(var56, var19 + Client.screenX, var20 + Client.screenY, var44, 0, Client.field953);
                              }

                              if(Client.field984[var37] == 2) {
                                 class228.fontBold12.method5527(var56, var19 + Client.screenX, var20 + Client.screenY, var44, 0, Client.field953);
                              }

                              if(Client.field984[var37] == 3) {
                                 class228.fontBold12.method5528(var56, var19 + Client.screenX, var20 + Client.screenY, var44, 0, Client.field953, 150 - Client.overheadTextsCyclesRemaining[var37]);
                              }

                              if(Client.field984[var37] == 4) {
                                 var45 = (150 - Client.overheadTextsCyclesRemaining[var37]) * (class228.fontBold12.getTextWidth(var56) + 100) / 150;
                                 Rasterizer2D.setInnerDrawRegion(var19 + Client.screenX - 50, var20, var19 + Client.screenX + 50, var22 + var20);
                                 class228.fontBold12.method5521(var56, var19 + Client.screenX + 50 - var45, var20 + Client.screenY, var44, 0);
                                 Rasterizer2D.setDrawRegion(var19, var20, var19 + var21, var20 + var22);
                              }

                              if(Client.field984[var37] == 5) {
                                 var45 = 150 - Client.overheadTextsCyclesRemaining[var37];
                                 int var46 = 0;
                                 if(var45 < 25) {
                                    var46 = var45 - 25;
                                 } else if(var45 > 125) {
                                    var46 = var45 - 125;
                                 }

                                 Rasterizer2D.setInnerDrawRegion(var19, var20 + Client.screenY - class228.fontBold12.verticalSpace - 1, var21 + var19, var20 + Client.screenY + 5);
                                 class228.fontBold12.drawTextCentered(var56, var19 + Client.screenX, var20 + var46 + Client.screenY, var44, 0);
                                 Rasterizer2D.setDrawRegion(var19, var20, var19 + var21, var20 + var22);
                              }
                           } else {
                              class228.fontBold12.drawTextCentered(var56, var19 + Client.screenX, var20 + Client.screenY, 16776960, 0);
                           }
                        }

                        class22.method187(var19, var20);
                        ((TextureProvider)Graphics3D.textureLoader).checkTextures(Client.field893);
                        class37.method524(var19, var20, var21, var22);
                        Sequence.cameraX = var24;
                        Area.cameraZ = var25;
                        ChatLineBuffer.cameraY = var26;
                        BoundingBox3D.cameraPitch = var27;
                        ClientPacket.cameraYaw = var28;
                        if(Client.field865) {
                           byte var61 = 0;
                           var33 = var61 + class264.NetCache_pendingPriorityWritesCount + class264.NetCache_pendingPriorityResponsesCount;
                           if(var33 == 0) {
                              Client.field865 = false;
                           }
                        }

                        if(Client.field865) {
                           Rasterizer2D.Rasterizer2D_fillRectangle(var19, var20, var21, var22, 0);
                           VertexNormal.method2787("Loading - please wait.", false);
                        }

                        Client.field1060[var10.boundsIndex] = true;
                        Rasterizer2D.setDrawRegion(var2, var3, var4, var5);
                        continue;
                     }

                     if(var10.contentType == 1338) {
                        class28.method268(var10, var12, var13, var11);
                        Rasterizer2D.setDrawRegion(var2, var3, var4, var5);
                        continue;
                     }

                     if(var10.contentType == 1339) {
                        class62.method1068(var10, var12, var13, var11);
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
                     if(!var10.hasScript && class157.method3183(var10) && var10 != Coordinates.field2775) {
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

                     WidgetNode var47 = (WidgetNode)Client.componentTable.get((long)var10.id);
                     if(var47 != null) {
                        UnitPriceComparator.method138(var47.id, var15, var16, var17, var18, var12, var13, var11);
                     }

                     Rasterizer2D.setDrawRegion(var2, var3, var4, var5);
                     Graphics3D.Rasterizer3D_method1();
                  }

                  if(Client.isResized || Client.field1062[var11] || Client.gameDrawingMode > 1) {
                     if(var10.type == 0 && !var10.hasScript && var10.scrollHeight > var10.height) {
                        var19 = var12 + var10.width;
                        var20 = var10.scrollY;
                        var21 = var10.height;
                        var22 = var10.scrollHeight;
                        PendingSpawn.scrollbarSprites[0].method5842(var19, var13);
                        PendingSpawn.scrollbarSprites[1].method5842(var19, var21 + var13 - 16);
                        Rasterizer2D.Rasterizer2D_fillRectangle(var19, var13 + 16, 16, var21 - 32, Client.field918);
                        var23 = var21 * (var21 - 32) / var22;
                        if(var23 < 8) {
                           var23 = 8;
                        }

                        var24 = var20 * (var21 - 32 - var23) / (var22 - var21);
                        Rasterizer2D.Rasterizer2D_fillRectangle(var19, var24 + var13 + 16, 16, var23, Client.field895);
                        Rasterizer2D.method5752(var19, var13 + var24 + 16, var23, Client.field921);
                        Rasterizer2D.method5752(var19 + 1, var13 + var24 + 16, var23, Client.field921);
                        Rasterizer2D.method5756(var19, var13 + var24 + 16, 16, Client.field921);
                        Rasterizer2D.method5756(var19, var24 + var13 + 17, 16, Client.field921);
                        Rasterizer2D.method5752(var19 + 15, var13 + var24 + 16, var23, Client.field920);
                        Rasterizer2D.method5752(var19 + 14, var24 + var13 + 17, var23 - 1, Client.field920);
                        Rasterizer2D.method5756(var19, var13 + var24 + var23 + 15, 16, Client.field920);
                        Rasterizer2D.method5756(var19 + 1, var13 + var24 + var23 + 14, 15, Client.field920);
                     }

                     if(var10.type != 1) {
                        if(var10.type == 2) {
                           var19 = 0;

                           for(var20 = 0; var20 < var10.originalHeight; ++var20) {
                              for(var21 = 0; var21 < var10.originalWidth; ++var21) {
                                 var22 = var12 + var21 * (var10.paddingX + 32);
                                 var23 = var20 * (var10.paddingY + 32) + var13;
                                 if(var19 < 20) {
                                    var22 += var10.xSprites[var19];
                                    var23 += var10.field2883[var19];
                                 }

                                 if(var10.itemIds[var19] <= 0) {
                                    if(var10.field2884 != null && var19 < 20) {
                                       SpritePixels var66 = var10.method4454(var19);
                                       if(var66 != null) {
                                          var66.drawAt(var22, var23);
                                       } else if(Widget.field2812) {
                                          WorldMapType1.method274(var10);
                                       }
                                    }
                                 } else {
                                    boolean var58 = false;
                                    boolean var59 = false;
                                    var26 = var10.itemIds[var19] - 1;
                                    if(var22 + 32 > var2 && var22 < var4 && var23 + 32 > var3 && var23 < var5 || var10 == class157.field2149 && var19 == Client.field1080) {
                                       SpritePixels var54;
                                       if(Client.itemSelectionState == 1 && var19 == class49.selectedItemIndex && var10.id == Client.field900) {
                                          var54 = class93.createSprite(var26, var10.itemQuantities[var19], 2, 0, 2, false);
                                       } else {
                                          var54 = class93.createSprite(var26, var10.itemQuantities[var19], 1, 3153952, 2, false);
                                       }

                                       if(var54 != null) {
                                          if(var10 == class157.field2149 && var19 == Client.field1080) {
                                             var24 = MouseInput.mouseLastX - Client.field964;
                                             var25 = MouseInput.mouseLastY - Client.field1056;
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

                                             var54.drawAtOpacity(var24 + var22, var25 + var23, 128);
                                             if(var1 != -1) {
                                                Widget var55 = var0[var1 & 65535];
                                                if(var23 + var25 < Rasterizer2D.drawingAreaTop && var55.scrollY > 0) {
                                                   var29 = (Rasterizer2D.drawingAreaTop - var23 - var25) * Client.field893 / 3;
                                                   if(var29 > Client.field893 * 10) {
                                                      var29 = Client.field893 * 10;
                                                   }

                                                   if(var29 > var55.scrollY) {
                                                      var29 = var55.scrollY;
                                                   }

                                                   var55.scrollY -= var29;
                                                   Client.field1056 += var29;
                                                   WorldMapType1.method274(var55);
                                                }

                                                if(var23 + var25 + 32 > Rasterizer2D.drawingAreaRight && var55.scrollY < var55.scrollHeight - var55.height) {
                                                   var29 = (var23 + var25 + 32 - Rasterizer2D.drawingAreaRight) * Client.field893 / 3;
                                                   if(var29 > Client.field893 * 10) {
                                                      var29 = Client.field893 * 10;
                                                   }

                                                   if(var29 > var55.scrollHeight - var55.height - var55.scrollY) {
                                                      var29 = var55.scrollHeight - var55.height - var55.scrollY;
                                                   }

                                                   var55.scrollY += var29;
                                                   Client.field1056 -= var29;
                                                   WorldMapType1.method274(var55);
                                                }
                                             }
                                          } else if(var10 == class64.field750 && var19 == Client.pressedItemIndex) {
                                             var54.drawAtOpacity(var22, var23, 128);
                                          } else {
                                             var54.drawAt(var22, var23);
                                          }
                                       } else {
                                          WorldMapType1.method274(var10);
                                       }
                                    }
                                 }

                                 ++var19;
                              }
                           }
                        } else if(var10.type == 3) {
                           if(class167.method3248(var10)) {
                              var19 = var10.field2920;
                              if(var10 == Coordinates.field2775 && var10.field2842 != 0) {
                                 var19 = var10.field2842;
                              }
                           } else {
                              var19 = var10.textColor;
                              if(var10 == Coordinates.field2775 && var10.field2841 != 0) {
                                 var19 = var10.field2841;
                              }
                           }

                           if(var10.filled) {
                              switch(var10.field2896.field3967) {
                              case 1:
                                 Rasterizer2D.method5742(var12, var13, var10.width, var10.height, var10.textColor, var10.field2920, 256 - (var10.opacity & 255), 256 - (var10.field2846 & 255));
                                 break;
                              case 2:
                                 Rasterizer2D.method5743(var12, var13, var10.width, var10.height, var10.textColor, var10.field2920, 256 - (var10.opacity & 255), 256 - (var10.field2846 & 255));
                                 break;
                              case 3:
                                 Rasterizer2D.method5744(var12, var13, var10.width, var10.height, var10.textColor, var10.field2920, 256 - (var10.opacity & 255), 256 - (var10.field2846 & 255));
                                 break;
                              case 4:
                                 Rasterizer2D.method5773(var12, var13, var10.width, var10.height, var10.textColor, var10.field2920, 256 - (var10.opacity & 255), 256 - (var10.field2846 & 255));
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
                           Font var63;
                           if(var10.type == 4) {
                              var63 = var10.getFont();
                              if(var63 == null) {
                                 if(Widget.field2812) {
                                    WorldMapType1.method274(var10);
                                 }
                              } else {
                                 String var69 = var10.text;
                                 if(class167.method3248(var10)) {
                                    var20 = var10.field2920;
                                    if(var10 == Coordinates.field2775 && var10.field2842 != 0) {
                                       var20 = var10.field2842;
                                    }

                                    if(var10.string1.length() > 0) {
                                       var69 = var10.string1;
                                    }
                                 } else {
                                    var20 = var10.textColor;
                                    if(var10 == Coordinates.field2775 && var10.field2841 != 0) {
                                       var20 = var10.field2841;
                                    }
                                 }

                                 if(var10.hasScript && var10.itemId != -1) {
                                    ItemComposition var70 = GameObject.getItemDefinition(var10.itemId);
                                    var69 = var70.name;
                                    if(var69 == null) {
                                       var69 = "null";
                                    }

                                    if((var70.isStackable == 1 || var10.itemQuantity != 1) && var10.itemQuantity != -1) {
                                       var69 = class173.getColTags(16748608) + var69 + "</col>" + " " + 'x' + Widget.method4503(var10.itemQuantity);
                                    }
                                 }

                                 if(var10 == Client.field1102) {
                                    var69 = "Please wait...";
                                    var20 = var10.textColor;
                                 }

                                 if(!var10.hasScript) {
                                    var69 = Fonts.method5500(var69, var10);
                                 }

                                 var63.method5525(var69, var12, var13, var10.width, var10.height, var20, var10.textShadowed?0:-1, var10.field2877, var10.field2929, var10.field2804);
                              }
                           } else if(var10.type == 5) {
                              SpritePixels var64;
                              if(!var10.hasScript) {
                                 var64 = var10.method4452(class167.method3248(var10));
                                 if(var64 != null) {
                                    var64.drawAt(var12, var13);
                                 } else if(Widget.field2812) {
                                    WorldMapType1.method274(var10);
                                 }
                              } else {
                                 if(var10.itemId != -1) {
                                    var64 = class93.createSprite(var10.itemId, var10.itemQuantity, var10.borderThickness, var10.sprite2, var10.field2872, false);
                                 } else {
                                    var64 = var10.method4452(false);
                                 }

                                 if(var64 == null) {
                                    if(Widget.field2812) {
                                       WorldMapType1.method274(var10);
                                    }
                                 } else {
                                    var20 = var64.maxWidth;
                                    var21 = var64.maxHeight;
                                    if(!var10.spriteTiling) {
                                       var22 = var10.width * 4096 / var20;
                                       if(var10.textureId != 0) {
                                          var64.method5906(var10.width / 2 + var12, var10.height / 2 + var13, var10.textureId, var22);
                                       } else if(var14 != 0) {
                                          var64.method5877(var12, var13, var10.width, var10.height, 256 - (var14 & 255));
                                       } else if(var20 == var10.width && var21 == var10.height) {
                                          var64.drawAt(var12, var13);
                                       } else {
                                          var64.method5871(var12, var13, var10.width, var10.height);
                                       }
                                    } else {
                                       Rasterizer2D.setInnerDrawRegion(var12, var13, var12 + var10.width, var13 + var10.height);
                                       var22 = (var20 - 1 + var10.width) / var20;
                                       var23 = (var21 - 1 + var10.height) / var21;

                                       for(var24 = 0; var24 < var22; ++var24) {
                                          for(var25 = 0; var25 < var23; ++var25) {
                                             if(var10.textureId != 0) {
                                                var64.method5906(var20 / 2 + var12 + var24 * var20, var21 / 2 + var13 + var21 * var25, var10.textureId, 4096);
                                             } else if(var14 != 0) {
                                                var64.drawAtOpacity(var12 + var24 * var20, var13 + var21 * var25, 256 - (var14 & 255));
                                             } else {
                                                var64.drawAt(var12 + var24 * var20, var13 + var25 * var21);
                                             }
                                          }
                                       }

                                       Rasterizer2D.setDrawRegion(var2, var3, var4, var5);
                                    }
                                 }
                              }
                           } else {
                              ItemComposition var52;
                              if(var10.type == 6) {
                                 boolean var57 = class167.method3248(var10);
                                 if(var57) {
                                    var20 = var10.field2862;
                                 } else {
                                    var20 = var10.field2831;
                                 }

                                 Model var67 = null;
                                 var22 = 0;
                                 if(var10.itemId != -1) {
                                    var52 = GameObject.getItemDefinition(var10.itemId);
                                    if(var52 != null) {
                                       var52 = var52.method5062(var10.itemQuantity);
                                       var67 = var52.getModel(1);
                                       if(var67 != null) {
                                          var67.calculateBoundsCylinder();
                                          var22 = var67.modelHeight / 2;
                                       } else {
                                          WorldMapType1.method274(var10);
                                       }
                                    }
                                 } else if(var10.modelType == 5) {
                                    if(var10.modelId == 0) {
                                       var67 = Client.field1118.getModel((Sequence)null, -1, (Sequence)null, -1);
                                    } else {
                                       var67 = WorldComparator.localPlayer.getModel();
                                    }
                                 } else if(var20 == -1) {
                                    var67 = var10.getModel((Sequence)null, -1, var57, WorldComparator.localPlayer.composition);
                                    if(var67 == null && Widget.field2812) {
                                       WorldMapType1.method274(var10);
                                    }
                                 } else {
                                    Sequence var71 = ISAACCipher.getAnimation(var20);
                                    var67 = var10.getModel(var71, var10.field2837, var57, WorldComparator.localPlayer.composition);
                                    if(var67 == null && Widget.field2812) {
                                       WorldMapType1.method274(var10);
                                    }
                                 }

                                 Graphics3D.method2795(var10.width / 2 + var12, var10.height / 2 + var13);
                                 var23 = Graphics3D.SINE[var10.rotationX] * var10.modelZoom >> 16;
                                 var24 = Graphics3D.COSINE[var10.rotationX] * var10.modelZoom >> 16;
                                 if(var67 != null) {
                                    if(!var10.hasScript) {
                                       var67.method2700(0, var10.rotationZ, 0, var10.rotationX, 0, var23, var24);
                                    } else {
                                       var67.calculateBoundsCylinder();
                                       if(var10.field2829) {
                                          var67.method2701(0, var10.rotationZ, var10.rotationY, var10.rotationX, var10.offsetX2d, var23 + var22 + var10.offsetY2d, var24 + var10.offsetY2d, var10.modelZoom);
                                       } else {
                                          var67.method2700(0, var10.rotationZ, var10.rotationY, var10.rotationX, var10.offsetX2d, var23 + var22 + var10.offsetY2d, var24 + var10.offsetY2d);
                                       }
                                    }
                                 }

                                 Graphics3D.Rasterizer3D_method3();
                              } else {
                                 if(var10.type == 7) {
                                    var63 = var10.getFont();
                                    if(var63 == null) {
                                       if(Widget.field2812) {
                                          WorldMapType1.method274(var10);
                                       }
                                       continue;
                                    }

                                    var20 = 0;

                                    for(var21 = 0; var21 < var10.originalHeight; ++var21) {
                                       for(var22 = 0; var22 < var10.originalWidth; ++var22) {
                                          if(var10.itemIds[var20] > 0) {
                                             var52 = GameObject.getItemDefinition(var10.itemIds[var20] - 1);
                                             String var48;
                                             if(var52.isStackable != 1 && var10.itemQuantities[var20] == 1) {
                                                var48 = class173.getColTags(16748608) + var52.name + "</col>";
                                             } else {
                                                var48 = class173.getColTags(16748608) + var52.name + "</col>" + " " + 'x' + Widget.method4503(var10.itemQuantities[var20]);
                                             }

                                             var25 = var22 * (var10.paddingX + 115) + var12;
                                             var26 = var13 + (var10.paddingY + 12) * var21;
                                             if(var10.field2877 == 0) {
                                                var63.method5521(var48, var25, var26, var10.textColor, var10.textShadowed?0:-1);
                                             } else if(var10.field2877 == 1) {
                                                var63.drawTextCentered(var48, var10.width / 2 + var25, var26, var10.textColor, var10.textShadowed?0:-1);
                                             } else {
                                                var63.method5544(var48, var25 + var10.width - 1, var26, var10.textColor, var10.textShadowed?0:-1);
                                             }
                                          }

                                          ++var20;
                                       }
                                    }
                                 }

                                 if(var10.type == 8 && var10 == class23.field331 && Client.field1007 == Client.field1006) {
                                    var19 = 0;
                                    var20 = 0;
                                    Font var50 = Huffman.font_p12full;
                                    String var51 = var10.text;

                                    String var68;
                                    for(var51 = Fonts.method5500(var51, var10); var51.length() > 0; var20 = var20 + var50.verticalSpace + 1) {
                                       var24 = var51.indexOf("<br>");
                                       if(var24 != -1) {
                                          var68 = var51.substring(0, var24);
                                          var51 = var51.substring(var24 + 4);
                                       } else {
                                          var68 = var51;
                                          var51 = "";
                                       }

                                       var25 = var50.getTextWidth(var68);
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

                                    if(var20 + var25 > var5) {
                                       var25 = var5 - var20;
                                    }

                                    Rasterizer2D.Rasterizer2D_fillRectangle(var24, var25, var19, var20, 16777120);
                                    Rasterizer2D.drawRectangle(var24, var25, var19, var20, 0);
                                    var51 = var10.text;
                                    var26 = var25 + var50.verticalSpace + 2;

                                    for(var51 = Fonts.method5500(var51, var10); var51.length() > 0; var26 = var26 + var50.verticalSpace + 1) {
                                       var27 = var51.indexOf("<br>");
                                       if(var27 != -1) {
                                          var68 = var51.substring(0, var27);
                                          var51 = var51.substring(var27 + 4);
                                       } else {
                                          var68 = var51;
                                          var51 = "";
                                       }

                                       var50.method5521(var68, var24 + 3, var26, 0, -1);
                                    }
                                 }

                                 if(var10.type == 9) {
                                    if(var10.field2897) {
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
                                       var27 = var21 - var19;
                                       var28 = var22 - var20;
                                       var29 = var27 >= 0?var27:-var27;
                                       var30 = var28 >= 0?var28:-var28;
                                       var31 = var29;
                                       if(var29 < var30) {
                                          var31 = var30;
                                       }

                                       if(var31 != 0) {
                                          var32 = (var27 << 16) / var31;
                                          var33 = (var28 << 16) / var31;
                                          if(var33 <= var32) {
                                             var32 = -var32;
                                          } else {
                                             var33 = -var33;
                                          }

                                          var34 = var33 * var26 >> 17;
                                          var35 = var33 * var26 + 1 >> 17;
                                          var36 = var26 * var32 >> 17;
                                          var37 = var32 * var26 + 1 >> 17;
                                          var23 = var19 - Rasterizer2D.draw_region_x;
                                          var24 = var20 - Rasterizer2D.drawingAreaTop;
                                          var53 = var34 + var23;
                                          var39 = var23 - var35;
                                          var40 = var23 + var27 - var35;
                                          var41 = var27 + var23 + var34;
                                          int var42 = var24 + var36;
                                          var43 = var24 - var37;
                                          var44 = var28 + var24 - var37;
                                          var45 = var28 + var24 + var36;
                                          Graphics3D.setRasterClippingEnabled(var53, var39, var40);
                                          Graphics3D.rasterFlat(var42, var43, var44, var53, var39, var40, var25);
                                          Graphics3D.setRasterClippingEnabled(var53, var40, var41);
                                          Graphics3D.rasterFlat(var42, var44, var45, var53, var40, var41, var25);
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
