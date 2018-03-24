import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gh")
public class class190 {
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 1373246773
   )
   public static int field2496;

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(ILcj;ZI)I",
      garbageValue = "1155240435"
   )
   static int method3505(int var0, Script var1, boolean var2) {
      int var3;
      if(var0 == 3903) {
         var3 = class81.intStack[--class5.intStackSize];
         class81.intStack[++class5.intStackSize - 1] = Client.grandExchangeOffers[var3].type();
         return 1;
      } else if(var0 == 3904) {
         var3 = class81.intStack[--class5.intStackSize];
         class81.intStack[++class5.intStackSize - 1] = Client.grandExchangeOffers[var3].itemId;
         return 1;
      } else if(var0 == 3905) {
         var3 = class81.intStack[--class5.intStackSize];
         class81.intStack[++class5.intStackSize - 1] = Client.grandExchangeOffers[var3].price;
         return 1;
      } else if(var0 == 3906) {
         var3 = class81.intStack[--class5.intStackSize];
         class81.intStack[++class5.intStackSize - 1] = Client.grandExchangeOffers[var3].totalQuantity;
         return 1;
      } else if(var0 == 3907) {
         var3 = class81.intStack[--class5.intStackSize];
         class81.intStack[++class5.intStackSize - 1] = Client.grandExchangeOffers[var3].quantitySold;
         return 1;
      } else if(var0 == 3908) {
         var3 = class81.intStack[--class5.intStackSize];
         class81.intStack[++class5.intStackSize - 1] = Client.grandExchangeOffers[var3].spent;
         return 1;
      } else {
         int var12;
         if(var0 == 3910) {
            var3 = class81.intStack[--class5.intStackSize];
            var12 = Client.grandExchangeOffers[var3].status();
            class81.intStack[++class5.intStackSize - 1] = var12 == 0?1:0;
            return 1;
         } else if(var0 == 3911) {
            var3 = class81.intStack[--class5.intStackSize];
            var12 = Client.grandExchangeOffers[var3].status();
            class81.intStack[++class5.intStackSize - 1] = var12 == 2?1:0;
            return 1;
         } else if(var0 == 3912) {
            var3 = class81.intStack[--class5.intStackSize];
            var12 = Client.grandExchangeOffers[var3].status();
            class81.intStack[++class5.intStackSize - 1] = var12 == 5?1:0;
            return 1;
         } else if(var0 == 3913) {
            var3 = class81.intStack[--class5.intStackSize];
            var12 = Client.grandExchangeOffers[var3].status();
            class81.intStack[++class5.intStackSize - 1] = var12 == 1?1:0;
            return 1;
         } else {
            boolean var13;
            if(var0 == 3914) {
               var13 = class81.intStack[--class5.intStackSize] == 1;
               if(Occluder.grandExchangeEvents != null) {
                  Occluder.grandExchangeEvents.sort(GrandExchangeEvents.field268, var13);
               }

               return 1;
            } else if(var0 == 3915) {
               var13 = class81.intStack[--class5.intStackSize] == 1;
               if(Occluder.grandExchangeEvents != null) {
                  Occluder.grandExchangeEvents.sort(GrandExchangeEvents.field272, var13);
               }

               return 1;
            } else if(var0 == 3916) {
               class5.intStackSize -= 2;
               var13 = class81.intStack[class5.intStackSize] == 1;
               boolean var4 = class81.intStack[class5.intStackSize + 1] == 1;
               if(Occluder.grandExchangeEvents != null) {
                  Client.field1113.field846 = var4;
                  Occluder.grandExchangeEvents.sort(Client.field1113, var13);
               }

               return 1;
            } else if(var0 == 3917) {
               var13 = class81.intStack[--class5.intStackSize] == 1;
               if(Occluder.grandExchangeEvents != null) {
                  Occluder.grandExchangeEvents.sort(GrandExchangeEvents.field266, var13);
               }

               return 1;
            } else if(var0 == 3918) {
               var13 = class81.intStack[--class5.intStackSize] == 1;
               if(Occluder.grandExchangeEvents != null) {
                  Occluder.grandExchangeEvents.sort(GrandExchangeEvents.field264, var13);
               }

               return 1;
            } else if(var0 == 3919) {
               class81.intStack[++class5.intStackSize - 1] = Occluder.grandExchangeEvents == null?0:Occluder.grandExchangeEvents.events.size();
               return 1;
            } else {
               GrandExchangeEvent var11;
               if(var0 == 3920) {
                  var3 = class81.intStack[--class5.intStackSize];
                  var11 = (GrandExchangeEvent)Occluder.grandExchangeEvents.events.get(var3);
                  class81.intStack[++class5.intStackSize - 1] = var11.world;
                  return 1;
               } else if(var0 == 3921) {
                  var3 = class81.intStack[--class5.intStackSize];
                  var11 = (GrandExchangeEvent)Occluder.grandExchangeEvents.events.get(var3);
                  class81.scriptStringStack[++class316.scriptStringStackSize - 1] = var11.method82();
                  return 1;
               } else if(var0 == 3922) {
                  var3 = class81.intStack[--class5.intStackSize];
                  var11 = (GrandExchangeEvent)Occluder.grandExchangeEvents.events.get(var3);
                  class81.scriptStringStack[++class316.scriptStringStackSize - 1] = var11.method84();
                  return 1;
               } else if(var0 == 3923) {
                  var3 = class81.intStack[--class5.intStackSize];
                  var11 = (GrandExchangeEvent)Occluder.grandExchangeEvents.events.get(var3);
                  long var5 = WorldMapRegion.method465() - class204.field2603 - var11.field274;
                  int var7 = (int)(var5 / 3600000L);
                  int var8 = (int)((var5 - (long)(var7 * 3600000)) / 60000L);
                  int var9 = (int)((var5 - (long)(var7 * 3600000) - (long)(var8 * 60000)) / 1000L);
                  String var10 = var7 + ":" + var8 / 10 + var8 % 10 + ":" + var9 / 10 + var9 % 10;
                  class81.scriptStringStack[++class316.scriptStringStackSize - 1] = var10;
                  return 1;
               } else if(var0 == 3924) {
                  var3 = class81.intStack[--class5.intStackSize];
                  var11 = (GrandExchangeEvent)Occluder.grandExchangeEvents.events.get(var3);
                  class81.intStack[++class5.intStackSize - 1] = var11.grandExchangeOffer.totalQuantity;
                  return 1;
               } else if(var0 == 3925) {
                  var3 = class81.intStack[--class5.intStackSize];
                  var11 = (GrandExchangeEvent)Occluder.grandExchangeEvents.events.get(var3);
                  class81.intStack[++class5.intStackSize - 1] = var11.grandExchangeOffer.price;
                  return 1;
               } else if(var0 == 3926) {
                  var3 = class81.intStack[--class5.intStackSize];
                  var11 = (GrandExchangeEvent)Occluder.grandExchangeEvents.events.get(var3);
                  class81.intStack[++class5.intStackSize - 1] = var11.grandExchangeOffer.itemId;
                  return 1;
               } else {
                  return 2;
               }
            }
         }
      }
   }

   @ObfuscatedName("im")
   @ObfuscatedSignature(
      signature = "([Lig;IIIIIIII)V",
      garbageValue = "-422274378"
   )
   static final void method3504(Widget[] var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      for(int var8 = 0; var8 < var0.length; ++var8) {
         Widget var9 = var0[var8];
         if(var9 != null && (!var9.hasScript || var9.type == 0 || var9.field2878 || GrandExchangeEvent.getWidgetConfig(var9) != 0 || var9 == Client.field1020 || var9.contentType == 1338) && var9.parentId == var1) {
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
               Client.field1095 = true;
               Client.field1028 = var43;
               Client.field944 = var11;
            }

            if(!var9.hasScript || var12 < var14 && var13 < var15) {
               var16 = MouseInput.mouseLastX;
               var17 = MouseInput.mouseLastY;
               if(MouseInput.mouseLastButton != 0) {
                  var16 = MouseInput.mouseLastPressedX;
                  var17 = MouseInput.mouseLastPressedY;
               }

               boolean var44 = var16 >= var12 && var17 >= var13 && var16 < var14 && var17 < var15;
               int var20;
               int var22;
               int var23;
               int var24;
               int var25;
               int var26;
               int var47;
               if(var9.contentType == 1337) {
                  if(!Client.field949 && !Client.isMenuOpen && var44) {
                     if(Client.itemSelectionState == 0 && !Client.spellSelected) {
                        class169.addMenuEntry("Walk here", "", 23, 0, var16 - var12, var17 - var13);
                     }

                     var19 = -1;
                     var20 = -1;

                     for(var47 = 0; var47 < class132.Viewport_entityCountAtMouse; ++var47) {
                        var22 = class132.Viewport_entityIdsAtMouse[var47];
                        var23 = var22 & 127;
                        var24 = var22 >> 7 & 127;
                        var25 = var22 >> 29 & 3;
                        var26 = var22 >> 14 & 32767;
                        if(var20 != var22) {
                           var20 = var22;
                           if(var25 == 2 && class38.region.getObjectFlags(Ignore.plane, var23, var24, var22) >= 0) {
                              ObjectComposition var27 = Spotanim.getObjectDefinition(var26);
                              if(var27.impostorIds != null) {
                                 var27 = var27.getImpostor();
                              }

                              if(var27 == null) {
                                 continue;
                              }

                              if(Client.itemSelectionState == 1) {
                                 class169.addMenuEntry("Use", Client.lastSelectedItemName + " " + "->" + " " + class37.getColTags(65535) + var27.name, 1, var22, var23, var24);
                              } else if(Client.spellSelected) {
                                 if((class150.field2100 & 4) == 4) {
                                    class169.addMenuEntry(Client.field1006, Client.field1074 + " " + "->" + " " + class37.getColTags(65535) + var27.name, 2, var22, var23, var24);
                                 }
                              } else {
                                 String[] var28 = var27.actions;
                                 if(var28 != null) {
                                    for(int var29 = 4; var29 >= 0; --var29) {
                                       if(var28[var29] != null) {
                                          short var30 = 0;
                                          if(var29 == 0) {
                                             var30 = 3;
                                          }

                                          if(var29 == 1) {
                                             var30 = 4;
                                          }

                                          if(var29 == 2) {
                                             var30 = 5;
                                          }

                                          if(var29 == 3) {
                                             var30 = 6;
                                          }

                                          if(var29 == 4) {
                                             var30 = 1001;
                                          }

                                          class169.addMenuEntry(var28[var29], class37.getColTags(65535) + var27.name, var30, var22, var23, var24);
                                       }
                                    }
                                 }

                                 class169.addMenuEntry("Examine", class37.getColTags(65535) + var27.name, 1002, var27.id << 14, var23, var24);
                              }
                           }

                           Player var31;
                           int var38;
                           NPC var39;
                           int var52;
                           int[] var54;
                           if(var25 == 1) {
                              NPC var48 = Client.cachedNPCs[var26];
                              if(var48 == null) {
                                 continue;
                              }

                              if(var48.composition.field3710 == 1 && (var48.x & 127) == 64 && (var48.y & 127) == 64) {
                                 for(var38 = 0; var38 < Client.npcIndexesCount; ++var38) {
                                    var39 = Client.cachedNPCs[Client.npcIndices[var38]];
                                    if(var39 != null && var48 != var39 && var39.composition.field3710 == 1 && var39.x == var48.x && var39.y == var48.y) {
                                       UrlRequest.method3097(var39.composition, Client.npcIndices[var38], var23, var24);
                                    }
                                 }

                                 var38 = class93.playerIndexesCount;
                                 var54 = class93.playerIndices;

                                 for(var52 = 0; var52 < var38; ++var52) {
                                    var31 = Client.cachedPlayers[var54[var52]];
                                    if(var31 != null && var31.x == var48.x && var31.y == var48.y) {
                                       BoundingBox.method47(var31, var54[var52], var23, var24);
                                    }
                                 }
                              }

                              UrlRequest.method3097(var48.composition, var26, var23, var24);
                           }

                           if(var25 == 0) {
                              Player var49 = Client.cachedPlayers[var26];
                              if(var49 == null) {
                                 continue;
                              }

                              if((var49.x & 127) == 64 && (var49.y & 127) == 64) {
                                 for(var38 = 0; var38 < Client.npcIndexesCount; ++var38) {
                                    var39 = Client.cachedNPCs[Client.npcIndices[var38]];
                                    if(var39 != null && var39.composition.field3710 == 1 && var39.x == var49.x && var49.y == var39.y) {
                                       UrlRequest.method3097(var39.composition, Client.npcIndices[var38], var23, var24);
                                    }
                                 }

                                 var38 = class93.playerIndexesCount;
                                 var54 = class93.playerIndices;

                                 for(var52 = 0; var52 < var38; ++var52) {
                                    var31 = Client.cachedPlayers[var54[var52]];
                                    if(var31 != null && var31 != var49 && var49.x == var31.x && var31.y == var49.y) {
                                       BoundingBox.method47(var31, var54[var52], var23, var24);
                                    }
                                 }
                              }

                              if(var26 != Client.field890) {
                                 BoundingBox.method47(var49, var26, var23, var24);
                              } else {
                                 var19 = var22;
                              }
                           }

                           if(var25 == 3) {
                              Deque var51 = Client.groundItemDeque[Ignore.plane][var23][var24];
                              if(var51 != null) {
                                 for(Item var50 = (Item)var51.getTail(); var50 != null; var50 = (Item)var51.getPrevious()) {
                                    ItemComposition var55 = class81.getItemDefinition(var50.id);
                                    if(Client.itemSelectionState == 1) {
                                       class169.addMenuEntry("Use", Client.lastSelectedItemName + " " + "->" + " " + class37.getColTags(16748608) + var55.name, 16, var50.id, var23, var24);
                                    } else if(Client.spellSelected) {
                                       if((class150.field2100 & 1) == 1) {
                                          class169.addMenuEntry(Client.field1006, Client.field1074 + " " + "->" + " " + class37.getColTags(16748608) + var55.name, 17, var50.id, var23, var24);
                                       }
                                    } else {
                                       String[] var40 = var55.groundActions;

                                       for(int var41 = 4; var41 >= 0; --var41) {
                                          if(var40 != null && var40[var41] != null) {
                                             byte var32 = 0;
                                             if(var41 == 0) {
                                                var32 = 18;
                                             }

                                             if(var41 == 1) {
                                                var32 = 19;
                                             }

                                             if(var41 == 2) {
                                                var32 = 20;
                                             }

                                             if(var41 == 3) {
                                                var32 = 21;
                                             }

                                             if(var41 == 4) {
                                                var32 = 22;
                                             }

                                             class169.addMenuEntry(var40[var41], class37.getColTags(16748608) + var55.name, var32, var50.id, var23, var24);
                                          } else if(var41 == 2) {
                                             class169.addMenuEntry("Take", class37.getColTags(16748608) + var55.name, 20, var50.id, var23, var24);
                                          }
                                       }

                                       class169.addMenuEntry("Examine", class37.getColTags(16748608) + var55.name, 1004, var50.id, var23, var24);
                                    }
                                 }
                              }
                           }
                        }
                     }

                     if(var19 != -1) {
                        var47 = var19 & 127;
                        var22 = var19 >> 7 & 127;
                        Player var42 = Client.cachedPlayers[Client.field890];
                        BoundingBox.method47(var42, Client.field890, var47, var22);
                     }
                  }
               } else if(var9.contentType == 1338) {
                  BoundingBox2D.method37(var9, var43, var11);
               } else {
                  if(var9.contentType == 1400) {
                     class251.renderOverview.method5991(MouseInput.mouseLastX, MouseInput.mouseLastY, var44, var43, var11, var9.width, var9.height);
                  }

                  if(!Client.isMenuOpen && var44) {
                     if(var9.contentType == 1400) {
                        class251.renderOverview.method6080(var43, var11, var9.width, var9.height, var16, var17);
                     } else {
                        class95.method2027(var9, var16 - var43, var17 - var11);
                     }
                  }

                  boolean var45;
                  if(var9.type == 0) {
                     if(!var9.hasScript) {
                        var45 = var9.isHidden;
                        if(var45 && var9 != class28.field377) {
                           continue;
                        }
                     }

                     method3504(var0, var9.id, var12, var13, var14, var15, var43 - var9.scrollX, var11 - var9.scrollY);
                     if(var9.children != null) {
                        method3504(var9.children, var9.id, var12, var13, var14, var15, var43 - var9.scrollX, var11 - var9.scrollY);
                     }

                     WidgetNode var33 = (WidgetNode)Client.componentTable.get((long)var9.id);
                     if(var33 != null) {
                        if(var33.owner == 0 && MouseInput.mouseLastX >= var12 && MouseInput.mouseLastY >= var13 && MouseInput.mouseLastX < var14 && MouseInput.mouseLastY < var15 && !Client.isMenuOpen) {
                           for(ScriptEvent var34 = (ScriptEvent)Client.field1045.getFront(); var34 != null; var34 = (ScriptEvent)Client.field1045.getNext()) {
                              if(var34.boolean1) {
                                 var34.unlink();
                                 var34.widget.field2942 = false;
                              }
                           }

                           if(MapLabel.field446 == 0) {
                              Client.draggedWidget = null;
                              Client.field1020 = null;
                           }

                           if(!Client.isMenuOpen) {
                              GrandExchangeEvents.method79();
                           }
                        }

                        var20 = var33.id;
                        if(Script.loadWidget(var20)) {
                           method3504(Widget.widgets[var20], -1, var12, var13, var14, var15, var43, var11);
                        }
                     }
                  }

                  if(var9.hasScript) {
                     ScriptEvent var53;
                     if(!var9.noClickThrough) {
                        if(var9.field2951 && MouseInput.mouseLastX >= var12 && MouseInput.mouseLastY >= var13 && MouseInput.mouseLastX < var14 && MouseInput.mouseLastY < var15) {
                           for(var53 = (ScriptEvent)Client.field1045.getFront(); var53 != null; var53 = (ScriptEvent)Client.field1045.getNext()) {
                              if(var53.boolean1 && var53.widget.scrollListener == var53.objs) {
                                 var53.unlink();
                              }
                           }
                        }
                     } else if(MouseInput.mouseLastX >= var12 && MouseInput.mouseLastY >= var13 && MouseInput.mouseLastX < var14 && MouseInput.mouseLastY < var15) {
                        for(var53 = (ScriptEvent)Client.field1045.getFront(); var53 != null; var53 = (ScriptEvent)Client.field1045.getNext()) {
                           if(var53.boolean1) {
                              var53.unlink();
                              var53.widget.field2942 = false;
                           }
                        }

                        if(MapLabel.field446 == 0) {
                           Client.draggedWidget = null;
                           Client.field1020 = null;
                        }

                        if(!Client.isMenuOpen) {
                           GrandExchangeEvents.method79();
                        }
                     }

                     if(MouseInput.mouseLastX >= var12 && MouseInput.mouseLastY >= var13 && MouseInput.mouseLastX < var14 && MouseInput.mouseLastY < var15) {
                        var44 = true;
                     } else {
                        var44 = false;
                     }

                     var45 = false;
                     if((MouseInput.mouseCurrentButton == 1 || !class153.middleMouseMovesCamera && MouseInput.mouseCurrentButton == 4) && var44) {
                        var45 = true;
                     }

                     boolean var46 = false;
                     if((MouseInput.mouseLastButton == 1 || !class153.middleMouseMovesCamera && MouseInput.mouseLastButton == 4) && MouseInput.mouseLastPressedX >= var12 && MouseInput.mouseLastPressedY >= var13 && MouseInput.mouseLastPressedX < var14 && MouseInput.mouseLastPressedY < var15) {
                        var46 = true;
                     }

                     if(var46) {
                        WorldMapRegion.method534(var9, MouseInput.mouseLastPressedX - var43, MouseInput.mouseLastPressedY - var11);
                     }

                     if(var9.contentType == 1400) {
                        class251.renderOverview.method6122(var16, var17, var44 & var45, var44 & var46);
                     }

                     if(Client.draggedWidget != null && var9 != Client.draggedWidget && var44) {
                        var22 = GrandExchangeEvent.getWidgetConfig(var9);
                        boolean var21 = (var22 >> 20 & 1) != 0;
                        if(var21) {
                           Client.draggedOnWidget = var9;
                        }
                     }

                     if(var9 == Client.field1020) {
                        Client.field1024 = true;
                        Client.field1025 = var43;
                        Client.field1098 = var11;
                     }

                     if(var9.field2878) {
                        ScriptEvent var35;
                        if(var44 && Client.mouseWheelRotation != 0 && var9.scrollListener != null) {
                           var35 = new ScriptEvent();
                           var35.boolean1 = true;
                           var35.widget = var9;
                           var35.field789 = Client.mouseWheelRotation;
                           var35.objs = var9.scrollListener;
                           Client.field1045.addFront(var35);
                        }

                        if(Client.draggedWidget != null || MapIconReference.field574 != null || Client.isMenuOpen) {
                           var46 = false;
                           var45 = false;
                           var44 = false;
                        }

                        if(!var9.field2875 && var46) {
                           var9.field2875 = true;
                           if(var9.field2899 != null) {
                              var35 = new ScriptEvent();
                              var35.boolean1 = true;
                              var35.widget = var9;
                              var35.field782 = MouseInput.mouseLastPressedX - var43;
                              var35.field789 = MouseInput.mouseLastPressedY - var11;
                              var35.objs = var9.field2899;
                              Client.field1045.addFront(var35);
                           }
                        }

                        if(var9.field2875 && var45 && var9.field2900 != null) {
                           var35 = new ScriptEvent();
                           var35.boolean1 = true;
                           var35.widget = var9;
                           var35.field782 = MouseInput.mouseLastX - var43;
                           var35.field789 = MouseInput.mouseLastY - var11;
                           var35.objs = var9.field2900;
                           Client.field1045.addFront(var35);
                        }

                        if(var9.field2875 && !var45) {
                           var9.field2875 = false;
                           if(var9.field2901 != null) {
                              var35 = new ScriptEvent();
                              var35.boolean1 = true;
                              var35.widget = var9;
                              var35.field782 = MouseInput.mouseLastX - var43;
                              var35.field789 = MouseInput.mouseLastY - var11;
                              var35.objs = var9.field2901;
                              Client.field1047.addFront(var35);
                           }
                        }

                        if(var45 && var9.field2902 != null) {
                           var35 = new ScriptEvent();
                           var35.boolean1 = true;
                           var35.widget = var9;
                           var35.field782 = MouseInput.mouseLastX - var43;
                           var35.field789 = MouseInput.mouseLastY - var11;
                           var35.objs = var9.field2902;
                           Client.field1045.addFront(var35);
                        }

                        if(!var9.field2942 && var44) {
                           var9.field2942 = true;
                           if(var9.mouseEnterListener != null) {
                              var35 = new ScriptEvent();
                              var35.boolean1 = true;
                              var35.widget = var9;
                              var35.field782 = MouseInput.mouseLastX - var43;
                              var35.field789 = MouseInput.mouseLastY - var11;
                              var35.objs = var9.mouseEnterListener;
                              Client.field1045.addFront(var35);
                           }
                        }

                        if(var9.field2942 && var44 && var9.mouseHoverListener != null) {
                           var35 = new ScriptEvent();
                           var35.boolean1 = true;
                           var35.widget = var9;
                           var35.field782 = MouseInput.mouseLastX - var43;
                           var35.field789 = MouseInput.mouseLastY - var11;
                           var35.objs = var9.mouseHoverListener;
                           Client.field1045.addFront(var35);
                        }

                        if(var9.field2942 && !var44) {
                           var9.field2942 = false;
                           if(var9.mouseExitListener != null) {
                              var35 = new ScriptEvent();
                              var35.boolean1 = true;
                              var35.widget = var9;
                              var35.field782 = MouseInput.mouseLastX - var43;
                              var35.field789 = MouseInput.mouseLastY - var11;
                              var35.objs = var9.mouseExitListener;
                              Client.field1047.addFront(var35);
                           }
                        }

                        if(var9.renderListener != null) {
                           var35 = new ScriptEvent();
                           var35.widget = var9;
                           var35.objs = var9.renderListener;
                           Client.field1046.addFront(var35);
                        }

                        ScriptEvent var36;
                        if(var9.configListenerArgs != null && Client.field1033 > var9.field2945) {
                           if(var9.configTriggers != null && Client.field1033 - var9.field2945 <= 32) {
                              label1202:
                              for(var47 = var9.field2945; var47 < Client.field1033; ++var47) {
                                 var22 = Client.field1032[var47 & 31];

                                 for(var23 = 0; var23 < var9.configTriggers.length; ++var23) {
                                    if(var22 == var9.configTriggers[var23]) {
                                       var36 = new ScriptEvent();
                                       var36.widget = var9;
                                       var36.objs = var9.configListenerArgs;
                                       Client.field1045.addFront(var36);
                                       break label1202;
                                    }
                                 }
                              }
                           } else {
                              var35 = new ScriptEvent();
                              var35.widget = var9;
                              var35.objs = var9.configListenerArgs;
                              Client.field1045.addFront(var35);
                           }

                           var9.field2945 = Client.field1033;
                        }

                        if(var9.tableListenerArgs != null && Client.field1035 > var9.field2946) {
                           if(var9.tableModTriggers != null && Client.field1035 - var9.field2946 <= 32) {
                              label1178:
                              for(var47 = var9.field2946; var47 < Client.field1035; ++var47) {
                                 var22 = Client.interfaceItemTriggers[var47 & 31];

                                 for(var23 = 0; var23 < var9.tableModTriggers.length; ++var23) {
                                    if(var22 == var9.tableModTriggers[var23]) {
                                       var36 = new ScriptEvent();
                                       var36.widget = var9;
                                       var36.objs = var9.tableListenerArgs;
                                       Client.field1045.addFront(var36);
                                       break label1178;
                                    }
                                 }
                              }
                           } else {
                              var35 = new ScriptEvent();
                              var35.widget = var9;
                              var35.objs = var9.tableListenerArgs;
                              Client.field1045.addFront(var35);
                           }

                           var9.field2946 = Client.field1035;
                        }

                        if(var9.skillListenerArgs != null && Client.field1037 > var9.field2947) {
                           if(var9.skillTriggers != null && Client.field1037 - var9.field2947 <= 32) {
                              label1154:
                              for(var47 = var9.field2947; var47 < Client.field1037; ++var47) {
                                 var22 = Client.field894[var47 & 31];

                                 for(var23 = 0; var23 < var9.skillTriggers.length; ++var23) {
                                    if(var22 == var9.skillTriggers[var23]) {
                                       var36 = new ScriptEvent();
                                       var36.widget = var9;
                                       var36.objs = var9.skillListenerArgs;
                                       Client.field1045.addFront(var36);
                                       break label1154;
                                    }
                                 }
                              }
                           } else {
                              var35 = new ScriptEvent();
                              var35.widget = var9;
                              var35.objs = var9.skillListenerArgs;
                              Client.field1045.addFront(var35);
                           }

                           var9.field2947 = Client.field1037;
                        }

                        if(Client.chatCycle > var9.field2944 && var9.field2919 != null) {
                           var35 = new ScriptEvent();
                           var35.widget = var9;
                           var35.objs = var9.field2919;
                           Client.field1045.addFront(var35);
                        }

                        if(Client.field1039 > var9.field2944 && var9.field2921 != null) {
                           var35 = new ScriptEvent();
                           var35.widget = var9;
                           var35.objs = var9.field2921;
                           Client.field1045.addFront(var35);
                        }

                        if(Client.field892 > var9.field2944 && var9.field2922 != null) {
                           var35 = new ScriptEvent();
                           var35.widget = var9;
                           var35.objs = var9.field2922;
                           Client.field1045.addFront(var35);
                        }

                        if(Client.field1057 > var9.field2944 && var9.field2873 != null) {
                           var35 = new ScriptEvent();
                           var35.widget = var9;
                           var35.objs = var9.field2873;
                           Client.field1045.addFront(var35);
                        }

                        if(Client.field913 > var9.field2944 && var9.field2820 != null) {
                           var35 = new ScriptEvent();
                           var35.widget = var9;
                           var35.objs = var9.field2820;
                           Client.field1045.addFront(var35);
                        }

                        if(Client.field981 > var9.field2944 && var9.field2923 != null) {
                           var35 = new ScriptEvent();
                           var35.widget = var9;
                           var35.objs = var9.field2923;
                           Client.field1045.addFront(var35);
                        }

                        var9.field2944 = Client.cycleCntr;
                        if(var9.field2920 != null) {
                           for(var47 = 0; var47 < Client.field869; ++var47) {
                              ScriptEvent var37 = new ScriptEvent();
                              var37.widget = var9;
                              var37.field780 = Client.field1069[var47];
                              var37.field781 = Client.field1068[var47];
                              var37.objs = var9.field2920;
                              Client.field1045.addFront(var37);
                           }
                        }
                     }
                  }

                  if(!var9.hasScript && Client.draggedWidget == null && MapIconReference.field574 == null && !Client.isMenuOpen) {
                     if((var9.field2932 >= 0 || var9.field2844 != 0) && MouseInput.mouseLastX >= var12 && MouseInput.mouseLastY >= var13 && MouseInput.mouseLastX < var14 && MouseInput.mouseLastY < var15) {
                        if(var9.field2932 >= 0) {
                           class28.field377 = var0[var9.field2932];
                        } else {
                           class28.field377 = var9;
                        }
                     }

                     if(var9.type == 8 && MouseInput.mouseLastX >= var12 && MouseInput.mouseLastY >= var13 && MouseInput.mouseLastX < var14 && MouseInput.mouseLastY < var15) {
                        FileRequest.field3371 = var9;
                     }

                     if(var9.scrollHeight > var9.height) {
                        var19 = var43 + var9.width;
                        var20 = var9.height;
                        var47 = var9.scrollHeight;
                        var22 = MouseInput.mouseLastX;
                        var23 = MouseInput.mouseLastY;
                        if(Client.field915) {
                           Client.field1018 = 32;
                        } else {
                           Client.field1018 = 0;
                        }

                        Client.field915 = false;
                        if(MouseInput.mouseCurrentButton == 1 || !class153.middleMouseMovesCamera && MouseInput.mouseCurrentButton == 4) {
                           if(var22 >= var19 && var22 < var19 + 16 && var23 >= var11 && var23 < var11 + 16) {
                              var9.scrollY -= 4;
                              GameEngine.method1053(var9);
                           } else if(var22 >= var19 && var22 < var19 + 16 && var23 >= var20 + var11 - 16 && var23 < var11 + var20) {
                              var9.scrollY += 4;
                              GameEngine.method1053(var9);
                           } else if(var22 >= var19 - Client.field1018 && var22 < var19 + Client.field1018 + 16 && var23 >= var11 + 16 && var23 < var11 + var20 - 16) {
                              var24 = var20 * (var20 - 32) / var47;
                              if(var24 < 8) {
                                 var24 = 8;
                              }

                              var25 = var23 - var11 - 16 - var24 / 2;
                              var26 = var20 - 32 - var24;
                              var9.scrollY = var25 * (var47 - var20) / var26;
                              GameEngine.method1053(var9);
                              Client.field915 = true;
                           }
                        }

                        if(Client.mouseWheelRotation != 0) {
                           var24 = var9.width;
                           if(var22 >= var19 - var24 && var23 >= var11 && var22 < var19 + 16 && var23 <= var20 + var11) {
                              var9.scrollY += Client.mouseWheelRotation * 45;
                              GameEngine.method1053(var9);
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
