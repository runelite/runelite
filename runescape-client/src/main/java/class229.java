import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("he")
public final class class229 {
   @ObfuscatedName("gi")
   @ObfuscatedGetter(
      intValue = 1661239913
   )
   @Export("cameraZ")
   static int cameraZ;

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(IB)Lix;",
      garbageValue = "-72"
   )
   public static FloorUnderlayDefinition method4165(int var0) {
      FloorUnderlayDefinition var1 = (FloorUnderlayDefinition)FloorUnderlayDefinition.underlays.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = FloorUnderlayDefinition.underlay_ref.getConfigData(1, var0);
         var1 = new FloorUnderlayDefinition();
         if(var2 != null) {
            var1.decode(new Buffer(var2), var0);
         }

         var1.post();
         FloorUnderlayDefinition.underlays.put(var1, (long)var0);
         return var1;
      }
   }
}
