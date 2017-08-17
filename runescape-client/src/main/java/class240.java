import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("is")
public enum class240 implements RSEnum {
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "Lis;"
   )
   field3262(1, 0),
   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "Lis;"
   )
   field3258(0, 1),
   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "Lis;"
   )
   field3257(2, 2);

   @ObfuscatedName("r")
   static int[][][] field3259;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 791313073
   )
   public final int field3260;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 1338378769
   )
   final int field3261;

   class240(int var3, int var4) {
      this.field3260 = var3;
      this.field3261 = var4;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "316484705"
   )
   public int rsOrdinal() {
      return this.field3261;
   }
}
