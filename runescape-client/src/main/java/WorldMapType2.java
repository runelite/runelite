import net.runelite.mapping.Export;
import net.runelite.mapping.Hook;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.Opcodes;

@ObfuscatedName("an")
@Implements("WorldMapType2")
public class WorldMapType2 implements WorldMapSectionBase {
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -2095176437
   )
   static int field539;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 1157426607
   )
   int field538;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 543167615
   )
   int field537;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -1910620283
   )
   int field540;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 1533983525
   )
   int field534;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -2001546367
   )
   int field535;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 1387238457
   )
   int field536;

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(III)Z",
      garbageValue = "1359106856"
   )
   public boolean vmethod722(int var1, int var2) {
      return var1 >> 6 == this.field537 && var2 >> 6 == this.field534;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(IIII)Z",
      garbageValue = "-1997246299"
   )
   public boolean vmethod725(int var1, int var2, int var3) {
      return var1 >= this.field538 && var1 < this.field540 + this.field538?var2 >> 6 == this.field535 && var3 >> 6 == this.field536:false;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Las;B)V",
      garbageValue = "125"
   )
   public void vmethod723(WorldMapData var1) {
      if(var1.field473 > this.field537) {
         var1.field473 = this.field537;
      }

      if(var1.field474 < this.field537) {
         var1.field474 = this.field537;
      }

      if(var1.field475 > this.field534) {
         var1.field475 = this.field534;
      }

      if(var1.field476 < this.field534) {
         var1.field476 = this.field534;
      }

   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(IIB)Lhl;",
      garbageValue = "-58"
   )
   public Coordinates vmethod727(int var1, int var2) {
      if(!this.vmethod722(var1, var2)) {
         return null;
      } else {
         int var3 = this.field535 * 64 - this.field537 * 64 + var1;
         int var4 = this.field536 * 64 - this.field534 * 64 + var2;
         return new Coordinates(this.field538, var3, var4);
      }
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(IIII)[I",
      garbageValue = "-170036108"
   )
   public int[] vmethod741(int var1, int var2, int var3) {
      if(!this.vmethod725(var1, var2, var3)) {
         return null;
      } else {
         int[] var4 = new int[]{this.field537 * 64 - this.field535 * 64 + var2, var3 + (this.field534 * 64 - this.field536 * 64)};
         return var4;
      }
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "1"
   )
   void method502() {
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Lfg;B)V",
      garbageValue = "88"
   )
   public void vmethod728(Buffer var1) {
      this.field538 = var1.readUnsignedByte();
      this.field540 = var1.readUnsignedByte();
      this.field535 = var1.readUnsignedShort();
      this.field536 = var1.readUnsignedShort();
      this.field537 = var1.readUnsignedShort();
      this.field534 = var1.readUnsignedShort();
      this.method502();
   }

   @ObfuscatedName("id")
   @ObfuscatedSignature(
      signature = "(Lhj;IIB)V",
      garbageValue = "-77"
   )
   static void method499(Widget var0, int var1, int var2) {
      if(var0.field2645 == 0) {
         var0.relativeX = var0.originalX;
      } else if(var0.field2645 == 1) {
         var0.relativeX = var0.originalX + (var1 - var0.width) / 2;
      } else if(var0.field2645 == 2) {
         var0.relativeX = var1 - var0.width - var0.originalX;
      } else if(var0.field2645 == 3) {
         var0.relativeX = var0.originalX * var1 >> 14;
      } else if(var0.field2645 == 4) {
         var0.relativeX = (var1 - var0.width) / 2 + (var0.originalX * var1 >> 14);
      } else {
         var0.relativeX = var1 - var0.width - (var0.originalX * var1 >> 14);
      }

      if(var0.field2664 == 0) {
         var0.relativeY = var0.originalY;
      } else if(var0.field2664 == 1) {
         var0.relativeY = (var2 - var0.height) / 2 + var0.originalY;
      } else if(var0.field2664 == 2) {
         var0.relativeY = var2 - var0.height - var0.originalY;
      } else if(var0.field2664 == 3) {
         var0.relativeY = var2 * var0.originalY >> 14;
      } else if(var0.field2664 == 4) {
         var0.relativeY = (var2 * var0.originalY >> 14) + (var2 - var0.height) / 2;
      } else {
         var0.relativeY = var2 - var0.height - (var2 * var0.originalY >> 14);
      }

      if(Client.field961 && var0.type == 0) {
         if(var0.relativeX < 0) {
            var0.relativeX = 0;
         } else if(var0.relativeX + var0.width > var1) {
            var0.relativeX = var1 - var0.width;
         }

         if(var0.relativeY < 0) {
            var0.relativeY = 0;
         } else if(var0.height + var0.relativeY > var2) {
            var0.relativeY = var2 - var0.height;
         }
      }

   }

   @ObfuscatedName("if")
   @ObfuscatedSignature(
      signature = "([Lhj;IIIIIIIII)V",
      garbageValue = "-898436456"
   )
   @Export("gameDraw")
   static final void gameDraw(Widget[] var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
      Rasterizer2D.setDrawRegion(var2, var3, var4, var5);
      Graphics3D.method2680();

      for(int var9 = 0; var9 < var0.length; ++var9) {
         Widget var10 = var0[var9];
         if(var10 != null && (var10.parentId == var1 || var1 == -1412584499 && var10 == Client.field1052)) {
            int var11;
            if(var8 == -1) {
               Client.widgetPositionX[Client.field1116] = var10.relativeX + var6;
               Client.widgetPositionY[Client.field1116] = var7 + var10.relativeY;
               Client.widgetBoundsWidth[Client.field1116] = var10.width;
               Client.widgetBoundsHeight[Client.field1116] = var10.height;
               var11 = ++Client.field1116 - 1;
            } else {
               var11 = var8;
            }

            var10.boundsIndex = var11;
            var10.loopCycle = Client.gameCycle;
            if(!var10.hasScript || !Script.method1926(var10)) {
               int var12;
               if(var10.contentType > 0) {
                  var12 = var10.contentType;
                  if(var12 == 324) {
                     if(Client.field1186 == -1) {
                        Client.field1186 = var10.spriteId;
                        Client.field1187 = var10.field2683 * -1;
                     }

                     if(Client.field1179.isFemale) {
                        var10.spriteId = Client.field1186;
                     } else {
                        var10.spriteId = Client.field1187 * -1;
                     }
                  } else if(var12 == 325) {
                     if(Client.field1186 == -1) {
                        Client.field1186 = var10.spriteId;
                        Client.field1187 = var10.field2683 * -1;
                     }

                     if(Client.field1179.isFemale) {
                        var10.spriteId = Client.field1187 * -1;
                     } else {
                        var10.spriteId = Client.field1186;
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
               if(var10 == Client.field1052) {
                  if(var1 != -1412584499 && !var10.field2736) {
                     class31.field457 = var0;
                     GraphicsObject.field1358 = var6;
                     class39.field546 = var7;
                     continue;
                  }

                  if(Client.field1159 && Client.field1091) {
                     var15 = MouseInput.field745;
                     var16 = MouseInput.field746;
                     var15 -= Client.field1088;
                     var16 -= Client.field1089;
                     if(var15 < Client.field1092) {
                        var15 = Client.field1092;
                     }

                     if(var15 + var10.width > Client.field1092 + Client.field1047.width) {
                        var15 = Client.field1092 + Client.field1047.width - var10.width;
                     }

                     if(var16 < Client.field1093) {
                        var16 = Client.field1093;
                     }

                     if(var16 + var10.height > Client.field1093 + Client.field1047.height) {
                        var16 = Client.field1093 + Client.field1047.height - var10.height;
                     }

                     var12 = var15;
                     var13 = var16;
                  }

                  if(!var10.field2736) {
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
                           class20.font_p12full.method4842("Fps:" + GameEngine.FPS, var12 + var10.width, var13, 16776960, -1);
                           var13 += 15;
                           Runtime var42 = Runtime.getRuntime();
                           var20 = (int)((var42.totalMemory() - var42.freeMemory()) / 1024L);
                           var21 = 16776960;
                           if(var20 > '耀' && Client.lowMemory) {
                              var21 = 16711680;
                           }

                           if(var20 > 65536 && !Client.lowMemory) {
                              var21 = 16711680;
                           }

                           class20.font_p12full.method4842("Mem:" + var20 + "k", var12 + var10.width, var13, var21, -1);
                           var13 += 15;
                        }
                        continue;
                     }

                     if(var10.contentType == 1337) {
                        Client.field1029 = var12;
                        Client.field1063 = var13;
                        class175.method3469(var12, var13, var10.width, var10.height);
                        Client.field1118[var10.boundsIndex] = true;
                        Rasterizer2D.setDrawRegion(var2, var3, var4, var5);
                        continue;
                     }

                     if(var10.contentType == 1338) {
                        ClanMember.method1193(var10, var12, var13, var11);
                        Rasterizer2D.setDrawRegion(var2, var3, var4, var5);
                        continue;
                     }

                     if(var10.contentType == 1339) {
                        class1.method1(var10, var12, var13, var11);
                        Rasterizer2D.setDrawRegion(var2, var3, var4, var5);
                        continue;
                     }

                     if(var10.contentType == 1400) {
                        GameObject.renderOverview.extractWorldmap(var12, var13, var10.width, var10.height, Client.gameCycle);
                     }

                     if(var10.contentType == 1401) {
                        GameObject.renderOverview.extractData(var12, var13, var10.width, var10.height);
                     }
                  }

                  if(var10.type == 0) {
                     if(!var10.hasScript && Script.method1926(var10) && var10 != class27.field403) {
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
                        BaseVarType.method13(var30.id, var15, var16, var17, var18, var12, var13, var11);
                     }

                     Rasterizer2D.setDrawRegion(var2, var3, var4, var5);
                     Graphics3D.method2680();
                  }

                  if(Client.isResized || Client.field1034[var11] || Client.gameDrawingMode > 1) {
                     int var23;
                     int var24;
                     if(var10.type == 0 && !var10.hasScript && var10.scrollHeight > var10.height) {
                        var19 = var12 + var10.width;
                        var20 = var10.scrollY;
                        var21 = var10.height;
                        var22 = var10.scrollHeight;
                        class29.field432[0].method5147(var19, var13);
                        class29.field432[1].method5147(var19, var21 + var13 - 16);
                        Rasterizer2D.method5129(var19, var13 + 16, 16, var21 - 32, Client.field989);
                        var23 = var21 * (var21 - 32) / var22;
                        if(var23 < 8) {
                           var23 = 8;
                        }

                        var24 = var20 * (var21 - 32 - var23) / (var22 - var21);
                        Rasterizer2D.method5129(var19, var24 + var13 + 16, 16, var23, Client.field990);
                        Rasterizer2D.method5128(var19, var24 + var13 + 16, var23, Client.field992);
                        Rasterizer2D.method5128(var19 + 1, var24 + var13 + 16, var23, Client.field992);
                        Rasterizer2D.method5063(var19, var13 + var24 + 16, 16, Client.field992);
                        Rasterizer2D.method5063(var19, var13 + var24 + 17, 16, Client.field992);
                        Rasterizer2D.method5128(var19 + 15, var24 + var13 + 16, var23, Client.field1072);
                        Rasterizer2D.method5128(var19 + 14, var24 + var13 + 17, var23 - 1, Client.field1072);
                        Rasterizer2D.method5063(var19, var24 + var13 + var23 + 15, 16, Client.field1072);
                        Rasterizer2D.method5063(var19 + 1, var24 + var13 + var23 + 14, 15, Client.field1072);
                     }

                     if(var10.type != 1) {
                        int var25;
                        int var26;
                        if(var10.type == 2) {
                           var19 = 0;

                           for(var20 = 0; var20 < var10.field2670; ++var20) {
                              for(var21 = 0; var21 < var10.originalWidth; ++var21) {
                                 var22 = var12 + var21 * (var10.paddingX + 32);
                                 var23 = var13 + var20 * (var10.paddingY + 32);
                                 if(var19 < 20) {
                                    var22 += var10.xSprites[var19];
                                    var23 += var10.field2727[var19];
                                 }

                                 if(var10.itemIds[var19] <= 0) {
                                    if(var10.field2728 != null && var19 < 20) {
                                       SpritePixels var45 = var10.method4115(var19);
                                       if(var45 != null) {
                                          var45.method5172(var22, var23);
                                       } else if(Widget.field2719) {
                                          class25.method172(var10);
                                       }
                                    }
                                 } else {
                                    boolean var37 = false;
                                    boolean var38 = false;
                                    var26 = var10.itemIds[var19] - 1;
                                    if(var22 + 32 > var2 && var22 < var4 && var23 + 32 > var3 && var23 < var5 || var10 == ClanMember.field915 && var19 == Client.field1025) {
                                       SpritePixels var27;
                                       if(Client.itemSelectionState == 1 && var19 == class39.selectedItemIndex && var10.id == class25.field371) {
                                          var27 = class23.createSprite(var26, var10.itemQuantities[var19], 2, 0, 2, false);
                                       } else {
                                          var27 = class23.createSprite(var26, var10.itemQuantities[var19], 1, 3153952, 2, false);
                                       }

                                       if(var27 != null) {
                                          if(var10 == ClanMember.field915 && var19 == Client.field1025) {
                                             var24 = MouseInput.field745 - Client.field1026;
                                             var25 = MouseInput.field746 - Client.field1135;
                                             if(var24 < 5 && var24 > -5) {
                                                var24 = 0;
                                             }

                                             if(var25 < 5 && var25 > -5) {
                                                var25 = 0;
                                             }

                                             if(Client.field1127 < 5) {
                                                var24 = 0;
                                                var25 = 0;
                                             }

                                             var27.method5181(var22 + var24, var23 + var25, 128);
                                             if(var1 != -1) {
                                                Widget var28 = var0[var1 & '\uffff'];
                                                int var29;
                                                if(var25 + var23 < Rasterizer2D.drawingAreaTop && var28.scrollY > 0) {
                                                   var29 = (Rasterizer2D.drawingAreaTop - var23 - var25) * Client.field1122 / 3;
                                                   if(var29 > Client.field1122 * 10) {
                                                      var29 = Client.field1122 * 10;
                                                   }

                                                   if(var29 > var28.scrollY) {
                                                      var29 = var28.scrollY;
                                                   }

                                                   var28.scrollY -= var29;
                                                   Client.field1135 += var29;
                                                   class25.method172(var28);
                                                }

                                                if(var23 + var25 + 32 > Rasterizer2D.drawingAreaRight && var28.scrollY < var28.scrollHeight - var28.height) {
                                                   var29 = (var23 + var25 + 32 - Rasterizer2D.drawingAreaRight) * Client.field1122 / 3;
                                                   if(var29 > Client.field1122 * 10) {
                                                      var29 = Client.field1122 * 10;
                                                   }

                                                   if(var29 > var28.scrollHeight - var28.height - var28.scrollY) {
                                                      var29 = var28.scrollHeight - var28.height - var28.scrollY;
                                                   }

                                                   var28.scrollY += var29;
                                                   Client.field1135 -= var29;
                                                   class25.method172(var28);
                                                }
                                             }
                                          } else if(var10 == SceneTilePaint.field2031 && var19 == Client.field1024) {
                                             var27.method5181(var22, var23, 128);
                                          } else {
                                             var27.method5172(var22, var23);
                                          }
                                       } else {
                                          class25.method172(var10);
                                       }
                                    }
                                 }

                                 ++var19;
                              }
                           }
                        } else if(var10.type == 3) {
                           if(ItemContainer.method1129(var10)) {
                              var19 = var10.field2779;
                              if(var10 == class27.field403 && var10.field2686 != 0) {
                                 var19 = var10.field2686;
                              }
                           } else {
                              var19 = var10.textColor;
                              if(var10 == class27.field403 && var10.field2685 != 0) {
                                 var19 = var10.field2685;
                              }
                           }

                           if(var10.field2650) {
                              switch(var10.field2688.field3785) {
                              case 1:
                                 Rasterizer2D.method5055(var12, var13, var10.width, var10.height, var10.textColor, var10.field2779, 256 - (var10.opacity & 255), 256 - (var10.field2690 & 255));
                                 break;
                              case 2:
                                 Rasterizer2D.method5056(var12, var13, var10.width, var10.height, var10.textColor, var10.field2779, 256 - (var10.opacity & 255), 256 - (var10.field2690 & 255));
                                 break;
                              case 3:
                                 Rasterizer2D.method5057(var12, var13, var10.width, var10.height, var10.textColor, var10.field2779, 256 - (var10.opacity & 255), 256 - (var10.field2690 & 255));
                                 break;
                              case 4:
                                 Rasterizer2D.method5058(var12, var13, var10.width, var10.height, var10.textColor, var10.field2779, 256 - (var10.opacity & 255), 256 - (var10.field2690 & 255));
                                 break;
                              default:
                                 if(var14 == 0) {
                                    Rasterizer2D.method5129(var12, var13, var10.width, var10.height, var19);
                                 } else {
                                    Rasterizer2D.fillRectangle(var12, var13, var10.width, var10.height, var19, 256 - (var14 & 255));
                                 }
                              }
                           } else if(var14 == 0) {
                              Rasterizer2D.drawRectangle(var12, var13, var10.width, var10.height, var19);
                           } else {
                              Rasterizer2D.method5062(var12, var13, var10.width, var10.height, var19, 256 - (var14 & 255));
                           }
                        } else {
                           Font var39;
                           if(var10.type == 4) {
                              var39 = var10.method4122();
                              if(var39 == null) {
                                 if(Widget.field2719) {
                                    class25.method172(var10);
                                 }
                              } else {
                                 String var43 = var10.text;
                                 if(ItemContainer.method1129(var10)) {
                                    var20 = var10.field2779;
                                    if(var10 == class27.field403 && var10.field2686 != 0) {
                                       var20 = var10.field2686;
                                    }

                                    if(var10.field2730.length() > 0) {
                                       var43 = var10.field2730;
                                    }
                                 } else {
                                    var20 = var10.textColor;
                                    if(var10 == class27.field403 && var10.field2685 != 0) {
                                       var20 = var10.field2685;
                                    }
                                 }

                                 if(var10.hasScript && var10.itemId != -1) {
                                    ItemComposition var46 = class46.getItemDefinition(var10.itemId);
                                    var43 = var46.name;
                                    if(var43 == null) {
                                       var43 = "null";
                                    }

                                    if((var46.isStackable == 1 || var10.itemQuantity != 1) && var10.itemQuantity != -1) {
                                       var43 = class60.getColTags(16748608) + var43 + "</col>" + " " + 'x' + class20.method147(var10.itemQuantity);
                                    }
                                 }

                                 if(var10 == Client.field1077) {
                                    Object var10000 = null;
                                    var43 = "Please wait...";
                                    var20 = var10.textColor;
                                 }

                                 if(!var10.hasScript) {
                                    var43 = class222.method4189(var43, var10);
                                 }

                                 var39.method4844(var43, var12, var13, var10.width, var10.height, var20, var10.textShadowed?0:-1, var10.field2721, var10.field2722, var10.field2720);
                              }
                           } else if(var10.type == 5) {
                              SpritePixels var40;
                              if(!var10.hasScript) {
                                 var40 = var10.method4152(ItemContainer.method1129(var10));
                                 if(var40 != null) {
                                    var40.method5172(var12, var13);
                                 } else if(Widget.field2719) {
                                    class25.method172(var10);
                                 }
                              } else {
                                 if(var10.itemId != -1) {
                                    var40 = class23.createSprite(var10.itemId, var10.itemQuantity, var10.borderThickness, var10.sprite2, var10.field2716, false);
                                 } else {
                                    var40 = var10.method4152(false);
                                 }

                                 if(var40 == null) {
                                    if(Widget.field2719) {
                                       class25.method172(var10);
                                    }
                                 } else {
                                    var20 = var40.maxWidth;
                                    var21 = var40.maxHeight;
                                    if(!var10.field2696) {
                                       var22 = var10.width * 4096 / var20;
                                       if(var10.textureId != 0) {
                                          var40.method5188(var10.width / 2 + var12, var10.height / 2 + var13, var10.textureId, var22);
                                       } else if(var14 != 0) {
                                          var40.method5183(var12, var13, var10.width, var10.height, 256 - (var14 & 255));
                                       } else if(var20 == var10.width && var21 == var10.height) {
                                          var40.method5172(var12, var13);
                                       } else {
                                          var40.method5194(var12, var13, var10.width, var10.height);
                                       }
                                    } else {
                                       Rasterizer2D.setInnerDrawRegion(var12, var13, var12 + var10.width, var13 + var10.height);
                                       var22 = (var20 - 1 + var10.width) / var20;
                                       var23 = (var21 - 1 + var10.height) / var21;

                                       for(var24 = 0; var24 < var22; ++var24) {
                                          for(var25 = 0; var25 < var23; ++var25) {
                                             if(var10.textureId != 0) {
                                                var40.method5188(var20 / 2 + var12 + var24 * var20, var21 / 2 + var13 + var21 * var25, var10.textureId, 4096);
                                             } else if(var14 != 0) {
                                                var40.method5181(var12 + var24 * var20, var13 + var21 * var25, 256 - (var14 & 255));
                                             } else {
                                                var40.method5172(var12 + var20 * var24, var13 + var21 * var25);
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
                                 boolean var36 = ItemContainer.method1129(var10);
                                 if(var36) {
                                    var20 = var10.field2706;
                                 } else {
                                    var20 = var10.field2649;
                                 }

                                 Model var41 = null;
                                 var22 = 0;
                                 if(var10.itemId != -1) {
                                    var34 = class46.getItemDefinition(var10.itemId);
                                    if(var34 != null) {
                                       var34 = var34.method4714(var10.itemQuantity);
                                       var41 = var34.getModel(1);
                                       if(var41 != null) {
                                          var41.method2594();
                                          var22 = var41.modelHeight / 2;
                                       } else {
                                          class25.method172(var10);
                                       }
                                    }
                                 } else if(var10.modelType == 5) {
                                    if(var10.modelId == 0) {
                                       var41 = Client.field1179.method4072((Sequence)null, -1, (Sequence)null, -1);
                                    } else {
                                       var41 = AbstractByteBuffer.localPlayer.getModel();
                                    }
                                 } else if(var20 == -1) {
                                    var41 = var10.method4146((Sequence)null, -1, var36, AbstractByteBuffer.localPlayer.composition);
                                    if(var41 == null && Widget.field2719) {
                                       class25.method172(var10);
                                    }
                                 } else {
                                    Sequence var47 = class204.getAnimation(var20);
                                    var41 = var10.method4146(var47, var10.field2776, var36, AbstractByteBuffer.localPlayer.composition);
                                    if(var41 == null && Widget.field2719) {
                                       class25.method172(var10);
                                    }
                                 }

                                 Graphics3D.method2682(var10.width / 2 + var12, var10.height / 2 + var13);
                                 var23 = Graphics3D.SINE[var10.rotationX] * var10.modelZoom >> 16;
                                 var24 = Graphics3D.COSINE[var10.rotationX] * var10.modelZoom >> 16;
                                 if(var41 != null) {
                                    if(!var10.hasScript) {
                                       var41.method2607(0, var10.rotationZ, 0, var10.rotationX, 0, var23, var24);
                                    } else {
                                       var41.method2594();
                                       if(var10.field2715) {
                                          var41.method2608(0, var10.rotationZ, var10.rotationY, var10.rotationX, var10.field2707, var22 + var23 + var10.field2708, var24 + var10.field2708, var10.modelZoom);
                                       } else {
                                          var41.method2607(0, var10.rotationZ, var10.rotationY, var10.rotationX, var10.field2707, var22 + var23 + var10.field2708, var24 + var10.field2708);
                                       }
                                    }
                                 }

                                 Graphics3D.method2678();
                              } else {
                                 if(var10.type == 7) {
                                    var39 = var10.method4122();
                                    if(var39 == null) {
                                       if(Widget.field2719) {
                                          class25.method172(var10);
                                       }
                                       continue;
                                    }

                                    var20 = 0;

                                    for(var21 = 0; var21 < var10.field2670; ++var21) {
                                       for(var22 = 0; var22 < var10.originalWidth; ++var22) {
                                          if(var10.itemIds[var20] > 0) {
                                             var34 = class46.getItemDefinition(var10.itemIds[var20] - 1);
                                             String var33;
                                             if(var34.isStackable != 1 && var10.itemQuantities[var20] == 1) {
                                                var33 = class60.getColTags(16748608) + var34.name + "</col>";
                                             } else {
                                                var33 = class60.getColTags(16748608) + var34.name + "</col>" + " " + 'x' + class20.method147(var10.itemQuantities[var20]);
                                             }

                                             var25 = var12 + var22 * (var10.paddingX + 115);
                                             var26 = (var10.paddingY + 12) * var21 + var13;
                                             if(var10.field2721 == 0) {
                                                var39.method4840(var33, var25, var26, var10.textColor, var10.textShadowed?0:-1);
                                             } else if(var10.field2721 == 1) {
                                                var39.method4843(var33, var10.width / 2 + var25, var26, var10.textColor, var10.textShadowed?0:-1);
                                             } else {
                                                var39.method4842(var33, var25 + var10.width - 1, var26, var10.textColor, var10.textShadowed?0:-1);
                                             }
                                          }

                                          ++var20;
                                       }
                                    }
                                 }

                                 if(var10.type == 8 && var10 == class48.field635 && Client.field1064 == Client.field1065) {
                                    var19 = 0;
                                    var20 = 0;
                                    Font var31 = class20.font_p12full;
                                    String var32 = var10.text;

                                    String var44;
                                    for(var32 = class222.method4189(var32, var10); var32.length() > 0; var20 = var20 + var31.verticalSpace + 1) {
                                       var24 = var32.indexOf("<br>");
                                       if(var24 != -1) {
                                          var44 = var32.substring(0, var24);
                                          var32 = var32.substring(var24 + 4);
                                       } else {
                                          var44 = var32;
                                          var32 = "";
                                       }

                                       var25 = var31.method4918(var44);
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

                                    if(var25 + var20 > var5) {
                                       var25 = var5 - var20;
                                    }

                                    Rasterizer2D.method5129(var24, var25, var19, var20, 16777120);
                                    Rasterizer2D.drawRectangle(var24, var25, var19, var20, 0);
                                    var32 = var10.text;
                                    var26 = var25 + var31.verticalSpace + 2;

                                    for(var32 = class222.method4189(var32, var10); var32.length() > 0; var26 = var26 + var31.verticalSpace + 1) {
                                       int var35 = var32.indexOf("<br>");
                                       if(var35 != -1) {
                                          var44 = var32.substring(0, var35);
                                          var32 = var32.substring(var35 + 4);
                                       } else {
                                          var44 = var32;
                                          var32 = "";
                                       }

                                       var31.method4840(var44, var24 + 3, var26, 0, -1);
                                    }
                                 }

                                 if(var10.type == 9) {
                                    if(var10.field2723) {
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

                                    if(var10.field2702 == 1) {
                                       Rasterizer2D.drawLine(var19, var20, var21, var22, var10.textColor);
                                    } else {
                                       ScriptState.method1123(var19, var20, var21, var22, var10.textColor, var10.field2702);
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

   @ObfuscatedName("ko")
   @ObfuscatedSignature(
      signature = "([BIS)V",
      garbageValue = "-273"
   )
   static void method523(byte[] var0, int var1) {
      if(Client.field981 == null) {
         Client.field981 = new byte[24];
      }

      class183.method3548(var0, var1, Client.field981, 0, 24);
   }

   @ObfuscatedName("kr")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "-1361581980"
   )
   static final void method524(String var0) {
      if(var0 != null) {
         if((Client.friendCount < 200 || Client.field1035 == 1) && Client.friendCount < 400) {
            String var1 = class207.method3989(var0, class5.field42);
            if(var1 != null) {
               int var2;
               String var4;
               String var5;
               for(var2 = 0; var2 < Client.friendCount; ++var2) {
                  Friend var3 = Client.friends[var2];
                  var4 = class207.method3989(var3.name, class5.field42);
                  if(var4 != null && var4.equals(var1)) {
                     MessageNode.sendGameMessage(30, "", var0 + " is already on your friend list");
                     return;
                  }

                  if(var3.previousName != null) {
                     var5 = class207.method3989(var3.previousName, class5.field42);
                     if(var5 != null && var5.equals(var1)) {
                        MessageNode.sendGameMessage(30, "", var0 + " is already on your friend list");
                        return;
                     }
                  }
               }

               for(var2 = 0; var2 < Client.ignoreCount; ++var2) {
                  Ignore var6 = Client.ignores[var2];
                  var4 = class207.method3989(var6.name, class5.field42);
                  if(var4 != null && var4.equals(var1)) {
                     MessageNode.sendGameMessage(30, "", "Please remove " + var0 + " from your ignore list first");
                     return;
                  }

                  if(var6.previousName != null) {
                     var5 = class207.method3989(var6.previousName, class5.field42);
                     if(var5 != null && var5.equals(var1)) {
                        MessageNode.sendGameMessage(30, "", "Please remove " + var0 + " from your ignore list first");
                        return;
                     }
                  }
               }

               if(class207.method3989(AbstractByteBuffer.localPlayer.name, class5.field42).equals(var1)) {
                  MessageNode.sendGameMessage(30, "", "You can\'t add yourself to your own friend list");
               } else {
                  Client.secretPacketBuffer1.putOpcode(Opcodes.PACKET_CLIENT_ADD_FRIEND);
                  Client.secretPacketBuffer1.putByte(class162.getLength(var0));
                  Client.secretPacketBuffer1.putString(var0);
               }
            }
         } else {
            MessageNode.sendGameMessage(30, "", "Your friend list is full. Max of 200 for free users, and 400 for members");
         }
      }
   }

   @ObfuscatedName("hm")
   @ObfuscatedSignature(
      signature = "(IIIIIIII)V",
      garbageValue = "581697948"
   )
   static final void method519(int var0, int var1, int var2, int var3, int var4, int var5, int var6) {
      if(var2 >= 1 && var3 >= 1 && var2 <= 102 && var3 <= 102) {
         if(Client.lowMemory && var0 != class5.plane) {
            return;
         }

         int var7 = 0;
         boolean var8 = true;
         boolean var9 = false;
         boolean var10 = false;
         if(var1 == 0) {
            var7 = class8.region.method2848(var0, var2, var3);
         }

         if(var1 == 1) {
            var7 = class8.region.method2784(var0, var2, var3);
         }

         if(var1 == 2) {
            var7 = class8.region.method2907(var0, var2, var3);
         }

         if(var1 == 3) {
            var7 = class8.region.method2841(var0, var2, var3);
         }

         int var11;
         if(var7 != 0) {
            var11 = class8.region.method2801(var0, var2, var3, var7);
            int var13 = var7 >> 14 & 32767;
            int var14 = var11 & 31;
            int var15 = var11 >> 6 & 3;
            ObjectComposition var12;
            if(var1 == 0) {
               class8.region.method2864(var0, var2, var3);
               var12 = Occluder.getObjectDefinition(var13);
               if(var12.interactType != 0) {
                  Client.collisionMaps[var0].removeWall(var2, var3, var14, var15, var12.field3456);
               }
            }

            if(var1 == 1) {
               class8.region.method2775(var0, var2, var3);
            }

            if(var1 == 2) {
               class8.region.method2776(var0, var2, var3);
               var12 = Occluder.getObjectDefinition(var13);
               if(var2 + var12.sizeX > 103 || var3 + var12.sizeX > 103 || var2 + var12.sizeY > 103 || var3 + var12.sizeY > 103) {
                  return;
               }

               if(var12.interactType != 0) {
                  Client.collisionMaps[var0].removeObject(var2, var3, var12.sizeX, var12.sizeY, var15, var12.field3456);
               }
            }

            if(var1 == 3) {
               class8.region.method2777(var0, var2, var3);
               var12 = Occluder.getObjectDefinition(var13);
               if(var12.interactType == 1) {
                  Client.collisionMaps[var0].unblock(var2, var3);
               }
            }
         }

         if(var4 >= 0) {
            var11 = var0;
            if(var0 < 3 && (class61.tileSettings[1][var2][var3] & 2) == 2) {
               var11 = var0 + 1;
            }

            class17.method129(var0, var11, var2, var3, var4, var5, var6, class8.region, Client.collisionMaps[var0]);
         }
      }

   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V",
      garbageValue = "-1530750715"
   )
   @Export("addChatMessage")
   @Hook("addChatMessage")
   static void addChatMessage(int var0, String var1, String var2, String var3) {
      ChatLineBuffer var4 = (ChatLineBuffer)class96.chatLineMap.get(Integer.valueOf(var0));
      if(var4 == null) {
         var4 = new ChatLineBuffer();
         class96.chatLineMap.put(Integer.valueOf(var0), var4);
      }

      MessageNode var5 = var4.addMessage(var0, var1, var2, var3);
      class96.field1508.put(var5, (long)var5.id);
      class96.field1509.method3777(var5);
      Client.chatCycle = Client.cycleCntr;
   }
}
