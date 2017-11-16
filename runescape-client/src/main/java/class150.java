import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("em")
public enum class150 implements class185 {
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "Lem;"
   )
   field2109(2, 0),
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Lem;"
   )
   field2105(0, 1),
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "Lem;"
   )
   field2103(3, 2),
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Lem;"
   )
   field2104(1, 3);

   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -1581743961
   )
   public final int field2107;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -1527590813
   )
   final int field2108;

   class150(int var3, int var4) {
      this.field2107 = var3;
      this.field2108 = var4;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-4"
   )
   public int rsOrdinal() {
      return this.field2108;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(Lhf;B)Z",
      garbageValue = "30"
   )
   public static boolean method2926(class226 var0) {
      return class226.field2852 == var0 || class226.field2853 == var0 || class226.field2854 == var0 || class226.field2859 == var0 || class226.field2856 == var0 || class226.field2857 == var0 || class226.field2858 == var0 || class226.field2855 == var0;
   }
}
