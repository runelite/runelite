import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ju")
public enum class264 implements RSEnum {
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Lju;"
   )
   field3601(0, 0),
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Lju;"
   )
   field3597(2, 1),
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Lju;"
   )
   field3599(1, 2);

   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -1947227657
   )
   public final int field3598;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -478532633
   )
   final int field3602;

   class264(int var3, int var4) {
      this.field3598 = var3;
      this.field3602 = var4;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "369425307"
   )
   public int rsOrdinal() {
      return this.field3602;
   }
}
