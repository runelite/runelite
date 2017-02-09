import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("t")
@Implements("WidgetNode")
public class WidgetNode extends Node {
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 96921881
   )
   public static int field177;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -2026231125
   )
   int field178;
   @ObfuscatedName("er")
   static SpritePixels field180;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -264141929
   )
   @Export("id")
   int id;
   @ObfuscatedName("w")
   @Export("worldList")
   static World[] worldList;
   @ObfuscatedName("o")
   boolean field187 = false;

   @ObfuscatedName("db")
   @ObfuscatedSignature(
      signature = "(LWidget;IIII)V",
      garbageValue = "-1637546726"
   )
   static final void method200(Widget var0, int var1, int var2, int var3) {
      class3.method33();
      class145 var4 = var0.method2778(false);
      if(null != var4) {
         Rasterizer2D.method3973(var1, var2, var4.field2007 + var1, var4.field2004 + var2);
         if(Client.field514 != 2 && Client.field514 != 5) {
            int var5 = Client.mapScale + Client.mapAngle & 2047;
            int var6 = 48 + VertexNormal.localPlayer.x / 32;
            int var7 = 464 - VertexNormal.localPlayer.y / 32;
            class7.field56.method4125(var1, var2, var4.field2007, var4.field2004, var6, var7, var5, Client.mapScaleDelta + 256, var4.field2006, var4.field2003);

            int var8;
            int var9;
            int var10;
            for(var8 = 0; var8 < Client.field507; ++var8) {
               var9 = 2 + 4 * Client.field508[var8] - VertexNormal.localPlayer.x / 32;
               var10 = Client.field509[var8] * 4 + 2 - VertexNormal.localPlayer.y / 32;
               class97.method1911(var1, var2, var9, var10, Client.field510[var8], var4);
            }

            int var11;
            int var12;
            for(var8 = 0; var8 < 104; ++var8) {
               for(var9 = 0; var9 < 104; ++var9) {
                  Deque var18 = Client.groundItemDeque[class48.plane][var8][var9];
                  if(null != var18) {
                     var11 = 4 * var8 + 2 - VertexNormal.localPlayer.x / 32;
                     var12 = 2 + var9 * 4 - VertexNormal.localPlayer.y / 32;
                     class97.method1911(var1, var2, var11, var12, class22.field239[0], var4);
                  }
               }
            }

            for(var8 = 0; var8 < Client.field317; ++var8) {
               NPC var19 = Client.cachedNPCs[Client.field554[var8]];
               if(var19 != null && var19.vmethod736()) {
                  NPCComposition var21 = var19.composition;
                  if(var21 != null && var21.configs != null) {
                     var21 = var21.method3729();
                  }

                  if(null != var21 && var21.isMinimapVisible && var21.field3014) {
                     var11 = var19.x / 32 - VertexNormal.localPlayer.x / 32;
                     var12 = var19.y / 32 - VertexNormal.localPlayer.y / 32;
                     class97.method1911(var1, var2, var11, var12, class22.field239[1], var4);
                  }
               }
            }

            var8 = class45.field901;
            int[] var22 = class45.field902;

            for(var10 = 0; var10 < var8; ++var10) {
               Player var17 = Client.cachedPlayers[var22[var10]];
               if(var17 != null && var17.vmethod736() && !var17.field262 && VertexNormal.localPlayer != var17) {
                  var12 = var17.x / 32 - VertexNormal.localPlayer.x / 32;
                  int var13 = var17.y / 32 - VertexNormal.localPlayer.y / 32;
                  boolean var14 = false;
                  if(class63.method1170(var17.name, true)) {
                     var14 = true;
                  }

                  boolean var15 = false;

                  for(int var16 = 0; var16 < class72.clanChatCount; ++var16) {
                     if(var17.name.equals(class85.clanMembers[var16].username)) {
                        var15 = true;
                        break;
                     }
                  }

                  boolean var20 = false;
                  if(VertexNormal.localPlayer.team != 0 && var17.team != 0 && var17.team == VertexNormal.localPlayer.team) {
                     var20 = true;
                  }

                  if(var14) {
                     class97.method1911(var1, var2, var12, var13, class22.field239[3], var4);
                  } else if(var20) {
                     class97.method1911(var1, var2, var12, var13, class22.field239[4], var4);
                  } else if(var15) {
                     class97.method1911(var1, var2, var12, var13, class22.field239[5], var4);
                  } else {
                     class97.method1911(var1, var2, var12, var13, class22.field239[2], var4);
                  }
               }
            }

            if(Client.field296 != 0 && Client.gameCycle % 20 < 10) {
               if(Client.field296 == 1 && Client.field297 >= 0 && Client.field297 < Client.cachedNPCs.length) {
                  NPC var23 = Client.cachedNPCs[Client.field297];
                  if(null != var23) {
                     var11 = var23.x / 32 - VertexNormal.localPlayer.x / 32;
                     var12 = var23.y / 32 - VertexNormal.localPlayer.y / 32;
                     class6.method99(var1, var2, var11, var12, class5.field52[1], var4);
                  }
               }

               if(Client.field296 == 2) {
                  var10 = 2 + (Client.field348 * 4 - class114.baseX * 4) - VertexNormal.localPlayer.x / 32;
                  var11 = Client.field428 * 4 - CombatInfo1.baseY * 4 + 2 - VertexNormal.localPlayer.y / 32;
                  class6.method99(var1, var2, var10, var11, class5.field52[1], var4);
               }

               if(Client.field296 == 10 && Client.field298 >= 0 && Client.field298 < Client.cachedPlayers.length) {
                  Player var24 = Client.cachedPlayers[Client.field298];
                  if(var24 != null) {
                     var11 = var24.x / 32 - VertexNormal.localPlayer.x / 32;
                     var12 = var24.y / 32 - VertexNormal.localPlayer.y / 32;
                     class6.method99(var1, var2, var11, var12, class5.field52[1], var4);
                  }
               }
            }

            if(Client.flagX != 0) {
               var10 = Client.flagX * 4 + 2 - VertexNormal.localPlayer.x / 32;
               var11 = Client.flagY * 4 + 2 - VertexNormal.localPlayer.y / 32;
               class97.method1911(var1, var2, var10, var11, class5.field52[0], var4);
            }

            if(!VertexNormal.localPlayer.field262) {
               Rasterizer2D.method4004(var1 + var4.field2007 / 2 - 1, var4.field2004 / 2 + var2 - 1, 3, 3, 16777215);
            }
         } else {
            Rasterizer2D.method3992(var1, var2, 0, var4.field2006, var4.field2003);
         }

         Client.field483[var3] = true;
      }
   }
}
