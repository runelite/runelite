import java.util.Comparator;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("v")
final class class18 implements Comparator {
   @ObfuscatedName("pe")
   @ObfuscatedSignature(
      signature = "Lde;"
   )
   static Resampler field320;
   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "Ljr;"
   )
   static IndexDataBase field319;
   @ObfuscatedName("dj")
   @ObfuscatedGetter(
      intValue = -887124481
   )
   @Export("port1")
   static int port1;
   @ObfuscatedName("dp")
   @ObfuscatedGetter(
      intValue = -486537345
   )
   @Export("port2")
   static int port2;
   @ObfuscatedName("gs")
   @ObfuscatedGetter(
      intValue = -644896421
   )
   @Export("cameraPitch")
   static int cameraPitch;

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Lp;Lp;B)I",
      garbageValue = "-63"
   )
   int method144(GrandExchangeEvent var1, GrandExchangeEvent var2) {
      return var1.method86().compareTo(var2.method86());
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   public int compare(Object var1, Object var2) {
      return this.method144((GrandExchangeEvent)var1, (GrandExchangeEvent)var2);
   }

   @ObfuscatedName("kk")
   @ObfuscatedSignature(
      signature = "(Liz;IIII)V",
      garbageValue = "-622984876"
   )
   static final void method151(Widget var0, int var1, int var2, int var3) {
      class36.method545();
      class236 var4 = var0.method4542(false);
      if(var4 != null) {
         Rasterizer2D.setDrawRegion(var1, var2, var4.field2780 + var1, var2 + var4.field2782);
         if(Client.field1082 != 2 && Client.field1082 != 5) {
            int var5 = Client.mapAngle & 2047;
            int var6 = class265.localPlayer.x / 32 + 48;
            int var7 = 464 - class265.localPlayer.y / 32;
            class44.minimapSprite.method5932(var1, var2, var4.field2780, var4.field2782, var6, var7, var5, 256, var4.field2779, var4.field2781);

            int var8;
            int var9;
            int var10;
            for(var8 = 0; var8 < Client.field1114; ++var8) {
               var9 = Client.field1105[var8] * 4 + 2 - class265.localPlayer.x / 32;
               var10 = Client.field1087[var8] * 4 + 2 - class265.localPlayer.y / 32;
               ClanMemberManager.drawDot(var1, var2, var9, var10, Client.mapIcons[var8], var4);
            }

            int var11;
            int var12;
            for(var8 = 0; var8 < 104; ++var8) {
               for(var9 = 0; var9 < 104; ++var9) {
                  Deque var15 = Client.groundItemDeque[ScriptVarType.plane][var8][var9];
                  if(var15 != null) {
                     var11 = var8 * 4 + 2 - class265.localPlayer.x / 32;
                     var12 = var9 * 4 + 2 - class265.localPlayer.y / 32;
                     ClanMemberManager.drawDot(var1, var2, var11, var12, class3.mapDots[0], var4);
                  }
               }
            }

            for(var8 = 0; var8 < Client.npcIndexesCount; ++var8) {
               NPC var16 = Client.cachedNPCs[Client.npcIndices[var8]];
               if(var16 != null && var16.hasConfig()) {
                  NPCComposition var18 = var16.composition;
                  if(var18 != null && var18.configs != null) {
                     var18 = var18.transform();
                  }

                  if(var18 != null && var18.isMinimapVisible && var18.field3739) {
                     var11 = var16.x / 32 - class265.localPlayer.x / 32;
                     var12 = var16.y / 32 - class265.localPlayer.y / 32;
                     ClanMemberManager.drawDot(var1, var2, var11, var12, class3.mapDots[1], var4);
                  }
               }
            }

            var8 = class93.playerIndexesCount;
            int[] var19 = class93.playerIndices;

            for(var10 = 0; var10 < var8; ++var10) {
               Player var17 = Client.cachedPlayers[var19[var10]];
               if(var17 != null && var17.hasConfig() && !var17.hidden && var17 != class265.localPlayer) {
                  var12 = var17.x / 32 - class265.localPlayer.x / 32;
                  int var13 = var17.y / 32 - class265.localPlayer.y / 32;
                  boolean var14 = false;
                  if(class265.localPlayer.team != 0 && var17.team != 0 && var17.team == class265.localPlayer.team) {
                     var14 = true;
                  }

                  if(var17.isFriend()) {
                     ClanMemberManager.drawDot(var1, var2, var12, var13, class3.mapDots[3], var4);
                  } else if(var14) {
                     ClanMemberManager.drawDot(var1, var2, var12, var13, class3.mapDots[4], var4);
                  } else if(var17.isClanMember()) {
                     ClanMemberManager.drawDot(var1, var2, var12, var13, class3.mapDots[5], var4);
                  } else {
                     ClanMemberManager.drawDot(var1, var2, var12, var13, class3.mapDots[2], var4);
                  }
               }
            }

            if(Client.hintArrowTargetType != 0 && Client.gameCycle % 20 < 10) {
               if(Client.hintArrowTargetType == 1 && Client.hintArrowNpcTargetIdx >= 0 && Client.hintArrowNpcTargetIdx < Client.cachedNPCs.length) {
                  NPC var20 = Client.cachedNPCs[Client.hintArrowNpcTargetIdx];
                  if(var20 != null) {
                     var11 = var20.x / 32 - class265.localPlayer.x / 32;
                     var12 = var20.y / 32 - class265.localPlayer.y / 32;
                     MapIcon.worldToMinimap(var1, var2, var11, var12, class66.mapMarkers[1], var4);
                  }
               }

               if(Client.hintArrowTargetType == 2) {
                  var10 = Client.hintArrowX * 4 - ClientPacket.baseX * 4 + 2 - class265.localPlayer.x / 32;
                  var11 = Client.hintArrowY * 4 - MapIconReference.baseY * 4 + 2 - class265.localPlayer.y / 32;
                  MapIcon.worldToMinimap(var1, var2, var10, var11, class66.mapMarkers[1], var4);
               }

               if(Client.hintArrowTargetType == 10 && Client.hintArrowPlayerTargetIdx >= 0 && Client.hintArrowPlayerTargetIdx < Client.cachedPlayers.length) {
                  Player var21 = Client.cachedPlayers[Client.hintArrowPlayerTargetIdx];
                  if(var21 != null) {
                     var11 = var21.x / 32 - class265.localPlayer.x / 32;
                     var12 = var21.y / 32 - class265.localPlayer.y / 32;
                     MapIcon.worldToMinimap(var1, var2, var11, var12, class66.mapMarkers[1], var4);
                  }
               }
            }

            if(Client.destinationX != 0) {
               var10 = Client.destinationX * 4 + 2 - class265.localPlayer.x / 32;
               var11 = Client.destinationY * 4 + 2 - class265.localPlayer.y / 32;
               ClanMemberManager.drawDot(var1, var2, var10, var11, class66.mapMarkers[0], var4);
            }

            if(!class265.localPlayer.hidden) {
               Rasterizer2D.Rasterizer2D_fillRectangle(var4.field2780 / 2 + var1 - 1, var4.field2782 / 2 + var2 - 1, 3, 3, 16777215);
            }
         } else {
            Rasterizer2D.method5818(var1, var2, 0, var4.field2779, var4.field2781);
         }

         Client.field1056[var3] = true;
      }
   }
}
