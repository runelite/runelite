import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gb")
public class class184 {
   @ObfuscatedName("v")
   static Thread field2516;
   @ObfuscatedName("db")
   @ObfuscatedGetter(
      intValue = -712343249
   )
   @Export("myWorldPort")
   static int myWorldPort;

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Lid;Lid;Lid;I)V",
      garbageValue = "1441176455"
   )
   public static void method3551(IndexDataBase var0, IndexDataBase var1, IndexDataBase var2) {
      class261.field3498 = var0;
      class2.field15 = var1;
      class261.field3477 = var2;
   }

   @ObfuscatedName("gn")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-2141298635"
   )
   static final void method3543() {
      for(Projectile var0 = (Projectile)Client.projectiles.getFront(); var0 != null; var0 = (Projectile)Client.projectiles.getNext()) {
         if(var0.floor == class233.plane && Client.gameCycle <= var0.cycle) {
            if(Client.gameCycle >= var0.startTime) {
               if(var0.interacting > 0) {
                  NPC var1 = Client.cachedNPCs[var0.interacting - 1];
                  if(var1 != null && var1.x >= 0 && var1.x < 13312 && var1.y >= 0 && var1.y < 13312) {
                     var0.method1816(var1.x, var1.y, class41.getTileHeight(var1.x, var1.y, var0.floor) - var0.endHeight, Client.gameCycle);
                  }
               }

               if(var0.interacting < 0) {
                  int var2 = -var0.interacting - 1;
                  Player var3;
                  if(var2 == Client.localInteractingIndex) {
                     var3 = class181.localPlayer;
                  } else {
                     var3 = Client.cachedPlayers[var2];
                  }

                  if(var3 != null && var3.x >= 0 && var3.x < 13312 && var3.y >= 0 && var3.y < 13312) {
                     var0.method1816(var3.x, var3.y, class41.getTileHeight(var3.x, var3.y, var0.floor) - var0.endHeight, Client.gameCycle);
                  }
               }

               var0.method1817(Client.field992);
               class14.region.method2808(class233.plane, (int)var0.x, (int)var0.velocityZ, (int)var0.z, 60, var0, var0.rotationX, -1, false);
            }
         } else {
            var0.unlink();
         }
      }

   }
}
