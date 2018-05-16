import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gb")
public class class184 {
   @ObfuscatedName("my")
   @ObfuscatedGetter(
      intValue = -1621344433
   )
   static int field2378;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      longValue = 6328954577879716125L
   )
   static long field2380;
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Lhl;"
   )
   static Widget field2379;
   @ObfuscatedName("kv")
   @ObfuscatedSignature(
      signature = "Lbd;"
   )
   @Export("topContextMenuRow")
   static ContextMenuRow topContextMenuRow;

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(CI)Z",
      garbageValue = "1488900096"
   )
   public static boolean method3830(char var0) {
      return var0 >= '0' && var0 <= '9';
   }

   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      signature = "(IZII)V",
      garbageValue = "1842007658"
   )
   public static final void method3828(int var0, boolean var1, int var2) {
      if(var0 >= 8000 && var0 <= 48000) {
         AbstractSoundSystem.sampleRate = var0;
         AbstractSoundSystem.audioHighMemory = var1;
         AbstractSoundSystem.field1324 = var2;
      } else {
         throw new IllegalArgumentException();
      }
   }

   @ObfuscatedName("ik")
   @ObfuscatedSignature(
      signature = "(Ljj;IIII)V",
      garbageValue = "-223861270"
   )
   static final void method3829(NPCComposition var0, int var1, int var2, int var3) {
      if(Client.menuOptionCount < 400) {
         if(var0.configs != null) {
            var0 = var0.transform();
         }

         if(var0 != null) {
            if(var0.field3535) {
               if(!var0.field3534 || Client.field760 == var1) {
                  String var4 = var0.name;
                  if(var0.combatLevel != 0) {
                     var4 = var4 + class32.method598(var0.combatLevel, MilliTimer.localPlayer.combatLevel) + " " + " (" + "level-" + var0.combatLevel + ")";
                  }

                  if(var0.field3534 && Client.field753) {
                     VertexNormal.addMenuEntry("Examine", class50.getColTags(16776960) + var4, 1003, var1, var2, var3);
                  }

                  if(Client.itemSelectionState == 1) {
                     VertexNormal.addMenuEntry("Use", Client.lastSelectedItemName + " " + "->" + " " + class50.getColTags(16776960) + var4, 7, var1, var2, var3);
                  } else if(Client.spellSelected) {
                     if((class45.field373 & 2) == 2) {
                        VertexNormal.addMenuEntry(Client.field750, Client.field751 + " " + "->" + " " + class50.getColTags(16776960) + var4, 8, var1, var2, var3);
                     }
                  } else {
                     int var5 = var0.field3534 && Client.field753?2000:0;
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

                              VertexNormal.addMenuEntry(var6[var7], class50.getColTags(16776960) + var4, var8, var1, var2, var3);
                           }
                        }
                     }

                     if(var6 != null) {
                        for(var7 = 4; var7 >= 0; --var7) {
                           if(var6[var7] != null && var6[var7].equalsIgnoreCase("Attack")) {
                              short var9 = 0;
                              if(Client.npcAttackOption != AttackOption.AttackOption_hidden) {
                                 if(Client.npcAttackOption == AttackOption.AttackOption_alwaysRightClick || AttackOption.AttackOption_dependsOnCombatLevels == Client.npcAttackOption && var0.combatLevel > MilliTimer.localPlayer.combatLevel) {
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

                                 VertexNormal.addMenuEntry(var6[var7], class50.getColTags(16776960) + var4, var8, var1, var2, var3);
                              }
                           }
                        }
                     }

                     if(!var0.field3534 || !Client.field753) {
                        VertexNormal.addMenuEntry("Examine", class50.getColTags(16776960) + var4, 1003, var1, var2, var3);
                     }
                  }

               }
            }
         }
      }
   }
}
