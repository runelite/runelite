import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fb")
public class class162 {
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -1772873429
   )
   public static int field2310;
   @ObfuscatedName("i")
   public static int[][] field2311;
   @ObfuscatedName("h")
   public static int[] field2312;
   @ObfuscatedName("z")
   public static int[] field2314;
   @ObfuscatedName("j")
   public static int[][] field2318;

   static {
      field2311 = new int[128][128];
      field2318 = new int[128][128];
      field2314 = new int[4096];
      field2312 = new int[4096];
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(II)LFloorUnderlayDefinition;",
      garbageValue = "-1476361347"
   )
   public static FloorUnderlayDefinition method3053(int var0) {
      FloorUnderlayDefinition var1 = (FloorUnderlayDefinition)FloorUnderlayDefinition.field3343.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = FloorUnderlayDefinition.field3344.getConfigData(1, var0);
         var1 = new FloorUnderlayDefinition();
         if(var2 != null) {
            var1.method4373(new Buffer(var2), var0);
         }

         var1.method4380();
         FloorUnderlayDefinition.field3343.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(Lclass289;I)I",
      garbageValue = "-2036150182"
   )
   static final int method3054(class289 var0) {
      if(var0 == null) {
         return 12;
      } else {
         switch(var0.field3848) {
         case 8:
            return 20;
         default:
            return 12;
         }
      }
   }
}
