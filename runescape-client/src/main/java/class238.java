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
      if(var0.cs1Comparisons == null) {
         return false;
      } else {
         for(int var1 = 0; var1 < var0.cs1Comparisons.length; ++var1) {
            int var2 = class16.method187(var0, var1);
            int var3 = var0.cs1ComparisonValues[var1];
            if(var0.cs1Comparisons[var1] == 2) {
               if(var2 >= var3) {
                  return false;
               }
            } else if(var0.cs1Comparisons[var1] == 3) {
               if(var2 <= var3) {
                  return false;
               }
            } else if(var0.cs1Comparisons[var1] == 4) {
               if(var2 == var3) {
                  return false;
               }
            } else if(var3 != var2) {
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
      for(int var8 = 0; var8 < var0.length; ++var8) {
         Widget var9 = var0[var8];
         if(var9 != null && var9.parentId == var1 && (!var9.isIf3 || var9.type == 0 || var9.hasListener || class1.getWidgetClickMask(var9) != 0 || var9 == Client.clickedWidgetParent || var9.contentType == 1338)) {
            if(var9.isIf3) {
               if(PacketBufferNode.method3673(var9)) {
                  continue;
               }
            } else if(var9.type == 0 && var9 != Clock.mousedOverWidgetIf1 && PacketBufferNode.method3673(var9)) {
               continue;
            }

            int var10 = var9.x + var6;
            int var11 = var7 + var9.y;
            int var12;
            int var13;
            int var14;
            int var15;
            int var17;
            int var18;
            if(var9.type == 2) {
               var12 = var2;
               var13 = var3;
               var14 = var4;
               var15 = var5;
            } else {
               int var16;
               if(var9.type == 9) {
                  var16 = var10;
                  var17 = var11;
                  var18 = var10 + var9.width;
                  int var19 = var11 + var9.height;
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
            }

            if(var9 == Client.clickedWidget) {
               Client.__client_nt = true;
               Client.__client_nk = var10;
               Client.__client_np = var11;
            }

            boolean var32 = false;
            if(var9.__cg) {
               switch(Client.__client_mf) {
               case 0:
                  var32 = true;
               case 1:
               default:
                  break;
               case 2:
                  if(Client.__client_ms == var9.id >>> 16) {
                     var32 = true;
                  }
                  break;
               case 3:
                  if(var9.id == Client.__client_ms) {
                     var32 = true;
                  }
               }
            }

            if(var32 || !var9.isIf3 || var12 < var14 && var13 < var15) {
               if(var9.isIf3) {
                  ScriptEvent var26;
                  if(var9.noClickThrough) {
                     if(MouseHandler.MouseHandler_x >= var12 && MouseHandler.MouseHandler_y >= var13 && MouseHandler.MouseHandler_x < var14 && MouseHandler.MouseHandler_y < var15) {
                        for(var26 = (ScriptEvent)Client.scriptEvents.last(); var26 != null; var26 = (ScriptEvent)Client.scriptEvents.previous()) {
                           if(var26.boolean1) {
                              var26.remove();
                              var26.widget.__fq = false;
                           }
                        }

                        if(MouseRecorder.widgetDragDuration == 0) {
                           Client.clickedWidget = null;
                           Client.clickedWidgetParent = null;
                        }

                        if(!Client.isMenuOpen) {
                           class30.resetMenuEntries();
                        }
                     }
                  } else if(var9.noScrollThrough && MouseHandler.MouseHandler_x >= var12 && MouseHandler.MouseHandler_y >= var13 && MouseHandler.MouseHandler_x < var14 && MouseHandler.MouseHandler_y < var15) {
                     for(var26 = (ScriptEvent)Client.scriptEvents.last(); var26 != null; var26 = (ScriptEvent)Client.scriptEvents.previous()) {
                        if(var26.boolean1 && var26.widget.onScroll == var26.args0) {
                           var26.remove();
                        }
                     }
                  }
               }

               var17 = MouseHandler.MouseHandler_x;
               var18 = MouseHandler.MouseHandler_y;
               if(MouseHandler.MouseHandler_lastButton != 0) {
                  var17 = MouseHandler.MouseHandler_lastPressedX;
                  var18 = MouseHandler.MouseHandler_lastPressedY;
               }

               boolean var33 = var17 >= var12 && var18 >= var13 && var17 < var14 && var18 < var15;
               if(var9.contentType == 1337) {
                  if(!Client.isLoading && !Client.isMenuOpen && var33) {
                     WorldMapEvent.method781(var17, var18, var12, var13);
                  }
               } else if(var9.contentType == 1338) {
                  WorldMapRegion.method567(var9, var10, var11);
               } else {
                  if(var9.contentType == 1400) {
                     class60.worldMap0.onCycle(MouseHandler.MouseHandler_x, MouseHandler.MouseHandler_y, var33, var10, var11, var9.width, var9.height);
                  }

                  if(!Client.isMenuOpen && var33) {
                     if(var9.contentType == 1400) {
                        class60.worldMap0.__bd_544(var10, var11, var9.width, var9.height, var17, var18);
                     } else {
                        ChatChannel.method2237(var9, var17 - var10, var18 - var11);
                     }
                  }

                  boolean var21;
                  int var23;
                  if(var32) {
                     for(int var20 = 0; var20 < var9.__cf.length; ++var20) {
                        var21 = false;
                        boolean var22 = false;
                        if(!var21 && var9.__cf[var20] != null) {
                           for(var23 = 0; var23 < var9.__cf[var20].length; ++var23) {
                              boolean var24 = false;
                              if(var9.__fh != null) {
                                 var24 = KeyHandler.KeyHandler_pressedKeys[var9.__cf[var20][var23]];
                              }

                              if(class1.method15(var9.__cf[var20][var23]) || var24) {
                                 var21 = true;
                                 if(var9.__fh != null && var9.__fh[var20] > Client.cycle) {
                                    break;
                                 }

                                 byte var25 = var9.__cp[var20][var23];
                                 if(var25 == 0 || ((var25 & 8) == 0 || !KeyHandler.KeyHandler_pressedKeys[86] && !KeyHandler.KeyHandler_pressedKeys[82] && !KeyHandler.KeyHandler_pressedKeys[81]) && ((var25 & 2) == 0 || KeyHandler.KeyHandler_pressedKeys[86]) && ((var25 & 1) == 0 || KeyHandler.KeyHandler_pressedKeys[82]) && ((var25 & 4) == 0 || KeyHandler.KeyHandler_pressedKeys[81])) {
                                    var22 = true;
                                    break;
                                 }
                              }
                           }
                        }

                        if(var22) {
                           if(var20 < 10) {
                              class171.method3494(var20 + 1, var9.id, var9.childIndex, var9.itemId, "");
                           } else if(var20 == 10) {
                              Player.method1281();
                              class25.method350(var9.id, var9.childIndex, class211.method4107(class1.getWidgetClickMask(var9)), var9.itemId);
                              Client.selectedSpellActionName = class198.method3745(var9);
                              if(Client.selectedSpellActionName == null) {
                                 Client.selectedSpellActionName = "null";
                              }

                              Client.selectedSpellName = var9.dataText + BufferedFile.colorStartTag(16777215);
                           }

                           var23 = var9.__cc[var20];
                           if(var9.__fh == null) {
                              var9.__fh = new int[var9.__cf.length];
                           }

                           if(var9.__ci == null) {
                              var9.__ci = new int[var9.__cf.length];
                           }

                           if(var23 != 0) {
                              if(var9.__fh[var20] == 0) {
                                 var9.__fh[var20] = var23 + Client.cycle + var9.__ci[var20];
                              } else {
                                 var9.__fh[var20] = var23 + Client.cycle;
                              }
                           } else {
                              var9.__fh[var20] = Integer.MAX_VALUE;
                           }
                        }

                        if(!var21 && var9.__fh != null) {
                           var9.__fh[var20] = 0;
                        }
                     }
                  }

                  if(var9.isIf3) {
                     if(MouseHandler.MouseHandler_x >= var12 && MouseHandler.MouseHandler_y >= var13 && MouseHandler.MouseHandler_x < var14 && MouseHandler.MouseHandler_y < var15) {
                        var33 = true;
                     } else {
                        var33 = false;
                     }

                     boolean var34 = false;
                     if((MouseHandler.MouseHandler_currentButton == 1 || !AbstractRasterProvider.__lp_ca && MouseHandler.MouseHandler_currentButton == 4) && var33) {
                        var34 = true;
                     }

                     var21 = false;
                     if((MouseHandler.MouseHandler_lastButton == 1 || !AbstractRasterProvider.__lp_ca && MouseHandler.MouseHandler_lastButton == 4) && MouseHandler.MouseHandler_lastPressedX >= var12 && MouseHandler.MouseHandler_lastPressedY >= var13 && MouseHandler.MouseHandler_lastPressedX < var14 && MouseHandler.MouseHandler_lastPressedY < var15) {
                        var21 = true;
                     }

                     if(var21) {
                        Players.clickWidget(var9, MouseHandler.MouseHandler_lastPressedX - var10, MouseHandler.MouseHandler_lastPressedY - var11);
                     }

                     if(var9.contentType == 1400) {
                        class60.worldMap0.__w_519(var17, var18, var33 & var34, var33 & var21);
                     }

                     if(Client.clickedWidget != null && var9 != Client.clickedWidget && var33 && class54.method1090(class1.getWidgetClickMask(var9))) {
                        Client.draggedOnWidget = var9;
                     }

                     if(var9 == Client.clickedWidgetParent) {
                        Client.__client_nn = true;
                        Client.__client_nw = var10;
                        Client.__client_nl = var11;
                     }

                     if(var9.hasListener) {
                        ScriptEvent var27;
                        if(var33 && Client.mouseWheelRotation != 0 && var9.onScroll != null) {
                           var27 = new ScriptEvent();
                           var27.boolean1 = true;
                           var27.widget = var9;
                           var27.mouseY = Client.mouseWheelRotation;
                           var27.args0 = var9.onScroll;
                           Client.scriptEvents.addFirst(var27);
                        }

                        if(Client.clickedWidget != null || DevicePcmPlayerProvider.dragInventoryWidget != null || Client.isMenuOpen) {
                           var21 = false;
                           var34 = false;
                           var33 = false;
                        }

                        if(!var9.__fw && var21) {
                           var9.__fw = true;
                           if(var9.onClick != null) {
                              var27 = new ScriptEvent();
                              var27.boolean1 = true;
                              var27.widget = var9;
                              var27.mouseX = MouseHandler.MouseHandler_lastPressedX - var10;
                              var27.mouseY = MouseHandler.MouseHandler_lastPressedY - var11;
                              var27.args0 = var9.onClick;
                              Client.scriptEvents.addFirst(var27);
                           }
                        }

                        if(var9.__fw && var34 && var9.onClickRepeat != null) {
                           var27 = new ScriptEvent();
                           var27.boolean1 = true;
                           var27.widget = var9;
                           var27.mouseX = MouseHandler.MouseHandler_x - var10;
                           var27.mouseY = MouseHandler.MouseHandler_y - var11;
                           var27.args0 = var9.onClickRepeat;
                           Client.scriptEvents.addFirst(var27);
                        }

                        if(var9.__fw && !var34) {
                           var9.__fw = false;
                           if(var9.onRelease != null) {
                              var27 = new ScriptEvent();
                              var27.boolean1 = true;
                              var27.widget = var9;
                              var27.mouseX = MouseHandler.MouseHandler_x - var10;
                              var27.mouseY = MouseHandler.MouseHandler_y - var11;
                              var27.args0 = var9.onRelease;
                              Client.__client_oc.addFirst(var27);
                           }
                        }

                        if(var34 && var9.onHold != null) {
                           var27 = new ScriptEvent();
                           var27.boolean1 = true;
                           var27.widget = var9;
                           var27.mouseX = MouseHandler.MouseHandler_x - var10;
                           var27.mouseY = MouseHandler.MouseHandler_y - var11;
                           var27.args0 = var9.onHold;
                           Client.scriptEvents.addFirst(var27);
                        }

                        if(!var9.__fq && var33) {
                           var9.__fq = true;
                           if(var9.onMouseOver != null) {
                              var27 = new ScriptEvent();
                              var27.boolean1 = true;
                              var27.widget = var9;
                              var27.mouseX = MouseHandler.MouseHandler_x - var10;
                              var27.mouseY = MouseHandler.MouseHandler_y - var11;
                              var27.args0 = var9.onMouseOver;
                              Client.scriptEvents.addFirst(var27);
                           }
                        }

                        if(var9.__fq && var33 && var9.onMouseRepeat != null) {
                           var27 = new ScriptEvent();
                           var27.boolean1 = true;
                           var27.widget = var9;
                           var27.mouseX = MouseHandler.MouseHandler_x - var10;
                           var27.mouseY = MouseHandler.MouseHandler_y - var11;
                           var27.args0 = var9.onMouseRepeat;
                           Client.scriptEvents.addFirst(var27);
                        }

                        if(var9.__fq && !var33) {
                           var9.__fq = false;
                           if(var9.onMouseLeave != null) {
                              var27 = new ScriptEvent();
                              var27.boolean1 = true;
                              var27.widget = var9;
                              var27.mouseX = MouseHandler.MouseHandler_x - var10;
                              var27.mouseY = MouseHandler.MouseHandler_y - var11;
                              var27.args0 = var9.onMouseLeave;
                              Client.__client_oc.addFirst(var27);
                           }
                        }

                        if(var9.onTimer != null) {
                           var27 = new ScriptEvent();
                           var27.widget = var9;
                           var27.args0 = var9.onTimer;
                           Client.__client_oh.addFirst(var27);
                        }

                        ScriptEvent var30;
                        int var35;
                        int var36;
                        if(var9.onVarTransmit != null && Client.__client_nd > var9.__fc) {
                           if(var9.varTransmitTriggers != null && Client.__client_nd - var9.__fc <= 32) {
                              label887:
                              for(var35 = var9.__fc; var35 < Client.__client_nd; ++var35) {
                                 var23 = Client.__client_nr[var35 & 31];

                                 for(var36 = 0; var36 < var9.varTransmitTriggers.length; ++var36) {
                                    if(var23 == var9.varTransmitTriggers[var36]) {
                                       var30 = new ScriptEvent();
                                       var30.widget = var9;
                                       var30.args0 = var9.onVarTransmit;
                                       Client.scriptEvents.addFirst(var30);
                                       break label887;
                                    }
                                 }
                              }
                           } else {
                              var27 = new ScriptEvent();
                              var27.widget = var9;
                              var27.args0 = var9.onVarTransmit;
                              Client.scriptEvents.addFirst(var27);
                           }

                           var9.__fc = Client.__client_nd;
                        }

                        if(var9.onInvTransmit != null && Client.__client_ns > var9.__fl) {
                           if(var9.invTransmitTriggers != null && Client.__client_ns - var9.__fl <= 32) {
                              label863:
                              for(var35 = var9.__fl; var35 < Client.__client_ns; ++var35) {
                                 var23 = Client.__client_nz[var35 & 31];

                                 for(var36 = 0; var36 < var9.invTransmitTriggers.length; ++var36) {
                                    if(var23 == var9.invTransmitTriggers[var36]) {
                                       var30 = new ScriptEvent();
                                       var30.widget = var9;
                                       var30.args0 = var9.onInvTransmit;
                                       Client.scriptEvents.addFirst(var30);
                                       break label863;
                                    }
                                 }
                              }
                           } else {
                              var27 = new ScriptEvent();
                              var27.widget = var9;
                              var27.args0 = var9.onInvTransmit;
                              Client.scriptEvents.addFirst(var27);
                           }

                           var9.__fl = Client.__client_ns;
                        }

                        if(var9.onStatTransmit != null && Client.changedSkillsCount > var9.__fj) {
                           if(var9.statTransmitTriggers != null && Client.changedSkillsCount - var9.__fj <= 32) {
                              label839:
                              for(var35 = var9.__fj; var35 < Client.changedSkillsCount; ++var35) {
                                 var23 = Client.changedSkills[var35 & 31];

                                 for(var36 = 0; var36 < var9.statTransmitTriggers.length; ++var36) {
                                    if(var23 == var9.statTransmitTriggers[var36]) {
                                       var30 = new ScriptEvent();
                                       var30.widget = var9;
                                       var30.args0 = var9.onStatTransmit;
                                       Client.scriptEvents.addFirst(var30);
                                       break label839;
                                    }
                                 }
                              }
                           } else {
                              var27 = new ScriptEvent();
                              var27.widget = var9;
                              var27.args0 = var9.onStatTransmit;
                              Client.scriptEvents.addFirst(var27);
                           }

                           var9.__fj = Client.changedSkillsCount;
                        }

                        if(Client.chatCycle > var9.__fg && var9.__em != null) {
                           var27 = new ScriptEvent();
                           var27.widget = var9;
                           var27.args0 = var9.__em;
                           Client.scriptEvents.addFirst(var27);
                        }

                        if(Client.__client_na > var9.__fg && var9.__ex != null) {
                           var27 = new ScriptEvent();
                           var27.widget = var9;
                           var27.args0 = var9.__ex;
                           Client.scriptEvents.addFirst(var27);
                        }

                        if(Client.__client_nh > var9.__fg && var9.__ej != null) {
                           var27 = new ScriptEvent();
                           var27.widget = var9;
                           var27.args0 = var9.__ej;
                           Client.scriptEvents.addFirst(var27);
                        }

                        if(Client.__client_nv > var9.__fg && var9.__eq != null) {
                           var27 = new ScriptEvent();
                           var27.widget = var9;
                           var27.args0 = var9.__eq;
                           Client.scriptEvents.addFirst(var27);
                        }

                        if(Client.__client_nc > var9.__fg && var9.__eh != null) {
                           var27 = new ScriptEvent();
                           var27.widget = var9;
                           var27.args0 = var9.__eh;
                           Client.scriptEvents.addFirst(var27);
                        }

                        if(Client.__client_ni > var9.__fg && var9.__el != null) {
                           var27 = new ScriptEvent();
                           var27.widget = var9;
                           var27.args0 = var9.__el;
                           Client.scriptEvents.addFirst(var27);
                        }

                        var9.__fg = Client.cycleCntr;
                        if(var9.onKeyListener != null) {
                           for(var35 = 0; var35 < Client.__client_pm; ++var35) {
                              ScriptEvent var31 = new ScriptEvent();
                              var31.widget = var9;
                              var31.keyTyped = Client.__client_pn[var35];
                              var31.keyPressed = Client.__client_pq[var35];
                              var31.args0 = var9.onKeyListener;
                              Client.scriptEvents.addFirst(var31);
                           }
                        }
                     }
                  }

                  if(!var9.isIf3) {
                     if(Client.clickedWidget != null || DevicePcmPlayerProvider.dragInventoryWidget != null || Client.isMenuOpen) {
                        continue;
                     }

                     if((var9.mouseOverRedirect >= 0 || var9.mouseOverColor != 0) && MouseHandler.MouseHandler_x >= var12 && MouseHandler.MouseHandler_y >= var13 && MouseHandler.MouseHandler_x < var14 && MouseHandler.MouseHandler_y < var15) {
                        if(var9.mouseOverRedirect >= 0) {
                           Clock.mousedOverWidgetIf1 = var0[var9.mouseOverRedirect];
                        } else {
                           Clock.mousedOverWidgetIf1 = var9;
                        }
                     }

                     if(var9.type == 8 && MouseHandler.MouseHandler_x >= var12 && MouseHandler.MouseHandler_y >= var13 && MouseHandler.MouseHandler_x < var14 && MouseHandler.MouseHandler_y < var15) {
                        AccessFile.__dk_lm = var9;
                     }

                     if(var9.scrollHeight > var9.height) {
                        WorldMapSection0.method246(var9, var10 + var9.width, var11, var9.height, var9.scrollHeight, MouseHandler.MouseHandler_x, MouseHandler.MouseHandler_y);
                     }
                  }

                  if(var9.type == 0) {
                     updateWidgetGroup(var0, var9.id, var12, var13, var14, var15, var10 - var9.scrollX, var11 - var9.scrollY);
                     if(var9.children != null) {
                        updateWidgetGroup(var9.children, var9.id, var12, var13, var14, var15, var10 - var9.scrollX, var11 - var9.scrollY);
                     }

                     WidgetGroupParent var28 = (WidgetGroupParent)Client.widgetGroupParents.get((long)var9.id);
                     if(var28 != null) {
                        if(var28.type == 0 && MouseHandler.MouseHandler_x >= var12 && MouseHandler.MouseHandler_y >= var13 && MouseHandler.MouseHandler_x < var14 && MouseHandler.MouseHandler_y < var15 && !Client.isMenuOpen) {
                           for(ScriptEvent var29 = (ScriptEvent)Client.scriptEvents.last(); var29 != null; var29 = (ScriptEvent)Client.scriptEvents.previous()) {
                              if(var29.boolean1) {
                                 var29.remove();
                                 var29.widget.__fq = false;
                              }
                           }

                           if(MouseRecorder.widgetDragDuration == 0) {
                              Client.clickedWidget = null;
                              Client.clickedWidgetParent = null;
                           }

                           if(!Client.isMenuOpen) {
                              class30.resetMenuEntries();
                           }
                        }

                        class231.method4517(var28.group, var12, var13, var14, var15, var10, var11);
                     }
                  }
               }
            }
         }
      }

   }
}
