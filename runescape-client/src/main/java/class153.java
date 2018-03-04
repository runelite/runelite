import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("en")
public class class153 extends class297 {
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 1090730889
   )
   static int field2124;
   @ObfuscatedName("d")
   final boolean field2126;

   public class153(boolean var1) {
      this.field2126 = var1;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Lkz;Lkz;I)I",
      garbageValue = "1728855085"
   )
   int method3217(ChatPlayer var1, ChatPlayer var2) {
      return var1.world != 0 && var2.world != 0?(this.field2126?var1.field3840 - var2.field3840:var2.field3840 - var1.field3840):this.method5387(var1, var2);
   }

   public int compare(Object var1, Object var2) {
      return this.method3217((ChatPlayer)var1, (ChatPlayer)var2);
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(ILct;ZI)I",
      garbageValue = "-568661708"
   )
   static int method3216(int var0, Script var1, boolean var2) {
      int var3;
      int var4;
      if(var0 == 4000) {
         class81.intStackSize -= 2;
         var3 = class81.intStack[class81.intStackSize];
         var4 = class81.intStack[class81.intStackSize + 1];
         class81.intStack[++class81.intStackSize - 1] = var3 + var4;
         return 1;
      } else if(var0 == 4001) {
         class81.intStackSize -= 2;
         var3 = class81.intStack[class81.intStackSize];
         var4 = class81.intStack[class81.intStackSize + 1];
         class81.intStack[++class81.intStackSize - 1] = var3 - var4;
         return 1;
      } else if(var0 == 4002) {
         class81.intStackSize -= 2;
         var3 = class81.intStack[class81.intStackSize];
         var4 = class81.intStack[class81.intStackSize + 1];
         class81.intStack[++class81.intStackSize - 1] = var4 * var3;
         return 1;
      } else if(var0 == 4003) {
         class81.intStackSize -= 2;
         var3 = class81.intStack[class81.intStackSize];
         var4 = class81.intStack[class81.intStackSize + 1];
         class81.intStack[++class81.intStackSize - 1] = var3 / var4;
         return 1;
      } else if(var0 == 4004) {
         var3 = class81.intStack[--class81.intStackSize];
         class81.intStack[++class81.intStackSize - 1] = (int)(Math.random() * (double)var3);
         return 1;
      } else if(var0 == 4005) {
         var3 = class81.intStack[--class81.intStackSize];
         class81.intStack[++class81.intStackSize - 1] = (int)(Math.random() * (double)(var3 + 1));
         return 1;
      } else if(var0 == 4006) {
         class81.intStackSize -= 5;
         var3 = class81.intStack[class81.intStackSize];
         var4 = class81.intStack[class81.intStackSize + 1];
         int var5 = class81.intStack[class81.intStackSize + 2];
         int var6 = class81.intStack[class81.intStackSize + 3];
         int var7 = class81.intStack[class81.intStackSize + 4];
         class81.intStack[++class81.intStackSize - 1] = var3 + (var4 - var3) * (var7 - var5) / (var6 - var5);
         return 1;
      } else if(var0 == 4007) {
         class81.intStackSize -= 2;
         var3 = class81.intStack[class81.intStackSize];
         var4 = class81.intStack[class81.intStackSize + 1];
         class81.intStack[++class81.intStackSize - 1] = var3 + var3 * var4 / 100;
         return 1;
      } else if(var0 == 4008) {
         class81.intStackSize -= 2;
         var3 = class81.intStack[class81.intStackSize];
         var4 = class81.intStack[class81.intStackSize + 1];
         class81.intStack[++class81.intStackSize - 1] = var3 | 1 << var4;
         return 1;
      } else if(var0 == 4009) {
         class81.intStackSize -= 2;
         var3 = class81.intStack[class81.intStackSize];
         var4 = class81.intStack[class81.intStackSize + 1];
         class81.intStack[++class81.intStackSize - 1] = var3 & -1 - (1 << var4);
         return 1;
      } else if(var0 == 4010) {
         class81.intStackSize -= 2;
         var3 = class81.intStack[class81.intStackSize];
         var4 = class81.intStack[class81.intStackSize + 1];
         class81.intStack[++class81.intStackSize - 1] = (var3 & 1 << var4) != 0?1:0;
         return 1;
      } else if(var0 == 4011) {
         class81.intStackSize -= 2;
         var3 = class81.intStack[class81.intStackSize];
         var4 = class81.intStack[class81.intStackSize + 1];
         class81.intStack[++class81.intStackSize - 1] = var3 % var4;
         return 1;
      } else if(var0 == 4012) {
         class81.intStackSize -= 2;
         var3 = class81.intStack[class81.intStackSize];
         var4 = class81.intStack[class81.intStackSize + 1];
         if(var3 == 0) {
            class81.intStack[++class81.intStackSize - 1] = 0;
         } else {
            class81.intStack[++class81.intStackSize - 1] = (int)Math.pow((double)var3, (double)var4);
         }

         return 1;
      } else if(var0 == 4013) {
         class81.intStackSize -= 2;
         var3 = class81.intStack[class81.intStackSize];
         var4 = class81.intStack[class81.intStackSize + 1];
         if(var3 == 0) {
            class81.intStack[++class81.intStackSize - 1] = 0;
            return 1;
         } else {
            switch(var4) {
            case 0:
               class81.intStack[++class81.intStackSize - 1] = Integer.MAX_VALUE;
               break;
            case 1:
               class81.intStack[++class81.intStackSize - 1] = var3;
               break;
            case 2:
               class81.intStack[++class81.intStackSize - 1] = (int)Math.sqrt((double)var3);
               break;
            case 3:
               class81.intStack[++class81.intStackSize - 1] = (int)Math.cbrt((double)var3);
               break;
            case 4:
               class81.intStack[++class81.intStackSize - 1] = (int)Math.sqrt(Math.sqrt((double)var3));
               break;
            default:
               class81.intStack[++class81.intStackSize - 1] = (int)Math.pow((double)var3, 1.0D / (double)var4);
            }

            return 1;
         }
      } else if(var0 == 4014) {
         class81.intStackSize -= 2;
         var3 = class81.intStack[class81.intStackSize];
         var4 = class81.intStack[class81.intStackSize + 1];
         class81.intStack[++class81.intStackSize - 1] = var3 & var4;
         return 1;
      } else if(var0 == 4015) {
         class81.intStackSize -= 2;
         var3 = class81.intStack[class81.intStackSize];
         var4 = class81.intStack[class81.intStackSize + 1];
         class81.intStack[++class81.intStackSize - 1] = var3 | var4;
         return 1;
      } else if(var0 == 4018) {
         class81.intStackSize -= 3;
         long var9 = (long)class81.intStack[class81.intStackSize];
         long var11 = (long)class81.intStack[class81.intStackSize + 1];
         long var13 = (long)class81.intStack[class81.intStackSize + 2];
         class81.intStack[++class81.intStackSize - 1] = (int)(var13 * var9 / var11);
         return 1;
      } else {
         return 2;
      }
   }

   @ObfuscatedName("hy")
   @ObfuscatedSignature(
      signature = "(Ljg;IIIB)V",
      garbageValue = "13"
   )
   static final void method3220(NPCComposition var0, int var1, int var2, int var3) {
      if(Client.menuOptionCount < 400) {
         if(var0.configs != null) {
            var0 = var0.transform();
         }

         if(var0 != null) {
            if(var0.field3718) {
               if(!var0.field3738 || Client.field1008 == var1) {
                  String var4 = var0.name;
                  if(var0.combatLevel != 0) {
                     var4 = var4 + class45.method634(var0.combatLevel, TotalQuantityComparator.localPlayer.combatLevel) + " " + " (" + "level-" + var0.combatLevel + ")";
                  }

                  if(var0.field3738 && Client.field937) {
                     TextureProvider.addMenuEntry("Examine", IndexFile.getColTags(16776960) + var4, 1003, var1, var2, var3);
                  }

                  if(Client.itemSelectionState == 1) {
                     TextureProvider.addMenuEntry("Use", Client.lastSelectedItemName + " " + "->" + " " + IndexFile.getColTags(16776960) + var4, 7, var1, var2, var3);
                  } else if(Client.spellSelected) {
                     if((class243.field2960 & 2) == 2) {
                        TextureProvider.addMenuEntry(Client.field1097, Client.field941 + " " + "->" + " " + IndexFile.getColTags(16776960) + var4, 8, var1, var2, var3);
                     }
                  } else {
                     int var5 = var0.field3738 && Client.field937?2000:0;
                     String[] var6 = var0.actions;
                     int var7;
                     int var8;
                     if(var6 != null) {
                        for(var7 = 4; var7 >= 0; --var7) {
                           if(var6[var7] != null && !var6[var7].equalsIgnoreCase("Attack")) {
                              var8 = 0;
                              if(var7 == 0) {
                                 var8 = var5 + 9;
                              }

                              if(var7 == 1) {
                                 var8 = var5 + 10;
                              }

                              if(var7 == 2) {
                                 var8 = var5 + 11;
                              }

                              if(var7 == 3) {
                                 var8 = var5 + 12;
                              }

                              if(var7 == 4) {
                                 var8 = var5 + 13;
                              }

                              TextureProvider.addMenuEntry(var6[var7], IndexFile.getColTags(16776960) + var4, var8, var1, var2, var3);
                           }
                        }
                     }

                     if(var6 != null) {
                        for(var7 = 4; var7 >= 0; --var7) {
                           if(var6[var7] != null && var6[var7].equalsIgnoreCase("Attack")) {
                              short var9 = 0;
                              if(Client.npcAttackOption != AttackOption.AttackOption_hidden) {
                                 if(Client.npcAttackOption == AttackOption.AttackOption_alwaysRightClick || AttackOption.AttackOption_dependsOnCombatLevels == Client.npcAttackOption && var0.combatLevel > TotalQuantityComparator.localPlayer.combatLevel) {
                                    var9 = 2000;
                                 }

                                 var8 = 0;
                                 if(var7 == 0) {
                                    var8 = var9 + 9;
                                 }

                                 if(var7 == 1) {
                                    var8 = var9 + 10;
                                 }

                                 if(var7 == 2) {
                                    var8 = var9 + 11;
                                 }

                                 if(var7 == 3) {
                                    var8 = var9 + 12;
                                 }

                                 if(var7 == 4) {
                                    var8 = var9 + 13;
                                 }

                                 TextureProvider.addMenuEntry(var6[var7], IndexFile.getColTags(16776960) + var4, var8, var1, var2, var3);
                              }
                           }
                        }
                     }

                     if(!var0.field3738 || !Client.field937) {
                        TextureProvider.addMenuEntry("Examine", IndexFile.getColTags(16776960) + var4, 1003, var1, var2, var3);
                     }
                  }

               }
            }
         }
      }
   }
}
