import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("u")
@Implements("Friend")
public class Friend {
   @ObfuscatedName("r")
   @Export("previousName")
   String previousName;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -2051765091
   )
   @Export("world")
   int world;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 1484156943
   )
   @Export("rank")
   int rank;
   @ObfuscatedName("x")
   @Export("name")
   String name;
   @ObfuscatedName("b")
   boolean field252;
   @ObfuscatedName("ak")
   static class149 field254;
   @ObfuscatedName("bp")
   static class171 field255;
   @ObfuscatedName("i")
   boolean field256;

   @ObfuscatedName("bf")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-2135961560"
   )
   static final void method192(int var0, int var1) {
      if(var0 != Tile.field1789 || var1 != class191.field3084) {
         Tile.field1789 = var0;
         class191.field3084 = var1;
         class130.setGameState(25);
         KitDefinition.method941("Loading - please wait.", true);
         int var2 = class28.baseX;
         int var3 = class159.baseY;
         class28.baseX = (var0 - 6) * 8;
         class159.baseY = (var1 - 6) * 8;
         int var4 = class28.baseX - var2;
         int var5 = class159.baseY - var3;
         var2 = class28.baseX;
         var3 = class159.baseY;

         int var6;
         int var8;
         for(var6 = 0; var6 < '耀'; ++var6) {
            NPC var7 = Client.cachedNPCs[var6];
            if(null != var7) {
               for(var8 = 0; var8 < 10; ++var8) {
                  var7.pathX[var8] -= var4;
                  var7.pathY[var8] -= var5;
               }

               var7.x -= 128 * var4;
               var7.y -= 128 * var5;
            }
         }

         for(var6 = 0; var6 < 2048; ++var6) {
            Player var20 = Client.cachedPlayers[var6];
            if(var20 != null) {
               for(var8 = 0; var8 < 10; ++var8) {
                  var20.pathX[var8] -= var4;
                  var20.pathY[var8] -= var5;
               }

               var20.x -= 128 * var4;
               var20.y -= var5 * 128;
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
         for(int var12 = var19; var12 != var17; var12 += var21) {
            for(var13 = var9; var13 != var10; var13 += var11) {
               int var14 = var12 + var4;
               int var15 = var13 + var5;

               for(int var16 = 0; var16 < 4; ++var16) {
                  if(var14 >= 0 && var15 >= 0 && var14 < 104 && var15 < 104) {
                     Client.groundItemDeque[var16][var12][var13] = Client.groundItemDeque[var16][var14][var15];
                  } else {
                     Client.groundItemDeque[var16][var12][var13] = null;
                  }
               }
            }
         }

         for(class16 var18 = (class16)Client.field413.method3850(); var18 != null; var18 = (class16)Client.field413.method3852()) {
            var18.field244 -= var4;
            var18.field235 -= var5;
            if(var18.field244 < 0 || var18.field235 < 0 || var18.field244 >= 104 || var18.field235 >= 104) {
               var18.unlink();
            }
         }

         if(Client.flagX != 0) {
            Client.flagX -= var4;
            Client.flagY -= var5;
         }

         Client.field521 = 0;
         Client.field418 = false;
         Client.field435 = -1;
         Client.field357.method3855();
         Client.projectiles.method3855();

         for(var13 = 0; var13 < 4; ++var13) {
            Client.collisionMaps[var13].method2442();
         }

      }
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1192759151"
   )
   public static void method193() {
      class79.field1421 = null;
      class79.field1423 = null;
      class20.field567 = null;
      class79.field1424 = null;
      class79.field1425 = null;
      class13.field191 = null;
   }
}
