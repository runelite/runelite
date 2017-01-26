import java.math.BigInteger;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("af")
public class class36 {
   @ObfuscatedName("d")
   static final BigInteger field766 = new BigInteger("80782894952180643741752986186714059433953886149239752893425047584684715842049");
   @ObfuscatedName("k")
   static final BigInteger field768 = new BigInteger("7237300117305667488707183861728052766358166655052137727439795191253340127955075499635575104901523446809299097934591732635674173519120047404024393881551683");

   class36() throws Throwable {
      throw new Error();
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(CI)Z",
      garbageValue = "36480868"
   )
   static final boolean method722(char var0) {
      if(Character.isISOControl(var0)) {
         return false;
      } else if(Player.method223(var0)) {
         return true;
      } else {
         char[] var1 = class204.field3072;

         int var2;
         char var3;
         for(var2 = 0; var2 < var1.length; ++var2) {
            var3 = var1[var2];
            if(var0 == var3) {
               return true;
            }
         }

         var1 = class204.field3073;

         for(var2 = 0; var2 < var1.length; ++var2) {
            var3 = var1[var2];
            if(var0 == var3) {
               return true;
            }
         }

         return false;
      }
   }

   @ObfuscatedName("cc")
   @ObfuscatedSignature(
      signature = "([LWidget;IIIIIIIII)V",
      garbageValue = "-1160116349"
   )
   @Export("gameDraw")
   static final void gameDraw(Widget[] var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
      Rasterizer2D.method4008(var2, var3, var4, var5);
      class84.method1678();

      for(int var9 = 0; var9 < var0.length; ++var9) {
         Widget var10 = var0[var9];
         if(var10 != null && (var1 == var10.parentId || var1 == -1412584499 && var10 == Client.field368)) {
            int var11;
            if(var8 == -1) {
               Client.widgetPositionX[Client.field480] = var10.relativeX + var6;
               Client.widgetPositionY[Client.field480] = var7 + var10.relativeY;
               Client.widgetBoundsWidth[Client.field480] = var10.width;
               Client.widgetBoundsHeight[Client.field480] = var10.height;
               var11 = ++Client.field480 - 1;
            } else {
               var11 = var8;
            }

            var10.boundsIndex = var11;
            var10.field2328 = Client.gameCycle;
            if(!var10.hasScript || !class97.method1917(var10)) {
               int var12;
               if(var10.contentType > 0) {
                  var12 = var10.contentType;
                  if(var12 == 324) {
                     if(Client.field451 == -1) {
                        Client.field451 = var10.textureId;
                        Client.field552 = var10.field2232;
                     }

                     if(Client.field550.isFemale) {
                        var10.textureId = Client.field451;
                     } else {
                        var10.textureId = Client.field552;
                     }
                  } else if(var12 == 325) {
                     if(Client.field451 == -1) {
                        Client.field451 = var10.textureId;
                        Client.field552 = var10.field2232;
                     }

                     if(Client.field550.isFemale) {
                        var10.textureId = Client.field552;
                     } else {
                        var10.textureId = Client.field451;
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
               if(Client.field368 == var10) {
                  if(var1 != -1412584499 && !var10.field2211) {
                     class99.field1648 = var0;
                     class26.field588 = var6;
                     class37.field785 = var7;
                     continue;
                  }

                  if(Client.field461 && Client.field337) {
                     var15 = class115.field1805;
                     var16 = class115.field1814;
                     var15 -= Client.field452;
                     var16 -= Client.field551;
                     if(var15 < Client.field456) {
                        var15 = Client.field456;
                     }

                     if(var15 + var10.width > Client.field430.width + Client.field456) {
                        var15 = Client.field456 + Client.field430.width - var10.width;
                     }

                     if(var16 < Client.field457) {
                        var16 = Client.field457;
                     }

                     if(var16 + var10.height > Client.field457 + Client.field430.height) {
                        var16 = Client.field430.height + Client.field457 - var10.height;
                     }

                     var12 = var15;
                     var13 = var16;
                  }

                  if(!var10.field2211) {
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
                  var22 = var10.height + var13;
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
                  var20 = var10.height + var13;
                  var15 = var12 > var2?var12:var2;
                  var16 = var13 > var3?var13:var3;
                  var17 = var19 < var4?var19:var4;
                  var18 = var20 < var5?var20:var5;
               }

               if(!var10.hasScript || var15 < var17 && var16 < var18) {
                  if(var10.contentType != 0) {
                     if(var10.contentType == 1336) {
                        if(Client.field477) {
                           var13 += 15;
                           class178.field2670.method3877("Fps:" + GameEngine.FPS, var12 + var10.width, var13, 16776960, -1);
                           var13 += 15;
                           Runtime var52 = Runtime.getRuntime();
                           var20 = (int)((var52.totalMemory() - var52.freeMemory()) / 1024L);
                           var21 = 16776960;
                           if(var20 > '耀' && Client.field283) {
                              var21 = 16711680;
                           }

                           if(var20 > 65536 && !Client.field283) {
                              var21 = 16711680;
                           }

                           class178.field2670.method3877("Mem:" + var20 + "k", var12 + var10.width, var13, var21, -1);
                           var13 += 15;
                        }
                        continue;
                     }

                     if(var10.contentType == 1337) {
                        Client.field425 = var12;
                        Client.field426 = var13;
                        FileOnDisk.method1426(var12, var13, var10.width, var10.height);
                        Client.field482[var10.boundsIndex] = true;
                        Rasterizer2D.method4008(var2, var3, var4, var5);
                        continue;
                     }

                     if(var10.contentType == 1338) {
                        class15.method183(var10, var12, var13, var11);
                        Rasterizer2D.method4008(var2, var3, var4, var5);
                        continue;
                     }

                     if(var10.contentType == 1339) {
                        class164 var50 = var10.method3218(false);
                        if(var50 != null) {
                           if(Client.field513 < 3) {
                              class2.field21.method4155(var12, var13, var50.field2156, var50.field2153, 25, 25, Client.mapAngle, 256, var50.field2152, var50.field2150);
                           } else {
                              Rasterizer2D.method3988(var12, var13, 0, var50.field2152, var50.field2150);
                           }
                        }

                        Rasterizer2D.method4008(var2, var3, var4, var5);
                        continue;
                     }
                  }

                  if(var10.type == 0) {
                     if(!var10.hasScript && class97.method1917(var10) && class15.field167 != var10) {
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

                     WidgetNode var37 = (WidgetNode)Client.componentTable.method2374((long)var10.id);
                     if(var37 != null) {
                        var20 = var37.id;
                        if(!class103.method1973(var20)) {
                           if(var11 != -1) {
                              Client.field482[var11] = true;
                           } else {
                              for(var21 = 0; var21 < 100; ++var21) {
                                 Client.field482[var21] = true;
                              }
                           }
                        } else {
                           class99.field1648 = null;
                           gameDraw(Widget.widgets[var20], -1, var15, var16, var17, var18, var12, var13, var11);
                           if(null != class99.field1648) {
                              gameDraw(class99.field1648, -1412584499, var15, var16, var17, var18, class26.field588, class37.field785, var11);
                              class99.field1648 = null;
                           }
                        }
                     }

                     Rasterizer2D.method4008(var2, var3, var4, var5);
                     class84.method1678();
                  }

                  if(Client.isResized || Client.field484[var11] || Client.field489 > 1) {
                     if(var10.type == 0 && !var10.hasScript && var10.scrollHeight > var10.height) {
                        class33.method684(var10.width + var12, var13, var10.scrollY, var10.height, var10.scrollHeight);
                     }

                     if(var10.type != 1) {
                        int var23;
                        int var24;
                        int var25;
                        int var26;
                        int var29;
                        if(var10.type == 2) {
                           var19 = 0;

                           for(var20 = 0; var20 < var10.field2241; ++var20) {
                              for(var21 = 0; var21 < var10.originalWidth; ++var21) {
                                 var22 = var12 + (var10.field2262 + 32) * var21;
                                 var23 = var13 + (var10.field2318 + 32) * var20;
                                 if(var19 < 20) {
                                    var22 += var10.field2264[var19];
                                    var23 += var10.field2265[var19];
                                 }

                                 if(var10.itemIds[var19] <= 0) {
                                    if(null != var10.field2266 && var19 < 20) {
                                       SpritePixels var53 = var10.method3179(var19);
                                       if(var53 != null) {
                                          var53.method4144(var22, var23);
                                       } else if(Widget.field2326) {
                                          class33.method682(var10);
                                       }
                                    }
                                 } else {
                                    boolean var44 = false;
                                    boolean var45 = false;
                                    var26 = var10.itemIds[var19] - 1;
                                    if(var22 + 32 > var2 && var22 < var4 && 32 + var23 > var3 && var23 < var5 || var10 == CombatInfoListHolder.field751 && Client.field392 == var19) {
                                       SpritePixels var38;
                                       if(Client.field429 == 1 && Ignore.field202 == var19 && Client.field472 == var10.id) {
                                          var38 = class143.createSprite(var26, var10.itemQuantities[var19], 2, 0, 2, false);
                                       } else {
                                          var38 = class143.createSprite(var26, var10.itemQuantities[var19], 1, 3153952, 2, false);
                                       }

                                       if(var38 != null) {
                                          if(var10 == CombatInfoListHolder.field751 && Client.field392 == var19) {
                                             var24 = class115.field1805 - Client.field393;
                                             var25 = class115.field1814 - Client.field526;
                                             if(var24 < 5 && var24 > -5) {
                                                var24 = 0;
                                             }

                                             if(var25 < 5 && var25 > -5) {
                                                var25 = 0;
                                             }

                                             if(Client.field320 < 5) {
                                                var24 = 0;
                                                var25 = 0;
                                             }

                                             var38.method4223(var24 + var22, var25 + var23, 128);
                                             if(var1 != -1) {
                                                Widget var28 = var0[var1 & '\uffff'];
                                                if(var23 + var25 < Rasterizer2D.field3175 && var28.scrollY > 0) {
                                                   var29 = (Rasterizer2D.field3175 - var23 - var25) * Client.field354 / 3;
                                                   if(var29 > Client.field354 * 10) {
                                                      var29 = Client.field354 * 10;
                                                   }

                                                   if(var29 > var28.scrollY) {
                                                      var29 = var28.scrollY;
                                                   }

                                                   var28.scrollY -= var29;
                                                   Client.field526 += var29;
                                                   class33.method682(var28);
                                                }

                                                if(var23 + var25 + 32 > Rasterizer2D.field3176 && var28.scrollY < var28.scrollHeight - var28.height) {
                                                   var29 = (32 + var25 + var23 - Rasterizer2D.field3176) * Client.field354 / 3;
                                                   if(var29 > Client.field354 * 10) {
                                                      var29 = Client.field354 * 10;
                                                   }

                                                   if(var29 > var28.scrollHeight - var28.height - var28.scrollY) {
                                                      var29 = var28.scrollHeight - var28.height - var28.scrollY;
                                                   }

                                                   var28.scrollY += var29;
                                                   Client.field526 -= var29;
                                                   class33.method682(var28);
                                                }
                                             }
                                          } else if(var10 == class57.field1063 && Client.field391 == var19) {
                                             var38.method4223(var22, var23, 128);
                                          } else {
                                             var38.method4144(var22, var23);
                                          }
                                       } else {
                                          class33.method682(var10);
                                       }
                                    }
                                 }

                                 ++var19;
                              }
                           }
                        } else if(var10.type == 3) {
                           if(ChatMessages.method829(var10)) {
                              var19 = var10.field2289;
                              if(var10 == class15.field167 && var10.field2224 != 0) {
                                 var19 = var10.field2224;
                              }
                           } else {
                              var19 = var10.textColor;
                              if(class15.field167 == var10 && var10.field2223 != 0) {
                                 var19 = var10.field2223;
                              }
                           }

                           if(var10.field2225) {
                              switch(var10.field2226.field3184) {
                              case 1:
                                 Rasterizer2D.method3992(var12, var13, var10.width, var10.height, var10.textColor, var10.field2289, 256 - (var10.opacity & 255), 256 - (var10.field2228 & 255));
                                 break;
                              case 2:
                                 Rasterizer2D.method4047(var12, var13, var10.width, var10.height, var10.textColor, var10.field2289, 256 - (var10.opacity & 255), 256 - (var10.field2228 & 255));
                                 break;
                              case 3:
                                 Rasterizer2D.method3994(var12, var13, var10.width, var10.height, var10.textColor, var10.field2289, 256 - (var10.opacity & 255), 256 - (var10.field2228 & 255));
                                 break;
                              case 4:
                                 Rasterizer2D.method3995(var12, var13, var10.width, var10.height, var10.textColor, var10.field2289, 256 - (var10.opacity & 255), 256 - (var10.field2228 & 255));
                                 break;
                              default:
                                 if(var14 == 0) {
                                    Rasterizer2D.method4020(var12, var13, var10.width, var10.height, var19);
                                 } else {
                                    Rasterizer2D.method3990(var12, var13, var10.width, var10.height, var19, 256 - (var14 & 255));
                                 }
                              }
                           } else if(var14 == 0) {
                              Rasterizer2D.method3997(var12, var13, var10.width, var10.height, var19);
                           } else {
                              Rasterizer2D.method4052(var12, var13, var10.width, var10.height, var19, 256 - (var14 & 255));
                           }
                        } else {
                           Font var47;
                           if(var10.type == 4) {
                              var47 = var10.method3178();
                              if(var47 == null) {
                                 if(Widget.field2326) {
                                    class33.method682(var10);
                                 }
                              } else {
                                 String var49 = var10.text;
                                 if(ChatMessages.method829(var10)) {
                                    var20 = var10.field2289;
                                    if(var10 == class15.field167 && var10.field2224 != 0) {
                                       var20 = var10.field2224;
                                    }

                                    if(var10.field2312.length() > 0) {
                                       var49 = var10.field2312;
                                    }
                                 } else {
                                    var20 = var10.textColor;
                                    if(class15.field167 == var10 && var10.field2223 != 0) {
                                       var20 = var10.field2223;
                                    }
                                 }

                                 if(var10.hasScript && var10.item != -1) {
                                    ItemComposition var55 = getItemDefinition(var10.item);
                                    var49 = var55.name;
                                    if(null == var49) {
                                       var49 = "null";
                                    }

                                    if((var55.isStackable == 1 || var10.stackSize != 1) && var10.stackSize != -1) {
                                       var49 = Client.method568(16748608) + var49 + "</col>" + " " + 'x' + class164.method3115(var10.stackSize);
                                    }
                                 }

                                 if(var10 == Client.field441) {
                                    Object var10000 = null;
                                    var49 = "Please wait...";
                                    var20 = var10.textColor;
                                 }

                                 if(!var10.hasScript) {
                                    var49 = CombatInfo1.method606(var49, var10);
                                 }

                                 var47.method3866(var49, var12, var13, var10.width, var10.height, var20, var10.field2261?0:-1, var10.field2259, var10.field2263, var10.field2258);
                              }
                           } else if(var10.type == 5) {
                              SpritePixels var48;
                              if(!var10.hasScript) {
                                 var48 = var10.method3173(ChatMessages.method829(var10));
                                 if(var48 != null) {
                                    var48.method4144(var12, var13);
                                 } else if(Widget.field2326) {
                                    class33.method682(var10);
                                 }
                              } else {
                                 if(var10.item != -1) {
                                    var48 = class143.createSprite(var10.item, var10.stackSize, var10.borderThickness, var10.sprite2, var10.field2187, false);
                                 } else {
                                    var48 = var10.method3173(false);
                                 }

                                 if(null == var48) {
                                    if(Widget.field2326) {
                                       class33.method682(var10);
                                    }
                                 } else {
                                    var20 = var48.maxWidth;
                                    var21 = var48.maxHeight;
                                    if(!var10.field2234) {
                                       var22 = var10.width * 4096 / var20;
                                       if(var10.field2233 != 0) {
                                          var48.method4148(var12 + var10.width / 2, var13 + var10.height / 2, var10.field2233, var22);
                                       } else if(var14 != 0) {
                                          var48.method4193(var12, var13, var10.width, var10.height, 256 - (var14 & 255));
                                       } else if(var10.width == var20 && var10.height == var21) {
                                          var48.method4144(var12, var13);
                                       } else {
                                          var48.method4146(var12, var13, var10.width, var10.height);
                                       }
                                    } else {
                                       Rasterizer2D.method3986(var12, var13, var12 + var10.width, var13 + var10.height);
                                       var22 = (var10.width + (var20 - 1)) / var20;
                                       var23 = (var21 - 1 + var10.height) / var21;

                                       for(var24 = 0; var24 < var22; ++var24) {
                                          for(var25 = 0; var25 < var23; ++var25) {
                                             if(var10.field2233 != 0) {
                                                var48.method4148(var20 / 2 + var24 * var20 + var12, var13 + var25 * var21 + var21 / 2, var10.field2233, 4096);
                                             } else if(var14 != 0) {
                                                var48.method4223(var24 * var20 + var12, var21 * var25 + var13, 256 - (var14 & 255));
                                             } else {
                                                var48.method4144(var20 * var24 + var12, var13 + var21 * var25);
                                             }
                                          }
                                       }

                                       Rasterizer2D.method4008(var2, var3, var4, var5);
                                    }
                                 }
                              }
                           } else {
                              ItemComposition var39;
                              if(var10.type == 6) {
                                 boolean var43 = ChatMessages.method829(var10);
                                 if(var43) {
                                    var20 = var10.field2299;
                                 } else {
                                    var20 = var10.field2243;
                                 }

                                 Model var46 = null;
                                 var22 = 0;
                                 if(var10.item != -1) {
                                    var39 = getItemDefinition(var10.item);
                                    if(null != var39) {
                                       var39 = var39.method3652(var10.stackSize);
                                       var46 = var39.getModel(1);
                                       if(var46 != null) {
                                          var46.method1602();
                                          var22 = var46.modelHeight / 2;
                                       } else {
                                          class33.method682(var10);
                                       }
                                    }
                                 } else if(var10.modelType == 5) {
                                    if(var10.modelId == 0) {
                                       var46 = Client.field550.method3126((Sequence)null, -1, (Sequence)null, -1);
                                    } else {
                                       var46 = class16.localPlayer.getModel();
                                    }
                                 } else if(var20 == -1) {
                                    var46 = var10.method3180((Sequence)null, -1, var43, class16.localPlayer.composition);
                                    if(null == var46 && Widget.field2326) {
                                       class33.method682(var10);
                                    }
                                 } else {
                                    Sequence var54 = class146.getAnimation(var20);
                                    var46 = var10.method3180(var54, var10.field2221, var43, class16.localPlayer.composition);
                                    if(null == var46 && Widget.field2326) {
                                       class33.method682(var10);
                                    }
                                 }

                                 class84.method1648(var12 + var10.width / 2, var10.height / 2 + var13);
                                 var23 = class84.field1438[var10.rotationX] * var10.field2250 >> 16;
                                 var24 = var10.field2250 * class84.field1452[var10.rotationX] >> 16;
                                 if(null != var46) {
                                    if(!var10.hasScript) {
                                       var46.method1583(0, var10.rotationZ, 0, var10.rotationX, 0, var23, var24);
                                    } else {
                                       var46.method1602();
                                       if(var10.field2246) {
                                          var46.method1572(0, var10.rotationZ, var10.rotationY, var10.rotationX, var10.field2245, var10.field2247 + var22 + var23, var24 + var10.field2247, var10.field2250);
                                       } else {
                                          var46.method1583(0, var10.rotationZ, var10.rotationY, var10.rotationX, var10.field2245, var23 + var22 + var10.field2247, var24 + var10.field2247);
                                       }
                                    }
                                 }

                                 class84.method1631();
                              } else {
                                 if(var10.type == 7) {
                                    var47 = var10.method3178();
                                    if(var47 == null) {
                                       if(Widget.field2326) {
                                          class33.method682(var10);
                                       }
                                       continue;
                                    }

                                    var20 = 0;

                                    for(var21 = 0; var21 < var10.field2241; ++var21) {
                                       for(var22 = 0; var22 < var10.originalWidth; ++var22) {
                                          if(var10.itemIds[var20] > 0) {
                                             var39 = getItemDefinition(var10.itemIds[var20] - 1);
                                             String var40;
                                             if(var39.isStackable != 1 && var10.itemQuantities[var20] == 1) {
                                                var40 = Client.method568(16748608) + var39.name + "</col>";
                                             } else {
                                                var40 = Client.method568(16748608) + var39.name + "</col>" + " " + 'x' + class164.method3115(var10.itemQuantities[var20]);
                                             }

                                             var25 = var12 + var22 * (var10.field2262 + 115);
                                             var26 = (12 + var10.field2318) * var21 + var13;
                                             if(var10.field2259 == 0) {
                                                var47.method3875(var40, var25, var26, var10.textColor, var10.field2261?0:-1);
                                             } else if(var10.field2259 == 1) {
                                                var47.method3910(var40, var10.width / 2 + var25, var26, var10.textColor, var10.field2261?0:-1);
                                             } else {
                                                var47.method3877(var40, var10.width + var25 - 1, var26, var10.textColor, var10.field2261?0:-1);
                                             }
                                          }

                                          ++var20;
                                       }
                                    }
                                 }

                                 int var27;
                                 if(var10.type == 8 && var10 == Ignore.field201 && Client.field427 == Client.field507) {
                                    var19 = 0;
                                    var20 = 0;
                                    Font var36 = class178.field2670;
                                    String var41 = var10.text;

                                    String var51;
                                    for(var41 = CombatInfo1.method606(var41, var10); var41.length() > 0; var20 += var36.field3100 + 1) {
                                       var24 = var41.indexOf("<br>");
                                       if(var24 != -1) {
                                          var51 = var41.substring(0, var24);
                                          var41 = var41.substring(4 + var24);
                                       } else {
                                          var51 = var41;
                                          var41 = "";
                                       }

                                       var25 = var36.method3870(var51);
                                       if(var25 > var19) {
                                          var19 = var25;
                                       }
                                    }

                                    var19 += 6;
                                    var20 += 7;
                                    var24 = var10.width + var12 - 5 - var19;
                                    var25 = var10.height + var13 + 5;
                                    if(var24 < 5 + var12) {
                                       var24 = var12 + 5;
                                    }

                                    if(var19 + var24 > var4) {
                                       var24 = var4 - var19;
                                    }

                                    if(var20 + var25 > var5) {
                                       var25 = var5 - var20;
                                    }

                                    Rasterizer2D.method4020(var24, var25, var19, var20, 16777120);
                                    Rasterizer2D.method3997(var24, var25, var19, var20, 0);
                                    var41 = var10.text;
                                    var26 = 2 + var25 + var36.field3100;

                                    for(var41 = CombatInfo1.method606(var41, var10); var41.length() > 0; var26 += var36.field3100 + 1) {
                                       var27 = var41.indexOf("<br>");
                                       if(var27 != -1) {
                                          var51 = var41.substring(0, var27);
                                          var41 = var41.substring(var27 + 4);
                                       } else {
                                          var51 = var41;
                                          var41 = "";
                                       }

                                       var36.method3875(var51, 3 + var24, var26, 0, -1);
                                    }
                                 }

                                 if(var10.type == 9) {
                                    if(var10.field2229 == 1) {
                                       if(var10.field2230) {
                                          var19 = var12;
                                          var20 = var13 + var10.height;
                                          var21 = var12 + var10.width;
                                          var22 = var13;
                                       } else {
                                          var19 = var12;
                                          var20 = var13;
                                          var21 = var12 + var10.width;
                                          var22 = var10.height + var13;
                                       }

                                       Rasterizer2D.method4002(var19, var20, var21, var22, var10.textColor);
                                    } else {
                                       var19 = var10.width >= 0?var10.width:-var10.width;
                                       var20 = var10.height >= 0?var10.height:-var10.height;
                                       var21 = var19;
                                       if(var19 < var20) {
                                          var21 = var20;
                                       }

                                       if(var21 != 0) {
                                          var22 = (var10.width << 16) / var21;
                                          var23 = (var10.height << 16) / var21;
                                          if(var23 <= var22) {
                                             var22 = -var22;
                                          } else {
                                             var23 = -var23;
                                          }

                                          var24 = var23 * var10.field2229 >> 17;
                                          var25 = 1 + var10.field2229 * var23 >> 17;
                                          var26 = var10.field2229 * var22 >> 17;
                                          var27 = 1 + var22 * var10.field2229 >> 17;
                                          int var42 = var12 + var24;
                                          var29 = var12 - var25;
                                          int var30 = var12 + var10.width - var25;
                                          int var31 = var12 + var10.width + var24;
                                          int var32 = var13 + var26;
                                          int var33 = var13 - var27;
                                          int var34 = var13 + var10.height - var27;
                                          int var35 = var26 + var10.height + var13;
                                          class84.setRasterClippingEnabled(var42, var29, var30);
                                          class84.rasterFlat(var32, var33, var34, var42, var29, var30, var10.textColor);
                                          class84.setRasterClippingEnabled(var42, var30, var31);
                                          class84.rasterFlat(var32, var34, var35, var42, var30, var31, var10.textColor);
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

   @ObfuscatedName("dx")
   @ObfuscatedSignature(
      signature = "(LWidget;S)I",
      garbageValue = "-18304"
   )
   static int method724(Widget var0) {
      class133 var1 = (class133)Client.widgetFlags.method2374((long)var0.index + ((long)var0.id << 32));
      return var1 != null?var1.field1897:var0.field2268;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Lclass182;Ljava/lang/String;Ljava/lang/String;B)LSpritePixels;",
      garbageValue = "-1"
   )
   public static SpritePixels method725(class182 var0, String var1, String var2) {
      int var3 = var0.method3276(var1);
      int var4 = var0.method3287(var3, var2);
      return class186.method3417(var0, var3, var4);
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(IB)LItemComposition;",
      garbageValue = "-27"
   )
   @Export("getItemDefinition")
   public static ItemComposition getItemDefinition(int var0) {
      ItemComposition var1 = (ItemComposition)ItemComposition.field2942.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = ItemComposition.field2941.getConfigData(10, var0);
         var1 = new ItemComposition();
         var1.id = var0;
         if(null != var2) {
            var1.loadBuffer(new Buffer(var2));
         }

         var1.method3651();
         if(var1.notedTemplate != -1) {
            var1.method3647(getItemDefinition(var1.notedTemplate), getItemDefinition(var1.note));
         }

         if(var1.field2989 != -1) {
            var1.method3691(getItemDefinition(var1.field2989), getItemDefinition(var1.field2962));
         }

         if(var1.field2991 != -1) {
            var1.method3649(getItemDefinition(var1.field2991), getItemDefinition(var1.field2990));
         }

         if(!ItemComposition.isMembersWorld && var1.isMembers) {
            var1.name = "Members object";
            var1.field2987 = false;
            var1.groundActions = null;
            var1.inventoryActions = null;
            var1.team = 0;
         }

         ItemComposition.field2942.put(var1, (long)var0);
         return var1;
      }
   }
}
