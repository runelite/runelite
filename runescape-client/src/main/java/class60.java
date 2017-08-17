import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bj")
public final class class60 {
   @ObfuscatedName("gq")
   @ObfuscatedSignature(
      signature = "[Lkp;"
   )
   @Export("mapDots")
   static SpritePixels[] mapDots;
   @ObfuscatedName("gu")
   @ObfuscatedSignature(
      signature = "[Ljr;"
   )
   static IndexedSprite[] field753;

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(IB)Liu;",
      garbageValue = "-47"
   )
   public static FloorUnderlayDefinition method1071(int var0) {
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
