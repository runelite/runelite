import java.awt.datatransfer.Clipboard;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("i")
public class class15 {
   @ObfuscatedName("p")
   static final class15 field153 = new class15();
   @ObfuscatedName("x")
   static final class15 field155 = new class15();
   @ObfuscatedName("q")
   static final class15 field156 = new class15();
   @ObfuscatedName("g")
   static final class15 field157 = new class15();
   @ObfuscatedName("pn")
   @ObfuscatedGetter(
      longValue = 4702180852371870273L
   )
   static long field158;
   @ObfuscatedName("np")
   @ObfuscatedGetter(
      intValue = -560279843
   )
   static int field159;
   @ObfuscatedName("qs")
   protected static java.awt.Frame field163;
   @ObfuscatedName("ip")
   static class38 field164;
   @ObfuscatedName("pj")
   static Clipboard field165;
   @ObfuscatedName("im")
   static Widget field167;

   @ObfuscatedName("dg")
   @ObfuscatedSignature(
      signature = "(LWidget;IIIB)V",
      garbageValue = "-20"
   )
   static final void method183(Widget var0, int var1, int var2, int var3) {
      class85.method1692();
      class164 var4 = var0.method3218(false);
      if(null != var4) {
         Rasterizer2D.method4008(var1, var2, var4.field2156 + var1, var2 + var4.field2153);
         if(Client.field513 != 2 && Client.field513 != 5) {
            int var5 = Client.mapAngle + Client.mapScale & 2047;
            int var6 = 48 + class16.localPlayer.x / 32;
            int var7 = 464 - class16.localPlayer.y / 32;
            WidgetNode.field174.method4155(var1, var2, var4.field2156, var4.field2153, var6, var7, var5, Client.mapScaleDelta + 256, var4.field2152, var4.field2150);

            int var8;
            int var9;
            int var17;
            for(var8 = 0; var8 < Client.field343; ++var8) {
               var9 = Client.field508[var8] * 4 + 2 - class16.localPlayer.x / 32;
               var17 = 4 * Client.field531[var8] + 2 - class16.localPlayer.y / 32;
               class72.method1390(var1, var2, var9, var17, Client.field510[var8], var4);
            }

            int var11;
            int var12;
            for(var8 = 0; var8 < 104; ++var8) {
               for(var9 = 0; var9 < 104; ++var9) {
                  Deque var10 = Client.groundItemDeque[WallObject.plane][var8][var9];
                  if(null != var10) {
                     var11 = 4 * var8 + 2 - class16.localPlayer.x / 32;
                     var12 = var9 * 4 + 2 - class16.localPlayer.y / 32;
                     class72.method1390(var1, var2, var11, var12, class152.field2087[0], var4);
                  }
               }
            }

            for(var8 = 0; var8 < Client.field316; ++var8) {
               NPC var18 = Client.cachedNPCs[Client.field419[var8]];
               if(null != var18 && var18.vmethod702()) {
                  NPCComposition var20 = var18.composition;
                  if(null != var20 && null != var20.configs) {
                     var20 = var20.method3708();
                  }

                  if(null != var20 && var20.isMinimapVisible && var20.field3026) {
                     var11 = var18.x / 32 - class16.localPlayer.x / 32;
                     var12 = var18.y / 32 - class16.localPlayer.y / 32;
                     class72.method1390(var1, var2, var11, var12, class152.field2087[1], var4);
                  }
               }
            }

            var8 = class45.field898;
            int[] var24 = class45.field895;

            for(var17 = 0; var17 < var8; ++var17) {
               Player var19 = Client.cachedPlayers[var24[var17]];
               if(var19 != null && var19.vmethod702() && !var19.field266 && var19 != class16.localPlayer) {
                  var12 = var19.x / 32 - class16.localPlayer.x / 32;
                  int var13 = var19.y / 32 - class16.localPlayer.y / 32;
                  boolean var14 = false;
                  if(GameEngine.method2194(var19.name, true)) {
                     var14 = true;
                  }

                  boolean var15 = false;

                  for(int var16 = 0; var16 < class10.clanChatCount; ++var16) {
                     if(var19.name.equals(Renderable.clanMembers[var16].username)) {
                        var15 = true;
                        break;
                     }
                  }

                  boolean var23 = false;
                  if(class16.localPlayer.team != 0 && var19.team != 0 && var19.team == class16.localPlayer.team) {
                     var23 = true;
                  }

                  if(var14) {
                     class72.method1390(var1, var2, var12, var13, class152.field2087[3], var4);
                  } else if(var23) {
                     class72.method1390(var1, var2, var12, var13, class152.field2087[4], var4);
                  } else if(var15) {
                     class72.method1390(var1, var2, var12, var13, class152.field2087[5], var4);
                  } else {
                     class72.method1390(var1, var2, var12, var13, class152.field2087[2], var4);
                  }
               }
            }

            if(Client.field407 != 0 && Client.gameCycle % 20 < 10) {
               if(Client.field407 == 1 && Client.field499 >= 0 && Client.field499 < Client.cachedNPCs.length) {
                  NPC var21 = Client.cachedNPCs[Client.field499];
                  if(null != var21) {
                     var11 = var21.x / 32 - class16.localPlayer.x / 32;
                     var12 = var21.y / 32 - class16.localPlayer.y / 32;
                     class139.method2634(var1, var2, var11, var12, class175.field2644[1], var4);
                  }
               }

               if(Client.field407 == 2) {
                  var17 = 2 + (Client.field439 * 4 - Projectile.baseX * 4) - class16.localPlayer.x / 32;
                  var11 = 2 + (Client.field549 * 4 - class3.baseY * 4) - class16.localPlayer.y / 32;
                  class139.method2634(var1, var2, var17, var11, class175.field2644[1], var4);
               }

               if(Client.field407 == 10 && Client.field321 >= 0 && Client.field321 < Client.cachedPlayers.length) {
                  Player var22 = Client.cachedPlayers[Client.field321];
                  if(var22 != null) {
                     var11 = var22.x / 32 - class16.localPlayer.x / 32;
                     var12 = var22.y / 32 - class16.localPlayer.y / 32;
                     class139.method2634(var1, var2, var11, var12, class175.field2644[1], var4);
                  }
               }
            }

            if(Client.flagX != 0) {
               var17 = 2 + Client.flagX * 4 - class16.localPlayer.x / 32;
               var11 = 2 + Client.flagY * 4 - class16.localPlayer.y / 32;
               class72.method1390(var1, var2, var17, var11, class175.field2644[0], var4);
            }

            if(!class16.localPlayer.field266) {
               Rasterizer2D.method4020(var4.field2156 / 2 + var1 - 1, var2 + var4.field2153 / 2 - 1, 3, 3, 16777215);
            }
         } else {
            Rasterizer2D.method3988(var1, var2, 0, var4.field2152, var4.field2150);
         }

         Client.field483[var3] = true;
      }
   }

   @ObfuscatedName("bi")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "49"
   )
   @Export("groundItemSpawned")
   static final void groundItemSpawned(int var0, int var1) {
      Deque var2 = Client.groundItemDeque[WallObject.plane][var0][var1];
      if(var2 == null) {
         Renderable.region.method1720(WallObject.plane, var0, var1);
      } else {
         long var3 = -99999999L;
         Item var5 = null;

         Item var6;
         for(var6 = (Item)var2.method2412(); var6 != null; var6 = (Item)var2.method2426()) {
            ItemComposition var7 = class36.getItemDefinition(var6.id);
            long var8 = (long)var7.price;
            if(var7.isStackable == 1) {
               var8 *= (long)(var6.quantity + 1);
            }

            if(var8 > var3) {
               var3 = var8;
               var5 = var6;
            }
         }

         if(null == var5) {
            Renderable.region.method1720(WallObject.plane, var0, var1);
         } else {
            var2.method2408(var5);
            Item var11 = null;
            Item var10 = null;

            for(var6 = (Item)var2.method2412(); null != var6; var6 = (Item)var2.method2426()) {
               if(var5.id != var6.id) {
                  if(null == var11) {
                     var11 = var6;
                  }

                  if(var11.id != var6.id && var10 == null) {
                     var10 = var6;
                  }
               }
            }

            int var9 = (var1 << 7) + var0 + 1610612736;
            Renderable.region.method1737(WallObject.plane, var0, var1, class65.method1153(64 + 128 * var0, 64 + 128 * var1, WallObject.plane), var5, var9, var11, var10);
         }
      }
   }
}
