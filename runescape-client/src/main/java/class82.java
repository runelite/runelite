import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

import java.util.Calendar;

@ObfuscatedName("cv")
public class class82 {
   @ObfuscatedName("k")
   @Export("scriptLocalStrings")
   static String[] scriptLocalStrings;
   @ObfuscatedName("u")
   static int[] field1240;
   @ObfuscatedName("z")
   @Export("SHAPE_VERTICES")
   static int[][] SHAPE_VERTICES;
   @ObfuscatedName("t")
   @Export("intStack")
   static int[] intStack;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -531735453
   )
   @Export("intStackSize")
   static int intStackSize;
   @ObfuscatedName("g")
   @Export("scriptStringStack")
   static String[] scriptStringStack;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 733546181
   )
   @Export("scriptStackCount")
   static int scriptStackCount;
   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "[Lbs;"
   )
   @Export("scriptStack")
   static ScriptState[] scriptStack;
   @ObfuscatedName("y")
   @Export("calendarRS")
   static Calendar calendar;
   @ObfuscatedName("o")
   @Export("monthsShorthand")
   static final String[] months;
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "Laa;"
   )
   static MapAreaMetadata field1238;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -2128998809
   )
   static int field1250;

   static {
      field1240 = new int[5];
      SHAPE_VERTICES = new int[5][5000];
      intStack = new int[1000];
      scriptStringStack = new String[1000];
      scriptStackCount = 0;
      scriptStack = new ScriptState[50];
      calendar = Calendar.getInstance();
      months = new String[]{"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
      field1250 = 0;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(IILfk;Lfp;I)Z",
      garbageValue = "-472666733"
   )
   public static final boolean method1564(int var0, int var1, class168 var2, CollisionData var3) {
      int var4 = var0;
      int var5 = var1;
      byte var6 = 64;
      byte var7 = 64;
      int var8 = var0 - var6;
      int var9 = var1 - var7;
      class167.field2218[var6][var7] = 99;
      class167.field2216[var6][var7] = 0;
      byte var10 = 0;
      int var11 = 0;
      class167.field2220[var10] = var0;
      byte var10001 = var10;
      int var18 = var10 + 1;
      class167.field2221[var10001] = var1;
      int[][] var12 = var3.flags;

      while(var18 != var11) {
         var4 = class167.field2220[var11];
         var5 = class167.field2221[var11];
         var11 = var11 + 1 & 4095;
         int var16 = var4 - var8;
         int var17 = var5 - var9;
         int var13 = var4 - var3.x;
         int var14 = var5 - var3.y;
         if(var2.vmethod3167(2, var4, var5, var3)) {
            class167.field2217 = var4;
            class167.field2215 = var5;
            return true;
         }

         int var15 = class167.field2216[var16][var17] + 1;
         if(var16 > 0 && class167.field2218[var16 - 1][var17] == 0 && (var12[var13 - 1][var14] & 19136782) == 0 && (var12[var13 - 1][var14 + 1] & 19136824) == 0) {
            class167.field2220[var18] = var4 - 1;
            class167.field2221[var18] = var5;
            var18 = var18 + 1 & 4095;
            class167.field2218[var16 - 1][var17] = 2;
            class167.field2216[var16 - 1][var17] = var15;
         }

         if(var16 < 126 && class167.field2218[var16 + 1][var17] == 0 && (var12[var13 + 2][var14] & 19136899) == 0 && (var12[var13 + 2][var14 + 1] & 19136992) == 0) {
            class167.field2220[var18] = var4 + 1;
            class167.field2221[var18] = var5;
            var18 = var18 + 1 & 4095;
            class167.field2218[var16 + 1][var17] = 8;
            class167.field2216[var16 + 1][var17] = var15;
         }

         if(var17 > 0 && class167.field2218[var16][var17 - 1] == 0 && (var12[var13][var14 - 1] & 19136782) == 0 && (var12[var13 + 1][var14 - 1] & 19136899) == 0) {
            class167.field2220[var18] = var4;
            class167.field2221[var18] = var5 - 1;
            var18 = var18 + 1 & 4095;
            class167.field2218[var16][var17 - 1] = 1;
            class167.field2216[var16][var17 - 1] = var15;
         }

         if(var17 < 126 && class167.field2218[var16][var17 + 1] == 0 && (var12[var13][var14 + 2] & 19136824) == 0 && (var12[var13 + 1][var14 + 2] & 19136992) == 0) {
            class167.field2220[var18] = var4;
            class167.field2221[var18] = var5 + 1;
            var18 = var18 + 1 & 4095;
            class167.field2218[var16][var17 + 1] = 4;
            class167.field2216[var16][var17 + 1] = var15;
         }

         if(var16 > 0 && var17 > 0 && class167.field2218[var16 - 1][var17 - 1] == 0 && (var12[var13 - 1][var14] & 19136830) == 0 && (var12[var13 - 1][var14 - 1] & 19136782) == 0 && (var12[var13][var14 - 1] & 19136911) == 0) {
            class167.field2220[var18] = var4 - 1;
            class167.field2221[var18] = var5 - 1;
            var18 = var18 + 1 & 4095;
            class167.field2218[var16 - 1][var17 - 1] = 3;
            class167.field2216[var16 - 1][var17 - 1] = var15;
         }

         if(var16 < 126 && var17 > 0 && class167.field2218[var16 + 1][var17 - 1] == 0 && (var12[var13 + 1][var14 - 1] & 19136911) == 0 && (var12[var13 + 2][var14 - 1] & 19136899) == 0 && (var12[var13 + 2][var14] & 19136995) == 0) {
            class167.field2220[var18] = var4 + 1;
            class167.field2221[var18] = var5 - 1;
            var18 = var18 + 1 & 4095;
            class167.field2218[var16 + 1][var17 - 1] = 9;
            class167.field2216[var16 + 1][var17 - 1] = var15;
         }

         if(var16 > 0 && var17 < 126 && class167.field2218[var16 - 1][var17 + 1] == 0 && (var12[var13 - 1][var14 + 1] & 19136830) == 0 && (var12[var13 - 1][var14 + 2] & 19136824) == 0 && (var12[var13][var14 + 2] & 19137016) == 0) {
            class167.field2220[var18] = var4 - 1;
            class167.field2221[var18] = var5 + 1;
            var18 = var18 + 1 & 4095;
            class167.field2218[var16 - 1][var17 + 1] = 6;
            class167.field2216[var16 - 1][var17 + 1] = var15;
         }

         if(var16 < 126 && var17 < 126 && class167.field2218[var16 + 1][var17 + 1] == 0 && (var12[var13 + 1][var14 + 2] & 19137016) == 0 && (var12[var13 + 2][var14 + 2] & 19136992) == 0 && (var12[var13 + 2][var14 + 1] & 19136995) == 0) {
            class167.field2220[var18] = var4 + 1;
            class167.field2221[var18] = var5 + 1;
            var18 = var18 + 1 & 4095;
            class167.field2218[var16 + 1][var17 + 1] = 12;
            class167.field2216[var16 + 1][var17 + 1] = var15;
         }
      }

      class167.field2217 = var4;
      class167.field2215 = var5;
      return false;
   }

   @ObfuscatedName("hn")
   @ObfuscatedSignature(
      signature = "([Lhz;IIIIIIIIB)V",
      garbageValue = "-29"
   )
   @Export("gameDraw")
   static final void gameDraw(Widget[] var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
      Rasterizer2D.setDrawRegion(var2, var3, var4, var5);
      Graphics3D.Rasterizer3D_method1();

      label1611:
      for(int var9 = 0; var9 < var0.length; ++var9) {
         Widget var10 = var0[var9];
         if(var10 != null && (var10.parentId == var1 || var1 == -1412584499 && var10 == Client.field1064)) {
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
            if(!var10.hasScript || !Occluder.method2905(var10)) {
               if(var10.contentType > 0) {
                  class35.method491(var10);
               }

               int var12 = var10.relativeX + var6;
               int var13 = var7 + var10.relativeY;
               int var14 = var10.opacity;
               int var15;
               int var16;
               if(var10 == Client.field1064) {
                  if(var1 != -1412584499 && !var10.field2889) {
                     class3.field17 = var0;
                     GameObjectTransformMetadata.field1222 = var6;
                     class186.field2526 = var7;
                     continue;
                  }

                  if(Client.field1012 && Client.field992) {
                     var15 = MouseInput.field679;
                     var16 = MouseInput.field682 * -469125321;
                     var15 -= Client.field889;
                     var16 -= Client.field943;
                     if(var15 < Client.field1007) {
                        var15 = Client.field1007;
                     }

                     if(var15 + var10.width > Client.field1007 + Client.field1002.width) {
                        var15 = Client.field1007 + Client.field1002.width - var10.width;
                     }

                     if(var16 < Client.field950) {
                        var16 = Client.field950;
                     }

                     if(var16 + var10.height > Client.field950 + Client.field1002.height) {
                        var16 = Client.field950 + Client.field1002.height - var10.height;
                     }

                     var12 = var15;
                     var13 = var16;
                  }

                  if(!var10.field2889) {
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
                  int var38;
                  int var39;
                  int var40;
                  int var42;
                  int var43;
                  int var44;
                  int var45;
                  int var51;
                  if(var10.contentType != 0) {
                     if(var10.contentType == 1336) {
                        if(Client.displayFps) {
                           var13 += 15;
                           BaseVarType.font_p12full.drawString("Fps:" + GameEngine.FPS, var12 + var10.width, var13, 16776960, -1);
                           var13 += 15;
                           Runtime var67 = Runtime.getRuntime();
                           var20 = (int)((var67.totalMemory() - var67.freeMemory()) / 1024L);
                           var21 = 16776960;
                           if(var20 > 32768 && Client.lowMemory) {
                              var21 = 16711680;
                           }

                           if(var20 > 65536 && !Client.lowMemory) {
                              var21 = 16711680;
                           }

                           BaseVarType.font_p12full.drawString("Mem:" + var20 + "k", var12 + var10.width, var13, var21, -1);
                           var13 += 15;
                        }
                        continue;
                     }

                     if(var10.contentType == 1337) {
                        Client.field964 = var12;
                        Client.field882 = var13;
                        var21 = var10.width;
                        var22 = var10.height;
                        ++Client.field932;
                        if(UrlRequest.localPlayer.x >> 7 == Client.destinationX && UrlRequest.localPlayer.y >> 7 == Client.destinationY) {
                           Client.destinationX = 0;
                        }

                        PendingSpawn.method1462(UrlRequest.localPlayer, false);
                        if(Client.field957 >= 0 && Client.cachedPlayers[Client.field957] != null) {
                           PendingSpawn.method1462(Client.cachedPlayers[Client.field957], false);
                        }

                        ScriptState.method1022(true);
                        TotalQuantityComparator.method92();
                        ScriptState.method1022(false);
                        class35.method495();
                        UnitPriceComparator.method125();
                        BoundingBox3D.method47(var12, var13, var21, var22, true);
                        var19 = Client.Viewport_xOffset;
                        var20 = Client.Viewport_yOffset;
                        var21 = Client.viewportHeight;
                        var22 = Client.viewportWidth;
                        Rasterizer2D.setDrawRegion(var19, var20, var19 + var21, var22 + var20);
                        Graphics3D.Rasterizer3D_method1();
                        if(!Client.field930) {
                           var23 = Client.field998;
                           if(Client.field920 / 256 > var23) {
                              var23 = Client.field920 / 256;
                           }

                           if(Client.field1075[4] && Client.field1077[4] + 128 > var23) {
                              var23 = Client.field1077[4] + 128;
                           }

                           var24 = Client.mapAngle & 2047;
                           var25 = class72.field804;
                           var26 = WorldMapType2.getTileHeight(UrlRequest.localPlayer.x, UrlRequest.localPlayer.y, BoundingBox2D.plane) - Client.field1014;
                           var27 = SceneTilePaint.field1932;
                           var28 = var23 * 3 + 600;
                           var29 = 2048 - var23 & 2047;
                           var30 = 2048 - var24 & 2047;
                           var31 = 0;
                           var32 = 0;
                           var33 = var28;
                           if(var29 != 0) {
                              var34 = Graphics3D.SINE[var29];
                              var35 = Graphics3D.COSINE[var29];
                              var36 = var32 * var35 - var34 * var28 >> 16;
                              var33 = var35 * var28 + var32 * var34 >> 16;
                              var32 = var36;
                           }

                           if(var30 != 0) {
                              var34 = Graphics3D.SINE[var30];
                              var35 = Graphics3D.COSINE[var30];
                              var36 = var34 * var33 + var35 * var31 >> 16;
                              var33 = var35 * var33 - var31 * var34 >> 16;
                              var31 = var36;
                           }

                           MouseInput.cameraX = var25 - var31;
                           GrandExchangeEvent.cameraZ = var26 - var32;
                           GZipDecompressor.cameraY = var27 - var33;
                           class160.cameraPitch = var23;
                           class240.cameraYaw = var24;
                        }

                        if(!Client.field930) {
                           if(class2.preferences.hideRoofs) {
                              var24 = BoundingBox2D.plane;
                           } else {
                              label1709: {
                                 var25 = 3;
                                 if(class160.cameraPitch < 310) {
                                    var26 = MouseInput.cameraX >> 7;
                                    var27 = GZipDecompressor.cameraY >> 7;
                                    var28 = UrlRequest.localPlayer.x >> 7;
                                    var29 = UrlRequest.localPlayer.y >> 7;
                                    if(var26 < 0 || var27 < 0 || var26 >= 104 || var27 >= 104) {
                                       var24 = BoundingBox2D.plane;
                                       break label1709;
                                    }

                                    if((class61.tileSettings[BoundingBox2D.plane][var26][var27] & 4) != 0) {
                                       var25 = BoundingBox2D.plane;
                                    }

                                    if(var28 > var26) {
                                       var30 = var28 - var26;
                                    } else {
                                       var30 = var26 - var28;
                                    }

                                    if(var29 > var27) {
                                       var31 = var29 - var27;
                                    } else {
                                       var31 = var27 - var29;
                                    }

                                    if(var30 > var31) {
                                       var32 = var31 * 65536 / var30;
                                       var33 = 32768;

                                       while(var26 != var28) {
                                          if(var26 < var28) {
                                             ++var26;
                                          } else if(var26 > var28) {
                                             --var26;
                                          }

                                          if((class61.tileSettings[BoundingBox2D.plane][var26][var27] & 4) != 0) {
                                             var25 = BoundingBox2D.plane;
                                          }

                                          var33 += var32;
                                          if(var33 >= 65536) {
                                             var33 -= 65536;
                                             if(var27 < var29) {
                                                ++var27;
                                             } else if(var27 > var29) {
                                                --var27;
                                             }

                                             if((class61.tileSettings[BoundingBox2D.plane][var26][var27] & 4) != 0) {
                                                var25 = BoundingBox2D.plane;
                                             }
                                          }
                                       }
                                    } else {
                                       var32 = var30 * 65536 / var31;
                                       var33 = 32768;

                                       while(var29 != var27) {
                                          if(var27 < var29) {
                                             ++var27;
                                          } else if(var27 > var29) {
                                             --var27;
                                          }

                                          if((class61.tileSettings[BoundingBox2D.plane][var26][var27] & 4) != 0) {
                                             var25 = BoundingBox2D.plane;
                                          }

                                          var33 += var32;
                                          if(var33 >= 65536) {
                                             var33 -= 65536;
                                             if(var26 < var28) {
                                                ++var26;
                                             } else if(var26 > var28) {
                                                --var26;
                                             }

                                             if((class61.tileSettings[BoundingBox2D.plane][var26][var27] & 4) != 0) {
                                                var25 = BoundingBox2D.plane;
                                             }
                                          }
                                       }
                                    }
                                 }

                                 if(UrlRequest.localPlayer.x >= 0 && UrlRequest.localPlayer.y >= 0 && UrlRequest.localPlayer.x < 13312 && UrlRequest.localPlayer.y < 13312) {
                                    if((class61.tileSettings[BoundingBox2D.plane][UrlRequest.localPlayer.x >> 7][UrlRequest.localPlayer.y >> 7] & 4) != 0) {
                                       var25 = BoundingBox2D.plane;
                                    }

                                    var24 = var25;
                                 } else {
                                    var24 = BoundingBox2D.plane;
                                 }
                              }
                           }

                           var23 = var24;
                        } else {
                           if(class2.preferences.hideRoofs) {
                              var24 = BoundingBox2D.plane;
                           } else {
                              var25 = WorldMapType2.getTileHeight(MouseInput.cameraX, GZipDecompressor.cameraY, BoundingBox2D.plane);
                              if(var25 - GrandExchangeEvent.cameraZ < 800 && (class61.tileSettings[BoundingBox2D.plane][MouseInput.cameraX >> 7][GZipDecompressor.cameraY >> 7] & 4) != 0) {
                                 var24 = BoundingBox2D.plane;
                              } else {
                                 var24 = 3;
                              }
                           }

                           var23 = var24;
                        }

                        var24 = MouseInput.cameraX;
                        var25 = GrandExchangeEvent.cameraZ;
                        var26 = GZipDecompressor.cameraY;
                        var27 = class160.cameraPitch;
                        var28 = class240.cameraYaw;

                        for(var29 = 0; var29 < 5; ++var29) {
                           if(Client.field1075[var29]) {
                              var30 = (int)(Math.random() * (double)(Client.field1076[var29] * 2 + 1) - (double)Client.field1076[var29] + Math.sin((double)Client.field1078[var29] / 100.0D * (double)Client.field1079[var29]) * (double)Client.field1077[var29]);
                              if(var29 == 0) {
                                 MouseInput.cameraX += var30;
                              }

                              if(var29 == 1) {
                                 GrandExchangeEvent.cameraZ += var30;
                              }

                              if(var29 == 2) {
                                 GZipDecompressor.cameraY += var30;
                              }

                              if(var29 == 3) {
                                 class240.cameraYaw = var30 + class240.cameraYaw & 2047;
                              }

                              if(var29 == 4) {
                                 class160.cameraPitch += var30;
                                 if(class160.cameraPitch < 128) {
                                    class160.cameraPitch = 128;
                                 }

                                 if(class160.cameraPitch > 383) {
                                    class160.cameraPitch = 383;
                                 }
                              }
                           }
                        }

                        var29 = MouseInput.field679;
                        var30 = MouseInput.field682 * -469125321;
                        if(MouseInput.mouseLastButton != 0) {
                           var29 = MouseInput.mouseLastPressedX;
                           var30 = MouseInput.mouseLastPressedY;
                        }

                        if(var29 >= var19 && var29 < var19 + var21 && var30 >= var20 && var30 < var22 + var20) {
                           var31 = var29 - var19;
                           var32 = var30 - var20;
                           class133.Viewport_mouseX = var31;
                           class133.Viewport_mouseY = var32;
                           class133.Viewport_containsMouse = true;
                           class133.Viewport_entityCountAtMouse = 0;
                           class133.Viewport_false0 = false;
                        } else {
                           class133.Viewport_containsMouse = false;
                           class133.Viewport_entityCountAtMouse = 0;
                        }

                        NPC.method1648();
                        Rasterizer2D.Rasterizer2D_fillRectangle(var19, var20, var21, var22, 0);
                        NPC.method1648();
                        var31 = Graphics3D.Rasterizer3D_zoom;
                        Graphics3D.Rasterizer3D_zoom = Client.scale;
                        class48.region.draw(MouseInput.cameraX, GrandExchangeEvent.cameraZ, GZipDecompressor.cameraY, class160.cameraPitch, class240.cameraYaw, var23);

                        while(true) {
                           BoundingBox var49 = (BoundingBox)class7.boundingBoxes.removeLast();
                           if(var49 == null) {
                              Graphics3D.Rasterizer3D_zoom = var31;
                              NPC.method1648();
                              class48.region.clearEntities();
                              Client.field921 = 0;
                              boolean var60 = false;
                              var33 = -1;
                              var34 = class94.playerIndexesCount;
                              int[] var50 = class94.playerIndices;

                              for(var36 = 0; var36 < var34 + Client.npcIndexesCount; ++var36) {
                                 Object var37;
                                 if(var36 < var34) {
                                    var37 = Client.cachedPlayers[var50[var36]];
                                    if(var50[var36] == Client.field957) {
                                       var60 = true;
                                       var33 = var36;
                                       continue;
                                    }
                                 } else {
                                    var37 = Client.cachedNPCs[Client.npcIndices[var36 - var34]];
                                 }

                                 SceneComposition.method168((Actor)var37, var36, var19, var20, var21, var22);
                              }

                              if(var60) {
                                 SceneComposition.method168(Client.cachedPlayers[Client.field957], var33, var19, var20, var21, var22);
                              }

                              for(var36 = 0; var36 < Client.field921; ++var36) {
                                 var51 = Client.field923[var36];
                                 var38 = Client.field924[var36];
                                 var39 = Client.field926[var36];
                                 var40 = Client.field925[var36];
                                 boolean var62 = true;

                                 while(var62) {
                                    var62 = false;

                                    for(var42 = 0; var42 < var36; ++var42) {
                                       if(var38 + 2 > Client.field924[var42] - Client.field925[var42] && var38 - var40 < Client.field924[var42] + 2 && var51 - var39 < Client.field926[var42] + Client.field923[var42] && var51 + var39 > Client.field923[var42] - Client.field926[var42] && Client.field924[var42] - Client.field925[var42] < var38) {
                                          var38 = Client.field924[var42] - Client.field925[var42];
                                          var62 = true;
                                       }
                                    }
                                 }

                                 Client.screenY = Client.field923[var36];
                                 Client.screenX = Client.field924[var36] = var38;
                                 String var52 = Client.field997[var36];
                                 if(Client.field990 == 0) {
                                    var43 = 16776960;
                                    if(Client.field927[var36] < 6) {
                                       var43 = Client.field1043[Client.field927[var36]];
                                    }

                                    if(Client.field927[var36] == 6) {
                                       var43 = Client.field932 % 20 < 10?16711680:16776960;
                                    }

                                    if(Client.field927[var36] == 7) {
                                       var43 = Client.field932 % 20 < 10?255:'\uffff';
                                    }

                                    if(Client.field927[var36] == 8) {
                                       var43 = Client.field932 % 20 < 10?'뀀':8454016;
                                    }

                                    if(Client.field927[var36] == 9) {
                                       var44 = 150 - Client.field929[var36];
                                       if(var44 < 50) {
                                          var43 = var44 * 1280 + 16711680;
                                       } else if(var44 < 100) {
                                          var43 = 16776960 - (var44 - 50) * 327680;
                                       } else if(var44 < 150) {
                                          var43 = (var44 - 100) * 5 + 65280;
                                       }
                                    }

                                    if(Client.field927[var36] == 10) {
                                       var44 = 150 - Client.field929[var36];
                                       if(var44 < 50) {
                                          var43 = var44 * 5 + 16711680;
                                       } else if(var44 < 100) {
                                          var43 = 16711935 - (var44 - 50) * 327680;
                                       } else if(var44 < 150) {
                                          var43 = (var44 - 100) * 327680 + 255 - (var44 - 100) * 5;
                                       }
                                    }

                                    if(Client.field927[var36] == 11) {
                                       var44 = 150 - Client.field929[var36];
                                       if(var44 < 50) {
                                          var43 = 16777215 - var44 * 327685;
                                       } else if(var44 < 100) {
                                          var43 = (var44 - 50) * 327685 + 65280;
                                       } else if(var44 < 150) {
                                          var43 = 16777215 - (var44 - 100) * 327680;
                                       }
                                    }

                                    if(Client.field900[var36] == 0) {
                                       Friend.fontBold12.method4884(var52, var19 + Client.screenY, var20 + Client.screenX, var43, 0);
                                    }

                                    if(Client.field900[var36] == 1) {
                                       Friend.fontBold12.method4937(var52, var19 + Client.screenY, var20 + Client.screenX, var43, 0, Client.field932);
                                    }

                                    if(Client.field900[var36] == 2) {
                                       Friend.fontBold12.method4890(var52, var19 + Client.screenY, var20 + Client.screenX, var43, 0, Client.field932);
                                    }

                                    if(Client.field900[var36] == 3) {
                                       Friend.fontBold12.method4898(var52, var19 + Client.screenY, var20 + Client.screenX, var43, 0, Client.field932, 150 - Client.field929[var36]);
                                    }

                                    if(Client.field900[var36] == 4) {
                                       var44 = (150 - Client.field929[var36]) * (Friend.fontBold12.method4886(var52) + 100) / 150;
                                       Rasterizer2D.setInnerDrawRegion(var19 + Client.screenY - 50, var20, var19 + Client.screenY + 50, var20 + var22);
                                       Friend.fontBold12.method4891(var52, var19 + Client.screenY + 50 - var44, var20 + Client.screenX, var43, 0);
                                       Rasterizer2D.setDrawRegion(var19, var20, var19 + var21, var20 + var22);
                                    }

                                    if(Client.field900[var36] == 5) {
                                       var44 = 150 - Client.field929[var36];
                                       var45 = 0;
                                       if(var44 < 25) {
                                          var45 = var44 - 25;
                                       } else if(var44 > 125) {
                                          var45 = var44 - 125;
                                       }

                                       Rasterizer2D.setInnerDrawRegion(var19, var20 + Client.screenX - Friend.fontBold12.verticalSpace - 1, var19 + var21, var20 + Client.screenX + 5);
                                       Friend.fontBold12.method4884(var52, var19 + Client.screenY, var45 + var20 + Client.screenX, var43, 0);
                                       Rasterizer2D.setDrawRegion(var19, var20, var21 + var19, var22 + var20);
                                    }
                                 } else {
                                    Friend.fontBold12.method4884(var52, var19 + Client.screenY, var20 + Client.screenX, 16776960, 0);
                                 }
                              }

                              class21.method154(var19, var20);
                              ((TextureProvider)Graphics3D.textureLoader).method2393(Client.field847);
                              if(Client.cursorState == 1) {
                                 Size.crossSprites[Client.field1092 / 100].drawAt(Client.field1003 - 8, Client.field936 - 8);
                              }

                              if(Client.cursorState == 2) {
                                 Size.crossSprites[Client.field1092 / 100 + 4].drawAt(Client.field1003 - 8, Client.field936 - 8);
                              }

                              Coordinates.method4077();
                              MouseInput.cameraX = var24;
                              GrandExchangeEvent.cameraZ = var25;
                              GZipDecompressor.cameraY = var26;
                              class160.cameraPitch = var27;
                              class240.cameraYaw = var28;
                              if(Client.field853) {
                                 byte var61 = 0;
                                 var33 = var61 + class249.NetCache_pendingPriorityResponsesCount + class249.NetCache_pendingPriorityWritesCount;
                                 if(var33 == 0) {
                                    Client.field853 = false;
                                 }
                              }

                              if(Client.field853) {
                                 Rasterizer2D.Rasterizer2D_fillRectangle(var19, var20, var21, var22, 0);
                                 class185.drawStatusBox("Loading - please wait.", false);
                              }

                              Client.field1033[var10.boundsIndex] = true;
                              Rasterizer2D.setDrawRegion(var2, var3, var4, var5);
                              continue label1611;
                           }

                           var49.draw();
                        }
                     }

                     if(var10.contentType == 1338) {
                        UnitPriceComparator.method126(var10, var12, var13, var11);
                        Rasterizer2D.setDrawRegion(var2, var3, var4, var5);
                        continue;
                     }

                     if(var10.contentType == 1339) {
                        SpritePixels2 var66 = var10.method4148(false);
                        if(var66 != null) {
                           if(Client.field1062 < 3) {
                              GrandExchangeEvent.compass.method5216(var12, var13, var66.field2715, var66.field2716, 25, 25, Client.mapAngle, 256, var66.field2717, var66.field2714);
                           } else {
                              Rasterizer2D.method5104(var12, var13, 0, var66.field2717, var66.field2714);
                           }
                        }

                        Rasterizer2D.setDrawRegion(var2, var3, var4, var5);
                        continue;
                     }

                     if(var10.contentType == 1400) {
                        class61.renderOverview.extractWorldmap(var12, var13, var10.width, var10.height, Client.gameCycle);
                     }

                     if(var10.contentType == 1401) {
                        class61.renderOverview.extractData(var12, var13, var10.width, var10.height);
                     }
                  }

                  if(var10.type == 0) {
                     if(!var10.hasScript && Occluder.method2905(var10) && var10 != class29.field391) {
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

                     WidgetNode var46 = (WidgetNode)Client.componentTable.get((long)var10.id);
                     if(var46 != null) {
                        class61.method1018(var46.id, var15, var16, var17, var18, var12, var13, var11);
                     }

                     Rasterizer2D.setDrawRegion(var2, var3, var4, var5);
                     Graphics3D.Rasterizer3D_method1();
                  }

                  if(Client.isResized || Client.field970[var11] || Client.gameDrawingMode > 1) {
                     if(var10.type == 0 && !var10.hasScript && var10.scrollHeight > var10.height) {
                        var19 = var12 + var10.width;
                        var20 = var10.scrollY;
                        var21 = var10.height;
                        var22 = var10.scrollHeight;
                        WallObject.scrollbarSprites[0].method5176(var19, var13);
                        WallObject.scrollbarSprites[1].method5176(var19, var21 + var13 - 16);
                        Rasterizer2D.Rasterizer2D_fillRectangle(var19, var13 + 16, 16, var21 - 32, Client.field905);
                        var23 = var21 * (var21 - 32) / var22;
                        if(var23 < 8) {
                           var23 = 8;
                        }

                        var24 = var20 * (var21 - 32 - var23) / (var22 - var21);
                        Rasterizer2D.Rasterizer2D_fillRectangle(var19, var24 + var13 + 16, 16, var23, Client.field906);
                        Rasterizer2D.method5100(var19, var24 + var13 + 16, var23, Client.field908);
                        Rasterizer2D.method5100(var19 + 1, var13 + var24 + 16, var23, Client.field908);
                        Rasterizer2D.method5098(var19, var13 + var24 + 16, 16, Client.field908);
                        Rasterizer2D.method5098(var19, var13 + var24 + 17, 16, Client.field908);
                        Rasterizer2D.method5100(var19 + 15, var24 + var13 + 16, var23, Client.field907);
                        Rasterizer2D.method5100(var19 + 14, var24 + var13 + 17, var23 - 1, Client.field907);
                        Rasterizer2D.method5098(var19, var23 + var24 + var13 + 15, 16, Client.field907);
                        Rasterizer2D.method5098(var19 + 1, var23 + var13 + var24 + 14, 15, Client.field907);
                     }

                     if(var10.type != 1) {
                        if(var10.type == 2) {
                           var19 = 0;

                           for(var20 = 0; var20 < var10.field2817; ++var20) {
                              for(var21 = 0; var21 < var10.originalWidth; ++var21) {
                                 var22 = var12 + var21 * (var10.paddingX + 32);
                                 var23 = var20 * (var10.paddingY + 32) + var13;
                                 if(var19 < 20) {
                                    var22 += var10.xSprites[var19];
                                    var23 += var10.field2828[var19];
                                 }

                                 if(var10.itemIds[var19] <= 0) {
                                    if(var10.field2829 != null && var19 < 20) {
                                       SpritePixels var71 = var10.method4173(var19);
                                       if(var71 != null) {
                                          var71.drawAt(var22, var23);
                                       } else if(Widget.field2780) {
                                          class33.method344(var10);
                                       }
                                    }
                                 } else {
                                    boolean var58 = false;
                                    boolean var59 = false;
                                    var26 = var10.itemIds[var19] - 1;
                                    if(var22 + 32 > var2 && var22 < var4 && var23 + 32 > var3 && var23 < var5 || var10 == AreaMapIconMetadata.field506 && var19 == Client.field1073) {
                                       SpritePixels var55;
                                       if(Client.itemSelectionState == 1 && var19 == class36.selectedItemIndex && var10.id == GEItemNameComparator.field304) {
                                          var55 = class1.createSprite(var26, var10.itemQuantities[var19], 2, 0, 2, false);
                                       } else {
                                          var55 = class1.createSprite(var26, var10.itemQuantities[var19], 1, 3153952, 2, false);
                                       }

                                       if(var55 != null) {
                                          if(var10 == AreaMapIconMetadata.field506 && var19 == Client.field1073) {
                                             var24 = MouseInput.field679 - Client.field857;
                                             var25 = MouseInput.field682 * -469125321 - Client.field1039;
                                             if(var24 < 5 && var24 > -5) {
                                                var24 = 0;
                                             }

                                             if(var25 < 5 && var25 > -5) {
                                                var25 = 0;
                                             }

                                             if(Client.field1082 < 5) {
                                                var24 = 0;
                                                var25 = 0;
                                             }

                                             var55.method5211(var22 + var24, var23 + var25, 128);
                                             if(var1 != -1) {
                                                Widget var56 = var0[var1 & 65535];
                                                if(var23 + var25 < Rasterizer2D.drawingAreaTop && var56.scrollY > 0) {
                                                   var29 = (Rasterizer2D.drawingAreaTop - var23 - var25) * Client.field847 / 3;
                                                   if(var29 > Client.field847 * 10) {
                                                      var29 = Client.field847 * 10;
                                                   }

                                                   if(var29 > var56.scrollY) {
                                                      var29 = var56.scrollY;
                                                   }

                                                   var56.scrollY -= var29;
                                                   Client.field1039 += var29;
                                                   class33.method344(var56);
                                                }

                                                if(var23 + var25 + 32 > Rasterizer2D.drawingAreaRight && var56.scrollY < var56.scrollHeight - var56.height) {
                                                   var29 = (var25 + var23 + 32 - Rasterizer2D.drawingAreaRight) * Client.field847 / 3;
                                                   if(var29 > Client.field847 * 10) {
                                                      var29 = Client.field847 * 10;
                                                   }

                                                   if(var29 > var56.scrollHeight - var56.height - var56.scrollY) {
                                                      var29 = var56.scrollHeight - var56.height - var56.scrollY;
                                                   }

                                                   var56.scrollY += var29;
                                                   Client.field1039 -= var29;
                                                   class33.method344(var56);
                                                }
                                             }
                                          } else if(var10 == Friend.field742 && var19 == Client.field940) {
                                             var55.method5211(var22, var23, 128);
                                          } else {
                                             var55.drawAt(var22, var23);
                                          }
                                       } else {
                                          class33.method344(var10);
                                       }
                                    }
                                 }

                                 ++var19;
                              }
                           }
                        } else if(var10.type == 3) {
                           if(ClanMember.method1117(var10)) {
                              var19 = var10.field2785;
                              if(var10 == class29.field391 && var10.field2787 != 0) {
                                 var19 = var10.field2787;
                              }
                           } else {
                              var19 = var10.textColor;
                              if(var10 == class29.field391 && var10.field2786 != 0) {
                                 var19 = var10.field2786;
                              }
                           }

                           if(var10.filled) {
                              switch(var10.field2789.field3842) {
                              case 1:
                                 Rasterizer2D.method5090(var12, var13, var10.width, var10.height, var10.textColor, var10.field2785, 256 - (var10.opacity & 255), 256 - (var10.field2874 & 255));
                                 break;
                              case 2:
                                 Rasterizer2D.method5132(var12, var13, var10.width, var10.height, var10.textColor, var10.field2785, 256 - (var10.opacity & 255), 256 - (var10.field2874 & 255));
                                 break;
                              case 3:
                                 Rasterizer2D.method5109(var12, var13, var10.width, var10.height, var10.textColor, var10.field2785, 256 - (var10.opacity & 255), 256 - (var10.field2874 & 255));
                                 break;
                              case 4:
                                 Rasterizer2D.method5101(var12, var13, var10.width, var10.height, var10.textColor, var10.field2785, 256 - (var10.opacity & 255), 256 - (var10.field2874 & 255));
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
                                 if(Widget.field2780) {
                                    class33.method344(var10);
                                 }
                              } else {
                                 String var68 = var10.text;
                                 if(ClanMember.method1117(var10)) {
                                    var20 = var10.field2785;
                                    if(var10 == class29.field391 && var10.field2787 != 0) {
                                       var20 = var10.field2787;
                                    }

                                    if(var10.string1.length() > 0) {
                                       var68 = var10.string1;
                                    }
                                 } else {
                                    var20 = var10.textColor;
                                    if(var10 == class29.field391 && var10.field2786 != 0) {
                                       var20 = var10.field2786;
                                    }
                                 }

                                 if(var10.hasScript && var10.itemId != -1) {
                                    ItemComposition var69 = KitDefinition.getItemDefinition(var10.itemId);
                                    var68 = var69.name;
                                    if(var68 == null) {
                                       var68 = "null";
                                    }

                                    if((var69.isStackable == 1 || var10.itemQuantity != 1) && var10.itemQuantity != -1) {
                                       var68 = Buffer.getColTags(16748608) + var68 + "</col>" + " " + 'x' + class61.method1015(var10.itemQuantity);
                                    }
                                 }

                                 if(var10 == Client.field958) {
                                    Object var10000 = null;
                                    var68 = "Please wait...";
                                    var20 = var10.textColor;
                                 }

                                 if(!var10.hasScript) {
                                    var68 = UnitPriceComparator.method115(var68, var10);
                                 }

                                 var63.method4895(var68, var12, var13, var10.width, var10.height, var20, var10.textShadowed?0:-1, var10.field2814, var10.field2823, var10.field2821);
                              }
                           } else if(var10.type == 5) {
                              SpritePixels var64;
                              if(!var10.hasScript) {
                                 var64 = var10.method4144(ClanMember.method1117(var10));
                                 if(var64 != null) {
                                    var64.drawAt(var12, var13);
                                 } else if(Widget.field2780) {
                                    class33.method344(var10);
                                 }
                              } else {
                                 if(var10.itemId != -1) {
                                    var64 = class1.createSprite(var10.itemId, var10.itemQuantity, var10.borderThickness, var10.sprite2, var10.field2866, false);
                                 } else {
                                    var64 = var10.method4144(false);
                                 }

                                 if(var64 == null) {
                                    if(Widget.field2780) {
                                       class33.method344(var10);
                                    }
                                 } else {
                                    var20 = var64.maxWidth;
                                    var21 = var64.maxHeight;
                                    if(!var10.spriteTiling) {
                                       var22 = var10.width * 4096 / var20;
                                       if(var10.textureId != 0) {
                                          var64.method5218(var10.width / 2 + var12, var10.height / 2 + var13, var10.textureId, var22);
                                       } else if(var14 != 0) {
                                          var64.method5213(var12, var13, var10.width, var10.height, 256 - (var14 & 255));
                                       } else if(var20 == var10.width && var21 == var10.height) {
                                          var64.drawAt(var12, var13);
                                       } else {
                                          var64.method5207(var12, var13, var10.width, var10.height);
                                       }
                                    } else {
                                       Rasterizer2D.setInnerDrawRegion(var12, var13, var12 + var10.width, var13 + var10.height);
                                       var22 = (var20 - 1 + var10.width) / var20;
                                       var23 = (var21 - 1 + var10.height) / var21;

                                       for(var24 = 0; var24 < var22; ++var24) {
                                          for(var25 = 0; var25 < var23; ++var25) {
                                             if(var10.textureId != 0) {
                                                var64.method5218(var20 / 2 + var12 + var24 * var20, var21 / 2 + var13 + var21 * var25, var10.textureId, 4096);
                                             } else if(var14 != 0) {
                                                var64.method5211(var12 + var20 * var24, var13 + var21 * var25, 256 - (var14 & 255));
                                             } else {
                                                var64.drawAt(var12 + var20 * var24, var13 + var25 * var21);
                                             }
                                          }
                                       }

                                       Rasterizer2D.setDrawRegion(var2, var3, var4, var5);
                                    }
                                 }
                              }
                           } else {
                              ItemComposition var53;
                              if(var10.type == 6) {
                                 boolean var57 = ClanMember.method1117(var10);
                                 if(var57) {
                                    var20 = var10.field2807;
                                 } else {
                                    var20 = var10.field2806;
                                 }

                                 Model var65 = null;
                                 var22 = 0;
                                 if(var10.itemId != -1) {
                                    var53 = KitDefinition.getItemDefinition(var10.itemId);
                                    if(var53 != null) {
                                       var53 = var53.method4716(var10.itemQuantity);
                                       var65 = var53.getModel(1);
                                       if(var65 != null) {
                                          var65.calculateBoundsCylinder();
                                          var22 = var65.modelHeight / 2;
                                       } else {
                                          class33.method344(var10);
                                       }
                                    }
                                 } else if(var10.modelType == 5) {
                                    if(var10.modelId == 0) {
                                       var65 = Client.field1090.getModel((Sequence)null, -1, (Sequence)null, -1);
                                    } else {
                                       var65 = UrlRequest.localPlayer.getModel();
                                    }
                                 } else if(var20 == -1) {
                                    var65 = var10.getModel((Sequence)null, -1, var57, UrlRequest.localPlayer.composition);
                                    if(var65 == null && Widget.field2780) {
                                       class33.method344(var10);
                                    }
                                 } else {
                                    Sequence var72 = Permission.getAnimation(var20);
                                    var65 = var10.getModel(var72, var10.field2881, var57, UrlRequest.localPlayer.composition);
                                    if(var65 == null && Widget.field2780) {
                                       class33.method344(var10);
                                    }
                                 }

                                 Graphics3D.method2607(var10.width / 2 + var12, var10.height / 2 + var13);
                                 var23 = Graphics3D.SINE[var10.rotationX] * var10.modelZoom >> 16;
                                 var24 = Graphics3D.COSINE[var10.rotationX] * var10.modelZoom >> 16;
                                 if(var65 != null) {
                                    if(!var10.hasScript) {
                                       var65.method2526(0, var10.rotationZ, 0, var10.rotationX, 0, var23, var24);
                                    } else {
                                       var65.calculateBoundsCylinder();
                                       if(var10.field2795) {
                                          var65.method2527(0, var10.rotationZ, var10.rotationY, var10.rotationX, var10.field2808, var22 + var23 + var10.field2809, var24 + var10.field2809, var10.modelZoom);
                                       } else {
                                          var65.method2526(0, var10.rotationZ, var10.rotationY, var10.rotationX, var10.field2808, var23 + var22 + var10.field2809, var24 + var10.field2809);
                                       }
                                    }
                                 }

                                 Graphics3D.Rasterizer3D_method3();
                              } else {
                                 if(var10.type == 7) {
                                    var63 = var10.getFont();
                                    if(var63 == null) {
                                       if(Widget.field2780) {
                                          class33.method344(var10);
                                       }
                                       continue;
                                    }

                                    var20 = 0;

                                    for(var21 = 0; var21 < var10.field2817; ++var21) {
                                       for(var22 = 0; var22 < var10.originalWidth; ++var22) {
                                          if(var10.itemIds[var20] > 0) {
                                             var53 = KitDefinition.getItemDefinition(var10.itemIds[var20] - 1);
                                             String var54;
                                             if(var53.isStackable != 1 && var10.itemQuantities[var20] == 1) {
                                                var54 = Buffer.getColTags(16748608) + var53.name + "</col>";
                                             } else {
                                                var54 = Buffer.getColTags(16748608) + var53.name + "</col>" + " " + 'x' + class61.method1015(var10.itemQuantities[var20]);
                                             }

                                             var25 = var22 * (var10.paddingX + 115) + var12;
                                             var26 = var13 + (var10.paddingY + 12) * var21;
                                             if(var10.field2814 == 0) {
                                                var63.method4891(var54, var25, var26, var10.textColor, var10.textShadowed?0:-1);
                                             } else if(var10.field2814 == 1) {
                                                var63.method4884(var54, var10.width / 2 + var25, var26, var10.textColor, var10.textShadowed?0:-1);
                                             } else {
                                                var63.drawString(var54, var25 + var10.width - 1, var26, var10.textColor, var10.textShadowed?0:-1);
                                             }
                                          }

                                          ++var20;
                                       }
                                    }
                                 }

                                 if(var10.type == 8 && var10 == ContextMenuRow.field1299 && Client.field980 == Client.field979) {
                                    var19 = 0;
                                    var20 = 0;
                                    Font var47 = BaseVarType.font_p12full;
                                    String var48 = var10.text;

                                    String var70;
                                    for(var48 = UnitPriceComparator.method115(var48, var10); var48.length() > 0; var20 = var20 + var47.verticalSpace + 1) {
                                       var24 = var48.indexOf("<br>");
                                       if(var24 != -1) {
                                          var70 = var48.substring(0, var24);
                                          var48 = var48.substring(var24 + 4);
                                       } else {
                                          var70 = var48;
                                          var48 = "";
                                       }

                                       var25 = var47.method4886(var70);
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

                                    if(var20 + var25 > var5) {
                                       var25 = var5 - var20;
                                    }

                                    Rasterizer2D.Rasterizer2D_fillRectangle(var24, var25, var19, var20, 16777120);
                                    Rasterizer2D.drawRectangle(var24, var25, var19, var20, 0);
                                    var48 = var10.text;
                                    var26 = var25 + var47.verticalSpace + 2;

                                    for(var48 = UnitPriceComparator.method115(var48, var10); var48.length() > 0; var26 = var26 + var47.verticalSpace + 1) {
                                       var27 = var48.indexOf("<br>");
                                       if(var27 != -1) {
                                          var70 = var48.substring(0, var27);
                                          var48 = var48.substring(var27 + 4);
                                       } else {
                                          var70 = var48;
                                          var48 = "";
                                       }

                                       var47.method4891(var70, var24 + 3, var26, 0, -1);
                                    }
                                 }

                                 if(var10.type == 9) {
                                    if(var10.field2844) {
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
                                          var51 = var26 * var32 + 1 >> 17;
                                          var23 = var19 - Rasterizer2D.draw_region_x;
                                          var24 = var20 - Rasterizer2D.drawingAreaTop;
                                          var38 = var23 + var34;
                                          var39 = var23 - var35;
                                          var40 = var23 + var27 - var35;
                                          int var41 = var34 + var23 + var27;
                                          var42 = var24 + var36;
                                          var43 = var24 - var51;
                                          var44 = var28 + var24 - var51;
                                          var45 = var36 + var24 + var28;
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
}
