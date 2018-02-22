import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ik")
public enum class248 implements Enumerated {
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "Lik;"
   )
   field3272(0, 0),
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Lik;"
   )
   field3270(2, 1),
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Lik;"
   )
   field3268(1, 2),
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Lik;"
   )
   field3269(7, 3),
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "Lik;"
   )
   field3266(6, 4),
   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "Lik;"
   )
   field3271(5, 5),
   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "Lik;"
   )
   field3275(4, 6),
   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "Lik;"
   )
   field3273(3, 7);

   @ObfuscatedName("d")
   public static boolean field3276;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -2139327381
   )
   public final int field3274;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 1369133177
   )
   final int field3267;

   class248(int var3, int var4) {
      this.field3274 = var3;
      this.field3267 = var4;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1578971771"
   )
   public int rsOrdinal() {
      return this.field3267;
   }
}
