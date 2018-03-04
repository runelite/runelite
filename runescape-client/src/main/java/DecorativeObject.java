import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("eq")
@Implements("DecorativeObject")
public final class DecorativeObject {
   @ObfuscatedName("et")
   @ObfuscatedSignature(
      signature = "Lkw;"
   )
   @Export("fontBold12")
   static Font fontBold12;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 561761587
   )
   @Export("floor")
   int floor;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -1347282307
   )
   @Export("renderFlag")
   int renderFlag;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 1782602161
   )
   @Export("x")
   int x;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -400467123
   )
   @Export("y")
   int y;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -925425775
   )
   @Export("rotation")
   int rotation;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -2111990655
   )
   @Export("offsetX")
   int offsetX;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -49176267
   )
   @Export("offsetY")
   int offsetY;
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Leb;"
   )
   @Export("renderable1")
   public Renderable renderable1;
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Leb;"
   )
   @Export("renderable2")
   public Renderable renderable2;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -1836374149
   )
   @Export("hash")
   public int hash;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 1678700317
   )
   @Export("renderInfoBitPacked")
   int renderInfoBitPacked;

   DecorativeObject() {
      this.hash = 0;
      this.renderInfoBitPacked = 0;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)[Liz;",
      garbageValue = "657959905"
   )
   static BuildType[] method3165() {
      return new BuildType[]{BuildType.LIVE, BuildType.WIP, BuildType.RC, BuildType.BUILD_LIVE};
   }

   @ObfuscatedName("fb")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "2118680182"
   )
   static final void method3164() {
      for(Projectile var0 = (Projectile)Client.projectiles.getFront(); var0 != null; var0 = (Projectile)Client.projectiles.getNext()) {
         if(var0.floor == class36.plane && Client.gameCycle <= var0.endCycle) {
            if(Client.gameCycle >= var0.startMovementCycle) {
               if(var0.interacting > 0) {
                  NPC var1 = Client.cachedNPCs[var0.interacting - 1];
                  if(var1 != null && var1.x >= 0 && var1.x < 13312 && var1.y >= 0 && var1.y < 13312) {
                     var0.moveProjectile(var1.x, var1.y, class35.getTileHeight(var1.x, var1.y, var0.floor) - var0.endHeight, Client.gameCycle);
                  }
               }

               if(var0.interacting < 0) {
                  int var2 = -var0.interacting - 1;
                  Player var3;
                  if(var2 == Client.localInteractingIndex) {
                     var3 = TotalQuantityComparator.localPlayer;
                  } else {
                     var3 = Client.cachedPlayers[var2];
                  }

                  if(var3 != null && var3.x >= 0 && var3.x < 13312 && var3.y >= 0 && var3.y < 13312) {
                     var0.moveProjectile(var3.x, var3.y, class35.getTileHeight(var3.x, var3.y, var0.floor) - var0.endHeight, Client.gameCycle);
                  }
               }

               var0.update(Client.field914);
               class86.region.method3026(class36.plane, (int)var0.x, (int)var0.y, (int)var0.z, 60, var0, var0.rotationX, -1, false);
            }
         } else {
            var0.unlink();
         }
      }

   }
}
