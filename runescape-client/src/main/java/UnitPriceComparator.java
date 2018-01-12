import java.util.Comparator;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("i")
@Implements("UnitPriceComparator")
final class UnitPriceComparator implements Comparator {
   @ObfuscatedName("fa")
   @ObfuscatedSignature(
      signature = "[Lks;"
   )
   @Export("headIconsPrayer")
   static SpritePixels[] headIconsPrayer;

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Ly;Ly;B)I",
      garbageValue = "-32"
   )
   int method113(GrandExchangeEvent var1, GrandExchangeEvent var2) {
      return var1.grandExchangeOffer.price < var2.grandExchangeOffer.price?-1:(var2.grandExchangeOffer.price == var1.grandExchangeOffer.price?0:1);
   }

   public int compare(Object var1, Object var2) {
      return this.method113((GrandExchangeEvent)var1, (GrandExchangeEvent)var2);
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;I)Ljava/lang/String;",
      garbageValue = "-732137286"
   )
   public static String method127(CharSequence var0) {
      int var2 = var0.length();
      char[] var3 = new char[var2];

      for(int var4 = 0; var4 < var2; ++var4) {
         var3[var4] = '*';
      }

      String var1 = new String(var3);
      return var1;
   }

   @ObfuscatedName("fw")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-166567064"
   )
   static final void method125() {
      for(GraphicsObject var0 = (GraphicsObject)Client.graphicsObjectDeque.getFront(); var0 != null; var0 = (GraphicsObject)Client.graphicsObjectDeque.getNext()) {
         if(var0.level == BoundingBox2D.plane && !var0.finished) {
            if(Client.gameCycle >= var0.startCycle) {
               var0.method1612(Client.field847);
               if(var0.finished) {
                  var0.unlink();
               } else {
                  class48.region.method2701(var0.level, var0.x, var0.y, var0.height, 60, var0, 0, -1, false);
               }
            }
         } else {
            var0.unlink();
         }
      }

   }

   @ObfuscatedName("hl")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Lhz;B)Ljava/lang/String;",
      garbageValue = "13"
   )
   static String method115(String var0, Widget var1) {
      if(var0.indexOf("%") != -1) {
         for(int var2 = 1; var2 <= 5; ++var2) {
            while(true) {
               int var3 = var0.indexOf("%" + var2);
               if(var3 == -1) {
                  break;
               }

               String var4 = var0.substring(0, var3);
               int var6 = class278.method4994(var1, var2 - 1);
               String var5;
               if(var6 < 999999999) {
                  var5 = Integer.toString(var6);
               } else {
                  var5 = "*";
               }

               var0 = var4 + var5 + var0.substring(var3 + 2);
            }
         }
      }

      return var0;
   }

   @ObfuscatedName("iv")
   @ObfuscatedSignature(
      signature = "(Lhz;IIII)V",
      garbageValue = "-100248967"
   )
   static final void method126(Widget var0, int var1, int var2, int var3) {
      NPC.method1648();
      SpritePixels2 var4 = var0.method4148(false);
      if(var4 != null) {
         Rasterizer2D.setDrawRegion(var1, var2, var4.field2715 + var1, var2 + var4.field2716);
         if(Client.field1062 != 2 && Client.field1062 != 5) {
            int var5 = Client.mapAngle & 2047;
            int var6 = UrlRequest.localPlayer.x / 32 + 48;
            int var7 = 464 - UrlRequest.localPlayer.y / 32;
            BoundingBox3D.field250.method5216(var1, var2, var4.field2715, var4.field2716, var6, var7, var5, 256, var4.field2717, var4.field2714);

            int var8;
            int var9;
            int var10;
            for(var8 = 0; var8 < Client.field1056; ++var8) {
               var9 = Client.field914[var8] * 4 + 2 - UrlRequest.localPlayer.x / 32;
               var10 = Client.field1058[var8] * 4 + 2 - UrlRequest.localPlayer.y / 32;
               class37.drawDot(var1, var2, var9, var10, Client.mapIcons[var8], var4);
            }

            int var11;
            int var12;
            for(var8 = 0; var8 < 104; ++var8) {
               for(var9 = 0; var9 < 104; ++var9) {
                  Deque var17 = Client.groundItemDeque[BoundingBox2D.plane][var8][var9];
                  if(var17 != null) {
                     var11 = var8 * 4 + 2 - UrlRequest.localPlayer.x / 32;
                     var12 = var9 * 4 + 2 - UrlRequest.localPlayer.y / 32;
                     class37.drawDot(var1, var2, var11, var12, Script.mapDots[0], var4);
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

                  if(var21 != null && var21.isMinimapVisible && var21.field3643) {
                     var11 = var18.x / 32 - UrlRequest.localPlayer.x / 32;
                     var12 = var18.y / 32 - UrlRequest.localPlayer.y / 32;
                     class37.drawDot(var1, var2, var11, var12, Script.mapDots[1], var4);
                  }
               }
            }

            var8 = class94.playerIndexesCount;
            int[] var22 = class94.playerIndices;

            for(var10 = 0; var10 < var8; ++var10) {
               Player var19 = Client.cachedPlayers[var22[var10]];
               if(var19 != null && var19.hasConfig() && !var19.hidden && var19 != UrlRequest.localPlayer) {
                  var12 = var19.x / 32 - UrlRequest.localPlayer.x / 32;
                  int var13 = var19.y / 32 - UrlRequest.localPlayer.y / 32;
                  boolean var14 = false;
                  if(class48.isFriended(var19.name, true)) {
                     var14 = true;
                  }

                  boolean var15 = false;

                  for(int var16 = 0; var16 < class192.clanChatCount; ++var16) {
                     if(var19.name.equals(GameEngine.clanMembers[var16].username)) {
                        var15 = true;
                        break;
                     }
                  }

                  boolean var20 = false;
                  if(UrlRequest.localPlayer.team != 0 && var19.team != 0 && var19.team == UrlRequest.localPlayer.team) {
                     var20 = true;
                  }

                  if(var14) {
                     class37.drawDot(var1, var2, var12, var13, Script.mapDots[3], var4);
                  } else if(var20) {
                     class37.drawDot(var1, var2, var12, var13, Script.mapDots[4], var4);
                  } else if(var15) {
                     class37.drawDot(var1, var2, var12, var13, Script.mapDots[5], var4);
                  } else {
                     class37.drawDot(var1, var2, var12, var13, Script.mapDots[2], var4);
                  }
               }
            }

            if(Client.hintArrowTargetType != 0 && Client.gameCycle % 20 < 10) {
               if(Client.hintArrowTargetType == 1 && Client.hintArrowNpcTargetIdx >= 0 && Client.hintArrowNpcTargetIdx < Client.cachedNPCs.length) {
                  NPC var23 = Client.cachedNPCs[Client.hintArrowNpcTargetIdx];
                  if(var23 != null) {
                     var11 = var23.x / 32 - UrlRequest.localPlayer.x / 32;
                     var12 = var23.y / 32 - UrlRequest.localPlayer.y / 32;
                     class133.worldToMinimap(var1, var2, var11, var12, class34.mapMarkers[1], var4);
                  }
               }

               if(Client.hintArrowTargetType == 2) {
                  var10 = Client.hintArrowX * 4 - SceneChunkMetadata.baseX * 4 + 2 - UrlRequest.localPlayer.x / 32;
                  var11 = Client.hintArrowY * 4 - Client.baseY * 4 + 2 - UrlRequest.localPlayer.y / 32;
                  class133.worldToMinimap(var1, var2, var10, var11, class34.mapMarkers[1], var4);
               }

               if(Client.hintArrowTargetType == 10 && Client.hintArrowPlayerTargetIdx >= 0 && Client.hintArrowPlayerTargetIdx < Client.cachedPlayers.length) {
                  Player var24 = Client.cachedPlayers[Client.hintArrowPlayerTargetIdx];
                  if(var24 != null) {
                     var11 = var24.x / 32 - UrlRequest.localPlayer.x / 32;
                     var12 = var24.y / 32 - UrlRequest.localPlayer.y / 32;
                     class133.worldToMinimap(var1, var2, var11, var12, class34.mapMarkers[1], var4);
                  }
               }
            }

            if(Client.destinationX != 0) {
               var10 = Client.destinationX * 4 + 2 - UrlRequest.localPlayer.x / 32;
               var11 = Client.destinationY * 4 + 2 - UrlRequest.localPlayer.y / 32;
               class37.drawDot(var1, var2, var10, var11, class34.mapMarkers[0], var4);
            }

            if(!UrlRequest.localPlayer.hidden) {
               Rasterizer2D.Rasterizer2D_fillRectangle(var4.field2715 / 2 + var1 - 1, var4.field2716 / 2 + var2 - 1, 3, 3, 16777215);
            }
         } else {
            Rasterizer2D.method5104(var1, var2, 0, var4.field2717, var4.field2714);
         }

         Client.field1019[var3] = true;
      }
   }
}
