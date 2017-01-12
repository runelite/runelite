import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gb")
public class class194 extends CacheableNode {
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -173053773
   )
   public int field2831;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 798002561
   )
   public int field2833;
   @ObfuscatedName("x")
   static NodeCache field2834 = new NodeCache(64);
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 754002543
   )
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
            int var17;
            int var18;
            for(var8 = 0; var8 < Client.field362; ++var8) {
               var17 = 2 + Client.field511[var8] * 4 - class148.localPlayer.x / 32;
               var18 = 2 + 4 * Client.field512[var8] - class148.localPlayer.y / 32;
               class203.method3801(var1, var2, var17, var18, Client.field305[var8], var4);
            }

            int var12;
            int var19;
            for(var8 = 0; var8 < 104; ++var8) {
               for(var17 = 0; var17 < 104; ++var17) {
                  Deque var10 = Client.groundItemDeque[class60.plane][var8][var17];
                  if(null != var10) {
                     var19 = 4 * var8 + 2 - class148.localPlayer.x / 32;
                     var12 = 4 * var17 + 2 - class148.localPlayer.y / 32;
                     class203.method3801(var1, var2, var19, var12, class161.field2129[0], var4);
                  }
               }
            }

            for(var8 = 0; var8 < Client.field322; ++var8) {
               NPC var9 = Client.cachedNPCs[Client.field483[var8]];
               if(var9 != null && var9.vmethod718()) {
                  NPCComposition var21 = var9.composition;
                  if(var21 != null && null != var21.field3016) {
                     var21 = var21.method3705();
                  }

                  if(var21 != null && var21.isMinimapVisible && var21.field3009) {
                     var19 = var9.x / 32 - class148.localPlayer.x / 32;
                     var12 = var9.y / 32 - class148.localPlayer.y / 32;
                     class203.method3801(var1, var2, var19, var12, class161.field2129[1], var4);
                  }
               }
            }

            var8 = class45.field888;
            int[] var20 = class45.field892;

            for(var18 = 0; var18 < var8; ++var18) {
               Player var11 = Client.cachedPlayers[var20[var18]];
               if(null != var11 && var11.vmethod718() && !var11.field260 && class148.localPlayer != var11) {
                  var12 = var11.x / 32 - class148.localPlayer.x / 32;
                  int var13 = var11.y / 32 - class148.localPlayer.y / 32;
                  boolean var14 = false;
                  if(class60.method1098(var11.name, true)) {
                     var14 = true;
                  }

                  boolean var15 = false;

                  for(int var16 = 0; var16 < class142.field1984; ++var16) {
                     if(var11.name.equals(class30.clanMembers[var16].username)) {
                        var15 = true;
                        break;
                     }
                  }

                  boolean var24 = false;
                  if(class148.localPlayer.team != 0 && var11.team != 0 && var11.team == class148.localPlayer.team) {
                     var24 = true;
                  }

                  if(var14) {
                     class203.method3801(var1, var2, var12, var13, class161.field2129[3], var4);
                  } else if(var24) {
                     class203.method3801(var1, var2, var12, var13, class161.field2129[4], var4);
                  } else if(var15) {
                     class203.method3801(var1, var2, var12, var13, class161.field2129[5], var4);
                  } else {
                     class203.method3801(var1, var2, var12, var13, class161.field2129[2], var4);
                  }
               }
            }

            if(Client.field298 != 0 && Client.gameCycle % 20 < 10) {
               if(Client.field298 == 1 && Client.field299 >= 0 && Client.field299 < Client.cachedNPCs.length) {
                  NPC var22 = Client.cachedNPCs[Client.field299];
                  if(null != var22) {
                     var19 = var22.x / 32 - class148.localPlayer.x / 32;
                     var12 = var22.y / 32 - class148.localPlayer.y / 32;
                     XItemContainer.method159(var1, var2, var19, var12, class167.field2169[1], var4);
                  }
               }

               if(Client.field298 == 2) {
                  var18 = Client.field530 * 4 - FrameMap.baseX * 4 + 2 - class148.localPlayer.x / 32;
                  var19 = Client.field426 * 4 - XItemContainer.baseY * 4 + 2 - class148.localPlayer.y / 32;
                  XItemContainer.method159(var1, var2, var18, var19, class167.field2169[1], var4);
               }

               if(Client.field298 == 10 && Client.field544 >= 0 && Client.field544 < Client.cachedPlayers.length) {
                  Player var23 = Client.cachedPlayers[Client.field544];
                  if(null != var23) {
                     var19 = var23.x / 32 - class148.localPlayer.x / 32;
                     var12 = var23.y / 32 - class148.localPlayer.y / 32;
                     XItemContainer.method159(var1, var2, var19, var12, class167.field2169[1], var4);
                  }
               }
            }

            if(Client.flagX != 0) {
               var18 = 2 + Client.flagX * 4 - class148.localPlayer.x / 32;
               var19 = 2 + Client.flagY * 4 - class148.localPlayer.y / 32;
               class203.method3801(var1, var2, var18, var19, class167.field2169[0], var4);
            }

            if(!class148.localPlayer.field260) {
               class219.method3993(var1 + var4.field2143 / 2 - 1, var4.field2139 / 2 + var2 - 1, 3, 3, 16777215);
            }
         } else {
            class219.method3984(var1, var2, 0, var4.field2138, var4.field2141);
         }

         Client.field486[var3] = true;
      }
   }
}
