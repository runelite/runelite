import java.io.File;
import java.io.RandomAccessFile;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("az")
@Implements("DevicePcmPlayerProvider")
public class DevicePcmPlayerProvider implements PcmPlayerProvider {
   @ObfuscatedName("fu")
   @ObfuscatedSignature(
      signature = "Lkk;"
   )
   @Export("fontPlain12")
   static Font fontPlain12;
   @ObfuscatedName("jf")
   @ObfuscatedSignature(
      signature = "Lho;"
   )
   @Export("dragInventoryWidget")
   static Widget dragInventoryWidget;

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(B)Lco;",
      garbageValue = "-49"
   )
   public PcmPlayer player() {
      return new DevicePcmPlayer();
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(Ljava/io/File;ZI)Z",
      garbageValue = "248065919"
   )
   public static boolean method847(File var0, boolean var1) {
      try {
         RandomAccessFile var2 = new RandomAccessFile(var0, "rw");
         int var3 = var2.read();
         var2.seek(0L);
         var2.write(var3);
         var2.seek(0L);
         var2.close();
         if(var1) {
            var0.delete();
         }

         return true;
      } catch (Exception var4) {
         return false;
      }
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1746647997"
   )
   public static void method841() {
      KitDefinition.KitDefinition_cached.clear();
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "([BB)V",
      garbageValue = "-9"
   )
   @Export("decodeSprite")
   static void decodeSprite(byte[] var0) {
      Buffer var1 = new Buffer(var0);
      var1.index = var0.length - 2;
      class328.indexedSpriteCount = var1.__ag_302();
      class328.indexedSpriteOffsetXs = new int[class328.indexedSpriteCount];
      class328.indexedSpriteOffsetYs = new int[class328.indexedSpriteCount];
      VarbitDefinition.indexedSpriteWidths = new int[class328.indexedSpriteCount];
      SecureRandomCallable.indexedSpriteHeights = new int[class328.indexedSpriteCount];
      class328.spritePixels = new byte[class328.indexedSpriteCount][];
      var1.index = var0.length - 7 - class328.indexedSpriteCount * 8;
      class328.indexedSpriteWidth = var1.__ag_302();
      class328.indexedSpriteHeight = var1.__ag_302();
      int var2 = (var1.readUnsignedByte() & 255) + 1;

      int var3;
      for(var3 = 0; var3 < class328.indexedSpriteCount; ++var3) {
         class328.indexedSpriteOffsetXs[var3] = var1.__ag_302();
      }

      for(var3 = 0; var3 < class328.indexedSpriteCount; ++var3) {
         class328.indexedSpriteOffsetYs[var3] = var1.__ag_302();
      }

      for(var3 = 0; var3 < class328.indexedSpriteCount; ++var3) {
         VarbitDefinition.indexedSpriteWidths[var3] = var1.__ag_302();
      }

      for(var3 = 0; var3 < class328.indexedSpriteCount; ++var3) {
         SecureRandomCallable.indexedSpriteHeights[var3] = var1.__ag_302();
      }

      var1.index = var0.length - 7 - class328.indexedSpriteCount * 8 - (var2 - 1) * 3;
      class328.indexedSpritePalette = new int[var2];

      for(var3 = 1; var3 < var2; ++var3) {
         class328.indexedSpritePalette[var3] = var1.readMedium();
         if(class328.indexedSpritePalette[var3] == 0) {
            class328.indexedSpritePalette[var3] = 1;
         }
      }

      var1.index = 0;

      for(var3 = 0; var3 < class328.indexedSpriteCount; ++var3) {
         int var4 = VarbitDefinition.indexedSpriteWidths[var3];
         int var5 = SecureRandomCallable.indexedSpriteHeights[var3];
         int var6 = var4 * var5;
         byte[] var7 = new byte[var6];
         class328.spritePixels[var3] = var7;
         int var8 = var1.readUnsignedByte();
         int var9;
         if(var8 == 0) {
            for(var9 = 0; var9 < var6; ++var9) {
               var7[var9] = var1.readByte();
            }
         } else if(var8 == 1) {
            for(var9 = 0; var9 < var4; ++var9) {
               for(int var10 = 0; var10 < var5; ++var10) {
                  var7[var9 + var10 * var4] = var1.readByte();
               }
            }
         }
      }

   }

   @ObfuscatedName("ga")
   @ObfuscatedSignature(
      signature = "(Lbz;II)V",
      garbageValue = "-1590224882"
   )
   static final void method840(Actor var0, int var1) {
      WorldMapLabel.worldToScreen(var0.x, var0.y, var1);
   }

   @ObfuscatedName("ir")
   @ObfuscatedSignature(
      signature = "([Lho;IIIIIIIII)V",
      garbageValue = "-1516599170"
   )
   @Export("drawWidgetGroup")
   static final void drawWidgetGroup(Widget[] var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
      Rasterizer2D.Rasterizer2D_setClip(var2, var3, var4, var5);
      Rasterizer3D.Rasterizer3D_method1();

      for(int var9 = 0; var9 < var0.length; ++var9) {
         Widget var10 = var0[var9];
         if(var10 != null && (var10.parentId == var1 || var1 == -1412584499 && var10 == Client.clickedWidget)) {
            int var11;
            if(var8 == -1) {
               Client.rootWidgetXs[Client.rootWidgetCount] = var10.x + var6;
               Client.rootWidgetYs[Client.rootWidgetCount] = var7 + var10.y;
               Client.rootWidgetWidths[Client.rootWidgetCount] = var10.width;
               Client.rootWidgetHeights[Client.rootWidgetCount] = var10.height;
               var11 = ++Client.rootWidgetCount - 1;
            } else {
               var11 = var8;
            }

            var10.rootIndex = var11;
            var10.cycle = Client.cycle;
            if(!var10.isIf3 || !PacketBufferNode.method3673(var10)) {
               if(var10.contentType > 0) {
                  class15.method186(var10);
               }

               int var12 = var10.x + var6;
               int var13 = var7 + var10.y;
               int var14 = var10.transparency;
               int var15;
               int var16;
               if(var10 == Client.clickedWidget) {
                  if(var1 != -1412584499 && !var10.isScrollBar) {
                     class279.__jx_ne = var0;
                     class54.__bs_nb = var6;
                     class157.__fw_nm = var7;
                     continue;
                  }

                  if(Client.isDraggingWidget && Client.__client_nn) {
                     var15 = MouseHandler.MouseHandler_x;
                     var16 = MouseHandler.MouseHandler_y;
                     var15 -= Client.widgetClickX;
                     var16 -= Client.widgetClickY;
                     if(var15 < Client.__client_nw) {
                        var15 = Client.__client_nw;
                     }

                     if(var15 + var10.width > Client.__client_nw + Client.clickedWidgetParent.width) {
                        var15 = Client.__client_nw + Client.clickedWidgetParent.width - var10.width;
                     }

                     if(var16 < Client.__client_nl) {
                        var16 = Client.__client_nl;
                     }

                     if(var16 + var10.height > Client.__client_nl + Client.clickedWidgetParent.height) {
                        var16 = Client.__client_nl + Client.clickedWidgetParent.height - var10.height;
                     }

                     var12 = var15;
                     var13 = var16;
                  }

                  if(!var10.isScrollBar) {
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
                  var30 = var12 + var10.width;
                  var20 = var13 + var10.height;
                  var15 = var12 > var2?var12:var2;
                  var16 = var13 > var3?var13:var3;
                  var17 = var30 < var4?var30:var4;
                  var18 = var20 < var5?var20:var5;
               }

               if(!var10.isIf3 || var15 < var17 && var16 < var18) {
                  if(var10.contentType != 0) {
                     if(var10.contentType == 1336) {
                        if(Client.displayFps) {
                           var13 += 15;
                           fontPlain12.drawRightAligned("Fps:" + GameShell.fps, var12 + var10.width, var13, 16776960, -1);
                           var13 += 15;
                           Runtime var38 = Runtime.getRuntime();
                           var20 = (int)((var38.totalMemory() - var38.freeMemory()) / 1024L);
                           var21 = 16776960;
                           if(var20 > 327680 && !Client.isLowDetail) {
                              var21 = 16711680;
                           }

                           fontPlain12.drawRightAligned("Mem:" + var20 + "k", var12 + var10.width, var13, var21, -1);
                           var13 += 15;
                        }
                        continue;
                     }

                     if(var10.contentType == 1337) {
                        Client.__client_lq = var12;
                        Client.__client_ln = var13;
                        class40.drawEntities(var12, var13, var10.width, var10.height);
                        Client.__client_od[var10.rootIndex] = true;
                        Rasterizer2D.Rasterizer2D_setClip(var2, var3, var4, var5);
                        continue;
                     }

                     if(var10.contentType == 1338) {
                        MouseRecorder.method1189(var10, var12, var13, var11);
                        Rasterizer2D.Rasterizer2D_setClip(var2, var3, var4, var5);
                        continue;
                     }

                     if(var10.contentType == 1339) {
                        class22.method296(var10, var12, var13, var11);
                        Rasterizer2D.Rasterizer2D_setClip(var2, var3, var4, var5);
                        continue;
                     }

                     if(var10.contentType == 1400) {
                        class60.worldMap0.draw(var12, var13, var10.width, var10.height, Client.cycle);
                     }

                     if(var10.contentType == 1401) {
                        class60.worldMap0.drawOverview(var12, var13, var10.width, var10.height);
                     }

                     if(var10.contentType == 1402) {
                        class16.field85.method1782(var12, Client.cycle);
                     }
                  }

                  if(var10.type == 0) {
                     if(!var10.isIf3 && PacketBufferNode.method3673(var10) && var10 != Clock.mousedOverWidgetIf1) {
                        continue;
                     }

                     if(!var10.isIf3) {
                        if(var10.scrollY > var10.scrollHeight - var10.height) {
                           var10.scrollY = var10.scrollHeight - var10.height;
                        }

                        if(var10.scrollY < 0) {
                           var10.scrollY = 0;
                        }
                     }

                     drawWidgetGroup(var0, var10.id, var15, var16, var17, var18, var12 - var10.scrollX, var13 - var10.scrollY, var11);
                     if(var10.children != null) {
                        drawWidgetGroup(var10.children, var10.id, var15, var16, var17, var18, var12 - var10.scrollX, var13 - var10.scrollY, var11);
                     }

                     WidgetGroupParent var19 = (WidgetGroupParent)Client.widgetGroupParents.get((long)var10.id);
                     if(var19 != null) {
                        Interpreter.drawWidgets(var19.group, var15, var16, var17, var18, var12, var13, var11);
                     }

                     Rasterizer2D.Rasterizer2D_setClip(var2, var3, var4, var5);
                     Rasterizer3D.Rasterizer3D_method1();
                  }

                  if(Client.isResizable || Client.__client_oq[var11] || Client.gameDrawingMode > 1) {
                     if(var10.type == 0 && !var10.isIf3 && var10.scrollHeight > var10.height) {
                        class11.method148(var12 + var10.width, var13, var10.scrollY, var10.height, var10.scrollHeight);
                     }

                     if(var10.type != 1) {
                        int var23;
                        int var24;
                        int var25;
                        int var26;
                        if(var10.type == 2) {
                           var30 = 0;

                           for(var20 = 0; var20 < var10.rawHeight; ++var20) {
                              for(var21 = 0; var21 < var10.rawWidth; ++var21) {
                                 var22 = var12 + var21 * (var10.paddingX + 32);
                                 var23 = var13 + var20 * (var10.paddingY + 32);
                                 if(var30 < 20) {
                                    var22 += var10.inventoryXOffsets[var30];
                                    var23 += var10.inventoryYOffsets[var30];
                                 }

                                 if(var10.itemIds[var30] <= 0) {
                                    if(var10.inventorySprites != null && var30 < 20) {
                                       Sprite var42 = var10.getInventorySprite(var30);
                                       if(var42 != null) {
                                          var42.drawAt2(var22, var23);
                                       } else if(Widget.__ho_j) {
                                          class22.method295(var10);
                                       }
                                    }
                                 } else {
                                    boolean var39 = false;
                                    boolean var40 = false;
                                    var26 = var10.itemIds[var30] - 1;
                                    if(var22 + 32 > var2 && var22 < var4 && var23 + 32 > var3 && var23 < var5 || var10 == dragInventoryWidget && var30 == Client.dragItemSlotSource) {
                                       Sprite var27;
                                       if(Client.isItemSelected == 1 && var30 == HealthBarDefinition.selectedItemSlot && var10.id == ServerPacket.selectedItemWidget) {
                                          var27 = class226.getItemSprite(var26, var10.itemQuantities[var30], 2, 0, 2, false);
                                       } else {
                                          var27 = class226.getItemSprite(var26, var10.itemQuantities[var30], 1, 3153952, 2, false);
                                       }

                                       if(var27 != null) {
                                          if(var10 == dragInventoryWidget && var30 == Client.dragItemSlotSource) {
                                             var24 = MouseHandler.MouseHandler_x - Client.__client_ja;
                                             var25 = MouseHandler.MouseHandler_y - Client.__client_je;
                                             if(var24 < 5 && var24 > -5) {
                                                var24 = 0;
                                             }

                                             if(var25 < 5 && var25 > -5) {
                                                var25 = 0;
                                             }

                                             if(Client.itemDragDuration < 5) {
                                                var24 = 0;
                                                var25 = 0;
                                             }

                                             var27.__h_508(var22 + var24, var23 + var25, 128);
                                             if(var1 != -1) {
                                                Widget var28 = var0[var1 & 65535];
                                                int var29;
                                                if(var23 + var25 < Rasterizer2D.Rasterizer2D_yClipStart && var28.scrollY > 0) {
                                                   var29 = (Rasterizer2D.Rasterizer2D_yClipStart - var23 - var25) * Client.__client_gy / 3;
                                                   if(var29 > Client.__client_gy * 10) {
                                                      var29 = Client.__client_gy * 10;
                                                   }

                                                   if(var29 > var28.scrollY) {
                                                      var29 = var28.scrollY;
                                                   }

                                                   var28.scrollY -= var29;
                                                   Client.__client_je += var29;
                                                   class22.method295(var28);
                                                }

                                                if(var25 + var23 + 32 > Rasterizer2D.Rasterizer2D_yClipEnd && var28.scrollY < var28.scrollHeight - var28.height) {
                                                   var29 = (var23 + var25 + 32 - Rasterizer2D.Rasterizer2D_yClipEnd) * Client.__client_gy / 3;
                                                   if(var29 > Client.__client_gy * 10) {
                                                      var29 = Client.__client_gy * 10;
                                                   }

                                                   if(var29 > var28.scrollHeight - var28.height - var28.scrollY) {
                                                      var29 = var28.scrollHeight - var28.height - var28.scrollY;
                                                   }

                                                   var28.scrollY += var29;
                                                   Client.__client_je -= var29;
                                                   class22.method295(var28);
                                                }
                                             }
                                          } else if(var10 == BoundaryObject.__ej_jv && var30 == Client.__client_jz) {
                                             var27.__h_508(var22, var23, 128);
                                          } else {
                                             var27.drawAt2(var22, var23);
                                          }
                                       } else {
                                          class22.method295(var10);
                                       }
                                    }
                                 }

                                 ++var30;
                              }
                           }
                        } else if(var10.type == 3) {
                           if(class238.runCs1(var10)) {
                              var30 = var10.color2;
                              if(var10 == Clock.mousedOverWidgetIf1 && var10.mouseOverColor2 != 0) {
                                 var30 = var10.mouseOverColor2;
                              }
                           } else {
                              var30 = var10.color;
                              if(var10 == Clock.mousedOverWidgetIf1 && var10.mouseOverColor != 0) {
                                 var30 = var10.mouseOverColor;
                              }
                           }

                           if(var10.fill) {
                              switch(var10.rectangleMode.id) {
                              case 1:
                                 Rasterizer2D.drawGradient(var12, var13, var10.width, var10.height, var10.color, var10.color2);
                                 break;
                              case 2:
                                 Rasterizer2D.drawGradientAlpha(var12, var13, var10.width, var10.height, var10.color, var10.color2, 255 - (var10.transparency & 255), 255 - (var10.__af & 255));
                                 break;
                              default:
                                 if(var14 == 0) {
                                    Rasterizer2D.Rasterizer2D_fillRectangle(var12, var13, var10.width, var10.height, var30);
                                 } else {
                                    Rasterizer2D.Rasterizer2D_fillRectangleAlpha(var12, var13, var10.width, var10.height, var30, 256 - (var14 & 255));
                                 }
                              }
                           } else if(var14 == 0) {
                              Rasterizer2D.Rasterizer2D_drawRectangle(var12, var13, var10.width, var10.height, var30);
                           } else {
                              Rasterizer2D.Rasterizer2D_drawRectangleAlpha(var12, var13, var10.width, var10.height, var30, 256 - (var14 & 255));
                           }
                        } else {
                           Font var36;
                           if(var10.type == 4) {
                              var36 = var10.getFont();
                              if(var36 == null) {
                                 if(Widget.__ho_j) {
                                    class22.method295(var10);
                                 }
                              } else {
                                 String var45 = var10.text;
                                 if(class238.runCs1(var10)) {
                                    var20 = var10.color2;
                                    if(var10 == Clock.mousedOverWidgetIf1 && var10.mouseOverColor2 != 0) {
                                       var20 = var10.mouseOverColor2;
                                    }

                                    if(var10.text2.length() > 0) {
                                       var45 = var10.text2;
                                    }
                                 } else {
                                    var20 = var10.color;
                                    if(var10 == Clock.mousedOverWidgetIf1 && var10.mouseOverColor != 0) {
                                       var20 = var10.mouseOverColor;
                                    }
                                 }

                                 if(var10.isIf3 && var10.itemId != -1) {
                                    ItemDefinition var46 = Skills.getItemDefinition(var10.itemId);
                                    var45 = var46.name;
                                    if(var45 == null) {
                                       var45 = "null";
                                    }

                                    if((var46.isStackable == 1 || var10.itemQuantity != 1) && var10.itemQuantity != -1) {
                                       var45 = BufferedFile.colorStartTag(16748608) + var45 + "</col>" + " " + 'x' + GrandExchangeEvent.method88(var10.itemQuantity);
                                    }
                                 }

                                 if(var10 == Client.__client_mo) {
                                    var45 = "Please wait...";
                                    var20 = var10.color;
                                 }

                                 if(!var10.isIf3) {
                                    var45 = MouseRecorder.method1194(var45, var10);
                                 }

                                 var36.drawLines(var45, var12, var13, var10.width, var10.height, var20, var10.textShadowed?0:-1, var10.textXAlignment, var10.textYAlignment, var10.textLineHeight);
                              }
                           } else if(var10.type == 5) {
                              Sprite var37;
                              if(!var10.isIf3) {
                                 var37 = var10.getSprite(class238.runCs1(var10));
                                 if(var37 != null) {
                                    var37.drawAt2(var12, var13);
                                 } else if(Widget.__ho_j) {
                                    class22.method295(var10);
                                 }
                              } else {
                                 if(var10.itemId != -1) {
                                    var37 = class226.getItemSprite(var10.itemId, var10.itemQuantity, var10.outline, var10.spriteShadow, var10.itemQuantityMode, false);
                                 } else {
                                    var37 = var10.getSprite(false);
                                 }

                                 if(var37 == null) {
                                    if(Widget.__ho_j) {
                                       class22.method295(var10);
                                    }
                                 } else {
                                    var20 = var37.width;
                                    var21 = var37.height;
                                    if(!var10.spriteTiling) {
                                       var22 = var10.width * 4096 / var20;
                                       if(var10.spriteAngle != 0) {
                                          var37.__ak_515(var10.width / 2 + var12, var10.height / 2 + var13, var10.spriteAngle, var22);
                                       } else if(var14 != 0) {
                                          var37.__c_509(var12, var13, var10.width, var10.height, 256 - (var14 & 255));
                                       } else if(var20 == var10.width && var21 == var10.height) {
                                          var37.drawAt2(var12, var13);
                                       } else {
                                          var37.__j_506(var12, var13, var10.width, var10.height);
                                       }
                                    } else {
                                       Rasterizer2D.Rasterizer2D_expandClip(var12, var13, var12 + var10.width, var13 + var10.height);
                                       var22 = (var20 - 1 + var10.width) / var20;
                                       var23 = (var21 - 1 + var10.height) / var21;

                                       for(var24 = 0; var24 < var22; ++var24) {
                                          for(var25 = 0; var25 < var23; ++var25) {
                                             if(var10.spriteAngle != 0) {
                                                var37.__ak_515(var20 / 2 + var12 + var20 * var24, var21 / 2 + var13 + var25 * var21, var10.spriteAngle, 4096);
                                             } else if(var14 != 0) {
                                                var37.__h_508(var12 + var20 * var24, var13 + var21 * var25, 256 - (var14 & 255));
                                             } else {
                                                var37.drawAt2(var12 + var20 * var24, var13 + var25 * var21);
                                             }
                                          }
                                       }

                                       Rasterizer2D.Rasterizer2D_setClip(var2, var3, var4, var5);
                                    }
                                 }
                              }
                           } else {
                              ItemDefinition var34;
                              if(var10.type == 6) {
                                 boolean var43 = class238.runCs1(var10);
                                 if(var43) {
                                    var20 = var10.sequenceId2;
                                 } else {
                                    var20 = var10.sequenceId;
                                 }

                                 Model var41 = null;
                                 var22 = 0;
                                 if(var10.itemId != -1) {
                                    var34 = Skills.getItemDefinition(var10.itemId);
                                    if(var34 != null) {
                                       var34 = var34.__x_430(var10.itemQuantity);
                                       var41 = var34.getModel(1);
                                       if(var41 != null) {
                                          var41.calculateBoundsCylinder();
                                          var22 = var41.height / 2;
                                       } else {
                                          class22.method295(var10);
                                       }
                                    }
                                 } else if(var10.modelType == 5) {
                                    if(var10.modelId == 0) {
                                       var41 = Client.__client_ru.getModel((SequenceDefinition)null, -1, (SequenceDefinition)null, -1);
                                    } else {
                                       var41 = Canvas.localPlayer.getModel();
                                    }
                                 } else if(var20 == -1) {
                                    var41 = var10.getModel((SequenceDefinition)null, -1, var43, Canvas.localPlayer.appearance);
                                    if(var41 == null && Widget.__ho_j) {
                                       class22.method295(var10);
                                    }
                                 } else {
                                    SequenceDefinition var47 = WorldMapAreaData.getSequenceDefinition(var20);
                                    var41 = var10.getModel(var47, var10.modelFrame, var43, Canvas.localPlayer.appearance);
                                    if(var41 == null && Widget.__ho_j) {
                                       class22.method295(var10);
                                    }
                                 }

                                 Rasterizer3D.method2989(var10.width / 2 + var12, var10.height / 2 + var13);
                                 var23 = Rasterizer3D.Rasterizer3D_sine[var10.modelAngleX] * var10.modelZoom >> 16;
                                 var24 = Rasterizer3D.Rasterizer3D_cosine[var10.modelAngleX] * var10.modelZoom >> 16;
                                 if(var41 != null) {
                                    if(!var10.isIf3) {
                                       var41.__c_234(0, var10.modelAngleY, 0, var10.modelAngleX, 0, var23, var24);
                                    } else {
                                       var41.calculateBoundsCylinder();
                                       if(var10.modelOrthog) {
                                          var41.__p_235(0, var10.modelAngleY, var10.modelAngleZ, var10.modelAngleX, var10.modelOffsetX, var22 + var23 + var10.modelOffsetY, var24 + var10.modelOffsetY, var10.modelZoom);
                                       } else {
                                          var41.__c_234(0, var10.modelAngleY, var10.modelAngleZ, var10.modelAngleX, var10.modelOffsetX, var23 + var22 + var10.modelOffsetY, var24 + var10.modelOffsetY);
                                       }
                                    }
                                 }

                                 Rasterizer3D.Rasterizer3D_method3();
                              } else {
                                 if(var10.type == 7) {
                                    var36 = var10.getFont();
                                    if(var36 == null) {
                                       if(Widget.__ho_j) {
                                          class22.method295(var10);
                                       }
                                       continue;
                                    }

                                    var20 = 0;

                                    for(var21 = 0; var21 < var10.rawHeight; ++var21) {
                                       for(var22 = 0; var22 < var10.rawWidth; ++var22) {
                                          if(var10.itemIds[var20] > 0) {
                                             var34 = Skills.getItemDefinition(var10.itemIds[var20] - 1);
                                             String var31;
                                             if(var34.isStackable != 1 && var10.itemQuantities[var20] == 1) {
                                                var31 = BufferedFile.colorStartTag(16748608) + var34.name + "</col>";
                                             } else {
                                                var31 = BufferedFile.colorStartTag(16748608) + var34.name + "</col>" + " " + 'x' + GrandExchangeEvent.method88(var10.itemQuantities[var20]);
                                             }

                                             var25 = var22 * (var10.paddingX + 115) + var12;
                                             var26 = var21 * (var10.paddingY + 12) + var13;
                                             if(var10.textXAlignment == 0) {
                                                var36.draw(var31, var25, var26, var10.color, var10.textShadowed?0:-1);
                                             } else if(var10.textXAlignment == 1) {
                                                var36.drawCentered(var31, var10.width / 2 + var25, var26, var10.color, var10.textShadowed?0:-1);
                                             } else {
                                                var36.drawRightAligned(var31, var25 + var10.width - 1, var26, var10.color, var10.textShadowed?0:-1);
                                             }
                                          }

                                          ++var20;
                                       }
                                    }
                                 }

                                 if(var10.type == 8 && var10 == AccessFile.__dk_lm && Client.__client_ls == Client.__client_lb) {
                                    var30 = 0;
                                    var20 = 0;
                                    Font var32 = fontPlain12;
                                    String var33 = var10.text;

                                    String var44;
                                    for(var33 = MouseRecorder.method1194(var33, var10); var33.length() > 0; var20 = var20 + var32.ascent + 1) {
                                       var24 = var33.indexOf("<br>");
                                       if(var24 != -1) {
                                          var44 = var33.substring(0, var24);
                                          var33 = var33.substring(var24 + 4);
                                       } else {
                                          var44 = var33;
                                          var33 = "";
                                       }

                                       var25 = var32.stringWidth(var44);
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

                                    if(var30 + var24 > var4) {
                                       var24 = var4 - var30;
                                    }

                                    if(var25 + var20 > var5) {
                                       var25 = var5 - var20;
                                    }

                                    Rasterizer2D.Rasterizer2D_fillRectangle(var24, var25, var30, var20, 16777120);
                                    Rasterizer2D.Rasterizer2D_drawRectangle(var24, var25, var30, var20, 0);
                                    var33 = var10.text;
                                    var26 = var25 + var32.ascent + 2;

                                    for(var33 = MouseRecorder.method1194(var33, var10); var33.length() > 0; var26 = var26 + var32.ascent + 1) {
                                       int var35 = var33.indexOf("<br>");
                                       if(var35 != -1) {
                                          var44 = var33.substring(0, var35);
                                          var33 = var33.substring(var35 + 4);
                                       } else {
                                          var44 = var33;
                                          var33 = "";
                                       }

                                       var32.draw(var44, var24 + 3, var26, 0, -1);
                                    }
                                 }

                                 if(var10.type == 9) {
                                    if(var10.__ba) {
                                       var30 = var12;
                                       var20 = var13 + var10.height;
                                       var21 = var12 + var10.width;
                                       var22 = var13;
                                    } else {
                                       var30 = var12;
                                       var20 = var13;
                                       var21 = var12 + var10.width;
                                       var22 = var13 + var10.height;
                                    }

                                    if(var10.lineWid == 1) {
                                       Rasterizer2D.Rasterizer2D_drawLine(var30, var20, var21, var22, var10.color);
                                    } else {
                                       class190.method3669(var30, var20, var21, var22, var10.color, var10.lineWid);
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

   @ObfuscatedName("jy")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1666917204"
   )
   static final void method845(int var0) {
      if(GroundItemPile.loadWidgetGroup(var0)) {
         Widget[] var1 = Widget.widgets[var0];

         for(int var2 = 0; var2 < var1.length; ++var2) {
            Widget var3 = var1[var2];
            if(var3 != null) {
               var3.modelFrame = 0;
               var3.modelFrameCycle = 0;
            }
         }

      }
   }
}
