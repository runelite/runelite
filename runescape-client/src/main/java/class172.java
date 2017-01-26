import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fn")
public class class172 {
   @ObfuscatedName("x")
   public static int[] field2345 = new int[99];
   @ObfuscatedName("g")
   public static final boolean[] field2350 = new boolean[]{true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, false, false};

   @ObfuscatedName("ch")
   @ObfuscatedSignature(
      signature = "(LWidget;B)V",
      garbageValue = "45"
   )
   static void method3239(Widget var0) {
      Widget var1 = var0.parentId == -1?null:class37.method736(var0.parentId);
      int var2;
      int var3;
      if(null == var1) {
         var2 = class26.field577;
         var3 = class187.field2776;
      } else {
         var2 = var1.width;
         var3 = var1.height;
      }

      ChatMessages.method861(var0, var2, var3, false);
      class189.method3451(var0, var2, var3);
   }

   static {
      int var0 = 0;

      for(int var1 = 0; var1 < 99; ++var1) {
         int var2 = 1 + var1;
         int var3 = (int)((double)var2 + 300.0D * Math.pow(2.0D, (double)var2 / 7.0D));
         var0 += var3;
         field2345[var1] = var0 / 4;
      }

   }

   class172() throws Throwable {
      throw new Error();
   }

   @ObfuscatedName("aq")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1600842902"
   )
   static final void method3240() {
      for(Projectile var0 = (Projectile)Client.projectiles.method2412(); var0 != null; var0 = (Projectile)Client.projectiles.method2426()) {
         if(WallObject.plane == var0.floor && Client.gameCycle <= var0.field861) {
            if(Client.gameCycle >= var0.startTime) {
               if(var0.interacting > 0) {
                  NPC var1 = Client.cachedNPCs[var0.interacting - 1];
                  if(var1 != null && var1.x >= 0 && var1.x < 13312 && var1.y >= 0 && var1.y < 13312) {
                     var0.method774(var1.x, var1.y, class65.method1153(var1.x, var1.y, var0.floor) - var0.field859, Client.gameCycle);
                  }
               }

               if(var0.interacting < 0) {
                  int var2 = -var0.interacting - 1;
                  Player var3;
                  if(var2 == Client.localInteractingIndex) {
                     var3 = class16.localPlayer;
                  } else {
                     var3 = Client.cachedPlayers[var2];
                  }

                  if(null != var3 && var3.x >= 0 && var3.x < 13312 && var3.y >= 0 && var3.y < 13312) {
                     var0.method774(var3.x, var3.y, class65.method1153(var3.x, var3.y, var0.floor) - var0.field859, Client.gameCycle);
                  }
               }

               var0.method775(Client.field354);
               Renderable.region.method1710(WallObject.plane, (int)var0.x, (int)var0.velocityZ, (int)var0.z, 60, var0, var0.field854, -1, false);
            }
         } else {
            var0.unlink();
         }
      }

   }
}
