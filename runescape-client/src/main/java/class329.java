import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ld")
public enum class329 implements Enumerated {
   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "Lld;"
   )
   field3969(0, 0),
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Lld;"
   )
   field3968(1, 1),
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Lld;"
   )
   field3970(2, 2),
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "Lld;"
   )
   field3973(3, 3),
   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "Lld;"
   )
   field3971(4, 4);

   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 1134953417
   )
   public final int field3972;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -608690853
   )
   final int field3967;

   class329(int var3, int var4) {
      this.field3972 = var3;
      this.field3967 = var4;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "64"
   )
   public int rsOrdinal() {
      return this.field3967;
   }
}
