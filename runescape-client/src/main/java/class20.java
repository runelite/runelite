import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("d")
public class class20 implements Runnable {
   @ObfuscatedName("g")
   @Export("overlayPaths")
   static byte[][][] overlayPaths;
   @ObfuscatedName("fm")
   @ObfuscatedGetter(
      intValue = -1261916333
   )
   @Export("cameraY")
   static int cameraY;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 1003866935
   )
   int field230 = 0;
   @ObfuscatedName("s")
   boolean field231 = true;
   @ObfuscatedName("a")
   int[] field232 = new int[500];
   @ObfuscatedName("h")
   int[] field233 = new int[500];
   @ObfuscatedName("cx")
   static Font field234;
   @ObfuscatedName("c")
   Object field235 = new Object();
   @ObfuscatedName("p")
   public static Buffer field236;

   public void run() {
      for(; this.field231; Projectile.method757(50L)) {
         Object var1 = this.field235;
         synchronized(this.field235) {
            if(this.field230 < 500) {
               this.field233[this.field230] = class115.field1810;
               this.field232[this.field230] = class115.field1803;
               ++this.field230;
            }
         }
      }

   }

   @ObfuscatedName("as")
   @ObfuscatedSignature(
      signature = "(LPlayer;III)V",
      garbageValue = "-2061224546"
   )
   static void method172(Player var0, int var1, int var2) {
      if(var1 == var0.animation && var1 != -1) {
         int var3 = class110.getAnimation(var1).replyMode;
         if(var3 == 1) {
            var0.actionFrame = 0;
            var0.field638 = 0;
            var0.actionAnimationDisable = var2;
            var0.field640 = 0;
         }

         if(var3 == 2) {
            var0.field640 = 0;
         }
      } else if(var1 == -1 || var0.animation == -1 || class110.getAnimation(var1).forcedPriority >= class110.getAnimation(var0.animation).forcedPriority) {
         var0.animation = var1;
         var0.actionFrame = 0;
         var0.field638 = 0;
         var0.actionAnimationDisable = var2;
         var0.field640 = 0;
         var0.field663 = var0.field658;
      }

   }

   @ObfuscatedName("dq")
   @ObfuscatedSignature(
      signature = "(LWidget;IIII)V",
      garbageValue = "425296167"
   )
   static final void method173(Widget var0, int var1, int var2, int var3) {
      ChatMessages.method830();
      class164 var4 = var0.method3100(false);
      if(var4 != null) {
         Rasterizer2D.method3844(var1, var2, var1 + var4.field2164, var4.field2165 + var2);
         if(Client.field347 != 2 && Client.field347 != 5) {
            int var5 = Client.mapScale + Client.mapAngle & 2047;
            int var6 = 48 + XItemContainer.localPlayer.x / 32;
            int var7 = 464 - XItemContainer.localPlayer.y / 32;
            class63.field1094.method3982(var1, var2, var4.field2164, var4.field2165, var6, var7, var5, 256 + Client.mapScaleDelta, var4.field2172, var4.field2166);

            int var8;
            int var10;
            int var17;
            for(var8 = 0; var8 < Client.field331; ++var8) {
               var17 = Client.field523[var8] * 4 + 2 - XItemContainer.localPlayer.x / 32;
               var10 = 2 + Client.field524[var8] * 4 - XItemContainer.localPlayer.y / 32;
               NPC.method706(var1, var2, var17, var10, Client.field525[var8], var4);
            }

            int var11;
            int var12;
            for(var8 = 0; var8 < 104; ++var8) {
               for(var17 = 0; var17 < 104; ++var17) {
                  Deque var18 = Client.groundItemDeque[class118.plane][var8][var17];
                  if(var18 != null) {
                     var11 = var8 * 4 + 2 - XItemContainer.localPlayer.x / 32;
                     var12 = var17 * 4 + 2 - XItemContainer.localPlayer.y / 32;
                     NPC.method706(var1, var2, var11, var12, class116.field1821[0], var4);
                  }
               }
            }

            for(var8 = 0; var8 < Client.field332; ++var8) {
               NPC var9 = Client.cachedNPCs[Client.field333[var8]];
               if(var9 != null && var9.vmethod699()) {
                  NPCComposition var22 = var9.composition;
                  if(null != var22 && null != var22.configs) {
                     var22 = var22.method3576();
                  }

                  if(var22 != null && var22.isMinimapVisible && var22.field3037) {
                     var11 = var9.x / 32 - XItemContainer.localPlayer.x / 32;
                     var12 = var9.y / 32 - XItemContainer.localPlayer.y / 32;
                     NPC.method706(var1, var2, var11, var12, class116.field1821[1], var4);
                  }
               }
            }

            var8 = class45.field894;
            int[] var20 = class45.field896;

            for(var10 = 0; var10 < var8; ++var10) {
               Player var19 = Client.cachedPlayers[var20[var10]];
               if(var19 != null && var19.vmethod699() && !var19.field257 && var19 != XItemContainer.localPlayer) {
                  var12 = var19.x / 32 - XItemContainer.localPlayer.x / 32;
                  int var13 = var19.y / 32 - XItemContainer.localPlayer.y / 32;
                  boolean var14 = false;
                  if(class49.method854(var19.name, true)) {
                     var14 = true;
                  }

                  boolean var15 = false;

                  for(int var16 = 0; var16 < class162.clanChatCount; ++var16) {
                     if(var19.name.equals(class57.clanMembers[var16].username)) {
                        var15 = true;
                        break;
                     }
                  }

                  boolean var21 = false;
                  if(XItemContainer.localPlayer.team != 0 && var19.team != 0 && var19.team == XItemContainer.localPlayer.team) {
                     var21 = true;
                  }

                  if(var14) {
                     NPC.method706(var1, var2, var12, var13, class116.field1821[3], var4);
                  } else if(var21) {
                     NPC.method706(var1, var2, var12, var13, class116.field1821[4], var4);
                  } else if(var15) {
                     NPC.method706(var1, var2, var12, var13, class116.field1821[5], var4);
                  } else {
                     NPC.method706(var1, var2, var12, var13, class116.field1821[2], var4);
                  }
               }
            }

            if(Client.field311 != 0 && Client.gameCycle % 20 < 10) {
               if(Client.field311 == 1 && Client.field312 >= 0 && Client.field312 < Client.cachedNPCs.length) {
                  NPC var23 = Client.cachedNPCs[Client.field312];
                  if(var23 != null) {
                     var11 = var23.x / 32 - XItemContainer.localPlayer.x / 32;
                     var12 = var23.y / 32 - XItemContainer.localPlayer.y / 32;
                     class10.method130(var1, var2, var11, var12, class26.field593[1], var4);
                  }
               }

               if(Client.field311 == 2) {
                  var10 = 2 + (Client.field314 * 4 - class22.baseX * 4) - XItemContainer.localPlayer.x / 32;
                  var11 = 2 + (Client.field315 * 4 - class103.baseY * 4) - XItemContainer.localPlayer.y / 32;
                  class10.method130(var1, var2, var10, var11, class26.field593[1], var4);
               }

               if(Client.field311 == 10 && Client.field313 >= 0 && Client.field313 < Client.cachedPlayers.length) {
                  Player var24 = Client.cachedPlayers[Client.field313];
                  if(null != var24) {
                     var11 = var24.x / 32 - XItemContainer.localPlayer.x / 32;
                     var12 = var24.y / 32 - XItemContainer.localPlayer.y / 32;
                     class10.method130(var1, var2, var11, var12, class26.field593[1], var4);
                  }
               }
            }

            if(Client.flagX != 0) {
               var10 = 2 + Client.flagX * 4 - XItemContainer.localPlayer.x / 32;
               var11 = 2 + Client.flagY * 4 - XItemContainer.localPlayer.y / 32;
               NPC.method706(var1, var2, var10, var11, class26.field593[0], var4);
            }

            if(!XItemContainer.localPlayer.field257) {
               Rasterizer2D.method3876(var1 + var4.field2164 / 2 - 1, var4.field2165 / 2 + var2 - 1, 3, 3, 16777215);
            }
         } else {
            Rasterizer2D.method3856(var1, var2, 0, var4.field2172, var4.field2166);
         }

         Client.field294[var3] = true;
      }
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(IB)I",
      garbageValue = "21"
   )
   public static int method174(int var0) {
      Varbit var1 = class110.method2026(var0);
      int var2 = var1.leastSignificantBit;
      int var3 = var1.configId;
      int var4 = var1.mostSignificantBit;
      int var5 = class165.field2173[var4 - var3];
      return class165.widgetSettings[var2] >> var3 & var5;
   }
}
