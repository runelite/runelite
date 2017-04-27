import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("en")
public class class131 {
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      longValue = 6281806546656595249L
   )
   static long field1972;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      longValue = 8706612570538429603L
   )
   static long field1973;
   @ObfuscatedName("os")
   @ObfuscatedGetter(
      intValue = 469591239
   )
   static int field1974;

   class131() throws Throwable {
      throw new Error();
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(CI)Z",
      garbageValue = "-2050174090"
   )
   public static boolean method2609(char var0) {
      return var0 >= 48 && var0 <= 57;
   }

   @ObfuscatedName("dn")
   @ObfuscatedSignature(
      signature = "(LWidget;I)V",
      garbageValue = "1276171506"
   )
   static final void method2612(Widget var0) {
      int var1 = var0.contentType;
      if(var1 == 324) {
         if(Client.field560 == -1) {
            Client.field560 = var0.textureId;
            Client.field561 = var0.field2243;
         }

         if(Client.field559.isFemale) {
            var0.textureId = Client.field560;
         } else {
            var0.textureId = Client.field561;
         }

      } else if(var1 == 325) {
         if(Client.field560 == -1) {
            Client.field560 = var0.textureId;
            Client.field561 = var0.field2243;
         }

         if(Client.field559.isFemale) {
            var0.textureId = Client.field561;
         } else {
            var0.textureId = Client.field560;
         }

      } else if(var1 == 327) {
         var0.rotationX = 150;
         var0.rotationZ = (int)(Math.sin((double)Client.gameCycle / 40.0D) * 256.0D) & 2047;
         var0.modelType = 5;
         var0.modelId = 0;
      } else if(var1 == 328) {
         var0.rotationX = 150;
         var0.rotationZ = (int)(Math.sin((double)Client.gameCycle / 40.0D) * 256.0D) & 2047;
         var0.modelType = 5;
         var0.modelId = 1;
      }
   }

   @ObfuscatedName("bf")
   @ObfuscatedSignature(
      signature = "(IIZI)V",
      garbageValue = "-1980361831"
   )
   static final void method2613(int var0, int var1, boolean var2) {
      if(!var2 || var0 != Actor.field619 || class180.field2680 != var1) {
         Actor.field619 = var0;
         class180.field2680 = var1;
         class9.setGameState(25);
         class38.method769("Loading - please wait.", true);
         int var3 = class108.baseX;
         int var4 = GameEngine.baseY;
         class108.baseX = (var0 - 6) * 8;
         GameEngine.baseY = (var1 - 6) * 8;
         int var5 = class108.baseX - var3;
         int var6 = GameEngine.baseY - var4;
         var3 = class108.baseX;
         var4 = GameEngine.baseY;

         int var7;
         int var9;
         for(var7 = 0; var7 < '耀'; ++var7) {
            NPC var8 = Client.cachedNPCs[var7];
            if(var8 != null) {
               for(var9 = 0; var9 < 10; ++var9) {
                  var8.pathX[var9] -= var5;
                  var8.pathY[var9] -= var6;
               }

               var8.x -= var5 * 128;
               var8.y -= var6 * 128;
            }
         }

         for(var7 = 0; var7 < 2048; ++var7) {
            Player var21 = Client.cachedPlayers[var7];
            if(var21 != null) {
               for(var9 = 0; var9 < 10; ++var9) {
                  var21.pathX[var9] -= var5;
                  var21.pathY[var9] -= var6;
               }

               var21.x -= var5 * 128;
               var21.y -= var6 * 128;
            }
         }

         byte var20 = 0;
         byte var18 = 104;
         byte var22 = 1;
         if(var5 < 0) {
            var20 = 103;
            var18 = -1;
            var22 = -1;
         }

         byte var10 = 0;
         byte var11 = 104;
         byte var12 = 1;
         if(var6 < 0) {
            var10 = 103;
            var11 = -1;
            var12 = -1;
         }

         int var14;
         for(int var19 = var20; var18 != var19; var19 += var22) {
            for(var14 = var10; var11 != var14; var14 += var12) {
               int var15 = var19 + var5;
               int var16 = var6 + var14;

               for(int var17 = 0; var17 < 4; ++var17) {
                  if(var15 >= 0 && var16 >= 0 && var15 < 104 && var16 < 104) {
                     Client.groundItemDeque[var17][var19][var14] = Client.groundItemDeque[var17][var15][var16];
                  } else {
                     Client.groundItemDeque[var17][var19][var14] = null;
                  }
               }
            }
         }

         for(class25 var13 = (class25)Client.field415.method2828(); var13 != null; var13 = (class25)Client.field415.method2830()) {
            var13.field573 -= var5;
            var13.field574 -= var6;
            if(var13.field573 < 0 || var13.field574 < 0 || var13.field573 >= 104 || var13.field574 >= 104) {
               var13.unlink();
            }
         }

         if(Client.flagX != 0) {
            Client.flagX -= var5;
            Client.flagY -= var6;
         }

         Client.field528 = 0;
         Client.field534 = false;
         Client.field515 = -1;
         Client.field531.method2823();
         Client.projectiles.method2823();

         for(var14 = 0; var14 < 4; ++var14) {
            Client.collisionMaps[var14].method2250();
         }

      }
   }
}
