import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fc")
public enum class159 implements Enumerated {
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Lfc;"
   )
   field1982(2, 0),
   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "Lfc;"
   )
   field1980(3, 1),
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Lfc;"
   )
   field1985(1, 2),
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Lfc;"
   )
   field1983(0, 3);

   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 1975536793
   )
   public final int field1984;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 458308007
   )
   final int field1981;

   class159(int var3, int var4) {
      this.field1984 = var3;
      this.field1981 = var4;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "83"
   )
   public int rsOrdinal() {
      return this.field1981;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(CI)Z",
      garbageValue = "1176730001"
   )
   public static boolean method3394(char var0) {
      return var0 >= '0' && var0 <= '9';
   }
}
