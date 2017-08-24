import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bu")
public class class73 extends class164 {
   @ObfuscatedName("et")
   @ObfuscatedSignature(
      signature = "Ljm;"
   )
   static Font field897;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 1429293879
   )
   @Export("sampleRate")
   public static int sampleRate;
   @ObfuscatedName("bi")
   @ObfuscatedSignature(
      signature = "[Ljx;"
   )
   static IndexedSprite[] field895;
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Len;"
   )
   @Export("listFetcher")
   static class149 listFetcher;

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(IIILfh;I)Z",
      garbageValue = "-982142966"
   )
   protected boolean vmethod3145(int var1, int var2, int var3, CollisionData var4) {
      return var2 == super.field2314 && var3 == super.field2315;
   }

   @ObfuscatedName("hu")
   @ObfuscatedSignature(
      signature = "(Lbo;IIII)V",
      garbageValue = "-1738132245"
   )
   static final void method1144(Player var0, int var1, int var2, int var3) {
      if(Player.localPlayer != var0) {
         if(Client.menuOptionCount < 400) {
            String var4;
            if(var0.totalLevel == 0) {
               var4 = var0.actions[0] + var0.name + var0.actions[1] + Client.method1514(var0.combatLevel, Player.localPlayer.combatLevel) + " " + " (" + "level-" + var0.combatLevel + ")" + var0.actions[2];
            } else {
               var4 = var0.actions[0] + var0.name + var0.actions[1] + " " + " (" + "skill-" + var0.totalLevel + ")" + var0.actions[2];
            }

            int var5;
            if(Client.itemSelectionState == 1) {
               class36.addMenuEntry("Use", Client.field1085 + " " + "->" + " " + Friend.getColTags(16777215) + var4, 14, var1, var2, var3);
            } else if(Client.spellSelected) {
               if((class67.field845 & 8) == 8) {
                  class36.addMenuEntry(Client.field1089, Client.field1090 + " " + "->" + " " + Friend.getColTags(16777215) + var4, 15, var1, var2, var3);
               }
            } else {
               for(var5 = 7; var5 >= 0; --var5) {
                  if(Client.playerOptions[var5] != null) {
                     short var6 = 0;
                     if(Client.playerOptions[var5].equalsIgnoreCase("Attack")) {
                        if(class90.field1426 == Client.field967) {
                           continue;
                        }

                        if(Client.field967 == class90.field1424 || class90.field1431 == Client.field967 && var0.combatLevel > Player.localPlayer.combatLevel) {
                           var6 = 2000;
                        }

                        if(Player.localPlayer.team != 0 && var0.team != 0) {
                           if(var0.team == Player.localPlayer.team) {
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
                     class36.addMenuEntry(Client.playerOptions[var5], Friend.getColTags(16777215) + var4, var8, var1, var2, var3);
                  }
               }
            }

            for(var5 = 0; var5 < Client.menuOptionCount; ++var5) {
               if(Client.menuTypes[var5] == 23) {
                  Client.menuTargets[var5] = Friend.getColTags(16777215) + var4;
                  break;
               }
            }

         }
      }
   }
}
