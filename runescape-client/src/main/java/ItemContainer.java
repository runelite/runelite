import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bx")
@Implements("ItemContainer")
public class ItemContainer extends Node {
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Lgn;"
   )
   @Export("itemContainers")
   static HashTable itemContainers;
   @ObfuscatedName("ey")
   @ObfuscatedSignature(
      signature = "Ljf;"
   )
   static class262 field799;
   @ObfuscatedName("pu")
   @ObfuscatedGetter(
      intValue = -1001635797
   )
   static int field801;
   @ObfuscatedName("k")
   @Export("itemIds")
   int[] itemIds;
   @ObfuscatedName("e")
   @Export("stackSizes")
   int[] stackSizes;

   static {
      itemContainers = new HashTable(32);
   }

   ItemContainer() {
      this.itemIds = new int[]{-1};
      this.stackSizes = new int[]{0};
   }

   @ObfuscatedName("jk")
   @ObfuscatedSignature(
      signature = "(Lhj;I)Z",
      garbageValue = "672491550"
   )
   static final boolean method1129(Widget var0) {
      if(var0.tableActions == null) {
         return false;
      } else {
         for(int var1 = 0; var1 < var0.tableActions.length; ++var1) {
            int var2 = ScriptVarType.method27(var0, var1);
            int var3 = var0.field2687[var1];
            if(var0.tableActions[var1] == 2) {
               if(var2 >= var3) {
                  return false;
               }
            } else if(var0.tableActions[var1] == 3) {
               if(var2 <= var3) {
                  return false;
               }
            } else if(var0.tableActions[var1] == 4) {
               if(var3 == var2) {
                  return false;
               }
            } else if(var2 != var3) {
               return false;
            }
         }

         return true;
      }
   }

   @ObfuscatedName("ig")
   @ObfuscatedSignature(
      signature = "(Lbw;IIIS)V",
      garbageValue = "-392"
   )
   static final void method1130(Player var0, int var1, int var2, int var3) {
      if(AbstractByteBuffer.localPlayer != var0) {
         if(Client.menuOptionCount < 400) {
            String var4;
            int var7;
            if(var0.totalLevel == 0) {
               String var5 = var0.actions[0] + var0.name + var0.actions[1];
               var7 = var0.combatLevel;
               int var8 = AbstractByteBuffer.localPlayer.combatLevel;
               int var9 = var8 - var7;
               String var6;
               if(var9 < -9) {
                  var6 = class60.getColTags(16711680);
               } else if(var9 < -6) {
                  var6 = class60.getColTags(16723968);
               } else if(var9 < -3) {
                  var6 = class60.getColTags(16740352);
               } else if(var9 < 0) {
                  var6 = class60.getColTags(16756736);
               } else if(var9 > 9) {
                  var6 = class60.getColTags(65280);
               } else if(var9 > 6) {
                  var6 = class60.getColTags(4259584);
               } else if(var9 > 3) {
                  var6 = class60.getColTags(8453888);
               } else if(var9 > 0) {
                  var6 = class60.getColTags(12648192);
               } else {
                  var6 = class60.getColTags(16776960);
               }

               var4 = var5 + var6 + " " + " (" + "level-" + var0.combatLevel + ")" + var0.actions[2];
            } else {
               var4 = var0.actions[0] + var0.name + var0.actions[1] + " " + " (" + "skill-" + var0.totalLevel + ")" + var0.actions[2];
            }

            int var10;
            if(Client.itemSelectionState == 1) {
               class10.addMenuEntry("Use", Client.field1067 + " " + "->" + " " + class60.getColTags(16777215) + var4, 14, var1, var2, var3);
            } else if(Client.spellSelected) {
               if((WorldMapType1.field451 & 8) == 8) {
                  class10.addMenuEntry(Client.field1071, Client.field948 + " " + "->" + " " + class60.getColTags(16777215) + var4, 15, var1, var2, var3);
               }
            } else {
               for(var10 = 7; var10 >= 0; --var10) {
                  if(Client.playerOptions[var10] != null) {
                     short var11 = 0;
                     if(Client.playerOptions[var10].equalsIgnoreCase("Attack")) {
                        if(Client.field946 == class89.field1403) {
                           continue;
                        }

                        if(Client.field946 == class89.field1401 || class89.field1404 == Client.field946 && var0.combatLevel > AbstractByteBuffer.localPlayer.combatLevel) {
                           var11 = 2000;
                        }

                        if(AbstractByteBuffer.localPlayer.team != 0 && var0.team != 0) {
                           if(var0.team == AbstractByteBuffer.localPlayer.team) {
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
                     class10.addMenuEntry(Client.playerOptions[var10], class60.getColTags(16777215) + var4, var7, var1, var2, var3);
                  }
               }
            }

            for(var10 = 0; var10 < Client.menuOptionCount; ++var10) {
               if(Client.menuTypes[var10] == 23) {
                  Client.menuTargets[var10] = class60.getColTags(16777215) + var4;
                  break;
               }
            }

         }
      }
   }
}
