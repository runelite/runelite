import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ei")
public enum class146 implements Enumerated {
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Lei;"
   )
   field1930(1, 0),
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Lei;"
   )
   field1927(0, 1),
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Lei;"
   )
   field1929(3, 2),
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "Lei;"
   )
   field1933(2, 3);

   @ObfuscatedName("gh")
   @ObfuscatedGetter(
      intValue = 1002050991
   )
   @Export("cameraPitch")
   static int cameraPitch;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 2143082587
   )
   public final int field1928;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 1657474327
   )
   final int field1931;

   class146(int var3, int var4) {
      this.field1928 = var3;
      this.field1931 = var4;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "60"
   )
   public int rsOrdinal() {
      return this.field1931;
   }
}
