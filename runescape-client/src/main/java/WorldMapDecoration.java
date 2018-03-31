import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ak")
@Implements("WorldMapDecoration")
public class WorldMapDecoration {
   @ObfuscatedName("cv")
   @ObfuscatedSignature(
      signature = "Lfy;"
   )
   @Export("socket")
   static Task socket;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -362055059
   )
   @Export("objectDefinitionId")
   final int objectDefinitionId;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 1828880653
   )
   @Export("decoration")
   final int decoration;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 160883779
   )
   @Export("rotation")
   final int rotation;

   WorldMapDecoration(int var1, int var2, int var3) {
      this.objectDefinitionId = var1;
      this.decoration = var2;
      this.rotation = var3;
   }

   @ObfuscatedName("ia")
   @ObfuscatedSignature(
      signature = "(Ljk;IIIB)V",
      garbageValue = "34"
   )
   static final void method302(NPCComposition var0, int var1, int var2, int var3) {
      if(Client.menuOptionCount < 400) {
         if(var0.configs != null) {
            var0 = var0.transform();
         }

         if(var0 != null) {
            if(var0.field3729) {
               if(!var0.field3731 || Client.field1055 == var1) {
                  String var4 = var0.name;
                  int var7;
                  int var8;
                  if(var0.combatLevel != 0) {
                     var7 = var0.combatLevel;
                     var8 = WorldComparator.localPlayer.combatLevel;
                     int var9 = var8 - var7;
                     String var6;
                     if(var9 < -9) {
                        var6 = class173.getColTags(16711680);
                     } else if(var9 < -6) {
                        var6 = class173.getColTags(16723968);
                     } else if(var9 < -3) {
                        var6 = class173.getColTags(16740352);
                     } else if(var9 < 0) {
                        var6 = class173.getColTags(16756736);
                     } else if(var9 > 9) {
                        var6 = class173.getColTags(65280);
                     } else if(var9 > 6) {
                        var6 = class173.getColTags(4259584);
                     } else if(var9 > 3) {
                        var6 = class173.getColTags(8453888);
                     } else if(var9 > 0) {
                        var6 = class173.getColTags(12648192);
                     } else {
                        var6 = class173.getColTags(16776960);
                     }

                     var4 = var4 + var6 + " " + " (" + "level-" + var0.combatLevel + ")";
                  }

                  if(var0.field3731 && Client.field1094) {
                     RunException.addMenuEntry("Examine", class173.getColTags(16776960) + var4, 1003, var1, var2, var3);
                  }

                  if(Client.itemSelectionState == 1) {
                     RunException.addMenuEntry("Use", Client.lastSelectedItemName + " " + "->" + " " + class173.getColTags(16776960) + var4, 7, var1, var2, var3);
                  } else if(Client.spellSelected) {
                     if((class241.field2799 & 2) == 2) {
                        RunException.addMenuEntry(Client.field956, Client.field1015 + " " + "->" + " " + class173.getColTags(16776960) + var4, 8, var1, var2, var3);
                     }
                  } else {
                     int var10 = var0.field3731 && Client.field1094?2000:0;
                     String[] var11 = var0.actions;
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

                              RunException.addMenuEntry(var11[var7], class173.getColTags(16776960) + var4, var8, var1, var2, var3);
                           }
                        }
                     }

                     if(var11 != null) {
                        for(var7 = 4; var7 >= 0; --var7) {
                           if(var11[var7] != null && var11[var7].equalsIgnoreCase("Attack")) {
                              short var12 = 0;
                              if(AttackOption.AttackOption_hidden != Client.npcAttackOption) {
                                 if(Client.npcAttackOption == AttackOption.AttackOption_alwaysRightClick || Client.npcAttackOption == AttackOption.AttackOption_dependsOnCombatLevels && var0.combatLevel > WorldComparator.localPlayer.combatLevel) {
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

                                 RunException.addMenuEntry(var11[var7], class173.getColTags(16776960) + var4, var8, var1, var2, var3);
                              }
                           }
                        }
                     }

                     if(!var0.field3731 || !Client.field1094) {
                        RunException.addMenuEntry("Examine", class173.getColTags(16776960) + var4, 1003, var1, var2, var3);
                     }
                  }

               }
            }
         }
      }
   }

   @ObfuscatedName("km")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1000000"
   )
   static final void method303() {
      for(int var0 = 0; var0 < class93.playerIndexesCount; ++var0) {
         Player var1 = Client.cachedPlayers[class93.playerIndices[var0]];
         var1.method1145();
      }

   }
}
