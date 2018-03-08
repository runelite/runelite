import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("g")
@Implements("BoundingBox")
public abstract class BoundingBox extends Node {
   @ObfuscatedName("mt")
   @ObfuscatedSignature(
      signature = "Lcy;"
   )
   @Export("chatMessages")
   static Varcs chatMessages;
   @ObfuscatedName("g")
   static int[] field239;

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-706888510"
   )
   public abstract void vmethod56();

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-559410051"
   )
   static final void method49(int var0) {
      class132.Viewport_entityIdsAtMouse[++class132.Viewport_entityCountAtMouse - 1] = var0;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Lbd;Lbd;IZB)I",
      garbageValue = "100"
   )
   static int method48(World var0, World var1, int var2, boolean var3) {
      if(var2 == 1) {
         int var4 = var0.playerCount;
         int var5 = var1.playerCount;
         if(!var3) {
            if(var4 == -1) {
               var4 = 2001;
            }

            if(var5 == -1) {
               var5 = 2001;
            }
         }

         return var4 - var5;
      } else {
         return var2 == 2?var0.location - var1.location:(var2 == 3?(var0.activity.equals("-")?(var1.activity.equals("-")?0:(var3?-1:1)):(var1.activity.equals("-")?(var3?1:-1):var0.activity.compareTo(var1.activity))):(var2 == 4?(var0.method1675()?(var1.method1675()?0:1):(var1.method1675()?-1:0)):(var2 == 5?(var0.method1677()?(var1.method1677()?0:1):(var1.method1677()?-1:0)):(var2 == 6?(var0.method1673()?(var1.method1673()?0:1):(var1.method1673()?-1:0)):(var2 == 7?(var0.method1690()?(var1.method1690()?0:1):(var1.method1690()?-1:0)):var0.id - var1.id)))));
      }
   }

   @ObfuscatedName("ho")
   @ObfuscatedSignature(
      signature = "(Lbi;IIII)V",
      garbageValue = "-1114076516"
   )
   static final void method47(Player var0, int var1, int var2, int var3) {
      if(WorldMapData.localPlayer != var0) {
         if(Client.menuOptionCount < 400) {
            String var4;
            if(var0.totalLevel == 0) {
               var4 = var0.actions[0] + var0.name + var0.actions[1] + class245.method4529(var0.combatLevel, WorldMapData.localPlayer.combatLevel) + " " + " (" + "level-" + var0.combatLevel + ")" + var0.actions[2];
            } else {
               var4 = var0.actions[0] + var0.name + var0.actions[1] + " " + " (" + "skill-" + var0.totalLevel + ")" + var0.actions[2];
            }

            int var5;
            if(Client.itemSelectionState == 1) {
               class169.addMenuEntry("Use", Client.lastSelectedItemName + " " + "->" + " " + class37.getColTags(16777215) + var4, 14, var1, var2, var3);
            } else if(Client.spellSelected) {
               if((class150.field2100 & 8) == 8) {
                  class169.addMenuEntry(Client.field1006, Client.field1074 + " " + "->" + " " + class37.getColTags(16777215) + var4, 15, var1, var2, var3);
               }
            } else {
               for(var5 = 7; var5 >= 0; --var5) {
                  if(Client.playerOptions[var5] != null) {
                     short var6 = 0;
                     if(Client.playerOptions[var5].equalsIgnoreCase("Attack")) {
                        if(Client.playerAttackOption == AttackOption.AttackOption_hidden) {
                           continue;
                        }

                        if(Client.playerAttackOption == AttackOption.AttackOption_alwaysRightClick || Client.playerAttackOption == AttackOption.AttackOption_dependsOnCombatLevels && var0.combatLevel > WorldMapData.localPlayer.combatLevel) {
                           var6 = 2000;
                        }

                        if(WorldMapData.localPlayer.team != 0 && var0.team != 0) {
                           if(var0.team == WorldMapData.localPlayer.team) {
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
                     class169.addMenuEntry(Client.playerOptions[var5], class37.getColTags(16777215) + var4, var8, var1, var2, var3);
                  }
               }
            }

            for(var5 = 0; var5 < Client.menuOptionCount; ++var5) {
               if(Client.menuTypes[var5] == 23) {
                  Client.menuTargets[var5] = class37.getColTags(16777215) + var4;
                  break;
               }
            }

         }
      }
   }

   @ObfuscatedName("iz")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "16"
   )
   static final void method50(int var0, int var1) {
      if(Script.loadWidget(var0)) {
         class167.method3263(Widget.widgets[var0], var1);
      }
   }
}
