import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ey")
public enum class149 implements RSEnum {
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Ley;"
   )
   field2197(1, 0),
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Ley;"
   )
   field2195(3, 1),
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Ley;"
   )
   field2196(0, 2),
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Ley;"
   )
   field2194(2, 3);

   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 169656379
   )
   public final int field2198;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -422360003
   )
   final int field2199;

   class149(int var3, int var4) {
      this.field2198 = var3;
      this.field2199 = var4;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "6"
   )
   public int rsOrdinal() {
      return this.field2199;
   }
}
