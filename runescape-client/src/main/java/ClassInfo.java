import java.lang.reflect.Field;
import java.lang.reflect.Method;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ji")
@Implements("ClassInfo")
public class ClassInfo extends Node {
   @ObfuscatedName("ah")
   @ObfuscatedGetter(
      intValue = -1999353723
   )
   @Export("authCodeForLogin")
   static int authCodeForLogin;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -1933020291
   )
   int field3737;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -1935105849
   )
   @Export("count")
   int count;
   @ObfuscatedName("x")
   @Export("errorIdentifiers")
   int[] errorIdentifiers;
   @ObfuscatedName("p")
   @Export("type")
   int[] type;
   @ObfuscatedName("g")
   @Export("fields")
   Field[] fields;
   @ObfuscatedName("f")
   int[] field3734;
   @ObfuscatedName("c")
   @Export("methods")
   Method[] methods;
   @ObfuscatedName("l")
   @Export("args")
   byte[][][] args;

   @ObfuscatedName("gf")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1883293878"
   )
   static final void method4943() {
      for(Projectile var0 = (Projectile)Client.projectiles.getFront(); var0 != null; var0 = (Projectile)Client.projectiles.getNext()) {
         if(var0.floor == class35.plane && Client.gameCycle <= var0.cycle) {
            if(Client.gameCycle >= var0.startTime) {
               if(var0.interacting > 0) {
                  NPC var1 = Client.cachedNPCs[var0.interacting - 1];
                  if(var1 != null && var1.x >= 0 && var1.x < 13312 && var1.y >= 0 && var1.y < 13312) {
                     var0.method1768(var1.x, var1.y, class25.getTileHeight(var1.x, var1.y, var0.floor) - var0.endHeight, Client.gameCycle);
                  }
               }

               if(var0.interacting < 0) {
                  int var2 = -var0.interacting - 1;
                  Player var3;
                  if(var2 == Client.localInteractingIndex) {
                     var3 = GrandExchangeOffer.localPlayer;
                  } else {
                     var3 = Client.cachedPlayers[var2];
                  }

                  if(var3 != null && var3.x >= 0 && var3.x < 13312 && var3.y >= 0 && var3.y < 13312) {
                     var0.method1768(var3.x, var3.y, class25.getTileHeight(var3.x, var3.y, var0.floor) - var0.endHeight, Client.gameCycle);
                  }
               }

               var0.method1769(Client.field957);
               class36.region.method2713(class35.plane, (int)var0.x, (int)var0.velocityZ, (int)var0.z, 60, var0, var0.rotationX, -1, false);
            }
         } else {
            var0.unlink();
         }
      }

   }
}
