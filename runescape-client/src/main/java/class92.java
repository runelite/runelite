import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cb")
public class class92 {
   @ObfuscatedName("m")
   static byte[] field1389;
   @ObfuscatedName("h")
   static byte[] field1390;
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "[Lgy;"
   )
   static Buffer[] field1398;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 1692034155
   )
   @Export("playerIndexesCount")
   static int playerIndexesCount;
   @ObfuscatedName("t")
   @Export("playerIndices")
   static int[] playerIndices;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 1438656957
   )
   static int field1394;
   @ObfuscatedName("z")
   static int[] field1402;
   @ObfuscatedName("k")
   @Export("Players_regions")
   static int[] Players_regions;
   @ObfuscatedName("c")
   @Export("Players_orientations")
   static int[] Players_orientations;
   @ObfuscatedName("o")
   @Export("Players_targetIndices")
   static int[] Players_targetIndices;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 1504212801
   )
   static int field1399;
   @ObfuscatedName("f")
   static int[] field1400;
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Lgy;"
   )
   static Buffer field1401;
   @ObfuscatedName("cg")
   @ObfuscatedSignature(
      signature = "Led;"
   )
   @Export("socket")
   static Task socket;

   static {
      field1389 = new byte[2048];
      field1390 = new byte[2048];
      field1398 = new Buffer[2048];
      playerIndexesCount = 0;
      playerIndices = new int[2048];
      field1394 = 0;
      field1402 = new int[2048];
      Players_regions = new int[2048];
      Players_orientations = new int[2048];
      Players_targetIndices = new int[2048];
      field1399 = 0;
      field1400 = new int[2048];
      field1401 = new Buffer(new byte[5000]);
   }

   @ObfuscatedName("it")
   @ObfuscatedSignature(
      signature = "(Lby;IIIB)V",
      garbageValue = "106"
   )
   static final void method1968(Player var0, int var1, int var2, int var3) {
      if(GroundObject.localPlayer != var0) {
         if(Client.menuOptionCount < 400) {
            String var4;
            if(var0.totalLevel == 0) {
               var4 = var0.actions[0] + var0.name + var0.actions[1] + Tile.method2711(var0.combatLevel, GroundObject.localPlayer.combatLevel) + " " + " (" + "level-" + var0.combatLevel + ")" + var0.actions[2];
            } else {
               var4 = var0.actions[0] + var0.name + var0.actions[1] + " " + " (" + "skill-" + var0.totalLevel + ")" + var0.actions[2];
            }

            int var5;
            if(Client.itemSelectionState == 1) {
               NPCComposition.addMenuEntry("Use", Client.lastSelectedItemName + " " + "->" + " " + class70.getColTags(16777215) + var4, 14, var1, var2, var3);
            } else if(Client.spellSelected) {
               if((Occluder.field2038 & 8) == 8) {
                  NPCComposition.addMenuEntry(Client.field854, Client.field995 + " " + "->" + " " + class70.getColTags(16777215) + var4, 15, var1, var2, var3);
               }
            } else {
               for(var5 = 7; var5 >= 0; --var5) {
                  if(Client.playerOptions[var5] != null) {
                     short var6 = 0;
                     if(Client.playerOptions[var5].equalsIgnoreCase("Attack")) {
                        if(Client.playerAttackOption == AttackOption.AttackOption_hidden) {
                           continue;
                        }

                        if(AttackOption.AttackOption_alwaysRightClick == Client.playerAttackOption || Client.playerAttackOption == AttackOption.AttackOption_dependsOnCombatLevels && var0.combatLevel > GroundObject.localPlayer.combatLevel) {
                           var6 = 2000;
                        }

                        if(GroundObject.localPlayer.team != 0 && var0.team != 0) {
                           if(var0.team == GroundObject.localPlayer.team) {
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
                     NPCComposition.addMenuEntry(Client.playerOptions[var5], class70.getColTags(16777215) + var4, var8, var1, var2, var3);
                  }
               }
            }

            for(var5 = 0; var5 < Client.menuOptionCount; ++var5) {
               if(Client.menuTypes[var5] == 23) {
                  Client.menuTargets[var5] = class70.getColTags(16777215) + var4;
                  break;
               }
            }

         }
      }
   }
}
