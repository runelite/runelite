import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("iy")
public enum class240 implements RSEnum {
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Liy;"
   )
   field3254(1, 0),
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Liy;"
   )
   field3258(2, 1),
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Liy;"
   )
   field3256(0, 2);

   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -1871345175
   )
   final int field3255;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -740030383
   )
   public final int field3257;

   class240(int var3, int var4) {
      this.field3257 = var3;
      this.field3255 = var4;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "834678576"
   )
   public int rsOrdinal() {
      return this.field3255;
   }
}
