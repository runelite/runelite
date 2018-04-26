import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ii")
public enum class254 implements Enumerated {
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Lii;"
   )
   field3321(6, 0),
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Lii;"
   )
   field3315(2, 1),
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "Lii;"
   )
   field3317(3, 2),
   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "Lii;"
   )
   field3322(4, 3),
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Lii;"
   )
   field3320(1, 4),
   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "Lii;"
   )
   field3319(7, 5),
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Lii;"
   )
   field3316(5, 6),
   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "Lii;"
   )
   field3318(0, 7);

   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -1863002157
   )
   public final int field3314;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -1956031171
   )
   final int field3323;

   class254(int var3, int var4) {
      this.field3314 = var3;
      this.field3323 = var4;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(S)I",
      garbageValue = "19795"
   )
   public int rsOrdinal() {
      return this.field3323;
   }
}
