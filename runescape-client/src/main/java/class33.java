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
      if(var0 == 100) {
         class46.intStackSize -= 3;
         var3 = class83.intStack[class46.intStackSize];
         var4 = class83.intStack[class46.intStackSize + 1];
         int var5 = class83.intStack[class46.intStackSize + 2];
         if(var4 == 0) {
            throw new RuntimeException();
         } else {
            Widget var6 = PacketBuffer.method3403(var3);
            if(var6.children == null) {
               var6.children = new Widget[var5 + 1];
            }

            if(var6.children.length <= var5) {
               Widget[] var7 = new Widget[var5 + 1];

               for(int var8 = 0; var8 < var6.children.length; ++var8) {
                  var7[var8] = var6.children[var8];
               }

               var6.children = var7;
            }

            if(var5 > 0 && var6.children[var5 - 1] == null) {
               throw new RuntimeException("" + (var5 - 1));
            } else {
               Widget var12 = new Widget();
               var12.type = var4;
               var12.parentId = var12.id = var6.id;
               var12.index = var5;
               var12.hasScript = true;
               var6.children[var5] = var12;
               if(var2) {
                  class83.field1364 = var12;
               } else {
                  class60.field766 = var12;
               }

               class88.method1714(var6);
               return 1;
            }
         }
      } else {
         Widget var9;
         if(var0 == 101) {
            var9 = var2?class83.field1364:class60.field766;
            Widget var10 = PacketBuffer.method3403(var9.id);
            var10.children[var9.index] = null;
            class88.method1714(var10);
            return 1;
         } else if(var0 == 102) {
            var9 = PacketBuffer.method3403(class83.intStack[--class46.intStackSize]);
            var9.children = null;
            class88.method1714(var9);
            return 1;
         } else if(var0 != 200) {
            if(var0 == 201) {
               var9 = PacketBuffer.method3403(class83.intStack[--class46.intStackSize]);
               if(var9 != null) {
                  class83.intStack[++class46.intStackSize - 1] = 1;
                  if(var2) {
                     class83.field1364 = var9;
                  } else {
                     class60.field766 = var9;
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
            Widget var11 = class202.method3650(var3, var4);
            if(var11 != null && var4 != -1) {
               class83.intStack[++class46.intStackSize - 1] = 1;
               if(var2) {
                  class83.field1364 = var11;
               } else {
                  class60.field766 = var11;
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
      class50 var0 = class50.keyboard;
      synchronized(class50.keyboard) {
         ++class50.keyboardIdleTicks;
         class50.field672 = class50.field674;
         class50.field671 = 0;
         int var1;
         if(class50.field667 < 0) {
            for(var1 = 0; var1 < 112; ++var1) {
               class50.field659[var1] = false;
            }

            class50.field667 = class50.field663;
         } else {
            while(class50.field663 != class50.field667) {
               var1 = class50.field665[class50.field663];
               class50.field663 = class50.field663 + 1 & 127;
               if(var1 < 0) {
                  class50.field659[~var1] = false;
               } else {
                  if(!class50.field659[var1] && class50.field671 < class50.field670.length - 1) {
                     class50.field670[++class50.field671 - 1] = var1;
                  }

                  class50.field659[var1] = true;
               }
            }
         }

         if(class50.field671 > 0) {
            class50.keyboardIdleTicks = 0;
         }

         class50.field674 = class50.field673;
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
      int var10;
      for(int var9 = 0; var9 < 8; ++var9) {
         for(var10 = 0; var10 < 8; ++var10) {
            if(var2 + var9 > 0 && var2 + var9 < 103 && var3 + var10 > 0 && var3 + var10 < 103) {
               var8[var1].flags[var2 + var9][var3 + var10] &= -16777217;
            }
         }
      }

      Buffer var13 = new Buffer(var0);

      for(var10 = 0; var10 < 4; ++var10) {
         for(int var11 = 0; var11 < 64; ++var11) {
            for(int var12 = 0; var12 < 64; ++var12) {
               if(var10 == var4 && var11 >= var5 && var11 < var5 + 8 && var12 >= var6 && var12 < var6 + 8) {
                  GraphicsObject.method1683(var13, var1, var2 + World.method1568(var11 & 7, var12 & 7, var7), var3 + Varbit.method4428(var11 & 7, var12 & 7, var7), 0, 0, var7);
               } else {
                  GraphicsObject.method1683(var13, 0, -1, -1, 0, 0, 0);
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
            var0 = var0.method4646();
         }

         if(var0 != null) {
            if(var0.field3588) {
               if(!var0.field3590 || Client.field1065 == var1) {
                  String var4 = var0.name;
                  int var7;
                  int var8;
                  if(var0.combatLevel != 0) {
                     var7 = var0.combatLevel;
                     var8 = XItemContainer.localPlayer.combatLevel;
                     int var9 = var8 - var7;
                     String var6;
                     if(var9 < -9) {
                        var6 = class220.method4055(16711680);
                     } else if(var9 < -6) {
                        var6 = class220.method4055(16723968);
                     } else if(var9 < -3) {
                        var6 = class220.method4055(16740352);
                     } else if(var9 < 0) {
                        var6 = class220.method4055(16756736);
                     } else if(var9 > 9) {
                        var6 = class220.method4055('\uff00');
                     } else if(var9 > 6) {
                        var6 = class220.method4055(4259584);
                     } else if(var9 > 3) {
                        var6 = class220.method4055(8453888);
                     } else if(var9 > 0) {
                        var6 = class220.method4055(12648192);
                     } else {
                        var6 = class220.method4055(16776960);
                     }

                     var4 = var4 + var6 + " " + " (" + "level-" + var0.combatLevel + ")";
                  }

                  if(var0.field3590 && Client.field1073) {
                     class175.addMenuEntry("Examine", class220.method4055(16776960) + var4, 1003, var1, var2, var3);
                  }

                  if(Client.itemSelectionState == 1) {
                     class175.addMenuEntry("Use", Client.selectedItemName + " " + "->" + " " + class220.method4055(16776960) + var4, 7, var1, var2, var3);
                  } else if(Client.field1082) {
                     if((WorldMapType3.spellTargetFlags & 2) == 2) {
                        class175.addMenuEntry(Client.field1078, Client.field1159 + " " + "->" + " " + class220.method4055(16776960) + var4, 8, var1, var2, var3);
                     }
                  } else {
                     int var10 = var0.field3590 && Client.field1073?2000:0;
                     String[] var11 = var0.actions;
                     if(Client.field1199) {
                        var11 = class251.method4456(var11);
                     }

                     if(var11 != null) {
                        for(var7 = 4; var7 >= 0; --var7) {
                           if(var11[var7] != null && !var11[var7].equalsIgnoreCase("Attack")) {
                              var8 = 0;
                              if(var7 == 0) {
                                 var8 = var10 + 9;
                              }

                              if(var7 == 1) {
                                 var8 = var10 + 10;
                              }

                              if(var7 == 2) {
                                 var8 = var10 + 11;
                              }

                              if(var7 == 3) {
                                 var8 = var10 + 12;
                              }

                              if(var7 == 4) {
                                 var8 = var10 + 13;
                              }

                              class175.addMenuEntry(var11[var7], class220.method4055(16776960) + var4, var8, var1, var2, var3);
                           }
                        }
                     }

                     if(var11 != null) {
                        for(var7 = 4; var7 >= 0; --var7) {
                           if(var11[var7] != null && var11[var7].equalsIgnoreCase("Attack")) {
                              short var12 = 0;
                              if(class91.field1441 != Client.field952) {
                                 if(class91.field1440 == Client.field952 || class91.field1442 == Client.field952 && var0.combatLevel > XItemContainer.localPlayer.combatLevel) {
                                    var12 = 2000;
                                 }

                                 var8 = 0;
                                 if(var7 == 0) {
                                    var8 = var12 + 9;
                                 }

                                 if(var7 == 1) {
                                    var8 = var12 + 10;
                                 }

                                 if(var7 == 2) {
                                    var8 = var12 + 11;
                                 }

                                 if(var7 == 3) {
                                    var8 = var12 + 12;
                                 }

                                 if(var7 == 4) {
                                    var8 = var12 + 13;
                                 }

                                 class175.addMenuEntry(var11[var7], class220.method4055(16776960) + var4, var8, var1, var2, var3);
                              }
                           }
                        }
                     }

                     if(!var0.field3590 || !Client.field1073) {
                        class175.addMenuEntry("Examine", class220.method4055(16776960) + var4, 1003, var1, var2, var3);
                     }
                  }

               }
            }
         }
      }
   }
}
