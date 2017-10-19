import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hp")
public class class222 {
   @ObfuscatedName("s")
   public static final boolean[] field2827;
   @ObfuscatedName("q")
   public static int[] field2826;

   static {
      field2827 = new boolean[]{true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, false, false};
      field2826 = new int[99];
      int var0 = 0;

      for(int var1 = 0; var1 < 99; ++var1) {
         int var2 = var1 + 1;
         int var3 = (int)((double)var2 + 300.0D * Math.pow(2.0D, (double)var2 / 7.0D));
         var0 += var3;
         field2826[var1] = var0 / 4;
      }

   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(B)[Lhq;",
      garbageValue = "-48"
   )
   public static class232[] method4145() {
      return new class232[]{class232.field3186, class232.field3188, class232.field3187, class232.field3191, class232.field3190, class232.field3189};
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-171984717"
   )
   public static void method4146() {
      class251.field3387.reset();
   }

   @ObfuscatedName("ho")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "2027559128"
   )
   static final void method4147() {
      for(PendingSpawn var0 = (PendingSpawn)Client.pendingSpawns.getFront(); var0 != null; var0 = (PendingSpawn)Client.pendingSpawns.getNext()) {
         if(var0.hitpoints > 0) {
            --var0.hitpoints;
         }

         if(var0.hitpoints == 0) {
            if(var0.field1204 < 0 || class33.method347(var0.field1204, var0.field1199)) {
               Ignore.method1099(var0.level, var0.type, var0.x, var0.y, var0.field1204, var0.field1198, var0.field1199);
               var0.unlink();
            }
         } else {
            if(var0.delay > 0) {
               --var0.delay;
            }

            if(var0.delay == 0 && var0.x >= 1 && var0.y >= 1 && var0.x <= 102 && var0.y <= 102 && (var0.id < 0 || class33.method347(var0.id, var0.field1202))) {
               Ignore.method1099(var0.level, var0.type, var0.x, var0.y, var0.id, var0.orientation, var0.field1202);
               var0.delay = -1;
               if(var0.field1204 == var0.id && var0.field1204 == -1) {
                  var0.unlink();
               } else if(var0.field1204 == var0.id && var0.field1198 == var0.orientation && var0.field1199 == var0.field1202) {
                  var0.unlink();
               }
            }
         }
      }

   }
}
