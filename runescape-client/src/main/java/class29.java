import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ae")
public final class class29 {
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -1965379499
   )
   int field432;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -1247931113
   )
   int field433;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 767394683
   )
   int field434;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -1560509743
   )
   int field435;
   // $FF: synthetic field
   final class41 this$0;
   @ObfuscatedName("py")
   @ObfuscatedGetter(
      intValue = 1704259335
   )
   static int field436;
   @ObfuscatedName("fl")
   @ObfuscatedGetter(
      intValue = 1936797081
   )
   static int field437;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 1342223579
   )
   public static int field438;

   @ObfuscatedName("ha")
   @ObfuscatedSignature(
      signature = "([LWidget;IIIIIIIII)V",
      garbageValue = "-287014025"
   )
   @Export("gameDraw")
   static final void gameDraw(Widget[] var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
      Rasterizer2D.method4833(var2, var3, var4, var5);
      class136.method2493();

      for(int var9 = 0; var9 < var0.length; ++var9) {
         Widget var10 = var0[var9];
         if(var10 != null && (var10.parentId == var1 || var1 == -1412584499 && var10 == Client.field1079)) {
            int var11;
            if(var8 == -1) {
               Client.widgetPositionX[Client.field1109] = var10.relativeX + var6;
               Client.widgetPositionY[Client.field1109] = var10.relativeY + var7;
               Client.widgetBoundsWidth[Client.field1109] = var10.width;
               Client.widgetBoundsHeight[Client.field1109] = var10.height;
               var11 = ++Client.field1109 - 1;
            } else {
               var11 = var8;
            }

            var10.boundsIndex = var11;
            var10.field2786 = Client.gameCycle;
            if(!var10.hasScript || !WorldMapType2.method510(var10)) {
               int var12;
               if(var10.contentType > 0) {
                  var12 = var10.contentType;
                  if(var12 == 324) {
                     if(Client.field993 == -1) {
                        Client.field993 = var10.spriteId;
                        Client.field1179 = var10.field2690 * -1;
                     }

                     if(Client.field1177.isFemale) {
                        var10.spriteId = Client.field993;
                     } else {
                        var10.spriteId = Client.field1179 * -1;
                     }
                  } else if(var12 == 325) {
                     if(Client.field993 == -1) {
                        Client.field993 = var10.spriteId;
                        Client.field1179 = var10.field2690 * -1;
                     }

                     if(Client.field1177.isFemale) {
                        var10.spriteId = Client.field1179 * -1;
                     } else {
                        var10.spriteId = Client.field993;
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
               if(var10 == Client.field1079) {
                  if(var1 != -1412584499 && !var10.field2652) {
                     class64.field790 = var0;
                     class15.field303 = var6;
                     class71.field847 = var7;
                     continue;
                  }

                  if(Client.field1090 && Client.field1084) {
                     var15 = class59.field730;
                     var16 = class59.field731;
                     var15 -= Client.field1081;
                     var16 -= Client.field1082;
                     if(var15 < Client.field1093) {
                        var15 = Client.field1093;
                     }

                     if(var10.width + var15 > Client.field1080.width + Client.field1093) {
                        var15 = Client.field1080.width + Client.field1093 - var10.width;
                     }

                     if(var16 < Client.field1086) {
                        var16 = Client.field1086;
                     }

                     if(var16 + var10.height > Client.field1080.height + Client.field1086) {
                        var16 = Client.field1086 + Client.field1080.height - var10.height;
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
               int var30;
               if(var10.type == 2) {
                  var15 = var2;
                  var16 = var3;
                  var17 = var4;
                  var18 = var5;
               } else if(var10.type == 9) {
                  var30 = var12;
                  var20 = var13;
                  var21 = var12 + var10.width;
                  var22 = var13 + var10.height;
                  if(var21 < var12) {
                     var30 = var21;
                     var21 = var12;
                  }

                  if(var22 < var13) {
                     var20 = var22;
                     var22 = var13;
                  }

                  ++var21;
                  ++var22;
                  var15 = var30 > var2?var30:var2;
                  var16 = var20 > var3?var20:var3;
                  var17 = var21 < var4?var21:var4;
                  var18 = var22 < var5?var22:var5;
               } else {
                  var30 = var10.width + var12;
                  var20 = var13 + var10.height;
                  var15 = var12 > var2?var12:var2;
                  var16 = var13 > var3?var13:var3;
                  var17 = var30 < var4?var30:var4;
                  var18 = var20 < var5?var20:var5;
               }

               if(!var10.hasScript || var15 < var17 && var16 < var18) {
                  if(var10.contentType != 0) {
                     if(var10.contentType == 1336) {
                        if(Client.field918) {
                           var13 += 15;
                           WallObject.font_p12full.method4680("Fps:" + GameEngine.FPS, var10.width + var12, var13, 16776960, -1);
                           var13 += 15;
                           Runtime var38 = Runtime.getRuntime();
                           var20 = (int)((var38.totalMemory() - var38.freeMemory()) / 1024L);
                           var21 = 16776960;
                           if(var20 > '耀' && Client.field1055) {
                              var21 = 16711680;
                           }

                           if(var20 > 65536 && !Client.field1055) {
                              var21 = 16711680;
                           }

                           WallObject.font_p12full.method4680("Mem:" + var20 + "k", var10.width + var12, var13, var21, -1);
                           var13 += 15;
                        }
                        continue;
                     }

                     if(var10.contentType == 1337) {
                        Client.field941 = var12;
                        Client.field1056 = var13;
                        class21.method173(var12, var13, var10.width, var10.height);
                        Client.field1111[var10.boundsIndex] = true;
                        Rasterizer2D.method4833(var2, var3, var4, var5);
                        continue;
                     }

                     if(var10.contentType == 1338) {
                        class276.method4796(var10, var12, var13, var11);
                        Rasterizer2D.method4833(var2, var3, var4, var5);
                        continue;
                     }

                     if(var10.contentType == 1339) {
                        class11.method62(var10, var12, var13, var11);
                        Rasterizer2D.method4833(var2, var3, var4, var5);
                        continue;
                     }

                     if(var10.contentType == 1400) {
                        class46.field601.extractWorldmap(var12, var13, var10.width, var10.height, Client.gameCycle);
                     }

                     if(var10.contentType == 1401) {
                        class46.field601.extractData(var12, var13, var10.width, var10.height);
                     }
                  }

                  if(var10.type == 0) {
                     if(!var10.hasScript && WorldMapType2.method510(var10) && Item.field1476 != var10) {
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

                     WidgetNode var19 = (WidgetNode)Client.componentTable.method3425((long)var10.id);
                     if(var19 != null) {
                        class158.method2866(var19.id, var15, var16, var17, var18, var12, var13, var11);
                     }

                     Rasterizer2D.method4833(var2, var3, var4, var5);
                     class136.method2493();
                  }

                  if(Client.isResized || Client.field1128[var11] || Client.gameDrawingMode > 1) {
                     int var23;
                     int var24;
                     if(var10.type == 0 && !var10.hasScript && var10.scrollHeight > var10.height) {
                        var30 = var10.width + var12;
                        var20 = var10.scrollY;
                        var21 = var10.height;
                        var22 = var10.scrollHeight;
                        class1.field13[0].method4923(var30, var13);
                        class1.field13[1].method4923(var30, var13 + var21 - 16);
                        Rasterizer2D.method4826(var30, var13 + 16, 16, var21 - 32, Client.field983);
                        var23 = (var21 - 32) * var21 / var22;
                        if(var23 < 8) {
                           var23 = 8;
                        }

                        var24 = (var21 - 32 - var23) * var20 / (var22 - var21);
                        Rasterizer2D.method4826(var30, var13 + 16 + var24, 16, var23, Client.field984);
                        Rasterizer2D.method4836(var30, var24 + var13 + 16, var23, Client.field986);
                        Rasterizer2D.method4836(var30 + 1, var13 + 16 + var24, var23, Client.field986);
                        Rasterizer2D.method4834(var30, var13 + 16 + var24, 16, Client.field986);
                        Rasterizer2D.method4834(var30, var24 + var13 + 17, 16, Client.field986);
                        Rasterizer2D.method4836(var30 + 15, var24 + var13 + 16, var23, Client.field1184);
                        Rasterizer2D.method4836(var30 + 14, var24 + var13 + 17, var23 - 1, Client.field1184);
                        Rasterizer2D.method4834(var30, var23 + var13 + 15 + var24, 16, Client.field1184);
                        Rasterizer2D.method4834(var30 + 1, var23 + var13 + 14 + var24, 15, Client.field1184);
                     }

                     if(var10.type != 1) {
                        int var25;
                        int var26;
                        if(var10.type == 2) {
                           var30 = 0;

                           for(var20 = 0; var20 < var10.field2666; ++var20) {
                              for(var21 = 0; var21 < var10.originalWidth; ++var21) {
                                 var22 = var21 * (var10.paddingX + 32) + var12;
                                 var23 = (var10.paddingY + 32) * var20 + var13;
                                 if(var30 < 20) {
                                    var22 += var10.field2722[var30];
                                    var23 += var10.field2723[var30];
                                 }

                                 if(var10.itemIds[var30] <= 0) {
                                    if(var10.field2724 != null && var30 < 20) {
                                       SpritePixels var46 = var10.method3880(var30);
                                       if(var46 != null) {
                                          var46.method4950(var22, var23);
                                       } else if(Widget.field2651) {
                                          XItemContainer.method1020(var10);
                                       }
                                    }
                                 } else {
                                    boolean var39 = false;
                                    boolean var40 = false;
                                    var26 = var10.itemIds[var30] - 1;
                                    if(var22 + 32 > var2 && var22 < var4 && var23 + 32 > var3 && var23 < var5 || class165.field2335 == var10 && Client.field1019 == var30) {
                                       SpritePixels var27;
                                       if(Client.itemSelectionState == 1 && var30 == class91.selectedItemIndex && class33.field480 == var10.id) {
                                          var27 = class6.createSprite(var26, var10.itemQuantities[var30], 2, 0, 2, false);
                                       } else {
                                          var27 = class6.createSprite(var26, var10.itemQuantities[var30], 1, 3153952, 2, false);
                                       }

                                       if(var27 != null) {
                                          if(var10 == class165.field2335 && Client.field1019 == var30) {
                                             var24 = class59.field730 - Client.field911;
                                             var25 = class59.field731 - Client.field985;
                                             if(var24 < 5 && var24 > -5) {
                                                var24 = 0;
                                             }

                                             if(var25 < 5 && var25 > -5) {
                                                var25 = 0;
                                             }

                                             if(Client.field1024 < 5) {
                                                var24 = 0;
                                                var25 = 0;
                                             }

                                             var27.method4955(var22 + var24, var23 + var25, 128);
                                             if(var1 != -1) {
                                                Widget var28 = var0[var1 & '\uffff'];
                                                int var29;
                                                if(var25 + var23 < Rasterizer2D.drawingAreaTop && var28.scrollY > 0) {
                                                   var29 = Client.field1125 * (Rasterizer2D.drawingAreaTop - var23 - var25) / 3;
                                                   if(var29 > Client.field1125 * 10) {
                                                      var29 = Client.field1125 * 10;
                                                   }

                                                   if(var29 > var28.scrollY) {
                                                      var29 = var28.scrollY;
                                                   }

                                                   var28.scrollY -= var29;
                                                   Client.field985 += var29;
                                                   XItemContainer.method1020(var28);
                                                }

                                                if(var25 + var23 + 32 > Rasterizer2D.drawingAreaRight && var28.scrollY < var28.scrollHeight - var28.height) {
                                                   var29 = Client.field1125 * (var25 + var23 + 32 - Rasterizer2D.drawingAreaRight) / 3;
                                                   if(var29 > Client.field1125 * 10) {
                                                      var29 = Client.field1125 * 10;
                                                   }

                                                   if(var29 > var28.scrollHeight - var28.height - var28.scrollY) {
                                                      var29 = var28.scrollHeight - var28.height - var28.scrollY;
                                                   }

                                                   var28.scrollY += var29;
                                                   Client.field985 -= var29;
                                                   XItemContainer.method1020(var28);
                                                }
                                             }
                                          } else if(var10 == class59.field735 && Client.field1018 == var30) {
                                             var27.method4955(var22, var23, 128);
                                          } else {
                                             var27.method4950(var22, var23);
                                          }
                                       } else {
                                          XItemContainer.method1020(var10);
                                       }
                                    }
                                 }

                                 ++var30;
                              }
                           }
                        } else if(var10.type == 3) {
                           if(class54.method746(var10)) {
                              var30 = var10.field2728;
                              if(Item.field1476 == var10 && var10.field2682 != 0) {
                                 var30 = var10.field2682;
                              }
                           } else {
                              var30 = var10.textColor;
                              if(var10 == Item.field1476 && var10.field2681 != 0) {
                                 var30 = var10.field2681;
                              }
                           }

                           if(var10.field2683) {
                              switch(var10.field2684.field3768) {
                              case 1:
                                 Rasterizer2D.method4822(var12, var13, var10.width, var10.height, var10.textColor, var10.field2728, 256 - (var10.opacity & 255), 256 - (var10.field2686 & 255));
                                 break;
                              case 2:
                                 Rasterizer2D.method4874(var12, var13, var10.width, var10.height, var10.textColor, var10.field2728, 256 - (var10.opacity & 255), 256 - (var10.field2686 & 255));
                                 break;
                              case 3:
                                 Rasterizer2D.method4818(var12, var13, var10.width, var10.height, var10.textColor, var10.field2728, 256 - (var10.opacity & 255), 256 - (var10.field2686 & 255));
                                 break;
                              case 4:
                                 Rasterizer2D.method4819(var12, var13, var10.width, var10.height, var10.textColor, var10.field2728, 256 - (var10.opacity & 255), 256 - (var10.field2686 & 255));
                                 break;
                              default:
                                 if(var14 == 0) {
                                    Rasterizer2D.method4826(var12, var13, var10.width, var10.height, var30);
                                 } else {
                                    Rasterizer2D.method4825(var12, var13, var10.width, var10.height, var30, 256 - (var14 & 255));
                                 }
                              }
                           } else if(var14 == 0) {
                              Rasterizer2D.method4888(var12, var13, var10.width, var10.height, var30);
                           } else {
                              Rasterizer2D.method4841(var12, var13, var10.width, var10.height, var30, 256 - (var14 & 255));
                           }
                        } else {
                           Font var36;
                           if(var10.type == 4) {
                              var36 = var10.method3918();
                              if(var36 == null) {
                                 if(Widget.field2651) {
                                    XItemContainer.method1020(var10);
                                 }
                              } else {
                                 String var43 = var10.text;
                                 if(class54.method746(var10)) {
                                    var20 = var10.field2728;
                                    if(var10 == Item.field1476 && var10.field2682 != 0) {
                                       var20 = var10.field2682;
                                    }

                                    if(var10.field2715.length() > 0) {
                                       var43 = var10.field2715;
                                    }
                                 } else {
                                    var20 = var10.textColor;
                                    if(Item.field1476 == var10 && var10.field2681 != 0) {
                                       var20 = var10.field2681;
                                    }
                                 }

                                 if(var10.hasScript && var10.itemId != -1) {
                                    ItemComposition var47 = class224.getItemDefinition(var10.itemId);
                                    var43 = var47.name;
                                    if(var43 == null) {
                                       var43 = "null";
                                    }

                                    if((var47.isStackable == 1 || var10.itemQuantity != 1) && var10.itemQuantity != -1) {
                                       var43 = class15.method105(16748608) + var43 + "</col>" + " " + 'x' + class98.method1748(var10.itemQuantity);
                                    }
                                 }

                                 if(var10 == Client.field1070) {
                                    Object var10000 = null;
                                    var43 = "Please wait...";
                                    var20 = var10.textColor;
                                 }

                                 if(!var10.hasScript) {
                                    var43 = class59.method959(var43, var10);
                                 }

                                 var36.method4636(var43, var12, var13, var10.width, var10.height, var20, var10.field2736?0:-1, var10.field2696, var10.field2718, var10.field2680);
                              }
                           } else if(var10.type == 5) {
                              SpritePixels var37;
                              if(!var10.hasScript) {
                                 var37 = var10.method3885(class54.method746(var10));
                                 if(var37 != null) {
                                    var37.method4950(var12, var13);
                                 } else if(Widget.field2651) {
                                    XItemContainer.method1020(var10);
                                 }
                              } else {
                                 if(var10.itemId != -1) {
                                    var37 = class6.createSprite(var10.itemId, var10.itemQuantity, var10.borderThickness, var10.sprite2, var10.field2712, false);
                                 } else {
                                    var37 = var10.method3885(false);
                                 }

                                 if(var37 == null) {
                                    if(Widget.field2651) {
                                       XItemContainer.method1020(var10);
                                    }
                                 } else {
                                    var20 = var37.maxWidth;
                                    var21 = var37.maxHeight;
                                    if(!var10.field2692) {
                                       var22 = var10.width * 4096 / var20;
                                       if(var10.field2691 != 0) {
                                          var37.method4952(var12 + var10.width / 2, var13 + var10.height / 2, var10.field2691, var22);
                                       } else if(var14 != 0) {
                                          var37.method4999(var12, var13, var10.width, var10.height, 256 - (var14 & 255));
                                       } else if(var10.width == var20 && var10.height == var21) {
                                          var37.method4950(var12, var13);
                                       } else {
                                          var37.method4963(var12, var13, var10.width, var10.height);
                                       }
                                    } else {
                                       Rasterizer2D.method4862(var12, var13, var10.width + var12, var10.height + var13);
                                       var22 = (var10.width + (var20 - 1)) / var20;
                                       var23 = (var21 - 1 + var10.height) / var21;

                                       for(var24 = 0; var24 < var22; ++var24) {
                                          for(var25 = 0; var25 < var23; ++var25) {
                                             if(var10.field2691 != 0) {
                                                var37.method4952(var12 + var24 * var20 + var20 / 2, var21 * var25 + var13 + var21 / 2, var10.field2691, 4096);
                                             } else if(var14 != 0) {
                                                var37.method4955(var12 + var24 * var20, var21 * var25 + var13, 256 - (var14 & 255));
                                             } else {
                                                var37.method4950(var24 * var20 + var12, var25 * var21 + var13);
                                             }
                                          }
                                       }

                                       Rasterizer2D.method4833(var2, var3, var4, var5);
                                    }
                                 }
                              }
                           } else {
                              ItemComposition var32;
                              if(var10.type == 6) {
                                 boolean var44 = class54.method746(var10);
                                 if(var44) {
                                    var20 = var10.field2702;
                                 } else {
                                    var20 = var10.field2777;
                                 }

                                 Model var41 = null;
                                 var22 = 0;
                                 if(var10.itemId != -1) {
                                    var32 = class224.getItemDefinition(var10.itemId);
                                    if(var32 != null) {
                                       var32 = var32.method4458(var10.itemQuantity);
                                       var41 = var32.getModel(1);
                                       if(var41 != null) {
                                          var41.method2397();
                                          var22 = var41.modelHeight / 2;
                                       } else {
                                          XItemContainer.method1020(var10);
                                       }
                                    }
                                 } else if(var10.modelType == 5) {
                                    if(var10.modelId == 0) {
                                       var41 = Client.field1177.method3845((Sequence)null, -1, (Sequence)null, -1);
                                    } else {
                                       var41 = class20.localPlayer.getModel();
                                    }
                                 } else if(var20 == -1) {
                                    var41 = var10.method3914((Sequence)null, -1, var44, class20.localPlayer.composition);
                                    if(var41 == null && Widget.field2651) {
                                       XItemContainer.method1020(var10);
                                    }
                                 } else {
                                    Sequence var45 = GameEngine.getAnimation(var20);
                                    var41 = var10.method3914(var45, var10.field2776, var44, class20.localPlayer.composition);
                                    if(var41 == null && Widget.field2651) {
                                       XItemContainer.method1020(var10);
                                    }
                                 }

                                 class136.method2545(var12 + var10.width / 2, var13 + var10.height / 2);
                                 var23 = class136.SINE[var10.rotationX] * var10.field2737 >> 16;
                                 var24 = var10.field2737 * class136.COSINE[var10.rotationX] >> 16;
                                 if(var41 != null) {
                                    if(!var10.hasScript) {
                                       var41.method2440(0, var10.rotationZ, 0, var10.rotationX, 0, var23, var24);
                                    } else {
                                       var41.method2397();
                                       if(var10.field2711) {
                                          var41.method2411(0, var10.rotationZ, var10.rotationY, var10.rotationX, var10.field2750, var23 + var22 + var10.field2731, var10.field2731 + var24, var10.field2737);
                                       } else {
                                          var41.method2440(0, var10.rotationZ, var10.rotationY, var10.rotationX, var10.field2750, var22 + var23 + var10.field2731, var10.field2731 + var24);
                                       }
                                    }
                                 }

                                 class136.method2549();
                              } else {
                                 if(var10.type == 7) {
                                    var36 = var10.method3918();
                                    if(var36 == null) {
                                       if(Widget.field2651) {
                                          XItemContainer.method1020(var10);
                                       }
                                       continue;
                                    }

                                    var20 = 0;

                                    for(var21 = 0; var21 < var10.field2666; ++var21) {
                                       for(var22 = 0; var22 < var10.originalWidth; ++var22) {
                                          if(var10.itemIds[var20] > 0) {
                                             var32 = class224.getItemDefinition(var10.itemIds[var20] - 1);
                                             String var34;
                                             if(var32.isStackable != 1 && var10.itemQuantities[var20] == 1) {
                                                var34 = class15.method105(16748608) + var32.name + "</col>";
                                             } else {
                                                var34 = class15.method105(16748608) + var32.name + "</col>" + " " + 'x' + class98.method1748(var10.itemQuantities[var20]);
                                             }

                                             var25 = (var10.paddingX + 115) * var22 + var12;
                                             var26 = var13 + (var10.paddingY + 12) * var21;
                                             if(var10.field2696 == 0) {
                                                var36.method4647(var34, var25, var26, var10.textColor, var10.field2736?0:-1);
                                             } else if(var10.field2696 == 1) {
                                                var36.method4635(var34, var25 + var10.width / 2, var26, var10.textColor, var10.field2736?0:-1);
                                             } else {
                                                var36.method4680(var34, var10.width + var25 - 1, var26, var10.textColor, var10.field2736?0:-1);
                                             }
                                          }

                                          ++var20;
                                       }
                                    }
                                 }

                                 if(var10.type == 8 && var10 == class12.field280 && Client.field917 == Client.field1058) {
                                    var30 = 0;
                                    var20 = 0;
                                    Font var31 = WallObject.font_p12full;
                                    String var33 = var10.text;

                                    String var42;
                                    for(var33 = class59.method959(var33, var10); var33.length() > 0; var20 += var31.field3643 + 1) {
                                       var24 = var33.indexOf("<br>");
                                       if(var24 != -1) {
                                          var42 = var33.substring(0, var24);
                                          var33 = var33.substring(var24 + 4);
                                       } else {
                                          var42 = var33;
                                          var33 = "";
                                       }

                                       var25 = var31.method4696(var42);
                                       if(var25 > var30) {
                                          var30 = var25;
                                       }
                                    }

                                    var30 += 6;
                                    var20 += 7;
                                    var24 = var12 + var10.width - 5 - var30;
                                    var25 = var13 + var10.height + 5;
                                    if(var24 < var12 + 5) {
                                       var24 = var12 + 5;
                                    }

                                    if(var24 + var30 > var4) {
                                       var24 = var4 - var30;
                                    }

                                    if(var20 + var25 > var5) {
                                       var25 = var5 - var20;
                                    }

                                    Rasterizer2D.method4826(var24, var25, var30, var20, 16777120);
                                    Rasterizer2D.method4888(var24, var25, var30, var20, 0);
                                    var33 = var10.text;
                                    var26 = var25 + var31.field3643 + 2;

                                    for(var33 = class59.method959(var33, var10); var33.length() > 0; var26 += var31.field3643 + 1) {
                                       int var35 = var33.indexOf("<br>");
                                       if(var35 != -1) {
                                          var42 = var33.substring(0, var35);
                                          var33 = var33.substring(var35 + 4);
                                       } else {
                                          var42 = var33;
                                          var33 = "";
                                       }

                                       var31.method4647(var42, var24 + 3, var26, 0, -1);
                                    }
                                 }

                                 if(var10.type == 9) {
                                    if(var10.field2688) {
                                       var30 = var12;
                                       var20 = var10.height + var13;
                                       var21 = var12 + var10.width;
                                       var22 = var13;
                                    } else {
                                       var30 = var12;
                                       var20 = var13;
                                       var21 = var10.width + var12;
                                       var22 = var13 + var10.height;
                                    }

                                    if(var10.field2687 == 1) {
                                       Rasterizer2D.method4838(var30, var20, var21, var22, var10.textColor);
                                    } else {
                                       class22.method185(var30, var20, var21, var22, var10.textColor, var10.field2687);
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

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(II)LObjectComposition;",
      garbageValue = "69405308"
   )
   @Export("getObjectDefinition")
   public static ObjectComposition getObjectDefinition(int var0) {
      ObjectComposition var1 = (ObjectComposition)ObjectComposition.field3489.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = ObjectComposition.field3444.getConfigData(6, var0);
         var1 = new ObjectComposition();
         var1.field3461 = var0;
         if(var2 != null) {
            var1.method4389(new Buffer(var2));
         }

         var1.method4388();
         if(var1.isSolid) {
            var1.field3476 = 0;
            var1.field3468 = false;
         }

         ObjectComposition.field3489.put(var1, (long)var0);
         return var1;
      }
   }

   class29(class41 var1) {
      this.this$0 = var1;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(LPacketBuffer;IS)Z",
      garbageValue = "18229"
   )
   static boolean method253(PacketBuffer var0, int var1) {
      int var2 = var0.method3290(2);
      int var3;
      int var4;
      int var7;
      int var8;
      int var9;
      int var10;
      if(var2 == 0) {
         if(var0.method3290(1) != 0) {
            method253(var0, var1);
         }

         var3 = var0.method3290(13);
         var4 = var0.method3290(13);
         boolean var12 = var0.method3290(1) == 1;
         if(var12) {
            class96.field1500[++class96.field1493 - 1] = var1;
         }

         if(Client.cachedPlayers[var1] != null) {
            throw new RuntimeException();
         } else {
            Player var6 = Client.cachedPlayers[var1] = new Player();
            var6.field890 = var1;
            if(class96.field1498[var1] != null) {
               var6.method1091(class96.field1498[var1]);
            }

            var6.orientation = class96.field1497[var1];
            var6.interacting = class96.field1492[var1];
            var7 = class96.field1490[var1];
            var8 = var7 >> 28;
            var9 = var7 >> 14 & 255;
            var10 = var7 & 255;
            var6.field1265[0] = class96.field1494[var1];
            var6.field884 = (byte)var8;
            var6.method1083(var3 + (var9 << 13) - class19.baseX, var4 + (var10 << 13) - class21.baseY);
            var6.field877 = false;
            return true;
         }
      } else if(var2 == 1) {
         var3 = var0.method3290(2);
         var4 = class96.field1490[var1];
         class96.field1490[var1] = ((var3 + (var4 >> 28) & 3) << 28) + (var4 & 268435455);
         return false;
      } else {
         int var5;
         int var11;
         if(var2 == 2) {
            var3 = var0.method3290(5);
            var4 = var3 >> 3;
            var5 = var3 & 7;
            var11 = class96.field1490[var1];
            var7 = var4 + (var11 >> 28) & 3;
            var8 = var11 >> 14 & 255;
            var9 = var11 & 255;
            if(var5 == 0) {
               --var8;
               --var9;
            }

            if(var5 == 1) {
               --var9;
            }

            if(var5 == 2) {
               ++var8;
               --var9;
            }

            if(var5 == 3) {
               --var8;
            }

            if(var5 == 4) {
               ++var8;
            }

            if(var5 == 5) {
               --var8;
               ++var9;
            }

            if(var5 == 6) {
               ++var9;
            }

            if(var5 == 7) {
               ++var8;
               ++var9;
            }

            class96.field1490[var1] = var9 + (var8 << 14) + (var7 << 28);
            return false;
         } else {
            var3 = var0.method3290(18);
            var4 = var3 >> 16;
            var5 = var3 >> 8 & 255;
            var11 = var3 & 255;
            var7 = class96.field1490[var1];
            var8 = var4 + (var7 >> 28) & 3;
            var9 = var5 + (var7 >> 14) & 255;
            var10 = var7 + var11 & 255;
            class96.field1490[var1] = var10 + (var8 << 28) + (var9 << 14);
            return false;
         }
      }
   }
}
