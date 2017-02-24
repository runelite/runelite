import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cp")
@Implements("FaceNormal")
public class FaceNormal {
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -1294417811
   )
   @Export("y")
   int y;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -2098924619
   )
   @Export("x")
   int x;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 558708417
   )
   @Export("z")
   int z;

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Lclass159;S)I",
      garbageValue = "3612"
   )
   static int method1955(class159 var0) {
      int var1 = var0.method3095(2);
      int var2;
      if(var1 == 0) {
         var2 = 0;
      } else if(var1 == 1) {
         var2 = var0.method3095(5);
      } else if(var1 == 2) {
         var2 = var0.method3095(8);
      } else {
         var2 = var0.method3095(11);
      }

      return var2;
   }

   @ObfuscatedName("cb")
   @ObfuscatedSignature(
      signature = "(LPlayer;IIIS)V",
      garbageValue = "10266"
   )
   static final void method1956(Player var0, int var1, int var2, int var3) {
      if(class36.localPlayer != var0) {
         if(Client.menuOptionCount < 400) {
            String var4;
            int var7;
            if(var0.field256 == 0) {
               String var5 = var0.actions[0] + var0.name + var0.actions[1];
               var7 = var0.combatLevel;
               int var8 = class36.localPlayer.combatLevel;
               int var9 = var8 - var7;
               String var6;
               if(var9 < -9) {
                  var6 = class18.method199(16711680);
               } else if(var9 < -6) {
                  var6 = class18.method199(16723968);
               } else if(var9 < -3) {
                  var6 = class18.method199(16740352);
               } else if(var9 < 0) {
                  var6 = class18.method199(16756736);
               } else if(var9 > 9) {
                  var6 = class18.method199('\uff00');
               } else if(var9 > 6) {
                  var6 = class18.method199(4259584);
               } else if(var9 > 3) {
                  var6 = class18.method199(8453888);
               } else if(var9 > 0) {
                  var6 = class18.method199(12648192);
               } else {
                  var6 = class18.method199(16776960);
               }

               var4 = var5 + var6 + " " + " (" + "level-" + var0.combatLevel + ")" + var0.actions[2];
            } else {
               var4 = var0.actions[0] + var0.name + var0.actions[1] + " " + " (" + "skill-" + var0.field256 + ")" + var0.actions[2];
            }

            int var10;
            if(Client.field458 == 1) {
               class115.addMenuEntry("Use", Client.field459 + " " + "->" + " " + class18.method199(16777215) + var4, 14, var1, var2, var3);
            } else if(Client.field511) {
               if((class31.field739 & 8) == 8) {
                  class115.addMenuEntry(Client.field463, Client.field380 + " " + "->" + " " + class18.method199(16777215) + var4, 15, var1, var2, var3);
               }
            } else {
               for(var10 = 7; var10 >= 0; --var10) {
                  if(Client.playerOptions[var10] != null) {
                     short var11 = 0;
                     if(Client.playerOptions[var10].equalsIgnoreCase("Attack")) {
                        if(class40.field836 == Client.field331) {
                           continue;
                        }

                        if(Client.field331 == class40.field829 || class40.field831 == Client.field331 && var0.combatLevel > class36.localPlayer.combatLevel) {
                           var11 = 2000;
                        }

                        if(class36.localPlayer.team != 0 && var0.team != 0) {
                           if(var0.team == class36.localPlayer.team) {
                              var11 = 2000;
                           } else {
                              var11 = 0;
                           }
                        }
                     } else if(Client.playerOptionsPriority[var10]) {
                        var11 = 2000;
                     }

                     boolean var12 = false;
                     var7 = var11 + Client.field430[var10];
                     class115.addMenuEntry(Client.playerOptions[var10], class18.method199(16777215) + var4, var7, var1, var2, var3);
                  }
               }
            }

            for(var10 = 0; var10 < Client.menuOptionCount; ++var10) {
               if(Client.menuTypes[var10] == 23) {
                  Client.menuTargets[var10] = class18.method199(16777215) + var4;
                  break;
               }
            }

         }
      }
   }
}
