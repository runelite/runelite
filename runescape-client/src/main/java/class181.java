import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fw")
public class class181 {
   @ObfuscatedName("z")
   static boolean field2441;

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;IZB)I",
      garbageValue = "-51"
   )
   @Export("parseInt")
   public static int parseInt(CharSequence var0, int var1, boolean var2) {
      if(var1 >= 2 && var1 <= 36) {
         boolean var3 = false;
         boolean var4 = false;
         int var5 = 0;
         int var6 = var0.length();

         for(int var7 = 0; var7 < var6; ++var7) {
            char var8 = var0.charAt(var7);
            if(var7 == 0) {
               if(var8 == 45) {
                  var3 = true;
                  continue;
               }

               if(var8 == 43) {
                  continue;
               }
            }

            int var10;
            if(var8 >= 48 && var8 <= 57) {
               var10 = var8 - 48;
            } else if(var8 >= 65 && var8 <= 90) {
               var10 = var8 - 55;
            } else {
               if(var8 < 97 || var8 > 122) {
                  throw new NumberFormatException();
               }

               var10 = var8 - 87;
            }

            if(var10 >= var1) {
               throw new NumberFormatException();
            }

            if(var3) {
               var10 = -var10;
            }

            int var9 = var1 * var5 + var10;
            if(var9 / var1 != var5) {
               throw new NumberFormatException();
            }

            var5 = var9;
            var4 = true;
         }

         if(!var4) {
            throw new NumberFormatException();
         } else {
            return var5;
         }
      } else {
         throw new IllegalArgumentException("");
      }
   }

   @ObfuscatedName("hw")
   @ObfuscatedSignature(
      signature = "(LPlayer;IIII)V",
      garbageValue = "-1833465482"
   )
   static final void method3429(Player var0, int var1, int var2, int var3) {
      if(XItemContainer.localPlayer != var0) {
         if(Client.menuOptionCount < 400) {
            String var4;
            int var7;
            if(var0.totalLevel == 0) {
               String var5 = var0.actions[0] + var0.name + var0.actions[1];
               var7 = var0.combatLevel;
               int var8 = XItemContainer.localPlayer.combatLevel;
               int var9 = var8 - var7;
               String var6;
               if(var9 < -9) {
                  var6 = class220.getColTags(16711680);
               } else if(var9 < -6) {
                  var6 = class220.getColTags(16723968);
               } else if(var9 < -3) {
                  var6 = class220.getColTags(16740352);
               } else if(var9 < 0) {
                  var6 = class220.getColTags(16756736);
               } else if(var9 > 9) {
                  var6 = class220.getColTags('\uff00');
               } else if(var9 > 6) {
                  var6 = class220.getColTags(4259584);
               } else if(var9 > 3) {
                  var6 = class220.getColTags(8453888);
               } else if(var9 > 0) {
                  var6 = class220.getColTags(12648192);
               } else {
                  var6 = class220.getColTags(16776960);
               }

               var4 = var5 + var6 + " " + " (" + "level-" + var0.combatLevel + ")" + var0.actions[2];
            } else {
               var4 = var0.actions[0] + var0.name + var0.actions[1] + " " + " (" + "skill-" + var0.totalLevel + ")" + var0.actions[2];
            }

            int var10;
            if(Client.itemSelectionState == 1) {
               class175.addMenuEntry("Use", Client.selectedItemName + " " + "->" + " " + class220.getColTags(16777215) + var4, 14, var1, var2, var3);
            } else if(Client.spellSelected) {
               if((WorldMapType3.spellTargetFlags & 8) == 8) {
                  class175.addMenuEntry(Client.field1078, Client.field1159 + " " + "->" + " " + class220.getColTags(16777215) + var4, 15, var1, var2, var3);
               }
            } else {
               for(var10 = 7; var10 >= 0; --var10) {
                  if(Client.playerOptions[var10] != null) {
                     short var11 = 0;
                     if(Client.playerOptions[var10].equalsIgnoreCase("Attack")) {
                        if(Client.field1012 == class91.field1441) {
                           continue;
                        }

                        if(Client.field1012 == class91.field1440 || class91.field1442 == Client.field1012 && var0.combatLevel > XItemContainer.localPlayer.combatLevel) {
                           var11 = 2000;
                        }

                        if(XItemContainer.localPlayer.team != 0 && var0.team != 0) {
                           if(var0.team == XItemContainer.localPlayer.team) {
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
                     class175.addMenuEntry(Client.playerOptions[var10], class220.getColTags(16777215) + var4, var7, var1, var2, var3);
                  }
               }
            }

            for(var10 = 0; var10 < Client.menuOptionCount; ++var10) {
               if(Client.menuTypes[var10] == 23) {
                  Client.menuTargets[var10] = class220.getColTags(16777215) + var4;
                  break;
               }
            }

         }
      }
   }
}
