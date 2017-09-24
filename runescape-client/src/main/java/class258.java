import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ia")
public enum class258 implements RSEnum {
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Lia;"
   )
   field3539(1, 0),
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "Lia;"
   )
   field3540(2, 1),
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "Lia;"
   )
   field3541(0, 2);

   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 443232513
   )
   public final int field3542;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -353854513
   )
   final int field3543;

   class258(int var3, int var4) {
      this.field3542 = var3;
      this.field3543 = var4;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "959363303"
   )
   public int rsOrdinal() {
      return this.field3543;
   }
}
