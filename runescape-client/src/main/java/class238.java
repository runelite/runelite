import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("il")
public final class class238 {
   @ObfuscatedName("dw")
   @ObfuscatedSignature(
      signature = "Lit;"
   )
   @Export("indexCache9")
   static IndexCache indexCache9;

   @ObfuscatedName("im")
   @ObfuscatedSignature(
      signature = "(Lho;I)Z",
      garbageValue = "188151075"
   )
   @Export("runCs1")
   static final boolean runCs1(Widget var0) {
      if (var0.cs1Comparisons == null) {
         return false;
      } else {
         for (int var1 = 0; var1 < var0.cs1Comparisons.length; ++var1) {
            int var2 = class16.method187(var0, var1);
            int var3 = var0.cs1ComparisonValues[var1];
            if (var0.cs1Comparisons[var1] == 2) {
               if (var2 >= var3) {
                  return false;
               }
            } else if (var0.cs1Comparisons[var1] == 3) {
               if (var2 <= var3) {
                  return false;
               }
            } else if (var0.cs1Comparisons[var1] == 4) {
               if (var2 == var3) {
                  return false;
               }
            } else if (var3 != var2) {
               return false;
            }
         }

         return true;
      }
   }

   @ObfuscatedName("jr")
   @ObfuscatedSignature(
      signature = "([Lho;IIIIIIII)V",
      garbageValue = "1706481742"
   )
   @Export("updateWidgetGroup")
   static final void updateWidgetGroup(Widget[] var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      for (int var8 = 0; var8 < var0.length; ++var8) {
         Widget var9 = var0[var8];
         if (var9 != null && var9.parentId == var1 && (!var9.isIf3 || var9.type == 0 || var9.hasListener || class1.getWidgetClickMask(var9) != 0 || var9 == Client.clickedWidgetParent || var9.contentType == 1338)) {
            if (var9.isIf3) {
               if (PacketBufferNode.method3673(var9)) {
                  continue;
               }
            } else if (var9.type == 0 && var9 != Clock.mousedOverWidgetIf1 && PacketBufferNode.method3673(var9)) {
               continue;
            }

            int var10 = var9.x + var6;
            int var11 = var7 + var9.y;
            int var12;
            int var13;
            int var14;
            int var15;
            int var16;
            int var17;
            if (var9.type == 2) {
               var12 = var2;
               var13 = var3;
               var14 = var4;
               var15 = var5;
            } else {
               int var18;
               if (var9.type == 9) {
                  var18 = var10;
                  var16 = var11;
                  var17 = var10 + var9.width;
                  int var19 = var11 + var9.height;
                  if (var17 < var10) {
                     var18 = var17;
                     var17 = var10;
                  }

                  if (var19 < var11) {
                     var16 = var19;
                     var19 = var11;
                  }

                  ++var17;
                  ++var19;
                  var12 = var18 > var2 ? var18 : var2;
                  var13 = var16 > var3 ? var16 : var3;
                  var14 = var17 < var4 ? var17 : var4;
                  var15 = var19 < var5 ? var19 : var5;
               } else {
                  var18 = var10 + var9.width;
                  var16 = var11 + var9.height;
                  var12 = var10 > var2 ? var10 : var2;
                  var13 = var11 > var3 ? var11 : var3;
                  var14 = var18 < var4 ? var18 : var4;
                  var15 = var16 < var5 ? var16 : var5;
               }
            }

            if (var9 == Client.clickedWidget) {
               Client.field103 = true;
               Client.field110 = var10;
               Client.field111 = var11;
            }

            boolean var28 = false;
            if (var9.field965) {
               switch(Client.field151) {
               case 0:
                  var28 = true;
               case 1:
               default:
                  break;
               case 2:
                  if (Client.field153 == var9.id >>> 16) {
                     var28 = true;
                  }
                  break;
               case 3:
                  if (var9.id == Client.field153) {
                     var28 = true;
                  }
               }
            }

            if (var28 || !var9.isIf3 || var12 < var14 && var13 < var15) {
               if (var9.isIf3) {
                  ScriptEvent var29;
                  if (var9.noClickThrough) {
                     if (MouseHandler.MouseHandler_x >= var12 && MouseHandler.MouseHandler_y >= var13 && MouseHandler.MouseHandler_x < var14 && MouseHandler.MouseHandler_y < var15) {
                        for (var29 = (ScriptEvent)Client.scriptEvents.last(); var29 != null; var29 = (ScriptEvent)Client.scriptEvents.previous()) {
                           if (var29.boolean1) {
                              var29.remove();
                              var29.widget.field978 = false;
                           }
                        }

                        if (MouseRecorder.widgetDragDuration == 0) {
                           Client.clickedWidget = null;
                           Client.clickedWidgetParent = null;
                        }

                        if (!Client.isMenuOpen) {
                           class30.resetMenuEntries();
                        }
                     }
                  } else if (var9.noScrollThrough && MouseHandler.MouseHandler_x >= var12 && MouseHandler.MouseHandler_y >= var13 && MouseHandler.MouseHandler_x < var14 && MouseHandler.MouseHandler_y < var15) {
                     for (var29 = (ScriptEvent)Client.scriptEvents.last(); var29 != null; var29 = (ScriptEvent)Client.scriptEvents.previous()) {
                        if (var29.boolean1 && var29.widget.onScroll == var29.args0) {
                           var29.remove();
                        }
                     }
                  }
               }

               var16 = MouseHandler.MouseHandler_x;
               var17 = MouseHandler.MouseHandler_y;
               if (MouseHandler.MouseHandler_lastButton != 0) {
                  var16 = MouseHandler.MouseHandler_lastPressedX;
                  var17 = MouseHandler.MouseHandler_lastPressedY;
               }

               boolean var30 = var16 >= var12 && var17 >= var13 && var16 < var14 && var17 < var15;
               if (var9.contentType == 1337) {
                  if (!Client.isLoading && !Client.isMenuOpen && var30) {
                     WorldMapEvent.addSceneMenuOptions(var16, var17, var12, var13);
                  }
               } else if (var9.contentType == 1338) {
                  WorldMapRegion.method567(var9, var10, var11);
               } else {
                  if (var9.contentType == 1400) {
                     class60.worldMap0.onCycle(MouseHandler.MouseHandler_x, MouseHandler.MouseHandler_y, var30, var10, var11, var9.width, var9.height);
                  }

                  if (!Client.isMenuOpen && var30) {
                     if (var9.contentType == 1400) {
                        class60.worldMap0.method384(var10, var11, var9.width, var9.height, var16, var17);
                     } else {
                        ChatChannel.method2237(var9, var16 - var10, var17 - var11);
                     }
                  }

                  boolean var20;
                  int var21;
                  if (var28) {
                     for (int var22 = 0; var22 < var9.field966.length; ++var22) {
                        var20 = false;
                        boolean var23 = false;
                        if (!var20 && var9.field966[var22] != null) {
                           for (var21 = 0; var21 < var9.field966[var22].length; ++var21) {
                              boolean var24 = false;
                              if (var9.field984 != null) {
                                 var24 = KeyHandler.KeyHandler_pressedKeys[var9.field966[var22][var21]];
                              }

                              if (class1.method15(var9.field966[var22][var21]) || var24) {
                                 var20 = true;
                                 if (var9.field984 != null && var9.field984[var22] > Client.cycle) {
                                    break;
                                 }

                                 byte var25 = var9.field967[var22][var21];
                                 if (var25 == 0 || ((var25 & 8) == 0 || !KeyHandler.KeyHandler_pressedKeys[86] && !KeyHandler.KeyHandler_pressedKeys[82] && !KeyHandler.KeyHandler_pressedKeys[81]) && ((var25 & 2) == 0 || KeyHandler.KeyHandler_pressedKeys[86]) && ((var25 & 1) == 0 || KeyHandler.KeyHandler_pressedKeys[82]) && ((var25 & 4) == 0 || KeyHandler.KeyHandler_pressedKeys[81])) {
                                    var23 = true;
                                    break;
                                 }
                              }
                           }
                        }

                        if (var23) {
                           if (var22 < 10) {
                              class171.method3494(var22 + 1, var9.id, var9.childIndex, var9.itemId, "");
                           } else if (var22 == 10) {
                              Player.method1281();
                              WorldMapDecoration.method350(var9.id, var9.childIndex, class211.method4107(class1.getWidgetClickMask(var9)), var9.itemId);
                              Client.selectedSpellActionName = class198.method3745(var9);
                              if (Client.selectedSpellActionName == null) {
                                 Client.selectedSpellActionName = "null";
                              }

                              Client.selectedSpellName = var9.dataText + BufferedFile.colorStartTag(16777215);
                           }

                           var21 = var9.field968[var22];
                           if (var9.field984 == null) {
                              var9.field984 = new int[var9.field966.length];
                           }

                           if (var9.field969 == null) {
                              var9.field969 = new int[var9.field966.length];
                           }

                           if (var21 != 0) {
                              if (var9.field984[var22] == 0) {
                                 var9.field984[var22] = var21 + Client.cycle + var9.field969[var22];
                              } else {
                                 var9.field984[var22] = var21 + Client.cycle;
                              }
                           } else {
                              var9.field984[var22] = Integer.MAX_VALUE;
                           }
                        }

                        if (!var20 && var9.field984 != null) {
                           var9.field984[var22] = 0;
                        }
                     }
                  }

                  ScriptEvent var32;
                  if (var9.isIf3) {
                     if (MouseHandler.MouseHandler_x >= var12 && MouseHandler.MouseHandler_y >= var13 && MouseHandler.MouseHandler_x < var14 && MouseHandler.MouseHandler_y < var15) {
                        var30 = true;
                     } else {
                        var30 = false;
                     }

                     boolean var31 = false;
                     if ((MouseHandler.MouseHandler_currentButton == 1 || !AbstractRasterProvider.mouseCam && MouseHandler.MouseHandler_currentButton == 4) && var30) {
                        var31 = true;
                     }

                     var20 = false;
                     if ((MouseHandler.MouseHandler_lastButton == 1 || !AbstractRasterProvider.mouseCam && MouseHandler.MouseHandler_lastButton == 4) && MouseHandler.MouseHandler_lastPressedX >= var12 && MouseHandler.MouseHandler_lastPressedY >= var13 && MouseHandler.MouseHandler_lastPressedX < var14 && MouseHandler.MouseHandler_lastPressedY < var15) {
                        var20 = true;
                     }

                     if (var20) {
                        Players.clickWidget(var9, MouseHandler.MouseHandler_lastPressedX - var10, MouseHandler.MouseHandler_lastPressedY - var11);
                     }

                     if (var9.contentType == 1400) {
                        class60.worldMap0.method361(var16, var17, var30 & var31, var30 & var20);
                     }

                     if (Client.clickedWidget != null && var9 != Client.clickedWidget && var30 && class54.method1090(class1.getWidgetClickMask(var9))) {
                        Client.draggedOnWidget = var9;
                     }

                     if (var9 == Client.clickedWidgetParent) {
                        Client.field106 = true;
                        Client.field108 = var10;
                        Client.field109 = var11;
                     }

                     if (var9.hasListener) {
                        if (var30 && Client.mouseWheelRotation != 0 && var9.onScroll != null) {
                           var32 = new ScriptEvent();
                           var32.boolean1 = true;
                           var32.widget = var9;
                           var32.mouseY = Client.mouseWheelRotation;
                           var32.args0 = var9.onScroll;
                           Client.scriptEvents.addFirst(var32);
                        }

                        if (Client.clickedWidget != null || DevicePcmPlayerProvider.dragInventoryWidget != null || Client.isMenuOpen) {
                           var20 = false;
                           var31 = false;
                           var30 = false;
                        }

                        if (!var9.field979 && var20) {
                           var9.field979 = true;
                           if (var9.onClick != null) {
                              var32 = new ScriptEvent();
                              var32.boolean1 = true;
                              var32.widget = var9;
                              var32.mouseX = MouseHandler.MouseHandler_lastPressedX - var10;
                              var32.mouseY = MouseHandler.MouseHandler_lastPressedY - var11;
                              var32.args0 = var9.onClick;
                              Client.scriptEvents.addFirst(var32);
                           }
                        }

                        if (var9.field979 && var31 && var9.onClickRepeat != null) {
                           var32 = new ScriptEvent();
                           var32.boolean1 = true;
                           var32.widget = var9;
                           var32.mouseX = MouseHandler.MouseHandler_x - var10;
                           var32.mouseY = MouseHandler.MouseHandler_y - var11;
                           var32.args0 = var9.onClickRepeat;
                           Client.scriptEvents.addFirst(var32);
                        }

                        if (var9.field979 && !var31) {
                           var9.field979 = false;
                           if (var9.onRelease != null) {
                              var32 = new ScriptEvent();
                              var32.boolean1 = true;
                              var32.widget = var9;
                              var32.mouseX = MouseHandler.MouseHandler_x - var10;
                              var32.mouseY = MouseHandler.MouseHandler_y - var11;
                              var32.args0 = var9.onRelease;
                              Client.field148.addFirst(var32);
                           }
                        }

                        if (var31 && var9.onHold != null) {
                           var32 = new ScriptEvent();
                           var32.boolean1 = true;
                           var32.widget = var9;
                           var32.mouseX = MouseHandler.MouseHandler_x - var10;
                           var32.mouseY = MouseHandler.MouseHandler_y - var11;
                           var32.args0 = var9.onHold;
                           Client.scriptEvents.addFirst(var32);
                        }

                        if (!var9.field978 && var30) {
                           var9.field978 = true;
                           if (var9.onMouseOver != null) {
                              var32 = new ScriptEvent();
                              var32.boolean1 = true;
                              var32.widget = var9;
                              var32.mouseX = MouseHandler.MouseHandler_x - var10;
                              var32.mouseY = MouseHandler.MouseHandler_y - var11;
                              var32.args0 = var9.onMouseOver;
                              Client.scriptEvents.addFirst(var32);
                           }
                        }

                        if (var9.field978 && var30 && var9.onMouseRepeat != null) {
                           var32 = new ScriptEvent();
                           var32.boolean1 = true;
                           var32.widget = var9;
                           var32.mouseX = MouseHandler.MouseHandler_x - var10;
                           var32.mouseY = MouseHandler.MouseHandler_y - var11;
                           var32.args0 = var9.onMouseRepeat;
                           Client.scriptEvents.addFirst(var32);
                        }

                        if (var9.field978 && !var30) {
                           var9.field978 = false;
                           if (var9.onMouseLeave != null) {
                              var32 = new ScriptEvent();
                              var32.boolean1 = true;
                              var32.widget = var9;
                              var32.mouseX = MouseHandler.MouseHandler_x - var10;
                              var32.mouseY = MouseHandler.MouseHandler_y - var11;
                              var32.args0 = var9.onMouseLeave;
                              Client.field148.addFirst(var32);
                           }
                        }

                        if (var9.onTimer != null) {
                           var32 = new ScriptEvent();
                           var32.widget = var9;
                           var32.args0 = var9.onTimer;
                           Client.field147.addFirst(var32);
                        }

                        int var26;
                        ScriptEvent var34;
                        int var35;
                        if (var9.onVarTransmit != null && Client.field123 > var9.field981) {
                           if (var9.varTransmitTriggers != null && Client.field123 - var9.field981 <= 32) {
                              label590:
                              for (var35 = var9.field981; var35 < Client.field123; ++var35) {
                                 var21 = Client.field121[var35 & 31];

                                 for (var26 = 0; var26 < var9.varTransmitTriggers.length; ++var26) {
                                    if (var21 == var9.varTransmitTriggers[var26]) {
                                       var34 = new ScriptEvent();
                                       var34.widget = var9;
                                       var34.args0 = var9.onVarTransmit;
                                       Client.scriptEvents.addFirst(var34);
                                       break label590;
                                    }
                                 }
                              }
                           } else {
                              var32 = new ScriptEvent();
                              var32.widget = var9;
                              var32.args0 = var9.onVarTransmit;
                              Client.scriptEvents.addFirst(var32);
                           }

                           var9.field981 = Client.field123;
                        }

                        if (var9.onInvTransmit != null && Client.field117 > var9.field982) {
                           if (var9.invTransmitTriggers != null && Client.field117 - var9.field982 <= 32) {
                              label566:
                              for (var35 = var9.field982; var35 < Client.field117; ++var35) {
                                 var21 = Client.field116[var35 & 31];

                                 for (var26 = 0; var26 < var9.invTransmitTriggers.length; ++var26) {
                                    if (var21 == var9.invTransmitTriggers[var26]) {
                                       var34 = new ScriptEvent();
                                       var34.widget = var9;
                                       var34.args0 = var9.onInvTransmit;
                                       Client.scriptEvents.addFirst(var34);
                                       break label566;
                                    }
                                 }
                              }
                           } else {
                              var32 = new ScriptEvent();
                              var32.widget = var9;
                              var32.args0 = var9.onInvTransmit;
                              Client.scriptEvents.addFirst(var32);
                           }

                           var9.field982 = Client.field117;
                        }

                        if (var9.onStatTransmit != null && Client.changedSkillsCount > var9.field983) {
                           if (var9.statTransmitTriggers != null && Client.changedSkillsCount - var9.field983 <= 32) {
                              label542:
                              for (var35 = var9.field983; var35 < Client.changedSkillsCount; ++var35) {
                                 var21 = Client.changedSkills[var35 & 31];

                                 for (var26 = 0; var26 < var9.statTransmitTriggers.length; ++var26) {
                                    if (var21 == var9.statTransmitTriggers[var26]) {
                                       var34 = new ScriptEvent();
                                       var34.widget = var9;
                                       var34.args0 = var9.onStatTransmit;
                                       Client.scriptEvents.addFirst(var34);
                                       break label542;
                                    }
                                 }
                              }
                           } else {
                              var32 = new ScriptEvent();
                              var32.widget = var9;
                              var32.args0 = var9.onStatTransmit;
                              Client.scriptEvents.addFirst(var32);
                           }

                           var9.field983 = Client.changedSkillsCount;
                        }

                        if (Client.chatCycle > var9.field980 && var9.field970 != null) {
                           var32 = new ScriptEvent();
                           var32.widget = var9;
                           var32.args0 = var9.field970;
                           Client.scriptEvents.addFirst(var32);
                        }

                        if (Client.field105 > var9.field980 && var9.field971 != null) {
                           var32 = new ScriptEvent();
                           var32.widget = var9;
                           var32.args0 = var9.field971;
                           Client.scriptEvents.addFirst(var32);
                        }

                        if (Client.field129 > var9.field980 && var9.field972 != null) {
                           var32 = new ScriptEvent();
                           var32.widget = var9;
                           var32.args0 = var9.field972;
                           Client.scriptEvents.addFirst(var32);
                        }

                        if (Client.field122 > var9.field980 && var9.field976 != null) {
                           var32 = new ScriptEvent();
                           var32.widget = var9;
                           var32.args0 = var9.field976;
                           Client.scriptEvents.addFirst(var32);
                        }

                        if (Client.field154 > var9.field980 && var9.field977 != null) {
                           var32 = new ScriptEvent();
                           var32.widget = var9;
                           var32.args0 = var9.field977;
                           Client.scriptEvents.addFirst(var32);
                        }

                        if (Client.field124 > var9.field980 && var9.field973 != null) {
                           var32 = new ScriptEvent();
                           var32.widget = var9;
                           var32.args0 = var9.field973;
                           Client.scriptEvents.addFirst(var32);
                        }

                        var9.field980 = Client.cycleCntr;
                        if (var9.onKeyListener != null) {
                           for (var35 = 0; var35 < Client.field137; ++var35) {
                              ScriptEvent var27 = new ScriptEvent();
                              var27.widget = var9;
                              var27.keyTyped = Client.field145[var35];
                              var27.keyPressed = Client.field146[var35];
                              var27.args0 = var9.onKeyListener;
                              Client.scriptEvents.addFirst(var27);
                           }
                        }
                     }
                  }

                  if (!var9.isIf3) {
                     if (Client.clickedWidget != null || DevicePcmPlayerProvider.dragInventoryWidget != null || Client.isMenuOpen) {
                        continue;
                     }

                     if ((var9.mouseOverRedirect >= 0 || var9.mouseOverColor != 0) && MouseHandler.MouseHandler_x >= var12 && MouseHandler.MouseHandler_y >= var13 && MouseHandler.MouseHandler_x < var14 && MouseHandler.MouseHandler_y < var15) {
                        if (var9.mouseOverRedirect >= 0) {
                           Clock.mousedOverWidgetIf1 = var0[var9.mouseOverRedirect];
                        } else {
                           Clock.mousedOverWidgetIf1 = var9;
                        }
                     }

                     if (var9.type == 8 && MouseHandler.MouseHandler_x >= var12 && MouseHandler.MouseHandler_y >= var13 && MouseHandler.MouseHandler_x < var14 && MouseHandler.MouseHandler_y < var15) {
                        AccessFile.field8 = var9;
                     }

                     if (var9.scrollHeight > var9.height) {
                        WorldMapSection0.method246(var9, var10 + var9.width, var11, var9.height, var9.scrollHeight, MouseHandler.MouseHandler_x, MouseHandler.MouseHandler_y);
                     }
                  }

                  if (var9.type == 0) {
                     updateWidgetGroup(var0, var9.id, var12, var13, var14, var15, var10 - var9.scrollX, var11 - var9.scrollY);
                     if (var9.children != null) {
                        updateWidgetGroup(var9.children, var9.id, var12, var13, var14, var15, var10 - var9.scrollX, var11 - var9.scrollY);
                     }

                     WidgetGroupParent var33 = (WidgetGroupParent)Client.widgetGroupParents.get((long)var9.id);
                     if (var33 != null) {
                        if (var33.type == 0 && MouseHandler.MouseHandler_x >= var12 && MouseHandler.MouseHandler_y >= var13 && MouseHandler.MouseHandler_x < var14 && MouseHandler.MouseHandler_y < var15 && !Client.isMenuOpen) {
                           for (var32 = (ScriptEvent)Client.scriptEvents.last(); var32 != null; var32 = (ScriptEvent)Client.scriptEvents.previous()) {
                              if (var32.boolean1) {
                                 var32.remove();
                                 var32.widget.field978 = false;
                              }
                           }

                           if (MouseRecorder.widgetDragDuration == 0) {
                              Client.clickedWidget = null;
                              Client.clickedWidgetParent = null;
                           }

                           if (!Client.isMenuOpen) {
                              class30.resetMenuEntries();
                           }
                        }

                        WorldMapDecorationType.method4517(var33.group, var12, var13, var14, var15, var10, var11);
                     }
                  }
               }
            }
         }
      }

   }
}
