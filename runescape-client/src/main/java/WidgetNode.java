import java.util.concurrent.ScheduledExecutorService;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bl")
@Implements("WidgetNode")
public class WidgetNode extends Node {
   @ObfuscatedName("l")
   static ScheduledExecutorService field842;
   @ObfuscatedName("da")
   @ObfuscatedGetter(
      intValue = 434854617
   )
   @Export("myWorldPort")
   static int myWorldPort;
   @ObfuscatedName("f")
   boolean field841;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -436368989
   )
   @Export("id")
   int id;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 1936494447
   )
   @Export("owner")
   int owner;

   WidgetNode() {
      this.field841 = false;
   }

   @ObfuscatedName("hz")
   @ObfuscatedSignature(
      signature = "([Lhi;IIIIIIIII)V",
      garbageValue = "866489499"
   )
   @Export("gameDraw")
   static final void gameDraw(Widget[] var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
      Rasterizer2D.setDrawRegion(var2, var3, var4, var5);
      Graphics3D.method2614();

      for(int var9 = 0; var9 < var0.length; ++var9) {
         Widget var10 = var0[var9];
         if(var10 != null && (var10.parentId == var1 || var1 == -1412584499 && var10 == Client.field1107)) {
            int var11;
            if(var8 == -1) {
               Client.widgetPositionX[Client.field1129] = var10.relativeX + var6;
               Client.widgetPositionY[Client.field1129] = var7 + var10.relativeY;
               Client.widgetBoundsWidth[Client.field1129] = var10.width;
               Client.widgetBoundsHeight[Client.field1129] = var10.height;
               var11 = ++Client.field1129 - 1;
            } else {
               var11 = var8;
            }

            var10.boundsIndex = var11;
            var10.loopCycle = Client.gameCycle;
            if(!var10.hasScript || !Renderable.method2896(var10)) {
               if(var10.contentType > 0) {
                  BaseVarType.method11(var10);
               }

               int var12 = var10.relativeX + var6;
               int var13 = var7 + var10.relativeY;
               int var14 = var10.opacity;
               int var15;
               int var16;
               if(var10 == Client.field1107) {
                  if(var1 != -1412584499 && !var10.field2727) {
                     class20.field338 = var0;
                     class66.field830 = var6;
                     class47.field608 = var7;
                     continue;
                  }

                  if(Client.field1110 && Client.field1104) {
                     var15 = MouseInput.field734;
                     var16 = MouseInput.field735;
                     var15 -= Client.field1101;
                     var16 -= Client.field1102;
                     if(var15 < Client.field1105) {
                        var15 = Client.field1105;
                     }

                     if(var15 + var10.width > Client.field1105 + Client.field1173.width) {
                        var15 = Client.field1105 + Client.field1173.width - var10.width;
                     }

                     if(var16 < Client.field1106) {
                        var16 = Client.field1106;
                     }

                     if(var16 + var10.height > Client.field1106 + Client.field1173.height) {
                        var16 = Client.field1106 + Client.field1173.height - var10.height;
                     }

                     var12 = var15;
                     var13 = var16;
                  }

                  if(!var10.field2727) {
                     var14 = 128;
                  }
               }

               int var17;
               int var18;
               int var20;
               int var21;
               int var22;
               int var47;
               if(var10.type == 2) {
                  var15 = var2;
                  var16 = var3;
                  var17 = var4;
                  var18 = var5;
               } else if(var10.type == 9) {
                  var47 = var12;
                  var20 = var13;
                  var21 = var12 + var10.width;
                  var22 = var13 + var10.height;
                  if(var21 < var12) {
                     var47 = var21;
                     var21 = var12;
                  }

                  if(var22 < var13) {
                     var20 = var22;
                     var22 = var13;
                  }

                  ++var21;
                  ++var22;
                  var15 = var47 > var2?var47:var2;
                  var16 = var20 > var3?var20:var3;
                  var17 = var21 < var4?var21:var4;
                  var18 = var22 < var5?var22:var5;
               } else {
                  var47 = var12 + var10.width;
                  var20 = var13 + var10.height;
                  var15 = var12 > var2?var12:var2;
                  var16 = var13 > var3?var13:var3;
                  var17 = var47 < var4?var47:var4;
                  var18 = var20 < var5?var20:var5;
               }

               if(!var10.hasScript || var15 < var17 && var16 < var18) {
                  int var24;
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
                  int var49;
                  int var55;
                  if(var10.contentType != 0) {
                     if(var10.contentType == 1336) {
                        if(Client.displayFps) {
                           var13 += 15;
                           class35.font_p12full.method4782("Fps:" + GameEngine.FPS, var12 + var10.width, var13, 16776960, -1);
                           var13 += 15;
                           Runtime var60 = Runtime.getRuntime();
                           var20 = (int)((var60.totalMemory() - var60.freeMemory()) / 1024L);
                           var21 = 16776960;
                           if(var20 > '耀' && Client.lowMemory) {
                              var21 = 16711680;
                           }

                           if(var20 > 65536 && !Client.lowMemory) {
                              var21 = 16711680;
                           }

                           class35.font_p12full.method4782("Mem:" + var20 + "k", var12 + var10.width, var13, var21, -1);
                           var13 += 15;
                        }
                        continue;
                     }

                     if(var10.contentType == 1337) {
                        Client.field1075 = var12;
                        Client.field1076 = var13;
                        var21 = var10.width;
                        var22 = var10.height;
                        ++Client.field1071;
                        class266.method4875(class66.field823);
                        boolean var61 = false;
                        if(Client.field1054 >= 0) {
                           var24 = class97.field1510;
                           int[] var25 = class97.field1511;

                           for(var26 = 0; var26 < var24; ++var26) {
                              if(var25[var26] == Client.field1054) {
                                 var61 = true;
                                 break;
                              }
                           }
                        }

                        if(var61) {
                           class266.method4875(class66.field824);
                        }

                        class45.method688(true);
                        class266.method4875(var61?class66.field826:class66.field825);
                        class45.method688(false);
                        ClassInfo.method4943();

                        for(GraphicsObject var67 = (GraphicsObject)Client.graphicsObjectDeque.getFront(); var67 != null; var67 = (GraphicsObject)Client.graphicsObjectDeque.getNext()) {
                           if(var67.level == class35.plane && !var67.finished) {
                              if(Client.gameCycle >= var67.startCycle) {
                                 var67.method1671(Client.field957);
                                 if(var67.finished) {
                                    var67.unlink();
                                 } else {
                                    class36.region.method2713(var67.level, var67.x, var67.y, var67.height, 60, var67, 0, -1, false);
                                 }
                              }
                           } else {
                              var67.unlink();
                           }
                        }

                        class67.method1146(var12, var13, var21, var22, true);
                        var47 = Client.field1186;
                        var20 = Client.field1187;
                        var21 = Client.viewportHeight;
                        var22 = Client.viewportWidth;
                        Rasterizer2D.setDrawRegion(var47, var20, var47 + var21, var20 + var22);
                        Graphics3D.method2614();
                        if(!Client.field1172) {
                           var24 = Client.field1068;
                           if(Client.field1017 / 256 > var24) {
                              var24 = Client.field1017 / 256;
                           }

                           if(Client.field1000[4] && Client.field1175[4] + 128 > var24) {
                              var24 = Client.field1175[4] + 128;
                           }

                           var49 = Client.mapAngle & 2047;
                           var26 = class36.field513;
                           var27 = class25.getTileHeight(XGrandExchangeOffer.localPlayer.x, XGrandExchangeOffer.localPlayer.y, class35.plane) - Client.field1199;
                           var28 = WorldMapData.field472;
                           var29 = var24 * 3 + 600;
                           var30 = 2048 - var24 & 2047;
                           var31 = 2048 - var49 & 2047;
                           var32 = 0;
                           var33 = 0;
                           var34 = var29;
                           if(var30 != 0) {
                              var35 = Graphics3D.SINE[var30];
                              var36 = Graphics3D.COSINE[var30];
                              var37 = var36 * var33 - var35 * var29 >> 16;
                              var34 = var35 * var33 + var29 * var36 >> 16;
                              var33 = var37;
                           }

                           if(var31 != 0) {
                              var35 = Graphics3D.SINE[var31];
                              var36 = Graphics3D.COSINE[var31];
                              var37 = var34 * var35 + var36 * var32 >> 16;
                              var34 = var36 * var34 - var35 * var32 >> 16;
                              var32 = var37;
                           }

                           ISAACCipher.cameraX = var26 - var32;
                           WorldMapData.cameraZ = var27 - var33;
                           class25.cameraY = var28 - var34;
                           KeyFocusListener.cameraPitch = var24;
                           class47.cameraYaw = var49;
                        }

                        if(!Client.field1172) {
                           if(class3.preferences.hideRoofs) {
                              var49 = class35.plane;
                           } else {
                              label1655: {
                                 var26 = 3;
                                 if(KeyFocusListener.cameraPitch < 310) {
                                    var27 = ISAACCipher.cameraX >> 7;
                                    var28 = class25.cameraY >> 7;
                                    var29 = XGrandExchangeOffer.localPlayer.x >> 7;
                                    var30 = XGrandExchangeOffer.localPlayer.y >> 7;
                                    if(var27 < 0 || var28 < 0 || var27 >= 104 || var28 >= 104) {
                                       var49 = class35.plane;
                                       break label1655;
                                    }

                                    if((class61.tileSettings[class35.plane][var27][var28] & 4) != 0) {
                                       var26 = class35.plane;
                                    }

                                    if(var29 > var27) {
                                       var31 = var29 - var27;
                                    } else {
                                       var31 = var27 - var29;
                                    }

                                    if(var30 > var28) {
                                       var32 = var30 - var28;
                                    } else {
                                       var32 = var28 - var30;
                                    }

                                    if(var31 > var32) {
                                       var33 = var32 * 65536 / var31;
                                       var34 = '耀';

                                       while(var27 != var29) {
                                          if(var27 < var29) {
                                             ++var27;
                                          } else if(var27 > var29) {
                                             --var27;
                                          }

                                          if((class61.tileSettings[class35.plane][var27][var28] & 4) != 0) {
                                             var26 = class35.plane;
                                          }

                                          var34 += var33;
                                          if(var34 >= 65536) {
                                             var34 -= 65536;
                                             if(var28 < var30) {
                                                ++var28;
                                             } else if(var28 > var30) {
                                                --var28;
                                             }

                                             if((class61.tileSettings[class35.plane][var27][var28] & 4) != 0) {
                                                var26 = class35.plane;
                                             }
                                          }
                                       }
                                    } else {
                                       var33 = var31 * 65536 / var32;
                                       var34 = '耀';

                                       while(var28 != var30) {
                                          if(var28 < var30) {
                                             ++var28;
                                          } else if(var28 > var30) {
                                             --var28;
                                          }

                                          if((class61.tileSettings[class35.plane][var27][var28] & 4) != 0) {
                                             var26 = class35.plane;
                                          }

                                          var34 += var33;
                                          if(var34 >= 65536) {
                                             var34 -= 65536;
                                             if(var27 < var29) {
                                                ++var27;
                                             } else if(var27 > var29) {
                                                --var27;
                                             }

                                             if((class61.tileSettings[class35.plane][var27][var28] & 4) != 0) {
                                                var26 = class35.plane;
                                             }
                                          }
                                       }
                                    }
                                 }

                                 if(XGrandExchangeOffer.localPlayer.x >= 0 && XGrandExchangeOffer.localPlayer.y >= 0 && XGrandExchangeOffer.localPlayer.x < 13312 && XGrandExchangeOffer.localPlayer.y < 13312) {
                                    if((class61.tileSettings[class35.plane][XGrandExchangeOffer.localPlayer.x >> 7][XGrandExchangeOffer.localPlayer.y >> 7] & 4) != 0) {
                                       var26 = class35.plane;
                                    }

                                    var49 = var26;
                                 } else {
                                    var49 = class35.plane;
                                 }
                              }
                           }

                           var24 = var49;
                        } else {
                           if(class3.preferences.hideRoofs) {
                              var49 = class35.plane;
                           } else {
                              var26 = class25.getTileHeight(ISAACCipher.cameraX, class25.cameraY, class35.plane);
                              if(var26 - WorldMapData.cameraZ < 800 && (class61.tileSettings[class35.plane][ISAACCipher.cameraX >> 7][class25.cameraY >> 7] & 4) != 0) {
                                 var49 = class35.plane;
                              } else {
                                 var49 = 3;
                              }
                           }

                           var24 = var49;
                        }

                        var49 = ISAACCipher.cameraX;
                        var26 = WorldMapData.cameraZ;
                        var27 = class25.cameraY;
                        var28 = KeyFocusListener.cameraPitch;
                        var29 = class47.cameraYaw;

                        for(var30 = 0; var30 < 5; ++var30) {
                           if(Client.field1000[var30]) {
                              var31 = (int)(Math.random() * (double)(Client.field1174[var30] * 2 + 1) - (double)Client.field1174[var30] + Math.sin((double)Client.field1177[var30] * ((double)Client.field1176[var30] / 100.0D)) * (double)Client.field1175[var30]);
                              if(var30 == 0) {
                                 ISAACCipher.cameraX += var31;
                              }

                              if(var30 == 1) {
                                 WorldMapData.cameraZ += var31;
                              }

                              if(var30 == 2) {
                                 class25.cameraY += var31;
                              }

                              if(var30 == 3) {
                                 class47.cameraYaw = var31 + class47.cameraYaw & 2047;
                              }

                              if(var30 == 4) {
                                 KeyFocusListener.cameraPitch += var31;
                                 if(KeyFocusListener.cameraPitch < 128) {
                                    KeyFocusListener.cameraPitch = 128;
                                 }

                                 if(KeyFocusListener.cameraPitch > 383) {
                                    KeyFocusListener.cameraPitch = 383;
                                 }
                              }
                           }
                        }

                        var30 = MouseInput.field734;
                        var31 = MouseInput.field735;
                        if(MouseInput.field740 != 0) {
                           var30 = MouseInput.field741;
                           var31 = MouseInput.field742;
                        }

                        if(var30 >= var47 && var30 < var47 + var21 && var31 >= var20 && var31 < var20 + var22) {
                           var32 = var30 - var47;
                           var33 = var31 - var20;
                           class135.field1996 = var32;
                           class135.field1998 = var33;
                           class135.field2001 = true;
                           class135.field1997 = 0;
                           class135.field1999 = false;
                        } else {
                           class135.field2001 = false;
                           class135.field1997 = 0;
                        }

                        class182.method3458();
                        Rasterizer2D.method4968(var47, var20, var21, var22, 0);
                        class182.method3458();
                        var32 = Graphics3D.field2026;
                        Graphics3D.field2026 = Client.scale;
                        class36.region.draw(ISAACCipher.cameraX, WorldMapData.cameraZ, class25.cameraY, KeyFocusListener.cameraPitch, class47.cameraYaw, var24);
                        class13.method79();
                        Graphics3D.field2026 = var32;
                        class182.method3458();
                        class36.region.clearEntities();
                        Client.field936 = 0;
                        boolean var63 = false;
                        var34 = -1;
                        var35 = class97.field1510;
                        int[] var50 = class97.field1511;

                        for(var37 = 0; var37 < var35 + Client.field958; ++var37) {
                           Object var38;
                           if(var37 < var35) {
                              var38 = Client.cachedPlayers[var50[var37]];
                              if(var50[var37] == Client.field1054) {
                                 var63 = true;
                                 var34 = var37;
                                 continue;
                              }
                           } else {
                              var38 = Client.cachedNPCs[Client.npcIndices[var37 - var35]];
                           }

                           class21.method168((Actor)var38, var37, var47, var20, var21, var22);
                        }

                        if(var63) {
                           class21.method168(Client.cachedPlayers[Client.field1054], var34, var47, var20, var21, var22);
                        }

                        for(var37 = 0; var37 < Client.field936; ++var37) {
                           var55 = Client.field1019[var37];
                           var39 = Client.field1021[var37];
                           var40 = Client.field1165[var37];
                           var41 = Client.field1022[var37];
                           boolean var65 = true;

                           while(var65) {
                              var65 = false;

                              for(var43 = 0; var43 < var37; ++var43) {
                                 if(var39 + 2 > Client.field1021[var43] - Client.field1022[var43] && var39 - var41 < Client.field1021[var43] + 2 && var55 - var40 < Client.field1165[var43] + Client.field1019[var43] && var55 + var40 > Client.field1019[var43] - Client.field1165[var43] && Client.field1021[var43] - Client.field1022[var43] < var39) {
                                    var39 = Client.field1021[var43] - Client.field1022[var43];
                                    var65 = true;
                                 }
                              }
                           }

                           Client.screenY = Client.field1019[var37];
                           Client.screenX = Client.field1021[var37] = var39;
                           String var56 = Client.field1190[var37];
                           if(Client.field1088 == 0) {
                              var44 = 16776960;
                              if(Client.field1130[var37] < 6) {
                                 var44 = Client.field1181[Client.field1130[var37]];
                              }

                              if(Client.field1130[var37] == 6) {
                                 var44 = Client.field1071 % 20 < 10?16711680:16776960;
                              }

                              if(Client.field1130[var37] == 7) {
                                 var44 = Client.field1071 % 20 < 10?255:'\uffff';
                              }

                              if(Client.field1130[var37] == 8) {
                                 var44 = Client.field1071 % 20 < 10?'뀀':8454016;
                              }

                              if(Client.field1130[var37] == 9) {
                                 var45 = 150 - Client.field1026[var37];
                                 if(var45 < 50) {
                                    var44 = var45 * 1280 + 16711680;
                                 } else if(var45 < 100) {
                                    var44 = 16776960 - (var45 - 50) * 327680;
                                 } else if(var45 < 150) {
                                    var44 = (var45 - 100) * 5 + '\uff00';
                                 }
                              }

                              if(Client.field1130[var37] == 10) {
                                 var45 = 150 - Client.field1026[var37];
                                 if(var45 < 50) {
                                    var44 = var45 * 5 + 16711680;
                                 } else if(var45 < 100) {
                                    var44 = 16711935 - (var45 - 50) * 327680;
                                 } else if(var45 < 150) {
                                    var44 = 255 + (var45 - 100) * 327680 - (var45 - 100) * 5;
                                 }
                              }

                              if(Client.field1130[var37] == 11) {
                                 var45 = 150 - Client.field1026[var37];
                                 if(var45 < 50) {
                                    var44 = 16777215 - var45 * 327685;
                                 } else if(var45 < 100) {
                                    var44 = (var45 - 50) * 327685 + '\uff00';
                                 } else if(var45 < 150) {
                                    var44 = 16777215 - (var45 - 100) * 327680;
                                 }
                              }

                              if(Client.field1025[var37] == 0) {
                                 class61.field765.method4843(var56, var47 + Client.screenY, var20 + Client.screenX, var44, 0);
                              }

                              if(Client.field1025[var37] == 1) {
                                 class61.field765.method4785(var56, var47 + Client.screenY, var20 + Client.screenX, var44, 0, Client.field1071);
                              }

                              if(Client.field1025[var37] == 2) {
                                 class61.field765.method4786(var56, var47 + Client.screenY, var20 + Client.screenX, var44, 0, Client.field1071);
                              }

                              if(Client.field1025[var37] == 3) {
                                 class61.field765.method4787(var56, var47 + Client.screenY, var20 + Client.screenX, var44, 0, Client.field1071, 150 - Client.field1026[var37]);
                              }

                              if(Client.field1025[var37] == 4) {
                                 var45 = (150 - Client.field1026[var37]) * (class61.field765.method4775(var56) + 100) / 150;
                                 Rasterizer2D.setInnerDrawRegion(var47 + Client.screenY - 50, var20, var47 + Client.screenY + 50, var20 + var22);
                                 class61.field765.method4780(var56, var47 + Client.screenY + 50 - var45, var20 + Client.screenX, var44, 0);
                                 Rasterizer2D.setDrawRegion(var47, var20, var21 + var47, var20 + var22);
                              }

                              if(Client.field1025[var37] == 5) {
                                 var45 = 150 - Client.field1026[var37];
                                 int var46 = 0;
                                 if(var45 < 25) {
                                    var46 = var45 - 25;
                                 } else if(var45 > 125) {
                                    var46 = var45 - 125;
                                 }

                                 Rasterizer2D.setInnerDrawRegion(var47, var20 + Client.screenX - class61.field765.verticalSpace - 1, var21 + var47, var20 + Client.screenX + 5);
                                 class61.field765.method4843(var56, var47 + Client.screenY, var46 + var20 + Client.screenX, var44, 0);
                                 Rasterizer2D.setDrawRegion(var47, var20, var21 + var47, var20 + var22);
                              }
                           } else {
                              class61.field765.method4843(var56, var47 + Client.screenY, var20 + Client.screenX, 16776960, 0);
                           }
                        }

                        if(Client.field951 == 2) {
                           class7.method24((Client.hintArrowX - class47.baseX << 7) + Client.field1032, (Client.hintArrowY - class44.baseY << 7) + Client.field1161, Client.hintArrowType * 2);
                           if(Client.screenY > -1 && Client.gameCycle % 20 < 10) {
                              class13.pkIcons[0].method5172(var47 + Client.screenY - 12, var20 + Client.screenX - 28);
                           }
                        }

                        ((TextureProvider)Graphics3D.textureLoader).method2410(Client.field957);
                        if(Client.cursorState == 1) {
                           class165.field2320[Client.field940 / 100].method5172(Client.field1141 - 8, Client.field1033 - 8);
                        }

                        if(Client.cursorState == 2) {
                           class165.field2320[Client.field940 / 100 + 4].method5172(Client.field1141 - 8, Client.field1033 - 8);
                        }

                        class37.method513();
                        ISAACCipher.cameraX = var49;
                        WorldMapData.cameraZ = var26;
                        class25.cameraY = var27;
                        KeyFocusListener.cameraPitch = var28;
                        class47.cameraYaw = var29;
                        if(Client.field942) {
                           byte var64 = 0;
                           var34 = var64 + class239.field3240 + class239.field3242;
                           if(var34 == 0) {
                              Client.field942 = false;
                           }
                        }

                        if(Client.field942) {
                           Rasterizer2D.method4968(var47, var20, var21, var22, 0);
                           class88.drawStatusBox("Loading - please wait.", false);
                        }

                        Client.field1112[var10.boundsIndex] = true;
                        Rasterizer2D.setDrawRegion(var2, var3, var4, var5);
                        continue;
                     }

                     if(var10.contentType == 1338) {
                        KeyFocusListener.method784(var10, var12, var13, var11);
                        Rasterizer2D.setDrawRegion(var2, var3, var4, var5);
                        continue;
                     }

                     if(var10.contentType == 1339) {
                        class39.method563(var10, var12, var13, var11);
                        Rasterizer2D.setDrawRegion(var2, var3, var4, var5);
                        continue;
                     }

                     if(var10.contentType == 1400) {
                        class46.renderOverview.extractWorldmap(var12, var13, var10.width, var10.height, Client.gameCycle);
                     }

                     if(var10.contentType == 1401) {
                        class46.renderOverview.extractData(var12, var13, var10.width, var10.height);
                     }
                  }

                  if(var10.type == 0) {
                     if(!var10.hasScript && Renderable.method2896(var10) && var10 != class2.field12) {
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
                        var20 = var19.id;
                        if(!Ignore.loadWidget(var20)) {
                           if(var11 != -1) {
                              Client.field1112[var11] = true;
                           } else {
                              for(var21 = 0; var21 < 100; ++var21) {
                                 Client.field1112[var21] = true;
                              }
                           }
                        } else {
                           class20.field338 = null;
                           gameDraw(class176.widgets[var20], -1, var15, var16, var17, var18, var12, var13, var11);
                           if(class20.field338 != null) {
                              gameDraw(class20.field338, -1412584499, var15, var16, var17, var18, class66.field830, class47.field608, var11);
                              class20.field338 = null;
                           }
                        }
                     }

                     Rasterizer2D.setDrawRegion(var2, var3, var4, var5);
                     Graphics3D.method2614();
                  }

                  if(Client.isResized || Client.field1133[var11] || Client.gameDrawingMode > 1) {
                     if(var10.type == 0 && !var10.hasScript && var10.scrollHeight > var10.height) {
                        class19.method159(var12 + var10.width, var13, var10.scrollY, var10.height, var10.scrollHeight);
                     }

                     if(var10.type != 1) {
                        int var23;
                        if(var10.type == 2) {
                           var47 = 0;

                           for(var20 = 0; var20 < var10.field2656; ++var20) {
                              for(var21 = 0; var21 < var10.originalWidth; ++var21) {
                                 var22 = var12 + var21 * (var10.paddingX + 32);
                                 var23 = var20 * (var10.paddingY + 32) + var13;
                                 if(var47 < 20) {
                                    var22 += var10.xSprites[var47];
                                    var23 += var10.field2718[var47];
                                 }

                                 if(var10.itemIds[var47] <= 0) {
                                    if(var10.field2719 != null && var47 < 20) {
                                       SpritePixels var66 = var10.method4011(var47);
                                       if(var66 != null) {
                                          var66.method5172(var22, var23);
                                       } else if(Widget.field2647) {
                                          class90.method1723(var10);
                                       }
                                    }
                                 } else {
                                    boolean var62 = false;
                                    boolean var70 = false;
                                    var26 = var10.itemIds[var47] - 1;
                                    if(var22 + 32 > var2 && var22 < var4 && var23 + 32 > var3 && var23 < var5 || var10 == class25.field373 && var47 == Client.field1092) {
                                       SpritePixels var53;
                                       if(Client.itemSelectionState == 1 && var47 == MessageNode.selectedItemIndex && var10.id == class34.field499) {
                                          var53 = class99.createSprite(var26, var10.itemQuantities[var47], 2, 0, 2, false);
                                       } else {
                                          var53 = class99.createSprite(var26, var10.itemQuantities[var47], 1, 3153952, 2, false);
                                       }

                                       if(var53 != null) {
                                          if(var10 == class25.field373 && var47 == Client.field1092) {
                                             var24 = MouseInput.field734 - Client.field975;
                                             var49 = MouseInput.field735 - Client.field1073;
                                             if(var24 < 5 && var24 > -5) {
                                                var24 = 0;
                                             }

                                             if(var49 < 5 && var49 > -5) {
                                                var49 = 0;
                                             }

                                             if(Client.field1043 < 5) {
                                                var24 = 0;
                                                var49 = 0;
                                             }

                                             var53.method5097(var22 + var24, var23 + var49, 128);
                                             if(var1 != -1) {
                                                Widget var54 = var0[var1 & '\uffff'];
                                                if(var49 + var23 < Rasterizer2D.drawingAreaTop && var54.scrollY > 0) {
                                                   var29 = (Rasterizer2D.drawingAreaTop - var23 - var49) * Client.field957 / 3;
                                                   if(var29 > Client.field957 * 10) {
                                                      var29 = Client.field957 * 10;
                                                   }

                                                   if(var29 > var54.scrollY) {
                                                      var29 = var54.scrollY;
                                                   }

                                                   var54.scrollY -= var29;
                                                   Client.field1073 += var29;
                                                   class90.method1723(var54);
                                                }

                                                if(var23 + var49 + 32 > Rasterizer2D.drawingAreaRight && var54.scrollY < var54.scrollHeight - var54.height) {
                                                   var29 = (var23 + var49 + 32 - Rasterizer2D.drawingAreaRight) * Client.field957 / 3;
                                                   if(var29 > Client.field957 * 10) {
                                                      var29 = Client.field957 * 10;
                                                   }

                                                   if(var29 > var54.scrollHeight - var54.height - var54.scrollY) {
                                                      var29 = var54.scrollHeight - var54.height - var54.scrollY;
                                                   }

                                                   var54.scrollY += var29;
                                                   Client.field1073 -= var29;
                                                   class90.method1723(var54);
                                                }
                                             }
                                          } else if(var10 == class72.field879 && var47 == Client.field1037) {
                                             var53.method5097(var22, var23, 128);
                                          } else {
                                             var53.method5172(var22, var23);
                                          }
                                       } else {
                                          class90.method1723(var10);
                                       }
                                    }
                                 }

                                 ++var47;
                              }
                           }
                        } else if(var10.type == 3) {
                           if(class170.method3142(var10)) {
                              var47 = var10.field2675;
                              if(var10 == class2.field12 && var10.field2677 != 0) {
                                 var47 = var10.field2677;
                              }
                           } else {
                              var47 = var10.textColor;
                              if(var10 == class2.field12 && var10.field2777 != 0) {
                                 var47 = var10.field2777;
                              }
                           }

                           if(var10.field2678) {
                              switch(var10.field2679.field3756) {
                              case 1:
                                 Rasterizer2D.method4969(var12, var13, var10.width, var10.height, var10.textColor, var10.field2675, 256 - (var10.opacity & 255), 256 - (var10.field2681 & 255));
                                 break;
                              case 2:
                                 Rasterizer2D.method4970(var12, var13, var10.width, var10.height, var10.textColor, var10.field2675, 256 - (var10.opacity & 255), 256 - (var10.field2681 & 255));
                                 break;
                              case 3:
                                 Rasterizer2D.method4971(var12, var13, var10.width, var10.height, var10.textColor, var10.field2675, 256 - (var10.opacity & 255), 256 - (var10.field2681 & 255));
                                 break;
                              case 4:
                                 Rasterizer2D.method4980(var12, var13, var10.width, var10.height, var10.textColor, var10.field2675, 256 - (var10.opacity & 255), 256 - (var10.field2681 & 255));
                                 break;
                              default:
                                 if(var14 == 0) {
                                    Rasterizer2D.method4968(var12, var13, var10.width, var10.height, var47);
                                 } else {
                                    Rasterizer2D.fillRectangle(var12, var13, var10.width, var10.height, var47, 256 - (var14 & 255));
                                 }
                              }
                           } else if(var14 == 0) {
                              Rasterizer2D.drawRectangle(var12, var13, var10.width, var10.height, var47);
                           } else {
                              Rasterizer2D.method5001(var12, var13, var10.width, var10.height, var47, 256 - (var14 & 255));
                           }
                        } else {
                           Font var58;
                           if(var10.type == 4) {
                              var58 = var10.method4014();
                              if(var58 == null) {
                                 if(Widget.field2647) {
                                    class90.method1723(var10);
                                 }
                              } else {
                                 String var71 = var10.text;
                                 if(class170.method3142(var10)) {
                                    var20 = var10.field2675;
                                    if(var10 == class2.field12 && var10.field2677 != 0) {
                                       var20 = var10.field2677;
                                    }

                                    if(var10.field2710.length() > 0) {
                                       var71 = var10.field2710;
                                    }
                                 } else {
                                    var20 = var10.textColor;
                                    if(var10 == class2.field12 && var10.field2777 != 0) {
                                       var20 = var10.field2777;
                                    }
                                 }

                                 if(var10.hasScript && var10.itemId != -1) {
                                    ItemComposition var72 = SoundTask.getItemDefinition(var10.itemId);
                                    var71 = var72.name;
                                    if(var71 == null) {
                                       var71 = "null";
                                    }

                                    if((var72.isStackable == 1 || var10.itemQuantity != 1) && var10.itemQuantity != -1) {
                                       var71 = Tile.getColTags(16748608) + var71 + "</col>" + " " + 'x' + class183.method3461(var10.itemQuantity);
                                    }
                                 }

                                 if(var10 == Client.field1090) {
                                    Object var10000 = null;
                                    var71 = "Please wait...";
                                    var20 = var10.textColor;
                                 }

                                 if(!var10.hasScript) {
                                    var71 = class33.method371(var71, var10);
                                 }

                                 var58.method4784(var71, var12, var13, var10.width, var10.height, var20, var10.textShadowed?0:-1, var10.field2772, var10.field2682, var10.field2711);
                              }
                           } else if(var10.type == 5) {
                              SpritePixels var59;
                              if(!var10.hasScript) {
                                 var59 = var10.method4010(class170.method3142(var10));
                                 if(var59 != null) {
                                    var59.method5172(var12, var13);
                                 } else if(Widget.field2647) {
                                    class90.method1723(var10);
                                 }
                              } else {
                                 if(var10.itemId != -1) {
                                    var59 = class99.createSprite(var10.itemId, var10.itemQuantity, var10.borderThickness, var10.sprite2, var10.field2707, false);
                                 } else {
                                    var59 = var10.method4010(false);
                                 }

                                 if(var59 == null) {
                                    if(Widget.field2647) {
                                       class90.method1723(var10);
                                    }
                                 } else {
                                    var20 = var59.maxWidth;
                                    var21 = var59.maxHeight;
                                    if(!var10.field2687) {
                                       var22 = var10.width * 4096 / var20;
                                       if(var10.textureId != 0) {
                                          var59.method5104(var10.width / 2 + var12, var10.height / 2 + var13, var10.textureId, var22);
                                       } else if(var14 != 0) {
                                          var59.method5099(var12, var13, var10.width, var10.height, 256 - (var14 & 255));
                                       } else if(var20 == var10.width && var21 == var10.height) {
                                          var59.method5172(var12, var13);
                                       } else {
                                          var59.method5119(var12, var13, var10.width, var10.height);
                                       }
                                    } else {
                                       Rasterizer2D.setInnerDrawRegion(var12, var13, var12 + var10.width, var13 + var10.height);
                                       var22 = (var20 - 1 + var10.width) / var20;
                                       var23 = (var21 - 1 + var10.height) / var21;

                                       for(var24 = 0; var24 < var22; ++var24) {
                                          for(var49 = 0; var49 < var23; ++var49) {
                                             if(var10.textureId != 0) {
                                                var59.method5104(var20 / 2 + var20 * var24 + var12, var21 / 2 + var13 + var21 * var49, var10.textureId, 4096);
                                             } else if(var14 != 0) {
                                                var59.method5097(var12 + var20 * var24, var13 + var21 * var49, 256 - (var14 & 255));
                                             } else {
                                                var59.method5172(var20 * var24 + var12, var13 + var21 * var49);
                                             }
                                          }
                                       }

                                       Rasterizer2D.setDrawRegion(var2, var3, var4, var5);
                                    }
                                 }
                              }
                           } else {
                              ItemComposition var57;
                              if(var10.type == 6) {
                                 boolean var68 = class170.method3142(var10);
                                 if(var68) {
                                    var20 = var10.field2713;
                                 } else {
                                    var20 = var10.field2775;
                                 }

                                 Model var69 = null;
                                 var22 = 0;
                                 if(var10.itemId != -1) {
                                    var57 = SoundTask.getItemDefinition(var10.itemId);
                                    if(var57 != null) {
                                       var57 = var57.method4595(var10.itemQuantity);
                                       var69 = var57.getModel(1);
                                       if(var69 != null) {
                                          var69.method2528();
                                          var22 = var69.modelHeight / 2;
                                       } else {
                                          class90.method1723(var10);
                                       }
                                    }
                                 } else if(var10.modelType == 5) {
                                    if(var10.modelId == 0) {
                                       var69 = Client.field1008.method3970((Sequence)null, -1, (Sequence)null, -1);
                                    } else {
                                       var69 = XGrandExchangeOffer.localPlayer.getModel();
                                    }
                                 } else if(var20 == -1) {
                                    var69 = var10.method4012((Sequence)null, -1, var68, XGrandExchangeOffer.localPlayer.composition);
                                    if(var69 == null && Widget.field2647) {
                                       class90.method1723(var10);
                                    }
                                 } else {
                                    Sequence var74 = PendingSpawn.getAnimation(var20);
                                    var69 = var10.method4012(var74, var10.field2771, var68, XGrandExchangeOffer.localPlayer.composition);
                                    if(var69 == null && Widget.field2647) {
                                       class90.method1723(var10);
                                    }
                                 }

                                 Graphics3D.method2677(var10.width / 2 + var12, var10.height / 2 + var13);
                                 var23 = Graphics3D.SINE[var10.rotationX] * var10.modelZoom >> 16;
                                 var24 = Graphics3D.COSINE[var10.rotationX] * var10.modelZoom >> 16;
                                 if(var69 != null) {
                                    if(!var10.hasScript) {
                                       var69.method2563(0, var10.rotationZ, 0, var10.rotationX, 0, var23, var24);
                                    } else {
                                       var69.method2528();
                                       if(var10.field2706) {
                                          var69.method2541(0, var10.rotationZ, var10.rotationY, var10.rotationX, var10.field2698, var23 + var22 + var10.field2699, var24 + var10.field2699, var10.modelZoom);
                                       } else {
                                          var69.method2563(0, var10.rotationZ, var10.rotationY, var10.rotationX, var10.field2698, var22 + var23 + var10.field2699, var24 + var10.field2699);
                                       }
                                    }
                                 }

                                 Graphics3D.method2616();
                              } else {
                                 if(var10.type == 7) {
                                    var58 = var10.method4014();
                                    if(var58 == null) {
                                       if(Widget.field2647) {
                                          class90.method1723(var10);
                                       }
                                       continue;
                                    }

                                    var20 = 0;

                                    for(var21 = 0; var21 < var10.field2656; ++var21) {
                                       for(var22 = 0; var22 < var10.originalWidth; ++var22) {
                                          if(var10.itemIds[var20] > 0) {
                                             var57 = SoundTask.getItemDefinition(var10.itemIds[var20] - 1);
                                             String var48;
                                             if(var57.isStackable != 1 && var10.itemQuantities[var20] == 1) {
                                                var48 = Tile.getColTags(16748608) + var57.name + "</col>";
                                             } else {
                                                var48 = Tile.getColTags(16748608) + var57.name + "</col>" + " " + 'x' + class183.method3461(var10.itemQuantities[var20]);
                                             }

                                             var49 = var22 * (var10.paddingX + 115) + var12;
                                             var26 = (var10.paddingY + 12) * var21 + var13;
                                             if(var10.field2772 == 0) {
                                                var58.method4780(var48, var49, var26, var10.textColor, var10.textShadowed?0:-1);
                                             } else if(var10.field2772 == 1) {
                                                var58.method4843(var48, var10.width / 2 + var49, var26, var10.textColor, var10.textShadowed?0:-1);
                                             } else {
                                                var58.method4782(var48, var49 + var10.width - 1, var26, var10.textColor, var10.textShadowed?0:-1);
                                             }
                                          }

                                          ++var20;
                                       }
                                    }
                                 }

                                 if(var10.type == 8 && var10 == class23.field359 && Client.field1077 == Client.field1061) {
                                    var47 = 0;
                                    var20 = 0;
                                    Font var51 = class35.font_p12full;
                                    String var52 = var10.text;

                                    String var73;
                                    for(var52 = class33.method371(var52, var10); var52.length() > 0; var20 = var20 + var51.verticalSpace + 1) {
                                       var24 = var52.indexOf("<br>");
                                       if(var24 != -1) {
                                          var73 = var52.substring(0, var24);
                                          var52 = var52.substring(var24 + 4);
                                       } else {
                                          var73 = var52;
                                          var52 = "";
                                       }

                                       var49 = var51.method4775(var73);
                                       if(var49 > var47) {
                                          var47 = var49;
                                       }
                                    }

                                    var47 += 6;
                                    var20 += 7;
                                    var24 = var12 + var10.width - 5 - var47;
                                    var49 = var13 + var10.height + 5;
                                    if(var24 < var12 + 5) {
                                       var24 = var12 + 5;
                                    }

                                    if(var24 + var47 > var4) {
                                       var24 = var4 - var47;
                                    }

                                    if(var20 + var49 > var5) {
                                       var49 = var5 - var20;
                                    }

                                    Rasterizer2D.method4968(var24, var49, var47, var20, 16777120);
                                    Rasterizer2D.drawRectangle(var24, var49, var47, var20, 0);
                                    var52 = var10.text;
                                    var26 = var49 + var51.verticalSpace + 2;

                                    for(var52 = class33.method371(var52, var10); var52.length() > 0; var26 = var26 + var51.verticalSpace + 1) {
                                       var27 = var52.indexOf("<br>");
                                       if(var27 != -1) {
                                          var73 = var52.substring(0, var27);
                                          var52 = var52.substring(var27 + 4);
                                       } else {
                                          var73 = var52;
                                          var52 = "";
                                       }

                                       var51.method4780(var73, var24 + 3, var26, 0, -1);
                                    }
                                 }

                                 if(var10.type == 9) {
                                    if(var10.field2683) {
                                       var47 = var12;
                                       var20 = var13 + var10.height;
                                       var21 = var12 + var10.width;
                                       var22 = var13;
                                    } else {
                                       var47 = var12;
                                       var20 = var13;
                                       var21 = var12 + var10.width;
                                       var22 = var13 + var10.height;
                                    }

                                    if(var10.field2684 == 1) {
                                       Rasterizer2D.drawLine(var47, var20, var21, var22, var10.textColor);
                                    } else {
                                       var49 = var10.textColor;
                                       var26 = var10.field2684;
                                       var27 = var21 - var47;
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

                                          var34 = var26 * var33 >> 17;
                                          var35 = var33 * var26 + 1 >> 17;
                                          var36 = var26 * var32 >> 17;
                                          var37 = var26 * var32 + 1 >> 17;
                                          var23 = var47 - Rasterizer2D.draw_region_x;
                                          var24 = var20 - Rasterizer2D.drawingAreaTop;
                                          var55 = var23 + var34;
                                          var39 = var23 - var35;
                                          var40 = var23 + var27 - var35;
                                          var41 = var23 + var27 + var34;
                                          int var42 = var36 + var24;
                                          var43 = var24 - var37;
                                          var44 = var28 + var24 - var37;
                                          var45 = var24 + var28 + var36;
                                          Graphics3D.setRasterClippingEnabled(var55, var39, var40);
                                          Graphics3D.rasterFlat(var42, var43, var44, var55, var39, var40, var49);
                                          Graphics3D.setRasterClippingEnabled(var55, var40, var41);
                                          Graphics3D.rasterFlat(var42, var44, var45, var55, var40, var41, var49);
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

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(Lia;Lia;ZII)V",
      garbageValue = "727799795"
   )
   static void method1148(IndexDataBase var0, IndexDataBase var1, boolean var2, int var3) {
      if(class93.field1465) {
         if(var3 == 4) {
            class93.loginIndex = 4;
         }

      } else {
         class93.loginIndex = var3;
         Rasterizer2D.reset();
         byte[] var4 = var0.method4206("title.jpg", "");
         class244.field3300 = Varcs.method1851(var4);
         class92.field1425 = class244.field3300.method5081();
         if((Client.flags & 536870912) != 0) {
            class12.logoSprite = Projectile.getSprite(var1, "logo_deadman_mode", "");
         } else {
            class12.logoSprite = Projectile.getSprite(var1, "logo", "");
         }

         class93.field1446 = Projectile.getSprite(var1, "titlebox", "");
         class93.field1436 = Projectile.getSprite(var1, "titlebutton", "");
         class93.field1437 = class25.method197(var1, "runes", "");
         class233.titlemuteSprite = class25.method197(var1, "title_mute", "");
         class47.field601 = Projectile.getSprite(var1, "options_radio_buttons,0", "");
         class3.field17 = Projectile.getSprite(var1, "options_radio_buttons,2", "");
         WorldMapData.field473 = new int[256];

         int var5;
         for(var5 = 0; var5 < 64; ++var5) {
            WorldMapData.field473[var5] = var5 * 262144;
         }

         for(var5 = 0; var5 < 64; ++var5) {
            WorldMapData.field473[var5 + 64] = 16711680 + var5 * 1024;
         }

         for(var5 = 0; var5 < 64; ++var5) {
            WorldMapData.field473[var5 + 128] = 16776960 + var5 * 4;
         }

         for(var5 = 0; var5 < 64; ++var5) {
            WorldMapData.field473[var5 + 192] = 16777215;
         }

         WorldMapType3.field399 = new int[256];

         for(var5 = 0; var5 < 64; ++var5) {
            WorldMapType3.field399[var5] = var5 * 1024;
         }

         for(var5 = 0; var5 < 64; ++var5) {
            WorldMapType3.field399[var5 + 64] = var5 * 4 + '\uff00';
         }

         for(var5 = 0; var5 < 64; ++var5) {
            WorldMapType3.field399[var5 + 128] = var5 * 262144 + '\uffff';
         }

         for(var5 = 0; var5 < 64; ++var5) {
            WorldMapType3.field399[var5 + 192] = 16777215;
         }

         class93.field1440 = new int[256];

         for(var5 = 0; var5 < 64; ++var5) {
            class93.field1440[var5] = var5 * 4;
         }

         for(var5 = 0; var5 < 64; ++var5) {
            class93.field1440[var5 + 64] = var5 * 262144 + 255;
         }

         for(var5 = 0; var5 < 64; ++var5) {
            class93.field1440[var5 + 128] = var5 * 1024 + 16711935;
         }

         for(var5 = 0; var5 < 64; ++var5) {
            class93.field1440[var5 + 192] = 16777215;
         }

         BaseVarType.field28 = new int[256];
         class93.field1456 = new int['耀'];
         class228.field3136 = new int['耀'];
         class44.method654((IndexedSprite)null);
         Ignore.field871 = new int['耀'];
         class93.field1444 = new int['耀'];
         if(var2) {
            class93.username = "";
            class93.password = "";
         }

         ClassInfo.authCodeForLogin = 0;
         Preferences.authCode = "";
         class93.field1435 = true;
         class93.worldSelectShown = false;
         if(!class3.preferences.muted) {
            class20.method166(2, class253.indexTrack1, "scape main", "", 255, false);
         } else {
            class204.field2507 = 1;
            class204.field2502 = null;
            class150.field2205 = -1;
            class153.field2222 = -1;
            class204.field2504 = 0;
            class99.field1532 = false;
            class204.field2505 = 2;
         }

         class43.sendConInfo(false);
         class93.field1465 = true;
         class93.field1434 = (GameEngine.canvasWidth - 765) / 2;
         class93.loginWindowX = class93.field1434 + 202;
         class244.field3300.method5107(class93.field1434, 0);
         class92.field1425.method5107(class93.field1434 + 382, 0);
         class12.logoSprite.method5058(class93.field1434 + 382 - class12.logoSprite.originalWidth / 2, 18);
      }
   }
}
