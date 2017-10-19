import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ij")
public enum class239 implements RSEnum {
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Lij;"
   )
   field3267(0, 0),
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Lij;"
   )
   field3268(2, 1),
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Lij;"
   )
   field3270(1, 2);

   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -1884697263
   )
   public final int field3266;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -5663731
   )
   final int field3269;

   class239(int var3, int var4) {
      this.field3266 = var3;
      this.field3269 = var4;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "6"
   )
   public int rsOrdinal() {
      return this.field3269;
   }
}
