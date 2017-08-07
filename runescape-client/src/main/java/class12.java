import java.util.Comparator;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("l")
final class class12 implements Comparator {
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -351645387
   )
   public static int field273;
   @ObfuscatedName("fc")
   @ObfuscatedSignature(
      signature = "Lkn;"
   )
   @Export("compass")
   static SpritePixels compass;
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Lfu;"
   )
   public static Huffman field274;

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Ls;Ls;I)I",
      garbageValue = "2143761872"
   )
   int method57(class14 var1, class14 var2) {
      return var1.field293 < var2.field293?-1:(var2.field293 == var1.field293?0:1);
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   public int compare(Object var1, Object var2) {
      return this.method57((class14)var1, (class14)var2);
   }
}
