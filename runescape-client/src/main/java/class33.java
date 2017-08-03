import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ai")
public class class33 {
   @ObfuscatedName("eg")
   @ObfuscatedGetter(
      intValue = 1726771343
   )
   @Export("baseX")
   static int baseX;
   @ObfuscatedName("d")
   String field444;
   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "Lz;"
   )
   class24 field443;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -1007272797
   )
   int field441;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -1858183057
   )
   int field442;

   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;IILz;)V"
   )
   class33(String var1, int var2, int var3, class24 var4) {
      this.field444 = var1;
      this.field441 = var2;
      this.field442 = var3;
      this.field443 = var4;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Lgc;ILjava/lang/String;B)Ljava/lang/String;",
      garbageValue = "8"
   )
   static String method356(IterableHashTable var0, int var1, String var2) {
      if(var0 == null) {
         return var2;
      } else {
         ObjectNode var3 = (ObjectNode)var0.get((long)var1);
         return var3 == null?var2:(String)var3.value;
      }
   }

   @ObfuscatedName("gs")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "66"
   )
   static final void method355() {
      for(Projectile var0 = (Projectile)Client.projectiles.getFront(); var0 != null; var0 = (Projectile)Client.projectiles.getNext()) {
         if(var0.floor == class8.plane && Client.gameCycle <= var0.cycle) {
            if(Client.gameCycle >= var0.startTime) {
               if(var0.interacting > 0) {
                  NPC var1 = Client.cachedNPCs[var0.interacting - 1];
                  if(var1 != null && var1.x >= 0 && var1.x < 13312 && var1.y >= 0 && var1.y < 13312) {
                     var0.method1765(var1.x, var1.y, class18.getTileHeight(var1.x, var1.y, var0.floor) - var0.endHeight, Client.gameCycle);
                  }
               }

               if(var0.interacting < 0) {
                  int var2 = -var0.interacting - 1;
                  Player var3;
                  if(var2 == Client.localInteractingIndex) {
                     var3 = class224.localPlayer;
                  } else {
                     var3 = Client.cachedPlayers[var2];
                  }

                  if(var3 != null && var3.x >= 0 && var3.x < 13312 && var3.y >= 0 && var3.y < 13312) {
                     var0.method1765(var3.x, var3.y, class18.getTileHeight(var3.x, var3.y, var0.floor) - var0.endHeight, Client.gameCycle);
                  }
               }

               var0.method1774(Client.field1078);
               class51.region.method2711(class8.plane, (int)var0.x, (int)var0.velocityZ, (int)var0.z, 60, var0, var0.rotationX, -1, false);
            }
         } else {
            var0.unlink();
         }
      }

   }
}
