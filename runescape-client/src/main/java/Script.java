import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cd")
@Implements("Script")
public class Script extends CacheableNode {
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Lgg;"
   )
   static NodeCache field1501;
   @ObfuscatedName("du")
   @ObfuscatedSignature(
      signature = "Lib;"
   )
   @Export("indexWorldMap")
   static IndexData indexWorldMap;
   @ObfuscatedName("q")
   @Export("instructions")
   int[] instructions;
   @ObfuscatedName("x")
   @Export("intOperands")
   int[] intOperands;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 1416837639
   )
   @Export("localIntCount")
   int localIntCount;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 1554979711
   )
   @Export("localStringCount")
   int localStringCount;
   @ObfuscatedName("y")
   @Export("stringOperands")
   String[] stringOperands;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -269619001
   )
   @Export("intStackCount")
   int intStackCount;
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "[Lgc;"
   )
   @Export("switches")
   IterableHashTable[] switches;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 551729665
   )
   @Export("stringStackCount")
   int stringStackCount;

   static {
      field1501 = new NodeCache(128);
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(II)[Lgc;",
      garbageValue = "-2055107344"
   )
   IterableHashTable[] method1858(int var1) {
      return new IterableHashTable[var1];
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(CI)Z",
      garbageValue = "-826754024"
   )
   public static boolean method1865(char var0) {
      if((var0 <= 0 || var0 >= 128) && (var0 < 160 || var0 > 255)) {
         if(var0 != 0) {
            char[] var1 = class266.field3645;

            for(int var2 = 0; var2 < var1.length; ++var2) {
               char var3 = var1[var2];
               if(var0 == var3) {
                  return true;
               }
            }
         }

         return false;
      } else {
         return true;
      }
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(IB)Lit;",
      garbageValue = "85"
   )
   public static class251 method1857(int var0) {
      class251 var1 = (class251)class251.field3366.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = class251.field3365.getConfigData(11, var0);
         var1 = new class251();
         if(var2 != null) {
            var1.method4402(new Buffer(var2));
         }

         var1.method4416();
         class251.field3366.put(var1, (long)var0);
         return var1;
      }
   }
}
