import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("le")
public class class319 {
   @ObfuscatedName("u")
   static byte[][][] field3930;

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1718897418"
   )
   public static void method5650(int var0) {
      if(class229.field2687 != 0) {
         class86.field1330 = var0;
      } else {
         class229.field2690.method4134(var0);
      }

   }

   @ObfuscatedName("ib")
   @ObfuscatedSignature(
      signature = "([Lin;IIIIIIIB)V",
      garbageValue = "-27"
   )
   static final void method5651(Widget[] var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      for(int var8 = 0; var8 < var0.length; ++var8) {
         Widget var9 = var0[var8];
         if(var9 != null && (!var9.hasScript || var9.type == 0 || var9.hasListener || GroundObject.getWidgetClickMask(var9) != 0 || var9 == Client.field937 || var9.contentType == 1338) && var9.parentId == var1) {
            if(var9.hasScript) {
               boolean var10 = var9.isHidden;
               if(var10) {
                  continue;
               }
            }

            int var43 = var9.relativeX + var6;
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
               var16 = var43;
               var17 = var11;
               int var18 = var43 + var9.width;
               var19 = var11 + var9.height;
               if(var18 < var43) {
                  var16 = var18;
                  var18 = var43;
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
               var16 = var43 + var9.width;
               var17 = var11 + var9.height;
               var12 = var43 > var2?var43:var2;
               var13 = var11 > var3?var11:var3;
               var14 = var16 < var4?var16:var4;
               var15 = var17 < var5?var17:var5;
            }

            if(var9 == Client.draggedWidget) {
               Client.field958 = true;
               Client.field1049 = var43;
               Client.field882 = var11;
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
                  if(!Client.field880 && !Client.isMenuOpen && var44) {
                     GameCanvas.method833(var16, var17, var12, var13);
                  }
               } else if(var9.contentType == 1338) {
                  class71.method1181(var9, var43, var11);
               } else {
                  if(var9.contentType == 1400) {
                     Preferences.renderOverview.method6009(MouseInput.mouseLastX, MouseInput.mouseLastY, var44, var43, var11, var9.width, var9.height);
                  }

                  int var23;
                  int var37;
                  int var38;
                  if(!Client.isMenuOpen && var44) {
                     if(var9.contentType == 1400) {
                        Preferences.renderOverview.method6077(var43, var11, var9.width, var9.height, var16, var17);
                     } else {
                        var19 = var16 - var43;
                        int var20 = var17 - var11;
                        if(var9.field2932 == 1) {
                           TextureProvider.addMenuEntry(var9.tooltip, "", 24, 0, 0, var9.id);
                        }

                        String var21;
                        if(var9.field2932 == 2 && !Client.spellSelected) {
                           if(class250.method4502(GroundObject.getWidgetClickMask(var9)) == 0) {
                              var21 = null;
                           } else if(var9.targetVerb != null && var9.targetVerb.trim().length() != 0) {
                              var21 = var9.targetVerb;
                           } else {
                              var21 = null;
                           }

                           if(var21 != null) {
                              TextureProvider.addMenuEntry(var21, class45.getColTags(65280) + var9.spellName, 25, 0, -1, var9.id);
                           }
                        }

                        if(var9.field2932 == 3) {
                           TextureProvider.addMenuEntry("Close", "", 26, 0, 0, var9.id);
                        }

                        if(var9.field2932 == 4) {
                           TextureProvider.addMenuEntry(var9.tooltip, "", 28, 0, 0, var9.id);
                        }

                        if(var9.field2932 == 5) {
                           TextureProvider.addMenuEntry(var9.tooltip, "", 29, 0, 0, var9.id);
                        }

                        if(var9.field2932 == 6 && Client.field1033 == null) {
                           TextureProvider.addMenuEntry(var9.tooltip, "", 30, 0, -1, var9.id);
                        }

                        int var24;
                        if(var9.type == 2) {
                           var37 = 0;

                           for(var38 = 0; var38 < var9.height; ++var38) {
                              for(var23 = 0; var23 < var9.width; ++var23) {
                                 var24 = var23 * (var9.paddingX + 32);
                                 int var25 = var38 * (var9.paddingY + 32);
                                 if(var37 < 20) {
                                    var24 += var9.xSprites[var37];
                                    var25 += var9.field2915[var37];
                                 }

                                 if(var19 >= var24 && var20 >= var25 && var19 < var24 + 32 && var20 < var25 + 32) {
                                    Client.field980 = var37;
                                    class36.field492 = var9;
                                    if(var9.itemIds[var37] > 0) {
                                       label1333: {
                                          ItemComposition var26 = class47.getItemDefinition(var9.itemIds[var37] - 1);
                                          boolean var27;
                                          int var28;
                                          if(Client.itemSelectionState == 1) {
                                             var28 = GroundObject.getWidgetClickMask(var9);
                                             var27 = (var28 >> 30 & 1) != 0;
                                             if(var27) {
                                                if(var9.id != BoundingBox.field251 || var37 != UrlRequester.selectedItemIndex) {
                                                   TextureProvider.addMenuEntry("Use", Client.lastSelectedItemName + " " + "->" + " " + class45.getColTags(16748608) + var26.name, 31, var26.id, var37, var9.id);
                                                }
                                                break label1333;
                                             }
                                          }

                                          if(Client.spellSelected) {
                                             var28 = GroundObject.getWidgetClickMask(var9);
                                             var27 = (var28 >> 30 & 1) != 0;
                                             if(var27) {
                                                if((class110.field1607 & 16) == 16) {
                                                   TextureProvider.addMenuEntry(Client.field1092, Client.field1028 + " " + "->" + " " + class45.getColTags(16748608) + var26.name, 32, var26.id, var37, var9.id);
                                                }
                                                break label1333;
                                             }
                                          }

                                          String[] var40 = var26.inventoryActions;
                                          var28 = -1;
                                          if(Client.field981 && CombatInfo1.method1679()) {
                                             var28 = var26.getShiftClickActionIndex();
                                          }

                                          int var30 = GroundObject.getWidgetClickMask(var9);
                                          boolean var29 = (var30 >> 30 & 1) != 0;
                                          if(var29) {
                                             for(int var31 = 4; var31 >= 3; --var31) {
                                                if(var28 != var31) {
                                                   class110.method2272(var9, var26, var37, var31, false);
                                                }
                                             }
                                          }

                                          Object var10000 = null;
                                          if(class304.method5423(GroundObject.getWidgetClickMask(var9))) {
                                             TextureProvider.addMenuEntry("Use", class45.getColTags(16748608) + var26.name, 38, var26.id, var37, var9.id);
                                          }

                                          int var32 = GroundObject.getWidgetClickMask(var9);
                                          boolean var50 = (var32 >> 30 & 1) != 0;
                                          int var33;
                                          if(var50) {
                                             for(var33 = 2; var33 >= 0; --var33) {
                                                if(var33 != var28) {
                                                   class110.method2272(var9, var26, var37, var33, false);
                                                }
                                             }

                                             if(var28 >= 0) {
                                                class110.method2272(var9, var26, var37, var28, true);
                                             }
                                          }

                                          var40 = var9.configActions;
                                          if(var40 != null) {
                                             for(var33 = 4; var33 >= 0; --var33) {
                                                if(var40[var33] != null) {
                                                   byte var34 = 0;
                                                   if(var33 == 0) {
                                                      var34 = 39;
                                                   }

                                                   if(var33 == 1) {
                                                      var34 = 40;
                                                   }

                                                   if(var33 == 2) {
                                                      var34 = 41;
                                                   }

                                                   if(var33 == 3) {
                                                      var34 = 42;
                                                   }

                                                   if(var33 == 4) {
                                                      var34 = 43;
                                                   }

                                                   TextureProvider.addMenuEntry(var40[var33], class45.getColTags(16748608) + var26.name, var34, var26.id, var37, var9.id);
                                                }
                                             }
                                          }

                                          TextureProvider.addMenuEntry("Examine", class45.getColTags(16748608) + var26.name, 1005, var26.id, var37, var9.id);
                                       }
                                    }
                                 }

                                 ++var37;
                              }
                           }
                        }

                        if(var9.hasScript) {
                           if(Client.spellSelected) {
                              if(GroundObject.method2669(GroundObject.getWidgetClickMask(var9)) && (class110.field1607 & 32) == 32) {
                                 TextureProvider.addMenuEntry(Client.field1092, Client.field1028 + " " + "->" + " " + var9.opBase, 58, 0, var9.index, var9.id);
                              }
                           } else {
                              for(var37 = 9; var37 >= 5; --var37) {
                                 String var22;
                                 if(!DynamicObject.method2021(GroundObject.getWidgetClickMask(var9), var37) && var9.onOpListener == null) {
                                    var22 = null;
                                 } else if(var9.actions != null && var9.actions.length > var37 && var9.actions[var37] != null && var9.actions[var37].trim().length() != 0) {
                                    var22 = var9.actions[var37];
                                 } else {
                                    var22 = null;
                                 }

                                 if(var22 != null) {
                                    TextureProvider.addMenuEntry(var22, var9.opBase, 1007, var37 + 1, var9.index, var9.id);
                                 }
                              }

                              if(class250.method4502(GroundObject.getWidgetClickMask(var9)) == 0) {
                                 var21 = null;
                              } else if(var9.targetVerb != null && var9.targetVerb.trim().length() != 0) {
                                 var21 = var9.targetVerb;
                              } else {
                                 var21 = null;
                              }

                              if(var21 != null) {
                                 TextureProvider.addMenuEntry(var21, var9.opBase, 25, 0, var9.index, var9.id);
                              }

                              for(var23 = 4; var23 >= 0; --var23) {
                                 String var41;
                                 if(!DynamicObject.method2021(GroundObject.getWidgetClickMask(var9), var23) && var9.onOpListener == null) {
                                    var41 = null;
                                 } else if(var9.actions != null && var9.actions.length > var23 && var9.actions[var23] != null && var9.actions[var23].trim().length() != 0) {
                                    var41 = var9.actions[var23];
                                 } else {
                                    var41 = null;
                                 }

                                 if(var41 != null) {
                                    TextureProvider.addMenuEntry(var41, var9.opBase, 57, var23 + 1, var9.index, var9.id);
                                 }
                              }

                              var24 = GroundObject.getWidgetClickMask(var9);
                              boolean var49 = (var24 & 1) != 0;
                              if(var49) {
                                 TextureProvider.addMenuEntry("Continue", "", 30, 0, var9.index, var9.id);
                              }
                           }
                        }
                     }
                  }

                  boolean var46;
                  if(var9.type == 0) {
                     if(!var9.hasScript) {
                        var46 = var9.isHidden;
                        if(var46 && var9 != BoundingBox3D.field259) {
                           continue;
                        }
                     }

                     method5651(var0, var9.id, var12, var13, var14, var15, var43 - var9.scrollX, var11 - var9.scrollY);
                     if(var9.children != null) {
                        method5651(var9.children, var9.id, var12, var13, var14, var15, var43 - var9.scrollX, var11 - var9.scrollY);
                     }

                     WidgetNode var35 = (WidgetNode)Client.componentTable.get((long)var9.id);
                     if(var35 != null) {
                        if(var35.owner == 0 && MouseInput.mouseLastX >= var12 && MouseInput.mouseLastY >= var13 && MouseInput.mouseLastX < var14 && MouseInput.mouseLastY < var15 && !Client.isMenuOpen) {
                           for(ScriptEvent var36 = (ScriptEvent)Client.field1066.getFront(); var36 != null; var36 = (ScriptEvent)Client.field1066.getNext()) {
                              if(var36.boolean1) {
                                 var36.unlink();
                                 var36.widget.field2835 = false;
                              }
                           }

                           if(class55.field660 == 0) {
                              Client.draggedWidget = null;
                              Client.field937 = null;
                           }

                           if(!Client.isMenuOpen) {
                              Size.method198();
                           }
                        }

                        WorldMapData.method400(var35.id, var12, var13, var14, var15, var43, var11);
                     }
                  }

                  if(var9.hasScript) {
                     ScriptEvent var51;
                     if(!var9.noClickThrough) {
                        if(var9.noScrollThrough && MouseInput.mouseLastX >= var12 && MouseInput.mouseLastY >= var13 && MouseInput.mouseLastX < var14 && MouseInput.mouseLastY < var15) {
                           for(var51 = (ScriptEvent)Client.field1066.getFront(); var51 != null; var51 = (ScriptEvent)Client.field1066.getNext()) {
                              if(var51.boolean1 && var51.widget.onScrollWheelListener == var51.objs) {
                                 var51.unlink();
                              }
                           }
                        }
                     } else if(MouseInput.mouseLastX >= var12 && MouseInput.mouseLastY >= var13 && MouseInput.mouseLastX < var14 && MouseInput.mouseLastY < var15) {
                        for(var51 = (ScriptEvent)Client.field1066.getFront(); var51 != null; var51 = (ScriptEvent)Client.field1066.getNext()) {
                           if(var51.boolean1) {
                              var51.unlink();
                              var51.widget.field2835 = false;
                           }
                        }

                        if(class55.field660 == 0) {
                           Client.draggedWidget = null;
                           Client.field937 = null;
                        }

                        if(!Client.isMenuOpen) {
                           Size.method198();
                        }
                     }

                     if(MouseInput.mouseLastX >= var12 && MouseInput.mouseLastY >= var13 && MouseInput.mouseLastX < var14 && MouseInput.mouseLastY < var15) {
                        var44 = true;
                     } else {
                        var44 = false;
                     }

                     var46 = false;
                     if((MouseInput.mouseCurrentButton == 1 || !MapIconReference.middleMouseMovesCamera && MouseInput.mouseCurrentButton == 4) && var44) {
                        var46 = true;
                     }

                     boolean var45 = false;
                     if((MouseInput.mouseLastButton == 1 || !MapIconReference.middleMouseMovesCamera && MouseInput.mouseLastButton == 4) && MouseInput.mouseLastPressedX >= var12 && MouseInput.mouseLastPressedY >= var13 && MouseInput.mouseLastPressedX < var14 && MouseInput.mouseLastPressedY < var15) {
                        var45 = true;
                     }

                     if(var45) {
                        class27.method239(var9, MouseInput.mouseLastPressedX - var43, MouseInput.mouseLastPressedY - var11);
                     }

                     if(var9.contentType == 1400) {
                        Preferences.renderOverview.method6010(var16, var17, var44 & var46, var44 & var45);
                     }

                     if(Client.draggedWidget != null && var9 != Client.draggedWidget && var44) {
                        var38 = GroundObject.getWidgetClickMask(var9);
                        boolean var52 = (var38 >> 20 & 1) != 0;
                        if(var52) {
                           Client.draggedOnWidget = var9;
                        }
                     }

                     if(var9 == Client.field937) {
                        Client.field1053 = true;
                        Client.field1008 = var43;
                        Client.field1047 = var11;
                     }

                     if(var9.hasListener) {
                        ScriptEvent var48;
                        if(var44 && Client.mouseWheelRotation != 0 && var9.onScrollWheelListener != null) {
                           var48 = new ScriptEvent();
                           var48.boolean1 = true;
                           var48.widget = var9;
                           var48.field798 = Client.mouseWheelRotation;
                           var48.objs = var9.onScrollWheelListener;
                           Client.field1066.addFront(var48);
                        }

                        if(Client.draggedWidget != null || UrlRequest.field2137 != null || Client.isMenuOpen) {
                           var45 = false;
                           var46 = false;
                           var44 = false;
                        }

                        if(!var9.field2948 && var45) {
                           var9.field2948 = true;
                           if(var9.onClickListener != null) {
                              var48 = new ScriptEvent();
                              var48.boolean1 = true;
                              var48.widget = var9;
                              var48.field799 = MouseInput.mouseLastPressedX - var43;
                              var48.field798 = MouseInput.mouseLastPressedY - var11;
                              var48.objs = var9.onClickListener;
                              Client.field1066.addFront(var48);
                           }
                        }

                        if(var9.field2948 && var46 && var9.onClickRepeatListener != null) {
                           var48 = new ScriptEvent();
                           var48.boolean1 = true;
                           var48.widget = var9;
                           var48.field799 = MouseInput.mouseLastX - var43;
                           var48.field798 = MouseInput.mouseLastY - var11;
                           var48.objs = var9.onClickRepeatListener;
                           Client.field1066.addFront(var48);
                        }

                        if(var9.field2948 && !var46) {
                           var9.field2948 = false;
                           if(var9.onReleaseListener != null) {
                              var48 = new ScriptEvent();
                              var48.boolean1 = true;
                              var48.widget = var9;
                              var48.field799 = MouseInput.mouseLastX - var43;
                              var48.field798 = MouseInput.mouseLastY - var11;
                              var48.objs = var9.onReleaseListener;
                              Client.field1125.addFront(var48);
                           }
                        }

                        if(var46 && var9.onHoldListener != null) {
                           var48 = new ScriptEvent();
                           var48.boolean1 = true;
                           var48.widget = var9;
                           var48.field799 = MouseInput.mouseLastX - var43;
                           var48.field798 = MouseInput.mouseLastY - var11;
                           var48.objs = var9.onHoldListener;
                           Client.field1066.addFront(var48);
                        }

                        if(!var9.field2835 && var44) {
                           var9.field2835 = true;
                           if(var9.onMouseOverListener != null) {
                              var48 = new ScriptEvent();
                              var48.boolean1 = true;
                              var48.widget = var9;
                              var48.field799 = MouseInput.mouseLastX - var43;
                              var48.field798 = MouseInput.mouseLastY - var11;
                              var48.objs = var9.onMouseOverListener;
                              Client.field1066.addFront(var48);
                           }
                        }

                        if(var9.field2835 && var44 && var9.onMouseRepeatListener != null) {
                           var48 = new ScriptEvent();
                           var48.boolean1 = true;
                           var48.widget = var9;
                           var48.field799 = MouseInput.mouseLastX - var43;
                           var48.field798 = MouseInput.mouseLastY - var11;
                           var48.objs = var9.onMouseRepeatListener;
                           Client.field1066.addFront(var48);
                        }

                        if(var9.field2835 && !var44) {
                           var9.field2835 = false;
                           if(var9.onMouseLeaveListener != null) {
                              var48 = new ScriptEvent();
                              var48.boolean1 = true;
                              var48.widget = var9;
                              var48.field799 = MouseInput.mouseLastX - var43;
                              var48.field798 = MouseInput.mouseLastY - var11;
                              var48.objs = var9.onMouseLeaveListener;
                              Client.field1125.addFront(var48);
                           }
                        }

                        if(var9.onTimerListener != null) {
                           var48 = new ScriptEvent();
                           var48.widget = var9;
                           var48.objs = var9.onTimerListener;
                           Client.field1067.addFront(var48);
                        }

                        ScriptEvent var53;
                        if(var9.onVarTransmitListener != null && Client.field1054 > var9.field2950) {
                           if(var9.varTransmitTriggers != null && Client.field1054 - var9.field2950 <= 32) {
                              label999:
                              for(var37 = var9.field2950; var37 < Client.field1054; ++var37) {
                                 var38 = Client.field984[var37 & 31];

                                 for(var23 = 0; var23 < var9.varTransmitTriggers.length; ++var23) {
                                    if(var38 == var9.varTransmitTriggers[var23]) {
                                       var53 = new ScriptEvent();
                                       var53.widget = var9;
                                       var53.objs = var9.onVarTransmitListener;
                                       Client.field1066.addFront(var53);
                                       break label999;
                                    }
                                 }
                              }
                           } else {
                              var48 = new ScriptEvent();
                              var48.widget = var9;
                              var48.objs = var9.onVarTransmitListener;
                              Client.field1066.addFront(var48);
                           }

                           var9.field2950 = Client.field1054;
                        }

                        if(var9.onInvTransmitListener != null && Client.field1056 > var9.field2951) {
                           if(var9.invTransmitTriggers != null && Client.field1056 - var9.field2951 <= 32) {
                              label975:
                              for(var37 = var9.field2951; var37 < Client.field1056; ++var37) {
                                 var38 = Client.interfaceItemTriggers[var37 & 31];

                                 for(var23 = 0; var23 < var9.invTransmitTriggers.length; ++var23) {
                                    if(var38 == var9.invTransmitTriggers[var23]) {
                                       var53 = new ScriptEvent();
                                       var53.widget = var9;
                                       var53.objs = var9.onInvTransmitListener;
                                       Client.field1066.addFront(var53);
                                       break label975;
                                    }
                                 }
                              }
                           } else {
                              var48 = new ScriptEvent();
                              var48.widget = var9;
                              var48.objs = var9.onInvTransmitListener;
                              Client.field1066.addFront(var48);
                           }

                           var9.field2951 = Client.field1056;
                        }

                        if(var9.onStatTransmitListener != null && Client.field1052 > var9.field2856) {
                           if(var9.statTransmitTriggers != null && Client.field1052 - var9.field2856 <= 32) {
                              label951:
                              for(var37 = var9.field2856; var37 < Client.field1052; ++var37) {
                                 var38 = Client.field1057[var37 & 31];

                                 for(var23 = 0; var23 < var9.statTransmitTriggers.length; ++var23) {
                                    if(var38 == var9.statTransmitTriggers[var23]) {
                                       var53 = new ScriptEvent();
                                       var53.widget = var9;
                                       var53.objs = var9.onStatTransmitListener;
                                       Client.field1066.addFront(var53);
                                       break label951;
                                    }
                                 }
                              }
                           } else {
                              var48 = new ScriptEvent();
                              var48.widget = var9;
                              var48.objs = var9.onStatTransmitListener;
                              Client.field1066.addFront(var48);
                           }

                           var9.field2856 = Client.field1052;
                        }

                        if(Client.chatCycle > var9.field2949 && var9.onChatTransmitListener != null) {
                           var48 = new ScriptEvent();
                           var48.widget = var9;
                           var48.objs = var9.onChatTransmitListener;
                           Client.field1066.addFront(var48);
                        }

                        if(Client.field1060 > var9.field2949 && var9.onFriendTransmitListener != null) {
                           var48 = new ScriptEvent();
                           var48.widget = var9;
                           var48.objs = var9.onFriendTransmitListener;
                           Client.field1066.addFront(var48);
                        }

                        if(Client.field967 > var9.field2949 && var9.onClanTransmitListener != null) {
                           var48 = new ScriptEvent();
                           var48.widget = var9;
                           var48.objs = var9.onClanTransmitListener;
                           Client.field1066.addFront(var48);
                        }

                        if(Client.field1062 > var9.field2949 && var9.onStockTransmitListener != null) {
                           var48 = new ScriptEvent();
                           var48.widget = var9;
                           var48.objs = var9.onStockTransmitListener;
                           Client.field1066.addFront(var48);
                        }

                        if(Client.field1063 > var9.field2949 && var9.onCamFinishedListener != null) {
                           var48 = new ScriptEvent();
                           var48.widget = var9;
                           var48.objs = var9.onCamFinishedListener;
                           Client.field1066.addFront(var48);
                        }

                        if(Client.field1064 > var9.field2949 && var9.onMiscTransmitListener != null) {
                           var48 = new ScriptEvent();
                           var48.widget = var9;
                           var48.objs = var9.onMiscTransmitListener;
                           Client.field1066.addFront(var48);
                        }

                        var9.field2949 = Client.cycleCntr;
                        if(var9.onKeyListener != null) {
                           for(var37 = 0; var37 < Client.field952; ++var37) {
                              ScriptEvent var47 = new ScriptEvent();
                              var47.widget = var9;
                              var47.pressedKey = Client.field968[var37];
                              var47.typedKey = Client.field1089[var37];
                              var47.objs = var9.onKeyListener;
                              Client.field1066.addFront(var47);
                           }
                        }
                     }
                  }

                  if(!var9.hasScript && Client.draggedWidget == null && UrlRequest.field2137 == null && !Client.isMenuOpen) {
                     if((var9.field2937 >= 0 || var9.field2849 != 0) && MouseInput.mouseLastX >= var12 && MouseInput.mouseLastY >= var13 && MouseInput.mouseLastX < var14 && MouseInput.mouseLastY < var15) {
                        if(var9.field2937 >= 0) {
                           BoundingBox3D.field259 = var0[var9.field2937];
                        } else {
                           BoundingBox3D.field259 = var9;
                        }
                     }

                     if(var9.type == 8 && MouseInput.mouseLastX >= var12 && MouseInput.mouseLastY >= var13 && MouseInput.mouseLastX < var14 && MouseInput.mouseLastY < var15) {
                        class7.field234 = var9;
                     }

                     if(var9.scrollHeight > var9.height) {
                        GrandExchangeEvent.method90(var9, var43 + var9.width, var11, var9.height, var9.scrollHeight, MouseInput.mouseLastX, MouseInput.mouseLastY);
                     }
                  }
               }
            }
         }
      }

   }
}
