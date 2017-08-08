import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hb")
@Implements("BuildType")
public class BuildType {
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Lhb;"
   )
   @Export("RC")
   static final BuildType RC;
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Lhb;"
   )
   @Export("WIP")
   static final BuildType WIP;
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Lhb;"
   )
   @Export("LIVE")
   static final BuildType LIVE;
   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "Lhb;"
   )
   @Export("BUILD_LIVE")
   static final BuildType BUILD_LIVE;
   @ObfuscatedName("w")
   @Export("identifier")
   public final String identifier;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 1385057303
   )
   @Export("ordinal")
   final int ordinal;

   static {
      RC = new BuildType("LIVE", 0);
      WIP = new BuildType("BUILDLIVE", 3);
      LIVE = new BuildType("RC", 1);
      BUILD_LIVE = new BuildType("WIP", 2);
   }

   BuildType(String var1, int var2) {
      this.identifier = var1;
      this.ordinal = var2;
   }

   @ObfuscatedName("iu")
   @ObfuscatedSignature(
      signature = "([Lhg;IIIIIIIB)V",
      garbageValue = "-25"
   )
   static final void method4099(Widget[] var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      for(int var8 = 0; var8 < var0.length; ++var8) {
         Widget var9 = var0[var8];
         if(var9 != null && (!var9.hasScript || var9.type == 0 || var9.field2739 || class15.getWidgetConfig(var9) != 0 || var9 == Client.field1076 || var9.contentType == 1338) && var9.parentId == var1 && (!var9.hasScript || !class41.method543(var9))) {
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

            if(var9 == Client.field1117) {
               Client.field1083 = true;
               Client.field1084 = var10;
               Client.field1085 = var11;
            }

            if(!var9.hasScript || var12 < var14 && var13 < var15) {
               var16 = MouseInput.field718;
               var17 = MouseInput.field719;
               if(MouseInput.field734 != 0) {
                  var16 = MouseInput.field725;
                  var17 = MouseInput.field726;
               }

               boolean var47 = var16 >= var12 && var17 >= var13 && var16 < var14 && var17 < var15;
               int var20;
               int var21;
               int var22;
               int var23;
               int var24;
               int var25;
               int var26;
               int var28;
               int var30;
               int var31;
               if(var9.contentType == 1337) {
                  if(!Client.field923 && !Client.isMenuOpen && var47) {
                     if(Client.itemSelectionState == 0 && !Client.spellSelected) {
                        class165.addMenuEntry("Walk here", "", 23, 0, var16 - var12, var17 - var13);
                     }

                     var19 = -1;
                     var20 = -1;

                     for(var21 = 0; var21 < class135.field1988; ++var21) {
                        var22 = class135.field1989[var21];
                        var23 = var22 & 127;
                        var24 = var22 >> 7 & 127;
                        var25 = var22 >> 29 & 3;
                        var26 = var22 >> 14 & 32767;
                        if(var22 != var20) {
                           var20 = var22;
                           if(var25 == 2 && class84.region.method2740(class29.plane, var23, var24, var22) >= 0) {
                              ObjectComposition var59 = WorldMapType1.getObjectDefinition(var26);
                              if(var59.impostorIds != null) {
                                 var59 = var59.getImpostor();
                              }

                              if(var59 == null) {
                                 continue;
                              }

                              if(Client.itemSelectionState == 1) {
                                 class165.addMenuEntry("Use", Client.field1056 + " " + "->" + " " + RSSocket.getColTags('\uffff') + var59.name, 1, var22, var23, var24);
                              } else if(Client.spellSelected) {
                                 if((class1.field4 & 4) == 4) {
                                    class165.addMenuEntry(Client.field997, Client.field1061 + " " + "->" + " " + RSSocket.getColTags('\uffff') + var59.name, 2, var22, var23, var24);
                                 }
                              } else {
                                 String[] var43 = var59.actions;
                                 if(Client.field934) {
                                    var43 = class84.method1685(var43);
                                 }

                                 if(var43 != null) {
                                    for(int var51 = 4; var51 >= 0; --var51) {
                                       if(var43[var51] != null) {
                                          short var52 = 0;
                                          if(var51 == 0) {
                                             var52 = 3;
                                          }

                                          if(var51 == 1) {
                                             var52 = 4;
                                          }

                                          if(var51 == 2) {
                                             var52 = 5;
                                          }

                                          if(var51 == 3) {
                                             var52 = 6;
                                          }

                                          if(var51 == 4) {
                                             var52 = 1001;
                                          }

                                          class165.addMenuEntry(var43[var51], RSSocket.getColTags('\uffff') + var59.name, var52, var22, var23, var24);
                                       }
                                    }
                                 }

                                 class165.addMenuEntry("Examine", RSSocket.getColTags('\uffff') + var59.name, 1002, var59.id << 14, var23, var24);
                              }
                           }

                           NPC var44;
                           Player var45;
                           int[] var61;
                           if(var25 == 1) {
                              NPC var62 = Client.cachedNPCs[var26];
                              if(var62 == null) {
                                 continue;
                              }

                              if(var62.composition.field3547 == 1 && (var62.x & 127) == 64 && (var62.y & 127) == 64) {
                                 for(var28 = 0; var28 < Client.field952; ++var28) {
                                    var44 = Client.cachedNPCs[Client.npcIndices[var28]];
                                    if(var44 != null && var62 != var44 && var44.composition.field3547 == 1 && var44.x == var62.x && var62.y == var44.y) {
                                       class13.method68(var44.composition, Client.npcIndices[var28], var23, var24);
                                    }
                                 }

                                 var28 = class97.field1493;
                                 var61 = class97.field1494;

                                 for(var30 = 0; var30 < var28; ++var30) {
                                    var45 = Client.cachedPlayers[var61[var30]];
                                    if(var45 != null && var62.x == var45.x && var45.y == var62.y) {
                                       Renderable.method2898(var45, var61[var30], var23, var24);
                                    }
                                 }
                              }

                              class13.method68(var62.composition, var26, var23, var24);
                           }

                           if(var25 == 0) {
                              Player var63 = Client.cachedPlayers[var26];
                              if(var63 == null) {
                                 continue;
                              }

                              if((var63.x & 127) == 64 && (var63.y & 127) == 64) {
                                 for(var28 = 0; var28 < Client.field952; ++var28) {
                                    var44 = Client.cachedNPCs[Client.npcIndices[var28]];
                                    if(var44 != null && var44.composition.field3547 == 1 && var44.x == var63.x && var44.y == var63.y) {
                                       class13.method68(var44.composition, Client.npcIndices[var28], var23, var24);
                                    }
                                 }

                                 var28 = class97.field1493;
                                 var61 = class97.field1494;

                                 for(var30 = 0; var30 < var28; ++var30) {
                                    var45 = Client.cachedPlayers[var61[var30]];
                                    if(var45 != null && var45 != var63 && var63.x == var45.x && var63.y == var45.y) {
                                       Renderable.method2898(var45, var61[var30], var23, var24);
                                    }
                                 }
                              }

                              if(var26 != Client.field1031) {
                                 Renderable.method2898(var63, var26, var23, var24);
                              } else {
                                 var19 = var22;
                              }
                           }

                           if(var25 == 3) {
                              Deque var64 = Client.groundItemDeque[class29.plane][var23][var24];
                              if(var64 != null) {
                                 for(Item var60 = (Item)var64.getTail(); var60 != null; var60 = (Item)var64.getPrevious()) {
                                    ItemComposition var65 = ClassInfo.getItemDefinition(var60.id);
                                    if(Client.itemSelectionState == 1) {
                                       class165.addMenuEntry("Use", Client.field1056 + " " + "->" + " " + RSSocket.getColTags(16748608) + var65.name, 16, var60.id, var23, var24);
                                    } else if(Client.spellSelected) {
                                       if((class1.field4 & 1) == 1) {
                                          class165.addMenuEntry(Client.field997, Client.field1061 + " " + "->" + " " + RSSocket.getColTags(16748608) + var65.name, 17, var60.id, var23, var24);
                                       }
                                    } else {
                                       String[] var46 = var65.groundActions;
                                       if(Client.field934) {
                                          var46 = class84.method1685(var46);
                                       }

                                       for(var31 = 4; var31 >= 0; --var31) {
                                          if(var46 != null && var46[var31] != null) {
                                             byte var54 = 0;
                                             if(var31 == 0) {
                                                var54 = 18;
                                             }

                                             if(var31 == 1) {
                                                var54 = 19;
                                             }

                                             if(var31 == 2) {
                                                var54 = 20;
                                             }

                                             if(var31 == 3) {
                                                var54 = 21;
                                             }

                                             if(var31 == 4) {
                                                var54 = 22;
                                             }

                                             class165.addMenuEntry(var46[var31], RSSocket.getColTags(16748608) + var65.name, var54, var60.id, var23, var24);
                                          } else if(var31 == 2) {
                                             class165.addMenuEntry("Take", RSSocket.getColTags(16748608) + var65.name, 20, var60.id, var23, var24);
                                          }
                                       }

                                       class165.addMenuEntry("Examine", RSSocket.getColTags(16748608) + var65.name, 1004, var60.id, var23, var24);
                                    }
                                 }
                              }
                           }
                        }
                     }

                     if(var19 != -1) {
                        var21 = var19 & 127;
                        var22 = var19 >> 7 & 127;
                        Player var55 = Client.cachedPlayers[Client.field1031];
                        Renderable.method2898(var55, Client.field1031, var21, var22);
                     }
                  }
               } else if(var9.contentType == 1338) {
                  Friend.method1089(var9, var10, var11);
               } else {
                  if(var9.contentType == 1400) {
                     BaseVarType.renderOverview.method5227(MouseInput.field718, MouseInput.field719, var47, var10, var11, var9.width, var9.height);
                  }

                  if(!Client.isMenuOpen && var47) {
                     if(var9.contentType == 1400) {
                        BaseVarType.renderOverview.method5230(var10, var11, var9.width, var9.height, var16, var17);
                     } else {
                        var19 = var16 - var10;
                        var20 = var17 - var11;
                        if(var9.field2626 == 1) {
                           class165.addMenuEntry(var9.tooltip, "", 24, 0, 0, var9.id);
                        }

                        String var37;
                        if(var9.field2626 == 2 && !Client.spellSelected) {
                           var37 = class72.method1123(var9);
                           if(var37 != null) {
                              class165.addMenuEntry(var37, RSSocket.getColTags('\uff00') + var9.field2652, 25, 0, -1, var9.id);
                           }
                        }

                        if(var9.field2626 == 3) {
                           class165.addMenuEntry("Close", "", 26, 0, 0, var9.id);
                        }

                        if(var9.field2626 == 4) {
                           class165.addMenuEntry(var9.tooltip, "", 28, 0, 0, var9.id);
                        }

                        if(var9.field2626 == 5) {
                           class165.addMenuEntry(var9.tooltip, "", 29, 0, 0, var9.id);
                        }

                        if(var9.field2626 == 6 && Client.field1066 == null) {
                           class165.addMenuEntry(var9.tooltip, "", 30, 0, -1, var9.id);
                        }

                        if(var9.type == 2) {
                           var21 = 0;

                           for(var22 = 0; var22 < var9.height; ++var22) {
                              for(var23 = 0; var23 < var9.width; ++var23) {
                                 var24 = var23 * (var9.paddingX + 32);
                                 var25 = var22 * (var9.paddingY + 32);
                                 if(var21 < 20) {
                                    var24 += var9.xSprites[var21];
                                    var25 += var9.field2692[var21];
                                 }

                                 if(var19 >= var24 && var20 >= var25 && var19 < var24 + 32 && var20 < var25 + 32) {
                                    Client.field1018 = var21;
                                    MilliTimer.field2195 = var9;
                                    if(var9.itemIds[var21] > 0) {
                                       label1710: {
                                          ItemComposition var41 = ClassInfo.getItemDefinition(var9.itemIds[var21] - 1);
                                          if(Client.itemSelectionState == 1) {
                                             var28 = class15.getWidgetConfig(var9);
                                             boolean var27 = (var28 >> 30 & 1) != 0;
                                             if(var27) {
                                                if(var9.id != class10.field261 || var21 != class31.selectedItemIndex) {
                                                   class165.addMenuEntry("Use", Client.field1056 + " " + "->" + " " + RSSocket.getColTags(16748608) + var41.name, 31, var41.id, var21, var9.id);
                                                }
                                                break label1710;
                                             }
                                          }

                                          if(Client.spellSelected && class56.method816(class15.getWidgetConfig(var9))) {
                                             if((class1.field4 & 16) == 16) {
                                                class165.addMenuEntry(Client.field997, Client.field1061 + " " + "->" + " " + RSSocket.getColTags(16748608) + var41.name, 32, var41.id, var21, var9.id);
                                             }
                                          } else {
                                             String[] var42 = var41.inventoryActions;
                                             if(Client.field934) {
                                                var42 = class84.method1685(var42);
                                             }

                                             var28 = -1;
                                             if(Client.field1009 && KeyFocusListener.field631[81]) {
                                                var28 = var41.method4598();
                                             }

                                             var30 = class15.getWidgetConfig(var9);
                                             boolean var29 = (var30 >> 30 & 1) != 0;
                                             if(var29) {
                                                for(var31 = 4; var31 >= 3; --var31) {
                                                   if(var28 != var31) {
                                                      class19.method152(var9, var41, var21, var31, false);
                                                   }
                                                }
                                             }

                                             int var32 = class15.getWidgetConfig(var9);
                                             boolean var53 = (var32 >> 31 & 1) != 0;
                                             if(var53) {
                                                class165.addMenuEntry("Use", RSSocket.getColTags(16748608) + var41.name, 38, var41.id, var21, var9.id);
                                             }

                                             Object var10000 = null;
                                             int var33;
                                             if(class56.method816(class15.getWidgetConfig(var9))) {
                                                for(var33 = 2; var33 >= 0; --var33) {
                                                   if(var28 != var33) {
                                                      class19.method152(var9, var41, var21, var33, false);
                                                   }
                                                }

                                                if(var28 >= 0) {
                                                   class19.method152(var9, var41, var21, var28, true);
                                                }
                                             }

                                             var42 = var9.configActions;
                                             if(Client.field934) {
                                                var42 = class84.method1685(var42);
                                             }

                                             if(var42 != null) {
                                                for(var33 = 4; var33 >= 0; --var33) {
                                                   if(var42[var33] != null) {
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

                                                      class165.addMenuEntry(var42[var33], RSSocket.getColTags(16748608) + var41.name, var34, var41.id, var21, var9.id);
                                                   }
                                                }
                                             }

                                             class165.addMenuEntry("Examine", RSSocket.getColTags(16748608) + var41.name, 1005, var41.id, var21, var9.id);
                                          }
                                       }
                                    }
                                 }

                                 ++var21;
                              }
                           }
                        }

                        if(var9.hasScript) {
                           if(Client.spellSelected) {
                              if(class89.method1734(class15.getWidgetConfig(var9)) && (class1.field4 & 32) == 32) {
                                 class165.addMenuEntry(Client.field997, Client.field1061 + " " + "->" + " " + var9.name, 58, 0, var9.index, var9.id);
                              }
                           } else {
                              for(var21 = 9; var21 >= 5; --var21) {
                                 String var39 = XGrandExchangeOffer.method115(var9, var21);
                                 if(var39 != null) {
                                    class165.addMenuEntry(var39, var9.name, 1007, var21 + 1, var9.index, var9.id);
                                 }
                              }

                              var37 = class72.method1123(var9);
                              if(var37 != null) {
                                 class165.addMenuEntry(var37, var9.name, 25, 0, var9.index, var9.id);
                              }

                              for(var22 = 4; var22 >= 0; --var22) {
                                 String var35 = XGrandExchangeOffer.method115(var9, var22);
                                 if(var35 != null) {
                                    class165.addMenuEntry(var35, var9.name, 57, var22 + 1, var9.index, var9.id);
                                 }
                              }

                              if(class183.method3443(class15.getWidgetConfig(var9))) {
                                 class165.addMenuEntry("Continue", "", 30, 0, var9.index, var9.id);
                              }
                           }
                        }
                     }
                  }

                  if(var9.type == 0) {
                     if(!var9.hasScript && class41.method543(var9) && var9 != class43.field569) {
                        continue;
                     }

                     method4099(var0, var9.id, var12, var13, var14, var15, var10 - var9.scrollX, var11 - var9.scrollY);
                     if(var9.children != null) {
                        method4099(var9.children, var9.id, var12, var13, var14, var15, var10 - var9.scrollX, var11 - var9.scrollY);
                     }

                     WidgetNode var36 = (WidgetNode)Client.componentTable.get((long)var9.id);
                     if(var36 != null) {
                        if(var36.owner == 0 && MouseInput.field718 >= var12 && MouseInput.field719 >= var13 && MouseInput.field718 < var14 && MouseInput.field719 < var15 && !Client.isMenuOpen && !Client.field1072) {
                           for(ScriptEvent var38 = (ScriptEvent)Client.field1101.getFront(); var38 != null; var38 = (ScriptEvent)Client.field1101.getNext()) {
                              if(var38.field834) {
                                 var38.unlink();
                                 var38.widget.field2748 = false;
                              }
                           }

                           if(ItemLayer.field1779 == 0) {
                              Client.field1117 = null;
                              Client.field1076 = null;
                           }

                           if(!Client.isMenuOpen) {
                              Client.menuOptionCount = 0;
                              Client.isMenuOpen = false;
                              Client.menuOptions[0] = "Cancel";
                              Client.menuTargets[0] = "";
                              Client.menuTypes[0] = 1006;
                              Client.field1048[0] = false;
                              Client.menuOptionCount = 1;
                           }
                        }

                        var20 = var36.id;
                        if(class10.loadWidget(var20)) {
                           method4099(Item.widgets[var20], -1, var12, var13, var14, var15, var10, var11);
                        }
                     }
                  }

                  if(var9.hasScript) {
                     ScriptEvent var56;
                     if(!var9.field2702) {
                        if(var9.field2685 && MouseInput.field718 >= var12 && MouseInput.field719 >= var13 && MouseInput.field718 < var14 && MouseInput.field719 < var15) {
                           for(var56 = (ScriptEvent)Client.field1101.getFront(); var56 != null; var56 = (ScriptEvent)Client.field1101.getNext()) {
                              if(var56.field834 && var56.widget.scrollListener == var56.field849) {
                                 var56.unlink();
                              }
                           }
                        }
                     } else if(MouseInput.field718 >= var12 && MouseInput.field719 >= var13 && MouseInput.field718 < var14 && MouseInput.field719 < var15) {
                        for(var56 = (ScriptEvent)Client.field1101.getFront(); var56 != null; var56 = (ScriptEvent)Client.field1101.getNext()) {
                           if(var56.field834) {
                              var56.unlink();
                              var56.widget.field2748 = false;
                           }
                        }

                        if(ItemLayer.field1779 == 0) {
                           Client.field1117 = null;
                           Client.field1076 = null;
                        }

                        if(!Client.isMenuOpen) {
                           class5.method12();
                        }
                     }

                     if(MouseInput.field718 >= var12 && MouseInput.field719 >= var13 && MouseInput.field718 < var14 && MouseInput.field719 < var15) {
                        var47 = true;
                     } else {
                        var47 = false;
                     }

                     boolean var48 = false;
                     if((MouseInput.field711 == 1 || !class51.field645 && MouseInput.field711 == 4) && var47) {
                        var48 = true;
                     }

                     boolean var49 = false;
                     if((MouseInput.field734 == 1 || !class51.field645 && MouseInput.field734 == 4) && MouseInput.field725 >= var12 && MouseInput.field726 >= var13 && MouseInput.field725 < var14 && MouseInput.field726 < var15) {
                        var49 = true;
                     }

                     if(var49) {
                        class5.method14(var9, MouseInput.field725 - var10, MouseInput.field726 - var11);
                     }

                     if(var9.contentType == 1400) {
                        BaseVarType.renderOverview.method5228(MouseInput.field718, MouseInput.field719, var47 & var48);
                     }

                     if(Client.field1117 != null && var9 != Client.field1117 && var47) {
                        var22 = class15.getWidgetConfig(var9);
                        boolean var50 = (var22 >> 20 & 1) != 0;
                        if(var50) {
                           Client.field1120 = var9;
                        }
                     }

                     if(var9 == Client.field1076) {
                        Client.field1080 = true;
                        Client.field1081 = var10;
                        Client.field1082 = var11;
                     }

                     if(var9.field2739) {
                        ScriptEvent var57;
                        if(var47 && Client.field1100 != 0 && var9.scrollListener != null) {
                           var57 = new ScriptEvent();
                           var57.field834 = true;
                           var57.widget = var9;
                           var57.field844 = Client.field1100;
                           var57.field849 = var9.scrollListener;
                           Client.field1101.addFront(var57);
                        }

                        if(Client.field1117 != null || class31.field451 != null || Client.isMenuOpen) {
                           var49 = false;
                           var48 = false;
                           var47 = false;
                        }

                        if(!var9.field2722 && var49) {
                           var9.field2722 = true;
                           if(var9.field2705 != null) {
                              var57 = new ScriptEvent();
                              var57.field834 = true;
                              var57.widget = var9;
                              var57.field837 = MouseInput.field725 - var10;
                              var57.field844 = MouseInput.field726 - var11;
                              var57.field849 = var9.field2705;
                              Client.field1101.addFront(var57);
                           }
                        }

                        if(var9.field2722 && var48 && var9.field2706 != null) {
                           var57 = new ScriptEvent();
                           var57.field834 = true;
                           var57.widget = var9;
                           var57.field837 = MouseInput.field718 - var10;
                           var57.field844 = MouseInput.field719 - var11;
                           var57.field849 = var9.field2706;
                           Client.field1101.addFront(var57);
                        }

                        if(var9.field2722 && !var48) {
                           var9.field2722 = false;
                           if(var9.field2707 != null) {
                              var57 = new ScriptEvent();
                              var57.field834 = true;
                              var57.widget = var9;
                              var57.field837 = MouseInput.field718 - var10;
                              var57.field844 = MouseInput.field719 - var11;
                              var57.field849 = var9.field2707;
                              Client.field1041.addFront(var57);
                           }
                        }

                        if(var48 && var9.field2711 != null) {
                           var57 = new ScriptEvent();
                           var57.field834 = true;
                           var57.widget = var9;
                           var57.field837 = MouseInput.field718 - var10;
                           var57.field844 = MouseInput.field719 - var11;
                           var57.field849 = var9.field2711;
                           Client.field1101.addFront(var57);
                        }

                        if(!var9.field2748 && var47) {
                           var9.field2748 = true;
                           if(var9.mouseEnterListener != null) {
                              var57 = new ScriptEvent();
                              var57.field834 = true;
                              var57.widget = var9;
                              var57.field837 = MouseInput.field718 - var10;
                              var57.field844 = MouseInput.field719 - var11;
                              var57.field849 = var9.mouseEnterListener;
                              Client.field1101.addFront(var57);
                           }
                        }

                        if(var9.field2748 && var47 && var9.mouseHoverListener != null) {
                           var57 = new ScriptEvent();
                           var57.field834 = true;
                           var57.widget = var9;
                           var57.field837 = MouseInput.field718 - var10;
                           var57.field844 = MouseInput.field719 - var11;
                           var57.field849 = var9.mouseHoverListener;
                           Client.field1101.addFront(var57);
                        }

                        if(var9.field2748 && !var47) {
                           var9.field2748 = false;
                           if(var9.mouseExitListener != null) {
                              var57 = new ScriptEvent();
                              var57.field834 = true;
                              var57.widget = var9;
                              var57.field837 = MouseInput.field718 - var10;
                              var57.field844 = MouseInput.field719 - var11;
                              var57.field849 = var9.mouseExitListener;
                              Client.field1041.addFront(var57);
                           }
                        }

                        if(var9.renderListener != null) {
                           var57 = new ScriptEvent();
                           var57.widget = var9;
                           var57.field849 = var9.renderListener;
                           Client.field1102.addFront(var57);
                        }

                        ScriptEvent var40;
                        if(var9.configListenerArgs != null && Client.field1174 > var9.field2708) {
                           if(var9.configTriggers != null && Client.field1174 - var9.field2708 <= 32) {
                              label1385:
                              for(var21 = var9.field2708; var21 < Client.field1174; ++var21) {
                                 var22 = Client.field1088[var21 & 31];

                                 for(var23 = 0; var23 < var9.configTriggers.length; ++var23) {
                                    if(var22 == var9.configTriggers[var23]) {
                                       var40 = new ScriptEvent();
                                       var40.widget = var9;
                                       var40.field849 = var9.configListenerArgs;
                                       Client.field1101.addFront(var40);
                                       break label1385;
                                    }
                                 }
                              }
                           } else {
                              var57 = new ScriptEvent();
                              var57.widget = var9;
                              var57.field849 = var9.configListenerArgs;
                              Client.field1101.addFront(var57);
                           }

                           var9.field2708 = Client.field1174;
                        }

                        if(var9.tableListenerArgs != null && Client.field1015 > var9.field2752) {
                           if(var9.tableModTriggers != null && Client.field1015 - var9.field2752 <= 32) {
                              label1361:
                              for(var21 = var9.field2752; var21 < Client.field1015; ++var21) {
                                 var22 = Client.interfaceItemTriggers[var21 & 31];

                                 for(var23 = 0; var23 < var9.tableModTriggers.length; ++var23) {
                                    if(var22 == var9.tableModTriggers[var23]) {
                                       var40 = new ScriptEvent();
                                       var40.widget = var9;
                                       var40.field849 = var9.tableListenerArgs;
                                       Client.field1101.addFront(var40);
                                       break label1361;
                                    }
                                 }
                              }
                           } else {
                              var57 = new ScriptEvent();
                              var57.widget = var9;
                              var57.field849 = var9.tableListenerArgs;
                              Client.field1101.addFront(var57);
                           }

                           var9.field2752 = Client.field1015;
                        }

                        if(var9.skillListenerArgs != null && Client.field1093 > var9.field2753) {
                           if(var9.skillTriggers != null && Client.field1093 - var9.field2753 <= 32) {
                              label1337:
                              for(var21 = var9.field2753; var21 < Client.field1093; ++var21) {
                                 var22 = Client.field1092[var21 & 31];

                                 for(var23 = 0; var23 < var9.skillTriggers.length; ++var23) {
                                    if(var22 == var9.skillTriggers[var23]) {
                                       var40 = new ScriptEvent();
                                       var40.widget = var9;
                                       var40.field849 = var9.skillListenerArgs;
                                       Client.field1101.addFront(var40);
                                       break label1337;
                                    }
                                 }
                              }
                           } else {
                              var57 = new ScriptEvent();
                              var57.widget = var9;
                              var57.field849 = var9.skillListenerArgs;
                              Client.field1101.addFront(var57);
                           }

                           var9.field2753 = Client.field1093;
                        }

                        if(Client.chatCycle > var9.field2686 && var9.field2750 != null) {
                           var57 = new ScriptEvent();
                           var57.widget = var9;
                           var57.field849 = var9.field2750;
                           Client.field1101.addFront(var57);
                        }

                        if(Client.field1091 > var9.field2686 && var9.field2742 != null) {
                           var57 = new ScriptEvent();
                           var57.widget = var9;
                           var57.field849 = var9.field2742;
                           Client.field1101.addFront(var57);
                        }

                        if(Client.field1096 > var9.field2686 && var9.field2728 != null) {
                           var57 = new ScriptEvent();
                           var57.widget = var9;
                           var57.field849 = var9.field2728;
                           Client.field1101.addFront(var57);
                        }

                        if(Client.field1097 > var9.field2686 && var9.field2733 != null) {
                           var57 = new ScriptEvent();
                           var57.widget = var9;
                           var57.field849 = var9.field2733;
                           Client.field1101.addFront(var57);
                        }

                        if(Client.field1046 > var9.field2686 && var9.field2716 != null) {
                           var57 = new ScriptEvent();
                           var57.widget = var9;
                           var57.field849 = var9.field2716;
                           Client.field1101.addFront(var57);
                        }

                        if(Client.field1099 > var9.field2686 && var9.field2675 != null) {
                           var57 = new ScriptEvent();
                           var57.widget = var9;
                           var57.field849 = var9.field2675;
                           Client.field1101.addFront(var57);
                        }

                        var9.field2686 = Client.cycleCntr;
                        if(var9.field2726 != null) {
                           for(var21 = 0; var21 < Client.field1124; ++var21) {
                              ScriptEvent var58 = new ScriptEvent();
                              var58.widget = var9;
                              var58.field841 = Client.field1113[var21];
                              var58.field842 = Client.field1125[var21];
                              var58.field849 = var9.field2726;
                              Client.field1101.addFront(var58);
                           }
                        }
                     }
                  }

                  if(!var9.hasScript && Client.field1117 == null && class31.field451 == null && !Client.isMenuOpen) {
                     if((var9.field2738 >= 0 || var9.field2650 != 0) && MouseInput.field718 >= var12 && MouseInput.field719 >= var13 && MouseInput.field718 < var14 && MouseInput.field719 < var15) {
                        if(var9.field2738 >= 0) {
                           class43.field569 = var0[var9.field2738];
                        } else {
                           class43.field569 = var9;
                        }
                     }

                     if(var9.type == 8 && MouseInput.field718 >= var12 && MouseInput.field719 >= var13 && MouseInput.field718 < var14 && MouseInput.field719 < var15) {
                        class47.field602 = var9;
                     }

                     if(var9.scrollHeight > var9.height) {
                        var19 = var10 + var9.width;
                        var20 = var9.height;
                        var21 = var9.scrollHeight;
                        var22 = MouseInput.field718;
                        var23 = MouseInput.field719;
                        if(Client.field983) {
                           Client.field984 = 32;
                        } else {
                           Client.field984 = 0;
                        }

                        Client.field983 = false;
                        if(MouseInput.field711 == 1 || !class51.field645 && MouseInput.field711 == 4) {
                           if(var22 >= var19 && var22 < var19 + 16 && var23 >= var11 && var23 < var11 + 16) {
                              var9.scrollY -= 4;
                              class255.method4531(var9);
                           } else if(var22 >= var19 && var22 < var19 + 16 && var23 >= var20 + var11 - 16 && var23 < var20 + var11) {
                              var9.scrollY += 4;
                              class255.method4531(var9);
                           } else if(var22 >= var19 - Client.field984 && var22 < var19 + Client.field984 + 16 && var23 >= var11 + 16 && var23 < var11 + var20 - 16) {
                              var24 = var20 * (var20 - 32) / var21;
                              if(var24 < 8) {
                                 var24 = 8;
                              }

                              var25 = var23 - var11 - 16 - var24 / 2;
                              var26 = var20 - 32 - var24;
                              var9.scrollY = var25 * (var21 - var20) / var26;
                              class255.method4531(var9);
                              Client.field983 = true;
                           }
                        }

                        if(Client.field1100 != 0) {
                           var24 = var9.width;
                           if(var22 >= var19 - var24 && var23 >= var11 && var22 < var19 + 16 && var23 <= var11 + var20) {
                              var9.scrollY += Client.field1100 * 45;
                              class255.method4531(var9);
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
