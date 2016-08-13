import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cb")
@Implements("WallObject")
public final class WallObject {
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -1881120133
   )
   @Export("x")
   int x;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -365703295
   )
   @Export("y")
   int y;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -910668779
   )
   int field1605;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -1782156323
   )
   int field1606;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -373816833
   )
   @Export("floor")
   int floor;
   @ObfuscatedName("k")
   @Export("renderable2")
   public Renderable renderable2;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 1919113747
   )
   int field1610 = 0;
   @ObfuscatedName("ew")
   static ModIcon[] field1611;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -465064693
   )
   @Export("hash")
   public int hash = 0;
   @ObfuscatedName("s")
   @Export("renderable1")
   public Renderable renderable1;

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(IIB)I",
      garbageValue = "-4"
   )
   public static int method2159(int var0, int var1) {
      int var2;
      for(var2 = 1; var1 > 1; var1 >>= 1) {
         if((var1 & 1) != 0) {
            var2 *= var0;
         }

         var0 *= var0;
      }

      if(var1 == 1) {
         return var2 * var0;
      } else {
         return var2;
      }
   }
}
