import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gb")
@Implements("Varbit")
public class class194 extends CacheableNode {
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -173053773
   )
   @Export("configId")
   public int field2831;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 798002561
   )
   @Export("leastSignificantBit")
   public int field2833;
   @ObfuscatedName("x")
   static NodeCache field2834 = new NodeCache(64);
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 754002543
   )
   @Export("mostSignificantBit")
   public int field2835;
   @ObfuscatedName("u")
   public static class182 field2836;

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(LBuffer;II)V",
      garbageValue = "-1653672992"
   )
   void method3536(Buffer var1, int var2) {
      if(var2 == 1) {
         this.field2833 = var1.readUnsignedShort();
         this.field2831 = var1.readUnsignedByte();
         this.field2835 = var1.readUnsignedByte();
      }

   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)V",
      garbageValue = "-156302899"
   )
   void method3540(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method3536(var1, var2);
      }
   }

   @ObfuscatedName("dr")
   @ObfuscatedSignature(
      signature = "(LWidget;IIII)V",
      garbageValue = "-736335484"
   )
   static final void method3544(Widget var0, int var1, int var2, int var3) {
      class40.method741();
      class164 var4 = var0.method3173(false);
      if(var4 != null) {
         class219.method3965(var1, var2, var1 + var4.field2143, var2 + var4.field2139);
         if(Client.field543 != 2 && Client.field543 != 5) {
            int var5 = Client.mapAngle + Client.mapScale & 2047;
            int var6 = 48 + class148.localPlayer.x / 32;
            int var7 = 464 - class148.localPlayer.y / 32;
            class179.field2668.method4133(var1, var2, var4.field2143, var4.field2139, var6, var7, var5, 256 + Client.mapScaleDelta, var4.field2138, var4.field2141);

            int var8;
            int var9;
            int var10;
            for(var8 = 0; var8 < Client.field362; ++var8) {
               var9 = 2 + Client.field511[var8] * 4 - class148.localPlayer.x / 32;
               var10 = 2 + 4 * Client.field512[var8] - class148.localPlayer.y / 32;
               class203.method3801(var1, var2, var9, var10, Client.field305[var8], var4);
            }

            var8 = 0;

            while(true) {
               int var11;
               int var12;
               if(var8 >= 104) {
                  for(var8 = 0; var8 < Client.field322; ++var8) {
                     NPC var19 = Client.cachedNPCs[Client.field483[var8]];
                     if(var19 != null && var19.vmethod718()) {
                        NPCComposition var14 = var19.composition;
                        if(var14 != null && null != var14.field3016) {
                           var14 = var14.method3705();
                        }

                        if(var14 != null && var14.isMinimapVisible && var14.field3009) {
                           var12 = var19.x / 32 - class148.localPlayer.x / 32;
                           var11 = var19.y / 32 - class148.localPlayer.y / 32;
                           class203.method3801(var1, var2, var12, var11, class161.field2129[1], var4);
                        }
                     }
                  }

                  var8 = class45.field888;
                  int[] var20 = class45.field892;

                  Player var21;
                  for(var10 = 0; var10 < var8; ++var10) {
                     var21 = Client.cachedPlayers[var20[var10]];
                     if(null != var21 && var21.vmethod718() && !var21.field260 && class148.localPlayer != var21) {
                        var11 = var21.x / 32 - class148.localPlayer.x / 32;
                        int var15 = var21.y / 32 - class148.localPlayer.y / 32;
                        boolean var16 = false;
                        if(class60.method1098(var21.name, true)) {
                           var16 = true;
                        }

                        boolean var17 = false;

                        for(int var18 = 0; var18 < class142.field1984; ++var18) {
                           if(var21.name.equals(class30.clanMembers[var18].username)) {
                              var17 = true;
                              break;
                           }
                        }

                        boolean var23 = false;
                        if(class148.localPlayer.team != 0 && var21.team != 0 && var21.team == class148.localPlayer.team) {
                           var23 = true;
                        }

                        if(var16) {
                           class203.method3801(var1, var2, var11, var15, class161.field2129[3], var4);
                        } else if(var23) {
                           class203.method3801(var1, var2, var11, var15, class161.field2129[4], var4);
                        } else if(var17) {
                           class203.method3801(var1, var2, var11, var15, class161.field2129[5], var4);
                        } else {
                           class203.method3801(var1, var2, var11, var15, class161.field2129[2], var4);
                        }
                     }
                  }

                  if(Client.field298 != 0 && Client.gameCycle % 20 < 10) {
                     if(Client.field298 == 1 && Client.field299 >= 0 && Client.field299 < Client.cachedNPCs.length) {
                        NPC var22 = Client.cachedNPCs[Client.field299];
                        if(null != var22) {
                           var12 = var22.x / 32 - class148.localPlayer.x / 32;
                           var11 = var22.y / 32 - class148.localPlayer.y / 32;
                           XItemContainer.method159(var1, var2, var12, var11, class167.field2169[1], var4);
                        }
                     }

                     if(Client.field298 == 2) {
                        var10 = Client.field530 * 4 - FrameMap.baseX * 4 + 2 - class148.localPlayer.x / 32;
                        var12 = Client.field426 * 4 - XItemContainer.baseY * 4 + 2 - class148.localPlayer.y / 32;
                        XItemContainer.method159(var1, var2, var10, var12, class167.field2169[1], var4);
                     }

                     if(Client.field298 == 10 && Client.field544 >= 0 && Client.field544 < Client.cachedPlayers.length) {
                        var21 = Client.cachedPlayers[Client.field544];
                        if(null != var21) {
                           var12 = var21.x / 32 - class148.localPlayer.x / 32;
                           var11 = var21.y / 32 - class148.localPlayer.y / 32;
                           XItemContainer.method159(var1, var2, var12, var11, class167.field2169[1], var4);
                        }
                     }
                  }

                  if(Client.flagX != 0) {
                     var10 = 2 + Client.flagX * 4 - class148.localPlayer.x / 32;
                     var12 = 2 + Client.flagY * 4 - class148.localPlayer.y / 32;
                     class203.method3801(var1, var2, var10, var12, class167.field2169[0], var4);
                  }

                  if(!class148.localPlayer.field260) {
                     class219.method3993(var1 + var4.field2143 / 2 - 1, var4.field2139 / 2 + var2 - 1, 3, 3, 16777215);
                  }
                  break;
               }

               for(var9 = 0; var9 < 104; ++var9) {
                  Deque var13 = Client.groundItemDeque[class60.plane][var8][var9];
                  if(null != var13) {
                     var12 = 4 * var8 + 2 - class148.localPlayer.x / 32;
                     var11 = 4 * var9 + 2 - class148.localPlayer.y / 32;
                     class203.method3801(var1, var2, var12, var11, class161.field2129[0], var4);
                  }
               }

               ++var8;
            }
         } else {
            class219.method3984(var1, var2, 0, var4.field2138, var4.field2141);
         }

         Client.field486[var3] = true;
      }

   }
}
