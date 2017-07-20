import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ff")
public class class169 {
   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(IS)Lit;",
      garbageValue = "32767"
   )
   @Export("getObjectDefinition")
   public static ObjectComposition getObjectDefinition(int var0) {
      ObjectComposition var1 = (ObjectComposition)ObjectComposition.objects.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = ObjectComposition.objects_ref.getConfigData(6, var0);
         var1 = new ObjectComposition();
         var1.id = var0;
         if(var2 != null) {
            var1.decode(new Buffer(var2));
         }

         var1.post();
         if(var1.isSolid) {
            var1.interactType = 0;
            var1.field3439 = false;
         }

         ObjectComposition.objects.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "72"
   )
   public static void method3060() {
      ItemComposition.items.reset();
      ItemComposition.itemModelCache.reset();
      ItemComposition.itemSpriteCache.reset();
   }
}
