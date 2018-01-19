import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hs")
public class class228 {
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Lil;"
   )
   @Export("EnumDefinition_indexCache")
   static IndexDataBase EnumDefinition_indexCache;

   @ObfuscatedName("jn")
   @ObfuscatedSignature(
      signature = "(Lhq;IIB)V",
      garbageValue = "60"
   )
   static final void method4255(Widget var0, int var1, int var2) {
      if(var0.field2860 == 1) {
         DecorativeObject.addMenuEntry(var0.tooltip, "", 24, 0, 0, var0.id);
      }

      String var3;
      int var4;
      int var5;
      if(var0.field2860 == 2 && !Client.spellSelected) {
         var5 = GraphicsObject.getWidgetConfig(var0);
         var4 = var5 >> 11 & 63;
         if(var4 == 0) {
            var3 = null;
         } else if(var0.selectedAction != null && var0.selectedAction.trim().length() != 0) {
            var3 = var0.selectedAction;
         } else {
            var3 = null;
         }

         if(var3 != null) {
            DecorativeObject.addMenuEntry(var3, class54.getColTags(65280) + var0.spellName, 25, 0, -1, var0.id);
         }
      }

      if(var0.field2860 == 3) {
         DecorativeObject.addMenuEntry("Close", "", 26, 0, 0, var0.id);
      }

      if(var0.field2860 == 4) {
         DecorativeObject.addMenuEntry(var0.tooltip, "", 28, 0, 0, var0.id);
      }

      if(var0.field2860 == 5) {
         DecorativeObject.addMenuEntry(var0.tooltip, "", 29, 0, 0, var0.id);
      }

      if(var0.field2860 == 6 && Client.field1019 == null) {
         DecorativeObject.addMenuEntry(var0.tooltip, "", 30, 0, -1, var0.id);
      }

      int var6;
      int var14;
      if(var0.type == 2) {
         var14 = 0;

         for(var4 = 0; var4 < var0.height; ++var4) {
            for(var5 = 0; var5 < var0.width; ++var5) {
               var6 = (var0.paddingX + 32) * var5;
               int var7 = (var0.paddingY + 32) * var4;
               if(var14 < 20) {
                  var6 += var0.xSprites[var14];
                  var7 += var0.field2874[var14];
               }

               if(var1 >= var6 && var2 >= var7 && var1 < var6 + 32 && var2 < var7 + 32) {
                  Client.field1020 = var14;
                  class185.field2540 = var0;
                  if(var0.itemIds[var14] > 0) {
                     ItemComposition var8 = class115.getItemDefinition(var0.itemIds[var14] - 1);
                     if(Client.itemSelectionState == 1 && MessageNode.method1122(GraphicsObject.getWidgetConfig(var0))) {
                        if(var0.id != class33.field448 || var14 != class22.selectedItemIndex) {
                           DecorativeObject.addMenuEntry("Use", Client.lastSelectedItemName + " " + "->" + " " + class54.getColTags(16748608) + var8.name, 31, var8.id, var14, var0.id);
                        }
                     } else if(Client.spellSelected && MessageNode.method1122(GraphicsObject.getWidgetConfig(var0))) {
                        if((MouseRecorder.field817 & 16) == 16) {
                           DecorativeObject.addMenuEntry(Client.field1013, Client.field1014 + " " + "->" + " " + class54.getColTags(16748608) + var8.name, 32, var8.id, var14, var0.id);
                        }
                     } else {
                        String[] var9 = var8.inventoryActions;
                        if(Client.numberMenuOptions) {
                           var9 = class37.prependIndices(var9);
                        }

                        int var10 = -1;
                        if(Client.field1003 && KeyFocusListener.keyPressed[81]) {
                           var10 = var8.method4774();
                        }

                        int var11;
                        if(MessageNode.method1122(GraphicsObject.getWidgetConfig(var0))) {
                           for(var11 = 4; var11 >= 3; --var11) {
                              if(var11 != var10) {
                                 NPC.method1725(var0, var8, var14, var11, false);
                              }
                           }
                        }

                        if(class167.method3234(GraphicsObject.getWidgetConfig(var0))) {
                           DecorativeObject.addMenuEntry("Use", class54.getColTags(16748608) + var8.name, 38, var8.id, var14, var0.id);
                        }

                        if(MessageNode.method1122(GraphicsObject.getWidgetConfig(var0))) {
                           for(var11 = 2; var11 >= 0; --var11) {
                              if(var11 != var10) {
                                 NPC.method1725(var0, var8, var14, var11, false);
                              }
                           }

                           if(var10 >= 0) {
                              NPC.method1725(var0, var8, var14, var10, true);
                           }
                        }

                        var9 = var0.configActions;
                        if(Client.numberMenuOptions) {
                           var9 = class37.prependIndices(var9);
                        }

                        if(var9 != null) {
                           for(var11 = 4; var11 >= 0; --var11) {
                              if(var9[var11] != null) {
                                 byte var12 = 0;
                                 if(var11 == 0) {
                                    var12 = 39;
                                 }

                                 if(var11 == 1) {
                                    var12 = 40;
                                 }

                                 if(var11 == 2) {
                                    var12 = 41;
                                 }

                                 if(var11 == 3) {
                                    var12 = 42;
                                 }

                                 if(var11 == 4) {
                                    var12 = 43;
                                 }

                                 DecorativeObject.addMenuEntry(var9[var11], class54.getColTags(16748608) + var8.name, var12, var8.id, var14, var0.id);
                              }
                           }
                        }

                        DecorativeObject.addMenuEntry("Examine", class54.getColTags(16748608) + var8.name, 1005, var8.id, var14, var0.id);
                     }
                  }
               }

               ++var14;
            }
         }
      }

      if(var0.hasScript) {
         if(Client.spellSelected) {
            if(GroundObject.method2560(GraphicsObject.getWidgetConfig(var0)) && (MouseRecorder.field817 & 32) == 32) {
               DecorativeObject.addMenuEntry(Client.field1013, Client.field1014 + " " + "->" + " " + var0.name, 58, 0, var0.index, var0.id);
            }
         } else {
            for(var14 = 9; var14 >= 5; --var14) {
               String var13;
               if(!ServerPacket.method3243(GraphicsObject.getWidgetConfig(var0), var14) && var0.field2862 == null) {
                  var13 = null;
               } else if(var0.actions != null && var0.actions.length > var14 && var0.actions[var14] != null && var0.actions[var14].trim().length() != 0) {
                  var13 = var0.actions[var14];
               } else {
                  var13 = null;
               }

               if(var13 != null) {
                  DecorativeObject.addMenuEntry(var13, var0.name, 1007, var14 + 1, var0.index, var0.id);
               }
            }

            var5 = GraphicsObject.getWidgetConfig(var0);
            var4 = var5 >> 11 & 63;
            if(var4 == 0) {
               var3 = null;
            } else if(var0.selectedAction != null && var0.selectedAction.trim().length() != 0) {
               var3 = var0.selectedAction;
            } else {
               var3 = null;
            }

            if(var3 != null) {
               DecorativeObject.addMenuEntry(var3, var0.name, 25, 0, var0.index, var0.id);
            }

            for(var5 = 4; var5 >= 0; --var5) {
               String var16;
               if(!ServerPacket.method3243(GraphicsObject.getWidgetConfig(var0), var5) && var0.field2862 == null) {
                  var16 = null;
               } else if(var0.actions != null && var0.actions.length > var5 && var0.actions[var5] != null && var0.actions[var5].trim().length() != 0) {
                  var16 = var0.actions[var5];
               } else {
                  var16 = null;
               }

               if(var16 != null) {
                  DecorativeObject.addMenuEntry(var16, var0.name, 57, var5 + 1, var0.index, var0.id);
               }
            }

            var6 = GraphicsObject.getWidgetConfig(var0);
            boolean var18 = (var6 & 1) != 0;
            if(var18) {
               DecorativeObject.addMenuEntry("Continue", "", 30, 0, var0.index, var0.id);
            }
         }
      }

   }
}
