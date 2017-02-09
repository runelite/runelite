import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("p")
public class class16 extends class131 {
   @ObfuscatedName("y")
   String field167;
   @ObfuscatedName("d")
   static class178 field170;
   @ObfuscatedName("fo")
   @ObfuscatedGetter(
      intValue = -1666790629
   )
   @Export("cameraY")
   static int cameraY;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 171678197
   )
   int field173 = (int)(class22.method224() / 1000L);
   @ObfuscatedName("ax")
   static class102 field174;
   @ObfuscatedName("o")
   short field175;
   @ObfuscatedName("cd")
   static Font field176;

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "304911780"
   )
   public static boolean method197(int var0) {
      return (var0 >> 20 & 1) != 0;
   }

   @ObfuscatedName("ch")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "-1996689870"
   )
   static final boolean method198(int var0) {
      if(var0 < 0) {
         return false;
      } else {
         int var1 = Client.menuTypes[var0];
         if(var1 >= 2000) {
            var1 -= 2000;
         }

         return var1 == 1007;
      }
   }

   @ObfuscatedName("bc")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "-33"
   )
   static final void method199(int var0, int var1) {
      if(Actor.field650 != var0 || class2.field25 != var1) {
         Actor.field650 = var0;
         class2.field25 = var1;
         class11.setGameState(25);
         class101.method1940("Loading - please wait.", true);
         int var2 = class114.baseX;
         int var3 = CombatInfo1.baseY;
         class114.baseX = (var0 - 6) * 8;
         CombatInfo1.baseY = (var1 - 6) * 8;
         int var4 = class114.baseX - var2;
         int var5 = CombatInfo1.baseY - var3;
         var2 = class114.baseX;
         var3 = CombatInfo1.baseY;

         int var6;
         int var8;
         for(var6 = 0; var6 < '耀'; ++var6) {
            NPC var7 = Client.cachedNPCs[var6];
            if(var7 != null) {
               for(var8 = 0; var8 < 10; ++var8) {
                  var7.pathX[var8] -= var4;
                  var7.pathY[var8] -= var5;
               }

               var7.x -= var4 * 128;
               var7.y -= var5 * 128;
            }
         }

         for(var6 = 0; var6 < 2048; ++var6) {
            Player var20 = Client.cachedPlayers[var6];
            if(null != var20) {
               for(var8 = 0; var8 < 10; ++var8) {
                  var20.pathX[var8] -= var4;
                  var20.pathY[var8] -= var5;
               }

               var20.x -= 128 * var4;
               var20.y -= 128 * var5;
            }
         }

         byte var19 = 0;
         byte var17 = 104;
         byte var21 = 1;
         if(var4 < 0) {
            var19 = 103;
            var17 = -1;
            var21 = -1;
         }

         byte var9 = 0;
         byte var10 = 104;
         byte var11 = 1;
         if(var5 < 0) {
            var9 = 103;
            var10 = -1;
            var11 = -1;
         }

         int var13;
         for(int var18 = var19; var18 != var17; var18 += var21) {
            for(var13 = var9; var10 != var13; var13 += var11) {
               int var14 = var18 + var4;
               int var15 = var13 + var5;

               for(int var16 = 0; var16 < 4; ++var16) {
                  if(var14 >= 0 && var15 >= 0 && var14 < 104 && var15 < 104) {
                     Client.groundItemDeque[var16][var18][var13] = Client.groundItemDeque[var16][var14][var15];
                  } else {
                     Client.groundItemDeque[var16][var18][var13] = null;
                  }
               }
            }
         }

         for(class25 var12 = (class25)Client.field300.method2403(); var12 != null; var12 = (class25)Client.field300.method2398()) {
            var12.field564 -= var4;
            var12.field565 -= var5;
            if(var12.field564 < 0 || var12.field565 < 0 || var12.field564 >= 104 || var12.field565 >= 104) {
               var12.unlink();
            }
         }

         if(Client.flagX != 0) {
            Client.flagX -= var4;
            Client.flagY -= var5;
         }

         Client.field461 = 0;
         Client.field526 = false;
         Client.field382 = -1;
         Client.field411.method2379();
         Client.projectiles.method2379();

         for(var13 = 0; var13 < 4; ++var13) {
            Client.collisionMaps[var13].method2240();
         }

      }
   }

   class16(String var1, int var2) {
      this.field167 = var1;
      this.field175 = (short)var2;
   }
}
