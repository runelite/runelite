import java.math.BigInteger;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ar")
public class class36 {
   @ObfuscatedName("j")
   static final BigInteger field767 = new BigInteger("7237300117305667488707183861728052766358166655052137727439795191253340127955075499635575104901523446809299097934591732635674173519120047404024393881551683");
   @ObfuscatedName("w")
   static final BigInteger field770 = new BigInteger("80782894952180643741752986186714059433953886149239752893425047584684715842049");

   class36() throws Throwable {
      throw new Error();
   }

   @ObfuscatedName("ad")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1031678119"
   )
   static void method748(int var0) {
      Client.field484 = 0L;
      if(var0 >= 2) {
         Client.isResized = true;
      } else {
         Client.isResized = false;
      }

      ChatLineBuffer.method912();
      if(Client.gameState >= 25) {
         Client.field321.method3195(245);
         class166 var1 = Client.field321;
         int var2 = Client.isResized?2:1;
         var1.method2912(var2);
         Client.field321.method3094(XItemContainer.field123);
         Client.field321.method3094(class143.field1999);
      }

      GameEngine.field1776 = true;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(IB)I",
      garbageValue = "82"
   )
   static int method749(int var0) {
      MessageNode var1 = (MessageNode)class47.field925.method2297((long)var0);
      return var1 == null?-1:(var1.previous == class47.field926.field1892?-1:((MessageNode)var1.previous).id);
   }

   @ObfuscatedName("cm")
   @ObfuscatedSignature(
      signature = "([LWidget;IIIIIIIII)V",
      garbageValue = "749316420"
   )
   @Export("gameDraw")
   static final void gameDraw(Widget[] var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
      Rasterizer2D.method3973(var2, var3, var4, var5);
      class84.method1642();

      for(int var9 = 0; var9 < var0.length; ++var9) {
         Widget var10 = var0[var9];
         if(null != var10 && (var1 == var10.parentId || var1 == -1412584499 && Client.field450 == var10)) {
            int var11;
            if(var8 == -1) {
               Client.widgetPositionX[Client.field288] = var10.relativeX + var6;
               Client.widgetPositionY[Client.field288] = var10.relativeY + var7;
               Client.widgetBoundsWidth[Client.field288] = var10.width;
               Client.widgetBoundsHeight[Client.field288] = var10.height;
               var11 = ++Client.field288 - 1;
            } else {
               var11 = var8;
            }

            var10.boundsIndex = var11;
            var10.field2181 = Client.gameCycle;
            if(!var10.hasScript || !class48.method894(var10)) {
               int var12;
               if(var10.contentType > 0) {
                  var12 = var10.contentType;
                  if(var12 == 324) {
                     if(Client.field552 == -1) {
                        Client.field552 = var10.textureId;
                        Client.field295 = var10.field2062;
                     }

                     if(Client.field551.isFemale) {
                        var10.textureId = Client.field552;
                     } else {
                        var10.textureId = Client.field295;
                     }
                  } else if(var12 == 325) {
                     if(Client.field552 == -1) {
                        Client.field552 = var10.textureId;
                        Client.field295 = var10.field2062;
                     }

                     if(Client.field551.isFemale) {
                        var10.textureId = Client.field295;
                     } else {
                        var10.textureId = Client.field552;
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
               int var13 = var10.relativeY + var7;
               int var14 = var10.opacity;
               int var15;
               int var16;
               if(Client.field450 == var10) {
                  if(var1 != -1412584499 && !var10.field2172) {
                     class60.field1078 = var0;
                     class5.field51 = var6;
                     class32.field721 = var7;
                     continue;
                  }

                  if(Client.field460 && Client.field388) {
                     var15 = class115.field1799;
                     var16 = class115.field1794;
                     var15 -= Client.field452;
                     var16 -= Client.field360;
                     if(var15 < Client.field456) {
                        var15 = Client.field456;
                     }

                     if(var15 + var10.width > Client.field456 + Client.field420.width) {
                        var15 = Client.field420.width + Client.field456 - var10.width;
                     }

                     if(var16 < Client.field457) {
                        var16 = Client.field457;
                     }

                     if(var10.height + var16 > Client.field457 + Client.field420.height) {
                        var16 = Client.field420.height + Client.field457 - var10.height;
                     }

                     var12 = var15;
                     var13 = var16;
                  }

                  if(!var10.field2172) {
                     var14 = 128;
                  }
               }

               int var17;
               int var18;
               int var19;
               int var20;
               int var36;
               int var40;
               if(var10.type == 2) {
                  var15 = var2;
                  var16 = var3;
                  var17 = var4;
                  var18 = var5;
               } else if(var10.type == 9) {
                  var19 = var12;
                  var20 = var13;
                  var36 = var12 + var10.width;
                  var40 = var13 + var10.height;
                  if(var36 < var12) {
                     var19 = var36;
                     var36 = var12;
                  }

                  if(var40 < var13) {
                     var20 = var40;
                     var40 = var13;
                  }

                  ++var36;
                  ++var40;
                  var15 = var19 > var2?var19:var2;
                  var16 = var20 > var3?var20:var3;
                  var17 = var36 < var4?var36:var4;
                  var18 = var40 < var5?var40:var5;
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
                        if(Client.field441) {
                           var13 += 15;
                           class49.field961.method3894("Fps:" + GameEngine.FPS, var12 + var10.width, var13, 16776960, -1);
                           var13 += 15;
                           Runtime var54 = Runtime.getRuntime();
                           var20 = (int)((var54.totalMemory() - var54.freeMemory()) / 1024L);
                           var36 = 16776960;
                           if(var20 > '耀' && Client.field278) {
                              var36 = 16711680;
                           }

                           if(var20 > 65536 && !Client.field278) {
                              var36 = 16711680;
                           }

                           class49.field961.method3894("Mem:" + var20 + "k", var10.width + var12, var13, var36, -1);
                           var13 += 15;
                        }
                        continue;
                     }

                     if(var10.contentType == 1337) {
                        Client.field424 = var12;
                        Client.field425 = var13;
                        class32.method715(var12, var13, var10.width, var10.height);
                        Client.field482[var10.boundsIndex] = true;
                        Rasterizer2D.method3973(var2, var3, var4, var5);
                        continue;
                     }

                     if(var10.contentType == 1338) {
                        WidgetNode.method200(var10, var12, var13, var11);
                        Rasterizer2D.method3973(var2, var3, var4, var5);
                        continue;
                     }

                     if(var10.contentType == 1339) {
                        class145 var53 = var10.method2778(false);
                        if(var53 != null) {
                           if(Client.field514 < 3) {
                              WidgetNode.field180.method4125(var12, var13, var53.field2007, var53.field2004, 25, 25, Client.mapAngle, 256, var53.field2006, var53.field2003);
                           } else {
                              Rasterizer2D.method3992(var12, var13, 0, var53.field2006, var53.field2003);
                           }
                        }

                        Rasterizer2D.method3973(var2, var3, var4, var5);
                        continue;
                     }
                  }

                  if(var10.type == 0) {
                     if(!var10.hasScript && class48.method894(var10) && class138.field1907 != var10) {
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

                     WidgetNode var38 = (WidgetNode)Client.componentTable.method2331((long)var10.id);
                     if(var38 != null) {
                        class105.method2013(var38.id, var15, var16, var17, var18, var12, var13, var11);
                     }

                     Rasterizer2D.method3973(var2, var3, var4, var5);
                     class84.method1642();
                  }

                  if(Client.isResized || Client.field536[var11] || Client.field489 > 1) {
                     int var23;
                     int var24;
                     if(var10.type == 0 && !var10.hasScript && var10.scrollHeight > var10.height) {
                        var19 = var12 + var10.width;
                        var20 = var10.scrollY;
                        var36 = var10.height;
                        var40 = var10.scrollHeight;
                        class225.field3219[0].method4064(var19, var13);
                        class225.field3219[1].method4064(var19, var36 + var13 - 16);
                        Rasterizer2D.method4004(var19, 16 + var13, 16, var36 - 32, Client.field490);
                        var23 = var36 * (var36 - 32) / var40;
                        if(var23 < 8) {
                           var23 = 8;
                        }

                        var24 = (var36 - 32 - var23) * var20 / (var40 - var36);
                        Rasterizer2D.method4004(var19, 16 + var13 + var24, 16, var23, Client.field356);
                        Rasterizer2D.method4023(var19, var24 + 16 + var13, var23, Client.field358);
                        Rasterizer2D.method4023(var19 + 1, 16 + var13 + var24, var23, Client.field358);
                        Rasterizer2D.method3987(var19, 16 + var13 + var24, 16, Client.field358);
                        Rasterizer2D.method3987(var19, var24 + var13 + 17, 16, Client.field358);
                        Rasterizer2D.method4023(var19 + 15, var24 + 16 + var13, var23, Client.field357);
                        Rasterizer2D.method4023(14 + var19, var24 + var13 + 17, var23 - 1, Client.field357);
                        Rasterizer2D.method3987(var19, var23 + var13 + 15 + var24, 16, Client.field357);
                        Rasterizer2D.method3987(1 + var19, var23 + var13 + 14 + var24, 15, Client.field357);
                     }

                     if(var10.type != 1) {
                        int var25;
                        int var26;
                        int var29;
                        if(var10.type == 2) {
                           var19 = 0;

                           for(var20 = 0; var20 < var10.field2061; ++var20) {
                              for(var36 = 0; var36 < var10.originalWidth; ++var36) {
                                 var40 = var12 + (var10.field2118 + 32) * var36;
                                 var23 = (var10.field2116 + 32) * var20 + var13;
                                 if(var19 < 20) {
                                    var40 += var10.field2117[var19];
                                    var23 += var10.field2109[var19];
                                 }

                                 if(var10.itemIds[var19] <= 0) {
                                    if(null != var10.field2122 && var19 < 20) {
                                       SpritePixels var55 = var10.method2829(var19);
                                       if(null != var55) {
                                          var55.method4121(var40, var23);
                                       } else if(Widget.field2047) {
                                          class2.method28(var10);
                                       }
                                    }
                                 } else {
                                    boolean var47 = false;
                                    boolean var48 = false;
                                    var26 = var10.itemIds[var19] - 1;
                                    if(32 + var40 > var2 && var40 < var4 && 32 + var23 > var3 && var23 < var5 || var10 == class178.field2665 && var19 == Client.field391) {
                                       SpritePixels var41;
                                       if(Client.field525 == 1 && var19 == Client.field429 && var10.id == class169.field2313) {
                                          var41 = class94.createSprite(var26, var10.itemQuantities[var19], 2, 0, 2, false);
                                       } else {
                                          var41 = class94.createSprite(var26, var10.itemQuantities[var19], 1, 3153952, 2, false);
                                       }

                                       if(var41 != null) {
                                          if(var10 == class178.field2665 && Client.field391 == var19) {
                                             var24 = class115.field1799 - Client.field392;
                                             var25 = class115.field1794 - Client.field497;
                                             if(var24 < 5 && var24 > -5) {
                                                var24 = 0;
                                             }

                                             if(var25 < 5 && var25 > -5) {
                                                var25 = 0;
                                             }

                                             if(Client.field395 < 5) {
                                                var24 = 0;
                                                var25 = 0;
                                             }

                                             var41.method4120(var24 + var40, var23 + var25, 128);
                                             if(var1 != -1) {
                                                Widget var28 = var0[var1 & '\uffff'];
                                                if(var23 + var25 < Rasterizer2D.field3172 && var28.scrollY > 0) {
                                                   var29 = (Rasterizer2D.field3172 - var23 - var25) * Client.field354 / 3;
                                                   if(var29 > Client.field354 * 10) {
                                                      var29 = Client.field354 * 10;
                                                   }

                                                   if(var29 > var28.scrollY) {
                                                      var29 = var28.scrollY;
                                                   }

                                                   var28.scrollY -= var29;
                                                   Client.field497 += var29;
                                                   class2.method28(var28);
                                                }

                                                if(32 + var23 + var25 > Rasterizer2D.field3169 && var28.scrollY < var28.scrollHeight - var28.height) {
                                                   var29 = (var25 + var23 + 32 - Rasterizer2D.field3169) * Client.field354 / 3;
                                                   if(var29 > Client.field354 * 10) {
                                                      var29 = Client.field354 * 10;
                                                   }

                                                   if(var29 > var28.scrollHeight - var28.height - var28.scrollY) {
                                                      var29 = var28.scrollHeight - var28.height - var28.scrollY;
                                                   }

                                                   var28.scrollY += var29;
                                                   Client.field497 -= var29;
                                                   class2.method28(var28);
                                                }
                                             }
                                          } else if(var10 == class31.field708 && var19 == Client.field390) {
                                             var41.method4120(var40, var23, 128);
                                          } else {
                                             var41.method4121(var40, var23);
                                          }
                                       } else {
                                          class2.method28(var10);
                                       }
                                    }
                                 }

                                 ++var19;
                              }
                           }
                        } else if(var10.type == 3) {
                           if(class176.method3255(var10)) {
                              var19 = var10.field2075;
                              if(var10 == class138.field1907 && var10.field2077 != 0) {
                                 var19 = var10.field2077;
                              }
                           } else {
                              var19 = var10.textColor;
                              if(var10 == class138.field1907 && var10.field2076 != 0) {
                                 var19 = var10.field2076;
                              }
                           }

                           if(var10.field2099) {
                              switch(var10.field2079.field3185) {
                              case 1:
                                 Rasterizer2D.method4017(var12, var13, var10.width, var10.height, var10.textColor, var10.field2075, 256 - (var10.opacity & 255), 256 - (var10.field2081 & 255));
                                 break;
                              case 2:
                                 Rasterizer2D.method3981(var12, var13, var10.width, var10.height, var10.textColor, var10.field2075, 256 - (var10.opacity & 255), 256 - (var10.field2081 & 255));
                                 break;
                              case 3:
                                 Rasterizer2D.method3982(var12, var13, var10.width, var10.height, var10.textColor, var10.field2075, 256 - (var10.opacity & 255), 256 - (var10.field2081 & 255));
                                 break;
                              case 4:
                                 Rasterizer2D.method3983(var12, var13, var10.width, var10.height, var10.textColor, var10.field2075, 256 - (var10.opacity & 255), 256 - (var10.field2081 & 255));
                                 break;
                              default:
                                 if(var14 == 0) {
                                    Rasterizer2D.method4004(var12, var13, var10.width, var10.height, var19);
                                 } else {
                                    Rasterizer2D.method3978(var12, var13, var10.width, var10.height, var19, 256 - (var14 & 255));
                                 }
                              }
                           } else if(var14 == 0) {
                              Rasterizer2D.method3985(var12, var13, var10.width, var10.height, var19);
                           } else {
                              Rasterizer2D.method3986(var12, var13, var10.width, var10.height, var19, 256 - (var14 & 255));
                           }
                        } else {
                           Font var50;
                           if(var10.type == 4) {
                              var50 = var10.method2780();
                              if(var50 == null) {
                                 if(Widget.field2047) {
                                    class2.method28(var10);
                                 }
                              } else {
                                 String var45 = var10.text;
                                 if(class176.method3255(var10)) {
                                    var20 = var10.field2075;
                                    if(var10 == class138.field1907 && var10.field2077 != 0) {
                                       var20 = var10.field2077;
                                    }

                                    if(var10.field2068.length() > 0) {
                                       var45 = var10.field2068;
                                    }
                                 } else {
                                    var20 = var10.textColor;
                                    if(var10 == class138.field1907 && var10.field2076 != 0) {
                                       var20 = var10.field2076;
                                    }
                                 }

                                 if(var10.hasScript && var10.item != -1) {
                                    ItemComposition var46 = PlayerComposition.getItemDefinition(var10.item);
                                    var45 = var46.name;
                                    if(null == var45) {
                                       var45 = "null";
                                    }

                                    if((var46.isStackable == 1 || var10.stackSize != 1) && var10.stackSize != -1) {
                                       var45 = class163.method3157(16748608) + var45 + "</col>" + " " + 'x' + class25.method615(var10.stackSize);
                                    }
                                 }

                                 if(Client.field309 == var10) {
                                    Object var10000 = null;
                                    var45 = "Please wait...";
                                    var20 = var10.textColor;
                                 }

                                 if(!var10.hasScript) {
                                    var45 = MessageNode.method215(var45, var10);
                                 }

                                 var50.method3875(var45, var12, var13, var10.width, var10.height, var20, var10.field2163?0:-1, var10.field2112, var10.field2080, var10.field2113);
                              }
                           } else if(var10.type == 5) {
                              SpritePixels var51;
                              if(!var10.hasScript) {
                                 var51 = var10.method2823(class176.method3255(var10));
                                 if(var51 != null) {
                                    var51.method4121(var12, var13);
                                 } else if(Widget.field2047) {
                                    class2.method28(var10);
                                 }
                              } else {
                                 if(var10.item != -1) {
                                    var51 = class94.createSprite(var10.item, var10.stackSize, var10.borderThickness, var10.sprite2, var10.field2057, false);
                                 } else {
                                    var51 = var10.method2823(false);
                                 }

                                 if(var51 == null) {
                                    if(Widget.field2047) {
                                       class2.method28(var10);
                                    }
                                 } else {
                                    var20 = var51.maxWidth;
                                    var36 = var51.maxHeight;
                                    if(!var10.field2087) {
                                       var40 = var10.width * 4096 / var20;
                                       if(var10.field2078 != 0) {
                                          var51.method4127(var10.width / 2 + var12, var13 + var10.height / 2, var10.field2078, var40);
                                       } else if(var14 != 0) {
                                          var51.method4122(var12, var13, var10.width, var10.height, 256 - (var14 & 255));
                                       } else if(var10.width == var20 && var10.height == var36) {
                                          var51.method4121(var12, var13);
                                       } else {
                                          var51.method4116(var12, var13, var10.width, var10.height);
                                       }
                                    } else {
                                       Rasterizer2D.method3974(var12, var13, var12 + var10.width, var10.height + var13);
                                       var40 = (var10.width + (var20 - 1)) / var20;
                                       var23 = (var36 - 1 + var10.height) / var36;

                                       for(var24 = 0; var24 < var40; ++var24) {
                                          for(var25 = 0; var25 < var23; ++var25) {
                                             if(var10.field2078 != 0) {
                                                var51.method4127(var20 / 2 + var20 * var24 + var12, var13 + var36 * var25 + var36 / 2, var10.field2078, 4096);
                                             } else if(var14 != 0) {
                                                var51.method4120(var20 * var24 + var12, var13 + var36 * var25, 256 - (var14 & 255));
                                             } else {
                                                var51.method4121(var20 * var24 + var12, var13 + var25 * var36);
                                             }
                                          }
                                       }

                                       Rasterizer2D.method3973(var2, var3, var4, var5);
                                    }
                                 }
                              }
                           } else {
                              ItemComposition var37;
                              if(var10.type == 6) {
                                 boolean var44 = class176.method3255(var10);
                                 if(var44) {
                                    var20 = var10.field2074;
                                 } else {
                                    var20 = var10.field2164;
                                 }

                                 Model var43 = null;
                                 var40 = 0;
                                 if(var10.item != -1) {
                                    var37 = PlayerComposition.getItemDefinition(var10.item);
                                    if(var37 != null) {
                                       var37 = var37.method3653(var10.stackSize);
                                       var43 = var37.getModel(1);
                                       if(var43 != null) {
                                          var43.method1568();
                                          var40 = var43.modelHeight / 2;
                                       } else {
                                          class2.method28(var10);
                                       }
                                    }
                                 } else if(var10.modelType == 5) {
                                    if(var10.modelId == 0) {
                                       var43 = Client.field551.method2739((Sequence)null, -1, (Sequence)null, -1);
                                    } else {
                                       var43 = VertexNormal.localPlayer.getModel();
                                    }
                                 } else if(var20 == -1) {
                                    var43 = var10.method2815((Sequence)null, -1, var44, VertexNormal.localPlayer.composition);
                                    if(null == var43 && Widget.field2047) {
                                       class2.method28(var10);
                                    }
                                 } else {
                                    Sequence var52 = TextureProvider.getAnimation(var20);
                                    var43 = var10.method2815(var52, var10.field2054, var44, VertexNormal.localPlayer.composition);
                                    if(null == var43 && Widget.field2047) {
                                       class2.method28(var10);
                                    }
                                 }

                                 class84.method1646(var12 + var10.width / 2, var10.height / 2 + var13);
                                 var23 = class84.field1428[var10.rotationX] * var10.field2103 >> 16;
                                 var24 = var10.field2103 * class84.field1452[var10.rotationX] >> 16;
                                 if(null != var43) {
                                    if(!var10.hasScript) {
                                       var43.method1580(0, var10.rotationZ, 0, var10.rotationX, 0, var23, var24);
                                    } else {
                                       var43.method1568();
                                       if(var10.field2121) {
                                          var43.method1581(0, var10.rotationZ, var10.rotationY, var10.rotationX, var10.field2160, var40 + var23 + var10.field2114, var24 + var10.field2114, var10.field2103);
                                       } else {
                                          var43.method1580(0, var10.rotationZ, var10.rotationY, var10.rotationX, var10.field2160, var40 + var23 + var10.field2114, var10.field2114 + var24);
                                       }
                                    }
                                 }

                                 class84.method1645();
                              } else {
                                 if(var10.type == 7) {
                                    var50 = var10.method2780();
                                    if(var50 == null) {
                                       if(Widget.field2047) {
                                          class2.method28(var10);
                                       }
                                       continue;
                                    }

                                    var20 = 0;

                                    for(var36 = 0; var36 < var10.field2061; ++var36) {
                                       for(var40 = 0; var40 < var10.originalWidth; ++var40) {
                                          if(var10.itemIds[var20] > 0) {
                                             var37 = PlayerComposition.getItemDefinition(var10.itemIds[var20] - 1);
                                             String var39;
                                             if(var37.isStackable != 1 && var10.itemQuantities[var20] == 1) {
                                                var39 = class163.method3157(16748608) + var37.name + "</col>";
                                             } else {
                                                var39 = class163.method3157(16748608) + var37.name + "</col>" + " " + 'x' + class25.method615(var10.itemQuantities[var20]);
                                             }

                                             var25 = var40 * (115 + var10.field2118) + var12;
                                             var26 = var36 * (var10.field2116 + 12) + var13;
                                             if(var10.field2112 == 0) {
                                                var50.method3919(var39, var25, var26, var10.textColor, var10.field2163?0:-1);
                                             } else if(var10.field2112 == 1) {
                                                var50.method3874(var39, var25 + var10.width / 2, var26, var10.textColor, var10.field2163?0:-1);
                                             } else {
                                                var50.method3894(var39, var10.width + var25 - 1, var26, var10.textColor, var10.field2163?0:-1);
                                             }
                                          }

                                          ++var20;
                                       }
                                    }
                                 }

                                 int var27;
                                 if(var10.type == 8 && class137.field1893 == var10 && Client.field426 == Client.field455) {
                                    var19 = 0;
                                    var20 = 0;
                                    Font var21 = class49.field961;
                                    String var22 = var10.text;

                                    String var49;
                                    for(var22 = MessageNode.method215(var22, var10); var22.length() > 0; var20 += var21.field3086 + 1) {
                                       var24 = var22.indexOf("<br>");
                                       if(var24 != -1) {
                                          var49 = var22.substring(0, var24);
                                          var22 = var22.substring(4 + var24);
                                       } else {
                                          var49 = var22;
                                          var22 = "";
                                       }

                                       var25 = var21.method3884(var49);
                                       if(var25 > var19) {
                                          var19 = var25;
                                       }
                                    }

                                    var19 += 6;
                                    var20 += 7;
                                    var24 = var12 + var10.width - 5 - var19;
                                    var25 = 5 + var10.height + var13;
                                    if(var24 < 5 + var12) {
                                       var24 = 5 + var12;
                                    }

                                    if(var24 + var19 > var4) {
                                       var24 = var4 - var19;
                                    }

                                    if(var20 + var25 > var5) {
                                       var25 = var5 - var20;
                                    }

                                    Rasterizer2D.method4004(var24, var25, var19, var20, 16777120);
                                    Rasterizer2D.method3985(var24, var25, var19, var20, 0);
                                    var22 = var10.text;
                                    var26 = var21.field3086 + var25 + 2;

                                    for(var22 = MessageNode.method215(var22, var10); var22.length() > 0; var26 += var21.field3086 + 1) {
                                       var27 = var22.indexOf("<br>");
                                       if(var27 != -1) {
                                          var49 = var22.substring(0, var27);
                                          var22 = var22.substring(var27 + 4);
                                       } else {
                                          var49 = var22;
                                          var22 = "";
                                       }

                                       var21.method3919(var49, 3 + var24, var26, 0, -1);
                                    }
                                 }

                                 if(var10.type == 9) {
                                    if(var10.field2082 == 1) {
                                       if(var10.field2083) {
                                          var19 = var12;
                                          var20 = var13 + var10.height;
                                          var36 = var10.width + var12;
                                          var40 = var13;
                                       } else {
                                          var19 = var12;
                                          var20 = var13;
                                          var36 = var10.width + var12;
                                          var40 = var10.height + var13;
                                       }

                                       Rasterizer2D.method3991(var19, var20, var36, var40, var10.textColor);
                                    } else {
                                       var19 = var10.width >= 0?var10.width:-var10.width;
                                       var20 = var10.height >= 0?var10.height:-var10.height;
                                       var36 = var19;
                                       if(var19 < var20) {
                                          var36 = var20;
                                       }

                                       if(var36 != 0) {
                                          var40 = (var10.width << 16) / var36;
                                          var23 = (var10.height << 16) / var36;
                                          if(var23 <= var40) {
                                             var40 = -var40;
                                          } else {
                                             var23 = -var23;
                                          }

                                          var24 = var23 * var10.field2082 >> 17;
                                          var25 = var23 * var10.field2082 + 1 >> 17;
                                          var26 = var10.field2082 * var40 >> 17;
                                          var27 = var40 * var10.field2082 + 1 >> 17;
                                          int var42 = var12 + var24;
                                          var29 = var12 - var25;
                                          int var30 = var12 + var10.width - var25;
                                          int var31 = var10.width + var12 + var24;
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
}
