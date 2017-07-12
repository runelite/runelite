import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hs")
public class class220 {
   @ObfuscatedName("lx")
   @ObfuscatedGetter(
      intValue = -1075620353
   )
   static int field2809;

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(IB)LFloorUnderlayDefinition;",
      garbageValue = "-10"
   )
   public static FloorUnderlayDefinition method4054(int var0) {
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

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(II)Ljava/lang/String;",
      garbageValue = "1871425042"
   )
   @Export("getColTags")
   static String getColTags(int var0) {
      return "<col=" + Integer.toHexString(var0) + ">";
   }
}
