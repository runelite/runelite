import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("g")
public class class24 {
   @ObfuscatedName("w")
   public static final class24 field358;
   @ObfuscatedName("a")
   public static final class24 field359;
   @ObfuscatedName("t")
   final String field360;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -18608567
   )
   final int field362;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -1108717529
   )
   final int field363;
   @ObfuscatedName("i")
   public static final class24 field364;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -1454688603
   )
   final int field367;
   @ObfuscatedName("dd")
   @ObfuscatedGetter(
      longValue = -7267825207791254187L
   )
   static long field368;

   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;III)V",
      garbageValue = "4"
   )
   class24(String var1, int var2, int var3, int var4) {
      this.field360 = var1;
      this.field362 = var2;
      this.field367 = var3;
      this.field363 = var4;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(FI)Z",
      garbageValue = "-2135510352"
   )
   boolean method161(float var1) {
      return var1 >= (float)this.field363;
   }

   @ObfuscatedName("hv")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;IIIIZI)V",
      garbageValue = "1575584221"
   )
   static final void method162(String var0, String var1, int var2, int var3, int var4, int var5, boolean var6) {
      if(!Client.isMenuOpen && Client.menuOptionCount < 500) {
         Client.menuOptions[Client.menuOptionCount] = var0;
         Client.menuTargets[Client.menuOptionCount] = var1;
         Client.menuTypes[Client.menuOptionCount] = var2;
         Client.menuIdentifiers[Client.menuOptionCount] = var3;
         Client.menuActionParams0[Client.menuOptionCount] = var4;
         Client.menuActionParams1[Client.menuOptionCount] = var5;
         if(var6) {
            Client.field1074 = Client.menuOptionCount;
         }

         ++Client.menuOptionCount;
      }

   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(ILScript;ZB)I",
      garbageValue = "-72"
   )
   static int method163(int var0, Script var1, boolean var2) {
      int var3;
      if(var0 == 4200) {
         var3 = class83.intStack[--class46.intStackSize];
         class83.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = AbstractByteBuffer.getItemDefinition(var3).name;
         return 1;
      } else {
         int var4;
         ItemComposition var5;
         if(var0 == 4201) {
            class46.intStackSize -= 2;
            var3 = class83.intStack[class46.intStackSize];
            var4 = class83.intStack[class46.intStackSize + 1];
            var5 = AbstractByteBuffer.getItemDefinition(var3);
            if(var4 >= 1 && var4 <= 5 && var5.groundActions[var4 - 1] != null) {
               class83.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = var5.groundActions[var4 - 1];
            } else {
               class83.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = "";
            }

            return 1;
         } else if(var0 == 4202) {
            class46.intStackSize -= 2;
            var3 = class83.intStack[class46.intStackSize];
            var4 = class83.intStack[class46.intStackSize + 1];
            var5 = AbstractByteBuffer.getItemDefinition(var3);
            if(var4 >= 1 && var4 <= 5 && var5.inventoryActions[var4 - 1] != null) {
               class83.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = var5.inventoryActions[var4 - 1];
            } else {
               class83.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = "";
            }

            return 1;
         } else if(var0 == 4203) {
            var3 = class83.intStack[--class46.intStackSize];
            class83.intStack[++class46.intStackSize - 1] = AbstractByteBuffer.getItemDefinition(var3).price;
            return 1;
         } else if(var0 == 4204) {
            var3 = class83.intStack[--class46.intStackSize];
            class83.intStack[++class46.intStackSize - 1] = AbstractByteBuffer.getItemDefinition(var3).isStackable == 1?1:0;
            return 1;
         } else {
            ItemComposition var6;
            if(var0 == 4205) {
               var3 = class83.intStack[--class46.intStackSize];
               var6 = AbstractByteBuffer.getItemDefinition(var3);
               if(var6.notedTemplate == -1 && var6.note >= 0) {
                  class83.intStack[++class46.intStackSize - 1] = var6.note;
               } else {
                  class83.intStack[++class46.intStackSize - 1] = var3;
               }

               return 1;
            } else if(var0 == 4206) {
               var3 = class83.intStack[--class46.intStackSize];
               var6 = AbstractByteBuffer.getItemDefinition(var3);
               if(var6.notedTemplate >= 0 && var6.note >= 0) {
                  class83.intStack[++class46.intStackSize - 1] = var6.note;
               } else {
                  class83.intStack[++class46.intStackSize - 1] = var3;
               }

               return 1;
            } else if(var0 == 4207) {
               var3 = class83.intStack[--class46.intStackSize];
               class83.intStack[++class46.intStackSize - 1] = AbstractByteBuffer.getItemDefinition(var3).isMembers?1:0;
               return 1;
            } else if(var0 == 4208) {
               var3 = class83.intStack[--class46.intStackSize];
               var6 = AbstractByteBuffer.getItemDefinition(var3);
               if(var6.field3501 == -1 && var6.field3508 >= 0) {
                  class83.intStack[++class46.intStackSize - 1] = var6.field3508;
               } else {
                  class83.intStack[++class46.intStackSize - 1] = var3;
               }

               return 1;
            } else if(var0 == 4209) {
               var3 = class83.intStack[--class46.intStackSize];
               var6 = AbstractByteBuffer.getItemDefinition(var3);
               if(var6.field3501 >= 0 && var6.field3508 >= 0) {
                  class83.intStack[++class46.intStackSize - 1] = var6.field3508;
               } else {
                  class83.intStack[++class46.intStackSize - 1] = var3;
               }

               return 1;
            } else if(var0 == 4210) {
               String var7 = class83.scriptStringStack[--KeyFocusListener.scriptStringStackSize];
               var4 = class83.intStack[--class46.intStackSize];
               boolean var8 = var4 == 1;
               String var9 = var7.toLowerCase();
               short[] var10 = new short[16];
               int var11 = 0;
               int var12 = 0;

               while(true) {
                  short[] var14;
                  if(var12 >= CombatInfoListHolder.field1389) {
                     class15.field296 = var10;
                     WorldMapType2.field545 = 0;
                     class40.field569 = var11;
                     String[] var16 = new String[class40.field569];

                     for(int var17 = 0; var17 < class40.field569; ++var17) {
                        var16[var17] = AbstractByteBuffer.getItemDefinition(var10[var17]).name;
                     }

                     var14 = class15.field296;
                     Huffman.method3061(var16, var14, 0, var16.length - 1);
                     break;
                  }

                  ItemComposition var13 = AbstractByteBuffer.getItemDefinition(var12);
                  if((!var8 || var13.field3502) && var13.notedTemplate == -1 && var13.name.toLowerCase().indexOf(var9) != -1) {
                     if(var11 >= 250) {
                        class40.field569 = -1;
                        class15.field296 = null;
                        break;
                     }

                     if(var11 >= var10.length) {
                        var14 = new short[var10.length * 2];

                        for(int var15 = 0; var15 < var11; ++var15) {
                           var14[var15] = var10[var15];
                        }

                        var10 = var14;
                     }

                     var10[var11++] = (short)var12;
                  }

                  ++var12;
               }

               class83.intStack[++class46.intStackSize - 1] = class40.field569;
               return 1;
            } else if(var0 != 4211) {
               if(var0 == 4212) {
                  WorldMapType2.field545 = 0;
                  return 1;
               } else {
                  return 2;
               }
            } else {
               if(class15.field296 != null && WorldMapType2.field545 < class40.field569) {
                  class83.intStack[++class46.intStackSize - 1] = class15.field296[++WorldMapType2.field545 - 1] & '\uffff';
               } else {
                  class83.intStack[++class46.intStackSize - 1] = -1;
               }

               return 1;
            }
         }
      }
   }

   @ObfuscatedName("if")
   @ObfuscatedSignature(
      signature = "(LWidget;IIB)V",
      garbageValue = "90"
   )
   static final void method164(Widget var0, int var1, int var2) {
      if(var0.field2697 == 1) {
         class175.addMenuEntry(var0.tooltip, "", 24, 0, 0, var0.id);
      }

      String var3;
      if(var0.field2697 == 2 && !Client.spellSelected) {
         var3 = class162.method3041(var0);
         if(var3 != null) {
            class175.addMenuEntry(var3, class220.getColTags('\uff00') + var0.field2766, 25, 0, -1, var0.id);
         }
      }

      if(var0.field2697 == 3) {
         class175.addMenuEntry("Close", "", 26, 0, 0, var0.id);
      }

      if(var0.field2697 == 4) {
         class175.addMenuEntry(var0.tooltip, "", 28, 0, 0, var0.id);
      }

      if(var0.field2697 == 5) {
         class175.addMenuEntry(var0.tooltip, "", 29, 0, 0, var0.id);
      }

      if(var0.field2697 == 6 && Client.field1091 == null) {
         class175.addMenuEntry(var0.tooltip, "", 30, 0, -1, var0.id);
      }

      int var4;
      int var5;
      if(var0.type == 2) {
         var5 = 0;

         for(var4 = 0; var4 < var0.height; ++var4) {
            for(int var6 = 0; var6 < var0.width; ++var6) {
               int var7 = var6 * (var0.paddingX + 32);
               int var8 = (var0.paddingY + 32) * var4;
               if(var5 < 20) {
                  var7 += var0.xSprites[var5];
                  var8 += var0.field2723[var5];
               }

               if(var1 >= var7 && var2 >= var8 && var1 < var7 + 32 && var2 < var8 + 32) {
                  Client.field1042 = var5;
                  FaceNormal.field2155 = var0;
                  if(var0.itemIds[var5] > 0) {
                     ItemComposition var9 = AbstractByteBuffer.getItemDefinition(var0.itemIds[var5] - 1);
                     if(Client.itemSelectionState == 1 && class157.method2963(WorldMapType3.getWidgetConfig(var0))) {
                        if(var0.id != class40.field571 || var5 != FileSystem.selectedItemIndex) {
                           class175.addMenuEntry("Use", Client.selectedItemName + " -> " + class220.getColTags(16748608) + var9.name, 31, var9.id, var5, var0.id);
                        }
                     } else if(Client.spellSelected && class157.method2963(WorldMapType3.getWidgetConfig(var0))) {
                        if((WorldMapType3.spellTargetFlags & 16) == 16) {
                           class175.addMenuEntry(Client.field1078, Client.field1159 + " -> " + class220.getColTags(16748608) + var9.name, 32, var9.id, var5, var0.id);
                        }
                     } else {
                        String[] var10 = var9.inventoryActions;
                        if(Client.field1199) {
                           var10 = class251.method4456(var10);
                        }

                        int var11 = var9.method4624();
                        int var12;
                        boolean var13;
                        byte var14;
                        if(class157.method2963(WorldMapType3.getWidgetConfig(var0))) {
                           for(var12 = 4; var12 >= 3; --var12) {
                              var13 = var12 == var11;
                              if(var10 != null && var10[var12] != null) {
                                 if(var12 == 3) {
                                    var14 = 36;
                                 } else {
                                    var14 = 37;
                                 }

                                 method162(var10[var12], class220.getColTags(16748608) + var9.name, var14, var9.id, var5, var0.id, var13);
                              } else if(var12 == 4) {
                                 method162("Drop", class220.getColTags(16748608) + var9.name, 37, var9.id, var5, var0.id, var13);
                              }
                           }
                        }

                        if(class204.method3798(WorldMapType3.getWidgetConfig(var0))) {
                           class175.addMenuEntry("Use", class220.getColTags(16748608) + var9.name, 38, var9.id, var5, var0.id);
                        }

                        if(class157.method2963(WorldMapType3.getWidgetConfig(var0)) && var10 != null) {
                           for(var12 = 2; var12 >= 0; --var12) {
                              var13 = var12 == var11;
                              if(var10[var12] != null) {
                                 var14 = 0;
                                 if(var12 == 0) {
                                    var14 = 33;
                                 }

                                 if(var12 == 1) {
                                    var14 = 34;
                                 }

                                 if(var12 == 2) {
                                    var14 = 35;
                                 }

                                 method162(var10[var12], class220.getColTags(16748608) + var9.name, var14, var9.id, var5, var0.id, var13);
                              }
                           }
                        }

                        var10 = var0.configActions;
                        if(Client.field1199) {
                           var10 = class251.method4456(var10);
                        }

                        if(var10 != null) {
                           for(var12 = 4; var12 >= 0; --var12) {
                              if(var10[var12] != null) {
                                 byte var15 = 0;
                                 if(var12 == 0) {
                                    var15 = 39;
                                 }

                                 if(var12 == 1) {
                                    var15 = 40;
                                 }

                                 if(var12 == 2) {
                                    var15 = 41;
                                 }

                                 if(var12 == 3) {
                                    var15 = 42;
                                 }

                                 if(var12 == 4) {
                                    var15 = 43;
                                 }

                                 class175.addMenuEntry(var10[var12], class220.getColTags(16748608) + var9.name, var15, var9.id, var5, var0.id);
                              }
                           }
                        }

                        class175.addMenuEntry("Examine", class220.getColTags(16748608) + var9.name, 1005, var9.id, var5, var0.id);
                     }
                  }
               }

               ++var5;
            }
         }
      }

      if(var0.hasScript) {
         if(Client.spellSelected) {
            if(Actor.method1558(WorldMapType3.getWidgetConfig(var0)) && (WorldMapType3.spellTargetFlags & 32) == 32) {
               class175.addMenuEntry(Client.field1078, Client.field1159 + " -> " + var0.name, 58, 0, var0.index, var0.id);
            }
         } else {
            String var16;
            for(var5 = 9; var5 >= 5; --var5) {
               var16 = class20.method140(var0, var5);
               if(var16 != null) {
                  class175.addMenuEntry(var16, var0.name, 1007, var5 + 1, var0.index, var0.id);
               }
            }

            var3 = class162.method3041(var0);
            if(var3 != null) {
               class175.addMenuEntry(var3, var0.name, 25, 0, var0.index, var0.id);
            }

            for(var4 = 4; var4 >= 0; --var4) {
               var16 = class20.method140(var0, var4);
               if(var16 != null) {
                  class175.addMenuEntry(var16, var0.name, 57, var4 + 1, var0.index, var0.id);
               }
            }

            if(FrameMap.method2661(WorldMapType3.getWidgetConfig(var0))) {
               class175.addMenuEntry("Continue", "", 30, 0, var0.index, var0.id);
            }
         }
      }

   }

   static {
      field364 = new class24("SMALL", 0, 0, 4);
      field358 = new class24("MEDIUM", 2, 1, 2);
      field359 = new class24("LARGE", 1, 2, 0);
   }
}
