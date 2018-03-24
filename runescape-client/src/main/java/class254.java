import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("im")
public enum class254 implements Enumerated {
   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "Lim;"
   )
   field3326(7, 0),
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Lim;"
   )
   field3320(5, 1),
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Lim;"
   )
   field3321(0, 2),
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "Lim;"
   )
   field3322(1, 3),
   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "Lim;"
   )
   field3323(3, 4),
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "Lim;"
   )
   field3319(2, 5),
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Lim;"
   )
   field3325(4, 6),
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "Lim;"
   )
   field3327(6, 7);

   @ObfuscatedName("pv")
   @ObfuscatedGetter(
      intValue = -290450649
   )
   static int field3329;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -79338951
   )
   public final int field3328;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 168139889
   )
   final int field3324;

   class254(int var3, int var4) {
      this.field3328 = var3;
      this.field3324 = var4;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "64"
   )
   public int rsOrdinal() {
      return this.field3324;
   }
}
