import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("aj")
public class class38 {
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -544511557
   )
   int field816;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 857373153
   )
   int field817;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -583921789
   )
   int field818;
   @ObfuscatedName("j")
   String field819;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -755711437
   )
   int field820;
   @ObfuscatedName("bo")
   static class184 field821;

   @ObfuscatedName("al")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1646862292"
   )
   static final void method823() {
      for(Projectile var0 = (Projectile)Client.projectiles.method2458(); var0 != null; var0 = (Projectile)Client.projectiles.method2472()) {
         if(WallObject.plane == var0.floor && Client.gameCycle <= var0.field877) {
            if(Client.gameCycle >= var0.startTime) {
               if(var0.interacting > 0) {
                  NPC var1 = Client.cachedNPCs[var0.interacting - 1];
                  if(null != var1 && var1.x >= 0 && var1.x < 13312 && var1.y >= 0 && var1.y < 13312) {
                     var0.method867(var1.x, var1.y, class2.method19(var1.x, var1.y, var0.floor) - var0.field881, Client.gameCycle);
                  }
               }

               if(var0.interacting < 0) {
                  int var2 = -var0.interacting - 1;
                  Player var3;
                  if(var2 == Client.localInteractingIndex) {
                     var3 = class36.localPlayer;
                  } else {
                     var3 = Client.cachedPlayers[var2];
                  }

                  if(null != var3 && var3.x >= 0 && var3.x < 13312 && var3.y >= 0 && var3.y < 13312) {
                     var0.method867(var3.x, var3.y, class2.method19(var3.x, var3.y, var0.floor) - var0.field881, Client.gameCycle);
                  }
               }

               var0.method868(Client.field498);
               class48.region.method1758(WallObject.plane, (int)var0.x, (int)var0.velocityZ, (int)var0.z, 60, var0, var0.field882, -1, false);
            }
         } else {
            var0.unlink();
         }
      }

   }
}
