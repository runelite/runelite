import java.io.File;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ax")
public class class35 {
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Lax;"
   )
   static final class35 field511;
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Lax;"
   )
   static final class35 field506;
   @ObfuscatedName("o")
   static File field512;
   @ObfuscatedName("dd")
   @Export("host")
   static String host;
   @ObfuscatedName("fv")
   @Export("xteaKeys")
   static int[][] xteaKeys;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -2066952601
   )
   final int field507;

   static {
      field511 = new class35(0);
      field506 = new class35(1);
   }

   class35(int var1) {
      this.field507 = var1;
   }

   @ObfuscatedName("is")
   @ObfuscatedSignature(
      signature = "(Lbk;IIIB)V",
      garbageValue = "100"
   )
   static final void method477(Player var0, int var1, int var2, int var3) {
      if(class66.localPlayer != var0) {
         if(Client.menuOptionCount < 400) {
            String var4;
            if(var0.totalLevel == 0) {
               var4 = var0.actions[0] + var0.name + var0.actions[1] + method478(var0.combatLevel, class66.localPlayer.combatLevel) + " " + " (" + "level-" + var0.combatLevel + ")" + var0.actions[2];
            } else {
               var4 = var0.actions[0] + var0.name + var0.actions[1] + " " + " (" + "skill-" + var0.totalLevel + ")" + var0.actions[2];
            }

            int var5;
            if(Client.itemSelectionState == 1) {
               class215.addMenuEntry("Use", Client.field1068 + " " + "->" + " " + class24.getColTags(16777215) + var4, 14, var1, var2, var3);
            } else if(Client.spellSelected) {
               if((class90.field1421 & 8) == 8) {
                  class215.addMenuEntry(Client.field1072, Client.field1087 + " " + "->" + " " + class24.getColTags(16777215) + var4, 15, var1, var2, var3);
               }
            } else {
               for(var5 = 7; var5 >= 0; --var5) {
                  if(Client.playerOptions[var5] != null) {
                     short var6 = 0;
                     if(Client.playerOptions[var5].equalsIgnoreCase("Attack")) {
                        if(class89.field1406 == Client.field948) {
                           continue;
                        }

                        if(Client.field948 == class89.field1404 || Client.field948 == class89.field1405 && var0.combatLevel > class66.localPlayer.combatLevel) {
                           var6 = 2000;
                        }

                        if(class66.localPlayer.team != 0 && var0.team != 0) {
                           if(var0.team == class66.localPlayer.team) {
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
                     class215.addMenuEntry(Client.playerOptions[var5], class24.getColTags(16777215) + var4, var8, var1, var2, var3);
                  }
               }
            }

            for(var5 = 0; var5 < Client.menuOptionCount; ++var5) {
               if(Client.menuTypes[var5] == 23) {
                  Client.menuTargets[var5] = class24.getColTags(16777215) + var4;
                  break;
               }
            }

         }
      }
   }

   @ObfuscatedName("ip")
   @ObfuscatedSignature(
      signature = "(IIB)Ljava/lang/String;",
      garbageValue = "120"
   )
   static final String method478(int var0, int var1) {
      int var2 = var1 - var0;
      return var2 < -9?class24.getColTags(16711680):(var2 < -6?class24.getColTags(16723968):(var2 < -3?class24.getColTags(16740352):(var2 < 0?class24.getColTags(16756736):(var2 > 9?class24.getColTags(65280):(var2 > 6?class24.getColTags(4259584):(var2 > 3?class24.getColTags(8453888):(var2 > 0?class24.getColTags(12648192):class24.getColTags(16776960))))))));
   }
}
