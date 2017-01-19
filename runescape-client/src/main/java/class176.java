import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fc")
public final class class176 {
   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(ZZS)I",
      garbageValue = "1000"
   )
   public static int method3154(boolean var0, boolean var1) {
      byte var2 = 0;
      int var3 = var2 + class185.field2751 + class185.field2753;
      return var3;
   }

   @ObfuscatedName("bt")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "116"
   )
   static final void method3155() {
      for(Projectile var0 = (Projectile)Client.projectiles.method2330(); var0 != null; var0 = (Projectile)Client.projectiles.method2346()) {
         if(var0.floor == class118.plane && Client.gameCycle <= var0.field872) {
            if(Client.gameCycle >= var0.startTime) {
               if(var0.interacting > 0) {
                  NPC var1 = Client.cachedNPCs[var0.interacting - 1];
                  if(null != var1 && var1.x >= 0 && var1.x < 13312 && var1.y >= 0 && var1.y < 13312) {
                     var0.method759(var1.x, var1.y, XClanMember.method223(var1.x, var1.y, var0.floor) - var0.field856, Client.gameCycle);
                  }
               }

               if(var0.interacting < 0) {
                  int var2 = -var0.interacting - 1;
                  Player var3;
                  if(var2 == Client.localInteractingIndex) {
                     var3 = XItemContainer.localPlayer;
                  } else {
                     var3 = Client.cachedPlayers[var2];
                  }

                  if(var3 != null && var3.x >= 0 && var3.x < 13312 && var3.y >= 0 && var3.y < 13312) {
                     var0.method759(var3.x, var3.y, XClanMember.method223(var3.x, var3.y, var0.floor) - var0.field856, Client.gameCycle);
                  }
               }

               var0.method758(Client.field533);
               class0.region.method1713(class118.plane, (int)var0.x, (int)var0.velocityZ, (int)var0.z, 60, var0, var0.field871, -1, false);
            }
         } else {
            var0.unlink();
         }
      }

   }
}
