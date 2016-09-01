import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("r")
public class class1 {
   @ObfuscatedName("c")
   public static String field23;
   @ObfuscatedName("mv")
   @ObfuscatedGetter(
      intValue = -1724624689
   )
   static int field25;

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(II)LObjectComposition;",
      garbageValue = "-1038051249"
   )
   @Export("getObjectDefinition")
   public static ObjectComposition getObjectDefinition(int var0) {
      ObjectComposition var1 = (ObjectComposition)ObjectComposition.field925.get((long)var0);
      if(null != var1) {
         return var1;
      } else {
         byte[] var2 = ObjectComposition.field924.method3290(6, var0);
         var1 = new ObjectComposition();
         var1.field947 = var0;
         if(null != var2) {
            var1.method799(new Buffer(var2));
         }

         var1.method798();
         if(var1.field962) {
            var1.field940 = 0;
            var1.field973 = false;
         }

         ObjectComposition.field925.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-593513827"
   )
   static void method12() {
      class11.chatLineMap.clear();
      class11.field164.method3835();
      class11.field165.method3873();
      class11.field166 = 0;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1031360707"
   )
   public static void method13() {
      ItemComposition.itemSpriteCache.reset();
   }
}
