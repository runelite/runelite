import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fo")
public class class175 extends CacheableNode {
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 1436364329
   )
   public int field2782;
   @ObfuscatedName("t")
   public byte field2783;
   @ObfuscatedName("s")
   public class171 field2785;

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(CB)C",
      garbageValue = "96"
   )
   static char method3395(char var0) {
      return var0 != 181 && var0 != 402?Character.toTitleCase(var0):var0;
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "-2035427192"
   )
   public static boolean method3396(int var0) {
      return (var0 >> 28 & 1) != 0;
   }
}
