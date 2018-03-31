import java.io.File;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("p")
public class class7 {
   @ObfuscatedName("c")
   @Export("drawBoundingBoxes3D")
   public static boolean drawBoundingBoxes3D;
   @ObfuscatedName("i")
   @Export("drawBoundingBoxes2D")
   public static boolean drawBoundingBoxes2D;
   @ObfuscatedName("o")
   @Export("drawObjectGeometry2D")
   public static boolean drawObjectGeometry2D;
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "La;"
   )
   @Export("boundingBox3DDrawMode")
   public static BoundingBox3DDrawMode boundingBox3DDrawMode;
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Lhe;"
   )
   @Export("boundingBoxes")
   static CombatInfoList boundingBoxes;
   @ObfuscatedName("g")
   static int[] field231;
   @ObfuscatedName("ex")
   @ObfuscatedSignature(
      signature = "Lkp;"
   )
   @Export("fonts")
   static Fonts fonts;

   static {
      drawBoundingBoxes3D = false;
      drawBoundingBoxes2D = false;
      drawObjectGeometry2D = false;
      boundingBox3DDrawMode = BoundingBox3DDrawMode.ON_MOUSEOVER;
      boundingBoxes = new CombatInfoList();
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1265368216"
   )
   public static void method31() {
      if(KeyFocusListener.keyboard != null) {
         KeyFocusListener var0 = KeyFocusListener.keyboard;
         synchronized(KeyFocusListener.keyboard) {
            KeyFocusListener.keyboard = null;
         }
      }

   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(Ljava/io/File;I)V",
      garbageValue = "-962449221"
   )
   public static void method41(File var0) {
      SoundTaskDataProvider.field624 = var0;
      if(!SoundTaskDataProvider.field624.exists()) {
         throw new RuntimeException("");
      } else {
         class170.field2220 = true;
      }
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "([Ljava/lang/CharSequence;III)Ljava/lang/String;",
      garbageValue = "441121178"
   )
   public static String method43(CharSequence[] var0, int var1, int var2) {
      if(var2 == 0) {
         return "";
      } else if(var2 == 1) {
         CharSequence var3 = var0[var1];
         return var3 == null?"null":var3.toString();
      } else {
         int var8 = var2 + var1;
         int var4 = 0;

         for(int var5 = var1; var5 < var8; ++var5) {
            CharSequence var6 = var0[var5];
            if(var6 == null) {
               var4 += 4;
            } else {
               var4 += var6.length();
            }
         }

         StringBuilder var9 = new StringBuilder(var4);

         for(int var10 = var1; var10 < var8; ++var10) {
            CharSequence var7 = var0[var10];
            if(var7 == null) {
               var9.append("null");
            } else {
               var9.append(var7);
            }
         }

         return var9.toString();
      }
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(ILcx;ZI)I",
      garbageValue = "112449321"
   )
   static int method42(int var0, Script var1, boolean var2) {
      Widget var3;
      if(var0 >= 2000) {
         var0 -= 1000;
         var3 = class3.getWidget(class81.intStack[--SceneTilePaint.intStackSize]);
      } else {
         var3 = var2?class336.field4073:class61.field713;
      }

      WorldMapType1.method274(var3);
      if(var0 != 1200 && var0 != 1205 && var0 != 1212) {
         if(var0 == 1201) {
            var3.modelType = 2;
            var3.modelId = class81.intStack[--SceneTilePaint.intStackSize];
            return 1;
         } else if(var0 == 1202) {
            var3.modelType = 3;
            var3.modelId = WorldComparator.localPlayer.composition.method4416();
            return 1;
         } else {
            return 2;
         }
      } else {
         SceneTilePaint.intStackSize -= 2;
         int var4 = class81.intStack[SceneTilePaint.intStackSize];
         int var5 = class81.intStack[SceneTilePaint.intStackSize + 1];
         var3.itemId = var4;
         var3.itemQuantity = var5;
         ItemComposition var6 = GameObject.getItemDefinition(var4);
         var3.rotationX = var6.xan2d;
         var3.rotationZ = var6.yan2d;
         var3.rotationY = var6.zan2d;
         var3.offsetX2d = var6.offsetX2d;
         var3.offsetY2d = var6.offsetY2d;
         var3.modelZoom = var6.zoom2d;
         if(var0 == 1205) {
            var3.field2872 = 0;
         } else if(var0 == 1212 | 1 == var6.isStackable) {
            var3.field2872 = 1;
         } else {
            var3.field2872 = 2;
         }

         if(var3.field2869 > 0) {
            var3.modelZoom = var3.modelZoom * 32 / var3.field2869;
         } else if(var3.originalWidth > 0) {
            var3.modelZoom = var3.modelZoom * 32 / var3.originalWidth;
         }

         return 1;
      }
   }

   @ObfuscatedName("gp")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1801382100"
   )
   static void method39() {
      if(ScriptState.renderOverview != null) {
         ScriptState.renderOverview.method6021(class237.plane, (WorldComparator.localPlayer.x >> 7) + PacketNode.baseX, (WorldComparator.localPlayer.y >> 7) + BaseVarType.baseY, false);
         ScriptState.renderOverview.method6108();
      }

   }

   @ObfuscatedName("jq")
   @ObfuscatedSignature(
      signature = "([Lib;IIIIIIII)V",
      garbageValue = "1794637949"
   )
   static final void method40(Widget[] var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      for(int var8 = 0; var8 < var0.length; ++var8) {
         Widget var9 = var0[var8];
         if(var9 != null && (!var9.hasScript || var9.type == 0 || var9.hasListener || class45.getWidgetClickMask(var9) != 0 || var9 == Client.field1028 || var9.contentType == 1338) && var9.parentId == var1 && (!var9.hasScript || !class157.method3183(var9))) {
            int var10 = var9.relativeX + var6;
            int var11 = var7 + var9.relativeY;
            int var12;
            int var13;
            int var14;
            int var15;
            int var16;
            int var17;
            int var19;
            if(var9.type == 2) {
               var12 = var2;
               var13 = var3;
               var14 = var4;
               var15 = var5;
            } else if(var9.type == 9) {
               var16 = var10;
               var17 = var11;
               int var18 = var10 + var9.width;
               var19 = var11 + var9.height;
               if(var18 < var10) {
                  var16 = var18;
                  var18 = var10;
               }

               if(var19 < var11) {
                  var17 = var19;
                  var19 = var11;
               }

               ++var18;
               ++var19;
               var12 = var16 > var2?var16:var2;
               var13 = var17 > var3?var17:var3;
               var14 = var18 < var4?var18:var4;
               var15 = var19 < var5?var19:var5;
            } else {
               var16 = var10 + var9.width;
               var17 = var11 + var9.height;
               var12 = var10 > var2?var10:var2;
               var13 = var11 > var3?var11:var3;
               var14 = var16 < var4?var16:var4;
               var15 = var17 < var5?var17:var5;
            }

            if(var9 == Client.draggedWidget) {
               Client.field877 = true;
               Client.field1124 = var10;
               Client.field1037 = var11;
            }

            if(!var9.hasScript || var12 < var14 && var13 < var15) {
               var16 = MouseInput.mouseLastX;
               var17 = MouseInput.mouseLastY;
               if(MouseInput.mouseLastButton != 0) {
                  var16 = MouseInput.mouseLastPressedX;
                  var17 = MouseInput.mouseLastPressedY;
               }

               boolean var44 = var16 >= var12 && var17 >= var13 && var16 < var14 && var17 < var15;
               if(var9.contentType == 1337) {
                  if(!Client.field865 && !Client.isMenuOpen && var44) {
                     PacketBuffer.method3821(var16, var17, var12, var13);
                  }
               } else if(var9.contentType == 1338) {
                  class276.method4884(var9, var10, var11);
               } else {
                  if(var9.contentType == 1400) {
                     ScriptState.renderOverview.method6166(MouseInput.mouseLastX, MouseInput.mouseLastY, var44, var10, var11, var9.width, var9.height);
                  }

                  int var20;
                  int var22;
                  int var23;
                  int var24;
                  int var25;
                  int var39;
                  boolean var52;
                  if(!Client.isMenuOpen && var44) {
                     if(var9.contentType == 1400) {
                        ScriptState.renderOverview.method6064(var10, var11, var9.width, var9.height, var16, var17);
                     } else {
                        var19 = var16 - var10;
                        var20 = var17 - var11;
                        if(var9.field2817 == 1) {
                           RunException.addMenuEntry(var9.tooltip, "", 24, 0, 0, var9.id);
                        }

                        String var21;
                        if(var9.field2817 == 2 && !Client.spellSelected) {
                           var23 = class45.getWidgetClickMask(var9);
                           var22 = var23 >> 11 & 63;
                           if(var22 == 0) {
                              var21 = null;
                           } else if(var9.targetVerb != null && var9.targetVerb.trim().length() != 0) {
                              var21 = var9.targetVerb;
                           } else {
                              var21 = null;
                           }

                           if(var21 != null) {
                              RunException.addMenuEntry(var21, class173.getColTags(65280) + var9.spellName, 25, 0, -1, var9.id);
                           }
                        }

                        if(var9.field2817 == 3) {
                           RunException.addMenuEntry("Close", "", 26, 0, 0, var9.id);
                        }

                        if(var9.field2817 == 4) {
                           RunException.addMenuEntry(var9.tooltip, "", 28, 0, 0, var9.id);
                        }

                        if(var9.field2817 == 5) {
                           RunException.addMenuEntry(var9.tooltip, "", 29, 0, 0, var9.id);
                        }

                        if(var9.field2817 == 6 && Client.field1102 == null) {
                           RunException.addMenuEntry(var9.tooltip, "", 30, 0, -1, var9.id);
                        }

                        if(var9.type == 2) {
                           var39 = 0;

                           for(var22 = 0; var22 < var9.height; ++var22) {
                              for(var23 = 0; var23 < var9.width; ++var23) {
                                 var24 = var23 * (var9.paddingX + 32);
                                 var25 = var22 * (var9.paddingY + 32);
                                 if(var39 < 20) {
                                    var24 += var9.xSprites[var39];
                                    var25 += var9.field2883[var39];
                                 }

                                 if(var19 >= var24 && var20 >= var25 && var19 < var24 + 32 && var20 < var25 + 32) {
                                    Client.field1086 = var39;
                                    TextureProvider.field1701 = var9;
                                    if(var9.itemIds[var39] > 0) {
                                       label1423: {
                                          ItemComposition var26 = GameObject.getItemDefinition(var9.itemIds[var39] - 1);
                                          int var28;
                                          boolean var41;
                                          if(Client.itemSelectionState == 1) {
                                             var28 = class45.getWidgetClickMask(var9);
                                             var41 = (var28 >> 30 & 1) != 0;
                                             if(var41) {
                                                if(var9.id != Client.field900 || var39 != class49.selectedItemIndex) {
                                                   RunException.addMenuEntry("Use", Client.lastSelectedItemName + " " + "->" + " " + class173.getColTags(16748608) + var26.name, 31, var26.id, var39, var9.id);
                                                }
                                                break label1423;
                                             }
                                          }

                                          if(Client.spellSelected) {
                                             var28 = class45.getWidgetClickMask(var9);
                                             var41 = (var28 >> 30 & 1) != 0;
                                             if(var41) {
                                                if((class241.field2799 & 16) == 16) {
                                                   RunException.addMenuEntry(Client.field956, Client.field1015 + " " + "->" + " " + class173.getColTags(16748608) + var26.name, 32, var26.id, var39, var9.id);
                                                }
                                                break label1423;
                                             }
                                          }

                                          String[] var27 = var26.inventoryActions;
                                          var28 = -1;
                                          boolean var29;
                                          if(Client.field1001) {
                                             var29 = Client.field1002 || KeyFocusListener.keyPressed[81];
                                             if(var29) {
                                                var28 = var26.getShiftClickActionIndex();
                                             }
                                          }

                                          int var30 = class45.getWidgetClickMask(var9);
                                          var29 = (var30 >> 30 & 1) != 0;
                                          if(var29) {
                                             for(int var31 = 4; var31 >= 3; --var31) {
                                                if(var31 != var28) {
                                                   GZipDecompressor.method3457(var9, var26, var39, var31, false);
                                                }
                                             }
                                          }

                                          int var32 = class45.getWidgetClickMask(var9);
                                          boolean var49 = (var32 >> 31 & 1) != 0;
                                          if(var49) {
                                             RunException.addMenuEntry("Use", class173.getColTags(16748608) + var26.name, 38, var26.id, var39, var9.id);
                                          }

                                          int var34 = class45.getWidgetClickMask(var9);
                                          boolean var33 = (var34 >> 30 & 1) != 0;
                                          int var35;
                                          if(var33) {
                                             for(var35 = 2; var35 >= 0; --var35) {
                                                if(var28 != var35) {
                                                   GZipDecompressor.method3457(var9, var26, var39, var35, false);
                                                }
                                             }

                                             if(var28 >= 0) {
                                                GZipDecompressor.method3457(var9, var26, var39, var28, true);
                                             }
                                          }

                                          var27 = var9.configActions;
                                          if(var27 != null) {
                                             for(var35 = 4; var35 >= 0; --var35) {
                                                if(var27[var35] != null) {
                                                   byte var36 = 0;
                                                   if(var35 == 0) {
                                                      var36 = 39;
                                                   }

                                                   if(var35 == 1) {
                                                      var36 = 40;
                                                   }

                                                   if(var35 == 2) {
                                                      var36 = 41;
                                                   }

                                                   if(var35 == 3) {
                                                      var36 = 42;
                                                   }

                                                   if(var35 == 4) {
                                                      var36 = 43;
                                                   }

                                                   RunException.addMenuEntry(var27[var35], class173.getColTags(16748608) + var26.name, var36, var26.id, var39, var9.id);
                                                }
                                             }
                                          }

                                          RunException.addMenuEntry("Examine", class173.getColTags(16748608) + var26.name, 1005, var26.id, var39, var9.id);
                                       }
                                    }
                                 }

                                 ++var39;
                              }
                           }
                        }

                        if(var9.hasScript) {
                           if(Client.spellSelected) {
                              var22 = class45.getWidgetClickMask(var9);
                              var52 = (var22 >> 21 & 1) != 0;
                              if(var52 && (class241.field2799 & 32) == 32) {
                                 RunException.addMenuEntry(Client.field956, Client.field1015 + " " + "->" + " " + var9.opBase, 58, 0, var9.index, var9.id);
                              }
                           } else {
                              for(var39 = 9; var39 >= 5; --var39) {
                                 String var38 = class38.method529(var9, var39);
                                 if(var38 != null) {
                                    RunException.addMenuEntry(var38, var9.opBase, 1007, var39 + 1, var9.index, var9.id);
                                 }
                              }

                              var23 = class45.getWidgetClickMask(var9);
                              var22 = var23 >> 11 & 63;
                              if(var22 == 0) {
                                 var21 = null;
                              } else if(var9.targetVerb != null && var9.targetVerb.trim().length() != 0) {
                                 var21 = var9.targetVerb;
                              } else {
                                 var21 = null;
                              }

                              if(var21 != null) {
                                 RunException.addMenuEntry(var21, var9.opBase, 25, 0, var9.index, var9.id);
                              }

                              for(var23 = 4; var23 >= 0; --var23) {
                                 String var40 = class38.method529(var9, var23);
                                 if(var40 != null) {
                                    RunException.addMenuEntry(var40, var9.opBase, 57, var23 + 1, var9.index, var9.id);
                                 }
                              }

                              var24 = class45.getWidgetClickMask(var9);
                              boolean var48 = (var24 & 1) != 0;
                              if(var48) {
                                 RunException.addMenuEntry("Continue", "", 30, 0, var9.index, var9.id);
                              }
                           }
                        }
                     }
                  }

                  if(var9.type == 0) {
                     if(!var9.hasScript && class157.method3183(var9) && var9 != Coordinates.field2775) {
                        continue;
                     }

                     method40(var0, var9.id, var12, var13, var14, var15, var10 - var9.scrollX, var11 - var9.scrollY);
                     if(var9.children != null) {
                        method40(var9.children, var9.id, var12, var13, var14, var15, var10 - var9.scrollX, var11 - var9.scrollY);
                     }

                     WidgetNode var37 = (WidgetNode)Client.componentTable.get((long)var9.id);
                     if(var37 != null) {
                        if(var37.owner == 0 && MouseInput.mouseLastX >= var12 && MouseInput.mouseLastY >= var13 && MouseInput.mouseLastX < var14 && MouseInput.mouseLastY < var15 && !Client.isMenuOpen) {
                           for(ScriptEvent var42 = (ScriptEvent)Client.field1054.getFront(); var42 != null; var42 = (ScriptEvent)Client.field1054.getNext()) {
                              if(var42.boolean1) {
                                 var42.unlink();
                                 var42.widget.field2939 = false;
                              }
                           }

                           if(WorldMapRegion.field453 == 0) {
                              Client.draggedWidget = null;
                              Client.field1028 = null;
                           }

                           if(!Client.isMenuOpen) {
                              GrandExchangeOffer.method124();
                           }
                        }

                        var20 = var37.id;
                        if(Name.loadWidget(var20)) {
                           method40(class189.widgets[var20], -1, var12, var13, var14, var15, var10, var11);
                        }
                     }
                  }

                  if(var9.hasScript) {
                     ScriptEvent var50;
                     if(!var9.noClickThrough) {
                        if(var9.noScrollThrough && MouseInput.mouseLastX >= var12 && MouseInput.mouseLastY >= var13 && MouseInput.mouseLastX < var14 && MouseInput.mouseLastY < var15) {
                           for(var50 = (ScriptEvent)Client.field1054.getFront(); var50 != null; var50 = (ScriptEvent)Client.field1054.getNext()) {
                              if(var50.boolean1 && var50.widget.onScrollWheelListener == var50.objs) {
                                 var50.unlink();
                              }
                           }
                        }
                     } else if(MouseInput.mouseLastX >= var12 && MouseInput.mouseLastY >= var13 && MouseInput.mouseLastX < var14 && MouseInput.mouseLastY < var15) {
                        for(var50 = (ScriptEvent)Client.field1054.getFront(); var50 != null; var50 = (ScriptEvent)Client.field1054.getNext()) {
                           if(var50.boolean1) {
                              var50.unlink();
                              var50.widget.field2939 = false;
                           }
                        }

                        if(WorldMapRegion.field453 == 0) {
                           Client.draggedWidget = null;
                           Client.field1028 = null;
                        }

                        if(!Client.isMenuOpen) {
                           GrandExchangeOffer.method124();
                        }
                     }

                     if(MouseInput.mouseLastX >= var12 && MouseInput.mouseLastY >= var13 && MouseInput.mouseLastX < var14 && MouseInput.mouseLastY < var15) {
                        var44 = true;
                     } else {
                        var44 = false;
                     }

                     boolean var45 = false;
                     if((MouseInput.mouseCurrentButton == 1 || !WorldMapData.middleMouseMovesCamera && MouseInput.mouseCurrentButton == 4) && var44) {
                        var45 = true;
                     }

                     boolean var46 = false;
                     if((MouseInput.mouseLastButton == 1 || !WorldMapData.middleMouseMovesCamera && MouseInput.mouseLastButton == 4) && MouseInput.mouseLastPressedX >= var12 && MouseInput.mouseLastPressedY >= var13 && MouseInput.mouseLastPressedX < var14 && MouseInput.mouseLastPressedY < var15) {
                        var46 = true;
                     }

                     if(var46) {
                        class231.method4258(var9, MouseInput.mouseLastPressedX - var10, MouseInput.mouseLastPressedY - var11);
                     }

                     if(var9.contentType == 1400) {
                        ScriptState.renderOverview.method6013(var16, var17, var44 & var45, var44 & var46);
                     }

                     if(Client.draggedWidget != null && var9 != Client.draggedWidget && var44) {
                        var22 = class45.getWidgetClickMask(var9);
                        var52 = (var22 >> 20 & 1) != 0;
                        if(var52) {
                           Client.draggedOnWidget = var9;
                        }
                     }

                     if(var9 == Client.field1028) {
                        Client.field1032 = true;
                        Client.field1033 = var10;
                        Client.field980 = var11;
                     }

                     if(var9.hasListener) {
                        ScriptEvent var47;
                        if(var44 && Client.mouseWheelRotation != 0 && var9.onScrollWheelListener != null) {
                           var47 = new ScriptEvent();
                           var47.boolean1 = true;
                           var47.widget = var9;
                           var47.field778 = Client.mouseWheelRotation;
                           var47.objs = var9.onScrollWheelListener;
                           Client.field1054.addFront(var47);
                        }

                        if(Client.draggedWidget != null || class157.field2149 != null || Client.isMenuOpen) {
                           var46 = false;
                           var45 = false;
                           var44 = false;
                        }

                        if(!var9.field2940 && var46) {
                           var9.field2940 = true;
                           if(var9.onClickListener != null) {
                              var47 = new ScriptEvent();
                              var47.boolean1 = true;
                              var47.widget = var9;
                              var47.field783 = MouseInput.mouseLastPressedX - var10;
                              var47.field778 = MouseInput.mouseLastPressedY - var11;
                              var47.objs = var9.onClickListener;
                              Client.field1054.addFront(var47);
                           }
                        }

                        if(var9.field2940 && var45 && var9.onClickRepeatListener != null) {
                           var47 = new ScriptEvent();
                           var47.boolean1 = true;
                           var47.widget = var9;
                           var47.field783 = MouseInput.mouseLastX - var10;
                           var47.field778 = MouseInput.mouseLastY - var11;
                           var47.objs = var9.onClickRepeatListener;
                           Client.field1054.addFront(var47);
                        }

                        if(var9.field2940 && !var45) {
                           var9.field2940 = false;
                           if(var9.onReleaseListener != null) {
                              var47 = new ScriptEvent();
                              var47.boolean1 = true;
                              var47.widget = var9;
                              var47.field783 = MouseInput.mouseLastX - var10;
                              var47.field778 = MouseInput.mouseLastY - var11;
                              var47.objs = var9.onReleaseListener;
                              Client.field1129.addFront(var47);
                           }
                        }

                        if(var45 && var9.onHoldListener != null) {
                           var47 = new ScriptEvent();
                           var47.boolean1 = true;
                           var47.widget = var9;
                           var47.field783 = MouseInput.mouseLastX - var10;
                           var47.field778 = MouseInput.mouseLastY - var11;
                           var47.objs = var9.onHoldListener;
                           Client.field1054.addFront(var47);
                        }

                        if(!var9.field2939 && var44) {
                           var9.field2939 = true;
                           if(var9.onMouseOverListener != null) {
                              var47 = new ScriptEvent();
                              var47.boolean1 = true;
                              var47.widget = var9;
                              var47.field783 = MouseInput.mouseLastX - var10;
                              var47.field778 = MouseInput.mouseLastY - var11;
                              var47.objs = var9.onMouseOverListener;
                              Client.field1054.addFront(var47);
                           }
                        }

                        if(var9.field2939 && var44 && var9.onMouseRepeatListener != null) {
                           var47 = new ScriptEvent();
                           var47.boolean1 = true;
                           var47.widget = var9;
                           var47.field783 = MouseInput.mouseLastX - var10;
                           var47.field778 = MouseInput.mouseLastY - var11;
                           var47.objs = var9.onMouseRepeatListener;
                           Client.field1054.addFront(var47);
                        }

                        if(var9.field2939 && !var44) {
                           var9.field2939 = false;
                           if(var9.onMouseLeaveListener != null) {
                              var47 = new ScriptEvent();
                              var47.boolean1 = true;
                              var47.widget = var9;
                              var47.field783 = MouseInput.mouseLastX - var10;
                              var47.field778 = MouseInput.mouseLastY - var11;
                              var47.objs = var9.onMouseLeaveListener;
                              Client.field1129.addFront(var47);
                           }
                        }

                        if(var9.onTimerListener != null) {
                           var47 = new ScriptEvent();
                           var47.widget = var9;
                           var47.objs = var9.onTimerListener;
                           Client.field970.addFront(var47);
                        }

                        ScriptEvent var53;
                        if(var9.onVarTransmitListener != null && Client.field1042 > var9.field2942) {
                           if(var9.varTransmitTriggers != null && Client.field1042 - var9.field2942 <= 32) {
                              label1104:
                              for(var39 = var9.field2942; var39 < Client.field1042; ++var39) {
                                 var22 = Client.field988[var39 & 31];

                                 for(var23 = 0; var23 < var9.varTransmitTriggers.length; ++var23) {
                                    if(var22 == var9.varTransmitTriggers[var23]) {
                                       var53 = new ScriptEvent();
                                       var53.widget = var9;
                                       var53.objs = var9.onVarTransmitListener;
                                       Client.field1054.addFront(var53);
                                       break label1104;
                                    }
                                 }
                              }
                           } else {
                              var47 = new ScriptEvent();
                              var47.widget = var9;
                              var47.objs = var9.onVarTransmitListener;
                              Client.field1054.addFront(var47);
                           }

                           var9.field2942 = Client.field1042;
                        }

                        if(var9.onInvTransmitListener != null && Client.field1119 > var9.field2932) {
                           if(var9.invTransmitTriggers != null && Client.field1119 - var9.field2932 <= 32) {
                              label1080:
                              for(var39 = var9.field2932; var39 < Client.field1119; ++var39) {
                                 var22 = Client.interfaceItemTriggers[var39 & 31];

                                 for(var23 = 0; var23 < var9.invTransmitTriggers.length; ++var23) {
                                    if(var22 == var9.invTransmitTriggers[var23]) {
                                       var53 = new ScriptEvent();
                                       var53.widget = var9;
                                       var53.objs = var9.onInvTransmitListener;
                                       Client.field1054.addFront(var53);
                                       break label1080;
                                    }
                                 }
                              }
                           } else {
                              var47 = new ScriptEvent();
                              var47.widget = var9;
                              var47.objs = var9.onInvTransmitListener;
                              Client.field1054.addFront(var47);
                           }

                           var9.field2932 = Client.field1119;
                        }

                        if(var9.onStatTransmitListener != null && Client.field1046 > var9.field2944) {
                           if(var9.statTransmitTriggers != null && Client.field1046 - var9.field2944 <= 32) {
                              label1056:
                              for(var39 = var9.field2944; var39 < Client.field1046; ++var39) {
                                 var22 = Client.field1045[var39 & 31];

                                 for(var23 = 0; var23 < var9.statTransmitTriggers.length; ++var23) {
                                    if(var22 == var9.statTransmitTriggers[var23]) {
                                       var53 = new ScriptEvent();
                                       var53.widget = var9;
                                       var53.objs = var9.onStatTransmitListener;
                                       Client.field1054.addFront(var53);
                                       break label1056;
                                    }
                                 }
                              }
                           } else {
                              var47 = new ScriptEvent();
                              var47.widget = var9;
                              var47.objs = var9.onStatTransmitListener;
                              Client.field1054.addFront(var47);
                           }

                           var9.field2944 = Client.field1046;
                        }

                        if(Client.chatCycle > var9.field2816 && var9.onChatTransmitListener != null) {
                           var47 = new ScriptEvent();
                           var47.widget = var9;
                           var47.objs = var9.onChatTransmitListener;
                           Client.field1054.addFront(var47);
                        }

                        if(Client.field1048 > var9.field2816 && var9.onFriendTransmitListener != null) {
                           var47 = new ScriptEvent();
                           var47.widget = var9;
                           var47.objs = var9.onFriendTransmitListener;
                           Client.field1054.addFront(var47);
                        }

                        if(Client.field1049 > var9.field2816 && var9.onClanTransmitListener != null) {
                           var47 = new ScriptEvent();
                           var47.widget = var9;
                           var47.objs = var9.onClanTransmitListener;
                           Client.field1054.addFront(var47);
                        }

                        if(Client.field1008 > var9.field2816 && var9.onStockTransmitListener != null) {
                           var47 = new ScriptEvent();
                           var47.widget = var9;
                           var47.objs = var9.onStockTransmitListener;
                           Client.field1054.addFront(var47);
                        }

                        if(Client.field879 > var9.field2816 && var9.onCamFinishedListener != null) {
                           var47 = new ScriptEvent();
                           var47.widget = var9;
                           var47.objs = var9.onCamFinishedListener;
                           Client.field1054.addFront(var47);
                        }

                        if(Client.field1052 > var9.field2816 && var9.onMiscTransmitListener != null) {
                           var47 = new ScriptEvent();
                           var47.widget = var9;
                           var47.objs = var9.onMiscTransmitListener;
                           Client.field1054.addFront(var47);
                        }

                        var9.field2816 = Client.cycleCntr;
                        if(var9.onKeyListener != null) {
                           for(var39 = 0; var39 < Client.field1076; ++var39) {
                              ScriptEvent var51 = new ScriptEvent();
                              var51.widget = var9;
                              var51.pressedKey = Client.field949[var39];
                              var51.typedKey = Client.field1077[var39];
                              var51.objs = var9.onKeyListener;
                              Client.field1054.addFront(var51);
                           }
                        }
                     }
                  }

                  if(!var9.hasScript && Client.draggedWidget == null && class157.field2149 == null && !Client.isMenuOpen) {
                     if((var9.field2936 >= 0 || var9.field2841 != 0) && MouseInput.mouseLastX >= var12 && MouseInput.mouseLastY >= var13 && MouseInput.mouseLastX < var14 && MouseInput.mouseLastY < var15) {
                        if(var9.field2936 >= 0) {
                           Coordinates.field2775 = var0[var9.field2936];
                        } else {
                           Coordinates.field2775 = var9;
                        }
                     }

                     if(var9.type == 8 && MouseInput.mouseLastX >= var12 && MouseInput.mouseLastY >= var13 && MouseInput.mouseLastX < var14 && MouseInput.mouseLastY < var15) {
                        class23.field331 = var9;
                     }

                     if(var9.scrollHeight > var9.height) {
                        var19 = var10 + var9.width;
                        var20 = var9.height;
                        var39 = var9.scrollHeight;
                        var22 = MouseInput.mouseLastX;
                        var23 = MouseInput.mouseLastY;
                        if(Client.field927) {
                           Client.field1064 = 32;
                        } else {
                           Client.field1064 = 0;
                        }

                        Client.field927 = false;
                        if(MouseInput.mouseCurrentButton == 1 || !WorldMapData.middleMouseMovesCamera && MouseInput.mouseCurrentButton == 4) {
                           if(var22 >= var19 && var22 < var19 + 16 && var23 >= var11 && var23 < var11 + 16) {
                              var9.scrollY -= 4;
                              WorldMapType1.method274(var9);
                           } else if(var22 >= var19 && var22 < var19 + 16 && var23 >= var20 + var11 - 16 && var23 < var11 + var20) {
                              var9.scrollY += 4;
                              WorldMapType1.method274(var9);
                           } else if(var22 >= var19 - Client.field1064 && var22 < var19 + Client.field1064 + 16 && var23 >= var11 + 16 && var23 < var11 + var20 - 16) {
                              var24 = var20 * (var20 - 32) / var39;
                              if(var24 < 8) {
                                 var24 = 8;
                              }

                              var25 = var23 - var11 - 16 - var24 / 2;
                              int var43 = var20 - 32 - var24;
                              var9.scrollY = var25 * (var39 - var20) / var43;
                              WorldMapType1.method274(var9);
                              Client.field927 = true;
                           }
                        }

                        if(Client.mouseWheelRotation != 0) {
                           var24 = var9.width;
                           if(var22 >= var19 - var24 && var23 >= var11 && var22 < var19 + 16 && var23 <= var20 + var11) {
                              var9.scrollY += Client.mouseWheelRotation * 45;
                              WorldMapType1.method274(var9);
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
