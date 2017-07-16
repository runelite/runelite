import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("aj")
public class class37 {
   @ObfuscatedName("pr")
   @ObfuscatedGetter(
      intValue = 626756585
   )
   static int field498;
   @ObfuscatedName("ev")
   @ObfuscatedGetter(
      intValue = 184428231
   )
   static int field494;

   @ObfuscatedName("hi")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;IIIII)V",
      garbageValue = "1768907650"
   )
   @Export("addMenuEntry")
   public static final void addMenuEntry(String var0, String var1, int var2, int var3, int var4, int var5) {
      IndexFile.method3019(var0, var1, var2, var3, var4, var5, false);
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(Lff;B)I",
      garbageValue = "1"
   )
   static int method490(PacketBuffer var0) {
      int var1 = var0.getBits(2);
      int var2;
      if(var1 == 0) {
         var2 = 0;
      } else if(var1 == 1) {
         var2 = var0.getBits(5);
      } else if(var1 == 2) {
         var2 = var0.getBits(8);
      } else {
         var2 = var0.getBits(11);
      }

      return var2;
   }

   @ObfuscatedName("it")
   @ObfuscatedSignature(
      signature = "(Lhy;IIB)V",
      garbageValue = "15"
   )
   static final void method500(Widget var0, int var1, int var2) {
      if(var0.field2656 == 1) {
         addMenuEntry(var0.tooltip, "", 24, 0, 0, var0.id);
      }

      String var3;
      if(var0.field2656 == 2 && !Client.spellSelected) {
         var3 = MouseInput.method1029(var0);
         if(var3 != null) {
            addMenuEntry(var3, class46.getColTags('\uff00') + var0.field2769, 25, 0, -1, var0.id);
         }
      }

      if(var0.field2656 == 3) {
         addMenuEntry("Close", "", 26, 0, 0, var0.id);
      }

      if(var0.field2656 == 4) {
         addMenuEntry(var0.tooltip, "", 28, 0, 0, var0.id);
      }

      if(var0.field2656 == 5) {
         addMenuEntry(var0.tooltip, "", 29, 0, 0, var0.id);
      }

      if(var0.field2656 == 6 && Client.field1070 == null) {
         addMenuEntry(var0.tooltip, "", 30, 0, -1, var0.id);
      }

      int var4;
      int var18;
      if(var0.type == 2) {
         var18 = 0;

         for(var4 = 0; var4 < var0.height; ++var4) {
            for(int var5 = 0; var5 < var0.width; ++var5) {
               int var6 = (var0.paddingX + 32) * var5;
               int var7 = (var0.paddingY + 32) * var4;
               if(var18 < 20) {
                  var6 += var0.xSprites[var18];
                  var7 += var0.field2722[var18];
               }

               if(var1 >= var6 && var2 >= var7 && var1 < var6 + 32 && var2 < var7 + 32) {
                  Client.field1022 = var18;
                  class66.field813 = var0;
                  if(var0.itemIds[var18] > 0) {
                     label341: {
                        ItemComposition var8 = class83.getItemDefinition(var0.itemIds[var18] - 1);
                        boolean var9;
                        int var10;
                        if(Client.itemSelectionState == 1) {
                           var10 = class46.getWidgetConfig(var0);
                           var9 = (var10 >> 30 & 1) != 0;
                           if(var9) {
                              if(var0.id != class3.field17 || var18 != class11.selectedItemIndex) {
                                 addMenuEntry("Use", Client.selectedItemName + " " + "->" + " " + class46.getColTags(16748608) + var8.name, 31, var8.id, var18, var0.id);
                              }
                              break label341;
                           }
                        }

                        if(Client.spellSelected) {
                           var10 = class46.getWidgetConfig(var0);
                           var9 = (var10 >> 30 & 1) != 0;
                           if(var9) {
                              if((class116.field1676 & 16) == 16) {
                                 addMenuEntry(Client.field1064, Client.field1019 + " " + "->" + " " + class46.getColTags(16748608) + var8.name, 32, var8.id, var18, var0.id);
                              }
                              break label341;
                           }
                        }

                        String[] var19 = var8.inventoryActions;
                        if(Client.field1026) {
                           var19 = class34.method481(var19);
                        }

                        var10 = var8.method4521();
                        int var12 = class46.getWidgetConfig(var0);
                        boolean var11 = (var12 >> 30 & 1) != 0;
                        if(var11) {
                           for(int var13 = 4; var13 >= 3; --var13) {
                              boolean var14 = var13 == var10;
                              if(var19 != null && var19[var13] != null) {
                                 byte var15;
                                 if(var13 == 3) {
                                    var15 = 36;
                                 } else {
                                    var15 = 37;
                                 }

                                 IndexFile.method3019(var19[var13], class46.getColTags(16748608) + var8.name, var15, var8.id, var18, var0.id, var14);
                              } else if(var13 == 4) {
                                 IndexFile.method3019("Drop", class46.getColTags(16748608) + var8.name, 37, var8.id, var18, var0.id, var14);
                              }
                           }
                        }

                        Object var10000 = null;
                        if(AbstractSoundSystem.method2040(class46.getWidgetConfig(var0))) {
                           addMenuEntry("Use", class46.getColTags(16748608) + var8.name, 38, var8.id, var18, var0.id);
                        }

                        int var23 = class46.getWidgetConfig(var0);
                        boolean var22 = (var23 >> 30 & 1) != 0;
                        int var24;
                        if(var22 && var19 != null) {
                           for(var24 = 2; var24 >= 0; --var24) {
                              boolean var16 = var24 == var10;
                              if(var19[var24] != null) {
                                 byte var17 = 0;
                                 if(var24 == 0) {
                                    var17 = 33;
                                 }

                                 if(var24 == 1) {
                                    var17 = 34;
                                 }

                                 if(var24 == 2) {
                                    var17 = 35;
                                 }

                                 IndexFile.method3019(var19[var24], class46.getColTags(16748608) + var8.name, var17, var8.id, var18, var0.id, var16);
                              }
                           }
                        }

                        var19 = var0.configActions;
                        if(Client.field1026) {
                           var19 = class34.method481(var19);
                        }

                        if(var19 != null) {
                           for(var24 = 4; var24 >= 0; --var24) {
                              if(var19[var24] != null) {
                                 byte var25 = 0;
                                 if(var24 == 0) {
                                    var25 = 39;
                                 }

                                 if(var24 == 1) {
                                    var25 = 40;
                                 }

                                 if(var24 == 2) {
                                    var25 = 41;
                                 }

                                 if(var24 == 3) {
                                    var25 = 42;
                                 }

                                 if(var24 == 4) {
                                    var25 = 43;
                                 }

                                 addMenuEntry(var19[var24], class46.getColTags(16748608) + var8.name, var25, var8.id, var18, var0.id);
                              }
                           }
                        }

                        addMenuEntry("Examine", class46.getColTags(16748608) + var8.name, 1005, var8.id, var18, var0.id);
                     }
                  }
               }

               ++var18;
            }
         }
      }

      if(var0.hasScript) {
         if(Client.spellSelected) {
            if(class214.method3964(class46.getWidgetConfig(var0)) && (class116.field1676 & 32) == 32) {
               addMenuEntry(Client.field1064, Client.field1019 + " " + "->" + " " + var0.name, 58, 0, var0.index, var0.id);
            }
         } else {
            for(var18 = 9; var18 >= 5; --var18) {
               String var20 = class60.method1033(var0, var18);
               if(var20 != null) {
                  addMenuEntry(var20, var0.name, 1007, var18 + 1, var0.index, var0.id);
               }
            }

            var3 = MouseInput.method1029(var0);
            if(var3 != null) {
               addMenuEntry(var3, var0.name, 25, 0, var0.index, var0.id);
            }

            for(var4 = 4; var4 >= 0; --var4) {
               String var21 = class60.method1033(var0, var4);
               if(var21 != null) {
                  addMenuEntry(var21, var0.name, 57, var4 + 1, var0.index, var0.id);
               }
            }

            if(class12.method71(class46.getWidgetConfig(var0))) {
               addMenuEntry("Continue", "", 30, 0, var0.index, var0.id);
            }
         }
      }

   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(CII)I",
      garbageValue = "2030541206"
   )
   static int method502(char var0, int var1) {
      int var2 = var0 << 4;
      if(Character.isUpperCase(var0) || Character.isTitleCase(var0)) {
         var0 = Character.toLowerCase(var0);
         var2 = (var0 << 4) + 1;
      }

      return var2;
   }
}
