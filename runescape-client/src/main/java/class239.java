import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ir")
public enum class239 implements RSEnum {
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Lir;"
   )
   field3273(1, 0),
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Lir;"
   )
   field3277(0, 1),
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Lir;"
   )
   field3274(2, 2);

   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 244975635
   )
   public final int field3275;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 1061416151
   )
   final int field3279;

   class239(int var3, int var4) {
      this.field3275 = var3;
      this.field3279 = var4;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-41"
   )
   public int rsOrdinal() {
      return this.field3279;
   }
}
