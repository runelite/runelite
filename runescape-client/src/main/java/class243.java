import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ih")
public class class243 {
   @ObfuscatedName("ki")
   @ObfuscatedGetter(
      intValue = 1461864679
   )
   @Export("selectedItemIndex")
   static int selectedItemIndex;

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Ljr;Ljava/lang/String;Ljava/lang/String;I)[Llh;",
      garbageValue = "1338718543"
   )
   @Export("getIndexedSprites")
   public static IndexedSprite[] getIndexedSprites(IndexDataBase var0, String var1, String var2) {
      int var3 = var0.getFile(var1);
      int var4 = var0.getChild(var3, var2);
      return ItemContainer.method1150(var0, var3, var4);
   }

   @ObfuscatedName("ic")
   @ObfuscatedSignature(
      signature = "(Lbd;IIII)V",
      garbageValue = "-831612921"
   )
   static final void method4597(Player var0, int var1, int var2, int var3) {
      if(class265.localPlayer != var0) {
         if(Client.menuOptionCount < 400) {
            String var4;
            if(var0.totalLevel == 0) {
               var4 = var0.actions[0] + var0.name + var0.actions[1] + GameCanvas.method843(var0.combatLevel, class265.localPlayer.combatLevel) + " " + " (" + "level-" + var0.combatLevel + ")" + var0.actions[2];
            } else {
               var4 = var0.actions[0] + var0.name + var0.actions[1] + " " + " (" + "skill-" + var0.totalLevel + ")" + var0.actions[2];
            }

            int var5;
            if(Client.itemSelectionState == 1) {
               class150.addMenuEntry("Use", Client.lastSelectedItemName + " " + "->" + " " + DynamicObject.getColTags(16777215) + var4, 14, var1, var2, var3);
            } else if(Client.spellSelected) {
               if((class49.field605 & 8) == 8) {
                  class150.addMenuEntry(Client.field1010, Client.field1063 + " " + "->" + " " + DynamicObject.getColTags(16777215) + var4, 15, var1, var2, var3);
               }
            } else {
               for(var5 = 7; var5 >= 0; --var5) {
                  if(Client.playerOptions[var5] != null) {
                     short var6 = 0;
                     if(Client.playerOptions[var5].equalsIgnoreCase("Attack")) {
                        if(Client.playerAttackOption == AttackOption.AttackOption_hidden) {
                           continue;
                        }

                        if(AttackOption.AttackOption_alwaysRightClick == Client.playerAttackOption || Client.playerAttackOption == AttackOption.AttackOption_dependsOnCombatLevels && var0.combatLevel > class265.localPlayer.combatLevel) {
                           var6 = 2000;
                        }

                        if(class265.localPlayer.team != 0 && var0.team != 0) {
                           if(var0.team == class265.localPlayer.team) {
                              var6 = 2000;
                           } else {
                              var6 = 0;
                           }
                        }
                     } else if(Client.playerOptionsPriorities[var5]) {
                        var6 = 2000;
                     }

                     boolean var7 = false;
                     int var8 = Client.playerMenuTypes[var5] + var6;
                     class150.addMenuEntry(Client.playerOptions[var5], DynamicObject.getColTags(16777215) + var4, var8, var1, var2, var3);
                  }
               }
            }

            for(var5 = 0; var5 < Client.menuOptionCount; ++var5) {
               if(Client.menuTypes[var5] == 23) {
                  Client.menuTargets[var5] = DynamicObject.getColTags(16777215) + var4;
                  break;
               }
            }

         }
      }
   }
}
