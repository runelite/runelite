import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ar")
public class class49 extends Renderable {
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 1583239421
   )
   int field943;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -1989050061
   )
   int field944;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 1995785131
   )
   int field945;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 2037321837
   )
   int field946;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 623300341
   )
   int field947;
   @ObfuscatedName("nw")
   @ObfuscatedGetter(
      intValue = 1800312485
   )
   static int field948;
   @ObfuscatedName("c")
   Sequence field949;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -298499347
   )
   int field950;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -775562589
   )
   int field951;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 1692906395
   )
   int field952;
   @ObfuscatedName("qd")
   @ObfuscatedGetter(
      intValue = -2085977339
   )
   protected static int field953;

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)LModel;",
      garbageValue = "1672156994"
   )
   protected final Model getModel() {
      if(this.field949 != null) {
         int var12 = Client.gameCycle - this.field951;
         if(var12 > 100 && this.field949.frameStep > 0) {
            var12 = 100;
         }

         label63: {
            do {
               do {
                  if(var12 <= this.field949.frameLenghts[this.field952]) {
                     break label63;
                  }

                  var12 -= this.field949.frameLenghts[this.field952];
                  ++this.field952;
               } while(this.field952 < this.field949.frameIDs.length);

               this.field952 -= this.field949.frameStep;
            } while(this.field952 >= 0 && this.field952 < this.field949.frameIDs.length);

            this.field949 = null;
         }

         this.field951 = Client.gameCycle - var12;
      }

      ObjectComposition var1 = class15.getObjectDefinition(this.field950);
      if(null != var1.impostorIds) {
         var1 = var1.getImpostor();
      }

      if(null == var1) {
         return null;
      } else {
         int var2;
         int var3;
         if(this.field943 != 1 && this.field943 != 3) {
            var2 = var1.field2903;
            var3 = var1.field2907;
         } else {
            var2 = var1.field2907;
            var3 = var1.field2903;
         }

         int var4 = (var2 >> 1) + this.field947;
         int var5 = this.field947 + (var2 + 1 >> 1);
         int var6 = (var3 >> 1) + this.field946;
         int var7 = this.field946 + (var3 + 1 >> 1);
         int[][] var8 = class11.tileHeights[this.field945];
         int var9 = var8[var5][var7] + var8[var4][var7] + var8[var5][var6] + var8[var4][var6] >> 2;
         int var10 = (var2 << 6) + (this.field947 << 7);
         int var11 = (var3 << 6) + (this.field946 << 7);
         return var1.method3657(this.field944, this.field943, var8, var10, var9, var11, this.field949, this.field952);
      }
   }

   class49(int var1, int var2, int var3, int var4, int var5, int var6, int var7, boolean var8, Renderable var9) {
      this.field950 = var1;
      this.field944 = var2;
      this.field943 = var3;
      this.field945 = var4;
      this.field947 = var5;
      this.field946 = var6;
      if(var7 != -1) {
         this.field949 = class9.getAnimation(var7);
         this.field952 = 0;
         this.field951 = Client.gameCycle - 1;
         if(this.field949.replyMode == 0 && null != var9 && var9 instanceof class49) {
            class49 var10 = (class49)var9;
            if(this.field949 == var10.field949) {
               this.field952 = var10.field952;
               this.field951 = var10.field951;
               return;
            }
         }

         if(var8 && this.field949.frameStep != -1) {
            this.field952 = (int)(Math.random() * (double)this.field949.frameIDs.length);
            this.field951 -= (int)(Math.random() * (double)this.field949.frameLenghts[this.field952]);
         }
      }

   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(IS)V",
      garbageValue = "-26996"
   )
   static void method898(int var0) {
      XItemContainer var1 = (XItemContainer)XItemContainer.itemContainers.method2405((long)var0);
      if(var1 != null) {
         for(int var2 = 0; var2 < var1.itemIds.length; ++var2) {
            var1.itemIds[var2] = -1;
            var1.stackSizes[var2] = 0;
         }

      }
   }

   @ObfuscatedName("cb")
   @ObfuscatedSignature(
      signature = "(LPlayer;IIII)V",
      garbageValue = "2053077184"
   )
   static final void method899(Player var0, int var1, int var2, int var3) {
      if(var0 != class40.localPlayer) {
         if(Client.menuOptionCount < 400) {
            String var4;
            if(var0.field249 == 0) {
               var4 = var0.actions[0] + var0.name + var0.actions[1] + class112.method2146(var0.combatLevel, class40.localPlayer.combatLevel) + " " + " (" + "level-" + var0.combatLevel + ")" + var0.actions[2];
            } else {
               var4 = var0.actions[0] + var0.name + var0.actions[1] + " " + " (" + "skill-" + var0.field249 + ")" + var0.actions[2];
            }

            int var5;
            if(Client.field438 == 1) {
               class166.addMenuEntry("Use", Client.field371 + " " + "->" + " " + class13.method182(16777215) + var4, 14, var1, var2, var3);
            } else if(Client.field440) {
               if((class138.field1920 & 8) == 8) {
                  class166.addMenuEntry(Client.field297, Client.field444 + " " + "->" + " " + class13.method182(16777215) + var4, 15, var1, var2, var3);
               }
            } else {
               for(var5 = 7; var5 >= 0; --var5) {
                  if(Client.field414[var5] != null) {
                     short var6 = 0;
                     if(Client.field414[var5].equalsIgnoreCase("Attack")) {
                        if(Client.field310 == class40.field806) {
                           continue;
                        }

                        if(Client.field310 == class40.field811 || class40.field814 == Client.field310 && var0.combatLevel > class40.localPlayer.combatLevel) {
                           var6 = 2000;
                        }

                        if(class40.localPlayer.team != 0 && var0.team != 0) {
                           if(class40.localPlayer.team == var0.team) {
                              var6 = 2000;
                           } else {
                              var6 = 0;
                           }
                        }
                     } else if(Client.field434[var5]) {
                        var6 = 2000;
                     }

                     boolean var7 = false;
                     int var8 = var6 + Client.field542[var5];
                     class166.addMenuEntry(Client.field414[var5], class13.method182(16777215) + var4, var8, var1, var2, var3);
                  }
               }
            }

            for(var5 = 0; var5 < Client.menuOptionCount; ++var5) {
               if(Client.menuTypes[var5] == 23) {
                  Client.menuTargets[var5] = class13.method182(16777215) + var4;
                  break;
               }
            }

         }
      }
   }
}
