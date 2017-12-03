import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ea")
@Implements("FaceNormal")
public class FaceNormal {
   @ObfuscatedName("f")
   public static int[] field2025;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -819810915
   )
   @Export("x")
   int x;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 572835747
   )
   @Export("y")
   int y;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 1215733267
   )
   @Export("z")
   int z;

   @ObfuscatedName("hj")
   @ObfuscatedSignature(
      signature = "(Lhz;III)V",
      garbageValue = "897508312"
   )
   static final void method2883(Widget var0, int var1, int var2) {
      if(var0.field2754 == 1) {
         class37.addMenuEntry(var0.tooltip, "", 24, 0, 0, var0.id);
      }

      String var3;
      int var4;
      int var5;
      if(var0.field2754 == 2 && !Client.spellSelected) {
         var5 = class36.getWidgetConfig(var0);
         var4 = var5 >> 11 & 63;
         if(var4 == 0) {
            var3 = null;
         } else if(var0.selectedAction != null && var0.selectedAction.trim().length() != 0) {
            var3 = var0.selectedAction;
         } else {
            var3 = null;
         }

         if(var3 != null) {
            class37.addMenuEntry(var3, Buffer.getColTags(65280) + var0.spellName, 25, 0, -1, var0.id);
         }
      }

      if(var0.field2754 == 3) {
         class37.addMenuEntry("Close", "", 26, 0, 0, var0.id);
      }

      if(var0.field2754 == 4) {
         class37.addMenuEntry(var0.tooltip, "", 28, 0, 0, var0.id);
      }

      if(var0.field2754 == 5) {
         class37.addMenuEntry(var0.tooltip, "", 29, 0, 0, var0.id);
      }

      if(var0.field2754 == 6 && Client.field958 == null) {
         class37.addMenuEntry(var0.tooltip, "", 30, 0, -1, var0.id);
      }

      int var6;
      int var20;
      if(var0.type == 2) {
         var20 = 0;

         for(var4 = 0; var4 < var0.height; ++var4) {
            for(var5 = 0; var5 < var0.width; ++var5) {
               var6 = (var0.paddingX + 32) * var5;
               int var7 = (var0.paddingY + 32) * var4;
               if(var20 < 20) {
                  var6 += var0.xSprites[var20];
                  var7 += var0.field2828[var20];
               }

               if(var1 >= var6 && var2 >= var7 && var1 < var6 + 32 && var2 < var7 + 32) {
                  Client.field935 = var20;
                  class47.field566 = var0;
                  if(var0.itemIds[var20] > 0) {
                     label388: {
                        ItemComposition var8 = KitDefinition.getItemDefinition(var0.itemIds[var20] - 1);
                        boolean var9;
                        int var10;
                        if(Client.itemSelectionState == 1) {
                           var10 = class36.getWidgetConfig(var0);
                           var9 = (var10 >> 30 & 1) != 0;
                           if(var9) {
                              if(var0.id != class18.field304 || var20 != class36.selectedItemIndex) {
                                 class37.addMenuEntry("Use", Client.lastSelectedItemName + " " + "->" + " " + Buffer.getColTags(16748608) + var8.name, 31, var8.id, var20, var0.id);
                              }
                              break label388;
                           }
                        }

                        if(Client.spellSelected) {
                           var10 = class36.getWidgetConfig(var0);
                           var9 = (var10 >> 30 & 1) != 0;
                           if(var9) {
                              if((class86.field1278 & 16) == 16) {
                                 class37.addMenuEntry(Client.field986, Client.field910 + " " + "->" + " " + Buffer.getColTags(16748608) + var8.name, 32, var8.id, var20, var0.id);
                              }
                              break label388;
                           }
                        }

                        String[] var21 = var8.inventoryActions;
                        if(Client.numberMenuOptions) {
                           var21 = GameEngine.prependIndices(var21);
                        }

                        var10 = -1;
                        if(Client.field976 && KeyFocusListener.field593[81]) {
                           var10 = var8.method4719();
                        }

                        int var12 = class36.getWidgetConfig(var0);
                        boolean var11 = (var12 >> 30 & 1) != 0;
                        if(var11) {
                           for(int var13 = 4; var13 >= 3; --var13) {
                              if(var10 != var13) {
                                 ScriptState.method1023(var0, var8, var20, var13, false);
                              }
                           }
                        }

                        int var14 = class36.getWidgetConfig(var0);
                        boolean var24 = (var14 >> 31 & 1) != 0;
                        if(var24) {
                           class37.addMenuEntry("Use", Buffer.getColTags(16748608) + var8.name, 38, var8.id, var20, var0.id);
                        }

                        int var16 = class36.getWidgetConfig(var0);
                        boolean var15 = (var16 >> 30 & 1) != 0;
                        int var17;
                        if(var15) {
                           for(var17 = 2; var17 >= 0; --var17) {
                              if(var10 != var17) {
                                 ScriptState.method1023(var0, var8, var20, var17, false);
                              }
                           }

                           if(var10 >= 0) {
                              ScriptState.method1023(var0, var8, var20, var10, true);
                           }
                        }

                        var21 = var0.configActions;
                        if(Client.numberMenuOptions) {
                           var21 = GameEngine.prependIndices(var21);
                        }

                        if(var21 != null) {
                           for(var17 = 4; var17 >= 0; --var17) {
                              if(var21[var17] != null) {
                                 byte var18 = 0;
                                 if(var17 == 0) {
                                    var18 = 39;
                                 }

                                 if(var17 == 1) {
                                    var18 = 40;
                                 }

                                 if(var17 == 2) {
                                    var18 = 41;
                                 }

                                 if(var17 == 3) {
                                    var18 = 42;
                                 }

                                 if(var17 == 4) {
                                    var18 = 43;
                                 }

                                 class37.addMenuEntry(var21[var17], Buffer.getColTags(16748608) + var8.name, var18, var8.id, var20, var0.id);
                              }
                           }
                        }

                        class37.addMenuEntry("Examine", Buffer.getColTags(16748608) + var8.name, 1005, var8.id, var20, var0.id);
                     }
                  }
               }

               ++var20;
            }
         }
      }

      if(var0.hasScript) {
         if(Client.spellSelected) {
            var4 = class36.getWidgetConfig(var0);
            boolean var25 = (var4 >> 21 & 1) != 0;
            if(var25 && (class86.field1278 & 32) == 32) {
               class37.addMenuEntry(Client.field986, Client.field910 + " " + "->" + " " + var0.name, 58, 0, var0.index, var0.id);
            }
         } else {
            for(var20 = 9; var20 >= 5; --var20) {
               String var19 = class48.method717(var0, var20);
               if(var19 != null) {
                  class37.addMenuEntry(var19, var0.name, 1007, var20 + 1, var0.index, var0.id);
               }
            }

            var5 = class36.getWidgetConfig(var0);
            var4 = var5 >> 11 & 63;
            if(var4 == 0) {
               var3 = null;
            } else if(var0.selectedAction != null && var0.selectedAction.trim().length() != 0) {
               var3 = var0.selectedAction;
            } else {
               var3 = null;
            }

            if(var3 != null) {
               class37.addMenuEntry(var3, var0.name, 25, 0, var0.index, var0.id);
            }

            for(var5 = 4; var5 >= 0; --var5) {
               String var22 = class48.method717(var0, var5);
               if(var22 != null) {
                  class37.addMenuEntry(var22, var0.name, 57, var5 + 1, var0.index, var0.id);
               }
            }

            var6 = class36.getWidgetConfig(var0);
            boolean var23 = (var6 & 1) != 0;
            if(var23) {
               class37.addMenuEntry("Continue", "", 30, 0, var0.index, var0.id);
            }
         }
      }

   }
}
