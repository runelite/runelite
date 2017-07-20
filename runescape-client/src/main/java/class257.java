import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("il")
public enum class257 implements RSEnum {
   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "Lil;"
   )
   field3523(1, 0),
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Lil;"
   )
   field3520(2, 1),
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Lil;"
   )
   field3522(0, 2);

   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 1566624255
   )
   final int field3521;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -1979252143
   )
   public final int field3524;

   class257(int var3, int var4) {
      this.field3524 = var3;
      this.field3521 = var4;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1443879177"
   )
   public int rsOrdinal() {
      return this.field3521;
   }
}
