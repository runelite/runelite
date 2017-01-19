import java.util.Comparator;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("s")
final class class0 implements Comparator {
   @ObfuscatedName("f")
   static int[] field1;
   @ObfuscatedName("no")
   @ObfuscatedGetter(
      intValue = -1011536743
   )
   static int field3;
   @ObfuscatedName("dv")
   @Export("region")
   static Region region;
   @ObfuscatedName("c")
   public static class182 field5;
   @ObfuscatedName("br")
   @ObfuscatedGetter(
      intValue = 953520331
   )
   static int field6;
   @ObfuscatedName("fq")
   @ObfuscatedGetter(
      intValue = -689754051
   )
   static int field7;
   @ObfuscatedName("jj")
   @ObfuscatedGetter(
      intValue = 1571176659
   )
   static int field8;

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Lclass2;Lclass2;I)I",
      garbageValue = "729758857"
   )
   int method1(class2 var1, class2 var2) {
      return var1.field32 < var2.field32?-1:(var1.field32 == var2.field32?0:1);
   }

   public int compare(Object var1, Object var2) {
      return this.method1((class2)var1, (class2)var2);
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   @ObfuscatedName("ci")
   @ObfuscatedSignature(
      signature = "(LWidget;IIIIIII)V",
      garbageValue = "1020354041"
   )
   static final void method5(Widget var0, int var1, int var2, int var3, int var4, int var5, int var6) {
      if(Client.field500) {
         Client.field501 = 32;
      } else {
         Client.field501 = 0;
      }

      Client.field500 = false;
      int var7;
      if(class115.field1801 == 1 || !class10.field110 && class115.field1801 == 4) {
         if(var5 >= var1 && var5 < 16 + var1 && var6 >= var2 && var6 < var2 + 16) {
            var0.scrollY -= 4;
            class204.method3671(var0);
         } else if(var5 >= var1 && var5 < 16 + var1 && var6 >= var3 + var2 - 16 && var6 < var2 + var3) {
            var0.scrollY += 4;
            class204.method3671(var0);
         } else if(var5 >= var1 - Client.field501 && var5 < 16 + var1 + Client.field501 && var6 >= 16 + var2 && var6 < var3 + var2 - 16) {
            var7 = (var3 - 32) * var3 / var4;
            if(var7 < 8) {
               var7 = 8;
            }

            int var8 = var6 - var2 - 16 - var7 / 2;
            int var9 = var3 - 32 - var7;
            var0.scrollY = (var4 - var3) * var8 / var9;
            class204.method3671(var0);
            Client.field500 = true;
         }
      }

      if(Client.field380 != 0) {
         var7 = var0.width;
         if(var5 >= var1 - var7 && var6 >= var2 && var5 < 16 + var1 && var6 <= var2 + var3) {
            var0.scrollY += Client.field380 * 45;
            class204.method3671(var0);
         }
      }

   }

   @ObfuscatedName("cj")
   @ObfuscatedSignature(
      signature = "([LWidget;IIIIIIIII)V",
      garbageValue = "-545599948"
   )
   @Export("gameDraw")
   static final void gameDraw(Widget[] var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
      Rasterizer2D.method3844(var2, var3, var4, var5);
      class84.method1633();

      for(int var9 = 0; var9 < var0.length; ++var9) {
         Widget var10 = var0[var9];
         if(var10 != null && (var1 == var10.parentId || var1 == -1412584499 && var10 == Client.field464)) {
            int var11;
            if(var8 == -1) {
               Client.widgetPositionX[Client.field404] = var10.relativeX + var6;
               Client.widgetPositionY[Client.field404] = var10.relativeY + var7;
               Client.widgetBoundsWidth[Client.field404] = var10.width;
               Client.widgetBoundsHeight[Client.field404] = var10.height;
               var11 = ++Client.field404 - 1;
            } else {
               var11 = var8;
            }

            var10.boundsIndex = var11;
            var10.field2287 = Client.gameCycle;
            if(!var10.hasScript || !class13.method149(var10)) {
               if(var10.contentType > 0) {
                  class7.method93(var10);
               }

               int var12 = var10.relativeX + var6;
               int var13 = var10.relativeY + var7;
               int var14 = var10.opacity;
               int var15;
               int var16;
               if(Client.field464 == var10) {
                  if(var1 != -1412584499 && !var10.field2266) {
                     class94.field1581 = var0;
                     FrameMap.field1473 = var6;
                     field8 = var7;
                     continue;
                  }

                  if(Client.field475 && Client.field429) {
                     var15 = class115.field1810;
                     var16 = class115.field1803;
                     var15 -= Client.field466;
                     var16 -= Client.field467;
                     if(var15 < Client.field408) {
                        var15 = Client.field408;
                     }

                     if(var10.width + var15 > Client.field408 + Client.field465.width) {
                        var15 = Client.field465.width + Client.field408 - var10.width;
                     }

                     if(var16 < Client.field310) {
                        var16 = Client.field310;
                     }

                     if(var10.height + var16 > Client.field465.height + Client.field310) {
                        var16 = Client.field310 + Client.field465.height - var10.height;
                     }

                     var12 = var15;
                     var13 = var16;
                  }

                  if(!var10.field2266) {
                     var14 = 128;
                  }
               }

               int var17;
               int var18;
               int var19;
               int var20;
               int var21;
               int var37;
               if(var10.type == 2) {
                  var15 = var2;
                  var16 = var3;
                  var17 = var4;
                  var18 = var5;
               } else if(var10.type == 9) {
                  var19 = var12;
                  var20 = var13;
                  var21 = var12 + var10.width;
                  var37 = var10.height + var13;
                  if(var21 < var12) {
                     var19 = var21;
                     var21 = var12;
                  }

                  if(var37 < var13) {
                     var20 = var37;
                     var37 = var13;
                  }

                  ++var21;
                  ++var37;
                  var15 = var19 > var2?var19:var2;
                  var16 = var20 > var3?var20:var3;
                  var17 = var21 < var4?var21:var4;
                  var18 = var37 < var5?var37:var5;
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
                        if(Client.field309) {
                           var13 += 15;
                           class20.field234.method3770("Fps:" + GameEngine.FPS, var12 + var10.width, var13, 16776960, -1);
                           var13 += 15;
                           Runtime var53 = Runtime.getRuntime();
                           var20 = (int)((var53.totalMemory() - var53.freeMemory()) / 1024L);
                           var21 = 16776960;
                           if(var20 > '耀' && Client.field299) {
                              var21 = 16711680;
                           }

                           if(var20 > 65536 && !Client.field299) {
                              var21 = 16711680;
                           }

                           class20.field234.method3770("Mem:" + var20 + "k", var10.width + var12, var13, var21, -1);
                           var13 += 15;
                        }
                        continue;
                     }

                     if(var10.contentType == 1337) {
                        Client.field440 = var12;
                        Client.field441 = var13;
                        class190.method3366(var12, var13, var10.width, var10.height);
                        Client.field497[var10.boundsIndex] = true;
                        Rasterizer2D.method3844(var2, var3, var4, var5);
                        continue;
                     }

                     if(var10.contentType == 1338) {
                        class20.method173(var10, var12, var13, var11);
                        Rasterizer2D.method3844(var2, var3, var4, var5);
                        continue;
                     }

                     if(var10.contentType == 1339) {
                        class159.method2961(var10, var12, var13, var11);
                        Rasterizer2D.method3844(var2, var3, var4, var5);
                        continue;
                     }
                  }

                  if(var10.type == 0) {
                     if(!var10.hasScript && class13.method149(var10) && class215.field3163 != var10) {
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
                     if(null != var10.children) {
                        gameDraw(var10.children, var10.id, var15, var16, var17, var18, var12 - var10.scrollX, var13 - var10.scrollY, var11);
                     }

                     WidgetNode var40 = (WidgetNode)Client.componentTable.method2274((long)var10.id);
                     if(var40 != null) {
                        var20 = var40.id;
                        if(!class109.method1999(var20)) {
                           if(var11 != -1) {
                              Client.field497[var11] = true;
                           } else {
                              for(var21 = 0; var21 < 100; ++var21) {
                                 Client.field497[var21] = true;
                              }
                           }
                        } else {
                           class94.field1581 = null;
                           gameDraw(Widget.widgets[var20], -1, var15, var16, var17, var18, var12, var13, var11);
                           if(class94.field1581 != null) {
                              gameDraw(class94.field1581, -1412584499, var15, var16, var17, var18, FrameMap.field1473, field8, var11);
                              class94.field1581 = null;
                           }
                        }
                     }

                     Rasterizer2D.method3844(var2, var3, var4, var5);
                     class84.method1633();
                  }

                  if(Client.isResized || Client.field561[var11] || Client.field504 > 1) {
                     if(var10.type == 0 && !var10.hasScript && var10.scrollHeight > var10.height) {
                        Item.method776(var10.width + var12, var13, var10.scrollY, var10.height, var10.scrollHeight);
                     }

                     if(var10.type != 1) {
                        int var25;
                        int var26;
                        int var29;
                        int var36;
                        int var41;
                        if(var10.type == 2) {
                           var19 = 0;

                           for(var20 = 0; var20 < var10.field2221; ++var20) {
                              for(var21 = 0; var21 < var10.originalWidth; ++var21) {
                                 var37 = var12 + var21 * (var10.field2275 + 32);
                                 var36 = var13 + var20 * (32 + var10.field2276);
                                 if(var19 < 20) {
                                    var37 += var10.field2277[var19];
                                    var36 += var10.field2278[var19];
                                 }

                                 if(var10.itemIds[var19] <= 0) {
                                    if(null != var10.field2279 && var19 < 20) {
                                       SpritePixels var46 = var10.method3123(var19);
                                       if(null != var46) {
                                          var46.method3971(var37, var36);
                                       } else if(Widget.field2207) {
                                          class204.method3671(var10);
                                       }
                                    }
                                 } else {
                                    boolean var54 = false;
                                    boolean var48 = false;
                                    var26 = var10.itemIds[var19] - 1;
                                    if(var37 + 32 > var2 && var37 < var4 && 32 + var36 > var3 && var36 < var5 || class38.field786 == var10 && Client.field406 == var19) {
                                       SpritePixels var39;
                                       if(Client.field412 == 1 && ItemLayer.field1216 == var19 && var10.id == class107.field1734) {
                                          var39 = TextureProvider.createSprite(var26, var10.itemQuantities[var19], 2, 0, 2, false);
                                       } else {
                                          var39 = TextureProvider.createSprite(var26, var10.itemQuantities[var19], 1, 3153952, 2, false);
                                       }

                                       if(var39 != null) {
                                          if(class38.field786 == var10 && Client.field406 == var19) {
                                             var41 = class115.field1810 - Client.field407;
                                             var25 = class115.field1803 - Client.field344;
                                             if(var41 < 5 && var41 > -5) {
                                                var41 = 0;
                                             }

                                             if(var25 < 5 && var25 > -5) {
                                                var25 = 0;
                                             }

                                             if(Client.field422 < 5) {
                                                var41 = 0;
                                                var25 = 0;
                                             }

                                             var39.method3977(var37 + var41, var25 + var36, 128);
                                             if(var1 != -1) {
                                                Widget var28 = var0[var1 & '\uffff'];
                                                if(var25 + var36 < Rasterizer2D.field3177 && var28.scrollY > 0) {
                                                   var29 = (Rasterizer2D.field3177 - var36 - var25) * Client.field533 / 3;
                                                   if(var29 > Client.field533 * 10) {
                                                      var29 = Client.field533 * 10;
                                                   }

                                                   if(var29 > var28.scrollY) {
                                                      var29 = var28.scrollY;
                                                   }

                                                   var28.scrollY -= var29;
                                                   Client.field344 += var29;
                                                   class204.method3671(var28);
                                                }

                                                if(var25 + var36 + 32 > Rasterizer2D.field3178 && var28.scrollY < var28.scrollHeight - var28.height) {
                                                   var29 = Client.field533 * (var36 + var25 + 32 - Rasterizer2D.field3178) / 3;
                                                   if(var29 > Client.field533 * 10) {
                                                      var29 = Client.field533 * 10;
                                                   }

                                                   if(var29 > var28.scrollHeight - var28.height - var28.scrollY) {
                                                      var29 = var28.scrollHeight - var28.height - var28.scrollY;
                                                   }

                                                   var28.scrollY += var29;
                                                   Client.field344 -= var29;
                                                   class204.method3671(var28);
                                                }
                                             }
                                          } else if(var10 == class170.field2345 && var19 == Client.field405) {
                                             var39.method3977(var37, var36, 128);
                                          } else {
                                             var39.method3971(var37, var36);
                                          }
                                       } else {
                                          class204.method3671(var10);
                                       }
                                    }
                                 }

                                 ++var19;
                              }
                           }
                        } else if(var10.type == 3) {
                           if(class6.method78(var10)) {
                              var19 = var10.field2235;
                              if(var10 == class215.field3163 && var10.field2237 != 0) {
                                 var19 = var10.field2237;
                              }
                           } else {
                              var19 = var10.textColor;
                              if(var10 == class215.field3163 && var10.field2341 != 0) {
                                 var19 = var10.field2341;
                              }
                           }

                           if(var10.field2238) {
                              switch(var10.field2288.field3191) {
                              case 1:
                                 Rasterizer2D.method3851(var12, var13, var10.width, var10.height, var10.textColor, var10.field2235, 256 - (var10.opacity & 255), 256 - (var10.field2241 & 255));
                                 break;
                              case 2:
                                 Rasterizer2D.method3852(var12, var13, var10.width, var10.height, var10.textColor, var10.field2235, 256 - (var10.opacity & 255), 256 - (var10.field2241 & 255));
                                 break;
                              case 3:
                                 Rasterizer2D.method3853(var12, var13, var10.width, var10.height, var10.textColor, var10.field2235, 256 - (var10.opacity & 255), 256 - (var10.field2241 & 255));
                                 break;
                              case 4:
                                 Rasterizer2D.method3854(var12, var13, var10.width, var10.height, var10.textColor, var10.field2235, 256 - (var10.opacity & 255), 256 - (var10.field2241 & 255));
                                 break;
                              default:
                                 if(var14 == 0) {
                                    Rasterizer2D.method3876(var12, var13, var10.width, var10.height, var19);
                                 } else {
                                    Rasterizer2D.method3849(var12, var13, var10.width, var10.height, var19, 256 - (var14 & 255));
                                 }
                              }
                           } else if(var14 == 0) {
                              Rasterizer2D.method3863(var12, var13, var10.width, var10.height, var19);
                           } else {
                              Rasterizer2D.method3859(var12, var13, var10.width, var10.height, var19, 256 - (var14 & 255));
                           }
                        } else {
                           Font var50;
                           if(var10.type == 4) {
                              var50 = var10.method3091();
                              if(null == var50) {
                                 if(Widget.field2207) {
                                    class204.method3671(var10);
                                 }
                              } else {
                                 String var51 = var10.text;
                                 if(class6.method78(var10)) {
                                    var20 = var10.field2235;
                                    if(var10 == class215.field3163 && var10.field2237 != 0) {
                                       var20 = var10.field2237;
                                    }

                                    if(var10.field2264.length() > 0) {
                                       var51 = var10.field2264;
                                    }
                                 } else {
                                    var20 = var10.textColor;
                                    if(var10 == class215.field3163 && var10.field2341 != 0) {
                                       var20 = var10.field2341;
                                    }
                                 }

                                 if(var10.hasScript && var10.item != -1) {
                                    ItemComposition var45 = NPC.getItemDefinition(var10.item);
                                    var51 = var45.name;
                                    if(null == var51) {
                                       var51 = "null";
                                    }

                                    if((var45.isStackable == 1 || var10.stackSize != 1) && var10.stackSize != -1) {
                                       var51 = Actor.method574(16748608) + var51 + "</col>" + " " + 'x' + MessageNode.method181(var10.stackSize);
                                    }
                                 }

                                 if(var10 == Client.field455) {
                                    Object var10000 = null;
                                    var51 = "Please wait...";
                                    var20 = var10.textColor;
                                 }

                                 if(!var10.hasScript) {
                                    var51 = MessageNode.method184(var51, var10);
                                 }

                                 var50.method3731(var51, var12, var13, var10.width, var10.height, var20, var10.field2274?0:-1, var10.field2272, var10.field2273, var10.field2234);
                              }
                           } else if(var10.type == 5) {
                              SpritePixels var52;
                              if(!var10.hasScript) {
                                 var52 = var10.method3096(class6.method78(var10));
                                 if(null != var52) {
                                    var52.method3971(var12, var13);
                                 } else if(Widget.field2207) {
                                    class204.method3671(var10);
                                 }
                              } else {
                                 if(var10.item != -1) {
                                    var52 = TextureProvider.createSprite(var10.item, var10.stackSize, var10.borderThickness, var10.sprite2, var10.field2267, false);
                                 } else {
                                    var52 = var10.method3096(false);
                                 }

                                 if(var52 == null) {
                                    if(Widget.field2207) {
                                       class204.method3671(var10);
                                    }
                                 } else {
                                    var20 = var52.maxWidth;
                                    var21 = var52.maxHeight;
                                    if(!var10.field2247) {
                                       var37 = var10.width * 4096 / var20;
                                       if(var10.field2246 != 0) {
                                          var52.method3984(var10.width / 2 + var12, var13 + var10.height / 2, var10.field2246, var37);
                                       } else if(var14 != 0) {
                                          var52.method3959(var12, var13, var10.width, var10.height, 256 - (var14 & 255));
                                       } else if(var20 == var10.width && var10.height == var21) {
                                          var52.method3971(var12, var13);
                                       } else {
                                          var52.method3973(var12, var13, var10.width, var10.height);
                                       }
                                    } else {
                                       Rasterizer2D.method3845(var12, var13, var10.width + var12, var13 + var10.height);
                                       var37 = (var20 - 1 + var10.width) / var20;
                                       var36 = (var21 - 1 + var10.height) / var21;

                                       for(var41 = 0; var41 < var37; ++var41) {
                                          for(var25 = 0; var25 < var36; ++var25) {
                                             if(var10.field2246 != 0) {
                                                var52.method3984(var12 + var41 * var20 + var20 / 2, var21 / 2 + var13 + var21 * var25, var10.field2246, 4096);
                                             } else if(var14 != 0) {
                                                var52.method3977(var12 + var20 * var41, var25 * var21 + var13, 256 - (var14 & 255));
                                             } else {
                                                var52.method3971(var12 + var20 * var41, var13 + var25 * var21);
                                             }
                                          }
                                       }

                                       Rasterizer2D.method3844(var2, var3, var4, var5);
                                    }
                                 }
                              }
                           } else {
                              ItemComposition var23;
                              if(var10.type == 6) {
                                 boolean var43 = class6.method78(var10);
                                 if(var43) {
                                    var20 = var10.field2200;
                                 } else {
                                    var20 = var10.field2256;
                                 }

                                 Model var49 = null;
                                 var37 = 0;
                                 if(var10.item != -1) {
                                    var23 = NPC.getItemDefinition(var10.item);
                                    if(var23 != null) {
                                       var23 = var23.method3553(var10.stackSize);
                                       var49 = var23.getModel(1);
                                       if(null != var49) {
                                          var49.method1518();
                                          var37 = var49.modelHeight / 2;
                                       } else {
                                          class204.method3671(var10);
                                       }
                                    }
                                 } else if(var10.modelType == 5) {
                                    if(var10.modelId == 0) {
                                       var49 = Client.field470.method3046((Sequence)null, -1, (Sequence)null, -1);
                                    } else {
                                       var49 = XItemContainer.localPlayer.getModel();
                                    }
                                 } else if(var20 == -1) {
                                    var49 = var10.method3099((Sequence)null, -1, var43, XItemContainer.localPlayer.composition);
                                    if(null == var49 && Widget.field2207) {
                                       class204.method3671(var10);
                                    }
                                 } else {
                                    Sequence var47 = class110.getAnimation(var20);
                                    var49 = var10.method3099(var47, var10.field2331, var43, XItemContainer.localPlayer.composition);
                                    if(var49 == null && Widget.field2207) {
                                       class204.method3671(var10);
                                    }
                                 }

                                 class84.method1596(var12 + var10.width / 2, var10.height / 2 + var13);
                                 var36 = var10.field2263 * class84.field1444[var10.rotationX] >> 16;
                                 var41 = var10.field2263 * class84.field1453[var10.rotationX] >> 16;
                                 if(null != var49) {
                                    if(!var10.hasScript) {
                                       var49.method1534(0, var10.rotationZ, 0, var10.rotationX, 0, var36, var41);
                                    } else {
                                       var49.method1518();
                                       if(var10.field2268) {
                                          var49.method1535(0, var10.rotationZ, var10.rotationY, var10.rotationX, var10.field2297, var10.field2259 + var37 + var36, var10.field2259 + var41, var10.field2263);
                                       } else {
                                          var49.method1534(0, var10.rotationZ, var10.rotationY, var10.rotationX, var10.field2297, var10.field2259 + var36 + var37, var10.field2259 + var41);
                                       }
                                    }
                                 }

                                 class84.method1595();
                              } else {
                                 if(var10.type == 7) {
                                    var50 = var10.method3091();
                                    if(var50 == null) {
                                       if(Widget.field2207) {
                                          class204.method3671(var10);
                                       }
                                       continue;
                                    }

                                    var20 = 0;

                                    for(var21 = 0; var21 < var10.field2221; ++var21) {
                                       for(var37 = 0; var37 < var10.originalWidth; ++var37) {
                                          if(var10.itemIds[var20] > 0) {
                                             var23 = NPC.getItemDefinition(var10.itemIds[var20] - 1);
                                             String var24;
                                             if(var23.isStackable != 1 && var10.itemQuantities[var20] == 1) {
                                                var24 = Actor.method574(16748608) + var23.name + "</col>";
                                             } else {
                                                var24 = Actor.method574(16748608) + var23.name + "</col>" + " " + 'x' + MessageNode.method181(var10.itemQuantities[var20]);
                                             }

                                             var25 = (var10.field2275 + 115) * var37 + var12;
                                             var26 = var21 * (var10.field2276 + 12) + var13;
                                             if(var10.field2272 == 0) {
                                                var50.method3727(var24, var25, var26, var10.textColor, var10.field2274?0:-1);
                                             } else if(var10.field2272 == 1) {
                                                var50.method3739(var24, var10.width / 2 + var25, var26, var10.textColor, var10.field2274?0:-1);
                                             } else {
                                                var50.method3770(var24, var10.width + var25 - 1, var26, var10.textColor, var10.field2274?0:-1);
                                             }
                                          }

                                          ++var20;
                                       }
                                    }
                                 }

                                 int var27;
                                 if(var10.type == 8 && var10 == XItemContainer.field130 && Client.field443 == Client.field442) {
                                    var19 = 0;
                                    var20 = 0;
                                    Font var38 = class20.field234;
                                    String var22 = var10.text;

                                    String var44;
                                    for(var22 = MessageNode.method184(var22, var10); var22.length() > 0; var20 += var38.field3102 + 1) {
                                       var41 = var22.indexOf("<br>");
                                       if(var41 != -1) {
                                          var44 = var22.substring(0, var41);
                                          var22 = var22.substring(4 + var41);
                                       } else {
                                          var44 = var22;
                                          var22 = "";
                                       }

                                       var25 = var38.method3722(var44);
                                       if(var25 > var19) {
                                          var19 = var25;
                                       }
                                    }

                                    var19 += 6;
                                    var20 += 7;
                                    var41 = var10.width + var12 - 5 - var19;
                                    var25 = 5 + var13 + var10.height;
                                    if(var41 < 5 + var12) {
                                       var41 = 5 + var12;
                                    }

                                    if(var19 + var41 > var4) {
                                       var41 = var4 - var19;
                                    }

                                    if(var25 + var20 > var5) {
                                       var25 = var5 - var20;
                                    }

                                    Rasterizer2D.method3876(var41, var25, var19, var20, 16777120);
                                    Rasterizer2D.method3863(var41, var25, var19, var20, 0);
                                    var22 = var10.text;
                                    var26 = var38.field3102 + var25 + 2;

                                    for(var22 = MessageNode.method184(var22, var10); var22.length() > 0; var26 += 1 + var38.field3102) {
                                       var27 = var22.indexOf("<br>");
                                       if(var27 != -1) {
                                          var44 = var22.substring(0, var27);
                                          var22 = var22.substring(var27 + 4);
                                       } else {
                                          var44 = var22;
                                          var22 = "";
                                       }

                                       var38.method3727(var44, 3 + var41, var26, 0, -1);
                                    }
                                 }

                                 if(var10.type == 9) {
                                    if(var10.field2298 == 1) {
                                       if(var10.field2243) {
                                          var19 = var12;
                                          var20 = var13 + var10.height;
                                          var21 = var10.width + var12;
                                          var37 = var13;
                                       } else {
                                          var19 = var12;
                                          var20 = var13;
                                          var21 = var10.width + var12;
                                          var37 = var13 + var10.height;
                                       }

                                       Rasterizer2D.method3848(var19, var20, var21, var37, var10.textColor);
                                    } else {
                                       var19 = var10.width >= 0?var10.width:-var10.width;
                                       var20 = var10.height >= 0?var10.height:-var10.height;
                                       var21 = var19;
                                       if(var19 < var20) {
                                          var21 = var20;
                                       }

                                       if(var21 != 0) {
                                          var37 = (var10.width << 16) / var21;
                                          var36 = (var10.height << 16) / var21;
                                          if(var36 <= var37) {
                                             var37 = -var37;
                                          } else {
                                             var36 = -var36;
                                          }

                                          var41 = var36 * var10.field2298 >> 17;
                                          var25 = var36 * var10.field2298 + 1 >> 17;
                                          var26 = var37 * var10.field2298 >> 17;
                                          var27 = 1 + var10.field2298 * var37 >> 17;
                                          int var42 = var41 + var12;
                                          var29 = var12 - var25;
                                          int var30 = var10.width + var12 - var25;
                                          int var31 = var41 + var12 + var10.width;
                                          int var32 = var26 + var13;
                                          int var33 = var13 - var27;
                                          int var34 = var10.height + var13 - var27;
                                          int var35 = var13 + var10.height + var26;
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
}
