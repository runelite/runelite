import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hc")
public class class211 extends CacheableNode {
   @ObfuscatedName("r")
   public final int[] field2602;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -2147006807
   )
   public final int field2600;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -661971985
   )
   public final int field2599;
   @ObfuscatedName("a")
   public final int[] field2601;

   class211(int var1, int var2, int[] var3, int[] var4, int var5) {
      this.field2600 = var1;
      this.field2599 = var2;
      this.field2601 = var3;
      this.field2602 = var4;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(III)Z",
      garbageValue = "1325986525"
   )
   public boolean method3963(int var1, int var2) {
      if(var2 >= 0 && var2 < this.field2602.length) {
         int var3 = this.field2602[var2];
         if(var1 >= var3 && var1 <= var3 + this.field2601[var2]) {
            return true;
         }
      }

      return false;
   }

   @ObfuscatedName("im")
   @ObfuscatedSignature(
      signature = "([Lhx;IIIIIIIB)V",
      garbageValue = "96"
   )
   static final void method3962(Widget[] var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      for(int var8 = 0; var8 < var0.length; ++var8) {
         Widget var9 = var0[var8];
         if(var9 != null && (!var9.hasScript || var9.type == 0 || var9.field2785 || Coordinates.getWidgetConfig(var9) != 0 || var9 == Client.field1045 || var9.contentType == 1338) && var9.parentId == var1 && (!var9.hasScript || !WorldMapType2.method548(var9))) {
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

            if(var9 == Client.field1111) {
               Client.field1112 = true;
               Client.field1127 = var10;
               Client.field1114 = var11;
            }

            if(!var9.hasScript || var12 < var14 && var13 < var15) {
               var16 = MouseInput.field752;
               var17 = MouseInput.field747;
               if(MouseInput.field754 != 0) {
                  var16 = MouseInput.field753;
                  var17 = MouseInput.field739;
               }

               boolean var44 = var16 >= var12 && var17 >= var13 && var16 < var14 && var17 < var15;
               if(var9.contentType == 1337) {
                  if(!Client.field1100 && !Client.isMenuOpen && var44) {
                     class48.method775(var16, var17, var12, var13);
                  }
               } else if(var9.contentType == 1338) {
                  class44.method666(var9, var10, var11);
               } else {
                  if(var9.contentType == 1400) {
                     KeyFocusListener.renderOverview.method5159(MouseInput.field752, MouseInput.field747, var44, var10, var11, var9.width, var9.height);
                  }

                  int var20;
                  int var22;
                  int var23;
                  int var39;
                  if(!Client.isMenuOpen && var44) {
                     if(var9.contentType == 1400) {
                        KeyFocusListener.renderOverview.method5216(var10, var11, var9.width, var9.height, var16, var17);
                     } else {
                        var19 = var16 - var10;
                        var20 = var17 - var11;
                        if(var9.field2661 == 1) {
                           class36.addMenuEntry(var9.tooltip, "", 24, 0, 0, var9.id);
                        }

                        String var21;
                        if(var9.field2661 == 2 && !Client.spellSelected) {
                           var21 = AbstractByteBuffer.method3468(var9);
                           if(var21 != null) {
                              class36.addMenuEntry(var21, Friend.getColTags('\uff00') + var9.field2774, 25, 0, -1, var9.id);
                           }
                        }

                        if(var9.field2661 == 3) {
                           class36.addMenuEntry("Close", "", 26, 0, 0, var9.id);
                        }

                        if(var9.field2661 == 4) {
                           class36.addMenuEntry(var9.tooltip, "", 28, 0, 0, var9.id);
                        }

                        if(var9.field2661 == 5) {
                           class36.addMenuEntry(var9.tooltip, "", 29, 0, 0, var9.id);
                        }

                        if(var9.field2661 == 6 && Client.field1086 == null) {
                           class36.addMenuEntry(var9.tooltip, "", 30, 0, -1, var9.id);
                        }

                        if(var9.type == 2) {
                           var39 = 0;

                           for(var22 = 0; var22 < var9.height; ++var22) {
                              for(var23 = 0; var23 < var9.width; ++var23) {
                                 int var24 = var23 * (var9.paddingX + 32);
                                 int var25 = (var9.paddingY + 32) * var22;
                                 if(var39 < 20) {
                                    var24 += var9.xSprites[var39];
                                    var25 += var9.field2728[var39];
                                 }

                                 if(var19 >= var24 && var20 >= var25 && var19 < var24 + 32 && var20 < var25 + 32) {
                                    Client.field1133 = var39;
                                    class11.field278 = var9;
                                    if(var9.itemIds[var39] > 0) {
                                       label1283: {
                                          ItemComposition var26 = class169.getItemDefinition(var9.itemIds[var39] - 1);
                                          boolean var27;
                                          int var28;
                                          if(Client.itemSelectionState == 1) {
                                             var28 = Coordinates.getWidgetConfig(var9);
                                             var27 = (var28 >> 30 & 1) != 0;
                                             if(var27) {
                                                if(var9.id != class48.field626 || var39 != class56.selectedItemIndex) {
                                                   class36.addMenuEntry("Use", Client.field1085 + " " + "->" + " " + Friend.getColTags(16748608) + var26.name, 31, var26.id, var39, var9.id);
                                                }
                                                break label1283;
                                             }
                                          }

                                          if(Client.spellSelected) {
                                             var28 = Coordinates.getWidgetConfig(var9);
                                             var27 = (var28 >> 30 & 1) != 0;
                                             if(var27) {
                                                if((class67.field845 & 16) == 16) {
                                                   class36.addMenuEntry(Client.field1089, Client.field1090 + " " + "->" + " " + Friend.getColTags(16748608) + var26.name, 32, var26.id, var39, var9.id);
                                                }
                                                break label1283;
                                             }
                                          }

                                          String[] var40 = var26.inventoryActions;
                                          if(Client.field1102) {
                                             var40 = class171.method3220(var40);
                                          }

                                          var28 = -1;
                                          if(Client.field969 && KeyFocusListener.field651[81]) {
                                             var28 = var26.method4563();
                                          }

                                          int var30 = Coordinates.getWidgetConfig(var9);
                                          boolean var29 = (var30 >> 30 & 1) != 0;
                                          if(var29) {
                                             for(int var31 = 4; var31 >= 3; --var31) {
                                                if(var31 != var28) {
                                                   FrameMap.method2709(var9, var26, var39, var31, false);
                                                }
                                             }
                                          }

                                          int var32 = Coordinates.getWidgetConfig(var9);
                                          boolean var49 = (var32 >> 31 & 1) != 0;
                                          if(var49) {
                                             class36.addMenuEntry("Use", Friend.getColTags(16748608) + var26.name, 38, var26.id, var39, var9.id);
                                          }

                                          int var34 = Coordinates.getWidgetConfig(var9);
                                          boolean var33 = (var34 >> 30 & 1) != 0;
                                          int var35;
                                          if(var33) {
                                             for(var35 = 2; var35 >= 0; --var35) {
                                                if(var28 != var35) {
                                                   FrameMap.method2709(var9, var26, var39, var35, false);
                                                }
                                             }

                                             if(var28 >= 0) {
                                                FrameMap.method2709(var9, var26, var39, var28, true);
                                             }
                                          }

                                          var40 = var9.configActions;
                                          if(Client.field1102) {
                                             var40 = class171.method3220(var40);
                                          }

                                          if(var40 != null) {
                                             for(var35 = 4; var35 >= 0; --var35) {
                                                if(var40[var35] != null) {
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

                                                   class36.addMenuEntry(var40[var35], Friend.getColTags(16748608) + var26.name, var36, var26.id, var39, var9.id);
                                                }
                                             }
                                          }

                                          class36.addMenuEntry("Examine", Friend.getColTags(16748608) + var26.name, 1005, var26.id, var39, var9.id);
                                       }
                                    }
                                 }

                                 ++var39;
                              }
                           }
                        }

                        if(var9.hasScript) {
                           if(Client.spellSelected) {
                              if(WorldMapType1.method280(Coordinates.getWidgetConfig(var9)) && (class67.field845 & 32) == 32) {
                                 class36.addMenuEntry(Client.field1089, Client.field1090 + " " + "->" + " " + var9.name, 58, 0, var9.index, var9.id);
                              }
                           } else {
                              for(var39 = 9; var39 >= 5; --var39) {
                                 String var41 = class148.method2953(var9, var39);
                                 if(var41 != null) {
                                    class36.addMenuEntry(var41, var9.name, 1007, var39 + 1, var9.index, var9.id);
                                 }
                              }

                              var21 = AbstractByteBuffer.method3468(var9);
                              if(var21 != null) {
                                 class36.addMenuEntry(var21, var9.name, 25, 0, var9.index, var9.id);
                              }

                              for(var22 = 4; var22 >= 0; --var22) {
                                 String var43 = class148.method2953(var9, var22);
                                 if(var43 != null) {
                                    class36.addMenuEntry(var43, var9.name, 57, var22 + 1, var9.index, var9.id);
                                 }
                              }

                              var23 = Coordinates.getWidgetConfig(var9);
                              boolean var48 = (var23 & 1) != 0;
                              if(var48) {
                                 class36.addMenuEntry("Continue", "", 30, 0, var9.index, var9.id);
                              }
                           }
                        }
                     }
                  }

                  if(var9.type == 0) {
                     if(!var9.hasScript && WorldMapType2.method548(var9) && var9 != class56.field696) {
                        continue;
                     }

                     method3962(var0, var9.id, var12, var13, var14, var15, var10 - var9.scrollX, var11 - var9.scrollY);
                     if(var9.children != null) {
                        method3962(var9.children, var9.id, var12, var13, var14, var15, var10 - var9.scrollX, var11 - var9.scrollY);
                     }

                     WidgetNode var37 = (WidgetNode)Client.componentTable.get((long)var9.id);
                     if(var37 != null) {
                        if(var37.owner == 0 && MouseInput.field752 >= var12 && MouseInput.field747 >= var13 && MouseInput.field752 < var14 && MouseInput.field747 < var15 && !Client.isMenuOpen && !Client.field1101) {
                           for(ScriptEvent var38 = (ScriptEvent)Client.field1130.getFront(); var38 != null; var38 = (ScriptEvent)Client.field1130.getNext()) {
                              if(var38.field866) {
                                 var38.unlink();
                                 var38.widget.field2769 = false;
                              }
                           }

                           if(class54.field682 == 0) {
                              Client.field1111 = null;
                              Client.field1045 = null;
                           }

                           if(!Client.isMenuOpen) {
                              GraphicsObject.method1675();
                           }
                        }

                        var20 = var37.id;
                        if(class13.loadWidget(var20)) {
                           method3962(class268.widgets[var20], -1, var12, var13, var14, var15, var10, var11);
                        }
                     }
                  }

                  if(var9.hasScript) {
                     ScriptEvent var50;
                     if(!var9.field2654) {
                        if(var9.field2792 && MouseInput.field752 >= var12 && MouseInput.field747 >= var13 && MouseInput.field752 < var14 && MouseInput.field747 < var15) {
                           for(var50 = (ScriptEvent)Client.field1130.getFront(); var50 != null; var50 = (ScriptEvent)Client.field1130.getNext()) {
                              if(var50.field866 && var50.widget.scrollListener == var50.field864) {
                                 var50.unlink();
                              }
                           }
                        }
                     } else if(MouseInput.field752 >= var12 && MouseInput.field747 >= var13 && MouseInput.field752 < var14 && MouseInput.field747 < var15) {
                        for(var50 = (ScriptEvent)Client.field1130.getFront(); var50 != null; var50 = (ScriptEvent)Client.field1130.getNext()) {
                           if(var50.field866) {
                              var50.unlink();
                              var50.widget.field2769 = false;
                           }
                        }

                        if(class54.field682 == 0) {
                           Client.field1111 = null;
                           Client.field1045 = null;
                        }

                        if(!Client.isMenuOpen) {
                           GraphicsObject.method1675();
                        }
                     }

                     if(MouseInput.field752 >= var12 && MouseInput.field747 >= var13 && MouseInput.field752 < var14 && MouseInput.field747 < var15) {
                        var44 = true;
                     } else {
                        var44 = false;
                     }

                     boolean var45 = false;
                     if((MouseInput.field745 == 1 || !Client.field951 && MouseInput.field745 == 4) && var44) {
                        var45 = true;
                     }

                     boolean var46 = false;
                     if((MouseInput.field754 == 1 || !Client.field951 && MouseInput.field754 == 4) && MouseInput.field753 >= var12 && MouseInput.field739 >= var13 && MouseInput.field753 < var14 && MouseInput.field739 < var15) {
                        var46 = true;
                     }

                     if(var46) {
                        VertexNormal.method2614(var9, MouseInput.field753 - var10, MouseInput.field739 - var11);
                     }

                     if(var9.contentType == 1400) {
                        KeyFocusListener.renderOverview.method5160(MouseInput.field752, MouseInput.field747, var44 & var45);
                     }

                     if(Client.field1111 != null && var9 != Client.field1111 && var44) {
                        var22 = Coordinates.getWidgetConfig(var9);
                        boolean var51 = (var22 >> 20 & 1) != 0;
                        if(var51) {
                           Client.field1108 = var9;
                        }
                     }

                     if(var9 == Client.field1045) {
                        Client.field1209 = true;
                        Client.field1011 = var10;
                        Client.field1182 = var11;
                     }

                     if(var9.field2785) {
                        ScriptEvent var47;
                        if(var44 && Client.field1129 != 0 && var9.scrollListener != null) {
                           var47 = new ScriptEvent();
                           var47.field866 = true;
                           var47.widget = var9;
                           var47.field860 = Client.field1129;
                           var47.field864 = var9.scrollListener;
                           Client.field1130.addFront(var47);
                        }

                        if(Client.field1111 != null || class18.field325 != null || Client.isMenuOpen) {
                           var46 = false;
                           var45 = false;
                           var44 = false;
                        }

                        if(!var9.field2784 && var46) {
                           var9.field2784 = true;
                           if(var9.field2669 != null) {
                              var47 = new ScriptEvent();
                              var47.field866 = true;
                              var47.widget = var9;
                              var47.field859 = MouseInput.field753 - var10;
                              var47.field860 = MouseInput.field739 - var11;
                              var47.field864 = var9.field2669;
                              Client.field1130.addFront(var47);
                           }
                        }

                        if(var9.field2784 && var45 && var9.field2744 != null) {
                           var47 = new ScriptEvent();
                           var47.field866 = true;
                           var47.widget = var9;
                           var47.field859 = MouseInput.field752 - var10;
                           var47.field860 = MouseInput.field747 - var11;
                           var47.field864 = var9.field2744;
                           Client.field1130.addFront(var47);
                        }

                        if(var9.field2784 && !var45) {
                           var9.field2784 = false;
                           if(var9.field2711 != null) {
                              var47 = new ScriptEvent();
                              var47.field866 = true;
                              var47.widget = var9;
                              var47.field859 = MouseInput.field752 - var10;
                              var47.field860 = MouseInput.field747 - var11;
                              var47.field864 = var9.field2711;
                              Client.field1132.addFront(var47);
                           }
                        }

                        if(var45 && var9.field2742 != null) {
                           var47 = new ScriptEvent();
                           var47.field866 = true;
                           var47.widget = var9;
                           var47.field859 = MouseInput.field752 - var10;
                           var47.field860 = MouseInput.field747 - var11;
                           var47.field864 = var9.field2742;
                           Client.field1130.addFront(var47);
                        }

                        if(!var9.field2769 && var44) {
                           var9.field2769 = true;
                           if(var9.mouseEnterListener != null) {
                              var47 = new ScriptEvent();
                              var47.field866 = true;
                              var47.widget = var9;
                              var47.field859 = MouseInput.field752 - var10;
                              var47.field860 = MouseInput.field747 - var11;
                              var47.field864 = var9.mouseEnterListener;
                              Client.field1130.addFront(var47);
                           }
                        }

                        if(var9.field2769 && var44 && var9.mouseHoverListener != null) {
                           var47 = new ScriptEvent();
                           var47.field866 = true;
                           var47.widget = var9;
                           var47.field859 = MouseInput.field752 - var10;
                           var47.field860 = MouseInput.field747 - var11;
                           var47.field864 = var9.mouseHoverListener;
                           Client.field1130.addFront(var47);
                        }

                        if(var9.field2769 && !var44) {
                           var9.field2769 = false;
                           if(var9.mouseExitListener != null) {
                              var47 = new ScriptEvent();
                              var47.field866 = true;
                              var47.widget = var9;
                              var47.field859 = MouseInput.field752 - var10;
                              var47.field860 = MouseInput.field747 - var11;
                              var47.field864 = var9.mouseExitListener;
                              Client.field1132.addFront(var47);
                           }
                        }

                        if(var9.renderListener != null) {
                           var47 = new ScriptEvent();
                           var47.widget = var9;
                           var47.field864 = var9.renderListener;
                           Client.field1000.addFront(var47);
                        }

                        ScriptEvent var42;
                        if(var9.configListenerArgs != null && Client.field981 > var9.field2748) {
                           if(var9.configTriggers != null && Client.field981 - var9.field2748 <= 32) {
                              label987:
                              for(var39 = var9.field2748; var39 < Client.field981; ++var39) {
                                 var22 = Client.field1022[var39 & 31];

                                 for(var23 = 0; var23 < var9.configTriggers.length; ++var23) {
                                    if(var22 == var9.configTriggers[var23]) {
                                       var42 = new ScriptEvent();
                                       var42.widget = var9;
                                       var42.field864 = var9.configListenerArgs;
                                       Client.field1130.addFront(var42);
                                       break label987;
                                    }
                                 }
                              }
                           } else {
                              var47 = new ScriptEvent();
                              var47.widget = var9;
                              var47.field864 = var9.configListenerArgs;
                              Client.field1130.addFront(var47);
                           }

                           var9.field2748 = Client.field981;
                        }

                        if(var9.tableListenerArgs != null && Client.field1120 > var9.field2787) {
                           if(var9.tableModTriggers != null && Client.field1120 - var9.field2787 <= 32) {
                              label963:
                              for(var39 = var9.field2787; var39 < Client.field1120; ++var39) {
                                 var22 = Client.interfaceItemTriggers[var39 & 31];

                                 for(var23 = 0; var23 < var9.tableModTriggers.length; ++var23) {
                                    if(var22 == var9.tableModTriggers[var23]) {
                                       var42 = new ScriptEvent();
                                       var42.widget = var9;
                                       var42.field864 = var9.tableListenerArgs;
                                       Client.field1130.addFront(var42);
                                       break label963;
                                    }
                                 }
                              }
                           } else {
                              var47 = new ScriptEvent();
                              var47.widget = var9;
                              var47.field864 = var9.tableListenerArgs;
                              Client.field1130.addFront(var47);
                           }

                           var9.field2787 = Client.field1120;
                        }

                        if(var9.skillListenerArgs != null && Client.field1122 > var9.field2672) {
                           if(var9.skillTriggers != null && Client.field1122 - var9.field2672 <= 32) {
                              label939:
                              for(var39 = var9.field2672; var39 < Client.field1122; ++var39) {
                                 var22 = Client.field1121[var39 & 31];

                                 for(var23 = 0; var23 < var9.skillTriggers.length; ++var23) {
                                    if(var22 == var9.skillTriggers[var23]) {
                                       var42 = new ScriptEvent();
                                       var42.widget = var9;
                                       var42.field864 = var9.skillListenerArgs;
                                       Client.field1130.addFront(var42);
                                       break label939;
                                    }
                                 }
                              }
                           } else {
                              var47 = new ScriptEvent();
                              var47.widget = var9;
                              var47.field864 = var9.skillListenerArgs;
                              Client.field1130.addFront(var47);
                           }

                           var9.field2672 = Client.field1122;
                        }

                        if(Client.chatCycle > var9.field2705 && var9.field2760 != null) {
                           var47 = new ScriptEvent();
                           var47.widget = var9;
                           var47.field864 = var9.field2760;
                           Client.field1130.addFront(var47);
                        }

                        if(Client.field1124 > var9.field2705 && var9.field2762 != null) {
                           var47 = new ScriptEvent();
                           var47.widget = var9;
                           var47.field864 = var9.field2762;
                           Client.field1130.addFront(var47);
                        }

                        if(Client.field1125 > var9.field2705 && var9.field2763 != null) {
                           var47 = new ScriptEvent();
                           var47.widget = var9;
                           var47.field864 = var9.field2763;
                           Client.field1130.addFront(var47);
                        }

                        if(Client.field974 > var9.field2705 && var9.field2768 != null) {
                           var47 = new ScriptEvent();
                           var47.widget = var9;
                           var47.field864 = var9.field2768;
                           Client.field1130.addFront(var47);
                        }

                        if(Client.field1116 > var9.field2705 && var9.field2737 != null) {
                           var47 = new ScriptEvent();
                           var47.widget = var9;
                           var47.field864 = var9.field2737;
                           Client.field1130.addFront(var47);
                        }

                        if(Client.field1146 > var9.field2705 && var9.field2790 != null) {
                           var47 = new ScriptEvent();
                           var47.widget = var9;
                           var47.field864 = var9.field2790;
                           Client.field1130.addFront(var47);
                        }

                        var9.field2705 = Client.cycleCntr;
                        if(var9.field2648 != null) {
                           for(var39 = 0; var39 < Client.field1153; ++var39) {
                              ScriptEvent var52 = new ScriptEvent();
                              var52.widget = var9;
                              var52.field856 = Client.field1131[var39];
                              var52.field857 = Client.field1154[var39];
                              var52.field864 = var9.field2648;
                              Client.field1130.addFront(var52);
                           }
                        }
                     }
                  }

                  if(!var9.hasScript && Client.field1111 == null && class18.field325 == null && !Client.isMenuOpen) {
                     if((var9.field2727 >= 0 || var9.field2646 != 0) && MouseInput.field752 >= var12 && MouseInput.field747 >= var13 && MouseInput.field752 < var14 && MouseInput.field747 < var15) {
                        if(var9.field2727 >= 0) {
                           class56.field696 = var0[var9.field2727];
                        } else {
                           class56.field696 = var9;
                        }
                     }

                     if(var9.type == 8 && MouseInput.field752 >= var12 && MouseInput.field747 >= var13 && MouseInput.field752 < var14 && MouseInput.field747 < var15) {
                        class48.field629 = var9;
                     }

                     if(var9.scrollHeight > var9.height) {
                        KeyFocusListener.method813(var9, var10 + var9.width, var11, var9.height, var9.scrollHeight, MouseInput.field752, MouseInput.field747);
                     }
                  }
               }
            }
         }
      }

   }
}
