import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("id")
public enum class257 implements RSEnum {
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Lid;"
   )
   field3523(2, 0),
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Lid;"
   )
   field3527(1, 1),
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "Lid;"
   )
   field3525(0, 2);

   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -1784441321
   )
   final int field3521;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 146818409
   )
   public final int field3524;
   @ObfuscatedName("ei")
   @ObfuscatedGetter(
      longValue = -634698333447422801L
   )
   static long field3528;

   class257(int var3, int var4) {
      this.field3524 = var3;
      this.field3521 = var4;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1661971028"
   )
   public int rsOrdinal() {
      return this.field3521;
   }
}
