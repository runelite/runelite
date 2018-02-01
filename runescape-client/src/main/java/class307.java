import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("kn")
public enum class307 implements MouseWheel {
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Lkn;"
   )
   field3869(0, 0),
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Lkn;"
   )
   field3863(1, 1),
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Lkn;"
   )
   field3866(2, 2),
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Lkn;"
   )
   field3865(3, 3),
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "Lkn;"
   )
   field3864(4, 4);

   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -124314171
   )
   public final int field3867;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -1490171267
   )
   final int field3868;

   class307(int var3, int var4) {
      this.field3867 = var3;
      this.field3868 = var4;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "8"
   )
   public int rsOrdinal() {
      return this.field3868;
   }
}
