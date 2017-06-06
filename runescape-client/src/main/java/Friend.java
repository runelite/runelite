import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("by")
@Implements("Friend")
public class Friend {
   @ObfuscatedName("i")
   @Export("name")
   String name;
   @ObfuscatedName("c")
   @Export("previousName")
   String previousName;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -1041427113
   )
   @Export("world")
   int world;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 1990179491
   )
   @Export("rank")
   int rank;
   @ObfuscatedName("y")
   boolean field818;
   @ObfuscatedName("f")
   static int[][] field819;
   @ObfuscatedName("b")
   boolean field822;

   @ObfuscatedName("hb")
   @ObfuscatedSignature(
      signature = "([LWidget;IIIIIIIII)V",
      garbageValue = "182389913"
   )
   @Export("gameDraw")
   static final void gameDraw(Widget[] var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
      Rasterizer2D.method4940(var2, var3, var4, var5);
      class136.method2595();

      for(int var9 = 0; var9 < var0.length; ++var9) {
         Widget var10 = var0[var9];
         if(var10 != null && (var1 == var10.parentId || var1 == -1412584499 && var10 == Client.field1164)) {
            int var11;
            if(var8 == -1) {
               Client.widgetPositionX[Client.field1133] = var10.relativeX + var6;
               Client.widgetPositionY[Client.field1133] = var10.relativeY + var7;
               Client.widgetBoundsWidth[Client.field1133] = var10.width;
               Client.widgetBoundsHeight[Client.field1133] = var10.height;
               var11 = ++Client.field1133 - 1;
            } else {
               var11 = var8;
            }

            var10.boundsIndex = var11;
            var10.field2754 = Client.gameCycle;
            if(!var10.hasScript || !class89.method1700(var10)) {
               int var12;
               if(var10.contentType > 0) {
                  var12 = var10.contentType;
                  if(var12 == 324) {
                     if(Client.field1202 == -1) {
                        Client.field1202 = var10.spriteId;
                        Client.field962 = var10.field2662;
                     }

                     if(Client.field1201.isFemale) {
                        var10.spriteId = Client.field1202;
                     } else {
                        var10.spriteId = Client.field962;
                     }
                  } else if(var12 == 325) {
                     if(Client.field1202 == -1) {
                        Client.field1202 = var10.spriteId;
                        Client.field962 = var10.field2662;
                     }

                     if(Client.field1201.isFemale) {
                        var10.spriteId = Client.field962;
                     } else {
                        var10.spriteId = Client.field1202;
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

               var12 = var6 + var10.relativeX;
               int var13 = var10.relativeY + var7;
               int var14 = var10.opacity;
               int var15;
               int var16;
               if(var10 == Client.field1164) {
                  if(var1 != -1412584499 && !var10.field2780) {
                     class158.field2287 = var0;
                     class225.field3134 = var6;
                     WorldMapData.field463 = var7;
                     continue;
                  }

                  if(Client.field1114 && Client.field1108) {
                     var15 = class59.field737;
                     var16 = class59.field738;
                     var15 -= Client.field1105;
                     var16 -= Client.field1141;
                     if(var15 < Client.field1063) {
                        var15 = Client.field1063;
                     }

                     if(var10.width + var15 > Client.field1063 + Client.field1104.width) {
                        var15 = Client.field1104.width + Client.field1063 - var10.width;
                     }

                     if(var16 < Client.field1146) {
                        var16 = Client.field1146;
                     }

                     if(var10.height + var16 > Client.field1146 + Client.field1104.height) {
                        var16 = Client.field1104.height + Client.field1146 - var10.height;
                     }

                     var12 = var15;
                     var13 = var16;
                  }

                  if(!var10.field2780) {
                     var14 = 128;
                  }
               }

               int var17;
               int var18;
               int var19;
               int var20;
               int var31;
               int var32;
               if(var10.type == 2) {
                  var15 = var2;
                  var16 = var3;
                  var17 = var4;
                  var18 = var5;
               } else if(var10.type == 9) {
                  var19 = var12;
                  var20 = var13;
                  var32 = var12 + var10.width;
                  var31 = var10.height + var13;
                  if(var32 < var12) {
                     var19 = var32;
                     var32 = var12;
                  }

                  if(var31 < var13) {
                     var20 = var31;
                     var31 = var13;
                  }

                  ++var32;
                  ++var31;
                  var15 = var19 > var2?var19:var2;
                  var16 = var20 > var3?var20:var3;
                  var17 = var32 < var4?var32:var4;
                  var18 = var31 < var5?var31:var5;
               } else {
                  var19 = var10.width + var12;
                  var20 = var10.height + var13;
                  var15 = var12 > var2?var12:var2;
                  var16 = var13 > var3?var13:var3;
                  var17 = var19 < var4?var19:var4;
                  var18 = var20 < var5?var20:var5;
               }

               if(!var10.hasScript || var15 < var17 && var16 < var18) {
                  if(var10.contentType != 0) {
                     if(var10.contentType == 1336) {
                        if(Client.field943) {
                           var13 += 15;
                           class33.field473.method4758("Fps:" + GameEngine.FPS, var10.width + var12, var13, 16776960, -1);
                           var13 += 15;
                           Runtime var44 = Runtime.getRuntime();
                           var20 = (int)((var44.totalMemory() - var44.freeMemory()) / 1024L);
                           var32 = 16776960;
                           if(var20 > '耀' && Client.field1046) {
                              var32 = 16711680;
                           }

                           if(var20 > 65536 && !Client.field1046) {
                              var32 = 16711680;
                           }

                           class33.field473.method4758("Mem:" + var20 + "k", var12 + var10.width, var13, var32, -1);
                           var13 += 15;
                        }
                        continue;
                     }

                     if(var10.contentType == 1337) {
                        Client.field1079 = var12;
                        Client.field1080 = var13;
                        class61.method1047(var12, var13, var10.width, var10.height);
                        Client.field1135[var10.boundsIndex] = true;
                        Rasterizer2D.method4940(var2, var3, var4, var5);
                        continue;
                     }

                     if(var10.contentType == 1338) {
                        class76.method1505(var10, var12, var13, var11);
                        Rasterizer2D.method4940(var2, var3, var4, var5);
                        continue;
                     }

                     if(var10.contentType == 1339) {
                        class51.method758(var10, var12, var13, var11);
                        Rasterizer2D.method4940(var2, var3, var4, var5);
                        continue;
                     }

                     if(var10.contentType == 1400) {
                        class1.field14.extractWorldmap(var12, var13, var10.width, var10.height, Client.gameCycle);
                     }

                     if(var10.contentType == 1401) {
                        class1.field14.extractData(var12, var13, var10.width, var10.height);
                     }
                  }

                  if(var10.type == 0) {
                     if(!var10.hasScript && class89.method1700(var10) && WorldMapType1.field434 != var10) {
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

                     WidgetNode var30 = (WidgetNode)Client.componentTable.method3520((long)var10.id);
                     if(var30 != null) {
                        class36.method481(var30.id, var15, var16, var17, var18, var12, var13, var11);
                     }

                     Rasterizer2D.method4940(var2, var3, var4, var5);
                     class136.method2595();
                  }

                  if(Client.isResized || Client.field1040[var11] || Client.field1161 > 1) {
                     if(var10.type == 0 && !var10.hasScript && var10.scrollHeight > var10.height) {
                        class123.method2338(var12 + var10.width, var13, var10.scrollY, var10.height, var10.scrollHeight);
                     }

                     if(var10.type != 1) {
                        int var23;
                        int var24;
                        int var25;
                        int var26;
                        if(var10.type == 2) {
                           var19 = 0;

                           for(var20 = 0; var20 < var10.field2640; ++var20) {
                              for(var32 = 0; var32 < var10.originalWidth; ++var32) {
                                 var31 = var12 + var32 * (var10.paddingX + 32);
                                 var23 = var20 * (var10.paddingY + 32) + var13;
                                 if(var19 < 20) {
                                    var31 += var10.field2719[var19];
                                    var23 += var10.field2720[var19];
                                 }

                                 if(var10.itemIds[var19] <= 0) {
                                    if(var10.field2721 != null && var19 < 20) {
                                       SpritePixels var46 = var10.method3983(var19);
                                       if(var46 != null) {
                                          var46.method5047(var31, var23);
                                       } else if(Widget.field2649) {
                                          class25.method169(var10);
                                       }
                                    }
                                 } else {
                                    boolean var40 = false;
                                    boolean var41 = false;
                                    var26 = var10.itemIds[var19] - 1;
                                    if(var31 + 32 > var2 && var31 < var4 && var23 + 32 > var3 && var23 < var5 || var10 == GroundObject.field1885 && Client.field1043 == var19) {
                                       SpritePixels var27;
                                       if(Client.field1083 == 1 && var19 == IndexFile.field2303 && var10.id == GameObject.field2212) {
                                          var27 = class90.createSprite(var26, var10.itemQuantities[var19], 2, 0, 2, false);
                                       } else {
                                          var27 = class90.createSprite(var26, var10.itemQuantities[var19], 1, 3153952, 2, false);
                                       }

                                       if(var27 != null) {
                                          if(GroundObject.field1885 == var10 && Client.field1043 == var19) {
                                             var24 = class59.field737 - Client.field1044;
                                             var25 = class59.field738 - Client.field1081;
                                             if(var24 < 5 && var24 > -5) {
                                                var24 = 0;
                                             }

                                             if(var25 < 5 && var25 > -5) {
                                                var25 = 0;
                                             }

                                             if(Client.field1205 < 5) {
                                                var24 = 0;
                                                var25 = 0;
                                             }

                                             var27.method5052(var24 + var31, var25 + var23, 128);
                                             if(var1 != -1) {
                                                Widget var28 = var0[var1 & '\uffff'];
                                                int var29;
                                                if(var25 + var23 < Rasterizer2D.field3752 && var28.scrollY > 0) {
                                                   var29 = (Rasterizer2D.field3752 - var23 - var25) * Client.field1119 / 3;
                                                   if(var29 > Client.field1119 * 10) {
                                                      var29 = Client.field1119 * 10;
                                                   }

                                                   if(var29 > var28.scrollY) {
                                                      var29 = var28.scrollY;
                                                   }

                                                   var28.scrollY -= var29;
                                                   Client.field1081 += var29;
                                                   class25.method169(var28);
                                                }

                                                if(var25 + var23 + 32 > Rasterizer2D.field3756 && var28.scrollY < var28.scrollHeight - var28.height) {
                                                   var29 = Client.field1119 * (var23 + var25 + 32 - Rasterizer2D.field3756) / 3;
                                                   if(var29 > Client.field1119 * 10) {
                                                      var29 = Client.field1119 * 10;
                                                   }

                                                   if(var29 > var28.scrollHeight - var28.height - var28.scrollY) {
                                                      var29 = var28.scrollHeight - var28.height - var28.scrollY;
                                                   }

                                                   var28.scrollY += var29;
                                                   Client.field1081 -= var29;
                                                   class25.method169(var28);
                                                }
                                             }
                                          } else if(class47.field614 == var10 && var19 == Client.field1035) {
                                             var27.method5052(var31, var23, 128);
                                          } else {
                                             var27.method5047(var31, var23);
                                          }
                                       } else {
                                          class25.method169(var10);
                                       }
                                    }
                                 }

                                 ++var19;
                              }
                           }
                        } else if(var10.type == 3) {
                           if(class137.method2672(var10)) {
                              var19 = var10.field2708;
                              if(WorldMapType1.field434 == var10 && var10.field2677 != 0) {
                                 var19 = var10.field2677;
                              }
                           } else {
                              var19 = var10.textColor;
                              if(WorldMapType1.field434 == var10 && var10.field2769 != 0) {
                                 var19 = var10.field2769;
                              }
                           }

                           if(var10.field2680) {
                              switch(var10.field2681.field3767) {
                              case 1:
                                 Rasterizer2D.method4975(var12, var13, var10.width, var10.height, var10.textColor, var10.field2708, 256 - (var10.opacity & 255), 256 - (var10.field2683 & 255));
                                 break;
                              case 2:
                                 Rasterizer2D.method4926(var12, var13, var10.width, var10.height, var10.textColor, var10.field2708, 256 - (var10.opacity & 255), 256 - (var10.field2683 & 255));
                                 break;
                              case 3:
                                 Rasterizer2D.method4918(var12, var13, var10.width, var10.height, var10.textColor, var10.field2708, 256 - (var10.opacity & 255), 256 - (var10.field2683 & 255));
                                 break;
                              case 4:
                                 Rasterizer2D.method4916(var12, var13, var10.width, var10.height, var10.textColor, var10.field2708, 256 - (var10.opacity & 255), 256 - (var10.field2683 & 255));
                                 break;
                              default:
                                 if(var14 == 0) {
                                    Rasterizer2D.method4923(var12, var13, var10.width, var10.height, var19);
                                 } else {
                                    Rasterizer2D.method4922(var12, var13, var10.width, var10.height, var19, 256 - (var14 & 255));
                                 }
                              }
                           } else if(var14 == 0) {
                              Rasterizer2D.method4945(var12, var13, var10.width, var10.height, var19);
                           } else {
                              Rasterizer2D.method4964(var12, var13, var10.width, var10.height, var19, 256 - (var14 & 255));
                           }
                        } else {
                           Font var42;
                           if(var10.type == 4) {
                              var42 = var10.method3984();
                              if(var42 == null) {
                                 if(Widget.field2649) {
                                    class25.method169(var10);
                                 }
                              } else {
                                 String var38 = var10.text;
                                 if(class137.method2672(var10)) {
                                    var20 = var10.field2708;
                                    if(var10 == WorldMapType1.field434 && var10.field2677 != 0) {
                                       var20 = var10.field2677;
                                    }

                                    if(var10.field2667.length() > 0) {
                                       var38 = var10.field2667;
                                    }
                                 } else {
                                    var20 = var10.textColor;
                                    if(var10 == WorldMapType1.field434 && var10.field2769 != 0) {
                                       var20 = var10.field2769;
                                    }
                                 }

                                 if(var10.hasScript && var10.itemId != -1) {
                                    ItemComposition var39 = Buffer.getItemDefinition(var10.itemId);
                                    var38 = var39.name;
                                    if(var38 == null) {
                                       var38 = "null";
                                    }

                                    if((var39.isStackable == 1 || var10.itemQuantity != 1) && var10.itemQuantity != -1) {
                                       var38 = WorldMapData.method337(16748608) + var38 + "</col>" + " " + 'x' + Frames.method2877(var10.itemQuantity);
                                    }
                                 }

                                 if(Client.field963 == var10) {
                                    Object var10000 = null;
                                    var38 = "Please wait...";
                                    var20 = var10.textColor;
                                 }

                                 if(!var10.hasScript) {
                                    var38 = class225.method4075(var38, var10);
                                 }

                                 var42.method4745(var38, var12, var13, var10.width, var10.height, var20, var10.field2716?0:-1, var10.field2714, var10.field2715, var10.field2713);
                              }
                           } else if(var10.type == 5) {
                              SpritePixels var43;
                              if(!var10.hasScript) {
                                 var43 = var10.method4017(class137.method2672(var10));
                                 if(var43 != null) {
                                    var43.method5047(var12, var13);
                                 } else if(Widget.field2649) {
                                    class25.method169(var10);
                                 }
                              } else {
                                 if(var10.itemId != -1) {
                                    var43 = class90.createSprite(var10.itemId, var10.itemQuantity, var10.borderThickness, var10.sprite2, var10.field2709, false);
                                 } else {
                                    var43 = var10.method4017(false);
                                 }

                                 if(var43 == null) {
                                    if(Widget.field2649) {
                                       class25.method169(var10);
                                    }
                                 } else {
                                    var20 = var43.maxWidth;
                                    var32 = var43.maxHeight;
                                    if(!var10.field2689) {
                                       var31 = var10.width * 4096 / var20;
                                       if(var10.field2687 != 0) {
                                          var43.method5072(var12 + var10.width / 2, var13 + var10.height / 2, var10.field2687, var31);
                                       } else if(var14 != 0) {
                                          var43.method5101(var12, var13, var10.width, var10.height, 256 - (var14 & 255));
                                       } else if(var20 == var10.width && var10.height == var32) {
                                          var43.method5047(var12, var13);
                                       } else {
                                          var43.method5048(var12, var13, var10.width, var10.height);
                                       }
                                    } else {
                                       Rasterizer2D.method4956(var12, var13, var12 + var10.width, var10.height + var13);
                                       var31 = (var20 - 1 + var10.width) / var20;
                                       var23 = (var10.height + (var32 - 1)) / var32;

                                       for(var24 = 0; var24 < var31; ++var24) {
                                          for(var25 = 0; var25 < var23; ++var25) {
                                             if(var10.field2687 != 0) {
                                                var43.method5072(var12 + var24 * var20 + var20 / 2, var13 + var32 * var25 + var32 / 2, var10.field2687, 4096);
                                             } else if(var14 != 0) {
                                                var43.method5052(var12 + var20 * var24, var13 + var25 * var32, 256 - (var14 & 255));
                                             } else {
                                                var43.method5047(var12 + var24 * var20, var13 + var25 * var32);
                                             }
                                          }
                                       }

                                       Rasterizer2D.method4940(var2, var3, var4, var5);
                                    }
                                 }
                              }
                           } else {
                              ItemComposition var34;
                              if(var10.type == 6) {
                                 boolean var37 = class137.method2672(var10);
                                 if(var37) {
                                    var20 = var10.field2699;
                                 } else {
                                    var20 = var10.field2698;
                                 }

                                 Model var36 = null;
                                 var31 = 0;
                                 if(var10.itemId != -1) {
                                    var34 = Buffer.getItemDefinition(var10.itemId);
                                    if(var34 != null) {
                                       var34 = var34.method4595(var10.itemQuantity);
                                       var36 = var34.getModel(1);
                                       if(var36 != null) {
                                          var36.method2496();
                                          var31 = var36.modelHeight / 2;
                                       } else {
                                          class25.method169(var10);
                                       }
                                    }
                                 } else if(var10.modelType == 5) {
                                    if(var10.modelId == 0) {
                                       var36 = Client.field1201.method3942((Sequence)null, -1, (Sequence)null, -1);
                                    } else {
                                       var36 = World.localPlayer.getModel();
                                    }
                                 } else if(var20 == -1) {
                                    var36 = var10.method3986((Sequence)null, -1, var37, World.localPlayer.composition);
                                    if(var36 == null && Widget.field2649) {
                                       class25.method169(var10);
                                    }
                                 } else {
                                    Sequence var47 = class227.getAnimation(var20);
                                    var36 = var10.method3986(var47, var10.field2675, var37, World.localPlayer.composition);
                                    if(var36 == null && Widget.field2649) {
                                       class25.method169(var10);
                                    }
                                 }

                                 class136.method2593(var12 + var10.width / 2, var10.height / 2 + var13);
                                 var23 = var10.field2705 * class136.SINE[var10.rotationX] >> 16;
                                 var24 = class136.COSINE[var10.rotationX] * var10.field2705 >> 16;
                                 if(var36 != null) {
                                    if(!var10.hasScript) {
                                       var36.method2508(0, var10.rotationZ, 0, var10.rotationX, 0, var23, var24);
                                    } else {
                                       var36.method2496();
                                       if(var10.field2783) {
                                          var36.method2509(0, var10.rotationZ, var10.rotationY, var10.rotationX, var10.field2700, var10.field2701 + var31 + var23, var24 + var10.field2701, var10.field2705);
                                       } else {
                                          var36.method2508(0, var10.rotationZ, var10.rotationY, var10.rotationX, var10.field2700, var10.field2701 + var31 + var23, var10.field2701 + var24);
                                       }
                                    }
                                 }

                                 class136.method2592();
                              } else {
                                 if(var10.type == 7) {
                                    var42 = var10.method3984();
                                    if(var42 == null) {
                                       if(Widget.field2649) {
                                          class25.method169(var10);
                                       }
                                       continue;
                                    }

                                    var20 = 0;

                                    for(var32 = 0; var32 < var10.field2640; ++var32) {
                                       for(var31 = 0; var31 < var10.originalWidth; ++var31) {
                                          if(var10.itemIds[var20] > 0) {
                                             var34 = Buffer.getItemDefinition(var10.itemIds[var20] - 1);
                                             String var33;
                                             if(var34.isStackable != 1 && var10.itemQuantities[var20] == 1) {
                                                var33 = WorldMapData.method337(16748608) + var34.name + "</col>";
                                             } else {
                                                var33 = WorldMapData.method337(16748608) + var34.name + "</col>" + " " + 'x' + Frames.method2877(var10.itemQuantities[var20]);
                                             }

                                             var25 = (var10.paddingX + 115) * var31 + var12;
                                             var26 = var32 * (var10.paddingY + 12) + var13;
                                             if(var10.field2714 == 0) {
                                                var42.method4737(var33, var25, var26, var10.textColor, var10.field2716?0:-1);
                                             } else if(var10.field2714 == 1) {
                                                var42.method4736(var33, var25 + var10.width / 2, var26, var10.textColor, var10.field2716?0:-1);
                                             } else {
                                                var42.method4758(var33, var25 + var10.width - 1, var26, var10.textColor, var10.field2716?0:-1);
                                             }
                                          }

                                          ++var20;
                                       }
                                    }
                                 }

                                 if(var10.type == 8 && var10 == XItemContainer.field791 && Client.field991 == Client.field1082) {
                                    var19 = 0;
                                    var20 = 0;
                                    Font var21 = class33.field473;
                                    String var22 = var10.text;

                                    String var45;
                                    for(var22 = class225.method4075(var22, var10); var22.length() > 0; var20 += var21.field3652 + 1) {
                                       var24 = var22.indexOf("<br>");
                                       if(var24 != -1) {
                                          var45 = var22.substring(0, var24);
                                          var22 = var22.substring(var24 + 4);
                                       } else {
                                          var45 = var22;
                                          var22 = "";
                                       }

                                       var25 = var21.method4728(var45);
                                       if(var25 > var19) {
                                          var19 = var25;
                                       }
                                    }

                                    var19 += 6;
                                    var20 += 7;
                                    var24 = var10.width + var12 - 5 - var19;
                                    var25 = var10.height + var13 + 5;
                                    if(var24 < var12 + 5) {
                                       var24 = var12 + 5;
                                    }

                                    if(var24 + var19 > var4) {
                                       var24 = var4 - var19;
                                    }

                                    if(var20 + var25 > var5) {
                                       var25 = var5 - var20;
                                    }

                                    Rasterizer2D.method4923(var24, var25, var19, var20, 16777120);
                                    Rasterizer2D.method4945(var24, var25, var19, var20, 0);
                                    var22 = var10.text;
                                    var26 = var25 + var21.field3652 + 2;

                                    for(var22 = class225.method4075(var22, var10); var22.length() > 0; var26 += var21.field3652 + 1) {
                                       int var35 = var22.indexOf("<br>");
                                       if(var35 != -1) {
                                          var45 = var22.substring(0, var35);
                                          var22 = var22.substring(var35 + 4);
                                       } else {
                                          var45 = var22;
                                          var22 = "";
                                       }

                                       var21.method4737(var45, var24 + 3, var26, 0, -1);
                                    }
                                 }

                                 if(var10.type == 9) {
                                    if(var10.field2782) {
                                       var19 = var12;
                                       var20 = var13 + var10.height;
                                       var32 = var12 + var10.width;
                                       var31 = var13;
                                    } else {
                                       var19 = var12;
                                       var20 = var13;
                                       var32 = var12 + var10.width;
                                       var31 = var10.height + var13;
                                    }

                                    if(var10.field2684 == 1) {
                                       Rasterizer2D.method4936(var19, var20, var32, var31, var10.textColor);
                                    } else {
                                       class18.method118(var19, var20, var32, var31, var10.textColor, var10.field2684);
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

   @ObfuscatedName("iw")
   @ObfuscatedSignature(
      signature = "(LWidget;IIIIIII)V",
      garbageValue = "1095464124"
   )
   static final void method1074(Widget var0, int var1, int var2, int var3, int var4, int var5, int var6) {
      if(Client.field1011) {
         Client.field1012 = 32;
      } else {
         Client.field1012 = 0;
      }

      Client.field1011 = false;
      int var7;
      if(class59.field736 == 1 || !class233.field3202 && class59.field736 == 4) {
         if(var5 >= var1 && var5 < var1 + 16 && var6 >= var2 && var6 < var2 + 16) {
            var0.scrollY -= 4;
            class25.method169(var0);
         } else if(var5 >= var1 && var5 < var1 + 16 && var6 >= var3 + var2 - 16 && var6 < var3 + var2) {
            var0.scrollY += 4;
            class25.method169(var0);
         } else if(var5 >= var1 - Client.field1012 && var5 < var1 + 16 + Client.field1012 && var6 >= var2 + 16 && var6 < var3 + var2 - 16) {
            var7 = var3 * (var3 - 32) / var4;
            if(var7 < 8) {
               var7 = 8;
            }

            int var8 = var6 - var2 - 16 - var7 / 2;
            int var9 = var3 - 32 - var7;
            var0.scrollY = var8 * (var4 - var3) / var9;
            class25.method169(var0);
            Client.field1011 = true;
         }
      }

      if(Client.field954 != 0) {
         var7 = var0.width;
         if(var5 >= var1 - var7 && var6 >= var2 && var5 < var1 + 16 && var6 <= var3 + var2) {
            var0.scrollY += Client.field954 * 45;
            class25.method169(var0);
         }
      }

   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Lclass69;I)V",
      garbageValue = "1354591537"
   )
   public static void method1075(class69 var0) {
      Projectile.method1746(var0, 200000);
   }

   @ObfuscatedName("jn")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "174678079"
   )
   static final void method1076(String var0) {
      if(var0 != null) {
         String var1 = class154.method2955(var0, World.field1331);
         if(var1 != null) {
            for(int var2 = 0; var2 < Client.friendCount; ++var2) {
               Friend var3 = Client.friends[var2];
               String var4 = var3.name;
               String var5 = class154.method2955(var4, World.field1331);
               if(class155.method2957(var0, var1, var4, var5)) {
                  --Client.friendCount;

                  for(int var6 = var2; var6 < Client.friendCount; ++var6) {
                     Client.friends[var6] = Client.friends[var6 + 1];
                  }

                  Client.field1066 = Client.field1121;
                  Client.secretPacketBuffer1.putOpcode(255);
                  Client.secretPacketBuffer1.putByte(class5.method11(var0));
                  Client.secretPacketBuffer1.method3150(var0);
                  break;
               }
            }

         }
      }
   }
}
