import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ix")
public class class234 {
   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "[Lkg;"
   )
   @Export("runeSprites")
   static IndexedSprite[] runeSprites;
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "Lkg;"
   )
   static IndexedSprite field2945;

   @ObfuscatedName("hf")
   @ObfuscatedSignature(
      signature = "(Lbj;IIII)V",
      garbageValue = "-654823605"
   )
   static final void method4211(Player var0, int var1, int var2, int var3) {
      if(UrlRequest.localPlayer != var0) {
         if(Client.menuOptionCount < 400) {
            String var4;
            int var7;
            if(var0.totalLevel == 0) {
               String var5 = var0.actions[0] + var0.name + var0.actions[1];
               var7 = var0.combatLevel;
               int var8 = UrlRequest.localPlayer.combatLevel;
               int var9 = var8 - var7;
               String var6;
               if(var9 < -9) {
                  var6 = Buffer.getColTags(16711680);
               } else if(var9 < -6) {
                  var6 = Buffer.getColTags(16723968);
               } else if(var9 < -3) {
                  var6 = Buffer.getColTags(16740352);
               } else if(var9 < 0) {
                  var6 = Buffer.getColTags(16756736);
               } else if(var9 > 9) {
                  var6 = Buffer.getColTags(65280);
               } else if(var9 > 6) {
                  var6 = Buffer.getColTags(4259584);
               } else if(var9 > 3) {
                  var6 = Buffer.getColTags(8453888);
               } else if(var9 > 0) {
                  var6 = Buffer.getColTags(12648192);
               } else {
                  var6 = Buffer.getColTags(16776960);
               }

               var4 = var5 + var6 + " " + " (" + "level-" + var0.combatLevel + ")" + var0.actions[2];
            } else {
               var4 = var0.actions[0] + var0.name + var0.actions[1] + " " + " (" + "skill-" + var0.totalLevel + ")" + var0.actions[2];
            }

            int var10;
            if(Client.itemSelectionState == 1) {
               class37.addMenuEntry("Use", Client.lastSelectedItemName + " " + "->" + " " + Buffer.getColTags(16777215) + var4, 14, var1, var2, var3);
            } else if(Client.spellSelected) {
               if((class86.field1278 & 8) == 8) {
                  class37.addMenuEntry(Client.field986, Client.field910 + " " + "->" + " " + Buffer.getColTags(16777215) + var4, 15, var1, var2, var3);
               }
            } else {
               for(var10 = 7; var10 >= 0; --var10) {
                  if(Client.playerOptions[var10] != null) {
                     short var11 = 0;
                     if(Client.playerOptions[var10].equalsIgnoreCase("Attack")) {
                        if(Client.playerAttackOption == AttackOption.AttackOption_hidden) {
                           continue;
                        }

                        if(AttackOption.AttackOption_alwaysRightClick == Client.playerAttackOption || Client.playerAttackOption == AttackOption.AttackOption_dependsOnCombatLevels && var0.combatLevel > UrlRequest.localPlayer.combatLevel) {
                           var11 = 2000;
                        }

                        if(UrlRequest.localPlayer.team != 0 && var0.team != 0) {
                           if(var0.team == UrlRequest.localPlayer.team) {
                              var11 = 2000;
                           } else {
                              var11 = 0;
                           }
                        }
                     } else if(Client.playerOptionsPriorities[var10]) {
                        var11 = 2000;
                     }

                     boolean var12 = false;
                     var7 = Client.playerMenuTypes[var10] + var11;
                     class37.addMenuEntry(Client.playerOptions[var10], Buffer.getColTags(16777215) + var4, var7, var1, var2, var3);
                  }
               }
            }

            for(var10 = 0; var10 < Client.menuOptionCount; ++var10) {
               if(Client.menuTypes[var10] == 23) {
                  Client.menuTargets[var10] = Buffer.getColTags(16777215) + var4;
                  break;
               }
            }

         }
      }
   }
}
