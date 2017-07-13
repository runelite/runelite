import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cy")
@Implements("GraphicsObject")
public final class GraphicsObject extends Renderable {
   @ObfuscatedName("px")
   @ObfuscatedGetter(
      intValue = 164441549
   )
   static int field1354;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 1618697839
   )
   @Export("id")
   int id;
   @ObfuscatedName("p")
   @Export("finished")
   boolean finished;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -2068705883
   )
   int field1343;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -456674885
   )
   int field1345;
   @ObfuscatedName("l")
   Sequence field1349;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 898215773
   )
   @Export("level")
   int level;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 1441559041
   )
   @Export("x")
   int x;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 481633745
   )
   @Export("y")
   int y;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -1503897311
   )
   @Export("height")
   int height;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -1720004737
   )
   @Export("startCycle")
   int startCycle;

   GraphicsObject(int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      this.field1345 = 0;
      this.field1343 = 0;
      this.finished = false;
      this.id = var1;
      this.level = var2;
      this.x = var3;
      this.y = var4;
      this.height = var5;
      this.startCycle = var7 + var6;
      int var8 = InvType.getSpotAnimType(this.id).field3329;
      if(var8 != -1) {
         this.finished = false;
         this.field1349 = class112.getAnimation(var8);
      } else {
         this.finished = true;
      }

   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(B)LModel;",
      garbageValue = "19"
   )
   protected final Model getModel() {
      Spotanim var1 = InvType.getSpotAnimType(this.id);
      Model var2;
      if(!this.finished) {
         var2 = var1.method4283(this.field1345);
      } else {
         var2 = var1.method4283(-1);
      }

      return var2 == null?null:var2;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-2049022253"
   )
   final void method1645(int var1) {
      if(!this.finished) {
         this.field1343 += var1;

         while(this.field1343 > this.field1349.frameLenghts[this.field1345]) {
            this.field1343 -= this.field1349.frameLenghts[this.field1345];
            ++this.field1345;
            if(this.field1345 >= this.field1349.frameIDs.length) {
               this.finished = true;
               break;
            }
         }

      }
   }

   @ObfuscatedName("hs")
   @ObfuscatedSignature(
      signature = "(LPlayer;IIII)V",
      garbageValue = "-2036841632"
   )
   static final void method1644(Player var0, int var1, int var2, int var3) {
      if(Script.localPlayer != var0) {
         if(Client.menuOptionCount < 400) {
            String var4;
            int var7;
            if(var0.totalLevel == 0) {
               String var5 = var0.actions[0] + var0.name + var0.actions[1];
               var7 = var0.combatLevel;
               int var8 = Script.localPlayer.combatLevel;
               int var9 = var8 - var7;
               String var6;
               if(var9 < -9) {
                  var6 = class46.getColTags(16711680);
               } else if(var9 < -6) {
                  var6 = class46.getColTags(16723968);
               } else if(var9 < -3) {
                  var6 = class46.getColTags(16740352);
               } else if(var9 < 0) {
                  var6 = class46.getColTags(16756736);
               } else if(var9 > 9) {
                  var6 = class46.getColTags('\uff00');
               } else if(var9 > 6) {
                  var6 = class46.getColTags(4259584);
               } else if(var9 > 3) {
                  var6 = class46.getColTags(8453888);
               } else if(var9 > 0) {
                  var6 = class46.getColTags(12648192);
               } else {
                  var6 = class46.getColTags(16776960);
               }

               var4 = var5 + var6 + " " + " (" + "level-" + var0.combatLevel + ")" + var0.actions[2];
            } else {
               var4 = var0.actions[0] + var0.name + var0.actions[1] + " " + " (" + "skill-" + var0.totalLevel + ")" + var0.actions[2];
            }

            int var10;
            if(Client.itemSelectionState == 1) {
               class37.addMenuEntry("Use", Client.selectedItemName + " " + "->" + " " + class46.getColTags(16777215) + var4, 14, var1, var2, var3);
            } else if(Client.spellSelected) {
               if((class116.field1676 & 8) == 8) {
                  class37.addMenuEntry(Client.field1064, Client.field1019 + " " + "->" + " " + class46.getColTags(16777215) + var4, 15, var1, var2, var3);
               }
            } else {
               for(var10 = 7; var10 >= 0; --var10) {
                  if(Client.playerOptions[var10] != null) {
                     short var11 = 0;
                     if(Client.playerOptions[var10].equalsIgnoreCase("Attack")) {
                        if(Client.field931 == class91.field1409) {
                           continue;
                        }

                        if(class91.field1416 == Client.field931 || class91.field1410 == Client.field931 && var0.combatLevel > Script.localPlayer.combatLevel) {
                           var11 = 2000;
                        }

                        if(Script.localPlayer.team != 0 && var0.team != 0) {
                           if(var0.team == Script.localPlayer.team) {
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
                     class37.addMenuEntry(Client.playerOptions[var10], class46.getColTags(16777215) + var4, var7, var1, var2, var3);
                  }
               }
            }

            for(var10 = 0; var10 < Client.menuOptionCount; ++var10) {
               if(Client.menuTypes[var10] == 23) {
                  Client.menuTargets[var10] = class46.getColTags(16777215) + var4;
                  break;
               }
            }

         }
      }
   }
}
