import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ka")
public enum class307 implements Enumerated {
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Lka;"
   )
   field3882(0, 0),
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Lka;"
   )
   field3881(1, 1),
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Lka;"
   )
   field3883(2, 2),
   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "Lka;"
   )
   field3884(3, 3),
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Lka;"
   )
   field3887(4, 4);

   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 1929025661
   )
   public final int field3886;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -1512535757
   )
   final int field3885;

   class307(int var3, int var4) {
      this.field3886 = var3;
      this.field3885 = var4;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "744101166"
   )
   public int rsOrdinal() {
      return this.field3885;
   }
}
