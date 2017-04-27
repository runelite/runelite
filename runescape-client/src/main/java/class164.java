import net.runelite.mapping.Export;
import net.runelite.mapping.Hook;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fi")
public class class164 extends class68 {
   @ObfuscatedName("c")
   Deque field2152 = new Deque();
   @ObfuscatedName("dh")
   @Export("mapRegions")
   @Hook("mapRegionsChanged")
   static int[] mapRegions;
   @ObfuscatedName("d")
   class160 field2158;
   @ObfuscatedName("k")
   static int[][][] field2160;
   @ObfuscatedName("n")
   class51 field2161 = new class51();

   @ObfuscatedName("cc")
   @ObfuscatedSignature(
      signature = "([LWidget;IIIIIIIII)V",
      garbageValue = "-537389824"
   )
   @Export("gameDraw")
   static final void gameDraw(Widget[] var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
      Rasterizer2D.method4083(var2, var3, var4, var5);
      class84.method1649();

      for(int var9 = 0; var9 < var0.length; ++var9) {
         Widget var10 = var0[var9];
         if(var10 != null && (var1 == var10.parentId || var1 == -1412584499 && Client.field458 == var10)) {
            int var11;
            if(var8 == -1) {
               Client.widgetPositionX[Client.field490] = var10.relativeX + var6;
               Client.widgetPositionY[Client.field490] = var10.relativeY + var7;
               Client.widgetBoundsWidth[Client.field490] = var10.width;
               Client.widgetBoundsHeight[Client.field490] = var10.height;
               var11 = ++Client.field490 - 1;
            } else {
               var11 = var8;
            }

            var10.boundsIndex = var11;
            var10.field2339 = Client.gameCycle;
            if(!var10.hasScript || !ChatMessages.method857(var10)) {
               if(var10.contentType > 0) {
                  class131.method2612(var10);
               }

               int var12 = var6 + var10.relativeX;
               int var13 = var10.relativeY + var7;
               int var14 = var10.opacity;
               int var15;
               int var16;
               if(Client.field458 == var10) {
                  if(var1 != -1412584499 && !var10.field2290) {
                     ScriptState.field117 = var0;
                     class122.field1886 = var6;
                     NPC.field760 = var7;
                     continue;
                  }

                  if(Client.field469 && Client.field463) {
                     var15 = class115.field1805;
                     var16 = class115.field1806;
                     var15 -= Client.field492;
                     var16 -= Client.field461;
                     if(var15 < Client.field380) {
                        var15 = Client.field380;
                     }

                     if(var15 + var10.width > Client.field380 + Client.field496.width) {
                        var15 = Client.field496.width + Client.field380 - var10.width;
                     }

                     if(var16 < Client.field465) {
                        var16 = Client.field465;
                     }

                     if(var16 + var10.height > Client.field465 + Client.field496.height) {
                        var16 = Client.field496.height + Client.field465 - var10.height;
                     }

                     var12 = var15;
                     var13 = var16;
                  }

                  if(!var10.field2290) {
                     var14 = 128;
                  }
               }

               int var17;
               int var18;
               int var19;
               int var20;
               int var22;
               int var37;
               if(var10.type == 2) {
                  var15 = var2;
                  var16 = var3;
                  var17 = var4;
                  var18 = var5;
               } else if(var10.type == 9) {
                  var19 = var12;
                  var20 = var13;
                  var37 = var10.width + var12;
                  var22 = var13 + var10.height;
                  if(var37 < var12) {
                     var19 = var37;
                     var37 = var12;
                  }

                  if(var22 < var13) {
                     var20 = var22;
                     var22 = var13;
                  }

                  ++var37;
                  ++var22;
                  var15 = var19 > var2?var19:var2;
                  var16 = var20 > var3?var20:var3;
                  var17 = var37 < var4?var37:var4;
                  var18 = var22 < var5?var22:var5;
               } else {
                  var19 = var10.width + var12;
                  var20 = var13 + var10.height;
                  var15 = var12 > var2?var12:var2;
                  var16 = var13 > var3?var13:var3;
                  var17 = var19 < var4?var19:var4;
                  var18 = var20 < var5?var20:var5;
               }

               if(!var10.hasScript || var15 < var17 && var16 < var18) {
                  if(var10.contentType != 0) {
                     if(var10.contentType == 1336) {
                        if(Client.field558) {
                           var13 += 15;
                           WallObject.field1542.method3916("Fps:" + GameEngine.FPS, var12 + var10.width, var13, 16776960, -1);
                           var13 += 15;
                           Runtime var54 = Runtime.getRuntime();
                           var20 = (int)((var54.totalMemory() - var54.freeMemory()) / 1024L);
                           var37 = 16776960;
                           if(var20 > '耀' && Client.field285) {
                              var37 = 16711680;
                           }

                           if(var20 > 65536 && !Client.field285) {
                              var37 = 16711680;
                           }

                           WallObject.field1542.method3916("Mem:" + var20 + "k", var10.width + var12, var13, var37, -1);
                           var13 += 15;
                        }
                        continue;
                     }

                     if(var10.contentType == 1337) {
                        Client.field433 = var12;
                        Client.field546 = var13;
                        class105.method2030(var12, var13, var10.width, var10.height);
                        Client.field368[var10.boundsIndex] = true;
                        Rasterizer2D.method4083(var2, var3, var4, var5);
                        continue;
                     }

                     if(var10.contentType == 1338) {
                        class159.method2905(var10, var12, var13, var11);
                        Rasterizer2D.method4083(var2, var3, var4, var5);
                        continue;
                     }

                     if(var10.contentType == 1339) {
                        class166 var53 = var10.method3211(false);
                        if(var53 != null) {
                           if(Client.field522 < 3) {
                              ItemLayer.field1204.method4257(var12, var13, var53.field2167, var53.field2165, 25, 25, Client.mapAngle, 256, var53.field2166, var53.field2164);
                           } else {
                              Rasterizer2D.method4126(var12, var13, 0, var53.field2166, var53.field2164);
                           }
                        }

                        Rasterizer2D.method4083(var2, var3, var4, var5);
                        continue;
                     }
                  }

                  if(var10.type == 0) {
                     if(!var10.hasScript && ChatMessages.method857(var10) && ChatMessages.field920 != var10) {
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

                     WidgetNode var39 = (WidgetNode)Client.componentTable.method2773((long)var10.id);
                     if(var39 != null) {
                        class210.method4010(var39.id, var15, var16, var17, var18, var12, var13, var11);
                     }

                     Rasterizer2D.method4083(var2, var3, var4, var5);
                     class84.method1649();
                  }

                  if(Client.isResized || Client.field452[var11] || Client.field382 > 1) {
                     int var24;
                     int var36;
                     if(var10.type == 0 && !var10.hasScript && var10.scrollHeight > var10.height) {
                        var19 = var12 + var10.width;
                        var20 = var10.scrollY;
                        var37 = var10.height;
                        var22 = var10.scrollHeight;
                        class128.field1952[0].method4170(var19, var13);
                        class128.field1952[1].method4170(var19, var13 + var37 - 16);
                        Rasterizer2D.method4089(var19, var13 + 16, 16, var37 - 32, Client.field360);
                        var36 = (var37 - 32) * var37 / var22;
                        if(var36 < 8) {
                           var36 = 8;
                        }

                        var24 = (var37 - 32 - var36) * var20 / (var22 - var37);
                        Rasterizer2D.method4089(var19, var13 + 16 + var24, 16, var36, Client.field434);
                        Rasterizer2D.method4080(var19, var24 + var13 + 16, var36, Client.field363);
                        Rasterizer2D.method4080(var19 + 1, var13 + 16 + var24, var36, Client.field363);
                        Rasterizer2D.method4097(var19, var13 + 16 + var24, 16, Client.field363);
                        Rasterizer2D.method4097(var19, var24 + var13 + 17, 16, Client.field363);
                        Rasterizer2D.method4080(var19 + 15, var24 + var13 + 16, var36, Client.field362);
                        Rasterizer2D.method4080(var19 + 14, var13 + 17 + var24, var36 - 1, Client.field362);
                        Rasterizer2D.method4097(var19, var24 + var13 + 15 + var36, 16, Client.field362);
                        Rasterizer2D.method4097(var19 + 1, var24 + var13 + 14 + var36, 15, Client.field362);
                     }

                     if(var10.type != 1) {
                        int var25;
                        int var26;
                        int var29;
                        if(var10.type == 2) {
                           var19 = 0;

                           for(var20 = 0; var20 < var10.field2219; ++var20) {
                              for(var37 = 0; var37 < var10.originalWidth; ++var37) {
                                 var22 = var37 * (var10.field2273 + 32) + var12;
                                 var36 = var20 * (var10.field2274 + 32) + var13;
                                 if(var19 < 20) {
                                    var22 += var10.field2223[var19];
                                    var36 += var10.field2276[var19];
                                 }

                                 if(var10.itemIds[var19] <= 0) {
                                    if(var10.field2277 != null && var19 < 20) {
                                       SpritePixels var55 = var10.method3195(var19);
                                       if(var55 != null) {
                                          var55.method4230(var22, var36);
                                       } else if(Widget.field2205) {
                                          class124.method2350(var10);
                                       }
                                    }
                                 } else {
                                    boolean var48 = false;
                                    boolean var49 = false;
                                    var26 = var10.itemIds[var19] - 1;
                                    if(var22 + 32 > var2 && var22 < var4 && var36 + 32 > var3 && var36 < var5 || var10 == class97.field1627 && Client.field488 == var19) {
                                       SpritePixels var42;
                                       if(Client.field351 == 1 && Player.field264 == var19 && class72.field1171 == var10.id) {
                                          var42 = class130.createSprite(var26, var10.itemQuantities[var19], 2, 0, 2, false);
                                       } else {
                                          var42 = class130.createSprite(var26, var10.itemQuantities[var19], 1, 3153952, 2, false);
                                       }

                                       if(var42 != null) {
                                          if(var10 == class97.field1627 && Client.field488 == var19) {
                                             var24 = class115.field1805 - Client.field540;
                                             var25 = class115.field1806 - Client.field398;
                                             if(var24 < 5 && var24 > -5) {
                                                var24 = 0;
                                             }

                                             if(var25 < 5 && var25 > -5) {
                                                var25 = 0;
                                             }

                                             if(Client.field404 < 5) {
                                                var24 = 0;
                                                var25 = 0;
                                             }

                                             var42.method4236(var24 + var22, var25 + var36, 128);
                                             if(var1 != -1) {
                                                Widget var28 = var0[var1 & '\uffff'];
                                                if(var36 + var25 < Rasterizer2D.field3211 && var28.scrollY > 0) {
                                                   var29 = (Rasterizer2D.field3211 - var36 - var25) * Client.field358 / 3;
                                                   if(var29 > Client.field358 * 10) {
                                                      var29 = Client.field358 * 10;
                                                   }

                                                   if(var29 > var28.scrollY) {
                                                      var29 = var28.scrollY;
                                                   }

                                                   var28.scrollY -= var29;
                                                   Client.field398 += var29;
                                                   class124.method2350(var28);
                                                }

                                                if(var36 + var25 + 32 > Rasterizer2D.field3213 && var28.scrollY < var28.scrollHeight - var28.height) {
                                                   var29 = (var25 + var36 + 32 - Rasterizer2D.field3213) * Client.field358 / 3;
                                                   if(var29 > Client.field358 * 10) {
                                                      var29 = Client.field358 * 10;
                                                   }

                                                   if(var29 > var28.scrollHeight - var28.height - var28.scrollY) {
                                                      var29 = var28.scrollHeight - var28.height - var28.scrollY;
                                                   }

                                                   var28.scrollY += var29;
                                                   Client.field398 -= var29;
                                                   class124.method2350(var28);
                                                }
                                             }
                                          } else if(class32.field732 == var10 && Client.field395 == var19) {
                                             var42.method4236(var22, var36, 128);
                                          } else {
                                             var42.method4230(var22, var36);
                                          }
                                       } else {
                                          class124.method2350(var10);
                                       }
                                    }
                                 }

                                 ++var19;
                              }
                           }
                        } else if(var10.type == 3) {
                           if(class175.method3264(var10)) {
                              var19 = var10.field2279;
                              if(var10 == ChatMessages.field920 && var10.field2235 != 0) {
                                 var19 = var10.field2235;
                              }
                           } else {
                              var19 = var10.textColor;
                              if(var10 == ChatMessages.field920 && var10.field2234 != 0) {
                                 var19 = var10.field2234;
                              }
                           }

                           if(var10.field2236) {
                              switch(var10.field2238.field3219) {
                              case 1:
                                 Rasterizer2D.method4090(var12, var13, var10.width, var10.height, var10.textColor, var10.field2279, 256 - (var10.opacity & 255), 256 - (var10.field2248 & 255));
                                 break;
                              case 2:
                                 Rasterizer2D.method4091(var12, var13, var10.width, var10.height, var10.textColor, var10.field2279, 256 - (var10.opacity & 255), 256 - (var10.field2248 & 255));
                                 break;
                              case 3:
                                 Rasterizer2D.method4092(var12, var13, var10.width, var10.height, var10.textColor, var10.field2279, 256 - (var10.opacity & 255), 256 - (var10.field2248 & 255));
                                 break;
                              case 4:
                                 Rasterizer2D.method4093(var12, var13, var10.width, var10.height, var10.textColor, var10.field2279, 256 - (var10.opacity & 255), 256 - (var10.field2248 & 255));
                                 break;
                              default:
                                 if(var14 == 0) {
                                    Rasterizer2D.method4089(var12, var13, var10.width, var10.height, var19);
                                 } else {
                                    Rasterizer2D.method4101(var12, var13, var10.width, var10.height, var19, 256 - (var14 & 255));
                                 }
                              }
                           } else if(var14 == 0) {
                              Rasterizer2D.method4095(var12, var13, var10.width, var10.height, var19);
                           } else {
                              Rasterizer2D.method4096(var12, var13, var10.width, var10.height, var19, 256 - (var14 & 255));
                           }
                        } else {
                           Font var50;
                           if(var10.type == 4) {
                              var50 = var10.method3194();
                              if(var50 == null) {
                                 if(Widget.field2205) {
                                    class124.method2350(var10);
                                 }
                              } else {
                                 String var46 = var10.text;
                                 if(class175.method3264(var10)) {
                                    var20 = var10.field2279;
                                    if(var10 == ChatMessages.field920 && var10.field2235 != 0) {
                                       var20 = var10.field2235;
                                    }

                                    if(var10.field2268.length() > 0) {
                                       var46 = var10.field2268;
                                    }
                                 } else {
                                    var20 = var10.textColor;
                                    if(ChatMessages.field920 == var10 && var10.field2234 != 0) {
                                       var20 = var10.field2234;
                                    }
                                 }

                                 if(var10.hasScript && var10.item != -1) {
                                    ItemComposition var52 = class47.getItemDefinition(var10.item);
                                    var46 = var52.name;
                                    if(var46 == null) {
                                       var46 = "null";
                                    }

                                    if((var52.isStackable == 1 || var10.stackSize != 1) && var10.stackSize != -1) {
                                       var46 = class213.method4037(16748608) + var46 + "</col>" + " " + 'x' + XItemContainer.method168(var10.stackSize);
                                    }
                                 }

                                 if(var10 == Client.field449) {
                                    Object var10000 = null;
                                    var46 = "Please wait...";
                                    var20 = var10.textColor;
                                 }

                                 if(!var10.hasScript) {
                                    var46 = CollisionData.method2251(var46, var10);
                                 }

                                 var50.method3905(var46, var12, var13, var10.width, var10.height, var20, var10.field2272?0:-1, var10.field2270, var10.field2271, var10.field2287);
                              }
                           } else if(var10.type == 5) {
                              SpritePixels var51;
                              if(!var10.hasScript) {
                                 var51 = var10.method3193(class175.method3264(var10));
                                 if(var51 != null) {
                                    var51.method4230(var12, var13);
                                 } else if(Widget.field2205) {
                                    class124.method2350(var10);
                                 }
                              } else {
                                 if(var10.item != -1) {
                                    var51 = class130.createSprite(var10.item, var10.stackSize, var10.borderThickness, var10.sprite2, var10.field2265, false);
                                 } else {
                                    var51 = var10.method3193(false);
                                 }

                                 if(var51 == null) {
                                    if(Widget.field2205) {
                                       class124.method2350(var10);
                                    }
                                 } else {
                                    var20 = var51.maxWidth;
                                    var37 = var51.maxHeight;
                                    if(!var10.field2245) {
                                       var22 = var10.width * 4096 / var20;
                                       if(var10.field2196 != 0) {
                                          var51.method4227(var10.width / 2 + var12, var10.height / 2 + var13, var10.field2196, var22);
                                       } else if(var14 != 0) {
                                          var51.method4238(var12, var13, var10.width, var10.height, 256 - (var14 & 255));
                                       } else if(var20 == var10.width && var37 == var10.height) {
                                          var51.method4230(var12, var13);
                                       } else {
                                          var51.method4279(var12, var13, var10.width, var10.height);
                                       }
                                    } else {
                                       Rasterizer2D.method4084(var12, var13, var10.width + var12, var10.height + var13);
                                       var22 = (var20 - 1 + var10.width) / var20;
                                       var36 = (var10.height + (var37 - 1)) / var37;

                                       for(var24 = 0; var24 < var22; ++var24) {
                                          for(var25 = 0; var25 < var36; ++var25) {
                                             if(var10.field2196 != 0) {
                                                var51.method4227(var20 / 2 + var24 * var20 + var12, var13 + var25 * var37 + var37 / 2, var10.field2196, 4096);
                                             } else if(var14 != 0) {
                                                var51.method4236(var20 * var24 + var12, var13 + var25 * var37, 256 - (var14 & 255));
                                             } else {
                                                var51.method4230(var20 * var24 + var12, var13 + var25 * var37);
                                             }
                                          }
                                       }

                                       Rasterizer2D.method4083(var2, var3, var4, var5);
                                    }
                                 }
                              }
                           } else {
                              ItemComposition var23;
                              if(var10.type == 6) {
                                 boolean var44 = class175.method3264(var10);
                                 if(var44) {
                                    var20 = var10.field2255;
                                 } else {
                                    var20 = var10.field2254;
                                 }

                                 Model var43 = null;
                                 var22 = 0;
                                 if(var10.item != -1) {
                                    var23 = class47.getItemDefinition(var10.item);
                                    if(var23 != null) {
                                       var23 = var23.method3744(var10.stackSize);
                                       var43 = var23.getModel(1);
                                       if(var43 != null) {
                                          var43.method1574();
                                          var22 = var43.modelHeight / 2;
                                       } else {
                                          class124.method2350(var10);
                                       }
                                    }
                                 } else if(var10.modelType == 5) {
                                    if(var10.modelId == 0) {
                                       var43 = Client.field559.method3172((Sequence)null, -1, (Sequence)null, -1);
                                    } else {
                                       var43 = class22.localPlayer.getModel();
                                    }
                                 } else if(var20 == -1) {
                                    var43 = var10.method3196((Sequence)null, -1, var44, class22.localPlayer.composition);
                                    if(var43 == null && Widget.field2205) {
                                       class124.method2350(var10);
                                    }
                                 } else {
                                    Sequence var47 = NPCComposition.getAnimation(var20);
                                    var43 = var10.method3196(var47, var10.field2329, var44, class22.localPlayer.composition);
                                    if(var43 == null && Widget.field2205) {
                                       class124.method2350(var10);
                                    }
                                 }

                                 class84.method1652(var10.width / 2 + var12, var10.height / 2 + var13);
                                 var36 = class84.field1433[var10.rotationX] * var10.field2244 >> 16;
                                 var24 = class84.field1441[var10.rotationX] * var10.field2244 >> 16;
                                 if(var43 != null) {
                                    if(!var10.hasScript) {
                                       var43.method1586(0, var10.rotationZ, 0, var10.rotationX, 0, var36, var24);
                                    } else {
                                       var43.method1574();
                                       if(var10.field2230) {
                                          var43.method1589(0, var10.rotationZ, var10.rotationY, var10.rotationX, var10.field2256, var10.field2257 + var36 + var22, var24 + var10.field2257, var10.field2244);
                                       } else {
                                          var43.method1586(0, var10.rotationZ, var10.rotationY, var10.rotationX, var10.field2256, var10.field2257 + var36 + var22, var24 + var10.field2257);
                                       }
                                    }
                                 }

                                 class84.method1680();
                              } else {
                                 if(var10.type == 7) {
                                    var50 = var10.method3194();
                                    if(var50 == null) {
                                       if(Widget.field2205) {
                                          class124.method2350(var10);
                                       }
                                       continue;
                                    }

                                    var20 = 0;

                                    for(var37 = 0; var37 < var10.field2219; ++var37) {
                                       for(var22 = 0; var22 < var10.originalWidth; ++var22) {
                                          if(var10.itemIds[var20] > 0) {
                                             var23 = class47.getItemDefinition(var10.itemIds[var20] - 1);
                                             String var40;
                                             if(var23.isStackable != 1 && var10.itemQuantities[var20] == 1) {
                                                var40 = class213.method4037(16748608) + var23.name + "</col>";
                                             } else {
                                                var40 = class213.method4037(16748608) + var23.name + "</col>" + " " + 'x' + XItemContainer.method168(var10.itemQuantities[var20]);
                                             }

                                             var25 = var12 + var22 * (var10.field2273 + 115);
                                             var26 = var37 * (var10.field2274 + 12) + var13;
                                             if(var10.field2270 == 0) {
                                                var50.method3914(var40, var25, var26, var10.textColor, var10.field2272?0:-1);
                                             } else if(var10.field2270 == 1) {
                                                var50.method3944(var40, var25 + var10.width / 2, var26, var10.textColor, var10.field2272?0:-1);
                                             } else {
                                                var50.method3916(var40, var25 + var10.width - 1, var26, var10.textColor, var10.field2272?0:-1);
                                             }
                                          }

                                          ++var20;
                                       }
                                    }
                                 }

                                 int var27;
                                 if(var10.type == 8 && class13.field142 == var10 && Client.field436 == Client.field437) {
                                    var19 = 0;
                                    var20 = 0;
                                    Font var21 = WallObject.field1542;
                                    String var38 = var10.text;

                                    String var45;
                                    for(var38 = CollisionData.method2251(var38, var10); var38.length() > 0; var20 += var21.field3111 + 1) {
                                       var24 = var38.indexOf("<br>");
                                       if(var24 != -1) {
                                          var45 = var38.substring(0, var24);
                                          var38 = var38.substring(var24 + 4);
                                       } else {
                                          var45 = var38;
                                          var38 = "";
                                       }

                                       var25 = var21.method3904(var45);
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

                                    if(var25 + var20 > var5) {
                                       var25 = var5 - var20;
                                    }

                                    Rasterizer2D.method4089(var24, var25, var19, var20, 16777120);
                                    Rasterizer2D.method4095(var24, var25, var19, var20, 0);
                                    var38 = var10.text;
                                    var26 = var21.field3111 + var25 + 2;

                                    for(var38 = CollisionData.method2251(var38, var10); var38.length() > 0; var26 += var21.field3111 + 1) {
                                       var27 = var38.indexOf("<br>");
                                       if(var27 != -1) {
                                          var45 = var38.substring(0, var27);
                                          var38 = var38.substring(var27 + 4);
                                       } else {
                                          var45 = var38;
                                          var38 = "";
                                       }

                                       var21.method3914(var45, var24 + 3, var26, 0, -1);
                                    }
                                 }

                                 if(var10.type == 9) {
                                    if(var10.field2282 == 1) {
                                       if(var10.field2225) {
                                          var19 = var12;
                                          var20 = var10.height + var13;
                                          var37 = var12 + var10.width;
                                          var22 = var13;
                                       } else {
                                          var19 = var12;
                                          var20 = var13;
                                          var37 = var12 + var10.width;
                                          var22 = var13 + var10.height;
                                       }

                                       Rasterizer2D.method4087(var19, var20, var37, var22, var10.textColor);
                                    } else {
                                       var19 = var10.width >= 0?var10.width:-var10.width;
                                       var20 = var10.height >= 0?var10.height:-var10.height;
                                       var37 = var19;
                                       if(var19 < var20) {
                                          var37 = var20;
                                       }

                                       if(var37 != 0) {
                                          var22 = (var10.width << 16) / var37;
                                          var36 = (var10.height << 16) / var37;
                                          if(var36 <= var22) {
                                             var22 = -var22;
                                          } else {
                                             var36 = -var36;
                                          }

                                          var24 = var36 * var10.field2282 >> 17;
                                          var25 = var10.field2282 * var36 + 1 >> 17;
                                          var26 = var22 * var10.field2282 >> 17;
                                          var27 = var10.field2282 * var22 + 1 >> 17;
                                          int var41 = var12 + var24;
                                          var29 = var12 - var25;
                                          int var30 = var10.width + var12 - var25;
                                          int var31 = var24 + var10.width + var12;
                                          int var32 = var26 + var13;
                                          int var33 = var13 - var27;
                                          int var34 = var13 + var10.height - var27;
                                          int var35 = var13 + var10.height + var26;
                                          class84.setRasterClippingEnabled(var41, var29, var30);
                                          class84.rasterFlat(var32, var33, var34, var41, var29, var30, var10.textColor);
                                          class84.setRasterClippingEnabled(var41, var30, var31);
                                          class84.rasterFlat(var32, var34, var35, var41, var30, var31, var10.textColor);
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

   @ObfuscatedName("u")
   protected class68 vmethod3091() {
      class161 var1;
      do {
         var1 = (class161)this.field2152.method2830();
         if(var1 == null) {
            return null;
         }
      } while(var1.field2112 == null);

      return var1.field2112;
   }

   @ObfuscatedName("r")
   protected void vmethod3093(int[] var1, int var2, int var3) {
      this.field2161.vmethod3093(var1, var2, var3);

      for(class161 var6 = (class161)this.field2152.method2828(); var6 != null; var6 = (class161)this.field2152.method2830()) {
         if(!this.field2158.method2940(var6)) {
            int var4 = var2;
            int var5 = var3;

            do {
               if(var5 <= var6.field2124) {
                  this.method3095(var6, var1, var4, var5, var4 + var5);
                  var6.field2124 -= var5;
                  break;
               }

               this.method3095(var6, var1, var4, var6.field2124, var5 + var4);
               var4 += var6.field2124;
               var5 -= var6.field2124;
            } while(!this.field2158.method2941(var6, var1, var4, var5));
         }
      }

   }

   @ObfuscatedName("k")
   protected void vmethod3094(int var1) {
      this.field2161.vmethod3094(var1);

      for(class161 var3 = (class161)this.field2152.method2828(); var3 != null; var3 = (class161)this.field2152.method2830()) {
         if(!this.field2158.method2940(var3)) {
            int var2 = var1;

            do {
               if(var2 <= var3.field2124) {
                  this.method3108(var3, var2);
                  var3.field2124 -= var2;
                  break;
               }

               this.method3108(var3, var3.field2124);
               var2 -= var3.field2124;
            } while(!this.field2158.method2941(var3, (int[])null, 0, var2));
         }
      }

   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Lclass161;[IIIIS)V",
      garbageValue = "-25672"
   )
   void method3095(class161 var1, int[] var2, int var3, int var4, int var5) {
      if((this.field2158.field2086[var1.field2123] & 4) != 0 && var1.field2119 < 0) {
         int var6 = this.field2158.field2091[var1.field2123] / class57.field1032;

         while(true) {
            int var7 = (var6 + 1048575 - var1.field2125) / var6;
            if(var7 > var4) {
               var1.field2125 += var4 * var6;
               break;
            }

            var1.field2112.vmethod3093(var2, var3, var7);
            var3 += var7;
            var4 -= var7;
            var1.field2125 += var6 * var7 - 1048576;
            int var8 = class57.field1032 / 100;
            int var9 = 262144 / var6;
            if(var9 < var8) {
               var8 = var9;
            }

            class66 var10 = var1.field2112;
            if(this.field2158.field2089[var1.field2123] == 0) {
               var1.field2112 = class66.method1200(var1.field2113, var10.method1197(), var10.method1206(), var10.method1207());
            } else {
               var1.field2112 = class66.method1200(var1.field2113, var10.method1197(), 0, var10.method1207());
               this.field2158.method2978(var1, var1.field2109.field2144[var1.field2110] < 0);
               var1.field2112.method1211(var8, var10.method1206());
            }

            if(var1.field2109.field2144[var1.field2110] < 0) {
               var1.field2112.method1281(-1);
            }

            var10.method1213(var8);
            var10.vmethod3093(var2, var3, var5 - var3);
            if(var10.method1259()) {
               this.field2161.method935(var10);
            }
         }
      }

      var1.field2112.vmethod3093(var2, var3, var4);
   }

   @ObfuscatedName("w")
   protected int vmethod3097() {
      return 0;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(Lclass142;ILjava/lang/String;I)Ljava/lang/String;",
      garbageValue = "1124742077"
   )
   static String method3100(class142 var0, int var1, String var2) {
      if(var0 == null) {
         return var2;
      } else {
         class141 var3 = (class141)var0.method2728((long)var1);
         return var3 == null?var2:(String)var3.field2009;
      }
   }

   @ObfuscatedName("p")
   protected class68 vmethod3102() {
      class161 var1 = (class161)this.field2152.method2828();
      return (class68)(var1 == null?null:(var1.field2112 != null?var1.field2112:this.vmethod3091()));
   }

   class164(class160 var1) {
      this.field2158 = var1;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(Lclass161;IS)V",
      garbageValue = "-22229"
   )
   void method3108(class161 var1, int var2) {
      if((this.field2158.field2086[var1.field2123] & 4) != 0 && var1.field2119 < 0) {
         int var3 = this.field2158.field2091[var1.field2123] / class57.field1032;
         int var4 = (var3 + 1048575 - var1.field2125) / var3;
         var1.field2125 = var2 * var3 + var1.field2125 & 1048575;
         if(var4 <= var2) {
            if(this.field2158.field2089[var1.field2123] == 0) {
               var1.field2112 = class66.method1200(var1.field2113, var1.field2112.method1197(), var1.field2112.method1206(), var1.field2112.method1207());
            } else {
               var1.field2112 = class66.method1200(var1.field2113, var1.field2112.method1197(), 0, var1.field2112.method1207());
               this.field2158.method2978(var1, var1.field2109.field2144[var1.field2110] < 0);
            }

            if(var1.field2109.field2144[var1.field2110] < 0) {
               var1.field2112.method1281(-1);
            }

            var2 = var1.field2125 / var3;
         }
      }

      var1.field2112.vmethod3094(var2);
   }

   @ObfuscatedName("ca")
   @ObfuscatedSignature(
      signature = "([LWidget;LWidget;ZI)V",
      garbageValue = "-1093665577"
   )
   static void method3116(Widget[] var0, Widget var1, boolean var2) {
      int var3 = var1.scrollWidth != 0?var1.scrollWidth:var1.width;
      int var4 = var1.scrollHeight != 0?var1.scrollHeight:var1.height;
      ItemLayer.method1476(var0, var1.id, var3, var4, var2);
      if(var1.children != null) {
         ItemLayer.method1476(var1.children, var1.id, var3, var4, var2);
      }

      WidgetNode var5 = (WidgetNode)Client.componentTable.method2773((long)var1.id);
      if(var5 != null) {
         int var6 = var5.id;
         if(class112.method2112(var6)) {
            ItemLayer.method1476(class133.widgets[var6], -1, var3, var4, var2);
         }
      }

      if(var1.contentType == 1337) {
         ;
      }

   }
}
