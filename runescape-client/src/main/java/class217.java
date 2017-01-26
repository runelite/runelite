import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hf")
public final class class217 {
   @ObfuscatedName("g")
   static class182 field3170;

   class217() throws Throwable {
      throw new Error();
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(II)LObjectComposition;",
      garbageValue = "1228210050"
   )
   @Export("getObjectDefinition")
   public static ObjectComposition getObjectDefinition(int var0) {
      ObjectComposition var1 = (ObjectComposition)ObjectComposition.field2928.get((long)var0);
      if(null != var1) {
         return var1;
      } else {
         byte[] var2 = ObjectComposition.field2889.getConfigData(6, var0);
         var1 = new ObjectComposition();
         var1.field2896 = var0;
         if(null != var2) {
            var1.method3596(new Buffer(var2));
         }

         var1.method3595();
         if(var1.isSolid) {
            var1.field2906 = 0;
            var1.field2934 = false;
         }

         ObjectComposition.field2928.put(var1, (long)var0);
         return var1;
      }
   }
}
