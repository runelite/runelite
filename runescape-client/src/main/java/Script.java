import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cx")
@Implements("Script")
public class Script extends CacheableNode {
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "Lgp;"
   )
   static NodeCache field1436;
   @ObfuscatedName("s")
   @Export("instructions")
   int[] instructions;
   @ObfuscatedName("r")
   @Export("intOperands")
   int[] intOperands;
   @ObfuscatedName("g")
   @Export("stringOperands")
   String[] stringOperands;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 1299410407
   )
   @Export("localIntCount")
   int localIntCount;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 894056205
   )
   @Export("localStringCount")
   int localStringCount;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 1601830631
   )
   @Export("intStackCount")
   int intStackCount;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -911808973
   )
   @Export("stringStackCount")
   int stringStackCount;
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "[Lgu;"
   )
   @Export("switches")
   IterableHashTable[] switches;

   static {
      field1436 = new NodeCache(128);
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(II)[Lgu;",
      garbageValue = "-667059081"
   )
   IterableHashTable[] method1824(int var1) {
      return new IterableHashTable[var1];
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(IIS)V",
      garbageValue = "30132"
   )
   public static final void method1825(int var0, int var1) {
      class133.field1900 = var0;
      class133.field1906 = var1;
      class133.field1903 = true;
      class133.field1907 = 0;
      class133.field1908 = false;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(BI)C",
      garbageValue = "-2140729662"
   )
   public static char method1835(byte var0) {
      int var1 = var0 & 255;
      if(var1 == 0) {
         throw new IllegalArgumentException("");
      } else {
         if(var1 >= 128 && var1 < 160) {
            char var2 = class273.field3712[var1 - 128];
            if(var2 == 0) {
               var2 = '?';
            }

            var1 = var2;
         }

         return (char)var1;
      }
   }
}
