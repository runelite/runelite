import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("e")
public class class13 {
   @ObfuscatedName("g")
   static class179 field139;
   @ObfuscatedName("qx")
   @ObfuscatedGetter(
      intValue = -72125639
   )
   static int field143;
   @ObfuscatedName("gs")
   static Widget field144;
   @ObfuscatedName("nt")
   static class57 field150;

   @ObfuscatedName("bq")
   @ObfuscatedSignature(
      signature = "(LPlayer;IIBI)V",
      garbageValue = "1782460589"
   )
   static final void method170(Player var0, int var1, int var2, byte var3) {
      int var4 = var0.pathX[0];
      int var5 = var0.pathY[0];
      int var6 = var0.method215();
      if(var4 >= var6 && var4 < 104 - var6 && var5 >= var6 && var5 < 104 - var6) {
         if(var1 >= var6 && var1 < 104 - var6 && var2 >= var6 && var2 < 104 - var6) {
            int var7 = class41.method771(var4, var5, var0.method215(), XClanMember.method239(var1, var2), Client.collisionMaps[var0.field261], true, Client.field561, Client.field562);
            if(var7 >= 1) {
               for(int var8 = 0; var8 < var7 - 1; ++var8) {
                  var0.method219(Client.field561[var8], Client.field562[var8], var3);
               }

            }
         }
      }
   }

   @ObfuscatedName("cn")
   @ObfuscatedSignature(
      signature = "([LWidget;IIIIIIIII)V",
      garbageValue = "468098333"
   )
   @Export("gameDraw")
   static final void gameDraw(Widget[] var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
      class219.method3965(var2, var3, var4, var5);
      class84.method1614();

      for(int var9 = 0; var9 < var0.length; ++var9) {
         Widget var10 = var0[var9];
         if(var10 != null && (var1 == var10.parentId || var1 == -1412584499 && Client.field453 == var10)) {
            int var11;
            if(var8 == -1) {
               Client.widgetPositionX[Client.field533] = var6 + var10.relativeX;
               Client.widgetPositionY[Client.field533] = var10.relativeY + var7;
               Client.widgetBoundsWidth[Client.field533] = var10.width;
               Client.widgetBoundsHeight[Client.field533] = var10.height;
               var11 = ++Client.field533 - 1;
            } else {
               var11 = var8;
            }

            var10.boundsIndex = var11;
            var10.field2317 = Client.gameCycle;
            if(!var10.field2184 || !WallObject.method1846(var10)) {
               int var12;
               if(var10.contentType > 0) {
                  var12 = var10.contentType;
                  if(var12 == 324) {
                     if(Client.field555 == -1) {
                        Client.field555 = var10.textureId;
                        Client.field556 = var10.field2240;
                     }

                     if(Client.field560.isFemale) {
                        var10.textureId = Client.field555;
                     } else {
                        var10.textureId = Client.field556;
                     }
                  } else if(var12 == 325) {
                     if(Client.field555 == -1) {
                        Client.field555 = var10.textureId;
                        Client.field556 = var10.field2240;
                     }

                     if(Client.field560.isFemale) {
                        var10.textureId = Client.field556;
                     } else {
                        var10.textureId = Client.field555;
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
               int var13 = var7 + var10.relativeY;
               int var14 = var10.opacity;
               int var15;
               int var16;
               if(Client.field453 == var10) {
                  if(var1 != -1412584499 && !var10.field2263) {
                     class11.field122 = var0;
                     class107.field1721 = var6;
                     Friend.field163 = var7;
                     continue;
                  }

                  if(Client.field464 && Client.field458) {
                     var15 = class115.field1788;
                     var16 = class115.field1789;
                     var15 -= Client.field455;
                     var16 -= Client.field550;
                     if(var15 < Client.field490) {
                        var15 = Client.field490;
                     }

                     if(var15 + var10.width > Client.field490 + Client.field454.width) {
                        var15 = Client.field454.width + Client.field490 - var10.width;
                     }

                     if(var16 < Client.field284) {
                        var16 = Client.field284;
                     }

                     if(var16 + var10.height > Client.field454.height + Client.field284) {
                        var16 = Client.field284 + Client.field454.height - var10.height;
                     }

                     var12 = var15;
                     var13 = var16;
                  }

                  if(!var10.field2263) {
                     var14 = 128;
                  }
               }

               int var17;
               int var18;
               int var20;
               int var22;
               int var36;
               int var39;
               if(var10.type == 2) {
                  var15 = var2;
                  var16 = var3;
                  var17 = var4;
                  var18 = var5;
               } else if(var10.type == 9) {
                  var36 = var12;
                  var20 = var13;
                  var39 = var10.width + var12;
                  var22 = var10.height + var13;
                  if(var39 < var12) {
                     var36 = var39;
                     var39 = var12;
                  }

                  if(var22 < var13) {
                     var20 = var22;
                     var22 = var13;
                  }

                  ++var39;
                  ++var22;
                  var15 = var36 > var2?var36:var2;
                  var16 = var20 > var3?var20:var3;
                  var17 = var39 < var4?var39:var4;
                  var18 = var22 < var5?var22:var5;
               } else {
                  var36 = var12 + var10.width;
                  var20 = var10.height + var13;
                  var15 = var12 > var2?var12:var2;
                  var16 = var13 > var3?var13:var3;
                  var17 = var36 < var4?var36:var4;
                  var18 = var20 < var5?var20:var5;
               }

               if(!var10.field2184 || var15 < var17 && var16 < var18) {
                  if(var10.contentType != 0) {
                     if(var10.contentType == 1336) {
                        if(Client.field296) {
                           var13 += 15;
                           class22.field235.method3869("Fps:" + GameEngine.field1763, var12 + var10.width, var13, 16776960, -1);
                           var13 += 15;
                           Runtime var47 = Runtime.getRuntime();
                           var20 = (int)((var47.totalMemory() - var47.freeMemory()) / 1024L);
                           var39 = 16776960;
                           if(var20 > '耀' && Client.field286) {
                              var39 = 16711680;
                           }

                           if(var20 > 65536 && !Client.field286) {
                              var39 = 16711680;
                           }

                           class22.field235.method3869("Mem:" + var20 + "k", var10.width + var12, var13, var39, -1);
                           var13 += 15;
                        }
                        continue;
                     }

                     if(var10.contentType == 1337) {
                        Client.field429 = var12;
                        Client.field430 = var13;
                        class40.method742(var12, var13, var10.width, var10.height);
                        Client.field485[var10.boundsIndex] = true;
                        class219.method3965(var2, var3, var4, var5);
                        continue;
                     }

                     if(var10.contentType == 1338) {
                        class194.method3544(var10, var12, var13, var11);
                        class219.method3965(var2, var3, var4, var5);
                        continue;
                     }

                     if(var10.contentType == 1339) {
                        class164 var45 = var10.method3173(false);
                        if(var45 != null) {
                           if(Client.field543 < 3) {
                              class8.field73.method4133(var12, var13, var45.field2143, var45.field2139, 25, 25, Client.mapAngle, 256, var45.field2138, var45.field2141);
                           } else {
                              class219.method3984(var12, var13, 0, var45.field2138, var45.field2141);
                           }
                        }

                        class219.method3965(var2, var3, var4, var5);
                        continue;
                     }
                  }

                  if(var10.type == 0) {
                     if(!var10.field2184 && WallObject.method1846(var10) && class188.field2758 != var10) {
                        continue;
                     }

                     if(!var10.field2184) {
                        if(var10.scrollY > var10.scrollHeight - var10.height) {
                           var10.scrollY = var10.scrollHeight - var10.height;
                        }

                        if(var10.scrollY < 0) {
                           var10.scrollY = 0;
                        }
                     }

                     gameDraw(var0, var10.id, var15, var16, var17, var18, var12 - var10.scrollX, var13 - var10.scrollY, var11);
                     if(null != var10.children) {
                        gameDraw(var10.children, var10.id, var15, var16, var17, var18, var12 - var10.scrollX, var13 - var10.scrollY, var11);
                     }

                     WidgetNode var19 = (WidgetNode)Client.componentTable.method2339((long)var10.id);
                     if(var19 != null) {
                        class40.method743(var19.id, var15, var16, var17, var18, var12, var13, var11);
                     }

                     class219.method3965(var2, var3, var4, var5);
                     class84.method1614();
                  }

                  if(Client.isResized || Client.field487[var11] || Client.field492 > 1) {
                     int var24;
                     int var37;
                     if(var10.type == 0 && !var10.field2184 && var10.scrollHeight > var10.height) {
                        var36 = var12 + var10.width;
                        var20 = var10.scrollY;
                        var39 = var10.height;
                        var22 = var10.scrollHeight;
                        TextureProvider.field1200[0].method4066(var36, var13);
                        TextureProvider.field1200[1].method4066(var36, var39 + var13 - 16);
                        class219.method3993(var36, var13 + 16, 16, var39 - 32, Client.field360);
                        var37 = (var39 - 32) * var39 / var22;
                        if(var37 < 8) {
                           var37 = 8;
                        }

                        var24 = (var39 - 32 - var37) * var20 / (var22 - var39);
                        class219.method3993(var36, var24 + var13 + 16, 16, var37, Client.field478);
                        class219.method3981(var36, var24 + 16 + var13, var37, Client.field363);
                        class219.method3981(var36 + 1, var24 + var13 + 16, var37, Client.field363);
                        class219.method3979(var36, var24 + 16 + var13, 16, Client.field363);
                        class219.method3979(var36, 17 + var13 + var24, 16, Client.field363);
                        class219.method3981(var36 + 15, var13 + 16 + var24, var37, Client.field451);
                        class219.method3981(14 + var36, var13 + 17 + var24, var37 - 1, Client.field451);
                        class219.method3979(var36, var37 + var13 + 15 + var24, 16, Client.field451);
                        class219.method3979(var36 + 1, var24 + 14 + var13 + var37, 15, Client.field451);
                     }

                     if(var10.type != 1) {
                        int var25;
                        int var26;
                        int var29;
                        if(var10.type == 2) {
                           var36 = 0;

                           for(var20 = 0; var20 < var10.field2279; ++var20) {
                              for(var39 = 0; var39 < var10.field2237; ++var39) {
                                 var22 = var12 + var39 * (32 + var10.field2251);
                                 var37 = var13 + var20 * (var10.field2252 + 32);
                                 if(var36 < 20) {
                                    var22 += var10.field2253[var36];
                                    var37 += var10.field2254[var36];
                                 }

                                 if(var10.itemIds[var36] <= 0) {
                                    if(null != var10.field2190 && var36 < 20) {
                                       SpritePixels var53 = var10.method3171(var36);
                                       if(null != var53) {
                                          var53.method4122(var22, var37);
                                       } else if(Widget.field2183) {
                                          class6.method87(var10);
                                       }
                                    }
                                 } else {
                                    boolean var51 = false;
                                    boolean var52 = false;
                                    var26 = var10.itemIds[var36] - 1;
                                    if(32 + var22 > var2 && var22 < var4 && var37 + 32 > var3 && var37 < var5 || class31.field715 == var10 && Client.field396 == var36) {
                                       SpritePixels var41;
                                       if(Client.field447 == 1 && class15.field169 == var36 && var10.id == ObjectComposition.field2930) {
                                          var41 = class41.createSprite(var26, var10.itemQuantities[var36], 2, 0, 2, false);
                                       } else {
                                          var41 = class41.createSprite(var26, var10.itemQuantities[var36], 1, 3153952, 2, false);
                                       }

                                       if(null != var41) {
                                          if(var10 == class31.field715 && Client.field396 == var36) {
                                             var24 = class115.field1788 - Client.field397;
                                             var25 = class115.field1789 - Client.field398;
                                             if(var24 < 5 && var24 > -5) {
                                                var24 = 0;
                                             }

                                             if(var25 < 5 && var25 > -5) {
                                                var25 = 0;
                                             }

                                             if(Client.field401 < 5) {
                                                var24 = 0;
                                                var25 = 0;
                                             }

                                             var41.method4148(var22 + var24, var37 + var25, 128);
                                             if(var1 != -1) {
                                                Widget var28 = var0[var1 & '\uffff'];
                                                if(var25 + var37 < class219.field3172 && var28.scrollY > 0) {
                                                   var29 = (class219.field3172 - var37 - var25) * Client.field462 / 3;
                                                   if(var29 > Client.field462 * 10) {
                                                      var29 = Client.field462 * 10;
                                                   }

                                                   if(var29 > var28.scrollY) {
                                                      var29 = var28.scrollY;
                                                   }

                                                   var28.scrollY -= var29;
                                                   Client.field398 += var29;
                                                   class6.method87(var28);
                                                }

                                                if(32 + var25 + var37 > class219.field3173 && var28.scrollY < var28.scrollHeight - var28.height) {
                                                   var29 = (var37 + var25 + 32 - class219.field3173) * Client.field462 / 3;
                                                   if(var29 > Client.field462 * 10) {
                                                      var29 = Client.field462 * 10;
                                                   }

                                                   if(var29 > var28.scrollHeight - var28.height - var28.scrollY) {
                                                      var29 = var28.scrollHeight - var28.height - var28.scrollY;
                                                   }

                                                   var28.scrollY += var29;
                                                   Client.field398 -= var29;
                                                   class6.method87(var28);
                                                }
                                             }
                                          } else if(var10 == PlayerComposition.field2164 && Client.field395 == var36) {
                                             var41.method4148(var22, var37, 128);
                                          } else {
                                             var41.method4122(var22, var37);
                                          }
                                       } else {
                                          class6.method87(var10);
                                       }
                                    }
                                 }

                                 ++var36;
                              }
                           }
                        } else if(var10.type == 3) {
                           if(class94.method1868(var10)) {
                              var36 = var10.field2211;
                              if(var10 == class188.field2758 && var10.field2213 != 0) {
                                 var36 = var10.field2213;
                              }
                           } else {
                              var36 = var10.textColor;
                              if(class188.field2758 == var10 && var10.field2212 != 0) {
                                 var36 = var10.field2212;
                              }
                           }

                           if(var10.field2235) {
                              switch(var10.field2219.field3186) {
                              case 1:
                                 class219.method4044(var12, var13, var10.width, var10.height, var10.textColor, var10.field2211, 256 - (var10.opacity & 255), 256 - (var10.field2280 & 255));
                                 break;
                              case 2:
                                 class219.method4015(var12, var13, var10.width, var10.height, var10.textColor, var10.field2211, 256 - (var10.opacity & 255), 256 - (var10.field2280 & 255));
                                 break;
                              case 3:
                                 class219.method4042(var12, var13, var10.width, var10.height, var10.textColor, var10.field2211, 256 - (var10.opacity & 255), 256 - (var10.field2280 & 255));
                                 break;
                              case 4:
                                 class219.method3975(var12, var13, var10.width, var10.height, var10.textColor, var10.field2211, 256 - (var10.opacity & 255), 256 - (var10.field2280 & 255));
                                 break;
                              default:
                                 if(var14 == 0) {
                                    class219.method3993(var12, var13, var10.width, var10.height, var36);
                                 } else {
                                    class219.method3976(var12, var13, var10.width, var10.height, var36, 256 - (var14 & 255));
                                 }
                              }
                           } else if(var14 == 0) {
                              class219.method3977(var12, var13, var10.width, var10.height, var36);
                           } else {
                              class219.method3978(var12, var13, var10.width, var10.height, var36, 256 - (var14 & 255));
                           }
                        } else {
                           class208 var43;
                           if(var10.type == 4) {
                              var43 = var10.method3178();
                              if(null == var43) {
                                 if(Widget.field2183) {
                                    class6.method87(var10);
                                 }
                              } else {
                                 String var49 = var10.text;
                                 if(class94.method1868(var10)) {
                                    var20 = var10.field2211;
                                    if(var10 == class188.field2758 && var10.field2213 != 0) {
                                       var20 = var10.field2213;
                                    }

                                    if(var10.field2246.length() > 0) {
                                       var49 = var10.field2246;
                                    }
                                 } else {
                                    var20 = var10.textColor;
                                    if(var10 == class188.field2758 && var10.field2212 != 0) {
                                       var20 = var10.field2212;
                                    }
                                 }

                                 if(var10.field2184 && var10.item != -1) {
                                    ItemComposition var55 = class88.getItemDefinition(var10.item);
                                    var49 = var55.name;
                                    if(var49 == null) {
                                       var49 = "null";
                                    }

                                    if((var55.isStackable == 1 || var10.stackSize != 1) && var10.stackSize != -1) {
                                       var49 = class32.method691(16748608) + var49 + "</col>" + " " + 'x' + class211.method3946(var10.stackSize);
                                    }
                                 }

                                 if(Client.field537 == var10) {
                                    Object var10000 = null;
                                    var49 = "Please wait...";
                                    var20 = var10.textColor;
                                 }

                                 if(!var10.field2184) {
                                    var49 = class175.method3241(var49, var10);
                                 }

                                 var43.method3871(var49, var12, var13, var10.width, var10.height, var20, var10.field2218?0:-1, var10.field2176, var10.field2214, var10.field2247);
                              }
                           } else if(var10.type == 5) {
                              SpritePixels var44;
                              if(!var10.field2184) {
                                 var44 = var10.method3169(class94.method1868(var10));
                                 if(null != var44) {
                                    var44.method4122(var12, var13);
                                 } else if(Widget.field2183) {
                                    class6.method87(var10);
                                 }
                              } else {
                                 if(var10.item != -1) {
                                    var44 = class41.createSprite(var10.item, var10.stackSize, var10.borderThickness, var10.sprite2, var10.field2244, false);
                                 } else {
                                    var44 = var10.method3169(false);
                                 }

                                 if(var44 == null) {
                                    if(Widget.field2183) {
                                       class6.method87(var10);
                                    }
                                 } else {
                                    var20 = var44.field3205;
                                    var39 = var44.field3207;
                                    if(!var10.field2223) {
                                       var22 = var10.width * 4096 / var20;
                                       if(var10.field2222 != 0) {
                                          var44.method4135(var10.width / 2 + var12, var13 + var10.height / 2, var10.field2222, var22);
                                       } else if(var14 != 0) {
                                          var44.method4130(var12, var13, var10.width, var10.height, 256 - (var14 & 255));
                                       } else if(var10.width == var20 && var10.height == var39) {
                                          var44.method4122(var12, var13);
                                       } else {
                                          var44.method4199(var12, var13, var10.width, var10.height);
                                       }
                                    } else {
                                       class219.method4000(var12, var13, var10.width + var12, var13 + var10.height);
                                       var22 = (var10.width + (var20 - 1)) / var20;
                                       var37 = (var39 - 1 + var10.height) / var39;

                                       for(var24 = 0; var24 < var22; ++var24) {
                                          for(var25 = 0; var25 < var37; ++var25) {
                                             if(var10.field2222 != 0) {
                                                var44.method4135(var20 / 2 + var12 + var24 * var20, var39 / 2 + var13 + var25 * var39, var10.field2222, 4096);
                                             } else if(var14 != 0) {
                                                var44.method4148(var12 + var24 * var20, var13 + var25 * var39, 256 - (var14 & 255));
                                             } else {
                                                var44.method4122(var24 * var20 + var12, var25 * var39 + var13);
                                             }
                                          }
                                       }

                                       class219.method3965(var2, var3, var4, var5);
                                    }
                                 }
                              }
                           } else {
                              ItemComposition var23;
                              if(var10.type == 6) {
                                 boolean var54 = class94.method1868(var10);
                                 if(var54) {
                                    var20 = var10.field2233;
                                 } else {
                                    var20 = var10.field2250;
                                 }

                                 Model var46 = null;
                                 var22 = 0;
                                 if(var10.item != -1) {
                                    var23 = class88.getItemDefinition(var10.item);
                                    if(var23 != null) {
                                       var23 = var23.method3641(var10.stackSize);
                                       var46 = var23.getModel(1);
                                       if(var46 != null) {
                                          var46.method1532();
                                          var22 = var46.modelHeight / 2;
                                       } else {
                                          class6.method87(var10);
                                       }
                                    }
                                 } else if(var10.modelType == 5) {
                                    if(var10.modelId == 0) {
                                       var46 = Client.field560.method3152((Sequence)null, -1, (Sequence)null, -1);
                                    } else {
                                       var46 = class148.localPlayer.getModel();
                                    }
                                 } else if(var20 == -1) {
                                    var46 = var10.method3166((Sequence)null, -1, var54, class148.localPlayer.composition);
                                    if(null == var46 && Widget.field2183) {
                                       class6.method87(var10);
                                    }
                                 } else {
                                    Sequence var50 = CombatInfo2.getAnimation(var20);
                                    var46 = var10.method3166(var50, var10.field2215, var54, class148.localPlayer.composition);
                                    if(null == var46 && Widget.field2183) {
                                       class6.method87(var10);
                                    }
                                 }

                                 class84.method1604(var12 + var10.width / 2, var10.height / 2 + var13);
                                 var37 = class84.field1438[var10.rotationX] * var10.field2239 >> 16;
                                 var24 = var10.field2239 * class84.field1428[var10.rotationX] >> 16;
                                 if(var46 != null) {
                                    if(!var10.field2184) {
                                       var46.method1531(0, var10.rotationZ, 0, var10.rotationX, 0, var37, var24);
                                    } else {
                                       var46.method1532();
                                       if(var10.field2242) {
                                          var46.method1592(0, var10.rotationZ, var10.rotationY, var10.rotationX, var10.field2234, var10.field2178 + var37 + var22, var24 + var10.field2178, var10.field2239);
                                       } else {
                                          var46.method1531(0, var10.rotationZ, var10.rotationY, var10.rotationX, var10.field2234, var10.field2178 + var22 + var37, var24 + var10.field2178);
                                       }
                                    }
                                 }

                                 class84.method1644();
                              } else {
                                 if(var10.type == 7) {
                                    var43 = var10.method3178();
                                    if(var43 == null) {
                                       if(Widget.field2183) {
                                          class6.method87(var10);
                                       }
                                       continue;
                                    }

                                    var20 = 0;

                                    for(var39 = 0; var39 < var10.field2279; ++var39) {
                                       for(var22 = 0; var22 < var10.field2237; ++var22) {
                                          if(var10.itemIds[var20] > 0) {
                                             var23 = class88.getItemDefinition(var10.itemIds[var20] - 1);
                                             String var38;
                                             if(var23.isStackable != 1 && var10.itemQuantities[var20] == 1) {
                                                var38 = class32.method691(16748608) + var23.name + "</col>";
                                             } else {
                                                var38 = class32.method691(16748608) + var23.name + "</col>" + " " + 'x' + class211.method3946(var10.itemQuantities[var20]);
                                             }

                                             var25 = var12 + (115 + var10.field2251) * var22;
                                             var26 = var13 + (12 + var10.field2252) * var39;
                                             if(var10.field2176 == 0) {
                                                var43.method3867(var38, var25, var26, var10.textColor, var10.field2218?0:-1);
                                             } else if(var10.field2176 == 1) {
                                                var43.method3870(var38, var10.width / 2 + var25, var26, var10.textColor, var10.field2218?0:-1);
                                             } else {
                                                var43.method3869(var38, var10.width + var25 - 1, var26, var10.textColor, var10.field2218?0:-1);
                                             }
                                          }

                                          ++var20;
                                       }
                                    }
                                 }

                                 int var27;
                                 if(var10.type == 8 && Player.field241 == var10 && Client.field361 == Client.field431) {
                                    var36 = 0;
                                    var20 = 0;
                                    class208 var21 = class22.field235;
                                    String var40 = var10.text;

                                    String var48;
                                    for(var40 = class175.method3241(var40, var10); var40.length() > 0; var20 += var21.field3087 + 1) {
                                       var24 = var40.indexOf("<br>");
                                       if(var24 != -1) {
                                          var48 = var40.substring(0, var24);
                                          var40 = var40.substring(4 + var24);
                                       } else {
                                          var48 = var40;
                                          var40 = "";
                                       }

                                       var25 = var21.method3874(var48);
                                       if(var25 > var36) {
                                          var36 = var25;
                                       }
                                    }

                                    var36 += 6;
                                    var20 += 7;
                                    var24 = var12 + var10.width - 5 - var36;
                                    var25 = var10.height + var13 + 5;
                                    if(var24 < var12 + 5) {
                                       var24 = var12 + 5;
                                    }

                                    if(var36 + var24 > var4) {
                                       var24 = var4 - var36;
                                    }

                                    if(var25 + var20 > var5) {
                                       var25 = var5 - var20;
                                    }

                                    class219.method3993(var24, var25, var36, var20, 16777120);
                                    class219.method3977(var24, var25, var36, var20, 0);
                                    var40 = var10.text;
                                    var26 = var21.field3087 + var25 + 2;

                                    for(var40 = class175.method3241(var40, var10); var40.length() > 0; var26 += 1 + var21.field3087) {
                                       var27 = var40.indexOf("<br>");
                                       if(var27 != -1) {
                                          var48 = var40.substring(0, var27);
                                          var40 = var40.substring(4 + var27);
                                       } else {
                                          var48 = var40;
                                          var40 = "";
                                       }

                                       var21.method3867(var48, var24 + 3, var26, 0, -1);
                                    }
                                 }

                                 if(var10.type == 9) {
                                    if(var10.field2236 == 1) {
                                       if(var10.field2226) {
                                          var36 = var12;
                                          var20 = var10.height + var13;
                                          var39 = var10.width + var12;
                                          var22 = var13;
                                       } else {
                                          var36 = var12;
                                          var20 = var13;
                                          var39 = var12 + var10.width;
                                          var22 = var13 + var10.height;
                                       }

                                       class219.method3983(var36, var20, var39, var22, var10.textColor);
                                    } else {
                                       var36 = var10.width >= 0?var10.width:-var10.width;
                                       var20 = var10.height >= 0?var10.height:-var10.height;
                                       var39 = var36;
                                       if(var36 < var20) {
                                          var39 = var20;
                                       }

                                       if(var39 != 0) {
                                          var22 = (var10.width << 16) / var39;
                                          var37 = (var10.height << 16) / var39;
                                          if(var37 <= var22) {
                                             var22 = -var22;
                                          } else {
                                             var37 = -var37;
                                          }

                                          var24 = var10.field2236 * var37 >> 17;
                                          var25 = 1 + var10.field2236 * var37 >> 17;
                                          var26 = var10.field2236 * var22 >> 17;
                                          var27 = 1 + var10.field2236 * var22 >> 17;
                                          int var42 = var12 + var24;
                                          var29 = var12 - var25;
                                          int var30 = var12 + var10.width - var25;
                                          int var31 = var24 + var12 + var10.width;
                                          int var32 = var26 + var13;
                                          int var33 = var13 - var27;
                                          int var34 = var13 + var10.height - var27;
                                          int var35 = var26 + var13 + var10.height;
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

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(IIIIIILRegion;LCollisionData;B)V",
      garbageValue = "62"
   )
   static final void method172(int var0, int var1, int var2, int var3, int var4, int var5, Region var6, CollisionData var7) {
      if(!Client.field286 || (class10.tileSettings[0][var1][var2] & 2) != 0 || (class10.tileSettings[var0][var1][var2] & 16) == 0) {
         if(var0 < class10.field95) {
            class10.field95 = var0;
         }

         ObjectComposition var8 = Tile.getObjectDefinition(var3);
         int var9;
         int var10;
         if(var4 != 1 && var4 != 3) {
            var9 = var8.field2895;
            var10 = var8.field2931;
         } else {
            var9 = var8.field2931;
            var10 = var8.field2895;
         }

         int var11;
         int var12;
         if(var1 + var9 <= 104) {
            var11 = var1 + (var9 >> 1);
            var12 = (var9 + 1 >> 1) + var1;
         } else {
            var11 = var1;
            var12 = 1 + var1;
         }

         int var13;
         int var14;
         if(var10 + var2 <= 104) {
            var13 = var2 + (var10 >> 1);
            var14 = var2 + (1 + var10 >> 1);
         } else {
            var13 = var2;
            var14 = 1 + var2;
         }

         int[][] var15 = class10.tileHeights[var0];
         int var16 = var15[var11][var14] + var15[var12][var13] + var15[var11][var13] + var15[var12][var14] >> 2;
         int var17 = (var9 << 6) + (var1 << 7);
         int var18 = (var10 << 6) + (var2 << 7);
         int var19 = 1073741824 + var1 + (var2 << 7) + (var3 << 14);
         if(var8.field2899 == 0) {
            var19 -= Integer.MIN_VALUE;
         }

         int var20 = (var4 << 6) + var5;
         if(var8.field2920 == 1) {
            var20 += 256;
         }

         int var22;
         int var23;
         if(var8.method3605()) {
            class31 var21 = new class31();
            var21.field699 = var0;
            var21.field700 = var1 * 128;
            var21.field701 = var2 * 128;
            var22 = var8.field2895;
            var23 = var8.field2931;
            if(var4 == 1 || var4 == 3) {
               var22 = var8.field2931;
               var23 = var8.field2895;
            }

            var21.field702 = (var1 + var22) * 128;
            var21.field716 = (var2 + var23) * 128;
            var21.field705 = var8.field2924;
            var21.field704 = var8.field2925 * 128;
            var21.field707 = var8.field2926;
            var21.field708 = var8.field2900;
            var21.field709 = var8.field2928;
            if(var8.impostorIds != null) {
               var21.field712 = var8;
               var21.method677();
            }

            class31.field703.method2394(var21);
            if(null != var21.field709) {
               var21.field710 = var21.field707 + (int)(Math.random() * (double)(var21.field708 - var21.field707));
            }
         }

         Object var30;
         if(var5 == 22) {
            if(!Client.field286 || var8.field2899 != 0 || var8.field2923 == 1 || var8.field2918) {
               if(var8.field2903 == -1 && var8.impostorIds == null) {
                  var30 = var8.method3598(22, var4, var15, var17, var16, var18);
               } else {
                  var30 = new class49(var3, 22, var4, var0, var1, var2, var8.field2903, true, (Renderable)null);
               }

               var6.groundObjectSpawned(var0, var1, var2, var16, (Renderable)var30, var19, var20);
               if(var8.field2923 == 1 && var7 != null) {
                  var7.method2233(var1, var2);
               }

            }
         } else if(var5 != 10 && var5 != 11) {
            if(var5 >= 12) {
               if(var8.field2903 == -1 && var8.impostorIds == null) {
                  var30 = var8.method3598(var5, var4, var15, var17, var16, var18);
               } else {
                  var30 = new class49(var3, var5, var4, var0, var1, var2, var8.field2903, true, (Renderable)null);
               }

               var6.method1680(var0, var1, var2, var16, 1, 1, (Renderable)var30, 0, var19, var20);
               if(var5 >= 12 && var5 <= 17 && var5 != 13 && var0 > 0) {
                  class221.field3189[var0][var1][var2] |= 2340;
               }

               if(var8.field2923 != 0 && null != var7) {
                  var7.method2231(var1, var2, var9, var10, var8.field2898);
               }

            } else if(var5 == 0) {
               if(var8.field2903 == -1 && var8.impostorIds == null) {
                  var30 = var8.method3598(0, var4, var15, var17, var16, var18);
               } else {
                  var30 = new class49(var3, 0, var4, var0, var1, var2, var8.field2903, true, (Renderable)null);
               }

               var6.method1678(var0, var1, var2, var16, (Renderable)var30, (Renderable)null, class10.field96[var4], 0, var19, var20);
               if(var4 == 0) {
                  if(var8.field2927) {
                     class174.field2619[var0][var1][var2] = 50;
                     class174.field2619[var0][var1][1 + var2] = 50;
                  }

                  if(var8.field2902) {
                     class221.field3189[var0][var1][var2] |= 585;
                  }
               } else if(var4 == 1) {
                  if(var8.field2927) {
                     class174.field2619[var0][var1][var2 + 1] = 50;
                     class174.field2619[var0][1 + var1][1 + var2] = 50;
                  }

                  if(var8.field2902) {
                     class221.field3189[var0][var1][1 + var2] |= 1170;
                  }
               } else if(var4 == 2) {
                  if(var8.field2927) {
                     class174.field2619[var0][1 + var1][var2] = 50;
                     class174.field2619[var0][var1 + 1][1 + var2] = 50;
                  }

                  if(var8.field2902) {
                     class221.field3189[var0][1 + var1][var2] |= 585;
                  }
               } else if(var4 == 3) {
                  if(var8.field2927) {
                     class174.field2619[var0][var1][var2] = 50;
                     class174.field2619[var0][var1 + 1][var2] = 50;
                  }

                  if(var8.field2902) {
                     class221.field3189[var0][var1][var2] |= 1170;
                  }
               }

               if(var8.field2923 != 0 && var7 != null) {
                  var7.method2252(var1, var2, var5, var4, var8.field2898);
               }

               if(var8.field2905 != 16) {
                  var6.method1731(var0, var1, var2, var8.field2905);
               }

            } else if(var5 == 1) {
               if(var8.field2903 == -1 && null == var8.impostorIds) {
                  var30 = var8.method3598(1, var4, var15, var17, var16, var18);
               } else {
                  var30 = new class49(var3, 1, var4, var0, var1, var2, var8.field2903, true, (Renderable)null);
               }

               var6.method1678(var0, var1, var2, var16, (Renderable)var30, (Renderable)null, class10.field101[var4], 0, var19, var20);
               if(var8.field2927) {
                  if(var4 == 0) {
                     class174.field2619[var0][var1][1 + var2] = 50;
                  } else if(var4 == 1) {
                     class174.field2619[var0][1 + var1][var2 + 1] = 50;
                  } else if(var4 == 2) {
                     class174.field2619[var0][var1 + 1][var2] = 50;
                  } else if(var4 == 3) {
                     class174.field2619[var0][var1][var2] = 50;
                  }
               }

               if(var8.field2923 != 0 && var7 != null) {
                  var7.method2252(var1, var2, var5, var4, var8.field2898);
               }

            } else {
               int var26;
               Object var27;
               if(var5 == 2) {
                  var26 = 1 + var4 & 3;
                  Object var29;
                  if(var8.field2903 == -1 && var8.impostorIds == null) {
                     var29 = var8.method3598(2, 4 + var4, var15, var17, var16, var18);
                     var27 = var8.method3598(2, var26, var15, var17, var16, var18);
                  } else {
                     var29 = new class49(var3, 2, var4 + 4, var0, var1, var2, var8.field2903, true, (Renderable)null);
                     var27 = new class49(var3, 2, var26, var0, var1, var2, var8.field2903, true, (Renderable)null);
                  }

                  var6.method1678(var0, var1, var2, var16, (Renderable)var29, (Renderable)var27, class10.field96[var4], class10.field96[var26], var19, var20);
                  if(var8.field2902) {
                     if(var4 == 0) {
                        class221.field3189[var0][var1][var2] |= 585;
                        class221.field3189[var0][var1][1 + var2] |= 1170;
                     } else if(var4 == 1) {
                        class221.field3189[var0][var1][var2 + 1] |= 1170;
                        class221.field3189[var0][1 + var1][var2] |= 585;
                     } else if(var4 == 2) {
                        class221.field3189[var0][var1 + 1][var2] |= 585;
                        class221.field3189[var0][var1][var2] |= 1170;
                     } else if(var4 == 3) {
                        class221.field3189[var0][var1][var2] |= 1170;
                        class221.field3189[var0][var1][var2] |= 585;
                     }
                  }

                  if(var8.field2923 != 0 && var7 != null) {
                     var7.method2252(var1, var2, var5, var4, var8.field2898);
                  }

                  if(var8.field2905 != 16) {
                     var6.method1731(var0, var1, var2, var8.field2905);
                  }

               } else if(var5 == 3) {
                  if(var8.field2903 == -1 && var8.impostorIds == null) {
                     var30 = var8.method3598(3, var4, var15, var17, var16, var18);
                  } else {
                     var30 = new class49(var3, 3, var4, var0, var1, var2, var8.field2903, true, (Renderable)null);
                  }

                  var6.method1678(var0, var1, var2, var16, (Renderable)var30, (Renderable)null, class10.field101[var4], 0, var19, var20);
                  if(var8.field2927) {
                     if(var4 == 0) {
                        class174.field2619[var0][var1][1 + var2] = 50;
                     } else if(var4 == 1) {
                        class174.field2619[var0][1 + var1][var2 + 1] = 50;
                     } else if(var4 == 2) {
                        class174.field2619[var0][1 + var1][var2] = 50;
                     } else if(var4 == 3) {
                        class174.field2619[var0][var1][var2] = 50;
                     }
                  }

                  if(var8.field2923 != 0 && var7 != null) {
                     var7.method2252(var1, var2, var5, var4, var8.field2898);
                  }

               } else if(var5 == 9) {
                  if(var8.field2903 == -1 && var8.impostorIds == null) {
                     var30 = var8.method3598(var5, var4, var15, var17, var16, var18);
                  } else {
                     var30 = new class49(var3, var5, var4, var0, var1, var2, var8.field2903, true, (Renderable)null);
                  }

                  var6.method1680(var0, var1, var2, var16, 1, 1, (Renderable)var30, 0, var19, var20);
                  if(var8.field2923 != 0 && null != var7) {
                     var7.method2231(var1, var2, var9, var10, var8.field2898);
                  }

                  if(var8.field2905 != 16) {
                     var6.method1731(var0, var1, var2, var8.field2905);
                  }

               } else if(var5 == 4) {
                  if(var8.field2903 == -1 && var8.impostorIds == null) {
                     var30 = var8.method3598(4, var4, var15, var17, var16, var18);
                  } else {
                     var30 = new class49(var3, 4, var4, var0, var1, var2, var8.field2903, true, (Renderable)null);
                  }

                  var6.method1807(var0, var1, var2, var16, (Renderable)var30, (Renderable)null, class10.field96[var4], 0, 0, 0, var19, var20);
               } else if(var5 == 5) {
                  var26 = 16;
                  var22 = var6.method1696(var0, var1, var2);
                  if(var22 != 0) {
                     var26 = Tile.getObjectDefinition(var22 >> 14 & 32767).field2905;
                  }

                  if(var8.field2903 == -1 && var8.impostorIds == null) {
                     var27 = var8.method3598(4, var4, var15, var17, var16, var18);
                  } else {
                     var27 = new class49(var3, 4, var4, var0, var1, var2, var8.field2903, true, (Renderable)null);
                  }

                  var6.method1807(var0, var1, var2, var16, (Renderable)var27, (Renderable)null, class10.field96[var4], 0, class10.field102[var4] * var26, class10.field106[var4] * var26, var19, var20);
               } else if(var5 == 6) {
                  var26 = 8;
                  var22 = var6.method1696(var0, var1, var2);
                  if(var22 != 0) {
                     var26 = Tile.getObjectDefinition(var22 >> 14 & 32767).field2905 / 2;
                  }

                  if(var8.field2903 == -1 && null == var8.impostorIds) {
                     var27 = var8.method3598(4, 4 + var4, var15, var17, var16, var18);
                  } else {
                     var27 = new class49(var3, 4, var4 + 4, var0, var1, var2, var8.field2903, true, (Renderable)null);
                  }

                  var6.method1807(var0, var1, var2, var16, (Renderable)var27, (Renderable)null, 256, var4, class10.field104[var4] * var26, class10.field105[var4] * var26, var19, var20);
               } else if(var5 == 7) {
                  var22 = 2 + var4 & 3;
                  if(var8.field2903 == -1 && var8.impostorIds == null) {
                     var30 = var8.method3598(4, var22 + 4, var15, var17, var16, var18);
                  } else {
                     var30 = new class49(var3, 4, var22 + 4, var0, var1, var2, var8.field2903, true, (Renderable)null);
                  }

                  var6.method1807(var0, var1, var2, var16, (Renderable)var30, (Renderable)null, 256, var22, 0, 0, var19, var20);
               } else if(var5 == 8) {
                  var26 = 8;
                  var22 = var6.method1696(var0, var1, var2);
                  if(var22 != 0) {
                     var26 = Tile.getObjectDefinition(var22 >> 14 & 32767).field2905 / 2;
                  }

                  int var25 = 2 + var4 & 3;
                  Object var28;
                  if(var8.field2903 == -1 && var8.impostorIds == null) {
                     var27 = var8.method3598(4, 4 + var4, var15, var17, var16, var18);
                     var28 = var8.method3598(4, var25 + 4, var15, var17, var16, var18);
                  } else {
                     var27 = new class49(var3, 4, 4 + var4, var0, var1, var2, var8.field2903, true, (Renderable)null);
                     var28 = new class49(var3, 4, var25 + 4, var0, var1, var2, var8.field2903, true, (Renderable)null);
                  }

                  var6.method1807(var0, var1, var2, var16, (Renderable)var27, (Renderable)var28, 256, var4, var26 * class10.field104[var4], var26 * class10.field105[var4], var19, var20);
               }
            }
         } else {
            if(var8.field2903 == -1 && null == var8.impostorIds) {
               var30 = var8.method3598(10, var4, var15, var17, var16, var18);
            } else {
               var30 = new class49(var3, 10, var4, var0, var1, var2, var8.field2903, true, (Renderable)null);
            }

            if(var30 != null && var6.method1680(var0, var1, var2, var16, var9, var10, (Renderable)var30, var5 == 11?256:0, var19, var20) && var8.field2927) {
               var22 = 15;
               if(var30 instanceof Model) {
                  var22 = ((Model)var30).method1521() / 4;
                  if(var22 > 30) {
                     var22 = 30;
                  }
               }

               for(var23 = 0; var23 <= var9; ++var23) {
                  for(int var24 = 0; var24 <= var10; ++var24) {
                     if(var22 > class174.field2619[var0][var1 + var23][var24 + var2]) {
                        class174.field2619[var0][var1 + var23][var2 + var24] = (byte)var22;
                     }
                  }
               }
            }

            if(var8.field2923 != 0 && var7 != null) {
               var7.method2231(var1, var2, var9, var10, var8.field2898);
            }

         }
      }
   }

   @ObfuscatedName("bc")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "489165434"
   )
   static final void method173(int var0, int var1) {
      if(Client.menuOptionCount >= 2 || Client.field447 != 0 || Client.field435) {
         String var2;
         if(Client.field447 == 1 && Client.menuOptionCount < 2) {
            var2 = "Use" + " " + Client.field468 + " " + "->";
         } else if(Client.field435 && Client.menuOptionCount < 2) {
            var2 = Client.field438 + " " + Client.field282 + " " + "->";
         } else {
            int var4 = Client.menuOptionCount - 1;
            String var3;
            if(Client.menuTargets[var4].length() > 0) {
               var3 = Client.menuOptions[var4] + " " + Client.menuTargets[var4];
            } else {
               var3 = Client.menuOptions[var4];
            }

            var2 = var3;
         }

         if(Client.menuOptionCount > 2) {
            var2 = var2 + class32.method691(16777215) + " " + '/' + " " + (Client.menuOptionCount - 2) + " more options";
         }

         class97.field1621.method3875(var2, 4 + var0, var1 + 15, 16777215, 0, Client.gameCycle / 1000);
      }
   }
}
