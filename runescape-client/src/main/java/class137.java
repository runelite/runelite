import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("em")
public class class137 {
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Laz;"
   )
   static class47 field1992;

   @ObfuscatedName("hj")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-2031110441"
   )
   static final void method2993() {
      for(PendingSpawn var0 = (PendingSpawn)Client.pendingSpawns.getFront(); var0 != null; var0 = (PendingSpawn)Client.pendingSpawns.getNext()) {
         if(var0.hitpoints > 0) {
            --var0.hitpoints;
         }

         if(var0.hitpoints == 0) {
            if(var0.field1086 < 0 || class70.method1117(var0.field1086, var0.field1087)) {
               Tile.method2653(var0.level, var0.type, var0.x, var0.y, var0.field1086, var0.field1084, var0.field1087);
               var0.unlink();
            }
         } else {
            if(var0.delay > 0) {
               --var0.delay;
            }

            if(var0.delay == 0 && var0.x >= 1 && var0.y >= 1 && var0.x <= 102 && var0.y <= 102 && (var0.id < 0 || class70.method1117(var0.id, var0.field1091))) {
               Tile.method2653(var0.level, var0.type, var0.x, var0.y, var0.id, var0.orientation, var0.field1091);
               var0.delay = -1;
               if(var0.field1086 == var0.id && var0.field1086 == -1) {
                  var0.unlink();
               } else if(var0.field1086 == var0.id && var0.field1084 == var0.orientation && var0.field1087 == var0.field1091) {
                  var0.unlink();
               }
            }
         }
      }

   }
}
