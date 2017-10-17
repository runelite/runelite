import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("o")
public class class11 {
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Lo;"
   )
   public static final class11 field272;
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Lo;"
   )
   public static final class11 field270;

   static {
      field272 = new class11();
      field270 = new class11();
   }

   @ObfuscatedName("hj")
   @ObfuscatedSignature(
      signature = "(IIZB)V",
      garbageValue = "-47"
   )
   static final void method60(int var0, int var1, boolean var2) {
      if(!var2 || var0 != class43.field589 || Signlink.field2245 != var1) {
         class43.field589 = var0;
         Signlink.field2245 = var1;
         FrameMap.setGameState(25);
         class14.drawStatusBox("Loading - please wait.", true);
         int var3 = WallObject.baseX;
         int var4 = Varcs.baseY;
         WallObject.baseX = (var0 - 6) * 8;
         Varcs.baseY = (var1 - 6) * 8;
         int var5 = WallObject.baseX - var3;
         int var6 = Varcs.baseY - var4;
         var3 = WallObject.baseX;
         var4 = Varcs.baseY;

         int var7;
         int var9;
         for(var7 = 0; var7 < 32768; ++var7) {
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
         for(int var13 = var20; var13 != var18; var13 += var22) {
            for(var14 = var10; var14 != var11; var14 += var12) {
               int var15 = var13 + var5;
               int var16 = var6 + var14;

               for(int var17 = 0; var17 < 4; ++var17) {
                  if(var15 >= 0 && var16 >= 0 && var15 < 104 && var16 < 104) {
                     Client.groundItemDeque[var17][var13][var14] = Client.groundItemDeque[var17][var15][var16];
                  } else {
                     Client.groundItemDeque[var17][var13][var14] = null;
                  }
               }
            }
         }

         for(PendingSpawn var19 = (PendingSpawn)Client.pendingSpawns.getFront(); var19 != null; var19 = (PendingSpawn)Client.pendingSpawns.getNext()) {
            var19.x -= var5;
            var19.y -= var6;
            if(var19.x < 0 || var19.y < 0 || var19.x >= 104 || var19.y >= 104) {
               var19.unlink();
            }
         }

         if(Client.destinationX != 0) {
            Client.destinationX -= var5;
            Client.destinationY -= var6;
         }

         Client.field1154 = 0;
         Client.field1160 = false;
         Client.field1140 = -1;
         Client.graphicsObjectDeque.clear();
         Client.projectiles.clear();

         for(var14 = 0; var14 < 4; ++var14) {
            Client.collisionMaps[var14].reset();
         }

      }
   }
}
