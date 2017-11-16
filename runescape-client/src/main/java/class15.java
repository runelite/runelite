import java.util.Comparator;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("m")
final class class15 implements Comparator {
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Lj;Lj;I)I",
      garbageValue = "-1715102065"
   )
   int method93(class14 var1, class14 var2) {
      return var1.field276.totalQuantity < var2.field276.totalQuantity?-1:(var2.field276.totalQuantity == var1.field276.totalQuantity?0:1);
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   public int compare(Object var1, Object var2) {
      return this.method93((class14)var1, (class14)var2);
   }

   @ObfuscatedName("jj")
   @ObfuscatedSignature(
      signature = "(Lhx;IIII)V",
      garbageValue = "821771346"
   )
   static final void method97(Widget var0, int var1, int var2, int var3) {
      class90.method1683();
      class217 var4 = var0.method4027(false);
      if(var4 != null) {
         Rasterizer2D.setDrawRegion(var1, var2, var4.field2673 + var1, var2 + var4.field2672);
         if(Client.field1108 != 2 && Client.field1108 != 5) {
            int var5 = Client.mapAngle & 2047;
            int var6 = class275.localPlayer.x / 32 + 48;
            int var7 = 464 - class275.localPlayer.y / 32;
            GraphicsObject.field1280.method5125(var1, var2, var4.field2673, var4.field2672, var6, var7, var5, 256, var4.field2675, var4.field2674);

            int var8;
            int var9;
            int var10;
            for(var8 = 0; var8 < Client.field1075; ++var8) {
               var9 = Client.field1060[var8] * 4 + 2 - class275.localPlayer.x / 32;
               var10 = Client.field891[var8] * 4 + 2 - class275.localPlayer.y / 32;
               class3.drawDot(var1, var2, var9, var10, Client.mapIcons[var8], var4);
            }

            int var11;
            int var12;
            for(var8 = 0; var8 < 104; ++var8) {
               for(var9 = 0; var9 < 104; ++var9) {
                  Deque var17 = Client.groundItemDeque[class28.plane][var8][var9];
                  if(var17 != null) {
                     var11 = var8 * 4 + 2 - class275.localPlayer.x / 32;
                     var12 = var9 * 4 + 2 - class275.localPlayer.y / 32;
                     class3.drawDot(var1, var2, var11, var12, Player.mapDots[0], var4);
                  }
               }
            }

            for(var8 = 0; var8 < Client.npcIndexesCount; ++var8) {
               NPC var18 = Client.cachedNPCs[Client.npcIndices[var8]];
               if(var18 != null && var18.hasConfig()) {
                  NPCComposition var21 = var18.composition;
                  if(var21 != null && var21.configs != null) {
                     var21 = var21.transform();
                  }

                  if(var21 != null && var21.isMinimapVisible && var21.field3611) {
                     var11 = var18.x / 32 - class275.localPlayer.x / 32;
                     var12 = var18.y / 32 - class275.localPlayer.y / 32;
                     class3.drawDot(var1, var2, var11, var12, Player.mapDots[1], var4);
                  }
               }
            }

            var8 = class94.playerIndexesCount;
            int[] var22 = class94.playerIndices;

            for(var10 = 0; var10 < var8; ++var10) {
               Player var19 = Client.cachedPlayers[var22[var10]];
               if(var19 != null && var19.hasConfig() && !var19.hidden && var19 != class275.localPlayer) {
                  var12 = var19.x / 32 - class275.localPlayer.x / 32;
                  int var13 = var19.y / 32 - class275.localPlayer.y / 32;
                  boolean var14 = false;
                  if(class82.isFriended(var19.name, true)) {
                     var14 = true;
                  }

                  boolean var15 = false;

                  for(int var16 = 0; var16 < class34.clanChatCount; ++var16) {
                     if(var19.name.equals(Varcs.clanMembers[var16].username)) {
                        var15 = true;
                        break;
                     }
                  }

                  boolean var20 = false;
                  if(class275.localPlayer.team != 0 && var19.team != 0 && var19.team == class275.localPlayer.team) {
                     var20 = true;
                  }

                  if(var14) {
                     class3.drawDot(var1, var2, var12, var13, Player.mapDots[3], var4);
                  } else if(var20) {
                     class3.drawDot(var1, var2, var12, var13, Player.mapDots[4], var4);
                  } else if(var15) {
                     class3.drawDot(var1, var2, var12, var13, Player.mapDots[5], var4);
                  } else {
                     class3.drawDot(var1, var2, var12, var13, Player.mapDots[2], var4);
                  }
               }
            }

            if(Client.hintArrowTargetType != 0 && Client.gameCycle % 20 < 10) {
               if(Client.hintArrowTargetType == 1 && Client.hintArrowNpcTargetIdx >= 0 && Client.hintArrowNpcTargetIdx < Client.cachedNPCs.length) {
                  NPC var23 = Client.cachedNPCs[Client.hintArrowNpcTargetIdx];
                  if(var23 != null) {
                     var11 = var23.x / 32 - class275.localPlayer.x / 32;
                     var12 = var23.y / 32 - class275.localPlayer.y / 32;
                     World.method1558(var1, var2, var11, var12, class210.mapMarkers[1], var4);
                  }
               }

               if(Client.hintArrowTargetType == 2) {
                  var10 = Client.hintArrowX * 4 - class13.baseX * 4 + 2 - class275.localPlayer.x / 32;
                  var11 = Client.hintArrowY * 4 - ClanMember.baseY * 4 + 2 - class275.localPlayer.y / 32;
                  World.method1558(var1, var2, var10, var11, class210.mapMarkers[1], var4);
               }

               if(Client.hintArrowTargetType == 10 && Client.hintArrowPlayerTargetIdx >= 0 && Client.hintArrowPlayerTargetIdx < Client.cachedPlayers.length) {
                  Player var24 = Client.cachedPlayers[Client.hintArrowPlayerTargetIdx];
                  if(var24 != null) {
                     var11 = var24.x / 32 - class275.localPlayer.x / 32;
                     var12 = var24.y / 32 - class275.localPlayer.y / 32;
                     World.method1558(var1, var2, var11, var12, class210.mapMarkers[1], var4);
                  }
               }
            }

            if(Client.destinationX != 0) {
               var10 = Client.destinationX * 4 + 2 - class275.localPlayer.x / 32;
               var11 = Client.destinationY * 4 + 2 - class275.localPlayer.y / 32;
               class3.drawDot(var1, var2, var10, var11, class210.mapMarkers[0], var4);
            }

            if(!class275.localPlayer.hidden) {
               Rasterizer2D.method4981(var4.field2673 / 2 + var1 - 1, var4.field2672 / 2 + var2 - 1, 3, 3, 16777215);
            }
         } else {
            Rasterizer2D.method4996(var1, var2, 0, var4.field2675, var4.field2674);
         }

         Client.field1053[var3] = true;
      }
   }
}
