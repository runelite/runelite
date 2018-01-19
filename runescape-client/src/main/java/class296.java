import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("kw")
public enum class296 implements Enumerated {
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Lkw;"
   )
   field3846(0, 0),
   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "Lkw;"
   )
   field3841(1, 1),
   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "Lkw;"
   )
   field3842(2, 2),
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "Lkw;"
   )
   field3845(3, 3),
   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "Lkw;"
   )
   field3844(4, 4);

   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 831576923
   )
   public final int field3843;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -1809452597
   )
   final int field3840;

   class296(int var3, int var4) {
      this.field3843 = var3;
      this.field3840 = var4;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "2130441585"
   )
   public int rsOrdinal() {
      return this.field3840;
   }
}
