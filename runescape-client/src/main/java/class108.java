import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("de")
public class class108 {
   @ObfuscatedName("bm")
   static class184 field1738;

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(II)Lclass196;",
      garbageValue = "199283834"
   )
   public static class196 method2038(int var0) {
      class196 var1 = (class196)class196.field2862.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = class196.field2865.getConfigData(32, var0);
         var1 = new class196();
         if(var2 != null) {
            var1.method3546(new Buffer(var2));
         }

         class196.field2862.put(var1, (long)var0);
         return var1;
      }
   }

   class108() throws Throwable {
      throw new Error();
   }
}
