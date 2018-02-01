import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bj")
@Implements("CombatInfo1")
public class CombatInfo1 extends Node {
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -1778340869
   )
   @Export("cycle")
   int cycle;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 704853951
   )
   @Export("healthRatio")
   int healthRatio;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 1042724545
   )
   @Export("health")
   int health;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 246089991
   )
   @Export("int2")
   int int2;

   CombatInfo1(int var1, int var2, int var3, int var4) {
      this.cycle = var1;
      this.healthRatio = var2;
      this.health = var3;
      this.int2 = var4;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "370370272"
   )
   @Export("set")
   void set(int var1, int var2, int var3, int var4) {
      this.cycle = var1;
      this.healthRatio = var2;
      this.health = var3;
      this.int2 = var4;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(IB)Ljj;",
      garbageValue = "4"
   )
   @Export("getItemDefinition")
   public static ItemComposition getItemDefinition(int var0) {
      ItemComposition var1 = (ItemComposition)ItemComposition.items.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = class23.item_ref.getConfigData(10, var0);
         var1 = new ItemComposition();
         var1.id = var0;
         if(var2 != null) {
            var1.loadBuffer(new Buffer(var2));
         }

         var1.post();
         if(var1.notedTemplate != -1) {
            var1.method4839(getItemDefinition(var1.notedTemplate), getItemDefinition(var1.note));
         }

         if(var1.notedId != -1) {
            var1.method4867(getItemDefinition(var1.notedId), getItemDefinition(var1.unnotedId));
         }

         if(var1.int3 != -1) {
            var1.method4876(getItemDefinition(var1.int3), getItemDefinition(var1.int2));
         }

         if(!class255.isMembersWorld && var1.isMembers) {
            var1.name = "Members object";
            var1.isTradable = false;
            var1.groundActions = null;
            var1.inventoryActions = null;
            var1.team = -1;
            var1.int1 = 0;
            if(var1.field3595 != null) {
               boolean var3 = false;

               for(Node var4 = var1.field3595.getHead(); var4 != null; var4 = var1.field3595.getTail()) {
                  class262 var5 = class157.method3115((int)var4.hash);
                  if(var5.field3450) {
                     var4.unlink();
                  } else {
                     var3 = true;
                  }
               }

               if(!var3) {
                  var1.field3595 = null;
               }
            }
         }

         ItemComposition.items.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(ILcd;ZB)I",
      garbageValue = "3"
   )
   static int method1600(int var0, Script var1, boolean var2) {
      int var3 = -1;
      Widget var4;
      if(var0 >= 2000) {
         var0 -= 1000;
         var3 = class80.intStack[--class80.intStackSize];
         var4 = class35.getWidget(var3);
      } else {
         var4 = var2?class23.field331:GrandExchangeOffer.field297;
      }

      if(var0 == 1000) {
         class80.intStackSize -= 4;
         var4.originalX = class80.intStack[class80.intStackSize];
         var4.originalY = class80.intStack[class80.intStackSize + 1];
         var4.dynamicX = class80.intStack[class80.intStackSize + 2];
         var4.dynamicY = class80.intStack[class80.intStackSize + 3];
         class60.method1015(var4);
         class37.clientInstance.widgetMethod0(var4);
         if(var3 != -1 && var4.type == 0) {
            class33.method362(FileRequest.widgets[var3 >> 16], var4, false);
         }

         return 1;
      } else if(var0 == 1001) {
         class80.intStackSize -= 4;
         var4.originalWidth = class80.intStack[class80.intStackSize];
         var4.originalHeight = class80.intStack[class80.intStackSize + 1];
         var4.dynamicWidth = class80.intStack[class80.intStackSize + 2];
         var4.buttonType = class80.intStack[class80.intStackSize + 3];
         class60.method1015(var4);
         class37.clientInstance.widgetMethod0(var4);
         if(var3 != -1 && var4.type == 0) {
            class33.method362(FileRequest.widgets[var3 >> 16], var4, false);
         }

         return 1;
      } else if(var0 == 1003) {
         boolean var5 = class80.intStack[--class80.intStackSize] == 1;
         if(var5 != var4.isHidden) {
            var4.isHidden = var5;
            class60.method1015(var4);
         }

         return 1;
      } else if(var0 == 1005) {
         var4.noClickThrough = class80.intStack[--class80.intStackSize] == 1;
         return 1;
      } else if(var0 == 1006) {
         var4.field2866 = class80.intStack[--class80.intStackSize] == 1;
         return 1;
      } else {
         return 2;
      }
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "533170668"
   )
   public static int method1606(int var0) {
      return var0 > 0?1:(var0 < 0?-1:0);
   }

   @ObfuscatedName("jn")
   @ObfuscatedSignature(
      signature = "([Lho;IIIIIIII)V",
      garbageValue = "2136317640"
   )
   static final void method1599(Widget[] var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      for(int var8 = 0; var8 < var0.length; ++var8) {
         Widget var9 = var0[var8];
         if(var9 != null && (!var9.hasScript || var9.type == 0 || var9.field2813 || class60.getWidgetConfig(var9) != 0 || var9 == Client.field981 || var9.contentType == 1338) && var9.parentId == var1 && (!var9.hasScript || !WorldMapType3.method220(var9))) {
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

            if(var9 == Client.field980) {
               Client.field988 = true;
               Client.field989 = var10;
               Client.field990 = var11;
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
               int var21;
               int var22;
               int var23;
               int var24;
               int var25;
               int var28;
               int var29;
               if(var9.contentType == 1337) {
                  if(!Client.field830 && !Client.isMenuOpen && var44) {
                     if(Client.itemSelectionState == 0 && !Client.spellSelected) {
                        class3.addMenuEntry("Walk here", "", 23, 0, var16 - var12, var17 - var13);
                     }

                     var19 = -1;
                     var20 = -1;

                     for(var21 = 0; var21 < class131.Viewport_entityCountAtMouse; ++var21) {
                        var22 = class131.Viewport_entityIdsAtMouse[var21];
                        var23 = var22 & 127;
                        var24 = var22 >> 7 & 127;
                        var25 = var22 >> 29 & 3;
                        int var26 = var22 >> 14 & 32767;
                        if(var22 != var20) {
                           var20 = var22;
                           if(var25 == 2 && class48.region.getObjectFlags(MessageNode.plane, var23, var24, var22) >= 0) {
                              ObjectComposition var48 = TextureProvider.getObjectDefinition(var26);
                              if(var48.impostorIds != null) {
                                 var48 = var48.getImpostor();
                              }

                              if(var48 == null) {
                                 continue;
                              }

                              if(Client.itemSelectionState == 1) {
                                 class3.addMenuEntry("Use", Client.lastSelectedItemName + " " + "->" + " " + class1.getColTags(65535) + var48.name, 1, var22, var23, var24);
                              } else if(Client.spellSelected) {
                                 if((GameCanvas.field603 & 4) == 4) {
                                    class3.addMenuEntry(Client.field1001, Client.field966 + " " + "->" + " " + class1.getColTags(65535) + var48.name, 2, var22, var23, var24);
                                 }
                              } else {
                                 String[] var41 = var48.actions;
                                 if(Client.numberMenuOptions) {
                                    var41 = GrandExchangeOffer.prependIndices(var41);
                                 }

                                 if(var41 != null) {
                                    for(var29 = 4; var29 >= 0; --var29) {
                                       if(var41[var29] != null) {
                                          short var52 = 0;
                                          if(var29 == 0) {
                                             var52 = 3;
                                          }

                                          if(var29 == 1) {
                                             var52 = 4;
                                          }

                                          if(var29 == 2) {
                                             var52 = 5;
                                          }

                                          if(var29 == 3) {
                                             var52 = 6;
                                          }

                                          if(var29 == 4) {
                                             var52 = 1001;
                                          }

                                          class3.addMenuEntry(var41[var29], class1.getColTags(65535) + var48.name, var52, var22, var23, var24);
                                       }
                                    }
                                 }

                                 class3.addMenuEntry("Examine", class1.getColTags(65535) + var48.name, 1002, var48.id << 14, var23, var24);
                              }
                           }

                           Player var31;
                           NPC var40;
                           int var54;
                           int[] var58;
                           if(var25 == 1) {
                              NPC var49 = Client.cachedNPCs[var26];
                              if(var49 == null) {
                                 continue;
                              }

                              if(var49.composition.field3611 == 1 && (var49.x & 127) == 64 && (var49.y & 127) == 64) {
                                 for(var28 = 0; var28 < Client.npcIndexesCount; ++var28) {
                                    var40 = Client.cachedNPCs[Client.npcIndices[var28]];
                                    if(var40 != null && var40 != var49 && var40.composition.field3611 == 1 && var49.x == var40.x && var49.y == var40.y) {
                                       Huffman.method3335(var40.composition, Client.npcIndices[var28], var23, var24);
                                    }
                                 }

                                 var28 = class92.playerIndexesCount;
                                 var58 = class92.playerIndices;

                                 for(var54 = 0; var54 < var28; ++var54) {
                                    var31 = Client.cachedPlayers[var58[var54]];
                                    if(var31 != null && var49.x == var31.x && var49.y == var31.y) {
                                       class29.method257(var31, var58[var54], var23, var24);
                                    }
                                 }
                              }

                              Huffman.method3335(var49.composition, var26, var23, var24);
                           }

                           if(var25 == 0) {
                              Player var50 = Client.cachedPlayers[var26];
                              if(var50 == null) {
                                 continue;
                              }

                              if((var50.x & 127) == 64 && (var50.y & 127) == 64) {
                                 for(var28 = 0; var28 < Client.npcIndexesCount; ++var28) {
                                    var40 = Client.cachedNPCs[Client.npcIndices[var28]];
                                    if(var40 != null && var40.composition.field3611 == 1 && var40.x == var50.x && var50.y == var40.y) {
                                       Huffman.method3335(var40.composition, Client.npcIndices[var28], var23, var24);
                                    }
                                 }

                                 var28 = class92.playerIndexesCount;
                                 var58 = class92.playerIndices;

                                 for(var54 = 0; var54 < var28; ++var54) {
                                    var31 = Client.cachedPlayers[var58[var54]];
                                    if(var31 != null && var50 != var31 && var31.x == var50.x && var31.y == var50.y) {
                                       class29.method257(var31, var58[var54], var23, var24);
                                    }
                                 }
                              }

                              if(var26 != Client.field935) {
                                 class29.method257(var50, var26, var23, var24);
                              } else {
                                 var19 = var22;
                              }
                           }

                           if(var25 == 3) {
                              Deque var51 = Client.groundItemDeque[MessageNode.plane][var23][var24];
                              if(var51 != null) {
                                 for(Item var60 = (Item)var51.getTail(); var60 != null; var60 = (Item)var51.getPrevious()) {
                                    ItemComposition var59 = getItemDefinition(var60.id);
                                    if(Client.itemSelectionState == 1) {
                                       class3.addMenuEntry("Use", Client.lastSelectedItemName + " " + "->" + " " + class1.getColTags(16748608) + var59.name, 16, var60.id, var23, var24);
                                    } else if(Client.spellSelected) {
                                       if((GameCanvas.field603 & 1) == 1) {
                                          class3.addMenuEntry(Client.field1001, Client.field966 + " " + "->" + " " + class1.getColTags(16748608) + var59.name, 17, var60.id, var23, var24);
                                       }
                                    } else {
                                       String[] var42 = var59.groundActions;
                                       if(Client.numberMenuOptions) {
                                          var42 = GrandExchangeOffer.prependIndices(var42);
                                       }

                                       for(int var43 = 4; var43 >= 0; --var43) {
                                          if(var42 != null && var42[var43] != null) {
                                             byte var32 = 0;
                                             if(var43 == 0) {
                                                var32 = 18;
                                             }

                                             if(var43 == 1) {
                                                var32 = 19;
                                             }

                                             if(var43 == 2) {
                                                var32 = 20;
                                             }

                                             if(var43 == 3) {
                                                var32 = 21;
                                             }

                                             if(var43 == 4) {
                                                var32 = 22;
                                             }

                                             class3.addMenuEntry(var42[var43], class1.getColTags(16748608) + var59.name, var32, var60.id, var23, var24);
                                          } else if(var43 == 2) {
                                             class3.addMenuEntry("Take", class1.getColTags(16748608) + var59.name, 20, var60.id, var23, var24);
                                          }
                                       }

                                       class3.addMenuEntry("Examine", class1.getColTags(16748608) + var59.name, 1004, var60.id, var23, var24);
                                    }
                                 }
                              }
                           }
                        }
                     }

                     if(var19 != -1) {
                        var21 = var19 & 127;
                        var22 = var19 >> 7 & 127;
                        Player var55 = Client.cachedPlayers[Client.field935];
                        class29.method257(var55, Client.field935, var21, var22);
                     }
                  }
               } else if(var9.contentType == 1338) {
                  Script.method2000(var9, var10, var11);
               } else {
                  if(var9.contentType == 1400) {
                     ScriptState.renderOverview.method5663(MouseInput.mouseLastX, MouseInput.mouseLastY, var44, var10, var11, var9.width, var9.height);
                  }

                  boolean var47;
                  if(!Client.isMenuOpen && var44) {
                     if(var9.contentType == 1400) {
                        ScriptState.renderOverview.method5691(var10, var11, var9.width, var9.height, var16, var17);
                     } else {
                        var19 = var16 - var10;
                        var20 = var17 - var11;
                        if(var9.field2741 == 1) {
                           class3.addMenuEntry(var9.tooltip, "", 24, 0, 0, var9.id);
                        }

                        String var36;
                        if(var9.field2741 == 2 && !Client.spellSelected) {
                           var36 = class41.method589(var9);
                           if(var36 != null) {
                              class3.addMenuEntry(var36, class1.getColTags(65280) + var9.spellName, 25, 0, -1, var9.id);
                           }
                        }

                        if(var9.field2741 == 3) {
                           class3.addMenuEntry("Close", "", 26, 0, 0, var9.id);
                        }

                        if(var9.field2741 == 4) {
                           class3.addMenuEntry(var9.tooltip, "", 28, 0, 0, var9.id);
                        }

                        if(var9.field2741 == 5) {
                           class3.addMenuEntry(var9.tooltip, "", 29, 0, 0, var9.id);
                        }

                        if(var9.field2741 == 6 && Client.field971 == null) {
                           class3.addMenuEntry(var9.tooltip, "", 30, 0, -1, var9.id);
                        }

                        if(var9.type == 2) {
                           var21 = 0;

                           for(var22 = 0; var22 < var9.height; ++var22) {
                              for(var23 = 0; var23 < var9.width; ++var23) {
                                 var24 = var23 * (var9.paddingX + 32);
                                 var25 = var22 * (var9.paddingY + 32);
                                 if(var21 < 20) {
                                    var24 += var9.xSprites[var21];
                                    var25 += var9.field2807[var21];
                                 }

                                 if(var19 >= var24 && var20 >= var25 && var19 < var24 + 32 && var20 < var25 + 32) {
                                    Client.field922 = var21;
                                    FontName.field3732 = var9;
                                    if(var9.itemIds[var21] > 0) {
                                       ItemComposition var39 = getItemDefinition(var9.itemIds[var21] - 1);
                                       if(Client.itemSelectionState == 1 && NetWriter.method2042(class60.getWidgetConfig(var9))) {
                                          if(var9.id != class37.field476 || var21 != FontName.selectedItemIndex) {
                                             class3.addMenuEntry("Use", Client.lastSelectedItemName + " " + "->" + " " + class1.getColTags(16748608) + var39.name, 31, var39.id, var21, var9.id);
                                          }
                                       } else if(Client.spellSelected && NetWriter.method2042(class60.getWidgetConfig(var9))) {
                                          if((GameCanvas.field603 & 16) == 16) {
                                             class3.addMenuEntry(Client.field1001, Client.field966 + " " + "->" + " " + class1.getColTags(16748608) + var39.name, 32, var39.id, var21, var9.id);
                                          }
                                       } else {
                                          String[] var27 = var39.inventoryActions;
                                          if(Client.numberMenuOptions) {
                                             var27 = GrandExchangeOffer.prependIndices(var27);
                                          }

                                          var28 = -1;
                                          if(Client.field954 && KeyFocusListener.keyPressed[81]) {
                                             var28 = var39.method4841();
                                          }

                                          if(NetWriter.method2042(class60.getWidgetConfig(var9))) {
                                             for(var29 = 4; var29 >= 3; --var29) {
                                                if(var29 != var28) {
                                                   class89.method1903(var9, var39, var21, var29, false);
                                                }
                                             }
                                          }

                                          if(PlayerComposition.method4245(class60.getWidgetConfig(var9))) {
                                             class3.addMenuEntry("Use", class1.getColTags(16748608) + var39.name, 38, var39.id, var21, var9.id);
                                          }

                                          if(NetWriter.method2042(class60.getWidgetConfig(var9))) {
                                             for(var29 = 2; var29 >= 0; --var29) {
                                                if(var28 != var29) {
                                                   class89.method1903(var9, var39, var21, var29, false);
                                                }
                                             }

                                             if(var28 >= 0) {
                                                class89.method1903(var9, var39, var21, var28, true);
                                             }
                                          }

                                          var27 = var9.configActions;
                                          if(Client.numberMenuOptions) {
                                             var27 = GrandExchangeOffer.prependIndices(var27);
                                          }

                                          if(var27 != null) {
                                             for(var29 = 4; var29 >= 0; --var29) {
                                                if(var27[var29] != null) {
                                                   byte var30 = 0;
                                                   if(var29 == 0) {
                                                      var30 = 39;
                                                   }

                                                   if(var29 == 1) {
                                                      var30 = 40;
                                                   }

                                                   if(var29 == 2) {
                                                      var30 = 41;
                                                   }

                                                   if(var29 == 3) {
                                                      var30 = 42;
                                                   }

                                                   if(var29 == 4) {
                                                      var30 = 43;
                                                   }

                                                   class3.addMenuEntry(var27[var29], class1.getColTags(16748608) + var39.name, var30, var39.id, var21, var9.id);
                                                }
                                             }
                                          }

                                          class3.addMenuEntry("Examine", class1.getColTags(16748608) + var39.name, 1005, var39.id, var21, var9.id);
                                       }
                                    }
                                 }

                                 ++var21;
                              }
                           }
                        }

                        if(var9.hasScript) {
                           if(Client.spellSelected) {
                              var22 = class60.getWidgetConfig(var9);
                              var47 = (var22 >> 21 & 1) != 0;
                              if(var47 && (GameCanvas.field603 & 32) == 32) {
                                 class3.addMenuEntry(Client.field1001, Client.field966 + " " + "->" + " " + var9.name, 58, 0, var9.index, var9.id);
                              }
                           } else {
                              for(var21 = 9; var21 >= 5; --var21) {
                                 String var38 = class44.method627(var9, var21);
                                 if(var38 != null) {
                                    class3.addMenuEntry(var38, var9.name, 1007, var21 + 1, var9.index, var9.id);
                                 }
                              }

                              var36 = class41.method589(var9);
                              if(var36 != null) {
                                 class3.addMenuEntry(var36, var9.name, 25, 0, var9.index, var9.id);
                              }

                              for(var22 = 4; var22 >= 0; --var22) {
                                 String var35 = class44.method627(var9, var22);
                                 if(var35 != null) {
                                    class3.addMenuEntry(var35, var9.name, 57, var22 + 1, var9.index, var9.id);
                                 }
                              }

                              if(WorldMapType2.method534(class60.getWidgetConfig(var9))) {
                                 class3.addMenuEntry("Continue", "", 30, 0, var9.index, var9.id);
                              }
                           }
                        }
                     }
                  }

                  if(var9.type == 0) {
                     if(!var9.hasScript && WorldMapType3.method220(var9) && var9 != FileRequest.field3287) {
                        continue;
                     }

                     method1599(var0, var9.id, var12, var13, var14, var15, var10 - var9.scrollX, var11 - var9.scrollY);
                     if(var9.children != null) {
                        method1599(var9.children, var9.id, var12, var13, var14, var15, var10 - var9.scrollX, var11 - var9.scrollY);
                     }

                     WidgetNode var33 = (WidgetNode)Client.componentTable.get((long)var9.id);
                     if(var33 != null) {
                        if(var33.owner == 0 && MouseInput.mouseLastX >= var12 && MouseInput.mouseLastY >= var13 && MouseInput.mouseLastX < var14 && MouseInput.mouseLastY < var15 && !Client.isMenuOpen && !Client.field977) {
                           for(ScriptEvent var34 = (ScriptEvent)Client.field1006.getFront(); var34 != null; var34 = (ScriptEvent)Client.field1006.getNext()) {
                              if(var34.boolean1) {
                                 var34.unlink();
                                 var34.widget.field2863 = false;
                              }
                           }

                           if(VarPlayerType.field3350 == 0) {
                              Client.field980 = null;
                              Client.field981 = null;
                           }

                           if(!Client.isMenuOpen) {
                              Widget.method4302();
                           }
                        }

                        CombatInfo2.method4674(var33.id, var12, var13, var14, var15, var10, var11);
                     }
                  }

                  if(var9.hasScript) {
                     ScriptEvent var53;
                     if(!var9.noClickThrough) {
                        if(var9.field2866 && MouseInput.mouseLastX >= var12 && MouseInput.mouseLastY >= var13 && MouseInput.mouseLastX < var14 && MouseInput.mouseLastY < var15) {
                           for(var53 = (ScriptEvent)Client.field1006.getFront(); var53 != null; var53 = (ScriptEvent)Client.field1006.getNext()) {
                              if(var53.boolean1 && var53.widget.scrollListener == var53.objs) {
                                 var53.unlink();
                              }
                           }
                        }
                     } else if(MouseInput.mouseLastX >= var12 && MouseInput.mouseLastY >= var13 && MouseInput.mouseLastX < var14 && MouseInput.mouseLastY < var15) {
                        for(var53 = (ScriptEvent)Client.field1006.getFront(); var53 != null; var53 = (ScriptEvent)Client.field1006.getNext()) {
                           if(var53.boolean1) {
                              var53.unlink();
                              var53.widget.field2863 = false;
                           }
                        }

                        if(VarPlayerType.field3350 == 0) {
                           Client.field980 = null;
                           Client.field981 = null;
                        }

                        if(!Client.isMenuOpen) {
                           Widget.method4302();
                        }
                     }

                     if(MouseInput.mouseLastX >= var12 && MouseInput.mouseLastY >= var13 && MouseInput.mouseLastX < var14 && MouseInput.mouseLastY < var15) {
                        var44 = true;
                     } else {
                        var44 = false;
                     }

                     boolean var46 = false;
                     if((MouseInput.mouseCurrentButton == 1 || !Client.middleMouseMovesCamera && MouseInput.mouseCurrentButton == 4) && var44) {
                        var46 = true;
                     }

                     boolean var45 = false;
                     if((MouseInput.mouseLastButton == 1 || !Client.middleMouseMovesCamera && MouseInput.mouseLastButton == 4) && MouseInput.mouseLastPressedX >= var12 && MouseInput.mouseLastPressedY >= var13 && MouseInput.mouseLastPressedX < var14 && MouseInput.mouseLastPressedY < var15) {
                        var45 = true;
                     }

                     if(var45) {
                        class89.method1874(var9, MouseInput.mouseLastPressedX - var10, MouseInput.mouseLastPressedY - var11);
                     }

                     if(var9.contentType == 1400) {
                        ScriptState.renderOverview.method5664(MouseInput.mouseLastX, MouseInput.mouseLastY, var44 & var46, var44 & var45);
                     }

                     if(Client.field980 != null && var9 != Client.field980 && var44) {
                        var22 = class60.getWidgetConfig(var9);
                        var47 = (var22 >> 20 & 1) != 0;
                        if(var47) {
                           Client.field858 = var9;
                        }
                     }

                     if(var9 == Client.field981) {
                        Client.field985 = true;
                        Client.field986 = var10;
                        Client.field987 = var11;
                     }

                     if(var9.field2813) {
                        ScriptEvent var56;
                        if(var44 && Client.mouseWheelRotation != 0 && var9.scrollListener != null) {
                           var56 = new ScriptEvent();
                           var56.boolean1 = true;
                           var56.widget = var9;
                           var56.field746 = Client.mouseWheelRotation;
                           var56.objs = var9.scrollListener;
                           Client.field1006.addFront(var56);
                        }

                        if(Client.field980 != null || class37.field479 != null || Client.isMenuOpen) {
                           var45 = false;
                           var46 = false;
                           var44 = false;
                        }

                        if(!var9.field2864 && var45) {
                           var9.field2864 = true;
                           if(var9.field2820 != null) {
                              var56 = new ScriptEvent();
                              var56.boolean1 = true;
                              var56.widget = var9;
                              var56.field748 = MouseInput.mouseLastPressedX - var10;
                              var56.field746 = MouseInput.mouseLastPressedY - var11;
                              var56.objs = var9.field2820;
                              Client.field1006.addFront(var56);
                           }
                        }

                        if(var9.field2864 && var46 && var9.field2812 != null) {
                           var56 = new ScriptEvent();
                           var56.boolean1 = true;
                           var56.widget = var9;
                           var56.field748 = MouseInput.mouseLastX - var10;
                           var56.field746 = MouseInput.mouseLastY - var11;
                           var56.objs = var9.field2812;
                           Client.field1006.addFront(var56);
                        }

                        if(var9.field2864 && !var46) {
                           var9.field2864 = false;
                           if(var9.field2760 != null) {
                              var56 = new ScriptEvent();
                              var56.boolean1 = true;
                              var56.widget = var9;
                              var56.field748 = MouseInput.mouseLastX - var10;
                              var56.field746 = MouseInput.mouseLastY - var11;
                              var56.objs = var9.field2760;
                              Client.field917.addFront(var56);
                           }
                        }

                        if(var46 && var9.field2823 != null) {
                           var56 = new ScriptEvent();
                           var56.boolean1 = true;
                           var56.widget = var9;
                           var56.field748 = MouseInput.mouseLastX - var10;
                           var56.field746 = MouseInput.mouseLastY - var11;
                           var56.objs = var9.field2823;
                           Client.field1006.addFront(var56);
                        }

                        if(!var9.field2863 && var44) {
                           var9.field2863 = true;
                           if(var9.mouseEnterListener != null) {
                              var56 = new ScriptEvent();
                              var56.boolean1 = true;
                              var56.widget = var9;
                              var56.field748 = MouseInput.mouseLastX - var10;
                              var56.field746 = MouseInput.mouseLastY - var11;
                              var56.objs = var9.mouseEnterListener;
                              Client.field1006.addFront(var56);
                           }
                        }

                        if(var9.field2863 && var44 && var9.mouseHoverListener != null) {
                           var56 = new ScriptEvent();
                           var56.boolean1 = true;
                           var56.widget = var9;
                           var56.field748 = MouseInput.mouseLastX - var10;
                           var56.field746 = MouseInput.mouseLastY - var11;
                           var56.objs = var9.mouseHoverListener;
                           Client.field1006.addFront(var56);
                        }

                        if(var9.field2863 && !var44) {
                           var9.field2863 = false;
                           if(var9.mouseExitListener != null) {
                              var56 = new ScriptEvent();
                              var56.boolean1 = true;
                              var56.widget = var9;
                              var56.field748 = MouseInput.mouseLastX - var10;
                              var56.field746 = MouseInput.mouseLastY - var11;
                              var56.objs = var9.mouseExitListener;
                              Client.field917.addFront(var56);
                           }
                        }

                        if(var9.renderListener != null) {
                           var56 = new ScriptEvent();
                           var56.widget = var9;
                           var56.objs = var9.renderListener;
                           Client.field1007.addFront(var56);
                        }

                        ScriptEvent var37;
                        if(var9.configListenerArgs != null && Client.field994 > var9.field2774) {
                           if(var9.configTriggers != null && Client.field994 - var9.field2774 <= 32) {
                              label1319:
                              for(var21 = var9.field2774; var21 < Client.field994; ++var21) {
                                 var22 = Client.field993[var21 & 31];

                                 for(var23 = 0; var23 < var9.configTriggers.length; ++var23) {
                                    if(var22 == var9.configTriggers[var23]) {
                                       var37 = new ScriptEvent();
                                       var37.widget = var9;
                                       var37.objs = var9.configListenerArgs;
                                       Client.field1006.addFront(var37);
                                       break label1319;
                                    }
                                 }
                              }
                           } else {
                              var56 = new ScriptEvent();
                              var56.widget = var9;
                              var56.objs = var9.configListenerArgs;
                              Client.field1006.addFront(var56);
                           }

                           var9.field2774 = Client.field994;
                        }

                        if(var9.tableListenerArgs != null && Client.field1073 > var9.field2867) {
                           if(var9.tableModTriggers != null && Client.field1073 - var9.field2867 <= 32) {
                              label1295:
                              for(var21 = var9.field2867; var21 < Client.field1073; ++var21) {
                                 var22 = Client.interfaceItemTriggers[var21 & 31];

                                 for(var23 = 0; var23 < var9.tableModTriggers.length; ++var23) {
                                    if(var22 == var9.tableModTriggers[var23]) {
                                       var37 = new ScriptEvent();
                                       var37.widget = var9;
                                       var37.objs = var9.tableListenerArgs;
                                       Client.field1006.addFront(var37);
                                       break label1295;
                                    }
                                 }
                              }
                           } else {
                              var56 = new ScriptEvent();
                              var56.widget = var9;
                              var56.objs = var9.tableListenerArgs;
                              Client.field1006.addFront(var56);
                           }

                           var9.field2867 = Client.field1073;
                        }

                        if(var9.skillListenerArgs != null && Client.field998 > var9.field2768) {
                           if(var9.skillTriggers != null && Client.field998 - var9.field2768 <= 32) {
                              label1271:
                              for(var21 = var9.field2768; var21 < Client.field998; ++var21) {
                                 var22 = Client.field1059[var21 & 31];

                                 for(var23 = 0; var23 < var9.skillTriggers.length; ++var23) {
                                    if(var22 == var9.skillTriggers[var23]) {
                                       var37 = new ScriptEvent();
                                       var37.widget = var9;
                                       var37.objs = var9.skillListenerArgs;
                                       Client.field1006.addFront(var37);
                                       break label1271;
                                    }
                                 }
                              }
                           } else {
                              var56 = new ScriptEvent();
                              var56.widget = var9;
                              var56.objs = var9.skillListenerArgs;
                              Client.field1006.addFront(var56);
                           }

                           var9.field2768 = Client.field998;
                        }

                        if(Client.chatCycle > var9.field2784 && var9.field2761 != null) {
                           var56 = new ScriptEvent();
                           var56.widget = var9;
                           var56.objs = var9.field2761;
                           Client.field1006.addFront(var56);
                        }

                        if(Client.field1000 > var9.field2784 && var9.field2842 != null) {
                           var56 = new ScriptEvent();
                           var56.widget = var9;
                           var56.objs = var9.field2842;
                           Client.field1006.addFront(var56);
                        }

                        if(Client.field949 > var9.field2784 && var9.field2843 != null) {
                           var56 = new ScriptEvent();
                           var56.widget = var9;
                           var56.objs = var9.field2843;
                           Client.field1006.addFront(var56);
                        }

                        if(Client.field1021 > var9.field2784 && var9.field2848 != null) {
                           var56 = new ScriptEvent();
                           var56.widget = var9;
                           var56.objs = var9.field2848;
                           Client.field1006.addFront(var56);
                        }

                        if(Client.field859 > var9.field2784 && var9.field2834 != null) {
                           var56 = new ScriptEvent();
                           var56.widget = var9;
                           var56.objs = var9.field2834;
                           Client.field1006.addFront(var56);
                        }

                        if(Client.field862 > var9.field2784 && var9.field2844 != null) {
                           var56 = new ScriptEvent();
                           var56.widget = var9;
                           var56.objs = var9.field2844;
                           Client.field1006.addFront(var56);
                        }

                        var9.field2784 = Client.cycleCntr;
                        if(var9.field2841 != null) {
                           for(var21 = 0; var21 < Client.field1028; ++var21) {
                              ScriptEvent var57 = new ScriptEvent();
                              var57.widget = var9;
                              var57.field745 = Client.field1030[var21];
                              var57.field753 = Client.field1029[var21];
                              var57.objs = var9.field2841;
                              Client.field1006.addFront(var57);
                           }
                        }
                     }
                  }

                  if(!var9.hasScript && Client.field980 == null && class37.field479 == null && !Client.isMenuOpen) {
                     if((var9.field2853 >= 0 || var9.field2765 != 0) && MouseInput.mouseLastX >= var12 && MouseInput.mouseLastY >= var13 && MouseInput.mouseLastX < var14 && MouseInput.mouseLastY < var15) {
                        if(var9.field2853 >= 0) {
                           FileRequest.field3287 = var0[var9.field2853];
                        } else {
                           FileRequest.field3287 = var9;
                        }
                     }

                     if(var9.type == 8 && MouseInput.mouseLastX >= var12 && MouseInput.mouseLastY >= var13 && MouseInput.mouseLastX < var14 && MouseInput.mouseLastY < var15) {
                        BaseVarType.field25 = var9;
                     }

                     if(var9.scrollHeight > var9.height) {
                        ScriptVarType.method31(var9, var10 + var9.width, var11, var9.height, var9.scrollHeight, MouseInput.mouseLastX, MouseInput.mouseLastY);
                     }
                  }
               }
            }
         }
      }

   }
}
