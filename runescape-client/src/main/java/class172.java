import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fh")
public class class172 extends Node {
   @ObfuscatedName("g")
   byte[] field2755;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -780685089
   )
   int field2757;
   @ObfuscatedName("e")
   class171 field2758;
   @ObfuscatedName("r")
   class137 field2759;

   @ObfuscatedName("db")
   @ObfuscatedSignature(
      signature = "(LWidget;IIIB)V",
      garbageValue = "35"
   )
   static final void method3512(Widget var0, int var1, int var2, int var3) {
      class47.method1009();
      class178 var4 = var0.method3557(false);
      if(null != var4) {
         class82.method1908(var1, var2, var1 + var4.field2953, var4.field2950 + var2);
         if(Client.field530 != 2 && Client.field530 != 5) {
            int var5 = Client.mapAngle + Client.mapScale & 2047;
            int var6 = WidgetNode.localPlayer.x / 32 + 48;
            int var7 = 464 - WidgetNode.localPlayer.y / 32;
            class23.field619.method1801(var1, var2, var4.field2953, var4.field2950, var6, var7, var5, Client.mapScaleDelta + 256, var4.field2954, var4.field2951);

            int var8;
            int var9;
            int var10;
            for(var8 = 0; var8 < Client.field524; ++var8) {
               var9 = Client.field525[var8] * 4 + 2 - WidgetNode.localPlayer.x / 32;
               var10 = 2 + Client.field526[var8] * 4 - WidgetNode.localPlayer.y / 32;
               class0.method1(var1, var2, var9, var10, Client.field453[var8], var4);
            }

            var8 = 0;

            while(true) {
               int var11;
               int var12;
               if(var8 >= 104) {
                  for(var8 = 0; var8 < Client.field486; ++var8) {
                     NPC var19 = Client.cachedNPCs[Client.field334[var8]];
                     if(var19 != null && var19.vmethod794()) {
                        NPCComposition var14 = var19.composition;
                        if(null != var14 && null != var14.field937) {
                           var14 = var14.method820();
                        }

                        if(null != var14 && var14.isMinimapVisible && var14.field940) {
                           var11 = var19.x / 32 - WidgetNode.localPlayer.x / 32;
                           var12 = var19.y / 32 - WidgetNode.localPlayer.y / 32;
                           class0.method1(var1, var2, var11, var12, ChatMessages.field283[1], var4);
                        }
                     }
                  }

                  var8 = class34.field783;
                  int[] var20 = class34.field784;

                  Player var21;
                  for(var10 = 0; var10 < var8; ++var10) {
                     var21 = Client.cachedPlayers[var20[var10]];
                     if(null != var21 && var21.vmethod794() && !var21.field51 && var21 != WidgetNode.localPlayer) {
                        var12 = var21.x / 32 - WidgetNode.localPlayer.x / 32;
                        int var15 = var21.y / 32 - WidgetNode.localPlayer.y / 32;
                        boolean var16 = false;
                        if(class145.method3128(var21.name, true)) {
                           var16 = true;
                        }

                        boolean var17 = false;

                        for(int var18 = 0; var18 < Client.field522; ++var18) {
                           if(var21.name.equals(class4.clanMembers[var18].username)) {
                              var17 = true;
                              break;
                           }
                        }

                        boolean var23 = false;
                        if(WidgetNode.localPlayer.team != 0 && var21.team != 0 && var21.team == WidgetNode.localPlayer.team) {
                           var23 = true;
                        }

                        if(var16) {
                           class0.method1(var1, var2, var12, var15, ChatMessages.field283[3], var4);
                        } else if(var23) {
                           class0.method1(var1, var2, var12, var15, ChatMessages.field283[4], var4);
                        } else if(var17) {
                           class0.method1(var1, var2, var12, var15, ChatMessages.field283[5], var4);
                        } else {
                           class0.method1(var1, var2, var12, var15, ChatMessages.field283[2], var4);
                        }
                     }
                  }

                  if(Client.field313 != 0 && Client.gameCycle % 20 < 10) {
                     if(Client.field313 == 1 && Client.field314 >= 0 && Client.field314 < Client.cachedNPCs.length) {
                        NPC var22 = Client.cachedNPCs[Client.field314];
                        if(null != var22) {
                           var11 = var22.x / 32 - WidgetNode.localPlayer.x / 32;
                           var12 = var22.y / 32 - WidgetNode.localPlayer.y / 32;
                           Sequence.method945(var1, var2, var11, var12, Client.field463[1], var4);
                        }
                     }

                     if(Client.field313 == 2) {
                        var10 = 2 + (Client.field316 * 4 - class0.baseX * 4) - WidgetNode.localPlayer.x / 32;
                        var11 = 2 + (Client.field317 * 4 - class21.baseY * 4) - WidgetNode.localPlayer.y / 32;
                        Sequence.method945(var1, var2, var10, var11, Client.field463[1], var4);
                     }

                     if(Client.field313 == 10 && Client.field315 >= 0 && Client.field315 < Client.cachedPlayers.length) {
                        var21 = Client.cachedPlayers[Client.field315];
                        if(null != var21) {
                           var11 = var21.x / 32 - WidgetNode.localPlayer.x / 32;
                           var12 = var21.y / 32 - WidgetNode.localPlayer.y / 32;
                           Sequence.method945(var1, var2, var11, var12, Client.field463[1], var4);
                        }
                     }
                  }

                  if(Client.flagX != 0) {
                     var10 = 2 + Client.flagX * 4 - WidgetNode.localPlayer.x / 32;
                     var11 = Client.flagY * 4 + 2 - WidgetNode.localPlayer.y / 32;
                     class0.method1(var1, var2, var10, var11, Client.field463[0], var4);
                  }

                  if(!WidgetNode.localPlayer.field51) {
                     class82.method1907(var4.field2953 / 2 + var1 - 1, var4.field2950 / 2 + var2 - 1, 3, 3, 16777215);
                  }
                  break;
               }

               for(var9 = 0; var9 < 104; ++var9) {
                  Deque var13 = Client.groundItemDeque[VertexNormal.plane][var8][var9];
                  if(var13 != null) {
                     var11 = 4 * var8 + 2 - WidgetNode.localPlayer.x / 32;
                     var12 = var9 * 4 + 2 - WidgetNode.localPlayer.y / 32;
                     class0.method1(var1, var2, var11, var12, ChatMessages.field283[0], var4);
                  }
               }

               ++var8;
            }
         } else {
            class82.method1899(var1, var2, 0, var4.field2954, var4.field2951);
         }

         Client.field499[var3] = true;
      }

   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(ZZB)I",
      garbageValue = "-23"
   )
   public static int method3513(boolean var0, boolean var1) {
      byte var2 = 0;
      int var3 = var2 + class174.field2774 + class174.field2781;
      return var3;
   }

   @ObfuscatedName("bx")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "1855255590"
   )
   static final void method3514(int var0, int var1) {
      int var2 = class59.field1268.method4165("Choose Option");

      int var3;
      int var4;
      for(var3 = 0; var3 < Client.menuOptionCount; ++var3) {
         var4 = class59.field1268.method4165(Tile.method2382(var3));
         if(var4 > var2) {
            var2 = var4;
         }
      }

      var2 += 8;
      var3 = Client.menuOptionCount * 15 + 22;
      var4 = var0 - var2 / 2;
      if(var4 + var2 > class189.field3056) {
         var4 = class189.field3056 - var2;
      }

      if(var4 < 0) {
         var4 = 0;
      }

      int var5 = var1;
      if(var3 + var1 > Actor.field892) {
         var5 = Actor.field892 - var3;
      }

      if(var5 < 0) {
         var5 = 0;
      }

      Client.isMenuOpen = true;
      class13.menuX = var4;
      class14.menuY = var5;
      Item.menuWidth = var2;
      class77.menuHeight = Client.menuOptionCount * 15 + 22;
   }

   @ObfuscatedName("ai")
   @ObfuscatedSignature(
      signature = "(Lclass35;I)V",
      garbageValue = "-1671353199"
   )
   static final void method3515(class35 var0) {
      if(Client.flagX == WidgetNode.localPlayer.x >> 7 && WidgetNode.localPlayer.y >> 7 == Client.flagY) {
         Client.flagX = 0;
      }

      int var1 = class34.field783;
      int[] var2 = class34.field784;
      int var3 = var1;
      if(var0 == class35.field796 || class35.field800 == var0) {
         var3 = 1;
      }

      for(int var4 = 0; var4 < var3; ++var4) {
         Player var5;
         int var6;
         if(class35.field796 == var0) {
            var5 = WidgetNode.localPlayer;
            var6 = WidgetNode.localPlayer.field53 << 14;
         } else if(var0 == class35.field800) {
            var5 = Client.cachedPlayers[Client.field425];
            var6 = Client.field425 << 14;
         } else {
            var5 = Client.cachedPlayers[var2[var4]];
            var6 = var2[var4] << 14;
            if(class35.field798 == var0 && var2[var4] == Client.field425) {
               continue;
            }
         }

         if(null != var5 && var5.vmethod794() && !var5.field51) {
            var5.field39 = false;
            if((Client.field301 && var1 > 50 || var1 > 200) && class35.field796 != var0 && var5.idlePoseAnimation == var5.poseAnimation) {
               var5.field39 = true;
            }

            int var7 = var5.x >> 7;
            int var8 = var5.y >> 7;
            if(var7 >= 0 && var7 < 104 && var8 >= 0 && var8 < 104) {
               if(var5.model != null && Client.gameCycle >= var5.totalLevel && Client.gameCycle < var5.field40) {
                  var5.field39 = false;
                  var5.field38 = class127.method2936(var5.x, var5.y, VertexNormal.plane);
                  class136.region.method2131(VertexNormal.plane, var5.x, var5.y, var5.field38, 60, var5, var5.angle, var6, var5.field55, var5.field46, var5.field47, var5.field48);
               } else {
                  if((var5.x & 127) == 64 && (var5.y & 127) == 64) {
                     if(Client.field400 == Client.field560[var7][var8]) {
                        continue;
                     }

                     Client.field560[var7][var8] = Client.field400;
                  }

                  var5.field38 = class127.method2936(var5.x, var5.y, VertexNormal.plane);
                  class136.region.method2003(VertexNormal.plane, var5.x, var5.y, var5.field38, 60, var5, var5.angle, var6, var5.field834);
               }
            }
         }
      }

   }
}
