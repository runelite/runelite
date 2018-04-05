import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fk")
public class class177 {
   @ObfuscatedName("t")
   static int[][] field2285;
   @ObfuscatedName("d")
   static int[][] field2286;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -308985347
   )
   static int field2283;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 1971655173
   )
   static int field2289;
   @ObfuscatedName("i")
   static int[] field2290;
   @ObfuscatedName("u")
   static int[] field2287;

   static {
      field2285 = new int[128][128];
      field2286 = new int[128][128];
      field2290 = new int[4096];
      field2287 = new int[4096];
   }

   @ObfuscatedName("gq")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "20"
   )
   static final void method3427() {
      for(Projectile var0 = (Projectile)Client.projectiles.getFront(); var0 != null; var0 = (Projectile)Client.projectiles.getNext()) {
         if(var0.floor == BoundingBox3DDrawMode.plane && Client.gameCycle <= var0.endCycle) {
            if(Client.gameCycle >= var0.startMovementCycle) {
               if(var0.interacting > 0) {
                  NPC var1 = Client.cachedNPCs[var0.interacting - 1];
                  if(var1 != null && var1.x >= 0 && var1.x < 13312 && var1.y >= 0 && var1.y < 13312) {
                     var0.moveProjectile(var1.x, var1.y, class265.getTileHeight(var1.x, var1.y, var0.floor) - var0.endHeight, Client.gameCycle);
                  }
               }

               if(var0.interacting < 0) {
                  int var2 = -var0.interacting - 1;
                  Player var3;
                  if(var2 == Client.localInteractingIndex) {
                     var3 = SoundTaskDataProvider.localPlayer;
                  } else {
                     var3 = Client.cachedPlayers[var2];
                  }

                  if(var3 != null && var3.x >= 0 && var3.x < 13312 && var3.y >= 0 && var3.y < 13312) {
                     var0.moveProjectile(var3.x, var3.y, class265.getTileHeight(var3.x, var3.y, var0.floor) - var0.endHeight, Client.gameCycle);
                  }
               }

               var0.update(Client.field930);
               class255.region.method2863(BoundingBox3DDrawMode.plane, (int)var0.x, (int)var0.y, (int)var0.z, 60, var0, var0.rotationX, -1, false);
            }
         } else {
            var0.unlink();
         }
      }

   }
}
