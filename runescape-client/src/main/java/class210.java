import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hx")
public class class210 extends CacheableNode {
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 1222527657
   )
   public final int field2605;
   @ObfuscatedName("i")
   public final int[] field2606;
   @ObfuscatedName("j")
   public final int[] field2607;
   @ObfuscatedName("o")
   public static Track1 field2608;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 1486498301
   )
   public final int field2610;

   class210(int var1, int var2, int[] var3, int[] var4, int var5) {
      this.field2610 = var1;
      this.field2605 = var2;
      this.field2606 = var3;
      this.field2607 = var4;
   }

   @ObfuscatedName("ew")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1007010317"
   )
   static final void method3941() {
      if(Client.field966 > 0) {
         class20.method166();
      } else {
         class3.setGameState(40);
         Frames.field2149 = class8.rssocket;
         class8.rssocket = null;
      }
   }

   @ObfuscatedName("hg")
   @ObfuscatedSignature(
      signature = "(LPlayer;IIII)V",
      garbageValue = "2120039639"
   )
   static final void method3942(Player var0, int var1, int var2, int var3) {
      if(class168.localPlayer != var0) {
         if(Client.menuOptionCount < 400) {
            String var4;
            int var7;
            if(var0.totalLevel == 0) {
               String var5 = var0.actions[0] + var0.name + var0.actions[1];
               var7 = var0.combatLevel;
               int var8 = class168.localPlayer.combatLevel;
               int var9 = var8 - var7;
               String var10;
               if(var9 < -9) {
                  var10 = class60.method996(16711680);
               } else if(var9 < -6) {
                  var10 = class60.method996(16723968);
               } else if(var9 < -3) {
                  var10 = class60.method996(16740352);
               } else if(var9 < 0) {
                  var10 = class60.method996(16756736);
               } else if(var9 > 9) {
                  var10 = class60.method996('\uff00');
               } else if(var9 > 6) {
                  var10 = class60.method996(4259584);
               } else if(var9 > 3) {
                  var10 = class60.method996(8453888);
               } else if(var9 > 0) {
                  var10 = class60.method996(12648192);
               } else {
                  var10 = class60.method996(16776960);
               }

               var4 = var5 + var10 + " " + " (" + "level-" + var0.combatLevel + ")" + var0.actions[2];
            } else {
               var4 = var0.actions[0] + var0.name + var0.actions[1] + " " + " (" + "skill-" + var0.totalLevel + ")" + var0.actions[2];
            }

            int var11;
            if(Client.field1068 == 1) {
               Enum.addMenuEntry("Use", Client.field988 + " " + "->" + " " + class60.method996(16777215) + var4, 14, var1, var2, var3);
            } else if(Client.field1071) {
               if((class221.field2836 & 8) == 8) {
                  Enum.addMenuEntry(Client.field1074, Client.field1075 + " " + "->" + " " + class60.method996(16777215) + var4, 15, var1, var2, var3);
               }
            } else {
               for(var11 = 7; var11 >= 0; --var11) {
                  if(Client.playerOptions[var11] != null) {
                     short var6 = 0;
                     if(Client.playerOptions[var11].equalsIgnoreCase("Attack")) {
                        if(Client.field998 == class91.field1414) {
                           continue;
                        }

                        if(class91.field1410 == Client.field998 || class91.field1412 == Client.field998 && var0.combatLevel > class168.localPlayer.combatLevel) {
                           var6 = 2000;
                        }

                        if(class168.localPlayer.team != 0 && var0.team != 0) {
                           if(var0.team == class168.localPlayer.team) {
                              var6 = 2000;
                           } else {
                              var6 = 0;
                           }
                        }
                     } else if(Client.playerOptionsPriorities[var11]) {
                        var6 = 2000;
                     }

                     boolean var12 = false;
                     var7 = Client.playerMenuTypes[var11] + var6;
                     Enum.addMenuEntry(Client.playerOptions[var11], class60.method996(16777215) + var4, var7, var1, var2, var3);
                  }
               }
            }

            for(var11 = 0; var11 < Client.menuOptionCount; ++var11) {
               if(Client.menuTypes[var11] == 23) {
                  Client.menuTargets[var11] = class60.method996(16777215) + var4;
                  break;
               }
            }

         }
      }
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(III)Z",
      garbageValue = "-1822951817"
   )
   public boolean method3943(int var1, int var2) {
      if(var2 >= 0 && var2 < this.field2607.length) {
         int var3 = this.field2607[var2];
         if(var1 >= var3 && var1 <= var3 + this.field2606[var2]) {
            return true;
         }
      }

      return false;
   }
}
