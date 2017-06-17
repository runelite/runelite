import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("je")
public enum class283 implements RSEnum {
   @ObfuscatedName("p")
   field3767(0, 0),
   @ObfuscatedName("m")
   field3764(1, 1),
   @ObfuscatedName("e")
   field3766(2, 2),
   @ObfuscatedName("t")
   field3763(3, 3),
   @ObfuscatedName("w")
   field3765(4, 4);

   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -1340185893
   )
   public final int field3768;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -1954926833
   )
   final int field3769;

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "665522131"
   )
   public int rsOrdinal() {
      return this.field3769;
   }

   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "0"
   )
   class283(int var3, int var4) {
      this.field3768 = var3;
      this.field3769 = var4;
   }
}
