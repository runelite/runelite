import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hx")
public enum class229 implements RSEnum {
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Lhx;"
   )
   field3129(5, 0),
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Lhx;"
   )
   field3131(7, 1),
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Lhx;"
   )
   field3130(6, 2),
   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "Lhx;"
   )
   field3126(4, 3),
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Lhx;"
   )
   field3127(3, 4),
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Lhx;"
   )
   field3132(1, 5),
   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "Lhx;"
   )
   field3125(0, 6),
   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "Lhx;"
   )
   field3124(2, 7);

   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -1863774501
   )
   public final int field3128;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -337383587
   )
   final int field3133;

   class229(int var3, int var4) {
      this.field3128 = var3;
      this.field3133 = var4;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "834678576"
   )
   public int rsOrdinal() {
      return this.field3133;
   }
}
