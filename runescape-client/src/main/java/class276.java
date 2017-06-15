import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("js")
public class class276 {
   @ObfuscatedName("e")
   static final class276 field3732;
   @ObfuscatedName("p")
   static final class276 field3733;
   @ObfuscatedName("m")
   public static final class276 field3734;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 659362583
   )
   public final int field3735;

   static {
      field3733 = new class276(0);
      field3734 = new class276(1);
      field3732 = new class276(2);
   }

   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "0"
   )
   class276(int var1) {
      this.field3735 = var1;
   }

   @ObfuscatedName("ih")
   @ObfuscatedSignature(
      signature = "(LWidget;IIII)V",
      garbageValue = "-813520175"
   )
   static final void method4796(Widget var0, int var1, int var2, int var3) {
      class69.method1035();
      class210 var4 = var0.method3888(false);
      if(var4 != null) {
         Rasterizer2D.method4833(var1, var2, var1 + var4.field2607, var2 + var4.field2611);
         if(Client.field1087 != 2 && Client.field1087 != 5) {
            int var5 = Client.mapAngle + Client.mapScale & 2047;
            int var6 = class20.localPlayer.x / 32 + 48;
            int var7 = 464 - class20.localPlayer.y / 32;
            Actor.field1268.method4946(var1, var2, var4.field2607, var4.field2611, var6, var7, var5, Client.mapScaleDelta + 256, var4.field2609, var4.field2608);

            int var8;
            int var9;
            int var10;
            for(var8 = 0; var8 < Client.field1134; ++var8) {
               var9 = Client.field1180[var8] * 4 + 2 - class20.localPlayer.x / 32;
               var10 = Client.field900[var8] * 4 + 2 - class20.localPlayer.y / 32;
               class82.method1523(var1, var2, var9, var10, Client.field1137[var8], var4);
            }

            int var11;
            int var12;
            for(var8 = 0; var8 < 104; ++var8) {
               for(var9 = 0; var9 < 104; ++var9) {
                  Deque var17 = Client.groundItemDeque[Player.plane][var8][var9];
                  if(var17 != null) {
                     var11 = var8 * 4 + 2 - class20.localPlayer.x / 32;
                     var12 = var9 * 4 + 2 - class20.localPlayer.y / 32;
                     class82.method1523(var1, var2, var11, var12, class22.field360[0], var4);
                  }
               }
            }

            for(var8 = 0; var8 < Client.field930; ++var8) {
               NPC var18 = Client.cachedNPCs[Client.npcIndices[var8]];
               if(var18 != null && var18.vmethod1593()) {
                  NPCComposition var21 = var18.composition;
                  if(var21 != null && var21.configs != null) {
                     var21 = var21.method4525();
                  }

                  if(var21 != null && var21.isMinimapVisible && var21.field3586) {
                     var11 = var18.x / 32 - class20.localPlayer.x / 32;
                     var12 = var18.y / 32 - class20.localPlayer.y / 32;
                     class82.method1523(var1, var2, var11, var12, class22.field360[1], var4);
                  }
               }
            }

            var8 = class96.field1487;
            int[] var22 = class96.field1491;

            for(var10 = 0; var10 < var8; ++var10) {
               Player var19 = Client.cachedPlayers[var22[var10]];
               if(var19 != null && var19.vmethod1593() && !var19.hidden && class20.localPlayer != var19) {
                  var12 = var19.x / 32 - class20.localPlayer.x / 32;
                  int var13 = var19.y / 32 - class20.localPlayer.y / 32;
                  boolean var14 = false;
                  if(class162.method2946(var19.name, true)) {
                     var14 = true;
                  }

                  boolean var15 = false;

                  for(int var16 = 0; var16 < XGrandExchangeOffer.clanChatCount; ++var16) {
                     if(var19.name.equals(class177.clanMembers[var16].username)) {
                        var15 = true;
                        break;
                     }
                  }

                  boolean var20 = false;
                  if(class20.localPlayer.team != 0 && var19.team != 0 && var19.team == class20.localPlayer.team) {
                     var20 = true;
                  }

                  if(var14) {
                     class82.method1523(var1, var2, var12, var13, class22.field360[3], var4);
                  } else if(var20) {
                     class82.method1523(var1, var2, var12, var13, class22.field360[4], var4);
                  } else if(var15) {
                     class82.method1523(var1, var2, var12, var13, class22.field360[5], var4);
                  } else {
                     class82.method1523(var1, var2, var12, var13, class22.field360[2], var4);
                  }
               }
            }

            if(Client.field920 != 0 && Client.gameCycle % 20 < 10) {
               if(Client.field920 == 1 && Client.field1133 >= 0 && Client.field1133 < Client.cachedNPCs.length) {
                  NPC var23 = Client.cachedNPCs[Client.field1133];
                  if(var23 != null) {
                     var11 = var23.x / 32 - class20.localPlayer.x / 32;
                     var12 = var23.y / 32 - class20.localPlayer.y / 32;
                     class43.method594(var1, var2, var11, var12, class20.field346[1], var4);
                  }
               }

               if(Client.field920 == 2) {
                  var10 = Client.hintArrowX * 4 - class19.baseX * 4 + 2 - class20.localPlayer.x / 32;
                  var11 = Client.hintArrowY * 4 - class21.baseY * 4 + 2 - class20.localPlayer.y / 32;
                  class43.method594(var1, var2, var10, var11, class20.field346[1], var4);
               }

               if(Client.field920 == 10 && Client.field922 >= 0 && Client.field922 < Client.cachedPlayers.length) {
                  Player var24 = Client.cachedPlayers[Client.field922];
                  if(var24 != null) {
                     var11 = var24.x / 32 - class20.localPlayer.x / 32;
                     var12 = var24.y / 32 - class20.localPlayer.y / 32;
                     class43.method594(var1, var2, var11, var12, class20.field346[1], var4);
                  }
               }
            }

            if(Client.detinationX != 0) {
               var10 = Client.detinationX * 4 + 2 - class20.localPlayer.x / 32;
               var11 = Client.destinationY * 4 + 2 - class20.localPlayer.y / 32;
               class82.method1523(var1, var2, var10, var11, class20.field346[0], var4);
            }

            if(!class20.localPlayer.hidden) {
               Rasterizer2D.method4826(var1 + var4.field2607 / 2 - 1, var4.field2611 / 2 + var2 - 1, 3, 3, 16777215);
            }
         } else {
            Rasterizer2D.method4840(var1, var2, 0, var4.field2609, var4.field2608);
         }

         Client.field1112[var3] = true;
      }
   }
}
