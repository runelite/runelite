import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hg")
public class class224 {
   @ObfuscatedName("gv")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "6"
   )
   static final void method4097() {
      for(PendingSpawn var0 = (PendingSpawn)Client.pendingSpawns.method3622(); var0 != null; var0 = (PendingSpawn)Client.pendingSpawns.method3608()) {
         if(var0.hitpoints > 0) {
            --var0.hitpoints;
         }

         if(var0.hitpoints == 0) {
            if(var0.field1202 < 0 || class24.method203(var0.field1202, var0.field1214)) {
               class35.method492(var0.level, var0.type, var0.x, var0.y, var0.field1202, var0.field1211, var0.field1214);
               var0.unlink();
            }
         } else {
            if(var0.delay > 0) {
               --var0.delay;
            }

            if(var0.delay == 0 && var0.x >= 1 && var0.y >= 1 && var0.x <= 102 && var0.y <= 102 && (var0.id < 0 || class24.method203(var0.id, var0.field1207))) {
               class35.method492(var0.level, var0.type, var0.x, var0.y, var0.id, var0.orientation, var0.field1207);
               var0.delay = -1;
               if(var0.field1202 == var0.id && var0.field1202 == -1) {
                  var0.unlink();
               } else if(var0.id == var0.field1202 && var0.field1211 == var0.orientation && var0.field1207 == var0.field1214) {
                  var0.unlink();
               }
            }
         }
      }

   }
}
