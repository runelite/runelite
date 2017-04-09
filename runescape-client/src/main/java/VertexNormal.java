import java.awt.Component;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cg")
@Implements("VertexNormal")
public class VertexNormal {
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -1908689669
   )
   @Export("y")
   int y;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 1431665553
   )
   @Export("z")
   int z;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -24943487
   )
   @Export("magnitude")
   int magnitude;
   @ObfuscatedName("m")
   public static short[] field1446;
   @ObfuscatedName("mt")
   @ObfuscatedGetter(
      intValue = -1950568043
   )
   @Export("clanChatCount")
   static int clanChatCount;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -277889691
   )
   @Export("x")
   int x;

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(IIIB)I",
      garbageValue = "20"
   )
   static final int method1666(int var0, int var1, int var2) {
      int var3 = 256 - var2;
      return (var3 * (var0 & 16711935) + var2 * (var1 & 16711935) & -16711936) + ((var0 & '\uff00') * var3 + (var1 & '\uff00') * var2 & 16711680) >> 8;
   }

   VertexNormal(VertexNormal var1) {
      this.x = var1.x;
      this.y = var1.y;
      this.z = var1.z;
      this.magnitude = var1.magnitude;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Lclass182;III)Z",
      garbageValue = "1197921335"
   )
   static boolean method1667(IndexDataBase var0, int var1, int var2) {
      byte[] var3 = var0.getConfigData(var1, var2);
      if(var3 == null) {
         return false;
      } else {
         IndexData.method3451(var3);
         return true;
      }
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Component;I)V",
      garbageValue = "-158404877"
   )
   public static void method1668(Component var0) {
      var0.addMouseListener(class115.mouse);
      var0.addMouseMotionListener(class115.mouse);
      var0.addFocusListener(class115.mouse);
   }

   @ObfuscatedName("cf")
   @ObfuscatedSignature(
      signature = "([LWidget;IIIIIIIII)V",
      garbageValue = "-1703641502"
   )
   @Export("gameDraw")
   static final void gameDraw(Widget[] var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
      Rasterizer2D.method4001(var2, var3, var4, var5);
      class84.method1671();

      for(int var9 = 0; var9 < var0.length; ++var9) {
         Widget var10 = var0[var9];
         if(var10 != null && (var1 == var10.parentId || var1 == -1412584499 && Client.field476 == var10)) {
            int var11;
            if(var8 == -1) {
               Client.widgetPositionX[Client.field506] = var10.relativeX + var6;
               Client.widgetPositionY[Client.field506] = var7 + var10.relativeY;
               Client.widgetBoundsWidth[Client.field506] = var10.width;
               Client.widgetBoundsHeight[Client.field506] = var10.height;
               var11 = ++Client.field506 - 1;
            } else {
               var11 = var8;
            }

            var10.boundsIndex = var11;
            var10.field2254 = Client.gameCycle;
            if(!var10.hasScript || !ISAACCipher.method3124(var10)) {
               int var12;
               if(var10.contentType > 0) {
                  var12 = var10.contentType;
                  if(var12 == 324) {
                     if(Client.field577 == -1) {
                        Client.field577 = var10.textureId;
                        Client.field298 = var10.field2332;
                     }

                     if(Client.field509.isFemale) {
                        var10.textureId = Client.field577;
                     } else {
                        var10.textureId = Client.field298;
                     }
                  } else if(var12 == 325) {
                     if(Client.field577 == -1) {
                        Client.field577 = var10.textureId;
                        Client.field298 = var10.field2332;
                     }

                     if(Client.field509.isFemale) {
                        var10.textureId = Client.field298;
                     } else {
                        var10.textureId = Client.field577;
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
               if(Client.field476 == var10) {
                  if(var1 != -1412584499 && !var10.field2297) {
                     class162.field2170 = var0;
                     class149.field2062 = var6;
                     MessageNode.field245 = var7;
                     continue;
                  }

                  if(Client.field487 && Client.field481) {
                     var15 = class115.field1817;
                     var16 = class115.field1818;
                     var15 -= Client.field478;
                     var16 -= Client.field479;
                     if(var15 < Client.field324) {
                        var15 = Client.field324;
                     }

                     if(var15 + var10.width > Client.field324 + Client.field477.width) {
                        var15 = Client.field477.width + Client.field324 - var10.width;
                     }

                     if(var16 < Client.field483) {
                        var16 = Client.field483;
                     }

                     if(var10.height + var16 > Client.field477.height + Client.field483) {
                        var16 = Client.field483 + Client.field477.height - var10.height;
                     }

                     var12 = var15;
                     var13 = var16;
                  }

                  if(!var10.field2297) {
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
                  var22 = var12;
                  var19 = var13;
                  var20 = var10.width + var12;
                  var21 = var13 + var10.height;
                  if(var20 < var12) {
                     var22 = var20;
                     var20 = var12;
                  }

                  if(var21 < var13) {
                     var19 = var21;
                     var21 = var13;
                  }

                  ++var20;
                  ++var21;
                  var15 = var22 > var2?var22:var2;
                  var16 = var19 > var3?var19:var3;
                  var17 = var20 < var4?var20:var4;
                  var18 = var21 < var5?var21:var5;
               } else {
                  var22 = var12 + var10.width;
                  var19 = var13 + var10.height;
                  var15 = var12 > var2?var12:var2;
                  var16 = var13 > var3?var13:var3;
                  var17 = var22 < var4?var22:var4;
                  var18 = var19 < var5?var19:var5;
               }

               if(!var10.hasScript || var15 < var17 && var16 < var18) {
                  if(var10.contentType != 0) {
                     if(var10.contentType == 1336) {
                        if(Client.field318) {
                           var13 += 15;
                           Player.field282.method3941("Fps:" + GameEngine.FPS, var12 + var10.width, var13, 16776960, -1);
                           var13 += 15;
                           Runtime var41 = Runtime.getRuntime();
                           var19 = (int)((var41.totalMemory() - var41.freeMemory()) / 1024L);
                           var20 = 16776960;
                           if(var19 > '耀' && Client.field306) {
                              var20 = 16711680;
                           }

                           if(var19 > 65536 && !Client.field306) {
                              var20 = 16711680;
                           }

                           Player.field282.method3941("Mem:" + var19 + "k", var10.width + var12, var13, var20, -1);
                           var13 += 15;
                        }
                        continue;
                     }

                     if(var10.contentType == 1337) {
                        Client.field451 = var12;
                        Client.field331 = var13;
                        Buffer.method3065(var12, var13, var10.width, var10.height);
                        Client.field508[var10.boundsIndex] = true;
                        Rasterizer2D.method4001(var2, var3, var4, var5);
                        continue;
                     }

                     if(var10.contentType == 1338) {
                        class108.method2086(var10, var12, var13, var11);
                        Rasterizer2D.method4001(var2, var3, var4, var5);
                        continue;
                     }

                     if(var10.contentType == 1339) {
                        class164 var40 = var10.method3288(false);
                        if(var40 != null) {
                           if(Client.field539 < 3) {
                              XGrandExchangeOffer.field39.method4154(var12, var13, var40.field2174, var40.field2172, 25, 25, Client.mapAngle, 256, var40.field2173, var40.field2171);
                           } else {
                              Rasterizer2D.method4030(var12, var13, 0, var40.field2173, var40.field2171);
                           }
                        }

                        Rasterizer2D.method4001(var2, var3, var4, var5);
                        continue;
                     }
                  }

                  if(var10.type == 0) {
                     if(!var10.hasScript && ISAACCipher.method3124(var10) && var10 != class152.field2085) {
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

                     WidgetNode var23 = (WidgetNode)Client.componentTable.method2417((long)var10.id);
                     if(var23 != null) {
                        ChatMessages.method905(var23.id, var15, var16, var17, var18, var12, var13, var11);
                     }

                     Rasterizer2D.method4001(var2, var3, var4, var5);
                     class84.method1671();
                  }

                  if(Client.isResized || Client.field510[var11] || Client.field515 > 1) {
                     if(var10.type == 0 && !var10.hasScript && var10.scrollHeight > var10.height) {
                        class13.method159(var10.width + var12, var13, var10.scrollY, var10.height, var10.scrollHeight);
                     }

                     if(var10.type != 1) {
                        int var24;
                        int var25;
                        int var26;
                        int var27;
                        int var39;
                        SpritePixels var45;
                        if(var10.type == 2) {
                           var22 = 0;

                           for(var19 = 0; var19 < var10.field2231; ++var19) {
                              for(var20 = 0; var20 < var10.originalWidth; ++var20) {
                                 var21 = (var10.field2285 + 32) * var20 + var12;
                                 var27 = var19 * (var10.field2286 + 32) + var13;
                                 if(var22 < 20) {
                                    var21 += var10.field2340[var22];
                                    var27 += var10.field2288[var22];
                                 }

                                 if(var10.itemIds[var22] <= 0) {
                                    if(var10.field2289 != null && var22 < 20) {
                                       SpritePixels var43 = var10.method3253(var22);
                                       if(var43 != null) {
                                          var43.method4143(var21, var27);
                                       } else if(Widget.field2213) {
                                          class22.method197(var10);
                                       }
                                    }
                                 } else {
                                    boolean var42 = false;
                                    boolean var44 = false;
                                    var25 = var10.itemIds[var22] - 1;
                                    if(var21 + 32 > var2 && var21 < var4 && var27 + 32 > var3 && var27 < var5 || var10 == class164.field2177 && var22 == Client.field556) {
                                       if(Client.field455 == 1 && class47.field957 == var22 && var10.id == class177.field2689) {
                                          var45 = class5.createSprite(var25, var10.itemQuantities[var22], 2, 0, 2, false);
                                       } else {
                                          var45 = class5.createSprite(var25, var10.itemQuantities[var22], 1, 3153952, 2, false);
                                       }

                                       if(var45 != null) {
                                          if(var10 == class164.field2177 && Client.field556 == var22) {
                                             var39 = class115.field1817 - Client.field338;
                                             var24 = class115.field1818 - Client.field427;
                                             if(var39 < 5 && var39 > -5) {
                                                var39 = 0;
                                             }

                                             if(var24 < 5 && var24 > -5) {
                                                var24 = 0;
                                             }

                                             if(Client.field378 < 5) {
                                                var39 = 0;
                                                var24 = 0;
                                             }

                                             var45.method4149(var21 + var39, var27 + var24, 128);
                                             if(var1 != -1) {
                                                Widget var50 = var0[var1 & '\uffff'];
                                                if(var24 + var27 < Rasterizer2D.field3191 && var50.scrollY > 0) {
                                                   var26 = (Rasterizer2D.field3191 - var27 - var24) * Client.field511 / 3;
                                                   if(var26 > Client.field511 * 10) {
                                                      var26 = Client.field511 * 10;
                                                   }

                                                   if(var26 > var50.scrollY) {
                                                      var26 = var50.scrollY;
                                                   }

                                                   var50.scrollY -= var26;
                                                   Client.field427 += var26;
                                                   class22.method197(var50);
                                                }

                                                if(var27 + var24 + 32 > Rasterizer2D.field3189 && var50.scrollY < var50.scrollHeight - var50.height) {
                                                   var26 = (var24 + 32 + var27 - Rasterizer2D.field3189) * Client.field511 / 3;
                                                   if(var26 > Client.field511 * 10) {
                                                      var26 = Client.field511 * 10;
                                                   }

                                                   if(var26 > var50.scrollHeight - var50.height - var50.scrollY) {
                                                      var26 = var50.scrollHeight - var50.height - var50.scrollY;
                                                   }

                                                   var50.scrollY += var26;
                                                   Client.field427 -= var26;
                                                   class22.method197(var50);
                                                }
                                             }
                                          } else if(XGrandExchangeOffer.field42 == var10 && Client.field452 == var22) {
                                             var45.method4149(var21, var27, 128);
                                          } else {
                                             var45.method4143(var21, var27);
                                          }
                                       } else {
                                          class22.method197(var10);
                                       }
                                    }
                                 }

                                 ++var22;
                              }
                           }
                        } else if(var10.type == 3) {
                           if(class161.method3138(var10)) {
                              var22 = var10.field2245;
                              if(var10 == class152.field2085 && var10.field2247 != 0) {
                                 var22 = var10.field2247;
                              }
                           } else {
                              var22 = var10.textColor;
                              if(class152.field2085 == var10 && var10.field2280 != 0) {
                                 var22 = var10.field2280;
                              }
                           }

                           if(var10.field2267) {
                              switch(var10.field2249.field3205) {
                              case 1:
                                 Rasterizer2D.method4008(var12, var13, var10.width, var10.height, var10.textColor, var10.field2245, 256 - (var10.opacity & 255), 256 - (var10.field2251 & 255));
                                 break;
                              case 2:
                                 Rasterizer2D.method4009(var12, var13, var10.width, var10.height, var10.textColor, var10.field2245, 256 - (var10.opacity & 255), 256 - (var10.field2251 & 255));
                                 break;
                              case 3:
                                 Rasterizer2D.method4010(var12, var13, var10.width, var10.height, var10.textColor, var10.field2245, 256 - (var10.opacity & 255), 256 - (var10.field2251 & 255));
                                 break;
                              case 4:
                                 Rasterizer2D.method4015(var12, var13, var10.width, var10.height, var10.textColor, var10.field2245, 256 - (var10.opacity & 255), 256 - (var10.field2251 & 255));
                                 break;
                              default:
                                 if(var14 == 0) {
                                    Rasterizer2D.method4007(var12, var13, var10.width, var10.height, var22);
                                 } else {
                                    Rasterizer2D.method4006(var12, var13, var10.width, var10.height, var22, 256 - (var14 & 255));
                                 }
                              }
                           } else if(var14 == 0) {
                              Rasterizer2D.method4013(var12, var13, var10.width, var10.height, var22);
                           } else {
                              Rasterizer2D.method4014(var12, var13, var10.width, var10.height, var22, 256 - (var14 & 255));
                           }
                        } else {
                           Font var28;
                           String var29;
                           if(var10.type == 4) {
                              var28 = var10.method3257();
                              if(var28 == null) {
                                 if(Widget.field2213) {
                                    class22.method197(var10);
                                 }
                              } else {
                                 String var48 = var10.text;
                                 if(class161.method3138(var10)) {
                                    var19 = var10.field2245;
                                    if(var10 == class152.field2085 && var10.field2247 != 0) {
                                       var19 = var10.field2247;
                                    }

                                    if(var10.field2241.length() > 0) {
                                       var48 = var10.field2241;
                                    }
                                 } else {
                                    var19 = var10.textColor;
                                    if(class152.field2085 == var10 && var10.field2280 != 0) {
                                       var19 = var10.field2280;
                                    }
                                 }

                                 if(var10.hasScript && var10.item != -1) {
                                    ItemComposition var47 = class196.getItemDefinition(var10.item);
                                    var48 = var47.name;
                                    if(var48 == null) {
                                       var48 = "null";
                                    }

                                    if((var47.isStackable == 1 || var10.stackSize != 1) && var10.stackSize != -1) {
                                       var48 = XItemContainer.method153(16748608) + var48 + "</col> " + 'x' + FaceNormal.method1933(var10.stackSize);
                                    }
                                 }

                                 if(var10 == Client.field467) {
                                    var29 = null;
                                    var48 = "Please wait...";
                                    var19 = var10.textColor;
                                 }

                                 if(!var10.hasScript) {
                                    var48 = class1.method7(var48, var10);
                                 }

                                 var28.method3905(var48, var12, var13, var10.width, var10.height, var19, var10.field2298?0:-1, var10.field2219, var10.field2283, var10.field2212);
                              }
                           } else if(var10.type == 5) {
                              if(!var10.hasScript) {
                                 var45 = var10.method3256(class161.method3138(var10));
                                 if(var45 != null) {
                                    var45.method4143(var12, var13);
                                 } else if(Widget.field2213) {
                                    class22.method197(var10);
                                 }
                              } else {
                                 if(var10.item != -1) {
                                    var45 = class5.createSprite(var10.item, var10.stackSize, var10.borderThickness, var10.sprite2, var10.field2277, false);
                                 } else {
                                    var45 = var10.method3256(false);
                                 }

                                 if(var45 == null) {
                                    if(Widget.field2213) {
                                       class22.method197(var10);
                                    }
                                 } else {
                                    var19 = var45.maxWidth;
                                    var20 = var45.maxHeight;
                                    if(!var10.field2257) {
                                       var21 = var10.width * 4096 / var19;
                                       if(var10.field2294 != 0) {
                                          var45.method4156(var12 + var10.width / 2, var13 + var10.height / 2, var10.field2294, var21);
                                       } else if(var14 != 0) {
                                          var45.method4151(var12, var13, var10.width, var10.height, 256 - (var14 & 255));
                                       } else if(var10.width == var19 && var20 == var10.height) {
                                          var45.method4143(var12, var13);
                                       } else {
                                          var45.method4179(var12, var13, var10.width, var10.height);
                                       }
                                    } else {
                                       Rasterizer2D.method4002(var12, var13, var10.width + var12, var10.height + var13);
                                       var21 = (var19 - 1 + var10.width) / var19;
                                       var27 = (var10.height + (var20 - 1)) / var20;

                                       for(var39 = 0; var39 < var21; ++var39) {
                                          for(var24 = 0; var24 < var27; ++var24) {
                                             if(var10.field2294 != 0) {
                                                var45.method4156(var19 * var39 + var12 + var19 / 2, var13 + var24 * var20 + var20 / 2, var10.field2294, 4096);
                                             } else if(var14 != 0) {
                                                var45.method4149(var12 + var39 * var19, var13 + var20 * var24, 256 - (var14 & 255));
                                             } else {
                                                var45.method4143(var39 * var19 + var12, var24 * var20 + var13);
                                             }
                                          }
                                       }

                                       Rasterizer2D.method4001(var2, var3, var4, var5);
                                    }
                                 }
                              }
                           } else {
                              ItemComposition var30;
                              if(var10.type == 6) {
                                 boolean var46 = class161.method3138(var10);
                                 if(var46) {
                                    var19 = var10.field2276;
                                 } else {
                                    var19 = var10.field2266;
                                 }

                                 Model var51 = null;
                                 var21 = 0;
                                 if(var10.item != -1) {
                                    var30 = class196.getItemDefinition(var10.item);
                                    if(var30 != null) {
                                       var30 = var30.method3683(var10.stackSize);
                                       var51 = var30.getModel(1);
                                       if(var51 != null) {
                                          var51.method1643();
                                          var21 = var51.modelHeight / 2;
                                       } else {
                                          class22.method197(var10);
                                       }
                                    }
                                 } else if(var10.modelType == 5) {
                                    if(var10.modelId == 0) {
                                       var51 = Client.field509.method3206((Sequence)null, -1, (Sequence)null, -1);
                                    } else {
                                       var51 = Projectile.localPlayer.getModel();
                                    }
                                 } else if(var19 == -1) {
                                    var51 = var10.method3279((Sequence)null, -1, var46, Projectile.localPlayer.composition);
                                    if(var51 == null && Widget.field2213) {
                                       class22.method197(var10);
                                    }
                                 } else {
                                    Sequence var53 = Friend.getAnimation(var19);
                                    var51 = var10.method3279(var53, var10.field2344, var46, Projectile.localPlayer.composition);
                                    if(var51 == null && Widget.field2213) {
                                       class22.method197(var10);
                                    }
                                 }

                                 class84.method1674(var10.width / 2 + var12, var13 + var10.height / 2);
                                 var27 = var10.field2320 * class84.field1475[var10.rotationX] >> 16;
                                 var39 = var10.field2320 * class84.field1469[var10.rotationX] >> 16;
                                 if(var51 != null) {
                                    if(!var10.hasScript) {
                                       var51.method1599(0, var10.rotationZ, 0, var10.rotationX, 0, var27, var39);
                                    } else {
                                       var51.method1643();
                                       if(var10.field2296) {
                                          var51.method1600(0, var10.rotationZ, var10.rotationY, var10.rotationX, var10.field2268, var10.field2269 + var21 + var27, var39 + var10.field2269, var10.field2320);
                                       } else {
                                          var51.method1599(0, var10.rotationZ, var10.rotationY, var10.rotationX, var10.field2268, var27 + var21 + var10.field2269, var10.field2269 + var39);
                                       }
                                    }
                                 }

                                 class84.method1673();
                              } else {
                                 if(var10.type == 7) {
                                    var28 = var10.method3257();
                                    if(var28 == null) {
                                       if(Widget.field2213) {
                                          class22.method197(var10);
                                       }
                                       continue;
                                    }

                                    var19 = 0;

                                    for(var20 = 0; var20 < var10.field2231; ++var20) {
                                       for(var21 = 0; var21 < var10.originalWidth; ++var21) {
                                          if(var10.itemIds[var19] > 0) {
                                             var30 = class196.getItemDefinition(var10.itemIds[var19] - 1);
                                             if(var30.isStackable != 1 && var10.itemQuantities[var19] == 1) {
                                                var29 = XItemContainer.method153(16748608) + var30.name + "</col>";
                                             } else {
                                                var29 = XItemContainer.method153(16748608) + var30.name + "</col> " + 'x' + FaceNormal.method1933(var10.itemQuantities[var19]);
                                             }

                                             var24 = var12 + var21 * (var10.field2285 + 115);
                                             var25 = var13 + (var10.field2286 + 12) * var20;
                                             if(var10.field2219 == 0) {
                                                var28.method3930(var29, var24, var25, var10.textColor, var10.field2298?0:-1);
                                             } else if(var10.field2219 == 1) {
                                                var28.method3963(var29, var24 + var10.width / 2, var25, var10.textColor, var10.field2298?0:-1);
                                             } else {
                                                var28.method3941(var29, var10.width + var24 - 1, var25, var10.textColor, var10.field2298?0:-1);
                                             }
                                          }

                                          ++var19;
                                       }
                                    }
                                 }

                                 int var31;
                                 if(var10.type == 8 && WidgetNode.field190 == var10 && Client.field453 == Client.field369) {
                                    var22 = 0;
                                    var19 = 0;
                                    Font var32 = Player.field282;
                                    String var33 = var10.text;

                                    String var34;
                                    for(var33 = class1.method7(var33, var10); var33.length() > 0; var19 += var32.field3117 + 1) {
                                       var39 = var33.indexOf("<br>");
                                       if(var39 != -1) {
                                          var34 = var33.substring(0, var39);
                                          var33 = var33.substring(var39 + 4);
                                       } else {
                                          var34 = var33;
                                          var33 = "";
                                       }

                                       var24 = var32.method3897(var34);
                                       if(var24 > var22) {
                                          var22 = var24;
                                       }
                                    }

                                    var22 += 6;
                                    var19 += 7;
                                    var39 = var10.width + var12 - 5 - var22;
                                    var24 = var10.height + 5 + var13;
                                    if(var39 < var12 + 5) {
                                       var39 = var12 + 5;
                                    }

                                    if(var39 + var22 > var4) {
                                       var39 = var4 - var22;
                                    }

                                    if(var19 + var24 > var5) {
                                       var24 = var5 - var19;
                                    }

                                    Rasterizer2D.method4007(var39, var24, var22, var19, 16777120);
                                    Rasterizer2D.method4013(var39, var24, var22, var19, 0);
                                    var33 = var10.text;
                                    var25 = var24 + 2 + var32.field3117;

                                    for(var33 = class1.method7(var33, var10); var33.length() > 0; var25 += var32.field3117 + 1) {
                                       var31 = var33.indexOf("<br>");
                                       if(var31 != -1) {
                                          var34 = var33.substring(0, var31);
                                          var33 = var33.substring(var31 + 4);
                                       } else {
                                          var34 = var33;
                                          var33 = "";
                                       }

                                       var32.method3930(var34, var39 + 3, var25, 0, -1);
                                    }
                                 }

                                 if(var10.type == 9) {
                                    if(var10.field2218 == 1) {
                                       if(var10.field2253) {
                                          var22 = var12;
                                          var19 = var13 + var10.height;
                                          var20 = var12 + var10.width;
                                          var21 = var13;
                                       } else {
                                          var22 = var12;
                                          var19 = var13;
                                          var20 = var10.width + var12;
                                          var21 = var10.height + var13;
                                       }

                                       Rasterizer2D.method4019(var22, var19, var20, var21, var10.textColor);
                                    } else {
                                       var22 = var10.width >= 0?var10.width:-var10.width;
                                       var19 = var10.height >= 0?var10.height:-var10.height;
                                       var20 = var22;
                                       if(var22 < var19) {
                                          var20 = var19;
                                       }

                                       if(var20 != 0) {
                                          var21 = (var10.width << 16) / var20;
                                          var27 = (var10.height << 16) / var20;
                                          if(var27 <= var21) {
                                             var21 = -var21;
                                          } else {
                                             var27 = -var27;
                                          }

                                          var39 = var10.field2218 * var27 >> 17;
                                          var24 = var10.field2218 * var27 + 1 >> 17;
                                          var25 = var10.field2218 * var21 >> 17;
                                          var31 = var21 * var10.field2218 + 1 >> 17;
                                          int var49 = var12 + var39;
                                          var26 = var12 - var24;
                                          int var52 = var10.width + var12 - var24;
                                          int var54 = var12 + var10.width + var39;
                                          int var35 = var13 + var25;
                                          int var36 = var13 - var31;
                                          int var37 = var10.height + var13 - var31;
                                          int var38 = var13 + var10.height + var25;
                                          class84.setRasterClippingEnabled(var49, var26, var52);
                                          class84.rasterFlat(var35, var36, var37, var49, var26, var52, var10.textColor);
                                          class84.setRasterClippingEnabled(var49, var52, var54);
                                          class84.rasterFlat(var35, var37, var38, var49, var52, var54, var10.textColor);
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

   VertexNormal() {
   }
}
