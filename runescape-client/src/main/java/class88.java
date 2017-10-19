import java.math.BigInteger;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cu")
public class class88 {
   @ObfuscatedName("w")
   @Export("rsaKeyExponent")
   static final BigInteger rsaKeyExponent;
   @ObfuscatedName("s")
   @Export("rsaKeyModulus")
   static final BigInteger rsaKeyModulus;
   @ObfuscatedName("gc")
   @ObfuscatedSignature(
      signature = "[Ljo;"
   )
   static IndexedSprite[] field1401;

   static {
      rsaKeyExponent = new BigInteger("10001", 16);
      rsaKeyModulus = new BigInteger("d68b271f08925873eb7d6d664c91074c21f7e8af4f50bb761ec861cd3418f8fb86a45c28c78a998645a4e938e876df2951747ccff67978e7c04d73513ed6556971b648ee8ddd3291ebfd8293c27d29e19957af4cef7763dafca00649a228cdf72f14c0c777acbe402d07c00ca9024c2f789c35c3f7e5b330f80e965deeaab06d", 16);
   }

   @ObfuscatedName("ih")
   @ObfuscatedSignature(
      signature = "([Lhj;IIIIIIIIB)V",
      garbageValue = "9"
   )
   @Export("gameDraw")
   static final void gameDraw(Widget[] var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
      Rasterizer2D.setDrawRegion(var2, var3, var4, var5);
      Graphics3D.method2676();

      label1209:
      for(int var9 = 0; var9 < var0.length; ++var9) {
         Widget var10 = var0[var9];
         if(var10 != null && (var10.parentId == var1 || var1 == -1412584499 && var10 == Client.field1158)) {
            int var11;
            if(var8 == -1) {
               Client.widgetPositionX[Client.field1117] = var10.relativeX + var6;
               Client.widgetPositionY[Client.field1117] = var7 + var10.relativeY;
               Client.widgetBoundsWidth[Client.field1117] = var10.width;
               Client.widgetBoundsHeight[Client.field1117] = var10.height;
               var11 = ++Client.field1117 - 1;
            } else {
               var11 = var8;
            }

            var10.boundsIndex = var11;
            var10.loopCycle = Client.gameCycle;
            if(!var10.hasScript || !ScriptEvent.method1097(var10)) {
               if(var10.contentType > 0) {
                  FileOnDisk.method2403(var10);
               }

               int var12 = var10.relativeX + var6;
               int var13 = var7 + var10.relativeY;
               int var14 = var10.opacity;
               int var15;
               int var16;
               if(var10 == Client.field1158) {
                  if(var1 != -1412584499 && !var10.field2720) {
                     class64.field807 = var0;
                     class43.field593 = var6;
                     Friend.field825 = var7;
                     continue;
                  }

                  if(Client.field1090 && Client.field1183) {
                     var15 = MouseInput.field756;
                     var16 = MouseInput.field741;
                     var15 -= Client.field1089;
                     var16 -= Client.field1168;
                     if(var15 < Client.field1093) {
                        var15 = Client.field1093;
                     }

                     if(var15 + var10.width > Client.field1093 + Client.field960.width) {
                        var15 = Client.field1093 + Client.field960.width - var10.width;
                     }

                     if(var16 < Client.field1094) {
                        var16 = Client.field1094;
                     }

                     if(var16 + var10.height > Client.field1094 + Client.field960.height) {
                        var16 = Client.field1094 + Client.field960.height - var10.height;
                     }

                     var12 = var15;
                     var13 = var16;
                  }

                  if(!var10.field2720) {
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
                  int var29;
                  int var48;
                  if(var10.contentType != 0) {
                     if(var10.contentType == 1336) {
                        if(Client.displayFps) {
                           var13 += 15;
                           class9.font_p12full.method4844("Fps:" + GameEngine.FPS, var12 + var10.width, var13, 16776960, -1);
                           var13 += 15;
                           Runtime var58 = Runtime.getRuntime();
                           var20 = (int)((var58.totalMemory() - var58.freeMemory()) / 1024L);
                           var21 = 16776960;
                           if(var20 > 32768 && Client.lowMemory) {
                              var21 = 16711680;
                           }

                           if(var20 > 65536 && !Client.lowMemory) {
                              var21 = 16711680;
                           }

                           class9.font_p12full.method4844("Mem:" + var20 + "k", var12 + var10.width, var13, var21, -1);
                           var13 += 15;
                        }
                        continue;
                     }

                     if(var10.contentType == 1337) {
                        Client.field1063 = var12;
                        Client.field1064 = var13;
                        var21 = var10.width;
                        var22 = var10.height;
                        ++Client.field1018;
                        Ignore.method1100();
                        class44.method621();
                        WidgetNode.method1088();
                        CombatInfoListHolder.method1689(true);
                        var23 = class94.playerIndexesCount;
                        int[] var64 = class94.playerIndices;

                        for(var25 = 0; var25 < var23; ++var25) {
                           if(var64[var25] != Client.field1043 && var64[var25] != Client.localInteractingIndex) {
                              class29.method249(Client.cachedPlayers[var64[var25]], true);
                           }
                        }

                        CombatInfoListHolder.method1689(false);
                        class261.method4815();
                        class15.method96();
                        class3.method6(var12, var13, var21, var22, true);
                        var46 = Client.field923;
                        var20 = Client.field1175;
                        var21 = Client.viewportHeight;
                        var22 = Client.viewportWidth;
                        Rasterizer2D.setDrawRegion(var46, var20, var21 + var46, var22 + var20);
                        Graphics3D.method2676();
                        if(!Client.field1160) {
                           var23 = Client.field997;
                           if(Client.field958 / 256 > var23) {
                              var23 = Client.field958 / 256;
                           }

                           if(Client.field1029[4] && Client.field1163[4] + 128 > var23) {
                              var23 = Client.field1163[4] + 128;
                           }

                           var24 = Client.mapAngle & 2047;
                           class238.method4334(Occluder.field2148, class41.getTileHeight(class66.localPlayer.x, class66.localPlayer.y, class46.plane) - Client.field1069, class181.field2432, var23, var24, var23 * 3 + 600);
                        }

                        if(!Client.field1160) {
                           var23 = class56.method812();
                        } else {
                           if(class70.preferences.hideRoofs) {
                              var24 = class46.plane;
                           } else {
                              var25 = class41.getTileHeight(AbstractByteBuffer.cameraX, World.cameraY, class46.plane);
                              if(var25 - class229.cameraZ < 800 && (class61.tileSettings[class46.plane][AbstractByteBuffer.cameraX >> 7][World.cameraY >> 7] & 4) != 0) {
                                 var24 = class46.plane;
                              } else {
                                 var24 = 3;
                              }
                           }

                           var23 = var24;
                        }

                        var24 = AbstractByteBuffer.cameraX;
                        var25 = class229.cameraZ;
                        var26 = World.cameraY;
                        var48 = class18.cameraPitch;
                        int var49 = CombatInfo1.cameraYaw;

                        int var30;
                        for(var29 = 0; var29 < 5; ++var29) {
                           if(Client.field1029[var29]) {
                              var30 = (int)(Math.random() * (double)(Client.field1162[var29] * 2 + 1) - (double)Client.field1162[var29] + Math.sin((double)Client.field1165[var29] * ((double)Client.field935[var29] / 100.0D)) * (double)Client.field1163[var29]);
                              if(var29 == 0) {
                                 AbstractByteBuffer.cameraX += var30;
                              }

                              if(var29 == 1) {
                                 class229.cameraZ += var30;
                              }

                              if(var29 == 2) {
                                 World.cameraY += var30;
                              }

                              if(var29 == 3) {
                                 CombatInfo1.cameraYaw = var30 + CombatInfo1.cameraYaw & 2047;
                              }

                              if(var29 == 4) {
                                 class18.cameraPitch += var30;
                                 if(class18.cameraPitch < 128) {
                                    class18.cameraPitch = 128;
                                 }

                                 if(class18.cameraPitch > 383) {
                                    class18.cameraPitch = 383;
                                 }
                              }
                           }
                        }

                        var29 = MouseInput.field756;
                        var30 = MouseInput.field741;
                        if(MouseInput.field743 != 0) {
                           var29 = MouseInput.field757;
                           var30 = MouseInput.field758;
                        }

                        int var31;
                        if(var29 >= var46 && var29 < var21 + var46 && var30 >= var20 && var30 < var20 + var22) {
                           var31 = var29 - var46;
                           int var32 = var30 - var20;
                           class132.field1993 = var31;
                           class132.field1986 = var32;
                           class132.field1988 = true;
                           class132.field1981 = 0;
                           class132.field1983 = false;
                        } else {
                           class175.method3459();
                        }

                        KeyFocusListener.method756();
                        Rasterizer2D.method5045(var46, var20, var21, var22, 0);
                        KeyFocusListener.method756();
                        var31 = Graphics3D.field2009;
                        Graphics3D.field2009 = Client.scale;
                        class3.region.draw(AbstractByteBuffer.cameraX, class229.cameraZ, World.cameraY, class18.cameraPitch, CombatInfo1.cameraYaw, var23);

                        while(true) {
                           class9 var50 = (class9)class7.field241.method3654();
                           if(var50 == null) {
                              Graphics3D.field2009 = var31;
                              KeyFocusListener.method756();
                              class3.region.clearEntities();
                              Client.field1007 = 0;
                              boolean var61 = false;
                              int var33 = -1;
                              int var34 = class94.playerIndexesCount;
                              int[] var35 = class94.playerIndices;

                              int var36;
                              for(var36 = 0; var36 < var34 + Client.npcIndexesCount; ++var36) {
                                 Object var37;
                                 if(var36 < var34) {
                                    var37 = Client.cachedPlayers[var35[var36]];
                                    if(var35[var36] == Client.field1043) {
                                       var61 = true;
                                       var33 = var36;
                                       continue;
                                    }
                                 } else {
                                    var37 = Client.cachedNPCs[Client.npcIndices[var36 - var34]];
                                 }

                                 class1.method0((Actor)var37, var36, var46, var20, var21, var22);
                              }

                              if(var61) {
                                 class1.method0(Client.cachedPlayers[Client.field1043], var33, var46, var20, var21, var22);
                              }

                              for(var36 = 0; var36 < Client.field1007; ++var36) {
                                 int var51 = Client.field1009[var36];
                                 int var38 = Client.field1010[var36];
                                 int var39 = Client.field1012[var36];
                                 int var40 = Client.field1011[var36];
                                 boolean var41 = true;

                                 while(var41) {
                                    var41 = false;

                                    for(int var42 = 0; var42 < var36; ++var42) {
                                       if(var38 + 2 > Client.field1010[var42] - Client.field1011[var42] && var38 - var40 < Client.field1010[var42] + 2 && var51 - var39 < Client.field1012[var42] + Client.field1009[var42] && var39 + var51 > Client.field1009[var42] - Client.field1012[var42] && Client.field1010[var42] - Client.field1011[var42] < var38) {
                                          var38 = Client.field1010[var42] - Client.field1011[var42];
                                          var41 = true;
                                       }
                                    }
                                 }

                                 Client.screenY = Client.field1009[var36];
                                 Client.screenX = Client.field1010[var36] = var38;
                                 String var52 = Client.field1016[var36];
                                 if(Client.field1076 == 0) {
                                    int var43 = 16776960;
                                    if(Client.field1013[var36] < 6) {
                                       var43 = Client.field1110[Client.field1013[var36]];
                                    }

                                    if(Client.field1013[var36] == 6) {
                                       var43 = Client.field1018 % 20 < 10?16711680:16776960;
                                    }

                                    if(Client.field1013[var36] == 7) {
                                       var43 = Client.field1018 % 20 < 10?255:'\uffff';
                                    }

                                    if(Client.field1013[var36] == 8) {
                                       var43 = Client.field1018 % 20 < 10?'뀀':8454016;
                                    }

                                    int var44;
                                    if(Client.field1013[var36] == 9) {
                                       var44 = 150 - Client.field1121[var36];
                                       if(var44 < 50) {
                                          var43 = var44 * 1280 + 16711680;
                                       } else if(var44 < 100) {
                                          var43 = 16776960 - (var44 - 50) * 327680;
                                       } else if(var44 < 150) {
                                          var43 = (var44 - 100) * 5 + 65280;
                                       }
                                    }

                                    if(Client.field1013[var36] == 10) {
                                       var44 = 150 - Client.field1121[var36];
                                       if(var44 < 50) {
                                          var43 = var44 * 5 + 16711680;
                                       } else if(var44 < 100) {
                                          var43 = 16711935 - (var44 - 50) * 327680;
                                       } else if(var44 < 150) {
                                          var43 = (var44 - 100) * 327680 + 255 - (var44 - 100) * 5;
                                       }
                                    }

                                    if(Client.field1013[var36] == 11) {
                                       var44 = 150 - Client.field1121[var36];
                                       if(var44 < 50) {
                                          var43 = 16777215 - var44 * 327685;
                                       } else if(var44 < 100) {
                                          var43 = (var44 - 50) * 327685 + 65280;
                                       } else if(var44 < 150) {
                                          var43 = 16777215 - (var44 - 100) * 327680;
                                       }
                                    }

                                    if(Client.field1014[var36] == 0) {
                                       class155.field2238.method4845(var52, var46 + Client.screenY, var20 + Client.screenX, var43, 0);
                                    }

                                    if(Client.field1014[var36] == 1) {
                                       class155.field2238.method4847(var52, var46 + Client.screenY, var20 + Client.screenX, var43, 0, Client.field1018);
                                    }

                                    if(Client.field1014[var36] == 2) {
                                       class155.field2238.method4860(var52, var46 + Client.screenY, var20 + Client.screenX, var43, 0, Client.field1018);
                                    }

                                    if(Client.field1014[var36] == 3) {
                                       class155.field2238.method4849(var52, var46 + Client.screenY, var20 + Client.screenX, var43, 0, Client.field1018, 150 - Client.field1121[var36]);
                                    }

                                    if(Client.field1014[var36] == 4) {
                                       var44 = (150 - Client.field1121[var36]) * (class155.field2238.method4848(var52) + 100) / 150;
                                       Rasterizer2D.setInnerDrawRegion(var46 + Client.screenY - 50, var20, var46 + Client.screenY + 50, var22 + var20);
                                       class155.field2238.method4842(var52, var46 + Client.screenY + 50 - var44, var20 + Client.screenX, var43, 0);
                                       Rasterizer2D.setDrawRegion(var46, var20, var46 + var21, var20 + var22);
                                    }

                                    if(Client.field1014[var36] == 5) {
                                       var44 = 150 - Client.field1121[var36];
                                       int var45 = 0;
                                       if(var44 < 25) {
                                          var45 = var44 - 25;
                                       } else if(var44 > 125) {
                                          var45 = var44 - 125;
                                       }

                                       Rasterizer2D.setInnerDrawRegion(var46, var20 + Client.screenX - class155.field2238.verticalSpace - 1, var21 + var46, var20 + Client.screenX + 5);
                                       class155.field2238.method4845(var52, var46 + Client.screenY, var20 + var45 + Client.screenX, var43, 0);
                                       Rasterizer2D.setDrawRegion(var46, var20, var46 + var21, var22 + var20);
                                    }
                                 } else {
                                    class155.field2238.method4845(var52, var46 + Client.screenY, var20 + Client.screenX, 16776960, 0);
                                 }
                              }

                              WorldMapType1.method275(var46, var20);
                              ((TextureProvider)Graphics3D.textureLoader).method2439(Client.field1004);
                              if(Client.cursorState == 1) {
                                 GroundObject.field1854[Client.field1023 / 100].drawAt(Client.field1047 - 8, Client.field1022 - 8);
                              }

                              if(Client.cursorState == 2) {
                                 GroundObject.field1854[Client.field1023 / 100 + 4].drawAt(Client.field1047 - 8, Client.field1022 - 8);
                              }

                              class48.method718();
                              AbstractByteBuffer.cameraX = var24;
                              class229.cameraZ = var25;
                              World.cameraY = var26;
                              class18.cameraPitch = var48;
                              CombatInfo1.cameraYaw = var49;
                              if(Client.field931) {
                                 byte var62 = 0;
                                 var33 = var62 + class238.field3248 + class238.field3250;
                                 if(var33 == 0) {
                                    Client.field931 = false;
                                 }
                              }

                              if(Client.field931) {
                                 Rasterizer2D.method5045(var46, var20, var21, var22, 0);
                                 class24.drawStatusBox("Loading - please wait.", false);
                              }

                              Client.field1119[var10.boundsIndex] = true;
                              Rasterizer2D.setDrawRegion(var2, var3, var4, var5);
                              continue label1209;
                           }

                           var50.vmethod57();
                        }
                     }

                     if(var10.contentType == 1338) {
                        class5.method14(var10, var12, var13, var11);
                        Rasterizer2D.setDrawRegion(var2, var3, var4, var5);
                        continue;
                     }

                     if(var10.contentType == 1339) {
                        BuildType.method4177(var10, var12, var13, var11);
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
                     if(!var10.hasScript && ScriptEvent.method1097(var10) && var10 != Sequence.field3621) {
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
                        class54.method778(var19.id, var15, var16, var17, var18, var12, var13, var11);
                     }

                     Rasterizer2D.setDrawRegion(var2, var3, var4, var5);
                     Graphics3D.method2676();
                  }

                  if(Client.isResized || Client.field1056[var11] || Client.gameDrawingMode > 1) {
                     if(var10.type == 0 && !var10.hasScript && var10.scrollHeight > var10.height) {
                        var46 = var12 + var10.width;
                        var20 = var10.scrollY;
                        var21 = var10.height;
                        var22 = var10.scrollHeight;
                        field1401[0].method5147(var46, var13);
                        field1401[1].method5147(var46, var21 + var13 - 16);
                        Rasterizer2D.method5045(var46, var13 + 16, 16, var21 - 32, Client.field991);
                        var23 = var21 * (var21 - 32) / var22;
                        if(var23 < 8) {
                           var23 = 8;
                        }

                        var24 = var20 * (var21 - 32 - var23) / (var22 - var21);
                        Rasterizer2D.method5045(var46, var24 + var13 + 16, 16, var23, Client.field992);
                        Rasterizer2D.method5055(var46, var13 + var24 + 16, var23, Client.field933);
                        Rasterizer2D.method5055(var46 + 1, var13 + var24 + 16, var23, Client.field933);
                        Rasterizer2D.method5053(var46, var24 + var13 + 16, 16, Client.field933);
                        Rasterizer2D.method5053(var46, var24 + var13 + 17, 16, Client.field933);
                        Rasterizer2D.method5055(var46 + 15, var13 + var24 + 16, var23, Client.field1061);
                        Rasterizer2D.method5055(var46 + 14, var24 + var13 + 17, var23 - 1, Client.field1061);
                        Rasterizer2D.method5053(var46, var23 + var24 + var13 + 15, 16, Client.field1061);
                        Rasterizer2D.method5053(var46 + 1, var13 + var24 + var23 + 14, 15, Client.field1061);
                     }

                     if(var10.type != 1) {
                        if(var10.type == 2) {
                           var46 = 0;

                           for(var20 = 0; var20 < var10.field2654; ++var20) {
                              for(var21 = 0; var21 < var10.originalWidth; ++var21) {
                                 var22 = var12 + var21 * (var10.paddingX + 32);
                                 var23 = var13 + var20 * (var10.paddingY + 32);
                                 if(var46 < 20) {
                                    var22 += var10.xSprites[var46];
                                    var23 += var10.field2701[var46];
                                 }

                                 if(var10.itemIds[var46] <= 0) {
                                    if(var10.field2656 != null && var46 < 20) {
                                       SpritePixels var63 = var10.method4081(var46);
                                       if(var63 != null) {
                                          var63.drawAt(var22, var23);
                                       } else if(Widget.field2640) {
                                          class45.method647(var10);
                                       }
                                    }
                                 } else {
                                    boolean var59 = false;
                                    boolean var60 = false;
                                    var26 = var10.itemIds[var46] - 1;
                                    if(var22 + 32 > var2 && var22 < var4 && var23 + 32 > var3 && var23 < var5 || var10 == ScriptState.field787 && var46 == Client.field944) {
                                       SpritePixels var27;
                                       if(Client.itemSelectionState == 1 && var46 == class5.selectedItemIndex && var10.id == ClanMember.field915) {
                                          var27 = Client.createSprite(var26, var10.itemQuantities[var46], 2, 0, 2, false);
                                       } else {
                                          var27 = Client.createSprite(var26, var10.itemQuantities[var46], 1, 3153952, 2, false);
                                       }

                                       if(var27 != null) {
                                          if(var10 == ScriptState.field787 && var46 == Client.field944) {
                                             var24 = MouseInput.field756 - Client.field1028;
                                             var25 = MouseInput.field741 - Client.field1131;
                                             if(var24 < 5 && var24 > -5) {
                                                var24 = 0;
                                             }

                                             if(var25 < 5 && var25 > -5) {
                                                var25 = 0;
                                             }

                                             if(Client.field1032 < 5) {
                                                var24 = 0;
                                                var25 = 0;
                                             }

                                             var27.method5179(var22 + var24, var23 + var25, 128);
                                             if(var1 != -1) {
                                                Widget var28 = var0[var1 & 65535];
                                                if(var23 + var25 < Rasterizer2D.drawingAreaTop && var28.scrollY > 0) {
                                                   var29 = (Rasterizer2D.drawingAreaTop - var23 - var25) * Client.field1004 / 3;
                                                   if(var29 > Client.field1004 * 10) {
                                                      var29 = Client.field1004 * 10;
                                                   }

                                                   if(var29 > var28.scrollY) {
                                                      var29 = var28.scrollY;
                                                   }

                                                   var28.scrollY -= var29;
                                                   Client.field1131 += var29;
                                                   class45.method647(var28);
                                                }

                                                if(var25 + var23 + 32 > Rasterizer2D.drawingAreaRight && var28.scrollY < var28.scrollHeight - var28.height) {
                                                   var29 = (var23 + var25 + 32 - Rasterizer2D.drawingAreaRight) * Client.field1004 / 3;
                                                   if(var29 > Client.field1004 * 10) {
                                                      var29 = Client.field1004 * 10;
                                                   }

                                                   if(var29 > var28.scrollHeight - var28.height - var28.scrollY) {
                                                      var29 = var28.scrollHeight - var28.height - var28.scrollY;
                                                   }

                                                   var28.scrollY += var29;
                                                   Client.field1131 -= var29;
                                                   class45.method647(var28);
                                                }
                                             }
                                          } else if(var10 == class72.field882 && var46 == Client.field1026) {
                                             var27.method5179(var22, var23, 128);
                                          } else {
                                             var27.drawAt(var22, var23);
                                          }
                                       } else {
                                          class45.method647(var10);
                                       }
                                    }
                                 }

                                 ++var46;
                              }
                           }
                        } else if(var10.type == 3) {
                           if(class2.method2(var10)) {
                              var46 = var10.field2668;
                              if(var10 == Sequence.field3621 && var10.field2670 != 0) {
                                 var46 = var10.field2670;
                              }
                           } else {
                              var46 = var10.textColor;
                              if(var10 == Sequence.field3621 && var10.field2669 != 0) {
                                 var46 = var10.field2669;
                              }
                           }

                           if(var10.field2671) {
                              switch(var10.field2672.field3783) {
                              case 1:
                                 Rasterizer2D.method5111(var12, var13, var10.width, var10.height, var10.textColor, var10.field2668, 256 - (var10.opacity & 255), 256 - (var10.field2674 & 255));
                                 break;
                              case 2:
                                 Rasterizer2D.method5075(var12, var13, var10.width, var10.height, var10.textColor, var10.field2668, 256 - (var10.opacity & 255), 256 - (var10.field2674 & 255));
                                 break;
                              case 3:
                                 Rasterizer2D.method5076(var12, var13, var10.width, var10.height, var10.textColor, var10.field2668, 256 - (var10.opacity & 255), 256 - (var10.field2674 & 255));
                                 break;
                              case 4:
                                 Rasterizer2D.method5048(var12, var13, var10.width, var10.height, var10.textColor, var10.field2668, 256 - (var10.opacity & 255), 256 - (var10.field2674 & 255));
                                 break;
                              default:
                                 if(var14 == 0) {
                                    Rasterizer2D.method5045(var12, var13, var10.width, var10.height, var46);
                                 } else {
                                    Rasterizer2D.fillRectangle(var12, var13, var10.width, var10.height, var46, 256 - (var14 & 255));
                                 }
                              }
                           } else if(var14 == 0) {
                              Rasterizer2D.drawRectangle(var12, var13, var10.width, var10.height, var46);
                           } else {
                              Rasterizer2D.method5038(var12, var13, var10.width, var10.height, var46, 256 - (var14 & 255));
                           }
                        } else {
                           Font var56;
                           if(var10.type == 4) {
                              var56 = var10.method4073();
                              if(var56 == null) {
                                 if(Widget.field2640) {
                                    class45.method647(var10);
                                 }
                              } else {
                                 String var68 = var10.text;
                                 if(class2.method2(var10)) {
                                    var20 = var10.field2668;
                                    if(var10 == Sequence.field3621 && var10.field2670 != 0) {
                                       var20 = var10.field2670;
                                    }

                                    if(var10.field2729.length() > 0) {
                                       var68 = var10.field2729;
                                    }
                                 } else {
                                    var20 = var10.textColor;
                                    if(var10 == Sequence.field3621 && var10.field2669 != 0) {
                                       var20 = var10.field2669;
                                    }
                                 }

                                 if(var10.hasScript && var10.itemId != -1) {
                                    ItemComposition var70 = FaceNormal.getItemDefinition(var10.itemId);
                                    var68 = var70.name;
                                    if(var68 == null) {
                                       var68 = "null";
                                    }

                                    if((var70.isStackable == 1 || var10.itemQuantity != 1) && var10.itemQuantity != -1) {
                                       var68 = class24.getColTags(16748608) + var68 + "</col>" + " " + 'x' + class21.method160(var10.itemQuantity);
                                    }
                                 }

                                 if(var10 == Client.field1078) {
                                    Object var10000 = null;
                                    var68 = "Please wait...";
                                    var20 = var10.textColor;
                                 }

                                 if(!var10.hasScript) {
                                    var68 = IndexData.method4312(var68, var10);
                                 }

                                 var56.method4915(var68, var12, var13, var10.width, var10.height, var20, var10.textShadowed?0:-1, var10.field2705, var10.field2706, var10.field2704);
                              }
                           } else if(var10.type == 5) {
                              SpritePixels var57;
                              if(!var10.hasScript) {
                                 var57 = var10.method4087(class2.method2(var10));
                                 if(var57 != null) {
                                    var57.drawAt(var12, var13);
                                 } else if(Widget.field2640) {
                                    class45.method647(var10);
                                 }
                              } else {
                                 if(var10.itemId != -1) {
                                    var57 = Client.createSprite(var10.itemId, var10.itemQuantity, var10.borderThickness, var10.sprite2, var10.field2759, false);
                                 } else {
                                    var57 = var10.method4087(false);
                                 }

                                 if(var57 == null) {
                                    if(Widget.field2640) {
                                       class45.method647(var10);
                                    }
                                 } else {
                                    var20 = var57.maxWidth;
                                    var21 = var57.maxHeight;
                                    if(!var10.field2727) {
                                       var22 = var10.width * 4096 / var20;
                                       if(var10.textureId != 0) {
                                          var57.method5180(var10.width / 2 + var12, var10.height / 2 + var13, var10.textureId, var22);
                                       } else if(var14 != 0) {
                                          var57.method5181(var12, var13, var10.width, var10.height, 256 - (var14 & 255));
                                       } else if(var20 == var10.width && var21 == var10.height) {
                                          var57.drawAt(var12, var13);
                                       } else {
                                          var57.method5231(var12, var13, var10.width, var10.height);
                                       }
                                    } else {
                                       Rasterizer2D.setInnerDrawRegion(var12, var13, var12 + var10.width, var13 + var10.height);
                                       var22 = (var20 - 1 + var10.width) / var20;
                                       var23 = (var21 - 1 + var10.height) / var21;

                                       for(var24 = 0; var24 < var22; ++var24) {
                                          for(var25 = 0; var25 < var23; ++var25) {
                                             if(var10.textureId != 0) {
                                                var57.method5180(var20 / 2 + var12 + var20 * var24, var21 / 2 + var13 + var25 * var21, var10.textureId, 4096);
                                             } else if(var14 != 0) {
                                                var57.method5179(var12 + var20 * var24, var13 + var21 * var25, 256 - (var14 & 255));
                                             } else {
                                                var57.drawAt(var12 + var20 * var24, var13 + var21 * var25);
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
                                 boolean var65 = class2.method2(var10);
                                 if(var65) {
                                    var20 = var10.field2690;
                                 } else {
                                    var20 = var10.field2711;
                                 }

                                 Model var66 = null;
                                 var22 = 0;
                                 if(var10.itemId != -1) {
                                    var54 = FaceNormal.getItemDefinition(var10.itemId);
                                    if(var54 != null) {
                                       var54 = var54.method4662(var10.itemQuantity);
                                       var66 = var54.getModel(1);
                                       if(var66 != null) {
                                          var66.method2558();
                                          var22 = var66.modelHeight / 2;
                                       } else {
                                          class45.method647(var10);
                                       }
                                    }
                                 } else if(var10.modelType == 5) {
                                    if(var10.modelId == 0) {
                                       var66 = Client.field1185.method4032((Sequence)null, -1, (Sequence)null, -1);
                                    } else {
                                       var66 = class66.localPlayer.getModel();
                                    }
                                 } else if(var20 == -1) {
                                    var66 = var10.method4075((Sequence)null, -1, var65, class66.localPlayer.composition);
                                    if(var66 == null && Widget.field2640) {
                                       class45.method647(var10);
                                    }
                                 } else {
                                    Sequence var69 = NPCComposition.getAnimation(var20);
                                    var66 = var10.method4075(var69, var10.field2680, var65, class66.localPlayer.composition);
                                    if(var66 == null && Widget.field2640) {
                                       class45.method647(var10);
                                    }
                                 }

                                 Graphics3D.method2644(var10.width / 2 + var12, var10.height / 2 + var13);
                                 var23 = Graphics3D.SINE[var10.rotationX] * var10.modelZoom >> 16;
                                 var24 = Graphics3D.COSINE[var10.rotationX] * var10.modelZoom >> 16;
                                 if(var66 != null) {
                                    if(!var10.hasScript) {
                                       var66.method2571(0, var10.rotationZ, 0, var10.rotationX, 0, var23, var24);
                                    } else {
                                       var66.method2558();
                                       if(var10.field2699) {
                                          var66.method2576(0, var10.rotationZ, var10.rotationY, var10.rotationX, var10.field2737, var23 + var22 + var10.field2692, var24 + var10.field2692, var10.modelZoom);
                                       } else {
                                          var66.method2571(0, var10.rotationZ, var10.rotationY, var10.rotationX, var10.field2737, var22 + var23 + var10.field2692, var24 + var10.field2692);
                                       }
                                    }
                                 }

                                 Graphics3D.method2696();
                              } else {
                                 if(var10.type == 7) {
                                    var56 = var10.method4073();
                                    if(var56 == null) {
                                       if(Widget.field2640) {
                                          class45.method647(var10);
                                       }
                                       continue;
                                    }

                                    var20 = 0;

                                    for(var21 = 0; var21 < var10.field2654; ++var21) {
                                       for(var22 = 0; var22 < var10.originalWidth; ++var22) {
                                          if(var10.itemIds[var20] > 0) {
                                             var54 = FaceNormal.getItemDefinition(var10.itemIds[var20] - 1);
                                             String var47;
                                             if(var54.isStackable != 1 && var10.itemQuantities[var20] == 1) {
                                                var47 = class24.getColTags(16748608) + var54.name + "</col>";
                                             } else {
                                                var47 = class24.getColTags(16748608) + var54.name + "</col>" + " " + 'x' + class21.method160(var10.itemQuantities[var20]);
                                             }

                                             var25 = var22 * (var10.paddingX + 115) + var12;
                                             var26 = var21 * (var10.paddingY + 12) + var13;
                                             if(var10.field2705 == 0) {
                                                var56.method4842(var47, var25, var26, var10.textColor, var10.textShadowed?0:-1);
                                             } else if(var10.field2705 == 1) {
                                                var56.method4845(var47, var10.width / 2 + var25, var26, var10.textColor, var10.textShadowed?0:-1);
                                             } else {
                                                var56.method4844(var47, var25 + var10.width - 1, var26, var10.textColor, var10.textShadowed?0:-1);
                                             }
                                          }

                                          ++var20;
                                       }
                                    }
                                 }

                                 if(var10.type == 8 && var10 == class162.field2303 && Client.field1066 == Client.field1065) {
                                    var46 = 0;
                                    var20 = 0;
                                    Font var53 = class9.font_p12full;
                                    String var55 = var10.text;

                                    String var67;
                                    for(var55 = IndexData.method4312(var55, var10); var55.length() > 0; var20 = var20 + var53.verticalSpace + 1) {
                                       var24 = var55.indexOf("<br>");
                                       if(var24 != -1) {
                                          var67 = var55.substring(0, var24);
                                          var55 = var55.substring(var24 + 4);
                                       } else {
                                          var67 = var55;
                                          var55 = "";
                                       }

                                       var25 = var53.method4848(var67);
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

                                    if(var24 + var46 > var4) {
                                       var24 = var4 - var46;
                                    }

                                    if(var25 + var20 > var5) {
                                       var25 = var5 - var20;
                                    }

                                    Rasterizer2D.method5045(var24, var25, var46, var20, 16777120);
                                    Rasterizer2D.drawRectangle(var24, var25, var46, var20, 0);
                                    var55 = var10.text;
                                    var26 = var25 + var53.verticalSpace + 2;

                                    for(var55 = IndexData.method4312(var55, var10); var55.length() > 0; var26 = var26 + var53.verticalSpace + 1) {
                                       var48 = var55.indexOf("<br>");
                                       if(var48 != -1) {
                                          var67 = var55.substring(0, var48);
                                          var55 = var55.substring(var48 + 4);
                                       } else {
                                          var67 = var55;
                                          var55 = "";
                                       }

                                       var53.method4842(var67, var24 + 3, var26, 0, -1);
                                    }
                                 }

                                 if(var10.type == 9) {
                                    if(var10.field2676) {
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

                                    if(var10.field2745 == 1) {
                                       Rasterizer2D.drawLine(var46, var20, var21, var22, var10.textColor);
                                    } else {
                                       class66.method1085(var46, var20, var21, var22, var10.textColor, var10.field2745);
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
      signature = "(IIIIB)V",
      garbageValue = "57"
   )
   static final void method1724(int var0, int var1, int var2, int var3) {
      if(Client.itemSelectionState == 0 && !Client.spellSelected) {
         class215.addMenuEntry("Walk here", "", 23, 0, var0 - var2, var1 - var3);
      }

      int var4 = -1;
      int var5 = -1;

      int var6;
      int var7;
      for(var6 = 0; var6 < class132.field1981; ++var6) {
         var7 = class132.field1989[var6];
         int var8 = var7 & 127;
         int var9 = var7 >> 7 & 127;
         int var10 = var7 >> 29 & 3;
         int var11 = var7 >> 14 & 32767;
         if(var5 != var7) {
            var5 = var7;
            if(var10 == 2 && class3.region.method2747(class46.plane, var8, var9, var7) >= 0) {
               ObjectComposition var12 = CollisionData.getObjectDefinition(var11);
               if(var12.impostorIds != null) {
                  var12 = var12.getImpostor();
               }

               if(var12 == null) {
                  continue;
               }

               if(Client.itemSelectionState == 1) {
                  class215.addMenuEntry("Use", Client.field1068 + " " + "->" + " " + class24.getColTags(65535) + var12.name, 1, var7, var8, var9);
               } else if(Client.spellSelected) {
                  if((class90.field1421 & 4) == 4) {
                     class215.addMenuEntry(Client.field1072, Client.field1087 + " " + "->" + " " + class24.getColTags(65535) + var12.name, 2, var7, var8, var9);
                  }
               } else {
                  String[] var13 = var12.actions;
                  if(Client.field1085) {
                     var13 = class8.method43(var13);
                  }

                  if(var13 != null) {
                     for(int var14 = 4; var14 >= 0; --var14) {
                        if(var13[var14] != null) {
                           short var15 = 0;
                           if(var14 == 0) {
                              var15 = 3;
                           }

                           if(var14 == 1) {
                              var15 = 4;
                           }

                           if(var14 == 2) {
                              var15 = 5;
                           }

                           if(var14 == 3) {
                              var15 = 6;
                           }

                           if(var14 == 4) {
                              var15 = 1001;
                           }

                           class215.addMenuEntry(var13[var14], class24.getColTags(65535) + var12.name, var15, var7, var8, var9);
                        }
                     }
                  }

                  class215.addMenuEntry("Examine", class24.getColTags(65535) + var12.name, 1002, var12.id << 14, var8, var9);
               }
            }

            Player var16;
            int var19;
            NPC var20;
            int var27;
            int[] var28;
            if(var10 == 1) {
               NPC var23 = Client.cachedNPCs[var11];
               if(var23 == null) {
                  continue;
               }

               if(var23.composition.field3555 == 1 && (var23.x & 127) == 64 && (var23.y & 127) == 64) {
                  for(var19 = 0; var19 < Client.npcIndexesCount; ++var19) {
                     var20 = Client.cachedNPCs[Client.npcIndices[var19]];
                     if(var20 != null && var20 != var23 && var20.composition.field3555 == 1 && var23.x == var20.x && var23.y == var20.y) {
                        class18.method129(var20.composition, Client.npcIndices[var19], var8, var9);
                     }
                  }

                  var19 = class94.playerIndexesCount;
                  var28 = class94.playerIndices;

                  for(var27 = 0; var27 < var19; ++var27) {
                     var16 = Client.cachedPlayers[var28[var27]];
                     if(var16 != null && var16.x == var23.x && var16.y == var23.y) {
                        class35.method477(var16, var28[var27], var8, var9);
                     }
                  }
               }

               class18.method129(var23.composition, var11, var8, var9);
            }

            if(var10 == 0) {
               Player var24 = Client.cachedPlayers[var11];
               if(var24 == null) {
                  continue;
               }

               if((var24.x & 127) == 64 && (var24.y & 127) == 64) {
                  for(var19 = 0; var19 < Client.npcIndexesCount; ++var19) {
                     var20 = Client.cachedNPCs[Client.npcIndices[var19]];
                     if(var20 != null && var20.composition.field3555 == 1 && var20.x == var24.x && var20.y == var24.y) {
                        class18.method129(var20.composition, Client.npcIndices[var19], var8, var9);
                     }
                  }

                  var19 = class94.playerIndexesCount;
                  var28 = class94.playerIndices;

                  for(var27 = 0; var27 < var19; ++var27) {
                     var16 = Client.cachedPlayers[var28[var27]];
                     if(var16 != null && var24 != var16 && var24.x == var16.x && var16.y == var24.y) {
                        class35.method477(var16, var28[var27], var8, var9);
                     }
                  }
               }

               if(var11 != Client.field1043) {
                  class35.method477(var24, var11, var8, var9);
               } else {
                  var4 = var7;
               }
            }

            if(var10 == 3) {
               Deque var25 = Client.groundItemDeque[class46.plane][var8][var9];
               if(var25 != null) {
                  for(Item var26 = (Item)var25.getTail(); var26 != null; var26 = (Item)var25.getPrevious()) {
                     ItemComposition var29 = FaceNormal.getItemDefinition(var26.id);
                     if(Client.itemSelectionState == 1) {
                        class215.addMenuEntry("Use", Client.field1068 + " " + "->" + " " + class24.getColTags(16748608) + var29.name, 16, var26.id, var8, var9);
                     } else if(Client.spellSelected) {
                        if((class90.field1421 & 1) == 1) {
                           class215.addMenuEntry(Client.field1072, Client.field1087 + " " + "->" + " " + class24.getColTags(16748608) + var29.name, 17, var26.id, var8, var9);
                        }
                     } else {
                        String[] var21 = var29.groundActions;
                        if(Client.field1085) {
                           var21 = class8.method43(var21);
                        }

                        for(int var22 = 4; var22 >= 0; --var22) {
                           if(var21 != null && var21[var22] != null) {
                              byte var17 = 0;
                              if(var22 == 0) {
                                 var17 = 18;
                              }

                              if(var22 == 1) {
                                 var17 = 19;
                              }

                              if(var22 == 2) {
                                 var17 = 20;
                              }

                              if(var22 == 3) {
                                 var17 = 21;
                              }

                              if(var22 == 4) {
                                 var17 = 22;
                              }

                              class215.addMenuEntry(var21[var22], class24.getColTags(16748608) + var29.name, var17, var26.id, var8, var9);
                           } else if(var22 == 2) {
                              class215.addMenuEntry("Take", class24.getColTags(16748608) + var29.name, 20, var26.id, var8, var9);
                           }
                        }

                        class215.addMenuEntry("Examine", class24.getColTags(16748608) + var29.name, 1004, var26.id, var8, var9);
                     }
                  }
               }
            }
         }
      }

      if(var4 != -1) {
         var6 = var4 & 127;
         var7 = var4 >> 7 & 127;
         Player var18 = Client.cachedPlayers[Client.field1043];
         class35.method477(var18, Client.field1043, var6, var7);
      }

   }
}
