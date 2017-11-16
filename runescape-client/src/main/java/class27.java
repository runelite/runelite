import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("au")
public enum class27 implements class185 {
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "Lau;"
   )
   field371(0, (byte)0),
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Lau;"
   )
   field362(2, (byte)1),
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "Lau;"
   )
   field364(1, (byte)2),
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Lau;"
   )
   field365(3, (byte)3);

   @ObfuscatedName("om")
   @ObfuscatedGetter(
      intValue = 264472439
   )
   static int field370;
   @ObfuscatedName("j")
   static int[][][] field368;
   @ObfuscatedName("eu")
   @ObfuscatedSignature(
      signature = "Ljn;"
   )
   static Font field363;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 997636219
   )
   final int field366;
   @ObfuscatedName("f")
   final byte field369;

   class27(int var3, byte var4) {
      this.field366 = var3;
      this.field369 = var4;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-4"
   )
   public int rsOrdinal() {
      return this.field369;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Lfs;Lgu;I)Lgu;",
      garbageValue = "1944835574"
   )
   static final IterableHashTable method203(Buffer var0, IterableHashTable var1) {
      int var2 = var0.readUnsignedByte();
      int var3;
      if(var1 == null) {
         var3 = class23.method168(var2);
         var1 = new IterableHashTable(var3);
      }

      for(var3 = 0; var3 < var2; ++var3) {
         boolean var4 = var0.readUnsignedByte() == 1;
         int var5 = var0.read24BitInt();
         Object var6;
         if(var4) {
            var6 = new ObjectNode(var0.readString());
         } else {
            var6 = new IntegerNode(var0.readInt());
         }

         var1.put((Node)var6, (long)var5);
      }

      return var1;
   }

   @ObfuscatedName("hb")
   @ObfuscatedSignature(
      signature = "([Lhx;IIIIIIIII)V",
      garbageValue = "928454408"
   )
   @Export("gameDraw")
   static final void gameDraw(Widget[] var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
      Rasterizer2D.setDrawRegion(var2, var3, var4, var5);
      Graphics3D.method2601();

      for(int var9 = 0; var9 < var0.length; ++var9) {
         Widget var10 = var0[var9];
         if(var10 != null && (var10.parentId == var1 || var1 == -1412584499 && var10 == Client.field1020)) {
            int var11;
            if(var8 == -1) {
               Client.widgetPositionX[Client.field1050] = var10.relativeX + var6;
               Client.widgetPositionY[Client.field1050] = var7 + var10.relativeY;
               Client.widgetBoundsWidth[Client.field1050] = var10.width;
               Client.widgetBoundsHeight[Client.field1050] = var10.height;
               var11 = ++Client.field1050 - 1;
            } else {
               var11 = var8;
            }

            var10.boundsIndex = var11;
            var10.loopCycle = Client.gameCycle;
            if(!var10.hasScript || !class2.method2(var10)) {
               if(var10.contentType > 0) {
                  class181.method3415(var10);
               }

               int var12 = var10.relativeX + var6;
               int var13 = var7 + var10.relativeY;
               int var14 = var10.opacity;
               int var15;
               int var16;
               if(var10 == Client.field1020) {
                  if(var1 != -1412584499 && !var10.field2791) {
                     class14.field271 = var0;
                     class25.field340 = var6;
                     class35.field457 = var7;
                     continue;
                  }

                  if(Client.field993 && Client.field1025) {
                     var15 = MouseInput.field681;
                     var16 = MouseInput.field676;
                     var15 -= Client.field1022;
                     var16 -= Client.field1121;
                     if(var15 < Client.field1026) {
                        var15 = Client.field1026;
                     }

                     if(var15 + var10.width > Client.field1026 + Client.field1021.width) {
                        var15 = Client.field1026 + Client.field1021.width - var10.width;
                     }

                     if(var16 < Client.field1059) {
                        var16 = Client.field1059;
                     }

                     if(var16 + var10.height > Client.field1059 + Client.field1021.height) {
                        var16 = Client.field1059 + Client.field1021.height - var10.height;
                     }

                     var12 = var15;
                     var13 = var16;
                  }

                  if(!var10.field2791) {
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
                  if(var10.contentType != 0) {
                     if(var10.contentType == 1336) {
                        if(Client.displayFps) {
                           var13 += 15;
                           Tile.font_p12full.method4772("Fps:" + GameEngine.FPS, var12 + var10.width, var13, 16776960, -1);
                           var13 += 15;
                           Runtime var43 = Runtime.getRuntime();
                           var20 = (int)((var43.totalMemory() - var43.freeMemory()) / 1024L);
                           var21 = 16776960;
                           if(var20 > 32768 && Client.lowMemory) {
                              var21 = 16711680;
                           }

                           if(var20 > 65536 && !Client.lowMemory) {
                              var21 = 16711680;
                           }

                           Tile.font_p12full.method4772("Mem:" + var20 + "k", var12 + var10.width, var13, var21, -1);
                           var13 += 15;
                        }
                        continue;
                     }

                     if(var10.contentType == 1337) {
                        Client.field996 = var12;
                        Client.field1124 = var13;
                        class246.method4249(var12, var13, var10.width, var10.height);
                        Client.field1052[var10.boundsIndex] = true;
                        Rasterizer2D.setDrawRegion(var2, var3, var4, var5);
                        continue;
                     }

                     if(var10.contentType == 1338) {
                        class15.method97(var10, var12, var13, var11);
                        Rasterizer2D.setDrawRegion(var2, var3, var4, var5);
                        continue;
                     }

                     if(var10.contentType == 1339) {
                        class217 var41 = var10.method4027(false);
                        if(var41 != null) {
                           if(Client.field1108 < 3) {
                              class96.compass.method5125(var12, var13, var41.field2673, var41.field2672, 25, 25, Client.mapAngle, 256, var41.field2675, var41.field2674);
                           } else {
                              Rasterizer2D.method4996(var12, var13, 0, var41.field2675, var41.field2674);
                           }
                        }

                        Rasterizer2D.setDrawRegion(var2, var3, var4, var5);
                        continue;
                     }

                     if(var10.contentType == 1400) {
                        ScriptState.renderOverview.extractWorldmap(var12, var13, var10.width, var10.height, Client.gameCycle);
                     }

                     if(var10.contentType == 1401) {
                        ScriptState.renderOverview.extractData(var12, var13, var10.width, var10.height);
                     }
                  }

                  if(var10.type == 0) {
                     if(!var10.hasScript && class2.method2(var10) && var10 != class13.field264) {
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

                     WidgetNode var30 = (WidgetNode)Client.componentTable.get((long)var10.id);
                     if(var30 != null) {
                        class43.method587(var30.id, var15, var16, var17, var18, var12, var13, var11);
                     }

                     Rasterizer2D.setDrawRegion(var2, var3, var4, var5);
                     Graphics3D.method2601();
                  }

                  if(Client.isResized || Client.field872[var11] || Client.gameDrawingMode > 1) {
                     if(var10.type == 0 && !var10.hasScript && var10.scrollHeight > var10.height) {
                        class35.method474(var12 + var10.width, var13, var10.scrollY, var10.height, var10.scrollHeight);
                     }

                     if(var10.type != 1) {
                        int var23;
                        int var24;
                        int var25;
                        int var26;
                        if(var10.type == 2) {
                           var19 = 0;

                           for(var20 = 0; var20 < var10.field2725; ++var20) {
                              for(var21 = 0; var21 < var10.originalWidth; ++var21) {
                                 var22 = var21 * (var10.paddingX + 32) + var12;
                                 var23 = var13 + var20 * (var10.paddingY + 32);
                                 if(var19 < 20) {
                                    var22 += var10.xSprites[var19];
                                    var23 += var10.field2782[var19];
                                 }

                                 if(var10.itemIds[var19] <= 0) {
                                    if(var10.field2711 != null && var19 < 20) {
                                       SpritePixels var44 = var10.method4052(var19);
                                       if(var44 != null) {
                                          var44.drawAt(var22, var23);
                                       } else if(Widget.field2818) {
                                          ScriptEvent.method1038(var10);
                                       }
                                    }
                                 } else {
                                    boolean var37 = false;
                                    boolean var38 = false;
                                    var26 = var10.itemIds[var19] - 1;
                                    if(var22 + 32 > var2 && var22 < var4 && var23 + 32 > var3 && var23 < var5 || var10 == class72.field812 && var19 == Client.field890) {
                                       SpritePixels var27;
                                       if(Client.itemSelectionState == 1 && var19 == WorldMapType3.selectedItemIndex && var10.id == class268.field3677) {
                                          var27 = class89.createSprite(var26, var10.itemQuantities[var19], 2, 0, 2, false);
                                       } else {
                                          var27 = class89.createSprite(var26, var10.itemQuantities[var19], 1, 3153952, 2, false);
                                       }

                                       if(var27 != null) {
                                          if(var10 == class72.field812 && var19 == Client.field890) {
                                             var24 = MouseInput.field681 - Client.field923;
                                             var25 = MouseInput.field676 - Client.field962;
                                             if(var24 < 5 && var24 > -5) {
                                                var24 = 0;
                                             }

                                             if(var25 < 5 && var25 > -5) {
                                                var25 = 0;
                                             }

                                             if(Client.field965 < 5) {
                                                var24 = 0;
                                                var25 = 0;
                                             }

                                             var27.method5178(var22 + var24, var25 + var23, 128);
                                             if(var1 != -1) {
                                                Widget var28 = var0[var1 & 65535];
                                                int var29;
                                                if(var23 + var25 < Rasterizer2D.drawingAreaTop && var28.scrollY > 0) {
                                                   var29 = (Rasterizer2D.drawingAreaTop - var23 - var25) * Client.field922 / 3;
                                                   if(var29 > Client.field922 * 10) {
                                                      var29 = Client.field922 * 10;
                                                   }

                                                   if(var29 > var28.scrollY) {
                                                      var29 = var28.scrollY;
                                                   }

                                                   var28.scrollY -= var29;
                                                   Client.field962 += var29;
                                                   ScriptEvent.method1038(var28);
                                                }

                                                if(var23 + var25 + 32 > Rasterizer2D.drawingAreaRight && var28.scrollY < var28.scrollHeight - var28.height) {
                                                   var29 = (var23 + var25 + 32 - Rasterizer2D.drawingAreaRight) * Client.field922 / 3;
                                                   if(var29 > Client.field922 * 10) {
                                                      var29 = Client.field922 * 10;
                                                   }

                                                   if(var29 > var28.scrollHeight - var28.height - var28.scrollY) {
                                                      var29 = var28.scrollHeight - var28.height - var28.scrollY;
                                                   }

                                                   var28.scrollY += var29;
                                                   Client.field962 -= var29;
                                                   ScriptEvent.method1038(var28);
                                                }
                                             }
                                          } else if(var10 == class175.field2442 && var19 == Client.field959) {
                                             var27.method5178(var22, var23, 128);
                                          } else {
                                             var27.drawAt(var22, var23);
                                          }
                                       } else {
                                          ScriptEvent.method1038(var10);
                                       }
                                    }
                                 }

                                 ++var19;
                              }
                           }
                        } else if(var10.type == 3) {
                           if(ScriptEvent.method1041(var10)) {
                              var19 = var10.field2834;
                              if(var10 == class13.field264 && var10.field2759 != 0) {
                                 var19 = var10.field2759;
                              }
                           } else {
                              var19 = var10.textColor;
                              if(var10 == class13.field264 && var10.field2838 != 0) {
                                 var19 = var10.field2838;
                              }
                           }

                           if(var10.filled) {
                              switch(var10.field2743.field3823) {
                              case 1:
                                 Rasterizer2D.method4970(var12, var13, var10.width, var10.height, var10.textColor, var10.field2834, 256 - (var10.opacity & 255), 256 - (var10.field2745 & 255));
                                 break;
                              case 2:
                                 Rasterizer2D.method5041(var12, var13, var10.width, var10.height, var10.textColor, var10.field2834, 256 - (var10.opacity & 255), 256 - (var10.field2745 & 255));
                                 break;
                              case 3:
                                 Rasterizer2D.method4984(var12, var13, var10.width, var10.height, var10.textColor, var10.field2834, 256 - (var10.opacity & 255), 256 - (var10.field2745 & 255));
                                 break;
                              case 4:
                                 Rasterizer2D.method4985(var12, var13, var10.width, var10.height, var10.textColor, var10.field2834, 256 - (var10.opacity & 255), 256 - (var10.field2745 & 255));
                                 break;
                              default:
                                 if(var14 == 0) {
                                    Rasterizer2D.method4981(var12, var13, var10.width, var10.height, var19);
                                 } else {
                                    Rasterizer2D.fillRectangle(var12, var13, var10.width, var10.height, var19, 256 - (var14 & 255));
                                 }
                              }
                           } else if(var14 == 0) {
                              Rasterizer2D.drawRectangle(var12, var13, var10.width, var10.height, var19);
                           } else {
                              Rasterizer2D.method5061(var12, var13, var10.width, var10.height, var19, 256 - (var14 & 255));
                           }
                        } else {
                           Font var39;
                           if(var10.type == 4) {
                              var39 = var10.method4024();
                              if(var39 == null) {
                                 if(Widget.field2818) {
                                    ScriptEvent.method1038(var10);
                                 }
                              } else {
                                 String var46 = var10.text;
                                 if(ScriptEvent.method1041(var10)) {
                                    var20 = var10.field2834;
                                    if(var10 == class13.field264 && var10.field2759 != 0) {
                                       var20 = var10.field2759;
                                    }

                                    if(var10.field2774.length() > 0) {
                                       var46 = var10.field2774;
                                    }
                                 } else {
                                    var20 = var10.textColor;
                                    if(var10 == class13.field264 && var10.field2838 != 0) {
                                       var20 = var10.field2838;
                                    }
                                 }

                                 if(var10.hasScript && var10.itemId != -1) {
                                    ItemComposition var47 = class139.getItemDefinition(var10.itemId);
                                    var46 = var47.name;
                                    if(var46 == null) {
                                       var46 = "null";
                                    }

                                    if((var47.isStackable == 1 || var10.itemQuantity != 1) && var10.itemQuantity != -1) {
                                       var46 = class222.getColTags(16748608) + var46 + "</col>" + " " + 'x' + class234.method4091(var10.itemQuantity);
                                    }
                                 }

                                 if(var10 == Client.field878) {
                                    Object var10000 = null;
                                    var46 = "Please wait...";
                                    var20 = var10.textColor;
                                 }

                                 if(!var10.hasScript) {
                                    var46 = class74.method1094(var46, var10);
                                 }

                                 var39.method4774(var46, var12, var13, var10.width, var10.height, var20, var10.textShadowed?0:-1, var10.field2776, var10.field2777, var10.field2706);
                              }
                           } else if(var10.type == 5) {
                              SpritePixels var40;
                              if(!var10.hasScript) {
                                 var40 = var10.method4023(ScriptEvent.method1041(var10));
                                 if(var40 != null) {
                                    var40.drawAt(var12, var13);
                                 } else if(Widget.field2818) {
                                    ScriptEvent.method1038(var10);
                                 }
                              } else {
                                 if(var10.itemId != -1) {
                                    var40 = class89.createSprite(var10.itemId, var10.itemQuantity, var10.borderThickness, var10.sprite2, var10.field2787, false);
                                 } else {
                                    var40 = var10.method4023(false);
                                 }

                                 if(var40 == null) {
                                    if(Widget.field2818) {
                                       ScriptEvent.method1038(var10);
                                    }
                                 } else {
                                    var20 = var40.maxWidth;
                                    var21 = var40.maxHeight;
                                    if(!var10.spriteTiling) {
                                       var22 = var10.width * 4096 / var20;
                                       if(var10.textureId != 0) {
                                          var40.method5118(var10.width / 2 + var12, var10.height / 2 + var13, var10.textureId, var22);
                                       } else if(var14 != 0) {
                                          var40.method5143(var12, var13, var10.width, var10.height, 256 - (var14 & 255));
                                       } else if(var20 == var10.width && var21 == var10.height) {
                                          var40.drawAt(var12, var13);
                                       } else {
                                          var40.method5116(var12, var13, var10.width, var10.height);
                                       }
                                    } else {
                                       Rasterizer2D.setInnerDrawRegion(var12, var13, var12 + var10.width, var13 + var10.height);
                                       var22 = (var20 - 1 + var10.width) / var20;
                                       var23 = (var21 - 1 + var10.height) / var21;

                                       for(var24 = 0; var24 < var22; ++var24) {
                                          for(var25 = 0; var25 < var23; ++var25) {
                                             if(var10.textureId != 0) {
                                                var40.method5118(var20 / 2 + var12 + var24 * var20, var21 / 2 + var13 + var21 * var25, var10.textureId, 4096);
                                             } else if(var14 != 0) {
                                                var40.method5178(var12 + var24 * var20, var13 + var25 * var21, 256 - (var14 & 255));
                                             } else {
                                                var40.drawAt(var12 + var24 * var20, var13 + var21 * var25);
                                             }
                                          }
                                       }

                                       Rasterizer2D.setDrawRegion(var2, var3, var4, var5);
                                    }
                                 }
                              }
                           } else {
                              ItemComposition var34;
                              if(var10.type == 6) {
                                 boolean var36 = ScriptEvent.method1041(var10);
                                 if(var36) {
                                    var20 = var10.field2761;
                                 } else {
                                    var20 = var10.field2760;
                                 }

                                 Model var42 = null;
                                 var22 = 0;
                                 if(var10.itemId != -1) {
                                    var34 = class139.getItemDefinition(var10.itemId);
                                    if(var34 != null) {
                                       var34 = var34.method4597(var10.itemQuantity);
                                       var42 = var34.getModel(1);
                                       if(var42 != null) {
                                          var42.method2511();
                                          var22 = var42.modelHeight / 2;
                                       } else {
                                          ScriptEvent.method1038(var10);
                                       }
                                    }
                                 } else if(var10.modelType == 5) {
                                    if(var10.modelId == 0) {
                                       var42 = Client.field1119.method3999((Sequence)null, -1, (Sequence)null, -1);
                                    } else {
                                       var42 = class275.localPlayer.getModel();
                                    }
                                 } else if(var20 == -1) {
                                    var42 = var10.method4026((Sequence)null, -1, var36, class275.localPlayer.composition);
                                    if(var42 == null && Widget.field2818) {
                                       ScriptEvent.method1038(var10);
                                    }
                                 } else {
                                    Sequence var48 = class90.getAnimation(var20);
                                    var42 = var10.method4026(var48, var10.field2835, var36, class275.localPlayer.composition);
                                    if(var42 == null && Widget.field2818) {
                                       ScriptEvent.method1038(var10);
                                    }
                                 }

                                 Graphics3D.method2649(var10.width / 2 + var12, var10.height / 2 + var13);
                                 var23 = Graphics3D.SINE[var10.rotationX] * var10.modelZoom >> 16;
                                 var24 = Graphics3D.COSINE[var10.rotationX] * var10.modelZoom >> 16;
                                 if(var42 != null) {
                                    if(!var10.hasScript) {
                                       var42.method2524(0, var10.rotationZ, 0, var10.rotationX, 0, var23, var24);
                                    } else {
                                       var42.method2511();
                                       if(var10.field2814) {
                                          var42.method2525(0, var10.rotationZ, var10.rotationY, var10.rotationX, var10.field2762, var23 + var22 + var10.field2763, var24 + var10.field2763, var10.modelZoom);
                                       } else {
                                          var42.method2524(0, var10.rotationZ, var10.rotationY, var10.rotationX, var10.field2762, var22 + var23 + var10.field2763, var24 + var10.field2763);
                                       }
                                    }
                                 }

                                 Graphics3D.method2621();
                              } else {
                                 if(var10.type == 7) {
                                    var39 = var10.method4024();
                                    if(var39 == null) {
                                       if(Widget.field2818) {
                                          ScriptEvent.method1038(var10);
                                       }
                                       continue;
                                    }

                                    var20 = 0;

                                    for(var21 = 0; var21 < var10.field2725; ++var21) {
                                       for(var22 = 0; var22 < var10.originalWidth; ++var22) {
                                          if(var10.itemIds[var20] > 0) {
                                             var34 = class139.getItemDefinition(var10.itemIds[var20] - 1);
                                             String var31;
                                             if(var34.isStackable != 1 && var10.itemQuantities[var20] == 1) {
                                                var31 = class222.getColTags(16748608) + var34.name + "</col>";
                                             } else {
                                                var31 = class222.getColTags(16748608) + var34.name + "</col>" + " " + 'x' + class234.method4091(var10.itemQuantities[var20]);
                                             }

                                             var25 = var12 + var22 * (var10.paddingX + 115);
                                             var26 = (var10.paddingY + 12) * var21 + var13;
                                             if(var10.field2776 == 0) {
                                                var39.method4770(var31, var25, var26, var10.textColor, var10.textShadowed?0:-1);
                                             } else if(var10.field2776 == 1) {
                                                var39.method4773(var31, var10.width / 2 + var25, var26, var10.textColor, var10.textShadowed?0:-1);
                                             } else {
                                                var39.method4772(var31, var25 + var10.width - 1, var26, var10.textColor, var10.textShadowed?0:-1);
                                             }
                                          }

                                          ++var20;
                                       }
                                    }
                                 }

                                 if(var10.type == 8 && var10 == class29.field394 && Client.field975 == Client.field998) {
                                    var19 = 0;
                                    var20 = 0;
                                    Font var32 = Tile.font_p12full;
                                    String var33 = var10.text;

                                    String var45;
                                    for(var33 = class74.method1094(var33, var10); var33.length() > 0; var20 = var20 + var32.verticalSpace + 1) {
                                       var24 = var33.indexOf("<br>");
                                       if(var24 != -1) {
                                          var45 = var33.substring(0, var24);
                                          var33 = var33.substring(var24 + 4);
                                       } else {
                                          var45 = var33;
                                          var33 = "";
                                       }

                                       var25 = var32.method4790(var45);
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

                                    if(var19 + var24 > var4) {
                                       var24 = var4 - var19;
                                    }

                                    if(var20 + var25 > var5) {
                                       var25 = var5 - var20;
                                    }

                                    Rasterizer2D.method4981(var24, var25, var19, var20, 16777120);
                                    Rasterizer2D.drawRectangle(var24, var25, var19, var20, 0);
                                    var33 = var10.text;
                                    var26 = var25 + var32.verticalSpace + 2;

                                    for(var33 = class74.method1094(var33, var10); var33.length() > 0; var26 = var26 + var32.verticalSpace + 1) {
                                       int var35 = var33.indexOf("<br>");
                                       if(var35 != -1) {
                                          var45 = var33.substring(0, var35);
                                          var33 = var33.substring(var35 + 4);
                                       } else {
                                          var45 = var33;
                                          var33 = "";
                                       }

                                       var32.method4770(var45, var24 + 3, var26, 0, -1);
                                    }
                                 }

                                 if(var10.type == 9) {
                                    if(var10.field2747) {
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
                                       class9.method53(var19, var20, var21, var22, var10.textColor, var10.lineWidth);
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

   @ObfuscatedName("il")
   @ObfuscatedSignature(
      signature = "(IB)Ljava/lang/String;",
      garbageValue = "21"
   )
   static final String method206(int var0) {
      return var0 < 999999999?Integer.toString(var0):"*";
   }
}
