import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("p")
final class class3 implements class0 {
   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "Lia;"
   )
   static IndexDataBase field19;
   @ObfuscatedName("qj")
   @ObfuscatedSignature(
      signature = "Lcn;"
   )
   @Export("preferences")
   static Preferences preferences;
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Ljr;"
   )
   static IndexedSprite field17;

   @ObfuscatedName("fb")
   @ObfuscatedSignature(
      signature = "(Lbz;IIB)V",
      garbageValue = "47"
   )
   static void method6(Player var0, int var1, int var2) {
      if(var0.animation == var1 && var1 != -1) {
         int var3 = PendingSpawn.getAnimation(var1).replyMode;
         if(var3 == 1) {
            var0.actionFrame = 0;
            var0.field1267 = 0;
            var0.actionAnimationDisable = var2;
            var0.field1254 = 0;
         }

         if(var3 == 2) {
            var0.field1254 = 0;
         }
      } else if(var1 == -1 || var0.animation == -1 || PendingSpawn.getAnimation(var1).forcedPriority >= PendingSpawn.getAnimation(var0.animation).forcedPriority) {
         var0.animation = var1;
         var0.actionFrame = 0;
         var0.field1267 = 0;
         var0.actionAnimationDisable = var2;
         var0.field1254 = 0;
         var0.field1277 = var0.queueSize;
      }

   }
}
