import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("v")
public final class class9 {
   @ObfuscatedName("ex")
   static ModIcon[] field81;
   @ObfuscatedName("rg")
   protected static boolean field83;
   @ObfuscatedName("c")
   public static class72[] field84;
   @ObfuscatedName("ee")
   static SpritePixels[] field85;
   @ObfuscatedName("bc")
   @ObfuscatedGetter(
      intValue = -1014296119
   )
   static int field87;

   @ObfuscatedName("be")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "-9"
   )
   static final void method99(int var0, int var1) {
      if(MessageNode.field227 != var0 || var1 != Client.field503) {
         MessageNode.field227 = var0;
         Client.field503 = var1;
         XGrandExchangeOffer.setGameState(25);
         Frames.method1868("Loading - please wait.", true);
         int var2 = class15.baseX;
         int var3 = class20.baseY;
         class15.baseX = (var0 - 6) * 8;
         class20.baseY = (var1 - 6) * 8;
         int var4 = class15.baseX - var2;
         int var5 = class20.baseY - var3;
         var2 = class15.baseX;
         var3 = class20.baseY;

         int var6;
         int var8;
         for(var6 = 0; var6 < '耀'; ++var6) {
            NPC var7 = Client.cachedNPCs[var6];
            if(var7 != null) {
               for(var8 = 0; var8 < 10; ++var8) {
                  var7.pathX[var8] -= var4;
                  var7.pathY[var8] -= var5;
               }

               var7.x -= 128 * var4;
               var7.y -= var5 * 128;
            }
         }

         for(var6 = 0; var6 < 2048; ++var6) {
            Player var20 = Client.cachedPlayers[var6];
            if(var20 != null) {
               for(var8 = 0; var8 < 10; ++var8) {
                  var20.pathX[var8] -= var4;
                  var20.pathY[var8] -= var5;
               }

               var20.x -= var4 * 128;
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
         for(int var12 = var19; var17 != var12; var12 += var21) {
            for(var13 = var9; var13 != var10; var13 += var11) {
               int var14 = var4 + var12;
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

         for(class25 var18 = (class25)Client.field370.method2359(); var18 != null; var18 = (class25)Client.field370.method2361()) {
            var18.field574 -= var4;
            var18.field581 -= var5;
            if(var18.field574 < 0 || var18.field581 < 0 || var18.field574 >= 104 || var18.field581 >= 104) {
               var18.unlink();
            }
         }

         if(Client.flagX != 0) {
            Client.flagX -= var4;
            Client.flagY -= var5;
         }

         Client.field528 = 0;
         Client.field534 = false;
         Client.field515 = -1;
         Client.field422.method2353();
         Client.projectiles.method2353();

         for(var13 = 0; var13 < 4; ++var13) {
            Client.collisionMaps[var13].method2210();
         }

      }
   }

   @ObfuscatedName("bo")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-53"
   )
   static void method101() {
      if(Client.field523) {
         Widget var0 = class26.method561(MessageNode.field232, Client.field442);
         if(null != var0 && null != var0.field2296) {
            class18 var1 = new class18();
            var1.field187 = var0;
            var1.field188 = var0.field2296;
            Ignore.method191(var1);
         }

         Client.field523 = false;
         class94.method1890(var0);
      }
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(Lclass182;II)LModIcon;",
      garbageValue = "-375055152"
   )
   public static ModIcon method102(class182 var0, int var1) {
      return !PlayerComposition.method3074(var0, var1)?null:class156.method2963();
   }
}
