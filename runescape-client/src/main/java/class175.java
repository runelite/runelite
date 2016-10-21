import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fy")
public class class175 extends CacheableNode {
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -869825241
   )
   public int field2774;
   @ObfuscatedName("n")
   public byte field2775;
   @ObfuscatedName("f")
   public class171 field2776;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 1618301081
   )
   static int field2777;

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(IB)I",
      garbageValue = "-19"
   )
   public static int method3438(int var0) {
      return var0 >> 11 & 63;
   }
}
