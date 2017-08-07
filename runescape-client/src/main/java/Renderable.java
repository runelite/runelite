import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("eg")
@Implements("Renderable")
public abstract class Renderable extends CacheableNode {
   @ObfuscatedName("ch")
   @ObfuscatedGetter(
      intValue = -2010156075
   )
   @Export("modelHeight")
   public int modelHeight;

   protected Renderable() {
      this.modelHeight = 1000;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)Lew;",
      garbageValue = "-2113451941"
   )
   @Export("getModel")
   protected Model getModel() {
      return null;
   }

   @ObfuscatedName("cg")
   @Export("draw")
   void draw(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9) {
      Model var10 = this.getModel();
      if(var10 != null) {
         this.modelHeight = var10.modelHeight;
         var10.draw(var1, var2, var3, var4, var5, var6, var7, var8, var9);
      }

   }

   @ObfuscatedName("hx")
   @ObfuscatedSignature(
      signature = "(Lbk;IIII)V",
      garbageValue = "-1950339678"
   )
   static final void method2898(Player var0, int var1, int var2, int var3) {
      if(class54.localPlayer != var0) {
         if(Client.menuOptionCount < 400) {
            String var4;
            int var7;
            if(var0.totalLevel == 0) {
               String var5 = var0.actions[0] + var0.name + var0.actions[1];
               var7 = var0.combatLevel;
               int var8 = class54.localPlayer.combatLevel;
               int var9 = var8 - var7;
               String var6;
               if(var9 < -9) {
                  var6 = RSSocket.getColTags(16711680);
               } else if(var9 < -6) {
                  var6 = RSSocket.getColTags(16723968);
               } else if(var9 < -3) {
                  var6 = RSSocket.getColTags(16740352);
               } else if(var9 < 0) {
                  var6 = RSSocket.getColTags(16756736);
               } else if(var9 > 9) {
                  var6 = RSSocket.getColTags('\uff00');
               } else if(var9 > 6) {
                  var6 = RSSocket.getColTags(4259584);
               } else if(var9 > 3) {
                  var6 = RSSocket.getColTags(8453888);
               } else if(var9 > 0) {
                  var6 = RSSocket.getColTags(12648192);
               } else {
                  var6 = RSSocket.getColTags(16776960);
               }

               var4 = var5 + var6 + " " + " (" + "level-" + var0.combatLevel + ")" + var0.actions[2];
            } else {
               var4 = var0.actions[0] + var0.name + var0.actions[1] + " " + " (" + "skill-" + var0.totalLevel + ")" + var0.actions[2];
            }

            int var10;
            if(Client.itemSelectionState == 1) {
               class165.addMenuEntry("Use", Client.field1056 + " " + "->" + " " + RSSocket.getColTags(16777215) + var4, 14, var1, var2, var3);
            } else if(Client.spellSelected) {
               if((class1.field4 & 8) == 8) {
                  class165.addMenuEntry(Client.field997, Client.field1061 + " " + "->" + " " + RSSocket.getColTags(16777215) + var4, 15, var1, var2, var3);
               }
            } else {
               for(var10 = 7; var10 >= 0; --var10) {
                  if(Client.playerOptions[var10] != null) {
                     short var11 = 0;
                     if(Client.playerOptions[var10].equalsIgnoreCase("Attack")) {
                        if(Client.field940 == class92.field1410) {
                           continue;
                        }

                        if(class92.field1417 == Client.field940 || Client.field940 == class92.field1408 && var0.combatLevel > class54.localPlayer.combatLevel) {
                           var11 = 2000;
                        }

                        if(class54.localPlayer.team != 0 && var0.team != 0) {
                           if(var0.team == class54.localPlayer.team) {
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
                     class165.addMenuEntry(Client.playerOptions[var10], RSSocket.getColTags(16777215) + var4, var7, var1, var2, var3);
                  }
               }
            }

            for(var10 = 0; var10 < Client.menuOptionCount; ++var10) {
               if(Client.menuTypes[var10] == 23) {
                  Client.menuTargets[var10] = RSSocket.getColTags(16777215) + var4;
                  break;
               }
            }

         }
      }
   }
}
