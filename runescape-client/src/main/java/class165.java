import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fy")
public final class class165 {
   @ObfuscatedName("a")
   static final char[] field2712 = new char[]{'_', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
   @ObfuscatedName("fl")
   @ObfuscatedGetter(
      intValue = -1838974537
   )
   @Export("cameraX")
   static int cameraX;
   @ObfuscatedName("l")
   static class13 field2714;

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(IB)LObjectComposition;",
      garbageValue = "77"
   )
   @Export("getObjectDefinition")
   public static ObjectComposition getObjectDefinition(int var0) {
      ObjectComposition var1 = (ObjectComposition)ObjectComposition.field950.get((long)var0);
      if(null != var1) {
         return var1;
      } else {
         byte[] var2 = ObjectComposition.field948.method3309(6, var0);
         var1 = new ObjectComposition();
         var1.field955 = var0;
         if(null != var2) {
            var1.method838(new Buffer(var2));
         }

         var1.method837();
         if(var1.field996) {
            var1.field965 = 0;
            var1.field966 = false;
         }

         ObjectComposition.field950.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "19"
   )
   static void method3239() {
      Object var0 = class173.field2772;
      synchronized(class173.field2772) {
         if(class173.field2777 == 0) {
            class126.field2103.method2934(new class173(), 5);
         }

         class173.field2777 = 600;
      }
   }
}
