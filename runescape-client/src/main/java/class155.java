import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ep")
public class class155 {
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      longValue = 3839298024524576325L
   )
   static long field2101;
   @ObfuscatedName("k")
   static int[] field2105;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      longValue = -6622524658346086891L
   )
   static long field2106;

   @ObfuscatedName("dr")
   @ObfuscatedSignature(
      signature = "([Ljava/lang/String;I)[Ljava/lang/String;",
      garbageValue = "2051528292"
   )
   static final String[] method3078(String[] var0) {
      String[] var1 = new String[5];

      for(int var2 = 0; var2 < 5; ++var2) {
         var1[var2] = var2 + ": ";
         if(var0 != null && var0[var2] != null) {
            var1[var2] = var1[var2] + var0[var2];
         }
      }

      return var1;
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-14"
   )
   static void method3080() {
      class10.underlayIds = null;
      class10.overlayIds = null;
      class10.overlayPaths = null;
      class10.overlayRotations = null;
      class149.field2027 = null;
      Item.field884 = null;
      class183.field2729 = null;
      class85.field1444 = null;
      class142.field1996 = null;
      class47.field928 = null;
      class10.field95 = null;
      class16.field175 = null;
   }

   class155() throws Throwable {
      throw new Error();
   }
}
