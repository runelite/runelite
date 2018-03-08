import java.util.HashMap;
import java.util.Map;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cg")
public class class95 {
   @ObfuscatedName("t")
   @Export("chatLineMap")
   static final Map chatLineMap;
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Lhq;"
   )
   @Export("messages")
   static final IterableHashTable messages;
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Lhv;"
   )
   static final IterableDualNodeQueue field1421;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -641425821
   )
   static int field1422;

   static {
      chatLineMap = new HashMap();
      messages = new IterableHashTable(1024);
      field1421 = new IterableDualNodeQueue();
      field1422 = 0;
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "-1790279967"
   )
   public static boolean method2041(int var0) {
      return (var0 >> 30 & 1) != 0;
   }

   @ObfuscatedName("ip")
   @ObfuscatedSignature(
      signature = "(Lig;III)V",
      garbageValue = "-601506837"
   )
   static final void method2027(Widget var0, int var1, int var2) {
      if(var0.field2853 == 1) {
         class169.addMenuEntry(var0.tooltip, "", 24, 0, 0, var0.id);
      }

      String var3;
      if(var0.field2853 == 2 && !Client.spellSelected) {
         var3 = class21.method172(var0);
         if(var3 != null) {
            class169.addMenuEntry(var3, class37.getColTags(65280) + var0.spellName, 25, 0, -1, var0.id);
         }
      }

      if(var0.field2853 == 3) {
         class169.addMenuEntry("Close", "", 26, 0, 0, var0.id);
      }

      if(var0.field2853 == 4) {
         class169.addMenuEntry(var0.tooltip, "", 28, 0, 0, var0.id);
      }

      if(var0.field2853 == 5) {
         class169.addMenuEntry(var0.tooltip, "", 29, 0, 0, var0.id);
      }

      if(var0.field2853 == 6 && Client.field1012 == null) {
         class169.addMenuEntry(var0.tooltip, "", 30, 0, -1, var0.id);
      }

      int var4;
      int var5;
      int var13;
      if(var0.type == 2) {
         var13 = 0;

         for(var4 = 0; var4 < var0.height; ++var4) {
            for(var5 = 0; var5 < var0.width; ++var5) {
               int var6 = (var0.paddingX + 32) * var5;
               int var7 = (var0.paddingY + 32) * var4;
               if(var13 < 20) {
                  var6 += var0.xSprites[var13];
                  var7 += var0.field2886[var13];
               }

               if(var1 >= var6 && var2 >= var7 && var1 < var6 + 32 && var2 < var7 + 32) {
                  Client.field1090 = var13;
                  WorldComparator.field261 = var0;
                  if(var0.itemIds[var13] > 0) {
                     ItemComposition var8 = class81.getItemDefinition(var0.itemIds[var13] - 1);
                     if(Client.itemSelectionState == 1 && method2041(GrandExchangeEvent.getWidgetConfig(var0))) {
                        if(var0.id != SoundTaskDataProvider.field619 || var13 != class271.selectedItemIndex) {
                           class169.addMenuEntry("Use", Client.lastSelectedItemName + " " + "->" + " " + class37.getColTags(16748608) + var8.name, 31, var8.id, var13, var0.id);
                        }
                     } else if(Client.spellSelected && method2041(GrandExchangeEvent.getWidgetConfig(var0))) {
                        if((class150.field2100 & 16) == 16) {
                           class169.addMenuEntry(Client.field1006, Client.field1074 + " " + "->" + " " + class37.getColTags(16748608) + var8.name, 32, var8.id, var13, var0.id);
                        }
                     } else {
                        String[] var9 = var8.inventoryActions;
                        int var10 = -1;
                        if(Client.field994) {
                           boolean var11 = Client.field877 || KeyFocusListener.keyPressed[81];
                           if(var11) {
                              var10 = var8.method5080();
                           }
                        }

                        int var18;
                        if(method2041(GrandExchangeEvent.getWidgetConfig(var0))) {
                           for(var18 = 4; var18 >= 3; --var18) {
                              if(var10 != var18) {
                                 MessageNode.method1180(var0, var8, var13, var18, false);
                              }
                           }
                        }

                        if(Renderable.method3047(GrandExchangeEvent.getWidgetConfig(var0))) {
                           class169.addMenuEntry("Use", class37.getColTags(16748608) + var8.name, 38, var8.id, var13, var0.id);
                        }

                        if(method2041(GrandExchangeEvent.getWidgetConfig(var0))) {
                           for(var18 = 2; var18 >= 0; --var18) {
                              if(var18 != var10) {
                                 MessageNode.method1180(var0, var8, var13, var18, false);
                              }
                           }

                           if(var10 >= 0) {
                              MessageNode.method1180(var0, var8, var13, var10, true);
                           }
                        }

                        var9 = var0.configActions;
                        if(var9 != null) {
                           for(var18 = 4; var18 >= 0; --var18) {
                              if(var9[var18] != null) {
                                 byte var12 = 0;
                                 if(var18 == 0) {
                                    var12 = 39;
                                 }

                                 if(var18 == 1) {
                                    var12 = 40;
                                 }

                                 if(var18 == 2) {
                                    var12 = 41;
                                 }

                                 if(var18 == 3) {
                                    var12 = 42;
                                 }

                                 if(var18 == 4) {
                                    var12 = 43;
                                 }

                                 class169.addMenuEntry(var9[var18], class37.getColTags(16748608) + var8.name, var12, var8.id, var13, var0.id);
                              }
                           }
                        }

                        class169.addMenuEntry("Examine", class37.getColTags(16748608) + var8.name, 1005, var8.id, var13, var0.id);
                     }
                  }
               }

               ++var13;
            }
         }
      }

      if(var0.hasScript) {
         if(Client.spellSelected) {
            var4 = GrandExchangeEvent.getWidgetConfig(var0);
            boolean var19 = (var4 >> 21 & 1) != 0;
            if(var19 && (class150.field2100 & 32) == 32) {
               class169.addMenuEntry(Client.field1006, Client.field1074 + " " + "->" + " " + var0.name, 58, 0, var0.index, var0.id);
            }
         } else {
            for(var13 = 9; var13 >= 5; --var13) {
               String var14;
               if(!class81.method1814(GrandExchangeEvent.getWidgetConfig(var0), var13) && var0.field2917 == null) {
                  var14 = null;
               } else if(var0.actions != null && var0.actions.length > var13 && var0.actions[var13] != null && var0.actions[var13].trim().length() != 0) {
                  var14 = var0.actions[var13];
               } else {
                  var14 = null;
               }

               if(var14 != null) {
                  class169.addMenuEntry(var14, var0.name, 1007, var13 + 1, var0.index, var0.id);
               }
            }

            var3 = class21.method172(var0);
            if(var3 != null) {
               class169.addMenuEntry(var3, var0.name, 25, 0, var0.index, var0.id);
            }

            for(var4 = 4; var4 >= 0; --var4) {
               String var15;
               if(!class81.method1814(GrandExchangeEvent.getWidgetConfig(var0), var4) && var0.field2917 == null) {
                  var15 = null;
               } else if(var0.actions != null && var0.actions.length > var4 && var0.actions[var4] != null && var0.actions[var4].trim().length() != 0) {
                  var15 = var0.actions[var4];
               } else {
                  var15 = null;
               }

               if(var15 != null) {
                  class169.addMenuEntry(var15, var0.name, 57, var4 + 1, var0.index, var0.id);
               }
            }

            var5 = GrandExchangeEvent.getWidgetConfig(var0);
            boolean var17 = (var5 & 1) != 0;
            if(var17) {
               class169.addMenuEntry("Continue", "", 30, 0, var0.index, var0.id);
            }
         }
      }

   }
}
