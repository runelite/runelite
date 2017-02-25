import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ay")
@Implements("Script")
public class Script extends CacheableNode {
   @ObfuscatedName("d")
   @Export("instructions")
   int[] instructions;
   @ObfuscatedName("h")
   @Export("intOperands")
   int[] intOperands;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 1977718259
   )
   @Export("localStringCount")
   int localStringCount;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 22353007
   )
   @Export("stringStackCount")
   int stringStackCount;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -1721726273
   )
   @Export("localIntCount")
   int localIntCount;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 369322755
   )
   @Export("intStackCount")
   int intStackCount;
   @ObfuscatedName("p")
   @Export("stringOperands")
   String[] stringOperands;
   @ObfuscatedName("do")
   @Export("region")
   static Region region;
   @ObfuscatedName("q")
   static NodeCache field970 = new NodeCache(128);

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(II)Lclass196;",
      garbageValue = "-1792566079"
   )
   public static class196 method970(int var0) {
      class196 var1 = (class196)class196.field2870.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = class196.field2890.getConfigData(32, var0);
         var1 = new class196();
         if(null != var2) {
            var1.method3574(new Buffer(var2));
         }

         class196.field2870.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-2139167721"
   )
   public static void method971() {
      ItemComposition.itemSpriteCache.reset();
   }
}
