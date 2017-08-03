import java.awt.Component;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hx")
public class class215 {
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Component;S)V",
      garbageValue = "229"
   )
   static void method4000(Component var0) {
      var0.removeKeyListener(KeyFocusListener.keyboard);
      var0.removeFocusListener(KeyFocusListener.keyboard);
      KeyFocusListener.field607 = -1;
   }

   @ObfuscatedName("ih")
   @ObfuscatedSignature(
      signature = "([Lhn;IIIIIIIIB)V",
      garbageValue = "109"
   )
   @Export("gameDraw")
   static final void gameDraw(Widget[] var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
      Rasterizer2D.setDrawRegion(var2, var3, var4, var5);
      Graphics3D.method2605();

      for(int var9 = 0; var9 < var0.length; ++var9) {
         Widget var10 = var0[var9];
         if(var10 != null && (var10.parentId == var1 || var1 == -1412584499 && var10 == Client.field912)) {
            int var11;
            if(var8 == -1) {
               Client.widgetPositionX[Client.field1086] = var10.relativeX + var6;
               Client.widgetPositionY[Client.field1086] = var7 + var10.relativeY;
               Client.widgetBoundsWidth[Client.field1086] = var10.width;
               Client.widgetBoundsHeight[Client.field1086] = var10.height;
               var11 = ++Client.field1086 - 1;
            } else {
               var11 = var8;
            }

            var10.boundsIndex = var11;
            var10.loopCycle = Client.gameCycle;
            if(!var10.hasScript || !class177.method3423(var10)) {
               if(var10.contentType > 0) {
                  class20.method145(var10);
               }

               int var12 = var10.relativeX + var6;
               int var13 = var7 + var10.relativeY;
               int var14 = var10.opacity;
               int var15;
               int var16;
               if(var10 == Client.field912) {
                  if(var1 != -1412584499 && !var10.field2652) {
                     class67.field797 = var0;
                     class51.field623 = var6;
                     class7.field226 = var7;
                     continue;
                  }

                  if(Client.field1067 && Client.field1061) {
                     var15 = MouseInput.field696;
                     var16 = MouseInput.field705;
                     var15 -= Client.field1073;
                     var16 -= Client.field1063;
                     if(var15 < Client.field1062) {
                        var15 = Client.field1062;
                     }

                     if(var15 + var10.width > Client.field1062 + Client.field1057.width) {
                        var15 = Client.field1062 + Client.field1057.width - var10.width;
                     }

                     if(var16 < Client.field943) {
                        var16 = Client.field943;
                     }

                     if(var16 + var10.height > Client.field943 + Client.field1057.height) {
                        var16 = Client.field943 + Client.field1057.height - var10.height;
                     }

                     var12 = var15;
                     var13 = var16;
                  }

                  if(!var10.field2652) {
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
                  int var23;
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
                  int var37;
                  int var39;
                  int var40;
                  int var41;
                  int var43;
                  int var44;
                  int var45;
                  int var49;
                  int var52;
                  if(var10.contentType != 0) {
                     if(var10.contentType == 1336) {
                        if(Client.displayFps) {
                           var13 += 15;
                           class18.font_p12full.method4741("Fps:" + GameEngine.FPS, var12 + var10.width, var13, 16776960, -1);
                           var13 += 15;
                           Runtime var62 = Runtime.getRuntime();
                           var20 = (int)((var62.totalMemory() - var62.freeMemory()) / 1024L);
                           var21 = 16776960;
                           if(var20 > '耀' && Client.lowMemory) {
                              var21 = 16711680;
                           }

                           if(var20 > 65536 && !Client.lowMemory) {
                              var21 = 16711680;
                           }

                           class18.font_p12full.method4741("Mem:" + var20 + "k", var12 + var10.width, var13, var21, -1);
                           var13 += 15;
                        }
                        continue;
                     }

                     if(var10.contentType == 1337) {
                        Client.field1032 = var12;
                        Client.field966 = var13;
                        var21 = var10.width;
                        var22 = var10.height;
                        ++Client.field1038;
                        class41.method577(class66.field784);
                        boolean var68 = false;
                        if(Client.field927 >= 0) {
                           var24 = class96.field1470;
                           int[] var66 = class96.field1468;

                           for(var26 = 0; var26 < var24; ++var26) {
                              if(var66[var26] == Client.field927) {
                                 var68 = true;
                                 break;
                              }
                           }
                        }

                        if(var68) {
                           class41.method577(class66.field785);
                        }

                        class12.method69(true);
                        class41.method577(var68?class66.field787:class66.field786);
                        class12.method69(false);
                        class33.method355();

                        for(GraphicsObject var78 = (GraphicsObject)Client.graphicsObjectDeque.getFront(); var78 != null; var78 = (GraphicsObject)Client.graphicsObjectDeque.getNext()) {
                           if(var78.level == class8.plane && !var78.finished) {
                              if(Client.gameCycle >= var78.startCycle) {
                                 var78.method1685(Client.field1078);
                                 if(var78.finished) {
                                    var78.unlink();
                                 } else {
                                    class51.region.method2711(var78.level, var78.x, var78.y, var78.height, 60, var78, 0, -1, false);
                                 }
                              }
                           } else {
                              var78.unlink();
                           }
                        }

                        Varcs.method1833(var12, var13, var21, var22, true);
                        var47 = Client.field1072;
                        var20 = Client.field1145;
                        var21 = Client.viewportHeight;
                        var22 = Client.viewportWidth;
                        Rasterizer2D.setDrawRegion(var47, var20, var47 + var21, var20 + var22);
                        Graphics3D.method2605();
                        if(!Client.field1130) {
                           var24 = Client.field977;
                           if(Client.field975 / 256 > var24) {
                              var24 = Client.field975 / 256;
                           }

                           if(Client.field1005[4] && Client.field1048[4] + 128 > var24) {
                              var24 = Client.field1048[4] + 128;
                           }

                           var49 = Client.mapAngle & 2047;
                           class10.method56(class169.field2313, class18.getTileHeight(class224.localPlayer.x, class224.localPlayer.y, class8.plane) - Client.field907, CacheFile.field1535, var24, var49, var24 * 3 + 600);
                        }

                        if(!Client.field1130) {
                           if(class170.preferences.hideRoofs) {
                              var49 = class8.plane;
                           } else {
                              label1892: {
                                 var26 = 3;
                                 if(Client.cameraPitch < 310) {
                                    var27 = class89.cameraX >> 7;
                                    var28 = KeyFocusListener.cameraY >> 7;
                                    var29 = class224.localPlayer.x >> 7;
                                    var30 = class224.localPlayer.y >> 7;
                                    if(var27 < 0 || var28 < 0 || var27 >= 104 || var28 >= 104) {
                                       var49 = class8.plane;
                                       break label1892;
                                    }

                                    if((class62.tileSettings[class8.plane][var27][var28] & 4) != 0) {
                                       var26 = class8.plane;
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

                                          if((class62.tileSettings[class8.plane][var27][var28] & 4) != 0) {
                                             var26 = class8.plane;
                                          }

                                          var34 += var33;
                                          if(var34 >= 65536) {
                                             var34 -= 65536;
                                             if(var28 < var30) {
                                                ++var28;
                                             } else if(var28 > var30) {
                                                --var28;
                                             }

                                             if((class62.tileSettings[class8.plane][var27][var28] & 4) != 0) {
                                                var26 = class8.plane;
                                             }
                                          }
                                       }
                                    } else {
                                       var33 = var31 * 65536 / var32;
                                       var34 = '耀';

                                       while(var30 != var28) {
                                          if(var28 < var30) {
                                             ++var28;
                                          } else if(var28 > var30) {
                                             --var28;
                                          }

                                          if((class62.tileSettings[class8.plane][var27][var28] & 4) != 0) {
                                             var26 = class8.plane;
                                          }

                                          var34 += var33;
                                          if(var34 >= 65536) {
                                             var34 -= 65536;
                                             if(var27 < var29) {
                                                ++var27;
                                             } else if(var27 > var29) {
                                                --var27;
                                             }

                                             if((class62.tileSettings[class8.plane][var27][var28] & 4) != 0) {
                                                var26 = class8.plane;
                                             }
                                          }
                                       }
                                    }
                                 }

                                 if(class224.localPlayer.x >= 0 && class224.localPlayer.y >= 0 && class224.localPlayer.x < 13312 && class224.localPlayer.y < 13312) {
                                    if((class62.tileSettings[class8.plane][class224.localPlayer.x >> 7][class224.localPlayer.y >> 7] & 4) != 0) {
                                       var26 = class8.plane;
                                    }

                                    var49 = var26;
                                 } else {
                                    var49 = class8.plane;
                                 }
                              }
                           }

                           var24 = var49;
                        } else {
                           if(class170.preferences.hideRoofs) {
                              var49 = class8.plane;
                           } else {
                              var26 = class18.getTileHeight(class89.cameraX, KeyFocusListener.cameraY, class8.plane);
                              if(var26 - WallObject.cameraZ < 800 && (class62.tileSettings[class8.plane][class89.cameraX >> 7][KeyFocusListener.cameraY >> 7] & 4) != 0) {
                                 var49 = class8.plane;
                              } else {
                                 var49 = 3;
                              }
                           }

                           var24 = var49;
                        }

                        var49 = class89.cameraX;
                        var26 = WallObject.cameraZ;
                        var27 = KeyFocusListener.cameraY;
                        var28 = Client.cameraPitch;
                        var29 = ScriptState.cameraYaw;

                        for(var30 = 0; var30 < 5; ++var30) {
                           if(Client.field1005[var30]) {
                              var31 = (int)(Math.random() * (double)(1 + Client.field1132[var30] * 2) - (double)Client.field1132[var30] + Math.sin((double)Client.field1053[var30] / 100.0D * (double)Client.field1093[var30]) * (double)Client.field1048[var30]);
                              if(var30 == 0) {
                                 class89.cameraX += var31;
                              }

                              if(var30 == 1) {
                                 WallObject.cameraZ += var31;
                              }

                              if(var30 == 2) {
                                 KeyFocusListener.cameraY += var31;
                              }

                              if(var30 == 3) {
                                 ScriptState.cameraYaw = var31 + ScriptState.cameraYaw & 2047;
                              }

                              if(var30 == 4) {
                                 Client.cameraPitch += var31;
                                 if(Client.cameraPitch < 128) {
                                    Client.cameraPitch = 128;
                                 }

                                 if(Client.cameraPitch > 383) {
                                    Client.cameraPitch = 383;
                                 }
                              }
                           }
                        }

                        var30 = MouseInput.field696;
                        var31 = MouseInput.field705;
                        if(MouseInput.field697 != 0) {
                           var30 = MouseInput.field709;
                           var31 = MouseInput.field713;
                        }

                        if(var30 >= var47 && var30 < var47 + var21 && var31 >= var20 && var31 < var22 + var20) {
                           class118.method2185(var30 - var47, var31 - var20);
                        } else {
                           class134.field1973 = false;
                           class134.field1970 = 0;
                        }

                        class134.method2601();
                        Rasterizer2D.method4937(var47, var20, var21, var22, 0);
                        class134.method2601();
                        var32 = Graphics3D.field1998;
                        Graphics3D.field1998 = Client.scale;
                        class51.region.draw(class89.cameraX, WallObject.cameraZ, KeyFocusListener.cameraY, Client.cameraPitch, ScriptState.cameraYaw, var24);
                        class168.method3160();
                        Graphics3D.field1998 = var32;
                        class134.method2601();
                        class51.region.clearEntities();
                        Client.field976 = 0;
                        boolean var72 = false;
                        var34 = -1;
                        var35 = class96.field1470;
                        int[] var36 = class96.field1468;

                        for(var37 = 0; var37 < var35 + Client.field932; ++var37) {
                           Object var38;
                           if(var37 < var35) {
                              var38 = Client.cachedPlayers[var36[var37]];
                              if(var36[var37] == Client.field927) {
                                 var72 = true;
                                 var34 = var37;
                                 continue;
                              }
                           } else {
                              var38 = Client.cachedNPCs[Client.npcIndices[var37 - var35]];
                           }

                           class98.method1837((Actor)var38, var37, var47, var20, var21, var22);
                        }

                        if(var72) {
                           class98.method1837(Client.cachedPlayers[Client.field927], var34, var47, var20, var21, var22);
                        }

                        for(var37 = 0; var37 < Client.field976; ++var37) {
                           var52 = Client.field978[var37];
                           var39 = Client.field979[var37];
                           var40 = Client.field981[var37];
                           var41 = Client.field903[var37];
                           boolean var74 = true;

                           while(var74) {
                              var74 = false;

                              for(var43 = 0; var43 < var37; ++var43) {
                                 if(var39 + 2 > Client.field979[var43] - Client.field903[var43] && var39 - var41 < Client.field979[var43] + 2 && var52 - var40 < Client.field978[var43] + Client.field981[var43] && var52 + var40 > Client.field978[var43] - Client.field981[var43] && Client.field979[var43] - Client.field903[var43] < var39) {
                                    var39 = Client.field979[var43] - Client.field903[var43];
                                    var74 = true;
                                 }
                              }
                           }

                           Client.screenY = Client.field978[var37];
                           Client.screenX = Client.field979[var37] = var39;
                           String var54 = Client.field985[var37];
                           if(Client.field1045 == 0) {
                              var44 = 16776960;
                              if(Client.field982[var37] < 6) {
                                 var44 = Client.field1099[Client.field982[var37]];
                              }

                              if(Client.field982[var37] == 6) {
                                 var44 = Client.field1038 % 20 < 10?16711680:16776960;
                              }

                              if(Client.field982[var37] == 7) {
                                 var44 = Client.field1038 % 20 < 10?255:'\uffff';
                              }

                              if(Client.field982[var37] == 8) {
                                 var44 = Client.field1038 % 20 < 10?'뀀':8454016;
                              }

                              if(Client.field982[var37] == 9) {
                                 var45 = 150 - Client.field984[var37];
                                 if(var45 < 50) {
                                    var44 = var45 * 1280 + 16711680;
                                 } else if(var45 < 100) {
                                    var44 = 16776960 - (var45 - 50) * 327680;
                                 } else if(var45 < 150) {
                                    var44 = (var45 - 100) * 5 + '\uff00';
                                 }
                              }

                              if(Client.field982[var37] == 10) {
                                 var45 = 150 - Client.field984[var37];
                                 if(var45 < 50) {
                                    var44 = 16711680 + var45 * 5;
                                 } else if(var45 < 100) {
                                    var44 = 16711935 - (var45 - 50) * 327680;
                                 } else if(var45 < 150) {
                                    var44 = (var45 - 100) * 327680 + 255 - (var45 - 100) * 5;
                                 }
                              }

                              if(Client.field982[var37] == 11) {
                                 var45 = 150 - Client.field984[var37];
                                 if(var45 < 50) {
                                    var44 = 16777215 - var45 * 327685;
                                 } else if(var45 < 100) {
                                    var44 = '\uff00' + (var45 - 50) * 327685;
                                 } else if(var45 < 150) {
                                    var44 = 16777215 - (var45 - 100) * 327680;
                                 }
                              }

                              if(Client.field983[var37] == 0) {
                                 class43.field544.method4742(var54, var47 + Client.screenY, var20 + Client.screenX, var44, 0);
                              }

                              if(Client.field983[var37] == 1) {
                                 class43.field544.method4744(var54, var47 + Client.screenY, var20 + Client.screenX, var44, 0, Client.field1038);
                              }

                              if(Client.field983[var37] == 2) {
                                 class43.field544.method4745(var54, var47 + Client.screenY, var20 + Client.screenX, var44, 0, Client.field1038);
                              }

                              if(Client.field983[var37] == 3) {
                                 class43.field544.method4737(var54, var47 + Client.screenY, var20 + Client.screenX, var44, 0, Client.field1038, 150 - Client.field984[var37]);
                              }

                              if(Client.field983[var37] == 4) {
                                 var45 = (150 - Client.field984[var37]) * (class43.field544.method4820(var54) + 100) / 150;
                                 Rasterizer2D.setInnerDrawRegion(var47 + Client.screenY - 50, var20, var47 + Client.screenY + 50, var20 + var22);
                                 class43.field544.method4751(var54, var47 + Client.screenY + 50 - var45, var20 + Client.screenX, var44, 0);
                                 Rasterizer2D.setDrawRegion(var47, var20, var21 + var47, var22 + var20);
                              }

                              if(Client.field983[var37] == 5) {
                                 var45 = 150 - Client.field984[var37];
                                 int var46 = 0;
                                 if(var45 < 25) {
                                    var46 = var45 - 25;
                                 } else if(var45 > 125) {
                                    var46 = var45 - 125;
                                 }

                                 Rasterizer2D.setInnerDrawRegion(var47, var20 + Client.screenX - class43.field544.verticalSpace - 1, var47 + var21, var20 + Client.screenX + 5);
                                 class43.field544.method4742(var54, var47 + Client.screenY, var46 + var20 + Client.screenX, var44, 0);
                                 Rasterizer2D.setDrawRegion(var47, var20, var21 + var47, var22 + var20);
                              }
                           } else {
                              class43.field544.method4742(var54, var47 + Client.screenY, var20 + Client.screenX, 16776960, 0);
                           }
                        }

                        Widget.method4050(var47, var20);
                        ((TextureProvider)Graphics3D.textureLoader).method2399(Client.field1078);
                        if(Client.cursorState == 1) {
                           ScriptState.field724[Client.field1134 / 100].method5069(Client.field1056 - 8, Client.field1084 - 8);
                        }

                        if(Client.cursorState == 2) {
                           ScriptState.field724[Client.field1134 / 100 + 4].method5069(Client.field1056 - 8, Client.field1084 - 8);
                        }

                        DState.method3183();
                        class89.cameraX = var49;
                        WallObject.cameraZ = var26;
                        KeyFocusListener.cameraY = var27;
                        Client.cameraPitch = var28;
                        ScriptState.cameraYaw = var29;
                        if(Client.field900) {
                           byte var73 = 0;
                           var34 = var73 + class238.field3234 + class238.field3238;
                           if(var34 == 0) {
                              Client.field900 = false;
                           }
                        }

                        if(Client.field900) {
                           Rasterizer2D.method4937(var47, var20, var21, var22, 0);
                           ScriptVarType.drawStatusBox("Loading - please wait.", false);
                        }

                        Client.field1088[var10.boundsIndex] = true;
                        Rasterizer2D.setDrawRegion(var2, var3, var4, var5);
                        continue;
                     }

                     class210 var61;
                     if(var10.contentType == 1338) {
                        class134.method2601();
                        var61 = var10.method4012(false);
                        if(var61 != null) {
                           Rasterizer2D.setDrawRegion(var12, var13, var12 + var61.field2580, var13 + var61.field2581);
                           if(Client.field1118 != 2 && Client.field1118 != 5) {
                              var20 = Client.mapAngle & 2047;
                              var21 = class224.localPlayer.x / 32 + 48;
                              var22 = 464 - class224.localPlayer.y / 32;
                              KeyFocusListener.field619.method5080(var12, var13, var61.field2580, var61.field2581, var21, var22, var20, 256, var61.field2578, var61.field2579);

                              for(var23 = 0; var23 < Client.field1112; ++var23) {
                                 var24 = Client.field1113[var23] * 4 + 2 - class224.localPlayer.x / 32;
                                 var49 = Client.field1114[var23] * 4 + 2 - class224.localPlayer.y / 32;
                                 class35.drawDot(var12, var13, var24, var49, Client.field1127[var23], var61);
                              }

                              var23 = 0;

                              while(true) {
                                 if(var23 >= 104) {
                                    for(var23 = 0; var23 < Client.field932; ++var23) {
                                       NPC var76 = Client.cachedNPCs[Client.npcIndices[var23]];
                                       if(var76 != null && var76.hasConfig()) {
                                          NPCComposition var63 = var76.composition;
                                          if(var63 != null && var63.configs != null) {
                                             var63 = var63.transform();
                                          }

                                          if(var63 != null && var63.isMinimapVisible && var63.field3542) {
                                             var26 = var76.x / 32 - class224.localPlayer.x / 32;
                                             var27 = var76.y / 32 - class224.localPlayer.y / 32;
                                             class35.drawDot(var12, var13, var26, var27, TextureProvider.mapDots[1], var61);
                                          }
                                       }
                                    }

                                    var23 = class96.field1470;
                                    int[] var77 = class96.field1468;

                                    for(var49 = 0; var49 < var23; ++var49) {
                                       Player var53 = Client.cachedPlayers[var77[var49]];
                                       if(var53 != null && var53.hasConfig() && !var53.hidden && var53 != class224.localPlayer) {
                                          var27 = var53.x / 32 - class224.localPlayer.x / 32;
                                          var28 = var53.y / 32 - class224.localPlayer.y / 32;
                                          boolean var70 = false;
                                          if(class31.isFriended(var53.name, true)) {
                                             var70 = true;
                                          }

                                          boolean var69 = false;

                                          for(var31 = 0; var31 < class21.clanChatCount; ++var31) {
                                             if(var53.name.equals(class37.clanMembers[var31].username)) {
                                                var69 = true;
                                                break;
                                             }
                                          }

                                          boolean var71 = false;
                                          if(class224.localPlayer.team != 0 && var53.team != 0 && var53.team == class224.localPlayer.team) {
                                             var71 = true;
                                          }

                                          if(var70) {
                                             class35.drawDot(var12, var13, var27, var28, TextureProvider.mapDots[3], var61);
                                          } else if(var71) {
                                             class35.drawDot(var12, var13, var27, var28, TextureProvider.mapDots[4], var61);
                                          } else if(var69) {
                                             class35.drawDot(var12, var13, var27, var28, TextureProvider.mapDots[5], var61);
                                          } else {
                                             class35.drawDot(var12, var13, var27, var28, TextureProvider.mapDots[2], var61);
                                          }
                                       }
                                    }

                                    if(Client.field1115 != 0 && Client.gameCycle % 20 < 10) {
                                       if(Client.field1115 == 1 && Client.field910 >= 0 && Client.field910 < Client.cachedNPCs.length) {
                                          NPC var64 = Client.cachedNPCs[Client.field910];
                                          if(var64 != null) {
                                             var26 = var64.x / 32 - class224.localPlayer.x / 32;
                                             var27 = var64.y / 32 - class224.localPlayer.y / 32;
                                             class89.method1717(var12, var13, var26, var27, class51.field627[1], var61);
                                          }
                                       }

                                       if(Client.field1115 == 2) {
                                          var49 = 2 + (Client.hintArrowX * 4 - class33.baseX * 4) - class224.localPlayer.x / 32;
                                          var26 = 2 + (Client.hintArrowY * 4 - class17.baseY * 4) - class224.localPlayer.y / 32;
                                          class89.method1717(var12, var13, var49, var26, class51.field627[1], var61);
                                       }

                                       if(Client.field1115 == 10 && Client.field911 >= 0 && Client.field911 < Client.cachedPlayers.length) {
                                          Player var65 = Client.cachedPlayers[Client.field911];
                                          if(var65 != null) {
                                             var26 = var65.x / 32 - class224.localPlayer.x / 32;
                                             var27 = var65.y / 32 - class224.localPlayer.y / 32;
                                             class89.method1717(var12, var13, var26, var27, class51.field627[1], var61);
                                          }
                                       }
                                    }

                                    if(Client.destinationX != 0) {
                                       var49 = Client.destinationX * 4 + 2 - class224.localPlayer.x / 32;
                                       var26 = Client.destinationY * 4 + 2 - class224.localPlayer.y / 32;
                                       class35.drawDot(var12, var13, var49, var26, class51.field627[0], var61);
                                    }

                                    if(!class224.localPlayer.hidden) {
                                       Rasterizer2D.method4937(var12 + var61.field2580 / 2 - 1, var13 + var61.field2581 / 2 - 1, 3, 3, 16777215);
                                    }
                                    break;
                                 }

                                 for(var24 = 0; var24 < 104; ++var24) {
                                    Deque var25 = Client.groundItemDeque[class8.plane][var23][var24];
                                    if(var25 != null) {
                                       var26 = var23 * 4 + 2 - class224.localPlayer.x / 32;
                                       var27 = var24 * 4 + 2 - class224.localPlayer.y / 32;
                                       class35.drawDot(var12, var13, var26, var27, TextureProvider.mapDots[0], var61);
                                    }
                                 }

                                 ++var23;
                              }
                           } else {
                              Rasterizer2D.method4952(var12, var13, 0, var61.field2578, var61.field2579);
                           }

                           Client.field971[var11] = true;
                        }

                        Rasterizer2D.setDrawRegion(var2, var3, var4, var5);
                        continue;
                     }

                     if(var10.contentType == 1339) {
                        var61 = var10.method4012(false);
                        if(var61 != null) {
                           if(Client.field1118 < 3) {
                              FrameMap.compass.method5080(var12, var13, var61.field2580, var61.field2581, 25, 25, Client.mapAngle, 256, var61.field2578, var61.field2579);
                           } else {
                              Rasterizer2D.method4952(var12, var13, 0, var61.field2578, var61.field2579);
                           }
                        }

                        Rasterizer2D.setDrawRegion(var2, var3, var4, var5);
                        continue;
                     }

                     if(var10.contentType == 1400) {
                        class7.renderOverview.extractWorldmap(var12, var13, var10.width, var10.height, Client.gameCycle);
                     }

                     if(var10.contentType == 1401) {
                        class7.renderOverview.extractData(var12, var13, var10.width, var10.height);
                     }
                  }

                  if(var10.type == 0) {
                     if(!var10.hasScript && class177.method3423(var10) && var10 != class244.field3302) {
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
                        class2.drawWidget(var19.id, var15, var16, var17, var18, var12, var13, var11);
                     }

                     Rasterizer2D.setDrawRegion(var2, var3, var4, var5);
                     Graphics3D.method2605();
                  }

                  if(Client.isResized || Client.field1090[var11] || Client.gameDrawingMode > 1) {
                     if(var10.type == 0 && !var10.hasScript && var10.scrollHeight > var10.height) {
                        var47 = var12 + var10.width;
                        var20 = var10.scrollY;
                        var21 = var10.height;
                        var22 = var10.scrollHeight;
                        FloorUnderlayDefinition.field3327[0].method5034(var47, var13);
                        FloorUnderlayDefinition.field3327[1].method5034(var47, var21 + var13 - 16);
                        Rasterizer2D.method4937(var47, var13 + 16, 16, var21 - 32, Client.field959);
                        var23 = var21 * (var21 - 32) / var22;
                        if(var23 < 8) {
                           var23 = 8;
                        }

                        var24 = var20 * (var21 - 32 - var23) / (var22 - var21);
                        Rasterizer2D.method4937(var47, var24 + var13 + 16, 16, var23, Client.field909);
                        Rasterizer2D.method4948(var47, var24 + var13 + 16, var23, Client.field962);
                        Rasterizer2D.method4948(var47 + 1, var24 + var13 + 16, var23, Client.field962);
                        Rasterizer2D.method5003(var47, var13 + var24 + 16, 16, Client.field962);
                        Rasterizer2D.method5003(var47, var24 + var13 + 17, 16, Client.field962);
                        Rasterizer2D.method4948(var47 + 15, var24 + var13 + 16, var23, Client.field961);
                        Rasterizer2D.method4948(var47 + 14, var13 + var24 + 17, var23 - 1, Client.field961);
                        Rasterizer2D.method5003(var47, var24 + var13 + var23 + 15, 16, Client.field961);
                        Rasterizer2D.method5003(var47 + 1, var24 + var13 + var23 + 14, 15, Client.field961);
                     }

                     if(var10.type != 1) {
                        if(var10.type == 2) {
                           var47 = 0;

                           for(var20 = 0; var20 < var10.field2641; ++var20) {
                              for(var21 = 0; var21 < var10.originalWidth; ++var21) {
                                 var22 = (var10.paddingX + 32) * var21 + var12;
                                 var23 = var13 + (var10.paddingY + 32) * var20;
                                 if(var47 < 20) {
                                    var22 += var10.xSprites[var47];
                                    var23 += var10.field2698[var47];
                                 }

                                 if(var10.itemIds[var47] <= 0) {
                                    if(var10.field2724 != null && var47 < 20) {
                                       SpritePixels var75 = var10.method4022(var47);
                                       if(var75 != null) {
                                          var75.method5069(var22, var23);
                                       } else if(Widget.field2627) {
                                          class48.method732(var10);
                                       }
                                    }
                                 } else {
                                    boolean var67 = false;
                                    boolean var80 = false;
                                    var26 = var10.itemIds[var47] - 1;
                                    if(var22 + 32 > var2 && var22 < var4 && var23 + 32 > var3 && var23 < var5 || var10 == class18.field307 && var47 == Client.field996) {
                                       SpritePixels var50;
                                       if(Client.itemSelectionState == 1 && var47 == class35.selectedItemIndex && var10.id == class44.field548) {
                                          var50 = class46.createSprite(var26, var10.itemQuantities[var47], 2, 0, 2, false);
                                       } else {
                                          var50 = class46.createSprite(var26, var10.itemQuantities[var47], 1, 3153952, 2, false);
                                       }

                                       if(var50 != null) {
                                          if(var10 == class18.field307 && var47 == Client.field996) {
                                             var24 = MouseInput.field696 - Client.field997;
                                             var49 = MouseInput.field705 - Client.field998;
                                             if(var24 < 5 && var24 > -5) {
                                                var24 = 0;
                                             }

                                             if(var49 < 5 && var49 > -5) {
                                                var49 = 0;
                                             }

                                             if(Client.field1047 < 5) {
                                                var24 = 0;
                                                var49 = 0;
                                             }

                                             var50.method5137(var24 + var22, var49 + var23, 128);
                                             if(var1 != -1) {
                                                Widget var51 = var0[var1 & '\uffff'];
                                                if(var23 + var49 < Rasterizer2D.drawingAreaTop && var51.scrollY > 0) {
                                                   var29 = (Rasterizer2D.drawingAreaTop - var23 - var49) * Client.field1078 / 3;
                                                   if(var29 > Client.field1078 * 10) {
                                                      var29 = Client.field1078 * 10;
                                                   }

                                                   if(var29 > var51.scrollY) {
                                                      var29 = var51.scrollY;
                                                   }

                                                   var51.scrollY -= var29;
                                                   Client.field998 += var29;
                                                   class48.method732(var51);
                                                }

                                                if(var23 + var49 + 32 > Rasterizer2D.drawingAreaRight && var51.scrollY < var51.scrollHeight - var51.height) {
                                                   var29 = (var49 + var23 + 32 - Rasterizer2D.drawingAreaRight) * Client.field1078 / 3;
                                                   if(var29 > Client.field1078 * 10) {
                                                      var29 = Client.field1078 * 10;
                                                   }

                                                   if(var29 > var51.scrollHeight - var51.height - var51.scrollY) {
                                                      var29 = var51.scrollHeight - var51.height - var51.scrollY;
                                                   }

                                                   var51.scrollY += var29;
                                                   Client.field998 -= var29;
                                                   class48.method732(var51);
                                                }
                                             }
                                          } else if(var10 == class27.field374 && var47 == Client.field995) {
                                             var50.method5137(var22, var23, 128);
                                          } else {
                                             var50.method5069(var22, var23);
                                          }
                                       } else {
                                          class48.method732(var10);
                                       }
                                    }
                                 }

                                 ++var47;
                              }
                           }
                        } else if(var10.type == 3) {
                           if(World.method1597(var10)) {
                              var47 = var10.field2655;
                              if(var10 == class244.field3302 && var10.field2657 != 0) {
                                 var47 = var10.field2657;
                              }
                           } else {
                              var47 = var10.textColor;
                              if(var10 == class244.field3302 && var10.field2656 != 0) {
                                 var47 = var10.field2656;
                              }
                           }

                           if(var10.field2658) {
                              switch(var10.field2703.field3753) {
                              case 1:
                                 Rasterizer2D.method4938(var12, var13, var10.width, var10.height, var10.textColor, var10.field2655, 256 - (var10.opacity & 255), 256 - (var10.field2661 & 255));
                                 break;
                              case 2:
                                 Rasterizer2D.method4939(var12, var13, var10.width, var10.height, var10.textColor, var10.field2655, 256 - (var10.opacity & 255), 256 - (var10.field2661 & 255));
                                 break;
                              case 3:
                                 Rasterizer2D.method4940(var12, var13, var10.width, var10.height, var10.textColor, var10.field2655, 256 - (var10.opacity & 255), 256 - (var10.field2661 & 255));
                                 break;
                              case 4:
                                 Rasterizer2D.method4979(var12, var13, var10.width, var10.height, var10.textColor, var10.field2655, 256 - (var10.opacity & 255), 256 - (var10.field2661 & 255));
                                 break;
                              default:
                                 if(var14 == 0) {
                                    Rasterizer2D.method4937(var12, var13, var10.width, var10.height, var47);
                                 } else {
                                    Rasterizer2D.fillRectangle(var12, var13, var10.width, var10.height, var47, 256 - (var14 & 255));
                                 }
                              }
                           } else if(var14 == 0) {
                              Rasterizer2D.drawRectangle(var12, var13, var10.width, var10.height, var47);
                           } else {
                              Rasterizer2D.method4945(var12, var13, var10.width, var10.height, var47, 256 - (var14 & 255));
                           }
                        } else {
                           Font var59;
                           if(var10.type == 4) {
                              var59 = var10.method4009();
                              if(var59 == null) {
                                 if(Widget.field2627) {
                                    class48.method732(var10);
                                 }
                              } else {
                                 String var83 = var10.text;
                                 if(World.method1597(var10)) {
                                    var20 = var10.field2655;
                                    if(var10 == class244.field3302 && var10.field2657 != 0) {
                                       var20 = var10.field2657;
                                    }

                                    if(var10.field2619.length() > 0) {
                                       var83 = var10.field2619;
                                    }
                                 } else {
                                    var20 = var10.textColor;
                                    if(var10 == class244.field3302 && var10.field2656 != 0) {
                                       var20 = var10.field2656;
                                    }
                                 }

                                 if(var10.hasScript && var10.itemId != -1) {
                                    ItemComposition var84 = Friend.getItemDefinition(var10.itemId);
                                    var83 = var84.name;
                                    if(var83 == null) {
                                       var83 = "null";
                                    }

                                    if((var84.isStackable == 1 || var10.itemQuantity != 1) && var10.itemQuantity != -1) {
                                       var83 = CacheFile.getColTags(16748608) + var83 + "</col>" + " " + 'x' + class5.method14(var10.itemQuantity);
                                    }
                                 }

                                 if(var10 == Client.field895) {
                                    Object var10000 = null;
                                    var83 = "Please wait...";
                                    var20 = var10.textColor;
                                 }

                                 if(!var10.hasScript) {
                                    var83 = FrameMap.method2697(var83, var10);
                                 }

                                 var59.method4833(var83, var12, var13, var10.width, var10.height, var20, var10.textShadowed?0:-1, var10.field2692, var10.field2687, var10.field2691);
                              }
                           } else if(var10.type == 5) {
                              SpritePixels var60;
                              if(!var10.hasScript) {
                                 var60 = var10.method4031(World.method1597(var10));
                                 if(var60 != null) {
                                    var60.method5069(var12, var13);
                                 } else if(Widget.field2627) {
                                    class48.method732(var10);
                                 }
                              } else {
                                 if(var10.itemId != -1) {
                                    var60 = class46.createSprite(var10.itemId, var10.itemQuantity, var10.borderThickness, var10.sprite2, var10.field2744, false);
                                 } else {
                                    var60 = var10.method4031(false);
                                 }

                                 if(var60 == null) {
                                    if(Widget.field2627) {
                                       class48.method732(var10);
                                    }
                                 } else {
                                    var20 = var60.maxWidth;
                                    var21 = var60.maxHeight;
                                    if(!var10.field2733) {
                                       var22 = var10.width * 4096 / var20;
                                       if(var10.textureId != 0) {
                                          var60.method5082(var12 + var10.width / 2, var13 + var10.height / 2, var10.textureId, var22);
                                       } else if(var14 != 0) {
                                          var60.method5105(var12, var13, var10.width, var10.height, 256 - (var14 & 255));
                                       } else if(var20 == var10.width && var21 == var10.height) {
                                          var60.method5069(var12, var13);
                                       } else {
                                          var60.method5071(var12, var13, var10.width, var10.height);
                                       }
                                    } else {
                                       Rasterizer2D.setInnerDrawRegion(var12, var13, var12 + var10.width, var13 + var10.height);
                                       var22 = (var20 - 1 + var10.width) / var20;
                                       var23 = (var21 - 1 + var10.height) / var21;

                                       for(var24 = 0; var24 < var22; ++var24) {
                                          for(var49 = 0; var49 < var23; ++var49) {
                                             if(var10.textureId != 0) {
                                                var60.method5082(var12 + var24 * var20 + var20 / 2, var13 + var49 * var21 + var21 / 2, var10.textureId, 4096);
                                             } else if(var14 != 0) {
                                                var60.method5137(var12 + var24 * var20, var13 + var49 * var21, 256 - (var14 & 255));
                                             } else {
                                                var60.method5069(var24 * var20 + var12, var13 + var21 * var49);
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
                                 boolean var79 = World.method1597(var10);
                                 if(var79) {
                                    var20 = var10.field2734;
                                 } else {
                                    var20 = var10.field2676;
                                 }

                                 Model var81 = null;
                                 var22 = 0;
                                 if(var10.itemId != -1) {
                                    var57 = Friend.getItemDefinition(var10.itemId);
                                    if(var57 != null) {
                                       var57 = var57.method4571(var10.itemQuantity);
                                       var81 = var57.getModel(1);
                                       if(var81 != null) {
                                          var81.method2509();
                                          var22 = var81.modelHeight / 2;
                                       } else {
                                          class48.method732(var10);
                                       }
                                    }
                                 } else if(var10.modelType == 5) {
                                    if(var10.modelId == 0) {
                                       var81 = Client.field1155.method3963((Sequence)null, -1, (Sequence)null, -1);
                                    } else {
                                       var81 = class224.localPlayer.getModel();
                                    }
                                 } else if(var20 == -1) {
                                    var81 = var10.method4011((Sequence)null, -1, var79, class224.localPlayer.composition);
                                    if(var81 == null && Widget.field2627) {
                                       class48.method732(var10);
                                    }
                                 } else {
                                    Sequence var85 = class40.getAnimation(var20);
                                    var81 = var10.method4011(var85, var10.field2751, var79, class224.localPlayer.composition);
                                    if(var81 == null && Widget.field2627) {
                                       class48.method732(var10);
                                    }
                                 }

                                 Graphics3D.method2686(var12 + var10.width / 2, var13 + var10.height / 2);
                                 var23 = Graphics3D.SINE[var10.rotationX] * var10.modelZoom >> 16;
                                 var24 = Graphics3D.COSINE[var10.rotationX] * var10.modelZoom >> 16;
                                 if(var81 != null) {
                                    if(!var10.hasScript) {
                                       var81.method2522(0, var10.rotationZ, 0, var10.rotationX, 0, var23, var24);
                                    } else {
                                       var81.method2509();
                                       if(var10.field2686) {
                                          var81.method2523(0, var10.rotationZ, var10.rotationY, var10.rotationX, var10.field2678, var22 + var23 + var10.field2693, var24 + var10.field2693, var10.modelZoom);
                                       } else {
                                          var81.method2522(0, var10.rotationZ, var10.rotationY, var10.rotationX, var10.field2678, var23 + var22 + var10.field2693, var24 + var10.field2693);
                                       }
                                    }
                                 }

                                 Graphics3D.method2607();
                              } else {
                                 if(var10.type == 7) {
                                    var59 = var10.method4009();
                                    if(var59 == null) {
                                       if(Widget.field2627) {
                                          class48.method732(var10);
                                       }
                                       continue;
                                    }

                                    var20 = 0;

                                    for(var21 = 0; var21 < var10.field2641; ++var21) {
                                       for(var22 = 0; var22 < var10.originalWidth; ++var22) {
                                          if(var10.itemIds[var20] > 0) {
                                             var57 = Friend.getItemDefinition(var10.itemIds[var20] - 1);
                                             String var48;
                                             if(var57.isStackable != 1 && var10.itemQuantities[var20] == 1) {
                                                var48 = CacheFile.getColTags(16748608) + var57.name + "</col>";
                                             } else {
                                                var48 = CacheFile.getColTags(16748608) + var57.name + "</col>" + " " + 'x' + class5.method14(var10.itemQuantities[var20]);
                                             }

                                             var49 = var22 * (var10.paddingX + 115) + var12;
                                             var26 = var13 + (var10.paddingY + 12) * var21;
                                             if(var10.field2692 == 0) {
                                                var59.method4751(var48, var49, var26, var10.textColor, var10.textShadowed?0:-1);
                                             } else if(var10.field2692 == 1) {
                                                var59.method4742(var48, var49 + var10.width / 2, var26, var10.textColor, var10.textShadowed?0:-1);
                                             } else {
                                                var59.method4741(var48, var49 + var10.width - 1, var26, var10.textColor, var10.textShadowed?0:-1);
                                             }
                                          }

                                          ++var20;
                                       }
                                    }
                                 }

                                 if(var10.type == 8 && var10 == class89.field1372 && Client.field1035 == Client.field1087) {
                                    var47 = 0;
                                    var20 = 0;
                                    Font var55 = class18.font_p12full;
                                    String var56 = var10.text;

                                    String var82;
                                    for(var56 = FrameMap.method2697(var56, var10); var56.length() > 0; var20 = var20 + var55.verticalSpace + 1) {
                                       var24 = var56.indexOf("<br>");
                                       if(var24 != -1) {
                                          var82 = var56.substring(0, var24);
                                          var56 = var56.substring(var24 + 4);
                                       } else {
                                          var82 = var56;
                                          var56 = "";
                                       }

                                       var49 = var55.method4820(var82);
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

                                    if(var49 + var20 > var5) {
                                       var49 = var5 - var20;
                                    }

                                    Rasterizer2D.method4937(var24, var49, var47, var20, 16777120);
                                    Rasterizer2D.drawRectangle(var24, var49, var47, var20, 0);
                                    var56 = var10.text;
                                    var26 = var49 + var55.verticalSpace + 2;

                                    for(var56 = FrameMap.method2697(var56, var10); var56.length() > 0; var26 = var26 + var55.verticalSpace + 1) {
                                       var27 = var56.indexOf("<br>");
                                       if(var27 != -1) {
                                          var82 = var56.substring(0, var27);
                                          var56 = var56.substring(var27 + 4);
                                       } else {
                                          var82 = var56;
                                          var56 = "";
                                       }

                                       var55.method4751(var82, var24 + 3, var26, 0, -1);
                                    }
                                 }

                                 if(var10.type == 9) {
                                    if(var10.field2663) {
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

                                    if(var10.field2662 == 1) {
                                       Rasterizer2D.drawLine(var47, var20, var21, var22, var10.textColor);
                                    } else {
                                       var49 = var10.textColor;
                                       var26 = var10.field2662;
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

                                          var34 = var33 * var26 >> 17;
                                          var35 = var26 * var33 + 1 >> 17;
                                          int var58 = var32 * var26 >> 17;
                                          var37 = var26 * var32 + 1 >> 17;
                                          var23 = var47 - Rasterizer2D.draw_region_x;
                                          var24 = var20 - Rasterizer2D.drawingAreaTop;
                                          var52 = var23 + var34;
                                          var39 = var23 - var35;
                                          var40 = var23 + var27 - var35;
                                          var41 = var34 + var27 + var23;
                                          int var42 = var58 + var24;
                                          var43 = var24 - var37;
                                          var44 = var28 + var24 - var37;
                                          var45 = var24 + var28 + var58;
                                          Graphics3D.setRasterClippingEnabled(var52, var39, var40);
                                          Graphics3D.rasterFlat(var42, var43, var44, var52, var39, var40, var49);
                                          Graphics3D.setRasterClippingEnabled(var52, var40, var41);
                                          Graphics3D.rasterFlat(var42, var44, var45, var52, var40, var41, var49);
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

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "([BIIB)Z",
      garbageValue = "40"
   )
   static final boolean method3999(byte[] var0, int var1, int var2) {
      boolean var3 = true;
      Buffer var4 = new Buffer(var0);
      int var5 = -1;

      label68:
      while(true) {
         int var6 = var4.getUSmart();
         if(var6 == 0) {
            return var3;
         }

         var5 += var6;
         int var7 = 0;
         boolean var8 = false;

         while(true) {
            int var9;
            while(!var8) {
               var9 = var4.getUSmart();
               if(var9 == 0) {
                  continue label68;
               }

               var7 += var9 - 1;
               int var10 = var7 & 63;
               int var11 = var7 >> 6 & 63;
               int var12 = var4.readUnsignedByte() >> 2;
               int var13 = var11 + var1;
               int var14 = var10 + var2;
               if(var13 > 0 && var14 > 0 && var13 < 103 && var14 < 103) {
                  ObjectComposition var15 = WidgetNode.getObjectDefinition(var5);
                  if(var12 != 22 || !Client.lowMemory || var15.field3463 != 0 || var15.interactType == 1 || var15.field3442) {
                     if(!var15.method4497()) {
                        ++Client.field951;
                        var3 = false;
                     }

                     var8 = true;
                  }
               }
            }

            var9 = var4.getUSmart();
            if(var9 == 0) {
               break;
            }

            var4.readUnsignedByte();
         }
      }
   }
}
