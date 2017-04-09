import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dj")
public class class108 {
   @ObfuscatedName("pp")
   public static class103 field1755;

   @ObfuscatedName("dp")
   @ObfuscatedSignature(
      signature = "(LWidget;IIII)V",
      garbageValue = "-1993258635"
   )
   static final void method2086(Widget var0, int var1, int var2, int var3) {
      World.method596();
      class164 var4 = var0.method3288(false);
      if(var4 != null) {
         Rasterizer2D.method4001(var1, var2, var1 + var4.field2174, var2 + var4.field2172);
         if(Client.field539 != 2 && Client.field539 != 5) {
            int var5 = Client.mapScale + Client.mapAngle & 2047;
            int var6 = Projectile.localPlayer.x / 32 + 48;
            int var7 = 464 - Projectile.localPlayer.y / 32;
            CombatInfo1.field686.method4154(var1, var2, var4.field2174, var4.field2172, var6, var7, var5, Client.mapScaleDelta + 256, var4.field2173, var4.field2171);

            int var8;
            int var9;
            int var10;
            for(var8 = 0; var8 < Client.field533; ++var8) {
               var9 = Client.field534[var8] * 4 + 2 - Projectile.localPlayer.x / 32;
               var10 = Client.field435[var8] * 4 + 2 - Projectile.localPlayer.y / 32;
               class183.method3409(var1, var2, var9, var10, Client.field536[var8], var4);
            }

            var8 = 0;

            while(true) {
               int var11;
               int var12;
               if(var8 >= 104) {
                  for(var8 = 0; var8 < Client.field402; ++var8) {
                     NPC var19 = Client.cachedNPCs[Client.field342[var8]];
                     if(var19 != null && var19.vmethod738()) {
                        NPCComposition var14 = var19.composition;
                        if(var14 != null && var14.configs != null) {
                           var14 = var14.method3741();
                        }

                        if(var14 != null && var14.isMinimapVisible && var14.field3020) {
                           var12 = var19.x / 32 - Projectile.localPlayer.x / 32;
                           var11 = var19.y / 32 - Projectile.localPlayer.y / 32;
                           class183.method3409(var1, var2, var12, var11, MessageNode.field251[1], var4);
                        }
                     }
                  }

                  var8 = class45.field923;
                  int[] var20 = class45.field918;

                  Player var21;
                  for(var10 = 0; var10 < var8; ++var10) {
                     var21 = Client.cachedPlayers[var20[var10]];
                     if(var21 != null && var21.vmethod738() && !var21.field265 && var21 != Projectile.localPlayer) {
                        var11 = var21.x / 32 - Projectile.localPlayer.x / 32;
                        int var15 = var21.y / 32 - Projectile.localPlayer.y / 32;
                        boolean var16 = false;
                        if(class10.method137(var21.name, true)) {
                           var16 = true;
                        }

                        boolean var17 = false;

                        for(int var18 = 0; var18 < VertexNormal.clanChatCount; ++var18) {
                           if(var21.name.equals(class156.clanMembers[var18].username)) {
                              var17 = true;
                              break;
                           }
                        }

                        boolean var23 = false;
                        if(Projectile.localPlayer.team != 0 && var21.team != 0 && Projectile.localPlayer.team == var21.team) {
                           var23 = true;
                        }

                        if(var16) {
                           class183.method3409(var1, var2, var11, var15, MessageNode.field251[3], var4);
                        } else if(var23) {
                           class183.method3409(var1, var2, var11, var15, MessageNode.field251[4], var4);
                        } else if(var17) {
                           class183.method3409(var1, var2, var11, var15, MessageNode.field251[5], var4);
                        } else {
                           class183.method3409(var1, var2, var11, var15, MessageNode.field251[2], var4);
                        }
                     }
                  }

                  if(Client.field320 != 0 && Client.gameCycle % 20 < 10) {
                     if(Client.field320 == 1 && Client.field341 >= 0 && Client.field341 < Client.cachedNPCs.length) {
                        NPC var22 = Client.cachedNPCs[Client.field341];
                        if(var22 != null) {
                           var12 = var22.x / 32 - Projectile.localPlayer.x / 32;
                           var11 = var22.y / 32 - Projectile.localPlayer.y / 32;
                           class107.method2077(var1, var2, var12, var11, PlayerComposition.field2194[1], var4);
                        }
                     }

                     if(Client.field320 == 2) {
                        var10 = Client.field323 * 4 - class119.baseX * 4 + 2 - Projectile.localPlayer.x / 32;
                        var12 = Client.field393 * 4 - class187.baseY * 4 + 2 - Projectile.localPlayer.y / 32;
                        class107.method2077(var1, var2, var10, var12, PlayerComposition.field2194[1], var4);
                     }

                     if(Client.field320 == 10 && Client.field322 >= 0 && Client.field322 < Client.cachedPlayers.length) {
                        var21 = Client.cachedPlayers[Client.field322];
                        if(var21 != null) {
                           var12 = var21.x / 32 - Projectile.localPlayer.x / 32;
                           var11 = var21.y / 32 - Projectile.localPlayer.y / 32;
                           class107.method2077(var1, var2, var12, var11, PlayerComposition.field2194[1], var4);
                        }
                     }
                  }

                  if(Client.flagX != 0) {
                     var10 = Client.flagX * 4 + 2 - Projectile.localPlayer.x / 32;
                     var12 = Client.flagY * 4 + 2 - Projectile.localPlayer.y / 32;
                     class183.method3409(var1, var2, var10, var12, PlayerComposition.field2194[0], var4);
                  }

                  if(!Projectile.localPlayer.field265) {
                     Rasterizer2D.method4007(var1 + var4.field2174 / 2 - 1, var2 + var4.field2172 / 2 - 1, 3, 3, 16777215);
                  }
                  break;
               }

               for(var9 = 0; var9 < 104; ++var9) {
                  Deque var13 = Client.groundItemDeque[Sequence.plane][var8][var9];
                  if(var13 != null) {
                     var12 = var8 * 4 + 2 - Projectile.localPlayer.x / 32;
                     var11 = var9 * 4 + 2 - Projectile.localPlayer.y / 32;
                     class183.method3409(var1, var2, var12, var11, MessageNode.field251[0], var4);
                  }
               }

               ++var8;
            }
         } else {
            Rasterizer2D.method4030(var1, var2, 0, var4.field2173, var4.field2171);
         }

         Client.field425[var3] = true;
      }

   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;I)I",
      garbageValue = "1439822468"
   )
   public static int method2088(CharSequence var0) {
      int var1 = var0.length();
      int var2 = 0;

      for(int var3 = 0; var3 < var1; ++var3) {
         var2 = (var2 << 5) - var2 + var0.charAt(var3);
      }

      return var2;
   }

   class108() throws Throwable {
      throw new Error();
   }
}
