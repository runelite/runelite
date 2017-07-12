import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ay")
public class class33 {
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 1714896217
   )
   int field475;
   @ObfuscatedName("i")
   String field476;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -390685283
   )
   int field477;
   @ObfuscatedName("t")
   class24 field478;
   @ObfuscatedName("bg")
   @ObfuscatedGetter(
      intValue = 1268275657
   )
   static int field480;
   @ObfuscatedName("df")
   @ObfuscatedGetter(
      intValue = -1341501263
   )
   static int field481;

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(ILScript;ZI)I",
      garbageValue = "-1188208209"
   )
   static int method345(int var0, Script var1, boolean var2) {
      int var3;
      int var4;
      Widget var6;
      if(var0 == 100) {
         class46.intStackSize -= 3;
         var3 = class83.intStack[class46.intStackSize];
         var4 = class83.intStack[class46.intStackSize + 1];
         int var9 = class83.intStack[class46.intStackSize + 2];
         if(var4 == 0) {
            throw new RuntimeException();
         } else {
            var6 = PacketBuffer.method3403(var3);
            if(var6.children == null) {
               var6.children = new Widget[var9 + 1];
            }

            if(var6.children.length <= var9) {
               Widget[] var7 = new Widget[var9 + 1];

               for(int var8 = 0; var8 < var6.children.length; ++var8) {
                  var7[var8] = var6.children[var8];
               }

               var6.children = var7;
            }

            if(var9 > 0 && var6.children[var9 - 1] == null) {
               throw new RuntimeException("" + (var9 - 1));
            } else {
               Widget var10 = new Widget();
               var10.type = var4;
               var10.parentId = var10.id = var6.id;
               var10.index = var9;
               var10.hasScript = true;
               var6.children[var9] = var10;
               if(var2) {
                  class83.field1364 = var10;
               } else {
                  class60.field766 = var10;
               }

               class88.method1714(var6);
               return 1;
            }
         }
      } else {
         Widget var5;
         if(var0 == 101) {
            var5 = var2?class83.field1364:class60.field766;
            var6 = PacketBuffer.method3403(var5.id);
            var6.children[var5.index] = null;
            class88.method1714(var6);
            return 1;
         } else if(var0 == 102) {
            var5 = PacketBuffer.method3403(class83.intStack[--class46.intStackSize]);
            var5.children = null;
            class88.method1714(var5);
            return 1;
         } else if(var0 != 200) {
            if(var0 == 201) {
               var5 = PacketBuffer.method3403(class83.intStack[--class46.intStackSize]);
               if(var5 != null) {
                  class83.intStack[++class46.intStackSize - 1] = 1;
                  if(var2) {
                     class83.field1364 = var5;
                  } else {
                     class60.field766 = var5;
                  }
               } else {
                  class83.intStack[++class46.intStackSize - 1] = 0;
               }

               return 1;
            } else {
               return 2;
            }
         } else {
            class46.intStackSize -= 2;
            var3 = class83.intStack[class46.intStackSize];
            var4 = class83.intStack[class46.intStackSize + 1];
            var6 = class202.method3650(var3, var4);
            if(var6 != null && var4 != -1) {
               class83.intStack[++class46.intStackSize - 1] = 1;
               if(var2) {
                  class83.field1364 = var6;
               } else {
                  class60.field766 = var6;
               }
            } else {
               class83.intStack[++class46.intStackSize - 1] = 0;
            }

            return 1;
         }
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "913463073"
   )
   public static void method346() {
      KeyFocusListener var0 = KeyFocusListener.keyboard;
      KeyFocusListener var1 = KeyFocusListener.keyboard;
      synchronized(KeyFocusListener.keyboard) {
         ++KeyFocusListener.keyboardIdleTicks;
         KeyFocusListener.field672 = KeyFocusListener.field674;
         KeyFocusListener.field671 = 0;
         int var2;
         if(KeyFocusListener.field667 < 0) {
            for(var2 = 0; var2 < 112; ++var2) {
               KeyFocusListener.field659[var2] = false;
            }

            KeyFocusListener.field667 = KeyFocusListener.field663;
         } else {
            while(KeyFocusListener.field663 != KeyFocusListener.field667) {
               var2 = KeyFocusListener.field665[KeyFocusListener.field663];
               KeyFocusListener.field663 = KeyFocusListener.field663 + 1 & 127;
               if(var2 < 0) {
                  KeyFocusListener.field659[~var2] = false;
               } else {
                  if(!KeyFocusListener.field659[var2] && KeyFocusListener.field671 < KeyFocusListener.field670.length - 1) {
                     KeyFocusListener.field670[++KeyFocusListener.field671 - 1] = var2;
                  }

                  KeyFocusListener.field659[var2] = true;
               }
            }
         }

         if(KeyFocusListener.field671 > 0) {
            KeyFocusListener.keyboardIdleTicks = 0;
         }

         KeyFocusListener.field674 = KeyFocusListener.field673;
      }
   }

   class33(String var1, int var2, int var3, class24 var4) {
      this.field476 = var1;
      this.field475 = var2;
      this.field477 = var3;
      this.field478 = var4;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "([BIIIIIII[LCollisionData;B)V",
      garbageValue = "-24"
   )
   static final void method347(byte[] var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, CollisionData[] var8) {
      int var9;
      for(int var10 = 0; var10 < 8; ++var10) {
         for(var9 = 0; var9 < 8; ++var9) {
            if(var2 + var10 > 0 && var2 + var10 < 103 && var3 + var9 > 0 && var3 + var9 < 103) {
               var8[var1].flags[var2 + var10][var3 + var9] &= -16777217;
            }
         }
      }

      Buffer var13 = new Buffer(var0);

      for(var9 = 0; var9 < 4; ++var9) {
         for(int var11 = 0; var11 < 64; ++var11) {
            for(int var12 = 0; var12 < 64; ++var12) {
               if(var9 == var4 && var11 >= var5 && var11 < var5 + 8 && var12 >= var6 && var12 < var6 + 8) {
                  GraphicsObject.loadTerrain(var13, var1, var2 + World.method1568(var11 & 7, var12 & 7, var7), var3 + Varbit.method4428(var11 & 7, var12 & 7, var7), 0, 0, var7);
               } else {
                  GraphicsObject.loadTerrain(var13, 0, -1, -1, 0, 0, 0);
               }
            }
         }
      }

   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(LIndexDataBase;LIndexDataBase;LIndexDataBase;Lclass204;I)Z",
      garbageValue = "1023985339"
   )
   public static boolean method348(IndexDataBase var0, IndexDataBase var1, IndexDataBase var2, class204 var3) {
      class203.field2506 = var0;
      class203.field2514 = var1;
      class203.field2507 = var2;
      class203.field2509 = var3;
      return true;
   }

   @ObfuscatedName("hp")
   @ObfuscatedSignature(
      signature = "(LNPCComposition;IIII)V",
      garbageValue = "217027169"
   )
   static final void method349(NPCComposition var0, int var1, int var2, int var3) {
      if(Client.menuOptionCount < 400) {
         if(var0.configs != null) {
            var0 = var0.transform();
         }

         if(var0 != null && var0.field3588 && (!var0.field3590 || Client.field1065 == var1)) {
            String var4 = var0.name;
            int var5;
            int var6;
            int var7;
            if(var0.combatLevel != 0) {
               var5 = var0.combatLevel;
               var6 = XItemContainer.localPlayer.combatLevel;
               var7 = var6 - var5;
               String var8;
               if(var7 < -9) {
                  var8 = class220.getColTags(16711680);
               } else if(var7 < -6) {
                  var8 = class220.getColTags(16723968);
               } else if(var7 < -3) {
                  var8 = class220.getColTags(16740352);
               } else if(var7 < 0) {
                  var8 = class220.getColTags(16756736);
               } else if(var7 > 9) {
                  var8 = class220.getColTags('\uff00');
               } else if(var7 > 6) {
                  var8 = class220.getColTags(4259584);
               } else if(var7 > 3) {
                  var8 = class220.getColTags(8453888);
               } else if(var7 > 0) {
                  var8 = class220.getColTags(12648192);
               } else {
                  var8 = class220.getColTags(16776960);
               }

               var4 = var4 + var8 + "  (level-" + var0.combatLevel + ")";
            }

            if(var0.field3590 && Client.field1073) {
               class175.addMenuEntry("Examine", class220.getColTags(16776960) + var4, 1003, var1, var2, var3);
            }

            if(Client.itemSelectionState == 1) {
               class175.addMenuEntry("Use", Client.selectedItemName + " -> " + class220.getColTags(16776960) + var4, 7, var1, var2, var3);
            } else if(Client.spellSelected) {
               if((WorldMapType3.spellTargetFlags & 2) == 2) {
                  class175.addMenuEntry(Client.field1078, Client.field1159 + " -> " + class220.getColTags(16776960) + var4, 8, var1, var2, var3);
               }
            } else {
               var7 = var0.field3590 && Client.field1073?2000:0;
               String[] var10 = var0.actions;
               if(Client.field1199) {
                  var10 = class251.method4456(var10);
               }

               if(var10 != null) {
                  for(var5 = 4; var5 >= 0; --var5) {
                     if(var10[var5] != null && !var10[var5].equalsIgnoreCase("Attack")) {
                        var6 = 0;
                        if(var5 == 0) {
                           var6 = var7 + 9;
                        }

                        if(var5 == 1) {
                           var6 = var7 + 10;
                        }

                        if(var5 == 2) {
                           var6 = var7 + 11;
                        }

                        if(var5 == 3) {
                           var6 = var7 + 12;
                        }

                        if(var5 == 4) {
                           var6 = var7 + 13;
                        }

                        class175.addMenuEntry(var10[var5], class220.getColTags(16776960) + var4, var6, var1, var2, var3);
                     }
                  }
               }

               if(var10 != null) {
                  for(var5 = 4; var5 >= 0; --var5) {
                     if(var10[var5] != null && var10[var5].equalsIgnoreCase("Attack")) {
                        short var9 = 0;
                        if(class91.field1441 != Client.field952) {
                           if(class91.field1440 == Client.field952 || class91.field1442 == Client.field952 && var0.combatLevel > XItemContainer.localPlayer.combatLevel) {
                              var9 = 2000;
                           }

                           var6 = 0;
                           if(var5 == 0) {
                              var6 = var9 + 9;
                           }

                           if(var5 == 1) {
                              var6 = var9 + 10;
                           }

                           if(var5 == 2) {
                              var6 = var9 + 11;
                           }

                           if(var5 == 3) {
                              var6 = var9 + 12;
                           }

                           if(var5 == 4) {
                              var6 = var9 + 13;
                           }

                           class175.addMenuEntry(var10[var5], class220.getColTags(16776960) + var4, var6, var1, var2, var3);
                        }
                     }
                  }
               }

               if(!var0.field3590 || !Client.field1073) {
                  class175.addMenuEntry("Examine", class220.getColTags(16776960) + var4, 1003, var1, var2, var3);
               }
            }
         }
      }

   }
}
