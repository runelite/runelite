import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("az")
@Implements("Script")
public class Script extends CacheableNode {
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 1905583049
   )
   @Export("localStringCount")
   int localStringCount;
   @ObfuscatedName("u")
   @Export("intOperands")
   int[] intOperands;
   @ObfuscatedName("h")
   @Export("stringOperands")
   String[] stringOperands;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -250859631
   )
   @Export("localIntCount")
   int localIntCount;
   @ObfuscatedName("i")
   @Export("instructions")
   int[] instructions;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 138802439
   )
   @Export("intStackCount")
   int intStackCount;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 273578395
   )
   @Export("stringStackCount")
   int stringStackCount;
   @ObfuscatedName("f")
   static NodeCache field968 = new NodeCache(128);

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(IIB)I",
      garbageValue = "55"
   )
   static final int method921(int var0, int var1) {
      if(var0 == -1) {
         return 12345678;
      } else {
         var1 = var1 * (var0 & 127) / 128;
         if(var1 < 2) {
            var1 = 2;
         } else if(var1 > 126) {
            var1 = 126;
         }

         return (var0 & 'ﾀ') + var1;
      }
   }
}
